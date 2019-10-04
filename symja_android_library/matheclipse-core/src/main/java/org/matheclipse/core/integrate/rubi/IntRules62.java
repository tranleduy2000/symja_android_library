package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Coefficient;
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
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Simplify;
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
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.r;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearPairQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules62 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(1551, Int(Times(Power(Times(f_, x_), m_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(f, IntPart(m)), Power(Times(f, x), FracPart(m)), Power(Power(x, FracPart(m)), CN1)), Int(Times(Power(x, m), Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), p)), x), x), And(FreeQ(List(a, c, d, e, f, m, p, q), x), EqQ($s("n2"), Times(C2, n)), FractionQ(n))));
            IIntegrate(1552, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Plus(m, C1), CN1), Subst(Int(Times(Power(Plus(d, Times(e, Power(x, Simplify(Times(n, Power(Plus(m, C1), CN1)))))), q), Power(Plus(a, Times(b, Power(x, Simplify(Times(n, Power(Plus(m, C1), CN1))))), Times(c, Power(x, Simplify(Times(C2, n, Power(Plus(m, C1), CN1)))))), p)), x), x, Power(x, Plus(m, C1))), x), And(FreeQ(List(a, b, c, d, e, m, n, p, q), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(Simplify(Times(n, Power(Plus(m, C1), CN1)))), Not(IntegerQ(n)))));
            IIntegrate(1553, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Plus(m, C1), CN1), Subst(Int(Times(Power(Plus(d, Times(e, Power(x, Simplify(Times(n, Power(Plus(m, C1), CN1)))))), q), Power(Plus(a, Times(c, Power(x, Simplify(Times(C2, n, Power(Plus(m, C1), CN1)))))), p)), x), x, Power(x, Plus(m, C1))), x), And(FreeQ(List(a, c, d, e, m, n, p, q), x), EqQ($s("n2"), Times(C2, n)), IntegerQ(Simplify(Times(n, Power(Plus(m, C1), CN1)))), Not(IntegerQ(n)))));
            IIntegrate(1554, Int(Times(Power(Times(f_, x_), m_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(f, IntPart(m)), Power(Times(f, x), FracPart(m)), Power(Power(x, FracPart(m)), CN1)), Int(Times(Power(x, m), Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p)), x), x), And(FreeQ(List(a, b, c, d, e, f, m, p, q), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(Simplify(Times(n, Power(Plus(m, C1), CN1)))), Not(IntegerQ(n)))));
            IIntegrate(1555, Int(Times(Power(Times(f_, x_), m_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(f, IntPart(m)), Power(Times(f, x), FracPart(m)), Power(Power(x, FracPart(m)), CN1)), Int(Times(Power(x, m), Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), p)), x), x), And(FreeQ(List(a, c, d, e, f, m, p, q), x), EqQ($s("n2"), Times(C2, n)), IntegerQ(Simplify(Times(n, Power(Plus(m, C1), CN1)))), Not(IntegerQ(n)))));
            IIntegrate(1556, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), CN1), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(With(List(Set(r, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Subtract(Dist(Times(C2, c, Power(r, CN1)), Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(b, Negate(r), Times(C2, c, Power(x, n))), CN1)), x), x), Dist(Times(C2, c, Power(r, CN1)), Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(b, r, Times(C2, c, Power(x, n))), CN1)), x), x))), And(FreeQ(List(a, b, c, d, e, f, m, n, q), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(1557, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), CN1), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(With(List(Set(r, Rt(Times(CN1, a, c), C2))), Subtract(Negate(Dist(Times(c, Power(Times(C2, r), CN1)), Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Power(x, n))), q), Power(Subtract(r, Times(c, Power(x, n))), CN1)), x), x)), Dist(Times(c, Power(Times(C2, r), CN1)), Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(r, Times(c, Power(x, n))), CN1)), x), x))), And(FreeQ(List(a, c, d, e, f, m, n, q), x), EqQ($s("n2"), Times(C2, n)))));
            IIntegrate(1558, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Plus(d_, Times(e_DEFAULT, Power(x_, n_))), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_)), Times(c_DEFAULT, Power(x_, $p("n2")))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Times(f, x), Plus(m, C1)), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), Plus(p, C1)), Plus(Times(d, Subtract(Sqr(b), Times(C2, a, c))), Times(CN1, a, b, e), Times(Subtract(Times(b, d), Times(C2, a, e)), c, Power(x, n))), Power(Times(a, f, n, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1)), x)), Dist(Power(Times(a, n, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1), Int(Times(Power(Times(f, x), m), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), Plus(p, C1)), Simp(Plus(Times(d, Subtract(Times(Sqr(b), Plus(m, Times(n, Plus(p, C1)), C1)), Times(C2, a, c, Plus(m, Times(C2, n, Plus(p, C1)), C1)))), Times(CN1, a, b, e, Plus(m, C1)), Times(Plus(m, Times(n, Plus(Times(C2, p), C3)), C1), Subtract(Times(b, d), Times(C2, a, e)), c, Power(x, n))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, m, n), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), ILtQ(Plus(p, C1), C0))));
            IIntegrate(1559, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Plus(d_, Times(e_DEFAULT, Power(x_, n_))), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2")))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Times(f, x), Plus(m, C1)), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), Plus(p, C1)), Plus(d, Times(e, Power(x, n))), Power(Times(C2, a, f, n, Plus(p, C1)), CN1)), x)), Dist(Power(Times(C2, a, n, Plus(p, C1)), CN1), Int(Times(Power(Times(f, x), m), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), Plus(p, C1)), Simp(Plus(Times(d, Plus(m, Times(C2, n, Plus(p, C1)), C1)), Times(e, Plus(m, Times(n, Plus(Times(C2, p), C3)), C1), Power(x, n))), x)), x), x)), And(FreeQ(List(a, c, d, e, f, m, n), x), EqQ($s("n2"), Times(C2, n)), ILtQ(Plus(p, C1), C0))));
            IIntegrate(1560, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p)), x), x), And(FreeQ(List(a, b, c, d, e, f, m, n, p, q), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Or(IGtQ(p, C0), IGtQ(q, C0)))));
            IIntegrate(1561, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), p)), x), x), And(FreeQ(List(a, c, d, e, f, m, n, p, q), x), EqQ($s("n2"), Times(C2, n)), Or(IGtQ(p, C0), IGtQ(q, C0)))));
            IIntegrate(1562, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2")))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Times(f, x), m), Power(Power(x, m), CN1)), Int(ExpandIntegrand(Times(Power(x, m), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), p)), Power(Subtract(Times(d, Power(Subtract(Sqr(d), Times(Sqr(e), Power(x, Times(C2, n)))), CN1)), Times(e, Power(x, n), Power(Subtract(Sqr(d), Times(Sqr(e), Power(x, Times(C2, n)))), CN1))), Negate(q)), x), x), x), And(FreeQ(List(a, c, d, e, f, m, n, p), x), EqQ($s("n2"), Times(C2, n)), Not(IntegerQ(p)), ILtQ(q, C0))));
            IIntegrate(1563, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p)), x), And(FreeQ(List(a, b, c, d, e, f, m, n, p, q), x), EqQ($s("n2"), Times(C2, n)))));
            IIntegrate(1564, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), p)), x), And(FreeQ(List(a, c, d, e, f, m, n, p, q), x), EqQ($s("n2"), Times(C2, n)))));
            IIntegrate(1565, Int(Times(Power(u_, m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(v_, $p("n2", true))), Times(b_DEFAULT, Power(v_, n_))), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(v_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(u, m), Power(Times(Coefficient(v, x, C1), Power(v, m)), CN1)), Subst(Int(Times(Power(x, m), Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p)), x), x, v), x), And(FreeQ(List(a, b, c, d, e, m, n, p, q), x), EqQ($s("n2"), Times(C2, n)), LinearPairQ(u, v, x), NeQ(v, x))));
            IIntegrate(1566, Int(Times(Power(u_, m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(v_, $p("n2", true)))), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(v_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(u, m), Power(Times(Coefficient(v, x, C1), Power(v, m)), CN1)), Subst(Int(Times(Power(x, m), Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), p)), x), x, v), x), And(FreeQ(List(a, c, d, e, m, n, p), x), EqQ($s("n2"), Times(C2, n)), LinearPairQ(u, v, x), NeQ(v, x))));
            IIntegrate(1567, Int(Times(Power(x_, m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, $p("mn", true)))), q_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT)), Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(x, Subtract(m, Times(n, q))), Power(Plus(e, Times(d, Power(x, n))), q), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p)), x), And(FreeQ(List(a, b, c, d, e, m, n, p), x), EqQ($s("n2"), Times(C2, n)), EqQ($s("mn"), Negate(n)), IntegerQ(q), Or(PosQ(n), Not(IntegerQ(p))))));
            IIntegrate(1568, Int(Times(Power(x_, m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, $p("mn", true)))), q_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(x, Plus(m, Times($s("mn"), q))), Power(Plus(e, Times(d, Power(Power(x, $s("mn")), CN1))), q), Power(Plus(a, Times(c, Power(x, $s("n2")))), p)), x), And(FreeQ(List(a, c, d, e, m, $s("mn"), p), x), EqQ($s("n2"), Times(CN2, $s("mn"))), IntegerQ(q), Or(PosQ($s("n2")), Not(IntegerQ(p))))));
            IIntegrate(1569, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, $p("mn", true))), Times(c_DEFAULT, Power(x_, $p("mn2", true)))), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_DEFAULT))), q_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(x, Subtract(m, Times(C2, n, p))), Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(c, Times(b, Power(x, n)), Times(a, Power(x, Times(C2, n)))), p)), x), And(FreeQ(List(a, b, c, d, e, m, n, q), x), EqQ($s("mn"), Negate(n)), EqQ($s("mn2"), Times(C2, $s("mn"))), IntegerQ(p))));
            IIntegrate(1570, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_DEFAULT, Times(c_DEFAULT, Power(x_, $p("mn2", true)))), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_DEFAULT))), q_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(x, Subtract(m, Times(C2, n, p))), Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(c, Times(a, Power(x, Times(C2, n)))), p)), x), And(FreeQ(List(a, c, d, e, m, n, q), x), EqQ($s("mn2"), Times(CN2, n)), IntegerQ(p))));
            IIntegrate(1571, Int(Times(Power(x_, m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, $p("mn", true)))), q_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT)), Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(e, IntPart(q)), Power(x, Times(n, FracPart(q))), Power(Plus(d, Times(e, Power(Power(x, n), CN1))), FracPart(q)), Power(Power(Plus(C1, Times(d, Power(x, n), Power(e, CN1))), FracPart(q)), CN1)), Int(Times(Power(x, Subtract(m, Times(n, q))), Power(Plus(C1, Times(d, Power(x, n), Power(e, CN1))), q), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p)), x), x), And(FreeQ(List(a, b, c, d, e, m, n, p, q), x), EqQ($s("n2"), Times(C2, n)), EqQ($s("mn"), Negate(n)), Not(IntegerQ(p)), Not(IntegerQ(q)), PosQ(n))));
            IIntegrate(1572, Int(Times(Power(x_, m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, $p("mn", true)))), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(e, IntPart(q)), Power(Plus(d, Times(e, Power(x, $s("mn")))), FracPart(q)), Power(Times(Power(x, Times($s("mn"), FracPart(q))), Power(Plus(C1, Times(d, Power(Times(Power(x, $s("mn")), e), CN1))), FracPart(q))), CN1)), Int(Times(Power(x, Plus(m, Times($s("mn"), q))), Power(Plus(C1, Times(d, Power(Times(Power(x, $s("mn")), e), CN1))), q), Power(Plus(a, Times(c, Power(x, $s("n2")))), p)), x), x), And(FreeQ(List(a, c, d, e, m, $s("mn"), p, q), x), EqQ($s("n2"), Times(CN2, $s("mn"))), Not(IntegerQ(p)), Not(IntegerQ(q)), PosQ($s("n2")))));
            IIntegrate(1573, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, $p("mn", true))), Times(c_DEFAULT, Power(x_, $p("mn2", true)))), p_), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_DEFAULT))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(x, Times(C2, n, FracPart(p))), Power(Plus(a, Times(b, Power(Power(x, n), CN1)), Times(c, Power(Power(x, Times(C2, n)), CN1))), FracPart(p)), Power(Power(Plus(c, Times(b, Power(x, n)), Times(a, Power(x, Times(C2, n)))), FracPart(p)), CN1)), Int(Times(Power(x, Subtract(m, Times(C2, n, p))), Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(c, Times(b, Power(x, n)), Times(a, Power(x, Times(C2, n)))), p)), x), x), And(FreeQ(List(a, b, c, d, e, m, n, p, q), x), EqQ($s("mn"), Negate(n)), EqQ($s("mn2"), Times(C2, $s("mn"))), Not(IntegerQ(p)), Not(IntegerQ(q)), PosQ(n))));
            IIntegrate(1574, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_DEFAULT, Times(c_DEFAULT, Power(x_, $p("mn2", true)))), p_), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_DEFAULT))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(x, Times(C2, n, FracPart(p))), Power(Plus(a, Times(c, Power(Power(x, Times(C2, n)), CN1))), FracPart(p)), Power(Power(Plus(c, Times(a, Power(x, Times(C2, n)))), FracPart(p)), CN1)), Int(Times(Power(x, Subtract(m, Times(C2, n, p))), Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(c, Times(a, Power(x, Times(C2, n)))), p)), x), x), And(FreeQ(List(a, c, d, e, m, n, p, q), x), EqQ($s("mn2"), Times(CN2, n)), Not(IntegerQ(p)), Not(IntegerQ(q)), PosQ(n))));
            IIntegrate(1575, Int(Times(Power(Times(f_, x_), m_), Power(Plus(d_, Times(e_DEFAULT, Power(x_, $p("mn", true)))), q_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT)), Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(f, IntPart(m)), Power(Times(f, x), FracPart(m)), Power(Power(x, FracPart(m)), CN1)), Int(Times(Power(x, m), Power(Plus(d, Times(e, Power(x, $s("mn")))), q), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p)), x), x), And(FreeQ(List(a, b, c, d, e, f, m, n, p, q), x), EqQ($s("n2"), Times(C2, n)), EqQ($s("mn"), Negate(n)))));
        }
    }
}
