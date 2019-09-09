package com.duy.util;


import com.duy.lambda.Consumer;

public class SpliteratorWrapper {

    public static <T> void forEachRemaining(Spliterator<T> spliterator, Consumer<? super T> action) {
        do {
        } while (spliterator.tryAdvance(action));
    }
}
