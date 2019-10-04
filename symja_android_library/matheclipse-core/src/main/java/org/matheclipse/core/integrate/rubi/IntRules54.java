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
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.GCD;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Simplify;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.Unequal;
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
import static org.matheclipse.core.expression.F.k;
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
import static org.matheclipse.core.expression.F.r;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NegQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PolynomialDivide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules54 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(1351, Int(Power(Plus(a_, Times(c_DEFAULT, Power(x_, n_DEFAULT)), Times(b_DEFAULT, Power(x_, $p("mn")))), p_), x_Symbol),
                    Condition(Dist(Times(Power(x, Times(n, FracPart(p))), Power(Plus(a, Times(b, Power(Power(x, n), CN1)), Times(c, Power(x, n))), FracPart(p)), Power(Power(Plus(b, Times(a, Power(x, n)), Times(c, Power(x, Times(C2, n)))), FracPart(p)), CN1)), Int(Times(Power(Plus(b, Times(a, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p), Power(Power(x, Times(n, p)), CN1)), x), x), And(FreeQ(List(a, b, c, n, p), x), EqQ($s("mn"), Negate(n)), Not(IntegerQ(p)), PosQ(n))));
            IIntegrate(1352, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(n, CN1), Subst(Int(Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p), x), x, Power(x, n)), x), And(FreeQ(List(a, b, c, m, n, p), x), EqQ($s("n2"), Times(C2, n)), EqQ(Simplify(Plus(m, Negate(n), C1)), C0))));
            IIntegrate(1353, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Times(d, x), m), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p)), x), x), And(FreeQ(List(a, b, c, d, m, n), x), EqQ($s("n2"), Times(C2, n)), IGtQ(p, C0), Not(IntegerQ(Simplify(Times(Plus(m, C1), Power(n, CN1))))))));
            IIntegrate(1354, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Int(Times(Power(x, Plus(m, Times(C2, n, p))), Power(Plus(c, Times(b, Power(Power(x, n), CN1)), Times(a, Power(Power(x, Times(C2, n)), CN1))), p)), x), And(FreeQ(List(a, b, c, m, n), x), EqQ($s("n2"), Times(C2, n)), ILtQ(p, C0), NegQ(n))));
            IIntegrate(1355, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_DEFAULT)), Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), FracPart(p)), Power(Times(Power(c, IntPart(p)), Power(Plus(Times(C1D2, b), Times(c, Power(x, n))), Times(C2, FracPart(p)))), CN1)), Int(Times(Power(Times(d, x), m), Power(Plus(Times(C1D2, b), Times(c, Power(x, n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, m, n, p), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(Subtract(p, C1D2)))));
            IIntegrate(1356, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_DEFAULT)), Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(a, IntPart(p)), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), FracPart(p)), Power(Power(Plus(C1, Times(C2, c, Power(x, n), Power(b, CN1))), Times(C2, FracPart(p))), CN1)), Int(Times(Power(Times(d, x), m), Power(Plus(C1, Times(C2, c, Power(x, n), Power(b, CN1))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, m, n, p), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(Times(C2, p))))));
            IIntegrate(1357, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(n, CN1), Subst(Int(Times(Power(x, Subtract(Simplify(Times(Plus(m, C1), Power(n, CN1))), C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), x, Power(x, n)), x), And(FreeQ(List(a, b, c, m, n, p), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(Simplify(Times(Plus(m, C1), Power(n, CN1)))))));
            IIntegrate(1358, Int(Times(Power(Times(d_, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(d, IntPart(m)), Power(Times(d, x), FracPart(m)), Power(Power(x, FracPart(m)), CN1)), Int(Times(Power(x, m), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p)), x), x), And(FreeQ(List(a, b, c, d, m, n, p), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(Simplify(Times(Plus(m, C1), Power(n, CN1)))))));
            IIntegrate(1359, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(With(List(Set(k, GCD(Plus(m, C1), n))), Condition(Dist(Power(k, CN1), Subst(Int(Times(Power(x, Subtract(Times(Plus(m, C1), Power(k, CN1)), C1)), Power(Plus(a, Times(b, Power(x, Times(n, Power(k, CN1)))), Times(c, Power(x, Times(C2, n, Power(k, CN1))))), p)), x), x, Power(x, k)), x), Unequal(k, C1))), And(FreeQ(List(a, b, c, p), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0), IntegerQ(m))));
            IIntegrate(1360, Int(Times(Power(Times(d_DEFAULT, x_), m_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(With(List(Set(k, Denominator(m))), Dist(Times(k, Power(d, CN1)), Subst(Int(Times(Power(x, Subtract(Times(k, Plus(m, C1)), C1)), Power(Plus(a, Times(b, Power(x, Times(k, n)), Power(Power(d, n), CN1)), Times(c, Power(x, Times(C2, k, n)), Power(Power(d, Times(C2, n)), CN1))), p)), x), x, Power(Times(d, x), Power(k, CN1))), x)), And(FreeQ(List(a, b, c, d, p), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0), FractionQ(m), IntegerQ(p))));
            IIntegrate(1361, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(d, Subtract(n, C1)), Power(Times(d, x), Plus(m, Negate(n), C1)), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p), Plus(Times(b, n, p), Times(c, Plus(m, Times(n, Subtract(Times(C2, p), C1)), C1), Power(x, n))), Power(Times(c, Plus(m, Times(C2, n, p), C1), Plus(m, Times(n, Subtract(Times(C2, p), C1)), C1)), CN1)), x), Dist(Times(n, p, Power(d, n), Power(Times(c, Plus(m, Times(C2, n, p), C1), Plus(m, Times(n, Subtract(Times(C2, p), C1)), C1)), CN1)), Int(Times(Power(Times(d, x), Subtract(m, n)), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), Subtract(p, C1)), Simp(Subtract(Times(a, b, Plus(m, Negate(n), C1)), Times(Subtract(Times(C2, a, c, Plus(m, Times(n, Subtract(Times(C2, p), C1)), C1)), Times(Sqr(b), Plus(m, Times(n, Subtract(p, C1)), C1))), Power(x, n))), x)), x), x)), And(FreeQ(List(a, b, c, d), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0), IGtQ(p, C0), GtQ(m, Subtract(n, C1)), NeQ(Plus(m, Times(C2, n, p), C1), C0), NeQ(Plus(m, Times(n, Subtract(Times(C2, p), C1)), C1), C0))));
            IIntegrate(1362, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(d, x), Plus(m, C1)), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p), Power(Times(d, Plus(m, C1)), CN1)), x), Dist(Times(n, p, Power(Times(Power(d, n), Plus(m, C1)), CN1)), Int(Times(Power(Times(d, x), Plus(m, n)), Plus(b, Times(C2, c, Power(x, n))), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), Subtract(p, C1))), x), x)), And(FreeQ(List(a, b, c, d), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0), IGtQ(p, C0), LtQ(m, CN1))));
            IIntegrate(1363, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(d, x), Plus(m, C1)), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p), Power(Times(d, Plus(m, Times(C2, n, p), C1)), CN1)), x), Dist(Times(n, p, Power(Plus(m, Times(C2, n, p), C1), CN1)), Int(Times(Power(Times(d, x), m), Plus(Times(C2, a), Times(b, Power(x, n))), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), Subtract(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, m), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0), IGtQ(p, C0), NeQ(Plus(m, Times(C2, n, p), C1), C0))));
            IIntegrate(1364, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(d, Subtract(n, C1)), Power(Times(d, x), Plus(m, Negate(n), C1)), Plus(b, Times(C2, c, Power(x, n))), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), Plus(p, C1)), Power(Times(n, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1)), x), Dist(Times(Power(d, n), Power(Times(n, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1)), Int(Times(Power(Times(d, x), Subtract(m, n)), Plus(Times(b, Plus(m, Negate(n), C1)), Times(C2, c, Plus(m, Times(C2, n, Plus(p, C1)), C1), Power(x, n))), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, c, d), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0), ILtQ(p, CN1), GtQ(m, Subtract(n, C1)), LeQ(m, Subtract(Times(C2, n), C1)))));
            IIntegrate(1365, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(d, Subtract(Times(C2, n), C1)), Power(Times(d, x), Plus(m, Times(CN1, C2, n), C1)), Plus(Times(C2, a), Times(b, Power(x, n))), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), Plus(p, C1)), Power(Times(n, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1)), x)), Dist(Times(Power(d, Times(C2, n)), Power(Times(n, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1)), Int(Times(Power(Times(d, x), Subtract(m, Times(C2, n))), Plus(Times(C2, a, Plus(m, Times(CN1, C2, n), C1)), Times(b, Plus(m, Times(n, Plus(Times(C2, p), C1)), C1), Power(x, n))), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, c, d), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0), ILtQ(p, CN1), GtQ(m, Subtract(Times(C2, n), C1)))));
            IIntegrate(1366, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Times(d, x), Plus(m, C1)), Plus(Sqr(b), Times(CN1, C2, a, c), Times(b, c, Power(x, n))), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), Plus(p, C1)), Power(Times(a, d, n, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1)), x)), Dist(Power(Times(a, n, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1), Int(Times(Power(Times(d, x), m), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), Plus(p, C1)), Simp(Plus(Times(Sqr(b), Plus(m, Times(n, Plus(p, C1)), C1)), Times(CN1, C2, a, c, Plus(m, Times(C2, n, Plus(p, C1)), C1)), Times(b, c, Plus(m, Times(n, Plus(Times(C2, p), C3)), C1), Power(x, n))), x)), x), x)), And(FreeQ(List(a, b, c, d, m), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0), ILtQ(p, CN1))));
            IIntegrate(1367, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(d, Subtract(Times(C2, n), C1)), Power(Times(d, x), Plus(m, Times(CN1, C2, n), C1)), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), Plus(p, C1)), Power(Times(c, Plus(m, Times(C2, n, p), C1)), CN1)), x), Dist(Times(Power(d, Times(C2, n)), Power(Times(c, Plus(m, Times(C2, n, p), C1)), CN1)), Int(Times(Power(Times(d, x), Subtract(m, Times(C2, n))), Simp(Plus(Times(a, Plus(m, Times(CN1, C2, n), C1)), Times(b, Plus(m, Times(n, Subtract(p, C1)), C1), Power(x, n))), x), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p)), x), x)), And(FreeQ(List(a, b, c, d, p), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0), GtQ(m, Subtract(Times(C2, n), C1)), NeQ(Plus(m, Times(C2, n, p), C1), C0), IntegerQ(p))));
            IIntegrate(1368, Int(Times(Power(Times(d_DEFAULT, x_), m_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(d, x), Plus(m, C1)), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), Plus(p, C1)), Power(Times(a, d, Plus(m, C1)), CN1)), x), Dist(Power(Times(a, Power(d, n), Plus(m, C1)), CN1), Int(Times(Power(Times(d, x), Plus(m, n)), Plus(Times(b, Plus(m, Times(n, Plus(p, C1)), C1)), Times(c, Plus(m, Times(C2, n, Plus(p, C1)), C1), Power(x, n))), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p)), x), x)), And(FreeQ(List(a, b, c, d, p), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0), LtQ(m, CN1), IntegerQ(p))));
            IIntegrate(1369, Int(Times(Power(Times(d_DEFAULT, x_), m_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(d, x), Plus(m, C1)), Power(Times(a, d, Plus(m, C1)), CN1)), x), Dist(Power(Times(a, Power(d, n)), CN1), Int(Times(Power(Times(d, x), Plus(m, n)), Plus(b, Times(c, Power(x, n))), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), CN1)), x), x)), And(FreeQ(List(a, b, c, d), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0), LtQ(m, CN1))));
            IIntegrate(1370, Int(Times(Power(x_, m_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), CN1)), x_Symbol),
                    Condition(Int(PolynomialDivide(Power(x, m), Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), x), x), And(FreeQ(List(a, b, c), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0), IGtQ(m, Subtract(Times(C3, n), C1)))));
            IIntegrate(1371, Int(Times(Power(Times(d_DEFAULT, x_), m_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(d, Subtract(Times(C2, n), C1)), Power(Times(d, x), Plus(m, Times(CN1, C2, n), C1)), Power(Times(c, Plus(m, Times(CN1, C2, n), C1)), CN1)), x), Dist(Times(Power(d, Times(C2, n)), Power(c, CN1)), Int(Times(Power(Times(d, x), Subtract(m, Times(C2, n))), Plus(a, Times(b, Power(x, n))), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), CN1)), x), x)), And(FreeQ(List(a, b, c, d), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0), GtQ(m, Subtract(Times(C2, n), C1)))));
            IIntegrate(1372, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(a, Power(c, CN1)), C2))), With(List(Set(r, Rt(Subtract(Times(C2, q), Times(b, Power(c, CN1))), C2))), Plus(Negate(Dist(Power(Times(C2, c, r), CN1), Int(Times(Power(x, Subtract(m, Times(C3, C1D2, n))), Subtract(q, Times(r, Power(x, Times(C1D2, n)))), Power(Plus(q, Times(CN1, r, Power(x, Times(C1D2, n))), Power(x, n)), CN1)), x), x)), Dist(Power(Times(C2, c, r), CN1), Int(Times(Power(x, Subtract(m, Times(C3, C1D2, n))), Plus(q, Times(r, Power(x, Times(C1D2, n)))), Power(Plus(q, Times(r, Power(x, Times(C1D2, n))), Power(x, n)), CN1)), x), x)))), And(FreeQ(List(a, b, c), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(Times(C1D2, n), C0), IGtQ(m, C0), GeQ(m, Times(C1D2, C3, n)), LtQ(m, Times(C2, n)), NegQ(Subtract(Sqr(b), Times(C4, a, c))))));
            IIntegrate(1373, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(a, Power(c, CN1)), C2))), With(List(Set(r, Rt(Subtract(Times(C2, q), Times(b, Power(c, CN1))), C2))), Subtract(Dist(Power(Times(C2, c, r), CN1), Int(Times(Power(x, Subtract(m, Times(C1D2, n))), Power(Plus(q, Times(CN1, r, Power(x, Times(C1D2, n))), Power(x, n)), CN1)), x), x), Dist(Power(Times(C2, c, r), CN1), Int(Times(Power(x, Subtract(m, Times(C1D2, n))), Power(Plus(q, Times(r, Power(x, Times(C1D2, n))), Power(x, n)), CN1)), x), x)))), And(FreeQ(List(a, b, c), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(Times(C1D2, n), C0), IGtQ(m, C0), GeQ(m, Times(C1D2, n)), LtQ(m, Times(C1D2, C3, n)), NegQ(Subtract(Sqr(b), Times(C4, a, c))))));
            IIntegrate(1374, Int(Times(Power(Times(d_DEFAULT, x_), m_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Subtract(Dist(Times(C1D2, Power(d, n), Plus(Times(b, Power(q, CN1)), C1)), Int(Times(Power(Times(d, x), Subtract(m, n)), Power(Plus(Times(C1D2, b), Times(C1D2, q), Times(c, Power(x, n))), CN1)), x), x), Dist(Times(C1D2, Power(d, n), Subtract(Times(b, Power(q, CN1)), C1)), Int(Times(Power(Times(d, x), Subtract(m, n)), Power(Plus(Times(C1D2, b), Times(CN1, C1D2, q), Times(c, Power(x, n))), CN1)), x), x))), And(FreeQ(List(a, b, c, d), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0), GeQ(m, n))));
            IIntegrate(1375, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Subtract(Dist(Times(c, Power(q, CN1)), Int(Times(Power(Times(d, x), m), Power(Plus(Times(C1D2, b), Times(CN1, C1D2, q), Times(c, Power(x, n))), CN1)), x), x), Dist(Times(c, Power(q, CN1)), Int(Times(Power(Times(d, x), m), Power(Plus(Times(C1D2, b), Times(C1D2, q), Times(c, Power(x, n))), CN1)), x), x))), And(FreeQ(List(a, b, c, d, m), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0))));
        }
    }
}
