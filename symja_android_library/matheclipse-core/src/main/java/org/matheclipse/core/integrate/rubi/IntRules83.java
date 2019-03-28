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
public class IntRules83 { 

	public static void initialize() {
		Initializer.init();
	}

	private static class Initializer  {

		private static void init() {
IIntegrate(4151,Int(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),d_DEFAULT),m_),Power(Plus(a_,Times(b_DEFAULT,Power(Times(c_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_))),p_)),x_Symbol),
    Condition(Dist(Times(Power(Times(d,Csc(Plus(e,Times(f,x)))),FracPart(m)),Power(Times(Sin(Plus(e,Times(f,x))),Power(d,-1)),FracPart(m))),Int(Times(Power(Plus(a,Times(b,Power(Times(c,Sec(Plus(e,Times(f,x)))),n))),p),Power(Power(Times(Sin(Plus(e,Times(f,x))),Power(d,-1)),m),-1)),x),x),And(FreeQ(List(a,b,c,d,e,f,m,n,p),x),Not(IntegerQ(m)))));
IIntegrate(4152,Int(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power($($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),n_DEFAULT)),Times(c_DEFAULT,Power($($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),$p("n2",true)))),p_DEFAULT),x_Symbol),
    Condition(Dist(Power(Times(Power(C4,p),Power(c,p)),-1),Int(Power(Plus(b,Times(C2,c,Power(Sec(Plus(d,Times(e,x))),n))),Times(C2,p)),x),x),And(FreeQ(List(a,b,c,d,e,n),x),EqQ($s("n2"),Times(C2,n)),EqQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),IntegerQ(p))));
IIntegrate(4153,Int(Power(Plus(a_DEFAULT,Times(Power($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),n_DEFAULT),b_DEFAULT),Times(Power($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),$p("n2",true)),c_DEFAULT)),p_DEFAULT),x_Symbol),
    Condition(Dist(Power(Times(Power(C4,p),Power(c,p)),-1),Int(Power(Plus(b,Times(C2,c,Power(Csc(Plus(d,Times(e,x))),n))),Times(C2,p)),x),x),And(FreeQ(List(a,b,c,d,e,n),x),EqQ($s("n2"),Times(C2,n)),EqQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),IntegerQ(p))));
IIntegrate(4154,Int(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power($($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),n_DEFAULT)),Times(c_DEFAULT,Power($($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),$p("n2",true)))),p_),x_Symbol),
    Condition(Dist(Times(Power(Plus(a,Times(b,Power(Sec(Plus(d,Times(e,x))),n)),Times(c,Power(Sec(Plus(d,Times(e,x))),Times(C2,n)))),p),Power(Power(Plus(b,Times(C2,c,Power(Sec(Plus(d,Times(e,x))),n))),Times(C2,p)),-1)),Int(Times(u,Power(Plus(b,Times(C2,c,Power(Sec(Plus(d,Times(e,x))),n))),Times(C2,p))),x),x),And(FreeQ(List(a,b,c,d,e,n,p),x),EqQ($s("n2"),Times(C2,n)),EqQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),Not(IntegerQ(p)))));
IIntegrate(4155,Int(Power(Plus(a_DEFAULT,Times(Power($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),n_DEFAULT),b_DEFAULT),Times(Power($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),$p("n2",true)),c_DEFAULT)),p_),x_Symbol),
    Condition(Dist(Times(Power(Plus(a,Times(b,Power(Csc(Plus(d,Times(e,x))),n)),Times(c,Power(Csc(Plus(d,Times(e,x))),Times(C2,n)))),p),Power(Power(Plus(b,Times(C2,c,Power(Csc(Plus(d,Times(e,x))),n))),Times(C2,p)),-1)),Int(Times(u,Power(Plus(b,Times(C2,c,Power(Csc(Plus(d,Times(e,x))),n))),Times(C2,p))),x),x),And(FreeQ(List(a,b,c,d,e,n,p),x),EqQ($s("n2"),Times(C2,n)),EqQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),Not(IntegerQ(p)))));
IIntegrate(4156,Int(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power($($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),n_DEFAULT)),Times(c_DEFAULT,Power($($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),$p("n2",true)))),-1),x_Symbol),
    Condition(Module(List(Set(q,Rt(Plus(Sqr(b),Times(CN1,C4,a,c)),C2))),Plus(Dist(Times(C2,c,Power(q,-1)),Int(Power(Plus(b,Negate(q),Times(C2,c,Power(Sec(Plus(d,Times(e,x))),n))),-1),x),x),Negate(Dist(Times(C2,c,Power(q,-1)),Int(Power(Plus(b,q,Times(C2,c,Power(Sec(Plus(d,Times(e,x))),n))),-1),x),x)))),And(FreeQ(List(a,b,c,d,e,n),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0))));
IIntegrate(4157,Int(Power(Plus(a_DEFAULT,Times(Power($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),n_DEFAULT),b_DEFAULT),Times(Power($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),$p("n2",true)),c_DEFAULT)),-1),x_Symbol),
    Condition(Module(List(Set(q,Rt(Plus(Sqr(b),Times(CN1,C4,a,c)),C2))),Plus(Dist(Times(C2,c,Power(q,-1)),Int(Power(Plus(b,Negate(q),Times(C2,c,Power(Csc(Plus(d,Times(e,x))),n))),-1),x),x),Negate(Dist(Times(C2,c,Power(q,-1)),Int(Power(Plus(b,q,Times(C2,c,Power(Csc(Plus(d,Times(e,x))),n))),-1),x),x)))),And(FreeQ(List(a,b,c,d,e,n),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0))));
IIntegrate(4158,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power($($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),n_DEFAULT)),Times(c_DEFAULT,Power($($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),$p("n2")))),p_DEFAULT),Power($($s("§sin"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),m_DEFAULT)),x_Symbol),
    Condition(Module(List(Set(f,FreeFactors(Cos(Plus(d,Times(e,x))),x))),Negate(Dist(Times(f,Power(e,-1)),Subst(Int(Times(Power(Plus(C1,Times(CN1,Sqr(f),Sqr(x))),Times(C1D2,Plus(m,Negate(C1)))),Power(Plus(b,Times(a,Power(Times(f,x),n))),p),Power(Power(Times(f,x),Times(n,p)),-1)),x),x,Times(Cos(Plus(d,Times(e,x))),Power(f,-1))),x))),And(FreeQ(List(a,b,c,d,e),x),EqQ($s("n2"),Times(C2,n)),IntegerQ(Times(C1D2,Plus(m,Negate(C1)))),IntegersQ(n,p))));
IIntegrate(4159,Int(Times(Power($($s("§cos"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),m_DEFAULT),Power(Plus(a_DEFAULT,Times(Power($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),n_DEFAULT),b_DEFAULT),Times(Power($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),$p("n2")),c_DEFAULT)),p_DEFAULT)),x_Symbol),
    Condition(Module(List(Set(f,FreeFactors(Sin(Plus(d,Times(e,x))),x))),Dist(Times(f,Power(e,-1)),Subst(Int(Times(Power(Plus(C1,Times(CN1,Sqr(f),Sqr(x))),Times(C1D2,Plus(m,Negate(C1)))),Power(Plus(b,Times(a,Power(Times(f,x),n))),p),Power(Power(Times(f,x),Times(n,p)),-1)),x),x,Times(Sin(Plus(d,Times(e,x))),Power(f,-1))),x)),And(FreeQ(List(a,b,c,d,e),x),EqQ($s("n2"),Times(C2,n)),IntegerQ(Times(C1D2,Plus(m,Negate(C1)))),IntegersQ(n,p))));
IIntegrate(4160,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power($($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),n_)),Times(c_DEFAULT,Power($($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),$p("n2")))),p_DEFAULT),Power($($s("§sin"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),m_)),x_Symbol),
    Condition(Module(List(Set(f,FreeFactors(Tan(Plus(d,Times(e,x))),x))),Dist(Times(Power(f,Plus(m,C1)),Power(e,-1)),Subst(Int(Times(Power(x,m),Power(ExpandToSum(Plus(a,Times(b,Power(Plus(C1,Times(Sqr(f),Sqr(x))),Times(C1D2,n))),Times(c,Power(Plus(C1,Times(Sqr(f),Sqr(x))),n))),x),p),Power(Power(Plus(C1,Times(Sqr(f),Sqr(x))),Plus(Times(C1D2,m),C1)),-1)),x),x,Times(Tan(Plus(d,Times(e,x))),Power(f,-1))),x)),And(FreeQ(List(a,b,c,d,e,p),x),EqQ($s("n2"),Times(C2,n)),IntegerQ(Times(C1D2,m)),IntegerQ(Times(C1D2,n)))));
IIntegrate(4161,Int(Times(Power($($s("§cos"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),m_),Power(Plus(a_DEFAULT,Times(Power($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),n_),b_DEFAULT),Times(Power($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),$p("n2")),c_DEFAULT)),p_DEFAULT)),x_Symbol),
    Condition(Module(List(Set(f,FreeFactors(Cot(Plus(d,Times(e,x))),x))),Negate(Dist(Times(Power(f,Plus(m,C1)),Power(e,-1)),Subst(Int(Times(Power(x,m),Power(ExpandToSum(Plus(a,Times(b,Power(Plus(C1,Times(Sqr(f),Sqr(x))),Times(C1D2,n))),Times(c,Power(Plus(C1,Times(Sqr(f),Sqr(x))),n))),x),p),Power(Power(Plus(C1,Times(Sqr(f),Sqr(x))),Plus(Times(C1D2,m),C1)),-1)),x),x,Times(Cot(Plus(d,Times(e,x))),Power(f,-1))),x))),And(FreeQ(List(a,b,c,d,e,p),x),EqQ($s("n2"),Times(C2,n)),IntegerQ(Times(C1D2,m)),IntegerQ(Times(C1D2,n)))));
IIntegrate(4162,Int(Times(Power($($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power($($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),n_DEFAULT)),Times(c_DEFAULT,Power($($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),$p("n2",true)))),p_)),x_Symbol),
    Condition(Dist(Power(Times(Power(C4,p),Power(c,p)),-1),Int(Times(Power(Sec(Plus(d,Times(e,x))),m),Power(Plus(b,Times(C2,c,Power(Sec(Plus(d,Times(e,x))),n))),Times(C2,p))),x),x),And(FreeQ(List(a,b,c,d,e,m,n),x),EqQ($s("n2"),Times(C2,n)),EqQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),IntegerQ(p))));
IIntegrate(4163,Int(Times(Power($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),m_DEFAULT),Power(Plus(a_DEFAULT,Times(Power($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),n_DEFAULT),b_DEFAULT),Times(Power($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),$p("n2",true)),c_DEFAULT)),p_)),x_Symbol),
    Condition(Dist(Power(Times(Power(C4,p),Power(c,p)),-1),Int(Times(Power(Csc(Plus(d,Times(e,x))),m),Power(Plus(b,Times(C2,c,Power(Csc(Plus(d,Times(e,x))),n))),Times(C2,p))),x),x),And(FreeQ(List(a,b,c,d,e,m,n),x),EqQ($s("n2"),Times(C2,n)),EqQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),IntegerQ(p))));
IIntegrate(4164,Int(Times(Power($($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power($($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),n_DEFAULT)),Times(c_DEFAULT,Power($($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),$p("n2",true)))),p_)),x_Symbol),
    Condition(Dist(Times(Power(Plus(a,Times(b,Power(Sec(Plus(d,Times(e,x))),n)),Times(c,Power(Sec(Plus(d,Times(e,x))),Times(C2,n)))),p),Power(Power(Plus(b,Times(C2,c,Power(Sec(Plus(d,Times(e,x))),n))),Times(C2,p)),-1)),Int(Times(Power(Sec(Plus(d,Times(e,x))),m),Power(Plus(b,Times(C2,c,Power(Sec(Plus(d,Times(e,x))),n))),Times(C2,p))),x),x),And(FreeQ(List(a,b,c,d,e,m,n,p),x),EqQ($s("n2"),Times(C2,n)),EqQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),Not(IntegerQ(p)))));
IIntegrate(4165,Int(Times(Power($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),m_DEFAULT),Power(Plus(a_DEFAULT,Times(Power($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),n_DEFAULT),b_DEFAULT),Times(Power($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),$p("n2",true)),c_DEFAULT)),p_)),x_Symbol),
    Condition(Dist(Times(Power(Plus(a,Times(b,Power(Csc(Plus(d,Times(e,x))),n)),Times(c,Power(Csc(Plus(d,Times(e,x))),Times(C2,n)))),p),Power(Power(Plus(b,Times(C2,c,Power(Csc(Plus(d,Times(e,x))),n))),Times(C2,p)),-1)),Int(Times(Power(Csc(Plus(d,Times(e,x))),m),Power(Plus(b,Times(C2,c,Power(Csc(Plus(d,Times(e,x))),n))),Times(C2,p))),x),x),And(FreeQ(List(a,b,c,d,e,m,n,p),x),EqQ($s("n2"),Times(C2,n)),EqQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),Not(IntegerQ(p)))));
IIntegrate(4166,Int(Times(Power($($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power($($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),n_DEFAULT)),Times(c_DEFAULT,Power($($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),$p("n2",true)))),p_)),x_Symbol),
    Condition(Int(ExpandTrig(Times(Power($($s("§sec"),Plus(d,Times(e,x))),m),Power(Plus(a,Times(b,Power($($s("§sec"),Plus(d,Times(e,x))),n)),Times(c,Power($($s("§sec"),Plus(d,Times(e,x))),Times(C2,n)))),p)),x),x),And(FreeQ(List(a,b,c,d,e),x),EqQ($s("n2"),Times(C2,n)),IntegersQ(m,n,p))));
IIntegrate(4167,Int(Times(Power($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),m_DEFAULT),Power(Plus(a_DEFAULT,Times(Power($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),n_DEFAULT),b_DEFAULT),Times(Power($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),$p("n2",true)),c_DEFAULT)),p_)),x_Symbol),
    Condition(Int(ExpandTrig(Times(Power($($s("§csc"),Plus(d,Times(e,x))),m),Power(Plus(a,Times(b,Power($($s("§csc"),Plus(d,Times(e,x))),n)),Times(c,Power($($s("§csc"),Plus(d,Times(e,x))),Times(C2,n)))),p)),x),x),And(FreeQ(List(a,b,c,d,e),x),EqQ($s("n2"),Times(C2,n)),IntegersQ(m,n,p))));
IIntegrate(4168,Int(Times(Power(Plus(a_,Times(b_DEFAULT,Power($($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),n_DEFAULT)),Times(c_DEFAULT,Power($($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),$p("n2",true)))),p_DEFAULT),Power($($s("§tan"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),m_DEFAULT)),x_Symbol),
    Condition(Module(List(Set(f,FreeFactors(Cos(Plus(d,Times(e,x))),x))),Negate(Dist(Power(Times(e,Power(f,Plus(m,Times(n,p),Negate(C1)))),-1),Subst(Int(Times(Power(Plus(C1,Times(CN1,Sqr(f),Sqr(x))),Times(C1D2,Plus(m,Negate(C1)))),Power(Plus(c,Times(b,Power(Times(f,x),n)),Times(c,Power(Times(f,x),Times(C2,n)))),p),Power(Power(x,Plus(m,Times(C2,n,p))),-1)),x),x,Times(Cos(Plus(d,Times(e,x))),Power(f,-1))),x))),And(FreeQ(List(a,b,c,d,e,n),x),EqQ($s("n2"),Times(C2,n)),IntegerQ(Times(C1D2,Plus(m,Negate(C1)))),IntegerQ(n),IntegerQ(p))));
IIntegrate(4169,Int(Times(Power($($s("§cot"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),m_DEFAULT),Power(Plus(Times(Power($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),n_DEFAULT),b_DEFAULT),a_,Times(c_DEFAULT,Power($($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),$p("n2",true)))),p_DEFAULT)),x_Symbol),
    Condition(Module(List(Set(f,FreeFactors(Sin(Plus(d,Times(e,x))),x))),Dist(Power(Times(e,Power(f,Plus(m,Times(n,p),Negate(C1)))),-1),Subst(Int(Times(Power(Plus(C1,Times(CN1,Sqr(f),Sqr(x))),Times(C1D2,Plus(m,Negate(C1)))),Power(Plus(c,Times(b,Power(Times(f,x),n)),Times(c,Power(Times(f,x),Times(C2,n)))),p),Power(Power(x,Plus(m,Times(C2,n,p))),-1)),x),x,Times(Sin(Plus(d,Times(e,x))),Power(f,-1))),x)),And(FreeQ(List(a,b,c,d,e,n),x),EqQ($s("n2"),Times(C2,n)),IntegerQ(Times(C1D2,Plus(m,Negate(C1)))),IntegerQ(n),IntegerQ(p))));
IIntegrate(4170,Int(Times(Power(Plus(a_,Times(c_DEFAULT,Power($($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),$p("n2",true))),Times(b_DEFAULT,Power($($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),n_))),p_DEFAULT),Power($($s("§tan"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),m_DEFAULT)),x_Symbol),
    Condition(Module(List(Set(f,FreeFactors(Tan(Plus(d,Times(e,x))),x))),Dist(Times(Power(f,Plus(m,C1)),Power(e,-1)),Subst(Int(Times(Power(x,m),Power(ExpandToSum(Plus(a,Times(b,Power(Plus(C1,Times(Sqr(f),Sqr(x))),Times(C1D2,n))),Times(c,Power(Plus(C1,Times(Sqr(f),Sqr(x))),n))),x),p),Power(Plus(C1,Times(Sqr(f),Sqr(x))),-1)),x),x,Times(Tan(Plus(d,Times(e,x))),Power(f,-1))),x)),And(FreeQ(List(a,b,c,d,e),x),EqQ($s("n2"),Times(C2,n)),IntegerQ(Times(C1D2,m)),IntegerQ(Times(C1D2,n)))));
IIntegrate(4171,Int(Times(Power($($s("§cot"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),m_DEFAULT),Power(Plus(Times(Power($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),n_),b_DEFAULT),a_,Times(c_DEFAULT,Power($($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),$p("n2",true)))),p_DEFAULT)),x_Symbol),
    Condition(Module(List(Set(f,FreeFactors(Cot(Plus(d,Times(e,x))),x))),Negate(Dist(Times(Power(f,Plus(m,C1)),Power(e,-1)),Subst(Int(Times(Power(x,m),Power(ExpandToSum(Plus(a,Times(b,Power(Plus(C1,Times(Sqr(f),Sqr(x))),Times(C1D2,n))),Times(c,Power(Plus(C1,Times(Sqr(f),Sqr(x))),n))),x),p),Power(Plus(C1,Times(Sqr(f),Sqr(x))),-1)),x),x,Times(Cot(Plus(d,Times(e,x))),Power(f,-1))),x))),And(FreeQ(List(a,b,c,d,e),x),EqQ($s("n2"),Times(C2,n)),IntegerQ(Times(C1D2,m)),IntegerQ(Times(C1D2,n)))));
IIntegrate(4172,Int(Times(Plus(A_,Times(B_DEFAULT,$($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))))),Power(Plus(a_,Times(b_DEFAULT,$($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_)))),Times(c_DEFAULT,Sqr($($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_)))))),n_)),x_Symbol),
    Condition(Dist(Power(Times(Power(C4,n),Power(c,n)),-1),Int(Times(Plus(ASymbol,Times(BSymbol,Sec(Plus(d,Times(e,x))))),Power(Plus(b,Times(C2,c,Sec(Plus(d,Times(e,x))))),Times(C2,n))),x),x),And(FreeQ(List(a,b,c,d,e,ASymbol,BSymbol),x),EqQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),IntegerQ(n))));
IIntegrate(4173,Int(Times(Power(Plus(Times($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),b_DEFAULT),Times(Sqr($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_)))),c_DEFAULT),a_),n_),Plus(Times($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),B_DEFAULT),A_)),x_Symbol),
    Condition(Dist(Power(Times(Power(C4,n),Power(c,n)),-1),Int(Times(Plus(ASymbol,Times(BSymbol,Csc(Plus(d,Times(e,x))))),Power(Plus(b,Times(C2,c,Csc(Plus(d,Times(e,x))))),Times(C2,n))),x),x),And(FreeQ(List(a,b,c,d,e,ASymbol,BSymbol),x),EqQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),IntegerQ(n))));
IIntegrate(4174,Int(Times(Plus(A_,Times(B_DEFAULT,$($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))))),Power(Plus(a_,Times(b_DEFAULT,$($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_)))),Times(c_DEFAULT,Sqr($($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_)))))),n_)),x_Symbol),
    Condition(Dist(Times(Power(Plus(a,Times(b,Sec(Plus(d,Times(e,x)))),Times(c,Sqr(Sec(Plus(d,Times(e,x)))))),n),Power(Power(Plus(b,Times(C2,c,Sec(Plus(d,Times(e,x))))),Times(C2,n)),-1)),Int(Times(Plus(ASymbol,Times(BSymbol,Sec(Plus(d,Times(e,x))))),Power(Plus(b,Times(C2,c,Sec(Plus(d,Times(e,x))))),Times(C2,n))),x),x),And(FreeQ(List(a,b,c,d,e,ASymbol,BSymbol),x),EqQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),Not(IntegerQ(n)))));
IIntegrate(4175,Int(Times(Power(Plus(Times($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),b_DEFAULT),Times(Sqr($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_)))),c_DEFAULT),a_),n_),Plus(Times($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),B_DEFAULT),A_)),x_Symbol),
    Condition(Dist(Times(Power(Plus(a,Times(b,Csc(Plus(d,Times(e,x)))),Times(c,Sqr(Csc(Plus(d,Times(e,x)))))),n),Power(Power(Plus(b,Times(C2,c,Csc(Plus(d,Times(e,x))))),Times(C2,n)),-1)),Int(Times(Plus(ASymbol,Times(BSymbol,Csc(Plus(d,Times(e,x))))),Power(Plus(b,Times(C2,c,Csc(Plus(d,Times(e,x))))),Times(C2,n))),x),x),And(FreeQ(List(a,b,c,d,e,ASymbol,BSymbol),x),EqQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),Not(IntegerQ(n)))));
IIntegrate(4176,Int(Times(Plus(A_,Times(B_DEFAULT,$($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))))),Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_)))),Times(c_DEFAULT,Sqr($($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_)))))),-1)),x_Symbol),
    Condition(Module(List(Set(q,Rt(Plus(Sqr(b),Times(CN1,C4,a,c)),C2))),Plus(Dist(Plus(BSymbol,Times(Plus(Times(b,BSymbol),Times(CN1,C2,ASymbol,c)),Power(q,-1))),Int(Power(Plus(b,q,Times(C2,c,Sec(Plus(d,Times(e,x))))),-1),x),x),Dist(Plus(BSymbol,Times(CN1,Plus(Times(b,BSymbol),Times(CN1,C2,ASymbol,c)),Power(q,-1))),Int(Power(Plus(b,Negate(q),Times(C2,c,Sec(Plus(d,Times(e,x))))),-1),x),x))),And(FreeQ(List(a,b,c,d,e,ASymbol,BSymbol),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0))));
IIntegrate(4177,Int(Times(Power(Plus(a_DEFAULT,Times($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),b_DEFAULT),Times(Sqr($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_)))),c_DEFAULT)),-1),Plus(Times($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),B_DEFAULT),A_)),x_Symbol),
    Condition(Module(List(Set(q,Rt(Plus(Sqr(b),Times(CN1,C4,a,c)),C2))),Plus(Dist(Plus(BSymbol,Times(Plus(Times(b,BSymbol),Times(CN1,C2,ASymbol,c)),Power(q,-1))),Int(Power(Plus(b,q,Times(C2,c,Csc(Plus(d,Times(e,x))))),-1),x),x),Dist(Plus(BSymbol,Times(CN1,Plus(Times(b,BSymbol),Times(CN1,C2,ASymbol,c)),Power(q,-1))),Int(Power(Plus(b,Negate(q),Times(C2,c,Csc(Plus(d,Times(e,x))))),-1),x),x))),And(FreeQ(List(a,b,c,d,e,ASymbol,BSymbol),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0))));
IIntegrate(4178,Int(Times(Plus(A_,Times(B_DEFAULT,$($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))))),Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_)))),Times(c_DEFAULT,Sqr($($s("§sec"),Plus(d_DEFAULT,Times(e_DEFAULT,x_)))))),n_)),x_Symbol),
    Condition(Int(ExpandTrig(Times(Plus(ASymbol,Times(BSymbol,$($s("§sec"),Plus(d,Times(e,x))))),Power(Plus(a,Times(b,$($s("§sec"),Plus(d,Times(e,x)))),Times(c,Sqr($($s("§sec"),Plus(d,Times(e,x)))))),n)),x),x),And(FreeQ(List(a,b,c,d,e,ASymbol,BSymbol),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),IntegerQ(n))));
IIntegrate(4179,Int(Times(Power(Plus(a_DEFAULT,Times($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),b_DEFAULT),Times(Sqr($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_)))),c_DEFAULT)),n_),Plus(Times($($s("§csc"),Plus(d_DEFAULT,Times(e_DEFAULT,x_))),B_DEFAULT),A_)),x_Symbol),
    Condition(Int(ExpandTrig(Times(Plus(ASymbol,Times(BSymbol,$($s("§csc"),Plus(d,Times(e,x))))),Power(Plus(a,Times(b,$($s("§csc"),Plus(d,Times(e,x)))),Times(c,Sqr($($s("§csc"),Plus(d,Times(e,x)))))),n)),x),x),And(FreeQ(List(a,b,c,d,e,ASymbol,BSymbol),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),IntegerQ(n))));
IIntegrate(4180,Int(Times($($s("§csc"),Plus(e_DEFAULT,Times(Pi,k_DEFAULT),Times(Complex(C0,$p("fz")),f_DEFAULT,x_))),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(CN2,Power(Plus(c,Times(d,x)),m),ArcTanh(Times(Exp(Plus(Times(CN1,CI,e),Times(f,$s("fz"),x))),Power(Exp(Times(CI,k,Pi)),-1))),Power(Times(f,$s("fz"),CI),-1)),x),Negate(Dist(Times(d,m,Power(Times(f,$s("fz"),CI),-1)),Int(Times(Power(Plus(c,Times(d,x)),Plus(m,Negate(C1))),Log(Plus(C1,Times(CN1,Exp(Plus(Times(CN1,CI,e),Times(f,$s("fz"),x))),Power(Exp(Times(CI,k,Pi)),-1))))),x),x)),Dist(Times(d,m,Power(Times(f,$s("fz"),CI),-1)),Int(Times(Power(Plus(c,Times(d,x)),Plus(m,Negate(C1))),Log(Plus(C1,Times(Exp(Plus(Times(CN1,CI,e),Times(f,$s("fz"),x))),Power(Exp(Times(CI,k,Pi)),-1))))),x),x)),And(FreeQ(List(c,d,e,f,$s("fz")),x),IntegerQ(Times(C2,k)),IGtQ(m,C0))));
IIntegrate(4181,Int(Times($($s("§csc"),Plus(e_DEFAULT,Times(Pi,k_DEFAULT),Times(f_DEFAULT,x_))),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(CN2,Power(Plus(c,Times(d,x)),m),ArcTanh(Times(Exp(Times(CI,k,Pi)),Exp(Times(CI,Plus(e,Times(f,x)))))),Power(f,-1)),x),Negate(Dist(Times(d,m,Power(f,-1)),Int(Times(Power(Plus(c,Times(d,x)),Plus(m,Negate(C1))),Log(Plus(C1,Times(CN1,Exp(Times(CI,k,Pi)),Exp(Times(CI,Plus(e,Times(f,x)))))))),x),x)),Dist(Times(d,m,Power(f,-1)),Int(Times(Power(Plus(c,Times(d,x)),Plus(m,Negate(C1))),Log(Plus(C1,Times(Exp(Times(CI,k,Pi)),Exp(Times(CI,Plus(e,Times(f,x)))))))),x),x)),And(FreeQ(List(c,d,e,f),x),IntegerQ(Times(C2,k)),IGtQ(m,C0))));
IIntegrate(4182,Int(Times($($s("§csc"),Plus(e_DEFAULT,Times(Complex(C0,$p("fz")),f_DEFAULT,x_))),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(CN2,Power(Plus(c,Times(d,x)),m),ArcTanh(Exp(Plus(Times(CN1,CI,e),Times(f,$s("fz"),x)))),Power(Times(f,$s("fz"),CI),-1)),x),Negate(Dist(Times(d,m,Power(Times(f,$s("fz"),CI),-1)),Int(Times(Power(Plus(c,Times(d,x)),Plus(m,Negate(C1))),Log(Plus(C1,Negate(Exp(Plus(Times(CN1,CI,e),Times(f,$s("fz"),x))))))),x),x)),Dist(Times(d,m,Power(Times(f,$s("fz"),CI),-1)),Int(Times(Power(Plus(c,Times(d,x)),Plus(m,Negate(C1))),Log(Plus(C1,Exp(Plus(Times(CN1,CI,e),Times(f,$s("fz"),x)))))),x),x)),And(FreeQ(List(c,d,e,f,$s("fz")),x),IGtQ(m,C0))));
IIntegrate(4183,Int(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(CN2,Power(Plus(c,Times(d,x)),m),ArcTanh(Exp(Times(CI,Plus(e,Times(f,x))))),Power(f,-1)),x),Negate(Dist(Times(d,m,Power(f,-1)),Int(Times(Power(Plus(c,Times(d,x)),Plus(m,Negate(C1))),Log(Plus(C1,Negate(Exp(Times(CI,Plus(e,Times(f,x)))))))),x),x)),Dist(Times(d,m,Power(f,-1)),Int(Times(Power(Plus(c,Times(d,x)),Plus(m,Negate(C1))),Log(Plus(C1,Exp(Times(CI,Plus(e,Times(f,x))))))),x),x)),And(FreeQ(List(c,d,e,f),x),IGtQ(m,C0))));
IIntegrate(4184,Int(Times(Sqr($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Power(Plus(c,Times(d,x)),m),Cot(Plus(e,Times(f,x))),Power(f,-1)),x)),Dist(Times(d,m,Power(f,-1)),Int(Times(Power(Plus(c,Times(d,x)),Plus(m,Negate(C1))),Cot(Plus(e,Times(f,x)))),x),x)),And(FreeQ(List(c,d,e,f),x),GtQ(m,C0))));
IIntegrate(4185,Int(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),n_),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Sqr(b),Plus(c,Times(d,x)),Cot(Plus(e,Times(f,x))),Power(Times(b,Csc(Plus(e,Times(f,x)))),Plus(n,Negate(C2))),Power(Times(f,Plus(n,Negate(C1))),-1)),x)),Dist(Times(Sqr(b),Plus(n,Negate(C2)),Power(Plus(n,Negate(C1)),-1)),Int(Times(Plus(c,Times(d,x)),Power(Times(b,Csc(Plus(e,Times(f,x)))),Plus(n,Negate(C2)))),x),x),Negate(Simp(Times(Sqr(b),d,Power(Times(b,Csc(Plus(e,Times(f,x)))),Plus(n,Negate(C2))),Power(Times(Sqr(f),Plus(n,Negate(C1)),Plus(n,Negate(C2))),-1)),x))),And(FreeQ(List(b,c,d,e,f),x),GtQ(n,C1),NeQ(n,C2))));
IIntegrate(4186,Int(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),n_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),m_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Sqr(b),Power(Plus(c,Times(d,x)),m),Cot(Plus(e,Times(f,x))),Power(Times(b,Csc(Plus(e,Times(f,x)))),Plus(n,Negate(C2))),Power(Times(f,Plus(n,Negate(C1))),-1)),x)),Dist(Times(Sqr(b),Sqr(d),m,Plus(m,Negate(C1)),Power(Times(Sqr(f),Plus(n,Negate(C1)),Plus(n,Negate(C2))),-1)),Int(Times(Power(Plus(c,Times(d,x)),Plus(m,Negate(C2))),Power(Times(b,Csc(Plus(e,Times(f,x)))),Plus(n,Negate(C2)))),x),x),Dist(Times(Sqr(b),Plus(n,Negate(C2)),Power(Plus(n,Negate(C1)),-1)),Int(Times(Power(Plus(c,Times(d,x)),m),Power(Times(b,Csc(Plus(e,Times(f,x)))),Plus(n,Negate(C2)))),x),x),Negate(Simp(Times(Sqr(b),d,m,Power(Plus(c,Times(d,x)),Plus(m,Negate(C1))),Power(Times(b,Csc(Plus(e,Times(f,x)))),Plus(n,Negate(C2))),Power(Times(Sqr(f),Plus(n,Negate(C1)),Plus(n,Negate(C2))),-1)),x))),And(FreeQ(List(b,c,d,e,f),x),GtQ(n,C1),NeQ(n,C2),GtQ(m,C1))));
IIntegrate(4187,Int(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),n_),Plus(c_DEFAULT,Times(d_DEFAULT,x_))),x_Symbol),
    Condition(Plus(Simp(Times(d,Power(Times(b,Csc(Plus(e,Times(f,x)))),n),Power(Times(Sqr(f),Sqr(n)),-1)),x),Dist(Times(Plus(n,C1),Power(Times(Sqr(b),n),-1)),Int(Times(Plus(c,Times(d,x)),Power(Times(b,Csc(Plus(e,Times(f,x)))),Plus(n,C2))),x),x),Simp(Times(Plus(c,Times(d,x)),Cos(Plus(e,Times(f,x))),Power(Times(b,Csc(Plus(e,Times(f,x)))),Plus(n,C1)),Power(Times(b,f,n),-1)),x)),And(FreeQ(List(b,c,d,e,f),x),LtQ(n,CN1))));
IIntegrate(4188,Int(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),n_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),m_)),x_Symbol),
    Condition(Plus(Simp(Times(d,m,Power(Plus(c,Times(d,x)),Plus(m,Negate(C1))),Power(Times(b,Csc(Plus(e,Times(f,x)))),n),Power(Times(Sqr(f),Sqr(n)),-1)),x),Dist(Times(Plus(n,C1),Power(Times(Sqr(b),n),-1)),Int(Times(Power(Plus(c,Times(d,x)),m),Power(Times(b,Csc(Plus(e,Times(f,x)))),Plus(n,C2))),x),x),Negate(Dist(Times(Sqr(d),m,Plus(m,Negate(C1)),Power(Times(Sqr(f),Sqr(n)),-1)),Int(Times(Power(Plus(c,Times(d,x)),Plus(m,Negate(C2))),Power(Times(b,Csc(Plus(e,Times(f,x)))),n)),x),x)),Simp(Times(Power(Plus(c,Times(d,x)),m),Cos(Plus(e,Times(f,x))),Power(Times(b,Csc(Plus(e,Times(f,x)))),Plus(n,C1)),Power(Times(b,f,n),-1)),x)),And(FreeQ(List(b,c,d,e,f),x),LtQ(n,CN1),GtQ(m,C1))));
IIntegrate(4189,Int(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),n_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(Times(b,Sin(Plus(e,Times(f,x)))),n),Power(Times(b,Csc(Plus(e,Times(f,x)))),n)),Int(Times(Power(Plus(c,Times(d,x)),m),Power(Power(Times(b,Sin(Plus(e,Times(f,x)))),n),-1)),x),x),And(FreeQ(List(b,c,d,e,f,m,n),x),Not(IntegerQ(n)))));
IIntegrate(4190,Int(Times(Power(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_),n_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Int(ExpandIntegrand(Power(Plus(c,Times(d,x)),m),Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),n),x),x),And(FreeQ(List(a,b,c,d,e,f,m),x),IGtQ(m,C0),IGtQ(n,C0))));
IIntegrate(4191,Int(Times(Power(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_),n_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Int(ExpandIntegrand(Power(Plus(c,Times(d,x)),m),Power(Times(Power(Sin(Plus(e,Times(f,x))),n),Power(Power(Plus(b,Times(a,Sin(Plus(e,Times(f,x))))),n),-1)),-1),x),x),And(FreeQ(List(a,b,c,d,e,f),x),ILtQ(n,C0),IGtQ(m,C0))));
IIntegrate(4192,Int(Times(Power($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),n_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Simp(If(MatchQ(f,Times($p("f1",true),Complex(C0,j_))),If(MatchQ(e,Plus($p("e1",true),Times(C1D2,Pi))),Unintegrable(Times(Power(Plus(c,Times(d,x)),m),Power(Sech(Plus(Times(CI,Plus(e,Times(CN1,C1D2,Pi))),Times(CI,f,x))),n)),x),Times(Power(Negate(CI),n),Unintegrable(Times(Power(Plus(c,Times(d,x)),m),Power(Csch(Plus(Times(CN1,CI,e),Times(CN1,CI,f,x))),n)),x))),If(MatchQ(e,Plus($p("e1",true),Times(C1D2,Pi))),Unintegrable(Times(Power(Plus(c,Times(d,x)),m),Power(Sec(Plus(e,Times(CN1,C1D2,Pi),Times(f,x))),n)),x),Unintegrable(Times(Power(Plus(c,Times(d,x)),m),Power(Csc(Plus(e,Times(f,x))),n)),x))),x),And(FreeQ(List(c,d,e,f,m,n),x),IntegerQ(n))));
IIntegrate(4193,Int(Times(Power(Plus(a_DEFAULT,Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT)),n_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Unintegrable(Times(Power(Plus(c,Times(d,x)),m),Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),n)),x),FreeQ(List(a,b,c,d,e,f,m,n),x)));
IIntegrate(4194,Int(Times(Power(u_,m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sec(v_))),n_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(ExpandToSum(u,x),m),Power(Plus(a,Times(b,Sec(ExpandToSum(v,x)))),n)),x),And(FreeQ(List(a,b,m,n),x),LinearQ(List(u,v),x),Not(LinearMatchQ(List(u,v),x)))));
IIntegrate(4195,Int(Times(Power(Plus(a_DEFAULT,Times(Csc(v_),b_DEFAULT)),n_DEFAULT),Power(u_,m_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(ExpandToSum(u,x),m),Power(Plus(a,Times(b,Csc(ExpandToSum(v,x)))),n)),x),And(FreeQ(List(a,b,m,n),x),LinearQ(List(u,v),x),Not(LinearMatchQ(List(u,v),x)))));
IIntegrate(4196,Int(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sec(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_)))))),p_DEFAULT),x_Symbol),
    Condition(Dist(Power(n,-1),Subst(Int(Times(Power(x,Plus(Power(n,-1),Negate(C1))),Power(Plus(a,Times(b,Sec(Plus(c,Times(d,x))))),p)),x),x,Power(x,n)),x),And(FreeQ(List(a,b,c,d,p),x),IGtQ(Power(n,-1),C0),IntegerQ(p))));
IIntegrate(4197,Int(Power(Plus(a_DEFAULT,Times(Csc(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_)))),b_DEFAULT)),p_DEFAULT),x_Symbol),
    Condition(Dist(Power(n,-1),Subst(Int(Times(Power(x,Plus(Power(n,-1),Negate(C1))),Power(Plus(a,Times(b,Csc(Plus(c,Times(d,x))))),p)),x),x,Power(x,n)),x),And(FreeQ(List(a,b,c,d,p),x),IGtQ(Power(n,-1),C0),IntegerQ(p))));
IIntegrate(4198,Int(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sec(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_)))))),p_DEFAULT),x_Symbol),
    Condition(Unintegrable(Power(Plus(a,Times(b,Sec(Plus(c,Times(d,Power(x,n)))))),p),x),FreeQ(List(a,b,c,d,n,p),x)));
IIntegrate(4199,Int(Power(Plus(a_DEFAULT,Times(Csc(Plus(c_DEFAULT,Times(d_DEFAULT,Power(x_,n_)))),b_DEFAULT)),p_DEFAULT),x_Symbol),
    Condition(Unintegrable(Power(Plus(a,Times(b,Csc(Plus(c,Times(d,Power(x,n)))))),p),x),FreeQ(List(a,b,c,d,n,p),x)));
IIntegrate(4200,Int(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sec(Plus(c_DEFAULT,Times(d_DEFAULT,Power(u_,n_)))))),p_DEFAULT),x_Symbol),
    Condition(Dist(Power(Coefficient(u,x,C1),-1),Subst(Int(Power(Plus(a,Times(b,Sec(Plus(c,Times(d,Power(x,n)))))),p),x),x,u),x),And(FreeQ(List(a,b,c,d,n,p),x),LinearQ(u,x),NeQ(u,x))));
  }
}
}
