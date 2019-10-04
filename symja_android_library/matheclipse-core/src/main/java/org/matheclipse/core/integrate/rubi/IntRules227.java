package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcCosh;
import static org.matheclipse.core.expression.F.ArcSinh;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cosh;
import static org.matheclipse.core.expression.F.Csch;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.QQ;
import static org.matheclipse.core.expression.F.Sech;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sinh;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_DEFAULT;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntHide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules227 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(5676, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCosh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Plus($p("d1"), Times($p("e1", true), x_)), CN1D2), Power(Plus($p("d2"), Times($p("e2", true), x_)), CN1D2)), x_Symbol),
                    Condition(Simp(Times(Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), Plus(n, C1)), Power(Times(b, c, Sqrt(Times(CN1, $s("d1"), $s("d2"))), Plus(n, C1)), CN1)), x), And(FreeQ(List(a, b, c, $s("d1"), $s("e1"), $s("d2"), $s("e2"), n), x), EqQ($s("e1"), Times(c, $s("d1"))), EqQ($s("e2"), Times(CN1, c, $s("d2"))), GtQ($s("d1"), C0), LtQ($s("d2"), C0), NeQ(n, CN1))));
            IIntegrate(5677, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSinh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Plus(C1, Times(Sqr(c), Sqr(x)))), Power(Plus(d, Times(e, Sqr(x))), CN1D2)), Int(Times(Power(Plus(a, Times(b, ArcSinh(Times(c, x)))), n), Power(Plus(C1, Times(Sqr(c), Sqr(x))), CN1D2)), x), x), And(FreeQ(List(a, b, c, d, e, n), x), EqQ(e, Times(Sqr(c), d)), Not(GtQ(d, C0)))));
            IIntegrate(5678, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCosh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Plus($p("d1"), Times($p("e1", true), x_)), CN1D2), Power(Plus($p("d2"), Times($p("e2", true), x_)), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Plus(C1, Times(c, x))), Sqrt(Plus(CN1, Times(c, x))), Power(Times(Sqrt(Plus($s("d1"), Times($s("e1"), x))), Sqrt(Plus($s("d2"), Times($s("e2"), x)))), CN1)), Int(Times(Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), n), Power(Times(Sqrt(Plus(C1, Times(c, x))), Sqrt(Plus(CN1, Times(c, x)))), CN1)), x), x), And(FreeQ(List(a, b, c, $s("d1"), $s("e1"), $s("d2"), $s("e2"), n), x), EqQ($s("e1"), Times(c, $s("d1"))), EqQ($s("e2"), Times(CN1, c, $s("d2"))), Not(And(GtQ($s("d1"), C0), LtQ($s("d2"), C0))))));
            IIntegrate(5679, Int(Times(Plus(a_DEFAULT, Times(ArcSinh(Times(c_DEFAULT, x_)), b_DEFAULT)), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Power(Plus(d, Times(e, Sqr(x))), p), x))), Subtract(Dist(Plus(a, Times(b, ArcSinh(Times(c, x)))), u, x), Dist(Times(b, c), Int(SimplifyIntegrand(Times(u, Power(Plus(C1, Times(Sqr(c), Sqr(x))), CN1D2)), x), x), x))), And(FreeQ(List(a, b, c, d, e), x), EqQ(e, Times(Sqr(c), d)), IGtQ(p, C0))));
            IIntegrate(5680, Int(Times(Plus(a_DEFAULT, Times(ArcCosh(Times(c_DEFAULT, x_)), b_DEFAULT)), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(u, IntHide(Power(Plus(d, Times(e, Sqr(x))), p), x))), Subtract(Dist(Plus(a, Times(b, ArcCosh(Times(c, x)))), u, x), Dist(Times(b, c), Int(SimplifyIntegrand(Times(u, Power(Times(Sqrt(Plus(C1, Times(c, x))), Sqrt(Plus(CN1, Times(c, x)))), CN1)), x), x), x))), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), IGtQ(p, C0))));
            IIntegrate(5681, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCosh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(x, Power(Plus(d, Times(e, Sqr(x))), p), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), n), Power(Plus(Times(C2, p), C1), CN1)), x), Negate(Dist(Times(b, c, n, Power(Negate(d), p), Power(Plus(Times(C2, p), C1), CN1)), Int(Times(x, Power(Plus(CN1, Times(c, x)), Subtract(p, C1D2)), Power(Plus(C1, Times(c, x)), Subtract(p, C1D2)), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), Subtract(n, C1))), x), x)), Dist(Times(C2, d, p, Power(Plus(Times(C2, p), C1), CN1)), Int(Times(Power(Plus(d, Times(e, Sqr(x))), Subtract(p, C1)), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), n)), x), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), GtQ(n, C0), GtQ(p, C0), IntegerQ(p))));
            IIntegrate(5682, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSinh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Sqrt(Plus(d_, Times(e_DEFAULT, Sqr(x_))))), x_Symbol),
                    Condition(Plus(Simp(Times(C1D2, x, Sqrt(Plus(d, Times(e, Sqr(x)))), Power(Plus(a, Times(b, ArcSinh(Times(c, x)))), n)), x), Dist(Times(Sqrt(Plus(d, Times(e, Sqr(x)))), Power(Times(C2, Sqrt(Plus(C1, Times(Sqr(c), Sqr(x))))), CN1)), Int(Times(Power(Plus(a, Times(b, ArcSinh(Times(c, x)))), n), Power(Plus(C1, Times(Sqr(c), Sqr(x))), CN1D2)), x), x), Negate(Dist(Times(b, c, n, Sqrt(Plus(d, Times(e, Sqr(x)))), Power(Times(C2, Sqrt(Plus(C1, Times(Sqr(c), Sqr(x))))), CN1)), Int(Times(x, Power(Plus(a, Times(b, ArcSinh(Times(c, x)))), Subtract(n, C1))), x), x))), And(FreeQ(List(a, b, c, d, e), x), EqQ(e, Times(Sqr(c), d)), GtQ(n, C0))));
            IIntegrate(5683, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCosh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Sqrt(Plus($p("d1"), Times($p("e1", true), x_))), Sqrt(Plus($p("d2"), Times($p("e2", true), x_)))), x_Symbol),
                    Condition(Plus(Simp(Times(C1D2, x, Sqrt(Plus($s("d1"), Times($s("e1"), x))), Sqrt(Plus($s("d2"), Times($s("e2"), x))), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), n)), x), Negate(Dist(Times(Sqrt(Plus($s("d1"), Times($s("e1"), x))), Sqrt(Plus($s("d2"), Times($s("e2"), x))), Power(Times(C2, Sqrt(Plus(C1, Times(c, x))), Sqrt(Plus(CN1, Times(c, x)))), CN1)), Int(Times(Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), n), Power(Times(Sqrt(Plus(C1, Times(c, x))), Sqrt(Plus(CN1, Times(c, x)))), CN1)), x), x)), Negate(Dist(Times(b, c, n, Sqrt(Plus($s("d1"), Times($s("e1"), x))), Sqrt(Plus($s("d2"), Times($s("e2"), x))), Power(Times(C2, Sqrt(Plus(C1, Times(c, x))), Sqrt(Plus(CN1, Times(c, x)))), CN1)), Int(Times(x, Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), Subtract(n, C1))), x), x))), And(FreeQ(List(a, b, c, $s("d1"), $s("e1"), $s("d2"), $s("e2")), x), EqQ($s("e1"), Times(c, $s("d1"))), EqQ($s("e2"), Times(CN1, c, $s("d2"))), GtQ(n, C0))));
            IIntegrate(5684, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSinh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(x, Power(Plus(d, Times(e, Sqr(x))), p), Power(Plus(a, Times(b, ArcSinh(Times(c, x)))), n), Power(Plus(Times(C2, p), C1), CN1)), x), Dist(Times(C2, d, p, Power(Plus(Times(C2, p), C1), CN1)), Int(Times(Power(Plus(d, Times(e, Sqr(x))), Subtract(p, C1)), Power(Plus(a, Times(b, ArcSinh(Times(c, x)))), n)), x), x), Negate(Dist(Times(b, c, n, Power(d, IntPart(p)), Power(Plus(d, Times(e, Sqr(x))), FracPart(p)), Power(Times(Plus(Times(C2, p), C1), Power(Plus(C1, Times(Sqr(c), Sqr(x))), FracPart(p))), CN1)), Int(Times(x, Power(Plus(C1, Times(Sqr(c), Sqr(x))), Subtract(p, C1D2)), Power(Plus(a, Times(b, ArcSinh(Times(c, x)))), Subtract(n, C1))), x), x))), And(FreeQ(List(a, b, c, d, e), x), EqQ(e, Times(Sqr(c), d)), GtQ(n, C0), GtQ(p, C0))));
            IIntegrate(5685, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCosh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Plus($p("d1"), Times($p("e1", true), x_)), p_DEFAULT), Power(Plus($p("d2"), Times($p("e2", true), x_)), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(x, Power(Plus($s("d1"), Times($s("e1"), x)), p), Power(Plus($s("d2"), Times($s("e2"), x)), p), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), n), Power(Plus(Times(C2, p), C1), CN1)), x), Dist(Times(C2, $s("d1"), $s("d2"), p, Power(Plus(Times(C2, p), C1), CN1)), Int(Times(Power(Plus($s("d1"), Times($s("e1"), x)), Subtract(p, C1)), Power(Plus($s("d2"), Times($s("e2"), x)), Subtract(p, C1)), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), n)), x), x), Negate(Dist(Times(b, c, n, Power(Times(CN1, $s("d1"), $s("d2")), Subtract(p, C1D2)), Sqrt(Plus($s("d1"), Times($s("e1"), x))), Sqrt(Plus($s("d2"), Times($s("e2"), x))), Power(Times(Plus(Times(C2, p), C1), Sqrt(Plus(C1, Times(c, x))), Sqrt(Plus(CN1, Times(c, x)))), CN1)), Int(Times(x, Power(Plus(CN1, Times(Sqr(c), Sqr(x))), Subtract(p, C1D2)), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), Subtract(n, C1))), x), x))), And(FreeQ(List(a, b, c, $s("d1"), $s("e1"), $s("d2"), $s("e2")), x), EqQ($s("e1"), Times(c, $s("d1"))), EqQ($s("e2"), Times(CN1, c, $s("d2"))), GtQ(n, C0), GtQ(p, C0), IntegerQ(Subtract(p, C1D2)))));
            IIntegrate(5686, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCosh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Plus($p("d1"), Times($p("e1", true), x_)), p_DEFAULT), Power(Plus($p("d2"), Times($p("e2", true), x_)), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(x, Power(Plus($s("d1"), Times($s("e1"), x)), p), Power(Plus($s("d2"), Times($s("e2"), x)), p), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), n), Power(Plus(Times(C2, p), C1), CN1)), x), Dist(Times(C2, $s("d1"), $s("d2"), p, Power(Plus(Times(C2, p), C1), CN1)), Int(Times(Power(Plus($s("d1"), Times($s("e1"), x)), Subtract(p, C1)), Power(Plus($s("d2"), Times($s("e2"), x)), Subtract(p, C1)), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), n)), x), x), Negate(Dist(Times(b, c, n, Power(Times(CN1, $s("d1"), $s("d2")), IntPart(p)), Power(Plus($s("d1"), Times($s("e1"), x)), FracPart(p)), Power(Plus($s("d2"), Times($s("e2"), x)), FracPart(p)), Power(Times(Plus(Times(C2, p), C1), Power(Plus(C1, Times(c, x)), FracPart(p)), Power(Plus(CN1, Times(c, x)), FracPart(p))), CN1)), Int(Times(x, Power(Plus(CN1, Times(c, x)), Subtract(p, C1D2)), Power(Plus(C1, Times(c, x)), Subtract(p, C1D2)), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), Subtract(n, C1))), x), x))), And(FreeQ(List(a, b, c, $s("d1"), $s("e1"), $s("d2"), $s("e2")), x), EqQ($s("e1"), Times(c, $s("d1"))), EqQ($s("e2"), Times(CN1, c, $s("d2"))), GtQ(n, C0), GtQ(p, C0))));
            IIntegrate(5687, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSinh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), QQ(-3L, 2L))), x_Symbol),
                    Condition(Subtract(Simp(Times(x, Power(Plus(a, Times(b, ArcSinh(Times(c, x)))), n), Power(Times(d, Sqrt(Plus(d, Times(e, Sqr(x))))), CN1)), x), Dist(Times(b, c, n, Sqrt(Plus(C1, Times(Sqr(c), Sqr(x)))), Power(Times(d, Sqrt(Plus(d, Times(e, Sqr(x))))), CN1)), Int(Times(x, Power(Plus(a, Times(b, ArcSinh(Times(c, x)))), Subtract(n, C1)), Power(Plus(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ(e, Times(Sqr(c), d)), GtQ(n, C0))));
            IIntegrate(5688, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCosh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Plus($p("d1"), Times($p("e1", true), x_)), QQ(-3L, 2L)), Power(Plus($p("d2"), Times($p("e2", true), x_)), QQ(-3L, 2L))), x_Symbol),
                    Condition(Plus(Simp(Times(x, Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), n), Power(Times($s("d1"), $s("d2"), Sqrt(Plus($s("d1"), Times($s("e1"), x))), Sqrt(Plus($s("d2"), Times($s("e2"), x)))), CN1)), x), Dist(Times(b, c, n, Sqrt(Plus(C1, Times(c, x))), Sqrt(Plus(CN1, Times(c, x))), Power(Times($s("d1"), $s("d2"), Sqrt(Plus($s("d1"), Times($s("e1"), x))), Sqrt(Plus($s("d2"), Times($s("e2"), x)))), CN1)), Int(Times(x, Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), Subtract(n, C1)), Power(Subtract(C1, Times(Sqr(c), Sqr(x))), CN1)), x), x)), And(FreeQ(List(a, b, c, $s("d1"), $s("e1"), $s("d2"), $s("e2")), x), EqQ($s("e1"), Times(c, $s("d1"))), EqQ($s("e2"), Times(CN1, c, $s("d2"))), GtQ(n, C0))));
            IIntegrate(5689, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCosh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(x, Power(Plus(d, Times(e, Sqr(x))), Plus(p, C1)), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), n), Power(Times(C2, d, Plus(p, C1)), CN1)), x)), Negate(Dist(Times(b, c, n, Power(Negate(d), p), Power(Times(C2, Plus(p, C1)), CN1)), Int(Times(x, Power(Plus(C1, Times(c, x)), Plus(p, C1D2)), Power(Plus(CN1, Times(c, x)), Plus(p, C1D2)), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), Subtract(n, C1))), x), x)), Dist(Times(Plus(Times(C2, p), C3), Power(Times(C2, d, Plus(p, C1)), CN1)), Int(Times(Power(Plus(d, Times(e, Sqr(x))), Plus(p, C1)), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), n)), x), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), GtQ(n, C0), LtQ(p, CN1), IntegerQ(p))));
            IIntegrate(5690, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSinh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(x, Power(Plus(d, Times(e, Sqr(x))), Plus(p, C1)), Power(Plus(a, Times(b, ArcSinh(Times(c, x)))), n), Power(Times(C2, d, Plus(p, C1)), CN1)), x)), Dist(Times(Plus(Times(C2, p), C3), Power(Times(C2, d, Plus(p, C1)), CN1)), Int(Times(Power(Plus(d, Times(e, Sqr(x))), Plus(p, C1)), Power(Plus(a, Times(b, ArcSinh(Times(c, x)))), n)), x), x), Dist(Times(b, c, n, Power(d, IntPart(p)), Power(Plus(d, Times(e, Sqr(x))), FracPart(p)), Power(Times(C2, Plus(p, C1), Power(Plus(C1, Times(Sqr(c), Sqr(x))), FracPart(p))), CN1)), Int(Times(x, Power(Plus(C1, Times(Sqr(c), Sqr(x))), Plus(p, C1D2)), Power(Plus(a, Times(b, ArcSinh(Times(c, x)))), Subtract(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ(e, Times(Sqr(c), d)), GtQ(n, C0), LtQ(p, CN1), NeQ(p, QQ(-3L, 2L)))));
            IIntegrate(5691, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCosh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Plus($p("d1"), Times($p("e1", true), x_)), p_), Power(Plus($p("d2"), Times($p("e2", true), x_)), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(x, Power(Plus($s("d1"), Times($s("e1"), x)), Plus(p, C1)), Power(Plus($s("d2"), Times($s("e2"), x)), Plus(p, C1)), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), n), Power(Times(C2, $s("d1"), $s("d2"), Plus(p, C1)), CN1)), x)), Dist(Times(Plus(Times(C2, p), C3), Power(Times(C2, $s("d1"), $s("d2"), Plus(p, C1)), CN1)), Int(Times(Power(Plus($s("d1"), Times($s("e1"), x)), Plus(p, C1)), Power(Plus($s("d2"), Times($s("e2"), x)), Plus(p, C1)), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), n)), x), x), Negate(Dist(Times(b, c, n, Power(Times(CN1, $s("d1"), $s("d2")), Plus(p, C1D2)), Sqrt(Plus(C1, Times(c, x))), Sqrt(Plus(CN1, Times(c, x))), Power(Times(C2, Plus(p, C1), Sqrt(Plus($s("d1"), Times($s("e1"), x))), Sqrt(Plus($s("d2"), Times($s("e2"), x)))), CN1)), Int(Times(x, Power(Plus(CN1, Times(Sqr(c), Sqr(x))), Plus(p, C1D2)), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), Subtract(n, C1))), x), x))), And(FreeQ(List(a, b, c, $s("d1"), $s("e1"), $s("d2"), $s("e2")), x), EqQ($s("e1"), Times(c, $s("d1"))), EqQ($s("e2"), Times(CN1, c, $s("d2"))), GtQ(n, C0), LtQ(p, CN1), NeQ(p, QQ(-3L, 2L)), IntegerQ(Plus(p, C1D2)))));
            IIntegrate(5692, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCosh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Plus($p("d1"), Times($p("e1", true), x_)), p_), Power(Plus($p("d2"), Times($p("e2", true), x_)), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(x, Power(Plus($s("d1"), Times($s("e1"), x)), Plus(p, C1)), Power(Plus($s("d2"), Times($s("e2"), x)), Plus(p, C1)), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), n), Power(Times(C2, $s("d1"), $s("d2"), Plus(p, C1)), CN1)), x)), Dist(Times(Plus(Times(C2, p), C3), Power(Times(C2, $s("d1"), $s("d2"), Plus(p, C1)), CN1)), Int(Times(Power(Plus($s("d1"), Times($s("e1"), x)), Plus(p, C1)), Power(Plus($s("d2"), Times($s("e2"), x)), Plus(p, C1)), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), n)), x), x), Negate(Dist(Times(b, c, n, Power(Times(CN1, $s("d1"), $s("d2")), IntPart(p)), Power(Plus($s("d1"), Times($s("e1"), x)), FracPart(p)), Power(Plus($s("d2"), Times($s("e2"), x)), FracPart(p)), Power(Times(C2, Plus(p, C1), Power(Plus(C1, Times(c, x)), FracPart(p)), Power(Plus(CN1, Times(c, x)), FracPart(p))), CN1)), Int(Times(x, Power(Plus(C1, Times(c, x)), Plus(p, C1D2)), Power(Plus(CN1, Times(c, x)), Plus(p, C1D2)), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), Subtract(n, C1))), x), x))), And(FreeQ(List(a, b, c, $s("d1"), $s("e1"), $s("d2"), $s("e2")), x), EqQ($s("e1"), Times(c, $s("d1"))), EqQ($s("e2"), Times(CN1, c, $s("d2"))), GtQ(n, C0), LtQ(p, CN1), NeQ(p, QQ(-3L, 2L)))));
            IIntegrate(5693, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSinh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Dist(Power(Times(c, d), CN1), Subst(Int(Times(Power(Plus(a, Times(b, x)), n), Sech(x)), x), x, ArcSinh(Times(c, x))), x), And(FreeQ(List(a, b, c, d, e), x), EqQ(e, Times(Sqr(c), d)), IGtQ(n, C0))));
            IIntegrate(5694, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCosh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(Negate(Dist(Power(Times(c, d), CN1), Subst(Int(Times(Power(Plus(a, Times(b, x)), n), Csch(x)), x), x, ArcCosh(Times(c, x))), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ(Plus(Times(Sqr(c), d), e), C0), IGtQ(n, C0))));
            IIntegrate(5695, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCosh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Negate(d), p), Power(Plus(CN1, Times(c, x)), Plus(p, C1D2)), Power(Plus(C1, Times(c, x)), Plus(p, C1D2)), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), Plus(n, C1)), Power(Times(b, c, Plus(n, C1)), CN1)), x), Dist(Times(c, Power(Negate(d), p), Plus(Times(C2, p), C1), Power(Times(b, Plus(n, C1)), CN1)), Int(Times(x, Power(Plus(CN1, Times(c, x)), Subtract(p, C1D2)), Power(Plus(C1, Times(c, x)), Subtract(p, C1D2)), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), Plus(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, p), x), EqQ(Plus(Times(Sqr(c), d), e), C0), LtQ(n, CN1), IntegerQ(p))));
            IIntegrate(5696, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSinh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Sqrt(Plus(C1, Times(Sqr(c), Sqr(x)))), Power(Plus(d, Times(e, Sqr(x))), p), Power(Plus(a, Times(b, ArcSinh(Times(c, x)))), Plus(n, C1)), Power(Times(b, c, Plus(n, C1)), CN1)), x), Dist(Times(c, Plus(Times(C2, p), C1), Power(d, IntPart(p)), Power(Plus(d, Times(e, Sqr(x))), FracPart(p)), Power(Times(b, Plus(n, C1), Power(Plus(C1, Times(Sqr(c), Sqr(x))), FracPart(p))), CN1)), Int(Times(x, Power(Plus(C1, Times(Sqr(c), Sqr(x))), Subtract(p, C1D2)), Power(Plus(a, Times(b, ArcSinh(Times(c, x)))), Plus(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, p), x), EqQ(e, Times(Sqr(c), d)), LtQ(n, CN1))));
            IIntegrate(5697, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCosh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_), Power(Plus($p("d1"), Times($p("e1", true), x_)), p_DEFAULT), Power(Plus($p("d2"), Times($p("e2", true), x_)), p_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Sqrt(Plus(C1, Times(c, x))), Sqrt(Plus(CN1, Times(c, x))), Power(Plus($s("d1"), Times($s("e1"), x)), p), Power(Plus($s("d2"), Times($s("e2"), x)), p), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), Plus(n, C1)), Power(Times(b, c, Plus(n, C1)), CN1)), x), Dist(Times(c, Plus(Times(C2, p), C1), Power(Times(CN1, $s("d1"), $s("d2")), Subtract(p, C1D2)), Sqrt(Plus($s("d1"), Times($s("e1"), x))), Sqrt(Plus($s("d2"), Times($s("e2"), x))), Power(Times(b, Plus(n, C1), Sqrt(Plus(C1, Times(c, x))), Sqrt(Plus(CN1, Times(c, x)))), CN1)), Int(Times(x, Power(Plus(CN1, Times(Sqr(c), Sqr(x))), Subtract(p, C1D2)), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), Plus(n, C1))), x), x)), And(FreeQ(List(a, b, c, $s("d1"), $s("e1"), $s("d2"), $s("e2"), p), x), EqQ($s("e1"), Times(c, $s("d1"))), EqQ($s("e2"), Times(CN1, c, $s("d2"))), LtQ(n, CN1), IntegerQ(Subtract(p, C1D2)))));
            IIntegrate(5698, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCosh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_), Power(Plus($p("d1"), Times($p("e1", true), x_)), p_DEFAULT), Power(Plus($p("d2"), Times($p("e2", true), x_)), p_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Sqrt(Plus(C1, Times(c, x))), Sqrt(Plus(CN1, Times(c, x))), Power(Plus($s("d1"), Times($s("e1"), x)), p), Power(Plus($s("d2"), Times($s("e2"), x)), p), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), Plus(n, C1)), Power(Times(b, c, Plus(n, C1)), CN1)), x), Dist(Times(c, Plus(Times(C2, p), C1), Power(Times(CN1, $s("d1"), $s("d2")), IntPart(p)), Power(Plus($s("d1"), Times($s("e1"), x)), FracPart(p)), Power(Plus($s("d2"), Times($s("e2"), x)), FracPart(p)), Power(Times(b, Plus(n, C1), Power(Plus(C1, Times(c, x)), FracPart(p)), Power(Plus(CN1, Times(c, x)), FracPart(p))), CN1)), Int(Times(x, Power(Plus(C1, Times(c, x)), Subtract(p, C1D2)), Power(Plus(CN1, Times(c, x)), Subtract(p, C1D2)), Power(Plus(a, Times(b, ArcCosh(Times(c, x)))), Plus(n, C1))), x), x)), And(FreeQ(List(a, b, c, $s("d1"), $s("e1"), $s("d2"), $s("e2"), p), x), EqQ($s("e1"), Times(c, $s("d1"))), EqQ($s("e2"), Times(CN1, c, $s("d2"))), LtQ(n, CN1))));
            IIntegrate(5699, Int(Times(Power(Plus(a_DEFAULT, Times(ArcSinh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(d, p), Power(c, CN1)), Subst(Int(Times(Power(Plus(a, Times(b, x)), n), Power(Cosh(x), Plus(Times(C2, p), C1))), x), x, ArcSinh(Times(c, x))), x), And(FreeQ(List(a, b, c, d, e, n), x), EqQ(e, Times(Sqr(c), d)), IGtQ(Times(C2, p), C0), Or(IntegerQ(p), GtQ(d, C0)))));
            IIntegrate(5700, Int(Times(Power(Plus(a_DEFAULT, Times(ArcCosh(Times(c_DEFAULT, x_)), b_DEFAULT)), n_DEFAULT), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Negate(d), p), Power(c, CN1)), Subst(Int(Times(Power(Plus(a, Times(b, x)), n), Power(Sinh(x), Plus(Times(C2, p), C1))), x), x, ArcCosh(Times(c, x))), x), And(FreeQ(List(a, b, c, d, e, n), x), EqQ(Plus(Times(Sqr(c), d), e), C0), IGtQ(p, C0))));
        }
    }
}
