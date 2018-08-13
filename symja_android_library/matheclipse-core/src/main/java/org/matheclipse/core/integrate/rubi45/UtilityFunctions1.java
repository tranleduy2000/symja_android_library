package org.matheclipse.core.integrate.rubi45;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.*;
import static org.matheclipse.core.expression.F.Integer;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.AlgebraicFunctionFactors;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.AlgebraicFunctionQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.BinomialDegree;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.BinomialMatchQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.BinomialQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.BinomialTest;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.CalculusQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.CommonNumericFactors;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.ContentFactor;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.CubicMatchQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.FalseQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.FractionalPowerOfQuotientOfLinears;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.FractionalPowerQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.FreeFactors;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.FreeTerms;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.GE;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.GT;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.Gcd;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.GeneralizedBinomialDegree;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.GeneralizedBinomialMatchQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.GeneralizedBinomialQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.GeneralizedBinomialTest;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.GeneralizedTrinomialDegree;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.GeneralizedTrinomialMatchQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.GeneralizedTrinomialQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.GeneralizedTrinomialTest;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.IndependentQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.IntegerPowerQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.InverseFunctionOfQuotientOfLinears;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.InverseFunctionQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.LE;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.LinearMatchQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.LinearPairQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.MinimumMonomialExponent;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.MonomialExponent;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.MonomialQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.MonomialSumQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.NonalgebraicFunctionFactors;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.NonfreeFactors;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.NonfreeTerms;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.NonpolynomialTerms;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.NonrationalFunctionFactors;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.NonzeroQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.NotFalseQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.NumericFactor;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.PerfectPowerTest;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.PolyQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.PolynomialTermQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.PolynomialTerms;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.PowerOfLinearMatchQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.PowerOfLinearQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.PowerQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.ProductQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.QuadraticMatchQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.QuadraticQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.QuotientOfLinearsMatchQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.QuotientOfLinearsP;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.QuotientOfLinearsParts;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.QuotientOfLinearsQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.RationalFunctionExpand;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.RationalFunctionExponents;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.RationalFunctionFactors;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.RationalFunctionQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.RationalPowerQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.RealNumericQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.SplitFreeFactors;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.SubstForFractionalPower;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.SubstForFractionalPowerAuxQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.SubstForFractionalPowerOfQuotientOfLinears;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.SubstForFractionalPowerQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.SubstForInverseFunction;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.SubstForInverseFunctionOfQuotientOfLinears;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.SumQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.TrinomialDegree;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.TrinomialMatchQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.TrinomialQ;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.TrinomialTest;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.ZeroQ;
/** 
 * UtilityFunctions rules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class UtilityFunctions1 { 
  public static IAST RULES = List( 
ISetDelayed(GtQ(u_,v_,w_),
    And(GtQ(u,v),GtQ(v,w))),
ISetDelayed(LtQ(u_,v_),
    If(RealNumberQ(u),If(RealNumberQ(v),Less(u,v),With(List(Set($s("vn"),N(Together(v)))),And(SameQ(Head($s("vn")),$s("Real")),Less(u,$s("vn"))))),With(List(Set($s("un"),N(Together(u)))),If(SameQ(Head($s("un")),$s("Real")),If(RealNumberQ(v),Less($s("un"),v),With(List(Set($s("vn"),N(Together(v)))),And(SameQ(Head($s("vn")),$s("Real")),Less($s("un"),$s("vn"))))),False)))),
ISetDelayed(LtQ(u_,v_,w_),
    And(LtQ(u,v),LtQ(v,w))),
ISetDelayed(GeQ(u_,v_),
    If(RealNumberQ(u),If(RealNumberQ(v),GreaterEqual(u,v),With(List(Set($s("vn"),N(Together(v)))),And(SameQ(Head($s("vn")),$s("Real")),GreaterEqual(u,$s("vn"))))),With(List(Set($s("un"),N(Together(u)))),If(SameQ(Head($s("un")),$s("Real")),If(RealNumberQ(v),GreaterEqual($s("un"),v),With(List(Set($s("vn"),N(Together(v)))),And(SameQ(Head($s("vn")),$s("Real")),GreaterEqual($s("un"),$s("vn"))))),False)))),
ISetDelayed(GeQ(u_,v_,w_),
    And(GeQ(u,v),GeQ(v,w))),
ISetDelayed(LeQ(u_,v_),
    If(RealNumberQ(u),If(RealNumberQ(v),LessEqual(u,v),With(List(Set($s("vn"),N(Together(v)))),And(SameQ(Head($s("vn")),$s("Real")),LessEqual(u,$s("vn"))))),With(List(Set($s("un"),N(Together(u)))),If(SameQ(Head($s("un")),$s("Real")),If(RealNumberQ(v),LessEqual($s("un"),v),With(List(Set($s("vn"),N(Together(v)))),And(SameQ(Head($s("vn")),$s("Real")),LessEqual($s("un"),$s("vn"))))),False)))),
ISetDelayed(LeQ(u_,v_,w_),
    And(LeQ(u,v),LeQ(v,w))),
ISetDelayed(RealNumberQ(u_),
    And(NumberQ(u),UnsameQ(Head(u),$s("Complex")))),
ISetDelayed(PolyQ(u_,x_Symbol,n_),
    If(PolynomialQ(u,x),And(EqQ(Exponent(u,x),n),NeQ(Coefficient(u,x,n),C0)),With(List(Set(v,Together(u))),And(PolynomialQ(v,x),EqQ(Exponent(v,x),n),NeQ(Coefficient(v,x,n),C0))))),
ISetDelayed(PolyQ(u_,Power(x_Symbol,v_),n_),
    And(PolyQ(u,Power(x,v)),EqQ(Expon(u,Power(x,v)),n),NeQ(Coeff(u,Power(x,v),n),C0))),
ISetDelayed(PolyQ(u_,x_Symbol),
    Or(PolynomialQ(u,x),PolynomialQ(Together(u),x))),
ISetDelayed(PolyQ(u_,Power(x_Symbol,$p(n, Integer))),
    Condition(If(PolynomialQ(u,x),PolynomialQ(u,Power(x,n)),With(List(Set(v,Together(u))),And(PolynomialQ(v,x),PolynomialQ(v,Power(x,n))))),Greater(n,C0))),
ISetDelayed(PolyQ(u_,Power(x_Symbol,v_)),
    Condition(If(SameQ(Quiet(PolynomialQ(u,Power(x,v))),True),FreeQ(CoefficientList(u,Power(x,v)),x),With(List(Set(w,Together(u))),And(SameQ(Quiet(PolynomialQ(w,Power(x,v))),True),FreeQ(CoefficientList(w,Power(x,v)),x)))),And(NonsumQ(v),FreeQ(v,x)))),
ISetDelayed(PolyQ(u_,v_),
    False),
ISetDelayed(ProperPolyQ(u_,x_Symbol),
    And(PolyQ(u,x),NeQ(Coeff(u,x,C0),C0))),
ISetDelayed(BinomialQ(u_,x_Symbol),
    If(ListQ(u),Catch(CompoundExpression(Scan(Function(If(Not(BinomialQ(Slot1,x)),Throw(False))),u),True)),ListQ(BinomialParts(u,x)))),
ISetDelayed(BinomialQ(u_,x_Symbol,n_),
    If(ListQ(u),Catch(CompoundExpression(Scan(Function(If(Not(BinomialQ(Slot1,x,n)),Throw(False))),u),True)),$(Function(And(ListQ(Slot1),SameQ(Part(Slot1,C3),n))),BinomialParts(u,x)))),
ISetDelayed(TrinomialQ(u_,x_Symbol),
    If(ListQ(u),Catch(CompoundExpression(Scan(Function(If(Not(TrinomialQ(Slot1,x)),Throw(False))),u),True)),And(ListQ(TrinomialParts(u,x)),Not(QuadraticQ(u,x)),Not(MatchQ(u,Condition(Sqr(w_),BinomialQ(w,x))))))),
ISetDelayed(GeneralizedBinomialQ(u_,x_Symbol),
    If(ListQ(u),Catch(CompoundExpression(Scan(Function(If(Not(GeneralizedBinomialQ(Slot1,x)),Throw(False))),u),True)),ListQ(GeneralizedBinomialParts(u,x)))),
ISetDelayed(GeneralizedTrinomialQ(u_,x_Symbol),
    If(ListQ(u),Catch(CompoundExpression(Scan(Function(If(Not(GeneralizedTrinomialQ(Slot1,x)),Throw(False))),u),True)),ListQ(GeneralizedTrinomialParts(u,x)))),
ISetDelayed(PosQ(u_),
    PosAux(TogetherSimplify(u))),
ISetDelayed(PosAux(u_),
    If(NumberQ(u),If(SameQ(Head(u),$s("Complex")),If(EqQ(Re(u),C0),PosAux(Im(u)),PosAux(Re(u))),Greater(u,C0)),If(NumericQ(u),With(List(Set(v,Simplify(Re(u)))),If(NumberQ(v),If(EqQ(v,C0),PosAux(Simplify(Im(u))),Greater(v,C0)),With(List(Set(w,N(u))),And(NumberQ(w),PosAux(w))))),With(List(Set(v,Refine(Greater(u,C0)))),If(Or(SameQ(v,True),SameQ(v,False)),v,If(PowerQ(u),If(IntegerQ(Part(u,C2)),Or(EvenQ(Part(u,C2)),PosAux(Part(u,C1))),True),If(ProductQ(u),If(PosAux(First(u)),PosAux(Rest(u)),Not(PosAux(Rest(u)))),If(SumQ(u),PosAux(First(u)),True)))))))),
ISetDelayed(NegQ(u_),
    And(Not(PosQ(u)),NeQ(u,C0))),
ISetDelayed(NiceSqrtQ(u_),
    And(Not(LtQ(u,C0)),NiceSqrtAuxQ(u))),
ISetDelayed(NiceSqrtAuxQ(u_),
    If(RationalQ(u),Greater(u,C0),If(PowerQ(u),EvenQ(Part(u,C2)),If(ProductQ(u),And(NiceSqrtAuxQ(First(u)),NiceSqrtAuxQ(Rest(u))),If(SumQ(u),$(Function(And(NonsumQ(Slot1),NiceSqrtAuxQ(Slot1))),Simplify(u)),False))))),
ISetDelayed(PerfectSquareQ(u_),
    If(RationalQ(u),And(Greater(u,C0),RationalQ(Sqrt(u))),If(PowerQ(u),EvenQ(Part(u,C2)),If(ProductQ(u),And(PerfectSquareQ(First(u)),PerfectSquareQ(Rest(u))),If(SumQ(u),$(Function(And(NonsumQ(Slot1),PerfectSquareQ(Slot1))),Simplify(u)),False))))),
ISetDelayed(SimplerQ(u_,v_),
    If(IntegerQ(u),If(IntegerQ(v),If(Equal(u,v),False,If(Equal(u,Negate(v)),Less(v,C0),Less(Abs(u),Abs(v)))),True),If(IntegerQ(v),False,If(FractionQ(u),If(FractionQ(v),If(Equal(Denominator(u),Denominator(v)),SimplerQ(Numerator(u),Numerator(v)),Less(Denominator(u),Denominator(v))),True),If(FractionQ(v),False,If(And(Or(SameQ(Re(u),C0),SameQ(Re(u),num(0.0))),Or(SameQ(Re(v),C0),SameQ(Re(v),num(0.0)))),SimplerQ(Im(u),Im(v)),If(ComplexNumberQ(u),If(ComplexNumberQ(v),If(Equal(Re(u),Re(v)),SimplerQ(Im(u),Im(v)),SimplerQ(Re(u),Re(v))),False),If(NumberQ(u),If(NumberQ(v),OrderedQ(List(u,v)),True),If(NumberQ(v),False,If(AtomQ(u),If(AtomQ(v),OrderedQ(List(u,v)),True),If(AtomQ(v),False,If(SameQ(Head(u),Head(v)),If(Equal(Length(u),Length(v)),If(Equal(LeafCount(u),LeafCount(v)),Catch(CompoundExpression(Do(If(SameQ(Part(u,$s("ii")),Part(v,$s("ii"))),Null,Throw(SimplerQ(Part(u,$s("ii")),Part(v,$s("ii"))))),List($s("ii"),Length(u))),False)),Less(LeafCount(u),LeafCount(v))),Less(Length(u),Length(v))),If(Equal(LeafCount(u),LeafCount(v)),Not(OrderedQ(List(v,u))),Less(LeafCount(u),LeafCount(v))))))))))))))),
ISetDelayed(SimplerSqrtQ(u_,v_),
    If(And(LtQ(v,C0),Not(LtQ(u,C0))),True,If(And(LtQ(u,C0),Not(LtQ(v,C0))),False,With(List(Set($s("sqrtu"),Rt(u,C2)),Set($s("sqrtv"),Rt(v,C2))),If(IntegerQ($s("sqrtu")),If(IntegerQ($s("sqrtv")),Less($s("sqrtu"),$s("sqrtv")),True),If(IntegerQ($s("sqrtv")),False,If(RationalQ($s("sqrtu")),If(RationalQ($s("sqrtv")),Less($s("sqrtu"),$s("sqrtv")),True),If(RationalQ($s("sqrtv")),False,If(PosQ(u),If(PosQ(v),Less(LeafCount($s("sqrtu")),LeafCount($s("sqrtv"))),True),If(PosQ(v),False,If(Less(LeafCount($s("sqrtu")),LeafCount($s("sqrtv"))),True,If(Less(LeafCount($s("sqrtv")),LeafCount($s("sqrtu"))),False,Not(OrderedQ(List(v,u))))))))))))))),
ISetDelayed(SumSimplerQ(u_,v_),
    If(RationalQ(u,v),If(Equal(v,C0),False,If(Greater(v,C0),Less(u,CN1),GreaterEqual(u,Negate(v)))),SumSimplerAuxQ(Expand(u),Expand(v)))),
ISetDelayed(SumSimplerAuxQ(u_,v_),
    Condition(And(Or(RationalQ(First(v)),SumSimplerAuxQ(u,First(v))),Or(RationalQ(Rest(v)),SumSimplerAuxQ(u,Rest(v)))),SumQ(v))),
ISetDelayed(SumSimplerAuxQ(u_,v_),
    Condition(Or(SumSimplerAuxQ(First(u),v),SumSimplerAuxQ(Rest(u),v)),SumQ(u))),
ISetDelayed(SumSimplerAuxQ(u_,v_),
    And(UnsameQ(v,C0),SameQ(NonnumericFactors(u),NonnumericFactors(v)),Or(Less(Times(NumericFactor(u),Power(NumericFactor(v),-1)),CN1D2),And(Equal(Times(NumericFactor(u),Power(NumericFactor(v),-1)),CN1D2),Less(NumericFactor(u),C0))))),
ISetDelayed(SimplerIntegrandQ(u_,v_,x_Symbol),
    Module(List(Set($s("lst"),CancelCommonFactors(u,v)),$s("u1"),$s("v1")),CompoundExpression(Set($s("u1"),Part($s("lst"),C1)),Set($s("v1"),Part($s("lst"),C2)),If(Less(LeafCount($s("u1")),Times(QQ(3L,4L),LeafCount($s("v1")))),True,If(RationalFunctionQ($s("u1"),x),If(RationalFunctionQ($s("v1"),x),Less(Apply(Plus,RationalFunctionExponents($s("u1"),x)),Apply(Plus,RationalFunctionExponents($s("v1"),x))),True),False))))),
ISetDelayed(CancelCommonFactors(u_,v_),
    If(ProductQ(u),If(ProductQ(v),If(MemberQ(v,First(u)),CancelCommonFactors(Rest(u),DeleteCases(v,First(u),C1,C1)),$(Function(List(Times(First(u),Part(Slot1,C1)),Part(Slot1,C2))),CancelCommonFactors(Rest(u),v))),If(MemberQ(u,v),List(DeleteCases(u,v,C1,C1),C1),List(u,v))),If(ProductQ(v),If(MemberQ(v,u),List(C1,DeleteCases(v,u,C1,C1)),List(u,v)),List(u,v)))),
ISetDelayed(BinomialDegree(u_,x_Symbol),
    Part(BinomialParts(u,x),C3)),
ISetDelayed(BinomialParts(u_,x_Symbol),
    If(PolynomialQ(u,x),If(Greater(Exponent(u,x),C0),With(List(Set($s("lst"),Exponent(u,x,$s("List")))),If(Equal(Length($s("lst")),C1),List(C0,Coefficient(u,x,Exponent(u,x)),Exponent(u,x)),If(And(Equal(Length($s("lst")),C2),Equal(Part($s("lst"),C1),C0)),List(Coefficient(u,x,C0),Coefficient(u,x,Exponent(u,x)),Exponent(u,x)),False))),False),If(PowerQ(u),If(And(SameQ(Part(u,C1),x),FreeQ(Part(u,C2),x)),List(C0,C1,Part(u,C2)),False),If(ProductQ(u),If(FreeQ(First(u),x),With(List(Set($s("lst2"),BinomialParts(Rest(u),x))),If(AtomQ($s("lst2")),False,List(Times(First(u),Part($s("lst2"),C1)),Times(First(u),Part($s("lst2"),C2)),Part($s("lst2"),C3)))),If(FreeQ(Rest(u),x),With(List(Set($s("lst1"),BinomialParts(First(u),x))),If(AtomQ($s("lst1")),False,List(Times(Rest(u),Part($s("lst1"),C1)),Times(Rest(u),Part($s("lst1"),C2)),Part($s("lst1"),C3)))),With(List(Set($s("lst1"),BinomialParts(First(u),x))),If(AtomQ($s("lst1")),False,With(List(Set($s("lst2"),BinomialParts(Rest(u),x))),If(AtomQ($s("lst2")),False,With(List(Set(a,Part($s("lst1"),C1)),Set(b,Part($s("lst1"),C2)),Set(m,Part($s("lst1"),C3)),Set(c,Part($s("lst2"),C1)),Set(d,Part($s("lst2"),C2)),Set(n,Part($s("lst2"),C3))),If(EqQ(a,C0),If(EqQ(c,C0),List(C0,Times(b,d),Plus(m,n)),If(EqQ(Plus(m,n),C0),List(Times(b,d),Times(b,c),m),False)),If(EqQ(c,C0),If(EqQ(Plus(m,n),C0),List(Times(b,d),Times(a,d),n),False),If(And(EqQ(m,n),EqQ(Plus(Times(a,d),Times(b,c)),C0)),List(Times(a,c),Times(b,d),Times(C2,m)),False)))))))))),If(SumQ(u),If(FreeQ(First(u),x),With(List(Set($s("lst2"),BinomialParts(Rest(u),x))),If(AtomQ($s("lst2")),False,List(Plus(First(u),Part($s("lst2"),C1)),Part($s("lst2"),C2),Part($s("lst2"),C3)))),If(FreeQ(Rest(u),x),With(List(Set($s("lst1"),BinomialParts(First(u),x))),If(AtomQ($s("lst1")),False,List(Plus(Rest(u),Part($s("lst1"),C1)),Part($s("lst1"),C2),Part($s("lst1"),C3)))),With(List(Set($s("lst1"),BinomialParts(First(u),x))),If(AtomQ($s("lst1")),False,With(List(Set($s("lst2"),BinomialParts(Rest(u),x))),If(AtomQ($s("lst2")),False,If(EqQ(Part($s("lst1"),C3),Part($s("lst2"),C3)),List(Plus(Part($s("lst1"),C1),Part($s("lst2"),C1)),Plus(Part($s("lst1"),C2),Part($s("lst2"),C2)),Part($s("lst1"),C3)),False))))))),False))))),
ISetDelayed(TrinomialDegree(u_,x_Symbol),
    Part(TrinomialParts(u,x),C4)),
ISetDelayed(TrinomialParts(u_,x_Symbol),
    If(PolynomialQ(u,x),With(List(Set($s("lst"),CoefficientList(u,x))),If(Or(Less(Length($s("lst")),C3),EvenQ(Length($s("lst"))),EqQ(Part($s("lst"),Times(C1D2,Plus(Length($s("lst")),C1))),C0)),False,Catch(CompoundExpression(Scan(Function(If(EqQ(Slot1,C0),Null,Throw(False))),Drop(Drop(Drop($s("lst"),List(Times(C1D2,Plus(Length($s("lst")),C1)))),C1),CN1)),List(First($s("lst")),Part($s("lst"),Times(C1D2,Plus(Length($s("lst")),C1))),Last($s("lst")),Times(C1D2,Plus(Length($s("lst")),Negate(C1)))))))),If(PowerQ(u),If(EqQ(Part(u,C2),C2),With(List(Set($s("lst"),BinomialParts(Part(u,C1),x))),If(Or(AtomQ($s("lst")),EqQ(Part($s("lst"),C1),C0)),False,List(Sqr(Part($s("lst"),C1)),Times(C2,Part($s("lst"),C1),Part($s("lst"),C2)),Sqr(Part($s("lst"),C2)),Part($s("lst"),C3)))),False),If(ProductQ(u),If(FreeQ(First(u),x),With(List(Set($s("lst2"),TrinomialParts(Rest(u),x))),If(AtomQ($s("lst2")),False,List(Times(First(u),Part($s("lst2"),C1)),Times(First(u),Part($s("lst2"),C2)),Times(First(u),Part($s("lst2"),C3)),Part($s("lst2"),C4)))),If(FreeQ(Rest(u),x),With(List(Set($s("lst1"),TrinomialParts(First(u),x))),If(AtomQ($s("lst1")),False,List(Times(Rest(u),Part($s("lst1"),C1)),Times(Rest(u),Part($s("lst1"),C2)),Times(Rest(u),Part($s("lst1"),C3)),Part($s("lst1"),C4)))),With(List(Set($s("lst1"),BinomialParts(First(u),x))),If(AtomQ($s("lst1")),False,With(List(Set($s("lst2"),BinomialParts(Rest(u),x))),If(AtomQ($s("lst2")),False,With(List(Set(a,Part($s("lst1"),C1)),Set(b,Part($s("lst1"),C2)),Set(m,Part($s("lst1"),C3)),Set(c,Part($s("lst2"),C1)),Set(d,Part($s("lst2"),C2)),Set(n,Part($s("lst2"),C3))),If(And(EqQ(m,n),NeQ(Plus(Times(a,d),Times(b,c)),C0)),List(Times(a,c),Plus(Times(a,d),Times(b,c)),Times(b,d),m),False)))))))),If(SumQ(u),If(FreeQ(First(u),x),With(List(Set($s("lst2"),TrinomialParts(Rest(u),x))),If(AtomQ($s("lst2")),False,List(Plus(First(u),Part($s("lst2"),C1)),Part($s("lst2"),C2),Part($s("lst2"),C3),Part($s("lst2"),C4)))),If(FreeQ(Rest(u),x),With(List(Set($s("lst1"),TrinomialParts(First(u),x))),If(AtomQ($s("lst1")),False,List(Plus(Rest(u),Part($s("lst1"),C1)),Part($s("lst1"),C2),Part($s("lst1"),C3),Part($s("lst1"),C4)))),With(List(Set($s("lst1"),TrinomialParts(First(u),x))),If(AtomQ($s("lst1")),With(List(Set($s("lst3"),BinomialParts(First(u),x))),If(AtomQ($s("lst3")),False,With(List(Set($s("lst2"),TrinomialParts(Rest(u),x))),If(AtomQ($s("lst2")),With(List(Set($s("lst4"),BinomialParts(Rest(u),x))),If(AtomQ($s("lst4")),False,If(EqQ(Part($s("lst3"),C3),Times(C2,Part($s("lst4"),C3))),List(Plus(Part($s("lst3"),C1),Part($s("lst4"),C1)),Part($s("lst4"),C2),Part($s("lst3"),C2),Part($s("lst4"),C3)),If(EqQ(Part($s("lst4"),C3),Times(C2,Part($s("lst3"),C3))),List(Plus(Part($s("lst3"),C1),Part($s("lst4"),C1)),Part($s("lst3"),C2),Part($s("lst4"),C2),Part($s("lst3"),C3)),False)))),If(And(EqQ(Part($s("lst3"),C3),Part($s("lst2"),C4)),NeQ(Plus(Part($s("lst3"),C2),Part($s("lst2"),C2)),C0)),List(Plus(Part($s("lst3"),C1),Part($s("lst2"),C1)),Plus(Part($s("lst3"),C2),Part($s("lst2"),C2)),Part($s("lst2"),C3),Part($s("lst2"),C4)),If(And(EqQ(Part($s("lst3"),C3),Times(C2,Part($s("lst2"),C4))),NeQ(Plus(Part($s("lst3"),C2),Part($s("lst2"),C3)),C0)),List(Plus(Part($s("lst3"),C1),Part($s("lst2"),C1)),Part($s("lst2"),C2),Plus(Part($s("lst3"),C2),Part($s("lst2"),C3)),Part($s("lst2"),C4)),False)))))),With(List(Set($s("lst2"),TrinomialParts(Rest(u),x))),If(AtomQ($s("lst2")),With(List(Set($s("lst4"),BinomialParts(Rest(u),x))),If(AtomQ($s("lst4")),False,If(And(EqQ(Part($s("lst4"),C3),Part($s("lst1"),C4)),NeQ(Plus(Part($s("lst1"),C2),Part($s("lst4"),C2)),C0)),List(Plus(Part($s("lst1"),C1),Part($s("lst4"),C1)),Plus(Part($s("lst1"),C2),Part($s("lst4"),C2)),Part($s("lst1"),C3),Part($s("lst1"),C4)),If(And(EqQ(Part($s("lst4"),C3),Times(C2,Part($s("lst1"),C4))),NeQ(Plus(Part($s("lst1"),C3),Part($s("lst4"),C2)),C0)),List(Plus(Part($s("lst1"),C1),Part($s("lst4"),C1)),Part($s("lst1"),C2),Plus(Part($s("lst1"),C3),Part($s("lst4"),C2)),Part($s("lst1"),C4)),False)))),If(And(EqQ(Part($s("lst1"),C4),Part($s("lst2"),C4)),NeQ(Plus(Part($s("lst1"),C2),Part($s("lst2"),C2)),C0),NeQ(Plus(Part($s("lst1"),C3),Part($s("lst2"),C3)),C0)),List(Plus(Part($s("lst1"),C1),Part($s("lst2"),C1)),Plus(Part($s("lst1"),C2),Part($s("lst2"),C2)),Plus(Part($s("lst1"),C3),Part($s("lst2"),C3)),Part($s("lst1"),C4)),False))))))),False))))),
ISetDelayed(GeneralizedBinomialDegree(u_,x_Symbol),
    $(Function(Plus(Part(Slot1,C3),Negate(Part(Slot1,C4)))),GeneralizedBinomialParts(u,x))),
ISetDelayed(GeneralizedBinomialParts(Plus(Times(b_DEFAULT,Power(x_,n_DEFAULT)),Times(a_DEFAULT,Power(x_,q_DEFAULT))),x_Symbol),
    Condition(List(a,b,n,q),And(FreeQ(List(a,b,n,q),x),PosQ(Plus(n,Negate(q)))))),
ISetDelayed(GeneralizedBinomialParts(Times(a_,u_),x_Symbol),
    Condition(With(List(Set($s("lst"),GeneralizedBinomialParts(u,x))),Condition(List(Times(a,Part($s("lst"),C1)),Times(a,Part($s("lst"),C2)),Part($s("lst"),C3),Part($s("lst"),C4)),ListQ($s("lst")))),FreeQ(a,x))),
ISetDelayed(GeneralizedBinomialParts(Times(u_,Power(x_,m_DEFAULT)),x_Symbol),
    Condition(With(List(Set($s("lst"),GeneralizedBinomialParts(u,x))),Condition(List(Part($s("lst"),C1),Part($s("lst"),C2),Plus(m,Part($s("lst"),C3)),Plus(m,Part($s("lst"),C4))),And(ListQ($s("lst")),NeQ(Plus(m,Part($s("lst"),C3)),C0),NeQ(Plus(m,Part($s("lst"),C4)),C0)))),FreeQ(m,x))),
ISetDelayed(GeneralizedBinomialParts(Times(u_,Power(x_,m_DEFAULT)),x_Symbol),
    Condition(With(List(Set($s("lst"),BinomialParts(u,x))),Condition(List(Part($s("lst"),C1),Part($s("lst"),C2),Plus(m,Part($s("lst"),C3)),m),And(ListQ($s("lst")),NeQ(Plus(m,Part($s("lst"),C3)),C0)))),FreeQ(m,x))),
ISetDelayed(GeneralizedBinomialParts(u_,x_Symbol),
    False),
ISetDelayed(GeneralizedTrinomialDegree(u_,x_Symbol),
    $(Function(Plus(Part(Slot1,C4),Negate(Part(Slot1,C5)))),GeneralizedTrinomialParts(u,x))),
ISetDelayed(GeneralizedTrinomialParts(Plus(Times(b_DEFAULT,Power(x_,n_DEFAULT)),Times(a_DEFAULT,Power(x_,q_DEFAULT)),Times(c_DEFAULT,Power(x_,r_DEFAULT))),x_Symbol),
    Condition(List(a,b,c,n,q),And(FreeQ(List(a,b,c,n,q),x),EqQ(r,Plus(Times(C2,n),Negate(q)))))),
ISetDelayed(GeneralizedTrinomialParts(Times(a_,u_),x_Symbol),
    Condition(With(List(Set($s("lst"),GeneralizedTrinomialParts(u,x))),Condition(List(Times(a,Part($s("lst"),C1)),Times(a,Part($s("lst"),C2)),Times(a,Part($s("lst"),C3)),Part($s("lst"),C4),Part($s("lst"),C5)),ListQ($s("lst")))),FreeQ(a,x))),
ISetDelayed(GeneralizedTrinomialParts(u_,x_Symbol),
    Condition(With(List(Set($s("lst"),Expon(u,x,$s("List")))),If(And(Equal(Length($s("lst")),C3),NeQ(Part($s("lst"),C0),C0),EqQ(Part($s("lst"),C3),Plus(Times(C2,Part($s("lst"),C2)),Negate(Part($s("lst"),C1))))),List(Coeff(u,x,Part($s("lst"),C1)),Coeff(u,x,Part($s("lst"),C2)),Coeff(u,x,Part($s("lst"),C3)),Part($s("lst"),C2),Part($s("lst"),C1)),False)),PolyQ(u,x))),
ISetDelayed(GeneralizedTrinomialParts(Times(u_,Power(x_,m_DEFAULT)),x_Symbol),
    Condition(With(List(Set($s("lst"),GeneralizedTrinomialParts(u,x))),Condition(List(Part($s("lst"),C1),Part($s("lst"),C2),Part($s("lst"),C3),Plus(m,Part($s("lst"),C4)),Plus(m,Part($s("lst"),C5))),And(ListQ($s("lst")),NeQ(Plus(m,Part($s("lst"),C4)),C0),NeQ(Plus(m,Part($s("lst"),C5)),C0)))),FreeQ(m,x))),
ISetDelayed(GeneralizedTrinomialParts(Times(u_,Power(x_,m_DEFAULT)),x_Symbol),
    Condition(With(List(Set($s("lst"),TrinomialParts(u,x))),Condition(List(Part($s("lst"),C1),Part($s("lst"),C2),Part($s("lst"),C3),Plus(m,Part($s("lst"),C4)),m),And(ListQ($s("lst")),NeQ(Plus(m,Part($s("lst"),C4)),C0)))),FreeQ(m,x))),
ISetDelayed(GeneralizedTrinomialParts(u_,x_Symbol),
    False),
ISetDelayed(IntPart(Times(m_,u_),$p(n, null,C1)),
    Condition(IntPart(u,Times(m,n)),RationalQ(m))),
ISetDelayed(IntPart(u_,$p(n, null,C1)),
    If(RationalQ(u),IntegerPart(Times(n,u)),If(SumQ(u),Map(Function(IntPart(Slot1,n)),u),C0))),
ISetDelayed(FracPart(Times(m_,u_),$p(n, null,C1)),
    Condition(FracPart(u,Times(m,n)),RationalQ(m))),
ISetDelayed(FracPart(u_,$p(n, null,C1)),
    If(RationalQ(u),FractionalPart(Times(n,u)),If(SumQ(u),Map(Function(FracPart(Slot1,n)),u),Times(n,u)))),
ISetDelayed(NumericFactor(u_),
    If(NumberQ(u),If(EqQ(Im(u),C0),u,If(EqQ(Re(u),C0),Im(u),C1)),If(PowerQ(u),If(And(RationalQ(Part(u,C1)),FractionQ(Part(u,C2))),If(Greater(Part(u,C2),C0),Power(Denominator(Part(u,C1)),-1),Power(Denominator(Power(Part(u,C1),-1)),-1)),C1),If(ProductQ(u),Map($s("Integrate::NumericFactor"),u),If(SumQ(u),If(Less(LeafCount(u),ZZ(50L)),$(Function(If(SumQ(Slot1),C1,NumericFactor(Slot1))),ContentFactor(u)),With(List(Set(m,NumericFactor(First(u))),Set(n,NumericFactor(Rest(u)))),If(And(Less(m,C0),Less(n,C0)),Negate(GCD(Negate(m),Negate(n))),GCD(m,n)))),C1))))),
ISetDelayed(NonnumericFactors(u_),
    If(NumberQ(u),If(EqQ(Im(u),C0),C1,If(EqQ(Re(u),C0),CI,u)),If(PowerQ(u),If(And(RationalQ(Part(u,C1)),FractionQ(Part(u,C2))),Times(u,Power(NumericFactor(u),-1)),u),If(ProductQ(u),Map($s("Integrate::NonnumericFactors"),u),If(SumQ(u),If(Less(LeafCount(u),ZZ(50L)),$(Function(If(SumQ(Slot1),u,NonnumericFactors(Slot1))),ContentFactor(u)),With(List(Set(n,NumericFactor(u))),Map(Function(Times(Slot1,Power(n,-1))),u))),u))))),
ISetDelayed(RemoveContent(u_,x_Symbol),
    With(List(Set(v,NonfreeFactors(u,x))),With(List(Set(w,Together(v))),If(EqQ(FreeFactors(w,x),C1),RemoveContentAux(v,x),RemoveContentAux(NonfreeFactors(w,x),x))))),
ISetDelayed(RemoveContentAux(Plus(Times(Power(a_,m_),u_DEFAULT),Times(b_,v_DEFAULT)),x_Symbol),
    Condition(If(Greater(m,C1),RemoveContentAux(Plus(Times(Power(a,Plus(m,Negate(C1))),u),Negate(v)),x),RemoveContentAux(Plus(u,Times(CN1,Power(a,Plus(C1,Negate(m))),v)),x)),And(IntegersQ(a,b),Equal(Plus(a,b),C0),RationalQ(m)))),
ISetDelayed(RemoveContentAux(Plus(Times(Power(a_,m_DEFAULT),u_DEFAULT),Times(Power(a_,n_DEFAULT),v_DEFAULT)),x_Symbol),
    Condition(RemoveContentAux(Plus(u,Times(Power(a,Plus(n,Negate(m))),v)),x),And(FreeQ(a,x),RationalQ(m,n),GreaterEqual(Plus(n,Negate(m)),C0)))),
ISetDelayed(RemoveContentAux(Plus(Times(Power(a_,m_DEFAULT),u_DEFAULT),Times(Power(a_,n_DEFAULT),v_DEFAULT),Times(Power(a_,p_DEFAULT),w_DEFAULT)),x_Symbol),
    Condition(RemoveContentAux(Plus(u,Times(Power(a,Plus(n,Negate(m))),v),Times(Power(a,Plus(p,Negate(m))),w)),x),And(FreeQ(a,x),RationalQ(m,n,p),GreaterEqual(Plus(n,Negate(m)),C0),GreaterEqual(Plus(p,Negate(m)),C0)))),
ISetDelayed(RemoveContentAux(u_,x_Symbol),
    If(And(SumQ(u),NegQ(First(u))),Negate(u),u)),
ISetDelayed(FreeFactors(u_,x_),
    If(ProductQ(u),Map(Function(If(FreeQ(Slot1,x),Slot1,C1)),u),If(FreeQ(u,x),u,C1))),
ISetDelayed(NonfreeFactors(u_,x_),
    If(ProductQ(u),Map(Function(If(FreeQ(Slot1,x),C1,Slot1)),u),If(FreeQ(u,x),C1,u))),
ISetDelayed(FreeTerms(u_,x_),
    If(SumQ(u),Map(Function(If(FreeQ(Slot1,x),Slot1,C0)),u),If(FreeQ(u,x),u,C0))),
ISetDelayed(NonfreeTerms(u_,x_),
    If(SumQ(u),Map(Function(If(FreeQ(Slot1,x),C0,Slot1)),u),If(FreeQ(u,x),C0,u))),
ISetDelayed(Expon($p("expr"),$p("form")),
    Exponent(Together($s("expr")),$s("form"))),
ISetDelayed(Expon($p("expr"),$p("form"),h_),
    Exponent(Together($s("expr")),$s("form"),h)),
ISetDelayed(Coeff($p("expr"),$p("form")),
    Coefficient(Together($s("expr")),$s("form"))),
ISetDelayed(Coeff($p("expr"),$p("form"),n_),
    With(List(Set($s("coef1"),Coefficient($s("expr"),$s("form"),n)),Set($s("coef2"),Coefficient(Together($s("expr")),$s("form"),n))),If(SameQ(Simplify(Plus($s("coef1"),Negate($s("coef2")))),C0),$s("coef1"),$s("coef2")))),
ISetDelayed(LeadTerm(u_),
    If(SumQ(u),First(u),u)),
ISetDelayed(RemainingTerms(u_),
    If(SumQ(u),Rest(u),C0)),
ISetDelayed(LeadFactor(u_),
    If(ProductQ(u),LeadFactor(First(u)),If(And(ComplexNumberQ(u),SameQ(Re(u),C0)),If(SameQ(Im(u),C1),u,LeadFactor(Im(u))),u))),
ISetDelayed(RemainingFactors(u_),
    If(ProductQ(u),Times(RemainingFactors(First(u)),Rest(u)),If(And(ComplexNumberQ(u),SameQ(Re(u),C0)),If(SameQ(Im(u),C1),C1,Times(CI,RemainingFactors(Im(u)))),C1))),
ISetDelayed(LeadBase(u_),
    With(List(Set(v,LeadFactor(u))),If(PowerQ(v),Part(v,C1),v))),
ISetDelayed(LeadDegree(u_),
    With(List(Set(v,LeadFactor(u))),If(PowerQ(v),Part(v,C2),C1))),
ISetDelayed($($s("§numer"),Power($p(m, Integer),$p(n,$s("Rational")))),
    Condition(C1,Less(n,C0))),
ISetDelayed($($s("§numer"),Times(u_,v_)),
    Times($($s("§numer"),u),$($s("§numer"),v))),
ISetDelayed($($s("§numer"),u_),
    Numerator(u)),
ISetDelayed($($s("§denom"),Power($p(m, Integer),$p(n,$s("Rational")))),
    Condition(Power(m,Negate(n)),Less(n,C0))),
ISetDelayed($($s("§denom"),Times(u_,v_)),
    Times($($s("§denom"),u),$($s("§denom"),v))),
ISetDelayed($($s("§denom"),u_),
    Denominator(u)),
ISetDelayed(LinearQ(u_,x_Symbol),
    If(ListQ(u),Catch(CompoundExpression(Scan(Function(If(PolyQ(Slot1,x,C1),Null,Throw(False))),u),True)),PolyQ(u,x,C1))),
ISetDelayed(QuadraticProductQ(u_,x_Symbol),
    And(ProductQ(NonfreeFactors(u,x)),Catch(CompoundExpression(Scan(Function(If(MatchQ(Slot1,Condition(Power($p("§pm"),m_DEFAULT),And(PolyQ($s("§pm"),x),LessEqual(Expon($s("§pm"),x),C2),IntegerQ(m)))),Null,Throw(False))),NonfreeFactors(u,x)),True)))),
ISetDelayed(PowerOfLinearQ(Power(u_,m_DEFAULT),x_Symbol),
    And(FreeQ(m,x),PolynomialQ(u,x),If(IntegerQ(m),MatchQ(FactorSquareFree(u),Condition(Power(w_,n_DEFAULT),And(FreeQ(n,x),LinearQ(w,x)))),LinearQ(u,x)))),
ISetDelayed(QuadraticQ(u_,x_Symbol),
    If(ListQ(u),Catch(CompoundExpression(Scan(Function(If(Not(QuadraticQ(Slot1,x)),Throw(False))),u),True)),And(PolyQ(u,x,C2),Not(And(SameQ(Coefficient(u,x,C0),C0),SameQ(Coefficient(u,x,C1),C0))))))
  );
}
