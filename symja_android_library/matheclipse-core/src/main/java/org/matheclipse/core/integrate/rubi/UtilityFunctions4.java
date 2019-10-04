package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.Abs;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.Apply;
import static org.matheclipse.core.expression.F.AtomQ;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.Catch;
import static org.matheclipse.core.expression.F.Coefficient;
import static org.matheclipse.core.expression.F.CoefficientList;
import static org.matheclipse.core.expression.F.Complex;
import static org.matheclipse.core.expression.F.CompoundExpression;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.Do;
import static org.matheclipse.core.expression.F.Equal;
import static org.matheclipse.core.expression.F.EvenQ;
import static org.matheclipse.core.expression.F.Expand;
import static org.matheclipse.core.expression.F.Exponent;
import static org.matheclipse.core.expression.F.False;
import static org.matheclipse.core.expression.F.First;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.Function;
import static org.matheclipse.core.expression.F.Greater;
import static org.matheclipse.core.expression.F.GreaterEqual;
import static org.matheclipse.core.expression.F.Head;
import static org.matheclipse.core.expression.F.ISetDelayed;
import static org.matheclipse.core.expression.F.If;
import static org.matheclipse.core.expression.F.Im;
import static org.matheclipse.core.expression.F.Integer;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.LeafCount;
import static org.matheclipse.core.expression.F.Length;
import static org.matheclipse.core.expression.F.Less;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.ListQ;
import static org.matheclipse.core.expression.F.MatchQ;
import static org.matheclipse.core.expression.F.Module;
import static org.matheclipse.core.expression.F.N;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Null;
import static org.matheclipse.core.expression.F.NumberQ;
import static org.matheclipse.core.expression.F.Numerator;
import static org.matheclipse.core.expression.F.NumericQ;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.OrderedQ;
import static org.matheclipse.core.expression.F.Part;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.PolynomialQ;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.QQ;
import static org.matheclipse.core.expression.F.Quiet;
import static org.matheclipse.core.expression.F.Re;
import static org.matheclipse.core.expression.F.Refine;
import static org.matheclipse.core.expression.F.Rest;
import static org.matheclipse.core.expression.F.SameQ;
import static org.matheclipse.core.expression.F.Scan;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Simplify;
import static org.matheclipse.core.expression.F.Slot1;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Throw;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.Together;
import static org.matheclipse.core.expression.F.True;
import static org.matheclipse.core.expression.F.UnsameQ;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.num;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.w;
import static org.matheclipse.core.expression.F.w_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialParts;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.CancelCommonFactors;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Coeff;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ComplexNumberQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Expon;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GeneralizedBinomialParts;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GeneralizedBinomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GeneralizedTrinomialParts;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GeneralizedTrinomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NegQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NiceSqrtAuxQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NiceSqrtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NonnumericFactors;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NonsumQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NumericFactor;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PerfectSquareQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PolyQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosAux;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PowerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ProductQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ProperPolyQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.QuadraticQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalFunctionExponents;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalFunctionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplerIntegrandQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplerSqrtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumSimplerAuxQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumSimplerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.TogetherSimplify;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.TrinomialParts;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.TrinomialQ;

/**
 * UtilityFunctions rules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class UtilityFunctions4 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            ISetDelayed(42, PolyQ(u_, x_Symbol, n_),
                    If(PolynomialQ(u, x), And(EqQ(Exponent(u, x), n), NeQ(Coefficient(u, x, n), C0)), With(List(Set(v, Together(u))), And(PolynomialQ(v, x), EqQ(Exponent(v, x), n), NeQ(Coefficient(v, x, n), C0)))));
            ISetDelayed(43, PolyQ(u_, Power(x_Symbol, v_), n_),
                    And(PolyQ(u, Power(x, v)), EqQ(Expon(u, Power(x, v)), n), NeQ(Coeff(u, Power(x, v), n), C0)));
            ISetDelayed(44, PolyQ(u_, x_Symbol),
                    Or(PolynomialQ(u, x), PolynomialQ(Together(u), x)));
            ISetDelayed(45, PolyQ(u_, Power(x_Symbol, $p(n, Integer))),
                    Condition(If(PolynomialQ(u, x), PolynomialQ(u, Power(x, n)), With(List(Set(v, Together(u))), And(PolynomialQ(v, x), PolynomialQ(v, Power(x, n))))), Greater(n, C0)));
            ISetDelayed(46, PolyQ(u_, Power(x_Symbol, v_)),
                    Condition(If(SameQ(Quiet(PolynomialQ(u, Power(x, v))), True), FreeQ(CoefficientList(u, Power(x, v)), x), With(List(Set(w, Together(u))), And(SameQ(Quiet(PolynomialQ(w, Power(x, v))), True), FreeQ(CoefficientList(w, Power(x, v)), x)))), And(NonsumQ(v), FreeQ(v, x))));
            ISetDelayed(47, PolyQ(u_, v_),
                    False);
            ISetDelayed(48, ProperPolyQ(u_, x_Symbol),
                    And(PolyQ(u, x), NeQ(Coeff(u, x, C0), C0)));
            ISetDelayed(49, BinomialQ(u_, x_Symbol),
                    If(ListQ(u), Catch(CompoundExpression(Scan(Function(If(Not(BinomialQ(Slot1, x)), Throw(False))), u), True)), ListQ(BinomialParts(u, x))));
            ISetDelayed(50, BinomialQ(u_, x_Symbol, n_),
                    If(ListQ(u), Catch(CompoundExpression(Scan(Function(If(Not(BinomialQ(Slot1, x, n)), Throw(False))), u), True)), $(Function(And(ListQ(Slot1), SameQ(Part(Slot1, C3), n))), BinomialParts(u, x))));
            ISetDelayed(51, TrinomialQ(u_, x_Symbol),
                    If(ListQ(u), Catch(CompoundExpression(Scan(Function(If(Not(TrinomialQ(Slot1, x)), Throw(False))), u), True)), And(ListQ(TrinomialParts(u, x)), Not(QuadraticQ(u, x)), Not(MatchQ(u, Condition(Sqr(w_), BinomialQ(w, x)))))));
            ISetDelayed(52, GeneralizedBinomialQ(u_, x_Symbol),
                    If(ListQ(u), Catch(CompoundExpression(Scan(Function(If(Not(GeneralizedBinomialQ(Slot1, x)), Throw(False))), u), True)), ListQ(GeneralizedBinomialParts(u, x))));
            ISetDelayed(53, GeneralizedTrinomialQ(u_, x_Symbol),
                    If(ListQ(u), Catch(CompoundExpression(Scan(Function(If(Not(GeneralizedTrinomialQ(Slot1, x)), Throw(False))), u), True)), ListQ(GeneralizedTrinomialParts(u, x))));
            ISetDelayed(54, PosQ(u_),
                    PosAux(TogetherSimplify(u)));
            ISetDelayed(55, PosAux(u_),
                    If(NumberQ(u), If(SameQ(Head(u), Complex), If(EqQ(Re(u), C0), PosAux(Im(u)), PosAux(Re(u))), Greater(u, C0)), If(NumericQ(u), With(List(Set(v, Simplify(Re(u)))), If(NumberQ(v), If(EqQ(v, C0), PosAux(Simplify(Im(u))), Greater(v, C0)), With(List(Set(w, N(u))), And(NumberQ(w), PosAux(w))))), With(List(Set(v, Refine(Greater(u, C0)))), If(Or(SameQ(v, True), SameQ(v, False)), v, If(PowerQ(u), If(IntegerQ(Part(u, C2)), Or(EvenQ(Part(u, C2)), PosAux(Part(u, C1))), True), If(ProductQ(u), If(PosAux(First(u)), PosAux(Rest(u)), Not(PosAux(Rest(u)))), If(SumQ(u), PosAux(First(u)), True))))))));
            ISetDelayed(56, NegQ(u_),
                    And(Not(PosQ(u)), NeQ(u, C0)));
            ISetDelayed(57, NiceSqrtQ(u_),
                    And(Not(LtQ(u, C0)), NiceSqrtAuxQ(u)));
            ISetDelayed(58, NiceSqrtAuxQ(u_),
                    If(RationalQ(u), Greater(u, C0), If(PowerQ(u), EvenQ(Part(u, C2)), If(ProductQ(u), And(NiceSqrtAuxQ(First(u)), NiceSqrtAuxQ(Rest(u))), If(SumQ(u), $(Function(And(NonsumQ(Slot1), NiceSqrtAuxQ(Slot1))), Simplify(u)), False)))));
            ISetDelayed(59, PerfectSquareQ(u_),
                    If(RationalQ(u), And(Greater(u, C0), RationalQ(Sqrt(u))), If(PowerQ(u), EvenQ(Part(u, C2)), If(ProductQ(u), And(PerfectSquareQ(First(u)), PerfectSquareQ(Rest(u))), If(SumQ(u), $(Function(And(NonsumQ(Slot1), PerfectSquareQ(Slot1))), Simplify(u)), False)))));
            ISetDelayed(60, SimplerQ(u_, v_),
                    If(IntegerQ(u), If(IntegerQ(v), If(Equal(u, v), False, If(Equal(u, Negate(v)), Less(v, C0), Less(Abs(u), Abs(v)))), True), If(IntegerQ(v), False, If(FractionQ(u), If(FractionQ(v), If(Equal(Denominator(u), Denominator(v)), SimplerQ(Numerator(u), Numerator(v)), Less(Denominator(u), Denominator(v))), True), If(FractionQ(v), False, If(And(Or(SameQ(Re(u), C0), SameQ(Re(u), num(0.0))), Or(SameQ(Re(v), C0), SameQ(Re(v), num(0.0)))), SimplerQ(Im(u), Im(v)), If(ComplexNumberQ(u), If(ComplexNumberQ(v), If(Equal(Re(u), Re(v)), SimplerQ(Im(u), Im(v)), SimplerQ(Re(u), Re(v))), False), If(NumberQ(u), If(NumberQ(v), OrderedQ(List(u, v)), True), If(NumberQ(v), False, If(AtomQ(u), If(AtomQ(v), OrderedQ(List(u, v)), True), If(AtomQ(v), False, If(SameQ(Head(u), Head(v)), If(Equal(Length(u), Length(v)), If(Equal(LeafCount(u), LeafCount(v)), Catch(CompoundExpression(Do(If(SameQ(Part(u, $s("ii")), Part(v, $s("ii"))), Null, Throw(SimplerQ(Part(u, $s("ii")), Part(v, $s("ii"))))), List($s("ii"), Length(u))), False)), Less(LeafCount(u), LeafCount(v))), Less(Length(u), Length(v))), If(Equal(LeafCount(u), LeafCount(v)), Not(OrderedQ(List(v, u))), Less(LeafCount(u), LeafCount(v)))))))))))))));
            ISetDelayed(61, SimplerSqrtQ(u_, v_),
                    If(And(LtQ(v, C0), Not(LtQ(u, C0))), True, If(And(LtQ(u, C0), Not(LtQ(v, C0))), False, With(List(Set($s("sqrtu"), Rt(u, C2)), Set($s("sqrtv"), Rt(v, C2))), If(IntegerQ($s("sqrtu")), If(IntegerQ($s("sqrtv")), Less($s("sqrtu"), $s("sqrtv")), True), If(IntegerQ($s("sqrtv")), False, If(RationalQ($s("sqrtu")), If(RationalQ($s("sqrtv")), Less($s("sqrtu"), $s("sqrtv")), True), If(RationalQ($s("sqrtv")), False, If(PosQ(u), If(PosQ(v), Less(LeafCount($s("sqrtu")), LeafCount($s("sqrtv"))), True), If(PosQ(v), False, If(Less(LeafCount($s("sqrtu")), LeafCount($s("sqrtv"))), True, If(Less(LeafCount($s("sqrtv")), LeafCount($s("sqrtu"))), False, Not(OrderedQ(List(v, u)))))))))))))));
            ISetDelayed(62, SumSimplerQ(u_, v_),
                    If(RationalQ(u, v), If(Equal(v, C0), False, If(Greater(v, C0), Less(u, CN1), GreaterEqual(u, Negate(v)))), SumSimplerAuxQ(Expand(u), Expand(v))));
            ISetDelayed(63, SumSimplerAuxQ(u_, v_),
                    Condition(And(Or(RationalQ(First(v)), SumSimplerAuxQ(u, First(v))), Or(RationalQ(Rest(v)), SumSimplerAuxQ(u, Rest(v)))), SumQ(v)));
            ISetDelayed(64, SumSimplerAuxQ(u_, v_),
                    Condition(Or(SumSimplerAuxQ(First(u), v), SumSimplerAuxQ(Rest(u), v)), SumQ(u)));
            ISetDelayed(65, SumSimplerAuxQ(u_, v_),
                    And(UnsameQ(v, C0), SameQ(NonnumericFactors(u), NonnumericFactors(v)), Or(Less(Times(NumericFactor(u), Power(NumericFactor(v), CN1)), CN1D2), And(Equal(Times(NumericFactor(u), Power(NumericFactor(v), CN1)), CN1D2), Less(NumericFactor(u), C0)))));
            ISetDelayed(66, SimplerIntegrandQ(u_, v_, x_Symbol),
                    Module(List(Set($s("lst"), CancelCommonFactors(u, v)), $s("u1"), $s("v1")), CompoundExpression(Set($s("u1"), Part($s("lst"), C1)), Set($s("v1"), Part($s("lst"), C2)), If(Less(LeafCount($s("u1")), Times(QQ(3L, 4L), LeafCount($s("v1")))), True, If(RationalFunctionQ($s("u1"), x), If(RationalFunctionQ($s("v1"), x), Less(Apply(Plus, RationalFunctionExponents($s("u1"), x)), Apply(Plus, RationalFunctionExponents($s("v1"), x))), True), False)))));
        }
    }
}
