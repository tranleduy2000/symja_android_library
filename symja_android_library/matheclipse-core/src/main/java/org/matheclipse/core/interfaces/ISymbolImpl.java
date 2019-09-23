package org.matheclipse.core.interfaces;

import com.duy.lambda.DoubleFunction;

import org.matheclipse.core.convert.Object2Expr;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.expression.ID;

/**
 * Created by Duy on 2/20/2018.
 */

public abstract class ISymbolImpl extends IExprImpl implements ISymbol {

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
    public IExpr get() {
        return assignedValue();
    }

    public IExpr mapConstantDouble(DoubleFunction<IExpr> function) {
        return F.NIL;
    }

    @Override
    public IExpr of(Number... args) {
        IExpr[] array = new IExpr[args.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Object2Expr.convert(args[i]);
        }
        return of(array);
    }

    @Override
    public IExpr of(Boolean... args) {
        IExpr[] array = new IExpr[args.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = args[i].booleanValue() ? F.True : F.False;
        }
        return of(array);
    }

    @Override
    public double ofN(double... args) {
        IExpr[] array = new IExpr[args.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = F.num(args[i]);
        }
        return of(array).evalDouble();
    }

    @Override
    public int ordinal() {
        return ID.UNKNOWN;
    }

    @Override
    public void set(IExpr value) {
        assign(value);
    }

    @Override
    public IExpr[] linear(IExpr variable) {
        if (this.equals(variable)) {
            return new IExpr[]{F.C0, F.C1};
        }
        return new IExpr[]{this, F.C0};
    }

    @Override
    public boolean isNumericFunctionAttribute() {
        return ((getAttributes() & NUMERICFUNCTION) == NUMERICFUNCTION);
    }

    @Override
    public boolean isProtected() {
        return ((getAttributes() & PROTECTED) == PROTECTED);

    }

    @Override
    public boolean isSymbolID(int... ids) {
        return false;
    }

    @Override
    public boolean isConstantAttribute() {
        return (getAttributes() & CONSTANT) == CONSTANT;
    }
}
