package org.matheclipse.core.eval.interfaces;

import org.matheclipse.core.builtin.IOFunctions;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.core.patternmatching.IPatternMapImpl;
import org.matheclipse.core.patternmatching.IPatternMatcher;

/**
 * Interface for &quot;core functions&quot; which don't have associated rules and are only defined
 * by a derived classes from this interface.
 */
public interface ICoreFunctionEvaluator extends IFunctionEvaluator {

  public static final ICoreFunctionEvaluator ARGS_EVALUATOR =
      new ICoreFunctionEvaluator() {

    @Override
        public final IExpr evaluate(IAST ast, final EvalEngine engine) {
      return F.NIL;// engine.evalAttributes(ast.topHead(), ast);

    }

    @Override
        public final IExpr numericEval(IAST ast, final EvalEngine engine) {
      return F.NIL;// engine.evalAttributes(ast.topHead(), ast);

    }

    @Override
    public void await() {

    }

    @Override
    public void setUp(ISymbol newSymbol) {

    }

    @Override
    public void setOptions(ISymbol symbol, IAST listOfRules) {
      symbol.putDownRule(
          IPatternMatcher.SET,
          true,
          F.Options(symbol),
          listOfRules,
          IPatternMapImpl.DEFAULT_RULE_PRIORITY,
          true);
    }

    @Override
    public int[] expectedArgSize(IAST ast) {
      return null;
    }

    @Override
    public IExpr print(IAST ast, int expected, EvalEngine engine) {
      // `1` called with `2` arguments; `3` arguments are expected.
      return IOFunctions.printMessage(
          ast.topHead(), "argrx", F.List(ast, F.ZZ(ast.argSize()), F.ZZ(expected)), engine);
    }
  };

  @Override
  IExpr numericEval(IAST ast, EvalEngine engine);
}