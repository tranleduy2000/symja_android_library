/*
 * $Id$
 */

package edu.jas.structure;


import edu.jas.structure.elem.RingElem;

/**
 * Value interface. Defines selector for value.
 *
 * @param C base element type
 * @author Heinz Kredel
 */
public interface Value<C extends RingElem<C>> {


    /**
     * Value getter.
     */
    C value();


    /**
     * Test if element type is constant.
     */
    boolean isConstant();

}
