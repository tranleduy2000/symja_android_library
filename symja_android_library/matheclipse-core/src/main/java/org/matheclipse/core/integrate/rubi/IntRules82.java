package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcTan;
import static org.matheclipse.core.expression.F.ArcTanh;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D3;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.C5;
import static org.matheclipse.core.expression.F.C6;
import static org.matheclipse.core.expression.F.C8;
import static org.matheclipse.core.expression.F.C9;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN1D3;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.CN3;
import static org.matheclipse.core.expression.F.CN4;
import static org.matheclipse.core.expression.F.CN9;
import static org.matheclipse.core.expression.F.CSqrt2;
import static org.matheclipse.core.expression.F.CSqrt3;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Factor;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.Function;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Module;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.PSymbol;
import static org.matheclipse.core.expression.F.P_;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.PolynomialQuotient;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.QQ;
import static org.matheclipse.core.expression.F.QSymbol;
import static org.matheclipse.core.expression.F.Q_;
import static org.matheclipse.core.expression.F.ReplaceAll;
import static org.matheclipse.core.expression.F.Rule;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Simplify;
import static org.matheclipse.core.expression.F.Slot1;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.ZZ;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.a_DEFAULT;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.j;
import static org.matheclipse.core.expression.F.j_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.r;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_DEFAULT;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Coeff;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Distrib;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EveryQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.MinimumMonomialExponent;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NegQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NonfreeFactors;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PolyGCD;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PolyQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.QuadraticProductQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalFunctionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumQ;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules82 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(2051, Int(Times($p("§pq"), Power(Times(c_, x_), m_), Power(Plus(Times(a_DEFAULT, Power(x_, j_DEFAULT)), Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Times(c, x), m), Power(Power(x, m), CN1)), Int(Times(Power(x, m), $s("§pq"), Power(Plus(Times(a, Power(x, j)), Times(b, Power(x, n))), p)), x), x), And(FreeQ(List(a, b, c, j, m, n, p), x), PolyQ($s("§pq"), Power(x, n)), Not(IntegerQ(p)), NeQ(n, j), IntegerQ(Simplify(Times(j, Power(n, CN1)))), IntegerQ(Simplify(Times(n, Power(Plus(m, C1), CN1)))), Not(IntegerQ(n)))));
            IIntegrate(2052, Int(Times($p("§pq"), Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus(Times(a_DEFAULT, Power(x_, j_DEFAULT)), Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Times(c, x), m), $s("§pq"), Power(Plus(Times(a, Power(x, j)), Times(b, Power(x, n))), p)), x), x), And(FreeQ(List(a, b, c, j, m, n, p), x), Or(PolyQ($s("§pq"), x), PolyQ($s("§pq"), Power(x, n))), Not(IntegerQ(p)), NeQ(n, j))));
            IIntegrate(2053, Int(Times($p("§pq"), Power(Plus(Times(a_DEFAULT, Power(x_, j_DEFAULT)), Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times($s("§pq"), Power(Plus(Times(a, Power(x, j)), Times(b, Power(x, n))), p)), x), x), And(FreeQ(List(a, b, j, n, p), x), Or(PolyQ($s("§pq"), x), PolyQ($s("§pq"), Power(x, n))), Not(IntegerQ(p)), NeQ(n, j))));
            IIntegrate(2054, Int(Times(u_DEFAULT, Power(P_, p_), Power(Q_, q_)), x_Symbol),
                    Condition(Module(List(Set($s("§gcd"), PolyGCD(PSymbol, QSymbol, x))), Condition(Int(Times(u, Power($s("§gcd"), Plus(p, q)), Power(PolynomialQuotient(PSymbol, $s("§gcd"), x), p), Power(PolynomialQuotient(QSymbol, $s("§gcd"), x), q)), x), NeQ($s("§gcd"), C1))), And(IGtQ(p, C0), ILtQ(q, C0), PolyQ(PSymbol, x), PolyQ(QSymbol, x))));
            IIntegrate(2055, Int(Times(u_DEFAULT, P_, Power(Q_, q_)), x_Symbol),
                    Condition(Module(List(Set($s("§gcd"), PolyGCD(PSymbol, QSymbol, x))), Condition(Int(Times(u, Power($s("§gcd"), Plus(q, C1)), PolynomialQuotient(PSymbol, $s("§gcd"), x), Power(PolynomialQuotient(QSymbol, $s("§gcd"), x), q)), x), NeQ($s("§gcd"), C1))), And(ILtQ(q, C0), PolyQ(PSymbol, x), PolyQ(QSymbol, x))));
            IIntegrate(2056, Int(Times(u_DEFAULT, Power(P_, p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(m, MinimumMonomialExponent(PSymbol, x))), Dist(Times(Power(PSymbol, FracPart(p)), Power(Times(Power(x, Times(m, FracPart(p))), Power(Distrib(Power(Power(x, m), CN1), PSymbol), FracPart(p))), CN1)), Int(Times(u, Power(x, Times(m, p)), Power(Distrib(Power(Power(x, m), CN1), PSymbol), p)), x), x)), And(FreeQ(p, x), Not(IntegerQ(p)), SumQ(PSymbol), EveryQ(Function(BinomialQ(Slot1, x)), PSymbol), Not(PolyQ(PSymbol, x, C2)))));
            IIntegrate(2057, Int(Power(P_, p_), x_Symbol),
                    Condition(With(List(Set(u, Factor(ReplaceAll(PSymbol, Rule(x, Sqrt(x)))))), Condition(Int(ExpandIntegrand(Power(ReplaceAll(u, Rule(x, Sqr(x))), p), x), x), Not(SumQ(NonfreeFactors(u, x))))), And(PolyQ(PSymbol, Sqr(x)), ILtQ(p, C0))));
            IIntegrate(2058, Int(Power(P_, p_), x_Symbol),
                    Condition(With(List(Set(u, Factor(PSymbol))), Condition(Int(ExpandIntegrand(Power(u, p), x), x), Not(SumQ(NonfreeFactors(u, x))))), And(PolyQ(PSymbol, x), ILtQ(p, C0))));
            IIntegrate(2059, Int(Power(P_, p_), x_Symbol),
                    Condition(With(List(Set(u, Factor(PSymbol))), Condition(Int(Power(u, p), x), Not(SumQ(NonfreeFactors(u, x))))), And(PolyQ(PSymbol, x), IntegerQ(p))));
            IIntegrate(2060, Int(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_)), Times(d_DEFAULT, Power(x_, C3))), p_), x_Symbol),
                    Condition(Dist(Power(Power(C3, p), CN1), Subst(Int(Power(Simp(Plus(Times(Subtract(Times(C3, a, c), Sqr(b)), Power(c, CN1)), Times(Sqr(c), Power(x, C3), Power(b, CN1))), x), p), x), x, Plus(Times(c, Power(Times(C3, d), CN1)), x)), x), And(FreeQ(List(a, b, c, d), x), IGtQ(p, C0), EqQ(Subtract(Sqr(c), Times(C3, b, d)), C0))));
            IIntegrate(2061, Int(Power(P_, p_), x_Symbol),
                    Condition(Int(ExpandToSum(Power(PSymbol, p), x), x), And(PolyQ(PSymbol, x), IGtQ(p, C0))));
            IIntegrate(2062, Int(Power(P_, p_), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(PSymbol, p), x), x), And(PolyQ(PSymbol, x), IntegerQ(p), QuadraticProductQ(Factor(PSymbol), x))));
            IIntegrate(2063, Int(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(d_DEFAULT, Power(x_, C3))), p_), x_Symbol),
                    Condition(Dist(Power(Times(Power(C3, Times(C3, p)), Power(a, Times(C2, p))), CN1), Int(Times(Power(Subtract(Times(C3, a), Times(b, x)), p), Power(Plus(Times(C3, a), Times(C2, b, x)), Times(C2, p))), x), x), And(FreeQ(List(a, b, d), x), EqQ(Plus(Times(C4, Power(b, C3)), Times(ZZ(27L), Sqr(a), d)), C0), IntegerQ(p))));
            IIntegrate(2064, Int(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(d_DEFAULT, Power(x_, C3))), p_), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, x), Times(d, Power(x, C3))), p), Power(Times(Power(Subtract(Times(C3, a), Times(b, x)), p), Power(Plus(Times(C3, a), Times(C2, b, x)), Times(C2, p))), CN1)), Int(Times(Power(Subtract(Times(C3, a), Times(b, x)), p), Power(Plus(Times(C3, a), Times(C2, b, x)), Times(C2, p))), x), x), And(FreeQ(List(a, b, d, p), x), EqQ(Plus(Times(C4, Power(b, C3)), Times(ZZ(27L), Sqr(a), d)), C0), Not(IntegerQ(p)))));
            IIntegrate(2065, Int(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(d_DEFAULT, Power(x_, C3))), p_), x_Symbol),
                    Condition(With(List(Set(r, Rt(Plus(Times(CN9, a, Sqr(d)), Times(CSqrt3, d, Sqrt(Plus(Times(C4, Power(b, C3), d), Times(ZZ(27L), Sqr(a), Sqr(d)))))), C3))), Dist(Power(Power(d, Times(C2, p)), CN1), Int(Times(Power(Simp(Plus(Times(Power(ZZ(18L), C1D3), b, d, Power(Times(C3, r), CN1)), Times(CN1, r, Power(ZZ(18L), CN1D3)), Times(d, x)), x), p), Power(Simp(Plus(Times(C1D3, b, d), Times(Power(ZZ(12L), C1D3), Sqr(b), Sqr(d), Power(Times(C3, Sqr(r)), CN1)), Times(Sqr(r), Power(Times(C3, Power(ZZ(12L), C1D3)), CN1)), Times(CN1, d, Subtract(Times(Power(C2, C1D3), b, d, Power(Times(Power(C3, C1D3), r), CN1)), Times(r, Power(ZZ(18L), CN1D3))), x), Times(Sqr(d), Sqr(x))), x), p)), x), x)), And(FreeQ(List(a, b, d), x), NeQ(Plus(Times(C4, Power(b, C3)), Times(ZZ(27L), Sqr(a), d)), C0), IntegerQ(p))));
            IIntegrate(2066, Int(Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(d_DEFAULT, Power(x_, C3))), p_), x_Symbol),
                    Condition(With(List(Set(r, Rt(Plus(Times(CN9, a, Sqr(d)), Times(CSqrt3, d, Sqrt(Plus(Times(C4, Power(b, C3), d), Times(ZZ(27L), Sqr(a), Sqr(d)))))), C3))), Dist(Times(Power(Plus(a, Times(b, x), Times(d, Power(x, C3))), p), Power(Times(Power(Simp(Plus(Times(Power(ZZ(18L), C1D3), b, d, Power(Times(C3, r), CN1)), Times(CN1, r, Power(ZZ(18L), CN1D3)), Times(d, x)), x), p), Power(Simp(Plus(Times(C1D3, b, d), Times(Power(ZZ(12L), C1D3), Sqr(b), Sqr(d), Power(Times(C3, Sqr(r)), CN1)), Times(Sqr(r), Power(Times(C3, Power(ZZ(12L), C1D3)), CN1)), Times(CN1, d, Subtract(Times(Power(C2, C1D3), b, d, Power(Times(Power(C3, C1D3), r), CN1)), Times(r, Power(ZZ(18L), CN1D3))), x), Times(Sqr(d), Sqr(x))), x), p)), CN1)), Int(Times(Power(Simp(Plus(Times(Power(ZZ(18L), C1D3), b, d, Power(Times(C3, r), CN1)), Times(CN1, r, Power(ZZ(18L), CN1D3)), Times(d, x)), x), p), Power(Simp(Plus(Times(C1D3, b, d), Times(Power(ZZ(12L), C1D3), Sqr(b), Sqr(d), Power(Times(C3, Sqr(r)), CN1)), Times(Sqr(r), Power(Times(C3, Power(ZZ(12L), C1D3)), CN1)), Times(CN1, d, Subtract(Times(Power(C2, C1D3), b, d, Power(Times(Power(C3, C1D3), r), CN1)), Times(r, Power(ZZ(18L), CN1D3))), x), Times(Sqr(d), Sqr(x))), x), p)), x), x)), And(FreeQ(List(a, b, d, p), x), NeQ(Plus(Times(C4, Power(b, C3)), Times(ZZ(27L), Sqr(a), d)), C0), Not(IntegerQ(p)))));
            IIntegrate(2067, Int(Power($p("§p3"), p_), x_Symbol),
                    Condition(With(List(Set(a, Coeff($s("§p3"), x, C0)), Set(b, Coeff($s("§p3"), x, C1)), Set(c, Coeff($s("§p3"), x, C2)), Set(d, Coeff($s("§p3"), x, C3))), Condition(Subst(Int(Power(Simp(Plus(Times(Plus(Times(C2, Power(c, C3)), Times(CN1, C9, b, c, d), Times(ZZ(27L), a, Sqr(d))), Power(Times(ZZ(27L), Sqr(d)), CN1)), Times(CN1, Subtract(Sqr(c), Times(C3, b, d)), x, Power(Times(C3, d), CN1)), Times(d, Power(x, C3))), x), p), x), x, Plus(x, Times(c, Power(Times(C3, d), CN1)))), NeQ(c, C0))), And(FreeQ(p, x), PolyQ($s("§p3"), x, C3))));
            IIntegrate(2068, Int(Power($p("§p4"), p_), x_Symbol),
                    Condition(With(List(Set(a, Coeff($s("§p4"), x, C0)), Set(b, Coeff($s("§p4"), x, C1)), Set(c, Coeff($s("§p4"), x, C2)), Set(d, Coeff($s("§p4"), x, C3)), Set(e, Coeff($s("§p4"), x, C4))), Condition(Dist(Power(Power(a, Times(C3, p)), CN1), Int(ExpandIntegrand(Power(Times(Power(Subtract(a, Times(b, x)), p), Power(Power(Subtract(Power(a, C5), Times(Power(b, C5), Power(x, C5))), p), CN1)), CN1), x), x), x), And(NeQ(a, C0), EqQ(c, Times(Sqr(b), Power(a, CN1))), EqQ(d, Times(Power(b, C3), Power(a, CN2))), EqQ(e, Times(Power(b, C4), Power(a, CN3)))))), And(FreeQ(p, x), PolyQ($s("§p4"), x, C4), ILtQ(p, C0))));
            IIntegrate(2069, Int(Power($p("§p4"), p_), x_Symbol),
                    Condition(With(List(Set(a, Coeff($s("§p4"), x, C0)), Set(b, Coeff($s("§p4"), x, C1)), Set(c, Coeff($s("§p4"), x, C2)), Set(d, Coeff($s("§p4"), x, C3)), Set(e, Coeff($s("§p4"), x, C4))), Condition(Dist(Times(ZZ(-16L), Sqr(a)), Subst(Int(Times(C1, Power(Times(a, Plus(Times(CN3, Power(b, C4)), Times(ZZ(16L), a, Sqr(b), c), Times(CN1, ZZ(64L), Sqr(a), b, d), Times(ZZ(256L), Power(a, C3), e), Times(CN1, ZZ(32L), Sqr(a), Subtract(Times(C3, Sqr(b)), Times(C8, a, c)), Sqr(x)), Times(ZZ(256L), Power(a, C4), Power(x, C4))), Power(Subtract(b, Times(C4, a, x)), CN4)), p), Power(Subtract(b, Times(C4, a, x)), CN2)), x), x, Plus(Times(b, Power(Times(C4, a), CN1)), Power(x, CN1))), x), And(NeQ(a, C0), NeQ(b, C0), EqQ(Plus(Power(b, C3), Times(CN1, C4, a, b, c), Times(C8, Sqr(a), d)), C0)))), And(FreeQ(p, x), PolyQ($s("§p4"), x, C4), IntegerQ(Times(C2, p)), Not(IGtQ(p, C0)))));
            IIntegrate(2070, Int(Power($p("§q6"), p_), x_Symbol),
                    Condition(With(List(Set(a, Coeff($s("§q6"), x, C0)), Set(b, Coeff($s("§q6"), x, C2)), Set(c, Coeff($s("§q6"), x, C3)), Set(d, Coeff($s("§q6"), x, C4)), Set(e, Coeff($s("§q6"), x, C6))), Condition(Dist(Power(Times(Power(C3, Times(C3, p)), Power(a, Times(C2, p))), CN1), Int(ExpandIntegrand(Times(Power(Plus(Times(C3, a), Times(C3, Sqr(Rt(a, C3)), Rt(c, C3), x), Times(b, Sqr(x))), p), Power(Plus(Times(C3, a), Times(CN1, C3, Power(CN1, C1D3), Sqr(Rt(a, C3)), Rt(c, C3), x), Times(b, Sqr(x))), p), Power(Plus(Times(C3, a), Times(C3, Power(CN1, QQ(2L, 3L)), Sqr(Rt(a, C3)), Rt(c, C3), x), Times(b, Sqr(x))), p)), x), x), x), And(EqQ(Subtract(Sqr(b), Times(C3, a, d)), C0), EqQ(Subtract(Power(b, C3), Times(ZZ(27L), Sqr(a), e)), C0)))), And(ILtQ(p, C0), PolyQ($s("§q6"), x, C6), EqQ(Coeff($s("§q6"), x, C1), C0), EqQ(Coeff($s("§q6"), x, C5), C0), RationalFunctionQ(u, x))));
            IIntegrate(2071, Int(Times(Sqrt(v_), Power(Plus(d_, Times(e_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(With(List(Set(a, Coeff(v, x, C0)), Set(b, Coeff(v, x, C2)), Set(c, Coeff(v, x, C4))), Condition(Dist(Times(a, Power(d, CN1)), Subst(Int(Power(Plus(C1, Times(CN1, C2, b, Sqr(x)), Times(Subtract(Sqr(b), Times(C4, a, c)), Power(x, C4))), CN1), x), x, Times(x, Power(v, CN1D2))), x), And(EqQ(Plus(Times(c, d), Times(a, e)), C0), PosQ(Times(a, c))))), And(FreeQ(List(d, e), x), PolyQ(v, Sqr(x), C2))));
            IIntegrate(2072, Int(Times(Sqrt(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4)))), Power(Plus(d_, Times(e_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Sqrt(Subtract(Sqr(b), Times(C4, a, c))))), Plus(Negate(Simp(Times(a, Sqrt(Plus(b, q)), ArcTan(Times(Sqrt(Plus(b, q)), x, Plus(b, Negate(q), Times(C2, c, Sqr(x))), Power(Times(C2, CSqrt2, Rt(Times(CN1, a, c), C2), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1))), Power(Times(C2, CSqrt2, Rt(Times(CN1, a, c), C2), d), CN1)), x)), Simp(Times(a, Sqrt(Plus(Negate(b), q)), ArcTanh(Times(Sqrt(Plus(Negate(b), q)), x, Plus(b, q, Times(C2, c, Sqr(x))), Power(Times(C2, CSqrt2, Rt(Times(CN1, a, c), C2), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1))), Power(Times(C2, CSqrt2, Rt(Times(CN1, a, c), C2), d), CN1)), x))), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(c, d), Times(a, e)), C0), NegQ(Times(a, c)))));
            IIntegrate(2073, Int(Times(Power(P_, p_), Power(Q_, q_DEFAULT)), x_Symbol),
                    Condition(With(List(Set($s("§pp"), Factor(ReplaceAll(PSymbol, Rule(x, Sqrt(x)))))), Condition(Int(ExpandIntegrand(Times(Power(ReplaceAll($s("§pp"), Rule(x, Sqr(x))), p), Power(QSymbol, q)), x), x), Not(SumQ(NonfreeFactors($s("§pp"), x))))), And(FreeQ(q, x), PolyQ(PSymbol, Sqr(x)), PolyQ(QSymbol, x), ILtQ(p, C0))));
            IIntegrate(2074, Int(Times(Power(P_, p_), Power(Q_, q_DEFAULT)), x_Symbol),
                    Condition(With(List(Set($s("§pp"), Factor(PSymbol))), Condition(Int(ExpandIntegrand(Times(Power($s("§pp"), p), Power(QSymbol, q)), x), x), Not(SumQ(NonfreeFactors($s("§pp"), x))))), And(FreeQ(q, x), PolyQ(PSymbol, x), PolyQ(QSymbol, x), IntegerQ(p), NeQ(PSymbol, x))));
            IIntegrate(2075, Int(Times(Power(P_, p_), $p("§qm")), x_Symbol),
                    Condition(With(List(Set($s("§pp"), Factor(PSymbol))), Condition(Int(ExpandIntegrand(Times(Power($s("§pp"), p), $s("§qm")), x), x), QuadraticProductQ($s("§pp"), x))), And(PolyQ($s("§qm"), x), PolyQ(PSymbol, x), ILtQ(p, C0))));
        }
    }
}
