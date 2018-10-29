package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cosh;
import static org.matheclipse.core.expression.F.Coth;
import static org.matheclipse.core.expression.F.Csch;
import static org.matheclipse.core.expression.F.Exp;
import static org.matheclipse.core.expression.F.FSymbol;
import static org.matheclipse.core.expression.F.F_;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.GSymbol;
import static org.matheclipse.core.expression.F.G_;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.Module;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sech;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sinh;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_DEFAULT;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.g_DEFAULT;
import static org.matheclipse.core.expression.F.h;
import static org.matheclipse.core.expression.F.h_;
import static org.matheclipse.core.expression.F.h_DEFAULT;
import static org.matheclipse.core.expression.F.i;
import static org.matheclipse.core.expression.F.i_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.r;
import static org.matheclipse.core.expression.F.r_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandTrigReduce;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandTrigToExp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.G;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.H;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.HyperbolicQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntHide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearMatchQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PolyQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumSimplerQ;

/** 
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class IntRules110 { 
  public static IAST RULES = List( 
IIntegrate(5501,Int(Times(Power(Plus(Times(Cosh(Plus(d_DEFAULT,Times(e_DEFAULT,x_))),g_DEFAULT),f_),n_DEFAULT),Power(F_,Times(c_DEFAULT,Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),Power(Sinh(Plus(d_DEFAULT,Times(e_DEFAULT,x_))),m_DEFAULT)),x_Symbol),
    Condition(Dist(Power(g,n),Int(Times(Power(FSymbol,Times(c,Plus(a,Times(b,x)))),Power(Coth(Plus(Times(C1D2,d),Times(C1D2,e,x))),m)),x),x),And(FreeQ(List(FSymbol,a,b,c,d,e,f,g),x),EqQ(Plus(f,g),C0),IntegersQ(m,n),EqQ(Plus(m,n),C0)))),
IIntegrate(5502,Int(Times(Power(F_,Times(c_DEFAULT,Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),Plus(Times(Cosh(Plus(d_DEFAULT,Times(e_DEFAULT,x_))),i_DEFAULT),h_),Power(Plus(f_,Times(g_DEFAULT,Sinh(Plus(d_DEFAULT,Times(e_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Plus(Dist(Times(C2,i),Int(Times(Power(FSymbol,Times(c,Plus(a,Times(b,x)))),Cosh(Plus(d,Times(e,x))),Power(Plus(f,Times(g,Sinh(Plus(d,Times(e,x))))),-1)),x),x),Int(Times(Power(FSymbol,Times(c,Plus(a,Times(b,x)))),Plus(h,Times(CN1,i,Cosh(Plus(d,Times(e,x))))),Power(Plus(f,Times(g,Sinh(Plus(d,Times(e,x))))),-1)),x)),And(FreeQ(List(FSymbol,a,b,c,d,e,f,g,h,i),x),EqQ(Plus(Sqr(f),Sqr(g)),C0),EqQ(Plus(Sqr(h),Negate(Sqr(i))),C0),EqQ(Plus(Times(g,h),Times(CN1,f,i)),C0)))),
IIntegrate(5503,Int(Times(Power(Plus(Times(Cosh(Plus(d_DEFAULT,Times(e_DEFAULT,x_))),g_DEFAULT),f_),-1),Power(F_,Times(c_DEFAULT,Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),Plus(h_,Times(i_DEFAULT,Sinh(Plus(d_DEFAULT,Times(e_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Dist(Times(C2,i),Int(Times(Power(FSymbol,Times(c,Plus(a,Times(b,x)))),Sinh(Plus(d,Times(e,x))),Power(Plus(f,Times(g,Cosh(Plus(d,Times(e,x))))),-1)),x),x),Int(Times(Power(FSymbol,Times(c,Plus(a,Times(b,x)))),Plus(h,Times(CN1,i,Sinh(Plus(d,Times(e,x))))),Power(Plus(f,Times(g,Cosh(Plus(d,Times(e,x))))),-1)),x)),And(FreeQ(List(FSymbol,a,b,c,d,e,f,g,h,i),x),EqQ(Plus(Sqr(f),Negate(Sqr(g))),C0),EqQ(Plus(Sqr(h),Sqr(i)),C0),EqQ(Plus(Times(g,h),Times(f,i)),C0)))),
IIntegrate(5504,Int(Times(Power(F_,Times(c_DEFAULT,u_)),Power($(G_,v_),n_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(FSymbol,Times(c,ExpandToSum(u,x))),Power(G(ExpandToSum(v,x)),n)),x),And(FreeQ(List(FSymbol,c,n),x),HyperbolicQ(GSymbol),LinearQ(List(u,v),x),Not(LinearMatchQ(List(u,v),x))))),
IIntegrate(5505,Int(Times(Power(F_,Times(c_DEFAULT,Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),Power(Times(f_DEFAULT,x_),m_DEFAULT),Power(Sinh(Plus(d_DEFAULT,Times(e_DEFAULT,x_))),n_DEFAULT)),x_Symbol),
    Condition(Module(List(Set(u,IntHide(Times(Power(FSymbol,Times(c,Plus(a,Times(b,x)))),Power(Sinh(Plus(d,Times(e,x))),n)),x))),Plus(Dist(Power(Times(f,x),m),u,x),Negate(Dist(Times(f,m),Int(Times(Power(Times(f,x),Plus(m,Negate(C1))),u),x),x)))),And(FreeQ(List(FSymbol,a,b,c,d,e,f),x),IGtQ(n,C0),GtQ(m,C0)))),
IIntegrate(5506,Int(Times(Power(Cosh(Plus(d_DEFAULT,Times(e_DEFAULT,x_))),n_DEFAULT),Power(F_,Times(c_DEFAULT,Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),Power(Times(f_DEFAULT,x_),m_DEFAULT)),x_Symbol),
    Condition(Module(List(Set(u,IntHide(Times(Power(FSymbol,Times(c,Plus(a,Times(b,x)))),Power(Cosh(Plus(d,Times(e,x))),n)),x))),Plus(Dist(Power(Times(f,x),m),u,x),Negate(Dist(Times(f,m),Int(Times(Power(Times(f,x),Plus(m,Negate(C1))),u),x),x)))),And(FreeQ(List(FSymbol,a,b,c,d,e,f),x),IGtQ(n,C0),GtQ(m,C0)))),
IIntegrate(5507,Int(Times(Power(F_,Times(c_DEFAULT,Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),Power(Times(f_DEFAULT,x_),m_),Sinh(Plus(d_DEFAULT,Times(e_DEFAULT,x_)))),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(f,x),Plus(m,C1)),Power(FSymbol,Times(c,Plus(a,Times(b,x)))),Sinh(Plus(d,Times(e,x))),Power(Times(f,Plus(m,C1)),-1)),x),Negate(Dist(Times(e,Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(FSymbol,Times(c,Plus(a,Times(b,x)))),Cosh(Plus(d,Times(e,x)))),x),x)),Negate(Dist(Times(b,c,Log(FSymbol),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(FSymbol,Times(c,Plus(a,Times(b,x)))),Sinh(Plus(d,Times(e,x)))),x),x))),And(FreeQ(List(FSymbol,a,b,c,d,e,f,m),x),Or(LtQ(m,CN1),SumSimplerQ(m,C1))))),
IIntegrate(5508,Int(Times(Cosh(Plus(d_DEFAULT,Times(e_DEFAULT,x_))),Power(F_,Times(c_DEFAULT,Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),Power(Times(f_DEFAULT,x_),m_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(f,x),Plus(m,C1)),Power(FSymbol,Times(c,Plus(a,Times(b,x)))),Cosh(Plus(d,Times(e,x))),Power(Times(f,Plus(m,C1)),-1)),x),Negate(Dist(Times(e,Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(FSymbol,Times(c,Plus(a,Times(b,x)))),Sinh(Plus(d,Times(e,x)))),x),x)),Negate(Dist(Times(b,c,Log(FSymbol),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(FSymbol,Times(c,Plus(a,Times(b,x)))),Cosh(Plus(d,Times(e,x)))),x),x))),And(FreeQ(List(FSymbol,a,b,c,d,e,f,m),x),Or(LtQ(m,CN1),SumSimplerQ(m,C1))))),
IIntegrate(5509,Int(Times(Power(Cosh(Plus(f_DEFAULT,Times(g_DEFAULT,x_))),n_DEFAULT),Power(F_,Times(c_DEFAULT,Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),Power(Sinh(Plus(d_DEFAULT,Times(e_DEFAULT,x_))),m_DEFAULT)),x_Symbol),
    Condition(Int(ExpandTrigReduce(Power(FSymbol,Times(c,Plus(a,Times(b,x)))),Times(Power(Sinh(Plus(d,Times(e,x))),m),Power(Cosh(Plus(f,Times(g,x))),n)),x),x),And(FreeQ(List(FSymbol,a,b,c,d,e,f,g),x),IGtQ(m,C0),IGtQ(n,C0)))),
IIntegrate(5510,Int(Times(Power(Cosh(Plus(f_DEFAULT,Times(g_DEFAULT,x_))),n_DEFAULT),Power(F_,Times(c_DEFAULT,Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),Power(x_,p_DEFAULT),Power(Sinh(Plus(d_DEFAULT,Times(e_DEFAULT,x_))),m_DEFAULT)),x_Symbol),
    Condition(Int(ExpandTrigReduce(Times(Power(x,p),Power(FSymbol,Times(c,Plus(a,Times(b,x))))),Times(Power(Sinh(Plus(d,Times(e,x))),m),Power(Cosh(Plus(f,Times(g,x))),n)),x),x),And(FreeQ(List(FSymbol,a,b,c,d,e,f,g),x),IGtQ(m,C0),IGtQ(n,C0),IGtQ(p,C0)))),
IIntegrate(5511,Int(Times(Power(F_,Times(c_DEFAULT,Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),Power($(G_,Plus(d_DEFAULT,Times(e_DEFAULT,x_))),m_DEFAULT),Power($($p("H"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),n_DEFAULT)),x_Symbol),
    Condition(Int(ExpandTrigToExp(Power(FSymbol,Times(c,Plus(a,Times(b,x)))),Times(Power(G(Plus(d,Times(e,x))),m),Power(H(Plus(d,Times(e,x))),n)),x),x),And(FreeQ(List(FSymbol,a,b,c,d,e),x),IGtQ(m,C0),IGtQ(n,C0),HyperbolicQ(GSymbol),HyperbolicQ($s("H"))))),
IIntegrate(5512,Int(Times(Power(F_,u_),Power(Sinh(v_),n_DEFAULT)),x_Symbol),
    Condition(Int(ExpandTrigToExp(Power(FSymbol,u),Power(Sinh(v),n),x),x),And(FreeQ(FSymbol,x),Or(LinearQ(u,x),PolyQ(u,x,C2)),Or(LinearQ(v,x),PolyQ(v,x,C2)),IGtQ(n,C0)))),
IIntegrate(5513,Int(Times(Power(Cosh(v_),n_DEFAULT),Power(F_,u_)),x_Symbol),
    Condition(Int(ExpandTrigToExp(Power(FSymbol,u),Power(Cosh(v),n),x),x),And(FreeQ(FSymbol,x),Or(LinearQ(u,x),PolyQ(u,x,C2)),Or(LinearQ(v,x),PolyQ(v,x,C2)),IGtQ(n,C0)))),
IIntegrate(5514,Int(Times(Power(Cosh(v_),n_DEFAULT),Power(F_,u_),Power(Sinh(v_),m_DEFAULT)),x_Symbol),
    Condition(Int(ExpandTrigToExp(Power(FSymbol,u),Times(Power(Sinh(v),m),Power(Cosh(v),n)),x),x),And(FreeQ(FSymbol,x),Or(LinearQ(u,x),PolyQ(u,x,C2)),Or(LinearQ(v,x),PolyQ(v,x,C2)),IGtQ(m,C0),IGtQ(n,C0)))),
IIntegrate(5515,Int(Power(Sinh(Times(Log(Times(c_DEFAULT,Power(x_,n_DEFAULT))),b_DEFAULT)),p_DEFAULT),x_Symbol),
    Condition(Int(Power(Plus(Times(C1D2,Power(Times(c,Power(x,n)),b)),Negate(Power(Times(C2,Power(Times(c,Power(x,n)),b)),-1))),p),x),And(FreeQ(c,x),RationalQ(b,n,p)))),
IIntegrate(5516,Int(Power(Cosh(Times(Log(Times(c_DEFAULT,Power(x_,n_DEFAULT))),b_DEFAULT)),p_DEFAULT),x_Symbol),
    Condition(Int(Power(Plus(Times(C1D2,Power(Times(c,Power(x,n)),b)),Power(Times(C2,Power(Times(c,Power(x,n)),b)),-1)),p),x),And(FreeQ(c,x),RationalQ(b,n,p)))),
IIntegrate(5517,Int(Sinh(Times(Plus(a_DEFAULT,Times(Log(Times(c_DEFAULT,Power(x_,n_DEFAULT))),b_DEFAULT)),d_DEFAULT)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(x,Sinh(Times(d,Plus(a,Times(b,Log(Times(c,Power(x,n))))))),Power(Plus(Times(Sqr(b),Sqr(d),Sqr(n)),Negate(C1)),-1)),x)),Simp(Times(b,d,n,x,Cosh(Times(d,Plus(a,Times(b,Log(Times(c,Power(x,n))))))),Power(Plus(Times(Sqr(b),Sqr(d),Sqr(n)),Negate(C1)),-1)),x)),And(FreeQ(List(a,b,c,d,n),x),NeQ(Plus(Times(Sqr(b),Sqr(d),Sqr(n)),Negate(C1)),C0)))),
IIntegrate(5518,Int(Cosh(Times(Plus(a_DEFAULT,Times(Log(Times(c_DEFAULT,Power(x_,n_DEFAULT))),b_DEFAULT)),d_DEFAULT)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(x,Cosh(Times(d,Plus(a,Times(b,Log(Times(c,Power(x,n))))))),Power(Plus(Times(Sqr(b),Sqr(d),Sqr(n)),Negate(C1)),-1)),x)),Simp(Times(b,d,n,x,Sinh(Times(d,Plus(a,Times(b,Log(Times(c,Power(x,n))))))),Power(Plus(Times(Sqr(b),Sqr(d),Sqr(n)),Negate(C1)),-1)),x)),And(FreeQ(List(a,b,c,d,n),x),NeQ(Plus(Times(Sqr(b),Sqr(d),Sqr(n)),Negate(C1)),C0)))),
IIntegrate(5519,Int(Power(Sinh(Times(Plus(a_DEFAULT,Times(Log(Times(c_DEFAULT,Power(x_,n_DEFAULT))),b_DEFAULT)),d_DEFAULT)),p_),x_Symbol),
    Condition(Plus(Negate(Simp(Times(x,Power(Sinh(Times(d,Plus(a,Times(b,Log(Times(c,Power(x,n))))))),p),Power(Plus(Times(Sqr(b),Sqr(d),Sqr(n),Sqr(p)),Negate(C1)),-1)),x)),Negate(Dist(Times(Sqr(b),Sqr(d),Sqr(n),p,Plus(p,Negate(C1)),Power(Plus(Times(Sqr(b),Sqr(d),Sqr(n),Sqr(p)),Negate(C1)),-1)),Int(Power(Sinh(Times(d,Plus(a,Times(b,Log(Times(c,Power(x,n))))))),Plus(p,Negate(C2))),x),x)),Simp(Times(b,d,n,p,x,Cosh(Times(d,Plus(a,Times(b,Log(Times(c,Power(x,n))))))),Power(Sinh(Times(d,Plus(a,Times(b,Log(Times(c,Power(x,n))))))),Plus(p,Negate(C1))),Power(Plus(Times(Sqr(b),Sqr(d),Sqr(n),Sqr(p)),Negate(C1)),-1)),x)),And(FreeQ(List(a,b,c,d,n),x),IGtQ(p,C1),NeQ(Plus(Times(Sqr(b),Sqr(d),Sqr(n),Sqr(p)),Negate(C1)),C0)))),
IIntegrate(5520,Int(Power(Cosh(Times(Plus(a_DEFAULT,Times(Log(Times(c_DEFAULT,Power(x_,n_DEFAULT))),b_DEFAULT)),d_DEFAULT)),p_),x_Symbol),
    Condition(Plus(Negate(Simp(Times(x,Power(Cosh(Times(d,Plus(a,Times(b,Log(Times(c,Power(x,n))))))),p),Power(Plus(Times(Sqr(b),Sqr(d),Sqr(n),Sqr(p)),Negate(C1)),-1)),x)),Dist(Times(Sqr(b),Sqr(d),Sqr(n),p,Plus(p,Negate(C1)),Power(Plus(Times(Sqr(b),Sqr(d),Sqr(n),Sqr(p)),Negate(C1)),-1)),Int(Power(Cosh(Times(d,Plus(a,Times(b,Log(Times(c,Power(x,n))))))),Plus(p,Negate(C2))),x),x),Simp(Times(b,d,n,p,x,Power(Cosh(Times(d,Plus(a,Times(b,Log(Times(c,Power(x,n))))))),Plus(p,Negate(C1))),Sinh(Times(d,Plus(a,Times(b,Log(Times(c,Power(x,n))))))),Power(Plus(Times(Sqr(b),Sqr(d),Sqr(n),Sqr(p)),Negate(C1)),-1)),x)),And(FreeQ(List(a,b,c,d,n),x),IGtQ(p,C1),NeQ(Plus(Times(Sqr(b),Sqr(d),Sqr(n),Sqr(p)),Negate(C1)),C0)))),
IIntegrate(5521,Int(Power(Sinh(Times(Plus(a_DEFAULT,Times(Log(x_),b_DEFAULT)),d_DEFAULT)),p_DEFAULT),x_Symbol),
    Condition(Dist(Power(Times(Power(C2,p),Power(b,p),Power(d,p),Power(p,p)),-1),Int(ExpandIntegrand(Power(Plus(Negate(Power(Times(Exp(Times(a,b,Sqr(d),p)),Power(x,Power(p,-1))),-1)),Times(Exp(Times(a,b,Sqr(d),p)),Power(x,Power(p,-1)))),p),x),x),x),And(FreeQ(List(a,b,d),x),IGtQ(p,C0),EqQ(Plus(Times(Sqr(b),Sqr(d),Sqr(p)),Negate(C1)),C0)))),
IIntegrate(5522,Int(Power(Cosh(Times(Plus(a_DEFAULT,Times(Log(x_),b_DEFAULT)),d_DEFAULT)),p_DEFAULT),x_Symbol),
    Condition(Dist(Power(Power(C2,p),-1),Int(ExpandIntegrand(Power(Plus(Power(Times(Exp(Times(a,b,Sqr(d),p)),Power(x,Power(p,-1))),-1),Times(Exp(Times(a,b,Sqr(d),p)),Power(x,Power(p,-1)))),p),x),x),x),And(FreeQ(List(a,b,d),x),IGtQ(p,C0),EqQ(Plus(Times(Sqr(b),Sqr(d),Sqr(p)),Negate(C1)),C0)))),
IIntegrate(5523,Int(Power(Sinh(Times(Plus(a_DEFAULT,Times(Log(x_),b_DEFAULT)),d_DEFAULT)),p_),x_Symbol),
    Condition(Dist(Times(Power(Sinh(Times(d,Plus(a,Times(b,Log(x))))),p),Power(Times(Power(x,Times(b,d,p)),Power(Plus(C1,Negate(Power(Times(Exp(Times(C2,a,d)),Power(x,Times(C2,b,d))),-1))),p)),-1)),Int(Times(Power(x,Times(b,d,p)),Power(Plus(C1,Negate(Power(Times(Exp(Times(C2,a,d)),Power(x,Times(C2,b,d))),-1))),p)),x),x),And(FreeQ(List(a,b,d,p),x),Not(IntegerQ(p))))),
IIntegrate(5524,Int(Power(Cosh(Times(Plus(a_DEFAULT,Times(Log(x_),b_DEFAULT)),d_DEFAULT)),p_),x_Symbol),
    Condition(Dist(Times(Power(Cosh(Times(d,Plus(a,Times(b,Log(x))))),p),Power(Times(Power(x,Times(b,d,p)),Power(Plus(C1,Power(Times(Exp(Times(C2,a,d)),Power(x,Times(C2,b,d))),-1)),p)),-1)),Int(Times(Power(x,Times(b,d,p)),Power(Plus(C1,Power(Times(Exp(Times(C2,a,d)),Power(x,Times(C2,b,d))),-1)),p)),x),x),And(FreeQ(List(a,b,d,p),x),Not(IntegerQ(p))))),
IIntegrate(5525,Int(Power(Sinh(Times(Plus(a_DEFAULT,Times(Log(Times(c_DEFAULT,Power(x_,n_DEFAULT))),b_DEFAULT)),d_DEFAULT)),p_DEFAULT),x_Symbol),
    Condition(Dist(Times(x,Power(Times(n,Power(Times(c,Power(x,n)),Power(n,-1))),-1)),Subst(Int(Times(Power(x,Plus(Power(n,-1),Negate(C1))),Power(Sinh(Times(d,Plus(a,Times(b,Log(x))))),p)),x),x,Times(c,Power(x,n))),x),And(FreeQ(List(a,b,c,d,n,p),x),Or(NeQ(c,C1),NeQ(n,C1))))),
IIntegrate(5526,Int(Power(Cosh(Times(Plus(a_DEFAULT,Times(Log(Times(c_DEFAULT,Power(x_,n_DEFAULT))),b_DEFAULT)),d_DEFAULT)),p_DEFAULT),x_Symbol),
    Condition(Dist(Times(x,Power(Times(n,Power(Times(c,Power(x,n)),Power(n,-1))),-1)),Subst(Int(Times(Power(x,Plus(Power(n,-1),Negate(C1))),Power(Cosh(Times(d,Plus(a,Times(b,Log(x))))),p)),x),x,Times(c,Power(x,n))),x),And(FreeQ(List(a,b,c,d,n,p),x),Or(NeQ(c,C1),NeQ(n,C1))))),
IIntegrate(5527,Int(Times(Power(Times(e_DEFAULT,x_),m_DEFAULT),Sinh(Times(Plus(a_DEFAULT,Times(Log(Times(c_DEFAULT,Power(x_,n_DEFAULT))),b_DEFAULT)),d_DEFAULT))),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Plus(m,C1),Power(Times(e,x),Plus(m,C1)),Sinh(Times(d,Plus(a,Times(b,Log(Times(c,Power(x,n))))))),Power(Plus(Times(Sqr(b),Sqr(d),e,Sqr(n)),Times(CN1,e,Sqr(Plus(m,C1)))),-1)),x)),Simp(Times(b,d,n,Power(Times(e,x),Plus(m,C1)),Cosh(Times(d,Plus(a,Times(b,Log(Times(c,Power(x,n))))))),Power(Plus(Times(Sqr(b),Sqr(d),e,Sqr(n)),Times(CN1,e,Sqr(Plus(m,C1)))),-1)),x)),And(FreeQ(List(a,b,c,d,e,m,n),x),NeQ(Plus(Times(Sqr(b),Sqr(d),Sqr(n)),Negate(Sqr(Plus(m,C1)))),C0)))),
IIntegrate(5528,Int(Times(Cosh(Times(Plus(a_DEFAULT,Times(Log(Times(c_DEFAULT,Power(x_,n_DEFAULT))),b_DEFAULT)),d_DEFAULT)),Power(Times(e_DEFAULT,x_),m_DEFAULT)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Plus(m,C1),Power(Times(e,x),Plus(m,C1)),Cosh(Times(d,Plus(a,Times(b,Log(Times(c,Power(x,n))))))),Power(Plus(Times(Sqr(b),Sqr(d),e,Sqr(n)),Times(CN1,e,Sqr(Plus(m,C1)))),-1)),x)),Simp(Times(b,d,n,Power(Times(e,x),Plus(m,C1)),Sinh(Times(d,Plus(a,Times(b,Log(Times(c,Power(x,n))))))),Power(Plus(Times(Sqr(b),Sqr(d),e,Sqr(n)),Times(CN1,e,Sqr(Plus(m,C1)))),-1)),x)),And(FreeQ(List(a,b,c,d,e,m,n),x),NeQ(Plus(Times(Sqr(b),Sqr(d),Sqr(n)),Negate(Sqr(Plus(m,C1)))),C0)))),
IIntegrate(5529,Int(Times(Power(Times(e_DEFAULT,x_),m_DEFAULT),Power(Sinh(Times(Plus(a_DEFAULT,Times(Log(Times(c_DEFAULT,Power(x_,n_DEFAULT))),b_DEFAULT)),d_DEFAULT)),p_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Plus(m,C1),Power(Times(e,x),Plus(m,C1)),Power(Sinh(Times(d,Plus(a,Times(b,Log(Times(c,Power(x,n))))))),p),Power(Plus(Times(Sqr(b),Sqr(d),e,Sqr(n),Sqr(p)),Times(CN1,e,Sqr(Plus(m,C1)))),-1)),x)),Negate(Dist(Times(Sqr(b),Sqr(d),Sqr(n),p,Plus(p,Negate(C1)),Power(Plus(Times(Sqr(b),Sqr(d),Sqr(n),Sqr(p)),Negate(Sqr(Plus(m,C1)))),-1)),Int(Times(Power(Times(e,x),m),Power(Sinh(Times(d,Plus(a,Times(b,Log(Times(c,Power(x,n))))))),Plus(p,Negate(C2)))),x),x)),Simp(Times(b,d,n,p,Power(Times(e,x),Plus(m,C1)),Cosh(Times(d,Plus(a,Times(b,Log(Times(c,Power(x,n))))))),Power(Sinh(Times(d,Plus(a,Times(b,Log(Times(c,Power(x,n))))))),Plus(p,Negate(C1))),Power(Plus(Times(Sqr(b),Sqr(d),e,Sqr(n),Sqr(p)),Times(CN1,e,Sqr(Plus(m,C1)))),-1)),x)),And(FreeQ(List(a,b,c,d,e,m,n),x),IGtQ(p,C1),NeQ(Plus(Times(Sqr(b),Sqr(d),Sqr(n),Sqr(p)),Negate(Sqr(Plus(m,C1)))),C0)))),
IIntegrate(5530,Int(Times(Power(Cosh(Times(Plus(a_DEFAULT,Times(Log(Times(c_DEFAULT,Power(x_,n_DEFAULT))),b_DEFAULT)),d_DEFAULT)),p_),Power(Times(e_DEFAULT,x_),m_DEFAULT)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Plus(m,C1),Power(Times(e,x),Plus(m,C1)),Power(Cosh(Times(d,Plus(a,Times(b,Log(Times(c,Power(x,n))))))),p),Power(Plus(Times(Sqr(b),Sqr(d),e,Sqr(n),Sqr(p)),Times(CN1,e,Sqr(Plus(m,C1)))),-1)),x)),Dist(Times(Sqr(b),Sqr(d),Sqr(n),p,Plus(p,Negate(C1)),Power(Plus(Times(Sqr(b),Sqr(d),Sqr(n),Sqr(p)),Negate(Sqr(Plus(m,C1)))),-1)),Int(Times(Power(Times(e,x),m),Power(Cosh(Times(d,Plus(a,Times(b,Log(Times(c,Power(x,n))))))),Plus(p,Negate(C2)))),x),x),Simp(Times(b,d,n,p,Power(Times(e,x),Plus(m,C1)),Sinh(Times(d,Plus(a,Times(b,Log(Times(c,Power(x,n))))))),Power(Cosh(Times(d,Plus(a,Times(b,Log(Times(c,Power(x,n))))))),Plus(p,Negate(C1))),Power(Plus(Times(Sqr(b),Sqr(d),e,Sqr(n),Sqr(p)),Times(CN1,e,Sqr(Plus(m,C1)))),-1)),x)),And(FreeQ(List(a,b,c,d,e,m,n),x),IGtQ(p,C1),NeQ(Plus(Times(Sqr(b),Sqr(d),Sqr(n),Sqr(p)),Negate(Sqr(Plus(m,C1)))),C0)))),
IIntegrate(5531,Int(Times(Power(Times(e_DEFAULT,x_),m_DEFAULT),Power(Sinh(Times(Plus(a_DEFAULT,Times(Log(x_),b_DEFAULT)),d_DEFAULT)),p_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(Plus(m,C1),p),Power(Times(Power(C2,p),Power(b,p),Power(d,p),Power(p,p)),-1)),Int(ExpandIntegrand(Times(Power(Times(e,x),m),Power(Plus(Negate(Power(Times(Exp(Times(a,b,Sqr(d),p,Power(Plus(m,C1),-1))),Power(x,Times(Plus(m,C1),Power(p,-1)))),-1)),Times(Exp(Times(a,b,Sqr(d),p,Power(Plus(m,C1),-1))),Power(x,Times(Plus(m,C1),Power(p,-1))))),p)),x),x),x),And(FreeQ(List(a,b,d,e,m),x),IGtQ(p,C0),EqQ(Plus(Times(Sqr(b),Sqr(d),Sqr(p)),Negate(Sqr(Plus(m,C1)))),C0)))),
IIntegrate(5532,Int(Times(Power(Cosh(Times(Plus(a_DEFAULT,Times(Log(x_),b_DEFAULT)),d_DEFAULT)),p_DEFAULT),Power(Times(e_DEFAULT,x_),m_DEFAULT)),x_Symbol),
    Condition(Dist(Power(Power(C2,p),-1),Int(ExpandIntegrand(Times(Power(Times(e,x),m),Power(Plus(Power(Times(Exp(Times(a,b,Sqr(d),p,Power(Plus(m,C1),-1))),Power(x,Times(Plus(m,C1),Power(p,-1)))),-1),Times(Exp(Times(a,b,Sqr(d),p,Power(Plus(m,C1),-1))),Power(x,Times(Plus(m,C1),Power(p,-1))))),p)),x),x),x),And(FreeQ(List(a,b,d,e,m),x),IGtQ(p,C0),EqQ(Plus(Times(Sqr(b),Sqr(d),Sqr(p)),Negate(Sqr(Plus(m,C1)))),C0)))),
IIntegrate(5533,Int(Times(Power(Times(e_DEFAULT,x_),m_DEFAULT),Power(Sinh(Times(Plus(a_DEFAULT,Times(Log(x_),b_DEFAULT)),d_DEFAULT)),p_)),x_Symbol),
    Condition(Dist(Times(Power(Sinh(Times(d,Plus(a,Times(b,Log(x))))),p),Power(Times(Power(x,Times(b,d,p)),Power(Plus(C1,Negate(Power(Times(Exp(Times(C2,a,d)),Power(x,Times(C2,b,d))),-1))),p)),-1)),Int(Times(Power(Times(e,x),m),Power(x,Times(b,d,p)),Power(Plus(C1,Negate(Power(Times(Exp(Times(C2,a,d)),Power(x,Times(C2,b,d))),-1))),p)),x),x),And(FreeQ(List(a,b,d,e,m,p),x),Not(IntegerQ(p))))),
IIntegrate(5534,Int(Times(Power(Cosh(Times(Plus(a_DEFAULT,Times(Log(x_),b_DEFAULT)),d_DEFAULT)),p_),Power(Times(e_DEFAULT,x_),m_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(Cosh(Times(d,Plus(a,Times(b,Log(x))))),p),Power(Times(Power(x,Times(b,d,p)),Power(Plus(C1,Power(Times(Exp(Times(C2,a,d)),Power(x,Times(C2,b,d))),-1)),p)),-1)),Int(Times(Power(Times(e,x),m),Power(x,Times(b,d,p)),Power(Plus(C1,Power(Times(Exp(Times(C2,a,d)),Power(x,Times(C2,b,d))),-1)),p)),x),x),And(FreeQ(List(a,b,d,e,m,p),x),Not(IntegerQ(p))))),
IIntegrate(5535,Int(Times(Power(Times(e_DEFAULT,x_),m_DEFAULT),Power(Sinh(Times(Plus(a_DEFAULT,Times(Log(Times(c_DEFAULT,Power(x_,n_DEFAULT))),b_DEFAULT)),d_DEFAULT)),p_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(Times(e,x),Plus(m,C1)),Power(Times(e,n,Power(Times(c,Power(x,n)),Times(Plus(m,C1),Power(n,-1)))),-1)),Subst(Int(Times(Power(x,Plus(Times(Plus(m,C1),Power(n,-1)),Negate(C1))),Power(Sinh(Times(d,Plus(a,Times(b,Log(x))))),p)),x),x,Times(c,Power(x,n))),x),And(FreeQ(List(a,b,c,d,e,m,n,p),x),Or(NeQ(c,C1),NeQ(n,C1))))),
IIntegrate(5536,Int(Times(Power(Cosh(Times(Plus(a_DEFAULT,Times(Log(Times(c_DEFAULT,Power(x_,n_DEFAULT))),b_DEFAULT)),d_DEFAULT)),p_DEFAULT),Power(Times(e_DEFAULT,x_),m_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(Times(e,x),Plus(m,C1)),Power(Times(e,n,Power(Times(c,Power(x,n)),Times(Plus(m,C1),Power(n,-1)))),-1)),Subst(Int(Times(Power(x,Plus(Times(Plus(m,C1),Power(n,-1)),Negate(C1))),Power(Cosh(Times(d,Plus(a,Times(b,Log(x))))),p)),x),x,Times(c,Power(x,n))),x),And(FreeQ(List(a,b,c,d,e,m,n,p),x),Or(NeQ(c,C1),NeQ(n,C1))))),
IIntegrate(5537,Int(Times(Power(Times(Plus(e_DEFAULT,Times(Log(Times(g_DEFAULT,Power(x_,m_DEFAULT))),f_DEFAULT)),h_DEFAULT),q_DEFAULT),Sinh(Times(Plus(a_DEFAULT,Times(Log(Times(c_DEFAULT,Power(x_,n_DEFAULT))),b_DEFAULT)),d_DEFAULT))),x_Symbol),
    Condition(Plus(Negate(Dist(Power(Times(Exp(Times(a,d)),Power(Times(c,Power(x,n)),Times(b,d)),C2,Power(Power(x,Times(b,d,n)),-1)),-1),Int(Times(Power(Times(h,Plus(e,Times(f,Log(Times(g,Power(x,m)))))),q),Power(Power(x,Times(b,d,n)),-1)),x),x)),Dist(Times(Exp(Times(a,d)),Power(Times(c,Power(x,n)),Times(b,d)),Power(Times(C2,Power(x,Times(b,d,n))),-1)),Int(Times(Power(x,Times(b,d,n)),Power(Times(h,Plus(e,Times(f,Log(Times(g,Power(x,m)))))),q)),x),x)),FreeQ(List(a,b,c,d,e,f,g,h,m,n,q),x))),
IIntegrate(5538,Int(Times(Cosh(Times(Plus(a_DEFAULT,Times(Log(Times(c_DEFAULT,Power(x_,n_DEFAULT))),b_DEFAULT)),d_DEFAULT)),Power(Times(Plus(e_DEFAULT,Times(Log(Times(g_DEFAULT,Power(x_,m_DEFAULT))),f_DEFAULT)),h_DEFAULT),q_DEFAULT)),x_Symbol),
    Condition(Plus(Dist(Power(Times(Exp(Times(a,d)),Power(Times(c,Power(x,n)),Times(b,d)),C2,Power(Power(x,Times(b,d,n)),-1)),-1),Int(Times(Power(Times(h,Plus(e,Times(f,Log(Times(g,Power(x,m)))))),q),Power(Power(x,Times(b,d,n)),-1)),x),x),Dist(Times(Exp(Times(a,d)),Power(Times(c,Power(x,n)),Times(b,d)),Power(Times(C2,Power(x,Times(b,d,n))),-1)),Int(Times(Power(x,Times(b,d,n)),Power(Times(h,Plus(e,Times(f,Log(Times(g,Power(x,m)))))),q)),x),x)),FreeQ(List(a,b,c,d,e,f,g,h,m,n,q),x))),
IIntegrate(5539,Int(Times(Power(Times(Plus(e_DEFAULT,Times(Log(Times(g_DEFAULT,Power(x_,m_DEFAULT))),f_DEFAULT)),h_DEFAULT),q_DEFAULT),Power(Times(i_DEFAULT,x_),r_DEFAULT),Sinh(Times(Plus(a_DEFAULT,Times(Log(Times(c_DEFAULT,Power(x_,n_DEFAULT))),b_DEFAULT)),d_DEFAULT))),x_Symbol),
    Condition(Plus(Negate(Dist(Times(Power(Times(i,x),r),Power(Times(Exp(Times(a,d)),Power(Times(c,Power(x,n)),Times(b,d)),C2,Power(x,Plus(r,Times(CN1,b,d,n)))),-1)),Int(Times(Power(x,Plus(r,Times(CN1,b,d,n))),Power(Times(h,Plus(e,Times(f,Log(Times(g,Power(x,m)))))),q)),x),x)),Dist(Times(Exp(Times(a,d)),Power(Times(i,x),r),Power(Times(c,Power(x,n)),Times(b,d)),Power(Times(C2,Power(x,Plus(r,Times(b,d,n)))),-1)),Int(Times(Power(x,Plus(r,Times(b,d,n))),Power(Times(h,Plus(e,Times(f,Log(Times(g,Power(x,m)))))),q)),x),x)),FreeQ(List(a,b,c,d,e,f,g,h,i,m,n,q,r),x))),
IIntegrate(5540,Int(Times(Cosh(Times(Plus(a_DEFAULT,Times(Log(Times(c_DEFAULT,Power(x_,n_DEFAULT))),b_DEFAULT)),d_DEFAULT)),Power(Times(Plus(e_DEFAULT,Times(Log(Times(g_DEFAULT,Power(x_,m_DEFAULT))),f_DEFAULT)),h_DEFAULT),q_DEFAULT),Power(Times(i_DEFAULT,x_),r_DEFAULT)),x_Symbol),
    Condition(Plus(Dist(Times(Power(Times(i,x),r),Power(Times(Exp(Times(a,d)),Power(Times(c,Power(x,n)),Times(b,d)),C2,Power(x,Plus(r,Times(CN1,b,d,n)))),-1)),Int(Times(Power(x,Plus(r,Times(CN1,b,d,n))),Power(Times(h,Plus(e,Times(f,Log(Times(g,Power(x,m)))))),q)),x),x),Dist(Times(Exp(Times(a,d)),Power(Times(i,x),r),Power(Times(c,Power(x,n)),Times(b,d)),Power(Times(C2,Power(x,Plus(r,Times(b,d,n)))),-1)),Int(Times(Power(x,Plus(r,Times(b,d,n))),Power(Times(h,Plus(e,Times(f,Log(Times(g,Power(x,m)))))),q)),x),x)),FreeQ(List(a,b,c,d,e,f,g,h,i,m,n,q,r),x))),
IIntegrate(5541,Int(Power(Sech(Times(Plus(a_DEFAULT,Times(Log(x_),b_DEFAULT)),d_DEFAULT)),p_DEFAULT),x_Symbol),
    Condition(Dist(Times(Power(C2,p),Power(Exp(Times(a,d,p)),-1)),Int(Power(Times(Power(x,Times(b,d,p)),Power(Plus(C1,Power(Times(Exp(Times(C2,a,d)),Power(x,Times(C2,b,d))),-1)),p)),-1),x),x),And(FreeQ(List(a,b,d),x),IntegerQ(p)))),
IIntegrate(5542,Int(Power(Csch(Times(Plus(a_DEFAULT,Times(Log(x_),b_DEFAULT)),d_DEFAULT)),p_DEFAULT),x_Symbol),
    Condition(Dist(Times(Power(C2,p),Power(Exp(Times(a,d,p)),-1)),Int(Power(Times(Power(x,Times(b,d,p)),Power(Plus(C1,Negate(Power(Times(Exp(Times(C2,a,d)),Power(x,Times(C2,b,d))),-1))),p)),-1),x),x),And(FreeQ(List(a,b,d),x),IntegerQ(p)))),
IIntegrate(5543,Int(Power(Sech(Times(Plus(a_DEFAULT,Times(Log(x_),b_DEFAULT)),d_DEFAULT)),p_DEFAULT),x_Symbol),
    Condition(Dist(Times(Power(Sech(Times(d,Plus(a,Times(b,Log(x))))),p),Power(Plus(C1,Power(Times(Exp(Times(C2,a,d)),Power(x,Times(C2,b,d))),-1)),p),Power(Power(x,Times(CN1,b,d,p)),-1)),Int(Power(Times(Power(x,Times(b,d,p)),Power(Plus(C1,Power(Times(Exp(Times(C2,a,d)),Power(x,Times(C2,b,d))),-1)),p)),-1),x),x),And(FreeQ(List(a,b,d,p),x),Not(IntegerQ(p))))),
IIntegrate(5544,Int(Power(Csch(Times(Plus(a_DEFAULT,Times(Log(x_),b_DEFAULT)),d_DEFAULT)),p_DEFAULT),x_Symbol),
    Condition(Dist(Times(Power(Csch(Times(d,Plus(a,Times(b,Log(x))))),p),Power(Plus(C1,Negate(Power(Times(Exp(Times(C2,a,d)),Power(x,Times(C2,b,d))),-1))),p),Power(Power(x,Times(CN1,b,d,p)),-1)),Int(Power(Times(Power(x,Times(b,d,p)),Power(Plus(C1,Negate(Power(Times(Exp(Times(C2,a,d)),Power(x,Times(C2,b,d))),-1))),p)),-1),x),x),And(FreeQ(List(a,b,d,p),x),Not(IntegerQ(p))))),
IIntegrate(5545,Int(Power(Sech(Times(Plus(a_DEFAULT,Times(Log(Times(c_DEFAULT,Power(x_,n_DEFAULT))),b_DEFAULT)),d_DEFAULT)),p_DEFAULT),x_Symbol),
    Condition(Dist(Times(x,Power(Times(n,Power(Times(c,Power(x,n)),Power(n,-1))),-1)),Subst(Int(Times(Power(x,Plus(Power(n,-1),Negate(C1))),Power(Sech(Times(d,Plus(a,Times(b,Log(x))))),p)),x),x,Times(c,Power(x,n))),x),And(FreeQ(List(a,b,c,d,n,p),x),Or(NeQ(c,C1),NeQ(n,C1))))),
IIntegrate(5546,Int(Power(Csch(Times(Plus(a_DEFAULT,Times(Log(Times(c_DEFAULT,Power(x_,n_DEFAULT))),b_DEFAULT)),d_DEFAULT)),p_DEFAULT),x_Symbol),
    Condition(Dist(Times(x,Power(Times(n,Power(Times(c,Power(x,n)),Power(n,-1))),-1)),Subst(Int(Times(Power(x,Plus(Power(n,-1),Negate(C1))),Power(Csch(Times(d,Plus(a,Times(b,Log(x))))),p)),x),x,Times(c,Power(x,n))),x),And(FreeQ(List(a,b,c,d,n,p),x),Or(NeQ(c,C1),NeQ(n,C1))))),
IIntegrate(5547,Int(Times(Power(Times(e_DEFAULT,x_),m_DEFAULT),Power(Sech(Times(Plus(a_DEFAULT,Times(Log(x_),b_DEFAULT)),d_DEFAULT)),p_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(C2,p),Power(Exp(Times(a,d,p)),-1)),Int(Times(Power(Times(e,x),m),Power(Times(Power(x,Times(b,d,p)),Power(Plus(C1,Power(Times(Exp(Times(C2,a,d)),Power(x,Times(C2,b,d))),-1)),p)),-1)),x),x),And(FreeQ(List(a,b,d,e,m),x),IntegerQ(p)))),
IIntegrate(5548,Int(Times(Power(Csch(Times(Plus(a_DEFAULT,Times(Log(x_),b_DEFAULT)),d_DEFAULT)),p_DEFAULT),Power(Times(e_DEFAULT,x_),m_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(C2,p),Power(Exp(Times(a,d,p)),-1)),Int(Times(Power(Times(e,x),m),Power(Times(Power(x,Times(b,d,p)),Power(Plus(C1,Negate(Power(Times(Exp(Times(C2,a,d)),Power(x,Times(C2,b,d))),-1))),p)),-1)),x),x),And(FreeQ(List(a,b,d,e,m),x),IntegerQ(p)))),
IIntegrate(5549,Int(Times(Power(Times(e_DEFAULT,x_),m_DEFAULT),Power(Sech(Times(Plus(a_DEFAULT,Times(Log(x_),b_DEFAULT)),d_DEFAULT)),p_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(Sech(Times(d,Plus(a,Times(b,Log(x))))),p),Power(Plus(C1,Power(Times(Exp(Times(C2,a,d)),Power(x,Times(C2,b,d))),-1)),p),Power(Power(x,Times(CN1,b,d,p)),-1)),Int(Times(Power(Times(e,x),m),Power(Times(Power(x,Times(b,d,p)),Power(Plus(C1,Power(Times(Exp(Times(C2,a,d)),Power(x,Times(C2,b,d))),-1)),p)),-1)),x),x),And(FreeQ(List(a,b,d,e,m,p),x),Not(IntegerQ(p))))),
IIntegrate(5550,Int(Times(Power(Csch(Times(Plus(a_DEFAULT,Times(Log(x_),b_DEFAULT)),d_DEFAULT)),p_DEFAULT),Power(Times(e_DEFAULT,x_),m_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(Csch(Times(d,Plus(a,Times(b,Log(x))))),p),Power(Plus(C1,Negate(Power(Times(Exp(Times(C2,a,d)),Power(x,Times(C2,b,d))),-1))),p),Power(Power(x,Times(CN1,b,d,p)),-1)),Int(Times(Power(Times(e,x),m),Power(Times(Power(x,Times(b,d,p)),Power(Plus(C1,Negate(Power(Times(Exp(Times(C2,a,d)),Power(x,Times(C2,b,d))),-1))),p)),-1)),x),x),And(FreeQ(List(a,b,d,e,m,p),x),Not(IntegerQ(p)))))
  );
}
