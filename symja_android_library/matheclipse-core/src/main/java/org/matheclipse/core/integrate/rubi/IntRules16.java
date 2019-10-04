package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcCos;
import static org.matheclipse.core.expression.F.ArcSin;
import static org.matheclipse.core.expression.F.ArcTan;
import static org.matheclipse.core.expression.F.ArcTanh;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C1D4;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN1D4;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.EllipticE;
import static org.matheclipse.core.expression.F.EllipticF;
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
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntBinomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NegQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplerSqrtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules16 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(401, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), QQ(-3L, 4L)), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Times(CN1, b, Sqr(x), Power(a, CN1))), Power(Times(C2, x), CN1)), Subst(Int(Power(Times(Sqrt(Times(CN1, b, x, Power(a, CN1))), Power(Plus(a, Times(b, x)), QQ(3L, 4L)), Plus(c, Times(d, x))), CN1), x), x, Sqr(x)), x), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0))));
            IIntegrate(402, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), p_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Times(b, Power(d, CN1)), Int(Power(Plus(a, Times(b, Sqr(x))), Subtract(p, C1)), x), x), Dist(Times(Subtract(Times(b, c), Times(a, d)), Power(d, CN1)), Int(Times(Power(Plus(a, Times(b, Sqr(x))), Subtract(p, C1)), Power(Plus(c, Times(d, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), GtQ(p, C0), Or(EqQ(p, C1D2), EqQ(Denominator(p), C4)))));
            IIntegrate(403, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), p_), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Times(b, Power(Subtract(Times(b, c), Times(a, d)), CN1)), Int(Power(Plus(a, Times(b, Sqr(x))), p), x), x), Dist(Times(d, Power(Subtract(Times(b, c), Times(a, d)), CN1)), Int(Times(Power(Plus(a, Times(b, Sqr(x))), Plus(p, C1)), Power(Plus(c, Times(d, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), LtQ(p, CN1), EqQ(Denominator(p), C4), Or(EqQ(p, QQ(-5L, 4L)), EqQ(p, QQ(-7L, 4L))))));
            IIntegrate(404, Int(Times(Sqrt(Plus(a_, Times(b_DEFAULT, Power(x_, C4)))), Power(Plus(c_, Times(d_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(Dist(Times(a, Power(c, CN1)), Subst(Int(Power(Subtract(C1, Times(C4, a, b, Power(x, C4))), CN1), x), x, Times(x, Power(Plus(a, Times(b, Power(x, C4))), CN1D2))), x), And(FreeQ(List(a, b, c, d), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), PosQ(Times(a, b)))));
            IIntegrate(405, Int(Times(Sqrt(Plus(a_, Times(b_DEFAULT, Power(x_, C4)))), Power(Plus(c_, Times(d_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(CN1, a, b), C4))), Plus(Simp(Times(a, ArcTan(Times(q, x, Plus(a, Times(Sqr(q), Sqr(x))), Power(Times(a, Sqrt(Plus(a, Times(b, Power(x, C4))))), CN1))), Power(Times(C2, c, q), CN1)), x), Simp(Times(a, ArcTanh(Times(q, x, Subtract(a, Times(Sqr(q), Sqr(x))), Power(Times(a, Sqrt(Plus(a, Times(b, Power(x, C4))))), CN1))), Power(Times(C2, c, q), CN1)), x))), And(FreeQ(List(a, b, c, d), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), NegQ(Times(a, b)))));
            IIntegrate(406, Int(Times(Sqrt(Plus(a_, Times(b_DEFAULT, Power(x_, C4)))), Power(Plus(c_, Times(d_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Times(b, Power(d, CN1)), Int(Power(Plus(a, Times(b, Power(x, C4))), CN1D2), x), x), Dist(Times(Subtract(Times(b, c), Times(a, d)), Power(d, CN1)), Int(Power(Times(Sqrt(Plus(a, Times(b, Power(x, C4)))), Plus(c, Times(d, Power(x, C4)))), CN1), x), x)), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0))));
            IIntegrate(407, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, C4))), C1D4), Power(Plus(c_, Times(d_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Plus(a, Times(b, Power(x, C4)))), Sqrt(Times(a, Power(Plus(a, Times(b, Power(x, C4))), CN1)))), Subst(Int(Power(Times(Sqrt(Subtract(C1, Times(b, Power(x, C4)))), Subtract(c, Times(Subtract(Times(b, c), Times(a, d)), Power(x, C4)))), CN1), x), x, Times(x, Power(Plus(a, Times(b, Power(x, C4))), CN1D4))), x), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0))));
            IIntegrate(408, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, C4))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Times(b, Power(d, CN1)), Int(Power(Plus(a, Times(b, Power(x, C4))), Subtract(p, C1)), x), x), Dist(Times(Subtract(Times(b, c), Times(a, d)), Power(d, CN1)), Int(Times(Power(Plus(a, Times(b, Power(x, C4))), Subtract(p, C1)), Power(Plus(c, Times(d, Power(x, C4))), CN1)), x), x)), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), Or(EqQ(p, QQ(3L, 4L)), EqQ(p, QQ(5L, 4L))))));
            IIntegrate(409, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, C4))), CN1D2), Power(Plus(c_, Times(d_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(Plus(Dist(Power(Times(C2, c), CN1), Int(Power(Times(Sqrt(Plus(a, Times(b, Power(x, C4)))), Subtract(C1, Times(Rt(Times(CN1, d, Power(c, CN1)), C2), Sqr(x)))), CN1), x), x), Dist(Power(Times(C2, c), CN1), Int(Power(Times(Sqrt(Plus(a, Times(b, Power(x, C4)))), Plus(C1, Times(Rt(Times(CN1, d, Power(c, CN1)), C2), Sqr(x)))), CN1), x), x)), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0))));
            IIntegrate(410, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, C4))), QQ(-3L, 4L)), Power(Plus(c_, Times(d_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Times(b, Power(Subtract(Times(b, c), Times(a, d)), CN1)), Int(Power(Plus(a, Times(b, Power(x, C4))), QQ(-3L, 4L)), x), x), Dist(Times(d, Power(Subtract(Times(b, c), Times(a, d)), CN1)), Int(Times(Power(Plus(a, Times(b, Power(x, C4))), C1D4), Power(Plus(c, Times(d, Power(x, C4))), CN1)), x), x)), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0))));
            IIntegrate(411, Int(Times(Sqrt(Plus(a_, Times(b_DEFAULT, Sqr(x_)))), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), QQ(-3L, 2L))), x_Symbol),
                    Condition(Simp(Times(Sqrt(Plus(a, Times(b, Sqr(x)))), EllipticE(ArcTan(Times(Rt(Times(d, Power(c, CN1)), C2), x)), Subtract(C1, Times(b, c, Power(Times(a, d), CN1)))), Power(Times(c, Rt(Times(d, Power(c, CN1)), C2), Sqrt(Plus(c, Times(d, Sqr(x)))), Sqrt(Times(c, Plus(a, Times(b, Sqr(x))), Power(Times(a, Plus(c, Times(d, Sqr(x)))), CN1)))), CN1)), x), And(FreeQ(List(a, b, c, d), x), PosQ(Times(b, Power(a, CN1))), PosQ(Times(d, Power(c, CN1))))));
            IIntegrate(412, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(x, Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), q), Power(Times(a, n, Plus(p, C1)), CN1)), x)), Dist(Power(Times(a, n, Plus(p, C1)), CN1), Int(Times(Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), Subtract(q, C1)), Simp(Plus(Times(c, Plus(Times(n, Plus(p, C1)), C1)), Times(d, Plus(Times(n, Plus(p, q, C1)), C1), Power(x, n))), x)), x), x)), And(FreeQ(List(a, b, c, d, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), LtQ(p, CN1), LtQ(C0, q, C1), IntBinomialQ(a, b, c, d, n, p, q, x))));
            IIntegrate(413, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Subtract(Times(a, d), Times(c, b)), x, Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), Subtract(q, C1)), Power(Times(a, b, n, Plus(p, C1)), CN1)), x), Dist(Power(Times(a, b, n, Plus(p, C1)), CN1), Int(Times(Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), Subtract(q, C2)), Simp(Plus(Times(c, Subtract(Times(a, d), Times(c, b, Plus(Times(n, Plus(p, C1)), C1)))), Times(d, Subtract(Times(a, d, Plus(Times(n, Subtract(q, C1)), C1)), Times(b, c, Plus(Times(n, Plus(p, q)), C1))), Power(x, n))), x)), x), x)), And(FreeQ(List(a, b, c, d, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), LtQ(p, CN1), GtQ(q, C1), IntBinomialQ(a, b, c, d, n, p, q, x))));
            IIntegrate(414, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, x, Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), Plus(q, C1)), Power(Times(a, n, Plus(p, C1), Subtract(Times(b, c), Times(a, d))), CN1)), x)), Dist(Power(Times(a, n, Plus(p, C1), Subtract(Times(b, c), Times(a, d))), CN1), Int(Times(Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), q), Simp(Plus(Times(b, c), Times(n, Plus(p, C1), Subtract(Times(b, c), Times(a, d))), Times(d, b, Plus(Times(n, Plus(p, q, C2)), C1), Power(x, n))), x)), x), x)), And(FreeQ(List(a, b, c, d, n, q), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), LtQ(p, CN1), Not(And(Not(IntegerQ(p)), IntegerQ(q), LtQ(q, CN1))), IntBinomialQ(a, b, c, d, n, p, q, x))));
            IIntegrate(415, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(a, Times(b, Power(x, n))), p), Power(Plus(c, Times(d, Power(x, n))), q)), x), x), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), IGtQ(n, C0), IntegersQ(p, q), GtQ(Plus(p, q), C0))));
            IIntegrate(416, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(Plus(Simp(Times(d, x, Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), Subtract(q, C1)), Power(Times(b, Plus(Times(n, Plus(p, q)), C1)), CN1)), x), Dist(Power(Times(b, Plus(Times(n, Plus(p, q)), C1)), CN1), Int(Times(Power(Plus(a, Times(b, Power(x, n))), p), Power(Plus(c, Times(d, Power(x, n))), Subtract(q, C2)), Simp(Plus(Times(c, Subtract(Times(b, c, Plus(Times(n, Plus(p, q)), C1)), Times(a, d))), Times(d, Subtract(Times(b, c, Plus(Times(n, Subtract(Plus(p, Times(C2, q)), C1)), C1)), Times(a, d, Plus(Times(n, Subtract(q, C1)), C1))), Power(x, n))), x)), x), x)), And(FreeQ(List(a, b, c, d, n, p), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), GtQ(q, C1), NeQ(Plus(Times(n, Plus(p, q)), C1), C0), Not(IGtQ(p, C1)), IntBinomialQ(a, b, c, d, n, p, q, x))));
            IIntegrate(417, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_)), x_Symbol),
                    Condition(Plus(Simp(Times(x, Power(Plus(a, Times(b, Power(x, n))), p), Power(Plus(c, Times(d, Power(x, n))), q), Power(Plus(Times(n, Plus(p, q)), C1), CN1)), x), Dist(Times(n, Power(Plus(Times(n, Plus(p, q)), C1), CN1)), Int(Times(Power(Plus(a, Times(b, Power(x, n))), Subtract(p, C1)), Power(Plus(c, Times(d, Power(x, n))), Subtract(q, C1)), Simp(Plus(Times(a, c, Plus(p, q)), Times(Plus(Times(q, Subtract(Times(b, c), Times(a, d))), Times(a, d, Plus(p, q))), Power(x, n))), x)), x), x)), And(FreeQ(List(a, b, c, d, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), GtQ(q, C0), GtQ(p, C0), IntBinomialQ(a, b, c, d, n, p, q, x))));
            IIntegrate(418, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1D2), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Simp(Times(Sqrt(Plus(a, Times(b, Sqr(x)))), EllipticF(ArcTan(Times(Rt(Times(d, Power(c, CN1)), C2), x)), Subtract(C1, Times(b, c, Power(Times(a, d), CN1)))), Power(Times(a, Rt(Times(d, Power(c, CN1)), C2), Sqrt(Plus(c, Times(d, Sqr(x)))), Sqrt(Times(c, Plus(a, Times(b, Sqr(x))), Power(Times(a, Plus(c, Times(d, Sqr(x)))), CN1)))), CN1)), x), And(FreeQ(List(a, b, c, d), x), PosQ(Times(d, Power(c, CN1))), PosQ(Times(b, Power(a, CN1))), Not(SimplerSqrtQ(Times(b, Power(a, CN1)), Times(d, Power(c, CN1)))))));
            IIntegrate(419, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1D2), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Simp(Times(C1, EllipticF(ArcSin(Times(Rt(Times(CN1, d, Power(c, CN1)), C2), x)), Times(b, c, Power(Times(a, d), CN1))), Power(Times(Sqrt(a), Sqrt(c), Rt(Times(CN1, d, Power(c, CN1)), C2)), CN1)), x), And(FreeQ(List(a, b, c, d), x), NegQ(Times(d, Power(c, CN1))), GtQ(c, C0), GtQ(a, C0), Not(And(NegQ(Times(b, Power(a, CN1))), SimplerSqrtQ(Times(CN1, b, Power(a, CN1)), Times(CN1, d, Power(c, CN1))))))));
            IIntegrate(420, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1D2), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Negate(Simp(Times(EllipticF(ArcCos(Times(Rt(Times(CN1, d, Power(c, CN1)), C2), x)), Times(b, c, Power(Subtract(Times(b, c), Times(a, d)), CN1))), Power(Times(Sqrt(c), Rt(Times(CN1, d, Power(c, CN1)), C2), Sqrt(Subtract(a, Times(b, c, Power(d, CN1))))), CN1)), x)), And(FreeQ(List(a, b, c, d), x), NegQ(Times(d, Power(c, CN1))), GtQ(c, C0), GtQ(Subtract(a, Times(b, c, Power(d, CN1))), C0))));
            IIntegrate(421, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1D2), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Plus(C1, Times(d, Sqr(x), Power(c, CN1)))), Power(Plus(c, Times(d, Sqr(x))), CN1D2)), Int(Power(Times(Sqrt(Plus(a, Times(b, Sqr(x)))), Sqrt(Plus(C1, Times(d, Sqr(x), Power(c, CN1))))), CN1), x), x), And(FreeQ(List(a, b, c, d), x), Not(GtQ(c, C0)))));
            IIntegrate(422, Int(Times(Sqrt(Plus(a_, Times(b_DEFAULT, Sqr(x_)))), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Plus(Dist(a, Int(Power(Times(Sqrt(Plus(a, Times(b, Sqr(x)))), Sqrt(Plus(c, Times(d, Sqr(x))))), CN1), x), x), Dist(b, Int(Times(Sqr(x), Power(Times(Sqrt(Plus(a, Times(b, Sqr(x)))), Sqrt(Plus(c, Times(d, Sqr(x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d), x), PosQ(Times(d, Power(c, CN1))), PosQ(Times(b, Power(a, CN1))))));
            IIntegrate(423, Int(Times(Sqrt(Plus(a_, Times(b_DEFAULT, Sqr(x_)))), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Subtract(Dist(Times(b, Power(d, CN1)), Int(Times(Sqrt(Plus(c, Times(d, Sqr(x)))), Power(Plus(a, Times(b, Sqr(x))), CN1D2)), x), x), Dist(Times(Subtract(Times(b, c), Times(a, d)), Power(d, CN1)), Int(Power(Times(Sqrt(Plus(a, Times(b, Sqr(x)))), Sqrt(Plus(c, Times(d, Sqr(x))))), CN1), x), x)), And(FreeQ(List(a, b, c, d), x), PosQ(Times(d, Power(c, CN1))), NegQ(Times(b, Power(a, CN1))))));
            IIntegrate(424, Int(Times(Sqrt(Plus(a_, Times(b_DEFAULT, Sqr(x_)))), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Simp(Times(Sqrt(a), EllipticE(ArcSin(Times(Rt(Times(CN1, d, Power(c, CN1)), C2), x)), Times(b, c, Power(Times(a, d), CN1))), Power(Times(Sqrt(c), Rt(Times(CN1, d, Power(c, CN1)), C2)), CN1)), x), And(FreeQ(List(a, b, c, d), x), NegQ(Times(d, Power(c, CN1))), GtQ(c, C0), GtQ(a, C0))));
            IIntegrate(425, Int(Times(Sqrt(Plus(a_, Times(b_DEFAULT, Sqr(x_)))), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Negate(Simp(Times(Sqrt(Subtract(a, Times(b, c, Power(d, CN1)))), EllipticE(ArcCos(Times(Rt(Times(CN1, d, Power(c, CN1)), C2), x)), Times(b, c, Power(Subtract(Times(b, c), Times(a, d)), CN1))), Power(Times(Sqrt(c), Rt(Times(CN1, d, Power(c, CN1)), C2)), CN1)), x)), And(FreeQ(List(a, b, c, d), x), NegQ(Times(d, Power(c, CN1))), GtQ(c, C0), GtQ(Subtract(a, Times(b, c, Power(d, CN1))), C0))));
        }
    }
}
