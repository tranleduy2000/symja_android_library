package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcCos;
import static org.matheclipse.core.expression.F.ArcCosh;
import static org.matheclipse.core.expression.F.ArcSin;
import static org.matheclipse.core.expression.F.ArcSinh;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.CN3;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.ExpIntegralEi;
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
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.g_DEFAULT;
import static org.matheclipse.core.expression.F.h;
import static org.matheclipse.core.expression.F.h_DEFAULT;
import static org.matheclipse.core.expression.F.i;
import static org.matheclipse.core.expression.F.i_DEFAULT;
import static org.matheclipse.core.expression.F.j;
import static org.matheclipse.core.expression.F.j_DEFAULT;
import static org.matheclipse.core.expression.F.k;
import static org.matheclipse.core.expression.F.k_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.r;
import static org.matheclipse.core.expression.F.r_DEFAULT;
import static org.matheclipse.core.expression.F.s;
import static org.matheclipse.core.expression.F.s_;
import static org.matheclipse.core.expression.F.s_DEFAULT;
import static org.matheclipse.core.expression.F.t;
import static org.matheclipse.core.expression.F.t_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.u_DEFAULT;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.F;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntHide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules99 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(2476, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), p_DEFAULT))), b_DEFAULT)), q_DEFAULT), Power(x_, m_DEFAULT), Power(Plus(f_, Times(g_DEFAULT, Power(x_, s_))), r_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, Power(x, n))), p))))), q), Times(Power(x, m), Power(Plus(f, Times(g, Power(x, s))), r)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, m, n, p, q, r, s), x), IGtQ(q, C0), IntegerQ(m), IntegerQ(r), IntegerQ(s))));
            IIntegrate(2477, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), p_DEFAULT))), b_DEFAULT)), q_DEFAULT), Power(x_, m_DEFAULT), Power(Plus(f_, Times(g_DEFAULT, Power(x_, s_))), r_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(n, CN1), Subst(Int(Times(Power(x, Subtract(Plus(m, Power(n, CN1)), C1)), Power(Plus(f, Times(g, Power(x, Times(s, Power(n, CN1))))), r), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), p))))), q)), x), x, Power(x, n)), x), And(FreeQ(List(a, b, c, d, e, f, g, m, n, p, q, r, s), x), FractionQ(n), IntegerQ(Power(n, CN1)), IntegerQ(Times(s, Power(n, CN1))))));
            IIntegrate(2478, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_DEFAULT))), p_DEFAULT))), b_DEFAULT)), q_DEFAULT), Power(Times(h_DEFAULT, x_), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, Power(x_, s_DEFAULT))), r_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(k, Denominator(m))), Dist(Times(k, Power(h, CN1)), Subst(Int(Times(Power(x, Subtract(Times(k, Plus(m, C1)), C1)), Power(Plus(f, Times(g, Power(x, Times(k, s)), Power(Power(h, s), CN1))), r), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, Power(x, Times(k, n)), Power(Power(h, n), CN1))), p))))), q)), x), x, Power(Times(h, x), Power(k, CN1))), x)), And(FreeQ(List(a, b, c, d, e, f, g, h, p, r), x), FractionQ(m), IntegerQ(n), IntegerQ(s))));
            IIntegrate(2479, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), p_DEFAULT))), b_DEFAULT)), q_DEFAULT), Power(Times(h_DEFAULT, x_), m_DEFAULT), Power(Plus(f_, Times(g_DEFAULT, Power(x_, s_))), r_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Times(h, x), m), Power(Plus(f, Times(g, Power(x, s))), r), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, Power(x, n))), p))))), q)), x), FreeQ(List(a, b, c, d, e, f, g, h, m, n, p, q, r, s), x)));
            IIntegrate(2480, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(v_, p_DEFAULT))), b_DEFAULT)), q_DEFAULT), Power(u_, r_DEFAULT), Power(Times(h_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Times(h, x), m), Power(ExpandToSum(u, x), r), Power(Plus(a, Times(b, Log(Times(c, Power(ExpandToSum(v, x), p))))), q)), x), And(FreeQ(List(a, b, c, h, m, p, q, r), x), BinomialQ(List(u, v), x), Not(BinomialMatchQ(List(u, v), x)))));
            IIntegrate(2481, Int(Times(Power(Log(Times(f_DEFAULT, Power(x_, q_DEFAULT))), m_DEFAULT), Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), p_DEFAULT))), b_DEFAULT)), Power(x_, CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Log(Times(f, Power(x, q))), Plus(m, C1)), Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, Power(x, n))), p))))), Power(Times(q, Plus(m, C1)), CN1)), x), Dist(Times(b, e, n, p, Power(Times(q, Plus(m, C1)), CN1)), Int(Times(Power(x, Subtract(n, C1)), Power(Log(Times(f, Power(x, q))), Plus(m, C1)), Power(Plus(d, Times(e, Power(x, n))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, m, n, p, q), x), NeQ(m, CN1))));
            IIntegrate(2482, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), p_DEFAULT))), b_DEFAULT)), Power($(F_, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Power(F(Times(f, x)), m), x))), Subtract(Dist(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, Power(x, n))), p))))), u, x), Dist(Times(b, e, n, p), Int(SimplifyIntegrand(Times(u, Power(x, Subtract(n, C1)), Power(Plus(d, Times(e, Power(x, n))), CN1)), x), x), x))), And(FreeQ(List(a, b, c, d, e, f, p), x), MemberQ(List(ArcSin, ArcCos, ArcSinh, ArcCosh), FSymbol), IGtQ(m, C0), IGtQ(n, C1))));
            IIntegrate(2483, Int(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_))), p_DEFAULT))), b_DEFAULT)), q_DEFAULT), x_Symbol),
                    Condition(Dist(Power(g, CN1), Subst(Int(Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, Power(x, n))), p))))), q), x), x, Plus(f, Times(g, x))), x), And(FreeQ(List(a, b, c, d, e, f, g, n, p), x), IGtQ(q, C0), Or(EqQ(q, C1), IntegerQ(n)))));
            IIntegrate(2484, Int(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_))), p_DEFAULT))), b_DEFAULT)), q_DEFAULT), x_Symbol),
                    Condition(Unintegrable(Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, Power(Plus(f, Times(g, x)), n))), p))))), q), x), FreeQ(List(a, b, c, d, e, f, g, n, p, q), x)));
            IIntegrate(2485, Int(Times(Power(Log(Times(e_DEFAULT, Power(Times(f_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), q_DEFAULT)), r_DEFAULT))), s_DEFAULT), u_DEFAULT), x_Symbol),
                    Condition(Int(Times(u, Power(Log(Times(e, Power(Times(Power(b, p), f, Power(Plus(c, Times(d, x)), Plus(p, q)), Power(Power(d, p), CN1)), r))), s)), x), And(FreeQ(List(a, b, c, d, e, f, p, q, r, s), x), EqQ(Subtract(Times(b, c), Times(a, d)), C0), IntegerQ(p))));
            IIntegrate(2486, Int(Power(Log(Times(e_DEFAULT, Power(Times(f_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), q_DEFAULT)), r_DEFAULT))), s_DEFAULT), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(a, Times(b, x)), Power(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), s), Power(b, CN1)), x), Dist(Times(q, r, s, Subtract(Times(b, c), Times(a, d)), Power(b, CN1)), Int(Times(Power(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), Subtract(s, C1)), Power(Plus(c, Times(d, x)), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, p, q, r, s), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(p, q), C0), IGtQ(s, C0))));
            IIntegrate(2487, Int(Power(Log(Times(e_DEFAULT, Power(Times(f_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), q_DEFAULT)), r_DEFAULT))), s_DEFAULT), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(a, Times(b, x)), Power(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), s), Power(b, CN1)), x), Dist(Times(q, r, s, Subtract(Times(b, c), Times(a, d)), Power(b, CN1)), Int(Times(Power(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), Subtract(s, C1)), Power(Plus(c, Times(d, x)), CN1)), x), x), Negate(Dist(Times(r, s, Plus(p, q)), Int(Power(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), Subtract(s, C1)), x), x))), And(FreeQ(List(a, b, c, d, e, f, p, q, r, s), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Plus(p, q), C0), IGtQ(s, C0), LtQ(s, C4))));
            IIntegrate(2488, Int(Times(Power(Log(Times(e_DEFAULT, Power(Times(f_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), q_DEFAULT)), r_DEFAULT))), s_DEFAULT), Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Log(Times(CN1, Subtract(Times(b, c), Times(a, d)), Power(Times(d, Plus(a, Times(b, x))), CN1))), Power(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), s), Power(h, CN1)), x)), Dist(Times(p, r, s, Subtract(Times(b, c), Times(a, d)), Power(h, CN1)), Int(Times(Log(Times(CN1, Subtract(Times(b, c), Times(a, d)), Power(Times(d, Plus(a, Times(b, x))), CN1))), Power(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), Subtract(s, C1)), Power(Times(Plus(a, Times(b, x)), Plus(c, Times(d, x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, h, p, q, r, s), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(p, q), C0), EqQ(Subtract(Times(b, g), Times(a, h)), C0), IGtQ(s, C0))));
            IIntegrate(2489, Int(Times(Power(Log(Times(e_DEFAULT, Power(Times(f_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), q_DEFAULT)), r_DEFAULT))), s_), Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Times(d, Power(h, CN1)), Int(Times(Power(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), s), Power(Plus(c, Times(d, x)), CN1)), x), x), Dist(Times(Subtract(Times(d, g), Times(c, h)), Power(h, CN1)), Int(Times(Power(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), s), Power(Times(Plus(c, Times(d, x)), Plus(g, Times(h, x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, h, p, q, r, s), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(p, q), C0), NeQ(Subtract(Times(b, g), Times(a, h)), C0), NeQ(Subtract(Times(d, g), Times(c, h)), C0), IGtQ(s, C1))));
            IIntegrate(2490, Int(Times(Power(Log(Times(e_DEFAULT, Power(Times(f_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), q_DEFAULT)), r_DEFAULT))), s_DEFAULT), Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), CN2)), x_Symbol),
                    Condition(Subtract(Simp(Times(Plus(a, Times(b, x)), Power(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), s), Power(Times(Subtract(Times(b, g), Times(a, h)), Plus(g, Times(h, x))), CN1)), x), Dist(Times(p, r, s, Subtract(Times(b, c), Times(a, d)), Power(Subtract(Times(b, g), Times(a, h)), CN1)), Int(Times(Power(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), Subtract(s, C1)), Power(Times(Plus(c, Times(d, x)), Plus(g, Times(h, x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, h, p, q, r, s), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(p, q), C0), NeQ(Subtract(Times(b, g), Times(a, h)), C0), IGtQ(s, C0))));
            IIntegrate(2491, Int(Times(Power(Log(Times(e_DEFAULT, Power(Times(f_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), q_DEFAULT)), r_DEFAULT))), s_), Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), CN3)), x_Symbol),
                    Condition(Subtract(Dist(Times(d, Power(Subtract(Times(d, g), Times(c, h)), CN1)), Int(Times(Power(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), s), Power(Plus(g, Times(h, x)), CN2)), x), x), Dist(Times(h, Power(Subtract(Times(d, g), Times(c, h)), CN1)), Int(Times(Plus(c, Times(d, x)), Power(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), s), Power(Plus(g, Times(h, x)), CN3)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, h, p, q, r, s), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(p, q), C0), EqQ(Subtract(Times(b, g), Times(a, h)), C0), NeQ(Subtract(Times(d, g), Times(c, h)), C0), IGtQ(s, C0))));
            IIntegrate(2492, Int(Times(Power(Log(Times(e_DEFAULT, Power(Times(f_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), q_DEFAULT)), r_DEFAULT))), s_DEFAULT), Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(g, Times(h, x)), Plus(m, C1)), Power(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), s), Power(Times(h, Plus(m, C1)), CN1)), x), Dist(Times(p, r, s, Subtract(Times(b, c), Times(a, d)), Power(Times(h, Plus(m, C1)), CN1)), Int(Times(Power(Plus(g, Times(h, x)), Plus(m, C1)), Power(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), Subtract(s, C1)), Power(Times(Plus(a, Times(b, x)), Plus(c, Times(d, x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, h, m, p, q, r, s), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(p, q), C0), IGtQ(s, C0), NeQ(m, CN1))));
            IIntegrate(2493, Int(Times(Power(Log(Times(e_DEFAULT, Power(Times(f_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), q_DEFAULT)), r_DEFAULT))), CN1), Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), CN2)), x_Symbol),
                    Condition(Simp(Times(b, Plus(c, Times(d, x)), Power(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r)), Power(Times(p, r), CN1)), ExpIntegralEi(Times(CN1, Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), Power(Times(p, r), CN1))), Power(Times(h, p, r, Subtract(Times(b, c), Times(a, d)), Plus(g, Times(h, x))), CN1)), x), And(FreeQ(List(a, b, c, d, e, f, g, h, p, q, r), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(p, q), C0), EqQ(Subtract(Times(b, g), Times(a, h)), C0))));
            IIntegrate(2494, Int(Times(Log(Times(e_DEFAULT, Power(Times(f_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), q_DEFAULT)), r_DEFAULT))), Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Plus(Simp(Times(Log(Plus(g, Times(h, x))), Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), Power(h, CN1)), x), Negate(Dist(Times(b, p, r, Power(h, CN1)), Int(Times(Log(Plus(g, Times(h, x))), Power(Plus(a, Times(b, x)), CN1)), x), x)), Negate(Dist(Times(d, q, r, Power(h, CN1)), Int(Times(Log(Plus(g, Times(h, x))), Power(Plus(c, Times(d, x)), CN1)), x), x))), And(FreeQ(List(a, b, c, d, e, f, g, h, p, q, r), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0))));
            IIntegrate(2495, Int(Times(Log(Times(e_DEFAULT, Power(Times(f_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), q_DEFAULT)), r_DEFAULT))), Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(g, Times(h, x)), Plus(m, C1)), Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), Power(Times(h, Plus(m, C1)), CN1)), x), Negate(Dist(Times(b, p, r, Power(Times(h, Plus(m, C1)), CN1)), Int(Times(Power(Plus(g, Times(h, x)), Plus(m, C1)), Power(Plus(a, Times(b, x)), CN1)), x), x)), Negate(Dist(Times(d, q, r, Power(Times(h, Plus(m, C1)), CN1)), Int(Times(Power(Plus(g, Times(h, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), CN1)), x), x))), And(FreeQ(List(a, b, c, d, e, f, g, h, m, p, q, r), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(m, CN1))));
            IIntegrate(2496, Int(Times(Sqr(Log(Times(e_DEFAULT, Power(Times(f_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), q_DEFAULT)), r_DEFAULT)))), Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Plus(Int(Times(Sqr(Plus(Log(Power(Plus(a, Times(b, x)), Times(p, r))), Log(Power(Plus(c, Times(d, x)), Times(q, r))))), Power(Plus(g, Times(h, x)), CN1)), x), Simp(Times(Subtract(Subtract(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), Log(Power(Plus(a, Times(b, x)), Times(p, r)))), Log(Power(Plus(c, Times(d, x)), Times(q, r)))), Plus(Times(C2, Int(Times(Log(Power(Plus(c, Times(d, x)), Times(q, r))), Power(Plus(g, Times(h, x)), CN1)), x)), Int(Times(Plus(Log(Power(Plus(a, Times(b, x)), Times(p, r))), Negate(Log(Power(Plus(c, Times(d, x)), Times(q, r)))), Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r)))), Power(Plus(g, Times(h, x)), CN1)), x))), x)), And(FreeQ(List(a, b, c, d, e, f, g, h, p, q, r), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Times(b, g), Times(a, h)), C0))));
            IIntegrate(2497, Int(Times(Sqr(Log(Times(e_DEFAULT, Power(Times(f_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), q_DEFAULT)), r_DEFAULT)))), Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Plus(Simp(Times(Log(Plus(g, Times(h, x))), Sqr(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r)))), Power(h, CN1)), x), Negate(Dist(Times(C2, b, p, r, Power(h, CN1)), Int(Times(Log(Plus(g, Times(h, x))), Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), Power(Plus(a, Times(b, x)), CN1)), x), x)), Negate(Dist(Times(C2, d, q, r, Power(h, CN1)), Int(Times(Log(Plus(g, Times(h, x))), Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), Power(Plus(c, Times(d, x)), CN1)), x), x))), And(FreeQ(List(a, b, c, d, e, f, g, h, p, q, r), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0))));
            IIntegrate(2498, Int(Times(Power(Log(Times(e_DEFAULT, Power(Times(f_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), q_DEFAULT)), r_DEFAULT))), s_), Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(g, Times(h, x)), Plus(m, C1)), Power(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), s), Power(Times(h, Plus(m, C1)), CN1)), x), Negate(Dist(Times(b, p, r, s, Power(Times(h, Plus(m, C1)), CN1)), Int(Times(Power(Plus(g, Times(h, x)), Plus(m, C1)), Power(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), Subtract(s, C1)), Power(Plus(a, Times(b, x)), CN1)), x), x)), Negate(Dist(Times(d, q, r, s, Power(Times(h, Plus(m, C1)), CN1)), Int(Times(Power(Plus(g, Times(h, x)), Plus(m, C1)), Power(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), Subtract(s, C1)), Power(Plus(c, Times(d, x)), CN1)), x), x))), And(FreeQ(List(a, b, c, d, e, f, g, h, m, p, q, r, s), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), IGtQ(s, C0), NeQ(m, CN1))));
            IIntegrate(2499, Int(Times(Log(Times(e_DEFAULT, Power(Times(f_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), q_DEFAULT)), r_DEFAULT))), Power(Plus(s_DEFAULT, Times(Log(Times(i_DEFAULT, Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), n_DEFAULT))), t_DEFAULT)), m_DEFAULT), Power(Plus(j_DEFAULT, Times(k_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(s, Times(t, Log(Times(i, Power(Plus(g, Times(h, x)), n))))), Plus(m, C1)), Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), Power(Times(k, n, t, Plus(m, C1)), CN1)), x), Negate(Dist(Times(b, p, r, Power(Times(k, n, t, Plus(m, C1)), CN1)), Int(Times(Power(Plus(s, Times(t, Log(Times(i, Power(Plus(g, Times(h, x)), n))))), Plus(m, C1)), Power(Plus(a, Times(b, x)), CN1)), x), x)), Negate(Dist(Times(d, q, r, Power(Times(k, n, t, Plus(m, C1)), CN1)), Int(Times(Power(Plus(s, Times(t, Log(Times(i, Power(Plus(g, Times(h, x)), n))))), Plus(m, C1)), Power(Plus(c, Times(d, x)), CN1)), x), x))), And(FreeQ(List(a, b, c, d, e, f, g, h, i, j, k, s, t, m, n, p, q, r), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Times(h, j), Times(g, k)), C0), IGtQ(m, C0))));
            IIntegrate(2500, Int(Times(Log(Times(e_DEFAULT, Power(Times(f_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), q_DEFAULT)), r_DEFAULT))), Plus(s_DEFAULT, Times(Log(Times(i_DEFAULT, Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), n_DEFAULT))), t_DEFAULT)), Power(Plus(j_DEFAULT, Times(k_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Plus(Dist(Subtract(Subtract(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), Log(Power(Plus(a, Times(b, x)), Times(p, r)))), Log(Power(Plus(c, Times(d, x)), Times(q, r)))), Int(Times(Plus(s, Times(t, Log(Times(i, Power(Plus(g, Times(h, x)), n))))), Power(Plus(j, Times(k, x)), CN1)), x), x), Int(Times(Log(Power(Plus(a, Times(b, x)), Times(p, r))), Plus(s, Times(t, Log(Times(i, Power(Plus(g, Times(h, x)), n))))), Power(Plus(j, Times(k, x)), CN1)), x), Int(Times(Log(Power(Plus(c, Times(d, x)), Times(q, r))), Plus(s, Times(t, Log(Times(i, Power(Plus(g, Times(h, x)), n))))), Power(Plus(j, Times(k, x)), CN1)), x)), And(FreeQ(List(a, b, c, d, e, f, g, h, i, j, k, s, t, n, p, q, r), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0))));
        }
    }
}
