package com.duy;

import junit.framework.TestCase;

import org.matheclipse.core.eval.ExprEvaluator;

public class BooleanTest extends TestCase {
    public void testAnd() {
        ExprEvaluator exprEvaluator = new ExprEvaluator();
        assertEquals(exprEvaluator.eval("And(False, True)").toString(), "False");
        assertEquals(exprEvaluator.eval("And(True, True)").toString(), "True");
        assertEquals(exprEvaluator.eval("And(False, False)").toString(), "False");
        assertEquals(exprEvaluator.eval("And(True, False)").toString(), "False");
        assertEquals(exprEvaluator.eval("And(0, 1)").toString(), "False");
        assertEquals(exprEvaluator.eval("And(1, 1)").toString(), "True");
        assertEquals(exprEvaluator.eval("And(1, 0)").toString(), "False");
        assertEquals(exprEvaluator.eval("And(0, 0)").toString(), "False");
    }

    public void testOr() {
        ExprEvaluator exprEvaluator = new ExprEvaluator();
        assertEquals(exprEvaluator.eval("Or(False, True)").toString(), "True");
        assertEquals(exprEvaluator.eval("Or(True, True)").toString(), "True");
        assertEquals(exprEvaluator.eval("Or(False, False)").toString(), "False");
        assertEquals(exprEvaluator.eval("Or(True, False)").toString(), "True");
        assertEquals(exprEvaluator.eval("Or(0, 1)").toString(), "True");
        assertEquals(exprEvaluator.eval("Or(1, 1)").toString(), "True");
        assertEquals(exprEvaluator.eval("Or(1, 0)").toString(), "True");
        assertEquals(exprEvaluator.eval("Or(0, 0)").toString(), "False");
    }

    public void testXor() {
        ExprEvaluator exprEvaluator = new ExprEvaluator();
        assertEquals(exprEvaluator.eval("Xor(False, True)").toString(), "True");
        assertEquals(exprEvaluator.eval("Xor(True, True)").toString(), "False");
        assertEquals(exprEvaluator.eval("Xor(False, False)").toString(), "False");
        assertEquals(exprEvaluator.eval("Xor(True, False)").toString(), "True");
        assertEquals(exprEvaluator.eval("Xor(0, 1)").toString(), "True");
        assertEquals(exprEvaluator.eval("Xor(1, 1)").toString(), "False");
        assertEquals(exprEvaluator.eval("Xor(1, 0)").toString(), "True");
        assertEquals(exprEvaluator.eval("Xor(0, 0)").toString(), "False");
    }

    public void testNot() {
        ExprEvaluator exprEvaluator = new ExprEvaluator();
        assertEquals(exprEvaluator.eval("Not(False)").toString(), "True");
        assertEquals(exprEvaluator.eval("Not(True)").toString(), "False");
        assertEquals(exprEvaluator.eval("Not(0)").toString(), "True");
        assertEquals(exprEvaluator.eval("Not(1)").toString(), "False");
    }
}
