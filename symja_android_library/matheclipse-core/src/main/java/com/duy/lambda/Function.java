package com.duy.lambda;

@FunctionalInterface
public interface Function<T, R> {

    java.util.function.Function

    /**
     * Applies this function to the given argument.
     *
     * @param t the function argument
     * @return the function result
     */
    R apply(T t);
}