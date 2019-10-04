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
import static org.matheclipse.core.expression.F.C1D3;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.C5;
import static org.matheclipse.core.expression.F.C6;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D3;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.D;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.Equal;
import static org.matheclipse.core.expression.F.Floor;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.MatchQ;
import static org.matheclipse.core.expression.F.Module;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Numerator;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.PolynomialQuotient;
import static org.matheclipse.core.expression.F.PolynomialRemainder;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.QQ;
import static org.matheclipse.core.expression.F.QSymbol;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Sum;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.h;
import static org.matheclipse.core.expression.F.i;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.r;
import static org.matheclipse.core.expression.F.s;
import static org.matheclipse.core.expression.F.u_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Coeff;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Expon;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NegQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PolyQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules74 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(1851, Int(Times($p("§pq"), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_DEFAULT))), p_)), x_Symbol),
                    Condition(Int(Times(x, PolynomialQuotient($s("§pq"), x, x), Power(Plus(a, Times(b, Power(x, n))), p)), x), And(FreeQ(List(a, b, n, p), x), PolyQ($s("§pq"), x), EqQ(Coeff($s("§pq"), x, C0), C0), Not(MatchQ($s("§pq"), Condition(Times(Power(x, m_DEFAULT), u_DEFAULT), IntegerQ(m)))))));
            IIntegrate(1852, Int(Times($p("§pq"), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_DEFAULT))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(PolynomialQuotient($s("§pq"), Plus(a, Times(b, Power(x, n))), x), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1))), x), And(FreeQ(List(a, b, p), x), PolyQ($s("§pq"), x), IGtQ(n, C0), GeQ(Expon($s("§pq"), x), n), EqQ(PolynomialRemainder($s("§pq"), Plus(a, Times(b, Power(x, n))), x), C0))));
            IIntegrate(1853, Int(Times($p("§pq"), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_DEFAULT))), p_)), x_Symbol),
                    Condition(Module(List(Set(q, Expon($s("§pq"), x)), i), Plus(Simp(Times(Power(Plus(a, Times(b, Power(x, n))), p), Sum(Times(Coeff($s("§pq"), x, i), Power(x, Plus(i, C1)), Power(Plus(Times(n, p), i, C1), CN1)), List(i, C0, q))), x), Dist(Times(a, n, p), Int(Times(Power(Plus(a, Times(b, Power(x, n))), Subtract(p, C1)), Sum(Times(Coeff($s("§pq"), x, i), Power(x, i), Power(Plus(Times(n, p), i, C1), CN1)), List(i, C0, q))), x), x))), And(FreeQ(List(a, b), x), PolyQ($s("§pq"), x), IGtQ(Times(C1D2, Subtract(n, C1)), C0), GtQ(p, C0))));
            IIntegrate(1854, Int(Times($p("§pq"), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Module(List(Set(q, Expon($s("§pq"), x)), i), Condition(Plus(Simp(Times(Subtract(Times(a, Coeff($s("§pq"), x, q)), Times(b, x, ExpandToSum(Subtract($s("§pq"), Times(Coeff($s("§pq"), x, q), Power(x, q))), x))), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Times(a, b, n, Plus(p, C1)), CN1)), x), Dist(Power(Times(a, n, Plus(p, C1)), CN1), Int(Times(Sum(Times(Plus(Times(n, Plus(p, C1)), i, C1), Coeff($s("§pq"), x, i), Power(x, i)), List(i, C0, Subtract(q, C1))), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1))), x), x)), Equal(q, Subtract(n, C1)))), And(FreeQ(List(a, b), x), PolyQ($s("§pq"), x), IGtQ(n, C0), LtQ(p, CN1))));
            IIntegrate(1855, Int(Times($p("§pq"), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_DEFAULT))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(x, $s("§pq"), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Times(a, n, Plus(p, C1)), CN1)), x)), Dist(Power(Times(a, n, Plus(p, C1)), CN1), Int(Times(ExpandToSum(Plus(Times(n, Plus(p, C1), $s("§pq")), D(Times(x, $s("§pq")), x)), x), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b), x), PolyQ($s("§pq"), x), IGtQ(n, C0), LtQ(p, CN1), LtQ(Expon($s("§pq"), x), Subtract(n, C1)))));
            IIntegrate(1856, Int(Times($p("§p4"), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C4))), QQ(-3L, 2L))), x_Symbol),
                    Condition(With(List(Set(d, Coeff($s("§p4"), x, C0)), Set(e, Coeff($s("§p4"), x, C1)), Set(f, Coeff($s("§p4"), x, C3)), Set(g, Coeff($s("§p4"), x, C4))), Condition(Negate(Simp(Times(Subtract(Plus(Times(a, f), Times(C2, a, g, x)), Times(b, e, Sqr(x))), Power(Times(C2, a, b, Sqrt(Plus(a, Times(b, Power(x, C4))))), CN1)), x)), EqQ(Plus(Times(b, d), Times(a, g)), C0))), And(FreeQ(List(a, b), x), PolyQ($s("§p4"), x, C4), EqQ(Coeff($s("§p4"), x, C2), C0))));
            IIntegrate(1857, Int(Times($p("§p6"), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C4))), QQ(-3L, 2L))), x_Symbol),
                    Condition(With(List(Set(d, Coeff($s("§p6"), x, C0)), Set(e, Coeff($s("§p6"), x, C2)), Set(f, Coeff($s("§p6"), x, C3)), Set(g, Coeff($s("§p6"), x, C4)), Set(h, Coeff($s("§p6"), x, C6))), Condition(Negate(Simp(Times(Subtract(Subtract(Times(a, f), Times(C2, b, d, x)), Times(C2, a, h, Power(x, C3))), Power(Times(C2, a, b, Sqrt(Plus(a, Times(b, Power(x, C4))))), CN1)), x)), And(EqQ(Subtract(Times(b, e), Times(C3, a, h)), C0), EqQ(Plus(Times(b, d), Times(a, g)), C0)))), And(FreeQ(List(a, b), x), PolyQ($s("§p6"), x, C6), EqQ(Coeff($s("§p6"), x, C1), C0), EqQ(Coeff($s("§p6"), x, C5), C0))));
            IIntegrate(1858, Int(Times($p("§pq"), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_DEFAULT))), p_)), x_Symbol),
                    Condition(With(List(Set(q, Expon($s("§pq"), x))), Condition(Module(List(Set(QSymbol, PolynomialQuotient(Times(Power(b, Plus(Floor(Times(Subtract(q, C1), Power(n, CN1))), C1)), $s("§pq")), Plus(a, Times(b, Power(x, n))), x)), Set($s("R"), PolynomialRemainder(Times(Power(b, Plus(Floor(Times(Subtract(q, C1), Power(n, CN1))), C1)), $s("§pq")), Plus(a, Times(b, Power(x, n))), x))), Subtract(Dist(Power(Times(a, n, Plus(p, C1), Power(b, Plus(Floor(Times(Subtract(q, C1), Power(n, CN1))), C1))), CN1), Int(Times(Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), ExpandToSum(Plus(Times(a, n, Plus(p, C1), QSymbol), Times(n, Plus(p, C1), $s("R")), D(Times(x, $s("R")), x)), x)), x), x), Simp(Times(x, $s("R"), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Times(a, n, Plus(p, C1), Power(b, Plus(Floor(Times(Subtract(q, C1), Power(n, CN1))), C1))), CN1)), x))), GeQ(q, n))), And(FreeQ(List(a, b), x), PolyQ($s("§pq"), x), IGtQ(n, C0), LtQ(p, CN1))));
            IIntegrate(1859, Int(Times(Plus(A_, Times(B_DEFAULT, x_)), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1)), x_Symbol),
                    Condition(Dist(Times(Power(BSymbol, C3), Power(b, CN1)), Int(Power(Plus(Sqr(ASymbol), Times(CN1, ASymbol, BSymbol, x), Times(Sqr(BSymbol), Sqr(x))), CN1), x), x), And(FreeQ(List(a, b, ASymbol, BSymbol), x), EqQ(Subtract(Times(a, Power(BSymbol, C3)), Times(b, Power(ASymbol, C3))), C0))));
            IIntegrate(1860, Int(Times(Plus(A_, Times(B_DEFAULT, x_)), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1)), x_Symbol),
                    Condition(With(List(Set(r, Numerator(Rt(Times(a, Power(b, CN1)), C3))), Set(s, Denominator(Rt(Times(a, Power(b, CN1)), C3)))), Plus(Negate(Dist(Times(r, Subtract(Times(BSymbol, r), Times(ASymbol, s)), Power(Times(C3, a, s), CN1)), Int(Power(Plus(r, Times(s, x)), CN1), x), x)), Dist(Times(r, Power(Times(C3, a, s), CN1)), Int(Times(Plus(Times(r, Plus(Times(BSymbol, r), Times(C2, ASymbol, s))), Times(s, Subtract(Times(BSymbol, r), Times(ASymbol, s)), x)), Power(Plus(Sqr(r), Times(CN1, r, s, x), Times(Sqr(s), Sqr(x))), CN1)), x), x))), And(FreeQ(List(a, b, ASymbol, BSymbol), x), NeQ(Subtract(Times(a, Power(BSymbol, C3)), Times(b, Power(ASymbol, C3))), C0), PosQ(Times(a, Power(b, CN1))))));
            IIntegrate(1861, Int(Times(Plus(A_, Times(B_DEFAULT, x_)), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1)), x_Symbol),
                    Condition(With(List(Set(r, Numerator(Rt(Times(CN1, a, Power(b, CN1)), C3))), Set(s, Denominator(Rt(Times(CN1, a, Power(b, CN1)), C3)))), Subtract(Dist(Times(r, Plus(Times(BSymbol, r), Times(ASymbol, s)), Power(Times(C3, a, s), CN1)), Int(Power(Subtract(r, Times(s, x)), CN1), x), x), Dist(Times(r, Power(Times(C3, a, s), CN1)), Int(Times(Subtract(Times(r, Subtract(Times(BSymbol, r), Times(C2, ASymbol, s))), Times(s, Plus(Times(BSymbol, r), Times(ASymbol, s)), x)), Power(Plus(Sqr(r), Times(r, s, x), Times(Sqr(s), Sqr(x))), CN1)), x), x))), And(FreeQ(List(a, b, ASymbol, BSymbol), x), NeQ(Subtract(Times(a, Power(BSymbol, C3)), Times(b, Power(ASymbol, C3))), C0), NegQ(Times(a, Power(b, CN1))))));
            IIntegrate(1862, Int(Times($p("§p2"), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§p2"), x, C0)), Set(BSymbol, Coeff($s("§p2"), x, C1)), Set(C, Coeff($s("§p2"), x, C2))), Condition(Negate(Dist(Times(Sqr(C), Power(b, CN1)), Int(Power(Subtract(BSymbol, Times(C, x)), CN1), x), x)), And(EqQ(Subtract(Sqr(BSymbol), Times(ASymbol, C)), C0), EqQ(Plus(Times(b, Power(BSymbol, C3)), Times(a, Power(C, C3))), C0)))), And(FreeQ(List(a, b), x), PolyQ($s("§p2"), x, C2))));
            IIntegrate(1863, Int(Times($p("§p2"), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§p2"), x, C0)), Set(BSymbol, Coeff($s("§p2"), x, C1)), Set(C, Coeff($s("§p2"), x, C2))), Condition(With(List(Set(q, Times(Power(a, C1D3), Power(b, CN1D3)))), Plus(Dist(Times(C, Power(b, CN1)), Int(Power(Plus(q, x), CN1), x), x), Dist(Times(Plus(BSymbol, Times(C, q)), Power(b, CN1)), Int(Power(Plus(Sqr(q), Times(CN1, q, x), Sqr(x)), CN1), x), x))), EqQ(Subtract(Subtract(Times(ASymbol, Power(b, QQ(2L, 3L))), Times(Power(a, C1D3), Power(b, C1D3), BSymbol)), Times(C2, Power(a, QQ(2L, 3L)), C)), C0))), And(FreeQ(List(a, b), x), PolyQ($s("§p2"), x, C2))));
            IIntegrate(1864, Int(Times($p("§p2"), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§p2"), x, C0)), Set(BSymbol, Coeff($s("§p2"), x, C1)), Set(C, Coeff($s("§p2"), x, C2))), Condition(With(List(Set(q, Times(Power(Negate(a), C1D3), Power(Negate(b), CN1D3)))), Plus(Dist(Times(C, Power(b, CN1)), Int(Power(Plus(q, x), CN1), x), x), Dist(Times(Plus(BSymbol, Times(C, q)), Power(b, CN1)), Int(Power(Plus(Sqr(q), Times(CN1, q, x), Sqr(x)), CN1), x), x))), EqQ(Subtract(Subtract(Times(ASymbol, Power(Negate(b), QQ(2L, 3L))), Times(Power(Negate(a), C1D3), Power(Negate(b), C1D3), BSymbol)), Times(C2, Power(Negate(a), QQ(2L, 3L)), C)), C0))), And(FreeQ(List(a, b), x), PolyQ($s("§p2"), x, C2))));
            IIntegrate(1865, Int(Times($p("§p2"), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§p2"), x, C0)), Set(BSymbol, Coeff($s("§p2"), x, C1)), Set(C, Coeff($s("§p2"), x, C2))), Condition(With(List(Set(q, Times(Power(Negate(a), C1D3), Power(b, CN1D3)))), Plus(Negate(Dist(Times(C, Power(b, CN1)), Int(Power(Subtract(q, x), CN1), x), x)), Dist(Times(Subtract(BSymbol, Times(C, q)), Power(b, CN1)), Int(Power(Plus(Sqr(q), Times(q, x), Sqr(x)), CN1), x), x))), EqQ(Subtract(Plus(Times(ASymbol, Power(b, QQ(2L, 3L))), Times(Power(Negate(a), C1D3), Power(b, C1D3), BSymbol)), Times(C2, Power(Negate(a), QQ(2L, 3L)), C)), C0))), And(FreeQ(List(a, b), x), PolyQ($s("§p2"), x, C2))));
            IIntegrate(1866, Int(Times($p("§p2"), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§p2"), x, C0)), Set(BSymbol, Coeff($s("§p2"), x, C1)), Set(C, Coeff($s("§p2"), x, C2))), Condition(With(List(Set(q, Times(Power(a, C1D3), Power(Negate(b), CN1D3)))), Plus(Negate(Dist(Times(C, Power(b, CN1)), Int(Power(Subtract(q, x), CN1), x), x)), Dist(Times(Subtract(BSymbol, Times(C, q)), Power(b, CN1)), Int(Power(Plus(Sqr(q), Times(q, x), Sqr(x)), CN1), x), x))), EqQ(Subtract(Plus(Times(ASymbol, Power(Negate(b), QQ(2L, 3L))), Times(Power(a, C1D3), Power(Negate(b), C1D3), BSymbol)), Times(C2, Power(a, QQ(2L, 3L)), C)), C0))), And(FreeQ(List(a, b), x), PolyQ($s("§p2"), x, C2))));
            IIntegrate(1867, Int(Times($p("§p2"), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§p2"), x, C0)), Set(BSymbol, Coeff($s("§p2"), x, C1)), Set(C, Coeff($s("§p2"), x, C2))), Condition(With(List(Set(q, Power(Times(a, Power(b, CN1)), C1D3))), Plus(Dist(Times(C, Power(b, CN1)), Int(Power(Plus(q, x), CN1), x), x), Dist(Times(Plus(BSymbol, Times(C, q)), Power(b, CN1)), Int(Power(Plus(Sqr(q), Times(CN1, q, x), Sqr(x)), CN1), x), x))), EqQ(Subtract(Subtract(ASymbol, Times(Power(Times(a, Power(b, CN1)), C1D3), BSymbol)), Times(C2, Power(Times(a, Power(b, CN1)), QQ(2L, 3L)), C)), C0))), And(FreeQ(List(a, b), x), PolyQ($s("§p2"), x, C2))));
            IIntegrate(1868, Int(Times($p("§p2"), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§p2"), x, C0)), Set(BSymbol, Coeff($s("§p2"), x, C1)), Set(C, Coeff($s("§p2"), x, C2))), Condition(With(List(Set(q, Rt(Times(a, Power(b, CN1)), C3))), Plus(Dist(Times(C, Power(b, CN1)), Int(Power(Plus(q, x), CN1), x), x), Dist(Times(Plus(BSymbol, Times(C, q)), Power(b, CN1)), Int(Power(Plus(Sqr(q), Times(CN1, q, x), Sqr(x)), CN1), x), x))), EqQ(Subtract(Subtract(ASymbol, Times(Rt(Times(a, Power(b, CN1)), C3), BSymbol)), Times(C2, Sqr(Rt(Times(a, Power(b, CN1)), C3)), C)), C0))), And(FreeQ(List(a, b), x), PolyQ($s("§p2"), x, C2))));
            IIntegrate(1869, Int(Times($p("§p2"), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§p2"), x, C0)), Set(BSymbol, Coeff($s("§p2"), x, C1)), Set(C, Coeff($s("§p2"), x, C2))), Condition(With(List(Set(q, Power(Times(CN1, a, Power(b, CN1)), C1D3))), Plus(Negate(Dist(Times(C, Power(b, CN1)), Int(Power(Subtract(q, x), CN1), x), x)), Dist(Times(Subtract(BSymbol, Times(C, q)), Power(b, CN1)), Int(Power(Plus(Sqr(q), Times(q, x), Sqr(x)), CN1), x), x))), EqQ(Subtract(Plus(ASymbol, Times(Power(Times(CN1, a, Power(b, CN1)), C1D3), BSymbol)), Times(C2, Power(Times(CN1, a, Power(b, CN1)), QQ(2L, 3L)), C)), C0))), And(FreeQ(List(a, b), x), PolyQ($s("§p2"), x, C2))));
            IIntegrate(1870, Int(Times($p("§p2"), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§p2"), x, C0)), Set(BSymbol, Coeff($s("§p2"), x, C1)), Set(C, Coeff($s("§p2"), x, C2))), Condition(With(List(Set(q, Rt(Times(CN1, a, Power(b, CN1)), C3))), Plus(Negate(Dist(Times(C, Power(b, CN1)), Int(Power(Subtract(q, x), CN1), x), x)), Dist(Times(Subtract(BSymbol, Times(C, q)), Power(b, CN1)), Int(Power(Plus(Sqr(q), Times(q, x), Sqr(x)), CN1), x), x))), EqQ(Subtract(Plus(ASymbol, Times(Rt(Times(CN1, a, Power(b, CN1)), C3), BSymbol)), Times(C2, Sqr(Rt(Times(CN1, a, Power(b, CN1)), C3)), C)), C0))), And(FreeQ(List(a, b), x), PolyQ($s("§p2"), x, C2))));
            IIntegrate(1871, Int(Times($p("§p2"), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§p2"), x, C0)), Set(BSymbol, Coeff($s("§p2"), x, C1)), Set(C, Coeff($s("§p2"), x, C2))), Condition(Plus(Int(Times(Plus(ASymbol, Times(BSymbol, x)), Power(Plus(a, Times(b, Power(x, C3))), CN1)), x), Dist(C, Int(Times(Sqr(x), Power(Plus(a, Times(b, Power(x, C3))), CN1)), x), x)), Or(EqQ(Subtract(Times(a, Power(BSymbol, C3)), Times(b, Power(ASymbol, C3))), C0), Not(RationalQ(Times(a, Power(b, CN1))))))), And(FreeQ(List(a, b), x), PolyQ($s("§p2"), x, C2))));
            IIntegrate(1872, Int(Times($p("§p2"), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§p2"), x, C0)), Set(BSymbol, Coeff($s("§p2"), x, C1)), Set(C, Coeff($s("§p2"), x, C2))), Condition(With(List(Set(q, Power(Times(a, Power(b, CN1)), C1D3))), Dist(Times(Sqr(q), Power(a, CN1)), Int(Times(Plus(ASymbol, Times(C, q, x)), Power(Plus(Sqr(q), Times(CN1, q, x), Sqr(x)), CN1)), x), x)), EqQ(Plus(ASymbol, Times(CN1, BSymbol, Power(Times(a, Power(b, CN1)), C1D3)), Times(C, Power(Times(a, Power(b, CN1)), QQ(2L, 3L)))), C0))), And(FreeQ(List(a, b), x), PolyQ($s("§p2"), x, C2))));
            IIntegrate(1873, Int(Times($p("§p2"), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§p2"), x, C0)), Set(BSymbol, Coeff($s("§p2"), x, C1)), Set(C, Coeff($s("§p2"), x, C2))), Condition(With(List(Set(q, Power(Times(CN1, a, Power(b, CN1)), C1D3))), Dist(Times(q, Power(a, CN1)), Int(Times(Plus(Times(ASymbol, q), Times(Plus(ASymbol, Times(BSymbol, q)), x)), Power(Plus(Sqr(q), Times(q, x), Sqr(x)), CN1)), x), x)), EqQ(Plus(ASymbol, Times(BSymbol, Power(Times(CN1, a, Power(b, CN1)), C1D3)), Times(C, Power(Times(CN1, a, Power(b, CN1)), QQ(2L, 3L)))), C0))), And(FreeQ(List(a, b), x), PolyQ($s("§p2"), x, C2))));
            IIntegrate(1874, Int(Times($p("§p2"), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§p2"), x, C0)), Set(BSymbol, Coeff($s("§p2"), x, C1)), Set(C, Coeff($s("§p2"), x, C2)), Set(q, Power(Times(a, Power(b, CN1)), C1D3))), Condition(Plus(Dist(Times(q, Plus(ASymbol, Times(CN1, BSymbol, q), Times(C, Sqr(q))), Power(Times(C3, a), CN1)), Int(Power(Plus(q, x), CN1), x), x), Dist(Times(q, Power(Times(C3, a), CN1)), Int(Times(Subtract(Times(q, Subtract(Plus(Times(C2, ASymbol), Times(BSymbol, q)), Times(C, Sqr(q)))), Times(Subtract(Subtract(ASymbol, Times(BSymbol, q)), Times(C2, C, Sqr(q))), x)), Power(Plus(Sqr(q), Times(CN1, q, x), Sqr(x)), CN1)), x), x)), And(NeQ(Subtract(Times(a, Power(BSymbol, C3)), Times(b, Power(ASymbol, C3))), C0), NeQ(Plus(ASymbol, Times(CN1, BSymbol, q), Times(C, Sqr(q))), C0)))), And(FreeQ(List(a, b), x), PolyQ($s("§p2"), x, C2), GtQ(Times(a, Power(b, CN1)), C0))));
            IIntegrate(1875, Int(Times($p("§p2"), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§p2"), x, C0)), Set(BSymbol, Coeff($s("§p2"), x, C1)), Set(C, Coeff($s("§p2"), x, C2)), Set(q, Power(Times(CN1, a, Power(b, CN1)), C1D3))), Condition(Plus(Dist(Times(q, Plus(ASymbol, Times(BSymbol, q), Times(C, Sqr(q))), Power(Times(C3, a), CN1)), Int(Power(Subtract(q, x), CN1), x), x), Dist(Times(q, Power(Times(C3, a), CN1)), Int(Times(Plus(Times(q, Subtract(Subtract(Times(C2, ASymbol), Times(BSymbol, q)), Times(C, Sqr(q)))), Times(Subtract(Plus(ASymbol, Times(BSymbol, q)), Times(C2, C, Sqr(q))), x)), Power(Plus(Sqr(q), Times(q, x), Sqr(x)), CN1)), x), x)), And(NeQ(Subtract(Times(a, Power(BSymbol, C3)), Times(b, Power(ASymbol, C3))), C0), NeQ(Plus(ASymbol, Times(BSymbol, q), Times(C, Sqr(q))), C0)))), And(FreeQ(List(a, b), x), PolyQ($s("§p2"), x, C2), LtQ(Times(a, Power(b, CN1)), C0))));
        }
    }
}
