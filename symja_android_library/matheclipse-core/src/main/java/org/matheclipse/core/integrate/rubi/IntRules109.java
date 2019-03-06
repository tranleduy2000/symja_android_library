package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cosh;
import static org.matheclipse.core.expression.F.Coth;
import static org.matheclipse.core.expression.F.Csch;
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
import static org.matheclipse.core.expression.F.MemberQ;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Pi;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sech;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sinh;
import static org.matheclipse.core.expression.F.Sqr;
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
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.w;
import static org.matheclipse.core.expression.F.w_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandTrigExpand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandTrigReduce;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.F;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.G;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.HyperbolicQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntHide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearMatchQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyIntegrand;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *
 */
public class IntRules109 {
    public static IAST RULES = List(
            IIntegrate(5451, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Power(Sech(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT), Power(Tanh(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(c, Times(d, x)), m), Power(Sech(Plus(a, Times(b, x))), n), Power(Times(b, n), -1)), x)), Dist(Times(d, m, Power(Times(b, n), -1)), Int(Times(Power(Plus(c, Times(d, x)), Plus(m, Negate(C1))), Power(Sech(Plus(a, Times(b, x))), n)), x), x)), And(FreeQ(List(a, b, c, d, n), x), EqQ(p, C1), GtQ(m, C0)))),
            IIntegrate(5452, Int(Times(Power(Coth(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_DEFAULT), Power(Csch(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(c, Times(d, x)), m), Power(Csch(Plus(a, Times(b, x))), n), Power(Times(b, n), -1)), x)), Dist(Times(d, m, Power(Times(b, n), -1)), Int(Times(Power(Plus(c, Times(d, x)), Plus(m, Negate(C1))), Power(Csch(Plus(a, Times(b, x))), n)), x), x)), And(FreeQ(List(a, b, c, d, n), x), EqQ(p, C1), GtQ(m, C0)))),
            IIntegrate(5453, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Sqr(Sech(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Tanh(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(c, Times(d, x)), m), Power(Tanh(Plus(a, Times(b, x))), Plus(n, C1)), Power(Times(b, Plus(n, C1)), -1)), x), Negate(Dist(Times(d, m, Power(Times(b, Plus(n, C1)), -1)), Int(Times(Power(Plus(c, Times(d, x)), Plus(m, Negate(C1))), Power(Tanh(Plus(a, Times(b, x))), Plus(n, C1))), x), x))), And(FreeQ(List(a, b, c, d, n), x), IGtQ(m, C0), NeQ(n, CN1)))),
            IIntegrate(5454, Int(Times(Power(Coth(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT), Sqr(Csch(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(c, Times(d, x)), m), Power(Coth(Plus(a, Times(b, x))), Plus(n, C1)), Power(Times(b, Plus(n, C1)), -1)), x)), Dist(Times(d, m, Power(Times(b, Plus(n, C1)), -1)), Int(Times(Power(Plus(c, Times(d, x)), Plus(m, Negate(C1))), Power(Coth(Plus(a, Times(b, x))), Plus(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, n), x), IGtQ(m, C0), NeQ(n, CN1)))),
            IIntegrate(5455, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Sech(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Power(Tanh(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_)), x_Symbol),
                    Condition(Plus(Int(Times(Power(Plus(c, Times(d, x)), m), Sech(Plus(a, Times(b, x))), Power(Tanh(Plus(a, Times(b, x))), Plus(p, Negate(C2)))), x), Negate(Int(Times(Power(Plus(c, Times(d, x)), m), Power(Sech(Plus(a, Times(b, x))), 3), Power(Tanh(Plus(a, Times(b, x))), Plus(p, Negate(C2)))), x))), And(FreeQ(List(a, b, c, d, m), x), IGtQ(Times(C1D2, p), C0)))),
            IIntegrate(5456, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Power(Sech(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT), Power(Tanh(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_)), x_Symbol),
                    Condition(Plus(Int(Times(Power(Plus(c, Times(d, x)), m), Power(Sech(Plus(a, Times(b, x))), n), Power(Tanh(Plus(a, Times(b, x))), Plus(p, Negate(C2)))), x), Negate(Int(Times(Power(Plus(c, Times(d, x)), m), Power(Sech(Plus(a, Times(b, x))), Plus(n, C2)), Power(Tanh(Plus(a, Times(b, x))), Plus(p, Negate(C2)))), x))), And(FreeQ(List(a, b, c, d, m, n), x), IGtQ(Times(C1D2, p), C0)))),
            IIntegrate(5457, Int(Times(Power(Coth(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_), Csch(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Int(Times(Power(Plus(c, Times(d, x)), m), Csch(Plus(a, Times(b, x))), Power(Coth(Plus(a, Times(b, x))), Plus(p, Negate(C2)))), x), Int(Times(Power(Plus(c, Times(d, x)), m), Power(Csch(Plus(a, Times(b, x))), 3), Power(Coth(Plus(a, Times(b, x))), Plus(p, Negate(C2)))), x)), And(FreeQ(List(a, b, c, d, m), x), IGtQ(Times(C1D2, p), C0)))),
            IIntegrate(5458, Int(Times(Power(Coth(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_), Power(Csch(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Int(Times(Power(Plus(c, Times(d, x)), m), Power(Csch(Plus(a, Times(b, x))), n), Power(Coth(Plus(a, Times(b, x))), Plus(p, Negate(C2)))), x), Int(Times(Power(Plus(c, Times(d, x)), m), Power(Csch(Plus(a, Times(b, x))), Plus(n, C2)), Power(Coth(Plus(a, Times(b, x))), Plus(p, Negate(C2)))), x)), And(FreeQ(List(a, b, c, d, m, n), x), IGtQ(Times(C1D2, p), C0)))),
            IIntegrate(5459, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Power(Sech(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT), Power(Tanh(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Times(Power(Sech(Plus(a, Times(b, x))), n), Power(Tanh(Plus(a, Times(b, x))), p)), x))), Plus(Dist(Power(Plus(c, Times(d, x)), m), u, x), Negate(Dist(Times(d, m), Int(Times(Power(Plus(c, Times(d, x)), Plus(m, Negate(C1))), u), x), x)))), And(FreeQ(List(a, b, c, d, n, p), x), IGtQ(m, C0), Or(IntegerQ(Times(C1D2, n)), IntegerQ(Times(C1D2, Plus(p, Negate(C1)))))))),
            IIntegrate(5460, Int(Times(Power(Coth(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_DEFAULT), Power(Csch(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Times(Power(Csch(Plus(a, Times(b, x))), n), Power(Coth(Plus(a, Times(b, x))), p)), x))), Plus(Dist(Power(Plus(c, Times(d, x)), m), u, x), Negate(Dist(Times(d, m), Int(Times(Power(Plus(c, Times(d, x)), Plus(m, Negate(C1))), u), x), x)))), And(FreeQ(List(a, b, c, d, n, p), x), IGtQ(m, C0), Or(IntegerQ(Times(C1D2, n)), IntegerQ(Times(C1D2, Plus(p, Negate(C1)))))))),
            IIntegrate(5461, Int(Times(Power(Csch(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Power(Sech(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(C2, n), Int(Times(Power(Plus(c, Times(d, x)), m), Power(Csch(Plus(Times(C2, a), Times(C2, b, x))), n)), x), x), And(FreeQ(List(a, b, c, d), x), RationalQ(m), IntegerQ(n)))),
            IIntegrate(5462, Int(Times(Power(Csch(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Power(Sech(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Times(Power(Csch(Plus(a, Times(b, x))), n), Power(Sech(Plus(a, Times(b, x))), p)), x))), Plus(Dist(Power(Plus(c, Times(d, x)), m), u, x), Negate(Dist(Times(d, m), Int(Times(Power(Plus(c, Times(d, x)), Plus(m, Negate(C1))), u), x), x)))), And(FreeQ(List(a, b, c, d), x), IntegersQ(n, p), GtQ(m, C0), NeQ(n, p)))),
            IIntegrate(5463, Int(Times(Power(u_, m_DEFAULT), Power($(F_, v_), n_DEFAULT), Power($(G_, w_), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(ExpandToSum(u, x), m), Power(F(ExpandToSum(v, x)), n), Power(G(ExpandToSum(v, x)), p)), x), And(FreeQ(List(m, n, p), x), HyperbolicQ(FSymbol), HyperbolicQ(GSymbol), EqQ(v, w), LinearQ(List(u, v, w), x), Not(LinearMatchQ(List(u, v, w), x))))),
            IIntegrate(5464, Int(Times(Cosh(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sinh(Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), n_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), m), Power(Plus(a, Times(b, Sinh(Plus(c, Times(d, x))))), Plus(n, C1)), Power(Times(b, d, Plus(n, C1)), -1)), x), Negate(Dist(Times(f, m, Power(Times(b, d, Plus(n, C1)), -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, Negate(C1))), Power(Plus(a, Times(b, Sinh(Plus(c, Times(d, x))))), Plus(n, C1))), x), x))), And(FreeQ(List(a, b, c, d, e, f, n), x), IGtQ(m, C0), NeQ(n, CN1)))),
            IIntegrate(5465, Int(Times(Power(Plus(Times(Cosh(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Sinh(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), m), Power(Plus(a, Times(b, Cosh(Plus(c, Times(d, x))))), Plus(n, C1)), Power(Times(b, d, Plus(n, C1)), -1)), x), Negate(Dist(Times(f, m, Power(Times(b, d, Plus(n, C1)), -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, Negate(C1))), Power(Plus(a, Times(b, Cosh(Plus(c, Times(d, x))))), Plus(n, C1))), x), x))), And(FreeQ(List(a, b, c, d, e, f, n), x), IGtQ(m, C0), NeQ(n, CN1)))),
            IIntegrate(5466, Int(Times(Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Sqr(Sech(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), Power(Plus(a_, Times(b_DEFAULT, Tanh(Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), n_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), m), Power(Plus(a, Times(b, Tanh(Plus(c, Times(d, x))))), Plus(n, C1)), Power(Times(b, d, Plus(n, C1)), -1)), x), Negate(Dist(Times(f, m, Power(Times(b, d, Plus(n, C1)), -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, Negate(C1))), Power(Plus(a, Times(b, Tanh(Plus(c, Times(d, x))))), Plus(n, C1))), x), x))), And(FreeQ(List(a, b, c, d, e, f, n), x), IGtQ(m, C0), NeQ(n, CN1)))),
            IIntegrate(5467, Int(Times(Sqr(Csch(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), Power(Plus(Times(Coth(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(e, Times(f, x)), m), Power(Plus(a, Times(b, Coth(Plus(c, Times(d, x))))), Plus(n, C1)), Power(Times(b, d, Plus(n, C1)), -1)), x)), Dist(Times(f, m, Power(Times(b, d, Plus(n, C1)), -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, Negate(C1))), Power(Plus(a, Times(b, Coth(Plus(c, Times(d, x))))), Plus(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f, n), x), IGtQ(m, C0), NeQ(n, CN1)))),
            IIntegrate(5468, Int(Times(Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Sech(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(Plus(a_, Times(b_DEFAULT, Sech(Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), n_DEFAULT), Tanh(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(e, Times(f, x)), m), Power(Plus(a, Times(b, Sech(Plus(c, Times(d, x))))), Plus(n, C1)), Power(Times(b, d, Plus(n, C1)), -1)), x)), Dist(Times(f, m, Power(Times(b, d, Plus(n, C1)), -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, Negate(C1))), Power(Plus(a, Times(b, Sech(Plus(c, Times(d, x))))), Plus(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f, n), x), IGtQ(m, C0), NeQ(n, CN1)))),
            IIntegrate(5469, Int(Times(Coth(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Csch(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(Plus(Times(Csch(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(e, Times(f, x)), m), Power(Plus(a, Times(b, Csch(Plus(c, Times(d, x))))), Plus(n, C1)), Power(Times(b, d, Plus(n, C1)), -1)), x)), Dist(Times(f, m, Power(Times(b, d, Plus(n, C1)), -1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, Negate(C1))), Power(Plus(a, Times(b, Csch(Plus(c, Times(d, x))))), Plus(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f, n), x), IGtQ(m, C0), NeQ(n, CN1)))),
            IIntegrate(5470, Int(Times(Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Sinh(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_DEFAULT), Power(Sinh(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), q_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrigReduce(Power(Plus(e, Times(f, x)), m), Times(Power(Sinh(Plus(a, Times(b, x))), p), Power(Sinh(Plus(c, Times(d, x))), q)), x), x), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(p, C0), IGtQ(q, C0), IntegerQ(m)))),
            IIntegrate(5471, Int(Times(Power(Cosh(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_DEFAULT), Power(Cosh(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), q_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrigReduce(Power(Plus(e, Times(f, x)), m), Times(Power(Cosh(Plus(a, Times(b, x))), p), Power(Cosh(Plus(c, Times(d, x))), q)), x), x), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(p, C0), IGtQ(q, C0), IntegerQ(m)))),
            IIntegrate(5472, Int(Times(Power(Cosh(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), q_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Sinh(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrigReduce(Power(Plus(e, Times(f, x)), m), Times(Power(Sinh(Plus(a, Times(b, x))), p), Power(Cosh(Plus(c, Times(d, x))), q)), x), x), And(FreeQ(List(a, b, c, d, e, f, m), x), IGtQ(p, C0), IGtQ(q, C0)))),
            IIntegrate(5473, Int(Times(Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power($(F_, Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_DEFAULT), Power($(G_, Plus(c_DEFAULT, Times(d_DEFAULT, x_))), q_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrigExpand(Times(Power(Plus(e, Times(f, x)), m), Power(G(Plus(c, Times(d, x))), q)), FSymbol, Plus(c, Times(d, x)), p, Times(b, Power(d, -1)), x), x), And(FreeQ(List(a, b, c, d, e, f, m), x), MemberQ(List(Sinh, Cosh), FSymbol), MemberQ(List(Sech, Csch), GSymbol), IGtQ(p, C0), IGtQ(q, C0), EqQ(Plus(Times(b, c), Times(CN1, a, d)), C0), IGtQ(Times(b, Power(d, -1)), C1)))),
            IIntegrate(5474, Int(Times(Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Sinh(Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, c, Log(FSymbol), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Sinh(Plus(d, Times(e, x))), Power(Plus(Sqr(e), Times(CN1, Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), -1)), x)), Simp(Times(e, Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Cosh(Plus(d, Times(e, x))), Power(Plus(Sqr(e), Times(CN1, Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), -1)), x)), And(FreeQ(List(FSymbol, a, b, c, d, e), x), NeQ(Plus(Sqr(e), Times(CN1, Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), C0)))),
            IIntegrate(5475, Int(Times(Cosh(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, c, Log(FSymbol), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Cosh(Plus(d, Times(e, x))), Power(Plus(Sqr(e), Times(CN1, Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), -1)), x)), Simp(Times(e, Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Sinh(Plus(d, Times(e, x))), Power(Plus(Sqr(e), Times(CN1, Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), -1)), x)), And(FreeQ(List(FSymbol, a, b, c, d, e), x), NeQ(Plus(Sqr(e), Times(CN1, Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), C0)))),
            IIntegrate(5476, Int(Times(Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Sinh(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, c, Log(FSymbol), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Sinh(Plus(d, Times(e, x))), n), Power(Plus(Times(Sqr(e), Sqr(n)), Times(CN1, Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), -1)), x)), Negate(Dist(Times(n, Plus(n, Negate(C1)), Sqr(e), Power(Plus(Times(Sqr(e), Sqr(n)), Times(CN1, Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), -1)), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Sinh(Plus(d, Times(e, x))), Plus(n, Negate(C2)))), x), x)), Simp(Times(e, n, Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Cosh(Plus(d, Times(e, x))), Power(Sinh(Plus(d, Times(e, x))), Plus(n, Negate(C1))), Power(Plus(Times(Sqr(e), Sqr(n)), Times(CN1, Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), -1)), x)), And(FreeQ(List(FSymbol, a, b, c, d, e), x), NeQ(Plus(Times(Sqr(e), Sqr(n)), Times(CN1, Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), C0), GtQ(n, C1)))),
            IIntegrate(5477, Int(Times(Power(Cosh(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, c, Log(FSymbol), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Cosh(Plus(d, Times(e, x))), n), Power(Plus(Times(Sqr(e), Sqr(n)), Times(CN1, Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), -1)), x)), Dist(Times(n, Plus(n, Negate(C1)), Sqr(e), Power(Plus(Times(Sqr(e), Sqr(n)), Times(CN1, Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), -1)), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Cosh(Plus(d, Times(e, x))), Plus(n, Negate(C2)))), x), x), Simp(Times(e, n, Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Sinh(Plus(d, Times(e, x))), Power(Cosh(Plus(d, Times(e, x))), Plus(n, Negate(C1))), Power(Plus(Times(Sqr(e), Sqr(n)), Times(CN1, Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), -1)), x)), And(FreeQ(List(FSymbol, a, b, c, d, e), x), NeQ(Plus(Times(Sqr(e), Sqr(n)), Times(CN1, Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), C0), GtQ(n, C1)))),
            IIntegrate(5478, Int(Times(Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Sinh(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, c, Log(FSymbol), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Sinh(Plus(d, Times(e, x))), Plus(n, C2)), Power(Times(Sqr(e), Plus(n, C1), Plus(n, C2)), -1)), x)), Simp(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Cosh(Plus(d, Times(e, x))), Power(Sinh(Plus(d, Times(e, x))), Plus(n, C1)), Power(Times(e, Plus(n, C1)), -1)), x)), And(FreeQ(List(FSymbol, a, b, c, d, e, n), x), EqQ(Plus(Times(Sqr(e), Sqr(Plus(n, C2))), Times(CN1, Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), C0), NeQ(n, CN1), NeQ(n, CN2)))),
            IIntegrate(5479, Int(Times(Power(Cosh(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), x_Symbol),
                    Condition(Plus(Simp(Times(b, c, Log(FSymbol), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Cosh(Plus(d, Times(e, x))), Plus(n, C2)), Power(Times(Sqr(e), Plus(n, C1), Plus(n, C2)), -1)), x), Negate(Simp(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Sinh(Plus(d, Times(e, x))), Power(Cosh(Plus(d, Times(e, x))), Plus(n, C1)), Power(Times(e, Plus(n, C1)), -1)), x))), And(FreeQ(List(FSymbol, a, b, c, d, e, n), x), EqQ(Plus(Times(Sqr(e), Sqr(Plus(n, C2))), Times(CN1, Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), C0), NeQ(n, CN1), NeQ(n, CN2)))),
            IIntegrate(5480, Int(Times(Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Sinh(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, c, Log(FSymbol), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Sinh(Plus(d, Times(e, x))), Plus(n, C2)), Power(Times(Sqr(e), Plus(n, C1), Plus(n, C2)), -1)), x)), Negate(Dist(Times(Plus(Times(Sqr(e), Sqr(Plus(n, C2))), Times(CN1, Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), Power(Times(Sqr(e), Plus(n, C1), Plus(n, C2)), -1)), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Sinh(Plus(d, Times(e, x))), Plus(n, C2))), x), x)), Simp(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Cosh(Plus(d, Times(e, x))), Power(Sinh(Plus(d, Times(e, x))), Plus(n, C1)), Power(Times(e, Plus(n, C1)), -1)), x)), And(FreeQ(List(FSymbol, a, b, c, d, e), x), NeQ(Plus(Times(Sqr(e), Sqr(Plus(n, C2))), Times(CN1, Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), C0), LtQ(n, CN1), NeQ(n, CN2)))),
            IIntegrate(5481, Int(Times(Power(Cosh(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), x_Symbol),
                    Condition(Plus(Simp(Times(b, c, Log(FSymbol), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Cosh(Plus(d, Times(e, x))), Plus(n, C2)), Power(Times(Sqr(e), Plus(n, C1), Plus(n, C2)), -1)), x), Dist(Times(Plus(Times(Sqr(e), Sqr(Plus(n, C2))), Times(CN1, Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), Power(Times(Sqr(e), Plus(n, C1), Plus(n, C2)), -1)), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Cosh(Plus(d, Times(e, x))), Plus(n, C2))), x), x), Negate(Simp(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Sinh(Plus(d, Times(e, x))), Power(Cosh(Plus(d, Times(e, x))), Plus(n, C1)), Power(Times(e, Plus(n, C1)), -1)), x))), And(FreeQ(List(FSymbol, a, b, c, d, e), x), NeQ(Plus(Times(Sqr(e), Sqr(Plus(n, C2))), Times(CN1, Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), C0), LtQ(n, CN1), NeQ(n, CN2)))),
            IIntegrate(5482, Int(Times(Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Sinh(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_)), x_Symbol),
                    Condition(Dist(Times(Exp(Times(n, Plus(d, Times(e, x)))), Power(Sinh(Plus(d, Times(e, x))), n), Power(Power(Plus(CN1, Exp(Times(C2, Plus(d, Times(e, x))))), n), -1)), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Plus(CN1, Exp(Times(C2, Plus(d, Times(e, x))))), n), Power(Exp(Times(n, Plus(d, Times(e, x)))), -1)), x), x), And(FreeQ(List(FSymbol, a, b, c, d, e, n), x), Not(IntegerQ(n))))),
            IIntegrate(5483, Int(Times(Power(Cosh(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), x_Symbol),
                    Condition(Dist(Times(Exp(Times(n, Plus(d, Times(e, x)))), Power(Cosh(Plus(d, Times(e, x))), n), Power(Power(Plus(C1, Exp(Times(C2, Plus(d, Times(e, x))))), n), -1)), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Plus(C1, Exp(Times(C2, Plus(d, Times(e, x))))), n), Power(Exp(Times(n, Plus(d, Times(e, x)))), -1)), x), x), And(FreeQ(List(FSymbol, a, b, c, d, e, n), x), Not(IntegerQ(n))))),
            IIntegrate(5484, Int(Times(Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Tanh(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Plus(CN1, Exp(Times(C2, Plus(d, Times(e, x))))), n), Power(Power(Plus(C1, Exp(Times(C2, Plus(d, Times(e, x))))), n), -1)), x), x), And(FreeQ(List(FSymbol, a, b, c, d, e), x), IntegerQ(n)))),
            IIntegrate(5485, Int(Times(Power(Coth(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Plus(C1, Exp(Times(C2, Plus(d, Times(e, x))))), n), Power(Power(Plus(CN1, Exp(Times(C2, Plus(d, Times(e, x))))), n), -1)), x), x), And(FreeQ(List(FSymbol, a, b, c, d, e), x), IntegerQ(n)))),
            IIntegrate(5486, Int(Times(Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Sech(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, c, Log(FSymbol), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Sech(Plus(d, Times(e, x))), n), Power(Plus(Times(Sqr(e), Sqr(n)), Times(CN1, Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), -1)), x)), Dist(Times(Sqr(e), n, Plus(n, C1), Power(Plus(Times(Sqr(e), Sqr(n)), Times(CN1, Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), -1)), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Sech(Plus(d, Times(e, x))), Plus(n, C2))), x), x), Negate(Simp(Times(e, n, Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Sech(Plus(d, Times(e, x))), Plus(n, C1)), Sinh(Plus(d, Times(e, x))), Power(Plus(Times(Sqr(e), Sqr(n)), Times(CN1, Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), -1)), x))), And(FreeQ(List(FSymbol, a, b, c, d, e), x), NeQ(Plus(Times(Sqr(e), Sqr(n)), Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), C0), LtQ(n, CN1)))),
            IIntegrate(5487, Int(Times(Power(Csch(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, c, Log(FSymbol), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Csch(Plus(d, Times(e, x))), n), Power(Plus(Times(Sqr(e), Sqr(n)), Times(CN1, Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), -1)), x)), Negate(Dist(Times(Sqr(e), n, Plus(n, C1), Power(Plus(Times(Sqr(e), Sqr(n)), Times(CN1, Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), -1)), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Csch(Plus(d, Times(e, x))), Plus(n, C2))), x), x)), Negate(Simp(Times(e, n, Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Csch(Plus(d, Times(e, x))), Plus(n, C1)), Cosh(Plus(d, Times(e, x))), Power(Plus(Times(Sqr(e), Sqr(n)), Times(CN1, Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), -1)), x))), And(FreeQ(List(FSymbol, a, b, c, d, e), x), NeQ(Plus(Times(Sqr(e), Sqr(n)), Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), C0), LtQ(n, CN1)))),
            IIntegrate(5488, Int(Times(Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Sech(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_)), x_Symbol),
                    Condition(Plus(Simp(Times(b, c, Log(FSymbol), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Sech(Plus(d, Times(e, x))), Plus(n, Negate(C2))), Power(Times(Sqr(e), Plus(n, Negate(C1)), Plus(n, Negate(C2))), -1)), x), Simp(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Sech(Plus(d, Times(e, x))), Plus(n, Negate(C1))), Sinh(Plus(d, Times(e, x))), Power(Times(e, Plus(n, Negate(C1))), -1)), x)), And(FreeQ(List(FSymbol, a, b, c, d, e, n), x), EqQ(Plus(Times(Sqr(e), Sqr(Plus(n, Negate(C2)))), Times(CN1, Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), C0), NeQ(n, C1), NeQ(n, C2)))),
            IIntegrate(5489, Int(Times(Power(Csch(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, c, Log(FSymbol), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Csch(Plus(d, Times(e, x))), Plus(n, Negate(C2))), Power(Times(Sqr(e), Plus(n, Negate(C1)), Plus(n, Negate(C2))), -1)), x)), Negate(Simp(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Csch(Plus(d, Times(e, x))), Plus(n, Negate(C1))), Cosh(Plus(d, Times(e, x))), Power(Times(e, Plus(n, Negate(C1))), -1)), x))), And(FreeQ(List(FSymbol, a, b, c, d, e, n), x), EqQ(Plus(Times(Sqr(e), Sqr(Plus(n, Negate(C2)))), Times(CN1, Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), C0), NeQ(n, C1), NeQ(n, C2)))),
            IIntegrate(5490, Int(Times(Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Sech(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_)), x_Symbol),
                    Condition(Plus(Simp(Times(b, c, Log(FSymbol), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Sech(Plus(d, Times(e, x))), Plus(n, Negate(C2))), Power(Times(Sqr(e), Plus(n, Negate(C1)), Plus(n, Negate(C2))), -1)), x), Dist(Times(Plus(Times(Sqr(e), Sqr(Plus(n, Negate(C2)))), Times(CN1, Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), Power(Times(Sqr(e), Plus(n, Negate(C1)), Plus(n, Negate(C2))), -1)), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Sech(Plus(d, Times(e, x))), Plus(n, Negate(C2)))), x), x), Simp(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Sech(Plus(d, Times(e, x))), Plus(n, Negate(C1))), Sinh(Plus(d, Times(e, x))), Power(Times(e, Plus(n, Negate(C1))), -1)), x)), And(FreeQ(List(FSymbol, a, b, c, d, e), x), NeQ(Plus(Times(Sqr(e), Sqr(Plus(n, Negate(C2)))), Times(CN1, Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), C0), GtQ(n, C1), NeQ(n, C2)))),
            IIntegrate(5491, Int(Times(Power(Csch(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, c, Log(FSymbol), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Csch(Plus(d, Times(e, x))), Plus(n, Negate(C2))), Power(Times(Sqr(e), Plus(n, Negate(C1)), Plus(n, Negate(C2))), -1)), x)), Negate(Dist(Times(Plus(Times(Sqr(e), Sqr(Plus(n, Negate(C2)))), Times(CN1, Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), Power(Times(Sqr(e), Plus(n, Negate(C1)), Plus(n, Negate(C2))), -1)), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Csch(Plus(d, Times(e, x))), Plus(n, Negate(C2)))), x), x)), Negate(Simp(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Csch(Plus(d, Times(e, x))), Plus(n, Negate(C1))), Cosh(Plus(d, Times(e, x))), Power(Times(e, Plus(n, Negate(C1))), -1)), x))), And(FreeQ(List(FSymbol, a, b, c, d, e), x), NeQ(Plus(Times(Sqr(e), Sqr(Plus(n, Negate(C2)))), Times(CN1, Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), C0), GtQ(n, C1), NeQ(n, C2)))),
            IIntegrate(5492, Int(Times(Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Sech(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), x_Symbol),
                    Condition(Simp(Times(Power(C2, n), Exp(Times(n, Plus(d, Times(e, x)))), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Hypergeometric2F1(n, Plus(Times(C1D2, n), Times(b, c, Log(FSymbol), Power(Times(C2, e), -1))), Plus(C1, Times(C1D2, n), Times(b, c, Log(FSymbol), Power(Times(C2, e), -1))), Negate(Exp(Times(C2, Plus(d, Times(e, x)))))), Power(Plus(Times(e, n), Times(b, c, Log(FSymbol))), -1)), x), And(FreeQ(List(FSymbol, a, b, c, d, e), x), IntegerQ(n)))),
            IIntegrate(5493, Int(Times(Power(Csch(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), x_Symbol),
                    Condition(Simp(Times(Power(CN2, n), Exp(Times(n, Plus(d, Times(e, x)))), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Hypergeometric2F1(n, Plus(Times(C1D2, n), Times(b, c, Log(FSymbol), Power(Times(C2, e), -1))), Plus(C1, Times(C1D2, n), Times(b, c, Log(FSymbol), Power(Times(C2, e), -1))), Exp(Times(C2, Plus(d, Times(e, x))))), Power(Plus(Times(e, n), Times(b, c, Log(FSymbol))), -1)), x), And(FreeQ(List(FSymbol, a, b, c, d, e), x), IntegerQ(n)))),
            IIntegrate(5494, Int(Times(Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Sech(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(C1, Exp(Times(C2, Plus(d, Times(e, x))))), n), Power(Sech(Plus(d, Times(e, x))), n), Power(Exp(Times(n, Plus(d, Times(e, x)))), -1)), Int(SimplifyIntegrand(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Exp(Times(n, Plus(d, Times(e, x)))), Power(Power(Plus(C1, Exp(Times(C2, Plus(d, Times(e, x))))), n), -1)), x), x), x), And(FreeQ(List(FSymbol, a, b, c, d, e), x), Not(IntegerQ(n))))),
            IIntegrate(5495, Int(Times(Power(Csch(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), x_Symbol),
                    Condition(Dist(Times(Power(Plus(C1, Negate(Exp(Times(CN2, Plus(d, Times(e, x)))))), n), Power(Csch(Plus(d, Times(e, x))), n), Power(Exp(Times(CN1, n, Plus(d, Times(e, x)))), -1)), Int(SimplifyIntegrand(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Times(Exp(Times(n, Plus(d, Times(e, x)))), Power(Plus(C1, Negate(Exp(Times(CN2, Plus(d, Times(e, x)))))), n)), -1)), x), x), x), And(FreeQ(List(FSymbol, a, b, c, d, e), x), Not(IntegerQ(n))))),
            IIntegrate(5496, Int(Times(Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Plus(f_, Times(g_DEFAULT, Sinh(Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(C2, n), Power(f, n)), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Cosh(Plus(Times(C1D2, d), Times(C1D2, e, x), Times(CN1, f, Pi, Power(Times(C4, g), -1)))), Times(C2, n))), x), x), And(FreeQ(List(FSymbol, a, b, c, d, e, f, g), x), EqQ(Plus(Sqr(f), Sqr(g)), C0), ILtQ(n, C0)))),
            IIntegrate(5497, Int(Times(Power(Plus(Times(Cosh(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), g_DEFAULT), f_), n_DEFAULT), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), x_Symbol),
                    Condition(Dist(Times(Power(C2, n), Power(g, n)), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Cosh(Plus(Times(C1D2, d), Times(C1D2, e, x))), Times(C2, n))), x), x), And(FreeQ(List(FSymbol, a, b, c, d, e, f, g), x), EqQ(Plus(f, Negate(g)), C0), ILtQ(n, C0)))),
            IIntegrate(5498, Int(Times(Power(Plus(Times(Cosh(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), g_DEFAULT), f_), n_DEFAULT), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), x_Symbol),
                    Condition(Dist(Times(Power(C2, n), Power(g, n)), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Sinh(Plus(Times(C1D2, d), Times(C1D2, e, x))), Times(C2, n))), x), x), And(FreeQ(List(FSymbol, a, b, c, d, e, f, g), x), EqQ(Plus(f, g), C0), ILtQ(n, C0)))),
            IIntegrate(5499, Int(Times(Power(Cosh(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Plus(f_, Times(g_DEFAULT, Sinh(Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(g, n), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Tanh(Plus(Times(C1D2, d), Times(C1D2, e, x), Times(CN1, f, Pi, Power(Times(C4, g), -1)))), m)), x), x), And(FreeQ(List(FSymbol, a, b, c, d, e, f, g), x), EqQ(Plus(Sqr(f), Sqr(g)), C0), IntegersQ(m, n), EqQ(Plus(m, n), C0)))),
            IIntegrate(5500, Int(Times(Power(Plus(Times(Cosh(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), g_DEFAULT), f_), n_DEFAULT), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Sinh(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(g, n), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Tanh(Plus(Times(C1D2, d), Times(C1D2, e, x))), m)), x), x), And(FreeQ(List(FSymbol, a, b, c, d, e, f, g), x), EqQ(Plus(f, Negate(g)), C0), IntegersQ(m, n), EqQ(Plus(m, n), C0))))
    );
}
