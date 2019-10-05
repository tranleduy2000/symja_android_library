package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcCoth;
import static org.matheclipse.core.expression.F.ArcTanh;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.MatchQ;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.With;
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
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntHide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules243 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(6076, Int(Times(ArcCoth(Times(c_DEFAULT, x_)), Log(Plus(f_DEFAULT, Times(g_DEFAULT, Sqr(x_)))), Power(x_, CN1)), x_Symbol),
                    Condition(Plus(Dist(Subtract(Subtract(Subtract(Log(Plus(f, Times(g, Sqr(x)))), Log(Times(CN1, Sqr(c), Sqr(x)))), Log(Subtract(C1, Power(Times(c, x), CN1)))), Log(Plus(C1, Power(Times(c, x), CN1)))), Int(Times(ArcCoth(Times(c, x)), Power(x, CN1)), x), x), Negate(Dist(C1D2, Int(Times(Sqr(Log(Subtract(C1, Power(Times(c, x), CN1)))), Power(x, CN1)), x), x)), Dist(C1D2, Int(Times(Sqr(Log(Plus(C1, Power(Times(c, x), CN1)))), Power(x, CN1)), x), x), Int(Times(Log(Times(CN1, Sqr(c), Sqr(x))), ArcCoth(Times(c, x)), Power(x, CN1)), x)), And(FreeQ(List(c, f, g), x), EqQ(Plus(Times(Sqr(c), f), g), C0))));
            IIntegrate(6077, Int(Times(Log(Plus(f_DEFAULT, Times(g_DEFAULT, Sqr(x_)))), Plus(Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT), a_), Power(x_, CN1)), x_Symbol),
                    Condition(Plus(Dist(a, Int(Times(Log(Plus(f, Times(g, Sqr(x)))), Power(x, CN1)), x), x), Dist(b, Int(Times(Log(Plus(f, Times(g, Sqr(x)))), ArcTanh(Times(c, x)), Power(x, CN1)), x), x)), FreeQ(List(a, b, c, f, g), x)));
            IIntegrate(6078, Int(Times(Log(Plus(f_DEFAULT, Times(g_DEFAULT, Sqr(x_)))), Plus(Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT), a_), Power(x_, CN1)), x_Symbol),
                    Condition(Plus(Dist(a, Int(Times(Log(Plus(f, Times(g, Sqr(x)))), Power(x, CN1)), x), x), Dist(b, Int(Times(Log(Plus(f, Times(g, Sqr(x)))), ArcCoth(Times(c, x)), Power(x, CN1)), x), x)), FreeQ(List(a, b, c, f, g), x)));
            IIntegrate(6079, Int(Times(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), Plus(Times(Log(Plus(f_DEFAULT, Times(g_DEFAULT, Sqr(x_)))), e_DEFAULT), d_), Power(x_, CN1)), x_Symbol),
                    Condition(Plus(Dist(d, Int(Times(Plus(a, Times(b, ArcTanh(Times(c, x)))), Power(x, CN1)), x), x), Dist(e, Int(Times(Log(Plus(f, Times(g, Sqr(x)))), Plus(a, Times(b, ArcTanh(Times(c, x)))), Power(x, CN1)), x), x)), FreeQ(List(a, b, c, d, e, f, g), x)));
            IIntegrate(6080, Int(Times(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), Plus(Times(Log(Plus(f_DEFAULT, Times(g_DEFAULT, Sqr(x_)))), e_DEFAULT), d_), Power(x_, CN1)), x_Symbol),
                    Condition(Plus(Dist(d, Int(Times(Plus(a, Times(b, ArcCoth(Times(c, x)))), Power(x, CN1)), x), x), Dist(e, Int(Times(Log(Plus(f, Times(g, Sqr(x)))), Plus(a, Times(b, ArcCoth(Times(c, x)))), Power(x, CN1)), x), x)), FreeQ(List(a, b, c, d, e, f, g), x)));
            IIntegrate(6081, Int(Times(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), Plus(d_DEFAULT, Times(Log(Plus(f_DEFAULT, Times(g_DEFAULT, Sqr(x_)))), e_DEFAULT)), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, Plus(m, C1)), Plus(d, Times(e, Log(Plus(f, Times(g, Sqr(x)))))), Plus(a, Times(b, ArcTanh(Times(c, x)))), Power(Plus(m, C1), CN1)), x), Negate(Dist(Times(b, c, Power(Plus(m, C1), CN1)), Int(Times(Power(x, Plus(m, C1)), Plus(d, Times(e, Log(Plus(f, Times(g, Sqr(x)))))), Power(Subtract(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x)), Negate(Dist(Times(C2, e, g, Power(Plus(m, C1), CN1)), Int(Times(Power(x, Plus(m, C2)), Plus(a, Times(b, ArcTanh(Times(c, x)))), Power(Plus(f, Times(g, Sqr(x))), CN1)), x), x))), And(FreeQ(List(a, b, c, d, e, f, g), x), ILtQ(Times(C1D2, m), C0))));
            IIntegrate(6082, Int(Times(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), Plus(d_DEFAULT, Times(Log(Plus(f_DEFAULT, Times(g_DEFAULT, Sqr(x_)))), e_DEFAULT)), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, Plus(m, C1)), Plus(d, Times(e, Log(Plus(f, Times(g, Sqr(x)))))), Plus(a, Times(b, ArcCoth(Times(c, x)))), Power(Plus(m, C1), CN1)), x), Negate(Dist(Times(b, c, Power(Plus(m, C1), CN1)), Int(Times(Power(x, Plus(m, C1)), Plus(d, Times(e, Log(Plus(f, Times(g, Sqr(x)))))), Power(Subtract(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x)), Negate(Dist(Times(C2, e, g, Power(Plus(m, C1), CN1)), Int(Times(Power(x, Plus(m, C2)), Plus(a, Times(b, ArcCoth(Times(c, x)))), Power(Plus(f, Times(g, Sqr(x))), CN1)), x), x))), And(FreeQ(List(a, b, c, d, e, f, g), x), ILtQ(Times(C1D2, m), C0))));
            IIntegrate(6083, Int(Times(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), Plus(d_DEFAULT, Times(Log(Plus(f_DEFAULT, Times(g_DEFAULT, Sqr(x_)))), e_DEFAULT)), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Times(Power(x, m), Plus(d, Times(e, Log(Plus(f, Times(g, Sqr(x))))))), x))), Subtract(Dist(Plus(a, Times(b, ArcTanh(Times(c, x)))), u, x), Dist(Times(b, c), Int(ExpandIntegrand(Times(u, Power(Subtract(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x), x))), And(FreeQ(List(a, b, c, d, e, f, g), x), IGtQ(Times(C1D2, Plus(m, C1)), C0))));
            IIntegrate(6084, Int(Times(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), Plus(d_DEFAULT, Times(Log(Plus(f_DEFAULT, Times(g_DEFAULT, Sqr(x_)))), e_DEFAULT)), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Times(Power(x, m), Plus(d, Times(e, Log(Plus(f, Times(g, Sqr(x))))))), x))), Subtract(Dist(Plus(a, Times(b, ArcCoth(Times(c, x)))), u, x), Dist(Times(b, c), Int(ExpandIntegrand(Times(u, Power(Subtract(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x), x))), And(FreeQ(List(a, b, c, d, e, f, g), x), IGtQ(Times(C1D2, Plus(m, C1)), C0))));
            IIntegrate(6085, Int(Times(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), Plus(d_DEFAULT, Times(Log(Plus(f_DEFAULT, Times(g_DEFAULT, Sqr(x_)))), e_DEFAULT)), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Times(Power(x, m), Plus(a, Times(b, ArcTanh(Times(c, x))))), x))), Subtract(Dist(Plus(d, Times(e, Log(Plus(f, Times(g, Sqr(x)))))), u, x), Dist(Times(C2, e, g), Int(ExpandIntegrand(Times(x, u, Power(Plus(f, Times(g, Sqr(x))), CN1)), x), x), x))), And(FreeQ(List(a, b, c, d, e, f, g), x), IntegerQ(m), NeQ(m, CN1))));
            IIntegrate(6086, Int(Times(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), Plus(d_DEFAULT, Times(Log(Plus(f_DEFAULT, Times(g_DEFAULT, Sqr(x_)))), e_DEFAULT)), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Times(Power(x, m), Plus(a, Times(b, ArcCoth(Times(c, x))))), x))), Subtract(Dist(Plus(d, Times(e, Log(Plus(f, Times(g, Sqr(x)))))), u, x), Dist(Times(C2, e, g), Int(ExpandIntegrand(Times(x, u, Power(Plus(f, Times(g, Sqr(x))), CN1)), x), x), x))), And(FreeQ(List(a, b, c, d, e, f, g), x), IntegerQ(m), NeQ(m, CN1))));
            IIntegrate(6087, Int(Times(Sqr(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT))), Plus(d_DEFAULT, Times(Log(Plus(f_, Times(g_DEFAULT, Sqr(x_)))), e_DEFAULT)), x_), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(f, Times(g, Sqr(x))), Plus(d, Times(e, Log(Plus(f, Times(g, Sqr(x)))))), Sqr(Plus(a, Times(b, ArcTanh(Times(c, x))))), Power(Times(C2, g), CN1)), x), Dist(Times(b, Power(c, CN1)), Int(Times(Plus(d, Times(e, Log(Plus(f, Times(g, Sqr(x)))))), Plus(a, Times(b, ArcTanh(Times(c, x))))), x), x), Dist(Times(b, c, e), Int(Times(Sqr(x), Plus(a, Times(b, ArcTanh(Times(c, x)))), Power(Subtract(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x), Negate(Simp(Times(C1D2, e, Sqr(x), Sqr(Plus(a, Times(b, ArcTanh(Times(c, x)))))), x))), And(FreeQ(List(a, b, c, d, e, f, g), x), EqQ(Plus(Times(Sqr(c), f), g), C0))));
            IIntegrate(6088, Int(Times(Sqr(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT))), Plus(d_DEFAULT, Times(Log(Plus(f_, Times(g_DEFAULT, Sqr(x_)))), e_DEFAULT)), x_), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(f, Times(g, Sqr(x))), Plus(d, Times(e, Log(Plus(f, Times(g, Sqr(x)))))), Sqr(Plus(a, Times(b, ArcCoth(Times(c, x))))), Power(Times(C2, g), CN1)), x), Dist(Times(b, Power(c, CN1)), Int(Times(Plus(d, Times(e, Log(Plus(f, Times(g, Sqr(x)))))), Plus(a, Times(b, ArcCoth(Times(c, x))))), x), x), Dist(Times(b, c, e), Int(Times(Sqr(x), Plus(a, Times(b, ArcCoth(Times(c, x)))), Power(Subtract(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x), Negate(Simp(Times(C1D2, e, Sqr(x), Sqr(Plus(a, Times(b, ArcCoth(Times(c, x)))))), x))), And(FreeQ(List(a, b, c, d, e, f, g), x), EqQ(Plus(Times(Sqr(c), f), g), C0))));
            IIntegrate(6089, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), u_DEFAULT), x_Symbol),
                    Condition(Unintegrable(Times(u, Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), p)), x), And(FreeQ(List(a, b, c, p), x), Or(EqQ(u, C1), MatchQ(u, Condition(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x)), q_DEFAULT), FreeQ(List(d, e, q), x))), MatchQ(u, Condition(Times(Power(Times(f_DEFAULT, x), m_DEFAULT), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x)), q_DEFAULT)), FreeQ(List(d, e, f, m, q), x))), MatchQ(u, Condition(Power(Plus(d_DEFAULT, Times(e_DEFAULT, Sqr(x))), q_DEFAULT), FreeQ(List(d, e, q), x))), MatchQ(u, Condition(Times(Power(Times(f_DEFAULT, x), m_DEFAULT), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Sqr(x))), q_DEFAULT)), FreeQ(List(d, e, f, m, q), x)))))));
            IIntegrate(6090, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), u_DEFAULT), x_Symbol),
                    Condition(Unintegrable(Times(u, Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p)), x), And(FreeQ(List(a, b, c, p), x), Or(EqQ(u, C1), MatchQ(u, Condition(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x)), q_DEFAULT), FreeQ(List(d, e, q), x))), MatchQ(u, Condition(Times(Power(Times(f_DEFAULT, x), m_DEFAULT), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x)), q_DEFAULT)), FreeQ(List(d, e, f, m, q), x))), MatchQ(u, Condition(Power(Plus(d_DEFAULT, Times(e_DEFAULT, Sqr(x))), q_DEFAULT), FreeQ(List(d, e, q), x))), MatchQ(u, Condition(Times(Power(Times(f_DEFAULT, x), m_DEFAULT), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Sqr(x))), q_DEFAULT)), FreeQ(List(d, e, f, m, q), x)))))));
            IIntegrate(6091, Int(ArcTanh(Times(c_DEFAULT, Power(x_, n_))), x_Symbol),
                    Condition(Subtract(Simp(Times(x, ArcTanh(Times(c, Power(x, n)))), x), Dist(Times(c, n), Int(Times(Power(x, n), Power(Subtract(C1, Times(Sqr(c), Power(x, Times(C2, n)))), CN1)), x), x)), FreeQ(List(c, n), x)));
            IIntegrate(6092, Int(ArcCoth(Times(c_DEFAULT, Power(x_, n_))), x_Symbol),
                    Condition(Subtract(Simp(Times(x, ArcCoth(Times(c, Power(x, n)))), x), Dist(Times(c, n), Int(Times(Power(x, n), Power(Subtract(C1, Times(Sqr(c), Power(x, Times(C2, n)))), CN1)), x), x)), FreeQ(List(c, n), x)));
            IIntegrate(6093, Int(Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, Power(x_, n_))), b_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Subtract(Plus(a, Times(C1D2, b, Log(Plus(C1, Times(c, Power(x, n)))))), Times(C1D2, b, Log(Subtract(C1, Times(c, Power(x, n)))))), p), x), x), And(FreeQ(List(a, b, c, n), x), IGtQ(p, C0), IntegerQ(n))));
            IIntegrate(6094, Int(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, Power(x_, n_))), b_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Subtract(Plus(a, Times(C1D2, b, Log(Plus(C1, Power(Times(Power(x, n), c), CN1))))), Times(C1D2, b, Log(Subtract(C1, Power(Times(Power(x, n), c), CN1))))), p), x), x), And(FreeQ(List(a, b, c, n), x), IGtQ(p, C0), IntegerQ(n))));
            IIntegrate(6095, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, Power(x_, n_))), b_DEFAULT)), p_DEFAULT), Power(x_, CN1)), x_Symbol),
                    Condition(Dist(Power(n, CN1), Subst(Int(Times(Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), p), Power(x, CN1)), x), x, Power(x, n)), x), And(FreeQ(List(a, b, c, n), x), IGtQ(p, C0))));
            IIntegrate(6096, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, Power(x_, n_))), b_DEFAULT)), p_DEFAULT), Power(x_, CN1)), x_Symbol),
                    Condition(Dist(Power(n, CN1), Subst(Int(Times(Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p), Power(x, CN1)), x), x, Power(x, n)), x), And(FreeQ(List(a, b, c, n), x), IGtQ(p, C0))));
            IIntegrate(6097, Int(Times(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, Power(x_, n_))), b_DEFAULT)), Power(Times(d_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(d, x), Plus(m, C1)), Plus(a, Times(b, ArcTanh(Times(c, Power(x, n))))), Power(Times(d, Plus(m, C1)), CN1)), x), Dist(Times(b, c, n, Power(Times(d, Plus(m, C1)), CN1)), Int(Times(Power(x, Subtract(n, C1)), Power(Times(d, x), Plus(m, C1)), Power(Subtract(C1, Times(Sqr(c), Power(x, Times(C2, n)))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, m, n), x), NeQ(m, CN1))));
            IIntegrate(6098, Int(Times(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, Power(x_, n_))), b_DEFAULT)), Power(Times(d_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(d, x), Plus(m, C1)), Plus(a, Times(b, ArcCoth(Times(c, Power(x, n))))), Power(Times(d, Plus(m, C1)), CN1)), x), Dist(Times(b, c, n, Power(Times(d, Plus(m, C1)), CN1)), Int(Times(Power(x, Subtract(n, C1)), Power(Times(d, x), Plus(m, C1)), Power(Subtract(C1, Times(Sqr(c), Power(x, Times(C2, n)))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, m, n), x), NeQ(m, CN1))));
            IIntegrate(6099, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, Power(x_, n_))), b_DEFAULT)), p_DEFAULT), Power(Times(d_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Times(d, x), m), Power(Subtract(Plus(a, Times(C1D2, b, Log(Plus(C1, Times(c, Power(x, n)))))), Times(C1D2, b, Log(Subtract(C1, Times(c, Power(x, n)))))), p)), x), x), And(FreeQ(List(a, b, c, d, m, n), x), IGtQ(p, C0), IntegerQ(m), IntegerQ(n))));
            IIntegrate(6100, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, Power(x_, n_))), b_DEFAULT)), p_DEFAULT), Power(Times(d_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Times(d, x), m), Power(Subtract(Plus(a, Times(C1D2, b, Log(Plus(C1, Power(Times(Power(x, n), c), CN1))))), Times(C1D2, b, Log(Subtract(C1, Power(Times(Power(x, n), c), CN1))))), p)), x), x), And(FreeQ(List(a, b, c, d, m, n), x), IGtQ(p, C0), IntegerQ(m), IntegerQ(n))));
        }
    }
}
