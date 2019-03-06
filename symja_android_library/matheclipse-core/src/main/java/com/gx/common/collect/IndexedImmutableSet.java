/*
 * Copyright (C) 2018 The Guava Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gx.common.collect;

import com.gx.common.annotations.GwtCompatible;
import com.gx.common.annotations.GwtIncompatible;

@GwtCompatible(emulated = true)
abstract class IndexedImmutableSet<E> extends ImmutableSet<E> {
    abstract E get(int index);

    @Override
    public UnmodifiableIterator<E> iterator() {
        return asList().iterator();
    }

    @Override
    @GwtIncompatible
    int copyIntoArray(Object[] dst, int offset) {
        return asList().copyIntoArray(dst, offset);
    }

    @Override
    ImmutableList<E> createAsList() {
        return new ImmutableList<E>() {
            @Override
            public E get(int index) {
                return IndexedImmutableSet.this.get(index);
            }

            @Override
            boolean isPartialView() {
                return IndexedImmutableSet.this.isPartialView();
            }

            @Override
            public int size() {
                return IndexedImmutableSet.this.size();
            }
        };
    }
}