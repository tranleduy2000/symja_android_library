package org.matheclipse.core.interfaces;

import org.matheclipse.core.expression.F;

/**
 * Created by Duy on 2/20/2018.
 */

public abstract class INumberImpl extends IExprImpl implements INumber {
    @Override
    public abstract INumber conjugate();

    /**
     * Returns the imaginary part of a complex number
     *
     * @return real part
     */
    @Override
    public abstract ISignedNumber im();

    @Override
    public abstract INumber opposite();

    @Override
    public IRational rationalFactor() {
        if (this instanceof IRational) {
            return (IRational) this;
        }
        return null;
    }

    /**
     * Returns the real part of a complex number
     *
     * @return real part
     */
    @Override
    public abstract ISignedNumber re();

    /**
     * Get the absolute value for a given number
     *
     * @return
     * @deprecated use abs()
     */
    @Deprecated
    public IExpr eabs() {
        return abs();
    }

    @Override
    public double getImaginary() {
        return imDoubleValue();
    }

    @Override
    public double getReal() {
        return reDoubleValue();
    }

    @Override
    public IExpr[] linear(IExpr variable) {
        return new IExpr[]{this, F.C0};
    }
}
