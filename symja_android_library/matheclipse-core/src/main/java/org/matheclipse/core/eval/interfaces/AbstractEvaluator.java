package org.matheclipse.core.eval.interfaces;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.parser.client.math.MathException;


/**
 * Abstract interface for built-in Symja functions. The <code>numericEval()</code> method delegates to the <code>evaluate()</code>
 *
 */
public abstract class AbstractEvaluator extends IFunctionEvaluatorImpl implements IFunctionEvaluator {

	/** {@inheritDoc} */
    @Override
	public IExpr numericEval(final IAST ast,  EvalEngine engine) throws MathException {
        return evaluate(ast, engine);
    }

    /**
     * Evaluate built-in rules and define Attributes for a function.
	 *
     */
    @Override
    public void setUp(final ISymbol newSymbol) {
        // do nothing
    }

	/** {@inheritDoc} */
    @Override
	abstract public IExpr evaluate(final IAST ast,   EvalEngine engine) throws MathException;

}