package com.duy.util;

import com.duy.lambda.ToIntFunction;
import com.duy.lang.DInteger;

import java.io.Serializable;
import java.util.Objects;

public class Comparator {
    public static <T> java.util.Comparator<T> comparingInt(final ToIntFunction<? super T> keyExtractor) {
        DObjects.requireNonNull(keyExtractor);
        return new java.util.Comparator<T>() {
            @Override
            public int compare(T c1, T c2) {
                return DInteger.compare(keyExtractor.applyAsInt(c1), keyExtractor.applyAsInt(c2));
            }
        };
    }
}
