package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Csc;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sec;
import static org.matheclipse.core.expression.F.Simplify;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
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
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumSimplerQ;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules113 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(2826, Int(Times(Power(Times(c_DEFAULT, Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), p_)), n_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(c, IntPart(n)), Power(Times(c, Power(Times(d, Sin(Plus(e, Times(f, x)))), p)), FracPart(n)), Power(Power(Times(d, Sin(Plus(e, Times(f, x)))), Times(p, FracPart(n))), CN1)), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Times(d, Sin(Plus(e, Times(f, x)))), Times(n, p))), x), x), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), Not(IntegerQ(n)))));
            IIntegrate(2827, Int(Times(Power(Plus(a_DEFAULT, Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT)), m_DEFAULT), Power(Times(c_DEFAULT, Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), p_)), n_)), x_Symbol),
                    Condition(Dist(Times(Power(c, IntPart(n)), Power(Times(c, Power(Times(d, Cos(Plus(e, Times(f, x)))), p)), FracPart(n)), Power(Power(Times(d, Cos(Plus(e, Times(f, x)))), Times(p, FracPart(n))), CN1)), Int(Times(Power(Plus(a, Times(b, Cos(Plus(e, Times(f, x))))), m), Power(Times(d, Cos(Plus(e, Times(f, x)))), Times(n, p))), x), x), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), Not(IntegerQ(n)))));
            IIntegrate(2828, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(d, Times(c, Sin(Plus(e, Times(f, x))))), n), Power(Power(Sin(Plus(e, Times(f, x))), n), CN1)), x), And(FreeQ(List(a, b, c, d, e, f, m), x), IntegerQ(n))));
            IIntegrate(2829, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Plus(b, Times(a, Csc(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), n), Power(Power(Csc(Plus(e, Times(f, x))), m), CN1)), x), And(FreeQ(List(a, b, c, d, e, f, n), x), Not(IntegerQ(n)), IntegerQ(m))));
            IIntegrate(2830, Int(Times(Power(Plus(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Int(Times(Power(Plus(b, Times(a, Sec(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sec(Plus(e, Times(f, x))))), n), Power(Power(Sec(Plus(e, Times(f, x))), m), CN1)), x), And(FreeQ(List(a, b, c, d, e, f, n), x), Not(IntegerQ(n)), IntegerQ(m))));
            IIntegrate(2831, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Dist(Times(Power(Sin(Plus(e, Times(f, x))), n), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), n), Power(Power(Plus(d, Times(c, Sin(Plus(e, Times(f, x))))), n), CN1)), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(d, Times(c, Sin(Plus(e, Times(f, x))))), n), Power(Power(Sin(Plus(e, Times(f, x))), n), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f, m, n), x), Not(IntegerQ(n)), Not(IntegerQ(m)))));
            IIntegrate(2832, Int(Times(Power(Plus(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_), Power(Plus(c_, Times(d_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Dist(Times(Power(Cos(Plus(e, Times(f, x))), n), Power(Plus(c, Times(d, Sec(Plus(e, Times(f, x))))), n), Power(Power(Plus(d, Times(c, Cos(Plus(e, Times(f, x))))), n), CN1)), Int(Times(Power(Plus(a, Times(b, Cos(Plus(e, Times(f, x))))), m), Power(Plus(d, Times(c, Cos(Plus(e, Times(f, x))))), n), Power(Power(Cos(Plus(e, Times(f, x))), n), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f, m, n), x), Not(IntegerQ(n)), Not(IntegerQ(m)))));
            IIntegrate(2833, Int(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Times(b, f), CN1), Subst(Int(Times(Power(Plus(a, x), m), Power(Plus(c, Times(d, x, Power(b, CN1))), n)), x), x, Times(b, Sin(Plus(e, Times(f, x))))), x), FreeQ(List(a, b, c, d, e, f, m, n), x)));
            IIntegrate(2834, Int(Times(Power($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), p_), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_DEFAULT), Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Dist(a, Int(Times(Power(Cos(Plus(e, Times(f, x))), p), Power(Times(d, Sin(Plus(e, Times(f, x)))), n)), x), x), Dist(Times(b, Power(d, CN1)), Int(Times(Power(Cos(Plus(e, Times(f, x))), p), Power(Times(d, Sin(Plus(e, Times(f, x)))), Plus(n, C1))), x), x)), And(FreeQ(List(a, b, d, e, f, n, p), x), IntegerQ(Times(C1D2, Subtract(p, C1))), IntegerQ(n), Or(And(LtQ(p, C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0)), LtQ(C0, n, Subtract(p, C1)), LtQ(Plus(p, C1), Negate(n), Plus(Times(C2, p), C1))))));
            IIntegrate(2835, Int(Times(Power($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), p_), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Power(a, CN1), Int(Times(Power(Cos(Plus(e, Times(f, x))), Subtract(p, C2)), Power(Times(d, Sin(Plus(e, Times(f, x)))), n)), x), x), Dist(Power(Times(b, d), CN1), Int(Times(Power(Cos(Plus(e, Times(f, x))), Subtract(p, C2)), Power(Times(d, Sin(Plus(e, Times(f, x)))), Plus(n, C1))), x), x)), And(FreeQ(List(a, b, d, e, f, n, p), x), IntegerQ(Times(C1D2, Subtract(p, C1))), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegerQ(n), Or(LtQ(C0, n, Times(C1D2, Plus(p, C1))), And(LeQ(p, Negate(n)), LtQ(Negate(n), Subtract(Times(C2, p), C3))), And(GtQ(n, C0), LeQ(n, Negate(p)))))));
            IIntegrate(2836, Int(Times(Power($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Times(Power(b, p), f), CN1), Subst(Int(Times(Power(Plus(a, x), Plus(m, Times(C1D2, Subtract(p, C1)))), Power(Subtract(a, x), Times(C1D2, Subtract(p, C1))), Power(Plus(c, Times(d, x, Power(b, CN1))), n)), x), x, Times(b, Sin(Plus(e, Times(f, x))))), x), And(FreeQ(List(a, b, e, f, c, d, m, n), x), IntegerQ(Times(C1D2, Subtract(p, C1))), EqQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(2837, Int(Times(Power($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Times(Power(b, p), f), CN1), Subst(Int(Times(Power(Plus(a, x), m), Power(Plus(c, Times(d, x, Power(b, CN1))), n), Power(Subtract(Sqr(b), Sqr(x)), Times(C1D2, Subtract(p, C1)))), x), x, Times(b, Sin(Plus(e, Times(f, x))))), x), And(FreeQ(List(a, b, c, d, e, f, m, n), x), IntegerQ(Times(C1D2, Subtract(p, C1))), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(2838, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_DEFAULT), Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Dist(a, Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), p), Power(Times(d, Sin(Plus(e, Times(f, x)))), n)), x), x), Dist(Times(b, Power(d, CN1)), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), p), Power(Times(d, Sin(Plus(e, Times(f, x)))), Plus(n, C1))), x), x)), FreeQ(List(a, b, d, e, f, g, n, p), x)));
            IIntegrate(2839, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Times(Sqr(g), Power(a, CN1)), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), Subtract(p, C2)), Power(Times(d, Sin(Plus(e, Times(f, x)))), n)), x), x), Dist(Times(Sqr(g), Power(Times(b, d), CN1)), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), Subtract(p, C2)), Power(Times(d, Sin(Plus(e, Times(f, x)))), Plus(n, C1))), x), x)), And(FreeQ(List(a, b, d, e, f, g, n, p), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(2840, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(a, m), Power(c, m), Power(Power(g, Times(C2, m)), CN1)), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(Times(C2, m), p)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Subtract(n, m))), x), x), And(FreeQ(List(a, b, c, d, e, f, g, n, p), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegerQ(m), Not(And(IntegerQ(n), LtQ(Sqr(n), Sqr(m)))))));
            IIntegrate(2841, Int(Times(Power($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Times(Power(a, Times(C1D2, p)), Power(c, Times(C1D2, p))), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, Times(C1D2, p))), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, Times(C1D2, p)))), x), x), And(FreeQ(List(a, b, c, d, e, f, n, p), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegerQ(Times(C1D2, p)))));
            IIntegrate(2842, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(g, Cos(Plus(e, Times(f, x))), Power(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Sqrt(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))))), CN1)), Int(Power(Times(g, Cos(Plus(e, Times(f, x)))), Subtract(p, C1)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, p), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(2843, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Dist(Times(Power(a, IntPart(m)), Power(c, IntPart(m)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), FracPart(m)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), FracPart(m)), Power(Times(Power(g, Times(C2, IntPart(m))), Power(Times(g, Cos(Plus(e, Times(f, x)))), Times(C2, FracPart(m)))), CN1)), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(Times(C2, m), p)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, m, n, p), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), EqQ(Subtract(Plus(Times(C2, m), p), C1), C0), EqQ(Subtract(Subtract(m, n), C1), C0))));
            IIntegrate(2844, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Simp(Times(b, Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(p, C1)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Power(Times(f, g, Subtract(Subtract(m, n), C1)), CN1)), x), And(FreeQ(List(a, b, c, d, e, f, g, m, n, p), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), EqQ(Subtract(Plus(Times(C2, m), p), C1), C0), NeQ(Subtract(Subtract(m, n), C1), C0))));
            IIntegrate(2845, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Subtract(Simp(Times(CN2, b, Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(p, C1)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Power(Times(f, g, Plus(Times(C2, n), p, C1)), CN1)), x), Dist(Times(b, Subtract(Plus(Times(C2, m), p), C1), Power(Times(d, Plus(Times(C2, n), p, C1)), CN1)), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), p), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, p), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IGtQ(Simplify(Subtract(Plus(m, Times(C1D2, p)), C1D2)), C0), LtQ(n, CN1), NeQ(Plus(Times(C2, n), p, C1), C0), Not(And(ILtQ(Simplify(Plus(m, n, p)), C0), GtQ(Simplify(Plus(Times(C2, m), n, Times(C1D2, C3, p), C1)), C0))))));
            IIntegrate(2846, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(p, C1)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Power(Times(f, g, Plus(m, n, p)), CN1)), x)), Dist(Times(a, Subtract(Plus(Times(C2, m), p), C1), Power(Plus(m, n, p), CN1)), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), p), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, n, p), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IGtQ(Simplify(Subtract(Plus(m, Times(C1D2, p)), C1D2)), C0), Not(LtQ(n, CN1)), Not(And(IGtQ(Simplify(Subtract(Plus(n, Times(C1D2, p)), C1D2)), C0), GtQ(Subtract(m, n), C0))), Not(And(ILtQ(Simplify(Plus(m, n, p)), C0), GtQ(Simplify(Plus(Times(C2, m), n, Times(C1D2, C3, p), C1)), C0))))));
            IIntegrate(2847, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Dist(Times(Power(a, IntPart(m)), Power(c, IntPart(m)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), FracPart(m)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), FracPart(m)), Power(Times(Power(g, Times(C2, IntPart(m))), Power(Times(g, Cos(Plus(e, Times(f, x)))), Times(C2, FracPart(m)))), CN1)), Int(Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(Times(C2, m), p)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, m, p), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), EqQ(Plus(Times(C2, m), p, C1), C0))));
            IIntegrate(2848, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Simp(Times(b, Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(p, C1)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Power(Times(a, f, g, Subtract(m, n)), CN1)), x), And(FreeQ(List(a, b, c, d, e, f, g, m, n, p), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), EqQ(Plus(m, n, p, C1), C0), NeQ(m, n))));
            IIntegrate(2849, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Plus(Simp(Times(b, Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(p, C1)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Power(Times(a, f, g, Plus(Times(C2, m), p, C1)), CN1)), x), Dist(Times(Plus(m, n, p, C1), Power(Times(a, Plus(Times(C2, m), p, C1)), CN1)), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), p), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, m, n, p), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), ILtQ(Simplify(Plus(m, n, p, C1)), C0), NeQ(Plus(Times(C2, m), p, C1), C0), Or(SumSimplerQ(m, C1), Not(SumSimplerQ(n, C1))))));
            IIntegrate(2850, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Subtract(Simp(Times(CN2, b, Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(p, C1)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Power(Times(f, g, Plus(Times(C2, n), p, C1)), CN1)), x), Dist(Times(b, Subtract(Plus(Times(C2, m), p), C1), Power(Times(d, Plus(Times(C2, n), p, C1)), CN1)), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), p), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, p), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), GtQ(m, C0), LtQ(n, CN1), NeQ(Plus(Times(C2, n), p, C1), C0), IntegersQ(Times(C2, m), Times(C2, n), Times(C2, p)))));
        }
    }
}
