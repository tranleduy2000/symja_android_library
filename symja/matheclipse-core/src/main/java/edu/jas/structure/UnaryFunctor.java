/*
 * $Id$
 */

package edu.jas.structure;


/**
 * Unary functor interface.
 *
 * @param <C> element type
 * @param <D> element type
 * @author Heinz Kredel
 */

public interface UnaryFunctor<C, D> {


    /**
     * Evaluate.
     *
     * @return evaluated element.
     */
    D eval(C c);

}
