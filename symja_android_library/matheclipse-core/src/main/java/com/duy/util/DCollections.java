package com.duy.util;

import org.jgrapht.GraphMapping;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

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


}
