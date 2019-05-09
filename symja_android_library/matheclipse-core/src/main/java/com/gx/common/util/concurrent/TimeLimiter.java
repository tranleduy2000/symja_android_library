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

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Imposes a time limit on method calls.
 *
 * @author Kevin Bourrillion
 * @author Jens Nyman
 * @since 1.0
 */
@Beta
@GwtIncompatible
public interface TimeLimiter {

    /**
     * Invokes a specified Callable, timing out after the specified time limit. If the target method
     * call finishes before the limit is reached, the return value or a wrapped exception is
     * propagated. If, on the other hand, the time limit is reached, we attempt to abort the call to
     * the target, and throw a {#link TimeoutException} to the caller.
     *
     * @param callable        the Callable to execute
     * @param timeoutDuration with timeoutUnit, the maximum length of time to wait
     * @param timeoutUnit     with timeoutDuration, the maximum length of time to wait
     * @return the result returned by the Callable
     * @throws TimeoutException            if the time limit is reached
     * @throws InterruptedException        if the current thread was interrupted during execution
     * @throws ExecutionException          if {@code callable} throws a checked exception
     * @throws UncheckedExecutionException if {@code callable} throws a {@code RuntimeException}
     * @throws ExecutionError              if {@code callable} throws an {@code Error}
     * @since 22.0
     */
    @CanIgnoreReturnValue
    <T> T callWithTimeout(Callable<T> callable, long timeoutDuration, TimeUnit timeoutUnit)
            throws TimeoutException, InterruptedException, ExecutionException;

}
