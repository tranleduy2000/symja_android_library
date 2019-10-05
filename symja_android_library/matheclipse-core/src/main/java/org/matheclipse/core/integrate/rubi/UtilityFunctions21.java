package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.ASymbol;
import static org.matheclipse.core.expression.F.A_DEFAULT;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcCot;
import static org.matheclipse.core.expression.F.ArcCoth;
import static org.matheclipse.core.expression.F.ArcTan;
import static org.matheclipse.core.expression.F.ArcTanh;
import static org.matheclipse.core.expression.F.BSymbol;
import static org.matheclipse.core.expression.F.B_DEFAULT;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CI;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CNI;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Cot;
import static org.matheclipse.core.expression.F.Coth;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.EvenQ;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.Function;
import static org.matheclipse.core.expression.F.ISetDelayed;
import static org.matheclipse.core.expression.F.If;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.Map;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Part;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Slot1;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Tan;
import static org.matheclipse.core.expression.F.Tanh;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.Together;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.a_DEFAULT;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.g_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ComplexFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LogQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NormalizeTogether;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NumericFactor;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RectifyCotangent;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RectifyTangent;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RemoveContent;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyAntiderivative;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyAntiderivativeSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumQ;

/**
 * UtilityFunctions rules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class UtilityFunctions21 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            ISetDelayed(460, SimplifyAntiderivative(ArcCoth(Times(a_DEFAULT, Tan(u_))), x_Symbol),
                    Condition(RectifyTangent(u, Times(CI, a), CNI, x), And(FreeQ(a, x), GtQ(Sqr(a), C0), ComplexFreeQ(u))));
            ISetDelayed(461, SimplifyAntiderivative(ArcTanh(Tanh(u_)), x_Symbol),
                    SimplifyAntiderivative(u, x));
            ISetDelayed(462, SimplifyAntiderivative(ArcCoth(Tanh(u_)), x_Symbol),
                    SimplifyAntiderivative(u, x));
            ISetDelayed(463, SimplifyAntiderivative(ArcCot(Times(a_DEFAULT, Cot(u_))), x_Symbol),
                    Condition(RectifyCotangent(u, a, C1, x), And(FreeQ(a, x), GtQ(Sqr(a), C0), ComplexFreeQ(u))));
            ISetDelayed(464, SimplifyAntiderivative(ArcTan(Times(a_DEFAULT, Cot(u_))), x_Symbol),
                    Condition(RectifyCotangent(u, a, CN1, x), And(FreeQ(a, x), GtQ(Sqr(a), C0), ComplexFreeQ(u))));
            ISetDelayed(465, SimplifyAntiderivative(ArcTan(Times(a_DEFAULT, Coth(u_))), x_Symbol),
                    Condition(Negate(SimplifyAntiderivative(ArcTan(Times(Tanh(u), Power(a, CN1))), x)), And(FreeQ(a, x), ComplexFreeQ(u))));
            ISetDelayed(466, SimplifyAntiderivative(ArcCoth(Times(a_DEFAULT, Cot(u_))), x_Symbol),
                    Condition(RectifyCotangent(u, Times(CI, a), CI, x), And(FreeQ(a, x), GtQ(Sqr(a), C0), ComplexFreeQ(u))));
            ISetDelayed(467, SimplifyAntiderivative(ArcTanh(Times(a_DEFAULT, Cot(u_))), x_Symbol),
                    Condition(RectifyCotangent(u, Times(CI, a), CI, x), And(FreeQ(a, x), GtQ(Sqr(a), C0), ComplexFreeQ(u))));
            ISetDelayed(468, SimplifyAntiderivative(ArcCoth(Coth(u_)), x_Symbol),
                    SimplifyAntiderivative(u, x));
            ISetDelayed(469, SimplifyAntiderivative(ArcTanh(Times(a_DEFAULT, Coth(u_))), x_Symbol),
                    Condition(SimplifyAntiderivative(ArcTanh(Times(Tanh(u), Power(a, CN1))), x), And(FreeQ(a, x), ComplexFreeQ(u))));
            ISetDelayed(470, SimplifyAntiderivative(ArcTanh(Coth(u_)), x_Symbol),
                    SimplifyAntiderivative(u, x));
            ISetDelayed(471, SimplifyAntiderivative(ArcTan(Times(c_DEFAULT, Plus(a_, Times(b_DEFAULT, Tan(u_))))), x_Symbol),
                    Condition(RectifyTangent(u, Times(a, c), Times(b, c), C1, x), And(FreeQ(List(a, b, c), x), GtQ(Times(Sqr(a), Sqr(c)), C0), GtQ(Times(Sqr(b), Sqr(c)), C0), ComplexFreeQ(u))));
            ISetDelayed(472, SimplifyAntiderivative(ArcTanh(Times(c_DEFAULT, Plus(a_, Times(b_DEFAULT, Tan(u_))))), x_Symbol),
                    Condition(RectifyTangent(u, Times(CI, a, c), Times(CI, b, c), CNI, x), And(FreeQ(List(a, b, c), x), GtQ(Times(Sqr(a), Sqr(c)), C0), GtQ(Times(Sqr(b), Sqr(c)), C0), ComplexFreeQ(u))));
            ISetDelayed(473, SimplifyAntiderivative(ArcTan(Times(c_DEFAULT, Plus(a_, Times(b_DEFAULT, Cot(u_))))), x_Symbol),
                    Condition(RectifyCotangent(u, Times(a, c), Times(b, c), C1, x), And(FreeQ(List(a, b, c), x), GtQ(Times(Sqr(a), Sqr(c)), C0), GtQ(Times(Sqr(b), Sqr(c)), C0), ComplexFreeQ(u))));
            ISetDelayed(474, SimplifyAntiderivative(ArcTanh(Times(c_DEFAULT, Plus(a_, Times(b_DEFAULT, Cot(u_))))), x_Symbol),
                    Condition(RectifyCotangent(u, Times(CI, a, c), Times(CI, b, c), CNI, x), And(FreeQ(List(a, b, c), x), GtQ(Times(Sqr(a), Sqr(c)), C0), GtQ(Times(Sqr(b), Sqr(c)), C0), ComplexFreeQ(u))));
            ISetDelayed(475, SimplifyAntiderivative(ArcTan(Plus(a_DEFAULT, Times(b_DEFAULT, Tan(u_)), Times(c_DEFAULT, Sqr(Tan(u_))))), x_Symbol),
                    Condition(If(EvenQ(Denominator(NumericFactor(Together(u)))), ArcTan(NormalizeTogether(Times(Plus(a, c, CN1, Times(Subtract(Subtract(a, c), C1), Cos(Times(C2, u))), Times(b, Sin(Times(C2, u)))), Power(Plus(a, c, C1, Times(Plus(a, Negate(c), C1), Cos(Times(C2, u))), Times(b, Sin(Times(C2, u)))), CN1)))), ArcTan(NormalizeTogether(Times(Plus(c, Times(Subtract(Subtract(a, c), C1), Sqr(Cos(u))), Times(b, Cos(u), Sin(u))), Power(Plus(c, Times(Plus(a, Negate(c), C1), Sqr(Cos(u))), Times(b, Cos(u), Sin(u))), CN1))))), And(FreeQ(List(a, b, c), x), ComplexFreeQ(u))));
            ISetDelayed(476, SimplifyAntiderivative(ArcTan(Plus(a_DEFAULT, Times(b_DEFAULT, Plus(d_DEFAULT, Times(e_DEFAULT, Tan(u_)))), Times(c_DEFAULT, Sqr(Plus(f_DEFAULT, Times(g_DEFAULT, Tan(u_))))))), x_Symbol),
                    Condition(SimplifyAntiderivative(ArcTan(Plus(a, Times(b, d), Times(c, Sqr(f)), Times(Plus(Times(b, e), Times(C2, c, f, g)), Tan(u)), Times(c, Sqr(g), Sqr(Tan(u))))), x), And(FreeQ(List(a, b, c), x), ComplexFreeQ(u))));
            ISetDelayed(477, SimplifyAntiderivative(ArcTan(Plus(a_DEFAULT, Times(c_DEFAULT, Sqr(Tan(u_))))), x_Symbol),
                    Condition(If(EvenQ(Denominator(NumericFactor(Together(u)))), ArcTan(NormalizeTogether(Times(Plus(a, c, CN1, Times(Subtract(Subtract(a, c), C1), Cos(Times(C2, u)))), Power(Plus(a, c, C1, Times(Plus(a, Negate(c), C1), Cos(Times(C2, u)))), CN1)))), ArcTan(NormalizeTogether(Times(Plus(c, Times(Subtract(Subtract(a, c), C1), Sqr(Cos(u)))), Power(Plus(c, Times(Plus(a, Negate(c), C1), Sqr(Cos(u)))), CN1))))), And(FreeQ(List(a, c), x), ComplexFreeQ(u))));
            ISetDelayed(478, SimplifyAntiderivative(ArcTan(Plus(a_DEFAULT, Times(c_DEFAULT, Sqr(Plus(f_DEFAULT, Times(g_DEFAULT, Tan(u_))))))), x_Symbol),
                    Condition(SimplifyAntiderivative(ArcTan(Plus(a, Times(c, Sqr(f)), Times(C2, c, f, g, Tan(u)), Times(c, Sqr(g), Sqr(Tan(u))))), x), And(FreeQ(List(a, c), x), ComplexFreeQ(u))));
            ISetDelayed(479, SimplifyAntiderivative(u_, x_Symbol),
                    If(FreeQ(u, x), C0, If(LogQ(u), Log(RemoveContent(Part(u, C1), x)), If(SumQ(u), SimplifyAntiderivativeSum(Map(Function(SimplifyAntiderivative(Slot1, x)), u), x), u))));
            ISetDelayed(480, SimplifyAntiderivativeSum(Plus(v_DEFAULT, Times(B_DEFAULT, Log(Cos(u_))), Times(A_DEFAULT, Log(Plus(a_, Times(b_DEFAULT, Power(Tan(u_), n_DEFAULT)))))), x_Symbol),
                    Condition(Plus(SimplifyAntiderivativeSum(v, x), Times(ASymbol, Log(RemoveContent(Plus(Times(a, Power(Cos(u), n)), Times(b, Power(Sin(u), n))), x)))), And(FreeQ(List(a, b, ASymbol, BSymbol), x), IntegerQ(n), EqQ(Subtract(Times(n, ASymbol), BSymbol), C0))));
            ISetDelayed(481, SimplifyAntiderivativeSum(Plus(v_DEFAULT, Times(A_DEFAULT, Log(Plus(a_, Times(b_DEFAULT, Power(Cot(u_), n_DEFAULT))))), Times(B_DEFAULT, Log(Sin(u_)))), x_Symbol),
                    Condition(Plus(SimplifyAntiderivativeSum(v, x), Times(ASymbol, Log(RemoveContent(Plus(Times(a, Power(Sin(u), n)), Times(b, Power(Cos(u), n))), x)))), And(FreeQ(List(a, b, ASymbol, BSymbol), x), IntegerQ(n), EqQ(Subtract(Times(n, ASymbol), BSymbol), C0))));
            ISetDelayed(482, SimplifyAntiderivativeSum(Plus(v_DEFAULT, Times(A_DEFAULT, Log(Plus(a_, Times(b_DEFAULT, Power(Tan(u_), n_DEFAULT))))), Times(B_DEFAULT, Log(Plus(c_, Times(d_DEFAULT, Power(Tan(u_), n_DEFAULT)))))), x_Symbol),
                    Condition(Plus(SimplifyAntiderivativeSum(v, x), Times(ASymbol, Log(RemoveContent(Plus(Times(a, Power(Cos(u), n)), Times(b, Power(Sin(u), n))), x))), Times(BSymbol, Log(RemoveContent(Plus(Times(c, Power(Cos(u), n)), Times(d, Power(Sin(u), n))), x)))), And(FreeQ(List(a, b, c, d, ASymbol, BSymbol), x), IntegerQ(n), EqQ(Plus(ASymbol, BSymbol), C0))));
            ISetDelayed(483, SimplifyAntiderivativeSum(Plus(v_DEFAULT, Times(A_DEFAULT, Log(Plus(a_, Times(b_DEFAULT, Power(Cot(u_), n_DEFAULT))))), Times(B_DEFAULT, Log(Plus(c_, Times(d_DEFAULT, Power(Cot(u_), n_DEFAULT)))))), x_Symbol),
                    Condition(Plus(SimplifyAntiderivativeSum(v, x), Times(ASymbol, Log(RemoveContent(Plus(Times(b, Power(Cos(u), n)), Times(a, Power(Sin(u), n))), x))), Times(BSymbol, Log(RemoveContent(Plus(Times(d, Power(Cos(u), n)), Times(c, Power(Sin(u), n))), x)))), And(FreeQ(List(a, b, c, d, ASymbol, BSymbol), x), IntegerQ(n), EqQ(Plus(ASymbol, BSymbol), C0))));
        }
    }
}
