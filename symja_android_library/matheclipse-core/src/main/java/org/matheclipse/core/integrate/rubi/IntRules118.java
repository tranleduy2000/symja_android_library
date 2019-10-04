package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.ASymbol;
import static org.matheclipse.core.expression.F.A_DEFAULT;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.BSymbol;
import static org.matheclipse.core.expression.F.B_DEFAULT;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandTrig;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumSimplerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules118 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(2951, Int(Times(Power(Times(g_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Subtract(a, Times(b, Sin(Plus(e, Times(f, x)))))), Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Power(Times(f, Cos(Plus(e, Times(f, x)))), CN1)), Subst(Int(Times(Power(Times(g, x), p), Power(Plus(a, Times(b, x)), Subtract(m, C1D2)), Power(Plus(c, Times(d, x)), n), Power(Subtract(a, Times(b, x)), CN1D2)), x), x, Sin(Plus(e, Times(f, x)))), x), And(FreeQ(List(a, b, c, d, e, f, g, m, n, p), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), IntegerQ(Subtract(m, C1D2)))));
            IIntegrate(2952, Int(Times(Power(Times(g_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Int(ExpandTrig(Times(Power(Times(g, $($s("§sin"), Plus(e, Times(f, x)))), p), Power(Plus(a, Times(b, $($s("§sin"), Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, $($s("§sin"), Plus(e, Times(f, x))))), n)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, n, p), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), Or(IntegersQ(m, n), IntegersQ(m, p), IntegersQ(n, p)), NeQ(p, C2))));
            IIntegrate(2953, Int(Times(Power(Times(g_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Times(g, Sin(Plus(e, Times(f, x)))), p), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n)), x), And(FreeQ(List(a, b, c, d, e, f, g, m, n, p), x), NeQ(p, C2))));
            IIntegrate(2954, Int(Times(Power(Plus(a_DEFAULT, Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT)), m_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_DEFAULT), Power(Times(g_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(g, Plus(m, n)), Int(Times(Power(Times(g, Sin(Plus(e, Times(f, x)))), Subtract(Subtract(p, m), n)), Power(Plus(b, Times(a, Sin(Plus(e, Times(f, x))))), m), Power(Plus(d, Times(c, Sin(Plus(e, Times(f, x))))), n)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, p), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), Not(IntegerQ(p)), IntegerQ(m), IntegerQ(n))));
            IIntegrate(2955, Int(Times(Power(Plus(a_DEFAULT, Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT)), m_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_DEFAULT), Power(Times(g_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Times(g, Csc(Plus(e, Times(f, x)))), p), Power(Times(g, Sin(Plus(e, Times(f, x)))), p)), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), n), Power(Power(Times(g, Csc(Plus(e, Times(f, x)))), p), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, m, n, p), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), Not(IntegerQ(p)), Not(And(IntegerQ(m), IntegerQ(n))))));
            IIntegrate(2956, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_DEFAULT), Power(Times(g_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), p_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(g, n), Int(Times(Power(Times(g, Sin(Plus(e, Times(f, x)))), Subtract(p, n)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(d, Times(c, Sin(Plus(e, Times(f, x))))), n)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, m, p), x), IntegerQ(n))));
            IIntegrate(2957, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_), Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), p_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Plus(b, Times(a, Csc(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), n), Power(Power(Csc(Plus(e, Times(f, x))), Plus(m, p)), CN1)), x), And(FreeQ(List(a, b, c, d, e, f, n), x), Not(IntegerQ(n)), IntegerQ(m), IntegerQ(p))));
            IIntegrate(2958, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_), Power(Times(g_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Csc(Plus(e, Times(f, x))), p), Power(Times(g, Sin(Plus(e, Times(f, x)))), p)), Int(Times(Power(Plus(b, Times(a, Csc(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), n), Power(Power(Csc(Plus(e, Times(f, x))), Plus(m, p)), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, n, p), x), Not(IntegerQ(n)), IntegerQ(m), Not(IntegerQ(p)))));
            IIntegrate(2959, Int(Times(Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_), Power(Times(g_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), p_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Dist(Times(Power(Times(g, Sin(Plus(e, Times(f, x)))), n), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), n), Power(Power(Plus(d, Times(c, Sin(Plus(e, Times(f, x))))), n), CN1)), Int(Times(Power(Times(g, Sin(Plus(e, Times(f, x)))), Subtract(p, n)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(d, Times(c, Sin(Plus(e, Times(f, x))))), n)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, m, n, p), x), Not(IntegerQ(n)), Not(IntegerQ(m)))));
            IIntegrate(2960, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(g, Plus(m, n)), Int(Times(Power(Times(g, Csc(Plus(e, Times(f, x)))), Subtract(Subtract(p, m), n)), Power(Plus(b, Times(a, Csc(Plus(e, Times(f, x))))), m), Power(Plus(d, Times(c, Csc(Plus(e, Times(f, x))))), n)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, p), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), Not(IntegerQ(p)), IntegerQ(m), IntegerQ(n))));
            IIntegrate(2961, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Times(g, Csc(Plus(e, Times(f, x)))), p), Power(Times(g, Sin(Plus(e, Times(f, x)))), p)), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Power(Power(Times(g, Sin(Plus(e, Times(f, x)))), p), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, m, n, p), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), Not(IntegerQ(p)), Not(And(IntegerQ(m), IntegerQ(n))))));
            IIntegrate(2962, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(g, m), Int(Times(Power(Times(g, Csc(Plus(e, Times(f, x)))), Subtract(p, m)), Power(Plus(b, Times(a, Csc(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), n)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, n, p), x), IntegerQ(m))));
            IIntegrate(2963, Int(Times(Power($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), p_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(d, Times(c, Sin(Plus(e, Times(f, x))))), n), Power(Power(Sin(Plus(e, Times(f, x))), Plus(n, p)), CN1)), x), And(FreeQ(List(a, b, c, d, e, f, m), x), Not(IntegerQ(m)), IntegerQ(n), IntegerQ(p))));
            IIntegrate(2964, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Dist(Times(Power(Sin(Plus(e, Times(f, x))), p), Power(Times(g, Csc(Plus(e, Times(f, x)))), p)), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(d, Times(c, Sin(Plus(e, Times(f, x))))), n), Power(Power(Sin(Plus(e, Times(f, x))), Plus(n, p)), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, m, p), x), Not(IntegerQ(m)), IntegerQ(n), Not(IntegerQ(p)))));
            IIntegrate(2965, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), c_), n_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Times(g, Csc(Plus(e, Times(f, x)))), m), Power(Power(Plus(b, Times(a, Csc(Plus(e, Times(f, x))))), m), CN1)), Int(Times(Power(Times(g, Csc(Plus(e, Times(f, x)))), Subtract(p, m)), Power(Plus(b, Times(a, Csc(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), n)), x), x), And(FreeQ(List(a, b, c, d, e, f, g, m, n, p), x), Not(IntegerQ(m)), Not(IntegerQ(n)))));
            IIntegrate(2966, Int(Times(Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), n_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Int(ExpandTrig(Times(Power($($s("§sin"), Plus(e, Times(f, x))), n), Power(Plus(a, Times(b, $($s("§sin"), Plus(e, Times(f, x))))), m), Plus(ASymbol, Times(BSymbol, $($s("§sin"), Plus(e, Times(f, x)))))), x), x), And(FreeQ(List(a, b, e, f, ASymbol, BSymbol), x), EqQ(Plus(Times(ASymbol, b), Times(a, BSymbol)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegerQ(m), IntegerQ(n))));
            IIntegrate(2967, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(a, m), Power(c, m)), Int(Times(Power(Cos(Plus(e, Times(f, x))), Times(C2, m)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Subtract(n, m)), Plus(ASymbol, Times(BSymbol, Sin(Plus(e, Times(f, x)))))), x), x), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, n), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegerQ(m), Not(And(IntegerQ(n), Or(And(LtQ(m, C0), GtQ(n, C0)), LtQ(C0, n, m), LtQ(m, n, C0)))))));
            IIntegrate(2968, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), x_Symbol),
                    Condition(Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Plus(Times(ASymbol, c), Times(Plus(Times(BSymbol, c), Times(ASymbol, d)), Sin(Plus(e, Times(f, x)))), Times(BSymbol, d, Sqr(Sin(Plus(e, Times(f, x))))))), x), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, m), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0))));
            IIntegrate(2969, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1D2)), x_Symbol),
                    Condition(Plus(Dist(Times(Plus(Times(ASymbol, b), Times(a, BSymbol)), Power(Times(C2, a, b), CN1)), Int(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), CN1D2)), x), x), Dist(Times(Plus(Times(BSymbol, c), Times(ASymbol, d)), Power(Times(C2, c, d), CN1)), Int(Times(Sqrt(Plus(c, Times(d, Sin(Plus(e, Times(f, x)))))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), CN1D2)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(2970, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT)), x_Symbol),
                    Condition(Negate(Simp(Times(BSymbol, Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Power(Times(f, Plus(m, n, C1)), CN1)), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, m, n), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), EqQ(Plus(Times(ASymbol, b, Plus(m, n, C1)), Times(a, BSymbol, Subtract(m, n))), C0), NeQ(m, Negate(C1D2)))));
            IIntegrate(2971, Int(Times(Sqrt(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Subtract(Dist(Times(BSymbol, Power(d, CN1)), Int(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1))), x), x), Dist(Times(Subtract(Times(BSymbol, c), Times(ASymbol, d)), Power(d, CN1)), Int(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, n), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(2972, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Subtract(Times(ASymbol, b), Times(a, BSymbol)), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Power(Times(a, f, Plus(Times(C2, m), C1)), CN1)), x), Dist(Times(Plus(Times(a, BSymbol, Subtract(m, n)), Times(ASymbol, b, Plus(m, n, C1))), Power(Times(a, b, Plus(Times(C2, m), C1)), CN1)), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, m, n), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), Or(LtQ(m, Negate(C1D2)), And(ILtQ(Plus(m, n), C0), Not(SumSimplerQ(n, C1)))), NeQ(Plus(Times(C2, m), C1), C0))));
            IIntegrate(2973, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), Power(Plus(c_, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Subtract(Negate(Simp(Times(BSymbol, Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n), Power(Times(f, Plus(m, n, C1)), CN1)), x)), Dist(Times(Subtract(Times(BSymbol, c, Subtract(m, n)), Times(ASymbol, d, Plus(m, n, C1))), Power(Times(d, Plus(m, n, C1)), CN1)), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), n)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, m, n), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), Not(LtQ(m, Negate(C1D2))), NeQ(Plus(m, n, C1), C0))));
            IIntegrate(2974, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Simp(Times(Subtract(Times(BSymbol, c), Times(ASymbol, d)), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(f, Plus(n, C1), Subtract(Sqr(c), Sqr(d))), CN1)), x), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, m, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), EqQ(Plus(m, n, C2), C0), EqQ(Subtract(Times(ASymbol, Plus(Times(a, d, m), Times(b, c, Plus(n, C1)))), Times(BSymbol, Plus(Times(a, c, m), Times(b, d, Plus(n, C1))))), C0))));
            IIntegrate(2975, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_)), x_Symbol),
                    Condition(Subtract(Negate(Simp(Times(Sqr(b), Subtract(Times(BSymbol, c), Times(ASymbol, d)), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(d, f, Plus(n, C1), Plus(Times(b, c), Times(a, d))), CN1)), x)), Dist(Times(b, Power(Times(d, Plus(n, C1), Plus(Times(b, c), Times(a, d))), CN1)), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Plus(c, Times(d, Sin(Plus(e, Times(f, x))))), Plus(n, C1)), Simp(Subtract(Subtract(Times(a, ASymbol, d, Subtract(Subtract(m, n), C2)), Times(BSymbol, Plus(Times(a, c, Subtract(m, C1)), Times(b, d, Plus(n, C1))))), Times(Subtract(Times(ASymbol, b, d, Plus(m, n, C1)), Times(BSymbol, Subtract(Times(b, c, m), Times(a, d, Plus(n, C1))))), Sin(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Sqr(c), Sqr(d)), C0), GtQ(m, C1D2), LtQ(n, CN1), IntegerQ(Times(C2, m)), Or(IntegerQ(Times(C2, n)), EqQ(c, C0)))));
        }
    }
}
