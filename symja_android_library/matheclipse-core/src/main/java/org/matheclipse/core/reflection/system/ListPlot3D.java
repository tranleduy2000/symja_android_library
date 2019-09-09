package org.matheclipse.core.reflection.system;

import org.matheclipse.core.basic.Config;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.interfaces.AbstractEvaluator;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.ISymbol;

/**
 * 
 * Plot a list of Points in 3 dimesnsions
 *
 */
public class ListPlot3D extends AbstractEvaluator {
	public ListPlot3D() {
	}

	@Override
	public IExpr evaluate(final IAST ast, EvalEngine engine) {
		if (Config.USE_MATHCELL) {
			return F.Manipulate.of(engine, ast);
		}
		return F.NIL;
	}

	@Override
	public void setUp(final ISymbol newSymbol) {
	}
}
