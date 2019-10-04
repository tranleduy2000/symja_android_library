package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.ASymbol;
import static org.matheclipse.core.expression.F.A_DEFAULT;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.BSymbol;
import static org.matheclipse.core.expression.F.B_DEFAULT;
import static org.matheclipse.core.expression.F.C;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C5;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.C_DEFAULT;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.PolynomialQuotient;
import static org.matheclipse.core.expression.F.PolynomialRemainder;
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
import static org.matheclipse.core.expression.F.g_DEFAULT;
import static org.matheclipse.core.expression.F.h;
import static org.matheclipse.core.expression.F.h_DEFAULT;
import static org.matheclipse.core.expression.F.k;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Coeff;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Expon;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PolyQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules64 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(1601, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), CN1D2), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), CN1D2), Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), CN1D2), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr(x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(C2, C, Power(Plus(a, Times(b, x)), m), Sqrt(Plus(c, Times(d, x))), Sqrt(Plus(e, Times(f, x))), Sqrt(Plus(g, Times(h, x))), Power(Times(d, f, h, Plus(Times(C2, m), C3)), CN1)), x), Dist(Power(Times(d, f, h, Plus(Times(C2, m), C3)), CN1), Int(Times(Power(Plus(a, Times(b, x)), Subtract(m, C1)), Power(Times(Sqrt(Plus(c, Times(d, x))), Sqrt(Plus(e, Times(f, x))), Sqrt(Plus(g, Times(h, x)))), CN1), Simp(Plus(Times(a, ASymbol, d, f, h, Plus(Times(C2, m), C3)), Times(CN1, C, Plus(Times(a, Plus(Times(d, e, g), Times(c, f, g), Times(c, e, h))), Times(C2, b, c, e, g, m))), Times(Subtract(Times(ASymbol, b, d, f, h, Plus(Times(C2, m), C3)), Times(C, Plus(Times(C2, a, Plus(Times(d, f, g), Times(d, e, h), Times(c, f, h))), Times(b, Plus(Times(C2, m), C1), Plus(Times(d, e, g), Times(c, f, g), Times(c, e, h)))))), x), Times(C2, C, Subtract(Times(a, d, f, h, m), Times(b, Plus(m, C1), Plus(Times(d, f, g), Times(d, e, h), Times(c, f, h)))), Sqr(x))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, h, ASymbol, C), x), IntegerQ(Times(C2, m)), GtQ(m, C0))));
            IIntegrate(1602, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), CN1D2), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), CN1D2), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), CN1D2), Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), CN1D2), Plus(A_DEFAULT, Times(B_DEFAULT, x_), Times(C_DEFAULT, Sqr(x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(C, Sqrt(Plus(a, Times(b, x))), Sqrt(Plus(e, Times(f, x))), Sqrt(Plus(g, Times(h, x))), Power(Times(b, f, h, Sqrt(Plus(c, Times(d, x)))), CN1)), x), Dist(Power(Times(C2, b, d, f, h), CN1), Int(Times(C1, Simp(Plus(Times(C2, ASymbol, b, d, f, h), Times(CN1, C, Plus(Times(b, d, e, g), Times(a, c, f, h))), Times(Subtract(Times(C2, b, BSymbol, d, f, h), Times(C, Plus(Times(a, d, f, h), Times(b, Plus(Times(d, f, g), Times(d, e, h), Times(c, f, h)))))), x)), x), Power(Times(Sqrt(Plus(a, Times(b, x))), Sqrt(Plus(c, Times(d, x))), Sqrt(Plus(e, Times(f, x))), Sqrt(Plus(g, Times(h, x)))), CN1)), x), x), Dist(Times(C, Subtract(Times(d, e), Times(c, f)), Subtract(Times(d, g), Times(c, h)), Power(Times(C2, b, d, f, h), CN1)), Int(Times(Sqrt(Plus(a, Times(b, x))), Power(Times(Power(Plus(c, Times(d, x)), QQ(3L, 2L)), Sqrt(Plus(e, Times(f, x))), Sqrt(Plus(g, Times(h, x)))), CN1)), x), x)), FreeQ(List(a, b, c, d, e, f, g, h, ASymbol, BSymbol, C), x)));
            IIntegrate(1603, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), CN1D2), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), CN1D2), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), CN1D2), Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), CN1D2), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr(x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(C, Sqrt(Plus(a, Times(b, x))), Sqrt(Plus(e, Times(f, x))), Sqrt(Plus(g, Times(h, x))), Power(Times(b, f, h, Sqrt(Plus(c, Times(d, x)))), CN1)), x), Dist(Power(Times(C2, b, d, f, h), CN1), Int(Times(C1, Simp(Subtract(Subtract(Times(C2, ASymbol, b, d, f, h), Times(C, Plus(Times(b, d, e, g), Times(a, c, f, h)))), Times(C, Plus(Times(a, d, f, h), Times(b, Plus(Times(d, f, g), Times(d, e, h), Times(c, f, h)))), x)), x), Power(Times(Sqrt(Plus(a, Times(b, x))), Sqrt(Plus(c, Times(d, x))), Sqrt(Plus(e, Times(f, x))), Sqrt(Plus(g, Times(h, x)))), CN1)), x), x), Dist(Times(C, Subtract(Times(d, e), Times(c, f)), Subtract(Times(d, g), Times(c, h)), Power(Times(C2, b, d, f, h), CN1)), Int(Times(Sqrt(Plus(a, Times(b, x))), Power(Times(Power(Plus(c, Times(d, x)), QQ(3L, 2L)), Sqrt(Plus(e, Times(f, x))), Sqrt(Plus(g, Times(h, x)))), CN1)), x), x)), FreeQ(List(a, b, c, d, e, f, g, h, ASymbol, C), x)));
            IIntegrate(1604, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), CN1D2), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), CN1D2), Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), CN1D2), Plus(A_DEFAULT, Times(B_DEFAULT, x_), Times(C_DEFAULT, Sqr(x_)))), x_Symbol),
                    Condition(Subtract(Simp(Times(Plus(Times(ASymbol, Sqr(b)), Times(CN1, a, b, BSymbol), Times(Sqr(a), C)), Power(Plus(a, Times(b, x)), Plus(m, C1)), Sqrt(Plus(c, Times(d, x))), Sqrt(Plus(e, Times(f, x))), Sqrt(Plus(g, Times(h, x))), Power(Times(Plus(m, C1), Subtract(Times(b, c), Times(a, d)), Subtract(Times(b, e), Times(a, f)), Subtract(Times(b, g), Times(a, h))), CN1)), x), Dist(Power(Times(C2, Plus(m, C1), Subtract(Times(b, c), Times(a, d)), Subtract(Times(b, e), Times(a, f)), Subtract(Times(b, g), Times(a, h))), CN1), Int(Times(Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Times(Sqrt(Plus(c, Times(d, x))), Sqrt(Plus(e, Times(f, x))), Sqrt(Plus(g, Times(h, x)))), CN1), Simp(Plus(Times(ASymbol, Plus(Times(C2, Sqr(a), d, f, h, Plus(m, C1)), Times(CN1, C2, a, b, Plus(m, C1), Plus(Times(d, f, g), Times(d, e, h), Times(c, f, h))), Times(Sqr(b), Plus(Times(C2, m), C3), Plus(Times(d, e, g), Times(c, f, g), Times(c, e, h))))), Times(CN1, Subtract(Times(b, BSymbol), Times(a, C)), Plus(Times(a, Plus(Times(d, e, g), Times(c, f, g), Times(c, e, h))), Times(C2, b, c, e, g, Plus(m, C1)))), Times(CN1, C2, Subtract(Times(Subtract(Times(ASymbol, b), Times(a, BSymbol)), Subtract(Times(a, d, f, h, Plus(m, C1)), Times(b, Plus(m, C2), Plus(Times(d, f, g), Times(d, e, h), Times(c, f, h))))), Times(C, Plus(Times(Sqr(a), Plus(Times(d, f, g), Times(d, e, h), Times(c, f, h))), Times(CN1, Sqr(b), c, e, g, Plus(m, C1)), Times(a, b, Plus(m, C1), Plus(Times(d, e, g), Times(c, f, g), Times(c, e, h)))))), x), Times(d, f, h, Plus(Times(C2, m), C5), Plus(Times(ASymbol, Sqr(b)), Times(CN1, a, b, BSymbol), Times(Sqr(a), C)), Sqr(x))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, h, ASymbol, BSymbol, C), x), IntegerQ(Times(C2, m)), LtQ(m, CN1))));
            IIntegrate(1605, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), CN1D2), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), CN1D2), Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), CN1D2), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr(x_)))), x_Symbol),
                    Condition(Subtract(Simp(Times(Plus(Times(ASymbol, Sqr(b)), Times(Sqr(a), C)), Power(Plus(a, Times(b, x)), Plus(m, C1)), Sqrt(Plus(c, Times(d, x))), Sqrt(Plus(e, Times(f, x))), Sqrt(Plus(g, Times(h, x))), Power(Times(Plus(m, C1), Subtract(Times(b, c), Times(a, d)), Subtract(Times(b, e), Times(a, f)), Subtract(Times(b, g), Times(a, h))), CN1)), x), Dist(Power(Times(C2, Plus(m, C1), Subtract(Times(b, c), Times(a, d)), Subtract(Times(b, e), Times(a, f)), Subtract(Times(b, g), Times(a, h))), CN1), Int(Times(Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Times(Sqrt(Plus(c, Times(d, x))), Sqrt(Plus(e, Times(f, x))), Sqrt(Plus(g, Times(h, x)))), CN1), Simp(Plus(Times(ASymbol, Plus(Times(C2, Sqr(a), d, f, h, Plus(m, C1)), Times(CN1, C2, a, b, Plus(m, C1), Plus(Times(d, f, g), Times(d, e, h), Times(c, f, h))), Times(Sqr(b), Plus(Times(C2, m), C3), Plus(Times(d, e, g), Times(c, f, g), Times(c, e, h))))), Times(a, C, Plus(Times(a, Plus(Times(d, e, g), Times(c, f, g), Times(c, e, h))), Times(C2, b, c, e, g, Plus(m, C1)))), Times(CN1, C2, Subtract(Times(ASymbol, b, Subtract(Times(a, d, f, h, Plus(m, C1)), Times(b, Plus(m, C2), Plus(Times(d, f, g), Times(d, e, h), Times(c, f, h))))), Times(C, Plus(Times(Sqr(a), Plus(Times(d, f, g), Times(d, e, h), Times(c, f, h))), Times(CN1, Sqr(b), c, e, g, Plus(m, C1)), Times(a, b, Plus(m, C1), Plus(Times(d, e, g), Times(c, f, g), Times(c, e, h)))))), x), Times(d, f, h, Plus(Times(C2, m), C5), Plus(Times(ASymbol, Sqr(b)), Times(Sqr(a), C)), Sqr(x))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, h, ASymbol, C), x), IntegerQ(Times(C2, m)), LtQ(m, CN1))));
            IIntegrate(1606, Int(Times($p("§px"), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_DEFAULT), Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), q_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times($s("§px"), Power(Plus(a, Times(b, x)), m), Power(Plus(c, Times(d, x)), n), Power(Plus(e, Times(f, x)), p), Power(Plus(g, Times(h, x)), q)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, h, m, n, p, q), x), PolyQ($s("§px"), x), IntegersQ(m, n))));
            IIntegrate(1607, Int(Times($p("§px"), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_DEFAULT), Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), q_DEFAULT)), x_Symbol),
                    Condition(Plus(Dist(PolynomialRemainder($s("§px"), Plus(a, Times(b, x)), x), Int(Times(Power(Plus(a, Times(b, x)), m), Power(Plus(c, Times(d, x)), n), Power(Plus(e, Times(f, x)), p), Power(Plus(g, Times(h, x)), q)), x), x), Int(Times(PolynomialQuotient($s("§px"), Plus(a, Times(b, x)), x), Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), n), Power(Plus(e, Times(f, x)), p), Power(Plus(g, Times(h, x)), q)), x)), And(FreeQ(List(a, b, c, d, e, f, g, h, m, n, p, q), x), PolyQ($s("§px"), x), EqQ(m, CN1))));
            IIntegrate(1608, Int(Times($p("§px"), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_DEFAULT), Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), q_DEFAULT)), x_Symbol),
                    Condition(Plus(Dist(PolynomialRemainder($s("§px"), Plus(a, Times(b, x)), x), Int(Times(Power(Plus(a, Times(b, x)), m), Power(Plus(c, Times(d, x)), n), Power(Plus(e, Times(f, x)), p), Power(Plus(g, Times(h, x)), q)), x), x), Int(Times(PolynomialQuotient($s("§px"), Plus(a, Times(b, x)), x), Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), n), Power(Plus(e, Times(f, x)), p), Power(Plus(g, Times(h, x)), q)), x)), And(FreeQ(List(a, b, c, d, e, f, g, h, m, n, p, q), x), PolyQ($s("§px"), x))));
            IIntegrate(1609, Int(Times($p("§px"), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times($s("§px"), Power(Plus(Times(a, c), Times(b, d, Sqr(x))), m), Power(Plus(e, Times(f, x)), p)), x), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), PolyQ($s("§px"), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(m, n), Or(IntegerQ(m), And(GtQ(a, C0), GtQ(c, C0))))));
            IIntegrate(1610, Int(Times($p("§px"), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, x)), FracPart(m)), Power(Plus(c, Times(d, x)), FracPart(m)), Power(Power(Plus(Times(a, c), Times(b, d, Sqr(x))), FracPart(m)), CN1)), Int(Times($s("§px"), Power(Plus(Times(a, c), Times(b, d, Sqr(x))), m), Power(Plus(e, Times(f, x)), p)), x), x), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), PolyQ($s("§px"), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(m, n), Not(IntegerQ(m)))));
            IIntegrate(1611, Int(Times($p("§px"), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(PolynomialQuotient($s("§px"), Plus(a, Times(b, x)), x), Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), n), Power(Plus(e, Times(f, x)), p)), x), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), PolyQ($s("§px"), x), EqQ(PolynomialRemainder($s("§px"), Plus(a, Times(b, x)), x), C0))));
            IIntegrate(1612, Int(Times($p("§px"), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times($s("§px"), Power(Plus(a, Times(b, x)), m), Power(Plus(c, Times(d, x)), n), Power(Plus(e, Times(f, x)), p)), x), x), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), PolyQ($s("§px"), x), IntegersQ(m, n))));
            IIntegrate(1613, Int(Times($p("§px"), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set($s("§qx"), PolynomialQuotient($s("§px"), Plus(a, Times(b, x)), x)), Set($s("R"), PolynomialRemainder($s("§px"), Plus(a, Times(b, x)), x))), Plus(Simp(Times(b, $s("R"), Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), Plus(n, C1)), Power(Plus(e, Times(f, x)), Plus(p, C1)), Power(Times(Plus(m, C1), Subtract(Times(b, c), Times(a, d)), Subtract(Times(b, e), Times(a, f))), CN1)), x), Dist(Power(Times(Plus(m, C1), Subtract(Times(b, c), Times(a, d)), Subtract(Times(b, e), Times(a, f))), CN1), Int(Times(Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), n), Power(Plus(e, Times(f, x)), p), ExpandToSum(Subtract(Subtract(Plus(Times(Plus(m, C1), Subtract(Times(b, c), Times(a, d)), Subtract(Times(b, e), Times(a, f)), $s("§qx")), Times(a, d, f, $s("R"), Plus(m, C1))), Times(b, $s("R"), Plus(Times(d, e, Plus(m, n, C2)), Times(c, f, Plus(m, p, C2))))), Times(b, d, f, $s("R"), Plus(m, n, p, C3), x)), x)), x), x))), And(FreeQ(List(a, b, c, d, e, f, n, p), x), PolyQ($s("§px"), x), ILtQ(m, CN1), IntegersQ(Times(C2, m), Times(C2, n), Times(C2, p)))));
            IIntegrate(1614, Int(Times($p("§px"), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set($s("§qx"), PolynomialQuotient($s("§px"), Plus(a, Times(b, x)), x)), Set($s("R"), PolynomialRemainder($s("§px"), Plus(a, Times(b, x)), x))), Plus(Simp(Times(b, $s("R"), Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), Plus(n, C1)), Power(Plus(e, Times(f, x)), Plus(p, C1)), Power(Times(Plus(m, C1), Subtract(Times(b, c), Times(a, d)), Subtract(Times(b, e), Times(a, f))), CN1)), x), Dist(Power(Times(Plus(m, C1), Subtract(Times(b, c), Times(a, d)), Subtract(Times(b, e), Times(a, f))), CN1), Int(Times(Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), n), Power(Plus(e, Times(f, x)), p), ExpandToSum(Subtract(Subtract(Plus(Times(Plus(m, C1), Subtract(Times(b, c), Times(a, d)), Subtract(Times(b, e), Times(a, f)), $s("§qx")), Times(a, d, f, $s("R"), Plus(m, C1))), Times(b, $s("R"), Plus(Times(d, e, Plus(m, n, C2)), Times(c, f, Plus(m, p, C2))))), Times(b, d, f, $s("R"), Plus(m, n, p, C3), x)), x)), x), x))), And(FreeQ(List(a, b, c, d, e, f, n, p), x), PolyQ($s("§px"), x), LtQ(m, CN1), IntegersQ(Times(C2, m), Times(C2, n), Times(C2, p)))));
            IIntegrate(1615, Int(Times($p("§px"), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(q, Expon($s("§px"), x)), Set(k, Coeff($s("§px"), x, Expon($s("§px"), x)))), Condition(Plus(Simp(Times(k, Power(Plus(a, Times(b, x)), Subtract(Plus(m, q), C1)), Power(Plus(c, Times(d, x)), Plus(n, C1)), Power(Plus(e, Times(f, x)), Plus(p, C1)), Power(Times(d, f, Power(b, Subtract(q, C1)), Plus(m, n, p, q, C1)), CN1)), x), Dist(Power(Times(d, f, Power(b, q), Plus(m, n, p, q, C1)), CN1), Int(Times(Power(Plus(a, Times(b, x)), m), Power(Plus(c, Times(d, x)), n), Power(Plus(e, Times(f, x)), p), ExpandToSum(Plus(Times(d, f, Power(b, q), Plus(m, n, p, q, C1), $s("§px")), Times(CN1, d, f, k, Plus(m, n, p, q, C1), Power(Plus(a, Times(b, x)), q)), Times(k, Power(Plus(a, Times(b, x)), Subtract(q, C2)), Plus(Times(Sqr(a), d, f, Plus(m, n, p, q, C1)), Times(CN1, b, Plus(Times(b, c, e, Subtract(Plus(m, q), C1)), Times(a, Plus(Times(d, e, Plus(n, C1)), Times(c, f, Plus(p, C1)))))), Times(b, Subtract(Times(a, d, f, Plus(Times(C2, Plus(m, q)), n, p)), Times(b, Plus(Times(d, e, Plus(m, q, n)), Times(c, f, Plus(m, q, p))))), x)))), x)), x), x)), NeQ(Plus(m, n, p, q, C1), C0))), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), PolyQ($s("§px"), x), IntegersQ(Times(C2, m), Times(C2, n), Times(C2, p)))));
            IIntegrate(1616, Int(Times($p("§px"), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT)), x_Symbol),
                    Condition(Int(Times($s("§px"), Power(Plus(Times(a, c), Times(b, d, Sqr(x))), m)), x), And(FreeQ(List(a, b, c, d, m, n), x), PolyQ($s("§px"), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(m, n), Or(IntegerQ(m), And(GtQ(a, C0), GtQ(c, C0))))));
            IIntegrate(1617, Int(Times($p("§px"), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, x)), FracPart(m)), Power(Plus(c, Times(d, x)), FracPart(m)), Power(Power(Plus(Times(a, c), Times(b, d, Sqr(x))), FracPart(m)), CN1)), Int(Times($s("§px"), Power(Plus(Times(a, c), Times(b, d, Sqr(x))), m)), x), x), And(FreeQ(List(a, b, c, d, m, n), x), PolyQ($s("§px"), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(m, n), Not(IntegerQ(m)))));
            IIntegrate(1618, Int(Times($p("§px"), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT)), x_Symbol),
                    Condition(Int(Times(PolynomialQuotient($s("§px"), Plus(a, Times(b, x)), x), Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), n)), x), And(FreeQ(List(a, b, c, d, m, n), x), PolyQ($s("§px"), x), EqQ(PolynomialRemainder($s("§px"), Plus(a, Times(b, x)), x), C0))));
            IIntegrate(1619, Int(Times($p("§px"), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), CN1), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(c, Times(d, x)), CN1D2), Times($s("§px"), Power(Plus(c, Times(d, x)), Plus(n, C1D2)), Power(Plus(a, Times(b, x)), CN1)), x), x), And(FreeQ(List(a, b, c, d, n), x), PolyQ($s("§px"), x), ILtQ(Plus(n, C1D2), C0), GtQ(Expon($s("§px"), x), C2))));
            IIntegrate(1620, Int(Times($p("§px"), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times($s("§px"), Power(Plus(a, Times(b, x)), m), Power(Plus(c, Times(d, x)), n)), x), x), And(FreeQ(List(a, b, c, d, m, n), x), PolyQ($s("§px"), x), Or(IntegersQ(m, n), IGtQ(m, CN2)), GtQ(Expon($s("§px"), x), C2))));
            IIntegrate(1621, Int(Times($p("§px"), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT)), x_Symbol),
                    Condition(With(List(Set($s("§qx"), PolynomialQuotient($s("§px"), Plus(a, Times(b, x)), x)), Set($s("R"), PolynomialRemainder($s("§px"), Plus(a, Times(b, x)), x))), Plus(Simp(Times($s("R"), Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), Plus(n, C1)), Power(Times(Plus(m, C1), Subtract(Times(b, c), Times(a, d))), CN1)), x), Dist(Power(Times(Plus(m, C1), Subtract(Times(b, c), Times(a, d))), CN1), Int(Times(Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), n), ExpandToSum(Subtract(Times(Plus(m, C1), Subtract(Times(b, c), Times(a, d)), $s("§qx")), Times(d, $s("R"), Plus(m, n, C2))), x)), x), x))), And(FreeQ(List(a, b, c, d, n), x), PolyQ($s("§px"), x), ILtQ(m, CN1), GtQ(Expon($s("§px"), x), C2))));
            IIntegrate(1622, Int(Times($p("§px"), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT)), x_Symbol),
                    Condition(With(List(Set($s("§qx"), PolynomialQuotient($s("§px"), Plus(a, Times(b, x)), x)), Set($s("R"), PolynomialRemainder($s("§px"), Plus(a, Times(b, x)), x))), Plus(Simp(Times($s("R"), Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), Plus(n, C1)), Power(Times(Plus(m, C1), Subtract(Times(b, c), Times(a, d))), CN1)), x), Dist(Power(Times(Plus(m, C1), Subtract(Times(b, c), Times(a, d))), CN1), Int(Times(Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), n), ExpandToSum(Subtract(Times(Plus(m, C1), Subtract(Times(b, c), Times(a, d)), $s("§qx")), Times(d, $s("R"), Plus(m, n, C2))), x)), x), x))), And(FreeQ(List(a, b, c, d, n), x), PolyQ($s("§px"), x), LtQ(m, CN1), GtQ(Expon($s("§px"), x), C2))));
            IIntegrate(1623, Int(Times($p("§px"), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(q, Expon($s("§px"), x)), Set(k, Coeff($s("§px"), x, Expon($s("§px"), x)))), Condition(Plus(Simp(Times(k, Power(Plus(a, Times(b, x)), Plus(m, q)), Power(Plus(c, Times(d, x)), Plus(n, C1)), Power(Times(d, Power(b, q), Plus(m, n, q, C1)), CN1)), x), Dist(Power(Times(d, Power(b, q), Plus(m, n, q, C1)), CN1), Int(Times(Power(Plus(a, Times(b, x)), m), Power(Plus(c, Times(d, x)), n), ExpandToSum(Subtract(Subtract(Times(d, Power(b, q), Plus(m, n, q, C1), $s("§px")), Times(d, k, Plus(m, n, q, C1), Power(Plus(a, Times(b, x)), q))), Times(k, Subtract(Times(b, c), Times(a, d)), Plus(m, q), Power(Plus(a, Times(b, x)), Subtract(q, C1)))), x)), x), x)), NeQ(Plus(m, n, q, C1), C0))), And(FreeQ(List(a, b, c, d, m, n), x), PolyQ($s("§px"), x), GtQ(Expon($s("§px"), x), C2))));
            IIntegrate(1624, Int(Times($p("§pq"), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), PolynomialQuotient($s("§pq"), Plus(d, Times(e, x)), x), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), And(FreeQ(List(a, b, c, d, e, m, p), x), PolyQ($s("§pq"), x), EqQ(PolynomialRemainder($s("§pq"), Plus(d, Times(e, x)), x), C0))));
            IIntegrate(1625, Int(Times($p("§pq"), Power(Plus(d_, Times(e_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), PolynomialQuotient($s("§pq"), Plus(d, Times(e, x)), x), Power(Plus(a, Times(c, Sqr(x))), p)), x), And(FreeQ(List(a, c, d, e, m, p), x), PolyQ($s("§pq"), x), EqQ(PolynomialRemainder($s("§pq"), Plus(d, Times(e, x)), x), C0))));
        }
    }
}
