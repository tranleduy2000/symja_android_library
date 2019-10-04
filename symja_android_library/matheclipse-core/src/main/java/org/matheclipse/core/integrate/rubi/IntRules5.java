package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.AppellF1;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.C5;
import static org.matheclipse.core.expression.F.C6;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Coefficient;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.Hypergeometric2F1;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Subtract;
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
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.g_DEFAULT;
import static org.matheclipse.core.expression.F.h;
import static org.matheclipse.core.expression.F.h_DEFAULT;
import static org.matheclipse.core.expression.F.k;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumSimplerQ;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules5 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(126, Int(Times(Power(Times(f_DEFAULT, x_), p_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, x)), FracPart(m)), Power(Plus(c, Times(d, x)), FracPart(m)), Power(Power(Plus(Times(a, c), Times(b, d, Sqr(x))), FracPart(m)), CN1)), Int(Times(Power(Plus(Times(a, c), Times(b, d, Sqr(x))), m), Power(Times(f, x), p)), x), x), And(FreeQ(List(a, b, c, d, f, m, n, p), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(m, n), C0))));
            IIntegrate(127, Int(Times(Power(Times(f_DEFAULT, x_), p_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(a, Times(b, x)), n), Power(Plus(c, Times(d, x)), n), Power(Times(f, x), p)), Power(Plus(a, Times(b, x)), Subtract(m, n)), x), x), And(FreeQ(List(a, b, c, d, f, m, n, p), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), IGtQ(Subtract(m, n), C0), NeQ(Plus(m, n, p, C2), C0))));
            IIntegrate(128, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(a, Times(b, x)), m), Power(Plus(c, Times(d, x)), n), Power(Plus(e, Times(f, x)), p)), x), x), And(FreeQ(List(a, b, c, d, e, f, n, p), x), Or(IGtQ(m, C0), And(ILtQ(m, C0), ILtQ(n, C0))))));
            IIntegrate(129, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(b, Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), Plus(n, C1)), Power(Plus(e, Times(f, x)), Plus(p, C1)), Power(Times(Plus(m, C1), Subtract(Times(b, c), Times(a, d)), Subtract(Times(b, e), Times(a, f))), CN1)), x), Dist(Power(Times(Plus(m, C1), Subtract(Times(b, c), Times(a, d)), Subtract(Times(b, e), Times(a, f))), CN1), Int(Times(Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), n), Power(Plus(e, Times(f, x)), p), Simp(Subtract(Subtract(Times(a, d, f, Plus(m, C1)), Times(b, Plus(Times(d, e, Plus(m, n, C2)), Times(c, f, Plus(m, p, C2))))), Times(b, d, f, Plus(m, n, p, C3), x)), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), ILtQ(Plus(m, n, p, C2), C0), NeQ(m, CN1), Or(SumSimplerQ(m, C1), And(Not(And(NeQ(n, CN1), SumSimplerQ(n, C1))), Not(And(NeQ(p, CN1), SumSimplerQ(p, C1))))))));
            IIntegrate(130, Int(Times(Power(Times(e_DEFAULT, x_), p_), Power(Plus(a_, Times(b_DEFAULT, x_)), m_), Power(Plus(c_, Times(d_DEFAULT, x_)), n_)), x_Symbol),
                    Condition(With(List(Set(k, Denominator(p))), Dist(Times(k, Power(e, CN1)), Subst(Int(Times(Power(x, Subtract(Times(k, Plus(p, C1)), C1)), Power(Plus(a, Times(b, Power(x, k), Power(e, CN1))), m), Power(Plus(c, Times(d, Power(x, k), Power(e, CN1))), n)), x), x, Power(Times(e, x), Power(k, CN1))), x)), And(FreeQ(List(a, b, c, d, e, m, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), FractionQ(p), IntegerQ(m))));
            IIntegrate(131, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_)), x_Symbol),
                    Condition(Simp(Times(Power(Subtract(Times(b, c), Times(a, d)), n), Power(Plus(a, Times(b, x)), Plus(m, C1)), Hypergeometric2F1(Plus(m, C1), Negate(n), Plus(m, C2), Times(CN1, Subtract(Times(d, e), Times(c, f)), Plus(a, Times(b, x)), Power(Times(Subtract(Times(b, c), Times(a, d)), Plus(e, Times(f, x))), CN1))), Power(Times(Plus(m, C1), Power(Subtract(Times(b, e), Times(a, f)), Plus(n, C1)), Power(Plus(e, Times(f, x)), Plus(m, C1))), CN1)), x), And(FreeQ(List(a, b, c, d, e, f, m, p), x), EqQ(Plus(m, n, p, C2), C0), ILtQ(n, C0))));
            IIntegrate(132, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_)), x_Symbol),
                    Condition(Simp(Times(Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), n), Power(Plus(e, Times(f, x)), Plus(p, C1)), Hypergeometric2F1(Plus(m, C1), Negate(n), Plus(m, C2), Times(CN1, Subtract(Times(d, e), Times(c, f)), Plus(a, Times(b, x)), Power(Times(Subtract(Times(b, c), Times(a, d)), Plus(e, Times(f, x))), CN1))), Power(Times(Subtract(Times(b, e), Times(a, f)), Plus(m, C1), Power(Times(Subtract(Times(b, e), Times(a, f)), Plus(c, Times(d, x)), Power(Times(Subtract(Times(b, c), Times(a, d)), Plus(e, Times(f, x))), CN1)), n)), CN1)), x), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), EqQ(Plus(m, n, p, C2), C0), Not(IntegerQ(n)))));
            IIntegrate(133, Int(Times(Power(Times(b_DEFAULT, x_), m_), Power(Plus(c_, Times(d_DEFAULT, x_)), n_), Power(Plus(e_, Times(f_DEFAULT, x_)), p_)), x_Symbol),
                    Condition(Simp(Times(Power(c, n), Power(e, p), Power(Times(b, x), Plus(m, C1)), AppellF1(Plus(m, C1), Negate(n), Negate(p), Plus(m, C2), Times(CN1, d, x, Power(c, CN1)), Times(CN1, f, x, Power(e, CN1))), Power(Times(b, Plus(m, C1)), CN1)), x), And(FreeQ(List(b, c, d, e, f, m, n, p), x), Not(IntegerQ(m)), Not(IntegerQ(n)), GtQ(c, C0), Or(IntegerQ(p), GtQ(e, C0)))));
            IIntegrate(134, Int(Times(Power(Times(b_DEFAULT, x_), m_), Power(Plus(c_, Times(d_DEFAULT, x_)), n_), Power(Plus(e_, Times(f_DEFAULT, x_)), p_)), x_Symbol),
                    Condition(Simp(Times(Power(Plus(c, Times(d, x)), Plus(n, C1)), AppellF1(Plus(n, C1), Negate(m), Negate(p), Plus(n, C2), Plus(C1, Times(d, x, Power(c, CN1))), Times(CN1, f, Plus(c, Times(d, x)), Power(Subtract(Times(d, e), Times(c, f)), CN1))), Power(Times(d, Plus(n, C1), Power(Times(CN1, d, Power(Times(b, c), CN1)), m), Power(Times(d, Power(Subtract(Times(d, e), Times(c, f)), CN1)), p)), CN1)), x), And(FreeQ(List(b, c, d, e, f, m, n, p), x), Not(IntegerQ(m)), Not(IntegerQ(n)), GtQ(Times(CN1, d, Power(Times(b, c), CN1)), C0), Or(IntegerQ(p), GtQ(Times(d, Power(Subtract(Times(d, e), Times(c, f)), CN1)), C0)))));
            IIntegrate(135, Int(Times(Power(Times(b_DEFAULT, x_), m_), Power(Plus(c_, Times(d_DEFAULT, x_)), n_), Power(Plus(e_, Times(f_DEFAULT, x_)), p_)), x_Symbol),
                    Condition(Dist(Times(Power(c, IntPart(n)), Power(Plus(c, Times(d, x)), FracPart(n)), Power(Power(Plus(C1, Times(d, x, Power(c, CN1))), FracPart(n)), CN1)), Int(Times(Power(Times(b, x), m), Power(Plus(C1, Times(d, x, Power(c, CN1))), n), Power(Plus(e, Times(f, x)), p)), x), x), And(FreeQ(List(b, c, d, e, f, m, n, p), x), Not(IntegerQ(m)), Not(IntegerQ(n)), Not(GtQ(c, C0)))));
            IIntegrate(136, Int(Times(Power(Plus(a_, Times(b_DEFAULT, x_)), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_)), x_Symbol),
                    Condition(Simp(Times(Power(Subtract(Times(b, e), Times(a, f)), p), Power(Plus(a, Times(b, x)), Plus(m, C1)), AppellF1(Plus(m, C1), Negate(n), Negate(p), Plus(m, C2), Times(CN1, d, Plus(a, Times(b, x)), Power(Subtract(Times(b, c), Times(a, d)), CN1)), Times(CN1, f, Plus(a, Times(b, x)), Power(Subtract(Times(b, e), Times(a, f)), CN1))), Power(Times(Power(b, Plus(p, C1)), Plus(m, C1), Power(Times(b, Power(Subtract(Times(b, c), Times(a, d)), CN1)), n)), CN1)), x), And(FreeQ(List(a, b, c, d, e, f, m, n), x), Not(IntegerQ(m)), Not(IntegerQ(n)), IntegerQ(p), GtQ(Times(b, Power(Subtract(Times(b, c), Times(a, d)), CN1)), C0), Not(And(GtQ(Times(d, Power(Subtract(Times(d, a), Times(c, b)), CN1)), C0), SimplerQ(Plus(c, Times(d, x)), Plus(a, Times(b, x))))))));
            IIntegrate(137, Int(Times(Power(Plus(a_, Times(b_DEFAULT, x_)), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(c, Times(d, x)), FracPart(n)), Power(Times(Power(Times(b, Power(Subtract(Times(b, c), Times(a, d)), CN1)), IntPart(n)), Power(Times(b, Plus(c, Times(d, x)), Power(Subtract(Times(b, c), Times(a, d)), CN1)), FracPart(n))), CN1)), Int(Times(Power(Plus(a, Times(b, x)), m), Power(Plus(Times(b, c, Power(Subtract(Times(b, c), Times(a, d)), CN1)), Times(b, d, x, Power(Subtract(Times(b, c), Times(a, d)), CN1))), n), Power(Plus(e, Times(f, x)), p)), x), x), And(FreeQ(List(a, b, c, d, e, f, m, n), x), Not(IntegerQ(m)), Not(IntegerQ(n)), IntegerQ(p), Not(GtQ(Times(b, Power(Subtract(Times(b, c), Times(a, d)), CN1)), C0)), Not(SimplerQ(Plus(c, Times(d, x)), Plus(a, Times(b, x)))))));
            IIntegrate(138, Int(Times(Power(Plus(a_, Times(b_DEFAULT, x_)), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_)), x_Symbol),
                    Condition(Simp(Times(Power(Plus(a, Times(b, x)), Plus(m, C1)), AppellF1(Plus(m, C1), Negate(n), Negate(p), Plus(m, C2), Times(CN1, d, Plus(a, Times(b, x)), Power(Subtract(Times(b, c), Times(a, d)), CN1)), Times(CN1, f, Plus(a, Times(b, x)), Power(Subtract(Times(b, e), Times(a, f)), CN1))), Power(Times(b, Plus(m, C1), Power(Times(b, Power(Subtract(Times(b, c), Times(a, d)), CN1)), n), Power(Times(b, Power(Subtract(Times(b, e), Times(a, f)), CN1)), p)), CN1)), x), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), Not(IntegerQ(m)), Not(IntegerQ(n)), Not(IntegerQ(p)), GtQ(Times(b, Power(Subtract(Times(b, c), Times(a, d)), CN1)), C0), GtQ(Times(b, Power(Subtract(Times(b, e), Times(a, f)), CN1)), C0), Not(And(GtQ(Times(d, Power(Subtract(Times(d, a), Times(c, b)), CN1)), C0), GtQ(Times(d, Power(Subtract(Times(d, e), Times(c, f)), CN1)), C0), SimplerQ(Plus(c, Times(d, x)), Plus(a, Times(b, x))))), Not(And(GtQ(Times(f, Power(Subtract(Times(f, a), Times(e, b)), CN1)), C0), GtQ(Times(f, Power(Subtract(Times(f, c), Times(e, d)), CN1)), C0), SimplerQ(Plus(e, Times(f, x)), Plus(a, Times(b, x))))))));
            IIntegrate(139, Int(Times(Power(Plus(a_, Times(b_DEFAULT, x_)), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(e, Times(f, x)), FracPart(p)), Power(Times(Power(Times(b, Power(Subtract(Times(b, e), Times(a, f)), CN1)), IntPart(p)), Power(Times(b, Plus(e, Times(f, x)), Power(Subtract(Times(b, e), Times(a, f)), CN1)), FracPart(p))), CN1)), Int(Times(Power(Plus(a, Times(b, x)), m), Power(Plus(c, Times(d, x)), n), Power(Plus(Times(b, e, Power(Subtract(Times(b, e), Times(a, f)), CN1)), Times(b, f, x, Power(Subtract(Times(b, e), Times(a, f)), CN1))), p)), x), x), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), Not(IntegerQ(m)), Not(IntegerQ(n)), Not(IntegerQ(p)), GtQ(Times(b, Power(Subtract(Times(b, c), Times(a, d)), CN1)), C0), Not(GtQ(Times(b, Power(Subtract(Times(b, e), Times(a, f)), CN1)), C0)))));
            IIntegrate(140, Int(Times(Power(Plus(a_, Times(b_DEFAULT, x_)), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(c, Times(d, x)), FracPart(n)), Power(Times(Power(Times(b, Power(Subtract(Times(b, c), Times(a, d)), CN1)), IntPart(n)), Power(Times(b, Plus(c, Times(d, x)), Power(Subtract(Times(b, c), Times(a, d)), CN1)), FracPart(n))), CN1)), Int(Times(Power(Plus(a, Times(b, x)), m), Power(Plus(Times(b, c, Power(Subtract(Times(b, c), Times(a, d)), CN1)), Times(b, d, x, Power(Subtract(Times(b, c), Times(a, d)), CN1))), n), Power(Plus(e, Times(f, x)), p)), x), x), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), Not(IntegerQ(m)), Not(IntegerQ(n)), Not(IntegerQ(p)), Not(GtQ(Times(b, Power(Subtract(Times(b, c), Times(a, d)), CN1)), C0)), Not(SimplerQ(Plus(c, Times(d, x)), Plus(a, Times(b, x)))), Not(SimplerQ(Plus(e, Times(f, x)), Plus(a, Times(b, x)))))));
            IIntegrate(141, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, u_)), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, u_)), n_DEFAULT), Power(Plus(e_, Times(f_DEFAULT, u_)), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Coefficient(u, x, C1), CN1), Subst(Int(Times(Power(Plus(a, Times(b, x)), m), Power(Plus(c, Times(d, x)), n), Power(Plus(e, Times(f, x)), p)), x), x, u), x), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), LinearQ(u, x), NeQ(u, x))));
            IIntegrate(142, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT), Plus(e_, Times(f_DEFAULT, x_)), Plus(g_DEFAULT, Times(h_DEFAULT, x_))), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(a, Times(b, x)), m), Power(Plus(c, Times(d, x)), n), Plus(e, Times(f, x)), Plus(g, Times(h, x))), x), x), And(FreeQ(List(a, b, c, d, e, f, g, h), x), Or(IGtQ(m, C0), IntegersQ(m, n)))));
            IIntegrate(143, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT), Plus(e_, Times(f_DEFAULT, x_)), Plus(g_DEFAULT, Times(h_DEFAULT, x_))), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(Times(Sqr(b), d, e, g), Times(CN1, Sqr(a), d, f, h, m), Times(CN1, a, b, Subtract(Times(d, Plus(Times(f, g), Times(e, h))), Times(c, f, h, Plus(m, C1)))), Times(b, f, h, Subtract(Times(b, c), Times(a, d)), Plus(m, C1), x)), Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), Plus(n, C1)), Power(Times(Sqr(b), d, Subtract(Times(b, c), Times(a, d)), Plus(m, C1)), CN1)), x), Dist(Times(Plus(Times(a, d, f, h, m), Times(b, Subtract(Times(d, Plus(Times(f, g), Times(e, h))), Times(c, f, h, Plus(m, C2))))), Power(Times(Sqr(b), d), CN1)), Int(Times(Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), n)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, h, m, n), x), EqQ(Plus(m, n, C2), C0), NeQ(m, CN1), Not(And(SumSimplerQ(n, C1), Not(SumSimplerQ(m, C1)))))));
            IIntegrate(144, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_), Plus(e_, Times(f_DEFAULT, x_)), Plus(g_DEFAULT, Times(h_DEFAULT, x_))), x_Symbol),
                    Condition(Subtract(Simp(Times(Plus(Times(Sqr(b), c, d, e, g, Plus(n, C1)), Times(Sqr(a), c, d, f, h, Plus(n, C1)), Times(a, b, Subtract(Plus(Times(Sqr(d), e, g, Plus(m, C1)), Times(Sqr(c), f, h, Plus(m, C1))), Times(c, d, Plus(Times(f, g), Times(e, h)), Plus(m, n, C2)))), Times(Plus(Times(Sqr(a), Sqr(d), f, h, Plus(n, C1)), Times(CN1, a, b, Sqr(d), Plus(Times(f, g), Times(e, h)), Plus(n, C1)), Times(Sqr(b), Plus(Times(Sqr(c), f, h, Plus(m, C1)), Times(CN1, c, d, Plus(Times(f, g), Times(e, h)), Plus(m, C1)), Times(Sqr(d), e, g, Plus(m, n, C2))))), x)), Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), Plus(n, C1)), Power(Times(b, d, Sqr(Subtract(Times(b, c), Times(a, d))), Plus(m, C1), Plus(n, C1)), CN1)), x), Dist(Times(Plus(Times(Sqr(a), Sqr(d), f, h, Plus(C2, Times(C3, n), Sqr(n))), Times(a, b, d, Plus(n, C1), Subtract(Times(C2, c, f, h, Plus(m, C1)), Times(d, Plus(Times(f, g), Times(e, h)), Plus(m, n, C3)))), Times(Sqr(b), Plus(Times(Sqr(c), f, h, Plus(C2, Times(C3, m), Sqr(m))), Times(CN1, c, d, Plus(Times(f, g), Times(e, h)), Plus(m, C1), Plus(m, n, C3)), Times(Sqr(d), e, g, Plus(C6, Sqr(m), Times(C5, n), Sqr(n), Times(m, Plus(Times(C2, n), C5))))))), Power(Times(b, d, Sqr(Subtract(Times(b, c), Times(a, d))), Plus(m, C1), Plus(n, C1)), CN1)), Int(Times(Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), Plus(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, h), x), LtQ(m, CN1), LtQ(n, CN1))));
            IIntegrate(145, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT), Plus(e_, Times(f_DEFAULT, x_)), Plus(g_DEFAULT, Times(h_DEFAULT, x_))), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(Times(Power(b, C3), c, e, g, Plus(m, C2)), Times(CN1, Power(a, C3), d, f, h, Plus(n, C2)), Times(CN1, Sqr(a), b, Subtract(Times(c, f, h, m), Times(d, Plus(Times(f, g), Times(e, h)), Plus(m, n, C3)))), Times(CN1, a, Sqr(b), Plus(Times(c, Plus(Times(f, g), Times(e, h))), Times(d, e, g, Plus(Times(C2, m), n, C4)))), Times(b, Plus(Times(Sqr(a), d, f, h, Subtract(m, n)), Times(CN1, a, b, Subtract(Times(C2, c, f, h, Plus(m, C1)), Times(d, Plus(Times(f, g), Times(e, h)), Plus(n, C1)))), Times(Sqr(b), Subtract(Times(c, Plus(Times(f, g), Times(e, h)), Plus(m, C1)), Times(d, e, g, Plus(m, n, C2))))), x)), Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), Plus(n, C1)), Power(Times(Sqr(b), Sqr(Subtract(Times(b, c), Times(a, d))), Plus(m, C1), Plus(m, C2)), CN1)), x), Dist(Subtract(Times(f, h, Power(b, CN2)), Times(d, Plus(m, n, C3), Plus(Times(Sqr(a), d, f, h, Subtract(m, n)), Times(CN1, a, b, Subtract(Times(C2, c, f, h, Plus(m, C1)), Times(d, Plus(Times(f, g), Times(e, h)), Plus(n, C1)))), Times(Sqr(b), Subtract(Times(c, Plus(Times(f, g), Times(e, h)), Plus(m, C1)), Times(d, e, g, Plus(m, n, C2))))), Power(Times(Sqr(b), Sqr(Subtract(Times(b, c), Times(a, d))), Plus(m, C1), Plus(m, C2)), CN1))), Int(Times(Power(Plus(a, Times(b, x)), Plus(m, C2)), Power(Plus(c, Times(d, x)), n)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, h, m, n), x), Or(LtQ(m, CN2), And(EqQ(Plus(m, n, C3), C0), Not(LtQ(n, CN2)))))));
            IIntegrate(146, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT), Plus(e_, Times(f_DEFAULT, x_)), Plus(g_DEFAULT, Times(h_DEFAULT, x_))), x_Symbol),
                    Condition(Subtract(Simp(Times(Plus(Times(Sqr(a), d, f, h, Plus(n, C2)), Times(Sqr(b), d, e, g, Plus(m, n, C3)), Times(a, b, Subtract(Times(c, f, h, Plus(m, C1)), Times(d, Plus(Times(f, g), Times(e, h)), Plus(m, n, C3)))), Times(b, f, h, Subtract(Times(b, c), Times(a, d)), Plus(m, C1), x)), Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), Plus(n, C1)), Power(Times(Sqr(b), d, Subtract(Times(b, c), Times(a, d)), Plus(m, C1), Plus(m, n, C3)), CN1)), x), Dist(Times(Plus(Times(Sqr(a), Sqr(d), f, h, Plus(n, C1), Plus(n, C2)), Times(a, b, d, Plus(n, C1), Subtract(Times(C2, c, f, h, Plus(m, C1)), Times(d, Plus(Times(f, g), Times(e, h)), Plus(m, n, C3)))), Times(Sqr(b), Plus(Times(Sqr(c), f, h, Plus(m, C1), Plus(m, C2)), Times(CN1, c, d, Plus(Times(f, g), Times(e, h)), Plus(m, C1), Plus(m, n, C3)), Times(Sqr(d), e, g, Plus(m, n, C2), Plus(m, n, C3))))), Power(Times(Sqr(b), d, Subtract(Times(b, c), Times(a, d)), Plus(m, C1), Plus(m, n, C3)), CN1)), Int(Times(Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), n)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, h, m, n), x), Or(And(GeQ(m, CN2), LtQ(m, CN1)), SumSimplerQ(m, C1)), NeQ(m, CN1), NeQ(Plus(m, n, C3), C0))));
            IIntegrate(147, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT), Plus(e_, Times(f_DEFAULT, x_)), Plus(g_DEFAULT, Times(h_DEFAULT, x_))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Subtract(Subtract(Plus(Times(a, d, f, h, Plus(n, C2)), Times(b, c, f, h, Plus(m, C2))), Times(b, d, Plus(Times(f, g), Times(e, h)), Plus(m, n, C3))), Times(b, d, f, h, Plus(m, n, C2), x)), Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), Plus(n, C1)), Power(Times(Sqr(b), Sqr(d), Plus(m, n, C2), Plus(m, n, C3)), CN1)), x)), Dist(Times(Plus(Times(Sqr(a), Sqr(d), f, h, Plus(n, C1), Plus(n, C2)), Times(a, b, d, Plus(n, C1), Subtract(Times(C2, c, f, h, Plus(m, C1)), Times(d, Plus(Times(f, g), Times(e, h)), Plus(m, n, C3)))), Times(Sqr(b), Plus(Times(Sqr(c), f, h, Plus(m, C1), Plus(m, C2)), Times(CN1, c, d, Plus(Times(f, g), Times(e, h)), Plus(m, C1), Plus(m, n, C3)), Times(Sqr(d), e, g, Plus(m, n, C2), Plus(m, n, C3))))), Power(Times(Sqr(b), Sqr(d), Plus(m, n, C2), Plus(m, n, C3)), CN1)), Int(Times(Power(Plus(a, Times(b, x)), m), Power(Plus(c, Times(d, x)), n)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, h, m, n), x), NeQ(Plus(m, n, C2), C0), NeQ(Plus(m, n, C3), C0))));
            IIntegrate(148, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_), Plus(g_DEFAULT, Times(h_DEFAULT, x_))), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(a, Times(b, x)), m), Power(Plus(c, Times(d, x)), n), Power(Plus(e, Times(f, x)), p), Plus(g, Times(h, x))), x), x), And(FreeQ(List(a, b, c, d, e, f, g, h, m), x), Or(IntegersQ(m, n, p), And(IGtQ(n, C0), IGtQ(p, C0))))));
            IIntegrate(149, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_), Plus(g_DEFAULT, Times(h_DEFAULT, x_))), x_Symbol),
                    Condition(Subtract(Simp(Times(Subtract(Times(b, g), Times(a, h)), Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), n), Power(Plus(e, Times(f, x)), Plus(p, C1)), Power(Times(b, Subtract(Times(b, e), Times(a, f)), Plus(m, C1)), CN1)), x), Dist(Power(Times(b, Subtract(Times(b, e), Times(a, f)), Plus(m, C1)), CN1), Int(Times(Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), Subtract(n, C1)), Power(Plus(e, Times(f, x)), p), Simp(Plus(Times(b, c, Subtract(Times(f, g), Times(e, h)), Plus(m, C1)), Times(Subtract(Times(b, g), Times(a, h)), Plus(Times(d, e, n), Times(c, f, Plus(p, C1)))), Times(d, Plus(Times(b, Subtract(Times(f, g), Times(e, h)), Plus(m, C1)), Times(f, Subtract(Times(b, g), Times(a, h)), Plus(n, p, C1))), x)), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, h, p), x), LtQ(m, CN1), GtQ(n, C0), IntegerQ(m))));
            IIntegrate(150, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_), Plus(g_DEFAULT, Times(h_DEFAULT, x_))), x_Symbol),
                    Condition(Subtract(Simp(Times(Subtract(Times(b, g), Times(a, h)), Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), n), Power(Plus(e, Times(f, x)), Plus(p, C1)), Power(Times(b, Subtract(Times(b, e), Times(a, f)), Plus(m, C1)), CN1)), x), Dist(Power(Times(b, Subtract(Times(b, e), Times(a, f)), Plus(m, C1)), CN1), Int(Times(Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), Subtract(n, C1)), Power(Plus(e, Times(f, x)), p), Simp(Plus(Times(b, c, Subtract(Times(f, g), Times(e, h)), Plus(m, C1)), Times(Subtract(Times(b, g), Times(a, h)), Plus(Times(d, e, n), Times(c, f, Plus(p, C1)))), Times(d, Plus(Times(b, Subtract(Times(f, g), Times(e, h)), Plus(m, C1)), Times(f, Subtract(Times(b, g), Times(a, h)), Plus(n, p, C1))), x)), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, h, p), x), LtQ(m, CN1), GtQ(n, C0), IntegersQ(Times(C2, m), Times(C2, n), Times(C2, p)))));
        }
    }
}
