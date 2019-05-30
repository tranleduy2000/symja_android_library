package com.duy;

import junit.framework.TestCase;

import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.INum;

public class NumericTest extends TestCase {

    public void testSpeedOfLight() {
        //calculate speed of light = 299,792,458

        //Java floating point
        double e1 = 8.854187817E-12;
        double m1 = 1.2566370614E-6;
        double c1 = 1 / Math.sqrt(e1 * m1);
        assertEquals(c1, 2.997924580147872E8);

        //Numeric evaluator
        INum e2 = F.num(8.854187817E-12);
        INum m2 = F.num(1.2566370614E-6);
        IExpr c2 = F.num(1).divide(F.Sqrt(e2.multiply(m2)));
        assertEquals(c2.evalDouble(), 2.997924580147872E8);
    }

}
