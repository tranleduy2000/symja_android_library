package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcSin;
import static org.matheclipse.core.expression.F.ArcTan;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C1D4;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.C5;
import static org.matheclipse.core.expression.F.C7;
import static org.matheclipse.core.expression.F.C8;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Coefficient;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.EllipticE;
import static org.matheclipse.core.expression.F.EllipticF;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.QQ;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.ZZ;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.a_DEFAULT;
import static org.matheclipse.core.expression.F.b;
import static org.matheclipse.core.expression.F.b_DEFAULT;
import static org.matheclipse.core.expression.F.c;
import static org.matheclipse.core.expression.F.c_DEFAULT;
import static org.matheclipse.core.expression.F.d;
import static org.matheclipse.core.expression.F.d_;
import static org.matheclipse.core.expression.F.d_DEFAULT;
import static org.matheclipse.core.expression.F.e;
import static org.matheclipse.core.expression.F.e_DEFAULT;
import static org.matheclipse.core.expression.F.k;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_DEFAULT;
import static org.matheclipse.core.expression.F.r;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Coeff;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FracPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearPairQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NegQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PolyQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PolynomialDivide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplerSqrtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;

/**
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class IntRules22 {
    public static IAST RULES = List(
            IIntegrate(1101, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), CN1D2), x_Symbol),
                    Condition(With(List(Set(q, Rt(Plus(Sqr(b), Times(CN1, C4, a, c)), C2))), Condition(Simp(Times(Sqrt(Plus(C1, Times(Plus(b, q), Sqr(x), Power(Times(C2, a), -1)))), Sqrt(Plus(C1, Times(Plus(b, Negate(q)), Sqr(x), Power(Times(C2, a), -1)))), EllipticF(ArcSin(Times(Rt(Times(CN1, Plus(b, q), Power(Times(C2, a), -1)), C2), x)), Times(Plus(b, Negate(q)), Power(Plus(b, q), -1))), Power(Times(Rt(Times(CN1, Plus(b, q), Power(Times(C2, a), -1)), C2), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))))), -1)), x), And(NegQ(Times(Plus(b, q), Power(a, -1))), Not(And(NegQ(Times(Plus(b, Negate(q)), Power(a, -1))), SimplerSqrtQ(Times(CN1, Plus(b, Negate(q)), Power(Times(C2, a), -1)), Times(CN1, Plus(b, q), Power(Times(C2, a), -1)))))))), And(FreeQ(List(a, b, c), x), GtQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0)))),
            IIntegrate(1102, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), CN1D2), x_Symbol),
                    Condition(With(List(Set(q, Rt(Plus(Sqr(b), Times(CN1, C4, a, c)), C2))), Condition(Simp(Times(Sqrt(Plus(C1, Times(Plus(b, Negate(q)), Sqr(x), Power(Times(C2, a), -1)))), Sqrt(Plus(C1, Times(Plus(b, q), Sqr(x), Power(Times(C2, a), -1)))), EllipticF(ArcSin(Times(Rt(Times(CN1, Plus(b, Negate(q)), Power(Times(C2, a), -1)), C2), x)), Times(Plus(b, q), Power(Plus(b, Negate(q)), -1))), Power(Times(Rt(Times(CN1, Plus(b, Negate(q)), Power(Times(C2, a), -1)), C2), Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))))), -1)), x), NegQ(Times(Plus(b, Negate(q)), Power(a, -1))))), And(FreeQ(List(a, b, c), x), GtQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0)))),
            IIntegrate(1103, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), CN1D2), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(c, Power(a, -1)), C4))), Simp(Times(Plus(C1, Times(Sqr(q), Sqr(x))), Sqrt(Times(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), Power(Times(a, Sqr(Plus(C1, Times(Sqr(q), Sqr(x))))), -1))), EllipticF(Times(C2, ArcTan(Times(q, x))), Plus(C1D2, Times(CN1, b, Sqr(q), Power(Times(C4, c), -1)))), Power(Times(C2, q, Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))))), -1)), x)), And(FreeQ(List(a, b, c), x), NeQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), PosQ(Times(c, Power(a, -1)))))),
            IIntegrate(1104, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), CN1D2), x_Symbol),
                    Condition(With(List(Set(q, Rt(Plus(Sqr(b), Times(CN1, C4, a, c)), C2))), Dist(Times(Sqrt(Plus(C1, Times(C2, c, Sqr(x), Power(Plus(b, Negate(q)), -1)))), Sqrt(Plus(C1, Times(C2, c, Sqr(x), Power(Plus(b, q), -1)))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), CN1D2)), Int(Power(Times(Sqrt(Plus(C1, Times(C2, c, Sqr(x), Power(Plus(b, Negate(q)), -1)))), Sqrt(Plus(C1, Times(C2, c, Sqr(x), Power(Plus(b, q), -1))))), -1), x), x)), And(FreeQ(List(a, b, c), x), NeQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), NegQ(Times(c, Power(a, -1)))))),
            IIntegrate(1105, Int(Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), p_), x_Symbol),
                    Condition(With(List(Set(q, Rt(Plus(Sqr(b), Times(CN1, C4, a, c)), C2))), Dist(Times(Power(a, IntPart(p)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), FracPart(p)), Power(Times(Power(Plus(C1, Times(C2, c, Sqr(x), Power(Plus(b, q), -1))), FracPart(p)), Power(Plus(C1, Times(C2, c, Sqr(x), Power(Plus(b, Negate(q)), -1))), FracPart(p))), -1)), Int(Times(Power(Plus(C1, Times(C2, c, Sqr(x), Power(Plus(b, q), -1))), p), Power(Plus(C1, Times(C2, c, Sqr(x), Power(Plus(b, Negate(q)), -1))), p)), x), x)), And(FreeQ(List(a, b, c, p), x), NeQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0)))),
            IIntegrate(1106, Int(Power($p("§p4"), p_), x_Symbol),
                    Condition(With(List(Set(a, Coeff($s("§p4"), x, C0)), Set(b, Coeff($s("§p4"), x, C1)), Set(c, Coeff($s("§p4"), x, C2)), Set(d, Coeff($s("§p4"), x, C3)), Set(e, Coeff($s("§p4"), x, C4))), Condition(Subst(Int(SimplifyIntegrand(Power(Plus(a, Times(Power(d, 4), Power(Times(ZZ(256L), Power(e, 3)), -1)), Times(CN1, b, d, Power(Times(C8, e), -1)), Times(Plus(c, Times(CN1, C3, Sqr(d), Power(Times(C8, e), -1))), Sqr(x)), Times(e, Power(x, 4))), p), x), x), x, Plus(Times(d, Power(Times(C4, e), -1)), x)), And(EqQ(Plus(Power(d, 3), Times(CN1, C4, c, d, e), Times(C8, b, Sqr(e))), C0), NeQ(d, C0)))), And(FreeQ(p, x), PolyQ($s("§p4"), x, C4), NeQ(p, C2), NeQ(p, C3)))),
            IIntegrate(1107, Int(Times(x_, Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(C1D2, Subst(Int(Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p), x), x, Sqr(x)), x), FreeQ(List(a, b, c, p), x))),
            IIntegrate(1108, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), p_DEFAULT)), x_Symbol),
                    Condition(Int(ExpandIntegrand(Times(Power(Times(d, x), m), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), p)), x), x), And(FreeQ(List(a, b, c, d, m), x), IGtQ(p, C0), Not(IntegerQ(Times(C1D2, Plus(m, C1))))))),
            IIntegrate(1109, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(C2, Power(Times(d, x), Plus(m, C1)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), Plus(p, C1)), Power(Times(d, Plus(m, C3), Plus(Times(C2, a), Times(b, Sqr(x)))), -1)), x), Negate(Simp(Times(Power(Times(d, x), Plus(m, C1)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), Plus(p, C1)), Power(Times(C2, a, d, Plus(m, C3), Plus(p, C1)), -1)), x))), And(FreeQ(List(a, b, c, d, m, p), x), EqQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), Not(IntegerQ(p)), EqQ(Plus(m, Times(C4, p), C5), C0), LtQ(p, CN1)))),
            IIntegrate(1110, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(d, x), Plus(m, C1)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), Plus(p, C1)), Power(Times(C4, a, d, Plus(p, C1), Plus(Times(C2, p), C1)), -1)), x), Negate(Simp(Times(Power(Times(d, x), Plus(m, C1)), Plus(Times(C2, a), Times(b, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), p), Power(Times(C4, a, d, Plus(Times(C2, p), C1)), -1)), x))), And(FreeQ(List(a, b, c, d, m, p), x), EqQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), Not(IntegerQ(p)), EqQ(Plus(m, Times(C4, p), C5), C0), NeQ(p, Negate(Power(C2, -1)))))),
            IIntegrate(1111, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), p_)), x_Symbol),
                    Condition(Dist(C1D2, Subst(Int(Times(Power(x, Times(C1D2, Plus(m, Negate(C1)))), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), x, Sqr(x)), x), And(FreeQ(List(a, b, c, p), x), EqQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), IntegerQ(Plus(p, Negate(C1D2))), IntegerQ(Times(C1D2, Plus(m, Negate(C1)))), Or(GtQ(m, C0), LtQ(C0, Times(C4, p), Plus(Negate(m), Negate(C1))))))),
            IIntegrate(1112, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), FracPart(p)), Power(Times(Power(c, IntPart(p)), Power(Plus(Times(C1D2, b), Times(c, Sqr(x))), Times(C2, FracPart(p)))), -1)), Int(Times(Power(Times(d, x), m), Power(Plus(Times(C1D2, b), Times(c, Sqr(x))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, m, p), x), EqQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), IntegerQ(Plus(p, Negate(C1D2)))))),
            IIntegrate(1113, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(a, IntPart(p)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), FracPart(p)), Power(Power(Plus(C1, Times(C2, c, Sqr(x), Power(b, -1))), Times(C2, FracPart(p))), -1)), Int(Times(Power(Times(d, x), m), Power(Plus(C1, Times(C2, c, Sqr(x), Power(b, -1))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, m, p), x), EqQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), Not(IntegerQ(Times(C2, p)))))),
            IIntegrate(1114, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(C1D2, Subst(Int(Times(Power(x, Times(C1D2, Plus(m, Negate(C1)))), Power(Plus(a, Times(b, x), Times(c, Sqr(x))), p)), x), x, Sqr(x)), x), And(FreeQ(List(a, b, c, p), x), IntegerQ(Times(C1D2, Plus(m, Negate(C1))))))),
            IIntegrate(1115, Int(Times(Power(Times(d_DEFAULT, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), p_)), x_Symbol),
                    Condition(With(List(Set(k, Denominator(m))), Dist(Times(k, Power(d, -1)), Subst(Int(Times(Power(x, Plus(Times(k, Plus(m, C1)), Negate(C1))), Power(Plus(a, Times(b, Power(x, Times(C2, k)), Power(d, -2)), Times(c, Power(x, Times(C4, k)), Power(d, -4))), p)), x), x, Power(Times(d, x), Power(k, -1))), x)), And(FreeQ(List(a, b, c, d, p), x), NeQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), FractionQ(m), IntegerQ(p)))),
            IIntegrate(1116, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(d, Power(Times(d, x), Plus(m, Negate(C1))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), p), Plus(Times(C2, b, p), Times(c, Plus(m, Times(C4, p), Negate(C1)), Sqr(x))), Power(Times(c, Plus(m, Times(C4, p), C1), Plus(m, Times(C4, p), Negate(C1))), -1)), x), Negate(Dist(Times(C2, p, Sqr(d), Power(Times(c, Plus(m, Times(C4, p), C1), Plus(m, Times(C4, p), Negate(C1))), -1)), Int(Times(Power(Times(d, x), Plus(m, Negate(C2))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), Plus(p, Negate(C1))), Simp(Plus(Times(a, b, Plus(m, Negate(C1))), Times(CN1, Plus(Times(C2, a, c, Plus(m, Times(C4, p), Negate(C1))), Times(CN1, Sqr(b), Plus(m, Times(C2, p), Negate(C1)))), Sqr(x))), x)), x), x))), And(FreeQ(List(a, b, c, d), x), NeQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), GtQ(p, C0), GtQ(m, C1), IntegerQ(Times(C2, p)), Or(IntegerQ(p), IntegerQ(m))))),
            IIntegrate(1117, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(d, x), Plus(m, C1)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), p), Power(Times(d, Plus(m, C1)), -1)), x), Negate(Dist(Times(C2, p, Power(Times(Sqr(d), Plus(m, C1)), -1)), Int(Times(Power(Times(d, x), Plus(m, C2)), Plus(b, Times(C2, c, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), Plus(p, Negate(C1)))), x), x))), And(FreeQ(List(a, b, c, d), x), NeQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), GtQ(p, C0), LtQ(m, CN1), IntegerQ(Times(C2, p)), Or(IntegerQ(p), IntegerQ(m))))),
            IIntegrate(1118, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(d, x), Plus(m, C1)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), p), Power(Times(d, Plus(m, Times(C4, p), C1)), -1)), x), Dist(Times(C2, p, Power(Plus(m, Times(C4, p), C1), -1)), Int(Times(Power(Times(d, x), m), Plus(Times(C2, a), Times(b, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), Plus(p, Negate(C1)))), x), x)), And(FreeQ(List(a, b, c, d, m), x), NeQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), GtQ(p, C0), NeQ(Plus(m, Times(C4, p), C1), C0), IntegerQ(Times(C2, p)), Or(IntegerQ(p), IntegerQ(m))))),
            IIntegrate(1119, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(d, Power(Times(d, x), Plus(m, Negate(C1))), Plus(b, Times(C2, c, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), Plus(p, C1)), Power(Times(C2, Plus(p, C1), Plus(Sqr(b), Times(CN1, C4, a, c))), -1)), x), Negate(Dist(Times(Sqr(d), Power(Times(C2, Plus(p, C1), Plus(Sqr(b), Times(CN1, C4, a, c))), -1)), Int(Times(Power(Times(d, x), Plus(m, Negate(C2))), Plus(Times(b, Plus(m, Negate(C1))), Times(C2, c, Plus(m, Times(C4, p), C5), Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), Plus(p, C1))), x), x))), And(FreeQ(List(a, b, c, d), x), NeQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), LtQ(p, CN1), GtQ(m, C1), LeQ(m, C3), IntegerQ(Times(C2, p)), Or(IntegerQ(p), IntegerQ(m))))),
            IIntegrate(1120, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(d, 3), Power(Times(d, x), Plus(m, Negate(C3))), Plus(Times(C2, a), Times(b, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), Plus(p, C1)), Power(Times(C2, Plus(p, C1), Plus(Sqr(b), Times(CN1, C4, a, c))), -1)), x)), Dist(Times(Power(d, 4), Power(Times(C2, Plus(p, C1), Plus(Sqr(b), Times(CN1, C4, a, c))), -1)), Int(Times(Power(Times(d, x), Plus(m, Negate(C4))), Plus(Times(C2, a, Plus(m, Negate(C3))), Times(b, Plus(m, Times(C4, p), C3), Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), Plus(p, C1))), x), x)), And(FreeQ(List(a, b, c, d), x), NeQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), LtQ(p, CN1), GtQ(m, C3), IntegerQ(Times(C2, p)), Or(IntegerQ(p), IntegerQ(m))))),
            IIntegrate(1121, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), p_)), x_Symbol),
                    Condition(Plus(Negate(Simp(Times(Power(Times(d, x), Plus(m, C1)), Plus(Sqr(b), Times(CN1, C2, a, c), Times(b, c, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), Plus(p, C1)), Power(Times(C2, a, d, Plus(p, C1), Plus(Sqr(b), Times(CN1, C4, a, c))), -1)), x)), Dist(Power(Times(C2, a, Plus(p, C1), Plus(Sqr(b), Times(CN1, C4, a, c))), -1), Int(Times(Power(Times(d, x), m), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), Plus(p, C1)), Simp(Plus(Times(Sqr(b), Plus(m, Times(C2, p), C3)), Times(CN1, C2, a, c, Plus(m, Times(C4, p), C5)), Times(b, c, Plus(m, Times(C4, p), C7), Sqr(x))), x)), x), x)), And(FreeQ(List(a, b, c, d, m), x), NeQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), LtQ(p, CN1), IntegerQ(Times(C2, p)), Or(IntegerQ(p), IntegerQ(m))))),
            IIntegrate(1122, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(d, 3), Power(Times(d, x), Plus(m, Negate(C3))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), Plus(p, C1)), Power(Times(c, Plus(m, Times(C4, p), C1)), -1)), x), Negate(Dist(Times(Power(d, 4), Power(Times(c, Plus(m, Times(C4, p), C1)), -1)), Int(Times(Power(Times(d, x), Plus(m, Negate(C4))), Simp(Plus(Times(a, Plus(m, Negate(C3))), Times(b, Plus(m, Times(C2, p), Negate(C1)), Sqr(x))), x), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), p)), x), x))), And(FreeQ(List(a, b, c, d, p), x), NeQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), GtQ(m, C3), NeQ(Plus(m, Times(C4, p), C1), C0), IntegerQ(Times(C2, p)), Or(IntegerQ(p), IntegerQ(m))))),
            IIntegrate(1123, Int(Times(Power(Times(d_DEFAULT, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(d, x), Plus(m, C1)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), Plus(p, C1)), Power(Times(a, d, Plus(m, C1)), -1)), x), Negate(Dist(Power(Times(a, Sqr(d), Plus(m, C1)), -1), Int(Times(Power(Times(d, x), Plus(m, C2)), Plus(Times(b, Plus(m, Times(C2, p), C3)), Times(c, Plus(m, Times(C4, p), C5), Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), p)), x), x))), And(FreeQ(List(a, b, c, d, p), x), NeQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), LtQ(m, CN1), IntegerQ(Times(C2, p)), Or(IntegerQ(p), IntegerQ(m))))),
            IIntegrate(1124, Int(Times(Power(Times(d_DEFAULT, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), -1)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(Times(d, x), Plus(m, C1)), Power(Times(a, d, Plus(m, C1)), -1)), x), Negate(Dist(Power(Times(a, Sqr(d)), -1), Int(Times(Power(Times(d, x), Plus(m, C2)), Plus(b, Times(c, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), -1)), x), x))), And(FreeQ(List(a, b, c, d), x), NeQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), LtQ(m, CN1)))),
            IIntegrate(1125, Int(Times(Power(x_, m_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), -1)), x_Symbol),
                    Condition(Int(PolynomialDivide(Power(x, m), Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), x), x), And(FreeQ(List(a, b, c), x), NeQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), IGtQ(m, C5)))),
            IIntegrate(1126, Int(Times(Power(Times(d_DEFAULT, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), -1)), x_Symbol),
                    Condition(Plus(Simp(Times(Power(d, 3), Power(Times(d, x), Plus(m, Negate(C3))), Power(Times(c, Plus(m, Negate(C3))), -1)), x), Negate(Dist(Times(Power(d, 4), Power(c, -1)), Int(Times(Power(Times(d, x), Plus(m, Negate(C4))), Plus(a, Times(b, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), -1)), x), x))), And(FreeQ(List(a, b, c, d), x), NeQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), GtQ(m, C3)))),
            IIntegrate(1127, Int(Times(Sqr(x_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), -1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(a, Power(c, -1)), C2))), Plus(Dist(C1D2, Int(Times(Plus(q, Sqr(x)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), -1)), x), x), Negate(Dist(C1D2, Int(Times(Plus(q, Negate(Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), -1)), x), x)))), And(FreeQ(List(a, b, c), x), LtQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), PosQ(Times(a, c))))),
            IIntegrate(1128, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), -1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(a, Power(c, -1)), C2))), With(List(Set(r, Rt(Plus(Times(C2, q), Times(CN1, b, Power(c, -1))), C2))), Plus(Negate(Dist(Power(Times(C2, c, r), -1), Int(Times(Power(x, Plus(m, Negate(C3))), Plus(q, Times(CN1, r, x)), Power(Plus(q, Times(CN1, r, x), Sqr(x)), -1)), x), x)), Dist(Power(Times(C2, c, r), -1), Int(Times(Power(x, Plus(m, Negate(C3))), Plus(q, Times(r, x)), Power(Plus(q, Times(r, x), Sqr(x)), -1)), x), x)))), And(FreeQ(List(a, b, c), x), NeQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), GeQ(m, C3), LtQ(m, C4), NegQ(Plus(Sqr(b), Times(CN1, C4, a, c)))))),
            IIntegrate(1129, Int(Times(Power(x_, m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), -1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(a, Power(c, -1)), C2))), With(List(Set(r, Rt(Plus(Times(C2, q), Times(CN1, b, Power(c, -1))), C2))), Plus(Dist(Power(Times(C2, c, r), -1), Int(Times(Power(x, Plus(m, Negate(C1))), Power(Plus(q, Times(CN1, r, x), Sqr(x)), -1)), x), x), Negate(Dist(Power(Times(C2, c, r), -1), Int(Times(Power(x, Plus(m, Negate(C1))), Power(Plus(q, Times(r, x), Sqr(x)), -1)), x), x))))), And(FreeQ(List(a, b, c), x), NeQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), GeQ(m, C1), LtQ(m, C3), NegQ(Plus(Sqr(b), Times(CN1, C4, a, c)))))),
            IIntegrate(1130, Int(Times(Power(Times(d_DEFAULT, x_), m_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), -1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Plus(Sqr(b), Times(CN1, C4, a, c)), C2))), Plus(Dist(Times(C1D2, Sqr(d), Plus(Times(b, Power(q, -1)), C1)), Int(Times(Power(Times(d, x), Plus(m, Negate(C2))), Power(Plus(Times(C1D2, b), Times(C1D2, q), Times(c, Sqr(x))), -1)), x), x), Negate(Dist(Times(C1D2, Sqr(d), Plus(Times(b, Power(q, -1)), Negate(C1))), Int(Times(Power(Times(d, x), Plus(m, Negate(C2))), Power(Plus(Times(C1D2, b), Times(CN1, C1D2, q), Times(c, Sqr(x))), -1)), x), x)))), And(FreeQ(List(a, b, c, d), x), NeQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), GeQ(m, C2)))),
            IIntegrate(1131, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), -1)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Plus(Sqr(b), Times(CN1, C4, a, c)), C2))), Plus(Dist(Times(c, Power(q, -1)), Int(Times(Power(Times(d, x), m), Power(Plus(Times(C1D2, b), Times(CN1, C1D2, q), Times(c, Sqr(x))), -1)), x), x), Negate(Dist(Times(c, Power(q, -1)), Int(Times(Power(Times(d, x), m), Power(Plus(Times(C1D2, b), Times(C1D2, q), Times(c, Sqr(x))), -1)), x), x)))), And(FreeQ(List(a, b, c, d, m), x), NeQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0)))),
            IIntegrate(1132, Int(Times(Sqr(x_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Plus(Sqr(b), Times(CN1, C4, a, c)), C2))), Dist(Times(C2, Sqrt(Negate(c))), Int(Times(Sqr(x), Power(Times(Sqrt(Plus(b, q, Times(C2, c, Sqr(x)))), Sqrt(Plus(Negate(b), q, Times(CN1, C2, c, Sqr(x))))), -1)), x), x)), And(FreeQ(List(a, b, c), x), GtQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), LtQ(c, C0)))),
            IIntegrate(1133, Int(Times(Sqr(x_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(c, Power(a, -1)), C2))), Plus(Dist(Power(q, -1), Int(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), CN1D2), x), x), Negate(Dist(Power(q, -1), Int(Times(Plus(C1, Times(CN1, q, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), CN1D2)), x), x)))), And(FreeQ(List(a, b, c), x), GtQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), GtQ(Times(c, Power(a, -1)), C0), LtQ(Times(b, Power(a, -1)), C0)))),
            IIntegrate(1134, Int(Times(Sqr(x_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Plus(Sqr(b), Times(CN1, C4, a, c)), C2))), Plus(Negate(Dist(Times(Plus(b, Negate(q)), Power(Times(C2, c), -1)), Int(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), CN1D2), x), x)), Dist(Power(Times(C2, c), -1), Int(Times(Plus(b, Negate(q), Times(C2, c, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), CN1D2)), x), x))), And(FreeQ(List(a, b, c), x), GtQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), LtQ(a, C0), GtQ(c, C0)))),
            IIntegrate(1135, Int(Times(Sqr(x_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Plus(Sqr(b), Times(CN1, C4, a, c)), C2))), Condition(Plus(Simp(Times(x, Plus(b, q, Times(C2, c, Sqr(x))), Power(Times(C2, c, Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))))), -1)), x), Negate(Simp(Times(Rt(Times(Plus(b, q), Power(Times(C2, a), -1)), C2), Plus(Times(C2, a), Times(Plus(b, q), Sqr(x))), Sqrt(Times(Plus(Times(C2, a), Times(Plus(b, Negate(q)), Sqr(x))), Power(Plus(Times(C2, a), Times(Plus(b, q), Sqr(x))), -1))), EllipticE(ArcTan(Times(Rt(Times(Plus(b, q), Power(Times(C2, a), -1)), C2), x)), Times(C2, q, Power(Plus(b, q), -1))), Power(Times(C2, c, Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))))), -1)), x))), And(PosQ(Times(Plus(b, q), Power(a, -1))), Not(And(PosQ(Times(Plus(b, Negate(q)), Power(a, -1))), SimplerSqrtQ(Times(Plus(b, Negate(q)), Power(Times(C2, a), -1)), Times(Plus(b, q), Power(Times(C2, a), -1)))))))), And(FreeQ(List(a, b, c), x), GtQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0)))),
            IIntegrate(1136, Int(Times(Sqr(x_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Plus(Sqr(b), Times(CN1, C4, a, c)), C2))), Condition(Plus(Simp(Times(x, Plus(b, Negate(q), Times(C2, c, Sqr(x))), Power(Times(C2, c, Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))))), -1)), x), Negate(Simp(Times(Rt(Times(Plus(b, Negate(q)), Power(Times(C2, a), -1)), C2), Plus(Times(C2, a), Times(Plus(b, Negate(q)), Sqr(x))), Sqrt(Times(Plus(Times(C2, a), Times(Plus(b, q), Sqr(x))), Power(Plus(Times(C2, a), Times(Plus(b, Negate(q)), Sqr(x))), -1))), EllipticE(ArcTan(Times(Rt(Times(Plus(b, Negate(q)), Power(Times(C2, a), -1)), C2), x)), Times(CN2, q, Power(Plus(b, Negate(q)), -1))), Power(Times(C2, c, Sqrt(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))))), -1)), x))), PosQ(Times(Plus(b, Negate(q)), Power(a, -1))))), And(FreeQ(List(a, b, c), x), GtQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0)))),
            IIntegrate(1137, Int(Times(Sqr(x_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Plus(Sqr(b), Times(CN1, C4, a, c)), C2))), Condition(Plus(Negate(Dist(Times(Plus(b, q), Power(Times(C2, c), -1)), Int(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), CN1D2), x), x)), Dist(Power(Times(C2, c), -1), Int(Times(Plus(b, q, Times(C2, c, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), CN1D2)), x), x)), And(NegQ(Times(Plus(b, q), Power(a, -1))), Not(And(NegQ(Times(Plus(b, Negate(q)), Power(a, -1))), SimplerSqrtQ(Times(CN1, Plus(b, Negate(q)), Power(Times(C2, a), -1)), Times(CN1, Plus(b, q), Power(Times(C2, a), -1)))))))), And(FreeQ(List(a, b, c), x), GtQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0)))),
            IIntegrate(1138, Int(Times(Sqr(x_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Plus(Sqr(b), Times(CN1, C4, a, c)), C2))), Condition(Plus(Negate(Dist(Times(Plus(b, Negate(q)), Power(Times(C2, c), -1)), Int(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), CN1D2), x), x)), Dist(Power(Times(C2, c), -1), Int(Times(Plus(b, Negate(q), Times(C2, c, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), CN1D2)), x), x)), NegQ(Times(Plus(b, Negate(q)), Power(a, -1))))), And(FreeQ(List(a, b, c), x), GtQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0)))),
            IIntegrate(1139, Int(Times(Sqr(x_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Times(c, Power(a, -1)), C2))), Plus(Dist(Power(q, -1), Int(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), CN1D2), x), x), Negate(Dist(Power(q, -1), Int(Times(Plus(C1, Times(CN1, q, Sqr(x))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), CN1D2)), x), x)))), And(FreeQ(List(a, b, c), x), NeQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), PosQ(Times(c, Power(a, -1)))))),
            IIntegrate(1140, Int(Times(Sqr(x_), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), CN1D2)), x_Symbol),
                    Condition(With(List(Set(q, Rt(Plus(Sqr(b), Times(CN1, C4, a, c)), C2))), Dist(Times(Sqrt(Plus(C1, Times(C2, c, Sqr(x), Power(Plus(b, Negate(q)), -1)))), Sqrt(Plus(C1, Times(C2, c, Sqr(x), Power(Plus(b, q), -1)))), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), CN1D2)), Int(Times(Sqr(x), Power(Times(Sqrt(Plus(C1, Times(C2, c, Sqr(x), Power(Plus(b, Negate(q)), -1)))), Sqrt(Plus(C1, Times(C2, c, Sqr(x), Power(Plus(b, q), -1))))), -1)), x), x)), And(FreeQ(List(a, b, c), x), NeQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), NegQ(Times(c, Power(a, -1)))))),
            IIntegrate(1141, Int(Times(Power(Times(d_DEFAULT, x_), m_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(a, IntPart(p)), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), FracPart(p)), Power(Times(Power(Plus(C1, Times(C2, c, Sqr(x), Power(Plus(b, Rt(Plus(Sqr(b), Times(CN1, C4, a, c)), C2)), -1))), FracPart(p)), Power(Plus(C1, Times(C2, c, Sqr(x), Power(Plus(b, Negate(Rt(Plus(Sqr(b), Times(CN1, C4, a, c)), C2))), -1))), FracPart(p))), -1)), Int(Times(Power(Times(d, x), m), Power(Plus(C1, Times(C2, c, Sqr(x), Power(Plus(b, Sqrt(Plus(Sqr(b), Times(CN1, C4, a, c)))), -1))), p), Power(Plus(C1, Times(C2, c, Sqr(x), Power(Plus(b, Negate(Sqrt(Plus(Sqr(b), Times(CN1, C4, a, c))))), -1))), p)), x), x), FreeQ(List(a, b, c, d, m, p), x))),
            IIntegrate(1142, Int(Times(Power(u_, m_DEFAULT), Power(Plus(a_DEFAULT, Times(b_DEFAULT, Sqr(v_)), Times(c_DEFAULT, Power(v_, 4))), p_DEFAULT)), x_Symbol),
                    Condition(Dist(Times(Power(u, m), Power(Times(Coefficient(v, x, C1), Power(v, m)), -1)), Subst(Int(Times(Power(x, m), Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, Times(C2, C2)))), p)), x), x, v), x), And(FreeQ(List(a, b, c, m, p), x), LinearPairQ(u, v, x)))),
            IIntegrate(1143, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), QQ(-3L, 4L))), x_Symbol),
                    Condition(Plus(Simp(Times(CN2, Plus(Times(c, d), Times(CN1, b, e)), Power(Plus(Times(b, Sqr(x)), Times(c, Power(x, 4))), C1D4), Power(Times(b, c, x), -1)), x), Dist(Times(e, Power(c, -1)), Int(Times(Power(Plus(Times(b, Sqr(x)), Times(c, Power(x, 4))), C1D4), Power(x, -2)), x), x)), FreeQ(List(b, c, d, e), x))),
            IIntegrate(1144, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), p_)), x_Symbol),
                    Condition(Simp(Times(e, Power(Plus(Times(b, Sqr(x)), Times(c, Power(x, 4))), Plus(p, C1)), Power(Times(c, Plus(Times(C4, p), C3), x), -1)), x), And(FreeQ(List(b, c, d, e, p), x), Not(IntegerQ(p)), NeQ(Plus(Times(C4, p), C3), C0), EqQ(Plus(Times(b, e, Plus(Times(C2, p), C1)), Times(CN1, c, d, Plus(Times(C4, p), C3))), C0)))),
            IIntegrate(1145, Int(Times(Plus(d_, Times(e_DEFAULT, Sqr(x_))), Power(Plus(Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), p_)), x_Symbol),
                    Condition(Plus(Simp(Times(e, Power(Plus(Times(b, Sqr(x)), Times(c, Power(x, 4))), Plus(p, C1)), Power(Times(c, Plus(Times(C4, p), C3), x), -1)), x), Negate(Dist(Times(Plus(Times(b, e, Plus(Times(C2, p), C1)), Times(CN1, c, d, Plus(Times(C4, p), C3))), Power(Times(c, Plus(Times(C4, p), C3)), -1)), Int(Power(Plus(Times(b, Sqr(x)), Times(c, Power(x, 4))), p), x), x))), And(FreeQ(List(b, c, d, e, p), x), Not(IntegerQ(p)), NeQ(Plus(Times(C4, p), C3), C0), NeQ(Plus(Times(b, e, Plus(Times(C2, p), C1)), Times(CN1, c, d, Plus(Times(C4, p), C3))), C0)))),
            IIntegrate(1146, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(Times(b, Sqr(x)), Times(c, Power(x, 4))), FracPart(p)), Power(Times(Power(x, Times(C2, FracPart(p))), Power(Plus(b, Times(c, Sqr(x))), FracPart(p))), -1)), Int(Times(Power(x, Times(C2, p)), Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(b, Times(c, Sqr(x))), p)), x), x), And(FreeQ(List(b, c, d, e, p, q), x), Not(IntegerQ(p))))),
            IIntegrate(1147, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), p), Power(Power(Plus(d, Times(e, Sqr(x))), Times(C2, p)), -1)), Int(Power(Plus(d, Times(e, Sqr(x))), Plus(q, Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, p, q), x), EqQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), Not(IntegerQ(p)), EqQ(Plus(Times(C2, c, d), Times(CN1, b, e)), C0)))),
            IIntegrate(1148, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), p_)), x_Symbol),
                    Condition(Dist(Times(Power(Plus(a, Times(b, Sqr(x)), Times(c, Power(x, 4))), FracPart(p)), Power(Times(Power(c, IntPart(p)), Power(Plus(Times(C1D2, b), Times(c, Sqr(x))), Times(C2, FracPart(p)))), -1)), Int(Times(Power(Plus(d, Times(e, Sqr(x))), q), Power(Plus(Times(C1D2, b), Times(c, Sqr(x))), Times(C2, p))), x), x), And(FreeQ(List(a, b, c, d, e, p, q), x), EqQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), Not(IntegerQ(p))))),
            IIntegrate(1149, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(b_DEFAULT, Sqr(x_)), Times(c_DEFAULT, Power(x_, 4))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Plus(d, Times(e, Sqr(x))), Plus(p, q)), Power(Plus(Times(a, Power(d, -1)), Times(c, Sqr(x), Power(e, -1))), p)), x), And(FreeQ(List(a, b, c, d, e, q), x), NeQ(Plus(Sqr(b), Times(CN1, C4, a, c)), C0), EqQ(Plus(Times(c, Sqr(d)), Times(CN1, b, d, e), Times(a, Sqr(e))), C0), IntegerQ(p)))),
            IIntegrate(1150, Int(Times(Power(Plus(d_, Times(e_DEFAULT, Sqr(x_))), q_DEFAULT), Power(Plus(a_, Times(c_DEFAULT, Power(x_, 4))), p_DEFAULT)), x_Symbol),
                    Condition(Int(Times(Power(Plus(d, Times(e, Sqr(x))), Plus(p, q)), Power(Plus(Times(a, Power(d, -1)), Times(c, Sqr(x), Power(e, -1))), p)), x), And(FreeQ(List(a, c, d, e, q), x), EqQ(Plus(Times(c, Sqr(d)), Times(a, Sqr(e))), C0), IntegerQ(p))))
    );
}
