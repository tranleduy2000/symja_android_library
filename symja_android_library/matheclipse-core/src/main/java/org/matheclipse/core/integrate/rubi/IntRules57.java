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
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
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
public class IntRules57 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(1426, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_)), Times(c_DEFAULT, Power(x_, $p("n2")))), CN1)), x_Symbol),
                    Condition(Plus(Dist(Times(Sqr(e), Power(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), CN1)), Int(Power(Plus(d, Times(e, Power(x, n))), q), x), x), Dist(Power(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), CN1), Int(Times(Power(Plus(d, Times(e, Power(x, n))), Plus(q, C1)), Subtract(Subtract(Times(c, d), Times(b, e)), Times(c, e, Power(x, n))), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, n), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), Not(IntegerQ(q)), LtQ(q, CN1))));
            IIntegrate(1427, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2")))), CN1)), x_Symbol),
                    Condition(Plus(Dist(Times(Sqr(e), Power(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1)), Int(Power(Plus(d, Times(e, Power(x, n))), q), x), x), Dist(Times(c, Power(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1)), Int(Times(Power(Plus(d, Times(e, Power(x, n))), Plus(q, C1)), Subtract(d, Times(e, Power(x, n))), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), CN1)), x), x)), And(FreeQ(List(a, c, d, e, n), x), EqQ($s("n2"), Times(C2, n)), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IntegerQ(q)), LtQ(q, CN1))));
            IIntegrate(1428, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_)), Times(c_DEFAULT, Power(x_, $p("n2")))), CN1)), x_Symbol),
                    Condition(With(List(Set(r, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Subtract(Dist(Times(C2, c, Power(r, CN1)), Int(Times(Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(b, Negate(r), Times(C2, c, Power(x, n))), CN1)), x), x), Dist(Times(C2, c, Power(r, CN1)), Int(Times(Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(b, r, Times(C2, c, Power(x, n))), CN1)), x), x))), And(FreeQ(List(a, b, c, d, e, n, q), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), Not(IntegerQ(q)))));
            IIntegrate(1429, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2")))), CN1)), x_Symbol),
                    Condition(With(List(Set(r, Rt(Times(CN1, a, c), C2))), Subtract(Negate(Dist(Times(c, Power(Times(C2, r), CN1)), Int(Times(Power(Plus(d, Times(e, Power(x, n))), q), Power(Subtract(r, Times(c, Power(x, n))), CN1)), x), x)), Dist(Times(c, Power(Times(C2, r), CN1)), Int(Times(Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(r, Times(c, Power(x, n))), CN1)), x), x))), And(FreeQ(List(a, c, d, e, n, q), x), EqQ($s("n2"), Times(C2, n)), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IntegerQ(q)))));
            IIntegrate(1430, Int(Times(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_)), Times(c_DEFAULT, Power(x_, $p("n2")))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(x, Plus(Times(d, Sqr(b)), Times(CN1, a, b, e), Times(CN1, C2, a, c, d), Times(Subtract(Times(b, d), Times(C2, a, e)), c, Power(x, n))), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), Plus(p, C1)), Power(Times(a, n, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1)), x)), Dist(Power(Times(a, n, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1), Int(Times(Simp(Plus(Times(Plus(Times(n, p), n, C1), d, Sqr(b)), Times(CN1, a, b, e), Times(CN1, C2, a, c, d, Plus(Times(C2, n, p), Times(C2, n), C1)), Times(Plus(Times(C2, n, p), Times(C3, n), C1), Subtract(Times(d, b), Times(C2, a, e)), c, Power(x, n))), x), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, n), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), ILtQ(p, CN1))));
            IIntegrate(1431, Int(Times(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2")))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(x, Plus(d, Times(e, Power(x, n))), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), Plus(p, C1)), Power(Times(C2, a, n, Plus(p, C1)), CN1)), x)), Dist(Power(Times(C2, a, n, Plus(p, C1)), CN1), Int(Times(Plus(Times(d, Plus(Times(C2, n, p), Times(C2, n), C1)), Times(e, Plus(Times(C2, n, p), Times(C3, n), C1), Power(x, n))), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), Plus(p, C1))), x), x)), And(FreeQ(List(a, c, d, e, n), x), EqQ($s("n2"), Times(C2, n)), ILtQ(p, CN1))));
            IIntegrate(1432, Int(Times(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_)), Times(c_DEFAULT, Power(x_, $p("n2")))), p_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Plus(d, Times(e, Power(x, n))), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p)), x), x), And(FreeQ(List(a, b, c, d, e, n), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(1433, Int(Times(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2")))), p_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Plus(d, Times(e, Power(x, n))), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), p)), x), x), And(FreeQ(List(a, c, d, e, n), x), EqQ($s("n2"), Times(C2, n)))));
            IIntegrate(1434, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_)), Times(c_DEFAULT, Power(x_, $p("n2")))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(c, p), Power(x, Plus(Times(C2, n, p), Negate(n), C1)), Power(Plus(d, Times(e, Power(x, n))), Plus(q, C1)), Power(Times(e, Plus(Times(C2, n, p), Times(n, q), C1)), CN1)), x), Int(Times(Power(Plus(d, Times(e, Power(x, n))), q), ExpandToSum(Subtract(Subtract(Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p), Times(Power(c, p), Power(x, Times(C2, n, p)))), Times(d, Power(c, p), Plus(Times(C2, n, p), Negate(n), C1), Power(x, Subtract(Times(C2, n, p), n)), Power(Times(e, Plus(Times(C2, n, p), Times(n, q), C1)), CN1))), x)), x)), And(FreeQ(List(a, b, c, d, e, n, q), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(p, C0), NeQ(Plus(Times(C2, n, p), Times(n, q), C1), C0), IGtQ(n, C0), Not(IGtQ(q, C0)))));
            IIntegrate(1435, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2")))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(c, p), Power(x, Plus(Times(C2, n, p), Negate(n), C1)), Power(Plus(d, Times(e, Power(x, n))), Plus(q, C1)), Power(Times(e, Plus(Times(C2, n, p), Times(n, q), C1)), CN1)), x), Int(Times(Power(Plus(d, Times(e, Power(x, n))), q), ExpandToSum(Subtract(Subtract(Power(Plus(a, Times(c, Power(x, Times(C2, n)))), p), Times(Power(c, p), Power(x, Times(C2, n, p)))), Times(d, Power(c, p), Plus(Times(C2, n, p), Negate(n), C1), Power(x, Subtract(Times(C2, n, p), n)), Power(Times(e, Plus(Times(C2, n, p), Times(n, q), C1)), CN1))), x)), x)), And(FreeQ(List(a, c, d, e, n, q), x), EqQ($s("n2"), Times(C2, n)), IGtQ(p, C0), NeQ(Plus(Times(C2, n, p), Times(n, q), C1), C0), IGtQ(n, C0), Not(IGtQ(q, C0)))));
            IIntegrate(1436, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_)), Times(c_DEFAULT, Power(x_, $p("n2")))), p_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p)), x), x), And(FreeQ(List(a, b, c, d, e, n, p, q), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), Or(And(IntegersQ(p, q), Not(IntegerQ(n))), IGtQ(p, C0), And(IGtQ(q, C0), Not(IntegerQ(n)))))));
            IIntegrate(1437, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2")))), p_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), p)), x), x), And(FreeQ(List(a, c, d, e, n, p, q), x), EqQ($s("n2"), Times(C2, n)), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Or(And(IntegersQ(p, q), Not(IntegerQ(n))), IGtQ(p, C0), And(IGtQ(q, C0), Not(IntegerQ(n)))))));
            IIntegrate(1438, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2")))), p_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(a, Times(c, Power(x, Times(C2, n)))), p), Power(Subtract(Times(d, Power(Subtract(Sqr(d), Times(Sqr(e), Power(x, Times(C2, n)))), CN1)), Times(e, Power(x, n), Power(Subtract(Sqr(d), Times(Sqr(e), Power(x, Times(C2, n)))), CN1))), Negate(q)), x), x), And(FreeQ(List(a, c, d, e, n, p), x), EqQ($s("n2"), Times(C2, n)), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IntegerQ(p)), ILtQ(q, C0))));
            IIntegrate(1439, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_)), Times(c_DEFAULT, Power(x_, $p("n2")))), p_)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p)), x), And(FreeQ(List(a, b, c, d, e, n, p, q), x), EqQ($s("n2"), Times(C2, n)))));
            IIntegrate(1440, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2")))), p_)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), p)), x), And(FreeQ(List(a, c, d, e, n, p, q), x), EqQ($s("n2"), Times(C2, n)))));
            IIntegrate(1441, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(u_, n_))), q_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(u_, n_)), Times(c_DEFAULT, Power(u_, $p("n2")))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Coefficient(u, x, C1), CN1), Subst(Int(Times(Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p)), x), x, u), x), And(FreeQ(List(a, b, c, d, e, n, p, q), x), EqQ($s("n2"), Times(C2, n)), LinearQ(u, x), NeQ(u, x))));
            IIntegrate(1442, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(u_, n_))), q_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(u_, $p("n2")))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Coefficient(u, x, C1), CN1), Subst(Int(Times(Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), p)), x), x, u), x), And(FreeQ(List(a, c, d, e, n, p, q), x), EqQ($s("n2"), Times(C2, n)), LinearQ(u, x), NeQ(u, x))));
            IIntegrate(1443, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(x_, $p("mn", true)))), q_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT)), Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Plus(e, Times(d, Power(x, n))), q), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p), Power(Power(x, Times(n, q)), CN1)), x), And(FreeQ(List(a, b, c, d, e, n, p), x), EqQ($s("n2"), Times(C2, n)), EqQ($s("mn"), Negate(n)), IntegerQ(q), Or(PosQ(n), Not(IntegerQ(p))))));
            IIntegrate(1444, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(x_, $p("mn", true)))), q_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(x, Times($s("mn"), q)), Power(Plus(e, Times(d, Power(Power(x, $s("mn")), CN1))), q), Power(Plus(a, Times(c, Power(x, $s("n2")))), p)), x), And(FreeQ(List(a, c, d, e, $s("mn"), p), x), EqQ($s("n2"), Times(CN2, $s("mn"))), IntegerQ(q), Or(PosQ($s("n2")), Not(IntegerQ(p))))));
            IIntegrate(1445, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, $p("mn", true))), Times(c_DEFAULT, Power(x_, $p("mn2", true)))), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_DEFAULT))), q_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(c, Times(b, Power(x, n)), Times(a, Power(x, Times(C2, n)))), p), Power(Power(x, Times(C2, n, p)), CN1)), x), And(FreeQ(List(a, b, c, d, e, n, q), x), EqQ($s("mn"), Negate(n)), EqQ($s("mn2"), Times(C2, $s("mn"))), IntegerQ(p))));
            IIntegrate(1446, Int(Times(Power(Plus(a_DEFAULT, Times(c_DEFAULT, Power(x_, $p("mn2", true)))), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_DEFAULT))), q_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(c, Times(a, Power(x, Times(C2, n)))), p), Power(Power(x, Times(C2, n, p)), CN1)), x), And(FreeQ(List(a, c, d, e, n, q), x), EqQ($s("mn2"), Times(CN2, n)), IntegerQ(p))));
            IIntegrate(1447, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(x_, $p("mn", true)))), q_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT)), Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(e, IntPart(q)), Power(x, Times(n, FracPart(q))), Power(Plus(d, Times(e, Power(Power(x, n), CN1))), FracPart(q)), Power(Power(Plus(C1, Times(d, Power(x, n), Power(e, CN1))), FracPart(q)), CN1)), Int(Times(Power(Plus(C1, Times(d, Power(x, n), Power(e, CN1))), q), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p), Power(Power(x, Times(n, q)), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, n, p, q), x), EqQ($s("n2"), Times(C2, n)), EqQ($s("mn"), Negate(n)), Not(IntegerQ(p)), Not(IntegerQ(q)), PosQ(n))));
            IIntegrate(1448, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(x_, $p("mn", true)))), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(e, IntPart(q)), Power(Plus(d, Times(e, Power(x, $s("mn")))), FracPart(q)), Power(Times(Power(x, Times($s("mn"), FracPart(q))), Power(Plus(C1, Times(d, Power(Times(Power(x, $s("mn")), e), CN1))), FracPart(q))), CN1)), Int(Times(Power(x, Times($s("mn"), q)), Power(Plus(C1, Times(d, Power(Times(Power(x, $s("mn")), e), CN1))), q), Power(Plus(a, Times(c, Power(x, $s("n2")))), p)), x), x), And(FreeQ(List(a, c, d, e, $s("mn"), p, q), x), EqQ($s("n2"), Times(CN2, $s("mn"))), Not(IntegerQ(p)), Not(IntegerQ(q)), PosQ($s("n2")))));
            IIntegrate(1449, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, $p("mn", true))), Times(c_DEFAULT, Power(x_, $p("mn2", true)))), p_), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_DEFAULT))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(x, Times(C2, n, FracPart(p))), Power(Plus(a, Times(b, Power(Power(x, n), CN1)), Times(c, Power(Power(x, Times(C2, n)), CN1))), FracPart(p)), Power(Power(Plus(c, Times(b, Power(x, n)), Times(a, Power(x, Times(C2, n)))), FracPart(p)), CN1)), Int(Times(Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(c, Times(b, Power(x, n)), Times(a, Power(x, Times(C2, n)))), p), Power(Power(x, Times(C2, n, p)), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, n, p, q), x), EqQ($s("mn"), Negate(n)), EqQ($s("mn2"), Times(C2, $s("mn"))), Not(IntegerQ(p)), Not(IntegerQ(q)), PosQ(n))));
            IIntegrate(1450, Int(Times(Power(Plus(a_DEFAULT, Times(c_DEFAULT, Power(x_, $p("mn2", true)))), p_), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_DEFAULT))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(x, Times(C2, n, FracPart(p))), Power(Plus(a, Times(c, Power(Power(x, Times(C2, n)), CN1))), FracPart(p)), Power(Power(Plus(c, Times(a, Power(x, Times(C2, n)))), FracPart(p)), CN1)), Int(Times(Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(c, Times(a, Power(x, Times(C2, n)))), p), Power(Power(x, Times(C2, n, p)), CN1)), x), x), And(FreeQ(List(a, c, d, e, n, p, q), x), EqQ($s("mn2"), Times(CN2, n)), Not(IntegerQ(p)), Not(IntegerQ(q)), PosQ(n))));
        }
    }
}
