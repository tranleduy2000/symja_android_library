package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Cot;
import static org.matheclipse.core.expression.F.Csc;
import static org.matheclipse.core.expression.F.FSymbol;
import static org.matheclipse.core.expression.F.F_;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sec;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Tan;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
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
import static org.matheclipse.core.expression.F.m;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.F;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.TrigQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules181 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(4526, Int(Times(Power(Plus(Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), CN1), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_)), x_Symbol),
                    Condition(Plus(Dist(Times(a, Power(b, CN2)), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Sin(Plus(c, Times(d, x))), Subtract(n, C2))), x), x), Negate(Dist(Power(b, CN1), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Sin(Plus(c, Times(d, x))), Subtract(n, C2)), Cos(Plus(c, Times(d, x)))), x), x)), Negate(Dist(Times(Subtract(Sqr(a), Sqr(b)), Power(b, CN2)), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Sin(Plus(c, Times(d, x))), Subtract(n, C2)), Power(Plus(a, Times(b, Cos(Plus(c, Times(d, x))))), CN1)), x), x))), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(n, C1), NeQ(Subtract(Sqr(a), Sqr(b)), C0), IGtQ(m, C0))));
            IIntegrate(4527, Int(Times(Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), CN1), Power(Tan(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_DEFAULT)), x_Symbol),
                    Condition(Subtract(Dist(Power(b, CN1), Int(Times(Power(Plus(e, Times(f, x)), m), Sec(Plus(c, Times(d, x))), Power(Tan(Plus(c, Times(d, x))), Subtract(n, C1))), x), x), Dist(Times(a, Power(b, CN1)), Int(Times(Power(Plus(e, Times(f, x)), m), Sec(Plus(c, Times(d, x))), Power(Tan(Plus(c, Times(d, x))), Subtract(n, C1)), Power(Plus(a, Times(b, Sin(Plus(c, Times(d, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0), IGtQ(n, C0))));
            IIntegrate(4528, Int(Times(Power(Cot(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_DEFAULT), Power(Plus(Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), CN1), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Subtract(Dist(Power(b, CN1), Int(Times(Power(Plus(e, Times(f, x)), m), Csc(Plus(c, Times(d, x))), Power(Cot(Plus(c, Times(d, x))), Subtract(n, C1))), x), x), Dist(Times(a, Power(b, CN1)), Int(Times(Power(Plus(e, Times(f, x)), m), Csc(Plus(c, Times(d, x))), Power(Cot(Plus(c, Times(d, x))), Subtract(n, C1)), Power(Plus(a, Times(b, Cos(Plus(c, Times(d, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0), IGtQ(n, C0))));
            IIntegrate(4529, Int(Times(Power(Cot(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Power(a, CN1), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Cot(Plus(c, Times(d, x))), n)), x), x), Dist(Times(b, Power(a, CN1)), Int(Times(Power(Plus(e, Times(f, x)), m), Cos(Plus(c, Times(d, x))), Power(Cot(Plus(c, Times(d, x))), Subtract(n, C1)), Power(Plus(a, Times(b, Sin(Plus(c, Times(d, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0), IGtQ(n, C0))));
            IIntegrate(4530, Int(Times(Power(Plus(Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), CN1), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Tan(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_DEFAULT)), x_Symbol),
                    Condition(Subtract(Dist(Power(a, CN1), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Tan(Plus(c, Times(d, x))), n)), x), x), Dist(Times(b, Power(a, CN1)), Int(Times(Power(Plus(e, Times(f, x)), m), Sin(Plus(c, Times(d, x))), Power(Tan(Plus(c, Times(d, x))), Subtract(n, C1)), Power(Plus(a, Times(b, Cos(Plus(c, Times(d, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0), IGtQ(n, C0))));
            IIntegrate(4531, Int(Times(Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Sec(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Power(a, CN1), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Sec(Plus(c, Times(d, x))), Plus(n, C2))), x), x), Dist(Power(b, CN1), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Sec(Plus(c, Times(d, x))), Plus(n, C1)), Tan(Plus(c, Times(d, x)))), x), x)), And(FreeQ(List(a, b, c, d, e, f, n), x), IGtQ(m, C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(4532, Int(Times(Power(Csc(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_DEFAULT), Power(Plus(Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), CN1), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Subtract(Dist(Power(a, CN1), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Csc(Plus(c, Times(d, x))), Plus(n, C2))), x), x), Dist(Power(b, CN1), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Csc(Plus(c, Times(d, x))), Plus(n, C1)), Cot(Plus(c, Times(d, x)))), x), x)), And(FreeQ(List(a, b, c, d, e, f, n), x), IGtQ(m, C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(4533, Int(Times(Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Sec(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Plus(Negate(Dist(Times(Sqr(b), Power(Subtract(Sqr(a), Sqr(b)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Sec(Plus(c, Times(d, x))), Subtract(n, C2)), Power(Plus(a, Times(b, Sin(Plus(c, Times(d, x))))), CN1)), x), x)), Dist(Power(Subtract(Sqr(a), Sqr(b)), CN1), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Sec(Plus(c, Times(d, x))), n), Subtract(a, Times(b, Sin(Plus(c, Times(d, x)))))), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), IGtQ(n, C0))));
            IIntegrate(4534, Int(Times(Power(Csc(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_DEFAULT), Power(Plus(Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), CN1), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Negate(Dist(Times(Sqr(b), Power(Subtract(Sqr(a), Sqr(b)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Csc(Plus(c, Times(d, x))), Subtract(n, C2)), Power(Plus(a, Times(b, Cos(Plus(c, Times(d, x))))), CN1)), x), x)), Dist(Power(Subtract(Sqr(a), Sqr(b)), CN1), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Csc(Plus(c, Times(d, x))), n), Subtract(a, Times(b, Cos(Plus(c, Times(d, x)))))), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), IGtQ(n, C0))));
            IIntegrate(4535, Int(Times(Power(Csc(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Power(a, CN1), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Csc(Plus(c, Times(d, x))), n)), x), x), Dist(Times(b, Power(a, CN1)), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Csc(Plus(c, Times(d, x))), Subtract(n, C1)), Power(Plus(a, Times(b, Sin(Plus(c, Times(d, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0), IGtQ(n, C0))));
            IIntegrate(4536, Int(Times(Power(Plus(Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), CN1), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Sec(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_DEFAULT)), x_Symbol),
                    Condition(Subtract(Dist(Power(a, CN1), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Sec(Plus(c, Times(d, x))), n)), x), x), Dist(Times(b, Power(a, CN1)), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Sec(Plus(c, Times(d, x))), Subtract(n, C1)), Power(Plus(a, Times(b, Cos(Plus(c, Times(d, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0), IGtQ(n, C0))));
            IIntegrate(4537, Int(Times(Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), CN1), Power($(F_, Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(e, Times(f, x)), m), Power(F(Plus(c, Times(d, x))), n), Power(Plus(a, Times(b, Sin(Plus(c, Times(d, x))))), CN1)), x), And(FreeQ(List(a, b, c, d, e, f, m, n), x), TrigQ(FSymbol))));
            IIntegrate(4538, Int(Times(Power(Plus(Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), CN1), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power($(F_, Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(e, Times(f, x)), m), Power(F(Plus(c, Times(d, x))), n), Power(Plus(a, Times(b, Cos(Plus(c, Times(d, x))))), CN1)), x), And(FreeQ(List(a, b, c, d, e, f, m, n), x), TrigQ(FSymbol))));
            IIntegrate(4539, Int(Times(Power(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), p_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Power(b, CN1), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Cos(Plus(c, Times(d, x))), p), Power(Sin(Plus(c, Times(d, x))), Subtract(n, C1))), x), x), Dist(Times(a, Power(b, CN1)), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Cos(Plus(c, Times(d, x))), p), Power(Sin(Plus(c, Times(d, x))), Subtract(n, C1)), Power(Plus(a, Times(b, Sin(Plus(c, Times(d, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0), IGtQ(n, C0), IGtQ(p, C0))));
            IIntegrate(4540, Int(Times(Power(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_DEFAULT), Power(Plus(Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), CN1), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), p_DEFAULT)), x_Symbol),
                    Condition(Subtract(Dist(Power(b, CN1), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Sin(Plus(c, Times(d, x))), p), Power(Cos(Plus(c, Times(d, x))), Subtract(n, C1))), x), x), Dist(Times(a, Power(b, CN1)), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Sin(Plus(c, Times(d, x))), p), Power(Cos(Plus(c, Times(d, x))), Subtract(n, C1)), Power(Plus(a, Times(b, Cos(Plus(c, Times(d, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0), IGtQ(n, C0), IGtQ(p, C0))));
            IIntegrate(4541, Int(Times(Power(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), p_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), CN1), Power(Tan(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_DEFAULT)), x_Symbol),
                    Condition(Subtract(Dist(Power(b, CN1), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Cos(Plus(c, Times(d, x))), Subtract(p, C1)), Power(Tan(Plus(c, Times(d, x))), Subtract(n, C1))), x), x), Dist(Times(a, Power(b, CN1)), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Cos(Plus(c, Times(d, x))), Subtract(p, C1)), Power(Tan(Plus(c, Times(d, x))), Subtract(n, C1)), Power(Plus(a, Times(b, Sin(Plus(c, Times(d, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0), IGtQ(n, C0), IGtQ(p, C0))));
            IIntegrate(4542, Int(Times(Power(Cot(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_DEFAULT), Power(Plus(Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), CN1), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), p_DEFAULT)), x_Symbol),
                    Condition(Subtract(Dist(Power(b, CN1), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Sin(Plus(c, Times(d, x))), Subtract(p, C1)), Power(Cot(Plus(c, Times(d, x))), Subtract(n, C1))), x), x), Dist(Times(a, Power(b, CN1)), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Sin(Plus(c, Times(d, x))), Subtract(p, C1)), Power(Cot(Plus(c, Times(d, x))), Subtract(n, C1)), Power(Plus(a, Times(b, Cos(Plus(c, Times(d, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0), IGtQ(n, C0), IGtQ(p, C0))));
            IIntegrate(4543, Int(Times(Power(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), p_DEFAULT), Power(Cot(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Power(a, CN1), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Cos(Plus(c, Times(d, x))), p), Power(Cot(Plus(c, Times(d, x))), n)), x), x), Dist(Times(b, Power(a, CN1)), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Cos(Plus(c, Times(d, x))), Plus(p, C1)), Power(Cot(Plus(c, Times(d, x))), Subtract(n, C1)), Power(Plus(a, Times(b, Sin(Plus(c, Times(d, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0), IGtQ(n, C0), IGtQ(p, C0))));
            IIntegrate(4544, Int(Times(Power(Plus(Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), CN1), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), p_DEFAULT), Power(Tan(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_DEFAULT)), x_Symbol),
                    Condition(Subtract(Dist(Power(a, CN1), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Sin(Plus(c, Times(d, x))), p), Power(Tan(Plus(c, Times(d, x))), n)), x), x), Dist(Times(b, Power(a, CN1)), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Sin(Plus(c, Times(d, x))), Plus(p, C1)), Power(Tan(Plus(c, Times(d, x))), Subtract(n, C1)), Power(Plus(a, Times(b, Cos(Plus(c, Times(d, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0), IGtQ(n, C0), IGtQ(p, C0))));
            IIntegrate(4545, Int(Times(Power(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), p_DEFAULT), Power(Csc(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Power(a, CN1), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Cos(Plus(c, Times(d, x))), p), Power(Csc(Plus(c, Times(d, x))), n)), x), x), Dist(Times(b, Power(a, CN1)), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Cos(Plus(c, Times(d, x))), p), Power(Csc(Plus(c, Times(d, x))), Subtract(n, C1)), Power(Plus(a, Times(b, Sin(Plus(c, Times(d, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0), IGtQ(n, C0), IGtQ(p, C0))));
            IIntegrate(4546, Int(Times(Power(Plus(Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), CN1), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Sec(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_DEFAULT), Power(Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), p_DEFAULT)), x_Symbol),
                    Condition(Subtract(Dist(Power(a, CN1), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Sin(Plus(c, Times(d, x))), p), Power(Sec(Plus(c, Times(d, x))), n)), x), x), Dist(Times(b, Power(a, CN1)), Int(Times(Power(Plus(e, Times(f, x)), m), Power(Sin(Plus(c, Times(d, x))), p), Power(Sec(Plus(c, Times(d, x))), Subtract(n, C1)), Power(Plus(a, Times(b, Cos(Plus(c, Times(d, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0), IGtQ(n, C0), IGtQ(p, C0))));
            IIntegrate(4547, Int(Times(Power(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), p_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), CN1), Power($(F_, Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(e, Times(f, x)), m), Power(Cos(Plus(c, Times(d, x))), p), Power(F(Plus(c, Times(d, x))), n), Power(Plus(a, Times(b, Sin(Plus(c, Times(d, x))))), CN1)), x), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), TrigQ(FSymbol))));
            IIntegrate(4548, Int(Times(Power(Plus(Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), CN1), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), p_DEFAULT), Power($(F_, Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(e, Times(f, x)), m), Power(F(Plus(c, Times(d, x))), n), Power(Sin(Plus(c, Times(d, x))), p), Power(Plus(a, Times(b, Cos(Plus(c, Times(d, x))))), CN1)), x), And(FreeQ(List(a, b, c, d, e, f, m, n), x), TrigQ(FSymbol))));
            IIntegrate(4549, Int(Times(Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sec(Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), CN1), Power($(F_, Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Plus(e, Times(f, x)), m), Cos(Plus(c, Times(d, x))), Power(F(Plus(c, Times(d, x))), n), Power(Plus(b, Times(a, Cos(Plus(c, Times(d, x))))), CN1)), x), And(FreeQ(List(a, b, c, d, e, f), x), TrigQ(FSymbol), IntegersQ(m, n))));
            IIntegrate(4550, Int(Times(Power(Plus(Times(Csc(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), CN1), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power($(F_, Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Plus(e, Times(f, x)), m), Sin(Plus(c, Times(d, x))), Power(F(Plus(c, Times(d, x))), n), Power(Plus(b, Times(a, Sin(Plus(c, Times(d, x))))), CN1)), x), And(FreeQ(List(a, b, c, d, e, f), x), TrigQ(FSymbol), IntegersQ(m, n))));
        }
    }
}
