package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Cot;
import static org.matheclipse.core.expression.F.Csc;
import static org.matheclipse.core.expression.F.EllipticE;
import static org.matheclipse.core.expression.F.EllipticF;
import static org.matheclipse.core.expression.F.Expand;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.Hypergeometric2F1;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Pi;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.QQ;
import static org.matheclipse.core.expression.F.Sec;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Tan;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.a_DEFAULT;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandTrig;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/** 
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class IntRules52 { 
  public static IAST RULES = List( 
IIntegrate(2601,Int(Times(Power(Times(a_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT),Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_)),x_Symbol),
    Condition(Dist(Times(Power(Cos(Plus(e,Times(f,x))),n),Power(Times(b,Tan(Plus(e,Times(f,x)))),n),Power(Power(Times(a,Sin(Plus(e,Times(f,x)))),n),-1)),Int(Times(Power(Times(a,Sin(Plus(e,Times(f,x)))),Plus(m,n)),Power(Power(Cos(Plus(e,Times(f,x))),n),-1)),x),x),And(FreeQ(List(a,b,e,f,m,n),x),Not(IntegerQ(n)),Or(ILtQ(m,C0),And(EqQ(m,C1),EqQ(n,Negate(Power(C2,-1)))),IntegersQ(Plus(m,Negate(C1D2)),Plus(n,Negate(C1D2))))))),
IIntegrate(2602,Int(Times(Power(Times(a_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT),Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_)),x_Symbol),
    Condition(Dist(Times(a,Power(Cos(Plus(e,Times(f,x))),Plus(n,C1)),Power(Times(b,Tan(Plus(e,Times(f,x)))),Plus(n,C1)),Power(Times(b,Power(Times(a,Sin(Plus(e,Times(f,x)))),Plus(n,C1))),-1)),Int(Times(Power(Times(a,Sin(Plus(e,Times(f,x)))),Plus(m,n)),Power(Power(Cos(Plus(e,Times(f,x))),n),-1)),x),x),And(FreeQ(List(a,b,e,f,m,n),x),Not(IntegerQ(n))))),
IIntegrate(2603,Int(Times(Power(Times($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),a_DEFAULT),m_),Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_)),x_Symbol),
    Condition(Dist(Times(Power(Times(a,Cos(Plus(e,Times(f,x)))),FracPart(m)),Power(Times(Sec(Plus(e,Times(f,x))),Power(a,-1)),FracPart(m))),Int(Times(Power(Times(b,Tan(Plus(e,Times(f,x)))),n),Power(Power(Times(Sec(Plus(e,Times(f,x))),Power(a,-1)),m),-1)),x),x),And(FreeQ(List(a,b,e,f,m,n),x),Not(IntegerQ(m)),Not(IntegerQ(n))))),
IIntegrate(2604,Int(Times(Power(Times($($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),a_DEFAULT),m_),Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_)),x_Symbol),
    Condition(Dist(Times(Power(Times(a,Cot(Plus(e,Times(f,x)))),m),Power(Times(b,Tan(Plus(e,Times(f,x)))),m)),Int(Power(Times(b,Tan(Plus(e,Times(f,x)))),Plus(n,Negate(m))),x),x),And(FreeQ(List(a,b,e,f,m,n),x),Not(IntegerQ(m)),Not(IntegerQ(n))))),
IIntegrate(2605,Int(Times(Power(Times(a_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT),Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Negate(Simp(Times(Power(Times(a,Sec(Plus(e,Times(f,x)))),m),Power(Times(b,Tan(Plus(e,Times(f,x)))),Plus(n,C1)),Power(Times(b,f,m),-1)),x)),And(FreeQ(List(a,b,e,f,m,n),x),EqQ(Plus(m,n,C1),C0)))),
IIntegrate(2606,Int(Times(Power(Times(a_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT),Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Dist(Times(a,Power(f,-1)),Subst(Int(Times(Power(Times(a,x),Plus(m,Negate(C1))),Power(Plus(CN1,Sqr(x)),Times(C1D2,Plus(n,Negate(C1))))),x),x,Sec(Plus(e,Times(f,x)))),x),And(FreeQ(List(a,e,f,m),x),IntegerQ(Times(C1D2,Plus(n,Negate(C1)))),Not(And(IntegerQ(Times(C1D2,m)),LtQ(C0,m,Plus(n,C1))))))),
IIntegrate(2607,Int(Times(Power($($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),m_),Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Dist(Power(f,-1),Subst(Int(Times(Power(Times(b,x),n),Power(Plus(C1,Sqr(x)),Plus(Times(C1D2,m),Negate(C1)))),x),x,Tan(Plus(e,Times(f,x)))),x),And(FreeQ(List(b,e,f,n),x),IntegerQ(Times(C1D2,m)),Not(And(IntegerQ(Times(C1D2,Plus(n,Negate(C1)))),LtQ(C0,n,Plus(m,Negate(C1)))))))),
IIntegrate(2608,Int(Times(Power(Times(a_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT),Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_)),x_Symbol),
    Condition(Plus(Simp(Times(Sqr(a),Power(Times(a,Sec(Plus(e,Times(f,x)))),Plus(m,Negate(C2))),Power(Times(b,Tan(Plus(e,Times(f,x)))),Plus(n,C1)),Power(Times(b,f,Plus(n,C1)),-1)),x),Negate(Dist(Times(Sqr(a),Plus(m,Negate(C2)),Power(Times(Sqr(b),Plus(n,C1)),-1)),Int(Times(Power(Times(a,Sec(Plus(e,Times(f,x)))),Plus(m,Negate(C2))),Power(Times(b,Tan(Plus(e,Times(f,x)))),Plus(n,C2))),x),x))),And(FreeQ(List(a,b,e,f),x),LtQ(n,CN1),Or(GtQ(m,C1),And(EqQ(m,C1),EqQ(n,QQ(-3L,2L)))),IntegersQ(Times(C2,m),Times(C2,n))))),
IIntegrate(2609,Int(Times(Power(Times(a_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT),Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(a,Sec(Plus(e,Times(f,x)))),m),Power(Times(b,Tan(Plus(e,Times(f,x)))),Plus(n,C1)),Power(Times(b,f,Plus(n,C1)),-1)),x),Negate(Dist(Times(Plus(m,n,C1),Power(Times(Sqr(b),Plus(n,C1)),-1)),Int(Times(Power(Times(a,Sec(Plus(e,Times(f,x)))),m),Power(Times(b,Tan(Plus(e,Times(f,x)))),Plus(n,C2))),x),x))),And(FreeQ(List(a,b,e,f,m),x),LtQ(n,CN1),IntegersQ(Times(C2,m),Times(C2,n))))),
IIntegrate(2610,Int(Times(Power(Times(a_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_),Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_)),x_Symbol),
    Condition(Plus(Simp(Times(b,Power(Times(a,Sec(Plus(e,Times(f,x)))),m),Power(Times(b,Tan(Plus(e,Times(f,x)))),Plus(n,Negate(C1))),Power(Times(f,m),-1)),x),Negate(Dist(Times(Sqr(b),Plus(n,Negate(C1)),Power(Times(Sqr(a),m),-1)),Int(Times(Power(Times(a,Sec(Plus(e,Times(f,x)))),Plus(m,C2)),Power(Times(b,Tan(Plus(e,Times(f,x)))),Plus(n,Negate(C2)))),x),x))),And(FreeQ(List(a,b,e,f),x),GtQ(n,C1),Or(LtQ(m,CN1),And(EqQ(m,CN1),EqQ(n,QQ(3L,2L)))),IntegersQ(Times(C2,m),Times(C2,n))))),
IIntegrate(2611,Int(Times(Power(Times(a_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT),Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_)),x_Symbol),
    Condition(Plus(Simp(Times(b,Power(Times(a,Sec(Plus(e,Times(f,x)))),m),Power(Times(b,Tan(Plus(e,Times(f,x)))),Plus(n,Negate(C1))),Power(Times(f,Plus(m,n,Negate(C1))),-1)),x),Negate(Dist(Times(Sqr(b),Plus(n,Negate(C1)),Power(Plus(m,n,Negate(C1)),-1)),Int(Times(Power(Times(a,Sec(Plus(e,Times(f,x)))),m),Power(Times(b,Tan(Plus(e,Times(f,x)))),Plus(n,Negate(C2)))),x),x))),And(FreeQ(List(a,b,e,f,m),x),GtQ(n,C1),NeQ(Plus(m,n,Negate(C1)),C0),IntegersQ(Times(C2,m),Times(C2,n))))),
IIntegrate(2612,Int(Times(Power(Times(a_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_),Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Power(Times(a,Sec(Plus(e,Times(f,x)))),m),Power(Times(b,Tan(Plus(e,Times(f,x)))),Plus(n,C1)),Power(Times(b,f,m),-1)),x)),Dist(Times(Plus(m,n,C1),Power(Times(Sqr(a),m),-1)),Int(Times(Power(Times(a,Sec(Plus(e,Times(f,x)))),Plus(m,C2)),Power(Times(b,Tan(Plus(e,Times(f,x)))),n)),x),x)),And(FreeQ(List(a,b,e,f,n),x),Or(LtQ(m,CN1),And(EqQ(m,CN1),EqQ(n,Negate(Power(C2,-1))))),IntegersQ(Times(C2,m),Times(C2,n))))),
IIntegrate(2613,Int(Times(Power(Times(a_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT),Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_)),x_Symbol),
    Condition(Plus(Simp(Times(Sqr(a),Power(Times(a,Sec(Plus(e,Times(f,x)))),Plus(m,Negate(C2))),Power(Times(b,Tan(Plus(e,Times(f,x)))),Plus(n,C1)),Power(Times(b,f,Plus(m,n,Negate(C1))),-1)),x),Dist(Times(Sqr(a),Plus(m,Negate(C2)),Power(Plus(m,n,Negate(C1)),-1)),Int(Times(Power(Times(a,Sec(Plus(e,Times(f,x)))),Plus(m,Negate(C2))),Power(Times(b,Tan(Plus(e,Times(f,x)))),n)),x),x)),And(FreeQ(List(a,b,e,f,n),x),Or(GtQ(m,C1),And(EqQ(m,C1),EqQ(n,C1D2))),NeQ(Plus(m,n,Negate(C1)),C0),IntegersQ(Times(C2,m),Times(C2,n))))),
IIntegrate(2614,Int(Times($($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),CN1D2)),x_Symbol),
    Condition(Dist(Times(Sqrt(Sin(Plus(e,Times(f,x)))),Power(Times(Sqrt(Cos(Plus(e,Times(f,x)))),Sqrt(Times(b,Tan(Plus(e,Times(f,x)))))),-1)),Int(Power(Times(Sqrt(Cos(Plus(e,Times(f,x)))),Sqrt(Sin(Plus(e,Times(f,x))))),-1),x),x),FreeQ(List(b,e,f),x))),
IIntegrate(2615,Int(Times(Power($($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),-1),Sqrt(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(Dist(Times(Sqrt(Cos(Plus(e,Times(f,x)))),Sqrt(Times(b,Tan(Plus(e,Times(f,x))))),Power(Sin(Plus(e,Times(f,x))),CN1D2)),Int(Times(Sqrt(Cos(Plus(e,Times(f,x)))),Sqrt(Sin(Plus(e,Times(f,x))))),x),x),FreeQ(List(b,e,f),x))),
IIntegrate(2616,Int(Times(Power(Times(a_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_),Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_)),x_Symbol),
    Condition(Dist(Times(Power(a,Plus(m,n)),Power(Times(b,Tan(Plus(e,Times(f,x)))),n),Power(Times(Power(Times(a,Sec(Plus(e,Times(f,x)))),n),Power(Times(b,Sin(Plus(e,Times(f,x)))),n)),-1)),Int(Times(Power(Times(b,Sin(Plus(e,Times(f,x)))),n),Power(Power(Cos(Plus(e,Times(f,x))),Plus(m,n)),-1)),x),x),And(FreeQ(List(a,b,e,f,m,n),x),IntegerQ(Plus(n,C1D2)),IntegerQ(Plus(m,C1D2))))),
IIntegrate(2617,Int(Times(Power(Times(a_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT),Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_)),x_Symbol),
    Condition(Simp(Times(Power(Times(a,Sec(Plus(e,Times(f,x)))),m),Power(Times(b,Tan(Plus(e,Times(f,x)))),Plus(n,C1)),Power(Sqr(Cos(Plus(e,Times(f,x)))),Times(C1D2,Plus(m,n,C1))),Hypergeometric2F1(Times(C1D2,Plus(n,C1)),Times(C1D2,Plus(m,n,C1)),Times(C1D2,Plus(n,C3)),Sqr(Sin(Plus(e,Times(f,x))))),Power(Times(b,f,Plus(n,C1)),-1)),x),And(FreeQ(List(a,b,e,f,m,n),x),Not(IntegerQ(Times(C1D2,Plus(n,Negate(C1))))),Not(IntegerQ(Times(C1D2,m)))))),
IIntegrate(2618,Int(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),a_DEFAULT),m_),Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_)),x_Symbol),
    Condition(Dist(Times(Power(Times(a,Csc(Plus(e,Times(f,x)))),FracPart(m)),Power(Times(Sin(Plus(e,Times(f,x))),Power(a,-1)),FracPart(m))),Int(Times(Power(Times(b,Tan(Plus(e,Times(f,x)))),n),Power(Power(Times(Sin(Plus(e,Times(f,x))),Power(a,-1)),m),-1)),x),x),And(FreeQ(List(a,b,e,f,m,n),x),Not(IntegerQ(m)),Not(IntegerQ(n))))),
IIntegrate(2619,Int(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),a_DEFAULT),m_),Power(Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_)),x_Symbol),
    Condition(Simp(Times(a,b,Power(Times(a,Csc(Plus(e,Times(f,x)))),Plus(m,Negate(C1))),Power(Times(b,Sec(Plus(e,Times(f,x)))),Plus(n,Negate(C1))),Power(Times(f,Plus(n,Negate(C1))),-1)),x),And(FreeQ(List(a,b,e,f,m,n),x),EqQ(Plus(m,n,Negate(C2)),C0),NeQ(n,C1)))),
IIntegrate(2620,Int(Times(Power($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),m_DEFAULT),Power($($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),n_DEFAULT)),x_Symbol),
    Condition(Dist(Power(f,-1),Subst(Int(Times(Power(Plus(C1,Sqr(x)),Plus(Times(C1D2,Plus(m,n)),Negate(C1))),Power(Power(x,m),-1)),x),x,Tan(Plus(e,Times(f,x)))),x),And(FreeQ(List(e,f),x),IntegersQ(m,n,Times(C1D2,Plus(m,n)))))),
IIntegrate(2621,Int(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),a_DEFAULT),m_),Power($($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),n_DEFAULT)),x_Symbol),
    Condition(Negate(Dist(Power(Times(f,Power(a,n)),-1),Subst(Int(Times(Power(x,Plus(m,n,Negate(C1))),Power(Power(Plus(CN1,Times(Sqr(x),Power(a,-2))),Times(C1D2,Plus(n,C1))),-1)),x),x,Times(a,Csc(Plus(e,Times(f,x))))),x)),And(FreeQ(List(a,e,f,m),x),IntegerQ(Times(C1D2,Plus(n,C1))),Not(And(IntegerQ(Times(C1D2,Plus(m,C1))),LtQ(C0,m,n)))))),
IIntegrate(2622,Int(Times(Power($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),n_DEFAULT),Power(Times(a_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_)),x_Symbol),
    Condition(Dist(Power(Times(f,Power(a,n)),-1),Subst(Int(Times(Power(x,Plus(m,n,Negate(C1))),Power(Power(Plus(CN1,Times(Sqr(x),Power(a,-2))),Times(C1D2,Plus(n,C1))),-1)),x),x,Times(a,Sec(Plus(e,Times(f,x))))),x),And(FreeQ(List(a,e,f,m),x),IntegerQ(Times(C1D2,Plus(n,C1))),Not(And(IntegerQ(Times(C1D2,Plus(m,C1))),LtQ(C0,m,n)))))),
IIntegrate(2623,Int(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),a_DEFAULT),m_),Power(Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(a,Power(Times(a,Csc(Plus(e,Times(f,x)))),Plus(m,Negate(C1))),Power(Times(b,Sec(Plus(e,Times(f,x)))),Plus(n,C1)),Power(Times(f,b,Plus(m,Negate(C1))),-1)),x)),Dist(Times(Sqr(a),Plus(n,C1),Power(Times(Sqr(b),Plus(m,Negate(C1))),-1)),Int(Times(Power(Times(a,Csc(Plus(e,Times(f,x)))),Plus(m,Negate(C2))),Power(Times(b,Sec(Plus(e,Times(f,x)))),Plus(n,C2))),x),x)),And(FreeQ(List(a,b,e,f),x),GtQ(m,C1),LtQ(n,CN1),IntegersQ(Times(C2,m),Times(C2,n))))),
IIntegrate(2624,Int(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),a_DEFAULT),m_),Power(Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_)),x_Symbol),
    Condition(Plus(Simp(Times(b,Power(Times(a,Csc(Plus(e,Times(f,x)))),Plus(m,C1)),Power(Times(b,Sec(Plus(e,Times(f,x)))),Plus(n,Negate(C1))),Power(Times(f,a,Plus(n,Negate(C1))),-1)),x),Dist(Times(Sqr(b),Plus(m,C1),Power(Times(Sqr(a),Plus(n,Negate(C1))),-1)),Int(Times(Power(Times(a,Csc(Plus(e,Times(f,x)))),Plus(m,C2)),Power(Times(b,Sec(Plus(e,Times(f,x)))),Plus(n,Negate(C2)))),x),x)),And(FreeQ(List(a,b,e,f),x),GtQ(n,C1),LtQ(m,CN1),IntegersQ(Times(C2,m),Times(C2,n))))),
IIntegrate(2625,Int(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),a_DEFAULT),m_),Power(Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(a,b,Power(Times(a,Csc(Plus(e,Times(f,x)))),Plus(m,Negate(C1))),Power(Times(b,Sec(Plus(e,Times(f,x)))),Plus(n,Negate(C1))),Power(Times(f,Plus(m,Negate(C1))),-1)),x)),Dist(Times(Sqr(a),Plus(m,n,Negate(C2)),Power(Plus(m,Negate(C1)),-1)),Int(Times(Power(Times(a,Csc(Plus(e,Times(f,x)))),Plus(m,Negate(C2))),Power(Times(b,Sec(Plus(e,Times(f,x)))),n)),x),x)),And(FreeQ(List(a,b,e,f,n),x),GtQ(m,C1),IntegersQ(Times(C2,m),Times(C2,n)),Not(GtQ(n,m))))),
IIntegrate(2626,Int(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),a_DEFAULT),m_DEFAULT),Power(Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_)),x_Symbol),
    Condition(Plus(Simp(Times(a,b,Power(Times(a,Csc(Plus(e,Times(f,x)))),Plus(m,Negate(C1))),Power(Times(b,Sec(Plus(e,Times(f,x)))),Plus(n,Negate(C1))),Power(Times(f,Plus(n,Negate(C1))),-1)),x),Dist(Times(Sqr(b),Plus(m,n,Negate(C2)),Power(Plus(n,Negate(C1)),-1)),Int(Times(Power(Times(a,Csc(Plus(e,Times(f,x)))),m),Power(Times(b,Sec(Plus(e,Times(f,x)))),Plus(n,Negate(C2)))),x),x)),And(FreeQ(List(a,b,e,f,m),x),GtQ(n,C1),IntegersQ(Times(C2,m),Times(C2,n))))),
IIntegrate(2627,Int(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),a_DEFAULT),m_),Power(Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(b,Power(Times(a,Csc(Plus(e,Times(f,x)))),Plus(m,C1)),Power(Times(b,Sec(Plus(e,Times(f,x)))),Plus(n,Negate(C1))),Power(Times(a,f,Plus(m,n)),-1)),x),Dist(Times(Plus(m,C1),Power(Times(Sqr(a),Plus(m,n)),-1)),Int(Times(Power(Times(a,Csc(Plus(e,Times(f,x)))),Plus(m,C2)),Power(Times(b,Sec(Plus(e,Times(f,x)))),n)),x),x)),And(FreeQ(List(a,b,e,f,n),x),LtQ(m,CN1),NeQ(Plus(m,n),C0),IntegersQ(Times(C2,m),Times(C2,n))))),
IIntegrate(2628,Int(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),a_DEFAULT),m_DEFAULT),Power(Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(a,Power(Times(a,Csc(Plus(e,Times(f,x)))),Plus(m,Negate(C1))),Power(Times(b,Sec(Plus(e,Times(f,x)))),Plus(n,C1)),Power(Times(b,f,Plus(m,n)),-1)),x)),Dist(Times(Plus(n,C1),Power(Times(Sqr(b),Plus(m,n)),-1)),Int(Times(Power(Times(a,Csc(Plus(e,Times(f,x)))),m),Power(Times(b,Sec(Plus(e,Times(f,x)))),Plus(n,C2))),x),x)),And(FreeQ(List(a,b,e,f,m),x),LtQ(n,CN1),NeQ(Plus(m,n),C0),IntegersQ(Times(C2,m),Times(C2,n))))),
IIntegrate(2629,Int(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),a_DEFAULT),m_),Power(Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_)),x_Symbol),
    Condition(Dist(Times(Power(Times(a,Csc(Plus(e,Times(f,x)))),m),Power(Times(b,Sec(Plus(e,Times(f,x)))),n),Power(Power(Tan(Plus(e,Times(f,x))),n),-1)),Int(Power(Tan(Plus(e,Times(f,x))),n),x),x),And(FreeQ(List(a,b,e,f,m,n),x),Not(IntegerQ(n)),EqQ(Plus(m,n),C0)))),
IIntegrate(2630,Int(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),a_DEFAULT),m_),Power(Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_)),x_Symbol),
    Condition(Dist(Times(Power(Times(a,Csc(Plus(e,Times(f,x)))),m),Power(Times(b,Sec(Plus(e,Times(f,x)))),n),Power(Times(a,Sin(Plus(e,Times(f,x)))),m),Power(Times(b,Cos(Plus(e,Times(f,x)))),n)),Int(Power(Times(Power(Times(a,Sin(Plus(e,Times(f,x)))),m),Power(Times(b,Cos(Plus(e,Times(f,x)))),n)),-1),x),x),And(FreeQ(List(a,b,e,f,m,n),x),IntegerQ(Plus(m,Negate(C1D2))),IntegerQ(Plus(n,Negate(C1D2)))))),
IIntegrate(2631,Int(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),a_DEFAULT),m_),Power(Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_)),x_Symbol),
    Condition(Dist(Times(Sqr(a),Power(Times(a,Csc(Plus(e,Times(f,x)))),Plus(m,Negate(C1))),Power(Times(b,Sec(Plus(e,Times(f,x)))),Plus(n,C1)),Power(Times(a,Sin(Plus(e,Times(f,x)))),Plus(m,Negate(C1))),Power(Times(b,Cos(Plus(e,Times(f,x)))),Plus(n,C1)),Power(b,-2)),Int(Power(Times(Power(Times(a,Sin(Plus(e,Times(f,x)))),m),Power(Times(b,Cos(Plus(e,Times(f,x)))),n)),-1),x),x),And(FreeQ(List(a,b,e,f,m,n),x),Not(SimplerQ(Negate(m),Negate(n)))))),
IIntegrate(2632,Int(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),n_),Power(Times(a_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_)),x_Symbol),
    Condition(Dist(Times(Sqr(a),Power(Times(a,Sec(Plus(e,Times(f,x)))),Plus(m,Negate(C1))),Power(Times(b,Csc(Plus(e,Times(f,x)))),Plus(n,C1)),Power(Times(a,Cos(Plus(e,Times(f,x)))),Plus(m,Negate(C1))),Power(Times(b,Sin(Plus(e,Times(f,x)))),Plus(n,C1)),Power(b,-2)),Int(Power(Times(Power(Times(a,Cos(Plus(e,Times(f,x)))),m),Power(Times(b,Sin(Plus(e,Times(f,x)))),n)),-1),x),x),FreeQ(List(a,b,e,f,m,n),x))),
IIntegrate(2633,Int(Power($($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_),x_Symbol),
    Condition(Negate(Dist(Power(d,-1),Subst(Int(Expand(Power(Plus(C1,Negate(Sqr(x))),Times(C1D2,Plus(n,Negate(C1)))),x),x),x,Cos(Plus(c,Times(d,x)))),x)),And(FreeQ(List(c,d),x),IGtQ(Times(C1D2,Plus(n,Negate(C1))),C0)))),
IIntegrate(2634,Int(Sqr($($s("§sin"),Plus(c_DEFAULT,Times(C1D2,d_DEFAULT,x_)))),x_Symbol),
    Condition(Plus(Simp(Times(C1D2,x),x),Negate(Simp(Times(Sin(Plus(Times(C2,c),Times(d,x))),Power(Times(C2,d),-1)),x))),FreeQ(List(c,d),x))),
IIntegrate(2635,Int(Power(Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),n_),x_Symbol),
    Condition(Plus(Negate(Simp(Times(b,Cos(Plus(c,Times(d,x))),Power(Times(b,Sin(Plus(c,Times(d,x)))),Plus(n,Negate(C1))),Power(Times(d,n),-1)),x)),Dist(Times(Sqr(b),Plus(n,Negate(C1)),Power(n,-1)),Int(Power(Times(b,Sin(Plus(c,Times(d,x)))),Plus(n,Negate(C2))),x),x)),And(FreeQ(List(b,c,d),x),GtQ(n,C1),IntegerQ(Times(C2,n))))),
IIntegrate(2636,Int(Power(Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),n_),x_Symbol),
    Condition(Plus(Simp(Times(Cos(Plus(c,Times(d,x))),Power(Times(b,Sin(Plus(c,Times(d,x)))),Plus(n,C1)),Power(Times(b,d,Plus(n,C1)),-1)),x),Dist(Times(Plus(n,C2),Power(Times(Sqr(b),Plus(n,C1)),-1)),Int(Power(Times(b,Sin(Plus(c,Times(d,x)))),Plus(n,C2)),x),x)),And(FreeQ(List(b,c,d),x),LtQ(n,CN1),IntegerQ(Times(C2,n))))),
IIntegrate(2637,Int($($s("§sin"),Plus(Times(C1D2,Pi),c_DEFAULT,Times(d_DEFAULT,x_))),x_Symbol),
    Condition(Simp(Times(Sin(Plus(c,Times(d,x))),Power(d,-1)),x),FreeQ(List(c,d),x))),
IIntegrate(2638,Int($($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),x_Symbol),
    Condition(Negate(Simp(Times(Cos(Plus(c,Times(d,x))),Power(d,-1)),x)),FreeQ(List(c,d),x))),
IIntegrate(2639,Int(Sqrt($($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),x_Symbol),
    Condition(Simp(Times(C2,EllipticE(Times(C1D2,C1,Plus(c,Times(CN1,C1D2,Pi),Times(d,x))),C2),Power(d,-1)),x),FreeQ(List(c,d),x))),
IIntegrate(2640,Int(Sqrt(Times(b_,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),x_Symbol),
    Condition(Dist(Times(Sqrt(Times(b,Sin(Plus(c,Times(d,x))))),Power(Sin(Plus(c,Times(d,x))),CN1D2)),Int(Sqrt(Sin(Plus(c,Times(d,x)))),x),x),FreeQ(List(b,c,d),x))),
IIntegrate(2641,Int(Power($($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),CN1D2),x_Symbol),
    Condition(Simp(Times(C2,EllipticF(Times(C1D2,C1,Plus(c,Times(CN1,C1D2,Pi),Times(d,x))),C2),Power(d,-1)),x),FreeQ(List(c,d),x))),
IIntegrate(2642,Int(Power(Times(b_,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),CN1D2),x_Symbol),
    Condition(Dist(Times(Sqrt(Sin(Plus(c,Times(d,x)))),Power(Times(b,Sin(Plus(c,Times(d,x)))),CN1D2)),Int(Power(Sin(Plus(c,Times(d,x))),CN1D2),x),x),FreeQ(List(b,c,d),x))),
IIntegrate(2643,Int(Power(Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),n_),x_Symbol),
    Condition(Simp(Times(Cos(Plus(c,Times(d,x))),Power(Times(b,Sin(Plus(c,Times(d,x)))),Plus(n,C1)),Hypergeometric2F1(C1D2,Times(C1D2,Plus(n,C1)),Times(C1D2,Plus(n,C3)),Sqr(Sin(Plus(c,Times(d,x))))),Power(Times(b,d,Plus(n,C1),Sqrt(Sqr(Cos(Plus(c,Times(d,x)))))),-1)),x),And(FreeQ(List(b,c,d,n),x),Not(IntegerQ(Times(C2,n)))))),
IIntegrate(2644,Int(Sqr(Plus(a_,Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(C1D2,Plus(Times(C2,Sqr(a)),Sqr(b)),x),x),Negate(Simp(Times(C2,a,b,Cos(Plus(c,Times(d,x))),Power(d,-1)),x)),Negate(Simp(Times(Sqr(b),Cos(Plus(c,Times(d,x))),Sin(Plus(c,Times(d,x))),Power(Times(C2,d),-1)),x))),FreeQ(List(a,b,c,d),x))),
IIntegrate(2645,Int(Power(Plus(a_,Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_),x_Symbol),
    Condition(Int(ExpandTrig(Power(Plus(a,Times(b,$($s("§sin"),Plus(c,Times(d,x))))),n),x),x),And(FreeQ(List(a,b,c,d,n),x),EqQ(Plus(Sqr(a),Negate(Sqr(b))),C0),IGtQ(n,C0)))),
IIntegrate(2646,Int(Sqrt(Plus(a_,Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))))),x_Symbol),
    Condition(Simp(Times(CN2,b,Cos(Plus(c,Times(d,x))),Power(Times(d,Sqrt(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))))),-1)),x),And(FreeQ(List(a,b,c,d),x),EqQ(Plus(Sqr(a),Negate(Sqr(b))),C0)))),
IIntegrate(2647,Int(Power(Plus(a_,Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_),x_Symbol),
    Condition(Plus(Negate(Simp(Times(b,Cos(Plus(c,Times(d,x))),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,Negate(C1))),Power(Times(d,n),-1)),x)),Dist(Times(a,Plus(Times(C2,n),Negate(C1)),Power(n,-1)),Int(Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,Negate(C1))),x),x)),And(FreeQ(List(a,b,c,d),x),EqQ(Plus(Sqr(a),Negate(Sqr(b))),C0),IGtQ(Plus(n,Negate(C1D2)),C0)))),
IIntegrate(2648,Int(Power(Plus(a_,Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),-1),x_Symbol),
    Condition(Negate(Simp(Times(Cos(Plus(c,Times(d,x))),Power(Times(d,Plus(b,Times(a,Sin(Plus(c,Times(d,x)))))),-1)),x)),And(FreeQ(List(a,b,c,d),x),EqQ(Plus(Sqr(a),Negate(Sqr(b))),C0)))),
IIntegrate(2649,Int(Power(Plus(a_,Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),CN1D2),x_Symbol),
    Condition(Dist(Times(CN2,Power(d,-1)),Subst(Int(Power(Plus(Times(C2,a),Negate(Sqr(x))),-1),x),x,Times(b,Cos(Plus(c,Times(d,x))),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),CN1D2))),x),And(FreeQ(List(a,b,c,d),x),EqQ(Plus(Sqr(a),Negate(Sqr(b))),C0)))),
IIntegrate(2650,Int(Power(Plus(a_,Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_),x_Symbol),
    Condition(Plus(Simp(Times(b,Cos(Plus(c,Times(d,x))),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),n),Power(Times(a,d,Plus(Times(C2,n),C1)),-1)),x),Dist(Times(Plus(n,C1),Power(Times(a,Plus(Times(C2,n),C1)),-1)),Int(Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,C1)),x),x)),And(FreeQ(List(a,b,c,d),x),EqQ(Plus(Sqr(a),Negate(Sqr(b))),C0),LtQ(n,CN1),IntegerQ(Times(C2,n)))))
  );
}