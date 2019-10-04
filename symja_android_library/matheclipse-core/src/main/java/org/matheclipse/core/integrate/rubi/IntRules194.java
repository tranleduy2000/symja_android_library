package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcCot;
import static org.matheclipse.core.expression.F.ArcCoth;
import static org.matheclipse.core.expression.F.ArcTan;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CI;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.Negate;
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
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.u;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyIntegrand;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules194 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(4851, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT)), p_), Power(x_, CN1)), x_Symbol),
                    Condition(Plus(Simp(Times(C2, Power(Plus(a, Times(b, ArcCot(Times(c, x)))), p), ArcCoth(Subtract(C1, Times(C2, Power(Plus(C1, Times(CI, c, x)), CN1))))), x), Dist(Times(C2, b, c, p), Int(Times(Power(Plus(a, Times(b, ArcCot(Times(c, x)))), Subtract(p, C1)), ArcCoth(Subtract(C1, Times(C2, Power(Plus(C1, Times(CI, c, x)), CN1)))), Power(Plus(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c), x), IGtQ(p, C1))));
            IIntegrate(4852, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Times(d_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(d, x), Plus(m, C1)), Power(Plus(a, Times(b, ArcTan(Times(c, x)))), p), Power(Times(d, Plus(m, C1)), CN1)), x), Dist(Times(b, c, p, Power(Times(d, Plus(m, C1)), CN1)), Int(Times(Power(Times(d, x), Plus(m, C1)), Power(Plus(a, Times(b, ArcTan(Times(c, x)))), Subtract(p, C1)), Power(Plus(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, m), x), IGtQ(p, C0), Or(EqQ(p, C1), IntegerQ(m)), NeQ(m, CN1))));
            IIntegrate(4853, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Times(d_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(d, x), Plus(m, C1)), Power(Plus(a, Times(b, ArcCot(Times(c, x)))), p), Power(Times(d, Plus(m, C1)), CN1)), x), Dist(Times(b, c, p, Power(Times(d, Plus(m, C1)), CN1)), Int(Times(Power(Times(d, x), Plus(m, C1)), Power(Plus(a, Times(b, ArcCot(Times(c, x)))), Subtract(p, C1)), Power(Plus(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, m), x), IGtQ(p, C0), Or(EqQ(p, C1), IntegerQ(m)), NeQ(m, CN1))));
            IIntegrate(4854, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(a, Times(b, ArcTan(Times(c, x)))), p), Log(Times(C2, Power(Plus(C1, Times(e, x, Power(d, CN1))), CN1))), Power(e, CN1)), x)), Dist(Times(b, c, p, Power(e, CN1)), Int(Times(Power(Plus(a, Times(b, ArcTan(Times(c, x)))), Subtract(p, C1)), Log(Times(C2, Power(Plus(C1, Times(e, x, Power(d, CN1))), CN1))), Power(Plus(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), IGtQ(p, C0), EqQ(Plus(Times(Sqr(c), Sqr(d)), Sqr(e)), C0))));
            IIntegrate(4855, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Subtract(Negate(Simp(Times(Power(Plus(a, Times(b, ArcCot(Times(c, x)))), p), Log(Times(C2, Power(Plus(C1, Times(e, x, Power(d, CN1))), CN1))), Power(e, CN1)), x)), Dist(Times(b, c, p, Power(e, CN1)), Int(Times(Power(Plus(a, Times(b, ArcCot(Times(c, x)))), Subtract(p, C1)), Log(Times(C2, Power(Plus(C1, Times(e, x, Power(d, CN1))), CN1))), Power(Plus(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), IGtQ(p, C0), EqQ(Plus(Times(Sqr(c), Sqr(d)), Sqr(e)), C0))));
            IIntegrate(4856, Int(Times(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT)), Power(Plus(d_, Times(e_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Plus(a, Times(b, ArcTan(Times(c, x)))), Log(Times(C2, Power(Subtract(C1, Times(CI, c, x)), CN1))), Power(e, CN1)), x)), Dist(Times(b, c, Power(e, CN1)), Int(Times(Log(Times(C2, Power(Subtract(C1, Times(CI, c, x)), CN1))), Power(Plus(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x), Negate(Dist(Times(b, c, Power(e, CN1)), Int(Times(Log(Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), Times(CI, e)), Subtract(C1, Times(CI, c, x))), CN1))), Power(Plus(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x)), Simp(Times(Plus(a, Times(b, ArcTan(Times(c, x)))), Log(Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), Times(CI, e)), Subtract(C1, Times(CI, c, x))), CN1))), Power(e, CN1)), x)), And(FreeQ(List(a, b, c, d, e), x), NeQ(Plus(Times(Sqr(c), Sqr(d)), Sqr(e)), C0))));
            IIntegrate(4857, Int(Times(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT)), Power(Plus(d_, Times(e_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Plus(a, Times(b, ArcCot(Times(c, x)))), Log(Times(C2, Power(Subtract(C1, Times(CI, c, x)), CN1))), Power(e, CN1)), x)), Negate(Dist(Times(b, c, Power(e, CN1)), Int(Times(Log(Times(C2, Power(Subtract(C1, Times(CI, c, x)), CN1))), Power(Plus(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x)), Dist(Times(b, c, Power(e, CN1)), Int(Times(Log(Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), Times(CI, e)), Subtract(C1, Times(CI, c, x))), CN1))), Power(Plus(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x), Simp(Times(Plus(a, Times(b, ArcCot(Times(c, x)))), Log(Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), Times(CI, e)), Subtract(C1, Times(CI, c, x))), CN1))), Power(e, CN1)), x)), And(FreeQ(List(a, b, c, d, e), x), NeQ(Plus(Times(Sqr(c), Sqr(d)), Sqr(e)), C0))));
            IIntegrate(4858, Int(Times(Sqr(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT))), Power(Plus(d_, Times(e_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Sqr(Plus(a, Times(b, ArcTan(Times(c, x))))), Log(Times(C2, Power(Subtract(C1, Times(CI, c, x)), CN1))), Power(e, CN1)), x)), Simp(Times(Sqr(Plus(a, Times(b, ArcTan(Times(c, x))))), Log(Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), Times(CI, e)), Subtract(C1, Times(CI, c, x))), CN1))), Power(e, CN1)), x), Simp(Times(CI, b, Plus(a, Times(b, ArcTan(Times(c, x)))), PolyLog(C2, Subtract(C1, Times(C2, Power(Subtract(C1, Times(CI, c, x)), CN1)))), Power(e, CN1)), x), Negate(Simp(Times(CI, b, Plus(a, Times(b, ArcTan(Times(c, x)))), PolyLog(C2, Subtract(C1, Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), Times(CI, e)), Subtract(C1, Times(CI, c, x))), CN1)))), Power(e, CN1)), x)), Negate(Simp(Times(Sqr(b), PolyLog(C3, Subtract(C1, Times(C2, Power(Subtract(C1, Times(CI, c, x)), CN1)))), Power(Times(C2, e), CN1)), x)), Simp(Times(Sqr(b), PolyLog(C3, Subtract(C1, Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), Times(CI, e)), Subtract(C1, Times(CI, c, x))), CN1)))), Power(Times(C2, e), CN1)), x)), And(FreeQ(List(a, b, c, d, e), x), NeQ(Plus(Times(Sqr(c), Sqr(d)), Sqr(e)), C0))));
            IIntegrate(4859, Int(Times(Sqr(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT))), Power(Plus(d_, Times(e_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Sqr(Plus(a, Times(b, ArcCot(Times(c, x))))), Log(Times(C2, Power(Subtract(C1, Times(CI, c, x)), CN1))), Power(e, CN1)), x)), Simp(Times(Sqr(Plus(a, Times(b, ArcCot(Times(c, x))))), Log(Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), Times(CI, e)), Subtract(C1, Times(CI, c, x))), CN1))), Power(e, CN1)), x), Negate(Simp(Times(CI, b, Plus(a, Times(b, ArcCot(Times(c, x)))), PolyLog(C2, Subtract(C1, Times(C2, Power(Subtract(C1, Times(CI, c, x)), CN1)))), Power(e, CN1)), x)), Simp(Times(CI, b, Plus(a, Times(b, ArcCot(Times(c, x)))), PolyLog(C2, Subtract(C1, Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), Times(CI, e)), Subtract(C1, Times(CI, c, x))), CN1)))), Power(e, CN1)), x), Negate(Simp(Times(Sqr(b), PolyLog(C3, Subtract(C1, Times(C2, Power(Subtract(C1, Times(CI, c, x)), CN1)))), Power(Times(C2, e), CN1)), x)), Simp(Times(Sqr(b), PolyLog(C3, Subtract(C1, Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), Times(CI, e)), Subtract(C1, Times(CI, c, x))), CN1)))), Power(Times(C2, e), CN1)), x)), And(FreeQ(List(a, b, c, d, e), x), NeQ(Plus(Times(Sqr(c), Sqr(d)), Sqr(e)), C0))));
            IIntegrate(4860, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT)), C3), Power(Plus(d_, Times(e_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(a, Times(b, ArcTan(Times(c, x)))), C3), Log(Times(C2, Power(Subtract(C1, Times(CI, c, x)), CN1))), Power(e, CN1)), x)), Simp(Times(Power(Plus(a, Times(b, ArcTan(Times(c, x)))), C3), Log(Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), Times(CI, e)), Subtract(C1, Times(CI, c, x))), CN1))), Power(e, CN1)), x), Simp(Times(C3, CI, b, Sqr(Plus(a, Times(b, ArcTan(Times(c, x))))), PolyLog(C2, Subtract(C1, Times(C2, Power(Subtract(C1, Times(CI, c, x)), CN1)))), Power(Times(C2, e), CN1)), x), Negate(Simp(Times(C3, CI, b, Sqr(Plus(a, Times(b, ArcTan(Times(c, x))))), PolyLog(C2, Subtract(C1, Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), Times(CI, e)), Subtract(C1, Times(CI, c, x))), CN1)))), Power(Times(C2, e), CN1)), x)), Negate(Simp(Times(C3, Sqr(b), Plus(a, Times(b, ArcTan(Times(c, x)))), PolyLog(C3, Subtract(C1, Times(C2, Power(Subtract(C1, Times(CI, c, x)), CN1)))), Power(Times(C2, e), CN1)), x)), Simp(Times(C3, Sqr(b), Plus(a, Times(b, ArcTan(Times(c, x)))), PolyLog(C3, Subtract(C1, Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), Times(CI, e)), Subtract(C1, Times(CI, c, x))), CN1)))), Power(Times(C2, e), CN1)), x), Negate(Simp(Times(C3, CI, Power(b, C3), PolyLog(C4, Subtract(C1, Times(C2, Power(Subtract(C1, Times(CI, c, x)), CN1)))), Power(Times(C4, e), CN1)), x)), Simp(Times(C3, CI, Power(b, C3), PolyLog(C4, Subtract(C1, Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), Times(CI, e)), Subtract(C1, Times(CI, c, x))), CN1)))), Power(Times(C4, e), CN1)), x)), And(FreeQ(List(a, b, c, d, e), x), NeQ(Plus(Times(Sqr(c), Sqr(d)), Sqr(e)), C0))));
            IIntegrate(4861, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT)), C3), Power(Plus(d_, Times(e_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(a, Times(b, ArcCot(Times(c, x)))), C3), Log(Times(C2, Power(Subtract(C1, Times(CI, c, x)), CN1))), Power(e, CN1)), x)), Simp(Times(Power(Plus(a, Times(b, ArcCot(Times(c, x)))), C3), Log(Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), Times(CI, e)), Subtract(C1, Times(CI, c, x))), CN1))), Power(e, CN1)), x), Negate(Simp(Times(C3, CI, b, Sqr(Plus(a, Times(b, ArcCot(Times(c, x))))), PolyLog(C2, Subtract(C1, Times(C2, Power(Subtract(C1, Times(CI, c, x)), CN1)))), Power(Times(C2, e), CN1)), x)), Simp(Times(C3, CI, b, Sqr(Plus(a, Times(b, ArcCot(Times(c, x))))), PolyLog(C2, Subtract(C1, Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), Times(CI, e)), Subtract(C1, Times(CI, c, x))), CN1)))), Power(Times(C2, e), CN1)), x), Negate(Simp(Times(C3, Sqr(b), Plus(a, Times(b, ArcCot(Times(c, x)))), PolyLog(C3, Subtract(C1, Times(C2, Power(Subtract(C1, Times(CI, c, x)), CN1)))), Power(Times(C2, e), CN1)), x)), Simp(Times(C3, Sqr(b), Plus(a, Times(b, ArcCot(Times(c, x)))), PolyLog(C3, Subtract(C1, Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), Times(CI, e)), Subtract(C1, Times(CI, c, x))), CN1)))), Power(Times(C2, e), CN1)), x), Simp(Times(C3, CI, Power(b, C3), PolyLog(C4, Subtract(C1, Times(C2, Power(Subtract(C1, Times(CI, c, x)), CN1)))), Power(Times(C4, e), CN1)), x), Negate(Simp(Times(C3, CI, Power(b, C3), PolyLog(C4, Subtract(C1, Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), Times(CI, e)), Subtract(C1, Times(CI, c, x))), CN1)))), Power(Times(C4, e), CN1)), x))), And(FreeQ(List(a, b, c, d, e), x), NeQ(Plus(Times(Sqr(c), Sqr(d)), Sqr(e)), C0))));
            IIntegrate(4862, Int(Times(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT)), Power(Plus(d_, Times(e_DEFAULT, x_)), q_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(d, Times(e, x)), Plus(q, C1)), Plus(a, Times(b, ArcTan(Times(c, x)))), Power(Times(e, Plus(q, C1)), CN1)), x), Dist(Times(b, c, Power(Times(e, Plus(q, C1)), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Plus(q, C1)), Power(Plus(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, q), x), NeQ(q, CN1))));
            IIntegrate(4863, Int(Times(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT)), Power(Plus(d_, Times(e_DEFAULT, x_)), q_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(d, Times(e, x)), Plus(q, C1)), Plus(a, Times(b, ArcCot(Times(c, x)))), Power(Times(e, Plus(q, C1)), CN1)), x), Dist(Times(b, c, Power(Times(e, Plus(q, C1)), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Plus(q, C1)), Power(Plus(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, q), x), NeQ(q, CN1))));
            IIntegrate(4864, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT)), p_), Power(Plus(d_, Times(e_DEFAULT, x_)), q_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(d, Times(e, x)), Plus(q, C1)), Power(Plus(a, Times(b, ArcTan(Times(c, x)))), p), Power(Times(e, Plus(q, C1)), CN1)), x), Dist(Times(b, c, p, Power(Times(e, Plus(q, C1)), CN1)), Int(ExpandIntegrand(Power(Plus(a, Times(b, ArcTan(Times(c, x)))), Subtract(p, C1)), Times(Power(Plus(d, Times(e, x)), Plus(q, C1)), Power(Plus(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x), x)), And(FreeQ(List(a, b, c, d, e), x), IGtQ(p, C1), IntegerQ(q), NeQ(q, CN1))));
            IIntegrate(4865, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT)), p_), Power(Plus(d_, Times(e_DEFAULT, x_)), q_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(d, Times(e, x)), Plus(q, C1)), Power(Plus(a, Times(b, ArcCot(Times(c, x)))), p), Power(Times(e, Plus(q, C1)), CN1)), x), Dist(Times(b, c, p, Power(Times(e, Plus(q, C1)), CN1)), Int(ExpandIntegrand(Power(Plus(a, Times(b, ArcCot(Times(c, x)))), Subtract(p, C1)), Times(Power(Plus(d, Times(e, x)), Plus(q, C1)), Power(Plus(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x), x)), And(FreeQ(List(a, b, c, d, e), x), IGtQ(p, C1), IntegerQ(q), NeQ(q, CN1))));
            IIntegrate(4866, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Times(f, Power(e, CN1)), Int(Times(Power(Times(f, x), Subtract(m, C1)), Power(Plus(a, Times(b, ArcTan(Times(c, x)))), p)), x), x), Dist(Times(d, f, Power(e, CN1)), Int(Times(Power(Times(f, x), Subtract(m, C1)), Power(Plus(a, Times(b, ArcTan(Times(c, x)))), p), Power(Plus(d, Times(e, x)), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(p, C0), EqQ(Plus(Times(Sqr(c), Sqr(d)), Sqr(e)), C0), GtQ(m, C0))));
            IIntegrate(4867, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Times(f, Power(e, CN1)), Int(Times(Power(Times(f, x), Subtract(m, C1)), Power(Plus(a, Times(b, ArcCot(Times(c, x)))), p)), x), x), Dist(Times(d, f, Power(e, CN1)), Int(Times(Power(Times(f, x), Subtract(m, C1)), Power(Plus(a, Times(b, ArcCot(Times(c, x)))), p), Power(Plus(d, Times(e, x)), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(p, C0), EqQ(Plus(Times(Sqr(c), Sqr(d)), Sqr(e)), C0), GtQ(m, C0))));
            IIntegrate(4868, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(x_, CN1), Power(Plus(d_, Times(e_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(a, Times(b, ArcTan(Times(c, x)))), p), Log(Subtract(C2, Times(C2, Power(Plus(C1, Times(e, x, Power(d, CN1))), CN1)))), Power(d, CN1)), x), Dist(Times(b, c, p, Power(d, CN1)), Int(Times(Power(Plus(a, Times(b, ArcTan(Times(c, x)))), Subtract(p, C1)), Log(Subtract(C2, Times(C2, Power(Plus(C1, Times(e, x, Power(d, CN1))), CN1)))), Power(Plus(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), IGtQ(p, C0), EqQ(Plus(Times(Sqr(c), Sqr(d)), Sqr(e)), C0))));
            IIntegrate(4869, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(x_, CN1), Power(Plus(d_, Times(e_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(a, Times(b, ArcCot(Times(c, x)))), p), Log(Subtract(C2, Times(C2, Power(Plus(C1, Times(e, x, Power(d, CN1))), CN1)))), Power(d, CN1)), x), Dist(Times(b, c, p, Power(d, CN1)), Int(Times(Power(Plus(a, Times(b, ArcCot(Times(c, x)))), Subtract(p, C1)), Log(Subtract(C2, Times(C2, Power(Plus(C1, Times(e, x, Power(d, CN1))), CN1)))), Power(Plus(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), IGtQ(p, C0), EqQ(Plus(Times(Sqr(c), Sqr(d)), Sqr(e)), C0))));
            IIntegrate(4870, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Times(f_DEFAULT, x_), m_), Power(Plus(d_, Times(e_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Power(d, CN1), Int(Times(Power(Times(f, x), m), Power(Plus(a, Times(b, ArcTan(Times(c, x)))), p)), x), x), Dist(Times(e, Power(Times(d, f), CN1)), Int(Times(Power(Times(f, x), Plus(m, C1)), Power(Plus(a, Times(b, ArcTan(Times(c, x)))), p), Power(Plus(d, Times(e, x)), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(p, C0), EqQ(Plus(Times(Sqr(c), Sqr(d)), Sqr(e)), C0), LtQ(m, CN1))));
            IIntegrate(4871, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Times(f_DEFAULT, x_), m_), Power(Plus(d_, Times(e_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Power(d, CN1), Int(Times(Power(Times(f, x), m), Power(Plus(a, Times(b, ArcCot(Times(c, x)))), p)), x), x), Dist(Times(e, Power(Times(d, f), CN1)), Int(Times(Power(Times(f, x), Plus(m, C1)), Power(Plus(a, Times(b, ArcCot(Times(c, x)))), p), Power(Plus(d, Times(e, x)), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(p, C0), EqQ(Plus(Times(Sqr(c), Sqr(d)), Sqr(e)), C0), LtQ(m, CN1))));
            IIntegrate(4872, Int(Times(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT)), Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), q_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, x)), q)), x))), Subtract(Dist(Plus(a, Times(b, ArcTan(Times(c, x)))), u, x), Dist(Times(b, c), Int(SimplifyIntegrand(Times(u, Power(Plus(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x), x))), And(FreeQ(List(a, b, c, d, e, f, q), x), NeQ(q, CN1), IntegerQ(Times(C2, m)), Or(And(IGtQ(m, C0), IGtQ(q, C0)), And(ILtQ(Plus(m, q, C1), C0), LtQ(Times(m, q), C0))))));
            IIntegrate(4873, Int(Times(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT)), Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), q_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, x)), q)), x))), Plus(Dist(Plus(a, Times(b, ArcCot(Times(c, x)))), u, x), Dist(Times(b, c), Int(SimplifyIntegrand(Times(u, Power(Plus(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x), x))), And(FreeQ(List(a, b, c, d, e, f, q), x), NeQ(q, CN1), IntegerQ(Times(C2, m)), Or(And(IGtQ(m, C0), IGtQ(q, C0)), And(ILtQ(Plus(m, q, C1), C0), LtQ(Times(m, q), C0))))));
            IIntegrate(4874, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT)), p_), Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), q_)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, x)), q)), x))), Subtract(Dist(Power(Plus(a, Times(b, ArcTan(Times(c, x)))), p), u, x), Dist(Times(b, c, p), Int(ExpandIntegrand(Power(Plus(a, Times(b, ArcTan(Times(c, x)))), Subtract(p, C1)), Times(u, Power(Plus(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x), x))), And(FreeQ(List(a, b, c, d, e, f, q), x), IGtQ(p, C1), EqQ(Plus(Times(Sqr(c), Sqr(d)), Sqr(e)), C0), IntegersQ(m, q), NeQ(m, CN1), NeQ(q, CN1), ILtQ(Plus(m, q, C1), C0), LtQ(Times(m, q), C0))));
            IIntegrate(4875, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT)), p_), Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), q_)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, x)), q)), x))), Plus(Dist(Power(Plus(a, Times(b, ArcCot(Times(c, x)))), p), u, x), Dist(Times(b, c, p), Int(ExpandIntegrand(Power(Plus(a, Times(b, ArcCot(Times(c, x)))), Subtract(p, C1)), Times(u, Power(Plus(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x), x))), And(FreeQ(List(a, b, c, d, e, f, q), x), IGtQ(p, C1), EqQ(Plus(Times(Sqr(c), Sqr(d)), Sqr(e)), C0), IntegersQ(m, q), NeQ(m, CN1), NeQ(q, CN1), ILtQ(Plus(m, q, C1), C0), LtQ(Times(m, q), C0))));
        }
    }
}
