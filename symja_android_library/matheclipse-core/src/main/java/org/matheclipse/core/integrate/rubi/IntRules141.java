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
import static org.matheclipse.core.expression.F.CI;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Tan;
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
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PerfectSquareQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RemoveContent;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules141 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(3526, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Subtract(Times(b, c), Times(a, d)), Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), m), Power(Times(C2, a, f, m), CN1)), x)), Dist(Times(Plus(Times(b, c), Times(a, d)), Power(Times(C2, a, b), CN1)), Int(Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), Plus(m, C1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(Sqr(a), Sqr(b)), C0), LtQ(m, C0))));
            IIntegrate(3527, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Simp(Times(d, Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), m), Power(Times(f, m), CN1)), x), Dist(Times(Plus(Times(b, c), Times(a, d)), Power(b, CN1)), Int(Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), m), x), x)), And(FreeQ(List(a, b, c, d, e, f, m), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(Sqr(a), Sqr(b)), C0), Not(LtQ(m, C0)))));
            IIntegrate(3528, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Simp(Times(d, Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), m), Power(Times(f, m), CN1)), x), Int(Times(Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), Subtract(m, C1)), Simp(Plus(Times(a, c), Times(CN1, b, d), Times(Plus(Times(b, c), Times(a, d)), Tan(Plus(e, Times(f, x))))), x)), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Plus(Sqr(a), Sqr(b)), C0), GtQ(m, C0))));
            IIntegrate(3529, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Simp(Times(Subtract(Times(b, c), Times(a, d)), Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(f, Plus(m, C1), Plus(Sqr(a), Sqr(b))), CN1)), x), Dist(Power(Plus(Sqr(a), Sqr(b)), CN1), Int(Times(Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), Plus(m, C1)), Simp(Subtract(Plus(Times(a, c), Times(b, d)), Times(Subtract(Times(b, c), Times(a, d)), Tan(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Plus(Sqr(a), Sqr(b)), C0), LtQ(m, CN1))));
            IIntegrate(3530, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1), Plus(c_, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Simp(Times(c, Log(RemoveContent(Plus(Times(a, Cos(Plus(e, Times(f, x)))), Times(b, Sin(Plus(e, Times(f, x))))), x)), Power(Times(b, f), CN1)), x), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Plus(Sqr(a), Sqr(b)), C0), EqQ(Plus(Times(a, c), Times(b, d)), C0))));
            IIntegrate(3531, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1), Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(Times(a, c), Times(b, d)), x, Power(Plus(Sqr(a), Sqr(b)), CN1)), x), Dist(Times(Subtract(Times(b, c), Times(a, d)), Power(Plus(Sqr(a), Sqr(b)), CN1)), Int(Times(Subtract(b, Times(a, Tan(Plus(e, Times(f, x))))), Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Plus(Sqr(a), Sqr(b)), C0), NeQ(Plus(Times(a, c), Times(b, d)), C0))));
            IIntegrate(3532, Int(Times(Power(Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), CN1D2), Plus(c_, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Dist(Times(CN2, Sqr(d), Power(f, CN1)), Subst(Int(Power(Plus(Times(C2, c, d), Times(b, Sqr(x))), CN1), x), x, Times(Subtract(c, Times(d, Tan(Plus(e, Times(f, x))))), Power(Times(b, Tan(Plus(e, Times(f, x)))), CN1D2))), x), And(FreeQ(List(b, c, d, e, f), x), EqQ(Subtract(Sqr(c), Sqr(d)), C0))));
            IIntegrate(3533, Int(Times(Power(Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), CN1D2), Plus(c_, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Dist(Times(C2, Sqr(c), Power(f, CN1)), Subst(Int(Power(Subtract(Times(b, c), Times(d, Sqr(x))), CN1), x), x, Sqrt(Times(b, Tan(Plus(e, Times(f, x)))))), x), And(FreeQ(List(b, c, d, e, f), x), EqQ(Plus(Sqr(c), Sqr(d)), C0))));
            IIntegrate(3534, Int(Times(Power(Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), CN1D2), Plus(c_, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Dist(Times(C2, Power(f, CN1)), Subst(Int(Times(Plus(Times(b, c), Times(d, Sqr(x))), Power(Plus(Sqr(b), Power(x, C4)), CN1)), x), x, Sqrt(Times(b, Tan(Plus(e, Times(f, x)))))), x), And(FreeQ(List(b, c, d, e, f), x), NeQ(Subtract(Sqr(c), Sqr(d)), C0), NeQ(Plus(Sqr(c), Sqr(d)), C0))));
            IIntegrate(3535, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2), Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Dist(Times(CN2, Sqr(d), Power(f, CN1)), Subst(Int(Power(Plus(Times(C2, b, c, d), Times(CN1, C4, a, Sqr(d)), Sqr(x)), CN1), x), x, Times(Subtract(Subtract(Times(b, c), Times(C2, a, d)), Times(b, d, Tan(Plus(e, Times(f, x))))), Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), CN1D2))), x), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Plus(Sqr(a), Sqr(b)), C0), NeQ(Plus(Sqr(c), Sqr(d)), C0), EqQ(Subtract(Times(C2, a, c, d), Times(b, Subtract(Sqr(c), Sqr(d)))), C0))));
            IIntegrate(3536, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2), Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(With(List(Set(q, Rt(Plus(Sqr(a), Sqr(b)), C2))), Subtract(Dist(Power(Times(C2, q), CN1), Int(Times(Plus(Times(a, c), Times(b, d), Times(c, q), Times(Plus(Times(b, c), Times(CN1, a, d), Times(d, q)), Tan(Plus(e, Times(f, x))))), Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), CN1D2)), x), x), Dist(Power(Times(C2, q), CN1), Int(Times(Plus(Times(a, c), Times(b, d), Times(CN1, c, q), Times(Subtract(Subtract(Times(b, c), Times(a, d)), Times(d, q)), Tan(Plus(e, Times(f, x))))), Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), CN1D2)), x), x))), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Plus(Sqr(a), Sqr(b)), C0), NeQ(Plus(Sqr(c), Sqr(d)), C0), NeQ(Subtract(Times(C2, a, c, d), Times(b, Subtract(Sqr(c), Sqr(d)))), C0), Or(PerfectSquareQ(Plus(Sqr(a), Sqr(b))), RationalQ(a, b, c, d)))));
            IIntegrate(3537, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Plus(c_, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Dist(Times(c, d, Power(f, CN1)), Subst(Int(Times(Power(Plus(a, Times(b, x, Power(d, CN1))), m), Power(Plus(Sqr(d), Times(c, x)), CN1)), x), x, Times(d, Tan(Plus(e, Times(f, x))))), x), And(FreeQ(List(a, b, c, d, e, f, m), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Plus(Sqr(a), Sqr(b)), C0), EqQ(Plus(Sqr(c), Sqr(d)), C0))));
            IIntegrate(3538, Int(Times(Power(Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_), Plus(c_, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Dist(c, Int(Power(Times(b, Tan(Plus(e, Times(f, x)))), m), x), x), Dist(Times(d, Power(b, CN1)), Int(Power(Times(b, Tan(Plus(e, Times(f, x)))), Plus(m, C1)), x), x)), And(FreeQ(List(b, c, d, e, f, m), x), NeQ(Plus(Sqr(c), Sqr(d)), C0), Not(IntegerQ(Times(C2, m))))));
            IIntegrate(3539, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Dist(Times(C1D2, Plus(c, Times(CI, d))), Int(Times(Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), m), Subtract(C1, Times(CI, Tan(Plus(e, Times(f, x)))))), x), x), Dist(Times(C1D2, Subtract(c, Times(CI, d))), Int(Times(Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), m), Plus(C1, Times(CI, Tan(Plus(e, Times(f, x)))))), x), x)), And(FreeQ(List(a, b, c, d, e, f, m), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Plus(Sqr(a), Sqr(b)), C0), NeQ(Plus(Sqr(c), Sqr(d)), C0), Not(IntegerQ(m)))));
            IIntegrate(3540, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Sqr(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, Sqr(Plus(Times(a, c), Times(b, d))), Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), m), Power(Times(C2, Power(a, C3), f, m), CN1)), x)), Dist(Power(Times(C2, Sqr(a)), CN1), Int(Times(Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), Plus(m, C1)), Simp(Subtract(Plus(Times(a, Sqr(c)), Times(CN1, C2, b, c, d), Times(a, Sqr(d))), Times(C2, b, Sqr(d), Tan(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), LeQ(m, CN1), EqQ(Plus(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3541, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1), Sqr(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Simp(Times(d, Subtract(Times(C2, b, c), Times(a, d)), x, Power(b, CN2)), x), Dist(Times(Sqr(d), Power(b, CN1)), Int(Tan(Plus(e, Times(f, x))), x), x), Dist(Times(Sqr(Subtract(Times(b, c), Times(a, d))), Power(b, CN2)), Int(Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), CN1), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Plus(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3542, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Sqr(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Simp(Times(Sqr(Subtract(Times(b, c), Times(a, d))), Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(b, f, Plus(m, C1), Plus(Sqr(a), Sqr(b))), CN1)), x), Dist(Power(Plus(Sqr(a), Sqr(b)), CN1), Int(Times(Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), Plus(m, C1)), Simp(Subtract(Subtract(Plus(Times(a, Sqr(c)), Times(C2, b, c, d)), Times(a, Sqr(d))), Times(Subtract(Subtract(Times(b, Sqr(c)), Times(C2, a, c, d)), Times(b, Sqr(d))), Tan(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), LtQ(m, CN1), NeQ(Plus(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3543, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Sqr(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Simp(Times(Sqr(d), Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(b, f, Plus(m, C1)), CN1)), x), Int(Times(Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), m), Simp(Plus(Sqr(c), Negate(Sqr(d)), Times(C2, c, d, Tan(Plus(e, Times(f, x))))), x)), x)), And(FreeQ(List(a, b, c, d, e, f, m), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), Not(LeQ(m, CN1)), Not(And(EqQ(m, C2), EqQ(a, C0))))));
            IIntegrate(3544, Int(Times(Sqrt(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(CN2, a, b, Power(f, CN1)), Subst(Int(Power(Subtract(Subtract(Times(a, c), Times(b, d)), Times(C2, Sqr(a), Sqr(x))), CN1), x), x, Times(Sqrt(Plus(c, Times(d, Tan(Plus(e, Times(f, x)))))), Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), CN1D2))), x), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(Sqr(a), Sqr(b)), C0), NeQ(Plus(Sqr(c), Sqr(d)), C0))));
            IIntegrate(3545, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Plus(Simp(Times(a, b, Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(f, Subtract(m, C1), Subtract(Times(a, c), Times(b, d))), CN1)), x), Dist(Times(C2, Sqr(a), Power(Subtract(Times(a, c), Times(b, d)), CN1)), Int(Times(Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), Plus(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(Sqr(a), Sqr(b)), C0), NeQ(Plus(Sqr(c), Sqr(d)), C0), EqQ(Plus(m, n), C0), GtQ(m, C1D2))));
            IIntegrate(3546, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Subtract(Simp(Times(a, Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), n), Power(Times(C2, b, f, m), CN1)), x), Dist(Times(Subtract(Times(a, c), Times(b, d)), Power(Times(C2, Sqr(b)), CN1)), Int(Times(Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), Subtract(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(Sqr(a), Sqr(b)), C0), NeQ(Plus(Sqr(c), Sqr(d)), C0), EqQ(Plus(m, n), C0), LeQ(m, Negate(C1D2)))));
            IIntegrate(3547, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Plus(Simp(Times(a, Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(C2, f, m, Subtract(Times(b, c), Times(a, d))), CN1)), x), Dist(Power(Times(C2, a), CN1), Int(Times(Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), n)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(Sqr(a), Sqr(b)), C0), NeQ(Plus(Sqr(c), Sqr(d)), C0), EqQ(Plus(m, n, C1), C0), LtQ(m, CN1))));
            IIntegrate(3548, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(d, Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(f, m, Plus(Sqr(c), Sqr(d))), CN1)), x)), Dist(Times(a, Power(Subtract(Times(a, c), Times(b, d)), CN1)), Int(Times(Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), Plus(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f, m, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(Sqr(a), Sqr(b)), C0), NeQ(Plus(Sqr(c), Sqr(d)), C0), EqQ(Plus(m, n, C1), C0), Not(LtQ(m, CN1)))));
            IIntegrate(3549, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Plus(Times(a, c), Times(b, d)), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), n), Power(Times(C2, Subtract(Times(b, c), Times(a, d)), f, Plus(a, Times(b, Tan(Plus(e, Times(f, x)))))), CN1)), x)), Dist(Power(Times(C2, a, Subtract(Times(b, c), Times(a, d))), CN1), Int(Times(Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), Subtract(n, C1)), Simp(Subtract(Plus(Times(a, c, d, Subtract(n, C1)), Times(b, Sqr(c)), Times(b, Sqr(d), n)), Times(d, Subtract(Times(b, c), Times(a, d)), Subtract(n, C1), Tan(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(Sqr(a), Sqr(b)), C0), NeQ(Plus(Sqr(c), Sqr(d)), C0), LtQ(C0, n, C1))));
            IIntegrate(3550, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Plus(Simp(Times(Subtract(Times(b, c), Times(a, d)), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), Subtract(n, C1)), Power(Times(C2, a, f, Plus(a, Times(b, Tan(Plus(e, Times(f, x)))))), CN1)), x), Dist(Power(Times(C2, Sqr(a)), CN1), Int(Times(Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), Subtract(n, C2)), Simp(Subtract(Subtract(Plus(Times(a, Sqr(c)), Times(a, Sqr(d), Subtract(n, C1))), Times(b, c, d, n)), Times(d, Plus(Times(a, c, Subtract(n, C2)), Times(b, d, n)), Tan(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(Sqr(a), Sqr(b)), C0), NeQ(Plus(Sqr(c), Sqr(d)), C0), GtQ(n, C1))));
        }
    }
}
