package edu.jas.gbufd;

import java.io.Serializable;

import edu.jas.poly.ModuleList;
import edu.jas.structure.RingElem;

/**
 * Container for module resolution components.
 *
 * @param <C> coefficient type
 */
class ResPart<C extends RingElem<C>> implements Serializable {


    public final ModuleList<C> module;


    public final ModuleList<C> GB;


    public final ModuleList<C> syzygy;


    /**
     * ResPart.
     *
     * @param m a module list.
     * @param g a module list GB.
     * @param z a syzygy module list.
     */
    public ResPart(ModuleList<C> m, ModuleList<C> g, ModuleList<C> z) {
        module = m;
        GB = g;
        syzygy = z;
    }


    /**
     * toString.
     */
    @Override
    public String toString() {
        StringBuffer s = new StringBuffer("ResPart(\n");
        s.append("module = " + module);
        s.append("\n GB = " + GB);
        s.append("\n syzygy = " + syzygy);
        s.append(")");
        return s.toString();
    }
}
