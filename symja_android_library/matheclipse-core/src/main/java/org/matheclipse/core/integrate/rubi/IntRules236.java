package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcCosh;
import static org.matheclipse.core.expression.F.ArcCoth;
import static org.matheclipse.core.expression.F.ArcSinh;
import static org.matheclipse.core.expression.F.ArcTanh;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.D;
import static org.matheclipse.core.expression.F.Exp;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.MatchQ;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.PolyLog;
import static org.matheclipse.core.expression.F.PolynomialQ;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_DEFAULT;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfExponentialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntHide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InverseFunctionFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyIntegrand;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules236 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(5901, Int(ArcCosh(u_), x_Symbol),
                    Condition(Subtract(Simp(Times(x, ArcCosh(u)), x), Int(SimplifyIntegrand(Times(x, D(u, x), Power(Times(Sqrt(Plus(CN1, u)), Sqrt(Plus(C1, u))), CN1)), x), x)), And(InverseFunctionFreeQ(u, x), Not(FunctionOfExponentialQ(u, x)))));
            IIntegrate(5902, Int(Times(Plus(a_DEFAULT, Times(ArcSinh(u_), b_DEFAULT)), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), Plus(a, Times(b, ArcSinh(u))), Power(Times(d, Plus(m, C1)), CN1)), x), Dist(Times(b, Power(Times(d, Plus(m, C1)), CN1)), Int(SimplifyIntegrand(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), D(u, x), Power(Plus(C1, Sqr(u)), CN1D2)), x), x), x)), And(FreeQ(List(a, b, c, d, m), x), NeQ(m, CN1), InverseFunctionFreeQ(u, x), Not(FunctionOfQ(Power(Plus(c, Times(d, x)), Plus(m, C1)), u, x)), Not(FunctionOfExponentialQ(u, x)))));
            IIntegrate(5903, Int(Times(Plus(a_DEFAULT, Times(ArcCosh(u_), b_DEFAULT)), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), Plus(a, Times(b, ArcCosh(u))), Power(Times(d, Plus(m, C1)), CN1)), x), Dist(Times(b, Power(Times(d, Plus(m, C1)), CN1)), Int(SimplifyIntegrand(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), D(u, x), Power(Times(Sqrt(Plus(CN1, u)), Sqrt(Plus(C1, u))), CN1)), x), x), x)), And(FreeQ(List(a, b, c, d, m), x), NeQ(m, CN1), InverseFunctionFreeQ(u, x), Not(FunctionOfQ(Power(Plus(c, Times(d, x)), Plus(m, C1)), u, x)), Not(FunctionOfExponentialQ(u, x)))));
            IIntegrate(5904, Int(Times(Plus(a_DEFAULT, Times(ArcSinh(u_), b_DEFAULT)), v_), x_Symbol),
                    Condition(With(List(Set(w, IntHide(v, x))), Condition(Subtract(Dist(Plus(a, Times(b, ArcSinh(u))), w, x), Dist(b, Int(SimplifyIntegrand(Times(w, D(u, x), Power(Plus(C1, Sqr(u)), CN1D2)), x), x), x)), InverseFunctionFreeQ(w, x))), And(FreeQ(List(a, b), x), InverseFunctionFreeQ(u, x), Not(MatchQ(v, Condition(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x)), m_DEFAULT), FreeQ(List(c, d, m), x)))))));
            IIntegrate(5905, Int(Times(Plus(a_DEFAULT, Times(ArcCosh(u_), b_DEFAULT)), v_), x_Symbol),
                    Condition(With(List(Set(w, IntHide(v, x))), Condition(Subtract(Dist(Plus(a, Times(b, ArcCosh(u))), w, x), Dist(b, Int(SimplifyIntegrand(Times(w, D(u, x), Power(Times(Sqrt(Plus(CN1, u)), Sqrt(Plus(C1, u))), CN1)), x), x), x)), InverseFunctionFreeQ(w, x))), And(FreeQ(List(a, b), x), InverseFunctionFreeQ(u, x), Not(MatchQ(v, Condition(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x)), m_DEFAULT), FreeQ(List(c, d, m), x)))))));
            IIntegrate(5906, Int(Exp(Times(ArcSinh(u_), n_DEFAULT)), x_Symbol),
                    Condition(Int(Power(Plus(u, Sqrt(Plus(C1, Sqr(u)))), n), x), And(IntegerQ(n), PolynomialQ(u, x))));
            IIntegrate(5907, Int(Times(Exp(Times(ArcSinh(u_), n_DEFAULT)), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(x, m), Power(Plus(u, Sqrt(Plus(C1, Sqr(u)))), n)), x), And(RationalQ(m), IntegerQ(n), PolynomialQ(u, x))));
            IIntegrate(5908, Int(Exp(Times(ArcCosh(u_), n_DEFAULT)), x_Symbol),
                    Condition(Int(Power(Plus(u, Times(Sqrt(Plus(CN1, u)), Sqrt(Plus(C1, u)))), n), x), And(IntegerQ(n), PolynomialQ(u, x))));
            IIntegrate(5909, Int(Times(Exp(Times(ArcCosh(u_), n_DEFAULT)), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(x, m), Power(Plus(u, Times(Sqrt(Plus(CN1, u)), Sqrt(Plus(C1, u)))), n)), x), And(RationalQ(m), IntegerQ(n), PolynomialQ(u, x))));
            IIntegrate(5910, Int(Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Subtract(Simp(Times(x, Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), p)), x), Dist(Times(b, c, p), Int(Times(x, Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), Subtract(p, C1)), Power(Subtract(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c), x), IGtQ(p, C0))));
            IIntegrate(5911, Int(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Subtract(Simp(Times(x, Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p)), x), Dist(Times(b, c, p), Int(Times(x, Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), Subtract(p, C1)), Power(Subtract(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c), x), IGtQ(p, C0))));
            IIntegrate(5912, Int(Times(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), Power(x_, CN1)), x_Symbol),
                    Condition(Plus(Simp(Times(a, Log(x)), x), Negate(Simp(Times(C1D2, b, PolyLog(C2, Times(CN1, c, x))), x)), Simp(Times(C1D2, b, PolyLog(C2, Times(c, x))), x)), FreeQ(List(a, b, c), x)));
            IIntegrate(5913, Int(Times(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), Power(x_, CN1)), x_Symbol),
                    Condition(Plus(Simp(Times(a, Log(x)), x), Simp(Times(C1D2, b, PolyLog(C2, Negate(Power(Times(c, x), CN1)))), x), Negate(Simp(Times(C1D2, b, PolyLog(C2, Power(Times(c, x), CN1))), x))), FreeQ(List(a, b, c), x)));
            IIntegrate(5914, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), p_), Power(x_, CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(C2, Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), p), ArcTanh(Subtract(C1, Times(C2, Power(Subtract(C1, Times(c, x)), CN1))))), x), Dist(Times(C2, b, c, p), Int(Times(Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), Subtract(p, C1)), ArcTanh(Subtract(C1, Times(C2, Power(Subtract(C1, Times(c, x)), CN1)))), Power(Subtract(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c), x), IGtQ(p, C1))));
            IIntegrate(5915, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), p_), Power(x_, CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(C2, Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p), ArcCoth(Subtract(C1, Times(C2, Power(Subtract(C1, Times(c, x)), CN1))))), x), Dist(Times(C2, b, c, p), Int(Times(Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), Subtract(p, C1)), ArcCoth(Subtract(C1, Times(C2, Power(Subtract(C1, Times(c, x)), CN1)))), Power(Subtract(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c), x), IGtQ(p, C1))));
            IIntegrate(5916, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Times(d_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(d, x), Plus(m, C1)), Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), p), Power(Times(d, Plus(m, C1)), CN1)), x), Dist(Times(b, c, p, Power(Times(d, Plus(m, C1)), CN1)), Int(Times(Power(Times(d, x), Plus(m, C1)), Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), Subtract(p, C1)), Power(Subtract(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, m), x), IGtQ(p, C0), Or(EqQ(p, C1), IntegerQ(m)), NeQ(m, CN1))));
            IIntegrate(5917, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Times(d_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(d, x), Plus(m, C1)), Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p), Power(Times(d, Plus(m, C1)), CN1)), x), Dist(Times(b, c, p, Power(Times(d, Plus(m, C1)), CN1)), Int(Times(Power(Times(d, x), Plus(m, C1)), Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), Subtract(p, C1)), Power(Subtract(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, m), x), IGtQ(p, C0), Or(EqQ(p, C1), IntegerQ(m)), NeQ(m, CN1))));
            IIntegrate(5918, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), p), Log(Times(C2, Power(Plus(C1, Times(e, x, Power(d, CN1))), CN1))), Power(e, CN1)), x)), Dist(Times(b, c, p, Power(e, CN1)), Int(Times(Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), Subtract(p, C1)), Log(Times(C2, Power(Plus(C1, Times(e, x, Power(d, CN1))), CN1))), Power(Subtract(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), IGtQ(p, C0), EqQ(Subtract(Times(Sqr(c), Sqr(d)), Sqr(e)), C0))));
            IIntegrate(5919, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), p), Log(Times(C2, Power(Plus(C1, Times(e, x, Power(d, CN1))), CN1))), Power(e, CN1)), x)), Dist(Times(b, c, p, Power(e, CN1)), Int(Times(Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), Subtract(p, C1)), Log(Times(C2, Power(Plus(C1, Times(e, x, Power(d, CN1))), CN1))), Power(Subtract(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), IGtQ(p, C0), EqQ(Subtract(Times(Sqr(c), Sqr(d)), Sqr(e)), C0))));
            IIntegrate(5920, Int(Times(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), Power(Plus(d_, Times(e_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Plus(a, Times(b, ArcTanh(Times(c, x)))), Log(Times(C2, Power(Plus(C1, Times(c, x)), CN1))), Power(e, CN1)), x)), Dist(Times(b, c, Power(e, CN1)), Int(Times(Log(Times(C2, Power(Plus(C1, Times(c, x)), CN1))), Power(Subtract(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x), Negate(Dist(Times(b, c, Power(e, CN1)), Int(Times(Log(Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), e), Plus(C1, Times(c, x))), CN1))), Power(Subtract(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x)), Simp(Times(Plus(a, Times(b, ArcTanh(Times(c, x)))), Log(Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), e), Plus(C1, Times(c, x))), CN1))), Power(e, CN1)), x)), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Times(Sqr(c), Sqr(d)), Sqr(e)), C0))));
            IIntegrate(5921, Int(Times(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), Power(Plus(d_, Times(e_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Plus(a, Times(b, ArcCoth(Times(c, x)))), Log(Times(C2, Power(Plus(C1, Times(c, x)), CN1))), Power(e, CN1)), x)), Dist(Times(b, c, Power(e, CN1)), Int(Times(Log(Times(C2, Power(Plus(C1, Times(c, x)), CN1))), Power(Subtract(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x), Negate(Dist(Times(b, c, Power(e, CN1)), Int(Times(Log(Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), e), Plus(C1, Times(c, x))), CN1))), Power(Subtract(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x)), Simp(Times(Plus(a, Times(b, ArcCoth(Times(c, x)))), Log(Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), e), Plus(C1, Times(c, x))), CN1))), Power(e, CN1)), x)), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Times(Sqr(c), Sqr(d)), Sqr(e)), C0))));
            IIntegrate(5922, Int(Times(Sqr(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT))), Power(Plus(d_, Times(e_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Sqr(Plus(a, Times(b, ArcTanh(Times(c, x))))), Log(Times(C2, Power(Plus(C1, Times(c, x)), CN1))), Power(e, CN1)), x)), Simp(Times(Sqr(Plus(a, Times(b, ArcTanh(Times(c, x))))), Log(Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), e), Plus(C1, Times(c, x))), CN1))), Power(e, CN1)), x), Simp(Times(b, Plus(a, Times(b, ArcTanh(Times(c, x)))), PolyLog(C2, Subtract(C1, Times(C2, Power(Plus(C1, Times(c, x)), CN1)))), Power(e, CN1)), x), Negate(Simp(Times(b, Plus(a, Times(b, ArcTanh(Times(c, x)))), PolyLog(C2, Subtract(C1, Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), e), Plus(C1, Times(c, x))), CN1)))), Power(e, CN1)), x)), Simp(Times(Sqr(b), PolyLog(C3, Subtract(C1, Times(C2, Power(Plus(C1, Times(c, x)), CN1)))), Power(Times(C2, e), CN1)), x), Negate(Simp(Times(Sqr(b), PolyLog(C3, Subtract(C1, Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), e), Plus(C1, Times(c, x))), CN1)))), Power(Times(C2, e), CN1)), x))), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Times(Sqr(c), Sqr(d)), Sqr(e)), C0))));
            IIntegrate(5923, Int(Times(Sqr(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT))), Power(Plus(d_, Times(e_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Sqr(Plus(a, Times(b, ArcCoth(Times(c, x))))), Log(Times(C2, Power(Plus(C1, Times(c, x)), CN1))), Power(e, CN1)), x)), Simp(Times(Sqr(Plus(a, Times(b, ArcCoth(Times(c, x))))), Log(Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), e), Plus(C1, Times(c, x))), CN1))), Power(e, CN1)), x), Simp(Times(b, Plus(a, Times(b, ArcCoth(Times(c, x)))), PolyLog(C2, Subtract(C1, Times(C2, Power(Plus(C1, Times(c, x)), CN1)))), Power(e, CN1)), x), Negate(Simp(Times(b, Plus(a, Times(b, ArcCoth(Times(c, x)))), PolyLog(C2, Subtract(C1, Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), e), Plus(C1, Times(c, x))), CN1)))), Power(e, CN1)), x)), Simp(Times(Sqr(b), PolyLog(C3, Subtract(C1, Times(C2, Power(Plus(C1, Times(c, x)), CN1)))), Power(Times(C2, e), CN1)), x), Negate(Simp(Times(Sqr(b), PolyLog(C3, Subtract(C1, Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), e), Plus(C1, Times(c, x))), CN1)))), Power(Times(C2, e), CN1)), x))), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Times(Sqr(c), Sqr(d)), Sqr(e)), C0))));
            IIntegrate(5924, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTanh(Times(c_DEFAULT, x_)), b_DEFAULT)), C3), Power(Plus(d_, Times(e_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), C3), Log(Times(C2, Power(Plus(C1, Times(c, x)), CN1))), Power(e, CN1)), x)), Simp(Times(Power(Plus(a, Times(b, ArcTanh(Times(c, x)))), C3), Log(Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), e), Plus(C1, Times(c, x))), CN1))), Power(e, CN1)), x), Simp(Times(C3, b, Sqr(Plus(a, Times(b, ArcTanh(Times(c, x))))), PolyLog(C2, Subtract(C1, Times(C2, Power(Plus(C1, Times(c, x)), CN1)))), Power(Times(C2, e), CN1)), x), Negate(Simp(Times(C3, b, Sqr(Plus(a, Times(b, ArcTanh(Times(c, x))))), PolyLog(C2, Subtract(C1, Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), e), Plus(C1, Times(c, x))), CN1)))), Power(Times(C2, e), CN1)), x)), Simp(Times(C3, Sqr(b), Plus(a, Times(b, ArcTanh(Times(c, x)))), PolyLog(C3, Subtract(C1, Times(C2, Power(Plus(C1, Times(c, x)), CN1)))), Power(Times(C2, e), CN1)), x), Negate(Simp(Times(C3, Sqr(b), Plus(a, Times(b, ArcTanh(Times(c, x)))), PolyLog(C3, Subtract(C1, Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), e), Plus(C1, Times(c, x))), CN1)))), Power(Times(C2, e), CN1)), x)), Simp(Times(C3, Power(b, C3), PolyLog(C4, Subtract(C1, Times(C2, Power(Plus(C1, Times(c, x)), CN1)))), Power(Times(C4, e), CN1)), x), Negate(Simp(Times(C3, Power(b, C3), PolyLog(C4, Subtract(C1, Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), e), Plus(C1, Times(c, x))), CN1)))), Power(Times(C4, e), CN1)), x))), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Times(Sqr(c), Sqr(d)), Sqr(e)), C0))));
            IIntegrate(5925, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCoth(Times(c_DEFAULT, x_)), b_DEFAULT)), C3), Power(Plus(d_, Times(e_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), C3), Log(Times(C2, Power(Plus(C1, Times(c, x)), CN1))), Power(e, CN1)), x)), Simp(Times(Power(Plus(a, Times(b, ArcCoth(Times(c, x)))), C3), Log(Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), e), Plus(C1, Times(c, x))), CN1))), Power(e, CN1)), x), Simp(Times(C3, b, Sqr(Plus(a, Times(b, ArcCoth(Times(c, x))))), PolyLog(C2, Subtract(C1, Times(C2, Power(Plus(C1, Times(c, x)), CN1)))), Power(Times(C2, e), CN1)), x), Negate(Simp(Times(C3, b, Sqr(Plus(a, Times(b, ArcCoth(Times(c, x))))), PolyLog(C2, Subtract(C1, Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), e), Plus(C1, Times(c, x))), CN1)))), Power(Times(C2, e), CN1)), x)), Simp(Times(C3, Sqr(b), Plus(a, Times(b, ArcCoth(Times(c, x)))), PolyLog(C3, Subtract(C1, Times(C2, Power(Plus(C1, Times(c, x)), CN1)))), Power(Times(C2, e), CN1)), x), Negate(Simp(Times(C3, Sqr(b), Plus(a, Times(b, ArcCoth(Times(c, x)))), PolyLog(C3, Subtract(C1, Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), e), Plus(C1, Times(c, x))), CN1)))), Power(Times(C2, e), CN1)), x)), Simp(Times(C3, Power(b, C3), PolyLog(C4, Subtract(C1, Times(C2, Power(Plus(C1, Times(c, x)), CN1)))), Power(Times(C4, e), CN1)), x), Negate(Simp(Times(C3, Power(b, C3), PolyLog(C4, Subtract(C1, Times(C2, c, Plus(d, Times(e, x)), Power(Times(Plus(Times(c, d), e), Plus(C1, Times(c, x))), CN1)))), Power(Times(C4, e), CN1)), x))), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Times(Sqr(c), Sqr(d)), Sqr(e)), C0))));
        }
    }
}
