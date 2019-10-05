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
import static org.matheclipse.core.expression.F.CN2;
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
import static org.matheclipse.core.expression.F.Subtract;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules165 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(4126, Int(Times(u_DEFAULT, Power(Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_)), p_)), x_Symbol),
                    Condition(Dist(Times(Power(b, IntPart(p)), Power(Times(b, Power(Times(c, Sec(Plus(e, Times(f, x)))), n)), FracPart(p)), Power(Power(Times(c, Sec(Plus(e, Times(f, x)))), Times(n, FracPart(p))), CN1)), Int(Times(ActivateTrig(u), Power(Times(c, Sec(Plus(e, Times(f, x)))), Times(n, p))), x), x), And(FreeQ(List(b, c, e, f, n, p), x), Not(IntegerQ(p)), Not(IntegerQ(n)), Or(EqQ(u, C1), MatchQ(u, Condition(Power(Times(d_DEFAULT, $($p("§trig"), Plus(e, Times(f, x)))), m_DEFAULT), And(FreeQ(List(d, m), x), MemberQ(List($s("§sin"), $s("§cos"), $s("§tan"), $s("§cot"), $s("§sec"), $s("§csc")), $s("§trig")))))))));
            IIntegrate(4127, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), CN1), x_Symbol),
                    Condition(Subtract(Simp(Times(x, Power(a, CN1)), x), Dist(Times(b, Power(a, CN1)), Int(Power(Plus(b, Times(a, Sqr(Cos(Plus(e, Times(f, x)))))), CN1), x), x)), And(FreeQ(List(a, b, e, f), x), NeQ(Plus(a, b), C0))));
            IIntegrate(4128, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))))), p_), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Tan(Plus(e, Times(f, x))), x))), Dist(Times($s("ff"), Power(f, CN1)), Subst(Int(Times(Power(Plus(a, b, Times(b, Sqr($s("ff")), Sqr(x))), p), Power(Plus(C1, Times(Sqr($s("ff")), Sqr(x))), CN1)), x), x, Times(Tan(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x)), And(FreeQ(List(a, b, e, f, p), x), NeQ(Plus(a, b), C0), NeQ(p, CN1))));
            IIntegrate(4129, Int(Power(Plus(a_, Times(b_DEFAULT, Power($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), C4))), p_), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Tan(Plus(e, Times(f, x))), x))), Dist(Times($s("ff"), Power(f, CN1)), Subst(Int(Times(Power(Plus(a, b, Times(C2, b, Sqr($s("ff")), Sqr(x)), Times(b, Power($s("ff"), C4), Power(x, C4))), p), Power(Plus(C1, Times(Sqr($s("ff")), Sqr(x))), CN1)), x), x, Times(Tan(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x)), And(FreeQ(List(a, b, e, f, p), x), IntegerQ(Times(C2, p)))));
            IIntegrate(4130, Int(Power(Plus(a_, Times(b_DEFAULT, Power($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), n_))), p_), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Tan(Plus(e, Times(f, x))), x))), Dist(Times($s("ff"), Power(f, CN1)), Subst(Int(Times(Power(Plus(a, Times(b, Power(Plus(C1, Times(Sqr($s("ff")), Sqr(x))), Times(C1D2, n)))), p), Power(Plus(C1, Times(Sqr($s("ff")), Sqr(x))), CN1)), x), x, Times(Tan(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x)), And(FreeQ(List(a, b, e, f, p), x), IntegerQ(Times(C1D2, n)), IGtQ(p, CN2))));
            IIntegrate(4131, Int(Power(Plus(a_, Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_))), p_), x_Symbol),
                    Condition(Unintegrable(Power(Plus(a, Times(b, Power(Times(c, Sec(Plus(e, Times(f, x)))), n))), p), x), FreeQ(List(a, b, c, e, f, n, p), x)));
            IIntegrate(4132, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), n_))), p_DEFAULT), Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), m_)), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Tan(Plus(e, Times(f, x))), x))), Dist(Times(Power($s("ff"), Plus(m, C1)), Power(f, CN1)), Subst(Int(Times(Power(x, m), Power(ExpandToSum(Plus(a, Times(b, Power(Plus(C1, Times(Sqr($s("ff")), Sqr(x))), Times(C1D2, n)))), x), p), Power(Power(Plus(C1, Times(Sqr($s("ff")), Sqr(x))), Plus(Times(C1D2, m), C1)), CN1)), x), x, Times(Tan(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x)), And(FreeQ(List(a, b, e, f, p), x), IntegerQ(Times(C1D2, m)), IntegerQ(Times(C1D2, n)))));
            IIntegrate(4133, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), n_))), p_DEFAULT), Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Cos(Plus(e, Times(f, x))), x))), Negate(Dist(Times($s("ff"), Power(f, CN1)), Subst(Int(Times(Power(Subtract(C1, Times(Sqr($s("ff")), Sqr(x))), Times(C1D2, Subtract(m, C1))), Power(Plus(b, Times(a, Power(Times($s("ff"), x), n))), p), Power(Power(Times($s("ff"), x), Times(n, p)), CN1)), x), x, Times(Cos(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x))), And(FreeQ(List(a, b, e, f), x), IntegerQ(Times(C1D2, Subtract(m, C1))), IntegerQ(n), IntegerQ(p))));
            IIntegrate(4134, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_))), p_DEFAULT), Power($($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Cos(Plus(e, Times(f, x))), x))), Dist(Power(Times(f, Power($s("ff"), m)), CN1), Subst(Int(Times(Power(Plus(CN1, Times(Sqr($s("ff")), Sqr(x))), Times(C1D2, Subtract(m, C1))), Power(Plus(a, Times(b, Power(Times(c, $s("ff"), x), n))), p), Power(Power(x, Plus(m, C1)), CN1)), x), x, Times(Sec(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x)), And(FreeQ(List(a, b, c, e, f, n, p), x), IntegerQ(Times(C1D2, Subtract(m, C1))), Or(GtQ(m, C0), EqQ(n, C2), EqQ(n, C4)))));
            IIntegrate(4135, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_))), p_DEFAULT), Power(Times(d_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(a, Times(b, Power(Times(c, Sec(Plus(e, Times(f, x)))), n))), p), Power(Times(d, Sin(Plus(e, Times(f, x)))), m)), x), FreeQ(List(a, b, c, d, e, f, m, n, p), x)));
            IIntegrate(4136, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), m_), Power(Plus(a_, Times(b_DEFAULT, Power($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), n_DEFAULT))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(d, Times(n, p)), Int(Times(Power(Times(d, Cos(Plus(e, Times(f, x)))), Subtract(m, Times(n, p))), Power(Plus(b, Times(a, Power(Cos(Plus(e, Times(f, x))), n))), p)), x), x), And(FreeQ(List(a, b, d, e, f, m, n, p), x), Not(IntegerQ(m)), IntegersQ(n, p))));
            IIntegrate(4137, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), m_), Power(Plus(a_, Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Times(d, Cos(Plus(e, Times(f, x)))), FracPart(m)), Power(Times(Sec(Plus(e, Times(f, x))), Power(d, CN1)), FracPart(m))), Int(Times(Power(Plus(a, Times(b, Power(Times(c, Sec(Plus(e, Times(f, x)))), n))), p), Power(Power(Times(Sec(Plus(e, Times(f, x))), Power(d, CN1)), m), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), Not(IntegerQ(m)))));
            IIntegrate(4138, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), n_))), p_DEFAULT), Power($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), m_DEFAULT)), x_Symbol),
                    Condition(Module(List(Set($s("ff"), FreeFactors(Cos(Plus(e, Times(f, x))), x))), Negate(Dist(Power(Times(f, Power($s("ff"), Subtract(Plus(m, Times(n, p)), C1))), CN1), Subst(Int(Times(Power(Subtract(C1, Times(Sqr($s("ff")), Sqr(x))), Times(C1D2, Subtract(m, C1))), Power(Plus(b, Times(a, Power(Times($s("ff"), x), n))), p), Power(Power(x, Plus(m, Times(n, p))), CN1)), x), x, Times(Cos(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x))), And(FreeQ(List(a, b, e, f, n), x), IntegerQ(Times(C1D2, Subtract(m, C1))), IntegerQ(n), IntegerQ(p))));
            IIntegrate(4139, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_))), p_DEFAULT), Power($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Sec(Plus(e, Times(f, x))), x))), Dist(Power(f, CN1), Subst(Int(Times(Power(Plus(CN1, Times(Sqr($s("ff")), Sqr(x))), Times(C1D2, Subtract(m, C1))), Power(Plus(a, Times(b, Power(Times(c, $s("ff"), x), n))), p), Power(x, CN1)), x), x, Times(Sec(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x)), And(FreeQ(List(a, b, c, e, f, n, p), x), IntegerQ(Times(C1D2, Subtract(m, C1))), Or(GtQ(m, C0), EqQ(n, C2), EqQ(n, C4), IGtQ(p, C0), IntegersQ(Times(C2, n), p)))));
            IIntegrate(4140, Int(Times(Power(Times(b_DEFAULT, Sqr($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), p_DEFAULT), Power(Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_)), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Tan(Plus(e, Times(f, x))), x))), Dist(Times(b, $s("ff"), Power(f, CN1)), Subst(Int(Times(Power(Times(d, $s("ff"), x), m), Power(Plus(b, Times(b, Sqr($s("ff")), Sqr(x))), Subtract(p, C1))), x), x, Times(Tan(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x)), FreeQ(List(b, d, e, f, m, p), x)));
            IIntegrate(4141, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), n_))), p_DEFAULT), Power(Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_)), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Tan(Plus(e, Times(f, x))), x))), Dist(Times($s("ff"), Power(f, CN1)), Subst(Int(Times(Power(Times(d, $s("ff"), x), m), Power(Plus(a, Times(b, Power(Plus(C1, Times(Sqr($s("ff")), Sqr(x))), Times(C1D2, n)))), p), Power(Plus(C1, Times(Sqr($s("ff")), Sqr(x))), CN1)), x), x, Times(Tan(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x)), And(FreeQ(List(a, b, d, e, f, m, p), x), IntegerQ(Times(C1D2, n)), Or(IntegerQ(Times(C1D2, m)), EqQ(n, C2)))));
            IIntegrate(4142, Int(Times(Power(Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_)), p_DEFAULT), Power(Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_)), x_Symbol),
                    Condition(Subtract(Simp(Times(d, Power(Times(d, Tan(Plus(e, Times(f, x)))), Subtract(m, C1)), Power(Times(b, Power(Times(c, Sec(Plus(e, Times(f, x)))), n)), p), Power(Times(f, Subtract(Plus(Times(p, n), m), C1)), CN1)), x), Dist(Times(Sqr(d), Subtract(m, C1), Power(Subtract(Plus(Times(p, n), m), C1), CN1)), Int(Times(Power(Times(d, Tan(Plus(e, Times(f, x)))), Subtract(m, C2)), Power(Times(b, Power(Times(c, Sec(Plus(e, Times(f, x)))), n)), p)), x), x)), And(FreeQ(List(b, c, d, e, f, p, n), x), GtQ(m, C1), NeQ(Subtract(Plus(Times(p, n), m), C1), C0), IntegersQ(Times(C2, p, n), Times(C2, m)))));
            IIntegrate(4143, Int(Times(Power(Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_)), p_DEFAULT), Power(Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(d, Tan(Plus(e, Times(f, x)))), Plus(m, C1)), Power(Times(b, Power(Times(c, Sec(Plus(e, Times(f, x)))), n)), p), Power(Times(d, f, Plus(m, C1)), CN1)), x), Dist(Times(Plus(Times(p, n), m, C1), Power(Times(Sqr(d), Plus(m, C1)), CN1)), Int(Times(Power(Times(d, Tan(Plus(e, Times(f, x)))), Plus(m, C2)), Power(Times(b, Power(Times(c, Sec(Plus(e, Times(f, x)))), n)), p)), x), x)), And(FreeQ(List(b, c, d, e, f, p, n), x), LtQ(m, CN1), NeQ(Plus(Times(p, n), m, C1), C0), IntegersQ(Times(C2, p, n), Times(C2, m)))));
            IIntegrate(4144, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_))), p_DEFAULT), Power(Times(d_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Plus(a, Times(b, Power(Times(c, Sec(Plus(e, Times(f, x)))), n))), p), Power(Times(d, Tan(Plus(e, Times(f, x)))), m)), x), FreeQ(List(a, b, c, d, e, f, m, n, p), x)));
            IIntegrate(4145, Int(Times(Power(Times($($s("§cot"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), m_), Power(Plus(a_, Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Times(d, Cot(Plus(e, Times(f, x)))), FracPart(m)), Power(Times(Tan(Plus(e, Times(f, x))), Power(d, CN1)), FracPart(m))), Int(Times(Power(Plus(a, Times(b, Power(Times(c, Sec(Plus(e, Times(f, x)))), n))), p), Power(Power(Times(Tan(Plus(e, Times(f, x))), Power(d, CN1)), m), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), Not(IntegerQ(m)))));
            IIntegrate(4146, Int(Times(Power($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), m_), Power(Plus(a_, Times(b_DEFAULT, Power($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), n_))), p_)), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Tan(Plus(e, Times(f, x))), x))), Dist(Times($s("ff"), Power(f, CN1)), Subst(Int(Times(Power(Plus(C1, Times(Sqr($s("ff")), Sqr(x))), Subtract(Times(C1D2, m), C1)), Power(ExpandToSum(Plus(a, Times(b, Power(Plus(C1, Times(Sqr($s("ff")), Sqr(x))), Times(C1D2, n)))), x), p)), x), x, Times(Tan(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x)), And(FreeQ(List(a, b, e, f, p), x), IntegerQ(Times(C1D2, m)), IntegerQ(Times(C1D2, n)))));
            IIntegrate(4147, Int(Times(Power($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), n_))), p_)), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Sin(Plus(e, Times(f, x))), x))), Dist(Times($s("ff"), Power(f, CN1)), Subst(Int(Times(Power(ExpandToSum(Plus(b, Times(a, Power(Subtract(C1, Times(Sqr($s("ff")), Sqr(x))), Times(C1D2, n)))), x), p), Power(Power(Subtract(C1, Times(Sqr($s("ff")), Sqr(x))), Times(C1D2, Plus(m, Times(n, p), C1))), CN1)), x), x, Times(Sin(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x)), And(FreeQ(List(a, b, e, f), x), IntegerQ(Times(C1D2, Subtract(m, C1))), IntegerQ(Times(C1D2, n)), IntegerQ(p))));
            IIntegrate(4148, Int(Times(Power($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), n_))), p_)), x_Symbol),
                    Condition(With(List(Set($s("ff"), FreeFactors(Sin(Plus(e, Times(f, x))), x))), Dist(Times($s("ff"), Power(f, CN1)), Subst(Int(Times(Power(Plus(a, Times(b, Power(Power(Subtract(C1, Times(Sqr($s("ff")), Sqr(x))), Times(C1D2, n)), CN1))), p), Power(Power(Subtract(C1, Times(Sqr($s("ff")), Sqr(x))), Times(C1D2, Plus(m, C1))), CN1)), x), x, Times(Sin(Plus(e, Times(f, x))), Power($s("ff"), CN1))), x)), And(FreeQ(List(a, b, e, f, p), x), IntegerQ(Times(C1D2, Subtract(m, C1))), IntegerQ(Times(C1D2, n)), Not(IntegerQ(p)))));
            IIntegrate(4149, Int(Times(Power($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power($($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), n_))), p_)), x_Symbol),
                    Condition(Int(ExpandTrig(Times(Power($($s("§sec"), Plus(e, Times(f, x))), m), Power(Plus(a, Times(b, Power($($s("§sec"), Plus(e, Times(f, x))), n))), p)), x), x), And(FreeQ(List(a, b, e, f), x), IntegersQ(m, n, p))));
            IIntegrate(4150, Int(Times(Power(Times(d_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_))), p_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times(Power(Times(d, Sec(Plus(e, Times(f, x)))), m), Power(Plus(a, Times(b, Power(Times(c, Sec(Plus(e, Times(f, x)))), n))), p)), x), FreeQ(List(a, b, c, d, e, f, m, n, p), x)));
        }
    }
}
