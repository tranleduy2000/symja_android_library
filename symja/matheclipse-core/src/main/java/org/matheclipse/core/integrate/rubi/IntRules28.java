package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.C6;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.CSqrt2;
import static org.matheclipse.core.expression.F.CSqrt3;
import static org.matheclipse.core.expression.F.Coefficient;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
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
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_DEFAULT;
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
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NegQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/** 
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class IntRules28 { 
  public static IAST RULES = List( 
IIntegrate(1401,Int(Times(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),Power(Plus(Times(b_DEFAULT,Power(x_,n_)),Times(c_DEFAULT,Power(x_,$p("n2")))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(e,Power(x,Plus(Negate(n),C1)),Power(Plus(Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),Plus(p,C1)),Power(Times(c,Plus(Times(n,Plus(Times(C2,p),C1)),C1)),-1)),x),Negate(Dist(Times(Plus(Times(b,e,Plus(Times(n,p),C1)),Times(CN1,c,d,Plus(Times(n,Plus(Times(C2,p),C1)),C1))),Power(Times(c,Plus(Times(n,Plus(Times(C2,p),C1)),C1)),-1)),Int(Power(Plus(Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),p),x),x))),And(FreeQ(List(b,c,d,e,n,p),x),EqQ($s("n2"),Times(C2,n)),Not(IntegerQ(p)),NeQ(Plus(Times(n,Plus(Times(C2,p),C1)),C1),C0),NeQ(Plus(Times(b,e,Plus(Times(n,p),C1)),Times(CN1,c,d,Plus(Times(n,Plus(Times(C2,p),C1)),C1))),C0)))),
IIntegrate(1402,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_DEFAULT),Power(Plus(Times(b_DEFAULT,Power(x_,n_)),Times(c_DEFAULT,Power(x_,$p("n2")))),p_)),x_Symbol),
    Condition(Dist(Times(Power(Plus(Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),FracPart(p)),Power(Times(Power(x,Times(n,FracPart(p))),Power(Plus(b,Times(c,Power(x,n))),FracPart(p))),-1)),Int(Times(Power(x,Times(n,p)),Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(b,Times(c,Power(x,n))),p)),x),x),And(FreeQ(List(b,c,d,e,n,p,q),x),EqQ($s("n2"),Times(C2,n)),Not(IntegerQ(p))))),
IIntegrate(1403,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_)),Times(c_DEFAULT,Power(x_,$p("n2")))),p_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(Plus(d,Times(e,Power(x,n))),Plus(p,q)),Power(Plus(Times(a,Power(d,-1)),Times(c,Power(x,n),Power(e,-1))),p)),x),And(FreeQ(List(a,b,c,d,e,n,q),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),EqQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),IntegerQ(p)))),
IIntegrate(1404,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2")))),p_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(Plus(d,Times(e,Power(x,n))),Plus(p,q)),Power(Plus(Times(a,Power(d,-1)),Times(c,Power(x,n),Power(e,-1))),p)),x),And(FreeQ(List(a,c,d,e,n,q),x),EqQ($s("n2"),Times(C2,n)),EqQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),IntegerQ(p)))),
IIntegrate(1405,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_)),Times(c_DEFAULT,Power(x_,$p("n2")))),p_)),x_Symbol),
    Condition(Dist(Times(Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),FracPart(p)),Power(Times(Power(Plus(d,Times(e,Power(x,n))),FracPart(p)),Power(Plus(Times(a,Power(d,-1)),Times(c,Power(x,n),Power(e,-1))),FracPart(p))),-1)),Int(Times(Power(Plus(d,Times(e,Power(x,n))),Plus(p,q)),Power(Plus(Times(a,Power(d,-1)),Times(c,Power(x,n),Power(e,-1))),p)),x),x),And(FreeQ(List(a,b,c,d,e,n,p,q),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),EqQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),Not(IntegerQ(p))))),
IIntegrate(1406,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2")))),p_)),x_Symbol),
    Condition(Dist(Times(Power(Plus(a,Times(c,Power(x,Times(C2,n)))),FracPart(p)),Power(Times(Power(Plus(d,Times(e,Power(x,n))),FracPart(p)),Power(Plus(Times(a,Power(d,-1)),Times(c,Power(x,n),Power(e,-1))),FracPart(p))),-1)),Int(Times(Power(Plus(d,Times(e,Power(x,n))),Plus(p,q)),Power(Plus(Times(a,Power(d,-1)),Times(c,Power(x,n),Power(e,-1))),p)),x),x),And(FreeQ(List(a,c,d,e,n,p,q),x),EqQ($s("n2"),Times(C2,n)),EqQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),Not(IntegerQ(p))))),
IIntegrate(1407,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_DEFAULT),Plus(a_,Times(b_DEFAULT,Power(x_,n_)),Times(c_DEFAULT,Power(x_,$p("n2"))))),x_Symbol),
    Condition(Int(ExpandIntegrand(Times(Power(Plus(d,Times(e,Power(x,n))),q),Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n))))),x),x),And(FreeQ(List(a,b,c,d,e,n),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),IGtQ(q,C0)))),
IIntegrate(1408,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_DEFAULT),Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2"))))),x_Symbol),
    Condition(Int(ExpandIntegrand(Times(Power(Plus(d,Times(e,Power(x,n))),q),Plus(a,Times(c,Power(x,Times(C2,n))))),x),x),And(FreeQ(List(a,c,d,e,n),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),IGtQ(q,C0)))),
IIntegrate(1409,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_),Plus(a_,Times(b_DEFAULT,Power(x_,n_)),Times(c_DEFAULT,Power(x_,$p("n2"))))),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),x,Power(Plus(d,Times(e,Power(x,n))),Plus(q,C1)),Power(Times(d,Sqr(e),n,Plus(q,C1)),-1)),x)),Dist(Power(Times(n,Plus(q,C1),d,Sqr(e)),-1),Int(Times(Power(Plus(d,Times(e,Power(x,n))),Plus(q,C1)),Simp(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e),Plus(Times(n,Plus(q,C1)),C1)),Times(c,d,e,n,Plus(q,C1),Power(x,n))),x)),x),x)),And(FreeQ(List(a,b,c,d,e,n),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),LtQ(q,CN1)))),
IIntegrate(1410,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_),Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2"))))),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),x,Power(Plus(d,Times(e,Power(x,n))),Plus(q,C1)),Power(Times(d,Sqr(e),n,Plus(q,C1)),-1)),x)),Dist(Power(Times(n,Plus(q,C1),d,Sqr(e)),-1),Int(Times(Power(Plus(d,Times(e,Power(x,n))),Plus(q,C1)),Simp(Plus(Times(c,Sqr(d)),Times(a,Sqr(e),Plus(Times(n,Plus(q,C1)),C1)),Times(c,d,e,n,Plus(q,C1),Power(x,n))),x)),x),x)),And(FreeQ(List(a,c,d,e,n),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),LtQ(q,CN1)))),
IIntegrate(1411,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_),Plus(a_,Times(b_DEFAULT,Power(x_,n_)),Times(c_DEFAULT,Power(x_,$p("n2"))))),x_Symbol),
    Condition(Plus(Simp(Times(c,Power(x,Plus(n,C1)),Power(Plus(d,Times(e,Power(x,n))),Plus(q,C1)),Power(Times(e,Plus(Times(n,Plus(q,C2)),C1)),-1)),x),Dist(Power(Times(e,Plus(Times(n,Plus(q,C2)),C1)),-1),Int(Times(Power(Plus(d,Times(e,Power(x,n))),q),Plus(Times(a,e,Plus(Times(n,Plus(q,C2)),C1)),Times(CN1,Plus(Times(c,d,Plus(n,C1)),Times(CN1,b,e,Plus(Times(n,Plus(q,C2)),C1))),Power(x,n)))),x),x)),And(FreeQ(List(a,b,c,d,e,n,q),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0)))),
IIntegrate(1412,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_),Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2"))))),x_Symbol),
    Condition(Plus(Simp(Times(c,Power(x,Plus(n,C1)),Power(Plus(d,Times(e,Power(x,n))),Plus(q,C1)),Power(Times(e,Plus(Times(n,Plus(q,C2)),C1)),-1)),x),Dist(Power(Times(e,Plus(Times(n,Plus(q,C2)),C1)),-1),Int(Times(Power(Plus(d,Times(e,Power(x,n))),q),Plus(Times(a,e,Plus(Times(n,Plus(q,C2)),C1)),Times(CN1,c,d,Plus(n,C1),Power(x,n)))),x),x)),And(FreeQ(List(a,c,d,e,n,q),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0)))),
IIntegrate(1413,Int(Times(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2")))),-1)),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(C2,d,e),C2))),Plus(Dist(Times(Sqr(e),Power(Times(C2,c),-1)),Int(Power(Plus(d,Times(q,Power(x,Times(C1D2,n))),Times(e,Power(x,n))),-1),x),x),Dist(Times(Sqr(e),Power(Times(C2,c),-1)),Int(Power(Plus(d,Times(CN1,q,Power(x,Times(C1D2,n))),Times(e,Power(x,n))),-1),x),x))),And(FreeQ(List(a,c,d,e),x),EqQ($s("n2"),Times(C2,n)),EqQ(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),C0),IGtQ(Times(C1D2,n),C0),PosQ(Times(d,e))))),
IIntegrate(1414,Int(Times(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2")))),-1)),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(CN2,d,e),C2))),Plus(Dist(Times(d,Power(Times(C2,a),-1)),Int(Times(Plus(d,Times(CN1,q,Power(x,Times(C1D2,n)))),Power(Plus(d,Times(CN1,q,Power(x,Times(C1D2,n))),Times(CN1,e,Power(x,n))),-1)),x),x),Dist(Times(d,Power(Times(C2,a),-1)),Int(Times(Plus(d,Times(q,Power(x,Times(C1D2,n)))),Power(Plus(d,Times(q,Power(x,Times(C1D2,n))),Times(CN1,e,Power(x,n))),-1)),x),x))),And(FreeQ(List(a,c,d,e),x),EqQ($s("n2"),Times(C2,n)),EqQ(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),C0),IGtQ(Times(C1D2,n),C0),NegQ(Times(d,e))))),
IIntegrate(1415,Int(Times(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2")))),-1)),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(a,Power(c,-1)),C4))),Plus(Dist(Power(Times(C2,CSqrt2,c,Power(q,3)),-1),Int(Times(Plus(Times(CSqrt2,d,q),Times(CN1,Plus(d,Times(CN1,e,Sqr(q))),Power(x,Times(C1D2,n)))),Power(Plus(Sqr(q),Times(CN1,CSqrt2,q,Power(x,Times(C1D2,n))),Power(x,n)),-1)),x),x),Dist(Power(Times(C2,CSqrt2,c,Power(q,3)),-1),Int(Times(Plus(Times(CSqrt2,d,q),Times(Plus(d,Times(CN1,e,Sqr(q))),Power(x,Times(C1D2,n)))),Power(Plus(Sqr(q),Times(CSqrt2,q,Power(x,Times(C1D2,n))),Power(x,n)),-1)),x),x))),And(FreeQ(List(a,c,d,e),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),C0),IGtQ(Times(C1D2,n),C0),PosQ(Times(a,c))))),
IIntegrate(1416,Int(Times(Plus(d_,Times(e_DEFAULT,Power(x_,3))),Power(Plus(a_,Times(c_DEFAULT,Power(x_,6))),-1)),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(c,Power(a,-1)),C6))),Plus(Dist(Power(Times(C3,a,Sqr(q)),-1),Int(Times(Plus(Times(Sqr(q),d),Times(CN1,e,x)),Power(Plus(C1,Times(Sqr(q),Sqr(x))),-1)),x),x),Dist(Power(Times(C6,a,Sqr(q)),-1),Int(Times(Plus(Times(C2,Sqr(q),d),Times(CN1,Plus(Times(CSqrt3,Power(q,3),d),Negate(e)),x)),Power(Plus(C1,Times(CN1,CSqrt3,q,x),Times(Sqr(q),Sqr(x))),-1)),x),x),Dist(Power(Times(C6,a,Sqr(q)),-1),Int(Times(Plus(Times(C2,Sqr(q),d),Times(Plus(Times(CSqrt3,Power(q,3),d),e),x)),Power(Plus(C1,Times(CSqrt3,q,x),Times(Sqr(q),Sqr(x))),-1)),x),x))),And(FreeQ(List(a,c,d,e),x),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),PosQ(Times(c,Power(a,-1)))))),
IIntegrate(1417,Int(Times(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2")))),-1)),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(CN1,a,Power(c,-1)),C2))),Plus(Dist(Times(C1D2,Plus(d,Times(e,q))),Int(Power(Plus(a,Times(c,q,Power(x,n))),-1),x),x),Dist(Times(C1D2,Plus(d,Times(CN1,e,q))),Int(Power(Plus(a,Times(CN1,c,q,Power(x,n))),-1),x),x))),And(FreeQ(List(a,c,d,e,n),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),NegQ(Times(a,c)),IntegerQ(n)))),
IIntegrate(1418,Int(Times(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2")))),-1)),x_Symbol),
    Condition(Plus(Dist(d,Int(Power(Plus(a,Times(c,Power(x,Times(C2,n)))),-1),x),x),Dist(e,Int(Times(Power(x,n),Power(Plus(a,Times(c,Power(x,Times(C2,n)))),-1)),x),x)),And(FreeQ(List(a,c,d,e,n),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),Or(PosQ(Times(a,c)),Not(IntegerQ(n)))))),
IIntegrate(1419,Int(Times(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_)),Times(c_DEFAULT,Power(x_,$p("n2")))),-1)),x_Symbol),
    Condition(With(List(Set(q,Rt(Plus(Times(C2,d,Power(e,-1)),Times(CN1,b,Power(c,-1))),C2))),Plus(Dist(Times(e,Power(Times(C2,c),-1)),Int(Power(Simp(Plus(Times(d,Power(e,-1)),Times(q,Power(x,Times(C1D2,n))),Power(x,n)),x),-1),x),x),Dist(Times(e,Power(Times(C2,c),-1)),Int(Power(Simp(Plus(Times(d,Power(e,-1)),Times(CN1,q,Power(x,Times(C1D2,n))),Power(x,n)),x),-1),x),x))),And(FreeQ(List(a,b,c,d,e),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),EqQ(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),C0),IGtQ(Times(C1D2,n),C0),Or(GtQ(Plus(Times(C2,d,Power(e,-1)),Times(CN1,b,Power(c,-1))),C0),And(Not(LtQ(Plus(Times(C2,d,Power(e,-1)),Times(CN1,b,Power(c,-1))),C0)),EqQ(d,Times(e,Rt(Times(a,Power(c,-1)),C2)))))))),
IIntegrate(1420,Int(Times(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_)),Times(c_DEFAULT,Power(x_,$p("n2")))),-1)),x_Symbol),
    Condition(With(List(Set(q,Rt(Plus(Sqr(b),Times(CN1,C4,a,c)),C2))),Plus(Dist(Plus(Times(C1D2,e),Times(Plus(Times(C2,c,d),Times(CN1,b,e)),Power(Times(C2,q),-1))),Int(Power(Plus(Times(C1D2,b),Times(CN1,C1D2,q),Times(c,Power(x,n))),-1),x),x),Dist(Plus(Times(C1D2,e),Times(CN1,Plus(Times(C2,c,d),Times(CN1,b,e)),Power(Times(C2,q),-1))),Int(Power(Plus(Times(C1D2,b),Times(C1D2,q),Times(c,Power(x,n))),-1),x),x))),And(FreeQ(List(a,b,c,d,e,n),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),EqQ(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),C0),IGtQ(Times(C1D2,n),C0),GtQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0)))),
IIntegrate(1421,Int(Times(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_)),Times(c_DEFAULT,Power(x_,$p("n2")))),-1)),x_Symbol),
    Condition(With(List(Set(q,Rt(Plus(Times(CN2,d,Power(e,-1)),Times(CN1,b,Power(c,-1))),C2))),Plus(Dist(Times(e,Power(Times(C2,c,q),-1)),Int(Times(Plus(q,Times(CN1,C2,Power(x,Times(C1D2,n)))),Power(Simp(Plus(Times(d,Power(e,-1)),Times(q,Power(x,Times(C1D2,n))),Negate(Power(x,n))),x),-1)),x),x),Dist(Times(e,Power(Times(C2,c,q),-1)),Int(Times(Plus(q,Times(C2,Power(x,Times(C1D2,n)))),Power(Simp(Plus(Times(d,Power(e,-1)),Times(CN1,q,Power(x,Times(C1D2,n))),Negate(Power(x,n))),x),-1)),x),x))),And(FreeQ(List(a,b,c,d,e),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),EqQ(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),C0),IGtQ(Times(C1D2,n),C0),Not(GtQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0))))),
IIntegrate(1422,Int(Times(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_)),Times(c_DEFAULT,Power(x_,$p("n2")))),-1)),x_Symbol),
    Condition(With(List(Set(q,Rt(Plus(Sqr(b),Times(CN1,C4,a,c)),C2))),Plus(Dist(Plus(Times(C1D2,e),Times(Plus(Times(C2,c,d),Times(CN1,b,e)),Power(Times(C2,q),-1))),Int(Power(Plus(Times(C1D2,b),Times(CN1,C1D2,q),Times(c,Power(x,n))),-1),x),x),Dist(Plus(Times(C1D2,e),Times(CN1,Plus(Times(C2,c,d),Times(CN1,b,e)),Power(Times(C2,q),-1))),Int(Power(Plus(Times(C1D2,b),Times(C1D2,q),Times(c,Power(x,n))),-1),x),x))),And(FreeQ(List(a,b,c,d,e,n),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),Or(PosQ(Plus(Sqr(b),Times(CN1,C4,a,c))),Not(IGtQ(Times(C1D2,n),C0)))))),
IIntegrate(1423,Int(Times(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_)),Times(c_DEFAULT,Power(x_,$p("n2")))),-1)),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(a,Power(c,-1)),C2))),With(List(Set(r,Rt(Plus(Times(C2,q),Times(CN1,b,Power(c,-1))),C2))),Plus(Dist(Power(Times(C2,c,q,r),-1),Int(Times(Plus(Times(d,r),Times(CN1,Plus(d,Times(CN1,e,q)),Power(x,Times(C1D2,n)))),Power(Plus(q,Times(CN1,r,Power(x,Times(C1D2,n))),Power(x,n)),-1)),x),x),Dist(Power(Times(C2,c,q,r),-1),Int(Times(Plus(Times(d,r),Times(Plus(d,Times(CN1,e,q)),Power(x,Times(C1D2,n)))),Power(Plus(q,Times(r,Power(x,Times(C1D2,n))),Power(x,n)),-1)),x),x)))),And(FreeQ(List(a,b,c,d,e),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),IGtQ(Times(C1D2,n),C0),NegQ(Plus(Sqr(b),Times(CN1,C4,a,c)))))),
IIntegrate(1424,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_)),Times(c_DEFAULT,Power(x_,$p("n2")))),-1)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times(Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),-1)),x),x),And(FreeQ(List(a,b,c,d,e,n),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),IntegerQ(q)))),
IIntegrate(1425,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2")))),-1)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times(Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(a,Times(c,Power(x,Times(C2,n)))),-1)),x),x),And(FreeQ(List(a,c,d,e,n),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),IntegerQ(q)))),
IIntegrate(1426,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_)),Times(c_DEFAULT,Power(x_,$p("n2")))),-1)),x_Symbol),
    Condition(Plus(Dist(Times(Sqr(e),Power(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),-1)),Int(Power(Plus(d,Times(e,Power(x,n))),q),x),x),Dist(Power(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),-1),Int(Times(Power(Plus(d,Times(e,Power(x,n))),Plus(q,C1)),Plus(Times(c,d),Times(CN1,b,e),Times(CN1,c,e,Power(x,n))),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,n),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),Not(IntegerQ(q)),LtQ(q,CN1)))),
IIntegrate(1427,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2")))),-1)),x_Symbol),
    Condition(Plus(Dist(Times(Sqr(e),Power(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),-1)),Int(Power(Plus(d,Times(e,Power(x,n))),q),x),x),Dist(Times(c,Power(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),-1)),Int(Times(Power(Plus(d,Times(e,Power(x,n))),Plus(q,C1)),Plus(d,Times(CN1,e,Power(x,n))),Power(Plus(a,Times(c,Power(x,Times(C2,n)))),-1)),x),x)),And(FreeQ(List(a,c,d,e,n),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),Not(IntegerQ(q)),LtQ(q,CN1)))),
IIntegrate(1428,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_)),Times(c_DEFAULT,Power(x_,$p("n2")))),-1)),x_Symbol),
    Condition(With(List(Set(r,Rt(Plus(Sqr(b),Times(CN1,C4,a,c)),C2))),Plus(Dist(Times(C2,c,Power(r,-1)),Int(Times(Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(b,Negate(r),Times(C2,c,Power(x,n))),-1)),x),x),Negate(Dist(Times(C2,c,Power(r,-1)),Int(Times(Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(b,r,Times(C2,c,Power(x,n))),-1)),x),x)))),And(FreeQ(List(a,b,c,d,e,n,q),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),Not(IntegerQ(q))))),
IIntegrate(1429,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2")))),-1)),x_Symbol),
    Condition(With(List(Set(r,Rt(Times(CN1,a,c),C2))),Plus(Negate(Dist(Times(c,Power(Times(C2,r),-1)),Int(Times(Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(r,Times(CN1,c,Power(x,n))),-1)),x),x)),Negate(Dist(Times(c,Power(Times(C2,r),-1)),Int(Times(Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(r,Times(c,Power(x,n))),-1)),x),x)))),And(FreeQ(List(a,c,d,e,n,q),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),Not(IntegerQ(q))))),
IIntegrate(1430,Int(Times(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_)),Times(c_DEFAULT,Power(x_,$p("n2")))),p_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(x,Plus(Times(d,Sqr(b)),Times(CN1,a,b,e),Times(CN1,C2,a,c,d),Times(Plus(Times(b,d),Times(CN1,C2,a,e)),c,Power(x,n))),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),Plus(p,C1)),Power(Times(a,n,Plus(p,C1),Plus(Sqr(b),Times(CN1,C4,a,c))),-1)),x)),Dist(Power(Times(a,n,Plus(p,C1),Plus(Sqr(b),Times(CN1,C4,a,c))),-1),Int(Times(Simp(Plus(Times(Plus(Times(n,p),n,C1),d,Sqr(b)),Times(CN1,a,b,e),Times(CN1,C2,a,c,d,Plus(Times(C2,n,p),Times(C2,n),C1)),Times(Plus(Times(C2,n,p),Times(C3,n),C1),Plus(Times(d,b),Times(CN1,C2,a,e)),c,Power(x,n))),x),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),Plus(p,C1))),x),x)),And(FreeQ(List(a,b,c,d,e,n),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),ILtQ(p,CN1)))),
IIntegrate(1431,Int(Times(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2")))),p_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(x,Plus(d,Times(e,Power(x,n))),Power(Plus(a,Times(c,Power(x,Times(C2,n)))),Plus(p,C1)),Power(Times(C2,a,n,Plus(p,C1)),-1)),x)),Dist(Power(Times(C2,a,n,Plus(p,C1)),-1),Int(Times(Plus(Times(d,Plus(Times(C2,n,p),Times(C2,n),C1)),Times(e,Plus(Times(C2,n,p),Times(C3,n),C1),Power(x,n))),Power(Plus(a,Times(c,Power(x,Times(C2,n)))),Plus(p,C1))),x),x)),And(FreeQ(List(a,c,d,e,n),x),EqQ($s("n2"),Times(C2,n)),ILtQ(p,CN1)))),
IIntegrate(1432,Int(Times(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_)),Times(c_DEFAULT,Power(x_,$p("n2")))),p_)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times(Plus(d,Times(e,Power(x,n))),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),p)),x),x),And(FreeQ(List(a,b,c,d,e,n),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0)))),
IIntegrate(1433,Int(Times(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2")))),p_)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times(Plus(d,Times(e,Power(x,n))),Power(Plus(a,Times(c,Power(x,Times(C2,n)))),p)),x),x),And(FreeQ(List(a,c,d,e,n),x),EqQ($s("n2"),Times(C2,n))))),
IIntegrate(1434,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_)),Times(c_DEFAULT,Power(x_,$p("n2")))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(c,p),Power(x,Plus(Times(C2,n,p),Negate(n),C1)),Power(Plus(d,Times(e,Power(x,n))),Plus(q,C1)),Power(Times(e,Plus(Times(C2,n,p),Times(n,q),C1)),-1)),x),Int(Times(Power(Plus(d,Times(e,Power(x,n))),q),ExpandToSum(Plus(Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),p),Times(CN1,Power(c,p),Power(x,Times(C2,n,p))),Times(CN1,d,Power(c,p),Plus(Times(C2,n,p),Negate(n),C1),Power(x,Plus(Times(C2,n,p),Negate(n))),Power(Times(e,Plus(Times(C2,n,p),Times(n,q),C1)),-1))),x)),x)),And(FreeQ(List(a,b,c,d,e,n,q),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),IGtQ(p,C0),NeQ(Plus(Times(C2,n,p),Times(n,q),C1),C0),IGtQ(n,C0),Not(IGtQ(q,C0))))),
IIntegrate(1435,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2")))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(c,p),Power(x,Plus(Times(C2,n,p),Negate(n),C1)),Power(Plus(d,Times(e,Power(x,n))),Plus(q,C1)),Power(Times(e,Plus(Times(C2,n,p),Times(n,q),C1)),-1)),x),Int(Times(Power(Plus(d,Times(e,Power(x,n))),q),ExpandToSum(Plus(Power(Plus(a,Times(c,Power(x,Times(C2,n)))),p),Times(CN1,Power(c,p),Power(x,Times(C2,n,p))),Times(CN1,d,Power(c,p),Plus(Times(C2,n,p),Negate(n),C1),Power(x,Plus(Times(C2,n,p),Negate(n))),Power(Times(e,Plus(Times(C2,n,p),Times(n,q),C1)),-1))),x)),x)),And(FreeQ(List(a,c,d,e,n,q),x),EqQ($s("n2"),Times(C2,n)),IGtQ(p,C0),NeQ(Plus(Times(C2,n,p),Times(n,q),C1),C0),IGtQ(n,C0),Not(IGtQ(q,C0))))),
IIntegrate(1436,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_)),Times(c_DEFAULT,Power(x_,$p("n2")))),p_)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times(Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),p)),x),x),And(FreeQ(List(a,b,c,d,e,n,p,q),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),Or(And(IntegersQ(p,q),Not(IntegerQ(n))),IGtQ(p,C0),And(IGtQ(q,C0),Not(IntegerQ(n))))))),
IIntegrate(1437,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2")))),p_)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times(Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(a,Times(c,Power(x,Times(C2,n)))),p)),x),x),And(FreeQ(List(a,c,d,e,n,p,q),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),Or(And(IntegersQ(p,q),Not(IntegerQ(n))),IGtQ(p,C0),And(IGtQ(q,C0),Not(IntegerQ(n))))))),
IIntegrate(1438,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2")))),p_)),x_Symbol),
    Condition(Int(ExpandIntegrand(Power(Plus(a,Times(c,Power(x,Times(C2,n)))),p),Power(Plus(Times(d,Power(Plus(Sqr(d),Times(CN1,Sqr(e),Power(x,Times(C2,n)))),-1)),Times(CN1,e,Power(x,n),Power(Plus(Sqr(d),Times(CN1,Sqr(e),Power(x,Times(C2,n)))),-1))),Negate(q)),x),x),And(FreeQ(List(a,c,d,e,n,p),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),Not(IntegerQ(p)),ILtQ(q,C0)))),
IIntegrate(1439,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_)),Times(c_DEFAULT,Power(x_,$p("n2")))),p_)),x_Symbol),
    Condition(Unintegrable(Times(Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),p)),x),And(FreeQ(List(a,b,c,d,e,n,p,q),x),EqQ($s("n2"),Times(C2,n))))),
IIntegrate(1440,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_))),q_),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2")))),p_)),x_Symbol),
    Condition(Unintegrable(Times(Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(a,Times(c,Power(x,Times(C2,n)))),p)),x),And(FreeQ(List(a,c,d,e,n,p,q),x),EqQ($s("n2"),Times(C2,n))))),
IIntegrate(1441,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Power(u_,n_))),q_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Power(u_,n_)),Times(c_DEFAULT,Power(u_,$p("n2")))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Power(Coefficient(u,x,C1),-1),Subst(Int(Times(Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),p)),x),x,u),x),And(FreeQ(List(a,b,c,d,e,n,p,q),x),EqQ($s("n2"),Times(C2,n)),LinearQ(u,x),NeQ(u,x)))),
IIntegrate(1442,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Power(u_,n_))),q_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(u_,$p("n2")))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Power(Coefficient(u,x,C1),-1),Subst(Int(Times(Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(a,Times(c,Power(x,Times(C2,n)))),p)),x),x,u),x),And(FreeQ(List(a,c,d,e,n,p,q),x),EqQ($s("n2"),Times(C2,n)),LinearQ(u,x),NeQ(u,x)))),
IIntegrate(1443,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Power(x_,$p("mn",true)))),q_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_DEFAULT)),Times(c_DEFAULT,Power(x_,$p("n2",true)))),p_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(Plus(e,Times(d,Power(x,n))),q),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),p),Power(Power(x,Times(n,q)),-1)),x),And(FreeQ(List(a,b,c,d,e,n,p),x),EqQ($s("n2"),Times(C2,n)),EqQ($s("mn"),Negate(n)),IntegerQ(q),Or(PosQ(n),Not(IntegerQ(p)))))),
IIntegrate(1444,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Power(x_,$p("mn",true)))),q_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2",true)))),p_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(x,Times($s("mn"),q)),Power(Plus(e,Times(d,Power(Power(x,$s("mn")),-1))),q),Power(Plus(a,Times(c,Power(x,$s("n2")))),p)),x),And(FreeQ(List(a,c,d,e,$s("mn"),p),x),EqQ($s("n2"),Times(CN2,$s("mn"))),IntegerQ(q),Or(PosQ($s("n2")),Not(IntegerQ(p)))))),
IIntegrate(1445,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,$p("mn",true))),Times(c_DEFAULT,Power(x_,$p("mn2",true)))),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_DEFAULT))),q_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(c,Times(b,Power(x,n)),Times(a,Power(x,Times(C2,n)))),p),Power(Power(x,Times(C2,n,p)),-1)),x),And(FreeQ(List(a,b,c,d,e,n,q),x),EqQ($s("mn"),Negate(n)),EqQ($s("mn2"),Times(C2,$s("mn"))),IntegerQ(p)))),
IIntegrate(1446,Int(Times(Power(Plus(a_DEFAULT,Times(c_DEFAULT,Power(x_,$p("mn2",true)))),p_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_DEFAULT))),q_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(c,Times(a,Power(x,Times(C2,n)))),p),Power(Power(x,Times(C2,n,p)),-1)),x),And(FreeQ(List(a,c,d,e,n,q),x),EqQ($s("mn2"),Times(CN2,n)),IntegerQ(p)))),
IIntegrate(1447,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Power(x_,$p("mn",true)))),q_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_DEFAULT)),Times(c_DEFAULT,Power(x_,$p("n2",true)))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(e,IntPart(q)),Power(x,Times(n,FracPart(q))),Power(Plus(d,Times(e,Power(Power(x,n),-1))),FracPart(q)),Power(Power(Plus(C1,Times(d,Power(x,n),Power(e,-1))),FracPart(q)),-1)),Int(Times(Power(Plus(C1,Times(d,Power(x,n),Power(e,-1))),q),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),p),Power(Power(x,Times(n,q)),-1)),x),x),And(FreeQ(List(a,b,c,d,e,n,p,q),x),EqQ($s("n2"),Times(C2,n)),EqQ($s("mn"),Negate(n)),Not(IntegerQ(p)),Not(IntegerQ(q)),PosQ(n)))),
IIntegrate(1448,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Power(x_,$p("mn",true)))),q_),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2",true)))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(e,IntPart(q)),Power(Plus(d,Times(e,Power(x,$s("mn")))),FracPart(q)),Power(Times(Power(x,Times($s("mn"),FracPart(q))),Power(Plus(C1,Times(d,Power(Times(Power(x,$s("mn")),e),-1))),FracPart(q))),-1)),Int(Times(Power(x,Times($s("mn"),q)),Power(Plus(C1,Times(d,Power(Times(Power(x,$s("mn")),e),-1))),q),Power(Plus(a,Times(c,Power(x,$s("n2")))),p)),x),x),And(FreeQ(List(a,c,d,e,$s("mn"),p,q),x),EqQ($s("n2"),Times(CN2,$s("mn"))),Not(IntegerQ(p)),Not(IntegerQ(q)),PosQ($s("n2"))))),
IIntegrate(1449,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,$p("mn",true))),Times(c_DEFAULT,Power(x_,$p("mn2",true)))),p_),Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_DEFAULT))),q_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(x,Times(C2,n,FracPart(p))),Power(Plus(a,Times(b,Power(Power(x,n),-1)),Times(c,Power(Power(x,Times(C2,n)),-1))),FracPart(p)),Power(Power(Plus(c,Times(b,Power(x,n)),Times(a,Power(x,Times(C2,n)))),FracPart(p)),-1)),Int(Times(Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(c,Times(b,Power(x,n)),Times(a,Power(x,Times(C2,n)))),p),Power(Power(x,Times(C2,n,p)),-1)),x),x),And(FreeQ(List(a,b,c,d,e,n,p,q),x),EqQ($s("mn"),Negate(n)),EqQ($s("mn2"),Times(C2,$s("mn"))),Not(IntegerQ(p)),Not(IntegerQ(q)),PosQ(n)))),
IIntegrate(1450,Int(Times(Power(Plus(a_DEFAULT,Times(c_DEFAULT,Power(x_,$p("mn2",true)))),p_),Power(Plus(d_,Times(e_DEFAULT,Power(x_,n_DEFAULT))),q_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(x,Times(C2,n,FracPart(p))),Power(Plus(a,Times(c,Power(Power(x,Times(C2,n)),-1))),FracPart(p)),Power(Power(Plus(c,Times(a,Power(x,Times(C2,n)))),FracPart(p)),-1)),Int(Times(Power(Plus(d,Times(e,Power(x,n))),q),Power(Plus(c,Times(a,Power(x,Times(C2,n)))),p),Power(Power(x,Times(C2,n,p)),-1)),x),x),And(FreeQ(List(a,c,d,e,n,p,q),x),EqQ($s("mn2"),Times(CN2,n)),Not(IntegerQ(p)),Not(IntegerQ(q)),PosQ(n))))
  );
}