package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcTan;
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
import static org.matheclipse.core.expression.F.Coefficient;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.EllipticE;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
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
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.r;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.*;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules45 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(1126, Int(Times(Power(Times(d_DEFAULT, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(d, C3), Power(Times(d, x), Subtract(m, C3)), Power(Times(c, Subtract(m, C3)), CN1)), x), Dist(Times(Power(d, C4), Power(c, CN1)), Int(Times(Power(Times(d, x), Subtract(m, C4)), Plus(a, Times(b, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1)), x), x)), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), GtQ(m, C3))));
            IIntegrate(1127, Int(Times(Sqr(x_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(a, Power(c, CN1)), C2))), Subtract(Dist(C1D2, Int(Times(Plus(q, Sqr(x)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1)), x), x), Dist(C1D2, Int(Times(Subtract(q, Sqr(x)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1)), x), x))), And(FreeQ(List(a, b, c), x), LtQ(Subtract(Sqr(b), Times(C4, a, c)), C0), PosQ(Times(a, c)))));
            IIntegrate(1128, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(a, Power(c, CN1)), C2))), With(List(Set(r, Rt(Subtract(Times(C2, q), Times(b, Power(c, CN1))), C2))), Plus(Negate(Dist(Power(Times(C2, c, r), CN1), Int(Times(Power(x, Subtract(m, C3)), Subtract(q, Times(r, x)), Power(Plus(q, Times(CN1, r, x), Sqr(x)), CN1)), x), x)), Dist(Power(Times(C2, c, r), CN1), Int(Times(Power(x, Subtract(m, C3)), Plus(q, Times(r, x)), Power(Plus(q, Times(r, x), Sqr(x)), CN1)), x), x)))), And(FreeQ(List(a, b, c), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), GeQ(m, C3), LtQ(m, C4), NegQ(Subtract(Sqr(b), Times(C4, a, c))))));
            IIntegrate(1129, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(a, Power(c, CN1)), C2))), With(List(Set(r, Rt(Subtract(Times(C2, q), Times(b, Power(c, CN1))), C2))), Subtract(Dist(Power(Times(C2, c, r), CN1), Int(Times(Power(x, Subtract(m, C1)), Power(Plus(q, Times(CN1, r, x), Sqr(x)), CN1)), x), x), Dist(Power(Times(C2, c, r), CN1), Int(Times(Power(x, Subtract(m, C1)), Power(Plus(q, Times(r, x), Sqr(x)), CN1)), x), x)))), And(FreeQ(List(a, b, c), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), GeQ(m, C1), LtQ(m, C3), NegQ(Subtract(Sqr(b), Times(C4, a, c))))));
            IIntegrate(1130, Int(Times(Power(Times(d_DEFAULT, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Subtract(Dist(Times(C1D2, Sqr(d), Plus(Times(b, Power(q, CN1)), C1)), Int(Times(Power(Times(d, x), Subtract(m, C2)), Power(Plus(Times(C1D2, b), Times(C1D2, q), Times(c, Sqr(x))), CN1)), x), x), Dist(Times(C1D2, Sqr(d), Subtract(Times(b, Power(q, CN1)), C1)), Int(Times(Power(Times(d, x), Subtract(m, C2)), Power(Plus(Times(C1D2, b), Times(CN1, C1D2, q), Times(c, Sqr(x))), CN1)), x), x))), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), GeQ(m, C2))));
            IIntegrate(1131, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Subtract(Dist(Times(c, Power(q, CN1)), Int(Times(Power(Times(d, x), m), Power(Plus(Times(C1D2, b), Times(CN1, C1D2, q), Times(c, Sqr(x))), CN1)), x), x), Dist(Times(c, Power(q, CN1)), Int(Times(Power(Times(d, x), m), Power(Plus(Times(C1D2, b), Times(C1D2, q), Times(c, Sqr(x))), CN1)), x), x))), And(FreeQ(List(a, b, c, d, m), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(1132, Int(Times(Sqr(x_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Dist(Times(C2, Sqrt(Negate(c))), Int(Times(Sqr(x), Power(Times(Sqrt(Plus(b, q, Times(C2, c, Sqr(x)))), Sqrt(Subtract(Plus(Negate(b), q), Times(C2, c, Sqr(x))))), CN1)), x), x)), And(FreeQ(List(a, b, c), x), GtQ(Subtract(Sqr(b), Times(C4, a, c)), C0), LtQ(c, C0))));
            IIntegrate(1133, Int(Times(Sqr(x_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(c, Power(a, CN1)), C2))), Subtract(Dist(Power(q, CN1), Int(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2), x), x), Dist(Power(q, CN1), Int(Times(Subtract(C1, Times(q, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2)), x), x))), And(FreeQ(List(a, b, c), x), GtQ(Subtract(Sqr(b), Times(C4, a, c)), C0), GtQ(Times(c, Power(a, CN1)), C0), LtQ(Times(b, Power(a, CN1)), C0))));
            IIntegrate(1134, Int(Times(Sqr(x_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Plus(Negate(Dist(Times(Subtract(b, q), Power(Times(C2, c), CN1)), Int(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2), x), x)), Dist(Power(Times(C2, c), CN1), Int(Times(Plus(b, Negate(q), Times(C2, c, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2)), x), x))), And(FreeQ(List(a, b, c), x), GtQ(Subtract(Sqr(b), Times(C4, a, c)), C0), LtQ(a, C0), GtQ(c, C0))));
            IIntegrate(1135, Int(Times(Sqr(x_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Condition(Subtract(Simp(Times(x, Plus(b, q, Times(C2, c, Sqr(x))), Power(Times(C2, c, Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1)), x), Simp(Times(Rt(Times(Plus(b, q), Power(Times(C2, a), CN1)), C2), Plus(Times(C2, a), Times(Plus(b, q), Sqr(x))), Sqrt(Times(Plus(Times(C2, a), Times(Subtract(b, q), Sqr(x))), Power(Plus(Times(C2, a), Times(Plus(b, q), Sqr(x))), CN1))), EllipticE(ArcTan(Times(Rt(Times(Plus(b, q), Power(Times(C2, a), CN1)), C2), x)), Times(C2, q, Power(Plus(b, q), CN1))), Power(Times(C2, c, Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1)), x)), And(PosQ(Times(Plus(b, q), Power(a, CN1))), Not(And(PosQ(Times(Subtract(b, q), Power(a, CN1))), SimplerSqrtQ(Times(Subtract(b, q), Power(Times(C2, a), CN1)), Times(Plus(b, q), Power(Times(C2, a), CN1)))))))), And(FreeQ(List(a, b, c), x), GtQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(1136, Int(Times(Sqr(x_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Condition(Subtract(Simp(Times(x, Plus(b, Negate(q), Times(C2, c, Sqr(x))), Power(Times(C2, c, Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1)), x), Simp(Times(Rt(Times(Subtract(b, q), Power(Times(C2, a), CN1)), C2), Plus(Times(C2, a), Times(Subtract(b, q), Sqr(x))), Sqrt(Times(Plus(Times(C2, a), Times(Plus(b, q), Sqr(x))), Power(Plus(Times(C2, a), Times(Subtract(b, q), Sqr(x))), CN1))), EllipticE(ArcTan(Times(Rt(Times(Subtract(b, q), Power(Times(C2, a), CN1)), C2), x)), Times(CN2, q, Power(Subtract(b, q), CN1))), Power(Times(C2, c, Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1)), x)), PosQ(Times(Subtract(b, q), Power(a, CN1))))), And(FreeQ(List(a, b, c), x), GtQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(1137, Int(Times(Sqr(x_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Condition(Plus(Negate(Dist(Times(Plus(b, q), Power(Times(C2, c), CN1)), Int(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2), x), x)), Dist(Power(Times(C2, c), CN1), Int(Times(Plus(b, q, Times(C2, c, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2)), x), x)), And(NegQ(Times(Plus(b, q), Power(a, CN1))), Not(And(NegQ(Times(Subtract(b, q), Power(a, CN1))), SimplerSqrtQ(Times(CN1, Subtract(b, q), Power(Times(C2, a), CN1)), Times(CN1, Plus(b, q), Power(Times(C2, a), CN1)))))))), And(FreeQ(List(a, b, c), x), GtQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(1138, Int(Times(Sqr(x_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Condition(Plus(Negate(Dist(Times(Subtract(b, q), Power(Times(C2, c), CN1)), Int(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2), x), x)), Dist(Power(Times(C2, c), CN1), Int(Times(Plus(b, Negate(q), Times(C2, c, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2)), x), x)), NegQ(Times(Subtract(b, q), Power(a, CN1))))), And(FreeQ(List(a, b, c), x), GtQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(1139, Int(Times(Sqr(x_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(c, Power(a, CN1)), C2))), Subtract(Dist(Power(q, CN1), Int(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2), x), x), Dist(Power(q, CN1), Int(Times(Subtract(C1, Times(q, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2)), x), x))), And(FreeQ(List(a, b, c), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), PosQ(Times(c, Power(a, CN1))))));
            IIntegrate(1140, Int(Times(Sqr(x_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Dist(Times(Sqrt(Plus(C1, Times(C2, c, Sqr(x), Power(Subtract(b, q), CN1)))), Sqrt(Plus(C1, Times(C2, c, Sqr(x), Power(Plus(b, q), CN1)))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2)), Int(Times(Sqr(x), Power(Times(Sqrt(Plus(C1, Times(C2, c, Sqr(x), Power(Subtract(b, q), CN1)))), Sqrt(Plus(C1, Times(C2, c, Sqr(x), Power(Plus(b, q), CN1))))), CN1)), x), x)), And(FreeQ(List(a, b, c), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NegQ(Times(c, Power(a, CN1))))));
            IIntegrate(1141, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(a, IntPart(p)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), FracPart(p)), Power(Times(Power(Plus(C1, Times(C2, c, Sqr(x), Power(Plus(b, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2)), CN1))), FracPart(p)), Power(Plus(C1, Times(C2, c, Sqr(x), Power(Subtract(b, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2)), CN1))), FracPart(p))), CN1)), Int(Times(Power(Times(d, x), m), Power(Plus(C1, Times(C2, c, Sqr(x), Power(Plus(b, Sqrt(Subtract(Sqr(b), Times(C4, a, c)))), CN1))), p), Power(Plus(C1, Times(C2, c, Sqr(x), Power(Subtract(b, Sqrt(Subtract(Sqr(b), Times(C4, a, c)))), CN1))), p)), x), x), FreeQ(List(a, b, c, d, m, p), x)));
            IIntegrate(1142, Int(Times(Power(u_, m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sqr(v_)), Times(c_DEFAULT, Power(v_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(u, m), Power(Times(Coefficient(v, x, C1), Power(v, m)), CN1)), Subst(Int(Times(Power(x, m), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, Times(C2, C2)))), p)), x), x, v), x), And(FreeQ(List(a, b, c, m, p), x), LinearPairQ(u, v, x))));
            IIntegrate(1143, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), QQ(-3L, 4L))), x_Symbol),
                    Condition(Plus(Simp(Times(CN2, Subtract(Times(c, d), Times(b, e)), Power(Plus(Times(b, Sqr(x)), Times(c, Power(x, C4))), C1D4), Power(Times(b, c, x), CN1)), x), Dist(Times(e, Power(c, CN1)), Int(Times(Power(Plus(Times(b, Sqr(x)), Times(c, Power(x, C4))), C1D4), Power(x, CN2)), x), x)), FreeQ(List(b, c, d, e), x)));
            IIntegrate(1144, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Simp(Times(e, Power(Plus(Times(b, Sqr(x)), Times(c, Power(x, C4))), Plus(p, C1)), Power(Times(c, Plus(Times(C4, p), C3), x), CN1)), x), And(FreeQ(List(b, c, d, e, p), x), Not(IntegerQ(p)), NeQ(Plus(Times(C4, p), C3), C0), EqQ(Subtract(Times(b, e, Plus(Times(C2, p), C1)), Times(c, d, Plus(Times(C4, p), C3))), C0))));
            IIntegrate(1145, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(e, Power(Plus(Times(b, Sqr(x)), Times(c, Power(x, C4))), Plus(p, C1)), Power(Times(c, Plus(Times(C4, p), C3), x), CN1)), x), Dist(Times(Subtract(Times(b, e, Plus(Times(C2, p), C1)), Times(c, d, Plus(Times(C4, p), C3))), Power(Times(c, Plus(Times(C4, p), C3)), CN1)), Int(Power(Plus(Times(b, Sqr(x)), Times(c, Power(x, C4))), p), x), x)), And(FreeQ(List(b, c, d, e, p), x), Not(IntegerQ(p)), NeQ(Plus(Times(C4, p), C3), C0), NeQ(Subtract(Times(b, e, Plus(Times(C2, p), C1)), Times(c, d, Plus(Times(C4, p), C3))), C0))));
            IIntegrate(1146, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(Times(b, Sqr(x)), Times(c, Power(x, C4))), FracPart(p)), Power(Times(Power(x, Times(C2, FracPart(p))), Power(Plus(b, Times(c, Sqr(x))), FracPart(p))), CN1)), Int(Times(Power(x, Times(C2, p)), Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(b, Times(c, Sqr(x))), p)), x), x), And(FreeQ(List(b, c, d, e, p, q), x), Not(IntegerQ(p)))));
            IIntegrate(1147, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p), Power(Power(Plus(d, Times(e, Sqr(x))), Times(C2, p)), CN1)), Int(Power(Plus(d, Times(e, Sqr(x))), Plus(q, Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, p, q), x), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(p)), EqQ(Subtract(Times(C2, c, d), Times(b, e)), C0))));
            IIntegrate(1148, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), FracPart(p)), Power(Times(Power(c, IntPart(p)), Power(Plus(Times(C1D2, b), Times(c, Sqr(x))), Times(C2, FracPart(p)))), CN1)), Int(Times(Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(Times(C1D2, b), Times(c, Sqr(x))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, p, q), x), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(p)))));
            IIntegrate(1149, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Plus(d, Times(e, Sqr(x))), Plus(p, q)), Power(Plus(Times(a, Power(d, CN1)), Times(c, Sqr(x), Power(e, CN1))), p)), x), And(FreeQ(List(a, b, c, d, e, q), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), IntegerQ(p))));
            IIntegrate(1150, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Plus(d, Times(e, Sqr(x))), Plus(p, q)), Power(Plus(Times(a, Power(d, CN1)), Times(c, Sqr(x), Power(e, CN1))), p)), x), And(FreeQ(List(a, c, d, e, q), x), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), IntegerQ(p))));
        }
    }
}
