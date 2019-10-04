package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.CN4;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.PolynomialQuotient;
import static org.matheclipse.core.expression.F.PolynomialRemainder;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.Together;
import static org.matheclipse.core.expression.F.Unequal;
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
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.k;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Coeff;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules50 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(1251, Int(Times(Power(x_, m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(C1D2, Subst(Int(Times(Power(x, Times(C1D2, Subtract(m, C1))), Power(Plus(d, Times(e, x)), q), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), x, Sqr(x)), x), And(FreeQ(List(a, b, c, d, e, p, q), x), IntegerQ(Times(C1D2, Subtract(m, C1))))));
            IIntegrate(1252, Int(Times(Power(x_, m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(C1D2, Subst(Int(Times(Power(x, Times(C1D2, Subtract(m, C1))), Power(Plus(d, Times(e, x)), q), Power(Plus(a, Times(c, Sqr(x))), p)), x), x, Sqr(x)), x), And(FreeQ(List(a, c, d, e, p, q), x), IntegerQ(Times(C1D2, Plus(m, C1))))));
            IIntegrate(1253, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), Plus(q, p)), Power(Plus(Times(a, Power(d, CN1)), Times(c, Sqr(x), Power(e, CN1))), p)), x), And(FreeQ(List(a, b, c, d, e, f, m, q), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), IntegerQ(p))));
            IIntegrate(1254, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), Plus(q, p)), Power(Plus(Times(a, Power(d, CN1)), Times(c, Sqr(x), Power(e, CN1))), p)), x), And(FreeQ(List(a, c, d, e, f, q, m, q), x), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), IntegerQ(p))));
            IIntegrate(1255, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), FracPart(p)), Power(Times(Power(Plus(d, Times(e, Sqr(x))), FracPart(p)), Power(Plus(Times(a, Power(d, CN1)), Times(c, Sqr(x), Power(e, CN1))), FracPart(p))), CN1)), Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), Plus(q, p)), Power(Plus(Times(a, Power(d, CN1)), Times(c, Sqr(x), Power(e, CN1))), p)), x), x), And(FreeQ(List(a, b, c, d, e, f, m, p, q), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), Not(IntegerQ(p)))));
            IIntegrate(1256, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(c, Power(x, C4))), FracPart(p)), Power(Times(Power(Plus(d, Times(e, Sqr(x))), FracPart(p)), Power(Plus(Times(a, Power(d, CN1)), Times(c, Sqr(x), Power(e, CN1))), FracPart(p))), CN1)), Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), Plus(q, p)), Power(Plus(Times(a, Power(d, CN1)), Times(c, Sqr(x), Power(e, CN1))), p)), x), x), And(FreeQ(List(a, c, d, e, f, m, p, q), x), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IntegerQ(p)))));
            IIntegrate(1257, Int(Times(Power(x_, m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Negate(d), Subtract(Times(C1D2, m), C1)), Power(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), p), x, Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Power(Times(C2, Power(e, Plus(Times(C2, p), Times(C1D2, m))), Plus(q, C1)), CN1)), x), Dist(Power(Times(C2, Power(e, Plus(Times(C2, p), Times(C1D2, m))), Plus(q, C1)), CN1), Int(Times(Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), ExpandToSum(Together(Times(C1, Subtract(Times(C2, Power(e, Plus(Times(C2, p), Times(C1D2, m))), Plus(q, C1), Power(x, m), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p)), Times(Power(Negate(d), Subtract(Times(C1D2, m), C1)), Power(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), p), Plus(d, Times(e, Plus(Times(C2, q), C3), Sqr(x))))), Power(Plus(d, Times(e, Sqr(x))), CN1))), x)), x), x)), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(p, C0), ILtQ(q, CN1), IGtQ(Times(C1D2, m), C0))));
            IIntegrate(1258, Int(Times(Power(x_, m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Negate(d), Subtract(Times(C1D2, m), C1)), Power(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), p), x, Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Power(Times(C2, Power(e, Plus(Times(C2, p), Times(C1D2, m))), Plus(q, C1)), CN1)), x), Dist(Power(Times(C2, Power(e, Plus(Times(C2, p), Times(C1D2, m))), Plus(q, C1)), CN1), Int(Times(Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), ExpandToSum(Together(Times(C1, Subtract(Times(C2, Power(e, Plus(Times(C2, p), Times(C1D2, m))), Plus(q, C1), Power(x, m), Power(Plus(a, Times(c, Power(x, C4))), p)), Times(Power(Negate(d), Subtract(Times(C1D2, m), C1)), Power(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), p), Plus(d, Times(e, Plus(Times(C2, q), C3), Sqr(x))))), Power(Plus(d, Times(e, Sqr(x))), CN1))), x)), x), x)), And(FreeQ(List(a, c, d, e), x), IGtQ(p, C0), ILtQ(q, CN1), IGtQ(Times(C1D2, m), C0))));
            IIntegrate(1259, Int(Times(Power(x_, m_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Negate(d), Subtract(Times(C1D2, m), C1)), Power(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), p), x, Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Power(Times(C2, Power(e, Plus(Times(C2, p), Times(C1D2, m))), Plus(q, C1)), CN1)), x), Dist(Times(Power(Negate(d), Subtract(Times(C1D2, m), C1)), Power(Times(C2, Power(e, Times(C2, p)), Plus(q, C1)), CN1)), Int(Times(Power(x, m), Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), ExpandToSum(Together(Times(C1, Subtract(Times(C2, Power(Negate(d), Plus(Times(CN1, C1D2, m), C1)), Power(e, Times(C2, p)), Plus(q, C1), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p)), Times(Power(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), p), Power(Times(Power(e, Times(C1D2, m)), Power(x, m)), CN1), Plus(d, Times(e, Plus(Times(C2, q), C3), Sqr(x))))), Power(Plus(d, Times(e, Sqr(x))), CN1))), x)), x), x)), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(p, C0), ILtQ(q, CN1), ILtQ(Times(C1D2, m), C0))));
            IIntegrate(1260, Int(Times(Power(x_, m_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Negate(d), Subtract(Times(C1D2, m), C1)), Power(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), p), x, Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Power(Times(C2, Power(e, Plus(Times(C2, p), Times(C1D2, m))), Plus(q, C1)), CN1)), x), Dist(Times(Power(Negate(d), Subtract(Times(C1D2, m), C1)), Power(Times(C2, Power(e, Times(C2, p)), Plus(q, C1)), CN1)), Int(Times(Power(x, m), Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), ExpandToSum(Together(Times(C1, Subtract(Times(C2, Power(Negate(d), Plus(Times(CN1, C1D2, m), C1)), Power(e, Times(C2, p)), Plus(q, C1), Power(Plus(a, Times(c, Power(x, C4))), p)), Times(Power(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), p), Power(Times(Power(e, Times(C1D2, m)), Power(x, m)), CN1), Plus(d, Times(e, Plus(Times(C2, q), C3), Sqr(x))))), Power(Plus(d, Times(e, Sqr(x))), CN1))), x)), x), x)), And(FreeQ(List(a, c, d, e), x), IGtQ(p, C0), ILtQ(q, CN1), ILtQ(Times(C1D2, m), C0))));
            IIntegrate(1261, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p)), x), x), And(FreeQ(List(a, b, c, d, e, f, m, q), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(p, C0), IGtQ(q, CN2))));
            IIntegrate(1262, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(a, Times(c, Power(x, C4))), p)), x), x), And(FreeQ(List(a, c, d, e, f, m, q), x), IGtQ(p, C0), IGtQ(q, CN2))));
            IIntegrate(1263, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set($s("§qx"), PolynomialQuotient(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p), Plus(d, Times(e, Sqr(x))), x)), Set($s("R"), Coeff(PolynomialRemainder(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p), Plus(d, Times(e, Sqr(x))), x), x, C0))), Plus(Negate(Simp(Times($s("R"), Power(Times(f, x), Plus(m, C1)), Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Power(Times(C2, d, f, Plus(q, C1)), CN1)), x)), Dist(Times(f, Power(Times(C2, d, Plus(q, C1)), CN1)), Int(Times(Power(Times(f, x), Subtract(m, C1)), Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), ExpandToSum(Plus(Times(C2, d, Plus(q, C1), x, $s("§qx")), Times($s("R"), Plus(m, Times(C2, q), C3), x)), x)), x), x))), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(p, C0), LtQ(q, CN1), GtQ(m, C0))));
            IIntegrate(1264, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set($s("§qx"), PolynomialQuotient(Power(Plus(a, Times(c, Power(x, C4))), p), Plus(d, Times(e, Sqr(x))), x)), Set($s("R"), Coeff(PolynomialRemainder(Power(Plus(a, Times(c, Power(x, C4))), p), Plus(d, Times(e, Sqr(x))), x), x, C0))), Plus(Negate(Simp(Times($s("R"), Power(Times(f, x), Plus(m, C1)), Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Power(Times(C2, d, f, Plus(q, C1)), CN1)), x)), Dist(Times(f, Power(Times(C2, d, Plus(q, C1)), CN1)), Int(Times(Power(Times(f, x), Subtract(m, C1)), Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), ExpandToSum(Plus(Times(C2, d, Plus(q, C1), x, $s("§qx")), Times($s("R"), Plus(m, Times(C2, q), C3), x)), x)), x), x))), And(FreeQ(List(a, c, d, e, f), x), IGtQ(p, C0), LtQ(q, CN1), GtQ(m, C0))));
            IIntegrate(1265, Int(Times(Power(Times(f_DEFAULT, x_), m_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set($s("§qx"), PolynomialQuotient(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p), Times(f, x), x)), Set($s("R"), PolynomialRemainder(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p), Times(f, x), x))), Plus(Simp(Times($s("R"), Power(Times(f, x), Plus(m, C1)), Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Power(Times(d, f, Plus(m, C1)), CN1)), x), Dist(Power(Times(d, Sqr(f), Plus(m, C1)), CN1), Int(Times(Power(Times(f, x), Plus(m, C2)), Power(Plus(d, Times(e, Sqr(x))), q), ExpandToSum(Subtract(Times(d, f, Plus(m, C1), $s("§qx"), Power(x, CN1)), Times(e, $s("R"), Plus(m, Times(C2, q), C3))), x)), x), x))), And(FreeQ(List(a, b, c, d, e, f, q), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(p, C0), LtQ(m, CN1))));
            IIntegrate(1266, Int(Times(Power(Times(f_DEFAULT, x_), m_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set($s("§qx"), PolynomialQuotient(Power(Plus(a, Times(c, Power(x, C4))), p), Times(f, x), x)), Set($s("R"), PolynomialRemainder(Power(Plus(a, Times(c, Power(x, C4))), p), Times(f, x), x))), Plus(Simp(Times($s("R"), Power(Times(f, x), Plus(m, C1)), Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Power(Times(d, f, Plus(m, C1)), CN1)), x), Dist(Power(Times(d, Sqr(f), Plus(m, C1)), CN1), Int(Times(Power(Times(f, x), Plus(m, C2)), Power(Plus(d, Times(e, Sqr(x))), q), ExpandToSum(Subtract(Times(d, f, Plus(m, C1), $s("§qx"), Power(x, CN1)), Times(e, $s("R"), Plus(m, Times(C2, q), C3))), x)), x), x))), And(FreeQ(List(a, c, d, e, f, q), x), IGtQ(p, C0), LtQ(m, CN1))));
            IIntegrate(1267, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(c, p), Power(Times(f, x), Subtract(Plus(m, Times(C4, p)), C1)), Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Power(Times(e, Power(f, Subtract(Times(C4, p), C1)), Plus(m, Times(C4, p), Times(C2, q), C1)), CN1)), x), Dist(Power(Times(e, Plus(m, Times(C4, p), Times(C2, q), C1)), CN1), Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), q), ExpandToSum(Subtract(Times(e, Plus(m, Times(C4, p), Times(C2, q), C1), Subtract(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p), Times(Power(c, p), Power(x, Times(C4, p))))), Times(d, Power(c, p), Subtract(Plus(m, Times(C4, p)), C1), Power(x, Subtract(Times(C4, p), C2)))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, m, q), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(p, C0), Not(IntegerQ(q)), NeQ(Plus(m, Times(C4, p), Times(C2, q), C1), C0))));
            IIntegrate(1268, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(c, p), Power(Times(f, x), Subtract(Plus(m, Times(C4, p)), C1)), Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Power(Times(e, Power(f, Subtract(Times(C4, p), C1)), Plus(m, Times(C4, p), Times(C2, q), C1)), CN1)), x), Dist(Power(Times(e, Plus(m, Times(C4, p), Times(C2, q), C1)), CN1), Int(Times(Power(Times(f, x), m), Power(Plus(d, Times(e, Sqr(x))), q), ExpandToSum(Subtract(Times(e, Plus(m, Times(C4, p), Times(C2, q), C1), Subtract(Power(Plus(a, Times(c, Power(x, C4))), p), Times(Power(c, p), Power(x, Times(C4, p))))), Times(d, Power(c, p), Subtract(Plus(m, Times(C4, p)), C1), Power(x, Subtract(Times(C4, p), C2)))), x)), x), x)), And(FreeQ(List(a, c, d, e, f, m, q), x), IGtQ(p, C0), Not(IntegerQ(q)), NeQ(Plus(m, Times(C4, p), Times(C2, q), C1), C0))));
            IIntegrate(1269, Int(Times(Power(Times(f_DEFAULT, x_), m_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(With(List(Set(k, Denominator(m))), Dist(Times(k, Power(f, CN1)), Subst(Int(Times(Power(x, Subtract(Times(k, Plus(m, C1)), C1)), Power(Plus(d, Times(e, Power(x, Times(C2, k)), Power(f, CN2))), q), Power(Plus(a, Times(b, Power(x, Times(C2, k)), Power(Power(f, k), CN1)), Times(c, Power(x, Times(C4, k)), Power(f, CN4))), p)), x), x, Power(Times(f, x), Power(k, CN1))), x)), And(FreeQ(List(a, b, c, d, e, f, p, q), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), FractionQ(m), IntegerQ(p))));
            IIntegrate(1270, Int(Times(Power(Times(f_DEFAULT, x_), m_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(With(List(Set(k, Denominator(m))), Dist(Times(k, Power(f, CN1)), Subst(Int(Times(Power(x, Subtract(Times(k, Plus(m, C1)), C1)), Power(Plus(d, Times(e, Power(x, Times(C2, k)), Power(f, CN1))), q), Power(Plus(a, Times(c, Power(x, Times(C4, k)), Power(f, CN1))), p)), x), x, Power(Times(f, x), Power(k, CN1))), x)), And(FreeQ(List(a, c, d, e, f, p, q), x), FractionQ(m), IntegerQ(p))));
            IIntegrate(1271, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(f, x), Plus(m, C1)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p), Plus(Times(d, Plus(m, Times(C4, p), C3)), Times(e, Plus(m, C1), Sqr(x))), Power(Times(f, Plus(m, C1), Plus(m, Times(C4, p), C3)), CN1)), x), Dist(Times(C2, p, Power(Times(Sqr(f), Plus(m, C1), Plus(m, Times(C4, p), C3)), CN1)), Int(Times(Power(Times(f, x), Plus(m, C2)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Subtract(p, C1)), Simp(Plus(Times(C2, a, e, Plus(m, C1)), Times(CN1, b, d, Plus(m, Times(C4, p), C3)), Times(Subtract(Times(b, e, Plus(m, C1)), Times(C2, c, d, Plus(m, Times(C4, p), C3))), Sqr(x))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), GtQ(p, C0), LtQ(m, CN1), Unequal(Plus(m, Times(C4, p), C3), C0), IntegerQ(Times(C2, p)), Or(IntegerQ(p), IntegerQ(m)))));
            IIntegrate(1272, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(f, x), Plus(m, C1)), Power(Plus(a, Times(c, Power(x, C4))), p), Plus(Times(d, Plus(m, Times(C4, p), C3)), Times(e, Plus(m, C1), Sqr(x))), Power(Times(f, Plus(m, C1), Plus(m, Times(C4, p), C3)), CN1)), x), Dist(Times(C4, p, Power(Times(Sqr(f), Plus(m, C1), Plus(m, Times(C4, p), C3)), CN1)), Int(Times(Power(Times(f, x), Plus(m, C2)), Power(Plus(a, Times(c, Power(x, C4))), Subtract(p, C1)), Subtract(Times(a, e, Plus(m, C1)), Times(c, d, Plus(m, Times(C4, p), C3), Sqr(x)))), x), x)), And(FreeQ(List(a, c, d, e, f), x), GtQ(p, C0), LtQ(m, CN1), Unequal(Plus(m, Times(C4, p), C3), C0), IntegerQ(Times(C2, p)), Or(IntegerQ(p), IntegerQ(m)))));
            IIntegrate(1273, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(f, x), Plus(m, C1)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p), Plus(Times(b, e, C2, p), Times(c, d, Plus(m, Times(C4, p), C3)), Times(c, e, Plus(Times(C4, p), m, C1), Sqr(x))), Power(Times(c, f, Plus(Times(C4, p), m, C1), Plus(m, Times(C4, p), C3)), CN1)), x), Dist(Times(C2, p, Power(Times(c, Plus(Times(C4, p), m, C1), Plus(m, Times(C4, p), C3)), CN1)), Int(Times(Power(Times(f, x), m), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Subtract(p, C1)), Simp(Plus(Times(C2, a, c, d, Plus(m, Times(C4, p), C3)), Times(CN1, a, b, e, Plus(m, C1)), Times(Subtract(Plus(Times(C2, a, c, e, Plus(Times(C4, p), m, C1)), Times(b, c, d, Plus(m, Times(C4, p), C3))), Times(Sqr(b), e, Plus(m, Times(C2, p), C1))), Sqr(x))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f, m), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), GtQ(p, C0), NeQ(Plus(Times(C4, p), m, C1), C0), NeQ(Plus(m, Times(C4, p), C3), C0), IntegerQ(Times(C2, p)), Or(IntegerQ(p), IntegerQ(m)))));
            IIntegrate(1274, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(f, x), Plus(m, C1)), Power(Plus(a, Times(c, Power(x, C4))), p), Plus(Times(c, d, Plus(m, Times(C4, p), C3)), Times(c, e, Plus(Times(C4, p), m, C1), Sqr(x))), Power(Times(c, f, Plus(Times(C4, p), m, C1), Plus(m, Times(C4, p), C3)), CN1)), x), Dist(Times(C4, a, p, Power(Times(Plus(Times(C4, p), m, C1), Plus(m, Times(C4, p), C3)), CN1)), Int(Times(Power(Times(f, x), m), Power(Plus(a, Times(c, Power(x, C4))), Subtract(p, C1)), Simp(Plus(Times(d, Plus(m, Times(C4, p), C3)), Times(e, Plus(Times(C4, p), m, C1), Sqr(x))), x)), x), x)), And(FreeQ(List(a, c, d, e, f, m), x), GtQ(p, C0), NeQ(Plus(Times(C4, p), m, C1), C0), NeQ(Plus(m, Times(C4, p), C3), C0), IntegerQ(Times(C2, p)), Or(IntegerQ(p), IntegerQ(m)))));
            IIntegrate(1275, Int(Times(Power(Times(f_DEFAULT, x_), m_DEFAULT), Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(f, Power(Times(f, x), Subtract(m, C1)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Plus(p, C1)), Subtract(Subtract(Times(b, d), Times(C2, a, e)), Times(Subtract(Times(b, e), Times(C2, c, d)), Sqr(x))), Power(Times(C2, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1)), x), Dist(Times(Sqr(f), Power(Times(C2, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1)), Int(Times(Power(Times(f, x), Subtract(m, C2)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Plus(p, C1)), Simp(Subtract(Times(Subtract(m, C1), Subtract(Times(b, d), Times(C2, a, e))), Times(Plus(Times(C4, p), C4, m, C1), Subtract(Times(b, e), Times(C2, c, d)), Sqr(x))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), LtQ(p, CN1), GtQ(m, C1), IntegerQ(Times(C2, p)), Or(IntegerQ(p), IntegerQ(m)))));
        }
    }
}
