package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Simplify;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.a_DEFAULT;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.g_;
import static org.matheclipse.core.expression.F.g_DEFAULT;
import static org.matheclipse.core.expression.F.k;
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
import static org.matheclipse.core.expression.F.r;
import static org.matheclipse.core.expression.F.r_;
import static org.matheclipse.core.expression.F.r_DEFAULT;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules23 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(576, Int(Times(Power(Times(g_DEFAULT, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_), Power(Plus(e_, Times(f_DEFAULT, Power(x_, n_))), r_)), x_Symbol),
                    Condition(With(List(Set(k, Denominator(m))), Dist(Times(k, Power(g, CN1)), Subst(Int(Times(Power(x, Subtract(Times(k, Plus(m, C1)), C1)), Power(Plus(a, Times(b, Power(x, Times(k, n)), Power(Power(g, n), CN1))), p), Power(Plus(c, Times(d, Power(x, Times(k, n)), Power(Power(g, n), CN1))), q), Power(Plus(e, Times(f, Power(x, Times(k, n)), Power(Power(g, n), CN1))), r)), x), x, Power(Times(g, x), Power(k, CN1))), x)), And(FreeQ(List(a, b, c, d, e, f, g, p, q, r), x), IGtQ(n, C0), FractionQ(m))));
            IIntegrate(577, Int(Times(Power(Times(g_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT), Plus(e_, Times(f_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Subtract(Times(b, e), Times(a, f)), Power(Times(g, x), Plus(m, C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), q), Power(Times(a, b, g, n, Plus(p, C1)), CN1)), x)), Dist(Power(Times(a, b, n, Plus(p, C1)), CN1), Int(Times(Power(Times(g, x), m), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), Subtract(q, C1)), Simp(Plus(Times(c, Plus(Times(b, e, n, Plus(p, C1)), Times(Subtract(Times(b, e), Times(a, f)), Plus(m, C1)))), Times(d, Plus(Times(b, e, n, Plus(p, C1)), Times(Subtract(Times(b, e), Times(a, f)), Plus(m, Times(n, q), C1))), Power(x, n))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, m), x), IGtQ(n, C0), LtQ(p, CN1), GtQ(q, C0), Not(And(EqQ(q, C1), SimplerQ(Subtract(Times(b, c), Times(a, d)), Subtract(Times(b, e), Times(a, f))))))));
            IIntegrate(578, Int(Times(Power(Times(g_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_), Plus(e_, Times(f_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(g, Subtract(n, C1)), Subtract(Times(b, e), Times(a, f)), Power(Times(g, x), Plus(m, Negate(n), C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), Plus(q, C1)), Power(Times(b, n, Subtract(Times(b, c), Times(a, d)), Plus(p, C1)), CN1)), x), Dist(Times(Power(g, n), Power(Times(b, n, Subtract(Times(b, c), Times(a, d)), Plus(p, C1)), CN1)), Int(Times(Power(Times(g, x), Subtract(m, n)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), q), Simp(Plus(Times(c, Subtract(Times(b, e), Times(a, f)), Plus(m, Negate(n), C1)), Times(Subtract(Times(d, Subtract(Times(b, e), Times(a, f)), Plus(m, Times(n, q), C1)), Times(b, n, Subtract(Times(c, f), Times(d, e)), Plus(p, C1))), Power(x, n))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, q), x), IGtQ(n, C0), LtQ(p, CN1), GtQ(Plus(m, Negate(n), C1), C0))));
            IIntegrate(579, Int(Times(Power(Times(g_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_), Plus(e_, Times(f_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Subtract(Times(b, e), Times(a, f)), Power(Times(g, x), Plus(m, C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), Plus(q, C1)), Power(Times(a, g, n, Subtract(Times(b, c), Times(a, d)), Plus(p, C1)), CN1)), x)), Dist(Power(Times(a, n, Subtract(Times(b, c), Times(a, d)), Plus(p, C1)), CN1), Int(Times(Power(Times(g, x), m), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), q), Simp(Plus(Times(c, Subtract(Times(b, e), Times(a, f)), Plus(m, C1)), Times(e, n, Subtract(Times(b, c), Times(a, d)), Plus(p, C1)), Times(d, Subtract(Times(b, e), Times(a, f)), Plus(m, Times(n, Plus(p, q, C2)), C1), Power(x, n))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, m, q), x), IGtQ(n, C0), LtQ(p, CN1))));
            IIntegrate(580, Int(Times(Power(Times(g_DEFAULT, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT), Plus(e_, Times(f_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Subtract(Simp(Times(e, Power(Times(g, x), Plus(m, C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), q), Power(Times(a, g, Plus(m, C1)), CN1)), x), Dist(Power(Times(a, Power(g, n), Plus(m, C1)), CN1), Int(Times(Power(Times(g, x), Plus(m, n)), Power(Plus(a, Times(b, Power(x, n))), p), Power(Plus(c, Times(d, Power(x, n))), Subtract(q, C1)), Simp(Plus(Times(c, Subtract(Times(b, e), Times(a, f)), Plus(m, C1)), Times(e, n, Plus(Times(b, c, Plus(p, C1)), Times(a, d, q))), Times(d, Plus(Times(Subtract(Times(b, e), Times(a, f)), Plus(m, C1)), Times(b, e, n, Plus(p, q, C1))), Power(x, n))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, p), x), IGtQ(n, C0), GtQ(q, C0), LtQ(m, CN1), Not(And(EqQ(q, C1), SimplerQ(Plus(e, Times(f, Power(x, n))), Plus(c, Times(d, Power(x, n)))))))));
            IIntegrate(581, Int(Times(Power(Times(g_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT), Plus(e_, Times(f_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Plus(Simp(Times(f, Power(Times(g, x), Plus(m, C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), q), Power(Times(b, g, Plus(m, Times(n, Plus(p, q, C1)), C1)), CN1)), x), Dist(Power(Times(b, Plus(m, Times(n, Plus(p, q, C1)), C1)), CN1), Int(Times(Power(Times(g, x), m), Power(Plus(a, Times(b, Power(x, n))), p), Power(Plus(c, Times(d, Power(x, n))), Subtract(q, C1)), Simp(Plus(Times(c, Plus(Times(Subtract(Times(b, e), Times(a, f)), Plus(m, C1)), Times(b, e, n, Plus(p, q, C1)))), Times(Plus(Times(d, Subtract(Times(b, e), Times(a, f)), Plus(m, C1)), Times(f, n, q, Subtract(Times(b, c), Times(a, d))), Times(b, e, d, n, Plus(p, q, C1))), Power(x, n))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, m, p), x), IGtQ(n, C0), GtQ(q, C0), Not(And(EqQ(q, C1), SimplerQ(Plus(e, Times(f, Power(x, n))), Plus(c, Times(d, Power(x, n)))))))));
            IIntegrate(582, Int(Times(Power(Times(g_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT), Plus(e_, Times(f_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Subtract(Simp(Times(f, Power(g, Subtract(n, C1)), Power(Times(g, x), Plus(m, Negate(n), C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), Plus(q, C1)), Power(Times(b, d, Plus(m, Times(n, Plus(p, q, C1)), C1)), CN1)), x), Dist(Times(Power(g, n), Power(Times(b, d, Plus(m, Times(n, Plus(p, q, C1)), C1)), CN1)), Int(Times(Power(Times(g, x), Subtract(m, n)), Power(Plus(a, Times(b, Power(x, n))), p), Power(Plus(c, Times(d, Power(x, n))), q), Simp(Plus(Times(a, f, c, Plus(m, Negate(n), C1)), Times(Plus(Times(a, f, d, Plus(m, Times(n, q), C1)), Times(b, Subtract(Times(f, c, Plus(m, Times(n, p), C1)), Times(e, d, Plus(m, Times(n, Plus(p, q, C1)), C1))))), Power(x, n))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, p, q), x), IGtQ(n, C0), GtQ(m, Subtract(n, C1)))));
            IIntegrate(583, Int(Times(Power(Times(g_DEFAULT, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT), Plus(e_, Times(f_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Plus(Simp(Times(e, Power(Times(g, x), Plus(m, C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), Plus(q, C1)), Power(Times(a, c, g, Plus(m, C1)), CN1)), x), Dist(Power(Times(a, c, Power(g, n), Plus(m, C1)), CN1), Int(Times(Power(Times(g, x), Plus(m, n)), Power(Plus(a, Times(b, Power(x, n))), p), Power(Plus(c, Times(d, Power(x, n))), q), Simp(Subtract(Subtract(Subtract(Times(a, f, c, Plus(m, C1)), Times(e, Plus(Times(b, c), Times(a, d)), Plus(m, n, C1))), Times(e, n, Plus(Times(b, c, p), Times(a, d, q)))), Times(b, e, d, Plus(m, Times(n, Plus(p, q, C2)), C1), Power(x, n))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, p, q), x), IGtQ(n, C0), LtQ(m, CN1))));
            IIntegrate(584, Int(Times(Power(Times(g_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), CN1), Plus(e_, Times(f_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Times(g, x), m), Power(Plus(a, Times(b, Power(x, n))), p), Plus(e, Times(f, Power(x, n))), Power(Plus(c, Times(d, Power(x, n))), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, m, p), x), IGtQ(n, C0))));
            IIntegrate(585, Int(Times(Power(Times(g_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT), Plus(e_, Times(f_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Plus(Dist(e, Int(Times(Power(Times(g, x), m), Power(Plus(a, Times(b, Power(x, n))), p), Power(Plus(c, Times(d, Power(x, n))), q)), x), x), Dist(Times(f, Power(Power(e, n), CN1)), Int(Times(Power(Times(g, x), Plus(m, n)), Power(Plus(a, Times(b, Power(x, n))), p), Power(Plus(c, Times(d, Power(x, n))), q)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, m, p, q), x), IGtQ(n, C0))));
            IIntegrate(586, Int(Times(Power(Times(g_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT), Power(Plus(e_, Times(f_DEFAULT, Power(x_, n_))), r_DEFAULT)), x_Symbol),
                    Condition(Plus(Dist(e, Int(Times(Power(Times(g, x), m), Power(Plus(a, Times(b, Power(x, n))), p), Power(Plus(c, Times(d, Power(x, n))), q), Power(Plus(e, Times(f, Power(x, n))), Subtract(r, C1))), x), x), Dist(Times(f, Power(Power(e, n), CN1)), Int(Times(Power(Times(g, x), Plus(m, n)), Power(Plus(a, Times(b, Power(x, n))), p), Power(Plus(c, Times(d, Power(x, n))), q), Power(Plus(e, Times(f, Power(x, n))), Subtract(r, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, m, p, q), x), IGtQ(n, C0), IGtQ(r, C0))));
            IIntegrate(587, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT), Power(Plus(e_, Times(f_DEFAULT, Power(x_, n_))), r_DEFAULT)), x_Symbol),
                    Condition(Negate(Subst(Int(Times(Power(Plus(a, Times(b, Power(Power(x, n), CN1))), p), Power(Plus(c, Times(d, Power(Power(x, n), CN1))), q), Power(Plus(e, Times(f, Power(Power(x, n), CN1))), r), Power(Power(x, Plus(m, C2)), CN1)), x), x, Power(x, CN1))), And(FreeQ(List(a, b, c, d, e, f, p, q, r), x), ILtQ(n, C0), IntegerQ(m))));
            IIntegrate(588, Int(Times(Power(Times(g_DEFAULT, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT), Power(Plus(e_, Times(f_DEFAULT, Power(x_, n_))), r_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(k, Denominator(m))), Negate(Dist(Times(k, Power(g, CN1)), Subst(Int(Times(Power(Plus(a, Times(b, Power(Times(Power(g, n), Power(x, Times(k, n))), CN1))), p), Power(Plus(c, Times(d, Power(Times(Power(g, n), Power(x, Times(k, n))), CN1))), q), Power(Plus(e, Times(f, Power(Times(Power(g, n), Power(x, Times(k, n))), CN1))), r), Power(Power(x, Plus(Times(k, Plus(m, C1)), C1)), CN1)), x), x, Power(Power(Times(g, x), Power(k, CN1)), CN1)), x))), And(FreeQ(List(a, b, c, d, e, f, g, p, q, r), x), ILtQ(n, C0), FractionQ(m))));
            IIntegrate(589, Int(Times(Power(Times(g_DEFAULT, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT), Power(Plus(e_, Times(f_DEFAULT, Power(x_, n_))), r_DEFAULT)), x_Symbol),
                    Condition(Negate(Dist(Times(Power(Times(g, x), m), Power(Power(x, CN1), m)), Subst(Int(Times(Power(Plus(a, Times(b, Power(Power(x, n), CN1))), p), Power(Plus(c, Times(d, Power(Power(x, n), CN1))), q), Power(Plus(e, Times(f, Power(Power(x, n), CN1))), r), Power(Power(x, Plus(m, C2)), CN1)), x), x, Power(x, CN1)), x)), And(FreeQ(List(a, b, c, d, e, f, g, m, p, q, r), x), ILtQ(n, C0), Not(RationalQ(m)))));
            IIntegrate(590, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT), Power(Plus(e_, Times(f_DEFAULT, Power(x_, n_))), r_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(k, Denominator(n))), Dist(k, Subst(Int(Times(Power(x, Subtract(Times(k, Plus(m, C1)), C1)), Power(Plus(a, Times(b, Power(x, Times(k, n)))), p), Power(Plus(c, Times(d, Power(x, Times(k, n)))), q), Power(Plus(e, Times(f, Power(x, Times(k, n)))), r)), x), x, Power(x, Power(k, CN1))), x)), And(FreeQ(List(a, b, c, d, e, f, m, p, q, r), x), FractionQ(n))));
            IIntegrate(591, Int(Times(Power(Times(g_, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT), Power(Plus(e_, Times(f_DEFAULT, Power(x_, n_))), r_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(g, IntPart(m)), Power(Times(g, x), FracPart(m)), Power(Power(x, FracPart(m)), CN1)), Int(Times(Power(x, m), Power(Plus(a, Times(b, Power(x, n))), p), Power(Plus(c, Times(d, Power(x, n))), q), Power(Plus(e, Times(f, Power(x, n))), r)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, m, p, q, r), x), FractionQ(n))));
            IIntegrate(592, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT), Power(Plus(e_, Times(f_DEFAULT, Power(x_, n_))), r_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Plus(m, C1), CN1), Subst(Int(Times(Power(Plus(a, Times(b, Power(x, Simplify(Times(n, Power(Plus(m, C1), CN1)))))), p), Power(Plus(c, Times(d, Power(x, Simplify(Times(n, Power(Plus(m, C1), CN1)))))), q), Power(Plus(e, Times(f, Power(x, Simplify(Times(n, Power(Plus(m, C1), CN1)))))), r)), x), x, Power(x, Plus(m, C1))), x), And(FreeQ(List(a, b, c, d, e, f, m, n, p, q, r), x), IntegerQ(Simplify(Times(n, Power(Plus(m, C1), CN1)))))));
            IIntegrate(593, Int(Times(Power(Times(g_, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT), Power(Plus(e_, Times(f_DEFAULT, Power(x_, n_))), r_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(g, IntPart(m)), Power(Times(g, x), FracPart(m)), Power(Power(x, FracPart(m)), CN1)), Int(Times(Power(x, m), Power(Plus(a, Times(b, Power(x, n))), p), Power(Plus(c, Times(d, Power(x, n))), q), Power(Plus(e, Times(f, Power(x, n))), r)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, m, n, p, q, r), x), IntegerQ(Simplify(Times(n, Power(Plus(m, C1), CN1)))))));
            IIntegrate(594, Int(Times(Power(Times(g_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT), Plus(e_, Times(f_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Subtract(Times(b, e), Times(a, f)), Power(Times(g, x), Plus(m, C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), q), Power(Times(a, b, g, n, Plus(p, C1)), CN1)), x)), Dist(Power(Times(a, b, n, Plus(p, C1)), CN1), Int(Times(Power(Times(g, x), m), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), Subtract(q, C1)), Simp(Plus(Times(c, Plus(Times(b, e, n, Plus(p, C1)), Times(Subtract(Times(b, e), Times(a, f)), Plus(m, C1)))), Times(d, Plus(Times(b, e, n, Plus(p, C1)), Times(Subtract(Times(b, e), Times(a, f)), Plus(m, Times(n, q), C1))), Power(x, n))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, m, n), x), LtQ(p, CN1), GtQ(q, C0), Not(And(EqQ(q, C1), SimplerQ(Subtract(Times(b, c), Times(a, d)), Subtract(Times(b, e), Times(a, f))))))));
            IIntegrate(595, Int(Times(Power(Times(g_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_), Plus(e_, Times(f_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Subtract(Times(b, e), Times(a, f)), Power(Times(g, x), Plus(m, C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), Plus(q, C1)), Power(Times(a, g, n, Subtract(Times(b, c), Times(a, d)), Plus(p, C1)), CN1)), x)), Dist(Power(Times(a, n, Subtract(Times(b, c), Times(a, d)), Plus(p, C1)), CN1), Int(Times(Power(Times(g, x), m), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), q), Simp(Plus(Times(c, Subtract(Times(b, e), Times(a, f)), Plus(m, C1)), Times(e, n, Subtract(Times(b, c), Times(a, d)), Plus(p, C1)), Times(d, Subtract(Times(b, e), Times(a, f)), Plus(m, Times(n, Plus(p, q, C2)), C1), Power(x, n))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, m, n, q), x), LtQ(p, CN1))));
            IIntegrate(596, Int(Times(Power(Times(g_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT), Plus(e_, Times(f_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Plus(Simp(Times(f, Power(Times(g, x), Plus(m, C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), q), Power(Times(b, g, Plus(m, Times(n, Plus(p, q, C1)), C1)), CN1)), x), Dist(Power(Times(b, Plus(m, Times(n, Plus(p, q, C1)), C1)), CN1), Int(Times(Power(Times(g, x), m), Power(Plus(a, Times(b, Power(x, n))), p), Power(Plus(c, Times(d, Power(x, n))), Subtract(q, C1)), Simp(Plus(Times(c, Plus(Times(Subtract(Times(b, e), Times(a, f)), Plus(m, C1)), Times(b, e, n, Plus(p, q, C1)))), Times(Plus(Times(d, Subtract(Times(b, e), Times(a, f)), Plus(m, C1)), Times(f, n, q, Subtract(Times(b, c), Times(a, d))), Times(b, e, d, n, Plus(p, q, C1))), Power(x, n))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, m, n, p), x), GtQ(q, C0), Not(And(EqQ(q, C1), SimplerQ(Plus(e, Times(f, Power(x, n))), Plus(c, Times(d, Power(x, n)))))))));
            IIntegrate(597, Int(Times(Power(Times(g_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), CN1), Plus(e_, Times(f_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Times(g, x), m), Power(Plus(a, Times(b, Power(x, n))), p), Plus(e, Times(f, Power(x, n))), Power(Plus(c, Times(d, Power(x, n))), CN1)), x), x), FreeQ(List(a, b, c, d, e, f, g, m, n, p), x)));
            IIntegrate(598, Int(Times(Power(Times(g_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_), Plus(e_, Times(f_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Plus(Dist(e, Int(Times(Power(Times(g, x), m), Power(Plus(a, Times(b, Power(x, n))), p), Power(Plus(c, Times(d, Power(x, n))), q)), x), x), Dist(Times(f, Power(Times(g, x), m), Power(Power(x, m), CN1)), Int(Times(Power(x, Plus(m, n)), Power(Plus(a, Times(b, Power(x, n))), p), Power(Plus(c, Times(d, Power(x, n))), q)), x), x)), FreeQ(List(a, b, c, d, e, f, g, m, n, p, q), x)));
            IIntegrate(599, Int(Times(Power(x_, m_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, $p("mn", true)))), q_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_DEFAULT))), p_DEFAULT), Power(Plus(e_, Times(f_DEFAULT, Power(x_, n_DEFAULT))), r_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(x, Subtract(m, Times(n, q))), Power(Plus(a, Times(b, Power(x, n))), p), Power(Plus(d, Times(c, Power(x, n))), q), Power(Plus(e, Times(f, Power(x, n))), r)), x), And(FreeQ(List(a, b, c, d, e, f, m, n, p, r), x), EqQ($s("mn"), Negate(n)), IntegerQ(q))));
            IIntegrate(600, Int(Times(Power(x_, m_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, $p("mn", true)))), q_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT))), p_DEFAULT), Power(Plus(e_, Times(f_DEFAULT, Power(x_, n_DEFAULT))), r_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(x, Plus(m, Times(n, Plus(p, r)))), Power(Plus(b, Times(a, Power(Power(x, n), CN1))), p), Power(Plus(c, Times(d, Power(Power(x, n), CN1))), q), Power(Plus(f, Times(e, Power(Power(x, n), CN1))), r)), x), And(FreeQ(List(a, b, c, d, e, f, m, n, q), x), EqQ($s("mn"), Negate(n)), IntegerQ(p), IntegerQ(r))));
        }
    }
}
