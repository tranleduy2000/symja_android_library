package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcCosh;
import static org.matheclipse.core.expression.F.ArcSinh;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cosh;
import static org.matheclipse.core.expression.F.Coth;
import static org.matheclipse.core.expression.F.Exp;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sinh;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
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
import static org.matheclipse.core.expression.F.d_;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandTrigReduce;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
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
public class IntRules226 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(5651, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Sinh(Times(Sqr(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT))), d_DEFAULT))), x_Symbol),
                    Condition(Plus(Negate(Dist(C1D2, Int(Times(Power(Times(e, x), m), Power(Exp(Times(d, Sqr(Plus(a, Times(b, Log(Times(c, Power(x, n)))))))), CN1)), x), x)), Dist(C1D2, Int(Times(Power(Times(e, x), m), Exp(Times(d, Sqr(Plus(a, Times(b, Log(Times(c, Power(x, n))))))))), x), x)), FreeQ(List(a, b, c, d, e, m, n), x)));
            IIntegrate(5652, Int(Times(Cosh(Times(Sqr(Plus(a_DEFAULT, Times(Log(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT))), d_DEFAULT)), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Dist(C1D2, Int(Times(Power(Times(e, x), m), Power(Exp(Times(d, Sqr(Plus(a, Times(b, Log(Times(c, Power(x, n)))))))), CN1)), x), x), Dist(C1D2, Int(Times(Power(Times(e, x), m), Exp(Times(d, Sqr(Plus(a, Times(b, Log(Times(c, Power(x, n))))))))), x), x)), FreeQ(List(a, b, c, d, e, m, n), x)));
            IIntegrate(5653, Int(Power(Plus(a_DEFAULT, Times(ArcSinh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), x_Symbol),
                    Condition(Subtract(Simp(Times(x, Power(Plus(a, Times(b, ArcSinh(Times(c, x)))), n)), x), Dist(Times(b, c, n), Int(Times(x, Power(Plus(a, Times(b, ArcSinh(Times(c, x)))), Subtract(n, C1)), Power(Plus(C1, Times(Sqr(c), Sqr(x))), CN1D2)), x), x)), And(FreeQ(List(a, b, c), x), GtQ(n, C0))));
            IIntegrate(5654, Int(Power(Plus(a_DEFAULT, Times(ArcCosh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), x_Symbol),
                    Condition(Subtract(Simp(Times(x, Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), n)), x), Dist(Times(b, c, n), Int(Times(x, Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), Subtract(n, C1)), Power(Times(Sqrt(Plus(CN1, Times(c, x))), Sqrt(Plus(C1, Times(c, x)))), CN1)), x), x)), And(FreeQ(List(a, b, c), x), GtQ(n, C0))));
            IIntegrate(5655, Int(Power(Plus(a_DEFAULT, Times(ArcSinh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_), x_Symbol),
                    Condition(Subtract(Simp(Times(Sqrt(Plus(C1, Times(Sqr(c), Sqr(x)))), Power(Plus(a, Times(b, ArcSinh(Times(c, x)))), Plus(n, C1)), Power(Times(b, c, Plus(n, C1)), CN1)), x), Dist(Times(c, Power(Times(b, Plus(n, C1)), CN1)), Int(Times(x, Power(Plus(a, Times(b, ArcSinh(Times(c, x)))), Plus(n, C1)), Power(Plus(C1, Times(Sqr(c), Sqr(x))), CN1D2)), x), x)), And(FreeQ(List(a, b, c), x), LtQ(n, CN1))));
            IIntegrate(5656, Int(Power(Plus(a_DEFAULT, Times(ArcCosh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_), x_Symbol),
                    Condition(Subtract(Simp(Times(Sqrt(Plus(CN1, Times(c, x))), Sqrt(Plus(C1, Times(c, x))), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), Plus(n, C1)), Power(Times(b, c, Plus(n, C1)), CN1)), x), Dist(Times(c, Power(Times(b, Plus(n, C1)), CN1)), Int(Times(x, Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), Plus(n, C1)), Power(Times(Sqrt(Plus(CN1, Times(c, x))), Sqrt(Plus(C1, Times(c, x)))), CN1)), x), x)), And(FreeQ(List(a, b, c), x), LtQ(n, CN1))));
            IIntegrate(5657, Int(Power(Plus(a_DEFAULT, Times(ArcSinh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_), x_Symbol),
                    Condition(Dist(Power(Times(b, c), CN1), Subst(Int(Times(Power(x, n), Cosh(Subtract(Times(a, Power(b, CN1)), Times(x, Power(b, CN1))))), x), x, Plus(a, Times(b, ArcSinh(Times(c, x))))), x), FreeQ(List(a, b, c, n), x)));
            IIntegrate(5658, Int(Power(Plus(a_DEFAULT, Times(ArcCosh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_), x_Symbol),
                    Condition(Negate(Dist(Power(Times(b, c), CN1), Subst(Int(Times(Power(x, n), Sinh(Subtract(Times(a, Power(b, CN1)), Times(x, Power(b, CN1))))), x), x, Plus(a, Times(b, ArcCosh(Times(c, x))))), x)), FreeQ(List(a, b, c, n), x)));
            IIntegrate(5659, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSinh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(x_, CN1)), x_Symbol),
                    Condition(Subst(Int(Times(Power(Plus(a, Times(b, x)), n), Power(Tanh(x), CN1)), x), x, ArcSinh(Times(c, x))), And(FreeQ(List(a, b, c), x), IGtQ(n, C0))));
            IIntegrate(5660, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCosh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(x_, CN1)), x_Symbol),
                    Condition(Subst(Int(Times(Power(Plus(a, Times(b, x)), n), Power(Coth(x), CN1)), x), x, ArcCosh(Times(c, x))), And(FreeQ(List(a, b, c), x), IGtQ(n, C0))));
            IIntegrate(5661, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSinh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Times(d_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(d, x), Plus(m, C1)), Power(Plus(a, Times(b, ArcSinh(Times(c, x)))), n), Power(Times(d, Plus(m, C1)), CN1)), x), Dist(Times(b, c, n, Power(Times(d, Plus(m, C1)), CN1)), Int(Times(Power(Times(d, x), Plus(m, C1)), Power(Plus(a, Times(b, ArcSinh(Times(c, x)))), Subtract(n, C1)), Power(Plus(C1, Times(Sqr(c), Sqr(x))), CN1D2)), x), x)), And(FreeQ(List(a, b, c, d, m), x), IGtQ(n, C0), NeQ(m, CN1))));
            IIntegrate(5662, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCosh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Times(d_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(d, x), Plus(m, C1)), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), n), Power(Times(d, Plus(m, C1)), CN1)), x), Dist(Times(b, c, n, Power(Times(d, Plus(m, C1)), CN1)), Int(Times(Power(Times(d, x), Plus(m, C1)), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), Subtract(n, C1)), Power(Times(Sqrt(Plus(CN1, Times(c, x))), Sqrt(Plus(C1, Times(c, x)))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, m), x), IGtQ(n, C0), NeQ(m, CN1))));
            IIntegrate(5663, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSinh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(x, Plus(m, C1)), Power(Plus(a, Times(b, ArcSinh(Times(c, x)))), n), Power(Plus(m, C1), CN1)), x), Dist(Times(b, c, n, Power(Plus(m, C1), CN1)), Int(Times(Power(x, Plus(m, C1)), Power(Plus(a, Times(b, ArcSinh(Times(c, x)))), Subtract(n, C1)), Power(Plus(C1, Times(Sqr(c), Sqr(x))), CN1D2)), x), x)), And(FreeQ(List(a, b, c), x), IGtQ(m, C0), GtQ(n, C0))));
            IIntegrate(5664, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCosh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(x, Plus(m, C1)), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), n), Power(Plus(m, C1), CN1)), x), Dist(Times(b, c, n, Power(Plus(m, C1), CN1)), Int(Times(Power(x, Plus(m, C1)), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), Subtract(n, C1)), Power(Times(Sqrt(Plus(CN1, Times(c, x))), Sqrt(Plus(C1, Times(c, x)))), CN1)), x), x)), And(FreeQ(List(a, b, c), x), IGtQ(m, C0), GtQ(n, C0))));
            IIntegrate(5665, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSinh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(x, m), Sqrt(Plus(C1, Times(Sqr(c), Sqr(x)))), Power(Plus(a, Times(b, ArcSinh(Times(c, x)))), Plus(n, C1)), Power(Times(b, c, Plus(n, C1)), CN1)), x), Dist(Power(Times(b, Power(c, Plus(m, C1)), Plus(n, C1)), CN1), Subst(Int(ExpandTrigReduce(Power(Plus(a, Times(b, x)), Plus(n, C1)), Times(Power(Sinh(x), Subtract(m, C1)), Plus(m, Times(Plus(m, C1), Sqr(Sinh(x))))), x), x), x, ArcSinh(Times(c, x))), x)), And(FreeQ(List(a, b, c), x), IGtQ(m, C0), GeQ(n, CN2), LtQ(n, CN1))));
            IIntegrate(5666, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCosh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, m), Sqrt(Plus(CN1, Times(c, x))), Sqrt(Plus(C1, Times(c, x))), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), Plus(n, C1)), Power(Times(b, c, Plus(n, C1)), CN1)), x), Dist(Power(Times(b, Power(c, Plus(m, C1)), Plus(n, C1)), CN1), Subst(Int(ExpandTrigReduce(Times(Power(Plus(a, Times(b, x)), Plus(n, C1)), Power(Cosh(x), Subtract(m, C1)), Subtract(m, Times(Plus(m, C1), Sqr(Cosh(x))))), x), x), x, ArcCosh(Times(c, x))), x)), And(FreeQ(List(a, b, c), x), IGtQ(m, C0), GeQ(n, CN2), LtQ(n, CN1))));
            IIntegrate(5667, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSinh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, m), Sqrt(Plus(C1, Times(Sqr(c), Sqr(x)))), Power(Plus(a, Times(b, ArcSinh(Times(c, x)))), Plus(n, C1)), Power(Times(b, c, Plus(n, C1)), CN1)), x), Negate(Dist(Times(c, Plus(m, C1), Power(Times(b, Plus(n, C1)), CN1)), Int(Times(Power(x, Plus(m, C1)), Power(Plus(a, Times(b, ArcSinh(Times(c, x)))), Plus(n, C1)), Power(Plus(C1, Times(Sqr(c), Sqr(x))), CN1D2)), x), x)), Negate(Dist(Times(m, Power(Times(b, c, Plus(n, C1)), CN1)), Int(Times(Power(x, Subtract(m, C1)), Power(Plus(a, Times(b, ArcSinh(Times(c, x)))), Plus(n, C1)), Power(Plus(C1, Times(Sqr(c), Sqr(x))), CN1D2)), x), x))), And(FreeQ(List(a, b, c), x), IGtQ(m, C0), LtQ(n, CN2))));
            IIntegrate(5668, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCosh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(x, m), Sqrt(Plus(CN1, Times(c, x))), Sqrt(Plus(C1, Times(c, x))), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), Plus(n, C1)), Power(Times(b, c, Plus(n, C1)), CN1)), x), Negate(Dist(Times(c, Plus(m, C1), Power(Times(b, Plus(n, C1)), CN1)), Int(Times(Power(x, Plus(m, C1)), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), Plus(n, C1)), Power(Times(Sqrt(Plus(CN1, Times(c, x))), Sqrt(Plus(C1, Times(c, x)))), CN1)), x), x)), Dist(Times(m, Power(Times(b, c, Plus(n, C1)), CN1)), Int(Times(Power(x, Subtract(m, C1)), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), Plus(n, C1)), Power(Times(Sqrt(Plus(CN1, Times(c, x))), Sqrt(Plus(C1, Times(c, x)))), CN1)), x), x)), And(FreeQ(List(a, b, c), x), IGtQ(m, C0), LtQ(n, CN2))));
            IIntegrate(5669, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSinh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Power(c, Plus(m, C1)), CN1), Subst(Int(Times(Power(Plus(a, Times(b, x)), n), Power(Sinh(x), m), Cosh(x)), x), x, ArcSinh(Times(c, x))), x), And(FreeQ(List(a, b, c, n), x), IGtQ(m, C0))));
            IIntegrate(5670, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCosh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Power(c, Plus(m, C1)), CN1), Subst(Int(Times(Power(Plus(a, Times(b, x)), n), Power(Cosh(x), m), Sinh(x)), x), x, ArcCosh(Times(c, x))), x), And(FreeQ(List(a, b, c, n), x), IGtQ(m, C0))));
            IIntegrate(5671, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSinh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Times(d_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Times(d, x), m), Power(Plus(a, Times(b, ArcSinh(Times(c, x)))), n)), x), FreeQ(List(a, b, c, d, m, n), x)));
            IIntegrate(5672, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCosh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Times(d_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Times(d, x), m), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), n)), x), FreeQ(List(a, b, c, d, m, n), x)));
            IIntegrate(5673, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSinh(Times(c_DEFAULT, x_)), b_DEFAULT)), CN1), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Simp(Times(Log(Plus(a, Times(b, ArcSinh(Times(c, x))))), Power(Times(b, c, Sqrt(d)), CN1)), x), And(FreeQ(List(a, b, c, d, e), x), EqQ(e, Times(Sqr(c), d)), GtQ(d, C0))));
            IIntegrate(5674, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCosh(Times(c_DEFAULT, x_)), b_DEFAULT)), CN1), Power(Plus($p("d1"), Times($p("e1", true), x_)), CN1D2), Power(Plus($p("d2"), Times($p("e2", true), x_)), CN1D2)), x_Symbol),
                    Condition(Simp(Times(Log(Plus(a, Times(b, ArcCosh(Times(c, x))))), Power(Times(b, c, Sqrt(Times(CN1, $s("d1"), $s("d2")))), CN1)), x), And(FreeQ(List(a, b, c, $s("d1"), $s("e1"), $s("d2"), $s("e2")), x), EqQ($s("e1"), Times(c, $s("d1"))), EqQ($s("e2"), Times(CN1, c, $s("d2"))), GtQ($s("d1"), C0), LtQ($s("d2"), C0))));
            IIntegrate(5675, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSinh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Simp(Times(Power(Plus(a, Times(b, ArcSinh(Times(c, x)))), Plus(n, C1)), Power(Times(b, c, Sqrt(d), Plus(n, C1)), CN1)), x), And(FreeQ(List(a, b, c, d, e, n), x), EqQ(e, Times(Sqr(c), d)), GtQ(d, C0), NeQ(n, CN1))));
        }
    }
}
