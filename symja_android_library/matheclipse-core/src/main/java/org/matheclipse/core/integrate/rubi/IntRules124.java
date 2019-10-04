package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcTan;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C1D4;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Cot;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Module;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Pi;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Tan;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandTrig;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FreeFactors;
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
public class IntRules124 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(3101, Int(Times(Power($($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), CN1), Power(Plus(Times($($s("§cos"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), a_DEFAULT), Times(b_DEFAULT, $($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Power(a, CN1), Int(Cot(Plus(c, Times(d, x))), x), x), Dist(Power(a, CN1), Int(Times(Subtract(Times(b, Cos(Plus(c, Times(d, x)))), Times(a, Sin(Plus(c, Times(d, x))))), Power(Plus(Times(a, Cos(Plus(c, Times(d, x)))), Times(b, Sin(Plus(c, Times(d, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d), x), NeQ(Plus(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3102, Int(Times(Power($($s("§cos"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), CN1), Power(Plus(Times($($s("§cos"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), a_DEFAULT), Times(b_DEFAULT, $($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Plus(Dist(Power(b, CN1), Int(Tan(Plus(c, Times(d, x))), x), x), Dist(Power(b, CN1), Int(Times(Subtract(Times(b, Cos(Plus(c, Times(d, x)))), Times(a, Sin(Plus(c, Times(d, x))))), Power(Plus(Times(a, Cos(Plus(c, Times(d, x)))), Times(b, Sin(Plus(c, Times(d, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d), x), NeQ(Plus(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3103, Int(Times(Power($($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), m_), Power(Plus(Times($($s("§cos"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), a_DEFAULT), Times(b_DEFAULT, $($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Sin(Plus(c, Times(d, x))), Plus(m, C1)), Power(Times(a, d, Plus(m, C1)), CN1)), x), Negate(Dist(Times(b, Power(a, CN2)), Int(Power(Sin(Plus(c, Times(d, x))), Plus(m, C1)), x), x)), Dist(Times(Plus(Sqr(a), Sqr(b)), Power(a, CN2)), Int(Times(Power(Sin(Plus(c, Times(d, x))), Plus(m, C2)), Power(Plus(Times(a, Cos(Plus(c, Times(d, x)))), Times(b, Sin(Plus(c, Times(d, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d), x), NeQ(Plus(Sqr(a), Sqr(b)), C0), LtQ(m, CN1))));
            IIntegrate(3104, Int(Times(Power($($s("§cos"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), m_), Power(Plus(Times($($s("§cos"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), a_DEFAULT), Times(b_DEFAULT, $($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Cos(Plus(c, Times(d, x))), Plus(m, C1)), Power(Times(b, d, Plus(m, C1)), CN1)), x)), Negate(Dist(Times(a, Power(b, CN2)), Int(Power(Cos(Plus(c, Times(d, x))), Plus(m, C1)), x), x)), Dist(Times(Plus(Sqr(a), Sqr(b)), Power(b, CN2)), Int(Times(Power(Cos(Plus(c, Times(d, x))), Plus(m, C2)), Power(Plus(Times(a, Cos(Plus(c, Times(d, x)))), Times(b, Sin(Plus(c, Times(d, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d), x), NeQ(Plus(Sqr(a), Sqr(b)), C0), LtQ(m, CN1))));
            IIntegrate(3105, Int(Times(Power($($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), m_), Power(Plus(Times($($s("§cos"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), a_DEFAULT), Times(b_DEFAULT, $($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Plus(Dist(Times(Plus(Sqr(a), Sqr(b)), Power(a, CN2)), Int(Times(Power(Sin(Plus(c, Times(d, x))), Plus(m, C2)), Power(Plus(Times(a, Cos(Plus(c, Times(d, x)))), Times(b, Sin(Plus(c, Times(d, x))))), n)), x), x), Dist(Power(a, CN2), Int(Times(Power(Sin(Plus(c, Times(d, x))), m), Power(Plus(Times(a, Cos(Plus(c, Times(d, x)))), Times(b, Sin(Plus(c, Times(d, x))))), Plus(n, C2))), x), x), Negate(Dist(Times(C2, b, Power(a, CN2)), Int(Times(Power(Sin(Plus(c, Times(d, x))), Plus(m, C1)), Power(Plus(Times(a, Cos(Plus(c, Times(d, x)))), Times(b, Sin(Plus(c, Times(d, x))))), Plus(n, C1))), x), x))), And(FreeQ(List(a, b, c, d), x), NeQ(Plus(Sqr(a), Sqr(b)), C0), LtQ(n, CN1), LtQ(m, CN1))));
            IIntegrate(3106, Int(Times(Power($($s("§cos"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), m_), Power(Plus(Times($($s("§cos"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), a_DEFAULT), Times(b_DEFAULT, $($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Plus(Dist(Times(Plus(Sqr(a), Sqr(b)), Power(b, CN2)), Int(Times(Power(Cos(Plus(c, Times(d, x))), Plus(m, C2)), Power(Plus(Times(a, Cos(Plus(c, Times(d, x)))), Times(b, Sin(Plus(c, Times(d, x))))), n)), x), x), Dist(Power(b, CN2), Int(Times(Power(Cos(Plus(c, Times(d, x))), m), Power(Plus(Times(a, Cos(Plus(c, Times(d, x)))), Times(b, Sin(Plus(c, Times(d, x))))), Plus(n, C2))), x), x), Negate(Dist(Times(C2, a, Power(b, CN2)), Int(Times(Power(Cos(Plus(c, Times(d, x))), Plus(m, C1)), Power(Plus(Times(a, Cos(Plus(c, Times(d, x)))), Times(b, Sin(Plus(c, Times(d, x))))), Plus(n, C1))), x), x))), And(FreeQ(List(a, b, c, d), x), NeQ(Plus(Sqr(a), Sqr(b)), C0), LtQ(n, CN1), LtQ(m, CN1))));
            IIntegrate(3107, Int(Times(Power($($s("§cos"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), m_DEFAULT), Power($($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_DEFAULT), Power(Plus(Times($($s("§cos"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), a_DEFAULT), Times(b_DEFAULT, $($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrig(Times(Power($($s("§cos"), Plus(c, Times(d, x))), m), Power($($s("§sin"), Plus(c, Times(d, x))), n), Power(Plus(Times(a, $($s("§cos"), Plus(c, Times(d, x)))), Times(b, $($s("§sin"), Plus(c, Times(d, x))))), p)), x), x), And(FreeQ(List(a, b, c, d, m, n), x), IGtQ(p, C0))));
            IIntegrate(3108, Int(Times(Power($($s("§cos"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), m_DEFAULT), Power($($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_DEFAULT), Power(Plus(Times($($s("§cos"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), a_DEFAULT), Times(b_DEFAULT, $($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(a, p), Power(b, p)), Int(Times(Power(Cos(Plus(c, Times(d, x))), m), Power(Sin(Plus(c, Times(d, x))), n), Power(Power(Plus(Times(b, Cos(Plus(c, Times(d, x)))), Times(a, Sin(Plus(c, Times(d, x))))), p), CN1)), x), x), And(FreeQ(List(a, b, c, d, m, n), x), EqQ(Plus(Sqr(a), Sqr(b)), C0), ILtQ(p, C0))));
            IIntegrate(3109, Int(Times(Power($($s("§cos"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), m_DEFAULT), Power($($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_DEFAULT), Power(Plus(Times($($s("§cos"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), a_DEFAULT), Times(b_DEFAULT, $($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Plus(Dist(Times(b, Power(Plus(Sqr(a), Sqr(b)), CN1)), Int(Times(Power(Cos(Plus(c, Times(d, x))), m), Power(Sin(Plus(c, Times(d, x))), Subtract(n, C1))), x), x), Dist(Times(a, Power(Plus(Sqr(a), Sqr(b)), CN1)), Int(Times(Power(Cos(Plus(c, Times(d, x))), Subtract(m, C1)), Power(Sin(Plus(c, Times(d, x))), n)), x), x), Negate(Dist(Times(a, b, Power(Plus(Sqr(a), Sqr(b)), CN1)), Int(Times(Power(Cos(Plus(c, Times(d, x))), Subtract(m, C1)), Power(Sin(Plus(c, Times(d, x))), Subtract(n, C1)), Power(Plus(Times(a, Cos(Plus(c, Times(d, x)))), Times(b, Sin(Plus(c, Times(d, x))))), CN1)), x), x))), And(FreeQ(List(a, b, c, d), x), NeQ(Plus(Sqr(a), Sqr(b)), C0), IGtQ(m, C0), IGtQ(n, C0))));
            IIntegrate(3110, Int(Times(Power($($s("§cos"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), m_DEFAULT), Power($($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_DEFAULT), Power(Plus(Times($($s("§cos"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), a_DEFAULT), Times(b_DEFAULT, $($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Int(ExpandTrig(Times(Power($($s("§cos"), Plus(c, Times(d, x))), m), Power($($s("§sin"), Plus(c, Times(d, x))), n), Power(Plus(Times(a, $($s("§cos"), Plus(c, Times(d, x)))), Times(b, $($s("§sin"), Plus(c, Times(d, x))))), CN1)), x), x), And(FreeQ(List(a, b, c, d, m, n), x), IntegersQ(m, n))));
            IIntegrate(3111, Int(Times(Power($($s("§cos"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), m_DEFAULT), Power($($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_DEFAULT), Power(Plus(Times($($s("§cos"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), a_DEFAULT), Times(b_DEFAULT, $($s("§sin"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), p_)), x_Symbol),
                    Condition(Plus(Dist(Times(b, Power(Plus(Sqr(a), Sqr(b)), CN1)), Int(Times(Power(Cos(Plus(c, Times(d, x))), m), Power(Sin(Plus(c, Times(d, x))), Subtract(n, C1)), Power(Plus(Times(a, Cos(Plus(c, Times(d, x)))), Times(b, Sin(Plus(c, Times(d, x))))), Plus(p, C1))), x), x), Dist(Times(a, Power(Plus(Sqr(a), Sqr(b)), CN1)), Int(Times(Power(Cos(Plus(c, Times(d, x))), Subtract(m, C1)), Power(Sin(Plus(c, Times(d, x))), n), Power(Plus(Times(a, Cos(Plus(c, Times(d, x)))), Times(b, Sin(Plus(c, Times(d, x))))), Plus(p, C1))), x), x), Negate(Dist(Times(a, b, Power(Plus(Sqr(a), Sqr(b)), CN1)), Int(Times(Power(Cos(Plus(c, Times(d, x))), Subtract(m, C1)), Power(Sin(Plus(c, Times(d, x))), Subtract(n, C1)), Power(Plus(Times(a, Cos(Plus(c, Times(d, x)))), Times(b, Sin(Plus(c, Times(d, x))))), p)), x), x))), And(FreeQ(List(a, b, c, d), x), NeQ(Plus(Sqr(a), Sqr(b)), C0), IGtQ(m, C0), IGtQ(n, C0), ILtQ(p, C0))));
            IIntegrate(3112, Int(Sqrt(Plus(Times($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), b_DEFAULT), a_, Times(c_DEFAULT, $($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))))), x_Symbol),
                    Condition(Simp(Times(CN2, Subtract(Times(c, Cos(Plus(d, Times(e, x)))), Times(b, Sin(Plus(d, Times(e, x))))), Power(Times(e, Sqrt(Plus(a, Times(b, Cos(Plus(d, Times(e, x)))), Times(c, Sin(Plus(d, Times(e, x))))))), CN1)), x), And(FreeQ(List(a, b, c, d, e), x), EqQ(Subtract(Subtract(Sqr(a), Sqr(b)), Sqr(c)), C0))));
            IIntegrate(3113, Int(Power(Plus(Times($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), b_DEFAULT), a_, Times(c_DEFAULT, $($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), n_), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Subtract(Times(c, Cos(Plus(d, Times(e, x)))), Times(b, Sin(Plus(d, Times(e, x))))), Power(Plus(a, Times(b, Cos(Plus(d, Times(e, x)))), Times(c, Sin(Plus(d, Times(e, x))))), Subtract(n, C1)), Power(Times(e, n), CN1)), x)), Dist(Times(a, Subtract(Times(C2, n), C1), Power(n, CN1)), Int(Power(Plus(a, Times(b, Cos(Plus(d, Times(e, x)))), Times(c, Sin(Plus(d, Times(e, x))))), Subtract(n, C1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ(Subtract(Subtract(Sqr(a), Sqr(b)), Sqr(c)), C0), GtQ(n, C0))));
            IIntegrate(3114, Int(Power(Plus(Times($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), b_DEFAULT), a_, Times(c_DEFAULT, $($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), CN1), x_Symbol),
                    Condition(Negate(Simp(Times(Subtract(c, Times(a, Sin(Plus(d, Times(e, x))))), Power(Times(c, e, Subtract(Times(c, Cos(Plus(d, Times(e, x)))), Times(b, Sin(Plus(d, Times(e, x)))))), CN1)), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ(Subtract(Subtract(Sqr(a), Sqr(b)), Sqr(c)), C0))));
            IIntegrate(3115, Int(Power(Plus(Times($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), b_DEFAULT), a_, Times(c_DEFAULT, $($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), CN1D2), x_Symbol),
                    Condition(Int(Power(Plus(a, Times(Sqrt(Plus(Sqr(b), Sqr(c))), Cos(Subtract(Plus(d, Times(e, x)), ArcTan(b, c))))), CN1D2), x), And(FreeQ(List(a, b, c, d, e), x), EqQ(Subtract(Subtract(Sqr(a), Sqr(b)), Sqr(c)), C0))));
            IIntegrate(3116, Int(Power(Plus(Times($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), b_DEFAULT), a_, Times(c_DEFAULT, $($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), n_), x_Symbol),
                    Condition(Plus(Simp(Times(Subtract(Times(c, Cos(Plus(d, Times(e, x)))), Times(b, Sin(Plus(d, Times(e, x))))), Power(Plus(a, Times(b, Cos(Plus(d, Times(e, x)))), Times(c, Sin(Plus(d, Times(e, x))))), n), Power(Times(a, e, Plus(Times(C2, n), C1)), CN1)), x), Dist(Times(Plus(n, C1), Power(Times(a, Plus(Times(C2, n), C1)), CN1)), Int(Power(Plus(a, Times(b, Cos(Plus(d, Times(e, x)))), Times(c, Sin(Plus(d, Times(e, x))))), Plus(n, C1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ(Subtract(Subtract(Sqr(a), Sqr(b)), Sqr(c)), C0), LtQ(n, CN1))));
            IIntegrate(3117, Int(Sqrt(Plus(Times($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), b_DEFAULT), a_, Times(c_DEFAULT, $($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))))), x_Symbol),
                    Condition(Dist(Times(b, Power(Times(c, e), CN1)), Subst(Int(Times(Sqrt(Plus(a, x)), Power(x, CN1)), x), x, Plus(Times(b, Cos(Plus(d, Times(e, x)))), Times(c, Sin(Plus(d, Times(e, x)))))), x), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Sqr(b), Sqr(c)), C0))));
            IIntegrate(3118, Int(Sqrt(Plus(Times($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), b_DEFAULT), a_, Times(c_DEFAULT, $($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))))), x_Symbol),
                    Condition(Int(Sqrt(Plus(a, Times(Sqrt(Plus(Sqr(b), Sqr(c))), Cos(Subtract(Plus(d, Times(e, x)), ArcTan(b, c)))))), x), And(FreeQ(List(a, b, c, d, e), x), NeQ(Plus(Sqr(b), Sqr(c)), C0), GtQ(Plus(a, Sqrt(Plus(Sqr(b), Sqr(c)))), C0))));
            IIntegrate(3119, Int(Sqrt(Plus(Times($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), b_DEFAULT), a_, Times(c_DEFAULT, $($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))))), x_Symbol),
                    Condition(Dist(Times(Sqrt(Plus(a, Times(b, Cos(Plus(d, Times(e, x)))), Times(c, Sin(Plus(d, Times(e, x)))))), Power(Times(Plus(a, Times(b, Cos(Plus(d, Times(e, x)))), Times(c, Sin(Plus(d, Times(e, x))))), Power(Plus(a, Sqrt(Plus(Sqr(b), Sqr(c)))), CN1)), CN1D2)), Int(Sqrt(Plus(Times(a, Power(Plus(a, Sqrt(Plus(Sqr(b), Sqr(c)))), CN1)), Times(Sqrt(Plus(Sqr(b), Sqr(c))), Cos(Subtract(Plus(d, Times(e, x)), ArcTan(b, c))), Power(Plus(a, Sqrt(Plus(Sqr(b), Sqr(c)))), CN1)))), x), x), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Subtract(Sqr(a), Sqr(b)), Sqr(c)), C0), NeQ(Plus(Sqr(b), Sqr(c)), C0), Not(GtQ(Plus(a, Sqrt(Plus(Sqr(b), Sqr(c)))), C0)))));
            IIntegrate(3120, Int(Power(Plus(Times($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), b_DEFAULT), a_, Times(c_DEFAULT, $($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), n_), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Subtract(Times(c, Cos(Plus(d, Times(e, x)))), Times(b, Sin(Plus(d, Times(e, x))))), Power(Plus(a, Times(b, Cos(Plus(d, Times(e, x)))), Times(c, Sin(Plus(d, Times(e, x))))), Subtract(n, C1)), Power(Times(e, n), CN1)), x)), Dist(Power(n, CN1), Int(Times(Simp(Plus(Times(n, Sqr(a)), Times(Subtract(n, C1), Plus(Sqr(b), Sqr(c))), Times(a, b, Subtract(Times(C2, n), C1), Cos(Plus(d, Times(e, x)))), Times(a, c, Subtract(Times(C2, n), C1), Sin(Plus(d, Times(e, x))))), x), Power(Plus(a, Times(b, Cos(Plus(d, Times(e, x)))), Times(c, Sin(Plus(d, Times(e, x))))), Subtract(n, C2))), x), x)), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Subtract(Sqr(a), Sqr(b)), Sqr(c)), C0), GtQ(n, C1))));
            IIntegrate(3121, Int(Power(Plus(Times($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), b_DEFAULT), a_, Times(c_DEFAULT, $($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), CN1), x_Symbol),
                    Condition(Module(List(Set(f, FreeFactors(Cot(Times(C1D2, Plus(d, Times(e, x)))), x))), Negate(Dist(Times(f, Power(e, CN1)), Subst(Int(Power(Plus(a, Times(c, f, x)), CN1), x), x, Times(Cot(Times(C1D2, Plus(d, Times(e, x)))), Power(f, CN1))), x))), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(a, b), C0))));
            IIntegrate(3122, Int(Power(Plus(Times($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), b_DEFAULT), a_, Times(c_DEFAULT, $($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), CN1), x_Symbol),
                    Condition(Module(List(Set(f, FreeFactors(Tan(Plus(Times(C1D2, Plus(d, Times(e, x))), Times(C1D4, Pi))), x))), Dist(Times(f, Power(e, CN1)), Subst(Int(Power(Plus(a, Times(b, f, x)), CN1), x), x, Times(Tan(Plus(Times(C1D2, Plus(d, Times(e, x))), Times(C1D4, Pi))), Power(f, CN1))), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(a, c), C0))));
            IIntegrate(3123, Int(Power(Plus(Times($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), b_DEFAULT), a_, Times(c_DEFAULT, $($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), CN1), x_Symbol),
                    Condition(Module(List(Set(f, FreeFactors(Cot(Plus(Times(C1D2, Plus(d, Times(e, x))), Times(C1D4, Pi))), x))), Negate(Dist(Times(f, Power(e, CN1)), Subst(Int(Power(Plus(a, Times(b, f, x)), CN1), x), x, Times(Cot(Plus(Times(C1D2, Plus(d, Times(e, x))), Times(C1D4, Pi))), Power(f, CN1))), x))), And(FreeQ(List(a, b, c, d, e), x), EqQ(Subtract(a, c), C0), NeQ(Subtract(a, b), C0))));
            IIntegrate(3124, Int(Power(Plus(Times($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), b_DEFAULT), a_, Times(c_DEFAULT, $($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), CN1), x_Symbol),
                    Condition(Module(List(Set(f, FreeFactors(Tan(Times(C1D2, Plus(d, Times(e, x)))), x))), Dist(Times(C2, f, Power(e, CN1)), Subst(Int(Power(Plus(a, b, Times(C2, c, f, x), Times(Subtract(a, b), Sqr(f), Sqr(x))), CN1), x), x, Times(Tan(Times(C1D2, Plus(d, Times(e, x)))), Power(f, CN1))), x)), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Subtract(Sqr(a), Sqr(b)), Sqr(c)), C0))));
            IIntegrate(3125, Int(Power(Plus(Times($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), b_DEFAULT), a_, Times(c_DEFAULT, $($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), CN1D2), x_Symbol),
                    Condition(Dist(Times(b, Power(Times(c, e), CN1)), Subst(Int(Power(Times(x, Sqrt(Plus(a, x))), CN1), x), x, Plus(Times(b, Cos(Plus(d, Times(e, x)))), Times(c, Sin(Plus(d, Times(e, x)))))), x), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Sqr(b), Sqr(c)), C0))));
        }
    }
}
