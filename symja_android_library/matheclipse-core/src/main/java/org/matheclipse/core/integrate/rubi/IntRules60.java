package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
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
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
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
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.r;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules60 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(1501, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Plus(d_, Times(e_DEFAULT, Power(x_, n_))), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2")))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Times(f, x), Plus(m, C1)), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), Plus(p, C1)), Plus(d, Times(e, Power(x, n))), Power(Times(C2, a, f, n, Plus(p, C1)), CN1)), x)), Dist(Power(Times(C2, a, n, Plus(p, C1)), CN1), Int(Times(Power(Times(f, x), m), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), Plus(p, C1)), Simp(Plus(Times(d, Plus(m, Times(C2, n, Plus(p, C1)), C1)), Times(e, Plus(m, Times(n, Plus(Times(C2, p), C3)), C1), Power(x, n))), x)), x), x)), And(FreeQ(List(a, c, d, e, f, m), x), EqQ($s("n2"), Times(C2, n)), IGtQ(n, C0), LtQ(p, CN1), IntegerQ(p))));
            IIntegrate(1502, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Plus(d_, Times(e_DEFAULT, Power(x_, n_))), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_)), Times(c_DEFAULT, Power(x_, $p("n2")))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(e, Power(f, Subtract(n, C1)), Power(Times(f, x), Plus(m, Negate(n), C1)), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), Plus(p, C1)), Power(Times(c, Plus(m, Times(n, Plus(Times(C2, p), C1)), C1)), CN1)), x), Dist(Times(Power(f, n), Power(Times(c, Plus(m, Times(n, Plus(Times(C2, p), C1)), C1)), CN1)), Int(Times(Power(Times(f, x), Subtract(m, n)), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p), Simp(Plus(Times(a, e, Plus(m, Negate(n), C1)), Times(Subtract(Times(b, e, Plus(m, Times(n, p), C1)), Times(c, d, Plus(m, Times(n, Plus(Times(C2, p), C1)), C1))), Power(x, n))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, p), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0), GtQ(m, Subtract(n, C1)), NeQ(Plus(m, Times(n, Plus(Times(C2, p), C1)), C1), C0), IntegerQ(p))));
            IIntegrate(1503, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Plus(d_, Times(e_DEFAULT, Power(x_, n_))), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2")))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(e, Power(f, Subtract(n, C1)), Power(Times(f, x), Plus(m, Negate(n), C1)), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), Plus(p, C1)), Power(Times(c, Plus(m, Times(n, Plus(Times(C2, p), C1)), C1)), CN1)), x), Dist(Times(Power(f, n), Power(Times(c, Plus(m, Times(n, Plus(Times(C2, p), C1)), C1)), CN1)), Int(Times(Power(Times(f, x), Subtract(m, n)), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), p), Subtract(Times(a, e, Plus(m, Negate(n), C1)), Times(c, d, Plus(m, Times(n, Plus(Times(C2, p), C1)), C1), Power(x, n)))), x), x)), And(FreeQ(List(a, c, d, e, f, p), x), EqQ($s("n2"), Times(C2, n)), IGtQ(n, C0), GtQ(m, Subtract(n, C1)), NeQ(Plus(m, Times(n, Plus(Times(C2, p), C1)), C1), C0), IntegerQ(p))));
            IIntegrate(1504, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Plus(d_, Times(e_DEFAULT, Power(x_, n_))), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_)), Times(c_DEFAULT, Power(x_, $p("n2")))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(d, Power(Times(f, x), Plus(m, C1)), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), Plus(p, C1)), Power(Times(a, f, Plus(m, C1)), CN1)), x), Dist(Power(Times(a, Power(f, n), Plus(m, C1)), CN1), Int(Times(Power(Times(f, x), Plus(m, n)), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p), Simp(Subtract(Subtract(Times(a, e, Plus(m, C1)), Times(b, d, Plus(m, Times(n, Plus(p, C1)), C1))), Times(c, d, Plus(m, Times(C2, n, Plus(p, C1)), C1), Power(x, n))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, p), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0), LtQ(m, CN1), IntegerQ(p))));
            IIntegrate(1505, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Plus(d_, Times(e_DEFAULT, Power(x_, n_))), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2")))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(d, Power(Times(f, x), Plus(m, C1)), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), Plus(p, C1)), Power(Times(a, f, Plus(m, C1)), CN1)), x), Dist(Power(Times(a, Power(f, n), Plus(m, C1)), CN1), Int(Times(Power(Times(f, x), Plus(m, n)), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), p), Subtract(Times(a, e, Plus(m, C1)), Times(c, d, Plus(m, Times(C2, n, Plus(p, C1)), C1), Power(x, n)))), x), x)), And(FreeQ(List(a, c, d, e, f, p), x), EqQ($s("n2"), Times(C2, n)), IGtQ(n, C0), LtQ(m, CN1), IntegerQ(p))));
            IIntegrate(1506, Int(Times(Power(Times(f_DEFAULT, x_), m_), Plus(d_, Times(e_DEFAULT, Power(x_, n_))), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_)), Times(c_DEFAULT, Power(x_, $p("n2")))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(a, c), C2))), Condition(With(List(Set(r, Rt(Subtract(Times(C2, c, q), Times(b, c)), C2))), Plus(Dist(Times(c, Power(Times(C2, q, r), CN1)), Int(Times(Power(Times(f, x), m), Simp(Subtract(Times(d, r), Times(Subtract(Times(c, d), Times(e, q)), Power(x, Times(C1D2, n)))), x), Power(Plus(q, Times(CN1, r, Power(x, Times(C1D2, n))), Times(c, Power(x, n))), CN1)), x), x), Dist(Times(c, Power(Times(C2, q, r), CN1)), Int(Times(Power(Times(f, x), m), Simp(Plus(Times(d, r), Times(Subtract(Times(c, d), Times(e, q)), Power(x, Times(C1D2, n)))), x), Power(Plus(q, Times(r, Power(x, Times(C1D2, n))), Times(c, Power(x, n))), CN1)), x), x))), Not(LtQ(Subtract(Times(C2, c, q), Times(b, c)), C0)))), And(FreeQ(List(a, b, c, d, e, f), x), EqQ($s("n2"), Times(C2, n)), LtQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegersQ(m, Times(C1D2, n)), LtQ(C0, m, n), PosQ(Times(a, c)))));
            IIntegrate(1507, Int(Times(Power(Times(f_DEFAULT, x_), m_), Plus(d_, Times(e_DEFAULT, Power(x_, n_))), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2")))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(a, c), C2))), Condition(With(List(Set(r, Rt(Times(C2, c, q), C2))), Plus(Dist(Times(c, Power(Times(C2, q, r), CN1)), Int(Times(Power(Times(f, x), m), Simp(Subtract(Times(d, r), Times(Subtract(Times(c, d), Times(e, q)), Power(x, Times(C1D2, n)))), x), Power(Plus(q, Times(CN1, r, Power(x, Times(C1D2, n))), Times(c, Power(x, n))), CN1)), x), x), Dist(Times(c, Power(Times(C2, q, r), CN1)), Int(Times(Power(Times(f, x), m), Simp(Plus(Times(d, r), Times(Subtract(Times(c, d), Times(e, q)), Power(x, Times(C1D2, n)))), x), Power(Plus(q, Times(r, Power(x, Times(C1D2, n))), Times(c, Power(x, n))), CN1)), x), x))), Not(LtQ(Times(C2, c, q), C0)))), And(FreeQ(List(a, c, d, e, f), x), EqQ($s("n2"), Times(C2, n)), GtQ(Times(a, c), C0), IntegersQ(m, Times(C1D2, n)), LtQ(C0, m, n))));
            IIntegrate(1508, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Plus(d_, Times(e_DEFAULT, Power(x_, n_))), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_)), Times(c_DEFAULT, Power(x_, $p("n2")))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(a, c), C2))), Condition(With(List(Set(r, Rt(Subtract(Times(C2, c, q), Times(b, c)), C2))), Plus(Dist(Times(c, Power(Times(C2, q, r), CN1)), Int(Times(Power(Times(f, x), m), Subtract(Times(d, r), Times(Subtract(Times(c, d), Times(e, q)), Power(x, Times(C1D2, n)))), Power(Plus(q, Times(CN1, r, Power(x, Times(C1D2, n))), Times(c, Power(x, n))), CN1)), x), x), Dist(Times(c, Power(Times(C2, q, r), CN1)), Int(Times(Power(Times(f, x), m), Plus(Times(d, r), Times(Subtract(Times(c, d), Times(e, q)), Power(x, Times(C1D2, n)))), Power(Plus(q, Times(r, Power(x, Times(C1D2, n))), Times(c, Power(x, n))), CN1)), x), x))), Not(LtQ(Subtract(Times(C2, c, q), Times(b, c)), C0)))), And(FreeQ(List(a, b, c, d, e, f, m), x), EqQ($s("n2"), Times(C2, n)), LtQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(Times(C1D2, n), C1), PosQ(Times(a, c)))));
            IIntegrate(1509, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Plus(d_, Times(e_DEFAULT, Power(x_, n_))), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2")))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(a, c), C2))), Condition(With(List(Set(r, Rt(Times(C2, c, q), C2))), Plus(Dist(Times(c, Power(Times(C2, q, r), CN1)), Int(Times(Power(Times(f, x), m), Subtract(Times(d, r), Times(Subtract(Times(c, d), Times(e, q)), Power(x, Times(C1D2, n)))), Power(Plus(q, Times(CN1, r, Power(x, Times(C1D2, n))), Times(c, Power(x, n))), CN1)), x), x), Dist(Times(c, Power(Times(C2, q, r), CN1)), Int(Times(Power(Times(f, x), m), Plus(Times(d, r), Times(Subtract(Times(c, d), Times(e, q)), Power(x, Times(C1D2, n)))), Power(Plus(q, Times(r, Power(x, Times(C1D2, n))), Times(c, Power(x, n))), CN1)), x), x))), Not(LtQ(Times(C2, c, q), C0)))), And(FreeQ(List(a, c, d, e, f, m), x), EqQ($s("n2"), Times(C2, n)), IGtQ(Times(C1D2, n), C1), GtQ(Times(a, c), C0))));
            IIntegrate(1510, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Plus(d_, Times(e_DEFAULT, Power(x_, n_))), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_)), Times(c_DEFAULT, Power(x_, $p("n2")))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Plus(Dist(Plus(Times(C1D2, e), Times(Subtract(Times(C2, c, d), Times(b, e)), Power(Times(C2, q), CN1))), Int(Times(Power(Times(f, x), m), Power(Plus(Times(C1D2, b), Times(CN1, C1D2, q), Times(c, Power(x, n))), CN1)), x), x), Dist(Subtract(Times(C1D2, e), Times(Subtract(Times(C2, c, d), Times(b, e)), Power(Times(C2, q), CN1))), Int(Times(Power(Times(f, x), m), Power(Plus(Times(C1D2, b), Times(C1D2, q), Times(c, Power(x, n))), CN1)), x), x))), And(FreeQ(List(a, b, c, d, e, f, m), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0))));
            IIntegrate(1511, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Plus(d_, Times(e_DEFAULT, Power(x_, n_))), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2")))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(CN1, a, c), C2))), Plus(Negate(Dist(Plus(Times(C1D2, e), Times(c, d, Power(Times(C2, q), CN1))), Int(Times(Power(Times(f, x), m), Power(Subtract(q, Times(c, Power(x, n))), CN1)), x), x)), Dist(Subtract(Times(C1D2, e), Times(c, d, Power(Times(C2, q), CN1))), Int(Times(Power(Times(f, x), m), Power(Plus(q, Times(c, Power(x, n))), CN1)), x), x))), And(FreeQ(List(a, c, d, e, f, m), x), EqQ($s("n2"), Times(C2, n)), IGtQ(n, C0))));
            IIntegrate(1512, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), CN1), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f, m), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0), IntegerQ(q), IntegerQ(m))));
            IIntegrate(1513, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), CN1), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), CN1)), x), x), And(FreeQ(List(a, c, d, e, f, m), x), EqQ($s("n2"), Times(C2, n)), IGtQ(n, C0), IntegerQ(q), IntegerQ(m))));
            IIntegrate(1514, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), CN1), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Times(f, x), m), Times(Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f, m), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0), IntegerQ(q), Not(IntegerQ(m)))));
            IIntegrate(1515, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), CN1), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Times(f, x), m), Times(Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), CN1)), x), x), And(FreeQ(List(a, c, d, e, f, m), x), EqQ($s("n2"), Times(C2, n)), IGtQ(n, C0), IntegerQ(q), Not(IntegerQ(m)))));
            IIntegrate(1516, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), CN1), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(Subtract(Dist(Times(Power(f, Times(C2, n)), Power(c, CN2)), Int(Times(Power(Times(f, x), Subtract(m, Times(C2, n))), Plus(Times(c, d), Times(CN1, b, e), Times(c, e, Power(x, n))), Power(Plus(d, Times(e, Power(x, n))), Subtract(q, C1))), x), x), Dist(Times(Power(f, Times(C2, n)), Power(c, CN2)), Int(Times(Power(Times(f, x), Subtract(m, Times(C2, n))), Power(Plus(d, Times(e, Power(x, n))), Subtract(q, C1)), Simp(Plus(Times(a, Subtract(Times(c, d), Times(b, e))), Times(Plus(Times(b, c, d), Times(CN1, Sqr(b), e), Times(a, c, e)), Power(x, n))), x), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0), Not(IntegerQ(q)), GtQ(q, C0), GtQ(m, Subtract(Times(C2, n), C1)))));
            IIntegrate(1517, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), CN1), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(Subtract(Dist(Times(Power(f, Times(C2, n)), Power(c, CN1)), Int(Times(Power(Times(f, x), Subtract(m, Times(C2, n))), Power(Plus(d, Times(e, Power(x, n))), q)), x), x), Dist(Times(a, Power(f, Times(C2, n)), Power(c, CN1)), Int(Times(Power(Times(f, x), Subtract(m, Times(C2, n))), Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), CN1)), x), x)), And(FreeQ(List(a, c, d, e, f, q), x), EqQ($s("n2"), Times(C2, n)), IGtQ(n, C0), Not(IntegerQ(q)), GtQ(m, Subtract(Times(C2, n), C1)))));
            IIntegrate(1518, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), CN1), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(Subtract(Dist(Times(e, Power(f, n), Power(c, CN1)), Int(Times(Power(Times(f, x), Subtract(m, n)), Power(Plus(d, Times(e, Power(x, n))), Subtract(q, C1))), x), x), Dist(Times(Power(f, n), Power(c, CN1)), Int(Times(Power(Times(f, x), Subtract(m, n)), Power(Plus(d, Times(e, Power(x, n))), Subtract(q, C1)), Simp(Subtract(Times(a, e), Times(Subtract(Times(c, d), Times(b, e)), Power(x, n))), x), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0), Not(IntegerQ(q)), GtQ(q, C0), GtQ(m, Subtract(n, C1)), LeQ(m, Subtract(Times(C2, n), C1)))));
            IIntegrate(1519, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), CN1), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(Subtract(Dist(Times(e, Power(f, n), Power(c, CN1)), Int(Times(Power(Times(f, x), Subtract(m, n)), Power(Plus(d, Times(e, Power(x, n))), Subtract(q, C1))), x), x), Dist(Times(Power(f, n), Power(c, CN1)), Int(Times(Power(Times(f, x), Subtract(m, n)), Power(Plus(d, Times(e, Power(x, n))), Subtract(q, C1)), Simp(Subtract(Times(a, e), Times(c, d, Power(x, n))), x), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), CN1)), x), x)), And(FreeQ(List(a, c, d, e, f), x), EqQ($s("n2"), Times(C2, n)), IGtQ(n, C0), Not(IntegerQ(q)), GtQ(q, C0), GtQ(m, Subtract(n, C1)), LeQ(m, Subtract(Times(C2, n), C1)))));
            IIntegrate(1520, Int(Times(Power(Times(f_DEFAULT, x_), m_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), CN1), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(Subtract(Dist(Times(d, Power(a, CN1)), Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Power(x, n))), Subtract(q, C1))), x), x), Dist(Power(Times(a, Power(f, n)), CN1), Int(Times(Power(Times(f, x), Plus(m, n)), Power(Plus(d, Times(e, Power(x, n))), Subtract(q, C1)), Simp(Plus(Times(b, d), Times(CN1, a, e), Times(c, d, Power(x, n))), x), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0), Not(IntegerQ(q)), GtQ(q, C0), LtQ(m, C0))));
            IIntegrate(1521, Int(Times(Power(Times(f_DEFAULT, x_), m_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), CN1), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(Plus(Dist(Times(d, Power(a, CN1)), Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Power(x, n))), Subtract(q, C1))), x), x), Dist(Power(Times(a, Power(f, n)), CN1), Int(Times(Power(Times(f, x), Plus(m, n)), Power(Plus(d, Times(e, Power(x, n))), Subtract(q, C1)), Simp(Subtract(Times(a, e), Times(c, d, Power(x, n))), x), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), CN1)), x), x)), And(FreeQ(List(a, c, d, e, f), x), EqQ($s("n2"), Times(C2, n)), IGtQ(n, C0), Not(IntegerQ(q)), GtQ(q, C0), LtQ(m, C0))));
            IIntegrate(1522, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), CN1), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(Subtract(Dist(Times(Sqr(d), Power(f, Times(C2, n)), Power(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), CN1)), Int(Times(Power(Times(f, x), Subtract(m, Times(C2, n))), Power(Plus(d, Times(e, Power(x, n))), q)), x), x), Dist(Times(Power(f, Times(C2, n)), Power(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), CN1)), Int(Times(Power(Times(f, x), Subtract(m, Times(C2, n))), Power(Plus(d, Times(e, Power(x, n))), Plus(q, C1)), Simp(Plus(Times(a, d), Times(Subtract(Times(b, d), Times(a, e)), Power(x, n))), x), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0), Not(IntegerQ(q)), LtQ(q, CN1), GtQ(m, Subtract(Times(C2, n), C1)))));
            IIntegrate(1523, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), CN1), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(Subtract(Dist(Times(Sqr(d), Power(f, Times(C2, n)), Power(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1)), Int(Times(Power(Times(f, x), Subtract(m, Times(C2, n))), Power(Plus(d, Times(e, Power(x, n))), q)), x), x), Dist(Times(a, Power(f, Times(C2, n)), Power(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1)), Int(Times(Power(Times(f, x), Subtract(m, Times(C2, n))), Power(Plus(d, Times(e, Power(x, n))), Plus(q, C1)), Subtract(d, Times(e, Power(x, n))), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), CN1)), x), x)), And(FreeQ(List(a, c, d, e, f), x), EqQ($s("n2"), Times(C2, n)), IGtQ(n, C0), Not(IntegerQ(q)), LtQ(q, CN1), GtQ(m, Subtract(Times(C2, n), C1)))));
            IIntegrate(1524, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), CN1), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(Plus(Negate(Dist(Times(d, e, Power(f, n), Power(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), CN1)), Int(Times(Power(Times(f, x), Subtract(m, n)), Power(Plus(d, Times(e, Power(x, n))), q)), x), x)), Dist(Times(Power(f, n), Power(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), CN1)), Int(Times(Power(Times(f, x), Subtract(m, n)), Power(Plus(d, Times(e, Power(x, n))), Plus(q, C1)), Simp(Plus(Times(a, e), Times(c, d, Power(x, n))), x), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0), Not(IntegerQ(q)), LtQ(q, CN1), GtQ(m, Subtract(n, C1)), LeQ(m, Subtract(Times(C2, n), C1)))));
            IIntegrate(1525, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), CN1), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(Plus(Negate(Dist(Times(d, e, Power(f, n), Power(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1)), Int(Times(Power(Times(f, x), Subtract(m, n)), Power(Plus(d, Times(e, Power(x, n))), q)), x), x)), Dist(Times(Power(f, n), Power(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1)), Int(Times(Power(Times(f, x), Subtract(m, n)), Power(Plus(d, Times(e, Power(x, n))), Plus(q, C1)), Simp(Plus(Times(a, e), Times(c, d, Power(x, n))), x), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), CN1)), x), x)), And(FreeQ(List(a, c, d, e, f), x), EqQ($s("n2"), Times(C2, n)), IGtQ(n, C0), Not(IntegerQ(q)), LtQ(q, CN1), GtQ(m, Subtract(n, C1)), LeQ(m, Subtract(Times(C2, n), C1)))));
        }
    }
}
