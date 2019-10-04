package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
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
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_;
import static org.matheclipse.core.expression.F.r;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules52 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(1301, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(Plus(Dist(Times(Sqr(e), Power(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), CN1)), Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), q)), x), x), Dist(Power(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), CN1), Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Simp(Subtract(Subtract(Times(c, d), Times(b, e)), Times(c, e, Sqr(x))), x), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, m), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(q)), LtQ(q, CN1))));
            IIntegrate(1302, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(Plus(Dist(Times(Sqr(e), Power(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1)), Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), q)), x), x), Dist(Times(c, Power(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1)), Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Subtract(d, Times(e, Sqr(x))), Power(Plus(a, Times(c, Power(x, C4))), CN1)), x), x)), And(FreeQ(List(a, c, d, e, f, m), x), Not(IntegerQ(q)), LtQ(q, CN1))));
            IIntegrate(1303, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(d, Times(e, Sqr(x))), q), Times(Power(Times(f, x), m), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f, q), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(q)), IntegerQ(m))));
            IIntegrate(1304, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(d, Times(e, Sqr(x))), q), Times(Power(Times(f, x), m), Power(Plus(a, Times(c, Power(x, C4))), CN1)), x), x), And(FreeQ(List(a, c, d, e, f, q), x), Not(IntegerQ(q)), IntegerQ(m))));
            IIntegrate(1305, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), q)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1), x), x), And(FreeQ(List(a, b, c, d, e, f, m, q), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(q)), Not(IntegerQ(m)))));
            IIntegrate(1306, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), q)), Power(Plus(a, Times(c, Power(x, C4))), CN1), x), x), And(FreeQ(List(a, c, d, e, f, m, q), x), Not(IntegerQ(q)), Not(IntegerQ(m)))));
            IIntegrate(1307, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(With(List(Set(r, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Subtract(Dist(Times(C2, c, Power(r, CN1)), Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(b, Negate(r), Times(C2, c, Sqr(x))), CN1)), x), x), Dist(Times(C2, c, Power(r, CN1)), Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(b, r, Times(C2, c, Sqr(x))), CN1)), x), x))), And(FreeQ(List(a, b, c, d, e, f, m, q), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(1308, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(With(List(Set(r, Rt(Times(CN1, a, c), C2))), Subtract(Negate(Dist(Times(c, Power(Times(C2, r), CN1)), Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), q), Power(Subtract(r, Times(c, Sqr(x))), CN1)), x), x)), Dist(Times(c, Power(Times(C2, r), CN1)), Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(r, Times(c, Sqr(x))), CN1)), x), x))), FreeQ(List(a, c, d, e, f, m, q), x)));
            IIntegrate(1309, Int(Times(Power(Times(f_DEFAULT, x_), m_), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Dist(Power(d, CN2), Int(Times(Power(Times(f, x), m), Plus(Times(a, d), Times(Subtract(Times(b, d), Times(a, e)), Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Subtract(p, C1))), x), x), Dist(Times(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), Power(Times(Sqr(d), Power(f, C4)), CN1)), Int(Times(Power(Times(f, x), Plus(m, C4)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Subtract(p, C1)), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), GtQ(p, C0), LtQ(m, CN2))));
            IIntegrate(1310, Int(Times(Power(Times(f_DEFAULT, x_), m_), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Dist(Times(a, Power(d, CN2)), Int(Times(Power(Times(f, x), m), Subtract(d, Times(e, Sqr(x))), Power(Plus(a, Times(c, Power(x, C4))), Subtract(p, C1))), x), x), Dist(Times(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), Power(Times(Sqr(d), Power(f, C4)), CN1)), Int(Times(Power(Times(f, x), Plus(m, C4)), Power(Plus(a, Times(c, Power(x, C4))), Subtract(p, C1)), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, c, d, e, f), x), GtQ(p, C0), LtQ(m, CN2))));
            IIntegrate(1311, Int(Times(Power(Times(f_DEFAULT, x_), m_), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Subtract(Dist(Power(Times(d, e), CN1), Int(Times(Power(Times(f, x), m), Plus(Times(a, e), Times(c, d, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Subtract(p, C1))), x), x), Dist(Times(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), Power(Times(d, e, Sqr(f)), CN1)), Int(Times(Power(Times(f, x), Plus(m, C2)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Subtract(p, C1)), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), GtQ(p, C0), LtQ(m, C0))));
            IIntegrate(1312, Int(Times(Power(Times(f_DEFAULT, x_), m_), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Subtract(Dist(Power(Times(d, e), CN1), Int(Times(Power(Times(f, x), m), Plus(Times(a, e), Times(c, d, Sqr(x))), Power(Plus(a, Times(c, Power(x, C4))), Subtract(p, C1))), x), x), Dist(Times(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), Power(Times(d, e, Sqr(f)), CN1)), Int(Times(Power(Times(f, x), Plus(m, C2)), Power(Plus(a, Times(c, Power(x, C4))), Subtract(p, C1)), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, c, d, e, f), x), GtQ(p, C0), LtQ(m, C0))));
            IIntegrate(1313, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Plus(Negate(Dist(Times(Power(f, C4), Power(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), CN1)), Int(Times(Power(Times(f, x), Subtract(m, C4)), Plus(Times(a, d), Times(Subtract(Times(b, d), Times(a, e)), Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p)), x), x)), Dist(Times(Sqr(d), Power(f, C4), Power(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), CN1)), Int(Times(Power(Times(f, x), Subtract(m, C4)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Plus(p, C1)), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), LtQ(p, CN1), GtQ(m, C2))));
            IIntegrate(1314, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Plus(Negate(Dist(Times(a, Power(f, C4), Power(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1)), Int(Times(Power(Times(f, x), Subtract(m, C4)), Subtract(d, Times(e, Sqr(x))), Power(Plus(a, Times(c, Power(x, C4))), p)), x), x)), Dist(Times(Sqr(d), Power(f, C4), Power(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1)), Int(Times(Power(Times(f, x), Subtract(m, C4)), Power(Plus(a, Times(c, Power(x, C4))), Plus(p, C1)), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, c, d, e, f), x), LtQ(p, CN1), GtQ(m, C2))));
            IIntegrate(1315, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Subtract(Dist(Times(Sqr(f), Power(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), CN1)), Int(Times(Power(Times(f, x), Subtract(m, C2)), Plus(Times(a, e), Times(c, d, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p)), x), x), Dist(Times(d, e, Sqr(f), Power(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), CN1)), Int(Times(Power(Times(f, x), Subtract(m, C2)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Plus(p, C1)), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), LtQ(p, CN1), GtQ(m, C0))));
            IIntegrate(1316, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Subtract(Dist(Times(Sqr(f), Power(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1)), Int(Times(Power(Times(f, x), Subtract(m, C2)), Plus(Times(a, e), Times(c, d, Sqr(x))), Power(Plus(a, Times(c, Power(x, C4))), p)), x), x), Dist(Times(d, e, Sqr(f), Power(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1)), Int(Times(Power(Times(f, x), Subtract(m, C2)), Power(Plus(a, Times(c, Power(x, C4))), Plus(p, C1)), Power(Plus(d, Times(e, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, c, d, e, f), x), LtQ(p, CN1), GtQ(m, C0))));
            IIntegrate(1317, Int(Times(Sqr(x_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(Subtract(Dist(Times(d, Power(Times(C2, d, e), CN1)), Int(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2), x), x), Dist(Times(d, Power(Times(C2, d, e), CN1)), Int(Times(Subtract(d, Times(e, Sqr(x))), Power(Times(Plus(d, Times(e, Sqr(x))), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), PosQ(Times(c, Power(a, CN1))), EqQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0))));
            IIntegrate(1318, Int(Times(Sqr(x_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(Subtract(Dist(Times(d, Power(Times(C2, d, e), CN1)), Int(Power(Plus(a, Times(c, Power(x, C4))), CN1D2), x), x), Dist(Times(d, Power(Times(C2, d, e), CN1)), Int(Times(Subtract(d, Times(e, Sqr(x))), Power(Times(Plus(d, Times(e, Sqr(x))), Sqrt(Plus(a, Times(c, Power(x, C4))))), CN1)), x), x)), And(FreeQ(List(a, c, d, e), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), PosQ(Times(c, Power(a, CN1))), EqQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0))));
            IIntegrate(1319, Int(Times(Sqr(x_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(c, Power(a, CN1)), C2))), Plus(Negate(Dist(Times(a, Plus(e, Times(d, q)), Power(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1)), Int(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2), x), x)), Dist(Times(a, d, Plus(e, Times(d, q)), Power(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1)), Int(Times(Plus(C1, Times(q, Sqr(x))), Power(Times(Plus(d, Times(e, Sqr(x))), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1)), x), x))), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), PosQ(Times(c, Power(a, CN1))), NeQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0))));
            IIntegrate(1320, Int(Times(Sqr(x_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(c, Power(a, CN1)), C2))), Plus(Negate(Dist(Times(a, Plus(e, Times(d, q)), Power(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1)), Int(Power(Plus(a, Times(c, Power(x, C4))), CN1D2), x), x)), Dist(Times(a, d, Plus(e, Times(d, q)), Power(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1)), Int(Times(Plus(C1, Times(q, Sqr(x))), Power(Times(Plus(d, Times(e, Sqr(x))), Sqrt(Plus(a, Times(c, Power(x, C4))))), CN1)), x), x))), And(FreeQ(List(a, c, d, e), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), PosQ(Times(c, Power(a, CN1))), NeQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0))));
            IIntegrate(1321, Int(Times(Power(x_, C4), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(Plus(Negate(Dist(Power(e, CN2), Int(Times(Subtract(d, Times(e, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2)), x), x)), Dist(Times(Sqr(d), Power(e, CN2)), Int(Power(Times(Plus(d, Times(e, Sqr(x))), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1), x), x)), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), PosQ(Times(c, Power(a, CN1))), EqQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0))));
            IIntegrate(1322, Int(Times(Power(x_, C4), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(Plus(Negate(Dist(Power(e, CN2), Int(Times(Subtract(d, Times(e, Sqr(x))), Power(Plus(a, Times(c, Power(x, C4))), CN1D2)), x), x)), Dist(Times(Sqr(d), Power(e, CN2)), Int(Power(Times(Plus(d, Times(e, Sqr(x))), Sqrt(Plus(a, Times(c, Power(x, C4))))), CN1), x), x)), And(FreeQ(List(a, c, d, e), x), PosQ(Times(c, Power(a, CN1))), EqQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0))));
            IIntegrate(1323, Int(Times(Power(x_, C4), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(c, Power(a, CN1)), C2))), Condition(Plus(Negate(Dist(Power(Times(e, q), CN1), Int(Times(Subtract(C1, Times(q, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2)), x), x)), Dist(Times(Sqr(d), Power(Times(e, Subtract(e, Times(d, q))), CN1)), Int(Times(Plus(C1, Times(q, Sqr(x))), Power(Times(Plus(d, Times(e, Sqr(x))), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1)), x), x)), EqQ(Subtract(Times(C2, c, d), Times(a, e, q)), C0))), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), PosQ(Times(c, Power(a, CN1))), NeQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0))));
            IIntegrate(1324, Int(Times(Power(x_, C4), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(c, Power(a, CN1)), C2))), Condition(Plus(Negate(Dist(Power(Times(e, q), CN1), Int(Times(Subtract(C1, Times(q, Sqr(x))), Power(Plus(a, Times(c, Power(x, C4))), CN1D2)), x), x)), Dist(Times(Sqr(d), Power(Times(e, Subtract(e, Times(d, q))), CN1)), Int(Times(Plus(C1, Times(q, Sqr(x))), Power(Times(Plus(d, Times(e, Sqr(x))), Sqrt(Plus(a, Times(c, Power(x, C4))))), CN1)), x), x)), EqQ(Subtract(Times(C2, c, d), Times(a, e, q)), C0))), And(FreeQ(List(a, c, d, e), x), PosQ(Times(c, Power(a, CN1))), NeQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0))));
            IIntegrate(1325, Int(Times(Power(x_, C4), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(c, Power(a, CN1)), C2))), Plus(Negate(Dist(Times(Subtract(Times(C2, c, d), Times(a, e, q)), Power(Times(c, e, Subtract(e, Times(d, q))), CN1)), Int(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2), x), x)), Negate(Dist(Power(Times(e, q), CN1), Int(Times(Subtract(C1, Times(q, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2)), x), x)), Dist(Times(Sqr(d), Power(Times(e, Subtract(e, Times(d, q))), CN1)), Int(Times(Plus(C1, Times(q, Sqr(x))), Power(Times(Plus(d, Times(e, Sqr(x))), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1)), x), x))), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), PosQ(Times(c, Power(a, CN1))), NeQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0))));
        }
    }
}
