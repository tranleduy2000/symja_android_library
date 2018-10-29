/*
 * $Id$
 */

package edu.jas.structure.elem;


/**
 * Field element interface. Empty interface since inverse is already in
 * RingElem.
 *
 * @param <C> field element type
 * @author Heinz Kredel
 */

public interface FieldElem<C extends FieldElem<C>> extends RingElem<C> {

}
