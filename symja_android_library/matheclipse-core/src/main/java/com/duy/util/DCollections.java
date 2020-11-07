package com.duy.util;

import org.jgrapht.GraphMapping;
import org.logicng.formulas.Variable;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

import com.duy.lambda.Consumer;

public class DCollections {

    public static <E, V> Iterator<GraphMapping<V, E>> emptyIterator() {
        return new Iterator<GraphMapping<V, E>>() {

            public boolean hasNext() {
                return false;
            }

            public GraphMapping<V, E> next() {
                throw new NoSuchElementException();
            }

            public void remove() {
                throw new IllegalStateException();
            }

        };
    }

    /**
     * Returns an empty sorted set (immutable).  This set is serializable.
     *
     * <p>This example illustrates the type-safe way to obtain an empty
     * sorted set:
     * <pre> {@code
     *     SortedSet<String> s = Collections.emptySortedSet();
     * }</pre>
     *
     * @param <E> type of elements, if there were any, in the set
     * @return the empty sorted set
     * @implNote Implementations of this method need not create a separate
     * {@code SortedSet} object for each call.
     * @since 1.8
     */
    public static <E> SortedSet<E> emptySortedSet() {
        return new TreeSet<E>();
    }

}
