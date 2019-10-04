package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcCoth;
import static org.matheclipse.core.expression.F.ArcTanh;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.QQ;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules239 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(5976, Int(Times(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Power(Plus(d, Times(e, Sqr(x))), q), x))), Subtract(Dist(Plus(a, Times(b, ArcTanh(Times(c, x)))), u, x), Dist(Times(b, c), Int(Times(u, Power(Subtract(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x))), And(FreeQ(List(a, b, c, d, e), x), Or(IntegerQ(q), ILtQ(Plus(q, C1D2), C0)))));
            IIntegrate(5977, Int(Times(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Power(Plus(d, Times(e, Sqr(x))), q), x))), Subtract(Dist(Plus(a, Times(b, ArcCoth(Times(c, x)))), u, x), Dist(Times(b, c), Int(Times(u, Power(Subtract(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x))), And(FreeQ(List(a, b, c, d, e), x), Or(IntegerQ(q), ILtQ(Plus(q, C1D2), C0)))));
            IIntegrate(5978, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), p), Power(Plus(d, Times(e, Sqr(x))), q), x), x), And(FreeQ(List(a, b, c, d, e), x), IntegerQ(q), IGtQ(p, C0))));
            IIntegrate(5979, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p), Power(Plus(d, Times(e, Sqr(x))), q), x), x), And(FreeQ(List(a, b, c, d, e), x), IntegerQ(q), IGtQ(p, C0))));
            IIntegrate(5980, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Times(f_DEFAULT, x_), m_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Times(Sqr(f), Power(e, CN1)), Int(Times(Power(Times(f, x), Subtract(m, C2)), Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), p)), x), x), Dist(Times(d, Sqr(f), Power(e, CN1)), Int(Times(Power(Times(f, x), Subtract(m, C2)), Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), p), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), GtQ(p, C0), GtQ(m, C1))));
            IIntegrate(5981, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Times(f_DEFAULT, x_), m_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Times(Sqr(f), Power(e, CN1)), Int(Times(Power(Times(f, x), Subtract(m, C2)), Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p)), x), x), Dist(Times(d, Sqr(f), Power(e, CN1)), Int(Times(Power(Times(f, x), Subtract(m, C2)), Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), GtQ(p, C0), GtQ(m, C1))));
            IIntegrate(5982, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Times(f_DEFAULT, x_), m_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Power(d, CN1), Int(Times(Power(Times(f, x), m), Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), p)), x), x), Dist(Times(e, Power(Times(d, Sqr(f)), CN1)), Int(Times(Power(Times(f, x), Plus(m, C2)), Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), p), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), GtQ(p, C0), LtQ(m, CN1))));
            IIntegrate(5983, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Times(f_DEFAULT, x_), m_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Power(d, CN1), Int(Times(Power(Times(f, x), m), Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p)), x), x), Dist(Times(e, Power(Times(d, Sqr(f)), CN1)), Int(Times(Power(Times(f, x), Plus(m, C2)), Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), GtQ(p, C0), LtQ(m, CN1))));
            IIntegrate(5984, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), x_, Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), Plus(p, C1)), Power(Times(b, e, Plus(p, C1)), CN1)), x), Dist(Power(Times(c, d), CN1), Int(Times(Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), p), Power(Subtract(C1, Times(c, x)), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), IGtQ(p, C0))));
            IIntegrate(5985, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), x_, Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), Plus(p, C1)), Power(Times(b, e, Plus(p, C1)), CN1)), x), Dist(Power(Times(c, d), CN1), Int(Times(Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p), Power(Subtract(C1, Times(c, x)), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), IGtQ(p, C0))));
            IIntegrate(5986, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), p_), x_, Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(x, Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), Plus(p, C1)), Power(Times(b, c, d, Plus(p, C1)), CN1)), x), Dist(Power(Times(b, c, d, Plus(p, C1)), CN1), Int(Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), Plus(p, C1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), Not(IGtQ(p, C0)), NeQ(p, CN1))));
            IIntegrate(5987, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), p_), x_, Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Subtract(Negate(Simp(Times(x, Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), Plus(p, C1)), Power(Times(b, c, d, Plus(p, C1)), CN1)), x)), Dist(Power(Times(b, c, d, Plus(p, C1)), CN1), Int(Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), Plus(p, C1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), Not(IGtQ(p, C0)), NeQ(p, CN1))));
            IIntegrate(5988, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(x_, CN1), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), Plus(p, C1)), Power(Times(b, d, Plus(p, C1)), CN1)), x), Dist(Power(d, CN1), Int(Times(Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), p), Power(Times(x, Plus(C1, Times(c, x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), GtQ(p, C0))));
            IIntegrate(5989, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(x_, CN1), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), Plus(p, C1)), Power(Times(b, d, Plus(p, C1)), CN1)), x), Dist(Power(d, CN1), Int(Times(Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p), Power(Times(x, Plus(C1, Times(c, x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), GtQ(p, C0))));
            IIntegrate(5990, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), p_), Power(Times(f_DEFAULT, x_), m_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(f, x), m), Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), Plus(p, C1)), Power(Times(b, c, d, Plus(p, C1)), CN1)), x), Dist(Times(f, m, Power(Times(b, c, d, Plus(p, C1)), CN1)), Int(Times(Power(Times(f, x), Subtract(m, C1)), Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f, m), x), EqQ(Plus(Times(Sqr(c), d), e), C0), LtQ(p, CN1))));
            IIntegrate(5991, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), p_), Power(Times(f_DEFAULT, x_), m_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(f, x), m), Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), Plus(p, C1)), Power(Times(b, c, d, Plus(p, C1)), CN1)), x), Dist(Times(f, m, Power(Times(b, c, d, Plus(p, C1)), CN1)), Int(Times(Power(Times(f, x), Subtract(m, C1)), Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f, m), x), EqQ(Plus(Times(Sqr(c), d), e), C0), LtQ(p, CN1))));
            IIntegrate(5992, Int(Times(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), Power(x_, m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Plus(a, Times(b, ArcTanh(Times(c, x)))), Times(Power(x, m), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x), And(FreeQ(List(a, b, c, d, e), x), IntegerQ(m), Not(And(EqQ(m, C1), NeQ(a, C0))))));
            IIntegrate(5993, Int(Times(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), Power(x_, m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Plus(a, Times(b, ArcCoth(Times(c, x)))), Times(Power(x, m), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x), And(FreeQ(List(a, b, c, d, e), x), IntegerQ(m), Not(And(EqQ(m, C1), NeQ(a, C0))))));
            IIntegrate(5994, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), x_, Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), p), Power(Times(C2, e, Plus(q, C1)), CN1)), x), Dist(Times(b, p, Power(Times(C2, c, Plus(q, C1)), CN1)), Int(Times(Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), Subtract(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, q), x), EqQ(Plus(Times(Sqr(c), d), e), C0), GtQ(p, C0), NeQ(q, CN1))));
            IIntegrate(5995, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), x_, Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p), Power(Times(C2, e, Plus(q, C1)), CN1)), x), Dist(Times(b, p, Power(Times(C2, c, Plus(q, C1)), CN1)), Int(Times(Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), Subtract(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, q), x), EqQ(Plus(Times(Sqr(c), d), e), C0), GtQ(p, C0), NeQ(q, CN1))));
            IIntegrate(5996, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), p_), x_, Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN2)), x_Symbol),
                    Condition(Plus(Simp(Times(x, Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), Plus(p, C1)), Power(Times(b, c, d, Plus(p, C1), Plus(d, Times(e, Sqr(x)))), CN1)), x), Dist(Times(C4, Power(Times(Sqr(b), Plus(p, C1), Plus(p, C2)), CN1)), Int(Times(x, Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), Plus(p, C2)), Power(Plus(d, Times(e, Sqr(x))), CN2)), x), x), Simp(Times(Plus(C1, Times(Sqr(c), Sqr(x))), Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), Plus(p, C2)), Power(Times(Sqr(b), e, Plus(p, C1), Plus(p, C2), Plus(d, Times(e, Sqr(x)))), CN1)), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), LtQ(p, CN1), NeQ(p, CN2))));
            IIntegrate(5997, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), p_), x_, Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN2)), x_Symbol),
                    Condition(Plus(Simp(Times(x, Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), Plus(p, C1)), Power(Times(b, c, d, Plus(p, C1), Plus(d, Times(e, Sqr(x)))), CN1)), x), Dist(Times(C4, Power(Times(Sqr(b), Plus(p, C1), Plus(p, C2)), CN1)), Int(Times(x, Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), Plus(p, C2)), Power(Plus(d, Times(e, Sqr(x))), CN2)), x), x), Simp(Times(Plus(C1, Times(Sqr(c), Sqr(x))), Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), Plus(p, C2)), Power(Times(Sqr(b), e, Plus(p, C1), Plus(p, C2), Plus(d, Times(e, Sqr(x)))), CN1)), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), LtQ(p, CN1), NeQ(p, CN2))));
            IIntegrate(5998, Int(Times(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), Sqr(x_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Power(Times(C4, Power(c, C3), d, Sqr(Plus(q, C1))), CN1)), x)), Dist(Power(Times(C2, Sqr(c), d, Plus(q, C1)), CN1), Int(Times(Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Plus(a, Times(b, ArcTanh(Times(c, x))))), x), x), Negate(Simp(Times(x, Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Plus(a, Times(b, ArcTanh(Times(c, x)))), Power(Times(C2, Sqr(c), d, Plus(q, C1)), CN1)), x))), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), LtQ(q, CN1), NeQ(q, QQ(-5L, 2L)))));
            IIntegrate(5999, Int(Times(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), Sqr(x_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Power(Times(C4, Power(c, C3), d, Sqr(Plus(q, C1))), CN1)), x)), Dist(Power(Times(C2, Sqr(c), d, Plus(q, C1)), CN1), Int(Times(Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Plus(a, Times(b, ArcCoth(Times(c, x))))), x), x), Negate(Simp(Times(x, Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Plus(a, Times(b, ArcCoth(Times(c, x)))), Power(Times(C2, Sqr(c), d, Plus(q, C1)), CN1)), x))), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), LtQ(q, CN1), NeQ(q, QQ(-5L, 2L)))));
            IIntegrate(6000, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Sqr(x_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN2)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), Plus(p, C1)), Power(Times(C2, b, Power(c, C3), Sqr(d), Plus(p, C1)), CN1)), x)), Negate(Dist(Times(b, p, Power(Times(C2, c), CN1)), Int(Times(x, Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), Subtract(p, C1)), Power(Plus(d, Times(e, Sqr(x))), CN2)), x), x)), Simp(Times(x, Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), p), Power(Times(C2, Sqr(c), d, Plus(d, Times(e, Sqr(x)))), CN1)), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), GtQ(p, C0))));
        }
    }
}
