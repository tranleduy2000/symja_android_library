package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.AppellF1;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.C6;
import static org.matheclipse.core.expression.F.C8;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.CN3;
import static org.matheclipse.core.expression.F.CN4;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
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
import static org.matheclipse.core.expression.F.Tan;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.g_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules108 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(2701, Int(Times(Sqrt(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT)), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Plus(Negate(Sqr(a)), Sqr(b)), C2))), Plus(Dist(Times(a, g, Power(Times(C2, b), CN1)), Int(Power(Times(Sqrt(Times(g, Cos(Plus(e, Times(f, x))))), Plus(q, Times(b, Cos(Plus(e, Times(f, x)))))), CN1), x), x), Negate(Dist(Times(a, g, Power(Times(C2, b), CN1)), Int(Power(Times(Sqrt(Times(g, Cos(Plus(e, Times(f, x))))), Subtract(q, Times(b, Cos(Plus(e, Times(f, x)))))), CN1), x), x)), Dist(Times(b, g, Power(f, CN1)), Subst(Int(Times(Sqrt(x), Power(Plus(Times(Sqr(g), Subtract(Sqr(a), Sqr(b))), Times(Sqr(b), Sqr(x))), CN1)), x), x, Times(g, Cos(Plus(e, Times(f, x))))), x))), And(FreeQ(List(a, b, e, f, g), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(2702, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), CN1D2), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Plus(Negate(Sqr(a)), Sqr(b)), C2))), Plus(Negate(Dist(Times(a, Power(Times(C2, q), CN1)), Int(Power(Times(Sqrt(Times(g, Cos(Plus(e, Times(f, x))))), Plus(q, Times(b, Cos(Plus(e, Times(f, x)))))), CN1), x), x)), Dist(Times(b, g, Power(f, CN1)), Subst(Int(Power(Times(Sqrt(x), Plus(Times(Sqr(g), Subtract(Sqr(a), Sqr(b))), Times(Sqr(b), Sqr(x)))), CN1), x), x, Times(g, Cos(Plus(e, Times(f, x))))), x), Negate(Dist(Times(a, Power(Times(C2, q), CN1)), Int(Power(Times(Sqrt(Times(g, Cos(Plus(e, Times(f, x))))), Subtract(q, Times(b, Cos(Plus(e, Times(f, x)))))), CN1), x), x)))), And(FreeQ(List(a, b, e, f, g), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(2703, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Simp(Times(g, Power(Times(g, Cos(Plus(e, Times(f, x)))), Subtract(p, C1)), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), AppellF1(Subtract(Negate(p), m), Times(C1D2, Subtract(C1, p)), Times(C1D2, Subtract(C1, p)), Subtract(Subtract(C1, p), m), Times(Plus(a, b), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), CN1)), Times(Subtract(a, b), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), CN1))), Power(Times(b, f, Plus(m, p), Power(Times(CN1, b, Subtract(C1, Sin(Plus(e, Times(f, x)))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), CN1)), Times(C1D2, Subtract(p, C1))), Power(Times(b, Plus(C1, Sin(Plus(e, Times(f, x)))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), CN1)), Times(C1D2, Subtract(p, C1)))), CN1)), x), And(FreeQ(List(a, b, e, f, g, p), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), ILtQ(m, C0), Not(IGtQ(Plus(m, p, C1), C0)))));
            IIntegrate(2704, Int(Times(Power(Times($($s("§cos"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), g_DEFAULT), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_)), x_Symbol),
                    Condition(Dist(Times(g, Power(Times(g, Cos(Plus(e, Times(f, x)))), Subtract(p, C1)), Power(Times(f, Power(Subtract(C1, Times(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Power(Subtract(a, b), CN1))), Times(C1D2, Subtract(p, C1))), Power(Subtract(C1, Times(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Power(Plus(a, b), CN1))), Times(C1D2, Subtract(p, C1)))), CN1)), Subst(Int(Times(Power(Subtract(Times(CN1, b, Power(Subtract(a, b), CN1)), Times(b, x, Power(Subtract(a, b), CN1))), Times(C1D2, Subtract(p, C1))), Power(Subtract(Times(b, Power(Plus(a, b), CN1)), Times(b, x, Power(Plus(a, b), CN1))), Times(C1D2, Subtract(p, C1))), Power(Plus(a, Times(b, x)), m)), x), x, Sin(Plus(e, Times(f, x)))), x), And(FreeQ(List(a, b, e, f, g, m, p), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), Not(IGtQ(m, C0)))));
            IIntegrate(2705, Int(Times(Power(Times(g_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), p_), Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(g, Times(C2, IntPart(p))), Power(Times(g, Cos(Plus(e, Times(f, x)))), FracPart(p)), Power(Times(g, Sec(Plus(e, Times(f, x)))), FracPart(p))), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Power(Times(g, Cos(Plus(e, Times(f, x)))), p), CN1)), x), x), And(FreeQ(List(a, b, e, f, g, m, p), x), Not(IntegerQ(p)))));
            IIntegrate(2706, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), CN1), Power(Times(g_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), p_DEFAULT)), x_Symbol),
                    Condition(Subtract(Dist(Power(a, CN1), Int(Times(Sqr(Sec(Plus(e, Times(f, x)))), Power(Times(g, Tan(Plus(e, Times(f, x)))), p)), x), x), Dist(Power(Times(b, g), CN1), Int(Times(Sec(Plus(e, Times(f, x))), Power(Times(g, Tan(Plus(e, Times(f, x)))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, e, f, g, p), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), NeQ(p, CN1))));
            IIntegrate(2707, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(f, CN1), Subst(Int(Times(Power(x, p), Power(Plus(a, x), Subtract(m, Times(C1D2, Plus(p, C1)))), Power(Power(Subtract(a, x), Times(C1D2, Plus(p, C1))), CN1)), x), x, Times(b, Sin(Plus(e, Times(f, x))))), x), And(FreeQ(List(a, b, e, f, m), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegerQ(Times(C1D2, Plus(p, C1))))));
            IIntegrate(2708, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), p_)), x_Symbol),
                    Condition(Dist(Power(a, p), Int(Times(Power(Sin(Plus(e, Times(f, x))), p), Power(Power(Subtract(a, Times(b, Sin(Plus(e, Times(f, x))))), m), CN1)), x), x), And(FreeQ(List(a, b, e, f), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegersQ(m, p), EqQ(p, Times(C2, m)))));
            IIntegrate(2709, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), p_)), x_Symbol),
                    Condition(Dist(Power(a, p), Int(ExpandIntegrand(Times(Power(Sin(Plus(e, Times(f, x))), p), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Subtract(m, Times(C1D2, p))), Power(Power(Subtract(a, Times(b, Sin(Plus(e, Times(f, x))))), Times(C1D2, p)), CN1)), x), x), x), And(FreeQ(List(a, b, e, f), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegersQ(m, Times(C1D2, p)), Or(LtQ(p, C0), GtQ(Subtract(m, Times(C1D2, p)), C0)))));
            IIntegrate(2710, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Times(g_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Times(g, Tan(Plus(e, Times(f, x)))), p), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), x), x), And(FreeQ(List(a, b, e, f, g, p), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IGtQ(m, C0))));
            IIntegrate(2711, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Times(g_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(a, Times(C2, m)), Int(ExpandIntegrand(Times(Power(Times(g, Tan(Plus(e, Times(f, x)))), p), Power(Power(Sec(Plus(e, Times(f, x))), m), CN1)), Power(Subtract(Times(a, Sec(Plus(e, Times(f, x)))), Times(b, Tan(Plus(e, Times(f, x))))), Negate(m)), x), x), x), And(FreeQ(List(a, b, e, f, g, p), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), ILtQ(m, C0))));
            IIntegrate(2712, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Sqr($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), x_Symbol),
                    Condition(Subtract(Simp(Times(b, Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Times(a, f, Subtract(Times(C2, m), C1), Cos(Plus(e, Times(f, x)))), CN1)), x), Dist(Power(Times(Sqr(a), Subtract(Times(C2, m), C1)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Subtract(Times(a, m), Times(b, Subtract(Times(C2, m), C1), Sin(Plus(e, Times(f, x))))), Power(Cos(Plus(e, Times(f, x))), CN2)), x), x)), And(FreeQ(List(a, b, e, f), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), Not(IntegerQ(m)), LtQ(m, C0))));
            IIntegrate(2713, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Sqr($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(b, f, m, Cos(Plus(e, Times(f, x)))), CN1)), x)), Dist(Power(Times(b, m), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Plus(Times(b, Plus(m, C1)), Times(a, Sin(Plus(e, Times(f, x))))), Power(Cos(Plus(e, Times(f, x))), CN2)), x), x)), And(FreeQ(List(a, b, e, f, m), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), Not(IntegerQ(m)), Not(LtQ(m, C0)))));
            IIntegrate(2714, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), C4)), x_Symbol),
                    Condition(Subtract(Int(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), x), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Subtract(C1, Times(C2, Sqr(Sin(Plus(e, Times(f, x)))))), Power(Cos(Plus(e, Times(f, x))), CN4)), x)), And(FreeQ(List(a, b, e, f, m), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegerQ(Subtract(m, C1D2)))));
            IIntegrate(2715, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), CN2)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(a, f, Tan(Plus(e, Times(f, x)))), CN1)), x)), Dist(Power(b, CN2), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Subtract(Times(b, m), Times(a, Plus(m, C1), Sin(Plus(e, Times(f, x))))), Power(Sin(Plus(e, Times(f, x))), CN1)), x), x)), And(FreeQ(List(a, b, e, f), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegerQ(Subtract(m, C1D2)), LtQ(m, CN1))));
            IIntegrate(2716, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), CN2)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Power(Times(f, Tan(Plus(e, Times(f, x)))), CN1)), x)), Dist(Power(a, CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Subtract(Times(b, m), Times(a, Plus(m, C1), Sin(Plus(e, Times(f, x))))), Power(Sin(Plus(e, Times(f, x))), CN1)), x), x)), And(FreeQ(List(a, b, e, f, m), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegerQ(Subtract(m, C1D2)), Not(LtQ(m, CN1)))));
            IIntegrate(2717, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), CN4)), x_Symbol),
                    Condition(Plus(Dist(Times(CN2, Power(Times(a, b), CN1)), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C2)), Power(Sin(Plus(e, Times(f, x))), CN3)), x), x), Dist(Power(a, CN2), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C2)), Plus(C1, Sqr(Sin(Plus(e, Times(f, x))))), Power(Sin(Plus(e, Times(f, x))), CN4)), x), x)), And(FreeQ(List(a, b, e, f), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegerQ(Subtract(m, C1D2)), LtQ(m, CN1))));
            IIntegrate(2718, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), CN4)), x_Symbol),
                    Condition(Plus(Int(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), x), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Subtract(C1, Times(C2, Sqr(Sin(Plus(e, Times(f, x)))))), Power(Sin(Plus(e, Times(f, x))), CN4)), x)), And(FreeQ(List(a, b, e, f, m), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), IntegerQ(Subtract(m, C1D2)), Not(LtQ(m, CN1)))));
            IIntegrate(2719, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), p_)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Plus(a, Times(b, Sin(Plus(e, Times(f, x)))))), Sqrt(Subtract(a, Times(b, Sin(Plus(e, Times(f, x)))))), Power(Times(b, f, Cos(Plus(e, Times(f, x)))), CN1)), Subst(Int(Times(Power(x, p), Power(Plus(a, x), Subtract(m, Times(C1D2, Plus(p, C1)))), Power(Power(Subtract(a, x), Times(C1D2, Plus(p, C1))), CN1)), x), x, Times(b, Sin(Plus(e, Times(f, x))))), x), And(FreeQ(List(a, b, e, f, m), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), Not(IntegerQ(m)), IntegerQ(Times(C1D2, p)))));
            IIntegrate(2720, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power(Times(g_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Times(g, Tan(Plus(e, Times(f, x)))), Plus(p, C1)), Power(Subtract(a, Times(b, Sin(Plus(e, Times(f, x))))), Times(C1D2, Plus(p, C1))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Times(C1D2, Plus(p, C1))), Power(Times(f, g, Power(Times(b, Sin(Plus(e, Times(f, x)))), Plus(p, C1))), CN1)), Subst(Int(Times(Power(x, p), Power(Plus(a, x), Subtract(m, Times(C1D2, Plus(p, C1)))), Power(Power(Subtract(a, x), Times(C1D2, Plus(p, C1))), CN1)), x), x, Times(b, Sin(Plus(e, Times(f, x))))), x), And(FreeQ(List(a, b, e, f, g, m, p), x), EqQ(Subtract(Sqr(a), Sqr(b)), C0), Not(IntegerQ(m)), Not(IntegerQ(p)))));
            IIntegrate(2721, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(f, CN1), Subst(Int(Times(Power(x, p), Power(Plus(a, x), m), Power(Power(Subtract(Sqr(b), Sqr(x)), Times(C1D2, Plus(p, C1))), CN1)), x), x, Times(b, Sin(Plus(e, Times(f, x))))), x), And(FreeQ(List(a, b, e, f, m), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), IntegerQ(Times(C1D2, Plus(p, C1))))));
            IIntegrate(2722, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_DEFAULT), Power(Times(g_DEFAULT, $($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Times(g, Tan(Plus(e, Times(f, x)))), p), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), x), x), And(FreeQ(List(a, b, e, f, g, p), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), IGtQ(m, C0))));
            IIntegrate(2723, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), CN2)), x_Symbol),
                    Condition(Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Subtract(C1, Sqr(Sin(Plus(e, Times(f, x))))), Power(Sin(Plus(e, Times(f, x))), CN2)), x), And(FreeQ(List(a, b, e, f, m), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0))));
            IIntegrate(2724, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), CN4)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(C3, a, f, Power(Sin(Plus(e, Times(f, x))), C3)), CN1)), x)), Negate(Dist(Power(Times(C3, Sqr(a), b, Plus(m, C1)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Simp(Subtract(Plus(Times(C6, Sqr(a)), Times(CN1, Sqr(b), Subtract(m, C1), Subtract(m, C2)), Times(a, b, Plus(m, C1), Sin(Plus(e, Times(f, x))))), Times(Subtract(Times(C3, Sqr(a)), Times(Sqr(b), m, Subtract(m, C2))), Sqr(Sin(Plus(e, Times(f, x)))))), x), Power(Sin(Plus(e, Times(f, x))), CN3)), x), x)), Negate(Simp(Times(Plus(Times(C3, Sqr(a)), Times(Sqr(b), Subtract(m, C2))), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(C3, Sqr(a), b, f, Plus(m, C1), Sqr(Sin(Plus(e, Times(f, x))))), CN1)), x))), And(FreeQ(List(a, b, e, f), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), LtQ(m, CN1), IntegerQ(Times(C2, m)))));
            IIntegrate(2725, Int(Times(Power(Plus(a_, Times(b_DEFAULT, $($s("§sin"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))))), m_), Power($($s("§tan"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), CN4)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(C3, a, f, Power(Sin(Plus(e, Times(f, x))), C3)), CN1)), x)), Negate(Dist(Power(Times(C6, Sqr(a)), CN1), Int(Times(Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), m), Simp(Subtract(Plus(Times(C8, Sqr(a)), Times(CN1, Sqr(b), Subtract(m, C1), Subtract(m, C2)), Times(a, b, m, Sin(Plus(e, Times(f, x))))), Times(Subtract(Times(C6, Sqr(a)), Times(Sqr(b), m, Subtract(m, C2))), Sqr(Sin(Plus(e, Times(f, x)))))), x), Power(Sin(Plus(e, Times(f, x))), CN2)), x), x)), Negate(Simp(Times(b, Subtract(m, C2), Cos(Plus(e, Times(f, x))), Power(Plus(a, Times(b, Sin(Plus(e, Times(f, x))))), Plus(m, C1)), Power(Times(C6, Sqr(a), f, Sqr(Sin(Plus(e, Times(f, x))))), CN1)), x))), And(FreeQ(List(a, b, e, f, m), x), NeQ(Subtract(Sqr(a), Sqr(b)), C0), Not(LtQ(m, CN1)), IntegerQ(Times(C2, m)))));
        }
    }
}
