/*
 * $Id$
 */

package edu.jas.structure;


import edu.jas.structure.elem.MonoidElem;

/**
 * Monoid factory interface. Defines get one and tests for associativity and
 * commutativity.
 *
 * @author Heinz Kredel
 */

public interface MonoidFactory<C extends MonoidElem<C>> extends ElemFactory<C> {


    /**
     * Get the constant one for the MonoidElem.
     *
     * @return 1.
     */
    C getONE();


    /**
     * Query if this monoid is commutative.
     *
     * @return true if this monoid is commutative, else false.
     */
    boolean isCommutative();


    /**
     * Query if this monoid is associative.
     *
     * @return true if this monoid is associative, else false.
     */
    boolean isAssociative();


}
