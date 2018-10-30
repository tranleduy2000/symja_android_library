package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcSin;
import static org.matheclipse.core.expression.F.ArcTanh;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C1D4;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Cot;
import static org.matheclipse.core.expression.F.Csc;
import static org.matheclipse.core.expression.F.EllipticPi;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
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
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_;
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
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialMatchQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandTrig;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/** 
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class IntRules75 { 
  public static IAST RULES = List( 
IIntegrate(3751,Int(Times(Power(x_,m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Tan(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_)))))),p_DEFAULT)),x_Symbol),
    Condition(Unintegrable(Times(Power(x,m),Power(Plus(a,Times(b,Tan(Plus(c,Times(d,Power(x,n)))))),p)),x),FreeQ(List(a,b,c,d,m,n,p),x))),
IIntegrate(3752,Int(Times(Power(Plus(a_DEFAULT,Times(Cot(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_)))),b_DEFAULT)),p_DEFAULT),Power(x_,m_DEFAULT)),x_Symbol),
    Condition(Unintegrable(Times(Power(x,m),Power(Plus(a,Times(b,Cot(Plus(c,Times(d,Power(x,n)))))),p)),x),FreeQ(List(a,b,c,d,m,n,p),x))),
IIntegrate(3753,Int(Times(Power(Times(e_,x_),m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Tan(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_)))))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(e,IntPart(m)),Power(Times(e,x),FracPart(m)),Power(Power(x,FracPart(m)),-1)),Int(Times(Power(x,m),Power(Plus(a,Times(b,Tan(Plus(c,Times(d,Power(x,n)))))),p)),x),x),FreeQ(List(a,b,c,d,e,m,n,p),x))),
IIntegrate(3754,Int(Times(Power(Plus(a_DEFAULT,Times(Cot(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_)))),b_DEFAULT)),p_DEFAULT),Power(Times(e_,x_),m_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(e,IntPart(m)),Power(Times(e,x),FracPart(m)),Power(Power(x,FracPart(m)),-1)),Int(Times(Power(x,m),Power(Plus(a,Times(b,Cot(Plus(c,Times(d,Power(x,n)))))),p)),x),x),FreeQ(List(a,b,c,d,e,m,n,p),x))),
IIntegrate(3755,Int(Times(Power(Times(e_,x_),m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Tan(u_))),p_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(Times(e,x),m),Power(Plus(a,Times(b,Tan(ExpandToSum(u,x)))),p)),x),And(FreeQ(List(a,b,e,m,p),x),BinomialQ(u,x),Not(BinomialMatchQ(u,x))))),
IIntegrate(3756,Int(Times(Power(Plus(a_DEFAULT,Times(Cot(u_),b_DEFAULT)),p_DEFAULT),Power(Times(e_,x_),m_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(Times(e,x),m),Power(Plus(a,Times(b,Cot(ExpandToSum(u,x)))),p)),x),And(FreeQ(List(a,b,e,m,p),x),BinomialQ(u,x),Not(BinomialMatchQ(u,x))))),
IIntegrate(3757,Int(Times(Power(x_,m_DEFAULT),Power(Sec(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_DEFAULT)))),p_DEFAULT),Power(Tan(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_DEFAULT)))),q_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(x,Plus(m,Negate(n),C1)),Power(Sec(Plus(a,Times(b,Power(x,n)))),p),Power(Times(b,n,p),-1)),x),Negate(Dist(Times(Plus(m,Negate(n),C1),Power(Times(b,n,p),-1)),Int(Times(Power(x,Plus(m,Negate(n))),Power(Sec(Plus(a,Times(b,Power(x,n)))),p)),x),x))),And(FreeQ(List(a,b,p),x),IntegerQ(n),GeQ(m,n),EqQ(q,C1)))),
IIntegrate(3758,Int(Times(Power(Cot(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_DEFAULT)))),q_DEFAULT),Power(Csc(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_DEFAULT)))),p_DEFAULT),Power(x_,m_DEFAULT)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Power(x,Plus(m,Negate(n),C1)),Power(Csc(Plus(a,Times(b,Power(x,n)))),p),Power(Times(b,n,p),-1)),x)),Dist(Times(Plus(m,Negate(n),C1),Power(Times(b,n,p),-1)),Int(Times(Power(x,Plus(m,Negate(n))),Power(Csc(Plus(a,Times(b,Power(x,n)))),p)),x),x)),And(FreeQ(List(a,b,p),x),IntegerQ(n),GeQ(m,n),EqQ(q,C1)))),
IIntegrate(3759,Int(Power(Tan(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_)))),n_DEFAULT),x_Symbol),
    Condition(Unintegrable(Power(Tan(Plus(a,Times(b,x),Times(c,Sqr(x)))),n),x),FreeQ(List(a,b,c,n),x))),
IIntegrate(3760,Int(Power(Cot(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_)))),n_DEFAULT),x_Symbol),
    Condition(Unintegrable(Power(Cot(Plus(a,Times(b,x),Times(c,Sqr(x)))),n),x),FreeQ(List(a,b,c,n),x))),
IIntegrate(3761,Int(Times(Plus(d_,Times(e_DEFAULT,x_)),Tan(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))))),x_Symbol),
    Condition(Negate(Simp(Times(e,Log(Cos(Plus(a,Times(b,x),Times(c,Sqr(x))))),Power(Times(C2,c),-1)),x)),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(C2,c,d),Times(CN1,b,e)),C0)))),
IIntegrate(3762,Int(Times(Cot(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_)))),Plus(d_,Times(e_DEFAULT,x_))),x_Symbol),
    Condition(Simp(Times(e,Log(Sin(Plus(a,Times(b,x),Times(c,Sqr(x))))),Power(Times(C2,c),-1)),x),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(C2,c,d),Times(CN1,b,e)),C0)))),
IIntegrate(3763,Int(Times(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),Tan(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))))),x_Symbol),
    Condition(Plus(Negate(Simp(Times(e,Log(Cos(Plus(a,Times(b,x),Times(c,Sqr(x))))),Power(Times(C2,c),-1)),x)),Dist(Times(Plus(Times(C2,c,d),Times(CN1,b,e)),Power(Times(C2,c),-1)),Int(Tan(Plus(a,Times(b,x),Times(c,Sqr(x)))),x),x)),And(FreeQ(List(a,b,c,d,e),x),NeQ(Plus(Times(C2,c,d),Times(CN1,b,e)),C0)))),
IIntegrate(3764,Int(Times(Cot(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_)))),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),x_Symbol),
    Condition(Plus(Simp(Times(e,Log(Sin(Plus(a,Times(b,x),Times(c,Sqr(x))))),Power(Times(C2,c),-1)),x),Dist(Times(Plus(Times(C2,c,d),Times(CN1,b,e)),Power(Times(C2,c),-1)),Int(Cot(Plus(a,Times(b,x),Times(c,Sqr(x)))),x),x)),And(FreeQ(List(a,b,c,d,e),x),NeQ(Plus(Times(C2,c,d),Times(CN1,b,e)),C0)))),
IIntegrate(3765,Int(Times(Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),m_DEFAULT),Power(Tan(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_)))),n_DEFAULT)),x_Symbol),
    Condition(Unintegrable(Times(Power(Plus(d,Times(e,x)),m),Power(Tan(Plus(a,Times(b,x),Times(c,Sqr(x)))),n)),x),FreeQ(List(a,b,c,d,e,m,n),x))),
IIntegrate(3766,Int(Times(Power(Cot(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_)))),n_DEFAULT),Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Unintegrable(Times(Power(Plus(d,Times(e,x)),m),Power(Cot(Plus(a,Times(b,x),Times(c,Sqr(x)))),n)),x),FreeQ(List(a,b,c,d,e,m,n),x))),
IIntegrate(3767,Int(Power($($s("§csc"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),n_),x_Symbol),
    Condition(Negate(Dist(Power(d,-1),Subst(Int(ExpandIntegrand(Power(Plus(C1,Sqr(x)),Plus(Times(C1D2,n),Negate(C1))),x),x),x,Cot(Plus(c,Times(d,x)))),x)),And(FreeQ(List(c,d),x),IGtQ(Times(C1D2,n),C0)))),
IIntegrate(3768,Int(Power(Times($($s("§csc"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),n_),x_Symbol),
    Condition(Plus(Negate(Simp(Times(b,Cos(Plus(c,Times(d,x))),Power(Times(b,Csc(Plus(c,Times(d,x)))),Plus(n,Negate(C1))),Power(Times(d,Plus(n,Negate(C1))),-1)),x)),Dist(Times(Sqr(b),Plus(n,Negate(C2)),Power(Plus(n,Negate(C1)),-1)),Int(Power(Times(b,Csc(Plus(c,Times(d,x)))),Plus(n,Negate(C2))),x),x)),And(FreeQ(List(b,c,d),x),GtQ(n,C1),IntegerQ(Times(C2,n))))),
IIntegrate(3769,Int(Power(Times($($s("§csc"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),n_),x_Symbol),
    Condition(Plus(Simp(Times(Cos(Plus(c,Times(d,x))),Power(Times(b,Csc(Plus(c,Times(d,x)))),Plus(n,C1)),Power(Times(b,d,n),-1)),x),Dist(Times(Plus(n,C1),Power(Times(Sqr(b),n),-1)),Int(Power(Times(b,Csc(Plus(c,Times(d,x)))),Plus(n,C2)),x),x)),And(FreeQ(List(b,c,d),x),LtQ(n,CN1),IntegerQ(Times(C2,n))))),
IIntegrate(3770,Int($($s("§csc"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),x_Symbol),
    Condition(Negate(Simp(Times(ArcTanh(Cos(Plus(c,Times(d,x)))),Power(d,-1)),x)),FreeQ(List(c,d),x))),
IIntegrate(3771,Int(Power(Times($($s("§csc"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),n_),x_Symbol),
    Condition(Dist(Times(Power(Times(b,Csc(Plus(c,Times(d,x)))),n),Power(Sin(Plus(c,Times(d,x))),n)),Int(Power(Power(Sin(Plus(c,Times(d,x))),n),-1),x),x),And(FreeQ(List(b,c,d),x),EqQ(Sqr(n),C1D4)))),
IIntegrate(3772,Int(Power(Times($($s("§csc"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),n_),x_Symbol),
    Condition(Simp(Times(Power(Times(b,Csc(Plus(c,Times(d,x)))),Plus(n,Negate(C1))),Power(Times(Sin(Plus(c,Times(d,x))),Power(b,-1)),Plus(n,Negate(C1))),Int(Power(Power(Times(Sin(Plus(c,Times(d,x))),Power(b,-1)),n),-1),x)),x),And(FreeQ(List(b,c,d,n),x),Not(IntegerQ(n))))),
IIntegrate(3773,Int(Sqr(Plus(Times($($s("§csc"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_)),x_Symbol),
    Condition(Plus(Simp(Times(Sqr(a),x),x),Dist(Times(C2,a,b),Int(Csc(Plus(c,Times(d,x))),x),x),Dist(Sqr(b),Int(Sqr(Csc(Plus(c,Times(d,x)))),x),x)),FreeQ(List(a,b,c,d),x))),
IIntegrate(3774,Int(Sqrt(Plus(Times($($s("§csc"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_)),x_Symbol),
    Condition(Dist(Times(CN2,b,Power(d,-1)),Subst(Int(Power(Plus(a,Sqr(x)),-1),x),x,Times(b,Cot(Plus(c,Times(d,x))),Power(Plus(a,Times(b,Csc(Plus(c,Times(d,x))))),CN1D2))),x),And(FreeQ(List(a,b,c,d),x),EqQ(Plus(Sqr(a),Negate(Sqr(b))),C0)))),
IIntegrate(3775,Int(Power(Plus(Times($($s("§csc"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_),n_),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Sqr(b),Cot(Plus(c,Times(d,x))),Power(Plus(a,Times(b,Csc(Plus(c,Times(d,x))))),Plus(n,Negate(C2))),Power(Times(d,Plus(n,Negate(C1))),-1)),x)),Dist(Times(a,Power(Plus(n,Negate(C1)),-1)),Int(Times(Power(Plus(a,Times(b,Csc(Plus(c,Times(d,x))))),Plus(n,Negate(C2))),Plus(Times(a,Plus(n,Negate(C1))),Times(b,Plus(Times(C3,n),Negate(C4)),Csc(Plus(c,Times(d,x)))))),x),x)),And(FreeQ(List(a,b,c,d),x),EqQ(Plus(Sqr(a),Negate(Sqr(b))),C0),GtQ(n,C1),IntegerQ(Times(C2,n))))),
IIntegrate(3776,Int(Power(Plus(Times($($s("§csc"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_),CN1D2),x_Symbol),
    Condition(Plus(Dist(Power(a,-1),Int(Sqrt(Plus(a,Times(b,Csc(Plus(c,Times(d,x)))))),x),x),Negate(Dist(Times(b,Power(a,-1)),Int(Times(Csc(Plus(c,Times(d,x))),Power(Plus(a,Times(b,Csc(Plus(c,Times(d,x))))),CN1D2)),x),x))),And(FreeQ(List(a,b,c,d),x),EqQ(Plus(Sqr(a),Negate(Sqr(b))),C0)))),
IIntegrate(3777,Int(Power(Plus(Times($($s("§csc"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_),n_),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Cot(Plus(c,Times(d,x))),Power(Plus(a,Times(b,Csc(Plus(c,Times(d,x))))),n),Power(Times(d,Plus(Times(C2,n),C1)),-1)),x)),Dist(Power(Times(Sqr(a),Plus(Times(C2,n),C1)),-1),Int(Times(Power(Plus(a,Times(b,Csc(Plus(c,Times(d,x))))),Plus(n,C1)),Plus(Times(a,Plus(Times(C2,n),C1)),Times(CN1,b,Plus(n,C1),Csc(Plus(c,Times(d,x)))))),x),x)),And(FreeQ(List(a,b,c,d),x),EqQ(Plus(Sqr(a),Negate(Sqr(b))),C0),LeQ(n,CN1),IntegerQ(Times(C2,n))))),
IIntegrate(3778,Int(Power(Plus(Times($($s("§csc"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_),n_),x_Symbol),
    Condition(Dist(Times(Power(a,n),Cot(Plus(c,Times(d,x))),Power(Times(d,Sqrt(Plus(C1,Csc(Plus(c,Times(d,x))))),Sqrt(Plus(C1,Negate(Csc(Plus(c,Times(d,x))))))),-1)),Subst(Int(Times(Power(Plus(C1,Times(b,x,Power(a,-1))),Plus(n,Negate(C1D2))),Power(Times(x,Sqrt(Plus(C1,Times(CN1,b,x,Power(a,-1))))),-1)),x),x,Csc(Plus(c,Times(d,x)))),x),And(FreeQ(List(a,b,c,d,n),x),EqQ(Plus(Sqr(a),Negate(Sqr(b))),C0),Not(IntegerQ(Times(C2,n))),GtQ(a,C0)))),
IIntegrate(3779,Int(Power(Plus(Times($($s("§csc"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_),n_),x_Symbol),
    Condition(Dist(Times(Power(a,IntPart(n)),Power(Plus(a,Times(b,Csc(Plus(c,Times(d,x))))),FracPart(n)),Power(Power(Plus(C1,Times(b,Csc(Plus(c,Times(d,x))),Power(a,-1))),FracPart(n)),-1)),Int(Power(Plus(C1,Times(b,Csc(Plus(c,Times(d,x))),Power(a,-1))),n),x),x),And(FreeQ(List(a,b,c,d,n),x),EqQ(Plus(Sqr(a),Negate(Sqr(b))),C0),Not(IntegerQ(Times(C2,n))),Not(GtQ(a,C0))))),
IIntegrate(3780,Int(Sqrt(Plus(Times($($s("§csc"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_)),x_Symbol),
    Condition(Simp(Times(C2,Plus(a,Times(b,Csc(Plus(c,Times(d,x))))),Sqrt(Times(b,Plus(C1,Csc(Plus(c,Times(d,x)))),Power(Plus(a,Times(b,Csc(Plus(c,Times(d,x))))),-1))),Sqrt(Times(CN1,b,Plus(C1,Negate(Csc(Plus(c,Times(d,x))))),Power(Plus(a,Times(b,Csc(Plus(c,Times(d,x))))),-1))),EllipticPi(Times(a,Power(Plus(a,b),-1)),ArcSin(Times(Rt(Plus(a,b),C2),Power(Plus(a,Times(b,Csc(Plus(c,Times(d,x))))),CN1D2))),Times(Plus(a,Negate(b)),Power(Plus(a,b),-1))),Power(Times(d,Rt(Plus(a,b),C2),Cot(Plus(c,Times(d,x)))),-1)),x),And(FreeQ(List(a,b,c,d),x),NeQ(Plus(Sqr(a),Negate(Sqr(b))),C0)))),
IIntegrate(3781,Int(Power(Plus(Times($($s("§csc"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_),QQ(3L,2L)),x_Symbol),
    Condition(Plus(Int(Times(Plus(Sqr(a),Times(b,Plus(Times(C2,a),Negate(b)),Csc(Plus(c,Times(d,x))))),Power(Plus(a,Times(b,Csc(Plus(c,Times(d,x))))),CN1D2)),x),Dist(Sqr(b),Int(Times(Csc(Plus(c,Times(d,x))),Plus(C1,Csc(Plus(c,Times(d,x)))),Power(Plus(a,Times(b,Csc(Plus(c,Times(d,x))))),CN1D2)),x),x)),And(FreeQ(List(a,b,c,d),x),NeQ(Plus(Sqr(a),Negate(Sqr(b))),C0)))),
IIntegrate(3782,Int(Power(Plus(Times($($s("§csc"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_),n_),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Sqr(b),Cot(Plus(c,Times(d,x))),Power(Plus(a,Times(b,Csc(Plus(c,Times(d,x))))),Plus(n,Negate(C2))),Power(Times(d,Plus(n,Negate(C1))),-1)),x)),Dist(Power(Plus(n,Negate(C1)),-1),Int(Times(Power(Plus(a,Times(b,Csc(Plus(c,Times(d,x))))),Plus(n,Negate(C3))),Simp(Plus(Times(Power(a,3),Plus(n,Negate(C1))),Times(b,Plus(Times(Sqr(b),Plus(n,Negate(C2))),Times(C3,Sqr(a),Plus(n,Negate(C1)))),Csc(Plus(c,Times(d,x)))),Times(a,Sqr(b),Plus(Times(C3,n),Negate(C4)),Sqr(Csc(Plus(c,Times(d,x)))))),x)),x),x)),And(FreeQ(List(a,b,c,d),x),NeQ(Plus(Sqr(a),Negate(Sqr(b))),C0),GtQ(n,C2),IntegerQ(Times(C2,n))))),
IIntegrate(3783,Int(Power(Plus(Times($($s("§csc"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_),-1),x_Symbol),
    Condition(Plus(Simp(Times(x,Power(a,-1)),x),Negate(Dist(Power(a,-1),Int(Power(Plus(C1,Times(a,Sin(Plus(c,Times(d,x))),Power(b,-1))),-1),x),x))),And(FreeQ(List(a,b,c,d),x),NeQ(Plus(Sqr(a),Negate(Sqr(b))),C0)))),
IIntegrate(3784,Int(Power(Plus(Times($($s("§csc"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_),CN1D2),x_Symbol),
    Condition(Simp(Times(C2,Rt(Plus(a,b),C2),Sqrt(Times(b,Plus(C1,Negate(Csc(Plus(c,Times(d,x))))),Power(Plus(a,b),-1))),Sqrt(Times(CN1,b,Plus(C1,Csc(Plus(c,Times(d,x)))),Power(Plus(a,Negate(b)),-1))),EllipticPi(Times(Plus(a,b),Power(a,-1)),ArcSin(Times(Sqrt(Plus(a,Times(b,Csc(Plus(c,Times(d,x)))))),Power(Rt(Plus(a,b),C2),-1))),Times(Plus(a,b),Power(Plus(a,Negate(b)),-1))),Power(Times(a,d,Cot(Plus(c,Times(d,x)))),-1)),x),And(FreeQ(List(a,b,c,d),x),NeQ(Plus(Sqr(a),Negate(Sqr(b))),C0)))),
IIntegrate(3785,Int(Power(Plus(Times($($s("§csc"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_),n_),x_Symbol),
    Condition(Plus(Simp(Times(Sqr(b),Cot(Plus(c,Times(d,x))),Power(Plus(a,Times(b,Csc(Plus(c,Times(d,x))))),Plus(n,C1)),Power(Times(a,d,Plus(n,C1),Plus(Sqr(a),Negate(Sqr(b)))),-1)),x),Dist(Power(Times(a,Plus(n,C1),Plus(Sqr(a),Negate(Sqr(b)))),-1),Int(Times(Power(Plus(a,Times(b,Csc(Plus(c,Times(d,x))))),Plus(n,C1)),Simp(Plus(Times(Plus(Sqr(a),Negate(Sqr(b))),Plus(n,C1)),Times(CN1,a,b,Plus(n,C1),Csc(Plus(c,Times(d,x)))),Times(Sqr(b),Plus(n,C2),Sqr(Csc(Plus(c,Times(d,x)))))),x)),x),x)),And(FreeQ(List(a,b,c,d),x),NeQ(Plus(Sqr(a),Negate(Sqr(b))),C0),LtQ(n,CN1),IntegerQ(Times(C2,n))))),
IIntegrate(3786,Int(Power(Plus(Times($($s("§csc"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),b_DEFAULT),a_),n_),x_Symbol),
    Condition(Unintegrable(Power(Plus(a,Times(b,Csc(Plus(c,Times(d,x))))),n),x),And(FreeQ(List(a,b,c,d,n),x),NeQ(Plus(Sqr(a),Negate(Sqr(b))),C0),Not(IntegerQ(Times(C2,n)))))),
IIntegrate(3787,Int(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),d_DEFAULT),n_DEFAULT),Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_)),x_Symbol),
    Condition(Plus(Dist(a,Int(Power(Times(d,Csc(Plus(e,Times(f,x)))),n),x),x),Dist(Times(b,Power(d,-1)),Int(Power(Times(d,Csc(Plus(e,Times(f,x)))),Plus(n,C1)),x),x)),FreeQ(List(a,b,d,e,f,n),x))),
IIntegrate(3788,Int(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),d_DEFAULT),n_DEFAULT),Sqr(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_))),x_Symbol),
    Condition(Plus(Dist(Times(C2,a,b,Power(d,-1)),Int(Power(Times(d,Csc(Plus(e,Times(f,x)))),Plus(n,C1)),x),x),Int(Times(Power(Times(d,Csc(Plus(e,Times(f,x)))),n),Plus(Sqr(a),Times(Sqr(b),Sqr(Csc(Plus(e,Times(f,x))))))),x)),FreeQ(List(a,b,d,e,f,n),x))),
IIntegrate(3789,Int(Times(Sqr($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),Power(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_),-1)),x_Symbol),
    Condition(Plus(Dist(Power(b,-1),Int(Csc(Plus(e,Times(f,x))),x),x),Negate(Dist(Times(a,Power(b,-1)),Int(Times(Csc(Plus(e,Times(f,x))),Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),-1)),x),x))),FreeQ(List(a,b,e,f),x))),
IIntegrate(3790,Int(Times(Power($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),3),Power(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_),-1)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Cot(Plus(e,Times(f,x))),Power(Times(b,f),-1)),x)),Negate(Dist(Times(a,Power(b,-1)),Int(Times(Sqr(Csc(Plus(e,Times(f,x)))),Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),-1)),x),x))),FreeQ(List(a,b,e,f),x))),
IIntegrate(3791,Int(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),d_DEFAULT),n_DEFAULT),Power(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_),m_)),x_Symbol),
    Condition(Int(ExpandTrig(Times(Power(Plus(a,Times(b,$($s("§csc"),Plus(e,Times(f,x))))),m),Power(Times(d,$($s("§csc"),Plus(e,Times(f,x)))),n)),x),x),And(FreeQ(List(a,b,d,e,f,m,n),x),EqQ(Plus(Sqr(a),Negate(Sqr(b))),C0),IGtQ(m,C0),RationalQ(n)))),
IIntegrate(3792,Int(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),Sqrt(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_))),x_Symbol),
    Condition(Simp(Times(CN2,b,Cot(Plus(e,Times(f,x))),Power(Times(f,Sqrt(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))))),-1)),x),And(FreeQ(List(a,b,e,f),x),EqQ(Plus(Sqr(a),Negate(Sqr(b))),C0)))),
IIntegrate(3793,Int(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),Power(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_),m_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(b,Cot(Plus(e,Times(f,x))),Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),Plus(m,Negate(C1))),Power(Times(f,m),-1)),x)),Dist(Times(a,Plus(Times(C2,m),Negate(C1)),Power(m,-1)),Int(Times(Csc(Plus(e,Times(f,x))),Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),Plus(m,Negate(C1)))),x),x)),And(FreeQ(List(a,b,e,f),x),EqQ(Plus(Sqr(a),Negate(Sqr(b))),C0),GtQ(m,C1D2),IntegerQ(Times(C2,m))))),
IIntegrate(3794,Int(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),Power(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_),-1)),x_Symbol),
    Condition(Negate(Simp(Times(Cot(Plus(e,Times(f,x))),Power(Times(f,Plus(b,Times(a,Csc(Plus(e,Times(f,x)))))),-1)),x)),And(FreeQ(List(a,b,e,f),x),EqQ(Plus(Sqr(a),Negate(Sqr(b))),C0)))),
IIntegrate(3795,Int(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),Power(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_),CN1D2)),x_Symbol),
    Condition(Dist(Times(CN2,Power(f,-1)),Subst(Int(Power(Plus(Times(C2,a),Sqr(x)),-1),x),x,Times(b,Cot(Plus(e,Times(f,x))),Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),CN1D2))),x),And(FreeQ(List(a,b,e,f),x),EqQ(Plus(Sqr(a),Negate(Sqr(b))),C0)))),
IIntegrate(3796,Int(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),Power(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_),m_)),x_Symbol),
    Condition(Plus(Simp(Times(b,Cot(Plus(e,Times(f,x))),Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),m),Power(Times(a,f,Plus(Times(C2,m),C1)),-1)),x),Dist(Times(Plus(m,C1),Power(Times(a,Plus(Times(C2,m),C1)),-1)),Int(Times(Csc(Plus(e,Times(f,x))),Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),Plus(m,C1))),x),x)),And(FreeQ(List(a,b,e,f),x),EqQ(Plus(Sqr(a),Negate(Sqr(b))),C0),LtQ(m,Negate(Power(C2,-1))),IntegerQ(Times(C2,m))))),
IIntegrate(3797,Int(Times(Sqr($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),Power(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_),m_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Cot(Plus(e,Times(f,x))),Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),m),Power(Times(f,Plus(Times(C2,m),C1)),-1)),x)),Dist(Times(m,Power(Times(b,Plus(Times(C2,m),C1)),-1)),Int(Times(Csc(Plus(e,Times(f,x))),Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),Plus(m,C1))),x),x)),And(FreeQ(List(a,b,e,f),x),EqQ(Plus(Sqr(a),Negate(Sqr(b))),C0),LtQ(m,Negate(Power(C2,-1)))))),
IIntegrate(3798,Int(Times(Sqr($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),Power(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_),m_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Cot(Plus(e,Times(f,x))),Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),m),Power(Times(f,Plus(m,C1)),-1)),x)),Dist(Times(a,m,Power(Times(b,Plus(m,C1)),-1)),Int(Times(Csc(Plus(e,Times(f,x))),Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),m)),x),x)),And(FreeQ(List(a,b,e,f,m),x),EqQ(Plus(Sqr(a),Negate(Sqr(b))),C0),Not(LtQ(m,Negate(Power(C2,-1))))))),
IIntegrate(3799,Int(Times(Power($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),3),Power(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_),m_)),x_Symbol),
    Condition(Plus(Simp(Times(b,Cot(Plus(e,Times(f,x))),Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),m),Power(Times(a,f,Plus(Times(C2,m),C1)),-1)),x),Negate(Dist(Power(Times(Sqr(a),Plus(Times(C2,m),C1)),-1),Int(Times(Csc(Plus(e,Times(f,x))),Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),Plus(m,C1)),Plus(Times(a,m),Times(CN1,b,Plus(Times(C2,m),C1),Csc(Plus(e,Times(f,x)))))),x),x))),And(FreeQ(List(a,b,e,f),x),EqQ(Plus(Sqr(a),Negate(Sqr(b))),C0),LtQ(m,Negate(Power(C2,-1)))))),
IIntegrate(3800,Int(Times(Power($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),3),Power(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_),m_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Cot(Plus(e,Times(f,x))),Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),Plus(m,C1)),Power(Times(b,f,Plus(m,C2)),-1)),x)),Dist(Power(Times(b,Plus(m,C2)),-1),Int(Times(Csc(Plus(e,Times(f,x))),Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),m),Plus(Times(b,Plus(m,C1)),Times(CN1,a,Csc(Plus(e,Times(f,x)))))),x),x)),And(FreeQ(List(a,b,e,f,m),x),EqQ(Plus(Sqr(a),Negate(Sqr(b))),C0),Not(LtQ(m,Negate(Power(C2,-1)))))))
  );
}