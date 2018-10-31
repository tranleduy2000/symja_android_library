package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Coefficient;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cosh;
import static org.matheclipse.core.expression.F.CoshIntegral;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.Exp;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Module;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Simplify;
import static org.matheclipse.core.expression.F.Sinh;
import static org.matheclipse.core.expression.F.SinhIntegral;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_DEFAULT;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.k;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialMatchQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandTrigReduce;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/** 
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class IntRules106 { 
  public static IAST RULES = List( 
IIntegrate(5301,Int(Power(Plus(a_DEFAULT,Times(Cosh(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_)))),b_DEFAULT)),p_),x_Symbol),
    Condition(Int(ExpandTrigReduce(Power(Plus(a,Times(b,Cosh(Plus(c,Times(d,Power(x,n)))))),p),x),x),And(FreeQ(List(a,b,c,d),x),IGtQ(n,C1),IGtQ(p,C1)))),
IIntegrate(5302,Int(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sinh(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_)))))),p_DEFAULT),x_Symbol),
    Condition(Negate(Subst(Int(Times(Power(Plus(a,Times(b,Sinh(Plus(c,Times(d,Power(Power(x,n),-1)))))),p),Power(x,-2)),x),x,Power(x,-1))),And(FreeQ(List(a,b,c,d),x),ILtQ(n,C0),IntegerQ(p)))),
IIntegrate(5303,Int(Power(Plus(a_DEFAULT,Times(Cosh(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_)))),b_DEFAULT)),p_DEFAULT),x_Symbol),
    Condition(Negate(Subst(Int(Times(Power(Plus(a,Times(b,Cosh(Plus(c,Times(d,Power(Power(x,n),-1)))))),p),Power(x,-2)),x),x,Power(x,-1))),And(FreeQ(List(a,b,c,d),x),ILtQ(n,C0),IntegerQ(p)))),
IIntegrate(5304,Int(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sinh(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_)))))),p_DEFAULT),x_Symbol),
    Condition(Module(List(Set(k,Denominator(n))),Dist(k,Subst(Int(Times(Power(x,Plus(k,Negate(C1))),Power(Plus(a,Times(b,Sinh(Plus(c,Times(d,Power(x,Times(k,n))))))),p)),x),x,Power(x,Power(k,-1))),x)),And(FreeQ(List(a,b,c,d),x),FractionQ(n),IntegerQ(p)))),
IIntegrate(5305,Int(Power(Plus(a_DEFAULT,Times(Cosh(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_)))),b_DEFAULT)),p_DEFAULT),x_Symbol),
    Condition(Module(List(Set(k,Denominator(n))),Dist(k,Subst(Int(Times(Power(x,Plus(k,Negate(C1))),Power(Plus(a,Times(b,Cosh(Plus(c,Times(d,Power(x,Times(k,n))))))),p)),x),x,Power(x,Power(k,-1))),x)),And(FreeQ(List(a,b,c,d),x),FractionQ(n),IntegerQ(p)))),
IIntegrate(5306,Int(Sinh(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_)))),x_Symbol),
    Condition(Plus(Dist(C1D2,Int(Exp(Plus(c,Times(d,Power(x,n)))),x),x),Negate(Dist(C1D2,Int(Exp(Plus(Negate(c),Times(CN1,d,Power(x,n)))),x),x))),FreeQ(List(c,d,n),x))),
IIntegrate(5307,Int(Cosh(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_)))),x_Symbol),
    Condition(Plus(Dist(C1D2,Int(Exp(Plus(c,Times(d,Power(x,n)))),x),x),Dist(C1D2,Int(Exp(Plus(Negate(c),Times(CN1,d,Power(x,n)))),x),x)),FreeQ(List(c,d,n),x))),
IIntegrate(5308,Int(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sinh(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_)))))),p_),x_Symbol),
    Condition(Int(ExpandTrigReduce(Power(Plus(a,Times(b,Sinh(Plus(c,Times(d,Power(x,n)))))),p),x),x),And(FreeQ(List(a,b,c,d,n),x),IGtQ(p,C0)))),
IIntegrate(5309,Int(Power(Plus(a_DEFAULT,Times(Cosh(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_)))),b_DEFAULT)),p_),x_Symbol),
    Condition(Int(ExpandTrigReduce(Power(Plus(a,Times(b,Cosh(Plus(c,Times(d,Power(x,n)))))),p),x),x),And(FreeQ(List(a,b,c,d,n),x),IGtQ(p,C0)))),
IIntegrate(5310,Int(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sinh(Plus(c_DEFAULT,Times(d_DEFAULT,Power(u_,n_)))))),p_DEFAULT),x_Symbol),
    Condition(Dist(Power(Coefficient(u,x,C1),-1),Subst(Int(Power(Plus(a,Times(b,Sinh(Plus(c,Times(d,Power(x,n)))))),p),x),x,u),x),And(FreeQ(List(a,b,c,d,n),x),IntegerQ(p),LinearQ(u,x),NeQ(u,x)))),
IIntegrate(5311,Int(Power(Plus(a_DEFAULT,Times(Cosh(Plus(c_DEFAULT,Times(d_DEFAULT,Power(u_,n_)))),b_DEFAULT)),p_DEFAULT),x_Symbol),
    Condition(Dist(Power(Coefficient(u,x,C1),-1),Subst(Int(Power(Plus(a,Times(b,Cosh(Plus(c,Times(d,Power(x,n)))))),p),x),x,u),x),And(FreeQ(List(a,b,c,d,n),x),IntegerQ(p),LinearQ(u,x),NeQ(u,x)))),
IIntegrate(5312,Int(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sinh(Plus(c_DEFAULT,Times(d_DEFAULT,Power(u_,n_)))))),p_),x_Symbol),
    Condition(Unintegrable(Power(Plus(a,Times(b,Sinh(Plus(c,Times(d,Power(u,n)))))),p),x),And(FreeQ(List(a,b,c,d,n,p),x),LinearQ(u,x)))),
IIntegrate(5313,Int(Power(Plus(a_DEFAULT,Times(Cosh(Plus(c_DEFAULT,Times(d_DEFAULT,Power(u_,n_)))),b_DEFAULT)),p_),x_Symbol),
    Condition(Unintegrable(Power(Plus(a,Times(b,Cosh(Plus(c,Times(d,Power(u,n)))))),p),x),And(FreeQ(List(a,b,c,d,n,p),x),LinearQ(u,x)))),
IIntegrate(5314,Int(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sinh(u_))),p_DEFAULT),x_Symbol),
    Condition(Int(Power(Plus(a,Times(b,Sinh(ExpandToSum(u,x)))),p),x),And(FreeQ(List(a,b,p),x),BinomialQ(u,x),Not(BinomialMatchQ(u,x))))),
IIntegrate(5315,Int(Power(Plus(a_DEFAULT,Times(Cosh(u_),b_DEFAULT)),p_DEFAULT),x_Symbol),
    Condition(Int(Power(Plus(a,Times(b,Cosh(ExpandToSum(u,x)))),p),x),And(FreeQ(List(a,b,p),x),BinomialQ(u,x),Not(BinomialMatchQ(u,x))))),
IIntegrate(5316,Int(Times(Power(x_,-1),Sinh(Times(d_DEFAULT,Power(x_,n_)))),x_Symbol),
    Condition(Simp(Times(SinhIntegral(Times(d,Power(x,n))),Power(n,-1)),x),FreeQ(List(d,n),x))),
IIntegrate(5317,Int(Times(Cosh(Times(d_DEFAULT,Power(x_,n_))),Power(x_,-1)),x_Symbol),
    Condition(Simp(Times(CoshIntegral(Times(d,Power(x,n))),Power(n,-1)),x),FreeQ(List(d,n),x))),
IIntegrate(5318,Int(Times(Power(x_,-1),Sinh(Plus(c_,Times(d_DEFAULT,Power(x_,n_))))),x_Symbol),
    Condition(Plus(Dist(Sinh(c),Int(Times(Cosh(Times(d,Power(x,n))),Power(x,-1)),x),x),Dist(Cosh(c),Int(Times(Sinh(Times(d,Power(x,n))),Power(x,-1)),x),x)),FreeQ(List(c,d,n),x))),
IIntegrate(5319,Int(Times(Cosh(Plus(c_,Times(d_DEFAULT,Power(x_,n_)))),Power(x_,-1)),x_Symbol),
    Condition(Plus(Dist(Cosh(c),Int(Times(Cosh(Times(d,Power(x,n))),Power(x,-1)),x),x),Dist(Sinh(c),Int(Times(Sinh(Times(d,Power(x,n))),Power(x,-1)),x),x)),FreeQ(List(c,d,n),x))),
IIntegrate(5320,Int(Times(Power(x_,m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sinh(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_)))))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Power(n,-1),Subst(Int(Times(Power(x,Plus(Simplify(Times(Plus(m,C1),Power(n,-1))),Negate(C1))),Power(Plus(a,Times(b,Sinh(Plus(c,Times(d,x))))),p)),x),x,Power(x,n)),x),And(FreeQ(List(a,b,c,d,m,n,p),x),IntegerQ(Simplify(Times(Plus(m,C1),Power(n,-1)))),Or(EqQ(p,C1),EqQ(m,Plus(n,Negate(C1))),And(IntegerQ(p),GtQ(Simplify(Times(Plus(m,C1),Power(n,-1))),C0)))))),
IIntegrate(5321,Int(Times(Power(Plus(a_DEFAULT,Times(Cosh(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_)))),b_DEFAULT)),p_DEFAULT),Power(x_,m_DEFAULT)),x_Symbol),
    Condition(Dist(Power(n,-1),Subst(Int(Times(Power(x,Plus(Simplify(Times(Plus(m,C1),Power(n,-1))),Negate(C1))),Power(Plus(a,Times(b,Cosh(Plus(c,Times(d,x))))),p)),x),x,Power(x,n)),x),And(FreeQ(List(a,b,c,d,m,n,p),x),IntegerQ(Simplify(Times(Plus(m,C1),Power(n,-1)))),Or(EqQ(p,C1),EqQ(m,Plus(n,Negate(C1))),And(IntegerQ(p),GtQ(Simplify(Times(Plus(m,C1),Power(n,-1))),C0)))))),
IIntegrate(5322,Int(Times(Power(Times(e_,x_),m_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sinh(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_)))))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(e,IntPart(m)),Power(Times(e,x),FracPart(m)),Power(Power(x,FracPart(m)),-1)),Int(Times(Power(x,m),Power(Plus(a,Times(b,Sinh(Plus(c,Times(d,Power(x,n)))))),p)),x),x),And(FreeQ(List(a,b,c,d,e,m,n,p),x),IntegerQ(Simplify(Times(Plus(m,C1),Power(n,-1))))))),
IIntegrate(5323,Int(Times(Power(Plus(a_DEFAULT,Times(Cosh(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_)))),b_DEFAULT)),p_DEFAULT),Power(Times(e_,x_),m_)),x_Symbol),
    Condition(Dist(Times(Power(e,IntPart(m)),Power(Times(e,x),FracPart(m)),Power(Power(x,FracPart(m)),-1)),Int(Times(Power(x,m),Power(Plus(a,Times(b,Cosh(Plus(c,Times(d,Power(x,n)))))),p)),x),x),And(FreeQ(List(a,b,c,d,e,m,n,p),x),IntegerQ(Simplify(Times(Plus(m,C1),Power(n,-1))))))),
IIntegrate(5324,Int(Times(Power(Times(e_DEFAULT,x_),m_DEFAULT),Sinh(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_))))),x_Symbol),
    Condition(Plus(Simp(Times(Power(e,Plus(n,Negate(C1))),Power(Times(e,x),Plus(m,Negate(n),C1)),Cosh(Plus(c,Times(d,Power(x,n)))),Power(Times(d,n),-1)),x),Negate(Dist(Times(Power(e,n),Plus(m,Negate(n),C1),Power(Times(d,n),-1)),Int(Times(Power(Times(e,x),Plus(m,Negate(n))),Cosh(Plus(c,Times(d,Power(x,n))))),x),x))),And(FreeQ(List(c,d,e),x),IGtQ(n,C0),LtQ(C0,n,Plus(m,C1))))),
IIntegrate(5325,Int(Times(Cosh(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_)))),Power(Times(e_DEFAULT,x_),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(e,Plus(n,Negate(C1))),Power(Times(e,x),Plus(m,Negate(n),C1)),Sinh(Plus(c,Times(d,Power(x,n)))),Power(Times(d,n),-1)),x),Negate(Dist(Times(Power(e,n),Plus(m,Negate(n),C1),Power(Times(d,n),-1)),Int(Times(Power(Times(e,x),Plus(m,Negate(n))),Sinh(Plus(c,Times(d,Power(x,n))))),x),x))),And(FreeQ(List(c,d,e),x),IGtQ(n,C0),LtQ(C0,n,Plus(m,C1))))),
IIntegrate(5326,Int(Times(Power(Times(e_DEFAULT,x_),m_),Sinh(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_))))),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(e,x),Plus(m,C1)),Sinh(Plus(c,Times(d,Power(x,n)))),Power(Times(e,Plus(m,C1)),-1)),x),Negate(Dist(Times(d,n,Power(Times(Power(e,n),Plus(m,C1)),-1)),Int(Times(Power(Times(e,x),Plus(m,n)),Cosh(Plus(c,Times(d,Power(x,n))))),x),x))),And(FreeQ(List(c,d,e),x),IGtQ(n,C0),LtQ(m,CN1)))),
IIntegrate(5327,Int(Times(Cosh(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_)))),Power(Times(e_DEFAULT,x_),m_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(e,x),Plus(m,C1)),Cosh(Plus(c,Times(d,Power(x,n)))),Power(Times(e,Plus(m,C1)),-1)),x),Negate(Dist(Times(d,n,Power(Times(Power(e,n),Plus(m,C1)),-1)),Int(Times(Power(Times(e,x),Plus(m,n)),Sinh(Plus(c,Times(d,Power(x,n))))),x),x))),And(FreeQ(List(c,d,e),x),IGtQ(n,C0),LtQ(m,CN1)))),
IIntegrate(5328,Int(Times(Power(Times(e_DEFAULT,x_),m_DEFAULT),Sinh(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_))))),x_Symbol),
    Condition(Plus(Dist(C1D2,Int(Times(Power(Times(e,x),m),Exp(Plus(c,Times(d,Power(x,n))))),x),x),Negate(Dist(C1D2,Int(Times(Power(Times(e,x),m),Exp(Plus(Negate(c),Times(CN1,d,Power(x,n))))),x),x))),And(FreeQ(List(c,d,e,m),x),IGtQ(n,C0)))),
IIntegrate(5329,Int(Times(Cosh(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_)))),Power(Times(e_DEFAULT,x_),m_DEFAULT)),x_Symbol),
    Condition(Plus(Dist(C1D2,Int(Times(Power(Times(e,x),m),Exp(Plus(c,Times(d,Power(x,n))))),x),x),Dist(C1D2,Int(Times(Power(Times(e,x),m),Exp(Plus(Negate(c),Times(CN1,d,Power(x,n))))),x),x)),And(FreeQ(List(c,d,e,m),x),IGtQ(n,C0)))),
IIntegrate(5330,Int(Times(Power(x_,m_DEFAULT),Power(Sinh(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_)))),p_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Power(Sinh(Plus(a,Times(b,Power(x,n)))),p),Power(Times(Plus(n,Negate(C1)),Power(x,Plus(n,Negate(C1)))),-1)),x)),Dist(Times(b,n,p,Power(Plus(n,Negate(C1)),-1)),Int(Times(Power(Sinh(Plus(a,Times(b,Power(x,n)))),Plus(p,Negate(C1))),Cosh(Plus(a,Times(b,Power(x,n))))),x),x)),And(FreeQ(List(a,b),x),IntegersQ(n,p),EqQ(Plus(m,n),C0),GtQ(p,C1),NeQ(n,C1)))),
IIntegrate(5331,Int(Times(Power(Cosh(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_)))),p_),Power(x_,m_DEFAULT)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Power(Cosh(Plus(a,Times(b,Power(x,n)))),p),Power(Times(Plus(n,Negate(C1)),Power(x,Plus(n,Negate(C1)))),-1)),x)),Dist(Times(b,n,p,Power(Plus(n,Negate(C1)),-1)),Int(Times(Power(Cosh(Plus(a,Times(b,Power(x,n)))),Plus(p,Negate(C1))),Sinh(Plus(a,Times(b,Power(x,n))))),x),x)),And(FreeQ(List(a,b),x),IntegersQ(n,p),EqQ(Plus(m,n),C0),GtQ(p,C1),NeQ(n,C1)))),
IIntegrate(5332,Int(Times(Power(x_,m_DEFAULT),Power(Sinh(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_)))),p_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(n,Power(Sinh(Plus(a,Times(b,Power(x,n)))),p),Power(Times(Sqr(b),Sqr(n),Sqr(p)),-1)),x)),Negate(Dist(Times(Plus(p,Negate(C1)),Power(p,-1)),Int(Times(Power(x,m),Power(Sinh(Plus(a,Times(b,Power(x,n)))),Plus(p,Negate(C2)))),x),x)),Simp(Times(Power(x,n),Cosh(Plus(a,Times(b,Power(x,n)))),Power(Sinh(Plus(a,Times(b,Power(x,n)))),Plus(p,Negate(C1))),Power(Times(b,n,p),-1)),x)),And(FreeQ(List(a,b,m,n),x),EqQ(Plus(m,Times(CN1,C2,n),C1)),GtQ(p,C1)))),
IIntegrate(5333,Int(Times(Power(Cosh(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_)))),p_),Power(x_,m_DEFAULT)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(n,Power(Cosh(Plus(a,Times(b,Power(x,n)))),p),Power(Times(Sqr(b),Sqr(n),Sqr(p)),-1)),x)),Dist(Times(Plus(p,Negate(C1)),Power(p,-1)),Int(Times(Power(x,m),Power(Cosh(Plus(a,Times(b,Power(x,n)))),Plus(p,Negate(C2)))),x),x),Simp(Times(Power(x,n),Sinh(Plus(a,Times(b,Power(x,n)))),Power(Cosh(Plus(a,Times(b,Power(x,n)))),Plus(p,Negate(C1))),Power(Times(b,n,p),-1)),x)),And(FreeQ(List(a,b,m,n),x),EqQ(Plus(m,Times(CN1,C2,n),C1)),GtQ(p,C1)))),
IIntegrate(5334,Int(Times(Power(x_,m_DEFAULT),Power(Sinh(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_)))),p_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Plus(m,Negate(n),C1),Power(x,Plus(m,Times(CN1,C2,n),C1)),Power(Sinh(Plus(a,Times(b,Power(x,n)))),p),Power(Times(Sqr(b),Sqr(n),Sqr(p)),-1)),x)),Negate(Dist(Times(Plus(p,Negate(C1)),Power(p,-1)),Int(Times(Power(x,m),Power(Sinh(Plus(a,Times(b,Power(x,n)))),Plus(p,Negate(C2)))),x),x)),Dist(Times(Plus(m,Negate(n),C1),Plus(m,Times(CN1,C2,n),C1),Power(Times(Sqr(b),Sqr(n),Sqr(p)),-1)),Int(Times(Power(x,Plus(m,Times(CN1,C2,n))),Power(Sinh(Plus(a,Times(b,Power(x,n)))),p)),x),x),Simp(Times(Power(x,Plus(m,Negate(n),C1)),Cosh(Plus(a,Times(b,Power(x,n)))),Power(Sinh(Plus(a,Times(b,Power(x,n)))),Plus(p,Negate(C1))),Power(Times(b,n,p),-1)),x)),And(FreeQ(List(a,b),x),IntegersQ(m,n),GtQ(p,C1),LtQ(C0,Times(C2,n),Plus(m,C1))))),
IIntegrate(5335,Int(Times(Power(Cosh(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_)))),p_),Power(x_,m_DEFAULT)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Plus(m,Negate(n),C1),Power(x,Plus(m,Times(CN1,C2,n),C1)),Power(Cosh(Plus(a,Times(b,Power(x,n)))),p),Power(Times(Sqr(b),Sqr(n),Sqr(p)),-1)),x)),Dist(Times(Plus(p,Negate(C1)),Power(p,-1)),Int(Times(Power(x,m),Power(Cosh(Plus(a,Times(b,Power(x,n)))),Plus(p,Negate(C2)))),x),x),Dist(Times(Plus(m,Negate(n),C1),Plus(m,Times(CN1,C2,n),C1),Power(Times(Sqr(b),Sqr(n),Sqr(p)),-1)),Int(Times(Power(x,Plus(m,Times(CN1,C2,n))),Power(Cosh(Plus(a,Times(b,Power(x,n)))),p)),x),x),Simp(Times(Power(x,Plus(m,Negate(n),C1)),Sinh(Plus(a,Times(b,Power(x,n)))),Power(Cosh(Plus(a,Times(b,Power(x,n)))),Plus(p,Negate(C1))),Power(Times(b,n,p),-1)),x)),And(FreeQ(List(a,b),x),IntegersQ(m,n),GtQ(p,C1),LtQ(C0,Times(C2,n),Plus(m,C1))))),
IIntegrate(5336,Int(Times(Power(x_,m_DEFAULT),Power(Sinh(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_)))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(x,Plus(m,C1)),Power(Sinh(Plus(a,Times(b,Power(x,n)))),p),Power(Plus(m,C1),-1)),x),Dist(Times(Sqr(b),Sqr(n),p,Plus(p,Negate(C1)),Power(Times(Plus(m,C1),Plus(m,n,C1)),-1)),Int(Times(Power(x,Plus(m,Times(C2,n))),Power(Sinh(Plus(a,Times(b,Power(x,n)))),Plus(p,Negate(C2)))),x),x),Dist(Times(Sqr(b),Sqr(n),Sqr(p),Power(Times(Plus(m,C1),Plus(m,n,C1)),-1)),Int(Times(Power(x,Plus(m,Times(C2,n))),Power(Sinh(Plus(a,Times(b,Power(x,n)))),p)),x),x),Negate(Simp(Times(b,n,p,Power(x,Plus(m,n,C1)),Cosh(Plus(a,Times(b,Power(x,n)))),Power(Sinh(Plus(a,Times(b,Power(x,n)))),Plus(p,Negate(C1))),Power(Times(Plus(m,C1),Plus(m,n,C1)),-1)),x))),And(FreeQ(List(a,b),x),IntegersQ(m,n),GtQ(p,C1),LtQ(C0,Times(C2,n),Plus(C1,Negate(m))),NeQ(Plus(m,n,C1),C0)))),
IIntegrate(5337,Int(Times(Power(Cosh(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_)))),p_),Power(x_,m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(x,Plus(m,C1)),Power(Cosh(Plus(a,Times(b,Power(x,n)))),p),Power(Plus(m,C1),-1)),x),Negate(Dist(Times(Sqr(b),Sqr(n),p,Plus(p,Negate(C1)),Power(Times(Plus(m,C1),Plus(m,n,C1)),-1)),Int(Times(Power(x,Plus(m,Times(C2,n))),Power(Cosh(Plus(a,Times(b,Power(x,n)))),Plus(p,Negate(C2)))),x),x)),Dist(Times(Sqr(b),Sqr(n),Sqr(p),Power(Times(Plus(m,C1),Plus(m,n,C1)),-1)),Int(Times(Power(x,Plus(m,Times(C2,n))),Power(Cosh(Plus(a,Times(b,Power(x,n)))),p)),x),x),Negate(Simp(Times(b,n,p,Power(x,Plus(m,n,C1)),Sinh(Plus(a,Times(b,Power(x,n)))),Power(Cosh(Plus(a,Times(b,Power(x,n)))),Plus(p,Negate(C1))),Power(Times(Plus(m,C1),Plus(m,n,C1)),-1)),x))),And(FreeQ(List(a,b),x),IntegersQ(m,n),GtQ(p,C1),LtQ(C0,Times(C2,n),Plus(C1,Negate(m))),NeQ(Plus(m,n,C1),C0)))),
IIntegrate(5338,Int(Times(Power(Times(e_DEFAULT,x_),m_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sinh(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_)))))),p_DEFAULT)),x_Symbol),
    Condition(With(List(Set(k,Denominator(m))),Dist(Times(k,Power(e,-1)),Subst(Int(Times(Power(x,Plus(Times(k,Plus(m,C1)),Negate(C1))),Power(Plus(a,Times(b,Sinh(Plus(c,Times(d,Power(x,Times(k,n)),Power(Power(e,n),-1)))))),p)),x),x,Power(Times(e,x),Power(k,-1))),x)),And(FreeQ(List(a,b,c,d,e),x),IntegerQ(p),IGtQ(n,C0),FractionQ(m)))),
IIntegrate(5339,Int(Times(Power(Plus(a_DEFAULT,Times(Cosh(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_)))),b_DEFAULT)),p_DEFAULT),Power(Times(e_DEFAULT,x_),m_)),x_Symbol),
    Condition(With(List(Set(k,Denominator(m))),Dist(Times(k,Power(e,-1)),Subst(Int(Times(Power(x,Plus(Times(k,Plus(m,C1)),Negate(C1))),Power(Plus(a,Times(b,Cosh(Plus(c,Times(d,Power(x,Times(k,n)),Power(Power(e,n),-1)))))),p)),x),x,Power(Times(e,x),Power(k,-1))),x)),And(FreeQ(List(a,b,c,d,e),x),IntegerQ(p),IGtQ(n,C0),FractionQ(m)))),
IIntegrate(5340,Int(Times(Power(Times(e_DEFAULT,x_),m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sinh(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_)))))),p_)),x_Symbol),
    Condition(Int(ExpandTrigReduce(Power(Times(e,x),m),Power(Plus(a,Times(b,Sinh(Plus(c,Times(d,Power(x,n)))))),p),x),x),And(FreeQ(List(a,b,c,d,e,m),x),IGtQ(p,C1),IGtQ(n,C0)))),
IIntegrate(5341,Int(Times(Power(Plus(a_DEFAULT,Times(Cosh(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_)))),b_DEFAULT)),p_),Power(Times(e_DEFAULT,x_),m_DEFAULT)),x_Symbol),
    Condition(Int(ExpandTrigReduce(Power(Times(e,x),m),Power(Plus(a,Times(b,Cosh(Plus(c,Times(d,Power(x,n)))))),p),x),x),And(FreeQ(List(a,b,c,d,e,m),x),IGtQ(p,C1),IGtQ(n,C0)))),
IIntegrate(5342,Int(Times(Power(x_,m_DEFAULT),Power(Sinh(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_)))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(x,n),Cosh(Plus(a,Times(b,Power(x,n)))),Power(Sinh(Plus(a,Times(b,Power(x,n)))),Plus(p,C1)),Power(Times(b,n,Plus(p,C1)),-1)),x),Negate(Dist(Times(Plus(p,C2),Power(Plus(p,C1),-1)),Int(Times(Power(x,m),Power(Sinh(Plus(a,Times(b,Power(x,n)))),Plus(p,C2))),x),x)),Negate(Simp(Times(n,Power(Sinh(Plus(a,Times(b,Power(x,n)))),Plus(p,C2)),Power(Times(Sqr(b),Sqr(n),Plus(p,C1),Plus(p,C2)),-1)),x))),And(FreeQ(List(a,b,m,n),x),EqQ(Plus(m,Times(CN1,C2,n),C1),C0),LtQ(p,CN1),NeQ(p,CN2)))),
IIntegrate(5343,Int(Times(Power(Cosh(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_)))),p_),Power(x_,m_DEFAULT)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Power(x,n),Sinh(Plus(a,Times(b,Power(x,n)))),Power(Cosh(Plus(a,Times(b,Power(x,n)))),Plus(p,C1)),Power(Times(b,n,Plus(p,C1)),-1)),x)),Dist(Times(Plus(p,C2),Power(Plus(p,C1),-1)),Int(Times(Power(x,m),Power(Cosh(Plus(a,Times(b,Power(x,n)))),Plus(p,C2))),x),x),Simp(Times(n,Power(Cosh(Plus(a,Times(b,Power(x,n)))),Plus(p,C2)),Power(Times(Sqr(b),Sqr(n),Plus(p,C1),Plus(p,C2)),-1)),x)),And(FreeQ(List(a,b,m,n),x),EqQ(Plus(m,Times(CN1,C2,n),C1),C0),LtQ(p,CN1),NeQ(p,CN2)))),
IIntegrate(5344,Int(Times(Power(x_,m_DEFAULT),Power(Sinh(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_)))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(x,Plus(m,Negate(n),C1)),Cosh(Plus(a,Times(b,Power(x,n)))),Power(Sinh(Plus(a,Times(b,Power(x,n)))),Plus(p,C1)),Power(Times(b,n,Plus(p,C1)),-1)),x),Negate(Dist(Times(Plus(p,C2),Power(Plus(p,C1),-1)),Int(Times(Power(x,m),Power(Sinh(Plus(a,Times(b,Power(x,n)))),Plus(p,C2))),x),x)),Dist(Times(Plus(m,Negate(n),C1),Plus(m,Times(CN1,C2,n),C1),Power(Times(Sqr(b),Sqr(n),Plus(p,C1),Plus(p,C2)),-1)),Int(Times(Power(x,Plus(m,Times(CN1,C2,n))),Power(Sinh(Plus(a,Times(b,Power(x,n)))),Plus(p,C2))),x),x),Negate(Simp(Times(Plus(m,Negate(n),C1),Power(x,Plus(m,Times(CN1,C2,n),C1)),Power(Sinh(Plus(a,Times(b,Power(x,n)))),Plus(p,C2)),Power(Times(Sqr(b),Sqr(n),Plus(p,C1),Plus(p,C2)),-1)),x))),And(FreeQ(List(a,b),x),IntegersQ(m,n),LtQ(p,CN1),NeQ(p,CN2),LtQ(C0,Times(C2,n),Plus(m,C1))))),
IIntegrate(5345,Int(Times(Power(Cosh(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_)))),p_),Power(x_,m_DEFAULT)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Power(x,Plus(m,Negate(n),C1)),Sinh(Plus(a,Times(b,Power(x,n)))),Power(Cosh(Plus(a,Times(b,Power(x,n)))),Plus(p,C1)),Power(Times(b,n,Plus(p,C1)),-1)),x)),Dist(Times(Plus(p,C2),Power(Plus(p,C1),-1)),Int(Times(Power(x,m),Power(Cosh(Plus(a,Times(b,Power(x,n)))),Plus(p,C2))),x),x),Negate(Dist(Times(Plus(m,Negate(n),C1),Plus(m,Times(CN1,C2,n),C1),Power(Times(Sqr(b),Sqr(n),Plus(p,C1),Plus(p,C2)),-1)),Int(Times(Power(x,Plus(m,Times(CN1,C2,n))),Power(Cosh(Plus(a,Times(b,Power(x,n)))),Plus(p,C2))),x),x)),Simp(Times(Plus(m,Negate(n),C1),Power(x,Plus(m,Times(CN1,C2,n),C1)),Power(Cosh(Plus(a,Times(b,Power(x,n)))),Plus(p,C2)),Power(Times(Sqr(b),Sqr(n),Plus(p,C1),Plus(p,C2)),-1)),x)),And(FreeQ(List(a,b),x),IntegersQ(m,n),LtQ(p,CN1),NeQ(p,CN2),LtQ(C0,Times(C2,n),Plus(m,C1))))),
IIntegrate(5346,Int(Times(Power(x_,m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sinh(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_)))))),p_DEFAULT)),x_Symbol),
    Condition(Negate(Subst(Int(Times(Power(Plus(a,Times(b,Sinh(Plus(c,Times(d,Power(Power(x,n),-1)))))),p),Power(Power(x,Plus(m,C2)),-1)),x),x,Power(x,-1))),And(FreeQ(List(a,b,c,d),x),IntegerQ(p),ILtQ(n,C0),IntegerQ(m)))),
IIntegrate(5347,Int(Times(Power(Plus(a_DEFAULT,Times(Cosh(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_)))),b_DEFAULT)),p_DEFAULT),Power(x_,m_DEFAULT)),x_Symbol),
    Condition(Negate(Subst(Int(Times(Power(Plus(a,Times(b,Cosh(Plus(c,Times(d,Power(Power(x,n),-1)))))),p),Power(Power(x,Plus(m,C2)),-1)),x),x,Power(x,-1))),And(FreeQ(List(a,b,c,d),x),IntegerQ(p),ILtQ(n,C0),IntegerQ(m)))),
IIntegrate(5348,Int(Times(Power(Times(e_DEFAULT,x_),m_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sinh(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_)))))),p_DEFAULT)),x_Symbol),
    Condition(With(List(Set(k,Denominator(m))),Negate(Dist(Times(k,Power(e,-1)),Subst(Int(Times(Power(Plus(a,Times(b,Sinh(Plus(c,Times(d,Power(Times(Power(e,n),Power(x,Times(k,n))),-1)))))),p),Power(Power(x,Plus(Times(k,Plus(m,C1)),C1)),-1)),x),x,Power(Power(Times(e,x),Power(k,-1)),-1)),x))),And(FreeQ(List(a,b,c,d,e),x),IntegerQ(p),ILtQ(n,C0),FractionQ(m)))),
IIntegrate(5349,Int(Times(Power(Plus(a_DEFAULT,Times(Cosh(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_)))),b_DEFAULT)),p_DEFAULT),Power(Times(e_DEFAULT,x_),m_)),x_Symbol),
    Condition(With(List(Set(k,Denominator(m))),Negate(Dist(Times(k,Power(e,-1)),Subst(Int(Times(Power(Plus(a,Times(b,Cosh(Plus(c,Times(d,Power(Times(Power(e,n),Power(x,Times(k,n))),-1)))))),p),Power(Power(x,Plus(Times(k,Plus(m,C1)),C1)),-1)),x),x,Power(Power(Times(e,x),Power(k,-1)),-1)),x))),And(FreeQ(List(a,b,c,d,e),x),IntegerQ(p),ILtQ(n,C0),FractionQ(m)))),
IIntegrate(5350,Int(Times(Power(Times(e_DEFAULT,x_),m_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sinh(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_)))))),p_DEFAULT)),x_Symbol),
    Condition(Negate(Dist(Times(Power(Times(e,x),m),Power(Power(x,-1),m)),Subst(Int(Times(Power(Plus(a,Times(b,Sinh(Plus(c,Times(d,Power(Power(x,n),-1)))))),p),Power(Power(x,Plus(m,C2)),-1)),x),x,Power(x,-1)),x)),And(FreeQ(List(a,b,c,d,e,m),x),IntegerQ(p),ILtQ(n,C0),Not(RationalQ(m)))))
  );
}
