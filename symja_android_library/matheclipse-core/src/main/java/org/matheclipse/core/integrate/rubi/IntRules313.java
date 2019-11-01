package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.*;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.*;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.*;
import org.matheclipse.core.interfaces.IAST;

/** 
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class IntRules313 { 
  public static IAST RULES = List( 
IIntegrate(6261,Int(ArcTanh(Plus(c_DEFAULT,Times(Cot(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),d_DEFAULT))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcTanh(Plus(c,Times(d,Cot(Plus(a,Times(b,x))))))),x),Negate(Dist(Times(CI,b,Subtract(Subtract(C1,c),Times(CI,d))),Int(Times(x,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Subtract(Plus(C1,Negate(c),Times(CI,d)),Times(Subtract(Subtract(C1,c),Times(CI,d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),CN1)),x),x)),Dist(Times(CI,b,Plus(C1,c,Times(CI,d))),Int(Times(x,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Subtract(Subtract(Plus(C1,c),Times(CI,d)),Times(Plus(C1,c,Times(CI,d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),CN1)),x),x)),And(FreeQ(List(a,b,c,d),x),NeQ(Sqr(Subtract(c,Times(CI,d))),C1)))),
IIntegrate(6262,Int(ArcCoth(Plus(c_DEFAULT,Times(Cot(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),d_DEFAULT))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcCoth(Plus(c,Times(d,Cot(Plus(a,Times(b,x))))))),x),Negate(Dist(Times(CI,b,Subtract(Subtract(C1,c),Times(CI,d))),Int(Times(x,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Subtract(Plus(C1,Negate(c),Times(CI,d)),Times(Subtract(Subtract(C1,c),Times(CI,d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),CN1)),x),x)),Dist(Times(CI,b,Plus(C1,c,Times(CI,d))),Int(Times(x,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Subtract(Subtract(Plus(C1,c),Times(CI,d)),Times(Plus(C1,c,Times(CI,d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),CN1)),x),x)),And(FreeQ(List(a,b,c,d),x),NeQ(Sqr(Subtract(c,Times(CI,d))),C1)))),
IIntegrate(6263,Int(Times(ArcTanh(Plus(c_DEFAULT,Times(d_DEFAULT,Tan(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcTanh(Plus(c,Times(d,Tan(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),CN1)),x),Dist(Times(CI,b,Power(Times(f,Plus(m,C1)),CN1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Power(Plus(c,Times(CI,d),Times(c,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),CN1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),EqQ(Sqr(Plus(c,Times(CI,d))),C1)))),
IIntegrate(6264,Int(Times(ArcCoth(Plus(c_DEFAULT,Times(d_DEFAULT,Tan(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcCoth(Plus(c,Times(d,Tan(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),CN1)),x),Dist(Times(CI,b,Power(Times(f,Plus(m,C1)),CN1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Power(Plus(c,Times(CI,d),Times(c,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),CN1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),EqQ(Sqr(Plus(c,Times(CI,d))),C1)))),
IIntegrate(6265,Int(Times(ArcTanh(Plus(c_DEFAULT,Times(Cot(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),d_DEFAULT))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcTanh(Plus(c,Times(d,Cot(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),CN1)),x),Dist(Times(CI,b,Power(Times(f,Plus(m,C1)),CN1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Power(Subtract(Subtract(c,Times(CI,d)),Times(c,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),CN1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),EqQ(Sqr(Subtract(c,Times(CI,d))),C1)))),
IIntegrate(6266,Int(Times(ArcCoth(Plus(c_DEFAULT,Times(Cot(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),d_DEFAULT))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcCoth(Plus(c,Times(d,Cot(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),CN1)),x),Dist(Times(CI,b,Power(Times(f,Plus(m,C1)),CN1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Power(Subtract(Subtract(c,Times(CI,d)),Times(c,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),CN1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),EqQ(Sqr(Subtract(c,Times(CI,d))),C1)))),
IIntegrate(6267,Int(Times(ArcTanh(Plus(c_DEFAULT,Times(d_DEFAULT,Tan(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcTanh(Plus(c,Times(d,Tan(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),CN1)),x),Negate(Dist(Times(CI,b,Subtract(Plus(C1,c),Times(CI,d)),Power(Times(f,Plus(m,C1)),CN1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,c,Times(CI,d),Times(Subtract(Plus(C1,c),Times(CI,d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),CN1)),x),x)),Dist(Times(CI,b,Plus(C1,Negate(c),Times(CI,d)),Power(Times(f,Plus(m,C1)),CN1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,Negate(c),Times(CN1,CI,d),Times(Plus(C1,Negate(c),Times(CI,d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),CN1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),NeQ(Sqr(Plus(c,Times(CI,d))),C1)))),
IIntegrate(6268,Int(Times(ArcCoth(Plus(c_DEFAULT,Times(d_DEFAULT,Tan(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcCoth(Plus(c,Times(d,Tan(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),CN1)),x),Negate(Dist(Times(CI,b,Subtract(Plus(C1,c),Times(CI,d)),Power(Times(f,Plus(m,C1)),CN1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,c,Times(CI,d),Times(Subtract(Plus(C1,c),Times(CI,d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),CN1)),x),x)),Dist(Times(CI,b,Plus(C1,Negate(c),Times(CI,d)),Power(Times(f,Plus(m,C1)),CN1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,Negate(c),Times(CN1,CI,d),Times(Plus(C1,Negate(c),Times(CI,d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),CN1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),NeQ(Sqr(Plus(c,Times(CI,d))),C1)))),
IIntegrate(6269,Int(Times(ArcTanh(Plus(c_DEFAULT,Times(Cot(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),d_DEFAULT))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcTanh(Plus(c,Times(d,Cot(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),CN1)),x),Negate(Dist(Times(CI,b,Subtract(Subtract(C1,c),Times(CI,d)),Power(Times(f,Plus(m,C1)),CN1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Subtract(Plus(C1,Negate(c),Times(CI,d)),Times(Subtract(Subtract(C1,c),Times(CI,d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),CN1)),x),x)),Dist(Times(CI,b,Plus(C1,c,Times(CI,d)),Power(Times(f,Plus(m,C1)),CN1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Subtract(Subtract(Plus(C1,c),Times(CI,d)),Times(Plus(C1,c,Times(CI,d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),CN1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),NeQ(Sqr(Subtract(c,Times(CI,d))),C1)))),
IIntegrate(6270,Int(Times(ArcCoth(Plus(c_DEFAULT,Times(Cot(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),d_DEFAULT))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcCoth(Plus(c,Times(d,Cot(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),CN1)),x),Negate(Dist(Times(CI,b,Subtract(Subtract(C1,c),Times(CI,d)),Power(Times(f,Plus(m,C1)),CN1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Subtract(Plus(C1,Negate(c),Times(CI,d)),Times(Subtract(Subtract(C1,c),Times(CI,d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),CN1)),x),x)),Dist(Times(CI,b,Plus(C1,c,Times(CI,d)),Power(Times(f,Plus(m,C1)),CN1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Subtract(Subtract(Plus(C1,c),Times(CI,d)),Times(Plus(C1,c,Times(CI,d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),CN1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),NeQ(Sqr(Subtract(c,Times(CI,d))),C1)))),
IIntegrate(6271,Int(ArcTanh(u_),x_Symbol),
    Condition(Subtract(Simp(Times(x,ArcTanh(u)),x),Int(SimplifyIntegrand(Times(x,D(u,x),Power(Subtract(C1,Sqr(u)),CN1)),x),x)),InverseFunctionFreeQ(u,x))),
IIntegrate(6272,Int(ArcCoth(u_),x_Symbol),
    Condition(Subtract(Simp(Times(x,ArcCoth(u)),x),Int(SimplifyIntegrand(Times(x,D(u,x),Power(Subtract(C1,Sqr(u)),CN1)),x),x)),InverseFunctionFreeQ(u,x))),
IIntegrate(6273,Int(Times(Plus(a_DEFAULT,Times(ArcTanh(u_),b_DEFAULT)),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Subtract(Simp(Times(Power(Plus(c,Times(d,x)),Plus(m,C1)),Plus(a,Times(b,ArcTanh(u))),Power(Times(d,Plus(m,C1)),CN1)),x),Dist(Times(b,Power(Times(d,Plus(m,C1)),CN1)),Int(SimplifyIntegrand(Times(Power(Plus(c,Times(d,x)),Plus(m,C1)),D(u,x),Power(Subtract(C1,Sqr(u)),CN1)),x),x),x)),And(FreeQ(List(a,b,c,d,m),x),NeQ(m,CN1),InverseFunctionFreeQ(u,x),Not(FunctionOfQ(Power(Plus(c,Times(d,x)),Plus(m,C1)),u,x)),FalseQ(PowerVariableExpn(u,Plus(m,C1),x))))),
IIntegrate(6274,Int(Times(Plus(a_DEFAULT,Times(ArcCoth(u_),b_DEFAULT)),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Subtract(Simp(Times(Power(Plus(c,Times(d,x)),Plus(m,C1)),Plus(a,Times(b,ArcCoth(u))),Power(Times(d,Plus(m,C1)),CN1)),x),Dist(Times(b,Power(Times(d,Plus(m,C1)),CN1)),Int(SimplifyIntegrand(Times(Power(Plus(c,Times(d,x)),Plus(m,C1)),D(u,x),Power(Subtract(C1,Sqr(u)),CN1)),x),x),x)),And(FreeQ(List(a,b,c,d,m),x),NeQ(m,CN1),InverseFunctionFreeQ(u,x),Not(FunctionOfQ(Power(Plus(c,Times(d,x)),Plus(m,C1)),u,x)),FalseQ(PowerVariableExpn(u,Plus(m,C1),x))))),
IIntegrate(6275,Int(Times(Plus(a_DEFAULT,Times(ArcTanh(u_),b_DEFAULT)),v_),x_Symbol),
    Condition(With(List(Set(w,IntHide(v,x))),Condition(Subtract(Dist(Plus(a,Times(b,ArcTanh(u))),w,x),Dist(b,Int(SimplifyIntegrand(Times(w,D(u,x),Power(Subtract(C1,Sqr(u)),CN1)),x),x),x)),InverseFunctionFreeQ(w,x))),And(FreeQ(List(a,b),x),InverseFunctionFreeQ(u,x),Not(MatchQ(v,Condition(Power(Plus(c_DEFAULT,Times(d_DEFAULT,x)),m_DEFAULT),FreeQ(List(c,d,m),x)))),FalseQ(FunctionOfLinear(Times(v,Plus(a,Times(b,ArcTanh(u)))),x))))),
IIntegrate(6276,Int(Times(Plus(a_DEFAULT,Times(ArcCoth(u_),b_DEFAULT)),v_),x_Symbol),
    Condition(With(List(Set(w,IntHide(v,x))),Condition(Subtract(Dist(Plus(a,Times(b,ArcCoth(u))),w,x),Dist(b,Int(SimplifyIntegrand(Times(w,D(u,x),Power(Subtract(C1,Sqr(u)),CN1)),x),x),x)),InverseFunctionFreeQ(w,x))),And(FreeQ(List(a,b),x),InverseFunctionFreeQ(u,x),Not(MatchQ(v,Condition(Power(Plus(c_DEFAULT,Times(d_DEFAULT,x)),m_DEFAULT),FreeQ(List(c,d,m),x)))),FalseQ(FunctionOfLinear(Times(v,Plus(a,Times(b,ArcCoth(u)))),x))))),
IIntegrate(6277,Int(ArcSech(Times(c_DEFAULT,x_)),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcSech(Times(c,x))),x),Dist(Times(Sqrt(Plus(C1,Times(c,x))),Sqrt(Power(Plus(C1,Times(c,x)),CN1))),Int(Power(Subtract(C1,Times(Sqr(c),Sqr(x))),CN1D2),x),x)),FreeQ(c,x))),
IIntegrate(6278,Int(ArcCsch(Times(c_DEFAULT,x_)),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcCsch(Times(c,x))),x),Dist(Power(c,CN1),Int(Power(Times(x,Sqrt(Plus(C1,Power(Times(Sqr(c),Sqr(x)),CN1)))),CN1),x),x)),FreeQ(c,x))),
IIntegrate(6279,Int(Power(Plus(a_DEFAULT,Times(ArcSech(Times(c_DEFAULT,x_)),b_DEFAULT)),n_),x_Symbol),
    Condition(Negate(Dist(Power(c,CN1),Subst(Int(Times(Power(Plus(a,Times(b,x)),n),Sech(x),Tanh(x)),x),x,ArcSech(Times(c,x))),x)),And(FreeQ(List(a,b,c,n),x),IGtQ(n,C0)))),
IIntegrate(6280,Int(Power(Plus(a_DEFAULT,Times(ArcCsch(Times(c_DEFAULT,x_)),b_DEFAULT)),n_),x_Symbol),
    Condition(Negate(Dist(Power(c,CN1),Subst(Int(Times(Power(Plus(a,Times(b,x)),n),Csch(x),Coth(x)),x),x,ArcCsch(Times(c,x))),x)),And(FreeQ(List(a,b,c,n),x),IGtQ(n,C0))))
  );
}
