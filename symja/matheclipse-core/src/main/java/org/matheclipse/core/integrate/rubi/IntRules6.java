package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C1D4;
import static org.matheclipse.core.expression.F.C1DSqrt2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN1D4;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.CSqrt2;
import static org.matheclipse.core.expression.F.CSqrt3;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Numerator;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.QQ;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Simplify;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.k;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.r;
import static org.matheclipse.core.expression.F.s;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntBinomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NegQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PolynomialDivide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumSimplerQ;

/** 
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class IntRules6 { 
  public static IAST RULES = List( 
IIntegrate(301,Int(Times(Power(x_,m_),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),-1)),x_Symbol),
    Condition(With(List(Set(r,Numerator(Rt(Times(CN1,a,Power(b,-1)),C2))),Set(s,Denominator(Rt(Times(CN1,a,Power(b,-1)),C2)))),Plus(Dist(Times(s,Power(Times(C2,b),-1)),Int(Times(Power(x,Plus(m,Times(CN1,C1D2,n))),Power(Plus(r,Times(s,Power(x,Times(C1D2,n)))),-1)),x),x),Negate(Dist(Times(s,Power(Times(C2,b),-1)),Int(Times(Power(x,Plus(m,Times(CN1,C1D2,n))),Power(Plus(r,Times(CN1,s,Power(x,Times(C1D2,n)))),-1)),x),x)))),And(FreeQ(List(a,b),x),IGtQ(Times(C1D4,n),C0),IGtQ(m,C0),LeQ(Times(C1D2,n),m),LtQ(m,n),Not(GtQ(Times(a,Power(b,-1)),C0))))),
IIntegrate(302,Int(Times(Power(x_,m_),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),-1)),x_Symbol),
    Condition(Int(PolynomialDivide(Power(x,m),Plus(a,Times(b,Power(x,n))),x),x),And(FreeQ(List(a,b),x),IGtQ(m,C0),IGtQ(n,C0),GtQ(m,Plus(Times(C2,n),Negate(C1)))))),
IIntegrate(303,Int(Times(x_,Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),CN1D2)),x_Symbol),
    Condition(With(List(Set(r,$($s("§numer"),Rt(Times(b,Power(a,-1)),C3))),Set(s,$($s("§denom"),Rt(Times(b,Power(a,-1)),C3)))),Plus(Dist(Times(CSqrt2,s,Power(Times(Sqrt(Plus(C2,CSqrt3)),r),-1)),Int(Power(Plus(a,Times(b,Power(x,3))),CN1D2),x),x),Dist(Power(r,-1),Int(Times(Plus(Times(Plus(C1,Negate(CSqrt3)),s),Times(r,x)),Power(Plus(a,Times(b,Power(x,3))),CN1D2)),x),x))),And(FreeQ(List(a,b),x),PosQ(a)))),
IIntegrate(304,Int(Times(x_,Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),CN1D2)),x_Symbol),
    Condition(With(List(Set(r,$($s("§numer"),Rt(Times(b,Power(a,-1)),C3))),Set(s,$($s("§denom"),Rt(Times(b,Power(a,-1)),C3)))),Plus(Negate(Dist(Times(CSqrt2,s,Power(Times(Sqrt(Plus(C2,Negate(CSqrt3))),r),-1)),Int(Power(Plus(a,Times(b,Power(x,3))),CN1D2),x),x)),Dist(Power(r,-1),Int(Times(Plus(Times(Plus(C1,CSqrt3),s),Times(r,x)),Power(Plus(a,Times(b,Power(x,3))),CN1D2)),x),x))),And(FreeQ(List(a,b),x),NegQ(a)))),
IIntegrate(305,Int(Times(Sqr(x_),Power(Plus(a_,Times(b_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(b,Power(a,-1)),C2))),Plus(Dist(Power(q,-1),Int(Power(Plus(a,Times(b,Power(x,4))),CN1D2),x),x),Negate(Dist(Power(q,-1),Int(Times(Plus(C1,Times(CN1,q,Sqr(x))),Power(Plus(a,Times(b,Power(x,4))),CN1D2)),x),x)))),And(FreeQ(List(a,b),x),PosQ(Times(b,Power(a,-1)))))),
IIntegrate(306,Int(Times(Sqr(x_),Power(Plus(a_,Times(b_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(CN1,b,Power(a,-1)),C2))),Plus(Dist(Power(q,-1),Int(Power(Plus(a,Times(b,Power(x,4))),CN1D2),x),x),Negate(Dist(Power(q,-1),Int(Times(Plus(C1,Times(CN1,q,Sqr(x))),Power(Plus(a,Times(b,Power(x,4))),CN1D2)),x),x)))),And(FreeQ(List(a,b),x),LtQ(a,C0),GtQ(b,C0)))),
IIntegrate(307,Int(Times(Sqr(x_),Power(Plus(a_,Times(b_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(CN1,b,Power(a,-1)),C2))),Plus(Negate(Dist(Power(q,-1),Int(Power(Plus(a,Times(b,Power(x,4))),CN1D2),x),x)),Dist(Power(q,-1),Int(Times(Plus(C1,Times(q,Sqr(x))),Power(Plus(a,Times(b,Power(x,4))),CN1D2)),x),x))),And(FreeQ(List(a,b),x),NegQ(Times(b,Power(a,-1)))))),
IIntegrate(308,Int(Times(Power(x_,4),Power(Plus(a_,Times(b_DEFAULT,Power(x_,6))),CN1D2)),x_Symbol),
    Condition(With(List(Set(r,$($s("§numer"),Rt(Times(b,Power(a,-1)),C3))),Set(s,$($s("§denom"),Rt(Times(b,Power(a,-1)),C3)))),Plus(Dist(Times(Plus(CSqrt3,Negate(C1)),Sqr(s),Power(Times(C2,Sqr(r)),-1)),Int(Power(Plus(a,Times(b,Power(x,6))),CN1D2),x),x),Negate(Dist(Power(Times(C2,Sqr(r)),-1),Int(Times(Plus(Times(Plus(CSqrt3,Negate(C1)),Sqr(s)),Times(CN1,C2,Sqr(r),Power(x,4))),Power(Plus(a,Times(b,Power(x,6))),CN1D2)),x),x)))),FreeQ(List(a,b),x))),
IIntegrate(309,Int(Times(Sqr(x_),Power(Plus(a_,Times(b_DEFAULT,Power(x_,8))),CN1D2)),x_Symbol),
    Condition(Plus(Dist(Power(Times(C2,Rt(Times(b,Power(a,-1)),C4)),-1),Int(Times(Plus(C1,Times(Rt(Times(b,Power(a,-1)),C4),Sqr(x))),Power(Plus(a,Times(b,Power(x,8))),CN1D2)),x),x),Negate(Dist(Power(Times(C2,Rt(Times(b,Power(a,-1)),C4)),-1),Int(Times(Plus(C1,Times(CN1,Rt(Times(b,Power(a,-1)),C4),Sqr(x))),Power(Plus(a,Times(b,Power(x,8))),CN1D2)),x),x))),FreeQ(List(a,b),x))),
IIntegrate(310,Int(Times(Sqr(x_),Power(Plus(a_,Times(b_DEFAULT,Power(x_,4))),CN1D4)),x_Symbol),
    Condition(Plus(Simp(Times(Power(x,3),Power(Times(C2,Power(Plus(a,Times(b,Power(x,4))),C1D4)),-1)),x),Negate(Dist(Times(C1D2,a),Int(Times(Sqr(x),Power(Plus(a,Times(b,Power(x,4))),QQ(-5L,4L))),x),x))),And(FreeQ(List(a,b),x),PosQ(Times(b,Power(a,-1)))))),
IIntegrate(311,Int(Times(Sqr(x_),Power(Plus(a_,Times(b_DEFAULT,Power(x_,4))),CN1D4)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(a,Times(b,Power(x,4))),QQ(3L,4L)),Power(Times(C2,b,x),-1)),x),Dist(Times(a,Power(Times(C2,b),-1)),Int(Power(Times(Sqr(x),Power(Plus(a,Times(b,Power(x,4))),C1D4)),-1),x),x)),And(FreeQ(List(a,b),x),NegQ(Times(b,Power(a,-1)))))),
IIntegrate(312,Int(Times(Power(x_,-2),Power(Plus(a_,Times(b_DEFAULT,Power(x_,4))),CN1D4)),x_Symbol),
    Condition(Plus(Negate(Simp(Power(Times(x,Power(Plus(a,Times(b,Power(x,4))),C1D4)),-1),x)),Negate(Dist(b,Int(Times(Sqr(x),Power(Plus(a,Times(b,Power(x,4))),QQ(-5L,4L))),x),x))),And(FreeQ(List(a,b),x),PosQ(Times(b,Power(a,-1)))))),
IIntegrate(313,Int(Times(Power(x_,-2),Power(Plus(a_,Times(b_DEFAULT,Power(x_,4))),CN1D4)),x_Symbol),
    Condition(Dist(Times(x,Power(Plus(C1,Times(a,Power(Times(b,Power(x,4)),-1))),C1D4),Power(Plus(a,Times(b,Power(x,4))),CN1D4)),Int(Power(Times(Power(x,3),Power(Plus(C1,Times(a,Power(Times(b,Power(x,4)),-1))),C1D4)),-1),x),x),And(FreeQ(List(a,b),x),NegQ(Times(b,Power(a,-1)))))),
IIntegrate(314,Int(Times(Sqrt(Times(c_,x_)),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_))),CN1D4)),x_Symbol),
    Condition(Plus(Simp(Times(x,Sqrt(Times(c,x)),Power(Plus(a,Times(b,Sqr(x))),CN1D4)),x),Negate(Dist(Times(C1D2,a),Int(Times(Sqrt(Times(c,x)),Power(Plus(a,Times(b,Sqr(x))),QQ(-5L,4L))),x),x))),And(FreeQ(List(a,b,c),x),PosQ(Times(b,Power(a,-1)))))),
IIntegrate(315,Int(Times(Sqrt(Times(c_,x_)),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_))),CN1D4)),x_Symbol),
    Condition(Plus(Simp(Times(c,Power(Plus(a,Times(b,Sqr(x))),QQ(3L,4L)),Power(Times(b,Sqrt(Times(c,x))),-1)),x),Dist(Times(a,Sqr(c),Power(Times(C2,b),-1)),Int(Power(Times(Power(Times(c,x),QQ(3L,2L)),Power(Plus(a,Times(b,Sqr(x))),C1D4)),-1),x),x)),And(FreeQ(List(a,b,c),x),NegQ(Times(b,Power(a,-1)))))),
IIntegrate(316,Int(Times(Power(Times(c_DEFAULT,x_),QQ(-3L,2L)),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_))),CN1D4)),x_Symbol),
    Condition(Plus(Simp(Times(CN2,Power(Times(c,Sqrt(Times(c,x)),Power(Plus(a,Times(b,Sqr(x))),C1D4)),-1)),x),Negate(Dist(Times(b,Power(c,-2)),Int(Times(Sqrt(Times(c,x)),Power(Plus(a,Times(b,Sqr(x))),QQ(-5L,4L))),x),x))),And(FreeQ(List(a,b,c),x),PosQ(Times(b,Power(a,-1)))))),
IIntegrate(317,Int(Times(Power(Times(c_DEFAULT,x_),QQ(-3L,2L)),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_))),CN1D4)),x_Symbol),
    Condition(Dist(Times(Sqrt(Times(c,x)),Power(Plus(C1,Times(a,Power(Times(b,Sqr(x)),-1))),C1D4),Power(Times(Sqr(c),Power(Plus(a,Times(b,Sqr(x))),C1D4)),-1)),Int(Power(Times(Sqr(x),Power(Plus(C1,Times(a,Power(Times(b,Sqr(x)),-1))),C1D4)),-1),x),x),And(FreeQ(List(a,b,c),x),NegQ(Times(b,Power(a,-1)))))),
IIntegrate(318,Int(Times(Sqrt(x_),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_))),CN1D2)),x_Symbol),
    Condition(Dist(Times(CN2,Power(Times(Sqrt(a),Power(Times(CN1,b,Power(a,-1)),QQ(3L,4L))),-1)),Subst(Int(Times(Sqrt(Plus(C1,Times(CN1,C2,Sqr(x)))),Power(Plus(C1,Negate(Sqr(x))),CN1D2)),x),x,Times(Sqrt(Plus(C1,Times(CN1,Sqrt(Times(CN1,b,Power(a,-1))),x))),C1DSqrt2)),x),And(FreeQ(List(a,b),x),GtQ(Times(CN1,b,Power(a,-1)),C0),GtQ(a,C0)))),
IIntegrate(319,Int(Times(Sqrt(x_),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_))),CN1D2)),x_Symbol),
    Condition(Dist(Times(Sqrt(Plus(C1,Times(b,Sqr(x),Power(a,-1)))),Power(Plus(a,Times(b,Sqr(x))),CN1D2)),Int(Times(Sqrt(x),Power(Plus(C1,Times(b,Sqr(x),Power(a,-1))),CN1D2)),x),x),And(FreeQ(List(a,b),x),GtQ(Times(CN1,b,Power(a,-1)),C0),Not(GtQ(a,C0))))),
IIntegrate(320,Int(Times(Sqrt(Times(c_,x_)),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_))),CN1D2)),x_Symbol),
    Condition(Dist(Times(Sqrt(Times(c,x)),Power(x,CN1D2)),Int(Times(Sqrt(x),Power(Plus(a,Times(b,Sqr(x))),CN1D2)),x),x),And(FreeQ(List(a,b,c),x),GtQ(Times(CN1,b,Power(a,-1)),C0)))),
IIntegrate(321,Int(Times(Power(Times(c_DEFAULT,x_),m_),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(c,Plus(n,Negate(C1))),Power(Times(c,x),Plus(m,Negate(n),C1)),Power(Plus(a,Times(b,Power(x,n))),Plus(p,C1)),Power(Times(b,Plus(m,Times(n,p),C1)),-1)),x),Negate(Dist(Times(a,Power(c,n),Plus(m,Negate(n),C1),Power(Times(b,Plus(m,Times(n,p),C1)),-1)),Int(Times(Power(Times(c,x),Plus(m,Negate(n))),Power(Plus(a,Times(b,Power(x,n))),p)),x),x))),And(FreeQ(List(a,b,c,p),x),IGtQ(n,C0),GtQ(m,Plus(n,Negate(C1))),NeQ(Plus(m,Times(n,p),C1),C0),IntBinomialQ(a,b,c,n,m,p,x)))),
IIntegrate(322,Int(Times(Power(Times(c_DEFAULT,x_),m_),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(c,Plus(n,Negate(C1))),Power(Times(c,x),Plus(m,Negate(n),C1)),Power(Plus(a,Times(b,Power(x,n))),Plus(p,C1)),Power(Times(b,Plus(m,Times(n,p),C1)),-1)),x),Negate(Dist(Times(a,Power(c,n),Plus(m,Negate(n),C1),Power(Times(b,Plus(m,Times(n,p),C1)),-1)),Int(Times(Power(Times(c,x),Plus(m,Negate(n))),Power(Plus(a,Times(b,Power(x,n))),p)),x),x))),And(FreeQ(List(a,b,c,m,p),x),IGtQ(n,C0),SumSimplerQ(m,Negate(n)),NeQ(Plus(m,Times(n,p),C1),C0),ILtQ(Simplify(Plus(Times(Plus(m,C1),Power(n,-1)),p)),C0)))),
IIntegrate(323,Int(Times(Power(Times(c_DEFAULT,x_),m_),Power(Plus($p("a1"),Times($p("b1",true),Power(x_,n_))),p_),Power(Plus($p("a2"),Times($p("b2",true),Power(x_,n_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(c,Plus(Times(C2,n),Negate(C1))),Power(Times(c,x),Plus(m,Times(CN1,C2,n),C1)),Power(Plus($s("a1"),Times($s("b1"),Power(x,n))),Plus(p,C1)),Power(Plus($s("a2"),Times($s("b2"),Power(x,n))),Plus(p,C1)),Power(Times($s("b1"),$s("b2"),Plus(m,Times(C2,n,p),C1)),-1)),x),Negate(Dist(Times($s("a1"),$s("a2"),Power(c,Times(C2,n)),Plus(m,Times(CN1,C2,n),C1),Power(Times($s("b1"),$s("b2"),Plus(m,Times(C2,n,p),C1)),-1)),Int(Times(Power(Times(c,x),Plus(m,Times(CN1,C2,n))),Power(Plus($s("a1"),Times($s("b1"),Power(x,n))),p),Power(Plus($s("a2"),Times($s("b2"),Power(x,n))),p)),x),x))),And(FreeQ(List($s("a1"),$s("b1"),$s("a2"),$s("b2"),c,p),x),EqQ(Plus(Times($s("a2"),$s("b1")),Times($s("a1"),$s("b2"))),C0),IGtQ(Times(C2,n),C0),GtQ(m,Plus(Times(C2,n),Negate(C1))),NeQ(Plus(m,Times(C2,n,p),C1),C0),IntBinomialQ(Times($s("a1"),$s("a2")),Times($s("b1"),$s("b2")),c,Times(C2,n),m,p,x)))),
IIntegrate(324,Int(Times(Power(Times(c_DEFAULT,x_),m_),Power(Plus($p("a1"),Times($p("b1",true),Power(x_,n_))),p_),Power(Plus($p("a2"),Times($p("b2",true),Power(x_,n_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(c,Plus(Times(C2,n),Negate(C1))),Power(Times(c,x),Plus(m,Times(CN1,C2,n),C1)),Power(Plus($s("a1"),Times($s("b1"),Power(x,n))),Plus(p,C1)),Power(Plus($s("a2"),Times($s("b2"),Power(x,n))),Plus(p,C1)),Power(Times($s("b1"),$s("b2"),Plus(m,Times(C2,n,p),C1)),-1)),x),Negate(Dist(Times($s("a1"),$s("a2"),Power(c,Times(C2,n)),Plus(m,Times(CN1,C2,n),C1),Power(Times($s("b1"),$s("b2"),Plus(m,Times(C2,n,p),C1)),-1)),Int(Times(Power(Times(c,x),Plus(m,Times(CN1,C2,n))),Power(Plus($s("a1"),Times($s("b1"),Power(x,n))),p),Power(Plus($s("a2"),Times($s("b2"),Power(x,n))),p)),x),x))),And(FreeQ(List($s("a1"),$s("b1"),$s("a2"),$s("b2"),c,m,p),x),EqQ(Plus(Times($s("a2"),$s("b1")),Times($s("a1"),$s("b2"))),C0),IGtQ(Times(C2,n),C0),SumSimplerQ(m,Times(CN2,n)),NeQ(Plus(m,Times(C2,n,p),C1),C0),ILtQ(Simplify(Plus(Times(Plus(m,C1),Power(Times(C2,n),-1)),p)),C0)))),
IIntegrate(325,Int(Times(Power(Times(c_DEFAULT,x_),m_),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(c,x),Plus(m,C1)),Power(Plus(a,Times(b,Power(x,n))),Plus(p,C1)),Power(Times(a,c,Plus(m,C1)),-1)),x),Negate(Dist(Times(b,Plus(m,Times(n,Plus(p,C1)),C1),Power(Times(a,Power(c,n),Plus(m,C1)),-1)),Int(Times(Power(Times(c,x),Plus(m,n)),Power(Plus(a,Times(b,Power(x,n))),p)),x),x))),And(FreeQ(List(a,b,c,p),x),IGtQ(n,C0),LtQ(m,CN1),IntBinomialQ(a,b,c,n,m,p,x)))),
IIntegrate(326,Int(Times(Power(Times(c_DEFAULT,x_),m_),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(c,x),Plus(m,C1)),Power(Plus(a,Times(b,Power(x,n))),Plus(p,C1)),Power(Times(a,c,Plus(m,C1)),-1)),x),Negate(Dist(Times(b,Plus(m,Times(n,Plus(p,C1)),C1),Power(Times(a,Power(c,n),Plus(m,C1)),-1)),Int(Times(Power(Times(c,x),Plus(m,n)),Power(Plus(a,Times(b,Power(x,n))),p)),x),x))),And(FreeQ(List(a,b,c,m,p),x),IGtQ(n,C0),SumSimplerQ(m,n),ILtQ(Simplify(Plus(Times(Plus(m,C1),Power(n,-1)),p)),C0)))),
IIntegrate(327,Int(Times(Power(Times(c_DEFAULT,x_),m_),Power(Plus($p("a1"),Times($p("b1",true),Power(x_,n_))),p_),Power(Plus($p("a2"),Times($p("b2",true),Power(x_,n_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(c,x),Plus(m,C1)),Power(Plus($s("a1"),Times($s("b1"),Power(x,n))),Plus(p,C1)),Power(Plus($s("a2"),Times($s("b2"),Power(x,n))),Plus(p,C1)),Power(Times($s("a1"),$s("a2"),c,Plus(m,C1)),-1)),x),Negate(Dist(Times($s("b1"),$s("b2"),Plus(m,Times(C2,n,Plus(p,C1)),C1),Power(Times($s("a1"),$s("a2"),Power(c,Times(C2,n)),Plus(m,C1)),-1)),Int(Times(Power(Times(c,x),Plus(m,Times(C2,n))),Power(Plus($s("a1"),Times($s("b1"),Power(x,n))),p),Power(Plus($s("a2"),Times($s("b2"),Power(x,n))),p)),x),x))),And(FreeQ(List($s("a1"),$s("b1"),$s("a2"),$s("b2"),c,p),x),EqQ(Plus(Times($s("a2"),$s("b1")),Times($s("a1"),$s("b2"))),C0),IGtQ(Times(C2,n),C0),LtQ(m,CN1),IntBinomialQ(Times($s("a1"),$s("a2")),Times($s("b1"),$s("b2")),c,Times(C2,n),m,p,x)))),
IIntegrate(328,Int(Times(Power(Times(c_DEFAULT,x_),m_),Power(Plus($p("a1"),Times($p("b1",true),Power(x_,n_))),p_),Power(Plus($p("a2"),Times($p("b2",true),Power(x_,n_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(c,x),Plus(m,C1)),Power(Plus($s("a1"),Times($s("b1"),Power(x,n))),Plus(p,C1)),Power(Plus($s("a2"),Times($s("b2"),Power(x,n))),Plus(p,C1)),Power(Times($s("a1"),$s("a2"),c,Plus(m,C1)),-1)),x),Negate(Dist(Times($s("b1"),$s("b2"),Plus(m,Times(C2,n,Plus(p,C1)),C1),Power(Times($s("a1"),$s("a2"),Power(c,Times(C2,n)),Plus(m,C1)),-1)),Int(Times(Power(Times(c,x),Plus(m,Times(C2,n))),Power(Plus($s("a1"),Times($s("b1"),Power(x,n))),p),Power(Plus($s("a2"),Times($s("b2"),Power(x,n))),p)),x),x))),And(FreeQ(List($s("a1"),$s("b1"),$s("a2"),$s("b2"),c,m,p),x),EqQ(Plus(Times($s("a2"),$s("b1")),Times($s("a1"),$s("b2"))),C0),IGtQ(Times(C2,n),C0),SumSimplerQ(m,Times(C2,n)),ILtQ(Simplify(Plus(Times(Plus(m,C1),Power(Times(C2,n),-1)),p)),C0)))),
IIntegrate(329,Int(Times(Power(Times(c_DEFAULT,x_),m_),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_)),x_Symbol),
    Condition(With(List(Set(k,Denominator(m))),Dist(Times(k,Power(c,-1)),Subst(Int(Times(Power(x,Plus(Times(k,Plus(m,C1)),Negate(C1))),Power(Plus(a,Times(b,Power(x,Times(k,n)),Power(Power(c,n),-1))),p)),x),x,Power(Times(c,x),Power(k,-1))),x)),And(FreeQ(List(a,b,c,p),x),IGtQ(n,C0),FractionQ(m),IntBinomialQ(a,b,c,n,m,p,x)))),
IIntegrate(330,Int(Times(Power(Times(c_DEFAULT,x_),m_),Power(Plus($p("a1"),Times($p("b1",true),Power(x_,n_))),p_),Power(Plus($p("a2"),Times($p("b2",true),Power(x_,n_))),p_)),x_Symbol),
    Condition(With(List(Set(k,Denominator(m))),Dist(Times(k,Power(c,-1)),Subst(Int(Times(Power(x,Plus(Times(k,Plus(m,C1)),Negate(C1))),Power(Plus($s("a1"),Times($s("b1"),Power(x,Times(k,n)),Power(Power(c,n),-1))),p),Power(Plus($s("a2"),Times($s("b2"),Power(x,Times(k,n)),Power(Power(c,n),-1))),p)),x),x,Power(Times(c,x),Power(k,-1))),x)),And(FreeQ(List($s("a1"),$s("b1"),$s("a2"),$s("b2"),c,p),x),EqQ(Plus(Times($s("a2"),$s("b1")),Times($s("a1"),$s("b2"))),C0),IGtQ(Times(C2,n),C0),FractionQ(m),IntBinomialQ(Times($s("a1"),$s("a2")),Times($s("b1"),$s("b2")),c,Times(C2,n),m,p,x)))),
IIntegrate(331,Int(Times(Power(x_,m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_)),x_Symbol),
    Condition(Dist(Power(a,Plus(p,Times(Plus(m,C1),Power(n,-1)))),Subst(Int(Times(Power(x,m),Power(Power(Plus(C1,Times(CN1,b,Power(x,n))),Plus(p,Times(Plus(m,C1),Power(n,-1)),C1)),-1)),x),x,Times(x,Power(Power(Plus(a,Times(b,Power(x,n))),Power(n,-1)),-1))),x),And(FreeQ(List(a,b),x),IGtQ(n,C0),LtQ(CN1,p,C0),NeQ(p,Negate(Power(C2,-1))),IntegersQ(m,Plus(p,Times(Plus(m,C1),Power(n,-1))))))),
IIntegrate(332,Int(Times(Power(x_,m_DEFAULT),Power(Plus($p("a1"),Times($p("b1",true),Power(x_,n_))),p_),Power(Plus($p("a2"),Times($p("b2",true),Power(x_,n_))),p_)),x_Symbol),
    Condition(Dist(Power(Times($s("a1"),$s("a2")),Plus(p,Times(Plus(m,C1),Power(Times(C2,n),-1)))),Subst(Int(Times(Power(x,m),Power(Times(Power(Plus(C1,Times(CN1,$s("b1"),Power(x,n))),Plus(p,Times(Plus(m,C1),Power(Times(C2,n),-1)),C1)),Power(Plus(C1,Times(CN1,$s("b2"),Power(x,n))),Plus(p,Times(Plus(m,C1),Power(Times(C2,n),-1)),C1))),-1)),x),x,Times(x,Power(Times(Power(Plus($s("a1"),Times($s("b1"),Power(x,n))),Power(Times(C2,n),-1)),Power(Plus($s("a2"),Times($s("b2"),Power(x,n))),Power(Times(C2,n),-1))),-1))),x),And(FreeQ(List($s("a1"),$s("b1"),$s("a2"),$s("b2")),x),EqQ(Plus(Times($s("a2"),$s("b1")),Times($s("a1"),$s("b2"))),C0),IGtQ(Times(C2,n),C0),LtQ(CN1,p,C0),NeQ(p,Negate(Power(C2,-1))),IntegersQ(m,Plus(p,Times(Plus(m,C1),Power(Times(C2,n),-1))))))),
IIntegrate(333,Int(Times(Power(x_,m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_)),x_Symbol),
    Condition(Dist(Times(Power(Times(a,Power(Plus(a,Times(b,Power(x,n))),-1)),Plus(p,Times(Plus(m,C1),Power(n,-1)))),Power(Plus(a,Times(b,Power(x,n))),Plus(p,Times(Plus(m,C1),Power(n,-1))))),Subst(Int(Times(Power(x,m),Power(Power(Plus(C1,Times(CN1,b,Power(x,n))),Plus(p,Times(Plus(m,C1),Power(n,-1)),C1)),-1)),x),x,Times(x,Power(Power(Plus(a,Times(b,Power(x,n))),Power(n,-1)),-1))),x),And(FreeQ(List(a,b),x),IGtQ(n,C0),LtQ(CN1,p,C0),NeQ(p,Negate(Power(C2,-1))),IntegerQ(m),LtQ(Denominator(Plus(p,Times(Plus(m,C1),Power(n,-1)))),Denominator(p))))),
IIntegrate(334,Int(Times(Power(x_,m_DEFAULT),Power(Plus($p("a1"),Times($p("b1",true),Power(x_,n_))),p_),Power(Plus($p("a2"),Times($p("b2",true),Power(x_,n_))),p_)),x_Symbol),
    Condition(Dist(Times(Power(Times($s("a1"),Power(Plus($s("a1"),Times($s("b1"),Power(x,n))),-1)),Plus(p,Times(Plus(m,C1),Power(Times(C2,n),-1)))),Power(Plus($s("a1"),Times($s("b1"),Power(x,n))),Plus(p,Times(Plus(m,C1),Power(Times(C2,n),-1)))),Power(Times($s("a2"),Power(Plus($s("a2"),Times($s("b2"),Power(x,n))),-1)),Plus(p,Times(Plus(m,C1),Power(Times(C2,n),-1)))),Power(Plus($s("a2"),Times($s("b2"),Power(x,n))),Plus(p,Times(Plus(m,C1),Power(Times(C2,n),-1))))),Subst(Int(Times(Power(x,m),Power(Times(Power(Plus(C1,Times(CN1,$s("b1"),Power(x,n))),Plus(p,Times(Plus(m,C1),Power(Times(C2,n),-1)),C1)),Power(Plus(C1,Times(CN1,$s("b2"),Power(x,n))),Plus(p,Times(Plus(m,C1),Power(Times(C2,n),-1)),C1))),-1)),x),x,Times(x,Power(Times(Power(Plus($s("a1"),Times($s("b1"),Power(x,n))),Power(Times(C2,n),-1)),Power(Plus($s("a2"),Times($s("b2"),Power(x,n))),Power(Times(C2,n),-1))),-1))),x),And(FreeQ(List($s("a1"),$s("b1"),$s("a2"),$s("b2")),x),EqQ(Plus(Times($s("a2"),$s("b1")),Times($s("a1"),$s("b2"))),C0),IGtQ(Times(C2,n),C0),LtQ(CN1,p,C0),NeQ(p,Negate(Power(C2,-1))),IntegerQ(m),LtQ(Denominator(Plus(p,Times(Plus(m,C1),Power(Times(C2,n),-1)))),Denominator(p))))),
IIntegrate(335,Int(Times(Power(x_,m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_)),x_Symbol),
    Condition(Negate(Subst(Int(Times(Power(Plus(a,Times(b,Power(Power(x,n),-1))),p),Power(Power(x,Plus(m,C2)),-1)),x),x,Power(x,-1))),And(FreeQ(List(a,b,p),x),ILtQ(n,C0),IntegerQ(m)))),
IIntegrate(336,Int(Times(Power(x_,m_DEFAULT),Power(Plus($p("a1"),Times($p("b1",true),Power(x_,n_))),p_),Power(Plus($p("a2"),Times($p("b2",true),Power(x_,n_))),p_)),x_Symbol),
    Condition(Negate(Subst(Int(Times(Power(Plus($s("a1"),Times($s("b1"),Power(Power(x,n),-1))),p),Power(Plus($s("a2"),Times($s("b2"),Power(Power(x,n),-1))),p),Power(Power(x,Plus(m,C2)),-1)),x),x,Power(x,-1))),And(FreeQ(List($s("a1"),$s("b1"),$s("a2"),$s("b2"),p),x),EqQ(Plus(Times($s("a2"),$s("b1")),Times($s("a1"),$s("b2"))),C0),ILtQ(Times(C2,n),C0),IntegerQ(m)))),
IIntegrate(337,Int(Times(Power(Times(c_DEFAULT,x_),m_),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_)),x_Symbol),
    Condition(With(List(Set(k,Denominator(m))),Negate(Dist(Times(k,Power(c,-1)),Subst(Int(Times(Power(Plus(a,Times(b,Power(Times(Power(c,n),Power(x,Times(k,n))),-1))),p),Power(Power(x,Plus(Times(k,Plus(m,C1)),C1)),-1)),x),x,Power(Power(Times(c,x),Power(k,-1)),-1)),x))),And(FreeQ(List(a,b,c,p),x),ILtQ(n,C0),FractionQ(m)))),
IIntegrate(338,Int(Times(Power(Times(c_DEFAULT,x_),m_),Power(Plus($p("a1"),Times($p("b1",true),Power(x_,n_))),p_),Power(Plus($p("a2"),Times($p("b2",true),Power(x_,n_))),p_)),x_Symbol),
    Condition(With(List(Set(k,Denominator(m))),Negate(Dist(Times(k,Power(c,-1)),Subst(Int(Times(Power(Plus($s("a1"),Times($s("b1"),Power(Times(Power(c,n),Power(x,Times(k,n))),-1))),p),Power(Plus($s("a2"),Times($s("b2"),Power(Times(Power(c,n),Power(x,Times(k,n))),-1))),p),Power(Power(x,Plus(Times(k,Plus(m,C1)),C1)),-1)),x),x,Power(Power(Times(c,x),Power(k,-1)),-1)),x))),And(FreeQ(List($s("a1"),$s("b1"),$s("a2"),$s("b2"),c,p),x),EqQ(Plus(Times($s("a2"),$s("b1")),Times($s("a1"),$s("b2"))),C0),ILtQ(Times(C2,n),C0),FractionQ(m)))),
IIntegrate(339,Int(Times(Power(Times(c_DEFAULT,x_),m_),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_)),x_Symbol),
    Condition(Negate(Dist(Times(Power(Times(c,x),Plus(m,C1)),Power(Power(x,-1),Plus(m,C1)),Power(c,-1)),Subst(Int(Times(Power(Plus(a,Times(b,Power(Power(x,n),-1))),p),Power(Power(x,Plus(m,C2)),-1)),x),x,Power(x,-1)),x)),And(FreeQ(List(a,b,c,m,p),x),ILtQ(n,C0),Not(RationalQ(m))))),
IIntegrate(340,Int(Times(Power(Times(c_DEFAULT,x_),m_),Power(Plus($p("a1"),Times($p("b1",true),Power(x_,n_))),p_),Power(Plus($p("a2"),Times($p("b2",true),Power(x_,n_))),p_)),x_Symbol),
    Condition(Negate(Dist(Times(Power(Times(c,x),Plus(m,C1)),Power(Power(x,-1),Plus(m,C1)),Power(c,-1)),Subst(Int(Times(Power(Plus($s("a1"),Times($s("b1"),Power(Power(x,n),-1))),p),Power(Plus($s("a2"),Times($s("b2"),Power(Power(x,n),-1))),p),Power(Power(x,Plus(m,C2)),-1)),x),x,Power(x,-1)),x)),And(FreeQ(List($s("a1"),$s("b1"),$s("a2"),$s("b2"),c,m,p),x),EqQ(Plus(Times($s("a2"),$s("b1")),Times($s("a1"),$s("b2"))),C0),ILtQ(Times(C2,n),C0),Not(RationalQ(m))))),
IIntegrate(341,Int(Times(Power(x_,m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_)),x_Symbol),
    Condition(With(List(Set(k,Denominator(n))),Dist(k,Subst(Int(Times(Power(x,Plus(Times(k,Plus(m,C1)),Negate(C1))),Power(Plus(a,Times(b,Power(x,Times(k,n)))),p)),x),x,Power(x,Power(k,-1))),x)),And(FreeQ(List(a,b,m,p),x),FractionQ(n)))),
IIntegrate(342,Int(Times(Power(x_,m_DEFAULT),Power(Plus($p("a1"),Times($p("b1",true),Power(x_,n_))),p_),Power(Plus($p("a2"),Times($p("b2",true),Power(x_,n_))),p_)),x_Symbol),
    Condition(With(List(Set(k,Denominator(Times(C2,n)))),Dist(k,Subst(Int(Times(Power(x,Plus(Times(k,Plus(m,C1)),Negate(C1))),Power(Plus($s("a1"),Times($s("b1"),Power(x,Times(k,n)))),p),Power(Plus($s("a2"),Times($s("b2"),Power(x,Times(k,n)))),p)),x),x,Power(x,Power(k,-1))),x)),And(FreeQ(List($s("a1"),$s("b1"),$s("a2"),$s("b2"),m,p),x),EqQ(Plus(Times($s("a2"),$s("b1")),Times($s("a1"),$s("b2"))),C0),FractionQ(Times(C2,n))))),
IIntegrate(343,Int(Times(Power(Times(c_,x_),m_),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_)),x_Symbol),
    Condition(Dist(Times(Power(c,IntPart(m)),Power(Times(c,x),FracPart(m)),Power(Power(x,FracPart(m)),-1)),Int(Times(Power(x,m),Power(Plus(a,Times(b,Power(x,n))),p)),x),x),And(FreeQ(List(a,b,c,m,p),x),FractionQ(n)))),
IIntegrate(344,Int(Times(Power(Times(c_,x_),m_),Power(Plus($p("a1"),Times($p("b1",true),Power(x_,n_))),p_),Power(Plus($p("a2"),Times($p("b2",true),Power(x_,n_))),p_)),x_Symbol),
    Condition(Dist(Times(Power(c,IntPart(m)),Power(Times(c,x),FracPart(m)),Power(Power(x,FracPart(m)),-1)),Int(Times(Power(x,m),Power(Plus($s("a1"),Times($s("b1"),Power(x,n))),p),Power(Plus($s("a2"),Times($s("b2"),Power(x,n))),p)),x),x),And(FreeQ(List($s("a1"),$s("b1"),$s("a2"),$s("b2"),c,m,p),x),EqQ(Plus(Times($s("a2"),$s("b1")),Times($s("a1"),$s("b2"))),C0),FractionQ(Times(C2,n))))),
IIntegrate(345,Int(Times(Power(x_,m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_)),x_Symbol),
    Condition(Dist(Power(Plus(m,C1),-1),Subst(Int(Power(Plus(a,Times(b,Power(x,Simplify(Times(n,Power(Plus(m,C1),-1)))))),p),x),x,Power(x,Plus(m,C1))),x),And(FreeQ(List(a,b,m,n,p),x),IntegerQ(Simplify(Times(n,Power(Plus(m,C1),-1)))),Not(IntegerQ(n))))),
IIntegrate(346,Int(Times(Power(x_,m_DEFAULT),Power(Plus($p("a1"),Times($p("b1",true),Power(x_,n_))),p_),Power(Plus($p("a2"),Times($p("b2",true),Power(x_,n_))),p_)),x_Symbol),
    Condition(Dist(Power(Plus(m,C1),-1),Subst(Int(Times(Power(Plus($s("a1"),Times($s("b1"),Power(x,Simplify(Times(n,Power(Plus(m,C1),-1)))))),p),Power(Plus($s("a2"),Times($s("b2"),Power(x,Simplify(Times(n,Power(Plus(m,C1),-1)))))),p)),x),x,Power(x,Plus(m,C1))),x),And(FreeQ(List($s("a1"),$s("b1"),$s("a2"),$s("b2"),m,n,p),x),EqQ(Plus(Times($s("a2"),$s("b1")),Times($s("a1"),$s("b2"))),C0),IntegerQ(Simplify(Times(C2,n,Power(Plus(m,C1),-1)))),Not(IntegerQ(Times(C2,n)))))),
IIntegrate(347,Int(Times(Power(Times(c_,x_),m_),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_)),x_Symbol),
    Condition(Dist(Times(Power(c,IntPart(m)),Power(Times(c,x),FracPart(m)),Power(Power(x,FracPart(m)),-1)),Int(Times(Power(x,m),Power(Plus(a,Times(b,Power(x,n))),p)),x),x),And(FreeQ(List(a,b,c,m,n,p),x),IntegerQ(Simplify(Times(n,Power(Plus(m,C1),-1)))),Not(IntegerQ(n))))),
IIntegrate(348,Int(Times(Power(Times(c_,x_),m_),Power(Plus($p("a1"),Times($p("b1",true),Power(x_,n_))),p_),Power(Plus($p("a2"),Times($p("b2",true),Power(x_,n_))),p_)),x_Symbol),
    Condition(Dist(Times(Power(c,IntPart(m)),Power(Times(c,x),FracPart(m)),Power(Power(x,FracPart(m)),-1)),Int(Times(Power(x,m),Power(Plus($s("a1"),Times($s("b1"),Power(x,n))),p),Power(Plus($s("a2"),Times($s("b2"),Power(x,n))),p)),x),x),And(FreeQ(List($s("a1"),$s("b1"),$s("a2"),$s("b2"),c,m,n,p),x),EqQ(Plus(Times($s("a2"),$s("b1")),Times($s("a1"),$s("b2"))),C0),IntegerQ(Simplify(Times(C2,n,Power(Plus(m,C1),-1)))),Not(IntegerQ(Times(C2,n)))))),
IIntegrate(349,Int(Times(Power(x_,m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(x,Plus(m,C1)),Power(Plus(a,Times(b,Power(x,n))),p),Power(Plus(m,C1),-1)),x),Negate(Dist(Times(b,n,p,Power(Plus(m,C1),-1)),Int(Times(Power(x,Plus(m,n)),Power(Plus(a,Times(b,Power(x,n))),Plus(p,Negate(C1)))),x),x))),And(FreeQ(List(a,b,m,n),x),EqQ(Plus(Times(Plus(m,C1),Power(n,-1)),p),C0),GtQ(p,C0)))),
IIntegrate(350,Int(Times(Power(x_,m_DEFAULT),Power(Plus($p("a1"),Times($p("b1",true),Power(x_,n_))),p_),Power(Plus($p("a2"),Times($p("b2",true),Power(x_,n_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(x,Plus(m,C1)),Power(Plus($s("a1"),Times($s("b1"),Power(x,n))),p),Power(Plus($s("a2"),Times($s("b2"),Power(x,n))),p),Power(Plus(m,C1),-1)),x),Negate(Dist(Times(C2,$s("b1"),$s("b2"),n,p,Power(Plus(m,C1),-1)),Int(Times(Power(x,Plus(m,Times(C2,n))),Power(Plus($s("a1"),Times($s("b1"),Power(x,n))),Plus(p,Negate(C1))),Power(Plus($s("a2"),Times($s("b2"),Power(x,n))),Plus(p,Negate(C1)))),x),x))),And(FreeQ(List($s("a1"),$s("b1"),$s("a2"),$s("b2"),m,n),x),EqQ(Plus(Times($s("a2"),$s("b1")),Times($s("a1"),$s("b2"))),C0),EqQ(Plus(Times(Plus(m,C1),Power(Times(C2,n),-1)),p),C0),GtQ(p,C0))))
  );
}