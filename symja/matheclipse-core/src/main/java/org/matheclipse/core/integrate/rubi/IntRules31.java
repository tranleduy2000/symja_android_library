package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.ASymbol;
import static org.matheclipse.core.expression.F.A_DEFAULT;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.BSymbol;
import static org.matheclipse.core.expression.F.B_DEFAULT;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.C5;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.CSymbol;
import static org.matheclipse.core.expression.F.C_DEFAULT;
import static org.matheclipse.core.expression.F.Coefficient;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.D;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.MatchQ;
import static org.matheclipse.core.expression.F.Module;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.PolynomialQuotient;
import static org.matheclipse.core.expression.F.PolynomialRemainder;
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
import static org.matheclipse.core.expression.F.a_DEFAULT;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_;
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
import static org.matheclipse.core.expression.F.h;
import static org.matheclipse.core.expression.F.h_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.r;
import static org.matheclipse.core.expression.F.r_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.u_DEFAULT;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Coeff;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Expon;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearPairQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PolyQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RemoveContent;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/** 
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class IntRules31 { 
  public static IAST RULES = List( 
IIntegrate(1551,Int(Times(Power(Times(f_,x_),m_),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2",true)))),p_),Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(f,IntPart(m)),Power(Times(f,x),FracPart(m)),Power(Power(x,FracPart(m)),-1)),Int(Times(Power(x,m),Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(a,Times(c,Power(x,Times(C2,n)))),p)),x),x),And(FreeQ(List(a,c,d,e,f,m,p,q),x),EqQ($s("n2"),Times(C2,n)),FractionQ(n)))),
IIntegrate(1552,Int(Times(Power(x_,m_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2",true))),Times(b_DEFAULT,Power(x_,n_))),p_),Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_DEFAULT)),x_Symbol),
    Condition(Dist(Power(Plus(m,C1),-1),Subst(Int(Times(Power(Plus(d,Times(e,Power(x,Simplify(Times(n,Power(Plus(m,C1),-1)))))),q),Power(Plus(a,Times(b,Power(x,Simplify(Times(n,Power(Plus(m,C1),-1))))),Times(c,Power(x,Simplify(Times(C2,n,Power(Plus(m,C1),-1)))))),p)),x),x,Power(x,Plus(m,C1))),x),And(FreeQ(List(a,b,c,d,e,m,n,p,q),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),IntegerQ(Simplify(Times(n,Power(Plus(m,C1),-1)))),Not(IntegerQ(n))))),
IIntegrate(1553,Int(Times(Power(x_,m_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2",true)))),p_),Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_DEFAULT)),x_Symbol),
    Condition(Dist(Power(Plus(m,C1),-1),Subst(Int(Times(Power(Plus(d,Times(e,Power(x,Simplify(Times(n,Power(Plus(m,C1),-1)))))),q),Power(Plus(a,Times(c,Power(x,Simplify(Times(C2,n,Power(Plus(m,C1),-1)))))),p)),x),x,Power(x,Plus(m,C1))),x),And(FreeQ(List(a,c,d,e,m,n,p,q),x),EqQ($s("n2"),Times(C2,n)),IntegerQ(Simplify(Times(n,Power(Plus(m,C1),-1)))),Not(IntegerQ(n))))),
IIntegrate(1554,Int(Times(Power(Times(f_,x_),m_),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2",true))),Times(b_DEFAULT,Power(x_,n_))),p_),Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(f,IntPart(m)),Power(Times(f,x),FracPart(m)),Power(Power(x,FracPart(m)),-1)),Int(Times(Power(x,m),Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),p)),x),x),And(FreeQ(List(a,b,c,d,e,f,m,p,q),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),IntegerQ(Simplify(Times(n,Power(Plus(m,C1),-1)))),Not(IntegerQ(n))))),
IIntegrate(1555,Int(Times(Power(Times(f_,x_),m_),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2",true)))),p_),Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(f,IntPart(m)),Power(Times(f,x),FracPart(m)),Power(Power(x,FracPart(m)),-1)),Int(Times(Power(x,m),Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(a,Times(c,Power(x,Times(C2,n)))),p)),x),x),And(FreeQ(List(a,c,d,e,f,m,p,q),x),EqQ($s("n2"),Times(C2,n)),IntegerQ(Simplify(Times(n,Power(Plus(m,C1),-1)))),Not(IntegerQ(n))))),
IIntegrate(1556,Int(Times(Power(Times(f_DEFAULT,x_),m_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2",true))),Times(b_DEFAULT,Power(x_,n_))),-1),Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_)),x_Symbol),
    Condition(With(List(Set(r,Rt(Plus(Sqr(b),Times(CN1,C4,a,c)),C2))),Plus(Dist(Times(C2,c,Power(r,-1)),Int(Times(Power(Times(f,x),m),Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(b,Negate(r),Times(C2,c,Power(x,n))),-1)),x),x),Negate(Dist(Times(C2,c,Power(r,-1)),Int(Times(Power(Times(f,x),m),Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(b,r,Times(C2,c,Power(x,n))),-1)),x),x)))),And(FreeQ(List(a,b,c,d,e,f,m,n,q),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0)))),
IIntegrate(1557,Int(Times(Power(Times(f_DEFAULT,x_),m_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2",true)))),-1),Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_)),x_Symbol),
    Condition(With(List(Set(r,Rt(Times(CN1,a,c),C2))),Plus(Negate(Dist(Times(c,Power(Times(C2,r),-1)),Int(Times(Power(Times(f,x),m),Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(r,Times(CN1,c,Power(x,n))),-1)),x),x)),Negate(Dist(Times(c,Power(Times(C2,r),-1)),Int(Times(Power(Times(f,x),m),Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(r,Times(c,Power(x,n))),-1)),x),x)))),And(FreeQ(List(a,c,d,e,f,m,n,q),x),EqQ($s("n2"),Times(C2,n))))),
IIntegrate(1558,Int(Times(Power(Times(f_DEFAULT,x_),m_DEFAULT),Plus(d_,Times(e_DEFAULT,Power(x_,n_))),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_)),Times(c_DEFAULT,Power(x_,$p("n2")))),p_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),Plus(p,C1)),Plus(Times(d,Plus(Sqr(b),Times(CN1,C2,a,c))),Times(CN1,a,b,e),Times(Plus(Times(b,d),Times(CN1,C2,a,e)),c,Power(x,n))),Power(Times(a,f,n,Plus(p,C1),Plus(Sqr(b),Times(CN1,C4,a,c))),-1)),x)),Dist(Power(Times(a,n,Plus(p,C1),Plus(Sqr(b),Times(CN1,C4,a,c))),-1),Int(Times(Power(Times(f,x),m),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),Plus(p,C1)),Simp(Plus(Times(d,Plus(Times(Sqr(b),Plus(m,Times(n,Plus(p,C1)),C1)),Times(CN1,C2,a,c,Plus(m,Times(C2,n,Plus(p,C1)),C1)))),Times(CN1,a,b,e,Plus(m,C1)),Times(Plus(m,Times(n,Plus(Times(C2,p),C3)),C1),Plus(Times(b,d),Times(CN1,C2,a,e)),c,Power(x,n))),x)),x),x)),And(FreeQ(List(a,b,c,d,e,f,m,n),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),ILtQ(Plus(p,C1),C0)))),
IIntegrate(1559,Int(Times(Power(Times(f_DEFAULT,x_),m_DEFAULT),Plus(d_,Times(e_DEFAULT,Power(x_,n_))),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2")))),p_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(a,Times(c,Power(x,Times(C2,n)))),Plus(p,C1)),Plus(d,Times(e,Power(x,n))),Power(Times(C2,a,f,n,Plus(p,C1)),-1)),x)),Dist(Power(Times(C2,a,n,Plus(p,C1)),-1),Int(Times(Power(Times(f,x),m),Power(Plus(a,Times(c,Power(x,Times(C2,n)))),Plus(p,C1)),Simp(Plus(Times(d,Plus(m,Times(C2,n,Plus(p,C1)),C1)),Times(e,Plus(m,Times(n,Plus(Times(C2,p),C3)),C1),Power(x,n))),x)),x),x)),And(FreeQ(List(a,c,d,e,f,m,n),x),EqQ($s("n2"),Times(C2,n)),ILtQ(Plus(p,C1),C0)))),
IIntegrate(1560,Int(Times(Power(Times(f_DEFAULT,x_),m_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2",true))),Times(b_DEFAULT,Power(x_,n_))),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_DEFAULT)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times(Power(Times(f,x),m),Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),p)),x),x),And(FreeQ(List(a,b,c,d,e,f,m,n,p,q),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),Or(IGtQ(p,C0),IGtQ(q,C0))))),
IIntegrate(1561,Int(Times(Power(Times(f_DEFAULT,x_),m_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2",true)))),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_DEFAULT)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times(Power(Times(f,x),m),Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(a,Times(c,Power(x,Times(C2,n)))),p)),x),x),And(FreeQ(List(a,c,d,e,f,m,n,p,q),x),EqQ($s("n2"),Times(C2,n)),Or(IGtQ(p,C0),IGtQ(q,C0))))),
IIntegrate(1562,Int(Times(Power(Times(f_DEFAULT,x_),m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2")))),p_)),x_Symbol),
    Condition(Dist(Times(Power(Times(f,x),m),Power(Power(x,m),-1)),Int(ExpandIntegrand(Times(Power(x,m),Power(Plus(a,Times(c,Power(x,Times(C2,n)))),p)),Power(Plus(Times(d,Power(Plus(Sqr(d),Times(CN1,Sqr(e),Power(x,Times(C2,n)))),-1)),Times(CN1,e,Power(x,n),Power(Plus(Sqr(d),Times(CN1,Sqr(e),Power(x,Times(C2,n)))),-1))),Negate(q)),x),x),x),And(FreeQ(List(a,c,d,e,f,m,n,p),x),EqQ($s("n2"),Times(C2,n)),Not(IntegerQ(p)),ILtQ(q,C0)))),
IIntegrate(1563,Int(Times(Power(Times(f_DEFAULT,x_),m_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2",true))),Times(b_DEFAULT,Power(x_,n_))),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_DEFAULT)),x_Symbol),
    Condition(Unintegrable(Times(Power(Times(f,x),m),Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),p)),x),And(FreeQ(List(a,b,c,d,e,f,m,n,p,q),x),EqQ($s("n2"),Times(C2,n))))),
IIntegrate(1564,Int(Times(Power(Times(f_DEFAULT,x_),m_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2",true)))),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_DEFAULT)),x_Symbol),
    Condition(Unintegrable(Times(Power(Times(f,x),m),Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(a,Times(c,Power(x,Times(C2,n)))),p)),x),And(FreeQ(List(a,c,d,e,f,m,n,p,q),x),EqQ($s("n2"),Times(C2,n))))),
IIntegrate(1565,Int(Times(Power(u_,m_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(v_,$p("n2",true))),Times(b_DEFAULT,Power(v_,n_))),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Power(v_,n_))),q_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(u,m),Power(Times(Coefficient(v,x,C1),Power(v,m)),-1)),Subst(Int(Times(Power(x,m),Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),p)),x),x,v),x),And(FreeQ(List(a,b,c,d,e,m,n,p,q),x),EqQ($s("n2"),Times(C2,n)),LinearPairQ(u,v,x),NeQ(v,x)))),
IIntegrate(1566,Int(Times(Power(u_,m_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(v_,$p("n2",true)))),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Power(v_,n_))),q_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(u,m),Power(Times(Coefficient(v,x,C1),Power(v,m)),-1)),Subst(Int(Times(Power(x,m),Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(a,Times(c,Power(x,Times(C2,n)))),p)),x),x,v),x),And(FreeQ(List(a,c,d,e,m,n,p),x),EqQ($s("n2"),Times(C2,n)),LinearPairQ(u,v,x),NeQ(v,x)))),
IIntegrate(1567,Int(Times(Power(x_,m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Power(x_,$p("mn",true)))),q_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_DEFAULT)),Times(c_DEFAULT,Power(x_,$p("n2",true)))),p_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(x,Plus(m,Times(CN1,n,q))),Power(Plus(e,Times(d,Power(x,n))),q),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),p)),x),And(FreeQ(List(a,b,c,d,e,m,n,p),x),EqQ($s("n2"),Times(C2,n)),EqQ($s("mn"),Negate(n)),IntegerQ(q),Or(PosQ(n),Not(IntegerQ(p)))))),
IIntegrate(1568,Int(Times(Power(x_,m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Power(x_,$p("mn",true)))),q_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2",true)))),p_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(x,Plus(m,Times($s("mn"),q))),Power(Plus(e,Times(d,Power(Power(x,$s("mn")),-1))),q),Power(Plus(a,Times(c,Power(x,$s("n2")))),p)),x),And(FreeQ(List(a,c,d,e,m,$s("mn"),p),x),EqQ($s("n2"),Times(CN2,$s("mn"))),IntegerQ(q),Or(PosQ($s("n2")),Not(IntegerQ(p)))))),
IIntegrate(1569,Int(Times(Power(x_,m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,$p("mn",true))),Times(c_DEFAULT,Power(x_,$p("mn2",true)))),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_DEFAULT))),q_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(x,Plus(m,Times(CN1,C2,n,p))),Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(c,Times(b,Power(x,n)),Times(a,Power(x,Times(C2,n)))),p)),x),And(FreeQ(List(a,b,c,d,e,m,n,q),x),EqQ($s("mn"),Negate(n)),EqQ($s("mn2"),Times(C2,$s("mn"))),IntegerQ(p)))),
IIntegrate(1570,Int(Times(Power(x_,m_DEFAULT),Power(Plus(a_DEFAULT,Times(c_DEFAULT,Power(x_,$p("mn2",true)))),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_DEFAULT))),q_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(x,Plus(m,Times(CN1,C2,n,p))),Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(c,Times(a,Power(x,Times(C2,n)))),p)),x),And(FreeQ(List(a,c,d,e,m,n,q),x),EqQ($s("mn2"),Times(CN2,n)),IntegerQ(p)))),
IIntegrate(1571,Int(Times(Power(x_,m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Power(x_,$p("mn",true)))),q_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_DEFAULT)),Times(c_DEFAULT,Power(x_,$p("n2",true)))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(e,IntPart(q)),Power(x,Times(n,FracPart(q))),Power(Plus(d,Times(e,Power(Power(x,n),-1))),FracPart(q)),Power(Power(Plus(C1,Times(d,Power(x,n),Power(e,-1))),FracPart(q)),-1)),Int(Times(Power(x,Plus(m,Times(CN1,n,q))),Power(Plus(C1,Times(d,Power(x,n),Power(e,-1))),q),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),p)),x),x),And(FreeQ(List(a,b,c,d,e,m,n,p,q),x),EqQ($s("n2"),Times(C2,n)),EqQ($s("mn"),Negate(n)),Not(IntegerQ(p)),Not(IntegerQ(q)),PosQ(n)))),
IIntegrate(1572,Int(Times(Power(x_,m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Power(x_,$p("mn",true)))),q_),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2",true)))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(e,IntPart(q)),Power(Plus(d,Times(e,Power(x,$s("mn")))),FracPart(q)),Power(Times(Power(x,Times($s("mn"),FracPart(q))),Power(Plus(C1,Times(d,Power(Times(Power(x,$s("mn")),e),-1))),FracPart(q))),-1)),Int(Times(Power(x,Plus(m,Times($s("mn"),q))),Power(Plus(C1,Times(d,Power(Times(Power(x,$s("mn")),e),-1))),q),Power(Plus(a,Times(c,Power(x,$s("n2")))),p)),x),x),And(FreeQ(List(a,c,d,e,m,$s("mn"),p,q),x),EqQ($s("n2"),Times(CN2,$s("mn"))),Not(IntegerQ(p)),Not(IntegerQ(q)),PosQ($s("n2"))))),
IIntegrate(1573,Int(Times(Power(x_,m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,$p("mn",true))),Times(c_DEFAULT,Power(x_,$p("mn2",true)))),p_),Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_DEFAULT))),q_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(x,Times(C2,n,FracPart(p))),Power(Plus(a,Times(b,Power(Power(x,n),-1)),Times(c,Power(Power(x,Times(C2,n)),-1))),FracPart(p)),Power(Power(Plus(c,Times(b,Power(x,n)),Times(a,Power(x,Times(C2,n)))),FracPart(p)),-1)),Int(Times(Power(x,Plus(m,Times(CN1,C2,n,p))),Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(c,Times(b,Power(x,n)),Times(a,Power(x,Times(C2,n)))),p)),x),x),And(FreeQ(List(a,b,c,d,e,m,n,p,q),x),EqQ($s("mn"),Negate(n)),EqQ($s("mn2"),Times(C2,$s("mn"))),Not(IntegerQ(p)),Not(IntegerQ(q)),PosQ(n)))),
IIntegrate(1574,Int(Times(Power(x_,m_DEFAULT),Power(Plus(a_DEFAULT,Times(c_DEFAULT,Power(x_,$p("mn2",true)))),p_),Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_DEFAULT))),q_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(x,Times(C2,n,FracPart(p))),Power(Plus(a,Times(c,Power(Power(x,Times(C2,n)),-1))),FracPart(p)),Power(Power(Plus(c,Times(a,Power(x,Times(C2,n)))),FracPart(p)),-1)),Int(Times(Power(x,Plus(m,Times(CN1,C2,n,p))),Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(c,Times(a,Power(x,Times(C2,n)))),p)),x),x),And(FreeQ(List(a,c,d,e,m,n,p,q),x),EqQ($s("mn2"),Times(CN2,n)),Not(IntegerQ(p)),Not(IntegerQ(q)),PosQ(n)))),
IIntegrate(1575,Int(Times(Power(Times(f_,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Power(x_,$p("mn",true)))),q_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_DEFAULT)),Times(c_DEFAULT,Power(x_,$p("n2",true)))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(f,IntPart(m)),Power(Times(f,x),FracPart(m)),Power(Power(x,FracPart(m)),-1)),Int(Times(Power(x,m),Power(Plus(d,Times(e,Power(x,$s("mn")))),q),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),p)),x),x),And(FreeQ(List(a,b,c,d,e,f,m,n,p,q),x),EqQ($s("n2"),Times(C2,n)),EqQ($s("mn"),Negate(n))))),
IIntegrate(1576,Int(Times(Power(Times(f_,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Power(x_,$p("mn",true)))),q_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2",true)))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(f,IntPart(m)),Power(Times(f,x),FracPart(m)),Power(Power(x,FracPart(m)),-1)),Int(Times(Power(x,m),Power(Plus(d,Times(e,Power(x,$s("mn")))),q),Power(Plus(a,Times(c,Power(x,$s("n2")))),p)),x),x),And(FreeQ(List(a,c,d,e,f,m,$s("mn"),p,q),x),EqQ($s("n2"),Times(CN2,$s("mn")))))),
IIntegrate(1577,Int(Times(Power(x_,m_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(x_,n_DEFAULT)),Times(b_DEFAULT,Power(x_,$p("mn")))),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(x,Plus(m,Times(CN1,n,p))),Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(b,Times(a,Power(x,n)),Times(c,Power(x,Times(C2,n)))),p)),x),And(FreeQ(List(a,b,c,d,e,m,n,q),x),EqQ($s("mn"),Negate(n)),IntegerQ(p)))),
IIntegrate(1578,Int(Times(Power(x_,m_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(x_,n_DEFAULT)),Times(b_DEFAULT,Power(x_,$p("mn")))),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(x,Times(n,FracPart(p))),Power(Plus(a,Times(b,Power(Power(x,n),-1)),Times(c,Power(x,n))),FracPart(p)),Power(Power(Plus(b,Times(a,Power(x,n)),Times(c,Power(x,Times(C2,n)))),FracPart(p)),-1)),Int(Times(Power(x,Plus(m,Times(CN1,n,p))),Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(b,Times(a,Power(x,n)),Times(c,Power(x,Times(C2,n)))),p)),x),x),And(FreeQ(List(a,b,c,d,e,m,n,p,q),x),EqQ($s("mn"),Negate(n)),Not(IntegerQ(p))))),
IIntegrate(1579,Int(Times(Power(Times(f_,x_),m_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(x_,n_DEFAULT)),Times(b_DEFAULT,Power(x_,$p("mn")))),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(f,IntPart(m)),Power(Times(f,x),FracPart(m)),Power(Power(x,FracPart(m)),-1)),Int(Times(Power(x,m),Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(a,Times(b,Power(Power(x,n),-1)),Times(c,Power(x,n))),p)),x),x),And(FreeQ(List(a,b,c,d,e,f,m,n,p,q),x),EqQ($s("mn"),Negate(n))))),
IIntegrate(1580,Int(Times(Power(Times(f_DEFAULT,x_),m_DEFAULT),Power(Plus($p("d1"),Times($p("e1",true),Power(x_,$p("non2",true)))),q_DEFAULT),Power(Plus($p("d2"),Times($p("e2",true),Power(x_,$p("non2",true)))),q_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_)),Times(c_DEFAULT,Power(x_,$p("n2")))),p_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(Times(f,x),m),Power(Plus(Times($s("d1"),$s("d2")),Times($s("e1"),$s("e2"),Power(x,n))),q),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),p)),x),And(FreeQ(List(a,b,c,$s("d1"),$s("e1"),$s("d2"),$s("e2"),f,n,p,q),x),EqQ($s("n2"),Times(C2,n)),EqQ($s("non2"),Times(C1D2,n)),EqQ(Plus(Times($s("d2"),$s("e1")),Times($s("d1"),$s("e2"))),C0),Or(IntegerQ(q),And(GtQ($s("d1"),C0),GtQ($s("d2"),C0)))))),
IIntegrate(1581,Int(Times(Power(Times(f_DEFAULT,x_),m_DEFAULT),Power(Plus($p("d1"),Times($p("e1",true),Power(x_,$p("non2",true)))),q_DEFAULT),Power(Plus($p("d2"),Times($p("e2",true),Power(x_,$p("non2",true)))),q_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_)),Times(c_DEFAULT,Power(x_,$p("n2")))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(Plus($s("d1"),Times($s("e1"),Power(x,Times(C1D2,n)))),FracPart(q)),Power(Plus($s("d2"),Times($s("e2"),Power(x,Times(C1D2,n)))),FracPart(q)),Power(Power(Plus(Times($s("d1"),$s("d2")),Times($s("e1"),$s("e2"),Power(x,n))),FracPart(q)),-1)),Int(Times(Power(Times(f,x),m),Power(Plus(Times($s("d1"),$s("d2")),Times($s("e1"),$s("e2"),Power(x,n))),q),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),p)),x),x),And(FreeQ(List(a,b,c,$s("d1"),$s("e1"),$s("d2"),$s("e2"),f,n,p,q),x),EqQ($s("n2"),Times(C2,n)),EqQ($s("non2"),Times(C1D2,n)),EqQ(Plus(Times($s("d2"),$s("e1")),Times($s("d1"),$s("e2"))),C0)))),
IIntegrate(1582,Int(Times($p("§px"),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Coeff($s("§px"),x,Plus(n,Negate(C1))),Power(Plus(a,Times(b,Power(x,n))),Plus(p,C1)),Power(Times(b,n,Plus(p,C1)),-1)),x),Int(Times(Plus($s("§px"),Times(CN1,Coeff($s("§px"),x,Plus(n,Negate(C1))),Power(x,Plus(n,Negate(C1))))),Power(Plus(a,Times(b,Power(x,n))),p)),x)),And(FreeQ(List(a,b),x),PolyQ($s("§px"),x),IGtQ(p,C1),IGtQ(n,C1),NeQ(Coeff($s("§px"),x,Plus(n,Negate(C1))),C0),NeQ($s("§px"),Times(Coeff($s("§px"),x,Plus(n,Negate(C1))),Power(x,Plus(n,Negate(C1))))),Not(MatchQ($s("§px"),Condition(Times($p("§qx",true),Power(Plus(c_,Times(d_DEFAULT,Power(x,m_))),q_)),And(FreeQ(List(c,d),x),PolyQ($s("§qx"),x),IGtQ(q,C1),IGtQ(m,C1),NeQ(Coeff(Times($s("§qx"),Power(Plus(a,Times(b,Power(x,n))),p)),x,Plus(m,Negate(C1))),C0),GtQ(Times(m,q),Times(n,p))))))))),
IIntegrate(1583,Int(Times($p("§px"),Power(x_,m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_DEFAULT))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Coeff($s("§px"),x,Plus(n,Negate(m),Negate(C1))),Power(Plus(a,Times(b,Power(x,n))),Plus(p,C1)),Power(Times(b,n,Plus(p,C1)),-1)),x),Int(Times(Plus($s("§px"),Times(CN1,Coeff($s("§px"),x,Plus(n,Negate(m),Negate(C1))),Power(x,Plus(n,Negate(m),Negate(C1))))),Power(x,m),Power(Plus(a,Times(b,Power(x,n))),p)),x)),And(FreeQ(List(a,b,m,n),x),PolyQ($s("§px"),x),IGtQ(p,C1),IGtQ(Plus(n,Negate(m)),C0),NeQ(Coeff($s("§px"),x,Plus(n,Negate(m),Negate(C1))),C0)))),
IIntegrate(1584,Int(Times(u_DEFAULT,Power(x_,m_DEFAULT),Power(Plus(Times(a_DEFAULT,Power(x_,p_DEFAULT)),Times(b_DEFAULT,Power(x_,q_DEFAULT))),n_DEFAULT)),x_Symbol),
    Condition(Int(Times(u,Power(x,Plus(m,Times(n,p))),Power(Plus(a,Times(b,Power(x,Plus(q,Negate(p))))),n)),x),And(FreeQ(List(a,b,m,p,q),x),IntegerQ(n),PosQ(Plus(q,Negate(p)))))),
IIntegrate(1585,Int(Times(u_DEFAULT,Power(x_,m_DEFAULT),Power(Plus(Times(a_DEFAULT,Power(x_,p_DEFAULT)),Times(b_DEFAULT,Power(x_,q_DEFAULT)),Times(c_DEFAULT,Power(x_,r_DEFAULT))),n_DEFAULT)),x_Symbol),
    Condition(Int(Times(u,Power(x,Plus(m,Times(n,p))),Power(Plus(a,Times(b,Power(x,Plus(q,Negate(p)))),Times(c,Power(x,Plus(r,Negate(p))))),n)),x),And(FreeQ(List(a,b,c,m,p,q,r),x),IntegerQ(n),PosQ(Plus(q,Negate(p))),PosQ(Plus(r,Negate(p)))))),
IIntegrate(1586,Int(Times(u_DEFAULT,Power($p("§px"),p_DEFAULT),Power($p("§qx"),q_DEFAULT)),x_Symbol),
    Condition(Int(Times(u,Power(PolynomialQuotient($s("§px"),$s("§qx"),x),p),Power($s("§qx"),Plus(p,q))),x),And(FreeQ(q,x),PolyQ($s("§px"),x),PolyQ($s("§qx"),x),EqQ(PolynomialRemainder($s("§px"),$s("§qx"),x),C0),IntegerQ(p),LtQ(Times(p,q),C0)))),
IIntegrate(1587,Int(Times($p("§pp"),Power($p("§qq"),-1)),x_Symbol),
    Condition(With(List(Set(p,Expon($s("§pp"),x)),Set(q,Expon($s("§qq"),x))),Condition(Simp(Times(Coeff($s("§pp"),x,p),Log(RemoveContent($s("§qq"),x)),Power(Times(q,Coeff($s("§qq"),x,q)),-1)),x),And(EqQ(p,Plus(q,Negate(C1))),EqQ($s("§pp"),Simplify(Times(Coeff($s("§pp"),x,p),D($s("§qq"),x),Power(Times(q,Coeff($s("§qq"),x,q)),-1))))))),And(PolyQ($s("§pp"),x),PolyQ($s("§qq"),x)))),
IIntegrate(1588,Int(Times($p("§pp"),Power($p("§qq"),m_DEFAULT)),x_Symbol),
    Condition(With(List(Set(p,Expon($s("§pp"),x)),Set(q,Expon($s("§qq"),x))),Condition(Simp(Times(Coeff($s("§pp"),x,p),Power(x,Plus(p,Negate(q),C1)),Power($s("§qq"),Plus(m,C1)),Power(Times(Plus(p,Times(m,q),C1),Coeff($s("§qq"),x,q)),-1)),x),And(NeQ(Plus(p,Times(m,q),C1),C0),EqQ(Times(Plus(p,Times(m,q),C1),Coeff($s("§qq"),x,q),$s("§pp")),Times(Coeff($s("§pp"),x,p),Power(x,Plus(p,Negate(q))),Plus(Times(Plus(p,Negate(q),C1),$s("§qq")),Times(Plus(m,C1),x,D($s("§qq"),x)))))))),And(FreeQ(m,x),PolyQ($s("§pp"),x),PolyQ($s("§qq"),x),NeQ(m,CN1)))),
IIntegrate(1589,Int(Times(Power(x_,m_DEFAULT),Power(Plus($p("a1"),Times($p("b1",true),Power(x_,n_DEFAULT))),p_),Power(Plus($p("a2"),Times($p("b2",true),Power(x_,n_DEFAULT))),p_)),x_Symbol),
    Condition(Simp(Times(Power(Plus($s("a1"),Times($s("b1"),Power(x,n))),Plus(p,C1)),Power(Plus($s("a2"),Times($s("b2"),Power(x,n))),Plus(p,C1)),Power(Times(C2,$s("b1"),$s("b2"),n,Plus(p,C1)),-1)),x),And(FreeQ(List($s("a1"),$s("b1"),$s("a2"),$s("b2"),m,n,p),x),EqQ(Plus(Times($s("a2"),$s("b1")),Times($s("a1"),$s("b2"))),C0),EqQ(Plus(m,Times(CN1,C2,n),C1),C0),NeQ(p,CN1)))),
IIntegrate(1590,Int(Times($p("§pp"),Power($p("§qq"),m_DEFAULT),Power($p("§rr"),n_DEFAULT)),x_Symbol),
    Condition(With(List(Set(p,Expon($s("§pp"),x)),Set(q,Expon($s("§qq"),x)),Set(r,Expon($s("§rr"),x))),Condition(Simp(Times(Coeff($s("§pp"),x,p),Power(x,Plus(p,Negate(q),Negate(r),C1)),Power($s("§qq"),Plus(m,C1)),Power($s("§rr"),Plus(n,C1)),Power(Times(Plus(p,Times(m,q),Times(n,r),C1),Coeff($s("§qq"),x,q),Coeff($s("§rr"),x,r)),-1)),x),And(NeQ(Plus(p,Times(m,q),Times(n,r),C1),C0),EqQ(Times(Plus(p,Times(m,q),Times(n,r),C1),Coeff($s("§qq"),x,q),Coeff($s("§rr"),x,r),$s("§pp")),Times(Coeff($s("§pp"),x,p),Power(x,Plus(p,Negate(q),Negate(r))),Plus(Times(Plus(p,Negate(q),Negate(r),C1),$s("§qq"),$s("§rr")),Times(Plus(m,C1),x,$s("§rr"),D($s("§qq"),x)),Times(Plus(n,C1),x,$s("§qq"),D($s("§rr"),x)))))))),And(FreeQ(List(m,n),x),PolyQ($s("§pp"),x),PolyQ($s("§qq"),x),PolyQ($s("§rr"),x),NeQ(m,CN1),NeQ(n,CN1)))),
IIntegrate(1591,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power($p("§pq"),n_DEFAULT))),p_DEFAULT),$p("§qr")),x_Symbol),
    Condition(With(List(Set(q,Expon($s("§pq"),x)),Set(r,Expon($s("§qr"),x))),Condition(Dist(Times(Coeff($s("§qr"),x,r),Power(Times(q,Coeff($s("§pq"),x,q)),-1)),Subst(Int(Power(Plus(a,Times(b,Power(x,n))),p),x),x,$s("§pq")),x),And(EqQ(r,Plus(q,Negate(C1))),EqQ(Times(Coeff($s("§qr"),x,r),D($s("§pq"),x)),Times(q,Coeff($s("§pq"),x,q),$s("§qr")))))),And(FreeQ(List(a,b,n,p),x),PolyQ($s("§pq"),x),PolyQ($s("§qr"),x)))),
IIntegrate(1592,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power($p("§pq"),n_DEFAULT)),Times(c_DEFAULT,Power($p("§pq"),$p("n2",true)))),p_DEFAULT),$p("§qr")),x_Symbol),
    Condition(Module(List(Set(q,Expon($s("§pq"),x)),Set(r,Expon($s("§qr"),x))),Condition(Dist(Times(Coeff($s("§qr"),x,r),Power(Times(q,Coeff($s("§pq"),x,q)),-1)),Subst(Int(Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),p),x),x,$s("§pq")),x),And(EqQ(r,Plus(q,Negate(C1))),EqQ(Times(Coeff($s("§qr"),x,r),D($s("§pq"),x)),Times(q,Coeff($s("§pq"),x,q),$s("§qr")))))),And(FreeQ(List(a,b,c,n,p),x),EqQ($s("n2"),Times(C2,n)),PolyQ($s("§pq"),x),PolyQ($s("§qr"),x)))),
IIntegrate(1593,Int(Times(u_DEFAULT,Power(Plus(Times(a_DEFAULT,Power(x_,p_DEFAULT)),Times(b_DEFAULT,Power(x_,q_DEFAULT))),n_DEFAULT)),x_Symbol),
    Condition(Int(Times(u,Power(x,Times(n,p)),Power(Plus(a,Times(b,Power(x,Plus(q,Negate(p))))),n)),x),And(FreeQ(List(a,b,p,q),x),IntegerQ(n),PosQ(Plus(q,Negate(p)))))),
IIntegrate(1594,Int(Times(u_DEFAULT,Power(Plus(Times(a_DEFAULT,Power(x_,p_DEFAULT)),Times(b_DEFAULT,Power(x_,q_DEFAULT)),Times(c_DEFAULT,Power(x_,r_DEFAULT))),n_DEFAULT)),x_Symbol),
    Condition(Int(Times(u,Power(x,Times(n,p)),Power(Plus(a,Times(b,Power(x,Plus(q,Negate(p)))),Times(c,Power(x,Plus(r,Negate(p))))),n)),x),And(FreeQ(List(a,b,c,p,q,r),x),IntegerQ(n),PosQ(Plus(q,Negate(p))),PosQ(Plus(r,Negate(p)))))),
IIntegrate(1595,Int(Times(Sqrt(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),Plus(A_DEFAULT,Times(B_DEFAULT,x_)),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),CN1D2),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),CN1D2),Power(Plus(g_DEFAULT,Times(h_DEFAULT,x_)),CN1D2)),x_Symbol),
    Condition(Plus(Simp(Times(b,BSymbol,Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x))),Power(Times(d,f,h,Sqrt(Plus(a,Times(b,x)))),-1)),x),Negate(Dist(Times(BSymbol,Plus(Times(b,g),Times(CN1,a,h)),Power(Times(C2,f,h),-1)),Int(Times(Sqrt(Plus(e,Times(f,x))),Power(Times(Sqrt(Plus(a,Times(b,x))),Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(g,Times(h,x)))),-1)),x),x)),Dist(Times(BSymbol,Plus(Times(b,e),Times(CN1,a,f)),Plus(Times(b,g),Times(CN1,a,h)),Power(Times(C2,d,f,h),-1)),Int(Times(Sqrt(Plus(c,Times(d,x))),Power(Times(Power(Plus(a,Times(b,x)),QQ(3L,2L)),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x)))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f,g,h,ASymbol,BSymbol),x),EqQ(Plus(Times(C2,ASymbol,d,f),Times(CN1,BSymbol,Plus(Times(d,e),Times(c,f)))),C0)))),
IIntegrate(1596,Int(Times(Sqrt(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),Plus(A_DEFAULT,Times(B_DEFAULT,x_)),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),CN1D2),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),CN1D2),Power(Plus(g_DEFAULT,Times(h_DEFAULT,x_)),CN1D2)),x_Symbol),
    Condition(Plus(Simp(Times(BSymbol,Sqrt(Plus(a,Times(b,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x))),Power(Times(f,h,Sqrt(Plus(c,Times(d,x)))),-1)),x),Negate(Dist(Times(BSymbol,Plus(Times(b,e),Times(CN1,a,f)),Plus(Times(b,g),Times(CN1,a,h)),Power(Times(C2,b,f,h),-1)),Int(Power(Times(Sqrt(Plus(a,Times(b,x))),Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x)))),-1),x),x)),Dist(Times(BSymbol,Plus(Times(d,e),Times(CN1,c,f)),Plus(Times(d,g),Times(CN1,c,h)),Power(Times(C2,d,f,h),-1)),Int(Times(Sqrt(Plus(a,Times(b,x))),Power(Times(Power(Plus(c,Times(d,x)),QQ(3L,2L)),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x)))),-1)),x),x),Dist(Times(Plus(Times(C2,ASymbol,b,d,f,h),Times(BSymbol,Plus(Times(a,d,f,h),Times(CN1,b,Plus(Times(d,f,g),Times(d,e,h),Times(c,f,h)))))),Power(Times(C2,b,d,f,h),-1)),Int(Times(Sqrt(Plus(a,Times(b,x))),Power(Times(Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x)))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f,g,h,ASymbol,BSymbol),x),NeQ(Plus(Times(C2,ASymbol,d,f),Times(CN1,BSymbol,Plus(Times(d,e),Times(c,f)))),C0)))),
IIntegrate(1597,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_DEFAULT),Plus(A_DEFAULT,Times(B_DEFAULT,x_)),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),CN1D2),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),CN1D2),Power(Plus(g_DEFAULT,Times(h_DEFAULT,x_)),CN1D2)),x_Symbol),
    Condition(Dist(Power(Times(d,f,h,Plus(Times(C2,m),C3)),-1),Int(Times(Power(Plus(a,Times(b,x)),Plus(m,Negate(C1))),Power(Times(Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x)))),-1),Simp(Plus(Times(a,ASymbol,d,f,h,Plus(Times(C2,m),C3)),Times(Plus(Times(ASymbol,b),Times(a,BSymbol)),d,f,h,Plus(Times(C2,m),C3),x),Times(b,BSymbol,d,f,h,Plus(Times(C2,m),C3),Sqr(x))),x)),x),x),And(FreeQ(List(a,b,c,d,e,f,g,h,ASymbol,BSymbol),x),IntegerQ(Times(C2,m)),GtQ(m,C0)))),
IIntegrate(1598,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),CN1D2),Plus(A_DEFAULT,Times(B_DEFAULT,x_)),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),CN1D2),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),CN1D2),Power(Plus(g_DEFAULT,Times(h_DEFAULT,x_)),CN1D2)),x_Symbol),
    Condition(Plus(Dist(Times(Plus(Times(ASymbol,b),Times(CN1,a,BSymbol)),Power(b,-1)),Int(Power(Times(Sqrt(Plus(a,Times(b,x))),Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x)))),-1),x),x),Dist(Times(BSymbol,Power(b,-1)),Int(Times(Sqrt(Plus(a,Times(b,x))),Power(Times(Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x)))),-1)),x),x)),FreeQ(List(a,b,c,d,e,f,g,h,ASymbol,BSymbol),x))),
IIntegrate(1599,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_),Plus(A_DEFAULT,Times(B_DEFAULT,x_)),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),CN1D2),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),CN1D2),Power(Plus(g_DEFAULT,Times(h_DEFAULT,x_)),CN1D2)),x_Symbol),
    Condition(Plus(Simp(Times(Plus(Times(ASymbol,Sqr(b)),Times(CN1,a,b,BSymbol)),Power(Plus(a,Times(b,x)),Plus(m,C1)),Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x))),Power(Times(Plus(m,C1),Plus(Times(b,c),Times(CN1,a,d)),Plus(Times(b,e),Times(CN1,a,f)),Plus(Times(b,g),Times(CN1,a,h))),-1)),x),Negate(Dist(Power(Times(C2,Plus(m,C1),Plus(Times(b,c),Times(CN1,a,d)),Plus(Times(b,e),Times(CN1,a,f)),Plus(Times(b,g),Times(CN1,a,h))),-1),Int(Times(Power(Plus(a,Times(b,x)),Plus(m,C1)),Power(Times(Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x)))),-1),Simp(Plus(Times(ASymbol,Plus(Times(C2,Sqr(a),d,f,h,Plus(m,C1)),Times(CN1,C2,a,b,Plus(m,C1),Plus(Times(d,f,g),Times(d,e,h),Times(c,f,h))),Times(Sqr(b),Plus(Times(C2,m),C3),Plus(Times(d,e,g),Times(c,f,g),Times(c,e,h))))),Times(CN1,b,BSymbol,Plus(Times(a,Plus(Times(d,e,g),Times(c,f,g),Times(c,e,h))),Times(C2,b,c,e,g,Plus(m,C1)))),Times(CN1,C2,Plus(Times(ASymbol,b),Times(CN1,a,BSymbol)),Plus(Times(a,d,f,h,Plus(m,C1)),Times(CN1,b,Plus(m,C2),Plus(Times(d,f,g),Times(d,e,h),Times(c,f,h)))),x),Times(d,f,h,Plus(Times(C2,m),C5),Plus(Times(ASymbol,Sqr(b)),Times(CN1,a,b,BSymbol)),Sqr(x))),x)),x),x))),And(FreeQ(List(a,b,c,d,e,f,g,h,ASymbol,BSymbol),x),IntegerQ(Times(C2,m)),LtQ(m,CN1)))),
IIntegrate(1600,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),CN1D2),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),CN1D2),Power(Plus(g_DEFAULT,Times(h_DEFAULT,x_)),CN1D2),Plus(A_DEFAULT,Times(B_DEFAULT,x_),Times(C_DEFAULT,Sqr(x_)))),x_Symbol),
    Condition(Plus(Simp(Times(C2,CSymbol,Power(Plus(a,Times(b,x)),m),Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x))),Power(Times(d,f,h,Plus(Times(C2,m),C3)),-1)),x),Dist(Power(Times(d,f,h,Plus(Times(C2,m),C3)),-1),Int(Times(Power(Plus(a,Times(b,x)),Plus(m,Negate(C1))),Power(Times(Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x)))),-1),Simp(Plus(Times(a,ASymbol,d,f,h,Plus(Times(C2,m),C3)),Times(CN1,CSymbol,Plus(Times(a,Plus(Times(d,e,g),Times(c,f,g),Times(c,e,h))),Times(C2,b,c,e,g,m))),Times(Plus(Times(Plus(Times(ASymbol,b),Times(a,BSymbol)),d,f,h,Plus(Times(C2,m),C3)),Times(CN1,CSymbol,Plus(Times(C2,a,Plus(Times(d,f,g),Times(d,e,h),Times(c,f,h))),Times(b,Plus(Times(C2,m),C1),Plus(Times(d,e,g),Times(c,f,g),Times(c,e,h)))))),x),Times(Plus(Times(b,BSymbol,d,f,h,Plus(Times(C2,m),C3)),Times(C2,CSymbol,Plus(Times(a,d,f,h,m),Times(CN1,b,Plus(m,C1),Plus(Times(d,f,g),Times(d,e,h),Times(c,f,h)))))),Sqr(x))),x)),x),x)),And(FreeQ(List(a,b,c,d,e,f,g,h,ASymbol,BSymbol,CSymbol),x),IntegerQ(Times(C2,m)),GtQ(m,C0))))
  );
}