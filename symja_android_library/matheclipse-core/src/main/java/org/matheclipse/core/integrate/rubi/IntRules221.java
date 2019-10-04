package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cosh;
import static org.matheclipse.core.expression.F.Csch;
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
import static org.matheclipse.core.expression.F.Sech;
import static org.matheclipse.core.expression.F.Sinh;
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
public class IntRules221 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(5526, Int(Power(Cosh(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Times(x, Power(Times(n, Power(Times(c, Power(x, n)), Power(n, CN1))), CN1)), Subst(Int(Times(Power(x, Subtract(Power(n, CN1), C1)), Power(Cosh(Times(d, Plus(a, Times(b, Log(x))))), p)), x), x, Times(c, Power(x, n))), x), And(FreeQ(List(a, b, c, d, n, p), x), Or(NeQ(c, C1), NeQ(n, C1)))));
            IIntegrate(5527, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Sinh(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Plus(m, C1), Power(Times(e, x), Plus(m, C1)), Sinh(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Subtract(Times(Sqr(b), Sqr(d), e, Sqr(n)), Times(e, Sqr(Plus(m, C1)))), CN1)), x)), Simp(Times(b, d, n, Power(Times(e, x), Plus(m, C1)), Cosh(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Subtract(Times(Sqr(b), Sqr(d), e, Sqr(n)), Times(e, Sqr(Plus(m, C1)))), CN1)), x)), And(FreeQ(List(a, b, c, d, e, m, n), x), NeQ(Subtract(Times(Sqr(b), Sqr(d), Sqr(n)), Sqr(Plus(m, C1))), C0))));
            IIntegrate(5528, Int(Times(Cosh(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Plus(m, C1), Power(Times(e, x), Plus(m, C1)), Cosh(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Subtract(Times(Sqr(b), Sqr(d), e, Sqr(n)), Times(e, Sqr(Plus(m, C1)))), CN1)), x)), Simp(Times(b, d, n, Power(Times(e, x), Plus(m, C1)), Sinh(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Subtract(Times(Sqr(b), Sqr(d), e, Sqr(n)), Times(e, Sqr(Plus(m, C1)))), CN1)), x)), And(FreeQ(List(a, b, c, d, e, m, n), x), NeQ(Subtract(Times(Sqr(b), Sqr(d), Sqr(n)), Sqr(Plus(m, C1))), C0))));
            IIntegrate(5529, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Sinh(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Plus(m, C1), Power(Times(e, x), Plus(m, C1)), Power(Sinh(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), p), Power(Subtract(Times(Sqr(b), Sqr(d), e, Sqr(n), Sqr(p)), Times(e, Sqr(Plus(m, C1)))), CN1)), x)), Negate(Dist(Times(Sqr(b), Sqr(d), Sqr(n), p, Subtract(p, C1), Power(Subtract(Times(Sqr(b), Sqr(d), Sqr(n), Sqr(p)), Sqr(Plus(m, C1))), CN1)), Int(Times(Power(Times(e, x), m), Power(Sinh(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Subtract(p, C2))), x), x)), Simp(Times(b, d, n, p, Power(Times(e, x), Plus(m, C1)), Cosh(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Sinh(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Subtract(p, C1)), Power(Subtract(Times(Sqr(b), Sqr(d), e, Sqr(n), Sqr(p)), Times(e, Sqr(Plus(m, C1)))), CN1)), x)), And(FreeQ(List(a, b, c, d, e, m, n), x), IGtQ(p, C1), NeQ(Subtract(Times(Sqr(b), Sqr(d), Sqr(n), Sqr(p)), Sqr(Plus(m, C1))), C0))));
            IIntegrate(5530, Int(Times(Power(Cosh(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), p_), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Plus(m, C1), Power(Times(e, x), Plus(m, C1)), Power(Cosh(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), p), Power(Subtract(Times(Sqr(b), Sqr(d), e, Sqr(n), Sqr(p)), Times(e, Sqr(Plus(m, C1)))), CN1)), x)), Dist(Times(Sqr(b), Sqr(d), Sqr(n), p, Subtract(p, C1), Power(Subtract(Times(Sqr(b), Sqr(d), Sqr(n), Sqr(p)), Sqr(Plus(m, C1))), CN1)), Int(Times(Power(Times(e, x), m), Power(Cosh(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Subtract(p, C2))), x), x), Simp(Times(b, d, n, p, Power(Times(e, x), Plus(m, C1)), Sinh(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Cosh(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Subtract(p, C1)), Power(Subtract(Times(Sqr(b), Sqr(d), e, Sqr(n), Sqr(p)), Times(e, Sqr(Plus(m, C1)))), CN1)), x)), And(FreeQ(List(a, b, c, d, e, m, n), x), IGtQ(p, C1), NeQ(Subtract(Times(Sqr(b), Sqr(d), Sqr(n), Sqr(p)), Sqr(Plus(m, C1))), C0))));
            IIntegrate(5531, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Sinh(Times(Plus(a_DEFAULT, Times(Log(x_), b_DEFAULT)), d_DEFAULT)), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(m, C1), p), Power(Times(Power(C2, p), Power(b, p), Power(d, p), Power(p, p)), CN1)), Int(ExpandIntegrand(Times(Power(Times(e, x), m), Power(Plus(Negate(Power(Times(Exp(Times(a, b, Sqr(d), p, Power(Plus(m, C1), CN1))), Power(x, Times(Plus(m, C1), Power(p, CN1)))), CN1)), Times(Exp(Times(a, b, Sqr(d), p, Power(Plus(m, C1), CN1))), Power(x, Times(Plus(m, C1), Power(p, CN1))))), p)), x), x), x), And(FreeQ(List(a, b, d, e, m), x), IGtQ(p, C0), EqQ(Subtract(Times(Sqr(b), Sqr(d), Sqr(p)), Sqr(Plus(m, C1))), C0))));
            IIntegrate(5532, Int(Times(Power(Cosh(Times(Plus(a_DEFAULT, Times(Log(x_), b_DEFAULT)), d_DEFAULT)), p_DEFAULT), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Power(C2, p), CN1), Int(ExpandIntegrand(Times(Power(Times(e, x), m), Power(Plus(Power(Times(Exp(Times(a, b, Sqr(d), p, Power(Plus(m, C1), CN1))), Power(x, Times(Plus(m, C1), Power(p, CN1)))), CN1), Times(Exp(Times(a, b, Sqr(d), p, Power(Plus(m, C1), CN1))), Power(x, Times(Plus(m, C1), Power(p, CN1))))), p)), x), x), x), And(FreeQ(List(a, b, d, e, m), x), IGtQ(p, C0), EqQ(Subtract(Times(Sqr(b), Sqr(d), Sqr(p)), Sqr(Plus(m, C1))), C0))));
            IIntegrate(5533, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Sinh(Times(Plus(a_DEFAULT, Times(Log(x_), b_DEFAULT)), d_DEFAULT)), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Sinh(Times(d, Plus(a, Times(b, Log(x))))), p), Power(Times(Power(x, Times(b, d, p)), Power(Subtract(C1, Power(Times(Exp(Times(C2, a, d)), Power(x, Times(C2, b, d))), CN1)), p)), CN1)), Int(Times(Power(Times(e, x), m), Power(x, Times(b, d, p)), Power(Subtract(C1, Power(Times(Exp(Times(C2, a, d)), Power(x, Times(C2, b, d))), CN1)), p)), x), x), And(FreeQ(List(a, b, d, e, m, p), x), Not(IntegerQ(p)))));
            IIntegrate(5534, Int(Times(Power(Cosh(Times(Plus(a_DEFAULT, Times(Log(x_), b_DEFAULT)), d_DEFAULT)), p_), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Cosh(Times(d, Plus(a, Times(b, Log(x))))), p), Power(Times(Power(x, Times(b, d, p)), Power(Plus(C1, Power(Times(Exp(Times(C2, a, d)), Power(x, Times(C2, b, d))), CN1)), p)), CN1)), Int(Times(Power(Times(e, x), m), Power(x, Times(b, d, p)), Power(Plus(C1, Power(Times(Exp(Times(C2, a, d)), Power(x, Times(C2, b, d))), CN1)), p)), x), x), And(FreeQ(List(a, b, d, e, m, p), x), Not(IntegerQ(p)))));
            IIntegrate(5535, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Sinh(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Times(e, x), Plus(m, C1)), Power(Times(e, n, Power(Times(c, Power(x, n)), Times(Plus(m, C1), Power(n, CN1)))), CN1)), Subst(Int(Times(Power(x, Subtract(Times(Plus(m, C1), Power(n, CN1)), C1)), Power(Sinh(Times(d, Plus(a, Times(b, Log(x))))), p)), x), x, Times(c, Power(x, n))), x), And(FreeQ(List(a, b, c, d, e, m, n, p), x), Or(NeQ(c, C1), NeQ(n, C1)))));
            IIntegrate(5536, Int(Times(Power(Cosh(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), p_DEFAULT), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Times(e, x), Plus(m, C1)), Power(Times(e, n, Power(Times(c, Power(x, n)), Times(Plus(m, C1), Power(n, CN1)))), CN1)), Subst(Int(Times(Power(x, Subtract(Times(Plus(m, C1), Power(n, CN1)), C1)), Power(Cosh(Times(d, Plus(a, Times(b, Log(x))))), p)), x), x, Times(c, Power(x, n))), x), And(FreeQ(List(a, b, c, d, e, m, n, p), x), Or(NeQ(c, C1), NeQ(n, C1)))));
            IIntegrate(5537, Int(Times(Power(Times(Plus(e_DEFAULT, Times(Log(Times(g_DEFAULT, Power(x_, m_DEFAULT))), f_DEFAULT)), h_DEFAULT), q_DEFAULT), Sinh(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT))), x_Symbol),
                    Condition(Plus(Negate(Dist(Power(Times(Exp(Times(a, d)), Power(Times(c, Power(x, n)), Times(b, d)), C2, Power(Power(x, Times(b, d, n)), CN1)), CN1), Int(Times(Power(Times(h, Plus(e, Times(f, Log(Times(g, Power(x, m)))))), q), Power(Power(x, Times(b, d, n)), CN1)), x), x)), Dist(Times(Exp(Times(a, d)), Power(Times(c, Power(x, n)), Times(b, d)), Power(Times(C2, Power(x, Times(b, d, n))), CN1)), Int(Times(Power(x, Times(b, d, n)), Power(Times(h, Plus(e, Times(f, Log(Times(g, Power(x, m)))))), q)), x), x)), FreeQ(List(a, b, c, d, e, f, g, h, m, n, q), x)));
            IIntegrate(5538, Int(Times(Cosh(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), Power(Times(Plus(e_DEFAULT, Times(Log(Times(g_DEFAULT, Power(x_, m_DEFAULT))), f_DEFAULT)), h_DEFAULT), q_DEFAULT)), x_Symbol),
                    Condition(Plus(Dist(Power(Times(Exp(Times(a, d)), Power(Times(c, Power(x, n)), Times(b, d)), C2, Power(Power(x, Times(b, d, n)), CN1)), CN1), Int(Times(Power(Times(h, Plus(e, Times(f, Log(Times(g, Power(x, m)))))), q), Power(Power(x, Times(b, d, n)), CN1)), x), x), Dist(Times(Exp(Times(a, d)), Power(Times(c, Power(x, n)), Times(b, d)), Power(Times(C2, Power(x, Times(b, d, n))), CN1)), Int(Times(Power(x, Times(b, d, n)), Power(Times(h, Plus(e, Times(f, Log(Times(g, Power(x, m)))))), q)), x), x)), FreeQ(List(a, b, c, d, e, f, g, h, m, n, q), x)));
            IIntegrate(5539, Int(Times(Power(Times(Plus(e_DEFAULT, Times(Log(Times(g_DEFAULT, Power(x_, m_DEFAULT))), f_DEFAULT)), h_DEFAULT), q_DEFAULT), Power(Times(i_DEFAULT, x_), r_DEFAULT), Sinh(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT))), x_Symbol),
                    Condition(Plus(Negate(Dist(Times(Power(Times(i, x), r), Power(Times(Exp(Times(a, d)), Power(Times(c, Power(x, n)), Times(b, d)), C2, Power(x, Subtract(r, Times(b, d, n)))), CN1)), Int(Times(Power(x, Subtract(r, Times(b, d, n))), Power(Times(h, Plus(e, Times(f, Log(Times(g, Power(x, m)))))), q)), x), x)), Dist(Times(Exp(Times(a, d)), Power(Times(i, x), r), Power(Times(c, Power(x, n)), Times(b, d)), Power(Times(C2, Power(x, Plus(r, Times(b, d, n)))), CN1)), Int(Times(Power(x, Plus(r, Times(b, d, n))), Power(Times(h, Plus(e, Times(f, Log(Times(g, Power(x, m)))))), q)), x), x)), FreeQ(List(a, b, c, d, e, f, g, h, i, m, n, q, r), x)));
            IIntegrate(5540, Int(Times(Cosh(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), Power(Times(Plus(e_DEFAULT, Times(Log(Times(g_DEFAULT, Power(x_, m_DEFAULT))), f_DEFAULT)), h_DEFAULT), q_DEFAULT), Power(Times(i_DEFAULT, x_), r_DEFAULT)), x_Symbol),
                    Condition(Plus(Dist(Times(Power(Times(i, x), r), Power(Times(Exp(Times(a, d)), Power(Times(c, Power(x, n)), Times(b, d)), C2, Power(x, Subtract(r, Times(b, d, n)))), CN1)), Int(Times(Power(x, Subtract(r, Times(b, d, n))), Power(Times(h, Plus(e, Times(f, Log(Times(g, Power(x, m)))))), q)), x), x), Dist(Times(Exp(Times(a, d)), Power(Times(i, x), r), Power(Times(c, Power(x, n)), Times(b, d)), Power(Times(C2, Power(x, Plus(r, Times(b, d, n)))), CN1)), Int(Times(Power(x, Plus(r, Times(b, d, n))), Power(Times(h, Plus(e, Times(f, Log(Times(g, Power(x, m)))))), q)), x), x)), FreeQ(List(a, b, c, d, e, f, g, h, i, m, n, q, r), x)));
            IIntegrate(5541, Int(Power(Sech(Times(Plus(a_DEFAULT, Times(Log(x_), b_DEFAULT)), d_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Times(Power(C2, p), Power(Exp(Times(a, d, p)), CN1)), Int(Power(Times(Power(x, Times(b, d, p)), Power(Plus(C1, Power(Times(Exp(Times(C2, a, d)), Power(x, Times(C2, b, d))), CN1)), p)), CN1), x), x), And(FreeQ(List(a, b, d), x), IntegerQ(p))));
            IIntegrate(5542, Int(Power(Csch(Times(Plus(a_DEFAULT, Times(Log(x_), b_DEFAULT)), d_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Times(Power(C2, p), Power(Exp(Times(a, d, p)), CN1)), Int(Power(Times(Power(x, Times(b, d, p)), Power(Subtract(C1, Power(Times(Exp(Times(C2, a, d)), Power(x, Times(C2, b, d))), CN1)), p)), CN1), x), x), And(FreeQ(List(a, b, d), x), IntegerQ(p))));
            IIntegrate(5543, Int(Power(Sech(Times(Plus(a_DEFAULT, Times(Log(x_), b_DEFAULT)), d_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Times(Power(Sech(Times(d, Plus(a, Times(b, Log(x))))), p), Power(Plus(C1, Power(Times(Exp(Times(C2, a, d)), Power(x, Times(C2, b, d))), CN1)), p), Power(Power(x, Times(CN1, b, d, p)), CN1)), Int(Power(Times(Power(x, Times(b, d, p)), Power(Plus(C1, Power(Times(Exp(Times(C2, a, d)), Power(x, Times(C2, b, d))), CN1)), p)), CN1), x), x), And(FreeQ(List(a, b, d, p), x), Not(IntegerQ(p)))));
            IIntegrate(5544, Int(Power(Csch(Times(Plus(a_DEFAULT, Times(Log(x_), b_DEFAULT)), d_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Times(Power(Csch(Times(d, Plus(a, Times(b, Log(x))))), p), Power(Subtract(C1, Power(Times(Exp(Times(C2, a, d)), Power(x, Times(C2, b, d))), CN1)), p), Power(Power(x, Times(CN1, b, d, p)), CN1)), Int(Power(Times(Power(x, Times(b, d, p)), Power(Subtract(C1, Power(Times(Exp(Times(C2, a, d)), Power(x, Times(C2, b, d))), CN1)), p)), CN1), x), x), And(FreeQ(List(a, b, d, p), x), Not(IntegerQ(p)))));
            IIntegrate(5545, Int(Power(Sech(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Times(x, Power(Times(n, Power(Times(c, Power(x, n)), Power(n, CN1))), CN1)), Subst(Int(Times(Power(x, Subtract(Power(n, CN1), C1)), Power(Sech(Times(d, Plus(a, Times(b, Log(x))))), p)), x), x, Times(c, Power(x, n))), x), And(FreeQ(List(a, b, c, d, n, p), x), Or(NeQ(c, C1), NeQ(n, C1)))));
            IIntegrate(5546, Int(Power(Csch(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Times(x, Power(Times(n, Power(Times(c, Power(x, n)), Power(n, CN1))), CN1)), Subst(Int(Times(Power(x, Subtract(Power(n, CN1), C1)), Power(Csch(Times(d, Plus(a, Times(b, Log(x))))), p)), x), x, Times(c, Power(x, n))), x), And(FreeQ(List(a, b, c, d, n, p), x), Or(NeQ(c, C1), NeQ(n, C1)))));
            IIntegrate(5547, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Sech(Times(Plus(a_DEFAULT, Times(Log(x_), b_DEFAULT)), d_DEFAULT)), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(C2, p), Power(Exp(Times(a, d, p)), CN1)), Int(Times(Power(Times(e, x), m), Power(Times(Power(x, Times(b, d, p)), Power(Plus(C1, Power(Times(Exp(Times(C2, a, d)), Power(x, Times(C2, b, d))), CN1)), p)), CN1)), x), x), And(FreeQ(List(a, b, d, e, m), x), IntegerQ(p))));
            IIntegrate(5548, Int(Times(Power(Csch(Times(Plus(a_DEFAULT, Times(Log(x_), b_DEFAULT)), d_DEFAULT)), p_DEFAULT), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(C2, p), Power(Exp(Times(a, d, p)), CN1)), Int(Times(Power(Times(e, x), m), Power(Times(Power(x, Times(b, d, p)), Power(Subtract(C1, Power(Times(Exp(Times(C2, a, d)), Power(x, Times(C2, b, d))), CN1)), p)), CN1)), x), x), And(FreeQ(List(a, b, d, e, m), x), IntegerQ(p))));
            IIntegrate(5549, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Sech(Times(Plus(a_DEFAULT, Times(Log(x_), b_DEFAULT)), d_DEFAULT)), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Sech(Times(d, Plus(a, Times(b, Log(x))))), p), Power(Plus(C1, Power(Times(Exp(Times(C2, a, d)), Power(x, Times(C2, b, d))), CN1)), p), Power(Power(x, Times(CN1, b, d, p)), CN1)), Int(Times(Power(Times(e, x), m), Power(Times(Power(x, Times(b, d, p)), Power(Plus(C1, Power(Times(Exp(Times(C2, a, d)), Power(x, Times(C2, b, d))), CN1)), p)), CN1)), x), x), And(FreeQ(List(a, b, d, e, m, p), x), Not(IntegerQ(p)))));
            IIntegrate(5550, Int(Times(Power(Csch(Times(Plus(a_DEFAULT, Times(Log(x_), b_DEFAULT)), d_DEFAULT)), p_DEFAULT), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Csch(Times(d, Plus(a, Times(b, Log(x))))), p), Power(Subtract(C1, Power(Times(Exp(Times(C2, a, d)), Power(x, Times(C2, b, d))), CN1)), p), Power(Power(x, Times(CN1, b, d, p)), CN1)), Int(Times(Power(Times(e, x), m), Power(Times(Power(x, Times(b, d, p)), Power(Subtract(C1, Power(Times(Exp(Times(C2, a, d)), Power(x, Times(C2, b, d))), CN1)), p)), CN1)), x), x), And(FreeQ(List(a, b, d, e, m, p), x), Not(IntegerQ(p)))));
        }
    }
}
