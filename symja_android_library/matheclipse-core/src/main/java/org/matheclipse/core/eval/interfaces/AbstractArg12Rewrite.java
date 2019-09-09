package org.matheclipse.core.eval.interfaces;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.expression.ID;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;

public abstract class AbstractArg12Rewrite extends AbstractArg12 implements IRewrite {
    @Override
    public IExpr rewrite(IAST ast, EvalEngine engine, int functionID) {
        switch (functionID) {
            case ID.Exp:
                if (ast.isAST1()) {
                    return rewriteExp(ast.arg1(), engine);
                }
                break;
            case ID.Log:
                if (ast.isAST1()) {
                    return rewriteLog(ast.arg1(), engine);
                }
                if (ast.isAST2()) {
                    return rewriteLog(ast.arg1(), ast.arg2(), engine);
                }
                break;
        }
        return F.NIL;
    }

    @Override
    public IExpr rewriteExp(IExpr arg, EvalEngine engine) {
        return F.NIL;

    }

    @Override
    public IExpr rewriteLog(IExpr arg, EvalEngine engine) {
        return F.NIL;

    }

    @Override
    public IExpr rewriteLog(IExpr arg1, IExpr arg2, EvalEngine engine) {
        return F.NIL;
    }
}
