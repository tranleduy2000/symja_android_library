package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$p;
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
import static org.matheclipse.core.expression.F.MatchQ;
import static org.matheclipse.core.expression.F.MemberQ;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
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
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ActivateTrig;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FreeFactors;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules164 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(4101, Int(Times(Plus(A_DEFAULT, Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), n_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_)), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(Times(ASymbol, Sqr(b)), Times(Sqr(a), C)), Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(d, Csc(Plus(e, Times(f, x)))), n), Power(Times(a, f, Plus(m, C1), Subtract(Sqr(a), Sqr(b))), CN1)), x), Dist(Power(Times(a, Plus(m, C1), Subtract(Sqr(a), Sqr(b))), CN1), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(d, Csc(Plus(e, Times(f, x)))), n), Simp(Plus(Times(Sqr(a), Plus(ASymbol, C), Plus(m, C1)), Times(CN1, Plus(Times(ASymbol, Sqr(b)), Times(Sqr(a), C)), Plus(m, n, C1)), Times(CN1, a, b, Plus(ASymbol, C), Plus(m, C1), Csc(Plus(e, Times(f, x)))), Times(Plus(Times(ASymbol, Sqr(b)), Times(Sqr(a), C)), Plus(m, n, C2), Sqr(Csc(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, d, e, f, ASymbol, C, n), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), LtQ(m, CN1), Not(And(ILtQ(Plus(m, C1D2), C0), ILtQ(n, C0))))));
            IIntegrate(4102, Int(Times(Plus(A_DEFAULT, Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), n_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(C, d, Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(d, Csc(Plus(e, Times(f, x)))), Subtract(n, C1)), Power(Times(b, f, Plus(m, n, C1)), CN1)), x)), Dist(Times(d, Power(Times(b, Plus(m, n, C1)), CN1)), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Power(Times(d, Csc(Plus(e, Times(f, x)))), Subtract(n, C1)), Simp(Plus(Times(a, C, Subtract(n, C1)), Times(Plus(Times(ASymbol, b, Plus(m, n, C1)), Times(b, C, Plus(m, n))), Csc(Plus(e, Times(f, x)))), Times(Subtract(Times(b, BSymbol, Plus(m, n, C1)), Times(a, C, n)), Sqr(Csc(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, d, e, f, ASymbol, BSymbol, C, m), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), GtQ(n, C0))));
            IIntegrate(4103, Int(Times(Plus(A_DEFAULT, Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), n_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(C, d, Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(d, Csc(Plus(e, Times(f, x)))), Subtract(n, C1)), Power(Times(b, f, Plus(m, n, C1)), CN1)), x)), Dist(Times(d, Power(Times(b, Plus(m, n, C1)), CN1)), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Power(Times(d, Csc(Plus(e, Times(f, x)))), Subtract(n, C1)), Simp(Subtract(Plus(Times(a, C, Subtract(n, C1)), Times(Plus(Times(ASymbol, b, Plus(m, n, C1)), Times(b, C, Plus(m, n))), Csc(Plus(e, Times(f, x))))), Times(a, C, n, Sqr(Csc(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, d, e, f, ASymbol, C, m), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), GtQ(n, C0))));
            IIntegrate(4104, Int(Times(Plus(A_DEFAULT, Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), n_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_)), x_Symbol),
                    Condition(Plus(Simp(Times(ASymbol, Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(d, Csc(Plus(e, Times(f, x)))), n), Power(Times(a, f, n), CN1)), x), Dist(Power(Times(a, d, n), CN1), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Power(Times(d, Csc(Plus(e, Times(f, x)))), Plus(n, C1)), Simp(Plus(Times(a, BSymbol, n), Times(CN1, ASymbol, b, Plus(m, n, C1)), Times(a, Plus(ASymbol, Times(ASymbol, n), Times(C, n)), Csc(Plus(e, Times(f, x)))), Times(ASymbol, b, Plus(m, n, C2), Sqr(Csc(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, d, e, f, ASymbol, BSymbol, C, m), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), LeQ(n, CN1))));
            IIntegrate(4105, Int(Times(Plus(A_DEFAULT, Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), n_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_)), x_Symbol),
                    Condition(Plus(Simp(Times(ASymbol, Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(d, Csc(Plus(e, Times(f, x)))), n), Power(Times(a, f, n), CN1)), x), Dist(Power(Times(a, d, n), CN1), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Power(Times(d, Csc(Plus(e, Times(f, x)))), Plus(n, C1)), Simp(Plus(Times(CN1, ASymbol, b, Plus(m, n, C1)), Times(a, Plus(ASymbol, Times(ASymbol, n), Times(C, n)), Csc(Plus(e, Times(f, x)))), Times(ASymbol, b, Plus(m, n, C2), Sqr(Csc(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, d, e, f, ASymbol, C, m), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), LeQ(n, CN1))));
            IIntegrate(4106, Int(Times(Plus(A_DEFAULT, Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), CN1D2), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), CN1)), x_Symbol),
                    Condition(Plus(Dist(Times(Plus(Times(ASymbol, Sqr(b)), Times(CN1, a, b, BSymbol), Times(Sqr(a), C)), Power(Times(Sqr(a), Sqr(d)), CN1)), Int(Times(Power(Times(d, Csc(Plus(e, Times(f, x)))), QQ(3L, 2L)), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1)), x), x), Dist(Power(a, CN2), Int(Times(Subtract(Times(a, ASymbol), Times(Subtract(Times(ASymbol, b), Times(a, BSymbol)), Csc(Plus(e, Times(f, x))))), Power(Times(d, Csc(Plus(e, Times(f, x)))), CN1D2)), x), x)), And(FreeQ(List(a, b, d, e, f, ASymbol, BSymbol, C), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(4107, Int(Times(Plus(A_DEFAULT, Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), CN1D2), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), CN1)), x_Symbol),
                    Condition(Plus(Dist(Times(Plus(Times(ASymbol, Sqr(b)), Times(Sqr(a), C)), Power(Times(Sqr(a), Sqr(d)), CN1)), Int(Times(Power(Times(d, Csc(Plus(e, Times(f, x)))), QQ(3L, 2L)), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1)), x), x), Dist(Power(a, CN2), Int(Times(Subtract(Times(a, ASymbol), Times(ASymbol, b, Csc(Plus(e, Times(f, x))))), Power(Times(d, Csc(Plus(e, Times(f, x)))), CN1D2)), x), x)), And(FreeQ(List(a, b, d, e, f, ASymbol, C), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(4108, Int(Times(Plus(A_DEFAULT, Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), CN1D2), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), CN1D2)), x_Symbol),
                    Condition(Plus(Dist(Times(C, Power(d, CN2)), Int(Times(Power(Times(d, Csc(Plus(e, Times(f, x)))), QQ(3L, 2L)), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2)), x), x), Int(Times(Plus(ASymbol, Times(BSymbol, Csc(Plus(e, Times(f, x))))), Power(Times(Sqrt(Times(d, Csc(Plus(e, Times(f, x))))), Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))))), CN1)), x)), And(FreeQ(List(a, b, d, e, f, ASymbol, BSymbol, C), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(4109, Int(Times(Plus(A_DEFAULT, Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), CN1D2), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), CN1D2)), x_Symbol),
                    Condition(Plus(Dist(Times(C, Power(d, CN2)), Int(Times(Power(Times(d, Csc(Plus(e, Times(f, x)))), QQ(3L, 2L)), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2)), x), x), Dist(ASymbol, Int(Power(Times(Sqrt(Times(d, Csc(Plus(e, Times(f, x))))), Sqrt(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))))), CN1), x), x)), And(FreeQ(List(a, b, d, e, f, ASymbol, C), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(4110, Int(Times(Plus(A_DEFAULT, Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), n_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Times(d, Csc(Plus(e, Times(f, x)))), n), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Plus(ASymbol, Times(BSymbol, Csc(Plus(e, Times(f, x)))), Times(C, Sqr(Csc(Plus(e, Times(f, x))))))), x), FreeQ(List(a, b, d, e, f, ASymbol, BSymbol, C, m, n), x)));
            IIntegrate(4111, Int(Times(Plus(A_DEFAULT, Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), n_DEFAULT), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Times(d, Csc(Plus(e, Times(f, x)))), n), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Plus(ASymbol, Times(C, Sqr(Csc(Plus(e, Times(f, x))))))), x), FreeQ(List(a, b, d, e, f, ASymbol, C, m, n), x)));
            IIntegrate(4112, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), n_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Dist(Power(d, Plus(m, C2)), Int(Times(Power(Plus(b, Times(a, Cos(Plus(e, Times(f, x))))), m), Power(Times(d, Cos(Plus(e, Times(f, x)))), Subtract(Subtract(n, m), C2)), Plus(C, Times(BSymbol, Cos(Plus(e, Times(f, x)))), Times(ASymbol, Sqr(Cos(Plus(e, Times(f, x))))))), x), x), And(FreeQ(List(a, b, d, e, f, ASymbol, BSymbol, C, n), x), Not(IntegerQ(n)), IntegerQ(m))));
            IIntegrate(4113, Int(Times(Plus(A_DEFAULT, Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_DEFAULT), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_)), x_Symbol),
                    Condition(Dist(Power(d, Plus(m, C2)), Int(Times(Power(Plus(b, Times(a, Sin(Plus(e, Times(f, x))))), m), Power(Times(d, Sin(Plus(e, Times(f, x)))), Subtract(Subtract(n, m), C2)), Plus(C, Times(BSymbol, Sin(Plus(e, Times(f, x)))), Times(ASymbol, Sqr(Sin(Plus(e, Times(f, x))))))), x), x), And(FreeQ(List(a, b, d, e, f, ASymbol, BSymbol, C, n), x), Not(IntegerQ(n)), IntegerQ(m))));
            IIntegrate(4114, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), n_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Dist(Power(d, Plus(m, C2)), Int(Times(Power(Plus(b, Times(a, Cos(Plus(e, Times(f, x))))), m), Power(Times(d, Cos(Plus(e, Times(f, x)))), Subtract(Subtract(n, m), C2)), Plus(C, Times(ASymbol, Sqr(Cos(Plus(e, Times(f, x))))))), x), x), And(FreeQ(List(a, b, d, e, f, ASymbol, C, n), x), Not(IntegerQ(n)), IntegerQ(m))));
            IIntegrate(4115, Int(Times(Plus(A_DEFAULT, Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_DEFAULT), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_)), x_Symbol),
                    Condition(Dist(Power(d, Plus(m, C2)), Int(Times(Power(Plus(b, Times(a, Sin(Plus(e, Times(f, x))))), m), Power(Times(d, Sin(Plus(e, Times(f, x)))), Subtract(Subtract(n, m), C2)), Plus(C, Times(ASymbol, Sqr(Sin(Plus(e, Times(f, x))))))), x), x), And(FreeQ(List(a, b, d, e, f, ASymbol, C, n), x), Not(IntegerQ(n)), IntegerQ(m))));
            IIntegrate(4116, Int(Times(Power(Times(c_DEFAULT, Power(Times(d_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), p_)), n_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Dist(Times(Power(c, IntPart(n)), Power(Times(c, Power(Times(d, Sec(Plus(e, Times(f, x)))), p)), FracPart(n)), Power(Power(Times(d, Sec(Plus(e, Times(f, x)))), Times(p, FracPart(n))), CN1)), Int(Times(Power(Plus(a, Times(b, Sec(Plus(e, Times(f, x))))), m), Power(Times(d, Sec(Plus(e, Times(f, x)))), Times(n, p)), Plus(ASymbol, Times(BSymbol, Sec(Plus(e, Times(f, x)))), Times(C, Sqr(Sec(Plus(e, Times(f, x))))))), x), x), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, C, m, n, p), x), Not(IntegerQ(n)))));
            IIntegrate(4117, Int(Times(Plus(A_DEFAULT, Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Times(c_DEFAULT, Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), p_)), n_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(c, IntPart(n)), Power(Times(c, Power(Times(d, Csc(Plus(e, Times(f, x)))), p)), FracPart(n)), Power(Power(Times(d, Csc(Plus(e, Times(f, x)))), Times(p, FracPart(n))), CN1)), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Power(Times(d, Csc(Plus(e, Times(f, x)))), Times(n, p)), Plus(ASymbol, Times(BSymbol, Csc(Plus(e, Times(f, x)))), Times(C, Sqr(Csc(Plus(e, Times(f, x))))))), x), x), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, C, m, n, p), x), Not(IntegerQ(n)))));
            IIntegrate(4118, Int(Times(Power(Times(c_DEFAULT, Power(Times(d_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), p_)), n_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Dist(Times(Power(c, IntPart(n)), Power(Times(c, Power(Times(d, Sec(Plus(e, Times(f, x)))), p)), FracPart(n)), Power(Power(Times(d, Sec(Plus(e, Times(f, x)))), Times(p, FracPart(n))), CN1)), Int(Times(Power(Plus(a, Times(b, Sec(Plus(e, Times(f, x))))), m), Power(Times(d, Sec(Plus(e, Times(f, x)))), Times(n, p)), Plus(ASymbol, Times(C, Sqr(Sec(Plus(e, Times(f, x))))))), x), x), And(FreeQ(List(a, b, c, d, e, f, ASymbol, C, m, n, p), x), Not(IntegerQ(n)))));
            IIntegrate(4119, Int(Times(Plus(A_DEFAULT, Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Times(c_DEFAULT, Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), p_)), n_), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(c, IntPart(n)), Power(Times(c, Power(Times(d, Csc(Plus(e, Times(f, x)))), p)), FracPart(n)), Power(Power(Times(d, Csc(Plus(e, Times(f, x)))), Times(p, FracPart(n))), CN1)), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Power(Times(d, Csc(Plus(e, Times(f, x)))), Times(n, p)), Plus(ASymbol, Times(C, Sqr(Csc(Plus(e, Times(f, x))))))), x), x), And(FreeQ(List(a, b, c, d, e, f, ASymbol, C, m, n, p), x), Not(IntegerQ(n)))));
            IIntegrate(4120, Int(Times(u_DEFAULT, Power(Plus(a_, Times(b_DEFAULT, Sqr($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), p_)), x_Symbol),
                    Condition(Dist(Power(b, p), Int(ActivateTrig(Times(u, Power($($s("§tan"), Plus(e, Times(f, x))), Times(C2, p)))), x), x), And(FreeQ(List(a, b, e, f, p), x), EqQ(Plus(a, b), C0), IntegerQ(p))));
            IIntegrate(4121, Int(Times(u_DEFAULT, Power(Plus(a_, Times(b_DEFAULT, Sqr($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), p_)), x_Symbol),
                    Condition(Int(ActivateTrig(Times(u, Power(Times(b, Sqr($($s("§tan"), Plus(e, Times(f, x))))), p))), x), And(FreeQ(List(a, b, e, f, p), x), EqQ(Plus(a, b), C0))));
            IIntegrate(4122, Int(Power(Times(b_DEFAULT, Sqr($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), p_), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Tan(Plus(e, Times(f, x))), x))), Dist(Times(b, $s("ff"), Power(f, CN1)), Subst(Int(Power(Plus(b, Times(b, Sqr($s("ff")), Sqr(x))), Subtract(p, C1)), x), x, Times(Tan(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x)), And(FreeQ(List(b, e, f, p), x), Not(IntegerQ(p)))));
            IIntegrate(4123, Int(Power(Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_)), p_), x_Symbol),
                    Condition(Dist(Times(Power(b, IntPart(p)), Power(Times(b, Power(Times(c, Sec(Plus(e, Times(f, x)))), n)), FracPart(p)), Power(Power(Times(c, Sec(Plus(e, Times(f, x)))), Times(n, FracPart(p))), CN1)), Int(Power(Times(c, Sec(Plus(e, Times(f, x)))), Times(n, p)), x), x), And(FreeQ(List(b, c, e, f, n, p), x), Not(IntegerQ(p)))));
            IIntegrate(4124, Int(Times(Power(Times(b_DEFAULT, Sqr($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), p_DEFAULT), Power($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(b, Power(Times(C2, f), CN1)), Subst(Int(Times(Power(Plus(CN1, x), Times(C1D2, Subtract(m, C1))), Power(Times(b, x), Subtract(p, C1))), x), x, Sqr(Sec(Plus(e, Times(f, x))))), x), And(FreeQ(List(b, e, f, p), x), Not(IntegerQ(p)), IntegerQ(Times(C1D2, Subtract(m, C1))))));
            IIntegrate(4125, Int(Times(u_DEFAULT, Power(Times(b_DEFAULT, Power($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), n_)), p_)), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Sec(Plus(e, Times(f, x))), x))), Dist(Times(Power(Times(b, Power($s("ff"), n)), IntPart(p)), Power(Times(b, Power(Sec(Plus(e, Times(f, x))), n)), FracPart(p)), Power(Power(Times(Sec(Plus(e, Times(f, x))), Power($s("ff"), CN1)), Times(n, FracPart(p))), CN1)), Int(Times(ActivateTrig(u), Power(Times(Sec(Plus(e, Times(f, x))), Power($s("ff"), CN1)), Times(n, p))), x), x)), And(FreeQ(List(b, e, f, n, p), x), Not(IntegerQ(p)), IntegerQ(n), Or(EqQ(u, C1), MatchQ(u, Condition(Power(Times(d_DEFAULT, $($p("§trig"), Plus(e, Times(f, x)))), m_DEFAULT), And(FreeQ(List(d, m), x), MemberQ(List($s("§sin"), $s("§cos"), $s("§tan"), $s("§cot"), $s("§sec"), $s("§csc")), $s("§trig")))))))));
        }
    }
}
