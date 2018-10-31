package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcTan;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C1D3;
import static org.matheclipse.core.expression.F.C1DSqrt3;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.C5;
import static org.matheclipse.core.expression.F.C6;
import static org.matheclipse.core.expression.F.C9;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D3;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.CN3;
import static org.matheclipse.core.expression.F.CSqrt3;
import static org.matheclipse.core.expression.F.Coefficient;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Simplify;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.a_DEFAULT;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.g_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NegQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumSimplerQ;

/** 
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class IntRules15 { 
  public static IAST RULES = List( 
IIntegrate(751,Int(Times(Power(Plus(d_,Times(e_DEFAULT,x_)),-1),Power(Plus(a_,Times(c_DEFAULT,Sqr(x_))),CN1D3)),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(C6,Sqr(c),Sqr(e),Power(d,-2)),C3))),Plus(Negate(Simp(Times(CSqrt3,c,e,ArcTan(Plus(C1DSqrt3,Times(C2,c,Plus(d,Times(CN1,e,x)),Power(Times(CSqrt3,d,q,Power(Plus(a,Times(c,Sqr(x))),C1D3)),-1)))),Power(Times(Sqr(d),Sqr(q)),-1)),x)),Negate(Simp(Times(C3,c,e,Log(Plus(d,Times(e,x))),Power(Times(C2,Sqr(d),Sqr(q)),-1)),x)),Simp(Times(C3,c,e,Log(Plus(Times(c,d),Times(CN1,c,e,x),Times(CN1,d,q,Power(Plus(a,Times(c,Sqr(x))),C1D3)))),Power(Times(C2,Sqr(d),Sqr(q)),-1)),x))),And(FreeQ(List(a,c,d,e),x),EqQ(Plus(Times(c,Sqr(d)),Times(CN1,C3,a,Sqr(e))),C0)))),
IIntegrate(752,Int(Times(Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),-1),Power(Plus(a_,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))),CN1D3)),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(CN3,c,Sqr(e),Plus(Times(C2,c,d),Times(CN1,b,e))),C3))),Plus(Negate(Simp(Times(CSqrt3,c,e,ArcTan(Plus(C1DSqrt3,Times(CN1,C2,Plus(Times(c,d),Times(CN1,b,e),Times(CN1,c,e,x)),Power(Times(CSqrt3,q,Power(Plus(a,Times(b,x),Times(c,Sqr(x))),C1D3)),-1)))),Power(q,-2)),x)),Negate(Simp(Times(C3,c,e,Log(Plus(d,Times(e,x))),Power(Times(C2,Sqr(q)),-1)),x)),Simp(Times(C3,c,e,Log(Plus(Times(c,d),Times(CN1,b,e),Times(CN1,c,e,x),Times(q,Power(Plus(a,Times(b,x),Times(c,Sqr(x))),C1D3)))),Power(Times(C2,Sqr(q)),-1)),x))),And(FreeQ(List(a,b,c,d,e),x),NeQ(Plus(Times(C2,c,d),Times(CN1,b,e)),C0),EqQ(Plus(Times(Sqr(c),Sqr(d)),Times(CN1,b,c,d,e),Times(Sqr(b),Sqr(e)),Times(CN1,C3,a,c,Sqr(e))),C0),NegQ(Times(c,Sqr(e),Plus(Times(C2,c,d),Times(CN1,b,e))))))),
IIntegrate(753,Int(Times(Power(Plus(d_,Times(e_DEFAULT,x_)),-1),Power(Plus(a_,Times(c_DEFAULT,Sqr(x_))),CN1D3)),x_Symbol),
    Condition(Dist(Power(a,C1D3),Int(Power(Times(Plus(d,Times(e,x)),Power(Plus(C1,Times(CN1,C3,e,x,Power(d,-1))),C1D3),Power(Plus(C1,Times(C3,e,x,Power(d,-1))),C1D3)),-1),x),x),And(FreeQ(List(a,c,d,e),x),EqQ(Plus(Times(c,Sqr(d)),Times(C9,a,Sqr(e))),C0),GtQ(a,C0)))),
IIntegrate(754,Int(Times(Power(Plus(d_,Times(e_DEFAULT,x_)),-1),Power(Plus(a_,Times(c_DEFAULT,Sqr(x_))),CN1D3)),x_Symbol),
    Condition(Dist(Times(Power(Plus(C1,Times(c,Sqr(x),Power(a,-1))),C1D3),Power(Plus(a,Times(c,Sqr(x))),CN1D3)),Int(Power(Times(Plus(d,Times(e,x)),Power(Plus(C1,Times(c,Sqr(x),Power(a,-1))),C1D3)),-1),x),x),And(FreeQ(List(a,c,d,e),x),EqQ(Plus(Times(c,Sqr(d)),Times(C9,a,Sqr(e))),C0),Not(GtQ(a,C0))))),
IIntegrate(755,Int(Times(Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),-1),Power(Plus(a_,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))),CN1D3)),x_Symbol),
    Condition(With(List(Set(q,Rt(Plus(Sqr(b),Times(CN1,C4,a,c)),C2))),Dist(Times(Power(Plus(b,q,Times(C2,c,x)),C1D3),Power(Plus(b,Negate(q),Times(C2,c,x)),C1D3),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),CN1D3)),Int(Power(Times(Plus(d,Times(e,x)),Power(Plus(b,q,Times(C2,c,x)),C1D3),Power(Plus(b,Negate(q),Times(C2,c,x)),C1D3)),-1),x),x)),And(FreeQ(List(a,b,c,d,e),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),EqQ(Plus(Times(Sqr(c),Sqr(d)),Times(CN1,b,c,d,e),Times(CN1,C2,Sqr(b),Sqr(e)),Times(C9,a,c,Sqr(e))),C0)))),
IIntegrate(756,Int(Times(Power(Plus(d_,Times(e_DEFAULT,x_)),m_),Power(Plus(a_,Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Int(Times(Power(Plus(d,Times(e,x)),m),Power(Plus(Rt(a,C2),Times(Rt(Negate(c),C2),x)),p),Power(Plus(Rt(a,C2),Times(CN1,Rt(Negate(c),C2),x)),p)),x),And(FreeQ(List(a,c,d,e,m,p),x),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),Not(IntegerQ(p)),GtQ(a,C0),LtQ(c,C0)))),
IIntegrate(757,Int(Times(Power(Plus(d_,Times(e_DEFAULT,x_)),m_),Power(Plus(a_,Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Int(ExpandIntegrand(Power(Plus(a,Times(c,Sqr(x))),p),Power(Plus(Times(d,Power(Plus(Sqr(d),Times(CN1,Sqr(e),Sqr(x))),-1)),Times(CN1,e,x,Power(Plus(Sqr(d),Times(CN1,Sqr(e),Sqr(x))),-1))),Negate(m)),x),x),And(FreeQ(List(a,c,d,e,p),x),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),Not(IntegerQ(p)),ILtQ(m,C0)))),
IIntegrate(758,Int(Times(Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),m_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(With(List(Set(q,Rt(Plus(Sqr(b),Times(CN1,C4,a,c)),C2))),Negate(Dist(Times(Power(Power(Plus(d,Times(e,x)),-1),Times(C2,p)),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),p),Power(Times(e,Power(Times(e,Plus(b,Negate(q),Times(C2,c,x)),Power(Times(C2,c,Plus(d,Times(e,x))),-1)),p),Power(Times(e,Plus(b,q,Times(C2,c,x)),Power(Times(C2,c,Plus(d,Times(e,x))),-1)),p)),-1)),Subst(Int(Times(Power(x,Plus(Negate(m),Times(CN1,C2,Plus(p,C1)))),Power(Simp(Plus(C1,Times(CN1,Plus(d,Times(CN1,e,Plus(b,Negate(q)),Power(Times(C2,c),-1))),x)),x),p),Power(Simp(Plus(C1,Times(CN1,Plus(d,Times(CN1,e,Plus(b,q),Power(Times(C2,c),-1))),x)),x),p)),x),x,Power(Plus(d,Times(e,x)),-1)),x))),And(FreeQ(List(a,b,c,d,e,p),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),NeQ(Plus(Times(C2,c,d),Times(CN1,b,e)),C0),Not(IntegerQ(p)),ILtQ(m,C0)))),
IIntegrate(759,Int(Times(Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),m_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(With(List(Set(q,Rt(Plus(Sqr(b),Times(CN1,C4,a,c)),C2))),Dist(Times(Power(Plus(a,Times(b,x),Times(c,Sqr(x))),p),Power(Times(e,Power(Plus(C1,Times(CN1,Plus(d,Times(e,x)),Power(Plus(d,Times(CN1,e,Plus(b,Negate(q)),Power(Times(C2,c),-1))),-1))),p),Power(Plus(C1,Times(CN1,Plus(d,Times(e,x)),Power(Plus(d,Times(CN1,e,Plus(b,q),Power(Times(C2,c),-1))),-1))),p)),-1)),Subst(Int(Times(Power(x,m),Power(Simp(Plus(C1,Times(CN1,x,Power(Plus(d,Times(CN1,e,Plus(b,Negate(q)),Power(Times(C2,c),-1))),-1))),x),p),Power(Simp(Plus(C1,Times(CN1,x,Power(Plus(d,Times(CN1,e,Plus(b,q),Power(Times(C2,c),-1))),-1))),x),p)),x),x,Plus(d,Times(e,x))),x)),And(FreeQ(List(a,b,c,d,e,m,p),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),NeQ(Plus(Times(C2,c,d),Times(CN1,b,e)),C0),Not(IntegerQ(p))))),
IIntegrate(760,Int(Times(Power(Plus(d_,Times(e_DEFAULT,x_)),m_),Power(Plus(a_,Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(CN1,a,c),C2))),Dist(Times(Power(Plus(a,Times(c,Sqr(x))),p),Power(Times(e,Power(Plus(C1,Times(CN1,Plus(d,Times(e,x)),Power(Plus(d,Times(e,q,Power(c,-1))),-1))),p),Power(Plus(C1,Times(CN1,Plus(d,Times(e,x)),Power(Plus(d,Times(CN1,e,q,Power(c,-1))),-1))),p)),-1)),Subst(Int(Times(Power(x,m),Power(Simp(Plus(C1,Times(CN1,x,Power(Plus(d,Times(e,q,Power(c,-1))),-1))),x),p),Power(Simp(Plus(C1,Times(CN1,x,Power(Plus(d,Times(CN1,e,q,Power(c,-1))),-1))),x),p)),x),x,Plus(d,Times(e,x))),x)),And(FreeQ(List(a,c,d,e,m,p),x),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),Not(IntegerQ(p))))),
IIntegrate(761,Int(Times(Power(Plus(d_DEFAULT,Times(e_DEFAULT,u_)),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,u_),Times(c_DEFAULT,Sqr(u_))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Power(Coefficient(u,x,C1),-1),Subst(Int(Times(Power(Plus(d,Times(e,x)),m),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),p)),x),x,u),x),And(FreeQ(List(a,b,c,d,e,m,p),x),LinearQ(u,x),NeQ(u,x)))),
IIntegrate(762,Int(Times(Power(Plus(d_DEFAULT,Times(e_DEFAULT,u_)),m_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Sqr(u_))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Power(Coefficient(u,x,C1),-1),Subst(Int(Times(Power(Plus(d,Times(e,x)),m),Power(Plus(a,Times(c,Sqr(x))),p)),x),x,u),x),And(FreeQ(List(a,c,d,e,m,p),x),LinearQ(u,x),NeQ(u,x)))),
IIntegrate(763,Int(Times(Power(Times(e_DEFAULT,x_),m_DEFAULT),Plus(f_,Times(g_DEFAULT,x_)),Power(Plus(Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Simp(Times(g,Power(Times(e,x),m),Power(Plus(Times(b,x),Times(c,Sqr(x))),Plus(p,C1)),Power(Times(c,Plus(m,Times(C2,p),C2)),-1)),x),And(FreeQ(List(b,c,e,f,g,m,p),x),EqQ(Plus(Times(b,g,Plus(m,p,C1)),Times(CN1,c,f,Plus(m,Times(C2,p),C2))),C0),NeQ(Plus(m,Times(C2,p),C2),C0)))),
IIntegrate(764,Int(Times(Power(x_,m_DEFAULT),Plus(f_,Times(g_DEFAULT,x_)),Power(Plus(a_,Times(c_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Dist(f,Int(Times(Power(x,m),Power(Plus(a,Times(c,Sqr(x))),p)),x),x),Dist(g,Int(Times(Power(x,Plus(m,C1)),Power(Plus(a,Times(c,Sqr(x))),p)),x),x)),And(FreeQ(List(a,c,f,g,p),x),IntegerQ(m),Not(IntegerQ(Times(C2,p)))))),
IIntegrate(765,Int(Times(Power(Times(e_DEFAULT,x_),m_DEFAULT),Plus(f_DEFAULT,Times(g_DEFAULT,x_)),Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times(Power(Times(e,x),m),Plus(f,Times(g,x)),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),p)),x),x),And(FreeQ(List(a,b,c,e,f,g,m),x),IntegerQ(p),Or(GtQ(p,C0),And(EqQ(a,C0),IntegerQ(m)))))),
IIntegrate(766,Int(Times(Power(Times(e_DEFAULT,x_),m_DEFAULT),Plus(f_DEFAULT,Times(g_DEFAULT,x_)),Power(Plus(a_,Times(c_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times(Power(Times(e,x),m),Plus(f,Times(g,x)),Power(Plus(a,Times(c,Sqr(x))),p)),x),x),And(FreeQ(List(a,c,e,f,g,m),x),IGtQ(p,C0)))),
IIntegrate(767,Int(Times(Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),m_DEFAULT),Plus(f_,Times(g_DEFAULT,x_)),Power(Plus(a_,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Negate(Simp(Times(f,g,Power(Plus(d,Times(e,x)),Plus(m,C1)),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),Plus(p,C1)),Power(Times(b,Plus(p,C1),Plus(Times(e,f),Times(CN1,d,g))),-1)),x)),And(FreeQ(List(a,b,c,d,e,f,g,m,p),x),EqQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),EqQ(Plus(m,Times(C2,p),C3),C0),EqQ(Plus(Times(C2,c,f),Times(CN1,b,g)),C0)))),
IIntegrate(768,Int(Times(Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),m_DEFAULT),Plus(f_DEFAULT,Times(g_DEFAULT,x_)),Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(g,Power(Plus(d,Times(e,x)),m),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),Plus(p,C1)),Power(Times(C2,c,Plus(p,C1)),-1)),x),Negate(Dist(Times(e,g,m,Power(Times(C2,c,Plus(p,C1)),-1)),Int(Times(Power(Plus(d,Times(e,x)),Plus(m,Negate(C1))),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),Plus(p,C1))),x),x))),And(FreeQ(List(a,b,c,d,e,f,g),x),EqQ(Plus(Times(C2,c,f),Times(CN1,b,g)),C0),LtQ(p,CN1),GtQ(m,C0)))),
IIntegrate(769,Int(Times(Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),m_DEFAULT),Plus(f_DEFAULT,Times(g_DEFAULT,x_)),Power(Plus(a_,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(CN2,c,Plus(Times(e,f),Times(CN1,d,g)),Power(Plus(d,Times(e,x)),Plus(m,C1)),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),Plus(p,C1)),Power(Times(Plus(p,C1),Sqr(Plus(Times(C2,c,d),Times(CN1,b,e)))),-1)),x),Dist(Times(Plus(Times(C2,c,f),Times(CN1,b,g)),Power(Plus(Times(C2,c,d),Times(CN1,b,e)),-1)),Int(Times(Power(Plus(d,Times(e,x)),Plus(m,C1)),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),p)),x),x)),And(FreeQ(List(a,b,c,d,e,f,g,m,p),x),EqQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),EqQ(Plus(m,Times(C2,p),C3),C0),NeQ(Plus(Times(C2,c,f),Times(CN1,b,g)),C0),NeQ(Plus(Times(C2,c,d),Times(CN1,b,e)),C0)))),
IIntegrate(770,Int(Times(Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),m_DEFAULT),Plus(f_DEFAULT,Times(g_DEFAULT,x_)),Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Dist(Times(Power(Plus(a,Times(b,x),Times(c,Sqr(x))),FracPart(p)),Power(Times(Power(c,IntPart(p)),Power(Plus(Times(C1D2,b),Times(c,x)),Times(C2,FracPart(p)))),-1)),Int(Times(Power(Plus(d,Times(e,x)),m),Plus(f,Times(g,x)),Power(Plus(Times(C1D2,b),Times(c,x)),Times(C2,p))),x),x),And(FreeQ(List(a,b,c,d,e,f,g,m),x),EqQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0)))),
IIntegrate(771,Int(Times(Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),m_DEFAULT),Plus(f_DEFAULT,Times(g_DEFAULT,x_)),Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times(Power(Plus(d,Times(e,x)),m),Plus(f,Times(g,x)),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),p)),x),x),And(FreeQ(List(a,b,c,d,e,f,g,m),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),IntegerQ(p),Or(GtQ(p,C0),And(EqQ(a,C0),IntegerQ(m)))))),
IIntegrate(772,Int(Times(Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),m_DEFAULT),Plus(f_DEFAULT,Times(g_DEFAULT,x_)),Power(Plus(a_,Times(c_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times(Power(Plus(d,Times(e,x)),m),Plus(f,Times(g,x)),Power(Plus(a,Times(c,Sqr(x))),p)),x),x),And(FreeQ(List(a,c,d,e,f,g,m),x),IGtQ(p,C0)))),
IIntegrate(773,Int(Times(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),Plus(f_,Times(g_DEFAULT,x_)),Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Simp(Times(e,g,x,Power(c,-1)),x),Dist(Power(c,-1),Int(Times(Plus(Times(c,d,f),Times(CN1,a,e,g),Times(Plus(Times(c,e,f),Times(c,d,g),Times(CN1,b,e,g)),x)),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f,g),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0)))),
IIntegrate(774,Int(Times(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),Plus(f_,Times(g_DEFAULT,x_)),Power(Plus(a_,Times(c_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Simp(Times(e,g,x,Power(c,-1)),x),Dist(Power(c,-1),Int(Times(Plus(Times(c,d,f),Times(CN1,a,e,g),Times(c,Plus(Times(e,f),Times(d,g)),x)),Power(Plus(a,Times(c,Sqr(x))),-1)),x),x)),FreeQ(List(a,c,d,e,f,g),x))),
IIntegrate(775,Int(Times(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),Plus(f_DEFAULT,Times(g_DEFAULT,x_)),Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Negate(Simp(Times(Plus(Times(b,e,g,Plus(p,C2)),Times(CN1,c,Plus(Times(e,f),Times(d,g)),Plus(Times(C2,p),C3)),Times(CN1,C2,c,e,g,Plus(p,C1),x)),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),Plus(p,C1)),Power(Times(C2,Sqr(c),Plus(p,C1),Plus(Times(C2,p),C3)),-1)),x)),And(FreeQ(List(a,b,c,d,e,f,g,p),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),EqQ(Plus(Times(Sqr(b),e,g,Plus(p,C2)),Times(CN1,C2,a,c,e,g),Times(c,Plus(Times(C2,c,d,f),Times(CN1,b,Plus(Times(e,f),Times(d,g)))),Plus(Times(C2,p),C3))),C0),NeQ(p,CN1)))),
IIntegrate(776,Int(Times(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),Plus(f_DEFAULT,Times(g_DEFAULT,x_)),Power(Plus(a_,Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Simp(Times(Plus(Times(Plus(Times(e,f),Times(d,g)),Plus(Times(C2,p),C3)),Times(C2,e,g,Plus(p,C1),x)),Power(Plus(a,Times(c,Sqr(x))),Plus(p,C1)),Power(Times(C2,c,Plus(p,C1),Plus(Times(C2,p),C3)),-1)),x),And(FreeQ(List(a,c,d,e,f,g,p),x),EqQ(Plus(Times(a,e,g),Times(CN1,c,d,f,Plus(Times(C2,p),C3))),C0),NeQ(p,CN1)))),
IIntegrate(777,Int(Times(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),Plus(f_DEFAULT,Times(g_DEFAULT,x_)),Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Plus(Times(C2,a,c,Plus(Times(e,f),Times(d,g))),Times(CN1,b,Plus(Times(c,d,f),Times(a,e,g))),Times(CN1,Plus(Times(Sqr(b),e,g),Times(CN1,b,c,Plus(Times(e,f),Times(d,g))),Times(C2,c,Plus(Times(c,d,f),Times(CN1,a,e,g)))),x)),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),Plus(p,C1)),Power(Times(c,Plus(p,C1),Plus(Sqr(b),Times(CN1,C4,a,c))),-1)),x)),Negate(Dist(Times(Plus(Times(Sqr(b),e,g,Plus(p,C2)),Times(CN1,C2,a,c,e,g),Times(c,Plus(Times(C2,c,d,f),Times(CN1,b,Plus(Times(e,f),Times(d,g)))),Plus(Times(C2,p),C3))),Power(Times(c,Plus(p,C1),Plus(Sqr(b),Times(CN1,C4,a,c))),-1)),Int(Power(Plus(a,Times(b,x),Times(c,Sqr(x))),Plus(p,C1)),x),x))),And(FreeQ(List(a,b,c,d,e,f,g),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),LtQ(p,CN1)))),
IIntegrate(778,Int(Times(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),Plus(f_DEFAULT,Times(g_DEFAULT,x_)),Power(Plus(a_,Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Plus(Times(a,Plus(Times(e,f),Times(d,g))),Times(CN1,Plus(Times(c,d,f),Times(CN1,a,e,g)),x)),Power(Plus(a,Times(c,Sqr(x))),Plus(p,C1)),Power(Times(C2,a,c,Plus(p,C1)),-1)),x),Negate(Dist(Times(Plus(Times(a,e,g),Times(CN1,c,d,f,Plus(Times(C2,p),C3))),Power(Times(C2,a,c,Plus(p,C1)),-1)),Int(Power(Plus(a,Times(c,Sqr(x))),Plus(p,C1)),x),x))),And(FreeQ(List(a,c,d,e,f,g),x),LtQ(p,CN1)))),
IIntegrate(779,Int(Times(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),Plus(f_DEFAULT,Times(g_DEFAULT,x_)),Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Plus(Times(b,e,g,Plus(p,C2)),Times(CN1,c,Plus(Times(e,f),Times(d,g)),Plus(Times(C2,p),C3)),Times(CN1,C2,c,e,g,Plus(p,C1),x)),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),Plus(p,C1)),Power(Times(C2,Sqr(c),Plus(p,C1),Plus(Times(C2,p),C3)),-1)),x)),Dist(Times(Plus(Times(Sqr(b),e,g,Plus(p,C2)),Times(CN1,C2,a,c,e,g),Times(c,Plus(Times(C2,c,d,f),Times(CN1,b,Plus(Times(e,f),Times(d,g)))),Plus(Times(C2,p),C3))),Power(Times(C2,Sqr(c),Plus(Times(C2,p),C3)),-1)),Int(Power(Plus(a,Times(b,x),Times(c,Sqr(x))),p),x),x)),And(FreeQ(List(a,b,c,d,e,f,g,p),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),Not(LeQ(p,CN1))))),
IIntegrate(780,Int(Times(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),Plus(f_DEFAULT,Times(g_DEFAULT,x_)),Power(Plus(a_,Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Plus(Times(Plus(Times(e,f),Times(d,g)),Plus(Times(C2,p),C3)),Times(C2,e,g,Plus(p,C1),x)),Power(Plus(a,Times(c,Sqr(x))),Plus(p,C1)),Power(Times(C2,c,Plus(p,C1),Plus(Times(C2,p),C3)),-1)),x),Negate(Dist(Times(Plus(Times(a,e,g),Times(CN1,c,d,f,Plus(Times(C2,p),C3))),Power(Times(c,Plus(Times(C2,p),C3)),-1)),Int(Power(Plus(a,Times(c,Sqr(x))),p),x),x))),And(FreeQ(List(a,c,d,e,f,g,p),x),Not(LeQ(p,CN1))))),
IIntegrate(781,Int(Times(Power(Times(e_DEFAULT,x_),m_DEFAULT),Plus(f_DEFAULT,Times(g_DEFAULT,x_)),Power(Plus(Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Power(Power(e,p),-1),Int(Times(Power(Times(e,x),Plus(m,p)),Plus(f,Times(g,x)),Power(Plus(b,Times(c,x)),p)),x),x),And(FreeQ(List(b,c,e,f,g,m),x),IntegerQ(p)))),
IIntegrate(782,Int(Times(Power(Plus(d_,Times(e_DEFAULT,x_)),m_),Plus(f_DEFAULT,Times(g_DEFAULT,x_)),Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(Plus(d,Times(e,x)),Plus(m,p)),Plus(f,Times(g,x)),Power(Plus(Times(a,Power(d,-1)),Times(c,x,Power(e,-1))),p)),x),And(FreeQ(List(a,b,c,d,e,f,g,m),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),EqQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),IntegerQ(p)))),
IIntegrate(783,Int(Times(Power(Plus(d_,Times(e_DEFAULT,x_)),m_),Plus(f_DEFAULT,Times(g_DEFAULT,x_)),Power(Plus(a_,Times(c_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(Plus(d,Times(e,x)),Plus(m,p)),Plus(f,Times(g,x)),Power(Plus(Times(a,Power(d,-1)),Times(c,x,Power(e,-1))),p)),x),And(FreeQ(List(a,c,d,e,f,g,m),x),EqQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),Or(IntegerQ(p),And(GtQ(a,C0),GtQ(d,C0),EqQ(Plus(m,p),C0)))))),
IIntegrate(784,Int(Times(Power(Plus(d_,Times(e_DEFAULT,x_)),m_),Plus(f_DEFAULT,Times(g_DEFAULT,x_)),Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Dist(Times(Power(d,m),Power(e,m)),Int(Times(Plus(f,Times(g,x)),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),Plus(m,p)),Power(Power(Plus(Times(a,e),Times(c,d,x)),m),-1)),x),x),And(FreeQ(List(a,b,c,d,e,f,g,p),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),EqQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),Not(IntegerQ(Times(C2,p))),ILtQ(m,C0)))),
IIntegrate(785,Int(Times(x_,Power(Plus(d_,Times(e_DEFAULT,x_)),m_),Power(Plus(a_,Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Dist(Times(Power(d,m),Power(e,m)),Int(Times(x,Power(Plus(a,Times(c,Sqr(x))),Plus(m,p)),Power(Power(Plus(Times(a,e),Times(c,d,x)),m),-1)),x),x),And(FreeQ(List(a,c,d,e,p),x),EqQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),Not(IntegerQ(p)),ILtQ(m,C0),EqQ(m,CN1),Not(ILtQ(Plus(p,Negate(C1D2)),C0))))),
IIntegrate(786,Int(Times(Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),m_),Plus(f_DEFAULT,Times(g_DEFAULT,x_)),Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Simp(Times(g,Power(Plus(d,Times(e,x)),m),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),Plus(p,C1)),Power(Times(c,Plus(m,Times(C2,p),C2)),-1)),x),And(FreeQ(List(a,b,c,d,e,f,g,m,p),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),EqQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),EqQ(Plus(Times(m,Plus(Times(g,Plus(Times(c,d),Times(CN1,b,e))),Times(c,e,f))),Times(e,Plus(p,C1),Plus(Times(C2,c,f),Times(CN1,b,g)))),C0)))),
IIntegrate(787,Int(Times(Power(Plus(d_,Times(e_DEFAULT,x_)),m_),Plus(f_DEFAULT,Times(g_DEFAULT,x_)),Power(Plus(a_,Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Simp(Times(g,Power(Plus(d,Times(e,x)),m),Power(Plus(a,Times(c,Sqr(x))),Plus(p,C1)),Power(Times(c,Plus(m,Times(C2,p),C2)),-1)),x),And(FreeQ(List(a,c,d,e,f,g,m,p),x),EqQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),EqQ(Plus(Times(m,Plus(Times(d,g),Times(e,f))),Times(C2,e,f,Plus(p,C1))),C0)))),
IIntegrate(788,Int(Times(Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),m_),Plus(f_DEFAULT,Times(g_DEFAULT,x_)),Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Plus(Times(g,Plus(Times(c,d),Times(CN1,b,e))),Times(c,e,f)),Power(Plus(d,Times(e,x)),m),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),Plus(p,C1)),Power(Times(c,Plus(p,C1),Plus(Times(C2,c,d),Times(CN1,b,e))),-1)),x),Negate(Dist(Times(e,Plus(Times(m,Plus(Times(g,Plus(Times(c,d),Times(CN1,b,e))),Times(c,e,f))),Times(e,Plus(p,C1),Plus(Times(C2,c,f),Times(CN1,b,g)))),Power(Times(c,Plus(p,C1),Plus(Times(C2,c,d),Times(CN1,b,e))),-1)),Int(Times(Power(Plus(d,Times(e,x)),Plus(m,Negate(C1))),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),Plus(p,C1))),x),x))),And(FreeQ(List(a,b,c,d,e,f,g),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),EqQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),LtQ(p,CN1),GtQ(m,C0)))),
IIntegrate(789,Int(Times(Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),m_),Plus(f_DEFAULT,Times(g_DEFAULT,x_)),Power(Plus(a_,Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Plus(Times(d,g),Times(e,f)),Power(Plus(d,Times(e,x)),m),Power(Plus(a,Times(c,Sqr(x))),Plus(p,C1)),Power(Times(C2,c,d,Plus(p,C1)),-1)),x),Negate(Dist(Times(e,Plus(Times(m,Plus(Times(d,g),Times(e,f))),Times(C2,e,f,Plus(p,C1))),Power(Times(C2,c,d,Plus(p,C1)),-1)),Int(Times(Power(Plus(d,Times(e,x)),Plus(m,Negate(C1))),Power(Plus(a,Times(c,Sqr(x))),Plus(p,C1))),x),x))),And(FreeQ(List(a,c,d,e,f,g),x),EqQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),LtQ(p,CN1),GtQ(m,C0)))),
IIntegrate(790,Int(Times(Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),m_),Plus(f_DEFAULT,Times(g_DEFAULT,x_)),Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Plus(Times(g,Plus(Times(c,d),Times(CN1,b,e))),Times(c,e,f)),Power(Plus(d,Times(e,x)),m),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),Plus(p,C1)),Power(Times(c,Plus(p,C1),Plus(Times(C2,c,d),Times(CN1,b,e))),-1)),x),Negate(Dist(Times(e,Plus(Times(m,Plus(Times(g,Plus(Times(c,d),Times(CN1,b,e))),Times(c,e,f))),Times(e,Plus(p,C1),Plus(Times(C2,c,f),Times(CN1,b,g)))),Power(Times(c,Plus(p,C1),Plus(Times(C2,c,d),Times(CN1,b,e))),-1)),Int(Times(Power(Plus(d,Times(e,x)),Simplify(Plus(m,Negate(C1)))),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),Simplify(Plus(p,C1)))),x),x))),And(FreeQ(List(a,b,c,d,e,f,g,m,p),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),EqQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),SumSimplerQ(p,C1),SumSimplerQ(m,CN1),NeQ(p,CN1)))),
IIntegrate(791,Int(Times(Power(Plus(d_,Times(e_DEFAULT,x_)),m_),Plus(f_DEFAULT,Times(g_DEFAULT,x_)),Power(Plus(a_,Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Plus(Times(d,g),Times(e,f)),Power(Plus(d,Times(e,x)),m),Power(Plus(a,Times(c,Sqr(x))),Plus(p,C1)),Power(Times(C2,c,d,Plus(p,C1)),-1)),x),Negate(Dist(Times(e,Plus(Times(m,Plus(Times(d,g),Times(e,f))),Times(C2,e,f,Plus(p,C1))),Power(Times(C2,c,d,Plus(p,C1)),-1)),Int(Times(Power(Plus(d,Times(e,x)),Simplify(Plus(m,Negate(C1)))),Power(Plus(a,Times(c,Sqr(x))),Simplify(Plus(p,C1)))),x),x))),And(FreeQ(List(a,c,d,e,f,g,m,p),x),EqQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),SumSimplerQ(p,C1),SumSimplerQ(m,CN1),NeQ(p,CN1),Not(IGtQ(m,C0))))),
IIntegrate(792,Int(Times(Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),m_),Plus(f_DEFAULT,Times(g_DEFAULT,x_)),Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Plus(Times(d,g),Times(CN1,e,f)),Power(Plus(d,Times(e,x)),m),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),Plus(p,C1)),Power(Times(Plus(Times(C2,c,d),Times(CN1,b,e)),Plus(m,p,C1)),-1)),x),Dist(Times(Plus(Times(m,Plus(Times(g,Plus(Times(c,d),Times(CN1,b,e))),Times(c,e,f))),Times(e,Plus(p,C1),Plus(Times(C2,c,f),Times(CN1,b,g)))),Power(Times(e,Plus(Times(C2,c,d),Times(CN1,b,e)),Plus(m,p,C1)),-1)),Int(Times(Power(Plus(d,Times(e,x)),Plus(m,C1)),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),p)),x),x)),And(FreeQ(List(a,b,c,d,e,f,g,m,p),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),EqQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),Or(And(LtQ(m,CN1),Not(IGtQ(Plus(m,p,C1),C0))),And(LtQ(m,C0),LtQ(p,CN1)),EqQ(Plus(m,Times(C2,p),C2),C0)),NeQ(Plus(m,p,C1),C0)))),
IIntegrate(793,Int(Times(Power(Plus(d_,Times(e_DEFAULT,x_)),m_),Plus(f_DEFAULT,Times(g_DEFAULT,x_)),Power(Plus(a_,Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Plus(Times(d,g),Times(CN1,e,f)),Power(Plus(d,Times(e,x)),m),Power(Plus(a,Times(c,Sqr(x))),Plus(p,C1)),Power(Times(C2,c,d,Plus(m,p,C1)),-1)),x),Dist(Times(Plus(Times(m,Plus(Times(g,c,d),Times(c,e,f))),Times(C2,e,c,f,Plus(p,C1))),Power(Times(e,C2,c,d,Plus(m,p,C1)),-1)),Int(Times(Power(Plus(d,Times(e,x)),Plus(m,C1)),Power(Plus(a,Times(c,Sqr(x))),p)),x),x)),And(FreeQ(List(a,c,d,e,f,g,m,p),x),EqQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),Or(And(LtQ(m,CN1),Not(IGtQ(Plus(m,p,C1),C0))),And(LtQ(m,C0),LtQ(p,CN1)),EqQ(Plus(m,Times(C2,p),C2),C0)),NeQ(Plus(m,p,C1),C0)))),
IIntegrate(794,Int(Times(Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),m_),Plus(f_DEFAULT,Times(g_DEFAULT,x_)),Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(g,Power(Plus(d,Times(e,x)),m),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),Plus(p,C1)),Power(Times(c,Plus(m,Times(C2,p),C2)),-1)),x),Dist(Times(Plus(Times(m,Plus(Times(g,Plus(Times(c,d),Times(CN1,b,e))),Times(c,e,f))),Times(e,Plus(p,C1),Plus(Times(C2,c,f),Times(CN1,b,g)))),Power(Times(c,e,Plus(m,Times(C2,p),C2)),-1)),Int(Times(Power(Plus(d,Times(e,x)),m),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),p)),x),x)),And(FreeQ(List(a,b,c,d,e,f,g,m,p),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),EqQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),NeQ(Plus(m,Times(C2,p),C2),C0),Or(NeQ(m,C2),EqQ(d,C0))))),
IIntegrate(795,Int(Times(Power(Plus(d_,Times(e_DEFAULT,x_)),m_),Plus(f_DEFAULT,Times(g_DEFAULT,x_)),Power(Plus(a_,Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(g,Power(Plus(d,Times(e,x)),m),Power(Plus(a,Times(c,Sqr(x))),Plus(p,C1)),Power(Times(c,Plus(m,Times(C2,p),C2)),-1)),x),Dist(Times(Plus(Times(m,Plus(Times(d,g),Times(e,f))),Times(C2,e,f,Plus(p,C1))),Power(Times(e,Plus(m,Times(C2,p),C2)),-1)),Int(Times(Power(Plus(d,Times(e,x)),m),Power(Plus(a,Times(c,Sqr(x))),p)),x),x)),And(FreeQ(List(a,c,d,e,f,g,m,p),x),EqQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),NeQ(Plus(m,Times(C2,p),C2),C0),NeQ(m,C2)))),
IIntegrate(796,Int(Times(Sqr(x_),Plus(f_,Times(g_DEFAULT,x_)),Power(Plus(a_,Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Sqr(x),Plus(Times(a,g),Times(CN1,c,f,x)),Power(Plus(a,Times(c,Sqr(x))),Plus(p,C1)),Power(Times(C2,a,c,Plus(p,C1)),-1)),x),Negate(Dist(Power(Times(C2,a,c,Plus(p,C1)),-1),Int(Times(x,Simp(Plus(Times(C2,a,g),Times(CN1,c,f,Plus(Times(C2,p),C5),x)),x),Power(Plus(a,Times(c,Sqr(x))),Plus(p,C1))),x),x))),And(FreeQ(List(a,c,f,g),x),EqQ(Plus(Times(a,Sqr(g)),Times(Sqr(f),c)),C0),LtQ(p,CN2)))),
IIntegrate(797,Int(Times(Sqr(x_),Plus(f_,Times(g_DEFAULT,x_)),Power(Plus(a_,Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Plus(Dist(Power(c,-1),Int(Times(Plus(f,Times(g,x)),Power(Plus(a,Times(c,Sqr(x))),Plus(p,C1))),x),x),Negate(Dist(Times(a,Power(c,-1)),Int(Times(Plus(f,Times(g,x)),Power(Plus(a,Times(c,Sqr(x))),p)),x),x))),And(FreeQ(List(a,c,f,g,p),x),EqQ(Plus(Times(a,Sqr(g)),Times(Sqr(f),c)),C0)))),
IIntegrate(798,Int(Times(Power(Plus(d_,Times(e_DEFAULT,x_)),m_),Plus(f_DEFAULT,Times(g_DEFAULT,x_)),Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(Plus(d,Times(e,x)),m),Power(Plus(f,Times(g,x)),Plus(p,C1)),Power(Plus(Times(a,Power(f,-1)),Times(c,x,Power(g,-1))),p)),x),And(FreeQ(List(a,b,c,d,e,f,g,m),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),EqQ(Plus(Times(c,Sqr(f)),Times(CN1,b,f,g),Times(a,Sqr(g))),C0),IntegerQ(p)))),
IIntegrate(799,Int(Times(Power(Plus(d_,Times(e_DEFAULT,x_)),m_),Plus(f_DEFAULT,Times(g_DEFAULT,x_)),Power(Plus(a_DEFAULT,Times(c_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(Plus(d,Times(e,x)),m),Power(Plus(f,Times(g,x)),Plus(p,C1)),Power(Plus(Times(a,Power(f,-1)),Times(c,x,Power(g,-1))),p)),x),And(FreeQ(List(a,c,d,e,f,g,m),x),EqQ(Plus(Times(c,Sqr(f)),Times(a,Sqr(g))),C0),Or(IntegerQ(p),And(GtQ(a,C0),GtQ(f,C0),EqQ(p,CN1)))))),
IIntegrate(800,Int(Times(Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),m_),Plus(f_DEFAULT,Times(g_DEFAULT,x_)),Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times(Power(Plus(d,Times(e,x)),m),Plus(f,Times(g,x)),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),-1)),x),x),And(FreeQ(List(a,b,c,d,e,f,g),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),IntegerQ(m))))
  );
}
