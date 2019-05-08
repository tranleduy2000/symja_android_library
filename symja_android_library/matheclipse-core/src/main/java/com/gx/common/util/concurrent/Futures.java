/*
 * Copyright (C) 2006 The Guava Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.gx.common.util.concurrent;

import com.gx.common.annotations.Beta;
import com.gx.common.annotations.GwtCompatible;
import com.gx.common.base.Function;
import com.gx.common.util.concurrent.ImmediateFuture.ImmediateFailedFuture;
import com.gx.common.util.concurrent.ImmediateFuture.ImmediateSuccessfulFuture;
import com.gx.errorprone.annotations.CanIgnoreReturnValue;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import com.duy.concurrent.Executor;
import java.util.concurrent.Future;

import static com.gx.common.base.Preconditions.checkNotNull;
import static com.gx.common.base.Preconditions.checkState;
import static com.gx.common.util.concurrent.Uninterruptibles.getUninterruptibly;

/**
 * Static utility methods pertaining to the {#link Future} interface.
 * <p>
 * <p>Many of these methods use the {#link ListenableFuture} API; consult the Guava User Guide
 * article on <a href="https://github.com/google/guava/wiki/ListenableFutureExplained">{@code
 * ListenableFuture}</a>.
 * <p>
 * <p>The main purpose of {@code ListenableFuture} is to help you chain together a graph of
 * asynchronous operations. You can chain them together manually with calls to methods like {#link
 * Futures#transform(ListenableFuture, Function, Executor) Futures.transform}, but you will often
 * find it easier to use a framework. Frameworks automate the process, often adding features like
 * monitoring, debugging, and cancellation. Examples of frameworks include:
 * <p>
 * <ul>
 * <li><a href="http://google.github.io/dagger/producers.html">Dagger Producers</a>
 * </ul>
 * <p>
 * <p>If you do chain your operations manually, you may want to use {#link FluentFuture}.
 *
 * @author Kevin Bourrillion
 * @author Nishant Thakkar
 * @author Sven Mawson
 * @since 1.0
 */
@Beta
@GwtCompatible(emulated = true)
public final class Futures {

    // A note on memory visibility.
    // Many of the utilities in this class (transform, withFallback, withTimeout, asList, combine)
    // have two requirements that significantly complicate their design.
    // 1. Cancellation should propagate from the returned future to the input future(s).
    // 2. The returned futures shouldn't unnecessarily 'pin' their inputs after completion.
    //
    // A consequence of these requirements is that the delegate futures cannot be stored in
    // final fields.
    //
    // For simplicity the rest of this description will discuss Futures.catching since it is the
    // simplest instance, though very similar descriptions apply to many other classes in this file.
    //
    // In the constructor of AbstractCatchingFuture, the delegate future is assigned to a field
    // 'inputFuture'. That field is non-final and non-volatile. There are 2 places where the
    // 'inputFuture' field is read and where we will have to consider visibility of the write
    // operation in the constructor.
    //
    // 1. In the listener that performs the callback. In this case it is fine since inputFuture is
    //    assigned prior to calling addListener, and addListener happens-before any invocation of the
    //    listener. Notably, this means that 'volatile' is unnecessary to make 'inputFuture' visible
    //    to the listener.
    //
    // 2. In done() where we may propagate cancellation to the input. In this case it is _not_ fine.
    //    There is currently nothing that enforces that the write to inputFuture in the constructor is
    //    visible to done(). This is because there is no happens before edge between the write and a
    //    (hypothetical) unsafe read by our caller. Note: adding 'volatile' does not fix this issue,
    //    it would just add an edge such that if done() observed non-null, then it would also
    //    definitely observe all earlier writes, but we still have no guarantee that done() would see
    //    the inital write (just stronger guarantees if it does).
    //
    // See: http://cs.oswego.edu/pipermail/concurrency-interest/2015-January/013800.html
    // For a (long) discussion about this specific issue and the general futility of life.
    //
    // For the time being we are OK with the problem discussed above since it requires a caller to
    // introduce a very specific kind of data-race. And given the other operations performed by these
    // methods that involve volatile read/write operations, in practice there is no issue. Also, the
    // way in such a visibility issue would surface is most likely as a failure of cancel() to
    // propagate to the input. Cancellation propagation is fundamentally racy so this is fine.
    //
    // Future versions of the JMM may revise safe construction semantics in such a way that we can
    // safely publish these objects and we won't need this whole discussion.
    // TODO(user,lukes): consider adding volatile to all these fields since in current known JVMs
    // that should resolve the issue. This comes at the cost of adding more write barriers to the
    // implementations.

    private Futures() {
    }

    /**
     * Creates a {@code ListenableFuture} which has its value set immediately upon construction. The
     * getters just return the value. This {@code Future} can't be canceled or timed out and its
     * {@code isDone()} method always returns {@code true}.
     */
    public static <V> ListenableFuture<V> immediateFuture(@NullableDecl V value) {
        if (value == null) {
            // This cast is safe because null is assignable to V for all V (i.e. it is covariant)
            @SuppressWarnings({"unchecked", "rawtypes"})
            ListenableFuture<V> typedNull = (ListenableFuture) ImmediateSuccessfulFuture.NULL;
            return typedNull;
        }
        return new ImmediateSuccessfulFuture<V>(value);
    }

    /**
     * Returns a {@code ListenableFuture} which has an exception set immediately upon construction.
     * <p>
     * <p>The returned {@code Future} can't be cancelled, and its {@code isDone()} method always
     * returns {@code true}. Calling {@code get()} will immediately throw the provided {@code
     * Throwable} wrapped in an {@code ExecutionException}.
        */
    public static <V> ListenableFuture<V> immediateFailedFuture(Throwable throwable) {
        checkNotNull(throwable);
        return new ImmediateFailedFuture<V>(throwable);
    }

    /**
     * Returns a new {@code Future} whose result is derived from the result of the given {@code
     * Future}. If {@code input} fails, the returned {@code Future} fails with the same exception (and
     * the function is not invoked). Example usage:
     * <p>
     * <pre>{@code
     * ListenableFuture<QueryResult> queryFuture = ...;
     * ListenableFuture<List<Row>> rowsFuture =
     *     transform(queryFuture, QueryResult::getRows, executor);
     * }</pre>
     * <p>
     * <p>When selecting an executor, note that {@code directExecutor} is dangerous in some cases. See
     * the discussion in the {@link ListenableFuture#addListener ListenableFuture.addListener}
     * documentation. All its warnings about heavyweight listeners are also applicable to heavyweight
     * functions passed to this method.
     * <p>
     * <p>The returned {@code Future} attempts to keep its cancellation state in sync with that of the
     * input future. That is, if the returned {@code Future} is cancelled, it will attempt to cancel
     * the input, and if the input is cancelled, the returned {@code Future} will receive a callback
     * in which it will attempt to cancel itself.
     * <p>
     * <p>An example use of this method is to convert a serializable object returned from an RPC into
     * a POJO.
     *
     * @param input    The future to transform
     * @param function A Function to transform the results of the provided future to the results of
     *                 the returned future.
     * @param executor Executor to run the function in.
     * @return A future that holds result of the transformation.
     * @since 9.0 (in 2.0 as {@code compose})
     */
    public static <I, O> ListenableFuture<O> transform(
            ListenableFuture<I> input, Function<? super I, ? extends O> function, Executor executor) {
        return AbstractTransformFuture.create(input, function, executor);
    }

    /**
     * Returns the result of the input {@code Future}, which must have already completed.
     * <p>
     * <p>The benefits of this method are twofold. First, the name "getDone" suggests to readers that
     * the {@code Future} is already done. Second, if buggy code calls {@code getDone} on a {@code
     * Future} that is still pending, the program will throw instead of block. This can be important
     * for APIs like {#link #whenAllComplete whenAllComplete(...)}{@code .}{#link
     * FutureCombiner#call(Callable, Executor) call(...)}, where it is easy to use a new input from
     * the {@code call} implementation but forget to add it to the arguments of {@code
     * whenAllComplete}.
     * <p>
     * <p>If you are looking for a method to determine whether a given {@code Future} is done, use the
     * instance method {#link Future#isDone()}.
     *
     * @throws ExecutionException    if the {@code Future} failed with an exception
     * @throws CancellationException if the {@code Future} was cancelled
     * @throws IllegalStateException if the {@code Future} is not done
     * @since 20.0
     */
    @CanIgnoreReturnValue
    // TODO(cpovirk): Consider calling getDone() in our own code.
    public static <V> V getDone(Future<V> future) throws ExecutionException {
        /*
         * We throw IllegalStateException, since the call could succeed later. Perhaps we "should" throw
         * IllegalArgumentException, since the call could succeed with a different argument. Those
         * exceptions' docs suggest that either is acceptable. Google's Java Practices page recommends
         * IllegalArgumentException here, in part to keep its recommendation simple: Static methods
         * should throw IllegalStateException only when they use static state.
         *
         *
         * Why do we deviate here? The answer: We want for fluentFuture.getDone() to throw the same
         * exception as Futures.getDone(fluentFuture).
         */
        checkState(future.isDone(), "Future was expected to be done: %s", future);
        return getUninterruptibly(future);
    }

    /*
     * Arguably we don't need a timed getUnchecked because any operation slow enough to require a
     * timeout is heavyweight enough to throw a checked exception and therefore be inappropriate to
     * use with getUnchecked. Further, it's not clear that converting the checked TimeoutException to
     * a RuntimeException -- especially to an UncheckedExecutionException, since it wasn't thrown by
     * the computation -- makes sense, and if we don't convert it, the user still has to write a
     * try-catch block.
     *
     * If you think you would use this method, let us know. You might also also look into the
     * Fork-Join framework: http://docs.oracle.com/javase/tutorial/essential/concurrency/forkjoin.html
     */

}
