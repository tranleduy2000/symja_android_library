package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.ASymbol;
import static org.matheclipse.core.expression.F.A_;
import static org.matheclipse.core.expression.F.A_DEFAULT;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcTan;
import static org.matheclipse.core.expression.F.BSymbol;
import static org.matheclipse.core.expression.F.B_DEFAULT;
import static org.matheclipse.core.expression.F.C;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.C5;
import static org.matheclipse.core.expression.F.C6;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Cancel;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.EllipticPi;
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
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Coeff;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Expon;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NegQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PolyQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules68 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(1701, Int(Times(Plus(A_, Times(B_DEFAULT, Sqr(x_))), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(Subtract(Dist(Times(Plus(Times(BSymbol, d), Times(ASymbol, e)), Power(Times(C2, d, e), CN1)), Int(Power(Plus(a, Times(c, Power(x, C4))), CN1D2), x), x), Dist(Times(Subtract(Times(BSymbol, d), Times(ASymbol, e)), Power(Times(C2, d, e), CN1)), Int(Times(Subtract(d, Times(e, Sqr(x))), Power(Times(Plus(d, Times(e, Sqr(x))), Sqrt(Plus(a, Times(c, Power(x, C4))))), CN1)), x), x)), And(FreeQ(List(a, c, d, e, ASymbol, BSymbol), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), EqQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), NeQ(Plus(Times(BSymbol, d), Times(ASymbol, e)), C0))));
            IIntegrate(1702, Int(Times(Plus(A_, Times(B_DEFAULT, Sqr(x_))), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Plus(ASymbol, Times(BSymbol, Sqr(x)))), Sqrt(Plus(Times(a, Power(ASymbol, CN1)), Times(c, Sqr(x), Power(BSymbol, CN1)))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2)), Int(Times(Sqrt(Plus(ASymbol, Times(BSymbol, Sqr(x)))), Power(Times(Plus(d, Times(e, Sqr(x))), Sqrt(Plus(Times(a, Power(ASymbol, CN1)), Times(c, Sqr(x), Power(BSymbol, CN1))))), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, ASymbol, BSymbol), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), EqQ(Plus(Times(c, Sqr(ASymbol)), Times(CN1, b, ASymbol, BSymbol), Times(a, Sqr(BSymbol))), C0))));
            IIntegrate(1703, Int(Times(Plus(A_, Times(B_DEFAULT, Sqr(x_))), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(Dist(Times(Sqrt(Plus(ASymbol, Times(BSymbol, Sqr(x)))), Sqrt(Plus(Times(a, Power(ASymbol, CN1)), Times(c, Sqr(x), Power(BSymbol, CN1)))), Power(Plus(a, Times(c, Power(x, C4))), CN1D2)), Int(Times(Sqrt(Plus(ASymbol, Times(BSymbol, Sqr(x)))), Power(Times(Plus(d, Times(e, Sqr(x))), Sqrt(Plus(Times(a, Power(ASymbol, CN1)), Times(c, Sqr(x), Power(BSymbol, CN1))))), CN1)), x), x), And(FreeQ(List(a, c, d, e, ASymbol, BSymbol), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), EqQ(Plus(Times(c, Sqr(ASymbol)), Times(a, Sqr(BSymbol))), C0))));
            IIntegrate(1704, Int(Times(Plus(A_, Times(B_DEFAULT, Sqr(x_))), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Sqrt(Subtract(Sqr(b), Times(C4, a, c))))), Condition(Subtract(Dist(Times(Subtract(Times(C2, a, BSymbol), Times(ASymbol, Plus(b, q))), Power(Subtract(Times(C2, a, e), Times(d, Plus(b, q))), CN1)), Int(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2), x), x), Dist(Times(Subtract(Times(BSymbol, d), Times(ASymbol, e)), Power(Subtract(Times(C2, a, e), Times(d, Plus(b, q))), CN1)), Int(Times(Plus(Times(C2, a), Times(Plus(b, q), Sqr(x))), Power(Times(Plus(d, Times(e, Sqr(x))), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1)), x), x)), RationalQ(q))), And(FreeQ(List(a, b, c, d, e, ASymbol, BSymbol), x), GtQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), NeQ(Plus(Times(c, Sqr(ASymbol)), Times(CN1, b, ASymbol, BSymbol), Times(a, Sqr(BSymbol))), C0))));
            IIntegrate(1705, Int(Times(Plus(A_, Times(B_DEFAULT, Sqr(x_))), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Sqrt(Times(CN1, a, c)))), Condition(Subtract(Dist(Times(Subtract(Times(a, BSymbol), Times(ASymbol, q)), Power(Subtract(Times(a, e), Times(d, q)), CN1)), Int(Power(Plus(a, Times(c, Power(x, C4))), CN1D2), x), x), Dist(Times(Subtract(Times(BSymbol, d), Times(ASymbol, e)), Power(Subtract(Times(a, e), Times(d, q)), CN1)), Int(Times(Plus(a, Times(q, Sqr(x))), Power(Times(Plus(d, Times(e, Sqr(x))), Sqrt(Plus(a, Times(c, Power(x, C4))))), CN1)), x), x)), RationalQ(q))), And(FreeQ(List(a, c, d, e, ASymbol, BSymbol), x), GtQ(Times(CN1, a, c), C0), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), NeQ(Plus(Times(c, Sqr(ASymbol)), Times(a, Sqr(BSymbol))), C0))));
            IIntegrate(1706, Int(Times(Plus(A_, Times(B_DEFAULT, Sqr(x_))), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(BSymbol, Power(ASymbol, CN1)), C2))), Plus(Negate(Simp(Times(Subtract(Times(BSymbol, d), Times(ASymbol, e)), ArcTan(Times(Rt(Plus(Negate(b), Times(c, d, Power(e, CN1)), Times(a, e, Power(d, CN1))), C2), x, Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2))), Power(Times(C2, d, e, Rt(Plus(Negate(b), Times(c, d, Power(e, CN1)), Times(a, e, Power(d, CN1))), C2)), CN1)), x)), Simp(Times(Plus(Times(BSymbol, d), Times(ASymbol, e)), Plus(ASymbol, Times(BSymbol, Sqr(x))), Sqrt(Times(Sqr(ASymbol), Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Power(Times(a, Sqr(Plus(ASymbol, Times(BSymbol, Sqr(x))))), CN1))), EllipticPi(Cancel(Times(CN1, Sqr(Subtract(Times(BSymbol, d), Times(ASymbol, e))), Power(Times(C4, d, e, ASymbol, BSymbol), CN1))), Times(C2, ArcTan(Times(q, x))), Subtract(C1D2, Times(b, ASymbol, Power(Times(C4, a, BSymbol), CN1)))), Power(Times(C4, d, e, ASymbol, q, Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1)), x))), And(FreeQ(List(a, b, c, d, e, ASymbol, BSymbol), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), NeQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), PosQ(Times(c, Power(a, CN1))), EqQ(Subtract(Times(c, Sqr(ASymbol)), Times(a, Sqr(BSymbol))), C0))));
            IIntegrate(1707, Int(Times(Plus(A_, Times(B_DEFAULT, Sqr(x_))), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(BSymbol, Power(ASymbol, CN1)), C2))), Plus(Negate(Simp(Times(Subtract(Times(BSymbol, d), Times(ASymbol, e)), ArcTan(Times(Rt(Plus(Times(c, d, Power(e, CN1)), Times(a, e, Power(d, CN1))), C2), x, Power(Plus(a, Times(c, Power(x, C4))), CN1D2))), Power(Times(C2, d, e, Rt(Plus(Times(c, d, Power(e, CN1)), Times(a, e, Power(d, CN1))), C2)), CN1)), x)), Simp(Times(Plus(Times(BSymbol, d), Times(ASymbol, e)), Plus(ASymbol, Times(BSymbol, Sqr(x))), Sqrt(Times(Sqr(ASymbol), Plus(a, Times(c, Power(x, C4))), Power(Times(a, Sqr(Plus(ASymbol, Times(BSymbol, Sqr(x))))), CN1))), EllipticPi(Cancel(Times(CN1, Sqr(Subtract(Times(BSymbol, d), Times(ASymbol, e))), Power(Times(C4, d, e, ASymbol, BSymbol), CN1))), Times(C2, ArcTan(Times(q, x))), C1D2), Power(Times(C4, d, e, ASymbol, q, Sqrt(Plus(a, Times(c, Power(x, C4))))), CN1)), x))), And(FreeQ(List(a, c, d, e, ASymbol, BSymbol), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), NeQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), PosQ(Times(c, Power(a, CN1))), EqQ(Subtract(Times(c, Sqr(ASymbol)), Times(a, Sqr(BSymbol))), C0))));
            IIntegrate(1708, Int(Times(Plus(A_DEFAULT, Times(B_DEFAULT, Sqr(x_))), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(c, Power(a, CN1)), C2))), Plus(Dist(Times(Subtract(Times(ASymbol, Plus(Times(c, d), Times(a, e, q))), Times(a, BSymbol, Plus(e, Times(d, q)))), Power(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1)), Int(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2), x), x), Dist(Times(a, Subtract(Times(BSymbol, d), Times(ASymbol, e)), Plus(e, Times(d, q)), Power(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1)), Int(Times(Plus(C1, Times(q, Sqr(x))), Power(Times(Plus(d, Times(e, Sqr(x))), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1)), x), x))), And(FreeQ(List(a, b, c, d, e, ASymbol, BSymbol), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), NeQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), PosQ(Times(c, Power(a, CN1))), NeQ(Subtract(Times(c, Sqr(ASymbol)), Times(a, Sqr(BSymbol))), C0))));
            IIntegrate(1709, Int(Times(Plus(A_DEFAULT, Times(B_DEFAULT, Sqr(x_))), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(c, Power(a, CN1)), C2))), Plus(Dist(Times(Subtract(Times(ASymbol, Plus(Times(c, d), Times(a, e, q))), Times(a, BSymbol, Plus(e, Times(d, q)))), Power(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1)), Int(Power(Plus(a, Times(c, Power(x, C4))), CN1D2), x), x), Dist(Times(a, Subtract(Times(BSymbol, d), Times(ASymbol, e)), Plus(e, Times(d, q)), Power(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1)), Int(Times(Plus(C1, Times(q, Sqr(x))), Power(Times(Plus(d, Times(e, Sqr(x))), Sqrt(Plus(a, Times(c, Power(x, C4))))), CN1)), x), x))), And(FreeQ(List(a, c, d, e, ASymbol, BSymbol), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), NeQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), PosQ(Times(c, Power(a, CN1))), NeQ(Subtract(Times(c, Sqr(ASymbol)), Times(a, Sqr(BSymbol))), C0))));
            IIntegrate(1710, Int(Times(Plus(A_DEFAULT, Times(B_DEFAULT, Sqr(x_))), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(Plus(Dist(Times(BSymbol, Power(e, CN1)), Int(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2), x), x), Dist(Times(Subtract(Times(e, ASymbol), Times(d, BSymbol)), Power(e, CN1)), Int(Power(Times(Plus(d, Times(e, Sqr(x))), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1), x), x)), And(FreeQ(List(a, b, c, d, e, ASymbol, BSymbol), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), NeQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), NegQ(Times(c, Power(a, CN1))))));
            IIntegrate(1711, Int(Times(Plus(A_DEFAULT, Times(B_DEFAULT, Sqr(x_))), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(Plus(Dist(Times(BSymbol, Power(e, CN1)), Int(Power(Plus(a, Times(c, Power(x, C4))), CN1D2), x), x), Dist(Times(Subtract(Times(e, ASymbol), Times(d, BSymbol)), Power(e, CN1)), Int(Power(Times(Plus(d, Times(e, Sqr(x))), Sqrt(Plus(a, Times(c, Power(x, C4))))), CN1), x), x)), And(FreeQ(List(a, c, d, e, ASymbol, BSymbol), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), NeQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), NegQ(Times(c, Power(a, CN1))))));
            IIntegrate(1712, Int(Times($p("§p4x"), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§p4x"), x, C0)), Set(BSymbol, Coeff($s("§p4x"), x, C2)), Set(C, Coeff($s("§p4x"), x, C4))), Plus(Negate(Dist(Times(C, Power(e, CN2)), Int(Times(Subtract(d, Times(e, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2)), x), x)), Dist(Power(e, CN2), Int(Times(Plus(Times(C, Sqr(d)), Times(ASymbol, Sqr(e)), Times(BSymbol, Sqr(e), Sqr(x))), Power(Times(Plus(d, Times(e, Sqr(x))), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1)), x), x))), And(FreeQ(List(a, b, c, d, e), x), PolyQ($s("§p4x"), Sqr(x), C2), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), EqQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0))));
            IIntegrate(1713, Int(Times($p("§p4x"), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§p4x"), x, C0)), Set(BSymbol, Coeff($s("§p4x"), x, C2)), Set(C, Coeff($s("§p4x"), x, C4))), Plus(Negate(Dist(Times(C, Power(e, CN2)), Int(Times(Subtract(d, Times(e, Sqr(x))), Power(Plus(a, Times(c, Power(x, C4))), CN1D2)), x), x)), Dist(Power(e, CN2), Int(Times(Plus(Times(C, Sqr(d)), Times(ASymbol, Sqr(e)), Times(BSymbol, Sqr(e), Sqr(x))), Power(Times(Plus(d, Times(e, Sqr(x))), Sqrt(Plus(a, Times(c, Power(x, C4))))), CN1)), x), x))), And(FreeQ(List(a, c, d, e), x), PolyQ($s("§p4x"), Sqr(x), C2), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), EqQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0))));
            IIntegrate(1714, Int(Times($p("§p4x"), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(c, Power(a, CN1)), C2)), Set(ASymbol, Coeff($s("§p4x"), x, C0)), Set(BSymbol, Coeff($s("§p4x"), x, C2)), Set(C, Coeff($s("§p4x"), x, C4))), Plus(Negate(Dist(Times(C, Power(Times(e, q), CN1)), Int(Times(Subtract(C1, Times(q, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2)), x), x)), Dist(Power(Times(c, e), CN1), Int(Times(Plus(Times(ASymbol, c, e), Times(a, C, d, q), Times(Subtract(Times(BSymbol, c, e), Times(C, Subtract(Times(c, d), Times(a, e, q)))), Sqr(x))), Power(Times(Plus(d, Times(e, Sqr(x))), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1)), x), x))), And(FreeQ(List(a, b, c, d, e), x), PolyQ($s("§p4x"), Sqr(x), C2), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), NeQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), PosQ(Times(c, Power(a, CN1))), Not(GtQ(Subtract(Sqr(b), Times(C4, a, c)), C0)))));
            IIntegrate(1715, Int(Times($p("§p4x"), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(c, Power(a, CN1)), C2)), Set(ASymbol, Coeff($s("§p4x"), x, C0)), Set(BSymbol, Coeff($s("§p4x"), x, C2)), Set(C, Coeff($s("§p4x"), x, C4))), Plus(Negate(Dist(Times(C, Power(Times(e, q), CN1)), Int(Times(Subtract(C1, Times(q, Sqr(x))), Power(Plus(a, Times(c, Power(x, C4))), CN1D2)), x), x)), Dist(Power(Times(c, e), CN1), Int(Times(Plus(Times(ASymbol, c, e), Times(a, C, d, q), Times(Subtract(Times(BSymbol, c, e), Times(C, Subtract(Times(c, d), Times(a, e, q)))), Sqr(x))), Power(Times(Plus(d, Times(e, Sqr(x))), Sqrt(Plus(a, Times(c, Power(x, C4))))), CN1)), x), x))), And(FreeQ(List(a, c, d, e), x), PolyQ($s("§p4x"), Sqr(x), C2), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), NeQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), PosQ(Times(c, Power(a, CN1))))));
            IIntegrate(1716, Int(Times($p("§p4x"), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§p4x"), x, C0)), Set(BSymbol, Coeff($s("§p4x"), x, C2)), Set(C, Coeff($s("§p4x"), x, C4))), Plus(Negate(Dist(Power(e, CN2), Int(Times(Subtract(Subtract(Times(C, d), Times(BSymbol, e)), Times(C, e, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2)), x), x)), Dist(Times(Plus(Times(C, Sqr(d)), Times(CN1, BSymbol, d, e), Times(ASymbol, Sqr(e))), Power(e, CN2)), Int(Power(Times(Plus(d, Times(e, Sqr(x))), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1), x), x))), And(FreeQ(List(a, b, c, d, e), x), PolyQ($s("§p4x"), Sqr(x), C2), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), NeQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0))));
            IIntegrate(1717, Int(Times($p("§p4x"), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(ASymbol, Coeff($s("§p4x"), x, C0)), Set(BSymbol, Coeff($s("§p4x"), x, C2)), Set(C, Coeff($s("§p4x"), x, C4))), Plus(Negate(Dist(Power(e, CN2), Int(Times(Subtract(Subtract(Times(C, d), Times(BSymbol, e)), Times(C, e, Sqr(x))), Power(Plus(a, Times(c, Power(x, C4))), CN1D2)), x), x)), Dist(Times(Plus(Times(C, Sqr(d)), Times(CN1, BSymbol, d, e), Times(ASymbol, Sqr(e))), Power(e, CN2)), Int(Power(Times(Plus(d, Times(e, Sqr(x))), Sqrt(Plus(a, Times(c, Power(x, C4))))), CN1), x), x))), And(FreeQ(List(a, c, d, e), x), PolyQ($s("§p4x"), Sqr(x), C2), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), NeQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0))));
            IIntegrate(1718, Int(Times($p("§px"), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Expon($s("§px"), x))), Condition(Plus(Simp(Times(Coeff($s("§px"), x, q), Power(x, Subtract(q, C5)), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4)))), Power(Times(c, e, Subtract(q, C3)), CN1)), x), Dist(Power(Times(c, e, Subtract(q, C3)), CN1), Int(Times(Subtract(Times(c, e, Subtract(q, C3), $s("§px")), Times(Coeff($s("§px"), x, q), Power(x, Subtract(q, C6)), Plus(d, Times(e, Sqr(x))), Plus(Times(a, Subtract(q, C5)), Times(b, Subtract(q, C4), Sqr(x)), Times(c, Subtract(q, C3), Power(x, C4))))), Power(Times(Plus(d, Times(e, Sqr(x))), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1)), x), x)), GtQ(q, C4))), And(FreeQ(List(a, b, c, d, e), x), PolyQ($s("§px"), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0))));
            IIntegrate(1719, Int(Times($p("§px"), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), CN1), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Expon($s("§px"), x))), Condition(Plus(Simp(Times(Coeff($s("§px"), x, q), Power(x, Subtract(q, C5)), Sqrt(Plus(a, Times(c, Power(x, C4)))), Power(Times(c, e, Subtract(q, C3)), CN1)), x), Dist(Power(Times(c, e, Subtract(q, C3)), CN1), Int(Times(Subtract(Times(c, e, Subtract(q, C3), $s("§px")), Times(Coeff($s("§px"), x, q), Power(x, Subtract(q, C6)), Plus(d, Times(e, Sqr(x))), Plus(Times(a, Subtract(q, C5)), Times(c, Subtract(q, C3), Power(x, C4))))), Power(Times(Plus(d, Times(e, Sqr(x))), Sqrt(Plus(a, Times(c, Power(x, C4))))), CN1)), x), x)), GtQ(q, C4))), And(FreeQ(List(a, c, d, e), x), PolyQ($s("§px"), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0))));
            IIntegrate(1720, Int(Times($p("§px"), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1D2), Times($s("§px"), Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), Plus(p, C1D2))), x), x), And(FreeQ(List(a, b, c, d, e), x), PolyQ($s("§px"), Sqr(x)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), IntegerQ(Plus(p, C1D2)), IntegerQ(q))));
            IIntegrate(1721, Int(Times($p("§px"), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Power(Plus(a, Times(c, Power(x, C4))), CN1D2), Times($s("§px"), Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(a, Times(c, Power(x, C4))), Plus(p, C1D2))), x), x), And(FreeQ(List(a, c, d, e), x), PolyQ($s("§px"), Sqr(x)), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), IntegerQ(Plus(p, C1D2)), IntegerQ(q))));
            IIntegrate(1722, Int(Times($p("§px"), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times($s("§px"), Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p)), x), And(FreeQ(List(a, b, c, d, e, p, q), x), PolyQ($s("§px"), x))));
            IIntegrate(1723, Int(Times($p("§px"), Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Unintegrable(Times($s("§px"), Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(a, Times(c, Power(x, C4))), p)), x), And(FreeQ(List(a, c, d, e, p, q), x), PolyQ($s("§px"), x))));
            IIntegrate(1724, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), CN1), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(Subtract(Dist(d, Int(Power(Times(Subtract(Sqr(d), Times(Sqr(e), Sqr(x))), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1), x), x), Dist(e, Int(Times(x, Power(Times(Subtract(Sqr(d), Times(Sqr(e), Sqr(x))), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))))), CN1)), x), x)), FreeQ(List(a, b, c, d, e), x)));
            IIntegrate(1725, Int(Times(Power(Plus(d_, Times(e_DEFAULT, x_)), CN1), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1D2)), x_Symbol),
                    Condition(Subtract(Dist(d, Int(Power(Times(Subtract(Sqr(d), Times(Sqr(e), Sqr(x))), Sqrt(Plus(a, Times(c, Power(x, C4))))), CN1), x), x), Dist(e, Int(Times(x, Power(Times(Subtract(Sqr(d), Times(Sqr(e), Sqr(x))), Sqrt(Plus(a, Times(c, Power(x, C4))))), CN1)), x), x)), FreeQ(List(a, c, d, e), x)));
        }
    }
}
