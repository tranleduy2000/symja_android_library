package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.C5;
import static org.matheclipse.core.expression.F.C6;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.CN4;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.Less;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.QQ;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.ZZ;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.g_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandTrig;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules115 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(2876, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Dist(Power(Times(a, Power(g, CN1)), Times(C2, m)), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(Times(C2, m), p)), Power(Times(d, Sin(Plus(e, Times(f, x)))), n), Power(Power(Subtract(a, Times(b, Sin(Plus(e, Times(f, x))))), m), CN1)), x), x), And(FreeQ(List(a, b, d, e, f, g, n), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegerQ(m), RationalQ(p), Or(EqQ(Plus(Times(C2, m), p), C0), And(GtQ(Plus(Times(C2, m), p), C0), LtQ(p, CN1))))));
            IIntegrate(2877, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Subtract(Simp(Times(b, Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(p, C1)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Times(a, f, g, Plus(Times(C2, m), p, C1)), CN1)), x), Dist(Power(Times(Sqr(a), Plus(Times(C2, m), p, C1)), CN1), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), p), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Subtract(Times(a, m), Times(b, Plus(Times(C2, m), p, C1), Sin(Plus(e, Times(f, x)))))), x), x)), And(FreeQ(List(a, b, e, f, g, p), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), LeQ(m, Negate(C1D2)), NeQ(Plus(Times(C2, m), p, C1), C0))));
            IIntegrate(2878, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(p, C1)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(b, f, g, Plus(m, p, C2)), CN1)), x)), Dist(Power(Times(b, Plus(m, p, C2)), CN1), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), p), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Subtract(Times(b, Plus(m, C1)), Times(a, Plus(p, C1), Sin(Plus(e, Times(f, x)))))), x), x)), And(FreeQ(List(a, b, e, f, g, m, p), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Plus(m, p, C2), C0))));
            IIntegrate(2879, Int(Times(Sqr($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Dist(Power(b, CN2), Int(Times(Power(Times(d, Sin(Plus(e, Times(f, x)))), n), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Subtract(a, Times(b, Sin(Plus(e, Times(f, x)))))), x), x), And(FreeQ(List(a, b, d, e, f, m, n), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegersQ(Times(C2, m), Times(C2, n)))));
            IIntegrate(2880, Int(Times(Power($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), C4), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Plus(Dist(Times(CN2, Power(Times(a, b, d), CN1)), Int(Times(Power(Times(d, Sin(Plus(e, Times(f, x)))), Plus(n, C1)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C2))), x), x), Dist(Power(a, CN2), Int(Times(Power(Times(d, Sin(Plus(e, Times(f, x)))), n), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C2)), Plus(C1, Sqr(Sin(Plus(e, Times(f, x)))))), x), x)), And(FreeQ(List(a, b, d, e, f, n), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), LtQ(m, CN1))));
            IIntegrate(2881, Int(Times(Power($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), C4), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Plus(Dist(Power(d, CN4), Int(Times(Power(Times(d, Sin(Plus(e, Times(f, x)))), Plus(n, C4)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m)), x), x), Int(Times(Power(Times(d, Sin(Plus(e, Times(f, x)))), n), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Subtract(C1, Times(C2, Sqr(Sin(Plus(e, Times(f, x))))))), x)), And(FreeQ(List(a, b, d, e, f, m, n), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), Not(IGtQ(m, C0)))));
            IIntegrate(2882, Int(Times(Power($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), p_), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Dist(Times(Power(a, m), Cos(Plus(e, Times(f, x))), Power(Times(f, Sqrt(Plus(C1, Sin(Plus(e, Times(f, x))))), Sqrt(Subtract(C1, Sin(Plus(e, Times(f, x)))))), CN1)), Subst(Int(Times(Power(Times(d, x), n), Power(Plus(C1, Times(b, x, Power(a, CN1))), Plus(m, Times(C1D2, Subtract(p, C1)))), Power(Subtract(C1, Times(b, x, Power(a, CN1))), Times(C1D2, Subtract(p, C1)))), x), x, Sin(Plus(e, Times(f, x)))), x), And(FreeQ(List(a, b, d, e, f, n), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegerQ(Times(C1D2, p)), IntegerQ(m))));
            IIntegrate(2883, Int(Times(Power($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), p_), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Dist(Times(Cos(Plus(e, Times(f, x))), Power(Times(Power(a, Subtract(p, C2)), f, Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Sqrt(Subtract(a, Times(b, Sin(Plus(e, Times(f, x))))))), CN1)), Subst(Int(Times(Power(Times(d, x), n), Power(Plus(a, Times(b, x)), Subtract(Plus(m, Times(C1D2, p)), C1D2)), Power(Subtract(a, Times(b, x)), Subtract(Times(C1D2, p), C1D2))), x), x, Sin(Plus(e, Times(f, x)))), x), And(FreeQ(List(a, b, d, e, f, m, n), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegerQ(Times(C1D2, p)), Not(IntegerQ(m)))));
            IIntegrate(2884, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Int(ExpandTrig(Power(Times(g, $($s("§cos"), Plus(e, Times(f, x)))), p), Times(Power(Times(d, $($s("§sin"), Plus(e, Times(f, x)))), n), Power(Plus(a, Times(b, $($s("§sin"), Plus(e, Times(f, x))))), m)), x), x), And(FreeQ(List(a, b, d, e, f, g, n, p), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IGtQ(m, C0), Or(IntegerQ(p), IGtQ(n, C0)))));
            IIntegrate(2885, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Dist(Times(Power(a, m), g, Power(Times(g, Cos(Plus(e, Times(f, x)))), Subtract(p, C1)), Power(Times(f, Power(Plus(C1, Sin(Plus(e, Times(f, x)))), Times(C1D2, Subtract(p, C1))), Power(Subtract(C1, Sin(Plus(e, Times(f, x)))), Times(C1D2, Subtract(p, C1)))), CN1)), Subst(Int(Times(Power(Times(d, x), n), Power(Plus(C1, Times(b, x, Power(a, CN1))), Plus(m, Times(C1D2, Subtract(p, C1)))), Power(Subtract(C1, Times(b, x, Power(a, CN1))), Times(C1D2, Subtract(p, C1)))), x), x, Sin(Plus(e, Times(f, x)))), x), And(FreeQ(List(a, b, d, e, f, n, p), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegerQ(m))));
            IIntegrate(2886, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Dist(Times(g, Power(Times(g, Cos(Plus(e, Times(f, x)))), Subtract(p, C1)), Power(Times(f, Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Times(C1D2, Subtract(p, C1))), Power(Subtract(a, Times(b, Sin(Plus(e, Times(f, x))))), Times(C1D2, Subtract(p, C1)))), CN1)), Subst(Int(Times(Power(Times(d, x), n), Power(Plus(a, Times(b, x)), Plus(m, Times(C1D2, Subtract(p, C1)))), Power(Subtract(a, Times(b, x)), Times(C1D2, Subtract(p, C1)))), x), x, Sin(Plus(e, Times(f, x)))), x), And(FreeQ(List(a, b, d, e, f, m, n, p), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), Not(IntegerQ(m)))));
            IIntegrate(2887, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), CN1D2), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(g, Power(Times(g, Cos(Plus(e, Times(f, x)))), Subtract(p, C1)), Sqrt(Times(d, Sin(Plus(e, Times(f, x))))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(a, d, f, Plus(m, C1)), CN1)), x)), Dist(Times(Sqr(g), Plus(Times(C2, m), C3), Power(Times(C2, a, Plus(m, C1)), CN1)), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), Subtract(p, C2)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(d, Sin(Plus(e, Times(f, x)))), CN1D2)), x), x)), And(FreeQ(List(a, b, d, e, f, g), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), LtQ(m, CN1), EqQ(Plus(m, p, C1D2), C0))));
            IIntegrate(2888, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), CN1D2), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Plus(Simp(Times(C2, Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(p, C1)), Sqrt(Times(d, Sin(Plus(e, Times(f, x))))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Times(d, f, g, Plus(Times(C2, m), C1)), CN1)), x), Dist(Times(C2, a, m, Power(Times(Sqr(g), Plus(Times(C2, m), C1)), CN1)), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(p, C2)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Times(d, Sin(Plus(e, Times(f, x)))), CN1D2)), x), x)), And(FreeQ(List(a, b, e, f, g), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), GtQ(m, C0), EqQ(Plus(m, p, QQ(3L, 2L)), C0))));
            IIntegrate(2889, Int(Times(Sqr($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Int(Times(Power(Times(d, Sin(Plus(e, Times(f, x)))), n), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Subtract(C1, Sqr(Sin(Plus(e, Times(f, x)))))), x), And(FreeQ(List(a, b, d, e, f, m, n), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), Or(IGtQ(m, C0), IntegersQ(Times(C2, m), Times(C2, n))))));
            IIntegrate(2890, Int(Times(Power($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), C4), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Plus(Simp(Times(Cos(Plus(e, Times(f, x))), Power(Times(d, Sin(Plus(e, Times(f, x)))), Plus(n, C1)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(a, d, f, Plus(n, C1)), CN1)), x), Dist(Power(Times(Sqr(a), b, d, Plus(n, C1), Plus(m, C1)), CN1), Int(Times(Power(Times(d, Sin(Plus(e, Times(f, x)))), Plus(n, C1)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Simp(Subtract(Plus(Times(Sqr(a), Plus(n, C1), Plus(n, C2)), Times(CN1, Sqr(b), Plus(m, n, C2), Plus(m, n, C3)), Times(a, b, Plus(m, C1), Sin(Plus(e, Times(f, x))))), Times(Subtract(Times(Sqr(a), Plus(n, C1), Plus(n, C3)), Times(Sqr(b), Plus(m, n, C2), Plus(m, n, C4))), Sqr(Sin(Plus(e, Times(f, x)))))), x)), x), x), Negate(Simp(Times(Subtract(Times(Sqr(a), Plus(n, C1)), Times(Sqr(b), Plus(m, n, C2))), Cos(Plus(e, Times(f, x))), Power(Times(d, Sin(Plus(e, Times(f, x)))), Plus(n, C2)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(Sqr(a), b, Sqr(d), f, Plus(n, C1), Plus(m, C1)), CN1)), x))), And(FreeQ(List(a, b, d, e, f), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), IntegersQ(Times(C2, m), Times(C2, n)), LtQ(m, CN1), LtQ(n, CN1))));
            IIntegrate(2891, Int(Times(Power($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), C4), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Plus(Simp(Times(Subtract(Sqr(a), Sqr(b)), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(d, Sin(Plus(e, Times(f, x)))), Plus(n, C1)), Power(Times(a, Sqr(b), d, f, Plus(m, C1)), CN1)), x), Negate(Dist(Power(Times(Sqr(a), Sqr(b), Plus(m, C1), Plus(m, C2)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C2)), Power(Times(d, Sin(Plus(e, Times(f, x)))), n), Simp(Subtract(Plus(Times(Sqr(a), Plus(n, C1), Plus(n, C3)), Times(CN1, Sqr(b), Plus(m, n, C2), Plus(m, n, C3)), Times(a, b, Plus(m, C2), Sin(Plus(e, Times(f, x))))), Times(Subtract(Times(Sqr(a), Plus(n, C2), Plus(n, C3)), Times(Sqr(b), Plus(m, n, C2), Plus(m, n, C4))), Sqr(Sin(Plus(e, Times(f, x)))))), x)), x), x)), Simp(Times(Subtract(Times(Sqr(a), Plus(n, Negate(m), C1)), Times(Sqr(b), Plus(m, n, C2))), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C2)), Power(Times(d, Sin(Plus(e, Times(f, x)))), Plus(n, C1)), Power(Times(Sqr(a), Sqr(b), d, f, Plus(m, C1), Plus(m, C2)), CN1)), x)), And(FreeQ(List(a, b, d, e, f, n), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), IntegersQ(Times(C2, m), Times(C2, n)), LtQ(m, CN1), Not(LtQ(n, CN1)), Or(LtQ(m, CN2), EqQ(Plus(m, n, C4), C0)))));
            IIntegrate(2892, Int(Times(Power($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), C4), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Plus(Simp(Times(Subtract(Sqr(a), Sqr(b)), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(d, Sin(Plus(e, Times(f, x)))), Plus(n, C1)), Power(Times(a, Sqr(b), d, f, Plus(m, C1)), CN1)), x), Negate(Dist(Power(Times(a, Sqr(b), Plus(m, C1), Plus(m, n, C4)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(d, Sin(Plus(e, Times(f, x)))), n), Simp(Subtract(Plus(Times(Sqr(a), Plus(n, C1), Plus(n, C3)), Times(CN1, Sqr(b), Plus(m, n, C2), Plus(m, n, C4)), Times(a, b, Plus(m, C1), Sin(Plus(e, Times(f, x))))), Times(Subtract(Times(Sqr(a), Plus(n, C2), Plus(n, C3)), Times(Sqr(b), Plus(m, n, C3), Plus(m, n, C4))), Sqr(Sin(Plus(e, Times(f, x)))))), x)), x), x)), Negate(Simp(Times(Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C2)), Power(Times(d, Sin(Plus(e, Times(f, x)))), Plus(n, C1)), Power(Times(Sqr(b), d, f, Plus(m, n, C4)), CN1)), x))), And(FreeQ(List(a, b, d, e, f, n), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), IntegersQ(Times(C2, m), Times(C2, n)), LtQ(m, CN1), Not(LtQ(n, CN1)), NeQ(Plus(m, n, C4), C0))));
            IIntegrate(2893, Int(Times(Power($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), C4), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Plus(Simp(Times(Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(d, Sin(Plus(e, Times(f, x)))), Plus(n, C1)), Power(Times(a, d, f, Plus(n, C1)), CN1)), x), Negate(Dist(Power(Times(Sqr(a), Sqr(d), Plus(n, C1), Plus(n, C2)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Times(d, Sin(Plus(e, Times(f, x)))), Plus(n, C2)), Simp(Subtract(Plus(Times(Sqr(a), n, Plus(n, C2)), Times(CN1, Sqr(b), Plus(m, n, C2), Plus(m, n, C3)), Times(a, b, m, Sin(Plus(e, Times(f, x))))), Times(Subtract(Times(Sqr(a), Plus(n, C1), Plus(n, C2)), Times(Sqr(b), Plus(m, n, C2), Plus(m, n, C4))), Sqr(Sin(Plus(e, Times(f, x)))))), x)), x), x)), Negate(Simp(Times(b, Plus(m, n, C2), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(d, Sin(Plus(e, Times(f, x)))), Plus(n, C2)), Power(Times(Sqr(a), Sqr(d), f, Plus(n, C1), Plus(n, C2)), CN1)), x))), And(FreeQ(List(a, b, d, e, f, m), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), Or(IGtQ(m, C0), IntegersQ(Times(C2, m), Times(C2, n))), Not(Less(m, CN1)), LtQ(n, CN1), Or(LtQ(n, CN2), EqQ(Plus(m, n, C4), C0)))));
            IIntegrate(2894, Int(Times(Power($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), C4), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Plus(Simp(Times(Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(d, Sin(Plus(e, Times(f, x)))), Plus(n, C1)), Power(Times(a, d, f, Plus(n, C1)), CN1)), x), Dist(Power(Times(a, b, d, Plus(n, C1), Plus(m, n, C4)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Times(d, Sin(Plus(e, Times(f, x)))), Plus(n, C1)), Simp(Subtract(Plus(Times(Sqr(a), Plus(n, C1), Plus(n, C2)), Times(CN1, Sqr(b), Plus(m, n, C2), Plus(m, n, C4)), Times(a, b, Plus(m, C3), Sin(Plus(e, Times(f, x))))), Times(Subtract(Times(Sqr(a), Plus(n, C1), Plus(n, C3)), Times(Sqr(b), Plus(m, n, C3), Plus(m, n, C4))), Sqr(Sin(Plus(e, Times(f, x)))))), x)), x), x), Negate(Simp(Times(Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(d, Sin(Plus(e, Times(f, x)))), Plus(n, C2)), Power(Times(b, Sqr(d), f, Plus(m, n, C4)), CN1)), x))), And(FreeQ(List(a, b, d, e, f, m), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), Or(IGtQ(m, C0), IntegersQ(Times(C2, m), Times(C2, n))), Not(Less(m, CN1)), LtQ(n, CN1), NeQ(Plus(m, n, C4), C0))));
            IIntegrate(2895, Int(Times(Power($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), C4), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Plus(Simp(Times(a, Plus(n, C3), Cos(Plus(e, Times(f, x))), Power(Times(d, Sin(Plus(e, Times(f, x)))), Plus(n, C1)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(Sqr(b), d, f, Plus(m, n, C3), Plus(m, n, C4)), CN1)), x), Negate(Dist(Power(Times(Sqr(b), Plus(m, n, C3), Plus(m, n, C4)), CN1), Int(Times(Power(Times(d, Sin(Plus(e, Times(f, x)))), n), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Simp(Subtract(Plus(Times(Sqr(a), Plus(n, C1), Plus(n, C3)), Times(CN1, Sqr(b), Plus(m, n, C3), Plus(m, n, C4)), Times(a, b, m, Sin(Plus(e, Times(f, x))))), Times(Subtract(Times(Sqr(a), Plus(n, C2), Plus(n, C3)), Times(Sqr(b), Plus(m, n, C3), Plus(m, n, C5))), Sqr(Sin(Plus(e, Times(f, x)))))), x)), x), x)), Negate(Simp(Times(Cos(Plus(e, Times(f, x))), Power(Times(d, Sin(Plus(e, Times(f, x)))), Plus(n, C2)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(b, Sqr(d), f, Plus(m, n, C4)), CN1)), x))), And(FreeQ(List(a, b, d, e, f, m, n), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), Or(IGtQ(m, C0), IntegersQ(Times(C2, m), Times(C2, n))), Not(Less(m, CN1)), Not(LtQ(n, CN1)), NeQ(Plus(m, n, C3), C0), NeQ(Plus(m, n, C4), C0))));
            IIntegrate(2896, Int(Times(Power($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), C6), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Plus(Simp(Times(Cos(Plus(e, Times(f, x))), Power(Times(d, Sin(Plus(e, Times(f, x)))), Plus(n, C1)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(a, d, f, Plus(n, C1)), CN1)), x), Dist(Power(Times(Sqr(a), Sqr(b), Sqr(d), Plus(n, C1), Plus(n, C2), Plus(m, n, C5), Plus(m, n, C6)), CN1), Int(Times(Power(Times(d, Sin(Plus(e, Times(f, x)))), Plus(n, C2)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Simp(Subtract(Plus(Times(Power(a, C4), Plus(n, C1), Plus(n, C2), Plus(n, C3), Plus(n, C5)), Times(CN1, Sqr(a), Sqr(b), Plus(n, C2), Plus(Times(C2, n), C1), Plus(m, n, C5), Plus(m, n, C6)), Times(Power(b, C4), Plus(m, n, C2), Plus(m, n, C3), Plus(m, n, C5), Plus(m, n, C6)), Times(a, b, m, Subtract(Times(Sqr(a), Plus(n, C1), Plus(n, C2)), Times(Sqr(b), Plus(m, n, C5), Plus(m, n, C6))), Sin(Plus(e, Times(f, x))))), Times(Subtract(Plus(Times(Power(a, C4), Plus(n, C1), Plus(n, C2), Plus(C4, n), Plus(n, C5)), Times(Power(b, C4), Plus(m, n, C2), Plus(m, n, C4), Plus(m, n, C5), Plus(m, n, C6))), Times(Sqr(a), Sqr(b), Plus(n, C1), Plus(n, C2), Plus(m, n, C5), Plus(Times(C2, n), Times(C2, m), ZZ(13L)))), Sqr(Sin(Plus(e, Times(f, x)))))), x)), x), x), Negate(Simp(Times(b, Plus(m, n, C2), Cos(Plus(e, Times(f, x))), Power(Times(d, Sin(Plus(e, Times(f, x)))), Plus(n, C2)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(Sqr(a), Sqr(d), f, Plus(n, C1), Plus(n, C2)), CN1)), x)), Negate(Simp(Times(a, Plus(n, C5), Cos(Plus(e, Times(f, x))), Power(Times(d, Sin(Plus(e, Times(f, x)))), Plus(n, C3)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(Sqr(b), Power(d, C3), f, Plus(m, n, C5), Plus(m, n, C6)), CN1)), x)), Simp(Times(Cos(Plus(e, Times(f, x))), Power(Times(d, Sin(Plus(e, Times(f, x)))), Plus(n, C4)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(b, Power(d, C4), f, Plus(m, n, C6)), CN1)), x)), And(FreeQ(List(a, b, d, e, f, m, n), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), IntegersQ(Times(C2, m), Times(C2, n)), NeQ(n, CN1), NeQ(n, CN2), NeQ(Plus(m, n, C5), C0), NeQ(Plus(m, n, C6), C0), Not(IGtQ(m, C0)))));
            IIntegrate(2897, Int(Times(Power($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), p_), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Int(ExpandTrig(Times(Power(Times(d, $($s("§sin"), Plus(e, Times(f, x)))), n), Power(Plus(a, Times(b, $($s("§sin"), Plus(e, Times(f, x))))), m), Power(Subtract(C1, Sqr($($s("§sin"), Plus(e, Times(f, x))))), Times(C1D2, p))), x), x), And(FreeQ(List(a, b, d, e, f), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), IntegersQ(m, Times(C2, n), Times(C1D2, p)), Or(LtQ(m, CN1), And(EqQ(m, CN1), GtQ(p, C0))))));
            IIntegrate(2898, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), n_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Int(ExpandTrig(Power(Times(g, $($s("§cos"), Plus(e, Times(f, x)))), p), Times(Power($($s("§sin"), Plus(e, Times(f, x))), n), Power(Plus(a, Times(b, $($s("§sin"), Plus(e, Times(f, x))))), CN1)), x), x), And(FreeQ(List(a, b, e, f, g, p), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), IntegerQ(n), Or(LtQ(n, C0), IGtQ(Plus(p, C1D2), C0)))));
            IIntegrate(2899, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Plus(Dist(Times(Sqr(g), Power(a, CN1)), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), Subtract(p, C2)), Power(Times(d, Sin(Plus(e, Times(f, x)))), n)), x), x), Negate(Dist(Times(b, Sqr(g), Power(Times(Sqr(a), d), CN1)), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), Subtract(p, C2)), Power(Times(d, Sin(Plus(e, Times(f, x)))), Plus(n, C1))), x), x)), Negate(Dist(Times(Sqr(g), Subtract(Sqr(a), Sqr(b)), Power(Times(Sqr(a), Sqr(d)), CN1)), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), Subtract(p, C2)), Power(Times(d, Sin(Plus(e, Times(f, x)))), Plus(n, C2)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), CN1)), x), x))), And(FreeQ(List(a, b, d, e, f, g), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), IntegersQ(Times(C2, n), Times(C2, p)), GtQ(p, C1), Or(LeQ(n, CN2), And(EqQ(n, QQ(-3L, 2L)), EqQ(p, QQ(3L, 2L)))))));
            IIntegrate(2900, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Plus(Dist(Times(Sqr(g), Power(Times(a, b), CN1)), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), Subtract(p, C2)), Power(Times(d, Sin(Plus(e, Times(f, x)))), n), Subtract(b, Times(a, Sin(Plus(e, Times(f, x)))))), x), x), Dist(Times(Sqr(g), Subtract(Sqr(a), Sqr(b)), Power(Times(a, b, d), CN1)), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), Subtract(p, C2)), Power(Times(d, Sin(Plus(e, Times(f, x)))), Plus(n, C1)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), CN1)), x), x)), And(FreeQ(List(a, b, d, e, f, g), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), IntegersQ(Times(C2, n), Times(C2, p)), GtQ(p, C1), Or(LtQ(n, CN1), And(EqQ(p, QQ(3L, 2L)), EqQ(n, Negate(C1D2)))))));
        }
    }
}
