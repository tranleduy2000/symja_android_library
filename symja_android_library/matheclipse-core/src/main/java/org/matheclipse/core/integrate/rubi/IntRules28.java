package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C1D4;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
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
import static org.matheclipse.core.expression.F.e_;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PolynomialDivide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules28 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(701, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Int(PolynomialDivide(Power(Plus(d, Times(e, x)), m), Plus(a, Times(b, x), Times(c, Sqr(x))), x), x), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), NeQ(Subtract(Times(C2, c, d), Times(b, e)), C0), IGtQ(m, C1), Or(NeQ(d, C0), GtQ(m, C2)))));
            IIntegrate(702, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Int(PolynomialDivide(Power(Plus(d, Times(e, x)), m), Plus(a, Times(c, Sqr(x))), x), x), And(FreeQ(List(a, c, d, e), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), IGtQ(m, C1), Or(NeQ(d, C0), GtQ(m, C2)))));
            IIntegrate(703, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Plus(Simp(Times(e, Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Times(c, Subtract(m, C1)), CN1)), x), Dist(Power(c, CN1), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C2)), Simp(Plus(Times(c, Sqr(d)), Times(CN1, a, Sqr(e)), Times(e, Subtract(Times(C2, c, d), Times(b, e)), x)), x), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), NeQ(Subtract(Times(C2, c, d), Times(b, e)), C0), GtQ(m, C1))));
            IIntegrate(704, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Plus(Simp(Times(e, Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Times(c, Subtract(m, C1)), CN1)), x), Dist(Power(c, CN1), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C2)), Simp(Plus(Times(c, Sqr(d)), Times(CN1, a, Sqr(e)), Times(C2, c, d, e, x)), x), Power(Plus(a, Times(c, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, c, d, e), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), GtQ(m, C1))));
            IIntegrate(705, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), CN1), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Plus(Dist(Times(Sqr(e), Power(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), CN1)), Int(Power(Plus(d, Times(e, x)), CN1), x), x), Dist(Power(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), CN1), Int(Times(Subtract(Subtract(Times(c, d), Times(b, e)), Times(c, e, x)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), NeQ(Subtract(Times(C2, c, d), Times(b, e)), C0))));
            IIntegrate(706, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), CN1), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Plus(Dist(Times(Sqr(e), Power(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1)), Int(Power(Plus(d, Times(e, x)), CN1), x), x), Dist(Power(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1), Int(Times(Subtract(Times(c, d), Times(c, e, x)), Power(Plus(a, Times(c, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, c, d, e), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0))));
            IIntegrate(707, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), CN1D2), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Dist(Times(C2, e), Subst(Int(Power(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e)), Times(CN1, Subtract(Times(C2, c, d), Times(b, e)), Sqr(x)), Times(c, Power(x, C4))), CN1), x), x, Sqrt(Plus(d, Times(e, x)))), x), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), NeQ(Subtract(Times(C2, c, d), Times(b, e)), C0))));
            IIntegrate(708, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), CN1D2), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Dist(Times(C2, e), Subst(Int(Power(Plus(Times(c, Sqr(d)), Times(a, Sqr(e)), Times(CN1, C2, c, d, Sqr(x)), Times(c, Power(x, C4))), CN1), x), x, Sqrt(Plus(d, Times(e, x)))), x), And(FreeQ(List(a, c, d, e), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0))));
            IIntegrate(709, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Plus(Simp(Times(e, Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Times(Plus(m, C1), Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e)))), CN1)), x), Dist(Power(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), CN1), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Simp(Subtract(Subtract(Times(c, d), Times(b, e)), Times(c, e, x)), x), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, m), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), NeQ(Subtract(Times(C2, c, d), Times(b, e)), C0), LtQ(m, CN1))));
            IIntegrate(710, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Plus(Simp(Times(e, Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Times(Plus(m, C1), Plus(Times(c, Sqr(d)), Times(a, Sqr(e)))), CN1)), x), Dist(Times(c, Power(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Subtract(d, Times(e, x)), Power(Plus(a, Times(c, Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, c, d, e, m), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), LtQ(m, CN1))));
            IIntegrate(711, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(d, Times(e, x)), m), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), CN1), x), x), And(FreeQ(List(a, b, c, d, e, m), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), NeQ(Subtract(Times(C2, c, d), Times(b, e)), C0), Not(IntegerQ(m)))));
            IIntegrate(712, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(d, Times(e, x)), m), Power(Plus(a, Times(c, Sqr(x))), CN1), x), x), And(FreeQ(List(a, c, d, e, m), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IntegerQ(m)))));
            IIntegrate(713, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(a_, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(d, Times(e, x)), FracPart(p)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), FracPart(p)), Power(Power(Plus(Times(a, d), Times(c, e, Power(x, C3))), FracPart(p)), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, p)), Power(Plus(Times(a, d), Times(c, e, Power(x, C3))), p)), x), x), And(FreeQ(List(a, b, c, d, e, m, p), x), EqQ(Plus(Times(b, d), Times(a, e)), C0), EqQ(Plus(Times(c, d), Times(b, e)), C0), IGtQ(Plus(m, Negate(p), C1), C0), Not(IntegerQ(p)))));
            IIntegrate(714, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Int(Times(Power(Plus(d, Times(e, x)), m), Power(Times(Sqrt(Times(b, x)), Sqrt(Plus(C1, Times(c, x, Power(b, CN1))))), CN1)), x), And(FreeQ(List(b, c, d, e), x), NeQ(Subtract(Times(c, d), Times(b, e)), C0), NeQ(Subtract(Times(C2, c, d), Times(b, e)), C0), EqQ(Sqr(m), C1D4), LtQ(c, C0), RationalQ(b))));
            IIntegrate(715, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Sqrt(x), Sqrt(Plus(b, Times(c, x))), Power(Plus(Times(b, x), Times(c, Sqr(x))), CN1D2)), Int(Times(Power(Plus(d, Times(e, x)), m), Power(Times(Sqrt(x), Sqrt(Plus(b, Times(c, x)))), CN1)), x), x), And(FreeQ(List(b, c, d, e), x), NeQ(Subtract(Times(c, d), Times(b, e)), C0), NeQ(Subtract(Times(C2, c, d), Times(b, e)), C0), EqQ(Sqr(m), C1D4))));
            IIntegrate(716, Int(Times(Power(x_, m_), Power(Plus(a_, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(C2, Subst(Int(Times(Power(x, Plus(Times(C2, m), C1)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2)), x), x, Sqrt(x)), x), And(FreeQ(List(a, b, c), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Sqr(m), C1D4))));
            IIntegrate(717, Int(Times(Power(Times(e_, x_), m_), Power(Plus(a_, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Power(Times(e, x), m), Power(Power(x, m), CN1)), Int(Times(Power(x, m), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), CN1D2)), x), x), And(FreeQ(List(a, b, c, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Sqr(m), C1D4))));
            IIntegrate(718, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(C2, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2), Power(Plus(d, Times(e, x)), m), Sqrt(Times(CN1, c, Plus(a, Times(b, x), Times(c, Sqr(x))), Power(Subtract(Sqr(b), Times(C4, a, c)), CN1))), Power(Times(c, Sqrt(Plus(a, Times(b, x), Times(c, Sqr(x)))), Power(Times(C2, c, Plus(d, Times(e, x)), Power(Subtract(Subtract(Times(C2, c, d), Times(b, e)), Times(e, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), CN1)), m)), CN1)), Subst(Int(Times(Power(Plus(C1, Times(C2, e, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2), Sqr(x), Power(Subtract(Subtract(Times(C2, c, d), Times(b, e)), Times(e, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), CN1))), m), Power(Subtract(C1, Sqr(x)), CN1D2)), x), x, Sqrt(Times(Plus(b, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2), Times(C2, c, x)), Power(Times(C2, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2)), CN1)))), x), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), NeQ(Subtract(Times(C2, c, d), Times(b, e)), C0), EqQ(Sqr(m), C1D4))));
            IIntegrate(719, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(C2, a, Rt(Times(CN1, c, Power(a, CN1)), C2), Power(Plus(d, Times(e, x)), m), Sqrt(Plus(C1, Times(c, Sqr(x), Power(a, CN1)))), Power(Times(c, Sqrt(Plus(a, Times(c, Sqr(x)))), Power(Times(c, Plus(d, Times(e, x)), Power(Subtract(Times(c, d), Times(a, e, Rt(Times(CN1, c, Power(a, CN1)), C2))), CN1)), m)), CN1)), Subst(Int(Times(Power(Plus(C1, Times(C2, a, e, Rt(Times(CN1, c, Power(a, CN1)), C2), Sqr(x), Power(Subtract(Times(c, d), Times(a, e, Rt(Times(CN1, c, Power(a, CN1)), C2))), CN1))), m), Power(Subtract(C1, Sqr(x)), CN1D2)), x), x, Sqrt(Times(C1D2, Subtract(C1, Times(Rt(Times(CN1, c, Power(a, CN1)), C2), x))))), x), And(FreeQ(List(a, c, d, e), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), EqQ(Sqr(m), C1D4))));
            IIntegrate(720, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Plus(Times(d, b), Times(CN1, C2, a, e), Times(Subtract(Times(C2, c, d), Times(b, e)), x)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p), Power(Times(C2, Plus(m, C1), Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e)))), CN1)), x)), Dist(Times(p, Subtract(Sqr(b), Times(C4, a, c)), Power(Times(C2, Plus(m, C1), Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e)))), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, C2)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Subtract(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), NeQ(Subtract(Times(C2, c, d), Times(b, e)), C0), EqQ(Plus(m, Times(C2, p), C2), C0), GtQ(p, C0))));
            IIntegrate(721, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Subtract(Negate(Simp(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Plus(Times(CN2, a, e), Times(C2, c, d, x)), Power(Plus(a, Times(c, Sqr(x))), p), Power(Times(C2, Plus(m, C1), Plus(Times(c, Sqr(d)), Times(a, Sqr(e)))), CN1)), x)), Dist(Times(C4, a, c, p, Power(Times(C2, Plus(m, C1), Plus(Times(c, Sqr(d)), Times(a, Sqr(e)))), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, C2)), Power(Plus(a, Times(c, Sqr(x))), Subtract(p, C1))), x), x)), And(FreeQ(List(a, c, d, e), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), EqQ(Plus(m, Times(C2, p), C2), C0), GtQ(p, C0))));
            IIntegrate(722, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(d, Times(e, x)), Subtract(m, C1)), Plus(Times(d, b), Times(CN1, C2, a, e), Times(Subtract(Times(C2, c, d), Times(b, e)), x)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Times(Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1)), x), Dist(Times(C2, Plus(Times(C2, p), C3), Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), Power(Times(Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C2)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), NeQ(Subtract(Times(C2, c, d), Times(b, e)), C0), EqQ(Plus(m, Times(C2, p), C2), C0), LtQ(p, CN1))));
            IIntegrate(723, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(d, Times(e, x)), Subtract(m, C1)), Subtract(Times(a, e), Times(c, d, x)), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1)), Power(Times(C2, a, c, Plus(p, C1)), CN1)), x), Dist(Times(Plus(Times(C2, p), C3), Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), Power(Times(C2, a, c, Plus(p, C1)), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C2)), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1))), x), x)), And(FreeQ(List(a, c, d, e), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), EqQ(Plus(m, Times(C2, p), C2), C0), LtQ(p, CN1))));
            IIntegrate(724, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), CN1), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(CN2, Subst(Int(Power(Subtract(Plus(Times(C4, c, Sqr(d)), Times(CN1, C4, b, d, e), Times(C4, a, Sqr(e))), Sqr(x)), CN1), x), x, Times(Subtract(Subtract(Times(C2, a, e), Times(b, d)), Times(Subtract(Times(C2, c, d), Times(b, e)), x)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), CN1D2))), x), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Subtract(Times(C2, c, d), Times(b, e)), C0))));
            IIntegrate(725, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), CN1), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Negate(Subst(Int(Power(Subtract(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), Sqr(x)), CN1), x), x, Times(Subtract(Times(a, e), Times(c, d, x)), Power(Plus(a, Times(c, Sqr(x))), CN1D2)))), FreeQ(List(a, c, d, e), x)));
        }
    }
}
