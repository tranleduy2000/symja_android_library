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
public class IntRules132 { 

	public static void initialize() {
		Initializer.init();
	}

	private static class Initializer  {

		private static void init() {
IIntegrate(6601,Int(Times(Log(Plus(C1,Times(e_DEFAULT,x_))),Power(x_,-1),PolyLog(C2,Times(c_DEFAULT,x_))),x_Symbol),
    Condition(Negate(Simp(Times(C1D2,Sqr(PolyLog(C2,Times(c,x)))),x)),And(FreeQ(List(c,e),x),EqQ(Plus(c,e),C0))));
IIntegrate(6602,Int(Times(Plus(Times(Log(Plus(C1,Times(e_DEFAULT,x_))),h_DEFAULT),g_),Power(x_,-1),PolyLog(C2,Times(c_DEFAULT,x_))),x_Symbol),
    Condition(Plus(Dist(g,Int(Times(PolyLog(C2,Times(c,x)),Power(x,-1)),x),x),Dist(h,Int(Times(Log(Plus(C1,Times(e,x))),PolyLog(C2,Times(c,x)),Power(x,-1)),x),x)),And(FreeQ(List(c,e,g,h),x),EqQ(Plus(c,e),C0))));
IIntegrate(6603,Int(Times(Plus(g_DEFAULT,Times(Log(Times(f_DEFAULT,Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),n_DEFAULT))),h_DEFAULT)),Power(x_,m_DEFAULT),PolyLog(C2,Times(c_DEFAULT,Plus(a_DEFAULT,Times(b_DEFAULT,x_))))),x_Symbol),
    Condition(Plus(Simp(Times(Power(x,Plus(m,C1)),Plus(g,Times(h,Log(Times(f,Power(Plus(d,Times(e,x)),n))))),PolyLog(C2,Times(c,Plus(a,Times(b,x)))),Power(Plus(m,C1),-1)),x),Dist(Times(b,Power(Plus(m,C1),-1)),Int(ExpandIntegrand(Times(Plus(g,Times(h,Log(Times(f,Power(Plus(d,Times(e,x)),n))))),Log(Plus(C1,Times(CN1,a,c),Times(CN1,b,c,x)))),Times(Power(x,Plus(m,C1)),Power(Plus(a,Times(b,x)),-1)),x),x),x),Negate(Dist(Times(e,h,n,Power(Plus(m,C1),-1)),Int(ExpandIntegrand(PolyLog(C2,Times(c,Plus(a,Times(b,x)))),Times(Power(x,Plus(m,C1)),Power(Plus(d,Times(e,x)),-1)),x),x),x))),And(FreeQ(List(a,b,c,d,e,f,g,h,n),x),IntegerQ(m),NeQ(m,CN1))));
IIntegrate(6604,Int(Times(Plus(g_DEFAULT,Times(Log(Times(f_DEFAULT,Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),n_DEFAULT))),h_DEFAULT)),$p("§px"),PolyLog(C2,Times(c_DEFAULT,Plus(a_DEFAULT,Times(b_DEFAULT,x_))))),x_Symbol),
    Condition(With(List(Set(u,IntHide($s("§px"),x))),Plus(Simp(Times(u,Plus(g,Times(h,Log(Times(f,Power(Plus(d,Times(e,x)),n))))),PolyLog(C2,Times(c,Plus(a,Times(b,x))))),x),Dist(b,Int(ExpandIntegrand(Times(Plus(g,Times(h,Log(Times(f,Power(Plus(d,Times(e,x)),n))))),Log(Plus(C1,Times(CN1,a,c),Times(CN1,b,c,x)))),Times(u,Power(Plus(a,Times(b,x)),-1)),x),x),x),Negate(Dist(Times(e,h,n),Int(ExpandIntegrand(PolyLog(C2,Times(c,Plus(a,Times(b,x)))),Times(u,Power(Plus(d,Times(e,x)),-1)),x),x),x)))),And(FreeQ(List(a,b,c,d,e,f,g,h,n),x),PolyQ($s("§px"),x))));
IIntegrate(6605,Int(Times(Plus(g_DEFAULT,Times(Log(Plus(C1,Times(e_DEFAULT,x_))),h_DEFAULT)),$p("§px"),Power(x_,m_),PolyLog(C2,Times(c_DEFAULT,x_))),x_Symbol),
    Condition(Plus(Dist(Coeff($s("§px"),x,Plus(Negate(m),Negate(C1))),Int(Times(Plus(g,Times(h,Log(Plus(C1,Times(e,x))))),PolyLog(C2,Times(c,x)),Power(x,-1)),x),x),Int(Times(Power(x,m),Plus($s("§px"),Times(CN1,Coeff($s("§px"),x,Plus(Negate(m),Negate(C1))),Power(x,Plus(Negate(m),Negate(C1))))),Plus(g,Times(h,Log(Plus(C1,Times(e,x))))),PolyLog(C2,Times(c,x))),x)),And(FreeQ(List(c,e,g,h),x),PolyQ($s("§px"),x),ILtQ(m,C0),EqQ(Plus(c,e),C0),NeQ(Coeff($s("§px"),x,Plus(Negate(m),Negate(C1))),C0))));
IIntegrate(6606,Int(Times(Plus(g_DEFAULT,Times(Log(Times(f_DEFAULT,Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),n_DEFAULT))),h_DEFAULT)),$p("§px"),Power(x_,m_DEFAULT),PolyLog(C2,Times(c_DEFAULT,Plus(a_DEFAULT,Times(b_DEFAULT,x_))))),x_Symbol),
    Condition(With(List(Set(u,IntHide(Times(Power(x,m),$s("§px")),x))),Plus(Simp(Times(u,Plus(g,Times(h,Log(Times(f,Power(Plus(d,Times(e,x)),n))))),PolyLog(C2,Times(c,Plus(a,Times(b,x))))),x),Dist(b,Int(ExpandIntegrand(Times(Plus(g,Times(h,Log(Times(f,Power(Plus(d,Times(e,x)),n))))),Log(Plus(C1,Times(CN1,a,c),Times(CN1,b,c,x)))),Times(u,Power(Plus(a,Times(b,x)),-1)),x),x),x),Negate(Dist(Times(e,h,n),Int(ExpandIntegrand(PolyLog(C2,Times(c,Plus(a,Times(b,x)))),Times(u,Power(Plus(d,Times(e,x)),-1)),x),x),x)))),And(FreeQ(List(a,b,c,d,e,f,g,h,n),x),PolyQ($s("§px"),x),IntegerQ(m))));
IIntegrate(6607,Int(Times(Plus(g_DEFAULT,Times(Log(Times(f_DEFAULT,Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),n_DEFAULT))),h_DEFAULT)),$p("§px",true),Power(x_,m_),PolyLog(C2,Times(c_DEFAULT,Plus(a_DEFAULT,Times(b_DEFAULT,x_))))),x_Symbol),
    Condition(Unintegrable(Times($s("§px"),Power(x,m),Plus(g,Times(h,Log(Times(f,Power(Plus(d,Times(e,x)),n))))),PolyLog(C2,Times(c,Plus(a,Times(b,x))))),x),And(FreeQ(List(a,b,c,d,e,f,g,h,m,n),x),PolyQ($s("§px"),x))));
IIntegrate(6608,Int(PolyLog(n_,Times(d_DEFAULT,Power(Power(F_,Times(c_DEFAULT,Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),p_DEFAULT))),x_Symbol),
    Condition(Simp(Times(PolyLog(Plus(n,C1),Times(d,Power(Power(FSymbol,Times(c,Plus(a,Times(b,x)))),p))),Power(Times(b,c,p,Log(FSymbol)),-1)),x),FreeQ(List(FSymbol,a,b,c,d,n,p),x)));
IIntegrate(6609,Int(Times(Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),PolyLog(n_,Times(d_DEFAULT,Power(Power(F_,Times(c_DEFAULT,Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),p_DEFAULT)))),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),m),PolyLog(Plus(n,C1),Times(d,Power(Power(FSymbol,Times(c,Plus(a,Times(b,x)))),p))),Power(Times(b,c,p,Log(FSymbol)),-1)),x),Negate(Dist(Times(f,m,Power(Times(b,c,p,Log(FSymbol)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,Negate(C1))),PolyLog(Plus(n,C1),Times(d,Power(Power(FSymbol,Times(c,Plus(a,Times(b,x)))),p)))),x),x))),And(FreeQ(List(FSymbol,a,b,c,d,e,f,n,p),x),GtQ(m,C0))));
IIntegrate(6610,Int(Times(u_,PolyLog(n_,v_)),x_Symbol),
    Condition(With(List(Set(w,DerivativeDivides(v,Times(u,v),x))),Condition(Simp(Times(w,PolyLog(Plus(n,C1),v)),x),Not(FalseQ(w)))),FreeQ(n,x)));
IIntegrate(6611,Int(Times(Log(w_),u_,PolyLog(n_,v_)),x_Symbol),
    Condition(With(List(Set(z,DerivativeDivides(v,Times(u,v),x))),Condition(Plus(Simp(Times(z,Log(w),PolyLog(Plus(n,C1),v)),x),Negate(Int(SimplifyIntegrand(Times(z,D(w,x),PolyLog(Plus(n,C1),v),Power(w,-1)),x),x))),Not(FalseQ(z)))),And(FreeQ(n,x),InverseFunctionFreeQ(w,x))));
IIntegrate(6612,Int(Power(Times(c_DEFAULT,ProductLog(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),p_),x_Symbol),
    Condition(Plus(Simp(Times(Plus(a,Times(b,x)),Power(Times(c,ProductLog(Plus(a,Times(b,x)))),p),Power(Times(b,Plus(p,C1)),-1)),x),Dist(Times(p,Power(Times(c,Plus(p,C1)),-1)),Int(Times(Power(Times(c,ProductLog(Plus(a,Times(b,x)))),Plus(p,C1)),Power(Plus(C1,ProductLog(Plus(a,Times(b,x)))),-1)),x),x)),And(FreeQ(List(a,b,c),x),LtQ(p,CN1))));
IIntegrate(6613,Int(Power(Times(c_DEFAULT,ProductLog(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),p_DEFAULT),x_Symbol),
    Condition(Plus(Simp(Times(Plus(a,Times(b,x)),Power(Times(c,ProductLog(Plus(a,Times(b,x)))),p),Power(b,-1)),x),Negate(Dist(p,Int(Times(Power(Times(c,ProductLog(Plus(a,Times(b,x)))),p),Power(Plus(C1,ProductLog(Plus(a,Times(b,x)))),-1)),x),x))),And(FreeQ(List(a,b,c),x),Not(LtQ(p,CN1)))));
IIntegrate(6614,Int(Times(Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Times(c_DEFAULT,ProductLog(Plus(a_,Times(b_DEFAULT,x_)))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Power(Power(b,Plus(m,C1)),-1),Subst(Int(ExpandIntegrand(Power(Times(c,ProductLog(x)),p),Power(Plus(Times(b,e),Times(CN1,a,f),Times(f,x)),m),x),x),x,Plus(a,Times(b,x))),x),And(FreeQ(List(a,b,c,e,f,p),x),IGtQ(m,C0))));
IIntegrate(6615,Int(Power(Times(c_DEFAULT,ProductLog(Times(a_DEFAULT,Power(x_,n_)))),p_DEFAULT),x_Symbol),
    Condition(Plus(Simp(Times(x,Power(Times(c,ProductLog(Times(a,Power(x,n)))),p)),x),Negate(Dist(Times(n,p),Int(Times(Power(Times(c,ProductLog(Times(a,Power(x,n)))),p),Power(Plus(C1,ProductLog(Times(a,Power(x,n)))),-1)),x),x))),And(FreeQ(List(a,c,n,p),x),Or(EqQ(Times(n,Plus(p,Negate(C1))),CN1),And(IntegerQ(Plus(p,Negate(C1D2))),EqQ(Times(n,Plus(p,Negate(C1D2))),CN1))))));
IIntegrate(6616,Int(Power(Times(c_DEFAULT,ProductLog(Times(a_DEFAULT,Power(x_,n_)))),p_DEFAULT),x_Symbol),
    Condition(Plus(Simp(Times(x,Power(Times(c,ProductLog(Times(a,Power(x,n)))),p),Power(Plus(Times(n,p),C1),-1)),x),Dist(Times(n,p,Power(Times(c,Plus(Times(n,p),C1)),-1)),Int(Times(Power(Times(c,ProductLog(Times(a,Power(x,n)))),Plus(p,C1)),Power(Plus(C1,ProductLog(Times(a,Power(x,n)))),-1)),x),x)),And(FreeQ(List(a,c,n),x),Or(And(IntegerQ(p),EqQ(Times(n,Plus(p,C1)),CN1)),And(IntegerQ(Plus(p,Negate(C1D2))),EqQ(Times(n,Plus(p,C1D2)),CN1))))));
IIntegrate(6617,Int(Power(Times(c_DEFAULT,ProductLog(Times(a_DEFAULT,Power(x_,n_)))),p_DEFAULT),x_Symbol),
    Condition(Negate(Subst(Int(Times(Power(Times(c,ProductLog(Times(a,Power(Power(x,n),-1)))),p),Power(x,-2)),x),x,Power(x,-1))),And(FreeQ(List(a,c,p),x),ILtQ(n,C0))));
IIntegrate(6618,Int(Times(Power(x_,m_DEFAULT),Power(Times(c_DEFAULT,ProductLog(Times(a_DEFAULT,Power(x_,n_DEFAULT)))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(x,Plus(m,C1)),Power(Times(c,ProductLog(Times(a,Power(x,n)))),p),Power(Plus(m,C1),-1)),x),Negate(Dist(Times(n,p,Power(Plus(m,C1),-1)),Int(Times(Power(x,m),Power(Times(c,ProductLog(Times(a,Power(x,n)))),p),Power(Plus(C1,ProductLog(Times(a,Power(x,n)))),-1)),x),x))),And(FreeQ(List(a,c,m,n,p),x),NeQ(m,CN1),Or(And(IntegerQ(Plus(p,Negate(C1D2))),IGtQ(Times(C2,Simplify(Plus(p,Times(Plus(m,C1),Power(n,-1))))),C0)),And(Not(IntegerQ(Plus(p,Negate(C1D2)))),IGtQ(Plus(Simplify(Plus(p,Times(Plus(m,C1),Power(n,-1)))),C1),C0))))));
IIntegrate(6619,Int(Times(Power(x_,m_DEFAULT),Power(Times(c_DEFAULT,ProductLog(Times(a_DEFAULT,Power(x_,n_DEFAULT)))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(x,Plus(m,C1)),Power(Times(c,ProductLog(Times(a,Power(x,n)))),p),Power(Plus(m,Times(n,p),C1),-1)),x),Dist(Times(n,p,Power(Times(c,Plus(m,Times(n,p),C1)),-1)),Int(Times(Power(x,m),Power(Times(c,ProductLog(Times(a,Power(x,n)))),Plus(p,C1)),Power(Plus(C1,ProductLog(Times(a,Power(x,n)))),-1)),x),x)),And(FreeQ(List(a,c,m,n,p),x),Or(EqQ(m,CN1),And(IntegerQ(Plus(p,Negate(C1D2))),ILtQ(Plus(Simplify(Plus(p,Times(Plus(m,C1),Power(n,-1)))),Negate(C1D2)),C0)),And(Not(IntegerQ(Plus(p,Negate(C1D2)))),ILtQ(Simplify(Plus(p,Times(Plus(m,C1),Power(n,-1)))),C0))))));
IIntegrate(6620,Int(Times(Power(x_,m_DEFAULT),Power(Times(c_DEFAULT,ProductLog(Times(a_DEFAULT,x_))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Int(Times(Power(x,m),Power(Times(c,ProductLog(Times(a,x))),p),Power(Plus(C1,ProductLog(Times(a,x))),-1)),x),Dist(Power(c,-1),Int(Times(Power(x,m),Power(Times(c,ProductLog(Times(a,x))),Plus(p,C1)),Power(Plus(C1,ProductLog(Times(a,x))),-1)),x),x)),FreeQ(List(a,c,m),x)));
IIntegrate(6621,Int(Times(Power(x_,m_DEFAULT),Power(Times(c_DEFAULT,ProductLog(Times(a_DEFAULT,Power(x_,n_)))),p_DEFAULT)),x_Symbol),
    Condition(Negate(Subst(Int(Times(Power(Times(c,ProductLog(Times(a,Power(Power(x,n),-1)))),p),Power(Power(x,Plus(m,C2)),-1)),x),x,Power(x,-1))),And(FreeQ(List(a,c,p),x),ILtQ(n,C0),IntegerQ(m),NeQ(m,CN1))));
IIntegrate(6622,Int(Power(Plus(d_,Times(d_DEFAULT,ProductLog(Plus(a_DEFAULT,Times(b_DEFAULT,x_))))),-1),x_Symbol),
    Condition(Simp(Times(Plus(a,Times(b,x)),Power(Times(b,d,ProductLog(Plus(a,Times(b,x)))),-1)),x),FreeQ(List(a,b,d),x)));
IIntegrate(6623,Int(Times(ProductLog(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),Power(Plus(d_,Times(d_DEFAULT,ProductLog(Plus(a_DEFAULT,Times(b_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Plus(Simp(Times(d,x),x),Negate(Int(Power(Plus(d,Times(d,ProductLog(Plus(a,Times(b,x))))),-1),x))),FreeQ(List(a,b,d),x)));
IIntegrate(6624,Int(Times(Power(Times(c_DEFAULT,ProductLog(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),p_),Power(Plus(d_,Times(d_DEFAULT,ProductLog(Plus(a_DEFAULT,Times(b_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Plus(Simp(Times(c,Plus(a,Times(b,x)),Power(Times(c,ProductLog(Plus(a,Times(b,x)))),Plus(p,Negate(C1))),Power(Times(b,d),-1)),x),Negate(Dist(Times(c,p),Int(Times(Power(Times(c,ProductLog(Plus(a,Times(b,x)))),Plus(p,Negate(C1))),Power(Plus(d,Times(d,ProductLog(Plus(a,Times(b,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d),x),GtQ(p,C0))));
IIntegrate(6625,Int(Times(Power(ProductLog(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),-1),Power(Plus(d_,Times(d_DEFAULT,ProductLog(Plus(a_DEFAULT,Times(b_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Simp(Times(ExpIntegralEi(ProductLog(Plus(a,Times(b,x)))),Power(Times(b,d),-1)),x),FreeQ(List(a,b,d),x)));
IIntegrate(6626,Int(Times(Power(Times(c_DEFAULT,ProductLog(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),CN1D2),Power(Plus(d_,Times(d_DEFAULT,ProductLog(Plus(a_DEFAULT,Times(b_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Simp(Times(Rt(Times(Pi,c),C2),Erfi(Times(Sqrt(Times(c,ProductLog(Plus(a,Times(b,x))))),Power(Rt(c,C2),-1))),Power(Times(b,c,d),-1)),x),And(FreeQ(List(a,b,c,d),x),PosQ(c))));
IIntegrate(6627,Int(Times(Power(Times(c_DEFAULT,ProductLog(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),CN1D2),Power(Plus(d_,Times(d_DEFAULT,ProductLog(Plus(a_DEFAULT,Times(b_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Simp(Times(Rt(Times(CN1,Pi,c),C2),Erf(Times(Sqrt(Times(c,ProductLog(Plus(a,Times(b,x))))),Power(Rt(Negate(c),C2),-1))),Power(Times(b,c,d),-1)),x),And(FreeQ(List(a,b,c,d),x),NegQ(c))));
IIntegrate(6628,Int(Times(Power(Times(c_DEFAULT,ProductLog(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),p_),Power(Plus(d_,Times(d_DEFAULT,ProductLog(Plus(a_DEFAULT,Times(b_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Plus(Simp(Times(Plus(a,Times(b,x)),Power(Times(c,ProductLog(Plus(a,Times(b,x)))),p),Power(Times(b,d,Plus(p,C1)),-1)),x),Negate(Dist(Power(Times(c,Plus(p,C1)),-1),Int(Times(Power(Times(c,ProductLog(Plus(a,Times(b,x)))),Plus(p,C1)),Power(Plus(d,Times(d,ProductLog(Plus(a,Times(b,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d),x),LtQ(p,CN1))));
IIntegrate(6629,Int(Times(Power(Times(c_DEFAULT,ProductLog(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),p_DEFAULT),Power(Plus(d_,Times(d_DEFAULT,ProductLog(Plus(a_DEFAULT,Times(b_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Simp(Times(Gamma(Plus(p,C1),Negate(ProductLog(Plus(a,Times(b,x))))),Power(Times(c,ProductLog(Plus(a,Times(b,x)))),p),Power(Times(b,d,Power(Negate(ProductLog(Plus(a,Times(b,x)))),p)),-1)),x),FreeQ(List(a,b,c,d,p),x)));
IIntegrate(6630,Int(Times(Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Plus(d_,Times(d_DEFAULT,ProductLog(Plus(a_,Times(b_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Dist(Power(Power(b,Plus(m,C1)),-1),Subst(Int(ExpandIntegrand(Power(Plus(d,Times(d,ProductLog(x))),-1),Power(Plus(Times(b,e),Times(CN1,a,f),Times(f,x)),m),x),x),x,Plus(a,Times(b,x))),x),And(FreeQ(List(a,b,d,e,f),x),IGtQ(m,C0))));
IIntegrate(6631,Int(Times(Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),Power(Times(c_DEFAULT,ProductLog(Plus(a_,Times(b_DEFAULT,x_)))),p_DEFAULT),Power(Plus(d_,Times(d_DEFAULT,ProductLog(Plus(a_,Times(b_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Dist(Power(Power(b,Plus(m,C1)),-1),Subst(Int(ExpandIntegrand(Times(Power(Times(c,ProductLog(x)),p),Power(Plus(d,Times(d,ProductLog(x))),-1)),Power(Plus(Times(b,e),Times(CN1,a,f),Times(f,x)),m),x),x),x,Plus(a,Times(b,x))),x),And(FreeQ(List(a,b,c,d,e,f,p),x),IGtQ(m,C0))));
IIntegrate(6632,Int(Power(Plus(d_,Times(d_DEFAULT,ProductLog(Times(a_DEFAULT,Power(x_,n_))))),-1),x_Symbol),
    Condition(Negate(Subst(Int(Power(Times(Sqr(x),Plus(d,Times(d,ProductLog(Times(a,Power(Power(x,n),-1)))))),-1),x),x,Power(x,-1))),And(FreeQ(List(a,d),x),ILtQ(n,C0))));
IIntegrate(6633,Int(Times(Power(Times(c_DEFAULT,ProductLog(Times(a_DEFAULT,Power(x_,n_DEFAULT)))),p_DEFAULT),Power(Plus(d_,Times(d_DEFAULT,ProductLog(Times(a_DEFAULT,Power(x_,n_DEFAULT))))),-1)),x_Symbol),
    Condition(Simp(Times(c,x,Power(Times(c,ProductLog(Times(a,Power(x,n)))),Plus(p,Negate(C1))),Power(d,-1)),x),And(FreeQ(List(a,c,d,n,p),x),EqQ(Times(n,Plus(p,Negate(C1))),CN1))));
IIntegrate(6634,Int(Times(Power(ProductLog(Times(a_DEFAULT,Power(x_,n_DEFAULT))),p_DEFAULT),Power(Plus(d_,Times(d_DEFAULT,ProductLog(Times(a_DEFAULT,Power(x_,n_DEFAULT))))),-1)),x_Symbol),
    Condition(Simp(Times(Power(a,p),ExpIntegralEi(Times(CN1,p,ProductLog(Times(a,Power(x,n))))),Power(Times(d,n),-1)),x),And(FreeQ(List(a,d),x),IntegerQ(p),EqQ(Times(n,p),CN1))));
IIntegrate(6635,Int(Times(Power(Times(c_DEFAULT,ProductLog(Times(a_DEFAULT,Power(x_,n_DEFAULT)))),p_),Power(Plus(d_,Times(d_DEFAULT,ProductLog(Times(a_DEFAULT,Power(x_,n_DEFAULT))))),-1)),x_Symbol),
    Condition(Simp(Times(Rt(Times(Pi,c,n),C2),Erfi(Times(Sqrt(Times(c,ProductLog(Times(a,Power(x,n))))),Power(Rt(Times(c,n),C2),-1))),Power(Times(d,n,Power(a,Power(n,-1)),Power(c,Power(n,-1))),-1)),x),And(FreeQ(List(a,c,d),x),IntegerQ(Power(n,-1)),EqQ(p,Plus(C1D2,Negate(Power(n,-1)))),PosQ(Times(c,n)))));
IIntegrate(6636,Int(Times(Power(Times(c_DEFAULT,ProductLog(Times(a_DEFAULT,Power(x_,n_DEFAULT)))),p_),Power(Plus(d_,Times(d_DEFAULT,ProductLog(Times(a_DEFAULT,Power(x_,n_DEFAULT))))),-1)),x_Symbol),
    Condition(Simp(Times(Rt(Times(CN1,Pi,c,n),C2),Erf(Times(Sqrt(Times(c,ProductLog(Times(a,Power(x,n))))),Power(Rt(Times(CN1,c,n),C2),-1))),Power(Times(d,n,Power(a,Power(n,-1)),Power(c,Power(n,-1))),-1)),x),And(FreeQ(List(a,c,d),x),IntegerQ(Power(n,-1)),EqQ(p,Plus(C1D2,Negate(Power(n,-1)))),NegQ(Times(c,n)))));
IIntegrate(6637,Int(Times(Power(Times(c_DEFAULT,ProductLog(Times(a_DEFAULT,Power(x_,n_DEFAULT)))),p_DEFAULT),Power(Plus(d_,Times(d_DEFAULT,ProductLog(Times(a_DEFAULT,Power(x_,n_DEFAULT))))),-1)),x_Symbol),
    Condition(Plus(Simp(Times(c,x,Power(Times(c,ProductLog(Times(a,Power(x,n)))),Plus(p,Negate(C1))),Power(d,-1)),x),Negate(Dist(Times(c,Plus(Times(n,Plus(p,Negate(C1))),C1)),Int(Times(Power(Times(c,ProductLog(Times(a,Power(x,n)))),Plus(p,Negate(C1))),Power(Plus(d,Times(d,ProductLog(Times(a,Power(x,n))))),-1)),x),x))),And(FreeQ(List(a,c,d),x),GtQ(n,C0),GtQ(Plus(Times(n,Plus(p,Negate(C1))),C1),C0))));
IIntegrate(6638,Int(Times(Power(Times(c_DEFAULT,ProductLog(Times(a_DEFAULT,Power(x_,n_DEFAULT)))),p_DEFAULT),Power(Plus(d_,Times(d_DEFAULT,ProductLog(Times(a_DEFAULT,Power(x_,n_DEFAULT))))),-1)),x_Symbol),
    Condition(Plus(Simp(Times(x,Power(Times(c,ProductLog(Times(a,Power(x,n)))),p),Power(Times(d,Plus(Times(n,p),C1)),-1)),x),Negate(Dist(Power(Times(c,Plus(Times(n,p),C1)),-1),Int(Times(Power(Times(c,ProductLog(Times(a,Power(x,n)))),Plus(p,C1)),Power(Plus(d,Times(d,ProductLog(Times(a,Power(x,n))))),-1)),x),x))),And(FreeQ(List(a,c,d),x),GtQ(n,C0),LtQ(Plus(Times(n,p),C1),C0))));
IIntegrate(6639,Int(Times(Power(Times(c_DEFAULT,ProductLog(Times(a_DEFAULT,Power(x_,n_)))),p_DEFAULT),Power(Plus(d_,Times(d_DEFAULT,ProductLog(Times(a_DEFAULT,Power(x_,n_))))),-1)),x_Symbol),
    Condition(Negate(Subst(Int(Times(Power(Times(c,ProductLog(Times(a,Power(Power(x,n),-1)))),p),Power(Times(Sqr(x),Plus(d,Times(d,ProductLog(Times(a,Power(Power(x,n),-1)))))),-1)),x),x,Power(x,-1))),And(FreeQ(List(a,c,d,p),x),ILtQ(n,C0))));
IIntegrate(6640,Int(Times(Power(x_,m_DEFAULT),Power(Plus(d_,Times(d_DEFAULT,ProductLog(Times(a_DEFAULT,x_)))),-1)),x_Symbol),
    Condition(Plus(Simp(Times(Power(x,Plus(m,C1)),Power(Times(d,Plus(m,C1),ProductLog(Times(a,x))),-1)),x),Negate(Dist(Times(m,Power(Plus(m,C1),-1)),Int(Times(Power(x,m),Power(Times(ProductLog(Times(a,x)),Plus(d,Times(d,ProductLog(Times(a,x))))),-1)),x),x))),And(FreeQ(List(a,d),x),GtQ(m,C0))));
IIntegrate(6641,Int(Times(Power(x_,-1),Power(Plus(d_,Times(d_DEFAULT,ProductLog(Times(a_DEFAULT,x_)))),-1)),x_Symbol),
    Condition(Simp(Times(Log(ProductLog(Times(a,x))),Power(d,-1)),x),FreeQ(List(a,d),x)));
IIntegrate(6642,Int(Times(Power(x_,m_DEFAULT),Power(Plus(d_,Times(d_DEFAULT,ProductLog(Times(a_DEFAULT,x_)))),-1)),x_Symbol),
    Condition(Plus(Simp(Times(Power(x,Plus(m,C1)),Power(Times(d,Plus(m,C1)),-1)),x),Negate(Int(Times(Power(x,m),ProductLog(Times(a,x)),Power(Plus(d,Times(d,ProductLog(Times(a,x)))),-1)),x))),And(FreeQ(List(a,d),x),LtQ(m,CN1))));
IIntegrate(6643,Int(Times(Power(x_,m_DEFAULT),Power(Plus(d_,Times(d_DEFAULT,ProductLog(Times(a_DEFAULT,x_)))),-1)),x_Symbol),
    Condition(Simp(Times(Power(x,m),Gamma(Plus(m,C1),Times(CN1,Plus(m,C1),ProductLog(Times(a,x)))),Power(Times(a,d,Plus(m,C1),Exp(Times(m,ProductLog(Times(a,x)))),Power(Times(CN1,Plus(m,C1),ProductLog(Times(a,x))),m)),-1)),x),And(FreeQ(List(a,d,m),x),Not(IntegerQ(m)))));
IIntegrate(6644,Int(Times(Power(x_,-1),Power(Plus(d_,Times(d_DEFAULT,ProductLog(Times(a_DEFAULT,Power(x_,n_DEFAULT))))),-1)),x_Symbol),
    Condition(Simp(Times(Log(ProductLog(Times(a,Power(x,n)))),Power(Times(d,n),-1)),x),FreeQ(List(a,d,n),x)));
IIntegrate(6645,Int(Times(Power(x_,m_DEFAULT),Power(Plus(d_,Times(d_DEFAULT,ProductLog(Times(a_DEFAULT,Power(x_,n_))))),-1)),x_Symbol),
    Condition(Negate(Subst(Int(Power(Times(Power(x,Plus(m,C2)),Plus(d,Times(d,ProductLog(Times(a,Power(Power(x,n),-1)))))),-1),x),x,Power(x,-1))),And(FreeQ(List(a,d),x),IntegerQ(m),ILtQ(n,C0),NeQ(m,CN1))));
IIntegrate(6646,Int(Times(Power(x_,-1),Power(Times(c_DEFAULT,ProductLog(Times(a_DEFAULT,Power(x_,n_DEFAULT)))),p_DEFAULT),Power(Plus(d_,Times(d_DEFAULT,ProductLog(Times(a_DEFAULT,Power(x_,n_DEFAULT))))),-1)),x_Symbol),
    Condition(Simp(Times(Power(Times(c,ProductLog(Times(a,Power(x,n)))),p),Power(Times(d,n,p),-1)),x),FreeQ(List(a,c,d,n,p),x)));
IIntegrate(6647,Int(Times(Power(x_,m_DEFAULT),Power(Times(c_DEFAULT,ProductLog(Times(a_DEFAULT,Power(x_,n_DEFAULT)))),p_DEFAULT),Power(Plus(d_,Times(d_DEFAULT,ProductLog(Times(a_DEFAULT,Power(x_,n_DEFAULT))))),-1)),x_Symbol),
    Condition(Simp(Times(c,Power(x,Plus(m,C1)),Power(Times(c,ProductLog(Times(a,Power(x,n)))),Plus(p,Negate(C1))),Power(Times(d,Plus(m,C1)),-1)),x),And(FreeQ(List(a,c,d,m,n,p),x),NeQ(m,CN1),EqQ(Plus(m,Times(n,Plus(p,Negate(C1)))),CN1))));
IIntegrate(6648,Int(Times(Power(x_,m_DEFAULT),Power(ProductLog(Times(a_DEFAULT,Power(x_,n_DEFAULT))),p_DEFAULT),Power(Plus(d_,Times(d_DEFAULT,ProductLog(Times(a_DEFAULT,Power(x_,n_DEFAULT))))),-1)),x_Symbol),
    Condition(Simp(Times(Power(a,p),ExpIntegralEi(Times(CN1,p,ProductLog(Times(a,Power(x,n))))),Power(Times(d,n),-1)),x),And(FreeQ(List(a,d,m,n),x),IntegerQ(p),EqQ(Plus(m,Times(n,p)),CN1))));
IIntegrate(6649,Int(Times(Power(x_,m_DEFAULT),Power(Times(c_DEFAULT,ProductLog(Times(a_DEFAULT,Power(x_,n_DEFAULT)))),p_),Power(Plus(d_,Times(d_DEFAULT,ProductLog(Times(a_DEFAULT,Power(x_,n_DEFAULT))))),-1)),x_Symbol),
    Condition(Simp(Times(Power(a,Plus(p,Negate(C1D2))),Power(c,Plus(p,Negate(C1D2))),Rt(Times(Pi,c,Power(Plus(p,Negate(C1D2)),-1)),C2),Erf(Times(Sqrt(Times(c,ProductLog(Times(a,Power(x,n))))),Power(Rt(Times(c,Power(Plus(p,Negate(C1D2)),-1)),C2),-1))),Power(Times(d,n),-1)),x),And(FreeQ(List(a,c,d,m,n),x),NeQ(m,CN1),IntegerQ(Plus(p,Negate(C1D2))),EqQ(Plus(m,Times(n,Plus(p,Negate(C1D2)))),CN1),PosQ(Times(c,Power(Plus(p,Negate(C1D2)),-1))))));
IIntegrate(6650,Int(Times(Power(x_,m_DEFAULT),Power(Times(c_DEFAULT,ProductLog(Times(a_DEFAULT,Power(x_,n_DEFAULT)))),p_),Power(Plus(d_,Times(d_DEFAULT,ProductLog(Times(a_DEFAULT,Power(x_,n_DEFAULT))))),-1)),x_Symbol),
    Condition(Simp(Times(Power(a,Plus(p,Negate(C1D2))),Power(c,Plus(p,Negate(C1D2))),Rt(Times(CN1,Pi,c,Power(Plus(p,Negate(C1D2)),-1)),C2),Erfi(Times(Sqrt(Times(c,ProductLog(Times(a,Power(x,n))))),Power(Rt(Times(CN1,c,Power(Plus(p,Negate(C1D2)),-1)),C2),-1))),Power(Times(d,n),-1)),x),And(FreeQ(List(a,c,d,m,n),x),NeQ(m,CN1),IntegerQ(Plus(p,Negate(C1D2))),EqQ(Plus(m,Times(n,Plus(p,Negate(C1D2)))),CN1),NegQ(Times(c,Power(Plus(p,Negate(C1D2)),-1))))));
  }
}
}
