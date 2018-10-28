package edu.jas.structure;

public class RingElemDefault {

    /**
     * Left greatest common divisor.
     * Returns commutative greatest common divisor if not overwritten.
     *
     * @param b other element.
     * @return leftGcd(this, b).
     */
    public static <C extends RingElem<C>> C leftGcd(RingElem<C> ringElem, C b) {
        return ringElem.gcd(b);
    }


    /**
     * Right greatest common divisor.
     * Returns commutative greatest common divisor if not overwritten.
     *
     * @param b other element.
     * @return rightGcd(this, b).
     */
    public static <C extends RingElem<C>> C rightGcd(RingElem<C> ringElem, C b) {
        return ringElem.gcd(b);
    }

}
