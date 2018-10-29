/*
 * $Id$
 */

package edu.jas.structure;


import edu.jas.structure.elem.RingElem;

/**
 * Star ring element interface. Defines norm and conjugation.
 *
 * @param <C> ring element type
 * @author Heinz Kredel
 */

public interface StarRingElem<C extends StarRingElem<C>> extends RingElem<C> {


    /**
     * Conjugate of this.
     *
     * @return conj(this).
     */
    C conjugate();


    /**
     * Norm of this.
     *
     * @return norm(this).
     */
    C norm();

}
