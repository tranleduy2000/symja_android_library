/*
 * $Id$
 */

package edu.jas.structure;


import edu.jas.structure.elem.RingElem;

/**
 * Field factory interface. Defines test for field and access of characteristic.
 *
 * @author Heinz Kredel
 */

public interface FieldFactory<C extends RingElem<C>> extends RingFactory<C> {

}
