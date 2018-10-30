package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcCot;
import static org.matheclipse.core.expression.F.ArcCoth;
import static org.matheclipse.core.expression.F.ArcTan;
import static org.matheclipse.core.expression.F.ArcTanh;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CI;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Csc;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.PolyLog;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sec;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
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
import static org.matheclipse.core.expression.F.k;
import static org.matheclipse.core.expression.F.k_;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntHide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumQ;

/** 
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class IntRules99 { 
  public static IAST RULES = List( 
IIntegrate(4951,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCot(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_DEFAULT)),x_Symbol),
    Condition(Plus(Dist(d,Int(Times(Power(Times(f,x),m),Power(Plus(d,Times(e,Sqr(x))),Plus(q,Negate(C1))),Power(Plus(a,Times(b,ArcCot(Times(c,x)))),p)),x),x),Dist(Times(Sqr(c),d,Power(f,-2)),Int(Times(Power(Times(f,x),Plus(m,C2)),Power(Plus(d,Times(e,Sqr(x))),Plus(q,Negate(C1))),Power(Plus(a,Times(b,ArcCot(Times(c,x)))),p)),x),x)),And(FreeQ(List(a,b,c,d,e,f,m),x),EqQ(e,Times(Sqr(c),d)),GtQ(q,C0),IGtQ(p,C0),Or(RationalQ(m),And(EqQ(p,C1),IntegerQ(q)))))),
IIntegrate(4952,Int(Times(Power(Plus(a_DEFAULT,Times(ArcTan(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),CN1D2)),x_Symbol),
    Condition(Plus(Simp(Times(f,Power(Times(f,x),Plus(m,Negate(C1))),Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Plus(a,Times(b,ArcTan(Times(c,x)))),p),Power(Times(Sqr(c),d,m),-1)),x),Negate(Dist(Times(b,f,p,Power(Times(c,m),-1)),Int(Times(Power(Times(f,x),Plus(m,Negate(C1))),Power(Plus(a,Times(b,ArcTan(Times(c,x)))),Plus(p,Negate(C1))),Power(Plus(d,Times(e,Sqr(x))),CN1D2)),x),x)),Negate(Dist(Times(Sqr(f),Plus(m,Negate(C1)),Power(Times(Sqr(c),m),-1)),Int(Times(Power(Times(f,x),Plus(m,Negate(C2))),Power(Plus(a,Times(b,ArcTan(Times(c,x)))),p),Power(Plus(d,Times(e,Sqr(x))),CN1D2)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),EqQ(e,Times(Sqr(c),d)),GtQ(p,C0),GtQ(m,C1)))),
IIntegrate(4953,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCot(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),CN1D2)),x_Symbol),
    Condition(Plus(Simp(Times(f,Power(Times(f,x),Plus(m,Negate(C1))),Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Plus(a,Times(b,ArcCot(Times(c,x)))),p),Power(Times(Sqr(c),d,m),-1)),x),Dist(Times(b,f,p,Power(Times(c,m),-1)),Int(Times(Power(Times(f,x),Plus(m,Negate(C1))),Power(Plus(a,Times(b,ArcCot(Times(c,x)))),Plus(p,Negate(C1))),Power(Plus(d,Times(e,Sqr(x))),CN1D2)),x),x),Negate(Dist(Times(Sqr(f),Plus(m,Negate(C1)),Power(Times(Sqr(c),m),-1)),Int(Times(Power(Times(f,x),Plus(m,Negate(C2))),Power(Plus(a,Times(b,ArcCot(Times(c,x)))),p),Power(Plus(d,Times(e,Sqr(x))),CN1D2)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),EqQ(e,Times(Sqr(c),d)),GtQ(p,C0),GtQ(m,C1)))),
IIntegrate(4954,Int(Times(Plus(a_DEFAULT,Times(ArcTan(Times(c_DEFAULT,x_)),b_DEFAULT)),Power(x_,-1),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),CN1D2)),x_Symbol),
    Condition(Plus(Simp(Times(CN2,Plus(a,Times(b,ArcTan(Times(c,x)))),ArcTanh(Times(Sqrt(Plus(C1,Times(CI,c,x))),Power(Plus(C1,Times(CN1,CI,c,x)),CN1D2))),Power(d,CN1D2)),x),Simp(Times(CI,b,PolyLog(C2,Times(CN1,Sqrt(Plus(C1,Times(CI,c,x))),Power(Plus(C1,Times(CN1,CI,c,x)),CN1D2))),Power(d,CN1D2)),x),Negate(Simp(Times(CI,b,PolyLog(C2,Times(Sqrt(Plus(C1,Times(CI,c,x))),Power(Plus(C1,Times(CN1,CI,c,x)),CN1D2))),Power(d,CN1D2)),x))),And(FreeQ(List(a,b,c,d,e),x),EqQ(e,Times(Sqr(c),d)),GtQ(d,C0)))),
IIntegrate(4955,Int(Times(Plus(a_DEFAULT,Times(ArcCot(Times(c_DEFAULT,x_)),b_DEFAULT)),Power(x_,-1),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),CN1D2)),x_Symbol),
    Condition(Plus(Simp(Times(CN2,Plus(a,Times(b,ArcCot(Times(c,x)))),ArcTanh(Times(Sqrt(Plus(C1,Times(CI,c,x))),Power(Plus(C1,Times(CN1,CI,c,x)),CN1D2))),Power(d,CN1D2)),x),Negate(Simp(Times(CI,b,PolyLog(C2,Times(CN1,Sqrt(Plus(C1,Times(CI,c,x))),Power(Plus(C1,Times(CN1,CI,c,x)),CN1D2))),Power(d,CN1D2)),x)),Simp(Times(CI,b,PolyLog(C2,Times(Sqrt(Plus(C1,Times(CI,c,x))),Power(Plus(C1,Times(CN1,CI,c,x)),CN1D2))),Power(d,CN1D2)),x)),And(FreeQ(List(a,b,c,d,e),x),EqQ(e,Times(Sqr(c),d)),GtQ(d,C0)))),
IIntegrate(4956,Int(Times(Power(Plus(a_DEFAULT,Times(ArcTan(Times(c_DEFAULT,x_)),b_DEFAULT)),p_),Power(x_,-1),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),CN1D2)),x_Symbol),
    Condition(Dist(Power(d,CN1D2),Subst(Int(Times(Power(Plus(a,Times(b,x)),p),Csc(x)),x),x,ArcTan(Times(c,x))),x),And(FreeQ(List(a,b,c,d,e),x),EqQ(e,Times(Sqr(c),d)),IGtQ(p,C0),GtQ(d,C0)))),
IIntegrate(4957,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCot(Times(c_DEFAULT,x_)),b_DEFAULT)),p_),Power(x_,-1),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),CN1D2)),x_Symbol),
    Condition(Negate(Dist(Times(c,x,Sqrt(Plus(C1,Power(Times(Sqr(c),Sqr(x)),-1))),Power(Plus(d,Times(e,Sqr(x))),CN1D2)),Subst(Int(Times(Power(Plus(a,Times(b,x)),p),Sec(x)),x),x,ArcCot(Times(c,x))),x)),And(FreeQ(List(a,b,c,d,e),x),EqQ(e,Times(Sqr(c),d)),IGtQ(p,C0),GtQ(d,C0)))),
IIntegrate(4958,Int(Times(Power(Plus(a_DEFAULT,Times(ArcTan(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(x_,-1),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),CN1D2)),x_Symbol),
    Condition(Dist(Times(Sqrt(Plus(C1,Times(Sqr(c),Sqr(x)))),Power(Plus(d,Times(e,Sqr(x))),CN1D2)),Int(Times(Power(Plus(a,Times(b,ArcTan(Times(c,x)))),p),Power(Times(x,Sqrt(Plus(C1,Times(Sqr(c),Sqr(x))))),-1)),x),x),And(FreeQ(List(a,b,c,d,e),x),EqQ(e,Times(Sqr(c),d)),IGtQ(p,C0),Not(GtQ(d,C0))))),
IIntegrate(4959,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCot(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(x_,-1),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),CN1D2)),x_Symbol),
    Condition(Dist(Times(Sqrt(Plus(C1,Times(Sqr(c),Sqr(x)))),Power(Plus(d,Times(e,Sqr(x))),CN1D2)),Int(Times(Power(Plus(a,Times(b,ArcCot(Times(c,x)))),p),Power(Times(x,Sqrt(Plus(C1,Times(Sqr(c),Sqr(x))))),-1)),x),x),And(FreeQ(List(a,b,c,d,e),x),EqQ(e,Times(Sqr(c),d)),IGtQ(p,C0),Not(GtQ(d,C0))))),
IIntegrate(4960,Int(Times(Power(Plus(a_DEFAULT,Times(ArcTan(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(x_,-2),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),CN1D2)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Plus(a,Times(b,ArcTan(Times(c,x)))),p),Power(Times(d,x),-1)),x)),Dist(Times(b,c,p),Int(Times(Power(Plus(a,Times(b,ArcTan(Times(c,x)))),Plus(p,Negate(C1))),Power(Times(x,Sqrt(Plus(d,Times(e,Sqr(x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e),x),EqQ(e,Times(Sqr(c),d)),GtQ(p,C0)))),
IIntegrate(4961,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCot(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(x_,-2),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),CN1D2)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Plus(a,Times(b,ArcCot(Times(c,x)))),p),Power(Times(d,x),-1)),x)),Negate(Dist(Times(b,c,p),Int(Times(Power(Plus(a,Times(b,ArcCot(Times(c,x)))),Plus(p,Negate(C1))),Power(Times(x,Sqrt(Plus(d,Times(e,Sqr(x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e),x),EqQ(e,Times(Sqr(c),d)),GtQ(p,C0)))),
IIntegrate(4962,Int(Times(Power(Plus(a_DEFAULT,Times(ArcTan(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),CN1D2)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(f,x),Plus(m,C1)),Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Plus(a,Times(b,ArcTan(Times(c,x)))),p),Power(Times(d,f,Plus(m,C1)),-1)),x),Negate(Dist(Times(b,c,p,Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(a,Times(b,ArcTan(Times(c,x)))),Plus(p,Negate(C1))),Power(Plus(d,Times(e,Sqr(x))),CN1D2)),x),x)),Negate(Dist(Times(Sqr(c),Plus(m,C2),Power(Times(Sqr(f),Plus(m,C1)),-1)),Int(Times(Power(Times(f,x),Plus(m,C2)),Power(Plus(a,Times(b,ArcTan(Times(c,x)))),p),Power(Plus(d,Times(e,Sqr(x))),CN1D2)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),EqQ(e,Times(Sqr(c),d)),GtQ(p,C0),LtQ(m,CN1),NeQ(m,CN2)))),
IIntegrate(4963,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCot(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),CN1D2)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(f,x),Plus(m,C1)),Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Plus(a,Times(b,ArcCot(Times(c,x)))),p),Power(Times(d,f,Plus(m,C1)),-1)),x),Dist(Times(b,c,p,Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(a,Times(b,ArcCot(Times(c,x)))),Plus(p,Negate(C1))),Power(Plus(d,Times(e,Sqr(x))),CN1D2)),x),x),Negate(Dist(Times(Sqr(c),Plus(m,C2),Power(Times(Sqr(f),Plus(m,C1)),-1)),Int(Times(Power(Times(f,x),Plus(m,C2)),Power(Plus(a,Times(b,ArcCot(Times(c,x)))),p),Power(Plus(d,Times(e,Sqr(x))),CN1D2)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),EqQ(e,Times(Sqr(c),d)),GtQ(p,C0),LtQ(m,CN1),NeQ(m,CN2)))),
IIntegrate(4964,Int(Times(Power(Plus(a_DEFAULT,Times(ArcTan(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(x_,m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_)),x_Symbol),
    Condition(Plus(Dist(Power(e,-1),Int(Times(Power(x,Plus(m,Negate(C2))),Power(Plus(d,Times(e,Sqr(x))),Plus(q,C1)),Power(Plus(a,Times(b,ArcTan(Times(c,x)))),p)),x),x),Negate(Dist(Times(d,Power(e,-1)),Int(Times(Power(x,Plus(m,Negate(C2))),Power(Plus(d,Times(e,Sqr(x))),q),Power(Plus(a,Times(b,ArcTan(Times(c,x)))),p)),x),x))),And(FreeQ(List(a,b,c,d,e),x),EqQ(e,Times(Sqr(c),d)),IntegersQ(p,Times(C2,q)),LtQ(q,CN1),IGtQ(m,C1),NeQ(p,CN1)))),
IIntegrate(4965,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCot(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(x_,m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_)),x_Symbol),
    Condition(Plus(Dist(Power(e,-1),Int(Times(Power(x,Plus(m,Negate(C2))),Power(Plus(d,Times(e,Sqr(x))),Plus(q,C1)),Power(Plus(a,Times(b,ArcCot(Times(c,x)))),p)),x),x),Negate(Dist(Times(d,Power(e,-1)),Int(Times(Power(x,Plus(m,Negate(C2))),Power(Plus(d,Times(e,Sqr(x))),q),Power(Plus(a,Times(b,ArcCot(Times(c,x)))),p)),x),x))),And(FreeQ(List(a,b,c,d,e),x),EqQ(e,Times(Sqr(c),d)),IntegersQ(p,Times(C2,q)),LtQ(q,CN1),IGtQ(m,C1),NeQ(p,CN1)))),
IIntegrate(4966,Int(Times(Power(Plus(a_DEFAULT,Times(ArcTan(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(x_,m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_)),x_Symbol),
    Condition(Plus(Dist(Power(d,-1),Int(Times(Power(x,m),Power(Plus(d,Times(e,Sqr(x))),Plus(q,C1)),Power(Plus(a,Times(b,ArcTan(Times(c,x)))),p)),x),x),Negate(Dist(Times(e,Power(d,-1)),Int(Times(Power(x,Plus(m,C2)),Power(Plus(d,Times(e,Sqr(x))),q),Power(Plus(a,Times(b,ArcTan(Times(c,x)))),p)),x),x))),And(FreeQ(List(a,b,c,d,e),x),EqQ(e,Times(Sqr(c),d)),IntegersQ(p,Times(C2,q)),LtQ(q,CN1),ILtQ(m,C0),NeQ(p,CN1)))),
IIntegrate(4967,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCot(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(x_,m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_)),x_Symbol),
    Condition(Plus(Dist(Power(d,-1),Int(Times(Power(x,m),Power(Plus(d,Times(e,Sqr(x))),Plus(q,C1)),Power(Plus(a,Times(b,ArcCot(Times(c,x)))),p)),x),x),Negate(Dist(Times(e,Power(d,-1)),Int(Times(Power(x,Plus(m,C2)),Power(Plus(d,Times(e,Sqr(x))),q),Power(Plus(a,Times(b,ArcCot(Times(c,x)))),p)),x),x))),And(FreeQ(List(a,b,c,d,e),x),EqQ(e,Times(Sqr(c),d)),IntegersQ(p,Times(C2,q)),LtQ(q,CN1),ILtQ(m,C0),NeQ(p,CN1)))),
IIntegrate(4968,Int(Times(Power(Plus(a_DEFAULT,Times(ArcTan(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(x_,m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(x,m),Power(Plus(d,Times(e,Sqr(x))),Plus(q,C1)),Power(Plus(a,Times(b,ArcTan(Times(c,x)))),Plus(p,C1)),Power(Times(b,c,d,Plus(p,C1)),-1)),x),Negate(Dist(Times(c,Plus(m,Times(C2,q),C2),Power(Times(b,Plus(p,C1)),-1)),Int(Times(Power(x,Plus(m,C1)),Power(Plus(d,Times(e,Sqr(x))),q),Power(Plus(a,Times(b,ArcTan(Times(c,x)))),Plus(p,C1))),x),x)),Negate(Dist(Times(m,Power(Times(b,c,Plus(p,C1)),-1)),Int(Times(Power(x,Plus(m,Negate(C1))),Power(Plus(d,Times(e,Sqr(x))),q),Power(Plus(a,Times(b,ArcTan(Times(c,x)))),Plus(p,C1))),x),x))),And(FreeQ(List(a,b,c,d,e,m),x),EqQ(e,Times(Sqr(c),d)),IntegerQ(m),LtQ(q,CN1),LtQ(p,CN1),NeQ(Plus(m,Times(C2,q),C2),C0)))),
IIntegrate(4969,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCot(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(x_,m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Power(x,m),Power(Plus(d,Times(e,Sqr(x))),Plus(q,C1)),Power(Plus(a,Times(b,ArcCot(Times(c,x)))),Plus(p,C1)),Power(Times(b,c,d,Plus(p,C1)),-1)),x)),Dist(Times(c,Plus(m,Times(C2,q),C2),Power(Times(b,Plus(p,C1)),-1)),Int(Times(Power(x,Plus(m,C1)),Power(Plus(d,Times(e,Sqr(x))),q),Power(Plus(a,Times(b,ArcCot(Times(c,x)))),Plus(p,C1))),x),x),Dist(Times(m,Power(Times(b,c,Plus(p,C1)),-1)),Int(Times(Power(x,Plus(m,Negate(C1))),Power(Plus(d,Times(e,Sqr(x))),q),Power(Plus(a,Times(b,ArcCot(Times(c,x)))),Plus(p,C1))),x),x)),And(FreeQ(List(a,b,c,d,e,m),x),EqQ(e,Times(Sqr(c),d)),IntegerQ(m),LtQ(q,CN1),LtQ(p,CN1),NeQ(Plus(m,Times(C2,q),C2),C0)))),
IIntegrate(4970,Int(Times(Power(Plus(a_DEFAULT,Times(ArcTan(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(x_,m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_)),x_Symbol),
    Condition(Dist(Times(Power(d,q),Power(Power(c,Plus(m,C1)),-1)),Subst(Int(Times(Power(Plus(a,Times(b,x)),p),Power(Sin(x),m),Power(Power(Cos(x),Plus(m,Times(C2,Plus(q,C1)))),-1)),x),x,ArcTan(Times(c,x))),x),And(FreeQ(List(a,b,c,d,e,p),x),EqQ(e,Times(Sqr(c),d)),IGtQ(m,C0),ILtQ(Plus(m,Times(C2,q),C1),C0),Or(IntegerQ(q),GtQ(d,C0))))),
IIntegrate(4971,Int(Times(Power(Plus(a_DEFAULT,Times(ArcTan(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(x_,m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_)),x_Symbol),
    Condition(Dist(Times(Power(d,Plus(q,C1D2)),Sqrt(Plus(C1,Times(Sqr(c),Sqr(x)))),Power(Plus(d,Times(e,Sqr(x))),CN1D2)),Int(Times(Power(x,m),Power(Plus(C1,Times(Sqr(c),Sqr(x))),q),Power(Plus(a,Times(b,ArcTan(Times(c,x)))),p)),x),x),And(FreeQ(List(a,b,c,d,e,p),x),EqQ(e,Times(Sqr(c),d)),IGtQ(m,C0),ILtQ(Plus(m,Times(C2,q),C1),C0),Not(Or(IntegerQ(q),GtQ(d,C0)))))),
IIntegrate(4972,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCot(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(x_,m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_)),x_Symbol),
    Condition(Negate(Dist(Times(Power(d,q),Power(Power(c,Plus(m,C1)),-1)),Subst(Int(Times(Power(Plus(a,Times(b,x)),p),Power(Cos(x),m),Power(Power(Sin(x),Plus(m,Times(C2,Plus(q,C1)))),-1)),x),x,ArcCot(Times(c,x))),x)),And(FreeQ(List(a,b,c,d,e,p),x),EqQ(e,Times(Sqr(c),d)),IGtQ(m,C0),ILtQ(Plus(m,Times(C2,q),C1),C0),IntegerQ(q)))),
IIntegrate(4973,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCot(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(x_,m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_)),x_Symbol),
    Condition(Negate(Dist(Times(Power(d,Plus(q,C1D2)),x,Sqrt(Times(Plus(C1,Times(Sqr(c),Sqr(x))),Power(Times(Sqr(c),Sqr(x)),-1))),Power(Times(Power(c,m),Sqrt(Plus(d,Times(e,Sqr(x))))),-1)),Subst(Int(Times(Power(Plus(a,Times(b,x)),p),Power(Cos(x),m),Power(Power(Sin(x),Plus(m,Times(C2,Plus(q,C1)))),-1)),x),x,ArcCot(Times(c,x))),x)),And(FreeQ(List(a,b,c,d,e,p),x),EqQ(e,Times(Sqr(c),d)),IGtQ(m,C0),ILtQ(Plus(m,Times(C2,q),C1),C0),Not(IntegerQ(q))))),
IIntegrate(4974,Int(Times(Plus(a_DEFAULT,Times(ArcTan(Times(c_DEFAULT,x_)),b_DEFAULT)),x_,Power(Plus(d_DEFAULT,Times(e_DEFAULT,Sqr(x_))),q_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(d,Times(e,Sqr(x))),Plus(q,C1)),Plus(a,Times(b,ArcTan(Times(c,x)))),Power(Times(C2,e,Plus(q,C1)),-1)),x),Negate(Dist(Times(b,c,Power(Times(C2,e,Plus(q,C1)),-1)),Int(Times(Power(Plus(d,Times(e,Sqr(x))),Plus(q,C1)),Power(Plus(C1,Times(Sqr(c),Sqr(x))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,q),x),NeQ(q,CN1)))),
IIntegrate(4975,Int(Times(Plus(a_DEFAULT,Times(ArcCot(Times(c_DEFAULT,x_)),b_DEFAULT)),x_,Power(Plus(d_DEFAULT,Times(e_DEFAULT,Sqr(x_))),q_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(d,Times(e,Sqr(x))),Plus(q,C1)),Plus(a,Times(b,ArcCot(Times(c,x)))),Power(Times(C2,e,Plus(q,C1)),-1)),x),Dist(Times(b,c,Power(Times(C2,e,Plus(q,C1)),-1)),Int(Times(Power(Plus(d,Times(e,Sqr(x))),Plus(q,C1)),Power(Plus(C1,Times(Sqr(c),Sqr(x))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,q),x),NeQ(q,CN1)))),
IIntegrate(4976,Int(Times(Plus(a_DEFAULT,Times(ArcTan(Times(c_DEFAULT,x_)),b_DEFAULT)),Power(Times(f_DEFAULT,x_),m_DEFAULT),Power(Plus(d_DEFAULT,Times(e_DEFAULT,Sqr(x_))),q_DEFAULT)),x_Symbol),
    Condition(With(List(Set(u,IntHide(Times(Power(Times(f,x),m),Power(Plus(d,Times(e,Sqr(x))),q)),x))),Plus(Dist(Plus(a,Times(b,ArcTan(Times(c,x)))),u,x),Negate(Dist(Times(b,c),Int(SimplifyIntegrand(Times(u,Power(Plus(C1,Times(Sqr(c),Sqr(x))),-1)),x),x),x)))),And(FreeQ(List(a,b,c,d,e,f,m,q),x),Or(And(IGtQ(q,C0),Not(And(ILtQ(Times(C1D2,Plus(m,Negate(C1))),C0),GtQ(Plus(m,Times(C2,q),C3),C0)))),And(IGtQ(Times(C1D2,Plus(m,C1)),C0),Not(And(ILtQ(q,C0),GtQ(Plus(m,Times(C2,q),C3),C0)))),And(ILtQ(Times(C1D2,Plus(m,Times(C2,q),C1)),C0),Not(ILtQ(Times(C1D2,Plus(m,Negate(C1))),C0))))))),
IIntegrate(4977,Int(Times(Plus(a_DEFAULT,Times(ArcCot(Times(c_DEFAULT,x_)),b_DEFAULT)),Power(Times(f_DEFAULT,x_),m_DEFAULT),Power(Plus(d_DEFAULT,Times(e_DEFAULT,Sqr(x_))),q_DEFAULT)),x_Symbol),
    Condition(With(List(Set(u,IntHide(Times(Power(Times(f,x),m),Power(Plus(d,Times(e,Sqr(x))),q)),x))),Plus(Dist(Plus(a,Times(b,ArcCot(Times(c,x)))),u,x),Dist(Times(b,c),Int(SimplifyIntegrand(Times(u,Power(Plus(C1,Times(Sqr(c),Sqr(x))),-1)),x),x),x))),And(FreeQ(List(a,b,c,d,e,f,m,q),x),Or(And(IGtQ(q,C0),Not(And(ILtQ(Times(C1D2,Plus(m,Negate(C1))),C0),GtQ(Plus(m,Times(C2,q),C3),C0)))),And(IGtQ(Times(C1D2,Plus(m,C1)),C0),Not(And(ILtQ(q,C0),GtQ(Plus(m,Times(C2,q),C3),C0)))),And(ILtQ(Times(C1D2,Plus(m,Times(C2,q),C1)),C0),Not(ILtQ(Times(C1D2,Plus(m,Negate(C1))),C0))))))),
IIntegrate(4978,Int(Times(Power(Plus(a_DEFAULT,Times(ArcTan(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),x_,Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-2)),x_Symbol),
    Condition(Plus(Dist(Power(Times(C4,Sqr(d),Rt(Times(CN1,e,Power(d,-1)),C2)),-1),Int(Times(Power(Plus(a,Times(b,ArcTan(Times(c,x)))),p),Power(Plus(C1,Times(CN1,Rt(Times(CN1,e,Power(d,-1)),C2),x)),-2)),x),x),Negate(Dist(Power(Times(C4,Sqr(d),Rt(Times(CN1,e,Power(d,-1)),C2)),-1),Int(Times(Power(Plus(a,Times(b,ArcTan(Times(c,x)))),p),Power(Plus(C1,Times(Rt(Times(CN1,e,Power(d,-1)),C2),x)),-2)),x),x))),And(FreeQ(List(a,b,c,d,e),x),IGtQ(p,C0)))),
IIntegrate(4979,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCot(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),x_,Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-2)),x_Symbol),
    Condition(Plus(Dist(Power(Times(C4,Sqr(d),Rt(Times(CN1,e,Power(d,-1)),C2)),-1),Int(Times(Power(Plus(a,Times(b,ArcCot(Times(c,x)))),p),Power(Plus(C1,Times(CN1,Rt(Times(CN1,e,Power(d,-1)),C2),x)),-2)),x),x),Negate(Dist(Power(Times(C4,Sqr(d),Rt(Times(CN1,e,Power(d,-1)),C2)),-1),Int(Times(Power(Plus(a,Times(b,ArcCot(Times(c,x)))),p),Power(Plus(C1,Times(Rt(Times(CN1,e,Power(d,-1)),C2),x)),-2)),x),x))),And(FreeQ(List(a,b,c,d,e),x),IGtQ(p,C0)))),
IIntegrate(4980,Int(Times(Power(Plus(a_DEFAULT,Times(ArcTan(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Times(f_DEFAULT,x_),m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_DEFAULT)),x_Symbol),
    Condition(With(List(Set(u,ExpandIntegrand(Power(Plus(a,Times(b,ArcTan(Times(c,x)))),p),Times(Power(Times(f,x),m),Power(Plus(d,Times(e,Sqr(x))),q)),x))),Condition(Int(u,x),SumQ(u))),And(FreeQ(List(a,b,c,d,e,f,m),x),IntegerQ(q),IGtQ(p,C0),Or(And(EqQ(p,C1),GtQ(q,C0)),IntegerQ(m))))),
IIntegrate(4981,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCot(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Times(f_DEFAULT,x_),m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_DEFAULT)),x_Symbol),
    Condition(With(List(Set(u,ExpandIntegrand(Power(Plus(a,Times(b,ArcCot(Times(c,x)))),p),Times(Power(Times(f,x),m),Power(Plus(d,Times(e,Sqr(x))),q)),x))),Condition(Int(u,x),SumQ(u))),And(FreeQ(List(a,b,c,d,e,f,m),x),IntegerQ(q),IGtQ(p,C0),Or(And(EqQ(p,C1),GtQ(q,C0)),IntegerQ(m))))),
IIntegrate(4982,Int(Times(Plus(Times(ArcTan(Times(c_DEFAULT,x_)),b_DEFAULT),a_),Power(Times(f_DEFAULT,x_),m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_DEFAULT)),x_Symbol),
    Condition(Plus(Dist(a,Int(Times(Power(Times(f,x),m),Power(Plus(d,Times(e,Sqr(x))),q)),x),x),Dist(b,Int(Times(Power(Times(f,x),m),Power(Plus(d,Times(e,Sqr(x))),q),ArcTan(Times(c,x))),x),x)),FreeQ(List(a,b,c,d,e,f,m,q),x))),
IIntegrate(4983,Int(Times(Plus(Times(ArcCot(Times(c_DEFAULT,x_)),b_DEFAULT),a_),Power(Times(f_DEFAULT,x_),m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_DEFAULT)),x_Symbol),
    Condition(Plus(Dist(a,Int(Times(Power(Times(f,x),m),Power(Plus(d,Times(e,Sqr(x))),q)),x),x),Dist(b,Int(Times(Power(Times(f,x),m),Power(Plus(d,Times(e,Sqr(x))),q),ArcCot(Times(c,x))),x),x)),FreeQ(List(a,b,c,d,e,f,m,q),x))),
IIntegrate(4984,Int(Times(Power(Plus(a_DEFAULT,Times(ArcTan(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Plus(f_,Times(g_DEFAULT,x_)),m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times(Power(Plus(a,Times(b,ArcTan(Times(c,x)))),p),Power(Plus(d,Times(e,Sqr(x))),-1)),Power(Plus(f,Times(g,x)),m),x),x),And(FreeQ(List(a,b,c,d,e,f,g),x),IGtQ(p,C0),EqQ(e,Times(Sqr(c),d)),IGtQ(m,C0)))),
IIntegrate(4985,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCot(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Plus(f_,Times(g_DEFAULT,x_)),m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times(Power(Plus(a,Times(b,ArcCot(Times(c,x)))),p),Power(Plus(d,Times(e,Sqr(x))),-1)),Power(Plus(f,Times(g,x)),m),x),x),And(FreeQ(List(a,b,c,d,e,f,g),x),IGtQ(p,C0),EqQ(e,Times(Sqr(c),d)),IGtQ(m,C0)))),
IIntegrate(4986,Int(Times(ArcTanh(u_),Power(Plus(a_DEFAULT,Times(ArcTan(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Dist(C1D2,Int(Times(Log(Plus(C1,u)),Power(Plus(a,Times(b,ArcTan(Times(c,x)))),p),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x),Negate(Dist(C1D2,Int(Times(Log(Plus(C1,Negate(u))),Power(Plus(a,Times(b,ArcTan(Times(c,x)))),p),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e),x),IGtQ(p,C0),EqQ(e,Times(Sqr(c),d)),EqQ(Plus(Sqr(u),Negate(Sqr(Plus(C1,Times(CN1,C2,CI,Power(Plus(CI,Times(c,x)),-1)))))),C0)))),
IIntegrate(4987,Int(Times(ArcCoth(u_),Power(Plus(a_DEFAULT,Times(ArcCot(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Dist(C1D2,Int(Times(Log(SimplifyIntegrand(Plus(C1,Power(u,-1)),x)),Power(Plus(a,Times(b,ArcCot(Times(c,x)))),p),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x),Negate(Dist(C1D2,Int(Times(Log(SimplifyIntegrand(Plus(C1,Negate(Power(u,-1))),x)),Power(Plus(a,Times(b,ArcCot(Times(c,x)))),p),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e),x),IGtQ(p,C0),EqQ(e,Times(Sqr(c),d)),EqQ(Plus(Sqr(u),Negate(Sqr(Plus(C1,Times(CN1,C2,CI,Power(Plus(CI,Times(c,x)),-1)))))),C0)))),
IIntegrate(4988,Int(Times(ArcTanh(u_),Power(Plus(a_DEFAULT,Times(ArcTan(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Dist(C1D2,Int(Times(Log(Plus(C1,u)),Power(Plus(a,Times(b,ArcTan(Times(c,x)))),p),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x),Negate(Dist(C1D2,Int(Times(Log(Plus(C1,Negate(u))),Power(Plus(a,Times(b,ArcTan(Times(c,x)))),p),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e),x),IGtQ(p,C0),EqQ(e,Times(Sqr(c),d)),EqQ(Plus(Sqr(u),Negate(Sqr(Plus(C1,Times(CN1,C2,CI,Power(Plus(CI,Times(CN1,c,x)),-1)))))),C0)))),
IIntegrate(4989,Int(Times(ArcCoth(u_),Power(Plus(a_DEFAULT,Times(ArcCot(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Dist(C1D2,Int(Times(Log(SimplifyIntegrand(Plus(C1,Power(u,-1)),x)),Power(Plus(a,Times(b,ArcCot(Times(c,x)))),p),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x),Negate(Dist(C1D2,Int(Times(Log(SimplifyIntegrand(Plus(C1,Negate(Power(u,-1))),x)),Power(Plus(a,Times(b,ArcCot(Times(c,x)))),p),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e),x),IGtQ(p,C0),EqQ(e,Times(Sqr(c),d)),EqQ(Plus(Sqr(u),Negate(Sqr(Plus(C1,Times(CN1,C2,CI,Power(Plus(CI,Times(CN1,c,x)),-1)))))),C0)))),
IIntegrate(4990,Int(Times(Log(Plus(f_,Times(g_DEFAULT,x_))),Power(Plus(a_DEFAULT,Times(ArcTan(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(a,Times(b,ArcTan(Times(c,x)))),Plus(p,C1)),Log(Plus(f,Times(g,x))),Power(Times(b,c,d,Plus(p,C1)),-1)),x),Negate(Dist(Times(g,Power(Times(b,c,d,Plus(p,C1)),-1)),Int(Times(Power(Plus(a,Times(b,ArcTan(Times(c,x)))),Plus(p,C1)),Power(Plus(f,Times(g,x)),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f,g),x),IGtQ(p,C0),EqQ(e,Times(Sqr(c),d)),EqQ(Plus(Times(Sqr(c),Sqr(f)),Sqr(g)),C0)))),
IIntegrate(4991,Int(Times(Log(Plus(f_,Times(g_DEFAULT,x_))),Power(Plus(a_DEFAULT,Times(ArcCot(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(a,Times(b,ArcCot(Times(c,x)))),Plus(p,C1)),Log(Plus(f,Times(g,x))),Power(Times(b,c,d,Plus(p,C1)),-1)),x),Negate(Dist(Times(g,Power(Times(b,c,d,Plus(p,C1)),-1)),Int(Times(Power(Plus(a,Times(b,ArcCot(Times(c,x)))),Plus(p,C1)),Power(Plus(f,Times(g,x)),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f,g),x),IGtQ(p,C0),EqQ(e,Times(Sqr(c),d)),EqQ(Plus(Times(Sqr(c),Sqr(f)),Sqr(g)),C0)))),
IIntegrate(4992,Int(Times(Log(u_),Power(Plus(a_DEFAULT,Times(ArcTan(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Simp(Times(CI,Power(Plus(a,Times(b,ArcTan(Times(c,x)))),p),PolyLog(C2,Plus(C1,Negate(u))),Power(Times(C2,c,d),-1)),x),Negate(Dist(Times(C1D2,b,p,CI),Int(Times(Power(Plus(a,Times(b,ArcTan(Times(c,x)))),Plus(p,Negate(C1))),PolyLog(C2,Plus(C1,Negate(u))),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e),x),IGtQ(p,C0),EqQ(e,Times(Sqr(c),d)),EqQ(Plus(Sqr(Plus(C1,Negate(u))),Negate(Sqr(Plus(C1,Times(CN1,C2,CI,Power(Plus(CI,Times(c,x)),-1)))))),C0)))),
IIntegrate(4993,Int(Times(Log(u_),Power(Plus(a_DEFAULT,Times(ArcCot(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Simp(Times(CI,Power(Plus(a,Times(b,ArcCot(Times(c,x)))),p),PolyLog(C2,Plus(C1,Negate(u))),Power(Times(C2,c,d),-1)),x),Dist(Times(C1D2,b,p,CI),Int(Times(Power(Plus(a,Times(b,ArcCot(Times(c,x)))),Plus(p,Negate(C1))),PolyLog(C2,Plus(C1,Negate(u))),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e),x),IGtQ(p,C0),EqQ(e,Times(Sqr(c),d)),EqQ(Plus(Sqr(Plus(C1,Negate(u))),Negate(Sqr(Plus(C1,Times(CN1,C2,CI,Power(Plus(CI,Times(c,x)),-1)))))),C0)))),
IIntegrate(4994,Int(Times(Log(u_),Power(Plus(a_DEFAULT,Times(ArcTan(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(CI,Power(Plus(a,Times(b,ArcTan(Times(c,x)))),p),PolyLog(C2,Plus(C1,Negate(u))),Power(Times(C2,c,d),-1)),x)),Dist(Times(C1D2,b,p,CI),Int(Times(Power(Plus(a,Times(b,ArcTan(Times(c,x)))),Plus(p,Negate(C1))),PolyLog(C2,Plus(C1,Negate(u))),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e),x),IGtQ(p,C0),EqQ(e,Times(Sqr(c),d)),EqQ(Plus(Sqr(Plus(C1,Negate(u))),Negate(Sqr(Plus(C1,Times(CN1,C2,CI,Power(Plus(CI,Times(CN1,c,x)),-1)))))),C0)))),
IIntegrate(4995,Int(Times(Log(u_),Power(Plus(a_DEFAULT,Times(ArcCot(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(CI,Power(Plus(a,Times(b,ArcCot(Times(c,x)))),p),PolyLog(C2,Plus(C1,Negate(u))),Power(Times(C2,c,d),-1)),x)),Negate(Dist(Times(C1D2,b,p,CI),Int(Times(Power(Plus(a,Times(b,ArcCot(Times(c,x)))),Plus(p,Negate(C1))),PolyLog(C2,Plus(C1,Negate(u))),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e),x),IGtQ(p,C0),EqQ(e,Times(Sqr(c),d)),EqQ(Plus(Sqr(Plus(C1,Negate(u))),Negate(Sqr(Plus(C1,Times(CN1,C2,CI,Power(Plus(CI,Times(CN1,c,x)),-1)))))),C0)))),
IIntegrate(4996,Int(Times(Power(Plus(a_DEFAULT,Times(ArcTan(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),PolyLog(k_,u_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(CI,Power(Plus(a,Times(b,ArcTan(Times(c,x)))),p),PolyLog(Plus(k,C1),u),Power(Times(C2,c,d),-1)),x)),Dist(Times(C1D2,b,p,CI),Int(Times(Power(Plus(a,Times(b,ArcTan(Times(c,x)))),Plus(p,Negate(C1))),PolyLog(Plus(k,C1),u),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,k),x),IGtQ(p,C0),EqQ(e,Times(Sqr(c),d)),EqQ(Plus(Sqr(u),Negate(Sqr(Plus(C1,Times(CN1,C2,CI,Power(Plus(CI,Times(c,x)),-1)))))),C0)))),
IIntegrate(4997,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCot(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),PolyLog(k_,u_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(CI,Power(Plus(a,Times(b,ArcCot(Times(c,x)))),p),PolyLog(Plus(k,C1),u),Power(Times(C2,c,d),-1)),x)),Negate(Dist(Times(C1D2,b,p,CI),Int(Times(Power(Plus(a,Times(b,ArcCot(Times(c,x)))),Plus(p,Negate(C1))),PolyLog(Plus(k,C1),u),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,k),x),IGtQ(p,C0),EqQ(e,Times(Sqr(c),d)),EqQ(Plus(Sqr(u),Negate(Sqr(Plus(C1,Times(CN1,C2,CI,Power(Plus(CI,Times(c,x)),-1)))))),C0)))),
IIntegrate(4998,Int(Times(Power(Plus(a_DEFAULT,Times(ArcTan(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),PolyLog(k_,u_)),x_Symbol),
    Condition(Plus(Simp(Times(CI,Power(Plus(a,Times(b,ArcTan(Times(c,x)))),p),PolyLog(Plus(k,C1),u),Power(Times(C2,c,d),-1)),x),Negate(Dist(Times(C1D2,b,p,CI),Int(Times(Power(Plus(a,Times(b,ArcTan(Times(c,x)))),Plus(p,Negate(C1))),PolyLog(Plus(k,C1),u),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,k),x),IGtQ(p,C0),EqQ(e,Times(Sqr(c),d)),EqQ(Plus(Sqr(u),Negate(Sqr(Plus(C1,Times(CN1,C2,CI,Power(Plus(CI,Times(CN1,c,x)),-1)))))),C0)))),
IIntegrate(4999,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCot(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),PolyLog(k_,u_)),x_Symbol),
    Condition(Plus(Simp(Times(CI,Power(Plus(a,Times(b,ArcCot(Times(c,x)))),p),PolyLog(Plus(k,C1),u),Power(Times(C2,c,d),-1)),x),Dist(Times(C1D2,b,p,CI),Int(Times(Power(Plus(a,Times(b,ArcCot(Times(c,x)))),Plus(p,Negate(C1))),PolyLog(Plus(k,C1),u),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,k),x),IGtQ(p,C0),EqQ(e,Times(Sqr(c),d)),EqQ(Plus(Sqr(u),Negate(Sqr(Plus(C1,Times(CN1,C2,CI,Power(Plus(CI,Times(CN1,c,x)),-1)))))),C0)))),
IIntegrate(5000,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCot(Times(c_DEFAULT,x_)),b_DEFAULT)),-1),Power(Plus(a_DEFAULT,Times(ArcTan(Times(c_DEFAULT,x_)),b_DEFAULT)),-1),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Simp(Times(Plus(Negate(Log(Plus(a,Times(b,ArcCot(Times(c,x)))))),Log(Plus(a,Times(b,ArcTan(Times(c,x)))))),Power(Times(b,c,d,Plus(Times(C2,a),Times(b,ArcCot(Times(c,x))),Times(b,ArcTan(Times(c,x))))),-1)),x),And(FreeQ(List(a,b,c,d,e),x),EqQ(e,Times(Sqr(c),d)))))
  );
}