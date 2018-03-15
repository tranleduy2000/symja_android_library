package com.duy;

import junit.framework.TestCase;

import org.matheclipse.core.eval.ExprEvaluator;
import org.matheclipse.core.interfaces.IExpr;

/**
 * Created by Duy on 13-Mar-18.
 */

public class ToStringTest extends TestCase {
    public void test1() {
        IExpr parse = new ExprEvaluator().parse("3/(4*5)");
        String s = parse.toString();
        assertEquals(s, "3/(4*5)");
    }

    public void test2() {
        IExpr parse = new ExprEvaluator().parse("2-(3+4)");
        String s = parse.toString();
        assertEquals(s, "3/(4*5)");
    }
}
