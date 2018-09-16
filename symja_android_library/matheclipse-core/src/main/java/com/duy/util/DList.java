package com.duy.util;

import com.duy.lambda.Consumer;
import com.duy.lambda.Predicate;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class DList {
    public static <T> void forEach(List<T> list, Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : list) {
            action.accept(t);
        }
    }

    public static <E> boolean removeIf(List<E> list, Predicate<? super E> filter) {
        Objects.requireNonNull(filter);
        boolean removed = false;
        final Iterator<E> each = list.iterator();
        while (each.hasNext()) {
            if (filter.test(each.next())) {
                each.remove();
                removed = true;
            }
        }
        return removed;
    }

}
