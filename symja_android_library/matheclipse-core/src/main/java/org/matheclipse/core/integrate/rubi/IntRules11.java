package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$rubi;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.AtomQ;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C1D4;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CSqrt2;
import static org.matheclipse.core.expression.F.CompoundExpression;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.GCD;
import static org.matheclipse.core.expression.F.Greater;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Module;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Numerator;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Pi;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.QQ;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Sum;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.Unequal;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.k;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.r;
import static org.matheclipse.core.expression.F.s;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntBinomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NegQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SplitProduct;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules11 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(276, Int(Times(Power(x_, m_DEFAULT), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(With(List(Set(k, GCD(Plus(m, C1), Times(C2, n)))), Condition(Dist(Power(k, CN1), Subst(Int(Times(Power(x, Subtract(Times(Plus(m, C1), Power(k, CN1)), C1)), Power(Plus($s("a1"), Times($s("b1"), Power(x, Times(n, Power(k, CN1))))), p), Power(Plus($s("a2"), Times($s("b2"), Power(x, Times(n, Power(k, CN1))))), p)), x), x, Power(x, k)), x), Unequal(k, C1))), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), p), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), IGtQ(Times(C2, n), C0), IntegerQ(m))));
            IIntegrate(277, Int(Times(Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(c, x), Plus(m, C1)), Power(Plus(a, Times(b, Power(x, n))), p), Power(Times(c, Plus(m, C1)), CN1)), x), Dist(Times(b, n, p, Power(Times(Power(c, n), Plus(m, C1)), CN1)), Int(Times(Power(Times(c, x), Plus(m, n)), Power(Plus(a, Times(b, Power(x, n))), Subtract(p, C1))), x), x)), And(FreeQ(List(a, b, c), x), IGtQ(n, C0), GtQ(p, C0), LtQ(m, CN1), Not(ILtQ(Times(Plus(m, Times(n, p), n, C1), Power(n, CN1)), C0)), IntBinomialQ(a, b, c, n, m, p, x))));
            IIntegrate(278, Int(Times(Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(c, x), Plus(m, C1)), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), p), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), p), Power(Times(c, Plus(m, C1)), CN1)), x), Dist(Times(C2, $s("b1"), $s("b2"), n, p, Power(Times(Power(c, Times(C2, n)), Plus(m, C1)), CN1)), Int(Times(Power(Times(c, x), Plus(m, Times(C2, n))), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), Subtract(p, C1)), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), Subtract(p, C1))), x), x)), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), c, m), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), IGtQ(Times(C2, n), C0), GtQ(p, C0), LtQ(m, CN1), NeQ(Plus(m, Times(C2, n, p), C1), C0), IntBinomialQ(Times($s("a1"), $s("a2")), Times($s("b1"), $s("b2")), c, Times(C2, n), m, p, x))));
            IIntegrate(279, Int(Times(Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(c, x), Plus(m, C1)), Power(Plus(a, Times(b, Power(x, n))), p), Power(Times(c, Plus(m, Times(n, p), C1)), CN1)), x), Dist(Times(a, n, p, Power(Plus(m, Times(n, p), C1), CN1)), Int(Times(Power(Times(c, x), m), Power(Plus(a, Times(b, Power(x, n))), Subtract(p, C1))), x), x)), And(FreeQ(List(a, b, c, m), x), IGtQ(n, C0), GtQ(p, C0), NeQ(Plus(m, Times(n, p), C1), C0), IntBinomialQ(a, b, c, n, m, p, x))));
            IIntegrate(280, Int(Times(Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(c, x), Plus(m, C1)), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), p), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), p), Power(Times(c, Plus(m, Times(C2, n, p), C1)), CN1)), x), Dist(Times(C2, $s("a1"), $s("a2"), n, p, Power(Plus(m, Times(C2, n, p), C1), CN1)), Int(Times(Power(Times(c, x), m), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), Subtract(p, C1)), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), Subtract(p, C1))), x), x)), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), c, m), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), IGtQ(Times(C2, n), C0), GtQ(p, C0), NeQ(Plus(m, Times(C2, n, p), C1), C0), IntBinomialQ(Times($s("a1"), $s("a2")), Times($s("b1"), $s("b2")), c, Times(C2, n), m, p, x))));
            IIntegrate(281, Int(Times(Sqr(x_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C4))), QQ(-5L, 4L))), x_Symbol),
                    Condition(Dist(Times(x, Power(Plus(C1, Times(a, Power(Times(b, Power(x, C4)), CN1))), C1D4), Power(Times(b, Power(Plus(a, Times(b, Power(x, C4))), C1D4)), CN1)), Int(Power(Times(Power(x, C3), Power(Plus(C1, Times(a, Power(Times(b, Power(x, C4)), CN1))), QQ(5L, 4L))), CN1), x), x), And(FreeQ(List(a, b), x), PosQ(Times(b, Power(a, CN1))))));
            IIntegrate(282, Int(Times(Power(x_, m_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C4))), QQ(-5L, 4L))), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(x, Subtract(m, C3)), Power(Times(b, Subtract(m, C4), Power(Plus(a, Times(b, Power(x, C4))), C1D4)), CN1)), x), Dist(Times(a, Subtract(m, C3), Power(Times(b, Subtract(m, C4)), CN1)), Int(Times(Power(x, Subtract(m, C4)), Power(Plus(a, Times(b, Power(x, C4))), QQ(-5L, 4L))), x), x)), And(FreeQ(List(a, b), x), PosQ(Times(b, Power(a, CN1))), IGtQ(Times(C1D4, Subtract(m, C2)), C0))));
            IIntegrate(283, Int(Times(Power(x_, m_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C4))), QQ(-5L, 4L))), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(x, Plus(m, C1)), Power(Times(a, Plus(m, C1), Power(Plus(a, Times(b, Power(x, C4))), C1D4)), CN1)), x), Dist(Times(b, m, Power(Times(a, Plus(m, C1)), CN1)), Int(Times(Power(x, Plus(m, C4)), Power(Plus(a, Times(b, Power(x, C4))), QQ(-5L, 4L))), x), x)), And(FreeQ(List(a, b), x), PosQ(Times(b, Power(a, CN1))), ILtQ(Times(C1D4, Subtract(m, C2)), C0))));
            IIntegrate(284, Int(Times(Sqrt(Times(c_DEFAULT, x_)), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), QQ(-5L, 4L))), x_Symbol),
                    Condition(Dist(Times(Sqrt(Times(c, x)), Power(Plus(C1, Times(a, Power(Times(b, Sqr(x)), CN1))), C1D4), Power(Times(b, Power(Plus(a, Times(b, Sqr(x))), C1D4)), CN1)), Int(Power(Times(Sqr(x), Power(Plus(C1, Times(a, Power(Times(b, Sqr(x)), CN1))), QQ(5L, 4L))), CN1), x), x), And(FreeQ(List(a, b, c), x), PosQ(Times(b, Power(a, CN1))))));
            IIntegrate(285, Int(Times(Power(Times(c_DEFAULT, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), QQ(-5L, 4L))), x_Symbol),
                    Condition(Subtract(Simp(Times(C2, c, Power(Times(c, x), Subtract(m, C1)), Power(Times(b, Subtract(Times(C2, m), C3), Power(Plus(a, Times(b, Sqr(x))), C1D4)), CN1)), x), Dist(Times(C2, a, Sqr(c), Subtract(m, C1), Power(Times(b, Subtract(Times(C2, m), C3)), CN1)), Int(Times(Power(Times(c, x), Subtract(m, C2)), Power(Plus(a, Times(b, Sqr(x))), QQ(-5L, 4L))), x), x)), And(FreeQ(List(a, b, c), x), PosQ(Times(b, Power(a, CN1))), IntegerQ(Times(C2, m)), GtQ(m, QQ(3L, 2L)))));
            IIntegrate(286, Int(Times(Power(Times(c_DEFAULT, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), QQ(-5L, 4L))), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(c, x), Plus(m, C1)), Power(Times(a, c, Plus(m, C1), Power(Plus(a, Times(b, Sqr(x))), C1D4)), CN1)), x), Dist(Times(b, Plus(Times(C2, m), C1), Power(Times(C2, a, Sqr(c), Plus(m, C1)), CN1)), Int(Times(Power(Times(c, x), Plus(m, C2)), Power(Plus(a, Times(b, Sqr(x))), QQ(-5L, 4L))), x), x)), And(FreeQ(List(a, b, c), x), PosQ(Times(b, Power(a, CN1))), IntegerQ(Times(C2, m)), LtQ(m, CN1))));
            IIntegrate(287, Int(Times(Sqr(x_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C4))), QQ(-5L, 4L))), x_Symbol),
                    Condition(Subtract(Negate(Simp(Power(Times(b, x, Power(Plus(a, Times(b, Power(x, C4))), C1D4)), CN1), x)), Dist(Power(b, CN1), Int(Power(Times(Sqr(x), Power(Plus(a, Times(b, Power(x, C4))), C1D4)), CN1), x), x)), And(FreeQ(List(a, b), x), NegQ(Times(b, Power(a, CN1))))));
            IIntegrate(288, Int(Times(Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(c, Subtract(n, C1)), Power(Times(c, x), Plus(m, Negate(n), C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Times(b, n, Plus(p, C1)), CN1)), x), Dist(Times(Power(c, n), Plus(m, Negate(n), C1), Power(Times(b, n, Plus(p, C1)), CN1)), Int(Times(Power(Times(c, x), Subtract(m, n)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, c), x), IGtQ(n, C0), LtQ(p, CN1), GtQ(Plus(m, C1), n), Not(ILtQ(Times(Plus(m, Times(n, Plus(p, C1)), C1), Power(n, CN1)), C0)), IntBinomialQ(a, b, c, n, m, p, x))));
            IIntegrate(289, Int(Times(Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(c, Subtract(Times(C2, n), C1)), Power(Times(c, x), Plus(m, Times(CN1, C2, n), C1)), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), Plus(p, C1)), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), Plus(p, C1)), Power(Times(C2, $s("b1"), $s("b2"), n, Plus(p, C1)), CN1)), x), Dist(Times(Power(c, Times(C2, n)), Plus(m, Times(CN1, C2, n), C1), Power(Times(C2, $s("b1"), $s("b2"), n, Plus(p, C1)), CN1)), Int(Times(Power(Times(c, x), Subtract(m, Times(C2, n))), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), Plus(p, C1)), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), Plus(p, C1))), x), x)), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), c), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), IGtQ(Times(C2, n), C0), LtQ(p, CN1), Greater(Plus(m, C1), Times(C2, n)), Not(ILtQ(Times(Plus(m, Times(C2, n, Plus(p, C1)), C1), Power(Times(C2, n), CN1)), C0)), IntBinomialQ(Times($s("a1"), $s("a2")), Times($s("b1"), $s("b2")), c, Times(C2, n), m, p, x))));
            IIntegrate(290, Int(Times(Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Times(c, x), Plus(m, C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Times(a, c, n, Plus(p, C1)), CN1)), x)), Dist(Times(Plus(m, Times(n, Plus(p, C1)), C1), Power(Times(a, n, Plus(p, C1)), CN1)), Int(Times(Power(Times(c, x), m), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, c, m), x), IGtQ(n, C0), LtQ(p, CN1), IntBinomialQ(a, b, c, n, m, p, x))));
            IIntegrate(291, Int(Times(Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Times(c, x), Plus(m, C1)), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), Plus(p, C1)), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), Plus(p, C1)), Power(Times(C2, $s("a1"), $s("a2"), c, n, Plus(p, C1)), CN1)), x)), Dist(Times(Plus(m, Times(C2, n, Plus(p, C1)), C1), Power(Times(C2, $s("a1"), $s("a2"), n, Plus(p, C1)), CN1)), Int(Times(Power(Times(c, x), m), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), Plus(p, C1)), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), Plus(p, C1))), x), x)), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), c, m), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), IGtQ(Times(C2, n), C0), LtQ(p, CN1), IntBinomialQ(Times($s("a1"), $s("a2")), Times($s("b1"), $s("b2")), c, Times(C2, n), m, p, x))));
            IIntegrate(292, Int(Times(x_, Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1)), x_Symbol),
                    Condition(Plus(Negate(Dist(Power(Times(C3, Rt(a, C3), Rt(b, C3)), CN1), Int(Power(Plus(Rt(a, C3), Times(Rt(b, C3), x)), CN1), x), x)), Dist(Power(Times(C3, Rt(a, C3), Rt(b, C3)), CN1), Int(Times(Plus(Rt(a, C3), Times(Rt(b, C3), x)), Power(Plus(Sqr(Rt(a, C3)), Times(CN1, Rt(a, C3), Rt(b, C3), x), Times(Sqr(Rt(b, C3)), Sqr(x))), CN1)), x), x)), FreeQ(List(a, b), x)));
            IIntegrate(293, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), CN1)), x_Symbol),
                    Condition(Module(List(Set(r, Numerator(Rt(Times(a, Power(b, CN1)), n))), Set(s, Denominator(Rt(Times(a, Power(b, CN1)), n))), k, u), Simp(CompoundExpression(Set(u, Int(Times(Subtract(Times(r, Cos(Times(Subtract(Times(C2, k), C1), m, Pi, Power(n, CN1)))), Times(s, Cos(Times(Subtract(Times(C2, k), C1), Plus(m, C1), Pi, Power(n, CN1))), x)), Power(Plus(Sqr(r), Times(CN1, C2, r, s, Cos(Times(Subtract(Times(C2, k), C1), Pi, Power(n, CN1))), x), Times(Sqr(s), Sqr(x))), CN1)), x)), Plus(Times(CN1, Power(Negate(r), Plus(m, C1)), Int(Power(Plus(r, Times(s, x)), CN1), x), Power(Times(a, n, Power(s, m)), CN1)), Dist(Times(C2, Power(r, Plus(m, C1)), Power(Times(a, n, Power(s, m)), CN1)), Sum(u, List(k, C1, Times(C1D2, Subtract(n, C1)))), x))), x)), And(FreeQ(List(a, b), x), IGtQ(Times(C1D2, Subtract(n, C1)), C0), IGtQ(m, C0), LtQ(m, Subtract(n, C1)), PosQ(Times(a, Power(b, CN1))))));
            IIntegrate(294, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), CN1)), x_Symbol),
                    Condition(Module(List(Set(r, Numerator(Rt(Times(CN1, a, Power(b, CN1)), n))), Set(s, Denominator(Rt(Times(CN1, a, Power(b, CN1)), n))), k, u), Simp(CompoundExpression(Set(u, Int(Times(Plus(Times(r, Cos(Times(Subtract(Times(C2, k), C1), m, Pi, Power(n, CN1)))), Times(s, Cos(Times(Subtract(Times(C2, k), C1), Plus(m, C1), Pi, Power(n, CN1))), x)), Power(Plus(Sqr(r), Times(C2, r, s, Cos(Times(Subtract(Times(C2, k), C1), Pi, Power(n, CN1))), x), Times(Sqr(s), Sqr(x))), CN1)), x)), Subtract(Times(Power(r, Plus(m, C1)), Int(Power(Subtract(r, Times(s, x)), CN1), x), Power(Times(a, n, Power(s, m)), CN1)), Dist(Times(C2, Power(Negate(r), Plus(m, C1)), Power(Times(a, n, Power(s, m)), CN1)), Sum(u, List(k, C1, Times(C1D2, Subtract(n, C1)))), x))), x)), And(FreeQ(List(a, b), x), IGtQ(Times(C1D2, Subtract(n, C1)), C0), IGtQ(m, C0), LtQ(m, Subtract(n, C1)), NegQ(Times(a, Power(b, CN1))))));
            IIntegrate(295, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), CN1)), x_Symbol),
                    Condition(Module(List(Set(r, Numerator(Rt(Times(a, Power(b, CN1)), n))), Set(s, Denominator(Rt(Times(a, Power(b, CN1)), n))), k, u), Simp(CompoundExpression(Set(u, Plus(Int(Times(Subtract(Times(r, Cos(Times(Subtract(Times(C2, k), C1), m, Pi, Power(n, CN1)))), Times(s, Cos(Times(Subtract(Times(C2, k), C1), Plus(m, C1), Pi, Power(n, CN1))), x)), Power(Plus(Sqr(r), Times(CN1, C2, r, s, Cos(Times(Subtract(Times(C2, k), C1), Pi, Power(n, CN1))), x), Times(Sqr(s), Sqr(x))), CN1)), x), Int(Times(Plus(Times(r, Cos(Times(Subtract(Times(C2, k), C1), m, Pi, Power(n, CN1)))), Times(s, Cos(Times(Subtract(Times(C2, k), C1), Plus(m, C1), Pi, Power(n, CN1))), x)), Power(Plus(Sqr(r), Times(C2, r, s, Cos(Times(Subtract(Times(C2, k), C1), Pi, Power(n, CN1))), x), Times(Sqr(s), Sqr(x))), CN1)), x))), Plus(Times(C2, Power(CN1, Times(C1D2, m)), Power(r, Plus(m, C2)), Int(Power(Plus(Sqr(r), Times(Sqr(s), Sqr(x))), CN1), x), Power(Times(a, n, Power(s, m)), CN1)), Dist(Times(C2, Power(r, Plus(m, C1)), Power(Times(a, n, Power(s, m)), CN1)), Sum(u, List(k, C1, Times(C1D4, Subtract(n, C2)))), x))), x)), And(FreeQ(List(a, b), x), IGtQ(Times(C1D4, Subtract(n, C2)), C0), IGtQ(m, C0), LtQ(m, Subtract(n, C1)), PosQ(Times(a, Power(b, CN1))))));
            IIntegrate(296, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), CN1)), x_Symbol),
                    Condition(Module(List(Set(r, Numerator(Rt(Times(CN1, a, Power(b, CN1)), n))), Set(s, Denominator(Rt(Times(CN1, a, Power(b, CN1)), n))), k, u), Simp(CompoundExpression(Set(u, Plus(Int(Times(Subtract(Times(r, Cos(Times(C2, k, m, Pi, Power(n, CN1)))), Times(s, Cos(Times(C2, k, Plus(m, C1), Pi, Power(n, CN1))), x)), Power(Plus(Sqr(r), Times(CN1, C2, r, s, Cos(Times(C2, k, Pi, Power(n, CN1))), x), Times(Sqr(s), Sqr(x))), CN1)), x), Int(Times(Plus(Times(r, Cos(Times(C2, k, m, Pi, Power(n, CN1)))), Times(s, Cos(Times(C2, k, Plus(m, C1), Pi, Power(n, CN1))), x)), Power(Plus(Sqr(r), Times(C2, r, s, Cos(Times(C2, k, Pi, Power(n, CN1))), x), Times(Sqr(s), Sqr(x))), CN1)), x))), Plus(Times(C2, Power(r, Plus(m, C2)), Int(Power(Subtract(Sqr(r), Times(Sqr(s), Sqr(x))), CN1), x), Power(Times(a, n, Power(s, m)), CN1)), Dist(Times(C2, Power(r, Plus(m, C1)), Power(Times(a, n, Power(s, m)), CN1)), Sum(u, List(k, C1, Times(C1D4, Subtract(n, C2)))), x))), x)), And(FreeQ(List(a, b), x), IGtQ(Times(C1D4, Subtract(n, C2)), C0), IGtQ(m, C0), LtQ(m, Subtract(n, C1)), NegQ(Times(a, Power(b, CN1))))));
            IIntegrate(297, Int(Times(Sqr(x_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(With(List(Set(r, Numerator(Rt(Times(a, Power(b, CN1)), C2))), Set(s, Denominator(Rt(Times(a, Power(b, CN1)), C2)))), Subtract(Dist(Power(Times(C2, s), CN1), Int(Times(Plus(r, Times(s, Sqr(x))), Power(Plus(a, Times(b, Power(x, C4))), CN1)), x), x), Dist(Power(Times(C2, s), CN1), Int(Times(Subtract(r, Times(s, Sqr(x))), Power(Plus(a, Times(b, Power(x, C4))), CN1)), x), x))), And(FreeQ(List(a, b), x), Or(GtQ(Times(a, Power(b, CN1)), C0), And(PosQ(Times(a, Power(b, CN1))), AtomQ(SplitProduct($rubi("SumBaseQ"), a)), AtomQ(SplitProduct($rubi("SumBaseQ"), b)))))));
            IIntegrate(298, Int(Times(Sqr(x_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(With(List(Set(r, Numerator(Rt(Times(CN1, a, Power(b, CN1)), C2))), Set(s, Denominator(Rt(Times(CN1, a, Power(b, CN1)), C2)))), Subtract(Dist(Times(s, Power(Times(C2, b), CN1)), Int(Power(Plus(r, Times(s, Sqr(x))), CN1), x), x), Dist(Times(s, Power(Times(C2, b), CN1)), Int(Power(Subtract(r, Times(s, Sqr(x))), CN1), x), x))), And(FreeQ(List(a, b), x), Not(GtQ(Times(a, Power(b, CN1)), C0)))));
            IIntegrate(299, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), CN1)), x_Symbol),
                    Condition(With(List(Set(r, Numerator(Rt(Times(a, Power(b, CN1)), C4))), Set(s, Denominator(Rt(Times(a, Power(b, CN1)), C4)))), Subtract(Dist(Times(Power(s, C3), Power(Times(C2, CSqrt2, b, r), CN1)), Int(Times(Power(x, Subtract(m, Times(C1D4, n))), Power(Plus(Sqr(r), Times(CN1, CSqrt2, r, s, Power(x, Times(C1D4, n))), Times(Sqr(s), Power(x, Times(C1D2, n)))), CN1)), x), x), Dist(Times(Power(s, C3), Power(Times(C2, CSqrt2, b, r), CN1)), Int(Times(Power(x, Subtract(m, Times(C1D4, n))), Power(Plus(Sqr(r), Times(CSqrt2, r, s, Power(x, Times(C1D4, n))), Times(Sqr(s), Power(x, Times(C1D2, n)))), CN1)), x), x))), And(FreeQ(List(a, b), x), IGtQ(Times(C1D4, n), C0), IGtQ(m, C0), LtQ(m, Subtract(n, C1)), GtQ(Times(a, Power(b, CN1)), C0))));
            IIntegrate(300, Int(Times(Power(x_, m_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), CN1)), x_Symbol),
                    Condition(With(List(Set(r, Numerator(Rt(Times(CN1, a, Power(b, CN1)), C2))), Set(s, Denominator(Rt(Times(CN1, a, Power(b, CN1)), C2)))), Plus(Dist(Times(r, Power(Times(C2, a), CN1)), Int(Times(Power(x, m), Power(Plus(r, Times(s, Power(x, Times(C1D2, n)))), CN1)), x), x), Dist(Times(r, Power(Times(C2, a), CN1)), Int(Times(Power(x, m), Power(Subtract(r, Times(s, Power(x, Times(C1D2, n)))), CN1)), x), x))), And(FreeQ(List(a, b), x), IGtQ(Times(C1D4, n), C0), IGtQ(m, C0), LtQ(m, Times(C1D2, n)), Not(GtQ(Times(a, Power(b, CN1)), C0)))));
        }
    }
}
