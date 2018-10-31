package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcCosh;
import static org.matheclipse.core.expression.F.ArcCoth;
import static org.matheclipse.core.expression.F.ArcCsch;
import static org.matheclipse.core.expression.F.ArcSech;
import static org.matheclipse.core.expression.F.ArcSinh;
import static org.matheclipse.core.expression.F.ArcTanh;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CI;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cot;
import static org.matheclipse.core.expression.F.Coth;
import static org.matheclipse.core.expression.F.Csch;
import static org.matheclipse.core.expression.F.D;
import static org.matheclipse.core.expression.F.Exp;
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
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.w;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FalseQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfLinear;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntHide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InverseFunctionFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PowerVariableExpn;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/** 
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class IntRules125 { 
  public static IAST RULES = List( 
IIntegrate(6251,Int(Times(ArcTanh(Tan(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcTanh(Tan(Plus(a,Times(b,x)))),Power(Times(f,Plus(m,C1)),-1)),x),Negate(Dist(Times(b,Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Sec(Plus(Times(C2,a),Times(C2,b,x)))),x),x))),And(FreeQ(List(a,b,e,f),x),IGtQ(m,C0)))),
IIntegrate(6252,Int(Times(ArcCoth(Tan(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcCoth(Tan(Plus(a,Times(b,x)))),Power(Times(f,Plus(m,C1)),-1)),x),Negate(Dist(Times(b,Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Sec(Plus(Times(C2,a),Times(C2,b,x)))),x),x))),And(FreeQ(List(a,b,e,f),x),IGtQ(m,C0)))),
IIntegrate(6253,Int(Times(ArcTanh(Cot(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcTanh(Cot(Plus(a,Times(b,x)))),Power(Times(f,Plus(m,C1)),-1)),x),Negate(Dist(Times(b,Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Sec(Plus(Times(C2,a),Times(C2,b,x)))),x),x))),And(FreeQ(List(a,b,e,f),x),IGtQ(m,C0)))),
IIntegrate(6254,Int(Times(ArcCoth(Cot(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcCoth(Cot(Plus(a,Times(b,x)))),Power(Times(f,Plus(m,C1)),-1)),x),Negate(Dist(Times(b,Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Sec(Plus(Times(C2,a),Times(C2,b,x)))),x),x))),And(FreeQ(List(a,b,e,f),x),IGtQ(m,C0)))),
IIntegrate(6255,Int(ArcTanh(Plus(c_DEFAULT,Times(d_DEFAULT,Tan(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcTanh(Plus(c,Times(d,Tan(Plus(a,Times(b,x))))))),x),Dist(Times(CI,b),Int(Times(x,Power(Plus(c,Times(CI,d),Times(c,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d),x),EqQ(Sqr(Plus(c,Times(CI,d))),C1)))),
IIntegrate(6256,Int(ArcCoth(Plus(c_DEFAULT,Times(d_DEFAULT,Tan(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcCoth(Plus(c,Times(d,Tan(Plus(a,Times(b,x))))))),x),Dist(Times(CI,b),Int(Times(x,Power(Plus(c,Times(CI,d),Times(c,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d),x),EqQ(Sqr(Plus(c,Times(CI,d))),C1)))),
IIntegrate(6257,Int(ArcTanh(Plus(c_DEFAULT,Times(Cot(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),d_DEFAULT))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcTanh(Plus(c,Times(d,Cot(Plus(a,Times(b,x))))))),x),Dist(Times(CI,b),Int(Times(x,Power(Plus(c,Times(CN1,CI,d),Times(CN1,c,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d),x),EqQ(Sqr(Plus(c,Times(CN1,CI,d))),C1)))),
IIntegrate(6258,Int(ArcCoth(Plus(c_DEFAULT,Times(Cot(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),d_DEFAULT))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcCoth(Plus(c,Times(d,Cot(Plus(a,Times(b,x))))))),x),Dist(Times(CI,b),Int(Times(x,Power(Plus(c,Times(CN1,CI,d),Times(CN1,c,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d),x),EqQ(Sqr(Plus(c,Times(CN1,CI,d))),C1)))),
IIntegrate(6259,Int(ArcTanh(Plus(c_DEFAULT,Times(d_DEFAULT,Tan(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcTanh(Plus(c,Times(d,Tan(Plus(a,Times(b,x))))))),x),Negate(Dist(Times(CI,b,Plus(C1,c,Times(CN1,CI,d))),Int(Times(x,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,c,Times(CI,d),Times(Plus(C1,c,Times(CN1,CI,d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),Dist(Times(CI,b,Plus(C1,Negate(c),Times(CI,d))),Int(Times(x,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,Negate(c),Times(CN1,CI,d),Times(Plus(C1,Negate(c),Times(CI,d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d),x),NeQ(Sqr(Plus(c,Times(CI,d))),C1)))),
IIntegrate(6260,Int(ArcCoth(Plus(c_DEFAULT,Times(d_DEFAULT,Tan(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcCoth(Plus(c,Times(d,Tan(Plus(a,Times(b,x))))))),x),Negate(Dist(Times(CI,b,Plus(C1,c,Times(CN1,CI,d))),Int(Times(x,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,c,Times(CI,d),Times(Plus(C1,c,Times(CN1,CI,d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),Dist(Times(CI,b,Plus(C1,Negate(c),Times(CI,d))),Int(Times(x,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,Negate(c),Times(CN1,CI,d),Times(Plus(C1,Negate(c),Times(CI,d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d),x),NeQ(Sqr(Plus(c,Times(CI,d))),C1)))),
IIntegrate(6261,Int(ArcTanh(Plus(c_DEFAULT,Times(Cot(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),d_DEFAULT))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcTanh(Plus(c,Times(d,Cot(Plus(a,Times(b,x))))))),x),Negate(Dist(Times(CI,b,Plus(C1,Negate(c),Times(CN1,CI,d))),Int(Times(x,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,Negate(c),Times(CI,d),Times(CN1,Plus(C1,Negate(c),Times(CN1,CI,d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),Dist(Times(CI,b,Plus(C1,c,Times(CI,d))),Int(Times(x,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,c,Times(CN1,CI,d),Times(CN1,Plus(C1,c,Times(CI,d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d),x),NeQ(Sqr(Plus(c,Times(CN1,CI,d))),C1)))),
IIntegrate(6262,Int(ArcCoth(Plus(c_DEFAULT,Times(Cot(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),d_DEFAULT))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcCoth(Plus(c,Times(d,Cot(Plus(a,Times(b,x))))))),x),Negate(Dist(Times(CI,b,Plus(C1,Negate(c),Times(CN1,CI,d))),Int(Times(x,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,Negate(c),Times(CI,d),Times(CN1,Plus(C1,Negate(c),Times(CN1,CI,d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),Dist(Times(CI,b,Plus(C1,c,Times(CI,d))),Int(Times(x,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,c,Times(CN1,CI,d),Times(CN1,Plus(C1,c,Times(CI,d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d),x),NeQ(Sqr(Plus(c,Times(CN1,CI,d))),C1)))),
IIntegrate(6263,Int(Times(ArcTanh(Plus(c_DEFAULT,Times(d_DEFAULT,Tan(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcTanh(Plus(c,Times(d,Tan(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),-1)),x),Dist(Times(CI,b,Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Power(Plus(c,Times(CI,d),Times(c,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),EqQ(Sqr(Plus(c,Times(CI,d))),C1)))),
IIntegrate(6264,Int(Times(ArcCoth(Plus(c_DEFAULT,Times(d_DEFAULT,Tan(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcCoth(Plus(c,Times(d,Tan(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),-1)),x),Dist(Times(CI,b,Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Power(Plus(c,Times(CI,d),Times(c,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),EqQ(Sqr(Plus(c,Times(CI,d))),C1)))),
IIntegrate(6265,Int(Times(ArcTanh(Plus(c_DEFAULT,Times(Cot(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),d_DEFAULT))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcTanh(Plus(c,Times(d,Cot(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),-1)),x),Dist(Times(CI,b,Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Power(Plus(c,Times(CN1,CI,d),Times(CN1,c,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),EqQ(Sqr(Plus(c,Times(CN1,CI,d))),C1)))),
IIntegrate(6266,Int(Times(ArcCoth(Plus(c_DEFAULT,Times(Cot(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),d_DEFAULT))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcCoth(Plus(c,Times(d,Cot(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),-1)),x),Dist(Times(CI,b,Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Power(Plus(c,Times(CN1,CI,d),Times(CN1,c,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),EqQ(Sqr(Plus(c,Times(CN1,CI,d))),C1)))),
IIntegrate(6267,Int(Times(ArcTanh(Plus(c_DEFAULT,Times(d_DEFAULT,Tan(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcTanh(Plus(c,Times(d,Tan(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),-1)),x),Negate(Dist(Times(CI,b,Plus(C1,c,Times(CN1,CI,d)),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,c,Times(CI,d),Times(Plus(C1,c,Times(CN1,CI,d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),Dist(Times(CI,b,Plus(C1,Negate(c),Times(CI,d)),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,Negate(c),Times(CN1,CI,d),Times(Plus(C1,Negate(c),Times(CI,d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),NeQ(Sqr(Plus(c,Times(CI,d))),C1)))),
IIntegrate(6268,Int(Times(ArcCoth(Plus(c_DEFAULT,Times(d_DEFAULT,Tan(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcCoth(Plus(c,Times(d,Tan(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),-1)),x),Negate(Dist(Times(CI,b,Plus(C1,c,Times(CN1,CI,d)),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,c,Times(CI,d),Times(Plus(C1,c,Times(CN1,CI,d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),Dist(Times(CI,b,Plus(C1,Negate(c),Times(CI,d)),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,Negate(c),Times(CN1,CI,d),Times(Plus(C1,Negate(c),Times(CI,d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),NeQ(Sqr(Plus(c,Times(CI,d))),C1)))),
IIntegrate(6269,Int(Times(ArcTanh(Plus(c_DEFAULT,Times(Cot(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),d_DEFAULT))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcTanh(Plus(c,Times(d,Cot(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),-1)),x),Negate(Dist(Times(CI,b,Plus(C1,Negate(c),Times(CN1,CI,d)),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,Negate(c),Times(CI,d),Times(CN1,Plus(C1,Negate(c),Times(CN1,CI,d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),Dist(Times(CI,b,Plus(C1,c,Times(CI,d)),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,c,Times(CN1,CI,d),Times(CN1,Plus(C1,c,Times(CI,d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),NeQ(Sqr(Plus(c,Times(CN1,CI,d))),C1)))),
IIntegrate(6270,Int(Times(ArcCoth(Plus(c_DEFAULT,Times(Cot(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),d_DEFAULT))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcCoth(Plus(c,Times(d,Cot(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),-1)),x),Negate(Dist(Times(CI,b,Plus(C1,Negate(c),Times(CN1,CI,d)),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,Negate(c),Times(CI,d),Times(CN1,Plus(C1,Negate(c),Times(CN1,CI,d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),Dist(Times(CI,b,Plus(C1,c,Times(CI,d)),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,c,Times(CN1,CI,d),Times(CN1,Plus(C1,c,Times(CI,d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),NeQ(Sqr(Plus(c,Times(CN1,CI,d))),C1)))),
IIntegrate(6271,Int(ArcTanh(u_),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcTanh(u)),x),Negate(Int(SimplifyIntegrand(Times(x,D(u,x),Power(Plus(C1,Negate(Sqr(u))),-1)),x),x))),InverseFunctionFreeQ(u,x))),
IIntegrate(6272,Int(ArcCoth(u_),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcCoth(u)),x),Negate(Int(SimplifyIntegrand(Times(x,D(u,x),Power(Plus(C1,Negate(Sqr(u))),-1)),x),x))),InverseFunctionFreeQ(u,x))),
IIntegrate(6273,Int(Times(Plus(a_DEFAULT,Times(ArcTanh(u_),b_DEFAULT)),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(c,Times(d,x)),Plus(m,C1)),Plus(a,Times(b,ArcTanh(u))),Power(Times(d,Plus(m,C1)),-1)),x),Negate(Dist(Times(b,Power(Times(d,Plus(m,C1)),-1)),Int(SimplifyIntegrand(Times(Power(Plus(c,Times(d,x)),Plus(m,C1)),D(u,x),Power(Plus(C1,Negate(Sqr(u))),-1)),x),x),x))),And(FreeQ(List(a,b,c,d,m),x),NeQ(m,CN1),InverseFunctionFreeQ(u,x),Not(FunctionOfQ(Power(Plus(c,Times(d,x)),Plus(m,C1)),u,x)),FalseQ(PowerVariableExpn(u,Plus(m,C1),x))))),
IIntegrate(6274,Int(Times(Plus(a_DEFAULT,Times(ArcCoth(u_),b_DEFAULT)),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(c,Times(d,x)),Plus(m,C1)),Plus(a,Times(b,ArcCoth(u))),Power(Times(d,Plus(m,C1)),-1)),x),Negate(Dist(Times(b,Power(Times(d,Plus(m,C1)),-1)),Int(SimplifyIntegrand(Times(Power(Plus(c,Times(d,x)),Plus(m,C1)),D(u,x),Power(Plus(C1,Negate(Sqr(u))),-1)),x),x),x))),And(FreeQ(List(a,b,c,d,m),x),NeQ(m,CN1),InverseFunctionFreeQ(u,x),Not(FunctionOfQ(Power(Plus(c,Times(d,x)),Plus(m,C1)),u,x)),FalseQ(PowerVariableExpn(u,Plus(m,C1),x))))),
IIntegrate(6275,Int(Times(Plus(a_DEFAULT,Times(ArcTanh(u_),b_DEFAULT)),v_),x_Symbol),
    Condition(With(List(Set(w,IntHide(v,x))),Condition(Plus(Dist(Plus(a,Times(b,ArcTanh(u))),w,x),Negate(Dist(b,Int(SimplifyIntegrand(Times(w,D(u,x),Power(Plus(C1,Negate(Sqr(u))),-1)),x),x),x))),InverseFunctionFreeQ(w,x))),And(FreeQ(List(a,b),x),InverseFunctionFreeQ(u,x),Not(MatchQ(v,Condition(Power(Plus(c_DEFAULT,Times(d_DEFAULT,x)),m_DEFAULT),FreeQ(List(c,d,m),x)))),FalseQ(FunctionOfLinear(Times(v,Plus(a,Times(b,ArcTanh(u)))),x))))),
IIntegrate(6276,Int(Times(Plus(a_DEFAULT,Times(ArcCoth(u_),b_DEFAULT)),v_),x_Symbol),
    Condition(With(List(Set(w,IntHide(v,x))),Condition(Plus(Dist(Plus(a,Times(b,ArcCoth(u))),w,x),Negate(Dist(b,Int(SimplifyIntegrand(Times(w,D(u,x),Power(Plus(C1,Negate(Sqr(u))),-1)),x),x),x))),InverseFunctionFreeQ(w,x))),And(FreeQ(List(a,b),x),InverseFunctionFreeQ(u,x),Not(MatchQ(v,Condition(Power(Plus(c_DEFAULT,Times(d_DEFAULT,x)),m_DEFAULT),FreeQ(List(c,d,m),x)))),FalseQ(FunctionOfLinear(Times(v,Plus(a,Times(b,ArcCoth(u)))),x))))),
IIntegrate(6277,Int(ArcSech(Times(c_DEFAULT,x_)),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcSech(Times(c,x))),x),Dist(Times(Sqrt(Plus(C1,Times(c,x))),Sqrt(Power(Plus(C1,Times(c,x)),-1))),Int(Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),CN1D2),x),x)),FreeQ(c,x))),
IIntegrate(6278,Int(ArcCsch(Times(c_DEFAULT,x_)),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcCsch(Times(c,x))),x),Dist(Power(c,-1),Int(Power(Times(x,Sqrt(Plus(C1,Power(Times(Sqr(c),Sqr(x)),-1)))),-1),x),x)),FreeQ(c,x))),
IIntegrate(6279,Int(Power(Plus(a_DEFAULT,Times(ArcSech(Times(c_DEFAULT,x_)),b_DEFAULT)),n_),x_Symbol),
    Condition(Negate(Dist(Power(c,-1),Subst(Int(Times(Power(Plus(a,Times(b,x)),n),Sech(x),Tanh(x)),x),x,ArcSech(Times(c,x))),x)),And(FreeQ(List(a,b,c,n),x),IGtQ(n,C0)))),
IIntegrate(6280,Int(Power(Plus(a_DEFAULT,Times(ArcCsch(Times(c_DEFAULT,x_)),b_DEFAULT)),n_),x_Symbol),
    Condition(Negate(Dist(Power(c,-1),Subst(Int(Times(Power(Plus(a,Times(b,x)),n),Csch(x),Coth(x)),x),x,ArcCsch(Times(c,x))),x)),And(FreeQ(List(a,b,c,n),x),IGtQ(n,C0)))),
IIntegrate(6281,Int(Times(Plus(a_DEFAULT,Times(ArcSech(Times(c_DEFAULT,x_)),b_DEFAULT)),Power(x_,-1)),x_Symbol),
    Condition(Negate(Subst(Int(Times(Plus(a,Times(b,ArcCosh(Times(x,Power(c,-1))))),Power(x,-1)),x),x,Power(x,-1))),FreeQ(List(a,b,c),x))),
IIntegrate(6282,Int(Times(Plus(a_DEFAULT,Times(ArcCsch(Times(c_DEFAULT,x_)),b_DEFAULT)),Power(x_,-1)),x_Symbol),
    Condition(Negate(Subst(Int(Times(Plus(a,Times(b,ArcSinh(Times(x,Power(c,-1))))),Power(x,-1)),x),x,Power(x,-1))),FreeQ(List(a,b,c),x))),
IIntegrate(6283,Int(Times(Plus(a_DEFAULT,Times(ArcSech(Times(c_DEFAULT,x_)),b_DEFAULT)),Power(Times(d_DEFAULT,x_),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(d,x),Plus(m,C1)),Plus(a,Times(b,ArcSech(Times(c,x)))),Power(Times(d,Plus(m,C1)),-1)),x),Dist(Times(b,Sqrt(Plus(C1,Times(c,x))),Sqrt(Power(Plus(C1,Times(c,x)),-1)),Power(Plus(m,C1),-1)),Int(Times(Power(Times(d,x),m),Power(Times(Sqrt(Plus(C1,Times(CN1,c,x))),Sqrt(Plus(C1,Times(c,x)))),-1)),x),x)),And(FreeQ(List(a,b,c,d,m),x),NeQ(m,CN1)))),
IIntegrate(6284,Int(Times(Plus(a_DEFAULT,Times(ArcCsch(Times(c_DEFAULT,x_)),b_DEFAULT)),Power(Times(d_DEFAULT,x_),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(d,x),Plus(m,C1)),Plus(a,Times(b,ArcCsch(Times(c,x)))),Power(Times(d,Plus(m,C1)),-1)),x),Dist(Times(b,d,Power(Times(c,Plus(m,C1)),-1)),Int(Times(Power(Times(d,x),Plus(m,Negate(C1))),Power(Plus(C1,Power(Times(Sqr(c),Sqr(x)),-1)),CN1D2)),x),x)),And(FreeQ(List(a,b,c,d,m),x),NeQ(m,CN1)))),
IIntegrate(6285,Int(Times(Power(Plus(a_DEFAULT,Times(ArcSech(Times(c_DEFAULT,x_)),b_DEFAULT)),n_),Power(x_,m_DEFAULT)),x_Symbol),
    Condition(Negate(Dist(Power(Power(c,Plus(m,C1)),-1),Subst(Int(Times(Power(Plus(a,Times(b,x)),n),Power(Sech(x),Plus(m,C1)),Tanh(x)),x),x,ArcSech(Times(c,x))),x)),And(FreeQ(List(a,b,c),x),IntegerQ(n),IntegerQ(m),Or(GtQ(n,C0),LtQ(m,CN1))))),
IIntegrate(6286,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCsch(Times(c_DEFAULT,x_)),b_DEFAULT)),n_),Power(x_,m_DEFAULT)),x_Symbol),
    Condition(Negate(Dist(Power(Power(c,Plus(m,C1)),-1),Subst(Int(Times(Power(Plus(a,Times(b,x)),n),Power(Csch(x),Plus(m,C1)),Coth(x)),x),x,ArcCsch(Times(c,x))),x)),And(FreeQ(List(a,b,c),x),IntegerQ(n),IntegerQ(m),Or(GtQ(n,C0),LtQ(m,CN1))))),
IIntegrate(6287,Int(Times(Plus(a_DEFAULT,Times(ArcSech(Times(c_DEFAULT,x_)),b_DEFAULT)),Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),-1)),x_Symbol),
    Condition(Plus(Simp(Times(Plus(a,Times(b,ArcSech(Times(c,x)))),Log(Plus(C1,Times(Plus(e,Negate(Sqrt(Plus(Times(CN1,Sqr(c),Sqr(d)),Sqr(e))))),Power(Times(c,d,Exp(ArcSech(Times(c,x)))),-1)))),Power(e,-1)),x),Dist(Times(b,Power(e,-1)),Int(Times(Sqrt(Times(Plus(C1,Times(CN1,c,x)),Power(Plus(C1,Times(c,x)),-1))),Log(Plus(C1,Times(Plus(e,Negate(Sqrt(Plus(Times(CN1,Sqr(c),Sqr(d)),Sqr(e))))),Power(Times(c,d,Exp(ArcSech(Times(c,x)))),-1)))),Power(Times(x,Plus(C1,Times(CN1,c,x))),-1)),x),x),Dist(Times(b,Power(e,-1)),Int(Times(Sqrt(Times(Plus(C1,Times(CN1,c,x)),Power(Plus(C1,Times(c,x)),-1))),Log(Plus(C1,Times(Plus(e,Sqrt(Plus(Times(CN1,Sqr(c),Sqr(d)),Sqr(e)))),Power(Times(c,d,Exp(ArcSech(Times(c,x)))),-1)))),Power(Times(x,Plus(C1,Times(CN1,c,x))),-1)),x),x),Negate(Dist(Times(b,Power(e,-1)),Int(Times(Sqrt(Times(Plus(C1,Times(CN1,c,x)),Power(Plus(C1,Times(c,x)),-1))),Log(Plus(C1,Power(Exp(Times(C2,ArcSech(Times(c,x)))),-1))),Power(Times(x,Plus(C1,Times(CN1,c,x))),-1)),x),x)),Simp(Times(Plus(a,Times(b,ArcSech(Times(c,x)))),Log(Plus(C1,Times(Plus(e,Sqrt(Plus(Times(CN1,Sqr(c),Sqr(d)),Sqr(e)))),Power(Times(c,d,Exp(ArcSech(Times(c,x)))),-1)))),Power(e,-1)),x),Negate(Simp(Times(Plus(a,Times(b,ArcSech(Times(c,x)))),Log(Plus(C1,Power(Exp(Times(C2,ArcSech(Times(c,x)))),-1))),Power(e,-1)),x))),FreeQ(List(a,b,c,d,e),x))),
IIntegrate(6288,Int(Times(Plus(a_DEFAULT,Times(ArcSech(Times(c_DEFAULT,x_)),b_DEFAULT)),Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(d,Times(e,x)),Plus(m,C1)),Plus(a,Times(b,ArcSech(Times(c,x)))),Power(Times(e,Plus(m,C1)),-1)),x),Dist(Times(b,Sqrt(Plus(C1,Times(c,x))),Sqrt(Power(Plus(C1,Times(c,x)),-1)),Power(Times(e,Plus(m,C1)),-1)),Int(Times(Power(Plus(d,Times(e,x)),Plus(m,C1)),Power(Times(x,Sqrt(Plus(C1,Times(CN1,Sqr(c),Sqr(x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,m),x),NeQ(m,CN1)))),
IIntegrate(6289,Int(Times(Plus(a_DEFAULT,Times(ArcCsch(Times(c_DEFAULT,x_)),b_DEFAULT)),Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),-1)),x_Symbol),
    Condition(Plus(Simp(Times(Plus(a,Times(b,ArcCsch(Times(c,x)))),Log(Plus(C1,Times(CN1,Plus(e,Negate(Sqrt(Plus(Times(Sqr(c),Sqr(d)),Sqr(e))))),Exp(ArcCsch(Times(c,x))),Power(Times(c,d),-1)))),Power(e,-1)),x),Dist(Times(b,Power(Times(c,e),-1)),Int(Times(Log(Plus(C1,Times(CN1,Plus(e,Negate(Sqrt(Plus(Times(Sqr(c),Sqr(d)),Sqr(e))))),Exp(ArcCsch(Times(c,x))),Power(Times(c,d),-1)))),Power(Times(Sqr(x),Sqrt(Plus(C1,Power(Times(Sqr(c),Sqr(x)),-1)))),-1)),x),x),Dist(Times(b,Power(Times(c,e),-1)),Int(Times(Log(Plus(C1,Times(CN1,Plus(e,Sqrt(Plus(Times(Sqr(c),Sqr(d)),Sqr(e)))),Exp(ArcCsch(Times(c,x))),Power(Times(c,d),-1)))),Power(Times(Sqr(x),Sqrt(Plus(C1,Power(Times(Sqr(c),Sqr(x)),-1)))),-1)),x),x),Negate(Dist(Times(b,Power(Times(c,e),-1)),Int(Times(Log(Plus(C1,Negate(Exp(Times(C2,ArcCsch(Times(c,x))))))),Power(Times(Sqr(x),Sqrt(Plus(C1,Power(Times(Sqr(c),Sqr(x)),-1)))),-1)),x),x)),Simp(Times(Plus(a,Times(b,ArcCsch(Times(c,x)))),Log(Plus(C1,Times(CN1,Plus(e,Sqrt(Plus(Times(Sqr(c),Sqr(d)),Sqr(e)))),Exp(ArcCsch(Times(c,x))),Power(Times(c,d),-1)))),Power(e,-1)),x),Negate(Simp(Times(Plus(a,Times(b,ArcCsch(Times(c,x)))),Log(Plus(C1,Negate(Exp(Times(C2,ArcCsch(Times(c,x))))))),Power(e,-1)),x))),FreeQ(List(a,b,c,d,e),x))),
IIntegrate(6290,Int(Times(Plus(a_DEFAULT,Times(ArcCsch(Times(c_DEFAULT,x_)),b_DEFAULT)),Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(d,Times(e,x)),Plus(m,C1)),Plus(a,Times(b,ArcCsch(Times(c,x)))),Power(Times(e,Plus(m,C1)),-1)),x),Dist(Times(b,Power(Times(c,e,Plus(m,C1)),-1)),Int(Times(Power(Plus(d,Times(e,x)),Plus(m,C1)),Power(Times(Sqr(x),Sqrt(Plus(C1,Power(Times(Sqr(c),Sqr(x)),-1)))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,m),x),NeQ(m,CN1)))),
IIntegrate(6291,Int(Times(Plus(a_DEFAULT,Times(ArcSech(Times(c_DEFAULT,x_)),b_DEFAULT)),Power(Plus(d_DEFAULT,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(With(List(Set(u,IntHide(Power(Plus(d,Times(e,Sqr(x))),p),x))),Plus(Dist(Plus(a,Times(b,ArcSech(Times(c,x)))),u,x),Dist(Times(b,Sqrt(Plus(C1,Times(c,x))),Sqrt(Power(Plus(C1,Times(c,x)),-1))),Int(SimplifyIntegrand(Times(u,Power(Times(x,Sqrt(Plus(C1,Times(CN1,c,x))),Sqrt(Plus(C1,Times(c,x)))),-1)),x),x),x))),And(FreeQ(List(a,b,c,d,e),x),Or(IGtQ(p,C0),ILtQ(Plus(p,C1D2),C0))))),
IIntegrate(6292,Int(Times(Plus(a_DEFAULT,Times(ArcCsch(Times(c_DEFAULT,x_)),b_DEFAULT)),Power(Plus(d_DEFAULT,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(With(List(Set(u,IntHide(Power(Plus(d,Times(e,Sqr(x))),p),x))),Plus(Dist(Plus(a,Times(b,ArcCsch(Times(c,x)))),u,x),Negate(Dist(Times(b,c,x,Power(Times(CN1,Sqr(c),Sqr(x)),CN1D2)),Int(SimplifyIntegrand(Times(u,Power(Times(x,Sqrt(Plus(CN1,Times(CN1,Sqr(c),Sqr(x))))),-1)),x),x),x)))),And(FreeQ(List(a,b,c,d,e),x),Or(IGtQ(p,C0),ILtQ(Plus(p,C1D2),C0))))),
IIntegrate(6293,Int(Times(Power(Plus(a_DEFAULT,Times(ArcSech(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Plus(d_DEFAULT,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Negate(Subst(Int(Times(Power(Plus(e,Times(d,Sqr(x))),p),Power(Plus(a,Times(b,ArcCosh(Times(x,Power(c,-1))))),n),Power(Power(x,Times(C2,Plus(p,C1))),-1)),x),x,Power(x,-1))),And(FreeQ(List(a,b,c,d,e,n),x),IGtQ(n,C0),IntegerQ(p)))),
IIntegrate(6294,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCsch(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Plus(d_DEFAULT,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Negate(Subst(Int(Times(Power(Plus(e,Times(d,Sqr(x))),p),Power(Plus(a,Times(b,ArcSinh(Times(x,Power(c,-1))))),n),Power(Power(x,Times(C2,Plus(p,C1))),-1)),x),x,Power(x,-1))),And(FreeQ(List(a,b,c,d,e,n),x),IGtQ(n,C0),IntegerQ(p)))),
IIntegrate(6295,Int(Times(Power(Plus(a_DEFAULT,Times(ArcSech(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Plus(d_DEFAULT,Times(e_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Negate(Dist(Times(Sqrt(Sqr(x)),Power(x,-1)),Subst(Int(Times(Power(Plus(e,Times(d,Sqr(x))),p),Power(Plus(a,Times(b,ArcCosh(Times(x,Power(c,-1))))),n),Power(Power(x,Times(C2,Plus(p,C1))),-1)),x),x,Power(x,-1)),x)),And(FreeQ(List(a,b,c,d,e,n),x),IGtQ(n,C0),EqQ(Plus(Times(Sqr(c),d),e),C0),IntegerQ(Plus(p,C1D2)),GtQ(e,C0),LtQ(d,C0)))),
IIntegrate(6296,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCsch(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Plus(d_DEFAULT,Times(e_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Negate(Dist(Times(Sqrt(Sqr(x)),Power(x,-1)),Subst(Int(Times(Power(Plus(e,Times(d,Sqr(x))),p),Power(Plus(a,Times(b,ArcSinh(Times(x,Power(c,-1))))),n),Power(Power(x,Times(C2,Plus(p,C1))),-1)),x),x,Power(x,-1)),x)),And(FreeQ(List(a,b,c,d,e,n),x),IGtQ(n,C0),EqQ(Plus(e,Times(CN1,Sqr(c),d)),C0),IntegerQ(Plus(p,C1D2)),GtQ(e,C0),LtQ(d,C0)))),
IIntegrate(6297,Int(Times(Power(Plus(a_DEFAULT,Times(ArcSech(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Plus(d_DEFAULT,Times(e_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Negate(Dist(Times(Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Times(x,Sqrt(Plus(e,Times(d,Power(x,-2))))),-1)),Subst(Int(Times(Power(Plus(e,Times(d,Sqr(x))),p),Power(Plus(a,Times(b,ArcCosh(Times(x,Power(c,-1))))),n),Power(Power(x,Times(C2,Plus(p,C1))),-1)),x),x,Power(x,-1)),x)),And(FreeQ(List(a,b,c,d,e,n),x),IGtQ(n,C0),EqQ(Plus(Times(Sqr(c),d),e),C0),IntegerQ(Plus(p,C1D2)),Not(And(GtQ(e,C0),LtQ(d,C0)))))),
IIntegrate(6298,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCsch(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Plus(d_DEFAULT,Times(e_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Negate(Dist(Times(Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Times(x,Sqrt(Plus(e,Times(d,Power(x,-2))))),-1)),Subst(Int(Times(Power(Plus(e,Times(d,Sqr(x))),p),Power(Plus(a,Times(b,ArcSinh(Times(x,Power(c,-1))))),n),Power(Power(x,Times(C2,Plus(p,C1))),-1)),x),x,Power(x,-1)),x)),And(FreeQ(List(a,b,c,d,e,n),x),IGtQ(n,C0),EqQ(Plus(e,Times(CN1,Sqr(c),d)),C0),IntegerQ(Plus(p,C1D2)),Not(And(GtQ(e,C0),LtQ(d,C0)))))),
IIntegrate(6299,Int(Times(Plus(a_DEFAULT,Times(ArcSech(Times(c_DEFAULT,x_)),b_DEFAULT)),x_,Power(Plus(d_DEFAULT,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Plus(a,Times(b,ArcSech(Times(c,x)))),Power(Times(C2,e,Plus(p,C1)),-1)),x),Dist(Times(b,Sqrt(Plus(C1,Times(c,x))),Sqrt(Power(Plus(C1,Times(c,x)),-1)),Power(Times(C2,e,Plus(p,C1)),-1)),Int(Times(Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Times(x,Sqrt(Plus(C1,Times(CN1,c,x))),Sqrt(Plus(C1,Times(c,x)))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,p),x),NeQ(p,CN1)))),
IIntegrate(6300,Int(Times(Plus(a_DEFAULT,Times(ArcCsch(Times(c_DEFAULT,x_)),b_DEFAULT)),x_,Power(Plus(d_DEFAULT,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Plus(a,Times(b,ArcCsch(Times(c,x)))),Power(Times(C2,e,Plus(p,C1)),-1)),x),Negate(Dist(Times(b,c,x,Power(Times(C2,e,Plus(p,C1),Sqrt(Times(CN1,Sqr(c),Sqr(x)))),-1)),Int(Times(Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Times(x,Sqrt(Plus(CN1,Times(CN1,Sqr(c),Sqr(x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,p),x),NeQ(p,CN1))))
  );
}
