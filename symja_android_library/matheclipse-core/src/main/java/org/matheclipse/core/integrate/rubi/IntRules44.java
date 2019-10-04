package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
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
import static org.matheclipse.core.expression.F.C8;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.CN4;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.EllipticF;
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
import static org.matheclipse.core.expression.F.ZZ;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.k;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Coeff;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NegQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PolyQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PolynomialDivide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplerSqrtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules44 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(1101, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Condition(Simp(Times(Sqrt(Plus(C1, Times(Plus(b, q), Sqr(x), Power(Times(C2, a), CN1)))), Sqrt(Plus(C1, Times(Subtract(b, q), Sqr(x), Power(Times(C2, a), CN1)))), EllipticF(ArcSin(Times(Rt(Times(CN1, Plus(b, q), Power(Times(C2, a), CN1)), C2), x)), Times(Subtract(b, q), Power(Plus(b, q), CN1))), Power(Times(Rt(Times(CN1, Plus(b, q), Power(Times(C2, a), CN1)), C2), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1)), x), And(NegQ(Times(Plus(b, q), Power(a, CN1))), Not(And(NegQ(Times(Subtract(b, q), Power(a, CN1))), SimplerSqrtQ(Times(CN1, Subtract(b, q), Power(Times(C2, a), CN1)), Times(CN1, Plus(b, q), Power(Times(C2, a), CN1)))))))), And(FreeQ(List(a, b, c), x), GtQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(1102, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Condition(Simp(Times(Sqrt(Plus(C1, Times(Subtract(b, q), Sqr(x), Power(Times(C2, a), CN1)))), Sqrt(Plus(C1, Times(Plus(b, q), Sqr(x), Power(Times(C2, a), CN1)))), EllipticF(ArcSin(Times(Rt(Times(CN1, Subtract(b, q), Power(Times(C2, a), CN1)), C2), x)), Times(Plus(b, q), Power(Subtract(b, q), CN1))), Power(Times(Rt(Times(CN1, Subtract(b, q), Power(Times(C2, a), CN1)), C2), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1)), x), NegQ(Times(Subtract(b, q), Power(a, CN1))))), And(FreeQ(List(a, b, c), x), GtQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(1103, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(c, Power(a, CN1)), C4))), Simp(Times(Plus(C1, Times(Sqr(q), Sqr(x))), Sqrt(Times(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Power(Times(a, Sqr(Plus(C1, Times(Sqr(q), Sqr(x))))), CN1))), EllipticF(Times(C2, ArcTan(Times(q, x))), Subtract(C1D2, Times(b, Sqr(q), Power(Times(C4, c), CN1)))), Power(Times(C2, q, Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1)), x)), And(FreeQ(List(a, b, c), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), PosQ(Times(c, Power(a, CN1))))));
            IIntegrate(1104, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Dist(Times(Sqrt(Plus(C1, Times(C2, c, Sqr(x), Power(Subtract(b, q), CN1)))), Sqrt(Plus(C1, Times(C2, c, Sqr(x), Power(Plus(b, q), CN1)))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2)), Int(Power(Times(Sqrt(Plus(C1, Times(C2, c, Sqr(x), Power(Subtract(b, q), CN1)))), Sqrt(Plus(C1, Times(C2, c, Sqr(x), Power(Plus(b, q), CN1))))), CN1), x), x)), And(FreeQ(List(a, b, c), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NegQ(Times(c, Power(a, CN1))))));
            IIntegrate(1105, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Dist(Times(Power(a, IntPart(p)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), FracPart(p)), Power(Times(Power(Plus(C1, Times(C2, c, Sqr(x), Power(Plus(b, q), CN1))), FracPart(p)), Power(Plus(C1, Times(C2, c, Sqr(x), Power(Subtract(b, q), CN1))), FracPart(p))), CN1)), Int(Times(Power(Plus(C1, Times(C2, c, Sqr(x), Power(Plus(b, q), CN1))), p), Power(Plus(C1, Times(C2, c, Sqr(x), Power(Subtract(b, q), CN1))), p)), x), x)), And(FreeQ(List(a, b, c, p), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(1106, Int(Power($p("§p4"), p_), x_Symbol),
                    Condition(With(List(Set(a, Coeff($s("§p4"), x, C0)), Set(b, Coeff($s("§p4"), x, C1)), Set(c, Coeff($s("§p4"), x, C2)), Set(d, Coeff($s("§p4"), x, C3)), Set(e, Coeff($s("§p4"), x, C4))), Condition(Subst(Int(SimplifyIntegrand(Power(Plus(a, Times(Power(d, C4), Power(Times(ZZ(256L), Power(e, C3)), CN1)), Times(CN1, b, d, Power(Times(C8, e), CN1)), Times(Subtract(c, Times(C3, Sqr(d), Power(Times(C8, e), CN1))), Sqr(x)), Times(e, Power(x, C4))), p), x), x), x, Plus(Times(d, Power(Times(C4, e), CN1)), x)), And(EqQ(Plus(Power(d, C3), Times(CN1, C4, c, d, e), Times(C8, b, Sqr(e))), C0), NeQ(d, C0)))), And(FreeQ(p, x), PolyQ($s("§p4"), x, C4), NeQ(p, C2), NeQ(p, C3))));
            IIntegrate(1107, Int(Times(x_, Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(C1D2, Subst(Int(Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p), x), x, Sqr(x)), x), FreeQ(List(a, b, c, p), x)));
            IIntegrate(1108, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Times(d, x), m), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p)), x), x), And(FreeQ(List(a, b, c, d, m), x), IGtQ(p, C0), Not(IntegerQ(Times(C1D2, Plus(m, C1)))))));
            IIntegrate(1109, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(C2, Power(Times(d, x), Plus(m, C1)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Plus(p, C1)), Power(Times(d, Plus(m, C3), Plus(Times(C2, a), Times(b, Sqr(x)))), CN1)), x), Simp(Times(Power(Times(d, x), Plus(m, C1)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Plus(p, C1)), Power(Times(C2, a, d, Plus(m, C3), Plus(p, C1)), CN1)), x)), And(FreeQ(List(a, b, c, d, m, p), x), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(p)), EqQ(Plus(m, Times(C4, p), C5), C0), LtQ(p, CN1))));
            IIntegrate(1110, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(d, x), Plus(m, C1)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Plus(p, C1)), Power(Times(C4, a, d, Plus(p, C1), Plus(Times(C2, p), C1)), CN1)), x), Simp(Times(Power(Times(d, x), Plus(m, C1)), Plus(Times(C2, a), Times(b, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p), Power(Times(C4, a, d, Plus(Times(C2, p), C1)), CN1)), x)), And(FreeQ(List(a, b, c, d, m, p), x), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(p)), EqQ(Plus(m, Times(C4, p), C5), C0), NeQ(p, Negate(C1D2)))));
            IIntegrate(1111, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Dist(C1D2, Subst(Int(Times(Power(x, Times(C1D2, Subtract(m, C1))), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), x, Sqr(x)), x), And(FreeQ(List(a, b, c, p), x), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(Subtract(p, C1D2)), IntegerQ(Times(C1D2, Subtract(m, C1))), Or(GtQ(m, C0), LtQ(C0, Times(C4, p), Subtract(Negate(m), C1))))));
            IIntegrate(1112, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), FracPart(p)), Power(Times(Power(c, IntPart(p)), Power(Plus(Times(C1D2, b), Times(c, Sqr(x))), Times(C2, FracPart(p)))), CN1)), Int(Times(Power(Times(d, x), m), Power(Plus(Times(C1D2, b), Times(c, Sqr(x))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, m, p), x), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(Subtract(p, C1D2)))));
            IIntegrate(1113, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(a, IntPart(p)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), FracPart(p)), Power(Power(Plus(C1, Times(C2, c, Sqr(x), Power(b, CN1))), Times(C2, FracPart(p))), CN1)), Int(Times(Power(Times(d, x), m), Power(Plus(C1, Times(C2, c, Sqr(x), Power(b, CN1))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, m, p), x), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(Times(C2, p))))));
            IIntegrate(1114, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(C1D2, Subst(Int(Times(Power(x, Times(C1D2, Subtract(m, C1))), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), x, Sqr(x)), x), And(FreeQ(List(a, b, c, p), x), IntegerQ(Times(C1D2, Subtract(m, C1))))));
            IIntegrate(1115, Int(Times(Power(Times(d_DEFAULT, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(With(List(Set(k, Denominator(m))), Dist(Times(k, Power(d, CN1)), Subst(Int(Times(Power(x, Subtract(Times(k, Plus(m, C1)), C1)), Power(Plus(a, Times(b, Power(x, Times(C2, k)), Power(d, CN2)), Times(c, Power(x, Times(C4, k)), Power(d, CN4))), p)), x), x, Power(Times(d, x), Power(k, CN1))), x)), And(FreeQ(List(a, b, c, d, p), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), FractionQ(m), IntegerQ(p))));
            IIntegrate(1116, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(d, Power(Times(d, x), Subtract(m, C1)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p), Plus(Times(C2, b, p), Times(c, Subtract(Plus(m, Times(C4, p)), C1), Sqr(x))), Power(Times(c, Plus(m, Times(C4, p), C1), Subtract(Plus(m, Times(C4, p)), C1)), CN1)), x), Dist(Times(C2, p, Sqr(d), Power(Times(c, Plus(m, Times(C4, p), C1), Subtract(Plus(m, Times(C4, p)), C1)), CN1)), Int(Times(Power(Times(d, x), Subtract(m, C2)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Subtract(p, C1)), Simp(Subtract(Times(a, b, Subtract(m, C1)), Times(Subtract(Times(C2, a, c, Subtract(Plus(m, Times(C4, p)), C1)), Times(Sqr(b), Subtract(Plus(m, Times(C2, p)), C1))), Sqr(x))), x)), x), x)), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), GtQ(p, C0), GtQ(m, C1), IntegerQ(Times(C2, p)), Or(IntegerQ(p), IntegerQ(m)))));
            IIntegrate(1117, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(d, x), Plus(m, C1)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p), Power(Times(d, Plus(m, C1)), CN1)), x), Dist(Times(C2, p, Power(Times(Sqr(d), Plus(m, C1)), CN1)), Int(Times(Power(Times(d, x), Plus(m, C2)), Plus(b, Times(C2, c, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Subtract(p, C1))), x), x)), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), GtQ(p, C0), LtQ(m, CN1), IntegerQ(Times(C2, p)), Or(IntegerQ(p), IntegerQ(m)))));
            IIntegrate(1118, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(d, x), Plus(m, C1)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p), Power(Times(d, Plus(m, Times(C4, p), C1)), CN1)), x), Dist(Times(C2, p, Power(Plus(m, Times(C4, p), C1), CN1)), Int(Times(Power(Times(d, x), m), Plus(Times(C2, a), Times(b, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Subtract(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, m), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), GtQ(p, C0), NeQ(Plus(m, Times(C4, p), C1), C0), IntegerQ(Times(C2, p)), Or(IntegerQ(p), IntegerQ(m)))));
            IIntegrate(1119, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(d, Power(Times(d, x), Subtract(m, C1)), Plus(b, Times(C2, c, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Plus(p, C1)), Power(Times(C2, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1)), x), Dist(Times(Sqr(d), Power(Times(C2, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1)), Int(Times(Power(Times(d, x), Subtract(m, C2)), Plus(Times(b, Subtract(m, C1)), Times(C2, c, Plus(m, Times(C4, p), C5), Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), LtQ(p, CN1), GtQ(m, C1), LeQ(m, C3), IntegerQ(Times(C2, p)), Or(IntegerQ(p), IntegerQ(m)))));
            IIntegrate(1120, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(d, C3), Power(Times(d, x), Subtract(m, C3)), Plus(Times(C2, a), Times(b, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Plus(p, C1)), Power(Times(C2, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1)), x)), Dist(Times(Power(d, C4), Power(Times(C2, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1)), Int(Times(Power(Times(d, x), Subtract(m, C4)), Plus(Times(C2, a, Subtract(m, C3)), Times(b, Plus(m, Times(C4, p), C3), Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), LtQ(p, CN1), GtQ(m, C3), IntegerQ(Times(C2, p)), Or(IntegerQ(p), IntegerQ(m)))));
            IIntegrate(1121, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Times(d, x), Plus(m, C1)), Plus(Sqr(b), Times(CN1, C2, a, c), Times(b, c, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Plus(p, C1)), Power(Times(C2, a, d, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1)), x)), Dist(Power(Times(C2, a, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1), Int(Times(Power(Times(d, x), m), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Plus(p, C1)), Simp(Plus(Times(Sqr(b), Plus(m, Times(C2, p), C3)), Times(CN1, C2, a, c, Plus(m, Times(C4, p), C5)), Times(b, c, Plus(m, Times(C4, p), C7), Sqr(x))), x)), x), x)), And(FreeQ(List(a, b, c, d, m), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), LtQ(p, CN1), IntegerQ(Times(C2, p)), Or(IntegerQ(p), IntegerQ(m)))));
            IIntegrate(1122, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(d, C3), Power(Times(d, x), Subtract(m, C3)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Plus(p, C1)), Power(Times(c, Plus(m, Times(C4, p), C1)), CN1)), x), Dist(Times(Power(d, C4), Power(Times(c, Plus(m, Times(C4, p), C1)), CN1)), Int(Times(Power(Times(d, x), Subtract(m, C4)), Simp(Plus(Times(a, Subtract(m, C3)), Times(b, Subtract(Plus(m, Times(C2, p)), C1), Sqr(x))), x), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p)), x), x)), And(FreeQ(List(a, b, c, d, p), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), GtQ(m, C3), NeQ(Plus(m, Times(C4, p), C1), C0), IntegerQ(Times(C2, p)), Or(IntegerQ(p), IntegerQ(m)))));
            IIntegrate(1123, Int(Times(Power(Times(d_DEFAULT, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(d, x), Plus(m, C1)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Plus(p, C1)), Power(Times(a, d, Plus(m, C1)), CN1)), x), Dist(Power(Times(a, Sqr(d), Plus(m, C1)), CN1), Int(Times(Power(Times(d, x), Plus(m, C2)), Plus(Times(b, Plus(m, Times(C2, p), C3)), Times(c, Plus(m, Times(C4, p), C5), Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p)), x), x)), And(FreeQ(List(a, b, c, d, p), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), LtQ(m, CN1), IntegerQ(Times(C2, p)), Or(IntegerQ(p), IntegerQ(m)))));
            IIntegrate(1124, Int(Times(Power(Times(d_DEFAULT, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(d, x), Plus(m, C1)), Power(Times(a, d, Plus(m, C1)), CN1)), x), Dist(Power(Times(a, Sqr(d)), CN1), Int(Times(Power(Times(d, x), Plus(m, C2)), Plus(b, Times(c, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1)), x), x)), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), LtQ(m, CN1))));
            IIntegrate(1125, Int(Times(Power(x_, m_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(Int(PolynomialDivide(Power(x, m), Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), x), x), And(FreeQ(List(a, b, c), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(m, C5))));
        }
    }
}
