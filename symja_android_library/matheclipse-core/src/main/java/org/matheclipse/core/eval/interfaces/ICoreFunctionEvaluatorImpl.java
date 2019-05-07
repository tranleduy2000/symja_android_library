package org.matheclipse.core.eval.interfaces;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;

/**
 * Created by Duy on 2/20/2018.
 */

public abstract class ICoreFunctionEvaluatorImpl extends IFunctionEvaluatorImpl implements ICoreFunctionEvaluator {

    @Override
    public IExpr numericEval(IAST ast, EvalEngine engine) {
        return evaluate(ast, engine);
    }
}
