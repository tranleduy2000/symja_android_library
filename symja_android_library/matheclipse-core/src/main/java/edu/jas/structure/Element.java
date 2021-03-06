/*
 * $Id$
 */

package edu.jas.structure;


import java.io.Serializable;


/**
 * Element interface. Basic functionality of elements, e.g. compareTo, equals,
 * clone.
 * <b>Note:</b> extension of <code>Cloneable</code> removed in
 * 2012-08-18, <code>clone()</code> is renamed to <code>copy()</code>.
 *
 * @param <C> element type. See the discussion in
 *            <a href="http://www.artima.com/intv/bloch13.html">Bloch on Cloning</a>.
 * @author Heinz Kredel
 */

public interface Element<C> extends Comparable<C>, Serializable {


    /**
     * Clone this Element.
     *
     * @return Creates and returns a copy of this Element.
     */
    C copy();

    /**
     * Hashcode of this Element.
     *
     * @return the hashCode.
     */
    int hashCode();

    /**
     * Test if this is equal to b.
     *
     * @param b
     * @return true if this is equal to b, else false.
     */
    boolean equals(Object b);

    /**
     * Compare this to b. I.e. this &lt; b iff this.compareTo(b) &lt; 0.
     * <b>Note:</b> may not be meaningful if structure has no order.
     *
     * @param b
     * @return 0 if this is equal to b, -1 if this is less then b, else +1.
     */
    int compareTo(C b);


    /**
     * Get the corresponding element factory.
     *
     * @return factory for this Element.
     */
    ElemFactory<C> factory();


    /**
     * Get a scripting compatible string representation.
     *
     * @return script compatible representation for this Element.
     */
    String toScript();


    /**
     * Get a scripting compatible string representation of the factory.
     *
     * @return script compatible representation for this ElemFactory.
     */
    String toScriptFactory();

}
