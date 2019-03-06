package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

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
import static org.matheclipse.core.expression.F.Log;
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
import static org.matheclipse.core.expression.F.Simplify;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Sum;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.Unequal;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
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
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.r;
import static org.matheclipse.core.expression.F.s;
import static org.matheclipse.core.expression.F.u;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntBinomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NegQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RemoveContent;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SplitProduct;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules5 {
    public static IAST RULES = List(
            IIntegrate(251, Int(Times(Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(Negate(Subst(Int(Times(Power(Plus($s("a1"), Times($s("b1"), Power(Power(x, n), -1))), p), Power(Plus($s("a2"), Times($s("b2"), Power(Power(x, n), -1))), p), Power(x, -2)), x), x, Power(x, -1))), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), p), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), ILtQ(Times(C2, n), C0)))),
            IIntegrate(252, Int(Times(Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(With(List(Set(k, Denominator(Times(C2, n)))), Dist(k, Subst(Int(Times(Power(x, Plus(k, Negate(C1))), Power(Plus($s("a1"), Times($s("b1"), Power(x, Times(k, n)))), p), Power(Plus($s("a2"), Times($s("b2"), Power(x, Times(k, n)))), p)), x), x, Power(x, Power(k, -1))), x)), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), p), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), FractionQ(Times(C2, n))))),
            IIntegrate(253, Int(Times(Power(Plus($p("a1", true), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2", true), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), FracPart(p)), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), FracPart(p)), Power(Power(Plus(Times($s("a1"), $s("a2")), Times($s("b1"), $s("b2"), Power(x, Times(C2, n)))), FracPart(p)), -1)), Int(Power(Plus(Times($s("a1"), $s("a2")), Times($s("b1"), $s("b2"), Power(x, Times(C2, n)))), p), x), x), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), n, p), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), Not(IntegerQ(p))))),
            IIntegrate(254, Int(Power(Plus(a_, Times(b_DEFAULT, Power(Times(c_DEFAULT, Power(x_, q_DEFAULT)), n_))), p_DEFAULT), x_Symbol),
                    Condition(Dist(Times(x, Power(Power(Times(c, Power(x, q)), Power(q, -1)), -1)), Subst(Int(Power(Plus(a, Times(b, Power(x, Times(n, q)))), p), x), x, Power(Times(c, Power(x, q)), Power(q, -1))), x), And(FreeQ(List(a, b, c, n, p, q), x), IntegerQ(Times(n, q)), NeQ(x, Power(Times(c, Power(x, q)), Power(q, -1)))))),
            IIntegrate(255, Int(Power(Plus(a_, Times(b_DEFAULT, Power(Times(c_DEFAULT, Power(x_, q_DEFAULT)), n_))), p_DEFAULT), x_Symbol),
                    Condition(With(List(Set(k, Denominator(n))), Subst(Int(Power(Plus(a, Times(b, Power(c, n), Power(x, Times(n, q)))), p), x), Power(x, Power(k, -1)), Times(Power(Times(c, Power(x, q)), Power(k, -1)), Power(Times(Power(c, Power(k, -1)), Power(Power(x, Power(k, -1)), Plus(q, Negate(C1)))), -1)))), And(FreeQ(List(a, b, c, p, q), x), FractionQ(n)))),
            IIntegrate(256, Int(Power(Plus(a_, Times(b_DEFAULT, Power(Times(c_DEFAULT, Power(x_, q_DEFAULT)), n_))), p_DEFAULT), x_Symbol),
                    Condition(Subst(Int(Power(Plus(a, Times(b, Power(c, n), Power(x, Times(n, q)))), p), x), Power(x, Times(n, q)), Times(Power(Times(c, Power(x, q)), n), Power(Power(c, n), -1))), And(FreeQ(List(a, b, c, n, p, q), x), Not(RationalQ(n))))),
            IIntegrate(257, Int(Power(Plus(a_, Times(b_DEFAULT, Power(Times(d_DEFAULT, Power(x_, q_DEFAULT)), n_))), p_DEFAULT), x_Symbol),
                    Condition(Negate(Subst(Int(Times(Power(Plus(a, Times(b, Power(Times(d, Power(Power(x, q), -1)), n))), p), Power(x, -2)), x), x, Power(x, -1))), And(FreeQ(List(a, b, d, n, p), x), ILtQ(q, C0)))),
            IIntegrate(258, Int(Power(Plus(a_, Times(b_DEFAULT, Power(Times(d_DEFAULT, Power(x_, q_DEFAULT)), n_))), p_DEFAULT), x_Symbol),
                    Condition(With(List(Set(s, Denominator(q))), Dist(s, Subst(Int(Times(Power(x, Plus(s, Negate(C1))), Power(Plus(a, Times(b, Power(Times(d, Power(x, Times(q, s))), n))), p)), x), x, Power(x, Power(s, -1))), x)), And(FreeQ(List(a, b, d, n, p), x), FractionQ(q)))),
            IIntegrate(259, Int(Times(Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(Int(Times(Power(Times(c, x), m), Power(Plus(Times($s("a1"), $s("a2")), Times($s("b1"), $s("b2"), Power(x, Times(C2, n)))), p)), x), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), c, m, n, p), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), Or(IntegerQ(p), And(GtQ($s("a1"), C0), GtQ($s("a2"), C0)))))),
            IIntegrate(260, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), -1)), x_Symbol),
                    Condition(Simp(Times(Log(RemoveContent(Plus(a, Times(b, Power(x, n))), x)), Power(Times(b, n), -1)), x), And(FreeQ(List(a, b, m, n), x), EqQ(m, Plus(n, Negate(C1)))))),
            IIntegrate(261, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Simp(Times(Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Times(b, n, Plus(p, C1)), -1)), x), And(FreeQ(List(a, b, m, n, p), x), EqQ(m, Plus(n, Negate(C1))), NeQ(p, CN1)))),
            IIntegrate(262, Int(Times(Power(x_, m_DEFAULT), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_DEFAULT))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_DEFAULT))), p_)), x_Symbol),
                    Condition(Simp(Times(Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), Plus(p, C1)), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), Plus(p, C1)), Power(Times(C2, $s("b1"), $s("b2"), n, Plus(p, C1)), -1)), x), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), m, n, p), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), EqQ(m, Plus(Times(C2, n), Negate(C1))), NeQ(p, CN1)))),
            IIntegrate(263, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Int(Times(Power(x, Plus(m, Times(n, p))), Power(Plus(b, Times(a, Power(Power(x, n), -1))), p)), x), And(FreeQ(List(a, b, m, n), x), IntegerQ(p), NegQ(n)))),
            IIntegrate(264, Int(Times(Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Simp(Times(Power(Times(c, x), Plus(m, C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Times(a, c, Plus(m, C1)), -1)), x), And(FreeQ(List(a, b, c, m, n, p), x), EqQ(Plus(Times(Plus(m, C1), Power(n, -1)), p, C1), C0), NeQ(m, CN1)))),
            IIntegrate(265, Int(Times(Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(Simp(Times(Power(Times(c, x), Plus(m, C1)), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), Plus(p, C1)), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), Plus(p, C1)), Power(Times($s("a1"), $s("a2"), c, Plus(m, C1)), -1)), x), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), c, m, n, p), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), EqQ(Plus(Times(Plus(m, C1), Power(Times(C2, n), -1)), p, C1), C0), NeQ(m, CN1)))),
            IIntegrate(266, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Power(n, -1), Subst(Int(Times(Power(x, Plus(Simplify(Times(Plus(m, C1), Power(n, -1))), Negate(C1))), Power(Plus(a, Times(b, x)), p)), x), x, Power(x, n)), x), And(FreeQ(List(a, b, m, n, p), x), IntegerQ(Simplify(Times(Plus(m, C1), Power(n, -1))))))),
            IIntegrate(267, Int(Times(Power(x_, m_DEFAULT), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Power(n, -1), Subst(Int(Times(Power(x, Plus(Simplify(Times(Plus(m, C1), Power(n, -1))), Negate(C1))), Power(Plus($s("a1"), Times($s("b1"), x)), p), Power(Plus($s("a2"), Times($s("b2"), x)), p)), x), x, Power(x, n)), x), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), m, n, p), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), IntegerQ(Simplify(Times(Plus(m, C1), Power(Times(C2, n), -1))))))),
            IIntegrate(268, Int(Times(Power(Times(c_, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(c, IntPart(m)), Power(Times(c, x), FracPart(m)), Power(Power(x, FracPart(m)), -1)), Int(Times(Power(x, m), Power(Plus(a, Times(b, Power(x, n))), p)), x), x), And(FreeQ(List(a, b, c, m, n, p), x), IntegerQ(Simplify(Times(Plus(m, C1), Power(n, -1))))))),
            IIntegrate(269, Int(Times(Power(Times(c_, x_), m_), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(c, IntPart(m)), Power(Times(c, x), FracPart(m)), Power(Power(x, FracPart(m)), -1)), Int(Times(Power(x, m), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), p), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), p)), x), x), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), c, m, n, p), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), IntegerQ(Simplify(Times(Plus(m, C1), Power(Times(C2, n), -1))))))),
            IIntegrate(270, Int(Times(Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Times(c, x), m), Power(Plus(a, Times(b, Power(x, n))), p)), x), x), And(FreeQ(List(a, b, c, m, n), x), IGtQ(p, C0)))),
            IIntegrate(271, Int(Times(Power(x_, m_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, Plus(m, C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Times(a, Plus(m, C1)), -1)), x), Negate(Dist(Times(b, Plus(m, Times(n, Plus(p, C1)), C1), Power(Times(a, Plus(m, C1)), -1)), Int(Times(Power(x, Plus(m, n)), Power(Plus(a, Times(b, Power(x, n))), p)), x), x))), And(FreeQ(List(a, b, m, n, p), x), ILtQ(Simplify(Plus(Times(Plus(m, C1), Power(n, -1)), p, C1)), C0), NeQ(m, CN1)))),
            IIntegrate(272, Int(Times(Power(x_, m_), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, Plus(m, C1)), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), Plus(p, C1)), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), Plus(p, C1)), Power(Times($s("a1"), $s("a2"), Plus(m, C1)), -1)), x), Negate(Dist(Times($s("b1"), $s("b2"), Plus(m, Times(C2, n, Plus(p, C1)), C1), Power(Times($s("a1"), $s("a2"), Plus(m, C1)), -1)), Int(Times(Power(x, Plus(m, Times(C2, n))), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), p), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), p)), x), x))), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), m, n, p), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), ILtQ(Simplify(Plus(Times(Plus(m, C1), Power(Times(C2, n), -1)), p, C1)), C0), NeQ(m, CN1)))),
            IIntegrate(273, Int(Times(Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Times(c, x), Plus(m, C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Times(a, c, n, Plus(p, C1)), -1)), x)), Dist(Times(Plus(m, Times(n, Plus(p, C1)), C1), Power(Times(a, n, Plus(p, C1)), -1)), Int(Times(Power(Times(c, x), m), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, c, m, n, p), x), ILtQ(Simplify(Plus(Times(Plus(m, C1), Power(n, -1)), p, C1)), C0), NeQ(p, CN1)))),
            IIntegrate(274, Int(Times(Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Times(c, x), Plus(m, C1)), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), Plus(p, C1)), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), Plus(p, C1)), Power(Times(C2, $s("a1"), $s("a2"), c, n, Plus(p, C1)), -1)), x)), Dist(Times(Plus(m, Times(C2, n, Plus(p, C1)), C1), Power(Times(C2, $s("a1"), $s("a2"), n, Plus(p, C1)), -1)), Int(Times(Power(Times(c, x), m), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), Plus(p, C1)), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), Plus(p, C1))), x), x)), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), c, m, n, p), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), ILtQ(Simplify(Plus(Times(Plus(m, C1), Power(Times(C2, n), -1)), p, C1)), C0), NeQ(p, CN1)))),
            IIntegrate(275, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(With(List(Set(k, GCD(Plus(m, C1), n))), Condition(Dist(Power(k, -1), Subst(Int(Times(Power(x, Plus(Times(Plus(m, C1), Power(k, -1)), Negate(C1))), Power(Plus(a, Times(b, Power(x, Times(n, Power(k, -1))))), p)), x), x, Power(x, k)), x), Unequal(k, C1))), And(FreeQ(List(a, b, p), x), IGtQ(n, C0), IntegerQ(m)))),
            IIntegrate(276, Int(Times(Power(x_, m_DEFAULT), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(With(List(Set(k, GCD(Plus(m, C1), Times(C2, n)))), Condition(Dist(Power(k, -1), Subst(Int(Times(Power(x, Plus(Times(Plus(m, C1), Power(k, -1)), Negate(C1))), Power(Plus($s("a1"), Times($s("b1"), Power(x, Times(n, Power(k, -1))))), p), Power(Plus($s("a2"), Times($s("b2"), Power(x, Times(n, Power(k, -1))))), p)), x), x, Power(x, k)), x), Unequal(k, C1))), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), p), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), IGtQ(Times(C2, n), C0), IntegerQ(m)))),
            IIntegrate(277, Int(Times(Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(c, x), Plus(m, C1)), Power(Plus(a, Times(b, Power(x, n))), p), Power(Times(c, Plus(m, C1)), -1)), x), Negate(Dist(Times(b, n, p, Power(Times(Power(c, n), Plus(m, C1)), -1)), Int(Times(Power(Times(c, x), Plus(m, n)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, Negate(C1)))), x), x))), And(FreeQ(List(a, b, c), x), IGtQ(n, C0), GtQ(p, C0), LtQ(m, CN1), Not(ILtQ(Times(Plus(m, Times(n, p), n, C1), Power(n, -1)), C0)), IntBinomialQ(a, b, c, n, m, p, x)))),
            IIntegrate(278, Int(Times(Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(c, x), Plus(m, C1)), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), p), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), p), Power(Times(c, Plus(m, C1)), -1)), x), Negate(Dist(Times(C2, $s("b1"), $s("b2"), n, p, Power(Times(Power(c, Times(C2, n)), Plus(m, C1)), -1)), Int(Times(Power(Times(c, x), Plus(m, Times(C2, n))), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), Plus(p, Negate(C1))), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), Plus(p, Negate(C1)))), x), x))), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), c, m), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), IGtQ(Times(C2, n), C0), GtQ(p, C0), LtQ(m, CN1), NeQ(Plus(m, Times(C2, n, p), C1), C0), IntBinomialQ(Times($s("a1"), $s("a2")), Times($s("b1"), $s("b2")), c, Times(C2, n), m, p, x)))),
            IIntegrate(279, Int(Times(Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(c, x), Plus(m, C1)), Power(Plus(a, Times(b, Power(x, n))), p), Power(Times(c, Plus(m, Times(n, p), C1)), -1)), x), Dist(Times(a, n, p, Power(Plus(m, Times(n, p), C1), -1)), Int(Times(Power(Times(c, x), m), Power(Plus(a, Times(b, Power(x, n))), Plus(p, Negate(C1)))), x), x)), And(FreeQ(List(a, b, c, m), x), IGtQ(n, C0), GtQ(p, C0), NeQ(Plus(m, Times(n, p), C1), C0), IntBinomialQ(a, b, c, n, m, p, x)))),
            IIntegrate(280, Int(Times(Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(c, x), Plus(m, C1)), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), p), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), p), Power(Times(c, Plus(m, Times(C2, n, p), C1)), -1)), x), Dist(Times(C2, $s("a1"), $s("a2"), n, p, Power(Plus(m, Times(C2, n, p), C1), -1)), Int(Times(Power(Times(c, x), m), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), Plus(p, Negate(C1))), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), Plus(p, Negate(C1)))), x), x)), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), c, m), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), IGtQ(Times(C2, n), C0), GtQ(p, C0), NeQ(Plus(m, Times(C2, n, p), C1), C0), IntBinomialQ(Times($s("a1"), $s("a2")), Times($s("b1"), $s("b2")), c, Times(C2, n), m, p, x)))),
            IIntegrate(281, Int(Times(Sqr(x_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, 4))), QQ(-5L, 4L))), x_Symbol),
                    Condition(Dist(Times(x, Power(Plus(C1, Times(a, Power(Times(b, Power(x, 4)), -1))), C1D4), Power(Times(b, Power(Plus(a, Times(b, Power(x, 4))), C1D4)), -1)), Int(Power(Times(Power(x, 3), Power(Plus(C1, Times(a, Power(Times(b, Power(x, 4)), -1))), QQ(5L, 4L))), -1), x), x), And(FreeQ(List(a, b), x), PosQ(Times(b, Power(a, -1)))))),
            IIntegrate(282, Int(Times(Power(x_, m_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, 4))), QQ(-5L, 4L))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, Plus(m, Negate(C3))), Power(Times(b, Plus(m, Negate(C4)), Power(Plus(a, Times(b, Power(x, 4))), C1D4)), -1)), x), Negate(Dist(Times(a, Plus(m, Negate(C3)), Power(Times(b, Plus(m, Negate(C4))), -1)), Int(Times(Power(x, Plus(m, Negate(C4))), Power(Plus(a, Times(b, Power(x, 4))), QQ(-5L, 4L))), x), x))), And(FreeQ(List(a, b), x), PosQ(Times(b, Power(a, -1))), IGtQ(Times(C1D4, Plus(m, Negate(C2))), C0)))),
            IIntegrate(283, Int(Times(Power(x_, m_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, 4))), QQ(-5L, 4L))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, Plus(m, C1)), Power(Times(a, Plus(m, C1), Power(Plus(a, Times(b, Power(x, 4))), C1D4)), -1)), x), Negate(Dist(Times(b, m, Power(Times(a, Plus(m, C1)), -1)), Int(Times(Power(x, Plus(m, C4)), Power(Plus(a, Times(b, Power(x, 4))), QQ(-5L, 4L))), x), x))), And(FreeQ(List(a, b), x), PosQ(Times(b, Power(a, -1))), ILtQ(Times(C1D4, Plus(m, Negate(C2))), C0)))),
            IIntegrate(284, Int(Times(Sqrt(Times(c_DEFAULT, x_)), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), QQ(-5L, 4L))), x_Symbol),
                    Condition(Dist(Times(Sqrt(Times(c, x)), Power(Plus(C1, Times(a, Power(Times(b, Sqr(x)), -1))), C1D4), Power(Times(b, Power(Plus(a, Times(b, Sqr(x))), C1D4)), -1)), Int(Power(Times(Sqr(x), Power(Plus(C1, Times(a, Power(Times(b, Sqr(x)), -1))), QQ(5L, 4L))), -1), x), x), And(FreeQ(List(a, b, c), x), PosQ(Times(b, Power(a, -1)))))),
            IIntegrate(285, Int(Times(Power(Times(c_DEFAULT, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), QQ(-5L, 4L))), x_Symbol),
                    Condition(Plus(Simp(Times(C2, c, Power(Times(c, x), Plus(m, Negate(C1))), Power(Times(b, Plus(Times(C2, m), Negate(C3)), Power(Plus(a, Times(b, Sqr(x))), C1D4)), -1)), x), Negate(Dist(Times(C2, a, Sqr(c), Plus(m, Negate(C1)), Power(Times(b, Plus(Times(C2, m), Negate(C3))), -1)), Int(Times(Power(Times(c, x), Plus(m, Negate(C2))), Power(Plus(a, Times(b, Sqr(x))), QQ(-5L, 4L))), x), x))), And(FreeQ(List(a, b, c), x), PosQ(Times(b, Power(a, -1))), IntegerQ(Times(C2, m)), GtQ(m, QQ(3L, 2L))))),
            IIntegrate(286, Int(Times(Power(Times(c_DEFAULT, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), QQ(-5L, 4L))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(c, x), Plus(m, C1)), Power(Times(a, c, Plus(m, C1), Power(Plus(a, Times(b, Sqr(x))), C1D4)), -1)), x), Negate(Dist(Times(b, Plus(Times(C2, m), C1), Power(Times(C2, a, Sqr(c), Plus(m, C1)), -1)), Int(Times(Power(Times(c, x), Plus(m, C2)), Power(Plus(a, Times(b, Sqr(x))), QQ(-5L, 4L))), x), x))), And(FreeQ(List(a, b, c), x), PosQ(Times(b, Power(a, -1))), IntegerQ(Times(C2, m)), LtQ(m, CN1)))),
            IIntegrate(287, Int(Times(Sqr(x_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, 4))), QQ(-5L, 4L))), x_Symbol),
                    Condition(Plus(Negate(Simp(Power(Times(b, x, Power(Plus(a, Times(b, Power(x, 4))), C1D4)), -1), x)), Negate(Dist(Power(b, -1), Int(Power(Times(Sqr(x), Power(Plus(a, Times(b, Power(x, 4))), C1D4)), -1), x), x))), And(FreeQ(List(a, b), x), NegQ(Times(b, Power(a, -1)))))),
            IIntegrate(288, Int(Times(Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(c, Plus(n, Negate(C1))), Power(Times(c, x), Plus(m, Negate(n), C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Times(b, n, Plus(p, C1)), -1)), x), Negate(Dist(Times(Power(c, n), Plus(m, Negate(n), C1), Power(Times(b, n, Plus(p, C1)), -1)), Int(Times(Power(Times(c, x), Plus(m, Negate(n))), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1))), x), x))), And(FreeQ(List(a, b, c), x), IGtQ(n, C0), LtQ(p, CN1), GtQ(Plus(m, C1), n), Not(ILtQ(Times(Plus(m, Times(n, Plus(p, C1)), C1), Power(n, -1)), C0)), IntBinomialQ(a, b, c, n, m, p, x)))),
            IIntegrate(289, Int(Times(Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(c, Plus(Times(C2, n), Negate(C1))), Power(Times(c, x), Plus(m, Times(CN1, C2, n), C1)), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), Plus(p, C1)), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), Plus(p, C1)), Power(Times(C2, $s("b1"), $s("b2"), n, Plus(p, C1)), -1)), x), Negate(Dist(Times(Power(c, Times(C2, n)), Plus(m, Times(CN1, C2, n), C1), Power(Times(C2, $s("b1"), $s("b2"), n, Plus(p, C1)), -1)), Int(Times(Power(Times(c, x), Plus(m, Times(CN1, C2, n))), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), Plus(p, C1)), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), Plus(p, C1))), x), x))), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), c), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), IGtQ(Times(C2, n), C0), LtQ(p, CN1), Greater(Plus(m, C1), Times(C2, n)), Not(ILtQ(Times(Plus(m, Times(C2, n, Plus(p, C1)), C1), Power(Times(C2, n), -1)), C0)), IntBinomialQ(Times($s("a1"), $s("a2")), Times($s("b1"), $s("b2")), c, Times(C2, n), m, p, x)))),
            IIntegrate(290, Int(Times(Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Times(c, x), Plus(m, C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Times(a, c, n, Plus(p, C1)), -1)), x)), Dist(Times(Plus(m, Times(n, Plus(p, C1)), C1), Power(Times(a, n, Plus(p, C1)), -1)), Int(Times(Power(Times(c, x), m), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, c, m), x), IGtQ(n, C0), LtQ(p, CN1), IntBinomialQ(a, b, c, n, m, p, x)))),
            IIntegrate(291, Int(Times(Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_))), p_), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Times(c, x), Plus(m, C1)), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), Plus(p, C1)), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), Plus(p, C1)), Power(Times(C2, $s("a1"), $s("a2"), c, n, Plus(p, C1)), -1)), x)), Dist(Times(Plus(m, Times(C2, n, Plus(p, C1)), C1), Power(Times(C2, $s("a1"), $s("a2"), n, Plus(p, C1)), -1)), Int(Times(Power(Times(c, x), m), Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), Plus(p, C1)), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), Plus(p, C1))), x), x)), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), c, m), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), IGtQ(Times(C2, n), C0), LtQ(p, CN1), IntBinomialQ(Times($s("a1"), $s("a2")), Times($s("b1"), $s("b2")), c, Times(C2, n), m, p, x)))),
            IIntegrate(292, Int(Times(x_, Power(Plus(a_, Times(b_DEFAULT, Power(x_, 3))), -1)), x_Symbol),
                    Condition(Plus(Negate(Dist(Power(Times(C3, Rt(a, C3), Rt(b, C3)), -1), Int(Power(Plus(Rt(a, C3), Times(Rt(b, C3), x)), -1), x), x)), Dist(Power(Times(C3, Rt(a, C3), Rt(b, C3)), -1), Int(Times(Plus(Rt(a, C3), Times(Rt(b, C3), x)), Power(Plus(Sqr(Rt(a, C3)), Times(CN1, Rt(a, C3), Rt(b, C3), x), Times(Sqr(Rt(b, C3)), Sqr(x))), -1)), x), x)), FreeQ(List(a, b), x))),
            IIntegrate(293, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), -1)), x_Symbol),
                    Condition(Module(List(Set(r, Numerator(Rt(Times(a, Power(b, -1)), n))), Set(s, Denominator(Rt(Times(a, Power(b, -1)), n))), k, u), Simp(CompoundExpression(Set(u, Int(Times(Plus(Times(r, Cos(Times(Plus(Times(C2, k), Negate(C1)), m, Pi, Power(n, -1)))), Times(CN1, s, Cos(Times(Plus(Times(C2, k), Negate(C1)), Plus(m, C1), Pi, Power(n, -1))), x)), Power(Plus(Sqr(r), Times(CN1, C2, r, s, Cos(Times(Plus(Times(C2, k), Negate(C1)), Pi, Power(n, -1))), x), Times(Sqr(s), Sqr(x))), -1)), x)), Plus(Times(CN1, Power(Negate(r), Plus(m, C1)), Int(Power(Plus(r, Times(s, x)), -1), x), Power(Times(a, n, Power(s, m)), -1)), Dist(Times(C2, Power(r, Plus(m, C1)), Power(Times(a, n, Power(s, m)), -1)), Sum(u, List(k, C1, Times(C1D2, Plus(n, Negate(C1))))), x))), x)), And(FreeQ(List(a, b), x), IGtQ(Times(C1D2, Plus(n, Negate(C1))), C0), IGtQ(m, C0), LtQ(m, Plus(n, Negate(C1))), PosQ(Times(a, Power(b, -1)))))),
            IIntegrate(294, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), -1)), x_Symbol),
                    Condition(Module(List(Set(r, Numerator(Rt(Times(CN1, a, Power(b, -1)), n))), Set(s, Denominator(Rt(Times(CN1, a, Power(b, -1)), n))), k, u), Simp(CompoundExpression(Set(u, Int(Times(Plus(Times(r, Cos(Times(Plus(Times(C2, k), Negate(C1)), m, Pi, Power(n, -1)))), Times(s, Cos(Times(Plus(Times(C2, k), Negate(C1)), Plus(m, C1), Pi, Power(n, -1))), x)), Power(Plus(Sqr(r), Times(C2, r, s, Cos(Times(Plus(Times(C2, k), Negate(C1)), Pi, Power(n, -1))), x), Times(Sqr(s), Sqr(x))), -1)), x)), Plus(Times(Power(r, Plus(m, C1)), Int(Power(Plus(r, Times(CN1, s, x)), -1), x), Power(Times(a, n, Power(s, m)), -1)), Negate(Dist(Times(C2, Power(Negate(r), Plus(m, C1)), Power(Times(a, n, Power(s, m)), -1)), Sum(u, List(k, C1, Times(C1D2, Plus(n, Negate(C1))))), x)))), x)), And(FreeQ(List(a, b), x), IGtQ(Times(C1D2, Plus(n, Negate(C1))), C0), IGtQ(m, C0), LtQ(m, Plus(n, Negate(C1))), NegQ(Times(a, Power(b, -1)))))),
            IIntegrate(295, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), -1)), x_Symbol),
                    Condition(Module(List(Set(r, Numerator(Rt(Times(a, Power(b, -1)), n))), Set(s, Denominator(Rt(Times(a, Power(b, -1)), n))), k, u), Simp(CompoundExpression(Set(u, Plus(Int(Times(Plus(Times(r, Cos(Times(Plus(Times(C2, k), Negate(C1)), m, Pi, Power(n, -1)))), Times(CN1, s, Cos(Times(Plus(Times(C2, k), Negate(C1)), Plus(m, C1), Pi, Power(n, -1))), x)), Power(Plus(Sqr(r), Times(CN1, C2, r, s, Cos(Times(Plus(Times(C2, k), Negate(C1)), Pi, Power(n, -1))), x), Times(Sqr(s), Sqr(x))), -1)), x), Int(Times(Plus(Times(r, Cos(Times(Plus(Times(C2, k), Negate(C1)), m, Pi, Power(n, -1)))), Times(s, Cos(Times(Plus(Times(C2, k), Negate(C1)), Plus(m, C1), Pi, Power(n, -1))), x)), Power(Plus(Sqr(r), Times(C2, r, s, Cos(Times(Plus(Times(C2, k), Negate(C1)), Pi, Power(n, -1))), x), Times(Sqr(s), Sqr(x))), -1)), x))), Plus(Times(C2, Power(CN1, Times(C1D2, m)), Power(r, Plus(m, C2)), Int(Power(Plus(Sqr(r), Times(Sqr(s), Sqr(x))), -1), x), Power(Times(a, n, Power(s, m)), -1)), Dist(Times(C2, Power(r, Plus(m, C1)), Power(Times(a, n, Power(s, m)), -1)), Sum(u, List(k, C1, Times(C1D4, Plus(n, Negate(C2))))), x))), x)), And(FreeQ(List(a, b), x), IGtQ(Times(C1D4, Plus(n, Negate(C2))), C0), IGtQ(m, C0), LtQ(m, Plus(n, Negate(C1))), PosQ(Times(a, Power(b, -1)))))),
            IIntegrate(296, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), -1)), x_Symbol),
                    Condition(Module(List(Set(r, Numerator(Rt(Times(CN1, a, Power(b, -1)), n))), Set(s, Denominator(Rt(Times(CN1, a, Power(b, -1)), n))), k, u), Simp(CompoundExpression(Set(u, Plus(Int(Times(Plus(Times(r, Cos(Times(C2, k, m, Pi, Power(n, -1)))), Times(CN1, s, Cos(Times(C2, k, Plus(m, C1), Pi, Power(n, -1))), x)), Power(Plus(Sqr(r), Times(CN1, C2, r, s, Cos(Times(C2, k, Pi, Power(n, -1))), x), Times(Sqr(s), Sqr(x))), -1)), x), Int(Times(Plus(Times(r, Cos(Times(C2, k, m, Pi, Power(n, -1)))), Times(s, Cos(Times(C2, k, Plus(m, C1), Pi, Power(n, -1))), x)), Power(Plus(Sqr(r), Times(C2, r, s, Cos(Times(C2, k, Pi, Power(n, -1))), x), Times(Sqr(s), Sqr(x))), -1)), x))), Plus(Times(C2, Power(r, Plus(m, C2)), Int(Power(Plus(Sqr(r), Times(CN1, Sqr(s), Sqr(x))), -1), x), Power(Times(a, n, Power(s, m)), -1)), Dist(Times(C2, Power(r, Plus(m, C1)), Power(Times(a, n, Power(s, m)), -1)), Sum(u, List(k, C1, Times(C1D4, Plus(n, Negate(C2))))), x))), x)), And(FreeQ(List(a, b), x), IGtQ(Times(C1D4, Plus(n, Negate(C2))), C0), IGtQ(m, C0), LtQ(m, Plus(n, Negate(C1))), NegQ(Times(a, Power(b, -1)))))),
            IIntegrate(297, Int(Times(Sqr(x_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, 4))), -1)), x_Symbol),
                    Condition(With(List(Set(r, Numerator(Rt(Times(a, Power(b, -1)), C2))), Set(s, Denominator(Rt(Times(a, Power(b, -1)), C2)))), Plus(Dist(Power(Times(C2, s), -1), Int(Times(Plus(r, Times(s, Sqr(x))), Power(Plus(a, Times(b, Power(x, 4))), -1)), x), x), Negate(Dist(Power(Times(C2, s), -1), Int(Times(Plus(r, Times(CN1, s, Sqr(x))), Power(Plus(a, Times(b, Power(x, 4))), -1)), x), x)))), And(FreeQ(List(a, b), x), Or(GtQ(Times(a, Power(b, -1)), C0), And(PosQ(Times(a, Power(b, -1))), AtomQ(SplitProduct($rubi("SumBaseQ"), a)), AtomQ(SplitProduct($rubi("SumBaseQ"), b))))))),
            IIntegrate(298, Int(Times(Sqr(x_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, 4))), -1)), x_Symbol),
                    Condition(With(List(Set(r, Numerator(Rt(Times(CN1, a, Power(b, -1)), C2))), Set(s, Denominator(Rt(Times(CN1, a, Power(b, -1)), C2)))), Plus(Dist(Times(s, Power(Times(C2, b), -1)), Int(Power(Plus(r, Times(s, Sqr(x))), -1), x), x), Negate(Dist(Times(s, Power(Times(C2, b), -1)), Int(Power(Plus(r, Times(CN1, s, Sqr(x))), -1), x), x)))), And(FreeQ(List(a, b), x), Not(GtQ(Times(a, Power(b, -1)), C0))))),
            IIntegrate(299, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), -1)), x_Symbol),
                    Condition(With(List(Set(r, Numerator(Rt(Times(a, Power(b, -1)), C4))), Set(s, Denominator(Rt(Times(a, Power(b, -1)), C4)))), Plus(Dist(Times(Power(s, 3), Power(Times(C2, CSqrt2, b, r), -1)), Int(Times(Power(x, Plus(m, Times(CN1, C1D4, n))), Power(Plus(Sqr(r), Times(CN1, CSqrt2, r, s, Power(x, Times(C1D4, n))), Times(Sqr(s), Power(x, Times(C1D2, n)))), -1)), x), x), Negate(Dist(Times(Power(s, 3), Power(Times(C2, CSqrt2, b, r), -1)), Int(Times(Power(x, Plus(m, Times(CN1, C1D4, n))), Power(Plus(Sqr(r), Times(CSqrt2, r, s, Power(x, Times(C1D4, n))), Times(Sqr(s), Power(x, Times(C1D2, n)))), -1)), x), x)))), And(FreeQ(List(a, b), x), IGtQ(Times(C1D4, n), C0), IGtQ(m, C0), LtQ(m, Plus(n, Negate(C1))), GtQ(Times(a, Power(b, -1)), C0)))),
            IIntegrate(300, Int(Times(Power(x_, m_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), -1)), x_Symbol),
                    Condition(With(List(Set(r, Numerator(Rt(Times(CN1, a, Power(b, -1)), C2))), Set(s, Denominator(Rt(Times(CN1, a, Power(b, -1)), C2)))), Plus(Dist(Times(r, Power(Times(C2, a), -1)), Int(Times(Power(x, m), Power(Plus(r, Times(s, Power(x, Times(C1D2, n)))), -1)), x), x), Dist(Times(r, Power(Times(C2, a), -1)), Int(Times(Power(x, m), Power(Plus(r, Times(CN1, s, Power(x, Times(C1D2, n)))), -1)), x), x))), And(FreeQ(List(a, b), x), IGtQ(Times(C1D4, n), C0), IGtQ(m, C0), LtQ(m, Times(C1D2, n)), Not(GtQ(Times(a, Power(b, -1)), C0)))))
    );
}
