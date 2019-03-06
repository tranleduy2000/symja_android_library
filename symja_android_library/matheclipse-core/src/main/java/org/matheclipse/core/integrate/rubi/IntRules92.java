package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcCos;
import static org.matheclipse.core.expression.F.ArcSin;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CI;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Cot;
import static org.matheclipse.core.expression.F.Csc;
import static org.matheclipse.core.expression.F.Exp;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sec;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Tan;
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
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.g;
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
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_DEFAULT;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandTrigReduce;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntHide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules92 {
    public static IAST RULES = List(
            IIntegrate(4601, Int(Times(Power(Times(b_DEFAULT, x_), m_DEFAULT), Power(Sec(Times(a_DEFAULT, x_)), n_DEFAULT), Power(Plus(Times(Cos(Times(a_DEFAULT, x_)), c_DEFAULT), Times(d_DEFAULT, x_, Sin(Times(a_DEFAULT, x_)))), -2)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, Power(Times(b, x), Plus(m, Negate(C1))), Power(Sec(Times(a, x)), Plus(n, C1)), Power(Times(a, d, Plus(Times(c, Cos(Times(a, x))), Times(d, x, Sin(Times(a, x))))), -1)), x)), Dist(Times(Sqr(b), Plus(n, C1), Power(d, -2)), Int(Times(Power(Times(b, x), Plus(m, Negate(C2))), Power(Sec(Times(a, x)), Plus(n, C2))), x), x)), And(FreeQ(List(a, b, c, d, m, n), x), EqQ(Plus(Times(a, c), Negate(d)), C0), EqQ(m, Plus(n, C2))))),
            IIntegrate(4602, Int(Times(Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), p_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sin(Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Sin(Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(a, m), Power(c, m)), Int(Times(Power(Plus(g, Times(h, x)), p), Power(Cos(Plus(e, Times(f, x))), Times(C2, m)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, Negate(m)))), x), x), And(FreeQ(List(a, b, c, d, e, f, g, h), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Plus(Sqr(a), Negate(Sqr(b))), C0), IntegerQ(m), IGtQ(Plus(n, Negate(m)), C0)))),
            IIntegrate(4603, Int(Times(Power(Plus(Times(Cos(Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_DEFAULT), Power(Plus(Times(Cos(Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_DEFAULT), Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(a, m), Power(c, m)), Int(Times(Power(Plus(g, Times(h, x)), p), Power(Sin(Plus(e, Times(f, x))), Times(C2, m)), Power(Plus(c, Times(d, Cos(Plus(e, Times(f, x))))), Plus(n, Negate(m)))), x), x), And(FreeQ(List(a, b, c, d, e, f, g, h), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Plus(Sqr(a), Negate(Sqr(b))), C0), IntegerQ(m), IGtQ(Plus(n, Negate(m)), C0)))),
            IIntegrate(4604, Int(Times(Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), p_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sin(Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_, Times(d_DEFAULT, Sin(Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Dist(Times(Power(a, IntPart(m)), Power(c, IntPart(m)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), FracPart(m)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), FracPart(m)), Power(Power(Cos(Plus(e, Times(f, x))), Times(C2, FracPart(m))), -1)), Int(Times(Power(Plus(g, Times(h, x)), p), Power(Cos(Plus(e, Times(f, x))), Times(C2, m)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, Negate(m)))), x), x), And(FreeQ(List(a, b, c, d, e, f, g, h), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Plus(Sqr(a), Negate(Sqr(b))), C0), IntegerQ(p), IntegerQ(Times(C2, m)), IGeQ(Plus(n, Negate(m)), C0)))),
            IIntegrate(4605, Int(Times(Power(Plus(Times(Cos(Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_), Power(Plus(Times(Cos(Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_), Power(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(a, IntPart(m)), Power(c, IntPart(m)), Power(Plus(a, Times(b, Cos(Plus(e, Times(f, x))))), FracPart(m)), Power(Plus(c, Times(d, Cos(Plus(e, Times(f, x))))), FracPart(m)), Power(Power(Sin(Plus(e, Times(f, x))), Times(C2, FracPart(m))), -1)), Int(Times(Power(Plus(g, Times(h, x)), p), Power(Sin(Plus(e, Times(f, x))), Times(C2, m)), Power(Plus(c, Times(d, Cos(Plus(e, Times(f, x))))), Plus(n, Negate(m)))), x), x), And(FreeQ(List(a, b, c, d, e, f, g, h), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Plus(Sqr(a), Negate(Sqr(b))), C0), IntegerQ(p), IntegerQ(Times(C2, m)), IGeQ(Plus(n, Negate(m)), C0)))),
            IIntegrate(4606, Int(Times(Power(Sec(v_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Tan(v_))), n_DEFAULT)), x_Symbol),
                    Condition(Int(Power(Plus(Times(a, Cos(v)), Times(b, Sin(v))), n), x), And(FreeQ(List(a, b), x), IntegerQ(Times(C1D2, Plus(m, Negate(C1)))), EqQ(Plus(m, n), C0)))),
            IIntegrate(4607, Int(Times(Power(Csc(v_), m_DEFAULT), Power(Plus(Times(Cot(v_), b_DEFAULT), a_), n_DEFAULT)), x_Symbol),
                    Condition(Int(Power(Plus(Times(b, Cos(v)), Times(a, Sin(v))), n), x), And(FreeQ(List(a, b), x), IntegerQ(Times(C1D2, Plus(m, Negate(C1)))), EqQ(Plus(m, n), C0)))),
            IIntegrate(4608, Int(Times(u_DEFAULT, Power(Sin(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), m_DEFAULT), Power(Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrigReduce(u, Times(Power(Sin(Plus(a, Times(b, x))), m), Power(Sin(Plus(c, Times(d, x))), n)), x), x), And(FreeQ(List(a, b, c, d), x), IGtQ(m, C0), IGtQ(n, C0)))),
            IIntegrate(4609, Int(Times(Power(Cos(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), m_DEFAULT), Power(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_DEFAULT), u_DEFAULT), x_Symbol),
                    Condition(Int(ExpandTrigReduce(u, Times(Power(Cos(Plus(a, Times(b, x))), m), Power(Cos(Plus(c, Times(d, x))), n)), x), x), And(FreeQ(List(a, b, c, d), x), IGtQ(m, C0), IGtQ(n, C0)))),
            IIntegrate(4610, Int(Times(Sec(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Sec(Plus(c_, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Negate(Dist(Csc(Times(Plus(Times(b, c), Times(CN1, a, d)), Power(d, -1))), Int(Tan(Plus(a, Times(b, x))), x), x)), Dist(Csc(Times(Plus(Times(b, c), Times(CN1, a, d)), Power(b, -1))), Int(Tan(Plus(c, Times(d, x))), x), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Plus(Sqr(b), Negate(Sqr(d))), C0), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0)))),
            IIntegrate(4611, Int(Times(Csc(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Csc(Plus(c_, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Dist(Csc(Times(Plus(Times(b, c), Times(CN1, a, d)), Power(b, -1))), Int(Cot(Plus(a, Times(b, x))), x), x), Negate(Dist(Csc(Times(Plus(Times(b, c), Times(CN1, a, d)), Power(d, -1))), Int(Cot(Plus(c, Times(d, x))), x), x))), And(FreeQ(List(a, b, c, d), x), EqQ(Plus(Sqr(b), Negate(Sqr(d))), C0), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0)))),
            IIntegrate(4612, Int(Times(Tan(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Tan(Plus(c_, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, x, Power(d, -1)), x)), Dist(Times(b, Cos(Times(Plus(Times(b, c), Times(CN1, a, d)), Power(d, -1))), Power(d, -1)), Int(Times(Sec(Plus(a, Times(b, x))), Sec(Plus(c, Times(d, x)))), x), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Plus(Sqr(b), Negate(Sqr(d))), C0), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0)))),
            IIntegrate(4613, Int(Times(Cot(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Cot(Plus(c_, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, x, Power(d, -1)), x)), Dist(Cos(Times(Plus(Times(b, c), Times(CN1, a, d)), Power(d, -1))), Int(Times(Csc(Plus(a, Times(b, x))), Csc(Plus(c, Times(d, x)))), x), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Plus(Sqr(b), Negate(Sqr(d))), C0), NeQ(Plus(Times(b, c), Times(CN1, a, d)), C0)))),
            IIntegrate(4614, Int(Times(u_DEFAULT, Power(Plus(Times(Cos(v_), a_DEFAULT), Times(b_DEFAULT, Sin(v_))), n_DEFAULT)), x_Symbol),
                    Condition(Int(Times(u, Power(Times(a, Power(Exp(Times(a, v, Power(b, -1))), -1)), n)), x), And(FreeQ(List(a, b, n), x), EqQ(Plus(Sqr(a), Sqr(b)), C0)))),
            IIntegrate(4615, Int(Sin(Times(Sqr(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT))), d_DEFAULT)), x_Symbol),
                    Condition(Plus(Dist(Times(C1D2, CI), Int(Exp(Times(CN1, CI, d, Sqr(Plus(a, Times(b, Log(Times(c, Power(x, n)))))))), x), x), Negate(Dist(Times(C1D2, CI), Int(Exp(Times(CI, d, Sqr(Plus(a, Times(b, Log(Times(c, Power(x, n)))))))), x), x))), FreeQ(List(a, b, c, d, n), x))),
            IIntegrate(4616, Int(Cos(Times(Sqr(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT))), d_DEFAULT)), x_Symbol),
                    Condition(Plus(Dist(C1D2, Int(Exp(Times(CN1, CI, d, Sqr(Plus(a, Times(b, Log(Times(c, Power(x, n)))))))), x), x), Dist(C1D2, Int(Exp(Times(CI, d, Sqr(Plus(a, Times(b, Log(Times(c, Power(x, n)))))))), x), x)), FreeQ(List(a, b, c, d, n), x))),
            IIntegrate(4617, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Sin(Times(Sqr(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT))), d_DEFAULT))), x_Symbol),
                    Condition(Plus(Dist(Times(C1D2, CI), Int(Times(Power(Times(e, x), m), Power(Exp(Times(CI, d, Sqr(Plus(a, Times(b, Log(Times(c, Power(x, n)))))))), -1)), x), x), Negate(Dist(Times(C1D2, CI), Int(Times(Power(Times(e, x), m), Exp(Times(CI, d, Sqr(Plus(a, Times(b, Log(Times(c, Power(x, n))))))))), x), x))), FreeQ(List(a, b, c, d, e, m, n), x))),
            IIntegrate(4618, Int(Times(Cos(Times(Sqr(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT))), d_DEFAULT)), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Dist(C1D2, Int(Times(Power(Times(e, x), m), Power(Exp(Times(CI, d, Sqr(Plus(a, Times(b, Log(Times(c, Power(x, n)))))))), -1)), x), x), Dist(C1D2, Int(Times(Power(Times(e, x), m), Exp(Times(CI, d, Sqr(Plus(a, Times(b, Log(Times(c, Power(x, n))))))))), x), x)), FreeQ(List(a, b, c, d, e, m, n), x))),
            IIntegrate(4619, Int(Power(Plus(a_DEFAULT, Times(ArcSin(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), x_Symbol),
                    Condition(Plus(Simp(Times(x, Power(Plus(a, Times(b, ArcSin(Times(c, x)))), n)), x), Negate(Dist(Times(b, c, n), Int(Times(x, Power(Plus(a, Times(b, ArcSin(Times(c, x)))), Plus(n, Negate(C1))), Power(Plus(C1, Times(CN1, Sqr(c), Sqr(x))), CN1D2)), x), x))), And(FreeQ(List(a, b, c), x), GtQ(n, C0)))),
            IIntegrate(4620, Int(Power(Plus(a_DEFAULT, Times(ArcCos(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), x_Symbol),
                    Condition(Plus(Simp(Times(x, Power(Plus(a, Times(b, ArcCos(Times(c, x)))), n)), x), Dist(Times(b, c, n), Int(Times(x, Power(Plus(a, Times(b, ArcCos(Times(c, x)))), Plus(n, Negate(C1))), Power(Plus(C1, Times(CN1, Sqr(c), Sqr(x))), CN1D2)), x), x)), And(FreeQ(List(a, b, c), x), GtQ(n, C0)))),
            IIntegrate(4621, Int(Power(Plus(a_DEFAULT, Times(ArcSin(Times(c_DEFAULT, x_)), b_DEFAULT)), n_), x_Symbol),
                    Condition(Plus(Simp(Times(Sqrt(Plus(C1, Times(CN1, Sqr(c), Sqr(x)))), Power(Plus(a, Times(b, ArcSin(Times(c, x)))), Plus(n, C1)), Power(Times(b, c, Plus(n, C1)), -1)), x), Dist(Times(c, Power(Times(b, Plus(n, C1)), -1)), Int(Times(x, Power(Plus(a, Times(b, ArcSin(Times(c, x)))), Plus(n, C1)), Power(Plus(C1, Times(CN1, Sqr(c), Sqr(x))), CN1D2)), x), x)), And(FreeQ(List(a, b, c), x), LtQ(n, CN1)))),
            IIntegrate(4622, Int(Power(Plus(a_DEFAULT, Times(ArcCos(Times(c_DEFAULT, x_)), b_DEFAULT)), n_), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Sqrt(Plus(C1, Times(CN1, Sqr(c), Sqr(x)))), Power(Plus(a, Times(b, ArcCos(Times(c, x)))), Plus(n, C1)), Power(Times(b, c, Plus(n, C1)), -1)), x)), Negate(Dist(Times(c, Power(Times(b, Plus(n, C1)), -1)), Int(Times(x, Power(Plus(a, Times(b, ArcCos(Times(c, x)))), Plus(n, C1)), Power(Plus(C1, Times(CN1, Sqr(c), Sqr(x))), CN1D2)), x), x))), And(FreeQ(List(a, b, c), x), LtQ(n, CN1)))),
            IIntegrate(4623, Int(Power(Plus(a_DEFAULT, Times(ArcSin(Times(c_DEFAULT, x_)), b_DEFAULT)), n_), x_Symbol),
                    Condition(Dist(Power(Times(b, c), -1), Subst(Int(Times(Power(x, n), Cos(Plus(Times(a, Power(b, -1)), Times(CN1, x, Power(b, -1))))), x), x, Plus(a, Times(b, ArcSin(Times(c, x))))), x), FreeQ(List(a, b, c, n), x))),
            IIntegrate(4624, Int(Power(Plus(a_DEFAULT, Times(ArcCos(Times(c_DEFAULT, x_)), b_DEFAULT)), n_), x_Symbol),
                    Condition(Dist(Power(Times(b, c), -1), Subst(Int(Times(Power(x, n), Sin(Plus(Times(a, Power(b, -1)), Times(CN1, x, Power(b, -1))))), x), x, Plus(a, Times(b, ArcCos(Times(c, x))))), x), FreeQ(List(a, b, c, n), x))),
            IIntegrate(4625, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSin(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(x_, -1)), x_Symbol),
                    Condition(Subst(Int(Times(Power(Plus(a, Times(b, x)), n), Power(Tan(x), -1)), x), x, ArcSin(Times(c, x))), And(FreeQ(List(a, b, c), x), IGtQ(n, C0)))),
            IIntegrate(4626, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCos(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(x_, -1)), x_Symbol),
                    Condition(Negate(Subst(Int(Times(Power(Plus(a, Times(b, x)), n), Power(Cot(x), -1)), x), x, ArcCos(Times(c, x)))), And(FreeQ(List(a, b, c), x), IGtQ(n, C0)))),
            IIntegrate(4627, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSin(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Times(d_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(d, x), Plus(m, C1)), Power(Plus(a, Times(b, ArcSin(Times(c, x)))), n), Power(Times(d, Plus(m, C1)), -1)), x), Negate(Dist(Times(b, c, n, Power(Times(d, Plus(m, C1)), -1)), Int(Times(Power(Times(d, x), Plus(m, C1)), Power(Plus(a, Times(b, ArcSin(Times(c, x)))), Plus(n, Negate(C1))), Power(Plus(C1, Times(CN1, Sqr(c), Sqr(x))), CN1D2)), x), x))), And(FreeQ(List(a, b, c, d, m), x), IGtQ(n, C0), NeQ(m, CN1)))),
            IIntegrate(4628, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCos(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Times(d_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(d, x), Plus(m, C1)), Power(Plus(a, Times(b, ArcCos(Times(c, x)))), n), Power(Times(d, Plus(m, C1)), -1)), x), Dist(Times(b, c, n, Power(Times(d, Plus(m, C1)), -1)), Int(Times(Power(Times(d, x), Plus(m, C1)), Power(Plus(a, Times(b, ArcCos(Times(c, x)))), Plus(n, Negate(C1))), Power(Plus(C1, Times(CN1, Sqr(c), Sqr(x))), CN1D2)), x), x)), And(FreeQ(List(a, b, c, d, m), x), IGtQ(n, C0), NeQ(m, CN1)))),
            IIntegrate(4629, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSin(Times(c_DEFAULT, x_)), b_DEFAULT)), n_), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, Plus(m, C1)), Power(Plus(a, Times(b, ArcSin(Times(c, x)))), n), Power(Plus(m, C1), -1)), x), Negate(Dist(Times(b, c, n, Power(Plus(m, C1), -1)), Int(Times(Power(x, Plus(m, C1)), Power(Plus(a, Times(b, ArcSin(Times(c, x)))), Plus(n, Negate(C1))), Power(Plus(C1, Times(CN1, Sqr(c), Sqr(x))), CN1D2)), x), x))), And(FreeQ(List(a, b, c), x), IGtQ(m, C0), GtQ(n, C0)))),
            IIntegrate(4630, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCos(Times(c_DEFAULT, x_)), b_DEFAULT)), n_), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, Plus(m, C1)), Power(Plus(a, Times(b, ArcCos(Times(c, x)))), n), Power(Plus(m, C1), -1)), x), Dist(Times(b, c, n, Power(Plus(m, C1), -1)), Int(Times(Power(x, Plus(m, C1)), Power(Plus(a, Times(b, ArcCos(Times(c, x)))), Plus(n, Negate(C1))), Power(Plus(C1, Times(CN1, Sqr(c), Sqr(x))), CN1D2)), x), x)), And(FreeQ(List(a, b, c), x), IGtQ(m, C0), GtQ(n, C0)))),
            IIntegrate(4631, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSin(Times(c_DEFAULT, x_)), b_DEFAULT)), n_), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, m), Sqrt(Plus(C1, Times(CN1, Sqr(c), Sqr(x)))), Power(Plus(a, Times(b, ArcSin(Times(c, x)))), Plus(n, C1)), Power(Times(b, c, Plus(n, C1)), -1)), x), Negate(Dist(Power(Times(b, Power(c, Plus(m, C1)), Plus(n, C1)), -1), Subst(Int(ExpandTrigReduce(Power(Plus(a, Times(b, x)), Plus(n, C1)), Times(Power(Sin(x), Plus(m, Negate(C1))), Plus(m, Times(CN1, Plus(m, C1), Sqr(Sin(x))))), x), x), x, ArcSin(Times(c, x))), x))), And(FreeQ(List(a, b, c), x), IGtQ(m, C0), GeQ(n, CN2), LtQ(n, CN1)))),
            IIntegrate(4632, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCos(Times(c_DEFAULT, x_)), b_DEFAULT)), n_), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(x, m), Sqrt(Plus(C1, Times(CN1, Sqr(c), Sqr(x)))), Power(Plus(a, Times(b, ArcCos(Times(c, x)))), Plus(n, C1)), Power(Times(b, c, Plus(n, C1)), -1)), x)), Negate(Dist(Power(Times(b, Power(c, Plus(m, C1)), Plus(n, C1)), -1), Subst(Int(ExpandTrigReduce(Power(Plus(a, Times(b, x)), Plus(n, C1)), Times(Power(Cos(x), Plus(m, Negate(C1))), Plus(m, Times(CN1, Plus(m, C1), Sqr(Cos(x))))), x), x), x, ArcCos(Times(c, x))), x))), And(FreeQ(List(a, b, c), x), IGtQ(m, C0), GeQ(n, CN2), LtQ(n, CN1)))),
            IIntegrate(4633, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSin(Times(c_DEFAULT, x_)), b_DEFAULT)), n_), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, m), Sqrt(Plus(C1, Times(CN1, Sqr(c), Sqr(x)))), Power(Plus(a, Times(b, ArcSin(Times(c, x)))), Plus(n, C1)), Power(Times(b, c, Plus(n, C1)), -1)), x), Dist(Times(c, Plus(m, C1), Power(Times(b, Plus(n, C1)), -1)), Int(Times(Power(x, Plus(m, C1)), Power(Plus(a, Times(b, ArcSin(Times(c, x)))), Plus(n, C1)), Power(Plus(C1, Times(CN1, Sqr(c), Sqr(x))), CN1D2)), x), x), Negate(Dist(Times(m, Power(Times(b, c, Plus(n, C1)), -1)), Int(Times(Power(x, Plus(m, Negate(C1))), Power(Plus(a, Times(b, ArcSin(Times(c, x)))), Plus(n, C1)), Power(Plus(C1, Times(CN1, Sqr(c), Sqr(x))), CN1D2)), x), x))), And(FreeQ(List(a, b, c), x), IGtQ(m, C0), LtQ(n, CN2)))),
            IIntegrate(4634, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCos(Times(c_DEFAULT, x_)), b_DEFAULT)), n_), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(x, m), Sqrt(Plus(C1, Times(CN1, Sqr(c), Sqr(x)))), Power(Plus(a, Times(b, ArcCos(Times(c, x)))), Plus(n, C1)), Power(Times(b, c, Plus(n, C1)), -1)), x)), Negate(Dist(Times(c, Plus(m, C1), Power(Times(b, Plus(n, C1)), -1)), Int(Times(Power(x, Plus(m, C1)), Power(Plus(a, Times(b, ArcCos(Times(c, x)))), Plus(n, C1)), Power(Plus(C1, Times(CN1, Sqr(c), Sqr(x))), CN1D2)), x), x)), Dist(Times(m, Power(Times(b, c, Plus(n, C1)), -1)), Int(Times(Power(x, Plus(m, Negate(C1))), Power(Plus(a, Times(b, ArcCos(Times(c, x)))), Plus(n, C1)), Power(Plus(C1, Times(CN1, Sqr(c), Sqr(x))), CN1D2)), x), x)), And(FreeQ(List(a, b, c), x), IGtQ(m, C0), LtQ(n, CN2)))),
            IIntegrate(4635, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSin(Times(c_DEFAULT, x_)), b_DEFAULT)), n_), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Power(c, Plus(m, C1)), -1), Subst(Int(Times(Power(Plus(a, Times(b, x)), n), Power(Sin(x), m), Cos(x)), x), x, ArcSin(Times(c, x))), x), And(FreeQ(List(a, b, c, n), x), IGtQ(m, C0)))),
            IIntegrate(4636, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCos(Times(c_DEFAULT, x_)), b_DEFAULT)), n_), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Negate(Dist(Power(Power(c, Plus(m, C1)), -1), Subst(Int(Times(Power(Plus(a, Times(b, x)), n), Power(Cos(x), m), Sin(x)), x), x, ArcCos(Times(c, x))), x)), And(FreeQ(List(a, b, c, n), x), IGtQ(m, C0)))),
            IIntegrate(4637, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSin(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Times(d_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Times(d, x), m), Power(Plus(a, Times(b, ArcSin(Times(c, x)))), n)), x), FreeQ(List(a, b, c, d, m, n), x))),
            IIntegrate(4638, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCos(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Times(d_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Times(d, x), m), Power(Plus(a, Times(b, ArcCos(Times(c, x)))), n)), x), FreeQ(List(a, b, c, d, m, n), x))),
            IIntegrate(4639, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSin(Times(c_DEFAULT, x_)), b_DEFAULT)), -1), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Simp(Times(Log(Plus(a, Times(b, ArcSin(Times(c, x))))), Power(Times(b, c, Sqrt(d)), -1)), x), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), GtQ(d, C0)))),
            IIntegrate(4640, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCos(Times(c_DEFAULT, x_)), b_DEFAULT)), -1), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Negate(Simp(Times(Log(Plus(a, Times(b, ArcCos(Times(c, x))))), Power(Times(b, c, Sqrt(d)), -1)), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), GtQ(d, C0)))),
            IIntegrate(4641, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSin(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Simp(Times(Power(Plus(a, Times(b, ArcSin(Times(c, x)))), Plus(n, C1)), Power(Times(b, c, Sqrt(d), Plus(n, C1)), -1)), x), And(FreeQ(List(a, b, c, d, e, n), x), EqQ(Plus(Times(Sqr(c), d), e), C0), GtQ(d, C0), NeQ(n, CN1)))),
            IIntegrate(4642, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCos(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Negate(Simp(Times(Power(Plus(a, Times(b, ArcCos(Times(c, x)))), Plus(n, C1)), Power(Times(b, c, Sqrt(d), Plus(n, C1)), -1)), x)), And(FreeQ(List(a, b, c, d, e, n), x), EqQ(Plus(Times(Sqr(c), d), e), C0), GtQ(d, C0), NeQ(n, CN1)))),
            IIntegrate(4643, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSin(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Plus(C1, Times(CN1, Sqr(c), Sqr(x)))), Power(Plus(d, Times(e, Sqr(x))), CN1D2)), Int(Times(Power(Plus(a, Times(b, ArcSin(Times(c, x)))), n), Power(Plus(C1, Times(CN1, Sqr(c), Sqr(x))), CN1D2)), x), x), And(FreeQ(List(a, b, c, d, e, n), x), EqQ(Plus(Times(Sqr(c), d), e), C0), Not(GtQ(d, C0))))),
            IIntegrate(4644, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCos(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Plus(C1, Times(CN1, Sqr(c), Sqr(x)))), Power(Plus(d, Times(e, Sqr(x))), CN1D2)), Int(Times(Power(Plus(a, Times(b, ArcCos(Times(c, x)))), n), Power(Plus(C1, Times(CN1, Sqr(c), Sqr(x))), CN1D2)), x), x), And(FreeQ(List(a, b, c, d, e, n), x), EqQ(Plus(Times(Sqr(c), d), e), C0), Not(GtQ(d, C0))))),
            IIntegrate(4645, Int(Times(Plus(a_DEFAULT, Times(ArcSin(Times(c_DEFAULT, x_)), b_DEFAULT)), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Power(Plus(d, Times(e, Sqr(x))), p), x))), Plus(Dist(Plus(a, Times(b, ArcSin(Times(c, x)))), u, x), Negate(Dist(Times(b, c), Int(SimplifyIntegrand(Times(u, Power(Plus(C1, Times(CN1, Sqr(c), Sqr(x))), CN1D2)), x), x), x)))), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), IGtQ(p, C0)))),
            IIntegrate(4646, Int(Times(Plus(a_DEFAULT, Times(ArcCos(Times(c_DEFAULT, x_)), b_DEFAULT)), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Power(Plus(d, Times(e, Sqr(x))), p), x))), Plus(Dist(Plus(a, Times(b, ArcCos(Times(c, x)))), u, x), Dist(Times(b, c), Int(SimplifyIntegrand(Times(u, Power(Plus(C1, Times(CN1, Sqr(c), Sqr(x))), CN1D2)), x), x), x))), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), IGtQ(p, C0)))),
            IIntegrate(4647, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSin(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Sqrt(Plus(d_, Times(e_DEFAULT, Sqr(x_))))), x_Symbol),
                    Condition(Plus(Simp(Times(C1D2, x, Sqrt(Plus(d, Times(e, Sqr(x)))), Power(Plus(a, Times(b, ArcSin(Times(c, x)))), n)), x), Dist(Times(Sqrt(Plus(d, Times(e, Sqr(x)))), Power(Times(C2, Sqrt(Plus(C1, Times(CN1, Sqr(c), Sqr(x))))), -1)), Int(Times(Power(Plus(a, Times(b, ArcSin(Times(c, x)))), n), Power(Plus(C1, Times(CN1, Sqr(c), Sqr(x))), CN1D2)), x), x), Negate(Dist(Times(b, c, n, Sqrt(Plus(d, Times(e, Sqr(x)))), Power(Times(C2, Sqrt(Plus(C1, Times(CN1, Sqr(c), Sqr(x))))), -1)), Int(Times(x, Power(Plus(a, Times(b, ArcSin(Times(c, x)))), Plus(n, Negate(C1)))), x), x))), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), GtQ(n, C0)))),
            IIntegrate(4648, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCos(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Sqrt(Plus(d_, Times(e_DEFAULT, Sqr(x_))))), x_Symbol),
                    Condition(Plus(Simp(Times(C1D2, x, Sqrt(Plus(d, Times(e, Sqr(x)))), Power(Plus(a, Times(b, ArcCos(Times(c, x)))), n)), x), Dist(Times(Sqrt(Plus(d, Times(e, Sqr(x)))), Power(Times(C2, Sqrt(Plus(C1, Times(CN1, Sqr(c), Sqr(x))))), -1)), Int(Times(Power(Plus(a, Times(b, ArcCos(Times(c, x)))), n), Power(Plus(C1, Times(CN1, Sqr(c), Sqr(x))), CN1D2)), x), x), Dist(Times(b, c, n, Sqrt(Plus(d, Times(e, Sqr(x)))), Power(Times(C2, Sqrt(Plus(C1, Times(CN1, Sqr(c), Sqr(x))))), -1)), Int(Times(x, Power(Plus(a, Times(b, ArcCos(Times(c, x)))), Plus(n, Negate(C1)))), x), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), GtQ(n, C0)))),
            IIntegrate(4649, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSin(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(x, Power(Plus(d, Times(e, Sqr(x))), p), Power(Plus(a, Times(b, ArcSin(Times(c, x)))), n), Power(Plus(Times(C2, p), C1), -1)), x), Dist(Times(C2, d, p, Power(Plus(Times(C2, p), C1), -1)), Int(Times(Power(Plus(d, Times(e, Sqr(x))), Plus(p, Negate(C1))), Power(Plus(a, Times(b, ArcSin(Times(c, x)))), n)), x), x), Negate(Dist(Times(b, c, n, Power(d, IntPart(p)), Power(Plus(d, Times(e, Sqr(x))), FracPart(p)), Power(Times(Plus(Times(C2, p), C1), Power(Plus(C1, Times(CN1, Sqr(c), Sqr(x))), FracPart(p))), -1)), Int(Times(x, Power(Plus(C1, Times(CN1, Sqr(c), Sqr(x))), Plus(p, Negate(C1D2))), Power(Plus(a, Times(b, ArcSin(Times(c, x)))), Plus(n, Negate(C1)))), x), x))), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), GtQ(n, C0), GtQ(p, C0)))),
            IIntegrate(4650, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCos(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(x, Power(Plus(d, Times(e, Sqr(x))), p), Power(Plus(a, Times(b, ArcCos(Times(c, x)))), n), Power(Plus(Times(C2, p), C1), -1)), x), Dist(Times(C2, d, p, Power(Plus(Times(C2, p), C1), -1)), Int(Times(Power(Plus(d, Times(e, Sqr(x))), Plus(p, Negate(C1))), Power(Plus(a, Times(b, ArcCos(Times(c, x)))), n)), x), x), Dist(Times(b, c, n, Power(d, IntPart(p)), Power(Plus(d, Times(e, Sqr(x))), FracPart(p)), Power(Times(Plus(Times(C2, p), C1), Power(Plus(C1, Times(CN1, Sqr(c), Sqr(x))), FracPart(p))), -1)), Int(Times(x, Power(Plus(C1, Times(CN1, Sqr(c), Sqr(x))), Plus(p, Negate(C1D2))), Power(Plus(a, Times(b, ArcCos(Times(c, x)))), Plus(n, Negate(C1)))), x), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), GtQ(n, C0), GtQ(p, C0))))
    );
}
