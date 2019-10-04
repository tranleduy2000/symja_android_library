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
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.QQ;
import static org.matheclipse.core.expression.F.Simplify;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_;
import static org.matheclipse.core.expression.F.c_DEFAULT;
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
import static org.matheclipse.core.expression.F.m_DEFAULT;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules114 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(2851, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(p, C1)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Power(Times(f, g, Plus(m, n, p)), CN1)), x)), Dist(Times(a, Subtract(Plus(Times(C2, m), p), C1), Power(Plus(m, n, p), CN1)), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), p), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, n, p), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), GtQ(m, C0), NeQ(Plus(m, n, p), C0), Not(LtQ(C0, n, m)), IntegersQ(Times(C2, m), Times(C2, n), Times(C2, p)))));
            IIntegrate(2852, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Plus(Simp(Times(b, Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(p, C1)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Power(Times(a, f, g, Plus(Times(C2, m), p, C1)), CN1)), x), Dist(Times(Plus(m, n, p, C1), Power(Times(a, Plus(Times(C2, m), p, C1)), CN1)), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), p), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, n, p), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), LtQ(m, CN1), NeQ(Plus(Times(C2, m), p, C1), C0), Not(LtQ(m, n, CN1)), IntegersQ(Times(C2, m), Times(C2, n), Times(C2, p)))));
            IIntegrate(2853, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Dist(Times(Power(a, IntPart(m)), Power(c, IntPart(m)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), FracPart(m)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), FracPart(m)), Power(Times(Power(g, Times(C2, IntPart(m))), Power(Times(g, Cos(Plus(e, Times(f, x)))), Times(C2, FracPart(m)))), CN1)), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(Times(C2, m), p)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Subtract(n, m))), x), x), And(FreeQ(List(a, b, c, d, e, f, g, m, n, p), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), Or(FractionQ(m), Not(FractionQ(n))))));
            IIntegrate(2854, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Negate(Simp(Times(d, Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(p, C1)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Times(f, g, Plus(m, p, C1)), CN1)), x)), And(FreeQ(List(a, b, c, d, e, f, g, m, p), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), EqQ(Plus(Times(a, d, m), Times(b, c, Plus(m, p, C1))), C0))));
            IIntegrate(2855, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Plus(Times(b, c), Times(a, d)), Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(p, C1)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Times(a, f, g, Plus(p, C1)), CN1)), x)), Dist(Times(b, Plus(Times(a, d, m), Times(b, c, Plus(m, p, C1))), Power(Times(a, Sqr(g), Plus(p, C1)), CN1)), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(p, C2)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), GtQ(m, CN1), LtQ(p, CN1))));
            IIntegrate(2856, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(d, Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(p, C1)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Times(f, g, Plus(m, p, C1)), CN1)), x)), Dist(Times(Plus(Times(a, d, m), Times(b, c, Plus(m, p, C1))), Power(Times(b, Plus(m, p, C1)), CN1)), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), p), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, m, p), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IGtQ(Simplify(Times(C1D2, Plus(Times(C2, m), p, C1))), C0), NeQ(Plus(m, p, C1), C0))));
            IIntegrate(2857, Int(Times(Sqr($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Simp(Times(C2, Subtract(Times(b, c), Times(a, d)), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(Sqr(b), f, Plus(Times(C2, m), C3)), CN1)), x), Dist(Power(Times(Power(b, C3), Plus(Times(C2, m), C3)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C2)), Subtract(Plus(Times(b, c), Times(C2, a, d, Plus(m, C1))), Times(b, d, Plus(Times(C2, m), C3), Sin(Plus(e, Times(f, x)))))), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), LtQ(m, QQ(-3L, 2L)))));
            IIntegrate(2858, Int(Times(Sqr($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Subtract(Simp(Times(d, Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C2)), Power(Times(Sqr(b), f, Plus(m, C3)), CN1)), x), Dist(Power(Times(Sqr(b), Plus(m, C3)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Plus(Times(b, d, Plus(m, C2)), Times(CN1, a, c, Plus(m, C3)), Times(Subtract(Times(b, c, Plus(m, C3)), Times(a, d, Plus(m, C4))), Sin(Plus(e, Times(f, x)))))), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), GeQ(m, QQ(-3L, 2L)), LtQ(m, C0))));
            IIntegrate(2859, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Simp(Times(Subtract(Times(b, c), Times(a, d)), Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(p, C1)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Times(a, f, g, Plus(Times(C2, m), p, C1)), CN1)), x), Dist(Times(Plus(Times(a, d, m), Times(b, c, Plus(m, p, C1))), Power(Times(a, b, Plus(Times(C2, m), p, C1)), CN1)), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), p), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, m, p), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), Or(LtQ(m, CN1), ILtQ(Simplify(Plus(m, p)), C0)), NeQ(Plus(Times(C2, m), p, C1), C0))));
            IIntegrate(2860, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(d, Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(p, C1)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Times(f, g, Plus(m, p, C1)), CN1)), x)), Dist(Times(Plus(Times(a, d, m), Times(b, c, Plus(m, p, C1))), Power(Times(b, Plus(m, p, C1)), CN1)), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), p), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, m, p), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Plus(m, p, C1), C0))));
            IIntegrate(2861, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(p, C1)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Plus(d, Times(c, Sin(Plus(e, Times(f, x))))), Power(Times(f, g, Plus(p, C1)), CN1)), x)), Dist(Power(Times(Sqr(g), Plus(p, C1)), CN1), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(p, C2)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, C1)), Simp(Plus(Times(a, c, Plus(p, C2)), Times(b, d, m), Times(b, c, Plus(m, p, C2), Sin(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), GtQ(m, C0), LtQ(p, CN1), IntegerQ(Times(C2, m)), Not(And(EqQ(m, C1), NeQ(Subtract(Sqr(c), Sqr(d)), C0), SimplerQ(Plus(c, Times(d, x)), Plus(a, Times(b, x))))))));
            IIntegrate(2862, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(d, Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(p, C1)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Times(f, g, Plus(m, p, C1)), CN1)), x)), Dist(Power(Plus(m, p, C1), CN1), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), p), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, C1)), Simp(Plus(Times(a, c, Plus(m, p, C1)), Times(b, d, m), Times(Plus(Times(a, d, m), Times(b, c, Plus(m, p, C1))), Sin(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, p), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), GtQ(m, C0), Not(LtQ(p, CN1)), IntegerQ(Times(C2, m)), Not(And(EqQ(m, C1), NeQ(Subtract(Sqr(c), Sqr(d)), C0), SimplerQ(Plus(c, Times(d, x)), Plus(a, Times(b, x))))))));
            IIntegrate(2863, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Simp(Times(g, Power(Times(g, Cos(Plus(e, Times(f, x)))), Subtract(p, C1)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Plus(Times(b, c, Plus(m, p, C1)), Times(CN1, a, d, p), Times(b, d, Plus(m, C1), Sin(Plus(e, Times(f, x))))), Power(Times(Sqr(b), f, Plus(m, C1), Plus(m, p, C1)), CN1)), x), Dist(Times(Sqr(g), Subtract(p, C1), Power(Times(Sqr(b), Plus(m, C1), Plus(m, p, C1)), CN1)), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), Subtract(p, C2)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Simp(Plus(Times(b, d, Plus(m, C1)), Times(Subtract(Times(b, c, Plus(m, p, C1)), Times(a, d, p)), Sin(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), LtQ(m, CN1), GtQ(p, C1), NeQ(Plus(m, p, C1), C0), IntegerQ(Times(C2, m)))));
            IIntegrate(2864, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Subtract(Times(b, c), Times(a, d)), Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(p, C1)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(f, g, Subtract(Sqr(a), Sqr(b)), Plus(m, C1)), CN1)), x)), Dist(Power(Times(Subtract(Sqr(a), Sqr(b)), Plus(m, C1)), CN1), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), p), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Simp(Subtract(Times(Subtract(Times(a, c), Times(b, d)), Plus(m, C1)), Times(Subtract(Times(b, c), Times(a, d)), Plus(m, p, C2), Sin(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, p), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), LtQ(m, CN1), IntegerQ(Times(C2, m)))));
            IIntegrate(2865, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Simp(Times(g, Power(Times(g, Cos(Plus(e, Times(f, x)))), Subtract(p, C1)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Plus(Times(b, c, Plus(m, p, C1)), Times(CN1, a, d, p), Times(b, d, Plus(m, p), Sin(Plus(e, Times(f, x))))), Power(Times(Sqr(b), f, Plus(m, p), Plus(m, p, C1)), CN1)), x), Dist(Times(Sqr(g), Subtract(p, C1), Power(Times(Sqr(b), Plus(m, p), Plus(m, p, C1)), CN1)), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), Subtract(p, C2)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Simp(Plus(Times(b, Plus(Times(a, d, m), Times(b, c, Plus(m, p, C1)))), Times(Subtract(Times(a, b, c, Plus(m, p, C1)), Times(d, Subtract(Times(Sqr(a), p), Times(Sqr(b), Plus(m, p))))), Sin(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, m), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), GtQ(p, C1), NeQ(Plus(m, p), C0), NeQ(Plus(m, p, C1), C0), IntegerQ(Times(C2, m)))));
            IIntegrate(2866, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(p, C1)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Subtract(Subtract(Times(b, c), Times(a, d)), Times(Subtract(Times(a, c), Times(b, d)), Sin(Plus(e, Times(f, x))))), Power(Times(f, g, Subtract(Sqr(a), Sqr(b)), Plus(p, C1)), CN1)), x), Dist(Power(Times(Sqr(g), Subtract(Sqr(a), Sqr(b)), Plus(p, C1)), CN1), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(p, C2)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Simp(Plus(Times(c, Subtract(Times(Sqr(a), Plus(p, C2)), Times(Sqr(b), Plus(m, p, C2)))), Times(a, b, d, m), Times(b, Subtract(Times(a, c), Times(b, d)), Plus(m, p, C3), Sin(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, m), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), LtQ(p, CN1), IntegerQ(Times(C2, m)))));
            IIntegrate(2867, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1), Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Dist(Times(d, Power(b, CN1)), Int(Power(Times(g, Cos(Plus(e, Times(f, x)))), p), x), x), Dist(Times(Subtract(Times(b, c), Times(a, d)), Power(b, CN1)), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), p), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(2868, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Dist(Times(c, g, Power(Times(g, Cos(Plus(e, Times(f, x)))), Subtract(p, C1)), Power(Times(f, Power(Plus(C1, Sin(Plus(e, Times(f, x)))), Times(C1D2, Subtract(p, C1))), Power(Subtract(C1, Sin(Plus(e, Times(f, x)))), Times(C1D2, Subtract(p, C1)))), CN1)), Subst(Int(Times(Power(Plus(C1, Times(d, x, Power(c, CN1))), Times(C1D2, Plus(p, C1))), Power(Subtract(C1, Times(d, x, Power(c, CN1))), Times(C1D2, Subtract(p, C1))), Power(Plus(a, Times(b, x)), m)), x), x, Sin(Plus(e, Times(f, x)))), x), And(FreeQ(List(a, b, c, d, e, f, m, p), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), EqQ(Subtract(Sqr(c), Sqr(d)), C0))));
            IIntegrate(2869, Int(Times(Power($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), p_), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Dist(Power(a, Times(C2, m)), Int(Times(Power(Times(d, Sin(Plus(e, Times(f, x)))), n), Power(Power(Subtract(a, Times(b, Sin(Plus(e, Times(f, x))))), m), CN1)), x), x), And(FreeQ(List(a, b, d, e, f, n), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegersQ(m, p), EqQ(Plus(Times(C2, m), p), C0))));
            IIntegrate(2870, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(p, C1)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(C2, b, f, g, Plus(m, C1)), CN1)), x)), Dist(Times(a, Power(Times(C2, Sqr(g)), CN1)), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(p, C2)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, C1))), x), x)), And(FreeQ(List(a, b, e, f, g, m, p), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), EqQ(Subtract(m, p), C0))));
            IIntegrate(2871, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Subtract(Simp(Times(b, Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(p, C1)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Times(a, f, g, m), CN1)), x), Dist(Power(g, CN2), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(p, C2)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m)), x), x)), And(FreeQ(List(a, b, e, f, g, m, p), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), EqQ(Plus(m, p, C1), C0))));
            IIntegrate(2872, Int(Times(Power($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), p_), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Dist(Power(Power(a, p), CN1), Int(ExpandTrig(Times(Power(Times(d, $($s("§sin"), Plus(e, Times(f, x)))), n), Power(Subtract(a, Times(b, $($s("§sin"), Plus(e, Times(f, x))))), Times(C1D2, p)), Power(Plus(a, Times(b, $($s("§sin"), Plus(e, Times(f, x))))), Plus(m, Times(C1D2, p)))), x), x), x), And(FreeQ(List(a, b, d, e, f), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegersQ(m, n, Times(C1D2, p)), Or(And(GtQ(m, C0), GtQ(p, C0), LtQ(Subtract(Negate(m), p), n, CN1)), And(GtQ(m, C2), LtQ(p, C0), GtQ(Plus(m, Times(C1D2, p)), C0))))));
            IIntegrate(2873, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Int(ExpandTrig(Power(Times(g, $($s("§cos"), Plus(e, Times(f, x)))), p), Times(Power(Times(d, $($s("§sin"), Plus(e, Times(f, x)))), n), Power(Plus(a, Times(b, $($s("§sin"), Plus(e, Times(f, x))))), m)), x), x), And(FreeQ(List(a, b, d, e, f, g, n, p), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IGtQ(m, C0))));
            IIntegrate(2874, Int(Times(Sqr($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Dist(Power(b, CN2), Int(Times(Power(Times(d, Sin(Plus(e, Times(f, x)))), n), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Subtract(a, Times(b, Sin(Plus(e, Times(f, x)))))), x), x), And(FreeQ(List(a, b, d, e, f, m, n), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), Or(ILtQ(m, C0), Not(IGtQ(n, C0))))));
            IIntegrate(2875, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Dist(Power(Times(a, Power(g, CN1)), Times(C2, m)), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), Plus(Times(C2, m), p)), Power(Times(d, Sin(Plus(e, Times(f, x)))), n), Power(Power(Subtract(a, Times(b, Sin(Plus(e, Times(f, x))))), m), CN1)), x), x), And(FreeQ(List(a, b, d, e, f, g, n, p), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), ILtQ(m, C0))));
        }
    }
}
