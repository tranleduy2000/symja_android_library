package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.Block;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cosh;
import static org.matheclipse.core.expression.F.CoshIntegral;
import static org.matheclipse.core.expression.F.Exp;
import static org.matheclipse.core.expression.F.F_;
import static org.matheclipse.core.expression.F.Factorial;
import static org.matheclipse.core.expression.F.False;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.Gamma;
import static org.matheclipse.core.expression.F.HypergeometricPFQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.LogGamma;
import static org.matheclipse.core.expression.F.MemberQ;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.PolyGamma;
import static org.matheclipse.core.expression.F.PolyLog;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sinh;
import static org.matheclipse.core.expression.F.SinhIntegral;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.True;
import static org.matheclipse.core.expression.F.Zeta;
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
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.g_;
import static org.matheclipse.core.expression.F.g_DEFAULT;
import static org.matheclipse.core.expression.F.h;
import static org.matheclipse.core.expression.F.h_DEFAULT;
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
import static org.matheclipse.core.expression.F.r;
import static org.matheclipse.core.expression.F.r_DEFAULT;
import static org.matheclipse.core.expression.F.s;
import static org.matheclipse.core.expression.F.s_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.F;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;
import static org.matheclipse.core.expression.F.*;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules131 {
    public static IAST RULES = List(
            IIntegrate(6551, Int(Times(CoshIntegral(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_), Sinh(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Sinh(Plus(a, Times(b, x))), CoshIntegral(Plus(c, Times(d, x))), Power(Times(f, Plus(m, C1)), -1)), x), Negate(Dist(Times(b, Power(Times(f, Plus(m, C1)), -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Cosh(Plus(a, Times(b, x))), CoshIntegral(Plus(c, Times(d, x)))), x), x)), Negate(Dist(Times(d, Power(Times(f, Plus(m, C1)), -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Sinh(Plus(a, Times(b, x))), Cosh(Plus(c, Times(d, x))), Power(Plus(c, Times(d, x)), -1)), x), x))), And(FreeQ(List(a, b, c, d, e, f), x), ILtQ(m, CN1)))),
            IIntegrate(6552, Int(SinhIntegral(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(x, SinhIntegral(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n)))))))), x), Negate(Dist(Times(b, d, n), Int(Times(Sinh(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n)))))), -1)), x), x))), FreeQ(List(a, b, c, d, n), x))),
            IIntegrate(6553, Int(CoshIntegral(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(x, CoshIntegral(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n)))))))), x), Negate(Dist(Times(b, d, n), Int(Times(Cosh(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n)))))), -1)), x), x))), FreeQ(List(a, b, c, d, n), x))),
            IIntegrate(6554, Int(Times(Power(x_, -1), $(F_, Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT))), x_Symbol),
                    Condition(Dist(Power(n, -1), Subst(F(Times(d, Plus(a, Times(b, x)))), x, Log(Times(c, Power(x, n)))), x), And(FreeQ(List(a, b, c, d, n), x), MemberQ(List(SinhIntegral, CoshIntegral), x)))),
            IIntegrate(6555, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), SinhIntegral(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(e, x), Plus(m, C1)), SinhIntegral(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Times(e, Plus(m, C1)), -1)), x), Negate(Dist(Times(b, d, n, Power(Plus(m, C1), -1)), Int(Times(Power(Times(e, x), m), Sinh(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n)))))), -1)), x), x))), And(FreeQ(List(a, b, c, d, e, m, n), x), NeQ(m, CN1)))),
            IIntegrate(6556, Int(Times(CoshIntegral(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(e, x), Plus(m, C1)), CoshIntegral(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Times(e, Plus(m, C1)), -1)), x), Negate(Dist(Times(b, d, n, Power(Plus(m, C1), -1)), Int(Times(Power(Times(e, x), m), Cosh(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n)))))), -1)), x), x))), And(FreeQ(List(a, b, c, d, e, m, n), x), NeQ(m, CN1)))),
            IIntegrate(6557, Int(Gamma(n_, Plus(a_DEFAULT, Times(b_DEFAULT, x_))), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(a, Times(b, x)), Gamma(n, Plus(a, Times(b, x))), Power(b, -1)), x), Negate(Simp(Times(Gamma(Plus(n, C1), Plus(a, Times(b, x))), Power(b, -1)), x))), FreeQ(List(a, b, n), x))),
            IIntegrate(6558, Int(Times(Gamma(C0, Times(b_DEFAULT, x_)), Power(x_, -1)), x_Symbol),
                    Condition(Plus(Simp(Times(b, x, HypergeometricPFQ(List(C1, C1, C1), List(C2, C2, C2), Times(CN1, b, x))), x), Negate(Simp(Times(EulerGamma, Log(x)), x)), Negate(Simp(Times(C1D2, C1, Sqr(Log(Times(b, x)))), x))), FreeQ(b, x))),
            IIntegrate(6559, Int(Times(Gamma(n_, Times(b_DEFAULT, x_)), Power(x_, -1)), x_Symbol),
                    Condition(Plus(Negate(Simp(Gamma(Plus(n, Negate(C1)), Times(b, x)), x)), Dist(Plus(n, Negate(C1)), Int(Times(Gamma(Plus(n, Negate(C1)), Times(b, x)), Power(x, -1)), x), x)), And(FreeQ(b, x), IGtQ(n, C1)))),
            IIntegrate(6560, Int(Times(Gamma(n_, Times(b_DEFAULT, x_)), Power(x_, -1)), x_Symbol),
                    Condition(Plus(Simp(Times(Gamma(n, Times(b, x)), Power(n, -1)), x), Dist(Power(n, -1), Int(Times(Gamma(Plus(n, C1), Times(b, x)), Power(x, -1)), x), x)), And(FreeQ(b, x), ILtQ(n, C0)))),
            IIntegrate(6561, Int(Times(Gamma(n_, Times(b_DEFAULT, x_)), Power(x_, -1)), x_Symbol),
                    Condition(Plus(Simp(Times(Gamma(n), Log(x)), x), Negate(Simp(Times(Power(Times(b, x), n), HypergeometricPFQ(List(n, n), List(Plus(C1, n), Plus(C1, n)), Times(CN1, b, x)), Power(n, -2)), x))), And(FreeQ(List(b, n), x), Not(IntegerQ(n))))),
            IIntegrate(6562, Int(Times(Gamma(n_, Times(b_DEFAULT, x_)), Power(Times(d_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(d, x), Plus(m, C1)), Gamma(n, Times(b, x)), Power(Times(d, Plus(m, C1)), -1)), x), Negate(Simp(Times(Power(Times(d, x), m), Gamma(Plus(m, n, C1), Times(b, x)), Power(Times(b, Plus(m, C1), Power(Times(b, x), m)), -1)), x))), And(FreeQ(List(b, d, m, n), x), NeQ(m, CN1)))),
            IIntegrate(6563, Int(Times(Gamma(n_, Plus(a_, Times(b_DEFAULT, x_))), Power(Plus(c_, Times(d_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(b, -1), Subst(Int(Times(Power(Times(d, x, Power(b, -1)), m), Gamma(n, x)), x), x, Plus(a, Times(b, x))), x), And(FreeQ(List(a, b, c, d, m, n), x), EqQ(Plus(Times(b, c), Times(CN1, a, d)), C0)))),
            IIntegrate(6564, Int(Times(Gamma(n_, Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), -1)), x_Symbol),
                    Condition(Plus(Int(Times(Power(Plus(a, Times(b, x)), Plus(n, Negate(C1))), Power(Times(Plus(c, Times(d, x)), Exp(Plus(a, Times(b, x)))), -1)), x), Dist(Plus(n, Negate(C1)), Int(Times(Gamma(Plus(n, Negate(C1)), Plus(a, Times(b, x))), Power(Plus(c, Times(d, x)), -1)), x), x)), And(FreeQ(List(a, b, c, d), x), IGtQ(n, C1)))),
            IIntegrate(6565, Int(Times(Gamma(n_, Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Block(List(Set(False, True)), Plus(Simp(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), Gamma(n, Plus(a, Times(b, x))), Power(Times(d, Plus(m, C1)), -1)), x), Dist(Times(b, Power(Times(d, Plus(m, C1)), -1)), Int(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), Power(Plus(a, Times(b, x)), Plus(n, Negate(C1))), Power(Exp(Plus(a, Times(b, x))), -1)), x), x))), And(FreeQ(List(a, b, c, d, m, n), x), Or(IGtQ(m, C0), IGtQ(n, C0), IntegersQ(m, n)), NeQ(m, CN1)))),
            IIntegrate(6566, Int(Times(Gamma(n_, Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(c, Times(d, x)), m), Gamma(n, Plus(a, Times(b, x)))), x), FreeQ(List(a, b, c, d, m, n), x))),
            IIntegrate(6567, Int(LogGamma(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), x_Symbol),
                    Condition(Simp(Times(PolyGamma(CN2, Plus(a, Times(b, x))), Power(b, -1)), x), FreeQ(List(a, b), x))),
            IIntegrate(6568, Int(Times(LogGamma(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(c, Times(d, x)), m), PolyGamma(CN2, Plus(a, Times(b, x))), Power(b, -1)), x), Negate(Dist(Times(d, m, Power(b, -1)), Int(Times(Power(Plus(c, Times(d, x)), Plus(m, Negate(C1))), PolyGamma(CN2, Plus(a, Times(b, x)))), x), x))), And(FreeQ(List(a, b, c, d), x), IGtQ(m, C0)))),
            IIntegrate(6569, Int(Times(LogGamma(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(c, Times(d, x)), m), LogGamma(Plus(a, Times(b, x)))), x), FreeQ(List(a, b, c, d, m), x))),
            IIntegrate(6570, Int(PolyGamma(n_, Plus(a_DEFAULT, Times(b_DEFAULT, x_))), x_Symbol),
                    Condition(Simp(Times(PolyGamma(Plus(n, Negate(C1)), Plus(a, Times(b, x))), Power(b, -1)), x), FreeQ(List(a, b, n), x))),
            IIntegrate(6571, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), PolyGamma(n_, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(c, Times(d, x)), m), PolyGamma(Plus(n, Negate(C1)), Plus(a, Times(b, x))), Power(b, -1)), x), Negate(Dist(Times(d, m, Power(b, -1)), Int(Times(Power(Plus(c, Times(d, x)), Plus(m, Negate(C1))), PolyGamma(Plus(n, Negate(C1)), Plus(a, Times(b, x)))), x), x))), And(FreeQ(List(a, b, c, d, n), x), GtQ(m, C0)))),
            IIntegrate(6572, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), PolyGamma(n_, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), PolyGamma(n, Plus(a, Times(b, x))), Power(Times(d, Plus(m, C1)), -1)), x), Negate(Dist(Times(b, Power(Times(d, Plus(m, C1)), -1)), Int(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), PolyGamma(Plus(n, C1), Plus(a, Times(b, x)))), x), x))), And(FreeQ(List(a, b, c, d, n), x), LtQ(m, CN1)))),
            IIntegrate(6573, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), PolyGamma(n_, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(c, Times(d, x)), m), PolyGamma(n, Plus(a, Times(b, x)))), x), FreeQ(List(a, b, c, d, m, n), x))),
            IIntegrate(6574, Int(Times(Power(Gamma(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT), PolyGamma(C0, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), x_Symbol),
                    Condition(Simp(Times(Power(Gamma(Plus(a, Times(b, x))), n), Power(Times(b, n), -1)), x), FreeQ(List(a, b, n), x))),
            IIntegrate(6575, Int(Times(Power(Factorial(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT), PolyGamma(C0, Plus(c_DEFAULT, Times(b_DEFAULT, x_)))), x_Symbol),
                    Condition(Simp(Times(Power(Factorial(Plus(a, Times(b, x))), n), Power(Times(b, n), -1)), x), And(FreeQ(List(a, b, c, n), x), EqQ(c, Plus(a, C1))))),
            IIntegrate(6576, Int(Gamma(p_, Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(x, Gamma(p, Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n)))))))), x), Dist(Times(b, d, n, Power(Exp(Times(a, d)), -1)), Int(Times(Power(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n)))))), Plus(p, Negate(C1))), Power(Power(Times(c, Power(x, n)), Times(b, d)), -1)), x), x)), FreeQ(List(a, b, c, d, n, p), x))),
            IIntegrate(6577, Int(Times(Gamma(p_, Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), Power(x_, -1)), x_Symbol),
                    Condition(Dist(Power(n, -1), Subst(Gamma(p, Times(d, Plus(a, Times(b, x)))), x, Log(Times(c, Power(x, n)))), x), FreeQ(List(a, b, c, d, n, p), x))),
            IIntegrate(6578, Int(Times(Gamma(p_, Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(e, x), Plus(m, C1)), Gamma(p, Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Times(e, Plus(m, C1)), -1)), x), Dist(Times(b, d, n, Power(Times(e, x), Times(b, d, n)), Power(Times(Exp(Times(a, d)), Plus(m, C1), Power(Times(c, Power(x, n)), Times(b, d))), -1)), Int(Times(Power(Times(e, x), Plus(m, Times(CN1, b, d, n))), Power(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n)))))), Plus(p, Negate(C1)))), x), x)), And(FreeQ(List(a, b, c, d, e, m, n, p), x), NeQ(m, CN1)))),
            IIntegrate(6579, Int(Gamma(p_, Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), f_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(e, -1), Subst(Int(Gamma(p, Times(f, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), x), x, Plus(d, Times(e, x))), x), FreeQ(List(a, b, c, d, e, f, n, p), x))),
            IIntegrate(6580, Int(Times(Gamma(p_, Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(Plus(d_, Times(e_DEFAULT, x_)), n_DEFAULT))), b_DEFAULT)), f_DEFAULT)), Power(Plus(g_, Times(h_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(e, -1), Subst(Int(Times(Power(Times(g, x, Power(d, -1)), m), Gamma(p, Times(f, Plus(a, Times(b, Log(Times(c, Power(x, n)))))))), x), x, Plus(d, Times(e, x))), x), And(FreeQ(List(a, b, c, d, e, f, g, h, m, n, p), x), EqQ(Plus(Times(e, g), Times(CN1, d, h)), C0)))),
            IIntegrate(6581, Int(Zeta(C2, Plus(a_DEFAULT, Times(b_DEFAULT, x_))), x_Symbol),
                    Condition(Int(PolyGamma(C1, Plus(a, Times(b, x))), x), FreeQ(List(a, b), x))),
            IIntegrate(6582, Int(Zeta(s_, Plus(a_DEFAULT, Times(b_DEFAULT, x_))), x_Symbol),
                    Condition(Negate(Simp(Times(Zeta(Plus(s, Negate(C1)), Plus(a, Times(b, x))), Power(Times(b, Plus(s, Negate(C1))), -1)), x)), And(FreeQ(List(a, b, s), x), NeQ(s, C1), NeQ(s, C2)))),
            IIntegrate(6583, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Zeta(C2, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), x_Symbol),
                    Condition(Int(Times(Power(Plus(c, Times(d, x)), m), PolyGamma(C1, Plus(a, Times(b, x)))), x), And(FreeQ(List(a, b, c, d), x), RationalQ(m)))),
            IIntegrate(6584, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Zeta(s_, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(c, Times(d, x)), m), Zeta(Plus(s, Negate(C1)), Plus(a, Times(b, x))), Power(Times(b, Plus(s, Negate(C1))), -1)), x)), Dist(Times(d, m, Power(Times(b, Plus(s, Negate(C1))), -1)), Int(Times(Power(Plus(c, Times(d, x)), Plus(m, Negate(C1))), Zeta(Plus(s, Negate(C1)), Plus(a, Times(b, x)))), x), x)), And(FreeQ(List(a, b, c, d, s), x), NeQ(s, C1), NeQ(s, C2), GtQ(m, C0)))),
            IIntegrate(6585, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Zeta(s_, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), Zeta(s, Plus(a, Times(b, x))), Power(Times(d, Plus(m, C1)), -1)), x), Dist(Times(b, s, Power(Times(d, Plus(m, C1)), -1)), Int(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), Zeta(Plus(s, C1), Plus(a, Times(b, x)))), x), x)), And(FreeQ(List(a, b, c, d, s), x), NeQ(s, C1), NeQ(s, C2), LtQ(m, CN1)))),
            IIntegrate(6586, Int(PolyLog(n_, Times(a_DEFAULT, Power(Times(b_DEFAULT, Power(x_, p_DEFAULT)), q_DEFAULT))), x_Symbol),
                    Condition(Plus(Simp(Times(x, PolyLog(n, Times(a, Power(Times(b, Power(x, p)), q)))), x), Negate(Dist(Times(p, q), Int(PolyLog(Plus(n, Negate(C1)), Times(a, Power(Times(b, Power(x, p)), q))), x), x))), And(FreeQ(List(a, b, p, q), x), GtQ(n, C0)))),
            IIntegrate(6587, Int(PolyLog(n_, Times(a_DEFAULT, Power(Times(b_DEFAULT, Power(x_, p_DEFAULT)), q_DEFAULT))), x_Symbol),
                    Condition(Plus(Simp(Times(x, PolyLog(Plus(n, C1), Times(a, Power(Times(b, Power(x, p)), q))), Power(Times(p, q), -1)), x), Negate(Dist(Power(Times(p, q), -1), Int(PolyLog(Plus(n, C1), Times(a, Power(Times(b, Power(x, p)), q))), x), x))), And(FreeQ(List(a, b, p, q), x), LtQ(n, CN1)))),
            IIntegrate(6588, Int(PolyLog(n_, Times(a_DEFAULT, Power(Times(b_DEFAULT, Power(x_, p_DEFAULT)), q_DEFAULT))), x_Symbol),
                    Condition(Unintegrable(PolyLog(n, Times(a, Power(Times(b, Power(x, p)), q))), x), FreeQ(List(a, b, n, p, q), x))),
            IIntegrate(6589, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), -1), PolyLog(n_, Times(c_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), p_DEFAULT)))), x_Symbol),
                    Condition(Simp(Times(PolyLog(Plus(n, C1), Times(c, Power(Plus(a, Times(b, x)), p))), Power(Times(e, p), -1)), x), And(FreeQ(List(a, b, c, d, e, n, p), x), EqQ(Times(b, d), Times(a, e))))),
            IIntegrate(6590, Int(Times(Power(x_, -1), PolyLog(n_, Times(a_DEFAULT, Power(Times(b_DEFAULT, Power(x_, p_DEFAULT)), q_DEFAULT)))), x_Symbol),
                    Condition(Simp(Times(PolyLog(Plus(n, C1), Times(a, Power(Times(b, Power(x, p)), q))), Power(Times(p, q), -1)), x), FreeQ(List(a, b, n, p, q), x))),
            IIntegrate(6591, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), PolyLog(n_, Times(a_DEFAULT, Power(Times(b_DEFAULT, Power(x_, p_DEFAULT)), q_DEFAULT)))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(d, x), Plus(m, C1)), PolyLog(n, Times(a, Power(Times(b, Power(x, p)), q))), Power(Times(d, Plus(m, C1)), -1)), x), Negate(Dist(Times(p, q, Power(Plus(m, C1), -1)), Int(Times(Power(Times(d, x), m), PolyLog(Plus(n, Negate(C1)), Times(a, Power(Times(b, Power(x, p)), q)))), x), x))), And(FreeQ(List(a, b, d, m, p, q), x), NeQ(m, CN1), GtQ(n, C0)))),
            IIntegrate(6592, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), PolyLog(n_, Times(a_DEFAULT, Power(Times(b_DEFAULT, Power(x_, p_DEFAULT)), q_DEFAULT)))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(d, x), Plus(m, C1)), PolyLog(Plus(n, C1), Times(a, Power(Times(b, Power(x, p)), q))), Power(Times(d, p, q), -1)), x), Negate(Dist(Times(Plus(m, C1), Power(Times(p, q), -1)), Int(Times(Power(Times(d, x), m), PolyLog(Plus(n, C1), Times(a, Power(Times(b, Power(x, p)), q)))), x), x))), And(FreeQ(List(a, b, d, m, p, q), x), NeQ(m, CN1), LtQ(n, CN1)))),
            IIntegrate(6593, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), PolyLog(n_, Times(a_DEFAULT, Power(Times(b_DEFAULT, Power(x_, p_DEFAULT)), q_DEFAULT)))), x_Symbol),
                    Condition(Unintegrable(Times(Power(Times(d, x), m), PolyLog(n, Times(a, Power(Times(b, Power(x, p)), q)))), x), FreeQ(List(a, b, d, m, n, p, q), x))),
            IIntegrate(6594, Int(Times(Power(Log(Times(c_DEFAULT, Power(x_, m_DEFAULT))), r_DEFAULT), Power(x_, -1), PolyLog(n_, Times(a_DEFAULT, Power(Times(b_DEFAULT, Power(x_, p_DEFAULT)), q_DEFAULT)))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Log(Times(c, Power(x, m))), r), PolyLog(Plus(n, C1), Times(a, Power(Times(b, Power(x, p)), q))), Power(Times(p, q), -1)), x), Negate(Dist(Times(m, r, Power(Times(p, q), -1)), Int(Times(Power(Log(Times(c, Power(x, m))), Plus(r, Negate(C1))), PolyLog(Plus(n, C1), Times(a, Power(Times(b, Power(x, p)), q))), Power(x, -1)), x), x))), And(FreeQ(List(a, b, c, m, n, q, r), x), GtQ(r, C0)))),
            IIntegrate(6595, Int(PolyLog(n_, Times(c_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), p_DEFAULT))), x_Symbol),
                    Condition(Plus(Simp(Times(x, PolyLog(n, Times(c, Power(Plus(a, Times(b, x)), p)))), x), Negate(Dist(p, Int(PolyLog(Plus(n, Negate(C1)), Times(c, Power(Plus(a, Times(b, x)), p))), x), x)), Dist(Times(a, p), Int(Times(PolyLog(Plus(n, Negate(C1)), Times(c, Power(Plus(a, Times(b, x)), p))), Power(Plus(a, Times(b, x)), -1)), x), x)), And(FreeQ(List(a, b, c, p), x), GtQ(n, C0)))),
            IIntegrate(6596, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), -1), PolyLog(C2, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), x_Symbol),
                    Condition(Plus(Simp(Times(Log(Plus(C1, Times(CN1, a, c), Times(CN1, b, c, x))), PolyLog(C2, Times(c, Plus(a, Times(b, x)))), Power(e, -1)), x), Dist(Times(b, Power(e, -1)), Int(Times(Sqr(Log(Plus(C1, Times(CN1, a, c), Times(CN1, b, c, x)))), Power(Plus(a, Times(b, x)), -1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(c, Plus(Times(b, d), Times(CN1, a, e))), e), C0)))),
            IIntegrate(6597, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), -1), PolyLog(C2, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), x_Symbol),
                    Condition(Plus(Simp(Times(Log(Plus(d, Times(e, x))), PolyLog(C2, Times(c, Plus(a, Times(b, x)))), Power(e, -1)), x), Dist(Times(b, Power(e, -1)), Int(Times(Log(Plus(d, Times(e, x))), Log(Plus(C1, Times(CN1, a, c), Times(CN1, b, c, x))), Power(Plus(a, Times(b, x)), -1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), NeQ(Plus(Times(c, Plus(Times(b, d), Times(CN1, a, e))), e), C0)))),
            IIntegrate(6598, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_DEFAULT), PolyLog(C2, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), PolyLog(C2, Times(c, Plus(a, Times(b, x)))), Power(Times(e, Plus(m, C1)), -1)), x), Dist(Times(b, Power(Times(e, Plus(m, C1)), -1)), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Log(Plus(C1, Times(CN1, a, c), Times(CN1, b, c, x))), Power(Plus(a, Times(b, x)), -1)), x), x)), And(FreeQ(List(a, b, c, d, e, m), x), NeQ(m, CN1)))),
            IIntegrate(6599, Int(Times(Power(x_, m_DEFAULT), PolyLog(n_, Times(c_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), p_DEFAULT)))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Plus(Power(a, Plus(m, C1)), Times(CN1, Power(b, Plus(m, C1)), Power(x, Plus(m, C1)))), PolyLog(n, Times(c, Power(Plus(a, Times(b, x)), p))), Power(Times(Plus(m, C1), Power(b, Plus(m, C1))), -1)), x)), Dist(Times(p, Power(Times(Plus(m, C1), Power(b, m)), -1)), Int(ExpandIntegrand(PolyLog(Plus(n, Negate(C1)), Times(c, Power(Plus(a, Times(b, x)), p))), Times(Plus(Power(a, Plus(m, C1)), Times(CN1, Power(b, Plus(m, C1)), Power(x, Plus(m, C1)))), Power(Plus(a, Times(b, x)), -1)), x), x), x)), And(FreeQ(List(a, b, c, p), x), GtQ(n, C0), IntegerQ(m), NeQ(m, CN1)))),
            IIntegrate(6600, Int(Times(Plus(g_DEFAULT, Times(Log(Times(f_DEFAULT, Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), n_DEFAULT))), h_DEFAULT)), PolyLog(C2, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), x_Symbol),
                    Condition(Plus(Simp(Times(x, Plus(g, Times(h, Log(Times(f, Power(Plus(d, Times(e, x)), n))))), PolyLog(C2, Times(c, Plus(a, Times(b, x))))), x), Dist(b, Int(Times(Plus(g, Times(h, Log(Times(f, Power(Plus(d, Times(e, x)), n))))), Log(Plus(C1, Times(CN1, a, c), Times(CN1, b, c, x))), ExpandIntegrand(Times(x, Power(Plus(a, Times(b, x)), -1)), x)), x), x), Negate(Dist(Times(e, h, n), Int(Times(PolyLog(C2, Times(c, Plus(a, Times(b, x)))), ExpandIntegrand(Times(x, Power(Plus(d, Times(e, x)), -1)), x)), x), x))), FreeQ(List(a, b, c, d, e, f, g, h, n), x)))
    );
}
