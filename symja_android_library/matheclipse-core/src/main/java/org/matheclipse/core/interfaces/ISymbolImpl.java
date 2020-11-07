package org.matheclipse.core.interfaces;

import com.duy.lambda.DoubleFunction;

import org.matheclipse.core.basic.Config;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.expression.ID;

/**
 * Created by Duy on 2/20/2018.
 */

public abstract class ISymbolImpl extends IExprImpl implements ISymbol {

    @Override
    public boolean isBooleanFormula() {
        if (isConstantAttribute() && !(isTrue() || isFalse())) {
            return false;
        }
        return true;
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
    public IExpr get() {
        return assignedValue();
    }

    /**
     * Gives <code>true</code> if the system is in server mode and cannot be modified
     *
     * @return
     */
    @Override
    public boolean isNumericFunctionAttribute() {
        return ((getAttributes() & NUMERICFUNCTION) == NUMERICFUNCTION);
    }

    @Override
    public boolean isProtected() {
        return ((getAttributes() & PROTECTED) == PROTECTED) && !Config.DISABLE_PROTECTED_ATTR;

    }

    @Override
    public boolean isSymbolID(int... ids) {
        return false;
    }

    public IExpr mapConstantDouble(DoubleFunction<IExpr> function) {
        return F.NIL;
    }

    /**
     * Evaluate this symbol for the arguments as function <code>symbol(arg1, arg2, .... ,argN)</code>.
     *
     * @param args the arguments for which this function symbol should be evaluated
     * @return
     */
    @Override
    public IExpr of(int... args) {
        IExpr[] array = new IExpr[args.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = F.ZZ(args[i]);
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
    public IExpr of(boolean... args) {
        IExpr[] array = new IExpr[args.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = args[i] ? F.True : F.False;
        }
        return of(array);
    }

    @Override
    public int ordinal() {
        return ID.UNKNOWN;
    }

    @Override
    public boolean isConstantAttribute() {
        return (getAttributes() & CONSTANT) == CONSTANT;
    }

    @Override
    public IExpr[] linear(IExpr variable) {
        if (this.equals(variable)) {
            return new IExpr[]{F.C0, F.C1};
        }
        return new IExpr[]{this, F.C0};
    }

    public IExpr[] linearPower(IExpr variable) {
        if (this.equals(variable)) {
            return new IExpr[]{F.C0, F.C1, F.C1};
        }
        return new IExpr[]{this, F.C0, F.C1};
    }
}
