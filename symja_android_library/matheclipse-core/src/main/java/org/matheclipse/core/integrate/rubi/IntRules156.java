package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.CN4;
import static org.matheclipse.core.expression.F.CN8;
import static org.matheclipse.core.expression.F.Condition;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
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
public class IntRules156 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(3901, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sec"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), n_DEFAULT), Power(Times(e_DEFAULT, Power($($s("§tan"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), p_)), m_)), x_Symbol),
                    Condition(Dist(Times(Power(Times(e, Power(Tan(Plus(c, Times(d, x))), p)), m), Power(Power(Times(e, Tan(Plus(c, Times(d, x)))), Times(m, p)), CN1)), Int(Times(Power(Times(e, Tan(Plus(c, Times(d, x)))), Times(m, p)), Power(Plus(a, Times(b, Sec(Plus(c, Times(d, x))))), n)), x), x), And(FreeQ(List(a, b, c, d, e, m, n, p), x), Not(IntegerQ(m)))));
            IIntegrate(3902, Int(Times(Power(Times(Power($($s("§cot"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), p_), e_DEFAULT), m_), Power(Plus(Times($($s("§csc"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Times(e, Power(Cot(Plus(c, Times(d, x))), p)), m), Power(Power(Times(e, Cot(Plus(c, Times(d, x)))), Times(m, p)), CN1)), Int(Times(Power(Times(e, Cot(Plus(c, Times(d, x)))), Times(m, p)), Power(Plus(a, Times(b, Csc(Plus(c, Times(d, x))))), n)), x), x), And(FreeQ(List(a, b, c, d, e, m, n, p), x), Not(IntegerQ(m)))));
            IIntegrate(3903, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_)), x_Symbol),
                    Condition(Dist(Power(c, n), Int(ExpandTrig(Power(Plus(C1, Times(d, $($s("§csc"), Plus(e, Times(f, x))), Power(c, CN1))), n), Power(Plus(a, Times(b, $($s("§csc"), Plus(e, Times(f, x))))), m), x), x), x), And(FreeQ(List(a, b, c, d, e, f, n), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IGtQ(m, C0), ILtQ(n, C0), LtQ(Plus(m, n), C2))));
            IIntegrate(3904, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Times(CN1, a, c), m), Int(Times(Power(Cot(Plus(e, Times(f, x))), Times(C2, m)), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), Subtract(n, m))), x), x), And(FreeQ(List(a, b, c, d, e, f, n), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegerQ(m), RationalQ(n), Not(And(IntegerQ(n), GtQ(Subtract(m, n), C0))))));
            IIntegrate(3905, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), m_)), x_Symbol),
                    Condition(Dist(Times(Power(Times(CN1, a, c), Plus(m, C1D2)), Cot(Plus(e, Times(f, x))), Power(Times(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Sqrt(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))))), CN1)), Int(Power(Cot(Plus(e, Times(f, x))), Times(C2, m)), x), x), And(FreeQ(List(a, b, c, d, e, f, m), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegerQ(Plus(m, C1D2)))));
            IIntegrate(3906, Int(Times(Sqrt(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(C2, a, c, Cot(Plus(e, Times(f, x))), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), Subtract(n, C1)), Power(Times(f, Subtract(Times(C2, n), C1), Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))))), CN1)), x), Dist(c, Int(Times(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), Subtract(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), GtQ(n, C1D2))));
            IIntegrate(3907, Int(Times(Sqrt(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_)), x_Symbol),
                    Condition(Plus(Simp(Times(CN2, a, Cot(Plus(e, Times(f, x))), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), n), Power(Times(f, Plus(Times(C2, n), C1), Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))))), CN1)), x), Dist(Power(c, CN1), Int(Times(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), Plus(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), LtQ(n, Negate(C1D2)))));
            IIntegrate(3908, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), QQ(3L, 2L)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(CN4, Sqr(a), Cot(Plus(e, Times(f, x))), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), n), Power(Times(f, Plus(Times(C2, n), C1), Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))))), CN1)), x), Dist(Times(a, Power(c, CN1)), Int(Times(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), Plus(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), LtQ(n, Negate(C1D2)))));
            IIntegrate(3909, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), QQ(3L, 2L)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(CN2, Sqr(a), Cot(Plus(e, Times(f, x))), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), n), Power(Times(f, Plus(Times(C2, n), C1), Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))))), CN1)), x), Dist(a, Int(Times(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), n)), x), x)), And(FreeQ(List(a, b, c, d, e, f, n), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), Not(LeQ(n, Negate(C1D2))))));
            IIntegrate(3910, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), QQ(5L, 2L)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(CN8, Power(a, C3), Cot(Plus(e, Times(f, x))), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), n), Power(Times(f, Plus(Times(C2, n), C1), Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))))), CN1)), x), Dist(Times(Sqr(a), Power(c, CN2)), Int(Times(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), Plus(n, C2))), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), LtQ(n, Negate(C1D2)))));
            IIntegrate(3911, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_)), x_Symbol),
                    Condition(Negate(Dist(Times(a, c, Cot(Plus(e, Times(f, x))), Power(Times(f, Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Sqrt(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))))), CN1)), Subst(Int(Times(Power(Plus(b, Times(a, x)), Subtract(m, C1D2)), Power(Plus(d, Times(c, x)), Subtract(n, C1D2)), Power(Power(x, Plus(m, n)), CN1)), x), x, Sin(Plus(e, Times(f, x)))), x)), And(FreeQ(List(a, b, c, d, e, f), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegerQ(Subtract(m, C1D2)), EqQ(Plus(m, n), C0))));
            IIntegrate(3912, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(a, c, Cot(Plus(e, Times(f, x))), Power(Times(f, Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Sqrt(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))))), CN1)), Subst(Int(Times(Power(Plus(a, Times(b, x)), Subtract(m, C1D2)), Power(Plus(c, Times(d, x)), Subtract(n, C1D2)), Power(x, CN1)), x), x, Csc(Plus(e, Times(f, x)))), x), And(FreeQ(List(a, b, c, d, e, f, m, n), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3913, Int(Times(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_)), x_Symbol),
                    Condition(Plus(Simp(Times(a, c, x), x), Dist(Times(b, d), Int(Sqr(Csc(Plus(e, Times(f, x)))), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), EqQ(Plus(Times(b, c), Times(a, d)), C0))));
            IIntegrate(3914, Int(Times(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_)), x_Symbol),
                    Condition(Plus(Simp(Times(a, c, x), x), Dist(Times(b, d), Int(Sqr(Csc(Plus(e, Times(f, x)))), x), x), Dist(Plus(Times(b, c), Times(a, d)), Int(Csc(Plus(e, Times(f, x))), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Plus(Times(b, c), Times(a, d)), C0))));
            IIntegrate(3915, Int(Times(Sqrt(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_)), Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_)), x_Symbol),
                    Condition(Plus(Dist(c, Int(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), x), x), Dist(d, Int(Times(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Csc(Plus(e, Times(f, x)))), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3916, Int(Times(Sqrt(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_)), Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_)), x_Symbol),
                    Condition(Plus(Dist(Times(a, c), Int(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2), x), x), Int(Times(Csc(Plus(e, Times(f, x))), Plus(Times(b, c), Times(a, d), Times(b, d, Csc(Plus(e, Times(f, x))))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2)), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3917, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_), Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, d, Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Times(f, m), CN1)), x)), Dist(Power(m, CN1), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Subtract(m, C1)), Simp(Plus(Times(a, c, m), Times(Plus(Times(b, c, m), Times(a, d, Subtract(Times(C2, m), C1))), Csc(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), GtQ(m, C1), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegerQ(Times(C2, m)))));
            IIntegrate(3918, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_), Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, d, Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Times(f, m), CN1)), x)), Dist(Power(m, CN1), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Subtract(m, C2)), Simp(Plus(Times(Sqr(a), c, m), Times(Plus(Times(Sqr(b), d, Subtract(m, C1)), Times(C2, a, b, c, m), Times(Sqr(a), d, m)), Csc(Plus(e, Times(f, x)))), Times(b, Plus(Times(b, c, m), Times(a, d, Subtract(Times(C2, m), C1))), Sqr(Csc(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), GtQ(m, C1), NeQ(Subtract(Sqr(a), Sqr(b)), C0), IntegerQ(Times(C2, m)))));
            IIntegrate(3919, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), CN1), Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_)), x_Symbol),
                    Condition(Subtract(Simp(Times(c, x, Power(a, CN1)), x), Dist(Times(Subtract(Times(b, c), Times(a, d)), Power(a, CN1)), Int(Times(Csc(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0))));
            IIntegrate(3920, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), CN1D2), Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_)), x_Symbol),
                    Condition(Subtract(Dist(Times(c, Power(a, CN1)), Int(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), x), x), Dist(Times(Subtract(Times(b, c), Times(a, d)), Power(a, CN1)), Int(Times(Csc(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3921, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), CN1D2), Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_)), x_Symbol),
                    Condition(Plus(Dist(c, Int(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2), x), x), Dist(d, Int(Times(Csc(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3922, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_), Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Subtract(Times(b, c), Times(a, d)), Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Power(Times(b, f, Plus(Times(C2, m), C1)), CN1)), x)), Dist(Power(Times(Sqr(a), Plus(Times(C2, m), C1)), CN1), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Simp(Subtract(Times(a, c, Plus(Times(C2, m), C1)), Times(Subtract(Times(b, c), Times(a, d)), Plus(m, C1), Csc(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), LtQ(m, CN1), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegerQ(Times(C2, m)))));
            IIntegrate(3923, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_), Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_)), x_Symbol),
                    Condition(Plus(Simp(Times(b, Subtract(Times(b, c), Times(a, d)), Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(a, f, Plus(m, C1), Subtract(Sqr(a), Sqr(b))), CN1)), x), Dist(Power(Times(a, Plus(m, C1), Subtract(Sqr(a), Sqr(b))), CN1), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Simp(Plus(Times(c, Subtract(Sqr(a), Sqr(b)), Plus(m, C1)), Times(CN1, a, Subtract(Times(b, c), Times(a, d)), Plus(m, C1), Csc(Plus(e, Times(f, x)))), Times(b, Subtract(Times(b, c), Times(a, d)), Plus(m, C2), Sqr(Csc(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), LtQ(m, CN1), NeQ(Subtract(Sqr(a), Sqr(b)), C0), IntegerQ(Times(C2, m)))));
            IIntegrate(3924, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_), Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_)), x_Symbol),
                    Condition(Plus(Dist(c, Int(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), x), x), Dist(d, Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Csc(Plus(e, Times(f, x)))), x), x)), And(FreeQ(List(a, b, c, d, e, f, m), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), Not(IntegerQ(Times(C2, m))))));
            IIntegrate(3925, Int(Times(Sqrt(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Power(c, CN1), Int(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), x), x), Dist(Times(d, Power(c, CN1)), Int(Times(Csc(Plus(e, Times(f, x))), Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), Or(EqQ(Subtract(Sqr(a), Sqr(b)), C0), EqQ(Subtract(Sqr(c), Sqr(d)), C0)))));
        }
    }
}
