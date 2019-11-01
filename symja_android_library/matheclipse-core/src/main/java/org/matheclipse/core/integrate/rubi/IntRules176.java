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
public class IntRules176 { 
  public static IAST RULES = List( 
IIntegrate(3521,Int(Times(Power($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),p_DEFAULT),Power(Plus(Times($($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_),n_DEFAULT),Power($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),m_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(Sin(Plus(e,Times(f,x))),Subtract(m,n)),Power(Cos(Plus(e,Times(f,x))),p),Power(Plus(Times(a,Sin(Plus(e,Times(f,x)))),Times(b,Cos(Plus(e,Times(f,x))))),n)),x),And(FreeQ(List(a,b,e,f,m,p),x),IntegerQ(n)))),
IIntegrate(3522,Int(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Plus(c_,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(a,m),Power(c,m)),Int(Times(Power(Sec(Plus(e,Times(f,x))),Times(C2,m)),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),Subtract(n,m))),x),x),And(FreeQ(List(a,b,c,d,e,f,n),x),EqQ(Plus(Times(b,c),Times(a,d)),C0),EqQ(Plus(Sqr(a),Sqr(b)),C0),IntegerQ(m),Not(And(IGtQ(n,C0),Or(LtQ(m,C0),GtQ(m,n))))))),
IIntegrate(3523,Int(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_),Power(Plus(c_,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Dist(Times(a,c,Power(f,CN1)),Subst(Int(Times(Power(Plus(a,Times(b,x)),Subtract(m,C1)),Power(Plus(c,Times(d,x)),Subtract(n,C1))),x),x,Tan(Plus(e,Times(f,x)))),x),And(FreeQ(List(a,b,c,d,e,f,m,n),x),EqQ(Plus(Times(b,c),Times(a,d)),C0),EqQ(Plus(Sqr(a),Sqr(b)),C0)))),
IIntegrate(3524,Int(Times(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),Plus(c_,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(Subtract(Times(a,c),Times(b,d)),x),x),Simp(Times(b,d,Tan(Plus(e,Times(f,x))),Power(f,CN1)),x)),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Subtract(Times(b,c),Times(a,d)),C0),EqQ(Plus(Times(b,c),Times(a,d)),C0)))),
IIntegrate(3525,Int(Times(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(Subtract(Times(a,c),Times(b,d)),x),x),Dist(Plus(Times(b,c),Times(a,d)),Int(Tan(Plus(e,Times(f,x))),x),x),Simp(Times(b,d,Tan(Plus(e,Times(f,x))),Power(f,CN1)),x)),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Subtract(Times(b,c),Times(a,d)),C0),NeQ(Plus(Times(b,c),Times(a,d)),C0)))),
IIntegrate(3526,Int(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_),Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Subtract(Times(b,c),Times(a,d)),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),m),Power(Times(C2,a,f,m),CN1)),x)),Dist(Times(Plus(Times(b,c),Times(a,d)),Power(Times(C2,a,b),CN1)),Int(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Plus(m,C1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Subtract(Times(b,c),Times(a,d)),C0),EqQ(Plus(Sqr(a),Sqr(b)),C0),LtQ(m,C0)))),
IIntegrate(3527,Int(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_),Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(d,Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),m),Power(Times(f,m),CN1)),x),Dist(Times(Plus(Times(b,c),Times(a,d)),Power(b,CN1)),Int(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),m),x),x)),And(FreeQ(List(a,b,c,d,e,f,m),x),NeQ(Subtract(Times(b,c),Times(a,d)),C0),EqQ(Plus(Sqr(a),Sqr(b)),C0),Not(LtQ(m,C0))))),
IIntegrate(3528,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_),Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(d,Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),m),Power(Times(f,m),CN1)),x),Int(Times(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Subtract(m,C1)),Simp(Plus(Times(a,c),Times(CN1,b,d),Times(Plus(Times(b,c),Times(a,d)),Tan(Plus(e,Times(f,x))))),x)),x)),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Subtract(Times(b,c),Times(a,d)),C0),NeQ(Plus(Sqr(a),Sqr(b)),C0),GtQ(m,C0)))),
IIntegrate(3529,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_),Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(Subtract(Times(b,c),Times(a,d)),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Plus(m,C1)),Power(Times(f,Plus(m,C1),Plus(Sqr(a),Sqr(b))),CN1)),x),Dist(Power(Plus(Sqr(a),Sqr(b)),CN1),Int(Times(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Plus(m,C1)),Simp(Subtract(Plus(Times(a,c),Times(b,d)),Times(Subtract(Times(b,c),Times(a,d)),Tan(Plus(e,Times(f,x))))),x)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Subtract(Times(b,c),Times(a,d)),C0),NeQ(Plus(Sqr(a),Sqr(b)),C0),LtQ(m,CN1)))),
IIntegrate(3530,Int(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),CN1),Plus(c_,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(Simp(Times(c,Log(RemoveContent(Plus(Times(a,Cos(Plus(e,Times(f,x)))),Times(b,Sin(Plus(e,Times(f,x))))),x)),Power(Times(b,f),CN1)),x),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Subtract(Times(b,c),Times(a,d)),C0),NeQ(Plus(Sqr(a),Sqr(b)),C0),EqQ(Plus(Times(a,c),Times(b,d)),C0)))),
IIntegrate(3531,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),CN1),Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(Plus(Times(a,c),Times(b,d)),x,Power(Plus(Sqr(a),Sqr(b)),CN1)),x),Dist(Times(Subtract(Times(b,c),Times(a,d)),Power(Plus(Sqr(a),Sqr(b)),CN1)),Int(Times(Subtract(b,Times(a,Tan(Plus(e,Times(f,x))))),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),CN1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Subtract(Times(b,c),Times(a,d)),C0),NeQ(Plus(Sqr(a),Sqr(b)),C0),NeQ(Plus(Times(a,c),Times(b,d)),C0)))),
IIntegrate(3532,Int(Times(Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),CN1D2),Plus(c_,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(Dist(Times(CN2,Sqr(d),Power(f,CN1)),Subst(Int(Power(Plus(Times(C2,c,d),Times(b,Sqr(x))),CN1),x),x,Times(Subtract(c,Times(d,Tan(Plus(e,Times(f,x))))),Power(Times(b,Tan(Plus(e,Times(f,x)))),CN1D2))),x),And(FreeQ(List(b,c,d,e,f),x),EqQ(Subtract(Sqr(c),Sqr(d)),C0)))),
IIntegrate(3533,Int(Times(Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),CN1D2),Plus(c_,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(Dist(Times(C2,Sqr(c),Power(f,CN1)),Subst(Int(Power(Subtract(Times(b,c),Times(d,Sqr(x))),CN1),x),x,Sqrt(Times(b,Tan(Plus(e,Times(f,x)))))),x),And(FreeQ(List(b,c,d,e,f),x),EqQ(Plus(Sqr(c),Sqr(d)),C0)))),
IIntegrate(3534,Int(Times(Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),CN1D2),Plus(c_,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(Dist(Times(C2,Power(f,CN1)),Subst(Int(Times(Plus(Times(b,c),Times(d,Sqr(x))),Power(Plus(Sqr(b),Power(x,C4)),CN1)),x),x,Sqrt(Times(b,Tan(Plus(e,Times(f,x)))))),x),And(FreeQ(List(b,c,d,e,f),x),NeQ(Subtract(Sqr(c),Sqr(d)),C0),NeQ(Plus(Sqr(c),Sqr(d)),C0)))),
IIntegrate(3535,Int(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),CN1D2),Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(Dist(Times(CN2,Sqr(d),Power(f,CN1)),Subst(Int(Power(Plus(Times(C2,b,c,d),Times(CN1,C4,a,Sqr(d)),Sqr(x)),CN1),x),x,Times(Subtract(Subtract(Times(b,c),Times(C2,a,d)),Times(b,d,Tan(Plus(e,Times(f,x))))),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),CN1D2))),x),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Subtract(Times(b,c),Times(a,d)),C0),NeQ(Plus(Sqr(a),Sqr(b)),C0),NeQ(Plus(Sqr(c),Sqr(d)),C0),EqQ(Subtract(Times(C2,a,c,d),Times(b,Subtract(Sqr(c),Sqr(d)))),C0)))),
IIntegrate(3536,Int(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),CN1D2),Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(With(List(Set(q,Rt(Plus(Sqr(a),Sqr(b)),C2))),Subtract(Dist(Power(Times(C2,q),CN1),Int(Times(Plus(Times(a,c),Times(b,d),Times(c,q),Times(Plus(Times(b,c),Times(CN1,a,d),Times(d,q)),Tan(Plus(e,Times(f,x))))),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),CN1D2)),x),x),Dist(Power(Times(C2,q),CN1),Int(Times(Plus(Times(a,c),Times(b,d),Times(CN1,c,q),Times(Subtract(Subtract(Times(b,c),Times(a,d)),Times(d,q)),Tan(Plus(e,Times(f,x))))),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),CN1D2)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Subtract(Times(b,c),Times(a,d)),C0),NeQ(Plus(Sqr(a),Sqr(b)),C0),NeQ(Plus(Sqr(c),Sqr(d)),C0),NeQ(Subtract(Times(C2,a,c,d),Times(b,Subtract(Sqr(c),Sqr(d)))),C0),Or(PerfectSquareQ(Plus(Sqr(a),Sqr(b))),RationalQ(a,b,c,d))))),
IIntegrate(3537,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_),Plus(c_,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(Dist(Times(c,d,Power(f,CN1)),Subst(Int(Times(Power(Plus(a,Times(b,x,Power(d,CN1))),m),Power(Plus(Sqr(d),Times(c,x)),CN1)),x),x,Times(d,Tan(Plus(e,Times(f,x))))),x),And(FreeQ(List(a,b,c,d,e,f,m),x),NeQ(Subtract(Times(b,c),Times(a,d)),C0),NeQ(Plus(Sqr(a),Sqr(b)),C0),EqQ(Plus(Sqr(c),Sqr(d)),C0)))),
IIntegrate(3538,Int(Times(Power(Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_),Plus(c_,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Dist(c,Int(Power(Times(b,Tan(Plus(e,Times(f,x)))),m),x),x),Dist(Times(d,Power(b,CN1)),Int(Power(Times(b,Tan(Plus(e,Times(f,x)))),Plus(m,C1)),x),x)),And(FreeQ(List(b,c,d,e,f,m),x),NeQ(Plus(Sqr(c),Sqr(d)),C0),Not(IntegerQ(Times(C2,m)))))),
IIntegrate(3539,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_),Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Dist(Times(C1D2,Plus(c,Times(CI,d))),Int(Times(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),m),Subtract(C1,Times(CI,Tan(Plus(e,Times(f,x)))))),x),x),Dist(Times(C1D2,Subtract(c,Times(CI,d))),Int(Times(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),m),Plus(C1,Times(CI,Tan(Plus(e,Times(f,x)))))),x),x)),And(FreeQ(List(a,b,c,d,e,f,m),x),NeQ(Subtract(Times(b,c),Times(a,d)),C0),NeQ(Plus(Sqr(a),Sqr(b)),C0),NeQ(Plus(Sqr(c),Sqr(d)),C0),Not(IntegerQ(m))))),
IIntegrate(3540,Int(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_),Sqr(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Negate(Simp(Times(b,Sqr(Plus(Times(a,c),Times(b,d))),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),m),Power(Times(C2,Power(a,C3),f,m),CN1)),x)),Dist(Power(Times(C2,Sqr(a)),CN1),Int(Times(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Plus(m,C1)),Simp(Subtract(Plus(Times(a,Sqr(c)),Times(CN1,C2,b,c,d),Times(a,Sqr(d))),Times(C2,b,Sqr(d),Tan(Plus(e,Times(f,x))))),x)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Subtract(Times(b,c),Times(a,d)),C0),LeQ(m,CN1),EqQ(Plus(Sqr(a),Sqr(b)),C0))))
  );
}
