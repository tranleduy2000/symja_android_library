/*
 * $Id$
 */

package edu.jas.structure;


/**
 * Value factory interface. Defines constructor from value.
 *
 * @param C base element type
 * @param D result element type
 * @author Heinz Kredel
 */
public interface ValueFactory<C extends RingElem<C>, D extends RingElem<D>> {


    /**
     * Create from value.
     */
    D create(C n);


    /**
     * Factory for value elements.
     */
    RingFactory<C> valueFactory();

}
