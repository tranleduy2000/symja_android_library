/*
 * Copyright (C) 2008 The Guava Authors
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
import com.gx.j2objc.annotations.Weak;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import java.io.Serializable;
import java.util.Map.Entry;

/**
 * {@code values()} implementation for {@link ImmutableMap}.
 *
 * @author Jesse Wilson
 * @author Kevin Bourrillion
 */
@GwtCompatible(emulated = true)
final class ImmutableMapValues<K, V> extends ImmutableCollection<V> {
    @Weak
    private final ImmutableMap<K, V> map;

    ImmutableMapValues(ImmutableMap<K, V> map) {
        this.map = map;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public UnmodifiableIterator<V> iterator() {
        return new UnmodifiableIterator<V>() {
            final UnmodifiableIterator<Entry<K, V>> entryItr = map.entrySet().iterator();

            @Override
            public boolean hasNext() {
                return entryItr.hasNext();
            }

            @Override
            public V next() {
                return entryItr.next().getValue();
            }
        };
    }

    @Override
    public boolean contains(@NullableDecl Object object) {
        return object != null && Iterators.contains(iterator(), object);
    }

    @Override
    boolean isPartialView() {
        return true;
    }

    @Override
    public ImmutableList<V> asList() {
        final ImmutableList<Entry<K, V>> entryList = map.entrySet().asList();
        return new ImmutableList<V>() {
            @Override
            public V get(int index) {
                return entryList.get(index).getValue();
            }

            @Override
            boolean isPartialView() {
                return true;
            }

            @Override
            public int size() {
                return entryList.size();
            }
        };
    }

    @GwtIncompatible // serialization
    @Override
    Object writeReplace() {
        return new SerializedForm<V>(map);
    }

    @GwtIncompatible // serialization
    private static class SerializedForm<V> implements Serializable {
        private static final long serialVersionUID = 0;
        final ImmutableMap<?, V> map;

        SerializedForm(ImmutableMap<?, V> map) {
            this.map = map;
        }

        Object readResolve() {
            return map.values();
        }
    }
}
