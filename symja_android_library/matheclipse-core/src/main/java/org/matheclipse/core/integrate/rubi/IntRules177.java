package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CI;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.CNI;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Cot;
import static org.matheclipse.core.expression.F.Csc;
import static org.matheclipse.core.expression.F.Exp;
import static org.matheclipse.core.expression.F.FSymbol;
import static org.matheclipse.core.expression.F.F_;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.GSymbol;
import static org.matheclipse.core.expression.F.G_;
import static org.matheclipse.core.expression.F.Hypergeometric2F1;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.MemberQ;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Pi;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sec;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Tan;
import static org.matheclipse.core.expression.F.Times;
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
import static org.matheclipse.core.expression.F.k;
import static org.matheclipse.core.expression.F.k_DEFAULT;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandTrigExpand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandTrigReduce;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.G;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules177 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(4426, Int(Times(Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Sec(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(Plus(a_, Times(b_DEFAULT, Sec(Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), n_DEFAULT), Tan(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(e, Times(f, x)), m), Power(Plus(a, Times(b, Sec(Plus(c, Times(d, x))))), Plus(n, C1)), Power(Times(b, d, Plus(n, C1)), CN1)), x), Dist(Times(f, m, Power(Times(b, d, Plus(n, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Subtract(m, C1)), Power(Plus(a, Times(b, Sec(Plus(c, Times(d, x))))), Plus(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f, n), x), IGtQ(m, C0), NeQ(n, CN1))));
            IIntegrate(4427, Int(Times(Cot(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Csc(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(Plus(Times(Csc(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(e, Times(f, x)), m), Power(Plus(a, Times(b, Csc(Plus(c, Times(d, x))))), Plus(n, C1)), Power(Times(b, d, Plus(n, C1)), CN1)), x)), Dist(Times(f, m, Power(Times(b, d, Plus(n, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Subtract(m, C1)), Power(Plus(a, Times(b, Csc(Plus(c, Times(d, x))))), Plus(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f, n), x), IGtQ(m, C0), NeQ(n, CN1))));
            IIntegrate(4428, Int(Times(Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Sin(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_DEFAULT), Power(Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), q_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrigReduce(Power(Plus(e, Times(f, x)), m), Times(Power(Sin(Plus(a, Times(b, x))), p), Power(Sin(Plus(c, Times(d, x))), q)), x), x), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(p, C0), IGtQ(q, C0), IntegerQ(m))));
            IIntegrate(4429, Int(Times(Power(Cos(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_DEFAULT), Power(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), q_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrigReduce(Power(Plus(e, Times(f, x)), m), Times(Power(Cos(Plus(a, Times(b, x))), p), Power(Cos(Plus(c, Times(d, x))), q)), x), x), And(FreeQ(List(a, b, c, d, e, f), x), IGtQ(p, C0), IGtQ(q, C0), IntegerQ(m))));
            IIntegrate(4430, Int(Times(Power(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), q_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Sin(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrigReduce(Power(Plus(e, Times(f, x)), m), Times(Power(Sin(Plus(a, Times(b, x))), p), Power(Cos(Plus(c, Times(d, x))), q)), x), x), And(FreeQ(List(a, b, c, d, e, f, m), x), IGtQ(p, C0), IGtQ(q, C0))));
            IIntegrate(4431, Int(Times(Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power($(F_, Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_DEFAULT), Power($(G_, Plus(c_DEFAULT, Times(d_DEFAULT, x_))), q_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrigExpand(Times(Power(Plus(e, Times(f, x)), m), Power(G(Plus(c, Times(d, x))), q)), FSymbol, Plus(c, Times(d, x)), p, Times(b, Power(d, CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f, m), x), MemberQ(List(Sin, Cos), FSymbol), MemberQ(List(Sec, Csc), GSymbol), IGtQ(p, C0), IGtQ(q, C0), EqQ(Subtract(Times(b, c), Times(a, d)), C0), IGtQ(Times(b, Power(d, CN1)), C1))));
            IIntegrate(4432, Int(Times(Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Sin(Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), x_Symbol),
                    Condition(Subtract(Simp(Times(b, c, Log(FSymbol), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Sin(Plus(d, Times(e, x))), Power(Plus(Sqr(e), Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), CN1)), x), Simp(Times(e, Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Cos(Plus(d, Times(e, x))), Power(Plus(Sqr(e), Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), CN1)), x)), And(FreeQ(List(FSymbol, a, b, c, d, e), x), NeQ(Plus(Sqr(e), Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), C0))));
            IIntegrate(4433, Int(Times(Cos(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), x_Symbol),
                    Condition(Plus(Simp(Times(b, c, Log(FSymbol), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Cos(Plus(d, Times(e, x))), Power(Plus(Sqr(e), Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), CN1)), x), Simp(Times(e, Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Sin(Plus(d, Times(e, x))), Power(Plus(Sqr(e), Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), CN1)), x)), And(FreeQ(List(FSymbol, a, b, c, d, e), x), NeQ(Plus(Sqr(e), Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), C0))));
            IIntegrate(4434, Int(Times(Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Sin(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_)), x_Symbol),
                    Condition(Plus(Simp(Times(b, c, Log(FSymbol), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Sin(Plus(d, Times(e, x))), n), Power(Plus(Times(Sqr(e), Sqr(n)), Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), CN1)), x), Dist(Times(n, Subtract(n, C1), Sqr(e), Power(Plus(Times(Sqr(e), Sqr(n)), Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), CN1)), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Sin(Plus(d, Times(e, x))), Subtract(n, C2))), x), x), Negate(Simp(Times(e, n, Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Cos(Plus(d, Times(e, x))), Power(Sin(Plus(d, Times(e, x))), Subtract(n, C1)), Power(Plus(Times(Sqr(e), Sqr(n)), Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), CN1)), x))), And(FreeQ(List(FSymbol, a, b, c, d, e), x), NeQ(Plus(Times(Sqr(e), Sqr(n)), Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), C0), GtQ(n, C1))));
            IIntegrate(4435, Int(Times(Power(Cos(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), x_Symbol),
                    Condition(Plus(Simp(Times(b, c, Log(FSymbol), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Cos(Plus(d, Times(e, x))), m), Power(Plus(Times(Sqr(e), Sqr(m)), Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), CN1)), x), Dist(Times(m, Subtract(m, C1), Sqr(e), Power(Plus(Times(Sqr(e), Sqr(m)), Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), CN1)), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Cos(Plus(d, Times(e, x))), Subtract(m, C2))), x), x), Simp(Times(e, m, Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Sin(Plus(d, Times(e, x))), Power(Cos(Plus(d, Times(e, x))), Subtract(m, C1)), Power(Plus(Times(Sqr(e), Sqr(m)), Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), CN1)), x)), And(FreeQ(List(FSymbol, a, b, c, d, e), x), NeQ(Plus(Times(Sqr(e), Sqr(m)), Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), C0), GtQ(m, C1))));
            IIntegrate(4436, Int(Times(Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Sin(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, c, Log(FSymbol), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Sin(Plus(d, Times(e, x))), Plus(n, C2)), Power(Times(Sqr(e), Plus(n, C1), Plus(n, C2)), CN1)), x)), Simp(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Cos(Plus(d, Times(e, x))), Power(Sin(Plus(d, Times(e, x))), Plus(n, C1)), Power(Times(e, Plus(n, C1)), CN1)), x)), And(FreeQ(List(FSymbol, a, b, c, d, e, n), x), EqQ(Plus(Times(Sqr(e), Sqr(Plus(n, C2))), Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), C0), NeQ(n, CN1), NeQ(n, CN2))));
            IIntegrate(4437, Int(Times(Power(Cos(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), x_Symbol),
                    Condition(Subtract(Negate(Simp(Times(b, c, Log(FSymbol), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Cos(Plus(d, Times(e, x))), Plus(n, C2)), Power(Times(Sqr(e), Plus(n, C1), Plus(n, C2)), CN1)), x)), Simp(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Sin(Plus(d, Times(e, x))), Power(Cos(Plus(d, Times(e, x))), Plus(n, C1)), Power(Times(e, Plus(n, C1)), CN1)), x)), And(FreeQ(List(FSymbol, a, b, c, d, e, n), x), EqQ(Plus(Times(Sqr(e), Sqr(Plus(n, C2))), Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), C0), NeQ(n, CN1), NeQ(n, CN2))));
            IIntegrate(4438, Int(Times(Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Sin(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, c, Log(FSymbol), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Sin(Plus(d, Times(e, x))), Plus(n, C2)), Power(Times(Sqr(e), Plus(n, C1), Plus(n, C2)), CN1)), x)), Dist(Times(Plus(Times(Sqr(e), Sqr(Plus(n, C2))), Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), Power(Times(Sqr(e), Plus(n, C1), Plus(n, C2)), CN1)), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Sin(Plus(d, Times(e, x))), Plus(n, C2))), x), x), Simp(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Cos(Plus(d, Times(e, x))), Power(Sin(Plus(d, Times(e, x))), Plus(n, C1)), Power(Times(e, Plus(n, C1)), CN1)), x)), And(FreeQ(List(FSymbol, a, b, c, d, e), x), NeQ(Plus(Times(Sqr(e), Sqr(Plus(n, C2))), Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), C0), LtQ(n, CN1), NeQ(n, CN2))));
            IIntegrate(4439, Int(Times(Power(Cos(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, c, Log(FSymbol), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Cos(Plus(d, Times(e, x))), Plus(n, C2)), Power(Times(Sqr(e), Plus(n, C1), Plus(n, C2)), CN1)), x)), Dist(Times(Plus(Times(Sqr(e), Sqr(Plus(n, C2))), Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), Power(Times(Sqr(e), Plus(n, C1), Plus(n, C2)), CN1)), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Cos(Plus(d, Times(e, x))), Plus(n, C2))), x), x), Negate(Simp(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Sin(Plus(d, Times(e, x))), Power(Cos(Plus(d, Times(e, x))), Plus(n, C1)), Power(Times(e, Plus(n, C1)), CN1)), x))), And(FreeQ(List(FSymbol, a, b, c, d, e), x), NeQ(Plus(Times(Sqr(e), Sqr(Plus(n, C2))), Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), C0), LtQ(n, CN1), NeQ(n, CN2))));
            IIntegrate(4440, Int(Times(Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Sin(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_)), x_Symbol),
                    Condition(Dist(Times(Exp(Times(CI, n, Plus(d, Times(e, x)))), Power(Sin(Plus(d, Times(e, x))), n), Power(Power(Plus(CN1, Exp(Times(C2, CI, Plus(d, Times(e, x))))), n), CN1)), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Plus(CN1, Exp(Times(C2, CI, Plus(d, Times(e, x))))), n), Power(Exp(Times(CI, n, Plus(d, Times(e, x)))), CN1)), x), x), And(FreeQ(List(FSymbol, a, b, c, d, e, n), x), Not(IntegerQ(n)))));
            IIntegrate(4441, Int(Times(Power(Cos(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), x_Symbol),
                    Condition(Dist(Times(Exp(Times(CI, n, Plus(d, Times(e, x)))), Power(Cos(Plus(d, Times(e, x))), n), Power(Power(Plus(C1, Exp(Times(C2, CI, Plus(d, Times(e, x))))), n), CN1)), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Plus(C1, Exp(Times(C2, CI, Plus(d, Times(e, x))))), n), Power(Exp(Times(CI, n, Plus(d, Times(e, x)))), CN1)), x), x), And(FreeQ(List(FSymbol, a, b, c, d, e, n), x), Not(IntegerQ(n)))));
            IIntegrate(4442, Int(Times(Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Tan(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(CI, n), Int(ExpandIntegrand(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Subtract(C1, Exp(Times(C2, CI, Plus(d, Times(e, x))))), n), Power(Power(Plus(C1, Exp(Times(C2, CI, Plus(d, Times(e, x))))), n), CN1)), x), x), x), And(FreeQ(List(FSymbol, a, b, c, d, e), x), IntegerQ(n))));
            IIntegrate(4443, Int(Times(Power(Cot(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), x_Symbol),
                    Condition(Dist(Power(CNI, n), Int(ExpandIntegrand(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Plus(C1, Exp(Times(C2, CI, Plus(d, Times(e, x))))), n), Power(Power(Subtract(C1, Exp(Times(C2, CI, Plus(d, Times(e, x))))), n), CN1)), x), x), x), And(FreeQ(List(FSymbol, a, b, c, d, e), x), IntegerQ(n))));
            IIntegrate(4444, Int(Times(Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Sec(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_)), x_Symbol),
                    Condition(Plus(Simp(Times(b, c, Log(FSymbol), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Sec(Plus(d, Times(e, x))), n), Power(Plus(Times(Sqr(e), Sqr(n)), Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), CN1)), x), Dist(Times(Sqr(e), n, Plus(n, C1), Power(Plus(Times(Sqr(e), Sqr(n)), Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), CN1)), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Sec(Plus(d, Times(e, x))), Plus(n, C2))), x), x), Negate(Simp(Times(e, n, Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Sec(Plus(d, Times(e, x))), Plus(n, C1)), Sin(Plus(d, Times(e, x))), Power(Plus(Times(Sqr(e), Sqr(n)), Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), CN1)), x))), And(FreeQ(List(FSymbol, a, b, c, d, e), x), NeQ(Plus(Times(Sqr(e), Sqr(n)), Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), C0), LtQ(n, CN1))));
            IIntegrate(4445, Int(Times(Power(Csc(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), x_Symbol),
                    Condition(Plus(Simp(Times(b, c, Log(FSymbol), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Csc(Plus(d, Times(e, x))), n), Power(Plus(Times(Sqr(e), Sqr(n)), Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), CN1)), x), Dist(Times(Sqr(e), n, Plus(n, C1), Power(Plus(Times(Sqr(e), Sqr(n)), Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), CN1)), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Csc(Plus(d, Times(e, x))), Plus(n, C2))), x), x), Simp(Times(e, n, Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Csc(Plus(d, Times(e, x))), Plus(n, C1)), Cos(Plus(d, Times(e, x))), Power(Plus(Times(Sqr(e), Sqr(n)), Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), CN1)), x)), And(FreeQ(List(FSymbol, a, b, c, d, e), x), NeQ(Plus(Times(Sqr(e), Sqr(n)), Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), C0), LtQ(n, CN1))));
            IIntegrate(4446, Int(Times(Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Sec(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, c, Log(FSymbol), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Sec(Plus(d, Times(e, x))), Subtract(n, C2)), Power(Times(Sqr(e), Subtract(n, C1), Subtract(n, C2)), CN1)), x)), Simp(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Sec(Plus(d, Times(e, x))), Subtract(n, C1)), Sin(Plus(d, Times(e, x))), Power(Times(e, Subtract(n, C1)), CN1)), x)), And(FreeQ(List(FSymbol, a, b, c, d, e, n), x), EqQ(Plus(Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol))), Times(Sqr(e), Sqr(Subtract(n, C2)))), C0), NeQ(n, C1), NeQ(n, C2))));
            IIntegrate(4447, Int(Times(Power(Csc(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, c, Log(FSymbol), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Csc(Plus(d, Times(e, x))), Subtract(n, C2)), Power(Times(Sqr(e), Subtract(n, C1), Subtract(n, C2)), CN1)), x)), Simp(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Csc(Plus(d, Times(e, x))), Subtract(n, C1)), Cos(Plus(d, Times(e, x))), Power(Times(e, Subtract(n, C1)), CN1)), x)), And(FreeQ(List(FSymbol, a, b, c, d, e, n), x), EqQ(Plus(Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol))), Times(Sqr(e), Sqr(Subtract(n, C2)))), C0), NeQ(n, C1), NeQ(n, C2))));
            IIntegrate(4448, Int(Times(Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Sec(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, c, Log(FSymbol), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Sec(Plus(d, Times(e, x))), Subtract(n, C2)), Power(Times(Sqr(e), Subtract(n, C1), Subtract(n, C2)), CN1)), x)), Dist(Times(Plus(Times(Sqr(e), Sqr(Subtract(n, C2))), Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), Power(Times(Sqr(e), Subtract(n, C1), Subtract(n, C2)), CN1)), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Sec(Plus(d, Times(e, x))), Subtract(n, C2))), x), x), Simp(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Sec(Plus(d, Times(e, x))), Subtract(n, C1)), Sin(Plus(d, Times(e, x))), Power(Times(e, Subtract(n, C1)), CN1)), x)), And(FreeQ(List(FSymbol, a, b, c, d, e), x), NeQ(Plus(Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol))), Times(Sqr(e), Sqr(Subtract(n, C2)))), C0), GtQ(n, C1), NeQ(n, C2))));
            IIntegrate(4449, Int(Times(Power(Csc(Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_), Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_))))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(b, c, Log(FSymbol), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Csc(Plus(d, Times(e, x))), Subtract(n, C2)), Power(Times(Sqr(e), Subtract(n, C1), Subtract(n, C2)), CN1)), x)), Dist(Times(Plus(Times(Sqr(e), Sqr(Subtract(n, C2))), Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol)))), Power(Times(Sqr(e), Subtract(n, C1), Subtract(n, C2)), CN1)), Int(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Csc(Plus(d, Times(e, x))), Subtract(n, C2))), x), x), Negate(Simp(Times(Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Power(Csc(Plus(d, Times(e, x))), Subtract(n, C1)), Cos(Plus(d, Times(e, x))), Power(Times(e, Subtract(n, C1)), CN1)), x))), And(FreeQ(List(FSymbol, a, b, c, d, e), x), NeQ(Plus(Times(Sqr(b), Sqr(c), Sqr(Log(FSymbol))), Times(Sqr(e), Sqr(Subtract(n, C2)))), C0), GtQ(n, C1), NeQ(n, C2))));
            IIntegrate(4450, Int(Times(Power(F_, Times(c_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Sec(Plus(d_DEFAULT, Times(Pi, k_DEFAULT), Times(e_DEFAULT, x_))), n_DEFAULT)), x_Symbol),
                    Condition(Simp(Times(Power(C2, n), Exp(Times(CI, k, n, Pi)), Exp(Times(CI, n, Plus(d, Times(e, x)))), Power(FSymbol, Times(c, Plus(a, Times(b, x)))), Hypergeometric2F1(n, Subtract(Times(C1D2, n), Times(CI, b, c, Log(FSymbol), Power(Times(C2, e), CN1))), Subtract(Plus(C1, Times(C1D2, n)), Times(CI, b, c, Log(FSymbol), Power(Times(C2, e), CN1))), Times(CN1, Exp(Times(C2, CI, k, Pi)), Exp(Times(C2, CI, Plus(d, Times(e, x)))))), Power(Plus(Times(CI, e, n), Times(b, c, Log(FSymbol))), CN1)), x), And(FreeQ(List(FSymbol, a, b, c, d, e), x), IntegerQ(Times(C4, k)), IntegerQ(n))));
        }
    }
}
