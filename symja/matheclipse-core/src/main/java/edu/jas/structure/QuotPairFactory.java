/*
 * $Id$
 */

package edu.jas.structure;


import edu.jas.structure.elem.RingElem;

/**
 * Quotient pair factory interface. Defines constructors from numerators and
 * denominators.
 *
 * @param C base element type
 * @param D result element type
 * @author Heinz Kredel
 */
public interface QuotPairFactory<C extends RingElem<C>, D extends RingElem<D>> {


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
