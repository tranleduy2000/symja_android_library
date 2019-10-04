package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcSin;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C1D4;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
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
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
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
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules172 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(4301, Int(Times($($s("§cos"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Power(Times(g_DEFAULT, $($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(C2, Sin(Plus(a, Times(b, x))), Power(Times(g, Sin(Plus(c, Times(d, x)))), p), Power(Times(d, Plus(Times(C2, p), C1)), CN1)), x), Dist(Times(C2, p, g, Power(Plus(Times(C2, p), C1), CN1)), Int(Times(Sin(Plus(a, Times(b, x))), Power(Times(g, Sin(Plus(c, Times(d, x)))), Subtract(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, g), x), EqQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Times(d, Power(b, CN1)), C2), Not(IntegerQ(p)), GtQ(p, C0), IntegerQ(Times(C2, p)))));
            IIntegrate(4302, Int(Times($($s("§sin"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Power(Times(g_DEFAULT, $($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(CN2, Cos(Plus(a, Times(b, x))), Power(Times(g, Sin(Plus(c, Times(d, x)))), p), Power(Times(d, Plus(Times(C2, p), C1)), CN1)), x), Dist(Times(C2, p, g, Power(Plus(Times(C2, p), C1), CN1)), Int(Times(Cos(Plus(a, Times(b, x))), Power(Times(g, Sin(Plus(c, Times(d, x)))), Subtract(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, g), x), EqQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Times(d, Power(b, CN1)), C2), Not(IntegerQ(p)), GtQ(p, C0), IntegerQ(Times(C2, p)))));
            IIntegrate(4303, Int(Times($($s("§cos"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Power(Times(g_DEFAULT, $($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Cos(Plus(a, Times(b, x))), Power(Times(g, Sin(Plus(c, Times(d, x)))), Plus(p, C1)), Power(Times(C2, b, g, Plus(p, C1)), CN1)), x), Dist(Times(Plus(Times(C2, p), C3), Power(Times(C2, g, Plus(p, C1)), CN1)), Int(Times(Sin(Plus(a, Times(b, x))), Power(Times(g, Sin(Plus(c, Times(d, x)))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, g), x), EqQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Times(d, Power(b, CN1)), C2), Not(IntegerQ(p)), LtQ(p, CN1), IntegerQ(Times(C2, p)))));
            IIntegrate(4304, Int(Times($($s("§sin"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Power(Times(g_DEFAULT, $($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Sin(Plus(a, Times(b, x))), Power(Times(g, Sin(Plus(c, Times(d, x)))), Plus(p, C1)), Power(Times(C2, b, g, Plus(p, C1)), CN1)), x)), Dist(Times(Plus(Times(C2, p), C3), Power(Times(C2, g, Plus(p, C1)), CN1)), Int(Times(Cos(Plus(a, Times(b, x))), Power(Times(g, Sin(Plus(c, Times(d, x)))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, g), x), EqQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Times(d, Power(b, CN1)), C2), Not(IntegerQ(p)), LtQ(p, CN1), IntegerQ(Times(C2, p)))));
            IIntegrate(4305, Int(Times($($s("§cos"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Power($($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), CN1D2)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(ArcSin(Subtract(Cos(Plus(a, Times(b, x))), Sin(Plus(a, Times(b, x))))), Power(d, CN1)), x)), Simp(Times(Log(Plus(Cos(Plus(a, Times(b, x))), Sin(Plus(a, Times(b, x))), Sqrt(Sin(Plus(c, Times(d, x)))))), Power(d, CN1)), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Times(d, Power(b, CN1)), C2))));
            IIntegrate(4306, Int(Times($($s("§sin"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Power($($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), CN1D2)), x_Symbol),
                    Condition(Subtract(Negate(Simp(Times(ArcSin(Subtract(Cos(Plus(a, Times(b, x))), Sin(Plus(a, Times(b, x))))), Power(d, CN1)), x)), Simp(Times(Log(Plus(Cos(Plus(a, Times(b, x))), Sin(Plus(a, Times(b, x))), Sqrt(Sin(Plus(c, Times(d, x)))))), Power(d, CN1)), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Times(d, Power(b, CN1)), C2))));
            IIntegrate(4307, Int(Times(Power($($s("§cos"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), CN1), Power(Times(g_DEFAULT, $($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), p_)), x_Symbol),
                    Condition(Dist(Times(C2, g), Int(Times(Sin(Plus(a, Times(b, x))), Power(Times(g, Sin(Plus(c, Times(d, x)))), Subtract(p, C1))), x), x), And(FreeQ(List(a, b, c, d, g, p), x), EqQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Times(d, Power(b, CN1)), C2), Not(IntegerQ(p)), IntegerQ(Times(C2, p)))));
            IIntegrate(4308, Int(Times(Power($($s("§sin"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), CN1), Power(Times(g_DEFAULT, $($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), p_)), x_Symbol),
                    Condition(Dist(Times(C2, g), Int(Times(Cos(Plus(a, Times(b, x))), Power(Times(g, Sin(Plus(c, Times(d, x)))), Subtract(p, C1))), x), x), And(FreeQ(List(a, b, c, d, g, p), x), EqQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Times(d, Power(b, CN1)), C2), Not(IntegerQ(p)), IntegerQ(Times(C2, p)))));
            IIntegrate(4309, Int(Times(Power(Times($($s("§cos"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), e_DEFAULT), m_DEFAULT), Power(Times(g_DEFAULT, $($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Times(g, Sin(Plus(c, Times(d, x)))), p), Power(Times(Power(Times(e, Cos(Plus(a, Times(b, x)))), p), Power(Sin(Plus(a, Times(b, x))), p)), CN1)), Int(Times(Power(Times(e, Cos(Plus(a, Times(b, x)))), Plus(m, p)), Power(Sin(Plus(a, Times(b, x))), p)), x), x), And(FreeQ(List(a, b, c, d, e, g, m, p), x), EqQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Times(d, Power(b, CN1)), C2), Not(IntegerQ(p)))));
            IIntegrate(4310, Int(Times(Power(Times(f_DEFAULT, $($s("§sin"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), n_DEFAULT), Power(Times(g_DEFAULT, $($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Times(g, Sin(Plus(c, Times(d, x)))), p), Power(Times(Power(Cos(Plus(a, Times(b, x))), p), Power(Times(f, Sin(Plus(a, Times(b, x)))), p)), CN1)), Int(Times(Power(Cos(Plus(a, Times(b, x))), p), Power(Times(f, Sin(Plus(a, Times(b, x)))), Plus(n, p))), x), x), And(FreeQ(List(a, b, c, d, f, g, n, p), x), EqQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Times(d, Power(b, CN1)), C2), Not(IntegerQ(p)))));
            IIntegrate(4311, Int(Times(Sqr($($s("§cos"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Sqr($($s("§sin"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Times(g_DEFAULT, $($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), p_)), x_Symbol),
                    Condition(Subtract(Dist(C1D4, Int(Power(Times(g, Sin(Plus(c, Times(d, x)))), p), x), x), Dist(C1D4, Int(Times(Sqr(Cos(Plus(c, Times(d, x)))), Power(Times(g, Sin(Plus(c, Times(d, x)))), p)), x), x)), And(FreeQ(List(a, b, c, d, g), x), EqQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Times(d, Power(b, CN1)), C2), IGtQ(Times(C1D2, p), C0))));
            IIntegrate(4312, Int(Times(Power(Times($($s("§cos"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), e_DEFAULT), m_DEFAULT), Power(Times(f_DEFAULT, $($s("§sin"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), n_DEFAULT), Power($($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(C2, p), Power(Times(Power(e, p), Power(f, p)), CN1)), Int(Times(Power(Times(e, Cos(Plus(a, Times(b, x)))), Plus(m, p)), Power(Times(f, Sin(Plus(a, Times(b, x)))), Plus(n, p))), x), x), And(FreeQ(List(a, b, c, d, e, f, m, n), x), EqQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Times(d, Power(b, CN1)), C2), IntegerQ(p))));
            IIntegrate(4313, Int(Times(Power(Times($($s("§cos"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), e_DEFAULT), m_DEFAULT), Power(Times(f_DEFAULT, $($s("§sin"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), n_DEFAULT), Power(Times(g_DEFAULT, $($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), p_)), x_Symbol),
                    Condition(Simp(Times(e, Power(Times(e, Cos(Plus(a, Times(b, x)))), Subtract(m, C1)), Power(Times(f, Sin(Plus(a, Times(b, x)))), Plus(n, C1)), Power(Times(g, Sin(Plus(c, Times(d, x)))), p), Power(Times(b, f, Plus(n, p, C1)), CN1)), x), And(FreeQ(List(a, b, c, d, e, f, g, m, n, p), x), EqQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Times(d, Power(b, CN1)), C2), Not(IntegerQ(p)), EqQ(Plus(m, p, C1), C0))));
            IIntegrate(4314, Int(Times(Power(Times($($s("§cos"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), f_DEFAULT), n_), Power(Times(e_DEFAULT, $($s("§sin"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), m_), Power(Times(g_DEFAULT, $($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), p_)), x_Symbol),
                    Condition(Negate(Simp(Times(e, Power(Times(e, Sin(Plus(a, Times(b, x)))), Subtract(m, C1)), Power(Times(f, Cos(Plus(a, Times(b, x)))), Plus(n, C1)), Power(Times(g, Sin(Plus(c, Times(d, x)))), p), Power(Times(b, f, Plus(n, p, C1)), CN1)), x)), And(FreeQ(List(a, b, c, d, e, f, g, m, n, p), x), EqQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Times(d, Power(b, CN1)), C2), Not(IntegerQ(p)), EqQ(Plus(m, p, C1), C0))));
            IIntegrate(4315, Int(Times(Power(Times($($s("§cos"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), e_DEFAULT), m_DEFAULT), Power(Times(f_DEFAULT, $($s("§sin"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), n_DEFAULT), Power(Times(g_DEFAULT, $($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), p_)), x_Symbol),
                    Condition(Negate(Simp(Times(Power(Times(e, Cos(Plus(a, Times(b, x)))), Plus(m, C1)), Power(Times(f, Sin(Plus(a, Times(b, x)))), Plus(n, C1)), Power(Times(g, Sin(Plus(c, Times(d, x)))), p), Power(Times(b, e, f, Plus(m, p, C1)), CN1)), x)), And(FreeQ(List(a, b, c, d, e, f, g, m, n, p), x), EqQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Times(d, Power(b, CN1)), C2), Not(IntegerQ(p)), EqQ(Plus(m, n, Times(C2, p), C2), C0), NeQ(Plus(m, p, C1), C0))));
            IIntegrate(4316, Int(Times(Power(Times($($s("§cos"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), e_DEFAULT), m_), Power(Times(f_DEFAULT, $($s("§sin"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), n_), Power(Times(g_DEFAULT, $($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Sqr(e), Power(Times(e, Cos(Plus(a, Times(b, x)))), Subtract(m, C2)), Power(Times(f, Sin(Plus(a, Times(b, x)))), n), Power(Times(g, Sin(Plus(c, Times(d, x)))), Plus(p, C1)), Power(Times(C2, b, g, Plus(n, p, C1)), CN1)), x), Dist(Times(Power(e, C4), Subtract(Plus(m, p), C1), Power(Times(C4, Sqr(g), Plus(n, p, C1)), CN1)), Int(Times(Power(Times(e, Cos(Plus(a, Times(b, x)))), Subtract(m, C4)), Power(Times(f, Sin(Plus(a, Times(b, x)))), n), Power(Times(g, Sin(Plus(c, Times(d, x)))), Plus(p, C2))), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, n), x), EqQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Times(d, Power(b, CN1)), C2), Not(IntegerQ(p)), GtQ(m, C3), LtQ(p, CN1), NeQ(Plus(n, p, C1), C0), IntegersQ(Times(C2, m), Times(C2, n), Times(C2, p)))));
            IIntegrate(4317, Int(Times(Power(Times($($s("§cos"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), f_DEFAULT), n_), Power(Times(e_DEFAULT, $($s("§sin"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), m_), Power(Times(g_DEFAULT, $($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Sqr(e), Power(Times(e, Sin(Plus(a, Times(b, x)))), Subtract(m, C2)), Power(Times(f, Cos(Plus(a, Times(b, x)))), n), Power(Times(g, Sin(Plus(c, Times(d, x)))), Plus(p, C1)), Power(Times(C2, b, g, Plus(n, p, C1)), CN1)), x)), Dist(Times(Power(e, C4), Subtract(Plus(m, p), C1), Power(Times(C4, Sqr(g), Plus(n, p, C1)), CN1)), Int(Times(Power(Times(e, Sin(Plus(a, Times(b, x)))), Subtract(m, C4)), Power(Times(f, Cos(Plus(a, Times(b, x)))), n), Power(Times(g, Sin(Plus(c, Times(d, x)))), Plus(p, C2))), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, n), x), EqQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Times(d, Power(b, CN1)), C2), Not(IntegerQ(p)), GtQ(m, C3), LtQ(p, CN1), NeQ(Plus(n, p, C1), C0), IntegersQ(Times(C2, m), Times(C2, n), Times(C2, p)))));
            IIntegrate(4318, Int(Times(Power(Times($($s("§cos"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), e_DEFAULT), m_), Power(Times(f_DEFAULT, $($s("§sin"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), n_DEFAULT), Power(Times(g_DEFAULT, $($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(e, Cos(Plus(a, Times(b, x)))), m), Power(Times(f, Sin(Plus(a, Times(b, x)))), n), Power(Times(g, Sin(Plus(c, Times(d, x)))), Plus(p, C1)), Power(Times(C2, b, g, Plus(n, p, C1)), CN1)), x), Dist(Times(Sqr(e), Plus(m, n, Times(C2, p), C2), Power(Times(C4, Sqr(g), Plus(n, p, C1)), CN1)), Int(Times(Power(Times(e, Cos(Plus(a, Times(b, x)))), Subtract(m, C2)), Power(Times(f, Sin(Plus(a, Times(b, x)))), n), Power(Times(g, Sin(Plus(c, Times(d, x)))), Plus(p, C2))), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, n), x), EqQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Times(d, Power(b, CN1)), C2), Not(IntegerQ(p)), GtQ(m, C1), LtQ(p, CN1), NeQ(Plus(m, n, Times(C2, p), C2), C0), NeQ(Plus(n, p, C1), C0), IntegersQ(Times(C2, m), Times(C2, n), Times(C2, p)), Or(LtQ(p, CN2), EqQ(m, C2), EqQ(m, C3)))));
            IIntegrate(4319, Int(Times(Power(Times($($s("§cos"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), f_DEFAULT), n_DEFAULT), Power(Times(e_DEFAULT, $($s("§sin"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), m_), Power(Times(g_DEFAULT, $($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Times(e, Sin(Plus(a, Times(b, x)))), m), Power(Times(f, Cos(Plus(a, Times(b, x)))), n), Power(Times(g, Sin(Plus(c, Times(d, x)))), Plus(p, C1)), Power(Times(C2, b, g, Plus(n, p, C1)), CN1)), x)), Dist(Times(Sqr(e), Plus(m, n, Times(C2, p), C2), Power(Times(C4, Sqr(g), Plus(n, p, C1)), CN1)), Int(Times(Power(Times(e, Sin(Plus(a, Times(b, x)))), Subtract(m, C2)), Power(Times(f, Cos(Plus(a, Times(b, x)))), n), Power(Times(g, Sin(Plus(c, Times(d, x)))), Plus(p, C2))), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, n), x), EqQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Times(d, Power(b, CN1)), C2), Not(IntegerQ(p)), GtQ(m, C1), LtQ(p, CN1), NeQ(Plus(m, n, Times(C2, p), C2), C0), NeQ(Plus(n, p, C1), C0), IntegersQ(Times(C2, m), Times(C2, n), Times(C2, p)), Or(LtQ(p, CN2), EqQ(m, C2), EqQ(m, C3)))));
            IIntegrate(4320, Int(Times(Power(Times($($s("§cos"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), e_DEFAULT), m_), Power(Times(f_DEFAULT, $($s("§sin"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), n_), Power(Times(g_DEFAULT, $($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(e, Power(Times(e, Cos(Plus(a, Times(b, x)))), Subtract(m, C1)), Power(Times(f, Sin(Plus(a, Times(b, x)))), Plus(n, C1)), Power(Times(g, Sin(Plus(c, Times(d, x)))), p), Power(Times(b, f, Plus(n, p, C1)), CN1)), x), Dist(Times(Sqr(e), Subtract(Plus(m, p), C1), Power(Times(Sqr(f), Plus(n, p, C1)), CN1)), Int(Times(Power(Times(e, Cos(Plus(a, Times(b, x)))), Subtract(m, C2)), Power(Times(f, Sin(Plus(a, Times(b, x)))), Plus(n, C2)), Power(Times(g, Sin(Plus(c, Times(d, x)))), p)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, p), x), EqQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Times(d, Power(b, CN1)), C2), Not(IntegerQ(p)), GtQ(m, C1), LtQ(n, CN1), NeQ(Plus(n, p, C1), C0), IntegersQ(Times(C2, m), Times(C2, n), Times(C2, p)))));
            IIntegrate(4321, Int(Times(Power(Times($($s("§cos"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), f_DEFAULT), n_), Power(Times(e_DEFAULT, $($s("§sin"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), m_), Power(Times(g_DEFAULT, $($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(e, Power(Times(e, Sin(Plus(a, Times(b, x)))), Subtract(m, C1)), Power(Times(f, Cos(Plus(a, Times(b, x)))), Plus(n, C1)), Power(Times(g, Sin(Plus(c, Times(d, x)))), p), Power(Times(b, f, Plus(n, p, C1)), CN1)), x)), Dist(Times(Sqr(e), Subtract(Plus(m, p), C1), Power(Times(Sqr(f), Plus(n, p, C1)), CN1)), Int(Times(Power(Times(e, Sin(Plus(a, Times(b, x)))), Subtract(m, C2)), Power(Times(f, Cos(Plus(a, Times(b, x)))), Plus(n, C2)), Power(Times(g, Sin(Plus(c, Times(d, x)))), p)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, p), x), EqQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Times(d, Power(b, CN1)), C2), Not(IntegerQ(p)), GtQ(m, C1), LtQ(n, CN1), NeQ(Plus(n, p, C1), C0), IntegersQ(Times(C2, m), Times(C2, n), Times(C2, p)))));
            IIntegrate(4322, Int(Times(Power(Times($($s("§cos"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), e_DEFAULT), m_), Power(Times(f_DEFAULT, $($s("§sin"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), n_DEFAULT), Power(Times(g_DEFAULT, $($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(e, Power(Times(e, Cos(Plus(a, Times(b, x)))), Subtract(m, C1)), Power(Times(f, Sin(Plus(a, Times(b, x)))), Plus(n, C1)), Power(Times(g, Sin(Plus(c, Times(d, x)))), p), Power(Times(b, f, Plus(m, n, Times(C2, p))), CN1)), x), Dist(Times(Sqr(e), Subtract(Plus(m, p), C1), Power(Plus(m, n, Times(C2, p)), CN1)), Int(Times(Power(Times(e, Cos(Plus(a, Times(b, x)))), Subtract(m, C2)), Power(Times(f, Sin(Plus(a, Times(b, x)))), n), Power(Times(g, Sin(Plus(c, Times(d, x)))), p)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, n, p), x), EqQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Times(d, Power(b, CN1)), C2), Not(IntegerQ(p)), GtQ(m, C1), NeQ(Plus(m, n, Times(C2, p)), C0), IntegersQ(Times(C2, m), Times(C2, n), Times(C2, p)))));
            IIntegrate(4323, Int(Times(Power(Times($($s("§cos"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), f_DEFAULT), n_DEFAULT), Power(Times(e_DEFAULT, $($s("§sin"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), m_), Power(Times(g_DEFAULT, $($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(e, Power(Times(e, Sin(Plus(a, Times(b, x)))), Subtract(m, C1)), Power(Times(f, Cos(Plus(a, Times(b, x)))), Plus(n, C1)), Power(Times(g, Sin(Plus(c, Times(d, x)))), p), Power(Times(b, f, Plus(m, n, Times(C2, p))), CN1)), x)), Dist(Times(Sqr(e), Subtract(Plus(m, p), C1), Power(Plus(m, n, Times(C2, p)), CN1)), Int(Times(Power(Times(e, Sin(Plus(a, Times(b, x)))), Subtract(m, C2)), Power(Times(f, Cos(Plus(a, Times(b, x)))), n), Power(Times(g, Sin(Plus(c, Times(d, x)))), p)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, n, p), x), EqQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Times(d, Power(b, CN1)), C2), Not(IntegerQ(p)), GtQ(m, C1), NeQ(Plus(m, n, Times(C2, p)), C0), IntegersQ(Times(C2, m), Times(C2, n), Times(C2, p)))));
            IIntegrate(4324, Int(Times(Power(Times($($s("§cos"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), e_DEFAULT), m_), Power(Times(f_DEFAULT, $($s("§sin"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), n_DEFAULT), Power(Times(g_DEFAULT, $($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(f, Power(Times(e, Cos(Plus(a, Times(b, x)))), Plus(m, C1)), Power(Times(f, Sin(Plus(a, Times(b, x)))), Subtract(n, C1)), Power(Times(g, Sin(Plus(c, Times(d, x)))), p), Power(Times(b, e, Plus(m, n, Times(C2, p))), CN1)), x)), Dist(Times(C2, f, g, Subtract(Plus(n, p), C1), Power(Times(e, Plus(m, n, Times(C2, p))), CN1)), Int(Times(Power(Times(e, Cos(Plus(a, Times(b, x)))), Plus(m, C1)), Power(Times(f, Sin(Plus(a, Times(b, x)))), Subtract(n, C1)), Power(Times(g, Sin(Plus(c, Times(d, x)))), Subtract(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), EqQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Times(d, Power(b, CN1)), C2), Not(IntegerQ(p)), LtQ(m, CN1), GtQ(n, C0), GtQ(p, C0), NeQ(Plus(m, n, Times(C2, p)), C0), IntegersQ(Times(C2, m), Times(C2, n), Times(C2, p)))));
            IIntegrate(4325, Int(Times(Power(Times($($s("§cos"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), f_DEFAULT), n_DEFAULT), Power(Times(e_DEFAULT, $($s("§sin"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), m_), Power(Times(g_DEFAULT, $($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(f, Power(Times(e, Sin(Plus(a, Times(b, x)))), Plus(m, C1)), Power(Times(f, Cos(Plus(a, Times(b, x)))), Subtract(n, C1)), Power(Times(g, Sin(Plus(c, Times(d, x)))), p), Power(Times(b, e, Plus(m, n, Times(C2, p))), CN1)), x), Dist(Times(C2, f, g, Subtract(Plus(n, p), C1), Power(Times(e, Plus(m, n, Times(C2, p))), CN1)), Int(Times(Power(Times(e, Sin(Plus(a, Times(b, x)))), Plus(m, C1)), Power(Times(f, Cos(Plus(a, Times(b, x)))), Subtract(n, C1)), Power(Times(g, Sin(Plus(c, Times(d, x)))), Subtract(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), EqQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Times(d, Power(b, CN1)), C2), Not(IntegerQ(p)), LtQ(m, CN1), GtQ(n, C0), GtQ(p, C0), NeQ(Plus(m, n, Times(C2, p)), C0), IntegersQ(Times(C2, m), Times(C2, n), Times(C2, p)))));
        }
    }
}
