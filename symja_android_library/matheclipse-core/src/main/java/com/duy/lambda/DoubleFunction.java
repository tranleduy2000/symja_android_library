package com.duy.lambda;
@FunctionalInterface
public interface DoubleFunction<R> {

    /**
     * Applies this function to the given argument.
     *
     * @param value the function argument
     * @return the function result
     */
    R apply(double value);
}
