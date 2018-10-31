/*
 * Copyright (C) 2012 The Guava Authors
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
import com.gx.errorprone.annotations.CanIgnoreReturnValue;
import com.gx.j2objc.annotations.WeakOuter;

import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import static com.gx.common.base.Preconditions.checkNotNull;

/**
 * A skeleton {@code Multimap} implementation, not necessarily in terms of a {@code Map}.
 *
 * @author Louis Wasserman
 */
@GwtCompatible
abstract class AbstractMultimap<K, V> implements Multimap<K, V> {
    @MonotonicNonNullDecl
    private transient Collection<Entry<K, V>> entries;
    @MonotonicNonNullDecl
    private transient Set<K> keySet;
    @MonotonicNonNullDecl
    private transient Multiset<K> keys;
    @MonotonicNonNullDecl
    private transient Collection<V> values;
    @MonotonicNonNullDecl
    private transient Map<K, Collection<V>> asMap;

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsValue(@NullableDecl Object value) {
        for (Collection<V> collection : asMap().values()) {
            if (collection.contains(value)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsEntry(@NullableDecl Object key, @NullableDecl Object value) {
        Collection<V> collection = asMap().get(key);
        return collection != null && collection.contains(value);
    }

    @CanIgnoreReturnValue
    @Override
    public boolean remove(@NullableDecl Object key, @NullableDecl Object value) {
        Collection<V> collection = asMap().get(key);
        return collection != null && collection.remove(value);
    }

    @CanIgnoreReturnValue
    @Override
    public boolean put(@NullableDecl K key, @NullableDecl V value) {
        return get(key).add(value);
    }

    @CanIgnoreReturnValue
    @Override
    public boolean putAll(@NullableDecl K key, Iterable<? extends V> values) {
        checkNotNull(values);
        // make sure we only call values.iterator() once
        // and we only call get(key) if values is nonempty
        if (values instanceof Collection) {
            Collection<? extends V> valueCollection = (Collection<? extends V>) values;
            return !valueCollection.isEmpty() && get(key).addAll(valueCollection);
        } else {
            Iterator<? extends V> valueItr = values.iterator();
            return valueItr.hasNext() && Iterators.addAll(get(key), valueItr);
        }
    }

    @CanIgnoreReturnValue
    @Override
    public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
        boolean changed = false;
        for (Entry<? extends K, ? extends V> entry : multimap.entries()) {
            changed |= put(entry.getKey(), entry.getValue());
        }
        return changed;
    }

    @CanIgnoreReturnValue
    @Override
    public Collection<V> replaceValues(@NullableDecl K key, Iterable<? extends V> values) {
        checkNotNull(values);
        Collection<V> result = removeAll(key);
        putAll(key, values);
        return result;
    }

    @Override
    public Collection<Entry<K, V>> entries() {
        Collection<Entry<K, V>> result = entries;
        return (result == null) ? entries = createEntries() : result;
    }

    abstract Collection<Entry<K, V>> createEntries();

    abstract Iterator<Entry<K, V>> entryIterator();

    @Override
    public Set<K> keySet() {
        Set<K> result = keySet;
        return (result == null) ? keySet = createKeySet() : result;
    }

    abstract Set<K> createKeySet();

    @Override
    public Multiset<K> keys() {
        Multiset<K> result = keys;
        return (result == null) ? keys = createKeys() : result;
    }

    abstract Multiset<K> createKeys();

    @Override
    public Collection<V> values() {
        Collection<V> result = values;
        return (result == null) ? values = createValues() : result;
    }

    abstract Collection<V> createValues();

    Iterator<V> valueIterator() {
        return Maps.valueIterator(entries().iterator());
    }

    @Override
    public Map<K, Collection<V>> asMap() {
        Map<K, Collection<V>> result = asMap;
        return (result == null) ? asMap = createAsMap() : result;
    }

    abstract Map<K, Collection<V>> createAsMap();

    @Override
    public boolean equals(@NullableDecl Object object) {
        return Multimaps.equalsImpl(this, object);
    }

    /**
     * Returns the hash code for this multimap.
     * <p>
     * <p>The hash code of a multimap is defined as the hash code of the map view, as returned by
     * {@link Multimap#asMap}.
     *
     * @see Map#hashCode
     */
    @Override
    public int hashCode() {
        return asMap().hashCode();
    }

    /**
     * Returns a string representation of the multimap, generated by calling {@code toString} on the
     * map returned by {@link Multimap#asMap}.
     *
     * @return a string representation of the multimap
     */
    @Override
    public String toString() {
        return asMap().toString();
    }

    // Comparison and hashing

    @WeakOuter
    class Entries extends Multimaps.Entries<K, V> {
        @Override
        Multimap<K, V> multimap() {
            return AbstractMultimap.this;
        }

        @Override
        public Iterator<Entry<K, V>> iterator() {
            return entryIterator();
        }
    }

    @WeakOuter
    class EntrySet extends Entries implements Set<Entry<K, V>> {
        @Override
        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }

        @Override
        public boolean equals(@NullableDecl Object obj) {
            return Sets.equalsImpl(this, obj);
        }
    }

    @WeakOuter
    class Values extends AbstractCollection<V> {
        @Override
        public Iterator<V> iterator() {
            return valueIterator();
        }

        @Override
        public int size() {
            return AbstractMultimap.this.size();
        }

        @Override
        public boolean contains(@NullableDecl Object o) {
            return AbstractMultimap.this.containsValue(o);
        }

        @Override
        public void clear() {
            AbstractMultimap.this.clear();
        }
    }
}
