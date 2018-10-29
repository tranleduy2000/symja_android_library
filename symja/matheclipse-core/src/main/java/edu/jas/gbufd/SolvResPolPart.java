package edu.jas.gbufd;

import java.io.Serializable;

import edu.jas.poly.ModuleList;
import edu.jas.poly.PolynomialList;
import edu.jas.structure.RingElem;

/**
 * Container for polynomial resolution components.
 *
 * @param <C> coefficient type
 */
class SolvResPolPart<C extends RingElem<C>> implements Serializable {


    public final PolynomialList<C> ideal;


    public final PolynomialList<C> GB;


    public final ModuleList<C> syzygy;


    /**
     * SolvResPolPart.
     *
     * @param m a polynomial list.
     * @param g a polynomial list GB.
     * @param z a syzygy module list.
     */
    public SolvResPolPart(PolynomialList<C> m, PolynomialList<C> g, ModuleList<C> z) {
        ideal = m;
        GB = g;
        syzygy = z;
    }


    /**
     * toString.
     */
    @Override
    public String toString() {
        StringBuffer s = new StringBuffer("SolvResPolPart(\n");
        s.append("ideal = " + ideal);
        s.append("\n GB = " + GB);
        s.append("\n syzygy = " + syzygy);
        s.append(")");
        return s.toString();
    }

}