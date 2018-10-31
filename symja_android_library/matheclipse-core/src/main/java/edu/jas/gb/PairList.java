/*
 * $Id$
 */

package edu.jas.gb;

import java.io.Serializable;
import java.util.List;

import edu.jas.poly.ExpVector;
import edu.jas.poly.GenPolynomial;
import edu.jas.poly.GenPolynomialRing;
import edu.jas.structure.RingElem;


/**
 * Pair list management interface.
 *
 * @author Heinz Kredel
 */

public interface PairList<C extends RingElem<C>> extends Serializable {


    /**
     * Create a new PairList.
     *
     * @param r polynomial ring.
     */
    PairList<C> create(GenPolynomialRing<C> r);


    /**
     * Create a new PairList.
     *
     * @param m number of module variables.
     * @param r polynomial ring.
     */
    PairList<C> create(int m, GenPolynomialRing<C> r);


    /**
     * toString.
     */
    @Override
    String toString();


    /**
     * Put one Polynomial to the pairlist and reduction matrix.
     *
     * @param p polynomial.
     * @return the index of the added polynomial.
     */
    int put(GenPolynomial<C> p);


    /**
     * Put all polynomials in F to the pairlist and reduction matrix.
     *
     * @param F polynomial list.
     * @return the index of the last added polynomial.
     */
    int put(List<GenPolynomial<C>> F);


    /**
     * Put to ONE-Polynomial to the pairlist.
     *
     * @return the index of the last polynomial.
     */
    int putOne();


    /**
     * Remove the next required pair from the pairlist and reduction matrix.
     * Appy the criterions 3 and 4 to see if the S-polynomial is required.
     *
     * @return the next pair if one exists, otherwise null.
     */
    Pair<C> removeNext();


    /**
     * Test if there is possibly a pair in the list.
     *
     * @return true if a next pair could exist, otherwise false.
     */
    boolean hasNext();


    /**
     * Get the size of the list of polynomials.
     *
     * @return size of the polynomial list.
     */
    int size();


    /**
     * Get the list of polynomials.
     *
     * @return the polynomial list.
     */
    List<GenPolynomial<C>> getList();


    /**
     * Set the list of polynomials.
     *
     * @param F the polynomial list.
     */
    void setList(List<GenPolynomial<C>> F);


    /**
     * Get the number of polynomials put to the pairlist.
     *
     * @return the number of calls to put.
     */
    int putCount();


    /**
     * Get the number of required pairs removed from the pairlist.
     *
     * @return the number of non null pairs delivered.
     */
    int remCount();


    /**
     * GB criterium 3.
     *
     * @return true if the S-polynomial(i,j) is required.
     */
    boolean criterion3(int i, int j, ExpVector eij);

}

