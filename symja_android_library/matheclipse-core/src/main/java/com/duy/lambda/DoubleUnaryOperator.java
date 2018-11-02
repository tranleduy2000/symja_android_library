package com.duy.lambda;


import org.matheclipse.core.eval.exception.ComplexResultException;

public interface DoubleUnaryOperator {

    /**
     * Applies this operator to the given operand.
     *
     * @param operand the operand
     * @return the operator result
     */
    double applyAsDouble(double operand) throws ComplexResultException;
}