package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.If;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Module;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_DEFAULT;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.g_DEFAULT;
import static org.matheclipse.core.expression.F.h;
import static org.matheclipse.core.expression.F.h_DEFAULT;
import static org.matheclipse.core.expression.F.k;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialMatchQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandTrigReduce;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearMatchQ;
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
public class IntRules137 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(3426, Int(Times(Power(Plus(a_DEFAULT, Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))), b_DEFAULT)), p_), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrigReduce(Power(Times(e, x), m), Power(Plus(a, Times(b, Cos(Plus(c, Times(d, Power(x, n)))))), p), x), x), And(FreeQ(List(a, b, c, d, e, m, n), x), IGtQ(p, C0))));
            IIntegrate(3427, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sin(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))))), p_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Times(e, x), m), Power(Plus(a, Times(b, Sin(Plus(c, Times(d, Power(x, n)))))), p)), x), FreeQ(List(a, b, c, d, e, m, n, p), x)));
            IIntegrate(3428, Int(Times(Power(Plus(a_DEFAULT, Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))), b_DEFAULT)), p_DEFAULT), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Times(e, x), m), Power(Plus(a, Times(b, Cos(Plus(c, Times(d, Power(x, n)))))), p)), x), FreeQ(List(a, b, c, d, e, m, n, p), x)));
            IIntegrate(3429, Int(Times(Power(Times(e_, x_), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sin(u_))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Times(e, x), m), Power(Plus(a, Times(b, Sin(ExpandToSum(u, x)))), p)), x), And(FreeQ(List(a, b, e, m, p), x), BinomialQ(u, x), Not(BinomialMatchQ(u, x)))));
            IIntegrate(3430, Int(Times(Power(Plus(a_DEFAULT, Times(Cos(u_), b_DEFAULT)), p_DEFAULT), Power(Times(e_, x_), m_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Times(e, x), m), Power(Plus(a, Times(b, Cos(ExpandToSum(u, x)))), p)), x), And(FreeQ(List(a, b, e, m, p), x), BinomialQ(u, x), Not(BinomialMatchQ(u, x)))));
            IIntegrate(3431, Int(Times(Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sin(Plus(c_DEFAULT, Times(d_DEFAULT, Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), n_)))))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Times(n, f), CN1), Subst(Int(ExpandIntegrand(Power(Plus(a, Times(b, Sin(Plus(c, Times(d, x))))), p), Times(Power(x, Subtract(Power(n, CN1), C1)), Power(Plus(g, Times(CN1, e, h, Power(f, CN1)), Times(h, Power(x, Power(n, CN1)), Power(f, CN1))), m)), x), x), x, Power(Plus(e, Times(f, x)), n)), x), And(FreeQ(List(a, b, c, d, e, f, g, h, m), x), IGtQ(p, C0), IntegerQ(Power(n, CN1)))));
            IIntegrate(3432, Int(Times(Power(Plus(a_DEFAULT, Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), n_)))), b_DEFAULT)), p_DEFAULT), Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Times(n, f), CN1), Subst(Int(ExpandIntegrand(Power(Plus(a, Times(b, Cos(Plus(c, Times(d, x))))), p), Times(Power(x, Subtract(Power(n, CN1), C1)), Power(Plus(g, Times(CN1, e, h, Power(f, CN1)), Times(h, Power(x, Power(n, CN1)), Power(f, CN1))), m)), x), x), x, Power(Plus(e, Times(f, x)), n)), x), And(FreeQ(List(a, b, c, d, e, f, g, h, m), x), IGtQ(p, C0), IntegerQ(Power(n, CN1)))));
            IIntegrate(3433, Int(Times(Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sin(Plus(c_DEFAULT, Times(d_DEFAULT, Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), n_)))))), p_DEFAULT)), x_Symbol),
                    Condition(Module(List(Set(k, If(FractionQ(n), Denominator(n), C1))), Dist(Times(k, Power(Power(f, Plus(m, C1)), CN1)), Subst(Int(ExpandIntegrand(Power(Plus(a, Times(b, Sin(Plus(c, Times(d, Power(x, Times(k, n))))))), p), Times(Power(x, Subtract(k, C1)), Power(Plus(Times(f, g), Times(CN1, e, h), Times(h, Power(x, k))), m)), x), x), x, Power(Plus(e, Times(f, x)), Power(k, CN1))), x)), And(FreeQ(List(a, b, c, d, e, f, g, h), x), IGtQ(p, C0), IGtQ(m, C0))));
            IIntegrate(3434, Int(Times(Power(Plus(a_DEFAULT, Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), n_)))), b_DEFAULT)), p_DEFAULT), Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Module(List(Set(k, If(FractionQ(n), Denominator(n), C1))), Dist(Times(k, Power(Power(f, Plus(m, C1)), CN1)), Subst(Int(ExpandIntegrand(Power(Plus(a, Times(b, Cos(Plus(c, Times(d, Power(x, Times(k, n))))))), p), Times(Power(x, Subtract(k, C1)), Power(Plus(Times(f, g), Times(CN1, e, h), Times(h, Power(x, k))), m)), x), x), x, Power(Plus(e, Times(f, x)), Power(k, CN1))), x)), And(FreeQ(List(a, b, c, d, e, f, g, h), x), IGtQ(p, C0), IGtQ(m, C0))));
            IIntegrate(3435, Int(Times(Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sin(Plus(c_DEFAULT, Times(d_DEFAULT, Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), n_)))))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(f, CN1), Subst(Int(Times(Power(Times(h, x, Power(f, CN1)), m), Power(Plus(a, Times(b, Sin(Plus(c, Times(d, Power(x, n)))))), p)), x), x, Plus(e, Times(f, x))), x), And(FreeQ(List(a, b, c, d, e, f, g, h, m), x), IGtQ(p, C0), EqQ(Subtract(Times(f, g), Times(e, h)), C0))));
            IIntegrate(3436, Int(Times(Power(Plus(a_DEFAULT, Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), n_)))), b_DEFAULT)), p_DEFAULT), Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(f, CN1), Subst(Int(Times(Power(Times(h, x, Power(f, CN1)), m), Power(Plus(a, Times(b, Cos(Plus(c, Times(d, Power(x, n)))))), p)), x), x, Plus(e, Times(f, x))), x), And(FreeQ(List(a, b, c, d, e, f, g, h, m), x), IGtQ(p, C0), EqQ(Subtract(Times(f, g), Times(e, h)), C0))));
            IIntegrate(3437, Int(Times(Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sin(Plus(c_DEFAULT, Times(d_DEFAULT, Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), n_)))))), p_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(g, Times(h, x)), m), Power(Plus(a, Times(b, Sin(Plus(c, Times(d, Power(Plus(e, Times(f, x)), n)))))), p)), x), FreeQ(List(a, b, c, d, e, f, g, h, m, n, p), x)));
            IIntegrate(3438, Int(Times(Power(Plus(a_DEFAULT, Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), n_)))), b_DEFAULT)), p_DEFAULT), Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(g, Times(h, x)), m), Power(Plus(a, Times(b, Cos(Plus(c, Times(d, Power(Plus(e, Times(f, x)), n)))))), p)), x), FreeQ(List(a, b, c, d, e, f, g, h, m, n, p), x)));
            IIntegrate(3439, Int(Times(Power(v_, m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sin(Plus(c_DEFAULT, Times(d_DEFAULT, Power(u_, n_)))))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(ExpandToSum(v, x), m), Power(Plus(a, Times(b, Sin(Plus(c, Times(d, Power(ExpandToSum(u, x), n)))))), p)), x), And(FreeQ(List(a, b, c, d, m, n, p), x), LinearQ(u, x), LinearQ(v, x), Not(And(LinearMatchQ(u, x), LinearMatchQ(v, x))))));
            IIntegrate(3440, Int(Times(Power(Plus(a_DEFAULT, Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, Power(u_, n_)))), b_DEFAULT)), p_DEFAULT), Power(v_, m_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(ExpandToSum(v, x), m), Power(Plus(a, Times(b, Cos(Plus(c, Times(d, Power(ExpandToSum(u, x), n)))))), p)), x), And(FreeQ(List(a, b, c, d, m, n, p), x), LinearQ(u, x), LinearQ(v, x), Not(And(LinearMatchQ(u, x), LinearMatchQ(v, x))))));
            IIntegrate(3441, Int(Times(Cos(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT)))), Power(x_, m_DEFAULT), Power(Sin(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT)))), p_DEFAULT)), x_Symbol),
                    Condition(Simp(Times(Power(Sin(Plus(a, Times(b, Power(x, n)))), Plus(p, C1)), Power(Times(b, n, Plus(p, C1)), CN1)), x), And(FreeQ(List(a, b, m, n, p), x), EqQ(m, Subtract(n, C1)), NeQ(p, CN1))));
            IIntegrate(3442, Int(Times(Power(Cos(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT)))), p_DEFAULT), Power(x_, m_DEFAULT), Sin(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT))))), x_Symbol),
                    Condition(Negate(Simp(Times(Power(Cos(Plus(a, Times(b, Power(x, n)))), Plus(p, C1)), Power(Times(b, n, Plus(p, C1)), CN1)), x)), And(FreeQ(List(a, b, m, n, p), x), EqQ(m, Subtract(n, C1)), NeQ(p, CN1))));
            IIntegrate(3443, Int(Times(Cos(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT)))), Power(x_, m_DEFAULT), Power(Sin(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT)))), p_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(x, Plus(m, Negate(n), C1)), Power(Sin(Plus(a, Times(b, Power(x, n)))), Plus(p, C1)), Power(Times(b, n, Plus(p, C1)), CN1)), x), Dist(Times(Plus(m, Negate(n), C1), Power(Times(b, n, Plus(p, C1)), CN1)), Int(Times(Power(x, Subtract(m, n)), Power(Sin(Plus(a, Times(b, Power(x, n)))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, p), x), LtQ(C0, n, Plus(m, C1)), NeQ(p, CN1))));
            IIntegrate(3444, Int(Times(Power(Cos(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT)))), p_DEFAULT), Power(x_, m_DEFAULT), Sin(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(x, Plus(m, Negate(n), C1)), Power(Cos(Plus(a, Times(b, Power(x, n)))), Plus(p, C1)), Power(Times(b, n, Plus(p, C1)), CN1)), x)), Dist(Times(Plus(m, Negate(n), C1), Power(Times(b, n, Plus(p, C1)), CN1)), Int(Times(Power(x, Subtract(m, n)), Power(Cos(Plus(a, Times(b, Power(x, n)))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, p), x), LtQ(C0, n, Plus(m, C1)), NeQ(p, CN1))));
            IIntegrate(3445, Int(Sin(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_)))), x_Symbol),
                    Condition(Int(Sin(Times(Sqr(Plus(b, Times(C2, c, x))), Power(Times(C4, c), CN1))), x), And(FreeQ(List(a, b, c), x), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(3446, Int(Cos(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_)))), x_Symbol),
                    Condition(Int(Cos(Times(Sqr(Plus(b, Times(C2, c, x))), Power(Times(C4, c), CN1))), x), And(FreeQ(List(a, b, c), x), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(3447, Int(Sin(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_)))), x_Symbol),
                    Condition(Subtract(Dist(Cos(Times(Subtract(Sqr(b), Times(C4, a, c)), Power(Times(C4, c), CN1))), Int(Sin(Times(Sqr(Plus(b, Times(C2, c, x))), Power(Times(C4, c), CN1))), x), x), Dist(Sin(Times(Subtract(Sqr(b), Times(C4, a, c)), Power(Times(C4, c), CN1))), Int(Cos(Times(Sqr(Plus(b, Times(C2, c, x))), Power(Times(C4, c), CN1))), x), x)), And(FreeQ(List(a, b, c), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(3448, Int(Cos(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_)))), x_Symbol),
                    Condition(Plus(Dist(Cos(Times(Subtract(Sqr(b), Times(C4, a, c)), Power(Times(C4, c), CN1))), Int(Cos(Times(Sqr(Plus(b, Times(C2, c, x))), Power(Times(C4, c), CN1))), x), x), Dist(Sin(Times(Subtract(Sqr(b), Times(C4, a, c)), Power(Times(C4, c), CN1))), Int(Sin(Times(Sqr(Plus(b, Times(C2, c, x))), Power(Times(C4, c), CN1))), x), x)), And(FreeQ(List(a, b, c), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(3449, Int(Power(Sin(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_)))), n_), x_Symbol),
                    Condition(Int(ExpandTrigReduce(Power(Sin(Plus(a, Times(b, x), Times(c, Sqr(x)))), n), x), x), And(FreeQ(List(a, b, c), x), IGtQ(n, C1))));
            IIntegrate(3450, Int(Power(Cos(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_)))), n_), x_Symbol),
                    Condition(Int(ExpandTrigReduce(Power(Cos(Plus(a, Times(b, x), Times(c, Sqr(x)))), n), x), x), And(FreeQ(List(a, b, c), x), IGtQ(n, C1))));
        }
    }
}
