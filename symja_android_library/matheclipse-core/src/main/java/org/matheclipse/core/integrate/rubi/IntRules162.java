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
import static org.matheclipse.core.expression.F.Sec;
import static org.matheclipse.core.expression.F.Sin;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules162 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(4051, Int(Times(Plus(A_DEFAULT, Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), CN1)), x_Symbol),
                    Condition(Plus(Dist(Times(C, Power(b, CN1)), Int(Csc(Plus(e, Times(f, x))), x), x), Dist(Power(b, CN1), Int(Times(Subtract(Times(ASymbol, b), Times(a, C, Csc(Plus(e, Times(f, x))))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1)), x), x)), FreeQ(List(a, b, e, f, ASymbol, C), x)));
            IIntegrate(4052, Int(Times(Plus(A_DEFAULT, Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Plus(Times(a, ASymbol), Times(CN1, b, BSymbol), Times(a, C)), Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Power(Times(a, f, Plus(Times(C2, m), C1)), CN1)), x)), Dist(Power(Times(a, b, Plus(Times(C2, m), C1)), CN1), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Simp(Plus(Times(ASymbol, b, Plus(Times(C2, m), C1)), Times(Subtract(Times(b, BSymbol, Plus(m, C1)), Times(a, Subtract(Times(ASymbol, Plus(m, C1)), Times(C, m)))), Csc(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, e, f, ASymbol, BSymbol, C), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), LtQ(m, Negate(C1D2)))));
            IIntegrate(4053, Int(Times(Plus(A_DEFAULT, Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(a, Plus(ASymbol, C), Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Power(Times(a, f, Plus(Times(C2, m), C1)), CN1)), x)), Dist(Power(Times(a, b, Plus(Times(C2, m), C1)), CN1), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Simp(Subtract(Times(ASymbol, b, Plus(Times(C2, m), C1)), Times(a, Subtract(Times(ASymbol, Plus(m, C1)), Times(C, m)), Csc(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, e, f, ASymbol, C), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), LtQ(m, Negate(C1D2)))));
            IIntegrate(4054, Int(Times(Plus(A_DEFAULT, Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(C, Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Power(Times(f, Plus(m, C1)), CN1)), x)), Dist(Power(Times(b, Plus(m, C1)), CN1), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Simp(Plus(Times(ASymbol, b, Plus(m, C1)), Times(Plus(Times(a, C, m), Times(b, BSymbol, Plus(m, C1))), Csc(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, e, f, ASymbol, BSymbol, C, m), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), Not(LtQ(m, Negate(C1D2))))));
            IIntegrate(4055, Int(Times(Plus(A_DEFAULT, Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(C, Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Power(Times(f, Plus(m, C1)), CN1)), x)), Dist(Power(Times(b, Plus(m, C1)), CN1), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Simp(Plus(Times(ASymbol, b, Plus(m, C1)), Times(a, C, m, Csc(Plus(e, Times(f, x))))), x)), x), x)), And(FreeQ(List(a, b, e, f, ASymbol, C, m), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), Not(LtQ(m, Negate(C1D2))))));
            IIntegrate(4056, Int(Times(Plus(A_DEFAULT, Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(C, Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Power(Times(f, Plus(m, C1)), CN1)), x)), Dist(Power(Plus(m, C1), CN1), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Subtract(m, C1)), Simp(Plus(Times(a, ASymbol, Plus(m, C1)), Times(Plus(Times(Plus(Times(ASymbol, b), Times(a, BSymbol)), Plus(m, C1)), Times(b, C, m)), Csc(Plus(e, Times(f, x)))), Times(Plus(Times(b, BSymbol, Plus(m, C1)), Times(a, C, m)), Sqr(Csc(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, e, f, ASymbol, BSymbol, C), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), IGtQ(Times(C2, m), C0))));
            IIntegrate(4057, Int(Times(Plus(A_DEFAULT, Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(C, Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Power(Times(f, Plus(m, C1)), CN1)), x)), Dist(Power(Plus(m, C1), CN1), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Subtract(m, C1)), Simp(Plus(Times(a, ASymbol, Plus(m, C1)), Times(Plus(Times(ASymbol, b, Plus(m, C1)), Times(b, C, m)), Csc(Plus(e, Times(f, x)))), Times(a, C, m, Sqr(Csc(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, e, f, ASymbol, C), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), IGtQ(Times(C2, m), C0))));
            IIntegrate(4058, Int(Times(Plus(A_DEFAULT, Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), CN1D2)), x_Symbol),
                    Condition(Plus(Int(Times(Plus(ASymbol, Times(Subtract(BSymbol, C), Csc(Plus(e, Times(f, x))))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2)), x), Dist(C, Int(Times(Csc(Plus(e, Times(f, x))), Plus(C1, Csc(Plus(e, Times(f, x)))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2)), x), x)), And(FreeQ(List(a, b, e, f, ASymbol, BSymbol, C), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(4059, Int(Times(Plus(A_DEFAULT, Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), CN1D2)), x_Symbol),
                    Condition(Plus(Int(Times(Subtract(ASymbol, Times(C, Csc(Plus(e, Times(f, x))))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2)), x), Dist(C, Int(Times(Csc(Plus(e, Times(f, x))), Plus(C1, Csc(Plus(e, Times(f, x)))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), CN1D2)), x), x)), And(FreeQ(List(a, b, e, f, ASymbol, C), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(4060, Int(Times(Plus(A_DEFAULT, Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_)), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(Times(ASymbol, Sqr(b)), Times(CN1, a, b, BSymbol), Times(Sqr(a), C)), Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(a, f, Plus(m, C1), Subtract(Sqr(a), Sqr(b))), CN1)), x), Dist(Power(Times(a, Plus(m, C1), Subtract(Sqr(a), Sqr(b))), CN1), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Simp(Plus(Times(ASymbol, Subtract(Sqr(a), Sqr(b)), Plus(m, C1)), Times(CN1, a, Plus(Times(ASymbol, b), Times(CN1, a, BSymbol), Times(b, C)), Plus(m, C1), Csc(Plus(e, Times(f, x)))), Times(Plus(Times(ASymbol, Sqr(b)), Times(CN1, a, b, BSymbol), Times(Sqr(a), C)), Plus(m, C2), Sqr(Csc(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, e, f, ASymbol, BSymbol, C), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), LtQ(m, CN1))));
            IIntegrate(4061, Int(Times(Plus(A_DEFAULT, Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_)), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(Times(ASymbol, Sqr(b)), Times(Sqr(a), C)), Cot(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(a, f, Plus(m, C1), Subtract(Sqr(a), Sqr(b))), CN1)), x), Dist(Power(Times(a, Plus(m, C1), Subtract(Sqr(a), Sqr(b))), CN1), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Simp(Plus(Times(ASymbol, Subtract(Sqr(a), Sqr(b)), Plus(m, C1)), Times(CN1, a, b, Plus(ASymbol, C), Plus(m, C1), Csc(Plus(e, Times(f, x)))), Times(Plus(Times(ASymbol, Sqr(b)), Times(Sqr(a), C)), Plus(m, C2), Sqr(Csc(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, e, f, ASymbol, C), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), IntegerQ(Times(C2, m)), LtQ(m, CN1))));
            IIntegrate(4062, Int(Times(Plus(A_DEFAULT, Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_)), x_Symbol),
                    Condition(Plus(Dist(Power(b, CN1), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Plus(Times(ASymbol, b), Times(Subtract(Times(b, BSymbol), Times(a, C)), Csc(Plus(e, Times(f, x)))))), x), x), Dist(Times(C, Power(b, CN1)), Int(Times(Csc(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1))), x), x)), And(FreeQ(List(a, b, e, f, ASymbol, BSymbol, C, m), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), Not(IntegerQ(Times(C2, m))))));
            IIntegrate(4063, Int(Times(Plus(A_DEFAULT, Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_), m_)), x_Symbol),
                    Condition(Plus(Dist(Power(b, CN1), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), m), Subtract(Times(ASymbol, b), Times(a, C, Csc(Plus(e, Times(f, x)))))), x), x), Dist(Times(C, Power(b, CN1)), Int(Times(Csc(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1))), x), x)), And(FreeQ(List(a, b, e, f, ASymbol, C, m), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), Not(IntegerQ(Times(C2, m))))));
            IIntegrate(4064, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), m_), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Dist(Sqr(b), Int(Times(Power(Times(b, Cos(Plus(e, Times(f, x)))), Subtract(m, C2)), Plus(C, Times(BSymbol, Cos(Plus(e, Times(f, x)))), Times(ASymbol, Sqr(Cos(Plus(e, Times(f, x))))))), x), x), And(FreeQ(List(b, e, f, ASymbol, BSymbol, C, m), x), Not(IntegerQ(m)))));
            IIntegrate(4065, Int(Times(Plus(A_DEFAULT, Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_)), x_Symbol),
                    Condition(Dist(Sqr(b), Int(Times(Power(Times(b, Sin(Plus(e, Times(f, x)))), Subtract(m, C2)), Plus(C, Times(BSymbol, Sin(Plus(e, Times(f, x)))), Times(ASymbol, Sqr(Sin(Plus(e, Times(f, x))))))), x), x), And(FreeQ(List(b, e, f, ASymbol, BSymbol, C, m), x), Not(IntegerQ(m)))));
            IIntegrate(4066, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), m_), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Dist(Sqr(b), Int(Times(Power(Times(b, Cos(Plus(e, Times(f, x)))), Subtract(m, C2)), Plus(C, Times(ASymbol, Sqr(Cos(Plus(e, Times(f, x))))))), x), x), And(FreeQ(List(b, e, f, ASymbol, C, m), x), Not(IntegerQ(m)))));
            IIntegrate(4067, Int(Times(Plus(A_DEFAULT, Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_)), x_Symbol),
                    Condition(Dist(Sqr(b), Int(Times(Power(Times(b, Sin(Plus(e, Times(f, x)))), Subtract(m, C2)), Plus(C, Times(ASymbol, Sqr(Sin(Plus(e, Times(f, x))))))), x), x), And(FreeQ(List(b, e, f, ASymbol, C, m), x), Not(IntegerQ(m)))));
            IIntegrate(4068, Int(Times(Power(Times(a_DEFAULT, Power(Times(b_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), p_)), m_), Plus(A_DEFAULT, Times(B_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), Times(C_DEFAULT, Sqr($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Dist(Times(Power(a, IntPart(m)), Power(Times(a, Power(Times(b, Sec(Plus(e, Times(f, x)))), p)), FracPart(m)), Power(Power(Times(b, Sec(Plus(e, Times(f, x)))), Times(p, FracPart(m))), CN1)), Int(Times(Power(Times(b, Sec(Plus(e, Times(f, x)))), Times(m, p)), Plus(ASymbol, Times(BSymbol, Sec(Plus(e, Times(f, x)))), Times(C, Sqr(Sec(Plus(e, Times(f, x))))))), x), x), And(FreeQ(List(a, b, e, f, ASymbol, BSymbol, C, m, p), x), Not(IntegerQ(m)))));
            IIntegrate(4069, Int(Times(Power(Times(a_DEFAULT, Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), p_)), m_), Plus(A_DEFAULT, Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT))), x_Symbol),
                    Condition(Dist(Times(Power(a, IntPart(m)), Power(Times(a, Power(Times(b, Csc(Plus(e, Times(f, x)))), p)), FracPart(m)), Power(Power(Times(b, Csc(Plus(e, Times(f, x)))), Times(p, FracPart(m))), CN1)), Int(Times(Power(Times(b, Csc(Plus(e, Times(f, x)))), Times(m, p)), Plus(ASymbol, Times(BSymbol, Csc(Plus(e, Times(f, x)))), Times(C, Sqr(Csc(Plus(e, Times(f, x))))))), x), x), And(FreeQ(List(a, b, e, f, ASymbol, BSymbol, C, m, p), x), Not(IntegerQ(m)))));
            IIntegrate(4070, Int(Times(Power(Times(a_DEFAULT, Power(Times(b_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), p_)), m_), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))))), x_Symbol),
                    Condition(Dist(Times(Power(a, IntPart(m)), Power(Times(a, Power(Times(b, Sec(Plus(e, Times(f, x)))), p)), FracPart(m)), Power(Power(Times(b, Sec(Plus(e, Times(f, x)))), Times(p, FracPart(m))), CN1)), Int(Times(Power(Times(b, Sec(Plus(e, Times(f, x)))), Times(m, p)), Plus(ASymbol, Times(C, Sqr(Sec(Plus(e, Times(f, x))))))), x), x), And(FreeQ(List(a, b, e, f, ASymbol, C, m, p), x), Not(IntegerQ(m)))));
            IIntegrate(4071, Int(Times(Power(Times(a_DEFAULT, Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), p_)), m_), Plus(A_DEFAULT, Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT))), x_Symbol),
                    Condition(Dist(Times(Power(a, IntPart(m)), Power(Times(a, Power(Times(b, Csc(Plus(e, Times(f, x)))), p)), FracPart(m)), Power(Power(Times(b, Csc(Plus(e, Times(f, x)))), Times(p, FracPart(m))), CN1)), Int(Times(Power(Times(b, Csc(Plus(e, Times(f, x)))), Times(m, p)), Plus(ASymbol, Times(C, Sqr(Csc(Plus(e, Times(f, x))))))), x), x), And(FreeQ(List(a, b, e, f, ASymbol, C, m, p), x), Not(IntegerQ(m)))));
            IIntegrate(4072, Int(Times(Power(Plus(a_DEFAULT, Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT)), m_DEFAULT), Plus(A_DEFAULT, Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Plus(c_DEFAULT, Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT)), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(b, CN2), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), n), Plus(Times(b, BSymbol), Times(CN1, a, C), Times(b, C, Csc(Plus(e, Times(f, x)))))), x), x), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, C, m, n), x), EqQ(Plus(Times(ASymbol, Sqr(b)), Times(CN1, a, b, BSymbol), Times(Sqr(a), C)), C0))));
            IIntegrate(4073, Int(Times(Power(Plus(a_DEFAULT, Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT)), m_DEFAULT), Plus(A_DEFAULT, Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Plus(c_DEFAULT, Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT)), n_DEFAULT)), x_Symbol),
                    Condition(Negate(Dist(Times(C, Power(b, CN2)), Int(Times(Power(Plus(a, Times(b, Csc(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Plus(c, Times(d, Csc(Plus(e, Times(f, x))))), n), Subtract(a, Times(b, Csc(Plus(e, Times(f, x)))))), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, C, m, n), x), EqQ(Plus(Times(ASymbol, Sqr(b)), Times(Sqr(a), C)), C0))));
            IIntegrate(4074, Int(Times(Plus(A_DEFAULT, Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), B_DEFAULT), Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), n_), Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_)), x_Symbol),
                    Condition(Plus(Simp(Times(ASymbol, a, Cot(Plus(e, Times(f, x))), Power(Times(d, Csc(Plus(e, Times(f, x)))), n), Power(Times(f, n), CN1)), x), Dist(Power(Times(d, n), CN1), Int(Times(Power(Times(d, Csc(Plus(e, Times(f, x)))), Plus(n, C1)), Simp(Plus(Times(n, Plus(Times(BSymbol, a), Times(ASymbol, b))), Times(Plus(Times(n, Plus(Times(a, C), Times(BSymbol, b))), Times(ASymbol, a, Plus(n, C1))), Csc(Plus(e, Times(f, x)))), Times(b, C, n, Sqr(Csc(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, d, e, f, ASymbol, BSymbol, C), x), LtQ(n, CN1))));
            IIntegrate(4075, Int(Times(Plus(A_DEFAULT, Times(Sqr($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), C_DEFAULT)), Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), n_), Plus(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), b_DEFAULT), a_)), x_Symbol),
                    Condition(Plus(Simp(Times(ASymbol, a, Cot(Plus(e, Times(f, x))), Power(Times(d, Csc(Plus(e, Times(f, x)))), n), Power(Times(f, n), CN1)), x), Dist(Power(Times(d, n), CN1), Int(Times(Power(Times(d, Csc(Plus(e, Times(f, x)))), Plus(n, C1)), Simp(Plus(Times(ASymbol, b, n), Times(a, Plus(Times(C, n), Times(ASymbol, Plus(n, C1))), Csc(Plus(e, Times(f, x)))), Times(b, C, n, Sqr(Csc(Plus(e, Times(f, x)))))), x)), x), x)), And(FreeQ(List(a, b, d, e, f, ASymbol, C), x), LtQ(n, CN1))));
        }
    }
}
