package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.C6;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.CSqrt2;
import static org.matheclipse.core.expression.F.CSqrt3;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
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
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
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
public class IntRules56 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(1401, Int(Times(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), Power(Plus(Times(b_DEFAULT, Power(x_, n_)), Times(c_DEFAULT, Power(x_, $p("n2")))), p_)), x_Symbol),
                    Condition(Subtract(Simp(Times(e, Power(x, Plus(Negate(n), C1)), Power(Plus(Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), Plus(p, C1)), Power(Times(c, Plus(Times(n, Plus(Times(C2, p), C1)), C1)), CN1)), x), Dist(Times(Subtract(Times(b, e, Plus(Times(n, p), C1)), Times(c, d, Plus(Times(n, Plus(Times(C2, p), C1)), C1))), Power(Times(c, Plus(Times(n, Plus(Times(C2, p), C1)), C1)), CN1)), Int(Power(Plus(Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p), x), x)), And(FreeQ(List(b, c, d, e, n, p), x), EqQ($s("n2"), Times(C2, n)), Not(IntegerQ(p)), NeQ(Plus(Times(n, Plus(Times(C2, p), C1)), C1), C0), NeQ(Subtract(Times(b, e, Plus(Times(n, p), C1)), Times(c, d, Plus(Times(n, Plus(Times(C2, p), C1)), C1))), C0))));
            IIntegrate(1402, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT), Power(Plus(Times(b_DEFAULT, Power(x_, n_)), Times(c_DEFAULT, Power(x_, $p("n2")))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), FracPart(p)), Power(Times(Power(x, Times(n, FracPart(p))), Power(Plus(b, Times(c, Power(x, n))), FracPart(p))), CN1)), Int(Times(Power(x, Times(n, p)), Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(b, Times(c, Power(x, n))), p)), x), x), And(FreeQ(List(b, c, d, e, n, p, q), x), EqQ($s("n2"), Times(C2, n)), Not(IntegerQ(p)))));
            IIntegrate(1403, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_)), Times(c_DEFAULT, Power(x_, $p("n2")))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Plus(d, Times(e, Power(x, n))), Plus(p, q)), Power(Plus(Times(a, Power(d, CN1)), Times(c, Power(x, n), Power(e, CN1))), p)), x), And(FreeQ(List(a, b, c, d, e, n, q), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), IntegerQ(p))));
            IIntegrate(1404, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2")))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Plus(d, Times(e, Power(x, n))), Plus(p, q)), Power(Plus(Times(a, Power(d, CN1)), Times(c, Power(x, n), Power(e, CN1))), p)), x), And(FreeQ(List(a, c, d, e, n, q), x), EqQ($s("n2"), Times(C2, n)), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), IntegerQ(p))));
            IIntegrate(1405, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_)), Times(c_DEFAULT, Power(x_, $p("n2")))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), FracPart(p)), Power(Times(Power(Plus(d, Times(e, Power(x, n))), FracPart(p)), Power(Plus(Times(a, Power(d, CN1)), Times(c, Power(x, n), Power(e, CN1))), FracPart(p))), CN1)), Int(Times(Power(Plus(d, Times(e, Power(x, n))), Plus(p, q)), Power(Plus(Times(a, Power(d, CN1)), Times(c, Power(x, n), Power(e, CN1))), p)), x), x), And(FreeQ(List(a, b, c, d, e, n, p, q), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), Not(IntegerQ(p)))));
            IIntegrate(1406, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2")))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(c, Power(x, Times(C2, n)))), FracPart(p)), Power(Times(Power(Plus(d, Times(e, Power(x, n))), FracPart(p)), Power(Plus(Times(a, Power(d, CN1)), Times(c, Power(x, n), Power(e, CN1))), FracPart(p))), CN1)), Int(Times(Power(Plus(d, Times(e, Power(x, n))), Plus(p, q)), Power(Plus(Times(a, Power(d, CN1)), Times(c, Power(x, n), Power(e, CN1))), p)), x), x), And(FreeQ(List(a, c, d, e, n, p, q), x), EqQ($s("n2"), Times(C2, n)), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Not(IntegerQ(p)))));
            IIntegrate(1407, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT), Plus(a_, Times(b_DEFAULT, Power(x_, n_)), Times(c_DEFAULT, Power(x_, $p("n2"))))), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(d, Times(e, Power(x, n))), q), Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n))))), x), x), And(FreeQ(List(a, b, c, d, e, n), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), IGtQ(q, C0))));
            IIntegrate(1408, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_DEFAULT), Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2"))))), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(d, Times(e, Power(x, n))), q), Plus(a, Times(c, Power(x, Times(C2, n))))), x), x), And(FreeQ(List(a, c, d, e, n), x), EqQ($s("n2"), Times(C2, n)), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), IGtQ(q, C0))));
            IIntegrate(1409, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_), Plus(a_, Times(b_DEFAULT, Power(x_, n_)), Times(c_DEFAULT, Power(x_, $p("n2"))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), x, Power(Plus(d, Times(e, Power(x, n))), Plus(q, C1)), Power(Times(d, Sqr(e), n, Plus(q, C1)), CN1)), x)), Dist(Power(Times(n, Plus(q, C1), d, Sqr(e)), CN1), Int(Times(Power(Plus(d, Times(e, Power(x, n))), Plus(q, C1)), Simp(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e), Plus(Times(n, Plus(q, C1)), C1)), Times(c, d, e, n, Plus(q, C1), Power(x, n))), x)), x), x)), And(FreeQ(List(a, b, c, d, e, n), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), LtQ(q, CN1))));
            IIntegrate(1410, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_), Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2"))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), x, Power(Plus(d, Times(e, Power(x, n))), Plus(q, C1)), Power(Times(d, Sqr(e), n, Plus(q, C1)), CN1)), x)), Dist(Power(Times(n, Plus(q, C1), d, Sqr(e)), CN1), Int(Times(Power(Plus(d, Times(e, Power(x, n))), Plus(q, C1)), Simp(Plus(Times(c, Sqr(d)), Times(a, Sqr(e), Plus(Times(n, Plus(q, C1)), C1)), Times(c, d, e, n, Plus(q, C1), Power(x, n))), x)), x), x)), And(FreeQ(List(a, c, d, e, n), x), EqQ($s("n2"), Times(C2, n)), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), LtQ(q, CN1))));
            IIntegrate(1411, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_), Plus(a_, Times(b_DEFAULT, Power(x_, n_)), Times(c_DEFAULT, Power(x_, $p("n2"))))), x_Symbol),
                    Condition(Plus(Simp(Times(c, Power(x, Plus(n, C1)), Power(Plus(d, Times(e, Power(x, n))), Plus(q, C1)), Power(Times(e, Plus(Times(n, Plus(q, C2)), C1)), CN1)), x), Dist(Power(Times(e, Plus(Times(n, Plus(q, C2)), C1)), CN1), Int(Times(Power(Plus(d, Times(e, Power(x, n))), q), Subtract(Times(a, e, Plus(Times(n, Plus(q, C2)), C1)), Times(Subtract(Times(c, d, Plus(n, C1)), Times(b, e, Plus(Times(n, Plus(q, C2)), C1))), Power(x, n)))), x), x)), And(FreeQ(List(a, b, c, d, e, n, q), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0))));
            IIntegrate(1412, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_), Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2"))))), x_Symbol),
                    Condition(Plus(Simp(Times(c, Power(x, Plus(n, C1)), Power(Plus(d, Times(e, Power(x, n))), Plus(q, C1)), Power(Times(e, Plus(Times(n, Plus(q, C2)), C1)), CN1)), x), Dist(Power(Times(e, Plus(Times(n, Plus(q, C2)), C1)), CN1), Int(Times(Power(Plus(d, Times(e, Power(x, n))), q), Subtract(Times(a, e, Plus(Times(n, Plus(q, C2)), C1)), Times(c, d, Plus(n, C1), Power(x, n)))), x), x)), And(FreeQ(List(a, c, d, e, n, q), x), EqQ($s("n2"), Times(C2, n)), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0))));
            IIntegrate(1413, Int(Times(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2")))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(C2, d, e), C2))), Plus(Dist(Times(Sqr(e), Power(Times(C2, c), CN1)), Int(Power(Plus(d, Times(q, Power(x, Times(C1D2, n))), Times(e, Power(x, n))), CN1), x), x), Dist(Times(Sqr(e), Power(Times(C2, c), CN1)), Int(Power(Plus(d, Times(CN1, q, Power(x, Times(C1D2, n))), Times(e, Power(x, n))), CN1), x), x))), And(FreeQ(List(a, c, d, e), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), IGtQ(Times(C1D2, n), C0), PosQ(Times(d, e)))));
            IIntegrate(1414, Int(Times(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2")))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(CN2, d, e), C2))), Plus(Dist(Times(d, Power(Times(C2, a), CN1)), Int(Times(Subtract(d, Times(q, Power(x, Times(C1D2, n)))), Power(Subtract(Subtract(d, Times(q, Power(x, Times(C1D2, n)))), Times(e, Power(x, n))), CN1)), x), x), Dist(Times(d, Power(Times(C2, a), CN1)), Int(Times(Plus(d, Times(q, Power(x, Times(C1D2, n)))), Power(Subtract(Plus(d, Times(q, Power(x, Times(C1D2, n)))), Times(e, Power(x, n))), CN1)), x), x))), And(FreeQ(List(a, c, d, e), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), IGtQ(Times(C1D2, n), C0), NegQ(Times(d, e)))));
            IIntegrate(1415, Int(Times(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2")))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(a, Power(c, CN1)), C4))), Plus(Dist(Power(Times(C2, CSqrt2, c, Power(q, C3)), CN1), Int(Times(Subtract(Times(CSqrt2, d, q), Times(Subtract(d, Times(e, Sqr(q))), Power(x, Times(C1D2, n)))), Power(Plus(Sqr(q), Times(CN1, CSqrt2, q, Power(x, Times(C1D2, n))), Power(x, n)), CN1)), x), x), Dist(Power(Times(C2, CSqrt2, c, Power(q, C3)), CN1), Int(Times(Plus(Times(CSqrt2, d, q), Times(Subtract(d, Times(e, Sqr(q))), Power(x, Times(C1D2, n)))), Power(Plus(Sqr(q), Times(CSqrt2, q, Power(x, Times(C1D2, n))), Power(x, n)), CN1)), x), x))), And(FreeQ(List(a, c, d, e), x), EqQ($s("n2"), Times(C2, n)), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), NeQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), IGtQ(Times(C1D2, n), C0), PosQ(Times(a, c)))));
            IIntegrate(1416, Int(Times(Plus(d_, Times(e_DEFAULT, Power(x_, C3))), Power(Plus(a_, Times(c_DEFAULT, Power(x_, C6))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(c, Power(a, CN1)), C6))), Plus(Dist(Power(Times(C3, a, Sqr(q)), CN1), Int(Times(Subtract(Times(Sqr(q), d), Times(e, x)), Power(Plus(C1, Times(Sqr(q), Sqr(x))), CN1)), x), x), Dist(Power(Times(C6, a, Sqr(q)), CN1), Int(Times(Subtract(Times(C2, Sqr(q), d), Times(Subtract(Times(CSqrt3, Power(q, C3), d), e), x)), Power(Plus(C1, Times(CN1, CSqrt3, q, x), Times(Sqr(q), Sqr(x))), CN1)), x), x), Dist(Power(Times(C6, a, Sqr(q)), CN1), Int(Times(Plus(Times(C2, Sqr(q), d), Times(Plus(Times(CSqrt3, Power(q, C3), d), e), x)), Power(Plus(C1, Times(CSqrt3, q, x), Times(Sqr(q), Sqr(x))), CN1)), x), x))), And(FreeQ(List(a, c, d, e), x), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), PosQ(Times(c, Power(a, CN1))))));
            IIntegrate(1417, Int(Times(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2")))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(CN1, a, Power(c, CN1)), C2))), Plus(Dist(Times(C1D2, Plus(d, Times(e, q))), Int(Power(Plus(a, Times(c, q, Power(x, n))), CN1), x), x), Dist(Times(C1D2, Subtract(d, Times(e, q))), Int(Power(Subtract(a, Times(c, q, Power(x, n))), CN1), x), x))), And(FreeQ(List(a, c, d, e, n), x), EqQ($s("n2"), Times(C2, n)), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), NegQ(Times(a, c)), IntegerQ(n))));
            IIntegrate(1418, Int(Times(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2")))), CN1)), x_Symbol),
                    Condition(Plus(Dist(d, Int(Power(Plus(a, Times(c, Power(x, Times(C2, n)))), CN1), x), x), Dist(e, Int(Times(Power(x, n), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), CN1)), x), x)), And(FreeQ(List(a, c, d, e, n), x), EqQ($s("n2"), Times(C2, n)), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), Or(PosQ(Times(a, c)), Not(IntegerQ(n))))));
            IIntegrate(1419, Int(Times(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_)), Times(c_DEFAULT, Power(x_, $p("n2")))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Times(C2, d, Power(e, CN1)), Times(b, Power(c, CN1))), C2))), Plus(Dist(Times(e, Power(Times(C2, c), CN1)), Int(Power(Simp(Plus(Times(d, Power(e, CN1)), Times(q, Power(x, Times(C1D2, n))), Power(x, n)), x), CN1), x), x), Dist(Times(e, Power(Times(C2, c), CN1)), Int(Power(Simp(Plus(Times(d, Power(e, CN1)), Times(CN1, q, Power(x, Times(C1D2, n))), Power(x, n)), x), CN1), x), x))), And(FreeQ(List(a, b, c, d, e), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), IGtQ(Times(C1D2, n), C0), Or(GtQ(Subtract(Times(C2, d, Power(e, CN1)), Times(b, Power(c, CN1))), C0), And(Not(LtQ(Subtract(Times(C2, d, Power(e, CN1)), Times(b, Power(c, CN1))), C0)), EqQ(d, Times(e, Rt(Times(a, Power(c, CN1)), C2))))))));
            IIntegrate(1420, Int(Times(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_)), Times(c_DEFAULT, Power(x_, $p("n2")))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Plus(Dist(Plus(Times(C1D2, e), Times(Subtract(Times(C2, c, d), Times(b, e)), Power(Times(C2, q), CN1))), Int(Power(Plus(Times(C1D2, b), Times(CN1, C1D2, q), Times(c, Power(x, n))), CN1), x), x), Dist(Subtract(Times(C1D2, e), Times(Subtract(Times(C2, c, d), Times(b, e)), Power(Times(C2, q), CN1))), Int(Power(Plus(Times(C1D2, b), Times(C1D2, q), Times(c, Power(x, n))), CN1), x), x))), And(FreeQ(List(a, b, c, d, e, n), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), IGtQ(Times(C1D2, n), C0), GtQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(1421, Int(Times(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_)), Times(c_DEFAULT, Power(x_, $p("n2")))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Times(CN2, d, Power(e, CN1)), Times(b, Power(c, CN1))), C2))), Plus(Dist(Times(e, Power(Times(C2, c, q), CN1)), Int(Times(Subtract(q, Times(C2, Power(x, Times(C1D2, n)))), Power(Simp(Subtract(Plus(Times(d, Power(e, CN1)), Times(q, Power(x, Times(C1D2, n)))), Power(x, n)), x), CN1)), x), x), Dist(Times(e, Power(Times(C2, c, q), CN1)), Int(Times(Plus(q, Times(C2, Power(x, Times(C1D2, n)))), Power(Simp(Subtract(Subtract(Times(d, Power(e, CN1)), Times(q, Power(x, Times(C1D2, n)))), Power(x, n)), x), CN1)), x), x))), And(FreeQ(List(a, b, c, d, e), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), EqQ(Subtract(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), IGtQ(Times(C1D2, n), C0), Not(GtQ(Subtract(Sqr(b), Times(C4, a, c)), C0)))));
            IIntegrate(1422, Int(Times(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_)), Times(c_DEFAULT, Power(x_, $p("n2")))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Plus(Dist(Plus(Times(C1D2, e), Times(Subtract(Times(C2, c, d), Times(b, e)), Power(Times(C2, q), CN1))), Int(Power(Plus(Times(C1D2, b), Times(CN1, C1D2, q), Times(c, Power(x, n))), CN1), x), x), Dist(Subtract(Times(C1D2, e), Times(Subtract(Times(C2, c, d), Times(b, e)), Power(Times(C2, q), CN1))), Int(Power(Plus(Times(C1D2, b), Times(C1D2, q), Times(c, Power(x, n))), CN1), x), x))), And(FreeQ(List(a, b, c, d, e, n), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), Or(PosQ(Subtract(Sqr(b), Times(C4, a, c))), Not(IGtQ(Times(C1D2, n), C0))))));
            IIntegrate(1423, Int(Times(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_)), Times(c_DEFAULT, Power(x_, $p("n2")))), CN1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(a, Power(c, CN1)), C2))), With(List(Set(r, Rt(Subtract(Times(C2, q), Times(b, Power(c, CN1))), C2))), Plus(Dist(Power(Times(C2, c, q, r), CN1), Int(Times(Subtract(Times(d, r), Times(Subtract(d, Times(e, q)), Power(x, Times(C1D2, n)))), Power(Plus(q, Times(CN1, r, Power(x, Times(C1D2, n))), Power(x, n)), CN1)), x), x), Dist(Power(Times(C2, c, q, r), CN1), Int(Times(Plus(Times(d, r), Times(Subtract(d, Times(e, q)), Power(x, Times(C1D2, n)))), Power(Plus(q, Times(r, Power(x, Times(C1D2, n))), Power(x, n)), CN1)), x), x)))), And(FreeQ(List(a, b, c, d, e), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), IGtQ(Times(C1D2, n), C0), NegQ(Subtract(Sqr(b), Times(C4, a, c))))));
            IIntegrate(1424, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_), Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_)), Times(c_DEFAULT, Power(x_, $p("n2")))), CN1)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, n), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0), NeQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), IntegerQ(q))));
            IIntegrate(1425, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Power(x_, n_))), q_), Power(Plus(a_, Times(c_DEFAULT, Power(x_, $p("n2")))), CN1)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Plus(d, Times(e, Power(x, n))), q), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), CN1)), x), x), And(FreeQ(List(a, c, d, e, n), x), EqQ($s("n2"), Times(C2, n)), NeQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), IntegerQ(q))));
        }
    }
}
