package com.duy.lambda;

public class SFunction {
    /**
     * Returns a function that always returns its input argument.
     *
     * @param <T> the type of the input and output objects to the function
     * @return a function that always returns its input argument
     */
    public static <T> java.util.function.Function<T, T> identity() {
        return new java.util.function.Function<T, T>() {
            @Override
            public T apply(T t) {
                return t;
            }
        };
    }
}
