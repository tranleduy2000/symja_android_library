package com.duy.lambda;


import org.matheclipse.parser.client.math.MathException;

public interface IntFunction<R> {

    /**
     * Applies this function to the given argument.
     *
     * @param value the function argument
     * @return the function result
     */
    R apply(int value) throws MathException;
}
