/*
 * $Id$
 */

package edu.jas.structure;


/**
 * Value interface. Defines selector for value.
 *
 * @param C base element type
 * @author Heinz Kredel
 */
public interface Value<C> {


    /**
     * Value getter.
     */
    C value();


    /**
     * Test if element type is constant.
     */
    boolean isConstant();

}
