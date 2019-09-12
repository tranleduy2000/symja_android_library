package com.duy;

import junit.framework.TestCase;

import org.matheclipse.core.basic.Config;
import org.matheclipse.core.eval.ExprEvaluator;
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

    /**
     * http://mathworld.wolfram.com/Surd.html
     * <p>
     * In general, an unresolved nth root, commonly involving a radical symbol RadicalBox[x, n],
     * is known as a surd. However, the term surd or "surd expression" (e.g., Hardy 1967, p. 25)
     * can also be used to mean a sum of one or more irrational roots. In the mathematical literature,
     * the term arises most commonly in the context of quadratic surds.
     * <p>
     * The term "surd" has a special meaning in the Wolfram Language, where the principal nth root of
     * a complex number z can be found as z^(1/n) or equivalently Power[z, 1/n]. However, when x is
     * real and only real roots are of interest, the command Surd[x, n] which returns the real-valued
     * nth root for real x odd n and the principal nth root for nonnegative real x and even n can be used.
     */
    public void testSurd() {
        ExprEvaluator exprEvaluator = new ExprEvaluator();
        Config.UNPROTECT_ALLOWED = true;
        assertEquals(exprEvaluator.eval("Surd(-8,3)").toString(),
                "-2");
        assertEquals(exprEvaluator.eval("Surd(-8.0,3)").toString(),
                "-2.0");
        assertEquals(exprEvaluator.eval("Surd(9.0,9)").toString(),
                "1.2765180070092417");
        assertEquals(exprEvaluator.eval("Surd(9.0,9.0)").toString(),
                "1.2765180070092417");
        assertEquals(exprEvaluator.eval("Surd(9,9)").toString(),
                "3^(2/9)");
        assertEquals(exprEvaluator.eval("Surd(x,2)").toString(),
                "Surd(x,2)");
        assertEquals(exprEvaluator.eval("D(x^(1/2),x)").toString(),
                "1/(2*Sqrt(x))");
    }

}
