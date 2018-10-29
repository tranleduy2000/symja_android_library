/*
 * $Id$
 */

package edu.jas.structure;


/**
 * Selector interface.
 *
 * @param <C> ring element type
 * @author Heinz Kredel
 */

public interface Selector<C> {


    /**
     * Select.
     *
     * @return true, if the element is selected, otherwise false.
     */
    boolean select(C c);

}
