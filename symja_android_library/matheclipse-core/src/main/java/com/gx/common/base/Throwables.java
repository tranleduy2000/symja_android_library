/*
 * Copyright (C) 2007 The Guava Authors
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

package com.gx.common.base;

import com.gx.common.annotations.GwtCompatible;
import com.gx.common.annotations.GwtIncompatible;
import com.gx.errorprone.annotations.CanIgnoreReturnValue;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import static com.gx.common.base.Preconditions.checkNotNull;

/**
 * Static utility methods pertaining to instances of {@link Throwable}.
 * <p>
 * <p>See the Guava User Guide entry on <a
 * href="https://github.com/google/guava/wiki/ThrowablesExplained">Throwables</a>.
 *
 * @author Kevin Bourrillion
 * @author Ben Yu
 * @since 1.0
 */
@GwtCompatible(emulated = true)
public final class Throwables {

    private Throwables() {
    }

    /**
     * Throws {@code throwable} if it is an instance of {@code declaredType}. Example usage:
     * <p>
     * <pre>
     * for (Foo foo : foos) {
     *   try {
     *     foo.bar();
     *   } catch (BarException | RuntimeException | Error t) {
     *     failure = t;
     *   }
     * }
     * if (failure != null) {
     *   throwIfInstanceOf(failure, BarException.class);
     *   throwIfUnchecked(failure);
     *   throw new AssertionError(failure);
     * }
     * </pre>
     *
     * @since 20.0
     */
    @GwtIncompatible // Class.cast, Class.isInstance
    public static <X extends Throwable> void throwIfInstanceOf(
            Throwable throwable, Class<X> declaredType) throws X {
        checkNotNull(throwable);
        if (declaredType.isInstance(throwable)) {
            throw declaredType.cast(throwable);
        }
    }

    /**
     * Propagates {@code throwable} exactly as-is, if and only if it is an instance of {@code
     * declaredType}. Example usage:
     * <p>
     * <pre>
     * try {
     *   someMethodThatCouldThrowAnything();
     * } catch (IKnowWhatToDoWithThisException e) {
     *   handle(e);
     * } catch (Throwable t) {
     *   Throwables.propagateIfInstanceOf(t, IOException.class);
     *   Throwables.propagateIfInstanceOf(t, SQLException.class);
     *   throw Throwables.propagate(t);
     * }
     * </pre>
     *
     * @deprecated Use {@link #throwIfInstanceOf}, which has the same behavior but rejects {@code
     * null}.
     */
    @Deprecated
    @GwtIncompatible // throwIfInstanceOf
    public static <X extends Throwable> void propagateIfInstanceOf(
            @NullableDecl Throwable throwable, Class<X> declaredType) throws X {
        if (throwable != null) {
            throwIfInstanceOf(throwable, declaredType);
        }
    }

    /**
     * Throws {@code throwable} if it is a {@link RuntimeException} or {@link Error}. Example usage:
     * <p>
     * <pre>
     * for (Foo foo : foos) {
     *   try {
     *     foo.bar();
     *   } catch (RuntimeException | Error t) {
     *     failure = t;
     *   }
     * }
     * if (failure != null) {
     *   throwIfUnchecked(failure);
     *   throw new AssertionError(failure);
     * }
     * </pre>
     *
     * @since 20.0
     */
    public static void throwIfUnchecked(Throwable throwable) {
        checkNotNull(throwable);
        if (throwable instanceof RuntimeException) {
            throw (RuntimeException) throwable;
        }
        if (throwable instanceof Error) {
            throw (Error) throwable;
        }
    }

    /**
     * Propagates {@code throwable} exactly as-is, if and only if it is an instance of {@link
     * RuntimeException} or {@link Error}. Example usage:
     * <p>
     * <pre>
     * try {
     *   someMethodThatCouldThrowAnything();
     * } catch (IKnowWhatToDoWithThisException e) {
     *   handle(e);
     * } catch (Throwable t) {
     *   Throwables.propagateIfPossible(t);
     *   throw new RuntimeException("unexpected", t);
     * }
     * </pre>
     *
     * @deprecated Use {@link #throwIfUnchecked}, which has the same behavior but rejects {@code
     * null}.
     */
    @Deprecated
    @GwtIncompatible
    public static void propagateIfPossible(@NullableDecl Throwable throwable) {
        if (throwable != null) {
            throwIfUnchecked(throwable);
        }
    }

    /**
     * Propagates {@code throwable} exactly as-is, if and only if it is an instance of {@link
     * RuntimeException}, {@link Error}, or {@code declaredType}. Example usage:
     * <p>
     * <pre>
     * try {
     *   someMethodThatCouldThrowAnything();
     * } catch (IKnowWhatToDoWithThisException e) {
     *   handle(e);
     * } catch (Throwable t) {
     *   Throwables.propagateIfPossible(t, OtherException.class);
     *   throw new RuntimeException("unexpected", t);
     * }
     * </pre>
     *
     * @param throwable    the Throwable to possibly propagate
     * @param declaredType the single checked exception type declared by the calling method
     */
    @GwtIncompatible // propagateIfInstanceOf
    public static <X extends Throwable> void propagateIfPossible(
            @NullableDecl Throwable throwable, Class<X> declaredType) throws X {
        propagateIfInstanceOf(throwable, declaredType);
        propagateIfPossible(throwable);
    }

    /**
     * Propagates {@code throwable} exactly as-is, if and only if it is an instance of {@link
     * RuntimeException}, {@link Error}, {@code declaredType1}, or {@code declaredType2}. In the
     * unlikely case that you have three or more declared checked exception types, you can handle them
     * all by invoking these methods repeatedly. See usage example in {@link
     * #propagateIfPossible(Throwable, Class)}.
     *
     * @param throwable     the Throwable to possibly propagate
     * @param declaredType1 any checked exception type declared by the calling method
     * @param declaredType2 any other checked exception type declared by the calling method
     */
    @GwtIncompatible // propagateIfInstanceOf
    public static <X1 extends Throwable, X2 extends Throwable> void propagateIfPossible(
            @NullableDecl Throwable throwable, Class<X1> declaredType1, Class<X2> declaredType2)
            throws X1, X2 {
        checkNotNull(declaredType2);
        propagateIfInstanceOf(throwable, declaredType1);
        propagateIfPossible(throwable, declaredType2);
    }

    /**
     * Propagates {@code throwable} as-is if it is an instance of {@link RuntimeException} or {@link
     * Error}, or else as a last resort, wraps it in a {@code RuntimeException} and then propagates.
     * <p>
     * <p>This method always throws an exception. The {@code RuntimeException} return type allows
     * client code to signal to the compiler that statements after the call are unreachable. Example
     * usage:
     * <p>
     * <pre>
     * T doSomething() {
     *   try {
     *     return someMethodThatCouldThrowAnything();
     *   } catch (IKnowWhatToDoWithThisException e) {
     *     return handle(e);
     *   } catch (Throwable t) {
     *     throw Throwables.propagate(t);
     *   }
     * }
     * </pre>
     *
     * @param throwable the Throwable to propagate
     * @return nothing will ever be returned; this return type is only for your convenience, as
     * illustrated in the example above
     * @deprecated Use {@code throw e} or {@code throw new RuntimeException(e)} directly, or use a
     * combination of {@link #throwIfUnchecked} and {@code throw new RuntimeException(e)}. For
     * background on the deprecation, read <a href="https://goo.gl/Ivn2kc">Why we deprecated
     * {@code Throwables.propagate}</a>.
     */
    @CanIgnoreReturnValue
    @GwtIncompatible
    @Deprecated
    public static RuntimeException propagate(Throwable throwable) {
        throwIfUnchecked(throwable);
        throw new RuntimeException(throwable);
    }

    /**
     * Returns the innermost cause of {@code throwable}. The first throwable in a chain provides
     * context from when the error or exception was initially detected. Example usage:
     * <p>
     * <pre>
     * assertEquals("Unable to assign a customer id", Throwables.getRootCause(e).getMessage());
     * </pre>
     *
     * @throws IllegalArgumentException if there is a loop in the causal chain
     */
    public static Throwable getRootCause(Throwable throwable) {
        // Keep a second pointer that slowly walks the causal chain. If the fast pointer ever catches
        // the slower pointer, then there's a loop.
        Throwable slowPointer = throwable;
        boolean advanceSlowPointer = false;

        Throwable cause;
        while ((cause = throwable.getCause()) != null) {
            throwable = cause;

            if (throwable == slowPointer) {
                throw new IllegalArgumentException("Loop in causal chain detected.", throwable);
            }
            if (advanceSlowPointer) {
                slowPointer = slowPointer.getCause();
            }
            advanceSlowPointer = !advanceSlowPointer; // only advance every other iteration
        }
        return throwable;
    }

}
