package com.duy.util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class DCollections {
    /**
     * Returns an unmodifiable view of the specified set.  This method allows
     * modules to provide users with "read-only" access to internal sets.
     * Query operations on the returned set "read through" to the specified
     * set, and attempts to modify the returned set, whether direct or via its
     * iterator, result in an <tt>UnsupportedOperationException</tt>.<p>
     * <p>
     * The returned set will be serializable if the specified set
     * is serializable.
     *
     * @param <T> the class of the objects in the set
     * @param s   the set for which an unmodifiable view is to be returned.
     * @return an unmodifiable view of the specified set.
     */
    public static <T> Set<T> unmodifiableSet(Set<? extends T> s) {
        return new UnmodifiableSet<>(s);
    }

    /**
     * Returns an unmodifiable view of the specified collection.  This method
     * allows modules to provide users with "read-only" access to internal
     * collections.  Query operations on the returned collection "read through"
     * to the specified collection, and attempts to modify the returned
     * collection, whether direct or via its iterator, result in an
     * <tt>UnsupportedOperationException</tt>.<p>
     * <p>
     * The returned collection does <i>not</i> pass the hashCode and equals
     * operations through to the backing collection, but relies on
     * <tt>Object</tt>'s <tt>equals</tt> and <tt>hashCode</tt> methods.  This
     * is necessary to preserve the contracts of these operations in the case
     * that the backing collection is a set or a list.<p>
     * <p>
     * The returned collection will be serializable if the specified collection
     * is serializable.
     *
     * @param <T> the class of the objects in the collection
     * @param c   the collection for which an unmodifiable view is to be
     *            returned.
     * @return an unmodifiable view of the specified collection.
     */
    public static <T> Collection<T> unmodifiableCollection(Collection<? extends T> c) {
        return new UnmodifiableCollection<>(c);
    }

    /**
     * Returns true if the specified arguments are equal, or both null.
     * <p>
     * NB: Do not replace with Object.equals until JDK-8015417 is resolved.
     */
    static boolean eq(Object o1, Object o2) {
        return o1 == null ? o2 == null : o1.equals(o2);
    }

    /**
     * Returns an unmodifiable view of the specified navigable set.  This method
     * allows modules to provide users with "read-only" access to internal
     * navigable sets.  Query operations on the returned navigable set "read
     * through" to the specified navigable set.  Attempts to modify the returned
     * navigable set, whether direct, via its iterator, or via its
     * {@code subSet}, {@code headSet}, or {@code tailSet} views, result in
     * an {@code UnsupportedOperationException}.<p>
     * <p>
     * The returned navigable set will be serializable if the specified
     * navigable set is serializable.
     *
     * @param <T> the class of the objects in the set
     * @param s   the navigable set for which an unmodifiable view is to be
     *            returned
     * @return an unmodifiable view of the specified navigable set
     * @since 1.8
     */
    public static <T> NavigableSet<T> unmodifiableNavigableSet(NavigableSet<T> s) {
        return new UnmodifiableNavigableSet<>(s);
    }

    /**
     * Returns an empty navigable set (immutable).  This set is serializable.
     * <p>
     * <p>This example illustrates the type-safe way to obtain an empty
     * navigable set:
     * <pre> {@code
     *     NavigableSet<String> s = Collections.emptyNavigableSet();
     * }</pre>
     *
     * @param <E> type of elements, if there were any, in the set
     * @return the empty navigable set
     * @implNote Implementations of this method need not
     * create a separate {@code NavigableSet} object for each call.
     * @since 1.8
     */
    @SuppressWarnings("unchecked")
    public static <E> NavigableSet<E> emptyNavigableSet() {
        return (NavigableSet<E>) UnmodifiableNavigableSet.EMPTY_NAVIGABLE_SET;
    }

    /**
     * Returns an unmodifiable view of the specified navigable map.  This method
     * allows modules to provide users with "read-only" access to internal
     * navigable maps.  Query operations on the returned navigable map "read
     * through" to the specified navigable map.  Attempts to modify the returned
     * navigable map, whether direct, via its collection views, or via its
     * {@code subMap}, {@code headMap}, or {@code tailMap} views, result in
     * an {@code UnsupportedOperationException}.<p>
     * <p>
     * The returned navigable map will be serializable if the specified
     * navigable map is serializable.
     *
     * @param <K> the class of the map keys
     * @param <V> the class of the map values
     * @param m   the navigable map for which an unmodifiable view is to be
     *            returned
     * @return an unmodifiable view of the specified navigable map
     * @since 1.8
     */
    public static <K, V> NavigableMap<K, V> unmodifiableNavigableMap(NavigableMap<K, ? extends V> m) {
        return new UnmodifiableNavigableMap<>(m);
    }

    /**
     * @serial include
     */
    static class UnmodifiableCollection<E> implements Collection<E>, Serializable {
        private static final long serialVersionUID = 1820017752578914078L;

        final Collection<? extends E> c;

        UnmodifiableCollection(Collection<? extends E> c) {
            if (c == null)
                throw new NullPointerException();
            this.c = c;
        }

        public int size() {
            return c.size();
        }

        public boolean isEmpty() {
            return c.isEmpty();
        }

        public boolean contains(Object o) {
            return c.contains(o);
        }

        public Object[] toArray() {
            return c.toArray();
        }

        public <T> T[] toArray(T[] a) {
            return c.toArray(a);
        }

        public String toString() {
            return c.toString();
        }

        public Iterator<E> iterator() {
            return new Iterator<E>() {
                private final Iterator<? extends E> i = c.iterator();

                public boolean hasNext() {
                    return i.hasNext();
                }

                public E next() {
                    return i.next();
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }

                @Override
                public void forEachRemaining(Consumer<? super E> action) {
                    // Use backing collection version
                    i.forEachRemaining(action);
                }
            };
        }

        public boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        public boolean remove(Object o) {
            throw new UnsupportedOperationException();
        }

        public boolean containsAll(Collection<?> coll) {
            return c.containsAll(coll);
        }

        public boolean addAll(Collection<? extends E> coll) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> coll) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> coll) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            throw new UnsupportedOperationException();
        }

        // Override default methods in Collection
        @Override
        public void forEach(Consumer<? super E> action) {
            c.forEach(action);
        }

        @Override
        public boolean removeIf(Predicate<? super E> filter) {
            throw new UnsupportedOperationException();
        }

        @SuppressWarnings("unchecked")
        @Override
        public Spliterator<E> spliterator() {
            return (Spliterator<E>) c.spliterator();
        }

        @SuppressWarnings("unchecked")
        @Override
        public Stream<E> stream() {
            return (Stream<E>) c.stream();
        }

        @SuppressWarnings("unchecked")
        @Override
        public Stream<E> parallelStream() {
            return (Stream<E>) c.parallelStream();
        }
    }

    /**
     * @serial include
     */
    static class UnmodifiableSet<E> extends UnmodifiableCollection<E>
            implements Set<E>, Serializable {
        private static final long serialVersionUID = -9215047833775013803L;

        UnmodifiableSet(Set<? extends E> s) {
            super(s);
        }

        public boolean equals(Object o) {
            return o == this || c.equals(o);
        }

        public int hashCode() {
            return c.hashCode();
        }
    }

    /**
     * @serial include
     */
    static class UnmodifiableSortedSet<E>
            extends UnmodifiableSet<E>
            implements SortedSet<E>, Serializable {
        private static final long serialVersionUID = -4929149591599911165L;
        private final SortedSet<E> ss;

        UnmodifiableSortedSet(SortedSet<E> s) {
            super(s);
            ss = s;
        }

        public Comparator<? super E> comparator() {
            return ss.comparator();
        }

        public SortedSet<E> subSet(E fromElement, E toElement) {
            return new UnmodifiableSortedSet<>(ss.subSet(fromElement, toElement));
        }

        public SortedSet<E> headSet(E toElement) {
            return new UnmodifiableSortedSet<>(ss.headSet(toElement));
        }

        public SortedSet<E> tailSet(E fromElement) {
            return new UnmodifiableSortedSet<>(ss.tailSet(fromElement));
        }

        public E first() {
            return ss.first();
        }

        public E last() {
            return ss.last();
        }
    }

    /**
     * Wraps a navigable set and disables all of the mutative operations.
     *
     * @param <E> type of elements
     * @serial include
     */
    static class UnmodifiableNavigableSet<E>
            extends UnmodifiableSortedSet<E>
            implements NavigableSet<E>, Serializable {

        private static final long serialVersionUID = -6027448201786391929L;
        @SuppressWarnings("rawtypes")
        private static final NavigableSet<?> EMPTY_NAVIGABLE_SET =
                new EmptyNavigableSet<>();
        /**
         * The instance we are protecting.
         */
        private final NavigableSet<E> ns;

        UnmodifiableNavigableSet(NavigableSet<E> s) {
            super(s);
            ns = s;
        }

        public E lower(E e) {
            return ns.lower(e);
        }

        public E floor(E e) {
            return ns.floor(e);
        }

        public E ceiling(E e) {
            return ns.ceiling(e);
        }

        public E higher(E e) {
            return ns.higher(e);
        }

        public E pollFirst() {
            throw new UnsupportedOperationException();
        }

        public E pollLast() {
            throw new UnsupportedOperationException();
        }

        public NavigableSet<E> descendingSet() {
            return new UnmodifiableNavigableSet<>(ns.descendingSet());
        }

        public Iterator<E> descendingIterator() {
            return descendingSet().iterator();
        }

        public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
            return new UnmodifiableNavigableSet<>(
                    ns.subSet(fromElement, fromInclusive, toElement, toInclusive));
        }

        public NavigableSet<E> headSet(E toElement, boolean inclusive) {
            return new UnmodifiableNavigableSet<>(
                    ns.headSet(toElement, inclusive));
        }

        public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
            return new UnmodifiableNavigableSet<>(
                    ns.tailSet(fromElement, inclusive));
        }

        /**
         * A singleton empty unmodifiable navigable set used for
         * {@link #emptyNavigableSet()}.
         *
         * @param <E> type of elements, if there were any, and bounds
         */
        private static class EmptyNavigableSet<E> extends UnmodifiableNavigableSet<E>
                implements Serializable {
            private static final long serialVersionUID = -6291252904449939134L;

            public EmptyNavigableSet() {
                super(new TreeSet<E>());
            }

            private Object readResolve() {
                return EMPTY_NAVIGABLE_SET;
            }
        }
    }

    /**
     * @serial include
     */
    static class UnmodifiableSortedMap<K, V>
            extends UnmodifiableMap<K, V>
            implements SortedMap<K, V>, Serializable {
        private static final long serialVersionUID = -8806743815996713206L;

        private final SortedMap<K, ? extends V> sm;

        UnmodifiableSortedMap(SortedMap<K, ? extends V> m) {
            super(m);
            sm = m;
        }

        public Comparator<? super K> comparator() {
            return sm.comparator();
        }

        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            return new UnmodifiableSortedMap<>(sm.subMap(fromKey, toKey));
        }

        public SortedMap<K, V> headMap(K toKey) {
            return new UnmodifiableSortedMap<>(sm.headMap(toKey));
        }

        public SortedMap<K, V> tailMap(K fromKey) {
            return new UnmodifiableSortedMap<>(sm.tailMap(fromKey));
        }

        public K firstKey() {
            return sm.firstKey();
        }

        public K lastKey() {
            return sm.lastKey();
        }
    }

    /**
     * @serial include
     */
    private static class UnmodifiableMap<K, V> implements Map<K, V>, Serializable {
        private static final long serialVersionUID = -1034234728574286014L;

        private final Map<? extends K, ? extends V> m;
        private transient Set<K> keySet;
        private transient Set<Map.Entry<K, V>> entrySet;
        private transient Collection<V> values;

        UnmodifiableMap(Map<? extends K, ? extends V> m) {
            if (m == null)
                throw new NullPointerException();
            this.m = m;
        }

        public int size() {
            return m.size();
        }

        public boolean isEmpty() {
            return m.isEmpty();
        }

        public boolean containsKey(Object key) {
            return m.containsKey(key);
        }

        public boolean containsValue(Object val) {
            return m.containsValue(val);
        }

        public V get(Object key) {
            return m.get(key);
        }

        public V put(K key, V value) {
            throw new UnsupportedOperationException();
        }

        public V remove(Object key) {
            throw new UnsupportedOperationException();
        }

        public void putAll(Map<? extends K, ? extends V> m) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            throw new UnsupportedOperationException();
        }

        public Set<K> keySet() {
            if (keySet == null)
                keySet = unmodifiableSet(m.keySet());
            return keySet;
        }

        public Set<Map.Entry<K, V>> entrySet() {
            if (entrySet == null)
                entrySet = new UnmodifiableEntrySet<>(m.entrySet());
            return entrySet;
        }

        public Collection<V> values() {
            if (values == null)
                values = unmodifiableCollection(m.values());
            return values;
        }

        public boolean equals(Object o) {
            return o == this || m.equals(o);
        }

        public int hashCode() {
            return m.hashCode();
        }

        public String toString() {
            return m.toString();
        }

        // Override default methods in Map
        @Override
        @SuppressWarnings("unchecked")
        public V getOrDefault(Object k, V defaultValue) {
            // Safe cast as we don't change the value
            return ((Map<K, V>) m).getOrDefault(k, defaultValue);
        }

        @Override
        public void forEach(BiConsumer<? super K, ? super V> action) {
            m.forEach(action);
        }

        @Override
        public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
            throw new UnsupportedOperationException();
        }

        @Override
        public V putIfAbsent(K key, V value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean remove(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean replace(K key, V oldValue, V newValue) {
            throw new UnsupportedOperationException();
        }

        @Override
        public V replace(K key, V value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override
        public V computeIfPresent(K key,
                                  BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override
        public V compute(K key,
                         BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override
        public V merge(K key, V value,
                       BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        /**
         * We need this class in addition to UnmodifiableSet as
         * Map.Entries themselves permit modification of the backing Map
         * via their setValue operation.  This class is subtle: there are
         * many possible attacks that must be thwarted.
         *
         * @serial include
         */
        static class UnmodifiableEntrySet<K, V>
                extends UnmodifiableSet<Map.Entry<K, V>> {
            private static final long serialVersionUID = 7854390611657943733L;

            @SuppressWarnings({"unchecked", "rawtypes"})
            UnmodifiableEntrySet(Set<? extends Map.Entry<? extends K, ? extends V>> s) {
                // Need to cast to raw in order to work around a limitation in the type system
                super((Set) s);
            }

            static <K, V> Consumer<Entry<K, V>> entryConsumer(Consumer<? super Entry<K, V>> action) {
                return e -> action.accept(new UnmodifiableEntry<>(e));
            }

            public void forEach(Consumer<? super Entry<K, V>> action) {
                Objects.requireNonNull(action);
                c.forEach(entryConsumer(action));
            }

            @SuppressWarnings("unchecked")
            public Spliterator<Entry<K, V>> spliterator() {
                return new UnmodifiableEntrySetSpliterator<>(
                        (Spliterator<Map.Entry<K, V>>) c.spliterator());
            }

            @Override
            public Stream<Entry<K, V>> stream() {
                return StreamSupport.stream(spliterator(), false);
            }

            @Override
            public Stream<Entry<K, V>> parallelStream() {
                return StreamSupport.stream(spliterator(), true);
            }

            public Iterator<Entry<K, V>> iterator() {
                return new Iterator<Map.Entry<K, V>>() {
                    private final Iterator<? extends Map.Entry<? extends K, ? extends V>> i = c.iterator();

                    public boolean hasNext() {
                        return i.hasNext();
                    }

                    public Map.Entry<K, V> next() {
                        return new UnmodifiableEntry<>(i.next());
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                    // Android-note: This seems pretty inconsistent. Unlike other subclasses, we aren't
                    // delegating to the subclass iterator here. Seems like an oversight.
                };
            }

            @SuppressWarnings("unchecked")
            public Object[] toArray() {
                Object[] a = c.toArray();
                for (int i = 0; i < a.length; i++)
                    a[i] = new UnmodifiableEntry<>((Map.Entry<? extends K, ? extends V>) a[i]);
                return a;
            }

            @SuppressWarnings("unchecked")
            public <T> T[] toArray(T[] a) {
                // We don't pass a to c.toArray, to avoid window of
                // vulnerability wherein an unscrupulous multithreaded client
                // could get his hands on raw (unwrapped) Entries from c.
                Object[] arr = c.toArray(a.length == 0 ? a : Arrays.copyOf(a, 0));

                for (int i = 0; i < arr.length; i++)
                    arr[i] = new UnmodifiableEntry<>((Map.Entry<? extends K, ? extends V>) arr[i]);

                if (arr.length > a.length)
                    return (T[]) arr;

                System.arraycopy(arr, 0, a, 0, arr.length);
                if (a.length > arr.length)
                    a[arr.length] = null;
                return a;
            }

            /**
             * This method is overridden to protect the backing set against
             * an object with a nefarious equals function that senses
             * that the equality-candidate is Map.Entry and calls its
             * setValue method.
             */
            public boolean contains(Object o) {
                if (!(o instanceof Map.Entry))
                    return false;
                return c.contains(
                        new UnmodifiableEntry<>((Map.Entry<?, ?>) o));
            }

            /**
             * The next two methods are overridden to protect against
             * an unscrupulous List whose contains(Object o) method senses
             * when o is a Map.Entry, and calls o.setValue.
             */
            public boolean containsAll(Collection<?> coll) {
                for (Object e : coll) {
                    if (!contains(e)) // Invokes safe contains() above
                        return false;
                }
                return true;
            }

            public boolean equals(Object o) {
                if (o == this)
                    return true;

                if (!(o instanceof Set))
                    return false;
                Set<?> s = (Set<?>) o;
                if (s.size() != c.size())
                    return false;
                return containsAll(s); // Invokes safe containsAll() above
            }

            static final class UnmodifiableEntrySetSpliterator<K, V>
                    implements Spliterator<Entry<K, V>> {
                final Spliterator<Map.Entry<K, V>> s;

                UnmodifiableEntrySetSpliterator(Spliterator<Entry<K, V>> s) {
                    this.s = s;
                }

                @Override
                public boolean tryAdvance(Consumer<? super Entry<K, V>> action) {
                    Objects.requireNonNull(action);
                    return s.tryAdvance(entryConsumer(action));
                }

                @Override
                public void forEachRemaining(Consumer<? super Entry<K, V>> action) {
                    Objects.requireNonNull(action);
                    s.forEachRemaining(entryConsumer(action));
                }

                @Override
                public Spliterator<Entry<K, V>> trySplit() {
                    Spliterator<Entry<K, V>> split = s.trySplit();
                    return split == null
                            ? null
                            : new UnmodifiableEntrySetSpliterator<>(split);
                }

                @Override
                public long estimateSize() {
                    return s.estimateSize();
                }

                @Override
                public long getExactSizeIfKnown() {
                    return s.getExactSizeIfKnown();
                }

                @Override
                public int characteristics() {
                    return s.characteristics();
                }

                @Override
                public boolean hasCharacteristics(int characteristics) {
                    return s.hasCharacteristics(characteristics);
                }

                @Override
                public Comparator<? super Entry<K, V>> getComparator() {
                    return s.getComparator();
                }
            }

            /**
             * This "wrapper class" serves two purposes: it prevents
             * the client from modifying the backing Map, by short-circuiting
             * the setValue method, and it protects the backing Map against
             * an ill-behaved Map.Entry that attempts to modify another
             * Map Entry when asked to perform an equality check.
             */
            private static class UnmodifiableEntry<K, V> implements Map.Entry<K, V> {
                private Map.Entry<? extends K, ? extends V> e;

                UnmodifiableEntry(Map.Entry<? extends K, ? extends V> e) {
                    this.e = Objects.requireNonNull(e);
                }

                public K getKey() {
                    return e.getKey();
                }

                public V getValue() {
                    return e.getValue();
                }

                public V setValue(V value) {
                    throw new UnsupportedOperationException();
                }

                public int hashCode() {
                    return e.hashCode();
                }

                public boolean equals(Object o) {
                    if (this == o)
                        return true;
                    if (!(o instanceof Map.Entry))
                        return false;
                    Map.Entry<?, ?> t = (Map.Entry<?, ?>) o;
                    return eq(e.getKey(), t.getKey()) &&
                            eq(e.getValue(), t.getValue());
                }

                public String toString() {
                    return e.toString();
                }
            }
        }
    }

    /**
     * @serial include
     */
    static class UnmodifiableNavigableMap<K, V>
            extends UnmodifiableSortedMap<K, V>
            implements NavigableMap<K, V>, Serializable {
        private static final long serialVersionUID = -4858195264774772197L;
        /**
         * Singleton for {@link emptyNavigableMap()} which is also immutable.
         */
        private static final EmptyNavigableMap<?, ?> EMPTY_NAVIGABLE_MAP =
                new EmptyNavigableMap<>();
        /**
         * The instance we wrap and protect.
         */
        private final NavigableMap<K, ? extends V> nm;

        UnmodifiableNavigableMap(NavigableMap<K, ? extends V> m) {
            super(m);
            nm = m;
        }

        public K lowerKey(K key) {
            return nm.lowerKey(key);
        }

        public K floorKey(K key) {
            return nm.floorKey(key);
        }

        public K ceilingKey(K key) {
            return nm.ceilingKey(key);
        }

        public K higherKey(K key) {
            return nm.higherKey(key);
        }

        @SuppressWarnings("unchecked")
        public Map.Entry<K, V> lowerEntry(K key) {
            Map.Entry<K, V> lower = (Map.Entry<K, V>) nm.lowerEntry(key);
            return (null != lower)
                    ? new UnmodifiableEntrySet.UnmodifiableEntry<>(lower)
                    : null;
        }

        @SuppressWarnings("unchecked")
        public Map.Entry<K, V> floorEntry(K key) {
            Map.Entry<K, V> floor = (Map.Entry<K, V>) nm.floorEntry(key);
            return (null != floor)
                    ? new UnmodifiableEntrySet.UnmodifiableEntry<>(floor)
                    : null;
        }

        @SuppressWarnings("unchecked")
        public Map.Entry<K, V> ceilingEntry(K key) {
            Map.Entry<K, V> ceiling = (Map.Entry<K, V>) nm.ceilingEntry(key);
            return (null != ceiling)
                    ? new UnmodifiableEntrySet.UnmodifiableEntry<>(ceiling)
                    : null;
        }

        @SuppressWarnings("unchecked")
        public Map.Entry<K, V> higherEntry(K key) {
            Map.Entry<K, V> higher = (Map.Entry<K, V>) nm.higherEntry(key);
            return (null != higher)
                    ? new UnmodifiableEntrySet.UnmodifiableEntry<>(higher)
                    : null;
        }

        @SuppressWarnings("unchecked")
        public Map.Entry<K, V> firstEntry() {
            Map.Entry<K, V> first = (Map.Entry<K, V>) nm.firstEntry();
            return (null != first)
                    ? new UnmodifiableEntrySet.UnmodifiableEntry<>(first)
                    : null;
        }

        @SuppressWarnings("unchecked")
        public Map.Entry<K, V> lastEntry() {
            Map.Entry<K, V> last = (Map.Entry<K, V>) nm.lastEntry();
            return (null != last)
                    ? new UnmodifiableEntrySet.UnmodifiableEntry<>(last)
                    : null;
        }

        public Map.Entry<K, V> pollFirstEntry() {
            throw new UnsupportedOperationException();
        }

        public Map.Entry<K, V> pollLastEntry() {
            throw new UnsupportedOperationException();
        }

        public NavigableMap<K, V> descendingMap() {
            return unmodifiableNavigableMap(nm.descendingMap());
        }

        public NavigableSet<K> navigableKeySet() {
            return unmodifiableNavigableSet(nm.navigableKeySet());
        }

        public NavigableSet<K> descendingKeySet() {
            return unmodifiableNavigableSet(nm.descendingKeySet());
        }

        public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
            return unmodifiableNavigableMap(
                    nm.subMap(fromKey, fromInclusive, toKey, toInclusive));
        }

        public NavigableMap<K, V> headMap(K toKey, boolean inclusive) {
            return unmodifiableNavigableMap(nm.headMap(toKey, inclusive));
        }

        public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {
            return unmodifiableNavigableMap(nm.tailMap(fromKey, inclusive));
        }

        /**
         * A class for the {@link EMPTY_NAVIGABLE_MAP} which needs readResolve
         * to preserve singleton property.
         *
         * @param <K> type of keys, if there were any, and of bounds
         * @param <V> type of values, if there were any
         */
        private static class EmptyNavigableMap<K, V> extends UnmodifiableNavigableMap<K, V>
                implements Serializable {

            private static final long serialVersionUID = -2239321462712562324L;

            EmptyNavigableMap() {
                super(new TreeMap<K, V>());
            }

            @Override
            public NavigableSet<K> navigableKeySet() {
                return emptyNavigableSet();
            }

            private Object readResolve() {
                return EMPTY_NAVIGABLE_MAP;
            }
        }
    }
}
