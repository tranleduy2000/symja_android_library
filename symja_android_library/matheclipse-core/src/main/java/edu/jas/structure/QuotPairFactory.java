/*
 * $Id$
 */

package edu.jas.structure;


/**
 * Quotient pair factory interface. Defines constructors from numerators and
 * denominators.
 *
 * @param C base element type
 * @param D result element type
 * @author Heinz Kredel
 */
public interface QuotPairFactory<C, D> {


    /**
     * Create from numerator.
     */
    D create(C n);


    /**
     * Create from numerator, denominator pair.
     */
    D create(C n, C d);


    /**
     * Factory for base elements.
     */
    RingFactory<C> pairFactory();

}
