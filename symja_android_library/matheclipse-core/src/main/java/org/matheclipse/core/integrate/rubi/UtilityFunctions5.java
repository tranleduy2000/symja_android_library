package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.*;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ActivateTrig;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.AlgebraicFunctionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.AlgebraicTrigFunctionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialParts;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.CalculusQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ComplexFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EulerIntegrandQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EvenQuotientQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.F;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FalseQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FindTrigFactor;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FreeFactors;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfCosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfCoshQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfDensePolynomialsQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfExpnQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfExponential;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfExponentialFunction;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfExponentialFunctionAux;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfExponentialTest;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfExponentialTestAux;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfHyperbolic;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfHyperbolicQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfLog;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfSinQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfSinhQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfSquareRootOfQuadratic;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfTanQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfTanWeight;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfTanhQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfTanhWeight;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfTrig;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfTrigOfLinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfTrigQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.G;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.HeldFormQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.HyperbolicQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InertTrigFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegerPowerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegerQuotientQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LeadBase;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LeadDegree;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LeadFactor;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LogQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.MonomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NegQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NonfreeFactors;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NonnumericFactors;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NonsumQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NumericFactor;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.OddHyperbolicPowerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.OddQuotientQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.OddTrigPowerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PolyQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PowerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PowerVariableDegree;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PowerVariableExpn;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PowerVariableSubst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ProductQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PureFunctionOfCosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PureFunctionOfCoshQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PureFunctionOfCotQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PureFunctionOfCothQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PureFunctionOfSinQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PureFunctionOfSinhQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PureFunctionOfTanQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PureFunctionOfTanhQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.QuadraticQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ReapList;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RectifyCotangent;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RectifyTangent;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RemainingFactors;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyAntiderivative;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SquareRootOfQuadraticSubst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SubstAux;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.TrigQ;

/**
 * UtilityFunctions rules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *
 */
public class UtilityFunctions5 {
    public static IAST RULES = List(
            ISetDelayed(386, FunctionOfExponential(u_, x_Symbol),
                    Block(List(Set($s("$base$"), Null), Set($s("$expon$"), Null), Set($s("§$exponflag$"), False)), CompoundExpression(FunctionOfExponentialTest(u, x), Power($s("$base$"), $s("$expon$"))))),
            ISetDelayed(387, FunctionOfExponentialFunction(u_, x_Symbol),
                    Block(List(Set($s("$base$"), Null), Set($s("$expon$"), Null), Set($s("§$exponflag$"), False)), CompoundExpression(FunctionOfExponentialTest(u, x), SimplifyIntegrand(FunctionOfExponentialFunctionAux(u, x), x)))),
            ISetDelayed(388, FunctionOfExponentialFunctionAux(u_, x_),
                    If(AtomQ(u), u, If(And(PowerQ(u), FreeQ(Part(u, C1), x), LinearQ(Part(u, C2), x)), If(EqQ(Coefficient($s("$expon$"), x, C0), C0), Times(Power(Part(u, C1), Coefficient(Part(u, C2), x, C0)), Power(x, FullSimplify(Times(Log(Part(u, C1)), Coefficient(Part(u, C2), x, C1), Power(Times(Log($s("$base$")), Coefficient($s("$expon$"), x, C1)), -1))))), Power(x, FullSimplify(Times(Log(Part(u, C1)), Coefficient(Part(u, C2), x, C1), Power(Times(Log($s("$base$")), Coefficient($s("$expon$"), x, C1)), -1))))), If(And(HyperbolicQ(u), LinearQ(Part(u, C1), x)), Module(List($s("tmp")), CompoundExpression(Set($s("tmp"), Power(x, FullSimplify(Times(Coefficient(Part(u, C1), x, C1), Power(Times(Log($s("$base$")), Coefficient($s("$expon$"), x, C1)), -1))))), Switch(Head(u), Sinh, Plus(Times(C1D2, $s("tmp")), Negate(Power(Times(C2, $s("tmp")), -1))), Cosh, Plus(Times(C1D2, $s("tmp")), Power(Times(C2, $s("tmp")), -1)), Tanh, Times(Plus($s("tmp"), Negate(Power($s("tmp"), -1))), Power(Plus($s("tmp"), Power($s("tmp"), -1)), -1)), Coth, Times(Plus($s("tmp"), Power($s("tmp"), -1)), Power(Plus($s("tmp"), Negate(Power($s("tmp"), -1))), -1)), Sech, Times(C2, Power(Plus($s("tmp"), Power($s("tmp"), -1)), -1)), Csch, Times(C2, Power(Plus($s("tmp"), Negate(Power($s("tmp"), -1))), -1))))), If(And(PowerQ(u), FreeQ(Part(u, C1), x), SumQ(Part(u, C2))), Times(FunctionOfExponentialFunctionAux(Power(Part(u, C1), First(Part(u, C2))), x), FunctionOfExponentialFunctionAux(Power(Part(u, C1), Rest(Part(u, C2))), x)), Map(Function(FunctionOfExponentialFunctionAux(Slot1, x)), u)))))),
            ISetDelayed(389, FunctionOfExponentialTest(u_, x_),
                    If(FreeQ(u, x), True, If(Or(SameQ(u, x), CalculusQ(u)), False, If(And(PowerQ(u), FreeQ(Part(u, C1), x), LinearQ(Part(u, C2), x)), CompoundExpression(Set($s("§$exponflag$"), True), FunctionOfExponentialTestAux(Part(u, C1), Part(u, C2), x)), If(And(HyperbolicQ(u), LinearQ(Part(u, C1), x)), FunctionOfExponentialTestAux(E, Part(u, C1), x), If(And(PowerQ(u), FreeQ(Part(u, C1), x), SumQ(Part(u, C2))), And(FunctionOfExponentialTest(Power(Part(u, C1), First(Part(u, C2))), x), FunctionOfExponentialTest(Power(Part(u, C1), Rest(Part(u, C2))), x)), Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfExponentialTest(Slot1, x)), Throw(False))), u), True)))))))),
            ISetDelayed(390, FunctionOfExponentialTestAux($p("base"), $p("expon"), x_),
                    If(SameQ($s("$base$"), Null), CompoundExpression(Set($s("$base$"), $s("base")), Set($s("$expon$"), $s("expon")), True), Module(List($s("tmp")), CompoundExpression(Set($s("tmp"), FullSimplify(Times(Log($s("base")), Coefficient($s("expon"), x, C1), Power(Times(Log($s("$base$")), Coefficient($s("$expon$"), x, C1)), -1)))), If(Not(RationalQ($s("tmp"))), False, If(Or(EqQ(Coefficient($s("$expon$"), x, C0), C0), NeQ($s("tmp"), FullSimplify(Times(Log($s("base")), Coefficient($s("expon"), x, C0), Power(Times(Log($s("$base$")), Coefficient($s("$expon$"), x, C0)), -1))))), CompoundExpression(If(And(IGtQ($s("base"), C0), IGtQ($s("$base$"), C0), Less($s("base"), $s("$base$"))), CompoundExpression(Set($s("$base$"), $s("base")), Set($s("$expon$"), $s("expon")), Set($s("tmp"), Power($s("tmp"), -1)))), Set($s("$expon$"), Times(Coefficient($s("$expon$"), x, C1), x, Power(Denominator($s("tmp")), -1))), If(And(Less($s("tmp"), C0), NegQ(Coefficient($s("$expon$"), x, C1))), CompoundExpression(Set($s("$expon$"), Negate($s("$expon$"))), True), True)), CompoundExpression(If(And(IGtQ($s("base"), C0), IGtQ($s("$base$"), C0), Less($s("base"), $s("$base$"))), CompoundExpression(Set($s("$base$"), $s("base")), Set($s("$expon$"), $s("expon")), Set($s("tmp"), Power($s("tmp"), -1)))), Set($s("$expon$"), Times($s("$expon$"), Power(Denominator($s("tmp")), -1))), If(And(Less($s("tmp"), C0), NegQ(Coefficient($s("$expon$"), x, C1))), CompoundExpression(Set($s("$expon$"), Negate($s("$expon$"))), True), True)))))))),
            ISetDelayed(391, FunctionOfTrigOfLinearQ(u_, x_Symbol),
                    If(MatchQ(u, Condition(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x)), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($p("§trig"), Plus(e_DEFAULT, Times(f_DEFAULT, x))))), n_DEFAULT)), And(FreeQ(List(a, b, c, d, e, f, m, n), x), Or(TrigQ($s("§trig")), HyperbolicQ($s("§trig")))))), True, And(Not(MemberQ(List(Null, False), FunctionOfTrig(u, Null, x))), AlgebraicTrigFunctionQ(u, x)))),
            ISetDelayed(392, FunctionOfTrig(u_, x_Symbol),
                    With(List(Set(v, FunctionOfTrig(ActivateTrig(u), Null, x))), If(SameQ(v, Null), False, v))),
            ISetDelayed(393, FunctionOfTrig(u_, v_, x_),
                    If(AtomQ(u), If(SameQ(u, x), False, v), If(And(TrigQ(u), LinearQ(Part(u, C1), x)), If(SameQ(v, Null), Part(u, C1), With(List(Set(a, Coefficient(v, x, C0)), Set(b, Coefficient(v, x, C1)), Set(c, Coefficient(Part(u, C1), x, C0)), Set(d, Coefficient(Part(u, C1), x, C1))), If(And(EqQ(Plus(Times(a, d), Times(CN1, b, c)), C0), RationalQ(Times(b, Power(d, -1)))), Plus(Times(a, Power(Numerator(Times(b, Power(d, -1))), -1)), Times(b, x, Power(Numerator(Times(b, Power(d, -1))), -1))), False))), If(And(HyperbolicQ(u), LinearQ(Part(u, C1), x)), If(SameQ(v, Null), Times(CI, Part(u, C1)), With(List(Set(a, Coefficient(v, x, C0)), Set(b, Coefficient(v, x, C1)), Set(c, Times(CI, Coefficient(Part(u, C1), x, C0))), Set(d, Times(CI, Coefficient(Part(u, C1), x, C1)))), If(And(EqQ(Plus(Times(a, d), Times(CN1, b, c)), C0), RationalQ(Times(b, Power(d, -1)))), Plus(Times(a, Power(Numerator(Times(b, Power(d, -1))), -1)), Times(b, x, Power(Numerator(Times(b, Power(d, -1))), -1))), False))), If(CalculusQ(u), False, Module(List(Set(w, v)), Catch(CompoundExpression(Scan(Function(If(FalseQ(Set(w, FunctionOfTrig(Slot1, w, x))), Throw(False))), u), w)))))))),
            ISetDelayed(394, AlgebraicTrigFunctionQ(u_, x_Symbol),
                    If(AtomQ(u), True, If(And(TrigQ(u), LinearQ(Part(u, C1), x)), True, If(And(HyperbolicQ(u), LinearQ(Part(u, C1), x)), True, If(And(PowerQ(u), FreeQ(Part(u, C2), x)), AlgebraicTrigFunctionQ(Part(u, C1), x), If(Or(ProductQ(u), SumQ(u)), Catch(CompoundExpression(Scan(Function(If(Not(AlgebraicTrigFunctionQ(Slot1, x)), Throw(False))), u), True)), False)))))),
            ISetDelayed(395, FunctionOfHyperbolic(u_, x_Symbol),
                    With(List(Set(v, FunctionOfHyperbolic(u, Null, x))), If(SameQ(v, Null), False, v))),
            ISetDelayed(396, FunctionOfHyperbolic(u_, v_, x_),
                    If(AtomQ(u), If(SameQ(u, x), False, v), If(And(HyperbolicQ(u), LinearQ(Part(u, C1), x)), If(SameQ(v, Null), Part(u, C1), With(List(Set(a, Coefficient(v, x, C0)), Set(b, Coefficient(v, x, C1)), Set(c, Coefficient(Part(u, C1), x, C0)), Set(d, Coefficient(Part(u, C1), x, C1))), If(And(EqQ(Plus(Times(a, d), Times(CN1, b, c)), C0), RationalQ(Times(b, Power(d, -1)))), Plus(Times(a, Power(Numerator(Times(b, Power(d, -1))), -1)), Times(b, x, Power(Numerator(Times(b, Power(d, -1))), -1))), False))), If(CalculusQ(u), False, Module(List(Set(w, v)), Catch(CompoundExpression(Scan(Function(If(FalseQ(Set(w, FunctionOfHyperbolic(Slot1, w, x))), Throw(False))), u), w))))))),
            ISetDelayed(397, FunctionOfQ(v_, u_, x_Symbol, Optional($p("§pureflag"), False)),
                    If(FreeQ(u, x), False, If(AtomQ(v), True, If(Not(InertTrigFreeQ(u)), FunctionOfQ(v, ActivateTrig(u), x, $s("§pureflag")), If(And(ProductQ(v), NeQ(FreeFactors(v, x), C1)), FunctionOfQ(NonfreeFactors(v, x), u, x, $s("§pureflag")), If($s("§pureflag"), Switch(Head(v), Sin, PureFunctionOfSinQ(u, Part(v, C1), x), Cos, PureFunctionOfCosQ(u, Part(v, C1), x), Tan, PureFunctionOfTanQ(u, Part(v, C1), x), Cot, PureFunctionOfCotQ(u, Part(v, C1), x), Sec, PureFunctionOfCosQ(u, Part(v, C1), x), Csc, PureFunctionOfSinQ(u, Part(v, C1), x), Sinh, PureFunctionOfSinhQ(u, Part(v, C1), x), Cosh, PureFunctionOfCoshQ(u, Part(v, C1), x), Tanh, PureFunctionOfTanhQ(u, Part(v, C1), x), Coth, PureFunctionOfCothQ(u, Part(v, C1), x), Sech, PureFunctionOfCoshQ(u, Part(v, C1), x), Csch, PureFunctionOfSinhQ(u, Part(v, C1), x), $b(), UnsameQ(FunctionOfExpnQ(u, v, x), False)), Switch(Head(v), Sin, FunctionOfSinQ(u, Part(v, C1), x), Cos, FunctionOfCosQ(u, Part(v, C1), x), Tan, FunctionOfTanQ(u, Part(v, C1), x), Cot, FunctionOfTanQ(u, Part(v, C1), x), Sec, FunctionOfCosQ(u, Part(v, C1), x), Csc, FunctionOfSinQ(u, Part(v, C1), x), Sinh, FunctionOfSinhQ(u, Part(v, C1), x), Cosh, FunctionOfCoshQ(u, Part(v, C1), x), Tanh, FunctionOfTanhQ(u, Part(v, C1), x), Coth, FunctionOfTanhQ(u, Part(v, C1), x), Sech, FunctionOfCoshQ(u, Part(v, C1), x), Csch, FunctionOfSinhQ(u, Part(v, C1), x), $b(), UnsameQ(FunctionOfExpnQ(u, v, x), False)))))))),
            ISetDelayed(398, FunctionOfExpnQ(u_, v_, x_),
                    If(SameQ(u, v), C1, If(AtomQ(u), If(SameQ(u, x), False, C0), If(CalculusQ(u), False, If(And(PowerQ(u), FreeQ(Part(u, C2), x)), If(EqQ(Part(u, C1), v), If(IntegerQ(Part(u, C2)), Part(u, C2), C1), If(And(PowerQ(v), FreeQ(Part(v, C2), x), EqQ(Part(u, C1), Part(v, C1))), If(RationalQ(Part(v, C2)), If(And(RationalQ(Part(u, C2)), IntegerQ(Times(Part(u, C2), Power(Part(v, C2), -1))), Or(Greater(Part(v, C2), C0), Less(Part(u, C2), C0))), Times(Part(u, C2), Power(Part(v, C2), -1)), False), If(IntegerQ(Simplify(Times(Part(u, C2), Power(Part(v, C2), -1)))), Simplify(Times(Part(u, C2), Power(Part(v, C2), -1))), False)), FunctionOfExpnQ(Part(u, C1), v, x))), If(And(ProductQ(u), NeQ(FreeFactors(u, x), C1)), FunctionOfExpnQ(NonfreeFactors(u, x), v, x), If(And(ProductQ(u), ProductQ(v)), Module(List(Set($s("deg1"), FunctionOfExpnQ(First(u), First(v), x)), $s("deg2")), If(SameQ($s("deg1"), False), False, CompoundExpression(Set($s("deg2"), FunctionOfExpnQ(Rest(u), Rest(v), x)), If(And(SameQ($s("deg1"), $s("deg2")), FreeQ(Simplify(Times(u, Power(Power(v, $s("deg1")), -1))), x)), $s("deg1"), False)))), With(List(Set($s("lst"), Map(Function(FunctionOfExpnQ(Slot1, v, x)), Apply(List, u)))), If(MemberQ($s("lst"), False), False, Apply(GCD, $s("lst"))))))))))),
            ISetDelayed(399, PureFunctionOfSinQ(u_, v_, x_),
                    If(AtomQ(u), UnsameQ(u, x), If(CalculusQ(u), False, If(And(TrigQ(u), EqQ(Part(u, C1), v)), Or(SameQ(Head(u), Sin), SameQ(Head(u), Csc)), Catch(CompoundExpression(Scan(Function(If(Not(PureFunctionOfSinQ(Slot1, v, x)), Throw(False))), u), True)))))),
            ISetDelayed(400, PureFunctionOfCosQ(u_, v_, x_),
                    If(AtomQ(u), UnsameQ(u, x), If(CalculusQ(u), False, If(And(TrigQ(u), EqQ(Part(u, C1), v)), Or(SameQ(Head(u), Cos), SameQ(Head(u), Sec)), Catch(CompoundExpression(Scan(Function(If(Not(PureFunctionOfCosQ(Slot1, v, x)), Throw(False))), u), True)))))),
            ISetDelayed(401, PureFunctionOfTanQ(u_, v_, x_),
                    If(AtomQ(u), UnsameQ(u, x), If(CalculusQ(u), False, If(And(TrigQ(u), EqQ(Part(u, C1), v)), Or(SameQ(Head(u), Tan), SameQ(Head(u), Cot)), Catch(CompoundExpression(Scan(Function(If(Not(PureFunctionOfTanQ(Slot1, v, x)), Throw(False))), u), True)))))),
            ISetDelayed(402, PureFunctionOfCotQ(u_, v_, x_),
                    If(AtomQ(u), UnsameQ(u, x), If(CalculusQ(u), False, If(And(TrigQ(u), EqQ(Part(u, C1), v)), SameQ(Head(u), Cot), Catch(CompoundExpression(Scan(Function(If(Not(PureFunctionOfCotQ(Slot1, v, x)), Throw(False))), u), True)))))),
            ISetDelayed(403, FunctionOfSinQ(u_, v_, x_),
                    If(AtomQ(u), UnsameQ(u, x), If(CalculusQ(u), False, If(And(TrigQ(u), IntegerQuotientQ(Part(u, C1), v)), If(OddQuotientQ(Part(u, C1), v), Or(SameQ(Head(u), Sin), SameQ(Head(u), Csc)), Or(SameQ(Head(u), Cos), SameQ(Head(u), Sec))), If(And(IntegerPowerQ(u), TrigQ(Part(u, C1)), IntegerQuotientQ(Part(u, C1, C1), v)), If(EvenQ(Part(u, C2)), True, FunctionOfSinQ(Part(u, C1), v, x)), If(ProductQ(u), If(And(SameQ(Head(Part(u, C1)), Cos), SameQ(Head(Part(u, C2)), Sin), EqQ(Part(u, C1, C1), Times(C1D2, v)), EqQ(Part(u, C2, C1), Times(C1D2, v))), FunctionOfSinQ(Drop(u, C2), v, x), Module(List($s("lst")), CompoundExpression(Set($s("lst"), FindTrigFactor(Sin, Csc, u, v, False)), If(And(ListQ($s("lst")), EvenQuotientQ(Part($s("lst"), C1), v)), FunctionOfSinQ(Times(Cos(v), Part($s("lst"), C2)), v, x), CompoundExpression(Set($s("lst"), FindTrigFactor(Cos, Sec, u, v, False)), If(And(ListQ($s("lst")), OddQuotientQ(Part($s("lst"), C1), v)), FunctionOfSinQ(Times(Cos(v), Part($s("lst"), C2)), v, x), CompoundExpression(Set($s("lst"), FindTrigFactor(Tan, Cot, u, v, True)), If(ListQ($s("lst")), FunctionOfSinQ(Times(Cos(v), Part($s("lst"), C2)), v, x), Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfSinQ(Slot1, v, x)), Throw(False))), u), True)))))))))), Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfSinQ(Slot1, v, x)), Throw(False))), u), True)))))))),
            ISetDelayed(404, FunctionOfCosQ(u_, v_, x_),
                    If(AtomQ(u), UnsameQ(u, x), If(CalculusQ(u), False, If(And(TrigQ(u), IntegerQuotientQ(Part(u, C1), v)), Or(SameQ(Head(u), Cos), SameQ(Head(u), Sec)), If(And(IntegerPowerQ(u), TrigQ(Part(u, C1)), IntegerQuotientQ(Part(u, C1, C1), v)), If(EvenQ(Part(u, C2)), True, FunctionOfCosQ(Part(u, C1), v, x)), If(ProductQ(u), Module(List($s("lst")), CompoundExpression(Set($s("lst"), FindTrigFactor(Sin, Csc, u, v, False)), If(ListQ($s("lst")), FunctionOfCosQ(Times(Sin(v), Part($s("lst"), C2)), v, x), CompoundExpression(Set($s("lst"), FindTrigFactor(Tan, Cot, u, v, True)), If(ListQ($s("lst")), FunctionOfCosQ(Times(Sin(v), Part($s("lst"), C2)), v, x), Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfCosQ(Slot1, v, x)), Throw(False))), u), True))))))), Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfCosQ(Slot1, v, x)), Throw(False))), u), True)))))))),
            ISetDelayed(405, FunctionOfTanQ(u_, v_, x_),
                    If(AtomQ(u), UnsameQ(u, x), If(CalculusQ(u), False, If(And(TrigQ(u), IntegerQuotientQ(Part(u, C1), v)), Or(SameQ(Head(u), Tan), SameQ(Head(u), Cot), EvenQuotientQ(Part(u, C1), v)), If(And(PowerQ(u), EvenQ(Part(u, C2)), TrigQ(Part(u, C1)), IntegerQuotientQ(Part(u, C1, C1), v)), True, If(And(PowerQ(u), EvenQ(Part(u, C2)), SumQ(Part(u, C1))), FunctionOfTanQ(Expand(Sqr(Part(u, C1))), v, x), If(ProductQ(u), Module(List(Set($s("lst"), ReapList(Scan(Function(If(Not(FunctionOfTanQ(Slot1, v, x)), Sow(Slot1))), u)))), If(SameQ($s("lst"), List()), True, And(Equal(Length($s("lst")), C2), OddTrigPowerQ(Part($s("lst"), C1), v, x), OddTrigPowerQ(Part($s("lst"), C2), v, x)))), Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfTanQ(Slot1, v, x)), Throw(False))), u), True))))))))),
            ISetDelayed(406, OddTrigPowerQ(u_, v_, x_),
                    If(MemberQ(List(Sin, Cos, Sec, Csc), Head(u)), OddQuotientQ(Part(u, C1), v), If(PowerQ(u), And(OddQ(Part(u, C2)), OddTrigPowerQ(Part(u, C1), v, x)), If(ProductQ(u), If(NeQ(FreeFactors(u, x), C1), OddTrigPowerQ(NonfreeFactors(u, x), v, x), Module(List(Set($s("lst"), ReapList(Scan(Function(If(Not(FunctionOfTanQ(Slot1, v, x)), Sow(Slot1))), u)))), If(SameQ($s("lst"), List()), True, And(Equal(Length($s("lst")), C1), OddTrigPowerQ(Part($s("lst"), C1), v, x))))), If(SumQ(u), Catch(CompoundExpression(Scan(Function(If(Not(OddTrigPowerQ(Slot1, v, x)), Throw(False))), u), True)), False))))),
            ISetDelayed(407, FunctionOfTanWeight(u_, v_, x_),
                    If(AtomQ(u), C0, If(CalculusQ(u), C0, If(And(TrigQ(u), IntegerQuotientQ(Part(u, C1), v)), If(And(SameQ(Head(u), Tan), EqQ(Part(u, C1), v)), C1, If(And(SameQ(Head(u), Cot), EqQ(Part(u, C1), v)), CN1, C0)), If(And(PowerQ(u), EvenQ(Part(u, C2)), TrigQ(Part(u, C1)), IntegerQuotientQ(Part(u, C1, C1), v)), If(Or(SameQ(Head(Part(u, C1)), Tan), SameQ(Head(Part(u, C1)), Cos), SameQ(Head(Part(u, C1)), Sec)), C1, CN1), If(ProductQ(u), If(Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfTanQ(Slot1, v, x)), Throw(False))), u), True)), Apply(Plus, Map(Function(FunctionOfTanWeight(Slot1, v, x)), Apply(List, u))), C0), Apply(Plus, Map(Function(FunctionOfTanWeight(Slot1, v, x)), Apply(List, u))))))))),
            ISetDelayed(408, FunctionOfTrigQ(u_, v_, x_Symbol),
                    If(AtomQ(u), UnsameQ(u, x), If(CalculusQ(u), False, If(And(TrigQ(u), IntegerQuotientQ(Part(u, C1), v)), True, Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfTrigQ(Slot1, v, x)), Throw(False))), u), True)))))),
            ISetDelayed(409, PureFunctionOfSinhQ(u_, v_, x_),
                    If(AtomQ(u), UnsameQ(u, x), If(CalculusQ(u), False, If(And(HyperbolicQ(u), EqQ(Part(u, C1), v)), Or(SameQ(Head(u), Sinh), SameQ(Head(u), Csch)), Catch(CompoundExpression(Scan(Function(If(Not(PureFunctionOfSinhQ(Slot1, v, x)), Throw(False))), u), True)))))),
            ISetDelayed(410, PureFunctionOfCoshQ(u_, v_, x_),
                    If(AtomQ(u), UnsameQ(u, x), If(CalculusQ(u), False, If(And(HyperbolicQ(u), EqQ(Part(u, C1), v)), Or(SameQ(Head(u), Cosh), SameQ(Head(u), Sech)), Catch(CompoundExpression(Scan(Function(If(Not(PureFunctionOfCoshQ(Slot1, v, x)), Throw(False))), u), True)))))),
            ISetDelayed(411, PureFunctionOfTanhQ(u_, v_, x_),
                    If(AtomQ(u), UnsameQ(u, x), If(CalculusQ(u), False, If(And(HyperbolicQ(u), EqQ(Part(u, C1), v)), Or(SameQ(Head(u), Tanh), SameQ(Head(u), Coth)), Catch(CompoundExpression(Scan(Function(If(Not(PureFunctionOfTanhQ(Slot1, v, x)), Throw(False))), u), True)))))),
            ISetDelayed(412, PureFunctionOfCothQ(u_, v_, x_),
                    If(AtomQ(u), UnsameQ(u, x), If(CalculusQ(u), False, If(And(HyperbolicQ(u), EqQ(Part(u, C1), v)), SameQ(Head(u), Coth), Catch(CompoundExpression(Scan(Function(If(Not(PureFunctionOfCothQ(Slot1, v, x)), Throw(False))), u), True)))))),
            ISetDelayed(413, FunctionOfSinhQ(u_, v_, x_),
                    If(AtomQ(u), UnsameQ(u, x), If(CalculusQ(u), False, If(And(HyperbolicQ(u), IntegerQuotientQ(Part(u, C1), v)), If(OddQuotientQ(Part(u, C1), v), Or(SameQ(Head(u), Sinh), SameQ(Head(u), Csch)), Or(SameQ(Head(u), Cosh), SameQ(Head(u), Sech))), If(And(IntegerPowerQ(u), HyperbolicQ(Part(u, C1)), IntegerQuotientQ(Part(u, C1, C1), v)), If(EvenQ(Part(u, C2)), True, FunctionOfSinhQ(Part(u, C1), v, x)), If(ProductQ(u), If(And(SameQ(Head(Part(u, C1)), Cosh), SameQ(Head(Part(u, C2)), Sinh), EqQ(Part(u, C1, C1), Times(C1D2, v)), EqQ(Part(u, C2, C1), Times(C1D2, v))), FunctionOfSinhQ(Drop(u, C2), v, x), Module(List($s("lst")), CompoundExpression(Set($s("lst"), FindTrigFactor(Sinh, Csch, u, v, False)), If(And(ListQ($s("lst")), EvenQuotientQ(Part($s("lst"), C1), v)), FunctionOfSinhQ(Times(Cosh(v), Part($s("lst"), C2)), v, x), CompoundExpression(Set($s("lst"), FindTrigFactor(Cosh, Sech, u, v, False)), If(And(ListQ($s("lst")), OddQuotientQ(Part($s("lst"), C1), v)), FunctionOfSinhQ(Times(Cosh(v), Part($s("lst"), C2)), v, x), CompoundExpression(Set($s("lst"), FindTrigFactor(Tanh, Coth, u, v, True)), If(ListQ($s("lst")), FunctionOfSinhQ(Times(Cosh(v), Part($s("lst"), C2)), v, x), Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfSinhQ(Slot1, v, x)), Throw(False))), u), True)))))))))), Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfSinhQ(Slot1, v, x)), Throw(False))), u), True)))))))),
            ISetDelayed(414, FunctionOfCoshQ(u_, v_, x_),
                    If(AtomQ(u), UnsameQ(u, x), If(CalculusQ(u), False, If(And(HyperbolicQ(u), IntegerQuotientQ(Part(u, C1), v)), Or(SameQ(Head(u), Cosh), SameQ(Head(u), Sech)), If(And(IntegerPowerQ(u), HyperbolicQ(Part(u, C1)), IntegerQuotientQ(Part(u, C1, C1), v)), If(EvenQ(Part(u, C2)), True, FunctionOfCoshQ(Part(u, C1), v, x)), If(ProductQ(u), Module(List($s("lst")), CompoundExpression(Set($s("lst"), FindTrigFactor(Sinh, Csch, u, v, False)), If(ListQ($s("lst")), FunctionOfCoshQ(Times(Sinh(v), Part($s("lst"), C2)), v, x), CompoundExpression(Set($s("lst"), FindTrigFactor(Tanh, Coth, u, v, True)), If(ListQ($s("lst")), FunctionOfCoshQ(Times(Sinh(v), Part($s("lst"), C2)), v, x), Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfCoshQ(Slot1, v, x)), Throw(False))), u), True))))))), Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfCoshQ(Slot1, v, x)), Throw(False))), u), True)))))))),
            ISetDelayed(415, FunctionOfTanhQ(u_, v_, x_),
                    If(AtomQ(u), UnsameQ(u, x), If(CalculusQ(u), False, If(And(HyperbolicQ(u), IntegerQuotientQ(Part(u, C1), v)), Or(SameQ(Head(u), Tanh), SameQ(Head(u), Coth), EvenQuotientQ(Part(u, C1), v)), If(And(PowerQ(u), EvenQ(Part(u, C2)), HyperbolicQ(Part(u, C1)), IntegerQuotientQ(Part(u, C1, C1), v)), True, If(And(PowerQ(u), EvenQ(Part(u, C2)), SumQ(Part(u, C1))), FunctionOfTanhQ(Expand(Sqr(Part(u, C1))), v, x), If(ProductQ(u), With(List(Set($s("lst"), ReapList(Scan(Function(If(Not(FunctionOfTanhQ(Slot1, v, x)), Sow(Slot1))), u)))), If(SameQ($s("lst"), List()), True, And(Equal(Length($s("lst")), C2), OddHyperbolicPowerQ(Part($s("lst"), C1), v, x), OddHyperbolicPowerQ(Part($s("lst"), C2), v, x)))), Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfTanhQ(Slot1, v, x)), Throw(False))), u), True))))))))),
            ISetDelayed(416, OddHyperbolicPowerQ(u_, v_, x_),
                    If(MemberQ(List(Sinh, Cosh, Sech, Csch), Head(u)), OddQuotientQ(Part(u, C1), v), If(PowerQ(u), And(OddQ(Part(u, C2)), OddHyperbolicPowerQ(Part(u, C1), v, x)), If(ProductQ(u), If(NeQ(FreeFactors(u, x), C1), OddHyperbolicPowerQ(NonfreeFactors(u, x), v, x), With(List(Set($s("lst"), ReapList(Scan(Function(If(Not(FunctionOfTanhQ(Slot1, v, x)), Sow(Slot1))), u)))), If(SameQ($s("lst"), List()), True, And(Equal(Length($s("lst")), C1), OddHyperbolicPowerQ(Part($s("lst"), C1), v, x))))), If(SumQ(u), Catch(CompoundExpression(Scan(Function(If(Not(OddHyperbolicPowerQ(Slot1, v, x)), Throw(False))), u), True)), False))))),
            ISetDelayed(417, FunctionOfTanhWeight(u_, v_, x_),
                    If(AtomQ(u), C0, If(CalculusQ(u), C0, If(And(HyperbolicQ(u), IntegerQuotientQ(Part(u, C1), v)), If(And(SameQ(Head(u), Tanh), EqQ(Part(u, C1), v)), C1, If(And(SameQ(Head(u), Coth), EqQ(Part(u, C1), v)), CN1, C0)), If(And(PowerQ(u), EvenQ(Part(u, C2)), HyperbolicQ(Part(u, C1)), IntegerQuotientQ(Part(u, C1, C1), v)), If(Or(SameQ(Head(Part(u, C1)), Tanh), SameQ(Head(Part(u, C1)), Cosh), SameQ(Head(Part(u, C1)), Sech)), C1, CN1), If(ProductQ(u), If(Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfTanhQ(Slot1, v, x)), Throw(False))), u), True)), Apply(Plus, Map(Function(FunctionOfTanhWeight(Slot1, v, x)), Apply(List, u))), C0), Apply(Plus, Map(Function(FunctionOfTanhWeight(Slot1, v, x)), Apply(List, u))))))))),
            ISetDelayed(418, FunctionOfHyperbolicQ(u_, v_, x_Symbol),
                    If(AtomQ(u), UnsameQ(u, x), If(CalculusQ(u), False, If(And(HyperbolicQ(u), IntegerQuotientQ(Part(u, C1), v)), True, Catch(CompoundExpression(Scan(Function(If(FunctionOfHyperbolicQ(Slot1, v, x), Null, Throw(False))), u), True)))))),
            ISetDelayed(419, FindTrigFactor($p("func1"), $p("func2"), u_, v_, $p("flag")),
                    If(SameQ(u, C1), False, If(And(Or(SameQ(Head(LeadBase(u)), $s("func1")), SameQ(Head(LeadBase(u)), $s("func2"))), OddQ(LeadDegree(u)), IntegerQuotientQ(Part(LeadBase(u), C1), v), Or($s("flag"), NeQ(Part(LeadBase(u), C1), v))), List(Part(LeadBase(u), C1), RemainingFactors(u)), With(List(Set($s("lst"), FindTrigFactor($s("func1"), $s("func2"), RemainingFactors(u), v, $s("flag")))), If(AtomQ($s("lst")), False, List(Part($s("lst"), C1), Times(LeadFactor(u), Part($s("lst"), C2)))))))),
            ISetDelayed(420, IntegerQuotientQ(u_, v_),
                    IntegerQ(Simplify(Times(u, Power(v, -1))))),
            ISetDelayed(421, OddQuotientQ(u_, v_),
                    OddQ(Simplify(Times(u, Power(v, -1))))),
            ISetDelayed(422, EvenQuotientQ(u_, v_),
                    EvenQ(Simplify(Times(u, Power(v, -1))))),
            ISetDelayed(423, FunctionOfDensePolynomialsQ(u_, x_Symbol),
                    If(FreeQ(u, x), True, If(PolynomialQ(u, x), Greater(Length(Exponent(u, x, List)), C1), Catch(CompoundExpression(Scan(Function(If(FunctionOfDensePolynomialsQ(Slot1, x), Null, Throw(False))), u), True))))),
            ISetDelayed(424, FunctionOfLog(u_, x_Symbol),
                    With(List(Set($s("lst"), FunctionOfLog(u, False, False, x))), If(Or(AtomQ($s("lst")), FalseQ(Part($s("lst"), C2))), False, $s("lst")))),
            ISetDelayed(425, FunctionOfLog(u_, v_, n_, x_),
                    If(AtomQ(u), If(SameQ(u, x), False, List(u, v, n)), If(CalculusQ(u), False, Module(List($s("lst")), If(And(LogQ(u), ListQ(Set($s("lst"), BinomialParts(Part(u, C1), x))), EqQ(Part($s("lst"), C1), C0)), If(Or(FalseQ(v), SameQ(Part(u, C1), v)), List(x, Part(u, C1), Part($s("lst"), C3)), False), CompoundExpression(Set($s("lst"), List(C0, v, n)), Catch(List(Map(Function(CompoundExpression(Set($s("lst"), FunctionOfLog(Slot1, Part($s("lst"), C2), Part($s("lst"), C3), x)), If(AtomQ($s("lst")), Throw(False), Part($s("lst"), C1)))), u), Part($s("lst"), C2), Part($s("lst"), C3))))))))),
            ISetDelayed(426, PowerVariableExpn(u_, m_, x_Symbol),
                    If(IntegerQ(m), With(List(Set($s("lst"), PowerVariableDegree(u, m, C1, x))), If(AtomQ($s("lst")), False, List(Times(Power(x, Times(m, Power(Part($s("lst"), C1), -1))), PowerVariableSubst(u, Part($s("lst"), C1), x)), Part($s("lst"), C1), Part($s("lst"), C2)))), False)),
            ISetDelayed(427, PowerVariableDegree(u_, m_, c_, x_Symbol),
                    If(FreeQ(u, x), List(m, c), If(Or(AtomQ(u), CalculusQ(u)), False, If(And(PowerQ(u), FreeQ(Times(Part(u, C1), Power(x, -1)), x)), If(Or(EqQ(m, C0), And(SameQ(m, Part(u, C2)), SameQ(c, Times(Part(u, C1), Power(x, -1))))), List(Part(u, C2), Times(Part(u, C1), Power(x, -1))), If(And(IntegerQ(Part(u, C2)), IntegerQ(m), Greater(GCD(m, Part(u, C2)), C1), SameQ(c, Times(Part(u, C1), Power(x, -1)))), List(GCD(m, Part(u, C2)), c), False)), Catch(Module(List(Set($s("lst"), List(m, c))), CompoundExpression(Scan(Function(CompoundExpression(Set($s("lst"), PowerVariableDegree(Slot1, Part($s("lst"), C1), Part($s("lst"), C2), x)), If(AtomQ($s("lst")), Throw(False)))), u), $s("lst")))))))),
            ISetDelayed(428, PowerVariableSubst(u_, m_, x_Symbol),
                    If(Or(FreeQ(u, x), AtomQ(u), CalculusQ(u)), u, If(And(PowerQ(u), FreeQ(Times(Part(u, C1), Power(x, -1)), x)), Power(x, Times(Part(u, C2), Power(m, -1))), Map(Function(PowerVariableSubst(Slot1, m, x)), u)))),
            ISetDelayed(429, EulerIntegrandQ(Power(Plus(Times(b_DEFAULT, Power(u_, n_)), Times(a_DEFAULT, x_)), p_), x_Symbol),
                    Condition(True, And(FreeQ(List(a, b), x), IntegerQ(Plus(n, C1D2)), QuadraticQ(u, x), Or(Not(RationalQ(p)), And(ILtQ(p, C0), Not(BinomialQ(u, x))))))),
            ISetDelayed(430, EulerIntegrandQ(Times(Power(v_, m_DEFAULT), Power(Plus(Times(b_DEFAULT, Power(u_, n_)), Times(a_DEFAULT, x_)), p_)), x_Symbol),
                    Condition(True, And(FreeQ(List(a, b), x), EqQ(u, v), IntegersQ(Times(C2, m), Plus(n, C1D2)), QuadraticQ(u, x), Or(Not(RationalQ(p)), And(ILtQ(p, C0), Not(BinomialQ(u, x))))))),
            ISetDelayed(431, EulerIntegrandQ(Times(Power(v_, m_DEFAULT), Power(Plus(Times(b_DEFAULT, Power(u_, n_)), Times(a_DEFAULT, x_)), p_)), x_Symbol),
                    Condition(True, And(FreeQ(List(a, b), x), EqQ(u, v), IntegersQ(Times(C2, m), Plus(n, C1D2)), QuadraticQ(u, x), Or(Not(RationalQ(p)), And(ILtQ(p, C0), Not(BinomialQ(u, x))))))),
            ISetDelayed(432, EulerIntegrandQ(Times(Power(u_, n_), Power(v_, p_)), x_Symbol),
                    Condition(True, And(ILtQ(p, C0), IntegerQ(Plus(n, C1D2)), QuadraticQ(u, x), QuadraticQ(v, x), Not(BinomialQ(v, x))))),
            ISetDelayed(433, EulerIntegrandQ(u_, x_Symbol),
                    False),
            ISetDelayed(434, FunctionOfSquareRootOfQuadratic(u_, x_Symbol),
                    If(MatchQ(u, Condition(Times(Power(x, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x, n_DEFAULT))), p_)), FreeQ(List(a, b, m, n, p), x))), False, Module(List(Set($s("tmp"), FunctionOfSquareRootOfQuadratic(u, False, x))), If(Or(AtomQ($s("tmp")), FalseQ(Part($s("tmp"), C1))), False, CompoundExpression(Set($s("tmp"), Part($s("tmp"), C1)), Module(List(Set(a, Coefficient($s("tmp"), x, C0)), Set(b, Coefficient($s("tmp"), x, C1)), Set(c, Coefficient($s("tmp"), x, C2)), $s("§sqrt"), q, r), If(Or(And(EqQ(a, C0), EqQ(b, C0)), EqQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0)), False, If(PosQ(c), CompoundExpression(Set($s("§sqrt"), Rt(c, C2)), Set(q, Plus(Times(a, $s("§sqrt")), Times(b, x), Times($s("§sqrt"), Sqr(x)))), Set(r, Plus(b, Times(C2, $s("§sqrt"), x))), List(Simplify(Times(SquareRootOfQuadraticSubst(u, Times(q, Power(r, -1)), Times(Plus(Negate(a), Sqr(x)), Power(r, -1)), x), q, Power(r, -2))), Simplify(Plus(Times($s("§sqrt"), x), Sqrt($s("tmp")))), C2)), If(PosQ(a), CompoundExpression(Set($s("§sqrt"), Rt(a, C2)), Set(q, Plus(Times(c, $s("§sqrt")), Times(CN1, b, x), Times($s("§sqrt"), Sqr(x)))), Set(r, Plus(c, Negate(Sqr(x)))), List(Simplify(Times(SquareRootOfQuadraticSubst(u, Times(q, Power(r, -1)), Times(Plus(Negate(b), Times(C2, $s("§sqrt"), x)), Power(r, -1)), x), q, Power(r, -2))), Simplify(Times(Plus(Negate($s("§sqrt")), Sqrt($s("tmp"))), Power(x, -1))), C1)), CompoundExpression(Set($s("§sqrt"), Rt(Plus(Sqr(b), Times(CN1, C4, a, c)), C2)), Set(r, Plus(c, Negate(Sqr(x)))), List(Simplify(Times(CN1, $s("§sqrt"), SquareRootOfQuadraticSubst(u, Times(CN1, $s("§sqrt"), x, Power(r, -1)), Times(CN1, Plus(Times(b, c), Times(c, $s("§sqrt")), Times(Plus(Negate(b), $s("§sqrt")), Sqr(x))), Power(Times(C2, c, r), -1)), x), x, Power(r, -2))), FullSimplify(Times(C2, c, Sqrt($s("tmp")), Power(Plus(b, Negate($s("§sqrt")), Times(C2, c, x)), -1))), C3))))))))))),
            ISetDelayed(435, FunctionOfSquareRootOfQuadratic(u_, v_, x_Symbol),
                    If(Or(AtomQ(u), FreeQ(u, x)), List(v), If(And(PowerQ(u), FreeQ(Part(u, C2), x)), If(And(FractionQ(Part(u, C2)), Equal(Denominator(Part(u, C2)), C2), PolynomialQ(Part(u, C1), x), Equal(Exponent(Part(u, C1), x), C2)), If(Or(FalseQ(v), SameQ(Part(u, C1), v)), List(Part(u, C1)), False), FunctionOfSquareRootOfQuadratic(Part(u, C1), v, x)), If(Or(ProductQ(u), SumQ(u)), Catch(Module(List(Set($s("lst"), List(v))), CompoundExpression(Scan(Function(CompoundExpression(Set($s("lst"), FunctionOfSquareRootOfQuadratic(Slot1, Part($s("lst"), C1), x)), If(AtomQ($s("lst")), Throw(False)))), u), $s("lst")))), False)))),
            ISetDelayed(436, SquareRootOfQuadraticSubst(u_, $p("vv"), $p("xx"), x_Symbol),
                    If(Or(AtomQ(u), FreeQ(u, x)), If(SameQ(u, x), $s("xx"), u), If(And(PowerQ(u), FreeQ(Part(u, C2), x)), If(And(FractionQ(Part(u, C2)), Equal(Denominator(Part(u, C2)), C2), PolynomialQ(Part(u, C1), x), Equal(Exponent(Part(u, C1), x), C2)), Power($s("vv"), Numerator(Part(u, C2))), Power(SquareRootOfQuadraticSubst(Part(u, C1), $s("vv"), $s("xx"), x), Part(u, C2))), Map(Function(SquareRootOfQuadraticSubst(Slot1, $s("vv"), $s("xx"), x)), u)))),
            ISetDelayed(437, Subst(u_, x_Symbol, v_),
                    If(And(PowerQ(v), Not(IntegerQ(Part(v, C2))), MatchQ(Part(v, C1), Condition(Plus(a_, Times(b_DEFAULT, x), Times(c_DEFAULT, Sqr(x))), And(FreeQ(List(a, b, c), x), Not(AtomQ(b))))), Less(LeafCount(Simplify(Part(v, C1))), Times(QQ(2L, 3L), LeafCount(Part(v, C1))))), Subst(u, x, Power(Simplify(Part(v, C1)), Part(v, C2))), If(SumQ(u), If(BinomialQ(v, x), SimplifyAntiderivative(Map(Function(SubstAux(Slot1, x, v, True)), u), x), SimplifyAntiderivative(Map(Function(SubstAux(Slot1, x, v, False)), u), x)), SimplifyAntiderivative(SubstAux(u, x, v, BinomialQ(v, x)), x)))),
            ISetDelayed(438, Subst(u_, Rule(x_Symbol, v_)),
                    Subst(u, x, v)),
            ISetDelayed(439, Subst(u_, Power(Times(a_DEFAULT, x_), n_), v_),
                    Condition(If(AtomQ(u), u, If(And(RationalQ(n), Unequal(Numerator(n), C1)), Subst(u, Power(Times(a, x), Power(Denominator(n), -1)), Times(v, Power(Power(Times(a, x), Plus(n, Negate(Power(Denominator(n), -1)))), -1))), If(And(PowerQ(u), FreeQ(Part(u, C2), x), SameQ(Part(u, C1), Times(a, x))), If(IntegerQ(Times(Part(u, C2), Power(n, -1))), Simplify(Power(v, Times(Part(u, C2), Power(n, -1)))), If(SumQ(Part(u, C2)), Apply(Times, Map(Function(Subst(Power(Part(u, C1), Slot1), Power(Times(a, x), n), v)), Apply(List, Part(u, C2)))), With(List(Set(w, Expand(Part(u, C2)))), If(SumQ(w), Apply(Times, Map(Function(Subst(Power(Part(u, C1), Slot1), Power(Times(a, x), n), v)), Apply(List, w))), With(List(Set(m, NumericFactor(Part(u, C2)))), If(Unequal(Numerator(m), C1), Power(Subst(Power(Part(u, C1), Times(m, Power(Numerator(m), -1), NonnumericFactors(Part(u, C2)))), Power(Times(a, x), n), v), Numerator(m)), Power(Subst(Part(u, C1), Power(Times(a, x), n), v), Part(u, C2)))))))), If(Or(And(CalculusQ(u), Not(FreeQ(x, Part(u, C2)))), And(HeldFormQ(u), UnsameQ(Head(u), Defer(AppellF1)))), $(Defer($rubi("Subst")), u, Power(Times(a, x), n), v), Map(Function(Subst(Slot1, Power(Times(a, x), n), v)), u))))), FreeQ(List(a, n), x))),
            ISetDelayed(440, Subst(u_, v_, w_),
                    If(SameQ(u, v), w, If(AtomQ(u), u, If(Or(And(CalculusQ(u), Not(FreeQ(v, Part(u, C2)))), And(HeldFormQ(u), UnsameQ(Head(u), Defer(AppellF1)))), $(Defer($rubi("Subst")), u, v, w), Map(Function(Subst(Slot1, v, w)), u))))),
            ISetDelayed(441, SubstAux(Plus(a_, Times(b_DEFAULT, x_)), x_, Times(c_DEFAULT, Sqr($(F_, z_))), False),
                    Condition(Times(a, Simplify(Plus(C1, Negate(Sqr(F(z)))))), And(FreeQ(List(a, b, c), x), MemberQ(List(Sin, Cos, Sec, Csc, Cosh, Tanh, Coth, Sech), FSymbol), EqQ(Plus(a, Times(b, c)), C0)))),
            ISetDelayed(442, SubstAux(Plus(a_, Times(b_DEFAULT, x_)), x_, Times(c_DEFAULT, Sqr($(F_, z_))), False),
                    Condition(Times(a, Simplify(Plus(C1, Sqr(F(z))))), And(FreeQ(List(a, b, c), x), MemberQ(List(Tan, Cot, Sinh, Csch), FSymbol), EqQ(Plus(a, Times(CN1, b, c)), C0)))),
            ISetDelayed(443, SubstAux(Plus(a_, Times(b_DEFAULT, Sqr(x_))), x_, Times(c_DEFAULT, $(F_, z_)), False),
                    Condition(Times(a, Simplify(Plus(C1, Negate(Sqr(F(z)))))), And(FreeQ(List(a, b, c), x), MemberQ(List(Sin, Cos, Sec, Csc, Cosh, Tanh, Coth, Sech), FSymbol), EqQ(Plus(a, Times(b, Sqr(c))), C0)))),
            ISetDelayed(444, SubstAux(Plus(a_, Times(b_DEFAULT, Sqr(x_))), x_, Times(c_DEFAULT, $(F_, z_)), False),
                    Condition(Times(a, Simplify(Plus(C1, Sqr(F(z))))), And(FreeQ(List(a, b, c), x), MemberQ(List(Tan, Cot, Sinh, Csch), FSymbol), EqQ(Plus(a, Times(CN1, b, Sqr(c))), C0)))),
            ISetDelayed(445, SubstAux($(F_, Times(a_DEFAULT, Power(x_, m_DEFAULT))), x_, Times(b_DEFAULT, Power(x_, n_)), $p("flag")),
                    Condition($(Switch(FSymbol, ArcSin, ArcCsc, ArcCos, ArcSec, ArcTan, ArcCot, ArcCot, ArcTan, ArcSec, ArcCos, ArcCsc, ArcSin, ArcSinh, ArcCsch, ArcCosh, ArcSech, ArcTanh, ArcCoth, ArcCoth, ArcTanh, ArcSech, ArcCosh, ArcCsch, ArcSinh), Times(Power(x, Times(CN1, m, n)), Power(Times(a, Power(b, m)), -1))), And(FreeQ(List(a, b), x), IGtQ(m, C0), ILtQ(n, C0), MemberQ(List(ArcSin, ArcCos, ArcTan, ArcCot, ArcSec, ArcCsc, ArcSinh, ArcCosh, ArcTanh, ArcCoth, ArcSech, ArcCsch), FSymbol)))),
            ISetDelayed(446, SubstAux(u_, x_, v_, $p("flag")),
                    If(AtomQ(u), If(SameQ(u, x), v, u), If(FreeQ(u, x), u, If(And($s("flag"), PowerQ(u)), If(And(Not(IntegerQ(Part(u, C2))), LinearQ(Part(u, C1), x)), Power(Simplify(SubstAux(Part(u, C1), x, v, $s("flag"))), SubstAux(Part(u, C2), x, v, $s("flag"))), Power(SubstAux(Part(u, C1), x, v, $s("flag")), SubstAux(Part(u, C2), x, v, $s("flag")))), If(SameQ(Head(u), Defer($rubi("Subst"))), If(Or(SameQ(Part(u, C2), x), FreeQ(Part(u, C1), x)), SubstAux(Part(u, C1), Part(u, C2), SubstAux(Part(u, C3), x, v, $s("flag")), $s("flag")), $(Defer($rubi("Subst")), u, x, v)), If(SameQ(Head(u), Defer($rubi("Dist"))), $(Defer($rubi("Dist")), SubstAux(Part(u, C1), x, v, $s("flag")), SubstAux(Part(u, C2), x, v, $s("flag")), Part(u, C3)), If(And($s("§simplifyflag"), MemberQ(List($rubi("Unintegrable"), $rubi("CannotIntegrate")), Head(u)), SameQ(Part(u, C2), x)), With(List(Set(w, Simplify(D(v, x)))), Times(FreeFactors(w, x), $(Head(u), Times(Subst(Part(u, C1), x, v), NonfreeFactors(w, x)), x))), If(Or(And(CalculusQ(u), Not(FreeQ(x, Part(u, C2)))), And(HeldFormQ(u), UnsameQ(Head(u), Defer(AppellF1)))), $(Defer($rubi("Subst")), u, x, v), If(And($s("flag"), Equal(Length(u), C1), LinearQ(Part(u, C1), x)), $(Head(u), Simplify(SubstAux(Part(u, C1), x, v, $s("flag")))), If(And($s("flag"), SameQ(Head(u), PolyLog), Equal(Length(u), C2), LinearQ(Part(u, C2), x)), PolyLog(SubstAux(Part(u, C1), x, v, $s("flag")), Simplify(SubstAux(Part(u, C2), x, v, $s("flag")))), With(List(Set(w, Map(Function(SubstAux(Slot1, x, v, $s("flag"))), u))), If(PolyQ(w, x), With(List(Set(z, If(Or(LinearQ(v, x), MonomialQ(v, x)), ExpandToSum(w, x), Simplify(w)))), If(LessEqual(LeafCount(z), Times(If(LinearQ(u, x), QQ(3L, 4L), QQ(9L, 10L)), LeafCount(w))), If(EqQ(Sqr(NumericFactor(z)), C1), z, Times(NumericFactor(z), NonnumericFactors(z))), If(EqQ(Sqr(NumericFactor(w)), C1), w, Times(NumericFactor(w), NonnumericFactors(w))))), With(List(Set($s("ulst"), BinomialParts(u, x))), If(And(Not(FalseQ($s("ulst"))), IGtQ(Part($s("ulst"), C3), C0), NeQ(Part($s("ulst"), C1), C0), Or(NeQ(Part($s("ulst"), C3), C1), AlgebraicFunctionQ(v, x))), With(List(Set(z, Simplify(w))), If(Less(LeafCount(z), Times(QQ(9L, 10L), LeafCount(w))), z, w)), w)))))))))))))),
            ISetDelayed(447, SimplifyAntiderivative(Times(c_, u_), x_Symbol),
                    Condition(With(List(Set(v, SimplifyAntiderivative(u, x))), If(And(SumQ(v), NonsumQ(u)), Map(Function(Times(c, Slot1)), v), Times(c, v))), FreeQ(c, x))),
            ISetDelayed(448, SimplifyAntiderivative(Log(Times(c_, u_)), x_Symbol),
                    Condition(SimplifyAntiderivative(Log(u), x), FreeQ(c, x))),
            ISetDelayed(449, SimplifyAntiderivative(Log(Power(u_, n_)), x_Symbol),
                    Condition(Times(n, SimplifyAntiderivative(Log(u), x)), FreeQ(n, x))),
            ISetDelayed(450, SimplifyAntiderivative($(F_, $(G_, u_)), x_Symbol),
                    Condition(Negate(SimplifyAntiderivative(F(Power(G(u), -1)), x)), And(MemberQ(List(Log, ArcTan, ArcCot), FSymbol), MemberQ(List(Cot, Sec, Csc, Coth, Sech, Csch), GSymbol)))),
            ISetDelayed(451, SimplifyAntiderivative($(F_, $(G_, u_)), x_Symbol),
                    Condition(SimplifyAntiderivative(F(Power(G(u), -1)), x), And(MemberQ(List(ArcTanh, ArcCoth), FSymbol), MemberQ(List(Cot, Sec, Csc, Coth, Sech, Csch), GSymbol)))),
            ISetDelayed(452, SimplifyAntiderivative(Log($(F_, u_)), x_Symbol),
                    Condition(Negate(SimplifyAntiderivative(Log(Power(F(u), -1)), x)), MemberQ(List(Cot, Sec, Csc, Coth, Sech, Csch), FSymbol))),
            ISetDelayed(453, SimplifyAntiderivative(Log(Power(f_, u_)), x_Symbol),
                    Condition(Times(Log(f), SimplifyAntiderivative(u, x)), FreeQ(f, x))),
            ISetDelayed(454, SimplifyAntiderivative(Log(Plus(a_, Times(b_DEFAULT, Tan(u_)))), x_Symbol),
                    Condition(Plus(Times(b, Power(a, -1), SimplifyAntiderivative(u, x)), Negate(SimplifyAntiderivative(Log(Cos(u)), x))), And(FreeQ(List(a, b), x), EqQ(Plus(Sqr(a), Sqr(b)), C0)))),
            ISetDelayed(455, SimplifyAntiderivative(Log(Plus(a_, Times(b_DEFAULT, Cot(u_)))), x_Symbol),
                    Condition(Plus(Times(CN1, b, Power(a, -1), SimplifyAntiderivative(u, x)), Negate(SimplifyAntiderivative(Log(Sin(u)), x))), And(FreeQ(List(a, b), x), EqQ(Plus(Sqr(a), Sqr(b)), C0)))),
            ISetDelayed(456, SimplifyAntiderivative(ArcTan(Times(a_DEFAULT, Tan(u_))), x_Symbol),
                    Condition(RectifyTangent(u, a, C1, x), And(FreeQ(a, x), GtQ(Sqr(a), C0), ComplexFreeQ(u)))),
            ISetDelayed(457, SimplifyAntiderivative(ArcCot(Times(a_DEFAULT, Tan(u_))), x_Symbol),
                    Condition(RectifyTangent(u, a, CN1, x), And(FreeQ(a, x), GtQ(Sqr(a), C0), ComplexFreeQ(u)))),
            ISetDelayed(458, SimplifyAntiderivative(ArcCot(Times(a_DEFAULT, Tanh(u_))), x_Symbol),
                    Condition(Negate(SimplifyAntiderivative(ArcTan(Times(a, Tanh(u))), x)), And(FreeQ(a, x), ComplexFreeQ(u)))),
            ISetDelayed(459, SimplifyAntiderivative(ArcTanh(Times(a_DEFAULT, Tan(u_))), x_Symbol),
                    Condition(RectifyTangent(u, Times(CI, a), Negate(CI), x), And(FreeQ(a, x), GtQ(Sqr(a), C0), ComplexFreeQ(u)))),
            ISetDelayed(460, SimplifyAntiderivative(ArcCoth(Times(a_DEFAULT, Tan(u_))), x_Symbol),
                    Condition(RectifyTangent(u, Times(CI, a), Negate(CI), x), And(FreeQ(a, x), GtQ(Sqr(a), C0), ComplexFreeQ(u)))),
            ISetDelayed(461, SimplifyAntiderivative(ArcTanh(Tanh(u_)), x_Symbol),
                    SimplifyAntiderivative(u, x)),
            ISetDelayed(462, SimplifyAntiderivative(ArcCoth(Tanh(u_)), x_Symbol),
                    SimplifyAntiderivative(u, x)),
            ISetDelayed(463, SimplifyAntiderivative(ArcCot(Times(a_DEFAULT, Cot(u_))), x_Symbol),
                    Condition(RectifyCotangent(u, a, C1, x), And(FreeQ(a, x), GtQ(Sqr(a), C0), ComplexFreeQ(u)))),
            ISetDelayed(464, SimplifyAntiderivative(ArcTan(Times(a_DEFAULT, Cot(u_))), x_Symbol),
                    Condition(RectifyCotangent(u, a, CN1, x), And(FreeQ(a, x), GtQ(Sqr(a), C0), ComplexFreeQ(u)))),
            ISetDelayed(465, SimplifyAntiderivative(ArcTan(Times(a_DEFAULT, Coth(u_))), x_Symbol),
                    Condition(Negate(SimplifyAntiderivative(ArcTan(Times(Tanh(u), Power(a, -1))), x)), And(FreeQ(a, x), ComplexFreeQ(u)))),
            ISetDelayed(466, SimplifyAntiderivative(ArcCoth(Times(a_DEFAULT, Cot(u_))), x_Symbol),
                    Condition(RectifyCotangent(u, Times(CI, a), CI, x), And(FreeQ(a, x), GtQ(Sqr(a), C0), ComplexFreeQ(u)))),
            ISetDelayed(467, SimplifyAntiderivative(ArcTanh(Times(a_DEFAULT, Cot(u_))), x_Symbol),
                    Condition(RectifyCotangent(u, Times(CI, a), CI, x), And(FreeQ(a, x), GtQ(Sqr(a), C0), ComplexFreeQ(u)))),
            ISetDelayed(468, SimplifyAntiderivative(ArcCoth(Coth(u_)), x_Symbol),
                    SimplifyAntiderivative(u, x)),
            ISetDelayed(469, SimplifyAntiderivative(ArcTanh(Times(a_DEFAULT, Coth(u_))), x_Symbol),
                    Condition(SimplifyAntiderivative(ArcTanh(Times(Tanh(u), Power(a, -1))), x), And(FreeQ(a, x), ComplexFreeQ(u)))),
            ISetDelayed(470, SimplifyAntiderivative(ArcTanh(Coth(u_)), x_Symbol),
                    SimplifyAntiderivative(u, x)),
            ISetDelayed(471, SimplifyAntiderivative(ArcTan(Times(c_DEFAULT, Plus(a_, Times(b_DEFAULT, Tan(u_))))), x_Symbol),
                    Condition(RectifyTangent(u, Times(a, c), Times(b, c), C1, x), And(FreeQ(List(a, b, c), x), GtQ(Times(Sqr(a), Sqr(c)), C0), GtQ(Times(Sqr(b), Sqr(c)), C0), ComplexFreeQ(u)))),
            ISetDelayed(472, SimplifyAntiderivative(ArcTanh(Times(c_DEFAULT, Plus(a_, Times(b_DEFAULT, Tan(u_))))), x_Symbol),
                    Condition(RectifyTangent(u, Times(CI, a, c), Times(CI, b, c), Negate(CI), x), And(FreeQ(List(a, b, c), x), GtQ(Times(Sqr(a), Sqr(c)), C0), GtQ(Times(Sqr(b), Sqr(c)), C0), ComplexFreeQ(u)))),
            ISetDelayed(473, SimplifyAntiderivative(ArcTan(Times(c_DEFAULT, Plus(a_, Times(b_DEFAULT, Cot(u_))))), x_Symbol),
                    Condition(RectifyCotangent(u, Times(a, c), Times(b, c), C1, x), And(FreeQ(List(a, b, c), x), GtQ(Times(Sqr(a), Sqr(c)), C0), GtQ(Times(Sqr(b), Sqr(c)), C0), ComplexFreeQ(u)))),
            ISetDelayed(474, SimplifyAntiderivative(ArcTanh(Times(c_DEFAULT, Plus(a_, Times(b_DEFAULT, Cot(u_))))), x_Symbol),
                    Condition(RectifyCotangent(u, Times(CI, a, c), Times(CI, b, c), Negate(CI), x), And(FreeQ(List(a, b, c), x), GtQ(Times(Sqr(a), Sqr(c)), C0), GtQ(Times(Sqr(b), Sqr(c)), C0), ComplexFreeQ(u))))
    );
}
