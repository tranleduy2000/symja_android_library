package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.ASymbol;
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
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
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

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules121 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(3026, Int(Times(Power(Times(Power($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), p_), b_DEFAULT), m_), Plus(A_DEFAULT, Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), Times(Sqr($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT))), x_Symbol),
                    Condition(Dist(Times(Power(Times(b, Power(Cos(Plus(e, Times(f, x))), p)), m), Power(Power(Times(b, Cos(Plus(e, Times(f, x)))), Times(m, p)), CN1)), Int(Times(Power(Times(b, Cos(Plus(e, Times(f, x)))), Times(m, p)), Plus(ASymbol, Times(BSymbol, Cos(Plus(e, Times(f, x)))), Times(C, Sqr(Cos(Plus(e, Times(f, x))))))), x), x), And(FreeQ(List(b, e, f, ASymbol, BSymbol, C, m, p), x), Not(IntegerQ(m)))));
            IIntegrate(3027, Int(Times(Power(Times(b_DEFAULT, Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), p_)), m_), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Dist(Times(Power(Times(b, Power(Sin(Plus(e, Times(f, x))), p)), m), Power(Power(Times(b, Sin(Plus(e, Times(f, x)))), Times(m, p)), CN1)), Int(Times(Power(Times(b, Sin(Plus(e, Times(f, x)))), Times(m, p)), Plus(ASymbol, Times(C, Sqr(Sin(Plus(e, Times(f, x))))))), x), x), And(FreeQ(List(b, e, f, ASymbol, C, m, p), x), Not(IntegerQ(m)))));
            IIntegrate(3028, Int(Times(Power(Times(Power($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), p_), b_DEFAULT), m_), Plus(A_DEFAULT, Times(Sqr($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT))), x_Symbol),
                    Condition(Dist(Times(Power(Times(b, Power(Cos(Plus(e, Times(f, x))), p)), m), Power(Power(Times(b, Cos(Plus(e, Times(f, x)))), Times(m, p)), CN1)), Int(Times(Power(Times(b, Cos(Plus(e, Times(f, x)))), Times(m, p)), Plus(ASymbol, Times(C, Sqr(Cos(Plus(e, Times(f, x))))))), x), x), And(FreeQ(List(b, e, f, ASymbol, C, m, p), x), Not(IntegerQ(m)))));
            IIntegrate(3029, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Dist(Power(b, CN2), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Plus(Times(b, BSymbol), Times(CN1, a, C), Times(b, C, Sin(Plus(e, Times(f, x)))))), x), x), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, C, m, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(Times(ASymbol, Sqr(b)), Times(CN1, a, b, BSymbol), Times(Sqr(a), C)), C0))));
            IIntegrate(3030, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Negate(Dist(Times(C, Power(b, CN2)), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Subtract(a, Times(b, Sin(Plus(e, Times(f, x)))))), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, C, m, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(Times(ASymbol, Sqr(b)), Times(Sqr(a), C)), C0))));
            IIntegrate(3031, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Subtract(Negate(Simp(Times(Subtract(Times(b, c), Times(a, d)), Plus(Times(ASymbol, Sqr(b)), Times(CN1, a, b, BSymbol), Times(Sqr(a), C)), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(Sqr(b), f, Plus(m, C1), Subtract(Sqr(a), Sqr(b))), CN1)), x)), Dist(Power(Times(Sqr(b), Plus(m, C1), Subtract(Sqr(a), Sqr(b))), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Simp(Subtract(Plus(Times(b, Plus(m, C1), Subtract(Times(Subtract(Times(b, BSymbol), Times(a, C)), Subtract(Times(b, c), Times(a, d))), Times(ASymbol, b, Subtract(Times(a, c), Times(b, d))))), Times(Plus(Times(b, BSymbol, Subtract(Plus(Times(Sqr(a), d), Times(Sqr(b), d, Plus(m, C1))), Times(a, b, c, Plus(m, C2)))), Times(Subtract(Times(b, c), Times(a, d)), Plus(Times(ASymbol, Sqr(b), Plus(m, C2)), Times(C, Plus(Sqr(a), Times(Sqr(b), Plus(m, C1))))))), Sin(Plus(e, Times(f, x))))), Times(b, C, d, Plus(m, C1), Subtract(Sqr(a), Sqr(b)), Sqr(Sin(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, C), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), LtQ(m, CN1))));
            IIntegrate(3032, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Subtract(Times(b, c), Times(a, d)), Plus(Times(ASymbol, Sqr(b)), Times(Sqr(a), C)), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(Sqr(b), f, Plus(m, C1), Subtract(Sqr(a), Sqr(b))), CN1)), x)), Dist(Power(Times(Sqr(b), Plus(m, C1), Subtract(Sqr(a), Sqr(b))), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Simp(Plus(Times(b, Plus(m, C1), Plus(Times(a, C, Subtract(Times(b, c), Times(a, d))), Times(ASymbol, b, Subtract(Times(a, c), Times(b, d))))), Times(CN1, Subtract(Times(b, c), Times(a, d)), Plus(Times(ASymbol, Sqr(b), Plus(m, C2)), Times(C, Plus(Sqr(a), Times(Sqr(b), Plus(m, C1))))), Sin(Plus(e, Times(f, x)))), Times(b, C, d, Plus(m, C1), Subtract(Sqr(a), Sqr(b)), Sqr(Sin(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, C), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), LtQ(m, CN1))));
            IIntegrate(3033, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(C, d, Cos(Plus(e, Times(f, x))), Sin(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(b, f, Plus(m, C3)), CN1)), x)), Dist(Power(Times(b, Plus(m, C3)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Simp(Subtract(Plus(Times(a, C, d), Times(ASymbol, b, c, Plus(m, C3)), Times(b, Plus(Times(BSymbol, c, Plus(m, C3)), Times(d, Plus(Times(C, Plus(m, C2)), Times(ASymbol, Plus(m, C3))))), Sin(Plus(e, Times(f, x))))), Times(Subtract(Times(C2, a, C, d), Times(b, Plus(Times(c, C), Times(BSymbol, d)), Plus(m, C3))), Sqr(Sin(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, C, m), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), Not(LtQ(m, CN1)))));
            IIntegrate(3034, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(C, d, Cos(Plus(e, Times(f, x))), Sin(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(b, f, Plus(m, C3)), CN1)), x)), Dist(Power(Times(b, Plus(m, C3)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Simp(Subtract(Plus(Times(a, C, d), Times(ASymbol, b, c, Plus(m, C3)), Times(b, d, Plus(Times(C, Plus(m, C2)), Times(ASymbol, Plus(m, C3))), Sin(Plus(e, Times(f, x))))), Times(Subtract(Times(C2, a, C, d), Times(b, c, C, Plus(m, C3))), Sqr(Sin(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, C, m), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), Not(LtQ(m, CN1)))));
            IIntegrate(3035, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Subtract(Simp(Times(Plus(Times(a, ASymbol), Times(CN1, b, BSymbol), Times(a, C)), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(C2, b, c, f, Plus(Times(C2, m), C1)), CN1)), x), Dist(Power(Times(C2, b, c, d, Plus(Times(C2, m), C1)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Simp(Plus(Times(ASymbol, Plus(Times(Sqr(c), Plus(m, C1)), Times(Sqr(d), Plus(Times(C2, m), n, C2)))), Times(CN1, BSymbol, c, d, Subtract(Subtract(m, n), C1)), Times(CN1, C, Subtract(Times(Sqr(c), m), Times(Sqr(d), Plus(n, C1)))), Times(d, Subtract(Times(Plus(Times(ASymbol, c), Times(BSymbol, d)), Plus(m, n, C2)), Times(c, C, Subtract(Times(C3, m), n))), Sin(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, C, m, n), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), Or(LtQ(m, Negate(C1D2)), And(EqQ(Plus(m, n, C2), C0), NeQ(Plus(Times(C2, m), C1), C0))))));
            IIntegrate(3036, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Subtract(Simp(Times(Plus(Times(a, ASymbol), Times(a, C)), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(C2, b, c, f, Plus(Times(C2, m), C1)), CN1)), x), Dist(Power(Times(C2, b, c, d, Plus(Times(C2, m), C1)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Simp(Plus(Times(ASymbol, Plus(Times(Sqr(c), Plus(m, C1)), Times(Sqr(d), Plus(Times(C2, m), n, C2)))), Times(CN1, C, Subtract(Times(Sqr(c), m), Times(Sqr(d), Plus(n, C1)))), Times(d, Subtract(Times(ASymbol, c, Plus(m, n, C2)), Times(c, C, Subtract(Times(C3, m), n))), Sin(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, C, m, n), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), Or(LtQ(m, Negate(C1D2)), And(EqQ(Plus(m, n, C2), C0), NeQ(Plus(Times(C2, m), C1), C0))))));
            IIntegrate(3037, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Simp(Times(CN2, C, Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(b, f, Plus(Times(C2, m), C3), Sqrt(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))))), CN1)), x), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Simp(Plus(ASymbol, C, Times(BSymbol, Sin(Plus(e, Times(f, x))))), x), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), CN1D2)), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, C, m), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), Not(LtQ(m, Negate(C1D2))))));
            IIntegrate(3038, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Simp(Times(CN2, C, Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(b, f, Plus(Times(C2, m), C3), Sqrt(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))))), CN1)), x), Dist(Plus(ASymbol, C), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), CN1D2)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, C, m), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), Not(LtQ(m, Negate(C1D2))))));
            IIntegrate(3039, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(C, Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(d, f, Plus(m, n, C2)), CN1)), x)), Dist(Power(Times(b, d, Plus(m, n, C2)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Simp(Plus(Times(ASymbol, b, d, Plus(m, n, C2)), Times(C, Plus(Times(a, c, m), Times(b, d, Plus(n, C1)))), Times(Subtract(Times(b, BSymbol, d, Plus(m, n, C2)), Times(b, c, C, Plus(Times(C2, m), C1))), Sin(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, C, m, n), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), Not(LtQ(m, Negate(C1D2))), NeQ(Plus(m, n, C2), C0))));
            IIntegrate(3040, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(C, Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(d, f, Plus(m, n, C2)), CN1)), x)), Dist(Power(Times(b, d, Plus(m, n, C2)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Simp(Subtract(Plus(Times(ASymbol, b, d, Plus(m, n, C2)), Times(C, Plus(Times(a, c, m), Times(b, d, Plus(n, C1))))), Times(b, c, C, Plus(Times(C2, m), C1), Sin(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, C, m, n), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), Not(LtQ(m, Negate(C1D2))), NeQ(Plus(m, n, C2), C0))));
            IIntegrate(3041, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(Times(a, ASymbol), Times(CN1, b, BSymbol), Times(a, C)), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(f, Subtract(Times(b, c), Times(a, d)), Plus(Times(C2, m), C1)), CN1)), x), Dist(Power(Times(b, Subtract(Times(b, c), Times(a, d)), Plus(Times(C2, m), C1)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Simp(Plus(Times(ASymbol, Subtract(Times(a, c, Plus(m, C1)), Times(b, d, Plus(Times(C2, m), n, C2)))), Times(BSymbol, Plus(Times(b, c, m), Times(a, d, Plus(n, C1)))), Times(CN1, C, Plus(Times(a, c, m), Times(b, d, Plus(n, C1)))), Times(Plus(Times(d, Subtract(Times(a, ASymbol), Times(b, BSymbol)), Plus(m, n, C2)), Times(C, Subtract(Times(b, c, Plus(Times(C2, m), C1)), Times(a, d, Subtract(Subtract(m, n), C1))))), Sin(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, C, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), LtQ(m, Negate(C1D2)))));
            IIntegrate(3042, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Simp(Times(a, Plus(ASymbol, C), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(f, Subtract(Times(b, c), Times(a, d)), Plus(Times(C2, m), C1)), CN1)), x), Dist(Power(Times(b, Subtract(Times(b, c), Times(a, d)), Plus(Times(C2, m), C1)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Simp(Plus(Times(ASymbol, Subtract(Times(a, c, Plus(m, C1)), Times(b, d, Plus(Times(C2, m), n, C2)))), Times(CN1, C, Plus(Times(a, c, m), Times(b, d, Plus(n, C1)))), Times(Plus(Times(a, ASymbol, d, Plus(m, n, C2)), Times(C, Subtract(Times(b, c, Plus(Times(C2, m), C1)), Times(a, d, Subtract(Subtract(m, n), C1))))), Sin(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, C, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), LtQ(m, Negate(C1D2)))));
            IIntegrate(3043, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Plus(Times(Sqr(c), C), Times(CN1, BSymbol, c, d), Times(ASymbol, Sqr(d))), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(d, f, Plus(n, C1), Subtract(Sqr(c), Sqr(d))), CN1)), x)), Dist(Power(Times(b, d, Plus(n, C1), Subtract(Sqr(c), Sqr(d))), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1)), Simp(Plus(Times(ASymbol, d, Plus(Times(a, d, m), Times(b, c, Plus(n, C1)))), Times(Subtract(Times(c, C), Times(BSymbol, d)), Plus(Times(a, c, m), Times(b, d, Plus(n, C1)))), Times(b, Subtract(Times(d, Subtract(Times(BSymbol, c), Times(ASymbol, d)), Plus(m, n, C2)), Times(C, Plus(Times(Sqr(c), Plus(m, C1)), Times(Sqr(d), Plus(n, C1))))), Sin(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, C, m), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), Not(LtQ(m, Negate(C1D2))), Or(LtQ(n, CN1), EqQ(Plus(m, n, C2), C0)))));
            IIntegrate(3044, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Plus(Times(Sqr(c), C), Times(ASymbol, Sqr(d))), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(d, f, Plus(n, C1), Subtract(Sqr(c), Sqr(d))), CN1)), x)), Dist(Power(Times(b, d, Plus(n, C1), Subtract(Sqr(c), Sqr(d))), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1)), Simp(Subtract(Plus(Times(ASymbol, d, Plus(Times(a, d, m), Times(b, c, Plus(n, C1)))), Times(c, C, Plus(Times(a, c, m), Times(b, d, Plus(n, C1))))), Times(b, Plus(Times(ASymbol, Sqr(d), Plus(m, n, C2)), Times(C, Plus(Times(Sqr(c), Plus(m, C1)), Times(Sqr(d), Plus(n, C1))))), Sin(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, C, m), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), Not(LtQ(m, Negate(C1D2))), Or(LtQ(n, CN1), EqQ(Plus(m, n, C2), C0)))));
            IIntegrate(3045, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(C, Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(d, f, Plus(m, n, C2)), CN1)), x)), Dist(Power(Times(b, d, Plus(m, n, C2)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Simp(Plus(Times(ASymbol, b, d, Plus(m, n, C2)), Times(C, Plus(Times(a, c, m), Times(b, d, Plus(n, C1)))), Times(Plus(Times(C, Subtract(Times(a, d, m), Times(b, c, Plus(m, C1)))), Times(b, BSymbol, d, Plus(m, n, C2))), Sin(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, C, m, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), Not(LtQ(m, Negate(C1D2))), NeQ(Plus(m, n, C2), C0))));
            IIntegrate(3046, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(C, Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(d, f, Plus(m, n, C2)), CN1)), x)), Dist(Power(Times(b, d, Plus(m, n, C2)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Simp(Plus(Times(ASymbol, b, d, Plus(m, n, C2)), Times(C, Plus(Times(a, c, m), Times(b, d, Plus(n, C1)))), Times(C, Subtract(Times(a, d, m), Times(b, c, Plus(m, C1))), Sin(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, C, m, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), Not(LtQ(m, Negate(C1D2))), NeQ(Plus(m, n, C2), C0))));
            IIntegrate(3047, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Plus(Times(Sqr(c), C), Times(CN1, BSymbol, c, d), Times(ASymbol, Sqr(d))), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(d, f, Plus(n, C1), Subtract(Sqr(c), Sqr(d))), CN1)), x)), Dist(Power(Times(d, Plus(n, C1), Subtract(Sqr(c), Sqr(d))), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1)), Simp(Plus(Times(ASymbol, d, Plus(Times(b, d, m), Times(a, c, Plus(n, C1)))), Times(Subtract(Times(c, C), Times(BSymbol, d)), Plus(Times(b, c, m), Times(a, d, Plus(n, C1)))), Times(CN1, Subtract(Times(d, Plus(Times(ASymbol, Subtract(Times(a, d, Plus(n, C2)), Times(b, c, Plus(n, C1)))), Times(BSymbol, Subtract(Times(b, d, Plus(n, C1)), Times(a, c, Plus(n, C2)))))), Times(C, Subtract(Times(b, c, d, Plus(n, C1)), Times(a, Plus(Sqr(c), Times(Sqr(d), Plus(n, C1))))))), Sin(Plus(e, Times(f, x)))), Times(b, Subtract(Times(d, Subtract(Times(BSymbol, c), Times(ASymbol, d)), Plus(m, n, C2)), Times(C, Plus(Times(Sqr(c), Plus(m, C1)), Times(Sqr(d), Plus(n, C1))))), Sqr(Sin(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, C), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), GtQ(m, C0), LtQ(n, CN1))));
            IIntegrate(3048, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Plus(Times(Sqr(c), C), Times(ASymbol, Sqr(d))), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(d, f, Plus(n, C1), Subtract(Sqr(c), Sqr(d))), CN1)), x)), Dist(Power(Times(d, Plus(n, C1), Subtract(Sqr(c), Sqr(d))), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1)), Simp(Subtract(Subtract(Plus(Times(ASymbol, d, Plus(Times(b, d, m), Times(a, c, Plus(n, C1)))), Times(c, C, Plus(Times(b, c, m), Times(a, d, Plus(n, C1))))), Times(Subtract(Times(ASymbol, d, Subtract(Times(a, d, Plus(n, C2)), Times(b, c, Plus(n, C1)))), Times(C, Subtract(Times(b, c, d, Plus(n, C1)), Times(a, Plus(Sqr(c), Times(Sqr(d), Plus(n, C1))))))), Sin(Plus(e, Times(f, x))))), Times(b, Plus(Times(ASymbol, Sqr(d), Plus(m, n, C2)), Times(C, Plus(Times(Sqr(c), Plus(m, C1)), Times(Sqr(d), Plus(n, C1))))), Sqr(Sin(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, C), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), GtQ(m, C0), LtQ(n, CN1))));
            IIntegrate(3049, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(C, Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(d, f, Plus(m, n, C2)), CN1)), x)), Dist(Power(Times(d, Plus(m, n, C2)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Simp(Plus(Times(a, ASymbol, d, Plus(m, n, C2)), Times(C, Plus(Times(b, c, m), Times(a, d, Plus(n, C1)))), Times(Subtract(Times(d, Plus(Times(ASymbol, b), Times(a, BSymbol)), Plus(m, n, C2)), Times(C, Subtract(Times(a, c), Times(b, d, Plus(m, n, C1))))), Sin(Plus(e, Times(f, x)))), Times(Plus(Times(C, Subtract(Times(a, d, m), Times(b, c, Plus(m, C1)))), Times(b, BSymbol, d, Plus(m, n, C2))), Sqr(Sin(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, C, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), GtQ(m, C0), Not(And(IGtQ(n, C0), Or(Not(IntegerQ(m)), And(EqQ(a, C0), NeQ(c, C0))))))));
            IIntegrate(3050, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(C, Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(d, f, Plus(m, n, C2)), CN1)), x)), Dist(Power(Times(d, Plus(m, n, C2)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Simp(Plus(Times(a, ASymbol, d, Plus(m, n, C2)), Times(C, Plus(Times(b, c, m), Times(a, d, Plus(n, C1)))), Times(Subtract(Times(ASymbol, b, d, Plus(m, n, C2)), Times(C, Subtract(Times(a, c), Times(b, d, Plus(m, n, C1))))), Sin(Plus(e, Times(f, x)))), Times(C, Subtract(Times(a, d, m), Times(b, c, Plus(m, C1))), Sqr(Sin(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, C, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), GtQ(m, C0), Not(And(IGtQ(n, C0), Or(Not(IntegerQ(m)), And(EqQ(a, C0), NeQ(c, C0))))))));
        }
    }
}
