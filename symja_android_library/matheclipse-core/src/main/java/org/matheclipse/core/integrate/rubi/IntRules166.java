package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.ASymbol;
import static org.matheclipse.core.expression.F.A_;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.BSymbol;
import static org.matheclipse.core.expression.F.B_DEFAULT;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Cot;
import static org.matheclipse.core.expression.F.Csc;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Module;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Plus;
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
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.n_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandTrig;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FreeFactors;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules166 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(4151, Int(Times(Power(Times($($s("§csc"), Plus(e_DEFAULT, Times(f_DEFAULT, x_))), d_DEFAULT), m_), Power(Plus(a_, Times(b_DEFAULT, Power(Times(c_DEFAULT, $($s("§sec"), Plus(e_DEFAULT, Times(f_DEFAULT, x_)))), n_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Times(d, Csc(Plus(e, Times(f, x)))), FracPart(m)), Power(Times(Sin(Plus(e, Times(f, x))), Power(d, CN1)), FracPart(m))), Int(Times(Power(Plus(a, Times(b, Power(Times(c, Sec(Plus(e, Times(f, x)))), n))), p), Power(Power(Times(Sin(Plus(e, Times(f, x))), Power(d, CN1)), m), CN1)), x), x), And(FreeQ(List(a, b, c, d, e, f, m, n, p), x), Not(IntegerQ(m)))));
            IIntegrate(4152, Int(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power($($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), Times(c_DEFAULT, Power($($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)))), p_DEFAULT), x_Symbol),
                    Condition(Dist(Power(Times(Power(C4, p), Power(c, p)), CN1), Int(Power(Plus(b, Times(C2, c, Power(Sec(Plus(d, Times(e, x))), n))), Times(C2, p)), x), x), And(FreeQ(List(a, b, c, d, e, n), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(p))));
            IIntegrate(4153, Int(Power(Plus(a_DEFAULT, Times(Power($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), b_DEFAULT), Times(Power($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)), c_DEFAULT)), p_DEFAULT), x_Symbol),
                    Condition(Dist(Power(Times(Power(C4, p), Power(c, p)), CN1), Int(Power(Plus(b, Times(C2, c, Power(Csc(Plus(d, Times(e, x))), n))), Times(C2, p)), x), x), And(FreeQ(List(a, b, c, d, e, n), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(p))));
            IIntegrate(4154, Int(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power($($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), Times(c_DEFAULT, Power($($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)))), p_), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Power(Sec(Plus(d, Times(e, x))), n)), Times(c, Power(Sec(Plus(d, Times(e, x))), Times(C2, n)))), p), Power(Power(Plus(b, Times(C2, c, Power(Sec(Plus(d, Times(e, x))), n))), Times(C2, p)), CN1)), Int(Times(u, Power(Plus(b, Times(C2, c, Power(Sec(Plus(d, Times(e, x))), n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, n, p), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(p)))));
            IIntegrate(4155, Int(Power(Plus(a_DEFAULT, Times(Power($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), b_DEFAULT), Times(Power($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)), c_DEFAULT)), p_), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Power(Csc(Plus(d, Times(e, x))), n)), Times(c, Power(Csc(Plus(d, Times(e, x))), Times(C2, n)))), p), Power(Power(Plus(b, Times(C2, c, Power(Csc(Plus(d, Times(e, x))), n))), Times(C2, p)), CN1)), Int(Times(u, Power(Plus(b, Times(C2, c, Power(Csc(Plus(d, Times(e, x))), n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, n, p), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(p)))));
            IIntegrate(4156, Int(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power($($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), Times(c_DEFAULT, Power($($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)))), CN1), x_Symbol),
                    Condition(Module(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Subtract(Dist(Times(C2, c, Power(q, CN1)), Int(Power(Plus(b, Negate(q), Times(C2, c, Power(Sec(Plus(d, Times(e, x))), n))), CN1), x), x), Dist(Times(C2, c, Power(q, CN1)), Int(Power(Plus(b, q, Times(C2, c, Power(Sec(Plus(d, Times(e, x))), n))), CN1), x), x))), And(FreeQ(List(a, b, c, d, e, n), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(4157, Int(Power(Plus(a_DEFAULT, Times(Power($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), b_DEFAULT), Times(Power($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)), c_DEFAULT)), CN1), x_Symbol),
                    Condition(Module(List(Set(q, Rt(Subtract(Sqr(b), Times(C4, a, c)), C2))), Subtract(Dist(Times(C2, c, Power(q, CN1)), Int(Power(Plus(b, Negate(q), Times(C2, c, Power(Csc(Plus(d, Times(e, x))), n))), CN1), x), x), Dist(Times(C2, c, Power(q, CN1)), Int(Power(Plus(b, q, Times(C2, c, Power(Csc(Plus(d, Times(e, x))), n))), CN1), x), x))), And(FreeQ(List(a, b, c, d, e, n), x), EqQ($s("n2"), Times(C2, n)), NeQ(Subtract(Sqr(b), Times(C4, a, c)), C0))));
            IIntegrate(4158, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power($($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), Times(c_DEFAULT, Power($($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2")))), p_DEFAULT), Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT)), x_Symbol),
                    Condition(Module(List(Set(f, FreeFactors(Cos(Plus(d, Times(e, x))), x))), Negate(Dist(Times(f, Power(e, CN1)), Subst(Int(Times(Power(Subtract(C1, Times(Sqr(f), Sqr(x))), Times(C1D2, Subtract(m, C1))), Power(Plus(b, Times(a, Power(Times(f, x), n))), p), Power(Power(Times(f, x), Times(n, p)), CN1)), x), x, Times(Cos(Plus(d, Times(e, x))), Power(f, CN1))), x))), And(FreeQ(List(a, b, c, d, e), x), EqQ($s("n2"), Times(C2, n)), IntegerQ(Times(C1D2, Subtract(m, C1))), IntegersQ(n, p))));
            IIntegrate(4159, Int(Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_DEFAULT, Times(Power($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), b_DEFAULT), Times(Power($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2")), c_DEFAULT)), p_DEFAULT)), x_Symbol),
                    Condition(Module(List(Set(f, FreeFactors(Sin(Plus(d, Times(e, x))), x))), Dist(Times(f, Power(e, CN1)), Subst(Int(Times(Power(Subtract(C1, Times(Sqr(f), Sqr(x))), Times(C1D2, Subtract(m, C1))), Power(Plus(b, Times(a, Power(Times(f, x), n))), p), Power(Power(Times(f, x), Times(n, p)), CN1)), x), x, Times(Sin(Plus(d, Times(e, x))), Power(f, CN1))), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ($s("n2"), Times(C2, n)), IntegerQ(Times(C1D2, Subtract(m, C1))), IntegersQ(n, p))));
            IIntegrate(4160, Int(Times(Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power($($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_)), Times(c_DEFAULT, Power($($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2")))), p_DEFAULT), Power($($s("§sin"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_)), x_Symbol),
                    Condition(Module(List(Set(f, FreeFactors(Tan(Plus(d, Times(e, x))), x))), Dist(Times(Power(f, Plus(m, C1)), Power(e, CN1)), Subst(Int(Times(Power(x, m), Power(ExpandToSum(Plus(a, Times(b, Power(Plus(C1, Times(Sqr(f), Sqr(x))), Times(C1D2, n))), Times(c, Power(Plus(C1, Times(Sqr(f), Sqr(x))), n))), x), p), Power(Power(Plus(C1, Times(Sqr(f), Sqr(x))), Plus(Times(C1D2, m), C1)), CN1)), x), x, Times(Tan(Plus(d, Times(e, x))), Power(f, CN1))), x)), And(FreeQ(List(a, b, c, d, e, p), x), EqQ($s("n2"), Times(C2, n)), IntegerQ(Times(C1D2, m)), IntegerQ(Times(C1D2, n)))));
            IIntegrate(4161, Int(Times(Power($($s("§cos"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_), Power(Plus(a_DEFAULT, Times(Power($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_), b_DEFAULT), Times(Power($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2")), c_DEFAULT)), p_DEFAULT)), x_Symbol),
                    Condition(Module(List(Set(f, FreeFactors(Cot(Plus(d, Times(e, x))), x))), Negate(Dist(Times(Power(f, Plus(m, C1)), Power(e, CN1)), Subst(Int(Times(Power(x, m), Power(ExpandToSum(Plus(a, Times(b, Power(Plus(C1, Times(Sqr(f), Sqr(x))), Times(C1D2, n))), Times(c, Power(Plus(C1, Times(Sqr(f), Sqr(x))), n))), x), p), Power(Power(Plus(C1, Times(Sqr(f), Sqr(x))), Plus(Times(C1D2, m), C1)), CN1)), x), x, Times(Cot(Plus(d, Times(e, x))), Power(f, CN1))), x))), And(FreeQ(List(a, b, c, d, e, p), x), EqQ($s("n2"), Times(C2, n)), IntegerQ(Times(C1D2, m)), IntegerQ(Times(C1D2, n)))));
            IIntegrate(4162, Int(Times(Power($($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power($($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), Times(c_DEFAULT, Power($($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)))), p_)), x_Symbol),
                    Condition(Dist(Power(Times(Power(C4, p), Power(c, p)), CN1), Int(Times(Power(Sec(Plus(d, Times(e, x))), m), Power(Plus(b, Times(C2, c, Power(Sec(Plus(d, Times(e, x))), n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, m, n), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(p))));
            IIntegrate(4163, Int(Times(Power($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_DEFAULT, Times(Power($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), b_DEFAULT), Times(Power($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)), c_DEFAULT)), p_)), x_Symbol),
                    Condition(Dist(Power(Times(Power(C4, p), Power(c, p)), CN1), Int(Times(Power(Csc(Plus(d, Times(e, x))), m), Power(Plus(b, Times(C2, c, Power(Csc(Plus(d, Times(e, x))), n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, m, n), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(p))));
            IIntegrate(4164, Int(Times(Power($($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power($($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), Times(c_DEFAULT, Power($($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Power(Sec(Plus(d, Times(e, x))), n)), Times(c, Power(Sec(Plus(d, Times(e, x))), Times(C2, n)))), p), Power(Power(Plus(b, Times(C2, c, Power(Sec(Plus(d, Times(e, x))), n))), Times(C2, p)), CN1)), Int(Times(Power(Sec(Plus(d, Times(e, x))), m), Power(Plus(b, Times(C2, c, Power(Sec(Plus(d, Times(e, x))), n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, m, n, p), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(p)))));
            IIntegrate(4165, Int(Times(Power($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_DEFAULT, Times(Power($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), b_DEFAULT), Times(Power($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)), c_DEFAULT)), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Power(Csc(Plus(d, Times(e, x))), n)), Times(c, Power(Csc(Plus(d, Times(e, x))), Times(C2, n)))), p), Power(Power(Plus(b, Times(C2, c, Power(Csc(Plus(d, Times(e, x))), n))), Times(C2, p)), CN1)), Int(Times(Power(Csc(Plus(d, Times(e, x))), m), Power(Plus(b, Times(C2, c, Power(Csc(Plus(d, Times(e, x))), n))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, m, n, p), x), EqQ($s("n2"), Times(C2, n)), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(p)))));
            IIntegrate(4166, Int(Times(Power($($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power($($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), Times(c_DEFAULT, Power($($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)))), p_)), x_Symbol),
                    Condition(Int(ExpandTrig(Times(Power($($s("§sec"), Plus(d, Times(e, x))), m), Power(Plus(a, Times(b, Power($($s("§sec"), Plus(d, Times(e, x))), n)), Times(c, Power($($s("§sec"), Plus(d, Times(e, x))), Times(C2, n)))), p)), x), x), And(FreeQ(List(a, b, c, d, e), x), EqQ($s("n2"), Times(C2, n)), IntegersQ(m, n, p))));
            IIntegrate(4167, Int(Times(Power($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power(Plus(a_DEFAULT, Times(Power($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), b_DEFAULT), Times(Power($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)), c_DEFAULT)), p_)), x_Symbol),
                    Condition(Int(ExpandTrig(Times(Power($($s("§csc"), Plus(d, Times(e, x))), m), Power(Plus(a, Times(b, Power($($s("§csc"), Plus(d, Times(e, x))), n)), Times(c, Power($($s("§csc"), Plus(d, Times(e, x))), Times(C2, n)))), p)), x), x), And(FreeQ(List(a, b, c, d, e), x), EqQ($s("n2"), Times(C2, n)), IntegersQ(m, n, p))));
            IIntegrate(4168, Int(Times(Power(Plus(a_, Times(b_DEFAULT, Power($($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT)), Times(c_DEFAULT, Power($($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)))), p_DEFAULT), Power($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT)), x_Symbol),
                    Condition(Module(List(Set(f, FreeFactors(Cos(Plus(d, Times(e, x))), x))), Negate(Dist(Power(Times(e, Power(f, Subtract(Plus(m, Times(n, p)), C1))), CN1), Subst(Int(Times(Power(Subtract(C1, Times(Sqr(f), Sqr(x))), Times(C1D2, Subtract(m, C1))), Power(Plus(c, Times(b, Power(Times(f, x), n)), Times(c, Power(Times(f, x), Times(C2, n)))), p), Power(Power(x, Plus(m, Times(C2, n, p))), CN1)), x), x, Times(Cos(Plus(d, Times(e, x))), Power(f, CN1))), x))), And(FreeQ(List(a, b, c, d, e, n), x), EqQ($s("n2"), Times(C2, n)), IntegerQ(Times(C1D2, Subtract(m, C1))), IntegerQ(n), IntegerQ(p))));
            IIntegrate(4169, Int(Times(Power($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power(Plus(Times(Power($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_DEFAULT), b_DEFAULT), a_, Times(c_DEFAULT, Power($($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)))), p_DEFAULT)), x_Symbol),
                    Condition(Module(List(Set(f, FreeFactors(Sin(Plus(d, Times(e, x))), x))), Dist(Power(Times(e, Power(f, Subtract(Plus(m, Times(n, p)), C1))), CN1), Subst(Int(Times(Power(Subtract(C1, Times(Sqr(f), Sqr(x))), Times(C1D2, Subtract(m, C1))), Power(Plus(c, Times(b, Power(Times(f, x), n)), Times(c, Power(Times(f, x), Times(C2, n)))), p), Power(Power(x, Plus(m, Times(C2, n, p))), CN1)), x), x, Times(Sin(Plus(d, Times(e, x))), Power(f, CN1))), x)), And(FreeQ(List(a, b, c, d, e, n), x), EqQ($s("n2"), Times(C2, n)), IntegerQ(Times(C1D2, Subtract(m, C1))), IntegerQ(n), IntegerQ(p))));
            IIntegrate(4170, Int(Times(Power(Plus(a_, Times(c_DEFAULT, Power($($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true))), Times(b_DEFAULT, Power($($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_))), p_DEFAULT), Power($($s("§tan"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT)), x_Symbol),
                    Condition(Module(List(Set(f, FreeFactors(Tan(Plus(d, Times(e, x))), x))), Dist(Times(Power(f, Plus(m, C1)), Power(e, CN1)), Subst(Int(Times(Power(x, m), Power(ExpandToSum(Plus(a, Times(b, Power(Plus(C1, Times(Sqr(f), Sqr(x))), Times(C1D2, n))), Times(c, Power(Plus(C1, Times(Sqr(f), Sqr(x))), n))), x), p), Power(Plus(C1, Times(Sqr(f), Sqr(x))), CN1)), x), x, Times(Tan(Plus(d, Times(e, x))), Power(f, CN1))), x)), And(FreeQ(List(a, b, c, d, e), x), EqQ($s("n2"), Times(C2, n)), IntegerQ(Times(C1D2, m)), IntegerQ(Times(C1D2, n)))));
            IIntegrate(4171, Int(Times(Power($($s("§cot"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), m_DEFAULT), Power(Plus(Times(Power($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), n_), b_DEFAULT), a_, Times(c_DEFAULT, Power($($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), $p("n2", true)))), p_DEFAULT)), x_Symbol),
                    Condition(Module(List(Set(f, FreeFactors(Cot(Plus(d, Times(e, x))), x))), Negate(Dist(Times(Power(f, Plus(m, C1)), Power(e, CN1)), Subst(Int(Times(Power(x, m), Power(ExpandToSum(Plus(a, Times(b, Power(Plus(C1, Times(Sqr(f), Sqr(x))), Times(C1D2, n))), Times(c, Power(Plus(C1, Times(Sqr(f), Sqr(x))), n))), x), p), Power(Plus(C1, Times(Sqr(f), Sqr(x))), CN1)), x), x, Times(Cot(Plus(d, Times(e, x))), Power(f, CN1))), x))), And(FreeQ(List(a, b, c, d, e), x), EqQ($s("n2"), Times(C2, n)), IntegerQ(Times(C1D2, m)), IntegerQ(Times(C1D2, n)))));
            IIntegrate(4172, Int(Times(Plus(A_, Times(B_DEFAULT, $($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), Power(Plus(a_, Times(b_DEFAULT, $($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), Times(c_DEFAULT, Sqr($($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))))), n_)), x_Symbol),
                    Condition(Dist(Power(Times(Power(C4, n), Power(c, n)), CN1), Int(Times(Plus(ASymbol, Times(BSymbol, Sec(Plus(d, Times(e, x))))), Power(Plus(b, Times(C2, c, Sec(Plus(d, Times(e, x))))), Times(C2, n))), x), x), And(FreeQ(List(a, b, c, d, e, ASymbol, BSymbol), x), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(n))));
            IIntegrate(4173, Int(Times(Power(Plus(Times($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), b_DEFAULT), Times(Sqr($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), c_DEFAULT), a_), n_), Plus(Times($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), B_DEFAULT), A_)), x_Symbol),
                    Condition(Dist(Power(Times(Power(C4, n), Power(c, n)), CN1), Int(Times(Plus(ASymbol, Times(BSymbol, Csc(Plus(d, Times(e, x))))), Power(Plus(b, Times(C2, c, Csc(Plus(d, Times(e, x))))), Times(C2, n))), x), x), And(FreeQ(List(a, b, c, d, e, ASymbol, BSymbol), x), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), IntegerQ(n))));
            IIntegrate(4174, Int(Times(Plus(A_, Times(B_DEFAULT, $($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))))), Power(Plus(a_, Times(b_DEFAULT, $($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), Times(c_DEFAULT, Sqr($($s("§sec"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))))), n_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Sec(Plus(d, Times(e, x)))), Times(c, Sqr(Sec(Plus(d, Times(e, x)))))), n), Power(Power(Plus(b, Times(C2, c, Sec(Plus(d, Times(e, x))))), Times(C2, n)), CN1)), Int(Times(Plus(ASymbol, Times(BSymbol, Sec(Plus(d, Times(e, x))))), Power(Plus(b, Times(C2, c, Sec(Plus(d, Times(e, x))))), Times(C2, n))), x), x), And(FreeQ(List(a, b, c, d, e, ASymbol, BSymbol), x), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(n)))));
            IIntegrate(4175, Int(Times(Power(Plus(Times($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), b_DEFAULT), Times(Sqr($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_)))), c_DEFAULT), a_), n_), Plus(Times($($s("§csc"), Plus(d_DEFAULT, Times(e_DEFAULT, x_))), B_DEFAULT), A_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Csc(Plus(d, Times(e, x)))), Times(c, Sqr(Csc(Plus(d, Times(e, x)))))), n), Power(Power(Plus(b, Times(C2, c, Csc(Plus(d, Times(e, x))))), Times(C2, n)), CN1)), Int(Times(Plus(ASymbol, Times(BSymbol, Csc(Plus(d, Times(e, x))))), Power(Plus(b, Times(C2, c, Csc(Plus(d, Times(e, x))))), Times(C2, n))), x), x), And(FreeQ(List(a, b, c, d, e, ASymbol, BSymbol), x), EqQ(Subtract(Sqr(b), Times(C4, a, c)), C0), Not(IntegerQ(n)))));
        }
    }
}
