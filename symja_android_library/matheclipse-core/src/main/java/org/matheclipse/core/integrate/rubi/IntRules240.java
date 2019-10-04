package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcCoth;
import static org.matheclipse.core.expression.F.ArcTanh;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Csch;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.PolyLog;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sech;
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
import static org.matheclipse.core.expression.F.d_;
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
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules240 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(6001, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Sqr(x_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN2)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), Plus(p, C1)), Power(Times(C2, b, Power(c, C3), Sqr(d), Plus(p, C1)), CN1)), x)), Negate(Dist(Times(b, p, Power(Times(C2, c), CN1)), Int(Times(x, Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), Subtract(p, C1)), Power(Plus(d, Times(e, Sqr(x))), CN2)), x), x)), Simp(Times(x, Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p), Power(Times(C2, Sqr(c), d, Plus(d, Times(e, Sqr(x)))), CN1)), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), GtQ(p, C0))));
            IIntegrate(6002, Int(Times(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), Power(Times(f_DEFAULT, x_), m_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Power(Times(c, d, Sqr(m)), CN1)), x)), Negate(Dist(Times(Sqr(f), Subtract(m, C1), Power(Times(Sqr(c), d, m), CN1)), Int(Times(Power(Times(f, x), Subtract(m, C2)), Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Plus(a, Times(b, ArcTanh(Times(c, x))))), x), x)), Simp(Times(f, Power(Times(f, x), Subtract(m, C1)), Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Plus(a, Times(b, ArcTanh(Times(c, x)))), Power(Times(Sqr(c), d, m), CN1)), x)), And(FreeQ(List(a, b, c, d, e, f), x), EqQ(Plus(Times(Sqr(c), d), e), C0), EqQ(Plus(m, Times(C2, q), C2), C0), LtQ(q, CN1))));
            IIntegrate(6003, Int(Times(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), Power(Times(f_DEFAULT, x_), m_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Power(Times(c, d, Sqr(m)), CN1)), x)), Negate(Dist(Times(Sqr(f), Subtract(m, C1), Power(Times(Sqr(c), d, m), CN1)), Int(Times(Power(Times(f, x), Subtract(m, C2)), Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Plus(a, Times(b, ArcCoth(Times(c, x))))), x), x)), Simp(Times(f, Power(Times(f, x), Subtract(m, C1)), Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Plus(a, Times(b, ArcCoth(Times(c, x)))), Power(Times(Sqr(c), d, m), CN1)), x)), And(FreeQ(List(a, b, c, d, e, f), x), EqQ(Plus(Times(Sqr(c), d), e), C0), EqQ(Plus(m, Times(C2, q), C2), C0), LtQ(q, CN1))));
            IIntegrate(6004, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), p_), Power(Times(f_DEFAULT, x_), m_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, p, Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), Subtract(p, C1)), Power(Times(c, d, Sqr(m)), CN1)), x)), Negate(Dist(Times(Sqr(f), Subtract(m, C1), Power(Times(Sqr(c), d, m), CN1)), Int(Times(Power(Times(f, x), Subtract(m, C2)), Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), p)), x), x)), Dist(Times(Sqr(b), p, Subtract(p, C1), Power(m, CN2)), Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), Subtract(p, C2))), x), x), Simp(Times(f, Power(Times(f, x), Subtract(m, C1)), Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), p), Power(Times(Sqr(c), d, m), CN1)), x)), And(FreeQ(List(a, b, c, d, e, f, m), x), EqQ(Plus(Times(Sqr(c), d), e), C0), EqQ(Plus(m, Times(C2, q), C2), C0), LtQ(q, CN1), GtQ(p, C1))));
            IIntegrate(6005, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), p_), Power(Times(f_DEFAULT, x_), m_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, p, Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), Subtract(p, C1)), Power(Times(c, d, Sqr(m)), CN1)), x)), Negate(Dist(Times(Sqr(f), Subtract(m, C1), Power(Times(Sqr(c), d, m), CN1)), Int(Times(Power(Times(f, x), Subtract(m, C2)), Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p)), x), x)), Dist(Times(Sqr(b), p, Subtract(p, C1), Power(m, CN2)), Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), Subtract(p, C2))), x), x), Simp(Times(f, Power(Times(f, x), Subtract(m, C1)), Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p), Power(Times(Sqr(c), d, m), CN1)), x)), And(FreeQ(List(a, b, c, d, e, f, m), x), EqQ(Plus(Times(Sqr(c), d), e), C0), EqQ(Plus(m, Times(C2, q), C2), C0), LtQ(q, CN1), GtQ(p, C1))));
            IIntegrate(6006, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), p_), Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), Plus(p, C1)), Power(Times(b, c, d, Plus(p, C1)), CN1)), x), Dist(Times(f, m, Power(Times(b, c, Plus(p, C1)), CN1)), Int(Times(Power(Times(f, x), Subtract(m, C1)), Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f, m, q), x), EqQ(Plus(Times(Sqr(c), d), e), C0), EqQ(Plus(m, Times(C2, q), C2), C0), LtQ(p, CN1))));
            IIntegrate(6007, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), p_), Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), Plus(p, C1)), Power(Times(b, c, d, Plus(p, C1)), CN1)), x), Dist(Times(f, m, Power(Times(b, c, Plus(p, C1)), CN1)), Int(Times(Power(Times(f, x), Subtract(m, C1)), Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f, m, q), x), EqQ(Plus(Times(Sqr(c), d), e), C0), EqQ(Plus(m, Times(C2, q), C2), C0), LtQ(p, CN1))));
            IIntegrate(6008, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(f, x), Plus(m, C1)), Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), p), Power(Times(d, Plus(m, C1)), CN1)), x), Dist(Times(b, c, p, Power(Plus(m, C1), CN1)), Int(Times(Power(Times(f, x), Plus(m, C1)), Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), Subtract(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f, m, q), x), EqQ(Plus(Times(Sqr(c), d), e), C0), EqQ(Plus(m, Times(C2, q), C3), C0), GtQ(p, C0), NeQ(m, CN1))));
            IIntegrate(6009, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(f, x), Plus(m, C1)), Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p), Power(Times(d, f, Plus(m, C1)), CN1)), x), Dist(Times(b, c, p, Power(Times(f, Plus(m, C1)), CN1)), Int(Times(Power(Times(f, x), Plus(m, C1)), Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), Subtract(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f, m, q), x), EqQ(Plus(Times(Sqr(c), d), e), C0), EqQ(Plus(m, Times(C2, q), C3), C0), GtQ(p, C0), NeQ(m, CN1))));
            IIntegrate(6010, Int(Times(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), Power(Times(f_DEFAULT, x_), m_), Sqrt(Plus(d_, Times(e_DEFAULT, Sqr(x_))))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(f, x), Plus(m, C1)), Sqrt(Plus(d, Times(e, Sqr(x)))), Plus(a, Times(b, ArcTanh(Times(c, x)))), Power(Times(f, Plus(m, C2)), CN1)), x), Dist(Times(d, Power(Plus(m, C2), CN1)), Int(Times(Power(Times(f, x), m), Plus(a, Times(b, ArcTanh(Times(c, x)))), Power(Plus(d, Times(e, Sqr(x))), CN1D2)), x), x), Negate(Dist(Times(b, c, d, Power(Times(f, Plus(m, C2)), CN1)), Int(Times(Power(Times(f, x), Plus(m, C1)), Power(Plus(d, Times(e, Sqr(x))), CN1D2)), x), x))), And(FreeQ(List(a, b, c, d, e, f, m), x), EqQ(Plus(Times(Sqr(c), d), e), C0), NeQ(m, CN2))));
            IIntegrate(6011, Int(Times(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), Power(Times(f_DEFAULT, x_), m_), Sqrt(Plus(d_, Times(e_DEFAULT, Sqr(x_))))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(f, x), Plus(m, C1)), Sqrt(Plus(d, Times(e, Sqr(x)))), Plus(a, Times(b, ArcCoth(Times(c, x)))), Power(Times(f, Plus(m, C2)), CN1)), x), Dist(Times(d, Power(Plus(m, C2), CN1)), Int(Times(Power(Times(f, x), m), Plus(a, Times(b, ArcCoth(Times(c, x)))), Power(Plus(d, Times(e, Sqr(x))), CN1D2)), x), x), Negate(Dist(Times(b, c, d, Power(Times(f, Plus(m, C2)), CN1)), Int(Times(Power(Times(f, x), Plus(m, C1)), Power(Plus(d, Times(e, Sqr(x))), CN1D2)), x), x))), And(FreeQ(List(a, b, c, d, e, f, m), x), EqQ(Plus(Times(Sqr(c), d), e), C0), NeQ(m, CN2))));
            IIntegrate(6012, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Times(f_DEFAULT, x_), m_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), p)), x), x), And(FreeQ(List(a, b, c, d, e, f, m), x), EqQ(Plus(Times(Sqr(c), d), e), C0), IGtQ(p, C0), IGtQ(q, C1))));
            IIntegrate(6013, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Times(f_DEFAULT, x_), m_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p)), x), x), And(FreeQ(List(a, b, c, d, e, f, m), x), EqQ(Plus(Times(Sqr(c), d), e), C0), IGtQ(p, C0), IGtQ(q, C1))));
            IIntegrate(6014, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Times(f_DEFAULT, x_), m_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT)), x_Symbol),
                    Condition(Subtract(Dist(d, Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), Subtract(q, C1)), Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), p)), x), x), Dist(Times(Sqr(c), d, Power(f, CN2)), Int(Times(Power(Times(f, x), Plus(m, C2)), Power(Plus(d, Times(e, Sqr(x))), Subtract(q, C1)), Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), p)), x), x)), And(FreeQ(List(a, b, c, d, e, f, m), x), EqQ(Plus(Times(Sqr(c), d), e), C0), GtQ(q, C0), IGtQ(p, C0), Or(RationalQ(m), And(EqQ(p, C1), IntegerQ(q))))));
            IIntegrate(6015, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Times(f_DEFAULT, x_), m_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT)), x_Symbol),
                    Condition(Subtract(Dist(d, Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), Subtract(q, C1)), Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p)), x), x), Dist(Times(Sqr(c), d, Power(f, CN2)), Int(Times(Power(Times(f, x), Plus(m, C2)), Power(Plus(d, Times(e, Sqr(x))), Subtract(q, C1)), Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p)), x), x)), And(FreeQ(List(a, b, c, d, e, f, m), x), EqQ(Plus(Times(Sqr(c), d), e), C0), GtQ(q, C0), IGtQ(p, C0), Or(RationalQ(m), And(EqQ(p, C1), IntegerQ(q))))));
            IIntegrate(6016, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Times(f_DEFAULT, x_), m_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(f, Power(Times(f, x), Subtract(m, C1)), Sqrt(Plus(d, Times(e, Sqr(x)))), Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), p), Power(Times(Sqr(c), d, m), CN1)), x)), Dist(Times(b, f, p, Power(Times(c, m), CN1)), Int(Times(Power(Times(f, x), Subtract(m, C1)), Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), Subtract(p, C1)), Power(Plus(d, Times(e, Sqr(x))), CN1D2)), x), x), Dist(Times(Sqr(f), Subtract(m, C1), Power(Times(Sqr(c), m), CN1)), Int(Times(Power(Times(f, x), Subtract(m, C2)), Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), p), Power(Plus(d, Times(e, Sqr(x))), CN1D2)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), EqQ(Plus(Times(Sqr(c), d), e), C0), GtQ(p, C0), GtQ(m, C1))));
            IIntegrate(6017, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Times(f_DEFAULT, x_), m_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(f, Power(Times(f, x), Subtract(m, C1)), Sqrt(Plus(d, Times(e, Sqr(x)))), Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p), Power(Times(Sqr(c), d, m), CN1)), x)), Dist(Times(b, f, p, Power(Times(c, m), CN1)), Int(Times(Power(Times(f, x), Subtract(m, C1)), Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), Subtract(p, C1)), Power(Plus(d, Times(e, Sqr(x))), CN1D2)), x), x), Dist(Times(Sqr(f), Subtract(m, C1), Power(Times(Sqr(c), m), CN1)), Int(Times(Power(Times(f, x), Subtract(m, C2)), Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p), Power(Plus(d, Times(e, Sqr(x))), CN1D2)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), EqQ(Plus(Times(Sqr(c), d), e), C0), GtQ(p, C0), GtQ(m, C1))));
            IIntegrate(6018, Int(Times(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), Power(x_, CN1), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Plus(Simp(Times(CN2, Plus(a, Times(b, ArcTanh(Times(c, x)))), ArcTanh(Times(Sqrt(Subtract(C1, Times(c, x))), Power(Plus(C1, Times(c, x)), CN1D2))), Power(d, CN1D2)), x), Simp(Times(b, PolyLog(C2, Times(CN1, Sqrt(Subtract(C1, Times(c, x))), Power(Plus(C1, Times(c, x)), CN1D2))), Power(d, CN1D2)), x), Negate(Simp(Times(b, PolyLog(C2, Times(Sqrt(Subtract(C1, Times(c, x))), Power(Plus(C1, Times(c, x)), CN1D2))), Power(d, CN1D2)), x))), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), GtQ(d, C0))));
            IIntegrate(6019, Int(Times(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), Power(x_, CN1), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Plus(Simp(Times(CN2, Plus(a, Times(b, ArcCoth(Times(c, x)))), ArcTanh(Times(Sqrt(Subtract(C1, Times(c, x))), Power(Plus(C1, Times(c, x)), CN1D2))), Power(d, CN1D2)), x), Simp(Times(b, PolyLog(C2, Times(CN1, Sqrt(Subtract(C1, Times(c, x))), Power(Plus(C1, Times(c, x)), CN1D2))), Power(d, CN1D2)), x), Negate(Simp(Times(b, PolyLog(C2, Times(Sqrt(Subtract(C1, Times(c, x))), Power(Plus(C1, Times(c, x)), CN1D2))), Power(d, CN1D2)), x))), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), GtQ(d, C0))));
            IIntegrate(6020, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), p_), Power(x_, CN1), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(Power(d, CN1D2), Subst(Int(Times(Power(Plus(a, Times(b, x)), p), Csch(x)), x), x, ArcTanh(Times(c, x))), x), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), IGtQ(p, C0), GtQ(d, C0))));
            IIntegrate(6021, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), p_), Power(x_, CN1), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Negate(Dist(Times(c, x, Sqrt(Subtract(C1, Power(Times(Sqr(c), Sqr(x)), CN1))), Power(Plus(d, Times(e, Sqr(x))), CN1D2)), Subst(Int(Times(Power(Plus(a, Times(b, x)), p), Sech(x)), x), x, ArcCoth(Times(c, x))), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), IGtQ(p, C0), GtQ(d, C0))));
            IIntegrate(6022, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(x_, CN1), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Subtract(C1, Times(Sqr(c), Sqr(x)))), Power(Plus(d, Times(e, Sqr(x))), CN1D2)), Int(Times(Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), p), Power(Times(x, Sqrt(Subtract(C1, Times(Sqr(c), Sqr(x))))), CN1)), x), x), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), IGtQ(p, C0), Not(GtQ(d, C0)))));
            IIntegrate(6023, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(x_, CN1), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Subtract(C1, Times(Sqr(c), Sqr(x)))), Power(Plus(d, Times(e, Sqr(x))), CN1D2)), Int(Times(Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p), Power(Times(x, Sqrt(Subtract(C1, Times(Sqr(c), Sqr(x))))), CN1)), x), x), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), IGtQ(p, C0), Not(GtQ(d, C0)))));
            IIntegrate(6024, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(x_, CN2), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Sqrt(Plus(d, Times(e, Sqr(x)))), Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), p), Power(Times(d, x), CN1)), x)), Dist(Times(b, c, p), Int(Times(Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), Subtract(p, C1)), Power(Times(x, Sqrt(Plus(d, Times(e, Sqr(x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), GtQ(p, C0))));
            IIntegrate(6025, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(x_, CN2), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Sqrt(Plus(d, Times(e, Sqr(x)))), Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p), Power(Times(d, x), CN1)), x)), Dist(Times(b, c, p), Int(Times(Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), Subtract(p, C1)), Power(Times(x, Sqrt(Plus(d, Times(e, Sqr(x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), GtQ(p, C0))));
        }
    }
}
