package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcCot;
import static org.matheclipse.core.expression.F.ArcCoth;
import static org.matheclipse.core.expression.F.ArcTan;
import static org.matheclipse.core.expression.F.ArcTanh;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CI;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.PolyLog;
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
import static org.matheclipse.core.expression.F.k;
import static org.matheclipse.core.expression.F.k_;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntHide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumQ;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules199 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(4976, Int(Times(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT)), Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), q)), x))), Subtract(Dist(Plus(a, Times(b, ArcTan(Times(c, x)))), u, x), Dist(Times(b, c), Int(SimplifyIntegrand(Times(u, Power(Plus(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x), x))), And(FreeQ(List(a, b, c, d, e, f, m, q), x), Or(And(IGtQ(q, C0), Not(And(ILtQ(Times(C1D2, Subtract(m, C1)), C0), GtQ(Plus(m, Times(C2, q), C3), C0)))), And(IGtQ(Times(C1D2, Plus(m, C1)), C0), Not(And(ILtQ(q, C0), GtQ(Plus(m, Times(C2, q), C3), C0)))), And(ILtQ(Times(C1D2, Plus(m, Times(C2, q), C1)), C0), Not(ILtQ(Times(C1D2, Subtract(m, C1)), C0)))))));
            IIntegrate(4977, Int(Times(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT)), Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), q)), x))), Plus(Dist(Plus(a, Times(b, ArcCot(Times(c, x)))), u, x), Dist(Times(b, c), Int(SimplifyIntegrand(Times(u, Power(Plus(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x), x))), And(FreeQ(List(a, b, c, d, e, f, m, q), x), Or(And(IGtQ(q, C0), Not(And(ILtQ(Times(C1D2, Subtract(m, C1)), C0), GtQ(Plus(m, Times(C2, q), C3), C0)))), And(IGtQ(Times(C1D2, Plus(m, C1)), C0), Not(And(ILtQ(q, C0), GtQ(Plus(m, Times(C2, q), C3), C0)))), And(ILtQ(Times(C1D2, Plus(m, Times(C2, q), C1)), C0), Not(ILtQ(Times(C1D2, Subtract(m, C1)), C0)))))));
            IIntegrate(4978, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), x_, Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN2)), x_Symbol),
                    Condition(Subtract(Dist(Power(Times(C4, Sqr(d), Rt(Times(CN1, e, Power(d, CN1)), C2)), CN1), Int(Times(Power(Plus(a, Times(b, ArcTan(Times(c, x)))), p), Power(Subtract(C1, Times(Rt(Times(CN1, e, Power(d, CN1)), C2), x)), CN2)), x), x), Dist(Power(Times(C4, Sqr(d), Rt(Times(CN1, e, Power(d, CN1)), C2)), CN1), Int(Times(Power(Plus(a, Times(b, ArcTan(Times(c, x)))), p), Power(Plus(C1, Times(Rt(Times(CN1, e, Power(d, CN1)), C2), x)), CN2)), x), x)), And(FreeQ(List(a, b, c, d, e), x), IGtQ(p, C0))));
            IIntegrate(4979, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), x_, Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN2)), x_Symbol),
                    Condition(Subtract(Dist(Power(Times(C4, Sqr(d), Rt(Times(CN1, e, Power(d, CN1)), C2)), CN1), Int(Times(Power(Plus(a, Times(b, ArcCot(Times(c, x)))), p), Power(Subtract(C1, Times(Rt(Times(CN1, e, Power(d, CN1)), C2), x)), CN2)), x), x), Dist(Power(Times(C4, Sqr(d), Rt(Times(CN1, e, Power(d, CN1)), C2)), CN1), Int(Times(Power(Plus(a, Times(b, ArcCot(Times(c, x)))), p), Power(Plus(C1, Times(Rt(Times(CN1, e, Power(d, CN1)), C2), x)), CN2)), x), x)), And(FreeQ(List(a, b, c, d, e), x), IGtQ(p, C0))));
            IIntegrate(4980, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, ExpandIntegrand(Power(Plus(a, Times(b, ArcTan(Times(c, x)))), p), Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), q)), x))), Condition(Int(u, x), SumQ(u))), And(FreeQ(List(a, b, c, d, e, f, m), x), IntegerQ(q), IGtQ(p, C0), Or(And(EqQ(p, C1), GtQ(q, C0)), IntegerQ(m)))));
            IIntegrate(4981, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, ExpandIntegrand(Power(Plus(a, Times(b, ArcCot(Times(c, x)))), p), Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), q)), x))), Condition(Int(u, x), SumQ(u))), And(FreeQ(List(a, b, c, d, e, f, m), x), IntegerQ(q), IGtQ(p, C0), Or(And(EqQ(p, C1), GtQ(q, C0)), IntegerQ(m)))));
            IIntegrate(4982, Int(Times(Plus(Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT), a_), Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT)), x_Symbol),
                    Condition(Plus(Dist(a, Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), q)), x), x), Dist(b, Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), q), ArcTan(Times(c, x))), x), x)), FreeQ(List(a, b, c, d, e, f, m, q), x)));
            IIntegrate(4983, Int(Times(Plus(Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT), a_), Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT)), x_Symbol),
                    Condition(Plus(Dist(a, Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), q)), x), x), Dist(b, Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), q), ArcCot(Times(c, x))), x), x)), FreeQ(List(a, b, c, d, e, f, m, q), x)));
            IIntegrate(4984, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(f_, Times(g_DEFAULT, x_)), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(a, Times(b, ArcTan(Times(c, x)))), p), Power(Plus(d, Times(e, Sqr(x))), CN1)), Power(Plus(f, Times(g, x)), m), x), x), And(FreeQ(List(a, b, c, d, e, f, g), x), IGtQ(p, C0), EqQ(e, Times(Sqr(c), d)), IGtQ(m, C0))));
            IIntegrate(4985, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(f_, Times(g_DEFAULT, x_)), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(a, Times(b, ArcCot(Times(c, x)))), p), Power(Plus(d, Times(e, Sqr(x))), CN1)), Power(Plus(f, Times(g, x)), m), x), x), And(FreeQ(List(a, b, c, d, e, f, g), x), IGtQ(p, C0), EqQ(e, Times(Sqr(c), d)), IGtQ(m, C0))));
            IIntegrate(4986, Int(Times(ArcTanh(u_), Power(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(C1D2, Int(Times(Log(Plus(C1, u)), Power(Plus(a, Times(b, ArcTan(Times(c, x)))), p), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x), Dist(C1D2, Int(Times(Log(Subtract(C1, u)), Power(Plus(a, Times(b, ArcTan(Times(c, x)))), p), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), IGtQ(p, C0), EqQ(e, Times(Sqr(c), d)), EqQ(Subtract(Sqr(u), Sqr(Subtract(C1, Times(C2, CI, Power(Plus(CI, Times(c, x)), CN1))))), C0))));
            IIntegrate(4987, Int(Times(ArcCoth(u_), Power(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(C1D2, Int(Times(Log(SimplifyIntegrand(Plus(C1, Power(u, CN1)), x)), Power(Plus(a, Times(b, ArcCot(Times(c, x)))), p), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x), Dist(C1D2, Int(Times(Log(SimplifyIntegrand(Subtract(C1, Power(u, CN1)), x)), Power(Plus(a, Times(b, ArcCot(Times(c, x)))), p), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), IGtQ(p, C0), EqQ(e, Times(Sqr(c), d)), EqQ(Subtract(Sqr(u), Sqr(Subtract(C1, Times(C2, CI, Power(Plus(CI, Times(c, x)), CN1))))), C0))));
            IIntegrate(4988, Int(Times(ArcTanh(u_), Power(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(C1D2, Int(Times(Log(Plus(C1, u)), Power(Plus(a, Times(b, ArcTan(Times(c, x)))), p), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x), Dist(C1D2, Int(Times(Log(Subtract(C1, u)), Power(Plus(a, Times(b, ArcTan(Times(c, x)))), p), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), IGtQ(p, C0), EqQ(e, Times(Sqr(c), d)), EqQ(Subtract(Sqr(u), Sqr(Subtract(C1, Times(C2, CI, Power(Subtract(CI, Times(c, x)), CN1))))), C0))));
            IIntegrate(4989, Int(Times(ArcCoth(u_), Power(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(C1D2, Int(Times(Log(SimplifyIntegrand(Plus(C1, Power(u, CN1)), x)), Power(Plus(a, Times(b, ArcCot(Times(c, x)))), p), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x), Dist(C1D2, Int(Times(Log(SimplifyIntegrand(Subtract(C1, Power(u, CN1)), x)), Power(Plus(a, Times(b, ArcCot(Times(c, x)))), p), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), IGtQ(p, C0), EqQ(e, Times(Sqr(c), d)), EqQ(Subtract(Sqr(u), Sqr(Subtract(C1, Times(C2, CI, Power(Subtract(CI, Times(c, x)), CN1))))), C0))));
            IIntegrate(4990, Int(Times(Log(Plus(f_, Times(g_DEFAULT, x_))), Power(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(a, Times(b, ArcTan(Times(c, x)))), Plus(p, C1)), Log(Plus(f, Times(g, x))), Power(Times(b, c, d, Plus(p, C1)), CN1)), x), Dist(Times(g, Power(Times(b, c, d, Plus(p, C1)), CN1)), Int(Times(Power(Plus(a, Times(b, ArcTan(Times(c, x)))), Plus(p, C1)), Power(Plus(f, Times(g, x)), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), IGtQ(p, C0), EqQ(e, Times(Sqr(c), d)), EqQ(Plus(Times(Sqr(c), Sqr(f)), Sqr(g)), C0))));
            IIntegrate(4991, Int(Times(Log(Plus(f_, Times(g_DEFAULT, x_))), Power(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(a, Times(b, ArcCot(Times(c, x)))), Plus(p, C1)), Log(Plus(f, Times(g, x))), Power(Times(b, c, d, Plus(p, C1)), CN1)), x), Dist(Times(g, Power(Times(b, c, d, Plus(p, C1)), CN1)), Int(Times(Power(Plus(a, Times(b, ArcCot(Times(c, x)))), Plus(p, C1)), Power(Plus(f, Times(g, x)), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), IGtQ(p, C0), EqQ(e, Times(Sqr(c), d)), EqQ(Plus(Times(Sqr(c), Sqr(f)), Sqr(g)), C0))));
            IIntegrate(4992, Int(Times(Log(u_), Power(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(CI, Power(Plus(a, Times(b, ArcTan(Times(c, x)))), p), PolyLog(C2, Subtract(C1, u)), Power(Times(C2, c, d), CN1)), x), Dist(Times(C1D2, b, p, CI), Int(Times(Power(Plus(a, Times(b, ArcTan(Times(c, x)))), Subtract(p, C1)), PolyLog(C2, Subtract(C1, u)), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), IGtQ(p, C0), EqQ(e, Times(Sqr(c), d)), EqQ(Subtract(Sqr(Subtract(C1, u)), Sqr(Subtract(C1, Times(C2, CI, Power(Plus(CI, Times(c, x)), CN1))))), C0))));
            IIntegrate(4993, Int(Times(Log(u_), Power(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Plus(Simp(Times(CI, Power(Plus(a, Times(b, ArcCot(Times(c, x)))), p), PolyLog(C2, Subtract(C1, u)), Power(Times(C2, c, d), CN1)), x), Dist(Times(C1D2, b, p, CI), Int(Times(Power(Plus(a, Times(b, ArcCot(Times(c, x)))), Subtract(p, C1)), PolyLog(C2, Subtract(C1, u)), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), IGtQ(p, C0), EqQ(e, Times(Sqr(c), d)), EqQ(Subtract(Sqr(Subtract(C1, u)), Sqr(Subtract(C1, Times(C2, CI, Power(Plus(CI, Times(c, x)), CN1))))), C0))));
            IIntegrate(4994, Int(Times(Log(u_), Power(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(CI, Power(Plus(a, Times(b, ArcTan(Times(c, x)))), p), PolyLog(C2, Subtract(C1, u)), Power(Times(C2, c, d), CN1)), x)), Dist(Times(C1D2, b, p, CI), Int(Times(Power(Plus(a, Times(b, ArcTan(Times(c, x)))), Subtract(p, C1)), PolyLog(C2, Subtract(C1, u)), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), IGtQ(p, C0), EqQ(e, Times(Sqr(c), d)), EqQ(Subtract(Sqr(Subtract(C1, u)), Sqr(Subtract(C1, Times(C2, CI, Power(Subtract(CI, Times(c, x)), CN1))))), C0))));
            IIntegrate(4995, Int(Times(Log(u_), Power(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Subtract(Negate(Simp(Times(CI, Power(Plus(a, Times(b, ArcCot(Times(c, x)))), p), PolyLog(C2, Subtract(C1, u)), Power(Times(C2, c, d), CN1)), x)), Dist(Times(C1D2, b, p, CI), Int(Times(Power(Plus(a, Times(b, ArcCot(Times(c, x)))), Subtract(p, C1)), PolyLog(C2, Subtract(C1, u)), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), IGtQ(p, C0), EqQ(e, Times(Sqr(c), d)), EqQ(Subtract(Sqr(Subtract(C1, u)), Sqr(Subtract(C1, Times(C2, CI, Power(Subtract(CI, Times(c, x)), CN1))))), C0))));
            IIntegrate(4996, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), PolyLog(k_, u_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(CI, Power(Plus(a, Times(b, ArcTan(Times(c, x)))), p), PolyLog(Plus(k, C1), u), Power(Times(C2, c, d), CN1)), x)), Dist(Times(C1D2, b, p, CI), Int(Times(Power(Plus(a, Times(b, ArcTan(Times(c, x)))), Subtract(p, C1)), PolyLog(Plus(k, C1), u), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, k), x), IGtQ(p, C0), EqQ(e, Times(Sqr(c), d)), EqQ(Subtract(Sqr(u), Sqr(Subtract(C1, Times(C2, CI, Power(Plus(CI, Times(c, x)), CN1))))), C0))));
            IIntegrate(4997, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), PolyLog(k_, u_)), x_Symbol),
                    Condition(Subtract(Negate(Simp(Times(CI, Power(Plus(a, Times(b, ArcCot(Times(c, x)))), p), PolyLog(Plus(k, C1), u), Power(Times(C2, c, d), CN1)), x)), Dist(Times(C1D2, b, p, CI), Int(Times(Power(Plus(a, Times(b, ArcCot(Times(c, x)))), Subtract(p, C1)), PolyLog(Plus(k, C1), u), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, k), x), IGtQ(p, C0), EqQ(e, Times(Sqr(c), d)), EqQ(Subtract(Sqr(u), Sqr(Subtract(C1, Times(C2, CI, Power(Plus(CI, Times(c, x)), CN1))))), C0))));
            IIntegrate(4998, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), PolyLog(k_, u_)), x_Symbol),
                    Condition(Subtract(Simp(Times(CI, Power(Plus(a, Times(b, ArcTan(Times(c, x)))), p), PolyLog(Plus(k, C1), u), Power(Times(C2, c, d), CN1)), x), Dist(Times(C1D2, b, p, CI), Int(Times(Power(Plus(a, Times(b, ArcTan(Times(c, x)))), Subtract(p, C1)), PolyLog(Plus(k, C1), u), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, k), x), IGtQ(p, C0), EqQ(e, Times(Sqr(c), d)), EqQ(Subtract(Sqr(u), Sqr(Subtract(C1, Times(C2, CI, Power(Subtract(CI, Times(c, x)), CN1))))), C0))));
            IIntegrate(4999, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), PolyLog(k_, u_)), x_Symbol),
                    Condition(Plus(Simp(Times(CI, Power(Plus(a, Times(b, ArcCot(Times(c, x)))), p), PolyLog(Plus(k, C1), u), Power(Times(C2, c, d), CN1)), x), Dist(Times(C1D2, b, p, CI), Int(Times(Power(Plus(a, Times(b, ArcCot(Times(c, x)))), Subtract(p, C1)), PolyLog(Plus(k, C1), u), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, k), x), IGtQ(p, C0), EqQ(e, Times(Sqr(c), d)), EqQ(Subtract(Sqr(u), Sqr(Subtract(C1, Times(C2, CI, Power(Subtract(CI, Times(c, x)), CN1))))), C0))));
            IIntegrate(5000, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT)), CN1), Power(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT)), CN1), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Simp(Times(Plus(Negate(Log(Plus(a, Times(b, ArcCot(Times(c, x)))))), Log(Plus(a, Times(b, ArcTan(Times(c, x)))))), Power(Times(b, c, d, Plus(Times(C2, a), Times(b, ArcCot(Times(c, x))), Times(b, ArcTan(Times(c, x))))), CN1)), x), And(FreeQ(List(a, b, c, d, e), x), EqQ(e, Times(Sqr(c), d)))));
        }
    }
}
