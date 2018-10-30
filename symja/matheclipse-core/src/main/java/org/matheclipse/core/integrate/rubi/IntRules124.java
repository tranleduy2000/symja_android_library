package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcCoth;
import static org.matheclipse.core.expression.F.ArcTanh;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.Coefficient;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cot;
import static org.matheclipse.core.expression.F.Coth;
import static org.matheclipse.core.expression.F.Csch;
import static org.matheclipse.core.expression.F.D;
import static org.matheclipse.core.expression.F.Discriminant;
import static org.matheclipse.core.expression.F.Exp;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.Head;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.MatchQ;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Part;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sec;
import static org.matheclipse.core.expression.F.Sech;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Tan;
import static org.matheclipse.core.expression.F.Tanh;
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
import static org.matheclipse.core.expression.F.f_;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.r_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.u_DEFAULT;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.w_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FalseQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InverseFunctionOfLinear;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.QuadraticQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SubstForInverseFunction;

/** 
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class IntRules124 { 
  public static IAST RULES = List( 
IIntegrate(6201,Int(Times(Exp(Times(ArcCoth(Times(c_DEFAULT,Plus(a_,Times(b_DEFAULT,x_)))),n_DEFAULT)),Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(Times(c,Plus(a,Times(b,x))),Times(C1D2,n)),Power(Plus(C1,Power(Times(c,Plus(a,Times(b,x))),-1)),Times(C1D2,n)),Power(Power(Plus(C1,Times(a,c),Times(b,c,x)),Times(C1D2,n)),-1)),Int(Times(Power(Plus(d,Times(e,x)),m),Power(Plus(C1,Times(a,c),Times(b,c,x)),Times(C1D2,n)),Power(Power(Plus(CN1,Times(a,c),Times(b,c,x)),Times(C1D2,n)),-1)),x),x),And(FreeQ(List(a,b,c,d,e,m,n),x),Not(IntegerQ(Times(C1D2,n)))))),
IIntegrate(6202,Int(Times(Exp(Times(ArcCoth(Plus(a_,Times(b_DEFAULT,x_))),n_DEFAULT)),u_DEFAULT,Power(Plus(c_,Times(d_DEFAULT,x_),Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(Times(c,Power(Plus(C1,Negate(Sqr(a))),-1)),p),Power(Times(Plus(a,Times(b,x)),Power(Plus(C1,a,Times(b,x)),-1)),Times(C1D2,n)),Power(Times(Plus(C1,a,Times(b,x)),Power(Plus(a,Times(b,x)),-1)),Times(C1D2,n)),Power(Plus(C1,Negate(a),Times(CN1,b,x)),Times(C1D2,n)),Power(Power(Plus(CN1,a,Times(b,x)),Times(C1D2,n)),-1)),Int(Times(u,Power(Plus(C1,Negate(a),Times(CN1,b,x)),Plus(p,Times(CN1,C1D2,n))),Power(Plus(C1,a,Times(b,x)),Plus(p,Times(C1D2,n)))),x),x),And(FreeQ(List(a,b,c,d,e,n,p),x),Not(IntegerQ(Times(C1D2,n))),EqQ(Plus(Times(b,d),Times(CN1,C2,a,e)),C0),EqQ(Plus(Times(Sqr(b),c),Times(e,Plus(C1,Negate(Sqr(a))))),C0),Or(IntegerQ(p),GtQ(Times(c,Power(Plus(C1,Negate(Sqr(a))),-1)),C0))))),
IIntegrate(6203,Int(Times(Exp(Times(ArcCoth(Plus(a_,Times(b_DEFAULT,x_))),n_DEFAULT)),u_DEFAULT,Power(Plus(c_,Times(d_DEFAULT,x_),Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(Plus(c,Times(d,x),Times(e,Sqr(x))),p),Power(Power(Plus(C1,Negate(Sqr(a)),Times(CN1,C2,a,b,x),Times(CN1,Sqr(b),Sqr(x))),p),-1)),Int(Times(u,Power(Plus(C1,Negate(Sqr(a)),Times(CN1,C2,a,b,x),Times(CN1,Sqr(b),Sqr(x))),p),Exp(Times(n,ArcCoth(Times(a,x))))),x),x),And(FreeQ(List(a,b,c,d,e,n,p),x),Not(IntegerQ(Times(C1D2,n))),EqQ(Plus(Times(b,d),Times(CN1,C2,a,e)),C0),EqQ(Plus(Times(Sqr(b),c),Times(e,Plus(C1,Negate(Sqr(a))))),C0),Not(Or(IntegerQ(p),GtQ(Times(c,Power(Plus(C1,Negate(Sqr(a))),-1)),C0)))))),
IIntegrate(6204,Int(Times(Exp(Times(ArcCoth(Times(c_DEFAULT,Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),-1))),n_DEFAULT)),u_DEFAULT),x_Symbol),
    Condition(Int(Times(u,Exp(Times(n,ArcTanh(Plus(Times(a,Power(c,-1)),Times(b,x,Power(c,-1))))))),x),FreeQ(List(a,b,c,n),x))),
IIntegrate(6205,Int(ArcTanh(Plus(a_,Times(b_DEFAULT,Power(x_,n_)))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcTanh(Plus(a,Times(b,Power(x,n))))),x),Negate(Dist(Times(b,n),Int(Times(Power(x,n),Power(Plus(C1,Negate(Sqr(a)),Times(CN1,C2,a,b,Power(x,n)),Times(CN1,Sqr(b),Power(x,Times(C2,n)))),-1)),x),x))),FreeQ(List(a,b,n),x))),
IIntegrate(6206,Int(ArcCoth(Plus(a_,Times(b_DEFAULT,Power(x_,n_)))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcCoth(Plus(a,Times(b,Power(x,n))))),x),Negate(Dist(Times(b,n),Int(Times(Power(x,n),Power(Plus(C1,Negate(Sqr(a)),Times(CN1,C2,a,b,Power(x,n)),Times(CN1,Sqr(b),Power(x,Times(C2,n)))),-1)),x),x))),FreeQ(List(a,b,n),x))),
IIntegrate(6207,Int(Times(ArcTanh(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_DEFAULT)))),Power(x_,-1)),x_Symbol),
    Condition(Plus(Dist(C1D2,Int(Times(Log(Plus(C1,a,Times(b,Power(x,n)))),Power(x,-1)),x),x),Negate(Dist(C1D2,Int(Times(Log(Plus(C1,Negate(a),Times(CN1,b,Power(x,n)))),Power(x,-1)),x),x))),FreeQ(List(a,b,n),x))),
IIntegrate(6208,Int(Times(ArcCoth(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_DEFAULT)))),Power(x_,-1)),x_Symbol),
    Condition(Plus(Dist(C1D2,Int(Times(Log(Plus(C1,Power(Plus(a,Times(b,Power(x,n))),-1))),Power(x,-1)),x),x),Negate(Dist(C1D2,Int(Times(Log(Plus(C1,Negate(Power(Plus(a,Times(b,Power(x,n))),-1)))),Power(x,-1)),x),x))),FreeQ(List(a,b,n),x))),
IIntegrate(6209,Int(Times(ArcTanh(Plus(a_,Times(b_DEFAULT,Power(x_,n_)))),Power(x_,m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(x,Plus(m,C1)),ArcTanh(Plus(a,Times(b,Power(x,n)))),Power(Plus(m,C1),-1)),x),Negate(Dist(Times(b,n,Power(Plus(m,C1),-1)),Int(Times(Power(x,Plus(m,n)),Power(Plus(C1,Negate(Sqr(a)),Times(CN1,C2,a,b,Power(x,n)),Times(CN1,Sqr(b),Power(x,Times(C2,n)))),-1)),x),x))),And(FreeQ(List(a,b),x),RationalQ(m,n),NeQ(m,CN1),NeQ(Plus(m,C1),n)))),
IIntegrate(6210,Int(Times(ArcCoth(Plus(a_,Times(b_DEFAULT,Power(x_,n_)))),Power(x_,m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(x,Plus(m,C1)),ArcCoth(Plus(a,Times(b,Power(x,n)))),Power(Plus(m,C1),-1)),x),Negate(Dist(Times(b,n,Power(Plus(m,C1),-1)),Int(Times(Power(x,Plus(m,n)),Power(Plus(C1,Negate(Sqr(a)),Times(CN1,C2,a,b,Power(x,n)),Times(CN1,Sqr(b),Power(x,Times(C2,n)))),-1)),x),x))),And(FreeQ(List(a,b),x),RationalQ(m,n),NeQ(m,CN1),NeQ(Plus(m,C1),n)))),
IIntegrate(6211,Int(ArcTanh(Plus(a_DEFAULT,Times(b_DEFAULT,Power(f_,Plus(c_DEFAULT,Times(d_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Dist(C1D2,Int(Log(Plus(C1,a,Times(b,Power(f,Plus(c,Times(d,x)))))),x),x),Negate(Dist(C1D2,Int(Log(Plus(C1,Negate(a),Times(CN1,b,Power(f,Plus(c,Times(d,x)))))),x),x))),FreeQ(List(a,b,c,d,f),x))),
IIntegrate(6212,Int(ArcCoth(Plus(a_DEFAULT,Times(b_DEFAULT,Power(f_,Plus(c_DEFAULT,Times(d_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Dist(C1D2,Int(Log(Plus(C1,Power(Plus(a,Times(b,Power(f,Plus(c,Times(d,x))))),-1))),x),x),Negate(Dist(C1D2,Int(Log(Plus(C1,Negate(Power(Plus(a,Times(b,Power(f,Plus(c,Times(d,x))))),-1)))),x),x))),FreeQ(List(a,b,c,d,f),x))),
IIntegrate(6213,Int(Times(ArcTanh(Plus(a_DEFAULT,Times(b_DEFAULT,Power(f_,Plus(c_DEFAULT,Times(d_DEFAULT,x_)))))),Power(x_,m_DEFAULT)),x_Symbol),
    Condition(Plus(Dist(C1D2,Int(Times(Power(x,m),Log(Plus(C1,a,Times(b,Power(f,Plus(c,Times(d,x))))))),x),x),Negate(Dist(C1D2,Int(Times(Power(x,m),Log(Plus(C1,Negate(a),Times(CN1,b,Power(f,Plus(c,Times(d,x))))))),x),x))),And(FreeQ(List(a,b,c,d,f),x),IGtQ(m,C0)))),
IIntegrate(6214,Int(Times(ArcCoth(Plus(a_DEFAULT,Times(b_DEFAULT,Power(f_,Plus(c_DEFAULT,Times(d_DEFAULT,x_)))))),Power(x_,m_DEFAULT)),x_Symbol),
    Condition(Plus(Dist(C1D2,Int(Times(Power(x,m),Log(Plus(C1,Power(Plus(a,Times(b,Power(f,Plus(c,Times(d,x))))),-1)))),x),x),Negate(Dist(C1D2,Int(Times(Power(x,m),Log(Plus(C1,Negate(Power(Plus(a,Times(b,Power(f,Plus(c,Times(d,x))))),-1))))),x),x))),And(FreeQ(List(a,b,c,d,f),x),IGtQ(m,C0)))),
IIntegrate(6215,Int(Times(Power(ArcTanh(Times(c_DEFAULT,Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_DEFAULT))),-1))),m_DEFAULT),u_DEFAULT),x_Symbol),
    Condition(Int(Times(u,Power(ArcCoth(Plus(Times(a,Power(c,-1)),Times(b,Power(x,n),Power(c,-1)))),m)),x),FreeQ(List(a,b,c,n,m),x))),
IIntegrate(6216,Int(Times(Power(ArcCoth(Times(c_DEFAULT,Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_DEFAULT))),-1))),m_DEFAULT),u_DEFAULT),x_Symbol),
    Condition(Int(Times(u,Power(ArcTanh(Plus(Times(a,Power(c,-1)),Times(b,Power(x,n),Power(c,-1)))),m)),x),FreeQ(List(a,b,c,n,m),x))),
IIntegrate(6217,Int(ArcTanh(Times(c_DEFAULT,x_,Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sqr(x_))),CN1D2))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcTanh(Times(c,x,Power(Plus(a,Times(b,Sqr(x))),CN1D2)))),x),Negate(Dist(c,Int(Times(x,Power(Plus(a,Times(b,Sqr(x))),CN1D2)),x),x))),And(FreeQ(List(a,b,c),x),EqQ(b,Sqr(c))))),
IIntegrate(6218,Int(ArcCoth(Times(c_DEFAULT,x_,Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sqr(x_))),CN1D2))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcCoth(Times(c,x,Power(Plus(a,Times(b,Sqr(x))),CN1D2)))),x),Negate(Dist(c,Int(Times(x,Power(Plus(a,Times(b,Sqr(x))),CN1D2)),x),x))),And(FreeQ(List(a,b,c),x),EqQ(b,Sqr(c))))),
IIntegrate(6219,Int(Times(ArcTanh(Times(c_DEFAULT,x_,Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sqr(x_))),CN1D2))),Power(x_,-1)),x_Symbol),
    Condition(Plus(Simp(Times(ArcTanh(Times(c,x,Power(Plus(a,Times(b,Sqr(x))),CN1D2))),Log(x)),x),Negate(Dist(c,Int(Times(Log(x),Power(Plus(a,Times(b,Sqr(x))),CN1D2)),x),x))),And(FreeQ(List(a,b,c),x),EqQ(b,Sqr(c))))),
IIntegrate(6220,Int(Times(ArcCoth(Times(c_DEFAULT,x_,Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sqr(x_))),CN1D2))),Power(x_,-1)),x_Symbol),
    Condition(Plus(Simp(Times(ArcCoth(Times(c,x,Power(Plus(a,Times(b,Sqr(x))),CN1D2))),Log(x)),x),Negate(Dist(c,Int(Times(Log(x),Power(Plus(a,Times(b,Sqr(x))),CN1D2)),x),x))),And(FreeQ(List(a,b,c),x),EqQ(b,Sqr(c))))),
IIntegrate(6221,Int(Times(ArcTanh(Times(c_DEFAULT,x_,Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sqr(x_))),CN1D2))),Power(Times(d_DEFAULT,x_),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(d,x),Plus(m,C1)),ArcTanh(Times(c,x,Power(Plus(a,Times(b,Sqr(x))),CN1D2))),Power(Times(d,Plus(m,C1)),-1)),x),Negate(Dist(Times(c,Power(Times(d,Plus(m,C1)),-1)),Int(Times(Power(Times(d,x),Plus(m,C1)),Power(Plus(a,Times(b,Sqr(x))),CN1D2)),x),x))),And(FreeQ(List(a,b,c,d,m),x),EqQ(b,Sqr(c)),NeQ(m,CN1)))),
IIntegrate(6222,Int(Times(ArcCoth(Times(c_DEFAULT,x_,Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sqr(x_))),CN1D2))),Power(Times(d_DEFAULT,x_),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(d,x),Plus(m,C1)),ArcCoth(Times(c,x,Power(Plus(a,Times(b,Sqr(x))),CN1D2))),Power(Times(d,Plus(m,C1)),-1)),x),Negate(Dist(Times(c,Power(Times(d,Plus(m,C1)),-1)),Int(Times(Power(Times(d,x),Plus(m,C1)),Power(Plus(a,Times(b,Sqr(x))),CN1D2)),x),x))),And(FreeQ(List(a,b,c,d,m),x),EqQ(b,Sqr(c)),NeQ(m,CN1)))),
IIntegrate(6223,Int(Times(Power(ArcTanh(Times(c_DEFAULT,x_,Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sqr(x_))),CN1D2))),-1),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sqr(x_))),CN1D2)),x_Symbol),
    Condition(Simp(Times(C1,Log(ArcTanh(Times(c,x,Power(Plus(a,Times(b,Sqr(x))),CN1D2)))),Power(c,-1)),x),And(FreeQ(List(a,b,c),x),EqQ(b,Sqr(c))))),
IIntegrate(6224,Int(Times(Power(ArcCoth(Times(c_DEFAULT,x_,Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sqr(x_))),CN1D2))),-1),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sqr(x_))),CN1D2)),x_Symbol),
    Condition(Negate(Simp(Times(Log(ArcCoth(Times(c,x,Power(Plus(a,Times(b,Sqr(x))),CN1D2)))),Power(c,-1)),x)),And(FreeQ(List(a,b,c),x),EqQ(b,Sqr(c))))),
IIntegrate(6225,Int(Times(Power(ArcTanh(Times(c_DEFAULT,x_,Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sqr(x_))),CN1D2))),m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sqr(x_))),CN1D2)),x_Symbol),
    Condition(Simp(Times(Power(ArcTanh(Times(c,x,Power(Plus(a,Times(b,Sqr(x))),CN1D2))),Plus(m,C1)),Power(Times(c,Plus(m,C1)),-1)),x),And(FreeQ(List(a,b,c,m),x),EqQ(b,Sqr(c)),NeQ(m,CN1)))),
IIntegrate(6226,Int(Times(Power(ArcCoth(Times(c_DEFAULT,x_,Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sqr(x_))),CN1D2))),m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sqr(x_))),CN1D2)),x_Symbol),
    Condition(Negate(Simp(Times(Power(ArcCoth(Times(c,x,Power(Plus(a,Times(b,Sqr(x))),CN1D2))),Plus(m,C1)),Power(Times(c,Plus(m,C1)),-1)),x)),And(FreeQ(List(a,b,c,m),x),EqQ(b,Sqr(c)),NeQ(m,CN1)))),
IIntegrate(6227,Int(Times(Power(ArcTanh(Times(c_DEFAULT,x_,Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sqr(x_))),CN1D2))),m_DEFAULT),Power(Plus(d_DEFAULT,Times(e_DEFAULT,Sqr(x_))),CN1D2)),x_Symbol),
    Condition(Dist(Times(Sqrt(Plus(a,Times(b,Sqr(x)))),Power(Plus(d,Times(e,Sqr(x))),CN1D2)),Int(Times(Power(ArcTanh(Times(c,x,Power(Plus(a,Times(b,Sqr(x))),CN1D2))),m),Power(Plus(a,Times(b,Sqr(x))),CN1D2)),x),x),And(FreeQ(List(a,b,c,d,e,m),x),EqQ(b,Sqr(c)),EqQ(Plus(Times(b,d),Times(CN1,a,e)),C0)))),
IIntegrate(6228,Int(Times(Power(ArcCoth(Times(c_DEFAULT,x_,Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sqr(x_))),CN1D2))),m_DEFAULT),Power(Plus(d_DEFAULT,Times(e_DEFAULT,Sqr(x_))),CN1D2)),x_Symbol),
    Condition(Dist(Times(Sqrt(Plus(a,Times(b,Sqr(x)))),Power(Plus(d,Times(e,Sqr(x))),CN1D2)),Int(Times(Power(ArcCoth(Times(c,x,Power(Plus(a,Times(b,Sqr(x))),CN1D2))),m),Power(Plus(a,Times(b,Sqr(x))),CN1D2)),x),x),And(FreeQ(List(a,b,c,d,e,m),x),EqQ(b,Sqr(c)),EqQ(Plus(Times(b,d),Times(CN1,a,e)),C0)))),
IIntegrate(6229,Int(Times(u_,Power(v_,n_DEFAULT)),x_Symbol),
    Condition(With(List(Set($s("tmp"),InverseFunctionOfLinear(u,x))),Condition(Dist(Times(Power(Times(CN1,Discriminant(v,x),Power(Times(C4,Coefficient(v,x,C2)),-1)),n),Power(Coefficient(Part($s("tmp"),C1),x,C1),-1)),Subst(Int(SimplifyIntegrand(Times(SubstForInverseFunction(u,$s("tmp"),x),Power(Sech(x),Times(C2,Plus(n,C1)))),x),x),x,$s("tmp")),x),And(Not(FalseQ($s("tmp"))),EqQ(Head($s("tmp")),$s("ArcTanh")),EqQ(Plus(Times(Discriminant(v,x),Sqr(Part($s("tmp"),C1))),Negate(Sqr(D(v,x)))),C0)))),And(QuadraticQ(v,x),ILtQ(n,C0),PosQ(Discriminant(v,x)),MatchQ(u,Condition(Times(r_DEFAULT,Power(f_,w_)),FreeQ(f,x)))))),
IIntegrate(6230,Int(Times(u_,Power(v_,n_DEFAULT)),x_Symbol),
    Condition(With(List(Set($s("tmp"),InverseFunctionOfLinear(u,x))),Condition(Dist(Times(Power(Times(CN1,Discriminant(v,x),Power(Times(C4,Coefficient(v,x,C2)),-1)),n),Power(Coefficient(Part($s("tmp"),C1),x,C1),-1)),Subst(Int(SimplifyIntegrand(Times(SubstForInverseFunction(u,$s("tmp"),x),Power(Negate(Sqr(Csch(x))),Plus(n,C1))),x),x),x,$s("tmp")),x),And(Not(FalseQ($s("tmp"))),EqQ(Head($s("tmp")),$s("ArcCoth")),EqQ(Plus(Times(Discriminant(v,x),Sqr(Part($s("tmp"),C1))),Negate(Sqr(D(v,x)))),C0)))),And(QuadraticQ(v,x),ILtQ(n,C0),PosQ(Discriminant(v,x)),MatchQ(u,Condition(Times(r_DEFAULT,Power(f_,w_)),FreeQ(f,x)))))),
IIntegrate(6231,Int(ArcTanh(Plus(c_DEFAULT,Times(d_DEFAULT,Tanh(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcTanh(Plus(c,Times(d,Tanh(Plus(a,Times(b,x))))))),x),Dist(b,Int(Times(x,Power(Plus(c,Negate(d),Times(c,Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d),x),EqQ(Sqr(Plus(c,Negate(d))),C1)))),
IIntegrate(6232,Int(ArcCoth(Plus(c_DEFAULT,Times(d_DEFAULT,Tanh(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcCoth(Plus(c,Times(d,Tanh(Plus(a,Times(b,x))))))),x),Dist(b,Int(Times(x,Power(Plus(c,Negate(d),Times(c,Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d),x),EqQ(Sqr(Plus(c,Negate(d))),C1)))),
IIntegrate(6233,Int(ArcTanh(Plus(c_DEFAULT,Times(Coth(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),d_DEFAULT))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcTanh(Plus(c,Times(d,Coth(Plus(a,Times(b,x))))))),x),Dist(b,Int(Times(x,Power(Plus(c,Negate(d),Times(CN1,c,Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d),x),EqQ(Sqr(Plus(c,Negate(d))),C1)))),
IIntegrate(6234,Int(ArcCoth(Plus(c_DEFAULT,Times(Coth(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),d_DEFAULT))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcCoth(Plus(c,Times(d,Coth(Plus(a,Times(b,x))))))),x),Dist(b,Int(Times(x,Power(Plus(c,Negate(d),Times(CN1,c,Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d),x),EqQ(Sqr(Plus(c,Negate(d))),C1)))),
IIntegrate(6235,Int(ArcTanh(Plus(c_DEFAULT,Times(d_DEFAULT,Tanh(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcTanh(Plus(c,Times(d,Tanh(Plus(a,Times(b,x))))))),x),Dist(Times(b,Plus(C1,Negate(c),Negate(d))),Int(Times(x,Exp(Plus(Times(C2,a),Times(C2,b,x))),Power(Plus(C1,Negate(c),d,Times(Plus(C1,Negate(c),Negate(d)),Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x),Negate(Dist(Times(b,Plus(C1,c,d)),Int(Times(x,Exp(Plus(Times(C2,a),Times(C2,b,x))),Power(Plus(C1,c,Negate(d),Times(Plus(C1,c,d),Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d),x),NeQ(Sqr(Plus(c,Negate(d))),C1)))),
IIntegrate(6236,Int(ArcCoth(Plus(c_DEFAULT,Times(d_DEFAULT,Tanh(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcCoth(Plus(c,Times(d,Tanh(Plus(a,Times(b,x))))))),x),Dist(Times(b,Plus(C1,Negate(c),Negate(d))),Int(Times(x,Exp(Plus(Times(C2,a),Times(C2,b,x))),Power(Plus(C1,Negate(c),d,Times(Plus(C1,Negate(c),Negate(d)),Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x),Negate(Dist(Times(b,Plus(C1,c,d)),Int(Times(x,Exp(Plus(Times(C2,a),Times(C2,b,x))),Power(Plus(C1,c,Negate(d),Times(Plus(C1,c,d),Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d),x),NeQ(Sqr(Plus(c,Negate(d))),C1)))),
IIntegrate(6237,Int(ArcTanh(Plus(c_DEFAULT,Times(Coth(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),d_DEFAULT))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcTanh(Plus(c,Times(d,Coth(Plus(a,Times(b,x))))))),x),Negate(Dist(Times(b,Plus(C1,Negate(c),Negate(d))),Int(Times(x,Exp(Plus(Times(C2,a),Times(C2,b,x))),Power(Plus(C1,Negate(c),d,Times(CN1,Plus(C1,Negate(c),Negate(d)),Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x)),Dist(Times(b,Plus(C1,c,d)),Int(Times(x,Exp(Plus(Times(C2,a),Times(C2,b,x))),Power(Plus(C1,c,Negate(d),Times(CN1,Plus(C1,c,d),Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d),x),NeQ(Sqr(Plus(c,Negate(d))),C1)))),
IIntegrate(6238,Int(ArcCoth(Plus(c_DEFAULT,Times(Coth(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),d_DEFAULT))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcCoth(Plus(c,Times(d,Coth(Plus(a,Times(b,x))))))),x),Negate(Dist(Times(b,Plus(C1,Negate(c),Negate(d))),Int(Times(x,Exp(Plus(Times(C2,a),Times(C2,b,x))),Power(Plus(C1,Negate(c),d,Times(CN1,Plus(C1,Negate(c),Negate(d)),Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x)),Dist(Times(b,Plus(C1,c,d)),Int(Times(x,Exp(Plus(Times(C2,a),Times(C2,b,x))),Power(Plus(C1,c,Negate(d),Times(CN1,Plus(C1,c,d),Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d),x),NeQ(Sqr(Plus(c,Negate(d))),C1)))),
IIntegrate(6239,Int(Times(ArcTanh(Plus(c_DEFAULT,Times(d_DEFAULT,Tanh(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcTanh(Plus(c,Times(d,Tanh(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),-1)),x),Dist(Times(b,Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Power(Plus(c,Negate(d),Times(c,Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),EqQ(Sqr(Plus(c,Negate(d))),C1)))),
IIntegrate(6240,Int(Times(ArcCoth(Plus(c_DEFAULT,Times(d_DEFAULT,Tanh(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcCoth(Plus(c,Times(d,Tanh(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),-1)),x),Dist(Times(b,Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Power(Plus(c,Negate(d),Times(c,Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),EqQ(Sqr(Plus(c,Negate(d))),C1)))),
IIntegrate(6241,Int(Times(ArcTanh(Plus(c_DEFAULT,Times(Coth(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),d_DEFAULT))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcTanh(Plus(c,Times(d,Coth(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),-1)),x),Dist(Times(b,Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Power(Plus(c,Negate(d),Times(CN1,c,Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),EqQ(Sqr(Plus(c,Negate(d))),C1)))),
IIntegrate(6242,Int(Times(ArcCoth(Plus(c_DEFAULT,Times(Coth(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),d_DEFAULT))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcCoth(Plus(c,Times(d,Coth(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),-1)),x),Dist(Times(b,Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Power(Plus(c,Negate(d),Times(CN1,c,Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),EqQ(Sqr(Plus(c,Negate(d))),C1)))),
IIntegrate(6243,Int(Times(ArcTanh(Plus(c_DEFAULT,Times(d_DEFAULT,Tanh(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcTanh(Plus(c,Times(d,Tanh(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),-1)),x),Dist(Times(b,Plus(C1,Negate(c),Negate(d)),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,a),Times(C2,b,x))),Power(Plus(C1,Negate(c),d,Times(Plus(C1,Negate(c),Negate(d)),Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x),Negate(Dist(Times(b,Plus(C1,c,d),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,a),Times(C2,b,x))),Power(Plus(C1,c,Negate(d),Times(Plus(C1,c,d),Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),NeQ(Sqr(Plus(c,Negate(d))),C1)))),
IIntegrate(6244,Int(Times(ArcCoth(Plus(c_DEFAULT,Times(d_DEFAULT,Tanh(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcCoth(Plus(c,Times(d,Tanh(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),-1)),x),Dist(Times(b,Plus(C1,Negate(c),Negate(d)),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,a),Times(C2,b,x))),Power(Plus(C1,Negate(c),d,Times(Plus(C1,Negate(c),Negate(d)),Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x),Negate(Dist(Times(b,Plus(C1,c,d),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,a),Times(C2,b,x))),Power(Plus(C1,c,Negate(d),Times(Plus(C1,c,d),Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),NeQ(Sqr(Plus(c,Negate(d))),C1)))),
IIntegrate(6245,Int(Times(ArcTanh(Plus(c_DEFAULT,Times(Coth(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),d_DEFAULT))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcTanh(Plus(c,Times(d,Coth(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),-1)),x),Negate(Dist(Times(b,Plus(C1,Negate(c),Negate(d)),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,a),Times(C2,b,x))),Power(Plus(C1,Negate(c),d,Times(CN1,Plus(C1,Negate(c),Negate(d)),Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x)),Dist(Times(b,Plus(C1,c,d),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,a),Times(C2,b,x))),Power(Plus(C1,c,Negate(d),Times(CN1,Plus(C1,c,d),Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),NeQ(Sqr(Plus(c,Negate(d))),C1)))),
IIntegrate(6246,Int(Times(ArcCoth(Plus(c_DEFAULT,Times(Coth(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),d_DEFAULT))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcCoth(Plus(c,Times(d,Coth(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),-1)),x),Negate(Dist(Times(b,Plus(C1,Negate(c),Negate(d)),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,a),Times(C2,b,x))),Power(Plus(C1,Negate(c),d,Times(CN1,Plus(C1,Negate(c),Negate(d)),Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x)),Dist(Times(b,Plus(C1,c,d),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,a),Times(C2,b,x))),Power(Plus(C1,c,Negate(d),Times(CN1,Plus(C1,c,d),Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),NeQ(Sqr(Plus(c,Negate(d))),C1)))),
IIntegrate(6247,Int(ArcTanh(Tan(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcTanh(Tan(Plus(a,Times(b,x))))),x),Negate(Dist(b,Int(Times(x,Sec(Plus(Times(C2,a),Times(C2,b,x)))),x),x))),FreeQ(List(a,b),x))),
IIntegrate(6248,Int(ArcCoth(Tan(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcCoth(Tan(Plus(a,Times(b,x))))),x),Negate(Dist(b,Int(Times(x,Sec(Plus(Times(C2,a),Times(C2,b,x)))),x),x))),FreeQ(List(a,b),x))),
IIntegrate(6249,Int(ArcTanh(Cot(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcTanh(Cot(Plus(a,Times(b,x))))),x),Negate(Dist(b,Int(Times(x,Sec(Plus(Times(C2,a),Times(C2,b,x)))),x),x))),FreeQ(List(a,b),x))),
IIntegrate(6250,Int(ArcCoth(Cot(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcCoth(Cot(Plus(a,Times(b,x))))),x),Negate(Dist(b,Int(Times(x,Sec(Plus(Times(C2,a),Times(C2,b,x)))),x),x))),FreeQ(List(a,b),x)))
  );
}