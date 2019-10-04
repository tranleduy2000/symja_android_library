package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Coefficient;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.GCD;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Mod;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Quotient;
import static org.matheclipse.core.expression.F.ReplaceAll;
import static org.matheclipse.core.expression.F.Rule;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sign;
import static org.matheclipse.core.expression.F.Simplify;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_DEFAULT;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.j;
import static org.matheclipse.core.expression.F.j_;
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
import static org.matheclipse.core.expression.F.q_DEFAULT;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Expon;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearPairQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PolyQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SubstFor;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules81 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(2026, Int(Times(Power(x_, m_DEFAULT), Power(Plus(Times(a_DEFAULT, Power(x_, j_DEFAULT)), Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Power(Plus(m, C1), CN1), Subst(Int(Power(Plus(Times(a, Power(x, Simplify(Times(j, Power(Plus(m, C1), CN1))))), Times(b, Power(x, Simplify(Times(n, Power(Plus(m, C1), CN1)))))), p), x), x, Power(x, Plus(m, C1))), x), And(FreeQ(List(a, b, j, m, n, p), x), Not(IntegerQ(p)), NeQ(n, j), IntegerQ(Simplify(Times(j, Power(n, CN1)))), NeQ(m, CN1), IntegerQ(Simplify(Times(n, Power(Plus(m, C1), CN1)))), Not(IntegerQ(n)))));
            IIntegrate(2027, Int(Times(Power(Times(c_, x_), m_DEFAULT), Power(Plus(Times(a_DEFAULT, Power(x_, j_DEFAULT)), Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(c, IntPart(m)), Power(Times(c, x), FracPart(m)), Power(Power(x, FracPart(m)), CN1)), Int(Times(Power(x, m), Power(Plus(Times(a, Power(x, j)), Times(b, Power(x, n))), p)), x), x), And(FreeQ(List(a, b, c, j, m, n, p), x), Not(IntegerQ(p)), NeQ(n, j), IntegerQ(Simplify(Times(j, Power(n, CN1)))), NeQ(m, CN1), IntegerQ(Simplify(Times(n, Power(Plus(m, C1), CN1)))), Not(IntegerQ(n)))));
            IIntegrate(2028, Int(Times(Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus(Times(a_DEFAULT, Power(x_, j_DEFAULT)), Times(b_DEFAULT, Power(x_, n_DEFAULT))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(c, x), Plus(m, C1)), Power(Plus(Times(a, Power(x, j)), Times(b, Power(x, n))), p), Power(Times(c, p, Subtract(n, j)), CN1)), x), Dist(Times(a, Power(Power(c, j), CN1)), Int(Times(Power(Times(c, x), Plus(m, j)), Power(Plus(Times(a, Power(x, j)), Times(b, Power(x, n))), Subtract(p, C1))), x), x)), And(FreeQ(List(a, b, c, j, m, n), x), IGtQ(Plus(p, C1D2), C0), NeQ(n, j), EqQ(Simplify(Plus(m, Times(j, p), C1)), C0), Or(IntegerQ(j), GtQ(c, C0)))));
            IIntegrate(2029, Int(Times(Power(x_, m_DEFAULT), Power(Plus(Times(a_DEFAULT, Power(x_, j_DEFAULT)), Times(b_DEFAULT, Power(x_, n_DEFAULT))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(CN2, Power(Subtract(n, j), CN1)), Subst(Int(Power(Subtract(C1, Times(a, Sqr(x))), CN1), x), x, Times(Power(x, Times(C1D2, j)), Power(Plus(Times(a, Power(x, j)), Times(b, Power(x, n))), CN1D2))), x), And(FreeQ(List(a, b, j, n), x), EqQ(m, Subtract(Times(C1D2, j), C1)), NeQ(n, j))));
            IIntegrate(2030, Int(Times(Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus(Times(a_DEFAULT, Power(x_, j_DEFAULT)), Times(b_DEFAULT, Power(x_, n_DEFAULT))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(c, Subtract(j, C1)), Power(Times(c, x), Plus(m, Negate(j), C1)), Power(Plus(Times(a, Power(x, j)), Times(b, Power(x, n))), Plus(p, C1)), Power(Times(a, Subtract(n, j), Plus(p, C1)), CN1)), x)), Dist(Times(Power(c, j), Plus(m, Times(n, p), n, Negate(j), C1), Power(Times(a, Subtract(n, j), Plus(p, C1)), CN1)), Int(Times(Power(Times(c, x), Subtract(m, j)), Power(Plus(Times(a, Power(x, j)), Times(b, Power(x, n))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, c, j, m, n), x), ILtQ(Plus(p, C1D2), C0), NeQ(n, j), EqQ(Simplify(Plus(m, Times(j, p), C1)), C0), Or(IntegerQ(j), GtQ(c, C0)))));
            IIntegrate(2031, Int(Times(Power(Times(c_, x_), m_DEFAULT), Power(Plus(Times(a_DEFAULT, Power(x_, j_DEFAULT)), Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(c, IntPart(m)), Power(Times(c, x), FracPart(m)), Power(Power(x, FracPart(m)), CN1)), Int(Times(Power(x, m), Power(Plus(Times(a, Power(x, j)), Times(b, Power(x, n))), p)), x), x), And(FreeQ(List(a, b, c, j, m, n, p), x), IntegerQ(Plus(p, C1D2)), NeQ(n, j), EqQ(Simplify(Plus(m, Times(j, p), C1)), C0))));
            IIntegrate(2032, Int(Times(Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus(Times(a_DEFAULT, Power(x_, j_DEFAULT)), Times(b_DEFAULT, Power(x_, n_DEFAULT))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(c, IntPart(m)), Power(Times(c, x), FracPart(m)), Power(Plus(Times(a, Power(x, j)), Times(b, Power(x, n))), FracPart(p)), Power(Times(Power(x, Plus(FracPart(m), Times(j, FracPart(p)))), Power(Plus(a, Times(b, Power(x, Subtract(n, j)))), FracPart(p))), CN1)), Int(Times(Power(x, Plus(m, Times(j, p))), Power(Plus(a, Times(b, Power(x, Subtract(n, j)))), p)), x), x), And(FreeQ(List(a, b, c, j, m, n, p), x), Not(IntegerQ(p)), NeQ(n, j), PosQ(Subtract(n, j)))));
            IIntegrate(2033, Int(Times(Power(u_, m_DEFAULT), Power(Plus(Times(a_DEFAULT, Power(v_, j_DEFAULT)), Times(b_DEFAULT, Power(v_, n_DEFAULT))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(u, m), Power(Times(Coefficient(v, x, C1), Power(v, m)), CN1)), Subst(Int(Times(Power(x, m), Power(Plus(Times(a, Power(x, j)), Times(b, Power(x, n))), p)), x), x, v), x), And(FreeQ(List(a, b, j, m, n, p), x), LinearPairQ(u, v, x))));
            IIntegrate(2034, Int(Times(Power(x_, m_DEFAULT), Power(Plus(Times(b_DEFAULT, Power(x_, k_DEFAULT)), Times(a_DEFAULT, Power(x_, j_))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(n, CN1), Subst(Int(Times(Power(x, Subtract(Simplify(Times(Plus(m, C1), Power(n, CN1))), C1)), Power(Plus(Times(a, Power(x, Simplify(Times(j, Power(n, CN1))))), Times(b, Power(x, Simplify(Times(k, Power(n, CN1)))))), p), Power(Plus(c, Times(d, x)), q)), x), x, Power(x, n)), x), And(FreeQ(List(a, b, c, d, j, k, m, n, p, q), x), Not(IntegerQ(p)), NeQ(k, j), IntegerQ(Simplify(Times(j, Power(n, CN1)))), IntegerQ(Simplify(Times(k, Power(n, CN1)))), IntegerQ(Simplify(Times(Plus(m, C1), Power(n, CN1)))), NeQ(Sqr(n), C1))));
            IIntegrate(2035, Int(Times(Power(Times(e_, x_), m_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_DEFAULT))), q_DEFAULT), Power(Plus(Times(b_DEFAULT, Power(x_, k_DEFAULT)), Times(a_DEFAULT, Power(x_, j_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(e, IntPart(m)), Power(Times(e, x), FracPart(m)), Power(Power(x, FracPart(m)), CN1)), Int(Times(Power(x, m), Power(Plus(Times(a, Power(x, j)), Times(b, Power(x, k))), p), Power(Plus(c, Times(d, Power(x, n))), q)), x), x), And(FreeQ(List(a, b, c, d, e, j, k, m, n, p, q), x), Not(IntegerQ(p)), NeQ(k, j), IntegerQ(Simplify(Times(j, Power(n, CN1)))), IntegerQ(Simplify(Times(k, Power(n, CN1)))), IntegerQ(Simplify(Times(Plus(m, C1), Power(n, CN1)))), NeQ(Sqr(n), C1))));
            IIntegrate(2036, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Plus(Times(a_DEFAULT, Power(x_, j_DEFAULT)), Times(b_DEFAULT, Power(x_, $p("jn", true)))), p_), Plus(c_, Times(d_DEFAULT, Power(x_, n_DEFAULT)))), x_Symbol),
                    Condition(Simp(Times(c, Power(e, Subtract(j, C1)), Power(Times(e, x), Plus(m, Negate(j), C1)), Power(Plus(Times(a, Power(x, j)), Times(b, Power(x, Plus(j, n)))), Plus(p, C1)), Power(Times(a, Plus(m, Times(j, p), C1)), CN1)), x), And(FreeQ(List(a, b, c, d, e, j, m, n, p), x), EqQ($s("jn"), Plus(j, n)), Not(IntegerQ(p)), NeQ(Subtract(Times(b, c), Times(a, d)), C0), EqQ(Subtract(Times(a, d, Plus(m, Times(j, p), C1)), Times(b, c, Plus(m, n, Times(p, Plus(j, n)), C1))), C0), Or(GtQ(e, C0), IntegersQ(j)), NeQ(Plus(m, Times(j, p), C1), C0))));
            IIntegrate(2037, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Plus(Times(a_DEFAULT, Power(x_, j_DEFAULT)), Times(b_DEFAULT, Power(x_, $p("jn", true)))), p_), Plus(c_, Times(d_DEFAULT, Power(x_, n_DEFAULT)))), x_Symbol),
                    Condition(Subtract(Negate(Simp(Times(Power(e, Subtract(j, C1)), Subtract(Times(b, c), Times(a, d)), Power(Times(e, x), Plus(m, Negate(j), C1)), Power(Plus(Times(a, Power(x, j)), Times(b, Power(x, Plus(j, n)))), Plus(p, C1)), Power(Times(a, b, n, Plus(p, C1)), CN1)), x)), Dist(Times(Power(e, j), Subtract(Times(a, d, Plus(m, Times(j, p), C1)), Times(b, c, Plus(m, n, Times(p, Plus(j, n)), C1))), Power(Times(a, b, n, Plus(p, C1)), CN1)), Int(Times(Power(Times(e, x), Subtract(m, j)), Power(Plus(Times(a, Power(x, j)), Times(b, Power(x, Plus(j, n)))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, j, m, n), x), EqQ($s("jn"), Plus(j, n)), Not(IntegerQ(p)), NeQ(Subtract(Times(b, c), Times(a, d)), C0), LtQ(p, CN1), GtQ(j, C0), LeQ(j, m), Or(GtQ(e, C0), IntegerQ(j)))));
            IIntegrate(2038, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Plus(Times(a_DEFAULT, Power(x_, j_DEFAULT)), Times(b_DEFAULT, Power(x_, $p("jn", true)))), p_), Plus(c_, Times(d_DEFAULT, Power(x_, n_DEFAULT)))), x_Symbol),
                    Condition(Plus(Simp(Times(c, Power(e, Subtract(j, C1)), Power(Times(e, x), Plus(m, Negate(j), C1)), Power(Plus(Times(a, Power(x, j)), Times(b, Power(x, Plus(j, n)))), Plus(p, C1)), Power(Times(a, Plus(m, Times(j, p), C1)), CN1)), x), Dist(Times(Subtract(Times(a, d, Plus(m, Times(j, p), C1)), Times(b, c, Plus(m, n, Times(p, Plus(j, n)), C1))), Power(Times(a, Power(e, n), Plus(m, Times(j, p), C1)), CN1)), Int(Times(Power(Times(e, x), Plus(m, n)), Power(Plus(Times(a, Power(x, j)), Times(b, Power(x, Plus(j, n)))), p)), x), x)), And(FreeQ(List(a, b, c, d, e, j, p), x), EqQ($s("jn"), Plus(j, n)), Not(IntegerQ(p)), NeQ(Subtract(Times(b, c), Times(a, d)), C0), GtQ(n, C0), Or(LtQ(Plus(m, Times(j, p)), CN1), And(IntegersQ(Subtract(m, C1D2), Subtract(p, C1D2)), LtQ(p, C0), LtQ(m, Subtract(Times(CN1, n, p), C1)))), Or(GtQ(e, C0), IntegersQ(j, n)), NeQ(Plus(m, Times(j, p), C1), C0), NeQ(Plus(m, Negate(n), Times(j, p), C1), C0))));
            IIntegrate(2039, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Plus(Times(a_DEFAULT, Power(x_, j_DEFAULT)), Times(b_DEFAULT, Power(x_, $p("jn", true)))), p_), Plus(c_, Times(d_DEFAULT, Power(x_, n_DEFAULT)))), x_Symbol),
                    Condition(Subtract(Simp(Times(d, Power(e, Subtract(j, C1)), Power(Times(e, x), Plus(m, Negate(j), C1)), Power(Plus(Times(a, Power(x, j)), Times(b, Power(x, Plus(j, n)))), Plus(p, C1)), Power(Times(b, Plus(m, n, Times(p, Plus(j, n)), C1)), CN1)), x), Dist(Times(Subtract(Times(a, d, Plus(m, Times(j, p), C1)), Times(b, c, Plus(m, n, Times(p, Plus(j, n)), C1))), Power(Times(b, Plus(m, n, Times(p, Plus(j, n)), C1)), CN1)), Int(Times(Power(Times(e, x), m), Power(Plus(Times(a, Power(x, j)), Times(b, Power(x, Plus(j, n)))), p)), x), x)), And(FreeQ(List(a, b, c, d, e, j, m, n, p), x), EqQ($s("jn"), Plus(j, n)), Not(IntegerQ(p)), NeQ(Subtract(Times(b, c), Times(a, d)), C0), NeQ(Plus(m, n, Times(p, Plus(j, n)), C1), C0), Or(GtQ(e, C0), IntegerQ(j)))));
            IIntegrate(2040, Int(Times(Power(x_, m_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_DEFAULT))), q_DEFAULT), Power(Plus(Times(b_DEFAULT, Power(x_, k_DEFAULT)), Times(a_DEFAULT, Power(x_, j_))), p_)), x_Symbol),
                    Condition(Dist(Power(Plus(m, C1), CN1), Subst(Int(Times(Power(Plus(Times(a, Power(x, Simplify(Times(j, Power(Plus(m, C1), CN1))))), Times(b, Power(x, Simplify(Times(k, Power(Plus(m, C1), CN1)))))), p), Power(Plus(c, Times(d, Power(x, Simplify(Times(n, Power(Plus(m, C1), CN1)))))), q)), x), x, Power(x, Plus(m, C1))), x), And(FreeQ(List(a, b, c, d, j, k, m, n, p, q), x), Not(IntegerQ(p)), NeQ(k, j), IntegerQ(Simplify(Times(j, Power(n, CN1)))), IntegerQ(Simplify(Times(k, Power(n, CN1)))), NeQ(m, CN1), IntegerQ(Simplify(Times(n, Power(Plus(m, C1), CN1)))), Not(IntegerQ(n)))));
            IIntegrate(2041, Int(Times(Power(Times(e_, x_), m_DEFAULT), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_DEFAULT))), q_DEFAULT), Power(Plus(Times(b_DEFAULT, Power(x_, k_DEFAULT)), Times(a_DEFAULT, Power(x_, j_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(e, IntPart(m)), Power(Times(e, x), FracPart(m)), Power(Power(x, FracPart(m)), CN1)), Int(Times(Power(x, m), Power(Plus(Times(a, Power(x, j)), Times(b, Power(x, k))), p), Power(Plus(c, Times(d, Power(x, n))), q)), x), x), And(FreeQ(List(a, b, c, d, e, j, k, m, n, p, q), x), Not(IntegerQ(p)), NeQ(k, j), IntegerQ(Simplify(Times(j, Power(n, CN1)))), IntegerQ(Simplify(Times(k, Power(n, CN1)))), NeQ(m, CN1), IntegerQ(Simplify(Times(n, Power(Plus(m, C1), CN1)))), Not(IntegerQ(n)))));
            IIntegrate(2042, Int(Times(Power(Times(e_DEFAULT, x_), m_DEFAULT), Power(Plus(Times(a_DEFAULT, Power(x_, j_DEFAULT)), Times(b_DEFAULT, Power(x_, $p("jn", true)))), p_), Power(Plus(c_, Times(d_DEFAULT, Power(x_, n_DEFAULT))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(e, IntPart(m)), Power(Times(e, x), FracPart(m)), Power(Plus(Times(a, Power(x, j)), Times(b, Power(x, Plus(j, n)))), FracPart(p)), Power(Times(Power(x, Plus(FracPart(m), Times(j, FracPart(p)))), Power(Plus(a, Times(b, Power(x, n))), FracPart(p))), CN1)), Int(Times(Power(x, Plus(m, Times(j, p))), Power(Plus(a, Times(b, Power(x, n))), p), Power(Plus(c, Times(d, Power(x, n))), q)), x), x), And(FreeQ(List(a, b, c, d, e, j, m, n, p, q), x), EqQ($s("jn"), Plus(j, n)), Not(IntegerQ(p)), NeQ(Subtract(Times(b, c), Times(a, d)), C0), Not(And(EqQ(n, C1), EqQ(j, C1))))));
            IIntegrate(2043, Int(Times($p("§pq"), Power(Plus(Times(a_DEFAULT, Power(x_, j_DEFAULT)), Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(With(List(Set(d, Denominator(n))), Dist(d, Subst(Int(Times(Power(x, Subtract(d, C1)), ReplaceAll(SubstFor(Power(x, n), $s("§pq"), x), Rule(x, Power(x, Times(d, n)))), Power(Plus(Times(a, Power(x, Times(d, j))), Times(b, Power(x, Times(d, n)))), p)), x), x, Power(x, Power(d, CN1))), x)), And(FreeQ(List(a, b, j, n, p), x), PolyQ($s("§pq"), Power(x, n)), Not(IntegerQ(p)), NeQ(n, j), RationalQ(j, n), IntegerQ(Times(j, Power(n, CN1))), LtQ(CN1, n, C1))));
            IIntegrate(2044, Int(Times($p("§pq"), Power(x_, m_DEFAULT), Power(Plus(Times(a_DEFAULT, Power(x_, j_DEFAULT)), Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Power(n, CN1), Subst(Int(Times(Power(x, Subtract(Simplify(Times(Plus(m, C1), Power(n, CN1))), C1)), SubstFor(Power(x, n), $s("§pq"), x), Power(Plus(Times(a, Power(x, Simplify(Times(j, Power(n, CN1))))), Times(b, x)), p)), x), x, Power(x, n)), x), And(FreeQ(List(a, b, j, m, n, p), x), PolyQ($s("§pq"), Power(x, n)), Not(IntegerQ(p)), NeQ(n, j), IntegerQ(Simplify(Times(j, Power(n, CN1)))), IntegerQ(Simplify(Times(Plus(m, C1), Power(n, CN1)))))));
            IIntegrate(2045, Int(Times($p("§pq"), Power(Times(c_, x_), m_DEFAULT), Power(Plus(Times(a_DEFAULT, Power(x_, j_DEFAULT)), Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(c, Times(Sign(m), Quotient(m, Sign(m)))), Power(Times(c, x), Mod(m, Sign(m))), Power(Power(x, Mod(m, Sign(m))), CN1)), Int(Times(Power(x, m), $s("§pq"), Power(Plus(Times(a, Power(x, j)), Times(b, Power(x, n))), p)), x), x), And(FreeQ(List(a, b, c, j, n, p), x), PolyQ($s("§pq"), Power(x, n)), Not(IntegerQ(p)), NeQ(n, j), IntegerQ(Simplify(Times(j, Power(n, CN1)))), IntegerQ(Simplify(Times(Plus(m, C1), Power(n, CN1)))), RationalQ(m), GtQ(Sqr(m), C1))));
            IIntegrate(2046, Int(Times($p("§pq"), Power(Times(c_, x_), m_DEFAULT), Power(Plus(Times(a_DEFAULT, Power(x_, j_DEFAULT)), Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Times(c, x), m), Power(Power(x, m), CN1)), Int(Times(Power(x, m), $s("§pq"), Power(Plus(Times(a, Power(x, j)), Times(b, Power(x, n))), p)), x), x), And(FreeQ(List(a, b, c, j, m, n, p), x), PolyQ($s("§pq"), Power(x, n)), Not(IntegerQ(p)), NeQ(n, j), IntegerQ(Simplify(Times(j, Power(n, CN1)))), IntegerQ(Simplify(Times(Plus(m, C1), Power(n, CN1)))))));
            IIntegrate(2047, Int(Times($p("§pq"), Power(x_, m_DEFAULT), Power(Plus(Times(a_DEFAULT, Power(x_, j_DEFAULT)), Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(With(List(Set(g, GCD(Plus(m, C1), n))), Condition(Dist(Power(g, CN1), Subst(Int(Times(Power(x, Subtract(Times(Plus(m, C1), Power(g, CN1)), C1)), ReplaceAll($s("§pq"), Rule(x, Power(x, Power(g, CN1)))), Power(Plus(Times(a, Power(x, Times(j, Power(g, CN1)))), Times(b, Power(x, Times(n, Power(g, CN1))))), p)), x), x, Power(x, g)), x), NeQ(g, C1))), And(FreeQ(List(a, b, p), x), PolyQ($s("§pq"), Power(x, n)), Not(IntegerQ(p)), IGtQ(j, C0), IGtQ(n, C0), IGtQ(Times(j, Power(n, CN1)), C0), IntegerQ(m))));
            IIntegrate(2048, Int(Times($p("§pq"), Power(Times(c_DEFAULT, x_), m_DEFAULT), Power(Plus(Times(a_DEFAULT, Power(x_, j_DEFAULT)), Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(With(List(Set(q, Expon($s("§pq"), x))), Condition(With(List(Set($s("§pqq"), Coeff($s("§pq"), x, q))), Plus(Int(Times(Power(Times(c, x), m), ExpandToSum(Subtract(Subtract($s("§pq"), Times($s("§pqq"), Power(x, q))), Times(a, $s("§pqq"), Plus(m, q, Negate(n), C1), Power(x, Subtract(q, n)), Power(Times(b, Plus(m, q, Times(n, p), C1)), CN1))), x), Power(Plus(Times(a, Power(x, j)), Times(b, Power(x, n))), p)), x), Simp(Times($s("§pqq"), Power(Times(c, x), Plus(m, q, Negate(n), C1)), Power(Plus(Times(a, Power(x, j)), Times(b, Power(x, n))), Plus(p, C1)), Power(Times(b, Power(c, Plus(q, Negate(n), C1)), Plus(m, q, Times(n, p), C1)), CN1)), x))), And(GtQ(q, Subtract(n, C1)), NeQ(Plus(m, q, Times(n, p), C1), C0), Or(IntegerQ(Times(C2, p)), IntegerQ(Plus(p, Times(Plus(q, C1), Power(Times(C2, n), CN1)))))))), And(FreeQ(List(a, b, c, m, p), x), PolyQ($s("§pq"), x), Not(IntegerQ(p)), IGtQ(j, C0), IGtQ(n, C0), LtQ(j, n))));
            IIntegrate(2049, Int(Times($p("§pq"), Power(x_, m_DEFAULT), Power(Plus(Times(a_DEFAULT, Power(x_, j_DEFAULT)), Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Power(Plus(m, C1), CN1), Subst(Int(Times(ReplaceAll(SubstFor(Power(x, n), $s("§pq"), x), Rule(x, Power(x, Simplify(Times(n, Power(Plus(m, C1), CN1)))))), Power(Plus(Times(a, Power(x, Simplify(Times(j, Power(Plus(m, C1), CN1))))), Times(b, Power(x, Simplify(Times(n, Power(Plus(m, C1), CN1)))))), p)), x), x, Power(x, Plus(m, C1))), x), And(FreeQ(List(a, b, j, m, n, p), x), PolyQ($s("§pq"), Power(x, n)), Not(IntegerQ(p)), NeQ(n, j), IntegerQ(Simplify(Times(j, Power(n, CN1)))), IntegerQ(Simplify(Times(n, Power(Plus(m, C1), CN1)))), Not(IntegerQ(n)))));
            IIntegrate(2050, Int(Times($p("§pq"), Power(Times(c_, x_), m_), Power(Plus(Times(a_DEFAULT, Power(x_, j_DEFAULT)), Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(c, Times(Sign(m), Quotient(m, Sign(m)))), Power(Times(c, x), Mod(m, Sign(m))), Power(Power(x, Mod(m, Sign(m))), CN1)), Int(Times(Power(x, m), $s("§pq"), Power(Plus(Times(a, Power(x, j)), Times(b, Power(x, n))), p)), x), x), And(FreeQ(List(a, b, c, j, n, p), x), PolyQ($s("§pq"), Power(x, n)), Not(IntegerQ(p)), NeQ(n, j), IntegerQ(Simplify(Times(j, Power(n, CN1)))), IntegerQ(Simplify(Times(n, Power(Plus(m, C1), CN1)))), Not(IntegerQ(n)), GtQ(Sqr(m), C1))));
        }
    }
}
