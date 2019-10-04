package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sin;
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
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearMatchQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules133 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(3326, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(c, Times(d, x)), m), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), n)), x), FreeQ(List(a, b, c, d, e, f, m, n), x)));
            IIntegrate(3327, Int(Times(Power(u_, m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sin(v_))), n_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(ExpandToSum(u, x), m), Power(Plus(a, Times(b, Sin(ExpandToSum(v, x)))), n)), x), And(FreeQ(List(a, b, m, n), x), LinearQ(List(u, v), x), Not(LinearMatchQ(List(u, v), x)))));
            IIntegrate(3328, Int(Times(Power(Plus(a_DEFAULT, Times(Cos(v_), b_DEFAULT)), n_DEFAULT), Power(u_, m_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(ExpandToSum(u, x), m), Power(Plus(a, Times(b, Cos(ExpandToSum(v, x)))), n)), x), And(FreeQ(List(a, b, m, n), x), LinearQ(List(u, v), x), Not(LinearMatchQ(List(u, v), x)))));
            IIntegrate(3329, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Int(ExpandIntegrand(Sin(Plus(c, Times(d, x))), Power(Plus(a, Times(b, Power(x, n))), p), x), x), And(FreeQ(List(a, b, c, d, n), x), IGtQ(p, C0))));
            IIntegrate(3330, Int(Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Cos(Plus(c, Times(d, x))), Power(Plus(a, Times(b, Power(x, n))), p), x), x), And(FreeQ(List(a, b, c, d, n), x), IGtQ(p, C0))));
            IIntegrate(3331, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, Plus(Negate(n), C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Sin(Plus(c, Times(d, x))), Power(Times(b, n, Plus(p, C1)), CN1)), x), Negate(Dist(Times(Plus(Negate(n), C1), Power(Times(b, n, Plus(p, C1)), CN1)), Int(Times(Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Sin(Plus(c, Times(d, x))), Power(Power(x, n), CN1)), x), x)), Negate(Dist(Times(d, Power(Times(b, n, Plus(p, C1)), CN1)), Int(Times(Power(x, Plus(Negate(n), C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Cos(Plus(c, Times(d, x)))), x), x))), And(FreeQ(List(a, b, c, d), x), ILtQ(p, CN1), IGtQ(n, C2))));
            IIntegrate(3332, Int(Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, Plus(Negate(n), C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Cos(Plus(c, Times(d, x))), Power(Times(b, n, Plus(p, C1)), CN1)), x), Negate(Dist(Times(Plus(Negate(n), C1), Power(Times(b, n, Plus(p, C1)), CN1)), Int(Times(Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Cos(Plus(c, Times(d, x))), Power(Power(x, n), CN1)), x), x)), Dist(Times(d, Power(Times(b, n, Plus(p, C1)), CN1)), Int(Times(Power(x, Plus(Negate(n), C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Sin(Plus(c, Times(d, x)))), x), x)), And(FreeQ(List(a, b, c, d), x), ILtQ(p, CN1), IGtQ(n, C2))));
            IIntegrate(3333, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Int(ExpandIntegrand(Sin(Plus(c, Times(d, x))), Power(Plus(a, Times(b, Power(x, n))), p), x), x), And(FreeQ(List(a, b, c, d), x), ILtQ(p, C0), IGtQ(n, C0), Or(EqQ(n, C2), EqQ(p, CN1)))));
            IIntegrate(3334, Int(Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Cos(Plus(c, Times(d, x))), Power(Plus(a, Times(b, Power(x, n))), p), x), x), And(FreeQ(List(a, b, c, d), x), ILtQ(p, C0), IGtQ(n, C0), Or(EqQ(n, C2), EqQ(p, CN1)))));
            IIntegrate(3335, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Int(Times(Power(x, Times(n, p)), Power(Plus(b, Times(a, Power(Power(x, n), CN1))), p), Sin(Plus(c, Times(d, x)))), x), And(FreeQ(List(a, b, c, d), x), ILtQ(p, C0), ILtQ(n, C0))));
            IIntegrate(3336, Int(Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Int(Times(Power(x, Times(n, p)), Power(Plus(b, Times(a, Power(Power(x, n), CN1))), p), Cos(Plus(c, Times(d, x)))), x), And(FreeQ(List(a, b, c, d), x), ILtQ(p, C0), ILtQ(n, C0))));
            IIntegrate(3337, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(a, Times(b, Power(x, n))), p), Sin(Plus(c, Times(d, x)))), x), FreeQ(List(a, b, c, d, n, p), x)));
            IIntegrate(3338, Int(Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(a, Times(b, Power(x, n))), p), Cos(Plus(c, Times(d, x)))), x), FreeQ(List(a, b, c, d, n, p), x)));
            IIntegrate(3339, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Int(ExpandIntegrand(Sin(Plus(c, Times(d, x))), Times(Power(Times(e, x), m), Power(Plus(a, Times(b, Power(x, n))), p)), x), x), And(FreeQ(List(a, b, c, d, e, m, n), x), IGtQ(p, C0))));
            IIntegrate(3340, Int(Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Cos(Plus(c, Times(d, x))), Times(Power(Times(e, x), m), Power(Plus(a, Times(b, Power(x, n))), p)), x), x), And(FreeQ(List(a, b, c, d, e, m, n), x), IGtQ(p, C0))));
            IIntegrate(3341, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(e, m), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Sin(Plus(c, Times(d, x))), Power(Times(b, n, Plus(p, C1)), CN1)), x), Dist(Times(d, Power(e, m), Power(Times(b, n, Plus(p, C1)), CN1)), Int(Times(Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Cos(Plus(c, Times(d, x)))), x), x)), And(FreeQ(List(a, b, c, d, e, m, n), x), ILtQ(p, CN1), EqQ(m, Subtract(n, C1)), Or(IntegerQ(n), GtQ(e, C0)))));
            IIntegrate(3342, Int(Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(e, m), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Cos(Plus(c, Times(d, x))), Power(Times(b, n, Plus(p, C1)), CN1)), x), Dist(Times(d, Power(e, m), Power(Times(b, n, Plus(p, C1)), CN1)), Int(Times(Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Sin(Plus(c, Times(d, x)))), x), x)), And(FreeQ(List(a, b, c, d, e, m, n), x), ILtQ(p, CN1), EqQ(m, Subtract(n, C1)), Or(IntegerQ(n), GtQ(e, C0)))));
            IIntegrate(3343, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, Plus(m, Negate(n), C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Sin(Plus(c, Times(d, x))), Power(Times(b, n, Plus(p, C1)), CN1)), x), Negate(Dist(Times(Plus(m, Negate(n), C1), Power(Times(b, n, Plus(p, C1)), CN1)), Int(Times(Power(x, Subtract(m, n)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Sin(Plus(c, Times(d, x)))), x), x)), Negate(Dist(Times(d, Power(Times(b, n, Plus(p, C1)), CN1)), Int(Times(Power(x, Plus(m, Negate(n), C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Cos(Plus(c, Times(d, x)))), x), x))), And(FreeQ(List(a, b, c, d, m), x), ILtQ(p, CN1), IGtQ(n, C0), Or(GtQ(Plus(m, Negate(n), C1), C0), GtQ(n, C2)), RationalQ(m))));
            IIntegrate(3344, Int(Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, Plus(m, Negate(n), C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Cos(Plus(c, Times(d, x))), Power(Times(b, n, Plus(p, C1)), CN1)), x), Negate(Dist(Times(Plus(m, Negate(n), C1), Power(Times(b, n, Plus(p, C1)), CN1)), Int(Times(Power(x, Subtract(m, n)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Cos(Plus(c, Times(d, x)))), x), x)), Dist(Times(d, Power(Times(b, n, Plus(p, C1)), CN1)), Int(Times(Power(x, Plus(m, Negate(n), C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Sin(Plus(c, Times(d, x)))), x), x)), And(FreeQ(List(a, b, c, d, m), x), ILtQ(p, CN1), IGtQ(n, C0), Or(GtQ(Plus(m, Negate(n), C1), C0), GtQ(n, C2)), RationalQ(m))));
            IIntegrate(3345, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Int(ExpandIntegrand(Sin(Plus(c, Times(d, x))), Times(Power(x, m), Power(Plus(a, Times(b, Power(x, n))), p)), x), x), And(FreeQ(List(a, b, c, d, m), x), ILtQ(p, C0), IGtQ(n, C0), Or(EqQ(n, C2), EqQ(p, CN1)), IntegerQ(m))));
            IIntegrate(3346, Int(Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Cos(Plus(c, Times(d, x))), Times(Power(x, m), Power(Plus(a, Times(b, Power(x, n))), p)), x), x), And(FreeQ(List(a, b, c, d, m), x), ILtQ(p, C0), IGtQ(n, C0), Or(EqQ(n, C2), EqQ(p, CN1)), IntegerQ(m))));
            IIntegrate(3347, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Int(Times(Power(x, Plus(m, Times(n, p))), Power(Plus(b, Times(a, Power(Power(x, n), CN1))), p), Sin(Plus(c, Times(d, x)))), x), And(FreeQ(List(a, b, c, d, m), x), ILtQ(p, C0), ILtQ(n, C0))));
            IIntegrate(3348, Int(Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Int(Times(Power(x, Plus(m, Times(n, p))), Power(Plus(b, Times(a, Power(Power(x, n), CN1))), p), Cos(Plus(c, Times(d, x)))), x), And(FreeQ(List(a, b, c, d, m), x), ILtQ(p, C0), ILtQ(n, C0))));
            IIntegrate(3349, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Unintegrable(Times(Power(Times(e, x), m), Power(Plus(a, Times(b, Power(x, n))), p), Sin(Plus(c, Times(d, x)))), x), FreeQ(List(a, b, c, d, e, m, n, p), x)));
            IIntegrate(3350, Int(Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Times(e, x), m), Power(Plus(a, Times(b, Power(x, n))), p), Cos(Plus(c, Times(d, x)))), x), FreeQ(List(a, b, c, d, e, m, n, p), x)));
        }
    }
}
