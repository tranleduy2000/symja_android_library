package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcSin;
import static org.matheclipse.core.expression.F.ArcTan;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D4;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.EllipticPi;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.QQ;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.r;
import static org.matheclipse.core.expression.F.r_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NegQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplerSqrtQ;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules21 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(526, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT), Plus(e_, Times(f_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Subtract(Times(b, e), Times(a, f)), x, Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), q), Power(Times(a, b, n, Plus(p, C1)), CN1)), x)), Dist(Power(Times(a, b, n, Plus(p, C1)), CN1), Int(Times(Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), Subtract(q, C1)), Simp(Plus(Times(c, Subtract(Plus(Times(b, e, n, Plus(p, C1)), Times(b, e)), Times(a, f))), Times(d, Plus(Times(b, e, n, Plus(p, C1)), Times(Subtract(Times(b, e), Times(a, f)), Plus(Times(n, q), C1))), Power(x, n))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, n), x), LtQ(p, CN1), GtQ(q, C0))));
            IIntegrate(527, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT), Plus(e_, Times(f_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Subtract(Times(b, e), Times(a, f)), x, Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), Plus(q, C1)), Power(Times(a, n, Subtract(Times(b, c), Times(a, d)), Plus(p, C1)), CN1)), x)), Dist(Power(Times(a, n, Subtract(Times(b, c), Times(a, d)), Plus(p, C1)), CN1), Int(Times(Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), q), Simp(Plus(Times(c, Subtract(Times(b, e), Times(a, f))), Times(e, n, Subtract(Times(b, c), Times(a, d)), Plus(p, C1)), Times(d, Subtract(Times(b, e), Times(a, f)), Plus(Times(n, Plus(p, q, C2)), C1), Power(x, n))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, n, q), x), LtQ(p, CN1))));
            IIntegrate(528, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT), Plus(e_, Times(f_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Plus(Simp(Times(f, x, Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), q), Power(Times(b, Plus(Times(n, Plus(p, q, C1)), C1)), CN1)), x), Dist(Power(Times(b, Plus(Times(n, Plus(p, q, C1)), C1)), CN1), Int(Times(Power(Plus(a, Times(b, Power(x, n))), p), Power(Plus(c, Times(d, Power(x, n))), Subtract(q, C1)), Simp(Plus(Times(c, Plus(Times(b, e), Times(CN1, a, f), Times(b, e, n, Plus(p, q, C1)))), Times(Plus(Times(d, Subtract(Times(b, e), Times(a, f))), Times(f, n, q, Subtract(Times(b, c), Times(a, d))), Times(b, d, e, n, Plus(p, q, C1))), Power(x, n))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, n, p), x), GtQ(q, C0), NeQ(Plus(Times(n, Plus(p, q, C1)), C1), C0))));
            IIntegrate(529, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, C4))), QQ(-3L, 4L)), Power(Plus(c_, Times(d_DEFAULT, Power(x_, C4))), CN1), Plus(e_, Times(f_DEFAULT, Power(x_, C4)))), x_Symbol),
                    Condition(Subtract(Dist(Times(Subtract(Times(b, e), Times(a, f)), Power(Subtract(Times(b, c), Times(a, d)), CN1)), Int(Power(Plus(a, Times(b, Power(x, C4))), QQ(-3L, 4L)), x), x), Dist(Times(Subtract(Times(d, e), Times(c, f)), Power(Subtract(Times(b, c), Times(a, d)), CN1)), Int(Times(Power(Plus(a, Times(b, Power(x, C4))), C1D4), Power(Plus(c, Times(d, Power(x, C4))), CN1)), x), x)), FreeQ(List(a, b, c, d, e, f), x)));
            IIntegrate(530, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), CN1), Plus(e_, Times(f_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Plus(Dist(Times(f, Power(d, CN1)), Int(Power(Plus(a, Times(b, Power(x, n))), p), x), x), Dist(Times(Subtract(Times(d, e), Times(c, f)), Power(d, CN1)), Int(Times(Power(Plus(a, Times(b, Power(x, n))), p), Power(Plus(c, Times(d, Power(x, n))), CN1)), x), x)), FreeQ(List(a, b, c, d, e, f, p, n), x)));
            IIntegrate(531, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT), Plus(e_, Times(f_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Plus(Dist(e, Int(Times(Power(Plus(a, Times(b, Power(x, n))), p), Power(Plus(c, Times(d, Power(x, n))), q)), x), x), Dist(f, Int(Times(Power(x, n), Power(Plus(a, Times(b, Power(x, n))), p), Power(Plus(c, Times(d, Power(x, n))), q)), x), x)), FreeQ(List(a, b, c, d, e, f, n, p, q), x)));
            IIntegrate(532, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1), Power(Plus(e_, Times(f_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Subtract(Dist(Times(b, Power(Subtract(Times(b, c), Times(a, d)), CN1)), Int(Power(Times(Plus(a, Times(b, Sqr(x))), Sqrt(Plus(e, Times(f, Sqr(x))))), CN1), x), x), Dist(Times(d, Power(Subtract(Times(b, c), Times(a, d)), CN1)), Int(Power(Times(Plus(c, Times(d, Sqr(x))), Sqrt(Plus(e, Times(f, Sqr(x))))), CN1), x), x)), FreeQ(List(a, b, c, d, e, f), x)));
            IIntegrate(533, Int(Times(Power(x_, CN2), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1), Power(Plus(e_, Times(f_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Subtract(Dist(Power(c, CN1), Int(Power(Times(Sqr(x), Sqrt(Plus(e, Times(f, Sqr(x))))), CN1), x), x), Dist(Times(d, Power(c, CN1)), Int(Power(Times(Plus(c, Times(d, Sqr(x))), Sqrt(Plus(e, Times(f, Sqr(x))))), CN1), x), x)), And(FreeQ(List(c, d, e, f), x), NeQ(Subtract(Times(d, e), Times(c, f)), C0))));
            IIntegrate(534, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1), Sqrt(Plus(c_, Times(d_DEFAULT, Sqr(x_)))), Sqrt(Plus(e_, Times(f_DEFAULT, Sqr(x_))))), x_Symbol),
                    Condition(Plus(Dist(Times(d, Power(b, CN1)), Int(Times(Sqrt(Plus(e, Times(f, Sqr(x)))), Power(Plus(c, Times(d, Sqr(x))), CN1D2)), x), x), Dist(Times(Subtract(Times(b, c), Times(a, d)), Power(b, CN1)), Int(Times(Sqrt(Plus(e, Times(f, Sqr(x)))), Power(Times(Plus(a, Times(b, Sqr(x))), Sqrt(Plus(c, Times(d, Sqr(x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), GtQ(Times(d, Power(c, CN1)), C0), GtQ(Times(f, Power(e, CN1)), C0), Not(SimplerSqrtQ(Times(d, Power(c, CN1)), Times(f, Power(e, CN1)))))));
            IIntegrate(535, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1), Sqrt(Plus(c_, Times(d_DEFAULT, Sqr(x_)))), Sqrt(Plus(e_, Times(f_DEFAULT, Sqr(x_))))), x_Symbol),
                    Condition(Plus(Dist(Times(d, Power(b, CN1)), Int(Times(Sqrt(Plus(e, Times(f, Sqr(x)))), Power(Plus(c, Times(d, Sqr(x))), CN1D2)), x), x), Dist(Times(Subtract(Times(b, c), Times(a, d)), Power(b, CN1)), Int(Times(Sqrt(Plus(e, Times(f, Sqr(x)))), Power(Times(Plus(a, Times(b, Sqr(x))), Sqrt(Plus(c, Times(d, Sqr(x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), Not(SimplerSqrtQ(Times(CN1, f, Power(e, CN1)), Times(CN1, d, Power(c, CN1)))))));
            IIntegrate(536, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1D2), Power(Plus(e_, Times(f_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Plus(Negate(Dist(Times(f, Power(Subtract(Times(b, e), Times(a, f)), CN1)), Int(Power(Times(Sqrt(Plus(c, Times(d, Sqr(x)))), Sqrt(Plus(e, Times(f, Sqr(x))))), CN1), x), x)), Dist(Times(b, Power(Subtract(Times(b, e), Times(a, f)), CN1)), Int(Times(Sqrt(Plus(e, Times(f, Sqr(x)))), Power(Times(Plus(a, Times(b, Sqr(x))), Sqrt(Plus(c, Times(d, Sqr(x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), GtQ(Times(d, Power(c, CN1)), C0), GtQ(Times(f, Power(e, CN1)), C0), Not(SimplerSqrtQ(Times(d, Power(c, CN1)), Times(f, Power(e, CN1)))))));
            IIntegrate(537, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1D2), Power(Plus(e_, Times(f_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Simp(Times(C1, EllipticPi(Times(b, c, Power(Times(a, d), CN1)), ArcSin(Times(Rt(Times(CN1, d, Power(c, CN1)), C2), x)), Times(c, f, Power(Times(d, e), CN1))), Power(Times(a, Sqrt(c), Sqrt(e), Rt(Times(CN1, d, Power(c, CN1)), C2)), CN1)), x), And(FreeQ(List(a, b, c, d, e, f), x), Not(GtQ(Times(d, Power(c, CN1)), C0)), GtQ(c, C0), GtQ(e, C0), Not(And(Not(GtQ(Times(f, Power(e, CN1)), C0)), SimplerSqrtQ(Times(CN1, f, Power(e, CN1)), Times(CN1, d, Power(c, CN1))))))));
            IIntegrate(538, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1D2), Power(Plus(e_, Times(f_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Plus(C1, Times(d, Sqr(x), Power(c, CN1)))), Power(Plus(c, Times(d, Sqr(x))), CN1D2)), Int(Power(Times(Plus(a, Times(b, Sqr(x))), Sqrt(Plus(C1, Times(d, Sqr(x), Power(c, CN1)))), Sqrt(Plus(e, Times(f, Sqr(x))))), CN1), x), x), And(FreeQ(List(a, b, c, d, e, f), x), Not(GtQ(c, C0)))));
            IIntegrate(539, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1), Sqrt(Plus(c_, Times(d_DEFAULT, Sqr(x_)))), Power(Plus(e_, Times(f_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Simp(Times(c, Sqrt(Plus(e, Times(f, Sqr(x)))), EllipticPi(Subtract(C1, Times(b, c, Power(Times(a, d), CN1))), ArcTan(Times(Rt(Times(d, Power(c, CN1)), C2), x)), Subtract(C1, Times(c, f, Power(Times(d, e), CN1)))), Power(Times(a, e, Rt(Times(d, Power(c, CN1)), C2), Sqrt(Plus(c, Times(d, Sqr(x)))), Sqrt(Times(c, Plus(e, Times(f, Sqr(x))), Power(Times(e, Plus(c, Times(d, Sqr(x)))), CN1)))), CN1)), x), And(FreeQ(List(a, b, c, d, e, f), x), PosQ(Times(d, Power(c, CN1))))));
            IIntegrate(540, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1), Sqrt(Plus(c_, Times(d_DEFAULT, Sqr(x_)))), Power(Plus(e_, Times(f_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Plus(Dist(Times(d, Power(b, CN1)), Int(Power(Times(Sqrt(Plus(c, Times(d, Sqr(x)))), Sqrt(Plus(e, Times(f, Sqr(x))))), CN1), x), x), Dist(Times(Subtract(Times(b, c), Times(a, d)), Power(b, CN1)), Int(Power(Times(Plus(a, Times(b, Sqr(x))), Sqrt(Plus(c, Times(d, Sqr(x)))), Sqrt(Plus(e, Times(f, Sqr(x))))), CN1), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NegQ(Times(d, Power(c, CN1))))));
            IIntegrate(541, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), QQ(-3L, 2L)), Sqrt(Plus(e_, Times(f_DEFAULT, Sqr(x_))))), x_Symbol),
                    Condition(Subtract(Dist(Times(b, Power(Subtract(Times(b, c), Times(a, d)), CN1)), Int(Times(Sqrt(Plus(e, Times(f, Sqr(x)))), Power(Times(Plus(a, Times(b, Sqr(x))), Sqrt(Plus(c, Times(d, Sqr(x))))), CN1)), x), x), Dist(Times(d, Power(Subtract(Times(b, c), Times(a, d)), CN1)), Int(Times(Sqrt(Plus(e, Times(f, Sqr(x)))), Power(Plus(c, Times(d, Sqr(x))), QQ(-3L, 2L))), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), PosQ(Times(d, Power(c, CN1))), PosQ(Times(f, Power(e, CN1))))));
            IIntegrate(542, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), QQ(-3L, 2L)), Power(Plus(e_, Times(f_DEFAULT, Sqr(x_))), QQ(3L, 2L))), x_Symbol),
                    Condition(Subtract(Dist(Times(Subtract(Times(b, e), Times(a, f)), Power(Subtract(Times(b, c), Times(a, d)), CN1)), Int(Times(Sqrt(Plus(e, Times(f, Sqr(x)))), Power(Times(Plus(a, Times(b, Sqr(x))), Sqrt(Plus(c, Times(d, Sqr(x))))), CN1)), x), x), Dist(Times(Subtract(Times(d, e), Times(c, f)), Power(Subtract(Times(b, c), Times(a, d)), CN1)), Int(Times(Sqrt(Plus(e, Times(f, Sqr(x)))), Power(Plus(c, Times(d, Sqr(x))), QQ(-3L, 2L))), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), PosQ(Times(d, Power(c, CN1))), PosQ(Times(f, Power(e, CN1))))));
            IIntegrate(543, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), QQ(3L, 2L)), Sqrt(Plus(e_, Times(f_DEFAULT, Sqr(x_))))), x_Symbol),
                    Condition(Plus(Dist(Times(Sqr(Subtract(Times(b, c), Times(a, d))), Power(b, CN2)), Int(Times(Sqrt(Plus(e, Times(f, Sqr(x)))), Power(Times(Plus(a, Times(b, Sqr(x))), Sqrt(Plus(c, Times(d, Sqr(x))))), CN1)), x), x), Dist(Times(d, Power(b, CN2)), Int(Times(Plus(Times(C2, b, c), Times(CN1, a, d), Times(b, d, Sqr(x))), Sqrt(Plus(e, Times(f, Sqr(x)))), Power(Plus(c, Times(d, Sqr(x))), CN1D2)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), PosQ(Times(d, Power(c, CN1))), PosQ(Times(f, Power(e, CN1))))));
            IIntegrate(544, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), q_), Power(Plus(e_, Times(f_DEFAULT, Sqr(x_))), r_)), x_Symbol),
                    Condition(Subtract(Dist(Times(b, Subtract(Times(b, e), Times(a, f)), Power(Subtract(Times(b, c), Times(a, d)), CN2)), Int(Times(Power(Plus(c, Times(d, Sqr(x))), Plus(q, C2)), Power(Plus(e, Times(f, Sqr(x))), Subtract(r, C1)), Power(Plus(a, Times(b, Sqr(x))), CN1)), x), x), Dist(Power(Subtract(Times(b, c), Times(a, d)), CN2), Int(Times(Power(Plus(c, Times(d, Sqr(x))), q), Power(Plus(e, Times(f, Sqr(x))), Subtract(r, C1)), Plus(Times(C2, b, c, d, e), Times(CN1, a, Sqr(d), e), Times(CN1, b, Sqr(c), f), Times(Sqr(d), Subtract(Times(b, e), Times(a, f)), Sqr(x)))), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), LtQ(q, CN1), GtQ(r, C1))));
            IIntegrate(545, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), q_), Power(Plus(e_, Times(f_DEFAULT, Sqr(x_))), r_)), x_Symbol),
                    Condition(Plus(Dist(Times(d, Power(b, CN1)), Int(Times(Power(Plus(c, Times(d, Sqr(x))), Subtract(q, C1)), Power(Plus(e, Times(f, Sqr(x))), r)), x), x), Dist(Times(Subtract(Times(b, c), Times(a, d)), Power(b, CN1)), Int(Times(Power(Plus(c, Times(d, Sqr(x))), Subtract(q, C1)), Power(Plus(e, Times(f, Sqr(x))), r), Power(Plus(a, Times(b, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, r), x), GtQ(q, C1))));
            IIntegrate(546, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), q_), Power(Plus(e_, Times(f_DEFAULT, Sqr(x_))), r_)), x_Symbol),
                    Condition(Subtract(Dist(Times(Sqr(b), Power(Subtract(Times(b, c), Times(a, d)), CN2)), Int(Times(Power(Plus(c, Times(d, Sqr(x))), Plus(q, C2)), Power(Plus(e, Times(f, Sqr(x))), r), Power(Plus(a, Times(b, Sqr(x))), CN1)), x), x), Dist(Times(d, Power(Subtract(Times(b, c), Times(a, d)), CN2)), Int(Times(Power(Plus(c, Times(d, Sqr(x))), q), Power(Plus(e, Times(f, Sqr(x))), r), Plus(Times(C2, b, c), Times(CN1, a, d), Times(b, d, Sqr(x)))), x), x)), And(FreeQ(List(a, b, c, d, e, f, r), x), LtQ(q, CN1))));
            IIntegrate(547, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), q_), Power(Plus(e_, Times(f_DEFAULT, Sqr(x_))), r_)), x_Symbol),
                    Condition(Plus(Negate(Dist(Times(d, Power(Subtract(Times(b, c), Times(a, d)), CN1)), Int(Times(Power(Plus(c, Times(d, Sqr(x))), q), Power(Plus(e, Times(f, Sqr(x))), r)), x), x)), Dist(Times(b, Power(Subtract(Times(b, c), Times(a, d)), CN1)), Int(Times(Power(Plus(c, Times(d, Sqr(x))), Plus(q, C1)), Power(Plus(e, Times(f, Sqr(x))), r), Power(Plus(a, Times(b, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, r), x), LeQ(q, CN1))));
            IIntegrate(548, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN2), Sqrt(Plus(c_, Times(d_DEFAULT, Sqr(x_)))), Sqrt(Plus(e_, Times(f_DEFAULT, Sqr(x_))))), x_Symbol),
                    Condition(Plus(Simp(Times(x, Sqrt(Plus(c, Times(d, Sqr(x)))), Sqrt(Plus(e, Times(f, Sqr(x)))), Power(Times(C2, a, Plus(a, Times(b, Sqr(x)))), CN1)), x), Dist(Times(d, f, Power(Times(C2, a, Sqr(b)), CN1)), Int(Times(Subtract(a, Times(b, Sqr(x))), Power(Times(Sqrt(Plus(c, Times(d, Sqr(x)))), Sqrt(Plus(e, Times(f, Sqr(x))))), CN1)), x), x), Dist(Times(Subtract(Times(Sqr(b), c, e), Times(Sqr(a), d, f)), Power(Times(C2, a, Sqr(b)), CN1)), Int(Power(Times(Plus(a, Times(b, Sqr(x))), Sqrt(Plus(c, Times(d, Sqr(x)))), Sqrt(Plus(e, Times(f, Sqr(x))))), CN1), x), x)), FreeQ(List(a, b, c, d, e, f), x)));
            IIntegrate(549, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN2), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1D2), Power(Plus(e_, Times(f_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Plus(Simp(Times(Sqr(b), x, Sqrt(Plus(c, Times(d, Sqr(x)))), Sqrt(Plus(e, Times(f, Sqr(x)))), Power(Times(C2, a, Subtract(Times(b, c), Times(a, d)), Subtract(Times(b, e), Times(a, f)), Plus(a, Times(b, Sqr(x)))), CN1)), x), Negate(Dist(Times(d, f, Power(Times(C2, a, Subtract(Times(b, c), Times(a, d)), Subtract(Times(b, e), Times(a, f))), CN1)), Int(Times(Plus(a, Times(b, Sqr(x))), Power(Times(Sqrt(Plus(c, Times(d, Sqr(x)))), Sqrt(Plus(e, Times(f, Sqr(x))))), CN1)), x), x)), Dist(Times(Subtract(Plus(Times(Sqr(b), c, e), Times(C3, Sqr(a), d, f)), Times(C2, a, b, Plus(Times(d, e), Times(c, f)))), Power(Times(C2, a, Subtract(Times(b, c), Times(a, d)), Subtract(Times(b, e), Times(a, f))), CN1)), Int(Power(Times(Plus(a, Times(b, Sqr(x))), Sqrt(Plus(c, Times(d, Sqr(x)))), Sqrt(Plus(e, Times(f, Sqr(x))))), CN1), x), x)), FreeQ(List(a, b, c, d, e, f), x)));
            IIntegrate(550, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_), Power(Plus(e_, Times(f_DEFAULT, Power(x_, n_))), r_)), x_Symbol),
                    Condition(Plus(Dist(Times(d, Power(b, CN1)), Int(Times(Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), Subtract(q, C1)), Power(Plus(e, Times(f, Power(x, n))), r)), x), x), Dist(Times(Subtract(Times(b, c), Times(a, d)), Power(b, CN1)), Int(Times(Power(Plus(a, Times(b, Power(x, n))), p), Power(Plus(c, Times(d, Power(x, n))), Subtract(q, C1)), Power(Plus(e, Times(f, Power(x, n))), r)), x), x)), And(FreeQ(List(a, b, c, d, e, f, n, r), x), ILtQ(p, C0), GtQ(q, C0))));
        }
    }
}
