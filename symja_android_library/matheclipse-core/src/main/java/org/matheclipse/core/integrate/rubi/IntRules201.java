package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcCot;
import static org.matheclipse.core.expression.F.ArcTan;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CI;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.MatchQ;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
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
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules201 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(5026, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, x_)), b_DEFAULT)), p_DEFAULT), u_DEFAULT), x_Symbol),
                    Condition(Unintegrable(Times(u, Power(Plus(a, Times(b, ArcCot(Times(c, x)))), p)), x), And(FreeQ(List(a, b, c, p), x), Or(EqQ(u, C1), MatchQ(u, Condition(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x)), q_DEFAULT), FreeQ(List(d, e, q), x))), MatchQ(u, Condition(Times(Power(Times(f_DEFAULT, x), m_DEFAULT), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x)), q_DEFAULT)), FreeQ(List(d, e, f, m, q), x))), MatchQ(u, Condition(Power(Plus(d_DEFAULT, Times(e_DEFAULT, Sqr(x))), q_DEFAULT), FreeQ(List(d, e, q), x))), MatchQ(u, Condition(Times(Power(Times(f_DEFAULT, x), m_DEFAULT), Power(Plus(d_DEFAULT, Times(e_DEFAULT, Sqr(x))), q_DEFAULT)), FreeQ(List(d, e, f, m, q), x)))))));
            IIntegrate(5027, Int(ArcTan(Times(c_DEFAULT, Power(x_, n_))), x_Symbol),
                    Condition(Subtract(Simp(Times(x, ArcTan(Times(c, Power(x, n)))), x), Dist(Times(c, n), Int(Times(Power(x, n), Power(Plus(C1, Times(Sqr(c), Power(x, Times(C2, n)))), CN1)), x), x)), FreeQ(List(c, n), x)));
            IIntegrate(5028, Int(ArcCot(Times(c_DEFAULT, Power(x_, n_))), x_Symbol),
                    Condition(Plus(Simp(Times(x, ArcCot(Times(c, Power(x, n)))), x), Dist(Times(c, n), Int(Times(Power(x, n), Power(Plus(C1, Times(Sqr(c), Power(x, Times(C2, n)))), CN1)), x), x)), FreeQ(List(c, n), x)));
            IIntegrate(5029, Int(Power(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Subtract(Plus(a, Times(C1D2, CI, b, Log(Subtract(C1, Times(CI, c, Power(x, n)))))), Times(C1D2, CI, b, Log(Plus(C1, Times(CI, c, Power(x, n)))))), p), x), x), And(FreeQ(List(a, b, c, n), x), IGtQ(p, C0), IntegerQ(n))));
            IIntegrate(5030, Int(Power(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Subtract(Plus(a, Times(C1D2, CI, b, Log(Subtract(C1, Times(CI, Power(Times(Power(x, n), c), CN1)))))), Times(C1D2, CI, b, Log(Plus(C1, Times(CI, Power(Times(Power(x, n), c), CN1)))))), p), x), x), And(FreeQ(List(a, b, c, n), x), IGtQ(p, C0), IntegerQ(n))));
            IIntegrate(5031, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, Power(x_, n_))), b_DEFAULT)), p_DEFAULT), Power(x_, CN1)), x_Symbol),
                    Condition(Dist(Power(n, CN1), Subst(Int(Times(Power(Plus(a, Times(b, ArcTan(Times(c, x)))), p), Power(x, CN1)), x), x, Power(x, n)), x), And(FreeQ(List(a, b, c, n), x), IGtQ(p, C0))));
            IIntegrate(5032, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, Power(x_, n_))), b_DEFAULT)), p_DEFAULT), Power(x_, CN1)), x_Symbol),
                    Condition(Dist(Power(n, CN1), Subst(Int(Times(Power(Plus(a, Times(b, ArcCot(Times(c, x)))), p), Power(x, CN1)), x), x, Power(x, n)), x), And(FreeQ(List(a, b, c, n), x), IGtQ(p, C0))));
            IIntegrate(5033, Int(Times(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, Power(x_, n_))), b_DEFAULT)), Power(Times(d_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(d, x), Plus(m, C1)), Plus(a, Times(b, ArcTan(Times(c, Power(x, n))))), Power(Times(d, Plus(m, C1)), CN1)), x), Dist(Times(b, c, n, Power(Times(d, Plus(m, C1)), CN1)), Int(Times(Power(x, Subtract(n, C1)), Power(Times(d, x), Plus(m, C1)), Power(Plus(C1, Times(Sqr(c), Power(x, Times(C2, n)))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, m, n), x), NeQ(m, CN1))));
            IIntegrate(5034, Int(Times(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, Power(x_, n_))), b_DEFAULT)), Power(Times(d_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(d, x), Plus(m, C1)), Plus(a, Times(b, ArcCot(Times(c, Power(x, n))))), Power(Times(d, Plus(m, C1)), CN1)), x), Dist(Times(b, c, n, Power(Times(d, Plus(m, C1)), CN1)), Int(Times(Power(x, Subtract(n, C1)), Power(Times(d, x), Plus(m, C1)), Power(Plus(C1, Times(Sqr(c), Power(x, Times(C2, n)))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, m, n), x), NeQ(m, CN1))));
            IIntegrate(5035, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(Times(d_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Times(d, x), m), Power(Subtract(Plus(a, Times(C1D2, CI, b, Log(Subtract(C1, Times(CI, c, Power(x, n)))))), Times(C1D2, CI, b, Log(Plus(C1, Times(CI, c, Power(x, n)))))), p)), x), x), And(FreeQ(List(a, b, c, d, m, n), x), IGtQ(p, C0), IntegerQ(m), IntegerQ(n))));
            IIntegrate(5036, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, Power(x_, n_DEFAULT))), b_DEFAULT)), p_DEFAULT), Power(Times(d_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Times(d, x), m), Power(Subtract(Plus(a, Times(C1D2, CI, b, Log(Subtract(C1, Times(CI, Power(Times(Power(x, n), c), CN1)))))), Times(C1D2, CI, b, Log(Plus(C1, Times(CI, Power(Times(Power(x, n), c), CN1)))))), p)), x), x), And(FreeQ(List(a, b, c, d, m, n), x), IGtQ(p, C0), IntegerQ(m), IntegerQ(n))));
            IIntegrate(5037, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTan(Times(c_DEFAULT, Power(x_, n_))), b_DEFAULT)), p_DEFAULT), u_DEFAULT), x_Symbol),
                    Condition(Unintegrable(Times(u, Power(Plus(a, Times(b, ArcTan(Times(c, Power(x, n))))), p)), x), And(FreeQ(List(a, b, c, n, p), x), Or(EqQ(u, C1), MatchQ(u, Condition(Power(Times(d_DEFAULT, x), m_DEFAULT), FreeQ(List(d, m), x)))))));
            IIntegrate(5038, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCot(Times(c_DEFAULT, Power(x_, n_))), b_DEFAULT)), p_DEFAULT), u_DEFAULT), x_Symbol),
                    Condition(Unintegrable(Times(u, Power(Plus(a, Times(b, ArcCot(Times(c, Power(x, n))))), p)), x), And(FreeQ(List(a, b, c, n, p), x), Or(EqQ(u, C1), MatchQ(u, Condition(Power(Times(d_DEFAULT, x), m_DEFAULT), FreeQ(List(d, m), x)))))));
            IIntegrate(5039, Int(Power(Plus(a_DEFAULT, Times(ArcTan(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Power(d, CN1), Subst(Int(Power(Plus(a, Times(b, ArcTan(x))), p), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d), x), IGtQ(p, C0))));
            IIntegrate(5040, Int(Power(Plus(a_DEFAULT, Times(ArcCot(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Power(d, CN1), Subst(Int(Power(Plus(a, Times(b, ArcCot(x))), p), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d), x), IGtQ(p, C0))));
            IIntegrate(5041, Int(Power(Plus(a_DEFAULT, Times(ArcTan(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_), x_Symbol),
                    Condition(Unintegrable(Power(Plus(a, Times(b, ArcTan(Plus(c, Times(d, x))))), p), x), And(FreeQ(List(a, b, c, d, p), x), Not(IGtQ(p, C0)))));
            IIntegrate(5042, Int(Power(Plus(a_DEFAULT, Times(ArcCot(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_), x_Symbol),
                    Condition(Unintegrable(Power(Plus(a, Times(b, ArcCot(Plus(c, Times(d, x))))), p), x), And(FreeQ(List(a, b, c, d, p), x), Not(IGtQ(p, C0)))));
            IIntegrate(5043, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTan(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, CN1), Subst(Int(Times(Power(Times(f, x, Power(d, CN1)), m), Power(Plus(a, Times(b, ArcTan(x))), p)), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d, e, f, m), x), EqQ(Subtract(Times(d, e), Times(c, f)), C0), IGtQ(p, C0))));
            IIntegrate(5044, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCot(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, CN1), Subst(Int(Times(Power(Times(f, x, Power(d, CN1)), m), Power(Plus(a, Times(b, ArcCot(x))), p)), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d, e, f, m), x), EqQ(Subtract(Times(d, e), Times(c, f)), C0), IGtQ(p, C0))));
            IIntegrate(5045, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTan(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Power(Plus(a, Times(b, ArcTan(Plus(c, Times(d, x))))), p), Power(Times(f, Plus(m, C1)), CN1)), x), Dist(Times(b, d, p, Power(Times(f, Plus(m, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Power(Plus(a, Times(b, ArcTan(Plus(c, Times(d, x))))), Subtract(p, C1)), Power(Plus(C1, Sqr(Plus(c, Times(d, x)))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(p, C0), ILtQ(m, CN1))));
            IIntegrate(5046, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCot(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Power(Plus(a, Times(b, ArcCot(Plus(c, Times(d, x))))), p), Power(Times(f, Plus(m, C1)), CN1)), x), Dist(Times(b, d, p, Power(Times(f, Plus(m, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Plus(m, C1)), Power(Plus(a, Times(b, ArcCot(Plus(c, Times(d, x))))), Subtract(p, C1)), Power(Plus(C1, Sqr(Plus(c, Times(d, x)))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(p, C0), ILtQ(m, CN1))));
            IIntegrate(5047, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTan(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, CN1), Subst(Int(Times(Power(Plus(Times(Subtract(Times(d, e), Times(c, f)), Power(d, CN1)), Times(f, x, Power(d, CN1))), m), Power(Plus(a, Times(b, ArcTan(x))), p)), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d, e, f, m, p), x), IGtQ(p, C0))));
            IIntegrate(5048, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCot(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, CN1), Subst(Int(Times(Power(Plus(Times(Subtract(Times(d, e), Times(c, f)), Power(d, CN1)), Times(f, x, Power(d, CN1))), m), Power(Plus(a, Times(b, ArcCot(x))), p)), x), x, Plus(c, Times(d, x))), x), And(FreeQ(List(a, b, c, d, e, f, m, p), x), IGtQ(p, C0))));
            IIntegrate(5049, Int(Times(Power(Plus(a_DEFAULT, Times(ArcTan(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(e, Times(f, x)), m), Power(Plus(a, Times(b, ArcTan(Plus(c, Times(d, x))))), p)), x), And(FreeQ(List(a, b, c, d, e, f, m, p), x), Not(IGtQ(p, C0)))));
            IIntegrate(5050, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCot(Plus(c_, Times(d_DEFAULT, x_))), b_DEFAULT)), p_), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(e, Times(f, x)), m), Power(Plus(a, Times(b, ArcCot(Plus(c, Times(d, x))))), p)), x), And(FreeQ(List(a, b, c, d, e, f, m, p), x), Not(IGtQ(p, C0)))));
        }
    }
}
