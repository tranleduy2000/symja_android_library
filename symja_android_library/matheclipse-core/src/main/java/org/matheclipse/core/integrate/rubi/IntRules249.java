package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcCoth;
import static org.matheclipse.core.expression.F.ArcTanh;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.Coefficient;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cot;
import static org.matheclipse.core.expression.F.Coth;
import static org.matheclipse.core.expression.F.Csch;
import static org.matheclipse.core.expression.F.D;
import static org.matheclipse.core.expression.F.Discriminant;
import static org.matheclipse.core.expression.F.Exp;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.Head;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.MatchQ;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Part;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sec;
import static org.matheclipse.core.expression.F.Sech;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Tan;
import static org.matheclipse.core.expression.F.Tanh;
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
import static org.matheclipse.core.expression.F.f_;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.r_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.w_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FalseQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InverseFunctionOfLinear;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.QuadraticQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SubstForInverseFunction;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules249 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(6226, Int(Times(Power(ArcCoth(Times(c_DEFAULT, x_, Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sqr(x_))), CN1D2))), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Negate(Simp(Times(Power(ArcCoth(Times(c, x, Power(Plus(a, Times(b, Sqr(x))), CN1D2))), Plus(m, C1)), Power(Times(c, Plus(m, C1)), CN1)), x)), And(FreeQ(List(a, b, c, m), x), EqQ(b, Sqr(c)), NeQ(m, CN1))));
            IIntegrate(6227, Int(Times(Power(ArcTanh(Times(c_DEFAULT, x_, Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sqr(x_))), CN1D2))), m_DEFAULT), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Plus(a, Times(b, Sqr(x)))), Power(Plus(d, Times(e, Sqr(x))), CN1D2)), Int(Times(Power(ArcTanh(Times(c, x, Power(Plus(a, Times(b, Sqr(x))), CN1D2))), m), Power(Plus(a, Times(b, Sqr(x))), CN1D2)), x), x), And(FreeQ(List(a, b, c, d, e, m), x), EqQ(b, Sqr(c)), EqQ(Subtract(Times(b, d), Times(a, e)), C0))));
            IIntegrate(6228, Int(Times(Power(ArcCoth(Times(c_DEFAULT, x_, Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sqr(x_))), CN1D2))), m_DEFAULT), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Plus(a, Times(b, Sqr(x)))), Power(Plus(d, Times(e, Sqr(x))), CN1D2)), Int(Times(Power(ArcCoth(Times(c, x, Power(Plus(a, Times(b, Sqr(x))), CN1D2))), m), Power(Plus(a, Times(b, Sqr(x))), CN1D2)), x), x), And(FreeQ(List(a, b, c, d, e, m), x), EqQ(b, Sqr(c)), EqQ(Subtract(Times(b, d), Times(a, e)), C0))));
            IIntegrate(6229, Int(Times(u_, Power(v_, n_DEFAULT)), x_Symbol),
                    Condition(With(List(Set($s("tmp"), InverseFunctionOfLinear(u, x))), Condition(Dist(Times(Power(Times(CN1, Discriminant(v, x), Power(Times(C4, Coefficient(v, x, C2)), CN1)), n), Power(Coefficient(Part($s("tmp"), C1), x, C1), CN1)), Subst(Int(SimplifyIntegrand(Times(SubstForInverseFunction(u, $s("tmp"), x), Power(Sech(x), Times(C2, Plus(n, C1)))), x), x), x, $s("tmp")), x), And(Not(FalseQ($s("tmp"))), EqQ(Head($s("tmp")), ArcTanh), EqQ(Subtract(Times(Discriminant(v, x), Sqr(Part($s("tmp"), C1))), Sqr(D(v, x))), C0)))), And(QuadraticQ(v, x), ILtQ(n, C0), PosQ(Discriminant(v, x)), MatchQ(u, Condition(Times(r_DEFAULT, Power(f_, w_)), FreeQ(f, x))))));
            IIntegrate(6230, Int(Times(u_, Power(v_, n_DEFAULT)), x_Symbol),
                    Condition(With(List(Set($s("tmp"), InverseFunctionOfLinear(u, x))), Condition(Dist(Times(Power(Times(CN1, Discriminant(v, x), Power(Times(C4, Coefficient(v, x, C2)), CN1)), n), Power(Coefficient(Part($s("tmp"), C1), x, C1), CN1)), Subst(Int(SimplifyIntegrand(Times(SubstForInverseFunction(u, $s("tmp"), x), Power(Negate(Sqr(Csch(x))), Plus(n, C1))), x), x), x, $s("tmp")), x), And(Not(FalseQ($s("tmp"))), EqQ(Head($s("tmp")), ArcCoth), EqQ(Subtract(Times(Discriminant(v, x), Sqr(Part($s("tmp"), C1))), Sqr(D(v, x))), C0)))), And(QuadraticQ(v, x), ILtQ(n, C0), PosQ(Discriminant(v, x)), MatchQ(u, Condition(Times(r_DEFAULT, Power(f_, w_)), FreeQ(f, x))))));
            IIntegrate(6231, Int(ArcTanh(Plus(c_DEFAULT, Times(d_DEFAULT, Tanh(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Simp(Times(x, ArcTanh(Plus(c, Times(d, Tanh(Plus(a, Times(b, x))))))), x), Dist(b, Int(Times(x, Power(Plus(c, Negate(d), Times(c, Exp(Plus(Times(C2, a), Times(C2, b, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Sqr(Subtract(c, d)), C1))));
            IIntegrate(6232, Int(ArcCoth(Plus(c_DEFAULT, Times(d_DEFAULT, Tanh(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Simp(Times(x, ArcCoth(Plus(c, Times(d, Tanh(Plus(a, Times(b, x))))))), x), Dist(b, Int(Times(x, Power(Plus(c, Negate(d), Times(c, Exp(Plus(Times(C2, a), Times(C2, b, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Sqr(Subtract(c, d)), C1))));
            IIntegrate(6233, Int(ArcTanh(Plus(c_DEFAULT, Times(Coth(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), d_DEFAULT))), x_Symbol),
                    Condition(Plus(Simp(Times(x, ArcTanh(Plus(c, Times(d, Coth(Plus(a, Times(b, x))))))), x), Dist(b, Int(Times(x, Power(Subtract(Subtract(c, d), Times(c, Exp(Plus(Times(C2, a), Times(C2, b, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Sqr(Subtract(c, d)), C1))));
            IIntegrate(6234, Int(ArcCoth(Plus(c_DEFAULT, Times(Coth(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), d_DEFAULT))), x_Symbol),
                    Condition(Plus(Simp(Times(x, ArcCoth(Plus(c, Times(d, Coth(Plus(a, Times(b, x))))))), x), Dist(b, Int(Times(x, Power(Subtract(Subtract(c, d), Times(c, Exp(Plus(Times(C2, a), Times(C2, b, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Sqr(Subtract(c, d)), C1))));
            IIntegrate(6235, Int(ArcTanh(Plus(c_DEFAULT, Times(d_DEFAULT, Tanh(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Simp(Times(x, ArcTanh(Plus(c, Times(d, Tanh(Plus(a, Times(b, x))))))), x), Dist(Times(b, Subtract(Subtract(C1, c), d)), Int(Times(x, Exp(Plus(Times(C2, a), Times(C2, b, x))), Power(Plus(C1, Negate(c), d, Times(Subtract(Subtract(C1, c), d), Exp(Plus(Times(C2, a), Times(C2, b, x))))), CN1)), x), x), Negate(Dist(Times(b, Plus(C1, c, d)), Int(Times(x, Exp(Plus(Times(C2, a), Times(C2, b, x))), Power(Plus(C1, c, Negate(d), Times(Plus(C1, c, d), Exp(Plus(Times(C2, a), Times(C2, b, x))))), CN1)), x), x))), And(FreeQ(List(a, b, c, d), x), NeQ(Sqr(Subtract(c, d)), C1))));
            IIntegrate(6236, Int(ArcCoth(Plus(c_DEFAULT, Times(d_DEFAULT, Tanh(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))))), x_Symbol),
                    Condition(Plus(Simp(Times(x, ArcCoth(Plus(c, Times(d, Tanh(Plus(a, Times(b, x))))))), x), Dist(Times(b, Subtract(Subtract(C1, c), d)), Int(Times(x, Exp(Plus(Times(C2, a), Times(C2, b, x))), Power(Plus(C1, Negate(c), d, Times(Subtract(Subtract(C1, c), d), Exp(Plus(Times(C2, a), Times(C2, b, x))))), CN1)), x), x), Negate(Dist(Times(b, Plus(C1, c, d)), Int(Times(x, Exp(Plus(Times(C2, a), Times(C2, b, x))), Power(Plus(C1, c, Negate(d), Times(Plus(C1, c, d), Exp(Plus(Times(C2, a), Times(C2, b, x))))), CN1)), x), x))), And(FreeQ(List(a, b, c, d), x), NeQ(Sqr(Subtract(c, d)), C1))));
            IIntegrate(6237, Int(ArcTanh(Plus(c_DEFAULT, Times(Coth(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), d_DEFAULT))), x_Symbol),
                    Condition(Plus(Simp(Times(x, ArcTanh(Plus(c, Times(d, Coth(Plus(a, Times(b, x))))))), x), Negate(Dist(Times(b, Subtract(Subtract(C1, c), d)), Int(Times(x, Exp(Plus(Times(C2, a), Times(C2, b, x))), Power(Subtract(Plus(C1, Negate(c), d), Times(Subtract(Subtract(C1, c), d), Exp(Plus(Times(C2, a), Times(C2, b, x))))), CN1)), x), x)), Dist(Times(b, Plus(C1, c, d)), Int(Times(x, Exp(Plus(Times(C2, a), Times(C2, b, x))), Power(Subtract(Subtract(Plus(C1, c), d), Times(Plus(C1, c, d), Exp(Plus(Times(C2, a), Times(C2, b, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d), x), NeQ(Sqr(Subtract(c, d)), C1))));
            IIntegrate(6238, Int(ArcCoth(Plus(c_DEFAULT, Times(Coth(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), d_DEFAULT))), x_Symbol),
                    Condition(Plus(Simp(Times(x, ArcCoth(Plus(c, Times(d, Coth(Plus(a, Times(b, x))))))), x), Negate(Dist(Times(b, Subtract(Subtract(C1, c), d)), Int(Times(x, Exp(Plus(Times(C2, a), Times(C2, b, x))), Power(Subtract(Plus(C1, Negate(c), d), Times(Subtract(Subtract(C1, c), d), Exp(Plus(Times(C2, a), Times(C2, b, x))))), CN1)), x), x)), Dist(Times(b, Plus(C1, c, d)), Int(Times(x, Exp(Plus(Times(C2, a), Times(C2, b, x))), Power(Subtract(Subtract(Plus(C1, c), d), Times(Plus(C1, c, d), Exp(Plus(Times(C2, a), Times(C2, b, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d), x), NeQ(Sqr(Subtract(c, d)), C1))));
            IIntegrate(6239, Int(Times(ArcTanh(Plus(c_DEFAULT, Times(d_DEFAULT, Tanh(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), ArcTanh(Plus(c, Times(d, Tanh(Plus(a, Times(b, x)))))), Power(Times(f, Plus(m, C1)), CN1)), x), Dist(Times(b, Power(Times(f, Plus(m, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Power(Plus(c, Negate(d), Times(c, Exp(Plus(Times(C2, a), Times(C2, b, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0), EqQ(Sqr(Subtract(c, d)), C1))));
            IIntegrate(6240, Int(Times(ArcCoth(Plus(c_DEFAULT, Times(d_DEFAULT, Tanh(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), ArcCoth(Plus(c, Times(d, Tanh(Plus(a, Times(b, x)))))), Power(Times(f, Plus(m, C1)), CN1)), x), Dist(Times(b, Power(Times(f, Plus(m, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Power(Plus(c, Negate(d), Times(c, Exp(Plus(Times(C2, a), Times(C2, b, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0), EqQ(Sqr(Subtract(c, d)), C1))));
            IIntegrate(6241, Int(Times(ArcTanh(Plus(c_DEFAULT, Times(Coth(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), d_DEFAULT))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), ArcTanh(Plus(c, Times(d, Coth(Plus(a, Times(b, x)))))), Power(Times(f, Plus(m, C1)), CN1)), x), Dist(Times(b, Power(Times(f, Plus(m, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Power(Subtract(Subtract(c, d), Times(c, Exp(Plus(Times(C2, a), Times(C2, b, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0), EqQ(Sqr(Subtract(c, d)), C1))));
            IIntegrate(6242, Int(Times(ArcCoth(Plus(c_DEFAULT, Times(Coth(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), d_DEFAULT))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), ArcCoth(Plus(c, Times(d, Coth(Plus(a, Times(b, x)))))), Power(Times(f, Plus(m, C1)), CN1)), x), Dist(Times(b, Power(Times(f, Plus(m, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Power(Subtract(Subtract(c, d), Times(c, Exp(Plus(Times(C2, a), Times(C2, b, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0), EqQ(Sqr(Subtract(c, d)), C1))));
            IIntegrate(6243, Int(Times(ArcTanh(Plus(c_DEFAULT, Times(d_DEFAULT, Tanh(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), ArcTanh(Plus(c, Times(d, Tanh(Plus(a, Times(b, x)))))), Power(Times(f, Plus(m, C1)), CN1)), x), Dist(Times(b, Subtract(Subtract(C1, c), d), Power(Times(f, Plus(m, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Exp(Plus(Times(C2, a), Times(C2, b, x))), Power(Plus(C1, Negate(c), d, Times(Subtract(Subtract(C1, c), d), Exp(Plus(Times(C2, a), Times(C2, b, x))))), CN1)), x), x), Negate(Dist(Times(b, Plus(C1, c, d), Power(Times(f, Plus(m, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Exp(Plus(Times(C2, a), Times(C2, b, x))), Power(Plus(C1, c, Negate(d), Times(Plus(C1, c, d), Exp(Plus(Times(C2, a), Times(C2, b, x))))), CN1)), x), x))), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0), NeQ(Sqr(Subtract(c, d)), C1))));
            IIntegrate(6244, Int(Times(ArcCoth(Plus(c_DEFAULT, Times(d_DEFAULT, Tanh(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), ArcCoth(Plus(c, Times(d, Tanh(Plus(a, Times(b, x)))))), Power(Times(f, Plus(m, C1)), CN1)), x), Dist(Times(b, Subtract(Subtract(C1, c), d), Power(Times(f, Plus(m, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Exp(Plus(Times(C2, a), Times(C2, b, x))), Power(Plus(C1, Negate(c), d, Times(Subtract(Subtract(C1, c), d), Exp(Plus(Times(C2, a), Times(C2, b, x))))), CN1)), x), x), Negate(Dist(Times(b, Plus(C1, c, d), Power(Times(f, Plus(m, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Exp(Plus(Times(C2, a), Times(C2, b, x))), Power(Plus(C1, c, Negate(d), Times(Plus(C1, c, d), Exp(Plus(Times(C2, a), Times(C2, b, x))))), CN1)), x), x))), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0), NeQ(Sqr(Subtract(c, d)), C1))));
            IIntegrate(6245, Int(Times(ArcTanh(Plus(c_DEFAULT, Times(Coth(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), d_DEFAULT))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), ArcTanh(Plus(c, Times(d, Coth(Plus(a, Times(b, x)))))), Power(Times(f, Plus(m, C1)), CN1)), x), Negate(Dist(Times(b, Subtract(Subtract(C1, c), d), Power(Times(f, Plus(m, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Exp(Plus(Times(C2, a), Times(C2, b, x))), Power(Subtract(Plus(C1, Negate(c), d), Times(Subtract(Subtract(C1, c), d), Exp(Plus(Times(C2, a), Times(C2, b, x))))), CN1)), x), x)), Dist(Times(b, Plus(C1, c, d), Power(Times(f, Plus(m, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Exp(Plus(Times(C2, a), Times(C2, b, x))), Power(Subtract(Subtract(Plus(C1, c), d), Times(Plus(C1, c, d), Exp(Plus(Times(C2, a), Times(C2, b, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0), NeQ(Sqr(Subtract(c, d)), C1))));
            IIntegrate(6246, Int(Times(ArcCoth(Plus(c_DEFAULT, Times(Coth(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), d_DEFAULT))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), ArcCoth(Plus(c, Times(d, Coth(Plus(a, Times(b, x)))))), Power(Times(f, Plus(m, C1)), CN1)), x), Negate(Dist(Times(b, Subtract(Subtract(C1, c), d), Power(Times(f, Plus(m, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Exp(Plus(Times(C2, a), Times(C2, b, x))), Power(Subtract(Plus(C1, Negate(c), d), Times(Subtract(Subtract(C1, c), d), Exp(Plus(Times(C2, a), Times(C2, b, x))))), CN1)), x), x)), Dist(Times(b, Plus(C1, c, d), Power(Times(f, Plus(m, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Exp(Plus(Times(C2, a), Times(C2, b, x))), Power(Subtract(Subtract(Plus(C1, c), d), Times(Plus(C1, c, d), Exp(Plus(Times(C2, a), Times(C2, b, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(m, C0), NeQ(Sqr(Subtract(c, d)), C1))));
            IIntegrate(6247, Int(ArcTanh(Tan(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), x_Symbol),
                    Condition(Subtract(Simp(Times(x, ArcTanh(Tan(Plus(a, Times(b, x))))), x), Dist(b, Int(Times(x, Sec(Plus(Times(C2, a), Times(C2, b, x)))), x), x)), FreeQ(List(a, b), x)));
            IIntegrate(6248, Int(ArcCoth(Tan(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), x_Symbol),
                    Condition(Subtract(Simp(Times(x, ArcCoth(Tan(Plus(a, Times(b, x))))), x), Dist(b, Int(Times(x, Sec(Plus(Times(C2, a), Times(C2, b, x)))), x), x)), FreeQ(List(a, b), x)));
            IIntegrate(6249, Int(ArcTanh(Cot(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), x_Symbol),
                    Condition(Subtract(Simp(Times(x, ArcTanh(Cot(Plus(a, Times(b, x))))), x), Dist(b, Int(Times(x, Sec(Plus(Times(C2, a), Times(C2, b, x)))), x), x)), FreeQ(List(a, b), x)));
            IIntegrate(6250, Int(ArcCoth(Cot(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), x_Symbol),
                    Condition(Subtract(Simp(Times(x, ArcCoth(Cot(Plus(a, Times(b, x))))), x), Dist(b, Int(Times(x, Sec(Plus(Times(C2, a), Times(C2, b, x)))), x), x)), FreeQ(List(a, b), x)));
        }
    }
}
