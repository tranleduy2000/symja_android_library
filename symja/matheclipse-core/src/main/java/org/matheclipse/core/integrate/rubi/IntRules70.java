package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcTanh;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.C5;
import static org.matheclipse.core.expression.F.CI;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.CN4;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Csc;
import static org.matheclipse.core.expression.F.Expand;
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
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.a_DEFAULT;
import static org.matheclipse.core.expression.F.b;
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
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PerfectSquareQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RemoveContent;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/** 
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class IntRules70 { 
  public static IAST RULES = List( 
IIntegrate(3501,Int(Times(Power(Times(d_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Plus(Simp(Times(Sqr(d),Power(Times(d,Sec(Plus(e,Times(f,x)))),Plus(m,Negate(C2))),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Plus(n,C1)),Power(Times(b,f,Plus(m,n,Negate(C1))),-1)),x),Dist(Times(Sqr(d),Plus(m,Negate(C2)),Power(Times(a,Plus(m,n,Negate(C1))),-1)),Int(Times(Power(Times(d,Sec(Plus(e,Times(f,x)))),Plus(m,Negate(C2))),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Plus(n,C1))),x),x)),And(FreeQ(List(a,b,d,e,f),x),EqQ(Plus(Sqr(a),Sqr(b)),C0),LtQ(n,C0),GtQ(m,C1),Not(ILtQ(Plus(m,n),C0)),NeQ(Plus(m,n,Negate(C1)),C0),IntegersQ(Times(C2,m),Times(C2,n))))),
IIntegrate(3502,Int(Times(Power(Times(d_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Plus(Simp(Times(a,Power(Times(d,Sec(Plus(e,Times(f,x)))),m),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),n),Power(Times(b,f,Plus(m,Times(C2,n))),-1)),x),Dist(Times(Simplify(Plus(m,n)),Power(Times(a,Plus(m,Times(C2,n))),-1)),Int(Times(Power(Times(d,Sec(Plus(e,Times(f,x)))),m),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Plus(n,C1))),x),x)),And(FreeQ(List(a,b,d,e,f,m),x),EqQ(Plus(Sqr(a),Sqr(b)),C0),LtQ(n,C0),NeQ(Plus(m,Times(C2,n)),C0),IntegersQ(Times(C2,m),Times(C2,n))))),
IIntegrate(3503,Int(Times(Power(Times(d_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Plus(Simp(Times(b,Power(Times(d,Sec(Plus(e,Times(f,x)))),m),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Plus(n,Negate(C1))),Power(Times(f,Simplify(Plus(m,n,Negate(C1)))),-1)),x),Dist(Times(a,Plus(m,Times(C2,n),Negate(C2)),Power(Simplify(Plus(m,n,Negate(C1))),-1)),Int(Times(Power(Times(d,Sec(Plus(e,Times(f,x)))),m),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Plus(n,Negate(C1)))),x),x)),And(FreeQ(List(a,b,d,e,f,m,n),x),EqQ(Plus(Sqr(a),Sqr(b)),C0),IGtQ(Simplify(Plus(m,n,Negate(C1))),C0),RationalQ(n)))),
IIntegrate(3504,Int(Times(Power(Times(d_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Plus(Simp(Times(a,Power(Times(d,Sec(Plus(e,Times(f,x)))),m),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),n),Power(Times(b,f,Plus(m,Times(C2,n))),-1)),x),Dist(Times(Simplify(Plus(m,n)),Power(Times(a,Plus(m,Times(C2,n))),-1)),Int(Times(Power(Times(d,Sec(Plus(e,Times(f,x)))),m),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Plus(n,C1))),x),x)),And(FreeQ(List(a,b,d,e,f,m,n),x),EqQ(Plus(Sqr(a),Sqr(b)),C0),ILtQ(Simplify(Plus(m,n)),C0),NeQ(Plus(m,Times(C2,n)),C0)))),
IIntegrate(3505,Int(Times(Power(Times(d_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(Times(d,Sec(Plus(e,Times(f,x)))),m),Power(Times(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Times(C1D2,m)),Power(Plus(a,Times(CN1,b,Tan(Plus(e,Times(f,x))))),Times(C1D2,m))),-1)),Int(Times(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Plus(Times(C1D2,m),n)),Power(Plus(a,Times(CN1,b,Tan(Plus(e,Times(f,x))))),Times(C1D2,m))),x),x),And(FreeQ(List(a,b,d,e,f,m,n),x),EqQ(Plus(Sqr(a),Sqr(b)),C0)))),
IIntegrate(3506,Int(Times(Power($($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),m_),Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Dist(Power(Times(b,f),-1),Subst(Int(Times(Power(Plus(a,x),n),Power(Plus(C1,Times(Sqr(x),Power(b,-2))),Plus(Times(C1D2,m),Negate(C1)))),x),x,Times(b,Tan(Plus(e,Times(f,x))))),x),And(FreeQ(List(a,b,e,f,n),x),NeQ(Plus(Sqr(a),Sqr(b)),C0),IntegerQ(Times(C1D2,m))))),
IIntegrate(3507,Int(Times(Power($($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),-1),Sqr(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Simp(Times(Sqr(b),ArcTanh(Sin(Plus(e,Times(f,x)))),Power(f,-1)),x),Negate(Simp(Times(C2,a,b,Cos(Plus(e,Times(f,x))),Power(f,-1)),x)),Simp(Times(Plus(Sqr(a),Negate(Sqr(b))),Sin(Plus(e,Times(f,x))),Power(f,-1)),x)),And(FreeQ(List(a,b,e,f),x),NeQ(Plus(Sqr(a),Sqr(b)),C0)))),
IIntegrate(3508,Int(Times(Power(Times(d_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT),Sqr(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Simp(Times(b,Power(Times(d,Sec(Plus(e,Times(f,x)))),m),Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Power(Times(f,Plus(m,C1)),-1)),x),Dist(Power(Plus(m,C1),-1),Int(Times(Power(Times(d,Sec(Plus(e,Times(f,x)))),m),Plus(Times(Sqr(a),Plus(m,C1)),Negate(Sqr(b)),Times(a,b,Plus(m,C2),Tan(Plus(e,Times(f,x)))))),x),x)),And(FreeQ(List(a,b,d,e,f,m),x),NeQ(Plus(Sqr(a),Sqr(b)),C0),NeQ(m,CN1)))),
IIntegrate(3509,Int(Times($($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Negate(Dist(Power(f,-1),Subst(Int(Power(Plus(Sqr(a),Sqr(b),Negate(Sqr(x))),-1),x),x,Times(Plus(b,Times(CN1,a,Tan(Plus(e,Times(f,x))))),Power(Sec(Plus(e,Times(f,x))),-1))),x)),And(FreeQ(List(a,b,e,f),x),NeQ(Plus(Sqr(a),Sqr(b)),C0)))),
IIntegrate(3510,Int(Times(Power(Times(d_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_),Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Plus(Negate(Dist(Times(Sqr(d),Power(b,-2)),Int(Times(Power(Times(d,Sec(Plus(e,Times(f,x)))),Plus(m,Negate(C2))),Plus(a,Times(CN1,b,Tan(Plus(e,Times(f,x)))))),x),x)),Dist(Times(Sqr(d),Plus(Sqr(a),Sqr(b)),Power(b,-2)),Int(Times(Power(Times(d,Sec(Plus(e,Times(f,x)))),Plus(m,Negate(C2))),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),-1)),x),x)),And(FreeQ(List(a,b,d,e,f),x),NeQ(Plus(Sqr(a),Sqr(b)),C0),IGtQ(m,C1)))),
IIntegrate(3511,Int(Times(Power(Times(d_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_),Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Plus(Dist(Power(Plus(Sqr(a),Sqr(b)),-1),Int(Times(Power(Times(d,Sec(Plus(e,Times(f,x)))),m),Plus(a,Times(CN1,b,Tan(Plus(e,Times(f,x)))))),x),x),Dist(Times(Sqr(b),Power(Times(Sqr(d),Plus(Sqr(a),Sqr(b))),-1)),Int(Times(Power(Times(d,Sec(Plus(e,Times(f,x)))),Plus(m,C2)),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),-1)),x),x)),And(FreeQ(List(a,b,d,e,f),x),NeQ(Plus(Sqr(a),Sqr(b)),C0),ILtQ(m,C0)))),
IIntegrate(3512,Int(Times(Power(Times(d_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Dist(Times(Power(d,Times(C2,IntPart(Times(C1D2,m)))),Power(Times(d,Sec(Plus(e,Times(f,x)))),Times(C2,FracPart(Times(C1D2,m)))),Power(Times(b,f,Power(Sqr(Sec(Plus(e,Times(f,x)))),FracPart(Times(C1D2,m)))),-1)),Subst(Int(Times(Power(Plus(a,x),n),Power(Plus(C1,Times(Sqr(x),Power(b,-2))),Plus(Times(C1D2,m),Negate(C1)))),x),x,Times(b,Tan(Plus(e,Times(f,x))))),x),And(FreeQ(List(a,b,d,e,f,m,n),x),NeQ(Plus(Sqr(a),Sqr(b)),C0),Not(IntegerQ(Times(C1D2,m)))))),
IIntegrate(3513,Int(Times(Power(Times($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),d_DEFAULT),CN1D2),Sqrt(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),x_Symbol),
    Condition(Dist(Times(CN4,b,Power(f,-1)),Subst(Int(Times(Sqr(x),Power(Plus(Times(Sqr(a),Sqr(d)),Power(x,4)),-1)),x),x,Times(Sqrt(Times(d,Cos(Plus(e,Times(f,x))))),Sqrt(Plus(a,Times(b,Tan(Plus(e,Times(f,x)))))))),x),And(FreeQ(List(a,b,d,e,f),x),EqQ(Plus(Sqr(a),Sqr(b)),C0)))),
IIntegrate(3514,Int(Times(Power(Times($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),d_DEFAULT),QQ(-3L,2L)),Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),CN1D2)),x_Symbol),
    Condition(Dist(Power(Times(d,Cos(Plus(e,Times(f,x))),Sqrt(Plus(a,Times(CN1,b,Tan(Plus(e,Times(f,x)))))),Sqrt(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))))),-1),Int(Times(Sqrt(Plus(a,Times(CN1,b,Tan(Plus(e,Times(f,x)))))),Power(Times(d,Cos(Plus(e,Times(f,x)))),CN1D2)),x),x),And(FreeQ(List(a,b,d,e,f),x),EqQ(Plus(Sqr(a),Sqr(b)),C0)))),
IIntegrate(3515,Int(Times(Power(Times($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),d_DEFAULT),m_),Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(Times(d,Cos(Plus(e,Times(f,x)))),m),Power(Times(d,Sec(Plus(e,Times(f,x)))),m)),Int(Times(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),n),Power(Power(Times(d,Sec(Plus(e,Times(f,x)))),m),-1)),x),x),And(FreeQ(List(a,b,d,e,f,m,n),x),Not(IntegerQ(m))))),
IIntegrate(3516,Int(Times(Power($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),m_),Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Dist(Times(b,Power(f,-1)),Subst(Int(Times(Power(x,m),Power(Plus(a,x),n),Power(Power(Plus(Sqr(b),Sqr(x)),Plus(Times(C1D2,m),C1)),-1)),x),x,Times(b,Tan(Plus(e,Times(f,x))))),x),And(FreeQ(List(a,b,e,f,n),x),IntegerQ(Times(C1D2,m))))),
IIntegrate(3517,Int(Times(Power($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT)),x_Symbol),
    Condition(Int(Expand(Times(Power(Sin(Plus(e,Times(f,x))),m),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),n)),x),x),And(FreeQ(List(a,b,e,f),x),IntegerQ(Times(C1D2,Plus(m,Negate(C1)))),IGtQ(n,C0)))),
IIntegrate(3518,Int(Times(Power($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(Sin(Plus(e,Times(f,x))),m),Power(Plus(Times(a,Cos(Plus(e,Times(f,x)))),Times(b,Sin(Plus(e,Times(f,x))))),n),Power(Power(Cos(Plus(e,Times(f,x))),n),-1)),x),And(FreeQ(List(a,b,e,f),x),IntegerQ(Times(C1D2,Plus(m,Negate(C1)))),ILtQ(n,C0),Or(And(LtQ(m,C5),GtQ(n,CN4)),And(EqQ(m,C5),EqQ(n,CN1)))))),
IIntegrate(3519,Int(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),d_DEFAULT),m_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(Times(d,Csc(Plus(e,Times(f,x)))),FracPart(m)),Power(Times(Sin(Plus(e,Times(f,x))),Power(d,-1)),FracPart(m))),Int(Times(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),n),Power(Power(Times(Sin(Plus(e,Times(f,x))),Power(d,-1)),m),-1)),x),x),And(FreeQ(List(a,b,d,e,f,m,n),x),Not(IntegerQ(m))))),
IIntegrate(3520,Int(Times(Power($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),m_DEFAULT),Power($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),p_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(Cos(Plus(e,Times(f,x))),Plus(m,Negate(n))),Power(Sin(Plus(e,Times(f,x))),p),Power(Plus(Times(a,Cos(Plus(e,Times(f,x)))),Times(b,Sin(Plus(e,Times(f,x))))),n)),x),And(FreeQ(List(a,b,e,f,m,p),x),IntegerQ(n)))),
IIntegrate(3521,Int(Times(Power($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),p_DEFAULT),Power(Plus(Times($($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_),n_DEFAULT),Power($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),m_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(Sin(Plus(e,Times(f,x))),Plus(m,Negate(n))),Power(Cos(Plus(e,Times(f,x))),p),Power(Plus(Times(a,Sin(Plus(e,Times(f,x)))),Times(b,Cos(Plus(e,Times(f,x))))),n)),x),And(FreeQ(List(a,b,e,f,m,p),x),IntegerQ(n)))),
IIntegrate(3522,Int(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Plus(c_,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(a,m),Power(c,m)),Int(Times(Power(Sec(Plus(e,Times(f,x))),Times(C2,m)),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),Plus(n,Negate(m)))),x),x),And(FreeQ(List(a,b,c,d,e,f,n),x),EqQ(Plus(Times(b,c),Times(a,d)),C0),EqQ(Plus(Sqr(a),Sqr(b)),C0),IntegerQ(m),Not(And(IGtQ(n,C0),Or(LtQ(m,C0),GtQ(m,n))))))),
IIntegrate(3523,Int(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_),Power(Plus(c_,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Dist(Times(a,c,Power(f,-1)),Subst(Int(Times(Power(Plus(a,Times(b,x)),Plus(m,Negate(C1))),Power(Plus(c,Times(d,x)),Plus(n,Negate(C1)))),x),x,Tan(Plus(e,Times(f,x)))),x),And(FreeQ(List(a,b,c,d,e,f,m,n),x),EqQ(Plus(Times(b,c),Times(a,d)),C0),EqQ(Plus(Sqr(a),Sqr(b)),C0)))),
IIntegrate(3524,Int(Times(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),Plus(c_,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(Plus(Times(a,c),Times(CN1,b,d)),x),x),Simp(Times(b,d,Tan(Plus(e,Times(f,x))),Power(f,-1)),x)),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),EqQ(Plus(Times(b,c),Times(a,d)),C0)))),
IIntegrate(3525,Int(Times(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(Plus(Times(a,c),Times(CN1,b,d)),x),x),Dist(Plus(Times(b,c),Times(a,d)),Int(Tan(Plus(e,Times(f,x))),x),x),Simp(Times(b,d,Tan(Plus(e,Times(f,x))),Power(f,-1)),x)),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),NeQ(Plus(Times(b,c),Times(a,d)),C0)))),
IIntegrate(3526,Int(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_),Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Plus(Times(b,c),Times(CN1,a,d)),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),m),Power(Times(C2,a,f,m),-1)),x)),Dist(Times(Plus(Times(b,c),Times(a,d)),Power(Times(C2,a,b),-1)),Int(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Plus(m,C1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),EqQ(Plus(Sqr(a),Sqr(b)),C0),LtQ(m,C0)))),
IIntegrate(3527,Int(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_),Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(d,Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),m),Power(Times(f,m),-1)),x),Dist(Times(Plus(Times(b,c),Times(a,d)),Power(b,-1)),Int(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),m),x),x)),And(FreeQ(List(a,b,c,d,e,f,m),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),EqQ(Plus(Sqr(a),Sqr(b)),C0),Not(LtQ(m,C0))))),
IIntegrate(3528,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_),Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(d,Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),m),Power(Times(f,m),-1)),x),Int(Times(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Plus(m,Negate(C1))),Simp(Plus(Times(a,c),Times(CN1,b,d),Times(Plus(Times(b,c),Times(a,d)),Tan(Plus(e,Times(f,x))))),x)),x)),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),NeQ(Plus(Sqr(a),Sqr(b)),C0),GtQ(m,C0)))),
IIntegrate(3529,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_),Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(Plus(Times(b,c),Times(CN1,a,d)),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Plus(m,C1)),Power(Times(f,Plus(m,C1),Plus(Sqr(a),Sqr(b))),-1)),x),Dist(Power(Plus(Sqr(a),Sqr(b)),-1),Int(Times(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Plus(m,C1)),Simp(Plus(Times(a,c),Times(b,d),Times(CN1,Plus(Times(b,c),Times(CN1,a,d)),Tan(Plus(e,Times(f,x))))),x)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),NeQ(Plus(Sqr(a),Sqr(b)),C0),LtQ(m,CN1)))),
IIntegrate(3530,Int(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),-1),Plus(c_,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(Simp(Times(c,Log(RemoveContent(Plus(Times(a,Cos(Plus(e,Times(f,x)))),Times(b,Sin(Plus(e,Times(f,x))))),x)),Power(Times(b,f),-1)),x),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),NeQ(Plus(Sqr(a),Sqr(b)),C0),EqQ(Plus(Times(a,c),Times(b,d)),C0)))),
IIntegrate(3531,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),-1),Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(Plus(Times(a,c),Times(b,d)),x,Power(Plus(Sqr(a),Sqr(b)),-1)),x),Dist(Times(Plus(Times(b,c),Times(CN1,a,d)),Power(Plus(Sqr(a),Sqr(b)),-1)),Int(Times(Plus(b,Times(CN1,a,Tan(Plus(e,Times(f,x))))),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),NeQ(Plus(Sqr(a),Sqr(b)),C0),NeQ(Plus(Times(a,c),Times(b,d)),C0)))),
IIntegrate(3532,Int(Times(Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),CN1D2),Plus(c_,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(Dist(Times(CN2,Sqr(d),Power(f,-1)),Subst(Int(Power(Plus(Times(C2,c,d),Times(b,Sqr(x))),-1),x),x,Times(Plus(c,Times(CN1,d,Tan(Plus(e,Times(f,x))))),Power(Times(b,Tan(Plus(e,Times(f,x)))),CN1D2))),x),And(FreeQ(List(b,c,d,e,f),x),EqQ(Plus(Sqr(c),Negate(Sqr(d))),C0)))),
IIntegrate(3533,Int(Times(Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),CN1D2),Plus(c_,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(Dist(Times(C2,Sqr(c),Power(f,-1)),Subst(Int(Power(Plus(Times(b,c),Times(CN1,d,Sqr(x))),-1),x),x,Sqrt(Times(b,Tan(Plus(e,Times(f,x)))))),x),And(FreeQ(List(b,c,d,e,f),x),EqQ(Plus(Sqr(c),Sqr(d)),C0)))),
IIntegrate(3534,Int(Times(Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),CN1D2),Plus(c_,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(Dist(Times(C2,Power(f,-1)),Subst(Int(Times(Plus(Times(b,c),Times(d,Sqr(x))),Power(Plus(Sqr(b),Power(x,4)),-1)),x),x,Sqrt(Times(b,Tan(Plus(e,Times(f,x)))))),x),And(FreeQ(List(b,c,d,e,f),x),NeQ(Plus(Sqr(c),Negate(Sqr(d))),C0),NeQ(Plus(Sqr(c),Sqr(d)),C0)))),
IIntegrate(3535,Int(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),CN1D2),Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(Dist(Times(CN2,Sqr(d),Power(f,-1)),Subst(Int(Power(Plus(Times(C2,b,c,d),Times(CN1,C4,a,Sqr(d)),Sqr(x)),-1),x),x,Times(Plus(Times(b,c),Times(CN1,C2,a,d),Times(CN1,b,d,Tan(Plus(e,Times(f,x))))),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),CN1D2))),x),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),NeQ(Plus(Sqr(a),Sqr(b)),C0),NeQ(Plus(Sqr(c),Sqr(d)),C0),EqQ(Plus(Times(C2,a,c,d),Times(CN1,b,Plus(Sqr(c),Negate(Sqr(d))))),C0)))),
IIntegrate(3536,Int(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),CN1D2),Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(With(List(Set(q,Rt(Plus(Sqr(a),Sqr(b)),C2))),Plus(Dist(Power(Times(C2,q),-1),Int(Times(Plus(Times(a,c),Times(b,d),Times(c,q),Times(Plus(Times(b,c),Times(CN1,a,d),Times(d,q)),Tan(Plus(e,Times(f,x))))),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),CN1D2)),x),x),Negate(Dist(Power(Times(C2,q),-1),Int(Times(Plus(Times(a,c),Times(b,d),Times(CN1,c,q),Times(Plus(Times(b,c),Times(CN1,a,d),Times(CN1,d,q)),Tan(Plus(e,Times(f,x))))),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),CN1D2)),x),x)))),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),NeQ(Plus(Sqr(a),Sqr(b)),C0),NeQ(Plus(Sqr(c),Sqr(d)),C0),NeQ(Plus(Times(C2,a,c,d),Times(CN1,b,Plus(Sqr(c),Negate(Sqr(d))))),C0),Or(PerfectSquareQ(Plus(Sqr(a),Sqr(b))),RationalQ(a,b,c,d))))),
IIntegrate(3537,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_),Plus(c_,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(Dist(Times(c,d,Power(f,-1)),Subst(Int(Times(Power(Plus(a,Times(b,x,Power(d,-1))),m),Power(Plus(Sqr(d),Times(c,x)),-1)),x),x,Times(d,Tan(Plus(e,Times(f,x))))),x),And(FreeQ(List(a,b,c,d,e,f,m),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),NeQ(Plus(Sqr(a),Sqr(b)),C0),EqQ(Plus(Sqr(c),Sqr(d)),C0)))),
IIntegrate(3538,Int(Times(Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_),Plus(c_,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Dist(c,Int(Power(Times(b,Tan(Plus(e,Times(f,x)))),m),x),x),Dist(Times(d,Power(b,-1)),Int(Power(Times(b,Tan(Plus(e,Times(f,x)))),Plus(m,C1)),x),x)),And(FreeQ(List(b,c,d,e,f,m),x),NeQ(Plus(Sqr(c),Sqr(d)),C0),Not(IntegerQ(Times(C2,m)))))),
IIntegrate(3539,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_),Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Dist(Times(C1D2,Plus(c,Times(CI,d))),Int(Times(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),m),Plus(C1,Times(CN1,CI,Tan(Plus(e,Times(f,x)))))),x),x),Dist(Times(C1D2,Plus(c,Times(CN1,CI,d))),Int(Times(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),m),Plus(C1,Times(CI,Tan(Plus(e,Times(f,x)))))),x),x)),And(FreeQ(List(a,b,c,d,e,f,m),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),NeQ(Plus(Sqr(a),Sqr(b)),C0),NeQ(Plus(Sqr(c),Sqr(d)),C0),Not(IntegerQ(m))))),
IIntegrate(3540,Int(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_),Sqr(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Negate(Simp(Times(b,Sqr(Plus(Times(a,c),Times(b,d))),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),m),Power(Times(C2,Power(a,3),f,m),-1)),x)),Dist(Power(Times(C2,Sqr(a)),-1),Int(Times(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Plus(m,C1)),Simp(Plus(Times(a,Sqr(c)),Times(CN1,C2,b,c,d),Times(a,Sqr(d)),Times(CN1,C2,b,Sqr(d),Tan(Plus(e,Times(f,x))))),x)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),LeQ(m,CN1),EqQ(Plus(Sqr(a),Sqr(b)),C0)))),
IIntegrate(3541,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),-1),Sqr(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Simp(Times(d,Plus(Times(C2,b,c),Times(CN1,a,d)),x,Power(b,-2)),x),Dist(Times(Sqr(d),Power(b,-1)),Int(Tan(Plus(e,Times(f,x))),x),x),Dist(Times(Sqr(Plus(Times(b,c),Times(CN1,a,d))),Power(b,-2)),Int(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),-1),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),NeQ(Plus(Sqr(a),Sqr(b)),C0)))),
IIntegrate(3542,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_),Sqr(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Simp(Times(Sqr(Plus(Times(b,c),Times(CN1,a,d))),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Plus(m,C1)),Power(Times(b,f,Plus(m,C1),Plus(Sqr(a),Sqr(b))),-1)),x),Dist(Power(Plus(Sqr(a),Sqr(b)),-1),Int(Times(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Plus(m,C1)),Simp(Plus(Times(a,Sqr(c)),Times(C2,b,c,d),Times(CN1,a,Sqr(d)),Times(CN1,Plus(Times(b,Sqr(c)),Times(CN1,C2,a,c,d),Times(CN1,b,Sqr(d))),Tan(Plus(e,Times(f,x))))),x)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),LtQ(m,CN1),NeQ(Plus(Sqr(a),Sqr(b)),C0)))),
IIntegrate(3543,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_),Sqr(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Simp(Times(Sqr(d),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Plus(m,C1)),Power(Times(b,f,Plus(m,C1)),-1)),x),Int(Times(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),m),Simp(Plus(Sqr(c),Negate(Sqr(d)),Times(C2,c,d,Tan(Plus(e,Times(f,x))))),x)),x)),And(FreeQ(List(a,b,c,d,e,f,m),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),Not(LeQ(m,CN1)),Not(And(EqQ(m,C2),EqQ(a,C0)))))),
IIntegrate(3544,Int(Times(Sqrt(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),CN1D2)),x_Symbol),
    Condition(Dist(Times(CN2,a,b,Power(f,-1)),Subst(Int(Power(Plus(Times(a,c),Times(CN1,b,d),Times(CN1,C2,Sqr(a),Sqr(x))),-1),x),x,Times(Sqrt(Plus(c,Times(d,Tan(Plus(e,Times(f,x)))))),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),CN1D2))),x),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),EqQ(Plus(Sqr(a),Sqr(b)),C0),NeQ(Plus(Sqr(c),Sqr(d)),C0)))),
IIntegrate(3545,Int(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Plus(Simp(Times(a,b,Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Plus(m,Negate(C1))),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),Plus(n,C1)),Power(Times(f,Plus(m,Negate(C1)),Plus(Times(a,c),Times(CN1,b,d))),-1)),x),Dist(Times(C2,Sqr(a),Power(Plus(Times(a,c),Times(CN1,b,d)),-1)),Int(Times(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Plus(m,Negate(C1))),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),Plus(n,C1))),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),EqQ(Plus(Sqr(a),Sqr(b)),C0),NeQ(Plus(Sqr(c),Sqr(d)),C0),EqQ(Plus(m,n),C0),GtQ(m,C1D2)))),
IIntegrate(3546,Int(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Plus(Simp(Times(a,Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),m),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),n),Power(Times(C2,b,f,m),-1)),x),Negate(Dist(Times(Plus(Times(a,c),Times(CN1,b,d)),Power(Times(C2,Sqr(b)),-1)),Int(Times(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Plus(m,C1)),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),Plus(n,Negate(C1)))),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),EqQ(Plus(Sqr(a),Sqr(b)),C0),NeQ(Plus(Sqr(c),Sqr(d)),C0),EqQ(Plus(m,n),C0),LeQ(m,Negate(Power(C2,-1)))))),
IIntegrate(3547,Int(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Plus(Simp(Times(a,Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),m),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),Plus(n,C1)),Power(Times(C2,f,m,Plus(Times(b,c),Times(CN1,a,d))),-1)),x),Dist(Power(Times(C2,a),-1),Int(Times(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Plus(m,C1)),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),n)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),EqQ(Plus(Sqr(a),Sqr(b)),C0),NeQ(Plus(Sqr(c),Sqr(d)),C0),EqQ(Plus(m,n,C1),C0),LtQ(m,CN1)))),
IIntegrate(3548,Int(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(d,Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),m),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),Plus(n,C1)),Power(Times(f,m,Plus(Sqr(c),Sqr(d))),-1)),x)),Dist(Times(a,Power(Plus(Times(a,c),Times(CN1,b,d)),-1)),Int(Times(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),m),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),Plus(n,C1))),x),x)),And(FreeQ(List(a,b,c,d,e,f,m,n),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),EqQ(Plus(Sqr(a),Sqr(b)),C0),NeQ(Plus(Sqr(c),Sqr(d)),C0),EqQ(Plus(m,n,C1),C0),Not(LtQ(m,CN1))))),
IIntegrate(3549,Int(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),-1),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Plus(Times(a,c),Times(b,d)),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),n),Power(Times(C2,Plus(Times(b,c),Times(CN1,a,d)),f,Plus(a,Times(b,Tan(Plus(e,Times(f,x)))))),-1)),x)),Dist(Power(Times(C2,a,Plus(Times(b,c),Times(CN1,a,d))),-1),Int(Times(Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),Plus(n,Negate(C1))),Simp(Plus(Times(a,c,d,Plus(n,Negate(C1))),Times(b,Sqr(c)),Times(b,Sqr(d),n),Times(CN1,d,Plus(Times(b,c),Times(CN1,a,d)),Plus(n,Negate(C1)),Tan(Plus(e,Times(f,x))))),x)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),EqQ(Plus(Sqr(a),Sqr(b)),C0),NeQ(Plus(Sqr(c),Sqr(d)),C0),LtQ(C0,n,C1)))),
IIntegrate(3550,Int(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),-1),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Plus(Simp(Times(Plus(Times(b,c),Times(CN1,a,d)),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),Plus(n,Negate(C1))),Power(Times(C2,a,f,Plus(a,Times(b,Tan(Plus(e,Times(f,x)))))),-1)),x),Dist(Power(Times(C2,Sqr(a)),-1),Int(Times(Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),Plus(n,Negate(C2))),Simp(Plus(Times(a,Sqr(c)),Times(a,Sqr(d),Plus(n,Negate(C1))),Times(CN1,b,c,d,n),Times(CN1,d,Plus(Times(a,c,Plus(n,Negate(C2))),Times(b,d,n)),Tan(Plus(e,Times(f,x))))),x)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),EqQ(Plus(Sqr(a),Sqr(b)),C0),NeQ(Plus(Sqr(c),Sqr(d)),C0),GtQ(n,C1))))
  );
}