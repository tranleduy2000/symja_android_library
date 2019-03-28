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
public class IntRules101 { 

	public static void initialize() {
		Initializer.init();
	}

	private static class Initializer  {

		private static void init() {
IIntegrate(5051,Int(Times(ArcTan(Plus(a_,Times(b_DEFAULT,x_))),Power(Plus(c_,Times(d_DEFAULT,Power(x_,n_DEFAULT))),-1)),x_Symbol),
    Condition(Plus(Dist(Times(C1D2,CI),Int(Times(Log(Plus(C1,Times(CN1,CI,a),Times(CN1,CI,b,x))),Power(Plus(c,Times(d,Power(x,n))),-1)),x),x),Negate(Dist(Times(C1D2,CI),Int(Times(Log(Plus(C1,Times(CI,a),Times(CI,b,x))),Power(Plus(c,Times(d,Power(x,n))),-1)),x),x))),And(FreeQ(List(a,b,c,d),x),RationalQ(n))));
IIntegrate(5052,Int(Times(ArcCot(Plus(a_,Times(b_DEFAULT,x_))),Power(Plus(c_,Times(d_DEFAULT,Power(x_,n_DEFAULT))),-1)),x_Symbol),
    Condition(Plus(Dist(Times(C1D2,CI),Int(Times(Log(Times(Plus(Negate(CI),a,Times(b,x)),Power(Plus(a,Times(b,x)),-1))),Power(Plus(c,Times(d,Power(x,n))),-1)),x),x),Negate(Dist(Times(C1D2,CI),Int(Times(Log(Times(Plus(CI,a,Times(b,x)),Power(Plus(a,Times(b,x)),-1))),Power(Plus(c,Times(d,Power(x,n))),-1)),x),x))),And(FreeQ(List(a,b,c,d),x),RationalQ(n))));
IIntegrate(5053,Int(Times(ArcTan(Plus(a_,Times(b_DEFAULT,x_))),Power(Plus(c_,Times(d_DEFAULT,Power(x_,n_))),-1)),x_Symbol),
    Condition(Unintegrable(Times(ArcTan(Plus(a,Times(b,x))),Power(Plus(c,Times(d,Power(x,n))),-1)),x),And(FreeQ(List(a,b,c,d,n),x),Not(RationalQ(n)))));
IIntegrate(5054,Int(Times(ArcCot(Plus(a_,Times(b_DEFAULT,x_))),Power(Plus(c_,Times(d_DEFAULT,Power(x_,n_))),-1)),x_Symbol),
    Condition(Unintegrable(Times(ArcCot(Plus(a,Times(b,x))),Power(Plus(c,Times(d,Power(x,n))),-1)),x),And(FreeQ(List(a,b,c,d,n),x),Not(RationalQ(n)))));
IIntegrate(5055,Int(Times(Power(Plus(a_DEFAULT,Times(ArcTan(Plus(c_,Times(d_DEFAULT,x_))),b_DEFAULT)),p_DEFAULT),Power(Plus(A_DEFAULT,Times(B_DEFAULT,x_),Times(C_DEFAULT,Sqr(x_))),q_DEFAULT)),x_Symbol),
    Condition(Dist(Power(d,-1),Subst(Int(Times(Power(Plus(Times(CSymbol,Power(d,-2)),Times(CSymbol,Sqr(x),Power(d,-2))),q),Power(Plus(a,Times(b,ArcTan(x))),p)),x),x,Plus(c,Times(d,x))),x),And(FreeQ(List(a,b,c,d,ASymbol,BSymbol,CSymbol,p,q),x),EqQ(Plus(Times(BSymbol,Plus(C1,Sqr(c))),Times(CN1,C2,ASymbol,c,d)),C0),EqQ(Plus(Times(C2,c,CSymbol),Times(CN1,BSymbol,d)),C0))));
IIntegrate(5056,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCot(Plus(c_,Times(d_DEFAULT,x_))),b_DEFAULT)),p_DEFAULT),Power(Plus(A_DEFAULT,Times(B_DEFAULT,x_),Times(C_DEFAULT,Sqr(x_))),q_DEFAULT)),x_Symbol),
    Condition(Dist(Power(d,-1),Subst(Int(Times(Power(Plus(Times(CSymbol,Power(d,-2)),Times(CSymbol,Sqr(x),Power(d,-2))),q),Power(Plus(a,Times(b,ArcCot(x))),p)),x),x,Plus(c,Times(d,x))),x),And(FreeQ(List(a,b,c,d,ASymbol,BSymbol,CSymbol,p,q),x),EqQ(Plus(Times(BSymbol,Plus(C1,Sqr(c))),Times(CN1,C2,ASymbol,c,d)),C0),EqQ(Plus(Times(C2,c,CSymbol),Times(CN1,BSymbol,d)),C0))));
IIntegrate(5057,Int(Times(Power(Plus(a_DEFAULT,Times(ArcTan(Plus(c_,Times(d_DEFAULT,x_))),b_DEFAULT)),p_DEFAULT),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Plus(A_DEFAULT,Times(B_DEFAULT,x_),Times(C_DEFAULT,Sqr(x_))),q_DEFAULT)),x_Symbol),
    Condition(Dist(Power(d,-1),Subst(Int(Times(Power(Plus(Times(Plus(Times(d,e),Times(CN1,c,f)),Power(d,-1)),Times(f,x,Power(d,-1))),m),Power(Plus(Times(CSymbol,Power(d,-2)),Times(CSymbol,Sqr(x),Power(d,-2))),q),Power(Plus(a,Times(b,ArcTan(x))),p)),x),x,Plus(c,Times(d,x))),x),And(FreeQ(List(a,b,c,d,e,f,ASymbol,BSymbol,CSymbol,m,p,q),x),EqQ(Plus(Times(BSymbol,Plus(C1,Sqr(c))),Times(CN1,C2,ASymbol,c,d)),C0),EqQ(Plus(Times(C2,c,CSymbol),Times(CN1,BSymbol,d)),C0))));
IIntegrate(5058,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCot(Plus(c_,Times(d_DEFAULT,x_))),b_DEFAULT)),p_DEFAULT),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Plus(A_DEFAULT,Times(B_DEFAULT,x_),Times(C_DEFAULT,Sqr(x_))),q_DEFAULT)),x_Symbol),
    Condition(Dist(Power(d,-1),Subst(Int(Times(Power(Plus(Times(Plus(Times(d,e),Times(CN1,c,f)),Power(d,-1)),Times(f,x,Power(d,-1))),m),Power(Plus(Times(CSymbol,Power(d,-2)),Times(CSymbol,Sqr(x),Power(d,-2))),q),Power(Plus(a,Times(b,ArcCot(x))),p)),x),x,Plus(c,Times(d,x))),x),And(FreeQ(List(a,b,c,d,e,f,ASymbol,BSymbol,CSymbol,m,p,q),x),EqQ(Plus(Times(BSymbol,Plus(C1,Sqr(c))),Times(CN1,C2,ASymbol,c,d)),C0),EqQ(Plus(Times(C2,c,CSymbol),Times(CN1,BSymbol,d)),C0))));
IIntegrate(5059,Int(Exp(Times(ArcTan(Times(a_DEFAULT,x_)),n_)),x_Symbol),
    Condition(Int(Times(Power(Plus(C1,Times(CN1,CI,a,x)),Times(C1D2,Plus(Times(CI,n),C1))),Power(Times(Power(Plus(C1,Times(CI,a,x)),Times(C1D2,Plus(Times(CI,n),Negate(C1)))),Sqrt(Plus(C1,Times(Sqr(a),Sqr(x))))),-1)),x),And(FreeQ(a,x),IntegerQ(Times(C1D2,Plus(Times(CI,n),Negate(C1)))))));
IIntegrate(5060,Int(Times(Exp(Times(ArcTan(Times(a_DEFAULT,x_)),n_)),Power(x_,m_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(x,m),Power(Plus(C1,Times(CN1,CI,a,x)),Times(C1D2,Plus(Times(CI,n),C1))),Power(Times(Power(Plus(C1,Times(CI,a,x)),Times(C1D2,Plus(Times(CI,n),Negate(C1)))),Sqrt(Plus(C1,Times(Sqr(a),Sqr(x))))),-1)),x),And(FreeQ(List(a,m),x),IntegerQ(Times(C1D2,Plus(Times(CI,n),Negate(C1)))))));
IIntegrate(5061,Int(Exp(Times(ArcTan(Times(a_DEFAULT,x_)),n_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(Plus(C1,Times(CN1,CI,a,x)),Times(C1D2,CI,n)),Power(Power(Plus(C1,Times(CI,a,x)),Times(C1D2,CI,n)),-1)),x),And(FreeQ(List(a,n),x),Not(IntegerQ(Times(C1D2,Plus(Times(CI,n),Negate(C1))))))));
IIntegrate(5062,Int(Times(Exp(Times(ArcTan(Times(a_DEFAULT,x_)),n_DEFAULT)),Power(x_,m_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(x,m),Power(Plus(C1,Times(CN1,CI,a,x)),Times(C1D2,CI,n)),Power(Power(Plus(C1,Times(CI,a,x)),Times(C1D2,CI,n)),-1)),x),And(FreeQ(List(a,m,n),x),Not(IntegerQ(Times(C1D2,Plus(Times(CI,n),Negate(C1))))))));
IIntegrate(5063,Int(Times(Exp(Times(ArcTan(Times(a_DEFAULT,x_)),n_DEFAULT)),u_DEFAULT,Power(Plus(c_,Times(d_DEFAULT,x_)),p_DEFAULT)),x_Symbol),
    Condition(Dist(Power(c,p),Int(Times(u,Power(Plus(C1,Times(d,x,Power(c,-1))),p),Power(Plus(C1,Times(CN1,CI,a,x)),Times(C1D2,CI,n)),Power(Power(Plus(C1,Times(CI,a,x)),Times(C1D2,CI,n)),-1)),x),x),And(FreeQ(List(a,c,d,n,p),x),EqQ(Plus(Times(Sqr(a),Sqr(c)),Sqr(d)),C0),Or(IntegerQ(p),GtQ(c,C0)))));
IIntegrate(5064,Int(Times(Exp(Times(ArcTan(Times(a_DEFAULT,x_)),n_DEFAULT)),u_DEFAULT,Power(Plus(c_,Times(d_DEFAULT,x_)),p_DEFAULT)),x_Symbol),
    Condition(Int(Times(u,Power(Plus(c,Times(d,x)),p),Power(Plus(C1,Times(CN1,CI,a,x)),Times(C1D2,CI,n)),Power(Power(Plus(C1,Times(CI,a,x)),Times(C1D2,CI,n)),-1)),x),And(FreeQ(List(a,c,d,n,p),x),EqQ(Plus(Times(Sqr(a),Sqr(c)),Sqr(d)),C0),Not(Or(IntegerQ(p),GtQ(c,C0))))));
IIntegrate(5065,Int(Times(Exp(Times(ArcTan(Times(a_DEFAULT,x_)),n_DEFAULT)),u_DEFAULT,Power(Plus(c_,Times(d_DEFAULT,Power(x_,-1))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Power(d,p),Int(Times(u,Power(Plus(C1,Times(c,x,Power(d,-1))),p),Exp(Times(n,ArcTan(Times(a,x)))),Power(Power(x,p),-1)),x),x),And(FreeQ(List(a,c,d,n),x),EqQ(Plus(Sqr(c),Times(Sqr(a),Sqr(d))),C0),IntegerQ(p))));
IIntegrate(5066,Int(Times(Exp(Times(ArcTanh(Times(a_DEFAULT,x_)),n_)),u_DEFAULT,Power(Plus(c_,Times(d_DEFAULT,Power(x_,-1))),p_)),x_Symbol),
    Condition(Dist(Times(Power(CN1,Times(C1D2,n)),Power(c,p)),Int(Times(u,Power(Plus(C1,Times(d,Power(Times(c,x),-1))),p),Power(Plus(C1,Negate(Power(Times(CI,a,x),-1))),Times(C1D2,CI,n)),Power(Power(Plus(C1,Power(Times(CI,a,x),-1)),Times(C1D2,CI,n)),-1)),x),x),And(FreeQ(List(a,c,d,p),x),EqQ(Plus(Sqr(c),Times(Sqr(a),Sqr(d))),C0),Not(IntegerQ(p)),IntegerQ(Times(C1D2,CI,n)),GtQ(c,C0))));
IIntegrate(5067,Int(Times(Exp(Times(ArcTan(Times(a_DEFAULT,x_)),n_)),u_DEFAULT,Power(Plus(c_,Times(d_DEFAULT,Power(x_,-1))),p_)),x_Symbol),
    Condition(Int(Times(u,Power(Plus(c,Times(d,Power(x,-1))),p),Power(Plus(C1,Times(CN1,CI,a,x)),Times(C1D2,CI,n)),Power(Power(Plus(C1,Times(CI,a,x)),Times(C1D2,CI,n)),-1)),x),And(FreeQ(List(a,c,d,p),x),EqQ(Plus(Sqr(c),Times(Sqr(a),Sqr(d))),C0),Not(IntegerQ(p)),IntegerQ(Times(C1D2,CI,n)),Not(GtQ(c,C0)))));
IIntegrate(5068,Int(Times(Exp(Times(ArcTan(Times(a_DEFAULT,x_)),n_DEFAULT)),u_DEFAULT,Power(Plus(c_,Times(d_DEFAULT,Power(x_,-1))),p_)),x_Symbol),
    Condition(Dist(Times(Power(x,p),Power(Plus(c,Times(d,Power(x,-1))),p),Power(Power(Plus(C1,Times(c,x,Power(d,-1))),p),-1)),Int(Times(u,Power(Plus(C1,Times(c,x,Power(d,-1))),p),Exp(Times(n,ArcTan(Times(a,x)))),Power(Power(x,p),-1)),x),x),And(FreeQ(List(a,c,d,n,p),x),EqQ(Plus(Sqr(c),Times(Sqr(a),Sqr(d))),C0),Not(IntegerQ(p)))));
IIntegrate(5069,Int(Times(Exp(Times(ArcTan(Times(a_DEFAULT,x_)),n_DEFAULT)),Power(Plus(c_,Times(d_DEFAULT,Sqr(x_))),QQ(-3L,2L))),x_Symbol),
    Condition(Simp(Times(Plus(n,Times(a,x)),Exp(Times(n,ArcTan(Times(a,x)))),Power(Times(a,c,Plus(Sqr(n),C1),Sqrt(Plus(c,Times(d,Sqr(x))))),-1)),x),And(FreeQ(List(a,c,d,n),x),EqQ(d,Times(Sqr(a),c)),Not(IntegerQ(Times(CI,n))))));
IIntegrate(5070,Int(Times(Exp(Times(ArcTan(Times(a_DEFAULT,x_)),n_DEFAULT)),Power(Plus(c_,Times(d_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Plus(n,Times(CN1,C2,a,Plus(p,C1),x)),Power(Plus(c,Times(d,Sqr(x))),Plus(p,C1)),Exp(Times(n,ArcTan(Times(a,x)))),Power(Times(a,c,Plus(Sqr(n),Times(C4,Sqr(Plus(p,C1))))),-1)),x),Dist(Times(C2,Plus(p,C1),Plus(Times(C2,p),C3),Power(Times(c,Plus(Sqr(n),Times(C4,Sqr(Plus(p,C1))))),-1)),Int(Times(Power(Plus(c,Times(d,Sqr(x))),Plus(p,C1)),Exp(Times(n,ArcTan(Times(a,x))))),x),x)),And(FreeQ(List(a,c,d,n),x),EqQ(d,Times(Sqr(a),c)),LtQ(p,CN1),Not(IntegerQ(Times(CI,n))),NeQ(Plus(Sqr(n),Times(C4,Sqr(Plus(p,C1)))),C0),IntegerQ(Times(C2,p)))));
IIntegrate(5071,Int(Times(Exp(Times(ArcTan(Times(a_DEFAULT,x_)),n_DEFAULT)),Power(Plus(c_,Times(d_DEFAULT,Sqr(x_))),-1)),x_Symbol),
    Condition(Simp(Times(Exp(Times(n,ArcTan(Times(a,x)))),Power(Times(a,c,n),-1)),x),And(FreeQ(List(a,c,d,n),x),EqQ(d,Times(Sqr(a),c)))));
IIntegrate(5072,Int(Times(Exp(Times(ArcTan(Times(a_DEFAULT,x_)),n_)),Power(Plus(c_,Times(d_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Power(c,p),Int(Times(Power(Plus(C1,Times(Sqr(a),Sqr(x))),Plus(p,Times(CN1,C1D2,CI,n))),Power(Plus(C1,Times(CN1,CI,a,x)),Times(CI,n))),x),x),And(FreeQ(List(a,c,d,p),x),EqQ(d,Times(Sqr(a),c)),IntegerQ(p),IntegerQ(Times(C1D2,Plus(Times(CI,n),C1))),Not(IntegerQ(Plus(p,Times(CN1,C1D2,CI,n)))))));
IIntegrate(5073,Int(Times(Exp(Times(ArcTan(Times(a_DEFAULT,x_)),n_DEFAULT)),Power(Plus(c_,Times(d_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Power(c,p),Int(Times(Power(Plus(C1,Times(CN1,CI,a,x)),Plus(p,Times(C1D2,CI,n))),Power(Plus(C1,Times(CI,a,x)),Plus(p,Times(CN1,C1D2,CI,n)))),x),x),And(FreeQ(List(a,c,d,n,p),x),EqQ(d,Times(Sqr(a),c)),Or(IntegerQ(p),GtQ(c,C0)))));
IIntegrate(5074,Int(Times(Exp(Times(ArcTan(Times(a_DEFAULT,x_)),n_)),Power(Plus(c_,Times(d_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Dist(Power(c,Times(C1D2,CI,n)),Int(Times(Power(Plus(c,Times(d,Sqr(x))),Plus(p,Times(CN1,C1D2,CI,n))),Power(Plus(C1,Times(CN1,CI,a,x)),Times(CI,n))),x),x),And(FreeQ(List(a,c,d,p),x),EqQ(d,Times(Sqr(a),c)),Not(Or(IntegerQ(p),GtQ(c,C0))),IGtQ(Times(C1D2,CI,n),C0))));
IIntegrate(5075,Int(Times(Exp(Times(ArcTan(Times(a_DEFAULT,x_)),n_)),Power(Plus(c_,Times(d_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Dist(Power(Power(c,Times(C1D2,CI,n)),-1),Int(Times(Power(Plus(c,Times(d,Sqr(x))),Plus(p,Times(C1D2,CI,n))),Power(Power(Plus(C1,Times(CI,a,x)),Times(CI,n)),-1)),x),x),And(FreeQ(List(a,c,d,p),x),EqQ(d,Times(Sqr(a),c)),Not(Or(IntegerQ(p),GtQ(c,C0))),ILtQ(Times(C1D2,CI,n),C0))));
IIntegrate(5076,Int(Times(Exp(Times(ArcTan(Times(a_DEFAULT,x_)),n_DEFAULT)),Power(Plus(c_,Times(d_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Dist(Times(Power(c,IntPart(p)),Power(Plus(c,Times(d,Sqr(x))),FracPart(p)),Power(Power(Plus(C1,Times(Sqr(a),Sqr(x))),FracPart(p)),-1)),Int(Times(Power(Plus(C1,Times(Sqr(a),Sqr(x))),p),Exp(Times(n,ArcTan(Times(a,x))))),x),x),And(FreeQ(List(a,c,d,n,p),x),EqQ(d,Times(Sqr(a),c)),Not(Or(IntegerQ(p),GtQ(c,C0))))));
IIntegrate(5077,Int(Times(Exp(Times(ArcTan(Times(a_DEFAULT,x_)),n_DEFAULT)),x_,Power(Plus(c_,Times(d_DEFAULT,Sqr(x_))),QQ(-3L,2L))),x_Symbol),
    Condition(Negate(Simp(Times(Plus(C1,Times(CN1,a,n,x)),Exp(Times(n,ArcTan(Times(a,x)))),Power(Times(d,Plus(Sqr(n),C1),Sqrt(Plus(c,Times(d,Sqr(x))))),-1)),x)),And(FreeQ(List(a,c,d,n),x),EqQ(d,Times(Sqr(a),c)),Not(IntegerQ(Times(CI,n))))));
IIntegrate(5078,Int(Times(Exp(Times(ArcTan(Times(a_DEFAULT,x_)),n_DEFAULT)),x_,Power(Plus(c_,Times(d_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(c,Times(d,Sqr(x))),Plus(p,C1)),Exp(Times(n,ArcTan(Times(a,x)))),Power(Times(C2,d,Plus(p,C1)),-1)),x),Negate(Dist(Times(a,c,n,Power(Times(C2,d,Plus(p,C1)),-1)),Int(Times(Power(Plus(c,Times(d,Sqr(x))),p),Exp(Times(n,ArcTan(Times(a,x))))),x),x))),And(FreeQ(List(a,c,d,n),x),EqQ(d,Times(Sqr(a),c)),LtQ(p,CN1),Not(IntegerQ(Times(CI,n))),IntegerQ(Times(C2,p)))));
IIntegrate(5079,Int(Times(Exp(Times(ArcTan(Times(a_DEFAULT,x_)),n_DEFAULT)),Sqr(x_),Power(Plus(c_,Times(d_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Negate(Simp(Times(Plus(C1,Times(CN1,a,n,x)),Power(Plus(c,Times(d,Sqr(x))),Plus(p,C1)),Exp(Times(n,ArcTan(Times(a,x)))),Power(Times(a,d,n,Plus(Sqr(n),C1)),-1)),x)),And(FreeQ(List(a,c,d,n),x),EqQ(d,Times(Sqr(a),c)),EqQ(Plus(Sqr(n),Times(CN1,C2,Plus(p,C1))),C0),Not(IntegerQ(Times(CI,n))))));
IIntegrate(5080,Int(Times(Exp(Times(ArcTan(Times(a_DEFAULT,x_)),n_DEFAULT)),Sqr(x_),Power(Plus(c_,Times(d_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Plus(n,Times(CN1,C2,Plus(p,C1),a,x)),Power(Plus(c,Times(d,Sqr(x))),Plus(p,C1)),Exp(Times(n,ArcTan(Times(a,x)))),Power(Times(a,d,Plus(Sqr(n),Times(C4,Sqr(Plus(p,C1))))),-1)),x)),Dist(Times(Plus(Sqr(n),Times(CN1,C2,Plus(p,C1))),Power(Times(d,Plus(Sqr(n),Times(C4,Sqr(Plus(p,C1))))),-1)),Int(Times(Power(Plus(c,Times(d,Sqr(x))),Plus(p,C1)),Exp(Times(n,ArcTan(Times(a,x))))),x),x)),And(FreeQ(List(a,c,d,n),x),EqQ(d,Times(Sqr(a),c)),LtQ(p,CN1),Not(IntegerQ(Times(CI,n))),NeQ(Plus(Sqr(n),Times(C4,Sqr(Plus(p,C1)))),C0),IntegerQ(Times(C2,p)))));
IIntegrate(5081,Int(Times(Exp(Times(ArcTan(Times(a_DEFAULT,x_)),n_)),Power(x_,m_DEFAULT),Power(Plus(c_,Times(d_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Power(c,p),Int(Times(Power(x,m),Power(Plus(C1,Times(Sqr(a),Sqr(x))),Plus(p,Times(CN1,C1D2,CI,n))),Power(Plus(C1,Times(CN1,CI,a,x)),Times(CI,n))),x),x),And(FreeQ(List(a,c,d,m,p),x),EqQ(d,Times(Sqr(a),c)),Or(IntegerQ(p),GtQ(c,C0)),IntegerQ(Times(C1D2,Plus(Times(CI,n),C1))),Not(IntegerQ(Plus(p,Times(CN1,C1D2,CI,n)))))));
IIntegrate(5082,Int(Times(Exp(Times(ArcTan(Times(a_DEFAULT,x_)),n_DEFAULT)),Power(x_,m_DEFAULT),Power(Plus(c_,Times(d_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Power(c,p),Int(Times(Power(x,m),Power(Plus(C1,Times(CN1,CI,a,x)),Plus(p,Times(C1D2,CI,n))),Power(Plus(C1,Times(CI,a,x)),Plus(p,Times(CN1,C1D2,CI,n)))),x),x),And(FreeQ(List(a,c,d,m,n,p),x),EqQ(d,Times(Sqr(a),c)),Or(IntegerQ(p),GtQ(c,C0)))));
IIntegrate(5083,Int(Times(Exp(Times(ArcTan(Times(a_DEFAULT,x_)),n_)),Power(x_,m_DEFAULT),Power(Plus(c_,Times(d_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Dist(Power(c,Times(C1D2,CI,n)),Int(Times(Power(x,m),Power(Plus(c,Times(d,Sqr(x))),Plus(p,Times(CN1,C1D2,CI,n))),Power(Plus(C1,Times(CN1,CI,a,x)),Times(CI,n))),x),x),And(FreeQ(List(a,c,d,m,p),x),EqQ(d,Times(Sqr(a),c)),Not(Or(IntegerQ(p),GtQ(c,C0))),IGtQ(Times(C1D2,CI,n),C0))));
IIntegrate(5084,Int(Times(Exp(Times(ArcTan(Times(a_DEFAULT,x_)),n_)),Power(x_,m_DEFAULT),Power(Plus(c_,Times(d_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Dist(Power(Power(c,Times(C1D2,CI,n)),-1),Int(Times(Power(x,m),Power(Plus(c,Times(d,Sqr(x))),Plus(p,Times(C1D2,CI,n))),Power(Power(Plus(C1,Times(CI,a,x)),Times(CI,n)),-1)),x),x),And(FreeQ(List(a,c,d,m,p),x),EqQ(d,Times(Sqr(a),c)),Not(Or(IntegerQ(p),GtQ(c,C0))),ILtQ(Times(C1D2,CI,n),C0))));
IIntegrate(5085,Int(Times(Exp(Times(ArcTan(Times(a_DEFAULT,x_)),n_DEFAULT)),Power(x_,m_DEFAULT),Power(Plus(c_,Times(d_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Dist(Times(Power(c,IntPart(p)),Power(Plus(c,Times(d,Sqr(x))),FracPart(p)),Power(Power(Plus(C1,Times(Sqr(a),Sqr(x))),FracPart(p)),-1)),Int(Times(Power(x,m),Power(Plus(C1,Times(Sqr(a),Sqr(x))),p),Exp(Times(n,ArcTan(Times(a,x))))),x),x),And(FreeQ(List(a,c,d,m,n,p),x),EqQ(d,Times(Sqr(a),c)),Not(Or(IntegerQ(p),GtQ(c,C0))))));
IIntegrate(5086,Int(Times(Exp(Times(ArcTan(Times(a_DEFAULT,x_)),n_DEFAULT)),u_,Power(Plus(c_,Times(d_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Power(c,p),Int(Times(u,Power(Plus(C1,Times(CN1,CI,a,x)),Plus(p,Times(C1D2,CI,n))),Power(Plus(C1,Times(CI,a,x)),Plus(p,Times(CN1,C1D2,CI,n)))),x),x),And(FreeQ(List(a,c,d,n,p),x),EqQ(d,Times(Sqr(a),c)),Or(IntegerQ(p),GtQ(c,C0)))));
IIntegrate(5087,Int(Times(Exp(Times(ArcTan(Times(a_DEFAULT,x_)),n_)),u_,Power(Plus(c_,Times(d_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(c,IntPart(p)),Power(Plus(c,Times(d,Sqr(x))),FracPart(p)),Power(Times(Power(Plus(C1,Times(CN1,CI,a,x)),FracPart(p)),Power(Plus(C1,Times(CI,a,x)),FracPart(p))),-1)),Int(Times(u,Power(Plus(C1,Times(CN1,CI,a,x)),Plus(p,Times(C1D2,CI,n))),Power(Plus(C1,Times(CI,a,x)),Plus(p,Times(CN1,C1D2,CI,n)))),x),x),And(FreeQ(List(a,c,d,n,p),x),EqQ(d,Times(Sqr(a),c)),Or(IntegerQ(p),GtQ(c,C0)),IntegerQ(Times(C1D2,CI,n)))));
IIntegrate(5088,Int(Times(Exp(Times(ArcTan(Times(a_DEFAULT,x_)),n_DEFAULT)),u_,Power(Plus(c_,Times(d_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Dist(Times(Power(c,IntPart(p)),Power(Plus(c,Times(d,Sqr(x))),FracPart(p)),Power(Power(Plus(C1,Times(Sqr(a),Sqr(x))),FracPart(p)),-1)),Int(Times(u,Power(Plus(C1,Times(Sqr(a),Sqr(x))),p),Exp(Times(n,ArcTan(Times(a,x))))),x),x),And(FreeQ(List(a,c,d,n,p),x),EqQ(d,Times(Sqr(a),c)),Not(Or(IntegerQ(p),GtQ(c,C0))),Not(IntegerQ(Times(C1D2,CI,n))))));
IIntegrate(5089,Int(Times(Exp(Times(ArcTan(Times(a_DEFAULT,x_)),n_DEFAULT)),u_DEFAULT,Power(Plus(c_,Times(d_DEFAULT,Power(x_,-2))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Power(d,p),Int(Times(u,Power(Plus(C1,Times(Sqr(a),Sqr(x))),p),Exp(Times(n,ArcTan(Times(a,x)))),Power(Power(x,Times(C2,p)),-1)),x),x),And(FreeQ(List(a,c,d,n),x),EqQ(Plus(c,Times(CN1,Sqr(a),d)),C0),IntegerQ(p))));
IIntegrate(5090,Int(Times(Exp(Times(ArcTan(Times(a_DEFAULT,x_)),n_)),u_DEFAULT,Power(Plus(c_,Times(d_DEFAULT,Power(x_,-2))),p_)),x_Symbol),
    Condition(Dist(Power(c,p),Int(Times(u,Power(Plus(C1,Times(CN1,CI,Power(Times(a,x),-1))),p),Power(Plus(C1,Times(CI,Power(Times(a,x),-1))),p),Exp(Times(n,ArcTan(Times(a,x))))),x),x),And(FreeQ(List(a,c,d,p),x),EqQ(Plus(c,Times(CN1,Sqr(a),d)),C0),Not(IntegerQ(p)),IntegerQ(Times(C1D2,CI,n)),GtQ(c,C0))));
IIntegrate(5091,Int(Times(Exp(Times(ArcTan(Times(a_DEFAULT,x_)),n_)),u_DEFAULT,Power(Plus(c_,Times(d_DEFAULT,Power(x_,-2))),p_)),x_Symbol),
    Condition(Dist(Times(Power(x,Times(C2,p)),Power(Plus(c,Times(d,Power(x,-2))),p),Power(Times(Power(Plus(C1,Times(CN1,CI,a,x)),p),Power(Plus(C1,Times(CI,a,x)),p)),-1)),Int(Times(u,Power(Plus(C1,Times(CN1,CI,a,x)),p),Power(Plus(C1,Times(CI,a,x)),p),Exp(Times(n,ArcTan(Times(a,x)))),Power(Power(x,Times(C2,p)),-1)),x),x),And(FreeQ(List(a,c,d,n,p),x),EqQ(Plus(c,Times(CN1,Sqr(a),d)),C0),Not(IntegerQ(p)),IntegerQ(Times(C1D2,CI,n)),Not(GtQ(c,C0)))));
IIntegrate(5092,Int(Times(Exp(Times(ArcTan(Times(a_DEFAULT,x_)),n_DEFAULT)),u_DEFAULT,Power(Plus(c_,Times(d_DEFAULT,Power(x_,-2))),p_)),x_Symbol),
    Condition(Dist(Times(Power(x,Times(C2,p)),Power(Plus(c,Times(d,Power(x,-2))),p),Power(Power(Plus(C1,Times(Sqr(a),Sqr(x))),p),-1)),Int(Times(u,Power(Plus(C1,Times(Sqr(a),Sqr(x))),p),Exp(Times(n,ArcTan(Times(a,x)))),Power(Power(x,Times(C2,p)),-1)),x),x),And(FreeQ(List(a,c,d,n,p),x),EqQ(Plus(c,Times(CN1,Sqr(a),d)),C0),Not(IntegerQ(p)),Not(IntegerQ(Times(C1D2,CI,n))))));
IIntegrate(5093,Int(Exp(Times(ArcTan(Times(c_DEFAULT,Plus(a_,Times(b_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(Plus(C1,Times(CN1,CI,a,c),Times(CN1,CI,b,c,x)),Times(C1D2,CI,n)),Power(Power(Plus(C1,Times(CI,a,c),Times(CI,b,c,x)),Times(C1D2,CI,n)),-1)),x),FreeQ(List(a,b,c,n),x)));
IIntegrate(5094,Int(Times(Exp(Times(ArcTan(Times(c_DEFAULT,Plus(a_,Times(b_DEFAULT,x_)))),n_)),Power(x_,m_)),x_Symbol),
    Condition(Dist(Times(C4,Power(Times(Power(CI,m),n,Power(b,Plus(m,C1)),Power(c,Plus(m,C1))),-1)),Subst(Int(Times(Power(x,Times(C2,Power(Times(CI,n),-1))),Power(Plus(C1,Times(CN1,CI,a,c),Times(CN1,Plus(C1,Times(CI,a,c)),Power(x,Times(C2,Power(Times(CI,n),-1))))),m),Power(Power(Plus(C1,Power(x,Times(C2,Power(Times(CI,n),-1)))),Plus(m,C2)),-1)),x),x,Times(Power(Plus(C1,Times(CN1,CI,c,Plus(a,Times(b,x)))),Times(C1D2,CI,n)),Power(Power(Plus(C1,Times(CI,c,Plus(a,Times(b,x)))),Times(C1D2,CI,n)),-1))),x),And(FreeQ(List(a,b,c),x),ILtQ(m,C0),LtQ(CN1,Times(CI,n),C1))));
IIntegrate(5095,Int(Times(Exp(Times(ArcTan(Times(c_DEFAULT,Plus(a_,Times(b_DEFAULT,x_)))),n_DEFAULT)),Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(Plus(d,Times(e,x)),m),Power(Plus(C1,Times(CN1,CI,a,c),Times(CN1,CI,b,c,x)),Times(C1D2,CI,n)),Power(Power(Plus(C1,Times(CI,a,c),Times(CI,b,c,x)),Times(C1D2,CI,n)),-1)),x),FreeQ(List(a,b,c,d,e,m,n),x)));
IIntegrate(5096,Int(Times(Exp(Times(ArcTan(Plus(a_,Times(b_DEFAULT,x_))),n_DEFAULT)),u_DEFAULT,Power(Plus(c_,Times(d_DEFAULT,x_),Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Power(Times(c,Power(Plus(C1,Sqr(a)),-1)),p),Int(Times(u,Power(Plus(C1,Times(CN1,CI,a),Times(CN1,CI,b,x)),Plus(p,Times(C1D2,CI,n))),Power(Plus(C1,Times(CI,a),Times(CI,b,x)),Plus(p,Times(CN1,C1D2,CI,n)))),x),x),And(FreeQ(List(a,b,c,d,e,n,p),x),EqQ(Times(b,d),Times(C2,a,e)),EqQ(Plus(Times(Sqr(b),c),Times(CN1,e,Plus(C1,Sqr(a)))),C0),Or(IntegerQ(p),GtQ(Times(c,Power(Plus(C1,Sqr(a)),-1)),C0)))));
IIntegrate(5097,Int(Times(Exp(Times(ArcTan(Plus(a_,Times(b_DEFAULT,x_))),n_DEFAULT)),u_DEFAULT,Power(Plus(c_,Times(d_DEFAULT,x_),Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(Plus(c,Times(d,x),Times(e,Sqr(x))),p),Power(Power(Plus(C1,Sqr(a),Times(C2,a,b,x),Times(Sqr(b),Sqr(x))),p),-1)),Int(Times(u,Power(Plus(C1,Sqr(a),Times(C2,a,b,x),Times(Sqr(b),Sqr(x))),p),Exp(Times(n,ArcTan(Times(a,x))))),x),x),And(FreeQ(List(a,b,c,d,e,n,p),x),EqQ(Times(b,d),Times(C2,a,e)),EqQ(Plus(Times(Sqr(b),c),Times(CN1,e,Plus(C1,Sqr(a)))),C0),Not(Or(IntegerQ(p),GtQ(Times(c,Power(Plus(C1,Sqr(a)),-1)),C0))))));
IIntegrate(5098,Int(Times(Exp(Times(ArcTan(Times(c_DEFAULT,Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),-1))),n_DEFAULT)),u_DEFAULT),x_Symbol),
    Condition(Int(Times(u,Exp(Times(n,ArcCot(Plus(Times(a,Power(c,-1)),Times(b,x,Power(c,-1))))))),x),FreeQ(List(a,b,c,n),x)));
IIntegrate(5099,Int(Times(Exp(Times(ArcCot(Times(a_DEFAULT,x_)),n_)),u_DEFAULT),x_Symbol),
    Condition(Dist(Power(CN1,Times(C1D2,CI,n)),Int(Times(u,Power(Exp(Times(n,ArcTan(Times(a,x)))),-1)),x),x),And(FreeQ(a,x),IntegerQ(Times(C1D2,CI,n)))));
IIntegrate(5100,Int(Exp(Times(ArcCot(Times(a_DEFAULT,x_)),n_)),x_Symbol),
    Condition(Negate(Subst(Int(Times(Power(Plus(C1,Times(CN1,CI,x,Power(a,-1))),Times(C1D2,Plus(Times(CI,n),C1))),Power(Times(Sqr(x),Power(Plus(C1,Times(CI,x,Power(a,-1))),Times(C1D2,Plus(Times(CI,n),Negate(C1)))),Sqrt(Plus(C1,Times(Sqr(x),Power(a,-2))))),-1)),x),x,Power(x,-1))),And(FreeQ(a,x),IntegerQ(Times(C1D2,Plus(Times(CI,n),Negate(C1)))))));
  }
}
}
