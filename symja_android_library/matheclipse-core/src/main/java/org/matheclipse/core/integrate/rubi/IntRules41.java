package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.ASymbol;
import static org.matheclipse.core.expression.F.A_DEFAULT;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcTan;
import static org.matheclipse.core.expression.F.BSymbol;
import static org.matheclipse.core.expression.F.B_DEFAULT;
import static org.matheclipse.core.expression.F.C;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C1D3;
import static org.matheclipse.core.expression.F.C1DSqrt3;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.C9;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN1D3;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.CN4;
import static org.matheclipse.core.expression.F.CN9;
import static org.matheclipse.core.expression.F.CSqrt3;
import static org.matheclipse.core.expression.F.C_DEFAULT;
import static org.matheclipse.core.expression.F.Coefficient;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.LeafCount;
import static org.matheclipse.core.expression.F.LessEqual;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.QQ;
import static org.matheclipse.core.expression.F.Set;
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
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.g_;
import static org.matheclipse.core.expression.F.g_DEFAULT;
import static org.matheclipse.core.expression.F.h;
import static org.matheclipse.core.expression.F.h_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.s;
import static org.matheclipse.core.expression.F.t;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NegQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules41 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(1026, Int(Times(x_, Power(Plus(a_, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1), Power(Plus(d_, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(CN2, e), Subst(Int(Times(Subtract(C1, Times(d, Sqr(x))), Power(Plus(Times(c, e), Times(CN1, b, f), Times(CN1, e, Plus(Times(C2, c, d), Times(CN1, b, e), Times(C2, a, f)), Sqr(x)), Times(Sqr(d), Subtract(Times(c, e), Times(b, f)), Power(x, C4))), CN1)), x), x, Times(Plus(C1, Times(Plus(e, Sqrt(Subtract(Sqr(e), Times(C4, d, f)))), x, Power(Times(C2, d), CN1))), Power(Plus(d, Times(e, x), Times(f, Sqr(x))), CN1D2))), x), And(FreeQ(List(a, b, c, d, e, f), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Subtract(Sqr(e), Times(C4, d, f)), C0), EqQ(Subtract(Times(b, d), Times(a, e)), C0))));
            IIntegrate(1027, Int(Times(Plus(g_, Times(h_DEFAULT, x_)), Power(Plus(a_, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1), Power(Plus(d_, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(g, Subst(Int(Power(Plus(a, Times(Subtract(Times(c, d), Times(a, f)), Sqr(x))), CN1), x), x, Times(x, Power(Plus(d, Times(e, x), Times(f, Sqr(x))), CN1D2))), x), And(FreeQ(List(a, b, c, d, e, f, g, h), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Subtract(Sqr(e), Times(C4, d, f)), C0), EqQ(Subtract(Times(b, d), Times(a, e)), C0), EqQ(Subtract(Times(C2, h, d), Times(g, e)), C0))));
            IIntegrate(1028, Int(Times(Plus(g_, Times(h_DEFAULT, x_)), Power(Plus(a_, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1), Power(Plus(d_, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Plus(Negate(Dist(Times(Subtract(Times(C2, h, d), Times(g, e)), Power(e, CN1)), Int(Power(Times(Plus(a, Times(b, x), Times(c, Sqr(x))), Sqrt(Plus(d, Times(e, x), Times(f, Sqr(x))))), CN1), x), x)), Dist(Times(h, Power(e, CN1)), Int(Times(Plus(Times(C2, d), Times(e, x)), Power(Times(Plus(a, Times(b, x), Times(c, Sqr(x))), Sqrt(Plus(d, Times(e, x), Times(f, Sqr(x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, h), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Subtract(Sqr(e), Times(C4, d, f)), C0), EqQ(Subtract(Times(b, d), Times(a, e)), C0), NeQ(Subtract(Times(C2, h, d), Times(g, e)), C0))));
            IIntegrate(1029, Int(Times(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(CN2, g, Subtract(Times(g, b), Times(C2, a, h))), Subst(Int(Power(Simp(Subtract(Times(g, Subtract(Times(g, b), Times(C2, a, h)), Subtract(Sqr(b), Times(C4, a, c))), Times(Subtract(Times(b, d), Times(a, e)), Sqr(x))), x), CN1), x), x, Times(Simp(Subtract(Subtract(Times(g, b), Times(C2, a, h)), Times(Subtract(Times(b, h), Times(C2, g, c)), x)), x), Power(Plus(d, Times(e, x), Times(f, Sqr(x))), CN1D2))), x), And(FreeQ(List(a, b, c, d, e, f, g, h), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Subtract(Sqr(e), Times(C4, d, f)), C0), NeQ(Subtract(Times(b, d), Times(a, e)), C0), EqQ(Plus(Times(Sqr(h), Subtract(Times(b, d), Times(a, e))), Times(CN1, C2, g, h, Subtract(Times(c, d), Times(a, f))), Times(Sqr(g), Subtract(Times(c, e), Times(b, f)))), C0))));
            IIntegrate(1030, Int(Times(Plus(g_, Times(h_DEFAULT, x_)), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), CN1), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(CN2, a, g, h), Subst(Int(Power(Simp(Plus(Times(C2, Sqr(a), g, h, c), Times(a, e, Sqr(x))), x), CN1), x), x, Times(Simp(Subtract(Times(a, h), Times(g, c, x)), x), Power(Plus(d, Times(e, x), Times(f, Sqr(x))), CN1D2))), x), And(FreeQ(List(a, c, d, e, f, g, h), x), EqQ(Subtract(Plus(Times(a, Sqr(h), e), Times(C2, g, h, Subtract(Times(c, d), Times(a, f)))), Times(Sqr(g), c, e)), C0))));
            IIntegrate(1031, Int(Times(Plus(g_, Times(h_DEFAULT, x_)), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1), Power(Plus(d_, Times(f_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(CN2, g, Subtract(Times(g, b), Times(C2, a, h))), Subst(Int(Power(Simp(Subtract(Times(g, Subtract(Times(g, b), Times(C2, a, h)), Subtract(Sqr(b), Times(C4, a, c))), Times(b, d, Sqr(x))), x), CN1), x), x, Times(Simp(Subtract(Subtract(Times(g, b), Times(C2, a, h)), Times(Subtract(Times(b, h), Times(C2, g, c)), x)), x), Power(Plus(d, Times(f, Sqr(x))), CN1D2))), x), And(FreeQ(List(a, b, c, d, f, g, h), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Subtract(Subtract(Times(b, Sqr(h), d), Times(C2, g, h, Subtract(Times(c, d), Times(a, f)))), Times(Sqr(g), b, f)), C0))));
            IIntegrate(1032, Int(Times(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), Power(Plus(a_, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Subtract(Dist(Times(Subtract(Times(C2, c, g), Times(h, Subtract(b, q))), Power(q, CN1)), Int(Power(Times(Plus(b, Negate(q), Times(C2, c, x)), Sqrt(Plus(d, Times(e, x), Times(f, Sqr(x))))), CN1), x), x), Dist(Times(Subtract(Times(C2, c, g), Times(h, Plus(b, q))), Power(q, CN1)), Int(Power(Times(Plus(b, q, Times(C2, c, x)), Sqrt(Plus(d, Times(e, x), Times(f, Sqr(x))))), CN1), x), x))), And(FreeQ(List(a, b, c, d, e, f, g, h), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Subtract(Sqr(e), Times(C4, d, f)), C0), PosQ(Subtract(Sqr(b), Times(C4, a, c))))));
            IIntegrate(1033, Int(Times(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), CN1), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(CN1, a, c), C2))), Plus(Dist(Plus(Times(C1D2, h), Times(c, g, Power(Times(C2, q), CN1))), Int(Power(Times(Plus(Negate(q), Times(c, x)), Sqrt(Plus(d, Times(e, x), Times(f, Sqr(x))))), CN1), x), x), Dist(Subtract(Times(C1D2, h), Times(c, g, Power(Times(C2, q), CN1))), Int(Power(Times(Plus(q, Times(c, x)), Sqrt(Plus(d, Times(e, x), Times(f, Sqr(x))))), CN1), x), x))), And(FreeQ(List(a, c, d, e, f, g, h), x), NeQ(Subtract(Sqr(e), Times(C4, d, f)), C0), PosQ(Times(CN1, a, c)))));
            IIntegrate(1034, Int(Times(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), Power(Plus(a_, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1), Power(Plus(d_, Times(f_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Subtract(Dist(Times(Subtract(Times(C2, c, g), Times(h, Subtract(b, q))), Power(q, CN1)), Int(Power(Times(Plus(b, Negate(q), Times(C2, c, x)), Sqrt(Plus(d, Times(f, Sqr(x))))), CN1), x), x), Dist(Times(Subtract(Times(C2, c, g), Times(h, Plus(b, q))), Power(q, CN1)), Int(Power(Times(Plus(b, q, Times(C2, c, x)), Sqrt(Plus(d, Times(f, Sqr(x))))), CN1), x), x))), And(FreeQ(List(a, b, c, d, f, g, h), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), PosQ(Subtract(Sqr(b), Times(C4, a, c))))));
            IIntegrate(1035, Int(Times(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(Subtract(Times(c, d), Times(a, f))), Times(Subtract(Times(b, d), Times(a, e)), Subtract(Times(c, e), Times(b, f)))), C2))), Subtract(Dist(Power(Times(C2, q), CN1), Int(Times(Simp(Subtract(Subtract(Times(h, Subtract(Times(b, d), Times(a, e))), Times(g, Subtract(Subtract(Times(c, d), Times(a, f)), q))), Times(Subtract(Times(g, Subtract(Times(c, e), Times(b, f))), Times(h, Plus(Times(c, d), Times(CN1, a, f), q))), x)), x), Power(Times(Plus(a, Times(b, x), Times(c, Sqr(x))), Sqrt(Plus(d, Times(e, x), Times(f, Sqr(x))))), CN1)), x), x), Dist(Power(Times(C2, q), CN1), Int(Times(Simp(Subtract(Subtract(Times(h, Subtract(Times(b, d), Times(a, e))), Times(g, Plus(Times(c, d), Times(CN1, a, f), q))), Times(Subtract(Times(g, Subtract(Times(c, e), Times(b, f))), Times(h, Subtract(Subtract(Times(c, d), Times(a, f)), q))), x)), x), Power(Times(Plus(a, Times(b, x), Times(c, Sqr(x))), Sqrt(Plus(d, Times(e, x), Times(f, Sqr(x))))), CN1)), x), x))), And(FreeQ(List(a, b, c, d, e, f, g, h), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Subtract(Sqr(e), Times(C4, d, f)), C0), NeQ(Subtract(Times(b, d), Times(a, e)), C0), NegQ(Subtract(Sqr(b), Times(C4, a, c))))));
            IIntegrate(1036, Int(Times(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), CN1), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Plus(Sqr(Subtract(Times(c, d), Times(a, f))), Times(a, c, Sqr(e))), C2))), Subtract(Dist(Power(Times(C2, q), CN1), Int(Times(Simp(Plus(Times(CN1, a, h, e), Times(CN1, g, Subtract(Subtract(Times(c, d), Times(a, f)), q)), Times(Subtract(Times(h, Plus(Times(c, d), Times(CN1, a, f), q)), Times(g, c, e)), x)), x), Power(Times(Plus(a, Times(c, Sqr(x))), Sqrt(Plus(d, Times(e, x), Times(f, Sqr(x))))), CN1)), x), x), Dist(Power(Times(C2, q), CN1), Int(Times(Simp(Plus(Times(CN1, a, h, e), Times(CN1, g, Plus(Times(c, d), Times(CN1, a, f), q)), Times(Subtract(Times(h, Subtract(Subtract(Times(c, d), Times(a, f)), q)), Times(g, c, e)), x)), x), Power(Times(Plus(a, Times(c, Sqr(x))), Sqrt(Plus(d, Times(e, x), Times(f, Sqr(x))))), CN1)), x), x))), And(FreeQ(List(a, c, d, e, f, g, h), x), NeQ(Subtract(Sqr(e), Times(C4, d, f)), C0), NegQ(Times(CN1, a, c)))));
            IIntegrate(1037, Int(Times(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1), Power(Plus(d_, Times(f_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Plus(Sqr(Subtract(Times(c, d), Times(a, f))), Times(Sqr(b), d, f)), C2))), Subtract(Dist(Power(Times(C2, q), CN1), Int(Times(Simp(Plus(Times(h, b, d), Times(CN1, g, Subtract(Subtract(Times(c, d), Times(a, f)), q)), Times(Plus(Times(h, Plus(Times(c, d), Times(CN1, a, f), q)), Times(g, b, f)), x)), x), Power(Times(Plus(a, Times(b, x), Times(c, Sqr(x))), Sqrt(Plus(d, Times(f, Sqr(x))))), CN1)), x), x), Dist(Power(Times(C2, q), CN1), Int(Times(Simp(Plus(Times(h, b, d), Times(CN1, g, Plus(Times(c, d), Times(CN1, a, f), q)), Times(Plus(Times(h, Subtract(Subtract(Times(c, d), Times(a, f)), q)), Times(g, b, f)), x)), x), Power(Times(Plus(a, Times(b, x), Times(c, Sqr(x))), Sqrt(Plus(d, Times(f, Sqr(x))))), CN1)), x), x))), And(FreeQ(List(a, b, c, d, f, g, h), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NegQ(Subtract(Sqr(b), Times(C4, a, c))))));
            IIntegrate(1038, Int(Times(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), Power(Plus(a_, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1D2), Power(Plus(d_, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(s, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2)), Set(t, Rt(Subtract(Sqr(e), Times(C4, d, f)), C2))), Dist(Times(Sqrt(Plus(b, s, Times(C2, c, x))), Sqrt(Plus(Times(C2, a), Times(Plus(b, s), x))), Sqrt(Plus(e, t, Times(C2, f, x))), Sqrt(Plus(Times(C2, d), Times(Plus(e, t), x))), Power(Times(Sqrt(Plus(a, Times(b, x), Times(c, Sqr(x)))), Sqrt(Plus(d, Times(e, x), Times(f, Sqr(x))))), CN1)), Int(Times(Plus(g, Times(h, x)), Power(Times(Sqrt(Plus(b, s, Times(C2, c, x))), Sqrt(Plus(Times(C2, a), Times(Plus(b, s), x))), Sqrt(Plus(e, t, Times(C2, f, x))), Sqrt(Plus(Times(C2, d), Times(Plus(e, t), x)))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, h), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Subtract(Sqr(e), Times(C4, d, f)), C0))));
            IIntegrate(1039, Int(Times(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), Power(Plus(a_, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1D2), Power(Plus(d_, Times(f_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(s, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2)), Set(t, Rt(Times(CN4, d, f), C2))), Dist(Times(Sqrt(Plus(b, s, Times(C2, c, x))), Sqrt(Plus(Times(C2, a), Times(Plus(b, s), x))), Sqrt(Plus(t, Times(C2, f, x))), Sqrt(Plus(Times(C2, d), Times(t, x))), Power(Times(Sqrt(Plus(a, Times(b, x), Times(c, Sqr(x)))), Sqrt(Plus(d, Times(f, Sqr(x))))), CN1)), Int(Times(Plus(g, Times(h, x)), Power(Times(Sqrt(Plus(b, s, Times(C2, c, x))), Sqrt(Plus(Times(C2, a), Times(Plus(b, s), x))), Sqrt(Plus(t, Times(C2, f, x))), Sqrt(Plus(Times(C2, d), Times(t, x)))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, f, g, h), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(1040, Int(Times(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1D3), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Power(Times(CN9, c, Sqr(h), Power(Subtract(Times(C2, c, g), Times(b, h)), CN2)), C1D3))), Plus(Simp(Times(CSqrt3, h, q, ArcTan(Subtract(C1DSqrt3, Times(Power(C2, QQ(2L, 3L)), Power(Subtract(C1, Times(C3, h, Plus(b, Times(C2, c, x)), Power(Subtract(Times(C2, c, g), Times(b, h)), CN1))), QQ(2L, 3L)), Power(Times(CSqrt3, Power(Plus(C1, Times(C3, h, Plus(b, Times(C2, c, x)), Power(Subtract(Times(C2, c, g), Times(b, h)), CN1))), C1D3)), CN1)))), Power(f, CN1)), x), Negate(Simp(Times(C3, h, q, Log(Plus(Power(Subtract(C1, Times(C3, h, Plus(b, Times(C2, c, x)), Power(Subtract(Times(C2, c, g), Times(b, h)), CN1))), QQ(2L, 3L)), Times(Power(C2, C1D3), Power(Plus(C1, Times(C3, h, Plus(b, Times(C2, c, x)), Power(Subtract(Times(C2, c, g), Times(b, h)), CN1))), C1D3)))), Power(Times(C2, f), CN1)), x)), Simp(Times(h, q, Log(Plus(d, Times(e, x), Times(f, Sqr(x)))), Power(Times(C2, f), CN1)), x))), And(FreeQ(List(a, b, c, d, e, f, g, h), x), EqQ(Subtract(Times(c, e), Times(b, f)), C0), EqQ(Subtract(Times(Sqr(c), d), Times(f, Subtract(Sqr(b), Times(C3, a, c)))), C0), EqQ(Plus(Times(Sqr(c), Sqr(g)), Times(CN1, b, c, g, h), Times(CN1, C2, Sqr(b), Sqr(h)), Times(C9, a, c, Sqr(h))), C0), GtQ(Times(CN9, c, Sqr(h), Power(Subtract(Times(C2, c, g), Times(b, h)), CN2)), C0))));
            IIntegrate(1041, Int(Times(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1D3), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqr(x_))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Times(CN1, c, Power(Subtract(Sqr(b), Times(C4, a, c)), CN1)))), Dist(Times(Power(Times(q, Plus(a, Times(b, x), Times(c, Sqr(x)))), C1D3), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), CN1D3)), Int(Times(Plus(g, Times(h, x)), Power(Times(Power(Plus(Times(q, a), Times(b, q, x), Times(c, q, Sqr(x))), C1D3), Plus(d, Times(e, x), Times(f, Sqr(x)))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, g, h), x), EqQ(Subtract(Times(c, e), Times(b, f)), C0), EqQ(Subtract(Times(Sqr(c), d), Times(f, Subtract(Sqr(b), Times(C3, a, c)))), C0), EqQ(Plus(Times(Sqr(c), Sqr(g)), Times(CN1, b, c, g, h), Times(CN1, C2, Sqr(b), Sqr(h)), Times(C9, a, c, Sqr(h))), C0), Not(GtQ(Subtract(Times(C4, a), Times(Sqr(b), Power(c, CN1))), C0)))));
            IIntegrate(1042, Int(Times(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), Power(Plus(a_DEFAULT, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqr(x_))), q_)), x_Symbol),
                    Condition(Unintegrable(Times(Plus(g, Times(h, x)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p), Power(Plus(d, Times(e, x), Times(f, Sqr(x))), q)), x), FreeQ(List(a, b, c, d, e, f, g, h, p, q), x)));
            IIntegrate(1043, Int(Times(Plus(g_DEFAULT, Times(h_DEFAULT, x_)), Power(Plus(a_DEFAULT, Times(c_DEFAULT, Sqr(x_))), p_), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqr(x_))), q_)), x_Symbol),
                    Condition(Unintegrable(Times(Plus(g, Times(h, x)), Power(Plus(a, Times(c, Sqr(x))), p), Power(Plus(d, Times(e, x), Times(f, Sqr(x))), q)), x), FreeQ(List(a, c, d, e, f, g, h, p, q), x)));
            IIntegrate(1044, Int(Times(Power(Plus(g_DEFAULT, Times(h_DEFAULT, u_)), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, u_), Times(c_DEFAULT, Sqr(u_))), p_DEFAULT), Power(Plus(d_DEFAULT, Times(e_DEFAULT, u_), Times(f_DEFAULT, Sqr(u_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Coefficient(u, x, C1), CN1), Subst(Int(Times(Power(Plus(g, Times(h, x)), m), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p), Power(Plus(d, Times(e, x), Times(f, Sqr(x))), q)), x), x, u), x), And(FreeQ(List(a, b, c, d, e, f, g, h, m, p, q), x), LinearQ(u, x), NeQ(u, x))));
            IIntegrate(1045, Int(Times(Power(Plus(g_DEFAULT, Times(h_DEFAULT, u_)), m_DEFAULT), Power(Plus(a_DEFAULT, Times(c_DEFAULT, Sqr(u_))), p_DEFAULT), Power(Plus(d_DEFAULT, Times(e_DEFAULT, u_), Times(f_DEFAULT, Sqr(u_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Coefficient(u, x, C1), CN1), Subst(Int(Times(Power(Plus(g, Times(h, x)), m), Power(Plus(a, Times(c, Sqr(x))), p), Power(Plus(d, Times(e, x), Times(f, Sqr(x))), q)), x), x, u), x), And(FreeQ(List(a, c, d, e, f, g, h, m, p, q), x), LinearQ(u, x), NeQ(u, x))));
            IIntegrate(1046, Int(Times(Power(Plus(a_, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_DEFAULT), Plus(A_DEFAULT, Times(B_DEFAULT, x_), Times(C_DEFAULT, Sqr(x_))), Power(Plus(d_, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqr(x_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Times(c, Power(f, CN1)), p), Int(Times(Power(Plus(d, Times(e, x), Times(f, Sqr(x))), Plus(p, q)), Plus(ASymbol, Times(BSymbol, x), Times(C, Sqr(x)))), x), x), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, C, p, q), x), EqQ(Subtract(Times(c, d), Times(a, f)), C0), EqQ(Subtract(Times(b, d), Times(a, e)), C0), Or(IntegerQ(p), GtQ(Times(c, Power(f, CN1)), C0)), Or(Not(IntegerQ(q)), LessEqual(LeafCount(Plus(d, Times(e, x), Times(f, Sqr(x)))), LeafCount(Plus(a, Times(b, x), Times(c, Sqr(x)))))))));
            IIntegrate(1047, Int(Times(Power(Plus(a_, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_DEFAULT), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr(x_))), Power(Plus(d_, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqr(x_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Times(c, Power(f, CN1)), p), Int(Times(Power(Plus(d, Times(e, x), Times(f, Sqr(x))), Plus(p, q)), Plus(ASymbol, Times(C, Sqr(x)))), x), x), And(FreeQ(List(a, b, c, d, e, f, ASymbol, C, p, q), x), EqQ(Subtract(Times(c, d), Times(a, f)), C0), EqQ(Subtract(Times(b, d), Times(a, e)), C0), Or(IntegerQ(p), GtQ(Times(c, Power(f, CN1)), C0)), Or(Not(IntegerQ(q)), LessEqual(LeafCount(Plus(d, Times(e, x), Times(f, Sqr(x)))), LeafCount(Plus(a, Times(b, x), Times(c, Sqr(x)))))))));
            IIntegrate(1048, Int(Times(Power(Plus(a_, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_DEFAULT), Plus(A_DEFAULT, Times(B_DEFAULT, x_), Times(C_DEFAULT, Sqr(x_))), Power(Plus(d_, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqr(x_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(a, IntPart(p)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), FracPart(p)), Power(Times(Power(d, IntPart(p)), Power(Plus(d, Times(e, x), Times(f, Sqr(x))), FracPart(p))), CN1)), Int(Times(Power(Plus(d, Times(e, x), Times(f, Sqr(x))), Plus(p, q)), Plus(ASymbol, Times(BSymbol, x), Times(C, Sqr(x)))), x), x), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, C, p, q), x), EqQ(Subtract(Times(c, d), Times(a, f)), C0), EqQ(Subtract(Times(b, d), Times(a, e)), C0), Not(IntegerQ(p)), Not(IntegerQ(q)), Not(GtQ(Times(c, Power(f, CN1)), C0)))));
            IIntegrate(1049, Int(Times(Power(Plus(a_, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_DEFAULT), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr(x_))), Power(Plus(d_, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqr(x_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(a, IntPart(p)), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), FracPart(p)), Power(Times(Power(d, IntPart(p)), Power(Plus(d, Times(e, x), Times(f, Sqr(x))), FracPart(p))), CN1)), Int(Times(Power(Plus(d, Times(e, x), Times(f, Sqr(x))), Plus(p, q)), Plus(ASymbol, Times(C, Sqr(x)))), x), x), And(FreeQ(List(a, b, c, d, e, f, ASymbol, C, p, q), x), EqQ(Subtract(Times(c, d), Times(a, f)), C0), EqQ(Subtract(Times(b, d), Times(a, e)), C0), Not(IntegerQ(p)), Not(IntegerQ(q)), Not(GtQ(Times(c, Power(f, CN1)), C0)))));
            IIntegrate(1050, Int(Times(Power(Plus(a_, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), p_DEFAULT), Plus(A_DEFAULT, Times(B_DEFAULT, x_), Times(C_DEFAULT, Sqr(x_))), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqr(x_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, x), Times(c, Sqr(x))), FracPart(p)), Power(Times(Power(Times(C4, c), IntPart(p)), Power(Plus(b, Times(C2, c, x)), Times(C2, FracPart(p)))), CN1)), Int(Times(Power(Plus(b, Times(C2, c, x)), Times(C2, p)), Power(Plus(d, Times(e, x), Times(f, Sqr(x))), q), Plus(ASymbol, Times(BSymbol, x), Times(C, Sqr(x)))), x), x), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, C, p, q), x), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
        }
    }
}
