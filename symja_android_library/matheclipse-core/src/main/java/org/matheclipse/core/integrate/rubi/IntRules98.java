package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Simplify;
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
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.g_DEFAULT;
import static org.matheclipse.core.expression.F.h;
import static org.matheclipse.core.expression.F.h_DEFAULT;
import static org.matheclipse.core.expression.F.k;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.r;
import static org.matheclipse.core.expression.F.r_DEFAULT;
import static org.matheclipse.core.expression.F.s;
import static org.matheclipse.core.expression.F.s_;
import static org.matheclipse.core.expression.F.t;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialMatchQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntHide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearMatchQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules98 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(2451, Int(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), p_DEFAULT))), b_DEFAULT)), q_), x_Symbol),
                    Condition(With(List(Set(k, Denominator(n))), Dist(k, Subst(Int(Times(Power(x, Subtract(k, C1)), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, Power(x, Times(k, n)))), p))))), q)), x), x, Power(x, Power(k, CN1))), x)), And(FreeQ(List(a, b, c, d, e, p, q), x), FractionQ(n))));
            IIntegrate(2452, Int(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), p_DEFAULT))), b_DEFAULT)), q_), x_Symbol),
                    Condition(Unintegrable(Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, Power(x, n))), p))))), q), x), FreeQ(List(a, b, c, d, e, n, p, q), x)));
            IIntegrate(2453, Int(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(v_, p_DEFAULT))), b_DEFAULT)), q_DEFAULT), x_Symbol),
                    Condition(Int(Power(Plus(a, Times(b, Log(Times(c, Power(ExpandToSum(v, x), p))))), q), x), And(FreeQ(List(a, b, c, p, q), x), BinomialQ(v, x), Not(BinomialMatchQ(v, x)))));
            IIntegrate(2454, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), p_DEFAULT))), b_DEFAULT)), q_DEFAULT), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(n, CN1), Subst(Int(Times(Power(x, Subtract(Simplify(Times(Plus(m, C1), Power(n, CN1))), C1)), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), p))))), q)), x), x, Power(x, n)), x), And(FreeQ(List(a, b, c, d, e, m, n, p, q), x), IntegerQ(Simplify(Times(Plus(m, C1), Power(n, CN1)))), Or(GtQ(Times(Plus(m, C1), Power(n, CN1)), C0), IGtQ(q, C0)), Not(And(EqQ(q, C1), ILtQ(n, C0), IGtQ(m, C0))))));
            IIntegrate(2455, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), p_DEFAULT))), b_DEFAULT)), Power(Times(f_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(f, x), Plus(m, C1)), Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, Power(x, n))), p))))), Power(Times(f, Plus(m, C1)), CN1)), x), Dist(Times(b, e, n, p, Power(Times(f, Plus(m, C1)), CN1)), Int(Times(Power(x, Subtract(n, C1)), Power(Times(f, x), Plus(m, C1)), Power(Plus(d, Times(e, Power(x, n))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), NeQ(m, CN1))));
            IIntegrate(2456, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), p_DEFAULT))), b_DEFAULT)), q_DEFAULT), Power(Times(f_, x_), m_)), x_Symbol),
                    Condition(Dist(Times(Power(Times(f, x), m), Power(Power(x, m), CN1)), Int(Times(Power(x, m), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, Power(x, n))), p))))), q)), x), x), And(FreeQ(List(a, b, c, d, e, f, m, n, p, q), x), IntegerQ(Simplify(Times(Plus(m, C1), Power(n, CN1)))), Or(GtQ(Times(Plus(m, C1), Power(n, CN1)), C0), IGtQ(q, C0)))));
            IIntegrate(2457, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), p_DEFAULT))), b_DEFAULT)), q_), Power(Times(f_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(f, x), Plus(m, C1)), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, Power(x, n))), p))))), q), Power(Times(f, Plus(m, C1)), CN1)), x), Dist(Times(b, e, n, p, q, Power(Times(Power(f, n), Plus(m, C1)), CN1)), Int(Times(Power(Times(f, x), Plus(m, n)), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, Power(x, n))), p))))), Subtract(q, C1)), Power(Plus(d, Times(e, Power(x, n))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, m, p), x), IGtQ(q, C1), IntegerQ(n), NeQ(m, CN1))));
            IIntegrate(2458, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), p_DEFAULT))), b_DEFAULT)), q_), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(k, Denominator(n))), Dist(k, Subst(Int(Times(Power(x, Subtract(Times(k, Plus(m, C1)), C1)), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, Power(x, Times(k, n)))), p))))), q)), x), x, Power(x, Power(k, CN1))), x)), And(FreeQ(List(a, b, c, d, e, m, p, q), x), FractionQ(n))));
            IIntegrate(2459, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), p_DEFAULT))), b_DEFAULT)), q_DEFAULT), Power(Times(f_, x_), m_)), x_Symbol),
                    Condition(Dist(Times(Power(Times(f, x), m), Power(Power(x, m), CN1)), Int(Times(Power(x, m), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, Power(x, n))), p))))), q)), x), x), And(FreeQ(List(a, b, c, d, e, f, m, p, q), x), FractionQ(n))));
            IIntegrate(2460, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), p_DEFAULT))), b_DEFAULT)), q_DEFAULT), Power(Times(f_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Times(f, x), m), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, Power(x, n))), p))))), q)), x), FreeQ(List(a, b, c, d, e, f, m, n, p, q), x)));
            IIntegrate(2461, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(v_, p_DEFAULT))), b_DEFAULT)), q_DEFAULT), Power(Times(f_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Times(f, x), m), Power(Plus(a, Times(b, Log(Times(c, Power(ExpandToSum(v, x), p))))), q)), x), And(FreeQ(List(a, b, c, f, m, p, q), x), BinomialQ(v, x), Not(BinomialMatchQ(v, x)))));
            IIntegrate(2462, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), p_DEFAULT))), b_DEFAULT)), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(Log(Plus(f, Times(g, x))), Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, Power(x, n))), p))))), Power(g, CN1)), x), Dist(Times(b, e, n, p, Power(g, CN1)), Int(Times(Power(x, Subtract(n, C1)), Log(Plus(f, Times(g, x))), Power(Plus(d, Times(e, Power(x, n))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, n, p), x), RationalQ(n))));
            IIntegrate(2463, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), p_DEFAULT))), b_DEFAULT)), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), r_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(f, Times(g, x)), Plus(r, C1)), Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, Power(x, n))), p))))), Power(Times(g, Plus(r, C1)), CN1)), x), Dist(Times(b, e, n, p, Power(Times(g, Plus(r, C1)), CN1)), Int(Times(Power(x, Subtract(n, C1)), Power(Plus(f, Times(g, x)), Plus(r, C1)), Power(Plus(d, Times(e, Power(x, n))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, n, p, r), x), Or(IGtQ(r, C0), RationalQ(n)), NeQ(r, CN1))));
            IIntegrate(2464, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), p_DEFAULT))), b_DEFAULT)), q_DEFAULT), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), r_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(f, Times(g, x)), r), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, Power(x, n))), p))))), q)), x), FreeQ(List(a, b, c, d, e, f, g, n, p, q, r), x)));
            IIntegrate(2465, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(v_, p_DEFAULT))), b_DEFAULT)), q_DEFAULT), Power(u_, r_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(ExpandToSum(u, x), r), Power(Plus(a, Times(b, Log(Times(c, Power(ExpandToSum(v, x), p))))), q)), x), And(FreeQ(List(a, b, c, p, q, r), x), LinearQ(u, x), BinomialQ(v, x), Not(And(LinearMatchQ(u, x), BinomialMatchQ(v, x))))));
            IIntegrate(2466, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), p_DEFAULT))), b_DEFAULT)), q_DEFAULT), Power(x_, m_DEFAULT), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), r_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, Power(x, n))), p))))), q), Times(Power(x, m), Power(Plus(f, Times(g, x)), r)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, n, p, q), x), IntegerQ(m), IntegerQ(r))));
            IIntegrate(2467, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_DEFAULT))), p_DEFAULT))), b_DEFAULT)), q_DEFAULT), Power(Times(h_DEFAULT, x_), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), r_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(k, Denominator(m))), Dist(Times(k, Power(h, CN1)), Subst(Int(Times(Power(x, Subtract(Times(k, Plus(m, C1)), C1)), Power(Plus(f, Times(g, Power(x, k), Power(h, CN1))), r), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, Power(x, Times(k, n)), Power(Power(h, n), CN1))), p))))), q)), x), x, Power(Times(h, x), Power(k, CN1))), x)), And(FreeQ(List(a, b, c, d, e, f, g, h, p, r), x), FractionQ(m), IntegerQ(n), IntegerQ(r))));
            IIntegrate(2468, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), p_DEFAULT))), b_DEFAULT)), q_DEFAULT), Power(Times(h_DEFAULT, x_), m_DEFAULT), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), r_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Times(h, x), m), Power(Plus(f, Times(g, x)), r), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, Power(x, n))), p))))), q)), x), FreeQ(List(a, b, c, d, e, f, g, h, m, n, p, q, r), x)));
            IIntegrate(2469, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(v_, p_DEFAULT))), b_DEFAULT)), q_DEFAULT), Power(u_, r_DEFAULT), Power(Times(h_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Times(h, x), m), Power(ExpandToSum(u, x), r), Power(Plus(a, Times(b, Log(Times(c, Power(ExpandToSum(v, x), p))))), q)), x), And(FreeQ(List(a, b, c, h, m, p, q, r), x), LinearQ(u, x), BinomialQ(v, x), Not(And(LinearMatchQ(u, x), BinomialMatchQ(v, x))))));
            IIntegrate(2470, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), p_DEFAULT))), b_DEFAULT)), Power(Plus(f_, Times(g_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Power(Plus(f, Times(g, Sqr(x))), CN1), x))), Subtract(Simp(Times(u, Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, Power(x, n))), p)))))), x), Dist(Times(b, e, n, p), Int(Times(u, Power(x, Subtract(n, C1)), Power(Plus(d, Times(e, Power(x, n))), CN1)), x), x))), And(FreeQ(List(a, b, c, d, e, f, g, n, p), x), IntegerQ(n))));
            IIntegrate(2471, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), p_DEFAULT))), b_DEFAULT)), q_DEFAULT), Power(Plus(f_, Times(g_DEFAULT, Power(x_, s_))), r_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(t, ExpandIntegrand(Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, Power(x, n))), p))))), q), Power(Plus(f, Times(g, Power(x, s))), r), x))), Condition(Int(t, x), SumQ(t))), And(FreeQ(List(a, b, c, d, e, f, g, n, p, q, r, s), x), IntegerQ(n), IGtQ(q, C0), IntegerQ(r), IntegerQ(s), Or(EqQ(q, C1), And(GtQ(r, C0), GtQ(s, C1)), And(LtQ(s, C0), LtQ(r, C0))))));
            IIntegrate(2472, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), p_DEFAULT))), b_DEFAULT)), q_DEFAULT), Power(Plus(f_, Times(g_DEFAULT, Power(x_, s_))), r_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(k, Denominator(n))), Condition(Dist(k, Subst(Int(Times(Power(x, Subtract(k, C1)), Power(Plus(f, Times(g, Power(x, Times(k, s)))), r), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, Power(x, Times(k, n)))), p))))), q)), x), x, Power(x, Power(k, CN1))), x), IntegerQ(Times(k, s)))), And(FreeQ(List(a, b, c, d, e, f, g, n, p, q, r, s), x), FractionQ(n))));
            IIntegrate(2473, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), p_DEFAULT))), b_DEFAULT)), q_DEFAULT), Power(Plus(f_, Times(g_DEFAULT, Power(x_, s_))), r_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(f, Times(g, Power(x, s))), r), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, Power(x, n))), p))))), q)), x), FreeQ(List(a, b, c, d, e, f, g, n, p, q, r, s), x)));
            IIntegrate(2474, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(v_, p_DEFAULT))), b_DEFAULT)), q_DEFAULT), Power(u_, r_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(ExpandToSum(u, x), r), Power(Plus(a, Times(b, Log(Times(c, Power(ExpandToSum(v, x), p))))), q)), x), And(FreeQ(List(a, b, c, p, q, r), x), BinomialQ(List(u, v), x), Not(BinomialMatchQ(List(u, v), x)))));
            IIntegrate(2475, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), p_DEFAULT))), b_DEFAULT)), q_DEFAULT), Power(x_, m_DEFAULT), Power(Plus(f_, Times(g_DEFAULT, Power(x_, s_))), r_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(n, CN1), Subst(Int(Times(Power(x, Subtract(Simplify(Times(Plus(m, C1), Power(n, CN1))), C1)), Power(Plus(f, Times(g, Power(x, Times(s, Power(n, CN1))))), r), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), p))))), q)), x), x, Power(x, n)), x), And(FreeQ(List(a, b, c, d, e, f, g, m, n, p, q, r, s), x), IntegerQ(r), IntegerQ(Times(s, Power(n, CN1))), IntegerQ(Simplify(Times(Plus(m, C1), Power(n, CN1)))), Or(GtQ(Times(Plus(m, C1), Power(n, CN1)), C0), IGtQ(q, C0)))));
        }
    }
}
