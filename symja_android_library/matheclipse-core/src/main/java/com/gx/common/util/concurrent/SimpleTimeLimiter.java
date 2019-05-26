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
import com.gx.common.annotations.GwtIncompatible;
import com.gx.errorprone.annotations.CanIgnoreReturnValue;

import com.duy.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import com.duy.concurrent.ExecutorService;
import com.duy.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static com.gx.common.base.Preconditions.checkArgument;
import static com.gx.common.base.Preconditions.checkNotNull;

/**
 * A TimeLimiter that runs method calls in the background using an {#link ExecutorService}. If the
 * time limit expires for a given method call, the thread running the call will be interrupted.
 *
 * @author Kevin Bourrillion
 * @author Jens Nyman
 * @since 1.0
 */
@Beta
@GwtIncompatible
public final class SimpleTimeLimiter implements TimeLimiter {

    private final ExecutorService executor;

    private SimpleTimeLimiter(ExecutorService executor) {
        this.executor = checkNotNull(executor);
    }

    /**
     * Creates a TimeLimiter instance using the given executor service to execute method calls.
     * <p>
     * <p><b>Warning:</b> using a bounded executor may be counterproductive! If the thread pool fills
     * up, any time callers spend waiting for a thread may count toward their time limit, and in this
     * case the call may even time out before the target method is ever invoked.
     *
     * @param executor the ExecutorService that will execute the method calls on the target objects;
     *                 for example, a {#link Executors#newCachedThreadPool()}.
     * @since 22.0
     */
    public static SimpleTimeLimiter create(ExecutorService executor) {
        return new SimpleTimeLimiter(executor);
    }

    private static void checkPositiveTimeout(long timeoutDuration) {
        checkArgument(timeoutDuration > 0, "timeout must be positive: %s", timeoutDuration);
    }

    @CanIgnoreReturnValue
    @Override
    public <T> T callWithTimeout(Callable<T> callable, long timeoutDuration, TimeUnit timeoutUnit)
            throws TimeoutException, InterruptedException, ExecutionException {
        checkNotNull(callable);
        checkNotNull(timeoutUnit);
        checkPositiveTimeout(timeoutDuration);

        Future<T> future = executor.submit(callable);

        try {
            return future.get(timeoutDuration, timeoutUnit);
        } catch (InterruptedException | TimeoutException e) {
            future.cancel(true /* mayInterruptIfRunning */);
            throw e;
        } catch (ExecutionException e) {
            wrapAndThrowExecutionExceptionOrError(e.getCause());
            throw new AssertionError();
        }
    }

    private void wrapAndThrowExecutionExceptionOrError(Throwable cause) throws ExecutionException {
        if (cause instanceof Error) {
            throw new ExecutionError((Error) cause);
        } else if (cause instanceof RuntimeException) {
            throw new UncheckedExecutionException(cause);
        } else {
            throw new ExecutionException(cause);
        }
    }

}
