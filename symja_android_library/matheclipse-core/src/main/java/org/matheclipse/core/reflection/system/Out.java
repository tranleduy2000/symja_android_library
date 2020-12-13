package org.matheclipse.core.reflection.system;

import org.matheclipse.core.builtin.IOFunctions;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.EvalHistory;
import org.matheclipse.core.eval.interfaces.AbstractCoreFunctionEvaluator;
import org.matheclipse.core.eval.interfaces.AbstractFunctionEvaluator;
import org.matheclipse.core.eval.interfaces.IFunctionEvaluator;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.ISymbol;


/**
 * Get the specified history <code>Out</code> line from the <code>EvalEngine's</code> history list.
 * <br>
	 * <b>Note</b> that the history maybe disabled in the <code>EvalEngine</code>.
	 */
public class Out extends AbstractCoreFunctionEvaluator {

	@Override
	public IExpr evaluate(final IAST ast, EvalEngine engine) {

		if (ast.isAST0()) {
      final EvalHistory list = engine.getEvalHistory();
			if (list != null) {
        return list.getOut(-1);
		}
			return F.NIL;
		}
		final int position = ast.arg1().toIntDefault(0);
		if (position != 0) {
      final EvalHistory list = engine.getEvalHistory();
			if (list != null) {
        return list.getOut(position);
			}
		}
		return F.NIL;
	}

	public int[] expectedArgSize(IAST ast) {
    return IFunctionEvaluator.ARGS_0_1;
	}
  @Override
  public void setUp(final ISymbol newSymbol) {
    newSymbol.setAttributes(ISymbol.LISTABLE | ISymbol.NHOLDFIRST);
}
}