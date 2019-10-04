package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcSin;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1DSqrt2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Cot;
import static org.matheclipse.core.expression.F.Csc;
import static org.matheclipse.core.expression.F.EllipticE;
import static org.matheclipse.core.expression.F.EllipticPi;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sec;
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
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.g_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules117 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(2926, Int(Times(Power(Times(g_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), p_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(g, Times(C2, IntPart(p))), Power(Times(g, Cos(Plus(e, Times(f, x)))), FracPart(p)), Power(Times(g, Sec(Plus(e, Times(f, x)))), FracPart(p))), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Power(Power(Times(g, Cos(Plus(e, Times(f, x)))), p), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, m, n, p), x), Not(IntegerQ(p)))));
            IIntegrate(2927, Int(Times(Power(Plus(a_DEFAULT, Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT)), m_DEFAULT), Power(Plus(c_DEFAULT, Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT)), n_DEFAULT), Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_)), x_Symbol),
                    Condition(Dist(Times(Power(g, Times(C2, IntPart(p))), Power(Times(g, Sin(Plus(e, Times(f, x)))), FracPart(p)), Power(Times(g, Csc(Plus(e, Times(f, x)))), FracPart(p))), Int(Times(Power(Plus(a, Times(b, Cos(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Cos(Plus(e, Times(f, x))))), n), Power(Power(Times(g, Sin(Plus(e, Times(f, x)))), p), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, m, n, p), x), Not(IntegerQ(p)))));
            IIntegrate(2928, Int(Times(Sqrt(Times(g_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), Sqrt(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Times(g, Power(d, CN1)), Int(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Power(Times(g, Sin(Plus(e, Times(f, x)))), CN1D2)), x), x), Dist(Times(c, g, Power(d, CN1)), Int(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Power(Times(Sqrt(Times(g, Sin(Plus(e, Times(f, x))))), Plus(c, Times(d, Sin(Plus(e, Times(f, x)))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), Or(EqQ(Subtract(Sqr(a), Sqr(b)), C0), EqQ(Subtract(Sqr(c), Sqr(d)), C0)))));
            IIntegrate(2929, Int(Times(Sqrt(Times(g_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), Sqrt(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Times(b, Power(d, CN1)), Int(Times(Sqrt(Times(g, Sin(Plus(e, Times(f, x))))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), CN1D2)), x), x), Dist(Times(Subtract(Times(b, c), Times(a, d)), Power(d, CN1)), Int(Times(Sqrt(Times(g, Sin(Plus(e, Times(f, x))))), Power(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Plus(c, Times(d, Sin(Plus(e, Times(f, x)))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0))));
            IIntegrate(2930, Int(Times(Power(Times(g_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), CN1D2), Sqrt(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Dist(Times(CN2, b, Power(f, CN1)), Subst(Int(Power(Plus(Times(b, c), Times(a, d), Times(c, g, Sqr(x))), CN1), x), x, Times(b, Cos(Plus(e, Times(f, x))), Power(Times(Sqrt(Times(g, Sin(Plus(e, Times(f, x))))), Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))))), CN1))), x), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(2931, Int(Times(Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), CN1D2), Sqrt(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Negate(Simp(Times(Sqrt(Plus(a, b)), EllipticE(ArcSin(Times(Cos(Plus(e, Times(f, x))), Power(Plus(C1, Sin(Plus(e, Times(f, x)))), CN1))), Times(CN1, Subtract(a, b), Power(Plus(a, b), CN1))), Power(Times(c, f), CN1)), x)), And(FreeQ(List(a, b, c, d, e, f), x), EqQ(d, c), GtQ(Subtract(Sqr(b), Sqr(a)), C0), GtQ(b, C0))));
            IIntegrate(2932, Int(Times(Power(Times(g_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), CN1D2), Sqrt(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Negate(Simp(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Sqrt(Times(d, Sin(Plus(e, Times(f, x))), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), CN1))), EllipticE(ArcSin(Times(c, Cos(Plus(e, Times(f, x))), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), CN1))), Times(Subtract(Times(b, c), Times(a, d)), Power(Plus(Times(b, c), Times(a, d)), CN1))), Power(Times(d, f, Sqrt(Times(g, Sin(Plus(e, Times(f, x))))), Sqrt(Times(Sqr(c), Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Power(Times(Plus(Times(a, c), Times(b, d)), Plus(c, Times(d, Sin(Plus(e, Times(f, x)))))), CN1)))), CN1)), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), EqQ(Subtract(Sqr(c), Sqr(d)), C0))));
            IIntegrate(2933, Int(Times(Power(Times(g_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), CN1D2), Sqrt(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Plus(Dist(Times(a, Power(c, CN1)), Int(Power(Times(Sqrt(Times(g, Sin(Plus(e, Times(f, x))))), Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))))), CN1), x), x), Dist(Times(Subtract(Times(b, c), Times(a, d)), Power(Times(c, g), CN1)), Int(Times(Sqrt(Times(g, Sin(Plus(e, Times(f, x))))), Power(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Plus(c, Times(d, Sin(Plus(e, Times(f, x)))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0))));
            IIntegrate(2934, Int(Times(Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), CN1), Sqrt(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Power(c, CN1), Int(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Power(Sin(Plus(e, Times(f, x))), CN1)), x), x), Dist(Times(d, Power(c, CN1)), Int(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(2935, Int(Times(Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), CN1), Sqrt(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Plus(Dist(Times(a, Power(c, CN1)), Int(Power(Times(Sin(Plus(e, Times(f, x))), Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))))), CN1), x), x), Dist(Times(Subtract(Times(b, c), Times(a, d)), Power(c, CN1)), Int(Power(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Plus(c, Times(d, Sin(Plus(e, Times(f, x)))))), CN1), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(2936, Int(Times(Sqrt(Times(g_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Plus(Negate(Dist(Times(a, g, Power(Subtract(Times(b, c), Times(a, d)), CN1)), Int(Power(Times(Sqrt(Times(g, Sin(Plus(e, Times(f, x))))), Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))))), CN1), x), x)), Dist(Times(c, g, Power(Subtract(Times(b, c), Times(a, d)), CN1)), Int(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Power(Times(Sqrt(Times(g, Sin(Plus(e, Times(f, x))))), Plus(c, Times(d, Sin(Plus(e, Times(f, x)))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), Or(EqQ(Subtract(Sqr(a), Sqr(b)), C0), EqQ(Subtract(Sqr(c), Sqr(d)), C0)))));
            IIntegrate(2937, Int(Times(Sqrt(Times(g_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Simp(Times(C2, Sqrt(Negate(Sqr(Cot(Plus(e, Times(f, x)))))), Sqrt(Times(g, Sin(Plus(e, Times(f, x))))), Sqrt(Times(Plus(b, Times(a, Csc(Plus(e, Times(f, x))))), Power(Plus(a, b), CN1))), EllipticPi(Times(C2, c, Power(Plus(c, d), CN1)), ArcSin(Times(Sqrt(Subtract(C1, Csc(Plus(e, Times(f, x))))), C1DSqrt2)), Times(C2, a, Power(Plus(a, b), CN1))), Power(Times(f, Plus(c, d), Cot(Plus(e, Times(f, x))), Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))))), CN1)), x), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0))));
            IIntegrate(2938, Int(Times(Power(Times(g_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), CN1D2), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Times(b, Power(Subtract(Times(b, c), Times(a, d)), CN1)), Int(Power(Times(Sqrt(Times(g, Sin(Plus(e, Times(f, x))))), Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))))), CN1), x), x), Dist(Times(d, Power(Subtract(Times(b, c), Times(a, d)), CN1)), Int(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Power(Times(Sqrt(Times(g, Sin(Plus(e, Times(f, x))))), Plus(c, Times(d, Sin(Plus(e, Times(f, x)))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), Or(EqQ(Subtract(Sqr(a), Sqr(b)), C0), EqQ(Subtract(Sqr(c), Sqr(d)), C0)))));
            IIntegrate(2939, Int(Times(Power(Times(g_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), CN1D2), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Power(c, CN1), Int(Power(Times(Sqrt(Times(g, Sin(Plus(e, Times(f, x))))), Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))))), CN1), x), x), Dist(Times(d, Power(Times(c, g), CN1)), Int(Times(Sqrt(Times(g, Sin(Plus(e, Times(f, x))))), Power(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Plus(c, Times(d, Sin(Plus(e, Times(f, x)))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0))));
            IIntegrate(2940, Int(Times(Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), CN1), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Plus(Dist(Times(Sqr(d), Power(Times(c, Subtract(Times(b, c), Times(a, d))), CN1)), Int(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), CN1)), x), x), Dist(Power(Times(c, Subtract(Times(b, c), Times(a, d))), CN1), Int(Times(Subtract(Subtract(Times(b, c), Times(a, d)), Times(b, d, Sin(Plus(e, Times(f, x))))), Power(Times(Sin(Plus(e, Times(f, x))), Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(2941, Int(Times(Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), CN1), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Power(c, CN1), Int(Power(Times(Sin(Plus(e, Times(f, x))), Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))))), CN1), x), x), Dist(Times(d, Power(c, CN1)), Int(Power(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Plus(c, Times(d, Sin(Plus(e, Times(f, x)))))), CN1), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(2942, Int(Times(Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), CN1), Sqrt(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2)), x_Symbol),
                    Condition(Plus(Negate(Dist(Times(d, Power(c, CN1)), Int(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), CN1D2)), x), x)), Dist(Power(c, CN1), Int(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Sqrt(Plus(c, Times(d, Sin(Plus(e, Times(f, x)))))), Power(Sin(Plus(e, Times(f, x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), EqQ(Plus(Times(b, c), Times(a, d)), C0))));
            IIntegrate(2943, Int(Times(Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), CN1), Sqrt(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(CN2, a, Power(f, CN1)), Subst(Int(Power(Subtract(C1, Times(a, c, Sqr(x))), CN1), x), x, Times(Cos(Plus(e, Times(f, x))), Power(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Sqrt(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))))), CN1))), x), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Plus(Times(b, c), Times(a, d)), C0))));
            IIntegrate(2944, Int(Times(Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), CN1), Sqrt(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2)), x_Symbol),
                    Condition(Plus(Dist(Times(Subtract(Times(b, c), Times(a, d)), Power(c, CN1)), Int(Power(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Sqrt(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))))), CN1), x), x), Dist(Times(a, Power(c, CN1)), Int(Times(Sqrt(Plus(c, Times(d, Sin(Plus(e, Times(f, x)))))), Power(Times(Sin(Plus(e, Times(f, x))), Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), EqQ(Subtract(Sqr(c), Sqr(d)), C0))));
            IIntegrate(2945, Int(Times(Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), CN1), Sqrt(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2)), x_Symbol),
                    Condition(Simp(Times(CN2, Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Sqrt(Times(CN1, Subtract(Times(b, c), Times(a, d)), Subtract(C1, Sin(Plus(e, Times(f, x)))), Power(Times(Plus(c, d), Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), CN1))), Sqrt(Times(Subtract(Times(b, c), Times(a, d)), Plus(C1, Sin(Plus(e, Times(f, x)))), Power(Times(Subtract(c, d), Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), CN1))), EllipticPi(Times(a, Plus(c, d), Power(Times(c, Plus(a, b)), CN1)), ArcSin(Times(Rt(Times(Plus(a, b), Power(Plus(c, d), CN1)), C2), Sqrt(Plus(c, Times(d, Sin(Plus(e, Times(f, x)))))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), CN1D2))), Times(Subtract(a, b), Plus(c, d), Power(Times(Plus(a, b), Subtract(c, d)), CN1))), Power(Times(c, f, Rt(Times(Plus(a, b), Power(Plus(c, d), CN1)), C2), Cos(Plus(e, Times(f, x)))), CN1)), x), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0))));
            IIntegrate(2946, Int(Times(Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), CN1), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Cos(Plus(e, Times(f, x))), Power(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Sqrt(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))))), CN1)), Int(Power(Times(Cos(Plus(e, Times(f, x))), Sin(Plus(e, Times(f, x)))), CN1), x), x), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), EqQ(Subtract(Sqr(c), Sqr(d)), C0))));
            IIntegrate(2947, Int(Times(Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), CN1), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2)), x_Symbol),
                    Condition(Plus(Negate(Dist(Times(b, Power(a, CN1)), Int(Power(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Sqrt(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))))), CN1), x), x)), Dist(Power(a, CN1), Int(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Power(Times(Sin(Plus(e, Times(f, x))), Sqrt(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), Or(NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0)))));
            IIntegrate(2948, Int(Times(Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), CN1), Sqrt(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), Sqrt(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Dist(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Sqrt(Plus(c, Times(d, Sin(Plus(e, Times(f, x)))))), Power(Cos(Plus(e, Times(f, x))), CN1)), Int(Cot(Plus(e, Times(f, x))), x), x), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), EqQ(Subtract(Sqr(c), Sqr(d)), C0))));
            IIntegrate(2949, Int(Times(Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), CN1), Sqrt(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), Sqrt(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Dist(d, Int(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), CN1D2)), x), x), Dist(c, Int(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Power(Times(Sin(Plus(e, Times(f, x))), Sqrt(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), Or(NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0)))));
            IIntegrate(2950, Int(Times(Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(a, n), Power(c, n)), Int(Times(Power(Tan(Plus(e, Times(f, x))), p), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, n))), x), x), And(FreeQ(List(a, b, c, d, e, f, m), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), EqQ(Plus(p, Times(C2, n)), C0), IntegerQ(n))));
        }
    }
}
