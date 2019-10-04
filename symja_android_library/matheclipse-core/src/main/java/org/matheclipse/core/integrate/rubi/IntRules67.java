package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.ASymbol;
import static org.matheclipse.core.expression.F.A_;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.BSymbol;
import static org.matheclipse.core.expression.F.B_DEFAULT;
import static org.matheclipse.core.expression.F.C;
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
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.Greater;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.MatchQ;
import static org.matheclipse.core.expression.F.Module;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.PolynomialQuotient;
import static org.matheclipse.core.expression.F.PolynomialRemainder;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.ReplaceAll;
import static org.matheclipse.core.expression.F.Rule;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Sum;
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
import static org.matheclipse.core.expression.F.d_;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_;
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.g_DEFAULT;
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
import static org.matheclipse.core.expression.F.r;
import static org.matheclipse.core.expression.F.r_DEFAULT;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PolyQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules67 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(1676, Int(Times($p("§pq"), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times($s("§pq"), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1)), x), x), And(FreeQ(List(a, b, c), x), PolyQ($s("§pq"), Sqr(x)), Greater(Expon($s("§pq"), Sqr(x)), C1))));
            IIntegrate(1677, Int(Times($p("§pq"), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), FracPart(p)), Power(Times(Power(Times(C4, c), IntPart(p)), Power(Plus(b, Times(C2, c, Sqr(x))), Times(C2, FracPart(p)))), CN1)), Int(Times($s("§pq"), Power(Plus(b, Times(C2, c, Sqr(x))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, p), x), PolyQ($s("§pq"), Sqr(x)), Greater(Expon($s("§pq"), Sqr(x)), C1), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(1678, Int(Times($p("§pq"), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(With(List(Set(d, Coeff(PolynomialRemainder($s("§pq"), Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), x), x, C0)), Set(e, Coeff(PolynomialRemainder($s("§pq"), Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), x), x, C2))), Plus(Simp(Times(x, Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Plus(p, C1)), Subtract(Subtract(Times(a, b, e), Times(d, Subtract(Sqr(b), Times(C2, a, c)))), Times(c, Subtract(Times(b, d), Times(C2, a, e)), Sqr(x))), Power(Times(C2, a, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1)), x), Dist(Power(Times(C2, a, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1), Int(Times(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Plus(p, C1)), ExpandToSum(Plus(Times(C2, a, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c)), PolynomialQuotient($s("§pq"), Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), x)), Times(Sqr(b), d, Plus(Times(C2, p), C3)), Times(CN1, C2, a, c, d, Plus(Times(C4, p), C5)), Times(CN1, a, b, e), Times(c, Plus(Times(C4, p), C7), Subtract(Times(b, d), Times(C2, a, e)), Sqr(x))), x)), x), x))), And(FreeQ(List(a, b, c), x), PolyQ($s("§pq"), Sqr(x)), Greater(Expon($s("§pq"), Sqr(x)), C1), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), LtQ(p, CN1))));
            IIntegrate(1679, Int(Times($p("§pq"), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(With(List(Set(q, Expon($s("§pq"), Sqr(x))), Set(e, Coeff($s("§pq"), Sqr(x), Expon($s("§pq"), Sqr(x))))), Plus(Simp(Times(e, Power(x, Subtract(Times(C2, q), C3)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Plus(p, C1)), Power(Times(c, Plus(Times(C2, q), Times(C4, p), C1)), CN1)), x), Dist(Power(Times(c, Plus(Times(C2, q), Times(C4, p), C1)), CN1), Int(Times(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p), ExpandToSum(Subtract(Subtract(Subtract(Times(c, Plus(Times(C2, q), Times(C4, p), C1), $s("§pq")), Times(a, e, Subtract(Times(C2, q), C3), Power(x, Subtract(Times(C2, q), C4)))), Times(b, e, Subtract(Plus(Times(C2, q), Times(C2, p)), C1), Power(x, Subtract(Times(C2, q), C2)))), Times(c, e, Plus(Times(C2, q), Times(C4, p), C1), Power(x, Times(C2, q)))), x)), x), x))), And(FreeQ(List(a, b, c, p), x), PolyQ($s("§pq"), Sqr(x)), Greater(Expon($s("§pq"), Sqr(x)), C1), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(LtQ(p, CN1)))));
            IIntegrate(1680, Int(Times($p("§pq"), Power($p("§q4"), p_)), x_Symbol),
                    Condition(With(List(Set(a, Coeff($s("§q4"), x, C0)), Set(b, Coeff($s("§q4"), x, C1)), Set(c, Coeff($s("§q4"), x, C2)), Set(d, Coeff($s("§q4"), x, C3)), Set(e, Coeff($s("§q4"), x, C4))), Condition(Subst(Int(SimplifyIntegrand(Times(ReplaceAll($s("§pq"), Rule(x, Plus(Times(CN1, d, Power(Times(C4, e), CN1)), x))), Power(Plus(a, Times(Power(d, C4), Power(Times(ZZ(256L), Power(e, C3)), CN1)), Times(CN1, b, d, Power(Times(C8, e), CN1)), Times(Subtract(c, Times(C3, Sqr(d), Power(Times(C8, e), CN1))), Sqr(x)), Times(e, Power(x, C4))), p)), x), x), x, Plus(Times(d, Power(Times(C4, e), CN1)), x)), And(EqQ(Plus(Power(d, C3), Times(CN1, C4, c, d, e), Times(C8, b, Sqr(e))), C0), NeQ(d, C0)))), And(FreeQ(p, x), PolyQ($s("§pq"), x), PolyQ($s("§q4"), x, C4), Not(IGtQ(p, C0)))));
            IIntegrate(1681, Int(Times($p("§px"), Power(x_, m_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§px"), x, C0)), Set(BSymbol, Coeff($s("§px"), x, C2)), Set(C, Coeff($s("§px"), x, C4))), Subtract(Simp(Times(C, Power(x, Subtract(m, C1)), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4)))), Power(Times(c, e, Plus(m, C1)), CN1)), x), Dist(Power(Times(c, e, Plus(m, C1)), CN1), Int(Times(Power(x, Subtract(m, C2)), Power(Times(Plus(d, Times(e, Sqr(x))), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1), Simp(Subtract(Subtract(Times(a, C, d, Subtract(m, C1)), Times(Subtract(Times(ASymbol, c, e, Plus(m, C1)), Times(C, Plus(Times(a, e, Subtract(m, C1)), Times(b, d, m)))), Sqr(x))), Times(Subtract(Times(BSymbol, c, e, Plus(m, C1)), Times(C, Plus(Times(b, e, m), Times(c, d, Plus(m, C1))))), Power(x, C4))), x)), x), x))), And(FreeQ(List(a, b, c, d, e), x), PolyQ($s("§px"), Sqr(x), C2), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(Times(C1D2, m), C0))));
            IIntegrate(1682, Int(Times($p("§px"), Power(x_, m_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§px"), x, C0)), Set(BSymbol, Coeff($s("§px"), x, C2)), Set(C, Coeff($s("§px"), x, C4))), Subtract(Simp(Times(C, Power(x, Subtract(m, C1)), Sqrt(Plus(a, Times(c, Power(x, C4)))), Power(Times(c, e, Plus(m, C1)), CN1)), x), Dist(Power(Times(c, e, Plus(m, C1)), CN1), Int(Times(Power(x, Subtract(m, C2)), Power(Times(Plus(d, Times(e, Sqr(x))), Sqrt(Plus(a, Times(c, Power(x, C4))))), CN1), Simp(Subtract(Subtract(Times(a, C, d, Subtract(m, C1)), Times(Subtract(Times(ASymbol, c, e, Plus(m, C1)), Times(C, a, e, Subtract(m, C1))), Sqr(x))), Times(Subtract(Times(BSymbol, c, e, Plus(m, C1)), Times(C, c, d, Plus(m, C1))), Power(x, C4))), x)), x), x))), And(FreeQ(List(a, c, d, e), x), PolyQ($s("§px"), Sqr(x), C2), IGtQ(Times(C1D2, m), C0))));
            IIntegrate(1683, Int(Times($p("§px"), Power(x_, m_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§px"), x, C0)), Set(BSymbol, Coeff($s("§px"), x, C2)), Set(C, Coeff($s("§px"), x, C4))), Plus(Simp(Times(ASymbol, Power(x, Plus(m, C1)), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4)))), Power(Times(a, d, Plus(m, C1)), CN1)), x), Dist(Power(Times(a, d, Plus(m, C1)), CN1), Int(Times(Power(x, Plus(m, C2)), Power(Times(Plus(d, Times(e, Sqr(x))), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1), Simp(Subtract(Plus(Times(a, BSymbol, d, Plus(m, C1)), Times(CN1, ASymbol, Plus(Times(a, e, Plus(m, C1)), Times(b, d, Plus(m, C2)))), Times(Subtract(Times(a, C, d, Plus(m, C1)), Times(ASymbol, Plus(Times(b, e, Plus(m, C2)), Times(c, d, Plus(m, C3))))), Sqr(x))), Times(ASymbol, c, e, Plus(m, C3), Power(x, C4))), x)), x), x))), And(FreeQ(List(a, b, c, d, e), x), PolyQ($s("§px"), Sqr(x), C2), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), ILtQ(Times(C1D2, m), C0))));
            IIntegrate(1684, Int(Times($p("§px"), Power(x_, m_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§px"), x, C0)), Set(BSymbol, Coeff($s("§px"), x, C2)), Set(C, Coeff($s("§px"), x, C4))), Plus(Simp(Times(ASymbol, Power(x, Plus(m, C1)), Sqrt(Plus(a, Times(c, Power(x, C4)))), Power(Times(a, d, Plus(m, C1)), CN1)), x), Dist(Power(Times(a, d, Plus(m, C1)), CN1), Int(Times(Power(x, Plus(m, C2)), Power(Times(Plus(d, Times(e, Sqr(x))), Sqrt(Plus(a, Times(c, Power(x, C4))))), CN1), Simp(Subtract(Plus(Times(a, BSymbol, d, Plus(m, C1)), Times(CN1, ASymbol, a, e, Plus(m, C1)), Times(Subtract(Times(a, C, d, Plus(m, C1)), Times(ASymbol, c, d, Plus(m, C3))), Sqr(x))), Times(ASymbol, c, e, Plus(m, C3), Power(x, C4))), x)), x), x))), And(FreeQ(List(a, c, d, e), x), PolyQ($s("§px"), Sqr(x), C2), ILtQ(Times(C1D2, m), C0))));
            IIntegrate(1685, Int(Times($p("§px"), x_, Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(C1D2, Subst(Int(Times(ReplaceAll($s("§px"), Rule(x, Sqrt(x))), Power(Plus(d, Times(e, x)), q), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), x, Sqr(x)), x), And(FreeQ(List(a, b, c, d, e, p, q), x), PolyQ($s("§px"), Sqr(x)))));
            IIntegrate(1686, Int(Times($p("§pr"), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Int(Times(x, PolynomialQuotient($s("§pr"), x, x), Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p)), x), And(FreeQ(List(a, b, c, d, e, p, q), x), PolyQ($s("§pr"), x), EqQ(PolynomialRemainder($s("§pr"), x, x), C0), Not(MatchQ($s("§pr"), Condition(Times(Power(x, m_DEFAULT), u_DEFAULT), IntegerQ(m)))))));
            IIntegrate(1687, Int(Times($p("§pr"), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Module(List(Set(r, Expon($s("§pr"), x)), k), Plus(Int(Times(Sum(Times(Coeff($s("§pr"), x, Times(C2, k)), Power(x, Times(C2, k))), List(k, C0, Times(C1D2, r))), Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p)), x), Int(Times(x, Sum(Times(Coeff($s("§pr"), x, Plus(Times(C2, k), C1)), Power(x, Times(C2, k))), List(k, C0, Times(C1D2, Subtract(r, C1)))), Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p)), x))), And(FreeQ(List(a, b, c, d, e, p, q), x), PolyQ($s("§pr"), x), Not(PolyQ($s("§pr"), Sqr(x))))));
            IIntegrate(1688, Int(Times($p("§px"), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times($s("§px"), Power(Plus(d, Times(e, Sqr(x))), Plus(p, q)), Power(Plus(Times(a, Power(d, CN1)), Times(c, Sqr(x), Power(e, CN1))), p)), x), And(FreeQ(List(a, b, c, d, e, q), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), IntegerQ(p), Or(PolyQ($s("§px"), Sqr(x)), MatchQ($s("§px"), Condition(Power(Plus(f_, Times(g_DEFAULT, Sqr(x))), r_DEFAULT), FreeQ(List(f, g, r), x)))))));
            IIntegrate(1689, Int(Times($p("§px"), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times($s("§px"), Power(Plus(d, Times(e, Sqr(x))), Plus(p, q)), Power(Plus(Times(a, Power(d, CN1)), Times(c, Sqr(x), Power(e, CN1))), p)), x), And(FreeQ(List(a, c, d, e, q), x), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), IntegerQ(p), Or(PolyQ($s("§px"), Sqr(x)), MatchQ($s("§px"), Condition(Power(Plus(f_, Times(g_DEFAULT, Sqr(x))), r_DEFAULT), FreeQ(List(f, g, r), x)))))));
            IIntegrate(1690, Int(Times($p("§px"), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), FracPart(p)), Power(Times(Power(Plus(d, Times(e, Sqr(x))), FracPart(p)), Power(Plus(Times(a, Power(d, CN1)), Times(c, Sqr(x), Power(e, CN1))), FracPart(p))), CN1)), Int(Times($s("§px"), Power(Plus(d, Times(e, Sqr(x))), Plus(p, q)), Power(Plus(Times(a, Power(d, CN1)), Times(c, Sqr(x), Power(e, CN1))), p)), x), x), And(FreeQ(List(a, b, c, d, e, p, q), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), Not(IntegerQ(p)), Or(PolyQ($s("§px"), Sqr(x)), MatchQ($s("§px"), Condition(Power(Plus(f_, Times(g_DEFAULT, Sqr(x))), r_DEFAULT), FreeQ(List(f, g, r), x)))))));
            IIntegrate(1691, Int(Times($p("§px"), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(c, Power(x, C4))), FracPart(p)), Power(Times(Power(Plus(d, Times(e, Sqr(x))), FracPart(p)), Power(Plus(Times(a, Power(d, CN1)), Times(c, Sqr(x), Power(e, CN1))), FracPart(p))), CN1)), Int(Times($s("§px"), Power(Plus(d, Times(e, Sqr(x))), Plus(p, q)), Power(Plus(Times(a, Power(d, CN1)), Times(c, Sqr(x), Power(e, CN1))), p)), x), x), And(FreeQ(List(a, c, d, e, p, q), x), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IntegerQ(p)), Or(PolyQ($s("§px"), Sqr(x)), MatchQ($s("§px"), Condition(Power(Plus(f_, Times(g_DEFAULT, Sqr(x))), r_DEFAULT), FreeQ(List(f, g, r), x)))))));
            IIntegrate(1692, Int(Times($p("§px"), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times($s("§px"), Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p)), x), x), And(FreeQ(List(a, b, c, d, e, q), x), PolyQ($s("§px"), Sqr(x)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), IntegerQ(p))));
            IIntegrate(1693, Int(Times($p("§px"), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times($s("§px"), Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(a, Times(c, Power(x, C4))), p)), x), x), And(FreeQ(List(a, c, d, e, q), x), PolyQ($s("§px"), Sqr(x)), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), IntegerQ(p))));
            IIntegrate(1694, Int(Times($p("§p4x"), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§p4x"), x, C0)), Set(BSymbol, Coeff($s("§p4x"), x, C2)), Set(C, Coeff($s("§p4x"), x, C4))), Plus(Simp(Times(C, x, Power(Plus(d, Times(e, Sqr(x))), q), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4)))), Power(Times(c, Plus(Times(C2, q), C3)), CN1)), x), Dist(Power(Times(c, Plus(Times(C2, q), C3)), CN1), Int(Times(Power(Plus(d, Times(e, Sqr(x))), Subtract(q, C1)), Simp(Plus(Times(ASymbol, c, d, Plus(Times(C2, q), C3)), Times(CN1, a, C, d), Times(Subtract(Times(c, Plus(Times(BSymbol, d), Times(ASymbol, e)), Plus(Times(C2, q), C3)), Times(C, Plus(Times(C2, b, d), Times(a, e), Times(C2, a, e, q)))), Sqr(x)), Times(Subtract(Times(BSymbol, c, e, Plus(Times(C2, q), C3)), Times(C2, C, Plus(Times(b, e), Times(CN1, c, d, q), Times(b, e, q)))), Power(x, C4))), x), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2)), x), x))), And(FreeQ(List(a, b, c, d, e), x), PolyQ($s("§p4x"), Sqr(x)), EqQ(Expon($s("§p4x"), x), C4), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), IGtQ(q, C0))));
            IIntegrate(1695, Int(Times($p("§p4x"), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§p4x"), x, C0)), Set(BSymbol, Coeff($s("§p4x"), x, C2)), Set(C, Coeff($s("§p4x"), x, C4))), Plus(Simp(Times(C, x, Power(Plus(d, Times(e, Sqr(x))), q), Sqrt(Plus(a, Times(c, Power(x, C4)))), Power(Times(c, Plus(Times(C2, q), C3)), CN1)), x), Dist(Power(Times(c, Plus(Times(C2, q), C3)), CN1), Int(Times(Power(Plus(d, Times(e, Sqr(x))), Subtract(q, C1)), Simp(Plus(Times(ASymbol, c, d, Plus(Times(C2, q), C3)), Times(CN1, a, C, d), Times(Subtract(Times(c, Plus(Times(BSymbol, d), Times(ASymbol, e)), Plus(Times(C2, q), C3)), Times(a, C, e, Plus(Times(C2, q), C1))), Sqr(x)), Times(Plus(Times(BSymbol, c, e, Plus(Times(C2, q), C3)), Times(C2, c, C, d, q)), Power(x, C4))), x), Power(Plus(a, Times(c, Power(x, C4))), CN1D2)), x), x))), And(FreeQ(List(a, c, d, e), x), PolyQ($s("§p4x"), Sqr(x)), EqQ(Expon($s("§p4x"), x), C4), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), IGtQ(q, C0))));
            IIntegrate(1696, Int(Times($p("§p4x"), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§p4x"), x, C0)), Set(BSymbol, Coeff($s("§p4x"), x, C2)), Set(C, Coeff($s("§p4x"), x, C4))), Plus(Negate(Simp(Times(Plus(Times(C, Sqr(d)), Times(CN1, BSymbol, d, e), Times(ASymbol, Sqr(e))), x, Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4)))), Power(Times(C2, d, Plus(q, C1), Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e)))), CN1)), x)), Dist(Power(Times(C2, d, Plus(q, C1), Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e)))), CN1), Int(Times(Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Simp(Plus(Times(a, d, Subtract(Times(C, d), Times(BSymbol, e))), Times(ASymbol, Plus(Times(a, Sqr(e), Plus(Times(C2, q), C3)), Times(C2, d, Subtract(Times(c, d), Times(b, e)), Plus(q, C1)))), Times(CN1, C2, Subtract(Times(Subtract(Times(BSymbol, d), Times(ASymbol, e)), Subtract(Times(b, e, Plus(q, C2)), Times(c, d, Plus(q, C1)))), Times(C, d, Plus(Times(b, d), Times(a, e, Plus(q, C1))))), Sqr(x)), Times(c, Plus(Times(C, Sqr(d)), Times(CN1, BSymbol, d, e), Times(ASymbol, Sqr(e))), Plus(Times(C2, q), C5), Power(x, C4))), x), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2)), x), x))), And(FreeQ(List(a, b, c, d, e), x), PolyQ($s("§p4x"), Sqr(x)), LeQ(Expon($s("§p4x"), x), C4), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), ILtQ(q, CN1))));
            IIntegrate(1697, Int(Times($p("§p4x"), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§p4x"), x, C0)), Set(BSymbol, Coeff($s("§p4x"), x, C2)), Set(C, Coeff($s("§p4x"), x, C4))), Plus(Negate(Simp(Times(Plus(Times(C, Sqr(d)), Times(CN1, BSymbol, d, e), Times(ASymbol, Sqr(e))), x, Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Sqrt(Plus(a, Times(c, Power(x, C4)))), Power(Times(C2, d, Plus(q, C1), Plus(Times(c, Sqr(d)), Times(a, Sqr(e)))), CN1)), x)), Dist(Power(Times(C2, d, Plus(q, C1), Plus(Times(c, Sqr(d)), Times(a, Sqr(e)))), CN1), Int(Times(Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Simp(Plus(Times(a, d, Subtract(Times(C, d), Times(BSymbol, e))), Times(ASymbol, Plus(Times(a, Sqr(e), Plus(Times(C2, q), C3)), Times(C2, c, Sqr(d), Plus(q, C1)))), Times(C2, d, Plus(Times(BSymbol, c, d), Times(CN1, ASymbol, c, e), Times(a, C, e)), Plus(q, C1), Sqr(x)), Times(c, Plus(Times(C, Sqr(d)), Times(CN1, BSymbol, d, e), Times(ASymbol, Sqr(e))), Plus(Times(C2, q), C5), Power(x, C4))), x), Power(Plus(a, Times(c, Power(x, C4))), CN1D2)), x), x))), And(FreeQ(List(a, c, d, e), x), PolyQ($s("§p4x"), Sqr(x)), LeQ(Expon($s("§p4x"), x), C4), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), ILtQ(q, CN1))));
            IIntegrate(1698, Int(Times(Plus(A_, Times(B_DEFAULT, Sqr(x_))), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(Dist(ASymbol, Subst(Int(Power(Subtract(d, Times(Subtract(Times(b, d), Times(C2, a, e)), Sqr(x))), CN1), x), x, Times(x, Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2))), x), And(FreeQ(List(a, b, c, d, e, ASymbol, BSymbol), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), EqQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), EqQ(Plus(Times(BSymbol, d), Times(ASymbol, e)), C0))));
            IIntegrate(1699, Int(Times(Plus(A_, Times(B_DEFAULT, Sqr(x_))), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(Dist(ASymbol, Subst(Int(Power(Plus(d, Times(C2, a, e, Sqr(x))), CN1), x), x, Times(x, Power(Plus(a, Times(c, Power(x, C4))), CN1D2))), x), And(FreeQ(List(a, c, d, e, ASymbol, BSymbol), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), EqQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), EqQ(Plus(Times(BSymbol, d), Times(ASymbol, e)), C0))));
            IIntegrate(1700, Int(Times(Plus(A_, Times(B_DEFAULT, Sqr(x_))), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(Subtract(Dist(Times(Plus(Times(BSymbol, d), Times(ASymbol, e)), Power(Times(C2, d, e), CN1)), Int(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2), x), x), Dist(Times(Subtract(Times(BSymbol, d), Times(ASymbol, e)), Power(Times(C2, d, e), CN1)), Int(Times(Subtract(d, Times(e, Sqr(x))), Power(Times(Plus(d, Times(e, Sqr(x))), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, ASymbol, BSymbol), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), EqQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), NeQ(Plus(Times(BSymbol, d), Times(ASymbol, e)), C0))));
        }
    }
}
