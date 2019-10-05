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
import static org.matheclipse.core.expression.F.C6;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.D;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.PolynomialQuotient;
import static org.matheclipse.core.expression.F.PolynomialRemainder;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Simplify;
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
import static org.matheclipse.core.expression.F.d_;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.g_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SubstFor;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules69 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(1726, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), q_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(e, C3), Power(Plus(d, Times(e, x)), Plus(q, C1)), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4)))), Power(Times(Plus(q, C1), Plus(Times(c, Power(d, C4)), Times(b, Sqr(d), Sqr(e)), Times(a, Power(e, C4)))), CN1)), x), Dist(Power(Times(Plus(q, C1), Plus(Times(c, Power(d, C4)), Times(b, Sqr(d), Sqr(e)), Times(a, Power(e, C4)))), CN1), Int(Times(Power(Plus(d, Times(e, x)), Plus(q, C1)), Simp(Subtract(Plus(Times(d, Plus(q, C1), Plus(Times(c, Sqr(d)), Times(b, Sqr(e)))), Times(CN1, e, Plus(Times(c, Sqr(d), Plus(q, C1)), Times(b, Sqr(e), Plus(q, C2))), x), Times(c, d, Sqr(e), Plus(q, C1), Sqr(x))), Times(c, Power(e, C3), Plus(q, C3), Power(x, C3))), x), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2)), x), x)), And(FreeQ(List(a, b, c, d, e), x), NeQ(Plus(Times(c, Power(d, C4)), Times(b, Sqr(d), Sqr(e)), Times(a, Power(e, C4))), C0), ILtQ(q, CN1))));
            IIntegrate(1727, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(e, C3), Power(Plus(d, Times(e, x)), Plus(q, C1)), Sqrt(Plus(a, Times(c, Power(x, C4)))), Power(Times(Plus(q, C1), Plus(Times(c, Power(d, C4)), Times(a, Power(e, C4)))), CN1)), x), Dist(Times(c, Power(Times(Plus(q, C1), Plus(Times(c, Power(d, C4)), Times(a, Power(e, C4)))), CN1)), Int(Times(Power(Plus(d, Times(e, x)), Plus(q, C1)), Simp(Subtract(Plus(Times(Power(d, C3), Plus(q, C1)), Times(CN1, Sqr(d), e, Plus(q, C1), x), Times(d, Sqr(e), Plus(q, C1), Sqr(x))), Times(Power(e, C3), Plus(q, C3), Power(x, C3))), x), Power(Plus(a, Times(c, Power(x, C4))), CN1D2)), x), x)), And(FreeQ(List(a, c, d, e), x), NeQ(Plus(Times(c, Power(d, C4)), Times(a, Power(e, C4))), C0), ILtQ(q, CN1))));
            IIntegrate(1728, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), CN1), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Subtract(Dist(d, Int(Times(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p), Power(Subtract(Sqr(d), Times(Sqr(e), Sqr(x))), CN1)), x), x), Dist(e, Int(Times(x, Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p), Power(Subtract(Sqr(d), Times(Sqr(e), Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), IntegerQ(Plus(p, C1D2)))));
            IIntegrate(1729, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), CN1), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Subtract(Dist(d, Int(Times(Power(Plus(a, Times(c, Power(x, C4))), p), Power(Subtract(Sqr(d), Times(Sqr(e), Sqr(x))), CN1)), x), x), Dist(e, Int(Times(x, Power(Plus(a, Times(c, Power(x, C4))), p), Power(Subtract(Sqr(d), Times(Sqr(e), Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, c, d, e), x), IntegerQ(Plus(p, C1D2)))));
            IIntegrate(1730, Int(Times($p("§px"), Power(Plus(d_, Times(e_DEFAULT, x_)), q_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(PolynomialQuotient($s("§px"), Plus(d, Times(e, x)), x), Power(Plus(d, Times(e, x)), Plus(q, C1)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p)), x), And(FreeQ(List(a, b, c, d, e, p, q), x), PolyQ($s("§px"), x), EqQ(PolynomialRemainder($s("§px"), Plus(d, Times(e, x)), x), C0))));
            IIntegrate(1731, Int(Times($p("§px"), Power(Plus(d_, Times(e_DEFAULT, x_)), q_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(PolynomialQuotient($s("§px"), Plus(d, Times(e, x)), x), Power(Plus(d, Times(e, x)), Plus(q, C1)), Power(Plus(a, Times(c, Power(x, C4))), p)), x), And(FreeQ(List(a, c, d, e, p, q), x), PolyQ($s("§px"), x), EqQ(PolynomialRemainder($s("§px"), Plus(d, Times(e, x)), x), C0))));
            IIntegrate(1732, Int(Times($p("§px"), Power(Plus(d_, Times(e_DEFAULT, x_)), q_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(PolynomialQuotient($s("§px"), Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), x), Power(Plus(d, Times(e, x)), q), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Plus(p, C1))), x), And(FreeQ(List(a, b, c, d, e, p, q), x), PolyQ($s("§px"), x), EqQ(PolynomialRemainder($s("§px"), Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), x), C0))));
            IIntegrate(1733, Int(Times($p("§px"), Power(Plus(d_, Times(e_DEFAULT, x_)), q_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(PolynomialQuotient($s("§px"), Plus(a, Times(c, Power(x, C4))), x), Power(Plus(d, Times(e, x)), q), Power(Plus(a, Times(c, Power(x, C4))), Plus(p, C1))), x), And(FreeQ(List(a, c, d, e, p, q), x), PolyQ($s("§px"), x), EqQ(PolynomialRemainder($s("§px"), Plus(a, Times(c, Power(x, C4))), x), C0))));
            IIntegrate(1734, Int(Times($p("§px"), Power(Plus(d_, Times(e_DEFAULT, x_)), q_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§px"), x, C0)), Set(BSymbol, Coeff($s("§px"), x, C1)), Set(C, Coeff($s("§px"), x, C2)), Set(D, Coeff($s("§px"), x, C3))), Int(Times(Power(Plus(d, Times(e, x)), Subtract(q, C1)), Plus(Times(ASymbol, d), Times(Plus(Times(BSymbol, d), Times(ASymbol, e)), x), Times(Plus(Times(C, d), Times(BSymbol, e)), Sqr(x)), Times(C, e, Power(x, C3))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2)), x)), And(FreeQ(List(a, b, c, d, e), x), PolyQ($s("§px"), x), LeQ(Expon($s("§px"), x), C2), NeQ(Plus(Times(c, Power(d, C4)), Times(b, Sqr(d), Sqr(e)), Times(a, Power(e, C4))), C0), GtQ(q, C0))));
            IIntegrate(1735, Int(Times($p("§px"), Power(Plus(d_, Times(e_DEFAULT, x_)), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§px"), x, C0)), Set(BSymbol, Coeff($s("§px"), x, C1)), Set(C, Coeff($s("§px"), x, C2)), Set(D, Coeff($s("§px"), x, C3))), Int(Times(Power(Plus(d, Times(e, x)), Subtract(q, C1)), Plus(Times(ASymbol, d), Times(Plus(Times(BSymbol, d), Times(ASymbol, e)), x), Times(Plus(Times(C, d), Times(BSymbol, e)), Sqr(x)), Times(C, e, Power(x, C3))), Power(Plus(a, Times(c, Power(x, C4))), CN1D2)), x)), And(FreeQ(List(a, c, d, e), x), PolyQ($s("§px"), x), LeQ(Expon($s("§px"), x), C2), NeQ(Plus(Times(c, Power(d, C4)), Times(a, Power(e, C4))), C0), GtQ(q, C0))));
            IIntegrate(1736, Int(Times($p("§px"), Power(Plus(d_, Times(e_DEFAULT, x_)), q_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§px"), x, C0)), Set(BSymbol, Coeff($s("§px"), x, C1)), Set(C, Coeff($s("§px"), x, C2)), Set(D, Coeff($s("§px"), x, C3))), Subtract(Simp(Times(D, Power(Plus(d, Times(e, x)), q), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4)))), Power(Times(c, Plus(q, C2)), CN1)), x), Dist(Power(Times(c, Plus(q, C2)), CN1), Int(Times(Power(Plus(d, Times(e, x)), Subtract(q, C1)), Simp(Subtract(Plus(Times(a, D, e, q), Times(CN1, ASymbol, c, d, Plus(q, C2)), Times(Subtract(Subtract(Times(b, d, D), Times(BSymbol, c, d, Plus(q, C2))), Times(ASymbol, c, e, Plus(q, C2))), x), Times(Subtract(Times(b, D, e, Plus(q, C1)), Times(c, Plus(Times(C, d), Times(BSymbol, e)), Plus(q, C2))), Sqr(x))), Times(c, Plus(Times(d, D, q), Times(C, e, Plus(q, C2))), Power(x, C3))), x), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2)), x), x))), And(FreeQ(List(a, b, c, d, e), x), PolyQ($s("§px"), x, C3), NeQ(Plus(Times(c, Power(d, C4)), Times(b, Sqr(d), Sqr(e)), Times(a, Power(e, C4))), C0), GtQ(q, C0))));
            IIntegrate(1737, Int(Times($p("§px"), Power(Plus(d_, Times(e_DEFAULT, x_)), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§px"), x, C0)), Set(BSymbol, Coeff($s("§px"), x, C1)), Set(C, Coeff($s("§px"), x, C2)), Set(D, Coeff($s("§px"), x, C3))), Subtract(Simp(Times(D, Power(Plus(d, Times(e, x)), q), Sqrt(Plus(a, Times(c, Power(x, C4)))), Power(Times(c, Plus(q, C2)), CN1)), x), Dist(Power(Times(c, Plus(q, C2)), CN1), Int(Times(Power(Plus(d, Times(e, x)), Subtract(q, C1)), Simp(Subtract(Subtract(Subtract(Subtract(Times(a, D, e, q), Times(ASymbol, c, d, Plus(q, C2))), Times(c, Plus(Times(BSymbol, d, Plus(q, C2)), Times(ASymbol, e, Plus(q, C2))), x)), Times(c, Plus(Times(C, d), Times(BSymbol, e)), Plus(q, C2), Sqr(x))), Times(c, Plus(Times(d, D, q), Times(C, e, Plus(q, C2))), Power(x, C3))), x), Power(Plus(a, Times(c, Power(x, C4))), CN1D2)), x), x))), And(FreeQ(List(a, c, d, e), x), PolyQ($s("§px"), x, C3), NeQ(Plus(Times(c, Power(d, C4)), Times(a, Power(e, C4))), C0), GtQ(q, C0))));
            IIntegrate(1738, Int(Times($p("§px"), Power(Plus(d_, Times(e_DEFAULT, x_)), q_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§px"), x, C0)), Set(BSymbol, Coeff($s("§px"), x, C1)), Set(C, Coeff($s("§px"), x, C2)), Set(D, Coeff($s("§px"), x, C3))), Plus(Negate(Simp(Times(Subtract(Plus(Times(Power(d, C3), D), Times(CN1, C, Sqr(d), e), Times(BSymbol, d, Sqr(e))), Times(ASymbol, Power(e, C3))), Power(Plus(d, Times(e, x)), Plus(q, C1)), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4)))), Power(Times(Plus(q, C1), Plus(Times(c, Power(d, C4)), Times(b, Sqr(d), Sqr(e)), Times(a, Power(e, C4)))), CN1)), x)), Dist(Power(Times(Plus(q, C1), Plus(Times(c, Power(d, C4)), Times(b, Sqr(d), Sqr(e)), Times(a, Power(e, C4)))), CN1), Int(Times(Power(Plus(d, Times(e, x)), Plus(q, C1)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2), Simp(Plus(Times(Plus(q, C1), Plus(Times(a, e, Plus(Times(Sqr(d), D), Times(CN1, C, d, e), Times(BSymbol, Sqr(e)))), Times(ASymbol, d, Plus(Times(c, Sqr(d)), Times(b, Sqr(e)))))), Times(CN1, Subtract(Subtract(Times(e, Plus(q, C1), Plus(Times(ASymbol, c, Sqr(d)), Times(a, e, Subtract(Times(d, D), Times(C, e))))), Times(BSymbol, d, Plus(Times(c, Sqr(d), Plus(q, C1)), Times(b, Sqr(e), Plus(q, C2))))), Times(b, Subtract(Subtract(Times(Power(d, C3), D), Times(C, Sqr(d), e)), Times(ASymbol, Power(e, C3), Plus(q, C2))))), x), Times(Plus(q, C1), Plus(Times(D, e, Plus(Times(b, Sqr(d)), Times(a, Sqr(e)))), Times(c, d, Subtract(Times(C, Sqr(d)), Times(e, Subtract(Times(BSymbol, d), Times(ASymbol, e)))))), Sqr(x)), Times(c, Plus(q, C3), Subtract(Plus(Times(Power(d, C3), D), Times(CN1, C, Sqr(d), e), Times(BSymbol, d, Sqr(e))), Times(ASymbol, Power(e, C3))), Power(x, C3))), x)), x), x))), And(FreeQ(List(a, b, c, d, e), x), PolyQ($s("§px"), x), LeQ(Expon($s("§px"), x), C3), NeQ(Plus(Times(c, Power(d, C4)), Times(b, Sqr(d), Sqr(e)), Times(a, Power(e, C4))), C0), LtQ(q, CN1))));
            IIntegrate(1739, Int(Times($p("§px"), Power(Plus(d_, Times(e_DEFAULT, x_)), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§px"), x, C0)), Set(BSymbol, Coeff($s("§px"), x, C1)), Set(C, Coeff($s("§px"), x, C2)), Set(D, Coeff($s("§px"), x, C3))), Plus(Negate(Simp(Times(Subtract(Plus(Times(Power(d, C3), D), Times(CN1, C, Sqr(d), e), Times(BSymbol, d, Sqr(e))), Times(ASymbol, Power(e, C3))), Power(Plus(d, Times(e, x)), Plus(q, C1)), Sqrt(Plus(a, Times(c, Power(x, C4)))), Power(Times(Plus(q, C1), Plus(Times(c, Power(d, C4)), Times(a, Power(e, C4)))), CN1)), x)), Dist(Power(Times(Plus(q, C1), Plus(Times(c, Power(d, C4)), Times(a, Power(e, C4)))), CN1), Int(Times(Power(Plus(d, Times(e, x)), Plus(q, C1)), Power(Plus(a, Times(c, Power(x, C4))), CN1D2), Simp(Plus(Times(Plus(q, C1), Plus(Times(a, e, Plus(Times(Sqr(d), D), Times(CN1, C, d, e), Times(BSymbol, Sqr(e)))), Times(ASymbol, d, c, Sqr(d)))), Times(CN1, Subtract(Times(e, Plus(q, C1), Plus(Times(ASymbol, c, Sqr(d)), Times(a, e, Subtract(Times(d, D), Times(C, e))))), Times(BSymbol, d, c, Sqr(d), Plus(q, C1))), x), Times(Plus(q, C1), Plus(Times(D, e, a, Sqr(e)), Times(c, d, Subtract(Times(C, Sqr(d)), Times(e, Subtract(Times(BSymbol, d), Times(ASymbol, e)))))), Sqr(x)), Times(c, Plus(q, C3), Subtract(Plus(Times(Power(d, C3), D), Times(CN1, C, Sqr(d), e), Times(BSymbol, d, Sqr(e))), Times(ASymbol, Power(e, C3))), Power(x, C3))), x)), x), x))), And(FreeQ(List(a, c, d, e), x), PolyQ($s("§px"), x), LeQ(Expon($s("§px"), x), C3), NeQ(Plus(Times(c, Power(d, C4)), Times(a, Power(e, C4))), C0), LtQ(q, CN1))));
            IIntegrate(1740, Int(Times(Plus(A_, Times(B_DEFAULT, x_)), Power(Plus(d_, Times(e_DEFAULT, x_)), CN1), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(Negate(Dist(Times(Sqr(ASymbol), Plus(Times(BSymbol, d), Times(ASymbol, e)), Power(e, CN1)), Subst(Int(Power(Subtract(Plus(Times(C6, Power(ASymbol, C3), BSymbol, d), Times(C3, Power(ASymbol, C4), e)), Times(a, e, Sqr(x))), CN1), x), x, Times(Sqr(Plus(ASymbol, Times(BSymbol, x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2))), x)), And(FreeQ(List(a, b, c, d, e, ASymbol, BSymbol), x), NeQ(Subtract(Times(BSymbol, d), Times(ASymbol, e)), C0), EqQ(Plus(Times(Sqr(c), Power(d, C6)), Times(a, Power(e, C4), Plus(Times(ZZ(13L), c, Sqr(d)), Times(b, Sqr(e))))), C0), EqQ(Subtract(Times(Sqr(b), Power(e, C4)), Times(ZZ(12L), c, Sqr(d), Subtract(Times(c, Sqr(d)), Times(b, Sqr(e))))), C0), EqQ(Plus(Times(C4, ASymbol, c, d, e), Times(BSymbol, Subtract(Times(C2, c, Sqr(d)), Times(b, Sqr(e))))), C0))));
            IIntegrate(1741, Int(Times($p("§px"), Power(Plus(d_, Times(e_DEFAULT, x_)), CN1), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§px"), x, C0)), Set(BSymbol, Coeff($s("§px"), x, C1)), Set(C, Coeff($s("§px"), x, C2)), Set(D, Coeff($s("§px"), x, C3))), Plus(Int(Times(x, Plus(Times(BSymbol, d), Times(CN1, ASymbol, e), Times(Subtract(Times(d, D), Times(C, e)), Sqr(x))), Power(Times(Subtract(Sqr(d), Times(Sqr(e), Sqr(x))), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1)), x), Int(Times(Subtract(Plus(Times(ASymbol, d), Times(Subtract(Times(C, d), Times(BSymbol, e)), Sqr(x))), Times(D, e, Power(x, C4))), Power(Times(Subtract(Sqr(d), Times(Sqr(e), Sqr(x))), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1)), x))), And(FreeQ(List(a, b, c, d, e), x), PolyQ($s("§px"), x), LeQ(Expon($s("§px"), x), C3), NeQ(Plus(Times(c, Power(d, C4)), Times(b, Sqr(d), Sqr(e)), Times(a, Power(e, C4))), C0))));
            IIntegrate(1742, Int(Times($p("§px"), Power(Plus(d_, Times(e_DEFAULT, x_)), CN1), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§px"), x, C0)), Set(BSymbol, Coeff($s("§px"), x, C1)), Set(C, Coeff($s("§px"), x, C2)), Set(D, Coeff($s("§px"), x, C3))), Plus(Int(Times(x, Plus(Times(BSymbol, d), Times(CN1, ASymbol, e), Times(Subtract(Times(d, D), Times(C, e)), Sqr(x))), Power(Times(Subtract(Sqr(d), Times(Sqr(e), Sqr(x))), Sqrt(Plus(a, Times(c, Power(x, C4))))), CN1)), x), Int(Times(Subtract(Plus(Times(ASymbol, d), Times(Subtract(Times(C, d), Times(BSymbol, e)), Sqr(x))), Times(D, e, Power(x, C4))), Power(Times(Subtract(Sqr(d), Times(Sqr(e), Sqr(x))), Sqrt(Plus(a, Times(c, Power(x, C4))))), CN1)), x))), And(FreeQ(List(a, c, d, e), x), PolyQ($s("§px"), x), LeQ(Expon($s("§px"), x), C3), NeQ(Plus(Times(c, Power(d, C4)), Times(a, Power(e, C4))), C0))));
            IIntegrate(1743, Int(Times($p("§px"), Power(Plus(d_, Times(e_DEFAULT, x_)), CN1), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Subtract(Dist(d, Int(Times($s("§px"), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p), Power(Subtract(Sqr(d), Times(Sqr(e), Sqr(x))), CN1)), x), x), Dist(e, Int(Times(x, $s("§px"), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p), Power(Subtract(Sqr(d), Times(Sqr(e), Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), PolyQ($s("§px"), x), IntegerQ(Plus(p, C1D2)))));
            IIntegrate(1744, Int(Times($p("§px"), Power(Plus(d_, Times(e_DEFAULT, x_)), CN1), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Subtract(Dist(d, Int(Times($s("§px"), Power(Plus(a, Times(c, Power(x, C4))), p), Power(Subtract(Sqr(d), Times(Sqr(e), Sqr(x))), CN1)), x), x), Dist(e, Int(Times(x, $s("§px"), Power(Plus(a, Times(c, Power(x, C4))), p), Power(Subtract(Sqr(d), Times(Sqr(e), Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, c, d, e), x), PolyQ($s("§px"), x), IntegerQ(Plus(p, C1D2)))));
            IIntegrate(1745, Int(Times($p("§pq"), Power(x_, m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(n, CN1), Subst(Int(Times(SubstFor(Power(x, n), $s("§pq"), x), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), x, Power(x, n)), x), And(FreeQ(List(a, b, c, m, n, p), x), EqQ($s("n2"), Times(C2, n)), PolyQ($s("§pq"), Power(x, n)), EqQ(Simplify(Plus(m, Negate(n), C1)), C0))));
            IIntegrate(1746, Int(Times($p("§pq"), Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_DEFAULT)), Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Times(d, x), m), $s("§pq"), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p)), x), x), And(FreeQ(List(a, b, c, d, m, n), x), EqQ($s("n2"), Times(C2, n)), PolyQ($s("§pq"), x), IGtQ(p, C0))));
            IIntegrate(1747, Int(Times(Power(Times(g_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_DEFAULT)), Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_DEFAULT), Plus(d_, Times(e_DEFAULT, Power(x_, n_DEFAULT)), Times(f_DEFAULT, Power(x_, $p("n2", true))))), x_Symbol),
                    Condition(Simp(Times(d, Power(Times(g, x), Plus(m, C1)), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), Plus(p, C1)), Power(Times(a, g, Plus(m, C1)), CN1)), x), And(FreeQ(List(a, b, c, d, e, f, g, m, n, p), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Times(a, e, Plus(m, C1)), Times(b, d, Plus(m, Times(n, Plus(p, C1)), C1))), C0), EqQ(Subtract(Times(a, f, Plus(m, C1)), Times(c, d, Plus(m, Times(C2, n, Plus(p, C1)), C1))), C0), NeQ(m, CN1))));
            IIntegrate(1748, Int(Times(Power(Times(g_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_DEFAULT)), Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_DEFAULT), Plus(d_, Times(f_DEFAULT, Power(x_, $p("n2", true))))), x_Symbol),
                    Condition(Simp(Times(d, Power(Times(g, x), Plus(m, C1)), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), Plus(p, C1)), Power(Times(a, g, Plus(m, C1)), CN1)), x), And(FreeQ(List(a, b, c, d, f, g, m, n, p), x), EqQ($s("n2"), Times(C2, n)), EqQ(Plus(m, Times(n, Plus(p, C1)), C1), C0), EqQ(Plus(Times(c, d), Times(a, f)), C0), NeQ(m, CN1))));
            IIntegrate(1749, Int(Times($p("§pq"), Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_DEFAULT)), Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), FracPart(p)), Power(Times(Power(Times(C4, c), IntPart(p)), Power(Plus(b, Times(C2, c, Power(x, n))), Times(C2, FracPart(p)))), CN1)), Int(Times(Power(Times(d, x), m), $s("§pq"), Power(Plus(b, Times(C2, c, Power(x, n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, m, n, p), x), EqQ($s("n2"), Times(C2, n)), PolyQ($s("§pq"), x), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(Times(C2, p))))));
            IIntegrate(1750, Int(Times($p("§pq"), Power(x_, m_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2", true))), Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Power(n, CN1), Subst(Int(Times(Power(x, Subtract(Simplify(Times(Plus(m, C1), Power(n, CN1))), C1)), SubstFor(Power(x, n), $s("§pq"), x), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), x, Power(x, n)), x), And(FreeQ(List(a, b, c, m, n, p), x), EqQ($s("n2"), Times(C2, n)), PolyQ($s("§pq"), Power(x, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(Simplify(Times(Plus(m, C1), Power(n, CN1)))))));
        }
    }
}
