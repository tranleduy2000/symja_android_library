package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.AppellF1;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
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
import static org.matheclipse.core.expression.F.c;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
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
public class IntRules155 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(3876, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_)), x_Symbol),
                    Condition(Dist(Times(Power(Sin(Plus(e, Times(f, x))), FracPart(m)), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), FracPart(m)), Power(Power(Plus(b, Times(a, Sin(Plus(e, Times(f, x))))), FracPart(m)), CN1)), Int(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), p), Power(Plus(b, Times(a, Sin(Plus(e, Times(f, x))))), m), Power(Power(Sin(Plus(e, Times(f, x))), m), CN1)), x), x), And(FreeQ(List(a, b, e, f, g, m, p), x), Or(EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegersQ(Times(C2, m), p)))));
            IIntegrate(3877, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Times(g, Cos(Plus(e, Times(f, x)))), p), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m)), x), FreeQ(List(a, b, e, f, g, m, p), x)));
            IIntegrate(3878, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_DEFAULT), Power(Times(g_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(g, IntPart(p)), Power(Times(g, Sec(Plus(e, Times(f, x)))), FracPart(p)), Power(Cos(Plus(e, Times(f, x))), FracPart(p))), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Power(Power(Cos(Plus(e, Times(f, x))), p), CN1)), x), x), And(FreeQ(List(a, b, e, f, g, m, p), x), Not(IntegerQ(p)))));
            IIntegrate(3879, Int(Times(Power($($s("§cot"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), m_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Times(Power(a, Subtract(Subtract(m, n), C1)), Power(b, n), d), CN1), Subst(Int(Times(Power(Subtract(a, Times(b, x)), Times(C1D2, Subtract(m, C1))), Power(Plus(a, Times(b, x)), Plus(Times(C1D2, Subtract(m, C1)), n)), Power(Power(x, Plus(m, n)), CN1)), x), x, Sin(Plus(c, Times(d, x)))), x), And(FreeQ(List(a, b, c, d), x), IntegerQ(Times(C1D2, Subtract(m, C1))), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegerQ(n))));
            IIntegrate(3880, Int(Times(Power($($s("§cot"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), m_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), n_)), x_Symbol),
                    Condition(Negate(Dist(Power(Times(d, Power(b, Subtract(m, C1))), CN1), Subst(Int(Times(Power(Plus(Negate(a), Times(b, x)), Times(C1D2, Subtract(m, C1))), Power(Plus(a, Times(b, x)), Plus(Times(C1D2, Subtract(m, C1)), n)), Power(x, CN1)), x), x, Csc(Plus(c, Times(d, x)))), x)), And(FreeQ(List(a, b, c, d, n), x), IntegerQ(Times(C1D2, Subtract(m, C1))), EqQ(Subtract(Sqr(a), Sqr(b)), C0), Not(IntegerQ(n)))));
            IIntegrate(3881, Int(Times(Power(Times($($s("§cot"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), e_DEFAULT), m_), Plus(Times($($s("§csc"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_)), x_Symbol),
                    Condition(Subtract(Negate(Simp(Times(e, Power(Times(e, Cot(Plus(c, Times(d, x)))), Subtract(m, C1)), Plus(Times(a, m), Times(b, Subtract(m, C1), Csc(Plus(c, Times(d, x))))), Power(Times(d, m, Subtract(m, C1)), CN1)), x)), Dist(Times(Sqr(e), Power(m, CN1)), Int(Times(Power(Times(e, Cot(Plus(c, Times(d, x)))), Subtract(m, C2)), Plus(Times(a, m), Times(b, Subtract(m, C1), Csc(Plus(c, Times(d, x)))))), x), x)), And(FreeQ(List(a, b, c, d, e), x), GtQ(m, C1))));
            IIntegrate(3882, Int(Times(Power(Times($($s("§cot"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), e_DEFAULT), m_), Plus(Times($($s("§csc"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_)), x_Symbol),
                    Condition(Subtract(Negate(Simp(Times(Power(Times(e, Cot(Plus(c, Times(d, x)))), Plus(m, C1)), Plus(a, Times(b, Csc(Plus(c, Times(d, x))))), Power(Times(d, e, Plus(m, C1)), CN1)), x)), Dist(Power(Times(Sqr(e), Plus(m, C1)), CN1), Int(Times(Power(Times(e, Cot(Plus(c, Times(d, x)))), Plus(m, C2)), Plus(Times(a, Plus(m, C1)), Times(b, Plus(m, C2), Csc(Plus(c, Times(d, x)))))), x), x)), And(FreeQ(List(a, b, c, d, e), x), LtQ(m, CN1))));
            IIntegrate(3883, Int(Times(Power($($s("§cot"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), CN1), Plus(Times($($s("§csc"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_)), x_Symbol),
                    Condition(Int(Times(Plus(b, Times(a, Sin(Plus(c, Times(d, x))))), Power(Cos(Plus(c, Times(d, x))), CN1)), x), FreeQ(List(a, b, c, d), x)));
            IIntegrate(3884, Int(Times(Power(Times($($s("§cot"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), e_DEFAULT), m_DEFAULT), Plus(Times($($s("§csc"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_)), x_Symbol),
                    Condition(Plus(Dist(a, Int(Power(Times(e, Cot(Plus(c, Times(d, x)))), m), x), x), Dist(b, Int(Times(Power(Times(e, Cot(Plus(c, Times(d, x)))), m), Csc(Plus(c, Times(d, x)))), x), x)), FreeQ(List(a, b, c, d, e, m), x)));
            IIntegrate(3885, Int(Times(Power($($s("§cot"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), m_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), n_)), x_Symbol),
                    Condition(Negate(Dist(Times(Power(CN1, Times(C1D2, Subtract(m, C1))), Power(Times(d, Power(b, Subtract(m, C1))), CN1)), Subst(Int(Times(Power(Subtract(Sqr(b), Sqr(x)), Times(C1D2, Subtract(m, C1))), Power(Plus(a, x), n), Power(x, CN1)), x), x, Times(b, Csc(Plus(c, Times(d, x))))), x)), And(FreeQ(List(a, b, c, d, n), x), IntegerQ(Times(C1D2, Subtract(m, C1))), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3886, Int(Times(Power(Times($($s("§cot"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), e_DEFAULT), m_), Power(Plus(Times($($s("§csc"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), n_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Times(e, Cot(Plus(c, Times(d, x)))), m), Power(Plus(a, Times(b, Csc(Plus(c, Times(d, x))))), n), x), x), And(FreeQ(List(a, b, c, d, e, m), x), IGtQ(n, C0))));
            IIntegrate(3887, Int(Times(Power($($s("§cot"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), m_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(CN2, Power(a, Plus(Times(C1D2, m), n, C1D2)), Power(d, CN1)), Subst(Int(Times(Power(x, m), Power(Plus(C2, Times(a, Sqr(x))), Subtract(Plus(Times(C1D2, m), n), C1D2)), Power(Plus(C1, Times(a, Sqr(x))), CN1)), x), x, Times(Cot(Plus(c, Times(d, x))), Power(Plus(a, Times(b, Csc(Plus(c, Times(d, x))))), CN1D2))), x), And(FreeQ(List(a, b, c, d), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegerQ(Times(C1D2, m)), IntegerQ(Subtract(n, C1D2)))));
            IIntegrate(3888, Int(Times(Power(Times($($s("§cot"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), e_DEFAULT), m_), Power(Plus(Times($($s("§csc"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), n_)), x_Symbol),
                    Condition(Dist(Times(Power(a, Times(C2, n)), Power(Power(e, Times(C2, n)), CN1)), Int(Times(Power(Times(e, Cot(Plus(c, Times(d, x)))), Plus(m, Times(C2, n))), Power(Power(Plus(Negate(a), Times(b, Csc(Plus(c, Times(d, x))))), n), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, m), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), ILtQ(n, C0))));
            IIntegrate(3889, Int(Times(Power(Times($($s("§cot"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), e_DEFAULT), m_), Power(Plus(Times($($s("§csc"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), n_)), x_Symbol),
                    Condition(Negate(Simp(Times(Power(C2, Plus(m, n, C1)), Power(Times(e, Cot(Plus(c, Times(d, x)))), Plus(m, C1)), Power(Plus(a, Times(b, Csc(Plus(c, Times(d, x))))), n), Power(Times(a, Power(Plus(a, Times(b, Csc(Plus(c, Times(d, x))))), CN1)), Plus(m, n, C1)), AppellF1(Times(C1D2, Plus(m, C1)), Plus(m, n), C1, Times(C1D2, Plus(m, C3)), Times(CN1, Subtract(a, Times(b, Csc(Plus(c, Times(d, x))))), Power(Plus(a, Times(b, Csc(Plus(c, Times(d, x))))), CN1)), Times(Subtract(a, Times(b, Csc(Plus(c, Times(d, x))))), Power(Plus(a, Times(b, Csc(Plus(c, Times(d, x))))), CN1))), Power(Times(d, e, Plus(m, C1)), CN1)), x)), And(FreeQ(List(a, b, c, d, e, m, n), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), Not(IntegerQ(n)))));
            IIntegrate(3890, Int(Times(Sqrt(Times($($s("§cot"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), e_DEFAULT)), Power(Plus(Times($($s("§csc"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Power(a, CN1), Int(Sqrt(Times(e, Cot(Plus(c, Times(d, x))))), x), x), Dist(Times(b, Power(a, CN1)), Int(Times(Sqrt(Times(e, Cot(Plus(c, Times(d, x))))), Power(Plus(b, Times(a, Sin(Plus(c, Times(d, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3891, Int(Times(Power(Times($($s("§cot"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), e_DEFAULT), m_), Power(Plus(Times($($s("§csc"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), CN1)), x_Symbol),
                    Condition(Plus(Negate(Dist(Times(Sqr(e), Power(b, CN2)), Int(Times(Power(Times(e, Cot(Plus(c, Times(d, x)))), Subtract(m, C2)), Subtract(a, Times(b, Csc(Plus(c, Times(d, x)))))), x), x)), Dist(Times(Sqr(e), Subtract(Sqr(a), Sqr(b)), Power(b, CN2)), Int(Times(Power(Times(e, Cot(Plus(c, Times(d, x)))), Subtract(m, C2)), Power(Plus(a, Times(b, Csc(Plus(c, Times(d, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), IGtQ(Subtract(m, C1D2), C0))));
            IIntegrate(3892, Int(Times(Power(Times($($s("§cot"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), e_DEFAULT), CN1D2), Power(Plus(Times($($s("§csc"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Power(a, CN1), Int(Power(Times(e, Cot(Plus(c, Times(d, x)))), CN1D2), x), x), Dist(Times(b, Power(a, CN1)), Int(Power(Times(Sqrt(Times(e, Cot(Plus(c, Times(d, x))))), Plus(b, Times(a, Sin(Plus(c, Times(d, x)))))), CN1), x), x)), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3893, Int(Times(Power(Times($($s("§cot"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), e_DEFAULT), m_), Power(Plus(Times($($s("§csc"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), CN1)), x_Symbol),
                    Condition(Plus(Dist(Power(Subtract(Sqr(a), Sqr(b)), CN1), Int(Times(Power(Times(e, Cot(Plus(c, Times(d, x)))), m), Subtract(a, Times(b, Csc(Plus(c, Times(d, x)))))), x), x), Dist(Times(Sqr(b), Power(Times(Sqr(e), Subtract(Sqr(a), Sqr(b))), CN1)), Int(Times(Power(Times(e, Cot(Plus(c, Times(d, x)))), Plus(m, C2)), Power(Plus(a, Times(b, Csc(Plus(c, Times(d, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), ILtQ(Plus(m, C1D2), C0))));
            IIntegrate(3894, Int(Times(Sqr($($s("§cot"), Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), Power(Plus(Times($($s("§csc"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), n_)), x_Symbol),
                    Condition(Int(Times(Plus(CN1, Sqr(Csc(Plus(c, Times(d, x))))), Power(Plus(a, Times(b, Csc(Plus(c, Times(d, x))))), n)), x), And(FreeQ(List(a, b, c, d, n), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3895, Int(Times(Power($($s("§cot"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), m_), Power(Plus(Times($($s("§csc"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), n_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(a, Times(b, Csc(Plus(c, Times(d, x))))), n), Power(Plus(CN1, Sqr(Csc(Plus(c, Times(d, x))))), Times(C1D2, m)), x), x), And(FreeQ(List(a, b, c, d, n), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), IGtQ(Times(C1D2, m), C0), IntegerQ(Subtract(n, C1D2)))));
            IIntegrate(3896, Int(Times(Power($($s("§cot"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), m_), Power(Plus(Times($($s("§csc"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), n_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(a, Times(b, Csc(Plus(c, Times(d, x))))), n), Power(Plus(CN1, Sqr(Sec(Plus(c, Times(d, x))))), Times(CN1, C1D2, m)), x), x), And(FreeQ(List(a, b, c, d, n), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), ILtQ(Times(C1D2, m), C0), IntegerQ(Subtract(n, C1D2)), EqQ(m, CN2))));
            IIntegrate(3897, Int(Times(Power(Times($($s("§cot"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), e_DEFAULT), m_), Power(Plus(Times($($s("§csc"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), n_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Times(e, Cot(Plus(c, Times(d, x)))), m), Power(Plus(a, Times(b, Csc(Plus(c, Times(d, x))))), n), x), x), And(FreeQ(List(a, b, c, d, e, m), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), IGtQ(n, C0))));
            IIntegrate(3898, Int(Times(Power($($s("§cot"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), m_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), n_)), x_Symbol),
                    Condition(Int(Times(Power(Cos(Plus(c, Times(d, x))), m), Power(Plus(b, Times(a, Sin(Plus(c, Times(d, x))))), n), Power(Power(Sin(Plus(c, Times(d, x))), Plus(m, n)), CN1)), x), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), IntegerQ(n), IntegerQ(m), Or(IntegerQ(Times(C1D2, m)), LeQ(m, C1)))));
            IIntegrate(3899, Int(Times(Power(Plus(a_DEFAULT, Times($($s("§csc"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT)), n_DEFAULT), Power(Times($($s("§cot"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), e_DEFAULT), m_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Times(e, Cot(Plus(c, Times(d, x)))), m), Power(Plus(a, Times(b, Csc(Plus(c, Times(d, x))))), n)), x), FreeQ(List(a, b, c, d, e, m, n), x)));
            IIntegrate(3900, Int(Times(Power(Times($($s("§cot"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))), e_DEFAULT), m_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sec"), Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Times(e, Cot(Plus(c, Times(d, x)))), m), Power(Tan(Plus(c, Times(d, x))), m)), Int(Times(Power(Plus(a, Times(b, Sec(Plus(c, Times(d, x))))), n), Power(Power(Tan(Plus(c, Times(d, x))), m), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, m, n), x), Not(IntegerQ(m)))));
        }
    }
}
