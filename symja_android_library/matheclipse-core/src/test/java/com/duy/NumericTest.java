package com.duy;

import junit.framework.TestCase;
import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;
import org.matheclipse.core.basic.Config;
import org.matheclipse.core.basic.OperationSystem;
import org.matheclipse.core.builtin.functions.GammaJS;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.ExprEvaluator;
import org.matheclipse.core.expression.BigIntegerSym;
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

  public void testListable() {
    ExprEvaluator exprEvaluator = new ExprEvaluator();
    assertEquals(exprEvaluator.eval("Sin({1,2,3})").toString(),
        "{Sin(1),Sin(2),Sin(3)}");
    assertEquals(exprEvaluator.eval("LCM({1,2,3},3)").toString(),
        "{3,6,3}");
    assertEquals(exprEvaluator.eval("Cos({1,2,3},4,{1,2,4})").toString(),
        "{Cos(1,4,1),Cos(2,4,2),Cos(3,4,4)}");
    assertEquals(exprEvaluator.eval("Cos({1,2,3})").toString(),
        "{Cos(1),Cos(2),Cos(3)}");
  }

  public void testRound() {
    ExprEvaluator exprEvaluator = new ExprEvaluator();
    exprEvaluator.eval("TiRound[x_, y_] := Round[x, 10^(-y)]");
    assertEquals(exprEvaluator.eval("N[TiRound(Rationalize(2.1675),3.0)]").toString(),
        "2.168");
  }

  public void testSmallValue() {
    ExprEvaluator exprEvaluator = new ExprEvaluator();
//        assertEquals(exprEvaluator.eval("N(0.00000000000000000000000000000091093835611, 100)").toString(),
//                "9.1093835611*10^-31");

    assertEquals(exprEvaluator.eval("N[1/0.0000000000000000001602176620898, 100]").toString(),
        "6.241509125501484852088071665173164020252959820255548406024372975427711002340001391293975286331422184*10^18");

    assertEquals(
        exprEvaluator.eval("N[1/(N(0.0000000000000000001602176620898, 100)), 100]").toString(),
        "6.241509125501484852088071665173164020252959820255548406024372975427711002340001391293975286331422184*10^18");

    String expr = "(N(0.00000000000000000000000000000091093835611, 100))*(299792458)*(299792458)/(N(0.0000000000000000001602176620898, 100))";
    EvalEngine engine = exprEvaluator.getEvalEngine();
    exprEvaluator.eval(expr);
    assertEquals(exprEvaluator.eval(expr).toString(),
        "5.109989462990596090073354406528618388487843922686823477318769336034715783232952947882118172965136566*10^5");
  }

  public void testPrecision() {
    // (1+10^-15)^(10^15)
    double e = Math.pow(10, 15);
    System.out.println("e = " + e);
    double b = 1.0 + 10E-15;
    System.out.println("b = " + b);
    double a = Math.pow(b, e);
    System.out.println("a = " + a);
    a = Math.pow(1.000000000000001, 1000000000000000L);
    System.out.println("a = " + a);
    Apfloat apResult = ApfloatMath.pow(
        new Apfloat("1.000000000000001", 30),
        new Apfloat("1000000000000000", 30));
    System.out.println("result = " + apResult.toString(true));
    ExprEvaluator exprEvaluator = new ExprEvaluator();
    IExpr result = exprEvaluator.eval("(1+10^-N[15, 50])^(10^15)");
    System.out.println("result = " + result);
  }

  public void testToomcook3Threshold() {
    OperationSystem.toomCook3Threshold = 512;
    ExprEvaluator exprEvaluator = new ExprEvaluator();

    try {
      exprEvaluator.eval("Rationalize(0.1)^99999999");
      fail();
    } catch (Exception e) {
      e.printStackTrace();
    }

    try {
      exprEvaluator.eval("9999^99999999");
      fail();
    } catch (Exception e) {
      e.printStackTrace();
    }

    try {
      // Test org.apfloat.ApfloatHelper#toBigInteger
      IExpr result = exprEvaluator.eval(
          "IntegerPart[" +
              "N[Rationalize(7.632983698255881490491277878802104727687173409866438641630722914874999055316337727346395442234887161)"
              +
              "*10^N(29995651.0, 100), 100]]");
      assertTrue(result instanceof BigIntegerSym);
      assertEquals(((BigIntegerSym) result).bitLength(), 99643399);
      System.out.println("result.size = " + result.size());
      fail(); // should throw out of memory
    } catch (Exception e) {
      e.printStackTrace();
    }

    try {
      Config.MAX_BIT_LENGTH = 1024; // max 2^1024
      exprEvaluator.eval("(1/10)^(12314123/100000000)");
      fail();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void testBetaRegularized() {
    double res = GammaJS.betaRegularized(0.9768451023103443, 337.0, 0.5);
    assertEquals(res, 0.0000712171, 1E-9);
  }
}
