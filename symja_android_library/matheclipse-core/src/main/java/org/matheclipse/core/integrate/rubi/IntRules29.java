package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcTan;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D3;
import static org.matheclipse.core.expression.F.C1D4;
import static org.matheclipse.core.expression.F.C1DSqrt3;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D3;
import static org.matheclipse.core.expression.F.CN1D4;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.CN4;
import static org.matheclipse.core.expression.F.CSqrt3;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.Hypergeometric2F1;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.If;
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
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.With;
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
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntQuadraticQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumSimplerQ;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules29 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(726, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Negate(Simp(Times(Plus(b, Negate(Rt(Subtract(Sqr(b), Times(C4, a, c)), C2)), Times(C2, c, x)), Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p), Hypergeometric2F1(Plus(m, C1), Negate(p), Plus(m, C2), Times(CN4, c, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2), Plus(d, Times(e, x)), Power(Times(Subtract(Subtract(Times(C2, c, d), Times(b, e)), Times(e, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Plus(b, Negate(Rt(Subtract(Sqr(b), Times(C4, a, c)), C2)), Times(C2, c, x))), CN1))), Power(Times(Plus(m, C1), Plus(Times(C2, c, d), Times(CN1, b, e), Times(e, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Power(Times(Plus(Times(C2, c, d), Times(CN1, b, e), Times(e, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Plus(b, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2), Times(C2, c, x)), Power(Times(Subtract(Subtract(Times(C2, c, d), Times(b, e)), Times(e, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Plus(b, Negate(Rt(Subtract(Sqr(b), Times(C4, a, c)), C2)), Times(C2, c, x))), CN1)), p)), CN1)), x)), And(FreeQ(List(a, b, c, d, e, m, p), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), NeQ(Subtract(Times(C2, c, d), Times(b, e)), C0), Not(IntegerQ(p)), EqQ(Plus(m, Times(C2, p), C2), C0))));
            IIntegrate(727, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Simp(Times(Subtract(Rt(Times(CN1, a, c), C2), Times(c, x)), Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(c, Sqr(x))), p), Hypergeometric2F1(Plus(m, C1), Negate(p), Plus(m, C2), Times(C2, c, Rt(Times(CN1, a, c), C2), Plus(d, Times(e, x)), Power(Times(Subtract(Times(c, d), Times(e, Rt(Times(CN1, a, c), C2))), Subtract(Rt(Times(CN1, a, c), C2), Times(c, x))), CN1))), Power(Times(Plus(m, C1), Plus(Times(c, d), Times(e, Rt(Times(CN1, a, c), C2))), Power(Times(Plus(Times(c, d), Times(e, Rt(Times(CN1, a, c), C2))), Plus(Rt(Times(CN1, a, c), C2), Times(c, x)), Power(Times(Subtract(Times(c, d), Times(e, Rt(Times(CN1, a, c), C2))), Plus(Negate(Rt(Times(CN1, a, c), C2)), Times(c, x))), CN1)), p)), CN1)), x), And(FreeQ(List(a, c, d, e, m, p), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IntegerQ(p)), EqQ(Plus(m, Times(C2, p), C2), C0))));
            IIntegrate(728, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(d, Times(e, x)), m), Plus(b, Times(C2, c, x)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Times(Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1)), x), Dist(Times(m, Subtract(Times(C2, c, d), Times(b, e)), Power(Times(Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, m, p), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), NeQ(Subtract(Times(C2, c, d), Times(b, e)), C0), EqQ(Plus(m, Times(C2, p), C3), C0), LtQ(p, CN1))));
            IIntegrate(729, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Subtract(Negate(Simp(Times(Power(Plus(d, Times(e, x)), m), C2, c, x, Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1)), Power(Times(C4, a, c, Plus(p, C1)), CN1)), x)), Dist(Times(m, C2, c, d, Power(Times(C4, a, c, Plus(p, C1)), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1))), x), x)), And(FreeQ(List(a, c, d, e, m, p), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), EqQ(Plus(m, Times(C2, p), C3), C0), LtQ(p, CN1))));
            IIntegrate(730, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(e, Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Times(Plus(m, C1), Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e)))), CN1)), x), Dist(Times(Subtract(Times(C2, c, d), Times(b, e)), Power(Times(C2, Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e)))), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), x)), And(FreeQ(List(a, b, c, d, e, m, p), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), NeQ(Subtract(Times(C2, c, d), Times(b, e)), C0), EqQ(Plus(m, Times(C2, p), C3), C0))));
            IIntegrate(731, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(e, Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1)), Power(Times(Plus(m, C1), Plus(Times(c, Sqr(d)), Times(a, Sqr(e)))), CN1)), x), Dist(Times(c, d, Power(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(c, Sqr(x))), p)), x), x)), And(FreeQ(List(a, c, d, e, m, p), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), EqQ(Plus(m, Times(C2, p), C3), C0))));
            IIntegrate(732, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p), Power(Times(e, Plus(m, C1)), CN1)), x), Dist(Times(p, Power(Times(e, Plus(m, C1)), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Plus(b, Times(C2, c, x)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Subtract(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, m), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), NeQ(Subtract(Times(C2, c, d), Times(b, e)), C0), GtQ(p, C0), Or(IntegerQ(p), LtQ(m, CN1)), NeQ(m, CN1), Not(ILtQ(Plus(m, Times(C2, p), C1), C0)), IntQuadraticQ(a, b, c, d, e, m, p, x))));
            IIntegrate(733, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(c, Sqr(x))), p), Power(Times(e, Plus(m, C1)), CN1)), x), Dist(Times(C2, c, p, Power(Times(e, Plus(m, C1)), CN1)), Int(Times(x, Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(c, Sqr(x))), Subtract(p, C1))), x), x)), And(FreeQ(List(a, c, d, e, m), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), GtQ(p, C0), Or(IntegerQ(p), LtQ(m, CN1)), NeQ(m, CN1), Not(ILtQ(Plus(m, Times(C2, p), C1), C0)), IntQuadraticQ(a, C0, c, d, e, m, p, x))));
            IIntegrate(734, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p), Power(Times(e, Plus(m, Times(C2, p), C1)), CN1)), x), Dist(Times(p, Power(Times(e, Plus(m, Times(C2, p), C1)), CN1)), Int(Times(Power(Plus(d, Times(e, x)), m), Simp(Plus(Times(b, d), Times(CN1, C2, a, e), Times(Subtract(Times(C2, c, d), Times(b, e)), x)), x), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Subtract(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, m), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), NeQ(Subtract(Times(C2, c, d), Times(b, e)), C0), GtQ(p, C0), NeQ(Plus(m, Times(C2, p), C1), C0), Or(Not(RationalQ(m)), LtQ(m, C1)), Not(ILtQ(Plus(m, Times(C2, p)), C0)), IntQuadraticQ(a, b, c, d, e, m, p, x))));
            IIntegrate(735, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(c, Sqr(x))), p), Power(Times(e, Plus(m, Times(C2, p), C1)), CN1)), x), Dist(Times(C2, p, Power(Times(e, Plus(m, Times(C2, p), C1)), CN1)), Int(Times(Power(Plus(d, Times(e, x)), m), Simp(Subtract(Times(a, e), Times(c, d, x)), x), Power(Plus(a, Times(c, Sqr(x))), Subtract(p, C1))), x), x)), And(FreeQ(List(a, c, d, e, m), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), GtQ(p, C0), NeQ(Plus(m, Times(C2, p), C1), C0), Or(Not(RationalQ(m)), LtQ(m, C1)), Not(ILtQ(Plus(m, Times(C2, p)), C0)), IntQuadraticQ(a, C0, c, d, e, m, p, x))));
            IIntegrate(736, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(d, Times(e, x)), m), Plus(b, Times(C2, c, x)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Times(Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1)), x), Dist(Power(Times(Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C1)), Plus(Times(b, e, m), Times(C2, c, d, Plus(Times(C2, p), C3)), Times(C2, c, e, Plus(m, Times(C2, p), C3), x)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), NeQ(Subtract(Times(C2, c, d), Times(b, e)), C0), LtQ(p, CN1), GtQ(m, C0), Or(LtQ(m, C1), And(ILtQ(Plus(m, Times(C2, p), C3), C0), NeQ(m, C2))), IntQuadraticQ(a, b, c, d, e, m, p, x))));
            IIntegrate(737, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(x, Power(Plus(d, Times(e, x)), m), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1)), Power(Times(C2, a, Plus(p, C1)), CN1)), x)), Dist(Power(Times(C2, a, Plus(p, C1)), CN1), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C1)), Plus(Times(d, Plus(Times(C2, p), C3)), Times(e, Plus(m, Times(C2, p), C3), x)), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1))), x), x)), And(FreeQ(List(a, c, d, e), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), LtQ(p, CN1), GtQ(m, C0), Or(LtQ(m, C1), And(ILtQ(Plus(m, Times(C2, p), C3), C0), NeQ(m, C2))), IntQuadraticQ(a, C0, c, d, e, m, p, x))));
            IIntegrate(738, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(d, Times(e, x)), Subtract(m, C1)), Plus(Times(d, b), Times(CN1, C2, a, e), Times(Subtract(Times(C2, c, d), Times(b, e)), x)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Times(Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1)), x), Dist(Power(Times(Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C2)), Simp(Plus(Times(e, Plus(Times(C2, a, e, Subtract(m, C1)), Times(b, d, Plus(Times(C2, p), Negate(m), C4)))), Times(CN1, C2, c, Sqr(d), Plus(Times(C2, p), C3)), Times(e, Subtract(Times(b, e), Times(C2, d, c)), Plus(m, Times(C2, p), C2), x)), x), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), NeQ(Subtract(Times(C2, c, d), Times(b, e)), C0), LtQ(p, CN1), GtQ(m, C1), IntQuadraticQ(a, b, c, d, e, m, p, x))));
            IIntegrate(739, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(d, Times(e, x)), Subtract(m, C1)), Subtract(Times(a, e), Times(c, d, x)), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1)), Power(Times(C2, a, c, Plus(p, C1)), CN1)), x), Dist(Power(Times(Plus(p, C1), CN2, a, c), CN1), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C2)), Simp(Subtract(Subtract(Times(a, Sqr(e), Subtract(m, C1)), Times(c, Sqr(d), Plus(Times(C2, p), C3))), Times(d, c, e, Plus(m, Times(C2, p), C2), x)), x), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1))), x), x)), And(FreeQ(List(a, c, d, e), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), LtQ(p, CN1), GtQ(m, C1), IntQuadraticQ(a, C0, c, d, e, m, p, x))));
            IIntegrate(740, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Plus(Times(b, c, d), Times(CN1, Sqr(b), e), Times(C2, a, c, e), Times(c, Subtract(Times(C2, c, d), Times(b, e)), x)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Times(Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c)), Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e)))), CN1)), x), Dist(Power(Times(Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c)), Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e)))), CN1), Int(Times(Power(Plus(d, Times(e, x)), m), Simp(Subtract(Subtract(Subtract(Plus(Times(b, c, d, e, Plus(Times(C2, p), Negate(m), C2)), Times(Sqr(b), Sqr(e), Plus(m, p, C2))), Times(C2, Sqr(c), Sqr(d), Plus(Times(C2, p), C3))), Times(C2, a, c, Sqr(e), Plus(m, Times(C2, p), C3))), Times(c, e, Subtract(Times(C2, c, d), Times(b, e)), Plus(m, Times(C2, p), C4), x)), x), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, m), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), NeQ(Subtract(Times(C2, c, d), Times(b, e)), C0), LtQ(p, CN1), IntQuadraticQ(a, b, c, d, e, m, p, x))));
            IIntegrate(741, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Plus(Times(a, e), Times(c, d, x)), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1)), Power(Times(C2, a, Plus(p, C1), Plus(Times(c, Sqr(d)), Times(a, Sqr(e)))), CN1)), x)), Dist(Power(Times(C2, a, Plus(p, C1), Plus(Times(c, Sqr(d)), Times(a, Sqr(e)))), CN1), Int(Times(Power(Plus(d, Times(e, x)), m), Simp(Plus(Times(c, Sqr(d), Plus(Times(C2, p), C3)), Times(a, Sqr(e), Plus(m, Times(C2, p), C3)), Times(c, e, d, Plus(m, Times(C2, p), C4), x)), x), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1))), x), x)), And(FreeQ(List(a, c, d, e, m), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), LtQ(p, CN1), IntQuadraticQ(a, C0, c, d, e, m, p, x))));
            IIntegrate(742, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(e, Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Times(c, Plus(m, Times(C2, p), C1)), CN1)), x), Dist(Power(Times(c, Plus(m, Times(C2, p), C1)), CN1), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C2)), Simp(Plus(Times(c, Sqr(d), Plus(m, Times(C2, p), C1)), Times(CN1, e, Plus(Times(a, e, Subtract(m, C1)), Times(b, d, Plus(p, C1)))), Times(e, Subtract(Times(C2, c, d), Times(b, e)), Plus(m, p), x)), x), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), x)), And(FreeQ(List(a, b, c, d, e, m, p), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), NeQ(Subtract(Times(C2, c, d), Times(b, e)), C0), If(RationalQ(m), GtQ(m, C1), SumSimplerQ(m, CN2)), NeQ(Plus(m, Times(C2, p), C1), C0), IntQuadraticQ(a, b, c, d, e, m, p, x))));
            IIntegrate(743, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(e, Power(Plus(d, Times(e, x)), Subtract(m, C1)), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1)), Power(Times(c, Plus(m, Times(C2, p), C1)), CN1)), x), Dist(Power(Times(c, Plus(m, Times(C2, p), C1)), CN1), Int(Times(Power(Plus(d, Times(e, x)), Subtract(m, C2)), Simp(Plus(Times(c, Sqr(d), Plus(m, Times(C2, p), C1)), Times(CN1, a, Sqr(e), Subtract(m, C1)), Times(C2, c, d, e, Plus(m, p), x)), x), Power(Plus(a, Times(c, Sqr(x))), p)), x), x)), And(FreeQ(List(a, c, d, e, m, p), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), If(RationalQ(m), GtQ(m, C1), SumSimplerQ(m, CN2)), NeQ(Plus(m, Times(C2, p), C1), C0), IntQuadraticQ(a, C0, c, d, e, m, p, x))));
            IIntegrate(744, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(e, Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Times(Plus(m, C1), Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e)))), CN1)), x), Dist(Power(Times(Plus(m, C1), Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e)))), CN1), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Simp(Subtract(Subtract(Times(c, d, Plus(m, C1)), Times(b, e, Plus(m, p, C2))), Times(c, e, Plus(m, Times(C2, p), C3), x)), x), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), x)), And(FreeQ(List(a, b, c, d, e, m, p), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), NeQ(Subtract(Times(C2, c, d), Times(b, e)), C0), NeQ(m, CN1), Or(And(LtQ(m, CN1), IntQuadraticQ(a, b, c, d, e, m, p, x)), And(SumSimplerQ(m, C1), IntegerQ(p)), ILtQ(Simplify(Plus(m, Times(C2, p), C3)), C0)))));
            IIntegrate(745, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(e, Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1)), Power(Times(Plus(m, C1), Plus(Times(c, Sqr(d)), Times(a, Sqr(e)))), CN1)), x), Dist(Times(c, Power(Times(Plus(m, C1), Plus(Times(c, Sqr(d)), Times(a, Sqr(e)))), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Simp(Subtract(Times(d, Plus(m, C1)), Times(e, Plus(m, Times(C2, p), C3), x)), x), Power(Plus(a, Times(c, Sqr(x))), p)), x), x)), And(FreeQ(List(a, c, d, e, m, p), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), NeQ(m, CN1), Or(And(LtQ(m, CN1), IntQuadraticQ(a, C0, c, d, e, m, p, x)), And(SumSimplerQ(m, C1), IntegerQ(p)), ILtQ(Simplify(Plus(m, Times(C2, p), C3)), C0)))));
            IIntegrate(746, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), CN1), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), CN1D4)), x_Symbol),
                    Condition(Subtract(Dist(d, Int(Power(Times(Subtract(Sqr(d), Times(Sqr(e), Sqr(x))), Power(Plus(a, Times(c, Sqr(x))), C1D4)), CN1), x), x), Dist(e, Int(Times(x, Power(Times(Subtract(Sqr(d), Times(Sqr(e), Sqr(x))), Power(Plus(a, Times(c, Sqr(x))), C1D4)), CN1)), x), x)), And(FreeQ(List(a, c, d, e), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0))));
            IIntegrate(747, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), CN1), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), QQ(-3L, 4L))), x_Symbol),
                    Condition(Subtract(Dist(d, Int(Power(Times(Subtract(Sqr(d), Times(Sqr(e), Sqr(x))), Power(Plus(a, Times(c, Sqr(x))), QQ(3L, 4L))), CN1), x), x), Dist(e, Int(Times(x, Power(Times(Subtract(Sqr(d), Times(Sqr(e), Sqr(x))), Power(Plus(a, Times(c, Sqr(x))), QQ(3L, 4L))), CN1)), x), x)), And(FreeQ(List(a, c, d, e), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0))));
            IIntegrate(748, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), CN1), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Dist(Power(Power(Times(CN4, c, Power(Subtract(Sqr(b), Times(C4, a, c)), CN1)), p), CN1), Subst(Int(Times(Power(Simp(Subtract(C1, Times(Sqr(x), Power(Subtract(Sqr(b), Times(C4, a, c)), CN1))), x), p), Power(Simp(Plus(Times(C2, c, d), Times(CN1, b, e), Times(e, x)), x), CN1)), x), x, Plus(b, Times(C2, c, x))), x), And(FreeQ(List(a, b, c, d, e, p), x), GtQ(Subtract(Times(C4, a), Times(Sqr(b), Power(c, CN1))), C0), IntegerQ(Times(C4, p)))));
            IIntegrate(749, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), CN1), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p), Power(Power(Times(CN1, c, Plus(a, Times(b, x), Times(c, Sqr(x))), Power(Subtract(Sqr(b), Times(C4, a, c)), CN1)), p), CN1)), Int(Times(Power(Subtract(Subtract(Times(CN1, a, c, Power(Subtract(Sqr(b), Times(C4, a, c)), CN1)), Times(b, c, x, Power(Subtract(Sqr(b), Times(C4, a, c)), CN1))), Times(Sqr(c), Sqr(x), Power(Subtract(Sqr(b), Times(C4, a, c)), CN1))), p), Power(Plus(d, Times(e, x)), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, p), x), Not(GtQ(Subtract(Times(C4, a), Times(Sqr(b), Power(c, CN1))), C0)), IntegerQ(Times(C4, p)))));
            IIntegrate(750, Int(Times(Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), CN1), Power(Plus(a_, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1D3)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(C3, c, Sqr(e), Subtract(Times(C2, c, d), Times(b, e))), C3))), Plus(Negate(Simp(Times(CSqrt3, c, e, ArcTan(Plus(C1DSqrt3, Times(C2, Subtract(Subtract(Times(c, d), Times(b, e)), Times(c, e, x)), Power(Times(CSqrt3, q, Power(Plus(a, Times(b, x), Times(c, Sqr(x))), C1D3)), CN1)))), Power(q, CN2)), x)), Negate(Simp(Times(C3, c, e, Log(Plus(d, Times(e, x))), Power(Times(C2, Sqr(q)), CN1)), x)), Simp(Times(C3, c, e, Log(Subtract(Subtract(Subtract(Times(c, d), Times(b, e)), Times(c, e, x)), Times(q, Power(Plus(a, Times(b, x), Times(c, Sqr(x))), C1D3)))), Power(Times(C2, Sqr(q)), CN1)), x))), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Times(C2, c, d), Times(b, e)), C0), EqQ(Subtract(Plus(Times(Sqr(c), Sqr(d)), Times(CN1, b, c, d, e), Times(Sqr(b), Sqr(e))), Times(C3, a, c, Sqr(e))), C0), PosQ(Times(c, Sqr(e), Subtract(Times(C2, c, d), Times(b, e)))))));
        }
    }
}
