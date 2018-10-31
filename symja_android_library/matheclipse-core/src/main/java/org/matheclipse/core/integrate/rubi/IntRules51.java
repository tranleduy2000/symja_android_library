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
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.Cancel;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Csc;
import static org.matheclipse.core.expression.F.D;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.Gamma;
import static org.matheclipse.core.expression.F.Hypergeometric2F1;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.LogGamma;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Part;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.QQ;
import static org.matheclipse.core.expression.F.Sec;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Simplify;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Tan;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_DEFAULT;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.k;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.r;
import static org.matheclipse.core.expression.F.r_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.u_DEFAULT;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.w;
import static org.matheclipse.core.expression.F.w_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.expression.F.z;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.DeactivateTrig;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FalseQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FreeFactors;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfLog;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfTrigOfLinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntHide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InverseFunctionFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NonsumQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ProductQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.QuadraticQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/** 
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class IntRules51 { 
  public static IAST RULES = List( 
IIntegrate(2551,Int(Times(Log(u_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(a,Times(b,x)),Plus(m,C1)),Log(u),Power(Times(b,Plus(m,C1)),-1)),x),Negate(Dist(Power(Times(b,Plus(m,C1)),-1),Int(SimplifyIntegrand(Times(Power(Plus(a,Times(b,x)),Plus(m,C1)),D(u,x),Power(u,-1)),x),x),x))),And(FreeQ(List(a,b,m),x),InverseFunctionFreeQ(u,x),NeQ(m,CN1)))),
IIntegrate(2552,Int(Times(Log(u_),Power($p("§qx"),-1)),x_Symbol),
    Condition(With(List(Set(v,IntHide(Power($s("§qx"),-1),x))),Plus(Simp(Times(v,Log(u)),x),Negate(Int(SimplifyIntegrand(Times(v,D(u,x),Power(u,-1)),x),x)))),And(QuadraticQ($s("§qx"),x),InverseFunctionFreeQ(u,x)))),
IIntegrate(2553,Int(Times(Log(u_),Power(u_,Times(a_DEFAULT,x_))),x_Symbol),
    Condition(Plus(Simp(Times(Power(u,Times(a,x)),Power(a,-1)),x),Negate(Int(SimplifyIntegrand(Times(x,Power(u,Plus(Times(a,x),Negate(C1))),D(u,x)),x),x))),And(FreeQ(a,x),InverseFunctionFreeQ(u,x)))),
IIntegrate(2554,Int(Times(Log(u_),v_),x_Symbol),
    Condition(With(List(Set(w,IntHide(v,x))),Condition(Plus(Dist(Log(u),w,x),Negate(Int(SimplifyIntegrand(Times(w,D(u,x),Power(u,-1)),x),x))),InverseFunctionFreeQ(w,x))),InverseFunctionFreeQ(u,x))),
IIntegrate(2555,Int(Times(Log(u_),v_),x_Symbol),
    Condition(With(List(Set(w,IntHide(v,x))),Condition(Plus(Dist(Log(u),w,x),Negate(Int(SimplifyIntegrand(Times(w,Simplify(Times(D(u,x),Power(u,-1)))),x),x))),InverseFunctionFreeQ(w,x))),ProductQ(u))),
IIntegrate(2556,Int(Times(Log(v_),Log(w_)),x_Symbol),
    Condition(Plus(Simp(Times(x,Log(v),Log(w)),x),Negate(Int(SimplifyIntegrand(Times(x,Log(w),D(v,x),Power(v,-1)),x),x)),Negate(Int(SimplifyIntegrand(Times(x,Log(v),D(w,x),Power(w,-1)),x),x))),And(InverseFunctionFreeQ(v,x),InverseFunctionFreeQ(w,x)))),
IIntegrate(2557,Int(Times(Log(v_),Log(w_),u_),x_Symbol),
    Condition(With(List(Set(z,IntHide(u,x))),Condition(Plus(Dist(Times(Log(v),Log(w)),z,x),Negate(Int(SimplifyIntegrand(Times(z,Log(w),D(v,x),Power(v,-1)),x),x)),Negate(Int(SimplifyIntegrand(Times(z,Log(v),D(w,x),Power(w,-1)),x),x))),InverseFunctionFreeQ(z,x))),And(InverseFunctionFreeQ(v,x),InverseFunctionFreeQ(w,x)))),
IIntegrate(2558,Int(Power(f_,Times(Log(u_),a_DEFAULT)),x_Symbol),
    Condition(Int(Power(u,Times(a,Log(f))),x),FreeQ(List(a,f),x))),
IIntegrate(2559,Int(u_,x_Symbol),
    Condition(With(List(Set($s("lst"),FunctionOfLog(Cancel(Times(x,u)),x))),Condition(Dist(Power(Part($s("lst"),C3),-1),Subst(Int(Part($s("lst"),C1),x),x,Log(Part($s("lst"),C2))),x),Not(FalseQ($s("lst"))))),NonsumQ(u))),
IIntegrate(2560,Int(Times(Log(Gamma(v_)),u_DEFAULT),x_Symbol),
    Plus(Dist(Plus(Log(Gamma(v)),Negate(LogGamma(v))),Int(u,x),x),Int(Times(u,LogGamma(v)),x))),
IIntegrate(2561,Int(Times(u_DEFAULT,Power(Plus(Times(a_DEFAULT,Power(x_,m_DEFAULT)),Times(Power(Log(Times(c_DEFAULT,Power(x_,n_DEFAULT))),q_DEFAULT),b_DEFAULT,Power(x_,r_DEFAULT))),p_DEFAULT)),x_Symbol),
    Condition(Int(Times(u,Power(x,Times(p,r)),Power(Plus(Times(a,Power(x,Plus(m,Negate(r)))),Times(b,Power(Log(Times(c,Power(x,n))),q))),p)),x),And(FreeQ(List(a,b,c,m,n,p,q,r),x),IntegerQ(p)))),
IIntegrate(2562,Int(u_,x_Symbol),
    Condition(Int(DeactivateTrig(u,x),x),FunctionOfTrigOfLinearQ(u,x))),
IIntegrate(2563,Int(Times(Power(Times($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),n_DEFAULT),Power(Times(a_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT)),x_Symbol),
    Condition(Simp(Times(Power(Times(a,Sin(Plus(e,Times(f,x)))),Plus(m,C1)),Power(Times(b,Cos(Plus(e,Times(f,x)))),Plus(n,C1)),Power(Times(a,b,f,Plus(m,C1)),-1)),x),And(FreeQ(List(a,b,e,f,m,n),x),EqQ(Plus(m,n,C2),C0),NeQ(m,CN1)))),
IIntegrate(2564,Int(Times(Power($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),n_DEFAULT),Power(Times(a_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT)),x_Symbol),
    Condition(Dist(Power(Times(a,f),-1),Subst(Int(Times(Power(x,m),Power(Plus(C1,Times(CN1,Sqr(x),Power(a,-2))),Times(C1D2,Plus(n,Negate(C1))))),x),x,Times(a,Sin(Plus(e,Times(f,x))))),x),And(FreeQ(List(a,e,f,m),x),IntegerQ(Times(C1D2,Plus(n,Negate(C1)))),Not(And(IntegerQ(Times(C1D2,Plus(m,Negate(C1)))),LtQ(C0,m,n)))))),
IIntegrate(2565,Int(Times(Power(Times($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),a_DEFAULT),m_DEFAULT),Power($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),n_DEFAULT)),x_Symbol),
    Condition(Negate(Dist(Power(Times(a,f),-1),Subst(Int(Times(Power(x,m),Power(Plus(C1,Times(CN1,Sqr(x),Power(a,-2))),Times(C1D2,Plus(n,Negate(C1))))),x),x,Times(a,Cos(Plus(e,Times(f,x))))),x)),And(FreeQ(List(a,e,f,m),x),IntegerQ(Times(C1D2,Plus(n,Negate(C1)))),Not(And(IntegerQ(Times(C1D2,Plus(m,Negate(C1)))),GtQ(m,C0),LeQ(m,n)))))),
IIntegrate(2566,Int(Times(Power(Times($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),n_),Power(Times(a_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(a,Power(Times(a,Sin(Plus(e,Times(f,x)))),Plus(m,Negate(C1))),Power(Times(b,Cos(Plus(e,Times(f,x)))),Plus(n,C1)),Power(Times(b,f,Plus(n,C1)),-1)),x)),Dist(Times(Sqr(a),Plus(m,Negate(C1)),Power(Times(Sqr(b),Plus(n,C1)),-1)),Int(Times(Power(Times(a,Sin(Plus(e,Times(f,x)))),Plus(m,Negate(C2))),Power(Times(b,Cos(Plus(e,Times(f,x)))),Plus(n,C2))),x),x)),And(FreeQ(List(a,b,e,f),x),GtQ(m,C1),LtQ(n,CN1),Or(IntegersQ(Times(C2,m),Times(C2,n)),EqQ(Plus(m,n),C0))))),
IIntegrate(2567,Int(Times(Power(Times($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),a_DEFAULT),m_),Power(Times(b_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_)),x_Symbol),
    Condition(Plus(Simp(Times(a,Power(Times(a,Cos(Plus(e,Times(f,x)))),Plus(m,Negate(C1))),Power(Times(b,Sin(Plus(e,Times(f,x)))),Plus(n,C1)),Power(Times(b,f,Plus(n,C1)),-1)),x),Dist(Times(Sqr(a),Plus(m,Negate(C1)),Power(Times(Sqr(b),Plus(n,C1)),-1)),Int(Times(Power(Times(a,Cos(Plus(e,Times(f,x)))),Plus(m,Negate(C2))),Power(Times(b,Sin(Plus(e,Times(f,x)))),Plus(n,C2))),x),x)),And(FreeQ(List(a,b,e,f),x),GtQ(m,C1),LtQ(n,CN1),Or(IntegersQ(Times(C2,m),Times(C2,n)),EqQ(Plus(m,n),C0))))),
IIntegrate(2568,Int(Times(Power(Times($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),n_),Power(Times(a_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(a,Power(Times(b,Cos(Plus(e,Times(f,x)))),Plus(n,C1)),Power(Times(a,Sin(Plus(e,Times(f,x)))),Plus(m,Negate(C1))),Power(Times(b,f,Plus(m,n)),-1)),x)),Dist(Times(Sqr(a),Plus(m,Negate(C1)),Power(Plus(m,n),-1)),Int(Times(Power(Times(b,Cos(Plus(e,Times(f,x)))),n),Power(Times(a,Sin(Plus(e,Times(f,x)))),Plus(m,Negate(C2)))),x),x)),And(FreeQ(List(a,b,e,f,n),x),GtQ(m,C1),NeQ(Plus(m,n),C0),IntegersQ(Times(C2,m),Times(C2,n))))),
IIntegrate(2569,Int(Times(Power(Times($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),a_DEFAULT),m_),Power(Times(b_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_)),x_Symbol),
    Condition(Plus(Simp(Times(a,Power(Times(b,Sin(Plus(e,Times(f,x)))),Plus(n,C1)),Power(Times(a,Cos(Plus(e,Times(f,x)))),Plus(m,Negate(C1))),Power(Times(b,f,Plus(m,n)),-1)),x),Dist(Times(Sqr(a),Plus(m,Negate(C1)),Power(Plus(m,n),-1)),Int(Times(Power(Times(b,Sin(Plus(e,Times(f,x)))),n),Power(Times(a,Cos(Plus(e,Times(f,x)))),Plus(m,Negate(C2)))),x),x)),And(FreeQ(List(a,b,e,f,n),x),GtQ(m,C1),NeQ(Plus(m,n),C0),IntegersQ(Times(C2,m),Times(C2,n))))),
IIntegrate(2570,Int(Times(Power(Times($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),n_),Power(Times(a_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(b,Cos(Plus(e,Times(f,x)))),Plus(n,C1)),Power(Times(a,Sin(Plus(e,Times(f,x)))),Plus(m,C1)),Power(Times(a,b,f,Plus(m,C1)),-1)),x),Dist(Times(Plus(m,n,C2),Power(Times(Sqr(a),Plus(m,C1)),-1)),Int(Times(Power(Times(b,Cos(Plus(e,Times(f,x)))),n),Power(Times(a,Sin(Plus(e,Times(f,x)))),Plus(m,C2))),x),x)),And(FreeQ(List(a,b,e,f,n),x),LtQ(m,CN1),IntegersQ(Times(C2,m),Times(C2,n))))),
IIntegrate(2571,Int(Times(Power(Times($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),a_DEFAULT),m_),Power(Times(b_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Power(Times(b,Sin(Plus(e,Times(f,x)))),Plus(n,C1)),Power(Times(a,Cos(Plus(e,Times(f,x)))),Plus(m,C1)),Power(Times(a,b,f,Plus(m,C1)),-1)),x)),Dist(Times(Plus(m,n,C2),Power(Times(Sqr(a),Plus(m,C1)),-1)),Int(Times(Power(Times(b,Sin(Plus(e,Times(f,x)))),n),Power(Times(a,Cos(Plus(e,Times(f,x)))),Plus(m,C2))),x),x)),And(FreeQ(List(a,b,e,f,n),x),LtQ(m,CN1),IntegersQ(Times(C2,m),Times(C2,n))))),
IIntegrate(2572,Int(Times(Sqrt(Times($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT)),Sqrt(Times(a_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(Dist(Times(Sqrt(Times(a,Sin(Plus(e,Times(f,x))))),Sqrt(Times(b,Cos(Plus(e,Times(f,x))))),Power(Sin(Plus(Times(C2,e),Times(C2,f,x))),CN1D2)),Int(Sqrt(Sin(Plus(Times(C2,e),Times(C2,f,x)))),x),x),FreeQ(List(a,b,e,f),x))),
IIntegrate(2573,Int(Times(Power(Times($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),CN1D2),Power(Times(a_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),CN1D2)),x_Symbol),
    Condition(Dist(Times(Sqrt(Sin(Plus(Times(C2,e),Times(C2,f,x)))),Power(Times(Sqrt(Times(a,Sin(Plus(e,Times(f,x))))),Sqrt(Times(b,Cos(Plus(e,Times(f,x)))))),-1)),Int(Power(Sin(Plus(Times(C2,e),Times(C2,f,x))),CN1D2),x),x),FreeQ(List(a,b,e,f),x))),
IIntegrate(2574,Int(Times(Power(Times($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),n_),Power(Times(a_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_)),x_Symbol),
    Condition(With(List(Set(k,Denominator(m))),Dist(Times(k,a,b,Power(f,-1)),Subst(Int(Times(Power(x,Plus(Times(k,Plus(m,C1)),Negate(C1))),Power(Plus(Sqr(a),Times(Sqr(b),Power(x,Times(C2,k)))),-1)),x),x,Times(Power(Times(a,Sin(Plus(e,Times(f,x)))),Power(k,-1)),Power(Power(Times(b,Cos(Plus(e,Times(f,x)))),Power(k,-1)),-1))),x)),And(FreeQ(List(a,b,e,f),x),EqQ(Plus(m,n),C0),GtQ(m,C0),LtQ(m,C1)))),
IIntegrate(2575,Int(Times(Power(Times($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),a_DEFAULT),m_),Power(Times(b_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_)),x_Symbol),
    Condition(With(List(Set(k,Denominator(m))),Negate(Dist(Times(k,a,b,Power(f,-1)),Subst(Int(Times(Power(x,Plus(Times(k,Plus(m,C1)),Negate(C1))),Power(Plus(Sqr(a),Times(Sqr(b),Power(x,Times(C2,k)))),-1)),x),x,Times(Power(Times(a,Cos(Plus(e,Times(f,x)))),Power(k,-1)),Power(Power(Times(b,Sin(Plus(e,Times(f,x)))),Power(k,-1)),-1))),x))),And(FreeQ(List(a,b,e,f),x),EqQ(Plus(m,n),C0),GtQ(m,C0),LtQ(m,C1)))),
IIntegrate(2576,Int(Times(Power(Times($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),a_DEFAULT),m_),Power(Times(b_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_)),x_Symbol),
    Condition(Negate(Simp(Times(Power(b,Plus(Times(C2,IntPart(Times(C1D2,Plus(n,Negate(C1))))),C1)),Power(Times(b,Sin(Plus(e,Times(f,x)))),Times(C2,FracPart(Times(C1D2,Plus(n,Negate(C1)))))),Power(Times(a,Cos(Plus(e,Times(f,x)))),Plus(m,C1)),Hypergeometric2F1(Times(C1D2,Plus(C1,m)),Times(C1D2,Plus(C1,Negate(n))),Times(C1D2,Plus(C3,m)),Sqr(Cos(Plus(e,Times(f,x))))),Power(Times(a,f,Plus(m,C1),Power(Sqr(Sin(Plus(e,Times(f,x)))),FracPart(Times(C1D2,Plus(n,Negate(C1)))))),-1)),x)),And(FreeQ(List(a,b,e,f,m,n),x),SimplerQ(n,m)))),
IIntegrate(2577,Int(Times(Power(Times($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),n_),Power(Times(a_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_)),x_Symbol),
    Condition(Simp(Times(Power(b,Plus(Times(C2,IntPart(Times(C1D2,Plus(n,Negate(C1))))),C1)),Power(Times(b,Cos(Plus(e,Times(f,x)))),Times(C2,FracPart(Times(C1D2,Plus(n,Negate(C1)))))),Power(Times(a,Sin(Plus(e,Times(f,x)))),Plus(m,C1)),Hypergeometric2F1(Times(C1D2,Plus(C1,m)),Times(C1D2,Plus(C1,Negate(n))),Times(C1D2,Plus(C3,m)),Sqr(Sin(Plus(e,Times(f,x))))),Power(Times(a,f,Plus(m,C1),Power(Sqr(Cos(Plus(e,Times(f,x)))),FracPart(Times(C1D2,Plus(n,Negate(C1)))))),-1)),x),FreeQ(List(a,b,e,f,m,n),x))),
IIntegrate(2578,Int(Times(Power(Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_DEFAULT),Power(Times(a_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT)),x_Symbol),
    Condition(Simp(Times(b,Power(Times(a,Sin(Plus(e,Times(f,x)))),Plus(m,C1)),Power(Times(b,Sec(Plus(e,Times(f,x)))),Plus(n,Negate(C1))),Power(Times(a,f,Plus(m,C1)),-1)),x),And(FreeQ(List(a,b,e,f,m,n),x),EqQ(Plus(m,Negate(n),C2),C0),NeQ(m,CN1)))),
IIntegrate(2579,Int(Times(Power(Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_),Power(Times(a_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_)),x_Symbol),
    Condition(Plus(Simp(Times(a,b,Power(Times(a,Sin(Plus(e,Times(f,x)))),Plus(m,Negate(C1))),Power(Times(b,Sec(Plus(e,Times(f,x)))),Plus(n,Negate(C1))),Power(Times(f,Plus(n,Negate(C1))),-1)),x),Negate(Dist(Times(Sqr(a),Sqr(b),Plus(m,Negate(C1)),Power(Plus(n,Negate(C1)),-1)),Int(Times(Power(Times(a,Sin(Plus(e,Times(f,x)))),Plus(m,Negate(C2))),Power(Times(b,Sec(Plus(e,Times(f,x)))),Plus(n,Negate(C2)))),x),x))),And(FreeQ(List(a,b,e,f),x),GtQ(n,C1),GtQ(m,C1),IntegersQ(Times(C2,m),Times(C2,n))))),
IIntegrate(2580,Int(Times(Power(Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_),Power(Times(a_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(a,Sin(Plus(e,Times(f,x)))),Plus(m,C1)),Power(Times(b,Sec(Plus(e,Times(f,x)))),Plus(n,C1)),Power(Times(a,b,f,Plus(m,Negate(n))),-1)),x),Negate(Dist(Times(Plus(n,C1),Power(Times(Sqr(b),Plus(m,Negate(n))),-1)),Int(Times(Power(Times(a,Sin(Plus(e,Times(f,x)))),m),Power(Times(b,Sec(Plus(e,Times(f,x)))),Plus(n,C2))),x),x))),And(FreeQ(List(a,b,e,f,m),x),GtQ(n,C1),IntegersQ(Times(C2,m),Times(C2,n))))),
IIntegrate(2581,Int(Times(Power(Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_),Power(Times(a_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(a,Sin(Plus(e,Times(f,x)))),Plus(m,C1)),Power(Times(b,Sec(Plus(e,Times(f,x)))),Plus(n,C1)),Power(Times(a,b,f,Plus(m,C1)),-1)),x),Negate(Dist(Times(Plus(n,C1),Power(Times(Sqr(a),Sqr(b),Plus(m,C1)),-1)),Int(Times(Power(Times(a,Sin(Plus(e,Times(f,x)))),Plus(m,C2)),Power(Times(b,Sec(Plus(e,Times(f,x)))),Plus(n,C2))),x),x))),And(FreeQ(List(a,b,e,f),x),LtQ(n,CN1),LtQ(m,CN1),IntegersQ(Times(C2,m),Times(C2,n))))),
IIntegrate(2582,Int(Times(Power(Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_),Power(Times(a_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(a,Sin(Plus(e,Times(f,x)))),Plus(m,C1)),Power(Times(b,Sec(Plus(e,Times(f,x)))),Plus(n,C1)),Power(Times(a,b,f,Plus(m,Negate(n))),-1)),x),Negate(Dist(Times(Plus(n,C1),Power(Times(Sqr(b),Plus(m,Negate(n))),-1)),Int(Times(Power(Times(a,Sin(Plus(e,Times(f,x)))),m),Power(Times(b,Sec(Plus(e,Times(f,x)))),Plus(n,C2))),x),x))),And(FreeQ(List(a,b,e,f,m),x),LtQ(n,CN1),NeQ(Plus(m,Negate(n)),C0),IntegersQ(Times(C2,m),Times(C2,n))))),
IIntegrate(2583,Int(Times(Power(Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_),Power(Times(a_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(a,b,Power(Times(a,Sin(Plus(e,Times(f,x)))),Plus(m,Negate(C1))),Power(Times(b,Sec(Plus(e,Times(f,x)))),Plus(n,Negate(C1))),Power(Times(f,Plus(m,Negate(n))),-1)),x)),Dist(Times(Sqr(a),Plus(m,Negate(C1)),Power(Plus(m,Negate(n)),-1)),Int(Times(Power(Times(a,Sin(Plus(e,Times(f,x)))),Plus(m,Negate(C2))),Power(Times(b,Sec(Plus(e,Times(f,x)))),n)),x),x)),And(FreeQ(List(a,b,e,f,n),x),GtQ(m,C1),NeQ(Plus(m,Negate(n)),C0),IntegersQ(Times(C2,m),Times(C2,n))))),
IIntegrate(2584,Int(Times(Power(Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_),Power(Times(a_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_)),x_Symbol),
    Condition(Plus(Simp(Times(b,Power(Times(a,Sin(Plus(e,Times(f,x)))),Plus(m,C1)),Power(Times(b,Sec(Plus(e,Times(f,x)))),Plus(n,Negate(C1))),Power(Times(a,f,Plus(m,C1)),-1)),x),Dist(Times(Plus(m,Negate(n),C2),Power(Times(Sqr(a),Plus(m,C1)),-1)),Int(Times(Power(Times(a,Sin(Plus(e,Times(f,x)))),Plus(m,C2)),Power(Times(b,Sec(Plus(e,Times(f,x)))),n)),x),x)),And(FreeQ(List(a,b,e,f,n),x),LtQ(m,CN1),IntegersQ(Times(C2,m),Times(C2,n))))),
IIntegrate(2585,Int(Times(Power(Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_),Power(Times(a_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_)),x_Symbol),
    Condition(Dist(Times(Power(Times(b,Cos(Plus(e,Times(f,x)))),n),Power(Times(b,Sec(Plus(e,Times(f,x)))),n)),Int(Times(Power(Times(a,Sin(Plus(e,Times(f,x)))),m),Power(Power(Times(b,Cos(Plus(e,Times(f,x)))),n),-1)),x),x),And(FreeQ(List(a,b,e,f,m,n),x),IntegerQ(Plus(m,Negate(C1D2))),IntegerQ(Plus(n,Negate(C1D2)))))),
IIntegrate(2586,Int(Times(Power(Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_),Power(Times(a_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_)),x_Symbol),
    Condition(Dist(Times(C1,Power(Times(b,Cos(Plus(e,Times(f,x)))),Plus(n,C1)),Power(Times(b,Sec(Plus(e,Times(f,x)))),Plus(n,C1)),Power(b,-2)),Int(Times(Power(Times(a,Sin(Plus(e,Times(f,x)))),m),Power(Power(Times(b,Cos(Plus(e,Times(f,x)))),n),-1)),x),x),And(FreeQ(List(a,b,e,f,m,n),x),Not(IntegerQ(m)),Not(IntegerQ(n)),LtQ(n,C1)))),
IIntegrate(2587,Int(Times(Power(Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_),Power(Times(a_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_)),x_Symbol),
    Condition(Dist(Times(Sqr(b),Power(Times(b,Cos(Plus(e,Times(f,x)))),Plus(n,Negate(C1))),Power(Times(b,Sec(Plus(e,Times(f,x)))),Plus(n,Negate(C1)))),Int(Times(Power(Times(a,Sin(Plus(e,Times(f,x)))),m),Power(Power(Times(b,Cos(Plus(e,Times(f,x)))),n),-1)),x),x),And(FreeQ(List(a,b,e,f,m,n),x),Not(IntegerQ(m)),Not(IntegerQ(n))))),
IIntegrate(2588,Int(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),n_),Power(Times(a_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(Times(a,b),IntPart(n)),Power(Times(a,Sin(Plus(e,Times(f,x)))),FracPart(n)),Power(Times(b,Csc(Plus(e,Times(f,x)))),FracPart(n))),Int(Power(Times(a,Sin(Plus(e,Times(f,x)))),Plus(m,Negate(n))),x),x),And(FreeQ(List(a,b,e,f,m,n),x),Not(IntegerQ(m)),Not(IntegerQ(n))))),
IIntegrate(2589,Int(Times(Power(Times(a_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_),Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_)),x_Symbol),
    Condition(Negate(Simp(Times(b,Power(Times(a,Sin(Plus(e,Times(f,x)))),m),Power(Times(b,Tan(Plus(e,Times(f,x)))),Plus(n,Negate(C1))),Power(Times(f,m),-1)),x)),And(FreeQ(List(a,b,e,f,m,n),x),EqQ(Plus(m,n,Negate(C1)),C0)))),
IIntegrate(2590,Int(Times(Power($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),m_DEFAULT),Power($($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),n_DEFAULT)),x_Symbol),
    Condition(Negate(Dist(Power(f,-1),Subst(Int(Times(Power(Plus(C1,Negate(Sqr(x))),Times(C1D2,Plus(m,n,Negate(C1)))),Power(Power(x,n),-1)),x),x,Cos(Plus(e,Times(f,x)))),x)),And(FreeQ(List(e,f),x),IntegersQ(m,n,Times(C1D2,Plus(m,n,Negate(C1))))))),
IIntegrate(2591,Int(Times(Power($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),m_),Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(With(List(Set($s("ff"),FreeFactors(Tan(Plus(e,Times(f,x))),x))),Dist(Times(b,$s("ff"),Power(f,-1)),Subst(Int(Times(Power(Times($s("ff"),x),Plus(m,n)),Power(Power(Plus(Sqr(b),Times(Sqr($s("ff")),Sqr(x))),Plus(Times(C1D2,m),C1)),-1)),x),x,Times(b,Tan(Plus(e,Times(f,x))),Power($s("ff"),-1))),x)),And(FreeQ(List(b,e,f,n),x),IntegerQ(Times(C1D2,m))))),
IIntegrate(2592,Int(Times(Power(Times(a_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT),Power($($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),n_DEFAULT)),x_Symbol),
    Condition(With(List(Set($s("ff"),FreeFactors(Sin(Plus(e,Times(f,x))),x))),Dist(Times($s("ff"),Power(f,-1)),Subst(Int(Times(Power(Times($s("ff"),x),Plus(m,n)),Power(Power(Plus(Sqr(a),Times(CN1,Sqr($s("ff")),Sqr(x))),Times(C1D2,Plus(n,C1))),-1)),x),x,Times(a,Sin(Plus(e,Times(f,x))),Power($s("ff"),-1))),x)),And(FreeQ(List(a,e,f,m),x),IntegerQ(Times(C1D2,Plus(n,C1)))))),
IIntegrate(2593,Int(Times(Power(Times(a_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_),Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_)),x_Symbol),
    Condition(Plus(Simp(Times(b,Power(Times(a,Sin(Plus(e,Times(f,x)))),Plus(m,C2)),Power(Times(b,Tan(Plus(e,Times(f,x)))),Plus(n,Negate(C1))),Power(Times(Sqr(a),f,Plus(n,Negate(C1))),-1)),x),Negate(Dist(Times(Sqr(b),Plus(m,C2),Power(Times(Sqr(a),Plus(n,Negate(C1))),-1)),Int(Times(Power(Times(a,Sin(Plus(e,Times(f,x)))),Plus(m,C2)),Power(Times(b,Tan(Plus(e,Times(f,x)))),Plus(n,Negate(C2)))),x),x))),And(FreeQ(List(a,b,e,f),x),GtQ(n,C1),Or(LtQ(m,CN1),And(EqQ(m,CN1),EqQ(n,QQ(3L,2L)))),IntegersQ(Times(C2,m),Times(C2,n))))),
IIntegrate(2594,Int(Times(Power(Times(a_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT),Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_)),x_Symbol),
    Condition(Plus(Simp(Times(b,Power(Times(a,Sin(Plus(e,Times(f,x)))),m),Power(Times(b,Tan(Plus(e,Times(f,x)))),Plus(n,Negate(C1))),Power(Times(f,Plus(n,Negate(C1))),-1)),x),Negate(Dist(Times(Sqr(b),Plus(m,n,Negate(C1)),Power(Plus(n,Negate(C1)),-1)),Int(Times(Power(Times(a,Sin(Plus(e,Times(f,x)))),m),Power(Times(b,Tan(Plus(e,Times(f,x)))),Plus(n,Negate(C2)))),x),x))),And(FreeQ(List(a,b,e,f,m),x),GtQ(n,C1),IntegersQ(Times(C2,m),Times(C2,n)),Not(And(GtQ(m,C1),Not(IntegerQ(Times(C1D2,Plus(m,Negate(C1)))))))))),
IIntegrate(2595,Int(Times(Sqrt(Times(a_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),QQ(-3L,2L))),x_Symbol),
    Condition(Plus(Simp(Times(C2,Sqrt(Times(a,Sin(Plus(e,Times(f,x))))),Power(Times(b,f,Sqrt(Times(b,Tan(Plus(e,Times(f,x)))))),-1)),x),Dist(Times(Sqr(a),Power(b,-2)),Int(Times(Sqrt(Times(b,Tan(Plus(e,Times(f,x))))),Power(Times(a,Sin(Plus(e,Times(f,x)))),QQ(-3L,2L))),x),x)),FreeQ(List(a,b,e,f),x))),
IIntegrate(2596,Int(Times(Power(Times(a_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_),Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(a,Sin(Plus(e,Times(f,x)))),m),Power(Times(b,Tan(Plus(e,Times(f,x)))),Plus(n,C1)),Power(Times(b,f,m),-1)),x),Negate(Dist(Times(Sqr(a),Plus(n,C1),Power(Times(Sqr(b),m),-1)),Int(Times(Power(Times(a,Sin(Plus(e,Times(f,x)))),Plus(m,Negate(C2))),Power(Times(b,Tan(Plus(e,Times(f,x)))),Plus(n,C2))),x),x))),And(FreeQ(List(a,b,e,f),x),LtQ(n,CN1),GtQ(m,C1),IntegersQ(Times(C2,m),Times(C2,n))))),
IIntegrate(2597,Int(Times(Power(Times(a_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT),Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(a,Sin(Plus(e,Times(f,x)))),m),Power(Times(b,Tan(Plus(e,Times(f,x)))),Plus(n,C1)),Power(Times(b,f,Plus(m,n,C1)),-1)),x),Negate(Dist(Times(Plus(n,C1),Power(Times(Sqr(b),Plus(m,n,C1)),-1)),Int(Times(Power(Times(a,Sin(Plus(e,Times(f,x)))),m),Power(Times(b,Tan(Plus(e,Times(f,x)))),Plus(n,C2))),x),x))),And(FreeQ(List(a,b,e,f,m),x),LtQ(n,CN1),NeQ(Plus(m,n,C1),C0),IntegersQ(Times(C2,m),Times(C2,n)),Not(And(EqQ(n,QQ(-3L,2L)),EqQ(m,C1)))))),
IIntegrate(2598,Int(Times(Power(Times(a_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT),Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(b,Power(Times(a,Sin(Plus(e,Times(f,x)))),m),Power(Times(b,Tan(Plus(e,Times(f,x)))),Plus(n,Negate(C1))),Power(Times(f,m),-1)),x)),Dist(Times(Sqr(a),Plus(m,n,Negate(C1)),Power(m,-1)),Int(Times(Power(Times(a,Sin(Plus(e,Times(f,x)))),Plus(m,Negate(C2))),Power(Times(b,Tan(Plus(e,Times(f,x)))),n)),x),x)),And(FreeQ(List(a,b,e,f,n),x),Or(GtQ(m,C1),And(EqQ(m,C1),EqQ(n,C1D2))),IntegersQ(Times(C2,m),Times(C2,n))))),
IIntegrate(2599,Int(Times(Power(Times(a_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_),Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(b,Power(Times(a,Sin(Plus(e,Times(f,x)))),Plus(m,C2)),Power(Times(b,Tan(Plus(e,Times(f,x)))),Plus(n,Negate(C1))),Power(Times(Sqr(a),f,Plus(m,n,C1)),-1)),x),Dist(Times(Plus(m,C2),Power(Times(Sqr(a),Plus(m,n,C1)),-1)),Int(Times(Power(Times(a,Sin(Plus(e,Times(f,x)))),Plus(m,C2)),Power(Times(b,Tan(Plus(e,Times(f,x)))),n)),x),x)),And(FreeQ(List(a,b,e,f,n),x),LtQ(m,CN1),NeQ(Plus(m,n,C1),C0),IntegersQ(Times(C2,m),Times(C2,n))))),
IIntegrate(2600,Int(Times(Power(Times(a_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_),Power($($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),n_)),x_Symbol),
    Condition(Dist(Power(Power(a,n),-1),Int(Times(Power(Times(a,Sin(Plus(e,Times(f,x)))),Plus(m,n)),Power(Power(Cos(Plus(e,Times(f,x))),n),-1)),x),x),And(FreeQ(List(a,e,f,m),x),IntegerQ(n),Not(IntegerQ(m)))))
  );
}
