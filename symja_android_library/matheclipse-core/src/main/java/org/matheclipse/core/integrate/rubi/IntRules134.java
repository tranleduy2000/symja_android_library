package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CI;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.CPiHalf;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.Exp;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.FresnelC;
import static org.matheclipse.core.expression.F.FresnelS;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Module;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Pi;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.SinIntegral;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.a;
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
import static org.matheclipse.core.expression.F.k;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialMatchQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandTrigReduce;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearMatchQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules134 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(3351, Int(Sin(Times(d_DEFAULT, Sqr(Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), x_Symbol),
                    Condition(Simp(Times(Sqrt(CPiHalf), FresnelS(Times(Sqrt(Times(C2, Power(Pi, CN1))), Rt(d, C2), Plus(e, Times(f, x)))), Power(Times(f, Rt(d, C2)), CN1)), x), FreeQ(List(d, e, f), x)));
            IIntegrate(3352, Int(Cos(Times(d_DEFAULT, Sqr(Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), x_Symbol),
                    Condition(Simp(Times(Sqrt(CPiHalf), FresnelC(Times(Sqrt(Times(C2, Power(Pi, CN1))), Rt(d, C2), Plus(e, Times(f, x)))), Power(Times(f, Rt(d, C2)), CN1)), x), FreeQ(List(d, e, f), x)));
            IIntegrate(3353, Int(Sin(Plus(c_, Times(d_DEFAULT, Sqr(Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Dist(Sin(c), Int(Cos(Times(d, Sqr(Plus(e, Times(f, x))))), x), x), Dist(Cos(c), Int(Sin(Times(d, Sqr(Plus(e, Times(f, x))))), x), x)), FreeQ(List(c, d, e, f), x)));
            IIntegrate(3354, Int(Cos(Plus(c_, Times(d_DEFAULT, Sqr(Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Subtract(Dist(Cos(c), Int(Cos(Times(d, Sqr(Plus(e, Times(f, x))))), x), x), Dist(Sin(c), Int(Sin(Times(d, Sqr(Plus(e, Times(f, x))))), x), x)), FreeQ(List(c, d, e, f), x)));
            IIntegrate(3355, Int(Sin(Plus(c_DEFAULT, Times(d_DEFAULT, Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), n_)))), x_Symbol),
                    Condition(Subtract(Dist(Times(C1D2, CI), Int(Exp(Subtract(Times(CN1, c, CI), Times(d, CI, Power(Plus(e, Times(f, x)), n)))), x), x), Dist(Times(C1D2, CI), Int(Exp(Plus(Times(c, CI), Times(d, CI, Power(Plus(e, Times(f, x)), n)))), x), x)), And(FreeQ(List(c, d, e, f), x), IGtQ(n, C2))));
            IIntegrate(3356, Int(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), n_)))), x_Symbol),
                    Condition(Plus(Dist(C1D2, Int(Exp(Subtract(Times(CN1, c, CI), Times(d, CI, Power(Plus(e, Times(f, x)), n)))), x), x), Dist(C1D2, Int(Exp(Plus(Times(c, CI), Times(d, CI, Power(Plus(e, Times(f, x)), n)))), x), x)), And(FreeQ(List(c, d, e, f), x), IGtQ(n, C2))));
            IIntegrate(3357, Int(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sin(Plus(c_DEFAULT, Times(d_DEFAULT, Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), n_)))))), p_), x_Symbol),
                    Condition(Int(ExpandTrigReduce(Power(Plus(a, Times(b, Sin(Plus(c, Times(d, Power(Plus(e, Times(f, x)), n)))))), p), x), x), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(p, C1), IGtQ(n, C1))));
            IIntegrate(3358, Int(Power(Plus(a_DEFAULT, Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), n_)))), b_DEFAULT)), p_), x_Symbol),
                    Condition(Int(ExpandTrigReduce(Power(Plus(a, Times(b, Cos(Plus(c, Times(d, Power(Plus(e, Times(f, x)), n)))))), p), x), x), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(p, C1), IGtQ(n, C1))));
            IIntegrate(3359, Int(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sin(Plus(c_DEFAULT, Times(d_DEFAULT, Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), n_)))))), p_DEFAULT), x_Symbol),
                    Condition(Negate(Dist(Power(f, CN1), Subst(Int(Times(Power(Plus(a, Times(b, Sin(Plus(c, Times(d, Power(Power(x, n), CN1)))))), p), Power(x, CN2)), x), x, Power(Plus(e, Times(f, x)), CN1)), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(p, C0), ILtQ(n, C0), EqQ(n, CN2))));
            IIntegrate(3360, Int(Power(Plus(a_DEFAULT, Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), n_)))), b_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Negate(Dist(Power(f, CN1), Subst(Int(Times(Power(Plus(a, Times(b, Cos(Plus(c, Times(d, Power(Power(x, n), CN1)))))), p), Power(x, CN2)), x), x, Power(Plus(e, Times(f, x)), CN1)), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(p, C0), ILtQ(n, C0), EqQ(n, CN2))));
            IIntegrate(3361, Int(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sin(Plus(c_DEFAULT, Times(d_DEFAULT, Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), n_)))))), p_DEFAULT), x_Symbol),
                    Condition(Dist(Power(Times(n, f), CN1), Subst(Int(Times(Power(x, Subtract(Power(n, CN1), C1)), Power(Plus(a, Times(b, Sin(Plus(c, Times(d, x))))), p)), x), x, Power(Plus(e, Times(f, x)), n)), x), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(p, C0), IntegerQ(Power(n, CN1)))));
            IIntegrate(3362, Int(Power(Plus(a_DEFAULT, Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), n_)))), b_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Power(Times(n, f), CN1), Subst(Int(Times(Power(x, Subtract(Power(n, CN1), C1)), Power(Plus(a, Times(b, Cos(Plus(c, Times(d, x))))), p)), x), x, Power(Plus(e, Times(f, x)), n)), x), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(p, C0), IntegerQ(Power(n, CN1)))));
            IIntegrate(3363, Int(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sin(Plus(c_DEFAULT, Times(d_DEFAULT, Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), n_)))))), p_DEFAULT), x_Symbol),
                    Condition(Module(List(Set(k, Denominator(n))), Dist(Times(k, Power(f, CN1)), Subst(Int(Times(Power(x, Subtract(k, C1)), Power(Plus(a, Times(b, Sin(Plus(c, Times(d, Power(x, Times(k, n))))))), p)), x), x, Power(Plus(e, Times(f, x)), Power(k, CN1))), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(p, C0), FractionQ(n))));
            IIntegrate(3364, Int(Power(Plus(a_DEFAULT, Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), n_)))), b_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Module(List(Set(k, Denominator(n))), Dist(Times(k, Power(f, CN1)), Subst(Int(Times(Power(x, Subtract(k, C1)), Power(Plus(a, Times(b, Cos(Plus(c, Times(d, Power(x, Times(k, n))))))), p)), x), x, Power(Plus(e, Times(f, x)), Power(k, CN1))), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(p, C0), FractionQ(n))));
            IIntegrate(3365, Int(Sin(Plus(c_DEFAULT, Times(d_DEFAULT, Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), n_)))), x_Symbol),
                    Condition(Subtract(Dist(Times(C1D2, CI), Int(Exp(Subtract(Times(CN1, c, CI), Times(d, CI, Power(Plus(e, Times(f, x)), n)))), x), x), Dist(Times(C1D2, CI), Int(Exp(Plus(Times(c, CI), Times(d, CI, Power(Plus(e, Times(f, x)), n)))), x), x)), FreeQ(List(c, d, e, f, n), x)));
            IIntegrate(3366, Int(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), n_)))), x_Symbol),
                    Condition(Plus(Dist(C1D2, Int(Exp(Subtract(Times(CN1, c, CI), Times(d, CI, Power(Plus(e, Times(f, x)), n)))), x), x), Dist(C1D2, Int(Exp(Plus(Times(c, CI), Times(d, CI, Power(Plus(e, Times(f, x)), n)))), x), x)), FreeQ(List(c, d, e, f, n), x)));
            IIntegrate(3367, Int(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sin(Plus(c_DEFAULT, Times(d_DEFAULT, Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), n_)))))), p_), x_Symbol),
                    Condition(Int(ExpandTrigReduce(Power(Plus(a, Times(b, Sin(Plus(c, Times(d, Power(Plus(e, Times(f, x)), n)))))), p), x), x), And(FreeQ(List(a, b, c, d, e, f, n), x), IGtQ(p, C1))));
            IIntegrate(3368, Int(Power(Plus(a_DEFAULT, Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), n_)))), b_DEFAULT)), p_), x_Symbol),
                    Condition(Int(ExpandTrigReduce(Power(Plus(a, Times(b, Cos(Plus(c, Times(d, Power(Plus(e, Times(f, x)), n)))))), p), x), x), And(FreeQ(List(a, b, c, d, e, f, n), x), IGtQ(p, C1))));
            IIntegrate(3369, Int(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sin(Plus(c_DEFAULT, Times(d_DEFAULT, Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), n_)))))), p_), x_Symbol),
                    Condition(Unintegrable(Power(Plus(a, Times(b, Sin(Plus(c, Times(d, Power(Plus(e, Times(f, x)), n)))))), p), x), FreeQ(List(a, b, c, d, e, f, n, p), x)));
            IIntegrate(3370, Int(Power(Plus(a_DEFAULT, Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), n_)))), b_DEFAULT)), p_), x_Symbol),
                    Condition(Unintegrable(Power(Plus(a, Times(b, Cos(Plus(c, Times(d, Power(Plus(e, Times(f, x)), n)))))), p), x), FreeQ(List(a, b, c, d, e, f, n, p), x)));
            IIntegrate(3371, Int(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sin(Plus(c_DEFAULT, Times(d_DEFAULT, Power(u_, n_)))))), p_DEFAULT), x_Symbol),
                    Condition(Int(Power(Plus(a, Times(b, Sin(Plus(c, Times(d, Power(ExpandToSum(u, x), n)))))), p), x), And(FreeQ(List(a, b, c, d, n, p), x), LinearQ(u, x), Not(LinearMatchQ(u, x)))));
            IIntegrate(3372, Int(Power(Plus(a_DEFAULT, Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, Power(u_, n_)))), b_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Int(Power(Plus(a, Times(b, Cos(Plus(c, Times(d, Power(ExpandToSum(u, x), n)))))), p), x), And(FreeQ(List(a, b, c, d, n, p), x), LinearQ(u, x), Not(LinearMatchQ(u, x)))));
            IIntegrate(3373, Int(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sin(u_))), p_DEFAULT), x_Symbol),
                    Condition(Int(Power(Plus(a, Times(b, Sin(ExpandToSum(u, x)))), p), x), And(FreeQ(List(a, b, p), x), BinomialQ(u, x), Not(BinomialMatchQ(u, x)))));
            IIntegrate(3374, Int(Power(Plus(a_DEFAULT, Times(Cos(u_), b_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Int(Power(Plus(a, Times(b, Cos(ExpandToSum(u, x)))), p), x), And(FreeQ(List(a, b, p), x), BinomialQ(u, x), Not(BinomialMatchQ(u, x)))));
            IIntegrate(3375, Int(Times(Power(x_, CN1), Sin(Times(d_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Simp(Times(SinIntegral(Times(d, Power(x, n))), Power(n, CN1)), x), FreeQ(List(d, n), x)));
        }
    }
}
