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
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CI;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Cot;
import static org.matheclipse.core.expression.F.Csc;
import static org.matheclipse.core.expression.F.Exp;
import static org.matheclipse.core.expression.F.FSymbol;
import static org.matheclipse.core.expression.F.F_;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.GSymbol;
import static org.matheclipse.core.expression.F.G_;
import static org.matheclipse.core.expression.F.Hypergeometric2F1;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.Module;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Pi;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sec;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Tan;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.a;
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
import static org.matheclipse.core.expression.F.f_;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.g_DEFAULT;
import static org.matheclipse.core.expression.F.h;
import static org.matheclipse.core.expression.F.h_;
import static org.matheclipse.core.expression.F.h_DEFAULT;
import static org.matheclipse.core.expression.F.i;
import static org.matheclipse.core.expression.F.i_DEFAULT;
import static org.matheclipse.core.expression.F.k;
import static org.matheclipse.core.expression.F.k_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.r;
import static org.matheclipse.core.expression.F.r_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandTrigReduce;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandTrigToExp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.G;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.H;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntHide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearMatchQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PolyQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumSimplerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.TrigQ;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules89 {
    public static IAST RULES = List(
            IIntegrate(4451, Int(Times(Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Sec(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), x_Symbol),
                    Condition(Simp(Times(Power(C2, n), Exp(Times(CI, n, Plus(d, Times(e, x)))), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Hypergeometric2F1(n, Plus(Times(C1D2, n), Times(CN1, CI, b, c, Log(FSymbol), Power(Times(C2, e), -1))), Plus(C1, Times(C1D2, n), Times(CN1, CI, b, c, Log(FSymbol), Power(Times(C2, e), -1))), Negate(Exp(Times(C2, CI, Plus(d, Times(e, x)))))), Power(Plus(Times(CI, e, n), Times(b, c, Log(FSymbol))), -1)), x), And(FreeQ(List(FSymbol, a, b, c, d, e), x), IntegerQ(n)))),
            IIntegrate(4452, Int(Times(Power(Csc(Plus(d_DEFAULT, Times(Pi, k_DEFAULT), Times(e_DEFAULT, x_))), n_DEFAULT), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), x_Symbol),
                    Condition(Simp(Times(Power(Times(CN2, CI), n), Exp(Times(CI, k, n, Pi)), Exp(Times(CI, n, Plus(d, Times(e, x)))), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Plus(Times(CI, e, n), Times(b, c, Log(FSymbol))), -1), Hypergeometric2F1(n, Plus(Times(C1D2, n), Times(CN1, CI, b, c, Log(FSymbol), Power(Times(C2, e), -1))), Plus(C1, Times(C1D2, n), Times(CN1, CI, b, c, Log(FSymbol), Power(Times(C2, e), -1))), Times(Exp(Times(C2, CI, k, Pi)), Exp(Times(C2, CI, Plus(d, Times(e, x))))))), x), And(FreeQ(List(FSymbol, a, b, c, d, e), x), IntegerQ(Times(C4, k)), IntegerQ(n)))),
            IIntegrate(4453, Int(Times(Power(Csc(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), x_Symbol),
                    Condition(Simp(Times(Power(Times(CN2, CI), n), Exp(Times(CI, n, Plus(d, Times(e, x)))), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Plus(Times(CI, e, n), Times(b, c, Log(FSymbol))), -1), Hypergeometric2F1(n, Plus(Times(C1D2, n), Times(CN1, CI, b, c, Log(FSymbol), Power(Times(C2, e), -1))), Plus(C1, Times(C1D2, n), Times(CN1, CI, b, c, Log(FSymbol), Power(Times(C2, e), -1))), Exp(Times(C2, CI, Plus(d, Times(e, x)))))), x), And(FreeQ(List(FSymbol, a, b, c, d, e), x), IntegerQ(n)))),
            IIntegrate(4454, Int(Times(Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Sec(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(C1, Exp(Times(C2, CI, Plus(d, Times(e, x))))), n), Power(Sec(Plus(d, Times(e, x))), n), Power(Exp(Times(CI, n, Plus(d, Times(e, x)))), -1)), Int(SimplifyIntegrand(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Exp(Times(CI, n, Plus(d, Times(e, x)))), Power(Power(Plus(C1, Exp(Times(C2, CI, Plus(d, Times(e, x))))), n), -1)), x), x), x), And(FreeQ(List(FSymbol, a, b, c, d, e), x), Not(IntegerQ(n))))),
            IIntegrate(4455, Int(Times(Power(Csc(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), x_Symbol),
                    Condition(Dist(Times(Power(Plus(C1, Negate(Exp(Times(CN2, CI, Plus(d, Times(e, x)))))), n), Power(Csc(Plus(d, Times(e, x))), n), Power(Exp(Times(CN1, CI, n, Plus(d, Times(e, x)))), -1)), Int(SimplifyIntegrand(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Times(Exp(Times(CI, n, Plus(d, Times(e, x)))), Power(Plus(C1, Negate(Exp(Times(CN2, CI, Plus(d, Times(e, x)))))), n)), -1)), x), x), x), And(FreeQ(List(FSymbol, a, b, c, d, e), x), Not(IntegerQ(n))))),
            IIntegrate(4456, Int(Times(Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Plus(f_, Times(g_DEFAULT, Sin(Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(C2, n), Power(f, n)), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Cos(Plus(Times(C1D2, d), Times(C1D2, e, x), Times(CN1, f, Pi, Power(Times(C4, g), -1)))), Times(C2, n))), x), x), And(FreeQ(List(FSymbol, a, b, c, d, e, f, g), x), EqQ(Plus(Sqr(f), Negate(Sqr(g))), C0), ILtQ(n, C0)))),
            IIntegrate(4457, Int(Times(Power(Plus(Times(Cos(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), g_DEFAULT), f_), n_DEFAULT), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), x_Symbol),
                    Condition(Dist(Times(Power(C2, n), Power(f, n)), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Cos(Plus(Times(C1D2, d), Times(C1D2, e, x))), Times(C2, n))), x), x), And(FreeQ(List(FSymbol, a, b, c, d, e, f, g), x), EqQ(Plus(f, Negate(g)), C0), ILtQ(n, C0)))),
            IIntegrate(4458, Int(Times(Power(Plus(Times(Cos(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), g_DEFAULT), f_), n_DEFAULT), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), x_Symbol),
                    Condition(Dist(Times(Power(C2, n), Power(f, n)), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Sin(Plus(Times(C1D2, d), Times(C1D2, e, x))), Times(C2, n))), x), x), And(FreeQ(List(FSymbol, a, b, c, d, e, f, g), x), EqQ(Plus(f, g), C0), ILtQ(n, C0)))),
            IIntegrate(4459, Int(Times(Power(Cos(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Plus(f_, Times(g_DEFAULT, Sin(Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(g, n), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Tan(Plus(Times(f, Pi, Power(Times(C4, g), -1)), Times(CN1, C1D2, d), Times(CN1, C1D2, e, x))), m)), x), x), And(FreeQ(List(FSymbol, a, b, c, d, e, f, g), x), EqQ(Plus(Sqr(f), Negate(Sqr(g))), C0), IntegersQ(m, n), EqQ(Plus(m, n), C0)))),
            IIntegrate(4460, Int(Times(Power(Plus(Times(Cos(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), g_DEFAULT), f_), n_DEFAULT), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Sin(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(f, n), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Tan(Plus(Times(C1D2, d), Times(C1D2, e, x))), m)), x), x), And(FreeQ(List(FSymbol, a, b, c, d, e, f, g), x), EqQ(Plus(f, Negate(g)), C0), IntegersQ(m, n), EqQ(Plus(m, n), C0)))),
            IIntegrate(4461, Int(Times(Power(Plus(Times(Cos(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), g_DEFAULT), f_), n_DEFAULT), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Sin(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(f, n), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Cot(Plus(Times(C1D2, d), Times(C1D2, e, x))), m)), x), x), And(FreeQ(List(FSymbol, a, b, c, d, e, f, g), x), EqQ(Plus(f, g), C0), IntegersQ(m, n), EqQ(Plus(m, n), C0)))),
            IIntegrate(4462, Int(Times(Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Plus(Times(Cos(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), i_DEFAULT), h_), Power(Plus(f_, Times(g_DEFAULT, Sin(Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), -1)), x_Symbol),
                    Condition(Plus(Dist(Times(C2, i), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Cos(Plus(d, Times(e, x))), Power(Plus(f, Times(g, Sin(Plus(d, Times(e, x))))), -1)), x), x), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Plus(h, Times(CN1, i, Cos(Plus(d, Times(e, x))))), Power(Plus(f, Times(g, Sin(Plus(d, Times(e, x))))), -1)), x)), And(FreeQ(List(FSymbol, a, b, c, d, e, f, g, h, i), x), EqQ(Plus(Sqr(f), Negate(Sqr(g))), C0), EqQ(Plus(Sqr(h), Negate(Sqr(i))), C0), EqQ(Plus(Times(g, h), Times(CN1, f, i)), C0)))),
            IIntegrate(4463, Int(Times(Power(Plus(Times(Cos(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), g_DEFAULT), f_), -1), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Plus(h_, Times(i_DEFAULT, Sin(Plus(d_DEFAULT, Times(e_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Dist(Times(C2, i), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Sin(Plus(d, Times(e, x))), Power(Plus(f, Times(g, Cos(Plus(d, Times(e, x))))), -1)), x), x), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Plus(h, Times(CN1, i, Sin(Plus(d, Times(e, x))))), Power(Plus(f, Times(g, Cos(Plus(d, Times(e, x))))), -1)), x)), And(FreeQ(List(FSymbol, a, b, c, d, e, f, g, h, i), x), EqQ(Plus(Sqr(f), Negate(Sqr(g))), C0), EqQ(Plus(Sqr(h), Negate(Sqr(i))), C0), EqQ(Plus(Times(g, h), Times(f, i)), C0)))),
            IIntegrate(4464, Int(Times(Power(F_, Times(c_DEFAULT, u_)), Power($(G_, v_), n_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(FSymbol, Times(c, ExpandToSum(u, x))), Power(G(ExpandToSum(v, x)), n)), x), And(FreeQ(List(FSymbol, c, n), x), TrigQ(GSymbol), LinearQ(List(u, v), x), Not(LinearMatchQ(List(u, v), x))))),
            IIntegrate(4465, Int(Times(Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Sin(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), x_Symbol),
                    Condition(Module(List(Set(u, IntHide(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Sin(Plus(d, Times(e, x))), n)), x))), Plus(Dist(Power(Times(f, x), m), u, x), Negate(Dist(Times(f, m), Int(Times(Power(Times(f, x), Plus(m, Negate(C1))), u), x), x)))), And(FreeQ(List(FSymbol, a, b, c, d, e, f), x), IGtQ(n, C0), GtQ(m, C0)))),
            IIntegrate(4466, Int(Times(Power(Cos(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Times(f_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Module(List(Set(u, IntHide(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Cos(Plus(d, Times(e, x))), n)), x))), Plus(Dist(Power(Times(f, x), m), u, x), Negate(Dist(Times(f, m), Int(Times(Power(Times(f, x), Plus(m, Negate(C1))), u), x), x)))), And(FreeQ(List(FSymbol, a, b, c, d, e, f), x), IGtQ(n, C0), GtQ(m, C0)))),
            IIntegrate(4467, Int(Times(Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Times(f_DEFAULT, x_), m_), Sin(Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(f, x), Plus(m, C1)), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Sin(Plus(d, Times(e, x))), Power(Times(f, Plus(m, C1)), -1)), x), Negate(Dist(Times(e, Power(Times(f, Plus(m, C1)), -1)), Int(Times(Power(Times(f, x), Plus(m, C1)), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Cos(Plus(d, Times(e, x)))), x), x)), Negate(Dist(Times(b, c, Log(FSymbol), Power(Times(f, Plus(m, C1)), -1)), Int(Times(Power(Times(f, x), Plus(m, C1)), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Sin(Plus(d, Times(e, x)))), x), x))), And(FreeQ(List(FSymbol, a, b, c, d, e, f, m), x), Or(LtQ(m, CN1), SumSimplerQ(m, C1))))),
            IIntegrate(4468, Int(Times(Cos(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Times(f_DEFAULT, x_), m_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(f, x), Plus(m, C1)), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Cos(Plus(d, Times(e, x))), Power(Times(f, Plus(m, C1)), -1)), x), Dist(Times(e, Power(Times(f, Plus(m, C1)), -1)), Int(Times(Power(Times(f, x), Plus(m, C1)), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Sin(Plus(d, Times(e, x)))), x), x), Negate(Dist(Times(b, c, Log(FSymbol), Power(Times(f, Plus(m, C1)), -1)), Int(Times(Power(Times(f, x), Plus(m, C1)), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Cos(Plus(d, Times(e, x)))), x), x))), And(FreeQ(List(FSymbol, a, b, c, d, e, f, m), x), Or(LtQ(m, CN1), SumSimplerQ(m, C1))))),
            IIntegrate(4469, Int(Times(Power(Cos(Plus(f_DEFAULT, Times(g_DEFAULT, x_))), n_DEFAULT), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Sin(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrigReduce(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Times(Power(Sin(Plus(d, Times(e, x))), m), Power(Cos(Plus(f, Times(g, x))), n)), x), x), And(FreeQ(List(FSymbol, a, b, c, d, e, f, g), x), IGtQ(m, C0), IGtQ(n, C0)))),
            IIntegrate(4470, Int(Times(Power(Cos(Plus(f_DEFAULT, Times(g_DEFAULT, x_))), n_DEFAULT), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(x_, p_DEFAULT), Power(Sin(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrigReduce(Times(Power(x, p), Power(FSymbol, Times(c, Plus(a, Times(b, x))))), Times(Power(Sin(Plus(d, Times(e, x))), m), Power(Cos(Plus(f, Times(g, x))), n)), x), x), And(FreeQ(List(FSymbol, a, b, c, d, e, f, g), x), IGtQ(m, C0), IGtQ(n, C0), IGtQ(p, C0)))),
            IIntegrate(4471, Int(Times(Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power($(G_, Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power($($p("H"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrigToExp(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Times(Power(G(Plus(d, Times(e, x))), m), Power(H(Plus(d, Times(e, x))), n)), x), x), And(FreeQ(List(FSymbol, a, b, c, d, e), x), IGtQ(m, C0), IGtQ(n, C0), TrigQ(GSymbol), TrigQ($s("H"))))),
            IIntegrate(4472, Int(Times(Power(F_, u_), Power(Sin(v_), n_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrigToExp(Power(FSymbol, u), Power(Sin(v), n), x), x), And(FreeQ(FSymbol, x), Or(LinearQ(u, x), PolyQ(u, x, C2)), Or(LinearQ(v, x), PolyQ(v, x, C2)), IGtQ(n, C0)))),
            IIntegrate(4473, Int(Times(Power(Cos(v_), n_DEFAULT), Power(F_, u_)), x_Symbol),
                    Condition(Int(ExpandTrigToExp(Power(FSymbol, u), Power(Cos(v), n), x), x), And(FreeQ(FSymbol, x), Or(LinearQ(u, x), PolyQ(u, x, C2)), Or(LinearQ(v, x), PolyQ(v, x, C2)), IGtQ(n, C0)))),
            IIntegrate(4474, Int(Times(Power(Cos(v_), n_DEFAULT), Power(F_, u_), Power(Sin(v_), m_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrigToExp(Power(FSymbol, u), Times(Power(Sin(v), m), Power(Cos(v), n)), x), x), And(FreeQ(FSymbol, x), Or(LinearQ(u, x), PolyQ(u, x, C2)), Or(LinearQ(v, x), PolyQ(v, x, C2)), IGtQ(m, C0), IGtQ(n, C0)))),
            IIntegrate(4475, Int(Sin(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(x, Sin(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Plus(Times(Sqr(b), Sqr(d), Sqr(n)), C1), -1)), x), Negate(Simp(Times(b, d, n, x, Cos(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Plus(Times(Sqr(b), Sqr(d), Sqr(n)), C1), -1)), x))), And(FreeQ(List(a, b, c, d, n), x), NeQ(Plus(Times(Sqr(b), Sqr(d), Sqr(n)), C1), C0)))),
            IIntegrate(4476, Int(Cos(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(x, Cos(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Plus(Times(Sqr(b), Sqr(d), Sqr(n)), C1), -1)), x), Simp(Times(b, d, n, x, Sin(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Plus(Times(Sqr(b), Sqr(d), Sqr(n)), C1), -1)), x)), And(FreeQ(List(a, b, c, d, n), x), NeQ(Plus(Times(Sqr(b), Sqr(d), Sqr(n)), C1), C0)))),
            IIntegrate(4477, Int(Power(Sin(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), p_), x_Symbol),
                    Condition(Plus(Simp(Times(x, Power(Sin(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), p), Power(Plus(Times(Sqr(b), Sqr(d), Sqr(n), Sqr(p)), C1), -1)), x), Dist(Times(Sqr(b), Sqr(d), Sqr(n), p, Plus(p, Negate(C1)), Power(Plus(Times(Sqr(b), Sqr(d), Sqr(n), Sqr(p)), C1), -1)), Int(Power(Sin(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Plus(p, Negate(C2))), x), x), Negate(Simp(Times(b, d, n, p, x, Cos(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Sin(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Plus(p, Negate(C1))), Power(Plus(Times(Sqr(b), Sqr(d), Sqr(n), Sqr(p)), C1), -1)), x))), And(FreeQ(List(a, b, c, d, n), x), IGtQ(p, C1), NeQ(Plus(Times(Sqr(b), Sqr(d), Sqr(n), Sqr(p)), C1), C0)))),
            IIntegrate(4478, Int(Power(Cos(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), p_), x_Symbol),
                    Condition(Plus(Simp(Times(x, Power(Cos(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), p), Power(Plus(Times(Sqr(b), Sqr(d), Sqr(n), Sqr(p)), C1), -1)), x), Dist(Times(Sqr(b), Sqr(d), Sqr(n), p, Plus(p, Negate(C1)), Power(Plus(Times(Sqr(b), Sqr(d), Sqr(n), Sqr(p)), C1), -1)), Int(Power(Cos(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Plus(p, Negate(C2))), x), x), Simp(Times(b, d, n, p, x, Power(Cos(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Plus(p, Negate(C1))), Sin(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Plus(Times(Sqr(b), Sqr(d), Sqr(n), Sqr(p)), C1), -1)), x)), And(FreeQ(List(a, b, c, d, n), x), IGtQ(p, C1), NeQ(Plus(Times(Sqr(b), Sqr(d), Sqr(n), Sqr(p)), C1), C0)))),
            IIntegrate(4479, Int(Power(Sin(Times(Plus(a_DEFAULT, Times(Log(x_), b_DEFAULT)), d_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Power(Times(Power(C2, p), Power(b, p), Power(d, p), Power(p, p)), -1), Int(ExpandIntegrand(Power(Plus(Times(Exp(Times(a, b, Sqr(d), p)), Power(Power(x, Power(p, -1)), -1)), Times(CN1, Power(x, Power(p, -1)), Power(Exp(Times(a, b, Sqr(d), p)), -1))), p), x), x), x), And(FreeQ(List(a, b, d), x), IGtQ(p, C0), EqQ(Plus(Times(Sqr(b), Sqr(d), Sqr(p)), C1), C0)))),
            IIntegrate(4480, Int(Power(Cos(Times(Plus(a_DEFAULT, Times(Log(x_), b_DEFAULT)), d_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Power(Power(C2, p), -1), Int(ExpandIntegrand(Power(Plus(Times(Exp(Times(a, b, Sqr(d), p)), Power(Power(x, Power(p, -1)), -1)), Times(Power(x, Power(p, -1)), Power(Exp(Times(a, b, Sqr(d), p)), -1))), p), x), x), x), And(FreeQ(List(a, b, d), x), IGtQ(p, C0), EqQ(Plus(Times(Sqr(b), Sqr(d), Sqr(p)), C1), C0)))),
            IIntegrate(4481, Int(Power(Sin(Times(Plus(a_DEFAULT, Times(Log(x_), b_DEFAULT)), d_DEFAULT)), p_), x_Symbol),
                    Condition(Dist(Times(Power(Sin(Times(d, Plus(a, Times(b, Log(x))))), p), Power(x, Times(CI, b, d, p)), Power(Power(Plus(C1, Times(CN1, Exp(Times(C2, CI, a, d)), Power(x, Times(C2, CI, b, d)))), p), -1)), Int(Times(Power(Plus(C1, Times(CN1, Exp(Times(C2, CI, a, d)), Power(x, Times(C2, CI, b, d)))), p), Power(Power(x, Times(CI, b, d, p)), -1)), x), x), And(FreeQ(List(a, b, d, p), x), Not(IntegerQ(p))))),
            IIntegrate(4482, Int(Power(Cos(Times(Plus(a_DEFAULT, Times(Log(x_), b_DEFAULT)), d_DEFAULT)), p_), x_Symbol),
                    Condition(Dist(Times(Power(Cos(Times(d, Plus(a, Times(b, Log(x))))), p), Power(x, Times(CI, b, d, p)), Power(Power(Plus(C1, Times(Exp(Times(C2, CI, a, d)), Power(x, Times(C2, CI, b, d)))), p), -1)), Int(Times(Power(Plus(C1, Times(Exp(Times(C2, CI, a, d)), Power(x, Times(C2, CI, b, d)))), p), Power(Power(x, Times(CI, b, d, p)), -1)), x), x), And(FreeQ(List(a, b, d, p), x), Not(IntegerQ(p))))),
            IIntegrate(4483, Int(Power(Sin(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Times(x, Power(Times(n, Power(Times(c, Power(x, n)), Power(n, -1))), -1)), Subst(Int(Times(Power(x, Plus(Power(n, -1), Negate(C1))), Power(Sin(Times(d, Plus(a, Times(b, Log(x))))), p)), x), x, Times(c, Power(x, n))), x), And(FreeQ(List(a, b, c, d, n, p), x), Or(NeQ(c, C1), NeQ(n, C1))))),
            IIntegrate(4484, Int(Power(Cos(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Times(x, Power(Times(n, Power(Times(c, Power(x, n)), Power(n, -1))), -1)), Subst(Int(Times(Power(x, Plus(Power(n, -1), Negate(C1))), Power(Cos(Times(d, Plus(a, Times(b, Log(x))))), p)), x), x, Times(c, Power(x, n))), x), And(FreeQ(List(a, b, c, d, n, p), x), Or(NeQ(c, C1), NeQ(n, C1))))),
            IIntegrate(4485, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Sin(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT))), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(m, C1), Power(Times(e, x), Plus(m, C1)), Sin(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Plus(Times(Sqr(b), Sqr(d), e, Sqr(n)), Times(e, Sqr(Plus(m, C1)))), -1)), x), Negate(Simp(Times(b, d, n, Power(Times(e, x), Plus(m, C1)), Cos(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Plus(Times(Sqr(b), Sqr(d), e, Sqr(n)), Times(e, Sqr(Plus(m, C1)))), -1)), x))), And(FreeQ(List(a, b, c, d, e, m, n), x), NeQ(Plus(Times(Sqr(b), Sqr(d), Sqr(n)), Sqr(Plus(m, C1))), C0)))),
            IIntegrate(4486, Int(Times(Cos(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(m, C1), Power(Times(e, x), Plus(m, C1)), Cos(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Plus(Times(Sqr(b), Sqr(d), e, Sqr(n)), Times(e, Sqr(Plus(m, C1)))), -1)), x), Simp(Times(b, d, n, Power(Times(e, x), Plus(m, C1)), Sin(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Plus(Times(Sqr(b), Sqr(d), e, Sqr(n)), Times(e, Sqr(Plus(m, C1)))), -1)), x)), And(FreeQ(List(a, b, c, d, e, m, n), x), NeQ(Plus(Times(Sqr(b), Sqr(d), Sqr(n)), Sqr(Plus(m, C1))), C0)))),
            IIntegrate(4487, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Sin(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(m, C1), Power(Times(e, x), Plus(m, C1)), Power(Sin(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), p), Power(Plus(Times(Sqr(b), Sqr(d), e, Sqr(n), Sqr(p)), Times(e, Sqr(Plus(m, C1)))), -1)), x), Dist(Times(Sqr(b), Sqr(d), Sqr(n), p, Plus(p, Negate(C1)), Power(Plus(Times(Sqr(b), Sqr(d), Sqr(n), Sqr(p)), Sqr(Plus(m, C1))), -1)), Int(Times(Power(Times(e, x), m), Power(Sin(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Plus(p, Negate(C2)))), x), x), Negate(Simp(Times(b, d, n, p, Power(Times(e, x), Plus(m, C1)), Cos(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Sin(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Plus(p, Negate(C1))), Power(Plus(Times(Sqr(b), Sqr(d), e, Sqr(n), Sqr(p)), Times(e, Sqr(Plus(m, C1)))), -1)), x))), And(FreeQ(List(a, b, c, d, e, m, n), x), IGtQ(p, C1), NeQ(Plus(Times(Sqr(b), Sqr(d), Sqr(n), Sqr(p)), Sqr(Plus(m, C1))), C0)))),
            IIntegrate(4488, Int(Times(Power(Cos(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), p_), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(m, C1), Power(Times(e, x), Plus(m, C1)), Power(Cos(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), p), Power(Plus(Times(Sqr(b), Sqr(d), e, Sqr(n), Sqr(p)), Times(e, Sqr(Plus(m, C1)))), -1)), x), Dist(Times(Sqr(b), Sqr(d), Sqr(n), p, Plus(p, Negate(C1)), Power(Plus(Times(Sqr(b), Sqr(d), Sqr(n), Sqr(p)), Sqr(Plus(m, C1))), -1)), Int(Times(Power(Times(e, x), m), Power(Cos(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Plus(p, Negate(C2)))), x), x), Simp(Times(b, d, n, p, Power(Times(e, x), Plus(m, C1)), Sin(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Cos(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Plus(p, Negate(C1))), Power(Plus(Times(Sqr(b), Sqr(d), e, Sqr(n), Sqr(p)), Times(e, Sqr(Plus(m, C1)))), -1)), x)), And(FreeQ(List(a, b, c, d, e, m, n), x), IGtQ(p, C1), NeQ(Plus(Times(Sqr(b), Sqr(d), Sqr(n), Sqr(p)), Sqr(Plus(m, C1))), C0)))),
            IIntegrate(4489, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Sin(Times(Plus(a_DEFAULT, Times(Log(x_), b_DEFAULT)), d_DEFAULT)), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(m, C1), p), Power(Times(Power(C2, p), Power(b, p), Power(d, p), Power(p, p)), -1)), Int(ExpandIntegrand(Times(Power(Times(e, x), m), Power(Plus(Times(Exp(Times(a, b, Sqr(d), p, Power(Plus(m, C1), -1))), Power(Power(x, Times(Plus(m, C1), Power(p, -1))), -1)), Times(CN1, Power(x, Times(Plus(m, C1), Power(p, -1))), Power(Exp(Times(a, b, Sqr(d), p, Power(Plus(m, C1), -1))), -1))), p)), x), x), x), And(FreeQ(List(a, b, d, e, m), x), IGtQ(p, C0), EqQ(Plus(Times(Sqr(b), Sqr(d), Sqr(p)), Sqr(Plus(m, C1))), C0)))),
            IIntegrate(4490, Int(Times(Power(Cos(Times(Plus(a_DEFAULT, Times(Log(x_), b_DEFAULT)), d_DEFAULT)), p_DEFAULT), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Power(C2, p), -1), Int(ExpandIntegrand(Times(Power(Times(e, x), m), Power(Plus(Times(Exp(Times(a, b, Sqr(d), p, Power(Plus(m, C1), -1))), Power(Power(x, Times(Plus(m, C1), Power(p, -1))), -1)), Times(Power(x, Times(Plus(m, C1), Power(p, -1))), Power(Exp(Times(a, b, Sqr(d), p, Power(Plus(m, C1), -1))), -1))), p)), x), x), x), And(FreeQ(List(a, b, d, e, m), x), IGtQ(p, C0), EqQ(Plus(Times(Sqr(b), Sqr(d), Sqr(p)), Sqr(Plus(m, C1))), C0)))),
            IIntegrate(4491, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Sin(Times(Plus(a_DEFAULT, Times(Log(x_), b_DEFAULT)), d_DEFAULT)), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Sin(Times(d, Plus(a, Times(b, Log(x))))), p), Power(x, Times(CI, b, d, p)), Power(Power(Plus(C1, Times(CN1, Exp(Times(C2, CI, a, d)), Power(x, Times(C2, CI, b, d)))), p), -1)), Int(Times(Power(Times(e, x), m), Power(Plus(C1, Times(CN1, Exp(Times(C2, CI, a, d)), Power(x, Times(C2, CI, b, d)))), p), Power(Power(x, Times(CI, b, d, p)), -1)), x), x), And(FreeQ(List(a, b, d, e, m, p), x), Not(IntegerQ(p))))),
            IIntegrate(4492, Int(Times(Power(Cos(Times(Plus(a_DEFAULT, Times(Log(x_), b_DEFAULT)), d_DEFAULT)), p_), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Cos(Times(d, Plus(a, Times(b, Log(x))))), p), Power(x, Times(CI, b, d, p)), Power(Power(Plus(C1, Times(Exp(Times(C2, CI, a, d)), Power(x, Times(C2, CI, b, d)))), p), -1)), Int(Times(Power(Times(e, x), m), Power(Plus(C1, Times(Exp(Times(C2, CI, a, d)), Power(x, Times(C2, CI, b, d)))), p), Power(Power(x, Times(CI, b, d, p)), -1)), x), x), And(FreeQ(List(a, b, d, e, m, p), x), Not(IntegerQ(p))))),
            IIntegrate(4493, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Sin(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Times(e, x), Plus(m, C1)), Power(Times(e, n, Power(Times(c, Power(x, n)), Times(Plus(m, C1), Power(n, -1)))), -1)), Subst(Int(Times(Power(x, Plus(Times(Plus(m, C1), Power(n, -1)), Negate(C1))), Power(Sin(Times(d, Plus(a, Times(b, Log(x))))), p)), x), x, Times(c, Power(x, n))), x), And(FreeQ(List(a, b, c, d, e, m, n, p), x), Or(NeQ(c, C1), NeQ(n, C1))))),
            IIntegrate(4494, Int(Times(Power(Cos(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), p_DEFAULT), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Times(e, x), Plus(m, C1)), Power(Times(e, n, Power(Times(c, Power(x, n)), Times(Plus(m, C1), Power(n, -1)))), -1)), Subst(Int(Times(Power(x, Plus(Times(Plus(m, C1), Power(n, -1)), Negate(C1))), Power(Cos(Times(d, Plus(a, Times(b, Log(x))))), p)), x), x, Times(c, Power(x, n))), x), And(FreeQ(List(a, b, c, d, e, m, n, p), x), Or(NeQ(c, C1), NeQ(n, C1))))),
            IIntegrate(4495, Int(Times(Power(Times(Plus(e_DEFAULT, Times(Log(Times(g_DEFAULT, Power(x_, m_DEFAULT))), f_DEFAULT)), h_DEFAULT), q_DEFAULT), Sin(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT))), x_Symbol),
                    Condition(Plus(Dist(Times(CI, Power(Times(Exp(Times(CI, a, d)), Power(Times(c, Power(x, n)), Times(CI, b, d)), C2, Power(Power(x, Times(CI, b, d, n)), -1)), -1)), Int(Times(Power(Times(h, Plus(e, Times(f, Log(Times(g, Power(x, m)))))), q), Power(Power(x, Times(CI, b, d, n)), -1)), x), x), Negate(Dist(Times(CI, Exp(Times(CI, a, d)), Power(Times(c, Power(x, n)), Times(CI, b, d)), Power(Times(C2, Power(x, Times(CI, b, d, n))), -1)), Int(Times(Power(x, Times(CI, b, d, n)), Power(Times(h, Plus(e, Times(f, Log(Times(g, Power(x, m)))))), q)), x), x))), FreeQ(List(a, b, c, d, e, f, g, h, m, n, q), x))),
            IIntegrate(4496, Int(Times(Cos(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), Power(Times(Plus(e_DEFAULT, Times(Log(Times(g_DEFAULT, Power(x_, m_DEFAULT))), f_DEFAULT)), h_DEFAULT), q_DEFAULT)), x_Symbol),
                    Condition(Plus(Dist(Power(Times(Exp(Times(CI, a, d)), Power(Times(c, Power(x, n)), Times(CI, b, d)), C2, Power(Power(x, Times(CI, b, d, n)), -1)), -1), Int(Times(Power(Times(h, Plus(e, Times(f, Log(Times(g, Power(x, m)))))), q), Power(Power(x, Times(CI, b, d, n)), -1)), x), x), Dist(Times(Exp(Times(CI, a, d)), Power(Times(c, Power(x, n)), Times(CI, b, d)), Power(Times(C2, Power(x, Times(CI, b, d, n))), -1)), Int(Times(Power(x, Times(CI, b, d, n)), Power(Times(h, Plus(e, Times(f, Log(Times(g, Power(x, m)))))), q)), x), x)), FreeQ(List(a, b, c, d, e, f, g, h, m, n, q), x))),
            IIntegrate(4497, Int(Times(Power(Times(Plus(e_DEFAULT, Times(Log(Times(g_DEFAULT, Power(x_, m_DEFAULT))), f_DEFAULT)), h_DEFAULT), q_DEFAULT), Power(Times(i_DEFAULT, x_), r_DEFAULT), Sin(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT))), x_Symbol),
                    Condition(Plus(Dist(Times(CI, Power(Times(i, x), r), Power(Times(Exp(Times(CI, a, d)), Power(Times(c, Power(x, n)), Times(CI, b, d)), C2, Power(x, Plus(r, Times(CN1, CI, b, d, n)))), -1)), Int(Times(Power(x, Plus(r, Times(CN1, CI, b, d, n))), Power(Times(h, Plus(e, Times(f, Log(Times(g, Power(x, m)))))), q)), x), x), Negate(Dist(Times(CI, Exp(Times(CI, a, d)), Power(Times(i, x), r), Power(Times(c, Power(x, n)), Times(CI, b, d)), Power(Times(C2, Power(x, Plus(r, Times(CI, b, d, n)))), -1)), Int(Times(Power(x, Plus(r, Times(CI, b, d, n))), Power(Times(h, Plus(e, Times(f, Log(Times(g, Power(x, m)))))), q)), x), x))), FreeQ(List(a, b, c, d, e, f, g, h, i, m, n, q, r), x))),
            IIntegrate(4498, Int(Times(Cos(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), Power(Times(Plus(e_DEFAULT, Times(Log(Times(g_DEFAULT, Power(x_, m_DEFAULT))), f_DEFAULT)), h_DEFAULT), q_DEFAULT), Power(Times(i_DEFAULT, x_), r_DEFAULT)), x_Symbol),
                    Condition(Plus(Dist(Times(Power(Times(i, x), r), Power(Times(Exp(Times(CI, a, d)), Power(Times(c, Power(x, n)), Times(CI, b, d)), C2, Power(x, Plus(r, Times(CN1, CI, b, d, n)))), -1)), Int(Times(Power(x, Plus(r, Times(CN1, CI, b, d, n))), Power(Times(h, Plus(e, Times(f, Log(Times(g, Power(x, m)))))), q)), x), x), Dist(Times(Exp(Times(CI, a, d)), Power(Times(i, x), r), Power(Times(c, Power(x, n)), Times(CI, b, d)), Power(Times(C2, Power(x, Plus(r, Times(CI, b, d, n)))), -1)), Int(Times(Power(x, Plus(r, Times(CI, b, d, n))), Power(Times(h, Plus(e, Times(f, Log(Times(g, Power(x, m)))))), q)), x), x)), FreeQ(List(a, b, c, d, e, f, g, h, i, m, n, q, r), x))),
            IIntegrate(4499, Int(Power(Sec(Times(Plus(a_DEFAULT, Times(Log(x_), b_DEFAULT)), d_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Times(Power(C2, p), Exp(Times(CI, a, d, p))), Int(Times(Power(x, Times(CI, b, d, p)), Power(Power(Plus(C1, Times(Exp(Times(C2, CI, a, d)), Power(x, Times(C2, CI, b, d)))), p), -1)), x), x), And(FreeQ(List(a, b, d), x), IntegerQ(p)))),
            IIntegrate(4500, Int(Power(Csc(Times(Plus(a_DEFAULT, Times(Log(x_), b_DEFAULT)), d_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Times(Power(Times(CN2, CI), p), Exp(Times(CI, a, d, p))), Int(Times(Power(x, Times(CI, b, d, p)), Power(Power(Plus(C1, Times(CN1, Exp(Times(C2, CI, a, d)), Power(x, Times(C2, CI, b, d)))), p), -1)), x), x), And(FreeQ(List(a, b, d), x), IntegerQ(p))))
    );
}
