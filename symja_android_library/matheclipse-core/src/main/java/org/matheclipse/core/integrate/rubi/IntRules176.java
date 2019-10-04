package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.Block;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.Coefficient;
import static org.matheclipse.core.expression.F.CompoundExpression;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Cot;
import static org.matheclipse.core.expression.F.Csc;
import static org.matheclipse.core.expression.F.FSymbol;
import static org.matheclipse.core.expression.F.F_;
import static org.matheclipse.core.expression.F.False;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.GSymbol;
import static org.matheclipse.core.expression.F.G_;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Module;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Null;
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
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.w;
import static org.matheclipse.core.expression.F.w_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ActivateTrig;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.CalculusFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.CannotIntegrate;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandTrig;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandTrigReduce;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.F;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FalseQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FreeFactors;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfTrig;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.G;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InertTrigFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntHide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InverseFunctionFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearMatchQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SubstFor;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.TrigQ;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules176 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(4401, Int(u_, x_Symbol),
                    Condition(With(List(Set(v, ExpandTrig(u, x))), Condition(Int(v, x), SumQ(v))), Not(InertTrigFreeQ(u))));
            IIntegrate(4402, Int(u_, x_Symbol),
                    Condition(With(List(Set(w, Block(List(Set($s("§$showsteps"), False), Set($s("§$stepcounter"), Null)), Int(SubstFor(Power(Plus(C1, Times(Sqr(FreeFactors(Tan(Times(C1D2, FunctionOfTrig(u, x))), x)), Sqr(x))), CN1), Times(Tan(Times(C1D2, FunctionOfTrig(u, x))), Power(FreeFactors(Tan(Times(C1D2, FunctionOfTrig(u, x))), x), CN1)), u, x), x)))), Condition(Module(List(Set(v, FunctionOfTrig(u, x)), d), Simp(CompoundExpression(Set(d, FreeFactors(Tan(Times(C1D2, v)), x)), Dist(Times(C2, d, Power(Coefficient(v, x, C1), CN1)), Subst(Int(SubstFor(Power(Plus(C1, Times(Sqr(d), Sqr(x))), CN1), Times(Tan(Times(C1D2, v)), Power(d, CN1)), u, x), x), x, Times(Tan(Times(C1D2, v)), Power(d, CN1))), x)), x)), CalculusFreeQ(w, x))), And(InverseFunctionFreeQ(u, x), Not(FalseQ(FunctionOfTrig(u, x))))));
            IIntegrate(4403, Int(u_, x_Symbol),
                    Condition(With(List(Set(v, ActivateTrig(u))), CannotIntegrate(v, x)), Not(InertTrigFreeQ(u))));
            IIntegrate(4404, Int(Times(Cos(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Power(Sin(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(c, Times(d, x)), m), Power(Sin(Plus(a, Times(b, x))), Plus(n, C1)), Power(Times(b, Plus(n, C1)), CN1)), x), Dist(Times(d, m, Power(Times(b, Plus(n, C1)), CN1)), Int(Times(Power(Plus(c, Times(d, x)), Subtract(m, C1)), Power(Sin(Plus(a, Times(b, x))), Plus(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, n), x), IGtQ(m, C0), NeQ(n, CN1))));
            IIntegrate(4405, Int(Times(Power(Cos(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Sin(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(c, Times(d, x)), m), Power(Cos(Plus(a, Times(b, x))), Plus(n, C1)), Power(Times(b, Plus(n, C1)), CN1)), x)), Dist(Times(d, m, Power(Times(b, Plus(n, C1)), CN1)), Int(Times(Power(Plus(c, Times(d, x)), Subtract(m, C1)), Power(Cos(Plus(a, Times(b, x))), Plus(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, n), x), IGtQ(m, C0), NeQ(n, CN1))));
            IIntegrate(4406, Int(Times(Power(Cos(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Power(Sin(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandTrigReduce(Power(Plus(c, Times(d, x)), m), Times(Power(Sin(Plus(a, Times(b, x))), n), Power(Cos(Plus(a, Times(b, x))), p)), x), x), And(FreeQ(List(a, b, c, d, m), x), IGtQ(n, C0), IGtQ(p, C0))));
            IIntegrate(4407, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Power(Sin(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT), Power(Tan(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_DEFAULT)), x_Symbol),
                    Condition(Plus(Negate(Int(Times(Power(Plus(c, Times(d, x)), m), Power(Sin(Plus(a, Times(b, x))), n), Power(Tan(Plus(a, Times(b, x))), Subtract(p, C2))), x)), Int(Times(Power(Plus(c, Times(d, x)), m), Power(Sin(Plus(a, Times(b, x))), Subtract(n, C2)), Power(Tan(Plus(a, Times(b, x))), p)), x)), And(FreeQ(List(a, b, c, d, m), x), IGtQ(n, C0), IGtQ(p, C0))));
            IIntegrate(4408, Int(Times(Power(Cos(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT), Power(Cot(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Negate(Int(Times(Power(Plus(c, Times(d, x)), m), Power(Cos(Plus(a, Times(b, x))), n), Power(Cot(Plus(a, Times(b, x))), Subtract(p, C2))), x)), Int(Times(Power(Plus(c, Times(d, x)), m), Power(Cos(Plus(a, Times(b, x))), Subtract(n, C2)), Power(Cot(Plus(a, Times(b, x))), p)), x)), And(FreeQ(List(a, b, c, d, m), x), IGtQ(n, C0), IGtQ(p, C0))));
            IIntegrate(4409, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Power(Sec(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT), Power(Tan(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(c, Times(d, x)), m), Power(Sec(Plus(a, Times(b, x))), n), Power(Times(b, n), CN1)), x), Dist(Times(d, m, Power(Times(b, n), CN1)), Int(Times(Power(Plus(c, Times(d, x)), Subtract(m, C1)), Power(Sec(Plus(a, Times(b, x))), n)), x), x)), And(FreeQ(List(a, b, c, d, n), x), EqQ(p, C1), GtQ(m, C0))));
            IIntegrate(4410, Int(Times(Power(Cot(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_DEFAULT), Power(Csc(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(c, Times(d, x)), m), Power(Csc(Plus(a, Times(b, x))), n), Power(Times(b, n), CN1)), x)), Dist(Times(d, m, Power(Times(b, n), CN1)), Int(Times(Power(Plus(c, Times(d, x)), Subtract(m, C1)), Power(Csc(Plus(a, Times(b, x))), n)), x), x)), And(FreeQ(List(a, b, c, d, n), x), EqQ(p, C1), GtQ(m, C0))));
            IIntegrate(4411, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Sqr(Sec(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Tan(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(c, Times(d, x)), m), Power(Tan(Plus(a, Times(b, x))), Plus(n, C1)), Power(Times(b, Plus(n, C1)), CN1)), x), Dist(Times(d, m, Power(Times(b, Plus(n, C1)), CN1)), Int(Times(Power(Plus(c, Times(d, x)), Subtract(m, C1)), Power(Tan(Plus(a, Times(b, x))), Plus(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, n), x), IGtQ(m, C0), NeQ(n, CN1))));
            IIntegrate(4412, Int(Times(Power(Cot(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT), Sqr(Csc(Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(c, Times(d, x)), m), Power(Cot(Plus(a, Times(b, x))), Plus(n, C1)), Power(Times(b, Plus(n, C1)), CN1)), x)), Dist(Times(d, m, Power(Times(b, Plus(n, C1)), CN1)), Int(Times(Power(Plus(c, Times(d, x)), Subtract(m, C1)), Power(Cot(Plus(a, Times(b, x))), Plus(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, n), x), IGtQ(m, C0), NeQ(n, CN1))));
            IIntegrate(4413, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Sec(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Power(Tan(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_)), x_Symbol),
                    Condition(Plus(Negate(Int(Times(Power(Plus(c, Times(d, x)), m), Sec(Plus(a, Times(b, x))), Power(Tan(Plus(a, Times(b, x))), Subtract(p, C2))), x)), Int(Times(Power(Plus(c, Times(d, x)), m), Power(Sec(Plus(a, Times(b, x))), C3), Power(Tan(Plus(a, Times(b, x))), Subtract(p, C2))), x)), And(FreeQ(List(a, b, c, d, m), x), IGtQ(Times(C1D2, p), C0))));
            IIntegrate(4414, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Power(Sec(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT), Power(Tan(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_)), x_Symbol),
                    Condition(Plus(Negate(Int(Times(Power(Plus(c, Times(d, x)), m), Power(Sec(Plus(a, Times(b, x))), n), Power(Tan(Plus(a, Times(b, x))), Subtract(p, C2))), x)), Int(Times(Power(Plus(c, Times(d, x)), m), Power(Sec(Plus(a, Times(b, x))), Plus(n, C2)), Power(Tan(Plus(a, Times(b, x))), Subtract(p, C2))), x)), And(FreeQ(List(a, b, c, d, m, n), x), IGtQ(Times(C1D2, p), C0))));
            IIntegrate(4415, Int(Times(Power(Cot(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_), Csc(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Negate(Int(Times(Power(Plus(c, Times(d, x)), m), Csc(Plus(a, Times(b, x))), Power(Cot(Plus(a, Times(b, x))), Subtract(p, C2))), x)), Int(Times(Power(Plus(c, Times(d, x)), m), Power(Csc(Plus(a, Times(b, x))), C3), Power(Cot(Plus(a, Times(b, x))), Subtract(p, C2))), x)), And(FreeQ(List(a, b, c, d, m), x), IGtQ(Times(C1D2, p), C0))));
            IIntegrate(4416, Int(Times(Power(Cot(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_), Power(Csc(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Negate(Int(Times(Power(Plus(c, Times(d, x)), m), Power(Csc(Plus(a, Times(b, x))), n), Power(Cot(Plus(a, Times(b, x))), Subtract(p, C2))), x)), Int(Times(Power(Plus(c, Times(d, x)), m), Power(Csc(Plus(a, Times(b, x))), Plus(n, C2)), Power(Cot(Plus(a, Times(b, x))), Subtract(p, C2))), x)), And(FreeQ(List(a, b, c, d, m, n), x), IGtQ(Times(C1D2, p), C0))));
            IIntegrate(4417, Int(Times(Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Power(Sec(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT), Power(Tan(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_DEFAULT)), x_Symbol),
                    Condition(Module(List(Set(u, IntHide(Times(Power(Sec(Plus(a, Times(b, x))), n), Power(Tan(Plus(a, Times(b, x))), p)), x))), Subtract(Dist(Power(Plus(c, Times(d, x)), m), u, x), Dist(Times(d, m), Int(Times(Power(Plus(c, Times(d, x)), Subtract(m, C1)), u), x), x))), And(FreeQ(List(a, b, c, d, n, p), x), IGtQ(m, C0), Or(IntegerQ(Times(C1D2, n)), IntegerQ(Times(C1D2, Subtract(p, C1)))))));
            IIntegrate(4418, Int(Times(Power(Cot(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_DEFAULT), Power(Csc(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Module(List(Set(u, IntHide(Times(Power(Csc(Plus(a, Times(b, x))), n), Power(Cot(Plus(a, Times(b, x))), p)), x))), Subtract(Dist(Power(Plus(c, Times(d, x)), m), u, x), Dist(Times(d, m), Int(Times(Power(Plus(c, Times(d, x)), Subtract(m, C1)), u), x), x))), And(FreeQ(List(a, b, c, d, n, p), x), IGtQ(m, C0), Or(IntegerQ(Times(C1D2, n)), IntegerQ(Times(C1D2, Subtract(p, C1)))))));
            IIntegrate(4419, Int(Times(Power(Csc(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Power(Sec(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(C2, n), Int(Times(Power(Plus(c, Times(d, x)), m), Power(Csc(Plus(Times(C2, a), Times(C2, b, x))), n)), x), x), And(FreeQ(List(a, b, c, d, m), x), IntegerQ(n), RationalQ(m))));
            IIntegrate(4420, Int(Times(Power(Csc(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), n_DEFAULT), Power(Plus(c_DEFAULT, Times(d_DEFAULT, x_)), m_DEFAULT), Power(Sec(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), p_DEFAULT)), x_Symbol),
                    Condition(Module(List(Set(u, IntHide(Times(Power(Csc(Plus(a, Times(b, x))), n), Power(Sec(Plus(a, Times(b, x))), p)), x))), Subtract(Dist(Power(Plus(c, Times(d, x)), m), u, x), Dist(Times(d, m), Int(Times(Power(Plus(c, Times(d, x)), Subtract(m, C1)), u), x), x))), And(FreeQ(List(a, b, c, d), x), IntegersQ(n, p), GtQ(m, C0), NeQ(n, p))));
            IIntegrate(4421, Int(Times(Power(u_, m_DEFAULT), Power($(F_, v_), n_DEFAULT), Power($(G_, w_), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(ExpandToSum(u, x), m), Power(F(ExpandToSum(v, x)), n), Power(G(ExpandToSum(v, x)), p)), x), And(FreeQ(List(m, n, p), x), TrigQ(FSymbol), TrigQ(GSymbol), EqQ(v, w), LinearQ(List(u, v, w), x), Not(LinearMatchQ(List(u, v, w), x)))));
            IIntegrate(4422, Int(Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), n_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(e, Times(f, x)), m), Power(Plus(a, Times(b, Sin(Plus(c, Times(d, x))))), Plus(n, C1)), Power(Times(b, d, Plus(n, C1)), CN1)), x), Dist(Times(f, m, Power(Times(b, d, Plus(n, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Subtract(m, C1)), Power(Plus(a, Times(b, Sin(Plus(c, Times(d, x))))), Plus(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f, n), x), IGtQ(m, C0), NeQ(n, CN1))));
            IIntegrate(4423, Int(Times(Power(Plus(Times(Cos(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Sin(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(e, Times(f, x)), m), Power(Plus(a, Times(b, Cos(Plus(c, Times(d, x))))), Plus(n, C1)), Power(Times(b, d, Plus(n, C1)), CN1)), x)), Dist(Times(f, m, Power(Times(b, d, Plus(n, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Subtract(m, C1)), Power(Plus(a, Times(b, Cos(Plus(c, Times(d, x))))), Plus(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f, n), x), IGtQ(m, C0), NeQ(n, CN1))));
            IIntegrate(4424, Int(Times(Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT), Sqr(Sec(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), Power(Plus(a_, Times(b_DEFAULT, Tan(Plus(c_DEFAULT, Times(d_DEFAULT, x_))))), n_DEFAULT)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Plus(e, Times(f, x)), m), Power(Plus(a, Times(b, Tan(Plus(c, Times(d, x))))), Plus(n, C1)), Power(Times(b, d, Plus(n, C1)), CN1)), x), Dist(Times(f, m, Power(Times(b, d, Plus(n, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Subtract(m, C1)), Power(Plus(a, Times(b, Tan(Plus(c, Times(d, x))))), Plus(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f, n), x), IGtQ(m, C0), NeQ(n, CN1))));
            IIntegrate(4425, Int(Times(Sqr(Csc(Plus(c_DEFAULT, Times(d_DEFAULT, x_)))), Power(Plus(Times(Cot(Plus(c_DEFAULT, Times(d_DEFAULT, x_))), b_DEFAULT), a_), n_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, x_)), m_DEFAULT)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Plus(e, Times(f, x)), m), Power(Plus(a, Times(b, Cot(Plus(c, Times(d, x))))), Plus(n, C1)), Power(Times(b, d, Plus(n, C1)), CN1)), x)), Dist(Times(f, m, Power(Times(b, d, Plus(n, C1)), CN1)), Int(Times(Power(Plus(e, Times(f, x)), Subtract(m, C1)), Power(Plus(a, Times(b, Cot(Plus(c, Times(d, x))))), Plus(n, C1))), x), x)), And(FreeQ(List(a, b, c, d, e, f, n), x), IGtQ(m, C0), NeQ(n, CN1))));
        }
    }
}
