package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Simplify;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.a_DEFAULT;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_;
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
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules33 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(826, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), CN1D2), Plus(f_DEFAULT, Times(g_DEFAULT, x_)), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Dist(C2, Subst(Int(Times(Plus(Times(e, f), Times(CN1, d, g), Times(g, Sqr(x))), Power(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e)), Times(CN1, Subtract(Times(C2, c, d), Times(b, e)), Sqr(x)), Times(c, Power(x, C4))), CN1)), x), x, Sqrt(Plus(d, Times(e, x)))), x), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0))));
            IIntegrate(827, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), CN1D2), Plus(f_DEFAULT, Times(g_DEFAULT, x_)), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Dist(C2, Subst(Int(Times(Plus(Times(e, f), Times(CN1, d, g), Times(g, Sqr(x))), Power(Plus(Times(c, Sqr(d)), Times(a, Sqr(e)), Times(CN1, C2, c, d, Sqr(x)), Times(c, Power(x, C4))), CN1)), x), x, Sqrt(Plus(d, Times(e, x)))), x), And(FreeQ(List(a, c, d, e, f, g), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0))));
            IIntegrate(828, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Plus(f_DEFAULT, Times(g_DEFAULT, x_)), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Plus(Simp(Times(Subtract(Times(e, f), Times(d, g)), Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Times(Plus(m, C1), Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e)))), CN1)), x), Dist(Power(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), CN1), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Simp(Subtract(Plus(Times(c, d, f), Times(CN1, f, b, e), Times(a, e, g)), Times(c, Subtract(Times(e, f), Times(d, g)), x)), x), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, m), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), FractionQ(m), LtQ(m, CN1))));
            IIntegrate(829, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Plus(f_DEFAULT, Times(g_DEFAULT, x_)), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Plus(Simp(Times(Subtract(Times(e, f), Times(d, g)), Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Times(Plus(m, C1), Plus(Times(c, Sqr(d)), Times(a, Sqr(e)))), CN1)), x), Dist(Power(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Simp(Subtract(Plus(Times(c, d, f), Times(a, e, g)), Times(c, Subtract(Times(e, f), Times(d, g)), x)), x), Power(Plus(a, Times(c, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, c, d, e, f, g, m), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), FractionQ(m), LtQ(m, CN1))));
            IIntegrate(830, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Plus(f_DEFAULT, Times(g_DEFAULT, x_)), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(d, Times(e, x)), m), Times(Plus(f, Times(g, x)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), Not(RationalQ(m)))));
            IIntegrate(831, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Plus(f_DEFAULT, Times(g_DEFAULT, x_)), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(d, Times(e, x)), m), Times(Plus(f, Times(g, x)), Power(Plus(a, Times(c, Sqr(x))), CN1)), x), x), And(FreeQ(List(a, c, d, e, f, g), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(RationalQ(m)))));
            IIntegrate(832, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Plus(f_DEFAULT, Times(g_DEFAULT, x_)), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(g, Power(Plus(d, Times(e, x)), m), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Times(c, Plus(m, Times(C2, p), C2)), CN1)), x), Dist(Power(Times(c, Plus(m, Times(C2, p), C2)), CN1), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p), Simp(Plus(Times(m, Subtract(Times(c, d, f), Times(a, e, g))), Times(d, Subtract(Times(C2, c, f), Times(b, g)), Plus(p, C1)), Times(Plus(Times(m, Subtract(Plus(Times(c, e, f), Times(c, d, g)), Times(b, e, g))), Times(e, Plus(p, C1), Subtract(Times(C2, c, f), Times(b, g)))), x)), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, p), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), GtQ(m, C0), NeQ(Plus(m, Times(C2, p), C2), C0), Or(IntegerQ(m), IntegerQ(p), IntegersQ(Times(C2, m), Times(C2, p))), Not(And(IGtQ(m, C0), EqQ(f, C0))))));
            IIntegrate(833, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Plus(f_DEFAULT, Times(g_DEFAULT, x_)), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(g, Power(Plus(d, Times(e, x)), m), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1)), Power(Times(c, Plus(m, Times(C2, p), C2)), CN1)), x), Dist(Power(Times(c, Plus(m, Times(C2, p), C2)), CN1), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(a, Times(c, Sqr(x))), p), Simp(Plus(Times(c, d, f, Plus(m, Times(C2, p), C2)), Times(CN1, a, e, g, m), Times(c, Plus(Times(e, f, Plus(m, Times(C2, p), C2)), Times(d, g, m)), x)), x)), x), x)), And(FreeQ(List(a, c, d, e, f, g, p), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), GtQ(m, C0), NeQ(Plus(m, Times(C2, p), C2), C0), Or(IntegerQ(m), IntegerQ(p), IntegersQ(Times(C2, m), Times(C2, p))), Not(And(IGtQ(m, C0), EqQ(f, C0))))));
            IIntegrate(834, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Plus(f_DEFAULT, Times(g_DEFAULT, x_)), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Subtract(Times(e, f), Times(d, g)), Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Times(Plus(m, C1), Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e)))), CN1)), x), Dist(Power(Times(Plus(m, C1), Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e)))), CN1), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p), Simp(Subtract(Plus(Times(Plus(Times(c, d, f), Times(CN1, f, b, e), Times(a, e, g)), Plus(m, C1)), Times(b, Subtract(Times(d, g), Times(e, f)), Plus(p, C1))), Times(c, Subtract(Times(e, f), Times(d, g)), Plus(m, Times(C2, p), C3), x)), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, p), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), LtQ(m, CN1), Or(IntegerQ(m), IntegerQ(p), IntegersQ(Times(C2, m), Times(C2, p))))));
            IIntegrate(835, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Plus(f_DEFAULT, Times(g_DEFAULT, x_)), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Subtract(Times(e, f), Times(d, g)), Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1)), Power(Times(Plus(m, C1), Plus(Times(c, Sqr(d)), Times(a, Sqr(e)))), CN1)), x), Dist(Power(Times(Plus(m, C1), Plus(Times(c, Sqr(d)), Times(a, Sqr(e)))), CN1), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(c, Sqr(x))), p), Simp(Subtract(Times(Plus(Times(c, d, f), Times(a, e, g)), Plus(m, C1)), Times(c, Subtract(Times(e, f), Times(d, g)), Plus(m, Times(C2, p), C3), x)), x)), x), x)), And(FreeQ(List(a, c, d, e, f, g, p), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), LtQ(m, CN1), Or(IntegerQ(m), IntegerQ(p), IntegersQ(Times(C2, m), Times(C2, p))))));
            IIntegrate(836, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Plus(f_DEFAULT, Times(g_DEFAULT, x_)), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Subtract(Times(e, f), Times(d, g)), Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Times(Plus(m, C1), Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e)))), CN1)), x), Dist(Power(Times(Plus(m, C1), Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e)))), CN1), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p), Simp(Subtract(Plus(Times(Plus(Times(c, d, f), Times(CN1, f, b, e), Times(a, e, g)), Plus(m, C1)), Times(b, Subtract(Times(d, g), Times(e, f)), Plus(p, C1))), Times(c, Subtract(Times(e, f), Times(d, g)), Plus(m, Times(C2, p), C3), x)), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, m, p), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), ILtQ(Simplify(Plus(m, Times(C2, p), C3)), C0), NeQ(m, CN1))));
            IIntegrate(837, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Plus(f_DEFAULT, Times(g_DEFAULT, x_)), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Subtract(Times(e, f), Times(d, g)), Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1)), Power(Times(Plus(m, C1), Plus(Times(c, Sqr(d)), Times(a, Sqr(e)))), CN1)), x), Dist(Power(Times(Plus(m, C1), Plus(Times(c, Sqr(d)), Times(a, Sqr(e)))), CN1), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(c, Sqr(x))), p), Simp(Subtract(Times(Plus(Times(c, d, f), Times(a, e, g)), Plus(m, C1)), Times(c, Subtract(Times(e, f), Times(d, g)), Plus(m, Times(C2, p), C3), x)), x)), x), x)), And(FreeQ(List(a, c, d, e, f, g, m, p), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), ILtQ(Simplify(Plus(m, Times(C2, p), C3)), C0), NeQ(m, CN1))));
            IIntegrate(838, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), CN1), Plus(f_, Times(g_DEFAULT, x_)), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(C4, f, Subtract(a, d), Power(Subtract(Times(b, d), Times(a, e)), CN1)), Subst(Int(Power(Subtract(Times(C4, Subtract(a, d)), Sqr(x)), CN1), x), x, Times(Plus(Times(C2, Subtract(a, d)), Times(Subtract(b, e), x)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), CN1D2))), x), And(FreeQ(List(a, b, c, d, e, f, g), x), EqQ(Subtract(Times(C4, c, Subtract(a, d)), Sqr(Subtract(b, e))), C0), EqQ(Subtract(Times(e, f, Subtract(b, e)), Times(C2, g, Subtract(Times(b, d), Times(a, e)))), C0), NeQ(Subtract(Times(b, d), Times(a, e)), C0))));
            IIntegrate(839, Int(Times(Power(x_, CN1D2), Plus(f_, Times(g_DEFAULT, x_)), Power(Plus(a_, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(C2, Subst(Int(Times(Plus(f, Times(g, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2)), x), x, Sqrt(x)), x), And(FreeQ(List(a, b, c, f, g), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(840, Int(Times(Power(x_, CN1D2), Plus(f_, Times(g_DEFAULT, x_)), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(C2, Subst(Int(Times(Plus(f, Times(g, Sqr(x))), Power(Plus(a, Times(c, Power(x, C4))), CN1D2)), x), x, Sqrt(x)), x), FreeQ(List(a, c, f, g), x)));
            IIntegrate(841, Int(Times(Power(Times(e_, x_), CN1D2), Plus(f_, Times(g_DEFAULT, x_)), Power(Plus(a_, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Sqrt(x), Power(Times(e, x), CN1D2)), Int(Times(Plus(f, Times(g, x)), Power(Times(Sqrt(x), Sqrt(Plus(a, Times(b, x), Times(c, Sqr(x))))), CN1)), x), x), And(FreeQ(List(a, b, c, e, f, g), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(842, Int(Times(Power(Times(e_, x_), CN1D2), Plus(f_, Times(g_DEFAULT, x_)), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Sqrt(x), Power(Times(e, x), CN1D2)), Int(Times(Plus(f, Times(g, x)), Power(Times(Sqrt(x), Sqrt(Plus(a, Times(c, Sqr(x))))), CN1)), x), x), FreeQ(List(a, c, e, f, g), x)));
            IIntegrate(843, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Plus(f_DEFAULT, Times(g_DEFAULT, x_)), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Dist(Times(g, Power(e, CN1)), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), x), Dist(Times(Subtract(Times(e, f), Times(d, g)), Power(e, CN1)), Int(Times(Power(Plus(d, Times(e, x)), m), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, m, p), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), Not(IGtQ(m, C0)))));
            IIntegrate(844, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Plus(f_DEFAULT, Times(g_DEFAULT, x_)), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Dist(Times(g, Power(e, CN1)), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(c, Sqr(x))), p)), x), x), Dist(Times(Subtract(Times(e, f), Times(d, g)), Power(e, CN1)), Int(Times(Power(Plus(d, Times(e, x)), m), Power(Plus(a, Times(c, Sqr(x))), p)), x), x)), And(FreeQ(List(a, c, d, e, f, g, m, p), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IGtQ(m, C0)))));
            IIntegrate(845, Int(Times(Power(x_, m_DEFAULT), Power(Plus(f_, Times(g_DEFAULT, x_)), n_DEFAULT), Plus(Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_)))), x_Symbol),
                    Condition(Simp(Times(c, Power(x, Plus(m, C2)), Power(Plus(f, Times(g, x)), Plus(n, C1)), Power(Times(g, Plus(m, n, C3)), CN1)), x), And(FreeQ(List(b, c, f, g, m, n), x), EqQ(Subtract(Times(c, f, Plus(m, C2)), Times(b, g, Plus(m, n, C3))), C0), NeQ(Plus(m, n, C3), C0))));
            IIntegrate(846, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, x), Times(c, Sqr(x))), FracPart(p)), Power(Times(Power(c, IntPart(p)), Power(Plus(Times(C1D2, b), Times(c, x)), Times(C2, FracPart(p)))), CN1)), Int(Times(Power(Plus(d, Times(e, x)), m), Power(Plus(f, Times(g, x)), n), Power(Plus(Times(C1D2, b), Times(c, x)), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, f, g, m, n), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(p)))));
            IIntegrate(847, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Plus(d, Times(e, x)), Plus(m, p)), Power(Plus(f, Times(g, x)), n), Power(Plus(Times(a, Power(d, CN1)), Times(c, x, Power(e, CN1))), p)), x), And(FreeQ(List(a, b, c, d, e, f, g, m, n), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), IntegerQ(p), Not(IGtQ(n, C0)))));
            IIntegrate(848, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Plus(d, Times(e, x)), Plus(m, p)), Power(Plus(f, Times(g, x)), n), Power(Plus(Times(a, Power(d, CN1)), Times(c, x, Power(e, CN1))), p)), x), And(FreeQ(List(a, c, d, e, f, g, m, n), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Or(IntegerQ(p), And(GtQ(a, C0), GtQ(d, C0), EqQ(Plus(m, p), C0))))));
            IIntegrate(849, Int(Times(Power(x_, n_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, x_)), CN1), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Int(Times(Power(x, n), Plus(Times(a, Power(d, CN1)), Times(c, x, Power(e, CN1))), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Subtract(p, C1))), x), And(FreeQ(List(a, b, c, d, e, n, p), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), Not(IntegerQ(p)), Or(Not(IntegerQ(n)), Not(IntegerQ(Times(C2, p))), IGtQ(n, C2), And(GtQ(p, C0), NeQ(n, C2))))));
            IIntegrate(850, Int(Times(Power(x_, n_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, x_)), CN1), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Int(Times(Power(x, n), Plus(Times(a, Power(d, CN1)), Times(c, x, Power(e, CN1))), Power(Plus(a, Times(c, Sqr(x))), Subtract(p, C1))), x), And(FreeQ(List(a, c, d, e, n, p), x), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IntegerQ(p)), Or(Not(IntegerQ(n)), Not(IntegerQ(Times(C2, p))), IGtQ(n, C2), And(GtQ(p, C0), NeQ(n, C2))))));
        }
    }
}
