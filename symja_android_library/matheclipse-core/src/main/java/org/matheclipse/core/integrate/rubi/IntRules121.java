package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcCoth;
import static org.matheclipse.core.expression.F.ArcTanh;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.MatchQ;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.PolyLog;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sqr;
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
import static org.matheclipse.core.expression.F.k;
import static org.matheclipse.core.expression.F.k_;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.u_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntHide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/** 
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class IntRules121 { 
  public static IAST RULES = List( 
IIntegrate(6051,Int(Times(ArcCoth(u_),Power(Plus(a_DEFAULT,Times(ArcCoth(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Dist(C1D2,Int(Times(Log(SimplifyIntegrand(Plus(C1,Power(u,-1)),x)),Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),p),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x),Negate(Dist(C1D2,Int(Times(Log(SimplifyIntegrand(Plus(C1,Negate(Power(u,-1))),x)),Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),p),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e),x),IGtQ(p,C0),EqQ(Plus(Times(Sqr(c),d),e),C0),EqQ(Plus(Sqr(u),Negate(Sqr(Plus(C1,Times(CN1,C2,Power(Plus(C1,Times(c,x)),-1)))))),C0)))),
IIntegrate(6052,Int(Times(ArcTanh(u_),Power(Plus(a_DEFAULT,Times(ArcTanh(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Dist(C1D2,Int(Times(Log(Plus(C1,u)),Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),p),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x),Negate(Dist(C1D2,Int(Times(Log(Plus(C1,Negate(u))),Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),p),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e),x),IGtQ(p,C0),EqQ(Plus(Times(Sqr(c),d),e),C0),EqQ(Plus(Sqr(u),Negate(Sqr(Plus(C1,Times(CN1,C2,Power(Plus(C1,Times(CN1,c,x)),-1)))))),C0)))),
IIntegrate(6053,Int(Times(ArcCoth(u_),Power(Plus(a_DEFAULT,Times(ArcCoth(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Dist(C1D2,Int(Times(Log(SimplifyIntegrand(Plus(C1,Power(u,-1)),x)),Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),p),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x),Negate(Dist(C1D2,Int(Times(Log(SimplifyIntegrand(Plus(C1,Negate(Power(u,-1))),x)),Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),p),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e),x),IGtQ(p,C0),EqQ(Plus(Times(Sqr(c),d),e),C0),EqQ(Plus(Sqr(u),Negate(Sqr(Plus(C1,Times(CN1,C2,Power(Plus(C1,Times(CN1,c,x)),-1)))))),C0)))),
IIntegrate(6054,Int(Times(Log(Plus(f_,Times(g_DEFAULT,x_))),Power(Plus(a_DEFAULT,Times(ArcTanh(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),Plus(p,C1)),Log(Plus(f,Times(g,x))),Power(Times(b,c,d,Plus(p,C1)),-1)),x),Negate(Dist(Times(g,Power(Times(b,c,d,Plus(p,C1)),-1)),Int(Times(Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),Plus(p,C1)),Power(Plus(f,Times(g,x)),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f,g),x),IGtQ(p,C0),EqQ(Plus(Times(Sqr(c),d),e),C0),EqQ(Plus(Times(Sqr(c),Sqr(f)),Negate(Sqr(g))),C0)))),
IIntegrate(6055,Int(Times(Log(Plus(f_,Times(g_DEFAULT,x_))),Power(Plus(a_DEFAULT,Times(ArcCoth(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),Plus(p,C1)),Log(Plus(f,Times(g,x))),Power(Times(b,c,d,Plus(p,C1)),-1)),x),Negate(Dist(Times(g,Power(Times(b,c,d,Plus(p,C1)),-1)),Int(Times(Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),Plus(p,C1)),Power(Plus(f,Times(g,x)),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f,g),x),IGtQ(p,C0),EqQ(Plus(Times(Sqr(c),d),e),C0),EqQ(Plus(Times(Sqr(c),Sqr(f)),Negate(Sqr(g))),C0)))),
IIntegrate(6056,Int(Times(Log(u_),Power(Plus(a_DEFAULT,Times(ArcTanh(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),p),PolyLog(C2,Plus(C1,Negate(u))),Power(Times(C2,c,d),-1)),x),Negate(Dist(Times(C1D2,b,p),Int(Times(Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),Plus(p,Negate(C1))),PolyLog(C2,Plus(C1,Negate(u))),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e),x),IGtQ(p,C0),EqQ(Plus(Times(Sqr(c),d),e),C0),EqQ(Plus(Sqr(Plus(C1,Negate(u))),Negate(Sqr(Plus(C1,Times(CN1,C2,Power(Plus(C1,Times(c,x)),-1)))))),C0)))),
IIntegrate(6057,Int(Times(Log(u_),Power(Plus(a_DEFAULT,Times(ArcCoth(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),p),PolyLog(C2,Plus(C1,Negate(u))),Power(Times(C2,c,d),-1)),x),Negate(Dist(Times(C1D2,b,p),Int(Times(Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),Plus(p,Negate(C1))),PolyLog(C2,Plus(C1,Negate(u))),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e),x),IGtQ(p,C0),EqQ(Plus(Times(Sqr(c),d),e),C0),EqQ(Plus(Sqr(Plus(C1,Negate(u))),Negate(Sqr(Plus(C1,Times(CN1,C2,Power(Plus(C1,Times(c,x)),-1)))))),C0)))),
IIntegrate(6058,Int(Times(Log(u_),Power(Plus(a_DEFAULT,Times(ArcTanh(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),p),PolyLog(C2,Plus(C1,Negate(u))),Power(Times(C2,c,d),-1)),x)),Dist(Times(C1D2,b,p),Int(Times(Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),Plus(p,Negate(C1))),PolyLog(C2,Plus(C1,Negate(u))),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e),x),IGtQ(p,C0),EqQ(Plus(Times(Sqr(c),d),e),C0),EqQ(Plus(Sqr(Plus(C1,Negate(u))),Negate(Sqr(Plus(C1,Times(CN1,C2,Power(Plus(C1,Times(CN1,c,x)),-1)))))),C0)))),
IIntegrate(6059,Int(Times(Log(u_),Power(Plus(a_DEFAULT,Times(ArcCoth(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),p),PolyLog(C2,Plus(C1,Negate(u))),Power(Times(C2,c,d),-1)),x)),Dist(Times(C1D2,b,p),Int(Times(Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),Plus(p,Negate(C1))),PolyLog(C2,Plus(C1,Negate(u))),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e),x),IGtQ(p,C0),EqQ(Plus(Times(Sqr(c),d),e),C0),EqQ(Plus(Sqr(Plus(C1,Negate(u))),Negate(Sqr(Plus(C1,Times(CN1,C2,Power(Plus(C1,Times(CN1,c,x)),-1)))))),C0)))),
IIntegrate(6060,Int(Times(Power(Plus(a_DEFAULT,Times(ArcTanh(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),PolyLog(k_,u_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),p),PolyLog(Plus(k,C1),u),Power(Times(C2,c,d),-1)),x)),Dist(Times(C1D2,b,p),Int(Times(Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),Plus(p,Negate(C1))),PolyLog(Plus(k,C1),u),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,k),x),IGtQ(p,C0),EqQ(Plus(Times(Sqr(c),d),e),C0),EqQ(Plus(Sqr(u),Negate(Sqr(Plus(C1,Times(CN1,C2,Power(Plus(C1,Times(c,x)),-1)))))),C0)))),
IIntegrate(6061,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCoth(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),PolyLog(k_,u_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),p),PolyLog(Plus(k,C1),u),Power(Times(C2,c,d),-1)),x)),Dist(Times(C1D2,b,p),Int(Times(Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),Plus(p,Negate(C1))),PolyLog(Plus(k,C1),u),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,k),x),IGtQ(p,C0),EqQ(Plus(Times(Sqr(c),d),e),C0),EqQ(Plus(Sqr(u),Negate(Sqr(Plus(C1,Times(CN1,C2,Power(Plus(C1,Times(c,x)),-1)))))),C0)))),
IIntegrate(6062,Int(Times(Power(Plus(a_DEFAULT,Times(ArcTanh(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),PolyLog(k_,u_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),p),PolyLog(Plus(k,C1),u),Power(Times(C2,c,d),-1)),x),Negate(Dist(Times(C1D2,b,p),Int(Times(Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),Plus(p,Negate(C1))),PolyLog(Plus(k,C1),u),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,k),x),IGtQ(p,C0),EqQ(Plus(Times(Sqr(c),d),e),C0),EqQ(Plus(Sqr(u),Negate(Sqr(Plus(C1,Times(CN1,C2,Power(Plus(C1,Times(CN1,c,x)),-1)))))),C0)))),
IIntegrate(6063,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCoth(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),PolyLog(k_,u_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),p),PolyLog(Plus(k,C1),u),Power(Times(C2,c,d),-1)),x),Negate(Dist(Times(C1D2,b,p),Int(Times(Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),Plus(p,Negate(C1))),PolyLog(Plus(k,C1),u),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,k),x),IGtQ(p,C0),EqQ(Plus(Times(Sqr(c),d),e),C0),EqQ(Plus(Sqr(u),Negate(Sqr(Plus(C1,Times(CN1,C2,Power(Plus(C1,Times(CN1,c,x)),-1)))))),C0)))),
IIntegrate(6064,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCoth(Times(c_DEFAULT,x_)),b_DEFAULT)),-1),Power(Plus(a_DEFAULT,Times(ArcTanh(Times(c_DEFAULT,x_)),b_DEFAULT)),-1),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Simp(Times(Plus(Negate(Log(Plus(a,Times(b,ArcCoth(Times(c,x)))))),Log(Plus(a,Times(b,ArcTanh(Times(c,x)))))),Power(Times(Sqr(b),c,d,Plus(ArcCoth(Times(c,x)),Negate(ArcTanh(Times(c,x))))),-1)),x),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0)))),
IIntegrate(6065,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCoth(Times(c_DEFAULT,x_)),b_DEFAULT)),m_DEFAULT),Power(Plus(a_DEFAULT,Times(ArcTanh(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),Plus(m,C1)),Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),p),Power(Times(b,c,d,Plus(m,C1)),-1)),x),Negate(Dist(Times(p,Power(Plus(m,C1),-1)),Int(Times(Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),Plus(m,C1)),Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),Plus(p,Negate(C1))),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(p,C0),IGeQ(m,p)))),
IIntegrate(6066,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCoth(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),Power(Plus(a_DEFAULT,Times(ArcTanh(Times(c_DEFAULT,x_)),b_DEFAULT)),m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),Plus(m,C1)),Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),p),Power(Times(b,c,d,Plus(m,C1)),-1)),x),Negate(Dist(Times(p,Power(Plus(m,C1),-1)),Int(Times(Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),Plus(m,C1)),Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),Plus(p,Negate(C1))),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(p,C0),IGtQ(m,p)))),
IIntegrate(6067,Int(Times(ArcTanh(Times(a_DEFAULT,x_)),Power(Plus(c_,Times(d_DEFAULT,Power(x_,n_DEFAULT))),-1)),x_Symbol),
    Condition(Plus(Dist(C1D2,Int(Times(Log(Plus(C1,Times(a,x))),Power(Plus(c,Times(d,Power(x,n))),-1)),x),x),Negate(Dist(C1D2,Int(Times(Log(Plus(C1,Times(CN1,a,x))),Power(Plus(c,Times(d,Power(x,n))),-1)),x),x))),And(FreeQ(List(a,c,d),x),IntegerQ(n),Not(And(EqQ(n,C2),EqQ(Plus(Times(Sqr(a),c),d),C0)))))),
IIntegrate(6068,Int(Times(ArcCoth(Times(a_DEFAULT,x_)),Power(Plus(c_,Times(d_DEFAULT,Power(x_,n_DEFAULT))),-1)),x_Symbol),
    Condition(Plus(Dist(C1D2,Int(Times(Log(Plus(C1,Power(Times(a,x),-1))),Power(Plus(c,Times(d,Power(x,n))),-1)),x),x),Negate(Dist(C1D2,Int(Times(Log(Plus(C1,Negate(Power(Times(a,x),-1)))),Power(Plus(c,Times(d,Power(x,n))),-1)),x),x))),And(FreeQ(List(a,c,d),x),IntegerQ(n),Not(And(EqQ(n,C2),EqQ(Plus(Times(Sqr(a),c),d),C0)))))),
IIntegrate(6069,Int(Times(ArcTanh(Times(c_DEFAULT,Power(x_,n_DEFAULT))),Log(Times(d_DEFAULT,Power(x_,m_DEFAULT))),Power(x_,-1)),x_Symbol),
    Condition(Plus(Dist(C1D2,Int(Times(Log(Times(d,Power(x,m))),Log(Plus(C1,Times(c,Power(x,n)))),Power(x,-1)),x),x),Negate(Dist(C1D2,Int(Times(Log(Times(d,Power(x,m))),Log(Plus(C1,Times(CN1,c,Power(x,n)))),Power(x,-1)),x),x))),FreeQ(List(c,d,m,n),x))),
IIntegrate(6070,Int(Times(ArcCoth(Times(c_DEFAULT,Power(x_,n_DEFAULT))),Log(Times(d_DEFAULT,Power(x_,m_DEFAULT))),Power(x_,-1)),x_Symbol),
    Condition(Plus(Dist(C1D2,Int(Times(Log(Times(d,Power(x,m))),Log(Plus(C1,Power(Times(c,Power(x,n)),-1))),Power(x,-1)),x),x),Negate(Dist(C1D2,Int(Times(Log(Times(d,Power(x,m))),Log(Plus(C1,Negate(Power(Times(c,Power(x,n)),-1)))),Power(x,-1)),x),x))),FreeQ(List(c,d,m,n),x))),
IIntegrate(6071,Int(Times(Log(Times(d_DEFAULT,Power(x_,m_DEFAULT))),Plus(Times(ArcTanh(Times(c_DEFAULT,Power(x_,n_DEFAULT))),b_DEFAULT),a_),Power(x_,-1)),x_Symbol),
    Condition(Plus(Dist(a,Int(Times(Log(Times(d,Power(x,m))),Power(x,-1)),x),x),Dist(b,Int(Times(Log(Times(d,Power(x,m))),ArcTanh(Times(c,Power(x,n))),Power(x,-1)),x),x)),FreeQ(List(a,b,c,d,m,n),x))),
IIntegrate(6072,Int(Times(Log(Times(d_DEFAULT,Power(x_,m_DEFAULT))),Plus(Times(ArcCoth(Times(c_DEFAULT,Power(x_,n_DEFAULT))),b_DEFAULT),a_),Power(x_,-1)),x_Symbol),
    Condition(Plus(Dist(a,Int(Times(Log(Times(d,Power(x,m))),Power(x,-1)),x),x),Dist(b,Int(Times(Log(Times(d,Power(x,m))),ArcCoth(Times(c,Power(x,n))),Power(x,-1)),x),x)),FreeQ(List(a,b,c,d,m,n),x))),
IIntegrate(6073,Int(Times(Plus(a_DEFAULT,Times(ArcTanh(Times(c_DEFAULT,x_)),b_DEFAULT)),Plus(d_DEFAULT,Times(Log(Plus(f_DEFAULT,Times(g_DEFAULT,Sqr(x_)))),e_DEFAULT))),x_Symbol),
    Condition(Plus(Simp(Times(x,Plus(d,Times(e,Log(Plus(f,Times(g,Sqr(x)))))),Plus(a,Times(b,ArcTanh(Times(c,x))))),x),Negate(Dist(Times(b,c),Int(Times(x,Plus(d,Times(e,Log(Plus(f,Times(g,Sqr(x)))))),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),-1)),x),x)),Negate(Dist(Times(C2,e,g),Int(Times(Sqr(x),Plus(a,Times(b,ArcTanh(Times(c,x)))),Power(Plus(f,Times(g,Sqr(x))),-1)),x),x))),FreeQ(List(a,b,c,d,e,f,g),x))),
IIntegrate(6074,Int(Times(Plus(a_DEFAULT,Times(ArcCoth(Times(c_DEFAULT,x_)),b_DEFAULT)),Plus(d_DEFAULT,Times(Log(Plus(f_DEFAULT,Times(g_DEFAULT,Sqr(x_)))),e_DEFAULT))),x_Symbol),
    Condition(Plus(Simp(Times(x,Plus(d,Times(e,Log(Plus(f,Times(g,Sqr(x)))))),Plus(a,Times(b,ArcCoth(Times(c,x))))),x),Negate(Dist(Times(b,c),Int(Times(x,Plus(d,Times(e,Log(Plus(f,Times(g,Sqr(x)))))),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),-1)),x),x)),Negate(Dist(Times(C2,e,g),Int(Times(Sqr(x),Plus(a,Times(b,ArcCoth(Times(c,x)))),Power(Plus(f,Times(g,Sqr(x))),-1)),x),x))),FreeQ(List(a,b,c,d,e,f,g),x))),
IIntegrate(6075,Int(Times(ArcTanh(Times(c_DEFAULT,x_)),Log(Plus(f_DEFAULT,Times(g_DEFAULT,Sqr(x_)))),Power(x_,-1)),x_Symbol),
    Condition(Plus(Dist(Plus(Log(Plus(f,Times(g,Sqr(x)))),Negate(Log(Plus(C1,Times(CN1,c,x)))),Negate(Log(Plus(C1,Times(c,x))))),Int(Times(ArcTanh(Times(c,x)),Power(x,-1)),x),x),Negate(Dist(C1D2,Int(Times(Sqr(Log(Plus(C1,Times(CN1,c,x)))),Power(x,-1)),x),x)),Dist(C1D2,Int(Times(Sqr(Log(Plus(C1,Times(c,x)))),Power(x,-1)),x),x)),And(FreeQ(List(c,f,g),x),EqQ(Plus(Times(Sqr(c),f),g),C0)))),
IIntegrate(6076,Int(Times(ArcCoth(Times(c_DEFAULT,x_)),Log(Plus(f_DEFAULT,Times(g_DEFAULT,Sqr(x_)))),Power(x_,-1)),x_Symbol),
    Condition(Plus(Dist(Plus(Log(Plus(f,Times(g,Sqr(x)))),Negate(Log(Times(CN1,Sqr(c),Sqr(x)))),Negate(Log(Plus(C1,Negate(Power(Times(c,x),-1))))),Negate(Log(Plus(C1,Power(Times(c,x),-1))))),Int(Times(ArcCoth(Times(c,x)),Power(x,-1)),x),x),Negate(Dist(C1D2,Int(Times(Sqr(Log(Plus(C1,Negate(Power(Times(c,x),-1))))),Power(x,-1)),x),x)),Dist(C1D2,Int(Times(Sqr(Log(Plus(C1,Power(Times(c,x),-1)))),Power(x,-1)),x),x),Int(Times(Log(Times(CN1,Sqr(c),Sqr(x))),ArcCoth(Times(c,x)),Power(x,-1)),x)),And(FreeQ(List(c,f,g),x),EqQ(Plus(Times(Sqr(c),f),g),C0)))),
IIntegrate(6077,Int(Times(Log(Plus(f_DEFAULT,Times(g_DEFAULT,Sqr(x_)))),Plus(Times(ArcTanh(Times(c_DEFAULT,x_)),b_DEFAULT),a_),Power(x_,-1)),x_Symbol),
    Condition(Plus(Dist(a,Int(Times(Log(Plus(f,Times(g,Sqr(x)))),Power(x,-1)),x),x),Dist(b,Int(Times(Log(Plus(f,Times(g,Sqr(x)))),ArcTanh(Times(c,x)),Power(x,-1)),x),x)),FreeQ(List(a,b,c,f,g),x))),
IIntegrate(6078,Int(Times(Log(Plus(f_DEFAULT,Times(g_DEFAULT,Sqr(x_)))),Plus(Times(ArcCoth(Times(c_DEFAULT,x_)),b_DEFAULT),a_),Power(x_,-1)),x_Symbol),
    Condition(Plus(Dist(a,Int(Times(Log(Plus(f,Times(g,Sqr(x)))),Power(x,-1)),x),x),Dist(b,Int(Times(Log(Plus(f,Times(g,Sqr(x)))),ArcCoth(Times(c,x)),Power(x,-1)),x),x)),FreeQ(List(a,b,c,f,g),x))),
IIntegrate(6079,Int(Times(Plus(a_DEFAULT,Times(ArcTanh(Times(c_DEFAULT,x_)),b_DEFAULT)),Plus(Times(Log(Plus(f_DEFAULT,Times(g_DEFAULT,Sqr(x_)))),e_DEFAULT),d_),Power(x_,-1)),x_Symbol),
    Condition(Plus(Dist(d,Int(Times(Plus(a,Times(b,ArcTanh(Times(c,x)))),Power(x,-1)),x),x),Dist(e,Int(Times(Log(Plus(f,Times(g,Sqr(x)))),Plus(a,Times(b,ArcTanh(Times(c,x)))),Power(x,-1)),x),x)),FreeQ(List(a,b,c,d,e,f,g),x))),
IIntegrate(6080,Int(Times(Plus(a_DEFAULT,Times(ArcCoth(Times(c_DEFAULT,x_)),b_DEFAULT)),Plus(Times(Log(Plus(f_DEFAULT,Times(g_DEFAULT,Sqr(x_)))),e_DEFAULT),d_),Power(x_,-1)),x_Symbol),
    Condition(Plus(Dist(d,Int(Times(Plus(a,Times(b,ArcCoth(Times(c,x)))),Power(x,-1)),x),x),Dist(e,Int(Times(Log(Plus(f,Times(g,Sqr(x)))),Plus(a,Times(b,ArcCoth(Times(c,x)))),Power(x,-1)),x),x)),FreeQ(List(a,b,c,d,e,f,g),x))),
IIntegrate(6081,Int(Times(Plus(a_DEFAULT,Times(ArcTanh(Times(c_DEFAULT,x_)),b_DEFAULT)),Plus(d_DEFAULT,Times(Log(Plus(f_DEFAULT,Times(g_DEFAULT,Sqr(x_)))),e_DEFAULT)),Power(x_,m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(x,Plus(m,C1)),Plus(d,Times(e,Log(Plus(f,Times(g,Sqr(x)))))),Plus(a,Times(b,ArcTanh(Times(c,x)))),Power(Plus(m,C1),-1)),x),Negate(Dist(Times(b,c,Power(Plus(m,C1),-1)),Int(Times(Power(x,Plus(m,C1)),Plus(d,Times(e,Log(Plus(f,Times(g,Sqr(x)))))),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),-1)),x),x)),Negate(Dist(Times(C2,e,g,Power(Plus(m,C1),-1)),Int(Times(Power(x,Plus(m,C2)),Plus(a,Times(b,ArcTanh(Times(c,x)))),Power(Plus(f,Times(g,Sqr(x))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f,g),x),ILtQ(Times(C1D2,m),C0)))),
IIntegrate(6082,Int(Times(Plus(a_DEFAULT,Times(ArcCoth(Times(c_DEFAULT,x_)),b_DEFAULT)),Plus(d_DEFAULT,Times(Log(Plus(f_DEFAULT,Times(g_DEFAULT,Sqr(x_)))),e_DEFAULT)),Power(x_,m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(x,Plus(m,C1)),Plus(d,Times(e,Log(Plus(f,Times(g,Sqr(x)))))),Plus(a,Times(b,ArcCoth(Times(c,x)))),Power(Plus(m,C1),-1)),x),Negate(Dist(Times(b,c,Power(Plus(m,C1),-1)),Int(Times(Power(x,Plus(m,C1)),Plus(d,Times(e,Log(Plus(f,Times(g,Sqr(x)))))),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),-1)),x),x)),Negate(Dist(Times(C2,e,g,Power(Plus(m,C1),-1)),Int(Times(Power(x,Plus(m,C2)),Plus(a,Times(b,ArcCoth(Times(c,x)))),Power(Plus(f,Times(g,Sqr(x))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f,g),x),ILtQ(Times(C1D2,m),C0)))),
IIntegrate(6083,Int(Times(Plus(a_DEFAULT,Times(ArcTanh(Times(c_DEFAULT,x_)),b_DEFAULT)),Plus(d_DEFAULT,Times(Log(Plus(f_DEFAULT,Times(g_DEFAULT,Sqr(x_)))),e_DEFAULT)),Power(x_,m_DEFAULT)),x_Symbol),
    Condition(With(List(Set(u,IntHide(Times(Power(x,m),Plus(d,Times(e,Log(Plus(f,Times(g,Sqr(x))))))),x))),Plus(Dist(Plus(a,Times(b,ArcTanh(Times(c,x)))),u,x),Negate(Dist(Times(b,c),Int(ExpandIntegrand(Times(u,Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),-1)),x),x),x)))),And(FreeQ(List(a,b,c,d,e,f,g),x),IGtQ(Times(C1D2,Plus(m,C1)),C0)))),
IIntegrate(6084,Int(Times(Plus(a_DEFAULT,Times(ArcCoth(Times(c_DEFAULT,x_)),b_DEFAULT)),Plus(d_DEFAULT,Times(Log(Plus(f_DEFAULT,Times(g_DEFAULT,Sqr(x_)))),e_DEFAULT)),Power(x_,m_DEFAULT)),x_Symbol),
    Condition(With(List(Set(u,IntHide(Times(Power(x,m),Plus(d,Times(e,Log(Plus(f,Times(g,Sqr(x))))))),x))),Plus(Dist(Plus(a,Times(b,ArcCoth(Times(c,x)))),u,x),Negate(Dist(Times(b,c),Int(ExpandIntegrand(Times(u,Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),-1)),x),x),x)))),And(FreeQ(List(a,b,c,d,e,f,g),x),IGtQ(Times(C1D2,Plus(m,C1)),C0)))),
IIntegrate(6085,Int(Times(Plus(a_DEFAULT,Times(ArcTanh(Times(c_DEFAULT,x_)),b_DEFAULT)),Plus(d_DEFAULT,Times(Log(Plus(f_DEFAULT,Times(g_DEFAULT,Sqr(x_)))),e_DEFAULT)),Power(x_,m_DEFAULT)),x_Symbol),
    Condition(With(List(Set(u,IntHide(Times(Power(x,m),Plus(a,Times(b,ArcTanh(Times(c,x))))),x))),Plus(Dist(Plus(d,Times(e,Log(Plus(f,Times(g,Sqr(x)))))),u,x),Negate(Dist(Times(C2,e,g),Int(ExpandIntegrand(Times(x,u,Power(Plus(f,Times(g,Sqr(x))),-1)),x),x),x)))),And(FreeQ(List(a,b,c,d,e,f,g),x),IntegerQ(m),NeQ(m,CN1)))),
IIntegrate(6086,Int(Times(Plus(a_DEFAULT,Times(ArcCoth(Times(c_DEFAULT,x_)),b_DEFAULT)),Plus(d_DEFAULT,Times(Log(Plus(f_DEFAULT,Times(g_DEFAULT,Sqr(x_)))),e_DEFAULT)),Power(x_,m_DEFAULT)),x_Symbol),
    Condition(With(List(Set(u,IntHide(Times(Power(x,m),Plus(a,Times(b,ArcCoth(Times(c,x))))),x))),Plus(Dist(Plus(d,Times(e,Log(Plus(f,Times(g,Sqr(x)))))),u,x),Negate(Dist(Times(C2,e,g),Int(ExpandIntegrand(Times(x,u,Power(Plus(f,Times(g,Sqr(x))),-1)),x),x),x)))),And(FreeQ(List(a,b,c,d,e,f,g),x),IntegerQ(m),NeQ(m,CN1)))),
IIntegrate(6087,Int(Times(Sqr(Plus(a_DEFAULT,Times(ArcTanh(Times(c_DEFAULT,x_)),b_DEFAULT))),Plus(d_DEFAULT,Times(Log(Plus(f_,Times(g_DEFAULT,Sqr(x_)))),e_DEFAULT)),x_),x_Symbol),
    Condition(Plus(Simp(Times(Plus(f,Times(g,Sqr(x))),Plus(d,Times(e,Log(Plus(f,Times(g,Sqr(x)))))),Sqr(Plus(a,Times(b,ArcTanh(Times(c,x))))),Power(Times(C2,g),-1)),x),Dist(Times(b,Power(c,-1)),Int(Times(Plus(d,Times(e,Log(Plus(f,Times(g,Sqr(x)))))),Plus(a,Times(b,ArcTanh(Times(c,x))))),x),x),Dist(Times(b,c,e),Int(Times(Sqr(x),Plus(a,Times(b,ArcTanh(Times(c,x)))),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),-1)),x),x),Negate(Simp(Times(C1D2,e,Sqr(x),Sqr(Plus(a,Times(b,ArcTanh(Times(c,x)))))),x))),And(FreeQ(List(a,b,c,d,e,f,g),x),EqQ(Plus(Times(Sqr(c),f),g),C0)))),
IIntegrate(6088,Int(Times(Sqr(Plus(a_DEFAULT,Times(ArcCoth(Times(c_DEFAULT,x_)),b_DEFAULT))),Plus(d_DEFAULT,Times(Log(Plus(f_,Times(g_DEFAULT,Sqr(x_)))),e_DEFAULT)),x_),x_Symbol),
    Condition(Plus(Simp(Times(Plus(f,Times(g,Sqr(x))),Plus(d,Times(e,Log(Plus(f,Times(g,Sqr(x)))))),Sqr(Plus(a,Times(b,ArcCoth(Times(c,x))))),Power(Times(C2,g),-1)),x),Dist(Times(b,Power(c,-1)),Int(Times(Plus(d,Times(e,Log(Plus(f,Times(g,Sqr(x)))))),Plus(a,Times(b,ArcCoth(Times(c,x))))),x),x),Dist(Times(b,c,e),Int(Times(Sqr(x),Plus(a,Times(b,ArcCoth(Times(c,x)))),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),-1)),x),x),Negate(Simp(Times(C1D2,e,Sqr(x),Sqr(Plus(a,Times(b,ArcCoth(Times(c,x)))))),x))),And(FreeQ(List(a,b,c,d,e,f,g),x),EqQ(Plus(Times(Sqr(c),f),g),C0)))),
IIntegrate(6089,Int(Times(Power(Plus(a_DEFAULT,Times(ArcTanh(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),u_DEFAULT),x_Symbol),
    Condition(Unintegrable(Times(u,Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),p)),x),And(FreeQ(List(a,b,c,p),x),Or(EqQ(u,C1),MatchQ(u,Condition(Power(Plus(d_DEFAULT,Times(e_DEFAULT,x)),q_DEFAULT),FreeQ(List(d,e,q),x))),MatchQ(u,Condition(Times(Power(Times(f_DEFAULT,x),m_DEFAULT),Power(Plus(d_DEFAULT,Times(e_DEFAULT,x)),q_DEFAULT)),FreeQ(List(d,e,f,m,q),x))),MatchQ(u,Condition(Power(Plus(d_DEFAULT,Times(e_DEFAULT,Sqr(x))),q_DEFAULT),FreeQ(List(d,e,q),x))),MatchQ(u,Condition(Times(Power(Times(f_DEFAULT,x),m_DEFAULT),Power(Plus(d_DEFAULT,Times(e_DEFAULT,Sqr(x))),q_DEFAULT)),FreeQ(List(d,e,f,m,q),x))))))),
IIntegrate(6090,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCoth(Times(c_DEFAULT,x_)),b_DEFAULT)),p_DEFAULT),u_DEFAULT),x_Symbol),
    Condition(Unintegrable(Times(u,Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),p)),x),And(FreeQ(List(a,b,c,p),x),Or(EqQ(u,C1),MatchQ(u,Condition(Power(Plus(d_DEFAULT,Times(e_DEFAULT,x)),q_DEFAULT),FreeQ(List(d,e,q),x))),MatchQ(u,Condition(Times(Power(Times(f_DEFAULT,x),m_DEFAULT),Power(Plus(d_DEFAULT,Times(e_DEFAULT,x)),q_DEFAULT)),FreeQ(List(d,e,f,m,q),x))),MatchQ(u,Condition(Power(Plus(d_DEFAULT,Times(e_DEFAULT,Sqr(x))),q_DEFAULT),FreeQ(List(d,e,q),x))),MatchQ(u,Condition(Times(Power(Times(f_DEFAULT,x),m_DEFAULT),Power(Plus(d_DEFAULT,Times(e_DEFAULT,Sqr(x))),q_DEFAULT)),FreeQ(List(d,e,f,m,q),x))))))),
IIntegrate(6091,Int(ArcTanh(Times(c_DEFAULT,Power(x_,n_))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcTanh(Times(c,Power(x,n)))),x),Negate(Dist(Times(c,n),Int(Times(Power(x,n),Power(Plus(C1,Times(CN1,Sqr(c),Power(x,Times(C2,n)))),-1)),x),x))),FreeQ(List(c,n),x))),
IIntegrate(6092,Int(ArcCoth(Times(c_DEFAULT,Power(x_,n_))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcCoth(Times(c,Power(x,n)))),x),Negate(Dist(Times(c,n),Int(Times(Power(x,n),Power(Plus(C1,Times(CN1,Sqr(c),Power(x,Times(C2,n)))),-1)),x),x))),FreeQ(List(c,n),x))),
IIntegrate(6093,Int(Power(Plus(a_DEFAULT,Times(ArcTanh(Times(c_DEFAULT,Power(x_,n_))),b_DEFAULT)),p_DEFAULT),x_Symbol),
    Condition(Int(ExpandIntegrand(Power(Plus(a,Times(C1D2,b,Log(Plus(C1,Times(c,Power(x,n))))),Times(CN1,C1D2,b,Log(Plus(C1,Times(CN1,c,Power(x,n)))))),p),x),x),And(FreeQ(List(a,b,c,n),x),IGtQ(p,C0),IntegerQ(n)))),
IIntegrate(6094,Int(Power(Plus(a_DEFAULT,Times(ArcCoth(Times(c_DEFAULT,Power(x_,n_))),b_DEFAULT)),p_DEFAULT),x_Symbol),
    Condition(Int(ExpandIntegrand(Power(Plus(a,Times(C1D2,b,Log(Plus(C1,Power(Times(Power(x,n),c),-1)))),Times(CN1,C1D2,b,Log(Plus(C1,Negate(Power(Times(Power(x,n),c),-1)))))),p),x),x),And(FreeQ(List(a,b,c,n),x),IGtQ(p,C0),IntegerQ(n)))),
IIntegrate(6095,Int(Times(Power(Plus(a_DEFAULT,Times(ArcTanh(Times(c_DEFAULT,Power(x_,n_))),b_DEFAULT)),p_DEFAULT),Power(x_,-1)),x_Symbol),
    Condition(Dist(Power(n,-1),Subst(Int(Times(Power(Plus(a,Times(b,ArcTanh(Times(c,x)))),p),Power(x,-1)),x),x,Power(x,n)),x),And(FreeQ(List(a,b,c,n),x),IGtQ(p,C0)))),
IIntegrate(6096,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCoth(Times(c_DEFAULT,Power(x_,n_))),b_DEFAULT)),p_DEFAULT),Power(x_,-1)),x_Symbol),
    Condition(Dist(Power(n,-1),Subst(Int(Times(Power(Plus(a,Times(b,ArcCoth(Times(c,x)))),p),Power(x,-1)),x),x,Power(x,n)),x),And(FreeQ(List(a,b,c,n),x),IGtQ(p,C0)))),
IIntegrate(6097,Int(Times(Plus(a_DEFAULT,Times(ArcTanh(Times(c_DEFAULT,Power(x_,n_))),b_DEFAULT)),Power(Times(d_DEFAULT,x_),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(d,x),Plus(m,C1)),Plus(a,Times(b,ArcTanh(Times(c,Power(x,n))))),Power(Times(d,Plus(m,C1)),-1)),x),Negate(Dist(Times(b,c,n,Power(Times(d,Plus(m,C1)),-1)),Int(Times(Power(x,Plus(n,Negate(C1))),Power(Times(d,x),Plus(m,C1)),Power(Plus(C1,Times(CN1,Sqr(c),Power(x,Times(C2,n)))),-1)),x),x))),And(FreeQ(List(a,b,c,d,m,n),x),NeQ(m,CN1)))),
IIntegrate(6098,Int(Times(Plus(a_DEFAULT,Times(ArcCoth(Times(c_DEFAULT,Power(x_,n_))),b_DEFAULT)),Power(Times(d_DEFAULT,x_),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(d,x),Plus(m,C1)),Plus(a,Times(b,ArcCoth(Times(c,Power(x,n))))),Power(Times(d,Plus(m,C1)),-1)),x),Negate(Dist(Times(b,c,n,Power(Times(d,Plus(m,C1)),-1)),Int(Times(Power(x,Plus(n,Negate(C1))),Power(Times(d,x),Plus(m,C1)),Power(Plus(C1,Times(CN1,Sqr(c),Power(x,Times(C2,n)))),-1)),x),x))),And(FreeQ(List(a,b,c,d,m,n),x),NeQ(m,CN1)))),
IIntegrate(6099,Int(Times(Power(Plus(a_DEFAULT,Times(ArcTanh(Times(c_DEFAULT,Power(x_,n_))),b_DEFAULT)),p_DEFAULT),Power(Times(d_DEFAULT,x_),m_DEFAULT)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times(Power(Times(d,x),m),Power(Plus(a,Times(C1D2,b,Log(Plus(C1,Times(c,Power(x,n))))),Times(CN1,C1D2,b,Log(Plus(C1,Times(CN1,c,Power(x,n)))))),p)),x),x),And(FreeQ(List(a,b,c,d,m,n),x),IGtQ(p,C0),IntegerQ(m),IntegerQ(n)))),
IIntegrate(6100,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCoth(Times(c_DEFAULT,Power(x_,n_))),b_DEFAULT)),p_DEFAULT),Power(Times(d_DEFAULT,x_),m_DEFAULT)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times(Power(Times(d,x),m),Power(Plus(a,Times(C1D2,b,Log(Plus(C1,Power(Times(Power(x,n),c),-1)))),Times(CN1,C1D2,b,Log(Plus(C1,Negate(Power(Times(Power(x,n),c),-1)))))),p)),x),x),And(FreeQ(List(a,b,c,d,m,n),x),IGtQ(p,C0),IntegerQ(m),IntegerQ(n))))
  );
}
