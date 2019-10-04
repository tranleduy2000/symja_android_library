package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcTan;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D3;
import static org.matheclipse.core.expression.F.C1DSqrt3;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.C5;
import static org.matheclipse.core.expression.F.C9;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN1D3;
import static org.matheclipse.core.expression.F.CSqrt3;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.FractionalPart;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerPart;
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
import static org.matheclipse.core.expression.F.Simplify;
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
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumSimplerQ;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules3 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(76, Int(Times(Power(Times(d_DEFAULT, x_), n_DEFAULT), Plus(a_, Times(b_DEFAULT, x_)), Power(Plus(e_, Times(f_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Plus(a, Times(b, x)), Power(Times(d, x), n), Power(Plus(e, Times(f, x)), p)), x), x), And(FreeQ(List(a, b, d, e, f, n), x), IGtQ(p, C0), Or(NeQ(n, CN1), EqQ(p, C1)), NeQ(Plus(Times(b, e), Times(a, f)), C0), Or(Not(IntegerQ(n)), LtQ(Plus(Times(C9, p), Times(C5, n)), C0), GeQ(Plus(n, p, C1), C0), And(GeQ(Plus(n, p, C2), C0), RationalQ(a, b, d, e, f))), Or(NeQ(Plus(n, p, C3), C0), EqQ(p, C1)))));
            IIntegrate(77, Int(Times(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), Power(Plus(c_, Times(d_DEFAULT, x_)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Plus(a, Times(b, x)), Power(Plus(c, Times(d, x)), n), Power(Plus(e, Times(f, x)), p)), x), x), And(FreeQ(List(a, b, c, d, e, f, n), x), NeQ(Subtract(Times(b, c), Times(a, d)), C0), Or(And(ILtQ(n, C0), ILtQ(p, C0)), EqQ(p, C1), And(IGtQ(p, C0), Or(Not(IntegerQ(n)), LeQ(Plus(Times(C9, p), Times(C5, Plus(n, C2))), C0), GeQ(Plus(n, p, C1), C0), And(GeQ(Plus(n, p, C2), C0), RationalQ(a, b, c, d, e, f))))))));
            IIntegrate(78, Int(Times(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(Subtract(Negate(Simp(Times(Subtract(Times(b, e), Times(a, f)), Power(Plus(c, Times(d, x)), Plus(n, C1)), Power(Plus(e, Times(f, x)), Plus(p, C1)), Power(Times(f, Plus(p, C1), Subtract(Times(c, f), Times(d, e))), CN1)), x)), Dist(Times(Subtract(Times(a, d, f, Plus(n, p, C2)), Times(b, Plus(Times(d, e, Plus(n, C1)), Times(c, f, Plus(p, C1))))), Power(Times(f, Plus(p, C1), Subtract(Times(c, f), Times(d, e))), CN1)), Int(Times(Power(Plus(c, Times(d, x)), n), Power(Plus(e, Times(f, x)), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f, n), x), LtQ(p, CN1), Or(Not(LtQ(n, CN1)), IntegerQ(p), Not(Or(IntegerQ(n), Not(Or(EqQ(e, C0), Not(Or(EqQ(c, C0), LtQ(p, n)))))))))));
            IIntegrate(79, Int(Times(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(Subtract(Negate(Simp(Times(Subtract(Times(b, e), Times(a, f)), Power(Plus(c, Times(d, x)), Plus(n, C1)), Power(Plus(e, Times(f, x)), Plus(p, C1)), Power(Times(f, Plus(p, C1), Subtract(Times(c, f), Times(d, e))), CN1)), x)), Dist(Times(Subtract(Times(a, d, f, Plus(n, p, C2)), Times(b, Plus(Times(d, e, Plus(n, C1)), Times(c, f, Plus(p, C1))))), Power(Times(f, Plus(p, C1), Subtract(Times(c, f), Times(d, e))), CN1)), Int(Times(Power(Plus(c, Times(d, x)), n), Power(Plus(e, Times(f, x)), Simplify(Plus(p, C1)))), x), x)), And(FreeQ(List(a, b, c, d, e, f, n, p), x), Not(RationalQ(p)), SumSimplerQ(p, C1))));
            IIntegrate(80, Int(Times(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(b, Power(Plus(c, Times(d, x)), Plus(n, C1)), Power(Plus(e, Times(f, x)), Plus(p, C1)), Power(Times(d, f, Plus(n, p, C2)), CN1)), x), Dist(Times(Subtract(Times(a, d, f, Plus(n, p, C2)), Times(b, Plus(Times(d, e, Plus(n, C1)), Times(c, f, Plus(p, C1))))), Power(Times(d, f, Plus(n, p, C2)), CN1)), Int(Times(Power(Plus(c, Times(d, x)), n), Power(Plus(e, Times(f, x)), p)), x), x)), And(FreeQ(List(a, b, c, d, e, f, n, p), x), NeQ(Plus(n, p, C2), C0))));
            IIntegrate(81, Int(Times(Sqr(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(Simp(Times(b, Power(Plus(c, Times(d, x)), Plus(n, C1)), Power(Plus(e, Times(f, x)), Plus(p, C1)), Plus(Times(C2, a, d, f, Plus(n, p, C3)), Times(CN1, b, Plus(Times(d, e, Plus(n, C2)), Times(c, f, Plus(p, C2)))), Times(b, d, f, Plus(n, p, C2), x)), Power(Times(Sqr(d), Sqr(f), Plus(n, p, C2), Plus(n, p, C3)), CN1)), x), And(FreeQ(List(a, b, c, d, e, f, n, p), x), NeQ(Plus(n, p, C2), C0), NeQ(Plus(n, p, C3), C0), EqQ(Subtract(Times(d, f, Plus(n, p, C2), Subtract(Times(Sqr(a), d, f, Plus(n, p, C3)), Times(b, Plus(Times(b, c, e), Times(a, Plus(Times(d, e, Plus(n, C1)), Times(c, f, Plus(p, C1)))))))), Times(b, Plus(Times(d, e, Plus(n, C1)), Times(c, f, Plus(p, C1))), Subtract(Times(a, d, f, Plus(n, p, C4)), Times(b, Plus(Times(d, e, Plus(n, C2)), Times(c, f, Plus(p, C2))))))), C0))));
            IIntegrate(82, Int(Times(Power(Times(f_DEFAULT, x_), p_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT)), x_Symbol),
                    Condition(Plus(Dist(a, Int(Times(Power(Plus(a, Times(b, x)), n), Power(Plus(c, Times(d, x)), n), Power(Times(f, x), p)), x), x), Dist(Times(b, Power(f, CN1)), Int(Times(Power(Plus(a, Times(b, x)), n), Power(Plus(c, Times(d, x)), n), Power(Times(f, x), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, f, m, n, p), x), EqQ(Plus(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Subtract(m, n), C1), C0), Not(RationalQ(p)), Not(IGtQ(m, C0)), NeQ(Plus(m, n, p, C2), C0))));
            IIntegrate(83, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), CN1), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), CN1), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(Subtract(Dist(Times(Subtract(Times(b, e), Times(a, f)), Power(Subtract(Times(b, c), Times(a, d)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Subtract(p, C1)), Power(Plus(a, Times(b, x)), CN1)), x), x), Dist(Times(Subtract(Times(d, e), Times(c, f)), Power(Subtract(Times(b, c), Times(a, d)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Subtract(p, C1)), Power(Plus(c, Times(d, x)), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), LtQ(C0, p, C1))));
            IIntegrate(84, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), CN1), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), CN1), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(f, Power(Plus(e, Times(f, x)), Subtract(p, C1)), Power(Times(b, d, Subtract(p, C1)), CN1)), x), Dist(Power(Times(b, d), CN1), Int(Times(Plus(Times(b, d, Sqr(e)), Times(CN1, a, c, Sqr(f)), Times(f, Subtract(Subtract(Times(C2, b, d, e), Times(b, c, f)), Times(a, d, f)), x)), Power(Plus(e, Times(f, x)), Subtract(p, C2)), Power(Times(Plus(a, Times(b, x)), Plus(c, Times(d, x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), GtQ(p, C1))));
            IIntegrate(85, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), CN1), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), CN1), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(f, Power(Plus(e, Times(f, x)), Plus(p, C1)), Power(Times(Plus(p, C1), Subtract(Times(b, e), Times(a, f)), Subtract(Times(d, e), Times(c, f))), CN1)), x), Dist(Power(Times(Subtract(Times(b, e), Times(a, f)), Subtract(Times(d, e), Times(c, f))), CN1), Int(Times(Subtract(Subtract(Subtract(Times(b, d, e), Times(b, c, f)), Times(a, d, f)), Times(b, d, f, x)), Power(Plus(e, Times(f, x)), Plus(p, C1)), Power(Times(Plus(a, Times(b, x)), Plus(c, Times(d, x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), LtQ(p, CN1))));
            IIntegrate(86, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), CN1), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), CN1), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_)), x_Symbol),
                    Condition(Subtract(Dist(Times(b, Power(Subtract(Times(b, c), Times(a, d)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), p), Power(Plus(a, Times(b, x)), CN1)), x), x), Dist(Times(d, Power(Subtract(Times(b, c), Times(a, d)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), p), Power(Plus(c, Times(d, x)), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, p), x), Not(IntegerQ(p)))));
            IIntegrate(87, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), CN1), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(e, Times(f, x)), FractionalPart(p)), Times(Power(Plus(c, Times(d, x)), n), Power(Plus(e, Times(f, x)), IntegerPart(p)), Power(Plus(a, Times(b, x)), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(n, C0), LtQ(p, CN1), FractionQ(p))));
            IIntegrate(88, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(a, Times(b, x)), m), Power(Plus(c, Times(d, x)), n), Power(Plus(e, Times(f, x)), p)), x), x), And(FreeQ(List(a, b, c, d, e, f, p), x), IntegersQ(m, n), Or(IntegerQ(p), And(GtQ(m, C0), GeQ(n, CN1))))));
            IIntegrate(89, Int(Times(Sqr(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Sqr(Subtract(Times(b, c), Times(a, d))), Power(Plus(c, Times(d, x)), Plus(n, C1)), Power(Plus(e, Times(f, x)), Plus(p, C1)), Power(Times(Sqr(d), Subtract(Times(d, e), Times(c, f)), Plus(n, C1)), CN1)), x), Dist(Power(Times(Sqr(d), Subtract(Times(d, e), Times(c, f)), Plus(n, C1)), CN1), Int(Times(Power(Plus(c, Times(d, x)), Plus(n, C1)), Power(Plus(e, Times(f, x)), p), Simp(Subtract(Subtract(Plus(Times(Sqr(a), Sqr(d), f, Plus(n, p, C2)), Times(Sqr(b), c, Plus(Times(d, e, Plus(n, C1)), Times(c, f, Plus(p, C1))))), Times(C2, a, b, d, Plus(Times(d, e, Plus(n, C1)), Times(c, f, Plus(p, C1))))), Times(Sqr(b), d, Subtract(Times(d, e), Times(c, f)), Plus(n, C1), x)), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, n, p), x), Or(LtQ(n, CN1), And(EqQ(Plus(n, p, C3), C0), NeQ(n, CN1), Or(SumSimplerQ(n, C1), Not(SumSimplerQ(p, C1))))))));
            IIntegrate(90, Int(Times(Sqr(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(b, Plus(a, Times(b, x)), Power(Plus(c, Times(d, x)), Plus(n, C1)), Power(Plus(e, Times(f, x)), Plus(p, C1)), Power(Times(d, f, Plus(n, p, C3)), CN1)), x), Dist(Power(Times(d, f, Plus(n, p, C3)), CN1), Int(Times(Power(Plus(c, Times(d, x)), n), Power(Plus(e, Times(f, x)), p), Simp(Plus(Times(Sqr(a), d, f, Plus(n, p, C3)), Times(CN1, b, Plus(Times(b, c, e), Times(a, Plus(Times(d, e, Plus(n, C1)), Times(c, f, Plus(p, C1)))))), Times(b, Subtract(Times(a, d, f, Plus(n, p, C4)), Times(b, Plus(Times(d, e, Plus(n, C2)), Times(c, f, Plus(p, C2))))), x)), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, n, p), x), NeQ(Plus(n, p, C3), C0))));
            IIntegrate(91, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), CN1D3), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), QQ(-2L, 3L)), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(Subtract(Times(d, e), Times(c, f)), Power(Subtract(Times(b, e), Times(a, f)), CN1)), C3))), Plus(Negate(Simp(Times(CSqrt3, q, ArcTan(Plus(C1DSqrt3, Times(C2, q, Power(Plus(a, Times(b, x)), C1D3), Power(Times(CSqrt3, Power(Plus(c, Times(d, x)), C1D3)), CN1)))), Power(Subtract(Times(d, e), Times(c, f)), CN1)), x)), Simp(Times(q, Log(Plus(e, Times(f, x))), Power(Times(C2, Subtract(Times(d, e), Times(c, f))), CN1)), x), Negate(Simp(Times(C3, q, Log(Subtract(Times(q, Power(Plus(a, Times(b, x)), C1D3)), Power(Plus(c, Times(d, x)), C1D3))), Power(Times(C2, Subtract(Times(d, e), Times(c, f))), CN1)), x)))), FreeQ(List(a, b, c, d, e, f), x)));
            IIntegrate(92, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), CN1D2), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), CN1D2), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(Dist(Times(b, f), Subst(Int(Power(Plus(Times(d, Sqr(Subtract(Times(b, e), Times(a, f)))), Times(b, Sqr(f), Sqr(x))), CN1), x), x, Times(Sqrt(Plus(a, Times(b, x))), Sqrt(Plus(c, Times(d, x))))), x), And(FreeQ(List(a, b, c, d, e, f), x), EqQ(Subtract(Times(C2, b, d, e), Times(f, Plus(Times(b, c), Times(a, d)))), C0))));
            IIntegrate(93, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Denominator(m))), Dist(q, Subst(Int(Times(Power(x, Subtract(Times(q, Plus(m, C1)), C1)), Power(Subtract(Subtract(Times(b, e), Times(a, f)), Times(Subtract(Times(d, e), Times(c, f)), Power(x, q))), CN1)), x), x, Times(Power(Plus(a, Times(b, x)), Power(q, CN1)), Power(Power(Plus(c, Times(d, x)), Power(q, CN1)), CN1))), x)), And(FreeQ(List(a, b, c, d, e, f), x), EqQ(Plus(m, n, C1), C0), RationalQ(n), LtQ(CN1, m, C0), SimplerQ(Plus(a, Times(b, x)), Plus(c, Times(d, x))))));
            IIntegrate(94, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), n), Power(Plus(e, Times(f, x)), Plus(p, C1)), Power(Times(Plus(m, C1), Subtract(Times(b, e), Times(a, f))), CN1)), x), Dist(Times(n, Subtract(Times(d, e), Times(c, f)), Power(Times(Plus(m, C1), Subtract(Times(b, e), Times(a, f))), CN1)), Int(Times(Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), Subtract(n, C1)), Power(Plus(e, Times(f, x)), p)), x), x)), And(FreeQ(List(a, b, c, d, e, f, m, p), x), EqQ(Plus(m, n, p, C2), C0), GtQ(n, C0), Not(And(SumSimplerQ(p, C1), Not(SumSimplerQ(m, C1)))))));
            IIntegrate(95, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(Simp(Times(b, Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), Plus(n, C1)), Power(Plus(e, Times(f, x)), Plus(p, C1)), Power(Times(Plus(m, C1), Subtract(Times(b, c), Times(a, d)), Subtract(Times(b, e), Times(a, f))), CN1)), x), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), EqQ(Simplify(Plus(m, n, p, C3)), C0), EqQ(Plus(Times(a, d, f, Plus(m, C1)), Times(b, c, f, Plus(n, C1)), Times(b, d, e, Plus(p, C1))), C0), NeQ(m, CN1))));
            IIntegrate(96, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(b, Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), Plus(n, C1)), Power(Plus(e, Times(f, x)), Plus(p, C1)), Power(Times(Plus(m, C1), Subtract(Times(b, c), Times(a, d)), Subtract(Times(b, e), Times(a, f))), CN1)), x), Dist(Times(Plus(Times(a, d, f, Plus(m, C1)), Times(b, c, f, Plus(n, C1)), Times(b, d, e, Plus(p, C1))), Power(Times(Plus(m, C1), Subtract(Times(b, c), Times(a, d)), Subtract(Times(b, e), Times(a, f))), CN1)), Int(Times(Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), n), Power(Plus(e, Times(f, x)), p)), x), x)), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), EqQ(Simplify(Plus(m, n, p, C3)), C0), Or(LtQ(m, CN1), SumSimplerQ(m, C1)))));
            IIntegrate(97, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), n), Power(Plus(e, Times(f, x)), p), Power(Times(b, Plus(m, C1)), CN1)), x), Dist(Power(Times(b, Plus(m, C1)), CN1), Int(Times(Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), Subtract(n, C1)), Power(Plus(e, Times(f, x)), Subtract(p, C1)), Simp(Plus(Times(d, e, n), Times(c, f, p), Times(d, f, Plus(n, p), x)), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), LtQ(m, CN1), GtQ(n, C0), GtQ(p, C0), Or(IntegersQ(Times(C2, m), Times(C2, n), Times(C2, p)), IntegersQ(m, Plus(n, p)), IntegersQ(p, Plus(m, n))))));
            IIntegrate(98, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Subtract(Times(b, c), Times(a, d)), Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), Subtract(n, C1)), Power(Plus(e, Times(f, x)), Plus(p, C1)), Power(Times(b, Subtract(Times(b, e), Times(a, f)), Plus(m, C1)), CN1)), x), Dist(Power(Times(b, Subtract(Times(b, e), Times(a, f)), Plus(m, C1)), CN1), Int(Times(Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), Subtract(n, C2)), Power(Plus(e, Times(f, x)), p), Simp(Plus(Times(a, d, Plus(Times(d, e, Subtract(n, C1)), Times(c, f, Plus(p, C1)))), Times(b, c, Subtract(Times(d, e, Plus(m, Negate(n), C2)), Times(c, f, Plus(m, p, C2)))), Times(d, Plus(Times(a, d, f, Plus(n, p)), Times(b, Subtract(Times(d, e, Plus(m, C1)), Times(c, f, Plus(m, n, p, C1))))), x)), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, p), x), LtQ(m, CN1), GtQ(n, C1), Or(IntegersQ(Times(C2, m), Times(C2, n), Times(C2, p)), IntegersQ(m, Plus(n, p)), IntegersQ(p, Plus(m, n))))));
            IIntegrate(99, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), n), Power(Plus(e, Times(f, x)), Plus(p, C1)), Power(Times(Plus(m, C1), Subtract(Times(b, e), Times(a, f))), CN1)), x), Dist(Power(Times(Plus(m, C1), Subtract(Times(b, e), Times(a, f))), CN1), Int(Times(Power(Plus(a, Times(b, x)), Plus(m, C1)), Power(Plus(c, Times(d, x)), Subtract(n, C1)), Power(Plus(e, Times(f, x)), p), Simp(Plus(Times(d, e, n), Times(c, f, Plus(m, p, C2)), Times(d, f, Plus(m, n, p, C2), x)), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, p), x), LtQ(m, CN1), GtQ(n, C0), Or(IntegersQ(Times(C2, m), Times(C2, n), Times(C2, p)), IntegersQ(m, Plus(n, p)), IntegersQ(p, Plus(m, n))))));
            IIntegrate(100, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_)), m_), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(b, Power(Plus(a, Times(b, x)), Subtract(m, C1)), Power(Plus(c, Times(d, x)), Plus(n, C1)), Power(Plus(e, Times(f, x)), Plus(p, C1)), Power(Times(d, f, Plus(m, n, p, C1)), CN1)), x), Dist(Power(Times(d, f, Plus(m, n, p, C1)), CN1), Int(Times(Power(Plus(a, Times(b, x)), Subtract(m, C2)), Power(Plus(c, Times(d, x)), n), Power(Plus(e, Times(f, x)), p), Simp(Plus(Times(Sqr(a), d, f, Plus(m, n, p, C1)), Times(CN1, b, Plus(Times(b, c, e, Subtract(m, C1)), Times(a, Plus(Times(d, e, Plus(n, C1)), Times(c, f, Plus(p, C1)))))), Times(b, Subtract(Times(a, d, f, Plus(Times(C2, m), n, p)), Times(b, Plus(Times(d, e, Plus(m, n)), Times(c, f, Plus(m, p))))), x)), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, n, p), x), GtQ(m, C1), NeQ(Plus(m, n, p, C1), C0), IntegerQ(m))));
        }
    }
}
