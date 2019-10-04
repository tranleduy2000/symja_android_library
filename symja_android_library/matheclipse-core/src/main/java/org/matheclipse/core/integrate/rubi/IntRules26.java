package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C2;
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
import static org.matheclipse.core.expression.F.Simplify;
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
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules26 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(651, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Simp(Times(e, Power(Plus(d, Times(e, x)), m), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1)), Power(Times(C2, c, d, Plus(p, C1)), CN1)), x), And(FreeQ(List(a, c, d, e, m, p), x), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IntegerQ(p)), EqQ(Plus(m, Times(C2, p), C2), C0))));
            IIntegrate(652, Int(Times(Sqr(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(e, Plus(d, Times(e, x)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Times(c, Plus(p, C1)), CN1)), x), Dist(Times(Sqr(e), Plus(p, C2), Power(Times(c, Plus(p, C1)), CN1)), Int(Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), x), x)), And(FreeQ(List(a, b, c, d, e, p), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), Not(IntegerQ(p)), LtQ(p, CN1))));
            IIntegrate(653, Int(Times(Sqr(Plus(d_, Times(e_DEFAULT, x_))), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(e, Plus(d, Times(e, x)), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1)), Power(Times(c, Plus(p, C1)), CN1)), x), Dist(Times(Sqr(e), Plus(p, C2), Power(Times(c, Plus(p, C1)), CN1)), Int(Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1)), x), x)), And(FreeQ(List(a, c, d, e, p), x), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IntegerQ(p)), LtQ(p, CN1))));
            IIntegrate(654, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Int(Times(Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(m, p)), Power(Power(Plus(Times(a, Power(d, CN1)), Times(c, x, Power(e, CN1))), m), CN1)), x), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), Not(IntegerQ(p)), IntegerQ(m), RationalQ(p), Or(LtQ(C0, Negate(m), p), LtQ(p, Negate(m), C0)), NeQ(m, C2), NeQ(m, CN1))));
            IIntegrate(655, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(d, Times(C2, m)), Power(Power(a, m), CN1)), Int(Times(Power(Plus(a, Times(c, Sqr(x))), Plus(m, p)), Power(Power(Subtract(d, Times(e, x)), m), CN1)), x), x), And(FreeQ(List(a, c, d, e, m, p), x), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IntegerQ(p)), IntegerQ(m), RationalQ(p), Or(LtQ(C0, Negate(m), p), LtQ(p, Negate(m), C0)), NeQ(m, C2), NeQ(m, CN1))));
            IIntegrate(656, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(e, Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Times(c, Plus(m, Times(C2, p), C1)), CN1)), x), Dist(Times(Simplify(Plus(m, p)), Subtract(Times(C2, c, d), Times(b, e)), Power(Times(c, Plus(m, Times(C2, p), C1)), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), x)), And(FreeQ(List(a, b, c, d, e, m, p), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), Not(IntegerQ(p)), IGtQ(Simplify(Plus(m, p)), C0))));
            IIntegrate(657, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(e, Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1)), Power(Times(c, Plus(m, Times(C2, p), C1)), CN1)), x), Dist(Times(C2, c, d, Simplify(Plus(m, p)), Power(Times(c, Plus(m, Times(C2, p), C1)), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(a, Times(c, Sqr(x))), p)), x), x)), And(FreeQ(List(a, c, d, e, m, p), x), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IntegerQ(p)), IGtQ(Simplify(Plus(m, p)), C0))));
            IIntegrate(658, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(e, Power(Plus(d, Times(e, x)), m), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Times(Plus(m, p, C1), Subtract(Times(C2, c, d), Times(b, e))), CN1)), x)), Dist(Times(c, Simplify(Plus(m, Times(C2, p), C2)), Power(Times(Plus(m, p, C1), Subtract(Times(C2, c, d), Times(b, e))), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), x)), And(FreeQ(List(a, b, c, d, e, m, p), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), Not(IntegerQ(p)), ILtQ(Simplify(Plus(m, Times(C2, p), C2)), C0))));
            IIntegrate(659, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(e, Power(Plus(d, Times(e, x)), m), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1)), Power(Times(C2, c, d, Plus(m, p, C1)), CN1)), x)), Dist(Times(Simplify(Plus(m, Times(C2, p), C2)), Power(Times(C2, d, Plus(m, p, C1)), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(c, Sqr(x))), p)), x), x)), And(FreeQ(List(a, c, d, e, m, p), x), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IntegerQ(p)), ILtQ(Simplify(Plus(m, Times(C2, p), C2)), C0))));
            IIntegrate(660, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), CN1D2), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(C2, e), Subst(Int(Power(Plus(Times(C2, c, d), Times(CN1, b, e), Times(Sqr(e), Sqr(x))), CN1), x), x, Times(Sqrt(Plus(a, Times(b, x), Times(c, Sqr(x)))), Power(Plus(d, Times(e, x)), CN1D2))), x), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0))));
            IIntegrate(661, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), CN1D2), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(C2, e), Subst(Int(Power(Plus(Times(C2, c, d), Times(Sqr(e), Sqr(x))), CN1), x), x, Times(Sqrt(Plus(a, Times(c, Sqr(x)))), Power(Plus(d, Times(e, x)), CN1D2))), x), And(FreeQ(List(a, c, d, e), x), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0))));
            IIntegrate(662, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p), Power(Times(e, Plus(m, p, C1)), CN1)), x), Dist(Times(c, p, Power(Times(Sqr(e), Plus(m, p, C1)), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, C2)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Subtract(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), GtQ(p, C0), Or(LtQ(m, CN2), EqQ(Plus(m, Times(C2, p), C1), C0)), NeQ(Plus(m, p, C1), C0), IntegerQ(Times(C2, p)))));
            IIntegrate(663, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(c, Sqr(x))), p), Power(Times(e, Plus(m, p, C1)), CN1)), x), Dist(Times(c, p, Power(Times(Sqr(e), Plus(m, p, C1)), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, C2)), Power(Plus(a, Times(c, Sqr(x))), Subtract(p, C1))), x), x)), And(FreeQ(List(a, c, d, e), x), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), GtQ(p, C0), Or(LtQ(m, CN2), EqQ(Plus(m, Times(C2, p), C1), C0)), NeQ(Plus(m, p, C1), C0), IntegerQ(Times(C2, p)))));
            IIntegrate(664, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p), Power(Times(e, Plus(m, Times(C2, p), C1)), CN1)), x), Dist(Times(p, Subtract(Times(C2, c, d), Times(b, e)), Power(Times(Sqr(e), Plus(m, Times(C2, p), C1)), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Subtract(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), GtQ(p, C0), Or(LeQ(CN2, m, C0), EqQ(Plus(m, p, C1), C0)), NeQ(Plus(m, Times(C2, p), C1), C0), IntegerQ(Times(C2, p)))));
            IIntegrate(665, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(c, Sqr(x))), p), Power(Times(e, Plus(m, Times(C2, p), C1)), CN1)), x), Dist(Times(C2, c, d, p, Power(Times(Sqr(e), Plus(m, Times(C2, p), C1)), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(c, Sqr(x))), Subtract(p, C1))), x), x)), And(FreeQ(List(a, c, d, e), x), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), GtQ(p, C0), Or(LeQ(CN2, m, C0), EqQ(Plus(m, p, C1), C0)), NeQ(Plus(m, Times(C2, p), C1), C0), IntegerQ(Times(C2, p)))));
            IIntegrate(666, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Subtract(Times(C2, c, d), Times(b, e)), Power(Plus(d, Times(e, x)), m), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Times(e, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1)), x), Dist(Times(Subtract(Times(C2, c, d), Times(b, e)), Plus(m, Times(C2, p), C2), Power(Times(Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), LtQ(p, CN1), LtQ(C0, m, C1), IntegerQ(Times(C2, p)))));
            IIntegrate(667, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(d, Power(Plus(d, Times(e, x)), m), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1)), Power(Times(C2, a, e, Plus(p, C1)), CN1)), x)), Dist(Times(d, Plus(m, Times(C2, p), C2), Power(Times(C2, a, Plus(p, C1)), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1))), x), x)), And(FreeQ(List(a, c, d, e), x), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), LtQ(p, CN1), LtQ(C0, m, C1), IntegerQ(Times(C2, p)))));
            IIntegrate(668, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(e, Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Times(c, Plus(p, C1)), CN1)), x), Dist(Times(Sqr(e), Plus(m, p), Power(Times(c, Plus(p, C1)), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C2)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), LtQ(p, CN1), GtQ(m, C1), IntegerQ(Times(C2, p)))));
            IIntegrate(669, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(e, Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1)), Power(Times(c, Plus(p, C1)), CN1)), x), Dist(Times(Sqr(e), Plus(m, p), Power(Times(c, Plus(p, C1)), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C2)), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1))), x), x)), And(FreeQ(List(a, c, d, e), x), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), LtQ(p, CN1), GtQ(m, C1), IntegerQ(Times(C2, p)))));
            IIntegrate(670, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(e, Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Times(c, Plus(m, Times(C2, p), C1)), CN1)), x), Dist(Times(Plus(m, p), Subtract(Times(C2, c, d), Times(b, e)), Power(Times(c, Plus(m, Times(C2, p), C1)), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), x)), And(FreeQ(List(a, b, c, d, e, p), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), GtQ(m, C1), NeQ(Plus(m, Times(C2, p), C1), C0), IntegerQ(Times(C2, p)))));
            IIntegrate(671, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(e, Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1)), Power(Times(c, Plus(m, Times(C2, p), C1)), CN1)), x), Dist(Times(C2, c, d, Plus(m, p), Power(Times(c, Plus(m, Times(C2, p), C1)), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(a, Times(c, Sqr(x))), p)), x), x)), And(FreeQ(List(a, c, d, e, p), x), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), GtQ(m, C1), NeQ(Plus(m, Times(C2, p), C1), C0), IntegerQ(Times(C2, p)))));
            IIntegrate(672, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(e, Power(Plus(d, Times(e, x)), m), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Times(Plus(m, p, C1), Subtract(Times(C2, c, d), Times(b, e))), CN1)), x)), Dist(Times(c, Plus(m, Times(C2, p), C2), Power(Times(Plus(m, p, C1), Subtract(Times(C2, c, d), Times(b, e))), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), x)), And(FreeQ(List(a, b, c, d, e, p), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), LtQ(m, C0), NeQ(Plus(m, p, C1), C0), IntegerQ(Times(C2, p)))));
            IIntegrate(673, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(e, Power(Plus(d, Times(e, x)), m), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1)), Power(Times(C2, c, d, Plus(m, p, C1)), CN1)), x)), Dist(Times(Plus(m, Times(C2, p), C2), Power(Times(C2, d, Plus(m, p, C1)), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(c, Sqr(x))), p)), x), x)), And(FreeQ(List(a, c, d, e, p), x), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), LtQ(m, C0), NeQ(Plus(m, p, C1), C0), IntegerQ(Times(C2, p)))));
            IIntegrate(674, Int(Times(Power(Times(e_DEFAULT, x_), m_), Power(Plus(Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Times(e, x), m), Power(Plus(Times(b, x), Times(c, Sqr(x))), p), Power(Times(Power(x, Plus(m, p)), Power(Plus(b, Times(c, x)), p)), CN1)), Int(Times(Power(x, Plus(m, p)), Power(Plus(b, Times(c, x)), p)), x), x), And(FreeQ(List(b, c, e, m), x), Not(IntegerQ(p)))));
            IIntegrate(675, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Int(Times(Power(Plus(d, Times(e, x)), Plus(m, p)), Power(Plus(Times(a, Power(d, CN1)), Times(c, x, Power(e, CN1))), p)), x), And(FreeQ(List(a, c, d, e, m, p), x), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IntegerQ(p)), GtQ(a, C0), GtQ(d, C0), Not(IGtQ(m, C0)))));
        }
    }
}
