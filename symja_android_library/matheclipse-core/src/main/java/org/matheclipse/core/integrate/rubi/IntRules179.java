package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CI;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Csc;
import static org.matheclipse.core.expression.F.Exp;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sec;
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
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.g_DEFAULT;
import static org.matheclipse.core.expression.F.h;
import static org.matheclipse.core.expression.F.h_DEFAULT;
import static org.matheclipse.core.expression.F.i;
import static org.matheclipse.core.expression.F.i_DEFAULT;
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
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules179 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(4476, Int(Cos(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(x, Cos(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Plus(Times(Sqr(b), Sqr(d), Sqr(n)), C1), CN1)), x), Simp(Times(b, d, n, x, Sin(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Plus(Times(Sqr(b), Sqr(d), Sqr(n)), C1), CN1)), x)), And(FreeQ(List(a, b, c, d, n), x), NeQ(Plus(Times(Sqr(b), Sqr(d), Sqr(n)), C1), C0))));
            IIntegrate(4477, Int(Power(Sin(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), p_), x_Symbol),
                    Condition(Plus(Simp(Times(x, Power(Sin(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), p), Power(Plus(Times(Sqr(b), Sqr(d), Sqr(n), Sqr(p)), C1), CN1)), x), Dist(Times(Sqr(b), Sqr(d), Sqr(n), p, Subtract(p, C1), Power(Plus(Times(Sqr(b), Sqr(d), Sqr(n), Sqr(p)), C1), CN1)), Int(Power(Sin(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Subtract(p, C2)), x), x), Negate(Simp(Times(b, d, n, p, x, Cos(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Sin(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Subtract(p, C1)), Power(Plus(Times(Sqr(b), Sqr(d), Sqr(n), Sqr(p)), C1), CN1)), x))), And(FreeQ(List(a, b, c, d, n), x), IGtQ(p, C1), NeQ(Plus(Times(Sqr(b), Sqr(d), Sqr(n), Sqr(p)), C1), C0))));
            IIntegrate(4478, Int(Power(Cos(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), p_), x_Symbol),
                    Condition(Plus(Simp(Times(x, Power(Cos(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), p), Power(Plus(Times(Sqr(b), Sqr(d), Sqr(n), Sqr(p)), C1), CN1)), x), Dist(Times(Sqr(b), Sqr(d), Sqr(n), p, Subtract(p, C1), Power(Plus(Times(Sqr(b), Sqr(d), Sqr(n), Sqr(p)), C1), CN1)), Int(Power(Cos(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Subtract(p, C2)), x), x), Simp(Times(b, d, n, p, x, Power(Cos(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Subtract(p, C1)), Sin(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Plus(Times(Sqr(b), Sqr(d), Sqr(n), Sqr(p)), C1), CN1)), x)), And(FreeQ(List(a, b, c, d, n), x), IGtQ(p, C1), NeQ(Plus(Times(Sqr(b), Sqr(d), Sqr(n), Sqr(p)), C1), C0))));
            IIntegrate(4479, Int(Power(Sin(Times(Plus(a_DEFAULT, Times(Log(x_), b_DEFAULT)), d_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Power(Times(Power(C2, p), Power(b, p), Power(d, p), Power(p, p)), CN1), Int(ExpandIntegrand(Power(Subtract(Times(Exp(Times(a, b, Sqr(d), p)), Power(Power(x, Power(p, CN1)), CN1)), Times(Power(x, Power(p, CN1)), Power(Exp(Times(a, b, Sqr(d), p)), CN1))), p), x), x), x), And(FreeQ(List(a, b, d), x), IGtQ(p, C0), EqQ(Plus(Times(Sqr(b), Sqr(d), Sqr(p)), C1), C0))));
            IIntegrate(4480, Int(Power(Cos(Times(Plus(a_DEFAULT, Times(Log(x_), b_DEFAULT)), d_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Power(Power(C2, p), CN1), Int(ExpandIntegrand(Power(Plus(Times(Exp(Times(a, b, Sqr(d), p)), Power(Power(x, Power(p, CN1)), CN1)), Times(Power(x, Power(p, CN1)), Power(Exp(Times(a, b, Sqr(d), p)), CN1))), p), x), x), x), And(FreeQ(List(a, b, d), x), IGtQ(p, C0), EqQ(Plus(Times(Sqr(b), Sqr(d), Sqr(p)), C1), C0))));
            IIntegrate(4481, Int(Power(Sin(Times(Plus(a_DEFAULT, Times(Log(x_), b_DEFAULT)), d_DEFAULT)), p_), x_Symbol),
                    Condition(Dist(Times(Power(Sin(Times(d, Plus(a, Times(b, Log(x))))), p), Power(x, Times(CI, b, d, p)), Power(Power(Subtract(C1, Times(Exp(Times(C2, CI, a, d)), Power(x, Times(C2, CI, b, d)))), p), CN1)), Int(Times(Power(Subtract(C1, Times(Exp(Times(C2, CI, a, d)), Power(x, Times(C2, CI, b, d)))), p), Power(Power(x, Times(CI, b, d, p)), CN1)), x), x), And(FreeQ(List(a, b, d, p), x), Not(IntegerQ(p)))));
            IIntegrate(4482, Int(Power(Cos(Times(Plus(a_DEFAULT, Times(Log(x_), b_DEFAULT)), d_DEFAULT)), p_), x_Symbol),
                    Condition(Dist(Times(Power(Cos(Times(d, Plus(a, Times(b, Log(x))))), p), Power(x, Times(CI, b, d, p)), Power(Power(Plus(C1, Times(Exp(Times(C2, CI, a, d)), Power(x, Times(C2, CI, b, d)))), p), CN1)), Int(Times(Power(Plus(C1, Times(Exp(Times(C2, CI, a, d)), Power(x, Times(C2, CI, b, d)))), p), Power(Power(x, Times(CI, b, d, p)), CN1)), x), x), And(FreeQ(List(a, b, d, p), x), Not(IntegerQ(p)))));
            IIntegrate(4483, Int(Power(Sin(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Times(x, Power(Times(n, Power(Times(c, Power(x, n)), Power(n, CN1))), CN1)), Subst(Int(Times(Power(x, Subtract(Power(n, CN1), C1)), Power(Sin(Times(d, Plus(a, Times(b, Log(x))))), p)), x), x, Times(c, Power(x, n))), x), And(FreeQ(List(a, b, c, d, n, p), x), Or(NeQ(c, C1), NeQ(n, C1)))));
            IIntegrate(4484, Int(Power(Cos(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Times(x, Power(Times(n, Power(Times(c, Power(x, n)), Power(n, CN1))), CN1)), Subst(Int(Times(Power(x, Subtract(Power(n, CN1), C1)), Power(Cos(Times(d, Plus(a, Times(b, Log(x))))), p)), x), x, Times(c, Power(x, n))), x), And(FreeQ(List(a, b, c, d, n, p), x), Or(NeQ(c, C1), NeQ(n, C1)))));
            IIntegrate(4485, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Sin(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT))), x_Symbol),
                    Condition(Subtract(Simp(Times(Plus(m, C1), Power(Times(e, x), Plus(m, C1)), Sin(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Plus(Times(Sqr(b), Sqr(d), e, Sqr(n)), Times(e, Sqr(Plus(m, C1)))), CN1)), x), Simp(Times(b, d, n, Power(Times(e, x), Plus(m, C1)), Cos(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Plus(Times(Sqr(b), Sqr(d), e, Sqr(n)), Times(e, Sqr(Plus(m, C1)))), CN1)), x)), And(FreeQ(List(a, b, c, d, e, m, n), x), NeQ(Plus(Times(Sqr(b), Sqr(d), Sqr(n)), Sqr(Plus(m, C1))), C0))));
            IIntegrate(4486, Int(Times(Cos(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(m, C1), Power(Times(e, x), Plus(m, C1)), Cos(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Plus(Times(Sqr(b), Sqr(d), e, Sqr(n)), Times(e, Sqr(Plus(m, C1)))), CN1)), x), Simp(Times(b, d, n, Power(Times(e, x), Plus(m, C1)), Sin(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Plus(Times(Sqr(b), Sqr(d), e, Sqr(n)), Times(e, Sqr(Plus(m, C1)))), CN1)), x)), And(FreeQ(List(a, b, c, d, e, m, n), x), NeQ(Plus(Times(Sqr(b), Sqr(d), Sqr(n)), Sqr(Plus(m, C1))), C0))));
            IIntegrate(4487, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Sin(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(m, C1), Power(Times(e, x), Plus(m, C1)), Power(Sin(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), p), Power(Plus(Times(Sqr(b), Sqr(d), e, Sqr(n), Sqr(p)), Times(e, Sqr(Plus(m, C1)))), CN1)), x), Dist(Times(Sqr(b), Sqr(d), Sqr(n), p, Subtract(p, C1), Power(Plus(Times(Sqr(b), Sqr(d), Sqr(n), Sqr(p)), Sqr(Plus(m, C1))), CN1)), Int(Times(Power(Times(e, x), m), Power(Sin(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Subtract(p, C2))), x), x), Negate(Simp(Times(b, d, n, p, Power(Times(e, x), Plus(m, C1)), Cos(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Sin(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Subtract(p, C1)), Power(Plus(Times(Sqr(b), Sqr(d), e, Sqr(n), Sqr(p)), Times(e, Sqr(Plus(m, C1)))), CN1)), x))), And(FreeQ(List(a, b, c, d, e, m, n), x), IGtQ(p, C1), NeQ(Plus(Times(Sqr(b), Sqr(d), Sqr(n), Sqr(p)), Sqr(Plus(m, C1))), C0))));
            IIntegrate(4488, Int(Times(Power(Cos(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), p_), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(m, C1), Power(Times(e, x), Plus(m, C1)), Power(Cos(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), p), Power(Plus(Times(Sqr(b), Sqr(d), e, Sqr(n), Sqr(p)), Times(e, Sqr(Plus(m, C1)))), CN1)), x), Dist(Times(Sqr(b), Sqr(d), Sqr(n), p, Subtract(p, C1), Power(Plus(Times(Sqr(b), Sqr(d), Sqr(n), Sqr(p)), Sqr(Plus(m, C1))), CN1)), Int(Times(Power(Times(e, x), m), Power(Cos(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Subtract(p, C2))), x), x), Simp(Times(b, d, n, p, Power(Times(e, x), Plus(m, C1)), Sin(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Cos(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Subtract(p, C1)), Power(Plus(Times(Sqr(b), Sqr(d), e, Sqr(n), Sqr(p)), Times(e, Sqr(Plus(m, C1)))), CN1)), x)), And(FreeQ(List(a, b, c, d, e, m, n), x), IGtQ(p, C1), NeQ(Plus(Times(Sqr(b), Sqr(d), Sqr(n), Sqr(p)), Sqr(Plus(m, C1))), C0))));
            IIntegrate(4489, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Sin(Times(Plus(a_DEFAULT, Times(Log(x_), b_DEFAULT)), d_DEFAULT)), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(m, C1), p), Power(Times(Power(C2, p), Power(b, p), Power(d, p), Power(p, p)), CN1)), Int(ExpandIntegrand(Times(Power(Times(e, x), m), Power(Subtract(Times(Exp(Times(a, b, Sqr(d), p, Power(Plus(m, C1), CN1))), Power(Power(x, Times(Plus(m, C1), Power(p, CN1))), CN1)), Times(Power(x, Times(Plus(m, C1), Power(p, CN1))), Power(Exp(Times(a, b, Sqr(d), p, Power(Plus(m, C1), CN1))), CN1))), p)), x), x), x), And(FreeQ(List(a, b, d, e, m), x), IGtQ(p, C0), EqQ(Plus(Times(Sqr(b), Sqr(d), Sqr(p)), Sqr(Plus(m, C1))), C0))));
            IIntegrate(4490, Int(Times(Power(Cos(Times(Plus(a_DEFAULT, Times(Log(x_), b_DEFAULT)), d_DEFAULT)), p_DEFAULT), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Power(C2, p), CN1), Int(ExpandIntegrand(Times(Power(Times(e, x), m), Power(Plus(Times(Exp(Times(a, b, Sqr(d), p, Power(Plus(m, C1), CN1))), Power(Power(x, Times(Plus(m, C1), Power(p, CN1))), CN1)), Times(Power(x, Times(Plus(m, C1), Power(p, CN1))), Power(Exp(Times(a, b, Sqr(d), p, Power(Plus(m, C1), CN1))), CN1))), p)), x), x), x), And(FreeQ(List(a, b, d, e, m), x), IGtQ(p, C0), EqQ(Plus(Times(Sqr(b), Sqr(d), Sqr(p)), Sqr(Plus(m, C1))), C0))));
            IIntegrate(4491, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Sin(Times(Plus(a_DEFAULT, Times(Log(x_), b_DEFAULT)), d_DEFAULT)), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Sin(Times(d, Plus(a, Times(b, Log(x))))), p), Power(x, Times(CI, b, d, p)), Power(Power(Subtract(C1, Times(Exp(Times(C2, CI, a, d)), Power(x, Times(C2, CI, b, d)))), p), CN1)), Int(Times(Power(Times(e, x), m), Power(Subtract(C1, Times(Exp(Times(C2, CI, a, d)), Power(x, Times(C2, CI, b, d)))), p), Power(Power(x, Times(CI, b, d, p)), CN1)), x), x), And(FreeQ(List(a, b, d, e, m, p), x), Not(IntegerQ(p)))));
            IIntegrate(4492, Int(Times(Power(Cos(Times(Plus(a_DEFAULT, Times(Log(x_), b_DEFAULT)), d_DEFAULT)), p_), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Cos(Times(d, Plus(a, Times(b, Log(x))))), p), Power(x, Times(CI, b, d, p)), Power(Power(Plus(C1, Times(Exp(Times(C2, CI, a, d)), Power(x, Times(C2, CI, b, d)))), p), CN1)), Int(Times(Power(Times(e, x), m), Power(Plus(C1, Times(Exp(Times(C2, CI, a, d)), Power(x, Times(C2, CI, b, d)))), p), Power(Power(x, Times(CI, b, d, p)), CN1)), x), x), And(FreeQ(List(a, b, d, e, m, p), x), Not(IntegerQ(p)))));
            IIntegrate(4493, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Sin(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Times(e, x), Plus(m, C1)), Power(Times(e, n, Power(Times(c, Power(x, n)), Times(Plus(m, C1), Power(n, CN1)))), CN1)), Subst(Int(Times(Power(x, Subtract(Times(Plus(m, C1), Power(n, CN1)), C1)), Power(Sin(Times(d, Plus(a, Times(b, Log(x))))), p)), x), x, Times(c, Power(x, n))), x), And(FreeQ(List(a, b, c, d, e, m, n, p), x), Or(NeQ(c, C1), NeQ(n, C1)))));
            IIntegrate(4494, Int(Times(Power(Cos(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), p_DEFAULT), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Times(e, x), Plus(m, C1)), Power(Times(e, n, Power(Times(c, Power(x, n)), Times(Plus(m, C1), Power(n, CN1)))), CN1)), Subst(Int(Times(Power(x, Subtract(Times(Plus(m, C1), Power(n, CN1)), C1)), Power(Cos(Times(d, Plus(a, Times(b, Log(x))))), p)), x), x, Times(c, Power(x, n))), x), And(FreeQ(List(a, b, c, d, e, m, n, p), x), Or(NeQ(c, C1), NeQ(n, C1)))));
            IIntegrate(4495, Int(Times(Power(Times(Plus(e_DEFAULT, Times(Log(Times(g_DEFAULT, Power(x_, m_DEFAULT))), f_DEFAULT)), h_DEFAULT), q_DEFAULT), Sin(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT))), x_Symbol),
                    Condition(Subtract(Dist(Times(CI, Power(Times(Exp(Times(CI, a, d)), Power(Times(c, Power(x, n)), Times(CI, b, d)), C2, Power(Power(x, Times(CI, b, d, n)), CN1)), CN1)), Int(Times(Power(Times(h, Plus(e, Times(f, Log(Times(g, Power(x, m)))))), q), Power(Power(x, Times(CI, b, d, n)), CN1)), x), x), Dist(Times(CI, Exp(Times(CI, a, d)), Power(Times(c, Power(x, n)), Times(CI, b, d)), Power(Times(C2, Power(x, Times(CI, b, d, n))), CN1)), Int(Times(Power(x, Times(CI, b, d, n)), Power(Times(h, Plus(e, Times(f, Log(Times(g, Power(x, m)))))), q)), x), x)), FreeQ(List(a, b, c, d, e, f, g, h, m, n, q), x)));
            IIntegrate(4496, Int(Times(Cos(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), Power(Times(Plus(e_DEFAULT, Times(Log(Times(g_DEFAULT, Power(x_, m_DEFAULT))), f_DEFAULT)), h_DEFAULT), q_DEFAULT)), x_Symbol),
                    Condition(Plus(Dist(Power(Times(Exp(Times(CI, a, d)), Power(Times(c, Power(x, n)), Times(CI, b, d)), C2, Power(Power(x, Times(CI, b, d, n)), CN1)), CN1), Int(Times(Power(Times(h, Plus(e, Times(f, Log(Times(g, Power(x, m)))))), q), Power(Power(x, Times(CI, b, d, n)), CN1)), x), x), Dist(Times(Exp(Times(CI, a, d)), Power(Times(c, Power(x, n)), Times(CI, b, d)), Power(Times(C2, Power(x, Times(CI, b, d, n))), CN1)), Int(Times(Power(x, Times(CI, b, d, n)), Power(Times(h, Plus(e, Times(f, Log(Times(g, Power(x, m)))))), q)), x), x)), FreeQ(List(a, b, c, d, e, f, g, h, m, n, q), x)));
            IIntegrate(4497, Int(Times(Power(Times(Plus(e_DEFAULT, Times(Log(Times(g_DEFAULT, Power(x_, m_DEFAULT))), f_DEFAULT)), h_DEFAULT), q_DEFAULT), Power(Times(i_DEFAULT, x_), r_DEFAULT), Sin(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT))), x_Symbol),
                    Condition(Subtract(Dist(Times(CI, Power(Times(i, x), r), Power(Times(Exp(Times(CI, a, d)), Power(Times(c, Power(x, n)), Times(CI, b, d)), C2, Power(x, Subtract(r, Times(CI, b, d, n)))), CN1)), Int(Times(Power(x, Subtract(r, Times(CI, b, d, n))), Power(Times(h, Plus(e, Times(f, Log(Times(g, Power(x, m)))))), q)), x), x), Dist(Times(CI, Exp(Times(CI, a, d)), Power(Times(i, x), r), Power(Times(c, Power(x, n)), Times(CI, b, d)), Power(Times(C2, Power(x, Plus(r, Times(CI, b, d, n)))), CN1)), Int(Times(Power(x, Plus(r, Times(CI, b, d, n))), Power(Times(h, Plus(e, Times(f, Log(Times(g, Power(x, m)))))), q)), x), x)), FreeQ(List(a, b, c, d, e, f, g, h, i, m, n, q, r), x)));
            IIntegrate(4498, Int(Times(Cos(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), Power(Times(Plus(e_DEFAULT, Times(Log(Times(g_DEFAULT, Power(x_, m_DEFAULT))), f_DEFAULT)), h_DEFAULT), q_DEFAULT), Power(Times(i_DEFAULT, x_), r_DEFAULT)), x_Symbol),
                    Condition(Plus(Dist(Times(Power(Times(i, x), r), Power(Times(Exp(Times(CI, a, d)), Power(Times(c, Power(x, n)), Times(CI, b, d)), C2, Power(x, Subtract(r, Times(CI, b, d, n)))), CN1)), Int(Times(Power(x, Subtract(r, Times(CI, b, d, n))), Power(Times(h, Plus(e, Times(f, Log(Times(g, Power(x, m)))))), q)), x), x), Dist(Times(Exp(Times(CI, a, d)), Power(Times(i, x), r), Power(Times(c, Power(x, n)), Times(CI, b, d)), Power(Times(C2, Power(x, Plus(r, Times(CI, b, d, n)))), CN1)), Int(Times(Power(x, Plus(r, Times(CI, b, d, n))), Power(Times(h, Plus(e, Times(f, Log(Times(g, Power(x, m)))))), q)), x), x)), FreeQ(List(a, b, c, d, e, f, g, h, i, m, n, q, r), x)));
            IIntegrate(4499, Int(Power(Sec(Times(Plus(a_DEFAULT, Times(Log(x_), b_DEFAULT)), d_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Times(Power(C2, p), Exp(Times(CI, a, d, p))), Int(Times(Power(x, Times(CI, b, d, p)), Power(Power(Plus(C1, Times(Exp(Times(C2, CI, a, d)), Power(x, Times(C2, CI, b, d)))), p), CN1)), x), x), And(FreeQ(List(a, b, d), x), IntegerQ(p))));
            IIntegrate(4500, Int(Power(Csc(Times(Plus(a_DEFAULT, Times(Log(x_), b_DEFAULT)), d_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Times(Power(Times(CN2, CI), p), Exp(Times(CI, a, d, p))), Int(Times(Power(x, Times(CI, b, d, p)), Power(Power(Subtract(C1, Times(Exp(Times(C2, CI, a, d)), Power(x, Times(C2, CI, b, d)))), p), CN1)), x), x), And(FreeQ(List(a, b, d), x), IntegerQ(p))));
        }
    }
}
