package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Simplify;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.k;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntBinomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumSimplerQ;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules13 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(326, Int(Times(Power(Times(c_DEFAULT, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(c, x), Plus(m, C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Times(a, c, Plus(m, C1)), CN1)), x), Dist(Times(b, Plus(m, Times(n, Plus(p, C1)), C1), Power(Times(a, Power(c, n), Plus(m, C1)), CN1)), Int(Times(Power(Times(c, x), Plus(m, n)), Power(Plus(a, Times(b, Power(x, n))), p)), x), x)), And(FreeQ(List(a, b, c, m, p), x), IGtQ(n, C0), SumSimplerQ(m, n), ILtQ(Simplify(Plus(Times(Plus(m, C1), Power(n, CN1)), p)), C0))));
            IIntegrate(327, Int(Times(Power(Times(c_DEFAULT, x_), m_), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(c, x), Plus(m, C1)), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), Plus(p, C1)), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), Plus(p, C1)), Power(Times($s("a1"), $s("a2"), c, Plus(m, C1)), CN1)), x), Dist(Times($s("b1"), $s("b2"), Plus(m, Times(C2, n, Plus(p, C1)), C1), Power(Times($s("a1"), $s("a2"), Power(c, Times(C2, n)), Plus(m, C1)), CN1)), Int(Times(Power(Times(c, x), Plus(m, Times(C2, n))), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), p), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), p)), x), x)), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), c, p), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), IGtQ(Times(C2, n), C0), LtQ(m, CN1), IntBinomialQ(Times($s("a1"), $s("a2")), Times($s("b1"), $s("b2")), c, Times(C2, n), m, p, x))));
            IIntegrate(328, Int(Times(Power(Times(c_DEFAULT, x_), m_), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(c, x), Plus(m, C1)), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), Plus(p, C1)), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), Plus(p, C1)), Power(Times($s("a1"), $s("a2"), c, Plus(m, C1)), CN1)), x), Dist(Times($s("b1"), $s("b2"), Plus(m, Times(C2, n, Plus(p, C1)), C1), Power(Times($s("a1"), $s("a2"), Power(c, Times(C2, n)), Plus(m, C1)), CN1)), Int(Times(Power(Times(c, x), Plus(m, Times(C2, n))), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), p), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), p)), x), x)), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), c, m, p), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), IGtQ(Times(C2, n), C0), SumSimplerQ(m, Times(C2, n)), ILtQ(Simplify(Plus(Times(Plus(m, C1), Power(Times(C2, n), CN1)), p)), C0))));
            IIntegrate(329, Int(Times(Power(Times(c_DEFAULT, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(With(List(Set(k, Denominator(m))), Dist(Times(k, Power(c, CN1)), Subst(Int(Times(Power(x, Subtract(Times(k, Plus(m, C1)), C1)), Power(Plus(a, Times(b, Power(x, Times(k, n)), Power(Power(c, n), CN1))), p)), x), x, Power(Times(c, x), Power(k, CN1))), x)), And(FreeQ(List(a, b, c, p), x), IGtQ(n, C0), FractionQ(m), IntBinomialQ(a, b, c, n, m, p, x))));
            IIntegrate(330, Int(Times(Power(Times(c_DEFAULT, x_), m_), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(With(List(Set(k, Denominator(m))), Dist(Times(k, Power(c, CN1)), Subst(Int(Times(Power(x, Subtract(Times(k, Plus(m, C1)), C1)), Power(Plus($s("a1"), Times($s("b1"), Power(x, Times(k, n)), Power(Power(c, n), CN1))), p), Power(Plus($s("a2"), Times($s("b2"), Power(x, Times(k, n)), Power(Power(c, n), CN1))), p)), x), x, Power(Times(c, x), Power(k, CN1))), x)), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), c, p), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), IGtQ(Times(C2, n), C0), FractionQ(m), IntBinomialQ(Times($s("a1"), $s("a2")), Times($s("b1"), $s("b2")), c, Times(C2, n), m, p, x))));
            IIntegrate(331, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Power(a, Plus(p, Times(Plus(m, C1), Power(n, CN1)))), Subst(Int(Times(Power(x, m), Power(Power(Subtract(C1, Times(b, Power(x, n))), Plus(p, Times(Plus(m, C1), Power(n, CN1)), C1)), CN1)), x), x, Times(x, Power(Power(Plus(a, Times(b, Power(x, n))), Power(n, CN1)), CN1))), x), And(FreeQ(List(a, b), x), IGtQ(n, C0), LtQ(CN1, p, C0), NeQ(p, Negate(C1D2)), IntegersQ(m, Plus(p, Times(Plus(m, C1), Power(n, CN1)))))));
            IIntegrate(332, Int(Times(Power(x_, m_DEFAULT), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Power(Times($s("a1"), $s("a2")), Plus(p, Times(Plus(m, C1), Power(Times(C2, n), CN1)))), Subst(Int(Times(Power(x, m), Power(Times(Power(Subtract(C1, Times($s("b1"), Power(x, n))), Plus(p, Times(Plus(m, C1), Power(Times(C2, n), CN1)), C1)), Power(Subtract(C1, Times($s("b2"), Power(x, n))), Plus(p, Times(Plus(m, C1), Power(Times(C2, n), CN1)), C1))), CN1)), x), x, Times(x, Power(Times(Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), Power(Times(C2, n), CN1)), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), Power(Times(C2, n), CN1))), CN1))), x), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2")), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), IGtQ(Times(C2, n), C0), LtQ(CN1, p, C0), NeQ(p, Negate(C1D2)), IntegersQ(m, Plus(p, Times(Plus(m, C1), Power(Times(C2, n), CN1)))))));
            IIntegrate(333, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Times(a, Power(Plus(a, Times(b, Power(x, n))), CN1)), Plus(p, Times(Plus(m, C1), Power(n, CN1)))), Power(Plus(a, Times(b, Power(x, n))), Plus(p, Times(Plus(m, C1), Power(n, CN1))))), Subst(Int(Times(Power(x, m), Power(Power(Subtract(C1, Times(b, Power(x, n))), Plus(p, Times(Plus(m, C1), Power(n, CN1)), C1)), CN1)), x), x, Times(x, Power(Power(Plus(a, Times(b, Power(x, n))), Power(n, CN1)), CN1))), x), And(FreeQ(List(a, b), x), IGtQ(n, C0), LtQ(CN1, p, C0), NeQ(p, Negate(C1D2)), IntegerQ(m), LtQ(Denominator(Plus(p, Times(Plus(m, C1), Power(n, CN1)))), Denominator(p)))));
            IIntegrate(334, Int(Times(Power(x_, m_DEFAULT), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Times($s("a1"), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), CN1)), Plus(p, Times(Plus(m, C1), Power(Times(C2, n), CN1)))), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), Plus(p, Times(Plus(m, C1), Power(Times(C2, n), CN1)))), Power(Times($s("a2"), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), CN1)), Plus(p, Times(Plus(m, C1), Power(Times(C2, n), CN1)))), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), Plus(p, Times(Plus(m, C1), Power(Times(C2, n), CN1))))), Subst(Int(Times(Power(x, m), Power(Times(Power(Subtract(C1, Times($s("b1"), Power(x, n))), Plus(p, Times(Plus(m, C1), Power(Times(C2, n), CN1)), C1)), Power(Subtract(C1, Times($s("b2"), Power(x, n))), Plus(p, Times(Plus(m, C1), Power(Times(C2, n), CN1)), C1))), CN1)), x), x, Times(x, Power(Times(Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), Power(Times(C2, n), CN1)), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), Power(Times(C2, n), CN1))), CN1))), x), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2")), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), IGtQ(Times(C2, n), C0), LtQ(CN1, p, C0), NeQ(p, Negate(C1D2)), IntegerQ(m), LtQ(Denominator(Plus(p, Times(Plus(m, C1), Power(Times(C2, n), CN1)))), Denominator(p)))));
            IIntegrate(335, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Negate(Subst(Int(Times(Power(Plus(a, Times(b, Power(Power(x, n), CN1))), p), Power(Power(x, Plus(m, C2)), CN1)), x), x, Power(x, CN1))), And(FreeQ(List(a, b, p), x), ILtQ(n, C0), IntegerQ(m))));
            IIntegrate(336, Int(Times(Power(x_, m_DEFAULT), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(Negate(Subst(Int(Times(Power(Plus($s("a1"), Times($s("b1"), Power(Power(x, n), CN1))), p), Power(Plus($s("a2"), Times($s("b2"), Power(Power(x, n), CN1))), p), Power(Power(x, Plus(m, C2)), CN1)), x), x, Power(x, CN1))), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), p), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), ILtQ(Times(C2, n), C0), IntegerQ(m))));
            IIntegrate(337, Int(Times(Power(Times(c_DEFAULT, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(With(List(Set(k, Denominator(m))), Negate(Dist(Times(k, Power(c, CN1)), Subst(Int(Times(Power(Plus(a, Times(b, Power(Times(Power(c, n), Power(x, Times(k, n))), CN1))), p), Power(Power(x, Plus(Times(k, Plus(m, C1)), C1)), CN1)), x), x, Power(Power(Times(c, x), Power(k, CN1)), CN1)), x))), And(FreeQ(List(a, b, c, p), x), ILtQ(n, C0), FractionQ(m))));
            IIntegrate(338, Int(Times(Power(Times(c_DEFAULT, x_), m_), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(With(List(Set(k, Denominator(m))), Negate(Dist(Times(k, Power(c, CN1)), Subst(Int(Times(Power(Plus($s("a1"), Times($s("b1"), Power(Times(Power(c, n), Power(x, Times(k, n))), CN1))), p), Power(Plus($s("a2"), Times($s("b2"), Power(Times(Power(c, n), Power(x, Times(k, n))), CN1))), p), Power(Power(x, Plus(Times(k, Plus(m, C1)), C1)), CN1)), x), x, Power(Power(Times(c, x), Power(k, CN1)), CN1)), x))), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), c, p), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), ILtQ(Times(C2, n), C0), FractionQ(m))));
            IIntegrate(339, Int(Times(Power(Times(c_DEFAULT, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Negate(Dist(Times(Power(Times(c, x), Plus(m, C1)), Power(Power(x, CN1), Plus(m, C1)), Power(c, CN1)), Subst(Int(Times(Power(Plus(a, Times(b, Power(Power(x, n), CN1))), p), Power(Power(x, Plus(m, C2)), CN1)), x), x, Power(x, CN1)), x)), And(FreeQ(List(a, b, c, m, p), x), ILtQ(n, C0), Not(RationalQ(m)))));
            IIntegrate(340, Int(Times(Power(Times(c_DEFAULT, x_), m_), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(Negate(Dist(Times(Power(Times(c, x), Plus(m, C1)), Power(Power(x, CN1), Plus(m, C1)), Power(c, CN1)), Subst(Int(Times(Power(Plus($s("a1"), Times($s("b1"), Power(Power(x, n), CN1))), p), Power(Plus($s("a2"), Times($s("b2"), Power(Power(x, n), CN1))), p), Power(Power(x, Plus(m, C2)), CN1)), x), x, Power(x, CN1)), x)), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), c, m, p), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), ILtQ(Times(C2, n), C0), Not(RationalQ(m)))));
            IIntegrate(341, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(With(List(Set(k, Denominator(n))), Dist(k, Subst(Int(Times(Power(x, Subtract(Times(k, Plus(m, C1)), C1)), Power(Plus(a, Times(b, Power(x, Times(k, n)))), p)), x), x, Power(x, Power(k, CN1))), x)), And(FreeQ(List(a, b, m, p), x), FractionQ(n))));
            IIntegrate(342, Int(Times(Power(x_, m_DEFAULT), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(With(List(Set(k, Denominator(Times(C2, n)))), Dist(k, Subst(Int(Times(Power(x, Subtract(Times(k, Plus(m, C1)), C1)), Power(Plus($s("a1"), Times($s("b1"), Power(x, Times(k, n)))), p), Power(Plus($s("a2"), Times($s("b2"), Power(x, Times(k, n)))), p)), x), x, Power(x, Power(k, CN1))), x)), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), m, p), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), FractionQ(Times(C2, n)))));
            IIntegrate(343, Int(Times(Power(Times(c_, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(c, IntPart(m)), Power(Times(c, x), FracPart(m)), Power(Power(x, FracPart(m)), CN1)), Int(Times(Power(x, m), Power(Plus(a, Times(b, Power(x, n))), p)), x), x), And(FreeQ(List(a, b, c, m, p), x), FractionQ(n))));
            IIntegrate(344, Int(Times(Power(Times(c_, x_), m_), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(c, IntPart(m)), Power(Times(c, x), FracPart(m)), Power(Power(x, FracPart(m)), CN1)), Int(Times(Power(x, m), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), p), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), p)), x), x), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), c, m, p), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), FractionQ(Times(C2, n)))));
            IIntegrate(345, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Power(Plus(m, C1), CN1), Subst(Int(Power(Plus(a, Times(b, Power(x, Simplify(Times(n, Power(Plus(m, C1), CN1)))))), p), x), x, Power(x, Plus(m, C1))), x), And(FreeQ(List(a, b, m, n, p), x), IntegerQ(Simplify(Times(n, Power(Plus(m, C1), CN1)))), Not(IntegerQ(n)))));
            IIntegrate(346, Int(Times(Power(x_, m_DEFAULT), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Power(Plus(m, C1), CN1), Subst(Int(Times(Power(Plus($s("a1"), Times($s("b1"), Power(x, Simplify(Times(n, Power(Plus(m, C1), CN1)))))), p), Power(Plus($s("a2"), Times($s("b2"), Power(x, Simplify(Times(n, Power(Plus(m, C1), CN1)))))), p)), x), x, Power(x, Plus(m, C1))), x), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), m, n, p), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), IntegerQ(Simplify(Times(C2, n, Power(Plus(m, C1), CN1)))), Not(IntegerQ(Times(C2, n))))));
            IIntegrate(347, Int(Times(Power(Times(c_, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(c, IntPart(m)), Power(Times(c, x), FracPart(m)), Power(Power(x, FracPart(m)), CN1)), Int(Times(Power(x, m), Power(Plus(a, Times(b, Power(x, n))), p)), x), x), And(FreeQ(List(a, b, c, m, n, p), x), IntegerQ(Simplify(Times(n, Power(Plus(m, C1), CN1)))), Not(IntegerQ(n)))));
            IIntegrate(348, Int(Times(Power(Times(c_, x_), m_), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(c, IntPart(m)), Power(Times(c, x), FracPart(m)), Power(Power(x, FracPart(m)), CN1)), Int(Times(Power(x, m), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), p), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), p)), x), x), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), c, m, n, p), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), IntegerQ(Simplify(Times(C2, n, Power(Plus(m, C1), CN1)))), Not(IntegerQ(Times(C2, n))))));
            IIntegrate(349, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(x, Plus(m, C1)), Power(Plus(a, Times(b, Power(x, n))), p), Power(Plus(m, C1), CN1)), x), Dist(Times(b, n, p, Power(Plus(m, C1), CN1)), Int(Times(Power(x, Plus(m, n)), Power(Plus(a, Times(b, Power(x, n))), Subtract(p, C1))), x), x)), And(FreeQ(List(a, b, m, n), x), EqQ(Plus(Times(Plus(m, C1), Power(n, CN1)), p), C0), GtQ(p, C0))));
            IIntegrate(350, Int(Times(Power(x_, m_DEFAULT), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(x, Plus(m, C1)), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), p), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), p), Power(Plus(m, C1), CN1)), x), Dist(Times(C2, $s("b1"), $s("b2"), n, p, Power(Plus(m, C1), CN1)), Int(Times(Power(x, Plus(m, Times(C2, n))), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), Subtract(p, C1)), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), Subtract(p, C1))), x), x)), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), m, n), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), EqQ(Plus(Times(Plus(m, C1), Power(Times(C2, n), CN1)), p), C0), GtQ(p, C0))));
        }
    }
}
