package org.matheclipse.core.reflection.system.rules;

import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.ArcCos;
import static org.matheclipse.core.expression.F.ArcCot;
import static org.matheclipse.core.expression.F.ArcCsc;
import static org.matheclipse.core.expression.F.ArcSec;
import static org.matheclipse.core.expression.F.ArcSin;
import static org.matheclipse.core.expression.F.ArcTan;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D3;
import static org.matheclipse.core.expression.F.C1D4;
import static org.matheclipse.core.expression.F.C1DSqrt3;
import static org.matheclipse.core.expression.F.C1DSqrt5;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C2Pi;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CComplexInfinity;
import static org.matheclipse.core.expression.F.CI;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.CNI;
import static org.matheclipse.core.expression.F.CPiHalf;
import static org.matheclipse.core.expression.F.CSqrt2;
import static org.matheclipse.core.expression.F.CSqrt3;
import static org.matheclipse.core.expression.F.CSqrt5;
import static org.matheclipse.core.expression.F.CSqrt6;
import static org.matheclipse.core.expression.F.Csc;
import static org.matheclipse.core.expression.F.DirectedInfinity;
import static org.matheclipse.core.expression.F.IInit;
import static org.matheclipse.core.expression.F.ISet;
import static org.matheclipse.core.expression.F.ISetDelayed;
import static org.matheclipse.core.expression.F.Indeterminate;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Pi;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.QQ;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;

/**
 * <p>Generated by <code>org.matheclipse.core.preprocessor.RulePreprocessor</code>.</p>
 * <p>See GIT repository at: <a href="https://github.com/axkr/symja_android_library">github.com/axkr/symja_android_library under the tools directory</a>.</p>
 */
public interface CscRules {
  /**
   * <ul>
   * <li>index 0 - number of equal rules in <code>RULES</code></li>
	 * </ul>
	 */
  final public static int[] SIZES = { 43, 6 };

  final public static IAST RULES = List(
    IInit(Csc, SIZES),
    // Csc(0)=ComplexInfinity
    ISet(Csc(C0),
      CComplexInfinity),
    // Csc(Pi/12)=Sqrt(2)+Sqrt(6)
    ISet(Csc(Times(QQ(1L,12L),Pi)),
      Plus(CSqrt2,CSqrt6)),
    // Csc(Pi/10)=1+Sqrt(5)
    ISet(Csc(Times(QQ(1L,10L),Pi)),
      Plus(C1,CSqrt5)),
    // Csc(Pi/8)=Sqrt(4+2*Sqrt(2))
    ISet(Csc(Times(QQ(1L,8L),Pi)),
      Sqrt(Plus(C4,Times(C2,CSqrt2)))),
    // Csc(Pi/6)=2
    ISet(Csc(Times(QQ(1L,6L),Pi)),
      C2),
    // Csc(Pi/5)=Sqrt(2+2/Sqrt(5))
    ISet(Csc(Times(QQ(1L,5L),Pi)),
      Sqrt(Plus(C2,Times(C2,C1DSqrt5)))),
    // Csc(Pi/4)=Sqrt(2)
    ISet(Csc(Times(C1D4,Pi)),
      CSqrt2),
    // Csc(3/10*Pi)=-1+Sqrt(5)
    ISet(Csc(Times(QQ(3L,10L),Pi)),
      Plus(CN1,CSqrt5)),
    // Csc(Pi/3)=2/Sqrt(3)
    ISet(Csc(Times(C1D3,Pi)),
      Times(C2,C1DSqrt3)),
    // Csc(2/5*Pi)=Sqrt(2-2/Sqrt(5))
    ISet(Csc(Times(QQ(2L,5L),Pi)),
      Sqrt(Plus(C2,Times(CN2,C1DSqrt5)))),
    // Csc(5/12*Pi)=-Sqrt(2)+Sqrt(6)
    ISet(Csc(Times(QQ(5L,12L),Pi)),
      Plus(Negate(CSqrt2),CSqrt6)),
    // Csc(Pi/2)=1
    ISet(Csc(CPiHalf),
      C1),
    // Csc(7/12*Pi)=-Sqrt(2)+Sqrt(6)
    ISet(Csc(Times(QQ(7L,12L),Pi)),
      Plus(Negate(CSqrt2),CSqrt6)),
    // Csc(3/5*Pi)=Sqrt(2-2/Sqrt(5))
    ISet(Csc(Times(QQ(3L,5L),Pi)),
      Sqrt(Plus(C2,Times(CN2,C1DSqrt5)))),
    // Csc(2/3*Pi)=2/Sqrt(3)
    ISet(Csc(Times(QQ(2L,3L),Pi)),
      Times(C2,C1DSqrt3)),
    // Csc(7/10*Pi)=-1+Sqrt(5)
    ISet(Csc(Times(QQ(7L,10L),Pi)),
      Plus(CN1,CSqrt5)),
    // Csc(3/4*Pi)=Sqrt(2)
    ISet(Csc(Times(QQ(3L,4L),Pi)),
      CSqrt2),
    // Csc(4/5*Pi)=Sqrt(2+2/Sqrt(5))
    ISet(Csc(Times(QQ(4L,5L),Pi)),
      Sqrt(Plus(C2,Times(C2,C1DSqrt5)))),
    // Csc(5/6*Pi)=2
    ISet(Csc(Times(QQ(5L,6L),Pi)),
      C2),
    // Csc(9/10*Pi)=1+Sqrt(5)
    ISet(Csc(Times(QQ(9L,10L),Pi)),
      Plus(C1,CSqrt5)),
    // Csc(11/12*Pi)=Sqrt(6)+Sqrt(2)
    ISet(Csc(Times(QQ(11L,12L),Pi)),
      Plus(CSqrt2,CSqrt6)),
    // Csc(Pi)=ComplexInfinity
    ISet(Csc(Pi),
      CComplexInfinity),
    // Csc(11/10*Pi)=-1-Sqrt(5)
    ISet(Csc(Times(QQ(11L,10L),Pi)),
      Subtract(CN1,CSqrt5)),
    // Csc(7/6*Pi)=-2
    ISet(Csc(Times(QQ(7L,6L),Pi)),
      CN2),
    // Csc(6/5*Pi)=-Sqrt(2+2/Sqrt(5))
    ISet(Csc(Times(QQ(6L,5L),Pi)),
      Negate(Sqrt(Plus(C2,Times(C2,C1DSqrt5))))),
    // Csc(5/4*Pi)=-Sqrt(2)
    ISet(Csc(Times(QQ(5L,4L),Pi)),
      Negate(CSqrt2)),
    // Csc(13/10*Pi)=1-Sqrt(5)
    ISet(Csc(Times(QQ(13L,10L),Pi)),
      Subtract(C1,CSqrt5)),
    // Csc(4/3*Pi)=-2/Sqrt(3)
    ISet(Csc(Times(QQ(4L,3L),Pi)),
      Times(CN2,C1DSqrt3)),
    // Csc(17/12*Pi)=Sqrt(2)-Sqrt(6)
    ISet(Csc(Times(QQ(17L,12L),Pi)),
      Subtract(CSqrt2,CSqrt6)),
    // Csc(3/2*Pi)=-1
    ISet(Csc(Times(QQ(3L,2L),Pi)),
      CN1),
    // Csc(19/12*Pi)=Sqrt(2)-Sqrt(6)
    ISet(Csc(Times(QQ(19L,12L),Pi)),
      Subtract(CSqrt2,CSqrt6)),
    // Csc(8/5*Pi)=-Sqrt(2-2/Sqrt(5))
    ISet(Csc(Times(QQ(8L,5L),Pi)),
      Negate(Sqrt(Plus(C2,Times(CN2,C1DSqrt5))))),
    // Csc(5/3*Pi)=-2/Sqrt(3)
    ISet(Csc(Times(QQ(5L,3L),Pi)),
      Times(CN2,C1DSqrt3)),
    // Csc(17/10*Pi)=1-Sqrt(5)
    ISet(Csc(Times(QQ(17L,10L),Pi)),
      Subtract(C1,CSqrt5)),
    // Csc(7/4*Pi)=-Sqrt(2)
    ISet(Csc(Times(QQ(7L,4L),Pi)),
      Negate(CSqrt2)),
    // Csc(9/5*Pi)=-Sqrt(2+2/Sqrt(5))
    ISet(Csc(Times(QQ(9L,5L),Pi)),
      Negate(Sqrt(Plus(C2,Times(C2,C1DSqrt5))))),
    // Csc(11/6*Pi)=-2
    ISet(Csc(Times(QQ(11L,6L),Pi)),
      CN2),
    // Csc(19/10*Pi)=-1-Sqrt(5)
    ISet(Csc(Times(QQ(19L,10L),Pi)),
      Subtract(CN1,CSqrt5)),
    // Csc(23/12*Pi)=-2*Sqrt(2+Sqrt(3))
    ISet(Csc(Times(QQ(23L,12L),Pi)),
      Times(CN2,Sqrt(Plus(C2,CSqrt3)))),
    // Csc(2*Pi)=ComplexInfinity
    ISet(Csc(C2Pi),
      CComplexInfinity),
    // Csc(ArcSin(x_)):=1/x
    ISetDelayed(Csc(ArcSin(x_)),
      Power(x,CN1)),
    // Csc(ArcCos(x_)):=1/Sqrt(1-x^2)
    ISetDelayed(Csc(ArcCos(x_)),
      Power(Subtract(C1,Sqr(x)),CN1D2)),
    // Csc(ArcTan(x_)):=Sqrt(1+x^2)/x
    ISetDelayed(Csc(ArcTan(x_)),
      Times(Power(x,CN1),Sqrt(Plus(C1,Sqr(x))))),
    // Csc(ArcCot(x_)):=Sqrt(1+x^2)
    ISetDelayed(Csc(ArcCot(x_)),
      Sqrt(Plus(C1,Sqr(x)))),
    // Csc(ArcCsc(x_)):=x
    ISetDelayed(Csc(ArcCsc(x_)),
      x),
    // Csc(ArcSec(x_)):=1/Sqrt(1-1/x^2)
    ISetDelayed(Csc(ArcSec(x_)),
      Power(Subtract(C1,Power(x,CN2)),CN1D2)),
    // Csc(I*Infinity)=0
    ISet(Csc(DirectedInfinity(CI)),
      C0),
    // Csc(-I*Infinity)=0
    ISet(Csc(DirectedInfinity(CNI)),
      C0),
    // Csc(ComplexInfinity)=Indeterminate
    ISet(Csc(CComplexInfinity),
      Indeterminate)
  );
}
