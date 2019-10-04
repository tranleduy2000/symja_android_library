package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcCos;
import static org.matheclipse.core.expression.F.ArcCosh;
import static org.matheclipse.core.expression.F.ArcCot;
import static org.matheclipse.core.expression.F.ArcCoth;
import static org.matheclipse.core.expression.F.ArcSin;
import static org.matheclipse.core.expression.F.ArcSinh;
import static org.matheclipse.core.expression.F.ArcTan;
import static org.matheclipse.core.expression.F.ArcTanh;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.FSymbol;
import static org.matheclipse.core.expression.F.F_;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.MemberQ;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.PolyLog;
import static org.matheclipse.core.expression.F.PolynomialQ;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_DEFAULT;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.g_DEFAULT;
import static org.matheclipse.core.expression.F.k;
import static org.matheclipse.core.expression.F.k_;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.r;
import static org.matheclipse.core.expression.F.r_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialMatchQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.F;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntHide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules95 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(2376, Int(Times(Log(Times(d_DEFAULT, Power(Plus(e_, Times(f_DEFAULT, Power(x_, m_DEFAULT))), r_DEFAULT))), Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), Power(Times(g_DEFAULT, x_), q_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Times(Power(Times(g, x), q), Log(Times(d, Power(Plus(e, Times(f, Power(x, m))), r)))), x))), Subtract(Dist(Plus(a, Times(b, Log(Times(c, Power(x, n))))), u, x), Dist(Times(b, n), Int(Dist(Power(x, CN1), u, x), x), x))), And(FreeQ(List(a, b, c, d, e, f, g, r, m, n, q), x), Or(IntegerQ(Times(Plus(q, C1), Power(m, CN1))), And(RationalQ(m), RationalQ(q))), NeQ(q, CN1))));
            IIntegrate(2377, Int(Times(Log(Times(d_DEFAULT, Plus(e_, Times(f_DEFAULT, Power(x_, m_DEFAULT))))), Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(Times(g_DEFAULT, x_), q_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Times(Power(Times(g, x), q), Log(Times(d, Plus(e, Times(f, Power(x, m)))))), x))), Subtract(Dist(Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), p), u, x), Dist(Times(b, n, p), Int(Dist(Times(Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), Subtract(p, C1)), Power(x, CN1)), u, x), x), x))), And(FreeQ(List(a, b, c, d, e, f, g, m, n, q), x), IGtQ(p, C0), RationalQ(m), RationalQ(q), NeQ(q, CN1), Or(EqQ(p, C1), And(FractionQ(m), IntegerQ(Times(Plus(q, C1), Power(m, CN1)))), And(IGtQ(q, C0), IntegerQ(Times(Plus(q, C1), Power(m, CN1))), EqQ(Times(d, e), C1))))));
            IIntegrate(2378, Int(Times(Log(Times(d_DEFAULT, Power(Plus(e_, Times(f_DEFAULT, Power(x_, m_DEFAULT))), r_DEFAULT))), Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(Times(g_DEFAULT, x_), q_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Times(Power(Times(g, x), q), Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), p)), x))), Subtract(Dist(Log(Times(d, Power(Plus(e, Times(f, Power(x, m))), r))), u, x), Dist(Times(f, m, r), Int(Dist(Times(Power(x, Subtract(m, C1)), Power(Plus(e, Times(f, Power(x, m))), CN1)), u, x), x), x))), And(FreeQ(List(a, b, c, d, e, f, g, r, m, n, q), x), IGtQ(p, C0), RationalQ(m), RationalQ(q))));
            IIntegrate(2379, Int(Times(Log(Times(d_DEFAULT, Power(Plus(e_, Times(f_DEFAULT, Power(x_, m_DEFAULT))), r_DEFAULT))), Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(Times(g_DEFAULT, x_), q_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Times(g, x), q), Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), p), Log(Times(d, Power(Plus(e, Times(f, Power(x, m))), r)))), x), FreeQ(List(a, b, c, d, e, f, g, r, m, n, p, q), x)));
            IIntegrate(2380, Int(Times(Log(Times(d_DEFAULT, Power(u_, r_DEFAULT))), Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(Times(g_DEFAULT, x_), q_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Times(g, x), q), Log(Times(d, Power(ExpandToSum(u, x), r))), Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), p)), x), And(FreeQ(List(a, b, c, d, g, r, n, p, q), x), BinomialQ(u, x), Not(BinomialMatchQ(u, x)))));
            IIntegrate(2381, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), PolyLog(k_, Times(e_DEFAULT, Power(x_, q_DEFAULT)))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, n, x, PolyLog(k, Times(e, Power(x, q)))), x)), Negate(Dist(q, Int(Times(PolyLog(Subtract(k, C1), Times(e, Power(x, q))), Plus(a, Times(b, Log(Times(c, Power(x, n)))))), x), x)), Dist(Times(b, n, q), Int(PolyLog(Subtract(k, C1), Times(e, Power(x, q))), x), x), Simp(Times(x, PolyLog(k, Times(e, Power(x, q))), Plus(a, Times(b, Log(Times(c, Power(x, n)))))), x)), And(FreeQ(List(a, b, c, e, n, q), x), IGtQ(k, C0))));
            IIntegrate(2382, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), p_DEFAULT), PolyLog(k_, Times(e_DEFAULT, Power(x_, q_DEFAULT)))), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), p), PolyLog(k, Times(e, Power(x, q)))), x), FreeQ(List(a, b, c, e, n, p, q), x)));
            IIntegrate(2383, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(x_, CN1), PolyLog(k_, Times(e_DEFAULT, Power(x_, q_DEFAULT)))), x_Symbol),
                    Condition(Subtract(Simp(Times(PolyLog(Plus(k, C1), Times(e, Power(x, q))), Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), p), Power(q, CN1)), x), Dist(Times(b, n, p, Power(q, CN1)), Int(Times(PolyLog(Plus(k, C1), Times(e, Power(x, q))), Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), Subtract(p, C1)), Power(x, CN1)), x), x)), And(FreeQ(List(a, b, c, e, k, n, q), x), GtQ(p, C0))));
            IIntegrate(2384, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(x_, CN1), PolyLog(k_, Times(e_DEFAULT, Power(x_, q_DEFAULT)))), x_Symbol),
                    Condition(Subtract(Simp(Times(PolyLog(k, Times(e, Power(x, q))), Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), Plus(p, C1)), Power(Times(b, n, Plus(p, C1)), CN1)), x), Dist(Times(q, Power(Times(b, n, Plus(p, C1)), CN1)), Int(Times(PolyLog(Subtract(k, C1), Times(e, Power(x, q))), Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), Plus(p, C1)), Power(x, CN1)), x), x)), And(FreeQ(List(a, b, c, e, k, n, q), x), LtQ(p, CN1))));
            IIntegrate(2385, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), Power(Times(d_DEFAULT, x_), m_DEFAULT), PolyLog(k_, Times(e_DEFAULT, Power(x_, q_DEFAULT)))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, n, Power(Times(d, x), Plus(m, C1)), PolyLog(k, Times(e, Power(x, q))), Power(Times(d, Sqr(Plus(m, C1))), CN1)), x)), Negate(Dist(Times(q, Power(Plus(m, C1), CN1)), Int(Times(Power(Times(d, x), m), PolyLog(Subtract(k, C1), Times(e, Power(x, q))), Plus(a, Times(b, Log(Times(c, Power(x, n)))))), x), x)), Dist(Times(b, n, q, Power(Plus(m, C1), CN2)), Int(Times(Power(Times(d, x), m), PolyLog(Subtract(k, C1), Times(e, Power(x, q)))), x), x), Simp(Times(Power(Times(d, x), Plus(m, C1)), PolyLog(k, Times(e, Power(x, q))), Plus(a, Times(b, Log(Times(c, Power(x, n))))), Power(Times(d, Plus(m, C1)), CN1)), x)), And(FreeQ(List(a, b, c, d, e, m, n, q), x), IGtQ(k, C0))));
            IIntegrate(2386, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(Times(d_DEFAULT, x_), m_DEFAULT), PolyLog(k_, Times(e_DEFAULT, Power(x_, q_DEFAULT)))), x_Symbol),
                    Condition(Unintegrable(Times(Power(Times(d, x), m), Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), p), PolyLog(k, Times(e, Power(x, q)))), x), FreeQ(List(a, b, c, d, e, m, n, p, q), x)));
            IIntegrate(2387, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), $p("§px", true), Power($(F_, Times(d_DEFAULT, Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Times($s("§px"), Power(F(Times(d, Plus(e, Times(f, x)))), m)), x))), Subtract(Dist(Plus(a, Times(b, Log(Times(c, Power(x, n))))), u, x), Dist(Times(b, n), Int(Dist(Power(x, CN1), u, x), x), x))), And(FreeQ(List(a, b, c, d, e, f, n), x), PolynomialQ($s("§px"), x), IGtQ(m, C0), MemberQ(List(ArcSin, ArcCos, ArcSinh, ArcCosh), FSymbol))));
            IIntegrate(2388, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), $p("§px", true), $(F_, Times(d_DEFAULT, Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Times($s("§px"), F(Times(d, Plus(e, Times(f, x))))), x))), Subtract(Dist(Plus(a, Times(b, Log(Times(c, Power(x, n))))), u, x), Dist(Times(b, n), Int(Dist(Power(x, CN1), u, x), x), x))), And(FreeQ(List(a, b, c, d, e, f, n), x), PolynomialQ($s("§px"), x), MemberQ(List(ArcTan, ArcCot, ArcTanh, ArcCoth), FSymbol))));
            IIntegrate(2389, Int(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Power(e, CN1), Subst(Int(Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), p), x), x, Plus(d, Times(e, x))), x), FreeQ(List(a, b, c, d, e, n, p), x)));
            IIntegrate(2390, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(Plus(f_, Times(g_DEFAULT, x_)), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(e, CN1), Subst(Int(Times(Power(Times(f, x, Power(d, CN1)), q), Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), p)), x), x, Plus(d, Times(e, x))), x), And(FreeQ(List(a, b, c, d, e, f, g, n, p, q), x), EqQ(Subtract(Times(e, f), Times(d, g)), C0))));
            IIntegrate(2391, Int(Times(Log(Times(c_DEFAULT, Plus(d_, Times(e_DEFAULT, Power(x_, n_DEFAULT))))), Power(x_, CN1)), x_Symbol),
                    Condition(Negate(Simp(Times(PolyLog(C2, Times(CN1, c, e, Power(x, n))), Power(n, CN1)), x)), And(FreeQ(List(c, d, e, n), x), EqQ(Times(c, d), C1))));
            IIntegrate(2392, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Plus(d_, Times(e_DEFAULT, x_)))), b_DEFAULT)), Power(x_, CN1)), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(a, Times(b, Log(Times(c, d)))), Log(x)), x), Dist(b, Int(Times(Log(Plus(C1, Times(e, x, Power(d, CN1)))), Power(x, CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), GtQ(Times(c, d), C0))));
            IIntegrate(2393, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Plus(d_, Times(e_DEFAULT, x_)))), b_DEFAULT)), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Dist(Power(g, CN1), Subst(Int(Times(Plus(a, Times(b, Log(Plus(C1, Times(c, e, x, Power(g, CN1)))))), Power(x, CN1)), x), x, Plus(f, Times(g, x))), x), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), EqQ(Plus(g, Times(c, Subtract(Times(e, f), Times(d, g)))), C0))));
            IIntegrate(2394, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(Log(Times(e, Plus(f, Times(g, x)), Power(Subtract(Times(e, f), Times(d, g)), CN1))), Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), Power(g, CN1)), x), Dist(Times(b, e, n, Power(g, CN1)), Int(Times(Log(Times(e, Plus(f, Times(g, x)), Power(Subtract(Times(e, f), Times(d, g)), CN1))), Power(Plus(d, Times(e, x)), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, n), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0))));
            IIntegrate(2395, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), q_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(f, Times(g, x)), Plus(q, C1)), Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), Power(Times(g, Plus(q, C1)), CN1)), x), Dist(Times(b, e, n, Power(Times(g, Plus(q, C1)), CN1)), Int(Times(Power(Plus(f, Times(g, x)), Plus(q, C1)), Power(Plus(d, Times(e, x)), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, n, q), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(q, CN1))));
            IIntegrate(2396, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), p_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(Log(Times(e, Plus(f, Times(g, x)), Power(Subtract(Times(e, f), Times(d, g)), CN1))), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), p), Power(g, CN1)), x), Dist(Times(b, e, n, p, Power(g, CN1)), Int(Times(Log(Times(e, Plus(f, Times(g, x)), Power(Subtract(Times(e, f), Times(d, g)), CN1))), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), Subtract(p, C1)), Power(Plus(d, Times(e, x)), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, n, p), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), IGtQ(p, C1))));
            IIntegrate(2397, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), p_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), CN2)), x_Symbol),
                    Condition(Subtract(Simp(Times(Plus(d, Times(e, x)), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), p), Power(Times(Subtract(Times(e, f), Times(d, g)), Plus(f, Times(g, x))), CN1)), x), Dist(Times(b, e, n, p, Power(Subtract(Times(e, f), Times(d, g)), CN1)), Int(Times(Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), Subtract(p, C1)), Power(Plus(f, Times(g, x)), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, n), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), GtQ(p, C0))));
            IIntegrate(2398, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), p_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), q_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(f, Times(g, x)), Plus(q, C1)), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), p), Power(Times(g, Plus(q, C1)), CN1)), x), Dist(Times(b, e, n, p, Power(Times(g, Plus(q, C1)), CN1)), Int(Times(Power(Plus(f, Times(g, x)), Plus(q, C1)), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), Subtract(p, C1)), Power(Plus(d, Times(e, x)), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, n, q), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), GtQ(p, C0), NeQ(q, CN1), IntegersQ(Times(C2, p), Times(C2, q)), Or(Not(IGtQ(q, C0)), And(EqQ(p, C2), NeQ(q, C1))))));
            IIntegrate(2399, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), CN1), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), q_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(f, Times(g, x)), q), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, n), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), IGtQ(q, C0))));
            IIntegrate(2400, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), p_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), q_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(d, Times(e, x)), Power(Plus(f, Times(g, x)), q), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), Plus(p, C1)), Power(Times(b, e, n, Plus(p, C1)), CN1)), x), Negate(Dist(Times(Plus(q, C1), Power(Times(b, n, Plus(p, C1)), CN1)), Int(Times(Power(Plus(f, Times(g, x)), q), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), Plus(p, C1))), x), x)), Dist(Times(q, Subtract(Times(e, f), Times(d, g)), Power(Times(b, e, n, Plus(p, C1)), CN1)), Int(Times(Power(Plus(f, Times(g, x)), Subtract(q, C1)), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, n), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), LtQ(p, CN1), GtQ(q, C0))));
        }
    }
}
