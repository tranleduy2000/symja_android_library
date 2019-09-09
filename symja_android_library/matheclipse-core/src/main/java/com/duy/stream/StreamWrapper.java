package com.duy.stream;

import com.duy.lambda.Predicate;

import java.util.Collection;

public class StreamWrapper<E> {

    private Collection<E> list;

    public StreamWrapper(Collection<E> list) {
        this.list = list;
    }

    public boolean anyMatch(Predicate<E> predicate) {
        for (E e : list) {
            if (predicate.test(e)) {
                return true;
            }
        }
        return false;
    }

    public StreamWrapper<E> stream() {
        return this;
    }
}
