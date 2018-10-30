/*
 * $Id$
 */

package edu.jas.structure;


import java.util.List;


/**
 * Module element interface. Defines scalar operations.
 *
 * @param <M> module type
 * @param <C> scalar type
 * @author Heinz Kredel
 */
public interface ModulElem<M, C> extends AbelianGroupElem<M> {


    /**
     * Scalar multiplication. Multiply this by a scalar.
     *
     * @param s scalar
     * @return this * s.
     */
    M scalarMultiply(C s);


    /**
     * Linear combination.
     *
     * @param a scalar
     * @param b module element
     * @param s scalar
     * @return a * b + this * s.
     */
    M linearCombination(C a, M b, C s);


    /**
     * Linear combination.
     *
     * @param b module element
     * @param s scalar
     * @return b + this * s.
     */
    M linearCombination(M b, C s);


    /**
     * Scalar product. Multiply two vectors to become a scalar.
     *
     * @param b module element
     * @return this * b, a scalar.
     */
    C scalarProduct(M b);


    /**
     * Scalar product. Multiply this vectors by list of vectors to become a
     * vector.
     *
     * @param b list of module elements
     * @return this * b, a list of scalars, a module element.
     */
    M scalarProduct(List<M> b);

}