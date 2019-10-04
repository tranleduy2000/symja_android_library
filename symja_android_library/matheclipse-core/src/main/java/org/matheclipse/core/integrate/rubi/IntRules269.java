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
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Part;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.ReplaceAll;
import static org.matheclipse.core.expression.F.Rule;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Simplify;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Sum;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.Together;
import static org.matheclipse.core.expression.F.UnsameQ;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.a_DEFAULT;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_DEFAULT;
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
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.u_DEFAULT;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.AlgebraicFunctionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EulerIntegrandQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FalseQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfLinear;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfSquareRootOfQuadratic;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NonsumQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NormalizeIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PolynomialInQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PolynomialInSubst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PowerVariableExpn;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalFunctionExpand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalFunctionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SubstForFractionalPowerOfLinear;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumQ;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules269 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(6725, Int(Times(u_, Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT)), Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Times(Power(C4, p), Power(c, p)), CN1), Int(Times(u, Power(Plus(b, Times(C2, c, Power(x, n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, n), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(p), Not(AlgebraicFunctionQ(u, x)))));
            IIntegrate(6726, Int(Times(u_, Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT)), Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p), Power(Power(Plus(b, Times(C2, c, Power(x, n))), Times(C2, p)), CN1)), Int(Times(u, Power(Plus(b, Times(C2, c, Power(x, n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, n, p), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(p)), Not(AlgebraicFunctionQ(u, x)))));
            IIntegrate(6727, Int(Times(u_, Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_DEFAULT)), Times(c_DEFAULT, Power(x_, $p("n2", true)))), CN1)), x_Symbol),
                    Condition(With(List(Set(v, RationalFunctionExpand(Times(u, Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), CN1)), x))), Condition(Int(v, x), SumQ(v))), And(FreeQ(List(a, b, c), x), EqQ($s("n2"), Times(C2, n)), IGtQ(n, C0))));
            IIntegrate(6728, Int(Times(u_DEFAULT, Power(Plus(Times(a_DEFAULT, Power(x_, m_DEFAULT)), Times(b_DEFAULT, Sqrt(Times(c_DEFAULT, Power(x_, n_))))), CN1)), x_Symbol),
                    Condition(Int(Times(u, Subtract(Times(a, Power(x, m)), Times(b, Sqrt(Times(c, Power(x, n))))), Power(Subtract(Times(Sqr(a), Power(x, Times(C2, m))), Times(Sqr(b), c, Power(x, n))), CN1)), x), FreeQ(List(a, b, c, m, n), x)));
            IIntegrate(6729, Int(u_, x_Symbol),
                    With(List(Set($s("lst"), FunctionOfLinear(u, x))), Condition(Dist(Power(Part($s("lst"), C3), CN1), Subst(Int(Part($s("lst"), C1), x), x, Plus(Part($s("lst"), C2), Times(Part($s("lst"), C3), x))), x), Not(FalseQ($s("lst"))))));
            IIntegrate(6730, Int(Times(u_, Power(x_, CN1)), x_Symbol),
                    Condition(With(List(Set($s("lst"), PowerVariableExpn(u, C0, x))), Condition(Dist(Power(Part($s("lst"), C2), CN1), Subst(Int(NormalizeIntegrand(Simplify(Times(Part($s("lst"), C1), Power(x, CN1))), x), x), x, Power(Times(Part($s("lst"), C3), x), Part($s("lst"), C2))), x), And(Not(FalseQ($s("lst"))), NeQ(Part($s("lst"), C2), C0)))), And(NonsumQ(u), Not(RationalFunctionQ(u, x)))));
            IIntegrate(6731, Int(Times(u_, Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set($s("lst"), PowerVariableExpn(u, Plus(m, C1), x))), Condition(Dist(Power(Part($s("lst"), C2), CN1), Subst(Int(NormalizeIntegrand(Simplify(Times(Part($s("lst"), C1), Power(x, CN1))), x), x), x, Power(Times(Part($s("lst"), C3), x), Part($s("lst"), C2))), x), And(Not(FalseQ($s("lst"))), NeQ(Part($s("lst"), C2), Plus(m, C1))))), And(IntegerQ(m), NeQ(m, CN1), NonsumQ(u), Or(GtQ(m, C0), Not(AlgebraicFunctionQ(u, x))))));
            IIntegrate(6732, Int(Times(u_, Power(x_, m_)), x_Symbol),
                    Condition(With(List(Set(k, Denominator(m))), Dist(k, Subst(Int(Times(Power(x, Subtract(Times(k, Plus(m, C1)), C1)), ReplaceAll(u, Rule(x, Power(x, k)))), x), x, Power(x, Power(k, CN1))), x)), FractionQ(m)));
            IIntegrate(6733, Int(u_, x_Symbol),
                    Condition(With(List(Set($s("lst"), FunctionOfSquareRootOfQuadratic(u, x))), Condition(Dist(C2, Subst(Int(Part($s("lst"), C1), x), x, Part($s("lst"), C2)), x), And(Not(FalseQ($s("lst"))), EqQ(Part($s("lst"), C3), C1)))), EulerIntegrandQ(u, x)));
            IIntegrate(6734, Int(u_, x_Symbol),
                    Condition(With(List(Set($s("lst"), FunctionOfSquareRootOfQuadratic(u, x))), Condition(Dist(C2, Subst(Int(Part($s("lst"), C1), x), x, Part($s("lst"), C2)), x), And(Not(FalseQ($s("lst"))), EqQ(Part($s("lst"), C3), C2)))), EulerIntegrandQ(u, x)));
            IIntegrate(6735, Int(u_, x_Symbol),
                    Condition(With(List(Set($s("lst"), FunctionOfSquareRootOfQuadratic(u, x))), Condition(Dist(C2, Subst(Int(Part($s("lst"), C1), x), x, Part($s("lst"), C2)), x), And(Not(FalseQ($s("lst"))), EqQ(Part($s("lst"), C3), C3)))), EulerIntegrandQ(u, x)));
            IIntegrate(6736, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr(v_))), CN1), x_Symbol),
                    Condition(Plus(Dist(Power(Times(C2, a), CN1), Int(Together(Power(Subtract(C1, Times(v, Power(Rt(Times(CN1, a, Power(b, CN1)), C2), CN1))), CN1)), x), x), Dist(Power(Times(C2, a), CN1), Int(Together(Power(Plus(C1, Times(v, Power(Rt(Times(CN1, a, Power(b, CN1)), C2), CN1))), CN1)), x), x)), FreeQ(List(a, b), x)));
            IIntegrate(6737, Int(Power(Plus(a_, Times(b_DEFAULT, Power(v_, n_))), CN1), x_Symbol),
                    Condition(Dist(Times(C2, Power(Times(a, n), CN1)), Sum(Int(Together(Power(Subtract(C1, Times(Sqr(v), Power(Times(Power(CN1, Times(C4, k, Power(n, CN1))), Rt(Times(CN1, a, Power(b, CN1)), Times(C1D2, n))), CN1))), CN1)), x), List(k, C1, Times(C1D2, n))), x), And(FreeQ(List(a, b), x), IGtQ(Times(C1D2, n), C1))));
            IIntegrate(6738, Int(Power(Plus(a_, Times(b_DEFAULT, Power(v_, n_))), CN1), x_Symbol),
                    Condition(Dist(Power(Times(a, n), CN1), Sum(Int(Together(Power(Subtract(C1, Times(v, Power(Times(Power(CN1, Times(C2, k, Power(n, CN1))), Rt(Times(CN1, a, Power(b, CN1)), n)), CN1))), CN1)), x), List(k, C1, n)), x), And(FreeQ(List(a, b), x), IGtQ(Times(C1D2, Subtract(n, C1)), C0))));
            IIntegrate(6739, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(u_, n_DEFAULT))), CN1), v_), x_Symbol),
                    Condition(Int(ReplaceAll(ExpandIntegrand(Times(PolynomialInSubst(v, u, x), Power(Plus(a, Times(b, Power(x, n))), CN1)), x), Rule(x, u)), x), And(FreeQ(List(a, b), x), IGtQ(n, C0), PolynomialInQ(v, u, x))));
            IIntegrate(6740, Int(u_, x_Symbol),
                    With(List(Set(v, NormalizeIntegrand(u, x))), Condition(Int(v, x), UnsameQ(v, u))));
            IIntegrate(6741, Int(u_, x_Symbol),
                    With(List(Set(v, ExpandIntegrand(u, x))), Condition(Int(v, x), SumQ(v))));
            IIntegrate(6742, Int(Times(u_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, m_DEFAULT))), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, Power(x_, n_DEFAULT))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Power(x, m))), p), Power(Plus(c, Times(d, Power(x, n))), q), Power(Power(x, Times(m, p)), CN1)), Int(Times(u, Power(x, Times(m, p))), x), x), And(FreeQ(List(a, b, c, d, m, n, p, q), x), EqQ(Plus(a, d), C0), EqQ(Plus(b, c), C0), EqQ(Plus(m, n), C0), EqQ(Plus(p, q), C0))));
            IIntegrate(6743, Int(Times(u_, Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_DEFAULT)), Times(c_DEFAULT, Power(x_, $p("n2", true)))), p_)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n))))), Power(Times(Power(Times(C4, c), Subtract(p, C1D2)), Plus(b, Times(C2, c, Power(x, n)))), CN1)), Int(Times(u, Power(Plus(b, Times(C2, c, Power(x, n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, n, p), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(Subtract(p, C1D2)))));
            IIntegrate(6744, Int(u_, x_Symbol),
                    With(List(Set($s("lst"), SubstForFractionalPowerOfLinear(u, x))), Condition(Dist(Times(Part($s("lst"), C2), Part($s("lst"), C4)), Subst(Int(Part($s("lst"), C1), x), x, Power(Part($s("lst"), C3), Power(Part($s("lst"), C2), CN1))), x), Not(FalseQ($s("lst"))))));
        }

        ;
    }
}
