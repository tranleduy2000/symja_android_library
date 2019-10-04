package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CI;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Cancel;
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
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Module;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Part;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.PolynomialQ;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sec;
import static org.matheclipse.core.expression.F.Set;
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
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.u_DEFAULT;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.w;
import static org.matheclipse.core.expression.F.w_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandTrigReduce;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.F;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.G;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IndependentQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.QuotientOfLinearsParts;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.QuotientOfLinearsQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.TrigQ;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules182 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(4551, Int(Times(Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sec(Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), CN1), Power($(F_, Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_DEFAULT), Power($(G_, Plus(c_DEFAULT, Times(d_DEFAULT, x_))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Plus(e, Times(f, x)), m), Cos(Plus(c, Times(d, x))), Power(F(Plus(c, Times(d, x))), n), Power(G(Plus(c, Times(d, x))), p), Power(Plus(b, Times(a, Cos(Plus(c, Times(d, x))))), CN1)), x), And(FreeQ(List(a, b, c, d, e, f), x), TrigQ(FSymbol), TrigQ(GSymbol), IntegersQ(m, n, p))));
            IIntegrate(4552, Int(Times(Power(Plus(Times(Csc(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), CN1), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power($(F_, Plus(c_DEFAULT, Times(d_DEFAULT, x_))), n_DEFAULT), Power($(G_, Plus(c_DEFAULT, Times(d_DEFAULT, x_))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Plus(e, Times(f, x)), m), Sin(Plus(c, Times(d, x))), Power(F(Plus(c, Times(d, x))), n), Power(G(Plus(c, Times(d, x))), p), Power(Plus(b, Times(a, Sin(Plus(c, Times(d, x))))), CN1)), x), And(FreeQ(List(a, b, c, d, e, f), x), TrigQ(FSymbol), TrigQ(GSymbol), IntegersQ(m, n, p))));
            IIntegrate(4553, Int(Times(Power(Sin(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_DEFAULT), Power(Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Power(C2, Plus(p, q)), CN1), Int(ExpandIntegrand(Power(Subtract(Times(CI, Power(Exp(Times(CI, Plus(c, Times(d, x)))), CN1)), Times(CI, Exp(Times(CI, Plus(c, Times(d, x)))))), q), Power(Subtract(Times(CI, Power(Exp(Times(CI, Plus(a, Times(b, x)))), CN1)), Times(CI, Exp(Times(CI, Plus(a, Times(b, x)))))), p), x), x), x), And(FreeQ(List(a, b, c, d, q), x), IGtQ(p, C0), Not(IntegerQ(q)))));
            IIntegrate(4554, Int(Times(Power(Cos(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_DEFAULT), Power(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Power(C2, Plus(p, q)), CN1), Int(ExpandIntegrand(Power(Plus(Exp(Times(CN1, CI, Plus(c, Times(d, x)))), Exp(Times(CI, Plus(c, Times(d, x))))), q), Power(Plus(Exp(Times(CN1, CI, Plus(a, Times(b, x)))), Exp(Times(CI, Plus(a, Times(b, x))))), p), x), x), x), And(FreeQ(List(a, b, c, d, q), x), IGtQ(p, C0), Not(IntegerQ(q)))));
            IIntegrate(4555, Int(Times(Power(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), q_DEFAULT), Power(Sin(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Power(C2, Plus(p, q)), CN1), Int(ExpandIntegrand(Power(Plus(Exp(Times(CN1, CI, Plus(c, Times(d, x)))), Exp(Times(CI, Plus(c, Times(d, x))))), q), Power(Subtract(Times(CI, Power(Exp(Times(CI, Plus(a, Times(b, x)))), CN1)), Times(CI, Exp(Times(CI, Plus(a, Times(b, x)))))), p), x), x), x), And(FreeQ(List(a, b, c, d, q), x), IGtQ(p, C0), Not(IntegerQ(q)))));
            IIntegrate(4556, Int(Times(Power(Cos(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_DEFAULT), Power(Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), q_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Power(C2, Plus(p, q)), CN1), Int(ExpandIntegrand(Power(Subtract(Times(CI, Power(Exp(Times(CI, Plus(c, Times(d, x)))), CN1)), Times(CI, Exp(Times(CI, Plus(c, Times(d, x)))))), q), Power(Plus(Exp(Times(CN1, CI, Plus(a, Times(b, x)))), Exp(Times(CI, Plus(a, Times(b, x))))), p), x), x), x), And(FreeQ(List(a, b, c, d, q), x), IGtQ(p, C0), Not(IntegerQ(q)))));
            IIntegrate(4557, Int(Times(Sin(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Tan(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Int(Plus(Power(Times(Exp(Times(CI, Plus(a, Times(b, x)))), C2), CN1), Times(CN1, C1D2, Exp(Times(CI, Plus(a, Times(b, x))))), Negate(Power(Times(Exp(Times(CI, Plus(a, Times(b, x)))), Plus(C1, Exp(Times(C2, CI, Plus(c, Times(d, x)))))), CN1)), Times(Exp(Times(CI, Plus(a, Times(b, x)))), Power(Plus(C1, Exp(Times(C2, CI, Plus(c, Times(d, x))))), CN1))), x), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Sqr(b), Sqr(d)), C0))));
            IIntegrate(4558, Int(Times(Cos(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Cot(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Int(Subtract(Subtract(Plus(Times(CI, Power(Times(Exp(Times(CI, Plus(a, Times(b, x)))), C2), CN1)), Times(C1D2, CI, Exp(Times(CI, Plus(a, Times(b, x)))))), Times(CI, Power(Times(Exp(Times(CI, Plus(a, Times(b, x)))), Subtract(C1, Exp(Times(C2, CI, Plus(c, Times(d, x)))))), CN1))), Times(CI, Exp(Times(CI, Plus(a, Times(b, x)))), Power(Subtract(C1, Exp(Times(C2, CI, Plus(c, Times(d, x))))), CN1))), x), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Sqr(b), Sqr(d)), C0))));
            IIntegrate(4559, Int(Times(Cot(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Sin(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), x_Symbol),
                    Condition(Int(Subtract(Plus(Negate(Power(Times(Exp(Times(CI, Plus(a, Times(b, x)))), C2), CN1)), Times(C1D2, Exp(Times(CI, Plus(a, Times(b, x))))), Power(Times(Exp(Times(CI, Plus(a, Times(b, x)))), Subtract(C1, Exp(Times(C2, CI, Plus(c, Times(d, x)))))), CN1)), Times(Exp(Times(CI, Plus(a, Times(b, x)))), Power(Subtract(C1, Exp(Times(C2, CI, Plus(c, Times(d, x))))), CN1))), x), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Sqr(b), Sqr(d)), C0))));
            IIntegrate(4560, Int(Times(Cos(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Tan(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Int(Plus(Times(CN1, CI, Power(Times(Exp(Times(CI, Plus(a, Times(b, x)))), C2), CN1)), Times(CN1, C1D2, CI, Exp(Times(CI, Plus(a, Times(b, x))))), Times(CI, Power(Times(Exp(Times(CI, Plus(a, Times(b, x)))), Plus(C1, Exp(Times(C2, CI, Plus(c, Times(d, x)))))), CN1)), Times(CI, Exp(Times(CI, Plus(a, Times(b, x)))), Power(Plus(C1, Exp(Times(C2, CI, Plus(c, Times(d, x))))), CN1))), x), And(FreeQ(List(a, b, c, d), x), NeQ(Subtract(Sqr(b), Sqr(d)), C0))));
            IIntegrate(4561, Int(Power(Sin(Times(a_DEFAULT, Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), CN1))), n_DEFAULT), x_Symbol),
                    Condition(Negate(Dist(Power(d, CN1), Subst(Int(Times(Power(Sin(Times(a, x)), n), Power(x, CN2)), x), x, Power(Plus(c, Times(d, x)), CN1)), x)), And(FreeQ(List(a, c, d), x), IGtQ(n, C0))));
            IIntegrate(4562, Int(Power(Cos(Times(a_DEFAULT, Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), CN1))), n_DEFAULT), x_Symbol),
                    Condition(Negate(Dist(Power(d, CN1), Subst(Int(Times(Power(Cos(Times(a, x)), n), Power(x, CN2)), x), x, Power(Plus(c, Times(d, x)), CN1)), x)), And(FreeQ(List(a, c, d), x), IGtQ(n, C0))));
            IIntegrate(4563, Int(Power(Sin(Times(e_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), CN1))), n_DEFAULT), x_Symbol),
                    Condition(Negate(Dist(Power(d, CN1), Subst(Int(Times(Power(Sin(Subtract(Times(b, e, Power(d, CN1)), Times(e, Subtract(Times(b, c), Times(a, d)), x, Power(d, CN1)))), n), Power(x, CN2)), x), x, Power(Plus(c, Times(d, x)), CN1)), x)), And(FreeQ(List(a, b, c, d), x), IGtQ(n, C0), NeQ(Subtract(Times(b, c), Times(a, d)), C0))));
            IIntegrate(4564, Int(Power(Cos(Times(e_DEFAULT, Plus(a_DEFAULT, Times(b_DEFAULT, x_)), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), CN1))), n_DEFAULT), x_Symbol),
                    Condition(Negate(Dist(Power(d, CN1), Subst(Int(Times(Power(Cos(Subtract(Times(b, e, Power(d, CN1)), Times(e, Subtract(Times(b, c), Times(a, d)), x, Power(d, CN1)))), n), Power(x, CN2)), x), x, Power(Plus(c, Times(d, x)), CN1)), x)), And(FreeQ(List(a, b, c, d), x), IGtQ(n, C0), NeQ(Subtract(Times(b, c), Times(a, d)), C0))));
            IIntegrate(4565, Int(Power(Sin(u_), n_DEFAULT), x_Symbol),
                    Condition(Module(List(Set($s("lst"), QuotientOfLinearsParts(u, x))), Int(Power(Sin(Times(Plus(Part($s("lst"), C1), Times(Part($s("lst"), C2), x)), Power(Plus(Part($s("lst"), C3), Times(Part($s("lst"), C4), x)), CN1))), n), x)), And(IGtQ(n, C0), QuotientOfLinearsQ(u, x))));
            IIntegrate(4566, Int(Power(Cos(u_), n_DEFAULT), x_Symbol),
                    Condition(Module(List(Set($s("lst"), QuotientOfLinearsParts(u, x))), Int(Power(Cos(Times(Plus(Part($s("lst"), C1), Times(Part($s("lst"), C2), x)), Power(Plus(Part($s("lst"), C3), Times(Part($s("lst"), C4), x)), CN1))), n), x)), And(IGtQ(n, C0), QuotientOfLinearsQ(u, x))));
            IIntegrate(4567, Int(Times(u_DEFAULT, Power(Sin(v_), p_DEFAULT), Power(Sin(w_), q_DEFAULT)), x_Symbol),
                    Condition(Int(Times(u, Power(Sin(v), Plus(p, q))), x), EqQ(w, v)));
            IIntegrate(4568, Int(Times(Power(Cos(v_), p_DEFAULT), Power(Cos(w_), q_DEFAULT), u_DEFAULT), x_Symbol),
                    Condition(Int(Times(u, Power(Cos(v), Plus(p, q))), x), EqQ(w, v)));
            IIntegrate(4569, Int(Times(Power(Sin(v_), p_DEFAULT), Power(Sin(w_), q_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrigReduce(Times(Power(Sin(v), p), Power(Sin(w), q)), x), x), And(Or(And(PolynomialQ(v, x), PolynomialQ(w, x)), And(BinomialQ(List(v, w), x), IndependentQ(Cancel(Times(v, Power(w, CN1))), x))), IGtQ(p, C0), IGtQ(q, C0))));
            IIntegrate(4570, Int(Times(Power(Cos(v_), p_DEFAULT), Power(Cos(w_), q_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrigReduce(Times(Power(Cos(v), p), Power(Cos(w), q)), x), x), And(Or(And(PolynomialQ(v, x), PolynomialQ(w, x)), And(BinomialQ(List(v, w), x), IndependentQ(Cancel(Times(v, Power(w, CN1))), x))), IGtQ(p, C0), IGtQ(q, C0))));
            IIntegrate(4571, Int(Times(Power(x_, m_DEFAULT), Power(Sin(v_), p_DEFAULT), Power(Sin(w_), q_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrigReduce(Power(x, m), Times(Power(Sin(v), p), Power(Sin(w), q)), x), x), And(IGtQ(m, C0), IGtQ(p, C0), IGtQ(q, C0), Or(And(PolynomialQ(v, x), PolynomialQ(w, x)), And(BinomialQ(List(v, w), x), IndependentQ(Cancel(Times(v, Power(w, CN1))), x))))));
            IIntegrate(4572, Int(Times(Power(Cos(v_), p_DEFAULT), Power(Cos(w_), q_DEFAULT), Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrigReduce(Power(x, m), Times(Power(Cos(v), p), Power(Cos(w), q)), x), x), And(IGtQ(m, C0), IGtQ(p, C0), IGtQ(q, C0), Or(And(PolynomialQ(v, x), PolynomialQ(w, x)), And(BinomialQ(List(v, w), x), IndependentQ(Cancel(Times(v, Power(w, CN1))), x))))));
            IIntegrate(4573, Int(Times(Power(Cos(w_), p_DEFAULT), u_DEFAULT, Power(Sin(v_), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Power(C2, p), CN1), Int(Times(u, Power(Sin(Times(C2, v)), p)), x), x), And(EqQ(w, v), IntegerQ(p))));
            IIntegrate(4574, Int(Times(Power(Cos(w_), q_DEFAULT), Power(Sin(v_), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrigReduce(Times(Power(Sin(v), p), Power(Cos(w), q)), x), x), And(IGtQ(p, C0), IGtQ(q, C0), Or(And(PolynomialQ(v, x), PolynomialQ(w, x)), And(BinomialQ(List(v, w), x), IndependentQ(Cancel(Times(v, Power(w, CN1))), x))))));
            IIntegrate(4575, Int(Times(Power(Cos(w_), q_DEFAULT), Power(x_, m_DEFAULT), Power(Sin(v_), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrigReduce(Power(x, m), Times(Power(Sin(v), p), Power(Cos(w), q)), x), x), And(IGtQ(m, C0), IGtQ(p, C0), IGtQ(q, C0), Or(And(PolynomialQ(v, x), PolynomialQ(w, x)), And(BinomialQ(List(v, w), x), IndependentQ(Cancel(Times(v, Power(w, CN1))), x))))));
        }
    }
}
