package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CI;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.CosIntegral;
import static org.matheclipse.core.expression.F.Cosh;
import static org.matheclipse.core.expression.F.CoshIntegral;
import static org.matheclipse.core.expression.F.F_;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.HypergeometricPFQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.MemberQ;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.SinIntegral;
import static org.matheclipse.core.expression.F.Sinh;
import static org.matheclipse.core.expression.F.SinhIntegral;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Times;
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
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.F;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.expression.F.*;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules130 {
    public static IAST RULES = List(
            IIntegrate(6501, Int(Times(Power(x_, -1), SinIntegral(Times(b_DEFAULT, x_))), x_Symbol),
                    Condition(Plus(Simp(Times(C1D2, C1, b, x, HypergeometricPFQ(List(C1, C1, C1), List(C2, C2, C2), Times(CN1, CI, b, x))), x), Simp(Times(C1D2, C1, b, x, HypergeometricPFQ(List(C1, C1, C1), List(C2, C2, C2), Times(CI, b, x))), x)), FreeQ(b, x))),
            IIntegrate(6502, Int(Times(CosIntegral(Times(b_DEFAULT, x_)), Power(x_, -1)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(C1D2, CI, b, x, HypergeometricPFQ(List(C1, C1, C1), List(C2, C2, C2), Times(CN1, CI, b, x))), x)), Simp(Times(C1D2, C1, CI, b, x, HypergeometricPFQ(List(C1, C1, C1), List(C2, C2, C2), Times(CI, b, x))), x), Simp(Times(EulerGamma, Log(x)), x), Simp(Times(C1D2, C1, Sqr(Log(Times(b, x)))), x)), FreeQ(b, x))),
            IIntegrate(6503, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), SinIntegral(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), SinIntegral(Plus(a, Times(b, x))), Power(Times(d, Plus(m, C1)), -1)), x), Negate(Dist(Times(b, Power(Times(d, Plus(m, C1)), -1)), Int(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), Sin(Plus(a, Times(b, x))), Power(Plus(a, Times(b, x)), -1)), x), x))), And(FreeQ(List(a, b, c, d, m), x), NeQ(m, CN1)))),
            IIntegrate(6504, Int(Times(CosIntegral(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), CosIntegral(Plus(a, Times(b, x))), Power(Times(d, Plus(m, C1)), -1)), x), Negate(Dist(Times(b, Power(Times(d, Plus(m, C1)), -1)), Int(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), Cos(Plus(a, Times(b, x))), Power(Plus(a, Times(b, x)), -1)), x), x))), And(FreeQ(List(a, b, c, d, m), x), NeQ(m, CN1)))),
            IIntegrate(6505, Int(Sqr(SinIntegral(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(a, Times(b, x)), Sqr(SinIntegral(Plus(a, Times(b, x)))), Power(b, -1)), x), Negate(Dist(C2, Int(Times(Sin(Plus(a, Times(b, x))), SinIntegral(Plus(a, Times(b, x)))), x), x))), FreeQ(List(a, b), x))),
            IIntegrate(6506, Int(Sqr(CosIntegral(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(a, Times(b, x)), Sqr(CosIntegral(Plus(a, Times(b, x)))), Power(b, -1)), x), Negate(Dist(C2, Int(Times(Cos(Plus(a, Times(b, x))), CosIntegral(Plus(a, Times(b, x)))), x), x))), FreeQ(List(a, b), x))),
            IIntegrate(6507, Int(Times(Power(x_, m_DEFAULT), Sqr(SinIntegral(Times(b_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, Plus(m, C1)), Sqr(SinIntegral(Times(b, x))), Power(Plus(m, C1), -1)), x), Negate(Dist(Times(C2, Power(Plus(m, C1), -1)), Int(Times(Power(x, m), Sin(Times(b, x)), SinIntegral(Times(b, x))), x), x))), And(FreeQ(b, x), IGtQ(m, C0)))),
            IIntegrate(6508, Int(Times(Sqr(CosIntegral(Times(b_DEFAULT, x_))), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, Plus(m, C1)), Sqr(CosIntegral(Times(b, x))), Power(Plus(m, C1), -1)), x), Negate(Dist(Times(C2, Power(Plus(m, C1), -1)), Int(Times(Power(x, m), Cos(Times(b, x)), CosIntegral(Times(b, x))), x), x))), And(FreeQ(b, x), IGtQ(m, C0)))),
            IIntegrate(6509, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Sqr(SinIntegral(Plus(a_, Times(b_DEFAULT, x_))))), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(a, Times(b, x)), Power(Plus(c, Times(d, x)), m), Sqr(SinIntegral(Plus(a, Times(b, x)))), Power(Times(b, Plus(m, C1)), -1)), x), Negate(Dist(Times(C2, Power(Plus(m, C1), -1)), Int(Times(Power(Plus(c, Times(d, x)), m), Sin(Plus(a, Times(b, x))), SinIntegral(Plus(a, Times(b, x)))), x), x)), Dist(Times(Plus(Times(b, c), Times(CN1, a, d)), m, Power(Times(b, Plus(m, C1)), -1)), Int(Times(Power(Plus(c, Times(d, x)), Plus(m, Negate(C1))), Sqr(SinIntegral(Plus(a, Times(b, x))))), x), x)), And(FreeQ(List(a, b, c, d), x), IGtQ(m, C0)))),
            IIntegrate(6510, Int(Times(Sqr(CosIntegral(Plus(a_, Times(b_DEFAULT, x_)))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(a, Times(b, x)), Power(Plus(c, Times(d, x)), m), Sqr(CosIntegral(Plus(a, Times(b, x)))), Power(Times(b, Plus(m, C1)), -1)), x), Negate(Dist(Times(C2, Power(Plus(m, C1), -1)), Int(Times(Power(Plus(c, Times(d, x)), m), Cos(Plus(a, Times(b, x))), CosIntegral(Plus(a, Times(b, x)))), x), x)), Dist(Times(Plus(Times(b, c), Times(CN1, a, d)), m, Power(Times(b, Plus(m, C1)), -1)), Int(Times(Power(Plus(c, Times(d, x)), Plus(m, Negate(C1))), Sqr(CosIntegral(Plus(a, Times(b, x))))), x), x)), And(FreeQ(List(a, b, c, d), x), IGtQ(m, C0)))),
            IIntegrate(6511, Int(Times(Sin(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), SinIntegral(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Cos(Plus(a, Times(b, x))), SinIntegral(Plus(c, Times(d, x))), Power(b, -1)), x)), Dist(Times(d, Power(b, -1)), Int(Times(Cos(Plus(a, Times(b, x))), Sin(Plus(c, Times(d, x))), Power(Plus(c, Times(d, x)), -1)), x), x)), FreeQ(List(a, b, c, d), x))),
            IIntegrate(6512, Int(Times(Cos(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), CosIntegral(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(Sin(Plus(a, Times(b, x))), CosIntegral(Plus(c, Times(d, x))), Power(b, -1)), x), Negate(Dist(Times(d, Power(b, -1)), Int(Times(Sin(Plus(a, Times(b, x))), Cos(Plus(c, Times(d, x))), Power(Plus(c, Times(d, x)), -1)), x), x))), FreeQ(List(a, b, c, d), x))),
            IIntegrate(6513, Int(Times(Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Sin(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), SinIntegral(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(e, Times(f, x)), m), Cos(Plus(a, Times(b, x))), SinIntegral(Plus(c, Times(d, x))), Power(b, -1)), x)), Dist(Times(d, Power(b, -1)), Int(Times(Power(Plus(e, Times(f, x)), m), Cos(Plus(a, Times(b, x))), Sin(Plus(c, Times(d, x))), Power(Plus(c, Times(d, x)), -1)), x), x), Dist(Times(f, m, Power(b, -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, Negate(C1))), Cos(Plus(a, Times(b, x))), SinIntegral(Plus(c, Times(d, x)))), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0)))),
            IIntegrate(6514, Int(Times(Cos(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), CosIntegral(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), m), Sin(Plus(a, Times(b, x))), CosIntegral(Plus(c, Times(d, x))), Power(b, -1)), x), Negate(Dist(Times(d, Power(b, -1)), Int(Times(Power(Plus(e, Times(f, x)), m), Sin(Plus(a, Times(b, x))), Cos(Plus(c, Times(d, x))), Power(Plus(c, Times(d, x)), -1)), x), x)), Negate(Dist(Times(f, m, Power(b, -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, Negate(C1))), Sin(Plus(a, Times(b, x))), CosIntegral(Plus(c, Times(d, x)))), x), x))), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0)))),
            IIntegrate(6515, Int(Times(Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_), Sin(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), SinIntegral(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Sin(Plus(a, Times(b, x))), SinIntegral(Plus(c, Times(d, x))), Power(Times(f, Plus(m, C1)), -1)), x), Negate(Dist(Times(b, Power(Times(f, Plus(m, C1)), -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Cos(Plus(a, Times(b, x))), SinIntegral(Plus(c, Times(d, x)))), x), x)), Negate(Dist(Times(d, Power(Times(f, Plus(m, C1)), -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Sin(Plus(a, Times(b, x))), Sin(Plus(c, Times(d, x))), Power(Plus(c, Times(d, x)), -1)), x), x))), And(FreeQ(List(a, b, c, d, e, f), x), ILtQ(m, CN1)))),
            IIntegrate(6516, Int(Times(Cos(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), CosIntegral(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Cos(Plus(a, Times(b, x))), CosIntegral(Plus(c, Times(d, x))), Power(Times(f, Plus(m, C1)), -1)), x), Dist(Times(b, Power(Times(f, Plus(m, C1)), -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Sin(Plus(a, Times(b, x))), CosIntegral(Plus(c, Times(d, x)))), x), x), Negate(Dist(Times(d, Power(Times(f, Plus(m, C1)), -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Cos(Plus(a, Times(b, x))), Cos(Plus(c, Times(d, x))), Power(Plus(c, Times(d, x)), -1)), x), x))), And(FreeQ(List(a, b, c, d, e, f), x), ILtQ(m, CN1)))),
            IIntegrate(6517, Int(Times(Cos(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), SinIntegral(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(Sin(Plus(a, Times(b, x))), SinIntegral(Plus(c, Times(d, x))), Power(b, -1)), x), Negate(Dist(Times(d, Power(b, -1)), Int(Times(Sin(Plus(a, Times(b, x))), Sin(Plus(c, Times(d, x))), Power(Plus(c, Times(d, x)), -1)), x), x))), FreeQ(List(a, b, c, d), x))),
            IIntegrate(6518, Int(Times(CosIntegral(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Sin(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Cos(Plus(a, Times(b, x))), CosIntegral(Plus(c, Times(d, x))), Power(b, -1)), x)), Dist(Times(d, Power(b, -1)), Int(Times(Cos(Plus(a, Times(b, x))), Cos(Plus(c, Times(d, x))), Power(Plus(c, Times(d, x)), -1)), x), x)), FreeQ(List(a, b, c, d), x))),
            IIntegrate(6519, Int(Times(Cos(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), SinIntegral(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), m), Sin(Plus(a, Times(b, x))), SinIntegral(Plus(c, Times(d, x))), Power(b, -1)), x), Negate(Dist(Times(d, Power(b, -1)), Int(Times(Power(Plus(e, Times(f, x)), m), Sin(Plus(a, Times(b, x))), Sin(Plus(c, Times(d, x))), Power(Plus(c, Times(d, x)), -1)), x), x)), Negate(Dist(Times(f, m, Power(b, -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, Negate(C1))), Sin(Plus(a, Times(b, x))), SinIntegral(Plus(c, Times(d, x)))), x), x))), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0)))),
            IIntegrate(6520, Int(Times(CosIntegral(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Sin(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(e, Times(f, x)), m), Cos(Plus(a, Times(b, x))), CosIntegral(Plus(c, Times(d, x))), Power(b, -1)), x)), Dist(Times(d, Power(b, -1)), Int(Times(Power(Plus(e, Times(f, x)), m), Cos(Plus(a, Times(b, x))), Cos(Plus(c, Times(d, x))), Power(Plus(c, Times(d, x)), -1)), x), x), Dist(Times(f, m, Power(b, -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, Negate(C1))), Cos(Plus(a, Times(b, x))), CosIntegral(Plus(c, Times(d, x)))), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0)))),
            IIntegrate(6521, Int(Times(Cos(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), SinIntegral(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Cos(Plus(a, Times(b, x))), SinIntegral(Plus(c, Times(d, x))), Power(Times(f, Plus(m, C1)), -1)), x), Dist(Times(b, Power(Times(f, Plus(m, C1)), -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Sin(Plus(a, Times(b, x))), SinIntegral(Plus(c, Times(d, x)))), x), x), Negate(Dist(Times(d, Power(Times(f, Plus(m, C1)), -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Cos(Plus(a, Times(b, x))), Sin(Plus(c, Times(d, x))), Power(Plus(c, Times(d, x)), -1)), x), x))), And(FreeQ(List(a, b, c, d, e, f), x), ILtQ(m, CN1)))),
            IIntegrate(6522, Int(Times(CosIntegral(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_), Sin(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Sin(Plus(a, Times(b, x))), CosIntegral(Plus(c, Times(d, x))), Power(Times(f, Plus(m, C1)), -1)), x), Negate(Dist(Times(b, Power(Times(f, Plus(m, C1)), -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Cos(Plus(a, Times(b, x))), CosIntegral(Plus(c, Times(d, x)))), x), x)), Negate(Dist(Times(d, Power(Times(f, Plus(m, C1)), -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Sin(Plus(a, Times(b, x))), Cos(Plus(c, Times(d, x))), Power(Plus(c, Times(d, x)), -1)), x), x))), And(FreeQ(List(a, b, c, d, e, f), x), ILtQ(m, CN1)))),
            IIntegrate(6523, Int(SinIntegral(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(x, SinIntegral(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n)))))))), x), Negate(Dist(Times(b, d, n), Int(Times(Sin(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n)))))), -1)), x), x))), FreeQ(List(a, b, c, d, n), x))),
            IIntegrate(6524, Int(CosIntegral(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(x, CosIntegral(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n)))))))), x), Negate(Dist(Times(b, d, n), Int(Times(Cos(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n)))))), -1)), x), x))), FreeQ(List(a, b, c, d, n), x))),
            IIntegrate(6525, Int(Times(Power(x_, -1), $(F_, Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT))), x_Symbol),
                    Condition(Dist(Power(n, -1), Subst(F(Times(d, Plus(a, Times(b, x)))), x, Log(Times(c, Power(x, n)))), x), And(FreeQ(List(a, b, c, d, n), x), MemberQ(List(SinIntegral, CosIntegral), x)))),
            IIntegrate(6526, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), SinIntegral(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(e, x), Plus(m, C1)), SinIntegral(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Times(e, Plus(m, C1)), -1)), x), Negate(Dist(Times(b, d, n, Power(Plus(m, C1), -1)), Int(Times(Power(Times(e, x), m), Sin(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n)))))), -1)), x), x))), And(FreeQ(List(a, b, c, d, e, m, n), x), NeQ(m, CN1)))),
            IIntegrate(6527, Int(Times(CosIntegral(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(e, x), Plus(m, C1)), CosIntegral(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Times(e, Plus(m, C1)), -1)), x), Negate(Dist(Times(b, d, n, Power(Plus(m, C1), -1)), Int(Times(Power(Times(e, x), m), Cos(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n)))))), -1)), x), x))), And(FreeQ(List(a, b, c, d, e, m, n), x), NeQ(m, CN1)))),
            IIntegrate(6528, Int(SinhIntegral(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(a, Times(b, x)), SinhIntegral(Plus(a, Times(b, x))), Power(b, -1)), x), Negate(Simp(Times(Cosh(Plus(a, Times(b, x))), Power(b, -1)), x))), FreeQ(List(a, b), x))),
            IIntegrate(6529, Int(CoshIntegral(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(a, Times(b, x)), CoshIntegral(Plus(a, Times(b, x))), Power(b, -1)), x), Negate(Simp(Times(Sinh(Plus(a, Times(b, x))), Power(b, -1)), x))), FreeQ(List(a, b), x))),
            IIntegrate(6530, Int(Times(Power(x_, -1), SinhIntegral(Times(b_DEFAULT, x_))), x_Symbol),
                    Condition(Plus(Simp(Times(C1D2, C1, b, x, HypergeometricPFQ(List(C1, C1, C1), List(C2, C2, C2), Times(CN1, b, x))), x), Simp(Times(C1D2, C1, b, x, HypergeometricPFQ(List(C1, C1, C1), List(C2, C2, C2), Times(b, x))), x)), FreeQ(b, x))),
            IIntegrate(6531, Int(Times(CoshIntegral(Times(b_DEFAULT, x_)), Power(x_, -1)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(C1D2, b, x, HypergeometricPFQ(List(C1, C1, C1), List(C2, C2, C2), Times(CN1, b, x))), x)), Simp(Times(C1D2, C1, b, x, HypergeometricPFQ(List(C1, C1, C1), List(C2, C2, C2), Times(b, x))), x), Simp(Times(EulerGamma, Log(x)), x), Simp(Times(C1D2, C1, Sqr(Log(Times(b, x)))), x)), FreeQ(b, x))),
            IIntegrate(6532, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), SinhIntegral(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), SinhIntegral(Plus(a, Times(b, x))), Power(Times(d, Plus(m, C1)), -1)), x), Negate(Dist(Times(b, Power(Times(d, Plus(m, C1)), -1)), Int(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), Sinh(Plus(a, Times(b, x))), Power(Plus(a, Times(b, x)), -1)), x), x))), And(FreeQ(List(a, b, c, d, m), x), NeQ(m, CN1)))),
            IIntegrate(6533, Int(Times(CoshIntegral(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), CoshIntegral(Plus(a, Times(b, x))), Power(Times(d, Plus(m, C1)), -1)), x), Negate(Dist(Times(b, Power(Times(d, Plus(m, C1)), -1)), Int(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), Cosh(Plus(a, Times(b, x))), Power(Plus(a, Times(b, x)), -1)), x), x))), And(FreeQ(List(a, b, c, d, m), x), NeQ(m, CN1)))),
            IIntegrate(6534, Int(Sqr(SinhIntegral(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(a, Times(b, x)), Sqr(SinhIntegral(Plus(a, Times(b, x)))), Power(b, -1)), x), Negate(Dist(C2, Int(Times(Sinh(Plus(a, Times(b, x))), SinhIntegral(Plus(a, Times(b, x)))), x), x))), FreeQ(List(a, b), x))),
            IIntegrate(6535, Int(Sqr(CoshIntegral(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(a, Times(b, x)), Sqr(CoshIntegral(Plus(a, Times(b, x)))), Power(b, -1)), x), Negate(Dist(C2, Int(Times(Cosh(Plus(a, Times(b, x))), CoshIntegral(Plus(a, Times(b, x)))), x), x))), FreeQ(List(a, b), x))),
            IIntegrate(6536, Int(Times(Power(x_, m_DEFAULT), Sqr(SinhIntegral(Times(b_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, Plus(m, C1)), Sqr(SinhIntegral(Times(b, x))), Power(Plus(m, C1), -1)), x), Negate(Dist(Times(C2, Power(Plus(m, C1), -1)), Int(Times(Power(x, m), Sinh(Times(b, x)), SinhIntegral(Times(b, x))), x), x))), And(FreeQ(b, x), IGtQ(m, C0)))),
            IIntegrate(6537, Int(Times(Sqr(CoshIntegral(Times(b_DEFAULT, x_))), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, Plus(m, C1)), Sqr(CoshIntegral(Times(b, x))), Power(Plus(m, C1), -1)), x), Negate(Dist(Times(C2, Power(Plus(m, C1), -1)), Int(Times(Power(x, m), Cosh(Times(b, x)), CoshIntegral(Times(b, x))), x), x))), And(FreeQ(b, x), IGtQ(m, C0)))),
            IIntegrate(6538, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Sqr(SinhIntegral(Plus(a_, Times(b_DEFAULT, x_))))), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(a, Times(b, x)), Power(Plus(c, Times(d, x)), m), Sqr(SinhIntegral(Plus(a, Times(b, x)))), Power(Times(b, Plus(m, C1)), -1)), x), Negate(Dist(Times(C2, Power(Plus(m, C1), -1)), Int(Times(Power(Plus(c, Times(d, x)), m), Sinh(Plus(a, Times(b, x))), SinhIntegral(Plus(a, Times(b, x)))), x), x)), Dist(Times(Plus(Times(b, c), Times(CN1, a, d)), m, Power(Times(b, Plus(m, C1)), -1)), Int(Times(Power(Plus(c, Times(d, x)), Plus(m, Negate(C1))), Sqr(SinhIntegral(Plus(a, Times(b, x))))), x), x)), And(FreeQ(List(a, b, c, d), x), IGtQ(m, C0)))),
            IIntegrate(6539, Int(Times(Sqr(CoshIntegral(Plus(a_, Times(b_DEFAULT, x_)))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(a, Times(b, x)), Power(Plus(c, Times(d, x)), m), Sqr(CoshIntegral(Plus(a, Times(b, x)))), Power(Times(b, Plus(m, C1)), -1)), x), Negate(Dist(Times(C2, Power(Plus(m, C1), -1)), Int(Times(Power(Plus(c, Times(d, x)), m), Cosh(Plus(a, Times(b, x))), CoshIntegral(Plus(a, Times(b, x)))), x), x)), Dist(Times(Plus(Times(b, c), Times(CN1, a, d)), m, Power(Times(b, Plus(m, C1)), -1)), Int(Times(Power(Plus(c, Times(d, x)), Plus(m, Negate(C1))), Sqr(CoshIntegral(Plus(a, Times(b, x))))), x), x)), And(FreeQ(List(a, b, c, d), x), IGtQ(m, C0)))),
            IIntegrate(6540, Int(Times(Sinh(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), SinhIntegral(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(Cosh(Plus(a, Times(b, x))), SinhIntegral(Plus(c, Times(d, x))), Power(b, -1)), x), Negate(Dist(Times(d, Power(b, -1)), Int(Times(Cosh(Plus(a, Times(b, x))), Sinh(Plus(c, Times(d, x))), Power(Plus(c, Times(d, x)), -1)), x), x))), FreeQ(List(a, b, c, d), x))),
            IIntegrate(6541, Int(Times(Cosh(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), CoshIntegral(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(Sinh(Plus(a, Times(b, x))), CoshIntegral(Plus(c, Times(d, x))), Power(b, -1)), x), Negate(Dist(Times(d, Power(b, -1)), Int(Times(Sinh(Plus(a, Times(b, x))), Cosh(Plus(c, Times(d, x))), Power(Plus(c, Times(d, x)), -1)), x), x))), FreeQ(List(a, b, c, d), x))),
            IIntegrate(6542, Int(Times(Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Sinh(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), SinhIntegral(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), m), Cosh(Plus(a, Times(b, x))), SinhIntegral(Plus(c, Times(d, x))), Power(b, -1)), x), Negate(Dist(Times(d, Power(b, -1)), Int(Times(Power(Plus(e, Times(f, x)), m), Cosh(Plus(a, Times(b, x))), Sinh(Plus(c, Times(d, x))), Power(Plus(c, Times(d, x)), -1)), x), x)), Negate(Dist(Times(f, m, Power(b, -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, Negate(C1))), Cosh(Plus(a, Times(b, x))), SinhIntegral(Plus(c, Times(d, x)))), x), x))), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0)))),
            IIntegrate(6543, Int(Times(Cosh(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), CoshIntegral(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), m), Sinh(Plus(a, Times(b, x))), CoshIntegral(Plus(c, Times(d, x))), Power(b, -1)), x), Negate(Dist(Times(d, Power(b, -1)), Int(Times(Power(Plus(e, Times(f, x)), m), Sinh(Plus(a, Times(b, x))), Cosh(Plus(c, Times(d, x))), Power(Plus(c, Times(d, x)), -1)), x), x)), Negate(Dist(Times(f, m, Power(b, -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, Negate(C1))), Sinh(Plus(a, Times(b, x))), CoshIntegral(Plus(c, Times(d, x)))), x), x))), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0)))),
            IIntegrate(6544, Int(Times(Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_), Sinh(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), SinhIntegral(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Sinh(Plus(a, Times(b, x))), SinhIntegral(Plus(c, Times(d, x))), Power(Times(f, Plus(m, C1)), -1)), x), Negate(Dist(Times(b, Power(Times(f, Plus(m, C1)), -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Cosh(Plus(a, Times(b, x))), SinhIntegral(Plus(c, Times(d, x)))), x), x)), Negate(Dist(Times(d, Power(Times(f, Plus(m, C1)), -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Sinh(Plus(a, Times(b, x))), Sinh(Plus(c, Times(d, x))), Power(Plus(c, Times(d, x)), -1)), x), x))), And(FreeQ(List(a, b, c, d, e, f), x), ILtQ(m, CN1)))),
            IIntegrate(6545, Int(Times(Cosh(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), CoshIntegral(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Cosh(Plus(a, Times(b, x))), CoshIntegral(Plus(c, Times(d, x))), Power(Times(f, Plus(m, C1)), -1)), x), Negate(Dist(Times(b, Power(Times(f, Plus(m, C1)), -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Sinh(Plus(a, Times(b, x))), CoshIntegral(Plus(c, Times(d, x)))), x), x)), Negate(Dist(Times(d, Power(Times(f, Plus(m, C1)), -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Cosh(Plus(a, Times(b, x))), Cosh(Plus(c, Times(d, x))), Power(Plus(c, Times(d, x)), -1)), x), x))), And(FreeQ(List(a, b, c, d, e, f), x), ILtQ(m, CN1)))),
            IIntegrate(6546, Int(Times(Cosh(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), SinhIntegral(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(Sinh(Plus(a, Times(b, x))), SinhIntegral(Plus(c, Times(d, x))), Power(b, -1)), x), Negate(Dist(Times(d, Power(b, -1)), Int(Times(Sinh(Plus(a, Times(b, x))), Sinh(Plus(c, Times(d, x))), Power(Plus(c, Times(d, x)), -1)), x), x))), FreeQ(List(a, b, c, d), x))),
            IIntegrate(6547, Int(Times(CoshIntegral(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Sinh(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(Cosh(Plus(a, Times(b, x))), CoshIntegral(Plus(c, Times(d, x))), Power(b, -1)), x), Negate(Dist(Times(d, Power(b, -1)), Int(Times(Cosh(Plus(a, Times(b, x))), Cosh(Plus(c, Times(d, x))), Power(Plus(c, Times(d, x)), -1)), x), x))), FreeQ(List(a, b, c, d), x))),
            IIntegrate(6548, Int(Times(Cosh(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), SinhIntegral(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), m), Sinh(Plus(a, Times(b, x))), SinhIntegral(Plus(c, Times(d, x))), Power(b, -1)), x), Negate(Dist(Times(d, Power(b, -1)), Int(Times(Power(Plus(e, Times(f, x)), m), Sinh(Plus(a, Times(b, x))), Sinh(Plus(c, Times(d, x))), Power(Plus(c, Times(d, x)), -1)), x), x)), Negate(Dist(Times(f, m, Power(b, -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, Negate(C1))), Sinh(Plus(a, Times(b, x))), SinhIntegral(Plus(c, Times(d, x)))), x), x))), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0)))),
            IIntegrate(6549, Int(Times(CoshIntegral(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Sinh(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), m), Cosh(Plus(a, Times(b, x))), CoshIntegral(Plus(c, Times(d, x))), Power(b, -1)), x), Negate(Dist(Times(d, Power(b, -1)), Int(Times(Power(Plus(e, Times(f, x)), m), Cosh(Plus(a, Times(b, x))), Cosh(Plus(c, Times(d, x))), Power(Plus(c, Times(d, x)), -1)), x), x)), Negate(Dist(Times(f, m, Power(b, -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, Negate(C1))), Cosh(Plus(a, Times(b, x))), CoshIntegral(Plus(c, Times(d, x)))), x), x))), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0)))),
            IIntegrate(6550, Int(Times(Cosh(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), SinhIntegral(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Cosh(Plus(a, Times(b, x))), SinhIntegral(Plus(c, Times(d, x))), Power(Times(f, Plus(m, C1)), -1)), x), Negate(Dist(Times(b, Power(Times(f, Plus(m, C1)), -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Sinh(Plus(a, Times(b, x))), SinhIntegral(Plus(c, Times(d, x)))), x), x)), Negate(Dist(Times(d, Power(Times(f, Plus(m, C1)), -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Cosh(Plus(a, Times(b, x))), Sinh(Plus(c, Times(d, x))), Power(Plus(c, Times(d, x)), -1)), x), x))), And(FreeQ(List(a, b, c, d, e, f), x), ILtQ(m, CN1))))
    );
}
