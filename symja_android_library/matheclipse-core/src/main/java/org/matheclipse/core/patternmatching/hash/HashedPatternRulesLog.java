package org.matheclipse.core.patternmatching.hash;

import org.matheclipse.core.builtin.ExpTrigsFunctions;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.IInteger;

/**
 * Evaluate <code>Log(x) * Log(y)</code> combinations. For example evaluate <code>Log(1000) / Log(10)</code> to
 * <code>3</code>
 */
public class HashedPatternRulesLog extends HashedPatternRules {

  public HashedPatternRulesLog(IExpr lhsPattern1, IExpr lhsPattern2) {
    super(lhsPattern1, lhsPattern2, F.Null, null, true);
  }

  // private HashedPatternRulesLog(IExpr lhsPattern1, IExpr lhsPattern2, IExpr rhsResult, IExpr condition,
  // boolean defaultHashCode) {
  // super(lhsPattern1, lhsPattern2, rhsResult, condition, defaultHashCode);
  // }

  @Override
  public IExpr evalDownRule(IExpr e1, IExpr num1, IExpr e2, IExpr num2, EvalEngine engine) {
    if (num1.isOne() && num2.isMinusOne()) {
      IExpr temp = getRulesData().evalDownRule(F.List(e1, e2), engine);
      if (temp.isPresent()) {
        IExpr i1 = e1.first();
        IExpr i2 = e2.first();
        if (i1.isInteger() && i2.isInteger()) {
          return ExpTrigsFunctions.baseBLog((IInteger) i2, (IInteger) i1);
        }
        // ExpTrigsFunctions.integerLogFunction();
        // if (num1.equals(num2)) {
        // return F.Power(temp, num2);
        // }
        // IInteger plusMinusOne = F.C1;
        // if (num1.isNegative() && num2.isNegative()) {
        // num1 = num1.negate();
        // num2 = num2.negate();
        // plusMinusOne = F.CN1;
        // }
        // if (num1.isPositive() && num2.isPositive()) {
        // IExpr diff = num1.subtract(num2);
        // if (diff.isPositive()) {
        // // num1 > num2
        // return F.Times(F.Power(e1, diff), F.Power(temp, num2));
        // } else {
        // // num1 < num2
        // diff = diff.negate();
        // return F.Times(F.Power(e2, diff), F.Power(temp, num1));
        // }
        // }
      }
    }
    return F.NIL;
  }
}