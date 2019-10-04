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
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.MatchQ;
import static org.matheclipse.core.expression.F.MemberQ;
import static org.matheclipse.core.expression.F.Module;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sec;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Sum;
import static org.matheclipse.core.expression.F.Tan;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
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
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ActivateTrig;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules128 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(3201, Int(Times(Power($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), m_), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Sin(Plus(e, Times(f, x))), x))), Dist(Times($s("ff"), Sqrt(Sqr(Cos(Plus(e, Times(f, x))))), Power(Times(f, Cos(Plus(e, Times(f, x)))), CN1)), Subst(Int(Times(Power(Times(d, $s("ff"), x), n), Power(Subtract(C1, Times(Sqr($s("ff")), Sqr(x))), Times(C1D2, Subtract(m, C1))), Power(Plus(a, Times(b, Sqr($s("ff")), Sqr(x))), p)), x), x, Times(Sin(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x)), And(FreeQ(List(a, b, d, e, f, n, p), x), IntegerQ(Times(C1D2, m)))));
            IIntegrate(3202, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), c_DEFAULT), m_), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Sin(Plus(e, Times(f, x))), x))), Dist(Times($s("ff"), Power(c, Plus(Times(C2, IntPart(Times(C1D2, Subtract(m, C1)))), C1)), Power(Times(c, Cos(Plus(e, Times(f, x)))), Times(C2, FracPart(Times(C1D2, Subtract(m, C1))))), Power(Times(f, Power(Sqr(Cos(Plus(e, Times(f, x)))), FracPart(Times(C1D2, Subtract(m, C1))))), CN1)), Subst(Int(Times(Power(Times(d, $s("ff"), x), n), Power(Subtract(C1, Times(Sqr($s("ff")), Sqr(x))), Times(C1D2, Subtract(m, C1))), Power(Plus(a, Times(b, Sqr($s("ff")), Sqr(x))), p)), x), x, Times(Sin(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x)), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), Not(IntegerQ(m)))));
            IIntegrate(3203, Int(Power(Times(b_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), p_), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Cot(Plus(e, Times(f, x))), Power(Times(b, Sqr(Sin(Plus(e, Times(f, x))))), p), Power(Times(C2, f, p), CN1)), x)), Dist(Times(b, Subtract(Times(C2, p), C1), Power(Times(C2, p), CN1)), Int(Power(Times(b, Sqr(Sin(Plus(e, Times(f, x))))), Subtract(p, C1)), x), x)), And(FreeQ(List(b, e, f), x), Not(IntegerQ(p)), GtQ(p, C1))));
            IIntegrate(3204, Int(Power(Times(b_DEFAULT, Sqr($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), p_), x_Symbol),
                    Condition(Plus(Simp(Times(Cot(Plus(e, Times(f, x))), Power(Times(b, Sqr(Sin(Plus(e, Times(f, x))))), Plus(p, C1)), Power(Times(b, f, Plus(Times(C2, p), C1)), CN1)), x), Dist(Times(C2, Plus(p, C1), Power(Times(b, Plus(Times(C2, p), C1)), CN1)), Int(Power(Times(b, Sqr(Sin(Plus(e, Times(f, x))))), Plus(p, C1)), x), x)), And(FreeQ(List(b, e, f), x), Not(IntegerQ(p)), LtQ(p, CN1))));
            IIntegrate(3205, Int(Times(Power(Times(b_DEFAULT, Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), n_)), p_DEFAULT), Power($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Sqr(Sin(Plus(e, Times(f, x)))), x))), Dist(Times(Power($s("ff"), Times(C1D2, Plus(m, C1))), Power(Times(C2, f), CN1)), Subst(Int(Times(Power(x, Times(C1D2, Subtract(m, C1))), Power(Times(b, Power($s("ff"), Times(C1D2, n)), Power(x, Times(C1D2, n))), p), Power(Power(Subtract(C1, Times($s("ff"), x)), Times(C1D2, Plus(m, C1))), CN1)), x), x, Times(Sqr(Sin(Plus(e, Times(f, x)))), Power($s("ff"), CN1))), x)), And(FreeQ(List(b, e, f, p), x), IntegerQ(Times(C1D2, Subtract(m, C1))), IntegerQ(Times(C1D2, n)))));
            IIntegrate(3206, Int(Times(Power(Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_)), p_DEFAULT), Power($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Sin(Plus(e, Times(f, x))), x))), Dist(Times(Power($s("ff"), Plus(m, C1)), Power(f, CN1)), Subst(Int(Times(Power(x, m), Power(Times(b, Power(Times(c, $s("ff"), x), n)), p), Power(Power(Subtract(C1, Times(Sqr($s("ff")), Sqr(x))), Times(C1D2, Plus(m, C1))), CN1)), x), x, Times(Sin(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x)), And(FreeQ(List(b, c, e, f, n, p), x), ILtQ(Times(C1D2, Subtract(m, C1)), C0))));
            IIntegrate(3207, Int(Times(u_DEFAULT, Power(Times(b_DEFAULT, Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), n_)), p_)), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Sin(Plus(e, Times(f, x))), x))), Dist(Times(Power(Times(b, Power($s("ff"), n)), IntPart(p)), Power(Times(b, Power(Sin(Plus(e, Times(f, x))), n)), FracPart(p)), Power(Power(Times(Sin(Plus(e, Times(f, x))), Power($s("ff"), CN1)), Times(n, FracPart(p))), CN1)), Int(Times(ActivateTrig(u), Power(Times(Sin(Plus(e, Times(f, x))), Power($s("ff"), CN1)), Times(n, p))), x), x)), And(FreeQ(List(b, e, f, n, p), x), Not(IntegerQ(p)), IntegerQ(n), Or(EqQ(u, C1), MatchQ(u, Condition(Power(Times(d_DEFAULT, $($p("§trig"), Plus(e, Times(f, x)))), m_DEFAULT), And(FreeQ(List(d, m), x), MemberQ(List($s("§sin"), $s("§cos"), $s("§tan"), $s("§cot"), $s("§sec"), $s("§csc")), $s("§trig")))))))));
            IIntegrate(3208, Int(Times(u_DEFAULT, Power(Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_)), p_)), x_Symbol),
                    Condition(Dist(Times(Power(b, IntPart(p)), Power(Times(b, Power(Times(c, Sin(Plus(e, Times(f, x)))), n)), FracPart(p)), Power(Power(Times(c, Sin(Plus(e, Times(f, x)))), Times(n, FracPart(p))), CN1)), Int(Times(ActivateTrig(u), Power(Times(c, Sin(Plus(e, Times(f, x)))), Times(n, p))), x), x), And(FreeQ(List(b, c, e, f, n, p), x), Not(IntegerQ(p)), Not(IntegerQ(n)), Or(EqQ(u, C1), MatchQ(u, Condition(Power(Times(d_DEFAULT, $($p("§trig"), Plus(e, Times(f, x)))), m_DEFAULT), And(FreeQ(List(d, m), x), MemberQ(List($s("§sin"), $s("§cos"), $s("§tan"), $s("§cot"), $s("§sec"), $s("§csc")), $s("§trig")))))))));
            IIntegrate(3209, Int(Power(Plus(a_, Times(b_DEFAULT, Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), C4))), p_DEFAULT), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Tan(Plus(e, Times(f, x))), x))), Dist(Times($s("ff"), Power(f, CN1)), Subst(Int(Times(Power(Plus(a, Times(C2, a, Sqr($s("ff")), Sqr(x)), Times(Plus(a, b), Power($s("ff"), C4), Power(x, C4))), p), Power(Power(Plus(C1, Times(Sqr($s("ff")), Sqr(x))), Plus(Times(C2, p), C1)), CN1)), x), x, Times(Tan(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x)), And(FreeQ(List(a, b, e, f), x), IntegerQ(p))));
            IIntegrate(3210, Int(Power(Plus(a_, Times(b_DEFAULT, Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), C4))), p_), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Tan(Plus(e, Times(f, x))), x))), Dist(Times($s("ff"), Power(Plus(a, Times(b, Power(Sin(Plus(e, Times(f, x))), C4))), p), Power(Sqr(Sec(Plus(e, Times(f, x)))), Times(C2, p)), Power(Times(f, Power(Plus(a, Times(C2, a, Sqr(Tan(Plus(e, Times(f, x))))), Times(Plus(a, b), Power(Tan(Plus(e, Times(f, x))), C4))), p)), CN1)), Subst(Int(Times(Power(Plus(a, Times(C2, a, Sqr($s("ff")), Sqr(x)), Times(Plus(a, b), Power($s("ff"), C4), Power(x, C4))), p), Power(Power(Plus(C1, Times(Sqr($s("ff")), Sqr(x))), Plus(Times(C2, p), C1)), CN1)), x), x, Times(Tan(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x)), And(FreeQ(List(a, b, e, f, p), x), IntegerQ(Subtract(p, C1D2)))));
            IIntegrate(3211, Int(Power(Plus(a_, Times(b_DEFAULT, Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), n_))), CN1), x_Symbol),
                    Condition(Module(List(k), Dist(Times(C2, Power(Times(a, n), CN1)), Sum(Int(Power(Subtract(C1, Times(Sqr(Sin(Plus(e, Times(f, x)))), Power(Times(Power(CN1, Times(C4, k, Power(n, CN1))), Rt(Times(CN1, a, Power(b, CN1)), Times(C1D2, n))), CN1))), CN1), x), List(k, C1, Times(C1D2, n))), x)), And(FreeQ(List(a, b, e, f), x), IntegerQ(Times(C1D2, n)))));
            IIntegrate(3212, Int(Power(Plus(a_, Times(b_DEFAULT, Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), n_))), p_), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Tan(Plus(e, Times(f, x))), x))), Dist(Times($s("ff"), Power(f, CN1)), Subst(Int(Times(Power(Plus(Times(b, Power($s("ff"), n), Power(x, n)), Times(a, Power(Plus(C1, Times(Sqr($s("ff")), Sqr(x))), Times(C1D2, n)))), p), Power(Power(Plus(C1, Times(Sqr($s("ff")), Sqr(x))), Plus(Times(C1D2, n, p), C1)), CN1)), x), x, Times(Tan(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x)), And(FreeQ(List(a, b, e, f), x), IntegerQ(Times(C1D2, n)), IGtQ(p, C0))));
            IIntegrate(3213, Int(Power(Plus(a_, Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_))), p_), x_Symbol),
                    Condition(Int(ExpandTrig(Power(Plus(a, Times(b, Power(Times(c, $($s("§sin"), Plus(e, Times(f, x)))), n))), p), x), x), And(FreeQ(List(a, b, c, e, f, n), x), Or(IGtQ(p, C0), And(EqQ(p, CN1), IntegerQ(n))))));
            IIntegrate(3214, Int(Power(Plus(a_, Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_))), p_), x_Symbol),
                    Condition(Unintegrable(Power(Plus(a, Times(b, Power(Times(c, Sin(Plus(e, Times(f, x)))), n))), p), x), FreeQ(List(a, b, c, e, f, n, p), x)));
            IIntegrate(3215, Int(Times(Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), C4))), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Cos(Plus(e, Times(f, x))), x))), Negate(Dist(Times($s("ff"), Power(f, CN1)), Subst(Int(Times(Power(Subtract(C1, Times(Sqr($s("ff")), Sqr(x))), Times(C1D2, Subtract(m, C1))), Power(Plus(a, b, Times(CN1, C2, b, Sqr($s("ff")), Sqr(x)), Times(b, Power($s("ff"), C4), Power(x, C4))), p)), x), x, Times(Cos(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x))), And(FreeQ(List(a, b, e, f, p), x), IntegerQ(Times(C1D2, Subtract(m, C1))))));
            IIntegrate(3216, Int(Times(Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), n_))), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Cos(Plus(e, Times(f, x))), x))), Negate(Dist(Times($s("ff"), Power(f, CN1)), Subst(Int(Times(Power(Subtract(C1, Times(Sqr($s("ff")), Sqr(x))), Times(C1D2, Subtract(m, C1))), Power(Plus(a, Times(b, Power(Subtract(C1, Times(Sqr($s("ff")), Sqr(x))), Times(C1D2, n)))), p)), x), x, Times(Cos(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x))), And(FreeQ(List(a, b, e, f, p), x), IntegerQ(Times(C1D2, Subtract(m, C1))), IntegerQ(Times(C1D2, n)))));
            IIntegrate(3217, Int(Times(Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), m_), Power(Plus(a_, Times(b_DEFAULT, Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), C4))), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Tan(Plus(e, Times(f, x))), x))), Dist(Times(Power($s("ff"), Plus(m, C1)), Power(f, CN1)), Subst(Int(Times(Power(x, m), Power(Plus(a, Times(C2, a, Sqr($s("ff")), Sqr(x)), Times(Plus(a, b), Power($s("ff"), C4), Power(x, C4))), p), Power(Power(Plus(C1, Times(Sqr($s("ff")), Sqr(x))), Plus(Times(C1D2, m), Times(C2, p), C1)), CN1)), x), x, Times(Tan(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x)), And(FreeQ(List(a, b, e, f), x), IntegerQ(Times(C1D2, m)), IntegerQ(p))));
            IIntegrate(3218, Int(Times(Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), m_), Power(Plus(a_, Times(b_DEFAULT, Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), n_))), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Tan(Plus(e, Times(f, x))), x))), Dist(Times(Power($s("ff"), Plus(m, C1)), Power(f, CN1)), Subst(Int(Times(Power(x, m), Power(Plus(Times(a, Power(Plus(C1, Times(Sqr($s("ff")), Sqr(x))), Times(C1D2, n))), Times(b, Power($s("ff"), n), Power(x, n))), p), Power(Power(Plus(C1, Times(Sqr($s("ff")), Sqr(x))), Plus(Times(C1D2, m), Times(C1D2, n, p), C1)), CN1)), x), x, Times(Tan(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x)), And(FreeQ(List(a, b, e, f), x), IntegerQ(Times(C1D2, m)), IntegerQ(Times(C1D2, n)), IntegerQ(p))));
            IIntegrate(3219, Int(Times(Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), m_), Power(Plus(a_, Times(b_DEFAULT, Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), C4))), p_)), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Tan(Plus(e, Times(f, x))), x))), Dist(Times(Power($s("ff"), Plus(m, C1)), Power(Plus(a, Times(b, Power(Sin(Plus(e, Times(f, x))), C4))), p), Power(Sqr(Sec(Plus(e, Times(f, x)))), Times(C2, p)), Power(Times(f, Power(Apart(Plus(Times(a, Sqr(Plus(C1, Sqr(Tan(Plus(e, Times(f, x))))))), Times(b, Power(Tan(Plus(e, Times(f, x))), C4)))), p)), CN1)), Subst(Int(Times(Power(x, m), Power(ExpandToSum(Plus(Times(a, Sqr(Plus(C1, Times(Sqr($s("ff")), Sqr(x))))), Times(b, Power($s("ff"), C4), Power(x, C4))), x), p), Power(Power(Plus(C1, Times(Sqr($s("ff")), Sqr(x))), Plus(Times(C1D2, m), Times(C2, p), C1)), CN1)), x), x, Times(Tan(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x)), And(FreeQ(List(a, b, e, f, p), x), IntegerQ(Times(C1D2, m)), IntegerQ(Subtract(p, C1D2)))));
            IIntegrate(3220, Int(Times(Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), n_))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrig(Times(Power($($s("§sin"), Plus(e, Times(f, x))), m), Power(Plus(a, Times(b, Power($($s("§sin"), Plus(e, Times(f, x))), n))), p)), x), x), And(FreeQ(List(a, b, e, f), x), IntegersQ(m, p), Or(EqQ(n, C4), GtQ(p, C0), And(EqQ(p, CN1), IntegerQ(n))))));
            IIntegrate(3221, Int(Times(Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrig(Times(Power(Times(d, $($s("§sin"), Plus(e, Times(f, x)))), m), Power(Plus(a, Times(b, Power(Times(c, $($s("§sin"), Plus(e, Times(f, x)))), n))), p)), x), x), And(FreeQ(List(a, b, c, d, e, f, m, n), x), IGtQ(p, C0))));
            IIntegrate(3222, Int(Times(Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_))), p_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Times(d, Sin(Plus(e, Times(f, x)))), m), Power(Plus(a, Times(b, Power(Times(c, Sin(Plus(e, Times(f, x)))), n))), p)), x), FreeQ(List(a, b, c, d, e, f, m, n, p), x)));
            IIntegrate(3223, Int(Times(Power($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_))), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Sin(Plus(e, Times(f, x))), x))), Dist(Times($s("ff"), Power(f, CN1)), Subst(Int(Times(Power(Subtract(C1, Times(Sqr($s("ff")), Sqr(x))), Times(C1D2, Subtract(m, C1))), Power(Plus(a, Times(b, Power(Times(c, $s("ff"), x), n))), p)), x), x, Times(Sin(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x)), And(FreeQ(List(a, b, c, e, f, n, p), x), IntegerQ(Times(C1D2, Subtract(m, C1))), Or(EqQ(n, C4), GtQ(m, C0), IGtQ(p, C0), IntegersQ(m, p)))));
            IIntegrate(3224, Int(Times(Power($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), m_), Power(Plus(a_, Times(b_DEFAULT, Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), C4))), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Tan(Plus(e, Times(f, x))), x))), Dist(Times($s("ff"), Power(f, CN1)), Subst(Int(Times(Power(Plus(a, Times(C2, a, Sqr($s("ff")), Sqr(x)), Times(Plus(a, b), Power($s("ff"), C4), Power(x, C4))), p), Power(Power(Plus(C1, Times(Sqr($s("ff")), Sqr(x))), Plus(Times(C1D2, m), Times(C2, p), C1)), CN1)), x), x, Times(Tan(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x)), And(FreeQ(List(a, b, e, f), x), IntegerQ(Times(C1D2, m)), IntegerQ(p))));
            IIntegrate(3225, Int(Times(Power($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), m_), Power(Plus(a_, Times(b_DEFAULT, Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), n_))), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Tan(Plus(e, Times(f, x))), x))), Dist(Times($s("ff"), Power(f, CN1)), Subst(Int(Times(Power(Plus(Times(b, Power($s("ff"), n), Power(x, n)), Times(a, Power(Plus(C1, Times(Sqr($s("ff")), Sqr(x))), Times(C1D2, n)))), p), Power(Power(Plus(C1, Times(Sqr($s("ff")), Sqr(x))), Plus(Times(C1D2, m), Times(C1D2, n, p), C1)), CN1)), x), x, Times(Tan(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x)), And(FreeQ(List(a, b, e, f), x), IntegerQ(Times(C1D2, m)), IntegerQ(Times(C1D2, n)), IntegerQ(p))));
        }
    }
}
