/*
 * $Id$
 */

package edu.jas.structure;


import edu.jas.structure.elem.RingElem;

/**
 * Selector interface.
 *
 * @param <C> ring element type
 * @author Heinz Kredel
 */

public interface Selector<C extends RingElem<C>> {


    /**
     * Select.
     *
     * @return true, if the element is selected, otherwise false.
     */
    boolean select(C c);

}
