package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.*;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.*;

import org.matheclipse.core.interfaces.IAST;
/** 
 * UtilityFunctions rules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class UtilityFunctions4 { 
  public static IAST RULES = List( 
ISetDelayed(PolynomialDivide(u_,v_,x_Symbol),
    Module(List(Set($s("quo"),PolynomialQuotient(u,v,x)),Set($s("rem"),PolynomialRemainder(u,v,x)),$s("free"),$s("monomial")),CompoundExpression(Set($s("quo"),Apply(Plus,Map(Function(Simp(Together(Times(Coefficient($s("quo"),x,Slot1),Power(x,Slot1))),x)),Exponent($s("quo"),x,$s("List"))))),Set($s("rem"),Together($s("rem"))),Set($s("free"),FreeFactors($s("rem"),x)),Set($s("rem"),NonfreeFactors($s("rem"),x)),Set($s("monomial"),Power(x,Exponent($s("rem"),x,$s("Min")))),If(NegQ(Coefficient($s("rem"),x,C0)),Set($s("monomial"),Negate($s("monomial")))),Set($s("rem"),Apply(Plus,Map(Function(Simp(Together(Times(Coefficient($s("rem"),x,Slot1),Power(x,Slot1),Power($s("monomial"),-1))),x)),Exponent($s("rem"),x,$s("List"))))),If(BinomialQ(v,x),Plus($s("quo"),Times($s("free"),$s("monomial"),$s("rem"),Power(ExpandToSum(v,x),-1))),Plus($s("quo"),Times($s("free"),$s("monomial"),$s("rem"),Power(v,-1))))))),
ISetDelayed(PolynomialDivide(u_,v_,w_,x_Symbol),
    ReplaceAll(PolynomialDivide(PolynomialInSubst(u,w,x),PolynomialInSubst(v,w,x),x),List(Rule(x,w)))),
ISetDelayed(ExpandToSum(u_,v_,x_Symbol),
    Module(List(Set(w,ExpandToSum(v,x)),r),CompoundExpression(Set(r,NonfreeTerms(w,x)),If(SumQ(r),Plus(Times(u,FreeTerms(w,x)),Map(Function(MergeMonomials(Times(u,Slot1),x)),r)),Plus(Times(u,FreeTerms(w,x)),MergeMonomials(Times(u,r),x)))))),
ISetDelayed(ExpandToSum(u_,x_Symbol),
    If(PolyQ(u,x),Simp(Apply(Plus,Map(Function(Times(Coeff(u,x,Slot1),Power(x,Slot1))),Expon(u,x,$s("List")))),x),If(BinomialQ(u,x),$(Function(Plus(Part(Slot1,C1),Times(Part(Slot1,C2),Power(x,Part(Slot1,C3))))),BinomialParts(u,x)),If(TrinomialQ(u,x),$(Function(Plus(Part(Slot1,C1),Times(Part(Slot1,C2),Power(x,Part(Slot1,C4))),Times(Part(Slot1,C3),Power(x,Times(C2,Part(Slot1,C4)))))),TrinomialParts(u,x)),If(GeneralizedBinomialQ(u,x),$(Function(Plus(Times(Part(Slot1,C1),Power(x,Part(Slot1,C4))),Times(Part(Slot1,C2),Power(x,Part(Slot1,C3))))),GeneralizedBinomialParts(u,x)),If(GeneralizedTrinomialQ(u,x),$(Function(Plus(Times(Part(Slot1,C1),Power(x,Part(Slot1,C5))),Times(Part(Slot1,C2),Power(x,Part(Slot1,C4))),Times(Part(Slot1,C3),Power(x,Plus(Times(C2,Part(Slot1,C4)),Negate(Part(Slot1,C5))))))),GeneralizedTrinomialParts(u,x)),CompoundExpression(Print($str("Warning: Unrecognized expression for expansion "),u),Expand(u,x)))))))),
ISetDelayed(ExpandTrig(u_,x_Symbol),
    ActivateTrig(ExpandIntegrand(u,x))),
ISetDelayed(ExpandTrig(u_,v_,x_Symbol),
    With(List(Set(w,ExpandTrig(v,x)),Set(z,ActivateTrig(u))),If(SumQ(w),Map(Function(Times(z,Slot1)),w),Times(z,w)))),
ISetDelayed(ExpandIntegrand(u_,v_,x_Symbol),
    Module(List(Set(w,ExpandIntegrand(v,x)),r),CompoundExpression(Set(r,NonfreeTerms(w,x)),If(SumQ(r),Plus(Times(u,FreeTerms(w,x)),Map(Function(MergeMonomials(Times(u,Slot1),x)),r)),Plus(Times(u,FreeTerms(w,x)),MergeMonomials(Times(u,r),x)))))),
ISetDelayed(ExpandIntegrand(Power(u_,p_DEFAULT),x_Symbol),
    Condition(If(EqQ(p,C1),ExpandCleanup(u,x),ExpandCleanup(Expand(Power(u,p),x),x)),And(SumQ(u),IGtQ(p,C0)))),
ISetDelayed(ExpandIntegrand(Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_DEFAULT),x_Symbol),
    Condition(ExpandIntegrand(Times(Power(x,Times(n,p)),Power(Plus(b,Times(a,Power(x,Negate(n)))),p)),x),And(IntegerQ(p),ILtQ(n,C0)))),
ISetDelayed(ExpandIntegrand(Times(Power(x_,m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_DEFAULT)),x_Symbol),
    Condition(ExpandIntegrand(Times(Power(x,Plus(m,Times(n,p))),Power(Plus(b,Times(a,Power(x,Negate(n)))),p)),x),And(IntegerQ(p),ILtQ(n,C0)))),
ISetDelayed(ExpandIntegrand(Times($p("§px",true),Power(x_,m_),Power(Plus(Times(b_DEFAULT,Power(x_,n_DEFAULT)),Times(c_DEFAULT,Power(x_,$p("n1")))),p_DEFAULT)),x_Symbol),
    Condition(ExpandIntegrand(Times($s("§px"),Power(x,Plus(m,Times(n,p))),Power(Plus(b,Times(c,x)),p)),x),And(FreeQ(List(b,c,m),x),PolyQ($s("§px"),x),IGtQ(n,C0),EqQ($s("n1"),Plus(n,C1)),IntegerQ(p)))),
ISetDelayed(ExpandIntegrand(Times($p("§px",true),Power(Plus(Times(b_DEFAULT,Power(x_,n_DEFAULT)),Times(c_DEFAULT,Power(x_,$p("n1")))),p_DEFAULT)),x_Symbol),
    Condition(ExpandIntegrand(Times($s("§px"),Power(x,Times(n,p)),Power(Plus(b,Times(c,x)),p)),x),And(FreeQ(List(b,c),x),PolyQ($s("§px"),x),IGtQ(n,C0),EqQ($s("n1"),Plus(n,C1)),IntegerQ(p)))),
ISetDelayed(ExpandIntegrand(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(F_,u_))),p_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,Power(F_,v_))),q_DEFAULT)),x_Symbol),
    Condition(With(List(Set(k,Simplify(Times(u,Power(v,-1))))),Condition(ReplaceAll(ExpandIntegrand(Times(Power(Plus(a,Times(b,Power(x,Numerator(k)))),p),Power(Plus(c,Times(d,Power(x,Denominator(k)))),q)),x),Rule(x,Power(FSymbol,Times(v,Power(Denominator(k),-1))))),RationalQ(k))),And(FreeQ(List(FSymbol,a,b,c,d),x),IntegersQ(p,q)))),
ISetDelayed(ExpandIntegrand(Times(Power(F_,Times(e_DEFAULT,Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),n_DEFAULT))),Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_DEFAULT),Power(Plus(g_DEFAULT,Times(h_DEFAULT,x_)),-1)),x_Symbol),
    Condition(With(List(Set($s("tmp"),Plus(Times(a,h),Times(CN1,b,g)))),Module(List(k),Plus(Times(SimplifyTerm(Times(Power($s("tmp"),m),Power(Power(h,m),-1)),x),Power(FSymbol,Times(e,Power(Plus(c,Times(d,x)),n))),Power(Plus(g,Times(h,x)),-1)),Sum(Times(SimplifyTerm(Times(b,Power($s("tmp"),Plus(k,Negate(C1))),Power(Power(h,k),-1)),x),Power(FSymbol,Times(e,Power(Plus(c,Times(d,x)),n))),Power(Plus(a,Times(b,x)),Plus(m,Negate(k)))),List(k,C1,m))))),And(FreeQ(List(FSymbol,a,b,c,d,e,g,h),x),IGtQ(m,C0),EqQ(Plus(Times(b,c),Times(CN1,a,d)),C0)))),
ISetDelayed(ExpandIntegrand(Times(Power(F_,Times(b_DEFAULT,Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),n_DEFAULT))),Power(x_,m_DEFAULT),Power(Plus(e_,Times(f_DEFAULT,x_)),p_DEFAULT)),x_Symbol),
    Condition(If(And(IGtQ(m,C0),IGtQ(p,C0),LessEqual(m,p),Or(EqQ(n,C1),EqQ(Plus(Times(d,e),Times(CN1,c,f)),C0))),ExpandLinearProduct(Times(Power(Plus(e,Times(f,x)),p),Power(FSymbol,Times(b,Power(Plus(c,Times(d,x)),n)))),Power(x,m),e,f,x),If(IGtQ(p,C0),Distribute(Times(Power(x,m),Power(FSymbol,Times(b,Power(Plus(c,Times(d,x)),n))),Expand(Power(Plus(e,Times(f,x)),p),x)),Plus,Times),ExpandIntegrand(Power(FSymbol,Times(b,Power(Plus(c,Times(d,x)),n))),Times(Power(x,m),Power(Plus(e,Times(f,x)),p)),x))),FreeQ(List(FSymbol,b,c,d,e,f,m,n,p),x))),
ISetDelayed(ExpandIntegrand(Times(Power(F_,Plus(a_DEFAULT,Times(b_DEFAULT,Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),n_DEFAULT)))),Power(x_,m_DEFAULT),Power(Plus(e_,Times(f_DEFAULT,x_)),p_DEFAULT)),x_Symbol),
    Condition(If(And(IGtQ(m,C0),IGtQ(p,C0),LessEqual(m,p),Or(EqQ(n,C1),EqQ(Plus(Times(d,e),Times(CN1,c,f)),C0))),ExpandLinearProduct(Times(Power(Plus(e,Times(f,x)),p),Power(FSymbol,Plus(a,Times(b,Power(Plus(c,Times(d,x)),n))))),Power(x,m),e,f,x),If(IGtQ(p,C0),Distribute(Times(Power(x,m),Power(FSymbol,Plus(a,Times(b,Power(Plus(c,Times(d,x)),n)))),Expand(Power(Plus(e,Times(f,x)),p),x)),Plus,Times),ExpandIntegrand(Power(FSymbol,Plus(a,Times(b,Power(Plus(c,Times(d,x)),n)))),Times(Power(x,m),Power(Plus(e,Times(f,x)),p)),x))),FreeQ(List(FSymbol,a,b,c,d,e,f,m,n,p),x))),
ISetDelayed(ExpandIntegrand(Times(Power(Plus(a_,Times(b_DEFAULT,Power(F_,v_))),m_DEFAULT),Power(Plus(c_,Times(d_DEFAULT,Power(F_,v_))),n_),u_DEFAULT),x_Symbol),
    Condition(With(List(Set(w,ReplaceAll(ExpandIntegrand(Times(Power(Plus(a,Times(b,x)),m),Power(Plus(c,Times(d,x)),n)),x),Rule(x,Power(FSymbol,v))))),Condition(Map(Function(Times(u,Slot1)),w),SumQ(w))),And(FreeQ(List(FSymbol,a,b,c,d),x),IntegersQ(m,n),Less(n,C0)))),
ISetDelayed(ExpandIntegrand(Times(Power(F_,Times(e_DEFAULT,Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),n_DEFAULT))),u_,Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(With(List(Set(v,ExpandIntegrand(Times(u,Power(Plus(a,Times(b,x)),m)),x))),Condition(Distribute(Times(Power(FSymbol,Times(e,Power(Plus(c,Times(d,x)),n))),v),Plus,Times),SumQ(v))),And(FreeQ(List(FSymbol,a,b,c,d,e,m,n),x),PolynomialQ(u,x)))),
ISetDelayed(ExpandIntegrand(Times(u_,Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_DEFAULT),Log(Times(c_DEFAULT,Power(Plus(d_DEFAULT,Times(e_DEFAULT,Power(x_,n_DEFAULT))),p_DEFAULT)))),x_Symbol),
    Condition(ExpandIntegrand(Log(Times(c,Power(Plus(d,Times(e,Power(x,n))),p))),Times(u,Power(Plus(a,Times(b,x)),m)),x),And(FreeQ(List(a,b,c,d,e,m,n,p),x),PolynomialQ(u,x)))),
ISetDelayed(ExpandIntegrand(Times(Power(F_,Times(e_DEFAULT,Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),n_DEFAULT))),u_),x_Symbol),
    Condition(If(EqQ(n,C1),ExpandIntegrand(Power(FSymbol,Times(e,Power(Plus(c,Times(d,x)),n))),u,x),ExpandLinearProduct(Power(FSymbol,Times(e,Power(Plus(c,Times(d,x)),n))),u,c,d,x)),And(FreeQ(List(FSymbol,c,d,e,n),x),PolynomialQ(u,x)))),
ISetDelayed(ExpandIntegrand(Times(Power($(F_,u_),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,$(G_,u_))),n_DEFAULT)),x_Symbol),
    Condition(ReplaceAll(ExpandIntegrand(Times(Power(Plus(a,Times(b,x)),n),Power(Power(x,m),-1)),x),Rule(x,G(u))),And(FreeQ(List(a,b),x),IntegersQ(m,n),SameQ(Times(F(u),G(u)),C1)))),
ISetDelayed(ExpandIntegrand(Times(u_,Power(Plus(a_DEFAULT,Times(b_DEFAULT,Log(Times(c_DEFAULT,Power(Times(d_DEFAULT,Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),p_DEFAULT)),q_DEFAULT))))),n_)),x_Symbol),
    Condition(ExpandLinearProduct(Power(Plus(a,Times(b,Log(Times(c,Power(Times(d,Power(Plus(e,Times(f,x)),p)),q))))),n),u,e,f,x),And(FreeQ(List(a,b,c,d,e,f,n,p,q),x),PolynomialQ(u,x)))),
ISetDelayed(ExpandIntegrand(Times(u_,Power(Plus(a_DEFAULT,Times(b_DEFAULT,$(F_,Plus(c_DEFAULT,Times(d_DEFAULT,x_))))),n_)),x_Symbol),
    Condition(ExpandLinearProduct(Power(Plus(a,Times(b,F(Plus(c,Times(d,x))))),n),u,c,d,x),And(FreeQ(List(a,b,c,d,n),x),PolynomialQ(u,x),MemberQ(List($s("ArcSin"),$s("ArcCos"),$s("ArcSinh"),$s("ArcCosh")),FSymbol)))),
ISetDelayed(ExpandIntegrand(Times(u_DEFAULT,Power(Plus(Times(a_DEFAULT,Power(x_,n_)),Times(b_DEFAULT,Sqrt(Plus(c_,Times(d_DEFAULT,Power(x_,j_)))))),-1)),x_Symbol),
    Condition(ExpandIntegrand(Times(u,Plus(Times(a,Power(x,n)),Times(CN1,b,Sqrt(Plus(c,Times(d,Power(x,Times(C2,n))))))),Power(Plus(Times(CN1,Sqr(b),c),Times(Plus(Sqr(a),Times(CN1,Sqr(b),d)),Power(x,Times(C2,n)))),-1)),x),And(FreeQ(List(a,b,c,d,n),x),EqQ(j,Times(C2,n))))),
ISetDelayed(ExpandIntegrand(Times(Power(Plus(a_,Times(b_DEFAULT,x_)),m_),Power(Plus(c_,Times(d_DEFAULT,x_)),-1)),x_Symbol),
    Condition(If(RationalQ(a,b,c,d),ExpandExpression(Times(Power(Plus(a,Times(b,x)),m),Power(Plus(c,Times(d,x)),-1)),x),With(List(Set($s("tmp"),Plus(Times(a,d),Times(CN1,b,c)))),Module(List(k),Plus(Times(SimplifyTerm(Times(Power($s("tmp"),m),Power(Power(d,m),-1)),x),Power(Plus(c,Times(d,x)),-1)),Sum(Times(SimplifyTerm(Times(b,Power($s("tmp"),Plus(k,Negate(C1))),Power(Power(d,k),-1)),x),Power(Plus(a,Times(b,x)),Plus(m,Negate(k)))),List(k,C1,m)))))),And(FreeQ(List(a,b,c,d),x),IGtQ(m,C0)))),
ISetDelayed(ExpandIntegrand(Times(Plus(A_,Times(B_DEFAULT,x_)),Power(Plus(a_,Times(b_DEFAULT,x_)),m_DEFAULT),Power(Plus(c_,Times(d_DEFAULT,x_)),-1)),x_Symbol),
    Condition(If(RationalQ(a,b,c,d,ASymbol,BSymbol),ExpandExpression(Times(Power(Plus(a,Times(b,x)),m),Plus(ASymbol,Times(BSymbol,x)),Power(Plus(c,Times(d,x)),-1)),x),Module(List($s("tmp1"),$s("tmp2")),CompoundExpression(Set($s("tmp1"),Times(Plus(Times(ASymbol,d),Times(CN1,BSymbol,c)),Power(d,-1))),Set($s("tmp2"),ExpandIntegrand(Times(Power(Plus(a,Times(b,x)),m),Power(Plus(c,Times(d,x)),-1)),x)),Set($s("tmp2"),If(SumQ($s("tmp2")),Map(Function(SimplifyTerm(Times($s("tmp1"),Slot1),x)),$s("tmp2")),SimplifyTerm(Times($s("tmp1"),$s("tmp2")),x))),Plus(Times(SimplifyTerm(Times(BSymbol,Power(d,-1)),x),Power(Plus(a,Times(b,x)),m)),$s("tmp2"))))),And(FreeQ(List(a,b,c,d,ASymbol,BSymbol),x),IGtQ(m,C0)))),
ISetDelayed(ExpandIntegrand(Times(u_,Power(Plus(a_,Times(b_DEFAULT,x_)),m_DEFAULT),Power(Plus(c_,Times(d_DEFAULT,x_)),n_DEFAULT)),x_Symbol),
    Condition(ExpandIntegrand(Power(Plus(c,Times(d,x)),n),Times(u,Power(Plus(a,Times(b,x)),m)),x),And(FreeQ(List(a,b,c,d,m,n),x),PolynomialQ(u,x),Not(IntegerQ(m)),IGtQ(Plus(n,Negate(m)),C0)))),
ISetDelayed(ExpandIntegrand(Times(u_,Power(Plus(a_,Times(b_DEFAULT,x_)),m_DEFAULT)),x_Symbol),
    Condition(With(List(Set($s("sum1"),ExpandLinearProduct(Power(Plus(a,Times(b,x)),m),u,a,b,x))),If(Or(Not(IntegerQ(m)),And(Greater(m,C2),LinearQ(u,x))),$s("sum1"),With(List(Set($s("sum2"),ExpandExpression(Times(u,Power(Plus(a,Times(b,x)),m)),x))),If(SumQ($s("sum2")),If(Greater(m,C0),If(Or(LessEqual(Length($s("sum2")),Plus(Exponent(u,x),C2)),LessEqual(LeafCount($s("sum2")),Times(QQ(2L,3L),LeafCount($s("sum1"))))),$s("sum2"),$s("sum1")),If(LessEqual(LeafCount($s("sum2")),Plus(LeafCount($s("sum1")),C2)),$s("sum2"),$s("sum1"))),$s("sum1"))))),And(FreeQ(List(a,b,m),x),PolynomialQ(u,x),Not(And(IGtQ(m,C0),MatchQ(u,Condition(Times(w_DEFAULT,Power(Plus(c_,Times(d_DEFAULT,x)),p_)),And(FreeQ(List(c,d),x),IntegerQ(p),Greater(p,m))))))))),
ISetDelayed(ExpandIntegrand(Times(u_,Power(v_,n_),Power(Plus(a_,Times(b_DEFAULT,x_)),m_)),x_Symbol),
    Condition($(Function(Plus(ExpandIntegrand(Times(Part(Slot1,C1),Power(Plus(a,Times(b,x)),FractionalPart(m))),x),ExpandIntegrand(Times(Part(Slot1,C2),Power(v,n),Power(Plus(a,Times(b,x)),m)),x))),PolynomialQuotientRemainder(u,Times(Power(v,Negate(n)),Power(Plus(a,Times(b,x)),Negate(IntegerPart(m)))),x)),And(FreeQ(List(a,b,m),x),ILtQ(n,C0),Not(IntegerQ(m)),PolynomialQ(u,x),PolynomialQ(v,x),RationalQ(m),Less(m,CN1),GreaterEqual(Exponent(u,x),Times(CN1,Plus(n,IntegerPart(m)),Exponent(v,x)))))),
ISetDelayed(ExpandIntegrand(Times(u_,Power(v_,n_),Power(Plus(a_,Times(b_DEFAULT,x_)),m_)),x_Symbol),
    Condition($(Function(Plus(ExpandIntegrand(Times(Part(Slot1,C1),Power(Plus(a,Times(b,x)),m)),x),ExpandIntegrand(Times(Part(Slot1,C2),Power(v,n),Power(Plus(a,Times(b,x)),m)),x))),PolynomialQuotientRemainder(u,Power(v,Negate(n)),x)),And(FreeQ(List(a,b,m),x),ILtQ(n,C0),Not(IntegerQ(m)),PolynomialQ(u,x),PolynomialQ(v,x),GreaterEqual(Exponent(u,x),Times(CN1,n,Exponent(v,x)))))),
ISetDelayed(ExpandIntegrand(Power(Plus(a_,Times(b_DEFAULT,Power(u_,n_))),-1),x_Symbol),
    Condition(With(List(Set(r,Numerator(Rt(Times(CN1,a,Power(b,-1)),C2))),Set(s,Denominator(Rt(Times(CN1,a,Power(b,-1)),C2)))),Plus(Times(r,Power(Times(C2,a,Plus(r,Times(CN1,s,Power(u,Times(C1D2,n))))),-1)),Times(r,Power(Times(C2,a,Plus(r,Times(s,Power(u,Times(C1D2,n))))),-1)))),And(FreeQ(List(a,b),x),IGtQ(Times(C1D2,n),C0)))),
ISetDelayed(ExpandIntegrand(Times(Plus(c_,Times(d_DEFAULT,Power(u_,n_))),Power(Plus(a_,Times(b_DEFAULT,Power(u_,$p("n2")))),-1)),x_Symbol),
    Condition(With(List(Set(r,Numerator(Rt(Times(CN1,a,Power(b,-1)),C2))),Set(s,Denominator(Rt(Times(CN1,a,Power(b,-1)),C2)))),Plus(Times(CN1,s,Plus(Times(d,r),Times(c,s)),Power(Times(C2,b,r,Plus(r,Times(CN1,s,Power(u,n)))),-1)),Times(s,Plus(Times(d,r),Times(CN1,c,s)),Power(Times(C2,b,r,Plus(r,Times(s,Power(u,n)))),-1)))),And(FreeQ(List(a,b,c,d),x),IGtQ(n,C0),EqQ($s("n2"),Times(C2,n))))),
ISetDelayed(ExpandIntegrand(Times(Plus(c_DEFAULT,Times(d_DEFAULT,u_)),Power(Plus(a_,Times(b_DEFAULT,u_)),m_)),x_Symbol),
    Condition(Plus(Times(d,Power(b,-1),Power(Plus(a,Times(b,u)),Plus(m,C1))),Times(Plus(Times(b,c),Times(CN1,a,d)),Power(b,-1),Power(Plus(a,Times(b,u)),m))),And(FreeQ(List(a,b,c,d),x),ILtQ(m,C0)))),
ISetDelayed(ExpandIntegrand(Power(Plus(a_,Times(b_DEFAULT,Power(u_,n_))),-1),x_Symbol),
    Condition(With(List(Set(r,Numerator(Rt(Times(CN1,a,Power(b,-1)),n))),Set(s,Denominator(Rt(Times(CN1,a,Power(b,-1)),n)))),Module(List(k),Sum(Times(r,Power(Times(a,n,Plus(r,Times(CN1,Power(CN1,Times(C2,k,Power(n,-1))),s,u))),-1)),List(k,C1,n)))),And(FreeQ(List(a,b),x),IGtQ(n,C1)))),
ISetDelayed(ExpandIntegrand(Times(Plus(c_,Times(d_DEFAULT,Power(u_,m_DEFAULT))),Power(Plus(a_,Times(b_DEFAULT,Power(u_,n_))),-1)),x_Symbol),
    Condition(With(List(Set(r,Numerator(Rt(Times(CN1,a,Power(b,-1)),n))),Set(s,Denominator(Rt(Times(CN1,a,Power(b,-1)),n)))),Module(List(k),Sum(Times(Plus(Times(r,c),Times(r,d,Power(Times(r,Power(s,-1)),m),Power(CN1,Times(CN2,k,m,Power(n,-1))))),Power(Times(a,n,Plus(r,Times(CN1,Power(CN1,Times(C2,k,Power(n,-1))),s,u))),-1)),List(k,C1,n)))),And(FreeQ(List(a,b,c,d),x),IntegersQ(m,n),Less(C0,m,n)))),
ISetDelayed(ExpandIntegrand(Times(Plus(c_DEFAULT,Times(d_DEFAULT,Power(u_,m_DEFAULT)),Times(e_DEFAULT,Power(u_,p_))),Power(Plus(a_,Times(b_DEFAULT,Power(u_,n_))),-1)),x_Symbol),
    Condition(With(List(Set(r,Numerator(Rt(Times(CN1,a,Power(b,-1)),n))),Set(s,Denominator(Rt(Times(CN1,a,Power(b,-1)),n)))),Module(List(k),Sum(Times(Plus(Times(r,c),Times(r,d,Power(Times(r,Power(s,-1)),m),Power(CN1,Times(CN2,k,m,Power(n,-1)))),Times(r,e,Power(Times(r,Power(s,-1)),p),Power(CN1,Times(CN2,k,p,Power(n,-1))))),Power(Times(a,n,Plus(r,Times(CN1,Power(CN1,Times(C2,k,Power(n,-1))),s,u))),-1)),List(k,C1,n)))),And(FreeQ(List(a,b,c,d,e),x),IntegersQ(m,n,p),Less(C0,m,p,n)))),
ISetDelayed(ExpandIntegrand(Times(Plus(c_DEFAULT,Times(d_DEFAULT,Power(u_,m_DEFAULT)),Times(e_DEFAULT,Power(u_,p_)),Times(f_DEFAULT,Power(u_,q_))),Power(Plus(a_,Times(b_DEFAULT,Power(u_,n_))),-1)),x_Symbol),
    Condition(With(List(Set(r,Numerator(Rt(Times(CN1,a,Power(b,-1)),n))),Set(s,Denominator(Rt(Times(CN1,a,Power(b,-1)),n)))),Module(List(k),Sum(Times(Plus(Times(r,c),Times(r,d,Power(Times(r,Power(s,-1)),m),Power(CN1,Times(CN2,k,m,Power(n,-1)))),Times(r,e,Power(Times(r,Power(s,-1)),p),Power(CN1,Times(CN2,k,p,Power(n,-1)))),Times(r,f,Power(Times(r,Power(s,-1)),q),Power(CN1,Times(CN2,k,q,Power(n,-1))))),Power(Times(a,n,Plus(r,Times(CN1,Power(CN1,Times(C2,k,Power(n,-1))),s,u))),-1)),List(k,C1,n)))),And(FreeQ(List(a,b,c,d,e,f),x),IntegersQ(m,n,p,q),Less(C0,m,p,q,n)))),
ISetDelayed(ExpandIntegrand(Power(Plus(a_,Times(c_DEFAULT,Power(u_,n_))),p_),x_Symbol),
    Condition(Module(List(q),ReplaceAll(ExpandIntegrand(Power(Power(c,p),-1),Times(Power(Plus(Negate(q),Times(c,x)),p),Power(Plus(q,Times(c,x)),p)),x),List(Rule(q,Rt(Times(CN1,a,c),C2)),Rule(x,Power(u,Times(C1D2,n)))))),And(FreeQ(List(a,c),x),EvenQ(n),ILtQ(p,C0)))),
ISetDelayed(ExpandIntegrand(Times(Power(u_,m_DEFAULT),Power(Plus(a_DEFAULT,Times(c_DEFAULT,Power(u_,n_))),p_)),x_Symbol),
    Condition(Module(List(q),ReplaceAll(ExpandIntegrand(Power(Power(c,p),-1),Times(Power(x,m),Power(Plus(Negate(q),Times(c,Power(x,Times(C1D2,n)))),p),Power(Plus(q,Times(c,Power(x,Times(C1D2,n)))),p)),x),List(Rule(q,Rt(Times(CN1,a,c),C2)),Rule(x,u)))),And(FreeQ(List(a,c),x),IntegersQ(m,Times(C1D2,n)),ILtQ(p,C0),Less(C0,m,n),Unequal(m,Times(C1D2,n))))),
ISetDelayed(ExpandIntegrand(Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(CN1,a,Power(b,-1)),n))),Module(List($s("ii")),ExpandIntegrand(Power(Negate(b),p),Product(Power(Plus(q,Times(CN1,Power(CN1,Times(C2,$s("ii"),Power(n,-1))),x)),p),List($s("ii"),C1,n)),x))),And(FreeQ(List(a,b),x),IGtQ(n,C1),ILtQ(p,CN1)))),
ISetDelayed(ExpandIntegrand(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(u_,n_DEFAULT)),Times(c_DEFAULT,Power(u_,$p("n2",true)))),p_),x_Symbol),
    Condition(Module(List(q),ReplaceAll(ExpandIntegrand(Power(Times(Power(C4,p),Power(c,p)),-1),Times(Power(Plus(b,Negate(q),Times(C2,c,x)),p),Power(Plus(b,q,Times(C2,c,x)),p)),x),List(Rule(q,Rt(Plus(Sqr(b),Times(CN1,C4,a,c)),C2)),Rule(x,Power(u,n))))),And(FreeQ(List(a,b,c),x),IntegerQ(n),EqQ($s("n2"),Times(C2,n)),ILtQ(p,C0),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0)))),
ISetDelayed(ExpandIntegrand(Times(Power(u_,m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(u_,n_DEFAULT)),Times(c_DEFAULT,Power(u_,$p("n2",true)))),p_)),x_Symbol),
    Condition(Module(List(q),ReplaceAll(ExpandIntegrand(Power(Times(Power(C4,p),Power(c,p)),-1),Times(Power(x,m),Power(Plus(b,Negate(q),Times(C2,c,Power(x,n))),p),Power(Plus(b,q,Times(C2,c,Power(x,n))),p)),x),List(Rule(q,Rt(Plus(Sqr(b),Times(CN1,C4,a,c)),C2)),Rule(x,u)))),And(FreeQ(List(a,b,c),x),IntegersQ(m,n,$s("n2")),EqQ($s("n2"),Times(C2,n)),ILtQ(p,C0),Less(C0,m,Times(C2,n)),Not(And(Equal(m,n),Equal(p,CN1))),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0)))),
ISetDelayed(ExpandIntegrand(Times(Plus(c_,Times(d_DEFAULT,Power(u_,n_DEFAULT))),Power(Plus(a_,Times(b_DEFAULT,Power(u_,$p("n2",true)))),-1)),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(CN1,a,Power(b,-1)),C2))),Plus(Times(CN1,Plus(c,Times(CN1,d,q)),Power(Times(C2,b,q,Plus(q,Power(u,n))),-1)),Times(CN1,Plus(c,Times(d,q)),Power(Times(C2,b,q,Plus(q,Negate(Power(u,n)))),-1)))),And(FreeQ(List(a,b,c,d,n),x),EqQ($s("n2"),Times(C2,n))))),
ISetDelayed(ExpandIntegrand(Times(Plus(d_DEFAULT,Times(e_DEFAULT,Plus(f_DEFAULT,Times(g_DEFAULT,Power(u_,n_DEFAULT))))),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(u_,n_DEFAULT)),Times(c_DEFAULT,Power(u_,$p("n2",true)))),-1)),x_Symbol),
    Condition(With(List(Set(q,Rt(Plus(Sqr(b),Times(CN1,C4,a,c)),C2))),With(List(Set(r,TogetherSimplify(Times(Plus(Times(C2,c,Plus(d,Times(e,f))),Times(CN1,b,e,g)),Power(q,-1))))),Plus(Times(Plus(Times(e,g),r),Power(Plus(b,Negate(q),Times(C2,c,Power(u,n))),-1)),Times(Plus(Times(e,g),Negate(r)),Power(Plus(b,q,Times(C2,c,Power(u,n))),-1))))),And(FreeQ(List(a,b,c,d,e,f,g,n),x),EqQ($s("n2"),Times(C2,n)),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0)))),
ISetDelayed(ExpandIntegrand(Times(u_,Power(v_,-1)),x_Symbol),
    Condition(PolynomialDivide(u,v,x),And(PolynomialQ(u,x),PolynomialQ(v,x),GreaterEqual(Exponent(u,x),Exponent(v,x))))),
ISetDelayed(ExpandIntegrand(Times(u_,Power(Times(a_DEFAULT,x_),p_)),x_Symbol),
    Condition(ExpandToSum(Power(Times(a,x),p),u,x),And(Not(IntegerQ(p)),PolynomialQ(u,x)))),
ISetDelayed(ExpandIntegrand(Times(u_DEFAULT,Power(v_,p_)),x_Symbol),
    Condition(ExpandIntegrand(NormalizeIntegrand(Power(v,p),x),u,x),Not(IntegerQ(p)))),
ISetDelayed(ExpandIntegrand(u_,x_Symbol),
    With(List(Set(v,ExpandExpression(u,x))),Condition(v,SumQ(v)))),
ISetDelayed(ExpandIntegrand(Times(Power(u_,m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Power(u_,n_))),-1)),x_Symbol),
    Condition(ExpandBinomial(a,b,m,n,u,x),And(FreeQ(List(a,b),x),IntegersQ(m,n),Less(C0,m,n)))),
ISetDelayed(ExpandIntegrand(u_,x_Symbol),
    u),
ISetDelayed(ExpandExpression(u_,x_Symbol),
    Module(List(v,w),CompoundExpression(Set(v,If(And(AlgebraicFunctionQ(u,x),Not(RationalFunctionQ(u,x))),ExpandAlgebraicFunction(u,x),C0)),If(SumQ(v),ExpandCleanup(v,x),CompoundExpression(Set(v,SmartApart(u,x)),If(SumQ(v),ExpandCleanup(v,x),CompoundExpression(Set(v,SmartApart(RationalFunctionFactors(u,x),x,x)),If(SumQ(v),CompoundExpression(Set(w,NonrationalFunctionFactors(u,x)),ExpandCleanup(Map(Function(Times(Slot1,w)),v),x)),CompoundExpression(Set(v,Expand(u,x)),If(SumQ(v),ExpandCleanup(v,x),CompoundExpression(Set(v,Expand(u)),If(SumQ(v),ExpandCleanup(v,x),SimplifyTerm(u,x))))))))))))),
ISetDelayed(ExpandCleanup(Plus(u_,Times(v_,Power(Plus(a_,Times(b_DEFAULT,x_)),-1)),Times(w_,Power(Plus(c_,Times(d_DEFAULT,x_)),-1))),x_Symbol),
    Condition(ExpandCleanup(Plus(u,Times(Plus(Times(c,v),Times(a,w)),Power(Plus(Times(a,c),Times(b,d,Sqr(x))),-1))),x),And(FreeQ(List(a,b,c,d),x),EqQ(Plus(Times(b,c),Times(a,d)),C0),EqQ(Plus(Times(d,v),Times(b,w)),C0)))),
ISetDelayed(ExpandCleanup(u_,x_Symbol),
    Module(List(Set(v,CollectReciprocals(u,x))),If(SumQ(v),CompoundExpression(Set(v,Map(Function(SimplifyTerm(Slot1,x)),v)),If(SumQ(v),UnifySum(v,x),v)),v))),
ISetDelayed(CollectReciprocals(Plus(u_,Times(e_,Power(Plus(a_,Times(b_DEFAULT,x_)),-1)),Times(f_,Power(Plus(c_,Times(d_DEFAULT,x_)),-1))),x_Symbol),
    Condition(CollectReciprocals(Plus(u,Times(Plus(Times(c,e),Times(a,f)),Power(Plus(Times(a,c),Times(b,d,Sqr(x))),-1))),x),And(FreeQ(List(a,b,c,d,e,f),x),EqQ(Plus(Times(b,c),Times(a,d)),C0),EqQ(Plus(Times(d,e),Times(b,f)),C0)))),
ISetDelayed(CollectReciprocals(Plus(u_,Times(e_,Power(Plus(a_,Times(b_DEFAULT,x_)),-1)),Times(f_,Power(Plus(c_,Times(d_DEFAULT,x_)),-1))),x_Symbol),
    Condition(CollectReciprocals(Plus(u,Times(Plus(Times(d,e),Times(b,f)),x,Power(Plus(Times(a,c),Times(b,d,Sqr(x))),-1))),x),And(FreeQ(List(a,b,c,d,e,f),x),EqQ(Plus(Times(b,c),Times(a,d)),C0),EqQ(Plus(Times(c,e),Times(a,f)),C0)))),
ISetDelayed(CollectReciprocals(u_,x_Symbol),
    u),
ISetDelayed(ExpandBinomial(a_,b_,m_,n_,u_,x_Symbol),
    If(And(OddQ(Times(n,Power(GCD(m,n),-1))),PosQ(Times(a,Power(b,-1)))),With(List(Set(g,GCD(m,n)),Set(r,Numerator(Rt(Times(a,Power(b,-1)),Times(n,Power(GCD(m,n),-1))))),Set(s,Denominator(Rt(Times(a,Power(b,-1)),Times(n,Power(GCD(m,n),-1)))))),Module(List(k),If(CoprimeQ(Plus(m,g),n),Sum(Times(r,Power(Times(CN1,r,Power(s,-1)),Times(m,Power(g,-1))),Power(CN1,Times(CN2,k,m,Power(n,-1))),Power(Times(a,n,Plus(r,Times(Power(CN1,Times(C2,k,g,Power(n,-1))),s,Power(u,g)))),-1)),List(k,C1,Times(n,Power(g,-1)))),Sum(Times(r,Power(Times(CN1,r,Power(s,-1)),Times(m,Power(g,-1))),Power(CN1,Times(C2,k,Plus(m,g),Power(n,-1))),Power(Times(a,n,Plus(Times(Power(CN1,Times(C2,k,g,Power(n,-1))),r),Times(s,Power(u,g)))),-1)),List(k,C1,Times(n,Power(g,-1))))))),With(List(Set(g,GCD(m,n)),Set(r,Numerator(Rt(Times(CN1,a,Power(b,-1)),Times(n,Power(GCD(m,n),-1))))),Set(s,Denominator(Rt(Times(CN1,a,Power(b,-1)),Times(n,Power(GCD(m,n),-1)))))),If(Equal(Times(n,Power(g,-1)),C2),Plus(Times(s,Power(Times(C2,b,Plus(r,Times(s,Power(u,g)))),-1)),Times(CN1,s,Power(Times(C2,b,Plus(r,Times(CN1,s,Power(u,g)))),-1))),Module(List(k),If(CoprimeQ(Plus(m,g),n),Sum(Times(r,Power(Times(r,Power(s,-1)),Times(m,Power(g,-1))),Power(CN1,Times(CN2,k,m,Power(n,-1))),Power(Times(a,n,Plus(r,Times(CN1,Power(CN1,Times(C2,k,g,Power(n,-1))),s,Power(u,g)))),-1)),List(k,C1,Times(n,Power(g,-1)))),Sum(Times(r,Power(Times(r,Power(s,-1)),Times(m,Power(g,-1))),Power(CN1,Times(C2,k,Plus(m,g),Power(n,-1))),Power(Times(a,n,Plus(Times(Power(CN1,Times(C2,k,g,Power(n,-1))),r),Times(CN1,s,Power(u,g)))),-1)),List(k,C1,Times(n,Power(g,-1)))))))))),
ISetDelayed(SmartApart(u_,x_Symbol),
    With(List(Set($s("alst"),MakeAssocList(u,x))),With(List(Set($s("tmp"),KernelSubst(Apart(GensymSubst(u,x,$s("alst"))),x,$s("alst")))),If(SameQ($s("tmp"),$s("Indeterminate")),u,$s("tmp"))))),
ISetDelayed(SmartApart(u_,v_,x_Symbol),
    With(List(Set($s("alst"),MakeAssocList(u,x))),With(List(Set($s("tmp"),KernelSubst(Apart(GensymSubst(u,x,$s("alst")),v),x,$s("alst")))),If(SameQ($s("tmp"),$s("Indeterminate")),u,$s("tmp"))))),
ISetDelayed(MakeAssocList(u_,x_Symbol,Colon($p("alst",$s("List")),List())),
    If(AtomQ(u),$s("alst"),If(IntegerPowerQ(u),MakeAssocList(Part(u,C1),x,$s("alst")),If(Or(ProductQ(u),SumQ(u)),MakeAssocList(Rest(u),x,MakeAssocList(First(u),x,$s("alst"))),If(FreeQ(u,x),With(List(Set($s("tmp"),Select($s("alst"),Function(SameQ(Part(Slot1,C2),u)),C1))),If(SameQ($s("tmp"),List()),Append($s("alst"),List(Unique($str("Rubi")),u)),$s("alst"))),$s("alst")))))),
ISetDelayed(GensymSubst(u_,x_Symbol,$p("alst",$s("List"))),
    If(AtomQ(u),u,If(IntegerPowerQ(u),Power(GensymSubst(Part(u,C1),x,$s("alst")),Part(u,C2)),If(Or(ProductQ(u),SumQ(u)),Map(Function(GensymSubst(Slot1,x,$s("alst"))),u),If(FreeQ(u,x),With(List(Set($s("tmp"),Select($s("alst"),Function(SameQ(Part(Slot1,C2),u)),C1))),If(SameQ($s("tmp"),List()),u,Part($s("tmp"),C1,C1))),u))))),
ISetDelayed(KernelSubst(u_,x_Symbol,$p("alst",$s("List"))),
    If(AtomQ(u),With(List(Set($s("tmp"),Select($s("alst"),Function(SameQ(Part(Slot1,C1),u)),C1))),If(SameQ($s("tmp"),List()),u,Part($s("tmp"),C1,C2))),If(IntegerPowerQ(u),With(List(Set($s("tmp"),KernelSubst(Part(u,C1),x,$s("alst")))),If(And(Less(Part(u,C2),C0),EqQ($s("tmp"),C0)),$s("Indeterminate"),Power($s("tmp"),Part(u,C2)))),If(Or(ProductQ(u),SumQ(u)),Map(Function(KernelSubst(Slot1,x,$s("alst"))),u),u)))),
ISetDelayed(ExpandAlgebraicFunction(Times($p(u,Plus),v_),x_Symbol),
    Condition(Map(Function(Times(Slot1,v)),u),Not(FreeQ(u,x)))),
ISetDelayed(ExpandAlgebraicFunction(Times(Power($p(u,Plus),n_),v_DEFAULT),x_Symbol),
    Condition(With(List(Set(w,Expand(Power(u,n),x))),Condition(Map(Function(Times(Slot1,v)),w),SumQ(w))),And(IGtQ(n,C0),Not(FreeQ(u,x))))),
ISetDelayed(UnifySum(u_,x_Symbol),
    If(SumQ(u),Apply(Plus,UnifyTerms(Apply($s("List"),u),x)),SimplifyTerm(u,x))),
ISetDelayed(UnifyTerms($p("lst"),x_),
    If(SameQ($s("lst"),List()),$s("lst"),UnifyTerm(First($s("lst")),UnifyTerms(Rest($s("lst")),x),x))),
ISetDelayed(UnifyTerm($p("term"),$p("lst"),x_),
    If(SameQ($s("lst"),List()),List($s("term")),With(List(Set($s("tmp"),Simplify(Times(First($s("lst")),Power($s("term"),-1))))),If(FreeQ($s("tmp"),x),Prepend(Rest($s("lst")),Times(Plus(C1,$s("tmp")),$s("term"))),Prepend(UnifyTerm($s("term"),Rest($s("lst")),x),First($s("lst"))))))),
ISetDelayed(ExpandLinearProduct(v_,u_,a_,b_,x_Symbol),
    Condition(Module(List($s("lst")),CompoundExpression(Set($s("lst"),CoefficientList(ReplaceAll(u,Rule(x,Times(Plus(x,Negate(a)),Power(b,-1)))),x)),Set($s("lst"),Map(Function(SimplifyTerm(Slot1,x)),$s("lst"))),Module(List($s("ii")),Sum(Times(v,Part($s("lst"),$s("ii")),Power(Plus(a,Times(b,x)),Plus($s("ii"),Negate(C1)))),List($s("ii"),C1,Length($s("lst"))))))),And(FreeQ(List(a,b),x),PolynomialQ(u,x)))),
ISetDelayed(ExpandTrigExpand(u_,F_,v_,m_,n_,x_Symbol),
    With(List(Set(w,ReplaceAll(Expand(Power(TrigExpand(F(Times(n,x))),m),x),Rule(x,v)))),If(SumQ(w),Map(Function(Times(u,Slot1)),w),Times(u,w)))),
ISetDelayed(ExpandTrigReduce(u_,v_,x_Symbol),
    With(List(Set(w,ExpandTrigReduce(v,x))),If(SumQ(w),Map(Function(Times(u,Slot1)),w),Times(u,w)))),
ISetDelayed(ExpandTrigReduce(Times(u_DEFAULT,Power($(F_,Plus(n_,v_DEFAULT)),m_DEFAULT)),x_Symbol),
    Condition(Module(List($s("nn")),ReplaceAll(ExpandTrigReduce(Times(u,Power(F(Plus($s("nn"),v)),m)),x),Rule($s("nn"),n))),And(MemberQ(List($s("Sinh"),$s("Cosh")),FSymbol),IntegerQ(m),RationalQ(n)))),
ISetDelayed(ExpandTrigReduce(u_,x_Symbol),
    ExpandTrigReduceAux(u,x)),
ISetDelayed(ExpandTrigReduceAux(u_,x_Symbol),
    With(List(Set(v,Expand(TrigReduce(u)))),If(SumQ(v),Map(Function(NormalizeTrigReduce(Slot1,x)),v),NormalizeTrigReduce(v,x)))),
ISetDelayed(NormalizeTrigReduce(Times(a_DEFAULT,Power($(F_,u_),n_DEFAULT)),x_Symbol),
    Condition(Times(a,Power(F(ExpandToSum(u,x)),n)),And(FreeQ(List(FSymbol,a,n),x),PolynomialQ(u,x),Greater(Exponent(u,x),C0)))),
ISetDelayed(NormalizeTrigReduce(u_,x_Symbol),
    u),
ISetDelayed(ExpandTrigToExp(u_,x_Symbol),
    ExpandTrigToExp(C1,u,x)),
ISetDelayed(ExpandTrigToExp(u_,v_,x_Symbol),
    Module(List(Set(w,TrigToExp(v))),CompoundExpression(Set(w,If(SumQ(w),Map(Function(SimplifyIntegrand(Times(u,Slot1),x)),w),SimplifyIntegrand(Times(u,w),x))),ExpandIntegrand(FreeFactors(w,x),NonfreeFactors(w,x),x)))),
ISetDelayed(Distrib(u_,v_),
    If(SumQ(v),Map(Function(Times(u,Slot1)),v),Times(u,v))),
ISetDelayed(Dist(u_,$(Defer($s("Integrate::Dist")),v_,w_,x_),x_),
    Dist(Times(u,v),w,x)),
ISetDelayed(Dist(u_,v_,x_),
    If(SameQ(u,C1),v,If(SameQ(u,C0),CompoundExpression(Print($str("*** Warning ***:  Dist[0,"),v,$str(","),x,$str("]")),C0),If(And(Less(NumericFactor(u),C0),Greater(NumericFactor(Negate(u)),C0)),Negate(Dist(Negate(u),v,x)),If(SumQ(v),Map(Function(Dist(u,Slot1,x)),v),If(IntegralFreeQ(v),Simp(Times(u,v),x),With(List(Set(w,Times(Simp(Times(u,Sqr(x)),x),Power(x,-2)))),If(And(UnsameQ(w,u),FreeQ(w,x),SameQ(w,Simp(w,x)),SameQ(w,Times(Simp(Times(w,Sqr(x)),x),Power(x,-2)))),Dist(w,v,x),If(UnsameQ($s("§$showsteps"),True),Simp(Times(u,v),x),$(Defer($s("Integrate::Dist")),u,v,x)))))))))),
ISetDelayed(DistributeDegree(u_,m_),
    If(AtomQ(u),Power(u,m),If(PowerQ(u),Power(Part(u,C1),Times(Part(u,C2),m)),If(ProductQ(u),Map(Function(DistributeDegree(Slot1,m)),u),Power(u,m))))),
ISetDelayed(FunctionOfLinear(u_,x_Symbol),
    With(List(Set($s("lst"),FunctionOfLinear(u,False,False,x,False))),If(Or(AtomQ($s("lst")),FalseQ(Part($s("lst"),C1)),And(SameQ(Part($s("lst"),C1),C0),SameQ(Part($s("lst"),C2),C1))),False,List(FunctionOfLinearSubst(u,Part($s("lst"),C1),Part($s("lst"),C2),x),Part($s("lst"),C1),Part($s("lst"),C2))))),
ISetDelayed(FunctionOfLinear(u_,a_,b_,x_,$p("flag")),
    If(FreeQ(u,x),List(a,b),If(CalculusQ(u),False,If(LinearQ(u,x),If(FalseQ(a),List(Coefficient(u,x,C0),Coefficient(u,x,C1)),With(List(Set($s("lst"),CommonFactors(List(b,Coefficient(u,x,C1))))),If(And(EqQ(Coefficient(u,x,C0),C0),Not($s("flag"))),List(C0,Part($s("lst"),C1)),If(EqQ(Plus(Times(b,Coefficient(u,x,C0)),Times(CN1,a,Coefficient(u,x,C1))),C0),List(Times(a,Power(Part($s("lst"),C2),-1)),Part($s("lst"),C1)),List(C0,C1))))),If(And(PowerQ(u),FreeQ(Part(u,C1),x)),FunctionOfLinear(Times(Log(Part(u,C1)),Part(u,C2)),a,b,x,False),Module(List($s("lst")),If(And(ProductQ(u),NeQ(Part(Set($s("lst"),MonomialFactor(u,x)),C1),C0)),If(And(False,IntegerQ(Part($s("lst"),C1)),Unequal(Part($s("lst"),C1),CN1),FreeQ(Part($s("lst"),C2),x)),If(And(RationalQ(LeadFactor(Part($s("lst"),C2))),Less(LeadFactor(Part($s("lst"),C2)),C0)),FunctionOfLinear(Times(DivideDegreesOfFactors(Negate(Part($s("lst"),C2)),Part($s("lst"),C1)),x),a,b,x,False),FunctionOfLinear(Times(DivideDegreesOfFactors(Part($s("lst"),C2),Part($s("lst"),C1)),x),a,b,x,False)),False),CompoundExpression(Set($s("lst"),List(a,b)),Catch(CompoundExpression(Scan(Function(CompoundExpression(Set($s("lst"),FunctionOfLinear(Slot1,Part($s("lst"),C1),Part($s("lst"),C2),x,SumQ(u))),If(AtomQ($s("lst")),Throw(False)))),u),$s("lst"))))))))))),
ISetDelayed(FunctionOfLinearSubst(u_,a_,b_,x_),
    If(FreeQ(u,x),u,If(LinearQ(u,x),Module(List(Set($s("tmp"),Coefficient(u,x,C1))),CompoundExpression(Set($s("tmp"),If(SameQ($s("tmp"),b),C1,Times($s("tmp"),Power(b,-1)))),Plus(Coefficient(u,x,C0),Times(CN1,a,$s("tmp")),Times($s("tmp"),x)))),If(And(PowerQ(u),FreeQ(Part(u,C1),x)),Exp(FullSimplify(FunctionOfLinearSubst(Times(Log(Part(u,C1)),Part(u,C2)),a,b,x))),Module(List($s("lst")),If(And(ProductQ(u),NeQ(Part(Set($s("lst"),MonomialFactor(u,x)),C1),C0)),If(And(RationalQ(LeadFactor(Part($s("lst"),C2))),Less(LeadFactor(Part($s("lst"),C2)),C0)),Negate(Power(FunctionOfLinearSubst(Times(DivideDegreesOfFactors(Negate(Part($s("lst"),C2)),Part($s("lst"),C1)),x),a,b,x),Part($s("lst"),C1))),Power(FunctionOfLinearSubst(Times(DivideDegreesOfFactors(Part($s("lst"),C2),Part($s("lst"),C1)),x),a,b,x),Part($s("lst"),C1))),Map(Function(FunctionOfLinearSubst(Slot1,a,b,x)),u))))))),
ISetDelayed(DivideDegreesOfFactors(u_,n_),
    If(ProductQ(u),Map(Function(Power(LeadBase(Slot1),Times(LeadDegree(Slot1),Power(n,-1)))),u),Power(LeadBase(u),Times(LeadDegree(u),Power(n,-1))))),
ISetDelayed(FunctionOfInverseLinear(u_,x_Symbol),
    FunctionOfInverseLinear(u,Null,x))
  );
}
