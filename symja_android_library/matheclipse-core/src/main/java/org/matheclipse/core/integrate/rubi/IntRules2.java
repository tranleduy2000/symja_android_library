package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcCosh;
import static org.matheclipse.core.expression.F.ArcTan;
import static org.matheclipse.core.expression.F.AtomQ;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C1D3;
import static org.matheclipse.core.expression.F.C1DSqrt3;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN1D3;
import static org.matheclipse.core.expression.F.CSqrt3;
import static org.matheclipse.core.expression.F.Coefficient;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.Hypergeometric2F1;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.QQ;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.With;
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
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntLinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NegQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RemoveContent;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules2 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(51, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), Plus(n, C1)), Power(Times(Subtract(Times(b, c), Times(a, d)), Plus(m, C1)), CN1)), x), Dist(Times(d, Plus(m, n, C2), Power(Times(Subtract(Times(b, c), Times(a, d)), Plus(m, C1)), CN1)), Int(Times(Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), n)), x), x)), And(FreeQ(List(a, b, c, d, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), LtQ(m, CN1), Not(And(LtQ(n, CN1), Or(EqQ(a, C0), And(NeQ(c, C0), LtQ(Subtract(m, n), C0), IntegerQ(n))))), IntLinearQ(a, b, c, d, m, n, x))));
            IIntegrate(52, Int(Times(Power(Plus(a_, Times(b_DEFAULT, x_)), CN1D2), Power(Plus(c_, Times(d_DEFAULT, x_)), CN1D2)), x_Symbol),
                    Condition(Simp(Times(ArcCosh(Times(b, x, Power(a, CN1))), Power(b, CN1)), x), And(FreeQ(List(a, b, c, d), x), EqQ(Plus(a, c), C0), EqQ(Subtract(b, d), C0), GtQ(a, C0))));
            IIntegrate(53, Int(Times(Power(Plus(a_, Times(b_DEFAULT, x_)), CN1D2), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), CN1D2)), x_Symbol),
                    Condition(Int(Power(Subtract(Subtract(Times(a, c), Times(b, Subtract(a, c), x)), Times(Sqr(b), Sqr(x))), CN1D2), x), And(FreeQ(List(a, b, c, d), x), EqQ(Plus(b, d), C0), GtQ(Plus(a, c), C0))));
            IIntegrate(54, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), CN1D2), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), CN1D2)), x_Symbol),
                    Condition(Dist(Times(C2, Power(b, CN1D2)), Subst(Int(Power(Plus(Times(b, c), Times(CN1, a, d), Times(d, Sqr(x))), CN1D2), x), x, Sqrt(Plus(a, Times(b, x)))), x), And(FreeQ(List(a, b, c, d), x), GtQ(Subtract(Times(b, c), Times(a, d)), C0), GtQ(b, C0))));
            IIntegrate(55, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), CN1), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), CN1D3)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(Subtract(Times(b, c), Times(a, d)), Power(b, CN1)), C3))), Plus(Negate(Simp(Times(Log(RemoveContent(Plus(a, Times(b, x)), x)), Power(Times(C2, b, q), CN1)), x)), Dist(Times(C3, Power(Times(C2, b), CN1)), Subst(Int(Power(Plus(Sqr(q), Times(q, x), Sqr(x)), CN1), x), x, Power(Plus(c, Times(d, x)), C1D3)), x), Negate(Dist(Times(C3, Power(Times(C2, b, q), CN1)), Subst(Int(Power(Subtract(q, x), CN1), x), x, Power(Plus(c, Times(d, x)), C1D3)), x)))), And(FreeQ(List(a, b, c, d), x), PosQ(Times(Subtract(Times(b, c), Times(a, d)), Power(b, CN1))))));
            IIntegrate(56, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), CN1), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), CN1D3)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(CN1, Subtract(Times(b, c), Times(a, d)), Power(b, CN1)), C3))), Plus(Simp(Times(Log(RemoveContent(Plus(a, Times(b, x)), x)), Power(Times(C2, b, q), CN1)), x), Dist(Times(C3, Power(Times(C2, b), CN1)), Subst(Int(Power(Plus(Sqr(q), Times(CN1, q, x), Sqr(x)), CN1), x), x, Power(Plus(c, Times(d, x)), C1D3)), x), Negate(Dist(Times(C3, Power(Times(C2, b, q), CN1)), Subst(Int(Power(Plus(q, x), CN1), x), x, Power(Plus(c, Times(d, x)), C1D3)), x)))), And(FreeQ(List(a, b, c, d), x), NegQ(Times(Subtract(Times(b, c), Times(a, d)), Power(b, CN1))))));
            IIntegrate(57, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), CN1), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), QQ(-2L, 3L))), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(Subtract(Times(b, c), Times(a, d)), Power(b, CN1)), C3))), Plus(Negate(Simp(Times(Log(RemoveContent(Plus(a, Times(b, x)), x)), Power(Times(C2, b, Sqr(q)), CN1)), x)), Negate(Dist(Times(C3, Power(Times(C2, b, q), CN1)), Subst(Int(Power(Plus(Sqr(q), Times(q, x), Sqr(x)), CN1), x), x, Power(Plus(c, Times(d, x)), C1D3)), x)), Negate(Dist(Times(C3, Power(Times(C2, b, Sqr(q)), CN1)), Subst(Int(Power(Subtract(q, x), CN1), x), x, Power(Plus(c, Times(d, x)), C1D3)), x)))), And(FreeQ(List(a, b, c, d), x), PosQ(Times(Subtract(Times(b, c), Times(a, d)), Power(b, CN1))))));
            IIntegrate(58, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), CN1), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), QQ(-2L, 3L))), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(CN1, Subtract(Times(b, c), Times(a, d)), Power(b, CN1)), C3))), Plus(Negate(Simp(Times(Log(RemoveContent(Plus(a, Times(b, x)), x)), Power(Times(C2, b, Sqr(q)), CN1)), x)), Dist(Times(C3, Power(Times(C2, b, q), CN1)), Subst(Int(Power(Plus(Sqr(q), Times(CN1, q, x), Sqr(x)), CN1), x), x, Power(Plus(c, Times(d, x)), C1D3)), x), Dist(Times(C3, Power(Times(C2, b, Sqr(q)), CN1)), Subst(Int(Power(Plus(q, x), CN1), x), x, Power(Plus(c, Times(d, x)), C1D3)), x))), And(FreeQ(List(a, b, c, d), x), NegQ(Times(Subtract(Times(b, c), Times(a, d)), Power(b, CN1))))));
            IIntegrate(59, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), CN1D3), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), QQ(-2L, 3L))), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(d, Power(b, CN1)), C3))), Plus(Negate(Simp(Times(CSqrt3, q, ArcTan(Plus(Times(C2, q, Power(Plus(a, Times(b, x)), C1D3), Power(Times(CSqrt3, Power(Plus(c, Times(d, x)), C1D3)), CN1)), C1DSqrt3)), Power(d, CN1)), x)), Negate(Simp(Times(C3, q, Log(Subtract(Times(q, Power(Plus(a, Times(b, x)), C1D3), Power(Plus(c, Times(d, x)), CN1D3)), C1)), Power(Times(C2, d), CN1)), x)), Negate(Simp(Times(q, Log(Plus(c, Times(d, x))), Power(Times(C2, d), CN1)), x)))), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), PosQ(Times(d, Power(b, CN1))))));
            IIntegrate(60, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), CN1D3), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), QQ(-2L, 3L))), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(CN1, d, Power(b, CN1)), C3))), Plus(Simp(Times(CSqrt3, q, ArcTan(Subtract(C1DSqrt3, Times(C2, q, Power(Plus(a, Times(b, x)), C1D3), Power(Times(CSqrt3, Power(Plus(c, Times(d, x)), C1D3)), CN1)))), Power(d, CN1)), x), Simp(Times(C3, q, Log(Plus(Times(q, Power(Plus(a, Times(b, x)), C1D3), Power(Plus(c, Times(d, x)), CN1D3)), C1)), Power(Times(C2, d), CN1)), x), Simp(Times(q, Log(Plus(c, Times(d, x))), Power(Times(C2, d), CN1)), x))), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NegQ(Times(d, Power(b, CN1))))));
            IIntegrate(61, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_), Power(Plus(c_, Times(d_DEFAULT, x_)), m_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, x)), m), Power(Plus(c, Times(d, x)), m), Power(Power(Plus(Times(a, c), Times(Plus(Times(b, c), Times(a, d)), x), Times(b, d, Sqr(x))), m), CN1)), Int(Power(Plus(Times(a, c), Times(Plus(Times(b, c), Times(a, d)), x), Times(b, d, Sqr(x))), m), x), x), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), LtQ(CN1, m, C0), LeQ(C3, Denominator(m), C4), AtomQ(Plus(Times(b, c), Times(a, d))))));
            IIntegrate(62, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_), Power(Plus(c_, Times(d_DEFAULT, x_)), m_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, x)), m), Power(Plus(c, Times(d, x)), m), Power(Power(Times(Plus(a, Times(b, x)), Plus(c, Times(d, x))), m), CN1)), Int(Power(Plus(Times(a, c), Times(Plus(Times(b, c), Times(a, d)), x), Times(b, d, Sqr(x))), m), x), x), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), LtQ(CN1, m, C0), LeQ(C3, Denominator(m), C4))));
            IIntegrate(63, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_)), x_Symbol),
                    Condition(With(List(Set(p, Denominator(m))), Dist(Times(p, Power(b, CN1)), Subst(Int(Times(Power(x, Subtract(Times(p, Plus(m, C1)), C1)), Power(Plus(c, Times(CN1, a, d, Power(b, CN1)), Times(d, Power(x, p), Power(b, CN1))), n)), x), x, Power(Plus(a, Times(b, x)), Power(p, CN1))), x)), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), LtQ(CN1, m, C0), LeQ(CN1, n, C0), LeQ(Denominator(n), Denominator(m)), IntLinearQ(a, b, c, d, m, n, x))));
            IIntegrate(64, Int(Times(Power(Times(b_DEFAULT, x_), m_), Power(Plus(c_, Times(d_DEFAULT, x_)), n_)), x_Symbol),
                    Condition(Simp(Times(Power(c, n), Power(Times(b, x), Plus(m, C1)), Hypergeometric2F1(Negate(n), Plus(m, C1), Plus(m, C2), Times(CN1, d, x, Power(c, CN1))), Power(Times(b, Plus(m, C1)), CN1)), x), And(FreeQ(List(b, c, d, m, n), x), Not(IntegerQ(m)), Or(IntegerQ(n), And(GtQ(c, C0), Not(And(EqQ(n, Negate(C1D2)), EqQ(Subtract(Sqr(c), Sqr(d)), C0), GtQ(Times(CN1, d, Power(Times(b, c), CN1)), C0))))))));
            IIntegrate(65, Int(Times(Power(Times(b_DEFAULT, x_), m_), Power(Plus(c_, Times(d_DEFAULT, x_)), n_)), x_Symbol),
                    Condition(Simp(Times(Power(Plus(c, Times(d, x)), Plus(n, C1)), Hypergeometric2F1(Negate(m), Plus(n, C1), Plus(n, C2), Plus(C1, Times(d, x, Power(c, CN1)))), Power(Times(d, Plus(n, C1), Power(Times(CN1, d, Power(Times(b, c), CN1)), m)), CN1)), x), And(FreeQ(List(b, c, d, m, n), x), Not(IntegerQ(n)), Or(IntegerQ(m), GtQ(Times(CN1, d, Power(Times(b, c), CN1)), C0)))));
            IIntegrate(66, Int(Times(Power(Times(b_DEFAULT, x_), m_), Power(Plus(c_, Times(d_DEFAULT, x_)), n_)), x_Symbol),
                    Condition(Dist(Times(Power(c, IntPart(n)), Power(Plus(c, Times(d, x)), FracPart(n)), Power(Power(Plus(C1, Times(d, x, Power(c, CN1))), FracPart(n)), CN1)), Int(Times(Power(Times(b, x), m), Power(Plus(C1, Times(d, x, Power(c, CN1))), n)), x), x), And(FreeQ(List(b, c, d, m, n), x), Not(IntegerQ(m)), Not(IntegerQ(n)), Not(GtQ(c, C0)), Not(GtQ(Times(CN1, d, Power(Times(b, c), CN1)), C0)), Or(And(RationalQ(m), Not(And(EqQ(n, Negate(C1D2)), EqQ(Subtract(Sqr(c), Sqr(d)), C0)))), Not(RationalQ(n))))));
            IIntegrate(67, Int(Times(Power(Times(b_DEFAULT, x_), m_), Power(Plus(c_, Times(d_DEFAULT, x_)), n_)), x_Symbol),
                    Condition(Dist(Times(Power(Times(CN1, b, c, Power(d, CN1)), IntPart(m)), Power(Times(b, x), FracPart(m)), Power(Power(Times(CN1, d, x, Power(c, CN1)), FracPart(m)), CN1)), Int(Times(Power(Times(CN1, d, x, Power(c, CN1)), m), Power(Plus(c, Times(d, x)), n)), x), x), And(FreeQ(List(b, c, d, m, n), x), Not(IntegerQ(m)), Not(IntegerQ(n)), Not(GtQ(c, C0)), Not(GtQ(Times(CN1, d, Power(Times(b, c), CN1)), C0)))));
            IIntegrate(68, Int(Times(Power(Plus(a_, Times(b_DEFAULT, x_)), m_), Power(Plus(c_, Times(d_DEFAULT, x_)), n_)), x_Symbol),
                    Condition(Simp(Times(Power(Subtract(Times(b, c), Times(a, d)), n), Power(Plus(a, Times(b, x)), Plus(m, C1)), Hypergeometric2F1(Negate(n), Plus(m, C1), Plus(m, C2), Times(CN1, d, Plus(a, Times(b, x)), Power(Subtract(Times(b, c), Times(a, d)), CN1))), Power(Times(Power(b, Plus(n, C1)), Plus(m, C1)), CN1)), x), And(FreeQ(List(a, b, c, d, m), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), Not(IntegerQ(m)), IntegerQ(n))));
            IIntegrate(69, Int(Times(Power(Plus(a_, Times(b_DEFAULT, x_)), m_), Power(Plus(c_, Times(d_DEFAULT, x_)), n_)), x_Symbol),
                    Condition(Simp(Times(Power(Plus(a, Times(b, x)), Plus(m, C1)), Hypergeometric2F1(Negate(n), Plus(m, C1), Plus(m, C2), Times(CN1, d, Plus(a, Times(b, x)), Power(Subtract(Times(b, c), Times(a, d)), CN1))), Power(Times(b, Plus(m, C1), Power(Times(b, Power(Subtract(Times(b, c), Times(a, d)), CN1)), n)), CN1)), x), And(FreeQ(List(a, b, c, d, m, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), Not(IntegerQ(m)), Not(IntegerQ(n)), GtQ(Times(b, Power(Subtract(Times(b, c), Times(a, d)), CN1)), C0), Or(RationalQ(m), Not(And(RationalQ(n), GtQ(Times(CN1, d, Power(Subtract(Times(b, c), Times(a, d)), CN1)), C0)))))));
            IIntegrate(70, Int(Times(Power(Plus(a_, Times(b_DEFAULT, x_)), m_), Power(Plus(c_, Times(d_DEFAULT, x_)), n_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(c, Times(d, x)), FracPart(n)), Power(Times(Power(Times(b, Power(Subtract(Times(b, c), Times(a, d)), CN1)), IntPart(n)), Power(Times(b, Plus(c, Times(d, x)), Power(Subtract(Times(b, c), Times(a, d)), CN1)), FracPart(n))), CN1)), Int(Times(Power(Plus(a, Times(b, x)), m), Power(Simp(Plus(Times(b, c, Power(Subtract(Times(b, c), Times(a, d)), CN1)), Times(b, d, x, Power(Subtract(Times(b, c), Times(a, d)), CN1))), x), n)), x), x), And(FreeQ(List(a, b, c, d, m, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), Not(IntegerQ(m)), Not(IntegerQ(n)), Or(RationalQ(m), Not(SimplerQ(Plus(n, C1), Plus(m, C1)))))));
            IIntegrate(71, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, u_)), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, u_)), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Coefficient(u, x, C1), CN1), Subst(Int(Times(Power(Plus(a, Times(b, x)), m), Power(Plus(c, Times(d, x)), n)), x), x, u), x), And(FreeQ(List(a, b, c, d, m, n), x), LinearQ(u, x), NeQ(Coefficient(u, x, C0), C0))));
            IIntegrate(72, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), CN1), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), CN1), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(e, Times(f, x)), p), Power(Times(Plus(a, Times(b, x)), Plus(c, Times(d, x))), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f), x), IntegerQ(p))));
            IIntegrate(73, Int(Times(Power(Plus(a_, Times(b_DEFAULT, x_)), m_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, x_)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Plus(Times(a, c), Times(b, d, Sqr(x))), m), Power(Plus(e, Times(f, x)), p)), x), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(n, m), IntegerQ(m))));
            IIntegrate(74, Int(Times(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(Simp(Times(b, Power(Plus(c, Times(d, x)), Plus(n, C1)), Power(Plus(e, Times(f, x)), Plus(p, C1)), Power(Times(d, f, Plus(n, p, C2)), CN1)), x), And(FreeQ(List(a, b, c, d, e, f, n, p), x), NeQ(Plus(n, p, C2), C0), EqQ(Subtract(Times(a, d, f, Plus(n, p, C2)), Times(b, Plus(Times(d, e, Plus(n, C1)), Times(c, f, Plus(p, C1))))), C0))));
            IIntegrate(75, Int(Times(Power(Times(d_DEFAULT, x_), n_DEFAULT), Plus(a_, Times(b_DEFAULT, x_)), Power(Plus(e_, Times(f_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Plus(a, Times(b, x)), Power(Times(d, x), n), Power(Plus(e, Times(f, x)), p)), x), x), And(FreeQ(List(a, b, d, e, f, n), x), IGtQ(p, C0), EqQ(Plus(Times(b, e), Times(a, f)), C0), Not(And(ILtQ(Plus(n, p, C2), C0), GtQ(Plus(n, Times(C2, p)), C0))))));
        }
    }
}
