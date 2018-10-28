/*
 * $Id$
 */

package edu.jas.structure;


/**
 * Algabra element interface.
 *
 * @param <A> algebra type
 * @param <C> scalar type
 * @author Heinz Kredel
 */
public abstract class AlgebraElemImpl<A extends AlgebraElemImpl<A, C>, C extends RingElem<C>> implements AlgebraElem<A, C> {

    @Override
    public A leftGcd(A b) {
        return gcd(b);
    }

    @Override
    public A rightGcd(A b) {
        return gcd(b);
    }
}
