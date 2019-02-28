package org.matheclipse.core.interfaces;

import org.hipparchus.fraction.BigFraction;

/**
 * Created by Duy on 2/20/2018.
 */

public abstract class IRationalImpl extends ISignedNumberImpl implements IRational {
    /**
     * {@inheritDoc}
     */
    @Override
    public abstract IRational abs();

    @Override
    public abstract IRational negate();

    public abstract IRational add(IRational parm1);

    public abstract IRational divideBy(IRational parm1);

    @Override
    public IInteger getDenominator() {
        return denominator();
    }

    @Override
    public BigFraction getFraction() {
        return toBigFraction();
    }

    @Override
    public IInteger getNumerator() {
        return numerator();
    }

    @Override
    public IRational mod(IRational m) {
        return subtract(m.multiply(this.divideBy(m).floorFraction()));
    }

    public abstract IRational multiply(IRational parm1);

    /**
     * Returns the numerator of this fraction.
     *
     * @return denominator
     */
    public abstract IInteger numerator();

    /**
     * Returns this number raised at the specified exponent.
     *
     * @param exp the exponent.
     * @return <code>this<sup>exp</sup></code>
     * @throws ArithmeticException if {@code 0^0} is given.
     */
    public abstract IRational pow(final long exp) throws ArithmeticException;

    public abstract IRational subtract(IRational parm1);

}
