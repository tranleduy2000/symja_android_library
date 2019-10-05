package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.Coefficient;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cosh;
import static org.matheclipse.core.expression.F.Coth;
import static org.matheclipse.core.expression.F.Csch;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sech;
import static org.matheclipse.core.expression.F.Simplify;
import static org.matheclipse.core.expression.F.Sinh;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Tanh;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_DEFAULT;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialMatchQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandTrigReduce;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearMatchQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules217 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(5426, Int(Times(Power(u_, m_DEFAULT), Power(Sech(v_), n_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(ExpandToSum(u, x), m), Power(Sech(ExpandToSum(v, x)), n)), x), And(FreeQ(List(m, n), x), LinearQ(List(u, v), x), Not(LinearMatchQ(List(u, v), x)))));
            IIntegrate(5427, Int(Times(Power(Csch(v_), n_DEFAULT), Power(u_, m_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(ExpandToSum(u, x), m), Power(Csch(ExpandToSum(v, x)), n)), x), And(FreeQ(List(m, n), x), LinearQ(List(u, v), x), Not(LinearMatchQ(List(u, v), x)))));
            IIntegrate(5428, Int(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sech(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))))), p_DEFAULT), x_Symbol),
                    Condition(Dist(Power(n, CN1), Subst(Int(Times(Power(x, Subtract(Power(n, CN1), C1)), Power(Plus(a, Times(b, Sech(Plus(c, Times(d, x))))), p)), x), x, Power(x, n)), x), And(FreeQ(List(a, b, c, d, p), x), IGtQ(Power(n, CN1), C0), IntegerQ(p))));
            IIntegrate(5429, Int(Power(Plus(a_DEFAULT, Times(Csch(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))), b_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Power(n, CN1), Subst(Int(Times(Power(x, Subtract(Power(n, CN1), C1)), Power(Plus(a, Times(b, Csch(Plus(c, Times(d, x))))), p)), x), x, Power(x, n)), x), And(FreeQ(List(a, b, c, d, p), x), IGtQ(Power(n, CN1), C0), IntegerQ(p))));
            IIntegrate(5430, Int(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sech(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))))), p_DEFAULT), x_Symbol),
                    Condition(Unintegrable(Power(Plus(a, Times(b, Sech(Plus(c, Times(d, Power(x, n)))))), p), x), FreeQ(List(a, b, c, d, n, p), x)));
            IIntegrate(5431, Int(Power(Plus(a_DEFAULT, Times(Csch(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))), b_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Unintegrable(Power(Plus(a, Times(b, Csch(Plus(c, Times(d, Power(x, n)))))), p), x), FreeQ(List(a, b, c, d, n, p), x)));
            IIntegrate(5432, Int(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sech(Plus(c_DEFAULT, Times(d_DEFAULT, Power(u_, n_)))))), p_DEFAULT), x_Symbol),
                    Condition(Dist(Power(Coefficient(u, x, C1), CN1), Subst(Int(Power(Plus(a, Times(b, Sech(Plus(c, Times(d, Power(x, n)))))), p), x), x, u), x), And(FreeQ(List(a, b, c, d, n, p), x), LinearQ(u, x), NeQ(u, x))));
            IIntegrate(5433, Int(Power(Plus(a_DEFAULT, Times(Csch(Plus(c_DEFAULT, Times(d_DEFAULT, Power(u_, n_)))), b_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Power(Coefficient(u, x, C1), CN1), Subst(Int(Power(Plus(a, Times(b, Csch(Plus(c, Times(d, Power(x, n)))))), p), x), x, u), x), And(FreeQ(List(a, b, c, d, n, p), x), LinearQ(u, x), NeQ(u, x))));
            IIntegrate(5434, Int(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sech(u_))), p_DEFAULT), x_Symbol),
                    Condition(Int(Power(Plus(a, Times(b, Sech(ExpandToSum(u, x)))), p), x), And(FreeQ(List(a, b, p), x), BinomialQ(u, x), Not(BinomialMatchQ(u, x)))));
            IIntegrate(5435, Int(Power(Plus(a_DEFAULT, Times(Csch(u_), b_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Int(Power(Plus(a, Times(b, Csch(ExpandToSum(u, x)))), p), x), And(FreeQ(List(a, b, p), x), BinomialQ(u, x), Not(BinomialMatchQ(u, x)))));
            IIntegrate(5436, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sech(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(n, CN1), Subst(Int(Times(Power(x, Subtract(Simplify(Times(Plus(m, C1), Power(n, CN1))), C1)), Power(Plus(a, Times(b, Sech(Plus(c, Times(d, x))))), p)), x), x, Power(x, n)), x), And(FreeQ(List(a, b, c, d, m, n, p), x), IGtQ(Simplify(Times(Plus(m, C1), Power(n, CN1))), C0), IntegerQ(p))));
            IIntegrate(5437, Int(Times(Power(Plus(a_DEFAULT, Times(Csch(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))), b_DEFAULT)), p_DEFAULT), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(n, CN1), Subst(Int(Times(Power(x, Subtract(Simplify(Times(Plus(m, C1), Power(n, CN1))), C1)), Power(Plus(a, Times(b, Csch(Plus(c, Times(d, x))))), p)), x), x, Power(x, n)), x), And(FreeQ(List(a, b, c, d, m, n, p), x), IGtQ(Simplify(Times(Plus(m, C1), Power(n, CN1))), C0), IntegerQ(p))));
            IIntegrate(5438, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sech(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))))), p_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(x, m), Power(Plus(a, Times(b, Sech(Plus(c, Times(d, Power(x, n)))))), p)), x), FreeQ(List(a, b, c, d, m, n, p), x)));
            IIntegrate(5439, Int(Times(Power(Plus(a_DEFAULT, Times(Csch(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))), b_DEFAULT)), p_DEFAULT), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(x, m), Power(Plus(a, Times(b, Csch(Plus(c, Times(d, Power(x, n)))))), p)), x), FreeQ(List(a, b, c, d, m, n, p), x)));
            IIntegrate(5440, Int(Times(Power(Times(e_, x_), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sech(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(e, IntPart(m)), Power(Times(e, x), FracPart(m)), Power(Power(x, FracPart(m)), CN1)), Int(Times(Power(x, m), Power(Plus(a, Times(b, Sech(Plus(c, Times(d, Power(x, n)))))), p)), x), x), FreeQ(List(a, b, c, d, e, m, n, p), x)));
            IIntegrate(5441, Int(Times(Power(Plus(a_DEFAULT, Times(Csch(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))), b_DEFAULT)), p_DEFAULT), Power(Times(e_, x_), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(e, IntPart(m)), Power(Times(e, x), FracPart(m)), Power(Power(x, FracPart(m)), CN1)), Int(Times(Power(x, m), Power(Plus(a, Times(b, Csch(Plus(c, Times(d, Power(x, n)))))), p)), x), x), FreeQ(List(a, b, c, d, e, m, n, p), x)));
            IIntegrate(5442, Int(Times(Power(Times(e_, x_), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sech(u_))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Times(e, x), m), Power(Plus(a, Times(b, Sech(ExpandToSum(u, x)))), p)), x), And(FreeQ(List(a, b, e, m, p), x), BinomialQ(u, x), Not(BinomialMatchQ(u, x)))));
            IIntegrate(5443, Int(Times(Power(Plus(a_DEFAULT, Times(Csch(u_), b_DEFAULT)), p_DEFAULT), Power(Times(e_, x_), m_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Times(e, x), m), Power(Plus(a, Times(b, Csch(ExpandToSum(u, x)))), p)), x), And(FreeQ(List(a, b, e, m, p), x), BinomialQ(u, x), Not(BinomialMatchQ(u, x)))));
            IIntegrate(5444, Int(Times(Power(x_, m_DEFAULT), Power(Sech(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT)))), p_), Sinh(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(x, Plus(m, Negate(n), C1)), Power(Sech(Plus(a, Times(b, Power(x, n)))), Subtract(p, C1)), Power(Times(b, n, Subtract(p, C1)), CN1)), x)), Dist(Times(Plus(m, Negate(n), C1), Power(Times(b, n, Subtract(p, C1)), CN1)), Int(Times(Power(x, Subtract(m, n)), Power(Sech(Plus(a, Times(b, Power(x, n)))), Subtract(p, C1))), x), x)), And(FreeQ(List(a, b, p), x), IntegerQ(n), GeQ(Subtract(m, n), C0), NeQ(p, C1))));
            IIntegrate(5445, Int(Times(Cosh(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT)))), Power(Csch(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT)))), p_), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(x, Plus(m, Negate(n), C1)), Power(Csch(Plus(a, Times(b, Power(x, n)))), Subtract(p, C1)), Power(Times(b, n, Subtract(p, C1)), CN1)), x)), Dist(Times(Plus(m, Negate(n), C1), Power(Times(b, n, Subtract(p, C1)), CN1)), Int(Times(Power(x, Subtract(m, n)), Power(Csch(Plus(a, Times(b, Power(x, n)))), Subtract(p, C1))), x), x)), And(FreeQ(List(a, b, p), x), IntegerQ(n), GeQ(Subtract(m, n), C0), NeQ(p, C1))));
            IIntegrate(5446, Int(Times(Cosh(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Power(Sinh(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(c, Times(d, x)), m), Power(Sinh(Plus(a, Times(b, x))), Plus(n, C1)), Power(Times(b, Plus(n, C1)), CN1)), x), Dist(Times(d, m, Power(Times(b, Plus(n, C1)), CN1)), Int(Times(Power(Plus(c, Times(d, x)), Subtract(m, C1)), Power(Sinh(Plus(a, Times(b, x))), Plus(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, n), x), IGtQ(m, C0), NeQ(n, CN1))));
            IIntegrate(5447, Int(Times(Power(Cosh(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Sinh(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(c, Times(d, x)), m), Power(Cosh(Plus(a, Times(b, x))), Plus(n, C1)), Power(Times(b, Plus(n, C1)), CN1)), x), Dist(Times(d, m, Power(Times(b, Plus(n, C1)), CN1)), Int(Times(Power(Plus(c, Times(d, x)), Subtract(m, C1)), Power(Cosh(Plus(a, Times(b, x))), Plus(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, n), x), IGtQ(m, C0), NeQ(n, CN1))));
            IIntegrate(5448, Int(Times(Power(Cosh(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Power(Sinh(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrigReduce(Power(Plus(c, Times(d, x)), m), Times(Power(Sinh(Plus(a, Times(b, x))), n), Power(Cosh(Plus(a, Times(b, x))), p)), x), x), And(FreeQ(List(a, b, c, d, m), x), IGtQ(n, C0), IGtQ(p, C0))));
            IIntegrate(5449, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Power(Sinh(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT), Power(Tanh(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_DEFAULT)), x_Symbol),
                    Condition(Subtract(Int(Times(Power(Plus(c, Times(d, x)), m), Power(Sinh(Plus(a, Times(b, x))), n), Power(Tanh(Plus(a, Times(b, x))), Subtract(p, C2))), x), Int(Times(Power(Plus(c, Times(d, x)), m), Power(Sinh(Plus(a, Times(b, x))), Subtract(n, C2)), Power(Tanh(Plus(a, Times(b, x))), p)), x)), And(FreeQ(List(a, b, c, d, m), x), IGtQ(n, C0), IGtQ(p, C0))));
            IIntegrate(5450, Int(Times(Power(Cosh(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT), Power(Coth(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Int(Times(Power(Plus(c, Times(d, x)), m), Power(Cosh(Plus(a, Times(b, x))), n), Power(Coth(Plus(a, Times(b, x))), Subtract(p, C2))), x), Int(Times(Power(Plus(c, Times(d, x)), m), Power(Cosh(Plus(a, Times(b, x))), Subtract(n, C2)), Power(Coth(Plus(a, Times(b, x))), p)), x)), And(FreeQ(List(a, b, c, d, m), x), IGtQ(n, C0), IGtQ(p, C0))));
        }
    }
}
