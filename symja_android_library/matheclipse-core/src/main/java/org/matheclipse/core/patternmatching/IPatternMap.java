package org.matheclipse.core.patternmatching;

import com.duy.annotations.Nonnull;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.IPatternObject;
import org.matheclipse.core.interfaces.IPatternSequence;

import java.util.List;

/**
 * Interface for mapping ISymbol objects to int values.
 *
 */
public interface IPatternMap extends Cloneable {

    public IPatternMap clone();

    /**
     * Copy the current values into a new array.
     *
     * @return
     * @see PatternMap#resetPattern(IExpr[])
     */
    public IExpr[] copyPattern();

    /**
     * Copy the found pattern matches from the given <code>patternMap</code> back to this maps pattern values.
     *
     * @param patternMap
     */
    public void copyPatternValuesFromPatternMatcher(final IPatternMap patternMap);

    /**
     * Get the <code>int</code> value mapped to the given pattern or symbol.
     *
     * @param patternOrSymbol
     *            the given pattern or symbol
     * @return <code>-1</code> if the symbol isn't available in this map.
     */
    public int get(IExpr patternOrSymbol);

    public boolean getRHSEvaluated();

    public IExpr getKey(int index);

    /**
     * Return the matched value for the given <code>index</code> if possisble.
     *
     * @return <code>null</code> if no matched expression exists
     */
    public IExpr getValue(int index);

    /**
     * Return the matched value for the given pattern object
     *
     * @param pExpr
     * @return <code>null</code> if no matched expression exists
     */
    public IExpr getValue(@Nonnull IPatternObject pattern);

    public List<IExpr> getValuesAsList();

    /**
     * Set all pattern values to <code>null</code>;
     */
    public void initPattern();

    /**
     * Check if all symbols in the symbols array have corresponding values assigned.
     *
     * @return
     */
    public boolean isAllPatternsAssigned();

    /**
     * Check if the substituted expression still contains a symbol of a pattern expression.
     *
     * @param substitutedExpr
     * @return
     */
    public boolean isFreeOfPatternSymbols(IExpr substitutedExpr);

     boolean isPatternTest(IExpr expr, IExpr patternTest, EvalEngine engine);

    /**
     * Returns true if the pattern matcher contains no patterns
     *
     * @return
     */
    public boolean isRuleWithoutPatterns();

    /**
     * Returns true if the pattern matcher contains at least one value assigned.
     *
     * @return
     */
    public boolean isValueAssigned();

    /**
     * Reset the values to the values in the given array
     *
     * @param patternValuesArray
     * @see PatternMap#copyPattern()
     */
    public void resetPattern(final IExpr[] patternValuesArray);

    public void setRHSEvaluated(boolean evaluated);

    public void setValue(IPatternObject pattern, IExpr expr);

    public void setValue(IPatternSequence pattern, IAST sequence);

    /**
     * Gives the number of symbols used in this map.
     *
     * @return the number of symbols used in this map.
     */
    public int size();

    public IExpr substitute(IExpr symbolOrPatternObject);

    /**
     * Substitute all patterns and symbols in the given expression with the current value of the corresponding internal
     * pattern values arrays
     *
     * @param lhsPatternExpr
     *            left-hand-side expression which may contain pattern objects
     * @param onlyNamedPatterns
     *            TODO
     *
     * @return <code>F.NIL</code> if substitutions isn't possible
     */
     IExpr substitutePatternOrSymbols(final IExpr lhsPatternExpr, boolean onlyNamedPatterns);

     IAST substituteASTPatternOrSymbols(final IAST lhsPatternExpr, boolean onlyNamedPatterns);

    /**
     * Substitute all symbols in the given expression with the current value of the corresponding internal pattern
     * values arrays
     *
     * @param rhsExpr
     *            right-hand-side expression, substitute all symbols from the pattern-matching values
     *
     * @return
     */
    public IExpr substituteSymbols(final IExpr rhsExpr);

}
