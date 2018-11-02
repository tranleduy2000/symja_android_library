package com.duy.lambda;


import org.matheclipse.parser.client.math.MathException;

public interface Function<T, R> {

    /**
     * Applies this function to the given argument.
     *
     * @param t the function argument
     * @return the function result
     */
    R apply(T t) throws MathException;
}