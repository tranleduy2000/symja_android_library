package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.Coefficient;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cosh;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.Exp;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Module;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Simplify;
import static org.matheclipse.core.expression.F.Sinh;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Subtract;
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
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.k;
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
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialMatchQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandTrigReduce;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules214 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(5351, Int(Times(Power(Plus(a_DEFAULT, Times(Cosh(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))), b_DEFAULT)), p_DEFAULT), Power(Times(e_DEFAULT, x_), m_)), x_Symbol),
                    Condition(Negate(Dist(Times(Power(Times(e, x), m), Power(Power(x, CN1), m)), Subst(Int(Times(Power(Plus(a, Times(b, Cosh(Plus(c, Times(d, Power(Power(x, n), CN1)))))), p), Power(Power(x, Plus(m, C2)), CN1)), x), x, Power(x, CN1)), x)), And(FreeQ(List(a, b, c, d, e, m), x), IntegerQ(p), ILtQ(n, C0), Not(RationalQ(m)))));
            IIntegrate(5352, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sinh(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))))), p_DEFAULT)), x_Symbol),
                    Condition(Module(List(Set(k, Denominator(n))), Dist(k, Subst(Int(Times(Power(x, Subtract(Times(k, Plus(m, C1)), C1)), Power(Plus(a, Times(b, Sinh(Plus(c, Times(d, Power(x, Times(k, n))))))), p)), x), x, Power(x, Power(k, CN1))), x)), And(FreeQ(List(a, b, c, d, m), x), IntegerQ(p), FractionQ(n))));
            IIntegrate(5353, Int(Times(Power(Plus(a_DEFAULT, Times(Cosh(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))), b_DEFAULT)), p_DEFAULT), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Module(List(Set(k, Denominator(n))), Dist(k, Subst(Int(Times(Power(x, Subtract(Times(k, Plus(m, C1)), C1)), Power(Plus(a, Times(b, Cosh(Plus(c, Times(d, Power(x, Times(k, n))))))), p)), x), x, Power(x, Power(k, CN1))), x)), And(FreeQ(List(a, b, c, d, m), x), IntegerQ(p), FractionQ(n))));
            IIntegrate(5354, Int(Times(Power(Times(e_, x_), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sinh(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(e, IntPart(m)), Power(Times(e, x), FracPart(m)), Power(Power(x, FracPart(m)), CN1)), Int(Times(Power(x, m), Power(Plus(a, Times(b, Sinh(Plus(c, Times(d, Power(x, n)))))), p)), x), x), And(FreeQ(List(a, b, c, d, e, m), x), IntegerQ(p), FractionQ(n))));
            IIntegrate(5355, Int(Times(Power(Plus(a_DEFAULT, Times(Cosh(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))), b_DEFAULT)), p_DEFAULT), Power(Times(e_, x_), m_)), x_Symbol),
                    Condition(Dist(Times(Power(e, IntPart(m)), Power(Times(e, x), FracPart(m)), Power(Power(x, FracPart(m)), CN1)), Int(Times(Power(x, m), Power(Plus(a, Times(b, Cosh(Plus(c, Times(d, Power(x, n)))))), p)), x), x), And(FreeQ(List(a, b, c, d, e, m), x), IntegerQ(p), FractionQ(n))));
            IIntegrate(5356, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sinh(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Plus(m, C1), CN1), Subst(Int(Power(Plus(a, Times(b, Sinh(Plus(c, Times(d, Power(x, Simplify(Times(n, Power(Plus(m, C1), CN1))))))))), p), x), x, Power(x, Plus(m, C1))), x), And(FreeQ(List(a, b, c, d, m, n), x), IntegerQ(p), NeQ(m, CN1), IGtQ(Simplify(Times(n, Power(Plus(m, C1), CN1))), C0), Not(IntegerQ(n)))));
            IIntegrate(5357, Int(Times(Power(Plus(a_DEFAULT, Times(Cosh(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))), b_DEFAULT)), p_DEFAULT), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Plus(m, C1), CN1), Subst(Int(Power(Plus(a, Times(b, Cosh(Plus(c, Times(d, Power(x, Simplify(Times(n, Power(Plus(m, C1), CN1))))))))), p), x), x, Power(x, Plus(m, C1))), x), And(FreeQ(List(a, b, c, d, m, n), x), IntegerQ(p), NeQ(m, CN1), IGtQ(Simplify(Times(n, Power(Plus(m, C1), CN1))), C0), Not(IntegerQ(n)))));
            IIntegrate(5358, Int(Times(Power(Times(e_, x_), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sinh(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(e, IntPart(m)), Power(Times(e, x), FracPart(m)), Power(Power(x, FracPart(m)), CN1)), Int(Times(Power(x, m), Power(Plus(a, Times(b, Sinh(Plus(c, Times(d, Power(x, n)))))), p)), x), x), And(FreeQ(List(a, b, c, d, e, m, n), x), IntegerQ(p), NeQ(m, CN1), IGtQ(Simplify(Times(n, Power(Plus(m, C1), CN1))), C0), Not(IntegerQ(n)))));
            IIntegrate(5359, Int(Times(Power(Plus(a_DEFAULT, Times(Cosh(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))), b_DEFAULT)), p_DEFAULT), Power(Times(e_, x_), m_)), x_Symbol),
                    Condition(Dist(Times(Power(e, IntPart(m)), Power(Times(e, x), FracPart(m)), Power(Power(x, FracPart(m)), CN1)), Int(Times(Power(x, m), Power(Plus(a, Times(b, Cosh(Plus(c, Times(d, Power(x, n)))))), p)), x), x), And(FreeQ(List(a, b, c, d, e, m, n), x), IntegerQ(p), NeQ(m, CN1), IGtQ(Simplify(Times(n, Power(Plus(m, C1), CN1))), C0), Not(IntegerQ(n)))));
            IIntegrate(5360, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Sinh(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_))))), x_Symbol),
                    Condition(Subtract(Dist(C1D2, Int(Times(Power(Times(e, x), m), Exp(Plus(c, Times(d, Power(x, n))))), x), x), Dist(C1D2, Int(Times(Power(Times(e, x), m), Exp(Subtract(Negate(c), Times(d, Power(x, n))))), x), x)), FreeQ(List(c, d, e, m, n), x)));
            IIntegrate(5361, Int(Times(Cosh(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Dist(C1D2, Int(Times(Power(Times(e, x), m), Exp(Plus(c, Times(d, Power(x, n))))), x), x), Dist(C1D2, Int(Times(Power(Times(e, x), m), Exp(Subtract(Negate(c), Times(d, Power(x, n))))), x), x)), FreeQ(List(c, d, e, m, n), x)));
            IIntegrate(5362, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sinh(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))))), p_)), x_Symbol),
                    Condition(Int(ExpandTrigReduce(Power(Times(e, x), m), Power(Plus(a, Times(b, Sinh(Plus(c, Times(d, Power(x, n)))))), p), x), x), And(FreeQ(List(a, b, c, d, e, m, n), x), IGtQ(p, C0))));
            IIntegrate(5363, Int(Times(Power(Plus(a_DEFAULT, Times(Cosh(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_)))), b_DEFAULT)), p_), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrigReduce(Power(Times(e, x), m), Power(Plus(a, Times(b, Cosh(Plus(c, Times(d, Power(x, n)))))), p), x), x), And(FreeQ(List(a, b, c, d, e, m, n), x), IGtQ(p, C0))));
            IIntegrate(5364, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sinh(Plus(c_DEFAULT, Times(d_DEFAULT, Power(u_, n_)))))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Power(Coefficient(u, x, C1), Plus(m, C1)), CN1), Subst(Int(Times(Power(Subtract(x, Coefficient(u, x, C0)), m), Power(Plus(a, Times(b, Sinh(Plus(c, Times(d, Power(x, n)))))), p)), x), x, u), x), And(FreeQ(List(a, b, c, d, n, p), x), LinearQ(u, x), NeQ(u, x), IntegerQ(m))));
            IIntegrate(5365, Int(Times(Power(Plus(a_DEFAULT, Times(Cosh(Plus(c_DEFAULT, Times(d_DEFAULT, Power(u_, n_)))), b_DEFAULT)), p_DEFAULT), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Power(Coefficient(u, x, C1), Plus(m, C1)), CN1), Subst(Int(Times(Power(Subtract(x, Coefficient(u, x, C0)), m), Power(Plus(a, Times(b, Cosh(Plus(c, Times(d, Power(x, n)))))), p)), x), x, u), x), And(FreeQ(List(a, b, c, d, n, p), x), LinearQ(u, x), NeQ(u, x), IntegerQ(m))));
            IIntegrate(5366, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sinh(Plus(c_DEFAULT, Times(d_DEFAULT, Power(u_, n_)))))), p_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Times(e, x), m), Power(Plus(a, Times(b, Sinh(Plus(c, Times(d, Power(u, n)))))), p)), x), And(FreeQ(List(a, b, c, d, e, m, n, p), x), LinearQ(u, x))));
            IIntegrate(5367, Int(Times(Power(Plus(a_DEFAULT, Times(Cosh(Plus(c_DEFAULT, Times(d_DEFAULT, Power(u_, n_)))), b_DEFAULT)), p_DEFAULT), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Times(e, x), m), Power(Plus(a, Times(b, Cosh(Plus(c, Times(d, Power(u, n)))))), p)), x), And(FreeQ(List(a, b, c, d, e, m, n, p), x), LinearQ(u, x))));
            IIntegrate(5368, Int(Times(Power(Times(e_, x_), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sinh(u_))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Times(e, x), m), Power(Plus(a, Times(b, Sinh(ExpandToSum(u, x)))), p)), x), And(FreeQ(List(a, b, e, m, p), x), BinomialQ(u, x), Not(BinomialMatchQ(u, x)))));
            IIntegrate(5369, Int(Times(Power(Plus(a_DEFAULT, Times(Cosh(u_), b_DEFAULT)), p_DEFAULT), Power(Times(e_, x_), m_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Times(e, x), m), Power(Plus(a, Times(b, Cosh(ExpandToSum(u, x)))), p)), x), And(FreeQ(List(a, b, e, m, p), x), BinomialQ(u, x), Not(BinomialMatchQ(u, x)))));
            IIntegrate(5370, Int(Times(Cosh(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT)))), Power(x_, m_DEFAULT), Power(Sinh(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_)))), p_DEFAULT)), x_Symbol),
                    Condition(Simp(Times(Power(Sinh(Plus(a, Times(b, Power(x, n)))), Plus(p, C1)), Power(Times(b, n, Plus(p, C1)), CN1)), x), And(FreeQ(List(a, b, m, n, p), x), EqQ(m, Subtract(n, C1)), NeQ(p, CN1))));
            IIntegrate(5371, Int(Times(Power(Cosh(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_)))), p_DEFAULT), Power(x_, m_DEFAULT), Sinh(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT))))), x_Symbol),
                    Condition(Simp(Times(Power(Cosh(Plus(a, Times(b, Power(x, n)))), Plus(p, C1)), Power(Times(b, n, Plus(p, C1)), CN1)), x), And(FreeQ(List(a, b, m, n, p), x), EqQ(m, Subtract(n, C1)), NeQ(p, CN1))));
            IIntegrate(5372, Int(Times(Cosh(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT)))), Power(x_, m_DEFAULT), Power(Sinh(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT)))), p_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(x, Plus(m, Negate(n), C1)), Power(Sinh(Plus(a, Times(b, Power(x, n)))), Plus(p, C1)), Power(Times(b, n, Plus(p, C1)), CN1)), x), Dist(Times(Plus(m, Negate(n), C1), Power(Times(b, n, Plus(p, C1)), CN1)), Int(Times(Power(x, Subtract(m, n)), Power(Sinh(Plus(a, Times(b, Power(x, n)))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, p), x), LtQ(C0, n, Plus(m, C1)), NeQ(p, CN1))));
            IIntegrate(5373, Int(Times(Power(Cosh(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT)))), p_DEFAULT), Power(x_, m_DEFAULT), Sinh(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT))))), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(x, Plus(m, Negate(n), C1)), Power(Cosh(Plus(a, Times(b, Power(x, n)))), Plus(p, C1)), Power(Times(b, n, Plus(p, C1)), CN1)), x), Dist(Times(Plus(m, Negate(n), C1), Power(Times(b, n, Plus(p, C1)), CN1)), Int(Times(Power(x, Subtract(m, n)), Power(Cosh(Plus(a, Times(b, Power(x, n)))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, p), x), LtQ(C0, n, Plus(m, C1)), NeQ(p, CN1))));
            IIntegrate(5374, Int(Sinh(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_)))), x_Symbol),
                    Condition(Subtract(Dist(C1D2, Int(Exp(Plus(a, Times(b, x), Times(c, Sqr(x)))), x), x), Dist(C1D2, Int(Exp(Subtract(Subtract(Negate(a), Times(b, x)), Times(c, Sqr(x)))), x), x)), FreeQ(List(a, b, c), x)));
            IIntegrate(5375, Int(Cosh(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_)))), x_Symbol),
                    Condition(Plus(Dist(C1D2, Int(Exp(Plus(a, Times(b, x), Times(c, Sqr(x)))), x), x), Dist(C1D2, Int(Exp(Subtract(Subtract(Negate(a), Times(b, x)), Times(c, Sqr(x)))), x), x)), FreeQ(List(a, b, c), x)));
        }
    }
}
