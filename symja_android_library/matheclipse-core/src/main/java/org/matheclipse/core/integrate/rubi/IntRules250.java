package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcCoth;
import static org.matheclipse.core.expression.F.ArcTanh;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CI;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cot;
import static org.matheclipse.core.expression.F.D;
import static org.matheclipse.core.expression.F.Exp;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.MatchQ;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sec;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Tan;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.a;
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
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.w;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FalseQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfLinear;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntHide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InverseFunctionFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PowerVariableExpn;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyIntegrand;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules250 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(6251, Int(Times(ArcTanh(Tan(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), ArcTanh(Tan(Plus(a, Times(b, x)))), Power(Times(f, Plus(m, C1)), CN1)), x), Dist(Times(b, Power(Times(f, Plus(m, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Sec(Plus(Times(C2, a), Times(C2, b, x)))), x), x)), And(FreeQ(List(a, b, e, f), x), IGtQ(m, C0))));
            IIntegrate(6252, Int(Times(ArcCoth(Tan(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), ArcCoth(Tan(Plus(a, Times(b, x)))), Power(Times(f, Plus(m, C1)), CN1)), x), Dist(Times(b, Power(Times(f, Plus(m, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Sec(Plus(Times(C2, a), Times(C2, b, x)))), x), x)), And(FreeQ(List(a, b, e, f), x), IGtQ(m, C0))));
            IIntegrate(6253, Int(Times(ArcTanh(Cot(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), ArcTanh(Cot(Plus(a, Times(b, x)))), Power(Times(f, Plus(m, C1)), CN1)), x), Dist(Times(b, Power(Times(f, Plus(m, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Sec(Plus(Times(C2, a), Times(C2, b, x)))), x), x)), And(FreeQ(List(a, b, e, f), x), IGtQ(m, C0))));
            IIntegrate(6254, Int(Times(ArcCoth(Cot(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), ArcCoth(Cot(Plus(a, Times(b, x)))), Power(Times(f, Plus(m, C1)), CN1)), x), Dist(Times(b, Power(Times(f, Plus(m, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Sec(Plus(Times(C2, a), Times(C2, b, x)))), x), x)), And(FreeQ(List(a, b, e, f), x), IGtQ(m, C0))));
            IIntegrate(6255, Int(ArcTanh(Plus(c_DEFAULT, Times(d_DEFAULT, Tan(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Simp(Times(x, ArcTanh(Plus(c, Times(d, Tan(Plus(a, Times(b, x))))))), x), Dist(Times(CI, b), Int(Times(x, Power(Plus(c, Times(CI, d), Times(c, Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Sqr(Plus(c, Times(CI, d))), C1))));
            IIntegrate(6256, Int(ArcCoth(Plus(c_DEFAULT, Times(d_DEFAULT, Tan(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Simp(Times(x, ArcCoth(Plus(c, Times(d, Tan(Plus(a, Times(b, x))))))), x), Dist(Times(CI, b), Int(Times(x, Power(Plus(c, Times(CI, d), Times(c, Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Sqr(Plus(c, Times(CI, d))), C1))));
            IIntegrate(6257, Int(ArcTanh(Plus(c_DEFAULT, Times(Cot(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), d_DEFAULT))), x_Symbol),
                    Condition(Plus(Simp(Times(x, ArcTanh(Plus(c, Times(d, Cot(Plus(a, Times(b, x))))))), x), Dist(Times(CI, b), Int(Times(x, Power(Subtract(Subtract(c, Times(CI, d)), Times(c, Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Sqr(Subtract(c, Times(CI, d))), C1))));
            IIntegrate(6258, Int(ArcCoth(Plus(c_DEFAULT, Times(Cot(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), d_DEFAULT))), x_Symbol),
                    Condition(Plus(Simp(Times(x, ArcCoth(Plus(c, Times(d, Cot(Plus(a, Times(b, x))))))), x), Dist(Times(CI, b), Int(Times(x, Power(Subtract(Subtract(c, Times(CI, d)), Times(c, Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Sqr(Subtract(c, Times(CI, d))), C1))));
            IIntegrate(6259, Int(ArcTanh(Plus(c_DEFAULT, Times(d_DEFAULT, Tan(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Simp(Times(x, ArcTanh(Plus(c, Times(d, Tan(Plus(a, Times(b, x))))))), x), Negate(Dist(Times(CI, b, Subtract(Plus(C1, c), Times(CI, d))), Int(Times(x, Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))), Power(Plus(C1, c, Times(CI, d), Times(Subtract(Plus(C1, c), Times(CI, d)), Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))))), CN1)), x), x)), Dist(Times(CI, b, Plus(C1, Negate(c), Times(CI, d))), Int(Times(x, Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))), Power(Plus(C1, Negate(c), Times(CN1, CI, d), Times(Plus(C1, Negate(c), Times(CI, d)), Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d), x), NeQ(Sqr(Plus(c, Times(CI, d))), C1))));
            IIntegrate(6260, Int(ArcCoth(Plus(c_DEFAULT, Times(d_DEFAULT, Tan(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Simp(Times(x, ArcCoth(Plus(c, Times(d, Tan(Plus(a, Times(b, x))))))), x), Negate(Dist(Times(CI, b, Subtract(Plus(C1, c), Times(CI, d))), Int(Times(x, Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))), Power(Plus(C1, c, Times(CI, d), Times(Subtract(Plus(C1, c), Times(CI, d)), Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))))), CN1)), x), x)), Dist(Times(CI, b, Plus(C1, Negate(c), Times(CI, d))), Int(Times(x, Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))), Power(Plus(C1, Negate(c), Times(CN1, CI, d), Times(Plus(C1, Negate(c), Times(CI, d)), Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d), x), NeQ(Sqr(Plus(c, Times(CI, d))), C1))));
            IIntegrate(6261, Int(ArcTanh(Plus(c_DEFAULT, Times(Cot(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), d_DEFAULT))), x_Symbol),
                    Condition(Plus(Simp(Times(x, ArcTanh(Plus(c, Times(d, Cot(Plus(a, Times(b, x))))))), x), Negate(Dist(Times(CI, b, Subtract(Subtract(C1, c), Times(CI, d))), Int(Times(x, Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))), Power(Subtract(Plus(C1, Negate(c), Times(CI, d)), Times(Subtract(Subtract(C1, c), Times(CI, d)), Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))))), CN1)), x), x)), Dist(Times(CI, b, Plus(C1, c, Times(CI, d))), Int(Times(x, Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))), Power(Subtract(Subtract(Plus(C1, c), Times(CI, d)), Times(Plus(C1, c, Times(CI, d)), Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d), x), NeQ(Sqr(Subtract(c, Times(CI, d))), C1))));
            IIntegrate(6262, Int(ArcCoth(Plus(c_DEFAULT, Times(Cot(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), d_DEFAULT))), x_Symbol),
                    Condition(Plus(Simp(Times(x, ArcCoth(Plus(c, Times(d, Cot(Plus(a, Times(b, x))))))), x), Negate(Dist(Times(CI, b, Subtract(Subtract(C1, c), Times(CI, d))), Int(Times(x, Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))), Power(Subtract(Plus(C1, Negate(c), Times(CI, d)), Times(Subtract(Subtract(C1, c), Times(CI, d)), Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))))), CN1)), x), x)), Dist(Times(CI, b, Plus(C1, c, Times(CI, d))), Int(Times(x, Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))), Power(Subtract(Subtract(Plus(C1, c), Times(CI, d)), Times(Plus(C1, c, Times(CI, d)), Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d), x), NeQ(Sqr(Subtract(c, Times(CI, d))), C1))));
            IIntegrate(6263, Int(Times(ArcTanh(Plus(c_DEFAULT, Times(d_DEFAULT, Tan(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), ArcTanh(Plus(c, Times(d, Tan(Plus(a, Times(b, x)))))), Power(Times(f, Plus(m, C1)), CN1)), x), Dist(Times(CI, b, Power(Times(f, Plus(m, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Power(Plus(c, Times(CI, d), Times(c, Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0), EqQ(Sqr(Plus(c, Times(CI, d))), C1))));
            IIntegrate(6264, Int(Times(ArcCoth(Plus(c_DEFAULT, Times(d_DEFAULT, Tan(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), ArcCoth(Plus(c, Times(d, Tan(Plus(a, Times(b, x)))))), Power(Times(f, Plus(m, C1)), CN1)), x), Dist(Times(CI, b, Power(Times(f, Plus(m, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Power(Plus(c, Times(CI, d), Times(c, Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0), EqQ(Sqr(Plus(c, Times(CI, d))), C1))));
            IIntegrate(6265, Int(Times(ArcTanh(Plus(c_DEFAULT, Times(Cot(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), d_DEFAULT))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), ArcTanh(Plus(c, Times(d, Cot(Plus(a, Times(b, x)))))), Power(Times(f, Plus(m, C1)), CN1)), x), Dist(Times(CI, b, Power(Times(f, Plus(m, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Power(Subtract(Subtract(c, Times(CI, d)), Times(c, Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0), EqQ(Sqr(Subtract(c, Times(CI, d))), C1))));
            IIntegrate(6266, Int(Times(ArcCoth(Plus(c_DEFAULT, Times(Cot(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), d_DEFAULT))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), ArcCoth(Plus(c, Times(d, Cot(Plus(a, Times(b, x)))))), Power(Times(f, Plus(m, C1)), CN1)), x), Dist(Times(CI, b, Power(Times(f, Plus(m, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Power(Subtract(Subtract(c, Times(CI, d)), Times(c, Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0), EqQ(Sqr(Subtract(c, Times(CI, d))), C1))));
            IIntegrate(6267, Int(Times(ArcTanh(Plus(c_DEFAULT, Times(d_DEFAULT, Tan(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), ArcTanh(Plus(c, Times(d, Tan(Plus(a, Times(b, x)))))), Power(Times(f, Plus(m, C1)), CN1)), x), Negate(Dist(Times(CI, b, Subtract(Plus(C1, c), Times(CI, d)), Power(Times(f, Plus(m, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))), Power(Plus(C1, c, Times(CI, d), Times(Subtract(Plus(C1, c), Times(CI, d)), Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))))), CN1)), x), x)), Dist(Times(CI, b, Plus(C1, Negate(c), Times(CI, d)), Power(Times(f, Plus(m, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))), Power(Plus(C1, Negate(c), Times(CN1, CI, d), Times(Plus(C1, Negate(c), Times(CI, d)), Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0), NeQ(Sqr(Plus(c, Times(CI, d))), C1))));
            IIntegrate(6268, Int(Times(ArcCoth(Plus(c_DEFAULT, Times(d_DEFAULT, Tan(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), ArcCoth(Plus(c, Times(d, Tan(Plus(a, Times(b, x)))))), Power(Times(f, Plus(m, C1)), CN1)), x), Negate(Dist(Times(CI, b, Subtract(Plus(C1, c), Times(CI, d)), Power(Times(f, Plus(m, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))), Power(Plus(C1, c, Times(CI, d), Times(Subtract(Plus(C1, c), Times(CI, d)), Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))))), CN1)), x), x)), Dist(Times(CI, b, Plus(C1, Negate(c), Times(CI, d)), Power(Times(f, Plus(m, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))), Power(Plus(C1, Negate(c), Times(CN1, CI, d), Times(Plus(C1, Negate(c), Times(CI, d)), Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0), NeQ(Sqr(Plus(c, Times(CI, d))), C1))));
            IIntegrate(6269, Int(Times(ArcTanh(Plus(c_DEFAULT, Times(Cot(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), d_DEFAULT))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), ArcTanh(Plus(c, Times(d, Cot(Plus(a, Times(b, x)))))), Power(Times(f, Plus(m, C1)), CN1)), x), Negate(Dist(Times(CI, b, Subtract(Subtract(C1, c), Times(CI, d)), Power(Times(f, Plus(m, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))), Power(Subtract(Plus(C1, Negate(c), Times(CI, d)), Times(Subtract(Subtract(C1, c), Times(CI, d)), Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))))), CN1)), x), x)), Dist(Times(CI, b, Plus(C1, c, Times(CI, d)), Power(Times(f, Plus(m, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))), Power(Subtract(Subtract(Plus(C1, c), Times(CI, d)), Times(Plus(C1, c, Times(CI, d)), Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0), NeQ(Sqr(Subtract(c, Times(CI, d))), C1))));
            IIntegrate(6270, Int(Times(ArcCoth(Plus(c_DEFAULT, Times(Cot(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), d_DEFAULT))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), ArcCoth(Plus(c, Times(d, Cot(Plus(a, Times(b, x)))))), Power(Times(f, Plus(m, C1)), CN1)), x), Negate(Dist(Times(CI, b, Subtract(Subtract(C1, c), Times(CI, d)), Power(Times(f, Plus(m, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))), Power(Subtract(Plus(C1, Negate(c), Times(CI, d)), Times(Subtract(Subtract(C1, c), Times(CI, d)), Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))))), CN1)), x), x)), Dist(Times(CI, b, Plus(C1, c, Times(CI, d)), Power(Times(f, Plus(m, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))), Power(Subtract(Subtract(Plus(C1, c), Times(CI, d)), Times(Plus(C1, c, Times(CI, d)), Exp(Plus(Times(C2, CI, a), Times(C2, CI, b, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0), NeQ(Sqr(Subtract(c, Times(CI, d))), C1))));
            IIntegrate(6271, Int(ArcTanh(u_), x_Symbol),
                    Condition(Subtract(Simp(Times(x, ArcTanh(u)), x), Int(SimplifyIntegrand(Times(x, D(u, x), Power(Subtract(C1, Sqr(u)), CN1)), x), x)), InverseFunctionFreeQ(u, x)));
            IIntegrate(6272, Int(ArcCoth(u_), x_Symbol),
                    Condition(Subtract(Simp(Times(x, ArcCoth(u)), x), Int(SimplifyIntegrand(Times(x, D(u, x), Power(Subtract(C1, Sqr(u)), CN1)), x), x)), InverseFunctionFreeQ(u, x)));
            IIntegrate(6273, Int(Times(Plus(a_DEFAULT, Times(ArcTanh(u_), b_DEFAULT)), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), Plus(a, Times(b, ArcTanh(u))), Power(Times(d, Plus(m, C1)), CN1)), x), Dist(Times(b, Power(Times(d, Plus(m, C1)), CN1)), Int(SimplifyIntegrand(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), D(u, x), Power(Subtract(C1, Sqr(u)), CN1)), x), x), x)), And(FreeQ(List(a, b, c, d, m), x), NeQ(m, CN1), InverseFunctionFreeQ(u, x), Not(FunctionOfQ(Power(Plus(c, Times(d, x)), Plus(m, C1)), u, x)), FalseQ(PowerVariableExpn(u, Plus(m, C1), x)))));
            IIntegrate(6274, Int(Times(Plus(a_DEFAULT, Times(ArcCoth(u_), b_DEFAULT)), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), Plus(a, Times(b, ArcCoth(u))), Power(Times(d, Plus(m, C1)), CN1)), x), Dist(Times(b, Power(Times(d, Plus(m, C1)), CN1)), Int(SimplifyIntegrand(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), D(u, x), Power(Subtract(C1, Sqr(u)), CN1)), x), x), x)), And(FreeQ(List(a, b, c, d, m), x), NeQ(m, CN1), InverseFunctionFreeQ(u, x), Not(FunctionOfQ(Power(Plus(c, Times(d, x)), Plus(m, C1)), u, x)), FalseQ(PowerVariableExpn(u, Plus(m, C1), x)))));
            IIntegrate(6275, Int(Times(Plus(a_DEFAULT, Times(ArcTanh(u_), b_DEFAULT)), v_), x_Symbol),
                    Condition(With(List(Set(w, IntHide(v, x))), Condition(Subtract(Dist(Plus(a, Times(b, ArcTanh(u))), w, x), Dist(b, Int(SimplifyIntegrand(Times(w, D(u, x), Power(Subtract(C1, Sqr(u)), CN1)), x), x), x)), InverseFunctionFreeQ(w, x))), And(FreeQ(List(a, b), x), InverseFunctionFreeQ(u, x), Not(MatchQ(v, Condition(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x)), m_DEFAULT), FreeQ(List(c, d, m), x)))), FalseQ(FunctionOfLinear(Times(v, Plus(a, Times(b, ArcTanh(u)))), x)))));
        }
    }
}
