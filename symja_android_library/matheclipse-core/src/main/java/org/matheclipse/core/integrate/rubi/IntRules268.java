package org.matheclipse.core.integrate.rubi;


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
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.D;
import static org.matheclipse.core.expression.F.FSymbol;
import static org.matheclipse.core.expression.F.F_;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.Module;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Part;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Simplify;
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
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.r;
import static org.matheclipse.core.expression.F.r_DEFAULT;
import static org.matheclipse.core.expression.F.s;
import static org.matheclipse.core.expression.F.s_DEFAULT;
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
import static org.matheclipse.core.expression.F.y;
import static org.matheclipse.core.expression.F.y_;
import static org.matheclipse.core.expression.F.z;
import static org.matheclipse.core.expression.F.z_;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.BinomialQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.DerivativeDivides;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Divides;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FalseQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalFunctionExpand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalFunctionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SubstFor;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SubstForFractionalPowerOfLinear;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SubstForFractionalPowerOfQuotientOfLinears;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SubstForFractionalPowerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumQ;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules268 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            IIntegrate(6700, Int(Times(u_DEFAULT, Power(v_, m_DEFAULT), Power(Plus(a_DEFAULT, Times(c_DEFAULT, Power(w_, $p("n2", true))), Times(b_DEFAULT, Power(y_, n_))), p_DEFAULT)), x_Symbol),
                    Condition(Module(List(q, r), Condition(Dist(Times(q, r), Subst(Int(Times(Power(x, m), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p)), x), x, y), x), And(Not(FalseQ(Set(r, Divides(Power(y, m), Power(v, m), x)))), Not(FalseQ(Set(q, DerivativeDivides(y, u, x))))))), And(FreeQ(List(a, b, c, m, n, p), x), EqQ($s("n2"), Times(C2, n)), EqQ(w, y))));
            IIntegrate(6701, Int(Times(u_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(v_, n_)), Times(c_DEFAULT, Power(w_, $p("n2", true)))), p_DEFAULT), Plus(A_, Times(B_DEFAULT, Power(y_, n_))), Power(z_, m_DEFAULT)), x_Symbol),
                    Condition(Module(List(q, r), Condition(Dist(Times(q, r), Subst(Int(Times(Power(x, m), Plus(ASymbol, Times(BSymbol, Power(x, n))), Power(Plus(a, Times(b, Power(x, n)), Times(c, Power(x, Times(C2, n)))), p)), x), x, y), x), And(Not(FalseQ(Set(r, Divides(Power(y, m), Power(z, m), x)))), Not(FalseQ(Set(q, DerivativeDivides(y, u, x))))))), And(FreeQ(List(a, b, c, ASymbol, BSymbol, m, n, p), x), EqQ($s("n2"), Times(C2, n)), EqQ(v, y), EqQ(w, y))));
            IIntegrate(6702, Int(Times(u_DEFAULT, Power(Plus(a_DEFAULT, Times(c_DEFAULT, Power(w_, $p("n2", true)))), p_DEFAULT), Plus(A_, Times(B_DEFAULT, Power(y_, n_))), Power(z_, m_DEFAULT)), x_Symbol),
                    Condition(Module(List(q, r), Condition(Dist(Times(q, r), Subst(Int(Times(Power(x, m), Plus(ASymbol, Times(BSymbol, Power(x, n))), Power(Plus(a, Times(c, Power(x, Times(C2, n)))), p)), x), x, y), x), And(Not(FalseQ(Set(r, Divides(Power(y, m), Power(z, m), x)))), Not(FalseQ(Set(q, DerivativeDivides(y, u, x))))))), And(FreeQ(List(a, c, ASymbol, BSymbol, m, n, p), x), EqQ($s("n2"), Times(C2, n)), EqQ(w, y))));
            IIntegrate(6703, Int(Times(u_DEFAULT, Power(Plus(c_DEFAULT, Times(d_DEFAULT, Power(v_, n_))), p_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(y_, n_))), m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(q, DerivativeDivides(y, u, x))), Condition(Dist(q, Subst(Int(Times(Power(Plus(a, Times(b, Power(x, n))), m), Power(Plus(c, Times(d, Power(x, n))), p)), x), x, y), x), Not(FalseQ(q)))), And(FreeQ(List(a, b, c, d, m, n, p), x), EqQ(v, y))));
            IIntegrate(6704, Int(Times(u_DEFAULT, Power(Plus(c_DEFAULT, Times(d_DEFAULT, Power(v_, n_))), p_DEFAULT), Power(Plus(e_DEFAULT, Times(f_DEFAULT, Power(w_, n_))), q_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(y_, n_))), m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(r, DerivativeDivides(y, u, x))), Condition(Dist(r, Subst(Int(Times(Power(Plus(a, Times(b, Power(x, n))), m), Power(Plus(c, Times(d, Power(x, n))), p), Power(Plus(e, Times(f, Power(x, n))), q)), x), x, y), x), Not(FalseQ(r)))), And(FreeQ(List(a, b, c, d, e, f, m, n, p, q), x), EqQ(v, y), EqQ(w, y))));
            IIntegrate(6705, Int(Times(Power(F_, v_), u_), x_Symbol),
                    Condition(With(List(Set(q, DerivativeDivides(v, u, x))), Condition(Simp(Times(q, Power(FSymbol, v), Power(Log(FSymbol), CN1)), x), Not(FalseQ(q)))), FreeQ(FSymbol, x)));
            IIntegrate(6706, Int(Times(Power(F_, v_), u_, Power(w_, m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(q, DerivativeDivides(v, u, x))), Condition(Dist(q, Subst(Int(Times(Power(x, m), Power(FSymbol, x)), x), x, v), x), Not(FalseQ(q)))), And(FreeQ(List(FSymbol, m), x), EqQ(w, v))));
            IIntegrate(6707, Int(Times(u_, Power(Plus(a_, Times(b_DEFAULT, Power(v_, p_DEFAULT), Power(w_, p_DEFAULT))), m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(c, Simplify(Times(u, Power(Plus(Times(w, D(v, x)), Times(v, D(w, x))), CN1))))), Condition(Dist(c, Subst(Int(Power(Plus(a, Times(b, Power(x, p))), m), x), x, Times(v, w)), x), FreeQ(c, x))), And(FreeQ(List(a, b, m, p), x), IntegerQ(p))));
            IIntegrate(6708, Int(Times(u_, Power(v_, r_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(v_, p_DEFAULT), Power(w_, q_DEFAULT))), m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(c, Simplify(Times(u, Power(Plus(Times(p, w, D(v, x)), Times(q, v, D(w, x))), CN1))))), Condition(Dist(Times(c, p, Power(Plus(r, C1), CN1)), Subst(Int(Power(Plus(a, Times(b, Power(x, Times(p, Power(Plus(r, C1), CN1))))), m), x), x, Times(Power(v, Plus(r, C1)), w)), x), FreeQ(c, x))), And(FreeQ(List(a, b, m, p, q, r), x), EqQ(p, Times(q, Plus(r, C1))), NeQ(r, CN1), IntegerQ(Times(p, Power(Plus(r, C1), CN1))))));
            IIntegrate(6709, Int(Times(u_, Power(v_, r_DEFAULT), Power(w_, s_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Power(v_, p_DEFAULT), Power(w_, q_DEFAULT))), m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(c, Simplify(Times(u, Power(Plus(Times(p, w, D(v, x)), Times(q, v, D(w, x))), CN1))))), Condition(Dist(Times(c, p, Power(Plus(r, C1), CN1)), Subst(Int(Power(Plus(a, Times(b, Power(x, Times(p, Power(Plus(r, C1), CN1))))), m), x), x, Times(Power(v, Plus(r, C1)), Power(w, Plus(s, C1)))), x), FreeQ(c, x))), And(FreeQ(List(a, b, m, p, q, r, s), x), EqQ(Times(p, Plus(s, C1)), Times(q, Plus(r, C1))), NeQ(r, CN1), IntegerQ(Times(p, Power(Plus(r, C1), CN1))))));
            IIntegrate(6710, Int(Times(u_, Power(Plus(Times(a_DEFAULT, Power(v_, p_DEFAULT)), Times(b_DEFAULT, Power(w_, q_DEFAULT))), m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(c, Simplify(Times(u, Power(Subtract(Times(p, w, D(v, x)), Times(q, v, D(w, x))), CN1))))), Condition(Dist(Times(c, p), Subst(Int(Power(Plus(b, Times(a, Power(x, p))), m), x), x, Times(v, Power(w, Plus(Times(m, q), C1)))), x), FreeQ(c, x))), And(FreeQ(List(a, b, m, p, q), x), EqQ(Plus(p, Times(q, Plus(Times(m, p), C1))), C0), IntegerQ(p), IntegerQ(m))));
            IIntegrate(6711, Int(Times(u_, Power(v_, r_DEFAULT), Power(Plus(Times(a_DEFAULT, Power(v_, p_DEFAULT)), Times(b_DEFAULT, Power(w_, q_DEFAULT))), m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(c, Simplify(Times(u, Power(Subtract(Times(p, w, D(v, x)), Times(q, v, D(w, x))), CN1))))), Condition(Negate(Dist(Times(c, q), Subst(Int(Power(Plus(a, Times(b, Power(x, q))), m), x), x, Times(Power(v, Plus(Times(m, p), r, C1)), w)), x)), FreeQ(c, x))), And(FreeQ(List(a, b, m, p, q, r), x), EqQ(Plus(p, Times(q, Plus(Times(m, p), r, C1))), C0), IntegerQ(q), IntegerQ(m))));
            IIntegrate(6712, Int(Times(u_, Power(w_, s_DEFAULT), Power(Plus(Times(a_DEFAULT, Power(v_, p_DEFAULT)), Times(b_DEFAULT, Power(w_, q_DEFAULT))), m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(c, Simplify(Times(u, Power(Subtract(Times(p, w, D(v, x)), Times(q, v, D(w, x))), CN1))))), Condition(Negate(Dist(Times(c, q, Power(Plus(s, C1), CN1)), Subst(Int(Power(Plus(a, Times(b, Power(x, Times(q, Power(Plus(s, C1), CN1))))), m), x), x, Times(Power(v, Plus(Times(m, p), C1)), Power(w, Plus(s, C1)))), x)), FreeQ(c, x))), And(FreeQ(List(a, b, m, p, q, s), x), EqQ(Plus(Times(p, Plus(s, C1)), Times(q, Plus(Times(m, p), C1))), C0), NeQ(s, CN1), IntegerQ(Times(q, Power(Plus(s, C1), CN1))), IntegerQ(m))));
            IIntegrate(6713, Int(Times(u_, Power(v_, r_DEFAULT), Power(w_, s_DEFAULT), Power(Plus(Times(a_DEFAULT, Power(v_, p_DEFAULT)), Times(b_DEFAULT, Power(w_, q_DEFAULT))), m_DEFAULT)), x_Symbol),
                    Condition(With(List(Set(c, Simplify(Times(u, Power(Subtract(Times(p, w, D(v, x)), Times(q, v, D(w, x))), CN1))))), Condition(Negate(Dist(Times(c, q, Power(Plus(s, C1), CN1)), Subst(Int(Power(Plus(a, Times(b, Power(x, Times(q, Power(Plus(s, C1), CN1))))), m), x), x, Times(Power(v, Plus(Times(m, p), r, C1)), Power(w, Plus(s, C1)))), x)), FreeQ(c, x))), And(FreeQ(List(a, b, m, p, q, r, s), x), EqQ(Plus(Times(p, Plus(s, C1)), Times(q, Plus(Times(m, p), r, C1))), C0), NeQ(s, CN1), IntegerQ(Times(q, Power(Plus(s, C1), CN1))), IntegerQ(m))));
            IIntegrate(6714, Int(Times(u_, Power(x_, m_DEFAULT)), x_Symbol),
                    Condition(Dist(Power(Plus(m, C1), CN1), Subst(Int(SubstFor(Power(x, Plus(m, C1)), u, x), x), x, Power(x, Plus(m, C1))), x), And(FreeQ(m, x), NeQ(m, CN1), FunctionOfQ(Power(x, Plus(m, C1)), u, x))));
            IIntegrate(6715, Int(u_, x_Symbol),
                    With(List(Set($s("lst"), SubstForFractionalPowerOfLinear(u, x))), Condition(Dist(Times(Part($s("lst"), C2), Part($s("lst"), C4)), Subst(Int(Part($s("lst"), C1), x), x, Power(Part($s("lst"), C3), Power(Part($s("lst"), C2), CN1))), x), And(Not(FalseQ($s("lst"))), SubstForFractionalPowerQ(u, Part($s("lst"), C3), x)))));
            IIntegrate(6716, Int(u_, x_Symbol),
                    With(List(Set($s("lst"), SubstForFractionalPowerOfQuotientOfLinears(u, x))), Condition(Dist(Times(Part($s("lst"), C2), Part($s("lst"), C4)), Subst(Int(Part($s("lst"), C1), x), x, Power(Part($s("lst"), C3), Power(Part($s("lst"), C2), CN1))), x), Not(FalseQ($s("lst"))))));
            IIntegrate(6717, Int(Times(u_DEFAULT, Power(Times(a_DEFAULT, Power(v_, m_DEFAULT), Power(w_, n_DEFAULT), Power(z_, q_DEFAULT)), p_)), x_Symbol),
                    Condition(Dist(Times(Power(a, IntPart(p)), Power(Times(a, Power(v, m), Power(w, n), Power(z, q)), FracPart(p)), Power(Times(Power(v, Times(m, FracPart(p))), Power(w, Times(n, FracPart(p))), Power(z, Times(q, FracPart(p)))), CN1)), Int(Times(u, Power(v, Times(m, p)), Power(w, Times(n, p)), Power(z, Times(p, q))), x), x), And(FreeQ(List(a, m, n, p, q), x), Not(IntegerQ(p)), Not(FreeQ(v, x)), Not(FreeQ(w, x)), Not(FreeQ(z, x)))));
            IIntegrate(6718, Int(Times(u_DEFAULT, Power(Times(a_DEFAULT, Power(v_, m_DEFAULT), Power(w_, n_DEFAULT)), p_)), x_Symbol),
                    Condition(Dist(Times(Power(a, IntPart(p)), Power(Times(a, Power(v, m), Power(w, n)), FracPart(p)), Power(Times(Power(v, Times(m, FracPart(p))), Power(w, Times(n, FracPart(p)))), CN1)), Int(Times(u, Power(v, Times(m, p)), Power(w, Times(n, p))), x), x), And(FreeQ(List(a, m, n, p), x), Not(IntegerQ(p)), Not(FreeQ(v, x)), Not(FreeQ(w, x)))));
            IIntegrate(6719, Int(Times(u_DEFAULT, Power(Times(a_DEFAULT, Power(v_, m_DEFAULT)), p_)), x_Symbol),
                    Condition(Dist(Times(Power(a, IntPart(p)), Power(Times(a, Power(v, m)), FracPart(p)), Power(Power(v, Times(m, FracPart(p))), CN1)), Int(Times(u, Power(v, Times(m, p))), x), x), And(FreeQ(List(a, m, p), x), Not(IntegerQ(p)), Not(FreeQ(v, x)), Not(And(EqQ(a, C1), EqQ(m, C1))), Not(And(EqQ(v, x), EqQ(m, C1))))));
            IIntegrate(6720, Int(Times(u_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(x_, n_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(b, IntPart(p)), Power(Plus(a, Times(b, Power(x, n))), FracPart(p)), Power(Times(Power(x, Times(n, FracPart(p))), Power(Plus(C1, Times(a, Power(Times(Power(x, n), b), CN1))), FracPart(p))), CN1)), Int(Times(u, Power(x, Times(n, p)), Power(Plus(C1, Times(a, Power(Times(Power(x, n), b), CN1))), p)), x), x), And(FreeQ(List(a, b, p), x), Not(IntegerQ(p)), ILtQ(n, C0), Not(RationalFunctionQ(u, x)), IntegerQ(Plus(p, C1D2)))));
            IIntegrate(6721, Int(Times(u_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(v_, n_))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Power(v, n))), FracPart(p)), Power(Times(Power(v, Times(n, FracPart(p))), Power(Plus(b, Times(a, Power(Power(v, n), CN1))), FracPart(p))), CN1)), Int(Times(u, Power(v, Times(n, p)), Power(Plus(b, Times(a, Power(Power(v, n), CN1))), p)), x), x), And(FreeQ(List(a, b, p), x), Not(IntegerQ(p)), ILtQ(n, C0), BinomialQ(v, x), Not(LinearQ(v, x)))));
            IIntegrate(6722, Int(Times(u_DEFAULT, Power(Plus(a_DEFAULT, Times(b_DEFAULT, Power(v_, n_), Power(x_, m_DEFAULT))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Power(x, m), Power(v, n))), FracPart(p)), Power(Times(Power(v, Times(n, FracPart(p))), Power(Plus(Times(b, Power(x, m)), Times(a, Power(Power(v, n), CN1))), FracPart(p))), CN1)), Int(Times(u, Power(v, Times(n, p)), Power(Plus(Times(b, Power(x, m)), Times(a, Power(Power(v, n), CN1))), p)), x), x), And(FreeQ(List(a, b, m, p), x), Not(IntegerQ(p)), ILtQ(n, C0), BinomialQ(v, x))));
            IIntegrate(6723, Int(Times(u_DEFAULT, Power(Plus(Times(a_DEFAULT, Power(x_, r_DEFAULT)), Times(b_DEFAULT, Power(x_, s_DEFAULT))), m_)), x_Symbol),
                    Condition(With(List(Set(v, Times(Power(Plus(Times(a, Power(x, r)), Times(b, Power(x, s))), FracPart(m)), Power(Times(Power(x, Times(r, FracPart(m))), Power(Plus(a, Times(b, Power(x, Subtract(s, r)))), FracPart(m))), CN1)))), Condition(Dist(v, Int(Times(u, Power(x, Times(m, r)), Power(Plus(a, Times(b, Power(x, Subtract(s, r)))), m)), x), x), NeQ(Simplify(v), C1))), And(FreeQ(List(a, b, m, r, s), x), Not(IntegerQ(m)), PosQ(Subtract(s, r)))));
            IIntegrate(6724, Int(Times(u_, Power(Plus(a_, Times(b_DEFAULT, Power(x_, n_))), CN1)), x_Symbol),
                    Condition(With(List(Set(v, RationalFunctionExpand(Times(u, Power(Plus(a, Times(b, Power(x, n))), CN1)), x))), Condition(Int(v, x), SumQ(v))), And(FreeQ(List(a, b), x), IGtQ(n, C0))));
        }
    }
}
