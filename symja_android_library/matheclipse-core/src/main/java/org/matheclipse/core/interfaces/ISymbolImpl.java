package org.matheclipse.core.interfaces;

import com.duy.lambda.DoubleFunction;

import org.matheclipse.core.expression.F;
import org.matheclipse.core.expression.ID;

/**
 * Created by Duy on 2/20/2018.
 */

public abstract class ISymbolImpl extends IExprImpl implements ISymbol {

    public IExpr mapConstantDouble(DoubleFunction<IExpr> function) {
        return F.NIL;
    }

    @Override
    public int ordinal() {
        return ID.UNKNOWN;
    }

    @Override
    public IAST f(IExpr arg1) {
        return F.unaryAST1(this, arg1);
    }

    @Override
    public IAST f(IExpr arg1, IExpr arg2) {
        return F.binaryAST2(this, arg1, arg2);
    }

    @Override
    public IAST f(IExpr arg1, IExpr arg2, IExpr arg3) {
        return F.ternaryAST3(this, arg1, arg2, arg3);
    }

    @Override
    public IExpr[] linear(IExpr variable) {
        if (this.equals(variable)) {
            return new IExpr[]{F.C0, F.C1};
        }
        return new IExpr[]{this, F.C0};
    }
}
