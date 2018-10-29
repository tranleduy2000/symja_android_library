/*
 * $Id$
 */

package edu.jas.structure;


import edu.jas.structure.elem.Element;

/**
 * Unary functor interface.
 *
 * @param <C> element type
 * @param <D> element type
 * @author Heinz Kredel
 */

public interface UnaryFunctor<C extends Element<C>, D extends Element<D>> {


    /**
     * Evaluate.
     *
     * @return evaluated element.
     */
    D eval(C c);

}
