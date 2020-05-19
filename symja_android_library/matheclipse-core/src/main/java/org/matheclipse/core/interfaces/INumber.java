package org.matheclipse.core.interfaces;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.expression.ApcomplexNum;
import org.matheclipse.core.expression.ComplexNum;

/**
 *
 * Implemented by all number interfaces
 *
 */
public interface INumber extends IExpr {

    /**
     * Get the absolute value for a given number
     *
     * @return
     */
    @Override
    public IExpr abs();

    /**
     * Get a <code>Apcomplex</code> number wrapped into an <code>ApcomplexNum</code> object.
     *
	 * @param precision
	 *            set the precision of the resulting ApcomplexNum
     * @return this signed number represented as an ApcomplexNum
     */
    public ApcomplexNum apcomplexNumValue(long precision);

    /**
     * Returns the smallest (closest to negative infinity) <code>IInteger</code> value that is not less than
     * <code>this</code> and is equal to a mathematical integer. This method raises {@link ArithmeticException} if a
     * numeric value cannot be represented by an <code>long</code> type.
     *
     * @return the smallest (closest to negative infinity) <code>IInteger</code> value that is not less than
	 *         <code>this</code> and is equal to a mathematical integer.
     */
    public INumber ceilFraction() throws ArithmeticException;

    /**
     * Compare the absolute value of this number with <code>1</code> and return
     * <ul>
     * <li><code>1</code>, if the absolute value is greater than 1</li>
     * <li><code>0</code>, if the absolute value equals 1</li>
     * <li><code>-1</code>, if the absolute value is less than 1</li>
     * </ul>
     *
     * @return
     */
    public int compareAbsValueToOne();

    /**
     * Get the absolute value for a given number
     *
     * @return
     */
    @Override
    public IExpr complexArg();

    /**
     * Get a <code>ComplexNum</code> number bject.
     *
     * @return
     */
    public ComplexNum complexNumValue();

    /**
     * Gets the signum value of a complex number
     *
     * @return 0 for <code>this == 0</code>; +1 for <code>real(this) &gt; 0</code> or
	 *         <code>( real(this)==0 &amp;&amp; imaginary(this) &gt; 0 )</code>; -1 for <code>real(this) &lt; 0 || (
	 *         real(this) == 0 &amp;&amp; imaginary(this) &lt; 0 )
     */
    public int complexSign();

    @Override
    public INumber conjugate();

    /**
     * Get the absolute value for a given number
     *
     * @return
     * @deprecated use abs()
     */
    @Deprecated
    IExpr eabs();

    /**
     * Check if this number equals the given <code>int</code> number?
     *
`     * @param i the integer number
     * @return
     */
    public boolean equalsInt(int i);

    INumber evaluatePrecision(EvalEngine engine);

    /**
     * Returns the largest (closest to positive infinity) <code>IInteger</code> value that is not greater than
     * <code>this</code> and is equal to a mathematical integer. <br/>
     * This method raises {@link ArithmeticException} if a numeric value cannot be represented by an <code>long</code>
     * type.
     *
     * @return the largest (closest to positive infinity) <code>IInteger</code> value that is not greater than
     * <code>this</code> and is equal to a mathematical integer.
     */
    public INumber floorFraction() throws ArithmeticException;

    /**
     * Return the fractional part of this fraction
     *
     * @return
     */
    public INumber fractionalPart();

    /**
     * Return the integer (real and imaginary) part of this number
     *
     * @return
     */
    public INumber integerPart();

    /**
     * Returns the imaginary part of a complex number
     *
     * @return real part
     * @deprecated use {@link #imDoubleValue()}
     */
    double getImaginary();

    /**
     * Returns the real part of a complex number
     *
     * @return real part
     * @deprecated use {@link #reDoubleValue()}
     */
    double getReal();

    /**
     * Returns the imaginary part of a complex number
     *
     * @return real part
     */
    @Override
    public ISignedNumber im();

    /**
     * Returns the imaginary part of a complex number
     *
     * @return real part
     */
    public double imDoubleValue();

    @Override
    IExpr[] linear(IExpr variable);

    @Override
    public INumber opposite();

    /**
     * Return the rational Factor of this number. For IComplex numbers check if real and imaginary parts are equal or
     * real part or imaginary part is zero.
     *
     * @return <code>null</code> if no factor could be extracted
     */
    IRational rationalFactor();

    /**
     * Returns the real part of a complex number
     *
     * @return real part
     */
    @Override
    public ISignedNumber re();

    /**
     * Returns the real part of a complex number
     *
     * @return real part
     */
    public double reDoubleValue();

    /**
     * Returns the closest <code>IInteger</code> real and imaginary part to the argument. The result is rounded to an
     * integer by adding 1/2 and taking the floor of the result by applying round separately to the real and imaginary
     * part . <br/>
     * This method raises {@link ArithmeticException} if a numeric value cannot be represented by an <code>long</code>
     * type.
     *
     * @return the closest integer to the argument.
     */
    public IExpr round();
}
