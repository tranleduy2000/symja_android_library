package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.ASymbol;
import static org.matheclipse.core.expression.F.A_DEFAULT;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcSin;
import static org.matheclipse.core.expression.F.ArcTan;
import static org.matheclipse.core.expression.F.BSymbol;
import static org.matheclipse.core.expression.F.B_DEFAULT;
import static org.matheclipse.core.expression.F.C;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.C7;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.C_DEFAULT;
import static org.matheclipse.core.expression.F.Coefficient;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.EllipticF;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
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
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.r;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NegQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplerSqrtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules43 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(1076, Int(Times(Power(Plus(a_, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1), Plus(A_DEFAULT, Times(B_DEFAULT, x_), Times(C_DEFAULT, Sqr(x_))), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Plus(Dist(Times(C, Power(c, CN1)), Int(Power(Plus(d, Times(e, x), Times(f, Sqr(x))), CN1D2), x), x), Dist(Power(c, CN1), Int(Times(Plus(Times(ASymbol, c), Times(CN1, a, C), Times(Subtract(Times(BSymbol, c), Times(b, C)), x)), Power(Times(Plus(a, Times(b, x), Times(c, Sqr(x))), Sqrt(Plus(d, Times(e, x), Times(f, Sqr(x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, C), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Subtract(Sqr(e), Times(C4, d, f)), C0))));
            IIntegrate(1077, Int(Times(Power(Plus(a_, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr(x_))), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Plus(Dist(Times(C, Power(c, CN1)), Int(Power(Plus(d, Times(e, x), Times(f, Sqr(x))), CN1D2), x), x), Dist(Power(c, CN1), Int(Times(Subtract(Subtract(Times(ASymbol, c), Times(a, C)), Times(b, C, x)), Power(Times(Plus(a, Times(b, x), Times(c, Sqr(x))), Sqrt(Plus(d, Times(e, x), Times(f, Sqr(x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e, f, ASymbol, C), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Subtract(Sqr(e), Times(C4, d, f)), C0))));
            IIntegrate(1078, Int(Times(Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), CN1), Plus(A_DEFAULT, Times(B_DEFAULT, x_), Times(C_DEFAULT, Sqr(x_))), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Plus(Dist(Times(C, Power(c, CN1)), Int(Power(Plus(d, Times(e, x), Times(f, Sqr(x))), CN1D2), x), x), Dist(Power(c, CN1), Int(Times(Plus(Times(ASymbol, c), Times(CN1, a, C), Times(BSymbol, c, x)), Power(Times(Plus(a, Times(c, Sqr(x))), Sqrt(Plus(d, Times(e, x), Times(f, Sqr(x))))), CN1)), x), x)), And(FreeQ(List(a, c, d, e, f, ASymbol, BSymbol, C), x), NeQ(Subtract(Sqr(e), Times(C4, d, f)), C0))));
            IIntegrate(1079, Int(Times(Power(Plus(a_, Times(c_DEFAULT, Sqr(x_))), CN1), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr(x_))), Power(Plus(d_DEFAULT, Times(e_DEFAULT, x_), Times(f_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Plus(Dist(Times(C, Power(c, CN1)), Int(Power(Plus(d, Times(e, x), Times(f, Sqr(x))), CN1D2), x), x), Dist(Times(Subtract(Times(ASymbol, c), Times(a, C)), Power(c, CN1)), Int(Power(Times(Plus(a, Times(c, Sqr(x))), Sqrt(Plus(d, Times(e, x), Times(f, Sqr(x))))), CN1), x), x)), And(FreeQ(List(a, c, d, e, f, ASymbol, C), x), NeQ(Subtract(Sqr(e), Times(C4, d, f)), C0))));
            IIntegrate(1080, Int(Times(Power(Plus(a_, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1), Plus(A_DEFAULT, Times(B_DEFAULT, x_), Times(C_DEFAULT, Sqr(x_))), Power(Plus(d_DEFAULT, Times(f_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Plus(Dist(Times(C, Power(c, CN1)), Int(Power(Plus(d, Times(f, Sqr(x))), CN1D2), x), x), Dist(Power(c, CN1), Int(Times(Plus(Times(ASymbol, c), Times(CN1, a, C), Times(Subtract(Times(BSymbol, c), Times(b, C)), x)), Power(Times(Plus(a, Times(b, x), Times(c, Sqr(x))), Sqrt(Plus(d, Times(f, Sqr(x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, f, ASymbol, BSymbol, C), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(1081, Int(Times(Power(Plus(a_, Times(b_DEFAULT, x_), Times(c_DEFAULT, Sqr(x_))), CN1), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr(x_))), Power(Plus(d_DEFAULT, Times(f_DEFAULT, Sqr(x_))), CN1D2)), x_Symbol),
                    Condition(Plus(Dist(Times(C, Power(c, CN1)), Int(Power(Plus(d, Times(f, Sqr(x))), CN1D2), x), x), Dist(Power(c, CN1), Int(Times(Subtract(Subtract(Times(ASymbol, c), Times(a, C)), Times(b, C, x)), Power(Times(Plus(a, Times(b, x), Times(c, Sqr(x))), Sqrt(Plus(d, Times(f, Sqr(x))))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, f, ASymbol, C), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(1082, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, u_), Times(c_DEFAULT, Sqr(u_))), p_DEFAULT), Plus(A_DEFAULT, Times(B_DEFAULT, u_), Times(C_DEFAULT, Sqr(u_))), Power(Plus(d_DEFAULT, Times(e_DEFAULT, u_), Times(f_DEFAULT, Sqr(u_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Coefficient(u, x, C1), CN1), Subst(Int(Times(Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p), Power(Plus(d, Times(e, x), Times(f, Sqr(x))), q), Plus(ASymbol, Times(BSymbol, x), Times(C, Sqr(x)))), x), x, u), x), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, C, p, q), x), LinearQ(u, x), NeQ(u, x))));
            IIntegrate(1083, Int(Times(Plus(A_DEFAULT, Times(B_DEFAULT, u_)), Power(Plus(a_DEFAULT, Times(b_DEFAULT, u_), Times(c_DEFAULT, Sqr(u_))), p_DEFAULT), Power(Plus(d_DEFAULT, Times(e_DEFAULT, u_), Times(f_DEFAULT, Sqr(u_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Coefficient(u, x, C1), CN1), Subst(Int(Times(Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p), Power(Plus(d, Times(e, x), Times(f, Sqr(x))), q), Plus(ASymbol, Times(BSymbol, x))), x), x, u), x), And(FreeQ(List(a, b, c, d, e, f, ASymbol, BSymbol, C, p, q), x), LinearQ(u, x), NeQ(u, x))));
            IIntegrate(1084, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, u_), Times(c_DEFAULT, Sqr(u_))), p_DEFAULT), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr(u_))), Power(Plus(d_DEFAULT, Times(e_DEFAULT, u_), Times(f_DEFAULT, Sqr(u_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Coefficient(u, x, C1), CN1), Subst(Int(Times(Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p), Power(Plus(d, Times(e, x), Times(f, Sqr(x))), q), Plus(ASymbol, Times(C, Sqr(x)))), x), x, u), x), And(FreeQ(List(a, b, c, d, e, f, ASymbol, C, p, q), x), LinearQ(u, x), NeQ(u, x))));
            IIntegrate(1085, Int(Times(Power(Plus(a_DEFAULT, Times(c_DEFAULT, Sqr(u_))), p_DEFAULT), Plus(A_DEFAULT, Times(B_DEFAULT, u_), Times(C_DEFAULT, Sqr(u_))), Power(Plus(d_DEFAULT, Times(e_DEFAULT, u_), Times(f_DEFAULT, Sqr(u_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Coefficient(u, x, C1), CN1), Subst(Int(Times(Power(Plus(a, Times(c, Sqr(x))), p), Power(Plus(d, Times(e, x), Times(f, Sqr(x))), q), Plus(ASymbol, Times(BSymbol, x), Times(C, Sqr(x)))), x), x, u), x), And(FreeQ(List(a, c, d, e, f, ASymbol, BSymbol, C, p, q), x), LinearQ(u, x), NeQ(u, x))));
            IIntegrate(1086, Int(Times(Plus(A_DEFAULT, Times(B_DEFAULT, u_)), Power(Plus(a_DEFAULT, Times(c_DEFAULT, Sqr(u_))), p_DEFAULT), Power(Plus(d_DEFAULT, Times(e_DEFAULT, u_), Times(f_DEFAULT, Sqr(u_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Coefficient(u, x, C1), CN1), Subst(Int(Times(Power(Plus(a, Times(c, Sqr(x))), p), Power(Plus(d, Times(e, x), Times(f, Sqr(x))), q), Plus(ASymbol, Times(BSymbol, x))), x), x, u), x), And(FreeQ(List(a, c, d, e, f, ASymbol, BSymbol, C, p, q), x), LinearQ(u, x), NeQ(u, x))));
            IIntegrate(1087, Int(Times(Power(Plus(a_DEFAULT, Times(c_DEFAULT, Sqr(u_))), p_DEFAULT), Plus(A_DEFAULT, Times(C_DEFAULT, Sqr(u_))), Power(Plus(d_DEFAULT, Times(e_DEFAULT, u_), Times(f_DEFAULT, Sqr(u_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Coefficient(u, x, C1), CN1), Subst(Int(Times(Power(Plus(a, Times(c, Sqr(x))), p), Power(Plus(d, Times(e, x), Times(f, Sqr(x))), q), Plus(ASymbol, Times(C, Sqr(x)))), x), x, u), x), And(FreeQ(List(a, c, d, e, f, ASymbol, C, p, q), x), LinearQ(u, x), NeQ(u, x))));
            IIntegrate(1088, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p), Power(Power(Plus(b, Times(C2, c, Sqr(x))), Times(C2, p)), CN1)), Int(Power(Plus(b, Times(C2, c, Sqr(x))), Times(C2, p)), x), x), And(FreeQ(List(a, b, c, p), x), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(Subtract(p, C1D2)))));
            IIntegrate(1089, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_), x_Symbol),
                    Condition(Dist(Times(Power(a, IntPart(p)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), FracPart(p)), Power(Power(Plus(C1, Times(C2, c, Sqr(x), Power(b, CN1))), Times(C2, FracPart(p))), CN1)), Int(Power(Plus(C1, Times(C2, c, Sqr(x), Power(b, CN1))), Times(C2, p)), x), x), And(FreeQ(List(a, b, c, p), x), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(Times(C2, p))))));
            IIntegrate(1090, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p), x), x), And(FreeQ(List(a, b, c), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IGtQ(p, C0))));
            IIntegrate(1091, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_), x_Symbol),
                    Condition(Plus(Simp(Times(x, Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p), Power(Plus(Times(C4, p), C1), CN1)), x), Dist(Times(C2, p, Power(Plus(Times(C4, p), C1), CN1)), Int(Times(Plus(Times(C2, a), Times(b, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Subtract(p, C1))), x), x)), And(FreeQ(List(a, b, c), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), GtQ(p, C0), IntegerQ(Times(C2, p)))));
            IIntegrate(1092, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(x, Plus(Sqr(b), Times(CN1, C2, a, c), Times(b, c, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Plus(p, C1)), Power(Times(C2, a, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1)), x)), Dist(Power(Times(C2, a, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), CN1), Int(Times(Plus(Sqr(b), Times(CN1, C2, a, c), Times(C2, Plus(p, C1), Subtract(Sqr(b), Times(C4, a, c))), Times(b, c, Plus(Times(C4, p), C7), Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, c), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), LtQ(p, CN1), IntegerQ(Times(C2, p)))));
            IIntegrate(1093, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Subtract(Dist(Times(c, Power(q, CN1)), Int(Power(Plus(Times(C1D2, b), Times(CN1, C1D2, q), Times(c, Sqr(x))), CN1), x), x), Dist(Times(c, Power(q, CN1)), Int(Power(Plus(Times(C1D2, b), Times(C1D2, q), Times(c, Sqr(x))), CN1), x), x))), And(FreeQ(List(a, b, c), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), PosQ(Subtract(Sqr(b), Times(C4, a, c))))));
            IIntegrate(1094, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(a, Power(c, CN1)), C2))), With(List(Set(r, Rt(Subtract(Times(C2, q), Times(b, Power(c, CN1))), C2))), Plus(Dist(Power(Times(C2, c, q, r), CN1), Int(Times(Subtract(r, x), Power(Plus(q, Times(CN1, r, x), Sqr(x)), CN1)), x), x), Dist(Power(Times(C2, c, q, r), CN1), Int(Times(Plus(r, x), Power(Plus(q, Times(r, x), Sqr(x)), CN1)), x), x)))), And(FreeQ(List(a, b, c), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NegQ(Subtract(Sqr(b), Times(C4, a, c))))));
            IIntegrate(1095, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Dist(Times(C2, Sqrt(Negate(c))), Int(Power(Times(Sqrt(Plus(b, q, Times(C2, c, Sqr(x)))), Sqrt(Subtract(Plus(Negate(b), q), Times(C2, c, Sqr(x))))), CN1), x), x)), And(FreeQ(List(a, b, c), x), GtQ(Subtract(Sqr(b), Times(C4, a, c)), C0), LtQ(c, C0))));
            IIntegrate(1096, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(c, Power(a, CN1)), C4))), Simp(Times(Plus(C1, Times(Sqr(q), Sqr(x))), Sqrt(Times(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Power(Times(a, Sqr(Plus(C1, Times(Sqr(q), Sqr(x))))), CN1))), EllipticF(Times(C2, ArcTan(Times(q, x))), Subtract(C1D2, Times(b, Sqr(q), Power(Times(C4, c), CN1)))), Power(Times(C2, q, Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1)), x)), And(FreeQ(List(a, b, c), x), GtQ(Subtract(Sqr(b), Times(C4, a, c)), C0), GtQ(Times(c, Power(a, CN1)), C0), LtQ(Times(b, Power(a, CN1)), C0))));
            IIntegrate(1097, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Condition(Simp(Times(Sqrt(Subtract(Times(CN2, a), Times(Subtract(b, q), Sqr(x)))), Sqrt(Times(Plus(Times(C2, a), Times(Plus(b, q), Sqr(x))), Power(q, CN1))), EllipticF(ArcSin(Times(x, Power(Times(Plus(Times(C2, a), Times(Plus(b, q), Sqr(x))), Power(Times(C2, q), CN1)), CN1D2))), Times(Plus(b, q), Power(Times(C2, q), CN1))), Power(Times(C2, Sqrt(Negate(a)), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1)), x), IntegerQ(q))), And(FreeQ(List(a, b, c), x), GtQ(Subtract(Sqr(b), Times(C4, a, c)), C0), LtQ(a, C0), GtQ(c, C0))));
            IIntegrate(1098, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Simp(Times(Sqrt(Times(Plus(Times(C2, a), Times(Subtract(b, q), Sqr(x))), Power(Plus(Times(C2, a), Times(Plus(b, q), Sqr(x))), CN1))), Sqrt(Times(Plus(Times(C2, a), Times(Plus(b, q), Sqr(x))), Power(q, CN1))), EllipticF(ArcSin(Times(x, Power(Times(Plus(Times(C2, a), Times(Plus(b, q), Sqr(x))), Power(Times(C2, q), CN1)), CN1D2))), Times(Plus(b, q), Power(Times(C2, q), CN1))), Power(Times(C2, Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4)))), Sqrt(Times(a, Power(Plus(Times(C2, a), Times(Plus(b, q), Sqr(x))), CN1)))), CN1)), x)), And(FreeQ(List(a, b, c), x), GtQ(Subtract(Sqr(b), Times(C4, a, c)), C0), LtQ(a, C0), GtQ(c, C0))));
            IIntegrate(1099, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Condition(Simp(Times(Plus(Times(C2, a), Times(Plus(b, q), Sqr(x))), Sqrt(Times(Plus(Times(C2, a), Times(Subtract(b, q), Sqr(x))), Power(Plus(Times(C2, a), Times(Plus(b, q), Sqr(x))), CN1))), EllipticF(ArcTan(Times(Rt(Times(Plus(b, q), Power(Times(C2, a), CN1)), C2), x)), Times(C2, q, Power(Plus(b, q), CN1))), Power(Times(C2, a, Rt(Times(Plus(b, q), Power(Times(C2, a), CN1)), C2), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1)), x), And(PosQ(Times(Plus(b, q), Power(a, CN1))), Not(And(PosQ(Times(Subtract(b, q), Power(a, CN1))), SimplerSqrtQ(Times(Subtract(b, q), Power(Times(C2, a), CN1)), Times(Plus(b, q), Power(Times(C2, a), CN1)))))))), And(FreeQ(List(a, b, c), x), GtQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(1100, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Condition(Simp(Times(Plus(Times(C2, a), Times(Subtract(b, q), Sqr(x))), Sqrt(Times(Plus(Times(C2, a), Times(Plus(b, q), Sqr(x))), Power(Plus(Times(C2, a), Times(Subtract(b, q), Sqr(x))), CN1))), EllipticF(ArcTan(Times(Rt(Times(Subtract(b, q), Power(Times(C2, a), CN1)), C2), x)), Times(CN2, q, Power(Subtract(b, q), CN1))), Power(Times(C2, a, Rt(Times(Subtract(b, q), Power(Times(C2, a), CN1)), C2), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1)), x), PosQ(Times(Subtract(b, q), Power(a, CN1))))), And(FreeQ(List(a, b, c), x), GtQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
        }
    }
}
