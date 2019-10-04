package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcCos;
import static org.matheclipse.core.expression.F.ArcSin;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
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
import static org.matheclipse.core.expression.F.d_;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.g_DEFAULT;
import static org.matheclipse.core.expression.F.h;
import static org.matheclipse.core.expression.F.h_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntHide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InverseFunctionFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalFunctionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumQ;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules191 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(4776, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCos(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Plus(f_, Times(g_DEFAULT, x_)), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(a, Times(b, ArcCos(Times(c, x)))), n), Power(Plus(d, Times(e, Sqr(x))), CN1D2)), Times(Power(Plus(f, Times(g, x)), m), Power(Plus(d, Times(e, Sqr(x))), Plus(p, C1D2))), x), x), And(FreeQ(List(a, b, c, d, e, f, g), x), EqQ(Plus(Times(Sqr(c), d), e), C0), IntegerQ(m), ILtQ(Plus(p, C1D2), C0), GtQ(d, C0), IGtQ(n, C0))));
            IIntegrate(4777, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSin(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Plus(f_, Times(g_DEFAULT, x_)), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(d, IntPart(p)), Power(Plus(d, Times(e, Sqr(x))), FracPart(p)), Power(Power(Subtract(C1, Times(Sqr(c), Sqr(x))), FracPart(p)), CN1)), Int(Times(Power(Plus(f, Times(g, x)), m), Power(Subtract(C1, Times(Sqr(c), Sqr(x))), p), Power(Plus(a, Times(b, ArcSin(Times(c, x)))), n)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, n), x), EqQ(Plus(Times(Sqr(c), d), e), C0), IntegerQ(m), IntegerQ(Subtract(p, C1D2)), Not(GtQ(d, C0)))));
            IIntegrate(4778, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCos(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Plus(f_, Times(g_DEFAULT, x_)), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(d, IntPart(p)), Power(Plus(d, Times(e, Sqr(x))), FracPart(p)), Power(Power(Subtract(C1, Times(Sqr(c), Sqr(x))), FracPart(p)), CN1)), Int(Times(Power(Plus(f, Times(g, x)), m), Power(Subtract(C1, Times(Sqr(c), Sqr(x))), p), Power(Plus(a, Times(b, ArcCos(Times(c, x)))), n)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, n), x), EqQ(Plus(Times(Sqr(c), d), e), C0), IntegerQ(m), IntegerQ(Subtract(p, C1D2)), Not(GtQ(d, C0)))));
            IIntegrate(4779, Int(Times(Log(Times(h_DEFAULT, Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), m_DEFAULT))), Power(Plus(a_DEFAULT, Times(ArcSin(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Subtract(Simp(Times(Log(Times(h, Power(Plus(f, Times(g, x)), m))), Power(Plus(a, Times(b, ArcSin(Times(c, x)))), Plus(n, C1)), Power(Times(b, c, Sqrt(d), Plus(n, C1)), CN1)), x), Dist(Times(g, m, Power(Times(b, c, Sqrt(d), Plus(n, C1)), CN1)), Int(Times(Power(Plus(a, Times(b, ArcSin(Times(c, x)))), Plus(n, C1)), Power(Plus(f, Times(g, x)), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, h, m), x), EqQ(Plus(Times(Sqr(c), d), e), C0), GtQ(d, C0), IGtQ(n, C0))));
            IIntegrate(4780, Int(Times(Log(Times(h_DEFAULT, Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), m_DEFAULT))), Power(Plus(a_DEFAULT, Times(ArcCos(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Log(Times(h, Power(Plus(f, Times(g, x)), m))), Power(Plus(a, Times(b, ArcCos(Times(c, x)))), Plus(n, C1)), Power(Times(b, c, Sqrt(d), Plus(n, C1)), CN1)), x)), Dist(Times(g, m, Power(Times(b, c, Sqrt(d), Plus(n, C1)), CN1)), Int(Times(Power(Plus(a, Times(b, ArcCos(Times(c, x)))), Plus(n, C1)), Power(Plus(f, Times(g, x)), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, h, m), x), EqQ(Plus(Times(Sqr(c), d), e), C0), GtQ(d, C0), IGtQ(n, C0))));
            IIntegrate(4781, Int(Times(Log(Times(h_DEFAULT, Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), m_DEFAULT))), Power(Plus(a_DEFAULT, Times(ArcSin(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(d, IntPart(p)), Power(Plus(d, Times(e, Sqr(x))), FracPart(p)), Power(Power(Subtract(C1, Times(Sqr(c), Sqr(x))), FracPart(p)), CN1)), Int(Times(Log(Times(h, Power(Plus(f, Times(g, x)), m))), Power(Subtract(C1, Times(Sqr(c), Sqr(x))), p), Power(Plus(a, Times(b, ArcSin(Times(c, x)))), n)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, h, m, n), x), EqQ(Plus(Times(Sqr(c), d), e), C0), IntegerQ(Subtract(p, C1D2)), Not(GtQ(d, C0)))));
            IIntegrate(4782, Int(Times(Log(Times(h_DEFAULT, Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), m_DEFAULT))), Power(Plus(a_DEFAULT, Times(ArcCos(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(d, IntPart(p)), Power(Plus(d, Times(e, Sqr(x))), FracPart(p)), Power(Power(Subtract(C1, Times(Sqr(c), Sqr(x))), FracPart(p)), CN1)), Int(Times(Log(Times(h, Power(Plus(f, Times(g, x)), m))), Power(Subtract(C1, Times(Sqr(c), Sqr(x))), p), Power(Plus(a, Times(b, ArcCos(Times(c, x)))), n)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, h, m, n), x), EqQ(Plus(Times(Sqr(c), d), e), C0), IntegerQ(Subtract(p, C1D2)), Not(GtQ(d, C0)))));
            IIntegrate(4783, Int(Times(Plus(a_DEFAULT, Times(ArcSin(Times(c_DEFAULT, x_)), b_DEFAULT)), Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(f_, Times(g_DEFAULT, x_)), m_)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Times(Power(Plus(d, Times(e, x)), m), Power(Plus(f, Times(g, x)), m)), x))), Subtract(Dist(Plus(a, Times(b, ArcSin(Times(c, x)))), u, x), Dist(Times(b, c), Int(Dist(Power(Subtract(C1, Times(Sqr(c), Sqr(x))), CN1D2), u, x), x), x))), And(FreeQ(List(a, b, c, d, e, f, g), x), ILtQ(Plus(m, C1D2), C0))));
            IIntegrate(4784, Int(Times(Plus(a_DEFAULT, Times(ArcCos(Times(c_DEFAULT, x_)), b_DEFAULT)), Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(f_, Times(g_DEFAULT, x_)), m_)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Times(Power(Plus(d, Times(e, x)), m), Power(Plus(f, Times(g, x)), m)), x))), Plus(Dist(Plus(a, Times(b, ArcCos(Times(c, x)))), u, x), Dist(Times(b, c), Int(Dist(Power(Subtract(C1, Times(Sqr(c), Sqr(x))), CN1D2), u, x), x), x))), And(FreeQ(List(a, b, c, d, e, f, g), x), ILtQ(Plus(m, C1D2), C0))));
            IIntegrate(4785, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSin(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, x_)), m_DEFAULT), Power(Plus(f_, Times(g_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(d, Times(e, x)), m), Power(Plus(f, Times(g, x)), m), Power(Plus(a, Times(b, ArcSin(Times(c, x)))), n)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, n), x), IntegerQ(m))));
            IIntegrate(4786, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCos(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, x_)), m_DEFAULT), Power(Plus(f_, Times(g_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(d, Times(e, x)), m), Power(Plus(f, Times(g, x)), m), Power(Plus(a, Times(b, ArcCos(Times(c, x)))), n)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, n), x), IntegerQ(m))));
            IIntegrate(4787, Int(Times(Plus(a_DEFAULT, Times(ArcSin(Times(c_DEFAULT, x_)), b_DEFAULT)), u_), x_Symbol),
                    Condition(With(List(Set(v, IntHide(u, x))), Condition(Subtract(Dist(Plus(a, Times(b, ArcSin(Times(c, x)))), v, x), Dist(Times(b, c), Int(SimplifyIntegrand(Times(v, Power(Subtract(C1, Times(Sqr(c), Sqr(x))), CN1D2)), x), x), x)), InverseFunctionFreeQ(v, x))), FreeQ(List(a, b, c), x)));
            IIntegrate(4788, Int(Times(Plus(a_DEFAULT, Times(ArcCos(Times(c_DEFAULT, x_)), b_DEFAULT)), u_), x_Symbol),
                    Condition(With(List(Set(v, IntHide(u, x))), Condition(Plus(Dist(Plus(a, Times(b, ArcCos(Times(c, x)))), v, x), Dist(Times(b, c), Int(SimplifyIntegrand(Times(v, Power(Subtract(C1, Times(Sqr(c), Sqr(x))), CN1D2)), x), x), x)), InverseFunctionFreeQ(v, x))), FreeQ(List(a, b, c), x)));
            IIntegrate(4789, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSin(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), $p("§px"), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(With(List(Set(u, ExpandIntegrand(Times($s("§px"), Power(Plus(d, Times(e, Sqr(x))), p), Power(Plus(a, Times(b, ArcSin(Times(c, x)))), n)), x))), Condition(Int(u, x), SumQ(u))), And(FreeQ(List(a, b, c, d, e, n), x), PolynomialQ($s("§px"), x), EqQ(Plus(Times(Sqr(c), d), e), C0), IntegerQ(Subtract(p, C1D2)))));
            IIntegrate(4790, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCos(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), $p("§px"), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(With(List(Set(u, ExpandIntegrand(Times($s("§px"), Power(Plus(d, Times(e, Sqr(x))), p), Power(Plus(a, Times(b, ArcCos(Times(c, x)))), n)), x))), Condition(Int(u, x), SumQ(u))), And(FreeQ(List(a, b, c, d, e, n), x), PolynomialQ($s("§px"), x), EqQ(Plus(Times(Sqr(c), d), e), C0), IntegerQ(Subtract(p, C1D2)))));
            IIntegrate(4791, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSin(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), $p("§px", true), Power(Plus(f_, Times(g_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), p_))), m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, ExpandIntegrand(Times($s("§px"), Power(Plus(f, Times(g, Power(Plus(d, Times(e, Sqr(x))), p))), m), Power(Plus(a, Times(b, ArcSin(Times(c, x)))), n)), x))), Condition(Int(u, x), SumQ(u))), And(FreeQ(List(a, b, c, d, e, f, g), x), PolynomialQ($s("§px"), x), EqQ(Plus(Times(Sqr(c), d), e), C0), IGtQ(Plus(p, C1D2), C0), IntegersQ(m, n))));
            IIntegrate(4792, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCos(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), $p("§px", true), Power(Plus(f_, Times(g_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), p_))), m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, ExpandIntegrand(Times($s("§px"), Power(Plus(f, Times(g, Power(Plus(d, Times(e, Sqr(x))), p))), m), Power(Plus(a, Times(b, ArcCos(Times(c, x)))), n)), x))), Condition(Int(u, x), SumQ(u))), And(FreeQ(List(a, b, c, d, e, f, g), x), PolynomialQ($s("§px"), x), EqQ(Plus(Times(Sqr(c), d), e), C0), IGtQ(Plus(p, C1D2), C0), IntegersQ(m, n))));
            IIntegrate(4793, Int(Times(Power(ArcSin(Times(c_DEFAULT, x_)), n_DEFAULT), $p("§rfx")), x_Symbol),
                    Condition(With(List(Set(u, ExpandIntegrand(Power(ArcSin(Times(c, x)), n), $s("§rfx"), x))), Condition(Int(u, x), SumQ(u))), And(FreeQ(c, x), RationalFunctionQ($s("§rfx"), x), IGtQ(n, C0))));
            IIntegrate(4794, Int(Times(Power(ArcCos(Times(c_DEFAULT, x_)), n_DEFAULT), $p("§rfx")), x_Symbol),
                    Condition(With(List(Set(u, ExpandIntegrand(Power(ArcCos(Times(c, x)), n), $s("§rfx"), x))), Condition(Int(u, x), SumQ(u))), And(FreeQ(c, x), RationalFunctionQ($s("§rfx"), x), IGtQ(n, C0))));
            IIntegrate(4795, Int(Times(Power(Plus(Times(ArcSin(Times(c_DEFAULT, x_)), b_DEFAULT), a_), n_DEFAULT), $p("§rfx")), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times($s("§rfx"), Power(Plus(a, Times(b, ArcSin(Times(c, x)))), n)), x), x), And(FreeQ(List(a, b, c), x), RationalFunctionQ($s("§rfx"), x), IGtQ(n, C0))));
            IIntegrate(4796, Int(Times(Power(Plus(Times(ArcCos(Times(c_DEFAULT, x_)), b_DEFAULT), a_), n_DEFAULT), $p("§rfx")), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times($s("§rfx"), Power(Plus(a, Times(b, ArcCos(Times(c, x)))), n)), x), x), And(FreeQ(List(a, b, c), x), RationalFunctionQ($s("§rfx"), x), IGtQ(n, C0))));
            IIntegrate(4797, Int(Times(Power(ArcSin(Times(c_DEFAULT, x_)), n_DEFAULT), $p("§rfx"), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(With(List(Set(u, ExpandIntegrand(Times(Power(Plus(d, Times(e, Sqr(x))), p), Power(ArcSin(Times(c, x)), n)), $s("§rfx"), x))), Condition(Int(u, x), SumQ(u))), And(FreeQ(List(c, d, e), x), RationalFunctionQ($s("§rfx"), x), IGtQ(n, C0), EqQ(Plus(Times(Sqr(c), d), e), C0), IntegerQ(Subtract(p, C1D2)))));
            IIntegrate(4798, Int(Times(Power(ArcCos(Times(c_DEFAULT, x_)), n_DEFAULT), $p("§rfx"), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(With(List(Set(u, ExpandIntegrand(Times(Power(Plus(d, Times(e, Sqr(x))), p), Power(ArcCos(Times(c, x)), n)), $s("§rfx"), x))), Condition(Int(u, x), SumQ(u))), And(FreeQ(List(c, d, e), x), RationalFunctionQ($s("§rfx"), x), IGtQ(n, C0), EqQ(Plus(Times(Sqr(c), d), e), C0), IntegerQ(Subtract(p, C1D2)))));
            IIntegrate(4799, Int(Times(Power(Plus(Times(ArcSin(Times(c_DEFAULT, x_)), b_DEFAULT), a_), n_DEFAULT), $p("§rfx"), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(d, Times(e, Sqr(x))), p), Times($s("§rfx"), Power(Plus(a, Times(b, ArcSin(Times(c, x)))), n)), x), x), And(FreeQ(List(a, b, c, d, e), x), RationalFunctionQ($s("§rfx"), x), IGtQ(n, C0), EqQ(Plus(Times(Sqr(c), d), e), C0), IntegerQ(Subtract(p, C1D2)))));
            IIntegrate(4800, Int(Times(Power(Plus(Times(ArcCos(Times(c_DEFAULT, x_)), b_DEFAULT), a_), n_DEFAULT), $p("§rfx"), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(d, Times(e, Sqr(x))), p), Times($s("§rfx"), Power(Plus(a, Times(b, ArcCos(Times(c, x)))), n)), x), x), And(FreeQ(List(a, b, c, d, e), x), RationalFunctionQ($s("§rfx"), x), IGtQ(n, C0), EqQ(Plus(Times(Sqr(c), d), e), C0), IntegerQ(Subtract(p, C1D2)))));
        }
    }
}
