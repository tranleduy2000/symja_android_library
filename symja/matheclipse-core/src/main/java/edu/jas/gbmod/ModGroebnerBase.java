/*
 * $Id$
 */

package edu.jas.gbmod;


import java.util.List;

import edu.jas.poly.GenPolynomial;
import edu.jas.poly.ModuleList;
import edu.jas.structure.elem.RingElem;


/**
 * Module Groebner Bases interface. Defines Groebner bases and GB test.
 *
 * @author Heinz Kredel
 * @deprecated use respective methods from GroebnerBase
 */
@Deprecated
public interface ModGroebnerBase<C extends RingElem<C>> {


    /**
     * Module Groebner base test.
     */
    boolean isGB(int modv, List<GenPolynomial<C>> F);


    /**
     * isGB.
     *
     * @param M a module basis.
     * @return true, if M is a Groebner base, else false.
     */
    boolean isGB(ModuleList<C> M);


    /**
     * Groebner base using pairlist class.
     */
    List<GenPolynomial<C>> GB(int modv, List<GenPolynomial<C>> F);


    /**
     * GB.
     *
     * @param M a module basis.
     * @return GB(M), a Groebner base of M.
     */
    ModuleList<C> GB(ModuleList<C> M);

}
