package com.duy;

import junit.framework.TestCase;

import org.matheclipse.core.eval.ExprEvaluator;
import org.matheclipse.core.interfaces.IExpr;

public class ArcTanTest extends TestCase {
    public void testArcTan2() {
        ExprEvaluator exprEvaluator = new ExprEvaluator();
        IExpr result = exprEvaluator.eval("ArcTan(-9*Sqrt(2),0)");
        assertEquals(result.toString(), "Pi");
    }

}
