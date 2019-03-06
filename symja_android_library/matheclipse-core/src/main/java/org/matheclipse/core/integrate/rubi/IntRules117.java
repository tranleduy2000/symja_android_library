package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.ASymbol;
import static org.matheclipse.core.expression.F.A_DEFAULT;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcCosh;
import static org.matheclipse.core.expression.F.ArcCsch;
import static org.matheclipse.core.expression.F.ArcSech;
import static org.matheclipse.core.expression.F.ArcSinh;
import static org.matheclipse.core.expression.F.BSymbol;
import static org.matheclipse.core.expression.F.B_DEFAULT;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.CSqrt2;
import static org.matheclipse.core.expression.F.CSymbol;
import static org.matheclipse.core.expression.F.C_DEFAULT;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cosh;
import static org.matheclipse.core.expression.F.CoshIntegral;
import static org.matheclipse.core.expression.F.Coth;
import static org.matheclipse.core.expression.F.D;
import static org.matheclipse.core.expression.F.Erf;
import static org.matheclipse.core.expression.F.Erfi;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.FresnelC;
import static org.matheclipse.core.expression.F.FresnelS;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Pi;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.PolynomialQ;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.QQ;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sinh;
import static org.matheclipse.core.expression.F.SinhIntegral;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Tanh;
import static org.matheclipse.core.expression.F.Times;
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
import static org.matheclipse.core.expression.F.m;
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
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfExponentialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InverseFunctionFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalFunctionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules117 {
    public static IAST RULES = List(
            IIntegrate(5851, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSinh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), $p("§px", true), Power(Plus(f_, Times(g_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), p_))), m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, ExpandIntegrand(Times($s("§px"), Power(Plus(f, Times(g, Power(Plus(d, Times(e, Sqr(x))), p))), m), Power(Plus(a, Times(b, ArcSinh(Times(c, x)))), n)), x))), Condition(Int(u, x), SumQ(u))), And(FreeQ(List(a, b, c, d, e, f, g), x), PolynomialQ($s("§px"), x), EqQ(e, Times(Sqr(c), d)), IGtQ(Plus(p, C1D2), C0), IntegersQ(m, n)))),
            IIntegrate(5852, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCosh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), $p("§px", true), Power(Plus(f_, Times(g_DEFAULT, Power(Plus($p("d1"), Times($p("e1", true), x_)), p_), Power(Plus($p("d2"), Times($p("e2", true), x_)), p_))), m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, ExpandIntegrand(Times($s("§px"), Power(Plus(f, Times(g, Power(Plus($s("d1"), Times($s("e1"), x)), p), Power(Plus($s("d2"), Times($s("e2"), x)), p))), m), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), n)), x))), Condition(Int(u, x), SumQ(u))), And(FreeQ(List(a, b, c, $s("d1"), $s("e1"), $s("d2"), $s("e2"), f, g), x), PolynomialQ($s("§px"), x), EqQ(Plus($s("e1"), Times(CN1, c, $s("d1"))), C0), EqQ(Plus($s("e2"), Times(c, $s("d2"))), C0), IGtQ(Plus(p, C1D2), C0), IntegersQ(m, n)))),
            IIntegrate(5853, Int(Times(Power(ArcSinh(Times(c_DEFAULT, x_)), n_DEFAULT), $p("§rfx")), x_Symbol),
                    Condition(With(List(Set(u, ExpandIntegrand(Power(ArcSinh(Times(c, x)), n), $s("§rfx"), x))), Condition(Int(u, x), SumQ(u))), And(FreeQ(c, x), RationalFunctionQ($s("§rfx"), x), IGtQ(n, C0)))),
            IIntegrate(5854, Int(Times(Power(ArcCosh(Times(c_DEFAULT, x_)), n_DEFAULT), $p("§rfx")), x_Symbol),
                    Condition(With(List(Set(u, ExpandIntegrand(Power(ArcCosh(Times(c, x)), n), $s("§rfx"), x))), Condition(Int(u, x), SumQ(u))), And(FreeQ(c, x), RationalFunctionQ($s("§rfx"), x), IGtQ(n, C0)))),
            IIntegrate(5855, Int(Times(Power(Plus(Times(ArcSinh(Times(c_DEFAULT, x_)), b_DEFAULT), a_), n_DEFAULT), $p("§rfx")), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times($s("§rfx"), Power(Plus(a, Times(b, ArcSinh(Times(c, x)))), n)), x), x), And(FreeQ(List(a, b, c), x), RationalFunctionQ($s("§rfx"), x), IGtQ(n, C0)))),
            IIntegrate(5856, Int(Times(Power(Plus(Times(ArcCosh(Times(c_DEFAULT, x_)), b_DEFAULT), a_), n_DEFAULT), $p("§rfx")), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times($s("§rfx"), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), n)), x), x), And(FreeQ(List(a, b, c), x), RationalFunctionQ($s("§rfx"), x), IGtQ(n, C0)))),
            IIntegrate(5857, Int(Times(Power(ArcSinh(Times(c_DEFAULT, x_)), n_DEFAULT), $p("§rfx"), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(With(List(Set(u, ExpandIntegrand(Times(Power(Plus(d, Times(e, Sqr(x))), p), Power(ArcSinh(Times(c, x)), n)), $s("§rfx"), x))), Condition(Int(u, x), SumQ(u))), And(FreeQ(List(c, d, e), x), RationalFunctionQ($s("§rfx"), x), IGtQ(n, C0), EqQ(e, Times(Sqr(c), d)), IntegerQ(Plus(p, Negate(C1D2)))))),
            IIntegrate(5858, Int(Times(Power(ArcCosh(Times(c_DEFAULT, x_)), n_DEFAULT), $p("§rfx"), Power(Plus($p("d1"), Times($p("e1", true), x_)), p_), Power(Plus($p("d2"), Times($p("e2", true), x_)), p_)), x_Symbol),
                    Condition(With(List(Set(u, ExpandIntegrand(Times(Power(Plus($s("d1"), Times($s("e1"), x)), p), Power(Plus($s("d2"), Times($s("e2"), x)), p), Power(ArcCosh(Times(c, x)), n)), $s("§rfx"), x))), Condition(Int(u, x), SumQ(u))), And(FreeQ(List(c, $s("d1"), $s("e1"), $s("d2"), $s("e2")), x), RationalFunctionQ($s("§rfx"), x), IGtQ(n, C0), EqQ(Plus($s("e1"), Times(CN1, c, $s("d1"))), C0), EqQ(Plus($s("e2"), Times(c, $s("d2"))), C0), IntegerQ(Plus(p, Negate(C1D2)))))),
            IIntegrate(5859, Int(Times(Power(Plus(Times(ArcSinh(Times(c_DEFAULT, x_)), b_DEFAULT), a_), n_DEFAULT), $p("§rfx"), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(d, Times(e, Sqr(x))), p), Times($s("§rfx"), Power(Plus(a, Times(b, ArcSinh(Times(c, x)))), n)), x), x), And(FreeQ(List(a, b, c, d, e), x), RationalFunctionQ($s("§rfx"), x), IGtQ(n, C0), EqQ(e, Times(Sqr(c), d)), IntegerQ(Plus(p, Negate(C1D2)))))),
            IIntegrate(5860, Int(Times(Power(Plus(Times(ArcCosh(Times(c_DEFAULT, x_)), b_DEFAULT), a_), n_DEFAULT), $p("§rfx"), Power(Plus($p("d1"), Times($p("e1", true), x_)), p_), Power(Plus($p("d2"), Times($p("e2", true), x_)), p_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus($s("d1"), Times($s("e1"), x)), p), Power(Plus($s("d2"), Times($s("e2"), x)), p)), Times($s("§rfx"), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), n)), x), x), And(FreeQ(List(a, b, c, $s("d1"), $s("e1"), $s("d2"), $s("e2")), x), RationalFunctionQ($s("§rfx"), x), IGtQ(n, C0), EqQ(Plus($s("e1"), Times(CN1, c, $s("d1"))), C0), EqQ(Plus($s("e2"), Times(c, $s("d2"))), C0), IntegerQ(Plus(p, Negate(C1D2)))))),
            IIntegrate(5861, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSinh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), u_DEFAULT), x_Symbol),
                    Condition(Unintegrable(Times(u, Power(Plus(a, Times(b, ArcSinh(Times(c, x)))), n)), x), FreeQ(List(a, b, c, n), x))),
            IIntegrate(5862, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCosh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), u_DEFAULT), x_Symbol),
                    Condition(Unintegrable(Times(u, Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), n)), x), FreeQ(List(a, b, c, n), x))),
            IIntegrate(5863, Int(Power(Plus(a_DEFAULT, Times(ArcSinh(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), n_DEFAULT), x_Symbol),
                    Condition(Dist(Power(d, -1), Subst(Int(Power(Plus(a, Times(b, ArcSinh(x))), n), x), x, Plus(c, Times(d, x))), x), FreeQ(List(a, b, c, d, n), x))),
            IIntegrate(5864, Int(Power(Plus(a_DEFAULT, Times(ArcCosh(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), n_DEFAULT), x_Symbol),
                    Condition(Dist(Power(d, -1), Subst(Int(Power(Plus(a, Times(b, ArcCosh(x))), n), x), x, Plus(c, Times(d, x))), x), FreeQ(List(a, b, c, d, n), x))),
            IIntegrate(5865, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSinh(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, -1), Subst(Int(Times(Power(Plus(Times(Plus(Times(d, e), Times(CN1, c, f)), Power(d, -1)), Times(f, x, Power(d, -1))), m), Power(Plus(a, Times(b, ArcSinh(x))), n)), x), x, Plus(c, Times(d, x))), x), FreeQ(List(a, b, c, d, e, f, m, n), x))),
            IIntegrate(5866, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCosh(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, -1), Subst(Int(Times(Power(Plus(Times(Plus(Times(d, e), Times(CN1, c, f)), Power(d, -1)), Times(f, x, Power(d, -1))), m), Power(Plus(a, Times(b, ArcCosh(x))), n)), x), x, Plus(c, Times(d, x))), x), FreeQ(List(a, b, c, d, e, f, m, n), x))),
            IIntegrate(5867, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSinh(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), n_DEFAULT), Power(Plus(A_DEFAULT, Times(B_DEFAULT, x_), Times(C_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, -1), Subst(Int(Times(Power(Plus(Times(CSymbol, Power(d, -2)), Times(CSymbol, Sqr(x), Power(d, -2))), p), Power(Plus(a, Times(b, ArcSinh(x))), n)), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d, ASymbol, BSymbol, CSymbol, n, p), x), EqQ(Plus(Times(BSymbol, Plus(C1, Sqr(c))), Times(CN1, C2, ASymbol, c, d)), C0), EqQ(Plus(Times(C2, c, CSymbol), Times(CN1, BSymbol, d)), C0)))),
            IIntegrate(5868, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCosh(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), n_DEFAULT), Power(Plus(A_DEFAULT, Times(B_DEFAULT, x_), Times(C_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, -1), Subst(Int(Times(Power(Plus(Times(CN1, CSymbol, Power(d, -2)), Times(CSymbol, Sqr(x), Power(d, -2))), p), Power(Plus(a, Times(b, ArcCosh(x))), n)), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d, ASymbol, BSymbol, CSymbol, n, p), x), EqQ(Plus(Times(BSymbol, Plus(C1, Negate(Sqr(c)))), Times(C2, ASymbol, c, d)), C0), EqQ(Plus(Times(C2, c, CSymbol), Times(CN1, BSymbol, d)), C0)))),
            IIntegrate(5869, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSinh(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Plus(A_DEFAULT, Times(B_DEFAULT, x_), Times(C_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, -1), Subst(Int(Times(Power(Plus(Times(Plus(Times(d, e), Times(CN1, c, f)), Power(d, -1)), Times(f, x, Power(d, -1))), m), Power(Plus(Times(CSymbol, Power(d, -2)), Times(CSymbol, Sqr(x), Power(d, -2))), p), Power(Plus(a, Times(b, ArcSinh(x))), n)), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, CSymbol, m, n, p), x), EqQ(Plus(Times(BSymbol, Plus(C1, Sqr(c))), Times(CN1, C2, ASymbol, c, d)), C0), EqQ(Plus(Times(C2, c, CSymbol), Times(CN1, BSymbol, d)), C0)))),
            IIntegrate(5870, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCosh(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Plus(A_DEFAULT, Times(B_DEFAULT, x_), Times(C_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, -1), Subst(Int(Times(Power(Plus(Times(Plus(Times(d, e), Times(CN1, c, f)), Power(d, -1)), Times(f, x, Power(d, -1))), m), Power(Plus(Times(CN1, CSymbol, Power(d, -2)), Times(CSymbol, Sqr(x), Power(d, -2))), p), Power(Plus(a, Times(b, ArcCosh(x))), n)), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, CSymbol, m, n, p), x), EqQ(Plus(Times(BSymbol, Plus(C1, Negate(Sqr(c)))), Times(C2, ASymbol, c, d)), C0), EqQ(Plus(Times(C2, c, CSymbol), Times(CN1, BSymbol, d)), C0)))),
            IIntegrate(5871, Int(Sqrt(Plus(a_DEFAULT, Times(ArcSinh(Plus(c_, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT))), x_Symbol),
                    Condition(Plus(Simp(Times(x, Sqrt(Plus(a, Times(b, ArcSinh(Plus(c, Times(d, Sqr(x)))))))), x), Negate(Simp(Times(Sqrt(Pi), x, Plus(Cosh(Times(a, Power(Times(C2, b), -1))), Times(CN1, c, Sinh(Times(a, Power(Times(C2, b), -1))))), FresnelC(Times(Sqrt(Times(CN1, c, Power(Times(Pi, b), -1))), Sqrt(Plus(a, Times(b, ArcSinh(Plus(c, Times(d, Sqr(x))))))))), Power(Times(Sqrt(Times(CN1, c, Power(b, -1))), Plus(Cosh(Times(C1D2, ArcSinh(Plus(c, Times(d, Sqr(x)))))), Times(c, Sinh(Times(C1D2, ArcSinh(Plus(c, Times(d, Sqr(x))))))))), -1)), x)), Simp(Times(Sqrt(Pi), x, Plus(Cosh(Times(a, Power(Times(C2, b), -1))), Times(c, Sinh(Times(a, Power(Times(C2, b), -1))))), FresnelS(Times(Sqrt(Times(CN1, c, Power(Times(Pi, b), -1))), Sqrt(Plus(a, Times(b, ArcSinh(Plus(c, Times(d, Sqr(x))))))))), Power(Times(Sqrt(Times(CN1, c, Power(b, -1))), Plus(Cosh(Times(C1D2, ArcSinh(Plus(c, Times(d, Sqr(x)))))), Times(c, Sinh(Times(C1D2, ArcSinh(Plus(c, Times(d, Sqr(x))))))))), -1)), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Sqr(c), CN1)))),
            IIntegrate(5872, Int(Power(Plus(a_DEFAULT, Times(ArcSinh(Plus(c_, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT)), n_), x_Symbol),
                    Condition(Plus(Simp(Times(x, Power(Plus(a, Times(b, ArcSinh(Plus(c, Times(d, Sqr(x)))))), n)), x), Dist(Times(C4, Sqr(b), n, Plus(n, Negate(C1))), Int(Power(Plus(a, Times(b, ArcSinh(Plus(c, Times(d, Sqr(x)))))), Plus(n, Negate(C2))), x), x), Negate(Simp(Times(C2, b, n, Sqrt(Plus(Times(C2, c, d, Sqr(x)), Times(Sqr(d), Power(x, 4)))), Power(Plus(a, Times(b, ArcSinh(Plus(c, Times(d, Sqr(x)))))), Plus(n, Negate(C1))), Power(Times(d, x), -1)), x))), And(FreeQ(List(a, b, c, d), x), EqQ(Sqr(c), CN1), GtQ(n, C1)))),
            IIntegrate(5873, Int(Power(Plus(a_DEFAULT, Times(ArcSinh(Plus(c_, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT)), -1), x_Symbol),
                    Condition(Plus(Simp(Times(x, Plus(Times(c, Cosh(Times(a, Power(Times(C2, b), -1)))), Negate(Sinh(Times(a, Power(Times(C2, b), -1))))), CoshIntegral(Times(Plus(a, Times(b, ArcSinh(Plus(c, Times(d, Sqr(x)))))), Power(Times(C2, b), -1))), Power(Times(C2, b, Plus(Cosh(Times(C1D2, ArcSinh(Plus(c, Times(d, Sqr(x)))))), Times(c, Sinh(Times(C1D2, ArcSinh(Plus(c, Times(d, Sqr(x))))))))), -1)), x), Simp(Times(x, Plus(Cosh(Times(a, Power(Times(C2, b), -1))), Times(CN1, c, Sinh(Times(a, Power(Times(C2, b), -1))))), SinhIntegral(Times(Plus(a, Times(b, ArcSinh(Plus(c, Times(d, Sqr(x)))))), Power(Times(C2, b), -1))), Power(Times(C2, b, Plus(Cosh(Times(C1D2, ArcSinh(Plus(c, Times(d, Sqr(x)))))), Times(c, Sinh(Times(C1D2, ArcSinh(Plus(c, Times(d, Sqr(x))))))))), -1)), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Sqr(c), CN1)))),
            IIntegrate(5874, Int(Power(Plus(a_DEFAULT, Times(ArcSinh(Plus(c_, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT)), CN1D2), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(c, C1), Sqrt(Times(C1D2, Pi)), x, Plus(Cosh(Times(a, Power(Times(C2, b), -1))), Negate(Sinh(Times(a, Power(Times(C2, b), -1))))), Erfi(Times(Sqrt(Plus(a, Times(b, ArcSinh(Plus(c, Times(d, Sqr(x))))))), Power(Times(C2, b), CN1D2))), Power(Times(C2, Sqrt(b), Plus(Cosh(Times(C1D2, ArcSinh(Plus(c, Times(d, Sqr(x)))))), Times(c, Sinh(Times(C1D2, ArcSinh(Plus(c, Times(d, Sqr(x))))))))), -1)), x), Simp(Times(Plus(c, Negate(C1)), Sqrt(Times(C1D2, Pi)), x, Plus(Cosh(Times(a, Power(Times(C2, b), -1))), Sinh(Times(a, Power(Times(C2, b), -1)))), Erf(Times(Sqrt(Plus(a, Times(b, ArcSinh(Plus(c, Times(d, Sqr(x))))))), Power(Times(C2, b), CN1D2))), Power(Times(C2, Sqrt(b), Plus(Cosh(Times(C1D2, ArcSinh(Plus(c, Times(d, Sqr(x)))))), Times(c, Sinh(Times(C1D2, ArcSinh(Plus(c, Times(d, Sqr(x))))))))), -1)), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Sqr(c), CN1)))),
            IIntegrate(5875, Int(Power(Plus(a_DEFAULT, Times(ArcSinh(Plus(c_, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT)), QQ(-3L, 2L)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Sqrt(Plus(Times(C2, c, d, Sqr(x)), Times(Sqr(d), Power(x, 4)))), Power(Times(b, d, x, Sqrt(Plus(a, Times(b, ArcSinh(Plus(c, Times(d, Sqr(x)))))))), -1)), x)), Negate(Simp(Times(Power(Times(CN1, c, Power(b, -1)), QQ(3L, 2L)), Sqrt(Pi), x, Plus(Cosh(Times(a, Power(Times(C2, b), -1))), Times(CN1, c, Sinh(Times(a, Power(Times(C2, b), -1))))), FresnelC(Times(Sqrt(Times(CN1, c, Power(Times(Pi, b), -1))), Sqrt(Plus(a, Times(b, ArcSinh(Plus(c, Times(d, Sqr(x))))))))), Power(Plus(Cosh(Times(C1D2, ArcSinh(Plus(c, Times(d, Sqr(x)))))), Times(c, Sinh(Times(C1D2, ArcSinh(Plus(c, Times(d, Sqr(x)))))))), -1)), x)), Simp(Times(Power(Times(CN1, c, Power(b, -1)), QQ(3L, 2L)), Sqrt(Pi), x, Plus(Cosh(Times(a, Power(Times(C2, b), -1))), Times(c, Sinh(Times(a, Power(Times(C2, b), -1))))), FresnelS(Times(Sqrt(Times(CN1, c, Power(Times(Pi, b), -1))), Sqrt(Plus(a, Times(b, ArcSinh(Plus(c, Times(d, Sqr(x))))))))), Power(Plus(Cosh(Times(C1D2, ArcSinh(Plus(c, Times(d, Sqr(x)))))), Times(c, Sinh(Times(C1D2, ArcSinh(Plus(c, Times(d, Sqr(x)))))))), -1)), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Sqr(c), CN1)))),
            IIntegrate(5876, Int(Power(Plus(a_DEFAULT, Times(ArcSinh(Plus(c_, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT)), -2), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Sqrt(Plus(Times(C2, c, d, Sqr(x)), Times(Sqr(d), Power(x, 4)))), Power(Times(C2, b, d, x, Plus(a, Times(b, ArcSinh(Plus(c, Times(d, Sqr(x))))))), -1)), x)), Simp(Times(x, Plus(Cosh(Times(a, Power(Times(C2, b), -1))), Times(CN1, c, Sinh(Times(a, Power(Times(C2, b), -1))))), CoshIntegral(Times(Plus(a, Times(b, ArcSinh(Plus(c, Times(d, Sqr(x)))))), Power(Times(C2, b), -1))), Power(Times(C4, Sqr(b), Plus(Cosh(Times(C1D2, ArcSinh(Plus(c, Times(d, Sqr(x)))))), Times(c, Sinh(Times(C1D2, ArcSinh(Plus(c, Times(d, Sqr(x))))))))), -1)), x), Simp(Times(x, Plus(Times(c, Cosh(Times(a, Power(Times(C2, b), -1)))), Negate(Sinh(Times(a, Power(Times(C2, b), -1))))), SinhIntegral(Times(Plus(a, Times(b, ArcSinh(Plus(c, Times(d, Sqr(x)))))), Power(Times(C2, b), -1))), Power(Times(C4, Sqr(b), Plus(Cosh(Times(C1D2, ArcSinh(Plus(c, Times(d, Sqr(x)))))), Times(c, Sinh(Times(C1D2, ArcSinh(Plus(c, Times(d, Sqr(x))))))))), -1)), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Sqr(c), CN1)))),
            IIntegrate(5877, Int(Power(Plus(a_DEFAULT, Times(ArcSinh(Plus(c_, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT)), n_), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(x, Power(Plus(a, Times(b, ArcSinh(Plus(c, Times(d, Sqr(x)))))), Plus(n, C2)), Power(Times(C4, Sqr(b), Plus(n, C1), Plus(n, C2)), -1)), x)), Dist(Power(Times(C4, Sqr(b), Plus(n, C1), Plus(n, C2)), -1), Int(Power(Plus(a, Times(b, ArcSinh(Plus(c, Times(d, Sqr(x)))))), Plus(n, C2)), x), x), Simp(Times(Sqrt(Plus(Times(C2, c, d, Sqr(x)), Times(Sqr(d), Power(x, 4)))), Power(Plus(a, Times(b, ArcSinh(Plus(c, Times(d, Sqr(x)))))), Plus(n, C1)), Power(Times(C2, b, d, Plus(n, C1), x), -1)), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Sqr(c), CN1), LtQ(n, CN1), NeQ(n, CN2)))),
            IIntegrate(5878, Int(Sqrt(Plus(a_DEFAULT, Times(ArcCosh(Plus(C1, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT))), x_Symbol),
                    Condition(Plus(Simp(Times(C2, Sqrt(Plus(a, Times(b, ArcCosh(Plus(C1, Times(d, Sqr(x))))))), Sqr(Sinh(Times(C1D2, ArcCosh(Plus(C1, Times(d, Sqr(x))))))), Power(Times(d, x), -1)), x), Simp(Times(Sqrt(b), Sqrt(Times(C1D2, Pi)), Plus(Cosh(Times(a, Power(Times(C2, b), -1))), Sinh(Times(a, Power(Times(C2, b), -1)))), Sinh(Times(C1D2, ArcCosh(Plus(C1, Times(d, Sqr(x)))))), Erf(Times(Power(Times(C2, b), CN1D2), Sqrt(Plus(a, Times(b, ArcCosh(Plus(C1, Times(d, Sqr(x))))))))), Power(Times(d, x), -1)), x), Negate(Simp(Times(Sqrt(b), Sqrt(Times(C1D2, Pi)), Plus(Cosh(Times(a, Power(Times(C2, b), -1))), Negate(Sinh(Times(a, Power(Times(C2, b), -1))))), Sinh(Times(C1D2, ArcCosh(Plus(C1, Times(d, Sqr(x)))))), Erfi(Times(Power(Times(C2, b), CN1D2), Sqrt(Plus(a, Times(b, ArcCosh(Plus(C1, Times(d, Sqr(x))))))))), Power(Times(d, x), -1)), x))), FreeQ(List(a, b, d), x))),
            IIntegrate(5879, Int(Sqrt(Plus(a_DEFAULT, Times(ArcCosh(Plus(CN1, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT))), x_Symbol),
                    Condition(Plus(Simp(Times(C2, Sqrt(Plus(a, Times(b, ArcCosh(Plus(CN1, Times(d, Sqr(x))))))), Sqr(Cosh(Times(C1D2, ArcCosh(Plus(CN1, Times(d, Sqr(x))))))), Power(Times(d, x), -1)), x), Negate(Simp(Times(Sqrt(b), Sqrt(Times(C1D2, Pi)), Plus(Cosh(Times(a, Power(Times(C2, b), -1))), Sinh(Times(a, Power(Times(C2, b), -1)))), Cosh(Times(C1D2, ArcCosh(Plus(CN1, Times(d, Sqr(x)))))), Erf(Times(Power(Times(C2, b), CN1D2), Sqrt(Plus(a, Times(b, ArcCosh(Plus(CN1, Times(d, Sqr(x))))))))), Power(Times(d, x), -1)), x)), Negate(Simp(Times(Sqrt(b), Sqrt(Times(C1D2, Pi)), Plus(Cosh(Times(a, Power(Times(C2, b), -1))), Negate(Sinh(Times(a, Power(Times(C2, b), -1))))), Cosh(Times(C1D2, ArcCosh(Plus(CN1, Times(d, Sqr(x)))))), Erfi(Times(Power(Times(C2, b), CN1D2), Sqrt(Plus(a, Times(b, ArcCosh(Plus(CN1, Times(d, Sqr(x))))))))), Power(Times(d, x), -1)), x))), FreeQ(List(a, b, d), x))),
            IIntegrate(5880, Int(Power(Plus(a_DEFAULT, Times(ArcCosh(Plus(c_, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT)), n_), x_Symbol),
                    Condition(Plus(Simp(Times(x, Power(Plus(a, Times(b, ArcCosh(Plus(c, Times(d, Sqr(x)))))), n)), x), Dist(Times(C4, Sqr(b), n, Plus(n, Negate(C1))), Int(Power(Plus(a, Times(b, ArcCosh(Plus(c, Times(d, Sqr(x)))))), Plus(n, Negate(C2))), x), x), Negate(Simp(Times(C2, b, n, Plus(Times(C2, c, d, Sqr(x)), Times(Sqr(d), Power(x, 4))), Power(Plus(a, Times(b, ArcCosh(Plus(c, Times(d, Sqr(x)))))), Plus(n, Negate(C1))), Power(Times(d, x, Sqrt(Plus(CN1, c, Times(d, Sqr(x)))), Sqrt(Plus(C1, c, Times(d, Sqr(x))))), -1)), x))), And(FreeQ(List(a, b, c, d), x), EqQ(Sqr(c), C1), GtQ(n, C1)))),
            IIntegrate(5881, Int(Power(Plus(a_DEFAULT, Times(ArcCosh(Plus(C1, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT)), -1), x_Symbol),
                    Condition(Plus(Simp(Times(x, Cosh(Times(a, Power(Times(C2, b), -1))), CoshIntegral(Times(Plus(a, Times(b, ArcCosh(Plus(C1, Times(d, Sqr(x)))))), Power(Times(C2, b), -1))), Power(Times(CSqrt2, b, Sqrt(Times(d, Sqr(x)))), -1)), x), Negate(Simp(Times(x, Sinh(Times(a, Power(Times(C2, b), -1))), SinhIntegral(Times(Plus(a, Times(b, ArcCosh(Plus(C1, Times(d, Sqr(x)))))), Power(Times(C2, b), -1))), Power(Times(CSqrt2, b, Sqrt(Times(d, Sqr(x)))), -1)), x))), FreeQ(List(a, b, d), x))),
            IIntegrate(5882, Int(Power(Plus(a_DEFAULT, Times(ArcCosh(Plus(CN1, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT)), -1), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(x, Sinh(Times(a, Power(Times(C2, b), -1))), CoshIntegral(Times(Plus(a, Times(b, ArcCosh(Plus(CN1, Times(d, Sqr(x)))))), Power(Times(C2, b), -1))), Power(Times(CSqrt2, b, Sqrt(Times(d, Sqr(x)))), -1)), x)), Simp(Times(x, Cosh(Times(a, Power(Times(C2, b), -1))), SinhIntegral(Times(Plus(a, Times(b, ArcCosh(Plus(CN1, Times(d, Sqr(x)))))), Power(Times(C2, b), -1))), Power(Times(CSqrt2, b, Sqrt(Times(d, Sqr(x)))), -1)), x)), FreeQ(List(a, b, d), x))),
            IIntegrate(5883, Int(Power(Plus(a_DEFAULT, Times(ArcCosh(Plus(C1, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT)), CN1D2), x_Symbol),
                    Condition(Plus(Simp(Times(Sqrt(Times(C1D2, Pi)), Plus(Cosh(Times(a, Power(Times(C2, b), -1))), Negate(Sinh(Times(a, Power(Times(C2, b), -1))))), Sinh(Times(C1D2, ArcCosh(Plus(C1, Times(d, Sqr(x)))))), Erfi(Times(Sqrt(Plus(a, Times(b, ArcCosh(Plus(C1, Times(d, Sqr(x))))))), Power(Times(C2, b), CN1D2))), Power(Times(Sqrt(b), d, x), -1)), x), Simp(Times(Sqrt(Times(C1D2, Pi)), Plus(Cosh(Times(a, Power(Times(C2, b), -1))), Sinh(Times(a, Power(Times(C2, b), -1)))), Sinh(Times(C1D2, ArcCosh(Plus(C1, Times(d, Sqr(x)))))), Erf(Times(Sqrt(Plus(a, Times(b, ArcCosh(Plus(C1, Times(d, Sqr(x))))))), Power(Times(C2, b), CN1D2))), Power(Times(Sqrt(b), d, x), -1)), x)), FreeQ(List(a, b, d), x))),
            IIntegrate(5884, Int(Power(Plus(a_DEFAULT, Times(ArcCosh(Plus(CN1, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT)), CN1D2), x_Symbol),
                    Condition(Plus(Simp(Times(Sqrt(Times(C1D2, Pi)), Plus(Cosh(Times(a, Power(Times(C2, b), -1))), Negate(Sinh(Times(a, Power(Times(C2, b), -1))))), Cosh(Times(C1D2, ArcCosh(Plus(CN1, Times(d, Sqr(x)))))), Erfi(Times(Sqrt(Plus(a, Times(b, ArcCosh(Plus(CN1, Times(d, Sqr(x))))))), Power(Times(C2, b), CN1D2))), Power(Times(Sqrt(b), d, x), -1)), x), Negate(Simp(Times(Sqrt(Times(C1D2, Pi)), Plus(Cosh(Times(a, Power(Times(C2, b), -1))), Sinh(Times(a, Power(Times(C2, b), -1)))), Cosh(Times(C1D2, ArcCosh(Plus(CN1, Times(d, Sqr(x)))))), Erf(Times(Sqrt(Plus(a, Times(b, ArcCosh(Plus(CN1, Times(d, Sqr(x))))))), Power(Times(C2, b), CN1D2))), Power(Times(Sqrt(b), d, x), -1)), x))), FreeQ(List(a, b, d), x))),
            IIntegrate(5885, Int(Power(Plus(a_DEFAULT, Times(ArcCosh(Plus(C1, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT)), QQ(-3L, 2L)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Sqrt(Times(d, Sqr(x))), Sqrt(Plus(C2, Times(d, Sqr(x)))), Power(Times(b, d, x, Sqrt(Plus(a, Times(b, ArcCosh(Plus(C1, Times(d, Sqr(x)))))))), -1)), x)), Negate(Simp(Times(Sqrt(Times(C1D2, Pi)), Plus(Cosh(Times(a, Power(Times(C2, b), -1))), Sinh(Times(a, Power(Times(C2, b), -1)))), Sinh(Times(C1D2, ArcCosh(Plus(C1, Times(d, Sqr(x)))))), Erf(Times(Sqrt(Plus(a, Times(b, ArcCosh(Plus(C1, Times(d, Sqr(x))))))), Power(Times(C2, b), CN1D2))), Power(Times(Power(b, QQ(3L, 2L)), d, x), -1)), x)), Simp(Times(Sqrt(Times(C1D2, Pi)), Plus(Cosh(Times(a, Power(Times(C2, b), -1))), Negate(Sinh(Times(a, Power(Times(C2, b), -1))))), Sinh(Times(C1D2, ArcCosh(Plus(C1, Times(d, Sqr(x)))))), Erfi(Times(Sqrt(Plus(a, Times(b, ArcCosh(Plus(C1, Times(d, Sqr(x))))))), Power(Times(C2, b), CN1D2))), Power(Times(Power(b, QQ(3L, 2L)), d, x), -1)), x)), FreeQ(List(a, b, d), x))),
            IIntegrate(5886, Int(Power(Plus(a_DEFAULT, Times(ArcCosh(Plus(CN1, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT)), QQ(-3L, 2L)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Sqrt(Times(d, Sqr(x))), Sqrt(Plus(CN2, Times(d, Sqr(x)))), Power(Times(b, d, x, Sqrt(Plus(a, Times(b, ArcCosh(Plus(CN1, Times(d, Sqr(x)))))))), -1)), x)), Simp(Times(Sqrt(Times(C1D2, Pi)), Plus(Cosh(Times(a, Power(Times(C2, b), -1))), Sinh(Times(a, Power(Times(C2, b), -1)))), Cosh(Times(C1D2, ArcCosh(Plus(CN1, Times(d, Sqr(x)))))), Erf(Times(Sqrt(Plus(a, Times(b, ArcCosh(Plus(CN1, Times(d, Sqr(x))))))), Power(Times(C2, b), CN1D2))), Power(Times(Power(b, QQ(3L, 2L)), d, x), -1)), x), Simp(Times(Sqrt(Times(C1D2, Pi)), Plus(Cosh(Times(a, Power(Times(C2, b), -1))), Negate(Sinh(Times(a, Power(Times(C2, b), -1))))), Cosh(Times(C1D2, ArcCosh(Plus(CN1, Times(d, Sqr(x)))))), Erfi(Times(Sqrt(Plus(a, Times(b, ArcCosh(Plus(CN1, Times(d, Sqr(x))))))), Power(Times(C2, b), CN1D2))), Power(Times(Power(b, QQ(3L, 2L)), d, x), -1)), x)), FreeQ(List(a, b, d), x))),
            IIntegrate(5887, Int(Power(Plus(a_DEFAULT, Times(ArcCosh(Plus(C1, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT)), -2), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Sqrt(Times(d, Sqr(x))), Sqrt(Plus(C2, Times(d, Sqr(x)))), Power(Times(C2, b, d, x, Plus(a, Times(b, ArcCosh(Plus(C1, Times(d, Sqr(x))))))), -1)), x)), Negate(Simp(Times(x, Sinh(Times(a, Power(Times(C2, b), -1))), CoshIntegral(Times(Plus(a, Times(b, ArcCosh(Plus(C1, Times(d, Sqr(x)))))), Power(Times(C2, b), -1))), Power(Times(C2, CSqrt2, Sqr(b), Sqrt(Times(d, Sqr(x)))), -1)), x)), Simp(Times(x, Cosh(Times(a, Power(Times(C2, b), -1))), SinhIntegral(Times(Plus(a, Times(b, ArcCosh(Plus(C1, Times(d, Sqr(x)))))), Power(Times(C2, b), -1))), Power(Times(C2, CSqrt2, Sqr(b), Sqrt(Times(d, Sqr(x)))), -1)), x)), FreeQ(List(a, b, d), x))),
            IIntegrate(5888, Int(Power(Plus(a_DEFAULT, Times(ArcCosh(Plus(CN1, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT)), -2), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Sqrt(Times(d, Sqr(x))), Sqrt(Plus(CN2, Times(d, Sqr(x)))), Power(Times(C2, b, d, x, Plus(a, Times(b, ArcCosh(Plus(CN1, Times(d, Sqr(x))))))), -1)), x)), Simp(Times(x, Cosh(Times(a, Power(Times(C2, b), -1))), CoshIntegral(Times(Plus(a, Times(b, ArcCosh(Plus(CN1, Times(d, Sqr(x)))))), Power(Times(C2, b), -1))), Power(Times(C2, CSqrt2, Sqr(b), Sqrt(Times(d, Sqr(x)))), -1)), x), Negate(Simp(Times(x, Sinh(Times(a, Power(Times(C2, b), -1))), SinhIntegral(Times(Plus(a, Times(b, ArcCosh(Plus(CN1, Times(d, Sqr(x)))))), Power(Times(C2, b), -1))), Power(Times(C2, CSqrt2, Sqr(b), Sqrt(Times(d, Sqr(x)))), -1)), x))), FreeQ(List(a, b, d), x))),
            IIntegrate(5889, Int(Power(Plus(a_DEFAULT, Times(ArcCosh(Plus(c_, Times(d_DEFAULT, Sqr(x_)))), b_DEFAULT)), n_), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(x, Power(Plus(a, Times(b, ArcCosh(Plus(c, Times(d, Sqr(x)))))), Plus(n, C2)), Power(Times(C4, Sqr(b), Plus(n, C1), Plus(n, C2)), -1)), x)), Dist(Power(Times(C4, Sqr(b), Plus(n, C1), Plus(n, C2)), -1), Int(Power(Plus(a, Times(b, ArcCosh(Plus(c, Times(d, Sqr(x)))))), Plus(n, C2)), x), x), Simp(Times(Plus(Times(C2, c, Sqr(x)), Times(d, Power(x, 4))), Power(Plus(a, Times(b, ArcCosh(Plus(c, Times(d, Sqr(x)))))), Plus(n, C1)), Power(Times(C2, b, Plus(n, C1), x, Sqrt(Plus(CN1, c, Times(d, Sqr(x)))), Sqrt(Plus(C1, c, Times(d, Sqr(x))))), -1)), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Sqr(c), C1), LtQ(n, CN1), NeQ(n, CN2)))),
            IIntegrate(5890, Int(Times(Power(ArcSinh(Times(a_DEFAULT, Power(x_, p_))), n_DEFAULT), Power(x_, -1)), x_Symbol),
                    Condition(Dist(Power(p, -1), Subst(Int(Times(Power(x, n), Coth(x)), x), x, ArcSinh(Times(a, Power(x, p)))), x), And(FreeQ(List(a, p), x), IGtQ(n, C0)))),
            IIntegrate(5891, Int(Times(Power(ArcCosh(Times(a_DEFAULT, Power(x_, p_))), n_DEFAULT), Power(x_, -1)), x_Symbol),
                    Condition(Dist(Power(p, -1), Subst(Int(Times(Power(x, n), Tanh(x)), x), x, ArcCosh(Times(a, Power(x, p)))), x), And(FreeQ(List(a, p), x), IGtQ(n, C0)))),
            IIntegrate(5892, Int(Times(Power(ArcSinh(Times(c_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT))), -1))), m_DEFAULT), u_DEFAULT), x_Symbol),
                    Condition(Int(Times(u, Power(ArcCsch(Plus(Times(a, Power(c, -1)), Times(b, Power(x, n), Power(c, -1)))), m)), x), FreeQ(List(a, b, c, n, m), x))),
            IIntegrate(5893, Int(Times(Power(ArcCosh(Times(c_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT))), -1))), m_DEFAULT), u_DEFAULT), x_Symbol),
                    Condition(Int(Times(u, Power(ArcSech(Plus(Times(a, Power(c, -1)), Times(b, Power(x, n), Power(c, -1)))), m)), x), FreeQ(List(a, b, c, n, m), x))),
            IIntegrate(5894, Int(Times(Power(ArcSinh(Sqrt(Plus(CN1, Times(b_DEFAULT, Sqr(x_))))), n_DEFAULT), Power(Plus(CN1, Times(b_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Times(b, Sqr(x))), Power(Times(b, x), -1)), Subst(Int(Times(Power(ArcSinh(x), n), Power(Plus(C1, Sqr(x)), CN1D2)), x), x, Sqrt(Plus(CN1, Times(b, Sqr(x))))), x), FreeQ(List(b, n), x))),
            IIntegrate(5895, Int(Times(Power(ArcCosh(Sqrt(Plus(C1, Times(b_DEFAULT, Sqr(x_))))), n_DEFAULT), Power(Plus(C1, Times(b_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Plus(CN1, Sqrt(Plus(C1, Times(b, Sqr(x)))))), Sqrt(Plus(C1, Sqrt(Plus(C1, Times(b, Sqr(x)))))), Power(Times(b, x), -1)), Subst(Int(Times(Power(ArcCosh(x), n), Power(Times(Sqrt(Plus(CN1, x)), Sqrt(Plus(C1, x))), -1)), x), x, Sqrt(Plus(C1, Times(b, Sqr(x))))), x), FreeQ(List(b, n), x))),
            IIntegrate(5896, Int(Power(f_, Times(Power(ArcSinh(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT), c_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(b, -1), Subst(Int(Times(Power(f, Times(c, Power(x, n))), Cosh(x)), x), x, ArcSinh(Plus(a, Times(b, x)))), x), And(FreeQ(List(a, b, c, f), x), IGtQ(n, C0)))),
            IIntegrate(5897, Int(Power(f_, Times(Power(ArcCosh(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT), c_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(b, -1), Subst(Int(Times(Power(f, Times(c, Power(x, n))), Sinh(x)), x), x, ArcCosh(Plus(a, Times(b, x)))), x), And(FreeQ(List(a, b, c, f), x), IGtQ(n, C0)))),
            IIntegrate(5898, Int(Times(Power(f_, Times(Power(ArcSinh(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT), c_DEFAULT)), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(b, -1), Subst(Int(Times(Power(Plus(Times(CN1, a, Power(b, -1)), Times(Sinh(x), Power(b, -1))), m), Power(f, Times(c, Power(x, n))), Cosh(x)), x), x, ArcSinh(Plus(a, Times(b, x)))), x), And(FreeQ(List(a, b, c, f), x), IGtQ(m, C0), IGtQ(n, C0)))),
            IIntegrate(5899, Int(Times(Power(f_, Times(Power(ArcCosh(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT), c_DEFAULT)), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(b, -1), Subst(Int(Times(Power(Plus(Times(CN1, a, Power(b, -1)), Times(Cosh(x), Power(b, -1))), m), Power(f, Times(c, Power(x, n))), Sinh(x)), x), x, ArcCosh(Plus(a, Times(b, x)))), x), And(FreeQ(List(a, b, c, f), x), IGtQ(m, C0), IGtQ(n, C0)))),
            IIntegrate(5900, Int(ArcSinh(u_), x_Symbol),
                    Condition(Plus(Simp(Times(x, ArcSinh(u)), x), Negate(Int(SimplifyIntegrand(Times(x, D(u, x), Power(Plus(C1, Sqr(u)), CN1D2)), x), x))), And(InverseFunctionFreeQ(u, x), Not(FunctionOfExponentialQ(u, x)))))
    );
}
