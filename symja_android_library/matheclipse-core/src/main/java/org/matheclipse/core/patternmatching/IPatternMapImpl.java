package org.matheclipse.core.patternmatching;

import com.duy.lambda.Function;
import com.duy.lambda.Predicate;
import org.matheclipse.core.eval.EvalAttributes;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.expression.OptionsPattern;
import org.matheclipse.core.expression.Pattern;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IASTMutable;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.IPatternObject;
import org.matheclipse.core.visit.VisitorReplaceAllWithPatternFlags;

@SuppressWarnings("JavaDoc")
public abstract class IPatternMapImpl implements IPatternMap {

  /**
   * The default priority when associating a new rule to a symbol. Lower values have higher priorities.
   */
  public final static int DEFAULT_RULE_PRIORITY = Integer.MAX_VALUE;

  @Override
  public void initPatternBlank() {
    initPattern();
  }

  @Override
  public boolean isPatternTest(IExpr expr, IExpr patternTest, final EvalEngine engine) {
    final IExpr temp = substitutePatternOrSymbols(expr, false).orElse(expr);
    if (temp.isSequence()) {
      final IASTMutable test = F.unaryAST1(patternTest, null);
      return ((IAST) temp)
          .forAll(
              new Predicate<IExpr>() {
                @Override
                public boolean test(IExpr x) {
                  test.set(1, x);
                  return engine.evalTrue(test);
                }
              });
    }
    return engine.evalTrue(F.unaryAST1(patternTest, temp));
  }

  /**
   * Substitute all patterns and symbols in the given expression with the current value of the corresponding internal
   * pattern values arrays
   *
   * @param lhsPatternExpr left-hand-side expression which may contain pattern objects
   * @param onlyNamedPatterns TODO
   * @return <code>F.NIL</code> if substitutions isn't possible
   */
  @Override
  public IExpr substitutePatternOrSymbols(IExpr lhsPatternExpr, final boolean onlyNamedPatterns) {
    VisitorReplaceAllWithPatternFlags visitor =
        new VisitorReplaceAllWithPatternFlags(
            new Function<IExpr, IExpr>() {
              @Override
              public IExpr apply(IExpr input) {
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
                  return IPatternMapImpl.this.substitute(symbolOrPatternObject);
                }
                return F.NIL;
              }
            },
            onlyNamedPatterns);
    IExpr result = lhsPatternExpr.accept(visitor);

    if (result.isPresent()) {
      // set the eval flags
      result.isFreeOfPatterns();
      return result;
    }
    return lhsPatternExpr;
  }

  @Override
  public IExpr substituteASTPatternOrSymbols(IAST lhsPatternExpr, final boolean onlyNamedPatterns) {
    VisitorReplaceAllWithPatternFlags visitor =
        new VisitorReplaceAllWithPatternFlags(
            new Function<IExpr, IExpr>() {
              @Override
              public IExpr apply(IExpr input) {
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
                  return IPatternMapImpl.this.substitute(symbolOrPatternObject);
                }
                return F.NIL;
              }
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
  }

  /**
   * @param op
   * @param x may be <code>null</code>
   * @param engine
   */
  public static void addOptionsPattern(OptionsPattern op, IExpr x, EvalEngine engine) {
    if (x.size() > 1 && //
        (x.isSequence() || x.isList())) {
      IAST list = (IAST) x;
      for (int i = 1; i < list.size(); i++) {
        // also for nested lists
        addOptionsPattern(op, list.get(i), engine);
      }
    } else {
      engine.addOptionsPattern(op, (IAST) x);
    }

  }
}
