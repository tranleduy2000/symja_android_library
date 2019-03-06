package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CSymbol;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.D;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.FSymbol;
import static org.matheclipse.core.expression.F.F_;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.FullSimplify;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.MatchQ;
import static org.matheclipse.core.expression.F.MemberQ;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Part;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.PolyLog;
import static org.matheclipse.core.expression.F.PolynomialQ;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.True;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.a_DEFAULT;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.g_DEFAULT;
import static org.matheclipse.core.expression.F.h;
import static org.matheclipse.core.expression.F.h_;
import static org.matheclipse.core.expression.F.h_DEFAULT;
import static org.matheclipse.core.expression.F.i;
import static org.matheclipse.core.expression.F.i_DEFAULT;
import static org.matheclipse.core.expression.F.j;
import static org.matheclipse.core.expression.F.j_DEFAULT;
import static org.matheclipse.core.expression.F.k;
import static org.matheclipse.core.expression.F.k_;
import static org.matheclipse.core.expression.F.k_DEFAULT;
import static org.matheclipse.core.expression.F.l;
import static org.matheclipse.core.expression.F.l_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.r;
import static org.matheclipse.core.expression.F.r_;
import static org.matheclipse.core.expression.F.r_DEFAULT;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.AlgebraicFunctionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialMatchQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Expon;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.F;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntHide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegralFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InverseFunctionFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearMatchQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PolyQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalFunctionExponents;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalFunctionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;
import static org.matheclipse.core.expression.F.*;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules48 {
    public static IAST RULES = List(
            IIntegrate(2401, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), p_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), q_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(f, Times(g, x)), q), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), p)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, n, p), x), NeQ(Plus(Times(e, f), Times(CN1, d, g)), C0), IGtQ(q, C0)))),
            IIntegrate(2402, Int(Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), -1))), Power(Plus(f_, Times(g_DEFAULT, Sqr(x_))), -1)), x_Symbol),
                    Condition(Negate(Dist(Times(e, Power(g, -1)), Subst(Int(Times(Log(Times(C2, d, x)), Power(Plus(C1, Times(CN1, C2, d, x)), -1)), x), x, Power(Plus(d, Times(e, x)), -1)), x)), And(FreeQ(List(c, d, e, f, g), x), EqQ(c, Times(C2, d)), EqQ(Plus(Times(Sqr(e), f), Times(Sqr(d), g)), C0)))),
            IIntegrate(2403, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), -1))), b_DEFAULT)), Power(Plus(f_, Times(g_DEFAULT, Sqr(x_))), -1)), x_Symbol),
                    Condition(Plus(Dist(Plus(a, Times(b, Log(Times(c, Power(Times(C2, d), -1))))), Int(Power(Plus(f, Times(g, Sqr(x))), -1), x), x), Dist(b, Int(Times(Log(Times(C2, d, Power(Plus(d, Times(e, x)), -1))), Power(Plus(f, Times(g, Sqr(x))), -1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), EqQ(Plus(Times(Sqr(e), f), Times(Sqr(d), g)), C0), GtQ(Times(c, Power(Times(C2, d), -1)), C0)))),
            IIntegrate(2404, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), Power(Plus(f_, Times(g_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Power(Plus(f, Times(g, Sqr(x))), CN1D2), x))), Plus(Simp(Times(u, Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n)))))), x), Negate(Dist(Times(b, e, n), Int(SimplifyIntegrand(Times(u, Power(Plus(d, Times(e, x)), -1)), x), x), x)))), And(FreeQ(List(a, b, c, d, e, f, g, n), x), GtQ(f, C0)))),
            IIntegrate(2405, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), Power(Plus($p("f1"), Times($p("g1", true), x_)), CN1D2), Power(Plus($p("f2"), Times($p("g2", true), x_)), CN1D2)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Power(Plus(Times($s("f1"), $s("f2")), Times($s("g1"), $s("g2"), Sqr(x))), CN1D2), x))), Plus(Simp(Times(u, Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n)))))), x), Negate(Dist(Times(b, e, n), Int(SimplifyIntegrand(Times(u, Power(Plus(d, Times(e, x)), -1)), x), x), x)))), And(FreeQ(List(a, b, c, d, e, $s("f1"), $s("g1"), $s("f2"), $s("g2"), n), x), EqQ(Plus(Times($s("f2"), $s("g1")), Times($s("f1"), $s("g2"))), C0), GtQ($s("f1"), C0), GtQ($s("f2"), C0)))),
            IIntegrate(2406, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), Power(Plus(f_, Times(g_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Plus(C1, Times(g, Sqr(x), Power(f, -1)))), Power(Plus(f, Times(g, Sqr(x))), CN1D2)), Int(Times(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), Power(Plus(C1, Times(g, Sqr(x), Power(f, -1))), CN1D2)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, n), x), Not(GtQ(f, C0))))),
            IIntegrate(2407, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), Power(Plus($p("f1"), Times($p("g1", true), x_)), CN1D2), Power(Plus($p("f2"), Times($p("g2", true), x_)), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Plus(C1, Times($s("g1"), $s("g2"), Sqr(x), Power(Times($s("f1"), $s("f2")), -1)))), Power(Times(Sqrt(Plus($s("f1"), Times($s("g1"), x))), Sqrt(Plus($s("f2"), Times($s("g2"), x)))), -1)), Int(Times(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), Power(Plus(C1, Times($s("g1"), $s("g2"), Sqr(x), Power(Times($s("f1"), $s("f2")), -1))), CN1D2)), x), x), And(FreeQ(List(a, b, c, d, e, $s("f1"), $s("g1"), $s("f2"), $s("g2"), n), x), EqQ(Plus(Times($s("f2"), $s("g1")), Times($s("f1"), $s("g2"))), C0)))),
            IIntegrate(2408, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(Plus(f_DEFAULT, Times(g_DEFAULT, Power(x_, r_))), q_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(k, Denominator(r))), Dist(k, Subst(Int(Times(Power(x, Plus(k, Negate(C1))), Power(Plus(f, Times(g, Power(x, Times(k, r)))), q), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, Power(x, k))), n))))), p)), x), x, Power(x, Power(k, -1))), x)), And(FreeQ(List(a, b, c, d, e, f, g, n, p, q), x), FractionQ(r), IGtQ(p, C0)))),
            IIntegrate(2409, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(Plus(f_, Times(g_DEFAULT, Power(x_, r_))), q_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), p), Power(Plus(f, Times(g, Power(x, r))), q), x), x), And(FreeQ(List(a, b, c, d, e, f, g, n, r), x), IGtQ(p, C0), IntegerQ(q), Or(GtQ(q, C0), And(IntegerQ(r), NeQ(r, C1)))))),
            IIntegrate(2410, Int(Times(Log(Times(c_DEFAULT, Plus(d_, Times(e_DEFAULT, x_)))), Power(x_, m_DEFAULT), Power(Plus(f_, Times(g_DEFAULT, x_)), -1)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Log(Times(c, Plus(d, Times(e, x)))), Times(Power(x, m), Power(Plus(f, Times(g, x)), -1)), x), x), And(FreeQ(List(c, d, e, f, g), x), EqQ(Plus(Times(e, f), Times(CN1, d, g)), C0), EqQ(Times(c, d), C1), IntegerQ(m)))),
            IIntegrate(2411, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), q_DEFAULT), Power(Plus(h_DEFAULT, Times(i_DEFAULT, x_)), r_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(e, -1), Subst(Int(Times(Power(Times(g, x, Power(e, -1)), q), Power(Plus(Times(Plus(Times(e, h), Times(CN1, d, i)), Power(e, -1)), Times(i, x, Power(e, -1))), r), Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), p)), x), x, Plus(d, Times(e, x))), x), And(FreeQ(List(a, b, c, d, e, f, g, h, i, n, p, q, r), x), EqQ(Plus(Times(e, f), Times(CN1, d, g)), C0), Or(IGtQ(p, C0), IGtQ(r, C0)), IntegerQ(Times(C2, r))))),
            IIntegrate(2412, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(Plus(f_, Times(g_DEFAULT, Power(x_, -1))), q_DEFAULT), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Plus(g, Times(f, x)), q), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), p)), x), And(FreeQ(List(a, b, c, d, e, f, g, m, n, p, q), x), EqQ(m, q), IntegerQ(q)))),
            IIntegrate(2413, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(x_, m_DEFAULT), Power(Plus(f_DEFAULT, Times(g_DEFAULT, Power(x_, r_DEFAULT))), q_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(f, Times(g, Power(x, r))), Plus(q, C1)), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), p), Power(Times(g, r, Plus(q, C1)), -1)), x), Negate(Dist(Times(b, e, n, p, Power(Times(g, r, Plus(q, C1)), -1)), Int(Times(Power(Plus(f, Times(g, Power(x, r))), Plus(q, C1)), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), Plus(p, Negate(C1))), Power(Plus(d, Times(e, x)), -1)), x), x))), And(FreeQ(List(a, b, c, d, e, f, g, m, n, q, r), x), EqQ(m, Plus(r, Negate(C1))), NeQ(q, CN1), IGtQ(p, C0)))),
            IIntegrate(2414, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), Power(x_, m_DEFAULT), Power(Plus(f_, Times(g_DEFAULT, Power(x_, r_DEFAULT))), q_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Times(Power(x, m), Power(Plus(f, Times(g, Power(x, r))), q)), x))), Condition(Plus(Dist(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), u, x), Negate(Dist(Times(b, e, n), Int(SimplifyIntegrand(Times(u, Power(Plus(d, Times(e, x)), -1)), x), x), x))), InverseFunctionFreeQ(u, x))), And(FreeQ(List(a, b, c, d, e, f, g, m, n, q, r), x), IntegerQ(m), IntegerQ(q), IntegerQ(r)))),
            IIntegrate(2415, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(x_, m_DEFAULT), Power(Plus(f_DEFAULT, Times(g_DEFAULT, Power(x_, r_))), q_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(k, Denominator(r))), Dist(k, Subst(Int(Times(Power(x, Plus(Times(k, Plus(m, C1)), Negate(C1))), Power(Plus(f, Times(g, Power(x, Times(k, r)))), q), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, Power(x, k))), n))))), p)), x), x, Power(x, Power(k, -1))), x)), And(FreeQ(List(a, b, c, d, e, f, g, n, p, q), x), FractionQ(r), IGtQ(p, C0), IntegerQ(m)))),
            IIntegrate(2416, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(Times(h_DEFAULT, x_), m_DEFAULT), Power(Plus(f_, Times(g_DEFAULT, Power(x_, r_DEFAULT))), q_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), p), Times(Power(Times(h, x), m), Power(Plus(f, Times(g, Power(x, r))), q)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, h, m, n, p, q, r), x), IntegerQ(m), IntegerQ(q)))),
            IIntegrate(2417, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), p_DEFAULT), $p("§polyx")), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times($s("§polyx"), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), p)), x), x), And(FreeQ(List(a, b, c, d, e, n, p), x), PolynomialQ($s("§polyx"), x)))),
            IIntegrate(2418, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), p_DEFAULT), $p("§rfx")), x_Symbol),
                    Condition(With(List(Set(u, ExpandIntegrand(Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), p), $s("§rfx"), x))), Condition(Int(u, x), SumQ(u))), And(FreeQ(List(a, b, c, d, e, n), x), RationalFunctionQ($s("§rfx"), x), IntegerQ(p)))),
            IIntegrate(2419, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), p_DEFAULT), $p("§rfx")), x_Symbol),
                    Condition(With(List(Set(u, ExpandIntegrand(Times($s("§rfx"), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), p)), x))), Condition(Int(u, x), SumQ(u))), And(FreeQ(List(a, b, c, d, e, n), x), RationalFunctionQ($s("§rfx"), x), IntegerQ(p)))),
            IIntegrate(2420, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), p_DEFAULT), $p("§afx")), x_Symbol),
                    Condition(Unintegrable(Times($s("§afx"), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), p)), x), And(FreeQ(List(a, b, c, d, e, n, p), x), AlgebraicFunctionQ($s("§afx"), x, True)))),
            IIntegrate(2421, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(v_, n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(u_, q_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(ExpandToSum(u, x), q), Power(Plus(a, Times(b, Log(Times(c, Power(ExpandToSum(v, x), n))))), p)), x), And(FreeQ(List(a, b, c, n, p, q), x), BinomialQ(u, x), LinearQ(v, x), Not(And(BinomialMatchQ(u, x), LinearMatchQ(v, x)))))),
            IIntegrate(2422, Int(Times(Log(Times(f_DEFAULT, Power(x_, m_DEFAULT))), Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(x, Plus(m, Negate(Log(Times(f, Power(x, m))))), Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n)))))), x)), Negate(Dist(Times(b, e, n), Int(Times(x, Log(Times(f, Power(x, m))), Power(Plus(d, Times(e, x)), -1)), x), x)), Dist(Times(b, e, m, n), Int(Times(x, Power(Plus(d, Times(e, x)), -1)), x), x)), FreeQ(List(a, b, c, d, e, f, m, n), x))),
            IIntegrate(2423, Int(Times(Log(Times(f_DEFAULT, Power(x_, m_DEFAULT))), Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), p_)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), p), x))), Plus(Dist(Log(Times(f, Power(x, m))), u, x), Negate(Dist(m, Int(Dist(Power(x, -1), u, x), x), x)))), And(FreeQ(List(a, b, c, d, e, f, m, n), x), IGtQ(p, C1)))),
            IIntegrate(2424, Int(Times(Log(Times(f_DEFAULT, Power(x_, m_DEFAULT))), Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), p_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Log(Times(f, Power(x, m))), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), p)), x), FreeQ(List(a, b, c, d, e, f, m, n, p), x))),
            IIntegrate(2425, Int(Times(Log(Times(f_DEFAULT, Power(x_, m_DEFAULT))), Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), Power(x_, -1)), x_Symbol),
                    Condition(Plus(Simp(Times(Sqr(Log(Times(f, Power(x, m)))), Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), Power(Times(C2, m), -1)), x), Negate(Dist(Times(b, e, n, Power(Times(C2, m), -1)), Int(Times(Sqr(Log(Times(f, Power(x, m)))), Power(Plus(d, Times(e, x)), -1)), x), x))), FreeQ(List(a, b, c, d, e, f, m, n), x))),
            IIntegrate(2426, Int(Times(Log(Times(f_DEFAULT, Power(x_, m_DEFAULT))), Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), Power(Times(g_DEFAULT, x_), q_DEFAULT)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Plus(Times(m, Power(Times(g, x), Plus(q, C1)), Power(Plus(q, C1), -1)), Times(CN1, Power(Times(g, x), Plus(q, C1)), Log(Times(f, Power(x, m))))), Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), Power(Times(g, Plus(q, C1)), -1)), x)), Negate(Dist(Times(b, e, n, Power(Times(g, Plus(q, C1)), -1)), Int(Times(Power(Times(g, x), Plus(q, C1)), Log(Times(f, Power(x, m))), Power(Plus(d, Times(e, x)), -1)), x), x)), Dist(Times(b, e, m, n, Power(Times(g, Sqr(Plus(q, C1))), -1)), Int(Times(Power(Times(g, x), Plus(q, C1)), Power(Plus(d, Times(e, x)), -1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, m, n, q), x), NeQ(q, CN1)))),
            IIntegrate(2427, Int(Times(Log(Times(f_DEFAULT, Power(x_, m_DEFAULT))), Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(x_, -1)), x_Symbol),
                    Condition(Plus(Simp(Times(Sqr(Log(Times(f, Power(x, m)))), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), p), Power(Times(C2, m), -1)), x), Negate(Dist(Times(b, e, n, p, Power(Times(C2, m), -1)), Int(Times(Sqr(Log(Times(f, Power(x, m)))), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), Plus(p, Negate(C1))), Power(Plus(d, Times(e, x)), -1)), x), x))), And(FreeQ(List(a, b, c, d, e, f, m, n), x), IGtQ(p, C0)))),
            IIntegrate(2428, Int(Times(Log(Times(f_DEFAULT, Power(x_, m_DEFAULT))), Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), p_), Power(Times(g_DEFAULT, x_), q_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Times(Power(Times(g, x), q), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), p)), x))), Plus(Dist(Log(Times(f, Power(x, m))), u, x), Negate(Dist(m, Int(Dist(Power(x, -1), u, x), x), x)))), And(FreeQ(List(a, b, c, d, e, f, g, m, n, q), x), IGtQ(p, C1), IGtQ(q, C0)))),
            IIntegrate(2429, Int(Times(Log(Times(f_DEFAULT, Power(x_, m_DEFAULT))), Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(Times(g_DEFAULT, x_), q_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Times(g, x), q), Log(Times(f, Power(x, m))), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), p)), x), FreeQ(List(a, b, c, d, e, f, g, m, n, p, q), x))),
            IIntegrate(2430, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Plus(f_DEFAULT, Times(Log(Times(h_DEFAULT, Power(Plus(i_DEFAULT, Times(j_DEFAULT, x_)), m_DEFAULT))), g_DEFAULT))), x_Symbol),
                    Condition(Plus(Simp(Times(x, Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), p), Plus(f, Times(g, Log(Times(h, Power(Plus(i, Times(j, x)), m)))))), x), Negate(Dist(Times(g, j, m), Int(Times(x, Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), p), Power(Plus(i, Times(j, x)), -1)), x), x)), Negate(Dist(Times(b, e, n, p), Int(Times(x, Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), Plus(p, Negate(C1))), Plus(f, Times(g, Log(Times(h, Power(Plus(i, Times(j, x)), m))))), Power(Plus(d, Times(e, x)), -1)), x), x))), And(FreeQ(List(a, b, c, d, e, f, g, h, i, j, m, n), x), IGtQ(p, C0)))),
            IIntegrate(2431, Int(Times(Log(Times(f_DEFAULT, Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), m_DEFAULT))), Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(e, -1), Subst(Int(Times(Log(Times(f, Power(Times(g, x, Power(d, -1)), m))), Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), p)), x), x, Plus(d, Times(e, x))), x), And(FreeQ(List(a, b, c, d, e, f, g, h, m, n, p), x), EqQ(Plus(Times(e, f), Times(CN1, d, g)), C0)))),
            IIntegrate(2432, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(Plus(f_DEFAULT, Times(Log(Times(h_DEFAULT, Power(Plus(i_DEFAULT, Times(j_DEFAULT, x_)), m_DEFAULT))), g_DEFAULT)), q_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), p), Power(Plus(f, Times(g, Log(Times(h, Power(Plus(i, Times(j, x)), m))))), q)), x), FreeQ(List(a, b, c, d, e, f, g, h, i, j, m, n, p), x))),
            IIntegrate(2433, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Plus(f_DEFAULT, Times(Log(Times(h_DEFAULT, Power(Plus(i_DEFAULT, Times(j_DEFAULT, x_)), m_DEFAULT))), g_DEFAULT)), Power(Plus(k_DEFAULT, Times(l_DEFAULT, x_)), r_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(e, -1), Subst(Int(Times(Power(Times(k, x, Power(d, -1)), r), Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), p), Plus(f, Times(g, Log(Times(h, Power(Plus(Times(Plus(Times(e, i), Times(CN1, d, j)), Power(e, -1)), Times(j, x, Power(e, -1))), m)))))), x), x, Plus(d, Times(e, x))), x), And(FreeQ(List(a, b, c, d, e, f, g, h, i, j, k, l, n, p, r), x), EqQ(Plus(Times(e, k), Times(CN1, d, l)), C0)))),
            IIntegrate(2434, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), Plus(f_DEFAULT, Times(Log(Times(h_DEFAULT, Power(Plus(i_DEFAULT, Times(j_DEFAULT, x_)), m_DEFAULT))), g_DEFAULT)), Power(x_, -1)), x_Symbol),
                    Condition(Plus(Simp(Times(Log(x), Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), Plus(f, Times(g, Log(Times(h, Power(Plus(i, Times(j, x)), m)))))), x), Negate(Dist(Times(e, g, m), Int(Times(Log(x), Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), Power(Plus(d, Times(e, x)), -1)), x), x)), Negate(Dist(Times(b, j, n), Int(Times(Log(x), Plus(f, Times(g, Log(Times(h, Power(Plus(i, Times(j, x)), m))))), Power(Plus(i, Times(j, x)), -1)), x), x))), And(FreeQ(List(a, b, c, d, e, f, g, h, i, j, m, n), x), EqQ(Plus(Times(e, i), Times(CN1, d, j)), C0)))),
            IIntegrate(2435, Int(Times(Log(Plus(a_, Times(b_DEFAULT, x_))), Log(Plus(c_, Times(d_DEFAULT, x_))), Power(x_, -1)), x_Symbol),
                    Condition(Plus(Simp(Times(Log(Times(CN1, b, x, Power(a, -1))), Log(Plus(a, Times(b, x))), Log(Plus(c, Times(d, x)))), x), Simp(Times(C1D2, C1, Plus(Log(Times(CN1, b, x, Power(a, -1))), Negate(Log(Times(CN1, Plus(Times(b, c), Times(CN1, a, d)), x, Power(Times(a, Plus(c, Times(d, x))), -1)))), Log(Times(Plus(Times(b, c), Times(CN1, a, d)), Power(Times(b, Plus(c, Times(d, x))), -1)))), Sqr(Log(Times(a, Plus(c, Times(d, x)), Power(Times(c, Plus(a, Times(b, x))), -1))))), x), Negate(Simp(Times(C1D2, C1, Plus(Log(Times(CN1, b, x, Power(a, -1))), Negate(Log(Times(CN1, d, x, Power(c, -1))))), Sqr(Plus(Log(Plus(a, Times(b, x))), Log(Times(a, Plus(c, Times(d, x)), Power(Times(c, Plus(a, Times(b, x))), -1)))))), x)), Simp(Times(Plus(Log(Plus(c, Times(d, x))), Negate(Log(Times(a, Plus(c, Times(d, x)), Power(Times(c, Plus(a, Times(b, x))), -1))))), PolyLog(C2, Plus(C1, Times(b, x, Power(a, -1))))), x), Simp(Times(Plus(Log(Plus(a, Times(b, x))), Log(Times(a, Plus(c, Times(d, x)), Power(Times(c, Plus(a, Times(b, x))), -1)))), PolyLog(C2, Plus(C1, Times(d, x, Power(c, -1))))), x), Simp(Times(Log(Times(a, Plus(c, Times(d, x)), Power(Times(c, Plus(a, Times(b, x))), -1))), PolyLog(C2, Times(c, Plus(a, Times(b, x)), Power(Times(a, Plus(c, Times(d, x))), -1)))), x), Negate(Simp(Times(Log(Times(a, Plus(c, Times(d, x)), Power(Times(c, Plus(a, Times(b, x))), -1))), PolyLog(C2, Times(d, Plus(a, Times(b, x)), Power(Times(b, Plus(c, Times(d, x))), -1)))), x)), Negate(Simp(PolyLog(C3, Plus(C1, Times(b, x, Power(a, -1)))), x)), Negate(Simp(PolyLog(C3, Plus(C1, Times(d, x, Power(c, -1)))), x)), Simp(PolyLog(C3, Times(c, Plus(a, Times(b, x)), Power(Times(a, Plus(c, Times(d, x))), -1))), x), Negate(Simp(PolyLog(C3, Times(d, Plus(a, Times(b, x)), Power(Times(b, Plus(c, Times(d, x))), -1))), x))), And(FreeQ(List(a, b, c, d), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0)))),
            IIntegrate(2436, Int(Times(Log(v_), Log(w_), Power(x_, -1)), x_Symbol),
                    Condition(Int(Times(Log(ExpandToSum(v, x)), Log(ExpandToSum(w, x)), Power(x, -1)), x), And(LinearQ(List(v, w), x), Not(LinearMatchQ(List(v, w), x))))),
            IIntegrate(2437, Int(Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), Log(Times(h_DEFAULT, Power(Plus(i_DEFAULT, Times(j_DEFAULT, x_)), m_DEFAULT))), Power(x_, -1)), x_Symbol),
                    Condition(Plus(Dist(m, Int(Times(Log(Plus(i, Times(j, x))), Log(Times(c, Power(Plus(d, Times(e, x)), n))), Power(x, -1)), x), x), Negate(Dist(Plus(Times(m, Log(Plus(i, Times(j, x)))), Negate(Log(Times(h, Power(Plus(i, Times(j, x)), m))))), Int(Times(Log(Times(c, Power(Plus(d, Times(e, x)), n))), Power(x, -1)), x), x))), And(FreeQ(List(c, d, e, h, i, j, m, n), x), NeQ(Plus(Times(e, i), Times(CN1, d, j)), C0), NeQ(Plus(i, Times(j, x)), Times(h, Power(Plus(i, Times(j, x)), m)))))),
            IIntegrate(2438, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), Plus(Times(Log(Times(h_DEFAULT, Power(Plus(i_DEFAULT, Times(j_DEFAULT, x_)), m_DEFAULT))), g_DEFAULT), f_), Power(x_, -1)), x_Symbol),
                    Condition(Plus(Dist(f, Int(Times(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), Power(x, -1)), x), x), Dist(g, Int(Times(Log(Times(h, Power(Plus(i, Times(j, x)), m))), Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), Power(x, -1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, h, i, j, m, n), x), NeQ(Plus(Times(e, i), Times(CN1, d, j)), C0)))),
            IIntegrate(2439, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Plus(f_DEFAULT, Times(Log(Times(h_DEFAULT, Power(Plus(i_DEFAULT, Times(j_DEFAULT, x_)), m_DEFAULT))), g_DEFAULT)), Power(x_, r_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, Plus(r, C1)), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), p), Plus(f, Times(g, Log(Times(h, Power(Plus(i, Times(j, x)), m))))), Power(Plus(r, C1), -1)), x), Negate(Dist(Times(g, j, m, Power(Plus(r, C1), -1)), Int(Times(Power(x, Plus(r, C1)), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), p), Power(Plus(i, Times(j, x)), -1)), x), x)), Negate(Dist(Times(b, e, n, p, Power(Plus(r, C1), -1)), Int(Times(Power(x, Plus(r, C1)), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), Plus(p, Negate(C1))), Plus(f, Times(g, Log(Times(h, Power(Plus(i, Times(j, x)), m))))), Power(Plus(d, Times(e, x)), -1)), x), x))), And(FreeQ(List(a, b, c, d, e, f, g, h, i, j, m, n), x), IGtQ(p, C0), IntegerQ(r), Or(EqQ(p, C1), GtQ(r, C0)), NeQ(r, CN1)))),
            IIntegrate(2440, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), Plus(f_DEFAULT, Times(Log(Times(h_DEFAULT, Power(Plus(i_DEFAULT, Times(j_DEFAULT, x_)), m_DEFAULT))), g_DEFAULT)), Power(Plus(k_, Times(l_DEFAULT, x_)), r_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(l, -1), Subst(Int(Times(Power(x, r), Plus(a, Times(b, Log(Times(c, Power(Plus(Times(CN1, Plus(Times(e, k), Times(CN1, d, l)), Power(l, -1)), Times(e, x, Power(l, -1))), n))))), Plus(f, Times(g, Log(Times(h, Power(Plus(Times(CN1, Plus(Times(j, k), Times(CN1, i, l)), Power(l, -1)), Times(j, x, Power(l, -1))), m)))))), x), x, Plus(k, Times(l, x))), x), And(FreeQ(List(a, b, c, d, e, f, g, h, i, j, k, l, m, n), x), IntegerQ(r)))),
            IIntegrate(2441, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(Plus(f_DEFAULT, Times(Log(Times(h_DEFAULT, Power(Plus(i_DEFAULT, Times(j_DEFAULT, x_)), m_DEFAULT))), g_DEFAULT)), q_DEFAULT), Power(Plus(k_DEFAULT, Times(l_DEFAULT, x_)), r_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(k, Times(l, x)), r), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), p), Power(Plus(f, Times(g, Log(Times(h, Power(Plus(i, Times(j, x)), m))))), q)), x), FreeQ(List(a, b, c, d, e, f, g, h, i, j, k, l, m, n, p, q, r), x))),
            IIntegrate(2442, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(Plus(f_, Times(g_DEFAULT, x_)), -1), PolyLog(k_, Plus(h_, Times(i_DEFAULT, x_)))), x_Symbol),
                    Condition(Dist(Power(g, -1), Subst(Int(Times(PolyLog(k, Times(h, x, Power(d, -1))), Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), p), Power(x, -1)), x), x, Plus(d, Times(e, x))), x), And(FreeQ(List(a, b, c, d, e, f, g, h, i, k, n), x), EqQ(Plus(Times(e, f), Times(CN1, d, g)), C0), EqQ(Plus(Times(g, h), Times(CN1, f, i)), C0), IGtQ(p, C0)))),
            IIntegrate(2443, Int(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), $p("§px", true), $(F_, Times(f_DEFAULT, Plus(g_DEFAULT, Times(h_DEFAULT, x_))))), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Times($s("§px"), F(Times(f, Plus(g, Times(h, x))))), x))), Plus(Dist(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, x)), n))))), u, x), Negate(Dist(Times(b, e, n), Int(SimplifyIntegrand(Times(u, Power(Plus(d, Times(e, x)), -1)), x), x), x)))), And(FreeQ(List(a, b, c, d, e, f, g, h, n), x), PolynomialQ($s("§px"), x), MemberQ(List(ArcSin, ArcCos, ArcTan, ArcCot, ArcSinh, ArcCosh, ArcTanh, ArcCoth), FSymbol)))),
            IIntegrate(2444, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(v_, n_DEFAULT))), b_DEFAULT)), p_DEFAULT), u_DEFAULT), x_Symbol),
                    Condition(Int(Times(u, Power(Plus(a, Times(b, Log(Times(c, Power(ExpandToSum(v, x), n))))), p)), x), And(FreeQ(List(a, b, c, n, p), x), LinearQ(v, x), Not(LinearMatchQ(v, x)), Not(And(EqQ(n, C1), MatchQ(Times(c, v), Condition(Times(e_DEFAULT, Plus(f_, Times(g_DEFAULT, x))), FreeQ(List(e, f, g), x)))))))),
            IIntegrate(2445, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Times(d_DEFAULT, Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), n_))), b_DEFAULT)), p_DEFAULT), u_DEFAULT), x_Symbol),
                    Condition(Subst(Int(Times(u, Power(Plus(a, Times(b, Log(Times(c, Power(d, n), Power(Plus(e, Times(f, x)), Times(m, n)))))), p)), x), Times(c, Power(d, n), Power(Plus(e, Times(f, x)), Times(m, n))), Times(c, Power(Times(d, Power(Plus(e, Times(f, x)), m)), n))), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), Not(IntegerQ(n)), Not(And(EqQ(d, C1), EqQ(m, C1))), IntegralFreeQ(IntHide(Times(u, Power(Plus(a, Times(b, Log(Times(c, Power(d, n), Power(Plus(e, Times(f, x)), Times(m, n)))))), p)), x))))),
            IIntegrate(2446, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Times(d_DEFAULT, Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), n_))), b_DEFAULT)), p_DEFAULT), $p("§afx")), x_Symbol),
                    Condition(Unintegrable(Times($s("§afx"), Power(Plus(a, Times(b, Log(Times(c, Power(Times(d, Power(Plus(e, Times(f, x)), m)), n))))), p)), x), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), AlgebraicFunctionQ($s("§afx"), x, True)))),
            IIntegrate(2447, Int(Times(Log(u_), Power($p("§pq"), m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(CSymbol, FullSimplify(Times(Power($s("§pq"), m), Plus(C1, Negate(u)), Power(D(u, x), -1))))), Condition(Simp(Times(CSymbol, PolyLog(C2, Plus(C1, Negate(u)))), x), FreeQ(CSymbol, x))), And(IntegerQ(m), PolyQ($s("§pq"), x), RationalFunctionQ(u, x), LeQ(Part(RationalFunctionExponents(u, x), C2), Expon($s("§pq"), x))))),
            IIntegrate(2448, Int(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), p_DEFAULT))), x_Symbol),
                    Condition(Plus(Simp(Times(x, Log(Times(c, Power(Plus(d, Times(e, Power(x, n))), p)))), x), Negate(Dist(Times(e, n, p), Int(Times(Power(x, n), Power(Plus(d, Times(e, Power(x, n))), -1)), x), x))), FreeQ(List(c, d, e, n, p), x))),
            IIntegrate(2449, Int(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Power(x_, -1))), p_DEFAULT))), b_DEFAULT)), q_), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(e, Times(d, x)), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, Power(x, -1))), p))))), q), Power(d, -1)), x), Dist(Times(b, e, p, q, Power(d, -1)), Int(Times(Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, Power(x, -1))), p))))), Plus(q, Negate(C1))), Power(x, -1)), x), x)), And(FreeQ(List(a, b, c, d, e, p), x), IGtQ(q, C0)))),
            IIntegrate(2450, Int(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), p_DEFAULT))), b_DEFAULT)), q_), x_Symbol),
                    Condition(Plus(Simp(Times(x, Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, Power(x, n))), p))))), q)), x), Negate(Dist(Times(b, e, n, p, q), Int(Times(Power(x, n), Power(Plus(a, Times(b, Log(Times(c, Power(Plus(d, Times(e, Power(x, n))), p))))), Plus(q, Negate(C1))), Power(Plus(d, Times(e, Power(x, n))), -1)), x), x))), And(FreeQ(List(a, b, c, d, e, n, p), x), IGtQ(q, C0), Or(EqQ(q, C1), IntegerQ(n)))))
    );
}
