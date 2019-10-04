package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.CosIntegral;
import static org.matheclipse.core.expression.F.Exp;
import static org.matheclipse.core.expression.F.ExpIntegralE;
import static org.matheclipse.core.expression.F.ExpIntegralEi;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.Gamma;
import static org.matheclipse.core.expression.F.HypergeometricPFQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.LogIntegral;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.SinIntegral;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules259 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(6476, Int(Times(ExpIntegralE(n_, Times(b_DEFAULT, x_)), Power(x_, m_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, Plus(m, C1)), ExpIntegralE(n, Times(b, x)), Power(Plus(m, C1), CN1)), x), Dist(Times(b, Power(Plus(m, C1), CN1)), Int(Times(Power(x, Plus(m, C1)), ExpIntegralE(Subtract(n, C1), Times(b, x))), x), x)), And(FreeQ(b, x), EqQ(Plus(m, n), C0), ILtQ(m, CN1))));
            IIntegrate(6477, Int(Times(ExpIntegralE(n_, Times(b_DEFAULT, x_)), Power(Times(d_DEFAULT, x_), m_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(d, x), m), Gamma(Plus(m, C1)), Log(x), Power(Times(b, Power(Times(b, x), m)), CN1)), x), Simp(Times(Power(Times(d, x), Plus(m, C1)), HypergeometricPFQ(List(Plus(m, C1), Plus(m, C1)), List(Plus(m, C2), Plus(m, C2)), Times(CN1, b, x)), Power(Times(d, Sqr(Plus(m, C1))), CN1)), x)), And(FreeQ(List(b, d, m, n), x), EqQ(Plus(m, n), C0), Not(IntegerQ(m)))));
            IIntegrate(6478, Int(Times(ExpIntegralE(n_, Times(b_DEFAULT, x_)), Power(Times(d_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(d, x), Plus(m, C1)), ExpIntegralE(n, Times(b, x)), Power(Times(d, Plus(m, n)), CN1)), x), Simp(Times(Power(Times(d, x), Plus(m, C1)), ExpIntegralE(Negate(m), Times(b, x)), Power(Times(d, Plus(m, n)), CN1)), x)), And(FreeQ(List(b, d, m, n), x), NeQ(Plus(m, n), C0))));
            IIntegrate(6479, Int(Times(ExpIntegralE(n_, Plus(a_, Times(b_DEFAULT, x_))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(c, Times(d, x)), m), ExpIntegralE(Plus(n, C1), Plus(a, Times(b, x))), Power(b, CN1)), x)), Dist(Times(d, m, Power(b, CN1)), Int(Times(Power(Plus(c, Times(d, x)), Subtract(m, C1)), ExpIntegralE(Plus(n, C1), Plus(a, Times(b, x)))), x), x)), And(FreeQ(List(a, b, c, d, m, n), x), Or(IGtQ(m, C0), ILtQ(n, C0), And(GtQ(m, C0), LtQ(n, CN1))))));
            IIntegrate(6480, Int(Times(ExpIntegralE(n_, Plus(a_, Times(b_DEFAULT, x_))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), ExpIntegralE(n, Plus(a, Times(b, x))), Power(Times(d, Plus(m, C1)), CN1)), x), Dist(Times(b, Power(Times(d, Plus(m, C1)), CN1)), Int(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), ExpIntegralE(Subtract(n, C1), Plus(a, Times(b, x)))), x), x)), And(FreeQ(List(a, b, c, d, m, n), x), Or(IGtQ(n, C0), And(LtQ(m, CN1), GtQ(n, C0))), NeQ(m, CN1))));
            IIntegrate(6481, Int(Times(ExpIntegralE(n_, Plus(a_, Times(b_DEFAULT, x_))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(c, Times(d, x)), m), ExpIntegralE(n, Plus(a, Times(b, x)))), x), FreeQ(List(a, b, c, d, m, n), x)));
            IIntegrate(6482, Int(ExpIntegralEi(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), x_Symbol),
                    Condition(Subtract(Simp(Times(Plus(a, Times(b, x)), ExpIntegralEi(Plus(a, Times(b, x))), Power(b, CN1)), x), Simp(Times(Exp(Plus(a, Times(b, x))), Power(b, CN1)), x)), FreeQ(List(a, b), x)));
            IIntegrate(6483, Int(Times(ExpIntegralEi(Times(b_DEFAULT, x_)), Power(x_, CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(Log(x), Plus(ExpIntegralEi(Times(b, x)), ExpIntegralE(C1, Times(CN1, b, x)))), x), Int(Times(ExpIntegralE(C1, Times(CN1, b, x)), Power(x, CN1)), x)), FreeQ(b, x)));
            IIntegrate(6484, Int(Times(ExpIntegralEi(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Unintegrable(Times(ExpIntegralEi(Plus(a, Times(b, x))), Power(Plus(c, Times(d, x)), CN1)), x), FreeQ(List(a, b, c, d), x)));
            IIntegrate(6485, Int(Times(ExpIntegralEi(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), ExpIntegralEi(Plus(a, Times(b, x))), Power(Times(d, Plus(m, C1)), CN1)), x), Dist(Times(b, Power(Times(d, Plus(m, C1)), CN1)), Int(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), Exp(Plus(a, Times(b, x))), Power(Plus(a, Times(b, x)), CN1)), x), x)), And(FreeQ(List(a, b, c, d, m), x), NeQ(m, CN1))));
            IIntegrate(6486, Int(Sqr(ExpIntegralEi(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), x_Symbol),
                    Condition(Subtract(Simp(Times(Plus(a, Times(b, x)), Sqr(ExpIntegralEi(Plus(a, Times(b, x)))), Power(b, CN1)), x), Dist(C2, Int(Times(Exp(Plus(a, Times(b, x))), ExpIntegralEi(Plus(a, Times(b, x)))), x), x)), FreeQ(List(a, b), x)));
            IIntegrate(6487, Int(Times(Sqr(ExpIntegralEi(Times(b_DEFAULT, x_))), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(x, Plus(m, C1)), Sqr(ExpIntegralEi(Times(b, x))), Power(Plus(m, C1), CN1)), x), Dist(Times(C2, Power(Plus(m, C1), CN1)), Int(Times(Power(x, m), Exp(Times(b, x)), ExpIntegralEi(Times(b, x))), x), x)), And(FreeQ(b, x), IGtQ(m, C0))));
            IIntegrate(6488, Int(Times(Sqr(ExpIntegralEi(Plus(a_, Times(b_DEFAULT, x_)))), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, Plus(m, C1)), Sqr(ExpIntegralEi(Plus(a, Times(b, x)))), Power(Plus(m, C1), CN1)), x), Negate(Dist(Times(C2, Power(Plus(m, C1), CN1)), Int(Times(Power(x, m), Exp(Plus(a, Times(b, x))), ExpIntegralEi(Plus(a, Times(b, x)))), x), x)), Negate(Dist(Times(a, m, Power(Times(b, Plus(m, C1)), CN1)), Int(Times(Power(x, Subtract(m, C1)), Sqr(ExpIntegralEi(Plus(a, Times(b, x))))), x), x)), Simp(Times(a, Power(x, m), Sqr(ExpIntegralEi(Plus(a, Times(b, x)))), Power(Times(b, Plus(m, C1)), CN1)), x)), And(FreeQ(List(a, b), x), IGtQ(m, C0))));
            IIntegrate(6489, Int(Times(Exp(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), ExpIntegralEi(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Subtract(Simp(Times(Exp(Plus(a, Times(b, x))), ExpIntegralEi(Plus(c, Times(d, x))), Power(b, CN1)), x), Dist(Times(d, Power(b, CN1)), Int(Times(Exp(Plus(a, c, Times(Plus(b, d), x))), Power(Plus(c, Times(d, x)), CN1)), x), x)), FreeQ(List(a, b, c, d), x)));
            IIntegrate(6490, Int(Times(Exp(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), ExpIntegralEi(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, m), Exp(Plus(a, Times(b, x))), ExpIntegralEi(Plus(c, Times(d, x))), Power(b, CN1)), x), Negate(Dist(Times(d, Power(b, CN1)), Int(Times(Power(x, m), Exp(Plus(a, c, Times(Plus(b, d), x))), Power(Plus(c, Times(d, x)), CN1)), x), x)), Negate(Dist(Times(m, Power(b, CN1)), Int(Times(Power(x, Subtract(m, C1)), Exp(Plus(a, Times(b, x))), ExpIntegralEi(Plus(c, Times(d, x)))), x), x))), And(FreeQ(List(a, b, c, d), x), IGtQ(m, C0))));
            IIntegrate(6491, Int(Times(Exp(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), ExpIntegralEi(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(x_, m_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, Plus(m, C1)), Exp(Plus(a, Times(b, x))), ExpIntegralEi(Plus(c, Times(d, x))), Power(Plus(m, C1), CN1)), x), Negate(Dist(Times(b, Power(Plus(m, C1), CN1)), Int(Times(Power(x, Plus(m, C1)), Exp(Plus(a, Times(b, x))), ExpIntegralEi(Plus(c, Times(d, x)))), x), x)), Negate(Dist(Times(d, Power(Plus(m, C1), CN1)), Int(Times(Power(x, Plus(m, C1)), Exp(Plus(a, c, Times(Plus(b, d), x))), Power(Plus(c, Times(d, x)), CN1)), x), x))), And(FreeQ(List(a, b, c, d), x), ILtQ(m, CN1))));
            IIntegrate(6492, Int(ExpIntegralEi(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(x, ExpIntegralEi(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n)))))))), x), Dist(Times(b, n, Exp(Times(a, d))), Int(Times(Power(Times(c, Power(x, n)), Times(b, d)), Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), CN1)), x), x)), FreeQ(List(a, b, c, d, n), x)));
            IIntegrate(6493, Int(Times(ExpIntegralEi(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), Power(x_, CN1)), x_Symbol),
                    Condition(Dist(Power(n, CN1), Subst(ExpIntegralEi(Times(d, Plus(a, Times(b, x)))), x, Log(Times(c, Power(x, n)))), x), FreeQ(List(a, b, c, d, n), x)));
            IIntegrate(6494, Int(Times(ExpIntegralEi(Times(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), d_DEFAULT)), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(e, x), Plus(m, C1)), ExpIntegralEi(Times(d, Plus(a, Times(b, Log(Times(c, Power(x, n))))))), Power(Times(e, Plus(m, C1)), CN1)), x), Dist(Times(b, n, Exp(Times(a, d)), Power(Times(c, Power(x, n)), Times(b, d)), Power(Times(Plus(m, C1), Power(Times(e, x), Times(b, d, n))), CN1)), Int(Times(Power(Times(e, x), Plus(m, Times(b, d, n))), Power(Plus(a, Times(b, Log(Times(c, Power(x, n))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, m, n), x), NeQ(m, CN1))));
            IIntegrate(6495, Int(LogIntegral(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), x_Symbol),
                    Condition(Subtract(Simp(Times(Plus(a, Times(b, x)), LogIntegral(Plus(a, Times(b, x))), Power(b, CN1)), x), Simp(Times(ExpIntegralEi(Times(C2, Log(Plus(a, Times(b, x))))), Power(b, CN1)), x)), FreeQ(List(a, b), x)));
            IIntegrate(6496, Int(Times(LogIntegral(Times(b_DEFAULT, x_)), Power(x_, CN1)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, x), x)), Simp(Times(Log(Times(b, x)), LogIntegral(Times(b, x))), x)), FreeQ(b, x)));
            IIntegrate(6497, Int(Times(LogIntegral(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Unintegrable(Times(LogIntegral(Plus(a, Times(b, x))), Power(Plus(c, Times(d, x)), CN1)), x), FreeQ(List(a, b, c, d), x)));
            IIntegrate(6498, Int(Times(LogIntegral(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), LogIntegral(Plus(a, Times(b, x))), Power(Times(d, Plus(m, C1)), CN1)), x), Dist(Times(b, Power(Times(d, Plus(m, C1)), CN1)), Int(Times(Power(Plus(c, Times(d, x)), Plus(m, C1)), Power(Log(Plus(a, Times(b, x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, m), x), NeQ(m, CN1))));
            IIntegrate(6499, Int(SinIntegral(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), x_Symbol),
                    Condition(Plus(Simp(Times(Plus(a, Times(b, x)), SinIntegral(Plus(a, Times(b, x))), Power(b, CN1)), x), Simp(Times(Cos(Plus(a, Times(b, x))), Power(b, CN1)), x)), FreeQ(List(a, b), x)));
            IIntegrate(6500, Int(CosIntegral(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), x_Symbol),
                    Condition(Subtract(Simp(Times(Plus(a, Times(b, x)), CosIntegral(Plus(a, Times(b, x))), Power(b, CN1)), x), Simp(Times(Sin(Plus(a, Times(b, x))), Power(b, CN1)), x)), FreeQ(List(a, b), x)));
        }
    }
}
