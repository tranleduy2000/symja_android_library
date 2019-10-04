package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.PolynomialQuotient;
import static org.matheclipse.core.expression.F.PolynomialRemainder;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sqr;
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
import static org.matheclipse.core.expression.F.q_;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.r;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Coeff;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NegQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules46 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(1151, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), FracPart(p)), Power(Times(Power(Plus(d, Times(e, Sqr(x))), FracPart(p)), Power(Plus(Times(a, Power(d, CN1)), Times(c, Sqr(x), Power(e, CN1))), FracPart(p))), CN1)), Int(Times(Power(Plus(d, Times(e, Sqr(x))), Plus(p, q)), Power(Plus(Times(a, Power(d, CN1)), Times(c, Sqr(x), Power(e, CN1))), p)), x), x), And(FreeQ(List(a, b, c, d, e, p, q), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), Not(IntegerQ(p)))));
            IIntegrate(1152, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(c, Power(x, C4))), FracPart(p)), Power(Times(Power(Plus(d, Times(e, Sqr(x))), FracPart(p)), Power(Plus(Times(a, Power(d, CN1)), Times(c, Sqr(x), Power(e, CN1))), FracPart(p))), CN1)), Int(Times(Power(Plus(d, Times(e, Sqr(x))), Plus(p, q)), Power(Plus(Times(a, Power(d, CN1)), Times(c, Sqr(x), Power(e, CN1))), p)), x), x), And(FreeQ(List(a, c, d, e, p, q), x), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IntegerQ(p)))));
            IIntegrate(1153, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p)), x), x), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), IGtQ(p, C0), IGtQ(q, CN2))));
            IIntegrate(1154, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(a, Times(c, Power(x, C4))), p)), x), x), And(FreeQ(List(a, c, d, e), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), IGtQ(p, C0), IGtQ(q, CN2))));
            IIntegrate(1155, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(a, p), x, Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Power(d, CN1)), x), Dist(Power(d, CN1), Int(Times(Sqr(x), Power(Plus(d, Times(e, Sqr(x))), q), Subtract(Times(d, PolynomialQuotient(Subtract(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p), Power(a, p)), Sqr(x), x)), Times(e, Power(a, p), Plus(Times(C2, q), C3)))), x), x)), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), IGtQ(p, C0), ILtQ(Plus(q, C1D2), C0), LtQ(Plus(Times(C4, p), Times(C2, q), C1), C0))));
            IIntegrate(1156, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(a, p), x, Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Power(d, CN1)), x), Dist(Power(d, CN1), Int(Times(Sqr(x), Power(Plus(d, Times(e, Sqr(x))), q), Subtract(Times(d, PolynomialQuotient(Subtract(Power(Plus(a, Times(c, Power(x, C4))), p), Power(a, p)), Sqr(x), x)), Times(e, Power(a, p), Plus(Times(C2, q), C3)))), x), x)), And(FreeQ(List(a, c, d, e), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), IGtQ(p, C0), ILtQ(Plus(q, C1D2), C0), LtQ(Plus(Times(C4, p), Times(C2, q), C1), C0))));
            IIntegrate(1157, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set($s("§qx"), PolynomialQuotient(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p), Plus(d, Times(e, Sqr(x))), x)), Set($s("R"), Coeff(PolynomialRemainder(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p), Plus(d, Times(e, Sqr(x))), x), x, C0))), Plus(Negate(Simp(Times($s("R"), x, Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Power(Times(C2, d, Plus(q, C1)), CN1)), x)), Dist(Power(Times(C2, d, Plus(q, C1)), CN1), Int(Times(Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), ExpandToSum(Plus(Times(C2, d, Plus(q, C1), $s("§qx")), Times($s("R"), Plus(Times(C2, q), C3))), x)), x), x))), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), IGtQ(p, C0), LtQ(q, CN1))));
            IIntegrate(1158, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(With(List(Set($s("§qx"), PolynomialQuotient(Power(Plus(a, Times(c, Power(x, C4))), p), Plus(d, Times(e, Sqr(x))), x)), Set($s("R"), Coeff(PolynomialRemainder(Power(Plus(a, Times(c, Power(x, C4))), p), Plus(d, Times(e, Sqr(x))), x), x, C0))), Plus(Negate(Simp(Times($s("R"), x, Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Power(Times(C2, d, Plus(q, C1)), CN1)), x)), Dist(Power(Times(C2, d, Plus(q, C1)), CN1), Int(Times(Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), ExpandToSum(Plus(Times(C2, d, Plus(q, C1), $s("§qx")), Times($s("R"), Plus(Times(C2, q), C3))), x)), x), x))), And(FreeQ(List(a, c, d, e), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), IGtQ(p, C0), LtQ(q, CN1))));
            IIntegrate(1159, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(c, p), Power(x, Subtract(Times(C4, p), C1)), Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Power(Times(e, Plus(Times(C4, p), Times(C2, q), C1)), CN1)), x), Dist(Power(Times(e, Plus(Times(C4, p), Times(C2, q), C1)), CN1), Int(Times(Power(Plus(d, Times(e, Sqr(x))), q), ExpandToSum(Subtract(Subtract(Times(e, Plus(Times(C4, p), Times(C2, q), C1), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), p)), Times(d, Power(c, p), Subtract(Times(C4, p), C1), Power(x, Subtract(Times(C4, p), C2)))), Times(e, Power(c, p), Plus(Times(C4, p), Times(C2, q), C1), Power(x, Times(C4, p)))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, q), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), IGtQ(p, C0), Not(LtQ(q, CN1)))));
            IIntegrate(1160, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(c, p), Power(x, Subtract(Times(C4, p), C1)), Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Power(Times(e, Plus(Times(C4, p), Times(C2, q), C1)), CN1)), x), Dist(Power(Times(e, Plus(Times(C4, p), Times(C2, q), C1)), CN1), Int(Times(Power(Plus(d, Times(e, Sqr(x))), q), ExpandToSum(Subtract(Subtract(Times(e, Plus(Times(C4, p), Times(C2, q), C1), Power(Plus(a, Times(c, Power(x, C4))), p)), Times(d, Power(c, p), Subtract(Times(C4, p), C1), Power(x, Subtract(Times(C4, p), C2)))), Times(e, Power(c, p), Plus(Times(C4, p), Times(C2, q), C1), Power(x, Times(C4, p)))), x)), x), x)), And(FreeQ(List(a, c, d, e, q), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), IGtQ(p, C0), Not(LtQ(q, CN1)))));
            IIntegrate(1161, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Times(C2, d, Power(e, CN1)), Times(b, Power(c, CN1))), C2))), Plus(Dist(Times(e, Power(Times(C2, c), CN1)), Int(Power(Simp(Plus(Times(d, Power(e, CN1)), Times(q, x), Sqr(x)), x), CN1), x), x), Dist(Times(e, Power(Times(C2, c), CN1)), Int(Power(Simp(Plus(Times(d, Power(e, CN1)), Times(CN1, q, x), Sqr(x)), x), CN1), x), x))), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Or(GtQ(Subtract(Times(C2, d, Power(e, CN1)), Times(b, Power(c, CN1))), C0), And(Not(LtQ(Subtract(Times(C2, d, Power(e, CN1)), Times(b, Power(c, CN1))), C0)), EqQ(Subtract(d, Times(e, Rt(Times(a, Power(c, CN1)), C2))), C0))))));
            IIntegrate(1162, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(C2, d, Power(e, CN1)), C2))), Plus(Dist(Times(e, Power(Times(C2, c), CN1)), Int(Power(Simp(Plus(Times(d, Power(e, CN1)), Times(q, x), Sqr(x)), x), CN1), x), x), Dist(Times(e, Power(Times(C2, c), CN1)), Int(Power(Simp(Plus(Times(d, Power(e, CN1)), Times(CN1, q, x), Sqr(x)), x), CN1), x), x))), And(FreeQ(List(a, c, d, e), x), EqQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), PosQ(Times(d, e)))));
            IIntegrate(1163, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Plus(Dist(Plus(Times(C1D2, e), Times(Subtract(Times(C2, c, d), Times(b, e)), Power(Times(C2, q), CN1))), Int(Power(Plus(Times(C1D2, b), Times(CN1, C1D2, q), Times(c, Sqr(x))), CN1), x), x), Dist(Subtract(Times(C1D2, e), Times(Subtract(Times(C2, c, d), Times(b, e)), Power(Times(C2, q), CN1))), Int(Power(Plus(Times(C1D2, b), Times(C1D2, q), Times(c, Sqr(x))), CN1), x), x))), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), GtQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(1164, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Times(CN2, d, Power(e, CN1)), Times(b, Power(c, CN1))), C2))), Plus(Dist(Times(e, Power(Times(C2, c, q), CN1)), Int(Times(Subtract(q, Times(C2, x)), Power(Simp(Subtract(Plus(Times(d, Power(e, CN1)), Times(q, x)), Sqr(x)), x), CN1)), x), x), Dist(Times(e, Power(Times(C2, c, q), CN1)), Int(Times(Plus(q, Times(C2, x)), Power(Simp(Subtract(Subtract(Times(d, Power(e, CN1)), Times(q, x)), Sqr(x)), x), CN1)), x), x))), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(GtQ(Subtract(Sqr(b), Times(C4, a, c)), C0)))));
            IIntegrate(1165, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(CN2, d, Power(e, CN1)), C2))), Plus(Dist(Times(e, Power(Times(C2, c, q), CN1)), Int(Times(Subtract(q, Times(C2, x)), Power(Simp(Subtract(Plus(Times(d, Power(e, CN1)), Times(q, x)), Sqr(x)), x), CN1)), x), x), Dist(Times(e, Power(Times(C2, c, q), CN1)), Int(Times(Plus(q, Times(C2, x)), Power(Simp(Subtract(Subtract(Times(d, Power(e, CN1)), Times(q, x)), Sqr(x)), x), CN1)), x), x))), And(FreeQ(List(a, c, d, e), x), EqQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), NegQ(Times(d, e)))));
            IIntegrate(1166, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Plus(Dist(Plus(Times(C1D2, e), Times(Subtract(Times(C2, c, d), Times(b, e)), Power(Times(C2, q), CN1))), Int(Power(Plus(Times(C1D2, b), Times(CN1, C1D2, q), Times(c, Sqr(x))), CN1), x), x), Dist(Subtract(Times(C1D2, e), Times(Subtract(Times(C2, c, d), Times(b, e)), Power(Times(C2, q), CN1))), Int(Power(Plus(Times(C1D2, b), Times(C1D2, q), Times(c, Sqr(x))), CN1), x), x))), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), PosQ(Subtract(Sqr(b), Times(C4, a, c))))));
            IIntegrate(1167, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(CN1, a, c), C2))), Plus(Dist(Plus(Times(C1D2, e), Times(c, d, Power(Times(C2, q), CN1))), Int(Power(Plus(Negate(q), Times(c, Sqr(x))), CN1), x), x), Dist(Subtract(Times(C1D2, e), Times(c, d, Power(Times(C2, q), CN1))), Int(Power(Plus(q, Times(c, Sqr(x))), CN1), x), x))), And(FreeQ(List(a, c, d, e), x), NeQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), PosQ(Times(CN1, a, c)))));
            IIntegrate(1168, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(a, c), C2))), Plus(Dist(Times(Plus(Times(d, q), Times(a, e)), Power(Times(C2, a, c), CN1)), Int(Times(Plus(q, Times(c, Sqr(x))), Power(Plus(a, Times(c, Power(x, C4))), CN1)), x), x), Dist(Times(Subtract(Times(d, q), Times(a, e)), Power(Times(C2, a, c), CN1)), Int(Times(Subtract(q, Times(c, Sqr(x))), Power(Plus(a, Times(c, Power(x, C4))), CN1)), x), x))), And(FreeQ(List(a, c, d, e), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), NeQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), NegQ(Times(CN1, a, c)))));
            IIntegrate(1169, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(a, Power(c, CN1)), C2))), With(List(Set(r, Rt(Subtract(Times(C2, q), Times(b, Power(c, CN1))), C2))), Plus(Dist(Power(Times(C2, c, q, r), CN1), Int(Times(Subtract(Times(d, r), Times(Subtract(d, Times(e, q)), x)), Power(Plus(q, Times(CN1, r, x), Sqr(x)), CN1)), x), x), Dist(Power(Times(C2, c, q, r), CN1), Int(Times(Plus(Times(d, r), Times(Subtract(d, Times(e, q)), x)), Power(Plus(q, Times(r, x), Sqr(x)), CN1)), x), x)))), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), NegQ(Subtract(Sqr(b), Times(C4, a, c))))));
            IIntegrate(1170, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1)), x), x), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), IntegerQ(q))));
            IIntegrate(1171, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(a, Times(c, Power(x, C4))), CN1)), x), x), And(FreeQ(List(a, c, d, e), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), IntegerQ(q))));
            IIntegrate(1172, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(Plus(Dist(Times(Sqr(e), Power(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), CN1)), Int(Power(Plus(d, Times(e, Sqr(x))), q), x), x), Dist(Power(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), CN1), Int(Times(Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Subtract(Subtract(Times(c, d), Times(b, e)), Times(c, e, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, C4))), CN1)), x), x)), And(FreeQ(List(a, b, c, d, e), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), Not(IntegerQ(q)), LtQ(q, CN1))));
            IIntegrate(1173, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(Plus(Dist(Times(Sqr(e), Power(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1)), Int(Power(Plus(d, Times(e, Sqr(x))), q), x), x), Dist(Times(c, Power(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), CN1)), Int(Times(Power(Plus(d, Times(e, Sqr(x))), Plus(q, C1)), Subtract(d, Times(e, Sqr(x))), Power(Plus(a, Times(c, Power(x, C4))), CN1)), x), x)), And(FreeQ(List(a, c, d, e), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IntegerQ(q)), LtQ(q, CN1))));
            IIntegrate(1174, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(With(List(Set(r, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Subtract(Dist(Times(C2, c, Power(r, CN1)), Int(Times(Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(b, Negate(r), Times(C2, c, Sqr(x))), CN1)), x), x), Dist(Times(C2, c, Power(r, CN1)), Int(Times(Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(b, r, Times(C2, c, Sqr(x))), CN1)), x), x))), And(FreeQ(List(a, b, c, d, e, q), x), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), Not(IntegerQ(q)))));
            IIntegrate(1175, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C4))), CN1)), x_Symbol),
                    Condition(With(List(Set(r, Rt(Times(CN1, a, c), C2))), Subtract(Negate(Dist(Times(c, Power(Times(C2, r), CN1)), Int(Times(Power(Plus(d, Times(e, Sqr(x))), q), Power(Subtract(r, Times(c, Sqr(x))), CN1)), x), x)), Dist(Times(c, Power(Times(C2, r), CN1)), Int(Times(Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(r, Times(c, Sqr(x))), CN1)), x), x))), And(FreeQ(List(a, c, d, e, q), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IntegerQ(q)))));
        }
    }
}
