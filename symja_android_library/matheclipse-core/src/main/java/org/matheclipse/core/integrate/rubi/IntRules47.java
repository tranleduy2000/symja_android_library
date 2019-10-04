package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcSin;
import static org.matheclipse.core.expression.F.ArcTan;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.C5;
import static org.matheclipse.core.expression.F.C7;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CSqrt2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.EllipticE;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NegQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplerSqrtQ;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules47 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(1176, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(x, Plus(Times(C2, b, e, p), Times(c, d, Plus(Times(C4, p), C3)), Times(c, e, Plus(Times(C4, p), C1), Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p), Power(Times(c, Plus(Times(C4, p), C1), Plus(Times(C4, p), C3)), CN1)), x), Dist(Times(C2, p, Power(Times(c, Plus(Times(C4, p), C1), Plus(Times(C4, p), C3)), CN1)), Int(Times(Simp(Plus(Times(C2, a, c, d, Plus(Times(C4, p), C3)), Times(CN1, a, b, e), Times(Subtract(Plus(Times(C2, a, c, e, Plus(Times(C4, p), C1)), Times(b, c, d, Plus(Times(C4, p), C3))), Times(Sqr(b), e, Plus(Times(C2, p), C1))), Sqr(x))), x), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Subtract(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), GtQ(p, C0), FractionQ(p), IntegerQ(Times(C2, p)))));
            IIntegrate(1177, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(x, Plus(Times(d, Plus(Times(C4, p), C3)), Times(e, Plus(Times(C4, p), C1), Sqr(x))), Power(Plus(a, Times(c, Power(x, C4))), p), Power(Times(Plus(Times(C4, p), C1), Plus(Times(C4, p), C3)), CN1)), x), Dist(Times(C2, p, Power(Times(Plus(Times(C4, p), C1), Plus(Times(C4, p), C3)), CN1)), Int(Times(Simp(Plus(Times(C2, a, d, Plus(Times(C4, p), C3)), Times(C2, a, e, Plus(Times(C4, p), C1), Sqr(x))), x), Power(Plus(a, Times(c, Power(x, C4))), Subtract(p, C1))), x), x)), And(FreeQ(List(a, c, d, e), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), GtQ(p, C0), FractionQ(p), IntegerQ(Times(C2, p)))));
            IIntegrate(1178, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(x, Subtract(Subtract(Times(a, b, e), Times(d, Subtract(Sqr(b), Times(C2, a, c)))), Times(c, Subtract(Times(b, d), Times(C2, a, e)), Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Plus(p, C1)), Power(Times(C2, a, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1)), x), Dist(Power(Times(C2, a, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1), Int(Times(Simp(Plus(Times(Plus(Times(C2, p), C3), d, Sqr(b)), Times(CN1, a, b, e), Times(CN1, C2, a, c, d, Plus(Times(C4, p), C5)), Times(Plus(Times(C4, p), C7), Subtract(Times(d, b), Times(C2, a, e)), c, Sqr(x))), x), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), LtQ(p, CN1), IntegerQ(Times(C2, p)))));
            IIntegrate(1179, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(x, Plus(d, Times(e, Sqr(x))), Power(Plus(a, Times(c, Power(x, C4))), Plus(p, C1)), Power(Times(C4, a, Plus(p, C1)), CN1)), x)), Dist(Power(Times(C4, a, Plus(p, C1)), CN1), Int(Times(Simp(Plus(Times(d, Plus(Times(C4, p), C5)), Times(e, Plus(Times(C4, p), C7), Sqr(x))), x), Power(Plus(a, Times(c, Power(x, C4))), Plus(p, C1))), x), x)), And(FreeQ(List(a, c, d, e), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), LtQ(p, CN1), IntegerQ(Times(C2, p)))));
            IIntegrate(1180, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Dist(Times(C2, Sqrt(Negate(c))), Int(Times(Plus(d, Times(e, Sqr(x))), Power(Times(Sqrt(Plus(b, q, Times(C2, c, Sqr(x)))), Sqrt(Subtract(Plus(Negate(b), q), Times(C2, c, Sqr(x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), GtQ(Subtract(Sqr(b), Times(C4, a, c)), C0), LtQ(c, C0))));
            IIntegrate(1181, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(CN1, a, c), C2))), Dist(Sqrt(Negate(c)), Int(Times(Plus(d, Times(e, Sqr(x))), Power(Times(Sqrt(Plus(q, Times(c, Sqr(x)))), Sqrt(Subtract(q, Times(c, Sqr(x))))), CN1)), x), x)), And(FreeQ(List(a, c, d, e), x), GtQ(a, C0), LtQ(c, C0))));
            IIntegrate(1182, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(c, Power(a, CN1)), C4))), Condition(Plus(Negate(Simp(Times(d, x, Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4)))), Power(Times(a, Plus(C1, Times(Sqr(q), Sqr(x)))), CN1)), x)), Simp(Times(d, Plus(C1, Times(Sqr(q), Sqr(x))), Sqrt(Times(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Power(Times(a, Sqr(Plus(C1, Times(Sqr(q), Sqr(x))))), CN1))), EllipticE(Times(C2, ArcTan(Times(q, x))), Subtract(C1D2, Times(b, Sqr(q), Power(Times(C4, c), CN1)))), Power(Times(q, Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1)), x)), EqQ(Plus(e, Times(d, Sqr(q))), C0))), And(FreeQ(List(a, b, c, d, e), x), GtQ(Subtract(Sqr(b), Times(C4, a, c)), C0), GtQ(Times(c, Power(a, CN1)), C0), LtQ(Times(b, Power(a, CN1)), C0))));
            IIntegrate(1183, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(c, Power(a, CN1)), C2))), Condition(Subtract(Dist(Times(Plus(e, Times(d, q)), Power(q, CN1)), Int(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2), x), x), Dist(Times(e, Power(q, CN1)), Int(Times(Subtract(C1, Times(q, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2)), x), x)), NeQ(Plus(e, Times(d, q)), C0))), And(FreeQ(List(a, b, c, d, e), x), GtQ(Subtract(Sqr(b), Times(C4, a, c)), C0), GtQ(Times(c, Power(a, CN1)), C0), LtQ(Times(b, Power(a, CN1)), C0))));
            IIntegrate(1184, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Condition(Subtract(Simp(Times(e, x, Plus(b, q, Times(C2, c, Sqr(x))), Power(Times(C2, c, Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1)), x), Simp(Times(e, q, Sqrt(Times(Plus(Times(C2, a), Times(Subtract(b, q), Sqr(x))), Power(Plus(Times(C2, a), Times(Plus(b, q), Sqr(x))), CN1))), Sqrt(Times(Plus(Times(C2, a), Times(Plus(b, q), Sqr(x))), Power(q, CN1))), EllipticE(ArcSin(Times(x, Power(Times(Plus(Times(C2, a), Times(Plus(b, q), Sqr(x))), Power(Times(C2, q), CN1)), CN1D2))), Times(Plus(b, q), Power(Times(C2, q), CN1))), Power(Times(C2, c, Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4)))), Sqrt(Times(a, Power(Plus(Times(C2, a), Times(Plus(b, q), Sqr(x))), CN1)))), CN1)), x)), EqQ(Subtract(Times(C2, c, d), Times(e, Subtract(b, q))), C0))), And(FreeQ(List(a, b, c, d, e), x), GtQ(Subtract(Sqr(b), Times(C4, a, c)), C0), LtQ(a, C0), GtQ(c, C0))));
            IIntegrate(1185, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(CN1, a, c), C2))), Condition(Subtract(Simp(Times(e, x, Plus(q, Times(c, Sqr(x))), Power(Times(c, Sqrt(Plus(a, Times(c, Power(x, C4))))), CN1)), x), Simp(Times(CSqrt2, e, q, Sqrt(Plus(Negate(a), Times(q, Sqr(x)))), Sqrt(Times(Plus(a, Times(q, Sqr(x))), Power(q, CN1))), EllipticE(ArcSin(Times(x, Power(Times(Plus(a, Times(q, Sqr(x))), Power(Times(C2, q), CN1)), CN1D2))), C1D2), Power(Times(Sqrt(Negate(a)), c, Sqrt(Plus(a, Times(c, Power(x, C4))))), CN1)), x)), And(EqQ(Plus(Times(c, d), Times(e, q)), C0), IntegerQ(q)))), And(FreeQ(List(a, c, d, e), x), LtQ(a, C0), GtQ(c, C0))));
            IIntegrate(1186, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(CN1, a, c), C2))), Condition(Subtract(Simp(Times(e, x, Plus(q, Times(c, Sqr(x))), Power(Times(c, Sqrt(Plus(a, Times(c, Power(x, C4))))), CN1)), x), Simp(Times(CSqrt2, e, q, Sqrt(Times(Subtract(a, Times(q, Sqr(x))), Power(Plus(a, Times(q, Sqr(x))), CN1))), Sqrt(Times(Plus(a, Times(q, Sqr(x))), Power(q, CN1))), EllipticE(ArcSin(Times(x, Power(Times(Plus(a, Times(q, Sqr(x))), Power(Times(C2, q), CN1)), CN1D2))), C1D2), Power(Times(c, Sqrt(Plus(a, Times(c, Power(x, C4)))), Sqrt(Times(a, Power(Plus(a, Times(q, Sqr(x))), CN1)))), CN1)), x)), EqQ(Plus(Times(c, d), Times(e, q)), C0))), And(FreeQ(List(a, c, d, e), x), LtQ(a, C0), GtQ(c, C0))));
            IIntegrate(1187, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Condition(Plus(Dist(Times(Subtract(Times(C2, c, d), Times(e, Subtract(b, q))), Power(Times(C2, c), CN1)), Int(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2), x), x), Dist(Times(e, Power(Times(C2, c), CN1)), Int(Times(Plus(b, Negate(q), Times(C2, c, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2)), x), x)), NeQ(Subtract(Times(C2, c, d), Times(e, Subtract(b, q))), C0))), And(FreeQ(List(a, b, c, d, e), x), GtQ(Subtract(Sqr(b), Times(C4, a, c)), C0), LtQ(a, C0), GtQ(c, C0))));
            IIntegrate(1188, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(CN1, a, c), C2))), Condition(Subtract(Dist(Times(Plus(Times(c, d), Times(e, q)), Power(c, CN1)), Int(Power(Plus(a, Times(c, Power(x, C4))), CN1D2), x), x), Dist(Times(e, Power(c, CN1)), Int(Times(Subtract(q, Times(c, Sqr(x))), Power(Plus(a, Times(c, Power(x, C4))), CN1D2)), x), x)), NeQ(Plus(Times(c, d), Times(e, q)), C0))), And(FreeQ(List(a, c, d, e), x), LtQ(a, C0), GtQ(c, C0))));
            IIntegrate(1189, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Condition(Plus(Dist(d, Int(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2), x), x), Dist(e, Int(Times(Sqr(x), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2)), x), x)), Or(PosQ(Times(Plus(b, q), Power(a, CN1))), PosQ(Times(Subtract(b, q), Power(a, CN1)))))), And(FreeQ(List(a, b, c, d, e), x), GtQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(1190, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(Plus(Dist(d, Int(Power(Plus(a, Times(c, Power(x, C4))), CN1D2), x), x), Dist(e, Int(Times(Sqr(x), Power(Plus(a, Times(c, Power(x, C4))), CN1D2)), x), x)), And(FreeQ(List(a, c, d, e), x), GtQ(Times(CN1, a, c), C0))));
            IIntegrate(1191, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Condition(Negate(Simp(Times(a, e, Rt(Times(CN1, Plus(b, q), Power(Times(C2, a), CN1)), C2), Sqrt(Plus(C1, Times(Plus(b, q), Sqr(x), Power(Times(C2, a), CN1)))), Sqrt(Plus(C1, Times(Subtract(b, q), Sqr(x), Power(Times(C2, a), CN1)))), EllipticE(ArcSin(Times(Rt(Times(CN1, Plus(b, q), Power(Times(C2, a), CN1)), C2), x)), Times(Subtract(b, q), Power(Plus(b, q), CN1))), Power(Times(c, Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1)), x)), And(NegQ(Times(Plus(b, q), Power(a, CN1))), EqQ(Subtract(Times(C2, c, d), Times(e, Plus(b, q))), C0), Not(SimplerSqrtQ(Times(CN1, Subtract(b, q), Power(Times(C2, a), CN1)), Times(CN1, Plus(b, q), Power(Times(C2, a), CN1))))))), And(FreeQ(List(a, b, c, d, e), x), GtQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(1192, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Condition(Plus(Dist(Times(Subtract(Times(C2, c, d), Times(e, Plus(b, q))), Power(Times(C2, c), CN1)), Int(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2), x), x), Dist(Times(e, Power(Times(C2, c), CN1)), Int(Times(Plus(b, q, Times(C2, c, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2)), x), x)), And(NegQ(Times(Plus(b, q), Power(a, CN1))), NeQ(Subtract(Times(C2, c, d), Times(e, Plus(b, q))), C0), Not(SimplerSqrtQ(Times(CN1, Subtract(b, q), Power(Times(C2, a), CN1)), Times(CN1, Plus(b, q), Power(Times(C2, a), CN1))))))), And(FreeQ(List(a, b, c, d, e), x), GtQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(1193, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Condition(Negate(Simp(Times(a, e, Rt(Times(CN1, Subtract(b, q), Power(Times(C2, a), CN1)), C2), Sqrt(Plus(C1, Times(Subtract(b, q), Sqr(x), Power(Times(C2, a), CN1)))), Sqrt(Plus(C1, Times(Plus(b, q), Sqr(x), Power(Times(C2, a), CN1)))), EllipticE(ArcSin(Times(Rt(Times(CN1, Subtract(b, q), Power(Times(C2, a), CN1)), C2), x)), Times(Plus(b, q), Power(Subtract(b, q), CN1))), Power(Times(c, Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1)), x)), And(NegQ(Times(Subtract(b, q), Power(a, CN1))), EqQ(Subtract(Times(C2, c, d), Times(e, Subtract(b, q))), C0)))), And(FreeQ(List(a, b, c, d, e), x), GtQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(1194, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Condition(Plus(Dist(Times(Subtract(Times(C2, c, d), Times(e, Subtract(b, q))), Power(Times(C2, c), CN1)), Int(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2), x), x), Dist(Times(e, Power(Times(C2, c), CN1)), Int(Times(Plus(b, Negate(q), Times(C2, c, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2)), x), x)), And(NegQ(Times(Subtract(b, q), Power(a, CN1))), NeQ(Subtract(Times(C2, c, d), Times(e, Subtract(b, q))), C0)))), And(FreeQ(List(a, b, c, d, e), x), GtQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(1195, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(c, Power(a, CN1)), C4))), Condition(Plus(Negate(Simp(Times(d, x, Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4)))), Power(Times(a, Plus(C1, Times(Sqr(q), Sqr(x)))), CN1)), x)), Simp(Times(d, Plus(C1, Times(Sqr(q), Sqr(x))), Sqrt(Times(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Power(Times(a, Sqr(Plus(C1, Times(Sqr(q), Sqr(x))))), CN1))), EllipticE(Times(C2, ArcTan(Times(q, x))), Subtract(C1D2, Times(b, Sqr(q), Power(Times(C4, c), CN1)))), Power(Times(q, Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1)), x)), EqQ(Plus(e, Times(d, Sqr(q))), C0))), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), PosQ(Times(c, Power(a, CN1))))));
            IIntegrate(1196, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(c, Power(a, CN1)), C4))), Condition(Plus(Negate(Simp(Times(d, x, Sqrt(Plus(a, Times(c, Power(x, C4)))), Power(Times(a, Plus(C1, Times(Sqr(q), Sqr(x)))), CN1)), x)), Simp(Times(d, Plus(C1, Times(Sqr(q), Sqr(x))), Sqrt(Times(Plus(a, Times(c, Power(x, C4))), Power(Times(a, Sqr(Plus(C1, Times(Sqr(q), Sqr(x))))), CN1))), EllipticE(Times(C2, ArcTan(Times(q, x))), C1D2), Power(Times(q, Sqrt(Plus(a, Times(c, Power(x, C4))))), CN1)), x)), EqQ(Plus(e, Times(d, Sqr(q))), C0))), And(FreeQ(List(a, c, d, e), x), PosQ(Times(c, Power(a, CN1))))));
            IIntegrate(1197, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(c, Power(a, CN1)), C2))), Condition(Subtract(Dist(Times(Plus(e, Times(d, q)), Power(q, CN1)), Int(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2), x), x), Dist(Times(e, Power(q, CN1)), Int(Times(Subtract(C1, Times(q, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2)), x), x)), NeQ(Plus(e, Times(d, q)), C0))), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), PosQ(Times(c, Power(a, CN1))))));
            IIntegrate(1198, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(c, Power(a, CN1)), C2))), Condition(Subtract(Dist(Times(Plus(e, Times(d, q)), Power(q, CN1)), Int(Power(Plus(a, Times(c, Power(x, C4))), CN1D2), x), x), Dist(Times(e, Power(q, CN1)), Int(Times(Subtract(C1, Times(q, Sqr(x))), Power(Plus(a, Times(c, Power(x, C4))), CN1D2)), x), x)), NeQ(Plus(e, Times(d, q)), C0))), And(FreeQ(List(a, c, d, e), x), PosQ(Times(c, Power(a, CN1))))));
            IIntegrate(1199, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(d, Power(a, CN1D2)), Int(Times(Sqrt(Plus(C1, Times(e, Sqr(x), Power(d, CN1)))), Power(Subtract(C1, Times(e, Sqr(x), Power(d, CN1))), CN1D2)), x), x), And(FreeQ(List(a, c, d, e), x), NegQ(Times(c, Power(a, CN1))), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), GtQ(a, C0))));
            IIntegrate(1200, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Plus(C1, Times(c, Power(x, C4), Power(a, CN1)))), Power(Plus(a, Times(c, Power(x, C4))), CN1D2)), Int(Times(Plus(d, Times(e, Sqr(x))), Power(Plus(C1, Times(c, Power(x, C4), Power(a, CN1))), CN1D2)), x), x), And(FreeQ(List(a, c, d, e), x), NegQ(Times(c, Power(a, CN1))), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(GtQ(a, C0)))));
        }
    }
}
