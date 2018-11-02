package edu.jas.structure;

import org.matheclipse.parser.client.math.MathException;

public abstract class MonoidElemImpl<C extends MonoidElem<C>> implements MonoidElem<C> {

    /**
     * Quotient and remainder by division of this by S.
     *
     * @param S
     * @return [this/S, this - (this/S)*S].
     */
    @SuppressWarnings("unchecked")
    public C[] quotientRemainder(C S) throws MathException {
        return (C[]) new MonoidElem[]{divide(S), remainder(S)};
    }


    /**
     * Right division.
     * Returns commutative divide if not overwritten.
     *
     * @param a element.
     * @return right, with a * right = this
     */
    public C rightDivide(C a) throws MathException {
        return divide(a);
    }


    /**
     * Left division.
     * Returns commutative divide if not overwritten.
     *
     * @param a element.
     * @return left, with left * a = this
     */
    public C leftDivide(C a) throws MathException {
        return divide(a);
    }


    /**
     * Right remainder.
     * Returns commutative remainder if not overwritten.
     *
     * @param a element.
     * @return r = this - a * (1/right), where a * right = this.
     */
    public C rightRemainder(C a) {
        return remainder(a);
    }


    /**
     * Left remainder.
     * Returns commutative remainder if not overwritten.
     *
     * @param a element.
     * @return r = this - (1/left) * a, where left * a = this.
     */
    public C leftRemainder(C a) {
        return remainder(a);
    }

    /**
     * Two-sided division.
     * Returns commutative divide if not overwritten.
     *
     * @param a element.
     * @return [left, right], with left * a * right = this
     */
    @SuppressWarnings("unchecked")
    public C[] twosidedDivide(C a) throws MathException {
        C[] ret = (C[]) new MonoidElem[2];
        ret[0] = divide(a);
        ret[1] = ((MonoidFactory<C>) factory()).getONE();
        return ret;
    }

    /**
     * Two-sided remainder.
     * Returns commutative remainder if not overwritten.
     *
     * @param a element.
     * @return r = this - (a/left) * a * (a/right), where left * a * right = this.
     */
    public C twosidedRemainder(C a) {
        return remainder(a);
    }

    /**
     * Power of this to the n-th.
     *
     * @param n integer exponent.
     * @return a**n, with a**0 = 1 and a**{-n} = {1/a}**n.
     * Java 8 only
     */
    @SuppressWarnings("unchecked")
    public C power(long n) throws MathException {
        //System.out.println("this = " + this + ", n = " + n);
        return Power.power((MonoidFactory<C>) factory(), (C) this, n);
    }

}
