package com.duy.lambda;

import org.matheclipse.parser.client.math.MathException;

public interface Consumer<T> {

    /**
     * Performs this operation on the given argument.
     *
     * @param t the input argument
     */
    void accept(T t) throws MathException;
}