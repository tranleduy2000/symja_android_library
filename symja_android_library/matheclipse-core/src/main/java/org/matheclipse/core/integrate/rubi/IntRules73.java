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
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.D;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.Floor;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.GCD;
import static org.matheclipse.core.expression.F.GreaterEqual;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.Less;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Module;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.PolynomialQuotient;
import static org.matheclipse.core.expression.F.PolynomialRemainder;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.QQ;
import static org.matheclipse.core.expression.F.QSymbol;
import static org.matheclipse.core.expression.F.ReplaceAll;
import static org.matheclipse.core.expression.F.Rule;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Simplify;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Sum;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.Unequal;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.g_DEFAULT;
import static org.matheclipse.core.expression.F.h;
import static org.matheclipse.core.expression.F.h_DEFAULT;
import static org.matheclipse.core.expression.F.i;
import static org.matheclipse.core.expression.F.j;
import static org.matheclipse.core.expression.F.k;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearPairQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PolyQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SubstFor;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumQ;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules73 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(1826, Int(Times($p("§pq"), Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_DEFAULT))), p_)), x_Symbol),
                    Condition(Module(List(Set(q, Expon($s("§pq"), x)), i), Plus(Simp(Times(Power(Times(c, x), m), Power(Plus(a, Times(b, Power(x, n))), p), Sum(Times(Coeff($s("§pq"), x, i), Power(x, Plus(i, C1)), Power(Plus(m, Times(n, p), i, C1), CN1)), List(i, C0, q))), x), Dist(Times(a, n, p), Int(Times(Power(Times(c, x), m), Power(Plus(a, Times(b, Power(x, n))), Subtract(p, C1)), Sum(Times(Coeff($s("§pq"), x, i), Power(x, i), Power(Plus(m, Times(n, p), i, C1), CN1)), List(i, C0, q))), x), x))), And(FreeQ(List(a, b, c, m), x), PolyQ($s("§pq"), x), IGtQ(Times(C1D2, Subtract(n, C1)), C0), GtQ(p, C0))));
            IIntegrate(1827, Int(Times($p("§p4"), Sqr(x_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, C4))), QQ(-3L, 2L))), x_Symbol),
                    Condition(With(List(Set(e, Coeff($s("§p4"), x, C0)), Set(f, Coeff($s("§p4"), x, C1)), Set(h, Coeff($s("§p4"), x, C4))), Condition(Negate(Simp(Times(Subtract(f, Times(C2, h, Power(x, C3))), Power(Times(C2, b, Sqrt(Plus(a, Times(b, Power(x, C4))))), CN1)), x)), EqQ(Subtract(Times(b, e), Times(C3, a, h)), C0))), And(FreeQ(List(a, b), x), PolyQ($s("§p4"), x, C4), EqQ(Coeff($s("§p4"), x, C2), C0), EqQ(Coeff($s("§p4"), x, C3), C0))));
            IIntegrate(1828, Int(Times($p("§pq"), Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_DEFAULT))), p_)), x_Symbol),
                    Condition(With(List(Set(q, Plus(m, Expon($s("§pq"), x)))), Condition(Module(List(Set(QSymbol, PolynomialQuotient(Times(Power(b, Plus(Floor(Times(Subtract(q, C1), Power(n, CN1))), C1)), Power(x, m), $s("§pq")), Plus(a, Times(b, Power(x, n))), x)), Set($s("R"), PolynomialRemainder(Times(Power(b, Plus(Floor(Times(Subtract(q, C1), Power(n, CN1))), C1)), Power(x, m), $s("§pq")), Plus(a, Times(b, Power(x, n))), x))), Subtract(Dist(Power(Times(a, n, Plus(p, C1), Power(b, Plus(Floor(Times(Subtract(q, C1), Power(n, CN1))), C1))), CN1), Int(Times(Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), ExpandToSum(Plus(Times(a, n, Plus(p, C1), QSymbol), Times(n, Plus(p, C1), $s("R")), D(Times(x, $s("R")), x)), x)), x), x), Simp(Times(x, $s("R"), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Times(a, n, Plus(p, C1), Power(b, Plus(Floor(Times(Subtract(q, C1), Power(n, CN1))), C1))), CN1)), x))), GeQ(q, n))), And(FreeQ(List(a, b), x), PolyQ($s("§pq"), x), IGtQ(n, C0), LtQ(p, CN1), IGtQ(m, C0))));
            IIntegrate(1829, Int(Times($p("§pq"), Power(x_, m_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_DEFAULT))), p_)), x_Symbol),
                    Condition(With(List(Set(q, Expon($s("§pq"), x))), Module(List(Set(QSymbol, PolynomialQuotient(Times(a, Power(b, Plus(Floor(Times(Subtract(q, C1), Power(n, CN1))), C1)), Power(x, m), $s("§pq")), Plus(a, Times(b, Power(x, n))), x)), Set($s("R"), PolynomialRemainder(Times(a, Power(b, Plus(Floor(Times(Subtract(q, C1), Power(n, CN1))), C1)), Power(x, m), $s("§pq")), Plus(a, Times(b, Power(x, n))), x)), i), Subtract(Dist(Power(Times(a, n, Plus(p, C1), Power(b, Plus(Floor(Times(Subtract(q, C1), Power(n, CN1))), C1))), CN1), Int(Times(Power(x, m), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), ExpandToSum(Plus(Times(n, Plus(p, C1), QSymbol, Power(Power(x, m), CN1)), Sum(Times(Plus(Times(n, Plus(p, C1)), i, C1), Coeff($s("R"), x, i), Power(x, Subtract(i, m)), Power(a, CN1)), List(i, C0, Subtract(n, C1)))), x)), x), x), Simp(Times(x, $s("R"), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Times(Sqr(a), n, Plus(p, C1), Power(b, Plus(Floor(Times(Subtract(q, C1), Power(n, CN1))), C1))), CN1)), x)))), And(FreeQ(List(a, b), x), PolyQ($s("§pq"), x), IGtQ(n, C0), LtQ(p, CN1), ILtQ(m, C0))));
            IIntegrate(1830, Int(Times($p("§pq"), Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(With(List(Set(g, GCD(Plus(m, C1), n))), Condition(Dist(Power(g, CN1), Subst(Int(Times(Power(x, Subtract(Times(Plus(m, C1), Power(g, CN1)), C1)), ReplaceAll($s("§pq"), Rule(x, Power(x, Power(g, CN1)))), Power(Plus(a, Times(b, Power(x, Times(n, Power(g, CN1))))), p)), x), x, Power(x, g)), x), Unequal(g, C1))), And(FreeQ(List(a, b, p), x), PolyQ($s("§pq"), Power(x, n)), IGtQ(n, C0), IntegerQ(m))));
            IIntegrate(1831, Int(Times($p("§pq"), Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), CN1)), x_Symbol),
                    Condition(With(List(Set(v, Sum(Times(Power(Times(c, x), Plus(m, $s("ii"))), Plus(Coeff($s("§pq"), x, $s("ii")), Times(Coeff($s("§pq"), x, Plus(Times(C1D2, n), $s("ii"))), Power(x, Times(C1D2, n)))), Power(Times(Power(c, $s("ii")), Plus(a, Times(b, Power(x, n)))), CN1)), List($s("ii"), C0, Subtract(Times(C1D2, n), C1))))), Condition(Int(v, x), SumQ(v))), And(FreeQ(List(a, b, c, m), x), PolyQ($s("§pq"), x), IGtQ(Times(C1D2, n), C0), Less(Expon($s("§pq"), x), n))));
            IIntegrate(1832, Int(Times($p("§pq"), Power(x_, CN1), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), CN1D2)), x_Symbol),
                    Condition(Plus(Dist(Coeff($s("§pq"), x, C0), Int(Power(Times(x, Sqrt(Plus(a, Times(b, Power(x, n))))), CN1), x), x), Int(Times(ExpandToSum(Times(Subtract($s("§pq"), Coeff($s("§pq"), x, C0)), Power(x, CN1)), x), Power(Plus(a, Times(b, Power(x, n))), CN1D2)), x)), And(FreeQ(List(a, b), x), PolyQ($s("§pq"), x), IGtQ(n, C0), NeQ(Coeff($s("§pq"), x, C0), C0))));
            IIntegrate(1833, Int(Times($p("§pq"), Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Module(List(Set(q, Expon($s("§pq"), x)), j, k), Int(Sum(Times(Power(Times(c, x), Plus(m, j)), Sum(Times(Coeff($s("§pq"), x, Plus(j, Times(C1D2, k, n))), Power(x, Times(C1D2, k, n))), List(k, C0, Plus(Times(C2, Subtract(q, j), Power(n, CN1)), C1))), Power(Plus(a, Times(b, Power(x, n))), p), Power(Power(c, j), CN1)), List(j, C0, Subtract(Times(C1D2, n), C1))), x)), And(FreeQ(List(a, b, c, m, p), x), PolyQ($s("§pq"), x), IGtQ(Times(C1D2, n), C0), Not(PolyQ($s("§pq"), Power(x, Times(C1D2, n)))))));
            IIntegrate(1834, Int(Times($p("§pq"), Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), CN1)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Times(c, x), m), $s("§pq"), Power(Plus(a, Times(b, Power(x, n))), CN1)), x), x), And(FreeQ(List(a, b, c, m), x), PolyQ($s("§pq"), x), IntegerQ(n), Not(IGtQ(m, C0)))));
            IIntegrate(1835, Int(Times($p("§pq"), Power(Times(c_DEFAULT, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(With(List(Set($s("§pq0"), Coeff($s("§pq"), x, C0))), Condition(Plus(Simp(Times($s("§pq0"), Power(Times(c, x), Plus(m, C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Times(a, c, Plus(m, C1)), CN1)), x), Dist(Power(Times(C2, a, c, Plus(m, C1)), CN1), Int(Times(Power(Times(c, x), Plus(m, C1)), ExpandToSum(Subtract(Times(C2, a, Plus(m, C1), Subtract($s("§pq"), $s("§pq0")), Power(x, CN1)), Times(C2, b, $s("§pq0"), Plus(m, Times(n, Plus(p, C1)), C1), Power(x, Subtract(n, C1)))), x), Power(Plus(a, Times(b, Power(x, n))), p)), x), x)), NeQ($s("§pq0"), C0))), And(FreeQ(List(a, b, c, p), x), PolyQ($s("§pq"), x), IGtQ(n, C0), LtQ(m, CN1), LeQ(Subtract(n, C1), Expon($s("§pq"), x)))));
            IIntegrate(1836, Int(Times($p("§pq"), Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(With(List(Set(q, Expon($s("§pq"), x))), Condition(With(List(Set($s("§pqq"), Coeff($s("§pq"), x, q))), Plus(Dist(Power(Times(b, Plus(m, q, Times(n, p), C1)), CN1), Int(Times(Power(Times(c, x), m), ExpandToSum(Subtract(Times(b, Plus(m, q, Times(n, p), C1), Subtract($s("§pq"), Times($s("§pqq"), Power(x, q)))), Times(a, $s("§pqq"), Plus(m, q, Negate(n), C1), Power(x, Subtract(q, n)))), x), Power(Plus(a, Times(b, Power(x, n))), p)), x), x), Simp(Times($s("§pqq"), Power(Times(c, x), Plus(m, q, Negate(n), C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Times(b, Power(c, Plus(q, Negate(n), C1)), Plus(m, q, Times(n, p), C1)), CN1)), x))), And(NeQ(Plus(m, q, Times(n, p), C1), C0), GreaterEqual(Subtract(q, n), C0), Or(IntegerQ(Times(C2, p)), IntegerQ(Plus(p, Times(Plus(q, C1), Power(Times(C2, n), CN1)))))))), And(FreeQ(List(a, b, c, m, p), x), PolyQ($s("§pq"), x), IGtQ(n, C0))));
            IIntegrate(1837, Int(Times($p("§pq"), Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(With(List(Set(q, Expon($s("§pq"), x))), Negate(Subst(Int(Times(ExpandToSum(Times(Power(x, q), ReplaceAll($s("§pq"), Rule(x, Power(x, CN1)))), x), Power(Plus(a, Times(b, Power(Power(x, n), CN1))), p), Power(Power(x, Plus(m, q, C2)), CN1)), x), x, Power(x, CN1)))), And(FreeQ(List(a, b, p), x), PolyQ($s("§pq"), x), ILtQ(n, C0), IntegerQ(m))));
            IIntegrate(1838, Int(Times($p("§pq"), Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(With(List(Set(g, Denominator(m)), Set(q, Expon($s("§pq"), x))), Negate(Dist(Times(g, Power(c, CN1)), Subst(Int(Times(ExpandToSum(Times(Power(x, Times(g, q)), ReplaceAll($s("§pq"), Rule(x, Power(Times(c, Power(x, g)), CN1)))), x), Power(Plus(a, Times(b, Power(Times(Power(c, n), Power(x, Times(g, n))), CN1))), p), Power(Power(x, Plus(Times(g, Plus(m, q, C1)), C1)), CN1)), x), x, Power(Power(Times(c, x), Power(g, CN1)), CN1)), x))), And(FreeQ(List(a, b, c, p), x), PolyQ($s("§pq"), x), ILtQ(n, C0), FractionQ(m))));
            IIntegrate(1839, Int(Times($p("§pq"), Power(Times(c_DEFAULT, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(With(List(Set(q, Expon($s("§pq"), x))), Negate(Dist(Times(Power(Times(c, x), m), Power(Power(x, CN1), m)), Subst(Int(Times(ExpandToSum(Times(Power(x, q), ReplaceAll($s("§pq"), Rule(x, Power(x, CN1)))), x), Power(Plus(a, Times(b, Power(Power(x, n), CN1))), p), Power(Power(x, Plus(m, q, C2)), CN1)), x), x, Power(x, CN1)), x))), And(FreeQ(List(a, b, c, m, p), x), PolyQ($s("§pq"), x), ILtQ(n, C0), Not(RationalQ(m)))));
            IIntegrate(1840, Int(Times($p("§pq"), Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(With(List(Set(g, Denominator(n))), Dist(g, Subst(Int(Times(Power(x, Subtract(Times(g, Plus(m, C1)), C1)), ReplaceAll($s("§pq"), Rule(x, Power(x, g))), Power(Plus(a, Times(b, Power(x, Times(g, n)))), p)), x), x, Power(x, Power(g, CN1))), x)), And(FreeQ(List(a, b, m, p), x), PolyQ($s("§pq"), x), FractionQ(n))));
            IIntegrate(1841, Int(Times($p("§pq"), Power(Times(c_, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(c, IntPart(m)), Power(Times(c, x), FracPart(m)), Power(Power(x, FracPart(m)), CN1)), Int(Times(Power(x, m), $s("§pq"), Power(Plus(a, Times(b, Power(x, n))), p)), x), x), And(FreeQ(List(a, b, c, m, p), x), PolyQ($s("§pq"), x), FractionQ(n))));
            IIntegrate(1842, Int(Times($p("§pq"), Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Power(Plus(m, C1), CN1), Subst(Int(Times(ReplaceAll(SubstFor(Power(x, n), $s("§pq"), x), Rule(x, Power(x, Simplify(Times(n, Power(Plus(m, C1), CN1)))))), Power(Plus(a, Times(b, Power(x, Simplify(Times(n, Power(Plus(m, C1), CN1)))))), p)), x), x, Power(x, Plus(m, C1))), x), And(FreeQ(List(a, b, m, n, p), x), PolyQ($s("§pq"), Power(x, n)), IntegerQ(Simplify(Times(n, Power(Plus(m, C1), CN1)))), Not(IntegerQ(n)))));
            IIntegrate(1843, Int(Times($p("§pq"), Power(Times(c_, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(c, IntPart(m)), Power(Times(c, x), FracPart(m)), Power(Power(x, FracPart(m)), CN1)), Int(Times(Power(x, m), $s("§pq"), Power(Plus(a, Times(b, Power(x, n))), p)), x), x), And(FreeQ(List(a, b, c, m, n, p), x), PolyQ($s("§pq"), Power(x, n)), IntegerQ(Simplify(Times(n, Power(Plus(m, C1), CN1)))), Not(IntegerQ(n)))));
            IIntegrate(1844, Int(Times($p("§pq"), Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Times(c, x), m), $s("§pq"), Power(Plus(a, Times(b, Power(x, n))), p)), x), x), And(FreeQ(List(a, b, c, m, n, p), x), Or(PolyQ($s("§pq"), x), PolyQ($s("§pq"), Power(x, n))), Not(IGtQ(m, C0)))));
            IIntegrate(1845, Int(Times($p("§pq"), Power(u_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(v_, n_DEFAULT))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(u, m), Power(Times(Coeff(v, x, C1), Power(v, m)), CN1)), Subst(Int(Times(Power(x, m), SubstFor(v, $s("§pq"), x), Power(Plus(a, Times(b, Power(x, n))), p)), x), x, v), x), And(FreeQ(List(a, b, m, n, p), x), LinearPairQ(u, v, x), PolyQ($s("§pq"), Power(v, n)))));
            IIntegrate(1846, Int(Times($p("§pq"), Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_DEFAULT))), p_DEFAULT), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_DEFAULT))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Times(c, x), m), $s("§pq"), Power(Plus(Times($s("a1"), $s("a2")), Times($s("b1"), $s("b2"), Power(x, Times(C2, n)))), p)), x), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), c, m, n, p), x), PolyQ($s("§pq"), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), Or(IntegerQ(p), And(GtQ($s("a1"), C0), GtQ($s("a2"), C0))))));
            IIntegrate(1847, Int(Times($p("§pq"), Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus($p("a1"), Times($p("b1", true), Power(x_, n_DEFAULT))), p_DEFAULT), Power(Plus($p("a2"), Times($p("b2", true), Power(x_, n_DEFAULT))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Plus($s("a1"), Times($s("b1"), Power(x, n))), FracPart(p)), Power(Plus($s("a2"), Times($s("b2"), Power(x, n))), FracPart(p)), Power(Power(Plus(Times($s("a1"), $s("a2")), Times($s("b1"), $s("b2"), Power(x, Times(C2, n)))), FracPart(p)), CN1)), Int(Times(Power(Times(c, x), m), $s("§pq"), Power(Plus(Times($s("a1"), $s("a2")), Times($s("b1"), $s("b2"), Power(x, Times(C2, n)))), p)), x), x), And(FreeQ(List($s("a1"), $s("b1"), $s("a2"), $s("b2"), c, m, n, p), x), PolyQ($s("§pq"), x), EqQ(Plus(Times($s("a2"), $s("b1")), Times($s("a1"), $s("b2"))), C0), Not(And(EqQ(n, C1), LinearQ($s("§pq"), x))))));
            IIntegrate(1848, Int(Times(Power(Times(h_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_DEFAULT))), p_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_DEFAULT))), p_DEFAULT), Plus(e_, Times(f_DEFAULT, Power(x_, n_DEFAULT)), Times(g_DEFAULT, Power(x_, $p("n2", true))))), x_Symbol),
                    Condition(Simp(Times(e, Power(Times(h, x), Plus(m, C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), Plus(p, C1)), Power(Times(a, c, h, Plus(m, C1)), CN1)), x), And(FreeQ(List(a, b, c, d, e, f, g, h, m, n, p), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Times(a, c, f, Plus(m, C1)), Times(e, Plus(Times(b, c), Times(a, d)), Plus(m, Times(n, Plus(p, C1)), C1))), C0), EqQ(Subtract(Times(a, c, g, Plus(m, C1)), Times(b, d, e, Plus(m, Times(C2, n, Plus(p, C1)), C1))), C0), NeQ(m, CN1))));
            IIntegrate(1849, Int(Times(Power(Times(h_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_DEFAULT))), p_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_DEFAULT))), p_DEFAULT), Plus(e_, Times(g_DEFAULT, Power(x_, $p("n2", true))))), x_Symbol),
                    Condition(Simp(Times(e, Power(Times(h, x), Plus(m, C1)), Power(Plus(a, Times(b, Power(x, n))), Plus(p, C1)), Power(Plus(c, Times(d, Power(x, n))), Plus(p, C1)), Power(Times(a, c, h, Plus(m, C1)), CN1)), x), And(FreeQ(List(a, b, c, d, e, g, h, m, n, p), x), EqQ($s("n2"), Times(C2, n)), EqQ(Plus(m, Times(n, Plus(p, C1)), C1), C0), EqQ(Subtract(Times(a, c, g, Plus(m, C1)), Times(b, d, e, Plus(m, Times(C2, n, Plus(p, C1)), C1))), C0), NeQ(m, CN1))));
            IIntegrate(1850, Int(Times($p("§pq"), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_DEFAULT))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times($s("§pq"), Power(Plus(a, Times(b, Power(x, n))), p)), x), x), And(FreeQ(List(a, b, n), x), PolyQ($s("§pq"), x), Or(IGtQ(p, C0), EqQ(n, C1)))));
        }
    }
}
