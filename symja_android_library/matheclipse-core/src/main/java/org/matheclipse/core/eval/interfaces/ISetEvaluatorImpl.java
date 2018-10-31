package org.matheclipse.core.eval.interfaces;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IExpr;

public abstract class ISetEvaluatorImpl implements ISetEvaluator {

    @Override
    public IExpr evaluateSet(IExpr leftHandSide, IExpr rightHandSide, EvalEngine engine) {
        return F.NIL;
    }
}
