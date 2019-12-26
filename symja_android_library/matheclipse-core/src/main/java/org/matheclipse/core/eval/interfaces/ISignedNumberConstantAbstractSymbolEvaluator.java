package org.matheclipse.core.eval.interfaces;

public abstract class ISignedNumberConstantAbstractSymbolEvaluator
        extends AbstractSymbolEvaluator implements ISignedNumberConstant {
    @Override
    public boolean isNegative() {
        return false;
    }

    @Override
    public boolean isPositive() {
        return true;
    }
}
