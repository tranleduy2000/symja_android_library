package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C1D4;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CI;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.CosIntegral;
import static org.matheclipse.core.expression.F.Cosh;
import static org.matheclipse.core.expression.F.CoshIntegral;
import static org.matheclipse.core.expression.F.Erf;
import static org.matheclipse.core.expression.F.Erfc;
import static org.matheclipse.core.expression.F.Erfi;
import static org.matheclipse.core.expression.F.Exp;
import static org.matheclipse.core.expression.F.ExpIntegralEi;
import static org.matheclipse.core.expression.F.FSymbol;
import static org.matheclipse.core.expression.F.F_;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.FresnelC;
import static org.matheclipse.core.expression.F.FresnelS;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.MemberQ;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Pi;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.SinIntegral;
import static org.matheclipse.core.expression.F.Sinh;
import static org.matheclipse.core.expression.F.SinhIntegral;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_DEFAULT;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.g_;
import static org.matheclipse.core.expression.F.h_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.F;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules256 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(6401, Int(Times(Erf(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(e, x), Plus(m, C1)), Erf(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Times(e, Plus(m, C1)), CN1)), x), Dist(Times(C2, b, d, n, Power(Times(Sqrt(Pi), Plus(m, C1)), CN1)), Int(Times(Power(Times(e, x), m), Power(Exp(Sqr(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n)))))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, m, n), x), NeQ(m, CN1))));
            IIntegrate(6402, Int(Times(Erfc(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(e, x), Plus(m, C1)), Erfc(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Times(e, Plus(m, C1)), CN1)), x), Dist(Times(C2, b, d, n, Power(Times(Sqrt(Pi), Plus(m, C1)), CN1)), Int(Times(Power(Times(e, x), m), Power(Exp(Sqr(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n)))))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, m, n), x), NeQ(m, CN1))));
            IIntegrate(6403, Int(Times(Erfi(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(e, x), Plus(m, C1)), Erfi(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Times(e, Plus(m, C1)), CN1)), x), Dist(Times(C2, b, d, n, Power(Times(Sqrt(Pi), Plus(m, C1)), CN1)), Int(Times(Power(Times(e, x), m), Exp(Sqr(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))))), x), x)), And(FreeQ(List(a, b, c, d, e, m, n), x), NeQ(m, CN1))));
            IIntegrate(6404, Int(Times(Erf(Times(b_DEFAULT, x_)), Sin(Plus(c_DEFAULT, Times(d_DEFAULT, Sqr(x_))))), x_Symbol),
                    Condition(Subtract(Dist(Times(C1D2, CI), Int(Times(Exp(Subtract(Times(CN1, CI, c), Times(CI, d, Sqr(x)))), Erf(Times(b, x))), x), x), Dist(Times(C1D2, CI), Int(Times(Exp(Plus(Times(CI, c), Times(CI, d, Sqr(x)))), Erf(Times(b, x))), x), x)), And(FreeQ(List(b, c, d), x), EqQ(Sqr(d), Negate(Power(b, C4))))));
            IIntegrate(6405, Int(Times(Erfc(Times(b_DEFAULT, x_)), Sin(Plus(c_DEFAULT, Times(d_DEFAULT, Sqr(x_))))), x_Symbol),
                    Condition(Subtract(Dist(Times(C1D2, CI), Int(Times(Exp(Subtract(Times(CN1, CI, c), Times(CI, d, Sqr(x)))), Erfc(Times(b, x))), x), x), Dist(Times(C1D2, CI), Int(Times(Exp(Plus(Times(CI, c), Times(CI, d, Sqr(x)))), Erfc(Times(b, x))), x), x)), And(FreeQ(List(b, c, d), x), EqQ(Sqr(d), Negate(Power(b, C4))))));
            IIntegrate(6406, Int(Times(Erfi(Times(b_DEFAULT, x_)), Sin(Plus(c_DEFAULT, Times(d_DEFAULT, Sqr(x_))))), x_Symbol),
                    Condition(Subtract(Dist(Times(C1D2, CI), Int(Times(Exp(Subtract(Times(CN1, CI, c), Times(CI, d, Sqr(x)))), Erfi(Times(b, x))), x), x), Dist(Times(C1D2, CI), Int(Times(Exp(Plus(Times(CI, c), Times(CI, d, Sqr(x)))), Erfi(Times(b, x))), x), x)), And(FreeQ(List(b, c, d), x), EqQ(Sqr(d), Negate(Power(b, C4))))));
            IIntegrate(6407, Int(Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, Sqr(x_)))), Erf(Times(b_DEFAULT, x_))), x_Symbol),
                    Condition(Plus(Dist(C1D2, Int(Times(Exp(Subtract(Times(CN1, CI, c), Times(CI, d, Sqr(x)))), Erf(Times(b, x))), x), x), Dist(C1D2, Int(Times(Exp(Plus(Times(CI, c), Times(CI, d, Sqr(x)))), Erf(Times(b, x))), x), x)), And(FreeQ(List(b, c, d), x), EqQ(Sqr(d), Negate(Power(b, C4))))));
            IIntegrate(6408, Int(Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, Sqr(x_)))), Erfc(Times(b_DEFAULT, x_))), x_Symbol),
                    Condition(Plus(Dist(C1D2, Int(Times(Exp(Subtract(Times(CN1, CI, c), Times(CI, d, Sqr(x)))), Erfc(Times(b, x))), x), x), Dist(C1D2, Int(Times(Exp(Plus(Times(CI, c), Times(CI, d, Sqr(x)))), Erfc(Times(b, x))), x), x)), And(FreeQ(List(b, c, d), x), EqQ(Sqr(d), Negate(Power(b, C4))))));
            IIntegrate(6409, Int(Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, Sqr(x_)))), Erfi(Times(b_DEFAULT, x_))), x_Symbol),
                    Condition(Plus(Dist(C1D2, Int(Times(Exp(Subtract(Times(CN1, CI, c), Times(CI, d, Sqr(x)))), Erfi(Times(b, x))), x), x), Dist(C1D2, Int(Times(Exp(Plus(Times(CI, c), Times(CI, d, Sqr(x)))), Erfi(Times(b, x))), x), x)), And(FreeQ(List(b, c, d), x), EqQ(Sqr(d), Negate(Power(b, C4))))));
            IIntegrate(6410, Int(Times(Erf(Times(b_DEFAULT, x_)), Sinh(Plus(c_DEFAULT, Times(d_DEFAULT, Sqr(x_))))), x_Symbol),
                    Condition(Subtract(Dist(C1D2, Int(Times(Exp(Plus(c, Times(d, Sqr(x)))), Erf(Times(b, x))), x), x), Dist(C1D2, Int(Times(Exp(Subtract(Negate(c), Times(d, Sqr(x)))), Erf(Times(b, x))), x), x)), And(FreeQ(List(b, c, d), x), EqQ(Sqr(d), Power(b, C4)))));
            IIntegrate(6411, Int(Times(Erfc(Times(b_DEFAULT, x_)), Sinh(Plus(c_DEFAULT, Times(d_DEFAULT, Sqr(x_))))), x_Symbol),
                    Condition(Subtract(Dist(C1D2, Int(Times(Exp(Plus(c, Times(d, Sqr(x)))), Erfc(Times(b, x))), x), x), Dist(C1D2, Int(Times(Exp(Subtract(Negate(c), Times(d, Sqr(x)))), Erfc(Times(b, x))), x), x)), And(FreeQ(List(b, c, d), x), EqQ(Sqr(d), Power(b, C4)))));
            IIntegrate(6412, Int(Times(Erfi(Times(b_DEFAULT, x_)), Sinh(Plus(c_DEFAULT, Times(d_DEFAULT, Sqr(x_))))), x_Symbol),
                    Condition(Subtract(Dist(C1D2, Int(Times(Exp(Plus(c, Times(d, Sqr(x)))), Erfi(Times(b, x))), x), x), Dist(C1D2, Int(Times(Exp(Subtract(Negate(c), Times(d, Sqr(x)))), Erfi(Times(b, x))), x), x)), And(FreeQ(List(b, c, d), x), EqQ(Sqr(d), Power(b, C4)))));
            IIntegrate(6413, Int(Times(Cosh(Plus(c_DEFAULT, Times(d_DEFAULT, Sqr(x_)))), Erf(Times(b_DEFAULT, x_))), x_Symbol),
                    Condition(Plus(Dist(C1D2, Int(Times(Exp(Plus(c, Times(d, Sqr(x)))), Erf(Times(b, x))), x), x), Dist(C1D2, Int(Times(Exp(Subtract(Negate(c), Times(d, Sqr(x)))), Erf(Times(b, x))), x), x)), And(FreeQ(List(b, c, d), x), EqQ(Sqr(d), Power(b, C4)))));
            IIntegrate(6414, Int(Times(Cosh(Plus(c_DEFAULT, Times(d_DEFAULT, Sqr(x_)))), Erfc(Times(b_DEFAULT, x_))), x_Symbol),
                    Condition(Plus(Dist(C1D2, Int(Times(Exp(Plus(c, Times(d, Sqr(x)))), Erfc(Times(b, x))), x), x), Dist(C1D2, Int(Times(Exp(Subtract(Negate(c), Times(d, Sqr(x)))), Erfc(Times(b, x))), x), x)), And(FreeQ(List(b, c, d), x), EqQ(Sqr(d), Power(b, C4)))));
            IIntegrate(6415, Int(Times(Cosh(Plus(c_DEFAULT, Times(d_DEFAULT, Sqr(x_)))), Erfi(Times(b_DEFAULT, x_))), x_Symbol),
                    Condition(Plus(Dist(C1D2, Int(Times(Exp(Plus(c, Times(d, Sqr(x)))), Erfi(Times(b, x))), x), x), Dist(C1D2, Int(Times(Exp(Subtract(Negate(c), Times(d, Sqr(x)))), Erfi(Times(b, x))), x), x)), And(FreeQ(List(b, c, d), x), EqQ(Sqr(d), Power(b, C4)))));
            IIntegrate(6416, Int($(F_, Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), f_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(e, CN1), Subst(Int(F(Times(f, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), x), x, Plus(d, Times(e, x))), x), And(FreeQ(List(a, b, c, d, e, f, n), x), MemberQ(List(Erf, Erfc, Erfi, FresnelS, FresnelC, ExpIntegralEi, SinIntegral, CosIntegral, SinhIntegral, CoshIntegral), FSymbol))));
            IIntegrate(6417, Int(Times(Power(Plus(g_, Times(h_DEFAULT, x_)), m_DEFAULT), $(F_, Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), f_DEFAULT))), x_Symbol),
                    Condition(Dist(Power(e, CN1), Subst(Int(Times(Power(Times(g, x, Power(d, CN1)), m), F(Times(f, Plus(a, Times(b, Log(Times(c, Power(x, n)))))))), x), x, Plus(d, Times(e, x))), x), And(FreeQ(List(a, b, c, d, e, f, g, m, n), x), EqQ(Subtract(Times(e, f), Times(d, g)), C0), MemberQ(List(Erf, Erfc, Erfi, FresnelS, FresnelC, ExpIntegralEi, SinIntegral, CosIntegral, SinhIntegral, CoshIntegral), FSymbol))));
            IIntegrate(6418, Int(FresnelS(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(a, Times(b, x)), FresnelS(Plus(a, Times(b, x))), Power(b, CN1)), x), Simp(Times(Cos(Times(C1D2, Pi, Sqr(Plus(a, Times(b, x))))), Power(Times(b, Pi), CN1)), x)), FreeQ(List(a, b), x)));
            IIntegrate(6419, Int(FresnelC(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), x_Symbol),
                    Condition(Subtract(Simp(Times(Plus(a, Times(b, x)), FresnelC(Plus(a, Times(b, x))), Power(b, CN1)), x), Simp(Times(Sin(Times(C1D2, Pi, Sqr(Plus(a, Times(b, x))))), Power(Times(b, Pi), CN1)), x)), FreeQ(List(a, b), x)));
            IIntegrate(6420, Int(Sqr(FresnelS(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), x_Symbol),
                    Condition(Subtract(Simp(Times(Plus(a, Times(b, x)), Sqr(FresnelS(Plus(a, Times(b, x)))), Power(b, CN1)), x), Dist(C2, Int(Times(Plus(a, Times(b, x)), Sin(Times(C1D2, Pi, Sqr(Plus(a, Times(b, x))))), FresnelS(Plus(a, Times(b, x)))), x), x)), FreeQ(List(a, b), x)));
            IIntegrate(6421, Int(Sqr(FresnelC(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), x_Symbol),
                    Condition(Subtract(Simp(Times(Plus(a, Times(b, x)), Sqr(FresnelC(Plus(a, Times(b, x)))), Power(b, CN1)), x), Dist(C2, Int(Times(Plus(a, Times(b, x)), Cos(Times(C1D2, Pi, Sqr(Plus(a, Times(b, x))))), FresnelC(Plus(a, Times(b, x)))), x), x)), FreeQ(List(a, b), x)));
            IIntegrate(6422, Int(Power(FresnelS(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_), x_Symbol),
                    Condition(Unintegrable(Power(FresnelS(Plus(a, Times(b, x))), n), x), And(FreeQ(List(a, b, n), x), NeQ(n, C1), NeQ(n, C2))));
            IIntegrate(6423, Int(Power(FresnelC(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_), x_Symbol),
                    Condition(Unintegrable(Power(FresnelC(Plus(a, Times(b, x))), n), x), And(FreeQ(List(a, b, n), x), NeQ(n, C1), NeQ(n, C2))));
            IIntegrate(6424, Int(Times(FresnelS(Times(b_DEFAULT, x_)), Power(x_, CN1)), x_Symbol),
                    Condition(Plus(Dist(Times(C1D4, Plus(C1, CI)), Int(Times(Erf(Times(C1D2, Sqrt(Pi), Plus(C1, CI), b, x)), Power(x, CN1)), x), x), Dist(Times(C1D4, Subtract(C1, CI)), Int(Times(Erf(Times(C1D2, Sqrt(Pi), Subtract(C1, CI), b, x)), Power(x, CN1)), x), x)), FreeQ(b, x)));
            IIntegrate(6425, Int(Times(FresnelC(Times(b_DEFAULT, x_)), Power(x_, CN1)), x_Symbol),
                    Condition(Plus(Dist(Times(C1D4, Subtract(C1, CI)), Int(Times(Erf(Times(C1D2, Sqrt(Pi), Plus(C1, CI), b, x)), Power(x, CN1)), x), x), Dist(Times(C1D4, Plus(C1, CI)), Int(Times(Erf(Times(C1D2, Sqrt(Pi), Subtract(C1, CI), b, x)), Power(x, CN1)), x), x)), FreeQ(b, x)));
        }
    }
}
