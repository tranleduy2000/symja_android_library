package org.matheclipse.core.integrate.rubi;


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
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
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
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.g_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules36 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(901, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(f_, Times(g_DEFAULT, x_)), n_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(d, Times(e, x)), FracPart(m)), Power(Plus(f, Times(g, x)), FracPart(m)), Power(Power(Plus(Times(d, f), Times(e, g, Sqr(x))), FracPart(m)), CN1)), Int(Times(Power(Plus(Times(d, f), Times(e, g, Sqr(x))), m), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, m, n, p), x), EqQ(Subtract(m, n), C0), EqQ(Plus(Times(e, f), Times(d, g)), C0))));
            IIntegrate(902, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(f_, Times(g_DEFAULT, x_)), n_), Power(Plus(a_DEFAULT, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(d, Times(e, x)), FracPart(m)), Power(Plus(f, Times(g, x)), FracPart(m)), Power(Power(Plus(Times(d, f), Times(e, g, Sqr(x))), FracPart(m)), CN1)), Int(Times(Power(Plus(Times(d, f), Times(e, g, Sqr(x))), m), Power(Plus(a, Times(c, Sqr(x))), p)), x), x), And(FreeQ(List(a, c, d, e, f, g, m, n, p), x), EqQ(Subtract(m, n), C0), EqQ(Plus(Times(e, f), Times(d, g)), C0))));
            IIntegrate(903, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Plus(Dist(Times(g, Power(c, CN2)), Int(Times(Simp(Plus(Times(C2, c, e, f), Times(c, d, g), Times(CN1, b, e, g), Times(c, e, g, x)), x), Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(f, Times(g, x)), Subtract(n, C2))), x), x), Dist(Power(c, CN2), Int(Times(Simp(Plus(Times(Sqr(c), d, Sqr(f)), Times(CN1, C2, a, c, e, f, g), Times(CN1, a, c, d, Sqr(g)), Times(a, b, e, Sqr(g)), Times(Subtract(Plus(Times(Sqr(c), e, Sqr(f)), Times(C2, Sqr(c), d, f, g), Times(CN1, C2, b, c, e, f, g), Times(CN1, b, c, d, Sqr(g)), Times(Sqr(b), e, Sqr(g))), Times(a, c, e, Sqr(g))), x)), x), Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(f, Times(g, x)), Subtract(n, C2)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), Not(IntegerQ(m)), Not(IntegerQ(n)), GtQ(m, C0), GtQ(n, C1))));
            IIntegrate(904, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Plus(Dist(Times(g, Power(c, CN1)), Int(Times(Simp(Plus(Times(C2, e, f), Times(d, g), Times(e, g, x)), x), Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(f, Times(g, x)), Subtract(n, C2))), x), x), Dist(Power(c, CN1), Int(Times(Simp(Plus(Times(c, d, Sqr(f)), Times(CN1, C2, a, e, f, g), Times(CN1, a, d, Sqr(g)), Times(Subtract(Plus(Times(c, e, Sqr(f)), Times(C2, c, d, f, g)), Times(a, e, Sqr(g))), x)), x), Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(f, Times(g, x)), Subtract(n, C2)), Power(Plus(a, Times(c, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, c, d, e, f, g), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IntegerQ(m)), Not(IntegerQ(n)), GtQ(m, C0), GtQ(n, C1))));
            IIntegrate(905, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Plus(Dist(Times(e, g, Power(c, CN1)), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(f, Times(g, x)), Subtract(n, C1))), x), x), Dist(Power(c, CN1), Int(Times(Simp(Plus(Times(c, d, f), Times(CN1, a, e, g), Times(Subtract(Plus(Times(c, e, f), Times(c, d, g)), Times(b, e, g)), x)), x), Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(f, Times(g, x)), Subtract(n, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), Not(IntegerQ(m)), Not(IntegerQ(n)), GtQ(m, C0), GtQ(n, C0))));
            IIntegrate(906, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Plus(Dist(Times(e, g, Power(c, CN1)), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(f, Times(g, x)), Subtract(n, C1))), x), x), Dist(Power(c, CN1), Int(Times(Simp(Plus(Times(c, d, f), Times(CN1, a, e, g), Times(Plus(Times(c, e, f), Times(c, d, g)), x)), x), Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(f, Times(g, x)), Subtract(n, C1)), Power(Plus(a, Times(c, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, c, d, e, f, g), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IntegerQ(m)), Not(IntegerQ(n)), GtQ(m, C0), GtQ(n, C0))));
            IIntegrate(907, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Plus(Negate(Dist(Times(g, Subtract(Times(e, f), Times(d, g)), Power(Plus(Times(c, Sqr(f)), Times(CN1, b, f, g), Times(a, Sqr(g))), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(f, Times(g, x)), n)), x), x)), Dist(Power(Plus(Times(c, Sqr(f)), Times(CN1, b, f, g), Times(a, Sqr(g))), CN1), Int(Times(Simp(Plus(Times(c, d, f), Times(CN1, b, d, g), Times(a, e, g), Times(c, Subtract(Times(e, f), Times(d, g)), x)), x), Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(f, Times(g, x)), Plus(n, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), Not(IntegerQ(m)), Not(IntegerQ(n)), GtQ(m, C0), LtQ(n, CN1))));
            IIntegrate(908, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Plus(Negate(Dist(Times(g, Subtract(Times(e, f), Times(d, g)), Power(Plus(Times(c, Sqr(f)), Times(a, Sqr(g))), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(f, Times(g, x)), n)), x), x)), Dist(Power(Plus(Times(c, Sqr(f)), Times(a, Sqr(g))), CN1), Int(Times(Simp(Plus(Times(c, d, f), Times(a, e, g), Times(c, Subtract(Times(e, f), Times(d, g)), x)), x), Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(f, Times(g, x)), Plus(n, C1)), Power(Plus(a, Times(c, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, c, d, e, f, g), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IntegerQ(m)), Not(IntegerQ(n)), GtQ(m, C0), LtQ(n, CN1))));
            IIntegrate(909, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), CN1D2), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Times(Sqrt(Plus(d, Times(e, x))), Sqrt(Plus(f, Times(g, x)))), CN1), Times(Power(Plus(d, Times(e, x)), Plus(m, C1D2)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), IGtQ(Plus(m, C1D2), C0))));
            IIntegrate(910, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), CN1D2), Power(Plus(a_DEFAULT, Times(c_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Times(Sqrt(Plus(d, Times(e, x))), Sqrt(Plus(f, Times(g, x)))), CN1), Times(Power(Plus(d, Times(e, x)), Plus(m, C1D2)), Power(Plus(a, Times(c, Sqr(x))), CN1)), x), x), And(FreeQ(List(a, c, d, e, f, g), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), IGtQ(Plus(m, C1D2), C0))));
            IIntegrate(911, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(d, Times(e, x)), m), Power(Plus(f, Times(g, x)), n)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), CN1), x), x), And(FreeQ(List(a, b, c, d, e, f, g, m, n), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), Not(IntegerQ(m)), Not(IntegerQ(n)))));
            IIntegrate(912, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(d, Times(e, x)), m), Power(Plus(f, Times(g, x)), n)), Power(Plus(a, Times(c, Sqr(x))), CN1), x), x), And(FreeQ(List(a, c, d, e, f, g, m, n), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IntegerQ(m)), Not(IntegerQ(n)))));
            IIntegrate(913, Int(Times(Sqr(x_), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Simp(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Times(c, e, Plus(m, Times(C2, p), C3)), CN1)), x), And(FreeQ(List(a, b, c, d, e, m, p), x), EqQ(Plus(Times(b, e, Plus(m, p, C2)), Times(C2, c, d, Plus(p, C1))), C0), EqQ(Plus(Times(b, d, Plus(p, C1)), Times(a, e, Plus(m, C1))), C0), NeQ(Plus(m, Times(C2, p), C3), C0))));
            IIntegrate(914, Int(Times(Sqr(x_), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_DEFAULT, Times(c_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Simp(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1)), Power(Times(c, e, Plus(m, Times(C2, p), C3)), CN1)), x), And(FreeQ(List(a, c, d, e, m, p), x), EqQ(Times(d, Plus(p, C1)), C0), EqQ(Times(a, Plus(m, C1)), C0), NeQ(Plus(m, Times(C2, p), C3), C0))));
            IIntegrate(915, Int(Times(Power(Times(g_DEFAULT, x_), n_), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(a_, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(d, Times(e, x)), FracPart(p)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), FracPart(p)), Power(Power(Plus(Times(a, d), Times(c, e, Power(x, C3))), FracPart(p)), CN1)), Int(Times(Power(Times(g, x), n), Power(Plus(Times(a, d), Times(c, e, Power(x, C3))), p)), x), x), And(FreeQ(List(a, b, c, d, e, g, m, n, p), x), EqQ(Subtract(m, p), C0), EqQ(Plus(Times(b, d), Times(a, e)), C0), EqQ(Plus(Times(c, d), Times(b, e)), C0))));
            IIntegrate(916, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_DEFAULT), Sqrt(Plus(f_DEFAULT, Times(g_DEFAULT, x_))), Sqrt(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))))), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Sqrt(Plus(f, Times(g, x))), Sqrt(Plus(a, Times(b, x), Times(c, Sqr(x)))), Power(Times(e, Plus(m, C1)), CN1)), x), Dist(Power(Times(C2, e, Plus(m, C1)), CN1), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Simp(Plus(Times(b, f), Times(a, g), Times(C2, Plus(Times(c, f), Times(b, g)), x), Times(C3, c, g, Sqr(x))), x), Power(Times(Sqrt(Plus(f, Times(g, x))), Sqrt(Plus(a, Times(b, x), Times(c, Sqr(x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), IntegerQ(Times(C2, m)), LtQ(m, CN1))));
            IIntegrate(917, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_DEFAULT), Sqrt(Plus(f_DEFAULT, Times(g_DEFAULT, x_))), Sqrt(Plus(a_, Times(c_DEFAULT, Sqr(x_))))), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Sqrt(Plus(f, Times(g, x))), Sqrt(Plus(a, Times(c, Sqr(x)))), Power(Times(e, Plus(m, C1)), CN1)), x), Dist(Power(Times(C2, e, Plus(m, C1)), CN1), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Simp(Plus(Times(a, g), Times(C2, c, f, x), Times(C3, c, g, Sqr(x))), x), Power(Times(Sqrt(Plus(f, Times(g, x))), Sqrt(Plus(a, Times(c, Sqr(x))))), CN1)), x), x)), And(FreeQ(List(a, c, d, e, f, g), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), IntegerQ(Times(C2, m)), LtQ(m, CN1))));
            IIntegrate(918, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_DEFAULT), Sqrt(Plus(f_DEFAULT, Times(g_DEFAULT, x_))), Sqrt(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))))), x_Symbol),
                    Condition(Subtract(Simp(Times(C2, Power(Plus(d, Times(e, x)), Plus(m, C1)), Sqrt(Plus(f, Times(g, x))), Sqrt(Plus(a, Times(b, x), Times(c, Sqr(x)))), Power(Times(e, Plus(Times(C2, m), C5)), CN1)), x), Dist(Power(Times(e, Plus(Times(C2, m), C5)), CN1), Int(Times(Power(Plus(d, Times(e, x)), m), Simp(Subtract(Plus(Times(b, d, f), Times(CN1, C3, a, e, f), Times(a, d, g), Times(C2, Subtract(Plus(Times(c, d, f), Times(CN1, b, e, f), Times(b, d, g)), Times(a, e, g)), x)), Times(Plus(Times(c, e, f), Times(CN1, C3, c, d, g), Times(b, e, g)), Sqr(x))), x), Power(Times(Sqrt(Plus(f, Times(g, x))), Sqrt(Plus(a, Times(b, x), Times(c, Sqr(x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, m), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), IntegerQ(Times(C2, m)), Not(LtQ(m, CN1)))));
            IIntegrate(919, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_DEFAULT), Sqrt(Plus(f_DEFAULT, Times(g_DEFAULT, x_))), Sqrt(Plus(a_, Times(c_DEFAULT, Sqr(x_))))), x_Symbol),
                    Condition(Plus(Simp(Times(C2, Power(Plus(d, Times(e, x)), Plus(m, C1)), Sqrt(Plus(f, Times(g, x))), Sqrt(Plus(a, Times(c, Sqr(x)))), Power(Times(e, Plus(Times(C2, m), C5)), CN1)), x), Dist(Power(Times(e, Plus(Times(C2, m), C5)), CN1), Int(Times(Power(Plus(d, Times(e, x)), m), Simp(Plus(Times(C3, a, e, f), Times(CN1, a, d, g), Times(CN1, C2, Subtract(Times(c, d, f), Times(a, e, g)), x), Times(Subtract(Times(c, e, f), Times(C3, c, d, g)), Sqr(x))), x), Power(Times(Sqrt(Plus(f, Times(g, x))), Sqrt(Plus(a, Times(c, Sqr(x))))), CN1)), x), x)), And(FreeQ(List(a, c, d, e, f, g, m), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), IntegerQ(Times(C2, m)), Not(LtQ(m, CN1)))));
            IIntegrate(920, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_DEFAULT), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), CN1D2), Sqrt(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))))), x_Symbol),
                    Condition(Subtract(Simp(Times(C2, Power(Plus(d, Times(e, x)), m), Sqrt(Plus(f, Times(g, x))), Sqrt(Plus(a, Times(b, x), Times(c, Sqr(x)))), Power(Times(g, Plus(Times(C2, m), C3)), CN1)), x), Dist(Power(Times(g, Plus(Times(C2, m), C3)), CN1), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C1)), Simp(Subtract(Plus(Times(b, d, f), Times(C2, a, Subtract(Times(e, f, m), Times(d, g, Plus(m, C1)))), Times(Plus(Times(C2, c, d, f), Times(CN1, C2, a, e, g), Times(b, Subtract(Times(e, f), Times(d, g)), Plus(Times(C2, m), C1))), x)), Times(Plus(Times(b, e, g), Times(C2, c, Subtract(Times(d, g, m), Times(e, f, Plus(m, C1))))), Sqr(x))), x), Power(Times(Sqrt(Plus(f, Times(g, x))), Sqrt(Plus(a, Times(b, x), Times(c, Sqr(x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), IntegerQ(Times(C2, m)), GtQ(m, C0))));
            IIntegrate(921, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_DEFAULT), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), CN1D2), Sqrt(Plus(a_, Times(c_DEFAULT, Sqr(x_))))), x_Symbol),
                    Condition(Subtract(Simp(Times(C2, Power(Plus(d, Times(e, x)), m), Sqrt(Plus(f, Times(g, x))), Sqrt(Plus(a, Times(c, Sqr(x)))), Power(Times(g, Plus(Times(C2, m), C3)), CN1)), x), Dist(Power(Times(g, Plus(Times(C2, m), C3)), CN1), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C1)), Simp(Subtract(Plus(Times(C2, a, Subtract(Times(e, f, m), Times(d, g, Plus(m, C1)))), Times(Subtract(Times(C2, c, d, f), Times(C2, a, e, g)), x)), Times(C2, c, Subtract(Times(d, g, m), Times(e, f, Plus(m, C1))), Sqr(x))), x), Power(Times(Sqrt(Plus(f, Times(g, x))), Sqrt(Plus(a, Times(c, Sqr(x))))), CN1)), x), x)), And(FreeQ(List(a, c, d, e, f, g), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), IntegerQ(Times(C2, m)), GtQ(m, C0))));
            IIntegrate(922, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), CN1), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), CN1D2), Sqrt(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))))), x_Symbol),
                    Condition(Subtract(Dist(Times(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), Power(e, CN2)), Int(Power(Times(Plus(d, Times(e, x)), Sqrt(Plus(f, Times(g, x))), Sqrt(Plus(a, Times(b, x), Times(c, Sqr(x))))), CN1), x), x), Dist(Power(e, CN2), Int(Times(Subtract(Subtract(Times(c, d), Times(b, e)), Times(c, e, x)), Power(Times(Sqrt(Plus(f, Times(g, x))), Sqrt(Plus(a, Times(b, x), Times(c, Sqr(x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0))));
            IIntegrate(923, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), CN1), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), CN1D2), Sqrt(Plus(a_, Times(c_DEFAULT, Sqr(x_))))), x_Symbol),
                    Condition(Subtract(Dist(Times(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), Power(e, CN2)), Int(Power(Times(Plus(d, Times(e, x)), Sqrt(Plus(f, Times(g, x))), Sqrt(Plus(a, Times(c, Sqr(x))))), CN1), x), x), Dist(Power(e, CN2), Int(Times(Subtract(Times(c, d), Times(c, e, x)), Power(Times(Sqrt(Plus(f, Times(g, x))), Sqrt(Plus(a, Times(c, Sqr(x))))), CN1)), x), x)), And(FreeQ(List(a, c, d, e, f, g), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0))));
            IIntegrate(924, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_DEFAULT), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), CN1D2), Sqrt(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))))), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Sqrt(Plus(f, Times(g, x))), Sqrt(Plus(a, Times(b, x), Times(c, Sqr(x)))), Power(Times(Plus(m, C1), Subtract(Times(e, f), Times(d, g))), CN1)), x), Dist(Power(Times(C2, Plus(m, C1), Subtract(Times(e, f), Times(d, g))), CN1), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Simp(Plus(Times(b, f), Times(a, g, Plus(Times(C2, m), C3)), Times(C2, Plus(Times(c, f), Times(b, g, Plus(m, C2))), x), Times(c, g, Plus(Times(C2, m), C5), Sqr(x))), x), Power(Times(Sqrt(Plus(f, Times(g, x))), Sqrt(Plus(a, Times(b, x), Times(c, Sqr(x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), IntegerQ(Times(C2, m)), LtQ(m, CN1))));
            IIntegrate(925, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_DEFAULT), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), CN1D2), Sqrt(Plus(a_, Times(c_DEFAULT, Sqr(x_))))), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Sqrt(Plus(f, Times(g, x))), Sqrt(Plus(a, Times(c, Sqr(x)))), Power(Times(Plus(m, C1), Subtract(Times(e, f), Times(d, g))), CN1)), x), Dist(Power(Times(C2, Plus(m, C1), Subtract(Times(e, f), Times(d, g))), CN1), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Simp(Plus(Times(a, g, Plus(Times(C2, m), C3)), Times(C2, c, f, x), Times(c, g, Plus(Times(C2, m), C5), Sqr(x))), x), Power(Times(Sqrt(Plus(f, Times(g, x))), Sqrt(Plus(a, Times(c, Sqr(x))))), CN1)), x), x)), And(FreeQ(List(a, c, d, e, f, g), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), IntegerQ(Times(C2, m)), LtQ(m, CN1))));
        }
    }
}
