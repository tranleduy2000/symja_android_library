package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.C5;
import static org.matheclipse.core.expression.F.C6;
import static org.matheclipse.core.expression.F.C7;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.MatchQ;
import static org.matheclipse.core.expression.F.Module;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.PolynomialQuotient;
import static org.matheclipse.core.expression.F.PolynomialRemainder;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.QSymbol;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Sum;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.True;
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
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.k;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.u_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Coeff;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Expon;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PolyQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SubstFor;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules66 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(1651, Int(Times($p("§pq"), Power(Plus(d_, Times(e_DEFAULT, x_)), m_), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(With(List(Set(QSymbol, PolynomialQuotient($s("§pq"), Plus(d, Times(e, x)), x)), Set($s("R"), PolynomialRemainder($s("§pq"), Plus(d, Times(e, x)), x))), Plus(Simp(Times(e, $s("R"), Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1)), Power(Times(Plus(m, C1), Plus(Times(c, Sqr(d)), Times(a, Sqr(e)))), CN1)), x), Dist(Power(Times(Plus(m, C1), Plus(Times(c, Sqr(d)), Times(a, Sqr(e)))), CN1), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, C1)), Power(Plus(a, Times(c, Sqr(x))), p), ExpandToSum(Subtract(Plus(Times(Plus(m, C1), Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), QSymbol), Times(c, d, $s("R"), Plus(m, C1))), Times(c, e, $s("R"), Plus(m, Times(C2, p), C3), x)), x)), x), x))), And(FreeQ(List(a, c, d, e, p), x), PolyQ($s("§pq"), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), LtQ(m, CN1))));
            IIntegrate(1652, Int(Times($p("§pq"), Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Module(List(Set(q, Expon($s("§pq"), x)), k), Plus(Int(Times(Power(x, m), Sum(Times(Coeff($s("§pq"), x, Times(C2, k)), Power(x, Times(C2, k))), List(k, C0, Times(C1D2, q))), Power(Plus(a, Times(b, Sqr(x))), p)), x), Int(Times(Power(x, Plus(m, C1)), Sum(Times(Coeff($s("§pq"), x, Plus(Times(C2, k), C1)), Power(x, Times(C2, k))), List(k, C0, Times(C1D2, Subtract(q, C1)))), Power(Plus(a, Times(b, Sqr(x))), p)), x))), And(FreeQ(List(a, b, p), x), PolyQ($s("§pq"), x), Not(PolyQ($s("§pq"), Sqr(x))), IGtQ(m, CN2), Not(IntegerQ(Times(C2, p))))));
            IIntegrate(1653, Int(Times($p("§pq"), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(With(List(Set(q, Expon($s("§pq"), x)), Set(f, Coeff($s("§pq"), x, Expon($s("§pq"), x)))), Condition(Plus(Simp(Times(f, Power(Plus(d, Times(e, x)), Subtract(Plus(m, q), C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Times(c, Power(e, Subtract(q, C1)), Plus(m, q, Times(C2, p), C1)), CN1)), x), Dist(Power(Times(c, Power(e, q), Plus(m, q, Times(C2, p), C1)), CN1), Int(Times(Power(Plus(d, Times(e, x)), m), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p), ExpandToSum(Subtract(Subtract(Times(c, Power(e, q), Plus(m, q, Times(C2, p), C1), $s("§pq")), Times(c, f, Plus(m, q, Times(C2, p), C1), Power(Plus(d, Times(e, x)), q))), Times(f, Power(Plus(d, Times(e, x)), Subtract(q, C2)), Subtract(Subtract(Plus(Times(b, d, e, Plus(p, C1)), Times(a, Sqr(e), Subtract(Plus(m, q), C1))), Times(c, Sqr(d), Plus(m, q, Times(C2, p), C1))), Times(e, Subtract(Times(C2, c, d), Times(b, e)), Plus(m, q, p), x)))), x)), x), x)), And(GtQ(q, C1), NeQ(Plus(m, q, Times(C2, p), C1), C0)))), And(FreeQ(List(a, b, c, d, e, m, p), x), PolyQ($s("§pq"), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), Not(And(IGtQ(m, C0), RationalQ(a, b, c, d, e), Or(IntegerQ(p), ILtQ(Plus(p, C1D2), C0)))))));
            IIntegrate(1654, Int(Times($p("§pq"), Power(Plus(d_, Times(e_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(With(List(Set(q, Expon($s("§pq"), x)), Set(f, Coeff($s("§pq"), x, Expon($s("§pq"), x)))), Condition(Plus(Simp(Times(f, Power(Plus(d, Times(e, x)), Subtract(Plus(m, q), C1)), Power(Plus(a, Times(c, Sqr(x))), Plus(p, C1)), Power(Times(c, Power(e, Subtract(q, C1)), Plus(m, q, Times(C2, p), C1)), CN1)), x), Dist(Power(Times(c, Power(e, q), Plus(m, q, Times(C2, p), C1)), CN1), Int(Times(Power(Plus(d, Times(e, x)), m), Power(Plus(a, Times(c, Sqr(x))), p), ExpandToSum(Subtract(Subtract(Times(c, Power(e, q), Plus(m, q, Times(C2, p), C1), $s("§pq")), Times(c, f, Plus(m, q, Times(C2, p), C1), Power(Plus(d, Times(e, x)), q))), Times(f, Power(Plus(d, Times(e, x)), Subtract(q, C2)), Subtract(Subtract(Times(a, Sqr(e), Subtract(Plus(m, q), C1)), Times(c, Sqr(d), Plus(m, q, Times(C2, p), C1))), Times(C2, c, d, e, Plus(m, q, p), x)))), x)), x), x)), And(GtQ(q, C1), NeQ(Plus(m, q, Times(C2, p), C1), C0)))), And(FreeQ(List(a, c, d, e, m, p), x), PolyQ($s("§pq"), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(And(EqQ(d, C0), True)), Not(And(IGtQ(m, C0), RationalQ(a, c, d, e), Or(IntegerQ(p), ILtQ(Plus(p, C1D2), C0)))))));
            IIntegrate(1655, Int(Times($p("§pq"), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(q, Expon($s("§pq"), x))), Plus(Dist(Times(Coeff($s("§pq"), x, q), Power(Power(e, q), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, q)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), x), Dist(Power(Power(e, q), CN1), Int(Times(Power(Plus(d, Times(e, x)), m), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p), ExpandToSum(Subtract(Times(Power(e, q), $s("§pq")), Times(Coeff($s("§pq"), x, q), Power(Plus(d, Times(e, x)), q))), x)), x), x))), And(FreeQ(List(a, b, c, d, e, m, p), x), PolyQ($s("§pq"), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), Not(And(IGtQ(m, C0), RationalQ(a, b, c, d, e), Or(IntegerQ(p), ILtQ(Plus(p, C1D2), C0)))))));
            IIntegrate(1656, Int(Times($p("§pq"), Power(Plus(d_, Times(e_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(q, Expon($s("§pq"), x))), Plus(Dist(Times(Coeff($s("§pq"), x, q), Power(Power(e, q), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Plus(m, q)), Power(Plus(a, Times(c, Sqr(x))), p)), x), x), Dist(Power(Power(e, q), CN1), Int(Times(Power(Plus(d, Times(e, x)), m), Power(Plus(a, Times(c, Sqr(x))), p), ExpandToSum(Subtract(Times(Power(e, q), $s("§pq")), Times(Coeff($s("§pq"), x, q), Power(Plus(d, Times(e, x)), q))), x)), x), x))), And(FreeQ(List(a, c, d, e, m, p), x), PolyQ($s("§pq"), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(And(IGtQ(m, C0), RationalQ(a, c, d, e), Or(IntegerQ(p), ILtQ(Plus(p, C1D2), C0)))))));
            IIntegrate(1657, Int(Times($p("§pq"), Power(Plus(a_, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times($s("§pq"), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), x), And(FreeQ(List(a, b, c), x), PolyQ($s("§pq"), x), IGtQ(p, CN2))));
            IIntegrate(1658, Int(Times($p("§pq"), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Int(Times(x, PolynomialQuotient($s("§pq"), x, x), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), And(FreeQ(List(a, b, c, p), x), PolyQ($s("§pq"), x), EqQ(Coeff($s("§pq"), x, C0), C0), Not(MatchQ($s("§pq"), Condition(Times(Power(x, m_DEFAULT), u_DEFAULT), IntegerQ(m)))))));
            IIntegrate(1659, Int(Times($p("§pq"), Power(Plus(a_, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, x), Times(c, Sqr(x))), FracPart(p)), Power(Times(Power(Times(C4, c), IntPart(p)), Power(Plus(b, Times(C2, c, x)), Times(C2, FracPart(p)))), CN1)), Int(Times($s("§pq"), Power(Plus(b, Times(C2, c, x)), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, p), x), PolyQ($s("§pq"), x), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(1660, Int(Times($p("§pq"), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(With(List(Set(QSymbol, PolynomialQuotient($s("§pq"), Plus(a, Times(b, x), Times(c, Sqr(x))), x)), Set(f, Coeff(PolynomialRemainder($s("§pq"), Plus(a, Times(b, x), Times(c, Sqr(x))), x), x, C0)), Set(g, Coeff(PolynomialRemainder($s("§pq"), Plus(a, Times(b, x), Times(c, Sqr(x))), x), x, C1))), Plus(Simp(Times(Plus(Times(b, f), Times(CN1, C2, a, g), Times(Subtract(Times(C2, c, f), Times(b, g)), x)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Times(Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1)), x), Dist(Power(Times(Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1), Int(Times(Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), ExpandToSum(Subtract(Times(Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c)), QSymbol), Times(Plus(Times(C2, p), C3), Subtract(Times(C2, c, f), Times(b, g)))), x)), x), x))), And(FreeQ(List(a, b, c), x), PolyQ($s("§pq"), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), LtQ(p, CN1))));
            IIntegrate(1661, Int(Times($p("§pq"), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(With(List(Set(q, Expon($s("§pq"), x)), Set(e, Coeff($s("§pq"), x, Expon($s("§pq"), x)))), Plus(Simp(Times(e, Power(x, Subtract(q, C1)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), Plus(p, C1)), Power(Times(c, Plus(q, Times(C2, p), C1)), CN1)), x), Dist(Power(Times(c, Plus(q, Times(C2, p), C1)), CN1), Int(Times(Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p), ExpandToSum(Subtract(Subtract(Subtract(Times(c, Plus(q, Times(C2, p), C1), $s("§pq")), Times(a, e, Subtract(q, C1), Power(x, Subtract(q, C2)))), Times(b, e, Plus(q, p), Power(x, Subtract(q, C1)))), Times(c, e, Plus(q, Times(C2, p), C1), Power(x, q))), x)), x), x))), And(FreeQ(List(a, b, c, p), x), PolyQ($s("§pq"), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(LeQ(p, CN1)))));
            IIntegrate(1662, Int(Times($p("§pq"), Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Module(List(Set(q, Expon($s("§pq"), x)), k), Plus(Int(Times(Power(Times(d, x), m), Sum(Times(Coeff($s("§pq"), x, Times(C2, k)), Power(x, Times(C2, k))), List(k, C0, Plus(Times(C1D2, q), C1))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p)), x), Dist(Power(d, CN1), Int(Times(Power(Times(d, x), Plus(m, C1)), Sum(Times(Coeff($s("§pq"), x, Plus(Times(C2, k), C1)), Power(x, Times(C2, k))), List(k, C0, Plus(Times(C1D2, Subtract(q, C1)), C1))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p)), x), x))), And(FreeQ(List(a, b, c, d, m, p), x), PolyQ($s("§pq"), x), Not(PolyQ($s("§pq"), Sqr(x))))));
            IIntegrate(1663, Int(Times($p("§pq"), Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Dist(C1D2, Subst(Int(Times(Power(x, Times(C1D2, Subtract(m, C1))), SubstFor(Sqr(x), $s("§pq"), x), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), x, Sqr(x)), x), And(FreeQ(List(a, b, c, p), x), PolyQ($s("§pq"), Sqr(x)), IntegerQ(Times(C1D2, Subtract(m, C1))))));
            IIntegrate(1664, Int(Times($p("§pq"), Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Times(d, x), m), $s("§pq"), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p)), x), x), And(FreeQ(List(a, b, c, d, m), x), PolyQ($s("§pq"), Sqr(x)), IGtQ(p, CN2))));
            IIntegrate(1665, Int(Times($p("§pq"), Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Dist(Power(d, CN2), Int(Times(Power(Times(d, x), Plus(m, C2)), ExpandToSum(Times($s("§pq"), Power(x, CN2)), x), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p)), x), x), And(FreeQ(List(a, b, c, d, m, p), x), PolyQ($s("§pq"), Sqr(x)), EqQ(Coeff($s("§pq"), x, C0), C0))));
            IIntegrate(1666, Int(Times($p("§pq"), Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(e, Coeff($s("§pq"), x, C0)), Set(f, Coeff($s("§pq"), x, C2)), Set(g, Coeff($s("§pq"), x, C4))), Condition(Simp(Times(e, Power(Times(d, x), Plus(m, C1)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Plus(p, C1)), Power(Times(a, d, Plus(m, C1)), CN1)), x), And(EqQ(Subtract(Times(a, f, Plus(m, C1)), Times(b, e, Plus(m, Times(C2, p), C3))), C0), EqQ(Subtract(Times(a, g, Plus(m, C1)), Times(c, e, Plus(m, Times(C4, p), C5))), C0), NeQ(m, CN1)))), And(FreeQ(List(a, b, c, d, m, p), x), PolyQ($s("§pq"), Sqr(x)), EqQ(Expon($s("§pq"), x), C4))));
            IIntegrate(1667, Int(Times($p("§pq"), Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), FracPart(p)), Power(Times(Power(Times(C4, c), IntPart(p)), Power(Plus(b, Times(C2, c, Sqr(x))), Times(C2, FracPart(p)))), CN1)), Int(Times(Power(Times(d, x), m), $s("§pq"), Power(Plus(b, Times(C2, c, Sqr(x))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, m, p), x), PolyQ($s("§pq"), Sqr(x)), GtQ(Expon($s("§pq"), Sqr(x)), C1), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(1668, Int(Times($p("§pq"), Power(x_, m_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(With(List(Set(d, Coeff(PolynomialRemainder(Times(Power(x, m), $s("§pq")), Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), x), x, C0)), Set(e, Coeff(PolynomialRemainder(Times(Power(x, m), $s("§pq")), Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), x), x, C2))), Plus(Simp(Times(x, Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Plus(p, C1)), Subtract(Subtract(Times(a, b, e), Times(d, Subtract(Sqr(b), Times(C2, a, c)))), Times(c, Subtract(Times(b, d), Times(C2, a, e)), Sqr(x))), Power(Times(C2, a, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1)), x), Dist(Power(Times(C2, a, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1), Int(Times(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Plus(p, C1)), ExpandToSum(Plus(Times(C2, a, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c)), PolynomialQuotient(Times(Power(x, m), $s("§pq")), Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), x)), Times(Sqr(b), d, Plus(Times(C2, p), C3)), Times(CN1, C2, a, c, d, Plus(Times(C4, p), C5)), Times(CN1, a, b, e), Times(c, Plus(Times(C4, p), C7), Subtract(Times(b, d), Times(C2, a, e)), Sqr(x))), x)), x), x))), And(FreeQ(List(a, b, c), x), PolyQ($s("§pq"), Sqr(x)), GtQ(Expon($s("§pq"), Sqr(x)), C1), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), LtQ(p, CN1), IGtQ(Times(C1D2, m), C0))));
            IIntegrate(1669, Int(Times($p("§pq"), Power(x_, m_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(With(List(Set(d, Coeff(PolynomialRemainder(Times(Power(x, m), $s("§pq")), Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), x), x, C0)), Set(e, Coeff(PolynomialRemainder(Times(Power(x, m), $s("§pq")), Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), x), x, C2))), Plus(Simp(Times(x, Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Plus(p, C1)), Subtract(Subtract(Times(a, b, e), Times(d, Subtract(Sqr(b), Times(C2, a, c)))), Times(c, Subtract(Times(b, d), Times(C2, a, e)), Sqr(x))), Power(Times(C2, a, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1)), x), Dist(Power(Times(C2, a, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1), Int(Times(Power(x, m), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Plus(p, C1)), ExpandToSum(Plus(Times(C2, a, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c)), PolynomialQuotient(Times(Power(x, m), $s("§pq")), Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), x), Power(Power(x, m), CN1)), Times(Subtract(Subtract(Times(Sqr(b), d, Plus(Times(C2, p), C3)), Times(C2, a, c, d, Plus(Times(C4, p), C5))), Times(a, b, e)), Power(Power(x, m), CN1)), Times(c, Plus(Times(C4, p), C7), Subtract(Times(b, d), Times(C2, a, e)), Power(x, Subtract(C2, m)))), x)), x), x))), And(FreeQ(List(a, b, c), x), PolyQ($s("§pq"), Sqr(x)), GtQ(Expon($s("§pq"), Sqr(x)), C1), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), LtQ(p, CN1), ILtQ(Times(C1D2, m), C0))));
            IIntegrate(1670, Int(Times($p("§pq"), Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times($s("§pq"), Power(Times(d, x), m), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p)), x), And(FreeQ(List(a, b, c, d, m, p), x), PolyQ($s("§pq"), x))));
            IIntegrate(1671, Int(Times($p("§pq"), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times($s("§pq"), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p)), x), x), And(FreeQ(List(a, b, c), x), PolyQ($s("§pq"), x), IGtQ(p, C0))));
            IIntegrate(1672, Int(Times($p("§pq"), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Int(Times(x, PolynomialQuotient($s("§pq"), x, x), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p)), x), And(FreeQ(List(a, b, c, p), x), PolyQ($s("§pq"), x), EqQ(Coeff($s("§pq"), x, C0), C0), Not(MatchQ($s("§pq"), Condition(Times(Power(x, m_DEFAULT), u_DEFAULT), IntegerQ(m)))))));
            IIntegrate(1673, Int(Times($p("§pq"), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Module(List(Set(q, Expon($s("§pq"), x)), k), Plus(Int(Times(Sum(Times(Coeff($s("§pq"), x, Times(C2, k)), Power(x, Times(C2, k))), List(k, C0, Times(C1D2, q))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p)), x), Int(Times(x, Sum(Times(Coeff($s("§pq"), x, Plus(Times(C2, k), C1)), Power(x, Times(C2, k))), List(k, C0, Times(C1D2, Subtract(q, C1)))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p)), x))), And(FreeQ(List(a, b, c, p), x), PolyQ($s("§pq"), x), Not(PolyQ($s("§pq"), Sqr(x))))));
            IIntegrate(1674, Int(Times($p("§pq"), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(d, Coeff($s("§pq"), x, C0)), Set(e, Coeff($s("§pq"), x, C2)), Set(f, Coeff($s("§pq"), x, C4))), Condition(Simp(Times(d, x, Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Plus(p, C1)), Power(a, CN1)), x), And(EqQ(Subtract(Times(a, e), Times(b, d, Plus(Times(C2, p), C3))), C0), EqQ(Subtract(Times(a, f), Times(c, d, Plus(Times(C4, p), C5))), C0)))), And(FreeQ(List(a, b, c, p), x), PolyQ($s("§pq"), Sqr(x)), EqQ(Expon($s("§pq"), x), C4))));
            IIntegrate(1675, Int(Times($p("§pq"), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(d, Coeff($s("§pq"), x, C0)), Set(e, Coeff($s("§pq"), x, C2)), Set(f, Coeff($s("§pq"), x, C4)), Set(g, Coeff($s("§pq"), x, C6))), Condition(Simp(Times(x, Plus(Times(C3, a, d), Times(Subtract(Times(a, e), Times(b, d, Plus(Times(C2, p), C3))), Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Plus(p, C1)), Power(Times(C3, Sqr(a)), CN1)), x), And(EqQ(Subtract(Times(C3, Sqr(a), g), Times(c, Plus(Times(C4, p), C7), Subtract(Times(a, e), Times(b, d, Plus(Times(C2, p), C3))))), C0), EqQ(Subtract(Subtract(Times(C3, Sqr(a), f), Times(C3, a, c, d, Plus(Times(C4, p), C5))), Times(b, Plus(Times(C2, p), C5), Subtract(Times(a, e), Times(b, d, Plus(Times(C2, p), C3))))), C0)))), And(FreeQ(List(a, b, c, p), x), PolyQ($s("§pq"), Sqr(x)), EqQ(Expon($s("§pq"), x), C6))));
        }
    }
}
