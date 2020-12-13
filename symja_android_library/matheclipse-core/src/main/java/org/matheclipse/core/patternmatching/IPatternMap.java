package org.matheclipse.core.patternmatching;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.IPatternObject;
import org.matheclipse.core.interfaces.IPatternSequence;
import org.matheclipse.core.interfaces.ISymbol;

import java.util.List;

/** Interface for mapping ISymbol objects to int values. */
public interface IPatternMap {

  public IPatternMap copy();

  /**
   * Copy the current values into a new array.
   *
   * @return
   * @see PatternMap#resetPattern(IExpr[])
   */
  public IExpr[] copyPattern();

  /**
   * Copy the found pattern matches from the given <code>patternMap</code> back to this maps pattern
   * values.
   *
   * @param patternMap
   */
  public void copyPatternValuesFromPatternMatcher(final IPatternMap patternMap);

  /**
   * Get the <code>int</code> value mapped to the given pattern or symbol.
   *
   * @param patternOrSymbol the given pattern or symbol
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
   * @param pattern the pattern object
   * @return <code>null</code> if no matched expression exists
   */
  public IExpr getValue(IPatternObject pattern);

  public List<IExpr> getValuesAsList();

  /** Set all pattern values to <code>null</code>; */
  public void initPattern();

  void initPatternBlank(); /*{
    initPattern();
  }*/

  public void initSlotValues();

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

  /*default*/ boolean isPatternTest(IExpr expr, IExpr patternTest, EvalEngine engine); /*{
    final IExpr temp = substitutePatternOrSymbols(expr, false).orElse(expr);
    if (temp.isSequence()) {
      final IASTMutable test = F.unaryAST1(patternTest, null);
      return ((IAST) temp)
          .forAll(
              x -> {
                test.set(1, x);
                return engine.evalTrue(test);
              });
    }
    return engine.evalTrue(F.unaryAST1(patternTest, temp));
  }*/

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

  /**
   * Assign the value to the pattern.
   *
   * @param pattern the pattern expression
   * @param expr
   * @return <code>true</code> if assignment was successful, <code>false</code> otherwise.
   */
  public boolean setValue(IPatternObject pattern, IExpr expr);

  /**
   * Assign the sequence to the pattern sequence.
   *
   * @param pattern the pattern sequence expression
   * @param sequence
   * @return <code>true</code> if assignment was successful, <code>false</code> otherwise.
   */
  public boolean setValue(IPatternSequence pattern, IAST sequence);

  /**
   * Gives the number of symbols used in this map.
   *
   * @return the number of symbols used in this map.
   */
  public int size();

  public IExpr substitute(IExpr symbolOrPatternObject);

  /**
   * Substitute all patterns and symbols in the given expression with the current value of the
   * corresponding internal pattern values arrays
   *
   * @param lhsPatternExpr left-hand-side expression which may contain pattern objects
   * @param onlyNamedPatterns TODO
   * @return <code>F.NIL</code> if substitutions isn't possible
   */
  IExpr substitutePatternOrSymbols(final IExpr lhsPatternExpr, boolean onlyNamedPatterns); /*{
    VisitorReplaceAllWithPatternFlags visitor =
        new VisitorReplaceAllWithPatternFlags(
            input -> {
              if (input instanceof IPatternObject) {
                if (onlyNamedPatterns && !(input instanceof Pattern)) {
                  return F.NIL;
                }
                IExpr symbolOrPatternObject = ((IPatternObject) input).getSymbol();
                if (symbolOrPatternObject == null) {
                  if (onlyNamedPatterns) {
                    return F.NIL;
                  }
                  symbolOrPatternObject = input;
                }
                return substitute(symbolOrPatternObject);
              }
              return F.NIL;
            },
            onlyNamedPatterns);
    IExpr result = lhsPatternExpr.accept(visitor);

    if (result.isPresent()) {
      // set the eval flags
      result.isFreeOfPatterns();
      return result;
    }
    return lhsPatternExpr;
  }*/

  IExpr substituteASTPatternOrSymbols(final IAST lhsPatternExpr, boolean onlyNamedPatterns); /*{
    VisitorReplaceAllWithPatternFlags visitor =
        new VisitorReplaceAllWithPatternFlags(
            input -> {
              if (input instanceof IPatternObject) {
                if (onlyNamedPatterns && !(input instanceof Pattern)) {
                  return F.NIL;
                }
                IExpr symbolOrPatternObject = ((IPatternObject) input).getSymbol();
                if (symbolOrPatternObject == null) {
                  if (onlyNamedPatterns) {
                    return F.NIL;
                  }
                  symbolOrPatternObject = input;
                }
                return substitute(symbolOrPatternObject);
              }
              return F.NIL;
            },
            onlyNamedPatterns);

    IASTMutable result = F.NIL;
    for (int i = 1; i < lhsPatternExpr.size(); i++) {
      IExpr temp = lhsPatternExpr.get(i).accept(visitor);
      if (temp.isPresent()) {
        if (!result.isPresent()) {
          result = lhsPatternExpr.setAtCopy(i, temp);
          // result.setEvalFlags(lhsPatternExpr.getEvalFlags());
        } else {
          result.set(i, temp);
        }
      }
    }

    if (result.isPresent()) {
      return EvalAttributes.simpleEval(result);

      // if (result.isFlatAST()) {
      // IASTMutable temp = EvalAttributes.flattenDeep((IAST) result);
      // if (temp.isPresent()) {
      // result = temp;
      // }
      // }
      // // don't test for OneIdentity attribute here !
      // if (result.isOrderlessAST()) {
      // EvalAttributes.sort(result);
      // }
      // // set the eval flags
      // result.isFreeOfPatterns();
      // // System.out.println(" " + lhsPatternExpr.toString() + " -> " + result.toString());
      // return result;
    }
    return F.NIL;
  }*/

  /**
   * Substitute all symbols in the given expression with the current value of the corresponding
   * internal pattern values arrays
   *
   * @param rhsExpr right-hand-side expression, substitute all symbols from the pattern-matching
   *     values
   * @param nilOrEmptySequence default value <code>F.NIL</code> or <code>F.Sequence()</code>
   * @return
   */
  public IExpr substituteSymbols(final IExpr rhsExpr, final IExpr nilOrEmptySequence);

  public boolean setOptionsPattern(final EvalEngine engine, ISymbol lhsHead);

  // Moved to org.matheclipse.core.patternmatching.IPatternMapImpl
  // /**
  //  * @param op
  //  * @param x      may be <code>null</code>
  //  * @param engine
  //  */
  // public static void addOptionsPattern(OptionsPattern op, IExpr x, EvalEngine engine) {
  //     if (x.size() > 1 && //
  //             (x.isSequence() || x.isList())) {
  //         IAST list = (IAST) x;
  //         for (int i = 1; i < list.size(); i++) {
  //             // also for nested lists
  //             addOptionsPattern(op, list.get(i), engine);
  //         }
  //     } else {
  //         engine.addOptionsPattern(op, (IAST) x);
  //     }
  // }
}
