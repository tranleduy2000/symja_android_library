package com.duy;

import junit.framework.TestCase;

import org.matheclipse.core.eval.ExprEvaluator;
import org.matheclipse.core.expression.AbstractFractionSym;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.IFraction;

import java.math.BigInteger;

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
        assertEquals(s, "2-(3+4)");
    }

    public void testBigFractionToDouble() {
        IFraction fraction = AbstractFractionSym.valueOf(
                new BigInteger("2535301200456458802993406410751"),
                new BigInteger("1267650600228229401496703205376"));
        double value = fraction.doubleValue();
        assertEquals(value, 2.0);
    }

}
