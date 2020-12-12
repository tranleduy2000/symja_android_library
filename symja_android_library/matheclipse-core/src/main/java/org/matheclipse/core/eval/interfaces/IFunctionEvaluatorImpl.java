package org.matheclipse.core.eval.interfaces;

import org.matheclipse.core.builtin.IOFunctions;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IEvaluatorImpl;
import org.matheclipse.core.interfaces.IExpr;

/**
 * Created by Duy on 2/20/2018.
 */

public abstract class IFunctionEvaluatorImpl extends IEvaluatorImpl implements IFunctionEvaluator {

  @Override
  public int[] expectedArgSize(IAST ast) {
    return null;
  }

  @Override
  public IExpr print(IAST ast, int expected, EvalEngine engine) {

    // `1` called with `2` arguments; `3` arguments are expected.
    return IOFunctions.printMessage(
        ast.topHead(), "argrx", F.List(ast, F.ZZ(ast.argSize()), F.ZZ(expected)), engine);

  }

}
