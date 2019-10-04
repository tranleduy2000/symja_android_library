package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.D;
import static org.matheclipse.core.expression.F.FSymbol;
import static org.matheclipse.core.expression.F.F_;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.MatchQ;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Part;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.PolyLog;
import static org.matheclipse.core.expression.F.PolynomialQ;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Simplify;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.With;
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
import static org.matheclipse.core.expression.F.g_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.r;
import static org.matheclipse.core.expression.F.r_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialDegree;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FalseQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntHide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InverseFunctionFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ProductQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.QuadraticMatchQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.QuadraticQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalFunctionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SubstForFractionalPowerOfLinear;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumQ;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules101 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(2526, Int(Times(Log(Times(c_DEFAULT, Power($p("§rfx"), n_DEFAULT))), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Power(Plus(d, Times(e, Sqr(x))), CN1), x))), Subtract(Simp(Times(u, Log(Times(c, Power($s("§rfx"), n)))), x), Dist(n, Int(SimplifyIntegrand(Times(u, D($s("§rfx"), x), Power($s("§rfx"), CN1)), x), x), x))), And(FreeQ(List(c, d, e, n), x), RationalFunctionQ($s("§rfx"), x), Not(PolynomialQ($s("§rfx"), x)))));
            IIntegrate(2527, Int(Times(Log(Times(c_DEFAULT, Power($p("§px"), n_DEFAULT))), Power($p("§qx"), CN1)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Power($s("§qx"), CN1), x))), Subtract(Simp(Times(u, Log(Times(c, Power($s("§px"), n)))), x), Dist(n, Int(SimplifyIntegrand(Times(u, D($s("§px"), x), Power($s("§px"), CN1)), x), x), x))), And(FreeQ(List(c, n), x), QuadraticQ(List($s("§qx"), $s("§px")), x), EqQ(D(Times($s("§px"), Power($s("§qx"), CN1)), x), C0))));
            IIntegrate(2528, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power($p("§rfx"), p_DEFAULT))), b_DEFAULT)), n_DEFAULT), $p("§rgx")), x_Symbol),
                    Condition(With(List(Set(u, ExpandIntegrand(Power(Plus(a, Times(b, Log(Times(c, Power($s("§rfx"), p))))), n), $s("§rgx"), x))), Condition(Int(u, x), SumQ(u))), And(FreeQ(List(a, b, c, p), x), RationalFunctionQ($s("§rfx"), x), RationalFunctionQ($s("§rgx"), x), IGtQ(n, C0))));
            IIntegrate(2529, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power($p("§rfx"), p_DEFAULT))), b_DEFAULT)), n_DEFAULT), $p("§rgx")), x_Symbol),
                    Condition(With(List(Set(u, ExpandIntegrand(Times($s("§rgx"), Power(Plus(a, Times(b, Log(Times(c, Power($s("§rfx"), p))))), n)), x))), Condition(Int(u, x), SumQ(u))), And(FreeQ(List(a, b, c, p), x), RationalFunctionQ($s("§rfx"), x), RationalFunctionQ($s("§rgx"), x), IGtQ(n, C0))));
            IIntegrate(2530, Int(Times(Plus(a_DEFAULT, Times(Log(u_), b_DEFAULT)), $p("§rfx")), x_Symbol),
                    Condition(With(List(Set($s("lst"), SubstForFractionalPowerOfLinear(Times($s("§rfx"), Plus(a, Times(b, Log(u)))), x))), Condition(Dist(Times(Part($s("lst"), C2), Part($s("lst"), C4)), Subst(Int(Part($s("lst"), C1), x), x, Power(Part($s("lst"), C3), Power(Part($s("lst"), C2), CN1))), x), Not(FalseQ($s("lst"))))), And(FreeQ(List(a, b), x), RationalFunctionQ($s("§rfx"), x))));
            IIntegrate(2531, Int(Times(Log(Plus(C1, Times(e_DEFAULT, Power(Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), n_DEFAULT)))), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(f, Times(g, x)), m), PolyLog(C2, Times(CN1, e, Power(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), n))), Power(Times(b, c, n, Log(FSymbol)), CN1)), x)), Dist(Times(g, m, Power(Times(b, c, n, Log(FSymbol)), CN1)), Int(Times(Power(Plus(f, Times(g, x)), Subtract(m, C1)), PolyLog(C2, Times(CN1, e, Power(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), n)))), x), x)), And(FreeQ(List(FSymbol, a, b, c, e, f, g, n), x), GtQ(m, C0))));
            IIntegrate(2532, Int(Times(Log(Plus(d_, Times(e_DEFAULT, Power(Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), n_DEFAULT)))), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(f, Times(g, x)), Plus(m, C1)), Log(Plus(d, Times(e, Power(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), n)))), Power(Times(g, Plus(m, C1)), CN1)), x), Int(Times(Power(Plus(f, Times(g, x)), m), Log(Plus(C1, Times(e, Power(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), n), Power(d, CN1))))), x), Negate(Simp(Times(Power(Plus(f, Times(g, x)), Plus(m, C1)), Log(Plus(C1, Times(e, Power(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), n), Power(d, CN1)))), Power(Times(g, Plus(m, C1)), CN1)), x))), And(FreeQ(List(FSymbol, a, b, c, d, e, f, g, n), x), GtQ(m, C0), NeQ(d, C1))));
            IIntegrate(2533, Int(Log(Plus(d_DEFAULT, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqrt(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))))))), x_Symbol),
                    Condition(Plus(Simp(Times(x, Log(Plus(d, Times(e, x), Times(f, Sqrt(Plus(a, Times(b, x), Times(c, Sqr(x)))))))), x), Dist(Times(C1D2, Sqr(f), Subtract(Sqr(b), Times(C4, a, c))), Int(Times(x, Power(Subtract(Times(Subtract(Times(C2, d, e), Times(b, Sqr(f))), Plus(a, Times(b, x), Times(c, Sqr(x)))), Times(f, Plus(Times(b, d), Times(CN1, C2, a, e), Times(Subtract(Times(C2, c, d), Times(b, e)), x)), Sqrt(Plus(a, Times(b, x), Times(c, Sqr(x)))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), EqQ(Subtract(Sqr(e), Times(c, Sqr(f))), C0))));
            IIntegrate(2534, Int(Log(Plus(d_DEFAULT, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqrt(Plus(a_DEFAULT, Times(c_DEFAULT, Sqr(x_))))))), x_Symbol),
                    Condition(Subtract(Simp(Times(x, Log(Plus(d, Times(e, x), Times(f, Sqrt(Plus(a, Times(c, Sqr(x)))))))), x), Dist(Times(a, c, Sqr(f)), Int(Times(x, Power(Plus(Times(d, e, Plus(a, Times(c, Sqr(x)))), Times(f, Subtract(Times(a, e), Times(c, d, x)), Sqrt(Plus(a, Times(c, Sqr(x)))))), CN1)), x), x)), And(FreeQ(List(a, c, d, e, f), x), EqQ(Subtract(Sqr(e), Times(c, Sqr(f))), C0))));
            IIntegrate(2535, Int(Times(Log(Plus(d_DEFAULT, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqrt(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))))))), Power(Times(g_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(g, x), Plus(m, C1)), Log(Plus(d, Times(e, x), Times(f, Sqrt(Plus(a, Times(b, x), Times(c, Sqr(x))))))), Power(Times(g, Plus(m, C1)), CN1)), x), Dist(Times(Sqr(f), Subtract(Sqr(b), Times(C4, a, c)), Power(Times(C2, g, Plus(m, C1)), CN1)), Int(Times(Power(Times(g, x), Plus(m, C1)), Power(Subtract(Times(Subtract(Times(C2, d, e), Times(b, Sqr(f))), Plus(a, Times(b, x), Times(c, Sqr(x)))), Times(f, Plus(Times(b, d), Times(CN1, C2, a, e), Times(Subtract(Times(C2, c, d), Times(b, e)), x)), Sqrt(Plus(a, Times(b, x), Times(c, Sqr(x)))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, m), x), EqQ(Subtract(Sqr(e), Times(c, Sqr(f))), C0), NeQ(m, CN1), IntegerQ(Times(C2, m)))));
            IIntegrate(2536, Int(Times(Log(Plus(d_DEFAULT, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqrt(Plus(a_DEFAULT, Times(c_DEFAULT, Sqr(x_))))))), Power(Times(g_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(g, x), Plus(m, C1)), Log(Plus(d, Times(e, x), Times(f, Sqrt(Plus(a, Times(c, Sqr(x))))))), Power(Times(g, Plus(m, C1)), CN1)), x), Dist(Times(a, c, Sqr(f), Power(Times(g, Plus(m, C1)), CN1)), Int(Times(Power(Times(g, x), Plus(m, C1)), Power(Plus(Times(d, e, Plus(a, Times(c, Sqr(x)))), Times(f, Subtract(Times(a, e), Times(c, d, x)), Sqrt(Plus(a, Times(c, Sqr(x)))))), CN1)), x), x)), And(FreeQ(List(a, c, d, e, f, g, m), x), EqQ(Subtract(Sqr(e), Times(c, Sqr(f))), C0), NeQ(m, CN1), IntegerQ(Times(C2, m)))));
            IIntegrate(2537, Int(Times(Log(Plus(d_DEFAULT, Times(f_DEFAULT, Sqrt(u_)), Times(e_DEFAULT, x_))), v_DEFAULT), x_Symbol),
                    Condition(Int(Times(v, Log(Plus(d, Times(e, x), Times(f, Sqrt(ExpandToSum(u, x)))))), x), And(FreeQ(List(d, e, f), x), QuadraticQ(u, x), Not(QuadraticMatchQ(u, x)), Or(EqQ(v, C1), MatchQ(v, Condition(Power(Times(g_DEFAULT, x), m_DEFAULT), FreeQ(List(g, m), x)))))));
            IIntegrate(2538, Int(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), r_DEFAULT), Power(x_, CN1), Power(Plus(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), q_), b_DEFAULT), Times(a_DEFAULT, Power(x_, m_DEFAULT))), CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(Log(Plus(Times(a, Power(x, m)), Times(b, Power(Log(Times(c, Power(x, n))), q)))), Power(Times(b, n, q), CN1)), x), Dist(Times(a, m, Power(Times(b, n, q), CN1)), Int(Times(Power(x, Subtract(m, C1)), Power(Plus(Times(a, Power(x, m)), Times(b, Power(Log(Times(c, Power(x, n))), q))), CN1)), x), x)), And(FreeQ(List(a, b, c, m, n, q, r), x), EqQ(r, Subtract(q, C1)))));
            IIntegrate(2539, Int(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), r_DEFAULT), Power(x_, CN1), Power(Plus(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), q_), b_DEFAULT), Times(a_DEFAULT, Power(x_, m_DEFAULT))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Log(Times(c, Power(x, n))), r), Power(x, CN1)), Power(Plus(Times(a, Power(x, m)), Times(b, Power(Log(Times(c, Power(x, n))), q))), p), x), x), And(FreeQ(List(a, b, c, m, n, p, q, r), x), EqQ(r, Subtract(q, C1)), IGtQ(p, C0))));
            IIntegrate(2540, Int(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), r_DEFAULT), Power(x_, CN1), Power(Plus(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), q_), b_DEFAULT), Times(a_DEFAULT, Power(x_, m_DEFAULT))), p_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(Times(a, Power(x, m)), Times(b, Power(Log(Times(c, Power(x, n))), q))), Plus(p, C1)), Power(Times(b, n, q, Plus(p, C1)), CN1)), x), Dist(Times(a, m, Power(Times(b, n, q), CN1)), Int(Times(Power(x, Subtract(m, C1)), Power(Plus(Times(a, Power(x, m)), Times(b, Power(Log(Times(c, Power(x, n))), q))), p)), x), x)), And(FreeQ(List(a, b, c, m, n, p, q, r), x), EqQ(r, Subtract(q, C1)), NeQ(p, CN1))));
            IIntegrate(2541, Int(Times(Power(x_, CN1), Power(Plus(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), q_), b_DEFAULT), Times(a_DEFAULT, Power(x_, m_DEFAULT))), CN1), Plus(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), r_DEFAULT), e_DEFAULT), Times(d_DEFAULT, Power(x_, m_DEFAULT)))), x_Symbol),
                    Condition(Simp(Times(e, Log(Plus(Times(a, Power(x, m)), Times(b, Power(Log(Times(c, Power(x, n))), q)))), Power(Times(b, n, q), CN1)), x), And(FreeQ(List(a, b, c, d, e, m, n, q, r), x), EqQ(r, Subtract(q, C1)), EqQ(Subtract(Times(a, e, m), Times(b, d, n, q)), C0))));
            IIntegrate(2542, Int(Times(Power(x_, CN1), Power(Plus(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), q_), b_DEFAULT), Times(a_DEFAULT, Power(x_, m_DEFAULT))), CN1), Plus(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), r_DEFAULT), e_DEFAULT), u_, Times(d_DEFAULT, Power(x_, m_DEFAULT)))), x_Symbol),
                    Condition(Plus(Simp(Times(e, Log(Plus(Times(a, Power(x, m)), Times(b, Power(Log(Times(c, Power(x, n))), q)))), Power(Times(b, n, q), CN1)), x), Int(Times(u, Power(Times(x, Plus(Times(a, Power(x, m)), Times(b, Power(Log(Times(c, Power(x, n))), q)))), CN1)), x)), And(FreeQ(List(a, b, c, d, e, m, n, q, r), x), EqQ(r, Subtract(q, C1)), EqQ(Subtract(Times(a, e, m), Times(b, d, n, q)), C0))));
            IIntegrate(2543, Int(Times(Power(x_, CN1), Power(Plus(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), q_), b_DEFAULT), Times(a_DEFAULT, Power(x_, m_DEFAULT))), CN1), Plus(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), r_DEFAULT), e_DEFAULT), Times(d_DEFAULT, Power(x_, m_DEFAULT)))), x_Symbol),
                    Condition(Subtract(Simp(Times(e, Log(Plus(Times(a, Power(x, m)), Times(b, Power(Log(Times(c, Power(x, n))), q)))), Power(Times(b, n, q), CN1)), x), Dist(Times(Subtract(Times(a, e, m), Times(b, d, n, q)), Power(Times(b, n, q), CN1)), Int(Times(Power(x, Subtract(m, C1)), Power(Plus(Times(a, Power(x, m)), Times(b, Power(Log(Times(c, Power(x, n))), q))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, m, n, q, r), x), EqQ(r, Subtract(q, C1)), NeQ(Subtract(Times(a, e, m), Times(b, d, n, q)), C0))));
            IIntegrate(2544, Int(Times(Power(x_, CN1), Power(Plus(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), q_), b_DEFAULT), Times(a_DEFAULT, Power(x_, m_DEFAULT))), p_DEFAULT), Plus(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), r_DEFAULT), e_DEFAULT), Times(d_DEFAULT, Power(x_, m_DEFAULT)))), x_Symbol),
                    Condition(Simp(Times(e, Power(Plus(Times(a, Power(x, m)), Times(b, Power(Log(Times(c, Power(x, n))), q))), Plus(p, C1)), Power(Times(b, n, q, Plus(p, C1)), CN1)), x), And(FreeQ(List(a, b, c, d, e, m, n, p, q, r), x), EqQ(r, Subtract(q, C1)), NeQ(p, CN1), EqQ(Subtract(Times(a, e, m), Times(b, d, n, q)), C0))));
            IIntegrate(2545, Int(Times(Power(x_, CN1), Power(Plus(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), q_), b_DEFAULT), Times(a_DEFAULT, Power(x_, m_DEFAULT))), p_DEFAULT), Plus(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), r_DEFAULT), e_DEFAULT), Times(d_DEFAULT, Power(x_, m_DEFAULT)))), x_Symbol),
                    Condition(Subtract(Simp(Times(e, Power(Plus(Times(a, Power(x, m)), Times(b, Power(Log(Times(c, Power(x, n))), q))), Plus(p, C1)), Power(Times(b, n, q, Plus(p, C1)), CN1)), x), Dist(Times(Subtract(Times(a, e, m), Times(b, d, n, q)), Power(Times(b, n, q), CN1)), Int(Times(Power(x, Subtract(m, C1)), Power(Plus(Times(a, Power(x, m)), Times(b, Power(Log(Times(c, Power(x, n))), q))), p)), x), x)), And(FreeQ(List(a, b, c, d, e, m, n, p, q, r), x), EqQ(r, Subtract(q, C1)), NeQ(p, CN1), NeQ(Subtract(Times(a, e, m), Times(b, d, n, q)), C0))));
            IIntegrate(2546, Int(Times(Power(x_, CN1), Power(Plus(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), q_), b_DEFAULT), Times(a_DEFAULT, Power(x_, m_DEFAULT))), CN2), Plus(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), q_DEFAULT), f_DEFAULT), Times(d_DEFAULT, Power(x_, m_DEFAULT)), Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), e_DEFAULT, Power(x_, m_DEFAULT)))), x_Symbol),
                    Condition(Simp(Times(d, Log(Times(c, Power(x, n))), Power(Times(a, n, Plus(Times(a, Power(x, m)), Times(b, Power(Log(Times(c, Power(x, n))), q)))), CN1)), x), And(FreeQ(List(a, b, c, d, e, f, m, n, q), x), EqQ(Plus(Times(e, n), Times(d, m)), C0), EqQ(Plus(Times(a, f), Times(b, d, Subtract(q, C1))), C0))));
            IIntegrate(2547, Int(Times(Plus(Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), e_DEFAULT), d_), Power(Plus(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), q_), b_DEFAULT), Times(a_DEFAULT, x_)), CN2)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(e, Log(Times(c, Power(x, n))), Power(Times(a, Plus(Times(a, x), Times(b, Power(Log(Times(c, Power(x, n))), q)))), CN1)), x)), Dist(Times(Plus(d, Times(e, n)), Power(a, CN1)), Int(Power(Times(x, Plus(Times(a, x), Times(b, Power(Log(Times(c, Power(x, n))), q)))), CN1), x), x)), And(FreeQ(List(a, b, c, d, e, n, q), x), EqQ(Plus(d, Times(e, n, q)), C0))));
            IIntegrate(2548, Int(Log(u_), x_Symbol),
                    Condition(Subtract(Simp(Times(x, Log(u)), x), Int(SimplifyIntegrand(Times(x, D(u, x), Power(u, CN1)), x), x)), InverseFunctionFreeQ(u, x)));
            IIntegrate(2549, Int(Log(u_), x_Symbol),
                    Condition(Subtract(Simp(Times(x, Log(u)), x), Int(SimplifyIntegrand(Times(x, Simplify(Times(D(u, x), Power(u, CN1)))), x), x)), ProductQ(u)));
            IIntegrate(2550, Int(Times(Log(u_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(Log(Plus(a, Times(b, x))), Log(u), Power(b, CN1)), x), Dist(Power(b, CN1), Int(SimplifyIntegrand(Times(Log(Plus(a, Times(b, x))), D(u, x), Power(u, CN1)), x), x), x)), And(FreeQ(List(a, b), x), RationalFunctionQ(Times(D(u, x), Power(u, CN1)), x), Or(NeQ(a, C0), Not(And(BinomialQ(u, x), EqQ(Sqr(BinomialDegree(u, x)), C1)))))));
        }
    }
}
