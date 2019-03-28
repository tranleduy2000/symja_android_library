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
public class IntRules42 { 

	public static void initialize() {
		Initializer.init();
	}

	private static class Initializer  {

		private static void init() {
IIntegrate(2101,Int(Times($p("§pm"),Power($p("§qn"),p_)),x_Symbol),
    Condition(With(List(Set(m,Expon($s("§pm"),x)),Set(n,Expon($s("§qn"),x))),Condition(Plus(Simp(Times(Coeff($s("§pm"),x,m),Power($s("§qn"),Plus(p,C1)),Power(Times(n,Plus(p,C1),Coeff($s("§qn"),x,n)),-1)),x),Dist(Power(Times(n,Coeff($s("§qn"),x,n)),-1),Int(Times(ExpandToSum(Plus(Times(n,Coeff($s("§qn"),x,n),$s("§pm")),Times(CN1,Coeff($s("§pm"),x,m),D($s("§qn"),x))),x),Power($s("§qn"),p)),x),x)),EqQ(m,Plus(n,Negate(C1))))),And(FreeQ(p,x),PolyQ($s("§pm"),x),PolyQ($s("§qn"),x),NeQ(p,CN1))));
IIntegrate(2102,Int(Times($p("§pm"),Power($p("§qn"),p_DEFAULT)),x_Symbol),
    Condition(With(List(Set(m,Expon($s("§pm"),x)),Set(n,Expon($s("§qn"),x))),Condition(Plus(Simp(Times(Coeff($s("§pm"),x,m),Power(x,Plus(m,Negate(n),C1)),Power($s("§qn"),Plus(p,C1)),Power(Times(Plus(m,Times(n,p),C1),Coeff($s("§qn"),x,n)),-1)),x),Dist(Power(Times(Plus(m,Times(n,p),C1),Coeff($s("§qn"),x,n)),-1),Int(Times(ExpandToSum(Plus(Times(Plus(m,Times(n,p),C1),Coeff($s("§qn"),x,n),$s("§pm")),Times(CN1,Coeff($s("§pm"),x,m),Power(x,Plus(m,Negate(n))),Plus(Times(Plus(m,Negate(n),C1),$s("§qn")),Times(Plus(p,C1),x,D($s("§qn"),x))))),x),Power($s("§qn"),p)),x),x)),And(LtQ(C1,n,Plus(m,C1)),Less(Plus(m,Times(n,p),C1),C0)))),And(FreeQ(p,x),PolyQ($s("§pm"),x),PolyQ($s("§qn"),x),LtQ(p,CN1))));
IIntegrate(2103,Int(Times(u_,Power(Plus(Times(e_DEFAULT,Sqrt(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),Times(f_DEFAULT,Sqrt(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Plus(Dist(Times(c,Power(Times(e,Plus(Times(b,c),Times(CN1,a,d))),-1)),Int(Times(u,Sqrt(Plus(a,Times(b,x))),Power(x,-1)),x),x),Negate(Dist(Times(a,Power(Times(f,Plus(Times(b,c),Times(CN1,a,d))),-1)),Int(Times(u,Sqrt(Plus(c,Times(d,x))),Power(x,-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),EqQ(Plus(Times(a,Sqr(e)),Times(CN1,c,Sqr(f))),C0))));
IIntegrate(2104,Int(Times(u_,Power(Plus(Times(e_DEFAULT,Sqrt(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),Times(f_DEFAULT,Sqrt(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Plus(Negate(Dist(Times(d,Power(Times(e,Plus(Times(b,c),Times(CN1,a,d))),-1)),Int(Times(u,Sqrt(Plus(a,Times(b,x)))),x),x)),Dist(Times(b,Power(Times(f,Plus(Times(b,c),Times(CN1,a,d))),-1)),Int(Times(u,Sqrt(Plus(c,Times(d,x)))),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),EqQ(Plus(Times(b,Sqr(e)),Times(CN1,d,Sqr(f))),C0))));
IIntegrate(2105,Int(Times(u_,Power(Plus(Times(e_DEFAULT,Sqrt(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),Times(f_DEFAULT,Sqrt(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),-1)),x_Symbol),
    Condition(Plus(Dist(e,Int(Times(u,Sqrt(Plus(a,Times(b,x))),Power(Plus(Times(a,Sqr(e)),Times(CN1,c,Sqr(f)),Times(Plus(Times(b,Sqr(e)),Times(CN1,d,Sqr(f))),x)),-1)),x),x),Negate(Dist(f,Int(Times(u,Sqrt(Plus(c,Times(d,x))),Power(Plus(Times(a,Sqr(e)),Times(CN1,c,Sqr(f)),Times(Plus(Times(b,Sqr(e)),Times(CN1,d,Sqr(f))),x)),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Plus(Times(a,Sqr(e)),Times(CN1,c,Sqr(f))),C0),NeQ(Plus(Times(b,Sqr(e)),Times(CN1,d,Sqr(f))),C0))));
IIntegrate(2106,Int(Times(u_DEFAULT,Power(Plus(Times(d_DEFAULT,Power(x_,n_DEFAULT)),Times(c_DEFAULT,Sqrt(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,p_DEFAULT)))))),-1)),x_Symbol),
    Condition(Plus(Negate(Dist(Times(b,Power(Times(a,d),-1)),Int(Times(u,Power(x,n)),x),x)),Dist(Power(Times(a,c),-1),Int(Times(u,Sqrt(Plus(a,Times(b,Power(x,Times(C2,n)))))),x),x)),And(FreeQ(List(a,b,c,d,n),x),EqQ(p,Times(C2,n)),EqQ(Plus(Times(b,Sqr(c)),Negate(Sqr(d))),C0))));
IIntegrate(2107,Int(Times(Power(x_,m_DEFAULT),Power(Plus(Times(d_DEFAULT,Power(x_,n_DEFAULT)),Times(c_DEFAULT,Sqrt(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,p_DEFAULT)))))),-1)),x_Symbol),
    Condition(Plus(Negate(Dist(d,Int(Times(Power(x,Plus(m,n)),Power(Plus(Times(a,Sqr(c)),Times(Plus(Times(b,Sqr(c)),Negate(Sqr(d))),Power(x,Times(C2,n)))),-1)),x),x)),Dist(c,Int(Times(Power(x,m),Sqrt(Plus(a,Times(b,Power(x,Times(C2,n))))),Power(Plus(Times(a,Sqr(c)),Times(Plus(Times(b,Sqr(c)),Negate(Sqr(d))),Power(x,Times(C2,n)))),-1)),x),x)),And(FreeQ(List(a,b,c,d,m,n),x),EqQ(p,Times(C2,n)),NeQ(Plus(Times(b,Sqr(c)),Negate(Sqr(d))),C0))));
IIntegrate(2108,Int(Times(Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_),Times(f_DEFAULT,Sqr(x_))),CN1D2),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),-1)),x_Symbol),
    Condition(With(List(Set(r,Numerator(Rt(Times(a,Power(b,-1)),C3))),Set(s,Denominator(Rt(Times(a,Power(b,-1)),C3)))),Plus(Dist(Times(r,Power(Times(C3,a),-1)),Int(Power(Times(Plus(r,Times(s,x)),Sqrt(Plus(d,Times(e,x),Times(f,Sqr(x))))),-1),x),x),Dist(Times(r,Power(Times(C3,a),-1)),Int(Times(Plus(Times(C2,r),Times(CN1,s,x)),Power(Times(Plus(Sqr(r),Times(CN1,r,s,x),Times(Sqr(s),Sqr(x))),Sqrt(Plus(d,Times(e,x),Times(f,Sqr(x))))),-1)),x),x))),And(FreeQ(List(a,b,d,e,f),x),PosQ(Times(a,Power(b,-1))))));
IIntegrate(2109,Int(Times(Power(Plus(d_DEFAULT,Times(f_DEFAULT,Sqr(x_))),CN1D2),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),-1)),x_Symbol),
    Condition(With(List(Set(r,Numerator(Rt(Times(a,Power(b,-1)),C3))),Set(s,Denominator(Rt(Times(a,Power(b,-1)),C3)))),Plus(Dist(Times(r,Power(Times(C3,a),-1)),Int(Power(Times(Plus(r,Times(s,x)),Sqrt(Plus(d,Times(f,Sqr(x))))),-1),x),x),Dist(Times(r,Power(Times(C3,a),-1)),Int(Times(Plus(Times(C2,r),Times(CN1,s,x)),Power(Times(Plus(Sqr(r),Times(CN1,r,s,x),Times(Sqr(s),Sqr(x))),Sqrt(Plus(d,Times(f,Sqr(x))))),-1)),x),x))),And(FreeQ(List(a,b,d,f),x),PosQ(Times(a,Power(b,-1))))));
IIntegrate(2110,Int(Times(Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_),Times(f_DEFAULT,Sqr(x_))),CN1D2),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),-1)),x_Symbol),
    Condition(With(List(Set(r,Numerator(Rt(Times(CN1,a,Power(b,-1)),C3))),Set(s,Denominator(Rt(Times(CN1,a,Power(b,-1)),C3)))),Plus(Dist(Times(r,Power(Times(C3,a),-1)),Int(Power(Times(Plus(r,Times(CN1,s,x)),Sqrt(Plus(d,Times(e,x),Times(f,Sqr(x))))),-1),x),x),Dist(Times(r,Power(Times(C3,a),-1)),Int(Times(Plus(Times(C2,r),Times(s,x)),Power(Times(Plus(Sqr(r),Times(r,s,x),Times(Sqr(s),Sqr(x))),Sqrt(Plus(d,Times(e,x),Times(f,Sqr(x))))),-1)),x),x))),And(FreeQ(List(a,b,d,e,f),x),NegQ(Times(a,Power(b,-1))))));
IIntegrate(2111,Int(Times(Power(Plus(d_DEFAULT,Times(f_DEFAULT,Sqr(x_))),CN1D2),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),-1)),x_Symbol),
    Condition(With(List(Set(r,Numerator(Rt(Times(CN1,a,Power(b,-1)),C3))),Set(s,Denominator(Rt(Times(CN1,a,Power(b,-1)),C3)))),Plus(Dist(Times(r,Power(Times(C3,a),-1)),Int(Power(Times(Plus(r,Times(CN1,s,x)),Sqrt(Plus(d,Times(f,Sqr(x))))),-1),x),x),Dist(Times(r,Power(Times(C3,a),-1)),Int(Times(Plus(Times(C2,r),Times(s,x)),Power(Times(Plus(Sqr(r),Times(r,s,x),Times(Sqr(s),Sqr(x))),Sqrt(Plus(d,Times(f,Sqr(x))))),-1)),x),x))),And(FreeQ(List(a,b,d,f),x),NegQ(Times(a,Power(b,-1))))));
IIntegrate(2112,Int(Times(u_,Power(v_,CN1D2),Plus(A_,Times(B_DEFAULT,Power(x_,4)))),x_Symbol),
    Condition(With(List(Set(a,Coeff(v,x,C0)),Set(b,Coeff(v,x,C2)),Set(c,Coeff(v,x,C4)),Set(d,Coeff(Power(u,-1),x,C0)),Set(e,Coeff(Power(u,-1),x,C2)),Set(f,Coeff(Power(u,-1),x,C4))),Condition(Dist(ASymbol,Subst(Int(Power(Plus(d,Times(CN1,Plus(Times(b,d),Times(CN1,a,e)),Sqr(x))),-1),x),x,Times(x,Power(v,CN1D2))),x),And(EqQ(Plus(Times(a,BSymbol),Times(ASymbol,c)),C0),EqQ(Plus(Times(c,d),Times(CN1,a,f)),C0)))),And(FreeQ(List(ASymbol,BSymbol),x),PolyQ(v,Sqr(x),C2),PolyQ(Power(u,-1),Sqr(x),C2))));
IIntegrate(2113,Int(Times(Power(Plus(a_,Times(b_DEFAULT,x_)),-1),Power(Plus(c_,Times(d_DEFAULT,Sqr(x_))),CN1D2),Power(Plus(e_,Times(f_DEFAULT,Sqr(x_))),CN1D2)),x_Symbol),
    Condition(Plus(Dist(a,Int(Power(Times(Plus(Sqr(a),Times(CN1,Sqr(b),Sqr(x))),Sqrt(Plus(c,Times(d,Sqr(x)))),Sqrt(Plus(e,Times(f,Sqr(x))))),-1),x),x),Negate(Dist(b,Int(Times(x,Power(Times(Plus(Sqr(a),Times(CN1,Sqr(b),Sqr(x))),Sqrt(Plus(c,Times(d,Sqr(x)))),Sqrt(Plus(e,Times(f,Sqr(x))))),-1)),x),x))),FreeQ(List(a,b,c,d,e,f),x)));
IIntegrate(2114,Int(Times(Plus(g_DEFAULT,Times(h_DEFAULT,x_)),Sqrt(Plus(d_DEFAULT,Times(e_DEFAULT,x_),Times(f_DEFAULT,Sqrt(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_)))))))),x_Symbol),
    Condition(Simp(Times(C2,Plus(Times(f,Plus(Times(C5,b,c,Sqr(g)),Times(CN1,C2,Sqr(b),g,h),Times(CN1,C3,a,c,g,h),Times(C2,a,b,Sqr(h)))),Times(c,f,Plus(Times(C10,c,Sqr(g)),Times(CN1,b,g,h),Times(a,Sqr(h))),x),Times(C9,Sqr(c),f,g,h,Sqr(x)),Times(C3,Sqr(c),f,Sqr(h),Power(x,3)),Times(CN1,Plus(Times(e,g),Times(CN1,d,h)),Plus(Times(C5,c,g),Times(CN1,C2,b,h),Times(c,h,x)),Sqrt(Plus(a,Times(b,x),Times(c,Sqr(x)))))),Sqrt(Plus(d,Times(e,x),Times(f,Sqrt(Plus(a,Times(b,x),Times(c,Sqr(x))))))),Power(Times(ZZ(15L),Sqr(c),f,Plus(g,Times(h,x))),-1)),x),And(FreeQ(List(a,b,c,d,e,f,g,h),x),EqQ(Plus(Sqr(Plus(Times(e,g),Times(CN1,d,h))),Times(CN1,Sqr(f),Plus(Times(c,Sqr(g)),Times(CN1,b,g,h),Times(a,Sqr(h))))),C0),EqQ(Plus(Times(C2,Sqr(e),g),Times(CN1,C2,d,e,h),Times(CN1,Sqr(f),Plus(Times(C2,c,g),Times(CN1,b,h)))),C0))));
IIntegrate(2115,Int(Times(Power(Plus(u_,Times(f_DEFAULT,Plus(j_DEFAULT,Times(k_DEFAULT,Sqrt(v_))))),n_DEFAULT),Power(Plus(g_DEFAULT,Times(h_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(Plus(g,Times(h,x)),m),Power(Plus(ExpandToSum(Plus(u,Times(f,j)),x),Times(f,k,Sqrt(ExpandToSum(v,x)))),n)),x),And(FreeQ(List(f,g,h,j,k,m,n),x),LinearQ(u,x),QuadraticQ(v,x),Not(And(LinearMatchQ(u,x),QuadraticMatchQ(v,x),Or(EqQ(j,C0),EqQ(f,C1)))),EqQ(Plus(Sqr(Plus(Times(Coefficient(u,x,C1),g),Times(CN1,h,Plus(Coefficient(u,x,C0),Times(f,j))))),Times(CN1,Sqr(f),Sqr(k),Plus(Times(Coefficient(v,x,C2),Sqr(g)),Times(CN1,Coefficient(v,x,C1),g,h),Times(Coefficient(v,x,C0),Sqr(h))))),C0))));
IIntegrate(2116,Int(Power(Plus(g_DEFAULT,Times(h_DEFAULT,Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_),Times(f_DEFAULT,Sqrt(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_)))))),n_))),p_DEFAULT),x_Symbol),
    Condition(Dist(C2,Subst(Int(Times(Power(Plus(g,Times(h,Power(x,n))),p),Plus(Times(Sqr(d),e),Times(CN1,Plus(Times(b,d),Times(CN1,a,e)),Sqr(f)),Times(CN1,Plus(Times(C2,d,e),Times(CN1,b,Sqr(f))),x),Times(e,Sqr(x))),Power(Plus(Times(CN2,d,e),Times(b,Sqr(f)),Times(C2,e,x)),-2)),x),x,Plus(d,Times(e,x),Times(f,Sqrt(Plus(a,Times(b,x),Times(c,Sqr(x))))))),x),And(FreeQ(List(a,b,c,d,e,f,g,h,n),x),EqQ(Plus(Sqr(e),Times(CN1,c,Sqr(f))),C0),IntegerQ(p))));
IIntegrate(2117,Int(Power(Plus(g_DEFAULT,Times(h_DEFAULT,Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_),Times(f_DEFAULT,Sqrt(Plus(a_,Times(c_DEFAULT,Sqr(x_)))))),n_))),p_DEFAULT),x_Symbol),
    Condition(Dist(Power(Times(C2,e),-1),Subst(Int(Times(Power(Plus(g,Times(h,Power(x,n))),p),Plus(Sqr(d),Times(a,Sqr(f)),Times(CN1,C2,d,x),Sqr(x)),Power(Plus(d,Negate(x)),-2)),x),x,Plus(d,Times(e,x),Times(f,Sqrt(Plus(a,Times(c,Sqr(x))))))),x),And(FreeQ(List(a,c,d,e,f,g,h,n),x),EqQ(Plus(Sqr(e),Times(CN1,c,Sqr(f))),C0),IntegerQ(p))));
IIntegrate(2118,Int(Power(Plus(g_DEFAULT,Times(h_DEFAULT,Power(Plus(u_,Times(f_DEFAULT,Sqrt(v_))),n_))),p_DEFAULT),x_Symbol),
    Condition(Int(Power(Plus(g,Times(h,Power(Plus(ExpandToSum(u,x),Times(f,Sqrt(ExpandToSum(v,x)))),n))),p),x),And(FreeQ(List(f,g,h,n),x),LinearQ(u,x),QuadraticQ(v,x),Not(And(LinearMatchQ(u,x),QuadraticMatchQ(v,x))),EqQ(Plus(Sqr(Coefficient(u,x,C1)),Times(CN1,Coefficient(v,x,C2),Sqr(f))),C0),IntegerQ(p))));
IIntegrate(2119,Int(Times(Power(Plus(g_DEFAULT,Times(h_DEFAULT,x_)),m_DEFAULT),Power(Plus(Times(e_DEFAULT,x_),Times(f_DEFAULT,Sqrt(Plus(a_DEFAULT,Times(c_DEFAULT,Sqr(x_)))))),n_DEFAULT)),x_Symbol),
    Condition(Dist(Power(Times(Power(C2,Plus(m,C1)),Power(e,Plus(m,C1))),-1),Subst(Int(Times(Power(x,Plus(n,Negate(m),Negate(C2))),Plus(Times(a,Sqr(f)),Sqr(x)),Power(Plus(Times(CN1,a,Sqr(f),h),Times(C2,e,g,x),Times(h,Sqr(x))),m)),x),x,Plus(Times(e,x),Times(f,Sqrt(Plus(a,Times(c,Sqr(x))))))),x),And(FreeQ(List(a,c,e,f,g,h,n),x),EqQ(Plus(Sqr(e),Times(CN1,c,Sqr(f))),C0),IntegerQ(m))));
IIntegrate(2120,Int(Times(Power(x_,p_DEFAULT),Power(Plus(g_,Times(i_DEFAULT,Sqr(x_))),m_DEFAULT),Power(Plus(Times(e_DEFAULT,x_),Times(f_DEFAULT,Sqrt(Plus(a_,Times(c_DEFAULT,Sqr(x_)))))),n_DEFAULT)),x_Symbol),
    Condition(Dist(Times(C1,Power(Times(i,Power(c,-1)),m),Power(Times(Power(C2,Plus(Times(C2,m),p,C1)),Power(e,Plus(p,C1)),Power(f,Times(C2,m))),-1)),Subst(Int(Times(Power(x,Plus(n,Times(CN1,C2,m),Negate(p),Negate(C2))),Power(Plus(Times(CN1,a,Sqr(f)),Sqr(x)),p),Power(Plus(Times(a,Sqr(f)),Sqr(x)),Plus(Times(C2,m),C1))),x),x,Plus(Times(e,x),Times(f,Sqrt(Plus(a,Times(c,Sqr(x))))))),x),And(FreeQ(List(a,c,e,f,g,i,n),x),EqQ(Plus(Sqr(e),Times(CN1,c,Sqr(f))),C0),EqQ(Plus(Times(c,g),Times(CN1,a,i)),C0),IntegersQ(p,Times(C2,m)),Or(IntegerQ(m),GtQ(Times(i,Power(c,-1)),C0)))));
IIntegrate(2121,Int(Times(Power(Plus(g_DEFAULT,Times(h_DEFAULT,x_),Times(i_DEFAULT,Sqr(x_))),m_DEFAULT),Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_),Times(f_DEFAULT,Sqrt(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_)))))),n_DEFAULT)),x_Symbol),
    Condition(Dist(Times(C2,Power(Times(i,Power(c,-1)),m),Power(Power(f,Times(C2,m)),-1)),Subst(Int(Times(Power(x,n),Power(Plus(Times(Sqr(d),e),Times(CN1,Plus(Times(b,d),Times(CN1,a,e)),Sqr(f)),Times(CN1,Plus(Times(C2,d,e),Times(CN1,b,Sqr(f))),x),Times(e,Sqr(x))),Plus(Times(C2,m),C1)),Power(Power(Plus(Times(CN2,d,e),Times(b,Sqr(f)),Times(C2,e,x)),Times(C2,Plus(m,C1))),-1)),x),x,Plus(d,Times(e,x),Times(f,Sqrt(Plus(a,Times(b,x),Times(c,Sqr(x))))))),x),And(FreeQ(List(a,b,c,d,e,f,g,h,i,n),x),EqQ(Plus(Sqr(e),Times(CN1,c,Sqr(f))),C0),EqQ(Plus(Times(c,g),Times(CN1,a,i)),C0),EqQ(Plus(Times(c,h),Times(CN1,b,i)),C0),IntegerQ(Times(C2,m)),Or(IntegerQ(m),GtQ(Times(i,Power(c,-1)),C0)))));
IIntegrate(2122,Int(Times(Power(Plus(g_,Times(i_DEFAULT,Sqr(x_))),m_DEFAULT),Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_),Times(f_DEFAULT,Sqrt(Plus(a_,Times(c_DEFAULT,Sqr(x_)))))),n_DEFAULT)),x_Symbol),
    Condition(Dist(Times(C1,Power(Times(i,Power(c,-1)),m),Power(Times(Power(C2,Plus(Times(C2,m),C1)),e,Power(f,Times(C2,m))),-1)),Subst(Int(Times(Power(x,n),Power(Plus(Sqr(d),Times(a,Sqr(f)),Times(CN1,C2,d,x),Sqr(x)),Plus(Times(C2,m),C1)),Power(Power(Plus(Negate(d),x),Times(C2,Plus(m,C1))),-1)),x),x,Plus(d,Times(e,x),Times(f,Sqrt(Plus(a,Times(c,Sqr(x))))))),x),And(FreeQ(List(a,c,d,e,f,g,i,n),x),EqQ(Plus(Sqr(e),Times(CN1,c,Sqr(f))),C0),EqQ(Plus(Times(c,g),Times(CN1,a,i)),C0),IntegerQ(Times(C2,m)),Or(IntegerQ(m),GtQ(Times(i,Power(c,-1)),C0)))));
IIntegrate(2123,Int(Times(Power(Plus(g_DEFAULT,Times(h_DEFAULT,x_),Times(i_DEFAULT,Sqr(x_))),m_DEFAULT),Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_),Times(f_DEFAULT,Sqrt(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_)))))),n_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(Times(i,Power(c,-1)),Plus(m,Negate(C1D2))),Sqrt(Plus(g,Times(h,x),Times(i,Sqr(x)))),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),CN1D2)),Int(Times(Power(Plus(a,Times(b,x),Times(c,Sqr(x))),m),Power(Plus(d,Times(e,x),Times(f,Sqrt(Plus(a,Times(b,x),Times(c,Sqr(x)))))),n)),x),x),And(FreeQ(List(a,b,c,d,e,f,g,h,i,n),x),EqQ(Plus(Sqr(e),Times(CN1,c,Sqr(f))),C0),EqQ(Plus(Times(c,g),Times(CN1,a,i)),C0),EqQ(Plus(Times(c,h),Times(CN1,b,i)),C0),IGtQ(Plus(m,C1D2),C0),Not(GtQ(Times(i,Power(c,-1)),C0)))));
IIntegrate(2124,Int(Times(Power(Plus(g_,Times(i_DEFAULT,Sqr(x_))),m_DEFAULT),Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_),Times(f_DEFAULT,Sqrt(Plus(a_,Times(c_DEFAULT,Sqr(x_)))))),n_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(Times(i,Power(c,-1)),Plus(m,Negate(C1D2))),Sqrt(Plus(g,Times(i,Sqr(x)))),Power(Plus(a,Times(c,Sqr(x))),CN1D2)),Int(Times(Power(Plus(a,Times(c,Sqr(x))),m),Power(Plus(d,Times(e,x),Times(f,Sqrt(Plus(a,Times(c,Sqr(x)))))),n)),x),x),And(FreeQ(List(a,c,d,e,f,g,i,n),x),EqQ(Plus(Sqr(e),Times(CN1,c,Sqr(f))),C0),EqQ(Plus(Times(c,g),Times(CN1,a,i)),C0),IGtQ(Plus(m,C1D2),C0),Not(GtQ(Times(i,Power(c,-1)),C0)))));
IIntegrate(2125,Int(Times(Power(Plus(g_DEFAULT,Times(h_DEFAULT,x_),Times(i_DEFAULT,Sqr(x_))),m_DEFAULT),Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_),Times(f_DEFAULT,Sqrt(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_)))))),n_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(Times(i,Power(c,-1)),Plus(m,C1D2)),Sqrt(Plus(a,Times(b,x),Times(c,Sqr(x)))),Power(Plus(g,Times(h,x),Times(i,Sqr(x))),CN1D2)),Int(Times(Power(Plus(a,Times(b,x),Times(c,Sqr(x))),m),Power(Plus(d,Times(e,x),Times(f,Sqrt(Plus(a,Times(b,x),Times(c,Sqr(x)))))),n)),x),x),And(FreeQ(List(a,b,c,d,e,f,g,h,i,n),x),EqQ(Plus(Sqr(e),Times(CN1,c,Sqr(f))),C0),EqQ(Plus(Times(c,g),Times(CN1,a,i)),C0),EqQ(Plus(Times(c,h),Times(CN1,b,i)),C0),ILtQ(Plus(m,Negate(C1D2)),C0),Not(GtQ(Times(i,Power(c,-1)),C0)))));
IIntegrate(2126,Int(Times(Power(Plus(g_,Times(i_DEFAULT,Sqr(x_))),m_DEFAULT),Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_),Times(f_DEFAULT,Sqrt(Plus(a_,Times(c_DEFAULT,Sqr(x_)))))),n_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(Times(i,Power(c,-1)),Plus(m,C1D2)),Sqrt(Plus(a,Times(c,Sqr(x)))),Power(Plus(g,Times(i,Sqr(x))),CN1D2)),Int(Times(Power(Plus(a,Times(c,Sqr(x))),m),Power(Plus(d,Times(e,x),Times(f,Sqrt(Plus(a,Times(c,Sqr(x)))))),n)),x),x),And(FreeQ(List(a,c,d,e,f,g,i,n),x),EqQ(Plus(Sqr(e),Times(CN1,c,Sqr(f))),C0),EqQ(Plus(Times(c,g),Times(CN1,a,i)),C0),ILtQ(Plus(m,Negate(C1D2)),C0),Not(GtQ(Times(i,Power(c,-1)),C0)))));
IIntegrate(2127,Int(Times(Power(Plus(u_,Times(f_DEFAULT,Plus(j_DEFAULT,Times(k_DEFAULT,Sqrt(v_))))),n_DEFAULT),Power(w_,m_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(ExpandToSum(w,x),m),Power(Plus(ExpandToSum(Plus(u,Times(f,j)),x),Times(f,k,Sqrt(ExpandToSum(v,x)))),n)),x),And(FreeQ(List(f,j,k,m,n),x),LinearQ(u,x),QuadraticQ(List(v,w),x),Not(And(LinearMatchQ(u,x),QuadraticMatchQ(List(v,w),x),Or(EqQ(j,C0),EqQ(f,C1)))),EqQ(Plus(Sqr(Coefficient(u,x,C1)),Times(CN1,Coefficient(v,x,C2),Sqr(f),Sqr(k))),C0))));
IIntegrate(2128,Int(Times(Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_DEFAULT))),-1),Power(Plus(Times(c_DEFAULT,Sqr(x_)),Times(d_DEFAULT,Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_DEFAULT))),p_DEFAULT))),CN1D2)),x_Symbol),
    Condition(Dist(Power(a,-1),Subst(Int(Power(Plus(C1,Times(CN1,c,Sqr(x))),-1),x),x,Times(x,Power(Plus(Times(c,Sqr(x)),Times(d,Power(Plus(a,Times(b,Power(x,n))),Times(C2,Power(n,-1))))),CN1D2))),x),And(FreeQ(List(a,b,c,d,n),x),EqQ(p,Times(C2,Power(n,-1))))));
IIntegrate(2129,Int(Sqrt(Plus(a_,Times(b_DEFAULT,Sqrt(Plus(c_,Times(d_DEFAULT,Sqr(x_))))))),x_Symbol),
    Condition(Plus(Simp(Times(C2,Sqr(b),d,Power(x,3),Power(Times(C3,Power(Plus(a,Times(b,Sqrt(Plus(c,Times(d,Sqr(x)))))),QQ(3L,2L))),-1)),x),Simp(Times(C2,a,x,Power(Plus(a,Times(b,Sqrt(Plus(c,Times(d,Sqr(x)))))),CN1D2)),x)),And(FreeQ(List(a,b,c,d),x),EqQ(Plus(Sqr(a),Times(CN1,Sqr(b),c)),C0))));
IIntegrate(2130,Int(Times(Power(x_,-1),Power(Plus(c_,Times(d_DEFAULT,Sqr(x_))),CN1D2),Sqrt(Plus(Times(a_DEFAULT,Sqr(x_)),Times(b_DEFAULT,x_,Sqrt(Plus(c_,Times(d_DEFAULT,Sqr(x_)))))))),x_Symbol),
    Condition(Dist(Times(CSqrt2,b,Power(a,-1)),Subst(Int(Power(Plus(C1,Times(Sqr(x),Power(a,-1))),CN1D2),x),x,Plus(Times(a,x),Times(b,Sqrt(Plus(c,Times(d,Sqr(x))))))),x),And(FreeQ(List(a,b,c,d),x),EqQ(Plus(Sqr(a),Times(CN1,Sqr(b),d)),C0),EqQ(Plus(Times(Sqr(b),c),a),C0))));
IIntegrate(2131,Int(Times(Power(x_,-1),Power(Plus(c_,Times(d_DEFAULT,Sqr(x_))),CN1D2),Sqrt(Times(e_DEFAULT,x_,Plus(Times(a_DEFAULT,x_),Times(b_DEFAULT,Sqrt(Plus(c_,Times(d_DEFAULT,Sqr(x_))))))))),x_Symbol),
    Condition(Int(Times(Sqrt(Plus(Times(a,e,Sqr(x)),Times(b,e,x,Sqrt(Plus(c,Times(d,Sqr(x))))))),Power(Times(x,Sqrt(Plus(c,Times(d,Sqr(x))))),-1)),x),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Sqr(a),Times(CN1,Sqr(b),d)),C0),EqQ(Plus(Times(Sqr(b),c,e),a),C0))));
IIntegrate(2132,Int(Times(Power(Plus(a_,Times(b_DEFAULT,Power(x_,4))),CN1D2),Sqrt(Plus(Times(c_DEFAULT,Sqr(x_)),Times(d_DEFAULT,Sqrt(Plus(a_,Times(b_DEFAULT,Power(x_,4)))))))),x_Symbol),
    Condition(Dist(d,Subst(Int(Power(Plus(C1,Times(CN1,C2,c,Sqr(x))),-1),x),x,Times(x,Power(Plus(Times(c,Sqr(x)),Times(d,Sqrt(Plus(a,Times(b,Power(x,4)))))),CN1D2))),x),And(FreeQ(List(a,b,c,d),x),EqQ(Plus(Sqr(c),Times(CN1,b,Sqr(d))),C0))));
IIntegrate(2133,Int(Times(Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),m_DEFAULT),Power(Plus(a_,Times(e_DEFAULT,Power(x_,4))),CN1D2),Sqrt(Plus(Times(b_DEFAULT,Sqr(x_)),Sqrt(Plus(a_,Times(e_DEFAULT,Power(x_,4))))))),x_Symbol),
    Condition(Plus(Dist(Times(C1D2,Plus(C1,Negate(CI))),Int(Times(Power(Plus(c,Times(d,x)),m),Power(Plus(Sqrt(a),Times(CN1,CI,b,Sqr(x))),CN1D2)),x),x),Dist(Times(C1D2,Plus(C1,CI)),Int(Times(Power(Plus(c,Times(d,x)),m),Power(Plus(Sqrt(a),Times(CI,b,Sqr(x))),CN1D2)),x),x)),And(FreeQ(List(a,b,c,d,m),x),EqQ(e,Sqr(b)),GtQ(a,C0))));
IIntegrate(2134,Int(Times(Power(Plus(c_,Times(d_DEFAULT,x_)),-1),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),CN1D2)),x_Symbol),
    Condition(Plus(Dist(Times(C2,Power(Times(C3,c),-1)),Int(Power(Plus(a,Times(b,Power(x,3))),CN1D2),x),x),Dist(Power(Times(C3,c),-1),Int(Times(Plus(c,Times(CN1,C2,d,x)),Power(Times(Plus(c,Times(d,x)),Sqrt(Plus(a,Times(b,Power(x,3))))),-1)),x),x)),And(FreeQ(List(a,b,c,d),x),EqQ(Plus(Times(b,Power(c,3)),Times(CN1,C4,a,Power(d,3))),C0))));
IIntegrate(2135,Int(Times(Power(Plus(c_,Times(d_DEFAULT,x_)),-1),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),CN1D2)),x_Symbol),
    Condition(Plus(Dist(Times(CN6,a,Power(d,3),Power(Times(c,Plus(Times(b,Power(c,3)),Times(CN1,ZZ(28L),a,Power(d,3)))),-1)),Int(Power(Plus(a,Times(b,Power(x,3))),CN1D2),x),x),Dist(Power(Times(c,Plus(Times(b,Power(c,3)),Times(CN1,ZZ(28L),a,Power(d,3)))),-1),Int(Times(Simp(Plus(Times(c,Plus(Times(b,Power(c,3)),Times(CN1,ZZ(22L),a,Power(d,3)))),Times(C6,a,Power(d,4),x)),x),Power(Times(Plus(c,Times(d,x)),Sqrt(Plus(a,Times(b,Power(x,3))))),-1)),x),x)),And(FreeQ(List(a,b,c,d),x),EqQ(Plus(Times(Sqr(b),Power(c,6)),Times(CN1,ZZ(20L),a,b,Power(c,3),Power(d,3)),Times(CN1,C8,Sqr(a),Power(d,6))),C0))));
IIntegrate(2136,Int(Times(Power(Plus(c_,Times(d_DEFAULT,x_)),-1),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),CN1D2)),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(b,Power(a,-1)),C3))),Plus(Negate(Dist(Times(q,Power(Plus(Times(Plus(C1,CSqrt3),d),Times(CN1,c,q)),-1)),Int(Power(Plus(a,Times(b,Power(x,3))),CN1D2),x),x)),Dist(Times(d,Power(Plus(Times(Plus(C1,CSqrt3),d),Times(CN1,c,q)),-1)),Int(Times(Plus(C1,CSqrt3,Times(q,x)),Power(Times(Plus(c,Times(d,x)),Sqrt(Plus(a,Times(b,Power(x,3))))),-1)),x),x))),And(FreeQ(List(a,b,c,d),x),NeQ(Plus(Times(Sqr(b),Power(c,6)),Times(CN1,ZZ(20L),a,b,Power(c,3),Power(d,3)),Times(CN1,C8,Sqr(a),Power(d,6))),C0))));
IIntegrate(2137,Int(Times(Power(Plus(c_,Times(d_DEFAULT,x_)),-1),Plus(e_,Times(f_DEFAULT,x_)),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),CN1D2)),x_Symbol),
    Condition(Dist(Times(C2,e,Power(d,-1)),Subst(Int(Power(Plus(C1,Times(C3,a,Sqr(x))),-1),x),x,Times(Plus(C1,Times(C2,d,x,Power(c,-1))),Power(Plus(a,Times(b,Power(x,3))),CN1D2))),x),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Plus(Times(d,e),Times(CN1,c,f)),C0),EqQ(Plus(Times(b,Power(c,3)),Times(CN1,C4,a,Power(d,3))),C0),EqQ(Plus(Times(C2,d,e),Times(c,f)),C0))));
IIntegrate(2138,Int(Times(Power(Plus(c_,Times(d_DEFAULT,x_)),-1),Plus(e_,Times(f_DEFAULT,x_)),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),CN1D2)),x_Symbol),
    Condition(Dist(Times(CN2,e,Power(d,-1)),Subst(Int(Power(Plus(C9,Times(CN1,a,Sqr(x))),-1),x),x,Times(Sqr(Plus(C1,Times(f,x,Power(e,-1)))),Power(Plus(a,Times(b,Power(x,3))),CN1D2))),x),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Plus(Times(d,e),Times(CN1,c,f)),C0),EqQ(Plus(Times(b,Power(c,3)),Times(C8,a,Power(d,3))),C0),EqQ(Plus(Times(C2,d,e),Times(c,f)),C0))));
IIntegrate(2139,Int(Times(Power(Plus(c_,Times(d_DEFAULT,x_)),-1),Plus(e_DEFAULT,Times(f_DEFAULT,x_)),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),CN1D2)),x_Symbol),
    Condition(Plus(Dist(Times(Plus(Times(C2,d,e),Times(c,f)),Power(Times(C3,c,d),-1)),Int(Power(Plus(a,Times(b,Power(x,3))),CN1D2),x),x),Dist(Times(Plus(Times(d,e),Times(CN1,c,f)),Power(Times(C3,c,d),-1)),Int(Times(Plus(c,Times(CN1,C2,d,x)),Power(Times(Plus(c,Times(d,x)),Sqrt(Plus(a,Times(b,Power(x,3))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Plus(Times(d,e),Times(CN1,c,f)),C0),Or(EqQ(Plus(Times(b,Power(c,3)),Times(CN1,C4,a,Power(d,3))),C0),EqQ(Plus(Times(b,Power(c,3)),Times(C8,a,Power(d,3))),C0)),NeQ(Plus(Times(C2,d,e),Times(c,f)),C0))));
IIntegrate(2140,Int(Times(Power(Plus(c_,Times(d_DEFAULT,x_)),-1),Plus(e_,Times(f_DEFAULT,x_)),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),CN1D2)),x_Symbol),
    Condition(With(List(Set(k,Simplify(Times(Plus(Times(d,e),Times(C2,c,f)),Power(Times(c,f),-1))))),Dist(Times(Plus(C1,k),e,Power(d,-1)),Subst(Int(Power(Plus(C1,Times(Plus(C3,Times(C2,k)),a,Sqr(x))),-1),x),x,Times(Plus(C1,Times(Plus(C1,k),d,x,Power(c,-1))),Power(Plus(a,Times(b,Power(x,3))),CN1D2))),x)),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Plus(Times(d,e),Times(CN1,c,f)),C0),EqQ(Plus(Times(Sqr(b),Power(c,6)),Times(CN1,ZZ(20L),a,b,Power(c,3),Power(d,3)),Times(CN1,C8,Sqr(a),Power(d,6))),C0),EqQ(Plus(Times(C6,a,Power(d,4),e),Times(CN1,c,f,Plus(Times(b,Power(c,3)),Times(CN1,ZZ(22L),a,Power(d,3))))),C0))));
IIntegrate(2141,Int(Times(Power(Plus(c_,Times(d_DEFAULT,x_)),-1),Plus(e_DEFAULT,Times(f_DEFAULT,x_)),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),CN1D2)),x_Symbol),
    Condition(Plus(Negate(Dist(Times(Plus(Times(C6,a,Power(d,4),e),Times(CN1,c,f,Plus(Times(b,Power(c,3)),Times(CN1,ZZ(22L),a,Power(d,3))))),Power(Times(c,d,Plus(Times(b,Power(c,3)),Times(CN1,ZZ(28L),a,Power(d,3)))),-1)),Int(Power(Plus(a,Times(b,Power(x,3))),CN1D2),x),x)),Dist(Times(Plus(Times(d,e),Times(CN1,c,f)),Power(Times(c,d,Plus(Times(b,Power(c,3)),Times(CN1,ZZ(28L),a,Power(d,3)))),-1)),Int(Times(Plus(Times(c,Plus(Times(b,Power(c,3)),Times(CN1,ZZ(22L),a,Power(d,3)))),Times(C6,a,Power(d,4),x)),Power(Times(Plus(c,Times(d,x)),Sqrt(Plus(a,Times(b,Power(x,3))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Plus(Times(d,e),Times(CN1,c,f)),C0),EqQ(Plus(Times(Sqr(b),Power(c,6)),Times(CN1,ZZ(20L),a,b,Power(c,3),Power(d,3)),Times(CN1,C8,Sqr(a),Power(d,6))),C0),NeQ(Plus(Times(C6,a,Power(d,4),e),Times(CN1,c,f,Plus(Times(b,Power(c,3)),Times(CN1,ZZ(22L),a,Power(d,3))))),C0))));
IIntegrate(2142,Int(Times(Power(Plus(c_,Times(d_DEFAULT,x_)),-1),Plus(e_,Times(f_DEFAULT,x_)),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),CN1D2)),x_Symbol),
    Condition(With(List(Set(q,Simplify(Times(Plus(C1,CSqrt3),f,Power(e,-1))))),Dist(Times(C4,Power(C3,C1D4),Sqrt(Plus(C2,Negate(CSqrt3))),f,Plus(C1,Times(q,x)),Sqrt(Times(Plus(C1,Times(CN1,q,x),Times(Sqr(q),Sqr(x))),Power(Plus(C1,CSqrt3,Times(q,x)),-2))),Power(Times(q,Sqrt(Plus(a,Times(b,Power(x,3)))),Sqrt(Times(Plus(C1,Times(q,x)),Power(Plus(C1,CSqrt3,Times(q,x)),-2)))),-1)),Subst(Int(Power(Times(Plus(Times(Plus(C1,Negate(CSqrt3)),d),Times(CN1,c,q),Times(Plus(Times(Plus(C1,CSqrt3),d),Times(CN1,c,q)),x)),Sqrt(Plus(C1,Negate(Sqr(x)))),Sqrt(Plus(C7,Times(CN1,C4,CSqrt3),Sqr(x)))),-1),x),x,Times(Plus(CN1,CSqrt3,Times(CN1,q,x)),Power(Plus(C1,CSqrt3,Times(q,x)),-1))),x)),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Plus(Times(d,e),Times(CN1,c,f)),C0),EqQ(Plus(Times(b,Power(e,3)),Times(CN1,C2,Plus(C5,Times(C3,CSqrt3)),a,Power(f,3))),C0),NeQ(Plus(Times(b,Power(c,3)),Times(CN1,C2,Plus(C5,Times(CN1,C3,CSqrt3)),a,Power(d,3))),C0))));
IIntegrate(2143,Int(Times(Power(Plus(c_,Times(d_DEFAULT,x_)),-1),Plus(e_,Times(f_DEFAULT,x_)),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),CN1D2)),x_Symbol),
    Condition(With(List(Set(q,Simplify(Times(Plus(CN1,CSqrt3),f,Power(e,-1))))),Dist(Times(C4,Power(C3,C1D4),Sqrt(Plus(C2,CSqrt3)),f,Plus(C1,Times(CN1,q,x)),Sqrt(Times(Plus(C1,Times(q,x),Times(Sqr(q),Sqr(x))),Power(Plus(C1,Negate(CSqrt3),Times(CN1,q,x)),-2))),Power(Times(q,Sqrt(Plus(a,Times(b,Power(x,3)))),Sqrt(Times(CN1,Plus(C1,Times(CN1,q,x)),Power(Plus(C1,Negate(CSqrt3),Times(CN1,q,x)),-2)))),-1)),Subst(Int(Power(Times(Plus(Times(Plus(C1,CSqrt3),d),Times(c,q),Times(Plus(Times(Plus(C1,Negate(CSqrt3)),d),Times(c,q)),x)),Sqrt(Plus(C1,Negate(Sqr(x)))),Sqrt(Plus(C7,Times(C4,CSqrt3),Sqr(x)))),-1),x),x,Times(Plus(C1,CSqrt3,Times(CN1,q,x)),Power(Plus(CN1,CSqrt3,Times(q,x)),-1))),x)),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Plus(Times(d,e),Times(CN1,c,f)),C0),EqQ(Plus(Times(b,Power(e,3)),Times(CN1,C2,Plus(C5,Times(CN1,C3,CSqrt3)),a,Power(f,3))),C0),NeQ(Plus(Times(b,Power(c,3)),Times(CN1,C2,Plus(C5,Times(C3,CSqrt3)),a,Power(d,3))),C0))));
IIntegrate(2144,Int(Times(Power(Plus(c_,Times(d_DEFAULT,x_)),-1),Plus(e_DEFAULT,Times(f_DEFAULT,x_)),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),CN1D2)),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(b,Power(a,-1)),C3))),Plus(Dist(Times(Plus(Times(Plus(C1,CSqrt3),f),Times(CN1,e,q)),Power(Plus(Times(Plus(C1,CSqrt3),d),Times(CN1,c,q)),-1)),Int(Power(Plus(a,Times(b,Power(x,3))),CN1D2),x),x),Dist(Times(Plus(Times(d,e),Times(CN1,c,f)),Power(Plus(Times(Plus(C1,CSqrt3),d),Times(CN1,c,q)),-1)),Int(Times(Plus(C1,CSqrt3,Times(q,x)),Power(Times(Plus(c,Times(d,x)),Sqrt(Plus(a,Times(b,Power(x,3))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Plus(Times(d,e),Times(CN1,c,f)),C0),NeQ(Plus(Times(Sqr(b),Power(c,6)),Times(CN1,ZZ(20L),a,b,Power(c,3),Power(d,3)),Times(CN1,C8,Sqr(a),Power(d,6))),C0),NeQ(Plus(Times(Sqr(b),Power(e,6)),Times(CN1,ZZ(20L),a,b,Power(e,3),Power(f,3)),Times(CN1,C8,Sqr(a),Power(f,6))),C0))));
IIntegrate(2145,Int(Times(Power(Plus(c_,Times(d_DEFAULT,x_),Times(e_DEFAULT,Sqr(x_))),-1),Plus(f_,Times(g_DEFAULT,x_),Times(h_DEFAULT,Sqr(x_))),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),CN1D2)),x_Symbol),
    Condition(Dist(Times(CN2,g,h),Subst(Int(Power(Plus(Times(C2,e,h),Times(CN1,Plus(Times(b,d,f),Times(CN1,C2,a,e,h)),Sqr(x))),-1),x),x,Times(Plus(C1,Times(C2,h,x,Power(g,-1))),Power(Plus(a,Times(b,Power(x,3))),CN1D2))),x),And(FreeQ(List(a,b,c,d,e,f,g,h),x),NeQ(Plus(Times(b,d,f),Times(CN1,C2,a,e,h)),C0),EqQ(Plus(Times(b,Power(g,3)),Times(CN1,C8,a,Power(h,3))),C0),EqQ(Plus(Sqr(g),Times(C2,f,h)),C0),EqQ(Plus(Times(b,d,f),Times(b,c,g),Times(CN1,C4,a,e,h)),C0))));
IIntegrate(2146,Int(Times(Power(Plus(c_,Times(e_DEFAULT,Sqr(x_))),-1),Plus(f_,Times(g_DEFAULT,x_),Times(h_DEFAULT,Sqr(x_))),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),CN1D2)),x_Symbol),
    Condition(Negate(Dist(Times(g,Power(e,-1)),Subst(Int(Power(Plus(C1,Times(a,Sqr(x))),-1),x),x,Times(Plus(C1,Times(C2,h,x,Power(g,-1))),Power(Plus(a,Times(b,Power(x,3))),CN1D2))),x)),And(FreeQ(List(a,b,c,e,f,g,h),x),EqQ(Plus(Times(b,Power(g,3)),Times(CN1,C8,a,Power(h,3))),C0),EqQ(Plus(Sqr(g),Times(C2,f,h)),C0),EqQ(Plus(Times(b,c,g),Times(CN1,C4,a,e,h)),C0))));
IIntegrate(2147,Int(Times(Power(Plus(c_,Times(d_DEFAULT,x_)),-1),Sqrt(Plus(a_,Times(b_DEFAULT,Power(x_,3))))),x_Symbol),
    Condition(Plus(Dist(Times(b,Power(d,-1)),Int(Times(Sqr(x),Power(Plus(a,Times(b,Power(x,3))),CN1D2)),x),x),Dist(Times(b,c,Power(d,-3)),Int(Times(Plus(c,Times(CN1,d,x)),Power(Plus(a,Times(b,Power(x,3))),CN1D2)),x),x),Negate(Dist(Times(Plus(Times(b,Power(c,3)),Times(CN1,a,Power(d,3))),Power(d,-3)),Int(Power(Times(Plus(c,Times(d,x)),Sqrt(Plus(a,Times(b,Power(x,3))))),-1),x),x))),FreeQ(List(a,b,c,d),x)));
IIntegrate(2148,Int(Times(Power(Plus(c_,Times(d_DEFAULT,x_)),-1),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),CN1D3)),x_Symbol),
    Condition(Plus(Simp(Times(CSqrt3,ArcTan(Times(Plus(C1,Times(CN1,Power(C2,C1D3),Rt(b,C3),Plus(c,Times(CN1,d,x)),Power(Times(d,Power(Plus(a,Times(b,Power(x,3))),C1D3)),-1))),C1DSqrt3)),Power(Times(Power(C2,QQ(4L,3L)),Rt(b,C3),c),-1)),x),Simp(Times(Log(Times(Sqr(Plus(c,Times(d,x))),Plus(c,Times(CN1,d,x)))),Power(Times(Power(C2,QQ(7L,3L)),Rt(b,C3),c),-1)),x),Negate(Simp(Times(C3,Log(Plus(Times(Rt(b,C3),Plus(c,Times(CN1,d,x))),Times(Power(C2,QQ(2L,3L)),d,Power(Plus(a,Times(b,Power(x,3))),C1D3)))),Power(Times(Power(C2,QQ(7L,3L)),Rt(b,C3),c),-1)),x))),And(FreeQ(List(a,b,c,d),x),EqQ(Plus(Times(b,Power(c,3)),Times(a,Power(d,3))),C0))));
IIntegrate(2149,Int(Times(Power(Plus(c_,Times(d_DEFAULT,x_)),-1),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),CN1D3)),x_Symbol),
    Condition(Plus(Dist(Power(Times(C2,c),-1),Int(Power(Plus(a,Times(b,Power(x,3))),CN1D3),x),x),Dist(Power(Times(C2,c),-1),Int(Times(Plus(c,Times(CN1,d,x)),Power(Times(Plus(c,Times(d,x)),Power(Plus(a,Times(b,Power(x,3))),C1D3)),-1)),x),x)),And(FreeQ(List(a,b,c,d),x),EqQ(Plus(Times(C2,b,Power(c,3)),Times(CN1,a,Power(d,3))),C0))));
IIntegrate(2150,Int(Times(Power(Plus(c_,Times(d_DEFAULT,x_)),-1),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),CN1D3)),x_Symbol),
    Condition(Unintegrable(Power(Times(Plus(c,Times(d,x)),Power(Plus(a,Times(b,Power(x,3))),C1D3)),-1),x),FreeQ(List(a,b,c,d),x)));
  }
}
}
