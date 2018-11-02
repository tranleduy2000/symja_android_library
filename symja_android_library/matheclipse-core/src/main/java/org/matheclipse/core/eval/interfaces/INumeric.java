package org.matheclipse.core.eval.interfaces;

import org.matheclipse.core.eval.exception.IllegalArgument;

public interface INumeric {
	/**
	 * Evaluate the function to a double number
	 *
	 * @return
	 *
	 * @see org.matheclipse.core.eval.DoubleStackEvaluator
	 */
	double evalReal(double[] stack, int top, int size) throws IllegalArgument;
}
