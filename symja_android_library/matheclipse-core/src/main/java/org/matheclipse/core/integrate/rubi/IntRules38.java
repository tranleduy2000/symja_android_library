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
import static org.matheclipse.core.expression.F.CN4;
import static org.matheclipse.core.expression.F.Coefficient;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.LeafCount;
import static org.matheclipse.core.expression.F.LessEqual;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
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
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules38 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(951, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(c, p), Power(Plus(d, Times(e, x)), Plus(m, Times(C2, p))), Power(Plus(f, Times(g, x)), Plus(n, C1)), Power(Times(g, Power(e, Times(C2, p)), Plus(m, n, Times(C2, p), C1)), CN1)), x), Dist(Power(Times(g, Power(e, Times(C2, p)), Plus(m, n, Times(C2, p), C1)), CN1), Int(Times(Power(Plus(d, Times(e, x)), m), Power(Plus(f, Times(g, x)), n), ExpandToSum(Subtract(Times(g, Plus(m, n, Times(C2, p), C1), Subtract(Times(Power(e, Times(C2, p)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), Times(Power(c, p), Power(Plus(d, Times(e, x)), Times(C2, p))))), Times(Power(c, p), Subtract(Times(e, f), Times(d, g)), Plus(m, Times(C2, p)), Power(Plus(d, Times(e, x)), Subtract(Times(C2, p), C1)))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), IGtQ(p, C0), NeQ(Plus(m, n, Times(C2, p), C1), C0), Or(IntegerQ(n), Not(IntegerQ(m))))));
            IIntegrate(952, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(c, p), Power(Plus(d, Times(e, x)), Plus(m, Times(C2, p))), Power(Plus(f, Times(g, x)), Plus(n, C1)), Power(Times(g, Power(e, Times(C2, p)), Plus(m, n, Times(C2, p), C1)), CN1)), x), Dist(Power(Times(g, Power(e, Times(C2, p)), Plus(m, n, Times(C2, p), C1)), CN1), Int(Times(Power(Plus(d, Times(e, x)), m), Power(Plus(f, Times(g, x)), n), ExpandToSum(Subtract(Times(g, Plus(m, n, Times(C2, p), C1), Subtract(Times(Power(e, Times(C2, p)), Power(Plus(a, Times(c, Sqr(x))), p)), Times(Power(c, p), Power(Plus(d, Times(e, x)), Times(C2, p))))), Times(Power(c, p), Subtract(Times(e, f), Times(d, g)), Plus(m, Times(C2, p)), Power(Plus(d, Times(e, x)), Subtract(Times(C2, p), C1)))), x)), x), x)), And(FreeQ(List(a, c, d, e, f, g), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), IGtQ(p, C0), NeQ(Plus(m, n, Times(C2, p), C1), C0), Or(IntegerQ(n), Not(IntegerQ(m))))));
            IIntegrate(953, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), CN1), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Subtract(Dist(Times(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), Power(Times(e, Subtract(Times(e, f), Times(d, g))), CN1)), Int(Times(Power(Plus(f, Times(g, x)), Plus(n, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Subtract(p, C1)), Power(Plus(d, Times(e, x)), CN1)), x), x), Dist(Power(Times(e, Subtract(Times(e, f), Times(d, g))), CN1), Int(Times(Power(Plus(f, Times(g, x)), n), Subtract(Plus(Times(c, d, f), Times(CN1, b, e, f), Times(a, e, g)), Times(c, Subtract(Times(e, f), Times(d, g)), x)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Subtract(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), Not(IntegerQ(n)), Not(IntegerQ(p)), GtQ(p, C0), LtQ(n, CN1))));
            IIntegrate(954, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), CN1), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Subtract(Dist(Times(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), Power(Times(e, Subtract(Times(e, f), Times(d, g))), CN1)), Int(Times(Power(Plus(f, Times(g, x)), Plus(n, C1)), Power(Plus(a, Times(c, Sqr(x))), Subtract(p, C1)), Power(Plus(d, Times(e, x)), CN1)), x), x), Dist(Power(Times(e, Subtract(Times(e, f), Times(d, g))), CN1), Int(Times(Power(Plus(f, Times(g, x)), n), Subtract(Plus(Times(c, d, f), Times(a, e, g)), Times(c, Subtract(Times(e, f), Times(d, g)), x)), Power(Plus(a, Times(c, Sqr(x))), Subtract(p, C1))), x), x)), And(FreeQ(List(a, c, d, e, f, g), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IntegerQ(n)), Not(IntegerQ(p)), GtQ(p, C0), LtQ(n, CN1))));
            IIntegrate(955, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), CN1), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Plus(Dist(Times(e, Subtract(Times(e, f), Times(d, g)), Power(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), CN1)), Int(Times(Power(Plus(f, Times(g, x)), Subtract(n, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Plus(d, Times(e, x)), CN1)), x), x), Dist(Power(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), CN1), Int(Times(Power(Plus(f, Times(g, x)), Subtract(n, C1)), Subtract(Plus(Times(c, d, f), Times(CN1, b, e, f), Times(a, e, g)), Times(c, Subtract(Times(e, f), Times(d, g)), x)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), Not(IntegerQ(n)), Not(IntegerQ(p)), LtQ(p, CN1), GtQ(n, C0))));
            IIntegrate(956, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), CN1), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Plus(Dist(Times(e, Subtract(Times(e, f), Times(d, g)), Power(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1)), Int(Times(Power(Plus(f, Times(g, x)), Subtract(n, C1)), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1)), Power(Plus(d, Times(e, x)), CN1)), x), x), Dist(Power(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1), Int(Times(Power(Plus(f, Times(g, x)), Subtract(n, C1)), Subtract(Plus(Times(c, d, f), Times(a, e, g)), Times(c, Subtract(Times(e, f), Times(d, g)), x)), Power(Plus(a, Times(c, Sqr(x))), p)), x), x)), And(FreeQ(List(a, c, d, e, f, g), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IntegerQ(n)), Not(IntegerQ(p)), LtQ(p, CN1), GtQ(n, C0))));
            IIntegrate(957, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), CN1), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Times(Sqrt(Plus(f, Times(g, x))), Sqrt(Plus(a, Times(b, x), Times(c, Sqr(x))))), CN1), Times(Power(Plus(f, Times(g, x)), Plus(n, C1D2)), Power(Plus(d, Times(e, x)), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), IntegerQ(Plus(n, C1D2)))));
            IIntegrate(958, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), CN1), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Times(Sqrt(Plus(f, Times(g, x))), Sqrt(Plus(a, Times(c, Sqr(x))))), CN1), Times(Power(Plus(f, Times(g, x)), Plus(n, C1D2)), Power(Plus(d, Times(e, x)), CN1)), x), x), And(FreeQ(List(a, c, d, e, f, g), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), IntegerQ(Plus(n, C1D2)))));
            IIntegrate(959, Int(Times(Power(Times(g_DEFAULT, x_), n_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, x_)), CN1), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Subtract(Dist(Times(d, Power(Times(g, x), n), Power(Power(x, n), CN1)), Int(Times(Power(x, n), Power(Plus(a, Times(c, Sqr(x))), p), Power(Subtract(Sqr(d), Times(Sqr(e), Sqr(x))), CN1)), x), x), Dist(Times(e, Power(Times(g, x), n), Power(Power(x, n), CN1)), Int(Times(Power(x, Plus(n, C1)), Power(Plus(a, Times(c, Sqr(x))), p), Power(Subtract(Sqr(d), Times(Sqr(e), Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, c, d, e, g, n, p), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IntegerQ(p)), Not(IntegersQ(n, Times(C2, p))))));
            IIntegrate(960, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(d, Times(e, x)), m), Power(Plus(f, Times(g, x)), n), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), x), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), Or(IntegerQ(p), And(ILtQ(m, C0), ILtQ(n, C0))), Not(Or(IGtQ(m, C0), IGtQ(n, C0))))));
            IIntegrate(961, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(d, Times(e, x)), m), Power(Plus(f, Times(g, x)), n), Power(Plus(a, Times(c, Sqr(x))), p)), x), x), And(FreeQ(List(a, c, d, e, f, g), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Or(IntegerQ(p), And(ILtQ(m, C0), ILtQ(n, C0))), Not(Or(IGtQ(m, C0), IGtQ(n, C0))))));
            IIntegrate(962, Int(Times(Power(Times(g_DEFAULT, x_), n_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Times(g, x), n), Power(Power(x, n), CN1)), Int(ExpandIntegrand(Times(Power(x, n), Power(Plus(a, Times(c, Sqr(x))), p)), Power(Subtract(Times(d, Power(Subtract(Sqr(d), Times(Sqr(e), Sqr(x))), CN1)), Times(e, x, Power(Subtract(Sqr(d), Times(Sqr(e), Sqr(x))), CN1))), Negate(m)), x), x), x), And(FreeQ(List(a, c, d, e, g, n, p), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), ILtQ(m, C0), Not(IntegerQ(p)), Not(IntegerQ(n)))));
            IIntegrate(963, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(d, Times(e, x)), m), Power(Plus(f, Times(g, x)), n), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), And(FreeQ(List(a, b, c, d, e, f, g, m, n, p), x), Not(Or(IGtQ(m, C0), IGtQ(n, C0))))));
            IIntegrate(964, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(d, Times(e, x)), m), Power(Plus(f, Times(g, x)), n), Power(Plus(a, Times(c, Sqr(x))), p)), x), And(FreeQ(List(a, c, d, e, f, g, m, n, p), x), Not(Or(IGtQ(m, C0), IGtQ(n, C0))))));
            IIntegrate(965, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, u_)), m_DEFAULT), Power(Plus(f_DEFAULT, Times(g_DEFAULT, u_)), n_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, u_), Times(c_DEFAULT, Sqr(u_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Coefficient(u, x, C1), CN1), Subst(Int(Times(Power(Plus(d, Times(e, x)), m), Power(Plus(f, Times(g, x)), n), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), x, u), x), And(FreeQ(List(a, b, c, d, e, f, g, m, n, p), x), LinearQ(u, x), NeQ(u, x))));
            IIntegrate(966, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, u_)), m_DEFAULT), Power(Plus(f_DEFAULT, Times(g_DEFAULT, u_)), n_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Sqr(u_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Coefficient(u, x, C1), CN1), Subst(Int(Times(Power(Plus(d, Times(e, x)), m), Power(Plus(f, Times(g, x)), n), Power(Plus(a, Times(c, Sqr(x))), p)), x), x, u), x), And(FreeQ(List(a, c, d, e, f, g, m, n, p), x), LinearQ(u, x), NeQ(u, x))));
            IIntegrate(967, Int(Times(Power(Plus(a_, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqr(x_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Times(c, Power(f, CN1)), p), Int(Power(Plus(d, Times(e, x), Times(f, Sqr(x))), Plus(p, q)), x), x), And(FreeQ(List(a, b, c, d, e, f, p, q), x), EqQ(Subtract(Times(c, d), Times(a, f)), C0), EqQ(Subtract(Times(b, d), Times(a, e)), C0), Or(IntegerQ(p), GtQ(Times(c, Power(f, CN1)), C0)), Or(Not(IntegerQ(q)), LessEqual(LeafCount(Plus(d, Times(e, x), Times(f, Sqr(x)))), LeafCount(Plus(a, Times(b, x), Times(c, Sqr(x)))))))));
            IIntegrate(968, Int(Times(Power(Plus(a_, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_), Power(Plus(d_, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqr(x_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(a, IntPart(p)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), FracPart(p)), Power(Times(Power(d, IntPart(p)), Power(Plus(d, Times(e, x), Times(f, Sqr(x))), FracPart(p))), CN1)), Int(Power(Plus(d, Times(e, x), Times(f, Sqr(x))), Plus(p, q)), x), x), And(FreeQ(List(a, b, c, d, e, f, p, q), x), EqQ(Subtract(Times(c, d), Times(a, f)), C0), EqQ(Subtract(Times(b, d), Times(a, e)), C0), Not(IntegerQ(p)), Not(IntegerQ(q)), Not(GtQ(Times(c, Power(f, CN1)), C0)))));
            IIntegrate(969, Int(Times(Power(Plus(a_, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_), Power(Plus(d_, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqr(x_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, x), Times(c, Sqr(x))), FracPart(p)), Power(Times(Power(Times(C4, c), IntPart(p)), Power(Plus(b, Times(C2, c, x)), Times(C2, FracPart(p)))), CN1)), Int(Times(Power(Plus(b, Times(C2, c, x)), Times(C2, p)), Power(Plus(d, Times(e, x), Times(f, Sqr(x))), q)), x), x), And(FreeQ(List(a, b, c, d, e, f, p, q), x), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(p)))));
            IIntegrate(970, Int(Times(Power(Plus(a_, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_), Power(Plus(d_, Times(f_DEFAULT, Sqr(x_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, x), Times(c, Sqr(x))), FracPart(p)), Power(Times(Power(Times(C4, c), IntPart(p)), Power(Plus(b, Times(C2, c, x)), Times(C2, FracPart(p)))), CN1)), Int(Times(Power(Plus(b, Times(C2, c, x)), Times(C2, p)), Power(Plus(d, Times(f, Sqr(x))), q)), x), x), And(FreeQ(List(a, b, c, d, f, p, q), x), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(p)))));
            IIntegrate(971, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqr(x_))), q_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Plus(b, Times(C2, c, x)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Plus(d, Times(e, x), Times(f, Sqr(x))), q), Power(Times(Subtract(Sqr(b), Times(C4, a, c)), Plus(p, C1)), CN1)), x), Dist(Power(Times(Subtract(Sqr(b), Times(C4, a, c)), Plus(p, C1)), CN1), Int(Times(Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Plus(d, Times(e, x), Times(f, Sqr(x))), Subtract(q, C1)), Simp(Plus(Times(C2, c, d, Plus(Times(C2, p), C3)), Times(b, e, q), Times(Plus(Times(C2, b, f, q), Times(C2, c, e, Plus(Times(C2, p), q, C3))), x), Times(C2, c, f, Plus(Times(C2, p), Times(C2, q), C3), Sqr(x))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Subtract(Sqr(e), Times(C4, d, f)), C0), LtQ(p, CN1), GtQ(q, C0), Not(IGtQ(q, C0)))));
            IIntegrate(972, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_), Power(Plus(d_DEFAULT, Times(f_DEFAULT, Sqr(x_))), q_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Plus(b, Times(C2, c, x)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Plus(d, Times(f, Sqr(x))), q), Power(Times(Subtract(Sqr(b), Times(C4, a, c)), Plus(p, C1)), CN1)), x), Dist(Power(Times(Subtract(Sqr(b), Times(C4, a, c)), Plus(p, C1)), CN1), Int(Times(Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Plus(d, Times(f, Sqr(x))), Subtract(q, C1)), Simp(Plus(Times(C2, c, d, Plus(Times(C2, p), C3)), Times(C2, b, f, q, x), Times(C2, c, f, Plus(Times(C2, p), Times(C2, q), C3), Sqr(x))), x)), x), x)), And(FreeQ(List(a, b, c, d, f), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), LtQ(p, CN1), GtQ(q, C0), Not(IGtQ(q, C0)))));
            IIntegrate(973, Int(Times(Power(Plus(a_DEFAULT, Times(c_DEFAULT, Sqr(x_))), p_), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqr(x_))), q_)), x_Symbol),
                    Condition(Subtract(Simp(Times(C2, c, x, Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1)), Power(Plus(d, Times(e, x), Times(f, Sqr(x))), q), Power(Times(CN4, a, c, Plus(p, C1)), CN1)), x), Dist(Power(Times(CN4, a, c, Plus(p, C1)), CN1), Int(Times(Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1)), Power(Plus(d, Times(e, x), Times(f, Sqr(x))), Subtract(q, C1)), Simp(Plus(Times(C2, c, d, Plus(Times(C2, p), C3)), Times(C2, c, e, Plus(Times(C2, p), q, C3), x), Times(C2, c, f, Plus(Times(C2, p), Times(C2, q), C3), Sqr(x))), x)), x), x)), And(FreeQ(List(a, c, d, e, f), x), NeQ(Subtract(Sqr(e), Times(C4, d, f))), LtQ(p, CN1), GtQ(q, C0), Not(IGtQ(q, C0)))));
            IIntegrate(974, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqr(x_))), q_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Plus(Times(C2, a, Sqr(c), e), Times(CN1, Sqr(b), c, e), Times(Power(b, C3), f), Times(b, c, Subtract(Times(c, d), Times(C3, a, f))), Times(c, Subtract(Plus(Times(C2, Sqr(c), d), Times(Sqr(b), f)), Times(c, Plus(Times(b, e), Times(C2, a, f)))), x)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Plus(d, Times(e, x), Times(f, Sqr(x))), Plus(q, C1)), Power(Times(Subtract(Sqr(b), Times(C4, a, c)), Subtract(Sqr(Subtract(Times(c, d), Times(a, f))), Times(Subtract(Times(b, d), Times(a, e)), Subtract(Times(c, e), Times(b, f)))), Plus(p, C1)), CN1)), x), Dist(Power(Times(Subtract(Sqr(b), Times(C4, a, c)), Subtract(Sqr(Subtract(Times(c, d), Times(a, f))), Times(Subtract(Times(b, d), Times(a, e)), Subtract(Times(c, e), Times(b, f)))), Plus(p, C1)), CN1), Int(Times(Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Plus(d, Times(e, x), Times(f, Sqr(x))), q), Simp(Plus(Times(C2, c, Subtract(Sqr(Subtract(Times(c, d), Times(a, f))), Times(Subtract(Times(b, d), Times(a, e)), Subtract(Times(c, e), Times(b, f)))), Plus(p, C1)), Times(CN1, Subtract(Plus(Times(C2, Sqr(c), d), Times(Sqr(b), f)), Times(c, Plus(Times(b, e), Times(C2, a, f)))), Subtract(Times(a, f, Plus(p, C1)), Times(c, d, Plus(p, C2)))), Times(CN1, e, Subtract(Subtract(Subtract(Times(Sqr(b), c, e), Times(C2, a, Sqr(c), e)), Times(Power(b, C3), f)), Times(b, c, Subtract(Times(c, d), Times(C3, a, f)))), Plus(p, q, C2)), Times(Subtract(Times(C2, f, Plus(Times(C2, a, Sqr(c), e), Times(CN1, Sqr(b), c, e), Times(Power(b, C3), f), Times(b, c, Subtract(Times(c, d), Times(C3, a, f)))), Plus(p, q, C2)), Times(Subtract(Plus(Times(C2, Sqr(c), d), Times(Sqr(b), f)), Times(c, Plus(Times(b, e), Times(C2, a, f)))), Subtract(Times(b, f, Plus(p, C1)), Times(c, e, Plus(Times(C2, p), q, C4))))), x), Times(c, f, Subtract(Plus(Times(C2, Sqr(c), d), Times(Sqr(b), f)), Times(c, Plus(Times(b, e), Times(C2, a, f)))), Plus(Times(C2, p), Times(C2, q), C5), Sqr(x))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, q), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Subtract(Sqr(e), Times(C4, d, f)), C0), LtQ(p, CN1), NeQ(Subtract(Sqr(Subtract(Times(c, d), Times(a, f))), Times(Subtract(Times(b, d), Times(a, e)), Subtract(Times(c, e), Times(b, f)))), C0), Not(And(Not(IntegerQ(p)), ILtQ(q, CN1))), Not(IGtQ(q, C0)))));
            IIntegrate(975, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_), Power(Plus(d_DEFAULT, Times(f_DEFAULT, Sqr(x_))), q_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Plus(Times(Power(b, C3), f), Times(b, c, Subtract(Times(c, d), Times(C3, a, f))), Times(c, Subtract(Plus(Times(C2, Sqr(c), d), Times(Sqr(b), f)), Times(c, C2, a, f)), x)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Plus(d, Times(f, Sqr(x))), Plus(q, C1)), Power(Times(Subtract(Sqr(b), Times(C4, a, c)), Plus(Times(Sqr(b), d, f), Sqr(Subtract(Times(c, d), Times(a, f)))), Plus(p, C1)), CN1)), x), Dist(Power(Times(Subtract(Sqr(b), Times(C4, a, c)), Plus(Times(Sqr(b), d, f), Sqr(Subtract(Times(c, d), Times(a, f)))), Plus(p, C1)), CN1), Int(Times(Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Plus(d, Times(f, Sqr(x))), q), Simp(Plus(Times(C2, c, Plus(Times(Sqr(b), d, f), Sqr(Subtract(Times(c, d), Times(a, f)))), Plus(p, C1)), Times(CN1, Subtract(Plus(Times(C2, Sqr(c), d), Times(Sqr(b), f)), Times(c, C2, a, f)), Subtract(Times(a, f, Plus(p, C1)), Times(c, d, Plus(p, C2)))), Times(Subtract(Times(C2, f, Plus(Times(Power(b, C3), f), Times(b, c, Subtract(Times(c, d), Times(C3, a, f)))), Plus(p, q, C2)), Times(Subtract(Plus(Times(C2, Sqr(c), d), Times(Sqr(b), f)), Times(c, C2, a, f)), b, f, Plus(p, C1))), x), Times(c, f, Subtract(Plus(Times(C2, Sqr(c), d), Times(Sqr(b), f)), Times(c, C2, a, f)), Plus(Times(C2, p), Times(C2, q), C5), Sqr(x))), x)), x), x)), And(FreeQ(List(a, b, c, d, f, q), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), LtQ(p, CN1), NeQ(Plus(Times(Sqr(b), d, f), Sqr(Subtract(Times(c, d), Times(a, f)))), C0), Not(And(Not(IntegerQ(p)), ILtQ(q, CN1))), Not(IGtQ(q, C0)))));
        }
    }
}
