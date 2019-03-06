package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.ASymbol;
import static org.matheclipse.core.expression.F.A_DEFAULT;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.BSymbol;
import static org.matheclipse.core.expression.F.B_DEFAULT;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CSymbol;
import static org.matheclipse.core.expression.F.C_DEFAULT;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.D;
import static org.matheclipse.core.expression.F.ExpIntegralEi;
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
import static org.matheclipse.core.expression.F.g_;
import static org.matheclipse.core.expression.F.g_DEFAULT;
import static org.matheclipse.core.expression.F.h;
import static org.matheclipse.core.expression.F.h_DEFAULT;
import static org.matheclipse.core.expression.F.i;
import static org.matheclipse.core.expression.F.i_DEFAULT;
import static org.matheclipse.core.expression.F.j;
import static org.matheclipse.core.expression.F.j_DEFAULT;
import static org.matheclipse.core.expression.F.k;
import static org.matheclipse.core.expression.F.k_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.r;
import static org.matheclipse.core.expression.F.r_DEFAULT;
import static org.matheclipse.core.expression.F.s;
import static org.matheclipse.core.expression.F.s_DEFAULT;
import static org.matheclipse.core.expression.F.t;
import static org.matheclipse.core.expression.F.t_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.u_DEFAULT;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.v_DEFAULT;
import static org.matheclipse.core.expression.F.w;
import static org.matheclipse.core.expression.F.w_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.expression.F.z;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.AlgebraicFunctionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialDegree;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Coeff;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.DerivativeDivides;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FalseQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntHide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InverseFunctionFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearMatchQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules50 {
    public static IAST RULES = List(
            IIntegrate(2501, Int(Times(Power(Log(Times(e_DEFAULT, Power(Times(f_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), q_DEFAULT)), r_DEFAULT))), u_DEFAULT), Power(Plus(s_DEFAULT, Times(Log(Times(i_DEFAULT, Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), n_DEFAULT))), t_DEFAULT)), m_DEFAULT), Power(Plus(j_DEFAULT, Times(k_DEFAULT, x_)), -1)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), u), Power(Plus(s, Times(t, Log(Times(i, Power(Plus(g, Times(h, x)), n))))), m), Power(Plus(j, Times(k, x)), -1)), x), And(FreeQ(List(a, b, c, d, e, f, g, h, i, j, k, s, t, m, n, p, q, r, u), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0)))),
            IIntegrate(2502, Int(Times(Log(Times(e_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), -1), Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), u_), x_Symbol),
                    Condition(With(List(Set(g, Coeff(Simplify(Power(Times(u, Plus(a, Times(b, x))), -1)), x, C0)), Set(h, Coeff(Simplify(Power(Times(u, Plus(a, Times(b, x))), -1)), x, C1))), Condition(Negate(Dist(Times(Plus(b, Times(CN1, d, e)), Power(Times(h, Plus(Times(b, c), Times(CN1, a, d))), -1)), Subst(Int(Times(Log(Times(e, x)), Power(Plus(C1, Times(CN1, e, x)), -1)), x), x, Times(Plus(c, Times(d, x)), Power(Plus(a, Times(b, x)), -1))), x)), EqQ(Plus(Times(g, Plus(b, Times(CN1, d, e))), Times(CN1, h, Plus(a, Times(CN1, c, e)))), C0))), And(FreeQ(List(a, b, c, d, e), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0), LinearQ(Simplify(Power(Times(u, Plus(a, Times(b, x))), -1)), x)))),
            IIntegrate(2503, Int(Times(Power(Log(Times(e_DEFAULT, Power(Times(f_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), q_DEFAULT)), r_DEFAULT))), s_DEFAULT), u_), x_Symbol),
                    Condition(With(List(Set(g, Coeff(Simplify(Power(Times(u, Plus(a, Times(b, x))), -1)), x, C0)), Set(h, Coeff(Simplify(Power(Times(u, Plus(a, Times(b, x))), -1)), x, C1))), Condition(Plus(Negate(Simp(Times(Power(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), s), Log(Times(CN1, Plus(Times(b, c), Times(CN1, a, d)), Plus(g, Times(h, x)), Power(Times(Plus(Times(d, g), Times(CN1, c, h)), Plus(a, Times(b, x))), -1))), Power(Plus(Times(b, g), Times(CN1, a, h)), -1)), x)), Dist(Times(p, r, s, Plus(Times(b, c), Times(CN1, a, d)), Power(Plus(Times(b, g), Times(CN1, a, h)), -1)), Int(Times(Power(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), Plus(s, Negate(C1))), Log(Times(CN1, Plus(Times(b, c), Times(CN1, a, d)), Plus(g, Times(h, x)), Power(Times(Plus(Times(d, g), Times(CN1, c, h)), Plus(a, Times(b, x))), -1))), Power(Times(Plus(a, Times(b, x)), Plus(c, Times(d, x))), -1)), x), x)), And(NeQ(Plus(Times(b, g), Times(CN1, a, h)), C0), NeQ(Plus(Times(d, g), Times(CN1, c, h)), C0)))), And(FreeQ(List(a, b, c, d, e, f, p, q, r, s), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0), IGtQ(s, C0), EqQ(Plus(p, q), C0), LinearQ(Simplify(Power(Times(u, Plus(a, Times(b, x))), -1)), x)))),
            IIntegrate(2504, Int(Times(Power(Log(Times(e_DEFAULT, Power(Times(f_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), q_DEFAULT)), r_DEFAULT))), -1), u_), x_Symbol),
                    Condition(With(List(Set(h, Simplify(Times(u, Plus(a, Times(b, x)), Plus(c, Times(d, x)))))), Condition(Simp(Times(h, Log(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r)))), Power(Times(p, r, Plus(Times(b, c), Times(CN1, a, d))), -1)), x), FreeQ(h, x))), And(FreeQ(List(a, b, c, d, e, f, p, q, r), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0), EqQ(Plus(p, q), C0)))),
            IIntegrate(2505, Int(Times(Power(Log(Times(e_DEFAULT, Power(Times(f_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), q_DEFAULT)), r_DEFAULT))), s_DEFAULT), u_), x_Symbol),
                    Condition(With(List(Set(h, Simplify(Times(u, Plus(a, Times(b, x)), Plus(c, Times(d, x)))))), Condition(Simp(Times(h, Power(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), Plus(s, C1)), Power(Times(p, r, Plus(s, C1), Plus(Times(b, c), Times(CN1, a, d))), -1)), x), FreeQ(h, x))), And(FreeQ(List(a, b, c, d, e, f, p, q, r, s), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0), EqQ(Plus(p, q), C0), NeQ(s, CN1)))),
            IIntegrate(2506, Int(Times(Log(v_), Power(Log(Times(e_DEFAULT, Power(Times(f_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), q_DEFAULT)), r_DEFAULT))), s_DEFAULT), u_), x_Symbol),
                    Condition(With(List(Set(g, Simplify(Times(Plus(v, Negate(C1)), Plus(c, Times(d, x)), Power(Plus(a, Times(b, x)), -1)))), Set(h, Simplify(Times(u, Plus(a, Times(b, x)), Plus(c, Times(d, x)))))), Condition(Plus(Negate(Simp(Times(h, PolyLog(C2, Plus(C1, Negate(v))), Power(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), s), Power(Plus(Times(b, c), Times(CN1, a, d)), -1)), x)), Dist(Times(h, p, r, s), Int(Times(PolyLog(C2, Plus(C1, Negate(v))), Power(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), Plus(s, Negate(C1))), Power(Times(Plus(a, Times(b, x)), Plus(c, Times(d, x))), -1)), x), x)), FreeQ(List(g, h), x))), And(FreeQ(List(a, b, c, d, e, f, p, q, r, s), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0), IGtQ(s, C0), EqQ(Plus(p, q), C0)))),
            IIntegrate(2507, Int(Times(Power(Log(Times(e_DEFAULT, Power(Times(f_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), q_DEFAULT)), r_DEFAULT))), s_DEFAULT), Log(Times(i_DEFAULT, Power(Times(j_DEFAULT, Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), t_DEFAULT)), u_DEFAULT))), v_), x_Symbol),
                    Condition(With(List(Set(k, Simplify(Times(v, Plus(a, Times(b, x)), Plus(c, Times(d, x)))))), Condition(Plus(Simp(Times(k, Log(Times(i, Power(Times(j, Power(Plus(g, Times(h, x)), t)), u))), Power(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), Plus(s, C1)), Power(Times(p, r, Plus(s, C1), Plus(Times(b, c), Times(CN1, a, d))), -1)), x), Negate(Dist(Times(k, h, t, u, Power(Times(p, r, Plus(s, C1), Plus(Times(b, c), Times(CN1, a, d))), -1)), Int(Times(Power(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), Plus(s, C1)), Power(Plus(g, Times(h, x)), -1)), x), x))), FreeQ(k, x))), And(FreeQ(List(a, b, c, d, e, f, g, h, i, j, p, q, r, s, t, u), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0), EqQ(Plus(p, q), C0), NeQ(s, CN1)))),
            IIntegrate(2508, Int(Times(Power(Log(Times(e_DEFAULT, Power(Times(f_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), q_DEFAULT)), r_DEFAULT))), s_DEFAULT), u_, PolyLog(n_, v_)), x_Symbol),
                    Condition(With(List(Set(g, Simplify(Times(v, Plus(c, Times(d, x)), Power(Plus(a, Times(b, x)), -1)))), Set(h, Simplify(Times(u, Plus(a, Times(b, x)), Plus(c, Times(d, x)))))), Condition(Plus(Simp(Times(h, PolyLog(Plus(n, C1), v), Power(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), s), Power(Plus(Times(b, c), Times(CN1, a, d)), -1)), x), Negate(Dist(Times(h, p, r, s), Int(Times(PolyLog(Plus(n, C1), v), Power(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), Plus(s, Negate(C1))), Power(Times(Plus(a, Times(b, x)), Plus(c, Times(d, x))), -1)), x), x))), FreeQ(List(g, h), x))), And(FreeQ(List(a, b, c, d, e, f, n, p, q, r, s), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0), IGtQ(s, C0), EqQ(Plus(p, q), C0)))),
            IIntegrate(2509, Int(Times(Power(Log(Times(e_DEFAULT, Power(Times(f_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), q_DEFAULT)), r_DEFAULT))), s_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), Plus(n, C1)), Power(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), s), Power(Times(Plus(m, C1), Plus(Times(b, c), Times(CN1, a, d))), -1)), x), Negate(Dist(Times(p, r, s, Plus(Times(b, c), Times(CN1, a, d)), Power(Times(Plus(m, C1), Plus(Times(b, c), Times(CN1, a, d))), -1)), Int(Times(Power(Plus(a, Times(b, x)), m), Power(Plus(c, Times(d, x)), n), Power(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), Plus(s, Negate(C1)))), x), x))), And(FreeQ(List(a, b, c, d, e, f, m, n, p, q, r, s), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0), EqQ(Plus(p, q), C0), EqQ(Plus(m, n, C2), C0), NeQ(m, CN1), IGtQ(s, C0)))),
            IIntegrate(2510, Int(Times(Power(Log(Times(e_DEFAULT, Power(Times(f_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), q_DEFAULT)), r_DEFAULT))), -1), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT)), x_Symbol),
                    Condition(Simp(Times(Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), Plus(n, C1)), ExpIntegralEi(Times(Plus(m, C1), Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), Power(Times(p, r), -1))), Power(Times(p, r, Plus(Times(b, c), Times(CN1, a, d)), Power(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r)), Times(Plus(m, C1), Power(Times(p, r), -1)))), -1)), x), And(FreeQ(List(a, b, c, d, e, f, m, n, p, q, r), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0), EqQ(Plus(p, q), C0), EqQ(Plus(m, n, C2), C0), NeQ(m, CN1)))),
            IIntegrate(2511, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Sqrt(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), CN1D2))), b_DEFAULT)), n_DEFAULT), Power(Plus(A_DEFAULT, Times(B_DEFAULT, x_), Times(C_DEFAULT, Sqr(x_))), -1)), x_Symbol),
                    Condition(Dist(Times(C2, e, g, Power(Times(CSymbol, Plus(Times(e, f), Times(CN1, d, g))), -1)), Subst(Int(Times(Power(Plus(a, Times(b, Log(Times(c, x)))), n), Power(x, -1)), x), x, Times(Sqrt(Plus(d, Times(e, x))), Power(Plus(f, Times(g, x)), CN1D2))), x), And(FreeQ(List(a, b, c, d, e, f, g, ASymbol, BSymbol, CSymbol, n), x), EqQ(Plus(Times(CSymbol, d, f), Times(CN1, ASymbol, e, g)), C0), EqQ(Plus(Times(BSymbol, e, g), Times(CN1, CSymbol, Plus(Times(e, f), Times(d, g)))), C0)))),
            IIntegrate(2512, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Sqrt(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), CN1D2))), b_DEFAULT)), n_DEFAULT), Power(Plus(A_DEFAULT, Times(C_DEFAULT, Sqr(x_))), -1)), x_Symbol),
                    Condition(Dist(Times(g, Power(Times(CSymbol, f), -1)), Subst(Int(Times(Power(Plus(a, Times(b, Log(Times(c, x)))), n), Power(x, -1)), x), x, Times(Sqrt(Plus(d, Times(e, x))), Power(Plus(f, Times(g, x)), CN1D2))), x), And(FreeQ(List(a, b, c, d, e, f, g, ASymbol, CSymbol, n), x), EqQ(Plus(Times(CSymbol, d, f), Times(CN1, ASymbol, e, g)), C0), EqQ(Plus(Times(e, f), Times(d, g)), C0)))),
            IIntegrate(2513, Int(Times(Log(Times(e_DEFAULT, Power(Times(f_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), q_DEFAULT)), r_DEFAULT))), $p("§rfx", true)), x_Symbol),
                    Condition(Plus(Dist(Times(p, r), Int(Times($s("§rfx"), Log(Plus(a, Times(b, x)))), x), x), Dist(Times(q, r), Int(Times($s("§rfx"), Log(Plus(c, Times(d, x)))), x), x), Negate(Dist(Plus(Times(p, r, Log(Plus(a, Times(b, x)))), Times(q, r, Log(Plus(c, Times(d, x)))), Negate(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))))), Int($s("§rfx"), x), x))), And(FreeQ(List(a, b, c, d, e, f, p, q, r), x), RationalFunctionQ($s("§rfx"), x), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0), Not(MatchQ($s("§rfx"), Condition(Times(u_DEFAULT, Power(Plus(a, Times(b, x)), m_DEFAULT), Power(Plus(c, Times(d, x)), n_DEFAULT)), IntegersQ(m, n))))))),
            IIntegrate(2514, Int(Times(Power(Log(Times(e_DEFAULT, Power(Times(f_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), q_DEFAULT)), r_DEFAULT))), s_DEFAULT), $p("§rfx")), x_Symbol),
                    Condition(With(List(Set(u, ExpandIntegrand(Power(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), s), $s("§rfx"), x))), Condition(Int(u, x), SumQ(u))), And(FreeQ(List(a, b, c, d, e, f, p, q, r, s), x), RationalFunctionQ($s("§rfx"), x), IGtQ(s, C0)))),
            IIntegrate(2515, Int(Times(Power(Log(Times(e_DEFAULT, Power(Times(f_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), q_DEFAULT)), r_DEFAULT))), s_DEFAULT), $p("§rfx")), x_Symbol),
                    Condition(Unintegrable(Times($s("§rfx"), Power(Log(Times(e, Power(Times(f, Power(Plus(a, Times(b, x)), p), Power(Plus(c, Times(d, x)), q)), r))), s)), x), And(FreeQ(List(a, b, c, d, e, f, p, q, r, s), x), RationalFunctionQ($s("§rfx"), x)))),
            IIntegrate(2516, Int(Times(Power(Log(Times(e_DEFAULT, Power(Times(f_DEFAULT, Power(v_, p_DEFAULT), Power(w_, q_DEFAULT)), r_DEFAULT))), s_DEFAULT), u_DEFAULT), x_Symbol),
                    Condition(Int(Times(u, Power(Log(Times(e, Power(Times(f, Power(ExpandToSum(v, x), p), Power(ExpandToSum(w, x), q)), r))), s)), x), And(FreeQ(List(e, f, p, q, r, s), x), LinearQ(List(v, w), x), Not(LinearMatchQ(List(v, w), x)), AlgebraicFunctionQ(u, x)))),
            IIntegrate(2517, Int(Times(Power(Log(Times(e_DEFAULT, Power(Times(f_DEFAULT, Plus(g_, Times(v_DEFAULT, Power(w_, -1)))), r_DEFAULT))), s_DEFAULT), u_DEFAULT), x_Symbol),
                    Condition(Int(Times(u, Power(Log(Times(e, Power(Times(f, ExpandToSum(Plus(v, Times(g, w)), x), Power(ExpandToSum(w, x), -1)), r))), s)), x), And(FreeQ(List(e, f, g, r, s), x), LinearQ(w, x), Or(FreeQ(v, x), LinearQ(v, x)), AlgebraicFunctionQ(u, x)))),
            IIntegrate(2518, Int(Times(Log(v_), u_), x_Symbol),
                    With(List(Set(w, DerivativeDivides(v, Times(u, Plus(C1, Negate(v))), x))), Condition(Simp(Times(w, PolyLog(C2, Plus(C1, Negate(v)))), x), Not(FalseQ(w))))),
            IIntegrate(2519, Int(Times(Log(v_), Plus(a_DEFAULT, Times(Log(u_), b_DEFAULT)), w_), x_Symbol),
                    Condition(With(List(Set(z, DerivativeDivides(v, Times(w, Plus(C1, Negate(v))), x))), Condition(Plus(Simp(Times(z, Plus(a, Times(b, Log(u))), PolyLog(C2, Plus(C1, Negate(v)))), x), Negate(Dist(b, Int(SimplifyIntegrand(Times(z, PolyLog(C2, Plus(C1, Negate(v))), D(u, x), Power(u, -1)), x), x), x))), Not(FalseQ(z)))), And(FreeQ(List(a, b), x), InverseFunctionFreeQ(u, x)))),
            IIntegrate(2520, Int(Log(Times(Power(Log(Times(d_DEFAULT, Power(x_, n_DEFAULT))), p_DEFAULT), c_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(x, Log(Times(c, Power(Log(Times(d, Power(x, n))), p)))), x), Negate(Dist(Times(n, p), Int(Power(Log(Times(d, Power(x, n))), -1), x), x))), FreeQ(List(c, d, n, p), x))),
            IIntegrate(2521, Int(Times(Plus(a_DEFAULT, Times(Log(Times(Power(Log(Times(d_DEFAULT, Power(x_, n_DEFAULT))), p_DEFAULT), c_DEFAULT)), b_DEFAULT)), Power(x_, -1)), x_Symbol),
                    Condition(Plus(Simp(Times(Log(Times(d, Power(x, n))), Plus(a, Times(b, Log(Times(c, Power(Log(Times(d, Power(x, n))), p))))), Power(n, -1)), x), Negate(Simp(Times(b, p, Log(x)), x))), FreeQ(List(a, b, c, d, n, p), x))),
            IIntegrate(2522, Int(Times(Plus(a_DEFAULT, Times(Log(Times(Power(Log(Times(d_DEFAULT, Power(x_, n_DEFAULT))), p_DEFAULT), c_DEFAULT)), b_DEFAULT)), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(e, x), Plus(m, C1)), Plus(a, Times(b, Log(Times(c, Power(Log(Times(d, Power(x, n))), p))))), Power(Times(e, Plus(m, C1)), -1)), x), Negate(Dist(Times(b, n, p, Power(Plus(m, C1), -1)), Int(Times(Power(Times(e, x), m), Power(Log(Times(d, Power(x, n))), -1)), x), x))), And(FreeQ(List(a, b, c, d, e, m, n, p), x), NeQ(m, CN1)))),
            IIntegrate(2523, Int(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power($p("§rfx"), p_DEFAULT))), b_DEFAULT)), n_DEFAULT), x_Symbol),
                    Condition(Plus(Simp(Times(x, Power(Plus(a, Times(b, Log(Times(c, Power($s("§rfx"), p))))), n)), x), Negate(Dist(Times(b, n, p), Int(SimplifyIntegrand(Times(x, Power(Plus(a, Times(b, Log(Times(c, Power($s("§rfx"), p))))), Plus(n, Negate(C1))), D($s("§rfx"), x), Power($s("§rfx"), -1)), x), x), x))), And(FreeQ(List(a, b, c, p), x), RationalFunctionQ($s("§rfx"), x), IGtQ(n, C0)))),
            IIntegrate(2524, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power($p("§rfx"), p_DEFAULT))), b_DEFAULT)), n_DEFAULT), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), -1)), x_Symbol),
                    Condition(Plus(Simp(Times(Log(Plus(d, Times(e, x))), Power(Plus(a, Times(b, Log(Times(c, Power($s("§rfx"), p))))), n), Power(e, -1)), x), Negate(Dist(Times(b, n, p, Power(e, -1)), Int(Times(Log(Plus(d, Times(e, x))), Power(Plus(a, Times(b, Log(Times(c, Power($s("§rfx"), p))))), Plus(n, Negate(C1))), D($s("§rfx"), x), Power($s("§rfx"), -1)), x), x))), And(FreeQ(List(a, b, c, d, e, p), x), RationalFunctionQ($s("§rfx"), x), IGtQ(n, C0)))),
            IIntegrate(2525, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power($p("§rfx"), p_DEFAULT))), b_DEFAULT)), n_DEFAULT), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(b, Log(Times(c, Power($s("§rfx"), p))))), n), Power(Times(e, Plus(m, C1)), -1)), x), Negate(Dist(Times(b, n, p, Power(Times(e, Plus(m, C1)), -1)), Int(SimplifyIntegrand(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(b, Log(Times(c, Power($s("§rfx"), p))))), Plus(n, Negate(C1))), D($s("§rfx"), x), Power($s("§rfx"), -1)), x), x), x))), And(FreeQ(List(a, b, c, d, e, m, p), x), RationalFunctionQ($s("§rfx"), x), IGtQ(n, C0), Or(EqQ(n, C1), IntegerQ(m)), NeQ(m, CN1)))),
            IIntegrate(2526, Int(Times(Log(Times(c_DEFAULT, Power($p("§rfx"), n_DEFAULT))), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), -1)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Power(Plus(d, Times(e, Sqr(x))), -1), x))), Plus(Simp(Times(u, Log(Times(c, Power($s("§rfx"), n)))), x), Negate(Dist(n, Int(SimplifyIntegrand(Times(u, D($s("§rfx"), x), Power($s("§rfx"), -1)), x), x), x)))), And(FreeQ(List(c, d, e, n), x), RationalFunctionQ($s("§rfx"), x), Not(PolynomialQ($s("§rfx"), x))))),
            IIntegrate(2527, Int(Times(Log(Times(c_DEFAULT, Power($p("§px"), n_DEFAULT))), Power($p("§qx"), -1)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Power($s("§qx"), -1), x))), Plus(Simp(Times(u, Log(Times(c, Power($s("§px"), n)))), x), Negate(Dist(n, Int(SimplifyIntegrand(Times(u, D($s("§px"), x), Power($s("§px"), -1)), x), x), x)))), And(FreeQ(List(c, n), x), QuadraticQ(List($s("§qx"), $s("§px")), x), EqQ(D(Times($s("§px"), Power($s("§qx"), -1)), x), C0)))),
            IIntegrate(2528, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power($p("§rfx"), p_DEFAULT))), b_DEFAULT)), n_DEFAULT), $p("§rgx")), x_Symbol),
                    Condition(With(List(Set(u, ExpandIntegrand(Power(Plus(a, Times(b, Log(Times(c, Power($s("§rfx"), p))))), n), $s("§rgx"), x))), Condition(Int(u, x), SumQ(u))), And(FreeQ(List(a, b, c, p), x), RationalFunctionQ($s("§rfx"), x), RationalFunctionQ($s("§rgx"), x), IGtQ(n, C0)))),
            IIntegrate(2529, Int(Times(Power(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power($p("§rfx"), p_DEFAULT))), b_DEFAULT)), n_DEFAULT), $p("§rgx")), x_Symbol),
                    Condition(With(List(Set(u, ExpandIntegrand(Times($s("§rgx"), Power(Plus(a, Times(b, Log(Times(c, Power($s("§rfx"), p))))), n)), x))), Condition(Int(u, x), SumQ(u))), And(FreeQ(List(a, b, c, p), x), RationalFunctionQ($s("§rfx"), x), RationalFunctionQ($s("§rgx"), x), IGtQ(n, C0)))),
            IIntegrate(2530, Int(Times(Plus(a_DEFAULT, Times(Log(u_), b_DEFAULT)), $p("§rfx")), x_Symbol),
                    Condition(With(List(Set($s("lst"), SubstForFractionalPowerOfLinear(Times($s("§rfx"), Plus(a, Times(b, Log(u)))), x))), Condition(Dist(Times(Part($s("lst"), C2), Part($s("lst"), C4)), Subst(Int(Part($s("lst"), C1), x), x, Power(Part($s("lst"), C3), Power(Part($s("lst"), C2), -1))), x), Not(FalseQ($s("lst"))))), And(FreeQ(List(a, b), x), RationalFunctionQ($s("§rfx"), x)))),
            IIntegrate(2531, Int(Times(Log(Plus(C1, Times(e_DEFAULT, Power(Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), n_DEFAULT)))), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(f, Times(g, x)), m), PolyLog(C2, Times(CN1, e, Power(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), n))), Power(Times(b, c, n, Log(FSymbol)), -1)), x)), Dist(Times(g, m, Power(Times(b, c, n, Log(FSymbol)), -1)), Int(Times(Power(Plus(f, Times(g, x)), Plus(m, Negate(C1))), PolyLog(C2, Times(CN1, e, Power(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), n)))), x), x)), And(FreeQ(List(FSymbol, a, b, c, e, f, g, n), x), GtQ(m, C0)))),
            IIntegrate(2532, Int(Times(Log(Plus(d_, Times(e_DEFAULT, Power(Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), n_DEFAULT)))), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(f, Times(g, x)), Plus(m, C1)), Log(Plus(d, Times(e, Power(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), n)))), Power(Times(g, Plus(m, C1)), -1)), x), Int(Times(Power(Plus(f, Times(g, x)), m), Log(Plus(C1, Times(e, Power(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), n), Power(d, -1))))), x), Negate(Simp(Times(Power(Plus(f, Times(g, x)), Plus(m, C1)), Log(Plus(C1, Times(e, Power(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), n), Power(d, -1)))), Power(Times(g, Plus(m, C1)), -1)), x))), And(FreeQ(List(FSymbol, a, b, c, d, e, f, g, n), x), GtQ(m, C0), NeQ(d, C1)))),
            IIntegrate(2533, Int(Log(Plus(d_DEFAULT, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqrt(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))))))), x_Symbol),
                    Condition(Plus(Simp(Times(x, Log(Plus(d, Times(e, x), Times(f, Sqrt(Plus(a, Times(b, x), Times(c, Sqr(x)))))))), x), Dist(Times(C1D2, Sqr(f), Plus(Sqr(b), Times(CN1, C4, a, c))), Int(Times(x, Power(Plus(Times(Plus(Times(C2, d, e), Times(CN1, b, Sqr(f))), Plus(a, Times(b, x), Times(c, Sqr(x)))), Times(CN1, f, Plus(Times(b, d), Times(CN1, C2, a, e), Times(Plus(Times(C2, c, d), Times(CN1, b, e)), x)), Sqrt(Plus(a, Times(b, x), Times(c, Sqr(x)))))), -1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), EqQ(Plus(Sqr(e), Times(CN1, c, Sqr(f))), C0)))),
            IIntegrate(2534, Int(Log(Plus(d_DEFAULT, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqrt(Plus(a_DEFAULT, Times(c_DEFAULT, Sqr(x_))))))), x_Symbol),
                    Condition(Plus(Simp(Times(x, Log(Plus(d, Times(e, x), Times(f, Sqrt(Plus(a, Times(c, Sqr(x)))))))), x), Negate(Dist(Times(a, c, Sqr(f)), Int(Times(x, Power(Plus(Times(d, e, Plus(a, Times(c, Sqr(x)))), Times(f, Plus(Times(a, e), Times(CN1, c, d, x)), Sqrt(Plus(a, Times(c, Sqr(x)))))), -1)), x), x))), And(FreeQ(List(a, c, d, e, f), x), EqQ(Plus(Sqr(e), Times(CN1, c, Sqr(f))), C0)))),
            IIntegrate(2535, Int(Times(Log(Plus(d_DEFAULT, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqrt(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))))))), Power(Times(g_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(g, x), Plus(m, C1)), Log(Plus(d, Times(e, x), Times(f, Sqrt(Plus(a, Times(b, x), Times(c, Sqr(x))))))), Power(Times(g, Plus(m, C1)), -1)), x), Dist(Times(Sqr(f), Plus(Sqr(b), Times(CN1, C4, a, c)), Power(Times(C2, g, Plus(m, C1)), -1)), Int(Times(Power(Times(g, x), Plus(m, C1)), Power(Plus(Times(Plus(Times(C2, d, e), Times(CN1, b, Sqr(f))), Plus(a, Times(b, x), Times(c, Sqr(x)))), Times(CN1, f, Plus(Times(b, d), Times(CN1, C2, a, e), Times(Plus(Times(C2, c, d), Times(CN1, b, e)), x)), Sqrt(Plus(a, Times(b, x), Times(c, Sqr(x)))))), -1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, m), x), EqQ(Plus(Sqr(e), Times(CN1, c, Sqr(f))), C0), NeQ(m, CN1), IntegerQ(Times(C2, m))))),
            IIntegrate(2536, Int(Times(Log(Plus(d_DEFAULT, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqrt(Plus(a_DEFAULT, Times(c_DEFAULT, Sqr(x_))))))), Power(Times(g_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(g, x), Plus(m, C1)), Log(Plus(d, Times(e, x), Times(f, Sqrt(Plus(a, Times(c, Sqr(x))))))), Power(Times(g, Plus(m, C1)), -1)), x), Negate(Dist(Times(a, c, Sqr(f), Power(Times(g, Plus(m, C1)), -1)), Int(Times(Power(Times(g, x), Plus(m, C1)), Power(Plus(Times(d, e, Plus(a, Times(c, Sqr(x)))), Times(f, Plus(Times(a, e), Times(CN1, c, d, x)), Sqrt(Plus(a, Times(c, Sqr(x)))))), -1)), x), x))), And(FreeQ(List(a, c, d, e, f, g, m), x), EqQ(Plus(Sqr(e), Times(CN1, c, Sqr(f))), C0), NeQ(m, CN1), IntegerQ(Times(C2, m))))),
            IIntegrate(2537, Int(Times(Log(Plus(d_DEFAULT, Times(f_DEFAULT, Sqrt(u_)), Times(e_DEFAULT, x_))), v_DEFAULT), x_Symbol),
                    Condition(Int(Times(v, Log(Plus(d, Times(e, x), Times(f, Sqrt(ExpandToSum(u, x)))))), x), And(FreeQ(List(d, e, f), x), QuadraticQ(u, x), Not(QuadraticMatchQ(u, x)), Or(EqQ(v, C1), MatchQ(v, Condition(Power(Times(g_DEFAULT, x), m_DEFAULT), FreeQ(List(g, m), x))))))),
            IIntegrate(2538, Int(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), r_DEFAULT), Power(x_, -1), Power(Plus(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), q_), b_DEFAULT), Times(a_DEFAULT, Power(x_, m_DEFAULT))), -1)), x_Symbol),
                    Condition(Plus(Simp(Times(Log(Plus(Times(a, Power(x, m)), Times(b, Power(Log(Times(c, Power(x, n))), q)))), Power(Times(b, n, q), -1)), x), Negate(Dist(Times(a, m, Power(Times(b, n, q), -1)), Int(Times(Power(x, Plus(m, Negate(C1))), Power(Plus(Times(a, Power(x, m)), Times(b, Power(Log(Times(c, Power(x, n))), q))), -1)), x), x))), And(FreeQ(List(a, b, c, m, n, q, r), x), EqQ(r, Plus(q, Negate(C1)))))),
            IIntegrate(2539, Int(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), r_DEFAULT), Power(x_, -1), Power(Plus(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), q_), b_DEFAULT), Times(a_DEFAULT, Power(x_, m_DEFAULT))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Log(Times(c, Power(x, n))), r), Power(x, -1)), Power(Plus(Times(a, Power(x, m)), Times(b, Power(Log(Times(c, Power(x, n))), q))), p), x), x), And(FreeQ(List(a, b, c, m, n, p, q, r), x), EqQ(r, Plus(q, Negate(C1))), IGtQ(p, C0)))),
            IIntegrate(2540, Int(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), r_DEFAULT), Power(x_, -1), Power(Plus(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), q_), b_DEFAULT), Times(a_DEFAULT, Power(x_, m_DEFAULT))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(Times(a, Power(x, m)), Times(b, Power(Log(Times(c, Power(x, n))), q))), Plus(p, C1)), Power(Times(b, n, q, Plus(p, C1)), -1)), x), Negate(Dist(Times(a, m, Power(Times(b, n, q), -1)), Int(Times(Power(x, Plus(m, Negate(C1))), Power(Plus(Times(a, Power(x, m)), Times(b, Power(Log(Times(c, Power(x, n))), q))), p)), x), x))), And(FreeQ(List(a, b, c, m, n, p, q, r), x), EqQ(r, Plus(q, Negate(C1))), NeQ(p, CN1)))),
            IIntegrate(2541, Int(Times(Power(x_, -1), Power(Plus(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), q_), b_DEFAULT), Times(a_DEFAULT, Power(x_, m_DEFAULT))), -1), Plus(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), r_DEFAULT), e_DEFAULT), Times(d_DEFAULT, Power(x_, m_DEFAULT)))), x_Symbol),
                    Condition(Simp(Times(e, Log(Plus(Times(a, Power(x, m)), Times(b, Power(Log(Times(c, Power(x, n))), q)))), Power(Times(b, n, q), -1)), x), And(FreeQ(List(a, b, c, d, e, m, n, q, r), x), EqQ(r, Plus(q, Negate(C1))), EqQ(Plus(Times(a, e, m), Times(CN1, b, d, n, q)), C0)))),
            IIntegrate(2542, Int(Times(Power(x_, -1), Power(Plus(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), q_), b_DEFAULT), Times(a_DEFAULT, Power(x_, m_DEFAULT))), -1), Plus(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), r_DEFAULT), e_DEFAULT), u_, Times(d_DEFAULT, Power(x_, m_DEFAULT)))), x_Symbol),
                    Condition(Plus(Simp(Times(e, Log(Plus(Times(a, Power(x, m)), Times(b, Power(Log(Times(c, Power(x, n))), q)))), Power(Times(b, n, q), -1)), x), Int(Times(u, Power(Times(x, Plus(Times(a, Power(x, m)), Times(b, Power(Log(Times(c, Power(x, n))), q)))), -1)), x)), And(FreeQ(List(a, b, c, d, e, m, n, q, r), x), EqQ(r, Plus(q, Negate(C1))), EqQ(Plus(Times(a, e, m), Times(CN1, b, d, n, q)), C0)))),
            IIntegrate(2543, Int(Times(Power(x_, -1), Power(Plus(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), q_), b_DEFAULT), Times(a_DEFAULT, Power(x_, m_DEFAULT))), -1), Plus(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), r_DEFAULT), e_DEFAULT), Times(d_DEFAULT, Power(x_, m_DEFAULT)))), x_Symbol),
                    Condition(Plus(Simp(Times(e, Log(Plus(Times(a, Power(x, m)), Times(b, Power(Log(Times(c, Power(x, n))), q)))), Power(Times(b, n, q), -1)), x), Negate(Dist(Times(Plus(Times(a, e, m), Times(CN1, b, d, n, q)), Power(Times(b, n, q), -1)), Int(Times(Power(x, Plus(m, Negate(C1))), Power(Plus(Times(a, Power(x, m)), Times(b, Power(Log(Times(c, Power(x, n))), q))), -1)), x), x))), And(FreeQ(List(a, b, c, d, e, m, n, q, r), x), EqQ(r, Plus(q, Negate(C1))), NeQ(Plus(Times(a, e, m), Times(CN1, b, d, n, q)), C0)))),
            IIntegrate(2544, Int(Times(Power(x_, -1), Power(Plus(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), q_), b_DEFAULT), Times(a_DEFAULT, Power(x_, m_DEFAULT))), p_DEFAULT), Plus(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), r_DEFAULT), e_DEFAULT), Times(d_DEFAULT, Power(x_, m_DEFAULT)))), x_Symbol),
                    Condition(Simp(Times(e, Power(Plus(Times(a, Power(x, m)), Times(b, Power(Log(Times(c, Power(x, n))), q))), Plus(p, C1)), Power(Times(b, n, q, Plus(p, C1)), -1)), x), And(FreeQ(List(a, b, c, d, e, m, n, p, q, r), x), EqQ(r, Plus(q, Negate(C1))), NeQ(p, CN1), EqQ(Plus(Times(a, e, m), Times(CN1, b, d, n, q)), C0)))),
            IIntegrate(2545, Int(Times(Power(x_, -1), Power(Plus(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), q_), b_DEFAULT), Times(a_DEFAULT, Power(x_, m_DEFAULT))), p_DEFAULT), Plus(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), r_DEFAULT), e_DEFAULT), Times(d_DEFAULT, Power(x_, m_DEFAULT)))), x_Symbol),
                    Condition(Plus(Simp(Times(e, Power(Plus(Times(a, Power(x, m)), Times(b, Power(Log(Times(c, Power(x, n))), q))), Plus(p, C1)), Power(Times(b, n, q, Plus(p, C1)), -1)), x), Negate(Dist(Times(Plus(Times(a, e, m), Times(CN1, b, d, n, q)), Power(Times(b, n, q), -1)), Int(Times(Power(x, Plus(m, Negate(C1))), Power(Plus(Times(a, Power(x, m)), Times(b, Power(Log(Times(c, Power(x, n))), q))), p)), x), x))), And(FreeQ(List(a, b, c, d, e, m, n, p, q, r), x), EqQ(r, Plus(q, Negate(C1))), NeQ(p, CN1), NeQ(Plus(Times(a, e, m), Times(CN1, b, d, n, q)), C0)))),
            IIntegrate(2546, Int(Times(Power(x_, -1), Power(Plus(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), q_), b_DEFAULT), Times(a_DEFAULT, Power(x_, m_DEFAULT))), -2), Plus(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), q_DEFAULT), f_DEFAULT), Times(d_DEFAULT, Power(x_, m_DEFAULT)), Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), e_DEFAULT, Power(x_, m_DEFAULT)))), x_Symbol),
                    Condition(Simp(Times(d, Log(Times(c, Power(x, n))), Power(Times(a, n, Plus(Times(a, Power(x, m)), Times(b, Power(Log(Times(c, Power(x, n))), q)))), -1)), x), And(FreeQ(List(a, b, c, d, e, f, m, n, q), x), EqQ(Plus(Times(e, n), Times(d, m)), C0), EqQ(Plus(Times(a, f), Times(b, d, Plus(q, Negate(C1)))), C0)))),
            IIntegrate(2547, Int(Times(Plus(Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), e_DEFAULT), d_), Power(Plus(Times(Power(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), q_), b_DEFAULT), Times(a_DEFAULT, x_)), -2)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(e, Log(Times(c, Power(x, n))), Power(Times(a, Plus(Times(a, x), Times(b, Power(Log(Times(c, Power(x, n))), q)))), -1)), x)), Dist(Times(Plus(d, Times(e, n)), Power(a, -1)), Int(Power(Times(x, Plus(Times(a, x), Times(b, Power(Log(Times(c, Power(x, n))), q)))), -1), x), x)), And(FreeQ(List(a, b, c, d, e, n, q), x), EqQ(Plus(d, Times(e, n, q)), C0)))),
            IIntegrate(2548, Int(Log(u_), x_Symbol),
                    Condition(Plus(Simp(Times(x, Log(u)), x), Negate(Int(SimplifyIntegrand(Times(x, D(u, x), Power(u, -1)), x), x))), InverseFunctionFreeQ(u, x))),
            IIntegrate(2549, Int(Log(u_), x_Symbol),
                    Condition(Plus(Simp(Times(x, Log(u)), x), Negate(Int(SimplifyIntegrand(Times(x, Simplify(Times(D(u, x), Power(u, -1)))), x), x))), ProductQ(u))),
            IIntegrate(2550, Int(Times(Log(u_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), -1)), x_Symbol),
                    Condition(Plus(Simp(Times(Log(Plus(a, Times(b, x))), Log(u), Power(b, -1)), x), Negate(Dist(Power(b, -1), Int(SimplifyIntegrand(Times(Log(Plus(a, Times(b, x))), D(u, x), Power(u, -1)), x), x), x))), And(FreeQ(List(a, b), x), RationalFunctionQ(Times(D(u, x), Power(u, -1)), x), Or(NeQ(a, C0), Not(And(BinomialQ(u, x), EqQ(Sqr(BinomialDegree(u, x)), C1)))))))
    );
}
