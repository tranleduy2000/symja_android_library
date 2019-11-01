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
public class IntRules105 { 
  public static IAST RULES = List( 
IIntegrate(2101,Int(Times($p("§pm"),Power($p("§qn"),p_)),x_Symbol),
    Condition(With(List(Set(m,Expon($s("§pm"),x)),Set(n,Expon($s("§qn"),x))),Condition(Plus(Simp(Times(Coeff($s("§pm"),x,m),Power($s("§qn"),Plus(p,C1)),Power(Times(n,Plus(p,C1),Coeff($s("§qn"),x,n)),CN1)),x),Dist(Power(Times(n,Coeff($s("§qn"),x,n)),CN1),Int(Times(ExpandToSum(Subtract(Times(n,Coeff($s("§qn"),x,n),$s("§pm")),Times(Coeff($s("§pm"),x,m),D($s("§qn"),x))),x),Power($s("§qn"),p)),x),x)),EqQ(m,Subtract(n,C1)))),And(FreeQ(p,x),PolyQ($s("§pm"),x),PolyQ($s("§qn"),x),NeQ(p,CN1)))),
IIntegrate(2102,Int(Times($p("§pm"),Power($p("§qn"),p_DEFAULT)),x_Symbol),
    Condition(With(List(Set(m,Expon($s("§pm"),x)),Set(n,Expon($s("§qn"),x))),Condition(Plus(Simp(Times(Coeff($s("§pm"),x,m),Power(x,Plus(m,Negate(n),C1)),Power($s("§qn"),Plus(p,C1)),Power(Times(Plus(m,Times(n,p),C1),Coeff($s("§qn"),x,n)),CN1)),x),Dist(Power(Times(Plus(m,Times(n,p),C1),Coeff($s("§qn"),x,n)),CN1),Int(Times(ExpandToSum(Subtract(Times(Plus(m,Times(n,p),C1),Coeff($s("§qn"),x,n),$s("§pm")),Times(Coeff($s("§pm"),x,m),Power(x,Subtract(m,n)),Plus(Times(Plus(m,Negate(n),C1),$s("§qn")),Times(Plus(p,C1),x,D($s("§qn"),x))))),x),Power($s("§qn"),p)),x),x)),And(LtQ(C1,n,Plus(m,C1)),Less(Plus(m,Times(n,p),C1),C0)))),And(FreeQ(p,x),PolyQ($s("§pm"),x),PolyQ($s("§qn"),x),LtQ(p,CN1)))),
IIntegrate(2103,Int(Times(u_,Power(Plus(Times(e_DEFAULT,Sqrt(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),Times(f_DEFAULT,Sqrt(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),CN1)),x_Symbol),
    Condition(Subtract(Dist(Times(c,Power(Times(e,Subtract(Times(b,c),Times(a,d))),CN1)),Int(Times(u,Sqrt(Plus(a,Times(b,x))),Power(x,CN1)),x),x),Dist(Times(a,Power(Times(f,Subtract(Times(b,c),Times(a,d))),CN1)),Int(Times(u,Sqrt(Plus(c,Times(d,x))),Power(x,CN1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Subtract(Times(b,c),Times(a,d)),C0),EqQ(Subtract(Times(a,Sqr(e)),Times(c,Sqr(f))),C0)))),
IIntegrate(2104,Int(Times(u_,Power(Plus(Times(e_DEFAULT,Sqrt(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),Times(f_DEFAULT,Sqrt(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),CN1)),x_Symbol),
    Condition(Plus(Negate(Dist(Times(d,Power(Times(e,Subtract(Times(b,c),Times(a,d))),CN1)),Int(Times(u,Sqrt(Plus(a,Times(b,x)))),x),x)),Dist(Times(b,Power(Times(f,Subtract(Times(b,c),Times(a,d))),CN1)),Int(Times(u,Sqrt(Plus(c,Times(d,x)))),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Subtract(Times(b,c),Times(a,d)),C0),EqQ(Subtract(Times(b,Sqr(e)),Times(d,Sqr(f))),C0)))),
IIntegrate(2105,Int(Times(u_,Power(Plus(Times(e_DEFAULT,Sqrt(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),Times(f_DEFAULT,Sqrt(Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),CN1)),x_Symbol),
    Condition(Subtract(Dist(e,Int(Times(u,Sqrt(Plus(a,Times(b,x))),Power(Plus(Times(a,Sqr(e)),Times(CN1,c,Sqr(f)),Times(Subtract(Times(b,Sqr(e)),Times(d,Sqr(f))),x)),CN1)),x),x),Dist(f,Int(Times(u,Sqrt(Plus(c,Times(d,x))),Power(Plus(Times(a,Sqr(e)),Times(CN1,c,Sqr(f)),Times(Subtract(Times(b,Sqr(e)),Times(d,Sqr(f))),x)),CN1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),NeQ(Subtract(Times(a,Sqr(e)),Times(c,Sqr(f))),C0),NeQ(Subtract(Times(b,Sqr(e)),Times(d,Sqr(f))),C0)))),
IIntegrate(2106,Int(Times(u_DEFAULT,Power(Plus(Times(d_DEFAULT,Power(x_,n_DEFAULT)),Times(c_DEFAULT,Sqrt(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,p_DEFAULT)))))),CN1)),x_Symbol),
    Condition(Plus(Negate(Dist(Times(b,Power(Times(a,d),CN1)),Int(Times(u,Power(x,n)),x),x)),Dist(Power(Times(a,c),CN1),Int(Times(u,Sqrt(Plus(a,Times(b,Power(x,Times(C2,n)))))),x),x)),And(FreeQ(List(a,b,c,d,n),x),EqQ(p,Times(C2,n)),EqQ(Subtract(Times(b,Sqr(c)),Sqr(d)),C0)))),
IIntegrate(2107,Int(Times(Power(x_,m_DEFAULT),Power(Plus(Times(d_DEFAULT,Power(x_,n_DEFAULT)),Times(c_DEFAULT,Sqrt(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,p_DEFAULT)))))),CN1)),x_Symbol),
    Condition(Plus(Negate(Dist(d,Int(Times(Power(x,Plus(m,n)),Power(Plus(Times(a,Sqr(c)),Times(Subtract(Times(b,Sqr(c)),Sqr(d)),Power(x,Times(C2,n)))),CN1)),x),x)),Dist(c,Int(Times(Power(x,m),Sqrt(Plus(a,Times(b,Power(x,Times(C2,n))))),Power(Plus(Times(a,Sqr(c)),Times(Subtract(Times(b,Sqr(c)),Sqr(d)),Power(x,Times(C2,n)))),CN1)),x),x)),And(FreeQ(List(a,b,c,d,m,n),x),EqQ(p,Times(C2,n)),NeQ(Subtract(Times(b,Sqr(c)),Sqr(d)),C0)))),
IIntegrate(2108,Int(Times(Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_),Times(f_DEFAULT,Sqr(x_))),CN1D2),Power(Plus(a_,Times(b_DEFAULT,Power(x_,C3))),CN1)),x_Symbol),
    Condition(With(List(Set(r,Numerator(Rt(Times(a,Power(b,CN1)),C3))),Set(s,Denominator(Rt(Times(a,Power(b,CN1)),C3)))),Plus(Dist(Times(r,Power(Times(C3,a),CN1)),Int(Power(Times(Plus(r,Times(s,x)),Sqrt(Plus(d,Times(e,x),Times(f,Sqr(x))))),CN1),x),x),Dist(Times(r,Power(Times(C3,a),CN1)),Int(Times(Subtract(Times(C2,r),Times(s,x)),Power(Times(Plus(Sqr(r),Times(CN1,r,s,x),Times(Sqr(s),Sqr(x))),Sqrt(Plus(d,Times(e,x),Times(f,Sqr(x))))),CN1)),x),x))),And(FreeQ(List(a,b,d,e,f),x),PosQ(Times(a,Power(b,CN1)))))),
IIntegrate(2109,Int(Times(Power(Plus(d_DEFAULT,Times(f_DEFAULT,Sqr(x_))),CN1D2),Power(Plus(a_,Times(b_DEFAULT,Power(x_,C3))),CN1)),x_Symbol),
    Condition(With(List(Set(r,Numerator(Rt(Times(a,Power(b,CN1)),C3))),Set(s,Denominator(Rt(Times(a,Power(b,CN1)),C3)))),Plus(Dist(Times(r,Power(Times(C3,a),CN1)),Int(Power(Times(Plus(r,Times(s,x)),Sqrt(Plus(d,Times(f,Sqr(x))))),CN1),x),x),Dist(Times(r,Power(Times(C3,a),CN1)),Int(Times(Subtract(Times(C2,r),Times(s,x)),Power(Times(Plus(Sqr(r),Times(CN1,r,s,x),Times(Sqr(s),Sqr(x))),Sqrt(Plus(d,Times(f,Sqr(x))))),CN1)),x),x))),And(FreeQ(List(a,b,d,f),x),PosQ(Times(a,Power(b,CN1)))))),
IIntegrate(2110,Int(Times(Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_),Times(f_DEFAULT,Sqr(x_))),CN1D2),Power(Plus(a_,Times(b_DEFAULT,Power(x_,C3))),CN1)),x_Symbol),
    Condition(With(List(Set(r,Numerator(Rt(Times(CN1,a,Power(b,CN1)),C3))),Set(s,Denominator(Rt(Times(CN1,a,Power(b,CN1)),C3)))),Plus(Dist(Times(r,Power(Times(C3,a),CN1)),Int(Power(Times(Subtract(r,Times(s,x)),Sqrt(Plus(d,Times(e,x),Times(f,Sqr(x))))),CN1),x),x),Dist(Times(r,Power(Times(C3,a),CN1)),Int(Times(Plus(Times(C2,r),Times(s,x)),Power(Times(Plus(Sqr(r),Times(r,s,x),Times(Sqr(s),Sqr(x))),Sqrt(Plus(d,Times(e,x),Times(f,Sqr(x))))),CN1)),x),x))),And(FreeQ(List(a,b,d,e,f),x),NegQ(Times(a,Power(b,CN1)))))),
IIntegrate(2111,Int(Times(Power(Plus(d_DEFAULT,Times(f_DEFAULT,Sqr(x_))),CN1D2),Power(Plus(a_,Times(b_DEFAULT,Power(x_,C3))),CN1)),x_Symbol),
    Condition(With(List(Set(r,Numerator(Rt(Times(CN1,a,Power(b,CN1)),C3))),Set(s,Denominator(Rt(Times(CN1,a,Power(b,CN1)),C3)))),Plus(Dist(Times(r,Power(Times(C3,a),CN1)),Int(Power(Times(Subtract(r,Times(s,x)),Sqrt(Plus(d,Times(f,Sqr(x))))),CN1),x),x),Dist(Times(r,Power(Times(C3,a),CN1)),Int(Times(Plus(Times(C2,r),Times(s,x)),Power(Times(Plus(Sqr(r),Times(r,s,x),Times(Sqr(s),Sqr(x))),Sqrt(Plus(d,Times(f,Sqr(x))))),CN1)),x),x))),And(FreeQ(List(a,b,d,f),x),NegQ(Times(a,Power(b,CN1)))))),
IIntegrate(2112,Int(Times(u_,Power(v_,CN1D2),Plus(A_,Times(B_DEFAULT,Power(x_,C4)))),x_Symbol),
    Condition(With(List(Set(a,Coeff(v,x,C0)),Set(b,Coeff(v,x,C2)),Set(c,Coeff(v,x,C4)),Set(d,Coeff(Power(u,CN1),x,C0)),Set(e,Coeff(Power(u,CN1),x,C2)),Set(f,Coeff(Power(u,CN1),x,C4))),Condition(Dist(ASymbol,Subst(Int(Power(Subtract(d,Times(Subtract(Times(b,d),Times(a,e)),Sqr(x))),CN1),x),x,Times(x,Power(v,CN1D2))),x),And(EqQ(Plus(Times(a,BSymbol),Times(ASymbol,c)),C0),EqQ(Subtract(Times(c,d),Times(a,f)),C0)))),And(FreeQ(List(ASymbol,BSymbol),x),PolyQ(v,Sqr(x),C2),PolyQ(Power(u,CN1),Sqr(x),C2)))),
IIntegrate(2113,Int(Times(Power(Plus(a_,Times(b_DEFAULT,x_)),CN1),Power(Plus(c_,Times(d_DEFAULT,Sqr(x_))),CN1D2),Power(Plus(e_,Times(f_DEFAULT,Sqr(x_))),CN1D2)),x_Symbol),
    Condition(Subtract(Dist(a,Int(Power(Times(Subtract(Sqr(a),Times(Sqr(b),Sqr(x))),Sqrt(Plus(c,Times(d,Sqr(x)))),Sqrt(Plus(e,Times(f,Sqr(x))))),CN1),x),x),Dist(b,Int(Times(x,Power(Times(Subtract(Sqr(a),Times(Sqr(b),Sqr(x))),Sqrt(Plus(c,Times(d,Sqr(x)))),Sqrt(Plus(e,Times(f,Sqr(x))))),CN1)),x),x)),FreeQ(List(a,b,c,d,e,f),x))),
IIntegrate(2114,Int(Times(Plus(g_DEFAULT,Times(h_DEFAULT,x_)),Sqrt(Plus(d_DEFAULT,Times(e_DEFAULT,x_),Times(f_DEFAULT,Sqrt(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_)))))))),x_Symbol),
    Condition(Simp(Times(C2,Subtract(Plus(Times(f,Plus(Times(C5,b,c,Sqr(g)),Times(CN1,C2,Sqr(b),g,h),Times(CN1,C3,a,c,g,h),Times(C2,a,b,Sqr(h)))),Times(c,f,Plus(Times(C10,c,Sqr(g)),Times(CN1,b,g,h),Times(a,Sqr(h))),x),Times(C9,Sqr(c),f,g,h,Sqr(x)),Times(C3,Sqr(c),f,Sqr(h),Power(x,C3))),Times(Subtract(Times(e,g),Times(d,h)),Plus(Times(C5,c,g),Times(CN1,C2,b,h),Times(c,h,x)),Sqrt(Plus(a,Times(b,x),Times(c,Sqr(x)))))),Sqrt(Plus(d,Times(e,x),Times(f,Sqrt(Plus(a,Times(b,x),Times(c,Sqr(x))))))),Power(Times(ZZ(15L),Sqr(c),f,Plus(g,Times(h,x))),CN1)),x),And(FreeQ(List(a,b,c,d,e,f,g,h),x),EqQ(Subtract(Sqr(Subtract(Times(e,g),Times(d,h))),Times(Sqr(f),Plus(Times(c,Sqr(g)),Times(CN1,b,g,h),Times(a,Sqr(h))))),C0),EqQ(Subtract(Subtract(Times(C2,Sqr(e),g),Times(C2,d,e,h)),Times(Sqr(f),Subtract(Times(C2,c,g),Times(b,h)))),C0)))),
IIntegrate(2115,Int(Times(Power(Plus(u_,Times(f_DEFAULT,Plus(j_DEFAULT,Times(k_DEFAULT,Sqrt(v_))))),n_DEFAULT),Power(Plus(g_DEFAULT,Times(h_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(Int(Times(Power(Plus(g,Times(h,x)),m),Power(Plus(ExpandToSum(Plus(u,Times(f,j)),x),Times(f,k,Sqrt(ExpandToSum(v,x)))),n)),x),And(FreeQ(List(f,g,h,j,k,m,n),x),LinearQ(u,x),QuadraticQ(v,x),Not(And(LinearMatchQ(u,x),QuadraticMatchQ(v,x),Or(EqQ(j,C0),EqQ(f,C1)))),EqQ(Subtract(Sqr(Subtract(Times(Coefficient(u,x,C1),g),Times(h,Plus(Coefficient(u,x,C0),Times(f,j))))),Times(Sqr(f),Sqr(k),Plus(Times(Coefficient(v,x,C2),Sqr(g)),Times(CN1,Coefficient(v,x,C1),g,h),Times(Coefficient(v,x,C0),Sqr(h))))),C0)))),
IIntegrate(2116,Int(Power(Plus(g_DEFAULT,Times(h_DEFAULT,Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_),Times(f_DEFAULT,Sqrt(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_)))))),n_))),p_DEFAULT),x_Symbol),
    Condition(Dist(C2,Subst(Int(Times(Power(Plus(g,Times(h,Power(x,n))),p),Plus(Times(Sqr(d),e),Times(CN1,Subtract(Times(b,d),Times(a,e)),Sqr(f)),Times(CN1,Subtract(Times(C2,d,e),Times(b,Sqr(f))),x),Times(e,Sqr(x))),Power(Plus(Times(CN2,d,e),Times(b,Sqr(f)),Times(C2,e,x)),CN2)),x),x,Plus(d,Times(e,x),Times(f,Sqrt(Plus(a,Times(b,x),Times(c,Sqr(x))))))),x),And(FreeQ(List(a,b,c,d,e,f,g,h,n),x),EqQ(Subtract(Sqr(e),Times(c,Sqr(f))),C0),IntegerQ(p)))),
IIntegrate(2117,Int(Power(Plus(g_DEFAULT,Times(h_DEFAULT,Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_),Times(f_DEFAULT,Sqrt(Plus(a_,Times(c_DEFAULT,Sqr(x_)))))),n_))),p_DEFAULT),x_Symbol),
    Condition(Dist(Power(Times(C2,e),CN1),Subst(Int(Times(Power(Plus(g,Times(h,Power(x,n))),p),Plus(Sqr(d),Times(a,Sqr(f)),Times(CN1,C2,d,x),Sqr(x)),Power(Subtract(d,x),CN2)),x),x,Plus(d,Times(e,x),Times(f,Sqrt(Plus(a,Times(c,Sqr(x))))))),x),And(FreeQ(List(a,c,d,e,f,g,h,n),x),EqQ(Subtract(Sqr(e),Times(c,Sqr(f))),C0),IntegerQ(p)))),
IIntegrate(2118,Int(Power(Plus(g_DEFAULT,Times(h_DEFAULT,Power(Plus(u_,Times(f_DEFAULT,Sqrt(v_))),n_))),p_DEFAULT),x_Symbol),
    Condition(Int(Power(Plus(g,Times(h,Power(Plus(ExpandToSum(u,x),Times(f,Sqrt(ExpandToSum(v,x)))),n))),p),x),And(FreeQ(List(f,g,h,n),x),LinearQ(u,x),QuadraticQ(v,x),Not(And(LinearMatchQ(u,x),QuadraticMatchQ(v,x))),EqQ(Subtract(Sqr(Coefficient(u,x,C1)),Times(Coefficient(v,x,C2),Sqr(f))),C0),IntegerQ(p)))),
IIntegrate(2119,Int(Times(Power(Plus(g_DEFAULT,Times(h_DEFAULT,x_)),m_DEFAULT),Power(Plus(Times(e_DEFAULT,x_),Times(f_DEFAULT,Sqrt(Plus(a_DEFAULT,Times(c_DEFAULT,Sqr(x_)))))),n_DEFAULT)),x_Symbol),
    Condition(Dist(Power(Times(Power(C2,Plus(m,C1)),Power(e,Plus(m,C1))),CN1),Subst(Int(Times(Power(x,Subtract(Subtract(n,m),C2)),Plus(Times(a,Sqr(f)),Sqr(x)),Power(Plus(Times(CN1,a,Sqr(f),h),Times(C2,e,g,x),Times(h,Sqr(x))),m)),x),x,Plus(Times(e,x),Times(f,Sqrt(Plus(a,Times(c,Sqr(x))))))),x),And(FreeQ(List(a,c,e,f,g,h,n),x),EqQ(Subtract(Sqr(e),Times(c,Sqr(f))),C0),IntegerQ(m)))),
IIntegrate(2120,Int(Times(Power(x_,p_DEFAULT),Power(Plus(g_,Times(i_DEFAULT,Sqr(x_))),m_DEFAULT),Power(Plus(Times(e_DEFAULT,x_),Times(f_DEFAULT,Sqrt(Plus(a_,Times(c_DEFAULT,Sqr(x_)))))),n_DEFAULT)),x_Symbol),
    Condition(Dist(Times(C1,Power(Times(i,Power(c,CN1)),m),Power(Times(Power(C2,Plus(Times(C2,m),p,C1)),Power(e,Plus(p,C1)),Power(f,Times(C2,m))),CN1)),Subst(Int(Times(Power(x,Subtract(Subtract(Subtract(n,Times(C2,m)),p),C2)),Power(Plus(Times(CN1,a,Sqr(f)),Sqr(x)),p),Power(Plus(Times(a,Sqr(f)),Sqr(x)),Plus(Times(C2,m),C1))),x),x,Plus(Times(e,x),Times(f,Sqrt(Plus(a,Times(c,Sqr(x))))))),x),And(FreeQ(List(a,c,e,f,g,i,n),x),EqQ(Subtract(Sqr(e),Times(c,Sqr(f))),C0),EqQ(Subtract(Times(c,g),Times(a,i)),C0),IntegersQ(p,Times(C2,m)),Or(IntegerQ(m),GtQ(Times(i,Power(c,CN1)),C0)))))
  );
}
