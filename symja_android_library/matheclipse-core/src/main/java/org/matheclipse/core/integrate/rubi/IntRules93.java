package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcSin;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
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
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
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
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.r;
import static org.matheclipse.core.expression.F.r_;
import static org.matheclipse.core.expression.F.r_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialMatchQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntHide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InverseFunctionFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NegQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules93 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(2326, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Subtract(Simp(Times(ArcSin(Times(Rt(Negate(e), C2), x, Power(d, CN1D2))), Plus(a, Times(b, Log(Times(c, Power(x, n))))), Power(Rt(Negate(e), C2), CN1)), x), Dist(Times(b, n, Power(Rt(Negate(e), C2), CN1)), Int(Times(ArcSin(Times(Rt(Negate(e), C2), x, Power(d, CN1D2))), Power(x, CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, n), x), GtQ(d, C0), NegQ(e))));
            IIntegrate(2327, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Plus(C1, Times(e, Sqr(x), Power(d, CN1)))), Power(Plus(d, Times(e, Sqr(x))), CN1D2)), Int(Times(Plus(a, Times(b, Log(Times(c, Power(x, n))))), Power(Plus(C1, Times(e, Sqr(x), Power(d, CN1))), CN1D2)), x), x), And(FreeQ(List(a, b, c, d, e, n), x), Not(GtQ(d, C0)))));
            IIntegrate(2328, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), Power(Plus($p("d1"), Times($p("e1", true), x_)), CN1D2), Power(Plus($p("d2"), Times($p("e2", true), x_)), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Plus(C1, Times($s("e1"), $s("e2"), Sqr(x), Power(Times($s("d1"), $s("d2")), CN1)))), Power(Times(Sqrt(Plus($s("d1"), Times($s("e1"), x))), Sqrt(Plus($s("d2"), Times($s("e2"), x)))), CN1)), Int(Times(Plus(a, Times(b, Log(Times(c, Power(x, n))))), Power(Plus(C1, Times($s("e1"), $s("e2"), Sqr(x), Power(Times($s("d1"), $s("d2")), CN1))), CN1D2)), x), x), And(FreeQ(List(a, b, c, $s("d1"), $s("e1"), $s("d2"), $s("e2"), n), x), EqQ(Plus(Times($s("d2"), $s("e1")), Times($s("d1"), $s("e2"))), C0))));
            IIntegrate(2329, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), Power(Plus(d_, Times(e_DEFAULT, Power(x_, r_DEFAULT))), q_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Power(Plus(d, Times(e, Power(x, r))), q), x))), Condition(Subtract(Dist(Plus(a, Times(b, Log(Times(c, Power(x, n))))), u, x), Dist(Times(b, n), Int(SimplifyIntegrand(Times(u, Power(x, CN1)), x), x), x)), Or(And(EqQ(r, C1), IntegerQ(Subtract(q, C1D2))), And(EqQ(r, C2), EqQ(q, CN1)), InverseFunctionFreeQ(u, x)))), And(FreeQ(List(a, b, c, d, e, n, q, r), x), IntegerQ(Times(C2, q)), IntegerQ(r))));
            IIntegrate(2330, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, r_DEFAULT))), q_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, ExpandIntegrand(Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), p), Power(Plus(d, Times(e, Power(x, r))), q), x))), Condition(Int(u, x), SumQ(u))), And(FreeQ(List(a, b, c, d, e, n, p, q, r), x), IntegerQ(q), Or(GtQ(q, C0), And(IGtQ(p, C0), IntegerQ(r))))));
            IIntegrate(2331, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, r_DEFAULT))), q_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(d, Times(e, Power(x, r))), q), Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), p)), x), FreeQ(List(a, b, c, d, e, n, p, q, r), x)));
            IIntegrate(2332, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(u_, q_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(ExpandToSum(u, x), q), Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), p)), x), And(FreeQ(List(a, b, c, n, p, q), x), BinomialQ(u, x), Not(BinomialMatchQ(u, x)))));
            IIntegrate(2333, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, CN1))), q_DEFAULT), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Plus(e, Times(d, x)), q), Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), p)), x), And(FreeQ(List(a, b, c, d, e, m, n, p), x), EqQ(m, q), IntegerQ(q))));
            IIntegrate(2334, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), Power(x_, m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, r_DEFAULT))), q_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Times(Power(x, m), Power(Plus(d, Times(e, Power(x, r))), q)), x))), Subtract(Simp(Times(u, Plus(a, Times(b, Log(Times(c, Power(x, n)))))), x), Dist(Times(b, n), Int(SimplifyIntegrand(Times(u, Power(x, CN1)), x), x), x))), And(FreeQ(List(a, b, c, d, e, n, r), x), IGtQ(q, C0), IntegerQ(m), Not(And(EqQ(q, C1), EqQ(m, CN1))))));
            IIntegrate(2335, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, r_DEFAULT))), q_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(f, x), Plus(m, C1)), Power(Plus(d, Times(e, Power(x, r))), Plus(q, C1)), Plus(a, Times(b, Log(Times(c, Power(x, n))))), Power(Times(d, f, Plus(m, C1)), CN1)), x), Dist(Times(b, n, Power(Times(d, Plus(m, C1)), CN1)), Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Power(x, r))), Plus(q, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f, m, n, q, r), x), EqQ(Plus(m, Times(r, Plus(q, C1)), C1), C0), NeQ(m, CN1))));
            IIntegrate(2336, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_))), b_DEFAULT)), p_DEFAULT), Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, r_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(f, m), Power(n, CN1)), Subst(Int(Times(Power(Plus(d, Times(e, x)), q), Power(Plus(a, Times(b, Log(Times(c, x)))), p)), x), x, Power(x, n)), x), And(FreeQ(List(a, b, c, d, e, f, m, n, q, r), x), EqQ(m, Subtract(r, C1)), IGtQ(p, C0), Or(IntegerQ(m), GtQ(f, C0)), EqQ(r, n))));
            IIntegrate(2337, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, r_))), CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(f, m), Log(Plus(C1, Times(e, Power(x, r), Power(d, CN1)))), Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), p), Power(Times(e, r), CN1)), x), Dist(Times(b, Power(f, m), n, p, Power(Times(e, r), CN1)), Int(Times(Log(Plus(C1, Times(e, Power(x, r), Power(d, CN1)))), Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), Subtract(p, C1)), Power(x, CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, m, n, r), x), EqQ(m, Subtract(r, C1)), IGtQ(p, C0), Or(IntegerQ(m), GtQ(f, C0)), NeQ(r, n))));
            IIntegrate(2338, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, r_))), q_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(f, m), Power(Plus(d, Times(e, Power(x, r))), Plus(q, C1)), Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), p), Power(Times(e, r, Plus(q, C1)), CN1)), x), Dist(Times(b, Power(f, m), n, p, Power(Times(e, r, Plus(q, C1)), CN1)), Int(Times(Power(Plus(d, Times(e, Power(x, r))), Plus(q, C1)), Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), Subtract(p, C1)), Power(x, CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, m, n, q, r), x), EqQ(m, Subtract(r, C1)), IGtQ(p, C0), Or(IntegerQ(m), GtQ(f, C0)), NeQ(r, n), NeQ(q, CN1))));
            IIntegrate(2339, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(Times(f_, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, r_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Times(f, x), m), Power(Power(x, m), CN1)), Int(Times(Power(x, m), Power(Plus(d, Times(e, Power(x, r))), q), Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), p)), x), x), And(FreeQ(List(a, b, c, d, e, f, m, n, q, r), x), EqQ(m, Subtract(r, C1)), IGtQ(p, C0), Not(Or(IntegerQ(m), GtQ(f, C0))))));
            IIntegrate(2340, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Times(f, x), Plus(m, C1)), Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Plus(a, Times(b, Log(Times(c, Power(x, n))))), Power(Times(C2, d, f, Plus(q, C1)), CN1)), x)), Dist(Power(Times(C2, d, Plus(q, C1)), CN1), Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Plus(Times(a, Plus(m, Times(C2, q), C3)), Times(b, n), Times(b, Plus(m, Times(C2, q), C3), Log(Times(c, Power(x, n)))))), x), x)), And(FreeQ(List(a, b, c, d, e, f, m, n), x), ILtQ(q, CN1), ILtQ(m, C0))));
            IIntegrate(2341, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), Power(x_, m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_)), x_Symbol),
                    Condition(Dist(Times(Power(d, IntPart(q)), Power(Plus(d, Times(e, Sqr(x))), FracPart(q)), Power(Power(Plus(C1, Times(e, Sqr(x), Power(d, CN1))), FracPart(q)), CN1)), Int(Times(Power(x, m), Power(Plus(C1, Times(e, Sqr(x), Power(d, CN1))), q), Plus(a, Times(b, Log(Times(c, Power(x, n)))))), x), x), And(FreeQ(List(a, b, c, d, e, n), x), IntegerQ(Times(C1D2, m)), IntegerQ(Subtract(q, C1D2)), Not(Or(LtQ(Plus(m, Times(C2, q)), CN2), GtQ(d, C0))))));
            IIntegrate(2342, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), Power(x_, m_DEFAULT), Power(Plus($p("d1"), Times($p("e1", true), x_)), q_), Power(Plus($p("d2"), Times($p("e2", true), x_)), q_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus($s("d1"), Times($s("e1"), x)), q), Power(Plus($s("d2"), Times($s("e2"), x)), q), Power(Power(Plus(C1, Times($s("e1"), $s("e2"), Sqr(x), Power(Times($s("d1"), $s("d2")), CN1))), q), CN1)), Int(Times(Power(x, m), Power(Plus(C1, Times($s("e1"), $s("e2"), Sqr(x), Power(Times($s("d1"), $s("d2")), CN1))), q), Plus(a, Times(b, Log(Times(c, Power(x, n)))))), x), x), And(FreeQ(List(a, b, c, $s("d1"), $s("e1"), $s("d2"), $s("e2"), n), x), EqQ(Plus(Times($s("d2"), $s("e1")), Times($s("d1"), $s("e2"))), C0), IntegerQ(m), IntegerQ(Subtract(q, C1D2)))));
            IIntegrate(2343, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_))), b_DEFAULT)), Power(x_, CN1), Power(Plus(d_, Times(e_DEFAULT, Power(x_, r_DEFAULT))), CN1)), x_Symbol),
                    Condition(Dist(Power(n, CN1), Subst(Int(Times(Plus(a, Times(b, Log(Times(c, x)))), Power(Times(x, Plus(d, Times(e, Power(x, Times(r, Power(n, CN1)))))), CN1)), x), x, Power(x, n)), x), And(FreeQ(List(a, b, c, d, e, n, r), x), IntegerQ(Times(r, Power(n, CN1))))));
            IIntegrate(2344, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(x_, CN1), Power(Plus(d_, Times(e_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Power(d, CN1), Int(Times(Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), p), Power(x, CN1)), x), x), Dist(Times(e, Power(d, CN1)), Int(Times(Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), p), Power(Plus(d, Times(e, x)), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, n), x), IGtQ(p, C0))));
            IIntegrate(2345, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(x_, CN1), Power(Plus(d_, Times(e_DEFAULT, Power(x_, r_DEFAULT))), CN1)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Log(Plus(C1, Times(d, Power(Times(e, Power(x, r)), CN1)))), Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), p), Power(Times(d, r), CN1)), x)), Dist(Times(b, n, p, Power(Times(d, r), CN1)), Int(Times(Log(Plus(C1, Times(d, Power(Times(e, Power(x, r)), CN1)))), Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), Subtract(p, C1)), Power(x, CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, n, r), x), IGtQ(p, C0))));
            IIntegrate(2346, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(x_, CN1), Power(Plus(d_, Times(e_DEFAULT, x_)), q_DEFAULT)), x_Symbol),
                    Condition(Plus(Dist(d, Int(Times(Power(Plus(d, Times(e, x)), Subtract(q, C1)), Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), p), Power(x, CN1)), x), x), Dist(e, Int(Times(Power(Plus(d, Times(e, x)), Subtract(q, C1)), Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), p)), x), x)), And(FreeQ(List(a, b, c, d, e, n), x), IGtQ(p, C0), GtQ(q, C0), IntegerQ(Times(C2, q)))));
            IIntegrate(2347, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(x_, CN1), Power(Plus(d_, Times(e_DEFAULT, x_)), q_)), x_Symbol),
                    Condition(Subtract(Dist(Power(d, CN1), Int(Times(Power(Plus(d, Times(e, x)), Plus(q, C1)), Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), p), Power(x, CN1)), x), x), Dist(Times(e, Power(d, CN1)), Int(Times(Power(Plus(d, Times(e, x)), q), Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), p)), x), x)), And(FreeQ(List(a, b, c, d, e, n), x), IGtQ(p, C0), LtQ(q, CN1), IntegerQ(Times(C2, q)))));
            IIntegrate(2348, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), Power(x_, CN1), Power(Plus(d_, Times(e_DEFAULT, Power(x_, r_DEFAULT))), q_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Times(Power(Plus(d, Times(e, Power(x, r))), q), Power(x, CN1)), x))), Subtract(Simp(Times(u, Plus(a, Times(b, Log(Times(c, Power(x, n)))))), x), Dist(Times(b, n), Int(Dist(Power(x, CN1), u, x), x), x))), And(FreeQ(List(a, b, c, d, e, n, r), x), IntegerQ(Subtract(q, C1D2)))));
            IIntegrate(2349, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(x_, CN1), Power(Plus(d_, Times(e_DEFAULT, Power(x_, r_DEFAULT))), q_)), x_Symbol),
                    Condition(Subtract(Dist(Power(d, CN1), Int(Times(Power(Plus(d, Times(e, Power(x, r))), Plus(q, C1)), Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), p), Power(x, CN1)), x), x), Dist(Times(e, Power(d, CN1)), Int(Times(Power(x, Subtract(r, C1)), Power(Plus(d, Times(e, Power(x, r))), q), Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), p)), x), x)), And(FreeQ(List(a, b, c, d, e, n, r), x), IGtQ(p, C0), ILtQ(q, CN1))));
            IIntegrate(2350, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, r_DEFAULT))), q_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Power(x, r))), q)), x))), Condition(Subtract(Dist(Plus(a, Times(b, Log(Times(c, Power(x, n))))), u, x), Dist(Times(b, n), Int(SimplifyIntegrand(Times(u, Power(x, CN1)), x), x), x)), Or(And(Or(EqQ(r, C1), EqQ(r, C2)), IntegerQ(m), IntegerQ(Subtract(q, C1D2))), InverseFunctionFreeQ(u, x)))), And(FreeQ(List(a, b, c, d, e, f, m, n, q, r), x), IntegerQ(Times(C2, q)), Or(And(IntegerQ(m), IntegerQ(r)), IGtQ(q, C0)))));
        }
    }
}
