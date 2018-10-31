package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.ASymbol;
import static org.matheclipse.core.expression.F.A_DEFAULT;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.BSymbol;
import static org.matheclipse.core.expression.F.B_DEFAULT;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.C8;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.CSymbol;
import static org.matheclipse.core.expression.F.C_DEFAULT;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Cot;
import static org.matheclipse.core.expression.F.Csc;
import static org.matheclipse.core.expression.F.EllipticE;
import static org.matheclipse.core.expression.F.EllipticF;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.QQ;
import static org.matheclipse.core.expression.F.Sec;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Tan;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.With;
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
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ActivateTrig;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FreeFactors;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/** 
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class IntRules63 { 
  public static IAST RULES = List( 
IIntegrate(3151,Int(Times(Power(Plus(a_DEFAULT,Times($($s("§cos"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),b_DEFAULT),Times(c_DEFAULT,$($s("§sin"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))))),-2),Plus(A_DEFAULT,Times(C_DEFAULT,$($s("§sin"),Plus(d_DEFAULT,Times(e_DEFAULT,x_)))))),x_Symbol),
    Condition(Negate(Simp(Times(Plus(Times(b,CSymbol),Times(Plus(Times(a,CSymbol),Times(CN1,c,ASymbol)),Cos(Plus(d,Times(e,x)))),Times(b,ASymbol,Sin(Plus(d,Times(e,x))))),Power(Times(e,Plus(Sqr(a),Negate(Sqr(b)),Negate(Sqr(c))),Plus(a,Times(b,Cos(Plus(d,Times(e,x)))),Times(c,Sin(Plus(d,Times(e,x)))))),-1)),x)),And(FreeQ(List(a,b,c,d,e,ASymbol,CSymbol),x),NeQ(Plus(Sqr(a),Negate(Sqr(b)),Negate(Sqr(c))),C0),EqQ(Plus(Times(a,ASymbol),Times(CN1,c,CSymbol)),C0)))),
IIntegrate(3152,Int(Times(Plus(A_DEFAULT,Times($($s("§cos"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),B_DEFAULT)),Power(Plus(a_DEFAULT,Times($($s("§cos"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),b_DEFAULT),Times(c_DEFAULT,$($s("§sin"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))))),-2)),x_Symbol),
    Condition(Simp(Times(Plus(Times(c,BSymbol),Times(c,ASymbol,Cos(Plus(d,Times(e,x)))),Times(Plus(Times(a,BSymbol),Times(CN1,b,ASymbol)),Sin(Plus(d,Times(e,x))))),Power(Times(e,Plus(Sqr(a),Negate(Sqr(b)),Negate(Sqr(c))),Plus(a,Times(b,Cos(Plus(d,Times(e,x)))),Times(c,Sin(Plus(d,Times(e,x)))))),-1)),x),And(FreeQ(List(a,b,c,d,e,ASymbol,BSymbol),x),NeQ(Plus(Sqr(a),Negate(Sqr(b)),Negate(Sqr(c))),C0),EqQ(Plus(Times(a,ASymbol),Times(CN1,b,BSymbol)),C0)))),
IIntegrate(3153,Int(Times(Power(Plus(a_DEFAULT,Times($($s("§cos"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),b_DEFAULT),Times(c_DEFAULT,$($s("§sin"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))))),-2),Plus(A_DEFAULT,Times($($s("§cos"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),B_DEFAULT),Times(C_DEFAULT,$($s("§sin"),Plus(d_DEFAULT,Times(e_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(Plus(Times(c,BSymbol),Times(CN1,b,CSymbol),Times(CN1,Plus(Times(a,CSymbol),Times(CN1,c,ASymbol)),Cos(Plus(d,Times(e,x)))),Times(Plus(Times(a,BSymbol),Times(CN1,b,ASymbol)),Sin(Plus(d,Times(e,x))))),Power(Times(e,Plus(Sqr(a),Negate(Sqr(b)),Negate(Sqr(c))),Plus(a,Times(b,Cos(Plus(d,Times(e,x)))),Times(c,Sin(Plus(d,Times(e,x)))))),-1)),x),Dist(Times(Plus(Times(a,ASymbol),Times(CN1,b,BSymbol),Times(CN1,c,CSymbol)),Power(Plus(Sqr(a),Negate(Sqr(b)),Negate(Sqr(c))),-1)),Int(Power(Plus(a,Times(b,Cos(Plus(d,Times(e,x)))),Times(c,Sin(Plus(d,Times(e,x))))),-1),x),x)),And(FreeQ(List(a,b,c,d,e,ASymbol,BSymbol,CSymbol),x),NeQ(Plus(Sqr(a),Negate(Sqr(b)),Negate(Sqr(c))),C0),NeQ(Plus(Times(a,ASymbol),Times(CN1,b,BSymbol),Times(CN1,c,CSymbol)),C0)))),
IIntegrate(3154,Int(Times(Power(Plus(a_DEFAULT,Times($($s("§cos"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),b_DEFAULT),Times(c_DEFAULT,$($s("§sin"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))))),-2),Plus(A_DEFAULT,Times(C_DEFAULT,$($s("§sin"),Plus(d_DEFAULT,Times(e_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Plus(Times(b,CSymbol),Times(Plus(Times(a,CSymbol),Times(CN1,c,ASymbol)),Cos(Plus(d,Times(e,x)))),Times(b,ASymbol,Sin(Plus(d,Times(e,x))))),Power(Times(e,Plus(Sqr(a),Negate(Sqr(b)),Negate(Sqr(c))),Plus(a,Times(b,Cos(Plus(d,Times(e,x)))),Times(c,Sin(Plus(d,Times(e,x)))))),-1)),x)),Dist(Times(Plus(Times(a,ASymbol),Times(CN1,c,CSymbol)),Power(Plus(Sqr(a),Negate(Sqr(b)),Negate(Sqr(c))),-1)),Int(Power(Plus(a,Times(b,Cos(Plus(d,Times(e,x)))),Times(c,Sin(Plus(d,Times(e,x))))),-1),x),x)),And(FreeQ(List(a,b,c,d,e,ASymbol,CSymbol),x),NeQ(Plus(Sqr(a),Negate(Sqr(b)),Negate(Sqr(c))),C0),NeQ(Plus(Times(a,ASymbol),Times(CN1,c,CSymbol)),C0)))),
IIntegrate(3155,Int(Times(Plus(A_DEFAULT,Times($($s("§cos"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),B_DEFAULT)),Power(Plus(a_DEFAULT,Times($($s("§cos"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),b_DEFAULT),Times(c_DEFAULT,$($s("§sin"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))))),-2)),x_Symbol),
    Condition(Plus(Simp(Times(Plus(Times(c,BSymbol),Times(c,ASymbol,Cos(Plus(d,Times(e,x)))),Times(Plus(Times(a,BSymbol),Times(CN1,b,ASymbol)),Sin(Plus(d,Times(e,x))))),Power(Times(e,Plus(Sqr(a),Negate(Sqr(b)),Negate(Sqr(c))),Plus(a,Times(b,Cos(Plus(d,Times(e,x)))),Times(c,Sin(Plus(d,Times(e,x)))))),-1)),x),Dist(Times(Plus(Times(a,ASymbol),Times(CN1,b,BSymbol)),Power(Plus(Sqr(a),Negate(Sqr(b)),Negate(Sqr(c))),-1)),Int(Power(Plus(a,Times(b,Cos(Plus(d,Times(e,x)))),Times(c,Sin(Plus(d,Times(e,x))))),-1),x),x)),And(FreeQ(List(a,b,c,d,e,ASymbol,BSymbol),x),NeQ(Plus(Sqr(a),Negate(Sqr(b)),Negate(Sqr(c))),C0),NeQ(Plus(Times(a,ASymbol),Times(CN1,b,BSymbol)),C0)))),
IIntegrate(3156,Int(Times(Power(Plus(a_DEFAULT,Times($($s("§cos"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),b_DEFAULT),Times(c_DEFAULT,$($s("§sin"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))))),n_),Plus(A_DEFAULT,Times($($s("§cos"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),B_DEFAULT),Times(C_DEFAULT,$($s("§sin"),Plus(d_DEFAULT,Times(e_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Plus(Times(c,BSymbol),Times(CN1,b,CSymbol),Times(CN1,Plus(Times(a,CSymbol),Times(CN1,c,ASymbol)),Cos(Plus(d,Times(e,x)))),Times(Plus(Times(a,BSymbol),Times(CN1,b,ASymbol)),Sin(Plus(d,Times(e,x))))),Power(Plus(a,Times(b,Cos(Plus(d,Times(e,x)))),Times(c,Sin(Plus(d,Times(e,x))))),Plus(n,C1)),Power(Times(e,Plus(n,C1),Plus(Sqr(a),Negate(Sqr(b)),Negate(Sqr(c)))),-1)),x)),Dist(Power(Times(Plus(n,C1),Plus(Sqr(a),Negate(Sqr(b)),Negate(Sqr(c)))),-1),Int(Times(Power(Plus(a,Times(b,Cos(Plus(d,Times(e,x)))),Times(c,Sin(Plus(d,Times(e,x))))),Plus(n,C1)),Simp(Plus(Times(Plus(n,C1),Plus(Times(a,ASymbol),Times(CN1,b,BSymbol),Times(CN1,c,CSymbol))),Times(Plus(n,C2),Plus(Times(a,BSymbol),Times(CN1,b,ASymbol)),Cos(Plus(d,Times(e,x)))),Times(Plus(n,C2),Plus(Times(a,CSymbol),Times(CN1,c,ASymbol)),Sin(Plus(d,Times(e,x))))),x)),x),x)),And(FreeQ(List(a,b,c,d,e,ASymbol,BSymbol,CSymbol),x),LtQ(n,CN1),NeQ(Plus(Sqr(a),Negate(Sqr(b)),Negate(Sqr(c))),C0),NeQ(n,CN2)))),
IIntegrate(3157,Int(Times(Power(Plus(a_DEFAULT,Times($($s("§cos"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),b_DEFAULT),Times(c_DEFAULT,$($s("§sin"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))))),n_),Plus(A_DEFAULT,Times(C_DEFAULT,$($s("§sin"),Plus(d_DEFAULT,Times(e_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(Plus(Times(b,CSymbol),Times(Plus(Times(a,CSymbol),Times(CN1,c,ASymbol)),Cos(Plus(d,Times(e,x)))),Times(b,ASymbol,Sin(Plus(d,Times(e,x))))),Power(Plus(a,Times(b,Cos(Plus(d,Times(e,x)))),Times(c,Sin(Plus(d,Times(e,x))))),Plus(n,C1)),Power(Times(e,Plus(n,C1),Plus(Sqr(a),Negate(Sqr(b)),Negate(Sqr(c)))),-1)),x),Dist(Power(Times(Plus(n,C1),Plus(Sqr(a),Negate(Sqr(b)),Negate(Sqr(c)))),-1),Int(Times(Power(Plus(a,Times(b,Cos(Plus(d,Times(e,x)))),Times(c,Sin(Plus(d,Times(e,x))))),Plus(n,C1)),Simp(Plus(Times(Plus(n,C1),Plus(Times(a,ASymbol),Times(CN1,c,CSymbol))),Times(CN1,Plus(n,C2),b,ASymbol,Cos(Plus(d,Times(e,x)))),Times(Plus(n,C2),Plus(Times(a,CSymbol),Times(CN1,c,ASymbol)),Sin(Plus(d,Times(e,x))))),x)),x),x)),And(FreeQ(List(a,b,c,d,e,ASymbol,CSymbol),x),LtQ(n,CN1),NeQ(Plus(Sqr(a),Negate(Sqr(b)),Negate(Sqr(c))),C0),NeQ(n,CN2)))),
IIntegrate(3158,Int(Times(Plus(A_DEFAULT,Times($($s("§cos"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),B_DEFAULT)),Power(Plus(a_DEFAULT,Times($($s("§cos"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),b_DEFAULT),Times(c_DEFAULT,$($s("§sin"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Plus(Times(c,BSymbol),Times(c,ASymbol,Cos(Plus(d,Times(e,x)))),Times(Plus(Times(a,BSymbol),Times(CN1,b,ASymbol)),Sin(Plus(d,Times(e,x))))),Power(Plus(a,Times(b,Cos(Plus(d,Times(e,x)))),Times(c,Sin(Plus(d,Times(e,x))))),Plus(n,C1)),Power(Times(e,Plus(n,C1),Plus(Sqr(a),Negate(Sqr(b)),Negate(Sqr(c)))),-1)),x)),Dist(Power(Times(Plus(n,C1),Plus(Sqr(a),Negate(Sqr(b)),Negate(Sqr(c)))),-1),Int(Times(Power(Plus(a,Times(b,Cos(Plus(d,Times(e,x)))),Times(c,Sin(Plus(d,Times(e,x))))),Plus(n,C1)),Simp(Plus(Times(Plus(n,C1),Plus(Times(a,ASymbol),Times(CN1,b,BSymbol))),Times(Plus(n,C2),Plus(Times(a,BSymbol),Times(CN1,b,ASymbol)),Cos(Plus(d,Times(e,x)))),Times(CN1,Plus(n,C2),c,ASymbol,Sin(Plus(d,Times(e,x))))),x)),x),x)),And(FreeQ(List(a,b,c,d,e,ASymbol,BSymbol),x),LtQ(n,CN1),NeQ(Plus(Sqr(a),Negate(Sqr(b)),Negate(Sqr(c))),C0),NeQ(n,CN2)))),
IIntegrate(3159,Int(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_)))),Times(c_DEFAULT,$($s("§tan"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))))),-1),x_Symbol),
    Condition(Int(Times(Cos(Plus(d,Times(e,x))),Power(Plus(b,Times(a,Cos(Plus(d,Times(e,x)))),Times(c,Sin(Plus(d,Times(e,x))))),-1)),x),FreeQ(List(a,b,c,d,e),x))),
IIntegrate(3160,Int(Power(Plus(a_DEFAULT,Times($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),b_DEFAULT),Times($($s("§cot"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),c_DEFAULT)),-1),x_Symbol),
    Condition(Int(Times(Sin(Plus(d,Times(e,x))),Power(Plus(b,Times(a,Sin(Plus(d,Times(e,x)))),Times(c,Cos(Plus(d,Times(e,x))))),-1)),x),FreeQ(List(a,b,c,d,e),x))),
IIntegrate(3161,Int(Times(Power($($s("§cos"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),n_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_)))),Times(c_DEFAULT,$($s("§tan"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))))),n_DEFAULT)),x_Symbol),
    Condition(Int(Power(Plus(b,Times(a,Cos(Plus(d,Times(e,x)))),Times(c,Sin(Plus(d,Times(e,x))))),n),x),And(FreeQ(List(a,b,c,d,e),x),IntegerQ(n)))),
IIntegrate(3162,Int(Times(Power(Plus(a_DEFAULT,Times($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),b_DEFAULT),Times($($s("§cot"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),c_DEFAULT)),n_DEFAULT),Power($($s("§sin"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),n_DEFAULT)),x_Symbol),
    Condition(Int(Power(Plus(b,Times(a,Sin(Plus(d,Times(e,x)))),Times(c,Cos(Plus(d,Times(e,x))))),n),x),And(FreeQ(List(a,b,c,d,e),x),IntegerQ(n)))),
IIntegrate(3163,Int(Times(Power($($s("§cos"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),n_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_)))),Times(c_DEFAULT,$($s("§tan"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(Dist(Times(Power(Cos(Plus(d,Times(e,x))),n),Power(Plus(a,Times(b,Sec(Plus(d,Times(e,x)))),Times(c,Tan(Plus(d,Times(e,x))))),n),Power(Power(Plus(b,Times(a,Cos(Plus(d,Times(e,x)))),Times(c,Sin(Plus(d,Times(e,x))))),n),-1)),Int(Power(Plus(b,Times(a,Cos(Plus(d,Times(e,x)))),Times(c,Sin(Plus(d,Times(e,x))))),n),x),x),And(FreeQ(List(a,b,c,d,e),x),Not(IntegerQ(n))))),
IIntegrate(3164,Int(Times(Power(Plus(a_DEFAULT,Times($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),b_DEFAULT),Times($($s("§cot"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),c_DEFAULT)),n_),Power($($s("§sin"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),n_)),x_Symbol),
    Condition(Dist(Times(Power(Sin(Plus(d,Times(e,x))),n),Power(Plus(a,Times(b,Csc(Plus(d,Times(e,x)))),Times(c,Cot(Plus(d,Times(e,x))))),n),Power(Power(Plus(b,Times(a,Sin(Plus(d,Times(e,x)))),Times(c,Cos(Plus(d,Times(e,x))))),n),-1)),Int(Power(Plus(b,Times(a,Sin(Plus(d,Times(e,x)))),Times(c,Cos(Plus(d,Times(e,x))))),n),x),x),And(FreeQ(List(a,b,c,d,e),x),Not(IntegerQ(n))))),
IIntegrate(3165,Int(Times(Power($($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),n_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_)))),Times(c_DEFAULT,$($s("§tan"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))))),m_)),x_Symbol),
    Condition(Int(Power(Power(Plus(b,Times(a,Cos(Plus(d,Times(e,x)))),Times(c,Sin(Plus(d,Times(e,x))))),n),-1),x),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(m,n),C0),IntegerQ(n)))),
IIntegrate(3166,Int(Times(Power($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),n_DEFAULT),Power(Plus(a_DEFAULT,Times($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),b_DEFAULT),Times($($s("§cot"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),c_DEFAULT)),m_)),x_Symbol),
    Condition(Int(Power(Power(Plus(b,Times(a,Sin(Plus(d,Times(e,x)))),Times(c,Cos(Plus(d,Times(e,x))))),n),-1),x),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(m,n),C0),IntegerQ(n)))),
IIntegrate(3167,Int(Times(Power($($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),n_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_)))),Times(c_DEFAULT,$($s("§tan"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))))),m_)),x_Symbol),
    Condition(Dist(Times(Power(Sec(Plus(d,Times(e,x))),n),Power(Plus(b,Times(a,Cos(Plus(d,Times(e,x)))),Times(c,Sin(Plus(d,Times(e,x))))),n),Power(Power(Plus(a,Times(b,Sec(Plus(d,Times(e,x)))),Times(c,Tan(Plus(d,Times(e,x))))),n),-1)),Int(Power(Power(Plus(b,Times(a,Cos(Plus(d,Times(e,x)))),Times(c,Sin(Plus(d,Times(e,x))))),n),-1),x),x),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(m,n),C0),Not(IntegerQ(n))))),
IIntegrate(3168,Int(Times(Power($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),n_DEFAULT),Power(Plus(a_DEFAULT,Times($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),b_DEFAULT),Times($($s("§cot"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),c_DEFAULT)),m_)),x_Symbol),
    Condition(Dist(Times(Power(Csc(Plus(d,Times(e,x))),n),Power(Plus(b,Times(a,Sin(Plus(d,Times(e,x)))),Times(c,Cos(Plus(d,Times(e,x))))),n),Power(Power(Plus(a,Times(b,Csc(Plus(d,Times(e,x)))),Times(c,Cot(Plus(d,Times(e,x))))),n),-1)),Int(Power(Power(Plus(b,Times(a,Sin(Plus(d,Times(e,x)))),Times(c,Cos(Plus(d,Times(e,x))))),n),-1),x),x),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(m,n),C0),Not(IntegerQ(n))))),
IIntegrate(3169,Int(Times(Plus(a_,Times(b_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Plus(A_DEFAULT,Times(B_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Simp(Times(QQ(1L,8L),Plus(Times(C4,ASymbol,Plus(Times(C2,a),b)),Times(BSymbol,Plus(Times(C4,a),Times(C3,b)))),x),x),Negate(Simp(Times(b,BSymbol,Cos(Plus(e,Times(f,x))),Power(Sin(Plus(e,Times(f,x))),3),Power(Times(C4,f),-1)),x)),Negate(Simp(Times(Plus(Times(C4,ASymbol,b),Times(BSymbol,Plus(Times(C4,a),Times(C3,b)))),Cos(Plus(e,Times(f,x))),Sin(Plus(e,Times(f,x))),Power(Times(C8,f),-1)),x))),FreeQ(List(a,b,e,f,ASymbol,BSymbol),x))),
IIntegrate(3170,Int(Times(Power(Plus(a_,Times(b_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),p_),Plus(A_DEFAULT,Times(B_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Negate(Simp(Times(BSymbol,Cos(Plus(e,Times(f,x))),Sin(Plus(e,Times(f,x))),Power(Plus(a,Times(b,Sqr(Sin(Plus(e,Times(f,x)))))),p),Power(Times(C2,f,Plus(p,C1)),-1)),x)),Dist(Power(Times(C2,Plus(p,C1)),-1),Int(Times(Power(Plus(a,Times(b,Sqr(Sin(Plus(e,Times(f,x)))))),Plus(p,Negate(C1))),Simp(Plus(Times(a,BSymbol),Times(C2,a,ASymbol,Plus(p,C1)),Times(Plus(Times(C2,ASymbol,b,Plus(p,C1)),Times(BSymbol,Plus(b,Times(C2,a,p),Times(C2,b,p)))),Sqr(Sin(Plus(e,Times(f,x)))))),x)),x),x)),And(FreeQ(List(a,b,e,f,ASymbol,BSymbol),x),GtQ(p,C0)))),
IIntegrate(3171,Int(Times(Power(Plus(a_,Times(b_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),-1),Plus(A_DEFAULT,Times(B_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Simp(Times(BSymbol,x,Power(b,-1)),x),Dist(Times(Plus(Times(ASymbol,b),Times(CN1,a,BSymbol)),Power(b,-1)),Int(Power(Plus(a,Times(b,Sqr(Sin(Plus(e,Times(f,x)))))),-1),x),x)),FreeQ(List(a,b,e,f,ASymbol,BSymbol),x))),
IIntegrate(3172,Int(Times(Power(Plus(a_,Times(b_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),CN1D2),Plus(A_DEFAULT,Times(B_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Dist(Times(BSymbol,Power(b,-1)),Int(Sqrt(Plus(a,Times(b,Sqr(Sin(Plus(e,Times(f,x))))))),x),x),Dist(Times(Plus(Times(ASymbol,b),Times(CN1,a,BSymbol)),Power(b,-1)),Int(Power(Plus(a,Times(b,Sqr(Sin(Plus(e,Times(f,x)))))),CN1D2),x),x)),FreeQ(List(a,b,e,f,ASymbol,BSymbol),x))),
IIntegrate(3173,Int(Times(Power(Plus(a_,Times(b_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),p_),Plus(A_DEFAULT,Times(B_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Plus(Times(ASymbol,b),Times(CN1,a,BSymbol)),Cos(Plus(e,Times(f,x))),Sin(Plus(e,Times(f,x))),Power(Plus(a,Times(b,Sqr(Sin(Plus(e,Times(f,x)))))),Plus(p,C1)),Power(Times(C2,a,f,Plus(a,b),Plus(p,C1)),-1)),x)),Negate(Dist(Power(Times(C2,a,Plus(a,b),Plus(p,C1)),-1),Int(Times(Power(Plus(a,Times(b,Sqr(Sin(Plus(e,Times(f,x)))))),Plus(p,C1)),Simp(Plus(Times(a,BSymbol),Times(CN1,ASymbol,Plus(Times(C2,a,Plus(p,C1)),Times(b,Plus(Times(C2,p),C3)))),Times(C2,Plus(Times(ASymbol,b),Times(CN1,a,BSymbol)),Plus(p,C2),Sqr(Sin(Plus(e,Times(f,x)))))),x)),x),x))),And(FreeQ(List(a,b,e,f,ASymbol,BSymbol),x),LtQ(p,CN1),NeQ(Plus(a,b),C0)))),
IIntegrate(3174,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),p_),Plus(A_DEFAULT,Times(B_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),x_Symbol),
    Condition(With(List(Set($s("ff"),FreeFactors(Tan(Plus(e,Times(f,x))),x))),Dist(Times($s("ff"),Power(Plus(a,Times(b,Sqr(Sin(Plus(e,Times(f,x)))))),p),Power(Sqr(Sec(Plus(e,Times(f,x)))),p),Power(Times(f,Power(Plus(a,Times(Plus(a,b),Sqr(Tan(Plus(e,Times(f,x)))))),p)),-1)),Subst(Int(Times(Power(Plus(a,Times(Plus(a,b),Sqr($s("ff")),Sqr(x))),p),Plus(ASymbol,Times(Plus(ASymbol,BSymbol),Sqr($s("ff")),Sqr(x))),Power(Power(Plus(C1,Times(Sqr($s("ff")),Sqr(x))),Plus(p,C2)),-1)),x),x,Times(Tan(Plus(e,Times(f,x))),Power($s("ff"),-1))),x)),And(FreeQ(List(a,b,e,f,ASymbol,BSymbol),x),Not(IntegerQ(p))))),
IIntegrate(3175,Int(Times(u_DEFAULT,Power(Plus(a_,Times(b_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),p_)),x_Symbol),
    Condition(Dist(Power(a,p),Int(ActivateTrig(Times(u,Power($($s("§cos"),Plus(e,Times(f,x))),Times(C2,p)))),x),x),And(FreeQ(List(a,b,e,f,p),x),EqQ(Plus(a,b),C0),IntegerQ(p)))),
IIntegrate(3176,Int(Times(u_DEFAULT,Power(Plus(a_,Times(b_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),p_)),x_Symbol),
    Condition(Int(ActivateTrig(Times(u,Power(Times(a,Sqr($($s("§cos"),Plus(e,Times(f,x))))),p))),x),And(FreeQ(List(a,b,e,f,p),x),EqQ(Plus(a,b),C0)))),
IIntegrate(3177,Int(Sqrt(Plus(a_,Times(b_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),x_Symbol),
    Condition(Simp(Times(Sqrt(a),EllipticE(Plus(e,Times(f,x)),Times(CN1,b,Power(a,-1))),Power(f,-1)),x),And(FreeQ(List(a,b,e,f),x),GtQ(a,C0)))),
IIntegrate(3178,Int(Sqrt(Plus(a_,Times(b_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),x_Symbol),
    Condition(Dist(Times(Sqrt(Plus(a,Times(b,Sqr(Sin(Plus(e,Times(f,x))))))),Power(Plus(C1,Times(b,Sqr(Sin(Plus(e,Times(f,x)))),Power(a,-1))),CN1D2)),Int(Sqrt(Plus(C1,Times(b,Sqr(Sin(Plus(e,Times(f,x)))),Power(a,-1)))),x),x),And(FreeQ(List(a,b,e,f),x),Not(GtQ(a,C0))))),
IIntegrate(3179,Int(Sqr(Plus(a_,Times(b_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Simp(Times(QQ(1L,8L),Plus(Times(C8,Sqr(a)),Times(C8,a,b),Times(C3,Sqr(b))),x),x),Negate(Simp(Times(Sqr(b),Cos(Plus(e,Times(f,x))),Power(Sin(Plus(e,Times(f,x))),3),Power(Times(C4,f),-1)),x)),Negate(Simp(Times(b,Plus(Times(C8,a),Times(C3,b)),Cos(Plus(e,Times(f,x))),Sin(Plus(e,Times(f,x))),Power(Times(C8,f),-1)),x))),FreeQ(List(a,b,e,f),x))),
IIntegrate(3180,Int(Power(Plus(a_,Times(b_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),p_),x_Symbol),
    Condition(Plus(Negate(Simp(Times(b,Cos(Plus(e,Times(f,x))),Sin(Plus(e,Times(f,x))),Power(Plus(a,Times(b,Sqr(Sin(Plus(e,Times(f,x)))))),Plus(p,Negate(C1))),Power(Times(C2,f,p),-1)),x)),Dist(Power(Times(C2,p),-1),Int(Times(Power(Plus(a,Times(b,Sqr(Sin(Plus(e,Times(f,x)))))),Plus(p,Negate(C2))),Simp(Plus(Times(a,Plus(b,Times(C2,a,p))),Times(b,Plus(Times(C2,a),b),Plus(Times(C2,p),Negate(C1)),Sqr(Sin(Plus(e,Times(f,x)))))),x)),x),x)),And(FreeQ(List(a,b,e,f),x),NeQ(Plus(a,b),C0),GtQ(p,C1)))),
IIntegrate(3181,Int(Power(Plus(a_,Times(b_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),-1),x_Symbol),
    Condition(With(List(Set($s("ff"),FreeFactors(Tan(Plus(e,Times(f,x))),x))),Dist(Times($s("ff"),Power(f,-1)),Subst(Int(Power(Plus(a,Times(Plus(a,b),Sqr($s("ff")),Sqr(x))),-1),x),x,Times(Tan(Plus(e,Times(f,x))),Power($s("ff"),-1))),x)),FreeQ(List(a,b,e,f),x))),
IIntegrate(3182,Int(Power(Plus(a_,Times(b_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),CN1D2),x_Symbol),
    Condition(Simp(Times(C1,EllipticF(Plus(e,Times(f,x)),Times(CN1,b,Power(a,-1))),Power(Times(Sqrt(a),f),-1)),x),And(FreeQ(List(a,b,e,f),x),GtQ(a,C0)))),
IIntegrate(3183,Int(Power(Plus(a_,Times(b_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),CN1D2),x_Symbol),
    Condition(Dist(Times(Sqrt(Plus(C1,Times(b,Sqr(Sin(Plus(e,Times(f,x)))),Power(a,-1)))),Power(Plus(a,Times(b,Sqr(Sin(Plus(e,Times(f,x)))))),CN1D2)),Int(Power(Plus(C1,Times(b,Sqr(Sin(Plus(e,Times(f,x)))),Power(a,-1))),CN1D2),x),x),And(FreeQ(List(a,b,e,f),x),Not(GtQ(a,C0))))),
IIntegrate(3184,Int(Power(Plus(a_,Times(b_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),p_),x_Symbol),
    Condition(Plus(Negate(Simp(Times(b,Cos(Plus(e,Times(f,x))),Sin(Plus(e,Times(f,x))),Power(Plus(a,Times(b,Sqr(Sin(Plus(e,Times(f,x)))))),Plus(p,C1)),Power(Times(C2,a,f,Plus(p,C1),Plus(a,b)),-1)),x)),Dist(Power(Times(C2,a,Plus(p,C1),Plus(a,b)),-1),Int(Times(Power(Plus(a,Times(b,Sqr(Sin(Plus(e,Times(f,x)))))),Plus(p,C1)),Simp(Plus(Times(C2,a,Plus(p,C1)),Times(b,Plus(Times(C2,p),C3)),Times(CN1,C2,b,Plus(p,C2),Sqr(Sin(Plus(e,Times(f,x)))))),x)),x),x)),And(FreeQ(List(a,b,e,f),x),NeQ(Plus(a,b),C0),LtQ(p,CN1)))),
IIntegrate(3185,Int(Power(Plus(a_,Times(b_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),p_DEFAULT),x_Symbol),
    Condition(With(List(Set($s("ff"),FreeFactors(Sin(Plus(e,Times(f,x))),x))),Dist(Times($s("ff"),Sqrt(Sqr(Cos(Plus(e,Times(f,x))))),Power(Times(f,Cos(Plus(e,Times(f,x)))),-1)),Subst(Int(Times(Power(Plus(a,Times(b,Sqr($s("ff")),Sqr(x))),p),Power(Plus(C1,Times(CN1,Sqr($s("ff")),Sqr(x))),CN1D2)),x),x,Times(Sin(Plus(e,Times(f,x))),Power($s("ff"),-1))),x)),And(FreeQ(List(a,b,e,f,p),x),Not(IntegerQ(p))))),
IIntegrate(3186,Int(Times(Power($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),p_DEFAULT)),x_Symbol),
    Condition(With(List(Set($s("ff"),FreeFactors(Cos(Plus(e,Times(f,x))),x))),Negate(Dist(Times($s("ff"),Power(f,-1)),Subst(Int(Times(Power(Plus(C1,Times(CN1,Sqr($s("ff")),Sqr(x))),Times(C1D2,Plus(m,Negate(C1)))),Power(Plus(a,b,Times(CN1,b,Sqr($s("ff")),Sqr(x))),p)),x),x,Times(Cos(Plus(e,Times(f,x))),Power($s("ff"),-1))),x))),And(FreeQ(List(a,b,e,f,p),x),IntegerQ(Times(C1D2,Plus(m,Negate(C1))))))),
IIntegrate(3187,Int(Times(Power($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),m_),Power(Plus(a_,Times(b_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),p_DEFAULT)),x_Symbol),
    Condition(With(List(Set($s("ff"),FreeFactors(Tan(Plus(e,Times(f,x))),x))),Dist(Times(Power($s("ff"),Plus(m,C1)),Power(f,-1)),Subst(Int(Times(Power(x,m),Power(Plus(a,Times(Plus(a,b),Sqr($s("ff")),Sqr(x))),p),Power(Power(Plus(C1,Times(Sqr($s("ff")),Sqr(x))),Plus(Times(C1D2,m),p,C1)),-1)),x),x,Times(Tan(Plus(e,Times(f,x))),Power($s("ff"),-1))),x)),And(FreeQ(List(a,b,e,f),x),IntegerQ(Times(C1D2,m)),IntegerQ(p)))),
IIntegrate(3188,Int(Times(Power($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),m_),Power(Plus(a_,Times(b_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),p_DEFAULT)),x_Symbol),
    Condition(With(List(Set($s("ff"),FreeFactors(Sin(Plus(e,Times(f,x))),x))),Dist(Times(Power($s("ff"),Plus(m,C1)),Sqrt(Sqr(Cos(Plus(e,Times(f,x))))),Power(Times(f,Cos(Plus(e,Times(f,x)))),-1)),Subst(Int(Times(Power(x,m),Power(Plus(a,Times(b,Sqr($s("ff")),Sqr(x))),p),Power(Plus(C1,Times(CN1,Sqr($s("ff")),Sqr(x))),CN1D2)),x),x,Times(Sin(Plus(e,Times(f,x))),Power($s("ff"),-1))),x)),And(FreeQ(List(a,b,e,f,p),x),IntegerQ(Times(C1D2,m)),Not(IntegerQ(p))))),
IIntegrate(3189,Int(Times(Power(Times(d_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_),Power(Plus(a_,Times(b_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),p_DEFAULT)),x_Symbol),
    Condition(With(List(Set($s("ff"),FreeFactors(Cos(Plus(e,Times(f,x))),x))),Negate(Dist(Times($s("ff"),Power(d,Plus(Times(C2,IntPart(Times(C1D2,Plus(m,Negate(C1))))),C1)),Power(Times(d,Sin(Plus(e,Times(f,x)))),Times(C2,FracPart(Times(C1D2,Plus(m,Negate(C1)))))),Power(Times(f,Power(Sqr(Sin(Plus(e,Times(f,x)))),FracPart(Times(C1D2,Plus(m,Negate(C1)))))),-1)),Subst(Int(Times(Power(Plus(C1,Times(CN1,Sqr($s("ff")),Sqr(x))),Times(C1D2,Plus(m,Negate(C1)))),Power(Plus(a,b,Times(CN1,b,Sqr($s("ff")),Sqr(x))),p)),x),x,Times(Cos(Plus(e,Times(f,x))),Power($s("ff"),-1))),x))),And(FreeQ(List(a,b,d,e,f,m,p),x),Not(IntegerQ(m))))),
IIntegrate(3190,Int(Times(Power($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),p_DEFAULT)),x_Symbol),
    Condition(With(List(Set($s("ff"),FreeFactors(Sin(Plus(e,Times(f,x))),x))),Dist(Times($s("ff"),Power(f,-1)),Subst(Int(Times(Power(Plus(C1,Times(CN1,Sqr($s("ff")),Sqr(x))),Times(C1D2,Plus(m,Negate(C1)))),Power(Plus(a,Times(b,Sqr($s("ff")),Sqr(x))),p)),x),x,Times(Sin(Plus(e,Times(f,x))),Power($s("ff"),-1))),x)),And(FreeQ(List(a,b,e,f,p),x),IntegerQ(Times(C1D2,Plus(m,Negate(C1))))))),
IIntegrate(3191,Int(Times(Power($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),m_),Power(Plus(a_,Times(b_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),p_DEFAULT)),x_Symbol),
    Condition(With(List(Set($s("ff"),FreeFactors(Tan(Plus(e,Times(f,x))),x))),Dist(Times($s("ff"),Power(f,-1)),Subst(Int(Times(Power(Plus(a,Times(Plus(a,b),Sqr($s("ff")),Sqr(x))),p),Power(Power(Plus(C1,Times(Sqr($s("ff")),Sqr(x))),Plus(Times(C1D2,m),p,C1)),-1)),x),x,Times(Tan(Plus(e,Times(f,x))),Power($s("ff"),-1))),x)),And(FreeQ(List(a,b,e,f),x),IntegerQ(Times(C1D2,m)),IntegerQ(p)))),
IIntegrate(3192,Int(Times(Power($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),m_),Power(Plus(a_,Times(b_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),p_DEFAULT)),x_Symbol),
    Condition(With(List(Set($s("ff"),FreeFactors(Sin(Plus(e,Times(f,x))),x))),Dist(Times($s("ff"),Sqrt(Sqr(Cos(Plus(e,Times(f,x))))),Power(Times(f,Cos(Plus(e,Times(f,x)))),-1)),Subst(Int(Times(Power(Plus(C1,Times(CN1,Sqr($s("ff")),Sqr(x))),Times(C1D2,Plus(m,Negate(C1)))),Power(Plus(a,Times(b,Sqr($s("ff")),Sqr(x))),p)),x),x,Times(Sin(Plus(e,Times(f,x))),Power($s("ff"),-1))),x)),And(FreeQ(List(a,b,e,f,p),x),IntegerQ(Times(C1D2,m)),Not(IntegerQ(p))))),
IIntegrate(3193,Int(Times(Power(Times($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),d_DEFAULT),m_),Power(Plus(a_,Times(b_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),p_DEFAULT)),x_Symbol),
    Condition(With(List(Set($s("ff"),FreeFactors(Sin(Plus(e,Times(f,x))),x))),Dist(Times($s("ff"),Power(d,Plus(Times(C2,IntPart(Times(C1D2,Plus(m,Negate(C1))))),C1)),Power(Times(d,Cos(Plus(e,Times(f,x)))),Times(C2,FracPart(Times(C1D2,Plus(m,Negate(C1)))))),Power(Times(f,Power(Sqr(Cos(Plus(e,Times(f,x)))),FracPart(Times(C1D2,Plus(m,Negate(C1)))))),-1)),Subst(Int(Times(Power(Plus(C1,Times(CN1,Sqr($s("ff")),Sqr(x))),Times(C1D2,Plus(m,Negate(C1)))),Power(Plus(a,Times(b,Sqr($s("ff")),Sqr(x))),p)),x),x,Times(Sin(Plus(e,Times(f,x))),Power($s("ff"),-1))),x)),And(FreeQ(List(a,b,d,e,f,m,p),x),Not(IntegerQ(m))))),
IIntegrate(3194,Int(Times(Power(Plus(a_,Times(b_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),p_DEFAULT),Power($($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),m_DEFAULT)),x_Symbol),
    Condition(With(List(Set($s("ff"),FreeFactors(Sqr(Sin(Plus(e,Times(f,x)))),x))),Dist(Times(Power($s("ff"),Times(C1D2,Plus(m,C1))),Power(Times(C2,f),-1)),Subst(Int(Times(Power(x,Times(C1D2,Plus(m,Negate(C1)))),Power(Plus(a,Times(b,$s("ff"),x)),p),Power(Power(Plus(C1,Times(CN1,$s("ff"),x)),Times(C1D2,Plus(m,C1))),-1)),x),x,Times(Sqr(Sin(Plus(e,Times(f,x)))),Power($s("ff"),-1))),x)),And(FreeQ(List(a,b,e,f,p),x),IntegerQ(Times(C1D2,Plus(m,Negate(C1))))))),
IIntegrate(3195,Int(Times(Power(Plus(a_,Times(b_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),p_DEFAULT),Power(Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_)),x_Symbol),
    Condition(With(List(Set($s("ff"),FreeFactors(Tan(Plus(e,Times(f,x))),x))),Dist(Times($s("ff"),Power(f,-1)),Subst(Int(Times(Power(Times(d,$s("ff"),x),m),Power(Plus(a,Times(Plus(a,b),Sqr($s("ff")),Sqr(x))),p),Power(Power(Plus(C1,Times(Sqr($s("ff")),Sqr(x))),Plus(p,C1)),-1)),x),x,Times(Tan(Plus(e,Times(f,x))),Power($s("ff"),-1))),x)),And(FreeQ(List(a,b,d,e,f,m),x),IntegerQ(p)))),
IIntegrate(3196,Int(Times(Power(Plus(a_,Times(b_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),p_DEFAULT),Power($($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),m_)),x_Symbol),
    Condition(With(List(Set($s("ff"),FreeFactors(Sin(Plus(e,Times(f,x))),x))),Dist(Times(Power($s("ff"),Plus(m,C1)),Sqrt(Sqr(Cos(Plus(e,Times(f,x))))),Power(Times(f,Cos(Plus(e,Times(f,x)))),-1)),Subst(Int(Times(Power(x,m),Power(Plus(a,Times(b,Sqr($s("ff")),Sqr(x))),p),Power(Power(Plus(C1,Times(CN1,Sqr($s("ff")),Sqr(x))),Times(C1D2,Plus(m,C1))),-1)),x),x,Times(Sin(Plus(e,Times(f,x))),Power($s("ff"),-1))),x)),And(FreeQ(List(a,b,e,f,p),x),IntegerQ(Times(C1D2,m)),Not(IntegerQ(p))))),
IIntegrate(3197,Int(Times(Power(Plus(a_,Times(b_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),p_DEFAULT),Power(Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_)),x_Symbol),
    Condition(With(List(Set($s("ff"),FreeFactors(Sin(Plus(e,Times(f,x))),x))),Dist(Times($s("ff"),Power(Times(d,Tan(Plus(e,Times(f,x)))),Plus(m,C1)),Power(Sqr(Cos(Plus(e,Times(f,x)))),Times(C1D2,Plus(m,C1))),Power(Times(d,f,Power(Sin(Plus(e,Times(f,x))),Plus(m,C1))),-1)),Subst(Int(Times(Power(Times($s("ff"),x),m),Power(Plus(a,Times(b,Sqr($s("ff")),Sqr(x))),p),Power(Power(Plus(C1,Times(CN1,Sqr($s("ff")),Sqr(x))),Times(C1D2,Plus(m,C1))),-1)),x),x,Times(Sin(Plus(e,Times(f,x))),Power($s("ff"),-1))),x)),And(FreeQ(List(a,b,d,e,f,m,p),x),Not(IntegerQ(m))))),
IIntegrate(3198,Int(Times(Power($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),m_DEFAULT),Power(Times(d_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),p_DEFAULT)),x_Symbol),
    Condition(With(List(Set($s("ff"),FreeFactors(Sin(Plus(e,Times(f,x))),x))),Dist(Times($s("ff"),Power(f,-1)),Subst(Int(Times(Power(Times(d,$s("ff"),x),n),Power(Plus(C1,Times(CN1,Sqr($s("ff")),Sqr(x))),Times(C1D2,Plus(m,Negate(C1)))),Power(Plus(a,Times(b,Sqr($s("ff")),Sqr(x))),p)),x),x,Times(Sin(Plus(e,Times(f,x))),Power($s("ff"),-1))),x)),And(FreeQ(List(a,b,d,e,f,n,p),x),IntegerQ(Times(C1D2,Plus(m,Negate(C1))))))),
IIntegrate(3199,Int(Times(Power($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),n_DEFAULT),Power(Times(c_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_),Power(Plus(a_,Times(b_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),p_DEFAULT)),x_Symbol),
    Condition(With(List(Set($s("ff"),FreeFactors(Cos(Plus(e,Times(f,x))),x))),Negate(Dist(Times($s("ff"),Power(f,-1)),Subst(Int(Times(Power(Times(c,$s("ff"),x),m),Power(Plus(C1,Times(CN1,Sqr($s("ff")),Sqr(x))),Times(C1D2,Plus(n,Negate(C1)))),Power(Plus(a,b,Times(CN1,b,Sqr($s("ff")),Sqr(x))),p)),x),x,Times(Cos(Plus(e,Times(f,x))),Power($s("ff"),-1))),x))),And(FreeQ(List(a,b,c,e,f,m,p),x),IntegerQ(Times(C1D2,Plus(n,Negate(C1))))))),
IIntegrate(3200,Int(Times(Power($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),m_),Power($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),n_),Power(Plus(a_,Times(b_DEFAULT,Sqr($($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),p_DEFAULT)),x_Symbol),
    Condition(With(List(Set($s("ff"),FreeFactors(Tan(Plus(e,Times(f,x))),x))),Dist(Times(Power($s("ff"),Plus(n,C1)),Power(f,-1)),Subst(Int(Times(Power(x,n),Power(Plus(a,Times(Plus(a,b),Sqr($s("ff")),Sqr(x))),p),Power(Power(Plus(C1,Times(Sqr($s("ff")),Sqr(x))),Plus(Times(C1D2,Plus(m,n)),p,C1)),-1)),x),x,Times(Tan(Plus(e,Times(f,x))),Power($s("ff"),-1))),x)),And(FreeQ(List(a,b,e,f),x),IntegerQ(Times(C1D2,m)),IntegerQ(Times(C1D2,n)),IntegerQ(p))))
  );
}
