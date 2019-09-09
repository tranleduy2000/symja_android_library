package com.duy.util;

import com.duy.lambda.Consumer;

import java.util.Iterator;

/**
 * {@link Iterator}
 *
 * @param <T>
 */
public class IteratorWrapper<T> {
    private Iterator<T> iterator;

    public IteratorWrapper(Iterator<T> iterator) {
        this.iterator = iterator;
    }

    public void forEachRemaining(Consumer<T> action) {
        DObjects.requireNonNull(action);
        while (hasNext())
            action.accept(next());
    }

    private T next() {
        return iterator.next();
    }

    private boolean hasNext() {
        return iterator.hasNext();
    }
}
