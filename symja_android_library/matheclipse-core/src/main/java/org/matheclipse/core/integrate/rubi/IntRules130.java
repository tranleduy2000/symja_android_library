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
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Module;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Tan;
import static org.matheclipse.core.expression.F.Times;
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
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandTrig;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FreeFactors;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules130 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(3251, Int(Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_DEFAULT, Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), b_DEFAULT), Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)), c_DEFAULT)), p_)), x_Symbol),
                    Condition(Dist(Power(Times(Power(C4, p), Power(c, p)), CN1), Int(Times(Power(Cos(Plus(d, Times(e, x))), m), Power(Plus(b, Times(C2, c, Power(Cos(Plus(d, Times(e, x))), n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, m, n), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(p))));
            IIntegrate(3252, Int(Times(Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), Times(c_DEFAULT, Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Power(Sin(Plus(d, Times(e, x))), n)), Times(c, Power(Sin(Plus(d, Times(e, x))), Times(C2, n)))), p), Power(Power(Plus(b, Times(C2, c, Power(Sin(Plus(d, Times(e, x))), n))), Times(C2, p)), CN1)), Int(Times(Power(Sin(Plus(d, Times(e, x))), m), Power(Plus(b, Times(C2, c, Power(Sin(Plus(d, Times(e, x))), n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, m, n, p), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(p)))));
            IIntegrate(3253, Int(Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_DEFAULT, Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), b_DEFAULT), Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)), c_DEFAULT)), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Power(Cos(Plus(d, Times(e, x))), n)), Times(c, Power(Cos(Plus(d, Times(e, x))), Times(C2, n)))), p), Power(Power(Plus(b, Times(C2, c, Power(Cos(Plus(d, Times(e, x))), n))), Times(C2, p)), CN1)), Int(Times(Power(Cos(Plus(d, Times(e, x))), m), Power(Plus(b, Times(C2, c, Power(Cos(Plus(d, Times(e, x))), n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, m, n, p), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(p)))));
            IIntegrate(3254, Int(Times(Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_)), Times(c_DEFAULT, Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2")))), p_)), x_Symbol),
                    Condition(Module(List(Set(f, FreeFactors(Cot(Plus(d, Times(e, x))), x))), Negate(Dist(Times(f, Power(e, CN1)), Subst(Int(Times(Power(ExpandToSum(Plus(c, Times(b, Power(Plus(C1, Sqr(x)), Times(C1D2, n))), Times(a, Power(Plus(C1, Sqr(x)), n))), x), p), Power(Power(Plus(C1, Times(Sqr(f), Sqr(x))), Plus(Times(C1D2, m), Times(n, p), C1)), CN1)), x), x, Times(Cot(Plus(d, Times(e, x))), Power(f, CN1))), x))), And(FreeQ(List(a, b, c, d, e), x), EqQ($s("n2"), Times(C2, n)), IntegerQ(Times(C1D2, m)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(Times(C1D2, n)), IntegerQ(p))));
            IIntegrate(3255, Int(Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_DEFAULT, Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_), b_DEFAULT), Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2")), c_DEFAULT)), p_)), x_Symbol),
                    Condition(Module(List(Set(f, FreeFactors(Tan(Plus(d, Times(e, x))), x))), Dist(Times(f, Power(e, CN1)), Subst(Int(Times(Power(ExpandToSum(Plus(c, Times(b, Power(Plus(C1, Sqr(x)), Times(C1D2, n))), Times(a, Power(Plus(C1, Sqr(x)), n))), x), p), Power(Power(Plus(C1, Times(Sqr(f), Sqr(x))), Plus(Times(C1D2, m), Times(n, p), C1)), CN1)), x), x, Times(Tan(Plus(d, Times(e, x))), Power(f, CN1))), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ($s("n2"), Times(C2, n)), IntegerQ(Times(C1D2, m)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(Times(C1D2, n)), IntegerQ(p))));
            IIntegrate(3256, Int(Times(Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), Times(c_DEFAULT, Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)))), p_)), x_Symbol),
                    Condition(Int(ExpandTrig(Times(Power($($s("§sin"), Plus(d, Times(e, x))), m), Power(Plus(a, Times(b, Power($($s("§sin"), Plus(d, Times(e, x))), n)), Times(c, Power($($s("§sin"), Plus(d, Times(e, x))), Times(C2, n)))), p)), x), x), And(FreeQ(List(a, b, c, d, e), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegersQ(m, n, p))));
            IIntegrate(3257, Int(Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_DEFAULT, Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), b_DEFAULT), Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)), c_DEFAULT)), p_)), x_Symbol),
                    Condition(Int(ExpandTrig(Times(Power($($s("§cos"), Plus(d, Times(e, x))), m), Power(Plus(a, Times(b, Power($($s("§cos"), Plus(d, Times(e, x))), n)), Times(c, Power($($s("§cos"), Plus(d, Times(e, x))), Times(C2, n)))), p)), x), x), And(FreeQ(List(a, b, c, d, e), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegersQ(m, n, p))));
            IIntegrate(3258, Int(Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(Times(f_DEFAULT, $($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), n_DEFAULT)), Times(c_DEFAULT, Power(Times(f_DEFAULT, $($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), $p("n2", true)))), p_DEFAULT)), x_Symbol),
                    Condition(Module(List(Set(g, FreeFactors(Sin(Plus(d, Times(e, x))), x))), Dist(Times(g, Power(e, CN1)), Subst(Int(Times(Power(Subtract(C1, Times(Sqr(g), Sqr(x))), Times(C1D2, Subtract(m, C1))), Power(Plus(a, Times(b, Power(Times(f, g, x), n)), Times(c, Power(Times(f, g, x), Times(C2, n)))), p)), x), x, Times(Sin(Plus(d, Times(e, x))), Power(g, CN1))), x)), And(FreeQ(List(a, b, c, d, e, f, n, p), x), EqQ($s("n2"), Times(C2, n)), IntegerQ(Times(C1D2, Subtract(m, C1))))));
            IIntegrate(3259, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(Times($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), f_DEFAULT), n_DEFAULT)), Times(c_DEFAULT, Power(Times($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), f_DEFAULT), $p("n2", true)))), p_DEFAULT), Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT)), x_Symbol),
                    Condition(Module(List(Set(g, FreeFactors(Cos(Plus(d, Times(e, x))), x))), Negate(Dist(Times(g, Power(e, CN1)), Subst(Int(Times(Power(Subtract(C1, Times(Sqr(g), Sqr(x))), Times(C1D2, Subtract(m, C1))), Power(Plus(a, Times(b, Power(Times(f, g, x), n)), Times(c, Power(Times(f, g, x), Times(C2, n)))), p)), x), x, Times(Cos(Plus(d, Times(e, x))), Power(g, CN1))), x))), And(FreeQ(List(a, b, c, d, e, f, n, p), x), EqQ($s("n2"), Times(C2, n)), IntegerQ(Times(C1D2, Subtract(m, C1))))));
            IIntegrate(3260, Int(Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), Times(c_DEFAULT, Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Times(Power(C4, p), Power(c, p)), CN1), Int(Times(Power(Cos(Plus(d, Times(e, x))), m), Power(Plus(b, Times(C2, c, Power(Sin(Plus(d, Times(e, x))), n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, m, n), x), EqQ($s("n2"), Times(C2, n)), Not(IntegerQ(Times(C1D2, Subtract(m, C1)))), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(p))));
            IIntegrate(3261, Int(Times(Power(Plus(a_DEFAULT, Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), b_DEFAULT), Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)), c_DEFAULT)), p_DEFAULT), Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_)), x_Symbol),
                    Condition(Dist(Power(Times(Power(C4, p), Power(c, p)), CN1), Int(Times(Power(Sin(Plus(d, Times(e, x))), m), Power(Plus(b, Times(C2, c, Power(Cos(Plus(d, Times(e, x))), n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, m, n), x), EqQ($s("n2"), Times(C2, n)), Not(IntegerQ(Times(C1D2, Subtract(m, C1)))), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(p))));
            IIntegrate(3262, Int(Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), Times(c_DEFAULT, Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Power(Sin(Plus(d, Times(e, x))), n)), Times(c, Power(Sin(Plus(d, Times(e, x))), Times(C2, n)))), p), Power(Power(Plus(b, Times(C2, c, Power(Sin(Plus(d, Times(e, x))), n))), Times(C2, p)), CN1)), Int(Times(Power(Cos(Plus(d, Times(e, x))), m), Power(Plus(b, Times(C2, c, Power(Sin(Plus(d, Times(e, x))), n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, m, n, p), x), EqQ($s("n2"), Times(C2, n)), Not(IntegerQ(Times(C1D2, Subtract(m, C1)))), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(p)))));
            IIntegrate(3263, Int(Times(Power(Plus(a_DEFAULT, Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), b_DEFAULT), Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)), c_DEFAULT)), p_), Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Power(Cos(Plus(d, Times(e, x))), n)), Times(c, Power(Cos(Plus(d, Times(e, x))), Times(C2, n)))), p), Power(Power(Plus(b, Times(C2, c, Power(Cos(Plus(d, Times(e, x))), n))), Times(C2, p)), CN1)), Int(Times(Power(Sin(Plus(d, Times(e, x))), m), Power(Plus(b, Times(C2, c, Power(Cos(Plus(d, Times(e, x))), n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, m, n, p), x), EqQ($s("n2"), Times(C2, n)), Not(IntegerQ(Times(C1D2, Subtract(m, C1)))), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(p)))));
            IIntegrate(3264, Int(Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_)), Times(c_DEFAULT, Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2")))), p_DEFAULT)), x_Symbol),
                    Condition(Module(List(Set(f, FreeFactors(Cot(Plus(d, Times(e, x))), x))), Negate(Dist(Times(Power(f, Plus(m, C1)), Power(e, CN1)), Subst(Int(Times(Power(x, m), Power(ExpandToSum(Plus(c, Times(b, Power(Plus(C1, Sqr(x)), Times(C1D2, n))), Times(a, Power(Plus(C1, Sqr(x)), n))), x), p), Power(Power(Plus(C1, Times(Sqr(f), Sqr(x))), Plus(Times(C1D2, m), Times(n, p), C1)), CN1)), x), x, Times(Cot(Plus(d, Times(e, x))), Power(f, CN1))), x))), And(FreeQ(List(a, b, c, d, e), x), EqQ($s("n2"), Times(C2, n)), IntegerQ(Times(C1D2, m)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(Times(C1D2, n)), IntegerQ(p))));
            IIntegrate(3265, Int(Times(Power(Plus(a_DEFAULT, Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_), b_DEFAULT), Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2")), c_DEFAULT)), p_DEFAULT), Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT)), x_Symbol),
                    Condition(Module(List(Set(f, FreeFactors(Tan(Plus(d, Times(e, x))), x))), Dist(Times(Power(f, Plus(m, C1)), Power(e, CN1)), Subst(Int(Times(Power(x, m), Power(ExpandToSum(Plus(c, Times(b, Power(Plus(C1, Sqr(x)), Times(C1D2, n))), Times(a, Power(Plus(C1, Sqr(x)), n))), x), p), Power(Power(Plus(C1, Times(Sqr(f), Sqr(x))), Plus(Times(C1D2, m), Times(n, p), C1)), CN1)), x), x, Times(Tan(Plus(d, Times(e, x))), Power(f, CN1))), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ($s("n2"), Times(C2, n)), IntegerQ(Times(C1D2, m)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(Times(C1D2, n)), IntegerQ(p))));
            IIntegrate(3266, Int(Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), Times(c_DEFAULT, Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrig(Times(Power(Subtract(C1, Sqr($($s("§sin"), Plus(d, Times(e, x))))), Times(C1D2, m)), Power(Plus(a, Times(b, Power($($s("§sin"), Plus(d, Times(e, x))), n)), Times(c, Power($($s("§sin"), Plus(d, Times(e, x))), Times(C2, n)))), p)), x), x), And(FreeQ(List(a, b, c, d, e), x), EqQ($s("n2"), Times(C2, n)), IntegerQ(Times(C1D2, m)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegersQ(n, p))));
            IIntegrate(3267, Int(Times(Power(Plus(a_DEFAULT, Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), b_DEFAULT), Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)), c_DEFAULT)), p_DEFAULT), Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrig(Times(Power(Subtract(C1, Sqr($($s("§cos"), Plus(d, Times(e, x))))), Times(C1D2, m)), Power(Plus(a, Times(b, Power($($s("§cos"), Plus(d, Times(e, x))), n)), Times(c, Power($($s("§cos"), Plus(d, Times(e, x))), Times(C2, n)))), p)), x), x), And(FreeQ(List(a, b, c, d, e), x), EqQ($s("n2"), Times(C2, n)), IntegerQ(Times(C1D2, m)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegersQ(n, p))));
            IIntegrate(3268, Int(Times(Power(Plus(a_, Times(c_DEFAULT, Power(Times(f_DEFAULT, $($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), $p("n2", true))), Times(b_DEFAULT, Power(Times(f_DEFAULT, $($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), n_))), p_DEFAULT), Power($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT)), x_Symbol),
                    Condition(Module(List(Set(g, FreeFactors(Sin(Plus(d, Times(e, x))), x))), Dist(Times(Power(g, Plus(m, C1)), Power(e, CN1)), Subst(Int(Times(Power(x, m), Power(Plus(a, Times(b, Power(Times(f, g, x), n)), Times(c, Power(Times(f, g, x), Times(C2, n)))), p), Power(Power(Subtract(C1, Times(Sqr(g), Sqr(x))), Times(C1D2, Plus(m, C1))), CN1)), x), x, Times(Sin(Plus(d, Times(e, x))), Power(g, CN1))), x)), And(FreeQ(List(a, b, c, d, e, f, n), x), IntegerQ(Times(C1D2, Subtract(m, C1))), IntegerQ(Times(C2, p)))));
            IIntegrate(3269, Int(Times(Power($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power(Plus(Times(c_DEFAULT, Power(Times($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), f_DEFAULT), $p("n2", true))), Times(b_DEFAULT, Power(Times($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), f_DEFAULT), n_)), a_), p_DEFAULT)), x_Symbol),
                    Condition(Module(List(Set(g, FreeFactors(Cos(Plus(d, Times(e, x))), x))), Negate(Dist(Times(Power(g, Plus(m, C1)), Power(e, CN1)), Subst(Int(Times(Power(x, m), Power(Plus(a, Times(b, Power(Times(f, g, x), n)), Times(c, Power(Times(f, g, x), Times(C2, n)))), p), Power(Power(Subtract(C1, Times(Sqr(g), Sqr(x))), Times(C1D2, Plus(m, C1))), CN1)), x), x, Times(Cos(Plus(d, Times(e, x))), Power(g, CN1))), x))), And(FreeQ(List(a, b, c, d, e, f, n), x), IntegerQ(Times(C1D2, Subtract(m, C1))), IntegerQ(Times(C2, p)))));
            IIntegrate(3270, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), Times(c_DEFAULT, Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)))), p_DEFAULT), Power($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_)), x_Symbol),
                    Condition(Dist(Power(Times(Power(C4, p), Power(c, p)), CN1), Int(Times(Power(Tan(Plus(d, Times(e, x))), m), Power(Plus(b, Times(C2, c, Power(Sin(Plus(d, Times(e, x))), n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, m, n), x), EqQ($s("n2"), Times(C2, n)), Not(IntegerQ(Times(C1D2, Subtract(m, C1)))), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(p))));
            IIntegrate(3271, Int(Times(Power($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_), Power(Plus(a_DEFAULT, Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), b_DEFAULT), Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)), c_DEFAULT)), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Times(Power(C4, p), Power(c, p)), CN1), Int(Times(Power(Cot(Plus(d, Times(e, x))), m), Power(Plus(b, Times(C2, c, Power(Cos(Plus(d, Times(e, x))), n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, m, n), x), EqQ($s("n2"), Times(C2, n)), Not(IntegerQ(Times(C1D2, Subtract(m, C1)))), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(p))));
            IIntegrate(3272, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), Times(c_DEFAULT, Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)))), p_), Power($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Power(Sin(Plus(d, Times(e, x))), n)), Times(c, Power(Sin(Plus(d, Times(e, x))), Times(C2, n)))), p), Power(Power(Plus(b, Times(C2, c, Power(Sin(Plus(d, Times(e, x))), n))), Times(C2, p)), CN1)), Int(Times(Power(Tan(Plus(d, Times(e, x))), m), Power(Plus(b, Times(C2, c, Power(Sin(Plus(d, Times(e, x))), n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, m, n, p), x), EqQ($s("n2"), Times(C2, n)), Not(IntegerQ(Times(C1D2, Subtract(m, C1)))), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(p)))));
            IIntegrate(3273, Int(Times(Power($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_), Power(Plus(a_DEFAULT, Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), b_DEFAULT), Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)), c_DEFAULT)), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Power(Cos(Plus(d, Times(e, x))), n)), Times(c, Power(Cos(Plus(d, Times(e, x))), Times(C2, n)))), p), Power(Power(Plus(b, Times(C2, c, Power(Cos(Plus(d, Times(e, x))), n))), Times(C2, p)), CN1)), Int(Times(Power(Cot(Plus(d, Times(e, x))), m), Power(Plus(b, Times(C2, c, Power(Cos(Plus(d, Times(e, x))), n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, m, n, p), x), EqQ($s("n2"), Times(C2, n)), Not(IntegerQ(Times(C1D2, Subtract(m, C1)))), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(p)))));
            IIntegrate(3274, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_)), Times(c_DEFAULT, Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2")))), p_DEFAULT), Power($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT)), x_Symbol),
                    Condition(Module(List(Set(f, FreeFactors(Tan(Plus(d, Times(e, x))), x))), Dist(Times(Power(f, Plus(m, C1)), Power(e, CN1)), Subst(Int(Times(Power(x, m), Power(ExpandToSum(Plus(Times(c, Power(x, Times(C2, n))), Times(b, Power(x, n), Power(Plus(C1, Sqr(x)), Times(C1D2, n))), Times(a, Power(Plus(C1, Sqr(x)), n))), x), p), Power(Power(Plus(C1, Times(Sqr(f), Sqr(x))), Plus(Times(n, p), C1)), CN1)), x), x, Times(Tan(Plus(d, Times(e, x))), Power(f, CN1))), x)), And(FreeQ(List(a, b, c, d, e, m), x), EqQ($s("n2"), Times(C2, n)), Not(IntegerQ(Times(C1D2, Subtract(m, C1)))), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(Times(C1D2, n)), IntegerQ(p))));
            IIntegrate(3275, Int(Times(Power($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_DEFAULT, Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_), b_DEFAULT), Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2")), c_DEFAULT)), p_DEFAULT)), x_Symbol),
                    Condition(Module(List(Set(f, FreeFactors(Cot(Plus(d, Times(e, x))), x))), Negate(Dist(Times(Power(f, Plus(m, C1)), Power(e, CN1)), Subst(Int(Times(Power(x, m), Power(ExpandToSum(Plus(Times(c, Power(x, Times(C2, n))), Times(b, Power(x, n), Power(Plus(C1, Sqr(x)), Times(C1D2, n))), Times(a, Power(Plus(C1, Sqr(x)), n))), x), p), Power(Power(Plus(C1, Times(Sqr(f), Sqr(x))), Plus(Times(n, p), C1)), CN1)), x), x, Times(Cot(Plus(d, Times(e, x))), Power(f, CN1))), x))), And(FreeQ(List(a, b, c, d, e, m), x), EqQ($s("n2"), Times(C2, n)), Not(IntegerQ(Times(C1D2, Subtract(m, C1)))), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(Times(C1D2, n)), IntegerQ(p))));
        }
    }
}
