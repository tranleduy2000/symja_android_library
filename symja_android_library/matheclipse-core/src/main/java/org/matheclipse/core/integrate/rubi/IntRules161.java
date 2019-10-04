package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.ASymbol;
import static org.matheclipse.core.expression.F.A_;
import static org.matheclipse.core.expression.F.A_DEFAULT;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.BSymbol;
import static org.matheclipse.core.expression.F.B_DEFAULT;
import static org.matheclipse.core.expression.F.C;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.C_DEFAULT;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules161 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(4026, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), n_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_), Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), A_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, BSymbol, Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Times(d, Csc(Plus(e, Times(f, x)))), n), Power(Times(f, Plus(m, n)), CN1)), x)), Dist(Power(Plus(m, n), CN1), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Subtract(m, C2)), Power(Times(d, Csc(Plus(e, Times(f, x)))), n), Simp(Plus(Times(Sqr(a), ASymbol, Plus(m, n)), Times(a, b, BSymbol, n), Times(Plus(Times(a, Plus(Times(C2, ASymbol, b), Times(a, BSymbol)), Plus(m, n)), Times(Sqr(b), BSymbol, Subtract(Plus(m, n), C1))), Csc(Plus(e, Times(f, x)))), Times(b, Plus(Times(ASymbol, b, Plus(m, n)), Times(a, BSymbol, Subtract(Plus(Times(C2, m), n), C1))), Sqr(Csc(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, d, e, f, ASymbol, BSymbol, n), x), NeQ(Subtract(Times(ASymbol, b), Times(a, BSymbol)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), GtQ(m, C1), Not(And(IGtQ(n, C1), Not(IntegerQ(m)))))));
            IIntegrate(4027, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), n_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_), Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), A_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(d, Subtract(Times(ASymbol, b), Times(a, BSymbol)), Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(d, Csc(Plus(e, Times(f, x)))), Subtract(n, C1)), Power(Times(f, Plus(m, C1), Subtract(Sqr(a), Sqr(b))), CN1)), x)), Dist(Power(Times(Plus(m, C1), Subtract(Sqr(a), Sqr(b))), CN1), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(d, Csc(Plus(e, Times(f, x)))), Subtract(n, C1)), Simp(Subtract(Plus(Times(d, Subtract(n, C1), Subtract(Times(ASymbol, b), Times(a, BSymbol))), Times(d, Subtract(Times(a, ASymbol), Times(b, BSymbol)), Plus(m, C1), Csc(Plus(e, Times(f, x))))), Times(d, Subtract(Times(ASymbol, b), Times(a, BSymbol)), Plus(m, n, C1), Sqr(Csc(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, d, e, f, ASymbol, BSymbol), x), NeQ(Subtract(Times(ASymbol, b), Times(a, BSymbol)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), LtQ(m, CN1), LtQ(C0, n, C1))));
            IIntegrate(4028, Int(Times(Power($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), C3), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_), Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), A_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Sqr(a), Subtract(Times(ASymbol, b), Times(a, BSymbol)), Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(Sqr(b), f, Plus(m, C1), Subtract(Sqr(a), Sqr(b))), CN1)), x)), Dist(Power(Times(Sqr(b), Plus(m, C1), Subtract(Sqr(a), Sqr(b))), CN1), Int(Times(Csc(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Simp(Plus(Times(a, b, Subtract(Times(ASymbol, b), Times(a, BSymbol)), Plus(m, C1)), Times(CN1, Subtract(Times(ASymbol, b), Times(a, BSymbol)), Plus(Sqr(a), Times(Sqr(b), Plus(m, C1))), Csc(Plus(e, Times(f, x)))), Times(b, BSymbol, Plus(m, C1), Subtract(Sqr(a), Sqr(b)), Sqr(Csc(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, e, f, ASymbol, BSymbol), x), NeQ(Subtract(Times(ASymbol, b), Times(a, BSymbol)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), LtQ(m, CN1))));
            IIntegrate(4029, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), n_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_), Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), A_)), x_Symbol),
                    Condition(Subtract(Simp(Times(a, Sqr(d), Subtract(Times(ASymbol, b), Times(a, BSymbol)), Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(d, Csc(Plus(e, Times(f, x)))), Subtract(n, C2)), Power(Times(b, f, Plus(m, C1), Subtract(Sqr(a), Sqr(b))), CN1)), x), Dist(Times(d, Power(Times(b, Plus(m, C1), Subtract(Sqr(a), Sqr(b))), CN1)), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(d, Csc(Plus(e, Times(f, x)))), Subtract(n, C2)), Simp(Subtract(Plus(Times(a, d, Subtract(Times(ASymbol, b), Times(a, BSymbol)), Subtract(n, C2)), Times(b, d, Subtract(Times(ASymbol, b), Times(a, BSymbol)), Plus(m, C1), Csc(Plus(e, Times(f, x))))), Times(Subtract(Times(a, ASymbol, b, d, Plus(m, n)), Times(d, BSymbol, Plus(Times(Sqr(a), Subtract(n, C1)), Times(Sqr(b), Plus(m, C1))))), Sqr(Csc(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, d, e, f, ASymbol, BSymbol), x), NeQ(Subtract(Times(ASymbol, b), Times(a, BSymbol)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), LtQ(m, CN1), GtQ(n, C1))));
            IIntegrate(4030, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), n_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_), Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), A_)), x_Symbol),
                    Condition(Plus(Simp(Times(b, Subtract(Times(ASymbol, b), Times(a, BSymbol)), Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(d, Csc(Plus(e, Times(f, x)))), n), Power(Times(a, f, Plus(m, C1), Subtract(Sqr(a), Sqr(b))), CN1)), x), Dist(Power(Times(a, Plus(m, C1), Subtract(Sqr(a), Sqr(b))), CN1), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(d, Csc(Plus(e, Times(f, x)))), n), Simp(Plus(Times(ASymbol, Subtract(Times(Sqr(a), Plus(m, C1)), Times(Sqr(b), Plus(m, n, C1)))), Times(a, b, BSymbol, n), Times(CN1, a, Subtract(Times(ASymbol, b), Times(a, BSymbol)), Plus(m, C1), Csc(Plus(e, Times(f, x)))), Times(b, Subtract(Times(ASymbol, b), Times(a, BSymbol)), Plus(m, n, C2), Sqr(Csc(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, d, e, f, ASymbol, BSymbol, n), x), NeQ(Subtract(Times(ASymbol, b), Times(a, BSymbol)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), LtQ(m, CN1), Not(And(ILtQ(Plus(m, C1D2), C0), ILtQ(n, C0))))));
            IIntegrate(4031, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), n_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_), Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), A_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(BSymbol, d, Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Power(Times(d, Csc(Plus(e, Times(f, x)))), Subtract(n, C1)), Power(Times(f, Plus(m, n)), CN1)), x)), Dist(Times(d, Power(Plus(m, n), CN1)), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Times(d, Csc(Plus(e, Times(f, x)))), Subtract(n, C1)), Simp(Plus(Times(a, BSymbol, Subtract(n, C1)), Times(Plus(Times(b, BSymbol, Subtract(Plus(m, n), C1)), Times(a, ASymbol, Plus(m, n))), Csc(Plus(e, Times(f, x)))), Times(Plus(Times(a, BSymbol, m), Times(ASymbol, b, Plus(m, n))), Sqr(Csc(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, d, e, f, ASymbol, BSymbol), x), NeQ(Subtract(Times(ASymbol, b), Times(a, BSymbol)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), LtQ(C0, m, C1), GtQ(n, C0))));
            IIntegrate(4032, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), n_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_), Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), A_)), x_Symbol),
                    Condition(Subtract(Simp(Times(ASymbol, Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Power(Times(d, Csc(Plus(e, Times(f, x)))), n), Power(Times(f, n), CN1)), x), Dist(Power(Times(d, n), CN1), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Times(d, Csc(Plus(e, Times(f, x)))), Plus(n, C1)), Simp(Subtract(Subtract(Subtract(Times(ASymbol, b, m), Times(a, BSymbol, n)), Times(Plus(Times(b, BSymbol, n), Times(a, ASymbol, Plus(n, C1))), Csc(Plus(e, Times(f, x))))), Times(ASymbol, b, Plus(m, n, C1), Sqr(Csc(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, d, e, f, ASymbol, BSymbol), x), NeQ(Subtract(Times(ASymbol, b), Times(a, BSymbol)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), LtQ(C0, m, C1), LeQ(n, CN1))));
            IIntegrate(4033, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), n_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_), Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), A_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(BSymbol, Sqr(d), Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(d, Csc(Plus(e, Times(f, x)))), Subtract(n, C2)), Power(Times(b, f, Plus(m, n)), CN1)), x)), Dist(Times(Sqr(d), Power(Times(b, Plus(m, n)), CN1)), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Power(Times(d, Csc(Plus(e, Times(f, x)))), Subtract(n, C2)), Simp(Plus(Times(a, BSymbol, Subtract(n, C2)), Times(BSymbol, b, Subtract(Plus(m, n), C1), Csc(Plus(e, Times(f, x)))), Times(Subtract(Times(ASymbol, b, Plus(m, n)), Times(a, BSymbol, Subtract(n, C1))), Sqr(Csc(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, d, e, f, ASymbol, BSymbol, m), x), NeQ(Subtract(Times(ASymbol, b), Times(a, BSymbol)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), GtQ(n, C1), NeQ(Plus(m, n), C0), Not(IGtQ(m, C1)))));
            IIntegrate(4034, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), n_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_), Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), A_)), x_Symbol),
                    Condition(Plus(Simp(Times(ASymbol, Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(d, Csc(Plus(e, Times(f, x)))), n), Power(Times(a, f, n), CN1)), x), Dist(Power(Times(a, d, n), CN1), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Power(Times(d, Csc(Plus(e, Times(f, x)))), Plus(n, C1)), Simp(Plus(Times(a, BSymbol, n), Times(CN1, ASymbol, b, Plus(m, n, C1)), Times(ASymbol, a, Plus(n, C1), Csc(Plus(e, Times(f, x)))), Times(ASymbol, b, Plus(m, n, C2), Sqr(Csc(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, d, e, f, ASymbol, BSymbol, m), x), NeQ(Subtract(Times(ASymbol, b), Times(a, BSymbol)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), LeQ(n, CN1))));
            IIntegrate(4035, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), CN1D2), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), CN1D2), Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), A_)), x_Symbol),
                    Condition(Subtract(Dist(Times(ASymbol, Power(a, CN1)), Int(Times(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Power(Times(d, Csc(Plus(e, Times(f, x)))), CN1D2)), x), x), Dist(Times(Subtract(Times(ASymbol, b), Times(a, BSymbol)), Power(Times(a, d), CN1)), Int(Times(Sqrt(Times(d, Csc(Plus(e, Times(f, x))))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2)), x), x)), And(FreeQ(List(a, b, d, e, f, ASymbol, BSymbol), x), NeQ(Subtract(Times(ASymbol, b), Times(a, BSymbol)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(4036, Int(Times(Sqrt(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), CN1D2), Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), A_)), x_Symbol),
                    Condition(Plus(Dist(ASymbol, Int(Times(Sqrt(Times(d, Csc(Plus(e, Times(f, x))))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2)), x), x), Dist(Times(BSymbol, Power(d, CN1)), Int(Times(Power(Times(d, Csc(Plus(e, Times(f, x)))), QQ(3L, 2L)), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2)), x), x)), And(FreeQ(List(a, b, d, e, f, ASymbol, BSymbol), x), NeQ(Subtract(Times(ASymbol, b), Times(a, BSymbol)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(4037, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), CN1D2), Sqrt(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_)), Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), A_)), x_Symbol),
                    Condition(Plus(Dist(Times(BSymbol, Power(d, CN1)), Int(Times(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Sqrt(Times(d, Csc(Plus(e, Times(f, x)))))), x), x), Dist(ASymbol, Int(Times(Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x)))))), Power(Times(d, Csc(Plus(e, Times(f, x)))), CN1D2)), x), x)), And(FreeQ(List(a, b, d, e, f, ASymbol, BSymbol), x), NeQ(Subtract(Times(ASymbol, b), Times(a, BSymbol)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(4038, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), n_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), CN1), Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), A_)), x_Symbol),
                    Condition(Subtract(Dist(Times(ASymbol, Power(a, CN1)), Int(Power(Times(d, Csc(Plus(e, Times(f, x)))), n), x), x), Dist(Times(Subtract(Times(ASymbol, b), Times(a, BSymbol)), Power(Times(a, d), CN1)), Int(Times(Power(Times(d, Csc(Plus(e, Times(f, x)))), Plus(n, C1)), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1)), x), x)), And(FreeQ(List(a, b, d, e, f, ASymbol, BSymbol, n), x), NeQ(Subtract(Times(ASymbol, b), Times(a, BSymbol)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(4039, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), n_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_), Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), A_)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Times(d, Csc(Plus(e, Times(f, x)))), n), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Plus(ASymbol, Times(BSymbol, Csc(Plus(e, Times(f, x)))))), x), And(FreeQ(List(a, b, d, e, f, ASymbol, BSymbol, m, n), x), NeQ(Subtract(Times(ASymbol, b), Times(a, BSymbol)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(4040, Int(Times(Power(Plus(A_DEFAULT, Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT)), p_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Times(CN1, a, c), m), Int(Times(Power(Cos(Plus(e, Times(f, x))), Times(C2, m)), Power(Plus(d, Times(c, Sin(Plus(e, Times(f, x))))), Subtract(n, m)), Power(Plus(BSymbol, Times(ASymbol, Sin(Plus(e, Times(f, x))))), p), Power(Power(Sin(Plus(e, Times(f, x))), Plus(m, n, p)), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, n, p), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegersQ(m, n, p))));
            IIntegrate(4041, Int(Times(Plus(A_DEFAULT, Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(b, CN2), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Simp(Plus(Times(b, BSymbol), Times(CN1, a, C), Times(b, C, Csc(Plus(e, Times(f, x))))), x)), x), x), And(FreeQ(List(a, b, e, f, ASymbol, BSymbol, C, m), x), EqQ(Plus(Times(ASymbol, Sqr(b)), Times(CN1, a, b, BSymbol), Times(Sqr(a), C)), C0))));
            IIntegrate(4042, Int(Times(Plus(A_DEFAULT, Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(C, Power(b, CN2)), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Simp(Plus(Negate(a), Times(b, Csc(Plus(e, Times(f, x))))), x)), x), x), And(FreeQ(List(a, b, e, f, ASymbol, C, m), x), EqQ(Plus(Times(ASymbol, Sqr(b)), Times(Sqr(a), C)), C0))));
            IIntegrate(4043, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), m_DEFAULT), Plus(Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT), A_)), x_Symbol),
                    Condition(Simp(Times(ASymbol, Cot(Plus(e, Times(f, x))), Power(Times(b, Csc(Plus(e, Times(f, x)))), m), Power(Times(f, m), CN1)), x), And(FreeQ(List(b, e, f, ASymbol, C, m), x), EqQ(Plus(Times(C, m), Times(ASymbol, Plus(m, C1))), C0))));
            IIntegrate(4044, Int(Times(Power($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), m_DEFAULT), Plus(Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT), A_)), x_Symbol),
                    Condition(Int(Times(Plus(C, Times(ASymbol, Sqr(Sin(Plus(e, Times(f, x)))))), Power(Power(Sin(Plus(e, Times(f, x))), Plus(m, C2)), CN1)), x), And(FreeQ(List(e, f, ASymbol, C), x), NeQ(Plus(Times(C, m), Times(ASymbol, Plus(m, C1))), C0), ILtQ(Times(C1D2, Plus(m, C1)), C0))));
            IIntegrate(4045, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), m_DEFAULT), Plus(Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT), A_)), x_Symbol),
                    Condition(Plus(Simp(Times(ASymbol, Cot(Plus(e, Times(f, x))), Power(Times(b, Csc(Plus(e, Times(f, x)))), m), Power(Times(f, m), CN1)), x), Dist(Times(Plus(Times(C, m), Times(ASymbol, Plus(m, C1))), Power(Times(Sqr(b), m), CN1)), Int(Power(Times(b, Csc(Plus(e, Times(f, x)))), Plus(m, C2)), x), x)), And(FreeQ(List(b, e, f, ASymbol, C), x), NeQ(Plus(Times(C, m), Times(ASymbol, Plus(m, C1))), C0), LeQ(m, CN1))));
            IIntegrate(4046, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), m_DEFAULT), Plus(Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT), A_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(C, Cot(Plus(e, Times(f, x))), Power(Times(b, Csc(Plus(e, Times(f, x)))), m), Power(Times(f, Plus(m, C1)), CN1)), x)), Dist(Times(Plus(Times(C, m), Times(ASymbol, Plus(m, C1))), Power(Plus(m, C1), CN1)), Int(Power(Times(b, Csc(Plus(e, Times(f, x)))), m), x), x)), And(FreeQ(List(b, e, f, ASymbol, C, m), x), NeQ(Plus(Times(C, m), Times(ASymbol, Plus(m, C1))), C0), Not(LeQ(m, CN1)))));
            IIntegrate(4047, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), m_DEFAULT), Plus(A_DEFAULT, Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT))), x_Symbol),
                    Condition(Plus(Dist(Times(BSymbol, Power(b, CN1)), Int(Power(Times(b, Csc(Plus(e, Times(f, x)))), Plus(m, C1)), x), x), Int(Times(Power(Times(b, Csc(Plus(e, Times(f, x)))), m), Plus(ASymbol, Times(C, Sqr(Csc(Plus(e, Times(f, x))))))), x)), FreeQ(List(b, e, f, ASymbol, BSymbol, C, m), x)));
            IIntegrate(4048, Int(Times(Plus(A_DEFAULT, Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, C, Csc(Plus(e, Times(f, x))), Cot(Plus(e, Times(f, x))), Power(Times(C2, f), CN1)), x)), Dist(C1D2, Int(Simp(Plus(Times(C2, ASymbol, a), Times(Plus(Times(C2, BSymbol, a), Times(b, Plus(Times(C2, ASymbol), C))), Csc(Plus(e, Times(f, x)))), Times(C2, Plus(Times(a, C), Times(BSymbol, b)), Sqr(Csc(Plus(e, Times(f, x)))))), x), x), x)), FreeQ(List(a, b, e, f, ASymbol, BSymbol, C), x)));
            IIntegrate(4049, Int(Times(Plus(A_DEFAULT, Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, C, Csc(Plus(e, Times(f, x))), Cot(Plus(e, Times(f, x))), Power(Times(C2, f), CN1)), x)), Dist(C1D2, Int(Simp(Plus(Times(C2, ASymbol, a), Times(b, Plus(Times(C2, ASymbol), C), Csc(Plus(e, Times(f, x)))), Times(C2, a, C, Sqr(Csc(Plus(e, Times(f, x)))))), x), x), x)), FreeQ(List(a, b, e, f, ASymbol, C), x)));
            IIntegrate(4050, Int(Times(Plus(A_DEFAULT, Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), CN1)), x_Symbol),
                    Condition(Plus(Dist(Times(C, Power(b, CN1)), Int(Csc(Plus(e, Times(f, x))), x), x), Dist(Power(b, CN1), Int(Times(Plus(Times(ASymbol, b), Times(Subtract(Times(b, BSymbol), Times(a, C)), Csc(Plus(e, Times(f, x))))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1)), x), x)), FreeQ(List(a, b, e, f, ASymbol, BSymbol, C), x)));
        }
    }
}
