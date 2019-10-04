package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.ASymbol;
import static org.matheclipse.core.expression.F.A_;
import static org.matheclipse.core.expression.F.A_DEFAULT;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.BSymbol;
import static org.matheclipse.core.expression.F.B_DEFAULT;
import static org.matheclipse.core.expression.F.C;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CN1;
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
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sec;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Tan;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_DEFAULT;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.u_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ActivateTrig;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.KnownCotangentIntegrandQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.KnownSecantIntegrandQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.KnownTangentIntegrandQ;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules170 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(4251, Int(Times(Plus(A_DEFAULT, Times($($s("§cot"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), B_DEFAULT), Times(Sqr($($s("§cot"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), C_DEFAULT)), u_), x_Symbol),
                    Condition(Int(Times(ActivateTrig(u), Plus(C, Times(BSymbol, Tan(Plus(a, Times(b, x)))), Times(ASymbol, Sqr(Tan(Plus(a, Times(b, x)))))), Power(Tan(Plus(a, Times(b, x))), CN2)), x), And(FreeQ(List(a, b, ASymbol, BSymbol, C), x), KnownTangentIntegrandQ(u, x))));
            IIntegrate(4252, Int(Times(u_, Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§tan"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§tan"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))))))), x_Symbol),
                    Condition(Int(Times(ActivateTrig(u), Plus(C, Times(BSymbol, Cot(Plus(a, Times(b, x)))), Times(ASymbol, Sqr(Cot(Plus(a, Times(b, x)))))), Power(Cot(Plus(a, Times(b, x))), CN2)), x), And(FreeQ(List(a, b, ASymbol, BSymbol, C), x), KnownCotangentIntegrandQ(u, x))));
            IIntegrate(4253, Int(Times(Plus(Times(Sqr($($s("§cot"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), C_DEFAULT), A_), u_), x_Symbol),
                    Condition(Int(Times(ActivateTrig(u), Plus(C, Times(ASymbol, Sqr(Tan(Plus(a, Times(b, x)))))), Power(Tan(Plus(a, Times(b, x))), CN2)), x), And(FreeQ(List(a, b, ASymbol, C), x), KnownTangentIntegrandQ(u, x))));
            IIntegrate(4254, Int(Times(u_, Plus(A_, Times(C_DEFAULT, Sqr($($s("§tan"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))))))), x_Symbol),
                    Condition(Int(Times(ActivateTrig(u), Plus(C, Times(ASymbol, Sqr(Cot(Plus(a, Times(b, x)))))), Power(Cot(Plus(a, Times(b, x))), CN2)), x), And(FreeQ(List(a, b, ASymbol, C), x), KnownCotangentIntegrandQ(u, x))));
            IIntegrate(4255, Int(Times(u_, Plus(A_DEFAULT, Times($($s("§cot"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), C_DEFAULT), Times(B_DEFAULT, $($s("§tan"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))))), x_Symbol),
                    Condition(Int(Times(ActivateTrig(u), Plus(C, Times(ASymbol, Tan(Plus(a, Times(b, x)))), Times(BSymbol, Sqr(Tan(Plus(a, Times(b, x)))))), Power(Tan(Plus(a, Times(b, x))), CN1)), x), FreeQ(List(a, b, ASymbol, BSymbol, C), x)));
            IIntegrate(4256, Int(Times(u_, Plus(Times(A_DEFAULT, Power($($s("§tan"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT)), Times(B_DEFAULT, Power($($s("§tan"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), $p("n1"))), Times(C_DEFAULT, Power($($s("§tan"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), $p("n2"))))), x_Symbol),
                    Condition(Int(Times(ActivateTrig(u), Power(Tan(Plus(a, Times(b, x))), n), Plus(ASymbol, Times(BSymbol, Tan(Plus(a, Times(b, x)))), Times(C, Sqr(Tan(Plus(a, Times(b, x))))))), x), And(FreeQ(List(a, b, ASymbol, BSymbol, C, n), x), EqQ($s("n1"), Plus(n, C1)), EqQ($s("n2"), Plus(n, C2)))));
            IIntegrate(4257, Int(Times(Plus(Times(Power($($s("§cot"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT), A_DEFAULT), Times(Power($($s("§cot"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), $p("n1")), B_DEFAULT), Times(Power($($s("§cot"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), $p("n2")), C_DEFAULT)), u_), x_Symbol),
                    Condition(Int(Times(ActivateTrig(u), Power(Cot(Plus(a, Times(b, x))), n), Plus(ASymbol, Times(BSymbol, Cot(Plus(a, Times(b, x)))), Times(C, Sqr(Cot(Plus(a, Times(b, x))))))), x), And(FreeQ(List(a, b, ASymbol, BSymbol, C, n), x), EqQ($s("n1"), Plus(n, C1)), EqQ($s("n2"), Plus(n, C2)))));
            IIntegrate(4258, Int(Times(Power(Times($($s("§csc"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), d_DEFAULT), n_DEFAULT), u_, Power(Times(c_DEFAULT, $($s("§sin"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Times(c, Sin(Plus(a, Times(b, x)))), m), Power(Times(d, Csc(Plus(a, Times(b, x)))), m)), Int(Times(ActivateTrig(u), Power(Times(d, Csc(Plus(a, Times(b, x)))), Subtract(n, m))), x), x), And(FreeQ(List(a, b, c, d, m, n), x), KnownSecantIntegrandQ(u, x))));
            IIntegrate(4259, Int(Times(Power(Times($($s("§cos"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), c_DEFAULT), m_DEFAULT), u_, Power(Times(d_DEFAULT, $($s("§sec"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Times(c, Cos(Plus(a, Times(b, x)))), m), Power(Times(d, Sec(Plus(a, Times(b, x)))), m)), Int(Times(ActivateTrig(u), Power(Times(d, Sec(Plus(a, Times(b, x)))), Subtract(n, m))), x), x), And(FreeQ(List(a, b, c, d, m, n), x), KnownSecantIntegrandQ(u, x))));
            IIntegrate(4260, Int(Times(u_, Power(Times(d_DEFAULT, $($s("§sec"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), n_DEFAULT), Power(Times(c_DEFAULT, $($s("§tan"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Times(c, Tan(Plus(a, Times(b, x)))), m), Power(Times(d, Csc(Plus(a, Times(b, x)))), m), Power(Power(Times(d, Sec(Plus(a, Times(b, x)))), m), CN1)), Int(Times(ActivateTrig(u), Power(Times(d, Sec(Plus(a, Times(b, x)))), Plus(m, n)), Power(Power(Times(d, Csc(Plus(a, Times(b, x)))), m), CN1)), x), x), And(FreeQ(List(a, b, c, d, m, n), x), KnownSecantIntegrandQ(u, x), Not(IntegerQ(m)))));
            IIntegrate(4261, Int(Times(Power(Times($($s("§csc"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), d_DEFAULT), n_DEFAULT), u_, Power(Times(c_DEFAULT, $($s("§tan"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Times(c, Tan(Plus(a, Times(b, x)))), m), Power(Times(d, Csc(Plus(a, Times(b, x)))), m), Power(Power(Times(d, Sec(Plus(a, Times(b, x)))), m), CN1)), Int(Times(ActivateTrig(u), Power(Times(d, Sec(Plus(a, Times(b, x)))), m), Power(Power(Times(d, Csc(Plus(a, Times(b, x)))), Subtract(m, n)), CN1)), x), x), And(FreeQ(List(a, b, c, d, m, n), x), KnownSecantIntegrandQ(u, x), Not(IntegerQ(m)))));
            IIntegrate(4262, Int(Times(Power(Times($($s("§cot"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), c_DEFAULT), m_DEFAULT), u_, Power(Times(d_DEFAULT, $($s("§sec"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Times(c, Cot(Plus(a, Times(b, x)))), m), Power(Times(d, Sec(Plus(a, Times(b, x)))), m), Power(Power(Times(d, Csc(Plus(a, Times(b, x)))), m), CN1)), Int(Times(ActivateTrig(u), Power(Times(d, Csc(Plus(a, Times(b, x)))), m), Power(Power(Times(d, Sec(Plus(a, Times(b, x)))), Subtract(m, n)), CN1)), x), x), And(FreeQ(List(a, b, c, d, m, n), x), KnownSecantIntegrandQ(u, x), Not(IntegerQ(m)))));
            IIntegrate(4263, Int(Times(Power(Times($($s("§cot"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), c_DEFAULT), m_DEFAULT), Power(Times($($s("§csc"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), d_DEFAULT), n_DEFAULT), u_), x_Symbol),
                    Condition(Dist(Times(Power(Times(c, Cot(Plus(a, Times(b, x)))), m), Power(Times(d, Sec(Plus(a, Times(b, x)))), m), Power(Power(Times(d, Csc(Plus(a, Times(b, x)))), m), CN1)), Int(Times(ActivateTrig(u), Power(Times(d, Csc(Plus(a, Times(b, x)))), Plus(m, n)), Power(Power(Times(d, Sec(Plus(a, Times(b, x)))), m), CN1)), x), x), And(FreeQ(List(a, b, c, d, m, n), x), KnownSecantIntegrandQ(u, x), Not(IntegerQ(m)))));
            IIntegrate(4264, Int(Times(u_, Power(Times(c_DEFAULT, $($s("§sin"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Times(c, Csc(Plus(a, Times(b, x)))), m), Power(Times(c, Sin(Plus(a, Times(b, x)))), m)), Int(Times(ActivateTrig(u), Power(Power(Times(c, Csc(Plus(a, Times(b, x)))), m), CN1)), x), x), And(FreeQ(List(a, b, c, m), x), Not(IntegerQ(m)), KnownSecantIntegrandQ(u, x))));
            IIntegrate(4265, Int(Times(Power(Times($($s("§cos"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), c_DEFAULT), m_DEFAULT), u_), x_Symbol),
                    Condition(Dist(Times(Power(Times(c, Cos(Plus(a, Times(b, x)))), m), Power(Times(c, Sec(Plus(a, Times(b, x)))), m)), Int(Times(ActivateTrig(u), Power(Power(Times(c, Sec(Plus(a, Times(b, x)))), m), CN1)), x), x), And(FreeQ(List(a, b, c, m), x), Not(IntegerQ(m)), KnownSecantIntegrandQ(u, x))));
            IIntegrate(4266, Int(Times(u_, Power(Times(c_DEFAULT, $($s("§tan"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Times(c, Tan(Plus(a, Times(b, x)))), m), Power(Times(c, Csc(Plus(a, Times(b, x)))), m), Power(Power(Times(c, Sec(Plus(a, Times(b, x)))), m), CN1)), Int(Times(ActivateTrig(u), Power(Times(c, Sec(Plus(a, Times(b, x)))), m), Power(Power(Times(c, Csc(Plus(a, Times(b, x)))), m), CN1)), x), x), And(FreeQ(List(a, b, c, m), x), Not(IntegerQ(m)), KnownSecantIntegrandQ(u, x))));
            IIntegrate(4267, Int(Times(Power(Times($($s("§cot"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), c_DEFAULT), m_DEFAULT), u_), x_Symbol),
                    Condition(Dist(Times(Power(Times(c, Cot(Plus(a, Times(b, x)))), m), Power(Times(c, Sec(Plus(a, Times(b, x)))), m), Power(Power(Times(c, Csc(Plus(a, Times(b, x)))), m), CN1)), Int(Times(ActivateTrig(u), Power(Times(c, Csc(Plus(a, Times(b, x)))), m), Power(Power(Times(c, Sec(Plus(a, Times(b, x)))), m), CN1)), x), x), And(FreeQ(List(a, b, c, m), x), Not(IntegerQ(m)), KnownSecantIntegrandQ(u, x))));
            IIntegrate(4268, Int(Times(Plus(Times($($s("§cos"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), B_DEFAULT), A_), u_, Power(Times(c_DEFAULT, $($s("§sec"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), n_DEFAULT)), x_Symbol),
                    Condition(Dist(c, Int(Times(ActivateTrig(u), Power(Times(c, Sec(Plus(a, Times(b, x)))), Subtract(n, C1)), Plus(BSymbol, Times(ASymbol, Sec(Plus(a, Times(b, x)))))), x), x), And(FreeQ(List(a, b, c, ASymbol, BSymbol, n), x), KnownSecantIntegrandQ(u, x))));
            IIntegrate(4269, Int(Times(Power(Times($($s("§csc"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), c_DEFAULT), n_DEFAULT), u_, Plus(A_, Times(B_DEFAULT, $($s("§sin"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))))), x_Symbol),
                    Condition(Dist(c, Int(Times(ActivateTrig(u), Power(Times(c, Csc(Plus(a, Times(b, x)))), Subtract(n, C1)), Plus(BSymbol, Times(ASymbol, Csc(Plus(a, Times(b, x)))))), x), x), And(FreeQ(List(a, b, c, ASymbol, BSymbol, n), x), KnownSecantIntegrandQ(u, x))));
            IIntegrate(4270, Int(Times(Plus(Times($($s("§cos"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), B_DEFAULT), A_), u_), x_Symbol),
                    Condition(Int(Times(ActivateTrig(u), Plus(BSymbol, Times(ASymbol, Sec(Plus(a, Times(b, x))))), Power(Sec(Plus(a, Times(b, x))), CN1)), x), And(FreeQ(List(a, b, ASymbol, BSymbol), x), KnownSecantIntegrandQ(u, x))));
            IIntegrate(4271, Int(Times(u_, Plus(A_, Times(B_DEFAULT, $($s("§sin"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))))), x_Symbol),
                    Condition(Int(Times(ActivateTrig(u), Plus(BSymbol, Times(ASymbol, Csc(Plus(a, Times(b, x))))), Power(Csc(Plus(a, Times(b, x))), CN1)), x), And(FreeQ(List(a, b, ASymbol, BSymbol), x), KnownSecantIntegrandQ(u, x))));
            IIntegrate(4272, Int(Times(Plus(A_DEFAULT, Times($($s("§cos"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), B_DEFAULT), Times(Sqr($($s("§cos"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), C_DEFAULT)), u_DEFAULT, Power(Times(c_DEFAULT, $($s("§sec"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Sqr(c), Int(Times(ActivateTrig(u), Power(Times(c, Sec(Plus(a, Times(b, x)))), Subtract(n, C2)), Plus(C, Times(BSymbol, Sec(Plus(a, Times(b, x)))), Times(ASymbol, Sqr(Sec(Plus(a, Times(b, x))))))), x), x), And(FreeQ(List(a, b, c, ASymbol, BSymbol, C, n), x), KnownSecantIntegrandQ(u, x))));
            IIntegrate(4273, Int(Times(Power(Times($($s("§csc"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), c_DEFAULT), n_DEFAULT), u_DEFAULT, Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sin"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§sin"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))))))), x_Symbol),
                    Condition(Dist(Sqr(c), Int(Times(ActivateTrig(u), Power(Times(c, Csc(Plus(a, Times(b, x)))), Subtract(n, C2)), Plus(C, Times(BSymbol, Csc(Plus(a, Times(b, x)))), Times(ASymbol, Sqr(Csc(Plus(a, Times(b, x))))))), x), x), And(FreeQ(List(a, b, c, ASymbol, BSymbol, C, n), x), KnownSecantIntegrandQ(u, x))));
            IIntegrate(4274, Int(Times(u_DEFAULT, Plus(Times(Sqr($($s("§cos"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), C_DEFAULT), A_), Power(Times(c_DEFAULT, $($s("§sec"), Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Sqr(c), Int(Times(ActivateTrig(u), Power(Times(c, Sec(Plus(a, Times(b, x)))), Subtract(n, C2)), Plus(C, Times(ASymbol, Sqr(Sec(Plus(a, Times(b, x))))))), x), x), And(FreeQ(List(a, b, c, ASymbol, C, n), x), KnownSecantIntegrandQ(u, x))));
            IIntegrate(4275, Int(Times(Power(Times($($s("§csc"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))), c_DEFAULT), n_DEFAULT), u_DEFAULT, Plus(A_, Times(C_DEFAULT, Sqr($($s("§sin"), Plus(a_DEFAULT, Times(b_DEFAULT, x_))))))), x_Symbol),
                    Condition(Dist(Sqr(c), Int(Times(ActivateTrig(u), Power(Times(c, Csc(Plus(a, Times(b, x)))), Subtract(n, C2)), Plus(C, Times(ASymbol, Sqr(Csc(Plus(a, Times(b, x))))))), x), x), And(FreeQ(List(a, b, c, ASymbol, C, n), x), KnownSecantIntegrandQ(u, x))));
        }
    }
}
