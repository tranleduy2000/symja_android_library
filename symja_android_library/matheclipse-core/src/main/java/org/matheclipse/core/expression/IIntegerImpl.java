package org.matheclipse.core.expression;

import org.matheclipse.core.interfaces.IInteger;
import org.matheclipse.core.interfaces.IRationalImpl;

/**
 * Created by Duy on 2/20/2018.
 */

public abstract class IIntegerImpl extends IRationalImpl implements IInteger {

    /**
     * {@inheritDoc}
     */
    @Override
    public abstract IInteger abs();

    @Override
    public IInteger div(int that) {
        if (that == 1) {
            return this;
        }
        return div(F.ZZ(that));
    }

    @Override
    public IInteger mod(int that) {
        if (that == 1) {
            return F.C0;
        }
        return mod(F.ZZ(that));
    }

    /**
     * Multiply this integer with value
     *
     * @param value
     * @return
     */
    @Override
    public abstract IInteger multiply(int value);

    /**
     * Returns an <code>IInteger</code> whose value is <code>(-1) * this</code>.
     *
     * @return
     */
    @Override
    public abstract IInteger negate();

    @Override
    public abstract IInteger pow(final long exp) throws ArithmeticException;

}
