package com.duy;

import junit.framework.TestCase;

import org.matheclipse.core.eval.ExprEvaluator;
import org.matheclipse.core.interfaces.IExpr;

public class MemoryOverflowErrorTest extends TestCase {

    public void testPower() {
        IExpr result = new ExprEvaluator().eval("N(3123^22321321)");
        assertEquals(result.toString(), "Infinity");

        result = new ExprEvaluator().eval("3123^(1232321311/2131211123)");
        assertEquals(result.toString(), "Infinity");
    }
}
