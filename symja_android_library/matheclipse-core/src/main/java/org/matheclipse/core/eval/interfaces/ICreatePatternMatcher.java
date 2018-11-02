package org.matheclipse.core.eval.interfaces;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.parser.client.math.MathException;

/**
 * 
 */
public interface ICreatePatternMatcher {
	/**
	 * Returns an array of 2 objects with type IPatternMatcher (at index 0) and
	 * IExpr (at index 1).
	 * 
	 * @param leftHandSide
	 * @param rightHandSide
	 * @param packageMode TODO
	 * @return
	 */
	public Object[] createPatternMatcher(IExpr leftHandSide, IExpr rightHandSide, boolean packageMode, final EvalEngine engine) throws MathException;
}
