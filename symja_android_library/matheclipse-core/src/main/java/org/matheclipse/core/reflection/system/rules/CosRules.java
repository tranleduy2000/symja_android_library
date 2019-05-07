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
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C1D3;
import static org.matheclipse.core.expression.F.C1D4;
import static org.matheclipse.core.expression.F.C1DSqrt2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C2Pi;
import static org.matheclipse.core.expression.F.C5;
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
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Cosh;
import static org.matheclipse.core.expression.F.DirectedInfinity;
import static org.matheclipse.core.expression.F.IInit;
import static org.matheclipse.core.expression.F.ISet;
import static org.matheclipse.core.expression.F.ISetDelayed;
import static org.matheclipse.core.expression.F.Indeterminate;
import static org.matheclipse.core.expression.F.Interval;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Noo;
import static org.matheclipse.core.expression.F.Pi;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.QQ;
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
public interface CosRules {
  /**
   * <ul>
   * <li>index 0 - number of equal rules in <code>RULES</code></li>
	 * </ul>
	 */
  final public static int[] SIZES = { 55, 7 };

  final public static IAST RULES = List(
    IInit(Cos, SIZES),
    // Cos(0)=1
    ISet(Cos(C0),
      C1),
    // Cos(Pi/12)=(1+Sqrt(3))/(2*Sqrt(2))
    ISet(Cos(Times(QQ(1L,12L),Pi)),
      Times(C1D2,C1DSqrt2,Plus(C1,CSqrt3))),
    // Cos(Pi/10)=Sqrt(1/2*(5+Sqrt(5)))/2
    ISet(Cos(Times(QQ(1L,10L),Pi)),
      Times(C1D2,Sqrt(Times(C1D2,Plus(C5,CSqrt5))))),
    // Cos(Pi/8)=Sqrt(2+Sqrt(2))/2
    ISet(Cos(Times(QQ(1L,8L),Pi)),
      Times(C1D2,Sqrt(Plus(C2,CSqrt2)))),
    // Cos(Pi/6)=Sqrt(3)/2
    ISet(Cos(Times(QQ(1L,6L),Pi)),
      Times(C1D2,CSqrt3)),
    // Cos(Pi/5)=1/4*(Sqrt(5)+1)
    ISet(Cos(Times(QQ(1L,5L),Pi)),
      Times(C1D4,Plus(C1,CSqrt5))),
    // Cos(Pi/4)=1/Sqrt(2)
    ISet(Cos(Times(C1D4,Pi)),
      C1DSqrt2),
    // Cos(3/10*Pi)=Sqrt(1/2*(5-Sqrt(5)))/2
    ISet(Cos(Times(QQ(3L,10L),Pi)),
      Times(C1D2,Sqrt(Times(C1D2,Subtract(C5,CSqrt5))))),
    // Cos(Pi/3)=1/2
    ISet(Cos(Times(C1D3,Pi)),
      C1D2),
    // Cos(3/8*Pi)=Sqrt(2-Sqrt(2))/2
    ISet(Cos(Times(QQ(3L,8L),Pi)),
      Times(C1D2,Sqrt(Subtract(C2,CSqrt2)))),
    // Cos(2/5*Pi)=1/4*(-1+Sqrt(5))
    ISet(Cos(Times(QQ(2L,5L),Pi)),
      Times(C1D4,Plus(CN1,CSqrt5))),
    // Cos(5/12*Pi)=(-1+Sqrt(3))/(2*Sqrt(2))
    ISet(Cos(Times(QQ(5L,12L),Pi)),
      Times(C1D2,C1DSqrt2,Plus(CN1,CSqrt3))),
    // Cos(Pi/2)=0
    ISet(Cos(CPiHalf),
      C0),
    // Cos(7/12*Pi)=-(-1+Sqrt(3))/(2*Sqrt(2))
    ISet(Cos(Times(QQ(7L,12L),Pi)),
      Times(C1D2,C1DSqrt2,Subtract(C1,CSqrt3))),
    // Cos(3/5*Pi)=-(-1+Sqrt(5))/4
    ISet(Cos(Times(QQ(3L,5L),Pi)),
      Times(C1D4,Subtract(C1,CSqrt5))),
    // Cos(5/8*Pi)=-Sqrt(2-Sqrt(2))/2
    ISet(Cos(Times(QQ(5L,8L),Pi)),
      Times(CN1D2,Sqrt(Subtract(C2,CSqrt2)))),
    // Cos(2/3*Pi)=-1/2
    ISet(Cos(Times(QQ(2L,3L),Pi)),
      CN1D2),
    // Cos(7/10*Pi)=-Sqrt(1/2*(5-Sqrt(5)))/2
    ISet(Cos(Times(QQ(7L,10L),Pi)),
      Times(CN1D2,Sqrt(Times(C1D2,Subtract(C5,CSqrt5))))),
    // Cos(3/4*Pi)=-1/Sqrt(2)
    ISet(Cos(Times(QQ(3L,4L),Pi)),
      Negate(C1DSqrt2)),
    // Cos(4/5*Pi)=-(Sqrt(5)+1)/4
    ISet(Cos(Times(QQ(4L,5L),Pi)),
      Times(C1D4,Subtract(CN1,CSqrt5))),
    // Cos(5/6*Pi)=-Sqrt(3)/2
    ISet(Cos(Times(QQ(5L,6L),Pi)),
      Times(CN1D2,CSqrt3)),
    // Cos(7/8*Pi)=-Sqrt(2+Sqrt(2))/2
    ISet(Cos(Times(QQ(7L,8L),Pi)),
      Times(CN1D2,Sqrt(Plus(C2,CSqrt2)))),
    // Cos(9/10*Pi)=-Sqrt(1/2*(5+Sqrt(5)))/2
    ISet(Cos(Times(QQ(9L,10L),Pi)),
      Times(CN1D2,Sqrt(Times(C1D2,Plus(C5,CSqrt5))))),
    // Cos(11/12*Pi)=-(1+Sqrt(3))/(2*Sqrt(2))
    ISet(Cos(Times(QQ(11L,12L),Pi)),
      Times(C1D2,C1DSqrt2,Subtract(CN1,CSqrt3))),
    // Cos(Pi)=-1
    ISet(Cos(Pi),
      CN1),
    // Cos(13/12*Pi)=-(1+Sqrt(3))/(2*Sqrt(2))
    ISet(Cos(Times(QQ(13L,12L),Pi)),
      Times(C1D2,C1DSqrt2,Subtract(CN1,CSqrt3))),
    // Cos(11/10*Pi)=-Sqrt(1/2*(5+Sqrt(5)))/2
    ISet(Cos(Times(QQ(11L,10L),Pi)),
      Times(CN1D2,Sqrt(Times(C1D2,Plus(C5,CSqrt5))))),
    // Cos(9/8*Pi)=-Sqrt(2+Sqrt(2))/2
    ISet(Cos(Times(QQ(9L,8L),Pi)),
      Times(CN1D2,Sqrt(Plus(C2,CSqrt2)))),
    // Cos(7/6*Pi)=-Sqrt(3)/2
    ISet(Cos(Times(QQ(7L,6L),Pi)),
      Times(CN1D2,CSqrt3)),
    // Cos(6/5*Pi)=-(Sqrt(5)+1)/4
    ISet(Cos(Times(QQ(6L,5L),Pi)),
      Times(C1D4,Subtract(CN1,CSqrt5))),
    // Cos(5/4*Pi)=-1/Sqrt(2)
    ISet(Cos(Times(QQ(5L,4L),Pi)),
      Negate(C1DSqrt2)),
    // Cos(13/10*Pi)=-Sqrt(1/2*(5-Sqrt(5)))/2
    ISet(Cos(Times(QQ(13L,10L),Pi)),
      Times(CN1D2,Sqrt(Times(C1D2,Subtract(C5,CSqrt5))))),
    // Cos(4/3*Pi)=-1/2
    ISet(Cos(Times(QQ(4L,3L),Pi)),
      CN1D2),
    // Cos(11/8*Pi)=-Sqrt(2-Sqrt(2))/2
    ISet(Cos(Times(QQ(11L,8L),Pi)),
      Times(CN1D2,Sqrt(Subtract(C2,CSqrt2)))),
    // Cos(7/5*Pi)=-(-1+Sqrt(5))/4
    ISet(Cos(Times(QQ(7L,5L),Pi)),
      Times(C1D4,Subtract(C1,CSqrt5))),
    // Cos(17/12*Pi)=-(-1+Sqrt(3))/(2*Sqrt(2))
    ISet(Cos(Times(QQ(17L,12L),Pi)),
      Times(C1D2,C1DSqrt2,Subtract(C1,CSqrt3))),
    // Cos(3/2*Pi)=0
    ISet(Cos(Times(QQ(3L,2L),Pi)),
      C0),
    // Cos(19/12*Pi)=(-1+Sqrt(3))/(2*Sqrt(2))
    ISet(Cos(Times(QQ(19L,12L),Pi)),
      Times(C1D2,C1DSqrt2,Plus(CN1,CSqrt3))),
    // Cos(8/5*Pi)=1/4*(-1+Sqrt(5))
    ISet(Cos(Times(QQ(8L,5L),Pi)),
      Times(C1D4,Plus(CN1,CSqrt5))),
    // Cos(13/8*Pi)=Sqrt(2-Sqrt(2))/2
    ISet(Cos(Times(QQ(13L,8L),Pi)),
      Times(C1D2,Sqrt(Subtract(C2,CSqrt2)))),
    // Cos(5/3*Pi)=1/2
    ISet(Cos(Times(QQ(5L,3L),Pi)),
      C1D2),
    // Cos(17/10*Pi)=Sqrt(1/2*(5-Sqrt(5)))/2
    ISet(Cos(Times(QQ(17L,10L),Pi)),
      Times(C1D2,Sqrt(Times(C1D2,Subtract(C5,CSqrt5))))),
    // Cos(7/4*Pi)=1/Sqrt(2)
    ISet(Cos(Times(QQ(7L,4L),Pi)),
      C1DSqrt2),
    // Cos(9/5*Pi)=1/4*(Sqrt(5)+1)
    ISet(Cos(Times(QQ(9L,5L),Pi)),
      Times(C1D4,Plus(C1,CSqrt5))),
    // Cos(11/6*Pi)=Sqrt(3)/2
    ISet(Cos(Times(QQ(11L,6L),Pi)),
      Times(C1D2,CSqrt3)),
    // Cos(15/8*Pi)=Sqrt(2+Sqrt(2))/2
    ISet(Cos(Times(QQ(15L,8L),Pi)),
      Times(C1D2,Sqrt(Plus(C2,CSqrt2)))),
    // Cos(19/10*Pi)=Sqrt(1/2*(5+Sqrt(5)))/2
    ISet(Cos(Times(QQ(19L,10L),Pi)),
      Times(C1D2,Sqrt(Times(C1D2,Plus(C5,CSqrt5))))),
    // Cos(23/12*Pi)=(1+Sqrt(3))/(2*Sqrt(2))
    ISet(Cos(Times(QQ(23L,12L),Pi)),
      Times(C1D2,C1DSqrt2,Plus(C1,CSqrt3))),
    // Cos(2*Pi)=1
    ISet(Cos(C2Pi),
      C1),
    // Cos(I)=Cosh(1)
    ISet(Cos(CI),
      Cosh(C1)),
    // Cos(ArcSin(x_)):=Sqrt(1-x^2)
    ISetDelayed(Cos(ArcSin(x_)),
      Sqrt(Subtract(C1,Sqr(x)))),
    // Cos(ArcCos(x_)):=x
    ISetDelayed(Cos(ArcCos(x_)),
      x),
    // Cos(ArcTan(x_)):=1/Sqrt(1+x^2)
    ISetDelayed(Cos(ArcTan(x_)),
      Power(Plus(C1,Sqr(x)),CN1D2)),
    // Cos(ArcCot(x_)):=x/Sqrt(1+x^2)
    ISetDelayed(Cos(ArcCot(x_)),
      Times(x,Power(Plus(C1,Sqr(x)),CN1D2))),
    // Cos(ArcCsc(x_)):=Sqrt(1-1/x^2)
    ISetDelayed(Cos(ArcCsc(x_)),
      Sqrt(Subtract(C1,Power(x,CN2)))),
    // Cos(ArcSec(x_)):=1/x
    ISetDelayed(Cos(ArcSec(x_)),
      Power(x,CN1)),
    // Cos(Sqrt(x_^2)):=Cos(x)
    ISetDelayed(Cos(Sqrt(Sqr(x_))),
      Cos(x)),
    // Cos(I*Infinity)=Infinity
    ISet(Cos(DirectedInfinity(CI)),
      oo),
    // Cos(-I*Infinity)=Infinity
    ISet(Cos(DirectedInfinity(CNI)),
      oo),
    // Cos(ComplexInfinity)=Indeterminate
    ISet(Cos(CComplexInfinity),
      Indeterminate),
    // Cos(Infinity)=Interval({-1,1})
    ISet(Cos(oo),
      Interval(List(CN1,C1))),
    // Cos(-Infinity)=Interval({-1,1})
    ISet(Cos(Noo),
      Interval(List(CN1,C1)))
  );
}
