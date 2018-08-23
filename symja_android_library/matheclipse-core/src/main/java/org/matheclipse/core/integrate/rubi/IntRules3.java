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
public class IntRules3 { 
  public static IAST RULES = List( 
IIntegrate(151,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),n_),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),p_),Plus(g_DEFAULT,Times(h_DEFAULT,x_))),x_Symbol),
    Condition(Plus(Simp(Times(Plus(Times(b,g),Times(CN1,a,h)),Power(Plus(a,Times(b,x)),Plus(m,C1)),Power(Plus(c,Times(d,x)),Plus(n,C1)),Power(Plus(e,Times(f,x)),Plus(p,C1)),Power(Times(Plus(m,C1),Plus(Times(b,c),Times(CN1,a,d)),Plus(Times(b,e),Times(CN1,a,f))),-1)),x),Dist(Power(Times(Plus(m,C1),Plus(Times(b,c),Times(CN1,a,d)),Plus(Times(b,e),Times(CN1,a,f))),-1),Int(Times(Power(Plus(a,Times(b,x)),Plus(m,C1)),Power(Plus(c,Times(d,x)),n),Power(Plus(e,Times(f,x)),p),Simp(Plus(Times(Plus(Times(a,d,f,g),Times(CN1,b,Plus(Times(d,e),Times(c,f)),g),Times(b,c,e,h)),Plus(m,C1)),Times(CN1,Plus(Times(b,g),Times(CN1,a,h)),Plus(Times(d,e,Plus(n,C1)),Times(c,f,Plus(p,C1)))),Times(CN1,d,f,Plus(Times(b,g),Times(CN1,a,h)),Plus(m,n,p,C3),x)),x)),x),x)),And(FreeQ(List(a,b,c,d,e,f,g,h,n,p),x),LtQ(m,CN1),IntegerQ(m)))),
IIntegrate(152,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),n_),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),p_),Plus(g_DEFAULT,Times(h_DEFAULT,x_))),x_Symbol),
    Condition(Plus(Simp(Times(Plus(Times(b,g),Times(CN1,a,h)),Power(Plus(a,Times(b,x)),Plus(m,C1)),Power(Plus(c,Times(d,x)),Plus(n,C1)),Power(Plus(e,Times(f,x)),Plus(p,C1)),Power(Times(Plus(m,C1),Plus(Times(b,c),Times(CN1,a,d)),Plus(Times(b,e),Times(CN1,a,f))),-1)),x),Dist(Power(Times(Plus(m,C1),Plus(Times(b,c),Times(CN1,a,d)),Plus(Times(b,e),Times(CN1,a,f))),-1),Int(Times(Power(Plus(a,Times(b,x)),Plus(m,C1)),Power(Plus(c,Times(d,x)),n),Power(Plus(e,Times(f,x)),p),Simp(Plus(Times(Plus(Times(a,d,f,g),Times(CN1,b,Plus(Times(d,e),Times(c,f)),g),Times(b,c,e,h)),Plus(m,C1)),Times(CN1,Plus(Times(b,g),Times(CN1,a,h)),Plus(Times(d,e,Plus(n,C1)),Times(c,f,Plus(p,C1)))),Times(CN1,d,f,Plus(Times(b,g),Times(CN1,a,h)),Plus(m,n,p,C3),x)),x)),x),x)),And(FreeQ(List(a,b,c,d,e,f,g,h,n,p),x),LtQ(m,CN1),IntegersQ(Times(C2,m),Times(C2,n),Times(C2,p))))),
IIntegrate(153,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),n_),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),p_),Plus(g_DEFAULT,Times(h_DEFAULT,x_))),x_Symbol),
    Condition(Plus(Simp(Times(h,Power(Plus(a,Times(b,x)),m),Power(Plus(c,Times(d,x)),Plus(n,C1)),Power(Plus(e,Times(f,x)),Plus(p,C1)),Power(Times(d,f,Plus(m,n,p,C2)),-1)),x),Dist(Power(Times(d,f,Plus(m,n,p,C2)),-1),Int(Times(Power(Plus(a,Times(b,x)),Plus(m,Negate(C1))),Power(Plus(c,Times(d,x)),n),Power(Plus(e,Times(f,x)),p),Simp(Plus(Times(a,d,f,g,Plus(m,n,p,C2)),Times(CN1,h,Plus(Times(b,c,e,m),Times(a,Plus(Times(d,e,Plus(n,C1)),Times(c,f,Plus(p,C1)))))),Times(Plus(Times(b,d,f,g,Plus(m,n,p,C2)),Times(h,Plus(Times(a,d,f,m),Times(CN1,b,Plus(Times(d,e,Plus(m,n,C1)),Times(c,f,Plus(m,p,C1))))))),x)),x)),x),x)),And(FreeQ(List(a,b,c,d,e,f,g,h,n,p),x),GtQ(m,C0),NeQ(Plus(m,n,p,C2),C0),IntegerQ(m)))),
IIntegrate(154,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),n_),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),p_),Plus(g_DEFAULT,Times(h_DEFAULT,x_))),x_Symbol),
    Condition(Plus(Simp(Times(h,Power(Plus(a,Times(b,x)),m),Power(Plus(c,Times(d,x)),Plus(n,C1)),Power(Plus(e,Times(f,x)),Plus(p,C1)),Power(Times(d,f,Plus(m,n,p,C2)),-1)),x),Dist(Power(Times(d,f,Plus(m,n,p,C2)),-1),Int(Times(Power(Plus(a,Times(b,x)),Plus(m,Negate(C1))),Power(Plus(c,Times(d,x)),n),Power(Plus(e,Times(f,x)),p),Simp(Plus(Times(a,d,f,g,Plus(m,n,p,C2)),Times(CN1,h,Plus(Times(b,c,e,m),Times(a,Plus(Times(d,e,Plus(n,C1)),Times(c,f,Plus(p,C1)))))),Times(Plus(Times(b,d,f,g,Plus(m,n,p,C2)),Times(h,Plus(Times(a,d,f,m),Times(CN1,b,Plus(Times(d,e,Plus(m,n,C1)),Times(c,f,Plus(m,p,C1))))))),x)),x)),x),x)),And(FreeQ(List(a,b,c,d,e,f,g,h,n,p),x),GtQ(m,C0),NeQ(Plus(m,n,p,C2),C0),IntegersQ(Times(C2,m),Times(C2,n),Times(C2,p))))),
IIntegrate(155,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),n_),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),p_),Plus(g_DEFAULT,Times(h_DEFAULT,x_))),x_Symbol),
    Condition(Plus(Simp(Times(Plus(Times(b,g),Times(CN1,a,h)),Power(Plus(a,Times(b,x)),Plus(m,C1)),Power(Plus(c,Times(d,x)),Plus(n,C1)),Power(Plus(e,Times(f,x)),Plus(p,C1)),Power(Times(Plus(m,C1),Plus(Times(b,c),Times(CN1,a,d)),Plus(Times(b,e),Times(CN1,a,f))),-1)),x),Dist(Power(Times(Plus(m,C1),Plus(Times(b,c),Times(CN1,a,d)),Plus(Times(b,e),Times(CN1,a,f))),-1),Int(Times(Power(Plus(a,Times(b,x)),Plus(m,C1)),Power(Plus(c,Times(d,x)),n),Power(Plus(e,Times(f,x)),p),Simp(Plus(Times(Plus(Times(a,d,f,g),Times(CN1,b,Plus(Times(d,e),Times(c,f)),g),Times(b,c,e,h)),Plus(m,C1)),Times(CN1,Plus(Times(b,g),Times(CN1,a,h)),Plus(Times(d,e,Plus(n,C1)),Times(c,f,Plus(p,C1)))),Times(CN1,d,f,Plus(Times(b,g),Times(CN1,a,h)),Plus(m,n,p,C3),x)),x)),x),x)),And(FreeQ(List(a,b,c,d,e,f,g,h,n,p),x),ILtQ(Plus(m,n,p,C2),C0),NeQ(m,CN1),Or(SumSimplerQ(m,C1),And(Not(And(NeQ(n,CN1),SumSimplerQ(n,C1))),Not(And(NeQ(p,CN1),SumSimplerQ(p,C1)))))))),
IIntegrate(156,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),-1),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),-1),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),p_),Plus(g_DEFAULT,Times(h_DEFAULT,x_))),x_Symbol),
    Condition(Plus(Dist(Times(Plus(Times(b,g),Times(CN1,a,h)),Power(Plus(Times(b,c),Times(CN1,a,d)),-1)),Int(Times(Power(Plus(e,Times(f,x)),p),Power(Plus(a,Times(b,x)),-1)),x),x),Negate(Dist(Times(Plus(Times(d,g),Times(CN1,c,h)),Power(Plus(Times(b,c),Times(CN1,a,d)),-1)),Int(Times(Power(Plus(e,Times(f,x)),p),Power(Plus(c,Times(d,x)),-1)),x),x))),FreeQ(List(a,b,c,d,e,f,g,h),x))),
IIntegrate(157,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),-1),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),n_),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),p_),Plus(g_DEFAULT,Times(h_DEFAULT,x_))),x_Symbol),
    Condition(Plus(Dist(Times(h,Power(b,-1)),Int(Times(Power(Plus(c,Times(d,x)),n),Power(Plus(e,Times(f,x)),p)),x),x),Dist(Times(Plus(Times(b,g),Times(CN1,a,h)),Power(b,-1)),Int(Times(Power(Plus(c,Times(d,x)),n),Power(Plus(e,Times(f,x)),p),Power(Plus(a,Times(b,x)),-1)),x),x)),FreeQ(List(a,b,c,d,e,f,g,h,n,p),x))),
IIntegrate(158,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),CN1D2),Power(Plus(c_,Times(d_DEFAULT,x_)),CN1D2),Power(Plus(e_,Times(f_DEFAULT,x_)),CN1D2),Plus(g_DEFAULT,Times(h_DEFAULT,x_))),x_Symbol),
    Condition(Plus(Dist(Times(h,Power(f,-1)),Int(Times(Sqrt(Plus(e,Times(f,x))),Power(Times(Sqrt(Plus(a,Times(b,x))),Sqrt(Plus(c,Times(d,x)))),-1)),x),x),Dist(Times(Plus(Times(f,g),Times(CN1,e,h)),Power(f,-1)),Int(Power(Times(Sqrt(Plus(a,Times(b,x))),Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x)))),-1),x),x)),And(FreeQ(List(a,b,c,d,e,f,g,h),x),SimplerQ(Plus(a,Times(b,x)),Plus(e,Times(f,x))),SimplerQ(Plus(c,Times(d,x)),Plus(e,Times(f,x)))))),
IIntegrate(159,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),n_),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),p_),Plus(g_DEFAULT,Times(h_DEFAULT,x_))),x_Symbol),
    Condition(Plus(Dist(Times(h,Power(b,-1)),Int(Times(Power(Plus(a,Times(b,x)),Plus(m,C1)),Power(Plus(c,Times(d,x)),n),Power(Plus(e,Times(f,x)),p)),x),x),Dist(Times(Plus(Times(b,g),Times(CN1,a,h)),Power(b,-1)),Int(Times(Power(Plus(a,Times(b,x)),m),Power(Plus(c,Times(d,x)),n),Power(Plus(e,Times(f,x)),p)),x),x)),And(FreeQ(List(a,b,c,d,e,f,g,h,m,n,p),x),Or(SumSimplerQ(m,C1),And(Not(SumSimplerQ(n,C1)),Not(SumSimplerQ(p,C1))))))),
IIntegrate(160,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_),Sqrt(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),Sqrt(Plus(e_DEFAULT,Times(f_DEFAULT,x_))),Sqrt(Plus(g_DEFAULT,Times(h_DEFAULT,x_)))),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(a,Times(b,x)),Plus(m,C1)),Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x))),Power(Times(b,Plus(m,C1)),-1)),x),Negate(Dist(Power(Times(C2,b,Plus(m,C1)),-1),Int(Times(Power(Plus(a,Times(b,x)),Plus(m,C1)),Simp(Plus(Times(d,e,g),Times(c,f,g),Times(c,e,h),Times(C2,Plus(Times(d,f,g),Times(d,e,h),Times(c,f,h)),x),Times(C3,d,f,h,Sqr(x))),x),Power(Times(Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x)))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f,g,h,m),x),IntegerQ(Times(C2,m)),LtQ(m,CN1)))),
IIntegrate(161,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_),Sqrt(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),Sqrt(Plus(e_DEFAULT,Times(f_DEFAULT,x_))),Sqrt(Plus(g_DEFAULT,Times(h_DEFAULT,x_)))),x_Symbol),
    Condition(Plus(Simp(Times(C2,Power(Plus(a,Times(b,x)),Plus(m,C1)),Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x))),Power(Times(b,Plus(Times(C2,m),C5)),-1)),x),Dist(Power(Times(b,Plus(Times(C2,m),C5)),-1),Int(Times(Power(Plus(a,Times(b,x)),m),Simp(Plus(Times(C3,b,c,e,g),Times(CN1,a,Plus(Times(d,e,g),Times(c,f,g),Times(c,e,h))),Times(C2,Plus(Times(b,Plus(Times(d,e,g),Times(c,f,g),Times(c,e,h))),Times(CN1,a,Plus(Times(d,f,g),Times(d,e,h),Times(c,f,h)))),x),Times(CN1,Plus(Times(C3,a,d,f,h),Times(CN1,b,Plus(Times(d,f,g),Times(d,e,h),Times(c,f,h)))),Sqr(x))),x),Power(Times(Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x)))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f,g,h,m),x),IntegerQ(Times(C2,m)),Not(LtQ(m,CN1))))),
IIntegrate(162,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),CN1D2),Sqrt(Plus(e_DEFAULT,Times(f_DEFAULT,x_))),Sqrt(Plus(g_DEFAULT,Times(h_DEFAULT,x_)))),x_Symbol),
    Condition(Plus(Simp(Times(C2,Power(Plus(a,Times(b,x)),m),Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x))),Power(Times(d,Plus(Times(C2,m),C3)),-1)),x),Negate(Dist(Power(Times(d,Plus(Times(C2,m),C3)),-1),Int(Times(Power(Plus(a,Times(b,x)),Plus(m,Negate(C1))),Power(Times(Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x)))),-1),Simp(Plus(Times(C2,b,c,e,g,m),Times(a,Plus(Times(c,Plus(Times(f,g),Times(e,h))),Times(CN1,C2,d,e,g,Plus(m,C1)))),Times(CN1,Plus(Times(b,Plus(Times(C2,d,e,g),Times(CN1,c,Plus(Times(f,g),Times(e,h)),Plus(Times(C2,m),C1)))),Times(CN1,a,Plus(Times(C2,c,f,h),Times(CN1,d,Plus(Times(C2,m),C1),Plus(Times(f,g),Times(e,h)))))),x),Times(CN1,Plus(Times(C2,a,d,f,h,m),Times(b,Plus(Times(d,Plus(Times(f,g),Times(e,h))),Times(CN1,C2,c,f,h,Plus(m,C1))))),Sqr(x))),x)),x),x))),And(FreeQ(List(a,b,c,d,e,f,g,h,m),x),IntegerQ(Times(C2,m)),GtQ(m,C0)))),
IIntegrate(163,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),-1),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),CN1D2),Sqrt(Plus(e_DEFAULT,Times(f_DEFAULT,x_))),Sqrt(Plus(g_DEFAULT,Times(h_DEFAULT,x_)))),x_Symbol),
    Condition(Plus(Dist(Times(Plus(Times(b,e),Times(CN1,a,f)),Plus(Times(b,g),Times(CN1,a,h)),Power(b,-2)),Int(Power(Times(Plus(a,Times(b,x)),Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x)))),-1),x),x),Dist(Power(b,-2),Int(Times(Simp(Plus(Times(b,f,g),Times(b,e,h),Times(CN1,a,f,h),Times(b,f,h,x)),x),Power(Times(Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x)))),-1)),x),x)),FreeQ(List(a,b,c,d,e,f,g,h),x))),
IIntegrate(164,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),CN1D2),Sqrt(Plus(e_DEFAULT,Times(f_DEFAULT,x_))),Sqrt(Plus(g_DEFAULT,Times(h_DEFAULT,x_)))),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(a,Times(b,x)),Plus(m,C1)),Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x))),Power(Times(Plus(m,C1),Plus(Times(b,c),Times(CN1,a,d))),-1)),x),Negate(Dist(Power(Times(C2,Plus(m,C1),Plus(Times(b,c),Times(CN1,a,d))),-1),Int(Times(Power(Plus(a,Times(b,x)),Plus(m,C1)),Power(Times(Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x)))),-1),Simp(Plus(Times(c,Plus(Times(f,g),Times(e,h))),Times(d,e,g,Plus(Times(C2,m),C3)),Times(C2,Plus(Times(c,f,h),Times(d,Plus(m,C2),Plus(Times(f,g),Times(e,h)))),x),Times(d,f,h,Plus(Times(C2,m),C5),Sqr(x))),x)),x),x))),And(FreeQ(List(a,b,c,d,e,f,g,h,m),x),IntegerQ(Times(C2,m)),LtQ(m,CN1)))),
IIntegrate(165,Int(Times(Sqrt(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),CN1D2),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),CN1D2),Power(Plus(g_DEFAULT,Times(h_DEFAULT,x_)),CN1D2)),x_Symbol),
    Condition(Dist(Times(C2,Plus(a,Times(b,x)),Sqrt(Times(Plus(Times(b,g),Times(CN1,a,h)),Plus(c,Times(d,x)),Power(Times(Plus(Times(d,g),Times(CN1,c,h)),Plus(a,Times(b,x))),-1))),Sqrt(Times(Plus(Times(b,g),Times(CN1,a,h)),Plus(e,Times(f,x)),Power(Times(Plus(Times(f,g),Times(CN1,e,h)),Plus(a,Times(b,x))),-1))),Power(Times(Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x)))),-1)),Subst(Int(Power(Times(Plus(h,Times(CN1,b,Sqr(x))),Sqrt(Plus(C1,Times(Plus(Times(b,c),Times(CN1,a,d)),Sqr(x),Power(Plus(Times(d,g),Times(CN1,c,h)),-1)))),Sqrt(Plus(C1,Times(Plus(Times(b,e),Times(CN1,a,f)),Sqr(x),Power(Plus(Times(f,g),Times(CN1,e,h)),-1))))),-1),x),x,Times(Sqrt(Plus(g,Times(h,x))),Power(Plus(a,Times(b,x)),CN1D2))),x),FreeQ(List(a,b,c,d,e,f,g,h),x))),
IIntegrate(166,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),QQ(3L,2L)),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),CN1D2),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),CN1D2),Power(Plus(g_DEFAULT,Times(h_DEFAULT,x_)),CN1D2)),x_Symbol),
    Condition(Plus(Dist(Times(b,Power(d,-1)),Int(Times(Sqrt(Plus(a,Times(b,x))),Sqrt(Plus(c,Times(d,x))),Power(Times(Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x)))),-1)),x),x),Negate(Dist(Times(Plus(Times(b,c),Times(CN1,a,d)),Power(d,-1)),Int(Times(Sqrt(Plus(a,Times(b,x))),Power(Times(Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x)))),-1)),x),x))),FreeQ(List(a,b,c,d,e,f,g,h),x))),
IIntegrate(167,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),CN1D2),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),CN1D2),Power(Plus(g_DEFAULT,Times(h_DEFAULT,x_)),CN1D2)),x_Symbol),
    Condition(Plus(Simp(Times(C2,Sqr(b),Power(Plus(a,Times(b,x)),Plus(m,Negate(C2))),Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x))),Power(Times(d,f,h,Plus(Times(C2,m),Negate(C1))),-1)),x),Negate(Dist(Power(Times(d,f,h,Plus(Times(C2,m),Negate(C1))),-1),Int(Times(Power(Plus(a,Times(b,x)),Plus(m,Negate(C3))),Power(Times(Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x)))),-1),Simp(Plus(Times(a,Sqr(b),Plus(Times(d,e,g),Times(c,f,g),Times(c,e,h))),Times(C2,Power(b,3),c,e,g,Plus(m,Negate(C2))),Times(CN1,Power(a,3),d,f,h,Plus(Times(C2,m),Negate(C1))),Times(b,Plus(Times(C2,a,b,Plus(Times(d,f,g),Times(d,e,h),Times(c,f,h))),Times(Sqr(b),Plus(Times(C2,m),Negate(C3)),Plus(Times(d,e,g),Times(c,f,g),Times(c,e,h))),Times(CN1,C3,Sqr(a),d,f,h,Plus(Times(C2,m),Negate(C1)))),x),Times(CN1,C2,Sqr(b),Plus(m,Negate(C1)),Plus(Times(C3,a,d,f,h),Times(CN1,b,Plus(Times(d,f,g),Times(d,e,h),Times(c,f,h)))),Sqr(x))),x)),x),x))),And(FreeQ(List(a,b,c,d,e,f,g,h),x),IntegerQ(Times(C2,m)),GeQ(m,C2)))),
IIntegrate(168,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),-1),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),CN1D2),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),CN1D2),Power(Plus(g_DEFAULT,Times(h_DEFAULT,x_)),CN1D2)),x_Symbol),
    Condition(Dist(CN2,Subst(Int(Power(Times(Simp(Plus(Times(b,c),Times(CN1,a,d),Times(CN1,b,Sqr(x))),x),Sqrt(Simp(Plus(Times(Plus(Times(d,e),Times(CN1,c,f)),Power(d,-1)),Times(f,Sqr(x),Power(d,-1))),x)),Sqrt(Simp(Plus(Times(Plus(Times(d,g),Times(CN1,c,h)),Power(d,-1)),Times(h,Sqr(x),Power(d,-1))),x))),-1),x),x,Sqrt(Plus(c,Times(d,x)))),x),And(FreeQ(List(a,b,c,d,e,f,g,h),x),GtQ(Times(Plus(Times(d,e),Times(CN1,c,f)),Power(d,-1)),C0)))),
IIntegrate(169,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),-1),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),CN1D2),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),CN1D2),Power(Plus(g_DEFAULT,Times(h_DEFAULT,x_)),CN1D2)),x_Symbol),
    Condition(Dist(CN2,Subst(Int(Power(Times(Simp(Plus(Times(b,c),Times(CN1,a,d),Times(CN1,b,Sqr(x))),x),Sqrt(Simp(Plus(Times(Plus(Times(d,e),Times(CN1,c,f)),Power(d,-1)),Times(f,Sqr(x),Power(d,-1))),x)),Sqrt(Simp(Plus(Times(Plus(Times(d,g),Times(CN1,c,h)),Power(d,-1)),Times(h,Sqr(x),Power(d,-1))),x))),-1),x),x,Sqrt(Plus(c,Times(d,x)))),x),And(FreeQ(List(a,b,c,d,e,f,g,h),x),Not(SimplerQ(Plus(e,Times(f,x)),Plus(c,Times(d,x)))),Not(SimplerQ(Plus(g,Times(h,x)),Plus(c,Times(d,x))))))),
IIntegrate(170,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),CN1D2),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),CN1D2),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),CN1D2),Power(Plus(g_DEFAULT,Times(h_DEFAULT,x_)),CN1D2)),x_Symbol),
    Condition(Dist(Times(C2,Sqrt(Plus(g,Times(h,x))),Sqrt(Times(Plus(Times(b,e),Times(CN1,a,f)),Plus(c,Times(d,x)),Power(Times(Plus(Times(d,e),Times(CN1,c,f)),Plus(a,Times(b,x))),-1))),Power(Times(Plus(Times(f,g),Times(CN1,e,h)),Sqrt(Plus(c,Times(d,x))),Sqrt(Times(CN1,Plus(Times(b,e),Times(CN1,a,f)),Plus(g,Times(h,x)),Power(Times(Plus(Times(f,g),Times(CN1,e,h)),Plus(a,Times(b,x))),-1)))),-1)),Subst(Int(Power(Times(Sqrt(Plus(C1,Times(Plus(Times(b,c),Times(CN1,a,d)),Sqr(x),Power(Plus(Times(d,e),Times(CN1,c,f)),-1)))),Sqrt(Plus(C1,Times(CN1,Plus(Times(b,g),Times(CN1,a,h)),Sqr(x),Power(Plus(Times(f,g),Times(CN1,e,h)),-1))))),-1),x),x,Times(Sqrt(Plus(e,Times(f,x))),Power(Plus(a,Times(b,x)),CN1D2))),x),FreeQ(List(a,b,c,d,e,f,g,h),x))),
IIntegrate(171,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),QQ(-3L,2L)),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),CN1D2),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),CN1D2),Power(Plus(g_DEFAULT,Times(h_DEFAULT,x_)),CN1D2)),x_Symbol),
    Condition(Plus(Negate(Dist(Times(d,Power(Plus(Times(b,c),Times(CN1,a,d)),-1)),Int(Power(Times(Sqrt(Plus(a,Times(b,x))),Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x)))),-1),x),x)),Dist(Times(b,Power(Plus(Times(b,c),Times(CN1,a,d)),-1)),Int(Times(Sqrt(Plus(c,Times(d,x))),Power(Times(Power(Plus(a,Times(b,x)),QQ(3L,2L)),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x)))),-1)),x),x)),FreeQ(List(a,b,c,d,e,f,g,h),x))),
IIntegrate(172,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),CN1D2),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),CN1D2),Power(Plus(g_DEFAULT,Times(h_DEFAULT,x_)),CN1D2)),x_Symbol),
    Condition(Plus(Simp(Times(Sqr(b),Power(Plus(a,Times(b,x)),Plus(m,C1)),Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x))),Power(Times(Plus(m,C1),Plus(Times(b,c),Times(CN1,a,d)),Plus(Times(b,e),Times(CN1,a,f)),Plus(Times(b,g),Times(CN1,a,h))),-1)),x),Negate(Dist(Power(Times(C2,Plus(m,C1),Plus(Times(b,c),Times(CN1,a,d)),Plus(Times(b,e),Times(CN1,a,f)),Plus(Times(b,g),Times(CN1,a,h))),-1),Int(Times(Power(Plus(a,Times(b,x)),Plus(m,C1)),Power(Times(Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x)))),-1),Simp(Plus(Times(C2,Sqr(a),d,f,h,Plus(m,C1)),Times(CN1,C2,a,b,Plus(m,C1),Plus(Times(d,f,g),Times(d,e,h),Times(c,f,h))),Times(Sqr(b),Plus(Times(C2,m),C3),Plus(Times(d,e,g),Times(c,f,g),Times(c,e,h))),Times(CN1,C2,b,Plus(Times(a,d,f,h,Plus(m,C1)),Times(CN1,b,Plus(m,C2),Plus(Times(d,f,g),Times(d,e,h),Times(c,f,h)))),x),Times(d,f,h,Plus(Times(C2,m),C5),Sqr(b),Sqr(x))),x)),x),x))),And(FreeQ(List(a,b,c,d,e,f,g,h),x),IntegerQ(Times(C2,m)),LeQ(m,CN2)))),
IIntegrate(173,Int(Times(Sqrt(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),Sqrt(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),CN1D2),Power(Plus(g_DEFAULT,Times(h_DEFAULT,x_)),CN1D2)),x_Symbol),
    Condition(Plus(Simp(Times(Sqrt(Plus(a,Times(b,x))),Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(g,Times(h,x))),Power(Times(h,Sqrt(Plus(e,Times(f,x)))),-1)),x),Negate(Dist(Times(Plus(Times(d,e),Times(CN1,c,f)),Plus(Times(f,g),Times(CN1,e,h)),Power(Times(C2,f,h),-1)),Int(Times(Sqrt(Plus(a,Times(b,x))),Power(Times(Sqrt(Plus(c,Times(d,x))),Power(Plus(e,Times(f,x)),QQ(3L,2L)),Sqrt(Plus(g,Times(h,x)))),-1)),x),x)),Dist(Times(Plus(Times(d,e),Times(CN1,c,f)),Plus(Times(b,f,g),Times(b,e,h),Times(CN1,C2,a,f,h)),Power(Times(C2,Sqr(f),h),-1)),Int(Power(Times(Sqrt(Plus(a,Times(b,x))),Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x)))),-1),x),x),Dist(Times(Plus(Times(a,d,f,h),Times(CN1,b,Plus(Times(d,f,g),Times(d,e,h),Times(CN1,c,f,h)))),Power(Times(C2,Sqr(f),h),-1)),Int(Times(Sqrt(Plus(e,Times(f,x))),Power(Times(Sqrt(Plus(a,Times(b,x))),Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(g,Times(h,x)))),-1)),x),x)),FreeQ(List(a,b,c,d,e,f,g,h),x))),
IIntegrate(174,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_),Sqrt(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),CN1D2),Power(Plus(g_DEFAULT,Times(h_DEFAULT,x_)),CN1D2)),x_Symbol),
    Condition(Plus(Simp(Times(C2,b,Power(Plus(a,Times(b,x)),Plus(m,Negate(C1))),Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x))),Power(Times(f,h,Plus(Times(C2,m),C1)),-1)),x),Negate(Dist(Power(Times(f,h,Plus(Times(C2,m),C1)),-1),Int(Times(Power(Plus(a,Times(b,x)),Plus(m,Negate(C2))),Power(Times(Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x)))),-1),Simp(Plus(Times(a,b,Plus(Times(d,e,g),Times(c,Plus(Times(f,g),Times(e,h))))),Times(C2,Sqr(b),c,e,g,Plus(m,Negate(C1))),Times(CN1,Sqr(a),c,f,h,Plus(Times(C2,m),C1)),Times(Plus(Times(Sqr(b),Plus(Times(C2,m),Negate(C1)),Plus(Times(d,e,g),Times(c,Plus(Times(f,g),Times(e,h))))),Times(CN1,Sqr(a),d,f,h,Plus(Times(C2,m),C1)),Times(C2,a,b,Plus(Times(d,f,g),Times(d,e,h),Times(CN1,C2,c,f,h,m)))),x),Times(CN1,b,Plus(Times(a,d,f,h,Plus(Times(C4,m),Negate(C1))),Times(b,Plus(Times(c,f,h),Times(CN1,C2,d,Plus(Times(f,g),Times(e,h)),m)))),Sqr(x))),x)),x),x))),And(FreeQ(List(a,b,c,d,e,f,g,h,m),x),IntegerQ(Times(C2,m)),GtQ(m,C1)))),
IIntegrate(175,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),-1),Sqrt(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),CN1D2),Power(Plus(g_DEFAULT,Times(h_DEFAULT,x_)),CN1D2)),x_Symbol),
    Condition(Plus(Dist(Times(d,Power(b,-1)),Int(Power(Times(Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x)))),-1),x),x),Dist(Times(Plus(Times(b,c),Times(CN1,a,d)),Power(b,-1)),Int(Power(Times(Plus(a,Times(b,x)),Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x)))),-1),x),x)),FreeQ(List(a,b,c,d,e,f,g,h),x))),
IIntegrate(176,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),QQ(-3L,2L)),Sqrt(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),CN1D2),Power(Plus(g_DEFAULT,Times(h_DEFAULT,x_)),CN1D2)),x_Symbol),
    Condition(Dist(Times(CN2,Sqrt(Plus(c,Times(d,x))),Sqrt(Times(CN1,Plus(Times(b,e),Times(CN1,a,f)),Plus(g,Times(h,x)),Power(Times(Plus(Times(f,g),Times(CN1,e,h)),Plus(a,Times(b,x))),-1))),Power(Times(Plus(Times(b,e),Times(CN1,a,f)),Sqrt(Plus(g,Times(h,x))),Sqrt(Times(Plus(Times(b,e),Times(CN1,a,f)),Plus(c,Times(d,x)),Power(Times(Plus(Times(d,e),Times(CN1,c,f)),Plus(a,Times(b,x))),-1)))),-1)),Subst(Int(Times(Sqrt(Plus(C1,Times(Plus(Times(b,c),Times(CN1,a,d)),Sqr(x),Power(Plus(Times(d,e),Times(CN1,c,f)),-1)))),Power(Plus(C1,Times(CN1,Plus(Times(b,g),Times(CN1,a,h)),Sqr(x),Power(Plus(Times(f,g),Times(CN1,e,h)),-1))),CN1D2)),x),x,Times(Sqrt(Plus(e,Times(f,x))),Power(Plus(a,Times(b,x)),CN1D2))),x),FreeQ(List(a,b,c,d,e,f,g,h),x))),
IIntegrate(177,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_),Sqrt(Plus(c_DEFAULT,Times(d_DEFAULT,x_))),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),CN1D2),Power(Plus(g_DEFAULT,Times(h_DEFAULT,x_)),CN1D2)),x_Symbol),
    Condition(Plus(Simp(Times(b,Power(Plus(a,Times(b,x)),Plus(m,C1)),Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x))),Power(Times(Plus(m,C1),Plus(Times(b,e),Times(CN1,a,f)),Plus(Times(b,g),Times(CN1,a,h))),-1)),x),Dist(Power(Times(C2,Plus(m,C1),Plus(Times(b,e),Times(CN1,a,f)),Plus(Times(b,g),Times(CN1,a,h))),-1),Int(Times(Power(Plus(a,Times(b,x)),Plus(m,C1)),Power(Times(Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x)))),-1),Simp(Plus(Times(C2,a,c,f,h,Plus(m,C1)),Times(CN1,b,Plus(Times(d,e,g),Times(c,Plus(Times(C2,m),C3),Plus(Times(f,g),Times(e,h))))),Times(C2,Plus(Times(a,d,f,h,Plus(m,C1)),Times(CN1,b,Plus(m,C2),Plus(Times(d,f,g),Times(d,e,h),Times(c,f,h)))),x),Times(CN1,b,d,f,h,Plus(Times(C2,m),C5),Sqr(x))),x)),x),x)),And(FreeQ(List(a,b,c,d,e,f,g,h,m),x),IntegerQ(Times(C2,m)),LeQ(m,CN2)))),
IIntegrate(178,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),-1),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),-1),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),p_),Power(Plus(g_DEFAULT,Times(h_DEFAULT,x_)),q_)),x_Symbol),
    Condition(Plus(Dist(Times(Plus(Times(b,e),Times(CN1,a,f)),Power(Plus(Times(b,c),Times(CN1,a,d)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(p,Negate(C1))),Power(Plus(g,Times(h,x)),q),Power(Plus(a,Times(b,x)),-1)),x),x),Negate(Dist(Times(Plus(Times(d,e),Times(CN1,c,f)),Power(Plus(Times(b,c),Times(CN1,a,d)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(p,Negate(C1))),Power(Plus(g,Times(h,x)),q),Power(Plus(c,Times(d,x)),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f,g,h,q),x),LtQ(C0,p,C1)))),
IIntegrate(179,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),n_),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),CN1D2),Power(Plus(g_DEFAULT,Times(h_DEFAULT,x_)),CN1D2)),x_Symbol),
    Condition(Int(ExpandIntegrand(Power(Times(Sqrt(Plus(c,Times(d,x))),Sqrt(Plus(e,Times(f,x))),Sqrt(Plus(g,Times(h,x)))),-1),Times(Power(Plus(a,Times(b,x)),m),Power(Plus(c,Times(d,x)),Plus(n,C1D2))),x),x),And(FreeQ(List(a,b,c,d,e,f,g,h),x),IntegerQ(m),IntegerQ(Plus(n,C1D2))))),
IIntegrate(180,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),n_),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),p_),Power(Plus(g_DEFAULT,Times(h_DEFAULT,x_)),q_)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times(Power(Plus(a,Times(b,x)),m),Power(Plus(c,Times(d,x)),n),Power(Plus(e,Times(f,x)),p),Power(Plus(g,Times(h,x)),q)),x),x),And(FreeQ(List(a,b,c,d,e,f,g,h,m,n),x),IntegersQ(p,q)))),
IIntegrate(181,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),n_),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),p_),Power(Plus(g_DEFAULT,Times(h_DEFAULT,x_)),q_)),x_Symbol),
    Condition(Plus(Dist(Times(h,Power(b,-1)),Int(Times(Power(Plus(a,Times(b,x)),Plus(m,C1)),Power(Plus(c,Times(d,x)),n),Power(Plus(e,Times(f,x)),p),Power(Plus(g,Times(h,x)),Plus(q,Negate(C1)))),x),x),Dist(Times(Plus(Times(b,g),Times(CN1,a,h)),Power(b,-1)),Int(Times(Power(Plus(a,Times(b,x)),m),Power(Plus(c,Times(d,x)),n),Power(Plus(e,Times(f,x)),p),Power(Plus(g,Times(h,x)),Plus(q,Negate(C1)))),x),x)),And(FreeQ(List(a,b,c,d,e,f,g,h,m,n,p),x),IGtQ(q,C0),Or(SumSimplerQ(m,C1),And(Not(SumSimplerQ(n,C1)),Not(SumSimplerQ(p,C1))))))),
IIntegrate(182,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),n_DEFAULT),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),p_DEFAULT),Power(Plus(g_DEFAULT,Times(h_DEFAULT,x_)),q_DEFAULT)),x_Symbol),
    Condition(CannotIntegrate(Times(Power(Plus(a,Times(b,x)),m),Power(Plus(c,Times(d,x)),n),Power(Plus(e,Times(f,x)),p),Power(Plus(g,Times(h,x)),q)),x),FreeQ(List(a,b,c,d,e,f,g,h,m,n,p,q),x))),
IIntegrate(183,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,u_)),m_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,u_)),n_DEFAULT),Power(Plus(e_DEFAULT,Times(f_DEFAULT,u_)),p_DEFAULT),Power(Plus(g_DEFAULT,Times(h_DEFAULT,u_)),q_DEFAULT)),x_Symbol),
    Condition(Dist(Power(Coefficient(u,x,C1),-1),Subst(Int(Times(Power(Plus(a,Times(b,x)),m),Power(Plus(c,Times(d,x)),n),Power(Plus(e,Times(f,x)),p),Power(Plus(g,Times(h,x)),q)),x),x,u),x),And(FreeQ(List(a,b,c,d,e,f,g,h,m,n,p,q),x),LinearQ(u,x),NeQ(u,x)))),
IIntegrate(184,Int(Power(Times(i_DEFAULT,Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),n_),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),p_),Power(Plus(g_DEFAULT,Times(h_DEFAULT,x_)),q_)),r_),x_Symbol),
    Condition(Dist(Times(Power(Times(i,Power(Plus(a,Times(b,x)),m),Power(Plus(c,Times(d,x)),n),Power(Plus(e,Times(f,x)),p),Power(Plus(g,Times(h,x)),q)),r),Power(Times(Power(Plus(a,Times(b,x)),Times(m,r)),Power(Plus(c,Times(d,x)),Times(n,r)),Power(Plus(e,Times(f,x)),Times(p,r)),Power(Plus(g,Times(h,x)),Times(q,r))),-1)),Int(Times(Power(Plus(a,Times(b,x)),Times(m,r)),Power(Plus(c,Times(d,x)),Times(n,r)),Power(Plus(e,Times(f,x)),Times(p,r)),Power(Plus(g,Times(h,x)),Times(q,r))),x),x),FreeQ(List(a,b,c,d,e,f,g,h,i,m,n,p,q,r),x))),
IIntegrate(185,Int(Power(u_,m_),x_Symbol),
    Condition(Int(Power(ExpandToSum(u,x),m),x),And(FreeQ(m,x),LinearQ(u,x),Not(LinearMatchQ(u,x))))),
IIntegrate(186,Int(Times(Power(u_,m_DEFAULT),Power(v_,n_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(ExpandToSum(u,x),m),Power(ExpandToSum(v,x),n)),x),And(FreeQ(List(m,n),x),LinearQ(List(u,v),x),Not(LinearMatchQ(List(u,v),x))))),
IIntegrate(187,Int(Times(Power(u_,m_DEFAULT),Power(v_,n_DEFAULT),Power(w_,p_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(ExpandToSum(u,x),m),Power(ExpandToSum(v,x),n),Power(ExpandToSum(w,x),p)),x),And(FreeQ(List(m,n,p),x),LinearQ(List(u,v,w),x),Not(LinearMatchQ(List(u,v,w),x))))),
IIntegrate(188,Int(Times(Power(u_,m_DEFAULT),Power(v_,n_DEFAULT),Power(w_,p_DEFAULT),Power(z_,q_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(ExpandToSum(u,x),m),Power(ExpandToSum(v,x),n),Power(ExpandToSum(w,x),p),Power(ExpandToSum(z,x),q)),x),And(FreeQ(List(m,n,p,q),x),LinearQ(List(u,v,w,z),x),Not(LinearMatchQ(List(u,v,w,z),x))))),
IIntegrate(189,Int(Power(Times(b_DEFAULT,Power(x_,n_)),p_),x_Symbol),
    Condition(Dist(Times(Power(b,IntPart(p)),Power(Times(b,Power(x,n)),FracPart(p)),Power(Power(x,Times(n,FracPart(p))),-1)),Int(Power(x,Times(n,p)),x),x),FreeQ(List(b,n,p),x))),
IIntegrate(190,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_),x_Symbol),
    Condition(Dist(Power(n,-1),Subst(Int(Times(Power(x,Plus(Power(n,-1),Negate(C1))),Power(Plus(a,Times(b,x)),p)),x),x,Power(x,n)),x),And(FreeQ(List(a,b,p),x),FractionQ(n),IntegerQ(Power(n,-1))))),
IIntegrate(191,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_),x_Symbol),
    Condition(Simp(Times(x,Power(Plus(a,Times(b,Power(x,n))),Plus(p,C1)),Power(a,-1)),x),And(FreeQ(List(a,b,n,p),x),EqQ(Plus(Power(n,-1),p,C1),C0)))),
IIntegrate(192,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_),x_Symbol),
    Condition(Plus(Negate(Simp(Times(x,Power(Plus(a,Times(b,Power(x,n))),Plus(p,C1)),Power(Times(a,n,Plus(p,C1)),-1)),x)),Dist(Times(Plus(Times(n,Plus(p,C1)),C1),Power(Times(a,n,Plus(p,C1)),-1)),Int(Power(Plus(a,Times(b,Power(x,n))),Plus(p,C1)),x),x)),And(FreeQ(List(a,b,n,p),x),ILtQ(Simplify(Plus(Power(n,-1),p,C1)),C0),NeQ(p,CN1)))),
IIntegrate(193,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_),x_Symbol),
    Condition(Int(Times(Power(x,Times(n,p)),Power(Plus(b,Times(a,Power(Power(x,n),-1))),p)),x),And(FreeQ(List(a,b),x),LtQ(n,C0),IntegerQ(p)))),
IIntegrate(194,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_),x_Symbol),
    Condition(Int(ExpandIntegrand(Power(Plus(a,Times(b,Power(x,n))),p),x),x),And(FreeQ(List(a,b),x),IGtQ(n,C0),IGtQ(p,C0)))),
IIntegrate(195,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_),x_Symbol),
    Condition(Plus(Simp(Times(x,Power(Plus(a,Times(b,Power(x,n))),p),Power(Plus(Times(n,p),C1),-1)),x),Dist(Times(a,n,p,Power(Plus(Times(n,p),C1),-1)),Int(Power(Plus(a,Times(b,Power(x,n))),Plus(p,Negate(C1))),x),x)),And(FreeQ(List(a,b),x),IGtQ(n,C0),GtQ(p,C0),Or(IntegerQ(Times(C2,p)),And(EqQ(n,C2),IntegerQ(Times(C4,p))),And(EqQ(n,C2),IntegerQ(Times(C3,p))),LtQ(Denominator(Plus(p,Power(n,-1))),Denominator(p)))))),
IIntegrate(196,Int(Power(Plus(a_,Times(b_DEFAULT,Sqr(x_))),QQ(-5L,4L)),x_Symbol),
    Condition(Simp(Times(C2,EllipticE(Times(C1D2,C1,ArcTan(Times(Rt(Times(b,Power(a,-1)),C2),x))),C2),Power(Times(Power(a,QQ(5L,4L)),Rt(Times(b,Power(a,-1)),C2)),-1)),x),And(FreeQ(List(a,b),x),GtQ(a,C0),PosQ(Times(b,Power(a,-1)))))),
IIntegrate(197,Int(Power(Plus(a_,Times(b_DEFAULT,Sqr(x_))),QQ(-5L,4L)),x_Symbol),
    Condition(Dist(Times(Power(Plus(C1,Times(b,Sqr(x),Power(a,-1))),C1D4),Power(Times(a,Power(Plus(a,Times(b,Sqr(x))),C1D4)),-1)),Int(Power(Plus(C1,Times(b,Sqr(x),Power(a,-1))),QQ(-5L,4L)),x),x),And(FreeQ(List(a,b),x),PosQ(a),PosQ(Times(b,Power(a,-1)))))),
IIntegrate(198,Int(Power(Plus(a_,Times(b_DEFAULT,Sqr(x_))),QQ(-7L,6L)),x_Symbol),
    Condition(Dist(Power(Times(Power(Plus(a,Times(b,Sqr(x))),QQ(2L,3L)),Power(Times(a,Power(Plus(a,Times(b,Sqr(x))),-1)),QQ(2L,3L))),-1),Subst(Int(Power(Plus(C1,Times(CN1,b,Sqr(x))),CN1D3),x),x,Times(x,Power(Plus(a,Times(b,Sqr(x))),CN1D2))),x),FreeQ(List(a,b),x))),
IIntegrate(199,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_),x_Symbol),
    Condition(Plus(Negate(Simp(Times(x,Power(Plus(a,Times(b,Power(x,n))),Plus(p,C1)),Power(Times(a,n,Plus(p,C1)),-1)),x)),Dist(Times(Plus(Times(n,Plus(p,C1)),C1),Power(Times(a,n,Plus(p,C1)),-1)),Int(Power(Plus(a,Times(b,Power(x,n))),Plus(p,C1)),x),x)),And(FreeQ(List(a,b),x),IGtQ(n,C0),LtQ(p,CN1),Or(IntegerQ(Times(C2,p)),And(Equal(n,C2),IntegerQ(Times(C4,p))),And(Equal(n,C2),IntegerQ(Times(C3,p))),Less(Denominator(Plus(p,Power(n,-1))),Denominator(p)))))),
IIntegrate(200,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),-1),x_Symbol),
    Condition(Plus(Dist(Power(Times(C3,Sqr(Rt(a,C3))),-1),Int(Power(Plus(Rt(a,C3),Times(Rt(b,C3),x)),-1),x),x),Dist(Power(Times(C3,Sqr(Rt(a,C3))),-1),Int(Times(Plus(Times(C2,Rt(a,C3)),Times(CN1,Rt(b,C3),x)),Power(Plus(Sqr(Rt(a,C3)),Times(CN1,Rt(a,C3),Rt(b,C3),x),Times(Sqr(Rt(b,C3)),Sqr(x))),-1)),x),x)),FreeQ(List(a,b),x)))
  );
}
