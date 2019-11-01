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
public class IntRules182 { 
  public static IAST RULES = List( 
IIntegrate(3641,Int(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_),Plus(A_DEFAULT,Times(B_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),Times(C_DEFAULT,Sqr($($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),x_Symbol),
    Condition(Subtract(Simp(Times(Plus(Times(Sqr(c),C),Times(CN1,BSymbol,c,d),Times(ASymbol,Sqr(d))),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),m),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),Plus(n,C1)),Power(Times(d,f,Plus(n,C1),Plus(Sqr(c),Sqr(d))),CN1)),x),Dist(Power(Times(a,d,Plus(n,C1),Plus(Sqr(c),Sqr(d))),CN1),Int(Times(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),m),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),Plus(n,C1)),Simp(Subtract(Subtract(Times(b,Plus(Times(Sqr(c),C),Times(CN1,BSymbol,c,d),Times(ASymbol,Sqr(d))),m),Times(a,d,Plus(n,C1),Plus(Times(ASymbol,c),Times(CN1,c,C),Times(BSymbol,d)))),Times(a,Subtract(Times(d,Subtract(Times(BSymbol,c),Times(ASymbol,d)),Plus(m,n,C1)),Times(C,Subtract(Times(Sqr(c),m),Times(Sqr(d),Plus(n,C1))))),Tan(Plus(e,Times(f,x))))),x)),x),x)),And(FreeQ(List(a,b,c,d,e,f,ASymbol,BSymbol,C,m),x),NeQ(Subtract(Times(b,c),Times(a,d)),C0),EqQ(Plus(Sqr(a),Sqr(b)),C0),Not(LtQ(m,C0)),LtQ(n,CN1),NeQ(Plus(Sqr(c),Sqr(d)),C0)))),
IIntegrate(3642,Int(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_),Plus(A_DEFAULT,Times(C_DEFAULT,Sqr($($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),x_Symbol),
    Condition(Subtract(Simp(Times(Plus(Times(Sqr(c),C),Times(ASymbol,Sqr(d))),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),m),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),Plus(n,C1)),Power(Times(d,f,Plus(n,C1),Plus(Sqr(c),Sqr(d))),CN1)),x),Dist(Power(Times(a,d,Plus(n,C1),Plus(Sqr(c),Sqr(d))),CN1),Int(Times(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),m),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),Plus(n,C1)),Simp(Subtract(Subtract(Times(b,Plus(Times(Sqr(c),C),Times(ASymbol,Sqr(d))),m),Times(a,d,Plus(n,C1),Subtract(Times(ASymbol,c),Times(c,C)))),Times(a,Subtract(Times(CN1,ASymbol,Sqr(d),Plus(m,n,C1)),Times(C,Subtract(Times(Sqr(c),m),Times(Sqr(d),Plus(n,C1))))),Tan(Plus(e,Times(f,x))))),x)),x),x)),And(FreeQ(List(a,b,c,d,e,f,ASymbol,C,m),x),NeQ(Subtract(Times(b,c),Times(a,d)),C0),EqQ(Plus(Sqr(a),Sqr(b)),C0),Not(LtQ(m,C0)),LtQ(n,CN1),NeQ(Plus(Sqr(c),Sqr(d)),C0)))),
IIntegrate(3643,Int(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT),Plus(A_DEFAULT,Times(B_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),Times(C_DEFAULT,Sqr($($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Simp(Times(C,Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),m),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),Plus(n,C1)),Power(Times(d,f,Plus(m,n,C1)),CN1)),x),Dist(Power(Times(b,d,Plus(m,n,C1)),CN1),Int(Times(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),m),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),n),Simp(Subtract(Plus(Times(ASymbol,b,d,Plus(m,n,C1)),Times(C,Subtract(Times(a,c,m),Times(b,d,Plus(n,C1))))),Times(Subtract(Times(C,m,Subtract(Times(b,c),Times(a,d))),Times(b,BSymbol,d,Plus(m,n,C1))),Tan(Plus(e,Times(f,x))))),x)),x),x)),And(FreeQ(List(a,b,c,d,e,f,ASymbol,BSymbol,C,m,n),x),NeQ(Subtract(Times(b,c),Times(a,d)),C0),EqQ(Plus(Sqr(a),Sqr(b)),C0),Not(LtQ(m,C0)),NeQ(Plus(m,n,C1),C0)))),
IIntegrate(3644,Int(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT),Plus(A_DEFAULT,Times(C_DEFAULT,Sqr($($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Simp(Times(C,Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),m),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),Plus(n,C1)),Power(Times(d,f,Plus(m,n,C1)),CN1)),x),Dist(Power(Times(b,d,Plus(m,n,C1)),CN1),Int(Times(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),m),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),n),Simp(Subtract(Plus(Times(ASymbol,b,d,Plus(m,n,C1)),Times(C,Subtract(Times(a,c,m),Times(b,d,Plus(n,C1))))),Times(C,m,Subtract(Times(b,c),Times(a,d)),Tan(Plus(e,Times(f,x))))),x)),x),x)),And(FreeQ(List(a,b,c,d,e,f,ASymbol,C,m,n),x),NeQ(Subtract(Times(b,c),Times(a,d)),C0),EqQ(Plus(Sqr(a),Sqr(b)),C0),Not(LtQ(m,C0)),NeQ(Plus(m,n,C1),C0)))),
IIntegrate(3645,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_),Plus(A_DEFAULT,Times(B_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),Times(C_DEFAULT,Sqr($($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),x_Symbol),
    Condition(Subtract(Simp(Times(Plus(Times(ASymbol,Sqr(d)),Times(c,Subtract(Times(c,C),Times(BSymbol,d)))),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),m),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),Plus(n,C1)),Power(Times(d,f,Plus(n,C1),Plus(Sqr(c),Sqr(d))),CN1)),x),Dist(Power(Times(d,Plus(n,C1),Plus(Sqr(c),Sqr(d))),CN1),Int(Times(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Subtract(m,C1)),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),Plus(n,C1)),Simp(Subtract(Subtract(Plus(Times(ASymbol,d,Subtract(Times(b,d,m),Times(a,c,Plus(n,C1)))),Times(Subtract(Times(c,C),Times(BSymbol,d)),Plus(Times(b,c,m),Times(a,d,Plus(n,C1))))),Times(d,Plus(n,C1),Plus(Times(Subtract(ASymbol,C),Subtract(Times(b,c),Times(a,d))),Times(BSymbol,Plus(Times(a,c),Times(b,d)))),Tan(Plus(e,Times(f,x))))),Times(b,Subtract(Times(d,Subtract(Times(BSymbol,c),Times(ASymbol,d)),Plus(m,n,C1)),Times(C,Subtract(Times(Sqr(c),m),Times(Sqr(d),Plus(n,C1))))),Sqr(Tan(Plus(e,Times(f,x)))))),x)),x),x)),And(FreeQ(List(a,b,c,d,e,f,ASymbol,BSymbol,C),x),NeQ(Subtract(Times(b,c),Times(a,d)),C0),NeQ(Plus(Sqr(a),Sqr(b)),C0),NeQ(Plus(Sqr(c),Sqr(d)),C0),GtQ(m,C0),LtQ(n,CN1)))),
IIntegrate(3646,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_),Plus(A_DEFAULT,Times(C_DEFAULT,Sqr($($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),x_Symbol),
    Condition(Subtract(Simp(Times(Plus(Times(ASymbol,Sqr(d)),Times(Sqr(c),C)),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),m),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),Plus(n,C1)),Power(Times(d,f,Plus(n,C1),Plus(Sqr(c),Sqr(d))),CN1)),x),Dist(Power(Times(d,Plus(n,C1),Plus(Sqr(c),Sqr(d))),CN1),Int(Times(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Subtract(m,C1)),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),Plus(n,C1)),Simp(Plus(Times(ASymbol,d,Subtract(Times(b,d,m),Times(a,c,Plus(n,C1)))),Times(c,C,Plus(Times(b,c,m),Times(a,d,Plus(n,C1)))),Times(CN1,d,Plus(n,C1),Subtract(ASymbol,C),Subtract(Times(b,c),Times(a,d)),Tan(Plus(e,Times(f,x)))),Times(b,Plus(Times(ASymbol,Sqr(d),Plus(m,n,C1)),Times(C,Subtract(Times(Sqr(c),m),Times(Sqr(d),Plus(n,C1))))),Sqr(Tan(Plus(e,Times(f,x)))))),x)),x),x)),And(FreeQ(List(a,b,c,d,e,f,ASymbol,C),x),NeQ(Subtract(Times(b,c),Times(a,d)),C0),NeQ(Plus(Sqr(a),Sqr(b)),C0),NeQ(Plus(Sqr(c),Sqr(d)),C0),GtQ(m,C0),LtQ(n,CN1)))),
IIntegrate(3647,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_),Plus(A_DEFAULT,Times(B_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),Times(C_DEFAULT,Sqr($($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Simp(Times(C,Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),m),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),Plus(n,C1)),Power(Times(d,f,Plus(m,n,C1)),CN1)),x),Dist(Power(Times(d,Plus(m,n,C1)),CN1),Int(Times(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Subtract(m,C1)),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),n),Simp(Subtract(Plus(Times(a,ASymbol,d,Plus(m,n,C1)),Times(CN1,C,Plus(Times(b,c,m),Times(a,d,Plus(n,C1)))),Times(d,Subtract(Plus(Times(ASymbol,b),Times(a,BSymbol)),Times(b,C)),Plus(m,n,C1),Tan(Plus(e,Times(f,x))))),Times(Subtract(Times(C,m,Subtract(Times(b,c),Times(a,d))),Times(b,BSymbol,d,Plus(m,n,C1))),Sqr(Tan(Plus(e,Times(f,x)))))),x)),x),x)),And(FreeQ(List(a,b,c,d,e,f,ASymbol,BSymbol,C,n),x),NeQ(Subtract(Times(b,c),Times(a,d)),C0),NeQ(Plus(Sqr(a),Sqr(b)),C0),NeQ(Plus(Sqr(c),Sqr(d)),C0),GtQ(m,C0),Not(And(IGtQ(n,C0),Or(Not(IntegerQ(m)),And(EqQ(c,C0),NeQ(a,C0)))))))),
IIntegrate(3648,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_),Plus(A_DEFAULT,Times(C_DEFAULT,Sqr($($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Simp(Times(C,Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),m),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),Plus(n,C1)),Power(Times(d,f,Plus(m,n,C1)),CN1)),x),Dist(Power(Times(d,Plus(m,n,C1)),CN1),Int(Times(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Subtract(m,C1)),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),n),Simp(Subtract(Plus(Times(a,ASymbol,d,Plus(m,n,C1)),Times(CN1,C,Plus(Times(b,c,m),Times(a,d,Plus(n,C1)))),Times(d,Subtract(Times(ASymbol,b),Times(b,C)),Plus(m,n,C1),Tan(Plus(e,Times(f,x))))),Times(C,m,Subtract(Times(b,c),Times(a,d)),Sqr(Tan(Plus(e,Times(f,x)))))),x)),x),x)),And(FreeQ(List(a,b,c,d,e,f,ASymbol,C,n),x),NeQ(Subtract(Times(b,c),Times(a,d)),C0),NeQ(Plus(Sqr(a),Sqr(b)),C0),NeQ(Plus(Sqr(c),Sqr(d)),C0),GtQ(m,C0),Not(And(IGtQ(n,C0),Or(Not(IntegerQ(m)),And(EqQ(c,C0),NeQ(a,C0)))))))),
IIntegrate(3649,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_),Plus(A_DEFAULT,Times(B_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),Times(C_DEFAULT,Sqr($($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Simp(Times(Subtract(Times(ASymbol,Sqr(b)),Times(a,Subtract(Times(b,BSymbol),Times(a,C)))),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Plus(m,C1)),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),Plus(n,C1)),Power(Times(f,Plus(m,C1),Subtract(Times(b,c),Times(a,d)),Plus(Sqr(a),Sqr(b))),CN1)),x),Dist(Power(Times(Plus(m,C1),Subtract(Times(b,c),Times(a,d)),Plus(Sqr(a),Sqr(b))),CN1),Int(Times(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Plus(m,C1)),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),n),Simp(Subtract(Subtract(Plus(Times(ASymbol,Subtract(Times(a,Subtract(Times(b,c),Times(a,d)),Plus(m,C1)),Times(Sqr(b),d,Plus(m,n,C2)))),Times(Subtract(Times(b,BSymbol),Times(a,C)),Plus(Times(b,c,Plus(m,C1)),Times(a,d,Plus(n,C1))))),Times(Plus(m,C1),Subtract(Times(b,c),Times(a,d)),Subtract(Subtract(Times(ASymbol,b),Times(a,BSymbol)),Times(b,C)),Tan(Plus(e,Times(f,x))))),Times(d,Subtract(Times(ASymbol,Sqr(b)),Times(a,Subtract(Times(b,BSymbol),Times(a,C)))),Plus(m,n,C2),Sqr(Tan(Plus(e,Times(f,x)))))),x)),x),x)),And(FreeQ(List(a,b,c,d,e,f,ASymbol,BSymbol,C,n),x),NeQ(Subtract(Times(b,c),Times(a,d)),C0),NeQ(Plus(Sqr(a),Sqr(b)),C0),NeQ(Plus(Sqr(c),Sqr(d)),C0),LtQ(m,CN1),Not(And(ILtQ(n,CN1),Or(Not(IntegerQ(m)),And(EqQ(c,C0),NeQ(a,C0)))))))),
IIntegrate(3650,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_),Plus(A_DEFAULT,Times(C_DEFAULT,Sqr($($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Simp(Times(Plus(Times(ASymbol,Sqr(b)),Times(Sqr(a),C)),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Plus(m,C1)),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),Plus(n,C1)),Power(Times(f,Plus(m,C1),Subtract(Times(b,c),Times(a,d)),Plus(Sqr(a),Sqr(b))),CN1)),x),Dist(Power(Times(Plus(m,C1),Subtract(Times(b,c),Times(a,d)),Plus(Sqr(a),Sqr(b))),CN1),Int(Times(Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),Plus(m,C1)),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),n),Simp(Subtract(Subtract(Subtract(Times(ASymbol,Subtract(Times(a,Subtract(Times(b,c),Times(a,d)),Plus(m,C1)),Times(Sqr(b),d,Plus(m,n,C2)))),Times(a,C,Plus(Times(b,c,Plus(m,C1)),Times(a,d,Plus(n,C1))))),Times(Plus(m,C1),Subtract(Times(b,c),Times(a,d)),Subtract(Times(ASymbol,b),Times(b,C)),Tan(Plus(e,Times(f,x))))),Times(d,Plus(Times(ASymbol,Sqr(b)),Times(Sqr(a),C)),Plus(m,n,C2),Sqr(Tan(Plus(e,Times(f,x)))))),x)),x),x)),And(FreeQ(List(a,b,c,d,e,f,ASymbol,C,n),x),NeQ(Subtract(Times(b,c),Times(a,d)),C0),NeQ(Plus(Sqr(a),Sqr(b)),C0),NeQ(Plus(Sqr(c),Sqr(d)),C0),LtQ(m,CN1),Not(And(ILtQ(n,CN1),Or(Not(IntegerQ(m)),And(EqQ(c,C0),NeQ(a,C0)))))))),
IIntegrate(3651,Int(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),CN1),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),CN1),Plus(A_DEFAULT,Times(B_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),Times(C_DEFAULT,Sqr($($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Simp(Times(Plus(Times(a,Plus(Times(ASymbol,c),Times(CN1,c,C),Times(BSymbol,d))),Times(b,Plus(Times(BSymbol,c),Times(CN1,ASymbol,d),Times(C,d)))),x,Power(Times(Plus(Sqr(a),Sqr(b)),Plus(Sqr(c),Sqr(d))),CN1)),x),Dist(Times(Plus(Times(ASymbol,Sqr(b)),Times(CN1,a,b,BSymbol),Times(Sqr(a),C)),Power(Times(Subtract(Times(b,c),Times(a,d)),Plus(Sqr(a),Sqr(b))),CN1)),Int(Times(Subtract(b,Times(a,Tan(Plus(e,Times(f,x))))),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),CN1)),x),x),Negate(Dist(Times(Plus(Times(Sqr(c),C),Times(CN1,BSymbol,c,d),Times(ASymbol,Sqr(d))),Power(Times(Subtract(Times(b,c),Times(a,d)),Plus(Sqr(c),Sqr(d))),CN1)),Int(Times(Subtract(d,Times(c,Tan(Plus(e,Times(f,x))))),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),CN1)),x),x))),And(FreeQ(List(a,b,c,d,e,f,ASymbol,BSymbol,C),x),NeQ(Subtract(Times(b,c),Times(a,d)),C0),NeQ(Plus(Sqr(a),Sqr(b)),C0),NeQ(Plus(Sqr(c),Sqr(d)),C0)))),
IIntegrate(3652,Int(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),CN1),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),CN1),Plus(A_DEFAULT,Times(C_DEFAULT,Sqr($($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Simp(Times(Subtract(Times(a,Subtract(Times(ASymbol,c),Times(c,C))),Times(b,Subtract(Times(ASymbol,d),Times(C,d)))),x,Power(Times(Plus(Sqr(a),Sqr(b)),Plus(Sqr(c),Sqr(d))),CN1)),x),Dist(Times(Plus(Times(ASymbol,Sqr(b)),Times(Sqr(a),C)),Power(Times(Subtract(Times(b,c),Times(a,d)),Plus(Sqr(a),Sqr(b))),CN1)),Int(Times(Subtract(b,Times(a,Tan(Plus(e,Times(f,x))))),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),CN1)),x),x),Negate(Dist(Times(Plus(Times(Sqr(c),C),Times(ASymbol,Sqr(d))),Power(Times(Subtract(Times(b,c),Times(a,d)),Plus(Sqr(c),Sqr(d))),CN1)),Int(Times(Subtract(d,Times(c,Tan(Plus(e,Times(f,x))))),Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),CN1)),x),x))),And(FreeQ(List(a,b,c,d,e,f,ASymbol,C),x),NeQ(Subtract(Times(b,c),Times(a,d)),C0),NeQ(Plus(Sqr(a),Sqr(b)),C0),NeQ(Plus(Sqr(c),Sqr(d)),C0)))),
IIntegrate(3653,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),CN1),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_),Plus(A_DEFAULT,Times(B_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),Times(C_DEFAULT,Sqr($($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Dist(Power(Plus(Sqr(a),Sqr(b)),CN1),Int(Times(Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),n),Simp(Plus(Times(b,BSymbol),Times(a,Subtract(ASymbol,C)),Times(Subtract(Times(a,BSymbol),Times(b,Subtract(ASymbol,C))),Tan(Plus(e,Times(f,x))))),x)),x),x),Dist(Times(Plus(Times(ASymbol,Sqr(b)),Times(CN1,a,b,BSymbol),Times(Sqr(a),C)),Power(Plus(Sqr(a),Sqr(b)),CN1)),Int(Times(Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),n),Plus(C1,Sqr(Tan(Plus(e,Times(f,x))))),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),CN1)),x),x)),And(FreeQ(List(a,b,c,d,e,f,ASymbol,BSymbol,C,n),x),NeQ(Subtract(Times(b,c),Times(a,d)),C0),NeQ(Plus(Sqr(a),Sqr(b)),C0),NeQ(Plus(Sqr(c),Sqr(d)),C0),Not(GtQ(n,C0)),Not(LeQ(n,CN1))))),
IIntegrate(3654,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),CN1),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_),Plus(A_DEFAULT,Times(C_DEFAULT,Sqr($($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Dist(Power(Plus(Sqr(a),Sqr(b)),CN1),Int(Times(Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),n),Simp(Subtract(Times(a,Subtract(ASymbol,C)),Times(Subtract(Times(ASymbol,b),Times(b,C)),Tan(Plus(e,Times(f,x))))),x)),x),x),Dist(Times(Plus(Times(ASymbol,Sqr(b)),Times(Sqr(a),C)),Power(Plus(Sqr(a),Sqr(b)),CN1)),Int(Times(Power(Plus(c,Times(d,Tan(Plus(e,Times(f,x))))),n),Plus(C1,Sqr(Tan(Plus(e,Times(f,x))))),Power(Plus(a,Times(b,Tan(Plus(e,Times(f,x))))),CN1)),x),x)),And(FreeQ(List(a,b,c,d,e,f,ASymbol,C,n),x),NeQ(Subtract(Times(b,c),Times(a,d)),C0),NeQ(Plus(Sqr(a),Sqr(b)),C0),NeQ(Plus(Sqr(c),Sqr(d)),C0),Not(GtQ(n,C0)),Not(LeQ(n,CN1))))),
IIntegrate(3655,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_),Plus(A_DEFAULT,Times(B_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),Times(C_DEFAULT,Sqr($($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),x_Symbol),
    Condition(With(List(Set($s("ff"),FreeFactors(Tan(Plus(e,Times(f,x))),x))),Dist(Times($s("ff"),Power(f,CN1)),Subst(Int(Times(Power(Plus(a,Times(b,$s("ff"),x)),m),Power(Plus(c,Times(d,$s("ff"),x)),n),Plus(ASymbol,Times(BSymbol,$s("ff"),x),Times(C,Sqr($s("ff")),Sqr(x))),Power(Plus(C1,Times(Sqr($s("ff")),Sqr(x))),CN1)),x),x,Times(Tan(Plus(e,Times(f,x))),Power($s("ff"),CN1))),x)),And(FreeQ(List(a,b,c,d,e,f,ASymbol,BSymbol,C,m,n),x),NeQ(Subtract(Times(b,c),Times(a,d)),C0),NeQ(Plus(Sqr(a),Sqr(b)),C0),NeQ(Plus(Sqr(c),Sqr(d)),C0)))),
IIntegrate(3656,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_),Plus(A_DEFAULT,Times(C_DEFAULT,Sqr($($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),x_Symbol),
    Condition(With(List(Set($s("ff"),FreeFactors(Tan(Plus(e,Times(f,x))),x))),Dist(Times($s("ff"),Power(f,CN1)),Subst(Int(Times(Power(Plus(a,Times(b,$s("ff"),x)),m),Power(Plus(c,Times(d,$s("ff"),x)),n),Plus(ASymbol,Times(C,Sqr($s("ff")),Sqr(x))),Power(Plus(C1,Times(Sqr($s("ff")),Sqr(x))),CN1)),x),x,Times(Tan(Plus(e,Times(f,x))),Power($s("ff"),CN1))),x)),And(FreeQ(List(a,b,c,d,e,f,ASymbol,C,m,n),x),NeQ(Subtract(Times(b,c),Times(a,d)),C0),NeQ(Plus(Sqr(a),Sqr(b)),C0),NeQ(Plus(Sqr(c),Sqr(d)),C0)))),
IIntegrate(3657,Int(Times(u_DEFAULT,Power(Plus(a_,Times(b_DEFAULT,Sqr($($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),p_)),x_Symbol),
    Condition(Int(ActivateTrig(Times(u,Power(Times(a,Sqr($($s("§sec"),Plus(e,Times(f,x))))),p))),x),And(FreeQ(List(a,b,e,f,p),x),EqQ(a,b)))),
IIntegrate(3658,Int(Times(u_DEFAULT,Power(Times(b_DEFAULT,Power($($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),n_)),p_)),x_Symbol),
    Condition(With(List(Set($s("ff"),FreeFactors(Tan(Plus(e,Times(f,x))),x))),Dist(Times(Power(Times(b,Power($s("ff"),n)),IntPart(p)),Power(Times(b,Power(Tan(Plus(e,Times(f,x))),n)),FracPart(p)),Power(Power(Times(Tan(Plus(e,Times(f,x))),Power($s("ff"),CN1)),Times(n,FracPart(p))),CN1)),Int(Times(ActivateTrig(u),Power(Times(Tan(Plus(e,Times(f,x))),Power($s("ff"),CN1)),Times(n,p))),x),x)),And(FreeQ(List(b,e,f,n,p),x),Not(IntegerQ(p)),IntegerQ(n),Or(EqQ(u,C1),MatchQ(u,Condition(Power(Times(d_DEFAULT,$($p("§trig"),Plus(e,Times(f,x)))),m_DEFAULT),And(FreeQ(List(d,m),x),MemberQ(List($s("§sin"),$s("§cos"),$s("§tan"),$s("§cot"),$s("§sec"),$s("§csc")),$s("§trig"))))))))),
IIntegrate(3659,Int(Times(u_DEFAULT,Power(Times(b_DEFAULT,Power(Times(c_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_)),p_)),x_Symbol),
    Condition(Dist(Times(Power(b,IntPart(p)),Power(Times(b,Power(Times(c,Tan(Plus(e,Times(f,x)))),n)),FracPart(p)),Power(Power(Times(c,Tan(Plus(e,Times(f,x)))),Times(n,FracPart(p))),CN1)),Int(Times(ActivateTrig(u),Power(Times(c,Tan(Plus(e,Times(f,x)))),Times(n,p))),x),x),And(FreeQ(List(b,c,e,f,n,p),x),Not(IntegerQ(p)),Not(IntegerQ(n)),Or(EqQ(u,C1),MatchQ(u,Condition(Power(Times(d_DEFAULT,$($p("§trig"),Plus(e,Times(f,x)))),m_DEFAULT),And(FreeQ(List(d,m),x),MemberQ(List($s("§sin"),$s("§cos"),$s("§tan"),$s("§cot"),$s("§sec"),$s("§csc")),$s("§trig"))))))))),
IIntegrate(3660,Int(Power(Plus(a_,Times(b_DEFAULT,Sqr($($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),CN1),x_Symbol),
    Condition(Subtract(Simp(Times(x,Power(Subtract(a,b),CN1)),x),Dist(Times(b,Power(Subtract(a,b),CN1)),Int(Times(Sqr(Sec(Plus(e,Times(f,x)))),Power(Plus(a,Times(b,Sqr(Tan(Plus(e,Times(f,x)))))),CN1)),x),x)),And(FreeQ(List(a,b,e,f),x),NeQ(a,b))))
  );
}
