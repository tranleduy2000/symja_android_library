package edu.jas.gbufd;

import java.io.Serializable;

import edu.jas.poly.ModuleList;
import edu.jas.structure.RingElem;

/**
 * Container for module resolution components.
 *
 * @param <C> coefficient type
 */
class SolvResPart<C extends RingElem<C>> implements Serializable {


    public final ModuleList<C> module;


    public final ModuleList<C> GB;


    public final ModuleList<C> syzygy;


    /**
     * SolvResPart.
     *
     * @param m a module list.
     * @param g a module list GB.
     * @param z a syzygy module list.
     */
    public SolvResPart(ModuleList<C> m, ModuleList<C> g, ModuleList<C> z) {
        module = m;
        GB = g;
        syzygy = z;
    }


    /**
     * toString.
     */
    @Override
    public String toString() {
        StringBuffer s = new StringBuffer("SolvResPart(\n");
        s.append("module = " + module);
        s.append("\n GB = " + GB);
        s.append("\n syzygy = " + syzygy);
        s.append(")");
        return s.toString();
    }
}
