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
public class IntRules0 { 
  public static IAST RULES = List( 
IIntegrate(1,Int(Times(u_DEFAULT,Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_DEFAULT))),p_DEFAULT)),x_Symbol),
    Condition(Int(Times(u,Power(Times(b,Power(x,n)),p)),x),And(FreeQ(List(a,b,n,p),x),EqQ(a,C0)))),
IIntegrate(2,Int(Times(u_DEFAULT,Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_DEFAULT))),p_DEFAULT)),x_Symbol),
    Condition(Int(Times(u,Power(a,p)),x),And(FreeQ(List(a,b,n,p),x),EqQ(b,C0)))),
IIntegrate(3,Int(Times(u_DEFAULT,Power(Plus(a_,Times(c_DEFAULT,Power(x_,j_DEFAULT)),Times(b_DEFAULT,Power(x_,n_DEFAULT))),p_DEFAULT)),x_Symbol),
    Condition(Int(Times(u,Power(Plus(Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),p)),x),And(FreeQ(List(a,b,c,n,p),x),EqQ(j,Times(C2,n)),EqQ(a,C0)))),
IIntegrate(4,Int(Times(u_DEFAULT,Power(Plus(a_DEFAULT,Times(c_DEFAULT,Power(x_,j_DEFAULT)),Times(b_DEFAULT,Power(x_,n_DEFAULT))),p_DEFAULT)),x_Symbol),
    Condition(Int(Times(u,Power(Plus(a,Times(c,Power(x,Times(C2,n)))),p)),x),And(FreeQ(List(a,b,c,n,p),x),EqQ(j,Times(C2,n)),EqQ(b,C0)))),
IIntegrate(5,Int(Times(u_DEFAULT,Power(Plus(a_DEFAULT,Times(c_DEFAULT,Power(x_,j_DEFAULT)),Times(b_DEFAULT,Power(x_,n_DEFAULT))),p_DEFAULT)),x_Symbol),
    Condition(Int(Times(u,Power(Plus(a,Times(b,Power(x,n))),p)),x),And(FreeQ(List(a,b,c,n,p),x),EqQ(j,Times(C2,n)),EqQ(c,C0)))),
IIntegrate(6,Int(Times(u_DEFAULT,Power(Plus(w_DEFAULT,Times(a_DEFAULT,v_),Times(b_DEFAULT,v_)),p_DEFAULT)),x_Symbol),
    Condition(Int(Times(u,Power(Plus(Times(Plus(a,b),v),w),p)),x),And(FreeQ(List(a,b),x),Not(FreeQ(v,x))))),
IIntegrate(7,Int(Times(u_DEFAULT,Power($p("§px"),p_)),x_Symbol),
    Condition(Int(Times(u,Power($s("§px"),Simplify(p))),x),And(PolyQ($s("§px"),x),Not(RationalQ(p)),FreeQ(p,x),RationalQ(Simplify(p))))),
IIntegrate(8,Int(a_,x_Symbol),
    Condition(Simp(Times(a,x),x),FreeQ(a,x))),
IIntegrate(9,Int(Times(a_,Plus(b_,Times(c_DEFAULT,x_))),x_Symbol),
    Condition(Simp(Times(a,Sqr(Plus(b,Times(c,x))),Power(Times(C2,c),CN1)),x),FreeQ(List(a,b,c),x))),
IIntegrate(10,Int(Negate(u_),x_Symbol),
    Dist(Identity(CN1),Int(u,x),x)),
IIntegrate(11,Int(Times(Complex(C0,a_),u_),x_Symbol),
    Condition(Dist(Complex(Identity(C0),a),Int(u,x),x),And(FreeQ(a,x),EqQ(Sqr(a),C1)))),
IIntegrate(12,Int(Times(a_,u_),x_Symbol),
    Condition(Dist(a,Int(u,x),x),And(FreeQ(a,x),Not(MatchQ(u,Condition(Times(b_,v_),FreeQ(b,x))))))),
IIntegrate(13,Int(u_,x_Symbol),
    Condition(Simp(IntSum(u,x),x),SumQ(u))),
IIntegrate(14,Int(Times(u_,Power(Times(c_DEFAULT,x_),m_DEFAULT)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times(Power(Times(c,x),m),u),x),x),And(FreeQ(List(c,m),x),SumQ(u),Not(LinearQ(u,x)),Not(MatchQ(u,Condition(Plus(a_,Times(b_DEFAULT,v_)),And(FreeQ(List(a,b),x),InverseFunctionQ(v)))))))),
IIntegrate(15,Int(Times(u_DEFAULT,Power(Times(a_DEFAULT,Power(x_,n_)),m_)),x_Symbol),
    Condition(Dist(Times(Power(a,IntPart(m)),Power(Times(a,Power(x,n)),FracPart(m)),Power(Power(x,Times(n,FracPart(m))),CN1)),Int(Times(u,Power(x,Times(m,n))),x),x),And(FreeQ(List(a,m,n),x),Not(IntegerQ(m))))),
IIntegrate(16,Int(Times(u_DEFAULT,Power(v_,m_DEFAULT),Power(Times(b_,v_),n_)),x_Symbol),
    Condition(Dist(Power(Power(b,m),CN1),Int(Times(u,Power(Times(b,v),Plus(m,n))),x),x),And(FreeQ(List(b,n),x),IntegerQ(m)))),
IIntegrate(17,Int(Times(u_DEFAULT,Power(Times(a_DEFAULT,v_),m_),Power(Times(b_DEFAULT,v_),n_)),x_Symbol),
    Condition(Dist(Times(Power(a,Plus(m,C1D2)),Power(b,Subtract(n,C1D2)),Sqrt(Times(b,v)),Power(Times(a,v),CN1D2)),Int(Times(u,Power(v,Plus(m,n))),x),x),And(FreeQ(List(a,b,m),x),Not(IntegerQ(m)),IGtQ(Plus(n,C1D2),C0),IntegerQ(Plus(m,n))))),
IIntegrate(18,Int(Times(u_DEFAULT,Power(Times(a_DEFAULT,v_),m_),Power(Times(b_DEFAULT,v_),n_)),x_Symbol),
    Condition(Dist(Times(Power(a,Subtract(m,C1D2)),Power(b,Plus(n,C1D2)),Sqrt(Times(a,v)),Power(Times(b,v),CN1D2)),Int(Times(u,Power(v,Plus(m,n))),x),x),And(FreeQ(List(a,b,m),x),Not(IntegerQ(m)),ILtQ(Subtract(n,C1D2),C0),IntegerQ(Plus(m,n))))),
IIntegrate(19,Int(Times(u_DEFAULT,Power(Times(a_DEFAULT,v_),m_),Power(Times(b_DEFAULT,v_),n_)),x_Symbol),
    Condition(Dist(Times(Power(a,Plus(m,n)),Power(Times(b,v),n),Power(Power(Times(a,v),n),CN1)),Int(Times(u,Power(v,Plus(m,n))),x),x),And(FreeQ(List(a,b,m,n),x),Not(IntegerQ(m)),Not(IntegerQ(n)),IntegerQ(Plus(m,n))))),
IIntegrate(20,Int(Times(u_DEFAULT,Power(Times(a_DEFAULT,v_),m_),Power(Times(b_DEFAULT,v_),n_)),x_Symbol),
    Condition(Dist(Times(Power(b,IntPart(n)),Power(Times(b,v),FracPart(n)),Power(Times(Power(a,IntPart(n)),Power(Times(a,v),FracPart(n))),CN1)),Int(Times(u,Power(Times(a,v),Plus(m,n))),x),x),And(FreeQ(List(a,b,m,n),x),Not(IntegerQ(m)),Not(IntegerQ(n)),Not(IntegerQ(Plus(m,n)))))),
IIntegrate(21,Int(Times(u_DEFAULT,Power(Plus(a_,Times(b_DEFAULT,v_)),m_DEFAULT),Power(Plus(c_,Times(d_DEFAULT,v_)),n_DEFAULT)),x_Symbol),
    Condition(Dist(Power(Times(b,Power(d,CN1)),m),Int(Times(u,Power(Plus(c,Times(d,v)),Plus(m,n))),x),x),And(FreeQ(List(a,b,c,d,n),x),EqQ(Subtract(Times(b,c),Times(a,d)),C0),IntegerQ(m),Or(Not(IntegerQ(n)),SimplerQ(Plus(c,Times(d,x)),Plus(a,Times(b,x))))))),
IIntegrate(22,Int(Times(u_DEFAULT,Power(Plus(a_,Times(b_DEFAULT,v_)),m_),Power(Plus(c_,Times(d_DEFAULT,v_)),n_)),x_Symbol),
    Condition(Dist(Power(Times(b,Power(d,CN1)),m),Int(Times(u,Power(Plus(c,Times(d,v)),Plus(m,n))),x),x),And(FreeQ(List(a,b,c,d,m,n),x),EqQ(Subtract(Times(b,c),Times(a,d)),C0),GtQ(Times(b,Power(d,CN1)),C0),Not(Or(IntegerQ(m),IntegerQ(n)))))),
IIntegrate(23,Int(Times(u_DEFAULT,Power(Plus(a_,Times(b_DEFAULT,v_)),m_),Power(Plus(c_,Times(d_DEFAULT,v_)),n_)),x_Symbol),
    Condition(Dist(Times(Power(Plus(a,Times(b,v)),m),Power(Power(Plus(c,Times(d,v)),m),CN1)),Int(Times(u,Power(Plus(c,Times(d,v)),Plus(m,n))),x),x),And(FreeQ(List(a,b,c,d,m,n),x),EqQ(Subtract(Times(b,c),Times(a,d)),C0),Not(Or(IntegerQ(m),IntegerQ(n),GtQ(Times(b,Power(d,CN1)),C0)))))),
IIntegrate(24,Int(Times(u_DEFAULT,Power(Plus(a_,Times(b_DEFAULT,v_)),m_),Plus(A_DEFAULT,Times(B_DEFAULT,v_),Times(C_DEFAULT,Sqr(v_)))),x_Symbol),
    Condition(Dist(Power(b,CN2),Int(Times(u,Power(Plus(a,Times(b,v)),Plus(m,C1)),Simp(Plus(Times(b,BSymbol),Times(CN1,a,C),Times(b,C,v)),x)),x),x),And(FreeQ(List(a,b,ASymbol,BSymbol,C),x),EqQ(Plus(Times(ASymbol,Sqr(b)),Times(CN1,a,b,BSymbol),Times(Sqr(a),C)),C0),LeQ(m,CN1)))),
IIntegrate(25,Int(Times(u_DEFAULT,Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_DEFAULT))),m_DEFAULT),Power(Plus(c_,Times(d_DEFAULT,Power(x_,q_DEFAULT))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Power(Times(d,Power(a,CN1)),p),Int(Times(u,Power(Plus(a,Times(b,Power(x,n))),Plus(m,p)),Power(Power(x,Times(n,p)),CN1)),x),x),And(FreeQ(List(a,b,c,d,m,n),x),EqQ(q,Negate(n)),IntegerQ(p),EqQ(Subtract(Times(a,c),Times(b,d)),C0),Not(And(IntegerQ(m),NegQ(n))))))
  );
}
