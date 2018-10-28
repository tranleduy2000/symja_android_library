package com.duy.lambda;

@FunctionalInterface
public interface DoubleConsumer {

    /**
     * Performs this operation on the given argument.
     *
     * @param value the input argument
     */
    void accept(double value);
}