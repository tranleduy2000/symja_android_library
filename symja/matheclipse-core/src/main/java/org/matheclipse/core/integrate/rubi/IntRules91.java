package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.ASymbol;
import static org.matheclipse.core.expression.F.A_;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.BSymbol;
import static org.matheclipse.core.expression.F.B_DEFAULT;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CI;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Cancel;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Cot;
import static org.matheclipse.core.expression.F.Csc;
import static org.matheclipse.core.expression.F.Exp;
import static org.matheclipse.core.expression.F.FSymbol;
import static org.matheclipse.core.expression.F.F_;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.GSymbol;
import static org.matheclipse.core.expression.F.G_;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Module;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Part;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.PolynomialQ;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sec;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Tan;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.a_DEFAULT;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.g_DEFAULT;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandTrigReduce;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.F;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.G;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IndependentQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.QuotientOfLinearsParts;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.QuotientOfLinearsQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.TrigQ;

/** 
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class IntRules91 { 
  public static IAST RULES = List( 
IIntegrate(4551,Int(Times(Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sec(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),-1),Power($(F_,Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_DEFAULT),Power($(G_,Plus(c_DEFAULT,Times(d_DEFAULT,x_))),p_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(Plus(e,Times(f,x)),m),Cos(Plus(c,Times(d,x))),Power(F(Plus(c,Times(d,x))),n),Power(G(Plus(c,Times(d,x))),p),Power(Plus(b,Times(a,Cos(Plus(c,Times(d,x))))),-1)),x),And(FreeQ(List(a,b,c,d,e,f),x),TrigQ(FSymbol),TrigQ(GSymbol),IntegersQ(m,n,p)))),
IIntegrate(4552,Int(Times(Power(Plus(Times(Csc(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_),-1),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power($(F_,Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_DEFAULT),Power($(G_,Plus(c_DEFAULT,Times(d_DEFAULT,x_))),p_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(Plus(e,Times(f,x)),m),Sin(Plus(c,Times(d,x))),Power(F(Plus(c,Times(d,x))),n),Power(G(Plus(c,Times(d,x))),p),Power(Plus(b,Times(a,Sin(Plus(c,Times(d,x))))),-1)),x),And(FreeQ(List(a,b,c,d,e,f),x),TrigQ(FSymbol),TrigQ(GSymbol),IntegersQ(m,n,p)))),
IIntegrate(4553,Int(Times(Power(Sin(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),p_DEFAULT),Power(Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),q_DEFAULT)),x_Symbol),
    Condition(Dist(Power(Power(C2,Plus(p,q)),-1),Int(ExpandIntegrand(Power(Plus(Times(CI,Power(Exp(Times(CI,Plus(c,Times(d,x)))),-1)),Times(CN1,CI,Exp(Times(CI,Plus(c,Times(d,x)))))),q),Power(Plus(Times(CI,Power(Exp(Times(CI,Plus(a,Times(b,x)))),-1)),Times(CN1,CI,Exp(Times(CI,Plus(a,Times(b,x)))))),p),x),x),x),And(FreeQ(List(a,b,c,d,q),x),IGtQ(p,C0),Not(IntegerQ(q))))),
IIntegrate(4554,Int(Times(Power(Cos(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),p_DEFAULT),Power(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),q_DEFAULT)),x_Symbol),
    Condition(Dist(Power(Power(C2,Plus(p,q)),-1),Int(ExpandIntegrand(Power(Plus(Exp(Times(CN1,CI,Plus(c,Times(d,x)))),Exp(Times(CI,Plus(c,Times(d,x))))),q),Power(Plus(Exp(Times(CN1,CI,Plus(a,Times(b,x)))),Exp(Times(CI,Plus(a,Times(b,x))))),p),x),x),x),And(FreeQ(List(a,b,c,d,q),x),IGtQ(p,C0),Not(IntegerQ(q))))),
IIntegrate(4555,Int(Times(Power(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),q_DEFAULT),Power(Sin(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Power(Power(C2,Plus(p,q)),-1),Int(ExpandIntegrand(Power(Plus(Exp(Times(CN1,CI,Plus(c,Times(d,x)))),Exp(Times(CI,Plus(c,Times(d,x))))),q),Power(Plus(Times(CI,Power(Exp(Times(CI,Plus(a,Times(b,x)))),-1)),Times(CN1,CI,Exp(Times(CI,Plus(a,Times(b,x)))))),p),x),x),x),And(FreeQ(List(a,b,c,d,q),x),IGtQ(p,C0),Not(IntegerQ(q))))),
IIntegrate(4556,Int(Times(Power(Cos(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),p_DEFAULT),Power(Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),q_DEFAULT)),x_Symbol),
    Condition(Dist(Power(Power(C2,Plus(p,q)),-1),Int(ExpandIntegrand(Power(Plus(Times(CI,Power(Exp(Times(CI,Plus(c,Times(d,x)))),-1)),Times(CN1,CI,Exp(Times(CI,Plus(c,Times(d,x)))))),q),Power(Plus(Exp(Times(CN1,CI,Plus(a,Times(b,x)))),Exp(Times(CI,Plus(a,Times(b,x))))),p),x),x),x),And(FreeQ(List(a,b,c,d,q),x),IGtQ(p,C0),Not(IntegerQ(q))))),
IIntegrate(4557,Int(Times(Sin(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),Tan(Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),x_Symbol),
    Condition(Int(Plus(Power(Times(Exp(Times(CI,Plus(a,Times(b,x)))),C2),-1),Times(CN1,C1D2,Exp(Times(CI,Plus(a,Times(b,x))))),Negate(Power(Times(Exp(Times(CI,Plus(a,Times(b,x)))),Plus(C1,Exp(Times(C2,CI,Plus(c,Times(d,x)))))),-1)),Times(Exp(Times(CI,Plus(a,Times(b,x)))),Power(Plus(C1,Exp(Times(C2,CI,Plus(c,Times(d,x))))),-1))),x),And(FreeQ(List(a,b,c,d),x),NeQ(Plus(Sqr(b),Negate(Sqr(d))),C0)))),
IIntegrate(4558,Int(Times(Cos(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),Cot(Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),x_Symbol),
    Condition(Int(Plus(Times(CI,Power(Times(Exp(Times(CI,Plus(a,Times(b,x)))),C2),-1)),Times(C1D2,CI,Exp(Times(CI,Plus(a,Times(b,x))))),Times(CN1,CI,Power(Times(Exp(Times(CI,Plus(a,Times(b,x)))),Plus(C1,Negate(Exp(Times(C2,CI,Plus(c,Times(d,x))))))),-1)),Times(CN1,CI,Exp(Times(CI,Plus(a,Times(b,x)))),Power(Plus(C1,Negate(Exp(Times(C2,CI,Plus(c,Times(d,x)))))),-1))),x),And(FreeQ(List(a,b,c,d),x),NeQ(Plus(Sqr(b),Negate(Sqr(d))),C0)))),
IIntegrate(4559,Int(Times(Cot(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),Sin(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),x_Symbol),
    Condition(Int(Plus(Negate(Power(Times(Exp(Times(CI,Plus(a,Times(b,x)))),C2),-1)),Times(C1D2,Exp(Times(CI,Plus(a,Times(b,x))))),Power(Times(Exp(Times(CI,Plus(a,Times(b,x)))),Plus(C1,Negate(Exp(Times(C2,CI,Plus(c,Times(d,x))))))),-1),Times(CN1,Exp(Times(CI,Plus(a,Times(b,x)))),Power(Plus(C1,Negate(Exp(Times(C2,CI,Plus(c,Times(d,x)))))),-1))),x),And(FreeQ(List(a,b,c,d),x),NeQ(Plus(Sqr(b),Negate(Sqr(d))),C0)))),
IIntegrate(4560,Int(Times(Cos(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),Tan(Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),x_Symbol),
    Condition(Int(Plus(Times(CN1,CI,Power(Times(Exp(Times(CI,Plus(a,Times(b,x)))),C2),-1)),Times(CN1,C1D2,CI,Exp(Times(CI,Plus(a,Times(b,x))))),Times(CI,Power(Times(Exp(Times(CI,Plus(a,Times(b,x)))),Plus(C1,Exp(Times(C2,CI,Plus(c,Times(d,x)))))),-1)),Times(CI,Exp(Times(CI,Plus(a,Times(b,x)))),Power(Plus(C1,Exp(Times(C2,CI,Plus(c,Times(d,x))))),-1))),x),And(FreeQ(List(a,b,c,d),x),NeQ(Plus(Sqr(b),Negate(Sqr(d))),C0)))),
IIntegrate(4561,Int(Power(Sin(Times(a_DEFAULT,Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),-1))),n_DEFAULT),x_Symbol),
    Condition(Negate(Dist(Power(d,-1),Subst(Int(Times(Power(Sin(Times(a,x)),n),Power(x,-2)),x),x,Power(Plus(c,Times(d,x)),-1)),x)),And(FreeQ(List(a,c,d),x),IGtQ(n,C0)))),
IIntegrate(4562,Int(Power(Cos(Times(a_DEFAULT,Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),-1))),n_DEFAULT),x_Symbol),
    Condition(Negate(Dist(Power(d,-1),Subst(Int(Times(Power(Cos(Times(a,x)),n),Power(x,-2)),x),x,Power(Plus(c,Times(d,x)),-1)),x)),And(FreeQ(List(a,c,d),x),IGtQ(n,C0)))),
IIntegrate(4563,Int(Power(Sin(Times(e_DEFAULT,Plus(a_DEFAULT,Times(b_DEFAULT,x_)),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),-1))),n_DEFAULT),x_Symbol),
    Condition(Negate(Dist(Power(d,-1),Subst(Int(Times(Power(Sin(Plus(Times(b,e,Power(d,-1)),Times(CN1,e,Plus(Times(b,c),Times(CN1,a,d)),x,Power(d,-1)))),n),Power(x,-2)),x),x,Power(Plus(c,Times(d,x)),-1)),x)),And(FreeQ(List(a,b,c,d),x),IGtQ(n,C0),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0)))),
IIntegrate(4564,Int(Power(Cos(Times(e_DEFAULT,Plus(a_DEFAULT,Times(b_DEFAULT,x_)),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),-1))),n_DEFAULT),x_Symbol),
    Condition(Negate(Dist(Power(d,-1),Subst(Int(Times(Power(Cos(Plus(Times(b,e,Power(d,-1)),Times(CN1,e,Plus(Times(b,c),Times(CN1,a,d)),x,Power(d,-1)))),n),Power(x,-2)),x),x,Power(Plus(c,Times(d,x)),-1)),x)),And(FreeQ(List(a,b,c,d),x),IGtQ(n,C0),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0)))),
IIntegrate(4565,Int(Power(Sin(u_),n_DEFAULT),x_Symbol),
    Condition(Module(List(Set($s("lst"),QuotientOfLinearsParts(u,x))),Int(Power(Sin(Times(Plus(Part($s("lst"),C1),Times(Part($s("lst"),C2),x)),Power(Plus(Part($s("lst"),C3),Times(Part($s("lst"),C4),x)),-1))),n),x)),And(IGtQ(n,C0),QuotientOfLinearsQ(u,x)))),
IIntegrate(4566,Int(Power(Cos(u_),n_DEFAULT),x_Symbol),
    Condition(Module(List(Set($s("lst"),QuotientOfLinearsParts(u,x))),Int(Power(Cos(Times(Plus(Part($s("lst"),C1),Times(Part($s("lst"),C2),x)),Power(Plus(Part($s("lst"),C3),Times(Part($s("lst"),C4),x)),-1))),n),x)),And(IGtQ(n,C0),QuotientOfLinearsQ(u,x)))),
IIntegrate(4567,Int(Times(u_DEFAULT,Power(Sin(v_),p_DEFAULT),Power(Sin(w_),q_DEFAULT)),x_Symbol),
    Condition(Int(Times(u,Power(Sin(v),Plus(p,q))),x),EqQ(w,v))),
IIntegrate(4568,Int(Times(Power(Cos(v_),p_DEFAULT),Power(Cos(w_),q_DEFAULT),u_DEFAULT),x_Symbol),
    Condition(Int(Times(u,Power(Cos(v),Plus(p,q))),x),EqQ(w,v))),
IIntegrate(4569,Int(Times(Power(Sin(v_),p_DEFAULT),Power(Sin(w_),q_DEFAULT)),x_Symbol),
    Condition(Int(ExpandTrigReduce(Times(Power(Sin(v),p),Power(Sin(w),q)),x),x),And(Or(And(PolynomialQ(v,x),PolynomialQ(w,x)),And(BinomialQ(List(v,w),x),IndependentQ(Cancel(Times(v,Power(w,-1))),x))),IGtQ(p,C0),IGtQ(q,C0)))),
IIntegrate(4570,Int(Times(Power(Cos(v_),p_DEFAULT),Power(Cos(w_),q_DEFAULT)),x_Symbol),
    Condition(Int(ExpandTrigReduce(Times(Power(Cos(v),p),Power(Cos(w),q)),x),x),And(Or(And(PolynomialQ(v,x),PolynomialQ(w,x)),And(BinomialQ(List(v,w),x),IndependentQ(Cancel(Times(v,Power(w,-1))),x))),IGtQ(p,C0),IGtQ(q,C0)))),
IIntegrate(4571,Int(Times(Power(x_,m_DEFAULT),Power(Sin(v_),p_DEFAULT),Power(Sin(w_),q_DEFAULT)),x_Symbol),
    Condition(Int(ExpandTrigReduce(Power(x,m),Times(Power(Sin(v),p),Power(Sin(w),q)),x),x),And(IGtQ(m,C0),IGtQ(p,C0),IGtQ(q,C0),Or(And(PolynomialQ(v,x),PolynomialQ(w,x)),And(BinomialQ(List(v,w),x),IndependentQ(Cancel(Times(v,Power(w,-1))),x)))))),
IIntegrate(4572,Int(Times(Power(Cos(v_),p_DEFAULT),Power(Cos(w_),q_DEFAULT),Power(x_,m_DEFAULT)),x_Symbol),
    Condition(Int(ExpandTrigReduce(Power(x,m),Times(Power(Cos(v),p),Power(Cos(w),q)),x),x),And(IGtQ(m,C0),IGtQ(p,C0),IGtQ(q,C0),Or(And(PolynomialQ(v,x),PolynomialQ(w,x)),And(BinomialQ(List(v,w),x),IndependentQ(Cancel(Times(v,Power(w,-1))),x)))))),
IIntegrate(4573,Int(Times(Power(Cos(w_),p_DEFAULT),u_DEFAULT,Power(Sin(v_),p_DEFAULT)),x_Symbol),
    Condition(Dist(Power(Power(C2,p),-1),Int(Times(u,Power(Sin(Times(C2,v)),p)),x),x),And(EqQ(w,v),IntegerQ(p)))),
IIntegrate(4574,Int(Times(Power(Cos(w_),q_DEFAULT),Power(Sin(v_),p_DEFAULT)),x_Symbol),
    Condition(Int(ExpandTrigReduce(Times(Power(Sin(v),p),Power(Cos(w),q)),x),x),And(IGtQ(p,C0),IGtQ(q,C0),Or(And(PolynomialQ(v,x),PolynomialQ(w,x)),And(BinomialQ(List(v,w),x),IndependentQ(Cancel(Times(v,Power(w,-1))),x)))))),
IIntegrate(4575,Int(Times(Power(Cos(w_),q_DEFAULT),Power(x_,m_DEFAULT),Power(Sin(v_),p_DEFAULT)),x_Symbol),
    Condition(Int(ExpandTrigReduce(Power(x,m),Times(Power(Sin(v),p),Power(Cos(w),q)),x),x),And(IGtQ(m,C0),IGtQ(p,C0),IGtQ(q,C0),Or(And(PolynomialQ(v,x),PolynomialQ(w,x)),And(BinomialQ(List(v,w),x),IndependentQ(Cancel(Times(v,Power(w,-1))),x)))))),
IIntegrate(4576,Int(Times(Sin(v_),Power(Tan(w_),n_DEFAULT)),x_Symbol),
    Condition(Plus(Negate(Int(Times(Cos(v),Power(Tan(w),Plus(n,Negate(C1)))),x)),Dist(Cos(Plus(v,Negate(w))),Int(Times(Sec(w),Power(Tan(w),Plus(n,Negate(C1)))),x),x)),And(GtQ(n,C0),FreeQ(Plus(v,Negate(w)),x),NeQ(w,v)))),
IIntegrate(4577,Int(Times(Cos(v_),Power(Cot(w_),n_DEFAULT)),x_Symbol),
    Condition(Plus(Negate(Int(Times(Sin(v),Power(Cot(w),Plus(n,Negate(C1)))),x)),Dist(Cos(Plus(v,Negate(w))),Int(Times(Csc(w),Power(Cot(w),Plus(n,Negate(C1)))),x),x)),And(GtQ(n,C0),FreeQ(Plus(v,Negate(w)),x),NeQ(w,v)))),
IIntegrate(4578,Int(Times(Power(Cot(w_),n_DEFAULT),Sin(v_)),x_Symbol),
    Condition(Plus(Int(Times(Cos(v),Power(Cot(w),Plus(n,Negate(C1)))),x),Dist(Sin(Plus(v,Negate(w))),Int(Times(Csc(w),Power(Cot(w),Plus(n,Negate(C1)))),x),x)),And(GtQ(n,C0),FreeQ(Plus(v,Negate(w)),x),NeQ(w,v)))),
IIntegrate(4579,Int(Times(Cos(v_),Power(Tan(w_),n_DEFAULT)),x_Symbol),
    Condition(Plus(Int(Times(Sin(v),Power(Tan(w),Plus(n,Negate(C1)))),x),Negate(Dist(Sin(Plus(v,Negate(w))),Int(Times(Sec(w),Power(Tan(w),Plus(n,Negate(C1)))),x),x))),And(GtQ(n,C0),FreeQ(Plus(v,Negate(w)),x),NeQ(w,v)))),
IIntegrate(4580,Int(Times(Power(Sec(w_),n_DEFAULT),Sin(v_)),x_Symbol),
    Condition(Plus(Dist(Cos(Plus(v,Negate(w))),Int(Times(Tan(w),Power(Sec(w),Plus(n,Negate(C1)))),x),x),Dist(Sin(Plus(v,Negate(w))),Int(Power(Sec(w),Plus(n,Negate(C1))),x),x)),And(GtQ(n,C0),FreeQ(Plus(v,Negate(w)),x),NeQ(w,v)))),
IIntegrate(4581,Int(Times(Cos(v_),Power(Csc(w_),n_DEFAULT)),x_Symbol),
    Condition(Plus(Dist(Cos(Plus(v,Negate(w))),Int(Times(Cot(w),Power(Csc(w),Plus(n,Negate(C1)))),x),x),Negate(Dist(Sin(Plus(v,Negate(w))),Int(Power(Csc(w),Plus(n,Negate(C1))),x),x))),And(GtQ(n,C0),FreeQ(Plus(v,Negate(w)),x),NeQ(w,v)))),
IIntegrate(4582,Int(Times(Power(Csc(w_),n_DEFAULT),Sin(v_)),x_Symbol),
    Condition(Plus(Dist(Sin(Plus(v,Negate(w))),Int(Times(Cot(w),Power(Csc(w),Plus(n,Negate(C1)))),x),x),Dist(Cos(Plus(v,Negate(w))),Int(Power(Csc(w),Plus(n,Negate(C1))),x),x)),And(GtQ(n,C0),FreeQ(Plus(v,Negate(w)),x),NeQ(w,v)))),
IIntegrate(4583,Int(Times(Cos(v_),Power(Sec(w_),n_DEFAULT)),x_Symbol),
    Condition(Plus(Negate(Dist(Sin(Plus(v,Negate(w))),Int(Times(Tan(w),Power(Sec(w),Plus(n,Negate(C1)))),x),x)),Dist(Cos(Plus(v,Negate(w))),Int(Power(Sec(w),Plus(n,Negate(C1))),x),x)),And(GtQ(n,C0),FreeQ(Plus(v,Negate(w)),x),NeQ(w,v)))),
IIntegrate(4584,Int(Times(Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Plus(a_,Times(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT,Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(Plus(e,Times(f,x)),m),Power(Plus(a,Times(C1D2,b,Sin(Plus(Times(C2,c),Times(C2,d,x))))),n)),x),FreeQ(List(a,b,c,d,e,f,m,n),x))),
IIntegrate(4585,Int(Times(Power(x_,m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sqr(Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_)))))),n_)),x_Symbol),
    Condition(Dist(Power(Power(C2,n),-1),Int(Times(Power(x,m),Power(Plus(Times(C2,a),b,Times(CN1,b,Cos(Plus(Times(C2,c),Times(C2,d,x))))),n)),x),x),And(FreeQ(List(a,b,c,d),x),NeQ(Plus(a,b),C0),IGtQ(m,C0),ILtQ(n,C0),Or(EqQ(n,CN1),And(EqQ(m,C1),EqQ(n,CN2)))))),
IIntegrate(4586,Int(Times(Power(Plus(Times(Sqr(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),b_DEFAULT),a_),n_),Power(x_,m_DEFAULT)),x_Symbol),
    Condition(Dist(Power(Power(C2,n),-1),Int(Times(Power(x,m),Power(Plus(Times(C2,a),b,Times(b,Cos(Plus(Times(C2,c),Times(C2,d,x))))),n)),x),x),And(FreeQ(List(a,b,c,d),x),NeQ(Plus(a,b),C0),IGtQ(m,C0),ILtQ(n,C0),Or(EqQ(n,CN1),And(EqQ(m,C1),EqQ(n,CN2)))))),
IIntegrate(4587,Int(Times(Power(Plus(f_DEFAULT,Times(g_DEFAULT,x_)),m_DEFAULT),Power(Plus(a_DEFAULT,Times(Sqr(Cos(Plus(d_DEFAULT,Times(e_DEFAULT,x_)))),b_DEFAULT),Times(c_DEFAULT,Sqr(Sin(Plus(d_DEFAULT,Times(e_DEFAULT,x_)))))),-1)),x_Symbol),
    Condition(Dist(C2,Int(Times(Power(Plus(f,Times(g,x)),m),Power(Plus(Times(C2,a),b,c,Times(Plus(b,Negate(c)),Cos(Plus(Times(C2,d),Times(C2,e,x))))),-1)),x),x),And(FreeQ(List(a,b,c,d,e,f,g),x),IGtQ(m,C0),NeQ(Plus(a,b),C0),NeQ(Plus(a,c),C0)))),
IIntegrate(4588,Int(Times(Power(Plus(f_DEFAULT,Times(g_DEFAULT,x_)),m_DEFAULT),Sqr(Sec(Plus(d_DEFAULT,Times(e_DEFAULT,x_)))),Power(Plus(b_,Times(c_DEFAULT,Sqr(Tan(Plus(d_DEFAULT,Times(e_DEFAULT,x_)))))),-1)),x_Symbol),
    Condition(Dist(C2,Int(Times(Power(Plus(f,Times(g,x)),m),Power(Plus(b,c,Times(Plus(b,Negate(c)),Cos(Plus(Times(C2,d),Times(C2,e,x))))),-1)),x),x),And(FreeQ(List(b,c,d,e,f,g),x),IGtQ(m,C0)))),
IIntegrate(4589,Int(Times(Power(Plus(f_DEFAULT,Times(g_DEFAULT,x_)),m_DEFAULT),Sqr(Sec(Plus(d_DEFAULT,Times(e_DEFAULT,x_)))),Power(Plus(b_DEFAULT,Times(a_DEFAULT,Sqr(Sec(Plus(d_DEFAULT,Times(e_DEFAULT,x_))))),Times(c_DEFAULT,Sqr(Tan(Plus(d_DEFAULT,Times(e_DEFAULT,x_)))))),-1)),x_Symbol),
    Condition(Dist(C2,Int(Times(Power(Plus(f,Times(g,x)),m),Power(Plus(Times(C2,a),b,c,Times(Plus(b,Negate(c)),Cos(Plus(Times(C2,d),Times(C2,e,x))))),-1)),x),x),And(FreeQ(List(a,b,c,d,e,f,g),x),IGtQ(m,C0),NeQ(Plus(a,b),C0),NeQ(Plus(a,c),C0)))),
IIntegrate(4590,Int(Times(Sqr(Csc(Plus(d_DEFAULT,Times(e_DEFAULT,x_)))),Power(Plus(Times(Sqr(Cot(Plus(d_DEFAULT,Times(e_DEFAULT,x_)))),b_DEFAULT),c_),-1),Power(Plus(f_DEFAULT,Times(g_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Dist(C2,Int(Times(Power(Plus(f,Times(g,x)),m),Power(Plus(b,c,Times(Plus(b,Negate(c)),Cos(Plus(Times(C2,d),Times(C2,e,x))))),-1)),x),x),And(FreeQ(List(b,c,d,e,f,g),x),IGtQ(m,C0)))),
IIntegrate(4591,Int(Times(Sqr(Csc(Plus(d_DEFAULT,Times(e_DEFAULT,x_)))),Power(Plus(Times(Sqr(Csc(Plus(d_DEFAULT,Times(e_DEFAULT,x_)))),a_DEFAULT),Times(Sqr(Cot(Plus(d_DEFAULT,Times(e_DEFAULT,x_)))),b_DEFAULT),c_DEFAULT),-1),Power(Plus(f_DEFAULT,Times(g_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Dist(C2,Int(Times(Power(Plus(f,Times(g,x)),m),Power(Plus(Times(C2,a),b,c,Times(Plus(b,Negate(c)),Cos(Plus(Times(C2,d),Times(C2,e,x))))),-1)),x),x),And(FreeQ(List(a,b,c,d,e,f,g),x),IGtQ(m,C0),NeQ(Plus(a,b),C0),NeQ(Plus(a,c),C0)))),
IIntegrate(4592,Int(Times(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),Power(Plus(a_,Times(b_DEFAULT,Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),-2),Plus(A_,Times(B_DEFAULT,Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Negate(Simp(Times(BSymbol,Plus(e,Times(f,x)),Cos(Plus(c,Times(d,x))),Power(Times(a,d,Plus(a,Times(b,Sin(Plus(c,Times(d,x)))))),-1)),x)),Dist(Times(BSymbol,f,Power(Times(a,d),-1)),Int(Times(Cos(Plus(c,Times(d,x))),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f,ASymbol,BSymbol),x),EqQ(Plus(Times(a,ASymbol),Times(CN1,b,BSymbol)),C0)))),
IIntegrate(4593,Int(Times(Power(Plus(Times(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_),-2),Plus(Times(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),B_DEFAULT),A_),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),x_Symbol),
    Condition(Plus(Simp(Times(BSymbol,Plus(e,Times(f,x)),Sin(Plus(c,Times(d,x))),Power(Times(a,d,Plus(a,Times(b,Cos(Plus(c,Times(d,x)))))),-1)),x),Negate(Dist(Times(BSymbol,f,Power(Times(a,d),-1)),Int(Times(Sin(Plus(c,Times(d,x))),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f,ASymbol,BSymbol),x),EqQ(Plus(Times(a,ASymbol),Times(CN1,b,BSymbol)),C0)))),
IIntegrate(4594,Int(Times(Sqr(x_),Power(Plus(Times(Cos(Times(a_DEFAULT,x_)),d_DEFAULT,x_),Times(c_DEFAULT,Sin(Times(a_DEFAULT,x_)))),-2)),x_Symbol),
    Condition(Plus(Simp(Times(x,Power(Times(a,d,Sin(Times(a,x)),Plus(Times(c,Sin(Times(a,x))),Times(d,x,Cos(Times(a,x))))),-1)),x),Dist(Power(d,-2),Int(Power(Sin(Times(a,x)),-2),x),x)),And(FreeQ(List(a,c,d),x),EqQ(Plus(Times(a,c),d),C0)))),
IIntegrate(4595,Int(Times(Sqr(x_),Power(Plus(Times(Cos(Times(a_DEFAULT,x_)),c_DEFAULT),Times(d_DEFAULT,x_,Sin(Times(a_DEFAULT,x_)))),-2)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(x,Power(Times(a,d,Cos(Times(a,x)),Plus(Times(c,Cos(Times(a,x))),Times(d,x,Sin(Times(a,x))))),-1)),x)),Dist(Power(d,-2),Int(Power(Cos(Times(a,x)),-2),x),x)),And(FreeQ(List(a,c,d),x),EqQ(Plus(Times(a,c),Negate(d)),C0)))),
IIntegrate(4596,Int(Times(Sqr(Sin(Times(a_DEFAULT,x_))),Power(Plus(Times(Cos(Times(a_DEFAULT,x_)),d_DEFAULT,x_),Times(c_DEFAULT,Sin(Times(a_DEFAULT,x_)))),-2)),x_Symbol),
    Condition(Plus(Simp(Power(Times(Sqr(d),x),-1),x),Simp(Times(Sin(Times(a,x)),Power(Times(a,d,x,Plus(Times(d,x,Cos(Times(a,x))),Times(c,Sin(Times(a,x))))),-1)),x)),And(FreeQ(List(a,c,d),x),EqQ(Plus(Times(a,c),d),C0)))),
IIntegrate(4597,Int(Times(Sqr(Cos(Times(a_DEFAULT,x_))),Power(Plus(Times(Cos(Times(a_DEFAULT,x_)),c_DEFAULT),Times(d_DEFAULT,x_,Sin(Times(a_DEFAULT,x_)))),-2)),x_Symbol),
    Condition(Plus(Simp(Power(Times(Sqr(d),x),-1),x),Negate(Simp(Times(Cos(Times(a,x)),Power(Times(a,d,x,Plus(Times(d,x,Sin(Times(a,x))),Times(c,Cos(Times(a,x))))),-1)),x))),And(FreeQ(List(a,c,d),x),EqQ(Plus(Times(a,c),Negate(d)),C0)))),
IIntegrate(4598,Int(Times(Power(Times(b_DEFAULT,x_),m_),Power(Sin(Times(a_DEFAULT,x_)),n_),Power(Plus(Times(Cos(Times(a_DEFAULT,x_)),d_DEFAULT,x_),Times(c_DEFAULT,Sin(Times(a_DEFAULT,x_)))),-2)),x_Symbol),
    Condition(Plus(Simp(Times(b,Power(Times(b,x),Plus(m,Negate(C1))),Power(Sin(Times(a,x)),Plus(n,Negate(C1))),Power(Times(a,d,Plus(Times(c,Sin(Times(a,x))),Times(d,x,Cos(Times(a,x))))),-1)),x),Negate(Dist(Times(Sqr(b),Plus(n,Negate(C1)),Power(d,-2)),Int(Times(Power(Times(b,x),Plus(m,Negate(C2))),Power(Sin(Times(a,x)),Plus(n,Negate(C2)))),x),x))),And(FreeQ(List(a,b,c,d,m,n),x),EqQ(Plus(Times(a,c),d),C0),EqQ(m,Plus(C2,Negate(n)))))),
IIntegrate(4599,Int(Times(Power(Cos(Times(a_DEFAULT,x_)),n_),Power(Times(b_DEFAULT,x_),m_),Power(Plus(Times(Cos(Times(a_DEFAULT,x_)),c_DEFAULT),Times(d_DEFAULT,x_,Sin(Times(a_DEFAULT,x_)))),-2)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(b,Power(Times(b,x),Plus(m,Negate(C1))),Power(Cos(Times(a,x)),Plus(n,Negate(C1))),Power(Times(a,d,Plus(Times(c,Cos(Times(a,x))),Times(d,x,Sin(Times(a,x))))),-1)),x)),Negate(Dist(Times(Sqr(b),Plus(n,Negate(C1)),Power(d,-2)),Int(Times(Power(Times(b,x),Plus(m,Negate(C2))),Power(Cos(Times(a,x)),Plus(n,Negate(C2)))),x),x))),And(FreeQ(List(a,b,c,d,m,n),x),EqQ(Plus(Times(a,c),Negate(d)),C0),EqQ(m,Plus(C2,Negate(n)))))),
IIntegrate(4600,Int(Times(Power(Csc(Times(a_DEFAULT,x_)),n_DEFAULT),Power(Times(b_DEFAULT,x_),m_DEFAULT),Power(Plus(Times(Cos(Times(a_DEFAULT,x_)),d_DEFAULT,x_),Times(c_DEFAULT,Sin(Times(a_DEFAULT,x_)))),-2)),x_Symbol),
    Condition(Plus(Simp(Times(b,Power(Times(b,x),Plus(m,Negate(C1))),Power(Csc(Times(a,x)),Plus(n,C1)),Power(Times(a,d,Plus(Times(c,Sin(Times(a,x))),Times(d,x,Cos(Times(a,x))))),-1)),x),Dist(Times(Sqr(b),Plus(n,C1),Power(d,-2)),Int(Times(Power(Times(b,x),Plus(m,Negate(C2))),Power(Csc(Times(a,x)),Plus(n,C2))),x),x)),And(FreeQ(List(a,b,c,d,m,n),x),EqQ(Plus(Times(a,c),d),C0),EqQ(m,Plus(n,C2)))))
  );
}