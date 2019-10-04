package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.ASymbol;
import static org.matheclipse.core.expression.F.A_DEFAULT;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcCos;
import static org.matheclipse.core.expression.F.ArcSin;
import static org.matheclipse.core.expression.F.BSymbol;
import static org.matheclipse.core.expression.F.B_DEFAULT;
import static org.matheclipse.core.expression.F.C;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.CSqrt2;
import static org.matheclipse.core.expression.F.C_DEFAULT;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.CosIntegral;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.FresnelC;
import static org.matheclipse.core.expression.F.FresnelS;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Pi;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.QQ;
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
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules192 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(4801, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSin(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), u_DEFAULT), x_Symbol),
                    Condition(Unintegrable(Times(u, Power(Plus(a, Times(b, ArcSin(Times(c, x)))), n)), x), FreeQ(List(a, b, c, n), x)));
            IIntegrate(4802, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCos(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), u_DEFAULT), x_Symbol),
                    Condition(Unintegrable(Times(u, Power(Plus(a, Times(b, ArcCos(Times(c, x)))), n)), x), FreeQ(List(a, b, c, n), x)));
            IIntegrate(4803, Int(Power(Plus(a_DEFAULT, Times(ArcSin(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), n_DEFAULT), x_Symbol),
                    Condition(Dist(Power(d, CN1), Subst(Int(Power(Plus(a, Times(b, ArcSin(x))), n), x), x, Plus(c, Times(d, x))), x), FreeQ(List(a, b, c, d, n), x)));
            IIntegrate(4804, Int(Power(Plus(a_DEFAULT, Times(ArcCos(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), n_DEFAULT), x_Symbol),
                    Condition(Dist(Power(d, CN1), Subst(Int(Power(Plus(a, Times(b, ArcCos(x))), n), x), x, Plus(c, Times(d, x))), x), FreeQ(List(a, b, c, d, n), x)));
            IIntegrate(4805, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSin(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, CN1), Subst(Int(Times(Power(Plus(Times(Subtract(Times(d, e), Times(c, f)), Power(d, CN1)), Times(f, x, Power(d, CN1))), m), Power(Plus(a, Times(b, ArcSin(x))), n)), x), x, Plus(c, Times(d, x))), x), FreeQ(List(a, b, c, d, e, f, m, n), x)));
            IIntegrate(4806, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCos(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, CN1), Subst(Int(Times(Power(Plus(Times(Subtract(Times(d, e), Times(c, f)), Power(d, CN1)), Times(f, x, Power(d, CN1))), m), Power(Plus(a, Times(b, ArcCos(x))), n)), x), x, Plus(c, Times(d, x))), x), FreeQ(List(a, b, c, d, e, f, m, n), x)));
            IIntegrate(4807, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSin(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), n_DEFAULT), Power(Plus(A_DEFAULT, Times(B_DEFAULT, x_), Times(C_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, CN1), Subst(Int(Times(Power(Plus(Times(CN1, C, Power(d, CN2)), Times(C, Sqr(x), Power(d, CN2))), p), Power(Plus(a, Times(b, ArcSin(x))), n)), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d, ASymbol, BSymbol, C, n, p), x), EqQ(Plus(Times(BSymbol, Subtract(C1, Sqr(c))), Times(C2, ASymbol, c, d)), C0), EqQ(Subtract(Times(C2, c, C), Times(BSymbol, d)), C0))));
            IIntegrate(4808, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCos(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), n_DEFAULT), Power(Plus(A_DEFAULT, Times(B_DEFAULT, x_), Times(C_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, CN1), Subst(Int(Times(Power(Plus(Times(CN1, C, Power(d, CN2)), Times(C, Sqr(x), Power(d, CN2))), p), Power(Plus(a, Times(b, ArcCos(x))), n)), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d, ASymbol, BSymbol, C, n, p), x), EqQ(Plus(Times(BSymbol, Subtract(C1, Sqr(c))), Times(C2, ASymbol, c, d)), C0), EqQ(Subtract(Times(C2, c, C), Times(BSymbol, d)), C0))));
            IIntegrate(4809, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSin(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Plus(A_DEFAULT, Times(B_DEFAULT, x_), Times(C_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, CN1), Subst(Int(Times(Power(Plus(Times(Subtract(Times(d, e), Times(c, f)), Power(d, CN1)), Times(f, x, Power(d, CN1))), m), Power(Plus(Times(CN1, C, Power(d, CN2)), Times(C, Sqr(x), Power(d, CN2))), p), Power(Plus(a, Times(b, ArcSin(x))), n)), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, C, m, n, p), x), EqQ(Plus(Times(BSymbol, Subtract(C1, Sqr(c))), Times(C2, ASymbol, c, d)), C0), EqQ(Subtract(Times(C2, c, C), Times(BSymbol, d)), C0))));
            IIntegrate(4810, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCos(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Plus(A_DEFAULT, Times(B_DEFAULT, x_), Times(C_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, CN1), Subst(Int(Times(Power(Plus(Times(Subtract(Times(d, e), Times(c, f)), Power(d, CN1)), Times(f, x, Power(d, CN1))), m), Power(Plus(Times(CN1, C, Power(d, CN2)), Times(C, Sqr(x), Power(d, CN2))), p), Power(Plus(a, Times(b, ArcCos(x))), n)), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, C, m, n, p), x), EqQ(Plus(Times(BSymbol, Subtract(C1, Sqr(c))), Times(C2, ASymbol, c, d)), C0), EqQ(Subtract(Times(C2, c, C), Times(BSymbol, d)), C0))));
            IIntegrate(4811, Int(Sqrt(Plus(a_DEFAULT, Times(ArcSin(Plus(c_, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT))), x_Symbol),
                    Condition(Plus(Simp(Times(x, Sqrt(Plus(a, Times(b, ArcSin(Plus(c, Times(d, Sqr(x)))))))), x), Negate(Simp(Times(Sqrt(Pi), x, Plus(Cos(Times(a, Power(Times(C2, b), CN1))), Times(c, Sin(Times(a, Power(Times(C2, b), CN1))))), FresnelC(Times(Sqrt(Times(c, Power(Times(Pi, b), CN1))), Sqrt(Plus(a, Times(b, ArcSin(Plus(c, Times(d, Sqr(x))))))))), Power(Times(Sqrt(Times(c, Power(b, CN1))), Subtract(Cos(Times(C1D2, ArcSin(Plus(c, Times(d, Sqr(x)))))), Times(c, Sin(Times(C1D2, ArcSin(Plus(c, Times(d, Sqr(x))))))))), CN1)), x)), Simp(Times(Sqrt(Pi), x, Subtract(Cos(Times(a, Power(Times(C2, b), CN1))), Times(c, Sin(Times(a, Power(Times(C2, b), CN1))))), FresnelS(Times(Sqrt(Times(c, Power(Times(Pi, b), CN1))), Sqrt(Plus(a, Times(b, ArcSin(Plus(c, Times(d, Sqr(x))))))))), Power(Times(Sqrt(Times(c, Power(b, CN1))), Subtract(Cos(Times(C1D2, ArcSin(Plus(c, Times(d, Sqr(x)))))), Times(c, Sin(Times(C1D2, ArcSin(Plus(c, Times(d, Sqr(x))))))))), CN1)), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Sqr(c), C1))));
            IIntegrate(4812, Int(Sqrt(Plus(a_DEFAULT, Times(ArcCos(Plus(C1, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT))), x_Symbol),
                    Condition(Plus(Simp(Times(CN2, Sqrt(Plus(a, Times(b, ArcCos(Plus(C1, Times(d, Sqr(x))))))), Sqr(Sin(Times(C1D2, ArcCos(Plus(C1, Times(d, Sqr(x))))))), Power(Times(d, x), CN1)), x), Negate(Simp(Times(C2, Sqrt(Pi), Sin(Times(a, Power(Times(C2, b), CN1))), Sin(Times(C1D2, ArcCos(Plus(C1, Times(d, Sqr(x)))))), FresnelC(Times(Sqrt(Power(Times(Pi, b), CN1)), Sqrt(Plus(a, Times(b, ArcCos(Plus(C1, Times(d, Sqr(x))))))))), Power(Times(Sqrt(Power(b, CN1)), d, x), CN1)), x)), Simp(Times(C2, Sqrt(Pi), Cos(Times(a, Power(Times(C2, b), CN1))), Sin(Times(C1D2, ArcCos(Plus(C1, Times(d, Sqr(x)))))), FresnelS(Times(Sqrt(Power(Times(Pi, b), CN1)), Sqrt(Plus(a, Times(b, ArcCos(Plus(C1, Times(d, Sqr(x))))))))), Power(Times(Sqrt(Power(b, CN1)), d, x), CN1)), x)), FreeQ(List(a, b, d), x)));
            IIntegrate(4813, Int(Sqrt(Plus(a_DEFAULT, Times(ArcCos(Plus(CN1, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT))), x_Symbol),
                    Condition(Plus(Simp(Times(C2, Sqrt(Plus(a, Times(b, ArcCos(Plus(CN1, Times(d, Sqr(x))))))), Sqr(Cos(Times(C1D2, ArcCos(Plus(CN1, Times(d, Sqr(x))))))), Power(Times(d, x), CN1)), x), Negate(Simp(Times(C2, Sqrt(Pi), Cos(Times(a, Power(Times(C2, b), CN1))), Cos(Times(C1D2, ArcCos(Plus(CN1, Times(d, Sqr(x)))))), FresnelC(Times(Sqrt(Power(Times(Pi, b), CN1)), Sqrt(Plus(a, Times(b, ArcCos(Plus(CN1, Times(d, Sqr(x))))))))), Power(Times(Sqrt(Power(b, CN1)), d, x), CN1)), x)), Negate(Simp(Times(C2, Sqrt(Pi), Sin(Times(a, Power(Times(C2, b), CN1))), Cos(Times(C1D2, ArcCos(Plus(CN1, Times(d, Sqr(x)))))), FresnelS(Times(Sqrt(Power(Times(Pi, b), CN1)), Sqrt(Plus(a, Times(b, ArcCos(Plus(CN1, Times(d, Sqr(x))))))))), Power(Times(Sqrt(Power(b, CN1)), d, x), CN1)), x))), FreeQ(List(a, b, d), x)));
            IIntegrate(4814, Int(Power(Plus(a_DEFAULT, Times(ArcSin(Plus(c_, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT)), n_), x_Symbol),
                    Condition(Plus(Simp(Times(x, Power(Plus(a, Times(b, ArcSin(Plus(c, Times(d, Sqr(x)))))), n)), x), Negate(Dist(Times(C4, Sqr(b), n, Subtract(n, C1)), Int(Power(Plus(a, Times(b, ArcSin(Plus(c, Times(d, Sqr(x)))))), Subtract(n, C2)), x), x)), Simp(Times(C2, b, n, Sqrt(Subtract(Times(CN2, c, d, Sqr(x)), Times(Sqr(d), Power(x, C4)))), Power(Plus(a, Times(b, ArcSin(Plus(c, Times(d, Sqr(x)))))), Subtract(n, C1)), Power(Times(d, x), CN1)), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Sqr(c), C1), GtQ(n, C1))));
            IIntegrate(4815, Int(Power(Plus(a_DEFAULT, Times(ArcCos(Plus(c_, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT)), n_), x_Symbol),
                    Condition(Plus(Simp(Times(x, Power(Plus(a, Times(b, ArcCos(Plus(c, Times(d, Sqr(x)))))), n)), x), Negate(Dist(Times(C4, Sqr(b), n, Subtract(n, C1)), Int(Power(Plus(a, Times(b, ArcCos(Plus(c, Times(d, Sqr(x)))))), Subtract(n, C2)), x), x)), Negate(Simp(Times(C2, b, n, Sqrt(Subtract(Times(CN2, c, d, Sqr(x)), Times(Sqr(d), Power(x, C4)))), Power(Plus(a, Times(b, ArcCos(Plus(c, Times(d, Sqr(x)))))), Subtract(n, C1)), Power(Times(d, x), CN1)), x))), And(FreeQ(List(a, b, c, d), x), EqQ(Sqr(c), C1), GtQ(n, C1))));
            IIntegrate(4816, Int(Power(Plus(a_DEFAULT, Times(ArcSin(Plus(c_, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT)), CN1), x_Symbol),
                    Condition(Subtract(Negate(Simp(Times(x, Subtract(Times(c, Cos(Times(a, Power(Times(C2, b), CN1)))), Sin(Times(a, Power(Times(C2, b), CN1)))), CosIntegral(Times(c, Power(Times(C2, b), CN1), Plus(a, Times(b, ArcSin(Plus(c, Times(d, Sqr(x)))))))), Power(Times(C2, b, Subtract(Cos(Times(C1D2, ArcSin(Plus(c, Times(d, Sqr(x)))))), Times(c, Sin(Times(C1D2, ArcSin(Plus(c, Times(d, Sqr(x))))))))), CN1)), x)), Simp(Times(x, Plus(Times(c, Cos(Times(a, Power(Times(C2, b), CN1)))), Sin(Times(a, Power(Times(C2, b), CN1)))), SinIntegral(Times(c, Power(Times(C2, b), CN1), Plus(a, Times(b, ArcSin(Plus(c, Times(d, Sqr(x)))))))), Power(Times(C2, b, Subtract(Cos(Times(C1D2, ArcSin(Plus(c, Times(d, Sqr(x)))))), Times(c, Sin(Times(C1D2, ArcSin(Plus(c, Times(d, Sqr(x))))))))), CN1)), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Sqr(c), C1))));
            IIntegrate(4817, Int(Power(Plus(a_DEFAULT, Times(ArcCos(Plus(C1, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT)), CN1), x_Symbol),
                    Condition(Plus(Simp(Times(x, Cos(Times(a, Power(Times(C2, b), CN1))), CosIntegral(Times(Plus(a, Times(b, ArcCos(Plus(C1, Times(d, Sqr(x)))))), Power(Times(C2, b), CN1))), Power(Times(CSqrt2, b, Sqrt(Times(CN1, d, Sqr(x)))), CN1)), x), Simp(Times(x, Sin(Times(a, Power(Times(C2, b), CN1))), SinIntegral(Times(Plus(a, Times(b, ArcCos(Plus(C1, Times(d, Sqr(x)))))), Power(Times(C2, b), CN1))), Power(Times(CSqrt2, b, Sqrt(Times(CN1, d, Sqr(x)))), CN1)), x)), FreeQ(List(a, b, d), x)));
            IIntegrate(4818, Int(Power(Plus(a_DEFAULT, Times(ArcCos(Plus(CN1, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT)), CN1), x_Symbol),
                    Condition(Subtract(Simp(Times(x, Sin(Times(a, Power(Times(C2, b), CN1))), CosIntegral(Times(Plus(a, Times(b, ArcCos(Plus(CN1, Times(d, Sqr(x)))))), Power(Times(C2, b), CN1))), Power(Times(CSqrt2, b, Sqrt(Times(d, Sqr(x)))), CN1)), x), Simp(Times(x, Cos(Times(a, Power(Times(C2, b), CN1))), SinIntegral(Times(Plus(a, Times(b, ArcCos(Plus(CN1, Times(d, Sqr(x)))))), Power(Times(C2, b), CN1))), Power(Times(CSqrt2, b, Sqrt(Times(d, Sqr(x)))), CN1)), x)), FreeQ(List(a, b, d), x)));
            IIntegrate(4819, Int(Power(Plus(a_DEFAULT, Times(ArcSin(Plus(c_, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT)), CN1D2), x_Symbol),
                    Condition(Subtract(Negate(Simp(Times(Sqrt(Pi), x, Subtract(Cos(Times(a, Power(Times(C2, b), CN1))), Times(c, Sin(Times(a, Power(Times(C2, b), CN1))))), FresnelC(Times(C1, Sqrt(Plus(a, Times(b, ArcSin(Plus(c, Times(d, Sqr(x))))))), Power(Times(Sqrt(Times(b, c)), Sqrt(Pi)), CN1))), Power(Times(Sqrt(Times(b, c)), Subtract(Cos(Times(C1D2, ArcSin(Plus(c, Times(d, Sqr(x)))))), Times(c, Sin(Times(C1D2, ArcSin(Plus(c, Times(d, Sqr(x))))))))), CN1)), x)), Simp(Times(Sqrt(Pi), x, Plus(Cos(Times(a, Power(Times(C2, b), CN1))), Times(c, Sin(Times(a, Power(Times(C2, b), CN1))))), FresnelS(Times(Power(Times(Sqrt(Times(b, c)), Sqrt(Pi)), CN1), Sqrt(Plus(a, Times(b, ArcSin(Plus(c, Times(d, Sqr(x))))))))), Power(Times(Sqrt(Times(b, c)), Subtract(Cos(Times(C1D2, ArcSin(Plus(c, Times(d, Sqr(x)))))), Times(c, Sin(Times(C1D2, ArcSin(Plus(c, Times(d, Sqr(x))))))))), CN1)), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Sqr(c), C1))));
            IIntegrate(4820, Int(Power(Plus(a_DEFAULT, Times(ArcCos(Plus(C1, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT)), CN1D2), x_Symbol),
                    Condition(Subtract(Simp(Times(CN2, Sqrt(Times(Pi, Power(b, CN1))), Cos(Times(a, Power(Times(C2, b), CN1))), Sin(Times(C1D2, ArcCos(Plus(C1, Times(d, Sqr(x)))))), FresnelC(Times(Sqrt(Power(Times(Pi, b), CN1)), Sqrt(Plus(a, Times(b, ArcCos(Plus(C1, Times(d, Sqr(x))))))))), Power(Times(d, x), CN1)), x), Simp(Times(C2, Sqrt(Times(Pi, Power(b, CN1))), Sin(Times(a, Power(Times(C2, b), CN1))), Sin(Times(C1D2, ArcCos(Plus(C1, Times(d, Sqr(x)))))), FresnelS(Times(Sqrt(Power(Times(Pi, b), CN1)), Sqrt(Plus(a, Times(b, ArcCos(Plus(C1, Times(d, Sqr(x))))))))), Power(Times(d, x), CN1)), x)), FreeQ(List(a, b, d), x)));
            IIntegrate(4821, Int(Power(Plus(a_DEFAULT, Times(ArcCos(Plus(CN1, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT)), CN1D2), x_Symbol),
                    Condition(Subtract(Simp(Times(C2, Sqrt(Times(Pi, Power(b, CN1))), Sin(Times(a, Power(Times(C2, b), CN1))), Cos(Times(C1D2, ArcCos(Plus(CN1, Times(d, Sqr(x)))))), FresnelC(Times(Sqrt(Power(Times(Pi, b), CN1)), Sqrt(Plus(a, Times(b, ArcCos(Plus(CN1, Times(d, Sqr(x))))))))), Power(Times(d, x), CN1)), x), Simp(Times(C2, Sqrt(Times(Pi, Power(b, CN1))), Cos(Times(a, Power(Times(C2, b), CN1))), Cos(Times(C1D2, ArcCos(Plus(CN1, Times(d, Sqr(x)))))), FresnelS(Times(Sqrt(Power(Times(Pi, b), CN1)), Sqrt(Plus(a, Times(b, ArcCos(Plus(CN1, Times(d, Sqr(x))))))))), Power(Times(d, x), CN1)), x)), FreeQ(List(a, b, d), x)));
            IIntegrate(4822, Int(Power(Plus(a_DEFAULT, Times(ArcSin(Plus(c_, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT)), QQ(-3L, 2L)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Sqrt(Subtract(Times(CN2, c, d, Sqr(x)), Times(Sqr(d), Power(x, C4)))), Power(Times(b, d, x, Sqrt(Plus(a, Times(b, ArcSin(Plus(c, Times(d, Sqr(x)))))))), CN1)), x)), Negate(Simp(Times(Power(Times(c, Power(b, CN1)), QQ(3L, 2L)), Sqrt(Pi), x, Plus(Cos(Times(a, Power(Times(C2, b), CN1))), Times(c, Sin(Times(a, Power(Times(C2, b), CN1))))), FresnelC(Times(Sqrt(Times(c, Power(Times(Pi, b), CN1))), Sqrt(Plus(a, Times(b, ArcSin(Plus(c, Times(d, Sqr(x))))))))), Power(Subtract(Cos(Times(C1D2, ArcSin(Plus(c, Times(d, Sqr(x)))))), Times(c, Sin(Times(C1D2, ArcSin(Plus(c, Times(d, Sqr(x)))))))), CN1)), x)), Simp(Times(Power(Times(c, Power(b, CN1)), QQ(3L, 2L)), Sqrt(Pi), x, Subtract(Cos(Times(a, Power(Times(C2, b), CN1))), Times(c, Sin(Times(a, Power(Times(C2, b), CN1))))), FresnelS(Times(Sqrt(Times(c, Power(Times(Pi, b), CN1))), Sqrt(Plus(a, Times(b, ArcSin(Plus(c, Times(d, Sqr(x))))))))), Power(Subtract(Cos(Times(C1D2, ArcSin(Plus(c, Times(d, Sqr(x)))))), Times(c, Sin(Times(C1D2, ArcSin(Plus(c, Times(d, Sqr(x)))))))), CN1)), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Sqr(c), C1))));
            IIntegrate(4823, Int(Power(Plus(a_DEFAULT, Times(ArcCos(Plus(C1, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT)), QQ(-3L, 2L)), x_Symbol),
                    Condition(Plus(Simp(Times(Sqrt(Subtract(Times(CN2, d, Sqr(x)), Times(Sqr(d), Power(x, C4)))), Power(Times(b, d, x, Sqrt(Plus(a, Times(b, ArcCos(Plus(C1, Times(d, Sqr(x)))))))), CN1)), x), Negate(Simp(Times(C2, Power(Power(b, CN1), QQ(3L, 2L)), Sqrt(Pi), Sin(Times(a, Power(Times(C2, b), CN1))), Sin(Times(C1D2, ArcCos(Plus(C1, Times(d, Sqr(x)))))), FresnelC(Times(Sqrt(Power(Times(Pi, b), CN1)), Sqrt(Plus(a, Times(b, ArcCos(Plus(C1, Times(d, Sqr(x))))))))), Power(Times(d, x), CN1)), x)), Simp(Times(C2, Power(Power(b, CN1), QQ(3L, 2L)), Sqrt(Pi), Cos(Times(a, Power(Times(C2, b), CN1))), Sin(Times(C1D2, ArcCos(Plus(C1, Times(d, Sqr(x)))))), FresnelS(Times(Sqrt(Power(Times(Pi, b), CN1)), Sqrt(Plus(a, Times(b, ArcCos(Plus(C1, Times(d, Sqr(x))))))))), Power(Times(d, x), CN1)), x)), FreeQ(List(a, b, d), x)));
            IIntegrate(4824, Int(Power(Plus(a_DEFAULT, Times(ArcCos(Plus(CN1, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT)), QQ(-3L, 2L)), x_Symbol),
                    Condition(Plus(Simp(Times(Sqrt(Subtract(Times(C2, d, Sqr(x)), Times(Sqr(d), Power(x, C4)))), Power(Times(b, d, x, Sqrt(Plus(a, Times(b, ArcCos(Plus(CN1, Times(d, Sqr(x)))))))), CN1)), x), Negate(Simp(Times(C2, Power(Power(b, CN1), QQ(3L, 2L)), Sqrt(Pi), Cos(Times(a, Power(Times(C2, b), CN1))), Cos(Times(C1D2, ArcCos(Plus(CN1, Times(d, Sqr(x)))))), FresnelC(Times(Sqrt(Power(Times(Pi, b), CN1)), Sqrt(Plus(a, Times(b, ArcCos(Plus(CN1, Times(d, Sqr(x))))))))), Power(Times(d, x), CN1)), x)), Negate(Simp(Times(C2, Power(Power(b, CN1), QQ(3L, 2L)), Sqrt(Pi), Sin(Times(a, Power(Times(C2, b), CN1))), Cos(Times(C1D2, ArcCos(Plus(CN1, Times(d, Sqr(x)))))), FresnelS(Times(Sqrt(Power(Times(Pi, b), CN1)), Sqrt(Plus(a, Times(b, ArcCos(Plus(CN1, Times(d, Sqr(x))))))))), Power(Times(d, x), CN1)), x))), FreeQ(List(a, b, d), x)));
            IIntegrate(4825, Int(Power(Plus(a_DEFAULT, Times(ArcSin(Plus(c_, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT)), CN2), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Sqrt(Subtract(Times(CN2, c, d, Sqr(x)), Times(Sqr(d), Power(x, C4)))), Power(Times(C2, b, d, x, Plus(a, Times(b, ArcSin(Plus(c, Times(d, Sqr(x))))))), CN1)), x)), Negate(Simp(Times(x, Plus(Cos(Times(a, Power(Times(C2, b), CN1))), Times(c, Sin(Times(a, Power(Times(C2, b), CN1))))), CosIntegral(Times(c, Power(Times(C2, b), CN1), Plus(a, Times(b, ArcSin(Plus(c, Times(d, Sqr(x)))))))), Power(Times(C4, Sqr(b), Subtract(Cos(Times(C1D2, ArcSin(Plus(c, Times(d, Sqr(x)))))), Times(c, Sin(Times(C1D2, ArcSin(Plus(c, Times(d, Sqr(x))))))))), CN1)), x)), Simp(Times(x, Subtract(Cos(Times(a, Power(Times(C2, b), CN1))), Times(c, Sin(Times(a, Power(Times(C2, b), CN1))))), SinIntegral(Times(c, Power(Times(C2, b), CN1), Plus(a, Times(b, ArcSin(Plus(c, Times(d, Sqr(x)))))))), Power(Times(C4, Sqr(b), Subtract(Cos(Times(C1D2, ArcSin(Plus(c, Times(d, Sqr(x)))))), Times(c, Sin(Times(C1D2, ArcSin(Plus(c, Times(d, Sqr(x))))))))), CN1)), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Sqr(c), C1))));
        }
    }
}
