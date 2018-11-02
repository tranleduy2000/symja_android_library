/*
 * $Id$
 */

package edu.jas.structure;


import org.matheclipse.parser.client.math.MathException;

/**
 * Monoid element interface. Defines the multiplicative methods.
 *
 * @param <C> element type
 * @author Heinz Kredel
 */

public interface MonoidElem<C> extends Element<C> {


    /**
     * Test if this is one.
     *
     * @return true if this is 1, else false.
     */
    boolean isONE();


    /**
     * Test if this is a unit. I.e. there exists x with this.multiply(x).isONE()
     * == true.
     *
     * @return true if this is a unit, else false.
     */
    boolean isUnit();


    /**
     * Multiply this with S.
     *
     * @param S
     * @return this * S.
     */
    C multiply(C S);


    /**
     * Divide this by S.
     *
     * @param S
     * @return this / S.
     */
    C divide(C S) throws MathException;


    /**
     * Remainder after division of this by S.
     *
     * @param S
     * @return this - (this / S) * S.
     */
    C remainder(C S);


    /**
     * Quotient and remainder by division of this by S.
     *
     * @param S
     * @return [this/S, this - (this/S)*S].
     */
    @SuppressWarnings("unchecked")
    C[] quotientRemainder(C S) throws MathException;


    /**
     * Right division.
     * Returns commutative divide if not overwritten.
     *
     * @param a element.
     * @return right, with a * right = this
     */
    C rightDivide(C a) throws MathException;


    /**
     * Left division.
     * Returns commutative divide if not overwritten.
     *
     * @param a element.
     * @return left, with left * a = this
     */
    C leftDivide(C a) throws MathException;


    /**
     * Right remainder.
     * Returns commutative remainder if not overwritten.
     *
     * @param a element.
     * @return r = this - a * (1/right), where a * right = this.
     */
    C rightRemainder(C a);


    /**
     * Left remainder.
     * Returns commutative remainder if not overwritten.
     *
     * @param a element.
     * @return r = this - (1/left) * a, where left * a = this.
     */
    C leftRemainder(C a);


    /**
     * Two-sided division.
     * Returns commutative divide if not overwritten.
     *
     * @param a element.
     * @return [left, right], with left * a * right = this
     */
    @SuppressWarnings("unchecked")
    C[] twosidedDivide(C a) throws MathException;


    /**
     * Two-sided remainder.
     * Returns commutative remainder if not overwritten.
     *
     * @param a element.
     * @return r = this - (a/left) * a * (a/right), where left * a * right = this.
     */
    C twosidedRemainder(C a);


    /**
     * Inverse of this. Some implementing classes will throw
     * NotInvertibleException if the element is not invertible.
     *
     * @return x with this * x = 1, if it exists.
     */
    C inverse(); /*throws NotInvertibleException*/


    /**
     * Power of this to the n-th.
     *
     * @param n integer exponent.
     * @return a**n, with a**0 = 1 and a**{-n} = {1/a}**n.
     * Java 8 only
     */
    @SuppressWarnings("unchecked")
    C power(long n);

}
