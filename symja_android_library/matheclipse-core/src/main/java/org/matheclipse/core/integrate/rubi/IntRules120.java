package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.ASymbol;
import static org.matheclipse.core.expression.F.A_;
import static org.matheclipse.core.expression.F.A_DEFAULT;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcSin;
import static org.matheclipse.core.expression.F.BSymbol;
import static org.matheclipse.core.expression.F.B_DEFAULT;
import static org.matheclipse.core.expression.F.C;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C1D4;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.C_DEFAULT;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.EllipticPi;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
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
import static org.matheclipse.core.expression.F.d_;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules120 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(3001, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Plus(Dist(Times(Subtract(Times(ASymbol, b), Times(a, BSymbol)), Power(Subtract(Times(b, c), Times(a, d)), CN1)), Int(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), CN1), x), x), Dist(Times(Subtract(Times(BSymbol, c), Times(ASymbol, d)), Power(Subtract(Times(b, c), Times(a, d)), CN1)), Int(Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), CN1), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0))));
            IIntegrate(3002, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Subtract(Dist(Times(BSymbol, Power(d, CN1)), Int(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), x), x), Dist(Times(Subtract(Times(BSymbol, c), Times(ASymbol, d)), Power(d, CN1)), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, m), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0))));
            IIntegrate(3003, Int(Times(Sqrt(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Plus(Simp(Times(CN2, BSymbol, Cos(Plus(e, Times(f, x))), Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Power(Times(f, Plus(Times(C2, n), C3)), CN1)), x), Dist(Power(Plus(Times(C2, n), C3), CN1), Int(Times(Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Subtract(n, C1)), Simp(Plus(Times(a, ASymbol, c, Plus(Times(C2, n), C3)), Times(BSymbol, Plus(Times(b, c), Times(C2, a, d, n))), Times(Plus(Times(BSymbol, Plus(Times(a, c), Times(b, d)), Plus(Times(C2, n), C1)), Times(ASymbol, Plus(Times(b, c), Times(a, d)), Plus(Times(C2, n), C3))), Sin(Plus(e, Times(f, x)))), Times(Plus(Times(ASymbol, b, d, Plus(Times(C2, n), C3)), Times(BSymbol, Plus(Times(a, d), Times(C2, b, c, n)))), Sqr(Sin(Plus(e, Times(f, x)))))), x), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), CN1D2)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), EqQ(Sqr(n), C1D4))));
            IIntegrate(3004, Int(Times(Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), CN1D2), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2), Plus(A_, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Simp(Times(C4, ASymbol, EllipticPi(CN1, Negate(ArcSin(Times(Cos(Plus(e, Times(f, x))), Power(Plus(C1, Sin(Plus(e, Times(f, x)))), CN1)))), Times(CN1, Subtract(a, b), Power(Plus(a, b), CN1))), Power(Times(f, Sqrt(Plus(a, b))), CN1)), x), And(FreeQ(List(a, b, e, f, ASymbol, BSymbol), x), GtQ(b, C0), GtQ(Subtract(Sqr(b), Sqr(a)), C0), EqQ(ASymbol, BSymbol))));
            IIntegrate(3005, Int(Times(Power(Times(d_, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), CN1D2), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2), Plus(A_, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Dist(Times(Sqrt(Sin(Plus(e, Times(f, x)))), Power(Times(d, Sin(Plus(e, Times(f, x)))), CN1D2)), Int(Times(Plus(ASymbol, Times(BSymbol, Sin(Plus(e, Times(f, x))))), Power(Times(Sqrt(Sin(Plus(e, Times(f, x)))), Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))))), CN1)), x), x), And(FreeQ(List(a, b, e, f, d, ASymbol, BSymbol), x), GtQ(b, C0), GtQ(Subtract(Sqr(b), Sqr(a)), C0), EqQ(ASymbol, BSymbol))));
            IIntegrate(3006, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2)), x_Symbol),
                    Condition(Subtract(Dist(Times(BSymbol, Power(d, CN1)), Int(Times(Sqrt(Plus(c, Times(d, Sin(Plus(e, Times(f, x)))))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), CN1D2)), x), x), Dist(Times(Subtract(Times(BSymbol, c), Times(ASymbol, d)), Power(d, CN1)), Int(Power(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Sqrt(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))))), CN1), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0))));
            IIntegrate(3007, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Plus(ASymbol, Times(BSymbol, Sin(Plus(e, Times(f, x))))), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n)), x), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, m, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0))));
            IIntegrate(3008, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), p_), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Sqrt(Plus(c, Times(d, Sin(Plus(e, Times(f, x)))))), Power(Times(f, Cos(Plus(e, Times(f, x)))), CN1)), Subst(Int(Times(Power(Plus(a, Times(b, x)), Subtract(m, C1D2)), Power(Plus(c, Times(d, x)), Subtract(n, C1D2)), Power(Plus(ASymbol, Times(BSymbol, x)), p)), x), x, Sin(Plus(e, Times(f, x)))), x), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, m, n, p), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3009, Int(Times(Power(Plus(A_DEFAULT, Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT)), p_), Power(Plus(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_DEFAULT), Power(Plus(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_DEFAULT)), x_Symbol),
                    Condition(Negate(Dist(Times(Sqrt(Plus(a, Times(b, Cos(Plus(e, Times(f, x)))))), Sqrt(Plus(c, Times(d, Cos(Plus(e, Times(f, x)))))), Power(Times(f, Sin(Plus(e, Times(f, x)))), CN1)), Subst(Int(Times(Power(Plus(a, Times(b, x)), Subtract(m, C1D2)), Power(Plus(c, Times(d, x)), Subtract(n, C1D2)), Power(Plus(ASymbol, Times(BSymbol, x)), p)), x), x, Cos(Plus(e, Times(f, x)))), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, m, n, p), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3010, Int(Times(Power(Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_DEFAULT), Plus(Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Dist(Power(b, CN1), Int(Times(Power(Times(b, Sin(Plus(e, Times(f, x)))), Plus(m, C1)), Plus(BSymbol, Times(C, Sin(Plus(e, Times(f, x)))))), x), x), FreeQ(List(b, e, f, BSymbol, C, m), x)));
            IIntegrate(3011, Int(Times(Power(Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_DEFAULT), Plus(A_, Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Simp(Times(ASymbol, Cos(Plus(e, Times(f, x))), Power(Times(b, Sin(Plus(e, Times(f, x)))), Plus(m, C1)), Power(Times(b, f, Plus(m, C1)), CN1)), x), And(FreeQ(List(b, e, f, ASymbol, C, m), x), EqQ(Plus(Times(ASymbol, Plus(m, C2)), Times(C, Plus(m, C1))), C0))));
            IIntegrate(3012, Int(Times(Power(Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_), Plus(A_, Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Simp(Times(ASymbol, Cos(Plus(e, Times(f, x))), Power(Times(b, Sin(Plus(e, Times(f, x)))), Plus(m, C1)), Power(Times(b, f, Plus(m, C1)), CN1)), x), Dist(Times(Plus(Times(ASymbol, Plus(m, C2)), Times(C, Plus(m, C1))), Power(Times(Sqr(b), Plus(m, C1)), CN1)), Int(Power(Times(b, Sin(Plus(e, Times(f, x)))), Plus(m, C2)), x), x)), And(FreeQ(List(b, e, f, ASymbol, C), x), LtQ(m, CN1))));
            IIntegrate(3013, Int(Times(Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), m_DEFAULT), Plus(A_, Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Negate(Dist(Power(f, CN1), Subst(Int(Times(Power(Subtract(C1, Sqr(x)), Times(C1D2, Subtract(m, C1))), Subtract(Plus(ASymbol, C), Times(C, Sqr(x)))), x), x, Cos(Plus(e, Times(f, x)))), x)), And(FreeQ(List(e, f, ASymbol, C), x), IGtQ(Times(C1D2, Plus(m, C1)), C0))));
            IIntegrate(3014, Int(Times(Power(Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_DEFAULT), Plus(A_, Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(C, Cos(Plus(e, Times(f, x))), Power(Times(b, Sin(Plus(e, Times(f, x)))), Plus(m, C1)), Power(Times(b, f, Plus(m, C2)), CN1)), x)), Dist(Times(Plus(Times(ASymbol, Plus(m, C2)), Times(C, Plus(m, C1))), Power(Plus(m, C2), CN1)), Int(Power(Times(b, Sin(Plus(e, Times(f, x)))), m), x), x)), And(FreeQ(List(b, e, f, ASymbol, C, m), x), Not(LtQ(m, CN1)))));
            IIntegrate(3015, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Dist(Power(b, CN2), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Simp(Plus(Times(b, BSymbol), Times(CN1, a, C), Times(b, C, Sin(Plus(e, Times(f, x))))), x)), x), x), And(FreeQ(List(a, b, e, f, ASymbol, BSymbol, C, m), x), EqQ(Plus(Times(ASymbol, Sqr(b)), Times(CN1, a, b, BSymbol), Times(Sqr(a), C)), C0))));
            IIntegrate(3016, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Dist(Times(C, Power(b, CN2)), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Simp(Plus(Negate(a), Times(b, Sin(Plus(e, Times(f, x))))), x)), x), x), And(FreeQ(List(a, b, e, f, ASymbol, C, m), x), EqQ(Plus(Times(ASymbol, Sqr(b)), Times(Sqr(a), C)), C0))));
            IIntegrate(3017, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Dist(Subtract(ASymbol, C), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Plus(C1, Sin(Plus(e, Times(f, x))))), x), x), Dist(C, Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Sqr(Plus(C1, Sin(Plus(e, Times(f, x)))))), x), x)), And(FreeQ(List(a, b, e, f, ASymbol, BSymbol, C, m), x), EqQ(Plus(ASymbol, Negate(BSymbol), C), C0), Not(IntegerQ(Times(C2, m))))));
            IIntegrate(3018, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Dist(Subtract(ASymbol, C), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Plus(C1, Sin(Plus(e, Times(f, x))))), x), x), Dist(C, Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Sqr(Plus(C1, Sin(Plus(e, Times(f, x)))))), x), x)), And(FreeQ(List(a, b, e, f, ASymbol, C, m), x), EqQ(Plus(ASymbol, C), C0), Not(IntegerQ(Times(C2, m))))));
            IIntegrate(3019, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(Times(ASymbol, b), Times(CN1, a, BSymbol), Times(b, C)), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Times(a, f, Plus(Times(C2, m), C1)), CN1)), x), Dist(Power(Times(Sqr(a), Plus(Times(C2, m), C1)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Simp(Plus(Times(a, ASymbol, Plus(m, C1)), Times(m, Subtract(Times(b, BSymbol), Times(a, C))), Times(b, C, Plus(Times(C2, m), C1), Sin(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, e, f, ASymbol, BSymbol, C), x), LtQ(m, CN1), EqQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3020, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Simp(Times(b, Plus(ASymbol, C), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Times(a, f, Plus(Times(C2, m), C1)), CN1)), x), Dist(Power(Times(Sqr(a), Plus(Times(C2, m), C1)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Simp(Plus(Times(a, ASymbol, Plus(m, C1)), Times(CN1, a, C, m), Times(b, C, Plus(Times(C2, m), C1), Sin(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, e, f, ASymbol, C), x), LtQ(m, CN1), EqQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3021, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Plus(Times(ASymbol, Sqr(b)), Times(CN1, a, b, BSymbol), Times(Sqr(a), C)), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(b, f, Plus(m, C1), Subtract(Sqr(a), Sqr(b))), CN1)), x)), Dist(Power(Times(b, Plus(m, C1), Subtract(Sqr(a), Sqr(b))), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Simp(Subtract(Times(b, Plus(Times(a, ASymbol), Times(CN1, b, BSymbol), Times(a, C)), Plus(m, C1)), Times(Plus(Times(ASymbol, Sqr(b)), Times(CN1, a, b, BSymbol), Times(Sqr(a), C), Times(b, Plus(Times(ASymbol, b), Times(CN1, a, BSymbol), Times(b, C)), Plus(m, C1))), Sin(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, e, f, ASymbol, BSymbol, C), x), LtQ(m, CN1), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3022, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Plus(Times(ASymbol, Sqr(b)), Times(Sqr(a), C)), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(b, f, Plus(m, C1), Subtract(Sqr(a), Sqr(b))), CN1)), x)), Dist(Power(Times(b, Plus(m, C1), Subtract(Sqr(a), Sqr(b))), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Simp(Subtract(Times(a, b, Plus(ASymbol, C), Plus(m, C1)), Times(Plus(Times(ASymbol, Sqr(b)), Times(Sqr(a), C), Times(Sqr(b), Plus(ASymbol, C), Plus(m, C1))), Sin(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, e, f, ASymbol, C), x), LtQ(m, CN1), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3023, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(C, Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(b, f, Plus(m, C2)), CN1)), x)), Dist(Power(Times(b, Plus(m, C2)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Simp(Plus(Times(ASymbol, b, Plus(m, C2)), Times(b, C, Plus(m, C1)), Times(Subtract(Times(b, BSymbol, Plus(m, C2)), Times(a, C)), Sin(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, e, f, ASymbol, BSymbol, C, m), x), Not(LtQ(m, CN1)))));
            IIntegrate(3024, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(C, Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(b, f, Plus(m, C2)), CN1)), x)), Dist(Power(Times(b, Plus(m, C2)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Simp(Subtract(Plus(Times(ASymbol, b, Plus(m, C2)), Times(b, C, Plus(m, C1))), Times(a, C, Sin(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, e, f, ASymbol, C, m), x), Not(LtQ(m, CN1)))));
            IIntegrate(3025, Int(Times(Power(Times(b_DEFAULT, Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), p_)), m_), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Dist(Times(Power(Times(b, Power(Sin(Plus(e, Times(f, x))), p)), m), Power(Power(Times(b, Sin(Plus(e, Times(f, x)))), Times(m, p)), CN1)), Int(Times(Power(Times(b, Sin(Plus(e, Times(f, x)))), Times(m, p)), Plus(ASymbol, Times(BSymbol, Sin(Plus(e, Times(f, x)))), Times(C, Sqr(Sin(Plus(e, Times(f, x))))))), x), x), And(FreeQ(List(b, e, f, ASymbol, BSymbol, C, m, p), x), Not(IntegerQ(m)))));
        }
    }
}
