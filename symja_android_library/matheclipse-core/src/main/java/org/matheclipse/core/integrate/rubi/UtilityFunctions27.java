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
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CPiHalf;
import static org.matheclipse.core.expression.F.C_DEFAULT;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.ISetDelayed;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Pi;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Subtract;
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
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.UnifyInertTrigFunction;

/**
 * UtilityFunctions rules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class UtilityFunctions27 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            ISetDelayed(606, UnifyInertTrigFunction(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_))), p_DEFAULT), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_DEFAULT)), x_),
                    Condition(Times(Power(Times(CN1, d, $($s("§cos"), Plus(e, CPiHalf, Times(f, x)))), m), Power(Plus(a, Times(b, Power(Times(c, $($s("§sin"), Plus(e, CPiHalf, Times(f, x)))), n))), p)), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), Not(And(EqQ(a, C0), IntegerQ(p))))));
            ISetDelayed(607, UnifyInertTrigFunction(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_))), p_DEFAULT), Power(Times(d_DEFAULT, $($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_DEFAULT)), x_),
                    Condition(Times(Power(Times(CN1, d, $($s("§tan"), Plus(e, CPiHalf, Times(f, x)))), m), Power(Plus(a, Times(b, Power(Times(c, $($s("§sin"), Plus(e, CPiHalf, Times(f, x)))), n))), p)), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), Not(And(EqQ(a, C0), IntegerQ(p))))));
            ISetDelayed(608, UnifyInertTrigFunction(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_))), p_DEFAULT), Power(Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_DEFAULT)), x_),
                    Condition(Times(Power(Times(CN1, d, $($s("§cot"), Plus(e, CPiHalf, Times(f, x)))), m), Power(Plus(a, Times(b, Power(Times(c, $($s("§sin"), Plus(e, CPiHalf, Times(f, x)))), n))), p)), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), Not(And(EqQ(a, C0), IntegerQ(p))))));
            ISetDelayed(609, UnifyInertTrigFunction(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_))), p_DEFAULT), Power(Times(d_DEFAULT, $($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_DEFAULT)), x_),
                    Condition(Times(Power(Times(CN1, d, $($s("§sec"), Plus(e, CPiHalf, Times(f, x)))), m), Power(Plus(a, Times(b, Power(Times(c, $($s("§sin"), Plus(e, CPiHalf, Times(f, x)))), n))), p)), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), Not(And(EqQ(a, C0), IntegerQ(p))))));
            ISetDelayed(610, UnifyInertTrigFunction(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_))), p_DEFAULT), Power(Times(d_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_DEFAULT)), x_),
                    Condition(Times(Power(Times(d, $($s("§csc"), Plus(e, CPiHalf, Times(f, x)))), m), Power(Plus(a, Times(b, Power(Times(c, $($s("§sin"), Plus(e, CPiHalf, Times(f, x)))), n))), p)), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), Not(And(EqQ(a, C0), IntegerQ(p))))));
            ISetDelayed(611, UnifyInertTrigFunction(Times(Plus(A_DEFAULT, Times(B_DEFAULT, Power($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), n_))), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), n_))), m_DEFAULT)), x_),
                    Condition(Times(Power(Plus(a, Times(b, Power($($s("§sin"), Plus(e, CPiHalf, Times(f, x))), n))), m), Plus(ASymbol, Times(BSymbol, Power($($s("§sin"), Plus(e, CPiHalf, Times(f, x))), n)))), And(FreeQ(List(a, b, e, f, ASymbol, BSymbol, m, n), x), Not(And(EqQ(a, C0), IntegerQ(m))))));
            ISetDelayed(612, UnifyInertTrigFunction(Times(Power(Times(a_DEFAULT, $($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_DEFAULT), Power(Times(b_DEFAULT, $($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_DEFAULT)), x_),
                    Condition(Times(Power(Times(a, $($s("§sin"), Plus(e, CPiHalf, Times(f, x)))), m), Power(Times(CN1, b, $($s("§tan"), Plus(e, CPiHalf, Times(f, x)))), n)), FreeQ(List(a, b, e, f, m, n), x)));
            ISetDelayed(613, UnifyInertTrigFunction(Times(Power(Times(b_DEFAULT, $($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_DEFAULT), Power(Times(a_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_DEFAULT)), x_),
                    Condition(Times(Power(Times(a, $($s("§cos"), Plus(e, Times(CN1, C1D2, Pi), Times(f, x)))), m), Power(Times(CN1, b, $($s("§tan"), Plus(e, Times(CN1, C1D2, Pi), Times(f, x)))), n)), FreeQ(List(a, b, e, f, m, n), x)));
            ISetDelayed(614, UnifyInertTrigFunction(Times(Power(Times(b_DEFAULT, $($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_DEFAULT), Power(Times(a_DEFAULT, $($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_DEFAULT)), x_),
                    Condition(Times(Power(Times(a, $($s("§sec"), Plus(e, Times(CN1, C1D2, Pi), Times(f, x)))), m), Power(Times(CN1, b, $($s("§tan"), Plus(e, Times(CN1, C1D2, Pi), Times(f, x)))), n)), FreeQ(List(a, b, e, f, m, n), x)));
            ISetDelayed(615, UnifyInertTrigFunction(Times(Power(Times(b_DEFAULT, $($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_DEFAULT), Power(Times(a_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_DEFAULT)), x_),
                    Condition(Times(Power(Times(a, $($s("§csc"), Plus(e, CPiHalf, Times(f, x)))), m), Power(Times(CN1, b, $($s("§tan"), Plus(e, CPiHalf, Times(f, x)))), n)), FreeQ(List(a, b, e, f, m, n), x)));
            ISetDelayed(616, UnifyInertTrigFunction(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT), x_),
                    Condition(Power(Subtract(a, Times(b, $($s("§tan"), Plus(e, CPiHalf, Times(f, x))))), n), FreeQ(List(a, b, e, f, n), x)));
            ISetDelayed(617, UnifyInertTrigFunction(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT), Power(Times(d_DEFAULT, $($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_DEFAULT)), x_),
                    Condition(Times(Power(Times(d, $($s("§sec"), Plus(e, Times(CN1, C1D2, Pi), Times(f, x)))), m), Power(Subtract(a, Times(b, $($s("§tan"), Plus(e, Times(CN1, C1D2, Pi), Times(f, x))))), n)), FreeQ(List(a, b, d, e, f, m, n), x)));
            ISetDelayed(618, UnifyInertTrigFunction(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_DEFAULT)), x_),
                    Condition(Times(Power(Times(d, $($s("§cos"), Plus(e, Times(CN1, C1D2, Pi), Times(f, x)))), m), Power(Subtract(a, Times(b, $($s("§tan"), Plus(e, Times(CN1, C1D2, Pi), Times(f, x))))), n)), FreeQ(List(a, b, d, e, f, m, n), x)));
            ISetDelayed(619, UnifyInertTrigFunction(Times(Power(Times(d_DEFAULT, $($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, $($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT)), x_),
                    Condition(Times(Power(Times(d, $($s("§sin"), Plus(e, CPiHalf, Times(f, x)))), m), Power(Subtract(a, Times(b, $($s("§tan"), Plus(e, CPiHalf, Times(f, x))))), n)), FreeQ(List(a, b, d, e, f, m, n), x)));
            ISetDelayed(620, UnifyInertTrigFunction(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT), Power(Times(d_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_DEFAULT)), x_),
                    Condition(Times(Power(Times(d, $($s("§csc"), Plus(e, CPiHalf, Times(f, x)))), m), Power(Subtract(a, Times(b, $($s("§tan"), Plus(e, CPiHalf, Times(f, x))))), n)), FreeQ(List(a, b, d, e, f, m, n), x)));
            ISetDelayed(621, UnifyInertTrigFunction(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT)), x_),
                    Condition(Times(Power(Subtract(a, Times(b, $($s("§tan"), Plus(e, CPiHalf, Times(f, x))))), m), Power(Subtract(c, Times(d, $($s("§tan"), Plus(e, CPiHalf, Times(f, x))))), n)), FreeQ(List(a, b, c, d, e, f, m, n), x)));
            ISetDelayed(622, UnifyInertTrigFunction(Times(Power(Times(g_DEFAULT, $($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), p_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT)), x_),
                    Condition(Times(Power(Times(CN1, g, $($s("§tan"), Plus(e, CPiHalf, Times(f, x)))), p), Power(Subtract(a, Times(b, $($s("§tan"), Plus(e, CPiHalf, Times(f, x))))), m), Power(Subtract(c, Times(d, $($s("§tan"), Plus(e, CPiHalf, Times(f, x))))), n)), FreeQ(List(a, b, c, d, e, f, g, m, n, p), x)));
            ISetDelayed(623, UnifyInertTrigFunction(Times(Power(Times(g_DEFAULT, $($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), p_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT)), x_),
                    Condition(Times(Power(Times(CN1, g, $($s("§tan"), Plus(e, CPiHalf, Times(f, x)))), p), Power(Subtract(a, Times(b, $($s("§tan"), Plus(e, CPiHalf, Times(f, x))))), m), Power(Subtract(c, Times(d, $($s("§cot"), Plus(e, CPiHalf, Times(f, x))))), n)), FreeQ(List(a, b, c, d, e, f, g, m, n, p), x)));
            ISetDelayed(624, UnifyInertTrigFunction(Times(Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT)), x_),
                    Condition(Times(Power(Subtract(a, Times(b, $($s("§tan"), Plus(e, CPiHalf, Times(f, x))))), m), Power(Subtract(c, Times(d, $($s("§tan"), Plus(e, CPiHalf, Times(f, x))))), n), Subtract(ASymbol, Times(BSymbol, $($s("§tan"), Plus(e, CPiHalf, Times(f, x)))))), FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, m, n), x)));
            ISetDelayed(625, UnifyInertTrigFunction(Times(Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT)), x_),
                    Condition(Times(Power(Subtract(a, Times(b, $($s("§tan"), Plus(e, CPiHalf, Times(f, x))))), m), Plus(ASymbol, Times(CN1, BSymbol, $($s("§tan"), Plus(e, CPiHalf, Times(f, x)))), Times(C, Sqr($($s("§tan"), Plus(e, CPiHalf, Times(f, x))))))), FreeQ(List(a, b, e, f, ASymbol, BSymbol, C, m), x)));
            ISetDelayed(626, UnifyInertTrigFunction(Times(Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT)), x_),
                    Condition(Times(Power(Subtract(a, Times(b, $($s("§tan"), Plus(e, CPiHalf, Times(f, x))))), m), Plus(ASymbol, Times(C, Sqr($($s("§tan"), Plus(e, CPiHalf, Times(f, x))))))), FreeQ(List(a, b, e, f, ASymbol, C, m), x)));
            ISetDelayed(627, UnifyInertTrigFunction(Times(Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT)), x_),
                    Condition(Times(Power(Subtract(a, Times(b, $($s("§tan"), Plus(e, CPiHalf, Times(f, x))))), m), Power(Subtract(c, Times(d, $($s("§tan"), Plus(e, CPiHalf, Times(f, x))))), n), Plus(ASymbol, Times(CN1, BSymbol, $($s("§tan"), Plus(e, CPiHalf, Times(f, x)))), Times(C, Sqr($($s("§tan"), Plus(e, CPiHalf, Times(f, x))))))), FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, C, m, n), x)));
            ISetDelayed(628, UnifyInertTrigFunction(Times(Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT)), x_),
                    Condition(Times(Power(Subtract(a, Times(b, $($s("§tan"), Plus(e, CPiHalf, Times(f, x))))), m), Power(Subtract(c, Times(d, $($s("§tan"), Plus(e, CPiHalf, Times(f, x))))), n), Plus(ASymbol, Times(C, Sqr($($s("§tan"), Plus(e, CPiHalf, Times(f, x))))))), FreeQ(List(a, b, c, d, e, f, ASymbol, C, m, n), x)));
            ISetDelayed(629, UnifyInertTrigFunction(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_))), p_), x_),
                    Condition(Power(Plus(a, Times(b, Power(Times(CN1, c, $($s("§tan"), Plus(e, CPiHalf, Times(f, x)))), n))), p), And(FreeQ(List(a, b, c, e, f, n, p), x), Not(And(EqQ(a, C0), IntegerQ(p))))));
            ISetDelayed(630, UnifyInertTrigFunction(Times(Power(Times(d_DEFAULT, $($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_))), p_DEFAULT)), x_),
                    Condition(Times(Power(Times(d, $($s("§sin"), Plus(e, CPiHalf, Times(f, x)))), m), Power(Plus(a, Times(b, Power(Times(CN1, c, $($s("§tan"), Plus(e, CPiHalf, Times(f, x)))), n))), p)), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), Not(And(EqQ(a, C0), IntegerQ(p))))));
        }
    }
}
