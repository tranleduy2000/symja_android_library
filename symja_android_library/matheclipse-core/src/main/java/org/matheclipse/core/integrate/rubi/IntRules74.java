package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.ASymbol;
import static org.matheclipse.core.expression.F.A_;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.BSymbol;
import static org.matheclipse.core.expression.F.B_DEFAULT;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CI;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Coefficient;
import static org.matheclipse.core.expression.F.Complex;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Cot;
import static org.matheclipse.core.expression.F.Coth;
import static org.matheclipse.core.expression.F.Exp;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.If;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.MatchQ;
import static org.matheclipse.core.expression.F.Module;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Pi;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Simplify;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Tan;
import static org.matheclipse.core.expression.F.Tanh;
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
import static org.matheclipse.core.expression.F.j_;
import static org.matheclipse.core.expression.F.k;
import static org.matheclipse.core.expression.F.k_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialMatchQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandTrig;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FreeFactors;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntHide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearMatchQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules74 {
    public static IAST RULES = List(
            IIntegrate(3701, Int(Times(Power($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(Times($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), f_DEFAULT), n_DEFAULT)), Times(c_DEFAULT, Power(Times($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), f_DEFAULT), $p("n2", true)))), p_)), x_Symbol),
                    Condition(Negate(Dist(Times(f, Power(e, -1)), Subst(Int(Times(Power(Times(x, Power(f, -1)), m), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p), Power(Plus(Sqr(f), Sqr(x)), -1)), x), x, Times(f, Cot(Plus(d, Times(e, x))))), x)), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), EqQ($s("n2"), Times(C2, n)), NeQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0)))),
            IIntegrate(3702, Int(Times(Power($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), Times(c_DEFAULT, Power($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Times(Power(C4, p), Power(c, p)), -1), Int(Times(Power(Cot(Plus(d, Times(e, x))), m), Power(Plus(b, Times(C2, c, Power(Tan(Plus(d, Times(e, x))), n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, m, n), x), EqQ($s("n2"), Times(C2, n)), EqQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), IntegerQ(p)))),
            IIntegrate(3703, Int(Times(Power(Plus(a_DEFAULT, Times(Power($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), b_DEFAULT), Times(Power($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)), c_DEFAULT)), p_DEFAULT), Power($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Times(Power(C4, p), Power(c, p)), -1), Int(Times(Power(Tan(Plus(d, Times(e, x))), m), Power(Plus(b, Times(C2, c, Power(Cot(Plus(d, Times(e, x))), n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, m, n), x), EqQ($s("n2"), Times(C2, n)), EqQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), IntegerQ(p)))),
            IIntegrate(3704, Int(Times(Power($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), Times(c_DEFAULT, Power($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Power(Tan(Plus(d, Times(e, x))), n)), Times(c, Power(Tan(Plus(d, Times(e, x))), Times(C2, n)))), p), Power(Power(Plus(b, Times(C2, c, Power(Tan(Plus(d, Times(e, x))), n))), Times(C2, p)), -1)), Int(Times(Power(Cot(Plus(d, Times(e, x))), m), Power(Plus(b, Times(C2, c, Power(Tan(Plus(d, Times(e, x))), n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, m, n, p), x), EqQ($s("n2"), Times(C2, n)), EqQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), Not(IntegerQ(p))))),
            IIntegrate(3705, Int(Times(Power(Plus(a_DEFAULT, Times(Power($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), b_DEFAULT), Times(Power($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)), c_DEFAULT)), p_), Power($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Power(Cot(Plus(d, Times(e, x))), n)), Times(c, Power(Cot(Plus(d, Times(e, x))), Times(C2, n)))), p), Power(Power(Plus(b, Times(C2, c, Power(Cot(Plus(d, Times(e, x))), n))), Times(C2, p)), -1)), Int(Times(Power(Tan(Plus(d, Times(e, x))), m), Power(Plus(b, Times(C2, c, Power(Cot(Plus(d, Times(e, x))), n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, m, n, p), x), EqQ($s("n2"), Times(C2, n)), EqQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), Not(IntegerQ(p))))),
            IIntegrate(3706, Int(Times(Power($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_)), Times(c_DEFAULT, Power($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2")))), p_DEFAULT)), x_Symbol),
                    Condition(Module(List(Set(g, FreeFactors(Cot(Plus(d, Times(e, x))), x))), Dist(Times(g, Power(e, -1)), Subst(Int(Times(Power(Times(g, x), Plus(m, Times(CN1, C2, n, p))), Power(Plus(c, Times(b, Power(Times(g, x), n)), Times(a, Power(Times(g, x), Times(C2, n)))), p), Power(Plus(C1, Times(Sqr(g), Sqr(x))), -1)), x), x, Times(Cot(Plus(d, Times(e, x))), Power(g, -1))), x)), And(FreeQ(List(a, b, c, d, e, m, p), x), EqQ($s("n2"), Times(C2, n)), NeQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), IntegerQ(Times(C1D2, n))))),
            IIntegrate(3707, Int(Times(Power(Plus(a_DEFAULT, Times(Power($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_), b_DEFAULT), Times(Power($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2")), c_DEFAULT)), p_DEFAULT), Power($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT)), x_Symbol),
                    Condition(Module(List(Set(g, FreeFactors(Tan(Plus(d, Times(e, x))), x))), Negate(Dist(Times(g, Power(e, -1)), Subst(Int(Times(Power(Times(g, x), Plus(m, Times(CN1, C2, n, p))), Power(Plus(c, Times(b, Power(Times(g, x), n)), Times(a, Power(Times(g, x), Times(C2, n)))), p), Power(Plus(C1, Times(Sqr(g), Sqr(x))), -1)), x), x, Times(Tan(Plus(d, Times(e, x))), Power(g, -1))), x))), And(FreeQ(List(a, b, c, d, e, m, p), x), EqQ($s("n2"), Times(C2, n)), NeQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), IntegerQ(Times(C1D2, n))))),
            IIntegrate(3708, Int(Times(Plus(A_, Times(B_DEFAULT, $($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), Times(c_DEFAULT, Sqr($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))))), n_)), x_Symbol),
                    Condition(Dist(Power(Times(Power(C4, n), Power(c, n)), -1), Int(Times(Plus(ASymbol, Times(BSymbol, Tan(Plus(d, Times(e, x))))), Power(Plus(b, Times(C2, c, Tan(Plus(d, Times(e, x))))), Times(C2, n))), x), x), And(FreeQ(List(a, b, c, d, e, ASymbol, BSymbol), x), EqQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), IntegerQ(n)))),
            IIntegrate(3709, Int(Times(Power(Plus(Times($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), b_DEFAULT), Times(Sqr($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), c_DEFAULT), a_), n_), Plus(Times($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), B_DEFAULT), A_)), x_Symbol),
                    Condition(Dist(Power(Times(Power(C4, n), Power(c, n)), -1), Int(Times(Plus(ASymbol, Times(BSymbol, Cot(Plus(d, Times(e, x))))), Power(Plus(b, Times(C2, c, Cot(Plus(d, Times(e, x))))), Times(C2, n))), x), x), And(FreeQ(List(a, b, c, d, e, ASymbol, BSymbol), x), EqQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), IntegerQ(n)))),
            IIntegrate(3710, Int(Times(Plus(A_, Times(B_DEFAULT, $($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), Times(c_DEFAULT, Sqr($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))))), n_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Tan(Plus(d, Times(e, x)))), Times(c, Sqr(Tan(Plus(d, Times(e, x)))))), n), Power(Power(Plus(b, Times(C2, c, Tan(Plus(d, Times(e, x))))), Times(C2, n)), -1)), Int(Times(Plus(ASymbol, Times(BSymbol, Tan(Plus(d, Times(e, x))))), Power(Plus(b, Times(C2, c, Tan(Plus(d, Times(e, x))))), Times(C2, n))), x), x), And(FreeQ(List(a, b, c, d, e, ASymbol, BSymbol), x), EqQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), Not(IntegerQ(n))))),
            IIntegrate(3711, Int(Times(Power(Plus(Times($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), b_DEFAULT), Times(Sqr($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), c_DEFAULT), a_), n_), Plus(Times($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), B_DEFAULT), A_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Cot(Plus(d, Times(e, x)))), Times(c, Sqr(Cot(Plus(d, Times(e, x)))))), n), Power(Power(Plus(b, Times(C2, c, Cot(Plus(d, Times(e, x))))), Times(C2, n)), -1)), Int(Times(Plus(ASymbol, Times(BSymbol, Cot(Plus(d, Times(e, x))))), Power(Plus(b, Times(C2, c, Cot(Plus(d, Times(e, x))))), Times(C2, n))), x), x), And(FreeQ(List(a, b, c, d, e, ASymbol, BSymbol), x), EqQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), Not(IntegerQ(n))))),
            IIntegrate(3712, Int(Times(Plus(A_, Times(B_DEFAULT, $($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), Times(c_DEFAULT, Sqr($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))))), -1)), x_Symbol),
                    Condition(Module(List(Set(q, Rt(Plus(Sqr(b), Times(CN1, C4, a, c)), C2))), Plus(Dist(Plus(BSymbol, Times(Plus(Times(b, BSymbol), Times(CN1, C2, ASymbol, c)), Power(q, -1))), Int(Power(Simp(Plus(b, q, Times(C2, c, Tan(Plus(d, Times(e, x))))), x), -1), x), x), Dist(Plus(BSymbol, Times(CN1, Plus(Times(b, BSymbol), Times(CN1, C2, ASymbol, c)), Power(q, -1))), Int(Power(Simp(Plus(b, Negate(q), Times(C2, c, Tan(Plus(d, Times(e, x))))), x), -1), x), x))), And(FreeQ(List(a, b, c, d, e, ASymbol, BSymbol), x), NeQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0)))),
            IIntegrate(3713, Int(Times(Power(Plus(a_DEFAULT, Times($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), b_DEFAULT), Times(Sqr($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), c_DEFAULT)), -1), Plus(Times($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), B_DEFAULT), A_)), x_Symbol),
                    Condition(Module(List(Set(q, Rt(Plus(Sqr(b), Times(CN1, C4, a, c)), C2))), Plus(Dist(Plus(BSymbol, Times(Plus(Times(b, BSymbol), Times(CN1, C2, ASymbol, c)), Power(q, -1))), Int(Power(Simp(Plus(b, q, Times(C2, c, Cot(Plus(d, Times(e, x))))), x), -1), x), x), Dist(Plus(BSymbol, Times(CN1, Plus(Times(b, BSymbol), Times(CN1, C2, ASymbol, c)), Power(q, -1))), Int(Power(Simp(Plus(b, Negate(q), Times(C2, c, Cot(Plus(d, Times(e, x))))), x), -1), x), x))), And(FreeQ(List(a, b, c, d, e, ASymbol, BSymbol), x), NeQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0)))),
            IIntegrate(3714, Int(Times(Plus(A_, Times(B_DEFAULT, $($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), Times(c_DEFAULT, Sqr($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))))), n_)), x_Symbol),
                    Condition(Int(ExpandTrig(Times(Plus(ASymbol, Times(BSymbol, $($s("§tan"), Plus(d, Times(e, x))))), Power(Plus(a, Times(b, $($s("§tan"), Plus(d, Times(e, x)))), Times(c, Sqr($($s("§tan"), Plus(d, Times(e, x)))))), n)), x), x), And(FreeQ(List(a, b, c, d, e, ASymbol, BSymbol), x), NeQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), IntegerQ(n)))),
            IIntegrate(3715, Int(Times(Power(Plus(a_DEFAULT, Times($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), b_DEFAULT), Times(Sqr($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), c_DEFAULT)), n_), Plus(Times($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), B_DEFAULT), A_)), x_Symbol),
                    Condition(Int(ExpandTrig(Times(Plus(ASymbol, Times(BSymbol, $($s("§cot"), Plus(d, Times(e, x))))), Power(Plus(a, Times(b, $($s("§cot"), Plus(d, Times(e, x)))), Times(c, Sqr($($s("§cot"), Plus(d, Times(e, x)))))), n)), x), x), And(FreeQ(List(a, b, c, d, e, ASymbol, BSymbol), x), NeQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), IntegerQ(n)))),
            IIntegrate(3716, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), $($s("§tan"), Plus(e_DEFAULT, Times(Pi, k_DEFAULT), Times(Complex(C0, $p("fz")), f_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(CI, Power(Plus(c, Times(d, x)), Plus(m, C1)), Power(Times(d, Plus(m, C1)), -1)), x)), Dist(Times(C2, CI), Int(Times(Power(Plus(c, Times(d, x)), m), Exp(Times(C2, Plus(Times(CN1, CI, e), Times(f, $s("fz"), x)))), Power(Times(Exp(Times(C2, CI, k, Pi)), Plus(C1, Times(Exp(Times(C2, Plus(Times(CN1, CI, e), Times(f, $s("fz"), x)))), Power(Exp(Times(C2, CI, k, Pi)), -1)))), -1)), x), x)), And(FreeQ(List(c, d, e, f, $s("fz")), x), IntegerQ(Times(C4, k)), IGtQ(m, C0)))),
            IIntegrate(3717, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), $($s("§tan"), Plus(e_DEFAULT, Times(Pi, k_DEFAULT), Times(f_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(CI, Power(Plus(c, Times(d, x)), Plus(m, C1)), Power(Times(d, Plus(m, C1)), -1)), x), Negate(Dist(Times(C2, CI), Int(Times(Power(Plus(c, Times(d, x)), m), Exp(Times(C2, CI, k, Pi)), Exp(Times(C2, CI, Plus(e, Times(f, x)))), Power(Plus(C1, Times(Exp(Times(C2, CI, k, Pi)), Exp(Times(C2, CI, Plus(e, Times(f, x)))))), -1)), x), x))), And(FreeQ(List(c, d, e, f), x), IntegerQ(Times(C4, k)), IGtQ(m, C0)))),
            IIntegrate(3718, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), $($s("§tan"), Plus(e_DEFAULT, Times(Complex(C0, $p("fz")), f_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(CI, Power(Plus(c, Times(d, x)), Plus(m, C1)), Power(Times(d, Plus(m, C1)), -1)), x)), Dist(Times(C2, CI), Int(Times(Power(Plus(c, Times(d, x)), m), Exp(Times(C2, Plus(Times(CN1, CI, e), Times(f, $s("fz"), x)))), Power(Plus(C1, Exp(Times(C2, Plus(Times(CN1, CI, e), Times(f, $s("fz"), x))))), -1)), x), x)), And(FreeQ(List(c, d, e, f, $s("fz")), x), IGtQ(m, C0)))),
            IIntegrate(3719, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(CI, Power(Plus(c, Times(d, x)), Plus(m, C1)), Power(Times(d, Plus(m, C1)), -1)), x), Negate(Dist(Times(C2, CI), Int(Times(Power(Plus(c, Times(d, x)), m), Exp(Times(C2, CI, Plus(e, Times(f, x)))), Power(Plus(C1, Exp(Times(C2, CI, Plus(e, Times(f, x))))), -1)), x), x))), And(FreeQ(List(c, d, e, f), x), IGtQ(m, C0)))),
            IIntegrate(3720, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Power(Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_)), x_Symbol),
                    Condition(Plus(Simp(Times(b, Power(Plus(c, Times(d, x)), m), Power(Times(b, Tan(Plus(e, Times(f, x)))), Plus(n, Negate(C1))), Power(Times(f, Plus(n, Negate(C1))), -1)), x), Negate(Dist(Times(b, d, m, Power(Times(f, Plus(n, Negate(C1))), -1)), Int(Times(Power(Plus(c, Times(d, x)), Plus(m, Negate(C1))), Power(Times(b, Tan(Plus(e, Times(f, x)))), Plus(n, Negate(C1)))), x), x)), Negate(Dist(Sqr(b), Int(Times(Power(Plus(c, Times(d, x)), m), Power(Times(b, Tan(Plus(e, Times(f, x)))), Plus(n, Negate(C2)))), x), x))), And(FreeQ(List(b, c, d, e, f), x), GtQ(n, C1), GtQ(m, C0)))),
            IIntegrate(3721, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Power(Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(c, Times(d, x)), m), Power(Times(b, Tan(Plus(e, Times(f, x)))), Plus(n, C1)), Power(Times(b, f, Plus(n, C1)), -1)), x), Negate(Dist(Times(d, m, Power(Times(b, f, Plus(n, C1)), -1)), Int(Times(Power(Plus(c, Times(d, x)), Plus(m, Negate(C1))), Power(Times(b, Tan(Plus(e, Times(f, x)))), Plus(n, C1))), x), x)), Negate(Dist(Power(b, -2), Int(Times(Power(Plus(c, Times(d, x)), m), Power(Times(b, Tan(Plus(e, Times(f, x)))), Plus(n, C2))), x), x))), And(FreeQ(List(b, c, d, e, f), x), LtQ(n, CN1), GtQ(m, C0)))),
            IIntegrate(3722, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(c, Times(d, x)), m), Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), n), x), x), And(FreeQ(List(a, b, c, d, e, f, m), x), IGtQ(m, C0), IGtQ(n, C0)))),
            IIntegrate(3723, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), -1)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), Power(Times(C2, a, d, Plus(m, C1)), -1)), x), Dist(Times(a, d, m, Power(Times(C2, b, f), -1)), Int(Times(Power(Plus(c, Times(d, x)), Plus(m, Negate(C1))), Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), -1)), x), x), Negate(Simp(Times(a, Power(Plus(c, Times(d, x)), m), Power(Times(C2, b, f, Plus(a, Times(b, Tan(Plus(e, Times(f, x)))))), -1)), x))), And(FreeQ(List(a, b, c, d, e, f), x), EqQ(Plus(Sqr(a), Sqr(b)), C0), GtQ(m, C0)))),
            IIntegrate(3724, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), -2), Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), -1)), x_Symbol),
                    Condition(Plus(Negate(Simp(Power(Times(d, Plus(c, Times(d, x)), Plus(a, Times(b, Tan(Plus(e, Times(f, x)))))), -1), x)), Negate(Dist(Times(f, Power(Times(a, d), -1)), Int(Times(Sin(Plus(Times(C2, e), Times(C2, f, x))), Power(Plus(c, Times(d, x)), -1)), x), x)), Dist(Times(f, Power(Times(b, d), -1)), Int(Times(Cos(Plus(Times(C2, e), Times(C2, f, x))), Power(Plus(c, Times(d, x)), -1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), EqQ(Plus(Sqr(a), Sqr(b)), C0)))),
            IIntegrate(3725, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_), Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), -1)), x_Symbol),
                    Condition(Plus(Simp(Times(f, Power(Plus(c, Times(d, x)), Plus(m, C2)), Power(Times(b, Sqr(d), Plus(m, C1), Plus(m, C2)), -1)), x), Dist(Times(C2, b, f, Power(Times(a, d, Plus(m, C1)), -1)), Int(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), -1)), x), x), Simp(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), Power(Times(d, Plus(m, C1), Plus(a, Times(b, Tan(Plus(e, Times(f, x)))))), -1)), x)), And(FreeQ(List(a, b, c, d, e, f), x), EqQ(Plus(Sqr(a), Sqr(b)), C0), LtQ(m, CN1), NeQ(m, CN2)))),
            IIntegrate(3726, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), -1), Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), -1)), x_Symbol),
                    Condition(Plus(Simp(Times(Log(Plus(c, Times(d, x))), Power(Times(C2, a, d), -1)), x), Dist(Power(Times(C2, a), -1), Int(Times(Cos(Plus(Times(C2, e), Times(C2, f, x))), Power(Plus(c, Times(d, x)), -1)), x), x), Dist(Power(Times(C2, b), -1), Int(Times(Sin(Plus(Times(C2, e), Times(C2, f, x))), Power(Plus(c, Times(d, x)), -1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), EqQ(Plus(Sqr(a), Sqr(b)), C0)))),
            IIntegrate(3727, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_), Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), -1)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), Power(Times(C2, a, d, Plus(m, C1)), -1)), x), Dist(Power(Times(C2, a), -1), Int(Times(Power(Plus(c, Times(d, x)), m), Exp(Times(C2, a, Plus(e, Times(f, x)), Power(b, -1)))), x), x)), And(FreeQ(List(a, b, c, d, e, f, m), x), EqQ(Plus(Sqr(a), Sqr(b)), C0), Not(IntegerQ(m))))),
            IIntegrate(3728, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_), Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(c, Times(d, x)), m), Power(Plus(Power(Times(C2, a), -1), Times(Cos(Plus(Times(C2, e), Times(C2, f, x))), Power(Times(C2, a), -1)), Times(Sin(Plus(Times(C2, e), Times(C2, f, x))), Power(Times(C2, b), -1))), Negate(n)), x), x), And(FreeQ(List(a, b, c, d, e, f), x), EqQ(Plus(Sqr(a), Sqr(b)), C0), ILtQ(m, C0), ILtQ(n, C0)))),
            IIntegrate(3729, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_), Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(c, Times(d, x)), m), Power(Plus(Power(Times(C2, a), -1), Times(Exp(Times(C2, a, Plus(e, Times(f, x)), Power(b, -1))), Power(Times(C2, a), -1))), Negate(n)), x), x), And(FreeQ(List(a, b, c, d, e, f, m), x), EqQ(Plus(Sqr(a), Sqr(b)), C0), ILtQ(n, C0)))),
            IIntegrate(3730, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), n), x))), Plus(Dist(Power(Plus(c, Times(d, x)), m), u, x), Negate(Dist(Times(d, m), Int(Dist(Power(Plus(c, Times(d, x)), Plus(m, Negate(C1))), u, x), x), x)))), And(FreeQ(List(a, b, c, d, e, f), x), EqQ(Plus(Sqr(a), Sqr(b)), C0), ILtQ(n, CN1), GtQ(m, C0)))),
            IIntegrate(3731, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(Pi, k_DEFAULT), Times(f_DEFAULT, x_))))), -1)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), Power(Times(d, Plus(m, C1), Plus(a, Times(CI, b))), -1)), x), Dist(Times(C2, CI, b), Int(Times(Power(Plus(c, Times(d, x)), m), Exp(Times(C2, CI, k, Pi)), Exp(Simp(Times(C2, CI, Plus(e, Times(f, x))), x)), Power(Plus(Sqr(Plus(a, Times(CI, b))), Times(Plus(Sqr(a), Sqr(b)), Exp(Times(C2, CI, k, Pi)), Exp(Simp(Times(C2, CI, Plus(e, Times(f, x))), x)))), -1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IntegerQ(Times(C4, k)), NeQ(Plus(Sqr(a), Sqr(b)), C0), IGtQ(m, C0)))),
            IIntegrate(3732, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), -1)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), Power(Times(d, Plus(m, C1), Plus(a, Times(CI, b))), -1)), x), Dist(Times(C2, CI, b), Int(Times(Power(Plus(c, Times(d, x)), m), Exp(Simp(Times(C2, CI, Plus(e, Times(f, x))), x)), Power(Plus(Sqr(Plus(a, Times(CI, b))), Times(Plus(Sqr(a), Sqr(b)), Exp(Simp(Times(C2, CI, Plus(e, Times(f, x))), x)))), -1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Plus(Sqr(a), Sqr(b)), C0), IGtQ(m, C0)))),
            IIntegrate(3733, Int(Times(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), -2)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Sqr(Plus(c, Times(d, x))), Power(Times(C2, d, Plus(Sqr(a), Sqr(b))), -1)), x)), Dist(Power(Times(f, Plus(Sqr(a), Sqr(b))), -1), Int(Times(Plus(Times(b, d), Times(C2, a, c, f), Times(C2, a, d, f, x)), Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), -1)), x), x), Negate(Simp(Times(b, Plus(c, Times(d, x)), Power(Times(f, Plus(Sqr(a), Sqr(b)), Plus(a, Times(b, Tan(Plus(e, Times(f, x)))))), -1)), x))), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Plus(Sqr(a), Sqr(b)), C0)))),
            IIntegrate(3734, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(c, Times(d, x)), m), Power(Plus(Power(Plus(a, Times(CN1, CI, b)), -1), Times(CN1, C2, CI, b, Power(Plus(Sqr(a), Sqr(b), Times(Sqr(Plus(a, Times(CN1, CI, b))), Exp(Times(C2, CI, Plus(e, Times(f, x)))))), -1))), Negate(n)), x), x), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Plus(Sqr(a), Sqr(b)), C0), ILtQ(n, C0), IGtQ(m, C0)))),
            IIntegrate(3735, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Power($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), n_DEFAULT)), x_Symbol),
                    Condition(Simp(If(MatchQ(f, Times($p("f1", true), Complex(C0, j_))), If(MatchQ(e, Plus($p("e1", true), Times(C1D2, Pi))), Times(Power(CI, n), Unintegrable(Times(Power(Plus(c, Times(d, x)), m), Power(Coth(Plus(Times(CN1, CI, Plus(e, Times(CN1, C1D2, Pi))), Times(CN1, CI, f, x))), n)), x)), Times(Power(CI, n), Unintegrable(Times(Power(Plus(c, Times(d, x)), m), Power(Tanh(Plus(Times(CN1, CI, e), Times(CN1, CI, f, x))), n)), x))), If(MatchQ(e, Plus($p("e1", true), Times(C1D2, Pi))), Times(Power(CN1, n), Unintegrable(Times(Power(Plus(c, Times(d, x)), m), Power(Cot(Plus(e, Times(CN1, C1D2, Pi), Times(f, x))), n)), x)), Unintegrable(Times(Power(Plus(c, Times(d, x)), m), Power(Tan(Plus(e, Times(f, x))), n)), x))), x), And(FreeQ(List(c, d, e, f, m, n), x), IntegerQ(n)))),
            IIntegrate(3736, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(c, Times(d, x)), m), Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), n)), x), FreeQ(List(a, b, c, d, e, f, m, n), x))),
            IIntegrate(3737, Int(Times(Power(u_, m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Tan(v_))), n_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(ExpandToSum(u, x), m), Power(Plus(a, Times(b, Tan(ExpandToSum(v, x)))), n)), x), And(FreeQ(List(a, b, m, n), x), LinearQ(List(u, v), x), Not(LinearMatchQ(List(u, v), x))))),
            IIntegrate(3738, Int(Times(Power(Plus(a_DEFAULT, Times(Cot(v_), b_DEFAULT)), n_DEFAULT), Power(u_, m_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(ExpandToSum(u, x), m), Power(Plus(a, Times(b, Cot(ExpandToSum(v, x)))), n)), x), And(FreeQ(List(a, b, m, n), x), LinearQ(List(u, v), x), Not(LinearMatchQ(List(u, v), x))))),
            IIntegrate(3739, Int(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Tan(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))))), p_DEFAULT), x_Symbol),
                    Condition(Dist(Power(n, -1), Subst(Int(Times(Power(x, Plus(Power(n, -1), Negate(C1))), Power(Plus(a, Times(b, Tan(Plus(c, Times(d, x))))), p)), x), x, Power(x, n)), x), And(FreeQ(List(a, b, c, d, p), x), IGtQ(Power(n, -1), C0), IntegerQ(p)))),
            IIntegrate(3740, Int(Power(Plus(a_DEFAULT, Times(Cot(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))), b_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Power(n, -1), Subst(Int(Times(Power(x, Plus(Power(n, -1), Negate(C1))), Power(Plus(a, Times(b, Cot(Plus(c, Times(d, x))))), p)), x), x, Power(x, n)), x), And(FreeQ(List(a, b, c, d, p), x), IGtQ(Power(n, -1), C0), IntegerQ(p)))),
            IIntegrate(3741, Int(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Tan(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))))), p_DEFAULT), x_Symbol),
                    Condition(Unintegrable(Power(Plus(a, Times(b, Tan(Plus(c, Times(d, Power(x, n)))))), p), x), FreeQ(List(a, b, c, d, n, p), x))),
            IIntegrate(3742, Int(Power(Plus(a_DEFAULT, Times(Cot(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))), b_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Unintegrable(Power(Plus(a, Times(b, Cot(Plus(c, Times(d, Power(x, n)))))), p), x), FreeQ(List(a, b, c, d, n, p), x))),
            IIntegrate(3743, Int(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Tan(Plus(c_DEFAULT, Times(d_DEFAULT, Power(u_, n_)))))), p_DEFAULT), x_Symbol),
                    Condition(Dist(Power(Coefficient(u, x, C1), -1), Subst(Int(Power(Plus(a, Times(b, Tan(Plus(c, Times(d, Power(x, n)))))), p), x), x, u), x), And(FreeQ(List(a, b, c, d, n, p), x), LinearQ(u, x), NeQ(u, x)))),
            IIntegrate(3744, Int(Power(Plus(a_DEFAULT, Times(Cot(Plus(c_DEFAULT, Times(d_DEFAULT, Power(u_, n_)))), b_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Power(Coefficient(u, x, C1), -1), Subst(Int(Power(Plus(a, Times(b, Cot(Plus(c, Times(d, Power(x, n)))))), p), x), x, u), x), And(FreeQ(List(a, b, c, d, n, p), x), LinearQ(u, x), NeQ(u, x)))),
            IIntegrate(3745, Int(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Tan(u_))), p_DEFAULT), x_Symbol),
                    Condition(Int(Power(Plus(a, Times(b, Tan(ExpandToSum(u, x)))), p), x), And(FreeQ(List(a, b, p), x), BinomialQ(u, x), Not(BinomialMatchQ(u, x))))),
            IIntegrate(3746, Int(Power(Plus(a_DEFAULT, Times(Cot(u_), b_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Int(Power(Plus(a, Times(b, Cot(ExpandToSum(u, x)))), p), x), And(FreeQ(List(a, b, p), x), BinomialQ(u, x), Not(BinomialMatchQ(u, x))))),
            IIntegrate(3747, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Tan(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(n, -1), Subst(Int(Times(Power(x, Plus(Simplify(Times(Plus(m, C1), Power(n, -1))), Negate(C1))), Power(Plus(a, Times(b, Tan(Plus(c, Times(d, x))))), p)), x), x, Power(x, n)), x), And(FreeQ(List(a, b, c, d, m, n, p), x), IGtQ(Simplify(Times(Plus(m, C1), Power(n, -1))), C0), IntegerQ(p)))),
            IIntegrate(3748, Int(Times(Power(Plus(a_DEFAULT, Times(Cot(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))), b_DEFAULT)), p_DEFAULT), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(n, -1), Subst(Int(Times(Power(x, Plus(Simplify(Times(Plus(m, C1), Power(n, -1))), Negate(C1))), Power(Plus(a, Times(b, Cot(Plus(c, Times(d, x))))), p)), x), x, Power(x, n)), x), And(FreeQ(List(a, b, c, d, m, n, p), x), IGtQ(Simplify(Times(Plus(m, C1), Power(n, -1))), C0), IntegerQ(p)))),
            IIntegrate(3749, Int(Times(Power(x_, m_DEFAULT), Sqr(Tan(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, Plus(m, Negate(n), C1)), Tan(Plus(c, Times(d, Power(x, n)))), Power(Times(d, n), -1)), x), Negate(Dist(Times(Plus(m, Negate(n), C1), Power(Times(d, n), -1)), Int(Times(Power(x, Plus(m, Negate(n))), Tan(Plus(c, Times(d, Power(x, n))))), x), x)), Negate(Int(Power(x, m), x))), FreeQ(List(c, d, m, n), x))),
            IIntegrate(3750, Int(Times(Sqr(Cot(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_))))), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(x, Plus(m, Negate(n), C1)), Cot(Plus(c, Times(d, Power(x, n)))), Power(Times(d, n), -1)), x)), Dist(Times(Plus(m, Negate(n), C1), Power(Times(d, n), -1)), Int(Times(Power(x, Plus(m, Negate(n))), Cot(Plus(c, Times(d, Power(x, n))))), x), x), Negate(Int(Power(x, m), x))), FreeQ(List(c, d, m, n), x)))
    );
}
