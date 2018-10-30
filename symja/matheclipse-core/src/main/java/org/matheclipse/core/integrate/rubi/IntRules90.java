package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CI;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Cot;
import static org.matheclipse.core.expression.F.Csc;
import static org.matheclipse.core.expression.F.Exp;
import static org.matheclipse.core.expression.F.FSymbol;
import static org.matheclipse.core.expression.F.F_;
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
import static org.matheclipse.core.expression.F.Sec;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Tan;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
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
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.F;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NegQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.TrigQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/** 
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class IntRules90 { 
  public static IAST RULES = List( 
IIntegrate(4501,Int(Power(Sec(Times(Plus(a_DEFAULT,Times(Log(x_),b_DEFAULT)),d_DEFAULT)),p_DEFAULT),x_Symbol),
    Condition(Dist(Times(Power(Sec(Times(d,Plus(a,Times(b,Log(x))))),p),Power(Plus(C1,Times(Exp(Times(C2,CI,a,d)),Power(x,Times(C2,CI,b,d)))),p),Power(Power(x,Times(CI,b,d,p)),-1)),Int(Times(Power(x,Times(CI,b,d,p)),Power(Power(Plus(C1,Times(Exp(Times(C2,CI,a,d)),Power(x,Times(C2,CI,b,d)))),p),-1)),x),x),And(FreeQ(List(a,b,d,p),x),Not(IntegerQ(p))))),
IIntegrate(4502,Int(Power(Csc(Times(Plus(a_DEFAULT,Times(Log(x_),b_DEFAULT)),d_DEFAULT)),p_DEFAULT),x_Symbol),
    Condition(Dist(Times(Power(Csc(Times(d,Plus(a,Times(b,Log(x))))),p),Power(Plus(C1,Times(CN1,Exp(Times(C2,CI,a,d)),Power(x,Times(C2,CI,b,d)))),p),Power(Power(x,Times(CI,b,d,p)),-1)),Int(Times(Power(x,Times(CI,b,d,p)),Power(Power(Plus(C1,Times(CN1,Exp(Times(C2,CI,a,d)),Power(x,Times(C2,CI,b,d)))),p),-1)),x),x),And(FreeQ(List(a,b,d,p),x),Not(IntegerQ(p))))),
IIntegrate(4503,Int(Power(Sec(Times(Plus(a_DEFAULT,Times(Log(Times(c_DEFAULT,Power(x_,n_DEFAULT))),b_DEFAULT)),d_DEFAULT)),p_DEFAULT),x_Symbol),
    Condition(Dist(Times(x,Power(Times(n,Power(Times(c,Power(x,n)),Power(n,-1))),-1)),Subst(Int(Times(Power(x,Plus(Power(n,-1),Negate(C1))),Power(Sec(Times(d,Plus(a,Times(b,Log(x))))),p)),x),x,Times(c,Power(x,n))),x),And(FreeQ(List(a,b,c,d,n,p),x),Or(NeQ(c,C1),NeQ(n,C1))))),
IIntegrate(4504,Int(Power(Csc(Times(Plus(a_DEFAULT,Times(Log(Times(c_DEFAULT,Power(x_,n_DEFAULT))),b_DEFAULT)),d_DEFAULT)),p_DEFAULT),x_Symbol),
    Condition(Dist(Times(x,Power(Times(n,Power(Times(c,Power(x,n)),Power(n,-1))),-1)),Subst(Int(Times(Power(x,Plus(Power(n,-1),Negate(C1))),Power(Csc(Times(d,Plus(a,Times(b,Log(x))))),p)),x),x,Times(c,Power(x,n))),x),And(FreeQ(List(a,b,c,d,n,p),x),Or(NeQ(c,C1),NeQ(n,C1))))),
IIntegrate(4505,Int(Times(Power(Times(e_DEFAULT,x_),m_DEFAULT),Power(Sec(Times(Plus(a_DEFAULT,Times(Log(x_),b_DEFAULT)),d_DEFAULT)),p_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(C2,p),Exp(Times(CI,a,d,p))),Int(Times(Power(Times(e,x),m),Power(x,Times(CI,b,d,p)),Power(Power(Plus(C1,Times(Exp(Times(C2,CI,a,d)),Power(x,Times(C2,CI,b,d)))),p),-1)),x),x),And(FreeQ(List(a,b,d,e,m),x),IntegerQ(p)))),
IIntegrate(4506,Int(Times(Power(Csc(Times(Plus(a_DEFAULT,Times(Log(x_),b_DEFAULT)),d_DEFAULT)),p_DEFAULT),Power(Times(e_DEFAULT,x_),m_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(Times(CN2,CI),p),Exp(Times(CI,a,d,p))),Int(Times(Power(Times(e,x),m),Power(x,Times(CI,b,d,p)),Power(Power(Plus(C1,Times(CN1,Exp(Times(C2,CI,a,d)),Power(x,Times(C2,CI,b,d)))),p),-1)),x),x),And(FreeQ(List(a,b,d,e,m),x),IntegerQ(p)))),
IIntegrate(4507,Int(Times(Power(Times(e_DEFAULT,x_),m_DEFAULT),Power(Sec(Times(Plus(a_DEFAULT,Times(Log(x_),b_DEFAULT)),d_DEFAULT)),p_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(Sec(Times(d,Plus(a,Times(b,Log(x))))),p),Power(Plus(C1,Times(Exp(Times(C2,CI,a,d)),Power(x,Times(C2,CI,b,d)))),p),Power(Power(x,Times(CI,b,d,p)),-1)),Int(Times(Power(Times(e,x),m),Power(x,Times(CI,b,d,p)),Power(Power(Plus(C1,Times(Exp(Times(C2,CI,a,d)),Power(x,Times(C2,CI,b,d)))),p),-1)),x),x),And(FreeQ(List(a,b,d,e,m,p),x),Not(IntegerQ(p))))),
IIntegrate(4508,Int(Times(Power(Csc(Times(Plus(a_DEFAULT,Times(Log(x_),b_DEFAULT)),d_DEFAULT)),p_DEFAULT),Power(Times(e_DEFAULT,x_),m_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(Csc(Times(d,Plus(a,Times(b,Log(x))))),p),Power(Plus(C1,Times(CN1,Exp(Times(C2,CI,a,d)),Power(x,Times(C2,CI,b,d)))),p),Power(Power(x,Times(CI,b,d,p)),-1)),Int(Times(Power(Times(e,x),m),Power(x,Times(CI,b,d,p)),Power(Power(Plus(C1,Times(CN1,Exp(Times(C2,CI,a,d)),Power(x,Times(C2,CI,b,d)))),p),-1)),x),x),And(FreeQ(List(a,b,d,e,m,p),x),Not(IntegerQ(p))))),
IIntegrate(4509,Int(Times(Power(Times(e_DEFAULT,x_),m_DEFAULT),Power(Sec(Times(Plus(a_DEFAULT,Times(Log(Times(c_DEFAULT,Power(x_,n_DEFAULT))),b_DEFAULT)),d_DEFAULT)),p_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(Times(e,x),Plus(m,C1)),Power(Times(e,n,Power(Times(c,Power(x,n)),Times(Plus(m,C1),Power(n,-1)))),-1)),Subst(Int(Times(Power(x,Plus(Times(Plus(m,C1),Power(n,-1)),Negate(C1))),Power(Sec(Times(d,Plus(a,Times(b,Log(x))))),p)),x),x,Times(c,Power(x,n))),x),And(FreeQ(List(a,b,c,d,e,m,n,p),x),Or(NeQ(c,C1),NeQ(n,C1))))),
IIntegrate(4510,Int(Times(Power(Csc(Times(Plus(a_DEFAULT,Times(Log(Times(c_DEFAULT,Power(x_,n_DEFAULT))),b_DEFAULT)),d_DEFAULT)),p_DEFAULT),Power(Times(e_DEFAULT,x_),m_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(Times(e,x),Plus(m,C1)),Power(Times(e,n,Power(Times(c,Power(x,n)),Times(Plus(m,C1),Power(n,-1)))),-1)),Subst(Int(Times(Power(x,Plus(Times(Plus(m,C1),Power(n,-1)),Negate(C1))),Power(Csc(Times(d,Plus(a,Times(b,Log(x))))),p)),x),x,Times(c,Power(x,n))),x),And(FreeQ(List(a,b,c,d,e,m,n,p),x),Or(NeQ(c,C1),NeQ(n,C1))))),
IIntegrate(4511,Int(Times(Log(Times(b_DEFAULT,x_)),Sin(Times(Log(Times(b_DEFAULT,x_)),a_DEFAULT,x_))),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Cos(Times(a,x,Log(Times(b,x)))),Power(a,-1)),x)),Negate(Int(Sin(Times(a,x,Log(Times(b,x)))),x))),FreeQ(List(a,b),x))),
IIntegrate(4512,Int(Times(Cos(Times(Log(Times(b_DEFAULT,x_)),a_DEFAULT,x_)),Log(Times(b_DEFAULT,x_))),x_Symbol),
    Condition(Plus(Simp(Times(Sin(Times(a,x,Log(Times(b,x)))),Power(a,-1)),x),Negate(Int(Cos(Times(a,x,Log(Times(b,x)))),x))),FreeQ(List(a,b),x))),
IIntegrate(4513,Int(Times(Log(Times(b_DEFAULT,x_)),Power(x_,m_DEFAULT),Sin(Times(Log(Times(b_DEFAULT,x_)),a_DEFAULT,Power(x_,n_DEFAULT)))),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Cos(Times(a,Power(x,n),Log(Times(b,x)))),Power(Times(a,n),-1)),x)),Negate(Dist(Power(n,-1),Int(Times(Power(x,m),Sin(Times(a,Power(x,n),Log(Times(b,x))))),x),x))),And(FreeQ(List(a,b,m,n),x),EqQ(m,Plus(n,Negate(C1)))))),
IIntegrate(4514,Int(Times(Cos(Times(Log(Times(b_DEFAULT,x_)),a_DEFAULT,Power(x_,n_DEFAULT))),Log(Times(b_DEFAULT,x_)),Power(x_,m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Sin(Times(a,Power(x,n),Log(Times(b,x)))),Power(Times(a,n),-1)),x),Negate(Dist(Power(n,-1),Int(Times(Power(x,m),Cos(Times(a,Power(x,n),Log(Times(b,x))))),x),x))),And(FreeQ(List(a,b,m,n),x),EqQ(m,Plus(n,Negate(C1)))))),
IIntegrate(4515,Int(Times(Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Plus(Dist(Power(b,-1),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Sin(Plus(c,Times(d,x))),Plus(n,Negate(C1)))),x),x),Negate(Dist(Times(a,Power(b,-1)),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Sin(Plus(c,Times(d,x))),Plus(n,Negate(C1))),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),IGtQ(n,C0)))),
IIntegrate(4516,Int(Times(Power(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_DEFAULT),Power(Plus(Times(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_),-1),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Dist(Power(b,-1),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Cos(Plus(c,Times(d,x))),Plus(n,Negate(C1)))),x),x),Negate(Dist(Times(a,Power(b,-1)),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Cos(Plus(c,Times(d,x))),Plus(n,Negate(C1))),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),IGtQ(n,C0)))),
IIntegrate(4517,Int(Times(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(CI,Power(Plus(e,Times(f,x)),Plus(m,C1)),Power(Times(b,f,Plus(m,C1)),-1)),x)),Dist(C2,Int(Times(Power(Plus(e,Times(f,x)),m),Exp(Times(CI,Plus(c,Times(d,x)))),Power(Plus(a,Times(CN1,CI,b,Exp(Times(CI,Plus(c,Times(d,x)))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),EqQ(Plus(Sqr(a),Negate(Sqr(b))),C0)))),
IIntegrate(4518,Int(Times(Power(Plus(Times(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_),-1),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),x_Symbol),
    Condition(Plus(Simp(Times(CI,Power(Plus(e,Times(f,x)),Plus(m,C1)),Power(Times(b,f,Plus(m,C1)),-1)),x),Negate(Dist(Times(C2,CI),Int(Times(Power(Plus(e,Times(f,x)),m),Exp(Times(CI,Plus(c,Times(d,x)))),Power(Plus(a,Times(b,Exp(Times(CI,Plus(c,Times(d,x)))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),EqQ(Plus(Sqr(a),Negate(Sqr(b))),C0)))),
IIntegrate(4519,Int(Times(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(CI,Power(Plus(e,Times(f,x)),Plus(m,C1)),Power(Times(b,f,Plus(m,C1)),-1)),x)),Int(Times(Power(Plus(e,Times(f,x)),m),Exp(Times(CI,Plus(c,Times(d,x)))),Power(Plus(a,Negate(Rt(Plus(Sqr(a),Negate(Sqr(b))),C2)),Times(CN1,CI,b,Exp(Times(CI,Plus(c,Times(d,x)))))),-1)),x),Int(Times(Power(Plus(e,Times(f,x)),m),Exp(Times(CI,Plus(c,Times(d,x)))),Power(Plus(a,Rt(Plus(Sqr(a),Negate(Sqr(b))),C2),Times(CN1,CI,b,Exp(Times(CI,Plus(c,Times(d,x)))))),-1)),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),PosQ(Plus(Sqr(a),Negate(Sqr(b))))))),
IIntegrate(4520,Int(Times(Power(Plus(Times(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_),-1),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),x_Symbol),
    Condition(Plus(Simp(Times(CI,Power(Plus(e,Times(f,x)),Plus(m,C1)),Power(Times(b,f,Plus(m,C1)),-1)),x),Negate(Dist(CI,Int(Times(Power(Plus(e,Times(f,x)),m),Exp(Times(CI,Plus(c,Times(d,x)))),Power(Plus(a,Negate(Rt(Plus(Sqr(a),Negate(Sqr(b))),C2)),Times(b,Exp(Times(CI,Plus(c,Times(d,x)))))),-1)),x),x)),Negate(Dist(CI,Int(Times(Power(Plus(e,Times(f,x)),m),Exp(Times(CI,Plus(c,Times(d,x)))),Power(Plus(a,Rt(Plus(Sqr(a),Negate(Sqr(b))),C2),Times(b,Exp(Times(CI,Plus(c,Times(d,x)))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),PosQ(Plus(Sqr(a),Negate(Sqr(b))))))),
IIntegrate(4521,Int(Times(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(CI,Power(Plus(e,Times(f,x)),Plus(m,C1)),Power(Times(b,f,Plus(m,C1)),-1)),x)),Dist(CI,Int(Times(Power(Plus(e,Times(f,x)),m),Exp(Times(CI,Plus(c,Times(d,x)))),Power(Plus(Times(CI,a),Negate(Rt(Plus(Negate(Sqr(a)),Sqr(b)),C2)),Times(b,Exp(Times(CI,Plus(c,Times(d,x)))))),-1)),x),x),Dist(CI,Int(Times(Power(Plus(e,Times(f,x)),m),Exp(Times(CI,Plus(c,Times(d,x)))),Power(Plus(Times(CI,a),Rt(Plus(Negate(Sqr(a)),Sqr(b)),C2),Times(b,Exp(Times(CI,Plus(c,Times(d,x)))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),NegQ(Plus(Sqr(a),Negate(Sqr(b))))))),
IIntegrate(4522,Int(Times(Power(Plus(Times(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_),-1),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),x_Symbol),
    Condition(Plus(Simp(Times(CI,Power(Plus(e,Times(f,x)),Plus(m,C1)),Power(Times(b,f,Plus(m,C1)),-1)),x),Int(Times(Power(Plus(e,Times(f,x)),m),Exp(Times(CI,Plus(c,Times(d,x)))),Power(Plus(Times(CI,a),Negate(Rt(Plus(Negate(Sqr(a)),Sqr(b)),C2)),Times(CI,b,Exp(Times(CI,Plus(c,Times(d,x)))))),-1)),x),Int(Times(Power(Plus(e,Times(f,x)),m),Exp(Times(CI,Plus(c,Times(d,x)))),Power(Plus(Times(CI,a),Rt(Plus(Negate(Sqr(a)),Sqr(b)),C2),Times(CI,b,Exp(Times(CI,Plus(c,Times(d,x)))))),-1)),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),NegQ(Plus(Sqr(a),Negate(Sqr(b))))))),
IIntegrate(4523,Int(Times(Power(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Plus(Dist(Power(a,-1),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Cos(Plus(c,Times(d,x))),Plus(n,Negate(C2)))),x),x),Negate(Dist(Power(b,-1),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Cos(Plus(c,Times(d,x))),Plus(n,Negate(C2))),Sin(Plus(c,Times(d,x)))),x),x))),And(FreeQ(List(a,b,c,d,e,f,m),x),IGtQ(n,C1),EqQ(Plus(Sqr(a),Negate(Sqr(b))),C0)))),
IIntegrate(4524,Int(Times(Power(Plus(Times(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_),-1),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_)),x_Symbol),
    Condition(Plus(Dist(Power(a,-1),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Sin(Plus(c,Times(d,x))),Plus(n,Negate(C2)))),x),x),Negate(Dist(Power(b,-1),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Sin(Plus(c,Times(d,x))),Plus(n,Negate(C2))),Cos(Plus(c,Times(d,x)))),x),x))),And(FreeQ(List(a,b,c,d,e,f,m),x),IGtQ(n,C1),EqQ(Plus(Sqr(a),Negate(Sqr(b))),C0)))),
IIntegrate(4525,Int(Times(Power(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Plus(Dist(Times(a,Power(b,-2)),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Cos(Plus(c,Times(d,x))),Plus(n,Negate(C2)))),x),x),Negate(Dist(Power(b,-1),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Cos(Plus(c,Times(d,x))),Plus(n,Negate(C2))),Sin(Plus(c,Times(d,x)))),x),x)),Negate(Dist(Times(Plus(Sqr(a),Negate(Sqr(b))),Power(b,-2)),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Cos(Plus(c,Times(d,x))),Plus(n,Negate(C2))),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(n,C1),NeQ(Plus(Sqr(a),Negate(Sqr(b))),C0),IGtQ(m,C0)))),
IIntegrate(4526,Int(Times(Power(Plus(Times(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_),-1),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_)),x_Symbol),
    Condition(Plus(Dist(Times(a,Power(b,-2)),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Sin(Plus(c,Times(d,x))),Plus(n,Negate(C2)))),x),x),Negate(Dist(Power(b,-1),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Sin(Plus(c,Times(d,x))),Plus(n,Negate(C2))),Cos(Plus(c,Times(d,x)))),x),x)),Negate(Dist(Times(Plus(Sqr(a),Negate(Sqr(b))),Power(b,-2)),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Sin(Plus(c,Times(d,x))),Plus(n,Negate(C2))),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(n,C1),NeQ(Plus(Sqr(a),Negate(Sqr(b))),C0),IGtQ(m,C0)))),
IIntegrate(4527,Int(Times(Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),-1),Power(Tan(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_DEFAULT)),x_Symbol),
    Condition(Plus(Dist(Power(b,-1),Int(Times(Power(Plus(e,Times(f,x)),m),Sec(Plus(c,Times(d,x))),Power(Tan(Plus(c,Times(d,x))),Plus(n,Negate(C1)))),x),x),Negate(Dist(Times(a,Power(b,-1)),Int(Times(Power(Plus(e,Times(f,x)),m),Sec(Plus(c,Times(d,x))),Power(Tan(Plus(c,Times(d,x))),Plus(n,Negate(C1))),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),IGtQ(n,C0)))),
IIntegrate(4528,Int(Times(Power(Cot(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_DEFAULT),Power(Plus(Times(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_),-1),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Dist(Power(b,-1),Int(Times(Power(Plus(e,Times(f,x)),m),Csc(Plus(c,Times(d,x))),Power(Cot(Plus(c,Times(d,x))),Plus(n,Negate(C1)))),x),x),Negate(Dist(Times(a,Power(b,-1)),Int(Times(Power(Plus(e,Times(f,x)),m),Csc(Plus(c,Times(d,x))),Power(Cot(Plus(c,Times(d,x))),Plus(n,Negate(C1))),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),IGtQ(n,C0)))),
IIntegrate(4529,Int(Times(Power(Cot(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_DEFAULT),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Plus(Dist(Power(a,-1),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Cot(Plus(c,Times(d,x))),n)),x),x),Negate(Dist(Times(b,Power(a,-1)),Int(Times(Power(Plus(e,Times(f,x)),m),Cos(Plus(c,Times(d,x))),Power(Cot(Plus(c,Times(d,x))),Plus(n,Negate(C1))),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),IGtQ(n,C0)))),
IIntegrate(4530,Int(Times(Power(Plus(Times(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_),-1),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Tan(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_DEFAULT)),x_Symbol),
    Condition(Plus(Dist(Power(a,-1),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Tan(Plus(c,Times(d,x))),n)),x),x),Negate(Dist(Times(b,Power(a,-1)),Int(Times(Power(Plus(e,Times(f,x)),m),Sin(Plus(c,Times(d,x))),Power(Tan(Plus(c,Times(d,x))),Plus(n,Negate(C1))),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),IGtQ(n,C0)))),
IIntegrate(4531,Int(Times(Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Sec(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Plus(Dist(Power(a,-1),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Sec(Plus(c,Times(d,x))),Plus(n,C2))),x),x),Negate(Dist(Power(b,-1),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Sec(Plus(c,Times(d,x))),Plus(n,C1)),Tan(Plus(c,Times(d,x)))),x),x))),And(FreeQ(List(a,b,c,d,e,f,n),x),IGtQ(m,C0),EqQ(Plus(Sqr(a),Negate(Sqr(b))),C0)))),
IIntegrate(4532,Int(Times(Power(Csc(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_DEFAULT),Power(Plus(Times(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_),-1),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Dist(Power(a,-1),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Csc(Plus(c,Times(d,x))),Plus(n,C2))),x),x),Negate(Dist(Power(b,-1),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Csc(Plus(c,Times(d,x))),Plus(n,C1)),Cot(Plus(c,Times(d,x)))),x),x))),And(FreeQ(List(a,b,c,d,e,f,n),x),IGtQ(m,C0),EqQ(Plus(Sqr(a),Negate(Sqr(b))),C0)))),
IIntegrate(4533,Int(Times(Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Sec(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Plus(Negate(Dist(Times(Sqr(b),Power(Plus(Sqr(a),Negate(Sqr(b))),-1)),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Sec(Plus(c,Times(d,x))),Plus(n,Negate(C2))),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),-1)),x),x)),Dist(Power(Plus(Sqr(a),Negate(Sqr(b))),-1),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Sec(Plus(c,Times(d,x))),n),Plus(a,Times(CN1,b,Sin(Plus(c,Times(d,x)))))),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),NeQ(Plus(Sqr(a),Negate(Sqr(b))),C0),IGtQ(n,C0)))),
IIntegrate(4534,Int(Times(Power(Csc(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_DEFAULT),Power(Plus(Times(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_),-1),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Negate(Dist(Times(Sqr(b),Power(Plus(Sqr(a),Negate(Sqr(b))),-1)),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Csc(Plus(c,Times(d,x))),Plus(n,Negate(C2))),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),-1)),x),x)),Dist(Power(Plus(Sqr(a),Negate(Sqr(b))),-1),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Csc(Plus(c,Times(d,x))),n),Plus(a,Times(CN1,b,Cos(Plus(c,Times(d,x)))))),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),NeQ(Plus(Sqr(a),Negate(Sqr(b))),C0),IGtQ(n,C0)))),
IIntegrate(4535,Int(Times(Power(Csc(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_DEFAULT),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Plus(Dist(Power(a,-1),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Csc(Plus(c,Times(d,x))),n)),x),x),Negate(Dist(Times(b,Power(a,-1)),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Csc(Plus(c,Times(d,x))),Plus(n,Negate(C1))),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),IGtQ(n,C0)))),
IIntegrate(4536,Int(Times(Power(Plus(Times(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_),-1),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Sec(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_DEFAULT)),x_Symbol),
    Condition(Plus(Dist(Power(a,-1),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Sec(Plus(c,Times(d,x))),n)),x),x),Negate(Dist(Times(b,Power(a,-1)),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Sec(Plus(c,Times(d,x))),Plus(n,Negate(C1))),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),IGtQ(n,C0)))),
IIntegrate(4537,Int(Times(Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),-1),Power($(F_,Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_DEFAULT)),x_Symbol),
    Condition(Unintegrable(Times(Power(Plus(e,Times(f,x)),m),Power(F(Plus(c,Times(d,x))),n),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),-1)),x),And(FreeQ(List(a,b,c,d,e,f,m,n),x),TrigQ(FSymbol)))),
IIntegrate(4538,Int(Times(Power(Plus(Times(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_),-1),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power($(F_,Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_DEFAULT)),x_Symbol),
    Condition(Unintegrable(Times(Power(Plus(e,Times(f,x)),m),Power(F(Plus(c,Times(d,x))),n),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),-1)),x),And(FreeQ(List(a,b,c,d,e,f,m,n),x),TrigQ(FSymbol)))),
IIntegrate(4539,Int(Times(Power(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),p_DEFAULT),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Plus(Dist(Power(b,-1),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Cos(Plus(c,Times(d,x))),p),Power(Sin(Plus(c,Times(d,x))),Plus(n,Negate(C1)))),x),x),Negate(Dist(Times(a,Power(b,-1)),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Cos(Plus(c,Times(d,x))),p),Power(Sin(Plus(c,Times(d,x))),Plus(n,Negate(C1))),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),IGtQ(n,C0),IGtQ(p,C0)))),
IIntegrate(4540,Int(Times(Power(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_DEFAULT),Power(Plus(Times(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_),-1),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Dist(Power(b,-1),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Sin(Plus(c,Times(d,x))),p),Power(Cos(Plus(c,Times(d,x))),Plus(n,Negate(C1)))),x),x),Negate(Dist(Times(a,Power(b,-1)),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Sin(Plus(c,Times(d,x))),p),Power(Cos(Plus(c,Times(d,x))),Plus(n,Negate(C1))),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),IGtQ(n,C0),IGtQ(p,C0)))),
IIntegrate(4541,Int(Times(Power(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),p_DEFAULT),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),-1),Power(Tan(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_DEFAULT)),x_Symbol),
    Condition(Plus(Dist(Power(b,-1),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Cos(Plus(c,Times(d,x))),Plus(p,Negate(C1))),Power(Tan(Plus(c,Times(d,x))),Plus(n,Negate(C1)))),x),x),Negate(Dist(Times(a,Power(b,-1)),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Cos(Plus(c,Times(d,x))),Plus(p,Negate(C1))),Power(Tan(Plus(c,Times(d,x))),Plus(n,Negate(C1))),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),IGtQ(n,C0),IGtQ(p,C0)))),
IIntegrate(4542,Int(Times(Power(Cot(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_DEFAULT),Power(Plus(Times(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_),-1),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Dist(Power(b,-1),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Sin(Plus(c,Times(d,x))),Plus(p,Negate(C1))),Power(Cot(Plus(c,Times(d,x))),Plus(n,Negate(C1)))),x),x),Negate(Dist(Times(a,Power(b,-1)),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Sin(Plus(c,Times(d,x))),Plus(p,Negate(C1))),Power(Cot(Plus(c,Times(d,x))),Plus(n,Negate(C1))),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),IGtQ(n,C0),IGtQ(p,C0)))),
IIntegrate(4543,Int(Times(Power(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),p_DEFAULT),Power(Cot(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_DEFAULT),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Plus(Dist(Power(a,-1),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Cos(Plus(c,Times(d,x))),p),Power(Cot(Plus(c,Times(d,x))),n)),x),x),Negate(Dist(Times(b,Power(a,-1)),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Cos(Plus(c,Times(d,x))),Plus(p,C1)),Power(Cot(Plus(c,Times(d,x))),Plus(n,Negate(C1))),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),IGtQ(n,C0),IGtQ(p,C0)))),
IIntegrate(4544,Int(Times(Power(Plus(Times(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_),-1),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),p_DEFAULT),Power(Tan(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_DEFAULT)),x_Symbol),
    Condition(Plus(Dist(Power(a,-1),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Sin(Plus(c,Times(d,x))),p),Power(Tan(Plus(c,Times(d,x))),n)),x),x),Negate(Dist(Times(b,Power(a,-1)),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Sin(Plus(c,Times(d,x))),Plus(p,C1)),Power(Tan(Plus(c,Times(d,x))),Plus(n,Negate(C1))),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),IGtQ(n,C0),IGtQ(p,C0)))),
IIntegrate(4545,Int(Times(Power(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),p_DEFAULT),Power(Csc(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_DEFAULT),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Plus(Dist(Power(a,-1),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Cos(Plus(c,Times(d,x))),p),Power(Csc(Plus(c,Times(d,x))),n)),x),x),Negate(Dist(Times(b,Power(a,-1)),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Cos(Plus(c,Times(d,x))),p),Power(Csc(Plus(c,Times(d,x))),Plus(n,Negate(C1))),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),IGtQ(n,C0),IGtQ(p,C0)))),
IIntegrate(4546,Int(Times(Power(Plus(Times(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_),-1),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Sec(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_DEFAULT),Power(Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Dist(Power(a,-1),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Sin(Plus(c,Times(d,x))),p),Power(Sec(Plus(c,Times(d,x))),n)),x),x),Negate(Dist(Times(b,Power(a,-1)),Int(Times(Power(Plus(e,Times(f,x)),m),Power(Sin(Plus(c,Times(d,x))),p),Power(Sec(Plus(c,Times(d,x))),Plus(n,Negate(C1))),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),IGtQ(n,C0),IGtQ(p,C0)))),
IIntegrate(4547,Int(Times(Power(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),p_DEFAULT),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),-1),Power($(F_,Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_DEFAULT)),x_Symbol),
    Condition(Unintegrable(Times(Power(Plus(e,Times(f,x)),m),Power(Cos(Plus(c,Times(d,x))),p),Power(F(Plus(c,Times(d,x))),n),Power(Plus(a,Times(b,Sin(Plus(c,Times(d,x))))),-1)),x),And(FreeQ(List(a,b,c,d,e,f,m,n,p),x),TrigQ(FSymbol)))),
IIntegrate(4548,Int(Times(Power(Plus(Times(Cos(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_),-1),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Sin(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),p_DEFAULT),Power($(F_,Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_DEFAULT)),x_Symbol),
    Condition(Unintegrable(Times(Power(Plus(e,Times(f,x)),m),Power(F(Plus(c,Times(d,x))),n),Power(Sin(Plus(c,Times(d,x))),p),Power(Plus(a,Times(b,Cos(Plus(c,Times(d,x))))),-1)),x),And(FreeQ(List(a,b,c,d,e,f,m,n),x),TrigQ(FSymbol)))),
IIntegrate(4549,Int(Times(Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sec(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),-1),Power($(F_,Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(Plus(e,Times(f,x)),m),Cos(Plus(c,Times(d,x))),Power(F(Plus(c,Times(d,x))),n),Power(Plus(b,Times(a,Cos(Plus(c,Times(d,x))))),-1)),x),And(FreeQ(List(a,b,c,d,e,f),x),TrigQ(FSymbol),IntegersQ(m,n)))),
IIntegrate(4550,Int(Times(Power(Plus(Times(Csc(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_),-1),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power($(F_,Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(Plus(e,Times(f,x)),m),Sin(Plus(c,Times(d,x))),Power(F(Plus(c,Times(d,x))),n),Power(Plus(b,Times(a,Sin(Plus(c,Times(d,x))))),-1)),x),And(FreeQ(List(a,b,c,d,e,f),x),TrigQ(FSymbol),IntegersQ(m,n))))
  );
}