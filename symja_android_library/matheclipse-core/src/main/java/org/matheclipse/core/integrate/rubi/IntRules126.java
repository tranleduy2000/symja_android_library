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
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.C8;
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
import static org.matheclipse.core.expression.F.Sec;
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
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ActivateTrig;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FreeFactors;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules126 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(3151, Int(Times(Power(Plus(a_DEFAULT, Times($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), b_DEFAULT), Times(c_DEFAULT, $($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), CN2), Plus(A_DEFAULT, Times(C_DEFAULT, $($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))))), x_Symbol),
                    Condition(Negate(Simp(Times(Plus(Times(b, C), Times(Subtract(Times(a, C), Times(c, ASymbol)), Cos(Plus(d, Times(e, x)))), Times(b, ASymbol, Sin(Plus(d, Times(e, x))))), Power(Times(e, Subtract(Subtract(Sqr(a), Sqr(b)), Sqr(c)), Plus(a, Times(b, Cos(Plus(d, Times(e, x)))), Times(c, Sin(Plus(d, Times(e, x)))))), CN1)), x)), And(FreeQ(List(a, b, c, d, e, ASymbol, C), x), NeQ(Subtract(Subtract(Sqr(a), Sqr(b)), Sqr(c)), C0), EqQ(Subtract(Times(a, ASymbol), Times(c, C)), C0))));
            IIntegrate(3152, Int(Times(Plus(A_DEFAULT, Times($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), B_DEFAULT)), Power(Plus(a_DEFAULT, Times($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), b_DEFAULT), Times(c_DEFAULT, $($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), CN2)), x_Symbol),
                    Condition(Simp(Times(Plus(Times(c, BSymbol), Times(c, ASymbol, Cos(Plus(d, Times(e, x)))), Times(Subtract(Times(a, BSymbol), Times(b, ASymbol)), Sin(Plus(d, Times(e, x))))), Power(Times(e, Subtract(Subtract(Sqr(a), Sqr(b)), Sqr(c)), Plus(a, Times(b, Cos(Plus(d, Times(e, x)))), Times(c, Sin(Plus(d, Times(e, x)))))), CN1)), x), And(FreeQ(List(a, b, c, d, e, ASymbol, BSymbol), x), NeQ(Subtract(Subtract(Sqr(a), Sqr(b)), Sqr(c)), C0), EqQ(Subtract(Times(a, ASymbol), Times(b, BSymbol)), C0))));
            IIntegrate(3153, Int(Times(Power(Plus(a_DEFAULT, Times($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), b_DEFAULT), Times(c_DEFAULT, $($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), CN2), Plus(A_DEFAULT, Times($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), B_DEFAULT), Times(C_DEFAULT, $($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(Times(c, BSymbol), Times(CN1, b, C), Times(CN1, Subtract(Times(a, C), Times(c, ASymbol)), Cos(Plus(d, Times(e, x)))), Times(Subtract(Times(a, BSymbol), Times(b, ASymbol)), Sin(Plus(d, Times(e, x))))), Power(Times(e, Subtract(Subtract(Sqr(a), Sqr(b)), Sqr(c)), Plus(a, Times(b, Cos(Plus(d, Times(e, x)))), Times(c, Sin(Plus(d, Times(e, x)))))), CN1)), x), Dist(Times(Subtract(Subtract(Times(a, ASymbol), Times(b, BSymbol)), Times(c, C)), Power(Subtract(Subtract(Sqr(a), Sqr(b)), Sqr(c)), CN1)), Int(Power(Plus(a, Times(b, Cos(Plus(d, Times(e, x)))), Times(c, Sin(Plus(d, Times(e, x))))), CN1), x), x)), And(FreeQ(List(a, b, c, d, e, ASymbol, BSymbol, C), x), NeQ(Subtract(Subtract(Sqr(a), Sqr(b)), Sqr(c)), C0), NeQ(Subtract(Subtract(Times(a, ASymbol), Times(b, BSymbol)), Times(c, C)), C0))));
            IIntegrate(3154, Int(Times(Power(Plus(a_DEFAULT, Times($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), b_DEFAULT), Times(c_DEFAULT, $($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), CN2), Plus(A_DEFAULT, Times(C_DEFAULT, $($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Plus(Times(b, C), Times(Subtract(Times(a, C), Times(c, ASymbol)), Cos(Plus(d, Times(e, x)))), Times(b, ASymbol, Sin(Plus(d, Times(e, x))))), Power(Times(e, Subtract(Subtract(Sqr(a), Sqr(b)), Sqr(c)), Plus(a, Times(b, Cos(Plus(d, Times(e, x)))), Times(c, Sin(Plus(d, Times(e, x)))))), CN1)), x)), Dist(Times(Subtract(Times(a, ASymbol), Times(c, C)), Power(Subtract(Subtract(Sqr(a), Sqr(b)), Sqr(c)), CN1)), Int(Power(Plus(a, Times(b, Cos(Plus(d, Times(e, x)))), Times(c, Sin(Plus(d, Times(e, x))))), CN1), x), x)), And(FreeQ(List(a, b, c, d, e, ASymbol, C), x), NeQ(Subtract(Subtract(Sqr(a), Sqr(b)), Sqr(c)), C0), NeQ(Subtract(Times(a, ASymbol), Times(c, C)), C0))));
            IIntegrate(3155, Int(Times(Plus(A_DEFAULT, Times($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), B_DEFAULT)), Power(Plus(a_DEFAULT, Times($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), b_DEFAULT), Times(c_DEFAULT, $($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), CN2)), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(Times(c, BSymbol), Times(c, ASymbol, Cos(Plus(d, Times(e, x)))), Times(Subtract(Times(a, BSymbol), Times(b, ASymbol)), Sin(Plus(d, Times(e, x))))), Power(Times(e, Subtract(Subtract(Sqr(a), Sqr(b)), Sqr(c)), Plus(a, Times(b, Cos(Plus(d, Times(e, x)))), Times(c, Sin(Plus(d, Times(e, x)))))), CN1)), x), Dist(Times(Subtract(Times(a, ASymbol), Times(b, BSymbol)), Power(Subtract(Subtract(Sqr(a), Sqr(b)), Sqr(c)), CN1)), Int(Power(Plus(a, Times(b, Cos(Plus(d, Times(e, x)))), Times(c, Sin(Plus(d, Times(e, x))))), CN1), x), x)), And(FreeQ(List(a, b, c, d, e, ASymbol, BSymbol), x), NeQ(Subtract(Subtract(Sqr(a), Sqr(b)), Sqr(c)), C0), NeQ(Subtract(Times(a, ASymbol), Times(b, BSymbol)), C0))));
            IIntegrate(3156, Int(Times(Power(Plus(a_DEFAULT, Times($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), b_DEFAULT), Times(c_DEFAULT, $($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), n_), Plus(A_DEFAULT, Times($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), B_DEFAULT), Times(C_DEFAULT, $($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Plus(Times(c, BSymbol), Times(CN1, b, C), Times(CN1, Subtract(Times(a, C), Times(c, ASymbol)), Cos(Plus(d, Times(e, x)))), Times(Subtract(Times(a, BSymbol), Times(b, ASymbol)), Sin(Plus(d, Times(e, x))))), Power(Plus(a, Times(b, Cos(Plus(d, Times(e, x)))), Times(c, Sin(Plus(d, Times(e, x))))), Plus(n, C1)), Power(Times(e, Plus(n, C1), Subtract(Subtract(Sqr(a), Sqr(b)), Sqr(c))), CN1)), x)), Dist(Power(Times(Plus(n, C1), Subtract(Subtract(Sqr(a), Sqr(b)), Sqr(c))), CN1), Int(Times(Power(Plus(a, Times(b, Cos(Plus(d, Times(e, x)))), Times(c, Sin(Plus(d, Times(e, x))))), Plus(n, C1)), Simp(Plus(Times(Plus(n, C1), Subtract(Subtract(Times(a, ASymbol), Times(b, BSymbol)), Times(c, C))), Times(Plus(n, C2), Subtract(Times(a, BSymbol), Times(b, ASymbol)), Cos(Plus(d, Times(e, x)))), Times(Plus(n, C2), Subtract(Times(a, C), Times(c, ASymbol)), Sin(Plus(d, Times(e, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, ASymbol, BSymbol, C), x), LtQ(n, CN1), NeQ(Subtract(Subtract(Sqr(a), Sqr(b)), Sqr(c)), C0), NeQ(n, CN2))));
            IIntegrate(3157, Int(Times(Power(Plus(a_DEFAULT, Times($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), b_DEFAULT), Times(c_DEFAULT, $($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), n_), Plus(A_DEFAULT, Times(C_DEFAULT, $($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(Times(b, C), Times(Subtract(Times(a, C), Times(c, ASymbol)), Cos(Plus(d, Times(e, x)))), Times(b, ASymbol, Sin(Plus(d, Times(e, x))))), Power(Plus(a, Times(b, Cos(Plus(d, Times(e, x)))), Times(c, Sin(Plus(d, Times(e, x))))), Plus(n, C1)), Power(Times(e, Plus(n, C1), Subtract(Subtract(Sqr(a), Sqr(b)), Sqr(c))), CN1)), x), Dist(Power(Times(Plus(n, C1), Subtract(Subtract(Sqr(a), Sqr(b)), Sqr(c))), CN1), Int(Times(Power(Plus(a, Times(b, Cos(Plus(d, Times(e, x)))), Times(c, Sin(Plus(d, Times(e, x))))), Plus(n, C1)), Simp(Plus(Times(Plus(n, C1), Subtract(Times(a, ASymbol), Times(c, C))), Times(CN1, Plus(n, C2), b, ASymbol, Cos(Plus(d, Times(e, x)))), Times(Plus(n, C2), Subtract(Times(a, C), Times(c, ASymbol)), Sin(Plus(d, Times(e, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, ASymbol, C), x), LtQ(n, CN1), NeQ(Subtract(Subtract(Sqr(a), Sqr(b)), Sqr(c)), C0), NeQ(n, CN2))));
            IIntegrate(3158, Int(Times(Plus(A_DEFAULT, Times($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), B_DEFAULT)), Power(Plus(a_DEFAULT, Times($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), b_DEFAULT), Times(c_DEFAULT, $($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Plus(Times(c, BSymbol), Times(c, ASymbol, Cos(Plus(d, Times(e, x)))), Times(Subtract(Times(a, BSymbol), Times(b, ASymbol)), Sin(Plus(d, Times(e, x))))), Power(Plus(a, Times(b, Cos(Plus(d, Times(e, x)))), Times(c, Sin(Plus(d, Times(e, x))))), Plus(n, C1)), Power(Times(e, Plus(n, C1), Subtract(Subtract(Sqr(a), Sqr(b)), Sqr(c))), CN1)), x)), Dist(Power(Times(Plus(n, C1), Subtract(Subtract(Sqr(a), Sqr(b)), Sqr(c))), CN1), Int(Times(Power(Plus(a, Times(b, Cos(Plus(d, Times(e, x)))), Times(c, Sin(Plus(d, Times(e, x))))), Plus(n, C1)), Simp(Subtract(Plus(Times(Plus(n, C1), Subtract(Times(a, ASymbol), Times(b, BSymbol))), Times(Plus(n, C2), Subtract(Times(a, BSymbol), Times(b, ASymbol)), Cos(Plus(d, Times(e, x))))), Times(Plus(n, C2), c, ASymbol, Sin(Plus(d, Times(e, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, ASymbol, BSymbol), x), LtQ(n, CN1), NeQ(Subtract(Subtract(Sqr(a), Sqr(b)), Sqr(c)), C0), NeQ(n, CN2))));
            IIntegrate(3159, Int(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), Times(c_DEFAULT, $($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), CN1), x_Symbol),
                    Condition(Int(Times(Cos(Plus(d, Times(e, x))), Power(Plus(b, Times(a, Cos(Plus(d, Times(e, x)))), Times(c, Sin(Plus(d, Times(e, x))))), CN1)), x), FreeQ(List(a, b, c, d, e), x)));
            IIntegrate(3160, Int(Power(Plus(a_DEFAULT, Times($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), b_DEFAULT), Times($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), c_DEFAULT)), CN1), x_Symbol),
                    Condition(Int(Times(Sin(Plus(d, Times(e, x))), Power(Plus(b, Times(a, Sin(Plus(d, Times(e, x)))), Times(c, Cos(Plus(d, Times(e, x))))), CN1)), x), FreeQ(List(a, b, c, d, e), x)));
            IIntegrate(3161, Int(Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), Times(c_DEFAULT, $($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), n_DEFAULT)), x_Symbol),
                    Condition(Int(Power(Plus(b, Times(a, Cos(Plus(d, Times(e, x)))), Times(c, Sin(Plus(d, Times(e, x))))), n), x), And(FreeQ(List(a, b, c, d, e), x), IntegerQ(n))));
            IIntegrate(3162, Int(Times(Power(Plus(a_DEFAULT, Times($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), b_DEFAULT), Times($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), c_DEFAULT)), n_DEFAULT), Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), x_Symbol),
                    Condition(Int(Power(Plus(b, Times(a, Sin(Plus(d, Times(e, x)))), Times(c, Cos(Plus(d, Times(e, x))))), n), x), And(FreeQ(List(a, b, c, d, e), x), IntegerQ(n))));
            IIntegrate(3163, Int(Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), Times(c_DEFAULT, $($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Dist(Times(Power(Cos(Plus(d, Times(e, x))), n), Power(Plus(a, Times(b, Sec(Plus(d, Times(e, x)))), Times(c, Tan(Plus(d, Times(e, x))))), n), Power(Power(Plus(b, Times(a, Cos(Plus(d, Times(e, x)))), Times(c, Sin(Plus(d, Times(e, x))))), n), CN1)), Int(Power(Plus(b, Times(a, Cos(Plus(d, Times(e, x)))), Times(c, Sin(Plus(d, Times(e, x))))), n), x), x), And(FreeQ(List(a, b, c, d, e), x), Not(IntegerQ(n)))));
            IIntegrate(3164, Int(Times(Power(Plus(a_DEFAULT, Times($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), b_DEFAULT), Times($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), c_DEFAULT)), n_), Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_)), x_Symbol),
                    Condition(Dist(Times(Power(Sin(Plus(d, Times(e, x))), n), Power(Plus(a, Times(b, Csc(Plus(d, Times(e, x)))), Times(c, Cot(Plus(d, Times(e, x))))), n), Power(Power(Plus(b, Times(a, Sin(Plus(d, Times(e, x)))), Times(c, Cos(Plus(d, Times(e, x))))), n), CN1)), Int(Power(Plus(b, Times(a, Sin(Plus(d, Times(e, x)))), Times(c, Cos(Plus(d, Times(e, x))))), n), x), x), And(FreeQ(List(a, b, c, d, e), x), Not(IntegerQ(n)))));
            IIntegrate(3165, Int(Times(Power($($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), Times(c_DEFAULT, $($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Int(Power(Power(Plus(b, Times(a, Cos(Plus(d, Times(e, x)))), Times(c, Sin(Plus(d, Times(e, x))))), n), CN1), x), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(m, n), C0), IntegerQ(n))));
            IIntegrate(3166, Int(Times(Power($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), Power(Plus(a_DEFAULT, Times($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), b_DEFAULT), Times($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), c_DEFAULT)), m_)), x_Symbol),
                    Condition(Int(Power(Power(Plus(b, Times(a, Sin(Plus(d, Times(e, x)))), Times(c, Cos(Plus(d, Times(e, x))))), n), CN1), x), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(m, n), C0), IntegerQ(n))));
            IIntegrate(3167, Int(Times(Power($($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), Times(c_DEFAULT, $($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Dist(Times(Power(Sec(Plus(d, Times(e, x))), n), Power(Plus(b, Times(a, Cos(Plus(d, Times(e, x)))), Times(c, Sin(Plus(d, Times(e, x))))), n), Power(Power(Plus(a, Times(b, Sec(Plus(d, Times(e, x)))), Times(c, Tan(Plus(d, Times(e, x))))), n), CN1)), Int(Power(Power(Plus(b, Times(a, Cos(Plus(d, Times(e, x)))), Times(c, Sin(Plus(d, Times(e, x))))), n), CN1), x), x), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(m, n), C0), Not(IntegerQ(n)))));
            IIntegrate(3168, Int(Times(Power($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), Power(Plus(a_DEFAULT, Times($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), b_DEFAULT), Times($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), c_DEFAULT)), m_)), x_Symbol),
                    Condition(Dist(Times(Power(Csc(Plus(d, Times(e, x))), n), Power(Plus(b, Times(a, Sin(Plus(d, Times(e, x)))), Times(c, Cos(Plus(d, Times(e, x))))), n), Power(Power(Plus(a, Times(b, Csc(Plus(d, Times(e, x)))), Times(c, Cot(Plus(d, Times(e, x))))), n), CN1)), Int(Power(Power(Plus(b, Times(a, Sin(Plus(d, Times(e, x)))), Times(c, Cos(Plus(d, Times(e, x))))), n), CN1), x), x), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(m, n), C0), Not(IntegerQ(n)))));
            IIntegrate(3169, Int(Times(Plus(a_, Times(b_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), Plus(A_DEFAULT, Times(B_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Simp(Times(QQ(1L, 8L), Plus(Times(C4, ASymbol, Plus(Times(C2, a), b)), Times(BSymbol, Plus(Times(C4, a), Times(C3, b)))), x), x), Negate(Simp(Times(b, BSymbol, Cos(Plus(e, Times(f, x))), Power(Sin(Plus(e, Times(f, x))), C3), Power(Times(C4, f), CN1)), x)), Negate(Simp(Times(Plus(Times(C4, ASymbol, b), Times(BSymbol, Plus(Times(C4, a), Times(C3, b)))), Cos(Plus(e, Times(f, x))), Sin(Plus(e, Times(f, x))), Power(Times(C8, f), CN1)), x))), FreeQ(List(a, b, e, f, ASymbol, BSymbol), x)));
            IIntegrate(3170, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), p_), Plus(A_DEFAULT, Times(B_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(BSymbol, Cos(Plus(e, Times(f, x))), Sin(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sqr(Sin(Plus(e, Times(f, x)))))), p), Power(Times(C2, f, Plus(p, C1)), CN1)), x)), Dist(Power(Times(C2, Plus(p, C1)), CN1), Int(Times(Power(Plus(a, Times(b, Sqr(Sin(Plus(e, Times(f, x)))))), Subtract(p, C1)), Simp(Plus(Times(a, BSymbol), Times(C2, a, ASymbol, Plus(p, C1)), Times(Plus(Times(C2, ASymbol, b, Plus(p, C1)), Times(BSymbol, Plus(b, Times(C2, a, p), Times(C2, b, p)))), Sqr(Sin(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, e, f, ASymbol, BSymbol), x), GtQ(p, C0))));
            IIntegrate(3171, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), CN1), Plus(A_DEFAULT, Times(B_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Simp(Times(BSymbol, x, Power(b, CN1)), x), Dist(Times(Subtract(Times(ASymbol, b), Times(a, BSymbol)), Power(b, CN1)), Int(Power(Plus(a, Times(b, Sqr(Sin(Plus(e, Times(f, x)))))), CN1), x), x)), FreeQ(List(a, b, e, f, ASymbol, BSymbol), x)));
            IIntegrate(3172, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), CN1D2), Plus(A_DEFAULT, Times(B_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Dist(Times(BSymbol, Power(b, CN1)), Int(Sqrt(Plus(a, Times(b, Sqr(Sin(Plus(e, Times(f, x))))))), x), x), Dist(Times(Subtract(Times(ASymbol, b), Times(a, BSymbol)), Power(b, CN1)), Int(Power(Plus(a, Times(b, Sqr(Sin(Plus(e, Times(f, x)))))), CN1D2), x), x)), FreeQ(List(a, b, e, f, ASymbol, BSymbol), x)));
            IIntegrate(3173, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), p_), Plus(A_DEFAULT, Times(B_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Subtract(Negate(Simp(Times(Subtract(Times(ASymbol, b), Times(a, BSymbol)), Cos(Plus(e, Times(f, x))), Sin(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sqr(Sin(Plus(e, Times(f, x)))))), Plus(p, C1)), Power(Times(C2, a, f, Plus(a, b), Plus(p, C1)), CN1)), x)), Dist(Power(Times(C2, a, Plus(a, b), Plus(p, C1)), CN1), Int(Times(Power(Plus(a, Times(b, Sqr(Sin(Plus(e, Times(f, x)))))), Plus(p, C1)), Simp(Plus(Times(a, BSymbol), Times(CN1, ASymbol, Plus(Times(C2, a, Plus(p, C1)), Times(b, Plus(Times(C2, p), C3)))), Times(C2, Subtract(Times(ASymbol, b), Times(a, BSymbol)), Plus(p, C2), Sqr(Sin(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, e, f, ASymbol, BSymbol), x), LtQ(p, CN1), NeQ(Plus(a, b), C0))));
            IIntegrate(3174, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), p_), Plus(A_DEFAULT, Times(B_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Tan(Plus(e, Times(f, x))), x))), Dist(Times($s("ff"), Power(Plus(a, Times(b, Sqr(Sin(Plus(e, Times(f, x)))))), p), Power(Sqr(Sec(Plus(e, Times(f, x)))), p), Power(Times(f, Power(Plus(a, Times(Plus(a, b), Sqr(Tan(Plus(e, Times(f, x)))))), p)), CN1)), Subst(Int(Times(Power(Plus(a, Times(Plus(a, b), Sqr($s("ff")), Sqr(x))), p), Plus(ASymbol, Times(Plus(ASymbol, BSymbol), Sqr($s("ff")), Sqr(x))), Power(Power(Plus(C1, Times(Sqr($s("ff")), Sqr(x))), Plus(p, C2)), CN1)), x), x, Times(Tan(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x)), And(FreeQ(List(a, b, e, f, ASymbol, BSymbol), x), Not(IntegerQ(p)))));
            IIntegrate(3175, Int(Times(u_DEFAULT, Power(Plus(a_, Times(b_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), p_)), x_Symbol),
                    Condition(Dist(Power(a, p), Int(ActivateTrig(Times(u, Power($($s("§cos"), Plus(e, Times(f, x))), Times(C2, p)))), x), x), And(FreeQ(List(a, b, e, f, p), x), EqQ(Plus(a, b), C0), IntegerQ(p))));
        }
    }
}
