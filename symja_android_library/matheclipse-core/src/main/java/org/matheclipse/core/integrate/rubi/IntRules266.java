package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Derivative;
import static org.matheclipse.core.expression.F.Exp;
import static org.matheclipse.core.expression.F.FSymbol;
import static org.matheclipse.core.expression.F.F_;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.Gamma;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.ProductLog;
import static org.matheclipse.core.expression.F.Simplify;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_DEFAULT;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_;
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.g_;
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
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SubstFor;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules266 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(6651, Int(Times(Power(x_, m_DEFAULT), Power(Times(c_DEFAULT, ProductLog(Times(a_DEFAULT, Power(x_, n_DEFAULT)))), p_DEFAULT), Power(Plus(d_, Times(d_DEFAULT, ProductLog(Times(a_DEFAULT, Power(x_, n_DEFAULT))))), CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(c, Power(x, Plus(m, C1)), Power(Times(c, ProductLog(Times(a, Power(x, n)))), Subtract(p, C1)), Power(Times(d, Plus(m, C1)), CN1)), x), Dist(Times(c, Plus(m, Times(n, Subtract(p, C1)), C1), Power(Plus(m, C1), CN1)), Int(Times(Power(x, m), Power(Times(c, ProductLog(Times(a, Power(x, n)))), Subtract(p, C1)), Power(Plus(d, Times(d, ProductLog(Times(a, Power(x, n))))), CN1)), x), x)), And(FreeQ(List(a, c, d, m, n, p), x), NeQ(m, CN1), GtQ(Simplify(Plus(p, Times(Plus(m, C1), Power(n, CN1)))), C1))));
            IIntegrate(6652, Int(Times(Power(x_, m_DEFAULT), Power(Times(c_DEFAULT, ProductLog(Times(a_DEFAULT, Power(x_, n_DEFAULT)))), p_DEFAULT), Power(Plus(d_, Times(d_DEFAULT, ProductLog(Times(a_DEFAULT, Power(x_, n_DEFAULT))))), CN1)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(x, Plus(m, C1)), Power(Times(c, ProductLog(Times(a, Power(x, n)))), p), Power(Times(d, Plus(m, Times(n, p), C1)), CN1)), x), Dist(Times(Plus(m, C1), Power(Times(c, Plus(m, Times(n, p), C1)), CN1)), Int(Times(Power(x, m), Power(Times(c, ProductLog(Times(a, Power(x, n)))), Plus(p, C1)), Power(Plus(d, Times(d, ProductLog(Times(a, Power(x, n))))), CN1)), x), x)), And(FreeQ(List(a, c, d, m, n, p), x), NeQ(m, CN1), LtQ(Simplify(Plus(p, Times(Plus(m, C1), Power(n, CN1)))), C0))));
            IIntegrate(6653, Int(Times(Power(x_, m_DEFAULT), Power(Times(c_DEFAULT, ProductLog(Times(a_DEFAULT, x_))), p_DEFAULT), Power(Plus(d_, Times(d_DEFAULT, ProductLog(Times(a_DEFAULT, x_)))), CN1)), x_Symbol),
                    Condition(Simp(Times(Power(x, m), Gamma(Plus(m, p, C1), Times(CN1, Plus(m, C1), ProductLog(Times(a, x)))), Power(Times(c, ProductLog(Times(a, x))), p), Power(Times(a, d, Plus(m, C1), Exp(Times(m, ProductLog(Times(a, x)))), Power(Times(CN1, Plus(m, C1), ProductLog(Times(a, x))), Plus(m, p))), CN1)), x), And(FreeQ(List(a, c, d, m, p), x), NeQ(m, CN1))));
            IIntegrate(6654, Int(Times(Power(x_, m_DEFAULT), Power(Times(c_DEFAULT, ProductLog(Times(a_DEFAULT, Power(x_, n_DEFAULT)))), p_DEFAULT), Power(Plus(d_, Times(d_DEFAULT, ProductLog(Times(a_DEFAULT, Power(x_, n_DEFAULT))))), CN1)), x_Symbol),
                    Condition(Negate(Subst(Int(Times(Power(Times(c, ProductLog(Times(a, Power(Power(x, n), CN1)))), p), Power(Times(Power(x, Plus(m, C2)), Plus(d, Times(d, ProductLog(Times(a, Power(Power(x, n), CN1)))))), CN1)), x), x, Power(x, CN1))), And(FreeQ(List(a, c, d, p), x), NeQ(m, CN1), IntegerQ(m), LtQ(n, C0))));
            IIntegrate(6655, Int(u_, x_Symbol),
                    Condition(Subst(Int(SimplifyIntegrand(Times(Plus(x, C1), Exp(x), SubstFor(ProductLog(x), u, x)), x), x), x, ProductLog(x)), FunctionOfQ(ProductLog(x), u, x)));
            IIntegrate(6656, Int($($(Derivative(n_), f_), x_), x_Symbol),
                    Condition(Simp($($(Derivative(Subtract(n, C1)), f), x), x), FreeQ(List(f, n), x)));
            IIntegrate(6657, Int(Times(Power(Times(c_DEFAULT, Power(F_, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), p_DEFAULT), $($(Derivative(n_), f_), x_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(c, Power(FSymbol, Plus(a, Times(b, x)))), p), $($(Derivative(Subtract(n, C1)), f), x)), x), Dist(Times(b, p, Log(FSymbol)), Int(Times(Power(Times(c, Power(FSymbol, Plus(a, Times(b, x)))), p), $($(Derivative(Subtract(n, C1)), f), x)), x), x)), And(FreeQ(List(a, b, c, f, FSymbol, p), x), IGtQ(n, C0))));
            IIntegrate(6658, Int(Times(Power(Times(c_DEFAULT, Power(F_, Plus(a_DEFAULT, Times(b_DEFAULT, x_)))), p_DEFAULT), $($(Derivative(n_), f_), x_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Power(Times(c, Power(FSymbol, Plus(a, Times(b, x)))), p), $($(Derivative(n), f), x), Power(Times(b, p, Log(FSymbol)), CN1)), x), Dist(Power(Times(b, p, Log(FSymbol)), CN1), Int(Times(Power(Times(c, Power(FSymbol, Plus(a, Times(b, x)))), p), $($(Derivative(Plus(n, C1)), f), x)), x), x)), And(FreeQ(List(a, b, c, f, FSymbol, p), x), ILtQ(n, C0))));
            IIntegrate(6659, Int(Times(Sin(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), $($(Derivative(n_), f_), x_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Sin(Plus(a, Times(b, x))), $($(Derivative(Subtract(n, C1)), f), x)), x), Dist(b, Int(Times(Cos(Plus(a, Times(b, x))), $($(Derivative(Subtract(n, C1)), f), x)), x), x)), And(FreeQ(List(a, b, f), x), IGtQ(n, C0))));
            IIntegrate(6660, Int(Times(Cos(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), $($(Derivative(n_), f_), x_)), x_Symbol),
                    Condition(Plus(Simp(Times(Cos(Plus(a, Times(b, x))), $($(Derivative(Subtract(n, C1)), f), x)), x), Dist(b, Int(Times(Sin(Plus(a, Times(b, x))), $($(Derivative(Subtract(n, C1)), f), x)), x), x)), And(FreeQ(List(a, b, f), x), IGtQ(n, C0))));
            IIntegrate(6661, Int(Times(Sin(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), $($(Derivative(n_), f_), x_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Cos(Plus(a, Times(b, x))), $($(Derivative(n), f), x), Power(b, CN1)), x)), Dist(Power(b, CN1), Int(Times(Cos(Plus(a, Times(b, x))), $($(Derivative(Plus(n, C1)), f), x)), x), x)), And(FreeQ(List(a, b, f), x), ILtQ(n, C0))));
            IIntegrate(6662, Int(Times(Cos(Plus(a_DEFAULT, Times(b_DEFAULT, x_))), $($(Derivative(n_), f_), x_)), x_Symbol),
                    Condition(Subtract(Simp(Times(Sin(Plus(a, Times(b, x))), $($(Derivative(n), f), x), Power(b, CN1)), x), Dist(Power(b, CN1), Int(Times(Sin(Plus(a, Times(b, x))), $($(Derivative(Plus(n, C1)), f), x)), x), x)), And(FreeQ(List(a, b, f), x), ILtQ(n, C0))));
            IIntegrate(6663, Int(Times(u_, $($(Derivative(n_), f_), x_)), x_Symbol),
                    Condition(Subst(Int(SimplifyIntegrand(SubstFor($($(Derivative(Subtract(n, C1)), f), x), u, x), x), x), x, $($(Derivative(Subtract(n, C1)), f), x)), And(FreeQ(List(f, n), x), FunctionOfQ($($(Derivative(Subtract(n, C1)), f), x), u, x))));
            IIntegrate(6664, Int(Times(u_, Plus(Times(a_DEFAULT, $(g_, x_), $($(Derivative(C1), f_), x_)), Times(a_DEFAULT, $(f_, x_), $($(Derivative(C1), g_), x_)))), x_Symbol),
                    Condition(Dist(a, Subst(Int(SimplifyIntegrand(SubstFor(Times($(f, x), $(g, x)), u, x), x), x), x, Times($(f, x), $(g, x))), x), And(FreeQ(List(a, f, g), x), FunctionOfQ(Times($(f, x), $(g, x)), u, x))));
            IIntegrate(6665, Int(Times(u_, Plus(Times(a_DEFAULT, $(g_, x_), $($(Derivative(m_), f_), x_)), Times(a_DEFAULT, $($(Derivative(C1), g_), x_), $($(Derivative($p("m1")), f_), x_)))), x_Symbol),
                    Condition(Dist(a, Subst(Int(SimplifyIntegrand(SubstFor(Times($($(Derivative(Subtract(m, C1)), f), x), $(g, x)), u, x), x), x), x, Times($($(Derivative(Subtract(m, C1)), f), x), $(g, x))), x), And(FreeQ(List(a, f, g, m), x), EqQ($s("m1"), Subtract(m, C1)), FunctionOfQ(Times($($(Derivative(Subtract(m, C1)), f), x), $(g, x)), u, x))));
            IIntegrate(6666, Int(Times(u_, Plus(Times(a_DEFAULT, $($(Derivative($p("m1")), f_), x_), $($(Derivative(n_), g_), x_)), Times(a_DEFAULT, $($(Derivative(m_), f_), x_), $($(Derivative($p("n1")), g_), x_)))), x_Symbol),
                    Condition(Dist(a, Subst(Int(SimplifyIntegrand(SubstFor(Times($($(Derivative(Subtract(m, C1)), f), x), $($(Derivative(Subtract(n, C1)), g), x)), u, x), x), x), x, Times($($(Derivative(Subtract(m, C1)), f), x), $($(Derivative(Subtract(n, C1)), g), x))), x), And(FreeQ(List(a, f, g, m, n), x), EqQ($s("m1"), Subtract(m, C1)), EqQ($s("n1"), Subtract(n, C1)), FunctionOfQ(Times($($(Derivative(Subtract(m, C1)), f), x), $($(Derivative(Subtract(n, C1)), g), x)), u, x))));
            IIntegrate(6667, Int(Times(u_, Power($(f_, x_), p_DEFAULT), Plus(Times(a_DEFAULT, $(g_, x_), $($(Derivative(C1), f_), x_)), Times(b_DEFAULT, $(f_, x_), $($(Derivative(C1), g_), x_)))), x_Symbol),
                    Condition(Dist(b, Subst(Int(SimplifyIntegrand(SubstFor(Times(Power($(f, x), Plus(p, C1)), $(g, x)), u, x), x), x), x, Times(Power($(f, x), Plus(p, C1)), $(g, x))), x), And(FreeQ(List(a, b, f, g, p), x), EqQ(a, Times(b, Plus(p, C1))), FunctionOfQ(Times(Power($(f, x), Plus(p, C1)), $(g, x)), u, x))));
            IIntegrate(6668, Int(Times(u_, Power($($(Derivative($p("m1")), f_), x_), p_DEFAULT), Plus(Times(a_DEFAULT, $(g_, x_), $($(Derivative(m_), f_), x_)), Times(b_DEFAULT, $($(Derivative(C1), g_), x_), $($(Derivative($p("m1")), f_), x_)))), x_Symbol),
                    Condition(Dist(b, Subst(Int(SimplifyIntegrand(SubstFor(Times(Power($($(Derivative(Subtract(m, C1)), f), x), Plus(p, C1)), $(g, x)), u, x), x), x), x, Times(Power($($(Derivative(Subtract(m, C1)), f), x), Plus(p, C1)), $(g, x))), x), And(FreeQ(List(a, b, f, g, m, p), x), EqQ($s("m1"), Subtract(m, C1)), EqQ(a, Times(b, Plus(p, C1))), FunctionOfQ(Times(Power($($(Derivative(Subtract(m, C1)), f), x), Plus(p, C1)), $(g, x)), u, x))));
            IIntegrate(6669, Int(Times(u_, Power($(g_, x_), q_DEFAULT), Plus(Times(a_DEFAULT, $(g_, x_), $($(Derivative(m_), f_), x_)), Times(b_DEFAULT, $($(Derivative(C1), g_), x_), $($(Derivative($p("m1")), f_), x_)))), x_Symbol),
                    Condition(Dist(a, Subst(Int(SimplifyIntegrand(SubstFor(Times($($(Derivative(Subtract(m, C1)), f), x), Power($(g, x), Plus(q, C1))), u, x), x), x), x, Times($($(Derivative(Subtract(m, C1)), f), x), Power($(g, x), Plus(q, C1)))), x), And(FreeQ(List(a, b, f, g, m, q), x), EqQ($s("m1"), Subtract(m, C1)), EqQ(Times(a, Plus(q, C1)), b), FunctionOfQ(Times($($(Derivative(Subtract(m, C1)), f), x), Power($(g, x), Plus(q, C1))), u, x))));
            IIntegrate(6670, Int(Times(u_, Power($($(Derivative($p("m1")), f_), x_), p_DEFAULT), Plus(Times(b_DEFAULT, $($(Derivative($p("m1")), f_), x_), $($(Derivative(n_), g_), x_)), Times(a_DEFAULT, $($(Derivative(m_), f_), x_), $($(Derivative($p("n1")), g_), x_)))), x_Symbol),
                    Condition(Dist(b, Subst(Int(SimplifyIntegrand(SubstFor(Times(Power($($(Derivative(Subtract(m, C1)), f), x), Plus(p, C1)), $($(Derivative(Subtract(n, C1)), g), x)), u, x), x), x), x, Times(Power($($(Derivative(Subtract(m, C1)), f), x), Plus(p, C1)), $($(Derivative(Subtract(n, C1)), g), x))), x), And(FreeQ(List(a, b, f, g, m, n, p), x), EqQ($s("m1"), Subtract(m, C1)), EqQ($s("n1"), Subtract(n, C1)), EqQ(a, Times(b, Plus(p, C1))), FunctionOfQ(Times(Power($($(Derivative(Subtract(m, C1)), f), x), Plus(p, C1)), $($(Derivative(Subtract(n, C1)), g), x)), u, x))));
            IIntegrate(6671, Int(Times(u_, Power($(f_, x_), p_DEFAULT), Power($(g_, x_), q_DEFAULT), Plus(Times(a_DEFAULT, $(g_, x_), $($(Derivative(C1), f_), x_)), Times(b_DEFAULT, $(f_, x_), $($(Derivative(C1), g_), x_)))), x_Symbol),
                    Condition(Dist(Times(a, Power(Plus(p, C1), CN1)), Subst(Int(SimplifyIntegrand(SubstFor(Times(Power($(f, x), Plus(p, C1)), Power($(g, x), Plus(q, C1))), u, x), x), x), x, Times(Power($(f, x), Plus(p, C1)), Power($(g, x), Plus(q, C1)))), x), And(FreeQ(List(a, b, f, g, p, q), x), EqQ(Times(a, Plus(q, C1)), Times(b, Plus(p, C1))), FunctionOfQ(Times(Power($(f, x), Plus(p, C1)), Power($(g, x), Plus(q, C1))), u, x))));
            IIntegrate(6672, Int(Times(u_, Power($(g_, x_), q_DEFAULT), Power($($(Derivative($p("m1")), f_), x_), p_DEFAULT), Plus(Times(a_DEFAULT, $(g_, x_), $($(Derivative(m_), f_), x_)), Times(b_DEFAULT, $($(Derivative(C1), g_), x_), $($(Derivative($p("m1")), f_), x_)))), x_Symbol),
                    Condition(Dist(Times(a, Power(Plus(p, C1), CN1)), Subst(Int(SimplifyIntegrand(SubstFor(Times(Power($($(Derivative(Subtract(m, C1)), f), x), Plus(p, C1)), Power($(g, x), Plus(q, C1))), u, x), x), x), x, Times(Power($($(Derivative(Subtract(m, C1)), f), x), Plus(p, C1)), Power($(g, x), Plus(q, C1)))), x), And(FreeQ(List(a, b, f, g, m, p, q), x), EqQ($s("m1"), Subtract(m, C1)), EqQ(Times(a, Plus(q, C1)), Times(b, Plus(p, C1))), FunctionOfQ(Times(Power($($(Derivative(Subtract(m, C1)), f), x), Plus(p, C1)), Power($(g, x), Plus(q, C1))), u, x))));
            IIntegrate(6673, Int(Times(u_, Power($($(Derivative($p("m1")), f_), x_), p_DEFAULT), Power($($(Derivative($p("n1")), g_), x_), q_DEFAULT), Plus(Times(b_DEFAULT, $($(Derivative($p("m1")), f_), x_), $($(Derivative(n_), g_), x_)), Times(a_DEFAULT, $($(Derivative(m_), f_), x_), $($(Derivative($p("n1")), g_), x_)))), x_Symbol),
                    Condition(Dist(Times(a, Power(Plus(p, C1), CN1)), Subst(Int(SimplifyIntegrand(SubstFor(Times(Power($($(Derivative(Subtract(m, C1)), f), x), Plus(p, C1)), Power($($(Derivative(Subtract(n, C1)), g), x), Plus(q, C1))), u, x), x), x), x, Times(Power($($(Derivative(Subtract(m, C1)), f), x), Plus(p, C1)), Power($($(Derivative(Subtract(n, C1)), g), x), Plus(q, C1)))), x), And(FreeQ(List(a, b, f, g, m, n, p, q), x), EqQ($s("m1"), Subtract(m, C1)), EqQ($s("n1"), Subtract(n, C1)), EqQ(Times(a, Plus(q, C1)), Times(b, Plus(p, C1))), FunctionOfQ(Times(Power($($(Derivative(Subtract(m, C1)), f), x), Plus(p, C1)), Power($($(Derivative(Subtract(n, C1)), g), x), Plus(q, C1))), u, x))));
            IIntegrate(6674, Int(Times(Power($(g_, x_), CN2), Plus(Times($(g_, x_), $($(Derivative(C1), f_), x_)), Times(CN1, $(f_, x_), $($(Derivative(C1), g_), x_)))), x_Symbol),
                    Condition(Simp(Times($(f, x), Power($(g, x), CN1)), x), FreeQ(List(f, g), x)));
        }
    }
}
