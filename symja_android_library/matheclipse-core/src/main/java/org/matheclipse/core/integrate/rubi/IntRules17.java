package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.AppellF1;
import static org.matheclipse.core.expression.F.ArcTan;
import static org.matheclipse.core.expression.F.ArcTanh;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C1D4;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN1D4;
import static org.matheclipse.core.expression.F.CSqrt2;
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
import static org.matheclipse.core.expression.F.QQ;
import static org.matheclipse.core.expression.F.Simplify;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.a_DEFAULT;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_;
import static org.matheclipse.core.expression.F.e_DEFAULT;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NegQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NormalizePseudoBinomial;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PseudoBinomialPairQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules17 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(426, Int(Times(Sqrt(Plus(a_, Times(b_DEFAULT, Sqr(x_)))), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Plus(a, Times(b, Sqr(x)))), Power(Plus(C1, Times(b, Sqr(x), Power(a, CN1))), CN1D2)), Int(Times(Sqrt(Plus(C1, Times(b, Sqr(x), Power(a, CN1)))), Power(Plus(c, Times(d, Sqr(x))), CN1D2)), x), x), And(FreeQ(List(a, b, c, d), x), NegQ(Times(d, Power(c, CN1))), GtQ(c, C0), Not(GtQ(a, C0)))));
            IIntegrate(427, Int(Times(Sqrt(Plus(a_, Times(b_DEFAULT, Sqr(x_)))), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Plus(C1, Times(d, Sqr(x), Power(c, CN1)))), Power(Plus(c, Times(d, Sqr(x))), CN1D2)), Int(Times(Sqrt(Plus(a, Times(b, Sqr(x)))), Power(Plus(C1, Times(d, Sqr(x), Power(c, CN1))), CN1D2)), x), x), And(FreeQ(List(a, b, c, d), x), NegQ(Times(d, Power(c, CN1))), Not(GtQ(c, C0)))));
            IIntegrate(428, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(a, Times(b, Power(x, n))), p), Power(Plus(c, Times(d, Power(x, n))), q)), x), x), And(FreeQ(List(a, b, c, d, n, q), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), IGtQ(p, C0))));
            IIntegrate(429, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(Simp(Times(Power(a, p), Power(c, q), x, AppellF1(Power(n, CN1), Negate(p), Negate(q), Plus(C1, Power(n, CN1)), Times(CN1, b, Power(x, n), Power(a, CN1)), Times(CN1, d, Power(x, n), Power(c, CN1)))), x), And(FreeQ(List(a, b, c, d, n, p, q), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(n, CN1), Or(IntegerQ(p), GtQ(a, C0)), Or(IntegerQ(q), GtQ(c, C0)))));
            IIntegrate(430, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(Dist(Times(Power(a, IntPart(p)), Power(Plus(a, Times(b, Power(x, n))), FracPart(p)), Power(Power(Plus(C1, Times(b, Power(x, n), Power(a, CN1))), FracPart(p)), CN1)), Int(Times(Power(Plus(C1, Times(b, Power(x, n), Power(a, CN1))), p), Power(Plus(c, Times(d, Power(x, n))), q)), x), x), And(FreeQ(List(a, b, c, d, n, p, q), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(n, CN1), Not(Or(IntegerQ(p), GtQ(a, C0))))));
            IIntegrate(431, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(u_, n_))), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, Power(u_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Coefficient(u, x, C1), CN1), Subst(Int(Times(Power(Plus(a, Times(b, Power(x, n))), p), Power(Plus(c, Times(d, Power(x, n))), q)), x), x, u), x), And(FreeQ(List(a, b, c, d, n, p, q), x), LinearQ(u, x), NeQ(u, x))));
            IIntegrate(432, Int(Times(Power(u_, p_DEFAULT), Power(v_, q_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(NormalizePseudoBinomial(u, x), p), Power(NormalizePseudoBinomial(v, x), q)), x), And(FreeQ(List(p, q), x), PseudoBinomialPairQ(u, v, x))));
            IIntegrate(433, Int(Times(Power(u_, p_DEFAULT), Power(v_, q_DEFAULT), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(NormalizePseudoBinomial(Times(Power(x, Times(m, Power(p, CN1))), u), x), p), Power(NormalizePseudoBinomial(v, x), q)), x), And(FreeQ(List(p, q), x), IntegersQ(p, Times(m, Power(p, CN1))), PseudoBinomialPairQ(Times(Power(x, Times(m, Power(p, CN1))), u), v, x))));
            IIntegrate(434, Int(Times(Power(Plus(c_, Times(d_DEFAULT, Power(x_, $p("mn", true)))), q_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_DEFAULT))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Plus(a, Times(b, Power(x, n))), p), Power(Plus(d, Times(c, Power(x, n))), q), Power(Power(x, Times(n, q)), CN1)), x), And(FreeQ(List(a, b, c, d, n, p), x), EqQ($s("mn"), Negate(n)), IntegerQ(q), Or(PosQ(n), Not(IntegerQ(p))))));
            IIntegrate(435, Int(Times(Power(Plus(c_, Times(d_DEFAULT, Power(x_, $p("mn", true)))), q_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_DEFAULT))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(x, Times(n, FracPart(q))), Power(Plus(c, Times(d, Power(Power(x, n), CN1))), FracPart(q)), Power(Power(Plus(d, Times(c, Power(x, n))), FracPart(q)), CN1)), Int(Times(Power(Plus(a, Times(b, Power(x, n))), p), Power(Plus(d, Times(c, Power(x, n))), q), Power(Power(x, Times(n, q)), CN1)), x), x), And(FreeQ(List(a, b, c, d, n, p, q), x), EqQ($s("mn"), Negate(n)), Not(IntegerQ(q)), Not(IntegerQ(p)))));
            IIntegrate(436, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Times(b_DEFAULT, Power(x_, n_)), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(e, m), Power(Times(n, Power(b, Subtract(Simplify(Times(Plus(m, C1), Power(n, CN1))), C1))), CN1)), Subst(Int(Times(Power(Times(b, x), Subtract(Plus(p, Simplify(Times(Plus(m, C1), Power(n, CN1)))), C1)), Power(Plus(c, Times(d, x)), q)), x), x, Power(x, n)), x), And(FreeQ(List(b, c, d, e, m, n, p, q), x), Or(IntegerQ(m), GtQ(e, C0)), IntegerQ(Simplify(Times(Plus(m, C1), Power(n, CN1)))))));
            IIntegrate(437, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Times(b_DEFAULT, Power(x_, n_DEFAULT)), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(e, m), Power(b, IntPart(p)), Power(Times(b, Power(x, n)), FracPart(p)), Power(Power(x, Times(n, FracPart(p))), CN1)), Int(Times(Power(x, Plus(m, Times(n, p))), Power(Plus(c, Times(d, Power(x, n))), q)), x), x), And(FreeQ(List(b, c, d, e, m, n, p, q), x), Or(IntegerQ(m), GtQ(e, C0)), Not(IntegerQ(Simplify(Times(Plus(m, C1), Power(n, CN1))))))));
            IIntegrate(438, Int(Times(Power(Times(e_, x_), m_), Power(Times(b_DEFAULT, Power(x_, n_DEFAULT)), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(e, IntPart(m)), Power(Times(e, x), FracPart(m)), Power(Power(x, FracPart(m)), CN1)), Int(Times(Power(x, m), Power(Times(b, Power(x, n)), p), Power(Plus(c, Times(d, Power(x, n))), q)), x), x), And(FreeQ(List(b, c, d, e, m, n, p, q), x), Not(IntegerQ(m)))));
            IIntegrate(439, Int(Times(x_, Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1D4), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Subtract(Negate(Simp(Times(ArcTan(Times(Subtract(Sqr(Rt(a, C4)), Sqrt(Plus(a, Times(b, Sqr(x))))), Power(Times(CSqrt2, Rt(a, C4), Power(Plus(a, Times(b, Sqr(x))), C1D4)), CN1))), Power(Times(CSqrt2, Rt(a, C4), d), CN1)), x)), Simp(Times(C1, ArcTanh(Times(Plus(Sqr(Rt(a, C4)), Sqrt(Plus(a, Times(b, Sqr(x))))), Power(Times(CSqrt2, Rt(a, C4), Power(Plus(a, Times(b, Sqr(x))), C1D4)), CN1))), Power(Times(CSqrt2, Rt(a, C4), d), CN1)), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Subtract(Times(b, c), Times(C2, a, d)), C0), PosQ(a))));
            IIntegrate(440, Int(Times(Power(x_, m_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1D4), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(x, m), Power(Times(Power(Plus(a, Times(b, Sqr(x))), C1D4), Plus(c, Times(d, Sqr(x)))), CN1)), x), x), And(FreeQ(List(a, b, c, d), x), EqQ(Subtract(Times(b, c), Times(C2, a, d)), C0), IntegerQ(m), Or(PosQ(a), IntegerQ(Times(C1D2, m))))));
            IIntegrate(441, Int(Times(Sqr(x_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), QQ(-3L, 4L)), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, ArcTan(Times(Plus(b, Times(Sqr(Rt(Times(Sqr(b), Power(a, CN1)), C4)), Sqrt(Plus(a, Times(b, Sqr(x)))))), Power(Times(Power(Rt(Times(Sqr(b), Power(a, CN1)), C4), C3), x, Power(Plus(a, Times(b, Sqr(x))), C1D4)), CN1))), Power(Times(a, d, Power(Rt(Times(Sqr(b), Power(a, CN1)), C4), C3)), CN1)), x)), Simp(Times(b, ArcTanh(Times(Subtract(b, Times(Sqr(Rt(Times(Sqr(b), Power(a, CN1)), C4)), Sqrt(Plus(a, Times(b, Sqr(x)))))), Power(Times(Power(Rt(Times(Sqr(b), Power(a, CN1)), C4), C3), x, Power(Plus(a, Times(b, Sqr(x))), C1D4)), CN1))), Power(Times(a, d, Power(Rt(Times(Sqr(b), Power(a, CN1)), C4), C3)), CN1)), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Subtract(Times(b, c), Times(C2, a, d)), C0), PosQ(Times(Sqr(b), Power(a, CN1))))));
            IIntegrate(442, Int(Times(Sqr(x_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), QQ(-3L, 4L)), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, ArcTan(Times(Rt(Times(CN1, Sqr(b), Power(a, CN1)), C4), x, Power(Times(CSqrt2, Power(Plus(a, Times(b, Sqr(x))), C1D4)), CN1))), Power(Times(CSqrt2, a, d, Power(Rt(Times(CN1, Sqr(b), Power(a, CN1)), C4), C3)), CN1)), x)), Simp(Times(b, ArcTanh(Times(Rt(Times(CN1, Sqr(b), Power(a, CN1)), C4), x, Power(Times(CSqrt2, Power(Plus(a, Times(b, Sqr(x))), C1D4)), CN1))), Power(Times(CSqrt2, a, d, Power(Rt(Times(CN1, Sqr(b), Power(a, CN1)), C4), C3)), CN1)), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Subtract(Times(b, c), Times(C2, a, d)), C0), NegQ(Times(Sqr(b), Power(a, CN1))))));
            IIntegrate(443, Int(Times(Power(x_, m_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), QQ(-3L, 4L)), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(x, m), Power(Times(Power(Plus(a, Times(b, Sqr(x))), QQ(3L, 4L)), Plus(c, Times(d, Sqr(x)))), CN1)), x), x), And(FreeQ(List(a, b, c, d), x), EqQ(Subtract(Times(b, c), Times(C2, a, d)), C0), IntegerQ(m), Or(PosQ(a), IntegerQ(Times(C1D2, m))))));
            IIntegrate(444, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(n, CN1), Subst(Int(Times(Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), x), x, Power(x, n)), x), And(FreeQ(List(a, b, c, d, m, n, p, q), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(m, Negate(n), C1), C0))));
            IIntegrate(445, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(x, Plus(m, Times(n, Plus(p, q)))), Power(Plus(b, Times(a, Power(Power(x, n), CN1))), p), Power(Plus(d, Times(c, Power(Power(x, n), CN1))), q)), x), And(FreeQ(List(a, b, c, d, m, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), IntegersQ(p, q), NegQ(n))));
            IIntegrate(446, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(n, CN1), Subst(Int(Times(Power(x, Subtract(Simplify(Times(Plus(m, C1), Power(n, CN1))), C1)), Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), x), x, Power(x, n)), x), And(FreeQ(List(a, b, c, d, m, n, p, q), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), IntegerQ(Simplify(Times(Plus(m, C1), Power(n, CN1)))))));
            IIntegrate(447, Int(Times(Power(Times(e_, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(e, IntPart(m)), Power(Times(e, x), FracPart(m)), Power(Power(x, FracPart(m)), CN1)), Int(Times(Power(x, m), Power(Plus(a, Times(b, Power(x, n))), p), Power(Plus(c, Times(d, Power(x, n))), q)), x), x), And(FreeQ(List(a, b, c, d, e, m, n, p, q), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), IntegerQ(Simplify(Times(Plus(m, C1), Power(n, CN1)))))));
            IIntegrate(448, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Times(e, x), m), Power(Plus(a, Times(b, Power(x, n))), p), Power(Plus(c, Times(d, Power(x, n))), q)), x), x), And(FreeQ(List(a, b, c, d, e, m, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), IGtQ(p, C0), IGtQ(q, C0))));
            IIntegrate(449, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Plus(c_, Times(d_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Simp(Times(c, Power(Times(e, x), Plus(m, C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Times(a, e, Plus(m, C1)), CN1)), x), And(FreeQ(List(a, b, c, d, e, m, n, p), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Times(a, d, Plus(m, C1)), Times(b, c, Plus(m, Times(n, Plus(p, C1)), C1))), C0), NeQ(m, CN1))));
            IIntegrate(450, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, $p("non2", true)))), p_DEFAULT), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, $p("non2", true)))), p_DEFAULT), Plus(c_, Times(d_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Simp(Times(c, Power(Times(e, x), Plus(m, C1)), Power(Plus($s("a1"), Times($s("b1"), Power(x, Times(C1D2, n)))), Plus(p, C1)), Power(Plus($s("a2"), Times($s("b2"), Power(x, Times(C1D2, n)))), Plus(p, C1)), Power(Times($s("a1"), $s("a2"), e, Plus(m, C1)), CN1)), x), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), c, d, e, m, n, p), x), EqQ($s("non2"), Times(C1D2, n)), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), EqQ(Subtract(Times($s("a1"), $s("a2"), d, Plus(m, C1)), Times($s("b1"), $s("b2"), c, Plus(m, Times(n, Plus(p, C1)), C1))), C0), NeQ(m, CN1))));
        }
    }
}
