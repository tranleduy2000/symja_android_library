package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcSin;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.CPiHalf;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Cot;
import static org.matheclipse.core.expression.F.Csc;
import static org.matheclipse.core.expression.F.EllipticF;
import static org.matheclipse.core.expression.F.EllipticPi;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Pi;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.QQ;
import static org.matheclipse.core.expression.F.Sign;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Tan;
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
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandTrig;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NegQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules112 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(2801, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), QQ(-3L, 2L)), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2)), x_Symbol),
                    Condition(Subtract(Dist(Power(Subtract(a, b), CN1), Int(Power(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Sqrt(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))))), CN1), x), x), Dist(Times(b, Power(Subtract(a, b), CN1)), Int(Times(Plus(C1, Sin(Plus(e, Times(f, x)))), Power(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), QQ(3L, 2L)), Sqrt(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0))));
            IIntegrate(2802, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Sqr(b), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(f, Plus(m, C1), Subtract(Times(b, c), Times(a, d)), Subtract(Sqr(a), Sqr(b))), CN1)), x)), Dist(Power(Times(Plus(m, C1), Subtract(Times(b, c), Times(a, d)), Subtract(Sqr(a), Sqr(b))), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Simp(Subtract(Subtract(Plus(Times(a, Subtract(Times(b, c), Times(a, d)), Plus(m, C1)), Times(Sqr(b), d, Plus(m, n, C2))), Times(Plus(Times(Sqr(b), c), Times(b, Subtract(Times(b, c), Times(a, d)), Plus(m, C1))), Sin(Plus(e, Times(f, x))))), Times(Sqr(b), d, Plus(m, n, C3), Sqr(Sin(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), LtQ(m, CN1), IntegersQ(Times(C2, m), Times(C2, n)), Or(And(EqQ(a, C0), IntegerQ(m), Not(IntegerQ(n))), Not(And(IntegerQ(Times(C2, n)), LtQ(n, CN1), Or(And(IntegerQ(n), Not(IntegerQ(m))), EqQ(a, C0))))))));
            IIntegrate(2803, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1), Sqrt(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Dist(Times(d, Power(b, CN1)), Int(Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), CN1D2), x), x), Dist(Times(Subtract(Times(b, c), Times(a, d)), Power(b, CN1)), Int(Power(Times(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Sqrt(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))))), CN1), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0))));
            IIntegrate(2804, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), QQ(3L, 2L)), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Times(b, Power(d, CN1)), Int(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), x), x), Dist(Times(Subtract(Times(b, c), Times(a, d)), Power(d, CN1)), Int(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0))));
            IIntegrate(2805, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2)), x_Symbol),
                    Condition(Simp(Times(C2, EllipticPi(Times(C2, b, Power(Plus(a, b), CN1)), Times(C1D2, C1, Plus(e, Times(CN1, C1D2, Pi), Times(f, x))), Times(C2, d, Power(Plus(c, d), CN1))), Power(Times(f, Plus(a, b), Sqrt(Plus(c, d))), CN1)), x), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), GtQ(Plus(c, d), C0))));
            IIntegrate(2806, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2)), x_Symbol),
                    Condition(Simp(Times(C2, EllipticPi(Times(CN2, b, Power(Subtract(a, b), CN1)), Times(C1D2, C1, Plus(e, CPiHalf, Times(f, x))), Times(CN2, d, Power(Subtract(c, d), CN1))), Power(Times(f, Subtract(a, b), Sqrt(Subtract(c, d))), CN1)), x), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), GtQ(Subtract(c, d), C0))));
            IIntegrate(2807, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Times(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Power(Plus(c, d), CN1))), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), CN1D2)), Int(Power(Times(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Sqrt(Plus(Times(c, Power(Plus(c, d), CN1)), Times(d, Sin(Plus(e, Times(f, x))), Power(Plus(c, d), CN1))))), CN1), x), x), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), Not(GtQ(Plus(c, d), C0)))));
            IIntegrate(2808, Int(Times(Sqrt(Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2)), x_Symbol),
                    Condition(Simp(Times(C2, c, Rt(Times(b, Plus(c, d)), C2), Tan(Plus(e, Times(f, x))), Sqrt(Plus(C1, Csc(Plus(e, Times(f, x))))), Sqrt(Subtract(C1, Csc(Plus(e, Times(f, x))))), EllipticPi(Times(Plus(c, d), Power(d, CN1)), ArcSin(Times(Sqrt(Plus(c, Times(d, Sin(Plus(e, Times(f, x)))))), Power(Times(Sqrt(Times(b, Sin(Plus(e, Times(f, x))))), Rt(Times(Plus(c, d), Power(b, CN1)), C2)), CN1))), Times(CN1, Plus(c, d), Power(Subtract(c, d), CN1))), Power(Times(d, f, Sqrt(Subtract(Sqr(c), Sqr(d)))), CN1)), x), And(FreeQ(List(b, c, d, e, f), x), GtQ(Subtract(Sqr(c), Sqr(d)), C0), PosQ(Times(Plus(c, d), Power(b, CN1))), GtQ(Sqr(c), C0))));
            IIntegrate(2809, Int(Times(Sqrt(Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2)), x_Symbol),
                    Condition(Simp(Times(C2, b, Tan(Plus(e, Times(f, x))), Rt(Times(Plus(c, d), Power(b, CN1)), C2), Sqrt(Times(c, Plus(C1, Csc(Plus(e, Times(f, x)))), Power(Subtract(c, d), CN1))), Sqrt(Times(c, Subtract(C1, Csc(Plus(e, Times(f, x)))), Power(Plus(c, d), CN1))), EllipticPi(Times(Plus(c, d), Power(d, CN1)), ArcSin(Times(Sqrt(Plus(c, Times(d, Sin(Plus(e, Times(f, x)))))), Power(Times(Sqrt(Times(b, Sin(Plus(e, Times(f, x))))), Rt(Times(Plus(c, d), Power(b, CN1)), C2)), CN1))), Times(CN1, Plus(c, d), Power(Subtract(c, d), CN1))), Power(Times(d, f), CN1)), x), And(FreeQ(List(b, c, d, e, f), x), NeQ(Subtract(Sqr(c), Sqr(d)), C0), PosQ(Times(Plus(c, d), Power(b, CN1))))));
            IIntegrate(2810, Int(Times(Sqrt(Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Times(b, Sin(Plus(e, Times(f, x))))), Power(Times(CN1, b, Sin(Plus(e, Times(f, x)))), CN1D2)), Int(Times(Sqrt(Times(CN1, b, Sin(Plus(e, Times(f, x))))), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), CN1D2)), x), x), And(FreeQ(List(b, c, d, e, f), x), NeQ(Subtract(Sqr(c), Sqr(d)), C0), NegQ(Times(Plus(c, d), Power(b, CN1))))));
            IIntegrate(2811, Int(Times(Sqrt(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2)), x_Symbol),
                    Condition(Simp(Times(C2, Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Sqrt(Times(Subtract(Times(b, c), Times(a, d)), Plus(C1, Sin(Plus(e, Times(f, x)))), Power(Times(Subtract(c, d), Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), CN1))), Sqrt(Times(CN1, Subtract(Times(b, c), Times(a, d)), Subtract(C1, Sin(Plus(e, Times(f, x)))), Power(Times(Plus(c, d), Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), CN1))), EllipticPi(Times(b, Plus(c, d), Power(Times(d, Plus(a, b)), CN1)), ArcSin(Times(Rt(Times(Plus(a, b), Power(Plus(c, d), CN1)), C2), Sqrt(Plus(c, Times(d, Sin(Plus(e, Times(f, x)))))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), CN1D2))), Times(Subtract(a, b), Plus(c, d), Power(Times(Plus(a, b), Subtract(c, d)), CN1))), Power(Times(d, f, Rt(Times(Plus(a, b), Power(Plus(c, d), CN1)), C2), Cos(Plus(e, Times(f, x)))), CN1)), x), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), PosQ(Times(Plus(a, b), Power(Plus(c, d), CN1))))));
            IIntegrate(2812, Int(Times(Sqrt(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Subtract(Negate(c), Times(d, Sin(Plus(e, Times(f, x)))))), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), CN1D2)), Int(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Power(Subtract(Negate(c), Times(d, Sin(Plus(e, Times(f, x))))), CN1D2)), x), x), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), NegQ(Times(Plus(a, b), Power(Plus(c, d), CN1))))));
            IIntegrate(2813, Int(Times(Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), CN1D2), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2)), x_Symbol),
                    Condition(Simp(Times(CN2, d, EllipticF(ArcSin(Times(Cos(Plus(e, Times(f, x))), Power(Plus(C1, Times(d, Sin(Plus(e, Times(f, x))))), CN1))), Times(CN1, Subtract(a, Times(b, d)), Power(Plus(a, Times(b, d)), CN1))), Power(Times(f, Sqrt(Plus(a, Times(b, d)))), CN1)), x), And(FreeQ(List(a, b, d, e, f), x), LtQ(Subtract(Sqr(a), Sqr(b)), C0), EqQ(Sqr(d), C1), GtQ(Times(b, d), C0))));
            IIntegrate(2814, Int(Times(Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), CN1D2), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Times(Sign(b), Sin(Plus(e, Times(f, x))))), Power(Times(d, Sin(Plus(e, Times(f, x)))), CN1D2)), Int(Power(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Sqrt(Times(Sign(b), Sin(Plus(e, Times(f, x)))))), CN1), x), x), And(FreeQ(List(a, b, d, e, f), x), LtQ(Subtract(Sqr(a), Sqr(b)), C0), GtQ(Sqr(b), C0), Not(And(EqQ(Sqr(d), C1), GtQ(Times(b, d), C0))))));
            IIntegrate(2815, Int(Times(Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), CN1D2), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2)), x_Symbol),
                    Condition(Simp(Times(CN2, Sqrt(Sqr(a)), Sqrt(Negate(Sqr(Cot(Plus(e, Times(f, x)))))), Rt(Times(Plus(a, b), Power(d, CN1)), C2), EllipticF(ArcSin(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Power(Times(Sqrt(Times(d, Sin(Plus(e, Times(f, x))))), Rt(Times(Plus(a, b), Power(d, CN1)), C2)), CN1))), Times(CN1, Plus(a, b), Power(Subtract(a, b), CN1))), Power(Times(a, f, Sqrt(Subtract(Sqr(a), Sqr(b))), Cot(Plus(e, Times(f, x)))), CN1)), x), And(FreeQ(List(a, b, d, e, f), x), GtQ(Subtract(Sqr(a), Sqr(b)), C0), PosQ(Times(Plus(a, b), Power(d, CN1))), GtQ(Sqr(a), C0))));
            IIntegrate(2816, Int(Times(Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), CN1D2), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2)), x_Symbol),
                    Condition(Simp(Times(CN2, Tan(Plus(e, Times(f, x))), Rt(Times(Plus(a, b), Power(d, CN1)), C2), Sqrt(Times(a, Subtract(C1, Csc(Plus(e, Times(f, x)))), Power(Plus(a, b), CN1))), Sqrt(Times(a, Plus(C1, Csc(Plus(e, Times(f, x)))), Power(Subtract(a, b), CN1))), EllipticF(ArcSin(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Power(Times(Sqrt(Times(d, Sin(Plus(e, Times(f, x))))), Rt(Times(Plus(a, b), Power(d, CN1)), C2)), CN1))), Times(CN1, Plus(a, b), Power(Subtract(a, b), CN1))), Power(Times(a, f), CN1)), x), And(FreeQ(List(a, b, d, e, f), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), PosQ(Times(Plus(a, b), Power(d, CN1))))));
            IIntegrate(2817, Int(Times(Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), CN1D2), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Times(CN1, d, Sin(Plus(e, Times(f, x))))), Power(Times(d, Sin(Plus(e, Times(f, x)))), CN1D2)), Int(Power(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Sqrt(Times(CN1, d, Sin(Plus(e, Times(f, x)))))), CN1), x), x), And(FreeQ(List(a, b, d, e, f), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NegQ(Times(Plus(a, b), Power(d, CN1))))));
            IIntegrate(2818, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2)), x_Symbol),
                    Condition(Simp(Times(C2, Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Sqrt(Times(Subtract(Times(b, c), Times(a, d)), Subtract(C1, Sin(Plus(e, Times(f, x)))), Power(Times(Plus(a, b), Plus(c, Times(d, Sin(Plus(e, Times(f, x)))))), CN1))), Sqrt(Times(CN1, Subtract(Times(b, c), Times(a, d)), Plus(C1, Sin(Plus(e, Times(f, x)))), Power(Times(Subtract(a, b), Plus(c, Times(d, Sin(Plus(e, Times(f, x)))))), CN1))), EllipticF(ArcSin(Times(Rt(Times(Plus(c, d), Power(Plus(a, b), CN1)), C2), Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), CN1D2))), Times(Plus(a, b), Subtract(c, d), Power(Times(Subtract(a, b), Plus(c, d)), CN1))), Power(Times(f, Subtract(Times(b, c), Times(a, d)), Rt(Times(Plus(c, d), Power(Plus(a, b), CN1)), C2), Cos(Plus(e, Times(f, x)))), CN1)), x), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), PosQ(Times(Plus(c, d), Power(Plus(a, b), CN1))))));
            IIntegrate(2819, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Subtract(Negate(a), Times(b, Sin(Plus(e, Times(f, x)))))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), CN1D2)), Int(Power(Times(Sqrt(Subtract(Negate(a), Times(b, Sin(Plus(e, Times(f, x)))))), Sqrt(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))))), CN1), x), x), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), NegQ(Times(Plus(c, d), Power(Plus(a, b), CN1))))));
            IIntegrate(2820, Int(Times(Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), QQ(3L, 2L)), Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2)), x_Symbol),
                    Condition(Plus(Negate(Dist(Times(a, d, Power(Times(C2, b), CN1)), Int(Times(Sqrt(Times(d, Sin(Plus(e, Times(f, x))))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), CN1D2)), x), x)), Dist(Times(d, Power(Times(C2, b), CN1)), Int(Times(Sqrt(Times(d, Sin(Plus(e, Times(f, x))))), Plus(a, Times(C2, b, Sin(Plus(e, Times(f, x))))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), CN1D2)), x), x)), And(FreeQ(List(a, b, d, e, f), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(2821, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Power(Times(f, Plus(m, n)), CN1)), x)), Dist(Power(Times(d, Plus(m, n)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, C2)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Subtract(n, C1)), Simp(Plus(Times(Sqr(a), c, d, Plus(m, n)), Times(b, d, Plus(Times(b, c, Subtract(m, C1)), Times(a, d, n))), Times(Subtract(Times(a, d, Plus(Times(C2, b, c), Times(a, d)), Plus(m, n)), Times(b, d, Subtract(Times(a, c), Times(b, d, Subtract(Plus(m, n), C1))))), Sin(Plus(e, Times(f, x)))), Times(b, d, Plus(Times(b, c, n), Times(a, d, Subtract(Plus(Times(C2, m), n), C1))), Sqr(Sin(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), LtQ(C0, m, C2), LtQ(CN1, n, C2), NeQ(Plus(m, n), C0), Or(IntegerQ(m), IntegersQ(Times(C2, m), Times(C2, n))))));
            IIntegrate(2822, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Subtract(Dist(Times(b, Power(d, CN1)), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1))), x), x), Dist(Times(Subtract(Times(b, c), Times(a, d)), Power(d, CN1)), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n)), x), x)), And(FreeQ(List(a, b, c, d, e, f, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), IGtQ(m, C0))));
            IIntegrate(2823, Int(Times(Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(a, Int(Times(Power(Times(d, Sin(Plus(e, Times(f, x)))), n), Power(Subtract(Sqr(a), Times(Sqr(b), Sqr(Sin(Plus(e, Times(f, x)))))), CN1)), x), x), Dist(Times(b, Power(d, CN1)), Int(Times(Power(Times(d, Sin(Plus(e, Times(f, x)))), Plus(n, C1)), Power(Subtract(Sqr(a), Times(Sqr(b), Sqr(Sin(Plus(e, Times(f, x)))))), CN1)), x), x)), And(FreeQ(List(a, b, d, e, f, n), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(2824, Int(Times(Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrig(Times(Power(Times(d, $($s("§sin"), Plus(e, Times(f, x)))), n), Power(Times(Power(Subtract(a, Times(b, $($s("§sin"), Plus(e, Times(f, x))))), m), Power(Power(Subtract(Sqr(a), Times(Sqr(b), Sqr($($s("§sin"), Plus(e, Times(f, x)))))), m), CN1)), CN1)), x), x), And(FreeQ(List(a, b, d, e, f, n), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), ILtQ(m, CN1))));
            IIntegrate(2825, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n)), x), And(FreeQ(List(a, b, c, d, e, f, m, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0))));
        }
    }
}
