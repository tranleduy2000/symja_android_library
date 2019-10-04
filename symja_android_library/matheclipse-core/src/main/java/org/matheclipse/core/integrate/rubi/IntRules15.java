package org.matheclipse.core.integrate.rubi;


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
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.ZZ;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
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
public class IntRules15 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(376, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(g, Denominator(n))), Dist(g, Subst(Int(Times(Power(x, Subtract(g, C1)), Power(Plus(a, Times(b, Power(x, Times(g, n)))), p), Power(Plus(c, Times(d, Power(x, Times(g, n)))), q)), x), x, Power(x, Power(g, CN1))), x)), And(FreeQ(List(a, b, c, d, p, q), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), FractionQ(n))));
            IIntegrate(377, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), CN1)), x_Symbol),
                    Condition(Subst(Int(Power(Subtract(c, Times(Subtract(Times(b, c), Times(a, d)), Power(x, n))), CN1), x), x, Times(x, Power(Power(Plus(a, Times(b, Power(x, n))), Power(n, CN1)), CN1))), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(Times(n, p), C1), C0), IntegerQ(n))));
            IIntegrate(378, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Subtract(Negate(Simp(Times(x, Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), q), Power(Times(a, n, Plus(p, C1)), CN1)), x)), Dist(Times(c, q, Power(Times(a, Plus(p, C1)), CN1)), Int(Times(Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), Subtract(q, C1))), x), x)), And(FreeQ(List(a, b, c, d, n, p), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(Times(n, Plus(p, q, C1)), C1), C0), GtQ(q, C0), NeQ(p, CN1))));
            IIntegrate(379, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(Simp(Times(Power(a, p), x, Hypergeometric2F1(Power(n, CN1), Negate(p), Plus(C1, Power(n, CN1)), Times(CN1, Subtract(Times(b, c), Times(a, d)), Power(x, n), Power(Times(a, Plus(c, Times(d, Power(x, n)))), CN1))), Power(Times(Power(c, Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), Power(n, CN1))), CN1)), x), And(FreeQ(List(a, b, c, d, n, q), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(Times(n, Plus(p, q, C1)), C1), C0), ILtQ(p, C0))));
            IIntegrate(380, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(Simp(Times(x, Power(Plus(a, Times(b, Power(x, n))), p), Hypergeometric2F1(Power(n, CN1), Negate(p), Plus(C1, Power(n, CN1)), Times(CN1, Subtract(Times(b, c), Times(a, d)), Power(x, n), Power(Times(a, Plus(c, Times(d, Power(x, n)))), CN1))), Power(Times(c, Power(Times(c, Plus(a, Times(b, Power(x, n))), Power(Times(a, Plus(c, Times(d, Power(x, n)))), CN1)), p), Power(Plus(c, Times(d, Power(x, n))), Plus(Power(n, CN1), p))), CN1)), x), And(FreeQ(List(a, b, c, d, n, p, q), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(Times(n, Plus(p, q, C1)), C1), C0))));
            IIntegrate(381, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(Simp(Times(x, Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), Plus(q, C1)), Power(Times(a, c), CN1)), x), And(FreeQ(List(a, b, c, d, n, p, q), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(Times(n, Plus(p, q, C2)), C1), C0), EqQ(Plus(Times(a, d, Plus(p, C1)), Times(b, c, Plus(q, C1))), C0))));
            IIntegrate(382, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, x, Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), Plus(q, C1)), Power(Times(a, n, Plus(p, C1), Subtract(Times(b, c), Times(a, d))), CN1)), x)), Dist(Times(Plus(Times(b, c), Times(n, Plus(p, C1), Subtract(Times(b, c), Times(a, d)))), Power(Times(a, n, Plus(p, C1), Subtract(Times(b, c), Times(a, d))), CN1)), Int(Times(Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), q)), x), x)), And(FreeQ(List(a, b, c, d, n, q), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(Times(n, Plus(p, q, C2)), C1), C0), Or(LtQ(p, CN1), Not(LtQ(q, CN1))), NeQ(p, CN1))));
            IIntegrate(383, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Plus(c_, Times(d_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Simp(Times(c, x, Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(a, CN1)), x), And(FreeQ(List(a, b, c, d, n, p), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Times(a, d), Times(b, c, Plus(Times(n, Plus(p, C1)), C1))), C0))));
            IIntegrate(384, Int(Times(Power(Plus($p("a1"), Times($p("b1", true), Power(x_, $p("non2", true)))), p_DEFAULT), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, $p("non2", true)))), p_DEFAULT), Plus(c_, Times(d_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Simp(Times(c, x, Power(Plus($s("a1"), Times($s("b1"), Power(x, Times(C1D2, n)))), Plus(p, C1)), Power(Plus($s("a2"), Times($s("b2"), Power(x, Times(C1D2, n)))), Plus(p, C1)), Power(Times($s("a1"), $s("a2")), CN1)), x), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), c, d, n, p), x), EqQ($s("non2"), Times(C1D2, n)), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), EqQ(Subtract(Times($s("a1"), $s("a2"), d), Times($s("b1"), $s("b2"), c, Plus(Times(n, Plus(p, C1)), C1))), C0))));
            IIntegrate(385, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Plus(c_, Times(d_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Subtract(Negate(Simp(Times(Subtract(Times(b, c), Times(a, d)), x, Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Times(a, b, n, Plus(p, C1)), CN1)), x)), Dist(Times(Subtract(Times(a, d), Times(b, c, Plus(Times(n, Plus(p, C1)), C1))), Power(Times(a, b, n, Plus(p, C1)), CN1)), Int(Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), x), x)), And(FreeQ(List(a, b, c, d, n, p), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), Or(LtQ(p, CN1), ILtQ(Plus(Power(n, CN1), p), C0)))));
            IIntegrate(386, Int(Times(Power(Plus($p("a1"), Times($p("b1", true), Power(x_, $p("non2", true)))), p_DEFAULT), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, $p("non2", true)))), p_DEFAULT), Plus(c_, Times(d_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Subtract(Negate(Simp(Times(Subtract(Times($s("b1"), $s("b2"), c), Times($s("a1"), $s("a2"), d)), x, Power(Plus($s("a1"), Times($s("b1"), Power(x, Times(C1D2, n)))), Plus(p, C1)), Power(Plus($s("a2"), Times($s("b2"), Power(x, Times(C1D2, n)))), Plus(p, C1)), Power(Times($s("a1"), $s("a2"), $s("b1"), $s("b2"), n, Plus(p, C1)), CN1)), x)), Dist(Times(Subtract(Times($s("a1"), $s("a2"), d), Times($s("b1"), $s("b2"), c, Plus(Times(n, Plus(p, C1)), C1))), Power(Times($s("a1"), $s("a2"), $s("b1"), $s("b2"), n, Plus(p, C1)), CN1)), Int(Times(Power(Plus($s("a1"), Times($s("b1"), Power(x, Times(C1D2, n)))), Plus(p, C1)), Power(Plus($s("a2"), Times($s("b2"), Power(x, Times(C1D2, n)))), Plus(p, C1))), x), x)), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), c, d, n), x), EqQ($s("non2"), Times(C1D2, n)), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), Or(LtQ(p, CN1), ILtQ(Plus(Power(n, CN1), p), C0)))));
            IIntegrate(387, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), CN1), Plus(c_, Times(d_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Subtract(Simp(Times(c, x, Power(a, CN1)), x), Dist(Times(Subtract(Times(b, c), Times(a, d)), Power(a, CN1)), Int(Power(Plus(b, Times(a, Power(Power(x, n), CN1))), CN1), x), x)), And(FreeQ(List(a, b, c, d, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), LtQ(n, C0))));
            IIntegrate(388, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Plus(c_, Times(d_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Subtract(Simp(Times(d, x, Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Times(b, Plus(Times(n, Plus(p, C1)), C1)), CN1)), x), Dist(Times(Subtract(Times(a, d), Times(b, c, Plus(Times(n, Plus(p, C1)), C1))), Power(Times(b, Plus(Times(n, Plus(p, C1)), C1)), CN1)), Int(Power(Plus(a, Times(b, Power(x, n))), p), x), x)), And(FreeQ(List(a, b, c, d, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Plus(Times(n, Plus(p, C1)), C1), C0))));
            IIntegrate(389, Int(Times(Power(Plus($p("a1"), Times($p("b1", true), Power(x_, $p("non2", true)))), p_DEFAULT), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, $p("non2", true)))), p_DEFAULT), Plus(c_, Times(d_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Subtract(Simp(Times(d, x, Power(Plus($s("a1"), Times($s("b1"), Power(x, Times(C1D2, n)))), Plus(p, C1)), Power(Plus($s("a2"), Times($s("b2"), Power(x, Times(C1D2, n)))), Plus(p, C1)), Power(Times($s("b1"), $s("b2"), Plus(Times(n, Plus(p, C1)), C1)), CN1)), x), Dist(Times(Subtract(Times($s("a1"), $s("a2"), d), Times($s("b1"), $s("b2"), c, Plus(Times(n, Plus(p, C1)), C1))), Power(Times($s("b1"), $s("b2"), Plus(Times(n, Plus(p, C1)), C1)), CN1)), Int(Times(Power(Plus($s("a1"), Times($s("b1"), Power(x, Times(C1D2, n)))), p), Power(Plus($s("a2"), Times($s("b2"), Power(x, Times(C1D2, n)))), p)), x), x)), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), c, d, n, p), x), EqQ($s("non2"), Times(C1D2, n)), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), NeQ(Plus(Times(n, Plus(p, C1)), C1), C0))));
            IIntegrate(390, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(Int(PolynomialDivide(Power(Plus(a, Times(b, Power(x, n))), p), Power(Plus(c, Times(d, Power(x, n))), Negate(q)), x), x), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), IGtQ(n, C0), IGtQ(p, C0), ILtQ(q, C0), GeQ(p, Negate(q)))));
            IIntegrate(391, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), CN1), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Times(b, Power(Subtract(Times(b, c), Times(a, d)), CN1)), Int(Power(Plus(a, Times(b, Power(x, n))), CN1), x), x), Dist(Times(d, Power(Subtract(Times(b, c), Times(a, d)), CN1)), Int(Power(Plus(c, Times(d, Power(x, n))), CN1), x), x)), And(FreeQ(List(a, b, c, d, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0))));
            IIntegrate(392, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1D3), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(b, Power(a, CN1)), C2))), Plus(Simp(Times(q, ArcTanh(Times(CSqrt3, Power(Times(q, x), CN1))), Power(Times(C2, Power(C2, QQ(2L, 3L)), CSqrt3, Power(a, C1D3), d), CN1)), x), Negate(Simp(Times(q, ArcTan(Times(Power(a, C1D3), q, x, Power(Plus(Power(a, C1D3), Times(Power(C2, C1D3), Power(Plus(a, Times(b, Sqr(x))), C1D3))), CN1))), Power(Times(C2, Power(C2, QQ(2L, 3L)), Power(a, C1D3), d), CN1)), x)), Simp(Times(q, ArcTan(Times(q, x)), Power(Times(C6, Power(C2, QQ(2L, 3L)), Power(a, C1D3), d), CN1)), x), Simp(Times(q, ArcTanh(Times(CSqrt3, Subtract(Power(a, C1D3), Times(Power(C2, C1D3), Power(Plus(a, Times(b, Sqr(x))), C1D3))), Power(Times(Power(a, C1D3), q, x), CN1))), Power(Times(C2, Power(C2, QQ(2L, 3L)), CSqrt3, Power(a, C1D3), d), CN1)), x))), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(Times(b, c), Times(C3, a, d)), C0), PosQ(Times(b, Power(a, CN1))))));
            IIntegrate(393, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1D3), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(CN1, b, Power(a, CN1)), C2))), Plus(Simp(Times(q, ArcTan(Times(CSqrt3, Power(Times(q, x), CN1))), Power(Times(C2, Power(C2, QQ(2L, 3L)), CSqrt3, Power(a, C1D3), d), CN1)), x), Simp(Times(q, ArcTanh(Times(Power(a, C1D3), q, x, Power(Plus(Power(a, C1D3), Times(Power(C2, C1D3), Power(Plus(a, Times(b, Sqr(x))), C1D3))), CN1))), Power(Times(C2, Power(C2, QQ(2L, 3L)), Power(a, C1D3), d), CN1)), x), Negate(Simp(Times(q, ArcTanh(Times(q, x)), Power(Times(C6, Power(C2, QQ(2L, 3L)), Power(a, C1D3), d), CN1)), x)), Simp(Times(q, ArcTan(Times(CSqrt3, Subtract(Power(a, C1D3), Times(Power(C2, C1D3), Power(Plus(a, Times(b, Sqr(x))), C1D3))), Power(Times(Power(a, C1D3), q, x), CN1))), Power(Times(C2, Power(C2, QQ(2L, 3L)), CSqrt3, Power(a, C1D3), d), CN1)), x))), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(Times(b, c), Times(C3, a, d)), C0), NegQ(Times(b, Power(a, CN1))))));
            IIntegrate(394, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1D3), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(b, Power(a, CN1)), C2))), Plus(Simp(Times(q, ArcTan(Times(C1D3, q, x)), Power(Times(ZZ(12L), Rt(a, C3), d), CN1)), x), Simp(Times(q, ArcTan(Times(Sqr(Subtract(Rt(a, C3), Power(Plus(a, Times(b, Sqr(x))), C1D3))), Power(Times(C3, Sqr(Rt(a, C3)), q, x), CN1))), Power(Times(ZZ(12L), Rt(a, C3), d), CN1)), x), Negate(Simp(Times(q, ArcTanh(Times(CSqrt3, Subtract(Rt(a, C3), Power(Plus(a, Times(b, Sqr(x))), C1D3)), Power(Times(Rt(a, C3), q, x), CN1))), Power(Times(C4, CSqrt3, Rt(a, C3), d), CN1)), x)))), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Times(b, c), Times(C9, a, d)), C0), PosQ(Times(b, Power(a, CN1))))));
            IIntegrate(395, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1D3), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(CN1, b, Power(a, CN1)), C2))), Plus(Negate(Simp(Times(q, ArcTanh(Times(C1D3, q, x)), Power(Times(ZZ(12L), Rt(a, C3), d), CN1)), x)), Simp(Times(q, ArcTanh(Times(Sqr(Subtract(Rt(a, C3), Power(Plus(a, Times(b, Sqr(x))), C1D3))), Power(Times(C3, Sqr(Rt(a, C3)), q, x), CN1))), Power(Times(ZZ(12L), Rt(a, C3), d), CN1)), x), Negate(Simp(Times(q, ArcTan(Times(CSqrt3, Subtract(Rt(a, C3), Power(Plus(a, Times(b, Sqr(x))), C1D3)), Power(Times(Rt(a, C3), q, x), CN1))), Power(Times(C4, CSqrt3, Rt(a, C3), d), CN1)), x)))), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Times(b, c), Times(C9, a, d)), C0), NegQ(Times(b, Power(a, CN1))))));
            IIntegrate(396, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), QQ(2L, 3L)), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Times(b, Power(d, CN1)), Int(Power(Plus(a, Times(b, Sqr(x))), CN1D3), x), x), Dist(Times(Subtract(Times(b, c), Times(a, d)), Power(d, CN1)), Int(Power(Times(Power(Plus(a, Times(b, Sqr(x))), C1D3), Plus(c, Times(d, Sqr(x)))), CN1), x), x)), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(Times(b, c), Times(C3, a, d)), C0))));
            IIntegrate(397, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1D4), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(Sqr(b), Power(a, CN1)), C4))), Subtract(Negate(Simp(Times(b, ArcTan(Times(Plus(b, Times(Sqr(q), Sqrt(Plus(a, Times(b, Sqr(x)))))), Power(Times(Power(q, C3), x, Power(Plus(a, Times(b, Sqr(x))), C1D4)), CN1))), Power(Times(C2, a, d, q), CN1)), x)), Simp(Times(b, ArcTanh(Times(Subtract(b, Times(Sqr(q), Sqrt(Plus(a, Times(b, Sqr(x)))))), Power(Times(Power(q, C3), x, Power(Plus(a, Times(b, Sqr(x))), C1D4)), CN1))), Power(Times(C2, a, d, q), CN1)), x))), And(FreeQ(List(a, b, c, d), x), EqQ(Subtract(Times(b, c), Times(C2, a, d)), C0), PosQ(Times(Sqr(b), Power(a, CN1))))));
            IIntegrate(398, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1D4), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(CN1, Sqr(b), Power(a, CN1)), C4))), Plus(Simp(Times(b, ArcTan(Times(q, x, Power(Times(CSqrt2, Power(Plus(a, Times(b, Sqr(x))), C1D4)), CN1))), Power(Times(C2, CSqrt2, a, d, q), CN1)), x), Simp(Times(b, ArcTanh(Times(q, x, Power(Times(CSqrt2, Power(Plus(a, Times(b, Sqr(x))), C1D4)), CN1))), Power(Times(C2, CSqrt2, a, d, q), CN1)), x))), And(FreeQ(List(a, b, c, d), x), EqQ(Subtract(Times(b, c), Times(C2, a, d)), C0), NegQ(Times(Sqr(b), Power(a, CN1))))));
            IIntegrate(399, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1D4), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Dist(Times(C2, Sqrt(Times(CN1, b, Sqr(x), Power(a, CN1))), Power(x, CN1)), Subst(Int(Times(Sqr(x), Power(Times(Sqrt(Subtract(C1, Times(Power(x, C4), Power(a, CN1)))), Plus(Times(b, c), Times(CN1, a, d), Times(d, Power(x, C4)))), CN1)), x), x, Power(Plus(a, Times(b, Sqr(x))), C1D4)), x), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0))));
            IIntegrate(400, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), QQ(-3L, 4L)), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Power(c, CN1), Int(Power(Plus(a, Times(b, Sqr(x))), QQ(-3L, 4L)), x), x), Dist(Times(d, Power(c, CN1)), Int(Times(Sqr(x), Power(Times(Power(Plus(a, Times(b, Sqr(x))), QQ(3L, 4L)), Plus(c, Times(d, Sqr(x)))), CN1)), x), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Subtract(Times(b, c), Times(C2, a, d)), C0))));
        }
    }
}
