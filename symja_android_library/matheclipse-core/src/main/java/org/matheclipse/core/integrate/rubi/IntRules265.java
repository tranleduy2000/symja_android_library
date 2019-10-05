package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Erf;
import static org.matheclipse.core.expression.F.Erfi;
import static org.matheclipse.core.expression.F.Exp;
import static org.matheclipse.core.expression.F.ExpIntegralEi;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.Gamma;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Pi;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.ProductLog;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
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
import static org.matheclipse.core.expression.F.d_;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NegQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules265 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(6626, Int(Times(Power(Times(c_DEFAULT, ProductLog(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), CN1D2), Power(Plus(d_, Times(d_DEFAULT, ProductLog(Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Simp(Times(Rt(Times(Pi, c), C2), Erfi(Times(Sqrt(Times(c, ProductLog(Plus(a, Times(b, x))))), Power(Rt(c, C2), CN1))), Power(Times(b, c, d), CN1)), x), And(FreeQ(List(a, b, c, d), x), PosQ(c))));
            IIntegrate(6627, Int(Times(Power(Times(c_DEFAULT, ProductLog(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), CN1D2), Power(Plus(d_, Times(d_DEFAULT, ProductLog(Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Simp(Times(Rt(Times(CN1, Pi, c), C2), Erf(Times(Sqrt(Times(c, ProductLog(Plus(a, Times(b, x))))), Power(Rt(Negate(c), C2), CN1))), Power(Times(b, c, d), CN1)), x), And(FreeQ(List(a, b, c, d), x), NegQ(c))));
            IIntegrate(6628, Int(Times(Power(Times(c_DEFAULT, ProductLog(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), p_), Power(Plus(d_, Times(d_DEFAULT, ProductLog(Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(Plus(a, Times(b, x)), Power(Times(c, ProductLog(Plus(a, Times(b, x)))), p), Power(Times(b, d, Plus(p, C1)), CN1)), x), Dist(Power(Times(c, Plus(p, C1)), CN1), Int(Times(Power(Times(c, ProductLog(Plus(a, Times(b, x)))), Plus(p, C1)), Power(Plus(d, Times(d, ProductLog(Plus(a, Times(b, x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d), x), LtQ(p, CN1))));
            IIntegrate(6629, Int(Times(Power(Times(c_DEFAULT, ProductLog(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), p_DEFAULT), Power(Plus(d_, Times(d_DEFAULT, ProductLog(Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Simp(Times(Gamma(Plus(p, C1), Negate(ProductLog(Plus(a, Times(b, x))))), Power(Times(c, ProductLog(Plus(a, Times(b, x)))), p), Power(Times(b, d, Power(Negate(ProductLog(Plus(a, Times(b, x)))), p)), CN1)), x), FreeQ(List(a, b, c, d, p), x)));
            IIntegrate(6630, Int(Times(Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Plus(d_, Times(d_DEFAULT, ProductLog(Plus(a_, Times(b_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Dist(Power(Power(b, Plus(m, C1)), CN1), Subst(Int(ExpandIntegrand(Power(Plus(d, Times(d, ProductLog(x))), CN1), Power(Plus(Times(b, e), Times(CN1, a, f), Times(f, x)), m), x), x), x, Plus(a, Times(b, x))), x), And(FreeQ(List(a, b, d, e, f), x), IGtQ(m, C0))));
            IIntegrate(6631, Int(Times(Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Times(c_DEFAULT, ProductLog(Plus(a_, Times(b_DEFAULT, x_)))), p_DEFAULT), Power(Plus(d_, Times(d_DEFAULT, ProductLog(Plus(a_, Times(b_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(Dist(Power(Power(b, Plus(m, C1)), CN1), Subst(Int(ExpandIntegrand(Times(Power(Times(c, ProductLog(x)), p), Power(Plus(d, Times(d, ProductLog(x))), CN1)), Power(Plus(Times(b, e), Times(CN1, a, f), Times(f, x)), m), x), x), x, Plus(a, Times(b, x))), x), And(FreeQ(List(a, b, c, d, e, f, p), x), IGtQ(m, C0))));
            IIntegrate(6632, Int(Power(Plus(d_, Times(d_DEFAULT, ProductLog(Times(a_DEFAULT, Power(x_, n_))))), CN1), x_Symbol),
                    Condition(Negate(Subst(Int(Power(Times(Sqr(x), Plus(d, Times(d, ProductLog(Times(a, Power(Power(x, n), CN1)))))), CN1), x), x, Power(x, CN1))), And(FreeQ(List(a, d), x), ILtQ(n, C0))));
            IIntegrate(6633, Int(Times(Power(Times(c_DEFAULT, ProductLog(Times(a_DEFAULT, Power(x_, n_DEFAULT)))), p_DEFAULT), Power(Plus(d_, Times(d_DEFAULT, ProductLog(Times(a_DEFAULT, Power(x_, n_DEFAULT))))), CN1)), x_Symbol),
                    Condition(Simp(Times(c, x, Power(Times(c, ProductLog(Times(a, Power(x, n)))), Subtract(p, C1)), Power(d, CN1)), x), And(FreeQ(List(a, c, d, n, p), x), EqQ(Times(n, Subtract(p, C1)), CN1))));
            IIntegrate(6634, Int(Times(Power(ProductLog(Times(a_DEFAULT, Power(x_, n_DEFAULT))), p_DEFAULT), Power(Plus(d_, Times(d_DEFAULT, ProductLog(Times(a_DEFAULT, Power(x_, n_DEFAULT))))), CN1)), x_Symbol),
                    Condition(Simp(Times(Power(a, p), ExpIntegralEi(Times(CN1, p, ProductLog(Times(a, Power(x, n))))), Power(Times(d, n), CN1)), x), And(FreeQ(List(a, d), x), IntegerQ(p), EqQ(Times(n, p), CN1))));
            IIntegrate(6635, Int(Times(Power(Times(c_DEFAULT, ProductLog(Times(a_DEFAULT, Power(x_, n_DEFAULT)))), p_), Power(Plus(d_, Times(d_DEFAULT, ProductLog(Times(a_DEFAULT, Power(x_, n_DEFAULT))))), CN1)), x_Symbol),
                    Condition(Simp(Times(Rt(Times(Pi, c, n), C2), Erfi(Times(Sqrt(Times(c, ProductLog(Times(a, Power(x, n))))), Power(Rt(Times(c, n), C2), CN1))), Power(Times(d, n, Power(a, Power(n, CN1)), Power(c, Power(n, CN1))), CN1)), x), And(FreeQ(List(a, c, d), x), IntegerQ(Power(n, CN1)), EqQ(p, Subtract(C1D2, Power(n, CN1))), PosQ(Times(c, n)))));
            IIntegrate(6636, Int(Times(Power(Times(c_DEFAULT, ProductLog(Times(a_DEFAULT, Power(x_, n_DEFAULT)))), p_), Power(Plus(d_, Times(d_DEFAULT, ProductLog(Times(a_DEFAULT, Power(x_, n_DEFAULT))))), CN1)), x_Symbol),
                    Condition(Simp(Times(Rt(Times(CN1, Pi, c, n), C2), Erf(Times(Sqrt(Times(c, ProductLog(Times(a, Power(x, n))))), Power(Rt(Times(CN1, c, n), C2), CN1))), Power(Times(d, n, Power(a, Power(n, CN1)), Power(c, Power(n, CN1))), CN1)), x), And(FreeQ(List(a, c, d), x), IntegerQ(Power(n, CN1)), EqQ(p, Subtract(C1D2, Power(n, CN1))), NegQ(Times(c, n)))));
            IIntegrate(6637, Int(Times(Power(Times(c_DEFAULT, ProductLog(Times(a_DEFAULT, Power(x_, n_DEFAULT)))), p_DEFAULT), Power(Plus(d_, Times(d_DEFAULT, ProductLog(Times(a_DEFAULT, Power(x_, n_DEFAULT))))), CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(c, x, Power(Times(c, ProductLog(Times(a, Power(x, n)))), Subtract(p, C1)), Power(d, CN1)), x), Dist(Times(c, Plus(Times(n, Subtract(p, C1)), C1)), Int(Times(Power(Times(c, ProductLog(Times(a, Power(x, n)))), Subtract(p, C1)), Power(Plus(d, Times(d, ProductLog(Times(a, Power(x, n))))), CN1)), x), x)), And(FreeQ(List(a, c, d), x), GtQ(n, C0), GtQ(Plus(Times(n, Subtract(p, C1)), C1), C0))));
            IIntegrate(6638, Int(Times(Power(Times(c_DEFAULT, ProductLog(Times(a_DEFAULT, Power(x_, n_DEFAULT)))), p_DEFAULT), Power(Plus(d_, Times(d_DEFAULT, ProductLog(Times(a_DEFAULT, Power(x_, n_DEFAULT))))), CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(x, Power(Times(c, ProductLog(Times(a, Power(x, n)))), p), Power(Times(d, Plus(Times(n, p), C1)), CN1)), x), Dist(Power(Times(c, Plus(Times(n, p), C1)), CN1), Int(Times(Power(Times(c, ProductLog(Times(a, Power(x, n)))), Plus(p, C1)), Power(Plus(d, Times(d, ProductLog(Times(a, Power(x, n))))), CN1)), x), x)), And(FreeQ(List(a, c, d), x), GtQ(n, C0), LtQ(Plus(Times(n, p), C1), C0))));
            IIntegrate(6639, Int(Times(Power(Times(c_DEFAULT, ProductLog(Times(a_DEFAULT, Power(x_, n_)))), p_DEFAULT), Power(Plus(d_, Times(d_DEFAULT, ProductLog(Times(a_DEFAULT, Power(x_, n_))))), CN1)), x_Symbol),
                    Condition(Negate(Subst(Int(Times(Power(Times(c, ProductLog(Times(a, Power(Power(x, n), CN1)))), p), Power(Times(Sqr(x), Plus(d, Times(d, ProductLog(Times(a, Power(Power(x, n), CN1)))))), CN1)), x), x, Power(x, CN1))), And(FreeQ(List(a, c, d, p), x), ILtQ(n, C0))));
            IIntegrate(6640, Int(Times(Power(x_, m_DEFAULT), Power(Plus(d_, Times(d_DEFAULT, ProductLog(Times(a_DEFAULT, x_)))), CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(x, Plus(m, C1)), Power(Times(d, Plus(m, C1), ProductLog(Times(a, x))), CN1)), x), Dist(Times(m, Power(Plus(m, C1), CN1)), Int(Times(Power(x, m), Power(Times(ProductLog(Times(a, x)), Plus(d, Times(d, ProductLog(Times(a, x))))), CN1)), x), x)), And(FreeQ(List(a, d), x), GtQ(m, C0))));
            IIntegrate(6641, Int(Times(Power(x_, CN1), Power(Plus(d_, Times(d_DEFAULT, ProductLog(Times(a_DEFAULT, x_)))), CN1)), x_Symbol),
                    Condition(Simp(Times(Log(ProductLog(Times(a, x))), Power(d, CN1)), x), FreeQ(List(a, d), x)));
            IIntegrate(6642, Int(Times(Power(x_, m_DEFAULT), Power(Plus(d_, Times(d_DEFAULT, ProductLog(Times(a_DEFAULT, x_)))), CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(x, Plus(m, C1)), Power(Times(d, Plus(m, C1)), CN1)), x), Int(Times(Power(x, m), ProductLog(Times(a, x)), Power(Plus(d, Times(d, ProductLog(Times(a, x)))), CN1)), x)), And(FreeQ(List(a, d), x), LtQ(m, CN1))));
            IIntegrate(6643, Int(Times(Power(x_, m_DEFAULT), Power(Plus(d_, Times(d_DEFAULT, ProductLog(Times(a_DEFAULT, x_)))), CN1)), x_Symbol),
                    Condition(Simp(Times(Power(x, m), Gamma(Plus(m, C1), Times(CN1, Plus(m, C1), ProductLog(Times(a, x)))), Power(Times(a, d, Plus(m, C1), Exp(Times(m, ProductLog(Times(a, x)))), Power(Times(CN1, Plus(m, C1), ProductLog(Times(a, x))), m)), CN1)), x), And(FreeQ(List(a, d, m), x), Not(IntegerQ(m)))));
            IIntegrate(6644, Int(Times(Power(x_, CN1), Power(Plus(d_, Times(d_DEFAULT, ProductLog(Times(a_DEFAULT, Power(x_, n_DEFAULT))))), CN1)), x_Symbol),
                    Condition(Simp(Times(Log(ProductLog(Times(a, Power(x, n)))), Power(Times(d, n), CN1)), x), FreeQ(List(a, d, n), x)));
            IIntegrate(6645, Int(Times(Power(x_, m_DEFAULT), Power(Plus(d_, Times(d_DEFAULT, ProductLog(Times(a_DEFAULT, Power(x_, n_))))), CN1)), x_Symbol),
                    Condition(Negate(Subst(Int(Power(Times(Power(x, Plus(m, C2)), Plus(d, Times(d, ProductLog(Times(a, Power(Power(x, n), CN1)))))), CN1), x), x, Power(x, CN1))), And(FreeQ(List(a, d), x), IntegerQ(m), ILtQ(n, C0), NeQ(m, CN1))));
            IIntegrate(6646, Int(Times(Power(x_, CN1), Power(Times(c_DEFAULT, ProductLog(Times(a_DEFAULT, Power(x_, n_DEFAULT)))), p_DEFAULT), Power(Plus(d_, Times(d_DEFAULT, ProductLog(Times(a_DEFAULT, Power(x_, n_DEFAULT))))), CN1)), x_Symbol),
                    Condition(Simp(Times(Power(Times(c, ProductLog(Times(a, Power(x, n)))), p), Power(Times(d, n, p), CN1)), x), FreeQ(List(a, c, d, n, p), x)));
            IIntegrate(6647, Int(Times(Power(x_, m_DEFAULT), Power(Times(c_DEFAULT, ProductLog(Times(a_DEFAULT, Power(x_, n_DEFAULT)))), p_DEFAULT), Power(Plus(d_, Times(d_DEFAULT, ProductLog(Times(a_DEFAULT, Power(x_, n_DEFAULT))))), CN1)), x_Symbol),
                    Condition(Simp(Times(c, Power(x, Plus(m, C1)), Power(Times(c, ProductLog(Times(a, Power(x, n)))), Subtract(p, C1)), Power(Times(d, Plus(m, C1)), CN1)), x), And(FreeQ(List(a, c, d, m, n, p), x), NeQ(m, CN1), EqQ(Plus(m, Times(n, Subtract(p, C1))), CN1))));
            IIntegrate(6648, Int(Times(Power(x_, m_DEFAULT), Power(ProductLog(Times(a_DEFAULT, Power(x_, n_DEFAULT))), p_DEFAULT), Power(Plus(d_, Times(d_DEFAULT, ProductLog(Times(a_DEFAULT, Power(x_, n_DEFAULT))))), CN1)), x_Symbol),
                    Condition(Simp(Times(Power(a, p), ExpIntegralEi(Times(CN1, p, ProductLog(Times(a, Power(x, n))))), Power(Times(d, n), CN1)), x), And(FreeQ(List(a, d, m, n), x), IntegerQ(p), EqQ(Plus(m, Times(n, p)), CN1))));
            IIntegrate(6649, Int(Times(Power(x_, m_DEFAULT), Power(Times(c_DEFAULT, ProductLog(Times(a_DEFAULT, Power(x_, n_DEFAULT)))), p_), Power(Plus(d_, Times(d_DEFAULT, ProductLog(Times(a_DEFAULT, Power(x_, n_DEFAULT))))), CN1)), x_Symbol),
                    Condition(Simp(Times(Power(a, Subtract(p, C1D2)), Power(c, Subtract(p, C1D2)), Rt(Times(Pi, c, Power(Subtract(p, C1D2), CN1)), C2), Erf(Times(Sqrt(Times(c, ProductLog(Times(a, Power(x, n))))), Power(Rt(Times(c, Power(Subtract(p, C1D2), CN1)), C2), CN1))), Power(Times(d, n), CN1)), x), And(FreeQ(List(a, c, d, m, n), x), NeQ(m, CN1), IntegerQ(Subtract(p, C1D2)), EqQ(Plus(m, Times(n, Subtract(p, C1D2))), CN1), PosQ(Times(c, Power(Subtract(p, C1D2), CN1))))));
            IIntegrate(6650, Int(Times(Power(x_, m_DEFAULT), Power(Times(c_DEFAULT, ProductLog(Times(a_DEFAULT, Power(x_, n_DEFAULT)))), p_), Power(Plus(d_, Times(d_DEFAULT, ProductLog(Times(a_DEFAULT, Power(x_, n_DEFAULT))))), CN1)), x_Symbol),
                    Condition(Simp(Times(Power(a, Subtract(p, C1D2)), Power(c, Subtract(p, C1D2)), Rt(Times(CN1, Pi, c, Power(Subtract(p, C1D2), CN1)), C2), Erfi(Times(Sqrt(Times(c, ProductLog(Times(a, Power(x, n))))), Power(Rt(Times(CN1, c, Power(Subtract(p, C1D2), CN1)), C2), CN1))), Power(Times(d, n), CN1)), x), And(FreeQ(List(a, c, d, m, n), x), NeQ(m, CN1), IntegerQ(Subtract(p, C1D2)), EqQ(Plus(m, Times(n, Subtract(p, C1D2))), CN1), NegQ(Times(c, Power(Subtract(p, C1D2), CN1))))));
        }
    }
}
