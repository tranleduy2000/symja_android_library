package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$ps;
import static org.matheclipse.core.expression.F.$rubi;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.Apply;
import static org.matheclipse.core.expression.F.AtomQ;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.Catch;
import static org.matheclipse.core.expression.F.Coefficient;
import static org.matheclipse.core.expression.F.CompoundExpression;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Drop;
import static org.matheclipse.core.expression.F.Equal;
import static org.matheclipse.core.expression.F.Exponent;
import static org.matheclipse.core.expression.F.FactorInteger;
import static org.matheclipse.core.expression.F.False;
import static org.matheclipse.core.expression.F.First;
import static org.matheclipse.core.expression.F.Flatten;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.Function;
import static org.matheclipse.core.expression.F.Greater;
import static org.matheclipse.core.expression.F.Head;
import static org.matheclipse.core.expression.F.ISetDelayed;
import static org.matheclipse.core.expression.F.If;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.InverseFunction;
import static org.matheclipse.core.expression.F.LeafCount;
import static org.matheclipse.core.expression.F.Length;
import static org.matheclipse.core.expression.F.Less;
import static org.matheclipse.core.expression.F.LessEqual;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Map;
import static org.matheclipse.core.expression.F.MatchQ;
import static org.matheclipse.core.expression.F.Min;
import static org.matheclipse.core.expression.F.Module;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.OddQ;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Part;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.PolynomialQ;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Prepend;
import static org.matheclipse.core.expression.F.Rest;
import static org.matheclipse.core.expression.F.SameQ;
import static org.matheclipse.core.expression.F.Scan;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Simplify;
import static org.matheclipse.core.expression.F.Slot1;
import static org.matheclipse.core.expression.F.Slot2;
import static org.matheclipse.core.expression.F.Sort;
import static org.matheclipse.core.expression.F.Throw;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.Together;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.u_DEFAULT;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.w;
import static org.matheclipse.core.expression.F.w_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.AbsorbMinusSign;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.AbsurdNumberFactors;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.AbsurdNumberGCD;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.AbsurdNumberGCDList;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.AbsurdNumberQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialMatchQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.CalculusQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.CombineExponents;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EveryQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FactorAbsurdNumber;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionalPowerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegerPowerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InverseFunctionOfQuotientOfLinears;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InverseFunctionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.MergeMonomials;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.MinimumMonomialExponent;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.MonomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NonabsurdNumberFactors;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NonnumericFactors;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NormalizeIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NormalizeIntegrandAux;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NormalizeIntegrandFactor;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NormalizeIntegrandFactorBase;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NormalizeLeadTermSigns;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NormalizeSumFactors;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NormalizeTogether;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NumericFactor;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PowerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ProductQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.QuotientOfLinearsQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SignOfFactor;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.StopFunctionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SubstForFractionalPower;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SubstForInverseFunction;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.TogetherSimplify;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.TrinomialMatchQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.TrinomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.UnifySum;

/**
 * UtilityFunctions rules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class UtilityFunctions9 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            ISetDelayed(167, InverseFunctionOfQuotientOfLinears(u_, x_Symbol),
                    If(Or(AtomQ(u), CalculusQ(u), FreeQ(u, x)), False, If(And(InverseFunctionQ(u), QuotientOfLinearsQ(Part(u, C1), x)), u, Module(List($s("tmp")), Catch(CompoundExpression(Scan(Function(If(Not(AtomQ(Set($s("tmp"), InverseFunctionOfQuotientOfLinears(Slot1, x)))), Throw($s("tmp")))), u), False))))));
            ISetDelayed(168, SubstForFractionalPower(u_, v_, n_, w_, x_Symbol),
                    If(AtomQ(u), If(SameQ(u, x), w, u), If(And(FractionalPowerQ(u), EqQ(Part(u, C1), v)), Power(x, Times(n, Part(u, C2))), Map(Function(SubstForFractionalPower(Slot1, v, n, w, x)), u))));
            ISetDelayed(169, SubstForInverseFunction(u_, v_, x_Symbol),
                    SubstForInverseFunction(u, v, Times(Plus(Negate(Coefficient(Part(v, C1), x, C0)), $(InverseFunction(Head(v)), x)), Power(Coefficient(Part(v, C1), x, C1), CN1)), x));
            ISetDelayed(170, SubstForInverseFunction(u_, v_, w_, x_Symbol),
                    If(AtomQ(u), If(SameQ(u, x), w, u), If(And(SameQ(Head(u), Head(v)), EqQ(Part(u, C1), Part(v, C1))), x, Map(Function(SubstForInverseFunction(Slot1, v, w, x)), u))));
            ISetDelayed(171, AbsurdNumberQ(u_),
                    RationalQ(u));
            ISetDelayed(172, AbsurdNumberQ(Power(u_, v_)),
                    And(RationalQ(u), Greater(u, C0), FractionQ(v)));
            ISetDelayed(173, AbsurdNumberQ(Times(u_, v_)),
                    And(AbsurdNumberQ(u), AbsurdNumberQ(v)));
            ISetDelayed(174, AbsurdNumberFactors(u_),
                    If(AbsurdNumberQ(u), u, If(ProductQ(u), Map($rubi("AbsurdNumberFactors"), u), NumericFactor(u))));
            ISetDelayed(175, NonabsurdNumberFactors(u_),
                    If(AbsurdNumberQ(u), C1, If(ProductQ(u), Map($rubi("NonabsurdNumberFactors"), u), NonnumericFactors(u))));
            ISetDelayed(176, FactorAbsurdNumber(m_),
                    If(RationalQ(m), FactorInteger(m), If(PowerQ(m), Map(Function(List(Part(Slot1, C1), Times(Part(Slot1, C2), Part(m, C2)))), FactorInteger(Part(m, C1))), CombineExponents(Sort(Flatten(Map($rubi("FactorAbsurdNumber"), Apply(List, m)), C1), Function(Less(Part(Slot1, C1), Part(Slot2, C1))))))));
            ISetDelayed(177, CombineExponents($p("lst")),
                    If(Less(Length($s("lst")), C2), $s("lst"), If(Equal(Part($s("lst"), C1, C1), Part($s("lst"), C2, C1)), CombineExponents(Prepend(Drop($s("lst"), C2), List(Part($s("lst"), C1, C1), Plus(Part($s("lst"), C1, C2), Part($s("lst"), C2, C2))))), Prepend(CombineExponents(Rest($s("lst"))), First($s("lst"))))));
            ISetDelayed(178, AbsurdNumberGCD($ps("seq")),
                    With(List(Set($s("lst"), List($s("seq")))), If(Equal(Length($s("lst")), C1), First($s("lst")), AbsurdNumberGCDList(FactorAbsurdNumber(First($s("lst"))), FactorAbsurdNumber(Apply($rubi("AbsurdNumberGCD"), Rest($s("lst"))))))));
            ISetDelayed(179, AbsurdNumberGCDList($p("lst1"), $p("lst2")),
                    If(SameQ($s("lst1"), List()), Apply(Times, Map(Function(Power(Part(Slot1, C1), Min(Part(Slot1, C2), C0))), $s("lst2"))), If(SameQ($s("lst2"), List()), Apply(Times, Map(Function(Power(Part(Slot1, C1), Min(Part(Slot1, C2), C0))), $s("lst1"))), If(Equal(Part($s("lst1"), C1, C1), Part($s("lst2"), C1, C1)), If(LessEqual(Part($s("lst1"), C1, C2), Part($s("lst2"), C1, C2)), Times(Power(Part($s("lst1"), C1, C1), Part($s("lst1"), C1, C2)), AbsurdNumberGCDList(Rest($s("lst1")), Rest($s("lst2")))), Times(Power(Part($s("lst1"), C1, C1), Part($s("lst2"), C1, C2)), AbsurdNumberGCDList(Rest($s("lst1")), Rest($s("lst2"))))), If(Less(Part($s("lst1"), C1, C1), Part($s("lst2"), C1, C1)), If(Less(Part($s("lst1"), C1, C2), C0), Times(Power(Part($s("lst1"), C1, C1), Part($s("lst1"), C1, C2)), AbsurdNumberGCDList(Rest($s("lst1")), $s("lst2"))), AbsurdNumberGCDList(Rest($s("lst1")), $s("lst2"))), If(Less(Part($s("lst2"), C1, C2), C0), Times(Power(Part($s("lst2"), C1, C1), Part($s("lst2"), C1, C2)), AbsurdNumberGCDList($s("lst1"), Rest($s("lst2")))), AbsurdNumberGCDList($s("lst1"), Rest($s("lst2")))))))));
            ISetDelayed(180, NormalizeIntegrand(u_, x_Symbol),
                    With(List(Set(v, NormalizeLeadTermSigns(NormalizeIntegrandAux(u, x)))), If(SameQ(v, NormalizeLeadTermSigns(u)), u, v)));
            ISetDelayed(181, NormalizeIntegrandAux(u_, x_Symbol),
                    If(SumQ(u), Map(Function(NormalizeIntegrandAux(Slot1, x)), u), If(ProductQ(MergeMonomials(u, x)), Map(Function(NormalizeIntegrandFactor(Slot1, x)), MergeMonomials(u, x)), NormalizeIntegrandFactor(MergeMonomials(u, x), x))));
            ISetDelayed(182, NormalizeIntegrandFactor(u_, x_Symbol),
                    Module(List($s("bas"), $s("deg"), $s("§min")), If(And(PowerQ(u), FreeQ(Part(u, C2), x)), CompoundExpression(Set($s("bas"), NormalizeIntegrandFactorBase(Part(u, C1), x)), Set($s("deg"), Part(u, C2)), If(And(IntegerQ($s("deg")), SumQ($s("bas")), EveryQ(Function(MonomialQ(Slot1, x)), $s("bas"))), CompoundExpression(Set($s("§min"), MinimumMonomialExponent($s("bas"), x)), Times(Power(x, Times($s("§min"), $s("deg"))), Power(Map(Function(Simplify(Times(Slot1, Power(Power(x, $s("§min")), CN1)))), $s("bas")), $s("deg")))), Power($s("bas"), $s("deg")))), If(And(PowerQ(u), FreeQ(Part(u, C1), x)), Power(Part(u, C1), NormalizeIntegrandFactorBase(Part(u, C2), x)), CompoundExpression(Set($s("bas"), NormalizeIntegrandFactorBase(u, x)), If(And(SumQ($s("bas")), EveryQ(Function(MonomialQ(Slot1, x)), $s("bas"))), CompoundExpression(Set($s("§min"), MinimumMonomialExponent($s("bas"), x)), Times(Power(x, $s("§min")), Map(Function(Times(Slot1, Power(Power(x, $s("§min")), CN1))), $s("bas")))), $s("bas")))))));
            ISetDelayed(183, NormalizeIntegrandFactorBase(Times(u_, Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(NormalizeIntegrandFactorBase(Map(Function(Times(Power(x, m), Slot1)), u), x), And(FreeQ(m, x), SumQ(u))));
            ISetDelayed(184, NormalizeIntegrandFactorBase(u_, x_Symbol),
                    If(BinomialQ(u, x), If(BinomialMatchQ(u, x), u, ExpandToSum(u, x)), If(TrinomialQ(u, x), If(TrinomialMatchQ(u, x), u, ExpandToSum(u, x)), If(ProductQ(u), Map(Function(NormalizeIntegrandFactor(Slot1, x)), u), If(And(PolynomialQ(u, x), LessEqual(Exponent(u, x), C4)), ExpandToSum(u, x), If(SumQ(u), With(List(Set(v, TogetherSimplify(u))), If(Or(SumQ(v), MatchQ(v, Condition(Times(Power(x, m_DEFAULT), w_), And(FreeQ(m, x), SumQ(w)))), Greater(LeafCount(v), Plus(LeafCount(u), C2))), UnifySum(u, x), NormalizeIntegrandFactorBase(v, x))), Map(Function(NormalizeIntegrandFactor(Slot1, x)), u)))))));
            ISetDelayed(185, NormalizeTogether(u_),
                    NormalizeLeadTermSigns(Together(u)));
            ISetDelayed(186, NormalizeLeadTermSigns(u_),
                    With(List(Set($s("lst"), If(ProductQ(u), Map($rubi("SignOfFactor"), u), SignOfFactor(u)))), If(Equal(Part($s("lst"), C1), C1), Part($s("lst"), C2), AbsorbMinusSign(Part($s("lst"), C2)))));
            ISetDelayed(187, AbsorbMinusSign(Times(u_DEFAULT, $p(v, Plus))),
                    Times(u, CN1, v));
            ISetDelayed(188, AbsorbMinusSign(Times(u_DEFAULT, Power($p(v, Plus), m_))),
                    Condition(Times(u, Power(Negate(v), m)), OddQ(m)));
            ISetDelayed(189, AbsorbMinusSign(u_),
                    Negate(u));
            ISetDelayed(190, NormalizeSumFactors(u_),
                    If(Or(AtomQ(u), StopFunctionQ(u)), u, If(ProductQ(u), $(Function(Times(Part(Slot1, C1), Part(Slot1, C2))), SignOfFactor(Map($rubi("NormalizeSumFactors"), u))), Map($rubi("NormalizeSumFactors"), u))));
            ISetDelayed(191, SignOfFactor(u_),
                    If(Or(And(RationalQ(u), Less(u, C0)), And(SumQ(u), Less(NumericFactor(First(u)), C0))), List(CN1, Negate(u)), If(And(IntegerPowerQ(u), SumQ(Part(u, C1)), Less(NumericFactor(First(Part(u, C1))), C0)), List(Power(CN1, Part(u, C2)), Power(Negate(Part(u, C1)), Part(u, C2))), If(ProductQ(u), Map($rubi("SignOfFactor"), u), List(C1, u)))));
        }
    }
}
