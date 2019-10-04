package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcTan;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C1D3;
import static org.matheclipse.core.expression.F.C1D4;
import static org.matheclipse.core.expression.F.C1DSqrt3;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.C5;
import static org.matheclipse.core.expression.F.C6;
import static org.matheclipse.core.expression.F.C7;
import static org.matheclipse.core.expression.F.C8;
import static org.matheclipse.core.expression.F.C9;
import static org.matheclipse.core.expression.F.CI;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN1D3;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.CN3;
import static org.matheclipse.core.expression.F.CN6;
import static org.matheclipse.core.expression.F.CSqrt2;
import static org.matheclipse.core.expression.F.CSqrt3;
import static org.matheclipse.core.expression.F.Coefficient;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.QQ;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Simplify;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.ZZ;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.a_DEFAULT;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.g_;
import static org.matheclipse.core.expression.F.g_DEFAULT;
import static org.matheclipse.core.expression.F.h;
import static org.matheclipse.core.expression.F.h_DEFAULT;
import static org.matheclipse.core.expression.F.i;
import static org.matheclipse.core.expression.F.i_DEFAULT;
import static org.matheclipse.core.expression.F.j;
import static org.matheclipse.core.expression.F.j_DEFAULT;
import static org.matheclipse.core.expression.F.k;
import static org.matheclipse.core.expression.F.k_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.w;
import static org.matheclipse.core.expression.F.w_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearMatchQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.QuadraticMatchQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.QuadraticQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules85 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(2126, Int(Times(Power(Plus(g_, Times(i_DEFAULT, Sqr(x_))), m_DEFAULT), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqrt(Plus(a_, Times(c_DEFAULT, Sqr(x_)))))), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Times(i, Power(c, CN1)), Plus(m, C1D2)), Sqrt(Plus(a, Times(c, Sqr(x)))), Power(Plus(g, Times(i, Sqr(x))), CN1D2)), Int(Times(Power(Plus(a, Times(c, Sqr(x))), m), Power(Plus(d, Times(e, x), Times(f, Sqrt(Plus(a, Times(c, Sqr(x)))))), n)), x), x), And(FreeQ(List(a, c, d, e, f, g, i, n), x), EqQ(Subtract(Sqr(e), Times(c, Sqr(f))), C0), EqQ(Subtract(Times(c, g), Times(a, i)), C0), ILtQ(Subtract(m, C1D2), C0), Not(GtQ(Times(i, Power(c, CN1)), C0)))));
            IIntegrate(2127, Int(Times(Power(Plus(u_, Times(f_DEFAULT, Plus(j_DEFAULT, Times(k_DEFAULT, Sqrt(v_))))), n_DEFAULT), Power(w_, m_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(ExpandToSum(w, x), m), Power(Plus(ExpandToSum(Plus(u, Times(f, j)), x), Times(f, k, Sqrt(ExpandToSum(v, x)))), n)), x), And(FreeQ(List(f, j, k, m, n), x), LinearQ(u, x), QuadraticQ(List(v, w), x), Not(And(LinearMatchQ(u, x), QuadraticMatchQ(List(v, w), x), Or(EqQ(j, C0), EqQ(f, C1)))), EqQ(Subtract(Sqr(Coefficient(u, x, C1)), Times(Coefficient(v, x, C2), Sqr(f), Sqr(k))), C0))));
            IIntegrate(2128, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_DEFAULT))), CN1), Power(Plus(Times(c_DEFAULT, Sqr(x_)), Times(d_DEFAULT, Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_DEFAULT))), p_DEFAULT))), CN1D2)), x_Symbol),
                    Condition(Dist(Power(a, CN1), Subst(Int(Power(Subtract(C1, Times(c, Sqr(x))), CN1), x), x, Times(x, Power(Plus(Times(c, Sqr(x)), Times(d, Power(Plus(a, Times(b, Power(x, n))), Times(C2, Power(n, CN1))))), CN1D2))), x), And(FreeQ(List(a, b, c, d, n), x), EqQ(p, Times(C2, Power(n, CN1))))));
            IIntegrate(2129, Int(Sqrt(Plus(a_, Times(b_DEFAULT, Sqrt(Plus(c_, Times(d_DEFAULT, Sqr(x_))))))), x_Symbol),
                    Condition(Plus(Simp(Times(C2, Sqr(b), d, Power(x, C3), Power(Times(C3, Power(Plus(a, Times(b, Sqrt(Plus(c, Times(d, Sqr(x)))))), QQ(3L, 2L))), CN1)), x), Simp(Times(C2, a, x, Power(Plus(a, Times(b, Sqrt(Plus(c, Times(d, Sqr(x)))))), CN1D2)), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Subtract(Sqr(a), Times(Sqr(b), c)), C0))));
            IIntegrate(2130, Int(Times(Power(x_, CN1), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1D2), Sqrt(Plus(Times(a_DEFAULT, Sqr(x_)), Times(b_DEFAULT, x_, Sqrt(Plus(c_, Times(d_DEFAULT, Sqr(x_)))))))), x_Symbol),
                    Condition(Dist(Times(CSqrt2, b, Power(a, CN1)), Subst(Int(Power(Plus(C1, Times(Sqr(x), Power(a, CN1))), CN1D2), x), x, Plus(Times(a, x), Times(b, Sqrt(Plus(c, Times(d, Sqr(x))))))), x), And(FreeQ(List(a, b, c, d), x), EqQ(Subtract(Sqr(a), Times(Sqr(b), d)), C0), EqQ(Plus(Times(Sqr(b), c), a), C0))));
            IIntegrate(2131, Int(Times(Power(x_, CN1), Power(Plus(c_, Times(d_DEFAULT, Sqr(x_))), CN1D2), Sqrt(Times(e_DEFAULT, x_, Plus(Times(a_DEFAULT, x_), Times(b_DEFAULT, Sqrt(Plus(c_, Times(d_DEFAULT, Sqr(x_))))))))), x_Symbol),
                    Condition(Int(Times(Sqrt(Plus(Times(a, e, Sqr(x)), Times(b, e, x, Sqrt(Plus(c, Times(d, Sqr(x))))))), Power(Times(x, Sqrt(Plus(c, Times(d, Sqr(x))))), CN1)), x), And(FreeQ(List(a, b, c, d, e), x), EqQ(Subtract(Sqr(a), Times(Sqr(b), d)), C0), EqQ(Plus(Times(Sqr(b), c, e), a), C0))));
            IIntegrate(2132, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(x_, C4))), CN1D2), Sqrt(Plus(Times(c_DEFAULT, Sqr(x_)), Times(d_DEFAULT, Sqrt(Plus(a_, Times(b_DEFAULT, Power(x_, C4)))))))), x_Symbol),
                    Condition(Dist(d, Subst(Int(Power(Subtract(C1, Times(C2, c, Sqr(x))), CN1), x), x, Times(x, Power(Plus(Times(c, Sqr(x)), Times(d, Sqrt(Plus(a, Times(b, Power(x, C4)))))), CN1D2))), x), And(FreeQ(List(a, b, c, d), x), EqQ(Subtract(Sqr(c), Times(b, Sqr(d))), C0))));
            IIntegrate(2133, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_, Times(e_DEFAULT, Power(x_, C4))), CN1D2), Sqrt(Plus(Times(b_DEFAULT, Sqr(x_)), Sqrt(Plus(a_, Times(e_DEFAULT, Power(x_, C4))))))), x_Symbol),
                    Condition(Plus(Dist(Times(C1D2, Subtract(C1, CI)), Int(Times(Power(Plus(c, Times(d, x)), m), Power(Subtract(Sqrt(a), Times(CI, b, Sqr(x))), CN1D2)), x), x), Dist(Times(C1D2, Plus(C1, CI)), Int(Times(Power(Plus(c, Times(d, x)), m), Power(Plus(Sqrt(a), Times(CI, b, Sqr(x))), CN1D2)), x), x)), And(FreeQ(List(a, b, c, d, m), x), EqQ(e, Sqr(b)), GtQ(a, C0))));
            IIntegrate(2134, Int(Times(Power(Plus(c_, Times(d_DEFAULT, x_)), CN1), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1D2)), x_Symbol),
                    Condition(Plus(Dist(Times(C2, Power(Times(C3, c), CN1)), Int(Power(Plus(a, Times(b, Power(x, C3))), CN1D2), x), x), Dist(Power(Times(C3, c), CN1), Int(Times(Subtract(c, Times(C2, d, x)), Power(Times(Plus(c, Times(d, x)), Sqrt(Plus(a, Times(b, Power(x, C3))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Subtract(Times(b, Power(c, C3)), Times(C4, a, Power(d, C3))), C0))));
            IIntegrate(2135, Int(Times(Power(Plus(c_, Times(d_DEFAULT, x_)), CN1), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1D2)), x_Symbol),
                    Condition(Plus(Dist(Times(CN6, a, Power(d, C3), Power(Times(c, Subtract(Times(b, Power(c, C3)), Times(ZZ(28L), a, Power(d, C3)))), CN1)), Int(Power(Plus(a, Times(b, Power(x, C3))), CN1D2), x), x), Dist(Power(Times(c, Subtract(Times(b, Power(c, C3)), Times(ZZ(28L), a, Power(d, C3)))), CN1), Int(Times(Simp(Plus(Times(c, Subtract(Times(b, Power(c, C3)), Times(ZZ(22L), a, Power(d, C3)))), Times(C6, a, Power(d, C4), x)), x), Power(Times(Plus(c, Times(d, x)), Sqrt(Plus(a, Times(b, Power(x, C3))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Subtract(Subtract(Times(Sqr(b), Power(c, C6)), Times(ZZ(20L), a, b, Power(c, C3), Power(d, C3))), Times(C8, Sqr(a), Power(d, C6))), C0))));
            IIntegrate(2136, Int(Times(Power(Plus(c_, Times(d_DEFAULT, x_)), CN1), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(b, Power(a, CN1)), C3))), Plus(Negate(Dist(Times(q, Power(Subtract(Times(Plus(C1, CSqrt3), d), Times(c, q)), CN1)), Int(Power(Plus(a, Times(b, Power(x, C3))), CN1D2), x), x)), Dist(Times(d, Power(Subtract(Times(Plus(C1, CSqrt3), d), Times(c, q)), CN1)), Int(Times(Plus(C1, CSqrt3, Times(q, x)), Power(Times(Plus(c, Times(d, x)), Sqrt(Plus(a, Times(b, Power(x, C3))))), CN1)), x), x))), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Subtract(Times(Sqr(b), Power(c, C6)), Times(ZZ(20L), a, b, Power(c, C3), Power(d, C3))), Times(C8, Sqr(a), Power(d, C6))), C0))));
            IIntegrate(2137, Int(Times(Power(Plus(c_, Times(d_DEFAULT, x_)), CN1), Plus(e_, Times(f_DEFAULT, x_)), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(C2, e, Power(d, CN1)), Subst(Int(Power(Plus(C1, Times(C3, a, Sqr(x))), CN1), x), x, Times(Plus(C1, Times(C2, d, x, Power(c, CN1))), Power(Plus(a, Times(b, Power(x, C3))), CN1D2))), x), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(d, e), Times(c, f)), C0), EqQ(Subtract(Times(b, Power(c, C3)), Times(C4, a, Power(d, C3))), C0), EqQ(Plus(Times(C2, d, e), Times(c, f)), C0))));
            IIntegrate(2138, Int(Times(Power(Plus(c_, Times(d_DEFAULT, x_)), CN1), Plus(e_, Times(f_DEFAULT, x_)), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(CN2, e, Power(d, CN1)), Subst(Int(Power(Subtract(C9, Times(a, Sqr(x))), CN1), x), x, Times(Sqr(Plus(C1, Times(f, x, Power(e, CN1)))), Power(Plus(a, Times(b, Power(x, C3))), CN1D2))), x), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(d, e), Times(c, f)), C0), EqQ(Plus(Times(b, Power(c, C3)), Times(C8, a, Power(d, C3))), C0), EqQ(Plus(Times(C2, d, e), Times(c, f)), C0))));
            IIntegrate(2139, Int(Times(Power(Plus(c_, Times(d_DEFAULT, x_)), CN1), Plus(e_DEFAULT, Times(f_DEFAULT, x_)), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1D2)), x_Symbol),
                    Condition(Plus(Dist(Times(Plus(Times(C2, d, e), Times(c, f)), Power(Times(C3, c, d), CN1)), Int(Power(Plus(a, Times(b, Power(x, C3))), CN1D2), x), x), Dist(Times(Subtract(Times(d, e), Times(c, f)), Power(Times(C3, c, d), CN1)), Int(Times(Subtract(c, Times(C2, d, x)), Power(Times(Plus(c, Times(d, x)), Sqrt(Plus(a, Times(b, Power(x, C3))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(d, e), Times(c, f)), C0), Or(EqQ(Subtract(Times(b, Power(c, C3)), Times(C4, a, Power(d, C3))), C0), EqQ(Plus(Times(b, Power(c, C3)), Times(C8, a, Power(d, C3))), C0)), NeQ(Plus(Times(C2, d, e), Times(c, f)), C0))));
            IIntegrate(2140, Int(Times(Power(Plus(c_, Times(d_DEFAULT, x_)), CN1), Plus(e_, Times(f_DEFAULT, x_)), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(k, Simplify(Times(Plus(Times(d, e), Times(C2, c, f)), Power(Times(c, f), CN1))))), Dist(Times(Plus(C1, k), e, Power(d, CN1)), Subst(Int(Power(Plus(C1, Times(Plus(C3, Times(C2, k)), a, Sqr(x))), CN1), x), x, Times(Plus(C1, Times(Plus(C1, k), d, x, Power(c, CN1))), Power(Plus(a, Times(b, Power(x, C3))), CN1D2))), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(d, e), Times(c, f)), C0), EqQ(Subtract(Subtract(Times(Sqr(b), Power(c, C6)), Times(ZZ(20L), a, b, Power(c, C3), Power(d, C3))), Times(C8, Sqr(a), Power(d, C6))), C0), EqQ(Subtract(Times(C6, a, Power(d, C4), e), Times(c, f, Subtract(Times(b, Power(c, C3)), Times(ZZ(22L), a, Power(d, C3))))), C0))));
            IIntegrate(2141, Int(Times(Power(Plus(c_, Times(d_DEFAULT, x_)), CN1), Plus(e_DEFAULT, Times(f_DEFAULT, x_)), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1D2)), x_Symbol),
                    Condition(Plus(Negate(Dist(Times(Subtract(Times(C6, a, Power(d, C4), e), Times(c, f, Subtract(Times(b, Power(c, C3)), Times(ZZ(22L), a, Power(d, C3))))), Power(Times(c, d, Subtract(Times(b, Power(c, C3)), Times(ZZ(28L), a, Power(d, C3)))), CN1)), Int(Power(Plus(a, Times(b, Power(x, C3))), CN1D2), x), x)), Dist(Times(Subtract(Times(d, e), Times(c, f)), Power(Times(c, d, Subtract(Times(b, Power(c, C3)), Times(ZZ(28L), a, Power(d, C3)))), CN1)), Int(Times(Plus(Times(c, Subtract(Times(b, Power(c, C3)), Times(ZZ(22L), a, Power(d, C3)))), Times(C6, a, Power(d, C4), x)), Power(Times(Plus(c, Times(d, x)), Sqrt(Plus(a, Times(b, Power(x, C3))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(d, e), Times(c, f)), C0), EqQ(Subtract(Subtract(Times(Sqr(b), Power(c, C6)), Times(ZZ(20L), a, b, Power(c, C3), Power(d, C3))), Times(C8, Sqr(a), Power(d, C6))), C0), NeQ(Subtract(Times(C6, a, Power(d, C4), e), Times(c, f, Subtract(Times(b, Power(c, C3)), Times(ZZ(22L), a, Power(d, C3))))), C0))));
            IIntegrate(2142, Int(Times(Power(Plus(c_, Times(d_DEFAULT, x_)), CN1), Plus(e_, Times(f_DEFAULT, x_)), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Simplify(Times(Plus(C1, CSqrt3), f, Power(e, CN1))))), Dist(Times(C4, Power(C3, C1D4), Sqrt(Subtract(C2, CSqrt3)), f, Plus(C1, Times(q, x)), Sqrt(Times(Plus(C1, Times(CN1, q, x), Times(Sqr(q), Sqr(x))), Power(Plus(C1, CSqrt3, Times(q, x)), CN2))), Power(Times(q, Sqrt(Plus(a, Times(b, Power(x, C3)))), Sqrt(Times(Plus(C1, Times(q, x)), Power(Plus(C1, CSqrt3, Times(q, x)), CN2)))), CN1)), Subst(Int(Power(Times(Plus(Times(Subtract(C1, CSqrt3), d), Times(CN1, c, q), Times(Subtract(Times(Plus(C1, CSqrt3), d), Times(c, q)), x)), Sqrt(Subtract(C1, Sqr(x))), Sqrt(Plus(C7, Times(CN1, C4, CSqrt3), Sqr(x)))), CN1), x), x, Times(Subtract(Plus(CN1, CSqrt3), Times(q, x)), Power(Plus(C1, CSqrt3, Times(q, x)), CN1))), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(d, e), Times(c, f)), C0), EqQ(Subtract(Times(b, Power(e, C3)), Times(C2, Plus(C5, Times(C3, CSqrt3)), a, Power(f, C3))), C0), NeQ(Subtract(Times(b, Power(c, C3)), Times(C2, Subtract(C5, Times(C3, CSqrt3)), a, Power(d, C3))), C0))));
            IIntegrate(2143, Int(Times(Power(Plus(c_, Times(d_DEFAULT, x_)), CN1), Plus(e_, Times(f_DEFAULT, x_)), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Simplify(Times(Plus(CN1, CSqrt3), f, Power(e, CN1))))), Dist(Times(C4, Power(C3, C1D4), Sqrt(Plus(C2, CSqrt3)), f, Subtract(C1, Times(q, x)), Sqrt(Times(Plus(C1, Times(q, x), Times(Sqr(q), Sqr(x))), Power(Subtract(Subtract(C1, CSqrt3), Times(q, x)), CN2))), Power(Times(q, Sqrt(Plus(a, Times(b, Power(x, C3)))), Sqrt(Times(CN1, Subtract(C1, Times(q, x)), Power(Subtract(Subtract(C1, CSqrt3), Times(q, x)), CN2)))), CN1)), Subst(Int(Power(Times(Plus(Times(Plus(C1, CSqrt3), d), Times(c, q), Times(Plus(Times(Subtract(C1, CSqrt3), d), Times(c, q)), x)), Sqrt(Subtract(C1, Sqr(x))), Sqrt(Plus(C7, Times(C4, CSqrt3), Sqr(x)))), CN1), x), x, Times(Subtract(Plus(C1, CSqrt3), Times(q, x)), Power(Plus(CN1, CSqrt3, Times(q, x)), CN1))), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(d, e), Times(c, f)), C0), EqQ(Subtract(Times(b, Power(e, C3)), Times(C2, Subtract(C5, Times(C3, CSqrt3)), a, Power(f, C3))), C0), NeQ(Subtract(Times(b, Power(c, C3)), Times(C2, Plus(C5, Times(C3, CSqrt3)), a, Power(d, C3))), C0))));
            IIntegrate(2144, Int(Times(Power(Plus(c_, Times(d_DEFAULT, x_)), CN1), Plus(e_DEFAULT, Times(f_DEFAULT, x_)), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(b, Power(a, CN1)), C3))), Plus(Dist(Times(Subtract(Times(Plus(C1, CSqrt3), f), Times(e, q)), Power(Subtract(Times(Plus(C1, CSqrt3), d), Times(c, q)), CN1)), Int(Power(Plus(a, Times(b, Power(x, C3))), CN1D2), x), x), Dist(Times(Subtract(Times(d, e), Times(c, f)), Power(Subtract(Times(Plus(C1, CSqrt3), d), Times(c, q)), CN1)), Int(Times(Plus(C1, CSqrt3, Times(q, x)), Power(Times(Plus(c, Times(d, x)), Sqrt(Plus(a, Times(b, Power(x, C3))))), CN1)), x), x))), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Times(d, e), Times(c, f)), C0), NeQ(Subtract(Subtract(Times(Sqr(b), Power(c, C6)), Times(ZZ(20L), a, b, Power(c, C3), Power(d, C3))), Times(C8, Sqr(a), Power(d, C6))), C0), NeQ(Subtract(Subtract(Times(Sqr(b), Power(e, C6)), Times(ZZ(20L), a, b, Power(e, C3), Power(f, C3))), Times(C8, Sqr(a), Power(f, C6))), C0))));
            IIntegrate(2145, Int(Times(Power(Plus(c_, Times(d_DEFAULT, x_), Times(e_DEFAULT, Sqr(x_))), CN1), Plus(f_, Times(g_DEFAULT, x_), Times(h_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(CN2, g, h), Subst(Int(Power(Subtract(Times(C2, e, h), Times(Subtract(Times(b, d, f), Times(C2, a, e, h)), Sqr(x))), CN1), x), x, Times(Plus(C1, Times(C2, h, x, Power(g, CN1))), Power(Plus(a, Times(b, Power(x, C3))), CN1D2))), x), And(FreeQ(List(a, b, c, d, e, f, g, h), x), NeQ(Subtract(Times(b, d, f), Times(C2, a, e, h)), C0), EqQ(Subtract(Times(b, Power(g, C3)), Times(C8, a, Power(h, C3))), C0), EqQ(Plus(Sqr(g), Times(C2, f, h)), C0), EqQ(Subtract(Plus(Times(b, d, f), Times(b, c, g)), Times(C4, a, e, h)), C0))));
            IIntegrate(2146, Int(Times(Power(Plus(c_, Times(e_DEFAULT, Sqr(x_))), CN1), Plus(f_, Times(g_DEFAULT, x_), Times(h_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1D2)), x_Symbol),
                    Condition(Negate(Dist(Times(g, Power(e, CN1)), Subst(Int(Power(Plus(C1, Times(a, Sqr(x))), CN1), x), x, Times(Plus(C1, Times(C2, h, x, Power(g, CN1))), Power(Plus(a, Times(b, Power(x, C3))), CN1D2))), x)), And(FreeQ(List(a, b, c, e, f, g, h), x), EqQ(Subtract(Times(b, Power(g, C3)), Times(C8, a, Power(h, C3))), C0), EqQ(Plus(Sqr(g), Times(C2, f, h)), C0), EqQ(Subtract(Times(b, c, g), Times(C4, a, e, h)), C0))));
            IIntegrate(2147, Int(Times(Power(Plus(c_, Times(d_DEFAULT, x_)), CN1), Sqrt(Plus(a_, Times(b_DEFAULT, Power(x_, C3))))), x_Symbol),
                    Condition(Plus(Dist(Times(b, Power(d, CN1)), Int(Times(Sqr(x), Power(Plus(a, Times(b, Power(x, C3))), CN1D2)), x), x), Dist(Times(b, c, Power(d, CN3)), Int(Times(Subtract(c, Times(d, x)), Power(Plus(a, Times(b, Power(x, C3))), CN1D2)), x), x), Negate(Dist(Times(Subtract(Times(b, Power(c, C3)), Times(a, Power(d, C3))), Power(d, CN3)), Int(Power(Times(Plus(c, Times(d, x)), Sqrt(Plus(a, Times(b, Power(x, C3))))), CN1), x), x))), FreeQ(List(a, b, c, d), x)));
            IIntegrate(2148, Int(Times(Power(Plus(c_, Times(d_DEFAULT, x_)), CN1), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1D3)), x_Symbol),
                    Condition(Plus(Simp(Times(CSqrt3, ArcTan(Times(Subtract(C1, Times(Power(C2, C1D3), Rt(b, C3), Subtract(c, Times(d, x)), Power(Times(d, Power(Plus(a, Times(b, Power(x, C3))), C1D3)), CN1))), C1DSqrt3)), Power(Times(Power(C2, QQ(4L, 3L)), Rt(b, C3), c), CN1)), x), Simp(Times(Log(Times(Sqr(Plus(c, Times(d, x))), Subtract(c, Times(d, x)))), Power(Times(Power(C2, QQ(7L, 3L)), Rt(b, C3), c), CN1)), x), Negate(Simp(Times(C3, Log(Plus(Times(Rt(b, C3), Subtract(c, Times(d, x))), Times(Power(C2, QQ(2L, 3L)), d, Power(Plus(a, Times(b, Power(x, C3))), C1D3)))), Power(Times(Power(C2, QQ(7L, 3L)), Rt(b, C3), c), CN1)), x))), And(FreeQ(List(a, b, c, d), x), EqQ(Plus(Times(b, Power(c, C3)), Times(a, Power(d, C3))), C0))));
            IIntegrate(2149, Int(Times(Power(Plus(c_, Times(d_DEFAULT, x_)), CN1), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1D3)), x_Symbol),
                    Condition(Plus(Dist(Power(Times(C2, c), CN1), Int(Power(Plus(a, Times(b, Power(x, C3))), CN1D3), x), x), Dist(Power(Times(C2, c), CN1), Int(Times(Subtract(c, Times(d, x)), Power(Times(Plus(c, Times(d, x)), Power(Plus(a, Times(b, Power(x, C3))), C1D3)), CN1)), x), x)), And(FreeQ(List(a, b, c, d), x), EqQ(Subtract(Times(C2, b, Power(c, C3)), Times(a, Power(d, C3))), C0))));
            IIntegrate(2150, Int(Times(Power(Plus(c_, Times(d_DEFAULT, x_)), CN1), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1D3)), x_Symbol),
                    Condition(Unintegrable(Power(Times(Plus(c, Times(d, x)), Power(Plus(a, Times(b, Power(x, C3))), C1D3)), CN1), x), FreeQ(List(a, b, c, d), x)));
        }
    }
}
