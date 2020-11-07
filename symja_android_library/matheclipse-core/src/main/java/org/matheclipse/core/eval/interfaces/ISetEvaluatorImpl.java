package org.matheclipse.core.eval.interfaces;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IBuiltInSymbol;
import org.matheclipse.core.interfaces.IExpr;

public abstract class ISetEvaluatorImpl implements ISetEvaluator {

    @Override
    public IExpr evaluateSet(IExpr leftHandSide, IExpr rightHandSide, IBuiltInSymbol builtinSymbol, EvalEngine engine) {
        return F.NIL;
    }
}
