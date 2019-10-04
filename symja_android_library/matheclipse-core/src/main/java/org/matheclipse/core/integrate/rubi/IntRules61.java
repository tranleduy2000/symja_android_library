package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
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
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules61 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(1526, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_)), Times(c_DEFAULT, Power(x_, $p("n2")))), CN1)), x_Symbol),
                    Condition(Plus(Dist(Times(Sqr(e), Power(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), CN1)), Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Power(x, n))), q)), x), x), Dist(Power(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), CN1), Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Power(x, n))), Plus(q, C1)), Simp(Subtract(Subtract(Times(c, d), Times(b, e)), Times(c, e, Power(x, n))), x), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, m), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0), Not(IntegerQ(q)), LtQ(q, CN1))));
            IIntegrate(1527, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2")))), CN1)), x_Symbol),
                    Condition(Plus(Dist(Times(Sqr(e), Power(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1)), Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Power(x, n))), q)), x), x), Dist(Times(c, Power(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1)), Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Power(x, n))), Plus(q, C1)), Subtract(d, Times(e, Power(x, n))), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), CN1)), x), x)), And(FreeQ(List(a, c, d, e, f, m), x), EqQ($s("n2"), Times(C2, n)), IGtQ(n, C0), Not(IntegerQ(q)), LtQ(q, CN1))));
            IIntegrate(1528, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), CN1), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(d, Times(e, Power(x, n))), q), Times(Power(Times(f, x), m), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f, q, n), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0), Not(IntegerQ(q)), IntegerQ(m))));
            IIntegrate(1529, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), CN1), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(d, Times(e, Power(x, n))), q), Times(Power(Times(f, x), m), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), CN1)), x), x), And(FreeQ(List(a, c, d, e, f, q, n), x), EqQ($s("n2"), Times(C2, n)), IGtQ(n, C0), Not(IntegerQ(q)), IntegerQ(m))));
            IIntegrate(1530, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), CN1), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Power(x, n))), q)), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), CN1), x), x), And(FreeQ(List(a, b, c, d, e, f, m, q, n), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0), Not(IntegerQ(q)), Not(IntegerQ(m)))));
            IIntegrate(1531, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), CN1), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Power(x, n))), q)), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), CN1), x), x), And(FreeQ(List(a, c, d, e, f, m, q, n), x), EqQ($s("n2"), Times(C2, n)), IGtQ(n, C0), Not(IntegerQ(q)), Not(IntegerQ(m)))));
            IIntegrate(1532, Int(Times(Power(Times(f_DEFAULT, x_), m_), Power(Plus(a_DEFAULT, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Power(x_, n_))), CN1)), x_Symbol),
                    Condition(Plus(Dist(Power(d, CN2), Int(Times(Power(Times(f, x), m), Plus(Times(a, d), Times(Subtract(Times(b, d), Times(a, e)), Power(x, n))), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), Subtract(p, C1))), x), x), Dist(Times(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), Power(Times(Sqr(d), Power(f, Times(C2, n))), CN1)), Int(Times(Power(Times(f, x), Plus(m, Times(C2, n))), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), Subtract(p, C1)), Power(Plus(d, Times(e, Power(x, n))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0), GtQ(p, C0), LtQ(m, Negate(n)))));
            IIntegrate(1533, Int(Times(Power(Times(f_DEFAULT, x_), m_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_DEFAULT), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Power(x_, n_))), CN1)), x_Symbol),
                    Condition(Plus(Dist(Times(a, Power(d, CN2)), Int(Times(Power(Times(f, x), m), Subtract(d, Times(e, Power(x, n))), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), Subtract(p, C1))), x), x), Dist(Times(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), Power(Times(Sqr(d), Power(f, Times(C2, n))), CN1)), Int(Times(Power(Times(f, x), Plus(m, Times(C2, n))), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), Subtract(p, C1)), Power(Plus(d, Times(e, Power(x, n))), CN1)), x), x)), And(FreeQ(List(a, c, d, e, f), x), EqQ($s("n2"), Times(C2, n)), IGtQ(n, C0), GtQ(p, C0), LtQ(m, Negate(n)))));
            IIntegrate(1534, Int(Times(Power(Times(f_DEFAULT, x_), m_), Power(Plus(a_DEFAULT, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Power(x_, n_))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Power(Times(d, e), CN1), Int(Times(Power(Times(f, x), m), Plus(Times(a, e), Times(c, d, Power(x, n))), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), Subtract(p, C1))), x), x), Dist(Times(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), Power(Times(d, e, Power(f, n)), CN1)), Int(Times(Power(Times(f, x), Plus(m, n)), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), Subtract(p, C1)), Power(Plus(d, Times(e, Power(x, n))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0), GtQ(p, C0), LtQ(m, C0))));
            IIntegrate(1535, Int(Times(Power(Times(f_DEFAULT, x_), m_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_DEFAULT), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Power(x_, n_))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Power(Times(d, e), CN1), Int(Times(Power(Times(f, x), m), Plus(Times(a, e), Times(c, d, Power(x, n))), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), Subtract(p, C1))), x), x), Dist(Times(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), Power(Times(d, e, Power(f, n)), CN1)), Int(Times(Power(Times(f, x), Plus(m, n)), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), Subtract(p, C1)), Power(Plus(d, Times(e, Power(x, n))), CN1)), x), x)), And(FreeQ(List(a, c, d, e, f), x), EqQ($s("n2"), Times(C2, n)), IGtQ(n, C0), GtQ(p, C0), LtQ(m, C0))));
            IIntegrate(1536, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(a_DEFAULT, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Power(x_, n_))), CN1)), x_Symbol),
                    Condition(Plus(Negate(Dist(Times(Power(f, Times(C2, n)), Power(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), CN1)), Int(Times(Power(Times(f, x), Subtract(m, Times(C2, n))), Plus(Times(a, d), Times(Subtract(Times(b, d), Times(a, e)), Power(x, n))), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p)), x), x)), Dist(Times(Sqr(d), Power(f, Times(C2, n)), Power(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), CN1)), Int(Times(Power(Times(f, x), Subtract(m, Times(C2, n))), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), Plus(p, C1)), Power(Plus(d, Times(e, Power(x, n))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0), LtQ(p, CN1), GtQ(m, n))));
            IIntegrate(1537, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Power(x_, n_))), CN1)), x_Symbol),
                    Condition(Plus(Negate(Dist(Times(a, Power(f, Times(C2, n)), Power(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1)), Int(Times(Power(Times(f, x), Subtract(m, Times(C2, n))), Subtract(d, Times(e, Power(x, n))), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), p)), x), x)), Dist(Times(Sqr(d), Power(f, Times(C2, n)), Power(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1)), Int(Times(Power(Times(f, x), Subtract(m, Times(C2, n))), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), Plus(p, C1)), Power(Plus(d, Times(e, Power(x, n))), CN1)), x), x)), And(FreeQ(List(a, c, d, e, f), x), EqQ($s("n2"), Times(C2, n)), IGtQ(n, C0), LtQ(p, CN1), GtQ(m, n))));
            IIntegrate(1538, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(a_DEFAULT, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Power(x_, n_))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Times(Power(f, n), Power(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), CN1)), Int(Times(Power(Times(f, x), Subtract(m, n)), Plus(Times(a, e), Times(c, d, Power(x, n))), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p)), x), x), Dist(Times(d, e, Power(f, n), Power(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), CN1)), Int(Times(Power(Times(f, x), Subtract(m, n)), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), Plus(p, C1)), Power(Plus(d, Times(e, Power(x, n))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0), LtQ(p, CN1), GtQ(m, C0))));
            IIntegrate(1539, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Power(x_, n_))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Times(Power(f, n), Power(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1)), Int(Times(Power(Times(f, x), Subtract(m, n)), Plus(Times(a, e), Times(c, d, Power(x, n))), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), p)), x), x), Dist(Times(d, e, Power(f, n), Power(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1)), Int(Times(Power(Times(f, x), Subtract(m, n)), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), Plus(p, C1)), Power(Plus(d, Times(e, Power(x, n))), CN1)), x), x)), And(FreeQ(List(a, c, d, e, f), x), EqQ($s("n2"), Times(C2, n)), IGtQ(n, C0), LtQ(p, CN1), GtQ(m, C0))));
            IIntegrate(1540, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p), Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Power(x, n))), q)), x), x), And(FreeQ(List(a, b, c, d, e, f, m, q), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0), Or(IGtQ(q, C0), IntegersQ(m, q)))));
            IIntegrate(1541, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(a, Times(c, Power(x, Times(C2, n)))), p), Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Power(x, n))), q)), x), x), And(FreeQ(List(a, c, d, e, f, m, q), x), EqQ($s("n2"), Times(C2, n)), IGtQ(n, C0), IGtQ(q, C0))));
            IIntegrate(1542, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Negate(Subst(Int(Times(Power(Plus(d, Times(e, Power(Power(x, n), CN1))), q), Power(Plus(a, Times(b, Power(Power(x, n), CN1)), Times(c, Power(Power(x, Times(C2, n)), CN1))), p), Power(Power(x, Plus(m, C2)), CN1)), x), x, Power(x, CN1))), And(FreeQ(List(a, b, c, d, e, p, q), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), ILtQ(n, C0), IntegerQ(m))));
            IIntegrate(1543, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Negate(Subst(Int(Times(Power(Plus(d, Times(e, Power(Power(x, n), CN1))), q), Power(Plus(a, Times(c, Power(Power(x, Times(C2, n)), CN1))), p), Power(Power(x, Plus(m, C2)), CN1)), x), x, Power(x, CN1))), And(FreeQ(List(a, c, d, e, p, q), x), EqQ($s("n2"), Times(C2, n)), ILtQ(n, C0), IntegerQ(m))));
            IIntegrate(1544, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(g, Denominator(m))), Negate(Dist(Times(g, Power(f, CN1)), Subst(Int(Times(Power(Plus(d, Times(e, Power(Times(Power(f, n), Power(x, Times(g, n))), CN1))), q), Power(Plus(a, Times(b, Power(Times(Power(f, n), Power(x, Times(g, n))), CN1)), Times(c, Power(Times(Power(f, Times(C2, n)), Power(x, Times(C2, g, n))), CN1))), p), Power(Power(x, Plus(Times(g, Plus(m, C1)), C1)), CN1)), x), x, Power(Power(Times(f, x), Power(g, CN1)), CN1)), x))), And(FreeQ(List(a, b, c, d, e, f, p, q), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), ILtQ(n, C0), FractionQ(m))));
            IIntegrate(1545, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(g, Denominator(m))), Negate(Dist(Times(g, Power(f, CN1)), Subst(Int(Times(Power(Plus(d, Times(e, Power(Times(Power(f, n), Power(x, Times(g, n))), CN1))), q), Power(Plus(a, Times(c, Power(Times(Power(f, Times(C2, n)), Power(x, Times(C2, g, n))), CN1))), p), Power(Power(x, Plus(Times(g, Plus(m, C1)), C1)), CN1)), x), x, Power(Power(Times(f, x), Power(g, CN1)), CN1)), x))), And(FreeQ(List(a, c, d, e, f, p, q), x), EqQ($s("n2"), Times(C2, n)), ILtQ(n, C0), FractionQ(m))));
            IIntegrate(1546, Int(Times(Power(Times(f_DEFAULT, x_), m_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Negate(Dist(Times(Power(f, IntPart(m)), Power(Times(f, x), FracPart(m)), Power(Power(x, CN1), FracPart(m))), Subst(Int(Times(Power(Plus(d, Times(e, Power(Power(x, n), CN1))), q), Power(Plus(a, Times(b, Power(Power(x, n), CN1)), Times(c, Power(Power(x, Times(C2, n)), CN1))), p), Power(Power(x, Plus(m, C2)), CN1)), x), x, Power(x, CN1)), x)), And(FreeQ(List(a, b, c, d, e, f, m, p, q), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), ILtQ(n, C0), Not(RationalQ(m)))));
            IIntegrate(1547, Int(Times(Power(Times(f_DEFAULT, x_), m_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Negate(Dist(Times(Power(f, IntPart(m)), Power(Times(f, x), FracPart(m)), Power(Power(x, CN1), FracPart(m))), Subst(Int(Times(Power(Plus(d, Times(e, Power(Power(x, n), CN1))), q), Power(Plus(a, Times(c, Power(Power(x, Times(C2, n)), CN1))), p), Power(Power(x, Plus(m, C2)), CN1)), x), x, Power(x, CN1)), x)), And(FreeQ(List(a, c, d, e, f, m, p, q), x), EqQ($s("n2"), Times(C2, n)), ILtQ(n, C0), Not(RationalQ(m)))));
            IIntegrate(1548, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(g, Denominator(n))), Dist(g, Subst(Int(Times(Power(x, Subtract(Times(g, Plus(m, C1)), C1)), Power(Plus(d, Times(e, Power(x, Times(g, n)))), q), Power(Plus(a, Times(b, Power(x, Times(g, n))), Times(c, Power(x, Times(C2, g, n)))), p)), x), x, Power(x, Power(g, CN1))), x)), And(FreeQ(List(a, b, c, d, e, m, p, q), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), FractionQ(n))));
            IIntegrate(1549, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(g, Denominator(n))), Dist(g, Subst(Int(Times(Power(x, Subtract(Times(g, Plus(m, C1)), C1)), Power(Plus(d, Times(e, Power(x, Times(g, n)))), q), Power(Plus(a, Times(c, Power(x, Times(C2, g, n)))), p)), x), x, Power(x, Power(g, CN1))), x)), And(FreeQ(List(a, c, d, e, m, p, q), x), EqQ($s("n2"), Times(C2, n)), FractionQ(n))));
            IIntegrate(1550, Int(Times(Power(Times(f_, x_), m_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(f, IntPart(m)), Power(Times(f, x), FracPart(m)), Power(Power(x, FracPart(m)), CN1)), Int(Times(Power(x, m), Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p)), x), x), And(FreeQ(List(a, b, c, d, e, f, m, p, q), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), FractionQ(n))));
        }
    }
}
