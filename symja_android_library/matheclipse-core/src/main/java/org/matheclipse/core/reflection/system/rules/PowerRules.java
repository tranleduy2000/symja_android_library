package org.matheclipse.core.reflection.system.rules;

import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.CC;
import static org.matheclipse.core.expression.F.CComplexInfinity;
import static org.matheclipse.core.expression.F.CI;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CNI;
import static org.matheclipse.core.expression.F.Complex;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Cosh;
import static org.matheclipse.core.expression.F.Cot;
import static org.matheclipse.core.expression.F.Coth;
import static org.matheclipse.core.expression.F.Csc;
import static org.matheclipse.core.expression.F.Csch;
import static org.matheclipse.core.expression.F.DirectedInfinity;
import static org.matheclipse.core.expression.F.Element;
import static org.matheclipse.core.expression.F.Equal;
import static org.matheclipse.core.expression.F.EvenQ;
import static org.matheclipse.core.expression.F.Exp;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.Function;
import static org.matheclipse.core.expression.F.IInit;
import static org.matheclipse.core.expression.F.ISet;
import static org.matheclipse.core.expression.F.ISetDelayed;
import static org.matheclipse.core.expression.F.If;
import static org.matheclipse.core.expression.F.Im;
import static org.matheclipse.core.expression.F.Indeterminate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.Integers;
import static org.matheclipse.core.expression.F.Less;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.Module;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.PatternTest;
import static org.matheclipse.core.expression.F.Pi;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Re;
import static org.matheclipse.core.expression.F.Sec;
import static org.matheclipse.core.expression.F.Sech;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Sinh;
import static org.matheclipse.core.expression.F.Slot1;
import static org.matheclipse.core.expression.F.Tan;
import static org.matheclipse.core.expression.F.Tanh;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.j;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.r;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;

/**
 * <p>Generated by <code>org.matheclipse.core.preprocessor.RulePreprocessor</code>.</p>
 * <p>See GIT repository at: <a href="https://github.com/axkr/symja_android_library">github.com/axkr/symja_android_library under the tools directory</a>.</p>
 */
public interface PowerRules {
    /**
     * <ul>
     * <li>index 0 - number of equal rules in <code>RULES</code></li>
     * </ul>
     */
  final public static int[] SIZES = { 5, 17 };

    final public static IAST RULES = List(
            IInit(Power, SIZES),
    // E^(1/2*I*Pi)=I
    ISet(Exp(Times(CC(0L,1L,1L,2L),Pi)),
      CI),
            // E^(3/2*I*Pi)=-I
            ISet(Exp(Times(CC(0L,1L,3L,2L),Pi)),
                    CNI),
    // E^(I*Pi*n_):=(-1)^n/;Element(n,Integers)
    ISetDelayed(Exp(Times(CI,Pi,n_)),
      Condition(Power(CN1,n),Element(n,Integers))),
            // E^(Pi*c_Complex):=Module({r=Re(c),j=Im(c)},If(EvenQ(j),1,-1)/;r==0&&IntegerQ(j))
            ISetDelayed(Exp(Times(Pi,$p(c,Complex))),
                    Module(List(Set(r,Re(c)),Set(j,Im(c))),Condition(If(EvenQ(j),C1,CN1),And(Equal(r,C0),IntegerQ(j))))),
            // E^(x_+Pi*c_Complex):=Module({r=Re(c),j=Im(c)},If(EvenQ(j),E^x,-E^x)/;r==0&&IntegerQ(j))
            ISetDelayed(Exp(Plus(Times(Pi,$p(c,Complex)),x_)),
                    Module(List(Set(r,Re(c)),Set(j,Im(c))),Condition(If(EvenQ(j),Exp(x),Negate(Exp(x))),And(Equal(r,C0),IntegerQ(j))))),
            // E^(I*Infinity)=Indeterminate
            ISet(Exp(DirectedInfinity(CI)),
                    Indeterminate),
            // E^(-I*Infinity)=Indeterminate
            ISet(Exp(DirectedInfinity(CNI)),
                    Indeterminate),
            // E^ComplexInfinity=Indeterminate
            ISet(Exp(CComplexInfinity),
                    Indeterminate),
            // E^Log(x_):=x
            ISetDelayed(Exp(Log(x_)),
                    x),
            // E^(a_*Log(x_)/;FreeQ(a,x)):=x^a
    ISetDelayed(Exp(Condition(Times(a_,Log(x_)),FreeQ(a,x))),
                    Power(x,a)),
            // Tan(x_)^m_?(IntegerQ(#1)&&#1<0&):=Cot(x)^(-m)
            ISetDelayed(Power(Tan(x_),PatternTest(m_,Function(And(IntegerQ(Slot1),Less(Slot1,C0))))),
                    Power(Cot(x),Negate(m))),
            // Cot(x_)^m_?(IntegerQ(#1)&&#1<0&):=Tan(x)^(-m)
            ISetDelayed(Power(Cot(x_),PatternTest(m_,Function(And(IntegerQ(Slot1),Less(Slot1,C0))))),
                    Power(Tan(x),Negate(m))),
            // Sec(x_)^m_?(IntegerQ(#1)&&#1<0&):=Cos(x)^(-m)
            ISetDelayed(Power(Sec(x_),PatternTest(m_,Function(And(IntegerQ(Slot1),Less(Slot1,C0))))),
                    Power(Cos(x),Negate(m))),
            // Cos(x_)^m_?(IntegerQ(#1)&&#1<0&):=Sec(x)^(-m)
            ISetDelayed(Power(Cos(x_),PatternTest(m_,Function(And(IntegerQ(Slot1),Less(Slot1,C0))))),
                    Power(Sec(x),Negate(m))),
            // Csc(x_)^m_?(IntegerQ(#1)&&#1<0&):=Sin(x)^(-m)
            ISetDelayed(Power(Csc(x_),PatternTest(m_,Function(And(IntegerQ(Slot1),Less(Slot1,C0))))),
                    Power(Sin(x),Negate(m))),
            // Sin(x_)^m_?(IntegerQ(#1)&&#1<0&):=Csc(x)^(-m)
            ISetDelayed(Power(Sin(x_),PatternTest(m_,Function(And(IntegerQ(Slot1),Less(Slot1,C0))))),
      Power(Csc(x),Negate(m))),
    // Tanh(x_)^m_?(IntegerQ(#1)&&#1<0&):=Coth(x)^(-m)
    ISetDelayed(Power(Tanh(x_),PatternTest(m_,Function(And(IntegerQ(Slot1),Less(Slot1,C0))))),
      Power(Coth(x),Negate(m))),
    // Coth(x_)^m_?(IntegerQ(#1)&&#1<0&):=Tanh(x)^(-m)
    ISetDelayed(Power(Coth(x_),PatternTest(m_,Function(And(IntegerQ(Slot1),Less(Slot1,C0))))),
      Power(Tanh(x),Negate(m))),
    // Sech(x_)^m_?(IntegerQ(#1)&&#1<0&):=Cosh(x)^(-m)
    ISetDelayed(Power(Sech(x_),PatternTest(m_,Function(And(IntegerQ(Slot1),Less(Slot1,C0))))),
      Power(Cosh(x),Negate(m))),
    // Cosh(x_)^m_?(IntegerQ(#1)&&#1<0&):=Sech(x)^(-m)
    ISetDelayed(Power(Cosh(x_),PatternTest(m_,Function(And(IntegerQ(Slot1),Less(Slot1,C0))))),
      Power(Sech(x),Negate(m))),
    // Csch(x_)^m_?(IntegerQ(#1)&&#1<0&):=Sinh(x)^(-m)
    ISetDelayed(Power(Csch(x_),PatternTest(m_,Function(And(IntegerQ(Slot1),Less(Slot1,C0))))),
      Power(Sinh(x),Negate(m))),
    // Sinh(x_)^m_?(IntegerQ(#1)&&#1<0&):=Csch(x)^(-m)
    ISetDelayed(Power(Sinh(x_),PatternTest(m_,Function(And(IntegerQ(Slot1),Less(Slot1,C0))))),
      Power(Csch(x),Negate(m)))
    );
}