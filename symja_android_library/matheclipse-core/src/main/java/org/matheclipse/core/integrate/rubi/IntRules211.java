package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cosh;
import static org.matheclipse.core.expression.F.Exp;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sinh;
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
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandTrigReduce;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules211 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(5276, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Sinh(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Int(ExpandIntegrand(Sinh(Plus(c, Times(d, x))), Power(Plus(a, Times(b, Power(x, n))), p), x), x), And(FreeQ(List(a, b, c, d, n), x), IGtQ(p, C0))));
            IIntegrate(5277, Int(Times(Cosh(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Cosh(Plus(c, Times(d, x))), Power(Plus(a, Times(b, Power(x, n))), p), x), x), And(FreeQ(List(a, b, c, d, n), x), IGtQ(p, C0))));
            IIntegrate(5278, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Sinh(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, Plus(Negate(n), C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Sinh(Plus(c, Times(d, x))), Power(Times(b, n, Plus(p, C1)), CN1)), x), Negate(Dist(Times(Plus(Negate(n), C1), Power(Times(b, n, Plus(p, C1)), CN1)), Int(Times(Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Sinh(Plus(c, Times(d, x))), Power(Power(x, n), CN1)), x), x)), Negate(Dist(Times(d, Power(Times(b, n, Plus(p, C1)), CN1)), Int(Times(Power(x, Plus(Negate(n), C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Cosh(Plus(c, Times(d, x)))), x), x))), And(FreeQ(List(a, b, c, d), x), IntegerQ(p), IGtQ(n, C0), LtQ(p, CN1), GtQ(n, C2))));
            IIntegrate(5279, Int(Times(Cosh(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, Plus(Negate(n), C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Cosh(Plus(c, Times(d, x))), Power(Times(b, n, Plus(p, C1)), CN1)), x), Negate(Dist(Times(Plus(Negate(n), C1), Power(Times(b, n, Plus(p, C1)), CN1)), Int(Times(Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Cosh(Plus(c, Times(d, x))), Power(Power(x, n), CN1)), x), x)), Negate(Dist(Times(d, Power(Times(b, n, Plus(p, C1)), CN1)), Int(Times(Power(x, Plus(Negate(n), C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Sinh(Plus(c, Times(d, x)))), x), x))), And(FreeQ(List(a, b, c, d), x), IntegerQ(p), IGtQ(n, C0), LtQ(p, CN1), GtQ(n, C2))));
            IIntegrate(5280, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Sinh(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Int(ExpandIntegrand(Sinh(Plus(c, Times(d, x))), Power(Plus(a, Times(b, Power(x, n))), p), x), x), And(FreeQ(List(a, b, c, d), x), ILtQ(p, C0), IGtQ(n, C0), Or(EqQ(n, C2), EqQ(p, CN1)))));
            IIntegrate(5281, Int(Times(Cosh(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Cosh(Plus(c, Times(d, x))), Power(Plus(a, Times(b, Power(x, n))), p), x), x), And(FreeQ(List(a, b, c, d), x), ILtQ(p, C0), IGtQ(n, C0), Or(EqQ(n, C2), EqQ(p, CN1)))));
            IIntegrate(5282, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Sinh(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Int(Times(Power(x, Times(n, p)), Power(Plus(b, Times(a, Power(Power(x, n), CN1))), p), Sinh(Plus(c, Times(d, x)))), x), And(FreeQ(List(a, b, c, d), x), ILtQ(p, C0), ILtQ(n, C0))));
            IIntegrate(5283, Int(Times(Cosh(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Int(Times(Power(x, Times(n, p)), Power(Plus(b, Times(a, Power(Power(x, n), CN1))), p), Cosh(Plus(c, Times(d, x)))), x), And(FreeQ(List(a, b, c, d), x), ILtQ(p, C0), ILtQ(n, C0))));
            IIntegrate(5284, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Sinh(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(a, Times(b, Power(x, n))), p), Sinh(Plus(c, Times(d, x)))), x), FreeQ(List(a, b, c, d, n, p), x)));
            IIntegrate(5285, Int(Times(Cosh(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(a, Times(b, Power(x, n))), p), Cosh(Plus(c, Times(d, x)))), x), FreeQ(List(a, b, c, d, n, p), x)));
            IIntegrate(5286, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Sinh(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Int(ExpandIntegrand(Sinh(Plus(c, Times(d, x))), Times(Power(Times(e, x), m), Power(Plus(a, Times(b, Power(x, n))), p)), x), x), And(FreeQ(List(a, b, c, d, e, m, n), x), IGtQ(p, C0))));
            IIntegrate(5287, Int(Times(Cosh(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Cosh(Plus(c, Times(d, x))), Times(Power(Times(e, x), m), Power(Plus(a, Times(b, Power(x, n))), p)), x), x), And(FreeQ(List(a, b, c, d, e, m, n), x), IGtQ(p, C0))));
            IIntegrate(5288, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Sinh(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(e, m), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Sinh(Plus(c, Times(d, x))), Power(Times(b, n, Plus(p, C1)), CN1)), x), Dist(Times(d, Power(e, m), Power(Times(b, n, Plus(p, C1)), CN1)), Int(Times(Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Cosh(Plus(c, Times(d, x)))), x), x)), And(FreeQ(List(a, b, c, d, e, m, n), x), IntegerQ(p), EqQ(Plus(m, Negate(n), C1), C0), LtQ(p, CN1), Or(IntegerQ(n), GtQ(e, C0)))));
            IIntegrate(5289, Int(Times(Cosh(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(e, m), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Cosh(Plus(c, Times(d, x))), Power(Times(b, n, Plus(p, C1)), CN1)), x), Dist(Times(d, Power(e, m), Power(Times(b, n, Plus(p, C1)), CN1)), Int(Times(Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Sinh(Plus(c, Times(d, x)))), x), x)), And(FreeQ(List(a, b, c, d, e, m, n), x), IntegerQ(p), EqQ(Plus(m, Negate(n), C1), C0), LtQ(p, CN1), Or(IntegerQ(n), GtQ(e, C0)))));
            IIntegrate(5290, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Sinh(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, Plus(m, Negate(n), C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Sinh(Plus(c, Times(d, x))), Power(Times(b, n, Plus(p, C1)), CN1)), x), Negate(Dist(Times(Plus(m, Negate(n), C1), Power(Times(b, n, Plus(p, C1)), CN1)), Int(Times(Power(x, Subtract(m, n)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Sinh(Plus(c, Times(d, x)))), x), x)), Negate(Dist(Times(d, Power(Times(b, n, Plus(p, C1)), CN1)), Int(Times(Power(x, Plus(m, Negate(n), C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Cosh(Plus(c, Times(d, x)))), x), x))), And(FreeQ(List(a, b, c, d), x), ILtQ(p, CN1), IGtQ(n, C0), RationalQ(m), Or(GtQ(Plus(m, Negate(n), C1), C0), GtQ(n, C2)))));
            IIntegrate(5291, Int(Times(Cosh(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, Plus(m, Negate(n), C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Cosh(Plus(c, Times(d, x))), Power(Times(b, n, Plus(p, C1)), CN1)), x), Negate(Dist(Times(Plus(m, Negate(n), C1), Power(Times(b, n, Plus(p, C1)), CN1)), Int(Times(Power(x, Subtract(m, n)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Cosh(Plus(c, Times(d, x)))), x), x)), Negate(Dist(Times(d, Power(Times(b, n, Plus(p, C1)), CN1)), Int(Times(Power(x, Plus(m, Negate(n), C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Sinh(Plus(c, Times(d, x)))), x), x))), And(FreeQ(List(a, b, c, d), x), ILtQ(p, CN1), IGtQ(n, C0), RationalQ(m), Or(GtQ(Plus(m, Negate(n), C1), C0), GtQ(n, C2)))));
            IIntegrate(5292, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Sinh(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Int(ExpandIntegrand(Sinh(Plus(c, Times(d, x))), Times(Power(x, m), Power(Plus(a, Times(b, Power(x, n))), p)), x), x), And(FreeQ(List(a, b, c, d), x), ILtQ(p, C0), IntegerQ(m), IGtQ(n, C0), Or(EqQ(n, C2), EqQ(p, CN1)))));
            IIntegrate(5293, Int(Times(Cosh(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Cosh(Plus(c, Times(d, x))), Times(Power(x, m), Power(Plus(a, Times(b, Power(x, n))), p)), x), x), And(FreeQ(List(a, b, c, d), x), ILtQ(p, C0), IntegerQ(m), IGtQ(n, C0), Or(EqQ(n, C2), EqQ(p, CN1)))));
            IIntegrate(5294, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_), Sinh(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Int(Times(Power(x, Plus(m, Times(n, p))), Power(Plus(b, Times(a, Power(Power(x, n), CN1))), p), Sinh(Plus(c, Times(d, x)))), x), And(FreeQ(List(a, b, c, d, m), x), ILtQ(p, C0), ILtQ(n, C0))));
            IIntegrate(5295, Int(Times(Cosh(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Int(Times(Power(x, Plus(m, Times(n, p))), Power(Plus(b, Times(a, Power(Power(x, n), CN1))), p), Cosh(Plus(c, Times(d, x)))), x), And(FreeQ(List(a, b, c, d, m), x), ILtQ(p, C0), ILtQ(n, C0))));
            IIntegrate(5296, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT), Sinh(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Unintegrable(Times(Power(Times(e, x), m), Power(Plus(a, Times(b, Power(x, n))), p), Sinh(Plus(c, Times(d, x)))), x), FreeQ(List(a, b, c, d, e, m, n, p), x)));
            IIntegrate(5297, Int(Times(Cosh(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Times(e, x), m), Power(Plus(a, Times(b, Power(x, n))), p), Cosh(Plus(c, Times(d, x)))), x), FreeQ(List(a, b, c, d, e, m, n, p), x)));
            IIntegrate(5298, Int(Sinh(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Subtract(Dist(C1D2, Int(Exp(Plus(c, Times(d, Power(x, n)))), x), x), Dist(C1D2, Int(Exp(Subtract(Negate(c), Times(d, Power(x, n)))), x), x)), And(FreeQ(List(c, d), x), IGtQ(n, C1))));
            IIntegrate(5299, Int(Cosh(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))), x_Symbol),
                    Condition(Plus(Dist(C1D2, Int(Exp(Plus(c, Times(d, Power(x, n)))), x), x), Dist(C1D2, Int(Exp(Subtract(Negate(c), Times(d, Power(x, n)))), x), x)), And(FreeQ(List(c, d), x), IGtQ(n, C1))));
            IIntegrate(5300, Int(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sinh(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))))), p_), x_Symbol),
                    Condition(Int(ExpandTrigReduce(Power(Plus(a, Times(b, Sinh(Plus(c, Times(d, Power(x, n)))))), p), x), x), And(FreeQ(List(a, b, c, d), x), IGtQ(n, C1), IGtQ(p, C1))));
        }
    }
}
