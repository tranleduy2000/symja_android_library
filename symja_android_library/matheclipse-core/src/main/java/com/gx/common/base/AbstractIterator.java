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
import com.gx.errorprone.annotations.CanIgnoreReturnValue;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.gx.common.base.Preconditions.checkState;

/**
 * Note this class is a copy of {@link com.gx.common.collect.AbstractIterator} (for dependency
 * reasons).
 */
@GwtCompatible
abstract class AbstractIterator<T> implements Iterator<T> {
    private State state = State.NOT_READY;
    @NullableDecl
    private T next;

    protected AbstractIterator() {
    }

    protected abstract T computeNext();

    @CanIgnoreReturnValue
    @NullableDecl
    protected final T endOfData() {
        state = State.DONE;
        return null;
    }

    @Override
    public final boolean hasNext() {
        checkState(state != State.FAILED);
        switch (state) {
            case READY:
                return true;
            case DONE:
                return false;
            default:
        }
        return tryToComputeNext();
    }

    private boolean tryToComputeNext() {
        state = State.FAILED; // temporary pessimism
        next = computeNext();
        if (state != State.DONE) {
            state = State.READY;
            return true;
        }
        return false;
    }

    @Override
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        state = State.NOT_READY;
        T result = next;
        next = null;
        return result;
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED,
    }
}