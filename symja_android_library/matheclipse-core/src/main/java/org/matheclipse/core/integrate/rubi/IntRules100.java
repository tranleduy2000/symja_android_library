package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcCot;
import static org.matheclipse.core.expression.F.ArcTan;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CI;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.Condition;
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
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sqr;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntHide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules100 {
    public static IAST RULES = List(
            IIntegrate(5001, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT)), q_DEFAULT), Power(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), -1)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(a, Times(b, ArcCot(Times(c, x)))), Plus(q, C1)), Power(Plus(a, Times(b, ArcTan(Times(c, x)))), p), Power(Times(b, c, d, Plus(q, C1)), -1)), x)), Dist(Times(p, Power(Plus(q, C1), -1)), Int(Times(Power(Plus(a, Times(b, ArcCot(Times(c, x)))), Plus(q, C1)), Power(Plus(a, Times(b, ArcTan(Times(c, x)))), Plus(p, Negate(C1))), Power(Plus(d, Times(e, Sqr(x))), -1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ(e, Times(Sqr(c), d)), IGtQ(p, C0), IGeQ(q, p)))),
            IIntegrate(5002, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT)), q_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), -1)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(a, Times(b, ArcTan(Times(c, x)))), Plus(q, C1)), Power(Plus(a, Times(b, ArcCot(Times(c, x)))), p), Power(Times(b, c, d, Plus(q, C1)), -1)), x), Dist(Times(p, Power(Plus(q, C1), -1)), Int(Times(Power(Plus(a, Times(b, ArcTan(Times(c, x)))), Plus(q, C1)), Power(Plus(a, Times(b, ArcCot(Times(c, x)))), Plus(p, Negate(C1))), Power(Plus(d, Times(e, Sqr(x))), -1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ(e, Times(Sqr(c), d)), IGtQ(p, C0), IGeQ(q, p)))),
            IIntegrate(5003, Int(Times(ArcTan(Times(a_DEFAULT, x_)), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_DEFAULT))), -1)), x_Symbol),
                    Condition(Plus(Dist(Times(C1D2, CI), Int(Times(Log(Plus(C1, Times(CN1, CI, a, x))), Power(Plus(c, Times(d, Power(x, n))), -1)), x), x), Negate(Dist(Times(C1D2, CI), Int(Times(Log(Plus(C1, Times(CI, a, x))), Power(Plus(c, Times(d, Power(x, n))), -1)), x), x))), And(FreeQ(List(a, c, d), x), IntegerQ(n), Not(And(EqQ(n, C2), EqQ(d, Times(Sqr(a), c))))))),
            IIntegrate(5004, Int(Times(ArcCot(Times(a_DEFAULT, x_)), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_DEFAULT))), -1)), x_Symbol),
                    Condition(Plus(Dist(Times(C1D2, CI), Int(Times(Log(Plus(C1, Times(CN1, CI, Power(Times(a, x), -1)))), Power(Plus(c, Times(d, Power(x, n))), -1)), x), x), Negate(Dist(Times(C1D2, CI), Int(Times(Log(Plus(C1, Times(CI, Power(Times(a, x), -1)))), Power(Plus(c, Times(d, Power(x, n))), -1)), x), x))), And(FreeQ(List(a, c, d), x), IntegerQ(n), Not(And(EqQ(n, C2), EqQ(d, Times(Sqr(a), c))))))),
            IIntegrate(5005, Int(Times(ArcTan(Times(c_DEFAULT, Power(x_, n_DEFAULT))), Log(Times(d_DEFAULT, Power(x_, m_DEFAULT))), Power(x_, -1)), x_Symbol),
                    Condition(Plus(Dist(Times(C1D2, CI), Int(Times(Log(Times(d, Power(x, m))), Log(Plus(C1, Times(CN1, CI, c, Power(x, n)))), Power(x, -1)), x), x), Negate(Dist(Times(C1D2, CI), Int(Times(Log(Times(d, Power(x, m))), Log(Plus(C1, Times(CI, c, Power(x, n)))), Power(x, -1)), x), x))), FreeQ(List(c, d, m, n), x))),
            IIntegrate(5006, Int(Times(ArcCot(Times(c_DEFAULT, Power(x_, n_DEFAULT))), Log(Times(d_DEFAULT, Power(x_, m_DEFAULT))), Power(x_, -1)), x_Symbol),
                    Condition(Plus(Dist(Times(C1D2, CI), Int(Times(Log(Times(d, Power(x, m))), Log(Plus(C1, Times(CN1, CI, Power(Times(c, Power(x, n)), -1)))), Power(x, -1)), x), x), Negate(Dist(Times(C1D2, CI), Int(Times(Log(Times(d, Power(x, m))), Log(Plus(C1, Times(CI, Power(Times(c, Power(x, n)), -1)))), Power(x, -1)), x), x))), FreeQ(List(c, d, m, n), x))),
            IIntegrate(5007, Int(Times(Log(Times(d_DEFAULT, Power(x_, m_DEFAULT))), Plus(Times(ArcTan(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT), a_), Power(x_, -1)), x_Symbol),
                    Condition(Plus(Dist(a, Int(Times(Log(Times(d, Power(x, m))), Power(x, -1)), x), x), Dist(b, Int(Times(Log(Times(d, Power(x, m))), ArcTan(Times(c, Power(x, n))), Power(x, -1)), x), x)), FreeQ(List(a, b, c, d, m, n), x))),
            IIntegrate(5008, Int(Times(Log(Times(d_DEFAULT, Power(x_, m_DEFAULT))), Plus(Times(ArcCot(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT), a_), Power(x_, -1)), x_Symbol),
                    Condition(Plus(Dist(a, Int(Times(Log(Times(d, Power(x, m))), Power(x, -1)), x), x), Dist(b, Int(Times(Log(Times(d, Power(x, m))), ArcCot(Times(c, Power(x, n))), Power(x, -1)), x), x)), FreeQ(List(a, b, c, d, m, n), x))),
            IIntegrate(5009, Int(Times(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT)), Plus(d_DEFAULT, Times(Log(Plus(f_DEFAULT, Times(g_DEFAULT, Sqr(x_)))), e_DEFAULT))), x_Symbol),
                    Condition(Plus(Simp(Times(x, Plus(d, Times(e, Log(Plus(f, Times(g, Sqr(x)))))), Plus(a, Times(b, ArcTan(Times(c, x))))), x), Negate(Dist(Times(b, c), Int(Times(x, Plus(d, Times(e, Log(Plus(f, Times(g, Sqr(x)))))), Power(Plus(C1, Times(Sqr(c), Sqr(x))), -1)), x), x)), Negate(Dist(Times(C2, e, g), Int(Times(Sqr(x), Plus(a, Times(b, ArcTan(Times(c, x)))), Power(Plus(f, Times(g, Sqr(x))), -1)), x), x))), FreeQ(List(a, b, c, d, e, f, g), x))),
            IIntegrate(5010, Int(Times(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT)), Plus(d_DEFAULT, Times(Log(Plus(f_DEFAULT, Times(g_DEFAULT, Sqr(x_)))), e_DEFAULT))), x_Symbol),
                    Condition(Plus(Simp(Times(x, Plus(d, Times(e, Log(Plus(f, Times(g, Sqr(x)))))), Plus(a, Times(b, ArcCot(Times(c, x))))), x), Dist(Times(b, c), Int(Times(x, Plus(d, Times(e, Log(Plus(f, Times(g, Sqr(x)))))), Power(Plus(C1, Times(Sqr(c), Sqr(x))), -1)), x), x), Negate(Dist(Times(C2, e, g), Int(Times(Sqr(x), Plus(a, Times(b, ArcCot(Times(c, x)))), Power(Plus(f, Times(g, Sqr(x))), -1)), x), x))), FreeQ(List(a, b, c, d, e, f, g), x))),
            IIntegrate(5011, Int(Times(ArcTan(Times(c_DEFAULT, x_)), Log(Plus(f_DEFAULT, Times(g_DEFAULT, Sqr(x_)))), Power(x_, -1)), x_Symbol),
                    Condition(Plus(Dist(Plus(Log(Plus(f, Times(g, Sqr(x)))), Negate(Log(Plus(C1, Times(CN1, CI, c, x)))), Negate(Log(Plus(C1, Times(CI, c, x))))), Int(Times(ArcTan(Times(c, x)), Power(x, -1)), x), x), Dist(Times(C1D2, CI), Int(Times(Sqr(Log(Plus(C1, Times(CN1, CI, c, x)))), Power(x, -1)), x), x), Negate(Dist(Times(C1D2, CI), Int(Times(Sqr(Log(Plus(C1, Times(CI, c, x)))), Power(x, -1)), x), x))), And(FreeQ(List(c, f, g), x), EqQ(g, Times(Sqr(c), f))))),
            IIntegrate(5012, Int(Times(ArcCot(Times(c_DEFAULT, x_)), Log(Plus(f_DEFAULT, Times(g_DEFAULT, Sqr(x_)))), Power(x_, -1)), x_Symbol),
                    Condition(Plus(Dist(Plus(Log(Plus(f, Times(g, Sqr(x)))), Negate(Log(Times(Sqr(c), Sqr(x)))), Negate(Log(Plus(C1, Times(CN1, CI, Power(Times(c, x), -1))))), Negate(Log(Plus(C1, Times(CI, Power(Times(c, x), -1)))))), Int(Times(ArcCot(Times(c, x)), Power(x, -1)), x), x), Dist(Times(C1D2, CI), Int(Times(Sqr(Log(Plus(C1, Times(CN1, CI, Power(Times(c, x), -1))))), Power(x, -1)), x), x), Negate(Dist(Times(C1D2, CI), Int(Times(Sqr(Log(Plus(C1, Times(CI, Power(Times(c, x), -1))))), Power(x, -1)), x), x)), Int(Times(Log(Times(Sqr(c), Sqr(x))), ArcCot(Times(c, x)), Power(x, -1)), x)), And(FreeQ(List(c, f, g), x), EqQ(g, Times(Sqr(c), f))))),
            IIntegrate(5013, Int(Times(Log(Plus(f_DEFAULT, Times(g_DEFAULT, Sqr(x_)))), Plus(Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT), a_), Power(x_, -1)), x_Symbol),
                    Condition(Plus(Dist(a, Int(Times(Log(Plus(f, Times(g, Sqr(x)))), Power(x, -1)), x), x), Dist(b, Int(Times(Log(Plus(f, Times(g, Sqr(x)))), ArcTan(Times(c, x)), Power(x, -1)), x), x)), FreeQ(List(a, b, c, f, g), x))),
            IIntegrate(5014, Int(Times(Log(Plus(f_DEFAULT, Times(g_DEFAULT, Sqr(x_)))), Plus(Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT), a_), Power(x_, -1)), x_Symbol),
                    Condition(Plus(Dist(a, Int(Times(Log(Plus(f, Times(g, Sqr(x)))), Power(x, -1)), x), x), Dist(b, Int(Times(Log(Plus(f, Times(g, Sqr(x)))), ArcCot(Times(c, x)), Power(x, -1)), x), x)), FreeQ(List(a, b, c, f, g), x))),
            IIntegrate(5015, Int(Times(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT)), Plus(Times(Log(Plus(f_DEFAULT, Times(g_DEFAULT, Sqr(x_)))), e_DEFAULT), d_), Power(x_, -1)), x_Symbol),
                    Condition(Plus(Dist(d, Int(Times(Plus(a, Times(b, ArcTan(Times(c, x)))), Power(x, -1)), x), x), Dist(e, Int(Times(Log(Plus(f, Times(g, Sqr(x)))), Plus(a, Times(b, ArcTan(Times(c, x)))), Power(x, -1)), x), x)), FreeQ(List(a, b, c, d, e, f, g), x))),
            IIntegrate(5016, Int(Times(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT)), Plus(Times(Log(Plus(f_DEFAULT, Times(g_DEFAULT, Sqr(x_)))), e_DEFAULT), d_), Power(x_, -1)), x_Symbol),
                    Condition(Plus(Dist(d, Int(Times(Plus(a, Times(b, ArcCot(Times(c, x)))), Power(x, -1)), x), x), Dist(e, Int(Times(Log(Plus(f, Times(g, Sqr(x)))), Plus(a, Times(b, ArcCot(Times(c, x)))), Power(x, -1)), x), x)), FreeQ(List(a, b, c, d, e, f, g), x))),
            IIntegrate(5017, Int(Times(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT)), Plus(d_DEFAULT, Times(Log(Plus(f_DEFAULT, Times(g_DEFAULT, Sqr(x_)))), e_DEFAULT)), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, Plus(m, C1)), Plus(d, Times(e, Log(Plus(f, Times(g, Sqr(x)))))), Plus(a, Times(b, ArcTan(Times(c, x)))), Power(Plus(m, C1), -1)), x), Negate(Dist(Times(b, c, Power(Plus(m, C1), -1)), Int(Times(Power(x, Plus(m, C1)), Plus(d, Times(e, Log(Plus(f, Times(g, Sqr(x)))))), Power(Plus(C1, Times(Sqr(c), Sqr(x))), -1)), x), x)), Negate(Dist(Times(C2, e, g, Power(Plus(m, C1), -1)), Int(Times(Power(x, Plus(m, C2)), Plus(a, Times(b, ArcTan(Times(c, x)))), Power(Plus(f, Times(g, Sqr(x))), -1)), x), x))), And(FreeQ(List(a, b, c, d, e, f, g), x), ILtQ(Times(C1D2, m), C0)))),
            IIntegrate(5018, Int(Times(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT)), Plus(d_DEFAULT, Times(Log(Plus(f_DEFAULT, Times(g_DEFAULT, Sqr(x_)))), e_DEFAULT)), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, Plus(m, C1)), Plus(d, Times(e, Log(Plus(f, Times(g, Sqr(x)))))), Plus(a, Times(b, ArcCot(Times(c, x)))), Power(Plus(m, C1), -1)), x), Dist(Times(b, c, Power(Plus(m, C1), -1)), Int(Times(Power(x, Plus(m, C1)), Plus(d, Times(e, Log(Plus(f, Times(g, Sqr(x)))))), Power(Plus(C1, Times(Sqr(c), Sqr(x))), -1)), x), x), Negate(Dist(Times(C2, e, g, Power(Plus(m, C1), -1)), Int(Times(Power(x, Plus(m, C2)), Plus(a, Times(b, ArcCot(Times(c, x)))), Power(Plus(f, Times(g, Sqr(x))), -1)), x), x))), And(FreeQ(List(a, b, c, d, e, f, g), x), ILtQ(Times(C1D2, m), C0)))),
            IIntegrate(5019, Int(Times(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT)), Plus(d_DEFAULT, Times(Log(Plus(f_DEFAULT, Times(g_DEFAULT, Sqr(x_)))), e_DEFAULT)), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Times(Power(x, m), Plus(d, Times(e, Log(Plus(f, Times(g, Sqr(x))))))), x))), Plus(Dist(Plus(a, Times(b, ArcTan(Times(c, x)))), u, x), Negate(Dist(Times(b, c), Int(ExpandIntegrand(Times(u, Power(Plus(C1, Times(Sqr(c), Sqr(x))), -1)), x), x), x)))), And(FreeQ(List(a, b, c, d, e, f, g), x), IGtQ(Times(C1D2, Plus(m, C1)), C0)))),
            IIntegrate(5020, Int(Times(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT)), Plus(d_DEFAULT, Times(Log(Plus(f_DEFAULT, Times(g_DEFAULT, Sqr(x_)))), e_DEFAULT)), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Times(Power(x, m), Plus(d, Times(e, Log(Plus(f, Times(g, Sqr(x))))))), x))), Plus(Dist(Plus(a, Times(b, ArcCot(Times(c, x)))), u, x), Dist(Times(b, c), Int(ExpandIntegrand(Times(u, Power(Plus(C1, Times(Sqr(c), Sqr(x))), -1)), x), x), x))), And(FreeQ(List(a, b, c, d, e, f, g), x), IGtQ(Times(C1D2, Plus(m, C1)), C0)))),
            IIntegrate(5021, Int(Times(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT)), Plus(d_DEFAULT, Times(Log(Plus(f_DEFAULT, Times(g_DEFAULT, Sqr(x_)))), e_DEFAULT)), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Times(Power(x, m), Plus(a, Times(b, ArcTan(Times(c, x))))), x))), Plus(Dist(Plus(d, Times(e, Log(Plus(f, Times(g, Sqr(x)))))), u, x), Negate(Dist(Times(C2, e, g), Int(ExpandIntegrand(Times(x, u, Power(Plus(f, Times(g, Sqr(x))), -1)), x), x), x)))), And(FreeQ(List(a, b, c, d, e, f, g), x), IntegerQ(m), NeQ(m, CN1)))),
            IIntegrate(5022, Int(Times(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT)), Plus(d_DEFAULT, Times(Log(Plus(f_DEFAULT, Times(g_DEFAULT, Sqr(x_)))), e_DEFAULT)), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Times(Power(x, m), Plus(a, Times(b, ArcCot(Times(c, x))))), x))), Plus(Dist(Plus(d, Times(e, Log(Plus(f, Times(g, Sqr(x)))))), u, x), Negate(Dist(Times(C2, e, g), Int(ExpandIntegrand(Times(x, u, Power(Plus(f, Times(g, Sqr(x))), -1)), x), x), x)))), And(FreeQ(List(a, b, c, d, e, f, g), x), IntegerQ(m), NeQ(m, CN1)))),
            IIntegrate(5023, Int(Times(Sqr(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT))), Plus(d_DEFAULT, Times(Log(Plus(f_, Times(g_DEFAULT, Sqr(x_)))), e_DEFAULT)), x_), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(f, Times(g, Sqr(x))), Plus(d, Times(e, Log(Plus(f, Times(g, Sqr(x)))))), Sqr(Plus(a, Times(b, ArcTan(Times(c, x))))), Power(Times(C2, g), -1)), x), Negate(Dist(Times(b, Power(c, -1)), Int(Times(Plus(d, Times(e, Log(Plus(f, Times(g, Sqr(x)))))), Plus(a, Times(b, ArcTan(Times(c, x))))), x), x)), Dist(Times(b, c, e), Int(Times(Sqr(x), Plus(a, Times(b, ArcTan(Times(c, x)))), Power(Plus(C1, Times(Sqr(c), Sqr(x))), -1)), x), x), Negate(Simp(Times(C1D2, e, Sqr(x), Sqr(Plus(a, Times(b, ArcTan(Times(c, x)))))), x))), And(FreeQ(List(a, b, c, d, e, f, g), x), EqQ(g, Times(Sqr(c), f))))),
            IIntegrate(5024, Int(Times(Sqr(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT))), Plus(d_DEFAULT, Times(Log(Plus(f_, Times(g_DEFAULT, Sqr(x_)))), e_DEFAULT)), x_), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(f, Times(g, Sqr(x))), Plus(d, Times(e, Log(Plus(f, Times(g, Sqr(x)))))), Sqr(Plus(a, Times(b, ArcCot(Times(c, x))))), Power(Times(C2, g), -1)), x), Dist(Times(b, Power(c, -1)), Int(Times(Plus(d, Times(e, Log(Plus(f, Times(g, Sqr(x)))))), Plus(a, Times(b, ArcCot(Times(c, x))))), x), x), Negate(Dist(Times(b, c, e), Int(Times(Sqr(x), Plus(a, Times(b, ArcCot(Times(c, x)))), Power(Plus(C1, Times(Sqr(c), Sqr(x))), -1)), x), x)), Negate(Simp(Times(C1D2, e, Sqr(x), Sqr(Plus(a, Times(b, ArcCot(Times(c, x)))))), x))), And(FreeQ(List(a, b, c, d, e, f, g), x), EqQ(g, Times(Sqr(c), f))))),
            IIntegrate(5025, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), u_DEFAULT), x_Symbol),
                    Condition(Unintegrable(Times(u, Power(Plus(a, Times(b, ArcTan(Times(c, x)))), p)), x), And(FreeQ(List(a, b, c, p), x), Or(EqQ(u, C1), MatchQ(u, Condition(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x)), q_DEFAULT), FreeQ(List(d, e, q), x))), MatchQ(u, Condition(Times(Power(Times(f_DEFAULT, x), m_DEFAULT), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x)), q_DEFAULT)), FreeQ(List(d, e, f, m, q), x))), MatchQ(u, Condition(Power(Plus(d_DEFAULT, Times(e_DEFAULT, Sqr(x))), q_DEFAULT), FreeQ(List(d, e, q), x))), MatchQ(u, Condition(Times(Power(Times(f_DEFAULT, x), m_DEFAULT), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Sqr(x))), q_DEFAULT)), FreeQ(List(d, e, f, m, q), x))))))),
            IIntegrate(5026, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), u_DEFAULT), x_Symbol),
                    Condition(Unintegrable(Times(u, Power(Plus(a, Times(b, ArcCot(Times(c, x)))), p)), x), And(FreeQ(List(a, b, c, p), x), Or(EqQ(u, C1), MatchQ(u, Condition(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x)), q_DEFAULT), FreeQ(List(d, e, q), x))), MatchQ(u, Condition(Times(Power(Times(f_DEFAULT, x), m_DEFAULT), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x)), q_DEFAULT)), FreeQ(List(d, e, f, m, q), x))), MatchQ(u, Condition(Power(Plus(d_DEFAULT, Times(e_DEFAULT, Sqr(x))), q_DEFAULT), FreeQ(List(d, e, q), x))), MatchQ(u, Condition(Times(Power(Times(f_DEFAULT, x), m_DEFAULT), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Sqr(x))), q_DEFAULT)), FreeQ(List(d, e, f, m, q), x))))))),
            IIntegrate(5027, Int(ArcTan(Times(c_DEFAULT, Power(x_, n_))), x_Symbol),
                    Condition(Plus(Simp(Times(x, ArcTan(Times(c, Power(x, n)))), x), Negate(Dist(Times(c, n), Int(Times(Power(x, n), Power(Plus(C1, Times(Sqr(c), Power(x, Times(C2, n)))), -1)), x), x))), FreeQ(List(c, n), x))),
            IIntegrate(5028, Int(ArcCot(Times(c_DEFAULT, Power(x_, n_))), x_Symbol),
                    Condition(Plus(Simp(Times(x, ArcCot(Times(c, Power(x, n)))), x), Dist(Times(c, n), Int(Times(Power(x, n), Power(Plus(C1, Times(Sqr(c), Power(x, Times(C2, n)))), -1)), x), x)), FreeQ(List(c, n), x))),
            IIntegrate(5029, Int(Power(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(a, Times(C1D2, CI, b, Log(Plus(C1, Times(CN1, CI, c, Power(x, n))))), Times(CN1, C1D2, CI, b, Log(Plus(C1, Times(CI, c, Power(x, n)))))), p), x), x), And(FreeQ(List(a, b, c, n), x), IGtQ(p, C0), IntegerQ(n)))),
            IIntegrate(5030, Int(Power(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(a, Times(C1D2, CI, b, Log(Plus(C1, Times(CN1, CI, Power(Times(Power(x, n), c), -1))))), Times(CN1, C1D2, CI, b, Log(Plus(C1, Times(CI, Power(Times(Power(x, n), c), -1)))))), p), x), x), And(FreeQ(List(a, b, c, n), x), IGtQ(p, C0), IntegerQ(n)))),
            IIntegrate(5031, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, Power(x_, n_))), b_DEFAULT)), p_DEFAULT), Power(x_, -1)), x_Symbol),
                    Condition(Dist(Power(n, -1), Subst(Int(Times(Power(Plus(a, Times(b, ArcTan(Times(c, x)))), p), Power(x, -1)), x), x, Power(x, n)), x), And(FreeQ(List(a, b, c, n), x), IGtQ(p, C0)))),
            IIntegrate(5032, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, Power(x_, n_))), b_DEFAULT)), p_DEFAULT), Power(x_, -1)), x_Symbol),
                    Condition(Dist(Power(n, -1), Subst(Int(Times(Power(Plus(a, Times(b, ArcCot(Times(c, x)))), p), Power(x, -1)), x), x, Power(x, n)), x), And(FreeQ(List(a, b, c, n), x), IGtQ(p, C0)))),
            IIntegrate(5033, Int(Times(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, Power(x_, n_))), b_DEFAULT)), Power(Times(d_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(d, x), Plus(m, C1)), Plus(a, Times(b, ArcTan(Times(c, Power(x, n))))), Power(Times(d, Plus(m, C1)), -1)), x), Negate(Dist(Times(b, c, n, Power(Times(d, Plus(m, C1)), -1)), Int(Times(Power(x, Plus(n, Negate(C1))), Power(Times(d, x), Plus(m, C1)), Power(Plus(C1, Times(Sqr(c), Power(x, Times(C2, n)))), -1)), x), x))), And(FreeQ(List(a, b, c, d, m, n), x), NeQ(m, CN1)))),
            IIntegrate(5034, Int(Times(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, Power(x_, n_))), b_DEFAULT)), Power(Times(d_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(d, x), Plus(m, C1)), Plus(a, Times(b, ArcCot(Times(c, Power(x, n))))), Power(Times(d, Plus(m, C1)), -1)), x), Dist(Times(b, c, n, Power(Times(d, Plus(m, C1)), -1)), Int(Times(Power(x, Plus(n, Negate(C1))), Power(Times(d, x), Plus(m, C1)), Power(Plus(C1, Times(Sqr(c), Power(x, Times(C2, n)))), -1)), x), x)), And(FreeQ(List(a, b, c, d, m, n), x), NeQ(m, CN1)))),
            IIntegrate(5035, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(Times(d_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Times(d, x), m), Power(Plus(a, Times(C1D2, CI, b, Log(Plus(C1, Times(CN1, CI, c, Power(x, n))))), Times(CN1, C1D2, CI, b, Log(Plus(C1, Times(CI, c, Power(x, n)))))), p)), x), x), And(FreeQ(List(a, b, c, d, m, n), x), IGtQ(p, C0), IntegerQ(m), IntegerQ(n)))),
            IIntegrate(5036, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(Times(d_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Times(d, x), m), Power(Plus(a, Times(C1D2, CI, b, Log(Plus(C1, Times(CN1, CI, Power(Times(Power(x, n), c), -1))))), Times(CN1, C1D2, CI, b, Log(Plus(C1, Times(CI, Power(Times(Power(x, n), c), -1)))))), p)), x), x), And(FreeQ(List(a, b, c, d, m, n), x), IGtQ(p, C0), IntegerQ(m), IntegerQ(n)))),
            IIntegrate(5037, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, Power(x_, n_))), b_DEFAULT)), p_DEFAULT), u_DEFAULT), x_Symbol),
                    Condition(Unintegrable(Times(u, Power(Plus(a, Times(b, ArcTan(Times(c, Power(x, n))))), p)), x), And(FreeQ(List(a, b, c, n, p), x), Or(EqQ(u, C1), MatchQ(u, Condition(Power(Times(d_DEFAULT, x), m_DEFAULT), FreeQ(List(d, m), x))))))),
            IIntegrate(5038, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, Power(x_, n_))), b_DEFAULT)), p_DEFAULT), u_DEFAULT), x_Symbol),
                    Condition(Unintegrable(Times(u, Power(Plus(a, Times(b, ArcCot(Times(c, Power(x, n))))), p)), x), And(FreeQ(List(a, b, c, n, p), x), Or(EqQ(u, C1), MatchQ(u, Condition(Power(Times(d_DEFAULT, x), m_DEFAULT), FreeQ(List(d, m), x))))))),
            IIntegrate(5039, Int(Power(Plus(a_DEFAULT, Times(ArcTan(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Power(d, -1), Subst(Int(Power(Plus(a, Times(b, ArcTan(x))), p), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d), x), IGtQ(p, C0)))),
            IIntegrate(5040, Int(Power(Plus(a_DEFAULT, Times(ArcCot(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Power(d, -1), Subst(Int(Power(Plus(a, Times(b, ArcCot(x))), p), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d), x), IGtQ(p, C0)))),
            IIntegrate(5041, Int(Power(Plus(a_DEFAULT, Times(ArcTan(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_), x_Symbol),
                    Condition(Unintegrable(Power(Plus(a, Times(b, ArcTan(Plus(c, Times(d, x))))), p), x), And(FreeQ(List(a, b, c, d, p), x), Not(IGtQ(p, C0))))),
            IIntegrate(5042, Int(Power(Plus(a_DEFAULT, Times(ArcCot(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_), x_Symbol),
                    Condition(Unintegrable(Power(Plus(a, Times(b, ArcCot(Plus(c, Times(d, x))))), p), x), And(FreeQ(List(a, b, c, d, p), x), Not(IGtQ(p, C0))))),
            IIntegrate(5043, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTan(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, -1), Subst(Int(Times(Power(Times(f, x, Power(d, -1)), m), Power(Plus(a, Times(b, ArcTan(x))), p)), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d, e, f, m), x), EqQ(Plus(Times(d, e), Times(CN1, c, f)), C0), IGtQ(p, C0)))),
            IIntegrate(5044, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCot(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, -1), Subst(Int(Times(Power(Times(f, x, Power(d, -1)), m), Power(Plus(a, Times(b, ArcCot(x))), p)), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d, e, f, m), x), EqQ(Plus(Times(d, e), Times(CN1, c, f)), C0), IGtQ(p, C0)))),
            IIntegrate(5045, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTan(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Power(Plus(a, Times(b, ArcTan(Plus(c, Times(d, x))))), p), Power(Times(f, Plus(m, C1)), -1)), x), Negate(Dist(Times(b, d, p, Power(Times(f, Plus(m, C1)), -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Power(Plus(a, Times(b, ArcTan(Plus(c, Times(d, x))))), Plus(p, Negate(C1))), Power(Plus(C1, Sqr(Plus(c, Times(d, x)))), -1)), x), x))), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(p, C0), ILtQ(m, CN1)))),
            IIntegrate(5046, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCot(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Power(Plus(a, Times(b, ArcCot(Plus(c, Times(d, x))))), p), Power(Times(f, Plus(m, C1)), -1)), x), Dist(Times(b, d, p, Power(Times(f, Plus(m, C1)), -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Power(Plus(a, Times(b, ArcCot(Plus(c, Times(d, x))))), Plus(p, Negate(C1))), Power(Plus(C1, Sqr(Plus(c, Times(d, x)))), -1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(p, C0), ILtQ(m, CN1)))),
            IIntegrate(5047, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTan(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, -1), Subst(Int(Times(Power(Plus(Times(Plus(Times(d, e), Times(CN1, c, f)), Power(d, -1)), Times(f, x, Power(d, -1))), m), Power(Plus(a, Times(b, ArcTan(x))), p)), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d, e, f, m, p), x), IGtQ(p, C0)))),
            IIntegrate(5048, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCot(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, -1), Subst(Int(Times(Power(Plus(Times(Plus(Times(d, e), Times(CN1, c, f)), Power(d, -1)), Times(f, x, Power(d, -1))), m), Power(Plus(a, Times(b, ArcCot(x))), p)), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d, e, f, m, p), x), IGtQ(p, C0)))),
            IIntegrate(5049, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTan(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(e, Times(f, x)), m), Power(Plus(a, Times(b, ArcTan(Plus(c, Times(d, x))))), p)), x), And(FreeQ(List(a, b, c, d, e, f, m, p), x), Not(IGtQ(p, C0))))),
            IIntegrate(5050, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCot(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(e, Times(f, x)), m), Power(Plus(a, Times(b, ArcCot(Plus(c, Times(d, x))))), p)), x), And(FreeQ(List(a, b, c, d, e, f, m, p), x), Not(IGtQ(p, C0)))))
    );
}
