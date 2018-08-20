package org.matheclipse.core.reflection.system.rules;

import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.Abs;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcCos;
import static org.matheclipse.core.expression.F.ArcCosh;
import static org.matheclipse.core.expression.F.ArcCot;
import static org.matheclipse.core.expression.F.ArcCoth;
import static org.matheclipse.core.expression.F.ArcCsc;
import static org.matheclipse.core.expression.F.ArcCsch;
import static org.matheclipse.core.expression.F.ArcSec;
import static org.matheclipse.core.expression.F.ArcSech;
import static org.matheclipse.core.expression.F.ArcSin;
import static org.matheclipse.core.expression.F.ArcSinh;
import static org.matheclipse.core.expression.F.ArcTan;
import static org.matheclipse.core.expression.F.*;
import static org.matheclipse.core.expression.F.BernoulliB;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CC;
import static org.matheclipse.core.expression.F.CI;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CNI;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cosh;
import static org.matheclipse.core.expression.F.Cot;
import static org.matheclipse.core.expression.F.Coth;
import static org.matheclipse.core.expression.F.Csch;
import static org.matheclipse.core.expression.F.DirectedInfinity;
import static org.matheclipse.core.expression.F.Direction;
import static org.matheclipse.core.expression.F.E;
import static org.matheclipse.core.expression.F.Equal;
import static org.matheclipse.core.expression.F.EvenQ;
import static org.matheclipse.core.expression.F.Exp;
import static org.matheclipse.core.expression.F.Factorial;
import static org.matheclipse.core.expression.F.Greater;
import static org.matheclipse.core.expression.F.HarmonicNumber;
import static org.matheclipse.core.expression.F.IInit;
import static org.matheclipse.core.expression.F.ISet;
import static org.matheclipse.core.expression.F.ISetDelayed;
import static org.matheclipse.core.expression.F.If;
import static org.matheclipse.core.expression.F.Indeterminate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.Less;
import static org.matheclipse.core.expression.F.Limit;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.Module;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Noo;
import static org.matheclipse.core.expression.F.NumberQ;
import static org.matheclipse.core.expression.F.Pi;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Positive;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.RealNumberQ;
import static org.matheclipse.core.expression.F.Rule;
import static org.matheclipse.core.expression.F.Sech;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sinh;
import static org.matheclipse.core.expression.F.Tan;
import static org.matheclipse.core.expression.F.Tanh;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.oo;
import static org.matheclipse.core.expression.F.s;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.expression.F.y_Symbol;

/**
 * <p>Generated by <code>org.matheclipse.core.preprocessor.RulePreprocessor</code>.</p>
 * <p>See GIT repository at: <a href="https://github.com/axkr/symja_android_library">github.com/axkr/symja_android_library under the tools directory</a>.</p>
 */
public interface LimitRules {
  /**
   * <ul>
   * <li>index 0 - number of equal rules in <code>RULES</code></li>
	 * </ul>
	 */
  final public static int[] SIZES = { 41, 14 };

  final public static IAST RULES = List(
    IInit(Limit, SIZES),
    // Limit(x_*(Sqrt(2*Pi*x_)/x_!)^(1/x_),x_Symbol->Infinity):=E
    ISetDelayed(Limit(Times(x_,Power(Times(Sqrt(Times(C2,Pi,x_)),Power(Factorial(x_),-1)),Power(x_,-1))),Rule(x_Symbol,oo)),
      E),
    // Limit(x_/(x_!)^(1/x_),x_Symbol->Infinity):=E
    ISetDelayed(Limit(Times(x_,Power(Factorial(x_),Negate(Power(x_,-1)))),Rule(x_Symbol,oo)),
      E),
    // Limit(x_^m_RealNumberQ,x_Symbol->Infinity):=If(m<0,0,Infinity)
    ISetDelayed(Limit(Power(x_,$p(m,RealNumberQ)),Rule(x_Symbol,oo)),
      If(Less(m,C0),C0,oo)),
    // Limit(m_NumberQ^x_,x_Symbol->Infinity):=If(m>1,Infinity,If(m==1,1,0))/;Positive(m)
    ISetDelayed(Limit(Power($p(m,NumberQ),x_),Rule(x_Symbol,oo)),
      Condition(If(Greater(m,C1),oo,If(Equal(m,C1),C1,C0)),Positive(m))),
    // Limit(m_NumberQ^(-x_),x_Symbol->Infinity):=0/;m>1
    ISetDelayed(Limit(Power($p(m,NumberQ),Negate(x_)),Rule(x_Symbol,oo)),
      Condition(C0,Greater(m,C1))),
    // Limit(E^x_,x_Symbol->Infinity):=Infinity
    ISetDelayed(Limit(Exp(x_),Rule(x_Symbol,oo)),
      oo),
    // Limit(E^x_,x_Symbol->-Infinity):=0
    ISetDelayed(Limit(Exp(x_),Rule(x_Symbol,Negate(oo))),
      C0),
    // Limit(Log(x_),x_Symbol->0)=-Infinity
    ISet(Limit(Log(x_),Rule(x_Symbol,C0)),
      Noo),
    // Limit(Log(x_),x_Symbol->Infinity)=Infinity
    ISet(Limit(Log(x_),Rule(x_Symbol,oo)),
      oo),
    // Limit(Log(x_),x_Symbol->-Infinity)=Infinity
    ISet(Limit(Log(x_),Rule(x_Symbol,Negate(oo))),
      oo),
    // Limit((1+1/x_)^x_,x_Symbol->Infinity)=E
    ISet(Limit(Power(Plus(C1,Power(x_,-1)),x_),Rule(x_Symbol,oo)),
      E),
    // Limit((1+a_/x_)^x_,x_Symbol->Infinity)=E^a/;FreeQ(a,x)
    ISet(Limit(Power(Plus(C1,Times(a_,Power(x_,-1))),x_),Rule(x_Symbol,oo)),
      Exp(a)),
    // Limit(HarmonicNumber(y_Symbol,s_IntegerQ),x_Symbol->Infinity):=Module({v=s/2},((-1)^(v+1)*(2*Pi)^(2*v)*BernoulliB(2*v))/(2*(2*v)!))/;EvenQ(s)&&Positive(s)
    ISetDelayed(Limit(HarmonicNumber(y_Symbol,$p(s,IntegerQ)),Rule(x_Symbol,oo)),
      Condition(Module(List(Set(v,Times(C1D2,s))),Times(Power(CN1,Plus(v,C1)),Power(Times(C2,Pi),Times(C2,v)),BernoulliB(Times(C2,v)),Power(Times(C2,Factorial(Times(C2,v))),-1))),And(EvenQ(s),Positive(s)))),
    // Limit(Tan(x_),x_Symbol->Pi/2):=Indeterminate
    ISetDelayed(Limit(Tan(x_),Rule(x_Symbol,Times(C1D2,Pi))),
      Indeterminate),
    // Limit(Cot(x_),x_Symbol->0):=Indeterminate
    ISetDelayed(Limit(Cot(x_),Rule(x_Symbol,C0)),
      Indeterminate),
    // Limit(ArcCos(x_),x_Symbol->Infinity)=I*Infinity
    ISet(Limit(ArcCos(x_),Rule(x_Symbol,oo)),
      DirectedInfinity(CI)),
    // Limit(ArcCos(x_),x_Symbol->-Infinity)=-I*Infinity
    ISet(Limit(ArcCos(x_),Rule(x_Symbol,Negate(oo))),
      DirectedInfinity(CNI)),
    // Limit(ArcCot(x_),x_Symbol->Infinity)=0
    ISet(Limit(ArcCot(x_),Rule(x_Symbol,oo)),
      C0),
    // Limit(ArcCot(x_),x_Symbol->-Infinity)=0
    ISet(Limit(ArcCot(x_),Rule(x_Symbol,Negate(oo))),
      C0),
    // Limit(ArcCsc(x_),x_Symbol->Infinity)=0
    ISet(Limit(ArcCsc(x_),Rule(x_Symbol,oo)),
      C0),
    // Limit(ArcCsc(x_),x_Symbol->-Infinity)=0
    ISet(Limit(ArcCsc(x_),Rule(x_Symbol,Negate(oo))),
      C0),
    // Limit(ArcSec(x_),x_Symbol->Infinity)=Pi/2
    ISet(Limit(ArcSec(x_),Rule(x_Symbol,oo)),
      Times(C1D2,Pi)),
    // Limit(ArcSec(x_),x_Symbol->-Infinity)=Pi/2
    ISet(Limit(ArcSec(x_),Rule(x_Symbol,Negate(oo))),
      Times(C1D2,Pi)),
    // Limit(ArcSin(x_),x_Symbol->Infinity)=-I*Infinity
    ISet(Limit(ArcSin(x_),Rule(x_Symbol,oo)),
      DirectedInfinity(CNI)),
    // Limit(ArcSin(x_),x_Symbol->-Infinity)=I*Infinity
    ISet(Limit(ArcSin(x_),Rule(x_Symbol,Negate(oo))),
      DirectedInfinity(CI)),
    // Limit(ArcTan(x_),x_Symbol->Infinity)=Pi/2
    ISet(Limit(ArcTan(x_),Rule(x_Symbol,oo)),
      Times(C1D2,Pi)),
    // Limit(ArcTan(x_),x_Symbol->-Infinity)=(-1)*1/2*Pi
    ISet(Limit(ArcTan(x_),Rule(x_Symbol,Negate(oo))),
      Times(CN1D2,Pi)),
    // Limit(ArcCosh(x_),x_Symbol->Infinity)=Infinity
    ISet(Limit(ArcCosh(x_),Rule(x_Symbol,oo)),
      oo),
    // Limit(ArcCosh(x_),x_Symbol->-Infinity)=Infinity
    ISet(Limit(ArcCosh(x_),Rule(x_Symbol,Negate(oo))),
      oo),
    // Limit(ArcCoth(x_),x_Symbol->Infinity)=0
    ISet(Limit(ArcCoth(x_),Rule(x_Symbol,oo)),
      C0),
    // Limit(ArcCoth(x_),x_Symbol->-Infinity)=0
    ISet(Limit(ArcCoth(x_),Rule(x_Symbol,Negate(oo))),
      C0),
    // Limit(ArcCsch(x_),x_Symbol->Infinity)=0
    ISet(Limit(ArcCsch(x_),Rule(x_Symbol,oo)),
      C0),
    // Limit(ArcCsch(x_),x_Symbol->-Infinity)=0
    ISet(Limit(ArcCsch(x_),Rule(x_Symbol,Negate(oo))),
      C0),
    // Limit(ArcSech(x_),x_Symbol->Infinity)=I*Pi/2
    ISet(Limit(ArcSech(x_),Rule(x_Symbol,oo)),
      Times(CC(0L,1L,1L,2L),Pi)),
    // Limit(ArcSech(x_),x_Symbol->-Infinity)=I*Pi/2
    ISet(Limit(ArcSech(x_),Rule(x_Symbol,Negate(oo))),
      Times(CC(0L,1L,1L,2L),Pi)),
    // Limit(ArcSinh(x_),x_Symbol->Infinity)=Infinity
    ISet(Limit(ArcSinh(x_),Rule(x_Symbol,oo)),
      oo),
    // Limit(ArcSinh(x_),x_Symbol->-Infinity)=-Infinity
    ISet(Limit(ArcSinh(x_),Rule(x_Symbol,Negate(oo))),
      Noo),
    // Limit(ArcTanh(x_),x_Symbol->Infinity)=-I*Pi/2
    ISet(Limit(ArcTanh(x_),Rule(x_Symbol,oo)),
      Times(CC(0L,1L,-1L,2L),Pi)),
    // Limit(ArcTanh(x_),x_Symbol->-Infinity)=I*Pi/2
    ISet(Limit(ArcTanh(x_),Rule(x_Symbol,Negate(oo))),
      Times(CC(0L,1L,1L,2L),Pi)),
    // Limit(Cosh(x_),x_Symbol->Infinity)=Infinity
    ISet(Limit(Cosh(x_),Rule(x_Symbol,oo)),
      oo),
    // Limit(Cosh(x_),x_Symbol->-Infinity)=Infinity
    ISet(Limit(Cosh(x_),Rule(x_Symbol,Negate(oo))),
      oo),
    // Limit(Coth(x_),x_Symbol->Infinity)=1
    ISet(Limit(Coth(x_),Rule(x_Symbol,oo)),
      C1),
    // Limit(Coth(x_),x_Symbol->-Infinity)=-1
    ISet(Limit(Coth(x_),Rule(x_Symbol,Negate(oo))),
      CN1),
    // Limit(Csch(x_),x_Symbol->Infinity)=0
    ISet(Limit(Csch(x_),Rule(x_Symbol,oo)),
      C0),
    // Limit(Csch(x_),x_Symbol->-Infinity)=0
    ISet(Limit(Csch(x_),Rule(x_Symbol,Negate(oo))),
      C0),
    // Limit(Sech(x_),x_Symbol->Infinity)=0
    ISet(Limit(Sech(x_),Rule(x_Symbol,oo)),
      C0),
    // Limit(Sech(x_),x_Symbol->-Infinity)=0
    ISet(Limit(Sech(x_),Rule(x_Symbol,Negate(oo))),
      C0),
    // Limit(Sinh(x_),x_Symbol->Infinity)=Infinity
    ISet(Limit(Sinh(x_),Rule(x_Symbol,oo)),
      oo),
    // Limit(Sinh(x_),x_Symbol->-Infinity)=-Infinity
    ISet(Limit(Sinh(x_),Rule(x_Symbol,Negate(oo))),
      Noo),
    // Limit(Tanh(x_),x_Symbol->Infinity)=1
    ISet(Limit(Tanh(x_),Rule(x_Symbol,oo)),
      C1),
    // Limit(Tanh(x_),x_Symbol->-Infinity)=-1
    ISet(Limit(Tanh(x_),Rule(x_Symbol,Negate(oo))),
      CN1),
    // Limit(x_/Abs(x_),x_Symbol->0,Direction->1):=-1
    ISetDelayed(Limit(Times(x_,Power(Abs(x_),-1)),Rule(x_Symbol,C0),Rule(Direction,C1)),
      CN1),
    // Limit(x_/Abs(x_),x_Symbol->0,Direction->-1):=1
    ISetDelayed(Limit(Times(x_,Power(Abs(x_),-1)),Rule(x_Symbol,C0),Rule(Direction,CN1)),
      C1),
    // Limit(Tan(x_),x_Symbol->Pi/2,Direction->1):=Infinity
    ISetDelayed(Limit(Tan(x_),Rule(x_Symbol,Times(C1D2,Pi)),Rule(Direction,C1)),
      oo),
    // Limit(Tan(x_),x_Symbol->Pi/2,Direction->-1):=-Infinity
    ISetDelayed(Limit(Tan(x_),Rule(x_Symbol,Times(C1D2,Pi)),Rule(Direction,CN1)),
      Negate(oo)),
    // Limit(Cot(x_),x_Symbol->0,Direction->1):=-Infinity
    ISetDelayed(Limit(Cot(x_),Rule(x_Symbol,C0),Rule(Direction,C1)),
      Negate(oo)),
    // Limit(Cot(x_),x_Symbol->0,Direction->-1):=Infinity
    ISetDelayed(Limit(Cot(x_),Rule(x_Symbol,C0),Rule(Direction,CN1)),
      oo)
  );
}
