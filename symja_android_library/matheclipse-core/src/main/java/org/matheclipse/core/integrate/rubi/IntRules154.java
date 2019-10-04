package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C5;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Cot;
import static org.matheclipse.core.expression.F.Csc;
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
import static org.matheclipse.core.expression.F.Sec;
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
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules154 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(3851, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), n_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), CN1)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(d, C3), Cot(Plus(e, Times(f, x))), Power(Times(d, Csc(Plus(e, Times(f, x)))), Subtract(n, C3)), Power(Times(b, f, Subtract(n, C2)), CN1)), x)), Dist(Times(Power(d, C3), Power(Times(b, Subtract(n, C2)), CN1)), Int(Times(Power(Times(d, Csc(Plus(e, Times(f, x)))), Subtract(n, C3)), Simp(Subtract(Plus(Times(a, Subtract(n, C3)), Times(b, Subtract(n, C3), Csc(Plus(e, Times(f, x))))), Times(a, Subtract(n, C2), Sqr(Csc(Plus(e, Times(f, x)))))), x), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1)), x), x)), And(FreeQ(List(a, b, d, e, f), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), GtQ(n, C3))));
            IIntegrate(3852, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), CN1D2), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), CN1)), x_Symbol),
                    Condition(Plus(Dist(Times(Sqr(b), Power(Times(Sqr(a), Sqr(d)), CN1)), Int(Times(Power(Times(d, Csc(Plus(e, Times(f, x)))), QQ(3L, 2L)), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1)), x), x), Dist(Power(a, CN2), Int(Times(Subtract(a, Times(b, Csc(Plus(e, Times(f, x))))), Power(Times(d, Csc(Plus(e, Times(f, x)))), CN1D2)), x), x)), And(FreeQ(List(a, b, d, e, f), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3853, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), n_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(Cot(Plus(e, Times(f, x))), Power(Times(d, Csc(Plus(e, Times(f, x)))), n), Power(Times(a, f, n), CN1)), x), Dist(Power(Times(a, d, n), CN1), Int(Times(Power(Times(d, Csc(Plus(e, Times(f, x)))), Plus(n, C1)), Simp(Subtract(Subtract(Times(b, n), Times(a, Plus(n, C1), Csc(Plus(e, Times(f, x))))), Times(b, Plus(n, C1), Sqr(Csc(Plus(e, Times(f, x)))))), x), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1)), x), x)), And(FreeQ(List(a, b, d, e, f), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), LeQ(n, CN1), IntegerQ(Times(C2, n)))));
            IIntegrate(3854, Int(Times(Sqrt(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT)), Sqrt(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_))), x_Symbol),
                    Condition(Plus(Dist(a, Int(Times(Sqrt(Times(d, Csc(Plus(e, Times(f, x))))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2)), x), x), Dist(Times(b, Power(d, CN1)), Int(Times(Power(Times(d, Csc(Plus(e, Times(f, x)))), QQ(3L, 2L)), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2)), x), x)), And(FreeQ(List(a, b, d, e, f), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3855, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), n_), Sqrt(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_))), x_Symbol),
                    Condition(Plus(Simp(Times(CN2, d, Cos(Plus(e, Times(f, x))), Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Power(Times(d, Csc(Plus(e, Times(f, x)))), Subtract(n, C1)), Power(Times(f, Subtract(Times(C2, n), C1)), CN1)), x), Dist(Times(Sqr(d), Power(Subtract(Times(C2, n), C1), CN1)), Int(Times(Power(Times(d, Csc(Plus(e, Times(f, x)))), Subtract(n, C2)), Simp(Plus(Times(C2, a, Subtract(n, C2)), Times(b, Subtract(Times(C2, n), C3), Csc(Plus(e, Times(f, x)))), Times(a, Sqr(Csc(Plus(e, Times(f, x)))))), x), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2)), x), x)), And(FreeQ(List(a, b, d, e, f), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), GtQ(n, C1), IntegerQ(Times(C2, n)))));
            IIntegrate(3856, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), CN1D2), Sqrt(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_))), x_Symbol),
                    Condition(Dist(Times(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Power(Times(Sqrt(Times(d, Csc(Plus(e, Times(f, x))))), Sqrt(Plus(b, Times(a, Sin(Plus(e, Times(f, x))))))), CN1)), Int(Sqrt(Plus(b, Times(a, Sin(Plus(e, Times(f, x)))))), x), x), And(FreeQ(List(a, b, d, e, f), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3857, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), n_), Sqrt(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_))), x_Symbol),
                    Condition(Subtract(Simp(Times(Cot(Plus(e, Times(f, x))), Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Power(Times(d, Csc(Plus(e, Times(f, x)))), n), Power(Times(f, n), CN1)), x), Dist(Power(Times(C2, d, n), CN1), Int(Times(Power(Times(d, Csc(Plus(e, Times(f, x)))), Plus(n, C1)), Simp(Subtract(Subtract(b, Times(C2, a, Plus(n, C1), Csc(Plus(e, Times(f, x))))), Times(b, Plus(Times(C2, n), C3), Sqr(Csc(Plus(e, Times(f, x)))))), x), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2)), x), x)), And(FreeQ(List(a, b, d, e, f), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), LeQ(n, CN1), IntegerQ(Times(C2, n)))));
            IIntegrate(3858, Int(Times(Sqrt(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Times(d, Csc(Plus(e, Times(f, x))))), Sqrt(Plus(b, Times(a, Sin(Plus(e, Times(f, x)))))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2)), Int(Power(Plus(b, Times(a, Sin(Plus(e, Times(f, x))))), CN1D2), x), x), And(FreeQ(List(a, b, d, e, f), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3859, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), QQ(3L, 2L)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), CN1D2)), x_Symbol),
                    Condition(Dist(Times(d, Sqrt(Times(d, Csc(Plus(e, Times(f, x))))), Sqrt(Plus(b, Times(a, Sin(Plus(e, Times(f, x)))))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2)), Int(Power(Times(Sin(Plus(e, Times(f, x))), Sqrt(Plus(b, Times(a, Sin(Plus(e, Times(f, x))))))), CN1), x), x), And(FreeQ(List(a, b, d, e, f), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3860, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), n_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), CN1D2)), x_Symbol),
                    Condition(Plus(Simp(Times(CN2, Sqr(d), Cos(Plus(e, Times(f, x))), Power(Times(d, Csc(Plus(e, Times(f, x)))), Subtract(n, C2)), Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Power(Times(b, f, Subtract(Times(C2, n), C3)), CN1)), x), Dist(Times(Power(d, C3), Power(Times(b, Subtract(Times(C2, n), C3)), CN1)), Int(Times(Power(Times(d, Csc(Plus(e, Times(f, x)))), Subtract(n, C3)), Simp(Subtract(Plus(Times(C2, a, Subtract(n, C3)), Times(b, Subtract(Times(C2, n), C5), Csc(Plus(e, Times(f, x))))), Times(C2, a, Subtract(n, C2), Sqr(Csc(Plus(e, Times(f, x)))))), x), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2)), x), x)), And(FreeQ(List(a, b, d, e, f), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), GtQ(n, C2), IntegerQ(Times(C2, n)))));
            IIntegrate(3861, Int(Times(Power($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), CN1), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), CN1D2)), x_Symbol),
                    Condition(Subtract(Negate(Simp(Times(Cos(Plus(e, Times(f, x))), Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Power(Times(a, f), CN1)), x)), Dist(Times(b, Power(Times(C2, a), CN1)), Int(Times(Plus(C1, Sqr(Csc(Plus(e, Times(f, x))))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2)), x), x)), And(FreeQ(List(a, b, e, f), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3862, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), CN1D2), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), CN1D2)), x_Symbol),
                    Condition(Subtract(Dist(Power(a, CN1), Int(Times(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Power(Times(d, Csc(Plus(e, Times(f, x)))), CN1D2)), x), x), Dist(Times(b, Power(Times(a, d), CN1)), Int(Times(Sqrt(Times(d, Csc(Plus(e, Times(f, x))))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2)), x), x)), And(FreeQ(List(a, b, d, e, f), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3863, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), n_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), CN1D2)), x_Symbol),
                    Condition(Plus(Simp(Times(Cos(Plus(e, Times(f, x))), Power(Times(d, Csc(Plus(e, Times(f, x)))), Plus(n, C1)), Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Power(Times(a, d, f, n), CN1)), x), Dist(Power(Times(C2, a, d, n), CN1), Int(Times(Power(Times(d, Csc(Plus(e, Times(f, x)))), Plus(n, C1)), Simp(Plus(Times(CN1, b, Plus(Times(C2, n), C1)), Times(C2, a, Plus(n, C1), Csc(Plus(e, Times(f, x)))), Times(b, Plus(Times(C2, n), C3), Sqr(Csc(Plus(e, Times(f, x)))))), x), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2)), x), x)), And(FreeQ(List(a, b, d, e, f), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), LtQ(n, CN1), IntegerQ(Times(C2, n)))));
            IIntegrate(3864, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), n_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), QQ(3L, 2L))), x_Symbol),
                    Condition(Plus(Simp(Times(a, Cot(Plus(e, Times(f, x))), Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Power(Times(d, Csc(Plus(e, Times(f, x)))), n), Power(Times(f, n), CN1)), x), Dist(Power(Times(C2, d, n), CN1), Int(Times(Power(Times(d, Csc(Plus(e, Times(f, x)))), Plus(n, C1)), Simp(Plus(Times(a, b, Subtract(Times(C2, n), C1)), Times(C2, Plus(Times(Sqr(b), n), Times(Sqr(a), Plus(n, C1))), Csc(Plus(e, Times(f, x)))), Times(a, b, Plus(Times(C2, n), C3), Sqr(Csc(Plus(e, Times(f, x)))))), x), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2)), x), x)), And(FreeQ(List(a, b, d, e, f), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), LeQ(n, CN1), IntegersQ(Times(C2, n)))));
            IIntegrate(3865, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), n_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(d, C3), Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(d, Csc(Plus(e, Times(f, x)))), Subtract(n, C3)), Power(Times(b, f, Subtract(Plus(m, n), C1)), CN1)), x)), Dist(Times(Power(d, C3), Power(Times(b, Subtract(Plus(m, n), C1)), CN1)), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Power(Times(d, Csc(Plus(e, Times(f, x)))), Subtract(n, C3)), Simp(Subtract(Plus(Times(a, Subtract(n, C3)), Times(b, Subtract(Plus(m, n), C2), Csc(Plus(e, Times(f, x))))), Times(a, Subtract(n, C2), Sqr(Csc(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, d, e, f, m), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), GtQ(n, C3), Or(IntegerQ(n), IntegersQ(Times(C2, m), Times(C2, n))), Not(IGtQ(m, C2)))));
            IIntegrate(3866, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), n_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, d, Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Times(d, Csc(Plus(e, Times(f, x)))), Subtract(n, C1)), Power(Times(f, Subtract(Plus(m, n), C1)), CN1)), x)), Dist(Times(d, Power(Subtract(Plus(m, n), C1), CN1)), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Subtract(m, C2)), Power(Times(d, Csc(Plus(e, Times(f, x)))), Subtract(n, C1)), Simp(Plus(Times(a, b, Subtract(n, C1)), Times(Plus(Times(Sqr(b), Subtract(Plus(m, n), C2)), Times(Sqr(a), Subtract(Plus(m, n), C1))), Csc(Plus(e, Times(f, x)))), Times(a, b, Subtract(Plus(Times(C2, m), n), C2), Sqr(Csc(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, d, e, f), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), LtQ(C0, m, C2), LtQ(C0, n, C3), NeQ(Subtract(Plus(m, n), C1), C0), Or(IntegerQ(m), IntegersQ(Times(C2, m), Times(C2, n))))));
            IIntegrate(3867, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), n_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Sqr(d), Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Power(Times(d, Csc(Plus(e, Times(f, x)))), Subtract(n, C2)), Power(Times(f, Subtract(Plus(m, n), C1)), CN1)), x)), Dist(Times(Sqr(d), Power(Times(b, Subtract(Plus(m, n), C1)), CN1)), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Times(d, Csc(Plus(e, Times(f, x)))), Subtract(n, C2)), Simp(Plus(Times(a, b, Subtract(n, C2)), Times(Sqr(b), Subtract(Plus(m, n), C2), Csc(Plus(e, Times(f, x)))), Times(a, b, m, Sqr(Csc(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, d, e, f), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), LtQ(CN1, m, C2), LtQ(C1, n, C3), NeQ(Subtract(Plus(m, n), C1), C0), Or(IntegerQ(n), IntegersQ(Times(C2, m), Times(C2, n))))));
            IIntegrate(3868, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), CN1D2), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), QQ(3L, 2L))), x_Symbol),
                    Condition(Plus(Dist(a, Int(Times(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Power(Times(d, Csc(Plus(e, Times(f, x)))), CN1D2)), x), x), Dist(Times(b, Power(d, CN1)), Int(Times(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Sqrt(Times(d, Csc(Plus(e, Times(f, x)))))), x), x)), And(FreeQ(List(a, b, d, e, f), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3869, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), n_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Sin(Plus(e, Times(f, x))), n), Power(Times(d, Csc(Plus(e, Times(f, x)))), n)), Int(Times(Power(Plus(b, Times(a, Sin(Plus(e, Times(f, x))))), m), Power(Power(Sin(Plus(e, Times(f, x))), Plus(m, n)), CN1)), x), x), And(FreeQ(List(a, b, d, e, f, n), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), IntegerQ(m))));
            IIntegrate(3870, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), n_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Times(d, Csc(Plus(e, Times(f, x)))), n), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m)), x), FreeQ(List(a, b, d, e, f, m, n), x)));
            IIntegrate(3871, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Times(d, Cos(Plus(e, Times(f, x)))), FracPart(m)), Power(Times(Sec(Plus(e, Times(f, x))), Power(d, CN1)), FracPart(m))), Int(Times(Power(Plus(a, Times(b, Sec(Plus(e, Times(f, x))))), p), Power(Power(Times(Sec(Plus(e, Times(f, x))), Power(d, CN1)), m), CN1)), x), x), And(FreeQ(List(a, b, d, e, f, m, p), x), Not(IntegerQ(m)), Not(IntegerQ(p)))));
            IIntegrate(3872, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), p), Power(Plus(b, Times(a, Sin(Plus(e, Times(f, x))))), m), Power(Power(Sin(Plus(e, Times(f, x))), m), CN1)), x), And(FreeQ(List(a, b, e, f, g, p), x), IntegerQ(m))));
            IIntegrate(3873, Int(Times(Power($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), p_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_)), x_Symbol),
                    Condition(Negate(Dist(Power(Times(f, Power(b, Subtract(p, C1))), CN1), Subst(Int(Times(Power(Plus(Negate(a), Times(b, x)), Times(C1D2, Subtract(p, C1))), Power(Plus(a, Times(b, x)), Plus(m, Times(C1D2, Subtract(p, C1)))), Power(Power(x, Plus(p, C1)), CN1)), x), x, Csc(Plus(e, Times(f, x)))), x)), And(FreeQ(List(a, b, e, f, m), x), IntegerQ(Times(C1D2, Subtract(p, C1))), EqQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3874, Int(Times(Power($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), p_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_)), x_Symbol),
                    Condition(Negate(Dist(Power(f, CN1), Subst(Int(Times(Power(Plus(CN1, x), Times(C1D2, Subtract(p, C1))), Power(Plus(C1, x), Times(C1D2, Subtract(p, C1))), Power(Plus(a, Times(b, x)), m), Power(Power(x, Plus(p, C1)), CN1)), x), x, Csc(Plus(e, Times(f, x)))), x)), And(FreeQ(List(a, b, e, f, m), x), IntegerQ(Times(C1D2, Subtract(p, C1))), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3875, Int(Times(Power($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), CN2), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_)), x_Symbol),
                    Condition(Plus(Simp(Times(Tan(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Power(f, CN1)), x), Dist(Times(b, m), Int(Times(Csc(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Subtract(m, C1))), x), x)), FreeQ(List(a, b, e, f, m), x)));
        }
    }
}
