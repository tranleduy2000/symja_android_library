package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcCos;
import static org.matheclipse.core.expression.F.ArcCsc;
import static org.matheclipse.core.expression.F.ArcSec;
import static org.matheclipse.core.expression.F.ArcSin;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cosh;
import static org.matheclipse.core.expression.F.Cot;
import static org.matheclipse.core.expression.F.Csc;
import static org.matheclipse.core.expression.F.D;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.MatchQ;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.ReplaceAll;
import static org.matheclipse.core.expression.F.Rule;
import static org.matheclipse.core.expression.F.Sec;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sinh;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Tan;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.a;
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
import static org.matheclipse.core.expression.F.f_;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.u_DEFAULT;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.w;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfExponentialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntHide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InverseFunctionFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearMatchQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules210 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(5251, Int(ArcCsc(Plus(c_, Times(d_DEFAULT, x_))), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(c, Times(d, x)), ArcCsc(Plus(c, Times(d, x))), Power(d, CN1)), x), Int(Power(Times(Plus(c, Times(d, x)), Sqrt(Subtract(C1, Power(Plus(c, Times(d, x)), CN2)))), CN1), x)), FreeQ(List(c, d), x)));
            IIntegrate(5252, Int(Power(Plus(a_DEFAULT, Times(ArcSec(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Power(d, CN1), Subst(Int(Power(Plus(a, Times(b, ArcSec(x))), p), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d), x), IGtQ(p, C0))));
            IIntegrate(5253, Int(Power(Plus(a_DEFAULT, Times(ArcCsc(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Power(d, CN1), Subst(Int(Power(Plus(a, Times(b, ArcCsc(x))), p), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d), x), IGtQ(p, C0))));
            IIntegrate(5254, Int(Power(Plus(a_DEFAULT, Times(ArcSec(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_), x_Symbol),
                    Condition(Unintegrable(Power(Plus(a, Times(b, ArcSec(Plus(c, Times(d, x))))), p), x), And(FreeQ(List(a, b, c, d, p), x), Not(IGtQ(p, C0)))));
            IIntegrate(5255, Int(Power(Plus(a_DEFAULT, Times(ArcCsc(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_), x_Symbol),
                    Condition(Unintegrable(Power(Plus(a, Times(b, ArcCsc(Plus(c, Times(d, x))))), p), x), And(FreeQ(List(a, b, c, d, p), x), Not(IGtQ(p, C0)))));
            IIntegrate(5256, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSec(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, CN1), Subst(Int(Times(Power(Times(f, x, Power(d, CN1)), m), Power(Plus(a, Times(b, ArcSec(x))), p)), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d, e, f, m), x), EqQ(Subtract(Times(d, e), Times(c, f)), C0), IGtQ(p, C0))));
            IIntegrate(5257, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCsc(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, CN1), Subst(Int(Times(Power(Times(f, x, Power(d, CN1)), m), Power(Plus(a, Times(b, ArcCsc(x))), p)), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d, e, f, m), x), EqQ(Subtract(Times(d, e), Times(c, f)), C0), IGtQ(p, C0))));
            IIntegrate(5258, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSec(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Power(d, Plus(m, C1)), CN1), Subst(Int(Times(Power(Plus(a, Times(b, x)), p), Sec(x), Tan(x), Power(Plus(Times(d, e), Times(CN1, c, f), Times(f, Sec(x))), m)), x), x, ArcSec(Plus(c, Times(d, x)))), x), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(p, C0), IntegerQ(m))));
            IIntegrate(5259, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCsc(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Negate(Dist(Power(Power(d, Plus(m, C1)), CN1), Subst(Int(Times(Power(Plus(a, Times(b, x)), p), Csc(x), Cot(x), Power(Plus(Times(d, e), Times(CN1, c, f), Times(f, Csc(x))), m)), x), x, ArcCsc(Plus(c, Times(d, x)))), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(p, C0), IntegerQ(m))));
            IIntegrate(5260, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSec(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, CN1), Subst(Int(Times(Power(Plus(Times(Subtract(Times(d, e), Times(c, f)), Power(d, CN1)), Times(f, x, Power(d, CN1))), m), Power(Plus(a, Times(b, ArcSec(x))), p)), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d, e, f, m), x), IGtQ(p, C0))));
            IIntegrate(5261, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCsc(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, CN1), Subst(Int(Times(Power(Plus(Times(Subtract(Times(d, e), Times(c, f)), Power(d, CN1)), Times(f, x, Power(d, CN1))), m), Power(Plus(a, Times(b, ArcCsc(x))), p)), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d, e, f, m), x), IGtQ(p, C0))));
            IIntegrate(5262, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSec(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(e, Times(f, x)), m), Power(Plus(a, Times(b, ArcSec(Plus(c, Times(d, x))))), p)), x), And(FreeQ(List(a, b, c, d, e, f, m, p), x), Not(IGtQ(p, C0)))));
            IIntegrate(5263, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCsc(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(e, Times(f, x)), m), Power(Plus(a, Times(b, ArcCsc(Plus(c, Times(d, x))))), p)), x), And(FreeQ(List(a, b, c, d, e, f, m, p), x), Not(IGtQ(p, C0)))));
            IIntegrate(5264, Int(Times(Power(ArcSec(Times(c_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT))), CN1))), m_DEFAULT), u_DEFAULT), x_Symbol),
                    Condition(Int(Times(u, Power(ArcCos(Plus(Times(a, Power(c, CN1)), Times(b, Power(x, n), Power(c, CN1)))), m)), x), FreeQ(List(a, b, c, n, m), x)));
            IIntegrate(5265, Int(Times(Power(ArcCsc(Times(c_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT))), CN1))), m_DEFAULT), u_DEFAULT), x_Symbol),
                    Condition(Int(Times(u, Power(ArcSin(Plus(Times(a, Power(c, CN1)), Times(b, Power(x, n), Power(c, CN1)))), m)), x), FreeQ(List(a, b, c, n, m), x)));
            IIntegrate(5266, Int(Times(u_DEFAULT, Power(f_, Times(Power(ArcSec(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT), c_DEFAULT))), x_Symbol),
                    Condition(Dist(Power(b, CN1), Subst(Int(Times(ReplaceAll(u, Rule(x, Plus(Times(CN1, a, Power(b, CN1)), Times(Sec(x), Power(b, CN1))))), Power(f, Times(c, Power(x, n))), Sec(x), Tan(x)), x), x, ArcSec(Plus(a, Times(b, x)))), x), And(FreeQ(List(a, b, c, f), x), IGtQ(n, C0))));
            IIntegrate(5267, Int(Times(u_DEFAULT, Power(f_, Times(Power(ArcCsc(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT), c_DEFAULT))), x_Symbol),
                    Condition(Negate(Dist(Power(b, CN1), Subst(Int(Times(ReplaceAll(u, Rule(x, Plus(Times(CN1, a, Power(b, CN1)), Times(Csc(x), Power(b, CN1))))), Power(f, Times(c, Power(x, n))), Csc(x), Cot(x)), x), x, ArcCsc(Plus(a, Times(b, x)))), x)), And(FreeQ(List(a, b, c, f), x), IGtQ(n, C0))));
            IIntegrate(5268, Int(ArcSec(u_), x_Symbol),
                    Condition(Subtract(Simp(Times(x, ArcSec(u)), x), Dist(Times(u, Power(Sqr(u), CN1D2)), Int(SimplifyIntegrand(Times(x, D(u, x), Power(Times(u, Sqrt(Subtract(Sqr(u), C1))), CN1)), x), x), x)), And(InverseFunctionFreeQ(u, x), Not(FunctionOfExponentialQ(u, x)))));
            IIntegrate(5269, Int(ArcCsc(u_), x_Symbol),
                    Condition(Plus(Simp(Times(x, ArcCsc(u)), x), Dist(Times(u, Power(Sqr(u), CN1D2)), Int(SimplifyIntegrand(Times(x, D(u, x), Power(Times(u, Sqrt(Subtract(Sqr(u), C1))), CN1)), x), x), x)), And(InverseFunctionFreeQ(u, x), Not(FunctionOfExponentialQ(u, x)))));
            IIntegrate(5270, Int(Times(Plus(a_DEFAULT, Times(ArcSec(u_), b_DEFAULT)), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), Plus(a, Times(b, ArcSec(u))), Power(Times(d, Plus(m, C1)), CN1)), x), Dist(Times(b, u, Power(Times(d, Plus(m, C1), Sqrt(Sqr(u))), CN1)), Int(SimplifyIntegrand(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), D(u, x), Power(Times(u, Sqrt(Subtract(Sqr(u), C1))), CN1)), x), x), x)), And(FreeQ(List(a, b, c, d, m), x), NeQ(m, CN1), InverseFunctionFreeQ(u, x), Not(FunctionOfQ(Power(Plus(c, Times(d, x)), Plus(m, C1)), u, x)), Not(FunctionOfExponentialQ(u, x)))));
            IIntegrate(5271, Int(Times(Plus(a_DEFAULT, Times(ArcCsc(u_), b_DEFAULT)), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), Plus(a, Times(b, ArcCsc(u))), Power(Times(d, Plus(m, C1)), CN1)), x), Dist(Times(b, u, Power(Times(d, Plus(m, C1), Sqrt(Sqr(u))), CN1)), Int(SimplifyIntegrand(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), D(u, x), Power(Times(u, Sqrt(Subtract(Sqr(u), C1))), CN1)), x), x), x)), And(FreeQ(List(a, b, c, d, m), x), NeQ(m, CN1), InverseFunctionFreeQ(u, x), Not(FunctionOfQ(Power(Plus(c, Times(d, x)), Plus(m, C1)), u, x)), Not(FunctionOfExponentialQ(u, x)))));
            IIntegrate(5272, Int(Times(Plus(a_DEFAULT, Times(ArcSec(u_), b_DEFAULT)), v_), x_Symbol),
                    Condition(With(List(Set(w, IntHide(v, x))), Condition(Subtract(Dist(Plus(a, Times(b, ArcSec(u))), w, x), Dist(Times(b, u, Power(Sqr(u), CN1D2)), Int(SimplifyIntegrand(Times(w, D(u, x), Power(Times(u, Sqrt(Subtract(Sqr(u), C1))), CN1)), x), x), x)), InverseFunctionFreeQ(w, x))), And(FreeQ(List(a, b), x), InverseFunctionFreeQ(u, x), Not(MatchQ(v, Condition(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x)), m_DEFAULT), FreeQ(List(c, d, m), x)))))));
            IIntegrate(5273, Int(Times(Plus(a_DEFAULT, Times(ArcCsc(u_), b_DEFAULT)), v_), x_Symbol),
                    Condition(With(List(Set(w, IntHide(v, x))), Condition(Plus(Dist(Plus(a, Times(b, ArcCsc(u))), w, x), Dist(Times(b, u, Power(Sqr(u), CN1D2)), Int(SimplifyIntegrand(Times(w, D(u, x), Power(Times(u, Sqrt(Subtract(Sqr(u), C1))), CN1)), x), x), x)), InverseFunctionFreeQ(w, x))), And(FreeQ(List(a, b), x), InverseFunctionFreeQ(u, x), Not(MatchQ(v, Condition(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x)), m_DEFAULT), FreeQ(List(c, d, m), x)))))));
            IIntegrate(5274, Int(Times(Power(u_, m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sinh(v_))), n_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(ExpandToSum(u, x), m), Power(Plus(a, Times(b, Sinh(ExpandToSum(v, x)))), n)), x), And(FreeQ(List(a, b, m, n), x), LinearQ(List(u, v), x), Not(LinearMatchQ(List(u, v), x)))));
            IIntegrate(5275, Int(Times(Power(Plus(a_DEFAULT, Times(Cosh(v_), b_DEFAULT)), n_DEFAULT), Power(u_, m_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(ExpandToSum(u, x), m), Power(Plus(a, Times(b, Cosh(ExpandToSum(v, x)))), n)), x), And(FreeQ(List(a, b, m, n), x), LinearQ(List(u, v), x), Not(LinearMatchQ(List(u, v), x)))));
        }
    }
}
