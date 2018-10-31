package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcCos;
import static org.matheclipse.core.expression.F.ArcSin;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Cot;
import static org.matheclipse.core.expression.F.Csc;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.QQ;
import static org.matheclipse.core.expression.F.Sec;
import static org.matheclipse.core.expression.F.Set;
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
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.g_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.HalfIntegerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntHide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/** 
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class IntRules93 { 
  public static IAST RULES = List( 
IIntegrate(4651,Int(Times(Power(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),QQ(-3L,2L))),x_Symbol),
    Condition(Plus(Simp(Times(x,Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n),Power(Times(d,Sqrt(Plus(d,Times(e,Sqr(x))))),-1)),x),Negate(Dist(Times(b,c,n,Power(d,CN1D2)),Int(Times(x,Power(Plus(a,Times(b,ArcSin(Times(c,x)))),Plus(n,Negate(C1))),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),GtQ(d,C0)))),
IIntegrate(4652,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),QQ(-3L,2L))),x_Symbol),
    Condition(Plus(Simp(Times(x,Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n),Power(Times(d,Sqrt(Plus(d,Times(e,Sqr(x))))),-1)),x),Dist(Times(b,c,n,Power(d,CN1D2)),Int(Times(x,Power(Plus(a,Times(b,ArcCos(Times(c,x)))),Plus(n,Negate(C1))),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),GtQ(d,C0)))),
IIntegrate(4653,Int(Times(Power(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),QQ(-3L,2L))),x_Symbol),
    Condition(Plus(Simp(Times(x,Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n),Power(Times(d,Sqrt(Plus(d,Times(e,Sqr(x))))),-1)),x),Negate(Dist(Times(b,c,n,Sqrt(Plus(C1,Times(CN1,Sqr(c),Sqr(x)))),Power(Times(d,Sqrt(Plus(d,Times(e,Sqr(x))))),-1)),Int(Times(x,Power(Plus(a,Times(b,ArcSin(Times(c,x)))),Plus(n,Negate(C1))),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0)))),
IIntegrate(4654,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),QQ(-3L,2L))),x_Symbol),
    Condition(Plus(Simp(Times(x,Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n),Power(Times(d,Sqrt(Plus(d,Times(e,Sqr(x))))),-1)),x),Dist(Times(b,c,n,Sqrt(Plus(C1,Times(CN1,Sqr(c),Sqr(x)))),Power(Times(d,Sqrt(Plus(d,Times(e,Sqr(x))))),-1)),Int(Times(x,Power(Plus(a,Times(b,ArcCos(Times(c,x)))),Plus(n,Negate(C1))),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0)))),
IIntegrate(4655,Int(Times(Power(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(x,Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n),Power(Times(C2,d,Plus(p,C1)),-1)),x)),Dist(Times(Plus(Times(C2,p),C3),Power(Times(C2,d,Plus(p,C1)),-1)),Int(Times(Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n)),x),x),Dist(Times(b,c,n,Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(C2,Plus(p,C1),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),FracPart(p))),-1)),Int(Times(x,Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),Plus(p,C1D2)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),Plus(n,Negate(C1)))),x),x)),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),LtQ(p,CN1),NeQ(p,QQ(-3L,2L))))),
IIntegrate(4656,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(x,Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n),Power(Times(C2,d,Plus(p,C1)),-1)),x)),Dist(Times(Plus(Times(C2,p),C3),Power(Times(C2,d,Plus(p,C1)),-1)),Int(Times(Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n)),x),x),Negate(Dist(Times(b,c,n,Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(C2,Plus(p,C1),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),FracPart(p))),-1)),Int(Times(x,Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),Plus(p,C1D2)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),Plus(n,Negate(C1)))),x),x))),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),LtQ(p,CN1),NeQ(p,QQ(-3L,2L))))),
IIntegrate(4657,Int(Times(Power(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Dist(Power(Times(c,d),-1),Subst(Int(Times(Power(Plus(a,Times(b,x)),n),Sec(x)),x),x,ArcSin(Times(c,x))),x),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(n,C0)))),
IIntegrate(4658,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Negate(Dist(Power(Times(c,d),-1),Subst(Int(Times(Power(Plus(a,Times(b,x)),n),Csc(x)),x),x,ArcCos(Times(c,x))),x)),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(n,C0)))),
IIntegrate(4659,Int(Times(Power(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),n_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Sqrt(Plus(C1,Times(CN1,Sqr(c),Sqr(x)))),Power(Plus(d,Times(e,Sqr(x))),p),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),Plus(n,C1)),Power(Times(b,c,Plus(n,C1)),-1)),x),Dist(Times(c,Plus(Times(C2,p),C1),Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(b,Plus(n,C1),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),FracPart(p))),-1)),Int(Times(x,Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),Plus(p,Negate(C1D2))),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),Plus(n,C1))),x),x)),And(FreeQ(List(a,b,c,d,e,p),x),EqQ(Plus(Times(Sqr(c),d),e),C0),LtQ(n,CN1)))),
IIntegrate(4660,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),n_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Sqrt(Plus(C1,Times(CN1,Sqr(c),Sqr(x)))),Power(Plus(d,Times(e,Sqr(x))),p),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),Plus(n,C1)),Power(Times(b,c,Plus(n,C1)),-1)),x)),Negate(Dist(Times(c,Plus(Times(C2,p),C1),Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(b,Plus(n,C1),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),FracPart(p))),-1)),Int(Times(x,Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),Plus(p,Negate(C1D2))),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),Plus(n,C1))),x),x))),And(FreeQ(List(a,b,c,d,e,p),x),EqQ(Plus(Times(Sqr(c),d),e),C0),LtQ(n,CN1)))),
IIntegrate(4661,Int(Times(Power(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(d,p),Power(c,-1)),Subst(Int(Times(Power(Plus(a,Times(b,x)),n),Power(Cos(x),Plus(Times(C2,p),C1))),x),x,ArcSin(Times(c,x))),x),And(FreeQ(List(a,b,c,d,e,n),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(Times(C2,p),C0),Or(IntegerQ(p),GtQ(d,C0))))),
IIntegrate(4662,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Negate(Dist(Times(Power(d,p),Power(c,-1)),Subst(Int(Times(Power(Plus(a,Times(b,x)),n),Power(Sin(x),Plus(Times(C2,p),C1))),x),x,ArcCos(Times(c,x))),x)),And(FreeQ(List(a,b,c,d,e,n),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(Times(C2,p),C0),Or(IntegerQ(p),GtQ(d,C0))))),
IIntegrate(4663,Int(Times(Power(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(d,Plus(p,Negate(C1D2))),Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),CN1D2)),Int(Times(Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),p),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n)),x),x),And(FreeQ(List(a,b,c,d,e,n),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(Times(C2,p),C0),Not(Or(IntegerQ(p),GtQ(d,C0)))))),
IIntegrate(4664,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(d,Plus(p,Negate(C1D2))),Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),CN1D2)),Int(Times(Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),p),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n)),x),x),And(FreeQ(List(a,b,c,d,e,n),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(Times(C2,p),C0),Not(Or(IntegerQ(p),GtQ(d,C0)))))),
IIntegrate(4665,Int(Times(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(With(List(Set(u,IntHide(Power(Plus(d,Times(e,Sqr(x))),p),x))),Plus(Dist(Plus(a,Times(b,ArcSin(Times(c,x)))),u,x),Negate(Dist(Times(b,c),Int(SimplifyIntegrand(Times(u,Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),CN1D2)),x),x),x)))),And(FreeQ(List(a,b,c,d,e),x),NeQ(Plus(Times(Sqr(c),d),e),C0),Or(IGtQ(p,C0),ILtQ(Plus(p,C1D2),C0))))),
IIntegrate(4666,Int(Times(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(With(List(Set(u,IntHide(Power(Plus(d,Times(e,Sqr(x))),p),x))),Plus(Dist(Plus(a,Times(b,ArcCos(Times(c,x)))),u,x),Dist(Times(b,c),Int(SimplifyIntegrand(Times(u,Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),CN1D2)),x),x),x))),And(FreeQ(List(a,b,c,d,e),x),NeQ(Plus(Times(Sqr(c),d),e),C0),Or(IGtQ(p,C0),ILtQ(Plus(p,C1D2),C0))))),
IIntegrate(4667,Int(Times(Power(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Int(ExpandIntegrand(Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n),Power(Plus(d,Times(e,Sqr(x))),p),x),x),And(FreeQ(List(a,b,c,d,e,n),x),NeQ(Plus(Times(Sqr(c),d),e),C0),IntegerQ(p),Or(GtQ(p,C0),IGtQ(n,C0))))),
IIntegrate(4668,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Int(ExpandIntegrand(Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n),Power(Plus(d,Times(e,Sqr(x))),p),x),x),And(FreeQ(List(a,b,c,d,e,n),x),NeQ(Plus(Times(Sqr(c),d),e),C0),IntegerQ(p),Or(GtQ(p,C0),IGtQ(n,C0))))),
IIntegrate(4669,Int(Times(Power(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Unintegrable(Times(Power(Plus(d,Times(e,Sqr(x))),p),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n)),x),FreeQ(List(a,b,c,d,e,n,p),x))),
IIntegrate(4670,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Unintegrable(Times(Power(Plus(d,Times(e,Sqr(x))),p),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n)),x),FreeQ(List(a,b,c,d,e,n,p),x))),
IIntegrate(4671,Int(Times(Power(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,x_)),p_),Power(Plus(f_,Times(g_DEFAULT,x_)),q_)),x_Symbol),
    Condition(Dist(Power(Times(CN1,Sqr(d),g,Power(e,-1)),q),Int(Times(Power(Plus(d,Times(e,x)),Plus(p,Negate(q))),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),q),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n)),x),x),And(FreeQ(List(a,b,c,d,e,f,g,n),x),EqQ(Plus(Times(e,f),Times(d,g)),C0),EqQ(Plus(Times(Sqr(c),Sqr(d)),Negate(Sqr(e))),C0),HalfIntegerQ(p,q),GeQ(Plus(p,Negate(q)),C0),GtQ(d,C0),LtQ(Times(g,Power(e,-1)),C0)))),
IIntegrate(4672,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,x_)),p_),Power(Plus(f_,Times(g_DEFAULT,x_)),q_)),x_Symbol),
    Condition(Dist(Power(Times(CN1,Sqr(d),g,Power(e,-1)),q),Int(Times(Power(Plus(d,Times(e,x)),Plus(p,Negate(q))),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),q),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n)),x),x),And(FreeQ(List(a,b,c,d,e,f,g,n),x),EqQ(Plus(Times(e,f),Times(d,g)),C0),EqQ(Plus(Times(Sqr(c),Sqr(d)),Negate(Sqr(e))),C0),HalfIntegerQ(p,q),GeQ(Plus(p,Negate(q)),C0),GtQ(d,C0),LtQ(Times(g,Power(e,-1)),C0)))),
IIntegrate(4673,Int(Times(Power(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,x_)),p_),Power(Plus(f_,Times(g_DEFAULT,x_)),q_)),x_Symbol),
    Condition(Dist(Times(Power(Plus(d,Times(e,x)),q),Power(Plus(f,Times(g,x)),q),Power(Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),q),-1)),Int(Times(Power(Plus(d,Times(e,x)),Plus(p,Negate(q))),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),q),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n)),x),x),And(FreeQ(List(a,b,c,d,e,f,g,n),x),EqQ(Plus(Times(e,f),Times(d,g)),C0),EqQ(Plus(Times(Sqr(c),Sqr(d)),Negate(Sqr(e))),C0),HalfIntegerQ(p,q),GeQ(Plus(p,Negate(q)),C0)))),
IIntegrate(4674,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,x_)),p_),Power(Plus(f_,Times(g_DEFAULT,x_)),q_)),x_Symbol),
    Condition(Dist(Times(Power(Plus(d,Times(e,x)),q),Power(Plus(f,Times(g,x)),q),Power(Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),q),-1)),Int(Times(Power(Plus(d,Times(e,x)),Plus(p,Negate(q))),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),q),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n)),x),x),And(FreeQ(List(a,b,c,d,e,f,g,n),x),EqQ(Plus(Times(e,f),Times(d,g)),C0),EqQ(Plus(Times(Sqr(c),Sqr(d)),Negate(Sqr(e))),C0),HalfIntegerQ(p,q),GeQ(Plus(p,Negate(q)),C0)))),
IIntegrate(4675,Int(Times(Power(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),x_,Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Negate(Dist(Power(e,-1),Subst(Int(Times(Power(Plus(a,Times(b,x)),n),Tan(x)),x),x,ArcSin(Times(c,x))),x)),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(n,C0)))),
IIntegrate(4676,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),x_,Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Dist(Power(e,-1),Subst(Int(Times(Power(Plus(a,Times(b,x)),n),Cot(x)),x),x,ArcCos(Times(c,x))),x),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(n,C0)))),
IIntegrate(4677,Int(Times(Power(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),x_,Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n),Power(Times(C2,e,Plus(p,C1)),-1)),x),Dist(Times(b,n,Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(C2,c,Plus(p,C1),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),FracPart(p))),-1)),Int(Times(Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),Plus(p,C1D2)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),Plus(n,Negate(C1)))),x),x)),And(FreeQ(List(a,b,c,d,e,p),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),NeQ(p,CN1)))),
IIntegrate(4678,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),x_,Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n),Power(Times(C2,e,Plus(p,C1)),-1)),x),Negate(Dist(Times(b,n,Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(C2,c,Plus(p,C1),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),FracPart(p))),-1)),Int(Times(Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),Plus(p,C1D2)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),Plus(n,Negate(C1)))),x),x))),And(FreeQ(List(a,b,c,d,e,p),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),NeQ(p,CN1)))),
IIntegrate(4679,Int(Times(Power(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(x_,-1),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Dist(Power(d,-1),Subst(Int(Times(Power(Plus(a,Times(b,x)),n),Power(Times(Cos(x),Sin(x)),-1)),x),x,ArcSin(Times(c,x))),x),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(n,C0)))),
IIntegrate(4680,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(x_,-1),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Negate(Dist(Power(d,-1),Subst(Int(Times(Power(Plus(a,Times(b,x)),n),Power(Times(Cos(x),Sin(x)),-1)),x),x,ArcCos(Times(c,x))),x)),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(n,C0)))),
IIntegrate(4681,Int(Times(Power(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n),Power(Times(d,f,Plus(m,C1)),-1)),x),Negate(Dist(Times(b,c,n,Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(f,Plus(m,C1),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),FracPart(p))),-1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),Plus(p,C1D2)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),Plus(n,Negate(C1)))),x),x))),And(FreeQ(List(a,b,c,d,e,f,m,p),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),EqQ(Plus(m,Times(C2,p),C3),C0),NeQ(m,CN1)))),
IIntegrate(4682,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n),Power(Times(d,f,Plus(m,C1)),-1)),x),Dist(Times(b,c,n,Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(f,Plus(m,C1),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),FracPart(p))),-1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),Plus(p,C1D2)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),Plus(n,Negate(C1)))),x),x)),And(FreeQ(List(a,b,c,d,e,f,m,p),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),EqQ(Plus(m,Times(C2,p),C3),C0),NeQ(m,CN1)))),
IIntegrate(4683,Int(Times(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),Power(x_,-1),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(d,Times(e,Sqr(x))),p),Plus(a,Times(b,ArcSin(Times(c,x)))),Power(Times(C2,p),-1)),x),Dist(d,Int(Times(Power(Plus(d,Times(e,Sqr(x))),Plus(p,Negate(C1))),Plus(a,Times(b,ArcSin(Times(c,x)))),Power(x,-1)),x),x),Negate(Dist(Times(b,c,Power(d,p),Power(Times(C2,p),-1)),Int(Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),Plus(p,Negate(C1D2))),x),x))),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(p,C0)))),
IIntegrate(4684,Int(Times(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),Power(x_,-1),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(d,Times(e,Sqr(x))),p),Plus(a,Times(b,ArcCos(Times(c,x)))),Power(Times(C2,p),-1)),x),Dist(d,Int(Times(Power(Plus(d,Times(e,Sqr(x))),Plus(p,Negate(C1))),Plus(a,Times(b,ArcCos(Times(c,x)))),Power(x,-1)),x),x),Dist(Times(b,c,Power(d,p),Power(Times(C2,p),-1)),Int(Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),Plus(p,Negate(C1D2))),x),x)),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(p,C0)))),
IIntegrate(4685,Int(Times(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(d,Times(e,Sqr(x))),p),Plus(a,Times(b,ArcSin(Times(c,x)))),Power(Times(f,Plus(m,C1)),-1)),x),Negate(Dist(Times(b,c,Power(d,p),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),Plus(p,Negate(C1D2)))),x),x)),Negate(Dist(Times(C2,e,p,Power(Times(Sqr(f),Plus(m,C1)),-1)),Int(Times(Power(Times(f,x),Plus(m,C2)),Power(Plus(d,Times(e,Sqr(x))),Plus(p,Negate(C1))),Plus(a,Times(b,ArcSin(Times(c,x))))),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(p,C0),ILtQ(Times(C1D2,Plus(m,C1)),C0)))),
IIntegrate(4686,Int(Times(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(d,Times(e,Sqr(x))),p),Plus(a,Times(b,ArcCos(Times(c,x)))),Power(Times(f,Plus(m,C1)),-1)),x),Dist(Times(b,c,Power(d,p),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),Plus(p,Negate(C1D2)))),x),x),Negate(Dist(Times(C2,e,p,Power(Times(Sqr(f),Plus(m,C1)),-1)),Int(Times(Power(Times(f,x),Plus(m,C2)),Power(Plus(d,Times(e,Sqr(x))),Plus(p,Negate(C1))),Plus(a,Times(b,ArcCos(Times(c,x))))),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(p,C0),ILtQ(Times(C1D2,Plus(m,C1)),C0)))),
IIntegrate(4687,Int(Times(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(With(List(Set(u,IntHide(Times(Power(Times(f,x),m),Power(Plus(d,Times(e,Sqr(x))),p)),x))),Plus(Dist(Plus(a,Times(b,ArcSin(Times(c,x)))),u,x),Negate(Dist(Times(b,c),Int(SimplifyIntegrand(Times(u,Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),CN1D2)),x),x),x)))),And(FreeQ(List(a,b,c,d,e,f,m),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(p,C0)))),
IIntegrate(4688,Int(Times(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(With(List(Set(u,IntHide(Times(Power(Times(f,x),m),Power(Plus(d,Times(e,Sqr(x))),p)),x))),Plus(Dist(Plus(a,Times(b,ArcCos(Times(c,x)))),u,x),Dist(Times(b,c),Int(SimplifyIntegrand(Times(u,Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),CN1D2)),x),x),x))),And(FreeQ(List(a,b,c,d,e,f,m),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(p,C0)))),
IIntegrate(4689,Int(Times(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),Power(x_,m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(With(List(Set(u,IntHide(Times(Power(x,m),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),p)),x))),Plus(Dist(Times(Power(d,p),Plus(a,Times(b,ArcSin(Times(c,x))))),u,x),Negate(Dist(Times(b,c,Power(d,p)),Int(SimplifyIntegrand(Times(u,Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),CN1D2)),x),x),x)))),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IntegerQ(Plus(p,Negate(C1D2))),Or(IGtQ(Times(C1D2,Plus(m,C1)),C0),ILtQ(Times(C1D2,Plus(m,Times(C2,p),C3)),C0)),NeQ(p,Negate(Power(C2,-1))),GtQ(d,C0)))),
IIntegrate(4690,Int(Times(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),Power(x_,m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(With(List(Set(u,IntHide(Times(Power(x,m),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),p)),x))),Plus(Dist(Times(Power(d,p),Plus(a,Times(b,ArcCos(Times(c,x))))),u,x),Dist(Times(b,c,Power(d,p)),Int(SimplifyIntegrand(Times(u,Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),CN1D2)),x),x),x))),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IntegerQ(Plus(p,Negate(C1D2))),Or(IGtQ(Times(C1D2,Plus(m,C1)),C0),ILtQ(Times(C1D2,Plus(m,Times(C2,p),C3)),C0)),NeQ(p,Negate(Power(C2,-1))),GtQ(d,C0)))),
IIntegrate(4691,Int(Times(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),Power(x_,m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(With(List(Set(u,IntHide(Times(Power(x,m),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),p)),x))),Plus(Dist(Plus(a,Times(b,ArcSin(Times(c,x)))),Int(Times(Power(x,m),Power(Plus(d,Times(e,Sqr(x))),p)),x),x),Negate(Dist(Times(b,c,Power(d,Plus(p,Negate(C1D2))),Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),CN1D2)),Int(SimplifyIntegrand(Times(u,Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),CN1D2)),x),x),x)))),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(Plus(p,C1D2),C0),Or(IGtQ(Times(C1D2,Plus(m,C1)),C0),ILtQ(Times(C1D2,Plus(m,Times(C2,p),C3)),C0))))),
IIntegrate(4692,Int(Times(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),Power(x_,m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(With(List(Set(u,IntHide(Times(Power(x,m),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),p)),x))),Plus(Dist(Plus(a,Times(b,ArcCos(Times(c,x)))),Int(Times(Power(x,m),Power(Plus(d,Times(e,Sqr(x))),p)),x),x),Dist(Times(b,c,Power(d,Plus(p,Negate(C1D2))),Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),CN1D2)),Int(SimplifyIntegrand(Times(u,Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),CN1D2)),x),x),x))),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(Plus(p,C1D2),C0),Or(IGtQ(Times(C1D2,Plus(m,C1)),C0),ILtQ(Times(C1D2,Plus(m,Times(C2,p),C3)),C0))))),
IIntegrate(4693,Int(Times(Power(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Times(f_DEFAULT,x_),m_),Sqrt(Plus(d_,Times(e_DEFAULT,Sqr(x_))))),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(f,x),Plus(m,C1)),Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n),Power(Times(f,Plus(m,C1)),-1)),x),Negate(Dist(Times(b,c,n,Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Times(f,Plus(m,C1),Sqrt(Plus(C1,Times(CN1,Sqr(c),Sqr(x))))),-1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),Plus(n,Negate(C1)))),x),x)),Dist(Times(Sqr(c),Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Times(Sqr(f),Plus(m,C1),Sqrt(Plus(C1,Times(CN1,Sqr(c),Sqr(x))))),-1)),Int(Times(Power(Times(f,x),Plus(m,C2)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),CN1D2)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),LtQ(m,CN1)))),
IIntegrate(4694,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Times(f_DEFAULT,x_),m_),Sqrt(Plus(d_,Times(e_DEFAULT,Sqr(x_))))),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(f,x),Plus(m,C1)),Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n),Power(Times(f,Plus(m,C1)),-1)),x),Dist(Times(b,c,n,Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Times(f,Plus(m,C1),Sqrt(Plus(C1,Times(CN1,Sqr(c),Sqr(x))))),-1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),Plus(n,Negate(C1)))),x),x),Dist(Times(Sqr(c),Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Times(Sqr(f),Plus(m,C1),Sqrt(Plus(C1,Times(CN1,Sqr(c),Sqr(x))))),-1)),Int(Times(Power(Times(f,x),Plus(m,C2)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),CN1D2)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),LtQ(m,CN1)))),
IIntegrate(4695,Int(Times(Power(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(d,Times(e,Sqr(x))),p),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n),Power(Times(f,Plus(m,C1)),-1)),x),Negate(Dist(Times(C2,e,p,Power(Times(Sqr(f),Plus(m,C1)),-1)),Int(Times(Power(Times(f,x),Plus(m,C2)),Power(Plus(d,Times(e,Sqr(x))),Plus(p,Negate(C1))),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n)),x),x)),Negate(Dist(Times(b,c,n,Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(f,Plus(m,C1),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),FracPart(p))),-1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),Plus(p,Negate(C1D2))),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),Plus(n,Negate(C1)))),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),GtQ(p,C0),LtQ(m,CN1)))),
IIntegrate(4696,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(d,Times(e,Sqr(x))),p),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n),Power(Times(f,Plus(m,C1)),-1)),x),Negate(Dist(Times(C2,e,p,Power(Times(Sqr(f),Plus(m,C1)),-1)),Int(Times(Power(Times(f,x),Plus(m,C2)),Power(Plus(d,Times(e,Sqr(x))),Plus(p,Negate(C1))),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n)),x),x)),Dist(Times(b,c,n,Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(f,Plus(m,C1),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),FracPart(p))),-1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),Plus(p,Negate(C1D2))),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),Plus(n,Negate(C1)))),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),GtQ(p,C0),LtQ(m,CN1)))),
IIntegrate(4697,Int(Times(Power(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Times(f_DEFAULT,x_),m_),Sqrt(Plus(d_,Times(e_DEFAULT,Sqr(x_))))),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(f,x),Plus(m,C1)),Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n),Power(Times(f,Plus(m,C2)),-1)),x),Dist(Times(Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Times(Plus(m,C2),Sqrt(Plus(C1,Times(CN1,Sqr(c),Sqr(x))))),-1)),Int(Times(Power(Times(f,x),m),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),CN1D2)),x),x),Negate(Dist(Times(b,c,n,Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Times(f,Plus(m,C2),Sqrt(Plus(C1,Times(CN1,Sqr(c),Sqr(x))))),-1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),Plus(n,Negate(C1)))),x),x))),And(FreeQ(List(a,b,c,d,e,f,m),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),Not(LtQ(m,CN1)),Or(RationalQ(m),EqQ(n,C1))))),
IIntegrate(4698,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Times(f_DEFAULT,x_),m_),Sqrt(Plus(d_,Times(e_DEFAULT,Sqr(x_))))),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(f,x),Plus(m,C1)),Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n),Power(Times(f,Plus(m,C2)),-1)),x),Dist(Times(Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Times(Plus(m,C2),Sqrt(Plus(C1,Times(CN1,Sqr(c),Sqr(x))))),-1)),Int(Times(Power(Times(f,x),m),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),CN1D2)),x),x),Dist(Times(b,c,n,Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Times(f,Plus(m,C2),Sqrt(Plus(C1,Times(CN1,Sqr(c),Sqr(x))))),-1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),Plus(n,Negate(C1)))),x),x)),And(FreeQ(List(a,b,c,d,e,f,m),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),Not(LtQ(m,CN1)),Or(RationalQ(m),EqQ(n,C1))))),
IIntegrate(4699,Int(Times(Power(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(d,Times(e,Sqr(x))),p),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n),Power(Times(f,Plus(m,Times(C2,p),C1)),-1)),x),Dist(Times(C2,d,p,Power(Plus(m,Times(C2,p),C1),-1)),Int(Times(Power(Times(f,x),m),Power(Plus(d,Times(e,Sqr(x))),Plus(p,Negate(C1))),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n)),x),x),Negate(Dist(Times(b,c,n,Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(f,Plus(m,Times(C2,p),C1),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),FracPart(p))),-1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),Plus(p,Negate(C1D2))),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),Plus(n,Negate(C1)))),x),x))),And(FreeQ(List(a,b,c,d,e,f,m),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),GtQ(p,C0),Not(LtQ(m,CN1)),Or(RationalQ(m),EqQ(n,C1))))),
IIntegrate(4700,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(d,Times(e,Sqr(x))),p),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n),Power(Times(f,Plus(m,Times(C2,p),C1)),-1)),x),Dist(Times(C2,d,p,Power(Plus(m,Times(C2,p),C1),-1)),Int(Times(Power(Times(f,x),m),Power(Plus(d,Times(e,Sqr(x))),Plus(p,Negate(C1))),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n)),x),x),Dist(Times(b,c,n,Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(f,Plus(m,Times(C2,p),C1),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),FracPart(p))),-1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),Plus(p,Negate(C1D2))),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),Plus(n,Negate(C1)))),x),x)),And(FreeQ(List(a,b,c,d,e,f,m),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),GtQ(p,C0),Not(LtQ(m,CN1)),Or(RationalQ(m),EqQ(n,C1)))))
  );
}
