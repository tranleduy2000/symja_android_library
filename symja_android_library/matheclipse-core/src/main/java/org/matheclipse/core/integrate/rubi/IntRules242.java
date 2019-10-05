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
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.PolyLog;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.a_DEFAULT;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_;
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
import static org.matheclipse.core.expression.F.k;
import static org.matheclipse.core.expression.F.k_;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyIntegrand;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules242 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(6051, Int(Times(ArcCoth(u_), Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(C1D2, Int(Times(Log(SimplifyIntegrand(Plus(C1, Power(u, CN1)), x)), Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x), Dist(C1D2, Int(Times(Log(SimplifyIntegrand(Subtract(C1, Power(u, CN1)), x)), Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), IGtQ(p, C0), EqQ(Plus(Times(Sqr(c), d), e), C0), EqQ(Subtract(Sqr(u), Sqr(Subtract(C1, Times(C2, Power(Plus(C1, Times(c, x)), CN1))))), C0))));
            IIntegrate(6052, Int(Times(ArcTanh(u_), Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(C1D2, Int(Times(Log(Plus(C1, u)), Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), p), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x), Dist(C1D2, Int(Times(Log(Subtract(C1, u)), Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), p), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), IGtQ(p, C0), EqQ(Plus(Times(Sqr(c), d), e), C0), EqQ(Subtract(Sqr(u), Sqr(Subtract(C1, Times(C2, Power(Subtract(C1, Times(c, x)), CN1))))), C0))));
            IIntegrate(6053, Int(Times(ArcCoth(u_), Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(C1D2, Int(Times(Log(SimplifyIntegrand(Plus(C1, Power(u, CN1)), x)), Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x), Dist(C1D2, Int(Times(Log(SimplifyIntegrand(Subtract(C1, Power(u, CN1)), x)), Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), IGtQ(p, C0), EqQ(Plus(Times(Sqr(c), d), e), C0), EqQ(Subtract(Sqr(u), Sqr(Subtract(C1, Times(C2, Power(Subtract(C1, Times(c, x)), CN1))))), C0))));
            IIntegrate(6054, Int(Times(Log(Plus(f_, Times(g_DEFAULT, x_))), Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), Plus(p, C1)), Log(Plus(f, Times(g, x))), Power(Times(b, c, d, Plus(p, C1)), CN1)), x), Dist(Times(g, Power(Times(b, c, d, Plus(p, C1)), CN1)), Int(Times(Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), Plus(p, C1)), Power(Plus(f, Times(g, x)), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), IGtQ(p, C0), EqQ(Plus(Times(Sqr(c), d), e), C0), EqQ(Subtract(Times(Sqr(c), Sqr(f)), Sqr(g)), C0))));
            IIntegrate(6055, Int(Times(Log(Plus(f_, Times(g_DEFAULT, x_))), Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), Plus(p, C1)), Log(Plus(f, Times(g, x))), Power(Times(b, c, d, Plus(p, C1)), CN1)), x), Dist(Times(g, Power(Times(b, c, d, Plus(p, C1)), CN1)), Int(Times(Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), Plus(p, C1)), Power(Plus(f, Times(g, x)), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), IGtQ(p, C0), EqQ(Plus(Times(Sqr(c), d), e), C0), EqQ(Subtract(Times(Sqr(c), Sqr(f)), Sqr(g)), C0))));
            IIntegrate(6056, Int(Times(Log(u_), Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), p), PolyLog(C2, Subtract(C1, u)), Power(Times(C2, c, d), CN1)), x), Dist(Times(C1D2, b, p), Int(Times(Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), Subtract(p, C1)), PolyLog(C2, Subtract(C1, u)), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), IGtQ(p, C0), EqQ(Plus(Times(Sqr(c), d), e), C0), EqQ(Subtract(Sqr(Subtract(C1, u)), Sqr(Subtract(C1, Times(C2, Power(Plus(C1, Times(c, x)), CN1))))), C0))));
            IIntegrate(6057, Int(Times(Log(u_), Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p), PolyLog(C2, Subtract(C1, u)), Power(Times(C2, c, d), CN1)), x), Dist(Times(C1D2, b, p), Int(Times(Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), Subtract(p, C1)), PolyLog(C2, Subtract(C1, u)), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), IGtQ(p, C0), EqQ(Plus(Times(Sqr(c), d), e), C0), EqQ(Subtract(Sqr(Subtract(C1, u)), Sqr(Subtract(C1, Times(C2, Power(Plus(C1, Times(c, x)), CN1))))), C0))));
            IIntegrate(6058, Int(Times(Log(u_), Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), p), PolyLog(C2, Subtract(C1, u)), Power(Times(C2, c, d), CN1)), x)), Dist(Times(C1D2, b, p), Int(Times(Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), Subtract(p, C1)), PolyLog(C2, Subtract(C1, u)), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), IGtQ(p, C0), EqQ(Plus(Times(Sqr(c), d), e), C0), EqQ(Subtract(Sqr(Subtract(C1, u)), Sqr(Subtract(C1, Times(C2, Power(Subtract(C1, Times(c, x)), CN1))))), C0))));
            IIntegrate(6059, Int(Times(Log(u_), Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p), PolyLog(C2, Subtract(C1, u)), Power(Times(C2, c, d), CN1)), x)), Dist(Times(C1D2, b, p), Int(Times(Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), Subtract(p, C1)), PolyLog(C2, Subtract(C1, u)), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), IGtQ(p, C0), EqQ(Plus(Times(Sqr(c), d), e), C0), EqQ(Subtract(Sqr(Subtract(C1, u)), Sqr(Subtract(C1, Times(C2, Power(Subtract(C1, Times(c, x)), CN1))))), C0))));
            IIntegrate(6060, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), PolyLog(k_, u_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), p), PolyLog(Plus(k, C1), u), Power(Times(C2, c, d), CN1)), x)), Dist(Times(C1D2, b, p), Int(Times(Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), Subtract(p, C1)), PolyLog(Plus(k, C1), u), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, k), x), IGtQ(p, C0), EqQ(Plus(Times(Sqr(c), d), e), C0), EqQ(Subtract(Sqr(u), Sqr(Subtract(C1, Times(C2, Power(Plus(C1, Times(c, x)), CN1))))), C0))));
            IIntegrate(6061, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), PolyLog(k_, u_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p), PolyLog(Plus(k, C1), u), Power(Times(C2, c, d), CN1)), x)), Dist(Times(C1D2, b, p), Int(Times(Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), Subtract(p, C1)), PolyLog(Plus(k, C1), u), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, k), x), IGtQ(p, C0), EqQ(Plus(Times(Sqr(c), d), e), C0), EqQ(Subtract(Sqr(u), Sqr(Subtract(C1, Times(C2, Power(Plus(C1, Times(c, x)), CN1))))), C0))));
            IIntegrate(6062, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), PolyLog(k_, u_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), p), PolyLog(Plus(k, C1), u), Power(Times(C2, c, d), CN1)), x), Dist(Times(C1D2, b, p), Int(Times(Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), Subtract(p, C1)), PolyLog(Plus(k, C1), u), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, k), x), IGtQ(p, C0), EqQ(Plus(Times(Sqr(c), d), e), C0), EqQ(Subtract(Sqr(u), Sqr(Subtract(C1, Times(C2, Power(Subtract(C1, Times(c, x)), CN1))))), C0))));
            IIntegrate(6063, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), PolyLog(k_, u_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p), PolyLog(Plus(k, C1), u), Power(Times(C2, c, d), CN1)), x), Dist(Times(C1D2, b, p), Int(Times(Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), Subtract(p, C1)), PolyLog(Plus(k, C1), u), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, k), x), IGtQ(p, C0), EqQ(Plus(Times(Sqr(c), d), e), C0), EqQ(Subtract(Sqr(u), Sqr(Subtract(C1, Times(C2, Power(Subtract(C1, Times(c, x)), CN1))))), C0))));
            IIntegrate(6064, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), CN1), Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), CN1), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Simp(Times(Plus(Negate(Log(Plus(a, Times(b, ArcCoth(Times(c, x)))))), Log(Plus(a, Times(b, ArcTanh(Times(c, x)))))), Power(Times(Sqr(b), c, d, Subtract(ArcCoth(Times(c, x)), ArcTanh(Times(c, x)))), CN1)), x), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0))));
            IIntegrate(6065, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), m_DEFAULT), Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), Plus(m, C1)), Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), p), Power(Times(b, c, d, Plus(m, C1)), CN1)), x), Dist(Times(p, Power(Plus(m, C1), CN1)), Int(Times(Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), Plus(m, C1)), Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), Subtract(p, C1)), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), IGtQ(p, C0), IGeQ(m, p))));
            IIntegrate(6066, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), Plus(m, C1)), Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p), Power(Times(b, c, d, Plus(m, C1)), CN1)), x), Dist(Times(p, Power(Plus(m, C1), CN1)), Int(Times(Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), Plus(m, C1)), Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), Subtract(p, C1)), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), IGtQ(p, C0), IGtQ(m, p))));
            IIntegrate(6067, Int(Times(ArcTanh(Times(a_DEFAULT, x_)), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_DEFAULT))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(C1D2, Int(Times(Log(Plus(C1, Times(a, x))), Power(Plus(c, Times(d, Power(x, n))), CN1)), x), x), Dist(C1D2, Int(Times(Log(Subtract(C1, Times(a, x))), Power(Plus(c, Times(d, Power(x, n))), CN1)), x), x)), And(FreeQ(List(a, c, d), x), IntegerQ(n), Not(And(EqQ(n, C2), EqQ(Plus(Times(Sqr(a), c), d), C0))))));
            IIntegrate(6068, Int(Times(ArcCoth(Times(a_DEFAULT, x_)), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_DEFAULT))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(C1D2, Int(Times(Log(Plus(C1, Power(Times(a, x), CN1))), Power(Plus(c, Times(d, Power(x, n))), CN1)), x), x), Dist(C1D2, Int(Times(Log(Subtract(C1, Power(Times(a, x), CN1))), Power(Plus(c, Times(d, Power(x, n))), CN1)), x), x)), And(FreeQ(List(a, c, d), x), IntegerQ(n), Not(And(EqQ(n, C2), EqQ(Plus(Times(Sqr(a), c), d), C0))))));
            IIntegrate(6069, Int(Times(ArcTanh(Times(c_DEFAULT, Power(x_, n_DEFAULT))), Log(Times(d_DEFAULT, Power(x_, m_DEFAULT))), Power(x_, CN1)), x_Symbol),
                    Condition(Subtract(Dist(C1D2, Int(Times(Log(Times(d, Power(x, m))), Log(Plus(C1, Times(c, Power(x, n)))), Power(x, CN1)), x), x), Dist(C1D2, Int(Times(Log(Times(d, Power(x, m))), Log(Subtract(C1, Times(c, Power(x, n)))), Power(x, CN1)), x), x)), FreeQ(List(c, d, m, n), x)));
            IIntegrate(6070, Int(Times(ArcCoth(Times(c_DEFAULT, Power(x_, n_DEFAULT))), Log(Times(d_DEFAULT, Power(x_, m_DEFAULT))), Power(x_, CN1)), x_Symbol),
                    Condition(Subtract(Dist(C1D2, Int(Times(Log(Times(d, Power(x, m))), Log(Plus(C1, Power(Times(c, Power(x, n)), CN1))), Power(x, CN1)), x), x), Dist(C1D2, Int(Times(Log(Times(d, Power(x, m))), Log(Subtract(C1, Power(Times(c, Power(x, n)), CN1))), Power(x, CN1)), x), x)), FreeQ(List(c, d, m, n), x)));
            IIntegrate(6071, Int(Times(Log(Times(d_DEFAULT, Power(x_, m_DEFAULT))), Plus(Times(ArcTanh(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT), a_), Power(x_, CN1)), x_Symbol),
                    Condition(Plus(Dist(a, Int(Times(Log(Times(d, Power(x, m))), Power(x, CN1)), x), x), Dist(b, Int(Times(Log(Times(d, Power(x, m))), ArcTanh(Times(c, Power(x, n))), Power(x, CN1)), x), x)), FreeQ(List(a, b, c, d, m, n), x)));
            IIntegrate(6072, Int(Times(Log(Times(d_DEFAULT, Power(x_, m_DEFAULT))), Plus(Times(ArcCoth(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT), a_), Power(x_, CN1)), x_Symbol),
                    Condition(Plus(Dist(a, Int(Times(Log(Times(d, Power(x, m))), Power(x, CN1)), x), x), Dist(b, Int(Times(Log(Times(d, Power(x, m))), ArcCoth(Times(c, Power(x, n))), Power(x, CN1)), x), x)), FreeQ(List(a, b, c, d, m, n), x)));
            IIntegrate(6073, Int(Times(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), Plus(d_DEFAULT, Times(Log(Plus(f_DEFAULT, Times(g_DEFAULT, Sqr(x_)))), e_DEFAULT))), x_Symbol),
                    Condition(Plus(Simp(Times(x, Plus(d, Times(e, Log(Plus(f, Times(g, Sqr(x)))))), Plus(a, Times(b, ArcTanh(Times(c, x))))), x), Negate(Dist(Times(b, c), Int(Times(x, Plus(d, Times(e, Log(Plus(f, Times(g, Sqr(x)))))), Power(Subtract(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x)), Negate(Dist(Times(C2, e, g), Int(Times(Sqr(x), Plus(a, Times(b, ArcTanh(Times(c, x)))), Power(Plus(f, Times(g, Sqr(x))), CN1)), x), x))), FreeQ(List(a, b, c, d, e, f, g), x)));
            IIntegrate(6074, Int(Times(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), Plus(d_DEFAULT, Times(Log(Plus(f_DEFAULT, Times(g_DEFAULT, Sqr(x_)))), e_DEFAULT))), x_Symbol),
                    Condition(Plus(Simp(Times(x, Plus(d, Times(e, Log(Plus(f, Times(g, Sqr(x)))))), Plus(a, Times(b, ArcCoth(Times(c, x))))), x), Negate(Dist(Times(b, c), Int(Times(x, Plus(d, Times(e, Log(Plus(f, Times(g, Sqr(x)))))), Power(Subtract(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x)), Negate(Dist(Times(C2, e, g), Int(Times(Sqr(x), Plus(a, Times(b, ArcCoth(Times(c, x)))), Power(Plus(f, Times(g, Sqr(x))), CN1)), x), x))), FreeQ(List(a, b, c, d, e, f, g), x)));
            IIntegrate(6075, Int(Times(ArcTanh(Times(c_DEFAULT, x_)), Log(Plus(f_DEFAULT, Times(g_DEFAULT, Sqr(x_)))), Power(x_, CN1)), x_Symbol),
                    Condition(Plus(Dist(Subtract(Subtract(Log(Plus(f, Times(g, Sqr(x)))), Log(Subtract(C1, Times(c, x)))), Log(Plus(C1, Times(c, x)))), Int(Times(ArcTanh(Times(c, x)), Power(x, CN1)), x), x), Negate(Dist(C1D2, Int(Times(Sqr(Log(Subtract(C1, Times(c, x)))), Power(x, CN1)), x), x)), Dist(C1D2, Int(Times(Sqr(Log(Plus(C1, Times(c, x)))), Power(x, CN1)), x), x)), And(FreeQ(List(c, f, g), x), EqQ(Plus(Times(Sqr(c), f), g), C0))));
        }
    }
}
