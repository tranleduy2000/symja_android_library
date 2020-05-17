package org.matheclipse.core.reflection.system.rules;

import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.ArcCosh;
import static org.matheclipse.core.expression.F.ArcCoth;
import static org.matheclipse.core.expression.F.ArcCsch;
import static org.matheclipse.core.expression.F.ArcSech;
import static org.matheclipse.core.expression.F.ArcSinh;
import static org.matheclipse.core.expression.F.ArcTanh;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CC;
import static org.matheclipse.core.expression.F.CComplexInfinity;
import static org.matheclipse.core.expression.F.CI;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CNI;
import static org.matheclipse.core.expression.F.CSqrt2;
import static org.matheclipse.core.expression.F.Csch;
import static org.matheclipse.core.expression.F.IInit;
import static org.matheclipse.core.expression.F.ISet;
import static org.matheclipse.core.expression.F.ISetDelayed;
import static org.matheclipse.core.expression.F.Indeterminate;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Pi;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.oo;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;

/**
 * <p>Generated by <code>org.matheclipse.core.preprocessor.RulePreprocessor</code>.</p>
 * <p>See GIT repository at: <a href="https://github.com/axkr/symja_android_library">github.com/axkr/symja_android_library under the tools directory</a>.</p>
 */
public interface CschRules {
  /**
   * <ul>
   * <li>index 0 - number of equal rules in <code>RULES</code></li>
	 * </ul>
	 */
  final public static int[] SIZES = { 15, 7 };

  final public static IAST RULES = List(
    IInit(Csch, SIZES),
    // Csch(0)=ComplexInfinity
    ISet(Csch(C0),
      CComplexInfinity),
    // Csch(1/6*Pi*I)=(-2)*I
    ISet(Csch(Times(CC(0L,1L,1L,6L),Pi)),
      CC(0L,1L,-2L,1L)),
    // Csch(1/4*Pi*I)=-Sqrt(2)*I
    ISet(Csch(Times(CC(0L,1L,1L,4L),Pi)),
      Times(CNI,CSqrt2)),
    // Csch(1/2*Pi*I)=-I
    ISet(Csch(Times(CC(0L,1L,1L,2L),Pi)),
      CNI),
    // Csch(3/4*Pi*I)=-Sqrt(2)*I
    ISet(Csch(Times(CC(0L,1L,3L,4L),Pi)),
      Times(CNI,CSqrt2)),
    // Csch(5/6*Pi*I)=(-2)*I
    ISet(Csch(Times(CC(0L,1L,5L,6L),Pi)),
      CC(0L,1L,-2L,1L)),
    // Csch(Pi*I)=ComplexInfinity
    ISet(Csch(Times(CI,Pi)),
      CComplexInfinity),
    // Csch(7/6*Pi*I)=2*I
    ISet(Csch(Times(CC(0L,1L,7L,6L),Pi)),
      CC(0L,1L,2L,1L)),
    // Csch(5/4*Pi*I)=Sqrt(2)*I
    ISet(Csch(Times(CC(0L,1L,5L,4L),Pi)),
      Times(CI,CSqrt2)),
    // Csch(3/2*Pi*I)=I
    ISet(Csch(Times(CC(0L,1L,3L,2L),Pi)),
      CI),
    // Csch(7/4*Pi*I)=Sqrt(2)*I
    ISet(Csch(Times(CC(0L,1L,7L,4L),Pi)),
      Times(CI,CSqrt2)),
    // Csch(11/6*Pi*I)=2*I
    ISet(Csch(Times(CC(0L,1L,11L,6L),Pi)),
      CC(0L,1L,2L,1L)),
    // Csch(2*Pi*I)=ComplexInfinity
    ISet(Csch(Times(CC(0L,1L,2L,1L),Pi)),
      CComplexInfinity),
    // Csch(ArcSinh(x_)):=1/x
    ISetDelayed(Csch(ArcSinh(x_)),
      Power(x,CN1)),
    // Csch(ArcCosh(x_)):=1/(Sqrt(-1+x)*Sqrt(x+1))
    ISetDelayed(Csch(ArcCosh(x_)),
      Power(Times(Sqrt(Plus(CN1,x)),Sqrt(Plus(x,C1))),CN1)),
    // Csch(ArcTanh(x_)):=Sqrt(x+1)*Sqrt(1-x)/x
    ISetDelayed(Csch(ArcTanh(x_)),
      Times(Sqrt(Plus(x,C1)),Sqrt(Subtract(C1,x)),Power(x,CN1))),
    // Csch(ArcCoth(x_)):=Sqrt(-1+x)*Sqrt(x+1)
    ISetDelayed(Csch(ArcCoth(x_)),
      Times(Sqrt(Plus(CN1,x)),Sqrt(Plus(x,C1)))),
    // Csch(ArcSech(x_)):=x/(Sqrt((1-x)/(1+x))*(1+x))
    ISetDelayed(Csch(ArcSech(x_)),
      Times(x,Power(Times(Sqrt(Times(Subtract(C1,x),Power(Plus(C1,x),CN1))),Plus(C1,x)),CN1))),
    // Csch(ArcCsch(x_)):=x
    ISetDelayed(Csch(ArcCsch(x_)),
      x),
    // Csch(Log(x_)):=2*x/(-1+x^2)
    ISetDelayed(Csch(Log(x_)),
      Times(C2,x,Power(Plus(CN1,Sqr(x)),CN1))),
    // Csch(Infinity)=0
    ISet(Csch(oo),
      C0),
    // Csch(ComplexInfinity)=Indeterminate
    ISet(Csch(CComplexInfinity),
      Indeterminate)
  );
}
