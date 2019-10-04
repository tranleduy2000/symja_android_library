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
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.C_DEFAULT;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sqr;
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
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules145 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(3626, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1), Plus(A_, Times(B_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Simp(Times(Subtract(Plus(Times(a, ASymbol), Times(b, BSymbol)), Times(a, C)), x, Power(Plus(Sqr(a), Sqr(b)), CN1)), x), Dist(Times(Plus(Times(ASymbol, Sqr(b)), Times(CN1, a, b, BSymbol), Times(Sqr(a), C)), Power(Plus(Sqr(a), Sqr(b)), CN1)), Int(Times(Plus(C1, Sqr(Tan(Plus(e, Times(f, x))))), Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), CN1)), x), x), Negate(Dist(Times(Subtract(Subtract(Times(ASymbol, b), Times(a, BSymbol)), Times(b, C)), Power(Plus(Sqr(a), Sqr(b)), CN1)), Int(Tan(Plus(e, Times(f, x))), x), x))), And(FreeQ(List(a, b, e, f, ASymbol, BSymbol, C), x), NeQ(Plus(Times(ASymbol, Sqr(b)), Times(CN1, a, b, BSymbol), Times(Sqr(a), C)), C0), NeQ(Plus(Sqr(a), Sqr(b)), C0), NeQ(Subtract(Subtract(Times(ASymbol, b), Times(a, BSymbol)), Times(b, C)), C0))));
            IIntegrate(3627, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1), Plus(A_, Times(C_DEFAULT, Sqr($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Simp(Times(a, Subtract(ASymbol, C), x, Power(Plus(Sqr(a), Sqr(b)), CN1)), x), Dist(Times(Plus(Times(Sqr(a), C), Times(ASymbol, Sqr(b))), Power(Plus(Sqr(a), Sqr(b)), CN1)), Int(Times(Plus(C1, Sqr(Tan(Plus(e, Times(f, x))))), Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), CN1)), x), x), Negate(Dist(Times(b, Subtract(ASymbol, C), Power(Plus(Sqr(a), Sqr(b)), CN1)), Int(Tan(Plus(e, Times(f, x))), x), x))), And(FreeQ(List(a, b, e, f, ASymbol, C), x), NeQ(Plus(Times(Sqr(a), C), Times(ASymbol, Sqr(b))), C0), NeQ(Plus(Sqr(a), Sqr(b)), C0), NeQ(ASymbol, C))));
            IIntegrate(3628, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(Times(ASymbol, Sqr(b)), Times(CN1, a, b, BSymbol), Times(Sqr(a), C)), Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(b, f, Plus(m, C1), Plus(Sqr(a), Sqr(b))), CN1)), x), Dist(Power(Plus(Sqr(a), Sqr(b)), CN1), Int(Times(Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), Plus(m, C1)), Simp(Subtract(Plus(Times(b, BSymbol), Times(a, Subtract(ASymbol, C))), Times(Subtract(Subtract(Times(ASymbol, b), Times(a, BSymbol)), Times(b, C)), Tan(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, e, f, ASymbol, BSymbol, C), x), NeQ(Plus(Times(ASymbol, Sqr(b)), Times(CN1, a, b, BSymbol), Times(Sqr(a), C)), C0), LtQ(m, CN1), NeQ(Plus(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3629, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(Times(ASymbol, Sqr(b)), Times(Sqr(a), C)), Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(b, f, Plus(m, C1), Plus(Sqr(a), Sqr(b))), CN1)), x), Dist(Power(Plus(Sqr(a), Sqr(b)), CN1), Int(Times(Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), Plus(m, C1)), Simp(Subtract(Times(a, Subtract(ASymbol, C)), Times(Subtract(Times(ASymbol, b), Times(b, C)), Tan(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, e, f, ASymbol, C), x), NeQ(Plus(Times(ASymbol, Sqr(b)), Times(Sqr(a), C)), C0), LtQ(m, CN1), NeQ(Plus(Sqr(a), Sqr(b)), C0))));
            IIntegrate(3630, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Simp(Times(C, Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(b, f, Plus(m, C1)), CN1)), x), Int(Times(Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), m), Simp(Plus(ASymbol, Negate(C), Times(BSymbol, Tan(Plus(e, Times(f, x))))), x)), x)), And(FreeQ(List(a, b, e, f, ASymbol, BSymbol, C, m), x), NeQ(Plus(Times(ASymbol, Sqr(b)), Times(CN1, a, b, BSymbol), Times(Sqr(a), C)), C0), Not(LeQ(m, CN1)))));
            IIntegrate(3631, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Simp(Times(C, Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(b, f, Plus(m, C1)), CN1)), x), Dist(Subtract(ASymbol, C), Int(Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), m), x), x)), And(FreeQ(List(a, b, e, f, ASymbol, C, m), x), NeQ(Plus(Times(ASymbol, Sqr(b)), Times(Sqr(a), C)), C0), Not(LeQ(m, CN1)))));
            IIntegrate(3632, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Dist(Power(b, CN2), Int(Times(Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), n), Plus(Times(b, BSymbol), Times(CN1, a, C), Times(b, C, Tan(Plus(e, Times(f, x)))))), x), x), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, C, m, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(Times(ASymbol, Sqr(b)), Times(CN1, a, b, BSymbol), Times(Sqr(a), C)), C0))));
            IIntegrate(3633, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Negate(Dist(Times(C, Power(b, CN2)), Int(Times(Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), n), Subtract(a, Times(b, Tan(Plus(e, Times(f, x)))))), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, C, m, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(Times(ASymbol, Sqr(b)), Times(Sqr(a), C)), C0))));
            IIntegrate(3634, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT), Plus(A_, Times(C_DEFAULT, Sqr($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Dist(Times(ASymbol, Power(f, CN1)), Subst(Int(Times(Power(Plus(a, Times(b, x)), m), Power(Plus(c, Times(d, x)), n)), x), x, Tan(Plus(e, Times(f, x)))), x), And(FreeQ(List(a, b, c, d, e, f, ASymbol, C, m, n), x), EqQ(ASymbol, C))));
            IIntegrate(3635, Int(Times(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Subtract(Times(b, c), Times(a, d)), Plus(Times(Sqr(c), C), Times(CN1, BSymbol, c, d), Times(ASymbol, Sqr(d))), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(Sqr(d), f, Plus(n, C1), Plus(Sqr(c), Sqr(d))), CN1)), x)), Dist(Power(Times(d, Plus(Sqr(c), Sqr(d))), CN1), Int(Times(Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), Plus(n, C1)), Simp(Plus(Times(a, d, Plus(Times(ASymbol, c), Times(CN1, c, C), Times(BSymbol, d))), Times(b, Plus(Times(Sqr(c), C), Times(CN1, BSymbol, c, d), Times(ASymbol, Sqr(d)))), Times(d, Plus(Times(ASymbol, b, c), Times(a, BSymbol, c), Times(CN1, b, c, C), Times(CN1, a, ASymbol, d), Times(b, BSymbol, d), Times(a, C, d)), Tan(Plus(e, Times(f, x)))), Times(b, C, Plus(Sqr(c), Sqr(d)), Sqr(Tan(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, C), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Plus(Sqr(c), Sqr(d)), C0), LtQ(n, CN1))));
            IIntegrate(3636, Int(Times(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Subtract(Times(b, c), Times(a, d)), Plus(Times(Sqr(c), C), Times(ASymbol, Sqr(d))), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(Sqr(d), f, Plus(n, C1), Plus(Sqr(c), Sqr(d))), CN1)), x)), Dist(Power(Times(d, Plus(Sqr(c), Sqr(d))), CN1), Int(Times(Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), Plus(n, C1)), Simp(Plus(Times(a, d, Subtract(Times(ASymbol, c), Times(c, C))), Times(b, Plus(Times(Sqr(c), C), Times(ASymbol, Sqr(d)))), Times(d, Plus(Times(ASymbol, b, c), Times(CN1, b, c, C), Times(CN1, a, ASymbol, d), Times(a, C, d)), Tan(Plus(e, Times(f, x)))), Times(b, C, Plus(Sqr(c), Sqr(d)), Sqr(Tan(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, C), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Plus(Sqr(c), Sqr(d)), C0), LtQ(n, CN1))));
            IIntegrate(3637, Int(Times(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Subtract(Simp(Times(b, C, Tan(Plus(e, Times(f, x))), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(d, f, Plus(n, C2)), CN1)), x), Dist(Power(Times(d, Plus(n, C2)), CN1), Int(Times(Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), n), Simp(Subtract(Subtract(Subtract(Times(b, c, C), Times(a, ASymbol, d, Plus(n, C2))), Times(Subtract(Plus(Times(ASymbol, b), Times(a, BSymbol)), Times(b, C)), d, Plus(n, C2), Tan(Plus(e, Times(f, x))))), Times(Subtract(Times(a, C, d, Plus(n, C2)), Times(b, Subtract(Times(c, C), Times(BSymbol, d, Plus(n, C2))))), Sqr(Tan(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, C, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Plus(Sqr(c), Sqr(d)), C0), Not(LtQ(n, CN1)))));
            IIntegrate(3638, Int(Times(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Subtract(Simp(Times(b, C, Tan(Plus(e, Times(f, x))), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(d, f, Plus(n, C2)), CN1)), x), Dist(Power(Times(d, Plus(n, C2)), CN1), Int(Times(Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), n), Simp(Subtract(Subtract(Subtract(Times(b, c, C), Times(a, ASymbol, d, Plus(n, C2))), Times(Subtract(Times(ASymbol, b), Times(b, C)), d, Plus(n, C2), Tan(Plus(e, Times(f, x))))), Times(Subtract(Times(a, C, d, Plus(n, C2)), Times(b, c, C)), Sqr(Tan(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, C, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Plus(Sqr(c), Sqr(d)), C0), Not(LtQ(n, CN1)))));
            IIntegrate(3639, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Simp(Times(Subtract(Plus(Times(a, ASymbol), Times(b, BSymbol)), Times(a, C)), Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(C2, f, m, Subtract(Times(b, c), Times(a, d))), CN1)), x), Dist(Power(Times(C2, a, m, Subtract(Times(b, c), Times(a, d))), CN1), Int(Times(Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), n), Simp(Plus(Times(b, Subtract(Times(c, Plus(ASymbol, C), m), Times(BSymbol, d, Plus(n, C1)))), Times(a, Subtract(Plus(Times(BSymbol, c, m), Times(C, d, Plus(n, C1))), Times(ASymbol, d, Plus(Times(C2, m), n, C1)))), Times(Plus(Times(b, C, d, Subtract(Subtract(m, n), C1)), Times(ASymbol, b, d, Plus(m, n, C1)), Times(a, Subtract(Times(C2, c, C, m), Times(BSymbol, d, Plus(m, n, C1))))), Tan(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, C, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(Sqr(a), Sqr(b)), C0), Or(LtQ(m, C0), EqQ(Plus(m, n, C1), C0)))));
            IIntegrate(3640, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Simp(Times(a, Subtract(ASymbol, C), Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(C2, f, m, Subtract(Times(b, c), Times(a, d))), CN1)), x), Dist(Power(Times(C2, a, m, Subtract(Times(b, c), Times(a, d))), CN1), Int(Times(Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), n), Simp(Plus(Times(b, c, Plus(ASymbol, C), m), Times(a, Subtract(Times(C, d, Plus(n, C1)), Times(ASymbol, d, Plus(Times(C2, m), n, C1)))), Times(Plus(Times(b, C, d, Subtract(Subtract(m, n), C1)), Times(ASymbol, b, d, Plus(m, n, C1)), Times(C2, a, c, C, m)), Tan(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, C, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(Sqr(a), Sqr(b)), C0), Or(LtQ(m, C0), EqQ(Plus(m, n, C1), C0)))));
            IIntegrate(3641, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Subtract(Simp(Times(Plus(Times(Sqr(c), C), Times(CN1, BSymbol, c, d), Times(ASymbol, Sqr(d))), Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(d, f, Plus(n, C1), Plus(Sqr(c), Sqr(d))), CN1)), x), Dist(Power(Times(a, d, Plus(n, C1), Plus(Sqr(c), Sqr(d))), CN1), Int(Times(Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), Plus(n, C1)), Simp(Subtract(Subtract(Times(b, Plus(Times(Sqr(c), C), Times(CN1, BSymbol, c, d), Times(ASymbol, Sqr(d))), m), Times(a, d, Plus(n, C1), Plus(Times(ASymbol, c), Times(CN1, c, C), Times(BSymbol, d)))), Times(a, Subtract(Times(d, Subtract(Times(BSymbol, c), Times(ASymbol, d)), Plus(m, n, C1)), Times(C, Subtract(Times(Sqr(c), m), Times(Sqr(d), Plus(n, C1))))), Tan(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, C, m), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(Sqr(a), Sqr(b)), C0), Not(LtQ(m, C0)), LtQ(n, CN1), NeQ(Plus(Sqr(c), Sqr(d)), C0))));
            IIntegrate(3642, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Subtract(Simp(Times(Plus(Times(Sqr(c), C), Times(ASymbol, Sqr(d))), Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(d, f, Plus(n, C1), Plus(Sqr(c), Sqr(d))), CN1)), x), Dist(Power(Times(a, d, Plus(n, C1), Plus(Sqr(c), Sqr(d))), CN1), Int(Times(Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), Plus(n, C1)), Simp(Subtract(Subtract(Times(b, Plus(Times(Sqr(c), C), Times(ASymbol, Sqr(d))), m), Times(a, d, Plus(n, C1), Subtract(Times(ASymbol, c), Times(c, C)))), Times(a, Subtract(Times(CN1, ASymbol, Sqr(d), Plus(m, n, C1)), Times(C, Subtract(Times(Sqr(c), m), Times(Sqr(d), Plus(n, C1))))), Tan(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, C, m), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(Sqr(a), Sqr(b)), C0), Not(LtQ(m, C0)), LtQ(n, CN1), NeQ(Plus(Sqr(c), Sqr(d)), C0))));
            IIntegrate(3643, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Simp(Times(C, Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(d, f, Plus(m, n, C1)), CN1)), x), Dist(Power(Times(b, d, Plus(m, n, C1)), CN1), Int(Times(Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), n), Simp(Subtract(Plus(Times(ASymbol, b, d, Plus(m, n, C1)), Times(C, Subtract(Times(a, c, m), Times(b, d, Plus(n, C1))))), Times(Subtract(Times(C, m, Subtract(Times(b, c), Times(a, d))), Times(b, BSymbol, d, Plus(m, n, C1))), Tan(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, C, m, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(Sqr(a), Sqr(b)), C0), Not(LtQ(m, C0)), NeQ(Plus(m, n, C1), C0))));
            IIntegrate(3644, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_DEFAULT), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Simp(Times(C, Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(d, f, Plus(m, n, C1)), CN1)), x), Dist(Power(Times(b, d, Plus(m, n, C1)), CN1), Int(Times(Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), n), Simp(Subtract(Plus(Times(ASymbol, b, d, Plus(m, n, C1)), Times(C, Subtract(Times(a, c, m), Times(b, d, Plus(n, C1))))), Times(C, m, Subtract(Times(b, c), Times(a, d)), Tan(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, C, m, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Plus(Sqr(a), Sqr(b)), C0), Not(LtQ(m, C0)), NeQ(Plus(m, n, C1), C0))));
            IIntegrate(3645, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Subtract(Simp(Times(Plus(Times(ASymbol, Sqr(d)), Times(c, Subtract(Times(c, C), Times(BSymbol, d)))), Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(d, f, Plus(n, C1), Plus(Sqr(c), Sqr(d))), CN1)), x), Dist(Power(Times(d, Plus(n, C1), Plus(Sqr(c), Sqr(d))), CN1), Int(Times(Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), Plus(n, C1)), Simp(Subtract(Subtract(Plus(Times(ASymbol, d, Subtract(Times(b, d, m), Times(a, c, Plus(n, C1)))), Times(Subtract(Times(c, C), Times(BSymbol, d)), Plus(Times(b, c, m), Times(a, d, Plus(n, C1))))), Times(d, Plus(n, C1), Plus(Times(Subtract(ASymbol, C), Subtract(Times(b, c), Times(a, d))), Times(BSymbol, Plus(Times(a, c), Times(b, d)))), Tan(Plus(e, Times(f, x))))), Times(b, Subtract(Times(d, Subtract(Times(BSymbol, c), Times(ASymbol, d)), Plus(m, n, C1)), Times(C, Subtract(Times(Sqr(c), m), Times(Sqr(d), Plus(n, C1))))), Sqr(Tan(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, C), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Plus(Sqr(a), Sqr(b)), C0), NeQ(Plus(Sqr(c), Sqr(d)), C0), GtQ(m, C0), LtQ(n, CN1))));
            IIntegrate(3646, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Subtract(Simp(Times(Plus(Times(ASymbol, Sqr(d)), Times(Sqr(c), C)), Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(d, f, Plus(n, C1), Plus(Sqr(c), Sqr(d))), CN1)), x), Dist(Power(Times(d, Plus(n, C1), Plus(Sqr(c), Sqr(d))), CN1), Int(Times(Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), Plus(n, C1)), Simp(Plus(Times(ASymbol, d, Subtract(Times(b, d, m), Times(a, c, Plus(n, C1)))), Times(c, C, Plus(Times(b, c, m), Times(a, d, Plus(n, C1)))), Times(CN1, d, Plus(n, C1), Subtract(ASymbol, C), Subtract(Times(b, c), Times(a, d)), Tan(Plus(e, Times(f, x)))), Times(b, Plus(Times(ASymbol, Sqr(d), Plus(m, n, C1)), Times(C, Subtract(Times(Sqr(c), m), Times(Sqr(d), Plus(n, C1))))), Sqr(Tan(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, C), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Plus(Sqr(a), Sqr(b)), C0), NeQ(Plus(Sqr(c), Sqr(d)), C0), GtQ(m, C0), LtQ(n, CN1))));
            IIntegrate(3647, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Simp(Times(C, Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(d, f, Plus(m, n, C1)), CN1)), x), Dist(Power(Times(d, Plus(m, n, C1)), CN1), Int(Times(Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), n), Simp(Subtract(Plus(Times(a, ASymbol, d, Plus(m, n, C1)), Times(CN1, C, Plus(Times(b, c, m), Times(a, d, Plus(n, C1)))), Times(d, Subtract(Plus(Times(ASymbol, b), Times(a, BSymbol)), Times(b, C)), Plus(m, n, C1), Tan(Plus(e, Times(f, x))))), Times(Subtract(Times(C, m, Subtract(Times(b, c), Times(a, d))), Times(b, BSymbol, d, Plus(m, n, C1))), Sqr(Tan(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, C, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Plus(Sqr(a), Sqr(b)), C0), NeQ(Plus(Sqr(c), Sqr(d)), C0), GtQ(m, C0), Not(And(IGtQ(n, C0), Or(Not(IntegerQ(m)), And(EqQ(c, C0), NeQ(a, C0))))))));
            IIntegrate(3648, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Simp(Times(C, Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), m), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(d, f, Plus(m, n, C1)), CN1)), x), Dist(Power(Times(d, Plus(m, n, C1)), CN1), Int(Times(Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), Subtract(m, C1)), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), n), Simp(Subtract(Plus(Times(a, ASymbol, d, Plus(m, n, C1)), Times(CN1, C, Plus(Times(b, c, m), Times(a, d, Plus(n, C1)))), Times(d, Subtract(Times(ASymbol, b), Times(b, C)), Plus(m, n, C1), Tan(Plus(e, Times(f, x))))), Times(C, m, Subtract(Times(b, c), Times(a, d)), Sqr(Tan(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, C, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Plus(Sqr(a), Sqr(b)), C0), NeQ(Plus(Sqr(c), Sqr(d)), C0), GtQ(m, C0), Not(And(IGtQ(n, C0), Or(Not(IntegerQ(m)), And(EqQ(c, C0), NeQ(a, C0))))))));
            IIntegrate(3649, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Simp(Times(Subtract(Times(ASymbol, Sqr(b)), Times(a, Subtract(Times(b, BSymbol), Times(a, C)))), Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(f, Plus(m, C1), Subtract(Times(b, c), Times(a, d)), Plus(Sqr(a), Sqr(b))), CN1)), x), Dist(Power(Times(Plus(m, C1), Subtract(Times(b, c), Times(a, d)), Plus(Sqr(a), Sqr(b))), CN1), Int(Times(Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), n), Simp(Subtract(Subtract(Plus(Times(ASymbol, Subtract(Times(a, Subtract(Times(b, c), Times(a, d)), Plus(m, C1)), Times(Sqr(b), d, Plus(m, n, C2)))), Times(Subtract(Times(b, BSymbol), Times(a, C)), Plus(Times(b, c, Plus(m, C1)), Times(a, d, Plus(n, C1))))), Times(Plus(m, C1), Subtract(Times(b, c), Times(a, d)), Subtract(Subtract(Times(ASymbol, b), Times(a, BSymbol)), Times(b, C)), Tan(Plus(e, Times(f, x))))), Times(d, Subtract(Times(ASymbol, Sqr(b)), Times(a, Subtract(Times(b, BSymbol), Times(a, C)))), Plus(m, n, C2), Sqr(Tan(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, C, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Plus(Sqr(a), Sqr(b)), C0), NeQ(Plus(Sqr(c), Sqr(d)), C0), LtQ(m, CN1), Not(And(ILtQ(n, CN1), Or(Not(IntegerQ(m)), And(EqQ(c, C0), NeQ(a, C0))))))));
            IIntegrate(3650, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), n_), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(Times(ASymbol, Sqr(b)), Times(Sqr(a), C)), Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), Plus(n, C1)), Power(Times(f, Plus(m, C1), Subtract(Times(b, c), Times(a, d)), Plus(Sqr(a), Sqr(b))), CN1)), x), Dist(Power(Times(Plus(m, C1), Subtract(Times(b, c), Times(a, d)), Plus(Sqr(a), Sqr(b))), CN1), Int(Times(Power(Plus(a, Times(b, Tan(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Plus(c, Times(d, Tan(Plus(e, Times(f, x))))), n), Simp(Subtract(Subtract(Subtract(Times(ASymbol, Subtract(Times(a, Subtract(Times(b, c), Times(a, d)), Plus(m, C1)), Times(Sqr(b), d, Plus(m, n, C2)))), Times(a, C, Plus(Times(b, c, Plus(m, C1)), Times(a, d, Plus(n, C1))))), Times(Plus(m, C1), Subtract(Times(b, c), Times(a, d)), Subtract(Times(ASymbol, b), Times(b, C)), Tan(Plus(e, Times(f, x))))), Times(d, Plus(Times(ASymbol, Sqr(b)), Times(Sqr(a), C)), Plus(m, n, C2), Sqr(Tan(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, C, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Plus(Sqr(a), Sqr(b)), C0), NeQ(Plus(Sqr(c), Sqr(d)), C0), LtQ(m, CN1), Not(And(ILtQ(n, CN1), Or(Not(IntegerQ(m)), And(EqQ(c, C0), NeQ(a, C0))))))));
        }
    }
}
