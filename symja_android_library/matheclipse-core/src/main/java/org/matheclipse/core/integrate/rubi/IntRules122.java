package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.ASymbol;
import static org.matheclipse.core.expression.F.A_DEFAULT;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcCoth;
import static org.matheclipse.core.expression.F.ArcTanh;
import static org.matheclipse.core.expression.F.BSymbol;
import static org.matheclipse.core.expression.F.B_DEFAULT;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CSymbol;
import static org.matheclipse.core.expression.F.C_DEFAULT;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Exp;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.MatchQ;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.QQ;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
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
import static org.matheclipse.core.expression.F.e_;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_DEFAULT;
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
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules122 {
    public static IAST RULES = List(
            IIntegrate(6101, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, Power(x_, n_))), b_DEFAULT)), p_DEFAULT), u_DEFAULT), x_Symbol),
                    Condition(Unintegrable(Times(u, Power(Plus(a, Times(b, ArcTanh(Times(c, Power(x, n))))), p)), x), And(FreeQ(List(a, b, c, n, p), x), Or(EqQ(u, C1), MatchQ(u, Condition(Power(Times(d_DEFAULT, x), m_DEFAULT), FreeQ(List(d, m), x))))))),
            IIntegrate(6102, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, Power(x_, n_))), b_DEFAULT)), p_DEFAULT), u_DEFAULT), x_Symbol),
                    Condition(Unintegrable(Times(u, Power(Plus(a, Times(b, ArcCoth(Times(c, Power(x, n))))), p)), x), And(FreeQ(List(a, b, c, n, p), x), Or(EqQ(u, C1), MatchQ(u, Condition(Power(Times(d_DEFAULT, x), m_DEFAULT), FreeQ(List(d, m), x))))))),
            IIntegrate(6103, Int(Power(Plus(a_DEFAULT, Times(ArcTanh(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Power(d, -1), Subst(Int(Power(Plus(a, Times(b, ArcTanh(x))), p), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d), x), IGtQ(p, C0)))),
            IIntegrate(6104, Int(Power(Plus(a_DEFAULT, Times(ArcCoth(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Power(d, -1), Subst(Int(Power(Plus(a, Times(b, ArcCoth(x))), p), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d), x), IGtQ(p, C0)))),
            IIntegrate(6105, Int(Power(Plus(a_DEFAULT, Times(ArcTanh(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_), x_Symbol),
                    Condition(Unintegrable(Power(Plus(a, Times(b, ArcTanh(Plus(c, Times(d, x))))), p), x), And(FreeQ(List(a, b, c, d, p), x), Not(IGtQ(p, C0))))),
            IIntegrate(6106, Int(Power(Plus(a_DEFAULT, Times(ArcCoth(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_), x_Symbol),
                    Condition(Unintegrable(Power(Plus(a, Times(b, ArcCoth(Plus(c, Times(d, x))))), p), x), And(FreeQ(List(a, b, c, d, p), x), Not(IGtQ(p, C0))))),
            IIntegrate(6107, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, -1), Subst(Int(Times(Power(Times(f, x, Power(d, -1)), m), Power(Plus(a, Times(b, ArcTanh(x))), p)), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d, e, f, m), x), EqQ(Plus(Times(d, e), Times(CN1, c, f)), C0), IGtQ(p, C0)))),
            IIntegrate(6108, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, -1), Subst(Int(Times(Power(Times(f, x, Power(d, -1)), m), Power(Plus(a, Times(b, ArcCoth(x))), p)), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d, e, f, m), x), EqQ(Plus(Times(d, e), Times(CN1, c, f)), C0), IGtQ(p, C0)))),
            IIntegrate(6109, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Power(Plus(a, Times(b, ArcTanh(Plus(c, Times(d, x))))), p), Power(Times(f, Plus(m, C1)), -1)), x), Negate(Dist(Times(b, d, p, Power(Times(f, Plus(m, C1)), -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Power(Plus(a, Times(b, ArcTanh(Plus(c, Times(d, x))))), Plus(p, Negate(C1))), Power(Plus(C1, Negate(Sqr(Plus(c, Times(d, x))))), -1)), x), x))), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(p, C0), ILtQ(m, CN1)))),
            IIntegrate(6110, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Power(Plus(a, Times(b, ArcCoth(Plus(c, Times(d, x))))), p), Power(Times(f, Plus(m, C1)), -1)), x), Negate(Dist(Times(b, d, p, Power(Times(f, Plus(m, C1)), -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Power(Plus(a, Times(b, ArcCoth(Plus(c, Times(d, x))))), Plus(p, Negate(C1))), Power(Plus(C1, Negate(Sqr(Plus(c, Times(d, x))))), -1)), x), x))), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(p, C0), ILtQ(m, CN1)))),
            IIntegrate(6111, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, -1), Subst(Int(Times(Power(Plus(Times(Plus(Times(d, e), Times(CN1, c, f)), Power(d, -1)), Times(f, x, Power(d, -1))), m), Power(Plus(a, Times(b, ArcTanh(x))), p)), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d, e, f, m), x), IGtQ(p, C0)))),
            IIntegrate(6112, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, -1), Subst(Int(Times(Power(Plus(Times(Plus(Times(d, e), Times(CN1, c, f)), Power(d, -1)), Times(f, x, Power(d, -1))), m), Power(Plus(a, Times(b, ArcCoth(x))), p)), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d, e, f, m), x), IGtQ(p, C0)))),
            IIntegrate(6113, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(e, Times(f, x)), m), Power(Plus(a, Times(b, ArcTanh(Plus(c, Times(d, x))))), p)), x), And(FreeQ(List(a, b, c, d, e, f, m, p), x), Not(IGtQ(p, C0))))),
            IIntegrate(6114, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(e, Times(f, x)), m), Power(Plus(a, Times(b, ArcCoth(Plus(c, Times(d, x))))), p)), x), And(FreeQ(List(a, b, c, d, e, f, m, p), x), Not(IGtQ(p, C0))))),
            IIntegrate(6115, Int(Times(ArcTanh(Plus(c_, Times(d_DEFAULT, x_))), Power(Plus(e_, Times(f_DEFAULT, Power(x_, n_DEFAULT))), -1)), x_Symbol),
                    Condition(Plus(Dist(C1D2, Int(Times(Log(Plus(C1, c, Times(d, x))), Power(Plus(e, Times(f, Power(x, n))), -1)), x), x), Negate(Dist(C1D2, Int(Times(Log(Plus(C1, Negate(c), Times(CN1, d, x))), Power(Plus(e, Times(f, Power(x, n))), -1)), x), x))), And(FreeQ(List(c, d, e, f), x), RationalQ(n)))),
            IIntegrate(6116, Int(Times(ArcCoth(Plus(c_, Times(d_DEFAULT, x_))), Power(Plus(e_, Times(f_DEFAULT, Power(x_, n_DEFAULT))), -1)), x_Symbol),
                    Condition(Plus(Dist(C1D2, Int(Times(Log(Times(Plus(C1, c, Times(d, x)), Power(Plus(c, Times(d, x)), -1))), Power(Plus(e, Times(f, Power(x, n))), -1)), x), x), Negate(Dist(C1D2, Int(Times(Log(Times(Plus(CN1, c, Times(d, x)), Power(Plus(c, Times(d, x)), -1))), Power(Plus(e, Times(f, Power(x, n))), -1)), x), x))), And(FreeQ(List(c, d, e, f), x), RationalQ(n)))),
            IIntegrate(6117, Int(Times(ArcTanh(Plus(c_, Times(d_DEFAULT, x_))), Power(Plus(e_, Times(f_DEFAULT, Power(x_, n_))), -1)), x_Symbol),
                    Condition(Unintegrable(Times(ArcTanh(Plus(c, Times(d, x))), Power(Plus(e, Times(f, Power(x, n))), -1)), x), And(FreeQ(List(c, d, e, f, n), x), Not(RationalQ(n))))),
            IIntegrate(6118, Int(Times(ArcCoth(Plus(c_, Times(d_DEFAULT, x_))), Power(Plus(e_, Times(f_DEFAULT, Power(x_, n_))), -1)), x_Symbol),
                    Condition(Unintegrable(Times(ArcCoth(Plus(c, Times(d, x))), Power(Plus(e, Times(f, Power(x, n))), -1)), x), And(FreeQ(List(c, d, e, f, n), x), Not(RationalQ(n))))),
            IIntegrate(6119, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), Power(Plus(A_DEFAULT, Times(B_DEFAULT, x_), Times(C_DEFAULT, Sqr(x_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, -1), Subst(Int(Times(Power(Plus(Times(CN1, CSymbol, Power(d, -2)), Times(CSymbol, Sqr(x), Power(d, -2))), q), Power(Plus(a, Times(b, ArcTanh(x))), p)), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d, ASymbol, BSymbol, CSymbol, p, q), x), EqQ(Plus(Times(BSymbol, Plus(C1, Negate(Sqr(c)))), Times(C2, ASymbol, c, d)), C0), EqQ(Plus(Times(C2, c, CSymbol), Times(CN1, BSymbol, d)), C0)))),
            IIntegrate(6120, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), Power(Plus(A_DEFAULT, Times(B_DEFAULT, x_), Times(C_DEFAULT, Sqr(x_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, -1), Subst(Int(Times(Power(Plus(Times(CSymbol, Power(d, -2)), Times(CSymbol, Sqr(x), Power(d, -2))), q), Power(Plus(a, Times(b, ArcCoth(x))), p)), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d, ASymbol, BSymbol, CSymbol, p, q), x), EqQ(Plus(Times(BSymbol, Plus(C1, Negate(Sqr(c)))), Times(C2, ASymbol, c, d)), C0), EqQ(Plus(Times(C2, c, CSymbol), Times(CN1, BSymbol, d)), C0)))),
            IIntegrate(6121, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Plus(A_DEFAULT, Times(B_DEFAULT, x_), Times(C_DEFAULT, Sqr(x_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, -1), Subst(Int(Times(Power(Plus(Times(Plus(Times(d, e), Times(CN1, c, f)), Power(d, -1)), Times(f, x, Power(d, -1))), m), Power(Plus(Times(CN1, CSymbol, Power(d, -2)), Times(CSymbol, Sqr(x), Power(d, -2))), q), Power(Plus(a, Times(b, ArcTanh(x))), p)), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, CSymbol, m, p, q), x), EqQ(Plus(Times(BSymbol, Plus(C1, Negate(Sqr(c)))), Times(C2, ASymbol, c, d)), C0), EqQ(Plus(Times(C2, c, CSymbol), Times(CN1, BSymbol, d)), C0)))),
            IIntegrate(6122, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Plus(A_DEFAULT, Times(B_DEFAULT, x_), Times(C_DEFAULT, Sqr(x_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, -1), Subst(Int(Times(Power(Plus(Times(Plus(Times(d, e), Times(CN1, c, f)), Power(d, -1)), Times(f, x, Power(d, -1))), m), Power(Plus(Times(CN1, CSymbol, Power(d, -2)), Times(CSymbol, Sqr(x), Power(d, -2))), q), Power(Plus(a, Times(b, ArcCoth(x))), p)), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, CSymbol, m, p, q), x), EqQ(Plus(Times(BSymbol, Plus(C1, Negate(Sqr(c)))), Times(C2, ASymbol, c, d)), C0), EqQ(Plus(Times(C2, c, CSymbol), Times(CN1, BSymbol, d)), C0)))),
            IIntegrate(6123, Int(Exp(Times(ArcTanh(Times(a_DEFAULT, x_)), n_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Plus(C1, Times(a, x)), Times(C1D2, Plus(n, C1))), Power(Times(Power(Plus(C1, Times(CN1, a, x)), Times(C1D2, Plus(n, Negate(C1)))), Sqrt(Plus(C1, Times(CN1, Sqr(a), Sqr(x))))), -1)), x), And(FreeQ(a, x), IntegerQ(Times(C1D2, Plus(n, Negate(C1))))))),
            IIntegrate(6124, Int(Times(Exp(Times(ArcTanh(Times(a_DEFAULT, x_)), n_DEFAULT)), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(x, m), Power(Plus(C1, Times(a, x)), Times(C1D2, Plus(n, C1))), Power(Times(Power(Plus(C1, Times(CN1, a, x)), Times(C1D2, Plus(n, Negate(C1)))), Sqrt(Plus(C1, Times(CN1, Sqr(a), Sqr(x))))), -1)), x), And(FreeQ(List(a, m), x), IntegerQ(Times(C1D2, Plus(n, Negate(C1))))))),
            IIntegrate(6125, Int(Exp(Times(ArcTanh(Times(a_DEFAULT, x_)), n_)), x_Symbol),
                    Condition(Int(Times(Power(Plus(C1, Times(a, x)), Times(C1D2, n)), Power(Power(Plus(C1, Times(CN1, a, x)), Times(C1D2, n)), -1)), x), And(FreeQ(List(a, n), x), Not(IntegerQ(Times(C1D2, Plus(n, Negate(C1)))))))),
            IIntegrate(6126, Int(Times(Exp(Times(ArcTanh(Times(a_DEFAULT, x_)), n_)), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(x, m), Power(Plus(C1, Times(a, x)), Times(C1D2, n)), Power(Power(Plus(C1, Times(CN1, a, x)), Times(C1D2, n)), -1)), x), And(FreeQ(List(a, m, n), x), Not(IntegerQ(Times(C1D2, Plus(n, Negate(C1)))))))),
            IIntegrate(6127, Int(Times(Exp(Times(ArcTanh(Times(a_DEFAULT, x_)), n_DEFAULT)), Power(Plus(c_, Times(d_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(c, n), Int(Times(Power(Plus(c, Times(d, x)), Plus(p, Negate(n))), Power(Plus(C1, Times(CN1, Sqr(a), Sqr(x))), Times(C1D2, n))), x), x), And(FreeQ(List(a, c, d, p), x), EqQ(Plus(Times(a, c), d), C0), IntegerQ(Times(C1D2, Plus(n, Negate(C1)))), IntegerQ(Times(C2, p))))),
            IIntegrate(6128, Int(Times(Exp(Times(ArcTanh(Times(a_DEFAULT, x_)), n_DEFAULT)), Power(Plus(c_, Times(d_DEFAULT, x_)), p_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(c, n), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Plus(c, Times(d, x)), Plus(p, Negate(n))), Power(Plus(C1, Times(CN1, Sqr(a), Sqr(x))), Times(C1D2, n))), x), x), And(FreeQ(List(a, c, d, e, f, m, p), x), EqQ(Plus(Times(a, c), d), C0), IntegerQ(Times(C1D2, Plus(n, Negate(C1)))), Or(IntegerQ(p), EqQ(p, Times(C1D2, n)), EqQ(Plus(p, Times(CN1, C1D2, n), Negate(C1)), C0)), IntegerQ(Times(C2, p))))),
            IIntegrate(6129, Int(Times(Exp(Times(ArcTanh(Times(a_DEFAULT, x_)), n_DEFAULT)), u_DEFAULT, Power(Plus(c_, Times(d_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(c, p), Int(Times(u, Power(Plus(C1, Times(d, x, Power(c, -1))), p), Power(Plus(C1, Times(a, x)), Times(C1D2, n)), Power(Power(Plus(C1, Times(CN1, a, x)), Times(C1D2, n)), -1)), x), x), And(FreeQ(List(a, c, d, n, p), x), EqQ(Plus(Times(Sqr(a), Sqr(c)), Negate(Sqr(d))), C0), Or(IntegerQ(p), GtQ(c, C0))))),
            IIntegrate(6130, Int(Times(Exp(Times(ArcTanh(Times(a_DEFAULT, x_)), n_DEFAULT)), u_DEFAULT, Power(Plus(c_, Times(d_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(u, Power(Plus(c, Times(d, x)), p), Power(Plus(C1, Times(a, x)), Times(C1D2, n)), Power(Power(Plus(C1, Times(CN1, a, x)), Times(C1D2, n)), -1)), x), And(FreeQ(List(a, c, d, n, p), x), EqQ(Plus(Times(Sqr(a), Sqr(c)), Negate(Sqr(d))), C0), Not(Or(IntegerQ(p), GtQ(c, C0)))))),
            IIntegrate(6131, Int(Times(Exp(Times(ArcTanh(Times(a_DEFAULT, x_)), n_DEFAULT)), u_DEFAULT, Power(Plus(c_, Times(d_DEFAULT, Power(x_, -1))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, p), Int(Times(u, Power(Plus(C1, Times(c, x, Power(d, -1))), p), Exp(Times(n, ArcTanh(Times(a, x)))), Power(Power(x, p), -1)), x), x), And(FreeQ(List(a, c, d, n), x), EqQ(Plus(Sqr(c), Times(CN1, Sqr(a), Sqr(d))), C0), IntegerQ(p)))),
            IIntegrate(6132, Int(Times(Exp(Times(ArcTanh(Times(a_DEFAULT, x_)), n_)), u_DEFAULT, Power(Plus(c_, Times(d_DEFAULT, Power(x_, -1))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(CN1, Times(C1D2, n)), Power(c, p)), Int(Times(u, Power(Plus(C1, Times(d, Power(Times(c, x), -1))), p), Power(Plus(C1, Power(Times(a, x), -1)), Times(C1D2, n)), Power(Power(Plus(C1, Negate(Power(Times(a, x), -1))), Times(C1D2, n)), -1)), x), x), And(FreeQ(List(a, c, d, p), x), EqQ(Plus(Sqr(c), Times(CN1, Sqr(a), Sqr(d))), C0), Not(IntegerQ(p)), IntegerQ(Times(C1D2, n)), GtQ(c, C0)))),
            IIntegrate(6133, Int(Times(Exp(Times(ArcTanh(Times(a_DEFAULT, x_)), n_)), u_DEFAULT, Power(Plus(c_, Times(d_DEFAULT, Power(x_, -1))), p_)), x_Symbol),
                    Condition(Int(Times(u, Power(Plus(c, Times(d, Power(x, -1))), p), Power(Plus(C1, Times(a, x)), Times(C1D2, n)), Power(Power(Plus(C1, Times(CN1, a, x)), Times(C1D2, n)), -1)), x), And(FreeQ(List(a, c, d, p), x), EqQ(Plus(Sqr(c), Times(CN1, Sqr(a), Sqr(d))), C0), Not(IntegerQ(p)), IntegerQ(Times(C1D2, n)), Not(GtQ(c, C0))))),
            IIntegrate(6134, Int(Times(Exp(Times(ArcTanh(Times(a_DEFAULT, x_)), n_DEFAULT)), u_DEFAULT, Power(Plus(c_, Times(d_DEFAULT, Power(x_, -1))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(x, p), Power(Plus(c, Times(d, Power(x, -1))), p), Power(Power(Plus(C1, Times(c, x, Power(d, -1))), p), -1)), Int(Times(u, Power(Plus(C1, Times(c, x, Power(d, -1))), p), Exp(Times(n, ArcTanh(Times(a, x)))), Power(Power(x, p), -1)), x), x), And(FreeQ(List(a, c, d, n, p), x), EqQ(Plus(Sqr(c), Times(CN1, Sqr(a), Sqr(d))), C0), Not(IntegerQ(p))))),
            IIntegrate(6135, Int(Times(Exp(Times(ArcTanh(Times(a_DEFAULT, x_)), n_)), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), QQ(-3L, 2L))), x_Symbol),
                    Condition(Simp(Times(Plus(n, Times(CN1, a, x)), Exp(Times(n, ArcTanh(Times(a, x)))), Power(Times(a, c, Plus(Sqr(n), Negate(C1)), Sqrt(Plus(c, Times(d, Sqr(x))))), -1)), x), And(FreeQ(List(a, c, d, n), x), EqQ(Plus(Times(Sqr(a), c), d), C0), Not(IntegerQ(n))))),
            IIntegrate(6136, Int(Times(Exp(Times(ArcTanh(Times(a_DEFAULT, x_)), n_)), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(n, Times(C2, a, Plus(p, C1), x)), Power(Plus(c, Times(d, Sqr(x))), Plus(p, C1)), Exp(Times(n, ArcTanh(Times(a, x)))), Power(Times(a, c, Plus(Sqr(n), Times(CN1, C4, Sqr(Plus(p, C1))))), -1)), x), Negate(Dist(Times(C2, Plus(p, C1), Plus(Times(C2, p), C3), Power(Times(c, Plus(Sqr(n), Times(CN1, C4, Sqr(Plus(p, C1))))), -1)), Int(Times(Power(Plus(c, Times(d, Sqr(x))), Plus(p, C1)), Exp(Times(n, ArcTanh(Times(a, x))))), x), x))), And(FreeQ(List(a, c, d, n), x), EqQ(Plus(Times(Sqr(a), c), d), C0), LtQ(p, CN1), Not(IntegerQ(n)), NeQ(Plus(Sqr(n), Times(CN1, C4, Sqr(Plus(p, C1)))), C0), IntegerQ(Times(C2, p))))),
            IIntegrate(6137, Int(Times(Exp(Times(ArcTanh(Times(a_DEFAULT, x_)), n_DEFAULT)), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), -1)), x_Symbol),
                    Condition(Simp(Times(Exp(Times(n, ArcTanh(Times(a, x)))), Power(Times(a, c, n), -1)), x), And(FreeQ(List(a, c, d, n), x), EqQ(Plus(Times(Sqr(a), c), d), C0), Not(IntegerQ(Times(C1D2, n)))))),
            IIntegrate(6138, Int(Times(Exp(Times(ArcTanh(Times(a_DEFAULT, x_)), n_DEFAULT)), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(c, p), Int(Times(Power(Plus(C1, Times(CN1, Sqr(a), Sqr(x))), Plus(p, Times(CN1, C1D2, n))), Power(Plus(C1, Times(a, x)), n)), x), x), And(FreeQ(List(a, c, d, p), x), EqQ(Plus(Times(Sqr(a), c), d), C0), IntegerQ(p), IGtQ(Times(C1D2, Plus(n, C1)), C0), Not(IntegerQ(Plus(p, Times(CN1, C1D2, n))))))),
            IIntegrate(6139, Int(Times(Exp(Times(ArcTanh(Times(a_DEFAULT, x_)), n_)), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(c, p), Int(Times(Power(Plus(C1, Times(CN1, Sqr(a), Sqr(x))), Plus(p, Times(C1D2, n))), Power(Power(Plus(C1, Times(CN1, a, x)), n), -1)), x), x), And(FreeQ(List(a, c, d, p), x), EqQ(Plus(Times(Sqr(a), c), d), C0), IntegerQ(p), ILtQ(Times(C1D2, Plus(n, Negate(C1))), C0), Not(IntegerQ(Plus(p, Times(CN1, C1D2, n))))))),
            IIntegrate(6140, Int(Times(Exp(Times(ArcTanh(Times(a_DEFAULT, x_)), n_DEFAULT)), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(c, p), Int(Times(Power(Plus(C1, Times(CN1, a, x)), Plus(p, Times(CN1, C1D2, n))), Power(Plus(C1, Times(a, x)), Plus(p, Times(C1D2, n)))), x), x), And(FreeQ(List(a, c, d, n, p), x), EqQ(Plus(Times(Sqr(a), c), d), C0), Or(IntegerQ(p), GtQ(c, C0))))),
            IIntegrate(6141, Int(Times(Exp(Times(ArcTanh(Times(a_DEFAULT, x_)), n_)), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(c, Times(C1D2, n)), Int(Times(Power(Plus(c, Times(d, Sqr(x))), Plus(p, Times(CN1, C1D2, n))), Power(Plus(C1, Times(a, x)), n)), x), x), And(FreeQ(List(a, c, d, p), x), EqQ(Plus(Times(Sqr(a), c), d), C0), Not(Or(IntegerQ(p), GtQ(c, C0))), IGtQ(Times(C1D2, n), C0)))),
            IIntegrate(6142, Int(Times(Exp(Times(ArcTanh(Times(a_DEFAULT, x_)), n_)), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Power(c, Times(C1D2, n)), -1), Int(Times(Power(Plus(c, Times(d, Sqr(x))), Plus(p, Times(C1D2, n))), Power(Power(Plus(C1, Times(CN1, a, x)), n), -1)), x), x), And(FreeQ(List(a, c, d, p), x), EqQ(Plus(Times(Sqr(a), c), d), C0), Not(Or(IntegerQ(p), GtQ(c, C0))), ILtQ(Times(C1D2, n), C0)))),
            IIntegrate(6143, Int(Times(Exp(Times(ArcTanh(Times(a_DEFAULT, x_)), n_DEFAULT)), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(c, IntPart(p)), Power(Plus(c, Times(d, Sqr(x))), FracPart(p)), Power(Power(Plus(C1, Times(CN1, Sqr(a), Sqr(x))), FracPart(p)), -1)), Int(Times(Power(Plus(C1, Times(CN1, Sqr(a), Sqr(x))), p), Exp(Times(n, ArcTanh(Times(a, x))))), x), x), And(FreeQ(List(a, c, d, n, p), x), EqQ(Plus(Times(Sqr(a), c), d), C0), Not(Or(IntegerQ(p), GtQ(c, C0)))))),
            IIntegrate(6144, Int(Times(Exp(Times(ArcTanh(Times(a_DEFAULT, x_)), n_)), x_, Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), QQ(-3L, 2L))), x_Symbol),
                    Condition(Simp(Times(Plus(C1, Times(CN1, a, n, x)), Exp(Times(n, ArcTanh(Times(a, x)))), Power(Times(d, Plus(Sqr(n), Negate(C1)), Sqrt(Plus(c, Times(d, Sqr(x))))), -1)), x), And(FreeQ(List(a, c, d, n), x), EqQ(Plus(Times(Sqr(a), c), d), C0), Not(IntegerQ(n))))),
            IIntegrate(6145, Int(Times(Exp(Times(ArcTanh(Times(a_DEFAULT, x_)), n_)), x_, Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(c, Times(d, Sqr(x))), Plus(p, C1)), Exp(Times(n, ArcTanh(Times(a, x)))), Power(Times(C2, d, Plus(p, C1)), -1)), x), Negate(Dist(Times(a, c, n, Power(Times(C2, d, Plus(p, C1)), -1)), Int(Times(Power(Plus(c, Times(d, Sqr(x))), p), Exp(Times(n, ArcTanh(Times(a, x))))), x), x))), And(FreeQ(List(a, c, d, n), x), EqQ(Plus(Times(Sqr(a), c), d), C0), LtQ(p, CN1), Not(IntegerQ(n)), IntegerQ(Times(C2, p))))),
            IIntegrate(6146, Int(Times(Exp(Times(ArcTanh(Times(a_DEFAULT, x_)), n_)), Sqr(x_), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Simp(Times(Plus(C1, Times(CN1, a, n, x)), Power(Plus(c, Times(d, Sqr(x))), Plus(p, C1)), Exp(Times(n, ArcTanh(Times(a, x)))), Power(Times(a, d, n, Plus(Sqr(n), Negate(C1))), -1)), x), And(FreeQ(List(a, c, d, n), x), EqQ(Plus(Times(Sqr(a), c), d), C0), EqQ(Plus(Sqr(n), Times(C2, Plus(p, C1))), C0), Not(IntegerQ(n))))),
            IIntegrate(6147, Int(Times(Exp(Times(ArcTanh(Times(a_DEFAULT, x_)), n_)), Sqr(x_), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Plus(n, Times(C2, Plus(p, C1), a, x)), Power(Plus(c, Times(d, Sqr(x))), Plus(p, C1)), Exp(Times(n, ArcTanh(Times(a, x)))), Power(Times(a, d, Plus(Sqr(n), Times(CN1, C4, Sqr(Plus(p, C1))))), -1)), x)), Dist(Times(Plus(Sqr(n), Times(C2, Plus(p, C1))), Power(Times(d, Plus(Sqr(n), Times(CN1, C4, Sqr(Plus(p, C1))))), -1)), Int(Times(Power(Plus(c, Times(d, Sqr(x))), Plus(p, C1)), Exp(Times(n, ArcTanh(Times(a, x))))), x), x)), And(FreeQ(List(a, c, d, n), x), EqQ(Plus(Times(Sqr(a), c), d), C0), LtQ(p, CN1), Not(IntegerQ(n)), NeQ(Plus(Sqr(n), Times(CN1, C4, Sqr(Plus(p, C1)))), C0), IntegerQ(Times(C2, p))))),
            IIntegrate(6148, Int(Times(Exp(Times(ArcTanh(Times(a_DEFAULT, x_)), n_DEFAULT)), Power(x_, m_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(c, p), Int(Times(Power(x, m), Power(Plus(C1, Times(CN1, Sqr(a), Sqr(x))), Plus(p, Times(CN1, C1D2, n))), Power(Plus(C1, Times(a, x)), n)), x), x), And(FreeQ(List(a, c, d, m, p), x), EqQ(Plus(Times(Sqr(a), c), d), C0), Or(IntegerQ(p), GtQ(c, C0)), IGtQ(Times(C1D2, Plus(n, C1)), C0), Not(IntegerQ(Plus(p, Times(CN1, C1D2, n))))))),
            IIntegrate(6149, Int(Times(Exp(Times(ArcTanh(Times(a_DEFAULT, x_)), n_)), Power(x_, m_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(c, p), Int(Times(Power(x, m), Power(Plus(C1, Times(CN1, Sqr(a), Sqr(x))), Plus(p, Times(C1D2, n))), Power(Power(Plus(C1, Times(CN1, a, x)), n), -1)), x), x), And(FreeQ(List(a, c, d, m, p), x), EqQ(Plus(Times(Sqr(a), c), d), C0), Or(IntegerQ(p), GtQ(c, C0)), ILtQ(Times(C1D2, Plus(n, Negate(C1))), C0), Not(IntegerQ(Plus(p, Times(CN1, C1D2, n))))))),
            IIntegrate(6150, Int(Times(Exp(Times(ArcTanh(Times(a_DEFAULT, x_)), n_DEFAULT)), Power(x_, m_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(c, p), Int(Times(Power(x, m), Power(Plus(C1, Times(CN1, a, x)), Plus(p, Times(CN1, C1D2, n))), Power(Plus(C1, Times(a, x)), Plus(p, Times(C1D2, n)))), x), x), And(FreeQ(List(a, c, d, m, n, p), x), EqQ(Plus(Times(Sqr(a), c), d), C0), Or(IntegerQ(p), GtQ(c, C0)))))
    );
}
