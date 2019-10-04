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
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.PolynomialQuotient;
import static org.matheclipse.core.expression.F.PolynomialRemainder;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.QSymbol;
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
import static org.matheclipse.core.expression.F.h;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules35 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(876, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Simp(Times(Sqr(e), Power(Plus(d, Times(e, x)), Subtract(m, C2)), Power(Plus(f, Times(g, x)), Plus(n, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Times(c, g, Plus(n, p, C2)), CN1)), x), And(FreeQ(List(a, b, c, d, e, f, g, m, n, p), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), Not(IntegerQ(p)), EqQ(Subtract(Plus(m, p), C1), C0), EqQ(Subtract(Plus(Times(b, e, g, Plus(n, C1)), Times(c, e, f, Plus(p, C1))), Times(c, d, g, Plus(Times(C2, n), p, C3))), C0), NeQ(Plus(n, p, C2), C0))));
            IIntegrate(877, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Simp(Times(Sqr(e), Power(Plus(d, Times(e, x)), Subtract(m, C2)), Power(Plus(f, Times(g, x)), Plus(n, C1)), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1)), Power(Times(c, g, Plus(n, p, C2)), CN1)), x), And(FreeQ(List(a, c, d, e, f, g, m, n, p), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IntegerQ(p)), EqQ(Subtract(Plus(m, p), C1), C0), EqQ(Subtract(Times(e, f, Plus(p, C1)), Times(d, g, Plus(Times(C2, n), p, C3))), C0), NeQ(Plus(n, p, C2), C0))));
            IIntegrate(878, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Sqr(e), Subtract(Times(e, f), Times(d, g)), Power(Plus(d, Times(e, x)), Subtract(m, C2)), Power(Plus(f, Times(g, x)), Plus(n, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Times(g, Plus(n, C1), Subtract(Plus(Times(c, e, f), Times(c, d, g)), Times(b, e, g))), CN1)), x), Dist(Times(e, Subtract(Plus(Times(b, e, g, Plus(n, C1)), Times(c, e, f, Plus(p, C1))), Times(c, d, g, Plus(Times(C2, n), p, C3))), Power(Times(g, Plus(n, C1), Subtract(Plus(Times(c, e, f), Times(c, d, g)), Times(b, e, g))), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(f, Times(g, x)), Plus(n, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, m, p), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), Not(IntegerQ(p)), EqQ(Subtract(Plus(m, p), C1), C0), LtQ(n, CN1), IntegerQ(Times(C2, p)))));
            IIntegrate(879, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Sqr(e), Subtract(Times(e, f), Times(d, g)), Power(Plus(d, Times(e, x)), Subtract(m, C2)), Power(Plus(f, Times(g, x)), Plus(n, C1)), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1)), Power(Times(c, g, Plus(n, C1), Plus(Times(e, f), Times(d, g))), CN1)), x), Dist(Times(e, Subtract(Times(e, f, Plus(p, C1)), Times(d, g, Plus(Times(C2, n), p, C3))), Power(Times(g, Plus(n, C1), Plus(Times(e, f), Times(d, g))), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(f, Times(g, x)), Plus(n, C1)), Power(Plus(a, Times(c, Sqr(x))), p)), x), x)), And(FreeQ(List(a, c, d, e, f, g, m, p), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IntegerQ(p)), EqQ(Subtract(Plus(m, p), C1), C0), LtQ(n, CN1), IntegerQ(Times(C2, p)))));
            IIntegrate(880, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Sqr(e), Power(Plus(d, Times(e, x)), Subtract(m, C2)), Power(Plus(f, Times(g, x)), Plus(n, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Times(c, g, Plus(n, p, C2)), CN1)), x), Dist(Times(Subtract(Plus(Times(b, e, g, Plus(n, C1)), Times(c, e, f, Plus(p, C1))), Times(c, d, g, Plus(Times(C2, n), p, C3))), Power(Times(c, g, Plus(n, p, C2)), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(f, Times(g, x)), n), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, m, n, p), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), Not(IntegerQ(p)), EqQ(Subtract(Plus(m, p), C1), C0), Not(LtQ(n, CN1)), IntegerQ(Times(C2, p)))));
            IIntegrate(881, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Sqr(e), Power(Plus(d, Times(e, x)), Subtract(m, C2)), Power(Plus(f, Times(g, x)), Plus(n, C1)), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1)), Power(Times(c, g, Plus(n, p, C2)), CN1)), x), Dist(Times(Subtract(Times(e, f, Plus(p, C1)), Times(d, g, Plus(Times(C2, n), p, C3))), Power(Times(g, Plus(n, p, C2)), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(f, Times(g, x)), n), Power(Plus(a, Times(c, Sqr(x))), p)), x), x)), And(FreeQ(List(a, c, d, e, f, g, m, n, p), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IntegerQ(p)), EqQ(Subtract(Plus(m, p), C1), C0), Not(LtQ(n, CN1)), IntegerQ(Times(C2, p)))));
            IIntegrate(882, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(d, Times(e, x)), m), Power(Plus(f, Times(g, x)), n), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, n, p), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), Not(IntegerQ(p)), ILtQ(m, C0), Or(ILtQ(n, C0), And(IGtQ(n, C0), ILtQ(Plus(p, C1D2), C0))), Not(IGtQ(n, C0)))));
            IIntegrate(883, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(a, Times(c, Sqr(x))), CN1D2), Times(Power(Plus(d, Times(e, x)), m), Power(Plus(f, Times(g, x)), n), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1D2))), x), x), And(FreeQ(List(a, c, d, e, f, g, n, p), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), IntegerQ(Subtract(p, C1D2)), ILtQ(m, C0), ILtQ(n, C0), Not(IGtQ(n, C0)))));
            IIntegrate(884, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(d, Times(e, x)), m), Power(Plus(f, Times(g, x)), n), Power(Plus(a, Times(c, Sqr(x))), p)), x), x), And(FreeQ(List(a, c, d, e, f, g, n, p), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IntegerQ(p)), ILtQ(m, C0), Or(ILtQ(n, C0), And(IGtQ(n, C0), ILtQ(Plus(p, C1D2), C0))), Not(IGtQ(n, C0)))));
            IIntegrate(885, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_DEFAULT), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(With(List(Set(QSymbol, PolynomialQuotient(Power(Plus(f, Times(g, x)), n), Plus(Times(a, e), Times(c, d, x)), x)), Set(h, PolynomialRemainder(Power(Plus(f, Times(g, x)), n), Plus(Times(a, e), Times(c, d, x)), x))), Plus(Simp(Times(h, Subtract(Times(C2, c, d), Times(b, e)), Power(Plus(d, Times(e, x)), m), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Times(e, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1)), x), Dist(Power(Times(Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), ExpandToSum(Subtract(Times(d, e, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c)), QSymbol), Times(h, Subtract(Times(C2, c, d), Times(b, e)), Plus(m, Times(C2, p), C2))), x)), x), x))), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), ILtQ(Plus(p, C1D2), C0), IGtQ(m, C0), IGtQ(n, C0), Not(IGtQ(n, C0)))));
            IIntegrate(886, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_DEFAULT), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(With(List(Set(QSymbol, PolynomialQuotient(Power(Plus(f, Times(g, x)), n), Plus(Times(a, e), Times(c, d, x)), x)), Set(h, PolynomialRemainder(Power(Plus(f, Times(g, x)), n), Plus(Times(a, e), Times(c, d, x)), x))), Plus(Negate(Simp(Times(d, h, Power(Plus(d, Times(e, x)), m), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1)), Power(Times(C2, a, e, Plus(p, C1)), CN1)), x)), Dist(Times(d, Power(Times(C2, a, Plus(p, C1)), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1)), ExpandToSum(Plus(Times(C2, a, e, Plus(p, C1), QSymbol), Times(h, Plus(m, Times(C2, p), C2))), x)), x), x))), And(FreeQ(List(a, c, d, e, f, g), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), ILtQ(Plus(p, C1D2), C0), IGtQ(m, C0), IGtQ(n, C0), Not(IGtQ(n, C0)))));
            IIntegrate(887, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p), Times(Power(Plus(d, Times(e, x)), m), Power(Plus(f, Times(g, x)), n)), x), x), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), Not(IntegerQ(p)), EqQ(Plus(m, n, Times(C2, p), C1), C0), ILtQ(m, C0), ILtQ(n, C0))));
            IIntegrate(888, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(a, Times(c, Sqr(x))), p), Times(Power(Plus(d, Times(e, x)), m), Power(Plus(f, Times(g, x)), n)), x), x), And(FreeQ(List(a, c, d, e, f, g), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IntegerQ(p)), EqQ(Plus(m, n, Times(C2, p), C1), C0), ILtQ(m, C0), ILtQ(n, C0))));
            IIntegrate(889, Int(Times(Power(Times(e_DEFAULT, x_), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Times(e, x), m), Power(Plus(Times(b, x), Times(c, Sqr(x))), p), Power(Times(Power(x, Plus(m, p)), Power(Plus(b, Times(c, x)), p)), CN1)), Int(Times(Power(x, Plus(m, p)), Power(Plus(f, Times(g, x)), n), Power(Plus(b, Times(c, x)), p)), x), x), And(FreeQ(List(b, c, e, f, g, m, n), x), Not(IntegerQ(p)), Not(IGtQ(n, C0)))));
            IIntegrate(890, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Int(Times(Power(Plus(d, Times(e, x)), Plus(m, p)), Power(Plus(f, Times(g, x)), n), Power(Plus(Times(a, Power(d, CN1)), Times(c, x, Power(e, CN1))), p)), x), And(FreeQ(List(a, c, d, e, f, g, m, n), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IntegerQ(p)), GtQ(a, C0), GtQ(d, C0), Not(IGtQ(m, C0)), Not(IGtQ(n, C0)))));
            IIntegrate(891, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, x), Times(c, Sqr(x))), FracPart(p)), Power(Times(Power(Plus(d, Times(e, x)), FracPart(p)), Power(Plus(Times(a, Power(d, CN1)), Times(c, x, Power(e, CN1))), FracPart(p))), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, p)), Power(Plus(f, Times(g, x)), n), Power(Plus(Times(a, Power(d, CN1)), Times(c, x, Power(e, CN1))), p)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, m, n), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), Not(IntegerQ(p)), Not(IGtQ(m, C0)), Not(IGtQ(n, C0)))));
            IIntegrate(892, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(c, Sqr(x))), FracPart(p)), Power(Times(Power(Plus(d, Times(e, x)), FracPart(p)), Power(Plus(Times(a, Power(d, CN1)), Times(c, x, Power(e, CN1))), FracPart(p))), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, p)), Power(Plus(f, Times(g, x)), n), Power(Plus(Times(a, Power(d, CN1)), Times(c, x, Power(e, CN1))), p)), x), x), And(FreeQ(List(a, c, d, e, f, g, m, n), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IntegerQ(p)), Not(IGtQ(m, C0)), Not(IGtQ(n, C0)))));
            IIntegrate(893, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(d, Times(e, x)), m), Power(Plus(f, Times(g, x)), n), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), x), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), IntegerQ(p), Or(And(EqQ(p, C1), IntegersQ(m, n)), And(ILtQ(m, C0), ILtQ(n, C0))))));
            IIntegrate(894, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(d, Times(e, x)), m), Power(Plus(f, Times(g, x)), n), Power(Plus(a, Times(c, Sqr(x))), p)), x), x), And(FreeQ(List(a, c, d, e, f, g), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), IntegerQ(p), Or(And(EqQ(p, C1), IntegersQ(m, n)), And(ILtQ(m, C0), ILtQ(n, C0))))));
            IIntegrate(895, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), CN1), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), CN1), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Subtract(Dist(Times(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), Power(Times(e, Subtract(Times(e, f), Times(d, g))), CN1)), Int(Times(Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Subtract(p, C1)), Power(Plus(d, Times(e, x)), CN1)), x), x), Dist(Power(Times(e, Subtract(Times(e, f), Times(d, g))), CN1), Int(Times(Simp(Subtract(Plus(Times(c, d, f), Times(CN1, b, e, f), Times(a, e, g)), Times(c, Subtract(Times(e, f), Times(d, g)), x)), x), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Subtract(p, C1)), Power(Plus(f, Times(g, x)), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), FractionQ(p), GtQ(p, C0))));
            IIntegrate(896, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), CN1), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), CN1), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Subtract(Dist(Times(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), Power(Times(e, Subtract(Times(e, f), Times(d, g))), CN1)), Int(Times(Power(Plus(a, Times(c, Sqr(x))), Subtract(p, C1)), Power(Plus(d, Times(e, x)), CN1)), x), x), Dist(Power(Times(e, Subtract(Times(e, f), Times(d, g))), CN1), Int(Times(Simp(Subtract(Plus(Times(c, d, f), Times(a, e, g)), Times(c, Subtract(Times(e, f), Times(d, g)), x)), x), Power(Plus(a, Times(c, Sqr(x))), Subtract(p, C1)), Power(Plus(f, Times(g, x)), CN1)), x), x)), And(FreeQ(List(a, c, d, e, f, g), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), FractionQ(p), GtQ(p, C0))));
            IIntegrate(897, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(q, Denominator(m))), Dist(Times(q, Power(e, CN1)), Subst(Int(Times(Power(x, Subtract(Times(q, Plus(m, C1)), C1)), Power(Plus(Times(Subtract(Times(e, f), Times(d, g)), Power(e, CN1)), Times(g, Power(x, q), Power(e, CN1))), n), Power(Plus(Times(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), Power(e, CN2)), Times(CN1, Subtract(Times(C2, c, d), Times(b, e)), Power(x, q), Power(e, CN2)), Times(c, Power(x, Times(C2, q)), Power(e, CN2))), p)), x), x, Power(Plus(d, Times(e, x)), Power(q, CN1))), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), IntegersQ(n, p), FractionQ(m))));
            IIntegrate(898, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(f_DEFAULT, Times(g_DEFAULT, x_)), n_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(q, Denominator(m))), Dist(Times(q, Power(e, CN1)), Subst(Int(Times(Power(x, Subtract(Times(q, Plus(m, C1)), C1)), Power(Plus(Times(Subtract(Times(e, f), Times(d, g)), Power(e, CN1)), Times(g, Power(x, q), Power(e, CN1))), n), Power(Plus(Times(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), Power(e, CN2)), Times(CN1, C2, c, d, Power(x, q), Power(e, CN2)), Times(c, Power(x, Times(C2, q)), Power(e, CN2))), p)), x), x, Power(Plus(d, Times(e, x)), Power(q, CN1))), x)), And(FreeQ(List(a, c, d, e, f, g), x), NeQ(Subtract(Times(e, f), Times(d, g)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), IntegersQ(n, p), FractionQ(m))));
            IIntegrate(899, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(f_, Times(g_DEFAULT, x_)), n_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Plus(Times(d, f), Times(e, g, Sqr(x))), m), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), And(FreeQ(List(a, b, c, d, e, f, g, m, n, p), x), EqQ(Subtract(m, n), C0), EqQ(Plus(Times(e, f), Times(d, g)), C0), Or(IntegerQ(m), And(GtQ(d, C0), GtQ(f, C0))))));
            IIntegrate(900, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(f_, Times(g_DEFAULT, x_)), n_), Power(Plus(a_DEFAULT, Times(c_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Plus(Times(d, f), Times(e, g, Sqr(x))), m), Power(Plus(a, Times(c, Sqr(x))), p)), x), And(FreeQ(List(a, c, d, e, f, g, m, n, p), x), EqQ(Subtract(m, n), C0), EqQ(Plus(Times(e, f), Times(d, g)), C0), Or(IntegerQ(m), And(GtQ(d, C0), GtQ(f, C0))))));
        }
    }
}
