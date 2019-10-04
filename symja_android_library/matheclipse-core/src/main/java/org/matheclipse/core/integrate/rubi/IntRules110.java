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
import static org.matheclipse.core.expression.F.CN1D2;
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
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
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
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules110 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(2751, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(d, Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Times(f, Plus(m, C1)), CN1)), x)), Dist(Times(Plus(Times(a, d, m), Times(b, c, Plus(m, C1))), Power(Times(b, Plus(m, C1)), CN1)), Int(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), x), x)), And(FreeQ(List(a, b, c, d, e, f, m), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), Not(LtQ(m, Negate(C1D2))))));
            IIntegrate(2752, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2), Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Dist(Times(Subtract(Times(b, c), Times(a, d)), Power(b, CN1)), Int(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), CN1D2), x), x), Dist(Times(d, Power(b, CN1)), Int(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(2753, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(d, Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Times(f, Plus(m, C1)), CN1)), x)), Dist(Power(Plus(m, C1), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, C1)), Simp(Plus(Times(b, d, m), Times(a, c, Plus(m, C1)), Times(Plus(Times(a, d, m), Times(b, c, Plus(m, C1))), Sin(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), GtQ(m, C0), IntegerQ(Times(C2, m)))));
            IIntegrate(2754, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Subtract(Times(b, c), Times(a, d)), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(f, Plus(m, C1), Subtract(Sqr(a), Sqr(b))), CN1)), x)), Dist(Power(Times(Plus(m, C1), Subtract(Sqr(a), Sqr(b))), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Simp(Subtract(Times(Subtract(Times(a, c), Times(b, d)), Plus(m, C1)), Times(Subtract(Times(b, c), Times(a, d)), Plus(m, C2), Sin(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), LtQ(m, CN1), IntegerQ(Times(C2, m)))));
            IIntegrate(2755, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Dist(Times(c, Cos(Plus(e, Times(f, x))), Power(Times(f, Sqrt(Plus(C1, Sin(Plus(e, Times(f, x))))), Sqrt(Subtract(C1, Sin(Plus(e, Times(f, x)))))), CN1)), Subst(Int(Times(Power(Plus(a, Times(b, x)), m), Sqrt(Plus(C1, Times(d, x, Power(c, CN1)))), Power(Subtract(C1, Times(d, x, Power(c, CN1))), CN1D2)), x), x, Sin(Plus(e, Times(f, x)))), x), And(FreeQ(List(a, b, c, d, e, f, m), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), Not(IntegerQ(Times(C2, m))), EqQ(Subtract(Sqr(c), Sqr(d)), C0))));
            IIntegrate(2756, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Dist(Times(Subtract(Times(b, c), Times(a, d)), Power(b, CN1)), Int(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), x), x), Dist(Times(d, Power(b, CN1)), Int(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, m), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(2757, Int(Times(Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrig(Times(Power(Plus(a, Times(b, $($s("§sin"), Plus(e, Times(f, x))))), m), Power(Times(d, $($s("§sin"), Plus(e, Times(f, x)))), n)), x), x), And(FreeQ(List(a, b, d, e, f, n), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IGtQ(m, C0), RationalQ(n))));
            IIntegrate(2758, Int(Times(Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Subtract(Simp(Times(b, Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Times(a, f, Plus(Times(C2, m), C1)), CN1)), x), Dist(Power(Times(Sqr(a), Plus(Times(C2, m), C1)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Subtract(Times(a, m), Times(b, Plus(Times(C2, m), C1), Sin(Plus(e, Times(f, x)))))), x), x)), And(FreeQ(List(a, b, e, f), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), LtQ(m, Negate(C1D2)))));
            IIntegrate(2759, Int(Times(Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(b, f, Plus(m, C2)), CN1)), x)), Dist(Power(Times(b, Plus(m, C2)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Subtract(Times(b, Plus(m, C1)), Times(a, Sin(Plus(e, Times(f, x)))))), x), x)), And(FreeQ(List(a, b, e, f, m), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), Not(LtQ(m, Negate(C1D2))))));
            IIntegrate(2760, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Sqr(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Simp(Times(Subtract(Times(b, c), Times(a, d)), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Power(Times(a, f, Plus(Times(C2, m), C1)), CN1)), x), Dist(Power(Times(a, b, Plus(Times(C2, m), C1)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Simp(Plus(Times(a, c, d, Subtract(m, C1)), Times(b, Plus(Sqr(d), Times(Sqr(c), Plus(m, C1)))), Times(d, Plus(Times(a, d, Subtract(m, C1)), Times(b, c, Plus(m, C2))), Sin(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), LtQ(m, CN1))));
            IIntegrate(2761, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Sqr(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Sqr(d), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(b, f, Plus(m, C2)), CN1)), x)), Dist(Power(Times(b, Plus(m, C2)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Simp(Subtract(Times(b, Plus(Times(Sqr(d), Plus(m, C1)), Times(Sqr(c), Plus(m, C2)))), Times(d, Subtract(Times(a, d), Times(C2, b, c, Plus(m, C2))), Sin(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, m), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), Not(LtQ(m, CN1)))));
            IIntegrate(2762, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Sqr(b), Subtract(Times(b, c), Times(a, d)), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, C2)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(d, f, Plus(n, C1), Plus(Times(b, c), Times(a, d))), CN1)), x)), Dist(Times(Sqr(b), Power(Times(d, Plus(n, C1), Plus(Times(b, c), Times(a, d))), CN1)), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, C2)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1)), Simp(Subtract(Subtract(Times(a, c, Subtract(m, C2)), Times(b, d, Subtract(Subtract(m, Times(C2, n)), C4))), Times(Subtract(Times(b, c, Subtract(m, C1)), Times(a, d, Plus(m, Times(C2, n), C1))), Sin(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), GtQ(m, C1), LtQ(n, CN1), Or(IntegersQ(Times(C2, m), Times(C2, n)), IntegerQ(Plus(m, C1D2)), And(IntegerQ(m), EqQ(c, C0))))));
            IIntegrate(2763, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Sqr(b), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, C2)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(d, f, Plus(m, n)), CN1)), x)), Dist(Power(Times(d, Plus(m, n)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, C2)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Simp(Subtract(Plus(Times(a, b, c, Subtract(m, C2)), Times(Sqr(b), d, Plus(n, C1)), Times(Sqr(a), d, Plus(m, n))), Times(b, Subtract(Times(b, c, Subtract(m, C1)), Times(a, d, Subtract(Plus(Times(C3, m), Times(C2, n)), C2))), Sin(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), GtQ(m, C1), Not(LtQ(n, CN1)), Or(IntegersQ(Times(C2, m), Times(C2, n)), IntegerQ(Plus(m, C1D2)), And(IntegerQ(m), EqQ(c, C0))))));
            IIntegrate(2764, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Subtract(Simp(Times(b, Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Power(Times(a, f, Plus(Times(C2, m), C1)), CN1)), x), Dist(Power(Times(a, b, Plus(Times(C2, m), C1)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Subtract(n, C1)), Simp(Subtract(Subtract(Times(a, d, n), Times(b, c, Plus(m, C1))), Times(b, d, Plus(m, n, C1), Sin(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), LtQ(m, CN1), LtQ(C0, n, C1), Or(IntegersQ(Times(C2, m), Times(C2, n)), And(IntegerQ(m), EqQ(c, C0))))));
            IIntegrate(2765, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Plus(Simp(Times(Subtract(Times(b, c), Times(a, d)), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Subtract(n, C1)), Power(Times(a, f, Plus(Times(C2, m), C1)), CN1)), x), Dist(Power(Times(a, b, Plus(Times(C2, m), C1)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Subtract(n, C2)), Simp(Plus(Times(b, Plus(Times(Sqr(c), Plus(m, C1)), Times(Sqr(d), Subtract(n, C1)))), Times(a, c, d, Plus(m, Negate(n), C1)), Times(d, Plus(Times(a, d, Plus(m, Negate(n), C1)), Times(b, c, Plus(m, n))), Sin(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), LtQ(m, CN1), GtQ(n, C1), Or(IntegersQ(Times(C2, m), Times(C2, n)), And(IntegerQ(m), EqQ(c, C0))))));
            IIntegrate(2766, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Plus(Simp(Times(Sqr(b), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(a, f, Plus(Times(C2, m), C1), Subtract(Times(b, c), Times(a, d))), CN1)), x), Dist(Power(Times(a, Plus(Times(C2, m), C1), Subtract(Times(b, c), Times(a, d))), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Simp(Plus(Times(b, c, Plus(m, C1)), Times(CN1, a, d, Plus(Times(C2, m), n, C2)), Times(b, d, Plus(m, n, C2), Sin(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), LtQ(m, CN1), Not(GtQ(n, C0)), Or(IntegersQ(Times(C2, m), Times(C2, n)), And(IntegerQ(m), EqQ(c, C0))))));
            IIntegrate(2767, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Subtract(Negate(Simp(Times(Subtract(Times(b, c), Times(a, d)), Cos(Plus(e, Times(f, x))), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Subtract(n, C1)), Power(Times(a, f, Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), CN1)), x)), Dist(Times(d, Power(Times(a, b), CN1)), Int(Times(Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Subtract(n, C2)), Simp(Plus(Times(b, d, Subtract(n, C1)), Times(CN1, a, c, n), Times(Subtract(Times(b, c, Subtract(n, C1)), Times(a, d, n)), Sin(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), GtQ(n, C1), Or(IntegerQ(Times(C2, n)), EqQ(c, C0)))));
            IIntegrate(2768, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Sqr(b), Cos(Plus(e, Times(f, x))), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(a, f, Subtract(Times(b, c), Times(a, d)), Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), CN1)), x)), Dist(Times(d, Power(Times(a, Subtract(Times(b, c), Times(a, d))), CN1)), Int(Times(Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Subtract(Times(a, n), Times(b, Plus(n, C1), Sin(Plus(e, Times(f, x)))))), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), LtQ(n, C0), Or(IntegerQ(Times(C2, n)), EqQ(c, C0)))));
            IIntegrate(2769, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, Cos(Plus(e, Times(f, x))), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Power(Times(a, f, Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), CN1)), x)), Dist(Times(d, n, Power(Times(a, b), CN1)), Int(Times(Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Subtract(n, C1)), Subtract(a, Times(b, Sin(Plus(e, Times(f, x)))))), x), x)), And(FreeQ(List(a, b, c, d, e, f, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), Or(IntegerQ(Times(C2, n)), EqQ(c, C0)))));
            IIntegrate(2770, Int(Times(Sqrt(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Plus(Simp(Times(CN2, b, Cos(Plus(e, Times(f, x))), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Power(Times(f, Plus(Times(C2, n), C1), Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))))), CN1)), x), Dist(Times(C2, n, Plus(Times(b, c), Times(a, d)), Power(Times(b, Plus(Times(C2, n), C1)), CN1)), Int(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Subtract(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), GtQ(n, C0), IntegerQ(Times(C2, n)))));
            IIntegrate(2771, Int(Times(Sqrt(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), QQ(-3L, 2L))), x_Symbol),
                    Condition(Simp(Times(CN2, Sqr(b), Cos(Plus(e, Times(f, x))), Power(Times(f, Plus(Times(b, c), Times(a, d)), Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Sqrt(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))))), CN1)), x), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0))));
            IIntegrate(2772, Int(Times(Sqrt(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Plus(Simp(Times(Subtract(Times(b, c), Times(a, d)), Cos(Plus(e, Times(f, x))), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(f, Plus(n, C1), Subtract(Sqr(c), Sqr(d)), Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))))), CN1)), x), Dist(Times(Plus(Times(C2, n), C3), Subtract(Times(b, c), Times(a, d)), Power(Times(C2, b, Plus(n, C1), Subtract(Sqr(c), Sqr(d))), CN1)), Int(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), LtQ(n, CN1), NeQ(Plus(Times(C2, n), C3), C0), IntegerQ(Times(C2, n)))));
            IIntegrate(2773, Int(Times(Sqrt(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Dist(Times(CN2, b, Power(f, CN1)), Subst(Int(Power(Subtract(Plus(Times(b, c), Times(a, d)), Times(d, Sqr(x))), CN1), x), x, Times(b, Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), CN1D2))), x), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0))));
            IIntegrate(2774, Int(Times(Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), CN1D2), Sqrt(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Dist(Times(CN2, Power(f, CN1)), Subst(Int(Power(Subtract(C1, Times(Sqr(x), Power(a, CN1))), CN1D2), x), x, Times(b, Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), CN1D2))), x), And(FreeQ(List(a, b, d, e, f), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), EqQ(d, Times(a, Power(b, CN1))))));
            IIntegrate(2775, Int(Times(Sqrt(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(CN2, b, Power(f, CN1)), Subst(Int(Power(Plus(b, Times(d, Sqr(x))), CN1), x), x, Times(b, Cos(Plus(e, Times(f, x))), Power(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Sqrt(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))))), CN1))), x), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0))));
        }
    }
}
