package com.duy;

import junit.framework.TestCase;

import org.matheclipse.core.eval.ExprEvaluator;

public class CachedTest extends TestCase {

    public void test1() {
        ExprEvaluator exprEvaluator = new ExprEvaluator();
        exprEvaluator.eval("SinAlias:=Sin");
        for (int i = 0; i < 100000; i++) {
            exprEvaluator.eval("x" + i + ":=" + i + "+" + i);
        }
        assertEquals(exprEvaluator.eval("SinAlias").toString(), "Sin");
    }
}
