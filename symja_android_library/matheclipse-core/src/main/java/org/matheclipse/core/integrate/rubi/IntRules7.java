package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcTan;
import static org.matheclipse.core.expression.F.ArcTanh;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C1D3;
import static org.matheclipse.core.expression.F.C1D4;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.C6;
import static org.matheclipse.core.expression.F.C9;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D3;
import static org.matheclipse.core.expression.F.CN1D4;
import static org.matheclipse.core.expression.F.CSqrt2;
import static org.matheclipse.core.expression.F.CSqrt3;
import static org.matheclipse.core.expression.F.Coefficient;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.Hypergeometric2F1;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.QQ;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Simplify;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.ZZ;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.k;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearPairQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NegQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PolynomialDivide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumSimplerQ;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules7 {
    public static IAST RULES = List(
            IIntegrate(351, Int(Times(Power(Times(c_, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(c, IntPart(m)), Power(Times(c, x), FracPart(m)), Power(Power(x, FracPart(m)), -1)), Int(Times(Power(x, m), Power(Plus(a, Times(b, Power(x, n))), p)), x), x), And(FreeQ(List(a, b, c, m, n), x), EqQ(Plus(Times(Plus(m, C1), Power(n, -1)), p), C0), GtQ(p, C0)))),
            IIntegrate(352, Int(Times(Power(Times(c_, x_), m_), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(c, IntPart(m)), Power(Times(c, x), FracPart(m)), Power(Power(x, FracPart(m)), -1)), Int(Times(Power(x, m), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), p), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), p)), x), x), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), c, m, n), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), EqQ(Plus(Times(Plus(m, C1), Power(Times(C2, n), -1)), p), C0), GtQ(p, C0)))),
            IIntegrate(353, Int(Times(Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(c, x), Plus(m, C1)), Power(Plus(a, Times(b, Power(x, n))), p), Power(Times(c, Plus(m, Times(n, p), C1)), -1)), x), Dist(Times(a, n, p, Power(Plus(m, Times(n, p), C1), -1)), Int(Times(Power(Times(c, x), m), Power(Plus(a, Times(b, Power(x, n))), Plus(p, Negate(C1)))), x), x)), And(FreeQ(List(a, b, c, m, n), x), IntegerQ(Plus(p, Simplify(Times(Plus(m, C1), Power(n, -1))))), GtQ(p, C0), NeQ(Plus(m, Times(n, p), C1), C0)))),
            IIntegrate(354, Int(Times(Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(c, x), Plus(m, C1)), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), p), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), p), Power(Times(c, Plus(m, Times(C2, n, p), C1)), -1)), x), Dist(Times(C2, $s("a1"), $s("a2"), n, p, Power(Plus(m, Times(C2, n, p), C1), -1)), Int(Times(Power(Times(c, x), m), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), Plus(p, Negate(C1))), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), Plus(p, Negate(C1)))), x), x)), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), c, m, n), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), IntegerQ(Plus(p, Simplify(Times(Plus(m, C1), Power(Times(C2, n), -1))))), GtQ(p, C0), NeQ(Plus(m, Times(C2, n, p), C1), C0)))),
            IIntegrate(355, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(With(List(Set(k, Denominator(p))), Dist(Times(k, Power(a, Plus(p, Simplify(Times(Plus(m, C1), Power(n, -1))))), Power(n, -1)), Subst(Int(Times(Power(x, Plus(Times(k, Simplify(Times(Plus(m, C1), Power(n, -1)))), Negate(C1))), Power(Power(Plus(C1, Times(CN1, b, Power(x, k))), Plus(p, Simplify(Times(Plus(m, C1), Power(n, -1))), C1)), -1)), x), x, Times(Power(x, Times(n, Power(k, -1))), Power(Power(Plus(a, Times(b, Power(x, n))), Power(k, -1)), -1))), x)), And(FreeQ(List(a, b, m, n), x), IntegerQ(Plus(p, Simplify(Times(Plus(m, C1), Power(n, -1))))), LtQ(CN1, p, C0)))),
            IIntegrate(356, Int(Times(Power(x_, m_DEFAULT), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(With(List(Set(k, Denominator(p))), Dist(Times(k, Power(Times($s("a1"), $s("a2")), Plus(p, Simplify(Times(Plus(m, C1), Power(Times(C2, n), -1))))), Power(Times(C2, n), -1)), Subst(Int(Times(Power(x, Plus(Times(k, Simplify(Times(Plus(m, C1), Power(Times(C2, n), -1)))), Negate(C1))), Power(Power(Plus(C1, Times(CN1, $s("b1"), $s("b2"), Power(x, k))), Plus(p, Simplify(Times(Plus(m, C1), Power(Times(C2, n), -1))), C1)), -1)), x), x, Times(Power(x, Times(C2, n, Power(k, -1))), Power(Times(Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), Power(k, -1)), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), Power(k, -1))), -1))), x)), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), m, n), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), IntegerQ(Plus(p, Simplify(Times(Plus(m, C1), Power(Times(C2, n), -1))))), LtQ(CN1, p, C0)))),
            IIntegrate(357, Int(Times(Power(Times(c_, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(c, IntPart(m)), Power(Times(c, x), FracPart(m)), Power(Power(x, FracPart(m)), -1)), Int(Times(Power(x, m), Power(Plus(a, Times(b, Power(x, n))), p)), x), x), And(FreeQ(List(a, b, c, m, n), x), IntegerQ(Plus(p, Simplify(Times(Plus(m, C1), Power(n, -1))))), LtQ(CN1, p, C0)))),
            IIntegrate(358, Int(Times(Power(Times(c_, x_), m_), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(c, IntPart(m)), Power(Times(c, x), FracPart(m)), Power(Power(x, FracPart(m)), -1)), Int(Times(Power(x, m), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), p), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), p)), x), x), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), c, m, n), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), IntegerQ(Plus(p, Simplify(Times(Plus(m, C1), Power(Times(C2, n), -1))))), LtQ(CN1, p, C0)))),
            IIntegrate(359, Int(Times(Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Times(c, x), Plus(m, C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Times(a, c, n, Plus(p, C1)), -1)), x)), Dist(Times(Plus(m, Times(n, Plus(p, C1)), C1), Power(Times(a, n, Plus(p, C1)), -1)), Int(Times(Power(Times(c, x), m), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, c, m, n), x), IntegerQ(Plus(p, Simplify(Times(Plus(m, C1), Power(n, -1))))), LtQ(p, CN1)))),
            IIntegrate(360, Int(Times(Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Times(c, x), Plus(m, C1)), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), Plus(p, C1)), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), Plus(p, C1)), Power(Times(C2, $s("a1"), $s("a2"), c, n, Plus(p, C1)), -1)), x)), Dist(Times(Plus(m, Times(C2, n, Plus(p, C1)), C1), Power(Times(C2, $s("a1"), $s("a2"), n, Plus(p, C1)), -1)), Int(Times(Power(Times(c, x), m), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), Plus(p, C1)), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), Plus(p, C1))), x), x)), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), c, m, n), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), IntegerQ(Plus(p, Simplify(Times(Plus(m, C1), Power(Times(C2, n), -1))))), LtQ(p, CN1)))),
            IIntegrate(361, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), -1)), x_Symbol),
                    Condition(With(List(Set($s("mn"), Simplify(Plus(m, Negate(n))))), Plus(Simp(Times(Power(x, Plus($s("mn"), C1)), Power(Times(b, Plus($s("mn"), C1)), -1)), x), Negate(Dist(Times(a, Power(b, -1)), Int(Times(Power(x, $s("mn")), Power(Plus(a, Times(b, Power(x, n))), -1)), x), x)))), And(FreeQ(List(a, b, m, n), x), FractionQ(Simplify(Times(Plus(m, C1), Power(n, -1)))), SumSimplerQ(m, Negate(n))))),
            IIntegrate(362, Int(Times(Power(x_, m_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), -1)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, Plus(m, C1)), Power(Times(a, Plus(m, C1)), -1)), x), Negate(Dist(Times(b, Power(a, -1)), Int(Times(Power(x, Simplify(Plus(m, n))), Power(Plus(a, Times(b, Power(x, n))), -1)), x), x))), And(FreeQ(List(a, b, m, n), x), FractionQ(Simplify(Times(Plus(m, C1), Power(n, -1)))), SumSimplerQ(m, n)))),
            IIntegrate(363, Int(Times(Power(Times(c_, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), -1)), x_Symbol),
                    Condition(Dist(Times(Power(c, IntPart(m)), Power(Times(c, x), FracPart(m)), Power(Power(x, FracPart(m)), -1)), Int(Times(Power(x, m), Power(Plus(a, Times(b, Power(x, n))), -1)), x), x), And(FreeQ(List(a, b, c, m, n), x), FractionQ(Simplify(Times(Plus(m, C1), Power(n, -1)))), Or(SumSimplerQ(m, n), SumSimplerQ(m, Negate(n)))))),
            IIntegrate(364, Int(Times(Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Simp(Times(Power(a, p), Power(Times(c, x), Plus(m, C1)), Hypergeometric2F1(Negate(p), Times(Plus(m, C1), Power(n, -1)), Plus(Times(Plus(m, C1), Power(n, -1)), C1), Times(CN1, b, Power(x, n), Power(a, -1))), Power(Times(c, Plus(m, C1)), -1)), x), And(FreeQ(List(a, b, c, m, n, p), x), Not(IGtQ(p, C0)), Or(ILtQ(p, C0), GtQ(a, C0))))),
            IIntegrate(365, Int(Times(Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(a, IntPart(p)), Power(Plus(a, Times(b, Power(x, n))), FracPart(p)), Power(Power(Plus(C1, Times(b, Power(x, n), Power(a, -1))), FracPart(p)), -1)), Int(Times(Power(Times(c, x), m), Power(Plus(C1, Times(b, Power(x, n), Power(a, -1))), p)), x), x), And(FreeQ(List(a, b, c, m, n, p), x), Not(IGtQ(p, C0)), Not(Or(ILtQ(p, C0), GtQ(a, C0)))))),
            IIntegrate(366, Int(Times(Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), FracPart(p)), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), FracPart(p)), Power(Power(Plus(Times($s("a1"), $s("a2")), Times($s("b1"), $s("b2"), Power(x, Times(C2, n)))), FracPart(p)), -1)), Int(Times(Power(Times(c, x), m), Power(Plus(Times($s("a1"), $s("a2")), Times($s("b1"), $s("b2"), Power(x, Times(C2, n)))), p)), x), x), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), c, m, n, p), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), Not(IntegerQ(p))))),
            IIntegrate(367, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(Times(c_, x_), n_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(c, -1), Subst(Int(Times(Power(Times(d, x, Power(c, -1)), m), Power(Plus(a, Times(b, Power(x, n))), p)), x), x, Times(c, x)), x), FreeQ(List(a, b, c, d, m, n, p), x))),
            IIntegrate(368, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(Times(c_DEFAULT, Power(x_, q_)), n_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Times(d, x), Plus(m, C1)), Power(Times(d, Power(Power(Times(c, Power(x, q)), Power(q, -1)), Plus(m, C1))), -1)), Subst(Int(Times(Power(x, m), Power(Plus(a, Times(b, Power(x, Times(n, q)))), p)), x), x, Power(Times(c, Power(x, q)), Power(q, -1))), x), And(FreeQ(List(a, b, c, d, m, n, p, q), x), IntegerQ(Times(n, q)), NeQ(x, Power(Times(c, Power(x, q)), Power(q, -1)))))),
            IIntegrate(369, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(Times(c_DEFAULT, Power(x_, q_)), n_))), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(k, Denominator(n))), Subst(Int(Times(Power(Times(d, x), m), Power(Plus(a, Times(b, Power(c, n), Power(x, Times(n, q)))), p)), x), Power(x, Power(k, -1)), Times(Power(Times(c, Power(x, q)), Power(k, -1)), Power(Times(Power(c, Power(k, -1)), Power(Power(x, Power(k, -1)), Plus(q, Negate(C1)))), -1)))), And(FreeQ(List(a, b, c, d, m, p, q), x), FractionQ(n)))),
            IIntegrate(370, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(Times(c_DEFAULT, Power(x_, q_)), n_))), p_DEFAULT)), x_Symbol),
                    Condition(Subst(Int(Times(Power(Times(d, x), m), Power(Plus(a, Times(b, Power(c, n), Power(x, Times(n, q)))), p)), x), Power(x, Times(n, q)), Times(Power(Times(c, Power(x, q)), n), Power(Power(c, n), -1))), And(FreeQ(List(a, b, c, d, m, n, p, q), x), Not(RationalQ(n))))),
            IIntegrate(371, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(v_, n_))), p_DEFAULT), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(c, Coefficient(v, x, C0)), Set(d, Coefficient(v, x, C1))), Condition(Dist(Power(Power(d, Plus(m, C1)), -1), Subst(Int(SimplifyIntegrand(Times(Power(Plus(x, Negate(c)), m), Power(Plus(a, Times(b, Power(x, n))), p)), x), x), x, v), x), NeQ(c, C0))), And(FreeQ(List(a, b, n, p), x), LinearQ(v, x), IntegerQ(m)))),
            IIntegrate(372, Int(Times(Power(u_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(v_, n_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(u, m), Power(Times(Coefficient(v, x, C1), Power(v, m)), -1)), Subst(Int(Times(Power(x, m), Power(Plus(a, Times(b, Power(x, n))), p)), x), x, v), x), And(FreeQ(List(a, b, m, n, p), x), LinearPairQ(u, v, x)))),
            IIntegrate(373, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(a, Times(b, Power(x, n))), p), Power(Plus(c, Times(d, Power(x, n))), q)), x), x), And(FreeQ(List(a, b, c, d, n), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0), IGtQ(p, C0), IGtQ(q, C0)))),
            IIntegrate(374, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(x, Times(n, Plus(p, q))), Power(Plus(b, Times(a, Power(Power(x, n), -1))), p), Power(Plus(d, Times(c, Power(Power(x, n), -1))), q)), x), And(FreeQ(List(a, b, c, d, n), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0), IntegersQ(p, q), NegQ(n)))),
            IIntegrate(375, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Negate(Subst(Int(Times(Power(Plus(a, Times(b, Power(Power(x, n), -1))), p), Power(Plus(c, Times(d, Power(Power(x, n), -1))), q), Power(x, -2)), x), x, Power(x, -1))), And(FreeQ(List(a, b, c, d, p, q), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0), ILtQ(n, C0)))),
            IIntegrate(376, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(g, Denominator(n))), Dist(g, Subst(Int(Times(Power(x, Plus(g, Negate(C1))), Power(Plus(a, Times(b, Power(x, Times(g, n)))), p), Power(Plus(c, Times(d, Power(x, Times(g, n)))), q)), x), x, Power(x, Power(g, -1))), x)), And(FreeQ(List(a, b, c, d, p, q), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0), FractionQ(n)))),
            IIntegrate(377, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), -1)), x_Symbol),
                    Condition(Subst(Int(Power(Plus(c, Times(CN1, Plus(Times(b, c), Times(CN1, a, d)), Power(x, n))), -1), x), x, Times(x, Power(Power(Plus(a, Times(b, Power(x, n))), Power(n, -1)), -1))), And(FreeQ(List(a, b, c, d), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0), EqQ(Plus(Times(n, p), C1), C0), IntegerQ(n)))),
            IIntegrate(378, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(x, Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), q), Power(Times(a, n, Plus(p, C1)), -1)), x)), Negate(Dist(Times(c, q, Power(Times(a, Plus(p, C1)), -1)), Int(Times(Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), Plus(q, Negate(C1)))), x), x))), And(FreeQ(List(a, b, c, d, n, p), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0), EqQ(Plus(Times(n, Plus(p, q, C1)), C1), C0), GtQ(q, C0), NeQ(p, CN1)))),
            IIntegrate(379, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(Simp(Times(Power(a, p), x, Hypergeometric2F1(Power(n, -1), Negate(p), Plus(C1, Power(n, -1)), Times(CN1, Plus(Times(b, c), Times(CN1, a, d)), Power(x, n), Power(Times(a, Plus(c, Times(d, Power(x, n)))), -1))), Power(Times(Power(c, Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), Power(n, -1))), -1)), x), And(FreeQ(List(a, b, c, d, n, q), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0), EqQ(Plus(Times(n, Plus(p, q, C1)), C1), C0), ILtQ(p, C0)))),
            IIntegrate(380, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(Simp(Times(x, Power(Plus(a, Times(b, Power(x, n))), p), Hypergeometric2F1(Power(n, -1), Negate(p), Plus(C1, Power(n, -1)), Times(CN1, Plus(Times(b, c), Times(CN1, a, d)), Power(x, n), Power(Times(a, Plus(c, Times(d, Power(x, n)))), -1))), Power(Times(c, Power(Times(c, Plus(a, Times(b, Power(x, n))), Power(Times(a, Plus(c, Times(d, Power(x, n)))), -1)), p), Power(Plus(c, Times(d, Power(x, n))), Plus(Power(n, -1), p))), -1)), x), And(FreeQ(List(a, b, c, d, n, p, q), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0), EqQ(Plus(Times(n, Plus(p, q, C1)), C1), C0)))),
            IIntegrate(381, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(Simp(Times(x, Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), Plus(q, C1)), Power(Times(a, c), -1)), x), And(FreeQ(List(a, b, c, d, n, p, q), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0), EqQ(Plus(Times(n, Plus(p, q, C2)), C1), C0), EqQ(Plus(Times(a, d, Plus(p, C1)), Times(b, c, Plus(q, C1))), C0)))),
            IIntegrate(382, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, x, Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), Plus(q, C1)), Power(Times(a, n, Plus(p, C1), Plus(Times(b, c), Times(CN1, a, d))), -1)), x)), Dist(Times(Plus(Times(b, c), Times(n, Plus(p, C1), Plus(Times(b, c), Times(CN1, a, d)))), Power(Times(a, n, Plus(p, C1), Plus(Times(b, c), Times(CN1, a, d))), -1)), Int(Times(Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), q)), x), x)), And(FreeQ(List(a, b, c, d, n, q), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0), EqQ(Plus(Times(n, Plus(p, q, C2)), C1), C0), Or(LtQ(p, CN1), Not(LtQ(q, CN1))), NeQ(p, CN1)))),
            IIntegrate(383, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Plus(c_, Times(d_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Simp(Times(c, x, Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(a, -1)), x), And(FreeQ(List(a, b, c, d, n, p), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0), EqQ(Plus(Times(a, d), Times(CN1, b, c, Plus(Times(n, Plus(p, C1)), C1))), C0)))),
            IIntegrate(384, Int(Times(Power(Plus($p("a1"), Times($p("b1", true), Power(x_, $p("non2", true)))), p_DEFAULT), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, $p("non2", true)))), p_DEFAULT), Plus(c_, Times(d_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Simp(Times(c, x, Power(Plus($s("a1"), Times($s("b1"), Power(x, Times(C1D2, n)))), Plus(p, C1)), Power(Plus($s("a2"), Times($s("b2"), Power(x, Times(C1D2, n)))), Plus(p, C1)), Power(Times($s("a1"), $s("a2")), -1)), x), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), c, d, n, p), x), EqQ($s("non2"), Times(C1D2, n)), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), EqQ(Plus(Times($s("a1"), $s("a2"), d), Times(CN1, $s("b1"), $s("b2"), c, Plus(Times(n, Plus(p, C1)), C1))), C0)))),
            IIntegrate(385, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Plus(c_, Times(d_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Plus(Times(b, c), Times(CN1, a, d)), x, Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Times(a, b, n, Plus(p, C1)), -1)), x)), Negate(Dist(Times(Plus(Times(a, d), Times(CN1, b, c, Plus(Times(n, Plus(p, C1)), C1))), Power(Times(a, b, n, Plus(p, C1)), -1)), Int(Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), x), x))), And(FreeQ(List(a, b, c, d, n, p), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0), Or(LtQ(p, CN1), ILtQ(Plus(Power(n, -1), p), C0))))),
            IIntegrate(386, Int(Times(Power(Plus($p("a1"), Times($p("b1", true), Power(x_, $p("non2", true)))), p_DEFAULT), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, $p("non2", true)))), p_DEFAULT), Plus(c_, Times(d_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Plus(Times($s("b1"), $s("b2"), c), Times(CN1, $s("a1"), $s("a2"), d)), x, Power(Plus($s("a1"), Times($s("b1"), Power(x, Times(C1D2, n)))), Plus(p, C1)), Power(Plus($s("a2"), Times($s("b2"), Power(x, Times(C1D2, n)))), Plus(p, C1)), Power(Times($s("a1"), $s("a2"), $s("b1"), $s("b2"), n, Plus(p, C1)), -1)), x)), Negate(Dist(Times(Plus(Times($s("a1"), $s("a2"), d), Times(CN1, $s("b1"), $s("b2"), c, Plus(Times(n, Plus(p, C1)), C1))), Power(Times($s("a1"), $s("a2"), $s("b1"), $s("b2"), n, Plus(p, C1)), -1)), Int(Times(Power(Plus($s("a1"), Times($s("b1"), Power(x, Times(C1D2, n)))), Plus(p, C1)), Power(Plus($s("a2"), Times($s("b2"), Power(x, Times(C1D2, n)))), Plus(p, C1))), x), x))), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), c, d, n), x), EqQ($s("non2"), Times(C1D2, n)), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), Or(LtQ(p, CN1), ILtQ(Plus(Power(n, -1), p), C0))))),
            IIntegrate(387, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), -1), Plus(c_, Times(d_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Plus(Simp(Times(c, x, Power(a, -1)), x), Negate(Dist(Times(Plus(Times(b, c), Times(CN1, a, d)), Power(a, -1)), Int(Power(Plus(b, Times(a, Power(Power(x, n), -1))), -1), x), x))), And(FreeQ(List(a, b, c, d, n), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0), LtQ(n, C0)))),
            IIntegrate(388, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Plus(c_, Times(d_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Plus(Simp(Times(d, x, Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Times(b, Plus(Times(n, Plus(p, C1)), C1)), -1)), x), Negate(Dist(Times(Plus(Times(a, d), Times(CN1, b, c, Plus(Times(n, Plus(p, C1)), C1))), Power(Times(b, Plus(Times(n, Plus(p, C1)), C1)), -1)), Int(Power(Plus(a, Times(b, Power(x, n))), p), x), x))), And(FreeQ(List(a, b, c, d, n), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0), NeQ(Plus(Times(n, Plus(p, C1)), C1), C0)))),
            IIntegrate(389, Int(Times(Power(Plus($p("a1"), Times($p("b1", true), Power(x_, $p("non2", true)))), p_DEFAULT), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, $p("non2", true)))), p_DEFAULT), Plus(c_, Times(d_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Plus(Simp(Times(d, x, Power(Plus($s("a1"), Times($s("b1"), Power(x, Times(C1D2, n)))), Plus(p, C1)), Power(Plus($s("a2"), Times($s("b2"), Power(x, Times(C1D2, n)))), Plus(p, C1)), Power(Times($s("b1"), $s("b2"), Plus(Times(n, Plus(p, C1)), C1)), -1)), x), Negate(Dist(Times(Plus(Times($s("a1"), $s("a2"), d), Times(CN1, $s("b1"), $s("b2"), c, Plus(Times(n, Plus(p, C1)), C1))), Power(Times($s("b1"), $s("b2"), Plus(Times(n, Plus(p, C1)), C1)), -1)), Int(Times(Power(Plus($s("a1"), Times($s("b1"), Power(x, Times(C1D2, n)))), p), Power(Plus($s("a2"), Times($s("b2"), Power(x, Times(C1D2, n)))), p)), x), x))), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), c, d, n, p), x), EqQ($s("non2"), Times(C1D2, n)), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), NeQ(Plus(Times(n, Plus(p, C1)), C1), C0)))),
            IIntegrate(390, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(Int(PolynomialDivide(Power(Plus(a, Times(b, Power(x, n))), p), Power(Plus(c, Times(d, Power(x, n))), Negate(q)), x), x), And(FreeQ(List(a, b, c, d), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0), IGtQ(n, C0), IGtQ(p, C0), ILtQ(q, C0), GeQ(p, Negate(q))))),
            IIntegrate(391, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), -1), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), -1)), x_Symbol),
                    Condition(Plus(Dist(Times(b, Power(Plus(Times(b, c), Times(CN1, a, d)), -1)), Int(Power(Plus(a, Times(b, Power(x, n))), -1), x), x), Negate(Dist(Times(d, Power(Plus(Times(b, c), Times(CN1, a, d)), -1)), Int(Power(Plus(c, Times(d, Power(x, n))), -1), x), x))), And(FreeQ(List(a, b, c, d, n), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0)))),
            IIntegrate(392, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1D3), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), -1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(b, Power(a, -1)), C2))), Plus(Simp(Times(q, ArcTanh(Times(CSqrt3, Power(Times(q, x), -1))), Power(Times(C2, Power(C2, QQ(2L, 3L)), CSqrt3, Power(a, C1D3), d), -1)), x), Negate(Simp(Times(q, ArcTan(Times(Power(a, C1D3), q, x, Power(Plus(Power(a, C1D3), Times(Power(C2, C1D3), Power(Plus(a, Times(b, Sqr(x))), C1D3))), -1))), Power(Times(C2, Power(C2, QQ(2L, 3L)), Power(a, C1D3), d), -1)), x)), Simp(Times(q, ArcTan(Times(q, x)), Power(Times(C6, Power(C2, QQ(2L, 3L)), Power(a, C1D3), d), -1)), x), Simp(Times(q, ArcTanh(Times(CSqrt3, Plus(Power(a, C1D3), Times(CN1, Power(C2, C1D3), Power(Plus(a, Times(b, Sqr(x))), C1D3))), Power(Times(Power(a, C1D3), q, x), -1))), Power(Times(C2, Power(C2, QQ(2L, 3L)), CSqrt3, Power(a, C1D3), d), -1)), x))), And(FreeQ(List(a, b, c, d), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0), EqQ(Plus(Times(b, c), Times(C3, a, d)), C0), PosQ(Times(b, Power(a, -1)))))),
            IIntegrate(393, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1D3), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), -1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(CN1, b, Power(a, -1)), C2))), Plus(Simp(Times(q, ArcTan(Times(CSqrt3, Power(Times(q, x), -1))), Power(Times(C2, Power(C2, QQ(2L, 3L)), CSqrt3, Power(a, C1D3), d), -1)), x), Simp(Times(q, ArcTanh(Times(Power(a, C1D3), q, x, Power(Plus(Power(a, C1D3), Times(Power(C2, C1D3), Power(Plus(a, Times(b, Sqr(x))), C1D3))), -1))), Power(Times(C2, Power(C2, QQ(2L, 3L)), Power(a, C1D3), d), -1)), x), Negate(Simp(Times(q, ArcTanh(Times(q, x)), Power(Times(C6, Power(C2, QQ(2L, 3L)), Power(a, C1D3), d), -1)), x)), Simp(Times(q, ArcTan(Times(CSqrt3, Plus(Power(a, C1D3), Times(CN1, Power(C2, C1D3), Power(Plus(a, Times(b, Sqr(x))), C1D3))), Power(Times(Power(a, C1D3), q, x), -1))), Power(Times(C2, Power(C2, QQ(2L, 3L)), CSqrt3, Power(a, C1D3), d), -1)), x))), And(FreeQ(List(a, b, c, d), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0), EqQ(Plus(Times(b, c), Times(C3, a, d)), C0), NegQ(Times(b, Power(a, -1)))))),
            IIntegrate(394, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1D3), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), -1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(b, Power(a, -1)), C2))), Plus(Simp(Times(q, ArcTan(Times(C1D3, q, x)), Power(Times(ZZ(12L), Rt(a, C3), d), -1)), x), Simp(Times(q, ArcTan(Times(Sqr(Plus(Rt(a, C3), Negate(Power(Plus(a, Times(b, Sqr(x))), C1D3)))), Power(Times(C3, Sqr(Rt(a, C3)), q, x), -1))), Power(Times(ZZ(12L), Rt(a, C3), d), -1)), x), Negate(Simp(Times(q, ArcTanh(Times(CSqrt3, Plus(Rt(a, C3), Negate(Power(Plus(a, Times(b, Sqr(x))), C1D3))), Power(Times(Rt(a, C3), q, x), -1))), Power(Times(C4, CSqrt3, Rt(a, C3), d), -1)), x)))), And(FreeQ(List(a, b, c, d), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0), EqQ(Plus(Times(b, c), Times(CN1, C9, a, d)), C0), PosQ(Times(b, Power(a, -1)))))),
            IIntegrate(395, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1D3), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), -1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(CN1, b, Power(a, -1)), C2))), Plus(Negate(Simp(Times(q, ArcTanh(Times(C1D3, q, x)), Power(Times(ZZ(12L), Rt(a, C3), d), -1)), x)), Simp(Times(q, ArcTanh(Times(Sqr(Plus(Rt(a, C3), Negate(Power(Plus(a, Times(b, Sqr(x))), C1D3)))), Power(Times(C3, Sqr(Rt(a, C3)), q, x), -1))), Power(Times(ZZ(12L), Rt(a, C3), d), -1)), x), Negate(Simp(Times(q, ArcTan(Times(CSqrt3, Plus(Rt(a, C3), Negate(Power(Plus(a, Times(b, Sqr(x))), C1D3))), Power(Times(Rt(a, C3), q, x), -1))), Power(Times(C4, CSqrt3, Rt(a, C3), d), -1)), x)))), And(FreeQ(List(a, b, c, d), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0), EqQ(Plus(Times(b, c), Times(CN1, C9, a, d)), C0), NegQ(Times(b, Power(a, -1)))))),
            IIntegrate(396, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), QQ(2L, 3L)), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), -1)), x_Symbol),
                    Condition(Plus(Dist(Times(b, Power(d, -1)), Int(Power(Plus(a, Times(b, Sqr(x))), CN1D3), x), x), Negate(Dist(Times(Plus(Times(b, c), Times(CN1, a, d)), Power(d, -1)), Int(Power(Times(Power(Plus(a, Times(b, Sqr(x))), C1D3), Plus(c, Times(d, Sqr(x)))), -1), x), x))), And(FreeQ(List(a, b, c, d), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0), EqQ(Plus(Times(b, c), Times(C3, a, d)), C0)))),
            IIntegrate(397, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1D4), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), -1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(Sqr(b), Power(a, -1)), C4))), Plus(Negate(Simp(Times(b, ArcTan(Times(Plus(b, Times(Sqr(q), Sqrt(Plus(a, Times(b, Sqr(x)))))), Power(Times(Power(q, 3), x, Power(Plus(a, Times(b, Sqr(x))), C1D4)), -1))), Power(Times(C2, a, d, q), -1)), x)), Negate(Simp(Times(b, ArcTanh(Times(Plus(b, Times(CN1, Sqr(q), Sqrt(Plus(a, Times(b, Sqr(x)))))), Power(Times(Power(q, 3), x, Power(Plus(a, Times(b, Sqr(x))), C1D4)), -1))), Power(Times(C2, a, d, q), -1)), x)))), And(FreeQ(List(a, b, c, d), x), EqQ(Plus(Times(b, c), Times(CN1, C2, a, d)), C0), PosQ(Times(Sqr(b), Power(a, -1)))))),
            IIntegrate(398, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1D4), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), -1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(CN1, Sqr(b), Power(a, -1)), C4))), Plus(Simp(Times(b, ArcTan(Times(q, x, Power(Times(CSqrt2, Power(Plus(a, Times(b, Sqr(x))), C1D4)), -1))), Power(Times(C2, CSqrt2, a, d, q), -1)), x), Simp(Times(b, ArcTanh(Times(q, x, Power(Times(CSqrt2, Power(Plus(a, Times(b, Sqr(x))), C1D4)), -1))), Power(Times(C2, CSqrt2, a, d, q), -1)), x))), And(FreeQ(List(a, b, c, d), x), EqQ(Plus(Times(b, c), Times(CN1, C2, a, d)), C0), NegQ(Times(Sqr(b), Power(a, -1)))))),
            IIntegrate(399, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1D4), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), -1)), x_Symbol),
                    Condition(Dist(Times(C2, Sqrt(Times(CN1, b, Sqr(x), Power(a, -1))), Power(x, -1)), Subst(Int(Times(Sqr(x), Power(Times(Sqrt(Plus(C1, Times(CN1, Power(x, 4), Power(a, -1)))), Plus(Times(b, c), Times(CN1, a, d), Times(d, Power(x, 4)))), -1)), x), x, Power(Plus(a, Times(b, Sqr(x))), C1D4)), x), And(FreeQ(List(a, b, c, d), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0)))),
            IIntegrate(400, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), QQ(-3L, 4L)), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), -1)), x_Symbol),
                    Condition(Plus(Dist(Power(c, -1), Int(Power(Plus(a, Times(b, Sqr(x))), QQ(-3L, 4L)), x), x), Negate(Dist(Times(d, Power(c, -1)), Int(Times(Sqr(x), Power(Times(Power(Plus(a, Times(b, Sqr(x))), QQ(3L, 4L)), Plus(c, Times(d, Sqr(x)))), -1)), x), x))), And(FreeQ(List(a, b, c, d), x), EqQ(Plus(Times(b, c), Times(CN1, C2, a, d)), C0))))
    );
}
