package org.matheclipse.core.eval.interfaces;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;

public interface IRewrite {
	IExpr rewrite(IAST ast, EvalEngine engine, int functionID);

	IExpr rewriteExp(IExpr arg, EvalEngine engine);

	IExpr rewriteLog(IExpr arg, EvalEngine engine);

	IExpr rewriteLog(IExpr arg1, IExpr arg2, EvalEngine engine);
}
