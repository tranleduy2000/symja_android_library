package com.duy.lambda;


import org.matheclipse.parser.client.math.MathException;

public interface Predicate<T> {

    /**
     * Evaluates this predicate on the given argument.
     *
     * @param t the input argument
     * @return {@code true} if the input argument matches the predicate,
     * otherwise {@code false}
     */
    boolean test(T t) throws MathException;
}