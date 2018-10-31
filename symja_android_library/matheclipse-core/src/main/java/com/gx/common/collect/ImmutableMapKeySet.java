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

/**
 * {@code keySet()} implementation for {@link ImmutableMap}.
 *
 * @author Jesse Wilson
 * @author Kevin Bourrillion
 */
@GwtCompatible(emulated = true)
final class ImmutableMapKeySet<K, V> extends IndexedImmutableSet<K> {
    @Weak
    private final ImmutableMap<K, V> map;

    ImmutableMapKeySet(ImmutableMap<K, V> map) {
        this.map = map;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public UnmodifiableIterator<K> iterator() {
        return map.keyIterator();
    }

    @Override
    public boolean contains(@NullableDecl Object object) {
        return map.containsKey(object);
    }

    @Override
    K get(int index) {
        return map.entrySet().asList().get(index).getKey();
    }

    @Override
    boolean isPartialView() {
        return true;
    }

    @GwtIncompatible // serialization
    @Override
    Object writeReplace() {
        return new KeySetSerializedForm<K>(map);
    }

    @GwtIncompatible // serialization
    private static class KeySetSerializedForm<K> implements Serializable {
        private static final long serialVersionUID = 0;
        final ImmutableMap<K, ?> map;

        KeySetSerializedForm(ImmutableMap<K, ?> map) {
            this.map = map;
        }

        Object readResolve() {
            return map.keySet();
        }
    }
}
