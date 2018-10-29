/*
 * $Id$
 */

package edu.jas.structure;


/**
 * Binary functor interface.
 *
 * @param <C1> element type
 * @param <C2> element type
 * @param <D>  element type
 * @author Heinz Kredel
 */

public interface BinaryFunctor<C1, C2, D> {


    /**
     * Evaluate.
     *
     * @return evaluated element.
     */
    D eval(C1 c1, C2 c2);

}
