package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.ASymbol;
import static org.matheclipse.core.expression.F.A_;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.BSymbol;
import static org.matheclipse.core.expression.F.B_DEFAULT;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Coefficient;
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
import static org.matheclipse.core.expression.F.PolynomialQ;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.ReplaceAll;
import static org.matheclipse.core.expression.F.Rule;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Simplify;
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
import static org.matheclipse.core.expression.F.c_;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.j;
import static org.matheclipse.core.expression.F.j_DEFAULT;
import static org.matheclipse.core.expression.F.k;
import static org.matheclipse.core.expression.F.k_DEFAULT;
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
import static org.matheclipse.core.expression.F.q_;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.r;
import static org.matheclipse.core.expression.F.r_DEFAULT;
import static org.matheclipse.core.expression.F.s;
import static org.matheclipse.core.expression.F.s_;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.u_DEFAULT;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialDegree;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialMatchQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules78 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(1951, Int(Times(Power(x_, m_DEFAULT), Power(Plus(Times(c_DEFAULT, Power(x_, j_DEFAULT)), Times(b_DEFAULT, Power(x_, n_DEFAULT)), Times(a_DEFAULT, Power(x_, q_DEFAULT))), p_DEFAULT), Plus(A_, Times(B_DEFAULT, Power(x_, r_DEFAULT)))), x_Symbol),
                    Condition(Plus(Simp(Times(ASymbol, Power(x, Plus(m, Negate(q), C1)), Power(Plus(Times(a, Power(x, q)), Times(b, Power(x, n)), Times(c, Power(x, Subtract(Times(C2, n), q)))), Plus(p, C1)), Power(Times(a, Plus(m, Times(p, q), C1)), CN1)), x), Dist(Power(Times(a, Plus(m, Times(p, q), C1)), CN1), Int(Times(Power(x, Subtract(Plus(m, n), q)), Simp(Subtract(Subtract(Times(a, BSymbol, Plus(m, Times(p, q), C1)), Times(ASymbol, b, Plus(m, Times(p, q), Times(Subtract(n, q), Plus(p, C1)), C1))), Times(ASymbol, c, Plus(m, Times(p, q), Times(C2, Subtract(n, q), Plus(p, C1)), C1), Power(x, Subtract(n, q)))), x), Power(Plus(Times(a, Power(x, q)), Times(b, Power(x, n)), Times(c, Power(x, Subtract(Times(C2, n), q)))), p)), x), x)), And(FreeQ(List(a, b, c, ASymbol, BSymbol), x), EqQ(r, Subtract(n, q)), EqQ(j, Subtract(Times(C2, n), q)), Not(IntegerQ(p)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(n, C0), RationalQ(m, p, q), Or(And(GeQ(p, CN1), LtQ(p, C0)), EqQ(Plus(m, Times(p, q), Times(Subtract(n, q), Plus(Times(C2, p), C1)), C1), C0)), LeQ(Plus(m, Times(p, q)), Negate(Subtract(n, q))), NeQ(Plus(m, Times(p, q), C1), C0))));
            IIntegrate(1952, Int(Times(Power(x_, m_DEFAULT), Power(Plus(Times(c_DEFAULT, Power(x_, j_DEFAULT)), Times(a_DEFAULT, Power(x_, q_DEFAULT))), p_DEFAULT), Plus(A_, Times(B_DEFAULT, Power(x_, r_DEFAULT)))), x_Symbol),
                    Condition(With(List(Set(n, Plus(q, r))), Condition(Plus(Simp(Times(ASymbol, Power(x, Plus(m, Negate(q), C1)), Power(Plus(Times(a, Power(x, q)), Times(c, Power(x, Subtract(Times(C2, n), q)))), Plus(p, C1)), Power(Times(a, Plus(m, Times(p, q), C1)), CN1)), x), Dist(Power(Times(a, Plus(m, Times(p, q), C1)), CN1), Int(Times(Power(x, Subtract(Plus(m, n), q)), Simp(Subtract(Times(a, BSymbol, Plus(m, Times(p, q), C1)), Times(ASymbol, c, Plus(m, Times(p, q), Times(C2, Subtract(n, q), Plus(p, C1)), C1), Power(x, Subtract(n, q)))), x), Power(Plus(Times(a, Power(x, q)), Times(c, Power(x, Subtract(Times(C2, n), q)))), p)), x), x)), And(EqQ(j, Subtract(Times(C2, n), q)), IGtQ(n, C0), Or(And(GeQ(p, CN1), LtQ(p, C0)), EqQ(Plus(m, Times(p, q), Times(Subtract(n, q), Plus(Times(C2, p), C1)), C1), C0)), LeQ(Plus(m, Times(p, q)), Negate(Subtract(n, q))), NeQ(Plus(m, Times(p, q), C1), C0)))), And(FreeQ(List(a, c, ASymbol, BSymbol), x), Not(IntegerQ(p)), RationalQ(m, p, q))));
            IIntegrate(1953, Int(Times(Power(x_, m_DEFAULT), Plus(A_, Times(B_DEFAULT, Power(x_, j_DEFAULT))), Power(Plus(Times(b_DEFAULT, Power(x_, n_DEFAULT)), Times(a_DEFAULT, Power(x_, q_DEFAULT)), Times(c_DEFAULT, Power(x_, r_DEFAULT))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Power(x, Times(C1D2, q)), Sqrt(Plus(a, Times(b, Power(x, Subtract(n, q))), Times(c, Power(x, Times(C2, Subtract(n, q)))))), Power(Plus(Times(a, Power(x, q)), Times(b, Power(x, n)), Times(c, Power(x, Subtract(Times(C2, n), q)))), CN1D2)), Int(Times(Power(x, Subtract(m, Times(C1D2, q))), Plus(ASymbol, Times(BSymbol, Power(x, Subtract(n, q)))), Power(Plus(a, Times(b, Power(x, Subtract(n, q))), Times(c, Power(x, Times(C2, Subtract(n, q))))), CN1D2)), x), x), And(FreeQ(List(a, b, c, ASymbol, BSymbol, m, n, q), x), EqQ(j, Subtract(n, q)), EqQ(r, Subtract(Times(C2, n), q)), PosQ(Subtract(n, q)), Or(EqQ(m, C1D2), EqQ(m, Negate(C1D2))), EqQ(n, C3), EqQ(q, C1))));
            IIntegrate(1954, Int(Times(Power(x_, m_DEFAULT), Power(Plus(Times(a_DEFAULT, Power(x_, j_DEFAULT)), Times(b_DEFAULT, Power(x_, k_DEFAULT)), Times(c_DEFAULT, Power(x_, n_DEFAULT))), p_), Plus(A_, Times(B_DEFAULT, Power(x_, q_)))), x_Symbol),
                    Condition(Dist(Times(Power(Plus(Times(a, Power(x, j)), Times(b, Power(x, k)), Times(c, Power(x, n))), p), Power(Times(Power(x, Times(j, p)), Power(Plus(a, Times(b, Power(x, Subtract(k, j))), Times(c, Power(x, Times(C2, Subtract(k, j))))), p)), CN1)), Int(Times(Power(x, Plus(m, Times(j, p))), Plus(ASymbol, Times(BSymbol, Power(x, Subtract(k, j)))), Power(Plus(a, Times(b, Power(x, Subtract(k, j))), Times(c, Power(x, Times(C2, Subtract(k, j))))), p)), x), x), And(FreeQ(List(a, b, c, ASymbol, BSymbol, j, k, m, p), x), EqQ(q, Subtract(k, j)), EqQ(n, Subtract(Times(C2, k), j)), Not(IntegerQ(p)), PosQ(Subtract(k, j)))));
            IIntegrate(1955, Int(Times(Power(u_, m_DEFAULT), Plus(A_, Times(B_DEFAULT, Power(u_, j_DEFAULT))), Power(Plus(Times(b_DEFAULT, Power(u_, n_DEFAULT)), Times(a_DEFAULT, Power(u_, q_DEFAULT)), Times(c_DEFAULT, Power(u_, r_DEFAULT))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Coefficient(u, x, C1), CN1), Subst(Int(Times(Power(x, m), Plus(ASymbol, Times(BSymbol, Power(x, Subtract(n, q)))), Power(Plus(Times(a, Power(x, q)), Times(b, Power(x, n)), Times(c, Power(x, Subtract(Times(C2, n), q)))), p)), x), x, u), x), And(FreeQ(List(a, b, c, ASymbol, BSymbol, m, n, p, q), x), EqQ(j, Subtract(n, q)), EqQ(r, Subtract(Times(C2, n), q)), LinearQ(u, x), NeQ(u, x))));
            IIntegrate(1956, Int(Times(Power(x_, m_DEFAULT), Power(Times(e_DEFAULT, Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_DEFAULT))), r_DEFAULT)), p_), Power(Times(f_DEFAULT, Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_DEFAULT))), s_)), q_)), x_Symbol),
                    Condition(Dist(Times(Power(Times(e, Power(Plus(a, Times(b, Power(x, n))), r)), p), Power(Times(f, Power(Plus(c, Times(d, Power(x, n))), s)), q), Power(Times(Power(Plus(a, Times(b, Power(x, n))), Times(p, r)), Power(Plus(c, Times(d, Power(x, n))), Times(q, s))), CN1)), Int(Times(Power(x, m), Power(Plus(a, Times(b, Power(x, n))), Times(p, r)), Power(Plus(c, Times(d, Power(x, n))), Times(q, s))), x), x), FreeQ(List(a, b, c, d, e, f, m, n, p, q, r, s), x)));
            IIntegrate(1957, Int(Times(u_DEFAULT, Power(Times(e_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT))), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_DEFAULT))), CN1)), p_)), x_Symbol),
                    Condition(Dist(Power(Times(b, e, Power(d, CN1)), p), Int(u, x), x), And(FreeQ(List(a, b, c, d, e, n, p), x), EqQ(Subtract(Times(b, c), Times(a, d)), C0))));
            IIntegrate(1958, Int(Times(u_DEFAULT, Power(Times(e_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT))), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_DEFAULT))), CN1)), p_)), x_Symbol),
                    Condition(Int(Times(u, Power(Times(e, Plus(a, Times(b, Power(x, n)))), p), Power(Power(Plus(c, Times(d, Power(x, n))), p), CN1)), x), And(FreeQ(List(a, b, c, d, e, n, p), x), GtQ(Times(b, d, e), C0), GtQ(Subtract(c, Times(a, d, Power(b, CN1))), C0))));
            IIntegrate(1959, Int(Power(Times(e_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT))), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_DEFAULT))), CN1)), p_), x_Symbol),
                    Condition(With(List(Set(q, Denominator(p))), Dist(Times(q, e, Subtract(Times(b, c), Times(a, d)), Power(n, CN1)), Subst(Int(Times(Power(x, Subtract(Times(q, Plus(p, C1)), C1)), Power(Plus(Times(CN1, a, e), Times(c, Power(x, q))), Subtract(Power(n, CN1), C1)), Power(Power(Subtract(Times(b, e), Times(d, Power(x, q))), Plus(Power(n, CN1), C1)), CN1)), x), x, Power(Times(e, Plus(a, Times(b, Power(x, n))), Power(Plus(c, Times(d, Power(x, n))), CN1)), Power(q, CN1))), x)), And(FreeQ(List(a, b, c, d, e), x), FractionQ(p), IntegerQ(Power(n, CN1)))));
            IIntegrate(1960, Int(Times(Power(x_, m_DEFAULT), Power(Times(e_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT))), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_DEFAULT))), CN1)), p_)), x_Symbol),
                    Condition(With(List(Set(q, Denominator(p))), Dist(Times(q, e, Subtract(Times(b, c), Times(a, d)), Power(n, CN1)), Subst(Int(Times(Power(x, Subtract(Times(q, Plus(p, C1)), C1)), Power(Plus(Times(CN1, a, e), Times(c, Power(x, q))), Subtract(Simplify(Times(Plus(m, C1), Power(n, CN1))), C1)), Power(Power(Subtract(Times(b, e), Times(d, Power(x, q))), Plus(Simplify(Times(Plus(m, C1), Power(n, CN1))), C1)), CN1)), x), x, Power(Times(e, Plus(a, Times(b, Power(x, n))), Power(Plus(c, Times(d, Power(x, n))), CN1)), Power(q, CN1))), x)), And(FreeQ(List(a, b, c, d, e, m, n), x), FractionQ(p), IntegerQ(Simplify(Times(Plus(m, C1), Power(n, CN1)))))));
            IIntegrate(1961, Int(Times(Power(u_, r_DEFAULT), Power(Times(e_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT))), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_DEFAULT))), CN1)), p_)), x_Symbol),
                    Condition(With(List(Set(q, Denominator(p))), Dist(Times(q, e, Subtract(Times(b, c), Times(a, d)), Power(n, CN1)), Subst(Int(SimplifyIntegrand(Times(Power(x, Subtract(Times(q, Plus(p, C1)), C1)), Power(Plus(Times(CN1, a, e), Times(c, Power(x, q))), Subtract(Power(n, CN1), C1)), Power(ReplaceAll(u, Rule(x, Times(Power(Plus(Times(CN1, a, e), Times(c, Power(x, q))), Power(n, CN1)), Power(Power(Subtract(Times(b, e), Times(d, Power(x, q))), Power(n, CN1)), CN1)))), r), Power(Power(Subtract(Times(b, e), Times(d, Power(x, q))), Plus(Power(n, CN1), C1)), CN1)), x), x), x, Power(Times(e, Plus(a, Times(b, Power(x, n))), Power(Plus(c, Times(d, Power(x, n))), CN1)), Power(q, CN1))), x)), And(FreeQ(List(a, b, c, d, e), x), PolynomialQ(u, x), FractionQ(p), IntegerQ(Power(n, CN1)), IntegerQ(r))));
            IIntegrate(1962, Int(Times(Power(u_, r_DEFAULT), Power(x_, m_DEFAULT), Power(Times(e_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT))), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_DEFAULT))), CN1)), p_)), x_Symbol),
                    Condition(With(List(Set(q, Denominator(p))), Dist(Times(q, e, Subtract(Times(b, c), Times(a, d)), Power(n, CN1)), Subst(Int(SimplifyIntegrand(Times(Power(x, Subtract(Times(q, Plus(p, C1)), C1)), Power(Plus(Times(CN1, a, e), Times(c, Power(x, q))), Subtract(Times(Plus(m, C1), Power(n, CN1)), C1)), Power(ReplaceAll(u, Rule(x, Times(Power(Plus(Times(CN1, a, e), Times(c, Power(x, q))), Power(n, CN1)), Power(Power(Subtract(Times(b, e), Times(d, Power(x, q))), Power(n, CN1)), CN1)))), r), Power(Power(Subtract(Times(b, e), Times(d, Power(x, q))), Plus(Times(Plus(m, C1), Power(n, CN1)), C1)), CN1)), x), x), x, Power(Times(e, Plus(a, Times(b, Power(x, n))), Power(Plus(c, Times(d, Power(x, n))), CN1)), Power(q, CN1))), x)), And(FreeQ(List(a, b, c, d, e), x), PolynomialQ(u, x), FractionQ(p), IntegerQ(Power(n, CN1)), IntegersQ(m, r))));
            IIntegrate(1963, Int(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(Times(c_DEFAULT, Power(x_, CN1)), n_))), p_), x_Symbol),
                    Condition(Negate(Dist(c, Subst(Int(Times(Power(Plus(a, Times(b, Power(x, n))), p), Power(x, CN2)), x), x, Times(c, Power(x, CN1))), x)), FreeQ(List(a, b, c, n, p), x)));
            IIntegrate(1964, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(Times(c_DEFAULT, Power(x_, CN1)), n_))), p_DEFAULT), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Negate(Dist(Power(c, Plus(m, C1)), Subst(Int(Times(Power(Plus(a, Times(b, Power(x, n))), p), Power(Power(x, Plus(m, C2)), CN1)), x), x, Times(c, Power(x, CN1))), x)), And(FreeQ(List(a, b, c, n, p), x), IntegerQ(m))));
            IIntegrate(1965, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(Times(c_DEFAULT, Power(x_, CN1)), n_))), p_DEFAULT), Power(Times(d_DEFAULT, x_), m_)), x_Symbol),
                    Condition(Negate(Dist(Times(c, Power(Times(d, x), m), Power(Times(c, Power(x, CN1)), m)), Subst(Int(Times(Power(Plus(a, Times(b, Power(x, n))), p), Power(Power(x, Plus(m, C2)), CN1)), x), x, Times(c, Power(x, CN1))), x)), And(FreeQ(List(a, b, c, d, m, n, p), x), Not(IntegerQ(m)))));
            IIntegrate(1966, Int(Power(Plus(a_DEFAULT, Times(c_DEFAULT, Power(Times(d_DEFAULT, Power(x_, CN1)), $p("n2", true))), Times(b_DEFAULT, Power(Times(d_DEFAULT, Power(x_, CN1)), n_))), p_DEFAULT), x_Symbol),
                    Condition(Negate(Dist(d, Subst(Int(Times(Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p), Power(x, CN2)), x), x, Times(d, Power(x, CN1))), x)), And(FreeQ(List(a, b, c, d, n, p), x), EqQ($s("n2"), Times(C2, n)))));
            IIntegrate(1967, Int(Times(Power(Plus(a_, Times(c_DEFAULT, Power(Times(d_DEFAULT, Power(x_, CN1)), $p("n2", true))), Times(b_DEFAULT, Power(Times(d_DEFAULT, Power(x_, CN1)), n_))), p_DEFAULT), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Negate(Dist(Power(d, Plus(m, C1)), Subst(Int(Times(Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p), Power(Power(x, Plus(m, C2)), CN1)), x), x, Times(d, Power(x, CN1))), x)), And(FreeQ(List(a, b, c, d, n, p), x), EqQ($s("n2"), Times(C2, n)), IntegerQ(m))));
            IIntegrate(1968, Int(Times(Power(Plus(a_, Times(c_DEFAULT, Power(Times(d_DEFAULT, Power(x_, CN1)), $p("n2", true))), Times(b_DEFAULT, Power(Times(d_DEFAULT, Power(x_, CN1)), n_))), p_DEFAULT), Power(Times(e_DEFAULT, x_), m_)), x_Symbol),
                    Condition(Negate(Dist(Times(d, Power(Times(e, x), m), Power(Times(d, Power(x, CN1)), m)), Subst(Int(Times(Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p), Power(Power(x, Plus(m, C2)), CN1)), x), x, Times(d, Power(x, CN1))), x)), And(FreeQ(List(a, b, c, d, e, m, n, p), x), EqQ($s("n2"), Times(C2, n)), Not(IntegerQ(m)))));
            IIntegrate(1969, Int(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(Times(d_DEFAULT, Power(x_, CN1)), n_)), Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_DEFAULT), x_Symbol),
                    Condition(Negate(Dist(d, Subst(Int(Times(Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)), Power(Power(d, Times(C2, n)), CN1))), p), Power(x, CN2)), x), x, Times(d, Power(x, CN1))), x)), And(FreeQ(List(a, b, c, d, n, p), x), EqQ($s("n2"), Times(CN2, n)), IntegerQ(Times(C2, n)))));
            IIntegrate(1970, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(Times(d_DEFAULT, Power(x_, CN1)), n_)), Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_DEFAULT)), x_Symbol),
                    Condition(Negate(Dist(Power(d, Plus(m, C1)), Subst(Int(Times(Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)), Power(Power(d, Times(C2, n)), CN1))), p), Power(Power(x, Plus(m, C2)), CN1)), x), x, Times(d, Power(x, CN1))), x)), And(FreeQ(List(a, b, c, d, n, p), x), EqQ($s("n2"), Times(CN2, n)), IntegerQ(Times(C2, n)), IntegerQ(m))));
            IIntegrate(1971, Int(Times(Power(Times(e_DEFAULT, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Power(Times(d_DEFAULT, Power(x_, CN1)), n_)), Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_DEFAULT)), x_Symbol),
                    Condition(Negate(Dist(Times(d, Power(Times(e, x), m), Power(Times(d, Power(x, CN1)), m)), Subst(Int(Times(Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)), Power(Power(d, Times(C2, n)), CN1))), p), Power(Power(x, Plus(m, C2)), CN1)), x), x, Times(d, Power(x, CN1))), x)), And(FreeQ(List(a, b, c, d, e, n, p), x), EqQ($s("n2"), Times(CN2, n)), Not(IntegerQ(m)), IntegerQ(Times(C2, n)))));
            IIntegrate(1972, Int(Power(u_, p_), x_Symbol),
                    Condition(Int(Power(ExpandToSum(u, x), p), x), And(FreeQ(p, x), BinomialQ(u, x), Not(BinomialMatchQ(u, x)))));
            IIntegrate(1973, Int(Times(Power(u_, p_DEFAULT), Power(Times(c_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Times(c, x), m), Power(ExpandToSum(u, x), p)), x), And(FreeQ(List(c, m, p), x), BinomialQ(u, x), Not(BinomialMatchQ(u, x)))));
            IIntegrate(1974, Int(Times(Power(u_, p_DEFAULT), Power(v_, q_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(ExpandToSum(u, x), p), Power(ExpandToSum(v, x), q)), x), And(FreeQ(List(p, q), x), BinomialQ(List(u, v), x), EqQ(Subtract(BinomialDegree(u, x), BinomialDegree(v, x)), C0), Not(BinomialMatchQ(List(u, v), x)))));
            IIntegrate(1975, Int(Times(Power(u_, p_DEFAULT), Power(v_, q_DEFAULT), Power(Times(e_DEFAULT, x_), m_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Times(e, x), m), Power(ExpandToSum(u, x), p), Power(ExpandToSum(v, x), q)), x), And(FreeQ(List(e, m, p, q), x), BinomialQ(List(u, v), x), EqQ(Subtract(BinomialDegree(u, x), BinomialDegree(v, x)), C0), Not(BinomialMatchQ(List(u, v), x)))));
        }
    }
}
