/*
 * $Id$
 */

package edu.jas.structure;


/**
 * Regular ring element interface. Defines idempotent operations and idempotent
 * tests.
 *
 * @param <C> regular ring element type
 * @author Heinz Kredel
 */

public interface RegularRingElem<C> extends GcdRingElem<C> {


    /* Get component. 
     * Not possible to define in interface.
     * @param i index of component.
     * @return val(i).
    public C get(int i);
     */


    /**
     * Is regular ring element full.
     *
     * @return If every component is non zero, then true is returned, else
     * false.
     */
    boolean isFull();


    /**
     * Is idempotent.
     *
     * @return If this is a idempotent element then true is returned, else
     * false.
     */
    boolean isIdempotent();


    /**
     * Idempotent.
     *
     * @return S with this*S = this.
     */
    C idempotent();


    /**
     * Regular ring element idempotent complement.
     *
     * @return 1-this.idempotent().
     */
    C idemComplement();


    /**
     * Regular ring element idempotent and.
     *
     * @param S Product.
     * @return this.idempotent() and S.idempotent().
     */
    C idempotentAnd(C S);


    /**
     * Regular ring element idempotent or.
     *
     * @param S Product.
     * @return this.idempotent() or S.idempotent().
     */
    C idempotentOr(C S);


    /**
     * Regular ring element fill with idempotent.
     *
     * @param S Product.
     * @return fill this with S.idempotent().
     */
    C fillIdempotent(C S);


    /**
     * Regular ring element fill with one.
     *
     * @return fill this with one.
     */
    C fillOne();

}
