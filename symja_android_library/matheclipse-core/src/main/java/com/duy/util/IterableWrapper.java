package com.duy.util;

import com.duy.lambda.Consumer;

import java.util.Iterator;

public class IterableWrapper<T> {

    private Iterable<T> iterable;

    public IterableWrapper(Iterable<T> iterable) {
        this.iterable = iterable;
    }

    public void forEach(Consumer<? super T> action) {
        DObjects.requireNonNull(action);
        for (T t : iterable) {
            action.accept(t);
        }
    }
    public Iterator<T> iterator() {
        return iterable.iterator();
    }
}
