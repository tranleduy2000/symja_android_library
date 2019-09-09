package com.duy.util;

import com.duy.lambda.Predicate;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class CollectionWrapper<E> extends IterableWrapper<E> {

    private Collection<E> collection;

    public CollectionWrapper(Collection<E> collection) {
        super(collection);
        this.collection = collection;
    }

    public boolean removeIf(Predicate<E> filter) {
        DObjects.requireNonNull(filter);
        boolean removed = false;
        final Iterator<E> each = iterator();
        while (each.hasNext()) {
            if (filter.test(each.next())) {
                each.remove();
                removed = true;
            }
        }
        return removed;
    }

}
