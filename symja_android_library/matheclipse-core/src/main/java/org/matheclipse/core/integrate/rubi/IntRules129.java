package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.Apart;
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
import static org.matheclipse.core.expression.F.Expand;
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
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandTrig;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FreeFactors;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules129 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(3226, Int(Times(Power($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), m_), Power(Plus(a_, Times(b_DEFAULT, Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), n_))), CN1)), x_Symbol),
                    Condition(Int(Expand(Times(Power(Subtract(C1, Sqr(Sin(Plus(e, Times(f, x))))), Times(C1D2, m)), Power(Plus(a, Times(b, Power(Sin(Plus(e, Times(f, x))), n))), CN1)), x), x), And(FreeQ(List(a, b, e, f), x), IGtQ(Times(C1D2, m), C0), IntegerQ(Times(C1D2, Subtract(n, C1))))));
            IIntegrate(3227, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrig(Times(Power(Times(d, $($s("§cos"), Plus(e, Times(f, x)))), m), Power(Plus(a, Times(b, Power(Times(c, $($s("§sin"), Plus(e, Times(f, x)))), n))), p)), x), x), And(FreeQ(List(a, b, c, d, e, f, m, n), x), IGtQ(p, C0))));
            IIntegrate(3228, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_))), p_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Times(d, Cos(Plus(e, Times(f, x)))), m), Power(Plus(a, Times(b, Power(Times(c, Sin(Plus(e, Times(f, x)))), n))), p)), x), FreeQ(List(a, b, c, d, e, f, m, n, p), x)));
            IIntegrate(3229, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), n_))), p_DEFAULT), Power($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Sqr(Sin(Plus(e, Times(f, x)))), x))), Dist(Times(Power($s("ff"), Times(C1D2, Plus(m, C1))), Power(Times(C2, f), CN1)), Subst(Int(Times(Power(x, Times(C1D2, Subtract(m, C1))), Power(Plus(a, Times(b, Power($s("ff"), Times(C1D2, n)), Power(x, Times(C1D2, n)))), p), Power(Power(Subtract(C1, Times($s("ff"), x)), Times(C1D2, Plus(m, C1))), CN1)), x), x, Times(Sqr(Sin(Plus(e, Times(f, x)))), Power($s("ff"), CN1))), x)), And(FreeQ(List(a, b, e, f, p), x), IntegerQ(Times(C1D2, Subtract(m, C1))), IntegerQ(Times(C1D2, n)))));
            IIntegrate(3230, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_))), p_DEFAULT), Power($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Sin(Plus(e, Times(f, x))), x))), Dist(Times(Power($s("ff"), Plus(m, C1)), Power(f, CN1)), Subst(Int(Times(Power(x, m), Power(Plus(a, Times(b, Power(Times(c, $s("ff"), x), n))), p), Power(Power(Subtract(C1, Times(Sqr($s("ff")), Sqr(x))), Times(C1D2, Plus(m, C1))), CN1)), x), x, Times(Sin(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x)), And(FreeQ(List(a, b, c, e, f, n, p), x), ILtQ(Times(C1D2, Subtract(m, C1)), C0))));
            IIntegrate(3231, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), C4))), p_DEFAULT), Power(Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_)), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Tan(Plus(e, Times(f, x))), x))), Dist(Times($s("ff"), Power(f, CN1)), Subst(Int(Times(Power(Times(d, $s("ff"), x), m), Power(ExpandToSum(Plus(Times(a, Sqr(Plus(C1, Times(Sqr($s("ff")), Sqr(x))))), Times(b, Power($s("ff"), C4), Power(x, C4))), x), p), Power(Power(Plus(C1, Times(Sqr($s("ff")), Sqr(x))), Plus(Times(C2, p), C1)), CN1)), x), x, Times(Tan(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x)), And(FreeQ(List(a, b, d, e, f, m), x), IntegerQ(p))));
            IIntegrate(3232, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), C4))), p_), Power(Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_)), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Tan(Plus(e, Times(f, x))), x))), Dist(Times($s("ff"), Power(Plus(a, Times(b, Power(Sin(Plus(e, Times(f, x))), C4))), p), Power(Sqr(Sec(Plus(e, Times(f, x)))), Times(C2, p)), Power(Times(f, Power(Apart(Plus(Times(a, Sqr(Plus(C1, Sqr(Tan(Plus(e, Times(f, x))))))), Times(b, Power(Tan(Plus(e, Times(f, x))), C4)))), p)), CN1)), Subst(Int(Times(Power(Times(d, $s("ff"), x), m), Power(ExpandToSum(Plus(Times(a, Sqr(Plus(C1, Times(Sqr($s("ff")), Sqr(x))))), Times(b, Power($s("ff"), C4), Power(x, C4))), x), p), Power(Power(Plus(C1, Times(Sqr($s("ff")), Sqr(x))), Plus(Times(C2, p), C1)), CN1)), x), x, Times(Tan(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x)), And(FreeQ(List(a, b, d, e, f, m), x), IntegerQ(Subtract(p, C1D2)))));
            IIntegrate(3233, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), n_))), p_DEFAULT), Power(Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_)), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Tan(Plus(e, Times(f, x))), x))), Dist(Times(Power($s("ff"), Plus(m, C1)), Power(f, CN1)), Subst(Int(Times(Power(Times(d, x), m), Power(Plus(Times(b, Power($s("ff"), n), Power(x, n)), Times(a, Power(Plus(C1, Times(Sqr($s("ff")), Sqr(x))), Times(C1D2, n)))), p), Power(Power(Plus(C1, Times(Sqr($s("ff")), Sqr(x))), Plus(Times(C1D2, n, p), C1)), CN1)), x), x, Times(Tan(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x)), And(FreeQ(List(a, b, d, e, f, m), x), IntegerQ(Times(C1D2, n)), IGtQ(p, C0))));
            IIntegrate(3234, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_))), p_DEFAULT), Power(Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrig(Times(Power(Times(d, $($s("§tan"), Plus(e, Times(f, x)))), m), Power(Plus(a, Times(b, Power(Times(c, $($s("§sin"), Plus(e, Times(f, x)))), n))), p)), x), x), And(FreeQ(List(a, b, c, d, e, f, m, n), x), IGtQ(p, C0))));
            IIntegrate(3235, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_))), p_DEFAULT), Power(Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(a, Times(b, Power(Times(c, Sin(Plus(e, Times(f, x)))), n))), p), Power(Times(d, Tan(Plus(e, Times(f, x)))), m)), x), FreeQ(List(a, b, c, d, e, f, m, n, p), x)));
            IIntegrate(3236, Int(Times(Power(Times($($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), m_), Power(Plus(a_, Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Times(d, Cot(Plus(e, Times(f, x)))), FracPart(m)), Power(Times(Tan(Plus(e, Times(f, x))), Power(d, CN1)), FracPart(m))), Int(Times(Power(Plus(a, Times(b, Power(Times(c, Sin(Plus(e, Times(f, x)))), n))), p), Power(Power(Times(Tan(Plus(e, Times(f, x))), Power(d, CN1)), m), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), Not(IntegerQ(m)))));
            IIntegrate(3237, Int(Times(Power(Times(d_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_), Power(Plus(a_, Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Times(d, Sec(Plus(e, Times(f, x)))), FracPart(m)), Power(Times(Cos(Plus(e, Times(f, x))), Power(d, CN1)), FracPart(m))), Int(Times(Power(Plus(a, Times(b, Power(Times(c, Sin(Plus(e, Times(f, x)))), n))), p), Power(Power(Times(Cos(Plus(e, Times(f, x))), Power(d, CN1)), m), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), Not(IntegerQ(m)))));
            IIntegrate(3238, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), m_), Power(Plus(a_, Times(b_DEFAULT, Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), n_DEFAULT))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, Times(n, p)), Int(Times(Power(Times(d, Csc(Plus(e, Times(f, x)))), Subtract(m, Times(n, p))), Power(Plus(b, Times(a, Power(Csc(Plus(e, Times(f, x))), n))), p)), x), x), And(FreeQ(List(a, b, d, e, f, m, n, p), x), Not(IntegerQ(m)), IntegersQ(n, p))));
            IIntegrate(3239, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), m_), Power(Plus(a_, Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Times(d, Csc(Plus(e, Times(f, x)))), FracPart(m)), Power(Times(Sin(Plus(e, Times(f, x))), Power(d, CN1)), FracPart(m))), Int(Times(Power(Plus(a, Times(b, Power(Times(c, Sin(Plus(e, Times(f, x)))), n))), p), Power(Power(Times(Sin(Plus(e, Times(f, x))), Power(d, CN1)), m), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), Not(IntegerQ(m)))));
            IIntegrate(3240, Int(Times(Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_), Power(Plus(Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), p_), b_DEFAULT), a_, Times(c_DEFAULT, Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), q_))), n_)), x_Symbol),
                    Condition(Module(List(Set(f, FreeFactors(Cot(Plus(d, Times(e, x))), x))), Negate(Dist(Times(f, Power(e, CN1)), Subst(Int(Times(Power(ExpandToSum(Plus(c, Times(b, Power(Plus(C1, Times(Sqr(f), Sqr(x))), Subtract(Times(C1D2, q), Times(C1D2, p)))), Times(a, Power(Plus(C1, Times(Sqr(f), Sqr(x))), Times(C1D2, q)))), x), n), Power(Power(Plus(C1, Times(Sqr(f), Sqr(x))), Plus(Times(C1D2, m), Times(C1D2, n, q), C1)), CN1)), x), x, Times(Cot(Plus(d, Times(e, x))), Power(f, CN1))), x))), And(FreeQ(List(a, b, c, d, e), x), IntegerQ(Times(C1D2, m)), IntegerQ(Times(C1D2, p)), IntegerQ(Times(C1D2, q)), IntegerQ(n), GtQ(p, C0), LeQ(p, q))));
            IIntegrate(3241, Int(Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_), Power(Plus(Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), q_), c_DEFAULT), a_, Times(b_DEFAULT, Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), p_))), n_)), x_Symbol),
                    Condition(Module(List(Set(f, FreeFactors(Tan(Plus(d, Times(e, x))), x))), Dist(Times(f, Power(e, CN1)), Subst(Int(Times(Power(ExpandToSum(Plus(c, Times(b, Power(Plus(C1, Times(Sqr(f), Sqr(x))), Subtract(Times(C1D2, q), Times(C1D2, p)))), Times(a, Power(Plus(C1, Times(Sqr(f), Sqr(x))), Times(C1D2, q)))), x), n), Power(Power(Plus(C1, Times(Sqr(f), Sqr(x))), Plus(Times(C1D2, m), Times(C1D2, n, q), C1)), CN1)), x), x, Times(Tan(Plus(d, Times(e, x))), Power(f, CN1))), x)), And(FreeQ(List(a, b, c, d, e), x), IntegerQ(Times(C1D2, m)), IntegerQ(Times(C1D2, p)), IntegerQ(Times(C1D2, q)), IntegerQ(n), GtQ(p, C0), LeQ(p, q))));
            IIntegrate(3242, Int(Times(Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_), Power(Plus(Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), p_), b_DEFAULT), a_, Times(c_DEFAULT, Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), q_))), n_)), x_Symbol),
                    Condition(Module(List(Set(f, FreeFactors(Cot(Plus(d, Times(e, x))), x))), Negate(Dist(Times(f, Power(e, CN1)), Subst(Int(Times(Power(ExpandToSum(Plus(Times(a, Power(Plus(C1, Times(Sqr(f), Sqr(x))), Times(C1D2, p))), Times(b, Power(f, p), Power(x, p)), Times(c, Power(Plus(C1, Times(Sqr(f), Sqr(x))), Subtract(Times(C1D2, p), Times(C1D2, q))))), x), n), Power(Power(Plus(C1, Times(Sqr(f), Sqr(x))), Plus(Times(C1D2, m), Times(C1D2, n, p), C1)), CN1)), x), x, Times(Cot(Plus(d, Times(e, x))), Power(f, CN1))), x))), And(FreeQ(List(a, b, c, d, e), x), IntegerQ(Times(C1D2, m)), IntegerQ(Times(C1D2, p)), IntegerQ(Times(C1D2, q)), IntegerQ(n), LtQ(C0, q, p))));
            IIntegrate(3243, Int(Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_), Power(Plus(Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), q_), c_DEFAULT), a_, Times(b_DEFAULT, Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), p_))), n_)), x_Symbol),
                    Condition(Module(List(Set(f, FreeFactors(Tan(Plus(d, Times(e, x))), x))), Dist(Times(f, Power(e, CN1)), Subst(Int(Times(Power(ExpandToSum(Plus(Times(a, Power(Plus(C1, Times(Sqr(f), Sqr(x))), Times(C1D2, p))), Times(b, Power(f, p), Power(x, p)), Times(c, Power(Plus(C1, Times(Sqr(f), Sqr(x))), Subtract(Times(C1D2, p), Times(C1D2, q))))), x), n), Power(Power(Plus(C1, Times(Sqr(f), Sqr(x))), Plus(Times(C1D2, m), Times(C1D2, n, p), C1)), CN1)), x), x, Times(Tan(Plus(d, Times(e, x))), Power(f, CN1))), x)), And(FreeQ(List(a, b, c, d, e), x), IntegerQ(Times(C1D2, m)), IntegerQ(Times(C1D2, p)), IntegerQ(Times(C1D2, q)), IntegerQ(n), LtQ(C0, q, p))));
            IIntegrate(3244, Int(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), Times(c_DEFAULT, Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)))), p_DEFAULT), x_Symbol),
                    Condition(Dist(Power(Times(Power(C4, p), Power(c, p)), CN1), Int(Power(Plus(b, Times(C2, c, Power(Sin(Plus(d, Times(e, x))), n))), Times(C2, p)), x), x), And(FreeQ(List(a, b, c, d, e, n), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(p))));
            IIntegrate(3245, Int(Power(Plus(a_DEFAULT, Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), b_DEFAULT), Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)), c_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Power(Times(Power(C4, p), Power(c, p)), CN1), Int(Power(Plus(b, Times(C2, c, Power(Cos(Plus(d, Times(e, x))), n))), Times(C2, p)), x), x), And(FreeQ(List(a, b, c, d, e, n), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(p))));
            IIntegrate(3246, Int(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), Times(c_DEFAULT, Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)))), p_), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Power(Sin(Plus(d, Times(e, x))), n)), Times(c, Power(Sin(Plus(d, Times(e, x))), Times(C2, n)))), p), Power(Power(Plus(b, Times(C2, c, Power(Sin(Plus(d, Times(e, x))), n))), Times(C2, p)), CN1)), Int(Times(u, Power(Plus(b, Times(C2, c, Power(Sin(Plus(d, Times(e, x))), n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, n, p), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(p)))));
            IIntegrate(3247, Int(Power(Plus(a_DEFAULT, Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), b_DEFAULT), Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)), c_DEFAULT)), p_), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Power(Cos(Plus(d, Times(e, x))), n)), Times(c, Power(Cos(Plus(d, Times(e, x))), Times(C2, n)))), p), Power(Power(Plus(b, Times(C2, c, Power(Cos(Plus(d, Times(e, x))), n))), Times(C2, p)), CN1)), Int(Times(u, Power(Plus(b, Times(C2, c, Power(Cos(Plus(d, Times(e, x))), n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, n, p), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(p)))));
            IIntegrate(3248, Int(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), Times(c_DEFAULT, Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)))), CN1), x_Symbol),
                    Condition(Module(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Subtract(Dist(Times(C2, c, Power(q, CN1)), Int(Power(Plus(b, Negate(q), Times(C2, c, Power(Sin(Plus(d, Times(e, x))), n))), CN1), x), x), Dist(Times(C2, c, Power(q, CN1)), Int(Power(Plus(b, q, Times(C2, c, Power(Sin(Plus(d, Times(e, x))), n))), CN1), x), x))), And(FreeQ(List(a, b, c, d, e, n), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(3249, Int(Power(Plus(a_DEFAULT, Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), b_DEFAULT), Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)), c_DEFAULT)), CN1), x_Symbol),
                    Condition(Module(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Subtract(Dist(Times(C2, c, Power(q, CN1)), Int(Power(Plus(b, Negate(q), Times(C2, c, Power(Cos(Plus(d, Times(e, x))), n))), CN1), x), x), Dist(Times(C2, c, Power(q, CN1)), Int(Power(Plus(b, q, Times(C2, c, Power(Cos(Plus(d, Times(e, x))), n))), CN1), x), x))), And(FreeQ(List(a, b, c, d, e, n), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(3250, Int(Times(Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), Times(c_DEFAULT, Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)))), p_)), x_Symbol),
                    Condition(Dist(Power(Times(Power(C4, p), Power(c, p)), CN1), Int(Times(Power(Sin(Plus(d, Times(e, x))), m), Power(Plus(b, Times(C2, c, Power(Sin(Plus(d, Times(e, x))), n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, m, n), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(p))));
        }
    }
}
