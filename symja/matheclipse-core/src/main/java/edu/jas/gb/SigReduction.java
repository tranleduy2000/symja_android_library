/*
 * $Id$
 */

package edu.jas.gb;


import java.io.Serializable;
import java.util.List;

import edu.jas.poly.GenPolynomial;
import edu.jas.structure.elem.RingElem;


/**
 * Polynomial SigReduction interface. Defines S-Polynomial, normalform with
 * respect to signatures.
 *
 * @param <C> coefficient type
 * @author Heinz Kredel
 */

public interface SigReduction<C extends RingElem<C>> extends Serializable {


    /**
     * S-Polynomial.
     *
     * @param Ap polynomial.
     * @param Bp polynomial.
     * @return spol(Ap, Bp) the S-polynomial of Ap and Bp.
     */
    GenPolynomial<C> SPolynomial(SigPoly<C> Ap, SigPoly<C> Bp);


    /**
     * Is top reducible. Condition is lt(B) | lt(A) for some B in F or G.
     *
     * @param A polynomial.
     * @param F polynomial list.
     * @param G polynomial list.
     * @return true if A is top reducible with respect to P.
     */
    boolean isSigReducible(List<SigPoly<C>> F, List<SigPoly<C>> G, SigPoly<C> A);


    /**
     * Is in Normalform.
     *
     * @param A polynomial.
     * @param F polynomial list.
     * @param G polynomial list.
     * @return true if A is in normalform with respect to F and G.
     */
    boolean isSigNormalform(List<SigPoly<C>> F, List<SigPoly<C>> G, SigPoly<C> A);


    /**
     * Normalform.
     *
     * @param A polynomial.
     * @param F polynomial list.
     * @param G polynomial list.
     * @return nf(A) with respect to F and G.
     */
    SigPoly<C> sigNormalform(List<GenPolynomial<C>> F, List<SigPoly<C>> G, SigPoly<C> A);

}
