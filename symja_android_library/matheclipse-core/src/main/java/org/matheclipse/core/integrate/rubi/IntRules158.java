package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcSin;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C1DSqrt2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cot;
import static org.matheclipse.core.expression.F.Csc;
import static org.matheclipse.core.expression.F.EllipticE;
import static org.matheclipse.core.expression.F.EllipticPi;
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
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandTrig;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GeQ;
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
public class IntRules158 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(3951, Int(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(b, Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), n), Power(Times(a, f, Plus(Times(C2, m), C1)), CN1)), x), Dist(Times(Plus(m, n, C1), Power(Times(a, Plus(Times(C2, m), C1)), CN1)), Int(Times(Csc(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), n)), x), x)), And(FreeQ(List(a, b, c, d, e, f, m, n), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), ILtQ(Plus(m, n, C1), C0), NeQ(Plus(Times(C2, m), C1), C0), Not(LtQ(n, C0)), Not(And(IGtQ(Plus(n, C1D2), C0), LtQ(Plus(n, C1D2), Negate(Plus(m, n))))))));
            IIntegrate(3952, Int(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), CN1D2), Sqrt(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_))), x_Symbol),
                    Condition(Simp(Times(a, c, Log(Plus(C1, Times(b, Csc(Plus(e, Times(f, x))), Power(a, CN1)))), Cot(Plus(e, Times(f, x))), Power(Times(b, f, Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Sqrt(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))))), CN1)), x), And(FreeQ(List(a, b, c, d, e, f), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3953, Int(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_DEFAULT), Sqrt(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_))), x_Symbol),
                    Condition(Simp(Times(C2, a, c, Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Power(Times(b, f, Plus(Times(C2, m), C1), Sqrt(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))))), CN1)), x), And(FreeQ(List(a, b, c, d, e, f, m), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(m, Negate(C1D2)))));
            IIntegrate(3954, Int(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(C2, a, c, Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), Subtract(n, C1)), Power(Times(b, f, Plus(Times(C2, m), C1)), CN1)), x), Dist(Times(d, Subtract(Times(C2, n), C1), Power(Times(b, Plus(Times(C2, m), C1)), CN1)), Int(Times(Csc(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), Subtract(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IGtQ(Subtract(n, C1D2), C0), LtQ(m, Negate(C1D2)))));
            IIntegrate(3955, Int(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(d, Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), Subtract(n, C1)), Power(Times(f, Plus(m, n)), CN1)), x)), Dist(Times(c, Subtract(Times(C2, n), C1), Power(Plus(m, n), CN1)), Int(Times(Csc(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), Subtract(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f, m), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IGtQ(Subtract(n, C1D2), C0), Not(LtQ(m, Negate(C1D2))), Not(And(IGtQ(Subtract(m, C1D2), C0), LtQ(m, n))))));
            IIntegrate(3956, Int(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), CN1D2), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(CN2, d, Cot(Plus(e, Times(f, x))), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), Subtract(n, C1)), Power(Times(f, Subtract(Times(C2, n), C1), Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))))), CN1)), x), Dist(Times(C2, c, Subtract(Times(C2, n), C1), Power(Subtract(Times(C2, n), C1), CN1)), Int(Times(Csc(Plus(e, Times(f, x))), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), Subtract(n, C1)), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IGtQ(n, C0))));
            IIntegrate(3957, Int(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(C2, a, c, Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), Subtract(n, C1)), Power(Times(b, f, Plus(Times(C2, m), C1)), CN1)), x), Dist(Times(d, Subtract(Times(C2, n), C1), Power(Times(b, Plus(Times(C2, m), C1)), CN1)), Int(Times(Csc(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), Subtract(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IGtQ(n, C0), LtQ(m, Negate(C1D2)), IntegerQ(Times(C2, m)))));
            IIntegrate(3958, Int(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Times(CN1, a, c), m), Int(ExpandTrig(Times($($s("§csc"), Plus(e, Times(f, x))), Power($($s("§cot"), Plus(e, Times(f, x))), Times(C2, m))), Power(Plus(c, Times(d, $($s("§csc"), Plus(e, Times(f, x))))), Subtract(n, m)), x), x), x), And(FreeQ(List(a, b, c, d, e, f, n), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegersQ(m, n), GeQ(Subtract(n, m), C0), GtQ(Times(m, n), C0))));
            IIntegrate(3959, Int(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), m_)), x_Symbol),
                    Condition(Dist(Times(Power(Times(CN1, a, c), Plus(m, C1D2)), Cot(Plus(e, Times(f, x))), Power(Times(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Sqrt(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))))), CN1)), Int(Times(Csc(Plus(e, Times(f, x))), Power(Cot(Plus(e, Times(f, x))), Times(C2, m))), x), x), And(FreeQ(List(a, b, c, d, e, f), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegerQ(Plus(m, C1D2)))));
            IIntegrate(3960, Int(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_)), x_Symbol),
                    Condition(Plus(Simp(Times(b, Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), n), Power(Times(a, f, Plus(Times(C2, m), C1)), CN1)), x), Dist(Times(Plus(m, n, C1), Power(Times(a, Plus(Times(C2, m), C1)), CN1)), Int(Times(Csc(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), n)), x), x)), And(FreeQ(List(a, b, c, d, e, f, n), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), Or(And(ILtQ(m, C0), ILtQ(Subtract(n, C1D2), C0)), And(ILtQ(Subtract(m, C1D2), C0), ILtQ(Subtract(n, C1D2), C0), LtQ(m, n))))));
            IIntegrate(3961, Int(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_)), x_Symbol),
                    Condition(Dist(Times(a, c, Cot(Plus(e, Times(f, x))), Power(Times(f, Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Sqrt(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))))), CN1)), Subst(Int(Times(Power(Plus(a, Times(b, x)), Subtract(m, C1D2)), Power(Plus(c, Times(d, x)), Subtract(n, C1D2))), x), x, Csc(Plus(e, Times(f, x)))), x), And(FreeQ(List(a, b, c, d, e, f, m, n), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3962, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Times(CN1, a, c), m), Int(ExpandTrig(Times(Power(Times(g, $($s("§csc"), Plus(e, Times(f, x)))), p), Power($($s("§cot"), Plus(e, Times(f, x))), Times(C2, m))), Power(Plus(c, Times(d, $($s("§csc"), Plus(e, Times(f, x))))), Subtract(n, m)), x), x), x), And(FreeQ(List(a, b, c, d, e, f, g, n, p), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegersQ(m, n), GeQ(Subtract(n, m), C0), GtQ(Times(m, n), C0))));
            IIntegrate(3963, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), m_)), x_Symbol),
                    Condition(Dist(Times(Power(Times(CN1, a, c), Plus(m, C1D2)), Cot(Plus(e, Times(f, x))), Power(Times(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Sqrt(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))))), CN1)), Int(Times(Power(Times(g, Csc(Plus(e, Times(f, x)))), p), Power(Cot(Plus(e, Times(f, x))), Times(C2, m))), x), x), And(FreeQ(List(a, b, c, d, e, f, g, p), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegerQ(Plus(m, C1D2)))));
            IIntegrate(3964, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_)), x_Symbol),
                    Condition(Dist(Times(a, c, g, Cot(Plus(e, Times(f, x))), Power(Times(f, Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Sqrt(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))))), CN1)), Subst(Int(Times(Power(Times(g, x), Subtract(p, C1)), Power(Plus(a, Times(b, x)), Subtract(m, C1D2)), Power(Plus(c, Times(d, x)), Subtract(n, C1D2))), x), x, Csc(Plus(e, Times(f, x)))), x), And(FreeQ(List(a, b, c, d, e, f, g, m, n, p), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3965, Int(Times(Sqrt(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT)), Sqrt(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), CN1)), x_Symbol),
                    Condition(Dist(Times(CN2, b, g, Power(f, CN1)), Subst(Int(Power(Subtract(Plus(Times(b, c), Times(a, d)), Times(c, g, Sqr(x))), CN1), x), x, Times(b, Cot(Plus(e, Times(f, x))), Power(Times(Sqrt(Times(g, Csc(Plus(e, Times(f, x))))), Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))))), CN1))), x), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3966, Int(Times(Sqrt(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT)), Sqrt(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), CN1)), x_Symbol),
                    Condition(Plus(Dist(Times(a, Power(c, CN1)), Int(Times(Sqrt(Times(g, Csc(Plus(e, Times(f, x))))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2)), x), x), Dist(Times(Subtract(Times(b, c), Times(a, d)), Power(Times(c, g), CN1)), Int(Times(Power(Times(g, Csc(Plus(e, Times(f, x)))), QQ(3L, 2L)), Power(Times(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Plus(c, Times(d, Csc(Plus(e, Times(f, x)))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3967, Int(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), Sqrt(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), CN1)), x_Symbol),
                    Condition(Dist(Times(CN2, b, Power(f, CN1)), Subst(Int(Power(Plus(Times(b, c), Times(a, d), Times(d, Sqr(x))), CN1), x), x, Times(b, Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2))), x), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3968, Int(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), Sqrt(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), CN1)), x_Symbol),
                    Condition(Negate(Simp(Times(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Sqrt(Times(c, Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), CN1))), EllipticE(ArcSin(Times(c, Cot(Plus(e, Times(f, x))), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), CN1))), Times(CN1, Subtract(Times(b, c), Times(a, d)), Power(Plus(Times(b, c), Times(a, d)), CN1))), Power(Times(d, f, Sqrt(Times(c, d, Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Power(Times(Plus(Times(b, c), Times(a, d)), Plus(c, Times(d, Csc(Plus(e, Times(f, x)))))), CN1)))), CN1)), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), EqQ(Subtract(Sqr(c), Sqr(d)), C0))));
            IIntegrate(3969, Int(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), Sqrt(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Times(b, Power(d, CN1)), Int(Times(Csc(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2)), x), x), Dist(Times(Subtract(Times(b, c), Times(a, d)), Power(d, CN1)), Int(Times(Csc(Plus(e, Times(f, x))), Power(Times(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Plus(c, Times(d, Csc(Plus(e, Times(f, x)))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0))));
            IIntegrate(3970, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), QQ(3L, 2L)), Sqrt(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Times(g, Power(d, CN1)), Int(Times(Sqrt(Times(g, Csc(Plus(e, Times(f, x))))), Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))))), x), x), Dist(Times(c, g, Power(d, CN1)), Int(Times(Sqrt(Times(g, Csc(Plus(e, Times(f, x))))), Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3971, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), QQ(3L, 2L)), Sqrt(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Times(b, Power(d, CN1)), Int(Times(Power(Times(g, Csc(Plus(e, Times(f, x)))), QQ(3L, 2L)), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2)), x), x), Dist(Times(Subtract(Times(b, c), Times(a, d)), Power(d, CN1)), Int(Times(Power(Times(g, Csc(Plus(e, Times(f, x)))), QQ(3L, 2L)), Power(Times(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Plus(c, Times(d, Csc(Plus(e, Times(f, x)))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3972, Int(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), CN1D2), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Times(b, Power(Subtract(Times(b, c), Times(a, d)), CN1)), Int(Times(Csc(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2)), x), x), Dist(Times(d, Power(Subtract(Times(b, c), Times(a, d)), CN1)), Int(Times(Csc(Plus(e, Times(f, x))), Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), Or(EqQ(Subtract(Sqr(a), Sqr(b)), C0), EqQ(Subtract(Sqr(c), Sqr(d)), C0)))));
            IIntegrate(3973, Int(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), CN1D2), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), CN1)), x_Symbol),
                    Condition(Simp(Times(CN2, Cot(Plus(e, Times(f, x))), Sqrt(Times(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Power(Plus(a, b), CN1))), EllipticPi(Times(C2, d, Power(Plus(c, d), CN1)), ArcSin(Times(Sqrt(Subtract(C1, Csc(Plus(e, Times(f, x))))), C1DSqrt2)), Times(C2, b, Power(Plus(a, b), CN1))), Power(Times(f, Plus(c, d), Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Sqrt(Negate(Sqr(Cot(Plus(e, Times(f, x))))))), CN1)), x), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0))));
            IIntegrate(3974, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), QQ(3L, 2L)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), CN1D2), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), CN1)), x_Symbol),
                    Condition(Plus(Negate(Dist(Times(a, g, Power(Subtract(Times(b, c), Times(a, d)), CN1)), Int(Times(Sqrt(Times(g, Csc(Plus(e, Times(f, x))))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2)), x), x)), Dist(Times(c, g, Power(Subtract(Times(b, c), Times(a, d)), CN1)), Int(Times(Sqrt(Times(g, Csc(Plus(e, Times(f, x))))), Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3975, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), QQ(3L, 2L)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), CN1D2), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), CN1)), x_Symbol),
                    Condition(Dist(Times(g, Sqrt(Times(g, Csc(Plus(e, Times(f, x))))), Sqrt(Plus(b, Times(a, Sin(Plus(e, Times(f, x)))))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2)), Int(Power(Times(Sqrt(Plus(b, Times(a, Sin(Plus(e, Times(f, x)))))), Plus(d, Times(c, Sin(Plus(e, Times(f, x)))))), CN1), x), x), And(FreeQ(List(a, b, c, d, e, f, g), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
        }
    }
}
