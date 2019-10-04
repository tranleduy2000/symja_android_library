package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.*;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ActivateTrig;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.AlgebraicTrigFunctionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.CalculusQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EvenQuotientQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FalseQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FindTrigFactor;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FreeFactors;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfCosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfCoshQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfExpnQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfExponential;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfExponentialFunction;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfExponentialFunctionAux;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfExponentialTest;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfExponentialTestAux;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfHyperbolic;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfSinQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfSinhQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfTanQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfTanWeight;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfTanhQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfTrig;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfTrigOfLinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfTrigQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.HyperbolicQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InertTrigFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegerPowerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegerQuotientQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NegQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NonfreeFactors;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.OddQuotientQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.OddTrigPowerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PowerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ProductQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PureFunctionOfCosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PureFunctionOfCoshQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PureFunctionOfCotQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PureFunctionOfCothQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PureFunctionOfSinQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PureFunctionOfSinhQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PureFunctionOfTanQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PureFunctionOfTanhQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ReapList;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.TrigQ;

/**
 * UtilityFunctions rules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class UtilityFunctions18 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            ISetDelayed(386, FunctionOfExponential(u_, x_Symbol),
                    Block(List(Set($s("$base$"), Null), Set($s("$expon$"), Null), Set($s("§$exponflag$"), False)), CompoundExpression(FunctionOfExponentialTest(u, x), Power($s("$base$"), $s("$expon$")))));
            ISetDelayed(387, FunctionOfExponentialFunction(u_, x_Symbol),
                    Block(List(Set($s("$base$"), Null), Set($s("$expon$"), Null), Set($s("§$exponflag$"), False)), CompoundExpression(FunctionOfExponentialTest(u, x), SimplifyIntegrand(FunctionOfExponentialFunctionAux(u, x), x))));
            ISetDelayed(388, FunctionOfExponentialFunctionAux(u_, x_),
                    If(AtomQ(u), u, If(And(PowerQ(u), FreeQ(Part(u, C1), x), LinearQ(Part(u, C2), x)), If(EqQ(Coefficient($s("$expon$"), x, C0), C0), Times(Power(Part(u, C1), Coefficient(Part(u, C2), x, C0)), Power(x, FullSimplify(Times(Log(Part(u, C1)), Coefficient(Part(u, C2), x, C1), Power(Times(Log($s("$base$")), Coefficient($s("$expon$"), x, C1)), CN1))))), Power(x, FullSimplify(Times(Log(Part(u, C1)), Coefficient(Part(u, C2), x, C1), Power(Times(Log($s("$base$")), Coefficient($s("$expon$"), x, C1)), CN1))))), If(And(HyperbolicQ(u), LinearQ(Part(u, C1), x)), Module(List($s("tmp")), CompoundExpression(Set($s("tmp"), Power(x, FullSimplify(Times(Coefficient(Part(u, C1), x, C1), Power(Times(Log($s("$base$")), Coefficient($s("$expon$"), x, C1)), CN1))))), Switch(Head(u), Sinh, Subtract(Times(C1D2, $s("tmp")), Power(Times(C2, $s("tmp")), CN1)), Cosh, Plus(Times(C1D2, $s("tmp")), Power(Times(C2, $s("tmp")), CN1)), Tanh, Times(Subtract($s("tmp"), Power($s("tmp"), CN1)), Power(Plus($s("tmp"), Power($s("tmp"), CN1)), CN1)), Coth, Times(Plus($s("tmp"), Power($s("tmp"), CN1)), Power(Subtract($s("tmp"), Power($s("tmp"), CN1)), CN1)), Sech, Times(C2, Power(Plus($s("tmp"), Power($s("tmp"), CN1)), CN1)), Csch, Times(C2, Power(Subtract($s("tmp"), Power($s("tmp"), CN1)), CN1))))), If(And(PowerQ(u), FreeQ(Part(u, C1), x), SumQ(Part(u, C2))), Times(FunctionOfExponentialFunctionAux(Power(Part(u, C1), First(Part(u, C2))), x), FunctionOfExponentialFunctionAux(Power(Part(u, C1), Rest(Part(u, C2))), x)), Map(Function(FunctionOfExponentialFunctionAux(Slot1, x)), u))))));
            ISetDelayed(389, FunctionOfExponentialTest(u_, x_),
                    If(FreeQ(u, x), True, If(Or(SameQ(u, x), CalculusQ(u)), False, If(And(PowerQ(u), FreeQ(Part(u, C1), x), LinearQ(Part(u, C2), x)), CompoundExpression(Set($s("§$exponflag$"), True), FunctionOfExponentialTestAux(Part(u, C1), Part(u, C2), x)), If(And(HyperbolicQ(u), LinearQ(Part(u, C1), x)), FunctionOfExponentialTestAux(E, Part(u, C1), x), If(And(PowerQ(u), FreeQ(Part(u, C1), x), SumQ(Part(u, C2))), And(FunctionOfExponentialTest(Power(Part(u, C1), First(Part(u, C2))), x), FunctionOfExponentialTest(Power(Part(u, C1), Rest(Part(u, C2))), x)), Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfExponentialTest(Slot1, x)), Throw(False))), u), True))))))));
            ISetDelayed(390, FunctionOfExponentialTestAux($p("base"), $p("expon"), x_),
                    If(SameQ($s("$base$"), Null), CompoundExpression(Set($s("$base$"), $s("base")), Set($s("$expon$"), $s("expon")), True), Module(List($s("tmp")), CompoundExpression(Set($s("tmp"), FullSimplify(Times(Log($s("base")), Coefficient($s("expon"), x, C1), Power(Times(Log($s("$base$")), Coefficient($s("$expon$"), x, C1)), CN1)))), If(Not(RationalQ($s("tmp"))), False, If(Or(EqQ(Coefficient($s("$expon$"), x, C0), C0), NeQ($s("tmp"), FullSimplify(Times(Log($s("base")), Coefficient($s("expon"), x, C0), Power(Times(Log($s("$base$")), Coefficient($s("$expon$"), x, C0)), CN1))))), CompoundExpression(If(And(IGtQ($s("base"), C0), IGtQ($s("$base$"), C0), Less($s("base"), $s("$base$"))), CompoundExpression(Set($s("$base$"), $s("base")), Set($s("$expon$"), $s("expon")), Set($s("tmp"), Power($s("tmp"), CN1)))), Set($s("$expon$"), Times(Coefficient($s("$expon$"), x, C1), x, Power(Denominator($s("tmp")), CN1))), If(And(Less($s("tmp"), C0), NegQ(Coefficient($s("$expon$"), x, C1))), CompoundExpression(Set($s("$expon$"), Negate($s("$expon$"))), True), True)), CompoundExpression(If(And(IGtQ($s("base"), C0), IGtQ($s("$base$"), C0), Less($s("base"), $s("$base$"))), CompoundExpression(Set($s("$base$"), $s("base")), Set($s("$expon$"), $s("expon")), Set($s("tmp"), Power($s("tmp"), CN1)))), Set($s("$expon$"), Times($s("$expon$"), Power(Denominator($s("tmp")), CN1))), If(And(Less($s("tmp"), C0), NegQ(Coefficient($s("$expon$"), x, C1))), CompoundExpression(Set($s("$expon$"), Negate($s("$expon$"))), True), True))))))));
            ISetDelayed(391, FunctionOfTrigOfLinearQ(u_, x_Symbol),
                    If(MatchQ(u, Condition(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x)), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($p("§trig"), Plus(e_DEFAULT, Times(f_DEFAULT, x))))), n_DEFAULT)), And(FreeQ(List(a, b, c, d, e, f, m, n), x), Or(TrigQ($s("§trig")), HyperbolicQ($s("§trig")))))), True, And(Not(MemberQ(List(Null, False), FunctionOfTrig(u, Null, x))), AlgebraicTrigFunctionQ(u, x))));
            ISetDelayed(392, FunctionOfTrig(u_, x_Symbol),
                    With(List(Set(v, FunctionOfTrig(ActivateTrig(u), Null, x))), If(SameQ(v, Null), False, v)));
            ISetDelayed(393, FunctionOfTrig(u_, v_, x_),
                    If(AtomQ(u), If(SameQ(u, x), False, v), If(And(TrigQ(u), LinearQ(Part(u, C1), x)), If(SameQ(v, Null), Part(u, C1), With(List(Set(a, Coefficient(v, x, C0)), Set(b, Coefficient(v, x, C1)), Set(c, Coefficient(Part(u, C1), x, C0)), Set(d, Coefficient(Part(u, C1), x, C1))), If(And(EqQ(Subtract(Times(a, d), Times(b, c)), C0), RationalQ(Times(b, Power(d, CN1)))), Plus(Times(a, Power(Numerator(Times(b, Power(d, CN1))), CN1)), Times(b, x, Power(Numerator(Times(b, Power(d, CN1))), CN1))), False))), If(And(HyperbolicQ(u), LinearQ(Part(u, C1), x)), If(SameQ(v, Null), Times(CI, Part(u, C1)), With(List(Set(a, Coefficient(v, x, C0)), Set(b, Coefficient(v, x, C1)), Set(c, Times(CI, Coefficient(Part(u, C1), x, C0))), Set(d, Times(CI, Coefficient(Part(u, C1), x, C1)))), If(And(EqQ(Subtract(Times(a, d), Times(b, c)), C0), RationalQ(Times(b, Power(d, CN1)))), Plus(Times(a, Power(Numerator(Times(b, Power(d, CN1))), CN1)), Times(b, x, Power(Numerator(Times(b, Power(d, CN1))), CN1))), False))), If(CalculusQ(u), False, Module(List(Set(w, v)), Catch(CompoundExpression(Scan(Function(If(FalseQ(Set(w, FunctionOfTrig(Slot1, w, x))), Throw(False))), u), w))))))));
            ISetDelayed(394, AlgebraicTrigFunctionQ(u_, x_Symbol),
                    If(AtomQ(u), True, If(And(TrigQ(u), LinearQ(Part(u, C1), x)), True, If(And(HyperbolicQ(u), LinearQ(Part(u, C1), x)), True, If(And(PowerQ(u), FreeQ(Part(u, C2), x)), AlgebraicTrigFunctionQ(Part(u, C1), x), If(Or(ProductQ(u), SumQ(u)), Catch(CompoundExpression(Scan(Function(If(Not(AlgebraicTrigFunctionQ(Slot1, x)), Throw(False))), u), True)), False))))));
            ISetDelayed(395, FunctionOfHyperbolic(u_, x_Symbol),
                    With(List(Set(v, FunctionOfHyperbolic(u, Null, x))), If(SameQ(v, Null), False, v)));
            ISetDelayed(396, FunctionOfHyperbolic(u_, v_, x_),
                    If(AtomQ(u), If(SameQ(u, x), False, v), If(And(HyperbolicQ(u), LinearQ(Part(u, C1), x)), If(SameQ(v, Null), Part(u, C1), With(List(Set(a, Coefficient(v, x, C0)), Set(b, Coefficient(v, x, C1)), Set(c, Coefficient(Part(u, C1), x, C0)), Set(d, Coefficient(Part(u, C1), x, C1))), If(And(EqQ(Subtract(Times(a, d), Times(b, c)), C0), RationalQ(Times(b, Power(d, CN1)))), Plus(Times(a, Power(Numerator(Times(b, Power(d, CN1))), CN1)), Times(b, x, Power(Numerator(Times(b, Power(d, CN1))), CN1))), False))), If(CalculusQ(u), False, Module(List(Set(w, v)), Catch(CompoundExpression(Scan(Function(If(FalseQ(Set(w, FunctionOfHyperbolic(Slot1, w, x))), Throw(False))), u), w)))))));
            ISetDelayed(397, FunctionOfQ(v_, u_, x_Symbol, Optional($p("§pureflag"), False)),
                    If(FreeQ(u, x), False, If(AtomQ(v), True, If(Not(InertTrigFreeQ(u)), FunctionOfQ(v, ActivateTrig(u), x, $s("§pureflag")), If(And(ProductQ(v), NeQ(FreeFactors(v, x), C1)), FunctionOfQ(NonfreeFactors(v, x), u, x, $s("§pureflag")), If($s("§pureflag"), Switch(Head(v), Sin, PureFunctionOfSinQ(u, Part(v, C1), x), Cos, PureFunctionOfCosQ(u, Part(v, C1), x), Tan, PureFunctionOfTanQ(u, Part(v, C1), x), Cot, PureFunctionOfCotQ(u, Part(v, C1), x), Sec, PureFunctionOfCosQ(u, Part(v, C1), x), Csc, PureFunctionOfSinQ(u, Part(v, C1), x), Sinh, PureFunctionOfSinhQ(u, Part(v, C1), x), Cosh, PureFunctionOfCoshQ(u, Part(v, C1), x), Tanh, PureFunctionOfTanhQ(u, Part(v, C1), x), Coth, PureFunctionOfCothQ(u, Part(v, C1), x), Sech, PureFunctionOfCoshQ(u, Part(v, C1), x), Csch, PureFunctionOfSinhQ(u, Part(v, C1), x), $b(), UnsameQ(FunctionOfExpnQ(u, v, x), False)), Switch(Head(v), Sin, FunctionOfSinQ(u, Part(v, C1), x), Cos, FunctionOfCosQ(u, Part(v, C1), x), Tan, FunctionOfTanQ(u, Part(v, C1), x), Cot, FunctionOfTanQ(u, Part(v, C1), x), Sec, FunctionOfCosQ(u, Part(v, C1), x), Csc, FunctionOfSinQ(u, Part(v, C1), x), Sinh, FunctionOfSinhQ(u, Part(v, C1), x), Cosh, FunctionOfCoshQ(u, Part(v, C1), x), Tanh, FunctionOfTanhQ(u, Part(v, C1), x), Coth, FunctionOfTanhQ(u, Part(v, C1), x), Sech, FunctionOfCoshQ(u, Part(v, C1), x), Csch, FunctionOfSinhQ(u, Part(v, C1), x), $b(), UnsameQ(FunctionOfExpnQ(u, v, x), False))))))));
            ISetDelayed(398, FunctionOfExpnQ(u_, v_, x_),
                    If(SameQ(u, v), C1, If(AtomQ(u), If(SameQ(u, x), False, C0), If(CalculusQ(u), False, If(And(PowerQ(u), FreeQ(Part(u, C2), x)), If(EqQ(Part(u, C1), v), If(IntegerQ(Part(u, C2)), Part(u, C2), C1), If(And(PowerQ(v), FreeQ(Part(v, C2), x), EqQ(Part(u, C1), Part(v, C1))), If(RationalQ(Part(v, C2)), If(And(RationalQ(Part(u, C2)), IntegerQ(Times(Part(u, C2), Power(Part(v, C2), CN1))), Or(Greater(Part(v, C2), C0), Less(Part(u, C2), C0))), Times(Part(u, C2), Power(Part(v, C2), CN1)), False), If(IntegerQ(Simplify(Times(Part(u, C2), Power(Part(v, C2), CN1)))), Simplify(Times(Part(u, C2), Power(Part(v, C2), CN1))), False)), FunctionOfExpnQ(Part(u, C1), v, x))), If(And(ProductQ(u), NeQ(FreeFactors(u, x), C1)), FunctionOfExpnQ(NonfreeFactors(u, x), v, x), If(And(ProductQ(u), ProductQ(v)), Module(List(Set($s("deg1"), FunctionOfExpnQ(First(u), First(v), x)), $s("deg2")), If(SameQ($s("deg1"), False), False, CompoundExpression(Set($s("deg2"), FunctionOfExpnQ(Rest(u), Rest(v), x)), If(And(SameQ($s("deg1"), $s("deg2")), FreeQ(Simplify(Times(u, Power(Power(v, $s("deg1")), CN1))), x)), $s("deg1"), False)))), With(List(Set($s("lst"), Map(Function(FunctionOfExpnQ(Slot1, v, x)), Apply(List, u)))), If(MemberQ($s("lst"), False), False, Apply(GCD, $s("lst")))))))))));
            ISetDelayed(399, PureFunctionOfSinQ(u_, v_, x_),
                    If(AtomQ(u), UnsameQ(u, x), If(CalculusQ(u), False, If(And(TrigQ(u), EqQ(Part(u, C1), v)), Or(SameQ(Head(u), Sin), SameQ(Head(u), Csc)), Catch(CompoundExpression(Scan(Function(If(Not(PureFunctionOfSinQ(Slot1, v, x)), Throw(False))), u), True))))));
            ISetDelayed(400, PureFunctionOfCosQ(u_, v_, x_),
                    If(AtomQ(u), UnsameQ(u, x), If(CalculusQ(u), False, If(And(TrigQ(u), EqQ(Part(u, C1), v)), Or(SameQ(Head(u), Cos), SameQ(Head(u), Sec)), Catch(CompoundExpression(Scan(Function(If(Not(PureFunctionOfCosQ(Slot1, v, x)), Throw(False))), u), True))))));
            ISetDelayed(401, PureFunctionOfTanQ(u_, v_, x_),
                    If(AtomQ(u), UnsameQ(u, x), If(CalculusQ(u), False, If(And(TrigQ(u), EqQ(Part(u, C1), v)), Or(SameQ(Head(u), Tan), SameQ(Head(u), Cot)), Catch(CompoundExpression(Scan(Function(If(Not(PureFunctionOfTanQ(Slot1, v, x)), Throw(False))), u), True))))));
            ISetDelayed(402, PureFunctionOfCotQ(u_, v_, x_),
                    If(AtomQ(u), UnsameQ(u, x), If(CalculusQ(u), False, If(And(TrigQ(u), EqQ(Part(u, C1), v)), SameQ(Head(u), Cot), Catch(CompoundExpression(Scan(Function(If(Not(PureFunctionOfCotQ(Slot1, v, x)), Throw(False))), u), True))))));
            ISetDelayed(403, FunctionOfSinQ(u_, v_, x_),
                    If(AtomQ(u), UnsameQ(u, x), If(CalculusQ(u), False, If(And(TrigQ(u), IntegerQuotientQ(Part(u, C1), v)), If(OddQuotientQ(Part(u, C1), v), Or(SameQ(Head(u), Sin), SameQ(Head(u), Csc)), Or(SameQ(Head(u), Cos), SameQ(Head(u), Sec))), If(And(IntegerPowerQ(u), TrigQ(Part(u, C1)), IntegerQuotientQ(Part(u, C1, C1), v)), If(EvenQ(Part(u, C2)), True, FunctionOfSinQ(Part(u, C1), v, x)), If(ProductQ(u), If(And(SameQ(Head(Part(u, C1)), Cos), SameQ(Head(Part(u, C2)), Sin), EqQ(Part(u, C1, C1), Times(C1D2, v)), EqQ(Part(u, C2, C1), Times(C1D2, v))), FunctionOfSinQ(Drop(u, C2), v, x), Module(List($s("lst")), CompoundExpression(Set($s("lst"), FindTrigFactor(Sin, Csc, u, v, False)), If(And(ListQ($s("lst")), EvenQuotientQ(Part($s("lst"), C1), v)), FunctionOfSinQ(Times(Cos(v), Part($s("lst"), C2)), v, x), CompoundExpression(Set($s("lst"), FindTrigFactor(Cos, Sec, u, v, False)), If(And(ListQ($s("lst")), OddQuotientQ(Part($s("lst"), C1), v)), FunctionOfSinQ(Times(Cos(v), Part($s("lst"), C2)), v, x), CompoundExpression(Set($s("lst"), FindTrigFactor(Tan, Cot, u, v, True)), If(ListQ($s("lst")), FunctionOfSinQ(Times(Cos(v), Part($s("lst"), C2)), v, x), Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfSinQ(Slot1, v, x)), Throw(False))), u), True)))))))))), Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfSinQ(Slot1, v, x)), Throw(False))), u), True))))))));
            ISetDelayed(404, FunctionOfCosQ(u_, v_, x_),
                    If(AtomQ(u), UnsameQ(u, x), If(CalculusQ(u), False, If(And(TrigQ(u), IntegerQuotientQ(Part(u, C1), v)), Or(SameQ(Head(u), Cos), SameQ(Head(u), Sec)), If(And(IntegerPowerQ(u), TrigQ(Part(u, C1)), IntegerQuotientQ(Part(u, C1, C1), v)), If(EvenQ(Part(u, C2)), True, FunctionOfCosQ(Part(u, C1), v, x)), If(ProductQ(u), Module(List($s("lst")), CompoundExpression(Set($s("lst"), FindTrigFactor(Sin, Csc, u, v, False)), If(ListQ($s("lst")), FunctionOfCosQ(Times(Sin(v), Part($s("lst"), C2)), v, x), CompoundExpression(Set($s("lst"), FindTrigFactor(Tan, Cot, u, v, True)), If(ListQ($s("lst")), FunctionOfCosQ(Times(Sin(v), Part($s("lst"), C2)), v, x), Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfCosQ(Slot1, v, x)), Throw(False))), u), True))))))), Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfCosQ(Slot1, v, x)), Throw(False))), u), True))))))));
            ISetDelayed(405, FunctionOfTanQ(u_, v_, x_),
                    If(AtomQ(u), UnsameQ(u, x), If(CalculusQ(u), False, If(And(TrigQ(u), IntegerQuotientQ(Part(u, C1), v)), Or(SameQ(Head(u), Tan), SameQ(Head(u), Cot), EvenQuotientQ(Part(u, C1), v)), If(And(PowerQ(u), EvenQ(Part(u, C2)), TrigQ(Part(u, C1)), IntegerQuotientQ(Part(u, C1, C1), v)), True, If(And(PowerQ(u), EvenQ(Part(u, C2)), SumQ(Part(u, C1))), FunctionOfTanQ(Expand(Sqr(Part(u, C1))), v, x), If(ProductQ(u), Module(List(Set($s("lst"), ReapList(Scan(Function(If(Not(FunctionOfTanQ(Slot1, v, x)), Sow(Slot1))), u)))), If(SameQ($s("lst"), List()), True, And(Equal(Length($s("lst")), C2), OddTrigPowerQ(Part($s("lst"), C1), v, x), OddTrigPowerQ(Part($s("lst"), C2), v, x)))), Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfTanQ(Slot1, v, x)), Throw(False))), u), True)))))))));
            ISetDelayed(406, OddTrigPowerQ(u_, v_, x_),
                    If(MemberQ(List(Sin, Cos, Sec, Csc), Head(u)), OddQuotientQ(Part(u, C1), v), If(PowerQ(u), And(OddQ(Part(u, C2)), OddTrigPowerQ(Part(u, C1), v, x)), If(ProductQ(u), If(NeQ(FreeFactors(u, x), C1), OddTrigPowerQ(NonfreeFactors(u, x), v, x), Module(List(Set($s("lst"), ReapList(Scan(Function(If(Not(FunctionOfTanQ(Slot1, v, x)), Sow(Slot1))), u)))), If(SameQ($s("lst"), List()), True, And(Equal(Length($s("lst")), C1), OddTrigPowerQ(Part($s("lst"), C1), v, x))))), If(SumQ(u), Catch(CompoundExpression(Scan(Function(If(Not(OddTrigPowerQ(Slot1, v, x)), Throw(False))), u), True)), False)))));
            ISetDelayed(407, FunctionOfTanWeight(u_, v_, x_),
                    If(AtomQ(u), C0, If(CalculusQ(u), C0, If(And(TrigQ(u), IntegerQuotientQ(Part(u, C1), v)), If(And(SameQ(Head(u), Tan), EqQ(Part(u, C1), v)), C1, If(And(SameQ(Head(u), Cot), EqQ(Part(u, C1), v)), CN1, C0)), If(And(PowerQ(u), EvenQ(Part(u, C2)), TrigQ(Part(u, C1)), IntegerQuotientQ(Part(u, C1, C1), v)), If(Or(SameQ(Head(Part(u, C1)), Tan), SameQ(Head(Part(u, C1)), Cos), SameQ(Head(Part(u, C1)), Sec)), C1, CN1), If(ProductQ(u), If(Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfTanQ(Slot1, v, x)), Throw(False))), u), True)), Apply(Plus, Map(Function(FunctionOfTanWeight(Slot1, v, x)), Apply(List, u))), C0), Apply(Plus, Map(Function(FunctionOfTanWeight(Slot1, v, x)), Apply(List, u)))))))));
            ISetDelayed(408, FunctionOfTrigQ(u_, v_, x_Symbol),
                    If(AtomQ(u), UnsameQ(u, x), If(CalculusQ(u), False, If(And(TrigQ(u), IntegerQuotientQ(Part(u, C1), v)), True, Catch(CompoundExpression(Scan(Function(If(Not(FunctionOfTrigQ(Slot1, v, x)), Throw(False))), u), True))))));
            ISetDelayed(409, PureFunctionOfSinhQ(u_, v_, x_),
                    If(AtomQ(u), UnsameQ(u, x), If(CalculusQ(u), False, If(And(HyperbolicQ(u), EqQ(Part(u, C1), v)), Or(SameQ(Head(u), Sinh), SameQ(Head(u), Csch)), Catch(CompoundExpression(Scan(Function(If(Not(PureFunctionOfSinhQ(Slot1, v, x)), Throw(False))), u), True))))));
            ISetDelayed(410, PureFunctionOfCoshQ(u_, v_, x_),
                    If(AtomQ(u), UnsameQ(u, x), If(CalculusQ(u), False, If(And(HyperbolicQ(u), EqQ(Part(u, C1), v)), Or(SameQ(Head(u), Cosh), SameQ(Head(u), Sech)), Catch(CompoundExpression(Scan(Function(If(Not(PureFunctionOfCoshQ(Slot1, v, x)), Throw(False))), u), True))))));
        }
    }
}
