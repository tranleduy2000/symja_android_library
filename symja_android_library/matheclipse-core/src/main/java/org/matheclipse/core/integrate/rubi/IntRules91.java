package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.ASymbol;
import static org.matheclipse.core.expression.F.A_;
import static org.matheclipse.core.expression.F.A_DEFAULT;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.BSymbol;
import static org.matheclipse.core.expression.F.B_DEFAULT;
import static org.matheclipse.core.expression.F.C;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.C_DEFAULT;
import static org.matheclipse.core.expression.F.Coefficient;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.D;
import static org.matheclipse.core.expression.F.Exp;
import static org.matheclipse.core.expression.F.Exponent;
import static org.matheclipse.core.expression.F.FSymbol;
import static org.matheclipse.core.expression.F.F_;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.GSymbol;
import static org.matheclipse.core.expression.F.G_;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.LogIntegral;
import static org.matheclipse.core.expression.F.MatchQ;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.PolynomialQ;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.a_DEFAULT;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
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
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.u_DEFAULT;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.w;
import static org.matheclipse.core.expression.F.w_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.expression.F.y;
import static org.matheclipse.core.expression.F.y_DEFAULT;
import static org.matheclipse.core.expression.F.z;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.F;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfExponential;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfExponentialFunction;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfExponentialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InverseFunctionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NormalizeIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules91 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(2276, Int(Times(Power(F_, Times(Plus(a_DEFAULT, Times(Sqr(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT)))), b_DEFAULT)), d_DEFAULT)), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Times(e, x), Plus(m, C1)), Power(Times(e, n, Power(Times(c, Power(x, n)), Times(Plus(m, C1), Power(n, CN1)))), CN1)), Subst(Int(Exp(Plus(Times(a, d, Log(FSymbol)), Times(Plus(m, C1), x, Power(n, CN1)), Times(b, d, Log(FSymbol), Sqr(x)))), x), x, Log(Times(c, Power(x, n)))), x), FreeQ(List(FSymbol, a, b, c, d, e, m, n), x)));
            IIntegrate(2277, Int(Power(F_, Times(Sqr(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT))), d_DEFAULT)), x_Symbol),
                    Condition(Int(Power(FSymbol, Plus(Times(Sqr(a), d), Times(C2, a, b, d, Log(Times(c, Power(x, n)))), Times(Sqr(b), d, Sqr(Log(Times(c, Power(x, n))))))), x), FreeQ(List(FSymbol, a, b, c, d, n), x)));
            IIntegrate(2278, Int(Times(Power(F_, Times(Sqr(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT))), d_DEFAULT)), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Times(e, x), m), Power(FSymbol, Plus(Times(Sqr(a), d), Times(C2, a, b, d, Log(Times(c, Power(x, n)))), Times(Sqr(b), d, Sqr(Log(Times(c, Power(x, n)))))))), x), FreeQ(List(FSymbol, a, b, c, d, e, m, n), x)));
            IIntegrate(2279, Int(Log(Plus(a_, Times(b_DEFAULT, Power(Power(F_, Times(e_DEFAULT, Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), n_DEFAULT)))), x_Symbol),
                    Condition(Dist(Power(Times(d, e, n, Log(FSymbol)), CN1), Subst(Int(Times(Log(Plus(a, Times(b, x))), Power(x, CN1)), x), x, Power(Power(FSymbol, Times(e, Plus(c, Times(d, x)))), n)), x), And(FreeQ(List(FSymbol, a, b, c, d, e, n), x), GtQ(a, C0))));
            IIntegrate(2280, Int(Log(Plus(a_, Times(b_DEFAULT, Power(Power(F_, Times(e_DEFAULT, Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), n_DEFAULT)))), x_Symbol),
                    Condition(Subtract(Simp(Times(x, Log(Plus(a, Times(b, Power(Power(FSymbol, Times(e, Plus(c, Times(d, x)))), n))))), x), Dist(Times(b, d, e, n, Log(FSymbol)), Int(Times(x, Power(Power(FSymbol, Times(e, Plus(c, Times(d, x)))), n), Power(Plus(a, Times(b, Power(Power(FSymbol, Times(e, Plus(c, Times(d, x)))), n))), CN1)), x), x)), And(FreeQ(List(FSymbol, a, b, c, d, e, n), x), Not(GtQ(a, C0)))));
            IIntegrate(2281, Int(Times(u_DEFAULT, Power(Times(a_DEFAULT, Power(F_, v_)), n_)), x_Symbol),
                    Condition(Dist(Times(Power(Times(a, Power(FSymbol, v)), n), Power(Power(FSymbol, Times(n, v)), CN1)), Int(Times(u, Power(FSymbol, Times(n, v))), x), x), And(FreeQ(List(FSymbol, a, n), x), Not(IntegerQ(n)))));
            IIntegrate(2282, Int(u_, x_Symbol),
                    Condition(With(List(Set(v, FunctionOfExponential(u, x))), Dist(Times(v, Power(D(v, x), CN1)), Subst(Int(Times(FunctionOfExponentialFunction(u, x), Power(x, CN1)), x), x, v), x)), And(FunctionOfExponentialQ(u, x), Not(MatchQ(u, Condition(Times(w_, Power(Times(a_DEFAULT, Power(v_, n_)), m_)), And(FreeQ(List(a, m, n), x), IntegerQ(Times(m, n)))))), Not(MatchQ(u, Condition(Times(Exp(Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x)))), $(F_, v_)), And(FreeQ(List(a, b, c), x), InverseFunctionQ(F(x)))))))));
            IIntegrate(2283, Int(Times(u_DEFAULT, Power(Plus(Times(a_DEFAULT, Power(F_, v_)), Times(b_DEFAULT, Power(F_, w_))), n_)), x_Symbol),
                    Condition(Int(Times(u, Power(FSymbol, Times(n, v)), Power(Plus(a, Times(b, Power(FSymbol, ExpandToSum(Subtract(w, v), x)))), n)), x), And(FreeQ(List(FSymbol, a, b, n), x), ILtQ(n, C0), LinearQ(List(v, w), x))));
            IIntegrate(2284, Int(Times(u_DEFAULT, Power(Plus(Times(a_DEFAULT, Power(F_, v_)), Times(b_DEFAULT, Power(G_, w_))), n_)), x_Symbol),
                    Condition(Int(Times(u, Power(FSymbol, Times(n, v)), Power(Plus(a, Times(b, Exp(ExpandToSum(Subtract(Times(Log(GSymbol), w), Times(Log(FSymbol), v)), x)))), n)), x), And(FreeQ(List(FSymbol, GSymbol, a, b, n), x), ILtQ(n, C0), LinearQ(List(v, w), x))));
            IIntegrate(2285, Int(Times(u_DEFAULT, Power(Plus(Times(a_DEFAULT, Power(F_, v_)), Times(b_DEFAULT, Power(F_, w_))), n_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(Times(a, Power(FSymbol, v)), Times(b, Power(FSymbol, w))), n), Power(Times(Power(FSymbol, Times(n, v)), Power(Plus(a, Times(b, Power(FSymbol, ExpandToSum(Subtract(w, v), x)))), n)), CN1)), Int(Times(u, Power(FSymbol, Times(n, v)), Power(Plus(a, Times(b, Power(FSymbol, ExpandToSum(Subtract(w, v), x)))), n)), x), x), And(FreeQ(List(FSymbol, a, b, n), x), Not(IntegerQ(n)), LinearQ(List(v, w), x))));
            IIntegrate(2286, Int(Times(u_DEFAULT, Power(Plus(Times(a_DEFAULT, Power(F_, v_)), Times(b_DEFAULT, Power(G_, w_))), n_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(Times(a, Power(FSymbol, v)), Times(b, Power(GSymbol, w))), n), Power(Times(Power(FSymbol, Times(n, v)), Power(Plus(a, Times(b, Exp(ExpandToSum(Subtract(Times(Log(GSymbol), w), Times(Log(FSymbol), v)), x)))), n)), CN1)), Int(Times(u, Power(FSymbol, Times(n, v)), Power(Plus(a, Times(b, Exp(ExpandToSum(Subtract(Times(Log(GSymbol), w), Times(Log(FSymbol), v)), x)))), n)), x), x), And(FreeQ(List(FSymbol, GSymbol, a, b, n), x), Not(IntegerQ(n)), LinearQ(List(v, w), x))));
            IIntegrate(2287, Int(Times(u_DEFAULT, Power(F_, v_), Power(G_, w_)), x_Symbol),
                    Condition(With(List(Set(z, Plus(Times(v, Log(FSymbol)), Times(w, Log(GSymbol))))), Condition(Int(Times(u, NormalizeIntegrand(Exp(z), x)), x), Or(BinomialQ(z, x), And(PolynomialQ(z, x), LeQ(Exponent(z, x), C2))))), FreeQ(List(FSymbol, GSymbol), x)));
            IIntegrate(2288, Int(Times(y_DEFAULT, Power(F_, u_), Plus(v_, w_)), x_Symbol),
                    Condition(With(List(Set(z, Times(v, y, Power(Times(Log(FSymbol), D(u, x)), CN1)))), Condition(Simp(Times(Power(FSymbol, u), z), x), EqQ(D(z, x), Times(w, y)))), FreeQ(FSymbol, x)));
            IIntegrate(2289, Int(Times(Power(F_, u_), Power(v_, n_DEFAULT), w_), x_Symbol),
                    Condition(With(List(Set(z, Plus(Times(Log(FSymbol), v, D(u, x)), Times(Plus(n, C1), D(v, x))))), Condition(Simp(Times(Coefficient(w, x, Exponent(w, x)), Power(FSymbol, u), Power(v, Plus(n, C1)), Power(Coefficient(z, x, Exponent(z, x)), CN1)), x), And(EqQ(Exponent(w, x), Exponent(z, x)), EqQ(Times(w, Coefficient(z, x, Exponent(z, x))), Times(z, Coefficient(w, x, Exponent(w, x))))))), And(FreeQ(List(FSymbol, n), x), PolynomialQ(u, x), PolynomialQ(v, x), PolynomialQ(w, x))));
            IIntegrate(2290, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(F_, Times(c_DEFAULT, Sqrt(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), CN1D2))))), n_DEFAULT), Power(Plus(A_DEFAULT, Times(B_DEFAULT, x_), Times(C_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Dist(Times(C2, e, g, Power(Times(C, Subtract(Times(e, f), Times(d, g))), CN1)), Subst(Int(Times(Power(Plus(a, Times(b, Power(FSymbol, Times(c, x)))), n), Power(x, CN1)), x), x, Times(Sqrt(Plus(d, Times(e, x))), Power(Plus(f, Times(g, x)), CN1D2))), x), And(FreeQ(List(a, b, c, d, e, f, g, ASymbol, BSymbol, C, FSymbol), x), EqQ(Subtract(Times(C, d, f), Times(ASymbol, e, g)), C0), EqQ(Subtract(Times(BSymbol, e, g), Times(C, Plus(Times(e, f), Times(d, g)))), C0), IGtQ(n, C0))));
            IIntegrate(2291, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(F_, Times(c_DEFAULT, Sqrt(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), CN1D2))))), n_DEFAULT), Power(Plus(A_, Times(C_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Dist(Times(C2, e, g, Power(Times(C, Subtract(Times(e, f), Times(d, g))), CN1)), Subst(Int(Times(Power(Plus(a, Times(b, Power(FSymbol, Times(c, x)))), n), Power(x, CN1)), x), x, Times(Sqrt(Plus(d, Times(e, x))), Power(Plus(f, Times(g, x)), CN1D2))), x), And(FreeQ(List(a, b, c, d, e, f, g, ASymbol, C, FSymbol), x), EqQ(Subtract(Times(C, d, f), Times(ASymbol, e, g)), C0), EqQ(Plus(Times(e, f), Times(d, g)), C0), IGtQ(n, C0))));
            IIntegrate(2292, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(F_, Times(c_DEFAULT, Sqrt(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), CN1D2))))), n_), Power(Plus(A_DEFAULT, Times(B_DEFAULT, x_), Times(C_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(a, Times(b, Power(FSymbol, Times(c, Sqrt(Plus(d, Times(e, x))), Power(Plus(f, Times(g, x)), CN1D2))))), n), Power(Plus(ASymbol, Times(BSymbol, x), Times(C, Sqr(x))), CN1)), x), And(FreeQ(List(a, b, c, d, e, f, g, ASymbol, BSymbol, C, FSymbol, n), x), EqQ(Subtract(Times(C, d, f), Times(ASymbol, e, g)), C0), EqQ(Subtract(Times(BSymbol, e, g), Times(C, Plus(Times(e, f), Times(d, g)))), C0), Not(IGtQ(n, C0)))));
            IIntegrate(2293, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(F_, Times(c_DEFAULT, Sqrt(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), CN1D2))))), n_), Power(Plus(A_, Times(C_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(a, Times(b, Power(FSymbol, Times(c, Sqrt(Plus(d, Times(e, x))), Power(Plus(f, Times(g, x)), CN1D2))))), n), Power(Plus(ASymbol, Times(C, Sqr(x))), CN1)), x), And(FreeQ(List(a, b, c, d, e, f, g, ASymbol, C, FSymbol, n), x), EqQ(Subtract(Times(C, d, f), Times(ASymbol, e, g)), C0), EqQ(Plus(Times(e, f), Times(d, g)), C0), Not(IGtQ(n, C0)))));
            IIntegrate(2294, Int(Times(Plus(A_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), n_DEFAULT))), B_DEFAULT)), Power(Plus(Times(Log(Times(c_DEFAULT, Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT), a_), CN1D2)), x_Symbol),
                    Condition(Plus(Simp(Times(BSymbol, Plus(d, Times(e, x)), Sqrt(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n)))))), Power(Times(b, e), CN1)), x), Dist(Times(Subtract(Times(C2, ASymbol, b), Times(BSymbol, Plus(Times(C2, a), Times(b, n)))), Power(Times(C2, b), CN1)), Int(Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), CN1D2), x), x)), FreeQ(List(a, b, c, d, e, ASymbol, BSymbol, n), x)));
            IIntegrate(2295, Int(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), x_Symbol),
                    Condition(Subtract(Simp(Times(x, Log(Times(c, Power(x, n)))), x), Simp(Times(n, x), x)), FreeQ(List(c, n), x)));
            IIntegrate(2296, Int(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Subtract(Simp(Times(x, Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), p)), x), Dist(Times(b, n, p), Int(Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), Subtract(p, C1)), x), x)), And(FreeQ(List(a, b, c, n), x), GtQ(p, C0), IntegerQ(Times(C2, p)))));
            IIntegrate(2297, Int(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), p_), x_Symbol),
                    Condition(Subtract(Simp(Times(x, Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), Plus(p, C1)), Power(Times(b, n, Plus(p, C1)), CN1)), x), Dist(Power(Times(b, n, Plus(p, C1)), CN1), Int(Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), Plus(p, C1)), x), x)), And(FreeQ(List(a, b, c, n), x), LtQ(p, CN1), IntegerQ(Times(C2, p)))));
            IIntegrate(2298, Int(Power(Log(Times(c_DEFAULT, x_)), CN1), x_Symbol),
                    Condition(Simp(Times(LogIntegral(Times(c, x)), Power(c, CN1)), x), FreeQ(c, x)));
            IIntegrate(2299, Int(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), p_), x_Symbol),
                    Condition(Dist(Power(Times(n, Power(c, Power(n, CN1))), CN1), Subst(Int(Times(Exp(Times(x, Power(n, CN1))), Power(Plus(a, Times(b, x)), p)), x), x, Log(Times(c, Power(x, n)))), x), And(FreeQ(List(a, b, c, p), x), IntegerQ(Power(n, CN1)))));
            IIntegrate(2300, Int(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), p_), x_Symbol),
                    Condition(Dist(Times(x, Power(Times(n, Power(Times(c, Power(x, n)), Power(n, CN1))), CN1)), Subst(Int(Times(Exp(Times(x, Power(n, CN1))), Power(Plus(a, Times(b, x)), p)), x), x, Log(Times(c, Power(x, n)))), x), FreeQ(List(a, b, c, n, p), x)));
        }
    }
}
