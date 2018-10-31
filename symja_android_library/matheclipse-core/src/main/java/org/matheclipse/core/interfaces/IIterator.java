package org.matheclipse.core.interfaces;

import java.util.Iterator;

/**
 * Interface for an iterator with additional tearDown() method, to run the iterator again
 */
public interface IIterator<E> extends Iterator<E> {
    /**
     * Set up this iterator.
     *
     * @return
     */
    boolean setUp();

    /**
     * Set up this iterator.
     *
     * @return
     */
    boolean setUpThrow();

    /**
     * Get a hint of how much iterations probably will occurr.
     *
     * @return
     */
    int allocHint();

    /**
     * Get the &quot;upper limit&quot; which is used in this iterator.
     *
     * @return <code>null</code> if no &quot;upper limit&quot; is defined
     */
    IExpr getUpperLimit();

    /**
     * Get the &quot;lower limit&quot; which is used in this iterator.
     *
     * @return <code>null</code> if no &quot;lower limit&quot; is defined
     */
    IExpr getLowerLimit();

    /**
     * Get the &quot;step&quot; which is used in this iterator.
     *
     * @return <code>null</code> if no &quot;step&quot; is defined
     */
    IExpr getStep();

    /**
     * Get the variable which is used in this iterator.
     *
     * @return <code>null</code> if no variable is defined
     */
    ISymbol getVariable();

    /**
     * Test if &quot;lower limit&quot;, &quot;upper limit&quot; and &quot;step&quot; are numeric functions.
     *
     * @return
     */
    boolean isNumericFunction();

    /**
     * Test if there's a valid variable set for the iterator.
     *
     * @return
     */
    boolean isSetIterator();

    /**
     * Test if there's a valid variable set for the iterator and the &quot;upper limit&quot; is a list.
     *
     * @return
     */
    boolean isValidVariable();

    /**
     * Tear down this iterator.
     */
    void tearDown();
}
