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
public class IntRules205 { 

	public static void initialize() {
		Initializer.init();
	}

	private static class Initializer  {

		private static void init() {
IIntegrate(5126,Int(Times(Exp(Times(ArcCot(Times(a_DEFAULT,x_)),n_DEFAULT)),Power(Plus(c_,Times(d_DEFAULT,Power(x_,CN2))),p_DEFAULT),Power(x_,m_)),x_Symbol),
    Condition(Negate(Dist(Times(Power(c,p),Power(x,m),Power(Power(x,CN1),m)),Subst(Int(Times(Power(Subtract(C1,Times(CI,x,Power(a,CN1))),Plus(p,Times(C1D2,CI,n))),Power(Plus(C1,Times(CI,x,Power(a,CN1))),Subtract(p,Times(C1D2,CI,n))),Power(Power(x,Plus(m,C2)),CN1)),x),x,Power(x,CN1)),x)),And(FreeQ(List(a,c,d,m,n,p),x),EqQ(c,Times(Sqr(a),d)),Not(IntegerQ(Times(C1D2,CI,n))),Or(IntegerQ(p),GtQ(c,C0)),Not(And(IntegerQ(Times(C2,p)),IntegerQ(Plus(p,Times(C1D2,CI,n))))),Not(IntegerQ(m)))));
IIntegrate(5127,Int(Times(Exp(Times(ArcCot(Times(a_DEFAULT,x_)),n_DEFAULT)),u_DEFAULT,Power(Plus(c_,Times(d_DEFAULT,Power(x_,CN2))),p_)),x_Symbol),
    Condition(Dist(Times(Power(Plus(c,Times(d,Power(x,CN2))),p),Power(Power(Plus(C1,Power(Times(Sqr(a),Sqr(x)),CN1)),p),CN1)),Int(Times(u,Power(Plus(C1,Power(Times(Sqr(a),Sqr(x)),CN1)),p),Exp(Times(n,ArcCot(Times(a,x))))),x),x),And(FreeQ(List(a,c,d,n,p),x),EqQ(c,Times(Sqr(a),d)),Not(IntegerQ(Times(C1D2,CI,n))),Not(Or(IntegerQ(p),GtQ(c,C0))))));
IIntegrate(5128,Int(Times(Exp(Times(ArcCot(Times(c_DEFAULT,Plus(a_,Times(b_DEFAULT,x_)))),n_)),u_DEFAULT),x_Symbol),
    Condition(Dist(Power(CN1,Times(C1D2,CI,n)),Int(Times(u,Power(Exp(Times(n,ArcTan(Times(c,Plus(a,Times(b,x)))))),CN1)),x),x),And(FreeQ(List(a,b,c),x),IntegerQ(Times(C1D2,CI,n)))));
IIntegrate(5129,Int(Exp(Times(ArcCot(Times(c_DEFAULT,Plus(a_,Times(b_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(Times(CI,c,Plus(a,Times(b,x))),Times(C1D2,CI,n)),Power(Plus(C1,Power(Times(CI,c,Plus(a,Times(b,x))),CN1)),Times(C1D2,CI,n)),Power(Power(Plus(C1,Times(CI,a,c),Times(CI,b,c,x)),Times(C1D2,CI,n)),CN1)),Int(Times(Power(Plus(C1,Times(CI,a,c),Times(CI,b,c,x)),Times(C1D2,CI,n)),Power(Power(Plus(CN1,Times(CI,a,c),Times(CI,b,c,x)),Times(C1D2,CI,n)),CN1)),x),x),And(FreeQ(List(a,b,c,n),x),Not(IntegerQ(Times(C1D2,CI,n))))));
IIntegrate(5130,Int(Times(Exp(Times(ArcCoth(Times(c_DEFAULT,Plus(a_,Times(b_DEFAULT,x_)))),n_)),Power(x_,m_)),x_Symbol),
    Condition(Dist(Times(C4,Power(Times(Power(CI,m),n,Power(b,Plus(m,C1)),Power(c,Plus(m,C1))),CN1)),Subst(Int(Times(Power(x,Times(C2,Power(Times(CI,n),CN1))),Power(Plus(C1,Times(CI,a,c),Times(Subtract(C1,Times(CI,a,c)),Power(x,Times(C2,Power(Times(CI,n),CN1))))),m),Power(Power(Plus(CN1,Power(x,Times(C2,Power(Times(CI,n),CN1)))),Plus(m,C2)),CN1)),x),x,Times(Power(Plus(C1,Power(Times(CI,c,Plus(a,Times(b,x))),CN1)),Times(C1D2,CI,n)),Power(Power(Subtract(C1,Power(Times(CI,c,Plus(a,Times(b,x))),CN1)),Times(C1D2,CI,n)),CN1))),x),And(FreeQ(List(a,b,c),x),ILtQ(m,C0),LtQ(CN1,Times(CI,n),C1))));
IIntegrate(5131,Int(Times(Exp(Times(ArcCoth(Times(c_DEFAULT,Plus(a_,Times(b_DEFAULT,x_)))),n_DEFAULT)),Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(Times(CI,c,Plus(a,Times(b,x))),Times(C1D2,CI,n)),Power(Plus(C1,Power(Times(CI,c,Plus(a,Times(b,x))),CN1)),Times(C1D2,CI,n)),Power(Power(Plus(C1,Times(CI,a,c),Times(CI,b,c,x)),Times(C1D2,CI,n)),CN1)),Int(Times(Power(Plus(d,Times(e,x)),m),Power(Plus(C1,Times(CI,a,c),Times(CI,b,c,x)),Times(C1D2,CI,n)),Power(Power(Plus(CN1,Times(CI,a,c),Times(CI,b,c,x)),Times(C1D2,CI,n)),CN1)),x),x),And(FreeQ(List(a,b,c,d,e,m,n),x),Not(IntegerQ(Times(C1D2,CI,n))))));
IIntegrate(5132,Int(Times(Exp(Times(ArcCot(Plus(a_,Times(b_DEFAULT,x_))),n_DEFAULT)),u_DEFAULT,Power(Plus(c_,Times(d_DEFAULT,x_),Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(Times(c,Power(Plus(C1,Sqr(a)),CN1)),p),Power(Times(Plus(Times(CI,a),Times(CI,b,x)),Power(Plus(C1,Times(CI,a),Times(CI,b,x)),CN1)),Times(C1D2,CI,n)),Power(Times(Plus(C1,Times(CI,a),Times(CI,b,x)),Power(Plus(Times(CI,a),Times(CI,b,x)),CN1)),Times(C1D2,CI,n)),Power(Subtract(Subtract(C1,Times(CI,a)),Times(CI,b,x)),Times(C1D2,CI,n)),Power(Power(Plus(CN1,Times(CI,a),Times(CI,b,x)),Times(C1D2,CI,n)),CN1)),Int(Times(u,Power(Subtract(Subtract(C1,Times(CI,a)),Times(CI,b,x)),Subtract(p,Times(C1D2,CI,n))),Power(Plus(C1,Times(CI,a),Times(CI,b,x)),Plus(p,Times(C1D2,CI,n)))),x),x),And(FreeQ(List(a,b,c,d,e,n,p),x),Not(IntegerQ(Times(C1D2,CI,n))),EqQ(Subtract(Times(b,d),Times(C2,a,e)),C0),EqQ(Subtract(Times(Sqr(b),c),Times(e,Plus(C1,Sqr(a)))),C0),Or(IntegerQ(p),GtQ(Times(c,Power(Plus(C1,Sqr(a)),CN1)),C0)))));
IIntegrate(5133,Int(Times(Exp(Times(ArcCot(Plus(a_,Times(b_DEFAULT,x_))),n_DEFAULT)),u_DEFAULT,Power(Plus(c_,Times(d_DEFAULT,x_),Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(Plus(c,Times(d,x),Times(e,Sqr(x))),p),Power(Power(Plus(C1,Sqr(a),Times(C2,a,b,x),Times(Sqr(b),Sqr(x))),p),CN1)),Int(Times(u,Power(Plus(C1,Sqr(a),Times(C2,a,b,x),Times(Sqr(b),Sqr(x))),p),Exp(Times(n,ArcCot(Times(a,x))))),x),x),And(FreeQ(List(a,b,c,d,e,n,p),x),Not(IntegerQ(Times(C1D2,CI,n))),EqQ(Subtract(Times(b,d),Times(C2,a,e)),C0),EqQ(Subtract(Times(Sqr(b),c),Times(e,Plus(C1,Sqr(a)))),C0),Not(Or(IntegerQ(p),GtQ(Times(c,Power(Plus(C1,Sqr(a)),CN1)),C0))))));
IIntegrate(5134,Int(Times(Exp(Times(ArcCot(Times(c_DEFAULT,Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),CN1))),n_DEFAULT)),u_DEFAULT),x_Symbol),
    Condition(Int(Times(u,Exp(Times(n,ArcTan(Plus(Times(a,Power(c,CN1)),Times(b,x,Power(c,CN1))))))),x),FreeQ(List(a,b,c,n),x)));
IIntegrate(5135,Int(ArcTan(Plus(a_,Times(b_DEFAULT,Power(x_,n_)))),x_Symbol),
    Condition(Subtract(Simp(Times(x,ArcTan(Plus(a,Times(b,Power(x,n))))),x),Dist(Times(b,n),Int(Times(Power(x,n),Power(Plus(C1,Sqr(a),Times(C2,a,b,Power(x,n)),Times(Sqr(b),Power(x,Times(C2,n)))),CN1)),x),x)),FreeQ(List(a,b,n),x)));
IIntegrate(5136,Int(ArcCot(Plus(a_,Times(b_DEFAULT,Power(x_,n_)))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcCot(Plus(a,Times(b,Power(x,n))))),x),Dist(Times(b,n),Int(Times(Power(x,n),Power(Plus(C1,Sqr(a),Times(C2,a,b,Power(x,n)),Times(Sqr(b),Power(x,Times(C2,n)))),CN1)),x),x)),FreeQ(List(a,b,n),x)));
IIntegrate(5137,Int(Times(ArcTan(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_)))),Power(x_,CN1)),x_Symbol),
    Condition(Subtract(Dist(Times(C1D2,CI),Int(Times(Log(Subtract(Subtract(C1,Times(CI,a)),Times(CI,b,Power(x,n)))),Power(x,CN1)),x),x),Dist(Times(C1D2,CI),Int(Times(Log(Plus(C1,Times(CI,a),Times(CI,b,Power(x,n)))),Power(x,CN1)),x),x)),FreeQ(List(a,b,n),x)));
IIntegrate(5138,Int(Times(ArcCot(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_)))),Power(x_,CN1)),x_Symbol),
    Condition(Subtract(Dist(Times(C1D2,CI),Int(Times(Log(Subtract(C1,Times(CI,Power(Plus(a,Times(b,Power(x,n))),CN1)))),Power(x,CN1)),x),x),Dist(Times(C1D2,CI),Int(Times(Log(Plus(C1,Times(CI,Power(Plus(a,Times(b,Power(x,n))),CN1)))),Power(x,CN1)),x),x)),FreeQ(List(a,b,n),x)));
IIntegrate(5139,Int(Times(ArcTan(Plus(a_,Times(b_DEFAULT,Power(x_,n_)))),Power(x_,m_DEFAULT)),x_Symbol),
    Condition(Subtract(Simp(Times(Power(x,Plus(m,C1)),ArcTan(Plus(a,Times(b,Power(x,n)))),Power(Plus(m,C1),CN1)),x),Dist(Times(b,n,Power(Plus(m,C1),CN1)),Int(Times(Power(x,Plus(m,n)),Power(Plus(C1,Sqr(a),Times(C2,a,b,Power(x,n)),Times(Sqr(b),Power(x,Times(C2,n)))),CN1)),x),x)),And(FreeQ(List(a,b),x),RationalQ(m,n),Unequal(Plus(m,C1),C0),Unequal(Plus(m,C1),n))));
IIntegrate(5140,Int(Times(ArcCot(Plus(a_,Times(b_DEFAULT,Power(x_,n_)))),Power(x_,m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(x,Plus(m,C1)),ArcCot(Plus(a,Times(b,Power(x,n)))),Power(Plus(m,C1),CN1)),x),Dist(Times(b,n,Power(Plus(m,C1),CN1)),Int(Times(Power(x,Plus(m,n)),Power(Plus(C1,Sqr(a),Times(C2,a,b,Power(x,n)),Times(Sqr(b),Power(x,Times(C2,n)))),CN1)),x),x)),And(FreeQ(List(a,b),x),RationalQ(m,n),Unequal(Plus(m,C1),C0),Unequal(Plus(m,C1),n))));
IIntegrate(5141,Int(ArcTan(Plus(a_DEFAULT,Times(b_DEFAULT,Power(f_,Plus(c_DEFAULT,Times(d_DEFAULT,x_)))))),x_Symbol),
    Condition(Subtract(Dist(Times(C1D2,CI),Int(Log(Subtract(Subtract(C1,Times(CI,a)),Times(CI,b,Power(f,Plus(c,Times(d,x)))))),x),x),Dist(Times(C1D2,CI),Int(Log(Plus(C1,Times(CI,a),Times(CI,b,Power(f,Plus(c,Times(d,x)))))),x),x)),FreeQ(List(a,b,c,d,f),x)));
IIntegrate(5142,Int(ArcCot(Plus(a_DEFAULT,Times(b_DEFAULT,Power(f_,Plus(c_DEFAULT,Times(d_DEFAULT,x_)))))),x_Symbol),
    Condition(Subtract(Dist(Times(C1D2,CI),Int(Log(Subtract(C1,Times(CI,Power(Plus(a,Times(b,Power(f,Plus(c,Times(d,x))))),CN1)))),x),x),Dist(Times(C1D2,CI),Int(Log(Plus(C1,Times(CI,Power(Plus(a,Times(b,Power(f,Plus(c,Times(d,x))))),CN1)))),x),x)),FreeQ(List(a,b,c,d,f),x)));
IIntegrate(5143,Int(Times(ArcTan(Plus(a_DEFAULT,Times(b_DEFAULT,Power(f_,Plus(c_DEFAULT,Times(d_DEFAULT,x_)))))),Power(x_,m_DEFAULT)),x_Symbol),
    Condition(Subtract(Dist(Times(C1D2,CI),Int(Times(Power(x,m),Log(Subtract(Subtract(C1,Times(CI,a)),Times(CI,b,Power(f,Plus(c,Times(d,x))))))),x),x),Dist(Times(C1D2,CI),Int(Times(Power(x,m),Log(Plus(C1,Times(CI,a),Times(CI,b,Power(f,Plus(c,Times(d,x))))))),x),x)),And(FreeQ(List(a,b,c,d,f),x),IntegerQ(m),Greater(m,C0))));
IIntegrate(5144,Int(Times(ArcCot(Plus(a_DEFAULT,Times(b_DEFAULT,Power(f_,Plus(c_DEFAULT,Times(d_DEFAULT,x_)))))),Power(x_,m_DEFAULT)),x_Symbol),
    Condition(Subtract(Dist(Times(C1D2,CI),Int(Times(Power(x,m),Log(Subtract(C1,Times(CI,Power(Plus(a,Times(b,Power(f,Plus(c,Times(d,x))))),CN1))))),x),x),Dist(Times(C1D2,CI),Int(Times(Power(x,m),Log(Plus(C1,Times(CI,Power(Plus(a,Times(b,Power(f,Plus(c,Times(d,x))))),CN1))))),x),x)),And(FreeQ(List(a,b,c,d,f),x),IntegerQ(m),Greater(m,C0))));
IIntegrate(5145,Int(Times(Power(ArcTan(Times(c_DEFAULT,Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_DEFAULT))),CN1))),m_DEFAULT),u_DEFAULT),x_Symbol),
    Condition(Int(Times(u,Power(ArcCot(Plus(Times(a,Power(c,CN1)),Times(b,Power(x,n),Power(c,CN1)))),m)),x),FreeQ(List(a,b,c,n,m),x)));
IIntegrate(5146,Int(Times(Power(ArcCot(Times(c_DEFAULT,Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_DEFAULT))),CN1))),m_DEFAULT),u_DEFAULT),x_Symbol),
    Condition(Int(Times(u,Power(ArcTan(Plus(Times(a,Power(c,CN1)),Times(b,Power(x,n),Power(c,CN1)))),m)),x),FreeQ(List(a,b,c,n,m),x)));
IIntegrate(5147,Int(ArcTan(Times(c_DEFAULT,x_,Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sqr(x_))),CN1D2))),x_Symbol),
    Condition(Subtract(Simp(Times(x,ArcTan(Times(c,x,Power(Plus(a,Times(b,Sqr(x))),CN1D2)))),x),Dist(c,Int(Times(x,Power(Plus(a,Times(b,Sqr(x))),CN1D2)),x),x)),And(FreeQ(List(a,b,c),x),EqQ(Plus(b,Sqr(c)),C0))));
IIntegrate(5148,Int(ArcCot(Times(c_DEFAULT,x_,Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sqr(x_))),CN1D2))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcCot(Times(c,x,Power(Plus(a,Times(b,Sqr(x))),CN1D2)))),x),Dist(c,Int(Times(x,Power(Plus(a,Times(b,Sqr(x))),CN1D2)),x),x)),And(FreeQ(List(a,b,c),x),EqQ(Plus(b,Sqr(c)),C0))));
IIntegrate(5149,Int(Times(ArcTan(Times(c_DEFAULT,x_,Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sqr(x_))),CN1D2))),Power(x_,CN1)),x_Symbol),
    Condition(Subtract(Simp(Times(ArcTan(Times(c,x,Power(Plus(a,Times(b,Sqr(x))),CN1D2))),Log(x)),x),Dist(c,Int(Times(Log(x),Power(Plus(a,Times(b,Sqr(x))),CN1D2)),x),x)),And(FreeQ(List(a,b,c),x),EqQ(Plus(b,Sqr(c)),C0))));
IIntegrate(5150,Int(Times(ArcCot(Times(c_DEFAULT,x_,Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sqr(x_))),CN1D2))),Power(x_,CN1)),x_Symbol),
    Condition(Plus(Simp(Times(ArcCot(Times(c,x,Power(Plus(a,Times(b,Sqr(x))),CN1D2))),Log(x)),x),Dist(c,Int(Times(Log(x),Power(Plus(a,Times(b,Sqr(x))),CN1D2)),x),x)),And(FreeQ(List(a,b,c),x),EqQ(Plus(b,Sqr(c)),C0))));
  }
}
}