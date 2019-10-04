package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.C5;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.CN4;
import static org.matheclipse.core.expression.F.CN6;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Cot;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Simplify;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Tan;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.ZZ;
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
import static org.matheclipse.core.expression.F.g_;
import static org.matheclipse.core.expression.F.g_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumSimplerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules109 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(2726, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), CN6)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(C5, a, f, Power(Sin(Plus(e, Times(f, x))), C5)), CN1)), x)), Dist(Power(Times(ZZ(20L), Sqr(a), Sqr(b), m, Subtract(m, C1)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Simp(Subtract(Plus(Times(ZZ(60L), Power(a, C4)), Times(CN1, ZZ(44L), Sqr(a), Sqr(b), Subtract(m, C1), m), Times(Power(b, C4), m, Subtract(m, C1), Subtract(m, C3), Subtract(m, C4)), Times(a, b, m, Subtract(Times(ZZ(20L), Sqr(a)), Times(Sqr(b), m, Subtract(m, C1))), Sin(Plus(e, Times(f, x))))), Times(Subtract(Plus(Times(ZZ(40L), Power(a, C4)), Times(Power(b, C4), m, Subtract(m, C1), Subtract(m, C2), Subtract(m, C4))), Times(ZZ(20L), Sqr(a), Sqr(b), Subtract(m, C1), Plus(Times(C2, m), C1))), Sqr(Sin(Plus(e, Times(f, x)))))), x), Power(Sin(Plus(e, Times(f, x))), CN4)), x), x), Simp(Times(Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(b, f, m, Sqr(Sin(Plus(e, Times(f, x))))), CN1)), x), Simp(Times(a, Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(Sqr(b), f, m, Subtract(m, C1), Power(Sin(Plus(e, Times(f, x))), C3)), CN1)), x), Negate(Simp(Times(b, Subtract(m, C4), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(ZZ(20L), Sqr(a), f, Power(Sin(Plus(e, Times(f, x))), C4)), CN1)), x))), And(FreeQ(List(a, b, e, f, m), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(m, C1), IntegerQ(Times(C2, m)))));
            IIntegrate(2727, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1), Power(Times(g_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), p_)), x_Symbol),
                    Condition(Plus(Dist(Times(a, Power(Subtract(Sqr(a), Sqr(b)), CN1)), Int(Times(Power(Times(g, Tan(Plus(e, Times(f, x)))), p), Power(Sin(Plus(e, Times(f, x))), CN2)), x), x), Negate(Dist(Times(b, g, Power(Subtract(Sqr(a), Sqr(b)), CN1)), Int(Times(Power(Times(g, Tan(Plus(e, Times(f, x)))), Subtract(p, C1)), Power(Cos(Plus(e, Times(f, x))), CN1)), x), x)), Negate(Dist(Times(Sqr(a), Sqr(g), Power(Subtract(Sqr(a), Sqr(b)), CN1)), Int(Times(Power(Times(g, Tan(Plus(e, Times(f, x)))), Subtract(p, C2)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), CN1)), x), x))), And(FreeQ(List(a, b, e, f, g), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), IntegersQ(Times(C2, p)), GtQ(p, C1))));
            IIntegrate(2728, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1), Power(Times(g_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), p_)), x_Symbol),
                    Condition(Plus(Dist(Power(a, CN1), Int(Times(Power(Times(g, Tan(Plus(e, Times(f, x)))), p), Power(Cos(Plus(e, Times(f, x))), CN2)), x), x), Negate(Dist(Times(b, Power(Times(Sqr(a), g), CN1)), Int(Times(Power(Times(g, Tan(Plus(e, Times(f, x)))), Plus(p, C1)), Power(Cos(Plus(e, Times(f, x))), CN1)), x), x)), Negate(Dist(Times(Subtract(Sqr(a), Sqr(b)), Power(Times(Sqr(a), Sqr(g)), CN1)), Int(Times(Power(Times(g, Tan(Plus(e, Times(f, x)))), Plus(p, C2)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), CN1)), x), x))), And(FreeQ(List(a, b, e, f, g), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), IntegersQ(Times(C2, p)), LtQ(p, CN1))));
            IIntegrate(2729, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1), Sqrt(Times(g_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Dist(Times(Sqrt(Cos(Plus(e, Times(f, x)))), Sqrt(Times(g, Tan(Plus(e, Times(f, x))))), Power(Sin(Plus(e, Times(f, x))), CN1D2)), Int(Times(Sqrt(Sin(Plus(e, Times(f, x)))), Power(Times(Sqrt(Cos(Plus(e, Times(f, x)))), Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), CN1)), x), x), And(FreeQ(List(a, b, e, f, g), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(2730, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1), Power(Times(g_, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Sin(Plus(e, Times(f, x)))), Power(Times(Sqrt(Cos(Plus(e, Times(f, x)))), Sqrt(Times(g, Tan(Plus(e, Times(f, x)))))), CN1)), Int(Times(Sqrt(Cos(Plus(e, Times(f, x)))), Power(Times(Sqrt(Sin(Plus(e, Times(f, x)))), Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), CN1)), x), x), And(FreeQ(List(a, b, e, f, g), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(2731, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), p_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Sin(Plus(e, Times(f, x))), p), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Power(Subtract(C1, Sqr(Sin(Plus(e, Times(f, x))))), Times(C1D2, p)), CN1)), x), x), And(FreeQ(List(a, b, e, f), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), IntegersQ(m, Times(C1D2, p)))));
            IIntegrate(2732, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Times(g_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), p_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Times(g, Tan(Plus(e, Times(f, x)))), p)), x), FreeQ(List(a, b, e, f, g, m, p), x)));
            IIntegrate(2733, Int(Times(Power(Times($($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(g, Times(C2, IntPart(p))), Power(Times(g, Cot(Plus(e, Times(f, x)))), FracPart(p)), Power(Times(g, Tan(Plus(e, Times(f, x)))), FracPart(p))), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Power(Times(g, Tan(Plus(e, Times(f, x)))), p), CN1)), x), x), And(FreeQ(List(a, b, e, f, g, m, p), x), Not(IntegerQ(p)))));
            IIntegrate(2734, Int(Times(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Simp(Times(C1D2, Plus(Times(C2, a, c), Times(b, d)), x), x), Negate(Simp(Times(Plus(Times(b, c), Times(a, d)), Cos(Plus(e, Times(f, x))), Power(f, CN1)), x)), Negate(Simp(Times(b, d, Cos(Plus(e, Times(f, x))), Sin(Plus(e, Times(f, x))), Power(Times(C2, f), CN1)), x))), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0))));
            IIntegrate(2735, Int(Times(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(b, x, Power(d, CN1)), x), Dist(Times(Subtract(Times(b, c), Times(a, d)), Power(d, CN1)), Int(Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), CN1), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0))));
            IIntegrate(2736, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(a, m), Power(c, m)), Int(Times(Power(Cos(Plus(e, Times(f, x))), Times(C2, m)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Subtract(n, m))), x), x), And(FreeQ(List(a, b, c, d, e, f, n), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegerQ(m), Not(And(IntegerQ(n), Or(And(LtQ(m, C0), GtQ(n, C0)), LtQ(C0, n, m), LtQ(m, n, C0)))))));
            IIntegrate(2737, Int(Times(Sqrt(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(a, c, Cos(Plus(e, Times(f, x))), Power(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Sqrt(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))))), CN1)), Int(Times(Cos(Plus(e, Times(f, x))), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(2738, Int(Times(Sqrt(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Simp(Times(CN2, b, Cos(Plus(e, Times(f, x))), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Power(Times(f, Plus(Times(C2, n), C1), Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))))), CN1)), x), And(FreeQ(List(a, b, c, d, e, f, n), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(n, Negate(C1D2)))));
            IIntegrate(2739, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Subtract(Simp(Times(CN2, b, Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Power(Times(f, Plus(Times(C2, n), C1)), CN1)), x), Dist(Times(b, Subtract(Times(C2, m), C1), Power(Times(d, Plus(Times(C2, n), C1)), CN1)), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IGtQ(Subtract(m, C1D2), C0), LtQ(n, CN1), Not(And(ILtQ(Plus(m, n), C0), GtQ(Plus(Times(C2, m), n, C1), C0))))));
            IIntegrate(2740, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Power(Times(f, Plus(m, n)), CN1)), x)), Dist(Times(a, Subtract(Times(C2, m), C1), Power(Plus(m, n), CN1)), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n)), x), x)), And(FreeQ(List(a, b, c, d, e, f, n), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IGtQ(Subtract(m, C1D2), C0), Not(LtQ(n, CN1)), Not(And(IGtQ(Subtract(n, C1D2), C0), LtQ(n, m))), Not(And(ILtQ(Plus(m, n), C0), GtQ(Plus(Times(C2, m), n, C1), C0))))));
            IIntegrate(2741, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Cos(Plus(e, Times(f, x))), Power(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Sqrt(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))))), CN1)), Int(Power(Cos(Plus(e, Times(f, x))), CN1), x), x), And(FreeQ(List(a, b, c, d, e, f), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(2742, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Simp(Times(b, Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Power(Times(a, f, Plus(Times(C2, m), C1)), CN1)), x), And(FreeQ(List(a, b, c, d, e, f, m, n), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), EqQ(Plus(m, n, C1), C0), NeQ(m, Negate(C1D2)))));
            IIntegrate(2743, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Plus(Simp(Times(b, Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Power(Times(a, f, Plus(Times(C2, m), C1)), CN1)), x), Dist(Times(Plus(m, n, C1), Power(Times(a, Plus(Times(C2, m), C1)), CN1)), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n)), x), x)), And(FreeQ(List(a, b, c, d, e, f, m, n), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), ILtQ(Simplify(Plus(m, n, C1)), C0), NeQ(m, Negate(C1D2)), Or(SumSimplerQ(m, C1), Not(SumSimplerQ(n, C1))))));
            IIntegrate(2744, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Plus(Simp(Times(b, Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Power(Times(a, f, Plus(Times(C2, m), C1)), CN1)), x), Dist(Times(Plus(m, n, C1), Power(Times(a, Plus(Times(C2, m), C1)), CN1)), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n)), x), x)), And(FreeQ(List(a, b, c, d, e, f, n), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), LtQ(m, CN1), Not(LtQ(m, n, CN1)), IntegersQ(Times(C2, m), Times(C2, n)))));
            IIntegrate(2745, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Dist(Times(Power(a, IntPart(m)), Power(c, IntPart(m)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), FracPart(m)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), FracPart(m)), Power(Power(Cos(Plus(e, Times(f, x))), Times(C2, FracPart(m))), CN1)), Int(Times(Power(Cos(Plus(e, Times(f, x))), Times(C2, m)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Subtract(n, m))), x), x), And(FreeQ(List(a, b, c, d, e, f, m, n), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), Or(FractionQ(m), Not(FractionQ(n))))));
            IIntegrate(2746, Int(Times(Sqr(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Sqr(b), Cos(Plus(e, Times(f, x))), Power(Times(d, f), CN1)), x)), Dist(Power(d, CN1), Int(Times(Simp(Subtract(Times(Sqr(a), d), Times(b, Subtract(Times(b, c), Times(C2, a, d)), Sin(Plus(e, Times(f, x))))), x), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0))));
            IIntegrate(2747, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Times(b, Power(Subtract(Times(b, c), Times(a, d)), CN1)), Int(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), CN1), x), x), Dist(Times(d, Power(Subtract(Times(b, c), Times(a, d)), CN1)), Int(Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), CN1), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0))));
            IIntegrate(2748, Int(Times(Power(Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_), Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Dist(c, Int(Power(Times(b, Sin(Plus(e, Times(f, x)))), m), x), x), Dist(Times(d, Power(b, CN1)), Int(Power(Times(b, Sin(Plus(e, Times(f, x)))), Plus(m, C1)), x), x)), FreeQ(List(b, c, d, e, f, m), x)));
            IIntegrate(2749, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Negate(Simp(Times(d, Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Times(f, Plus(m, C1)), CN1)), x)), And(FreeQ(List(a, b, c, d, e, f, m), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), EqQ(Plus(Times(a, d, m), Times(b, c, Plus(m, C1))), C0))));
            IIntegrate(2750, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Simp(Times(Subtract(Times(b, c), Times(a, d)), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Times(a, f, Plus(Times(C2, m), C1)), CN1)), x), Dist(Times(Plus(Times(a, d, m), Times(b, c, Plus(m, C1))), Power(Times(a, b, Plus(Times(C2, m), C1)), CN1)), Int(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), LtQ(m, Negate(C1D2)))));
        }
    }
}
