package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$rubi;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcCos;
import static org.matheclipse.core.expression.F.ArcSin;
import static org.matheclipse.core.expression.F.ArcSinh;
import static org.matheclipse.core.expression.F.ArcTan;
import static org.matheclipse.core.expression.F.ArcTanh;
import static org.matheclipse.core.expression.F.AtomQ;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C1D4;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.C6;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.CN7;
import static org.matheclipse.core.expression.F.CSqrt2;
import static org.matheclipse.core.expression.F.CSqrt3;
import static org.matheclipse.core.expression.F.CompoundExpression;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.EllipticF;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Module;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Numerator;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Pi;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Sum;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.k;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.r;
import static org.matheclipse.core.expression.F.s;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NegQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SplitProduct;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules8 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(201, Int(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), CN1), x_Symbol),
                    Condition(Module(List(Set(r, Numerator(Rt(Times(a, Power(b, CN1)), n))), Set(s, Denominator(Rt(Times(a, Power(b, CN1)), n))), k, u), Simp(CompoundExpression(Set(u, Int(Times(Subtract(r, Times(s, Cos(Times(Subtract(Times(C2, k), C1), Pi, Power(n, CN1))), x)), Power(Plus(Sqr(r), Times(CN1, C2, r, s, Cos(Times(Subtract(Times(C2, k), C1), Pi, Power(n, CN1))), x), Times(Sqr(s), Sqr(x))), CN1)), x)), Plus(Times(r, Int(Power(Plus(r, Times(s, x)), CN1), x), Power(Times(a, n), CN1)), Dist(Times(C2, r, Power(Times(a, n), CN1)), Sum(u, List(k, C1, Times(C1D2, Subtract(n, C1)))), x))), x)), And(FreeQ(List(a, b), x), IGtQ(Times(C1D2, Subtract(n, C3)), C0), PosQ(Times(a, Power(b, CN1))))));
            IIntegrate(202, Int(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), CN1), x_Symbol),
                    Condition(Module(List(Set(r, Numerator(Rt(Times(CN1, a, Power(b, CN1)), n))), Set(s, Denominator(Rt(Times(CN1, a, Power(b, CN1)), n))), k, u), Simp(CompoundExpression(Set(u, Int(Times(Plus(r, Times(s, Cos(Times(Subtract(Times(C2, k), C1), Pi, Power(n, CN1))), x)), Power(Plus(Sqr(r), Times(C2, r, s, Cos(Times(Subtract(Times(C2, k), C1), Pi, Power(n, CN1))), x), Times(Sqr(s), Sqr(x))), CN1)), x)), Plus(Times(r, Int(Power(Subtract(r, Times(s, x)), CN1), x), Power(Times(a, n), CN1)), Dist(Times(C2, r, Power(Times(a, n), CN1)), Sum(u, List(k, C1, Times(C1D2, Subtract(n, C1)))), x))), x)), And(FreeQ(List(a, b), x), IGtQ(Times(C1D2, Subtract(n, C3)), C0), NegQ(Times(a, Power(b, CN1))))));
            IIntegrate(203, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1), x_Symbol),
                    Condition(Simp(Times(C1, ArcTan(Times(Rt(b, C2), x, Power(Rt(a, C2), CN1))), Power(Times(Rt(a, C2), Rt(b, C2)), CN1)), x), And(FreeQ(List(a, b), x), PosQ(Times(a, Power(b, CN1))), Or(GtQ(a, C0), GtQ(b, C0)))));
            IIntegrate(204, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1), x_Symbol),
                    Condition(Negate(Simp(Times(ArcTan(Times(Rt(Negate(b), C2), x, Power(Rt(Negate(a), C2), CN1))), Power(Times(Rt(Negate(a), C2), Rt(Negate(b), C2)), CN1)), x)), And(FreeQ(List(a, b), x), PosQ(Times(a, Power(b, CN1))), Or(LtQ(a, C0), LtQ(b, C0)))));
            IIntegrate(205, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1), x_Symbol),
                    Condition(Simp(Times(Rt(Times(a, Power(b, CN1)), C2), ArcTan(Times(x, Power(Rt(Times(a, Power(b, CN1)), C2), CN1))), Power(a, CN1)), x), And(FreeQ(List(a, b), x), PosQ(Times(a, Power(b, CN1))))));
            IIntegrate(206, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1), x_Symbol),
                    Condition(Simp(Times(C1, ArcTanh(Times(Rt(Negate(b), C2), x, Power(Rt(a, C2), CN1))), Power(Times(Rt(a, C2), Rt(Negate(b), C2)), CN1)), x), And(FreeQ(List(a, b), x), NegQ(Times(a, Power(b, CN1))), Or(GtQ(a, C0), LtQ(b, C0)))));
            IIntegrate(207, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1), x_Symbol),
                    Condition(Negate(Simp(Times(ArcTanh(Times(Rt(b, C2), x, Power(Rt(Negate(a), C2), CN1))), Power(Times(Rt(Negate(a), C2), Rt(b, C2)), CN1)), x)), And(FreeQ(List(a, b), x), NegQ(Times(a, Power(b, CN1))), Or(LtQ(a, C0), GtQ(b, C0)))));
            IIntegrate(208, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1), x_Symbol),
                    Condition(Simp(Times(Rt(Times(CN1, a, Power(b, CN1)), C2), ArcTanh(Times(x, Power(Rt(Times(CN1, a, Power(b, CN1)), C2), CN1))), Power(a, CN1)), x), And(FreeQ(List(a, b), x), NegQ(Times(a, Power(b, CN1))))));
            IIntegrate(209, Int(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), CN1), x_Symbol),
                    Condition(Module(List(Set(r, Numerator(Rt(Times(a, Power(b, CN1)), n))), Set(s, Denominator(Rt(Times(a, Power(b, CN1)), n))), k, u, v), Simp(CompoundExpression(Set(u, Plus(Int(Times(Subtract(r, Times(s, Cos(Times(Subtract(Times(C2, k), C1), Pi, Power(n, CN1))), x)), Power(Plus(Sqr(r), Times(CN1, C2, r, s, Cos(Times(Subtract(Times(C2, k), C1), Pi, Power(n, CN1))), x), Times(Sqr(s), Sqr(x))), CN1)), x), Int(Times(Plus(r, Times(s, Cos(Times(Subtract(Times(C2, k), C1), Pi, Power(n, CN1))), x)), Power(Plus(Sqr(r), Times(C2, r, s, Cos(Times(Subtract(Times(C2, k), C1), Pi, Power(n, CN1))), x), Times(Sqr(s), Sqr(x))), CN1)), x))), Plus(Times(C2, Sqr(r), Int(Power(Plus(Sqr(r), Times(Sqr(s), Sqr(x))), CN1), x), Power(Times(a, n), CN1)), Dist(Times(C2, r, Power(Times(a, n), CN1)), Sum(u, List(k, C1, Times(C1D4, Subtract(n, C2)))), x))), x)), And(FreeQ(List(a, b), x), IGtQ(Times(C1D4, Subtract(n, C2)), C0), PosQ(Times(a, Power(b, CN1))))));
            IIntegrate(210, Int(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), CN1), x_Symbol),
                    Condition(Module(List(Set(r, Numerator(Rt(Times(CN1, a, Power(b, CN1)), n))), Set(s, Denominator(Rt(Times(CN1, a, Power(b, CN1)), n))), k, u), Simp(CompoundExpression(Set(u, Plus(Int(Times(Subtract(r, Times(s, Cos(Times(C2, k, Pi, Power(n, CN1))), x)), Power(Plus(Sqr(r), Times(CN1, C2, r, s, Cos(Times(C2, k, Pi, Power(n, CN1))), x), Times(Sqr(s), Sqr(x))), CN1)), x), Int(Times(Plus(r, Times(s, Cos(Times(C2, k, Pi, Power(n, CN1))), x)), Power(Plus(Sqr(r), Times(C2, r, s, Cos(Times(C2, k, Pi, Power(n, CN1))), x), Times(Sqr(s), Sqr(x))), CN1)), x))), Plus(Times(C2, Sqr(r), Int(Power(Subtract(Sqr(r), Times(Sqr(s), Sqr(x))), CN1), x), Power(Times(a, n), CN1)), Dist(Times(C2, r, Power(Times(a, n), CN1)), Sum(u, List(k, C1, Times(C1D4, Subtract(n, C2)))), x))), x)), And(FreeQ(List(a, b), x), IGtQ(Times(C1D4, Subtract(n, C2)), C0), NegQ(Times(a, Power(b, CN1))))));
            IIntegrate(211, Int(Power(Plus(a_, Times(b_DEFAULT, Power(x_, C4))), CN1), x_Symbol),
                    Condition(With(List(Set(r, Numerator(Rt(Times(a, Power(b, CN1)), C2))), Set(s, Denominator(Rt(Times(a, Power(b, CN1)), C2)))), Plus(Dist(Power(Times(C2, r), CN1), Int(Times(Subtract(r, Times(s, Sqr(x))), Power(Plus(a, Times(b, Power(x, C4))), CN1)), x), x), Dist(Power(Times(C2, r), CN1), Int(Times(Plus(r, Times(s, Sqr(x))), Power(Plus(a, Times(b, Power(x, C4))), CN1)), x), x))), And(FreeQ(List(a, b), x), Or(GtQ(Times(a, Power(b, CN1)), C0), And(PosQ(Times(a, Power(b, CN1))), AtomQ(SplitProduct($rubi("SumBaseQ"), a)), AtomQ(SplitProduct($rubi("SumBaseQ"), b)))))));
            IIntegrate(212, Int(Power(Plus(a_, Times(b_DEFAULT, Power(x_, C4))), CN1), x_Symbol),
                    Condition(With(List(Set(r, Numerator(Rt(Times(CN1, a, Power(b, CN1)), C2))), Set(s, Denominator(Rt(Times(CN1, a, Power(b, CN1)), C2)))), Plus(Dist(Times(r, Power(Times(C2, a), CN1)), Int(Power(Subtract(r, Times(s, Sqr(x))), CN1), x), x), Dist(Times(r, Power(Times(C2, a), CN1)), Int(Power(Plus(r, Times(s, Sqr(x))), CN1), x), x))), And(FreeQ(List(a, b), x), Not(GtQ(Times(a, Power(b, CN1)), C0)))));
            IIntegrate(213, Int(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), CN1), x_Symbol),
                    Condition(With(List(Set(r, Numerator(Rt(Times(a, Power(b, CN1)), C4))), Set(s, Denominator(Rt(Times(a, Power(b, CN1)), C4)))), Plus(Dist(Times(r, Power(Times(C2, CSqrt2, a), CN1)), Int(Times(Subtract(Times(CSqrt2, r), Times(s, Power(x, Times(C1D4, n)))), Power(Plus(Sqr(r), Times(CN1, CSqrt2, r, s, Power(x, Times(C1D4, n))), Times(Sqr(s), Power(x, Times(C1D2, n)))), CN1)), x), x), Dist(Times(r, Power(Times(C2, CSqrt2, a), CN1)), Int(Times(Plus(Times(CSqrt2, r), Times(s, Power(x, Times(C1D4, n)))), Power(Plus(Sqr(r), Times(CSqrt2, r, s, Power(x, Times(C1D4, n))), Times(Sqr(s), Power(x, Times(C1D2, n)))), CN1)), x), x))), And(FreeQ(List(a, b), x), IGtQ(Times(C1D4, n), C1), GtQ(Times(a, Power(b, CN1)), C0))));
            IIntegrate(214, Int(Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), CN1), x_Symbol),
                    Condition(With(List(Set(r, Numerator(Rt(Times(CN1, a, Power(b, CN1)), C2))), Set(s, Denominator(Rt(Times(CN1, a, Power(b, CN1)), C2)))), Plus(Dist(Times(r, Power(Times(C2, a), CN1)), Int(Power(Subtract(r, Times(s, Power(x, Times(C1D2, n)))), CN1), x), x), Dist(Times(r, Power(Times(C2, a), CN1)), Int(Power(Plus(r, Times(s, Power(x, Times(C1D2, n)))), CN1), x), x))), And(FreeQ(List(a, b), x), IGtQ(Times(C1D4, n), C1), Not(GtQ(Times(a, Power(b, CN1)), C0)))));
            IIntegrate(215, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1D2), x_Symbol),
                    Condition(Simp(Times(ArcSinh(Times(Rt(b, C2), x, Power(a, CN1D2))), Power(Rt(b, C2), CN1)), x), And(FreeQ(List(a, b), x), GtQ(a, C0), PosQ(b))));
            IIntegrate(216, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1D2), x_Symbol),
                    Condition(Simp(Times(ArcSin(Times(Rt(Negate(b), C2), x, Power(a, CN1D2))), Power(Rt(Negate(b), C2), CN1)), x), And(FreeQ(List(a, b), x), GtQ(a, C0), NegQ(b))));
            IIntegrate(217, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_))), CN1D2), x_Symbol),
                    Condition(Subst(Int(Power(Subtract(C1, Times(b, Sqr(x))), CN1), x), x, Times(x, Power(Plus(a, Times(b, Sqr(x))), CN1D2))), And(FreeQ(List(a, b), x), Not(GtQ(a, C0)))));
            IIntegrate(218, Int(Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1D2), x_Symbol),
                    Condition(With(List(Set(r, $($s("§numer"), Rt(Times(b, Power(a, CN1)), C3))), Set(s, $($s("§denom"), Rt(Times(b, Power(a, CN1)), C3)))), Simp(Times(C2, Sqrt(Plus(C2, CSqrt3)), Plus(s, Times(r, x)), Sqrt(Times(Plus(Sqr(s), Times(CN1, r, s, x), Times(Sqr(r), Sqr(x))), Power(Plus(Times(Plus(C1, CSqrt3), s), Times(r, x)), CN2))), EllipticF(ArcSin(Times(Plus(Times(Subtract(C1, CSqrt3), s), Times(r, x)), Power(Plus(Times(Plus(C1, CSqrt3), s), Times(r, x)), CN1))), Subtract(CN7, Times(C4, CSqrt3))), Power(Times(Power(C3, C1D4), r, Sqrt(Plus(a, Times(b, Power(x, C3)))), Sqrt(Times(s, Plus(s, Times(r, x)), Power(Plus(Times(Plus(C1, CSqrt3), s), Times(r, x)), CN2)))), CN1)), x)), And(FreeQ(List(a, b), x), PosQ(a))));
            IIntegrate(219, Int(Power(Plus(a_, Times(b_DEFAULT, Power(x_, C3))), CN1D2), x_Symbol),
                    Condition(With(List(Set(r, $($s("§numer"), Rt(Times(b, Power(a, CN1)), C3))), Set(s, $($s("§denom"), Rt(Times(b, Power(a, CN1)), C3)))), Simp(Times(C2, Sqrt(Subtract(C2, CSqrt3)), Plus(s, Times(r, x)), Sqrt(Times(Plus(Sqr(s), Times(CN1, r, s, x), Times(Sqr(r), Sqr(x))), Power(Plus(Times(Subtract(C1, CSqrt3), s), Times(r, x)), CN2))), EllipticF(ArcSin(Times(Plus(Times(Plus(C1, CSqrt3), s), Times(r, x)), Power(Plus(Times(Subtract(C1, CSqrt3), s), Times(r, x)), CN1))), Plus(CN7, Times(C4, CSqrt3))), Power(Times(Power(C3, C1D4), r, Sqrt(Plus(a, Times(b, Power(x, C3)))), Sqrt(Times(CN1, s, Plus(s, Times(r, x)), Power(Plus(Times(Subtract(C1, CSqrt3), s), Times(r, x)), CN2)))), CN1)), x)), And(FreeQ(List(a, b), x), NegQ(a))));
            IIntegrate(220, Int(Power(Plus(a_, Times(b_DEFAULT, Power(x_, C4))), CN1D2), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(b, Power(a, CN1)), C4))), Simp(Times(Plus(C1, Times(Sqr(q), Sqr(x))), Sqrt(Times(Plus(a, Times(b, Power(x, C4))), Power(Times(a, Sqr(Plus(C1, Times(Sqr(q), Sqr(x))))), CN1))), EllipticF(Times(C2, ArcTan(Times(q, x))), C1D2), Power(Times(C2, q, Sqrt(Plus(a, Times(b, Power(x, C4))))), CN1)), x)), And(FreeQ(List(a, b), x), PosQ(Times(b, Power(a, CN1))))));
            IIntegrate(221, Int(Power(Plus(a_, Times(b_DEFAULT, Power(x_, C4))), CN1D2), x_Symbol),
                    Condition(Simp(Times(EllipticF(ArcSin(Times(Rt(Negate(b), C4), x, Power(Rt(a, C4), CN1))), CN1), Power(Times(Rt(a, C4), Rt(Negate(b), C4)), CN1)), x), And(FreeQ(List(a, b), x), NegQ(Times(b, Power(a, CN1))), GtQ(a, C0))));
            IIntegrate(222, Int(Power(Plus(a_, Times(b_DEFAULT, Power(x_, C4))), CN1D2), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(CN1, a, b), C2))), Condition(Simp(Times(Sqrt(Plus(Negate(a), Times(q, Sqr(x)))), Sqrt(Times(Plus(a, Times(q, Sqr(x))), Power(q, CN1))), EllipticF(ArcSin(Times(x, Power(Times(Plus(a, Times(q, Sqr(x))), Power(Times(C2, q), CN1)), CN1D2))), C1D2), Power(Times(CSqrt2, Sqrt(Negate(a)), Sqrt(Plus(a, Times(b, Power(x, C4))))), CN1)), x), IntegerQ(q))), And(FreeQ(List(a, b), x), LtQ(a, C0), GtQ(b, C0))));
            IIntegrate(223, Int(Power(Plus(a_, Times(b_DEFAULT, Power(x_, C4))), CN1D2), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(CN1, a, b), C2))), Simp(Times(Sqrt(Times(Subtract(a, Times(q, Sqr(x))), Power(Plus(a, Times(q, Sqr(x))), CN1))), Sqrt(Times(Plus(a, Times(q, Sqr(x))), Power(q, CN1))), EllipticF(ArcSin(Times(x, Power(Times(Plus(a, Times(q, Sqr(x))), Power(Times(C2, q), CN1)), CN1D2))), C1D2), Power(Times(CSqrt2, Sqrt(Plus(a, Times(b, Power(x, C4)))), Sqrt(Times(a, Power(Plus(a, Times(q, Sqr(x))), CN1)))), CN1)), x)), And(FreeQ(List(a, b), x), LtQ(a, C0), GtQ(b, C0))));
            IIntegrate(224, Int(Power(Plus(a_, Times(b_DEFAULT, Power(x_, C4))), CN1D2), x_Symbol),
                    Condition(Dist(Times(Sqrt(Plus(C1, Times(b, Power(x, C4), Power(a, CN1)))), Power(Plus(a, Times(b, Power(x, C4))), CN1D2)), Int(Power(Plus(C1, Times(b, Power(x, C4), Power(a, CN1))), CN1D2), x), x), And(FreeQ(List(a, b), x), NegQ(Times(b, Power(a, CN1))), Not(GtQ(a, C0)))));
            IIntegrate(225, Int(Power(Plus(a_, Times(b_DEFAULT, Power(x_, C6))), CN1D2), x_Symbol),
                    Condition(With(List(Set(r, $($s("§numer"), Rt(Times(b, Power(a, CN1)), C3))), Set(s, $($s("§denom"), Rt(Times(b, Power(a, CN1)), C3)))), Simp(Times(x, Plus(s, Times(r, Sqr(x))), Sqrt(Times(Plus(Sqr(s), Times(CN1, r, s, Sqr(x)), Times(Sqr(r), Power(x, C4))), Power(Plus(s, Times(Plus(C1, CSqrt3), r, Sqr(x))), CN2))), EllipticF(ArcCos(Times(Plus(s, Times(Subtract(C1, CSqrt3), r, Sqr(x))), Power(Plus(s, Times(Plus(C1, CSqrt3), r, Sqr(x))), CN1))), Times(C1D4, Plus(C2, CSqrt3))), Power(Times(C2, Power(C3, C1D4), s, Sqrt(Plus(a, Times(b, Power(x, C6)))), Sqrt(Times(r, Sqr(x), Plus(s, Times(r, Sqr(x))), Power(Plus(s, Times(Plus(C1, CSqrt3), r, Sqr(x))), CN2)))), CN1)), x)), FreeQ(List(a, b), x)));
        }
    }
}
