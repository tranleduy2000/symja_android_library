package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.ASymbol;
import static org.matheclipse.core.expression.F.A_;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.BSymbol;
import static org.matheclipse.core.expression.F.B_DEFAULT;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
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
import static org.matheclipse.core.expression.F.Simplify;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
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
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.g_DEFAULT;
import static org.matheclipse.core.expression.F.m;
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
import static org.matheclipse.core.expression.F.r_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NegQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules58 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(1451, Int(Times(Power(Plus(a_, Times(c_DEFAULT, Power(x_, n_DEFAULT)), Times(b_DEFAULT, Power(x_, $p("mn")))), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(b, Times(a, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p), Power(Power(x, Times(n, p)), CN1)), x), And(FreeQ(List(a, b, c, d, e, n, q), x), EqQ($s("mn"), Negate(n)), IntegerQ(p))));
            IIntegrate(1452, Int(Times(Power(Plus(a_, Times(c_DEFAULT, Power(x_, n_DEFAULT)), Times(b_DEFAULT, Power(x_, $p("mn")))), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(x, Times(n, FracPart(p))), Power(Plus(a, Times(b, Power(Power(x, n), CN1)), Times(c, Power(x, n))), FracPart(p)), Power(Power(Plus(b, Times(a, Power(x, n)), Times(c, Power(x, Times(C2, n)))), FracPart(p)), CN1)), Int(Times(Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(b, Times(a, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p), Power(Power(x, Times(n, p)), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, n, p, q), x), EqQ($s("mn"), Negate(n)), Not(IntegerQ(p)))));
            IIntegrate(1453, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT), Power(Plus(f_, Times(g_DEFAULT, Power(x_, n_))), r_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_)), Times(c_DEFAULT, Power(x_, $p("n2")))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), FracPart(p)), Power(Times(Power(Times(C4, c), IntPart(p)), Power(Plus(b, Times(C2, c, Power(x, n))), Times(C2, FracPart(p)))), CN1)), Int(Times(Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(f, Times(g, Power(x, n))), r), Power(Plus(b, Times(C2, c, Power(x, n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, f, g, n, p, q, r), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(p)))));
            IIntegrate(1454, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT), Power(Plus(f_, Times(g_DEFAULT, Power(x_, n_))), r_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_)), Times(c_DEFAULT, Power(x_, $p("n2")))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Plus(d, Times(e, Power(x, n))), Plus(p, q)), Power(Plus(f, Times(g, Power(x, n))), r), Power(Plus(Times(a, Power(d, CN1)), Times(c, Power(x, n), Power(e, CN1))), p)), x), And(FreeQ(List(a, b, c, d, e, f, g, n, q, r), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), IntegerQ(p))));
            IIntegrate(1455, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT), Power(Plus(f_, Times(g_DEFAULT, Power(x_, n_))), r_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2")))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Plus(d, Times(e, Power(x, n))), Plus(p, q)), Power(Plus(f, Times(g, Power(x, n))), r), Power(Plus(Times(a, Power(d, CN1)), Times(c, Power(x, n), Power(e, CN1))), p)), x), And(FreeQ(List(a, c, d, e, f, g, n, q, r), x), EqQ($s("n2"), Times(C2, n)), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), IntegerQ(p))));
            IIntegrate(1456, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT), Power(Plus(f_, Times(g_DEFAULT, Power(x_, n_))), r_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_)), Times(c_DEFAULT, Power(x_, $p("n2")))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), FracPart(p)), Power(Times(Power(Plus(d, Times(e, Power(x, n))), FracPart(p)), Power(Plus(Times(a, Power(d, CN1)), Times(c, Power(x, n), Power(e, CN1))), FracPart(p))), CN1)), Int(Times(Power(Plus(d, Times(e, Power(x, n))), Plus(p, q)), Power(Plus(f, Times(g, Power(x, n))), r), Power(Plus(Times(a, Power(d, CN1)), Times(c, Power(x, n), Power(e, CN1))), p)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, n, p, q, r), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), Not(IntegerQ(p)))));
            IIntegrate(1457, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT), Power(Plus(f_, Times(g_DEFAULT, Power(x_, n_))), r_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2")))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(c, Power(x, Times(C2, n)))), FracPart(p)), Power(Times(Power(Plus(d, Times(e, Power(x, n))), FracPart(p)), Power(Plus(Times(a, Power(d, CN1)), Times(c, Power(x, n), Power(e, CN1))), FracPart(p))), CN1)), Int(Times(Power(Plus(d, Times(e, Power(x, n))), Plus(p, q)), Power(Plus(f, Times(g, Power(x, n))), r), Power(Plus(Times(a, Power(d, CN1)), Times(c, Power(x, n), Power(e, CN1))), p)), x), x), And(FreeQ(List(a, c, d, e, f, g, n, p, q, r), x), EqQ($s("n2"), Times(C2, n)), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IntegerQ(p)))));
            IIntegrate(1458, Int(Times(Power(Plus($p("d1"), Times($p("e1", true), Power(x_, $p("non2", true)))), q_DEFAULT), Power(Plus($p("d2"), Times($p("e2", true), Power(x_, $p("non2", true)))), q_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_)), Times(c_DEFAULT, Power(x_, $p("n2")))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Plus(Times($s("d1"), $s("d2")), Times($s("e1"), $s("e2"), Power(x, n))), q), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p)), x), And(FreeQ(List(a, b, c, $s("d1"), $s("e1"), $s("d2"), $s("e2"), n, p, q), x), EqQ($s("n2"), Times(C2, n)), EqQ($s("non2"), Times(C1D2, n)), EqQ(Plus(Times($s("d2"), $s("e1")), Times($s("d1"), $s("e2"))), C0), Or(IntegerQ(q), And(GtQ($s("d1"), C0), GtQ($s("d2"), C0))))));
            IIntegrate(1459, Int(Times(Power(Plus($p("d1"), Times($p("e1", true), Power(x_, $p("non2", true)))), q_DEFAULT), Power(Plus($p("d2"), Times($p("e2", true), Power(x_, $p("non2", true)))), q_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_)), Times(c_DEFAULT, Power(x_, $p("n2")))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Plus($s("d1"), Times($s("e1"), Power(x, Times(C1D2, n)))), FracPart(q)), Power(Plus($s("d2"), Times($s("e2"), Power(x, Times(C1D2, n)))), FracPart(q)), Power(Power(Plus(Times($s("d1"), $s("d2")), Times($s("e1"), $s("e2"), Power(x, n))), FracPart(q)), CN1)), Int(Times(Power(Plus(Times($s("d1"), $s("d2")), Times($s("e1"), $s("e2"), Power(x, n))), q), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p)), x), x), And(FreeQ(List(a, b, c, $s("d1"), $s("e1"), $s("d2"), $s("e2"), n, p, q), x), EqQ($s("n2"), Times(C2, n)), EqQ($s("non2"), Times(C1D2, n)), EqQ(Plus(Times($s("d2"), $s("e1")), Times($s("d1"), $s("e2"))), C0))));
            IIntegrate(1460, Int(Times(Plus(A_, Times(B_DEFAULT, Power(x_, m_DEFAULT))), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_)), Times(c_DEFAULT, Power(x_, $p("n2")))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Dist(ASymbol, Int(Times(Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p)), x), x), Dist(BSymbol, Int(Times(Power(x, m), Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p)), x), x)), And(FreeQ(List(a, b, c, d, e, ASymbol, BSymbol, m, n, p, q), x), EqQ($s("n2"), Times(C2, n)), EqQ(Plus(m, Negate(n), C1), C0))));
            IIntegrate(1461, Int(Times(Plus(A_, Times(B_DEFAULT, Power(x_, m_DEFAULT))), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2")))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Dist(ASymbol, Int(Times(Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), p)), x), x), Dist(BSymbol, Int(Times(Power(x, m), Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), p)), x), x)), And(FreeQ(List(a, c, d, e, ASymbol, BSymbol, m, n, p, q), x), EqQ($s("n2"), Times(C2, n)), EqQ(Plus(m, Negate(n), C1), C0))));
            IIntegrate(1462, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Times(e_DEFAULT, Power(x_, n_)), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(f, m), Power(Times(n, Power(e, Subtract(Times(Plus(m, C1), Power(n, CN1)), C1))), CN1)), Subst(Int(Times(Power(Times(e, x), Subtract(Plus(q, Times(Plus(m, C1), Power(n, CN1))), C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), x, Power(x, n)), x), And(FreeQ(List(a, b, c, e, f, m, n, p, q), x), EqQ($s("n2"), Times(C2, n)), Or(IntegerQ(m), GtQ(f, C0)), IntegerQ(Simplify(Times(Plus(m, C1), Power(n, CN1)))))));
            IIntegrate(1463, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Times(e_DEFAULT, Power(x_, n_)), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(f, m), Power(Times(n, Power(e, Subtract(Times(Plus(m, C1), Power(n, CN1)), C1))), CN1)), Subst(Int(Times(Power(Times(e, x), Subtract(Plus(q, Times(Plus(m, C1), Power(n, CN1))), C1)), Power(Plus(a, Times(c, Sqr(x))), p)), x), x, Power(x, n)), x), And(FreeQ(List(a, c, e, f, m, n, p, q), x), EqQ($s("n2"), Times(C2, n)), Or(IntegerQ(m), GtQ(f, C0)), IntegerQ(Simplify(Times(Plus(m, C1), Power(n, CN1)))))));
            IIntegrate(1464, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Times(e_DEFAULT, Power(x_, n_)), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(f, m), Power(e, IntPart(q)), Power(Times(e, Power(x, n)), FracPart(q)), Power(Power(x, Times(n, FracPart(q))), CN1)), Int(Times(Power(x, Plus(m, Times(n, q))), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p)), x), x), And(FreeQ(List(a, b, c, e, f, m, n, p, q), x), EqQ($s("n2"), Times(C2, n)), Or(IntegerQ(m), GtQ(f, C0)), Not(IntegerQ(Simplify(Times(Plus(m, C1), Power(n, CN1))))))));
            IIntegrate(1465, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Times(e_DEFAULT, Power(x_, n_)), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(f, m), Power(e, IntPart(q)), Power(Times(e, Power(x, n)), FracPart(q)), Power(Power(x, Times(n, FracPart(q))), CN1)), Int(Times(Power(x, Plus(m, Times(n, q))), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), p)), x), x), And(FreeQ(List(a, c, e, f, m, n, p, q), x), EqQ($s("n2"), Times(C2, n)), Or(IntegerQ(m), GtQ(f, C0)), Not(IntegerQ(Simplify(Times(Plus(m, C1), Power(n, CN1))))))));
            IIntegrate(1466, Int(Times(Power(Times(f_, x_), m_DEFAULT), Power(Times(e_DEFAULT, Power(x_, n_)), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(f, IntPart(m)), Power(Times(f, x), FracPart(m)), Power(Power(x, FracPart(m)), CN1)), Int(Times(Power(x, m), Power(Times(e, Power(x, n)), q), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p)), x), x), And(FreeQ(List(a, b, c, e, f, m, n, p, q), x), EqQ($s("n2"), Times(C2, n)), Not(IntegerQ(m)))));
            IIntegrate(1467, Int(Times(Power(Times(f_, x_), m_DEFAULT), Power(Times(e_DEFAULT, Power(x_, n_)), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(f, IntPart(m)), Power(Times(f, x), FracPart(m)), Power(Power(x, FracPart(m)), CN1)), Int(Times(Power(x, m), Power(Times(e, Power(x, n)), q), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), p)), x), x), And(FreeQ(List(a, c, e, f, m, n, p, q), x), EqQ($s("n2"), Times(C2, n)), Not(IntegerQ(m)))));
            IIntegrate(1468, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(n, CN1), Subst(Int(Times(Power(Plus(d, Times(e, x)), q), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), x, Power(x, n)), x), And(FreeQ(List(a, b, c, d, e, m, n, p, q), x), EqQ($s("n2"), Times(C2, n)), EqQ(Simplify(Plus(m, Negate(n), C1)), C0))));
            IIntegrate(1469, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(n, CN1), Subst(Int(Times(Power(Plus(d, Times(e, x)), q), Power(Plus(a, Times(c, Sqr(x))), p)), x), x, Power(x, n)), x), And(FreeQ(List(a, c, d, e, m, n, p, q), x), EqQ($s("n2"), Times(C2, n)), EqQ(Simplify(Plus(m, Negate(n), C1)), C0))));
            IIntegrate(1470, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(x, Plus(m, Times(n, Plus(Times(C2, p), q)))), Power(Plus(e, Times(d, Power(Power(x, n), CN1))), q), Power(Plus(c, Times(b, Power(Power(x, n), CN1)), Times(a, Power(Power(x, Times(C2, n)), CN1))), p)), x), And(FreeQ(List(a, b, c, d, e, m, n), x), EqQ($s("n2"), Times(C2, n)), IntegersQ(p, q), NegQ(n))));
            IIntegrate(1471, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(x, Plus(m, Times(n, Plus(Times(C2, p), q)))), Power(Plus(e, Times(d, Power(Power(x, n), CN1))), q), Power(Plus(c, Times(a, Power(Power(x, Times(C2, n)), CN1))), p)), x), And(FreeQ(List(a, c, d, e, m, n), x), EqQ($s("n2"), Times(C2, n)), IntegersQ(p, q), NegQ(n))));
            IIntegrate(1472, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(n, CN1), Subst(Int(Times(Power(x, Subtract(Times(Plus(m, C1), Power(n, CN1)), C1)), Power(Plus(d, Times(e, x)), q), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), x, Power(x, n)), x), And(FreeQ(List(a, b, c, d, e, p, q), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(p)), IGtQ(m, C0), IGtQ(n, C0), IGtQ(Times(Plus(m, C1), Power(n, CN1)), C0))));
            IIntegrate(1473, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), FracPart(p)), Power(Times(Power(c, IntPart(p)), Power(Plus(Times(C1D2, b), Times(c, Power(x, n))), Times(C2, FracPart(p)))), CN1)), Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(Times(C1D2, b), Times(c, Power(x, n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, f, m, n, p, q), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(p)))));
            IIntegrate(1474, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(n, CN1), Subst(Int(Times(Power(x, Subtract(Simplify(Times(Plus(m, C1), Power(n, CN1))), C1)), Power(Plus(d, Times(e, x)), q), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), x, Power(x, n)), x), And(FreeQ(List(a, b, c, d, e, m, n, p, q), x), EqQ($s("n2"), Times(C2, n)), IntegerQ(Simplify(Times(Plus(m, C1), Power(n, CN1)))))));
            IIntegrate(1475, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(n, CN1), Subst(Int(Times(Power(x, Subtract(Simplify(Times(Plus(m, C1), Power(n, CN1))), C1)), Power(Plus(d, Times(e, x)), q), Power(Plus(a, Times(c, Sqr(x))), p)), x), x, Power(x, n)), x), And(FreeQ(List(a, c, d, e, m, n, p, q), x), EqQ($s("n2"), Times(C2, n)), IntegerQ(Simplify(Times(Plus(m, C1), Power(n, CN1)))))));
        }
    }
}
