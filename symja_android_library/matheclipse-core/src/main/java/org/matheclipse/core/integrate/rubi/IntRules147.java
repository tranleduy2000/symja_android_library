package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Cot;
import static org.matheclipse.core.expression.F.Csc;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Module;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sec;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Tan;
import static org.matheclipse.core.expression.F.Times;
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
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.g;
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
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandTrig;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FreeFactors;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules147 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(3676, Int(Times(Power($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), n_))), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Sin(Plus(e, Times(f, x))), x))), Dist(Times($s("ff"), Power(f, CN1)), Subst(Int(Times(Power(ExpandToSum(Plus(Times(b, Power(Times($s("ff"), x), n)), Times(a, Power(Subtract(C1, Times(Sqr($s("ff")), Sqr(x))), Times(C1D2, n)))), x), p), Power(Power(Subtract(C1, Times(Sqr($s("ff")), Sqr(x))), Times(C1D2, Plus(m, Times(n, p), C1))), CN1)), x), x, Times(Sin(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x)), And(FreeQ(List(a, b, e, f), x), IntegerQ(Times(C1D2, Subtract(m, C1))), IntegerQ(Times(C1D2, n)), IntegerQ(p))));
            IIntegrate(3677, Int(Times(Power($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), n_))), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Sin(Plus(e, Times(f, x))), x))), Dist(Times($s("ff"), Power(f, CN1)), Subst(Int(Times(C1, Power(Times(Plus(Times(b, Power(Times($s("ff"), x), n)), Times(a, Power(Subtract(C1, Times(Sqr($s("ff")), Sqr(x))), Times(C1D2, n)))), Power(Power(Subtract(C1, Times(Sqr($s("ff")), Sqr(x))), Times(C1D2, n)), CN1)), p), Power(Power(Subtract(C1, Times(Sqr($s("ff")), Sqr(x))), Times(C1D2, Plus(m, C1))), CN1)), x), x, Times(Sin(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x)), And(FreeQ(List(a, b, e, f, p), x), IntegerQ(Times(C1D2, Subtract(m, C1))), IntegerQ(Times(C1D2, n)), Not(IntegerQ(p)))));
            IIntegrate(3678, Int(Times(Power(Times(d_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrig(Times(Power(Times(d, $($s("§sec"), Plus(e, Times(f, x)))), m), Power(Plus(a, Times(b, Power(Times(c, $($s("§tan"), Plus(e, Times(f, x)))), n))), p)), x), x), And(FreeQ(List(a, b, c, d, e, f, m, n), x), IGtQ(p, C0))));
            IIntegrate(3679, Int(Times(Power(Times(d_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_), Power(Plus(a_, Times(b_DEFAULT, Sqr($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), p_)), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Tan(Plus(e, Times(f, x))), x))), Dist(Times($s("ff"), Power(Times(d, Sec(Plus(e, Times(f, x)))), m), Power(Times(f, Power(Sqr(Sec(Plus(e, Times(f, x)))), Times(C1D2, m))), CN1)), Subst(Int(Times(Power(Plus(C1, Times(Sqr($s("ff")), Sqr(x))), Subtract(Times(C1D2, m), C1)), Power(Plus(a, Times(b, Sqr($s("ff")), Sqr(x))), p)), x), x, Times(Tan(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x)), And(FreeQ(List(a, b, d, e, f, m, p), x), Not(IntegerQ(m)))));
            IIntegrate(3680, Int(Times(Power(Times(d_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_))), p_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Times(d, Sec(Plus(e, Times(f, x)))), m), Power(Plus(a, Times(b, Power(Times(c, Tan(Plus(e, Times(f, x)))), n))), p)), x), FreeQ(List(a, b, c, d, e, f, m, n, p), x)));
            IIntegrate(3681, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), m_), Power(Plus(a_, Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Times(d, Csc(Plus(e, Times(f, x)))), FracPart(m)), Power(Times(Sin(Plus(e, Times(f, x))), Power(d, CN1)), FracPart(m))), Int(Times(Power(Plus(a, Times(b, Power(Times(c, Tan(Plus(e, Times(f, x)))), n))), p), Power(Power(Times(Sin(Plus(e, Times(f, x))), Power(d, CN1)), m), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), Not(IntegerQ(m)))));
            IIntegrate(3682, Int(Power(Plus(a_, Times(b_DEFAULT, Power($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), Times(c_DEFAULT, Power($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)))), p_DEFAULT), x_Symbol),
                    Condition(Dist(Power(Times(Power(C4, p), Power(c, p)), CN1), Int(Power(Plus(b, Times(C2, c, Power(Tan(Plus(d, Times(e, x))), n))), Times(C2, p)), x), x), And(FreeQ(List(a, b, c, d, e, n), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(p))));
            IIntegrate(3683, Int(Power(Plus(Times(Power($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), b_DEFAULT), Times(Power($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)), c_DEFAULT), a_), p_DEFAULT), x_Symbol),
                    Condition(Dist(Power(Times(Power(C4, p), Power(c, p)), CN1), Int(Power(Plus(b, Times(C2, c, Power(Cot(Plus(d, Times(e, x))), n))), Times(C2, p)), x), x), And(FreeQ(List(a, b, c, d, e, n), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(p))));
            IIntegrate(3684, Int(Power(Plus(a_, Times(b_DEFAULT, Power($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), Times(c_DEFAULT, Power($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)))), p_), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Power(Tan(Plus(d, Times(e, x))), n)), Times(c, Power(Tan(Plus(d, Times(e, x))), Times(C2, n)))), p), Power(Power(Plus(b, Times(C2, c, Power(Tan(Plus(d, Times(e, x))), n))), Times(C2, p)), CN1)), Int(Power(Plus(b, Times(C2, c, Power(Tan(Plus(d, Times(e, x))), n))), Times(C2, p)), x), x), And(FreeQ(List(a, b, c, d, e, n), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(p)))));
            IIntegrate(3685, Int(Power(Plus(Times(Power($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), b_DEFAULT), Times(Power($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)), c_DEFAULT), a_), p_), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Power(Cot(Plus(d, Times(e, x))), n)), Times(c, Power(Cot(Plus(d, Times(e, x))), Times(C2, n)))), p), Power(Power(Plus(b, Times(C2, c, Power(Cot(Plus(d, Times(e, x))), n))), Times(C2, p)), CN1)), Int(Power(Plus(b, Times(C2, c, Power(Cot(Plus(d, Times(e, x))), n))), Times(C2, p)), x), x), And(FreeQ(List(a, b, c, d, e, n), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(p)))));
            IIntegrate(3686, Int(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), Times(c_DEFAULT, Power($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)))), CN1), x_Symbol),
                    Condition(Module(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Subtract(Dist(Times(C2, c, Power(q, CN1)), Int(Power(Plus(b, Negate(q), Times(C2, c, Power(Tan(Plus(d, Times(e, x))), n))), CN1), x), x), Dist(Times(C2, c, Power(q, CN1)), Int(Power(Plus(b, q, Times(C2, c, Power(Tan(Plus(d, Times(e, x))), n))), CN1), x), x))), And(FreeQ(List(a, b, c, d, e, n), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(3687, Int(Power(Plus(a_DEFAULT, Times(Power($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), b_DEFAULT), Times(Power($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)), c_DEFAULT)), CN1), x_Symbol),
                    Condition(Module(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Subtract(Dist(Times(C2, c, Power(q, CN1)), Int(Power(Plus(b, Negate(q), Times(C2, c, Power(Cot(Plus(d, Times(e, x))), n))), CN1), x), x), Dist(Times(C2, c, Power(q, CN1)), Int(Power(Plus(b, q, Times(C2, c, Power(Cot(Plus(d, Times(e, x))), n))), CN1), x), x))), And(FreeQ(List(a, b, c, d, e, n), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(3688, Int(Times(Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(Times(f_DEFAULT, $($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), n_DEFAULT)), Times(c_DEFAULT, Power(Times(f_DEFAULT, $($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), $p("n2", true)))), p_)), x_Symbol),
                    Condition(Dist(Times(f, Power(e, CN1)), Subst(Int(Times(Power(x, m), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p), Power(Power(Plus(Sqr(f), Sqr(x)), Plus(Times(C1D2, m), C1)), CN1)), x), x, Times(f, Tan(Plus(d, Times(e, x))))), x), And(FreeQ(List(a, b, c, d, e, f, n, p), x), EqQ($s("n2"), Times(C2, n)), IntegerQ(Times(C1D2, m)))));
            IIntegrate(3689, Int(Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(Times($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), f_DEFAULT), n_DEFAULT)), Times(c_DEFAULT, Power(Times($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), f_DEFAULT), $p("n2", true)))), p_)), x_Symbol),
                    Condition(Negate(Dist(Times(f, Power(e, CN1)), Subst(Int(Times(Power(x, m), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p), Power(Power(Plus(Sqr(f), Sqr(x)), Plus(Times(C1D2, m), C1)), CN1)), x), x, Times(f, Cot(Plus(d, Times(e, x))))), x)), And(FreeQ(List(a, b, c, d, e, f, n, p), x), EqQ($s("n2"), Times(C2, n)), IntegerQ(Times(C1D2, m)))));
            IIntegrate(3690, Int(Times(Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), Times(c_DEFAULT, Power($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)))), p_DEFAULT)), x_Symbol),
                    Condition(Module(List(Set(g, FreeFactors(Cos(Plus(d, Times(e, x))), x))), Negate(Dist(Times(g, Power(e, CN1)), Subst(Int(Times(Power(Subtract(C1, Times(Sqr(g), Sqr(x))), Times(C1D2, Subtract(m, C1))), Power(ExpandToSum(Plus(Times(a, Power(Times(g, x), Times(C2, n))), Times(b, Power(Times(g, x), n), Power(Subtract(C1, Times(Sqr(g), Sqr(x))), Times(C1D2, n))), Times(c, Power(Subtract(C1, Times(Sqr(g), Sqr(x))), n))), x), p), Power(Power(Times(g, x), Times(C2, n, p)), CN1)), x), x, Times(Cos(Plus(d, Times(e, x))), Power(g, CN1))), x))), And(FreeQ(List(a, b, c, d, e), x), EqQ($s("n2"), Times(C2, n)), IntegerQ(Times(C1D2, Subtract(m, C1))), IntegerQ(Times(C1D2, n)), IntegerQ(p))));
            IIntegrate(3691, Int(Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_DEFAULT, Times(Power($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), b_DEFAULT), Times(c_DEFAULT, Power($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)))), p_DEFAULT)), x_Symbol),
                    Condition(Module(List(Set(g, FreeFactors(Sin(Plus(d, Times(e, x))), x))), Dist(Times(g, Power(e, CN1)), Subst(Int(Times(Power(Subtract(C1, Times(Sqr(g), Sqr(x))), Times(C1D2, Subtract(m, C1))), Power(ExpandToSum(Plus(Times(a, Power(Times(g, x), Times(C2, n))), Times(b, Power(Times(g, x), n), Power(Subtract(C1, Times(Sqr(g), Sqr(x))), Times(C1D2, n))), Times(c, Power(Subtract(C1, Times(Sqr(g), Sqr(x))), n))), x), p), Power(Power(Times(g, x), Times(C2, n, p)), CN1)), x), x, Times(Sin(Plus(d, Times(e, x))), Power(g, CN1))), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ($s("n2"), Times(C2, n)), IntegerQ(Times(C1D2, Subtract(m, C1))), IntegerQ(Times(C1D2, n)), IntegerQ(p))));
            IIntegrate(3692, Int(Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(Times(f_DEFAULT, $($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), n_DEFAULT)), Times(c_DEFAULT, Power(Times(f_DEFAULT, $($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), $p("n2", true)))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(f, Plus(m, C1)), Power(e, CN1)), Subst(Int(Times(Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p), Power(Power(Plus(Sqr(f), Sqr(x)), Plus(Times(C1D2, m), C1)), CN1)), x), x, Times(f, Tan(Plus(d, Times(e, x))))), x), And(FreeQ(List(a, b, c, d, e, f, n, p), x), EqQ($s("n2"), Times(C2, n)), IntegerQ(Times(C1D2, m)))));
            IIntegrate(3693, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(Times($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), f_DEFAULT), n_DEFAULT)), Times(c_DEFAULT, Power(Times($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), f_DEFAULT), $p("n2", true)))), p_DEFAULT), Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_)), x_Symbol),
                    Condition(Negate(Dist(Times(Power(f, Plus(m, C1)), Power(e, CN1)), Subst(Int(Times(Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p), Power(Power(Plus(Sqr(f), Sqr(x)), Plus(Times(C1D2, m), C1)), CN1)), x), x, Times(f, Cot(Plus(d, Times(e, x))))), x)), And(FreeQ(List(a, b, c, d, e, f, n, p), x), EqQ($s("n2"), Times(C2, n)), IntegerQ(Times(C1D2, m)))));
            IIntegrate(3694, Int(Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), Times(c_DEFAULT, Power($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)))), p_DEFAULT)), x_Symbol),
                    Condition(Module(List(Set(g, FreeFactors(Sin(Plus(d, Times(e, x))), x))), Dist(Times(g, Power(e, CN1)), Subst(Int(Times(Power(Subtract(C1, Times(Sqr(g), Sqr(x))), Times(C1D2, Subtract(Subtract(m, Times(C2, n, p)), C1))), Power(ExpandToSum(Plus(Times(c, Power(x, Times(C2, n))), Times(b, Power(x, n), Power(Subtract(C1, Sqr(x)), Times(C1D2, n))), Times(a, Power(Subtract(C1, Sqr(x)), n))), x), p)), x), x, Times(Sin(Plus(d, Times(e, x))), Power(g, CN1))), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ($s("n2"), Times(C2, n)), IntegerQ(Times(C1D2, Subtract(m, C1))), IntegerQ(Times(C1D2, n)), IntegerQ(p))));
            IIntegrate(3695, Int(Times(Power(Plus(a_DEFAULT, Times(Power($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), b_DEFAULT), Times(Power($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)), c_DEFAULT)), p_DEFAULT), Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_)), x_Symbol),
                    Condition(Module(List(Set(g, FreeFactors(Cos(Plus(d, Times(e, x))), x))), Negate(Dist(Times(g, Power(e, CN1)), Subst(Int(Times(Power(Subtract(C1, Times(Sqr(g), Sqr(x))), Times(C1D2, Subtract(Subtract(m, Times(C2, n, p)), C1))), Power(ExpandToSum(Plus(Times(c, Power(x, Times(C2, n))), Times(b, Power(x, n), Power(Subtract(C1, Sqr(x)), Times(C1D2, n))), Times(a, Power(Subtract(C1, Sqr(x)), n))), x), p)), x), x, Times(Cos(Plus(d, Times(e, x))), Power(g, CN1))), x))), And(FreeQ(List(a, b, c, d, e), x), EqQ($s("n2"), Times(C2, n)), IntegerQ(Times(C1D2, Subtract(m, C1))), IntegerQ(Times(C1D2, n)), IntegerQ(p))));
            IIntegrate(3696, Int(Times(Power($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), Times(c_DEFAULT, Power($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)))), p_)), x_Symbol),
                    Condition(Dist(Power(Times(Power(C4, p), Power(c, p)), CN1), Int(Times(Power(Tan(Plus(d, Times(e, x))), m), Power(Plus(b, Times(C2, c, Power(Tan(Plus(d, Times(e, x))), n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, m, n), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(p))));
            IIntegrate(3697, Int(Times(Power($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_DEFAULT, Times(Power($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), b_DEFAULT), Times(Power($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)), c_DEFAULT)), p_)), x_Symbol),
                    Condition(Dist(Power(Times(Power(C4, p), Power(c, p)), CN1), Int(Times(Power(Cot(Plus(d, Times(e, x))), m), Power(Plus(b, Times(C2, c, Power(Cot(Plus(d, Times(e, x))), n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, m, n), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(p))));
            IIntegrate(3698, Int(Times(Power($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), Times(c_DEFAULT, Power($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Power(Tan(Plus(d, Times(e, x))), n)), Times(c, Power(Tan(Plus(d, Times(e, x))), Times(C2, n)))), p), Power(Power(Plus(b, Times(C2, c, Power(Tan(Plus(d, Times(e, x))), n))), Times(C2, p)), CN1)), Int(Times(Power(Tan(Plus(d, Times(e, x))), m), Power(Plus(b, Times(C2, c, Power(Tan(Plus(d, Times(e, x))), n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, m, n, p), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(p)))));
            IIntegrate(3699, Int(Times(Power($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_DEFAULT, Times(Power($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), b_DEFAULT), Times(Power($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)), c_DEFAULT)), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Power(Cot(Plus(d, Times(e, x))), n)), Times(c, Power(Cot(Plus(d, Times(e, x))), Times(C2, n)))), p), Power(Power(Plus(b, Times(C2, c, Power(Cot(Plus(d, Times(e, x))), n))), Times(C2, p)), CN1)), Int(Times(Power(Cot(Plus(d, Times(e, x))), m), Power(Plus(b, Times(C2, c, Power(Cot(Plus(d, Times(e, x))), n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, m, n, p), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(p)))));
            IIntegrate(3700, Int(Times(Power($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(Times(f_DEFAULT, $($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), n_DEFAULT)), Times(c_DEFAULT, Power(Times(f_DEFAULT, $($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), $p("n2", true)))), p_)), x_Symbol),
                    Condition(Dist(Times(f, Power(e, CN1)), Subst(Int(Times(Power(Times(x, Power(f, CN1)), m), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p), Power(Plus(Sqr(f), Sqr(x)), CN1)), x), x, Times(f, Tan(Plus(d, Times(e, x))))), x), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
        }
    }
}
