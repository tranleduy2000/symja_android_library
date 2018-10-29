/*
 * $Id$
 */

package edu.jas.structure;


import java.util.List;


/**
 * Algebra factory interface. Defines conversion from list of lists and sparse
 * random.
 *
 * @param <A> algebra type
 * @param <C> coefficient type
 * @author Heinz Kredel
 */
public interface AlgebraFactory<A, C> extends RingFactory<A> {


    /**
     * Convert list of list to matrix.
     *
     * @param m list of list of ring elements.
     * @return a matrix with the elements from m.
     */
    A fromList(List<List<C>> m);


    /**
     * Random Matrix.
     *
     * @param k size of coefficients.
     * @param q fraction of non zero elements.
     * @return a random matrix.
     */
    A random(int k, float q);

}
