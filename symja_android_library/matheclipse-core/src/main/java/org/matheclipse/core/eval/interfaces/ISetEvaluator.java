package org.matheclipse.core.eval.interfaces;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IBuiltInSymbol;
import org.matheclipse.core.interfaces.IExpr;

/**
 * <p>
 * Interface for &quot;core functions&quot; which can specially evaluated like <code>Attributes, List, Part</code>
 * </p>
 * 
 */
public interface ISetEvaluator extends IFunctionEvaluator {
	
	IExpr evaluateSet(final IExpr leftHandSide, IExpr rightHandSide, IBuiltInSymbol builtinSymbol, final EvalEngine engine);
}
