/*
 * $Id$
 */

package edu.jas.structure;


/**
 * Algabra element interface.
 *
 * @param <A> algebra type
 * @param <C> scalar type
 * @author Heinz Kredel
 */
public abstract class AlgebraElemImpl<A extends AlgebraElemImpl<A, C>, C extends RingElem<C>>
        extends RingElemImpl<A> implements AlgebraElem<A, C> {

}
