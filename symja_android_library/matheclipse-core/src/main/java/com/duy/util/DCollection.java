package com.duy.util;

import com.duy.lambda.Predicate;

import java.util.Collection;
import java.util.Iterator;

public class DCollection {
    public static <E> boolean removeIf(Collection<E> collection, Predicate<? super E> filter) {
        boolean removed = false;
        final Iterator<E> each = collection.iterator();
        while (each.hasNext()) {
            if (filter.test(each.next())) {
                each.remove();
                removed = true;
            }
        }
        return removed;
    }

}
