package org.matheclipse.core.integrate.rubi45;


import static org.matheclipse.core.expression.F.*;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.*;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctions.*;
import org.matheclipse.core.interfaces.IAST;

/** 
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class IntRules61 { 
  public static IAST RULES = List( 
ISetDelayed(7087,Int(Times(Plus(A_DEFAULT,Times(B_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),Times(C_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Power(Times(Sqrt(Times(d_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),Power(Plus(a_,Times(b_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),QQ(3L,2L))),-1)),x_Symbol),
    Condition(Plus(Dist(Times(CSymbol,Power(Times(b,d),-1)),Int(Times(Sqrt(Times(d,Sin(Plus(e,Times(f,x))))),Power(Plus(a,Times(b,Sin(Plus(e,Times(f,x))))),CN1D2)),x),x),Dist(Power(b,-1),Int(Times(Plus(Times(ASymbol,b),Times(Plus(Times(b,BSymbol),Times(CN1,a,CSymbol)),Sin(Plus(e,Times(f,x))))),Power(Times(Power(Plus(a,Times(b,Sin(Plus(e,Times(f,x))))),QQ(3L,2L)),Sqrt(Times(d,Sin(Plus(e,Times(f,x)))))),-1)),x),x)),And(FreeQ(List(a,b,d,e,f,ASymbol,BSymbol,CSymbol),x),NeQ(Plus(Sqr(a),Negate(Sqr(b))),C0)))),
ISetDelayed(7088,Int(Times(Plus(A_DEFAULT,Times(C_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Power(Times(Sqrt(Times(d_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),Power(Plus(a_,Times(b_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),QQ(3L,2L))),-1)),x_Symbol),
    Condition(Plus(Dist(Times(CSymbol,Power(Times(b,d),-1)),Int(Times(Sqrt(Times(d,Sin(Plus(e,Times(f,x))))),Power(Plus(a,Times(b,Sin(Plus(e,Times(f,x))))),CN1D2)),x),x),Dist(Power(b,-1),Int(Times(Plus(Times(ASymbol,b),Times(CN1,a,CSymbol,Sin(Plus(e,Times(f,x))))),Power(Times(Power(Plus(a,Times(b,Sin(Plus(e,Times(f,x))))),QQ(3L,2L)),Sqrt(Times(d,Sin(Plus(e,Times(f,x)))))),-1)),x),x)),And(FreeQ(List(a,b,d,e,f,ASymbol,CSymbol),x),NeQ(Plus(Sqr(a),Negate(Sqr(b))),C0)))),
ISetDelayed(7089,Int(Times(Plus(A_DEFAULT,Times(B_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),Times(C_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Power(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),QQ(3L,2L)),Sqrt(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),-1)),x_Symbol),
    Condition(Plus(Dist(Times(CSymbol,Power(b,-2)),Int(Times(Sqrt(Plus(a,Times(b,Sin(Plus(e,Times(f,x)))))),Power(Plus(c,Times(d,Sin(Plus(e,Times(f,x))))),CN1D2)),x),x),Dist(Power(b,-2),Int(Times(Plus(Times(ASymbol,Sqr(b)),Times(CN1,Sqr(a),CSymbol),Times(b,Plus(Times(b,BSymbol),Times(CN1,C2,a,CSymbol)),Sin(Plus(e,Times(f,x))))),Power(Times(Power(Plus(a,Times(b,Sin(Plus(e,Times(f,x))))),QQ(3L,2L)),Sqrt(Plus(c,Times(d,Sin(Plus(e,Times(f,x))))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f,ASymbol,BSymbol,CSymbol),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),NeQ(Plus(Sqr(a),Negate(Sqr(b))),C0),NeQ(Plus(Sqr(c),Negate(Sqr(d))),C0)))),
ISetDelayed(7090,Int(Times(Plus(A_DEFAULT,Times(C_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Power(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),QQ(3L,2L)),Sqrt(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),-1)),x_Symbol),
    Condition(Plus(Dist(Times(CSymbol,Power(b,-2)),Int(Times(Sqrt(Plus(a,Times(b,Sin(Plus(e,Times(f,x)))))),Power(Plus(c,Times(d,Sin(Plus(e,Times(f,x))))),CN1D2)),x),x),Dist(Power(b,-2),Int(Times(Plus(Times(ASymbol,Sqr(b)),Times(CN1,Sqr(a),CSymbol),Times(CN1,C2,a,b,CSymbol,Sin(Plus(e,Times(f,x))))),Power(Times(Power(Plus(a,Times(b,Sin(Plus(e,Times(f,x))))),QQ(3L,2L)),Sqrt(Plus(c,Times(d,Sin(Plus(e,Times(f,x))))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f,ASymbol,CSymbol),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),NeQ(Plus(Sqr(a),Negate(Sqr(b))),C0),NeQ(Plus(Sqr(c),Negate(Sqr(d))),C0)))),
ISetDelayed(7091,Int(Times(Plus(A_DEFAULT,Times(B_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),Times(C_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Plus(Times(ASymbol,Sqr(b)),Times(CN1,a,b,BSymbol),Times(Sqr(a),CSymbol)),Cos(Plus(e,Times(f,x))),Power(Plus(a,Times(b,Sin(Plus(e,Times(f,x))))),Plus(m,C1)),Power(Plus(c,Times(d,Sin(Plus(e,Times(f,x))))),Plus(n,C1)),Power(Times(f,Plus(m,C1),Plus(Times(b,c),Times(CN1,a,d)),Plus(Sqr(a),Negate(Sqr(b)))),-1)),x)),Dist(Power(Times(Plus(m,C1),Plus(Times(b,c),Times(CN1,a,d)),Plus(Sqr(a),Negate(Sqr(b)))),-1),Int(Times(Power(Plus(a,Times(b,Sin(Plus(e,Times(f,x))))),Plus(m,C1)),Power(Plus(c,Times(d,Sin(Plus(e,Times(f,x))))),n),Simp(Plus(Times(Plus(m,C1),Plus(Times(b,c),Times(CN1,a,d)),Plus(Times(a,ASymbol),Times(CN1,b,BSymbol),Times(a,CSymbol))),Times(d,Plus(Times(ASymbol,Sqr(b)),Times(CN1,a,b,BSymbol),Times(Sqr(a),CSymbol)),Plus(m,n,C2)),Times(CN1,Plus(Times(c,Plus(Times(ASymbol,Sqr(b)),Times(CN1,a,b,BSymbol),Times(Sqr(a),CSymbol))),Times(Plus(m,C1),Plus(Times(b,c),Times(CN1,a,d)),Plus(Times(ASymbol,b),Times(CN1,a,BSymbol),Times(b,CSymbol)))),Sin(Plus(e,Times(f,x)))),Times(CN1,d,Plus(Times(ASymbol,Sqr(b)),Times(CN1,a,b,BSymbol),Times(Sqr(a),CSymbol)),Plus(m,n,C3),Sqr(Sin(Plus(e,Times(f,x)))))),x)),x),x)),And(FreeQ(List(a,b,c,d,e,f,ASymbol,BSymbol,CSymbol,n),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),NeQ(Plus(Sqr(a),Negate(Sqr(b))),C0),NeQ(Plus(Sqr(c),Negate(Sqr(d))),C0),LtQ(m,CN1),Or(And(EqQ(a,C0),IntegerQ(m),Not(IntegerQ(n))),Not(And(IntegerQ(Times(C2,n)),LtQ(n,CN1),Or(And(IntegerQ(n),Not(IntegerQ(m))),EqQ(a,C0)))))))),
ISetDelayed(7092,Int(Times(Plus(A_DEFAULT,Times(C_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Plus(Times(ASymbol,Sqr(b)),Times(Sqr(a),CSymbol)),Cos(Plus(e,Times(f,x))),Power(Plus(a,Times(b,Sin(Plus(e,Times(f,x))))),Plus(m,C1)),Power(Plus(c,Times(d,Sin(Plus(e,Times(f,x))))),Plus(n,C1)),Power(Times(f,Plus(m,C1),Plus(Times(b,c),Times(CN1,a,d)),Plus(Sqr(a),Negate(Sqr(b)))),-1)),x)),Dist(Power(Times(Plus(m,C1),Plus(Times(b,c),Times(CN1,a,d)),Plus(Sqr(a),Negate(Sqr(b)))),-1),Int(Times(Power(Plus(a,Times(b,Sin(Plus(e,Times(f,x))))),Plus(m,C1)),Power(Plus(c,Times(d,Sin(Plus(e,Times(f,x))))),n),Simp(Plus(Times(a,Plus(m,C1),Plus(Times(b,c),Times(CN1,a,d)),Plus(ASymbol,CSymbol)),Times(d,Plus(Times(ASymbol,Sqr(b)),Times(Sqr(a),CSymbol)),Plus(m,n,C2)),Times(CN1,Plus(Times(c,Plus(Times(ASymbol,Sqr(b)),Times(Sqr(a),CSymbol))),Times(b,Plus(m,C1),Plus(Times(b,c),Times(CN1,a,d)),Plus(ASymbol,CSymbol))),Sin(Plus(e,Times(f,x)))),Times(CN1,d,Plus(Times(ASymbol,Sqr(b)),Times(Sqr(a),CSymbol)),Plus(m,n,C3),Sqr(Sin(Plus(e,Times(f,x)))))),x)),x),x)),And(FreeQ(List(a,b,c,d,e,f,ASymbol,CSymbol,n),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),NeQ(Plus(Sqr(a),Negate(Sqr(b))),C0),NeQ(Plus(Sqr(c),Negate(Sqr(d))),C0),LtQ(m,CN1),Or(And(EqQ(a,C0),IntegerQ(m),Not(IntegerQ(n))),Not(And(IntegerQ(Times(C2,n)),LtQ(n,CN1),Or(And(IntegerQ(n),Not(IntegerQ(m))),EqQ(a,C0)))))))),
ISetDelayed(7093,Int(Times(Plus(A_DEFAULT,Times(B_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),Times(C_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Power(Times(Plus(a_,Times(b_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),-1)),x_Symbol),
    Condition(Plus(Simp(Times(CSymbol,x,Power(Times(b,d),-1)),x),Dist(Times(Plus(Times(ASymbol,Sqr(b)),Times(CN1,a,b,BSymbol),Times(Sqr(a),CSymbol)),Power(Times(b,Plus(Times(b,c),Times(CN1,a,d))),-1)),Int(Power(Plus(a,Times(b,Sin(Plus(e,Times(f,x))))),-1),x),x),Negate(Dist(Times(Plus(Times(Sqr(c),CSymbol),Times(CN1,BSymbol,c,d),Times(ASymbol,Sqr(d))),Power(Times(d,Plus(Times(b,c),Times(CN1,a,d))),-1)),Int(Power(Plus(c,Times(d,Sin(Plus(e,Times(f,x))))),-1),x),x))),And(FreeQ(List(a,b,c,d,e,f,ASymbol,BSymbol,CSymbol),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),NeQ(Plus(Sqr(a),Negate(Sqr(b))),C0),NeQ(Plus(Sqr(c),Negate(Sqr(d))),C0)))),
ISetDelayed(7094,Int(Times(Plus(A_DEFAULT,Times(C_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Power(Times(Plus(a_,Times(b_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),-1)),x_Symbol),
    Condition(Plus(Simp(Times(CSymbol,x,Power(Times(b,d),-1)),x),Dist(Times(Plus(Times(ASymbol,Sqr(b)),Times(Sqr(a),CSymbol)),Power(Times(b,Plus(Times(b,c),Times(CN1,a,d))),-1)),Int(Power(Plus(a,Times(b,Sin(Plus(e,Times(f,x))))),-1),x),x),Negate(Dist(Times(Plus(Times(Sqr(c),CSymbol),Times(ASymbol,Sqr(d))),Power(Times(d,Plus(Times(b,c),Times(CN1,a,d))),-1)),Int(Power(Plus(c,Times(d,Sin(Plus(e,Times(f,x))))),-1),x),x))),And(FreeQ(List(a,b,c,d,e,f,ASymbol,CSymbol),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),NeQ(Plus(Sqr(a),Negate(Sqr(b))),C0),NeQ(Plus(Sqr(c),Negate(Sqr(d))),C0)))),
ISetDelayed(7095,Int(Times(Plus(A_DEFAULT,Times(B_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),Times(C_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Power(Times(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),Sqrt(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),-1)),x_Symbol),
    Condition(Plus(Dist(Times(CSymbol,Power(Times(b,d),-1)),Int(Sqrt(Plus(a,Times(b,Sin(Plus(e,Times(f,x)))))),x),x),Negate(Dist(Power(Times(b,d),-1),Int(Times(Simp(Plus(Times(a,c,CSymbol),Times(CN1,ASymbol,b,d),Times(Plus(Times(b,c,CSymbol),Times(CN1,b,BSymbol,d),Times(a,CSymbol,d)),Sin(Plus(e,Times(f,x))))),x),Power(Times(Sqrt(Plus(a,Times(b,Sin(Plus(e,Times(f,x)))))),Plus(c,Times(d,Sin(Plus(e,Times(f,x)))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f,ASymbol,BSymbol,CSymbol),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),NeQ(Plus(Sqr(a),Negate(Sqr(b))),C0),NeQ(Plus(Sqr(c),Negate(Sqr(d))),C0)))),
ISetDelayed(7096,Int(Times(Plus(A_DEFAULT,Times(C_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Power(Times(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),Sqrt(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),-1)),x_Symbol),
    Condition(Plus(Dist(Times(CSymbol,Power(Times(b,d),-1)),Int(Sqrt(Plus(a,Times(b,Sin(Plus(e,Times(f,x)))))),x),x),Negate(Dist(Power(Times(b,d),-1),Int(Times(Simp(Plus(Times(a,c,CSymbol),Times(CN1,ASymbol,b,d),Times(Plus(Times(b,c,CSymbol),Times(a,CSymbol,d)),Sin(Plus(e,Times(f,x))))),x),Power(Times(Sqrt(Plus(a,Times(b,Sin(Plus(e,Times(f,x)))))),Plus(c,Times(d,Sin(Plus(e,Times(f,x)))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f,ASymbol,CSymbol),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),NeQ(Plus(Sqr(a),Negate(Sqr(b))),C0),NeQ(Plus(Sqr(c),Negate(Sqr(d))),C0)))),
ISetDelayed(7097,Int(Times(Plus(A_DEFAULT,Times(B_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),Times(C_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Power(Times(Sqrt(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Sqrt(Plus(c_,Times(d_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),-1)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(CSymbol,Cos(Plus(e,Times(f,x))),Sqrt(Plus(c,Times(d,Sin(Plus(e,Times(f,x)))))),Power(Times(d,f,Sqrt(Plus(a,Times(b,Sin(Plus(e,Times(f,x))))))),-1)),x)),Dist(Power(Times(C2,d),-1),Int(Times(C1,Simp(Plus(Times(C2,a,ASymbol,d),Times(CN1,CSymbol,Plus(Times(b,c),Times(CN1,a,d))),Times(CN1,C2,Plus(Times(a,c,CSymbol),Times(CN1,d,Plus(Times(ASymbol,b),Times(a,BSymbol)))),Sin(Plus(e,Times(f,x)))),Times(Plus(Times(C2,b,BSymbol,d),Times(CN1,CSymbol,Plus(Times(b,c),Times(a,d)))),Sqr(Sin(Plus(e,Times(f,x)))))),x),Power(Times(Power(Plus(a,Times(b,Sin(Plus(e,Times(f,x))))),QQ(3L,2L)),Sqrt(Plus(c,Times(d,Sin(Plus(e,Times(f,x))))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f,ASymbol,BSymbol,CSymbol),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),NeQ(Plus(Sqr(a),Negate(Sqr(b))),C0),NeQ(Plus(Sqr(c),Negate(Sqr(d))),C0)))),
ISetDelayed(7098,Int(Times(Plus(A_DEFAULT,Times(C_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Power(Times(Sqrt(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Sqrt(Plus(c_,Times(d_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),-1)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(CSymbol,Cos(Plus(e,Times(f,x))),Sqrt(Plus(c,Times(d,Sin(Plus(e,Times(f,x)))))),Power(Times(d,f,Sqrt(Plus(a,Times(b,Sin(Plus(e,Times(f,x))))))),-1)),x)),Dist(Power(Times(C2,d),-1),Int(Times(C1,Simp(Plus(Times(C2,a,ASymbol,d),Times(CN1,CSymbol,Plus(Times(b,c),Times(CN1,a,d))),Times(CN1,C2,Plus(Times(a,c,CSymbol),Times(CN1,ASymbol,b,d)),Sin(Plus(e,Times(f,x)))),Times(CN1,CSymbol,Plus(Times(b,c),Times(a,d)),Sqr(Sin(Plus(e,Times(f,x)))))),x),Power(Times(Power(Plus(a,Times(b,Sin(Plus(e,Times(f,x))))),QQ(3L,2L)),Sqrt(Plus(c,Times(d,Sin(Plus(e,Times(f,x))))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f,ASymbol,CSymbol),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),NeQ(Plus(Sqr(a),Negate(Sqr(b))),C0),NeQ(Plus(Sqr(c),Negate(Sqr(d))),C0)))),
ISetDelayed(7099,Int(Times(Plus(A_DEFAULT,Times(B_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),Times(C_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Power(Times(d_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Plus(Dist(Times(Plus(Times(b,BSymbol),Times(CN1,a,CSymbol)),Power(b,-2)),Int(Power(Times(d,Sin(Plus(e,Times(f,x)))),n),x),x),Dist(Times(Plus(Times(ASymbol,Sqr(b)),Times(CN1,a,b,BSymbol),Times(Sqr(a),CSymbol)),Power(b,-2)),Int(Times(Power(Times(d,Sin(Plus(e,Times(f,x)))),n),Power(Plus(a,Times(b,Sin(Plus(e,Times(f,x))))),-1)),x),x),Dist(Times(CSymbol,Power(Times(b,d),-1)),Int(Power(Times(d,Sin(Plus(e,Times(f,x)))),Plus(n,C1)),x),x)),And(FreeQ(List(a,b,d,e,f,ASymbol,BSymbol,CSymbol,n),x),NeQ(Plus(Sqr(a),Negate(Sqr(b))),C0)))),
ISetDelayed(7100,Int(Times(Plus(A_DEFAULT,Times(C_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Power(Times(d_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Plus(Negate(Dist(Times(a,CSymbol,Power(b,-2)),Int(Power(Times(d,Sin(Plus(e,Times(f,x)))),n),x),x)),Dist(Times(Plus(Times(ASymbol,Sqr(b)),Times(Sqr(a),CSymbol)),Power(b,-2)),Int(Times(Power(Times(d,Sin(Plus(e,Times(f,x)))),n),Power(Plus(a,Times(b,Sin(Plus(e,Times(f,x))))),-1)),x),x),Dist(Times(CSymbol,Power(Times(b,d),-1)),Int(Power(Times(d,Sin(Plus(e,Times(f,x)))),Plus(n,C1)),x),x)),And(FreeQ(List(a,b,d,e,f,ASymbol,CSymbol,n),x),NeQ(Plus(Sqr(a),Negate(Sqr(b))),C0)))),
ISetDelayed(7101,Int(Times(Plus(A_DEFAULT,Times(B_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),Times(C_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT),Power(Times(b_DEFAULT,Power($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),p_)),m_)),x_Symbol),
    Condition(Dist(Times(Power(Times(b,Power(Sin(Plus(e,Times(f,x))),p)),m),Power(Power(Times(b,Sin(Plus(e,Times(f,x)))),Times(m,p)),-1)),Int(Times(Power(Times(b,Sin(Plus(e,Times(f,x)))),Times(m,p)),Power(Plus(c,Times(d,Sin(Plus(e,Times(f,x))))),n),Plus(ASymbol,Times(BSymbol,Sin(Plus(e,Times(f,x)))),Times(CSymbol,Sqr(Sin(Plus(e,Times(f,x))))))),x),x),And(FreeQ(List(b,c,d,e,f,ASymbol,BSymbol,CSymbol,m,n,p),x),Not(IntegerQ(m))))),
ISetDelayed(7102,Int(Times(Plus(A_DEFAULT,Times(B_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),Times(C_DEFAULT,Sqr($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT),Power(Times(b_DEFAULT,Power($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),p_)),m_)),x_Symbol),
    Condition(Dist(Times(Power(Times(b,Power(Cos(Plus(e,Times(f,x))),p)),m),Power(Power(Times(b,Cos(Plus(e,Times(f,x)))),Times(m,p)),-1)),Int(Times(Power(Times(b,Cos(Plus(e,Times(f,x)))),Times(m,p)),Power(Plus(c,Times(d,Cos(Plus(e,Times(f,x))))),n),Plus(ASymbol,Times(BSymbol,Cos(Plus(e,Times(f,x)))),Times(CSymbol,Sqr(Cos(Plus(e,Times(f,x))))))),x),x),And(FreeQ(List(b,c,d,e,f,ASymbol,BSymbol,CSymbol,m,n,p),x),Not(IntegerQ(m))))),
ISetDelayed(7103,Int(Times(Plus(A_DEFAULT,Times(C_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT),Power(Times(b_DEFAULT,Power($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),p_)),m_)),x_Symbol),
    Condition(Dist(Times(Power(Times(b,Power(Sin(Plus(e,Times(f,x))),p)),m),Power(Power(Times(b,Sin(Plus(e,Times(f,x)))),Times(m,p)),-1)),Int(Times(Power(Times(b,Sin(Plus(e,Times(f,x)))),Times(m,p)),Power(Plus(c,Times(d,Sin(Plus(e,Times(f,x))))),n),Plus(ASymbol,Times(CSymbol,Sqr(Sin(Plus(e,Times(f,x))))))),x),x),And(FreeQ(List(b,c,d,e,f,ASymbol,CSymbol,m,n,p),x),Not(IntegerQ(m))))),
ISetDelayed(7104,Int(Times(Plus(A_DEFAULT,Times(C_DEFAULT,Sqr($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT),Power(Times(b_DEFAULT,Power($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),p_)),m_)),x_Symbol),
    Condition(Dist(Times(Power(Times(b,Power(Cos(Plus(e,Times(f,x))),p)),m),Power(Power(Times(b,Cos(Plus(e,Times(f,x)))),Times(m,p)),-1)),Int(Times(Power(Times(b,Cos(Plus(e,Times(f,x)))),Times(m,p)),Power(Plus(c,Times(d,Cos(Plus(e,Times(f,x))))),n),Plus(ASymbol,Times(CSymbol,Sqr(Cos(Plus(e,Times(f,x))))))),x),x),And(FreeQ(List(b,c,d,e,f,ASymbol,CSymbol,m,n,p),x),Not(IntegerQ(m))))),
ISetDelayed(7105,Int(Power(Plus(Times(a_DEFAULT,$($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_),x_Symbol),
    Condition(Simp(Times(a,Power(Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x))))),n),Power(Times(b,d,n),-1)),x),And(FreeQ(List(a,b,c,d,n),x),EqQ(Plus(Sqr(a),Sqr(b)),C0)))),
ISetDelayed(7106,Int(Power(Plus(Times(a_DEFAULT,$($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_),x_Symbol),
    Condition(Negate(Dist(Power(d,-1),Subst(Int(Power(Plus(Sqr(a),Sqr(b),Negate(Sqr(x))),Times(C1D2,Plus(n,Negate(C1)))),x),x,Plus(Times(b,Cos(Plus(c,Times(d,x)))),Times(CN1,a,Sin(Plus(c,Times(d,x)))))),x)),And(FreeQ(List(a,b,c,d),x),NeQ(Plus(Sqr(a),Sqr(b)),C0),IGtQ(Times(C1D2,Plus(n,Negate(C1))),C0)))),
ISetDelayed(7107,Int(Power(Plus(Times(a_DEFAULT,$($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Plus(Times(b,Cos(Plus(c,Times(d,x)))),Times(CN1,a,Sin(Plus(c,Times(d,x))))),Power(Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,Negate(C1))),Power(Times(d,n),-1)),x)),Dist(Times(Plus(n,Negate(C1)),Plus(Sqr(a),Sqr(b)),Power(n,-1)),Int(Power(Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,Negate(C2))),x),x)),And(FreeQ(List(a,b,c,d),x),NeQ(Plus(Sqr(a),Sqr(b)),C0),Not(IntegerQ(Times(C1D2,Plus(n,Negate(C1))))),GtQ(n,C1)))),
ISetDelayed(7108,Int(Power(Plus(Times(a_DEFAULT,$($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),-1),x_Symbol),
    Condition(Negate(Dist(Power(d,-1),Subst(Int(Power(Plus(Sqr(a),Sqr(b),Negate(Sqr(x))),-1),x),x,Plus(Times(b,Cos(Plus(c,Times(d,x)))),Times(CN1,a,Sin(Plus(c,Times(d,x)))))),x)),And(FreeQ(List(a,b,c,d),x),NeQ(Plus(Sqr(a),Sqr(b)),C0)))),
ISetDelayed(7109,Int(Power(Plus(Times(a_DEFAULT,$($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),-2),x_Symbol),
    Condition(Simp(Times(Sin(Plus(c,Times(d,x))),Power(Times(a,d,Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x)))))),-1)),x),And(FreeQ(List(a,b,c,d),x),NeQ(Plus(Sqr(a),Sqr(b)),C0)))),
ISetDelayed(7110,Int(Power(Plus(Times(a_DEFAULT,$($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_),x_Symbol),
    Condition(Plus(Simp(Times(Plus(Times(b,Cos(Plus(c,Times(d,x)))),Times(CN1,a,Sin(Plus(c,Times(d,x))))),Power(Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,C1)),Power(Times(d,Plus(n,C1),Plus(Sqr(a),Sqr(b))),-1)),x),Dist(Times(Plus(n,C2),Power(Times(Plus(n,C1),Plus(Sqr(a),Sqr(b))),-1)),Int(Power(Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,C2)),x),x)),And(FreeQ(List(a,b,c,d),x),NeQ(Plus(Sqr(a),Sqr(b)),C0),LtQ(n,CN1),NeQ(n,CN2)))),
ISetDelayed(7111,Int(Power(Plus(Times(a_DEFAULT,$($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_),x_Symbol),
    Condition(Dist(Power(Plus(Sqr(a),Sqr(b)),Times(C1D2,n)),Int(Power(Cos(Plus(c,Times(d,x),Negate(ArcTan(a,b)))),n),x),x),And(FreeQ(List(a,b,c,d,n),x),Not(Or(GeQ(n,C1),LeQ(n,CN1))),GtQ(Plus(Sqr(a),Sqr(b)),C0)))),
ISetDelayed(7112,Int(Power(Plus(Times(a_DEFAULT,$($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_),x_Symbol),
    Condition(Dist(Times(Power(Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x))))),n),Power(Power(Times(Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x))))),Power(Plus(Sqr(a),Sqr(b)),CN1D2)),n),-1)),Int(Power(Cos(Plus(c,Times(d,x),Negate(ArcTan(a,b)))),n),x),x),And(FreeQ(List(a,b,c,d,n),x),Not(Or(GeQ(n,C1),LeQ(n,CN1))),Not(Or(GtQ(Plus(Sqr(a),Sqr(b)),C0),EqQ(Plus(Sqr(a),Sqr(b)),C0)))))),
ISetDelayed(7113,Int(Times(Power($($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),m_),Power(Plus(Times(a_DEFAULT,$($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(a,Power(Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,Negate(C1))),Power(Times(d,Plus(n,Negate(C1)),Power(Sin(Plus(c,Times(d,x))),Plus(n,Negate(C1)))),-1)),x)),Dist(Times(C2,b),Int(Times(Power(Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,Negate(C1))),Power(Power(Sin(Plus(c,Times(d,x))),Plus(n,Negate(C1))),-1)),x),x)),And(FreeQ(List(a,b,c,d),x),EqQ(Plus(m,n),C0),EqQ(Plus(Sqr(a),Sqr(b)),C0),GtQ(n,C1)))),
ISetDelayed(7114,Int(Times(Power($($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),m_),Power(Plus(Times(a_DEFAULT,$($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Plus(Simp(Times(b,Power(Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,Negate(C1))),Power(Times(d,Plus(n,Negate(C1)),Power(Cos(Plus(c,Times(d,x))),Plus(n,Negate(C1)))),-1)),x),Dist(Times(C2,a),Int(Times(Power(Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,Negate(C1))),Power(Power(Cos(Plus(c,Times(d,x))),Plus(n,Negate(C1))),-1)),x),x)),And(FreeQ(List(a,b,c,d),x),EqQ(Plus(m,n),C0),EqQ(Plus(Sqr(a),Sqr(b)),C0),GtQ(n,C1)))),
ISetDelayed(7115,Int(Times(Power($($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),m_DEFAULT),Power(Plus(Times(a_DEFAULT,$($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Plus(Simp(Times(a,Power(Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x))))),n),Power(Times(C2,b,d,n,Power(Sin(Plus(c,Times(d,x))),n)),-1)),x),Dist(Power(Times(C2,b),-1),Int(Times(Power(Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,C1)),Power(Power(Sin(Plus(c,Times(d,x))),Plus(n,C1)),-1)),x),x)),And(FreeQ(List(a,b,c,d),x),EqQ(Plus(m,n),C0),EqQ(Plus(Sqr(a),Sqr(b)),C0),LtQ(n,C0)))),
ISetDelayed(7116,Int(Times(Power($($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),m_DEFAULT),Power(Plus(Times(a_DEFAULT,$($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(b,Power(Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x))))),n),Power(Times(C2,a,d,n,Power(Cos(Plus(c,Times(d,x))),n)),-1)),x)),Dist(Power(Times(C2,a),-1),Int(Times(Power(Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,C1)),Power(Power(Cos(Plus(c,Times(d,x))),Plus(n,C1)),-1)),x),x)),And(FreeQ(List(a,b,c,d),x),EqQ(Plus(m,n),C0),EqQ(Plus(Sqr(a),Sqr(b)),C0),LtQ(n,C0)))),
ISetDelayed(7117,Int(Times(Power($($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),m_DEFAULT),Power(Plus(Times(a_DEFAULT,$($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Simp(Times(a,Power(Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x))))),n),Hypergeometric2F1(C1,n,Plus(n,C1),Times(Plus(b,Times(a,Cot(Plus(c,Times(d,x))))),Power(Times(C2,b),-1))),Power(Times(C2,b,d,n,Power(Sin(Plus(c,Times(d,x))),n)),-1)),x),And(FreeQ(List(a,b,c,d,n),x),EqQ(Plus(m,n),C0),EqQ(Plus(Sqr(a),Sqr(b)),C0),Not(IntegerQ(n))))),
ISetDelayed(7118,Int(Times(Power($($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),m_DEFAULT),Power(Plus(Times(a_DEFAULT,$($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Negate(Simp(Times(b,Power(Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x))))),n),Hypergeometric2F1(C1,n,Plus(n,C1),Times(Plus(a,Times(b,Tan(Plus(c,Times(d,x))))),Power(Times(C2,a),-1))),Power(Times(C2,a,d,n,Power(Cos(Plus(c,Times(d,x))),n)),-1)),x)),And(FreeQ(List(a,b,c,d,n),x),EqQ(Plus(m,n),C0),EqQ(Plus(Sqr(a),Sqr(b)),C0),Not(IntegerQ(n))))),
ISetDelayed(7119,Int(Times(Power($($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),m_),Power(Plus(Times(a_DEFAULT,$($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_DEFAULT)),x_Symbol),
    Condition(Int(Power(Plus(b,Times(a,Cot(Plus(c,Times(d,x))))),n),x),And(FreeQ(List(a,b,c,d),x),EqQ(Plus(m,n),C0),IntegerQ(n),NeQ(Plus(Sqr(a),Sqr(b)),C0)))),
ISetDelayed(7120,Int(Times(Power($($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),m_),Power(Plus(Times(a_DEFAULT,$($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_DEFAULT)),x_Symbol),
    Condition(Int(Power(Plus(a,Times(b,Tan(Plus(c,Times(d,x))))),n),x),And(FreeQ(List(a,b,c,d),x),EqQ(Plus(m,n),C0),IntegerQ(n),NeQ(Plus(Sqr(a),Sqr(b)),C0)))),
ISetDelayed(7121,Int(Times(Power($($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),m_DEFAULT),Power(Plus(Times(a_DEFAULT,$($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Dist(Power(d,-1),Subst(Int(Times(Power(x,m),Power(Plus(a,Times(b,x)),n),Power(Power(Plus(C1,Sqr(x)),Times(C1D2,Plus(m,n,C2))),-1)),x),x,Tan(Plus(c,Times(d,x)))),x),And(FreeQ(List(a,b,c,d),x),IntegerQ(n),IntegerQ(Times(C1D2,Plus(m,n))),NeQ(n,CN1),Not(And(GtQ(n,C0),GtQ(m,C1)))))),
ISetDelayed(7122,Int(Times(Power($($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),m_DEFAULT),Power(Plus(Times(a_DEFAULT,$($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Negate(Dist(Power(d,-1),Subst(Int(Times(Power(x,m),Power(Plus(b,Times(a,x)),n),Power(Power(Plus(C1,Sqr(x)),Times(C1D2,Plus(m,n,C2))),-1)),x),x,Cot(Plus(c,Times(d,x)))),x)),And(FreeQ(List(a,b,c,d),x),IntegerQ(n),IntegerQ(Times(C1D2,Plus(m,n))),NeQ(n,CN1),Not(And(GtQ(n,C0),GtQ(m,C1)))))),
ISetDelayed(7123,Int(Times(Power($($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),m_DEFAULT),Power(Plus(Times(a_DEFAULT,$($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_DEFAULT)),x_Symbol),
    Condition(Int(ExpandTrig(Times(Power($($s("§sin"),Plus(c,Times(d,x))),m),Power(Plus(Times(a,$($s("§cos"),Plus(c,Times(d,x)))),Times(b,$($s("§sin"),Plus(c,Times(d,x))))),n)),x),x),And(FreeQ(List(a,b,c,d),x),IntegerQ(m),IGtQ(n,C0)))),
ISetDelayed(7124,Int(Times(Power($($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),m_DEFAULT),Power(Plus(Times(a_DEFAULT,$($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_DEFAULT)),x_Symbol),
    Condition(Int(ExpandTrig(Times(Power($($s("§cos"),Plus(c,Times(d,x))),m),Power(Plus(Times(a,$($s("§cos"),Plus(c,Times(d,x)))),Times(b,$($s("§sin"),Plus(c,Times(d,x))))),n)),x),x),And(FreeQ(List(a,b,c,d),x),IntegerQ(m),IGtQ(n,C0)))),
ISetDelayed(7125,Int(Times(Power($($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),m_DEFAULT),Power(Plus(Times(a_DEFAULT,$($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Dist(Times(Power(a,n),Power(b,n)),Int(Times(Power(Sin(Plus(c,Times(d,x))),m),Power(Power(Plus(Times(b,Cos(Plus(c,Times(d,x)))),Times(a,Sin(Plus(c,Times(d,x))))),n),-1)),x),x),And(FreeQ(List(a,b,c,d,m),x),EqQ(Plus(Sqr(a),Sqr(b)),C0),ILtQ(n,C0)))),
ISetDelayed(7126,Int(Times(Power($($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),m_DEFAULT),Power(Plus(Times(a_DEFAULT,$($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Dist(Times(Power(a,n),Power(b,n)),Int(Times(Power(Cos(Plus(c,Times(d,x))),m),Power(Power(Plus(Times(b,Cos(Plus(c,Times(d,x)))),Times(a,Sin(Plus(c,Times(d,x))))),n),-1)),x),x),And(FreeQ(List(a,b,c,d,m),x),EqQ(Plus(Sqr(a),Sqr(b)),C0),ILtQ(n,C0)))),
ISetDelayed(7127,Int(Times(Power($($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),-1),Power(Plus(Times(a_DEFAULT,$($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Power(Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,C1)),Power(Times(a,d,Plus(n,C1)),-1)),x)),Dist(Power(a,-2),Int(Times(Power(Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,C2)),Power(Sin(Plus(c,Times(d,x))),-1)),x),x),Negate(Dist(Times(b,Power(a,-2)),Int(Power(Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,C1)),x),x))),And(FreeQ(List(a,b,c,d),x),NeQ(Plus(Sqr(a),Sqr(b)),C0),LtQ(n,CN1)))),
ISetDelayed(7128,Int(Times(Power($($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),-1),Power(Plus(Times(a_DEFAULT,$($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,C1)),Power(Times(b,d,Plus(n,C1)),-1)),x),Dist(Power(b,-2),Int(Times(Power(Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,C2)),Power(Cos(Plus(c,Times(d,x))),-1)),x),x),Negate(Dist(Times(a,Power(b,-2)),Int(Power(Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,C1)),x),x))),And(FreeQ(List(a,b,c,d),x),NeQ(Plus(Sqr(a),Sqr(b)),C0),LtQ(n,CN1)))),
ISetDelayed(7129,Int(Times(Power($($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),m_),Power(Plus(Times(a_DEFAULT,$($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Plus(Negate(Dist(Plus(Sqr(a),Sqr(b)),Int(Times(Power(Sin(Plus(c,Times(d,x))),Plus(m,C2)),Power(Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,Negate(C2)))),x),x)),Dist(Sqr(a),Int(Times(Power(Sin(Plus(c,Times(d,x))),m),Power(Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,Negate(C2)))),x),x),Dist(Times(C2,b),Int(Times(Power(Sin(Plus(c,Times(d,x))),Plus(m,C1)),Power(Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,Negate(C1)))),x),x)),And(FreeQ(List(a,b,c,d),x),NeQ(Plus(Sqr(a),Sqr(b)),C0),GtQ(n,C1),LtQ(m,CN1)))),
ISetDelayed(7130,Int(Times(Power($($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),m_),Power(Plus(Times(a_DEFAULT,$($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Plus(Negate(Dist(Plus(Sqr(a),Sqr(b)),Int(Times(Power(Cos(Plus(c,Times(d,x))),Plus(m,C2)),Power(Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,Negate(C2)))),x),x)),Dist(Times(C2,a),Int(Times(Power(Cos(Plus(c,Times(d,x))),Plus(m,C1)),Power(Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,Negate(C1)))),x),x),Dist(Sqr(b),Int(Times(Power(Cos(Plus(c,Times(d,x))),m),Power(Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x))))),Plus(n,Negate(C2)))),x),x)),And(FreeQ(List(a,b,c,d),x),NeQ(Plus(Sqr(a),Sqr(b)),C0),GtQ(n,C1),LtQ(m,CN1)))),
ISetDelayed(7131,Int(Times($($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),Power(Plus(Times(a_DEFAULT,$($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Plus(Simp(Times(b,x,Power(Plus(Sqr(a),Sqr(b)),-1)),x),Negate(Dist(Times(a,Power(Plus(Sqr(a),Sqr(b)),-1)),Int(Times(Plus(Times(b,Cos(Plus(c,Times(d,x)))),Times(CN1,a,Sin(Plus(c,Times(d,x))))),Power(Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d),x),NeQ(Plus(Sqr(a),Sqr(b)),C0)))),
ISetDelayed(7132,Int(Times($($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),Power(Plus(Times(a_DEFAULT,$($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Plus(Simp(Times(a,x,Power(Plus(Sqr(a),Sqr(b)),-1)),x),Dist(Times(b,Power(Plus(Sqr(a),Sqr(b)),-1)),Int(Times(Plus(Times(b,Cos(Plus(c,Times(d,x)))),Times(CN1,a,Sin(Plus(c,Times(d,x))))),Power(Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d),x),NeQ(Plus(Sqr(a),Sqr(b)),C0)))),
ISetDelayed(7133,Int(Times(Power($($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),m_),Power(Plus(Times(a_DEFAULT,$($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(a,Power(Sin(Plus(c,Times(d,x))),Plus(m,Negate(C1))),Power(Times(d,Plus(Sqr(a),Sqr(b)),Plus(m,Negate(C1))),-1)),x)),Dist(Times(Sqr(a),Power(Plus(Sqr(a),Sqr(b)),-1)),Int(Times(Power(Sin(Plus(c,Times(d,x))),Plus(m,Negate(C2))),Power(Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x))))),-1)),x),x),Dist(Times(b,Power(Plus(Sqr(a),Sqr(b)),-1)),Int(Power(Sin(Plus(c,Times(d,x))),Plus(m,Negate(C1))),x),x)),And(FreeQ(List(a,b,c,d),x),NeQ(Plus(Sqr(a),Sqr(b)),C0),GtQ(m,C1)))),
ISetDelayed(7134,Int(Times(Power($($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),m_),Power(Plus(Times(a_DEFAULT,$($s("§cos"),Plus(c_DEFAULT,Times(d_DEFAULT,x_)))),Times(b_DEFAULT,$($s("§sin"),Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Plus(Simp(Times(b,Power(Cos(Plus(c,Times(d,x))),Plus(m,Negate(C1))),Power(Times(d,Plus(Sqr(a),Sqr(b)),Plus(m,Negate(C1))),-1)),x),Dist(Times(a,Power(Plus(Sqr(a),Sqr(b)),-1)),Int(Power(Cos(Plus(c,Times(d,x))),Plus(m,Negate(C1))),x),x),Dist(Times(Sqr(b),Power(Plus(Sqr(a),Sqr(b)),-1)),Int(Times(Power(Cos(Plus(c,Times(d,x))),Plus(m,Negate(C2))),Power(Plus(Times(a,Cos(Plus(c,Times(d,x)))),Times(b,Sin(Plus(c,Times(d,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d),x),NeQ(Plus(Sqr(a),Sqr(b)),C0),GtQ(m,C1))))
  );
}
