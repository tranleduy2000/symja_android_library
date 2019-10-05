package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.ASymbol;
import static org.matheclipse.core.expression.F.A_;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.BSymbol;
import static org.matheclipse.core.expression.F.B_DEFAULT;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Cot;
import static org.matheclipse.core.expression.F.Csc;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sec;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Tan;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.a_DEFAULT;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_;
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
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.w;
import static org.matheclipse.core.expression.F.w_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules183 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(4576, Int(Times(Sin(v_), Power(Tan(w_), n_DEFAULT)), x_Symbol),
                    Condition(Plus(Negate(Int(Times(Cos(v), Power(Tan(w), Subtract(n, C1))), x)), Dist(Cos(Subtract(v, w)), Int(Times(Sec(w), Power(Tan(w), Subtract(n, C1))), x), x)), And(GtQ(n, C0), FreeQ(Subtract(v, w), x), NeQ(w, v))));
            IIntegrate(4577, Int(Times(Cos(v_), Power(Cot(w_), n_DEFAULT)), x_Symbol),
                    Condition(Plus(Negate(Int(Times(Sin(v), Power(Cot(w), Subtract(n, C1))), x)), Dist(Cos(Subtract(v, w)), Int(Times(Csc(w), Power(Cot(w), Subtract(n, C1))), x), x)), And(GtQ(n, C0), FreeQ(Subtract(v, w), x), NeQ(w, v))));
            IIntegrate(4578, Int(Times(Power(Cot(w_), n_DEFAULT), Sin(v_)), x_Symbol),
                    Condition(Plus(Int(Times(Cos(v), Power(Cot(w), Subtract(n, C1))), x), Dist(Sin(Subtract(v, w)), Int(Times(Csc(w), Power(Cot(w), Subtract(n, C1))), x), x)), And(GtQ(n, C0), FreeQ(Subtract(v, w), x), NeQ(w, v))));
            IIntegrate(4579, Int(Times(Cos(v_), Power(Tan(w_), n_DEFAULT)), x_Symbol),
                    Condition(Subtract(Int(Times(Sin(v), Power(Tan(w), Subtract(n, C1))), x), Dist(Sin(Subtract(v, w)), Int(Times(Sec(w), Power(Tan(w), Subtract(n, C1))), x), x)), And(GtQ(n, C0), FreeQ(Subtract(v, w), x), NeQ(w, v))));
            IIntegrate(4580, Int(Times(Power(Sec(w_), n_DEFAULT), Sin(v_)), x_Symbol),
                    Condition(Plus(Dist(Cos(Subtract(v, w)), Int(Times(Tan(w), Power(Sec(w), Subtract(n, C1))), x), x), Dist(Sin(Subtract(v, w)), Int(Power(Sec(w), Subtract(n, C1)), x), x)), And(GtQ(n, C0), FreeQ(Subtract(v, w), x), NeQ(w, v))));
            IIntegrate(4581, Int(Times(Cos(v_), Power(Csc(w_), n_DEFAULT)), x_Symbol),
                    Condition(Subtract(Dist(Cos(Subtract(v, w)), Int(Times(Cot(w), Power(Csc(w), Subtract(n, C1))), x), x), Dist(Sin(Subtract(v, w)), Int(Power(Csc(w), Subtract(n, C1)), x), x)), And(GtQ(n, C0), FreeQ(Subtract(v, w), x), NeQ(w, v))));
            IIntegrate(4582, Int(Times(Power(Csc(w_), n_DEFAULT), Sin(v_)), x_Symbol),
                    Condition(Plus(Dist(Sin(Subtract(v, w)), Int(Times(Cot(w), Power(Csc(w), Subtract(n, C1))), x), x), Dist(Cos(Subtract(v, w)), Int(Power(Csc(w), Subtract(n, C1)), x), x)), And(GtQ(n, C0), FreeQ(Subtract(v, w), x), NeQ(w, v))));
            IIntegrate(4583, Int(Times(Cos(v_), Power(Sec(w_), n_DEFAULT)), x_Symbol),
                    Condition(Plus(Negate(Dist(Sin(Subtract(v, w)), Int(Times(Tan(w), Power(Sec(w), Subtract(n, C1))), x), x)), Dist(Cos(Subtract(v, w)), Int(Power(Sec(w), Subtract(n, C1)), x), x)), And(GtQ(n, C0), FreeQ(Subtract(v, w), x), NeQ(w, v))));
            IIntegrate(4584, Int(Times(Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_, Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT, Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), n_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Plus(e, Times(f, x)), m), Power(Plus(a, Times(C1D2, b, Sin(Plus(Times(C2, c), Times(C2, d, x))))), n)), x), FreeQ(List(a, b, c, d, e, f, m, n), x)));
            IIntegrate(4585, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))))), n_)), x_Symbol),
                    Condition(Dist(Power(Power(C2, n), CN1), Int(Times(Power(x, m), Power(Subtract(Plus(Times(C2, a), b), Times(b, Cos(Plus(Times(C2, c), Times(C2, d, x))))), n)), x), x), And(FreeQ(List(a, b, c, d), x), NeQ(Plus(a, b), C0), IGtQ(m, C0), ILtQ(n, C0), Or(EqQ(n, CN1), And(EqQ(m, C1), EqQ(n, CN2))))));
            IIntegrate(4586, Int(Times(Power(Plus(Times(Sqr(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), b_DEFAULT), a_), n_), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Power(C2, n), CN1), Int(Times(Power(x, m), Power(Plus(Times(C2, a), b, Times(b, Cos(Plus(Times(C2, c), Times(C2, d, x))))), n)), x), x), And(FreeQ(List(a, b, c, d), x), NeQ(Plus(a, b), C0), IGtQ(m, C0), ILtQ(n, C0), Or(EqQ(n, CN1), And(EqQ(m, C1), EqQ(n, CN2))))));
            IIntegrate(4587, Int(Times(Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_DEFAULT, Times(Sqr(Cos(Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), b_DEFAULT), Times(c_DEFAULT, Sqr(Sin(Plus(d_DEFAULT, Times(e_DEFAULT, x_)))))), CN1)), x_Symbol),
                    Condition(Dist(C2, Int(Times(Power(Plus(f, Times(g, x)), m), Power(Plus(Times(C2, a), b, c, Times(Subtract(b, c), Cos(Plus(Times(C2, d), Times(C2, e, x))))), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f, g), x), IGtQ(m, C0), NeQ(Plus(a, b), C0), NeQ(Plus(a, c), C0))));
            IIntegrate(4588, Int(Times(Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), m_DEFAULT), Sqr(Sec(Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), Power(Plus(b_, Times(c_DEFAULT, Sqr(Tan(Plus(d_DEFAULT, Times(e_DEFAULT, x_)))))), CN1)), x_Symbol),
                    Condition(Dist(C2, Int(Times(Power(Plus(f, Times(g, x)), m), Power(Plus(b, c, Times(Subtract(b, c), Cos(Plus(Times(C2, d), Times(C2, e, x))))), CN1)), x), x), And(FreeQ(List(b, c, d, e, f, g), x), IGtQ(m, C0))));
            IIntegrate(4589, Int(Times(Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), m_DEFAULT), Sqr(Sec(Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), Power(Plus(b_DEFAULT, Times(a_DEFAULT, Sqr(Sec(Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), Times(c_DEFAULT, Sqr(Tan(Plus(d_DEFAULT, Times(e_DEFAULT, x_)))))), CN1)), x_Symbol),
                    Condition(Dist(C2, Int(Times(Power(Plus(f, Times(g, x)), m), Power(Plus(Times(C2, a), b, c, Times(Subtract(b, c), Cos(Plus(Times(C2, d), Times(C2, e, x))))), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f, g), x), IGtQ(m, C0), NeQ(Plus(a, b), C0), NeQ(Plus(a, c), C0))));
            IIntegrate(4590, Int(Times(Sqr(Csc(Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), Power(Plus(Times(Sqr(Cot(Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), b_DEFAULT), c_), CN1), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Dist(C2, Int(Times(Power(Plus(f, Times(g, x)), m), Power(Plus(b, c, Times(Subtract(b, c), Cos(Plus(Times(C2, d), Times(C2, e, x))))), CN1)), x), x), And(FreeQ(List(b, c, d, e, f, g), x), IGtQ(m, C0))));
            IIntegrate(4591, Int(Times(Sqr(Csc(Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), Power(Plus(Times(Sqr(Csc(Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), a_DEFAULT), Times(Sqr(Cot(Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), b_DEFAULT), c_DEFAULT), CN1), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Dist(C2, Int(Times(Power(Plus(f, Times(g, x)), m), Power(Plus(Times(C2, a), b, c, Times(Subtract(b, c), Cos(Plus(Times(C2, d), Times(C2, e, x))))), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f, g), x), IGtQ(m, C0), NeQ(Plus(a, b), C0), NeQ(Plus(a, c), C0))));
            IIntegrate(4592, Int(Times(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), Power(Plus(a_, Times(b_DEFAULT, Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), CN2), Plus(A_, Times(B_DEFAULT, Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(BSymbol, Plus(e, Times(f, x)), Cos(Plus(c, Times(d, x))), Power(Times(a, d, Plus(a, Times(b, Sin(Plus(c, Times(d, x)))))), CN1)), x)), Dist(Times(BSymbol, f, Power(Times(a, d), CN1)), Int(Times(Cos(Plus(c, Times(d, x))), Power(Plus(a, Times(b, Sin(Plus(c, Times(d, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol), x), EqQ(Subtract(Times(a, ASymbol), Times(b, BSymbol)), C0))));
            IIntegrate(4593, Int(Times(Power(Plus(Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), CN2), Plus(Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), B_DEFAULT), A_), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), x_Symbol),
                    Condition(Subtract(Simp(Times(BSymbol, Plus(e, Times(f, x)), Sin(Plus(c, Times(d, x))), Power(Times(a, d, Plus(a, Times(b, Cos(Plus(c, Times(d, x)))))), CN1)), x), Dist(Times(BSymbol, f, Power(Times(a, d), CN1)), Int(Times(Sin(Plus(c, Times(d, x))), Power(Plus(a, Times(b, Cos(Plus(c, Times(d, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol), x), EqQ(Subtract(Times(a, ASymbol), Times(b, BSymbol)), C0))));
            IIntegrate(4594, Int(Times(Sqr(x_), Power(Plus(Times(Cos(Times(a_DEFAULT, x_)), d_DEFAULT, x_), Times(c_DEFAULT, Sin(Times(a_DEFAULT, x_)))), CN2)), x_Symbol),
                    Condition(Plus(Simp(Times(x, Power(Times(a, d, Sin(Times(a, x)), Plus(Times(c, Sin(Times(a, x))), Times(d, x, Cos(Times(a, x))))), CN1)), x), Dist(Power(d, CN2), Int(Power(Sin(Times(a, x)), CN2), x), x)), And(FreeQ(List(a, c, d), x), EqQ(Plus(Times(a, c), d), C0))));
            IIntegrate(4595, Int(Times(Sqr(x_), Power(Plus(Times(Cos(Times(a_DEFAULT, x_)), c_DEFAULT), Times(d_DEFAULT, x_, Sin(Times(a_DEFAULT, x_)))), CN2)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(x, Power(Times(a, d, Cos(Times(a, x)), Plus(Times(c, Cos(Times(a, x))), Times(d, x, Sin(Times(a, x))))), CN1)), x)), Dist(Power(d, CN2), Int(Power(Cos(Times(a, x)), CN2), x), x)), And(FreeQ(List(a, c, d), x), EqQ(Subtract(Times(a, c), d), C0))));
            IIntegrate(4596, Int(Times(Sqr(Sin(Times(a_DEFAULT, x_))), Power(Plus(Times(Cos(Times(a_DEFAULT, x_)), d_DEFAULT, x_), Times(c_DEFAULT, Sin(Times(a_DEFAULT, x_)))), CN2)), x_Symbol),
                    Condition(Plus(Simp(Power(Times(Sqr(d), x), CN1), x), Simp(Times(Sin(Times(a, x)), Power(Times(a, d, x, Plus(Times(d, x, Cos(Times(a, x))), Times(c, Sin(Times(a, x))))), CN1)), x)), And(FreeQ(List(a, c, d), x), EqQ(Plus(Times(a, c), d), C0))));
            IIntegrate(4597, Int(Times(Sqr(Cos(Times(a_DEFAULT, x_))), Power(Plus(Times(Cos(Times(a_DEFAULT, x_)), c_DEFAULT), Times(d_DEFAULT, x_, Sin(Times(a_DEFAULT, x_)))), CN2)), x_Symbol),
                    Condition(Subtract(Simp(Power(Times(Sqr(d), x), CN1), x), Simp(Times(Cos(Times(a, x)), Power(Times(a, d, x, Plus(Times(d, x, Sin(Times(a, x))), Times(c, Cos(Times(a, x))))), CN1)), x)), And(FreeQ(List(a, c, d), x), EqQ(Subtract(Times(a, c), d), C0))));
            IIntegrate(4598, Int(Times(Power(Times(b_DEFAULT, x_), m_), Power(Sin(Times(a_DEFAULT, x_)), n_), Power(Plus(Times(Cos(Times(a_DEFAULT, x_)), d_DEFAULT, x_), Times(c_DEFAULT, Sin(Times(a_DEFAULT, x_)))), CN2)), x_Symbol),
                    Condition(Subtract(Simp(Times(b, Power(Times(b, x), Subtract(m, C1)), Power(Sin(Times(a, x)), Subtract(n, C1)), Power(Times(a, d, Plus(Times(c, Sin(Times(a, x))), Times(d, x, Cos(Times(a, x))))), CN1)), x), Dist(Times(Sqr(b), Subtract(n, C1), Power(d, CN2)), Int(Times(Power(Times(b, x), Subtract(m, C2)), Power(Sin(Times(a, x)), Subtract(n, C2))), x), x)), And(FreeQ(List(a, b, c, d, m, n), x), EqQ(Plus(Times(a, c), d), C0), EqQ(m, Subtract(C2, n)))));
            IIntegrate(4599, Int(Times(Power(Cos(Times(a_DEFAULT, x_)), n_), Power(Times(b_DEFAULT, x_), m_), Power(Plus(Times(Cos(Times(a_DEFAULT, x_)), c_DEFAULT), Times(d_DEFAULT, x_, Sin(Times(a_DEFAULT, x_)))), CN2)), x_Symbol),
                    Condition(Subtract(Negate(Simp(Times(b, Power(Times(b, x), Subtract(m, C1)), Power(Cos(Times(a, x)), Subtract(n, C1)), Power(Times(a, d, Plus(Times(c, Cos(Times(a, x))), Times(d, x, Sin(Times(a, x))))), CN1)), x)), Dist(Times(Sqr(b), Subtract(n, C1), Power(d, CN2)), Int(Times(Power(Times(b, x), Subtract(m, C2)), Power(Cos(Times(a, x)), Subtract(n, C2))), x), x)), And(FreeQ(List(a, b, c, d, m, n), x), EqQ(Subtract(Times(a, c), d), C0), EqQ(m, Subtract(C2, n)))));
            IIntegrate(4600, Int(Times(Power(Csc(Times(a_DEFAULT, x_)), n_DEFAULT), Power(Times(b_DEFAULT, x_), m_DEFAULT), Power(Plus(Times(Cos(Times(a_DEFAULT, x_)), d_DEFAULT, x_), Times(c_DEFAULT, Sin(Times(a_DEFAULT, x_)))), CN2)), x_Symbol),
                    Condition(Plus(Simp(Times(b, Power(Times(b, x), Subtract(m, C1)), Power(Csc(Times(a, x)), Plus(n, C1)), Power(Times(a, d, Plus(Times(c, Sin(Times(a, x))), Times(d, x, Cos(Times(a, x))))), CN1)), x), Dist(Times(Sqr(b), Plus(n, C1), Power(d, CN2)), Int(Times(Power(Times(b, x), Subtract(m, C2)), Power(Csc(Times(a, x)), Plus(n, C2))), x), x)), And(FreeQ(List(a, b, c, d, m, n), x), EqQ(Plus(Times(a, c), d), C0), EqQ(m, Plus(n, C2)))));
        }
    }
}
