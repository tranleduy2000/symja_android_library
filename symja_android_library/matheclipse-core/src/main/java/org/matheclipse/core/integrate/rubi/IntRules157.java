package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcSin;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Cot;
import static org.matheclipse.core.expression.F.Csc;
import static org.matheclipse.core.expression.F.EllipticPi;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.QQ;
import static org.matheclipse.core.expression.F.Sec;
import static org.matheclipse.core.expression.F.Simplify;
import static org.matheclipse.core.expression.F.Sin;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules157 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(3926, Int(Times(Sqrt(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), CN1)), x_Symbol),
                    Condition(Plus(Dist(Times(a, Power(c, CN1)), Int(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2), x), x), Dist(Times(Subtract(Times(b, c), Times(a, d)), Power(c, CN1)), Int(Times(Csc(Plus(e, Times(f, x))), Power(Times(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Plus(c, Times(d, Csc(Plus(e, Times(f, x)))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0))));
            IIntegrate(3927, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), QQ(3L, 2L)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), CN1)), x_Symbol),
                    Condition(Plus(Dist(Times(a, Power(c, CN1)), Int(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), x), x), Dist(Times(Subtract(Times(b, c), Times(a, d)), Power(c, CN1)), Int(Times(Csc(Plus(e, Times(f, x))), Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), Or(EqQ(Subtract(Sqr(a), Sqr(b)), C0), EqQ(Subtract(Sqr(c), Sqr(d)), C0)))));
            IIntegrate(3928, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), QQ(3L, 2L)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Power(Times(c, d), CN1), Int(Times(Plus(Times(Sqr(a), d), Times(Sqr(b), c, Csc(Plus(e, Times(f, x))))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2)), x), x), Dist(Times(Sqr(Subtract(Times(b, c), Times(a, d))), Power(Times(c, d), CN1)), Int(Times(Csc(Plus(e, Times(f, x))), Power(Times(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Plus(c, Times(d, Csc(Plus(e, Times(f, x)))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0))));
            IIntegrate(3929, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), CN1D2), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), CN1)), x_Symbol),
                    Condition(Plus(Dist(Power(Times(c, Subtract(Times(b, c), Times(a, d))), CN1), Int(Times(Subtract(Subtract(Times(b, c), Times(a, d)), Times(b, d, Csc(Plus(e, Times(f, x))))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2)), x), x), Dist(Times(Sqr(d), Power(Times(c, Subtract(Times(b, c), Times(a, d))), CN1)), Int(Times(Csc(Plus(e, Times(f, x))), Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), Or(EqQ(Subtract(Sqr(a), Sqr(b)), C0), EqQ(Subtract(Sqr(c), Sqr(d)), C0)))));
            IIntegrate(3930, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), CN1D2), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Power(c, CN1), Int(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2), x), x), Dist(Times(d, Power(c, CN1)), Int(Times(Csc(Plus(e, Times(f, x))), Power(Times(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Plus(c, Times(d, Csc(Plus(e, Times(f, x)))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3931, Int(Times(Sqrt(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_)), Sqrt(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_))), x_Symbol),
                    Condition(Dist(Times(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Sqrt(Plus(c, Times(d, Csc(Plus(e, Times(f, x)))))), Power(Cot(Plus(e, Times(f, x))), CN1)), Int(Cot(Plus(e, Times(f, x))), x), x), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), EqQ(Subtract(Sqr(c), Sqr(d)), C0))));
            IIntegrate(3932, Int(Times(Sqrt(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_)), Sqrt(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_))), x_Symbol),
                    Condition(Plus(Dist(c, Int(Times(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), CN1D2)), x), x), Dist(d, Int(Times(Csc(Plus(e, Times(f, x))), Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), CN1D2)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0))));
            IIntegrate(3933, Int(Times(Sqrt(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), CN1D2)), x_Symbol),
                    Condition(Subtract(Dist(Power(c, CN1), Int(Times(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Sqrt(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))))), x), x), Dist(Times(d, Power(c, CN1)), Int(Times(Csc(Plus(e, Times(f, x))), Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), CN1D2)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), EqQ(Subtract(Sqr(c), Sqr(d)), C0))));
            IIntegrate(3934, Int(Times(Sqrt(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), CN1D2)), x_Symbol),
                    Condition(Dist(Times(CN2, a, Power(f, CN1)), Subst(Int(Power(Plus(C1, Times(a, c, Sqr(x))), CN1), x), x, Times(Cot(Plus(e, Times(f, x))), Power(Times(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Sqrt(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))))), CN1))), x), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0))));
            IIntegrate(3935, Int(Times(Sqrt(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), CN1D2)), x_Symbol),
                    Condition(Plus(Dist(Times(a, Power(c, CN1)), Int(Times(Sqrt(Plus(c, Times(d, Csc(Plus(e, Times(f, x)))))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2)), x), x), Dist(Times(Subtract(Times(b, c), Times(a, d)), Power(c, CN1)), Int(Times(Csc(Plus(e, Times(f, x))), Power(Times(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Sqrt(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), EqQ(Subtract(Sqr(c), Sqr(d)), C0))));
            IIntegrate(3936, Int(Times(Sqrt(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), CN1D2)), x_Symbol),
                    Condition(Simp(Times(C2, Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Sqrt(Times(Subtract(Times(b, c), Times(a, d)), Plus(C1, Csc(Plus(e, Times(f, x)))), Power(Times(Subtract(c, d), Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), CN1))), Sqrt(Times(CN1, Subtract(Times(b, c), Times(a, d)), Subtract(C1, Csc(Plus(e, Times(f, x)))), Power(Times(Plus(c, d), Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), CN1))), EllipticPi(Times(a, Plus(c, d), Power(Times(c, Plus(a, b)), CN1)), ArcSin(Times(Rt(Times(Plus(a, b), Power(Plus(c, d), CN1)), C2), Sqrt(Plus(c, Times(d, Csc(Plus(e, Times(f, x)))))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2))), Times(Subtract(a, b), Plus(c, d), Power(Times(Plus(a, b), Subtract(c, d)), CN1))), Power(Times(c, f, Rt(Times(Plus(a, b), Power(Plus(c, d), CN1)), C2), Cot(Plus(e, Times(f, x)))), CN1)), x), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0))));
            IIntegrate(3937, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), CN1D2), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Cot(Plus(e, Times(f, x))), Power(Times(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Sqrt(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))))), CN1)), Int(Power(Cot(Plus(e, Times(f, x))), CN1), x), x), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), EqQ(Subtract(Sqr(c), Sqr(d)), C0))));
            IIntegrate(3938, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), CN1D2), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), CN1D2)), x_Symbol),
                    Condition(Subtract(Dist(Power(a, CN1), Int(Times(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), CN1D2)), x), x), Dist(Times(b, Power(a, CN1)), Int(Times(Csc(Plus(e, Times(f, x))), Power(Times(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Sqrt(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0))));
            IIntegrate(3939, Int(Times(Sqrt(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), QQ(-3L, 2L))), x_Symbol),
                    Condition(Subtract(Dist(Power(c, CN1), Int(Times(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), CN1D2)), x), x), Dist(Times(d, Power(c, CN1)), Int(Times(Csc(Plus(e, Times(f, x))), Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), QQ(-3L, 2L))), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0))));
            IIntegrate(3940, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Sqr(a), Cot(Plus(e, Times(f, x))), Power(Times(f, Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Sqrt(Subtract(a, Times(b, Csc(Plus(e, Times(f, x))))))), CN1)), Subst(Int(Times(Power(Plus(a, Times(b, x)), Subtract(m, C1D2)), Power(Plus(c, Times(d, x)), n), Power(Times(x, Sqrt(Subtract(a, Times(b, x)))), CN1)), x), x, Csc(Plus(e, Times(f, x)))), x), And(FreeQ(List(a, b, c, d, e, f, m, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), IntegerQ(Subtract(m, C1D2)))));
            IIntegrate(3941, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_)), x_Symbol),
                    Condition(Int(Times(Power(Plus(b, Times(a, Sin(Plus(e, Times(f, x))))), m), Power(Plus(d, Times(c, Sin(Plus(e, Times(f, x))))), n), Power(Power(Sin(Plus(e, Times(f, x))), Plus(m, n)), CN1)), x), And(FreeQ(List(a, b, c, d, e, f, m, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), IntegerQ(m), IntegerQ(n), LeQ(CN2, Plus(m, n), C0))));
            IIntegrate(3942, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Plus(d, Times(c, Sin(Plus(e, Times(f, x)))))), Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Power(Times(Sqrt(Plus(b, Times(a, Sin(Plus(e, Times(f, x)))))), Sqrt(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))))), CN1)), Int(Times(Power(Plus(b, Times(a, Sin(Plus(e, Times(f, x))))), m), Power(Plus(d, Times(c, Sin(Plus(e, Times(f, x))))), n), Power(Power(Sin(Plus(e, Times(f, x))), Plus(m, n)), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f, m, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), IntegerQ(Plus(m, C1D2)), IntegerQ(Plus(n, C1D2)), LeQ(CN2, Plus(m, n), C0))));
            IIntegrate(3943, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_)), x_Symbol),
                    Condition(Dist(Times(Power(Sin(Plus(e, Times(f, x))), Plus(m, n)), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), n), Power(Times(Power(Plus(b, Times(a, Sin(Plus(e, Times(f, x))))), m), Power(Plus(d, Times(c, Sin(Plus(e, Times(f, x))))), n)), CN1)), Int(Times(Power(Plus(b, Times(a, Sin(Plus(e, Times(f, x))))), m), Power(Plus(d, Times(c, Sin(Plus(e, Times(f, x))))), n), Power(Power(Sin(Plus(e, Times(f, x))), Simplify(Plus(m, n))), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f, m, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(m, n), C0), Not(IntegerQ(Times(C2, m))))));
            IIntegrate(3944, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_)), x_Symbol),
                    Condition(Int(ExpandTrig(Power(Plus(a, Times(b, $($s("§csc"), Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, $($s("§csc"), Plus(e, Times(f, x))))), n), x), x), And(FreeQ(List(a, b, c, d, e, f, m, n), x), IGtQ(n, C0))));
            IIntegrate(3945, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), n)), x), FreeQ(List(a, b, c, d, e, f, m, n), x)));
            IIntegrate(3946, Int(Times(Power(Times(d_DEFAULT, Power($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), CN1)), n_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, m), Int(Times(Power(Plus(b, Times(a, Cos(Plus(e, Times(f, x))))), m), Power(Times(d, Cos(Plus(e, Times(f, x)))), Subtract(n, m))), x), x), And(FreeQ(List(a, b, d, e, f, n), x), Not(IntegerQ(n)), IntegerQ(m))));
            IIntegrate(3947, Int(Times(Power(Plus(a_DEFAULT, Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT)), m_DEFAULT), Power(Times(Power($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), CN1), d_DEFAULT), n_)), x_Symbol),
                    Condition(Dist(Power(d, m), Int(Times(Power(Plus(b, Times(a, Sin(Plus(e, Times(f, x))))), m), Power(Times(d, Sin(Plus(e, Times(f, x)))), Subtract(n, m))), x), x), And(FreeQ(List(a, b, d, e, f, n), x), Not(IntegerQ(n)), IntegerQ(m))));
            IIntegrate(3948, Int(Times(Power(Times(c_DEFAULT, Power(Times(d_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), p_)), n_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(c, IntPart(n)), Power(Times(c, Power(Times(d, Sec(Plus(e, Times(f, x)))), p)), FracPart(n)), Power(Power(Times(d, Sec(Plus(e, Times(f, x)))), Times(p, FracPart(n))), CN1)), Int(Times(Power(Plus(a, Times(b, Sec(Plus(e, Times(f, x))))), m), Power(Times(d, Sec(Plus(e, Times(f, x)))), Times(n, p))), x), x), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), Not(IntegerQ(n)))));
            IIntegrate(3949, Int(Times(Power(Plus(a_DEFAULT, Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT)), m_DEFAULT), Power(Times(c_DEFAULT, Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), p_)), n_)), x_Symbol),
                    Condition(Dist(Times(Power(c, IntPart(n)), Power(Times(c, Power(Times(d, Csc(Plus(e, Times(f, x)))), p)), FracPart(n)), Power(Power(Times(d, Csc(Plus(e, Times(f, x)))), Times(p, FracPart(n))), CN1)), Int(Times(Power(Plus(a, Times(b, Cos(Plus(e, Times(f, x))))), m), Power(Times(d, Cos(Plus(e, Times(f, x)))), Times(n, p))), x), x), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), Not(IntegerQ(n)))));
            IIntegrate(3950, Int(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_DEFAULT)), x_Symbol),
                    Condition(Simp(Times(b, Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), n), Power(Times(a, f, Plus(Times(C2, m), C1)), CN1)), x), And(FreeQ(List(a, b, c, d, e, f, m, n), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), EqQ(Plus(m, n, C1), C0), NeQ(Plus(Times(C2, m), C1), C0))));
        }
    }
}
