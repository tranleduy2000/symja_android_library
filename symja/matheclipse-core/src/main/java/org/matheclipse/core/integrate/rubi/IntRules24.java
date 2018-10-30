package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcSin;
import static org.matheclipse.core.expression.F.ArcTan;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.C5;
import static org.matheclipse.core.expression.F.C7;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.EllipticE;
import static org.matheclipse.core.expression.F.EllipticF;
import static org.matheclipse.core.expression.F.EllipticPi;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.IIntegrate;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Module;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.PolynomialQuotient;
import static org.matheclipse.core.expression.F.PolynomialRemainder;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.ReplaceAll;
import static org.matheclipse.core.expression.F.Rule;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
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
import static org.matheclipse.core.expression.F.f;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_DEFAULT;
import static org.matheclipse.core.expression.F.p;
import static org.matheclipse.core.expression.F.p_;
import static org.matheclipse.core.expression.F.p_DEFAULT;
import static org.matheclipse.core.expression.F.q;
import static org.matheclipse.core.expression.F.q_;
import static org.matheclipse.core.expression.F.q_DEFAULT;
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
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntPart;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NegQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PosQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Rt;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Unintegrable;

/** 
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class IntRules24 { 
  public static IAST RULES = List( 
IIntegrate(1201,Int(Times(Plus(d_,Times(e_DEFAULT,Sqr(x_))),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(CN1,c,Power(a,-1)),C2))),Plus(Dist(Times(Plus(Times(d,q),Negate(e)),Power(q,-1)),Int(Power(Plus(a,Times(c,Power(x,4))),CN1D2),x),x),Dist(Times(e,Power(q,-1)),Int(Times(Plus(C1,Times(q,Sqr(x))),Power(Plus(a,Times(c,Power(x,4))),CN1D2)),x),x))),And(FreeQ(List(a,c,d,e),x),NegQ(Times(c,Power(a,-1))),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0)))),
IIntegrate(1202,Int(Times(Plus(d_,Times(e_DEFAULT,Sqr(x_))),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(q,Rt(Plus(Sqr(b),Times(CN1,C4,a,c)),C2))),Dist(Times(Sqrt(Plus(C1,Times(C2,c,Sqr(x),Power(Plus(b,Negate(q)),-1)))),Sqrt(Plus(C1,Times(C2,c,Sqr(x),Power(Plus(b,q),-1)))),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),CN1D2)),Int(Times(Plus(d,Times(e,Sqr(x))),Power(Times(Sqrt(Plus(C1,Times(C2,c,Sqr(x),Power(Plus(b,Negate(q)),-1)))),Sqrt(Plus(C1,Times(C2,c,Sqr(x),Power(Plus(b,q),-1))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NegQ(Times(c,Power(a,-1)))))),
IIntegrate(1203,Int(Times(Plus(d_,Times(e_DEFAULT,Sqr(x_))),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times(Plus(d,Times(e,Sqr(x))),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),p)),x),x),And(FreeQ(List(a,b,c,d,e),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0)))),
IIntegrate(1204,Int(Times(Plus(d_,Times(e_DEFAULT,Sqr(x_))),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),p_)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times(Plus(d,Times(e,Sqr(x))),Power(Plus(a,Times(c,Power(x,4))),p)),x),x),And(FreeQ(List(a,c,d,e),x),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0)))),
IIntegrate(1205,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_)),x_Symbol),
    Condition(With(List(Set(f,Coeff(PolynomialRemainder(Power(Plus(d,Times(e,Sqr(x))),q),Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),x),x,C0)),Set(g,Coeff(PolynomialRemainder(Power(Plus(d,Times(e,Sqr(x))),q),Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),x),x,C2))),Plus(Simp(Times(x,Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),Plus(p,C1)),Plus(Times(a,b,g),Times(CN1,f,Plus(Sqr(b),Times(CN1,C2,a,c))),Times(CN1,c,Plus(Times(b,f),Times(CN1,C2,a,g)),Sqr(x))),Power(Times(C2,a,Plus(p,C1),Plus(Sqr(b),Times(CN1,C4,a,c))),-1)),x),Dist(Power(Times(C2,a,Plus(p,C1),Plus(Sqr(b),Times(CN1,C4,a,c))),-1),Int(Times(Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),Plus(p,C1)),ExpandToSum(Plus(Times(C2,a,Plus(p,C1),Plus(Sqr(b),Times(CN1,C4,a,c)),PolynomialQuotient(Power(Plus(d,Times(e,Sqr(x))),q),Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),x)),Times(Sqr(b),f,Plus(Times(C2,p),C3)),Times(CN1,C2,a,c,f,Plus(Times(C4,p),C5)),Times(CN1,a,b,g),Times(c,Plus(Times(C4,p),C7),Plus(Times(b,f),Times(CN1,C2,a,g)),Sqr(x))),x)),x),x))),And(FreeQ(List(a,b,c,d,e),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),IGtQ(q,C1),LtQ(p,CN1)))),
IIntegrate(1206,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(e,q),Power(x,Plus(Times(C2,q),Negate(C3))),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),Plus(p,C1)),Power(Times(c,Plus(Times(C4,p),Times(C2,q),C1)),-1)),x),Dist(Power(Times(c,Plus(Times(C4,p),Times(C2,q),C1)),-1),Int(Times(Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),p),ExpandToSum(Plus(Times(c,Plus(Times(C4,p),Times(C2,q),C1),Power(Plus(d,Times(e,Sqr(x))),q)),Times(CN1,a,Plus(Times(C2,q),Negate(C3)),Power(e,q),Power(x,Plus(Times(C2,q),Negate(C4)))),Times(CN1,b,Plus(Times(C2,p),Times(C2,q),Negate(C1)),Power(e,q),Power(x,Plus(Times(C2,q),Negate(C2)))),Times(CN1,c,Plus(Times(C4,p),Times(C2,q),C1),Power(e,q),Power(x,Times(C2,q)))),x)),x),x)),And(FreeQ(List(a,b,c,d,e,p),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),IGtQ(q,C1)))),
IIntegrate(1207,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(e,q),Power(x,Plus(Times(C2,q),Negate(C3))),Power(Plus(a,Times(c,Power(x,4))),Plus(p,C1)),Power(Times(c,Plus(Times(C4,p),Times(C2,q),C1)),-1)),x),Dist(Power(Times(c,Plus(Times(C4,p),Times(C2,q),C1)),-1),Int(Times(Power(Plus(a,Times(c,Power(x,4))),p),ExpandToSum(Plus(Times(c,Plus(Times(C4,p),Times(C2,q),C1),Power(Plus(d,Times(e,Sqr(x))),q)),Times(CN1,a,Plus(Times(C2,q),Negate(C3)),Power(e,q),Power(x,Plus(Times(C2,q),Negate(C4)))),Times(CN1,c,Plus(Times(C4,p),Times(C2,q),C1),Power(e,q),Power(x,Times(C2,q)))),x)),x),x)),And(FreeQ(List(a,c,d,e,p),x),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),IGtQ(q,C1)))),
IIntegrate(1208,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_)),x_Symbol),
    Condition(Plus(Negate(Dist(Power(e,-2),Int(Times(Plus(Times(c,d),Times(CN1,b,e),Times(CN1,c,e,Sqr(x))),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),Plus(p,Negate(C1)))),x),x)),Dist(Times(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),Power(e,-2)),Int(Times(Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),Plus(p,Negate(C1))),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),IGtQ(Plus(p,C1D2),C0)))),
IIntegrate(1209,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),p_)),x_Symbol),
    Condition(Plus(Negate(Dist(Power(e,-2),Int(Times(Plus(Times(c,d),Times(CN1,c,e,Sqr(x))),Power(Plus(a,Times(c,Power(x,4))),Plus(p,Negate(C1)))),x),x)),Dist(Times(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),Power(e,-2)),Int(Times(Power(Plus(a,Times(c,Power(x,4))),Plus(p,Negate(C1))),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x)),And(FreeQ(List(a,c,d,e),x),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),IGtQ(Plus(p,C1D2),C0)))),
IIntegrate(1210,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(Plus(Dist(Power(Times(C2,d),-1),Int(Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),CN1D2),x),x),Dist(Power(Times(C2,d),-1),Int(Times(Plus(d,Times(CN1,e,Sqr(x))),Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),EqQ(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),C0)))),
IIntegrate(1211,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(Plus(Dist(Power(Times(C2,d),-1),Int(Power(Plus(a,Times(c,Power(x,4))),CN1D2),x),x),Dist(Power(Times(C2,d),-1),Int(Times(Plus(d,Times(CN1,e,Sqr(x))),Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(a,Times(c,Power(x,4))))),-1)),x),x)),And(FreeQ(List(a,c,d,e),x),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),EqQ(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),C0)))),
IIntegrate(1212,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(q,Rt(Plus(Sqr(b),Times(CN1,C4,a,c)),C2))),Dist(Times(C2,Sqrt(Negate(c))),Int(Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(b,q,Times(C2,c,Sqr(x)))),Sqrt(Plus(Negate(b),q,Times(CN1,C2,c,Sqr(x))))),-1),x),x)),And(FreeQ(List(a,b,c,d,e),x),GtQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),LtQ(c,C0)))),
IIntegrate(1213,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(CN1,a,c),C2))),Dist(Sqrt(Negate(c)),Int(Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(q,Times(c,Sqr(x)))),Sqrt(Plus(q,Times(CN1,c,Sqr(x))))),-1),x),x)),And(FreeQ(List(a,c,d,e),x),GtQ(a,C0),LtQ(c,C0)))),
IIntegrate(1214,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(q,Rt(Plus(Sqr(b),Times(CN1,C4,a,c)),C2))),Plus(Dist(Times(C2,c,Power(Plus(Times(C2,c,d),Times(CN1,e,Plus(b,Negate(q)))),-1)),Int(Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),CN1D2),x),x),Negate(Dist(Times(e,Power(Plus(Times(C2,c,d),Times(CN1,e,Plus(b,Negate(q)))),-1)),Int(Times(Plus(b,Negate(q),Times(C2,c,Sqr(x))),Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))))),-1)),x),x)))),And(FreeQ(List(a,b,c,d,e),x),GtQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),Not(LtQ(c,C0))))),
IIntegrate(1215,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(CN1,a,c),C2))),Plus(Dist(Times(c,Power(Plus(Times(c,d),Times(e,q)),-1)),Int(Power(Plus(a,Times(c,Power(x,4))),CN1D2),x),x),Dist(Times(e,Power(Plus(Times(c,d),Times(e,q)),-1)),Int(Times(Plus(q,Times(CN1,c,Sqr(x))),Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(a,Times(c,Power(x,4))))),-1)),x),x))),And(FreeQ(List(a,c,d,e),x),GtQ(Times(CN1,a,c),C0),Not(LtQ(c,C0))))),
IIntegrate(1216,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(c,Power(a,-1)),C2))),Plus(Dist(Times(Plus(Times(c,d),Times(a,e,q)),Power(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),-1)),Int(Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),CN1D2),x),x),Negate(Dist(Times(a,e,Plus(e,Times(d,q)),Power(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),-1)),Int(Times(Plus(C1,Times(q,Sqr(x))),Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))))),-1)),x),x)))),And(FreeQ(List(a,b,c,d,e),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),C0),PosQ(Times(c,Power(a,-1)))))),
IIntegrate(1217,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(c,Power(a,-1)),C2))),Plus(Dist(Times(Plus(Times(c,d),Times(a,e,q)),Power(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),-1)),Int(Power(Plus(a,Times(c,Power(x,4))),CN1D2),x),x),Negate(Dist(Times(a,e,Plus(e,Times(d,q)),Power(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),-1)),Int(Times(Plus(C1,Times(q,Sqr(x))),Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(a,Times(c,Power(x,4))))),-1)),x),x)))),And(FreeQ(List(a,c,d,e),x),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),C0),PosQ(Times(c,Power(a,-1)))))),
IIntegrate(1218,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(CN1,c,Power(a,-1)),C4))),Simp(Times(C1,EllipticPi(Times(CN1,e,Power(Times(d,Sqr(q)),-1)),ArcSin(Times(q,x)),CN1),Power(Times(d,Sqrt(a),q),-1)),x)),And(FreeQ(List(a,c,d,e),x),NegQ(Times(c,Power(a,-1))),GtQ(a,C0)))),
IIntegrate(1219,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(Dist(Times(Sqrt(Plus(C1,Times(c,Power(x,4),Power(a,-1)))),Power(Plus(a,Times(c,Power(x,4))),CN1D2)),Int(Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(C1,Times(c,Power(x,4),Power(a,-1))))),-1),x),x),And(FreeQ(List(a,c,d,e),x),NegQ(Times(c,Power(a,-1))),Not(GtQ(a,C0))))),
IIntegrate(1220,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(q,Rt(Plus(Sqr(b),Times(CN1,C4,a,c)),C2))),Dist(Times(Sqrt(Plus(C1,Times(C2,c,Sqr(x),Power(Plus(b,Negate(q)),-1)))),Sqrt(Plus(C1,Times(C2,c,Sqr(x),Power(Plus(b,q),-1)))),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),CN1D2)),Int(Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(C1,Times(C2,c,Sqr(x),Power(Plus(b,Negate(q)),-1)))),Sqrt(Plus(C1,Times(C2,c,Sqr(x),Power(Plus(b,q),-1))))),-1),x),x)),And(FreeQ(List(a,b,c,d,e),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NegQ(Times(c,Power(a,-1)))))),
IIntegrate(1221,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_)),x_Symbol),
    Condition(Plus(Dist(Power(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),-1),Int(Times(Plus(Times(c,d),Times(CN1,b,e),Times(CN1,c,e,Sqr(x))),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),p)),x),x),Dist(Times(Sqr(e),Power(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),-1)),Int(Times(Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),Plus(p,C1)),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),ILtQ(Plus(p,C1D2),C0)))),
IIntegrate(1222,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),p_)),x_Symbol),
    Condition(Plus(Dist(Power(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),-1),Int(Times(Plus(Times(c,d),Times(CN1,c,e,Sqr(x))),Power(Plus(a,Times(c,Power(x,4))),p)),x),x),Dist(Times(Sqr(e),Power(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),-1)),Int(Times(Power(Plus(a,Times(c,Power(x,4))),Plus(p,C1)),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x)),And(FreeQ(List(a,c,d,e),x),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),ILtQ(Plus(p,C1D2),C0)))),
IIntegrate(1223,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Sqr(e),x,Power(Plus(d,Times(e,Sqr(x))),Plus(q,C1)),Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4)))),Power(Times(C2,d,Plus(q,C1),Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e)))),-1)),x)),Dist(Power(Times(C2,d,Plus(q,C1),Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e)))),-1),Int(Times(Power(Plus(d,Times(e,Sqr(x))),Plus(q,C1)),Simp(Plus(Times(a,Sqr(e),Plus(Times(C2,q),C3)),Times(C2,d,Plus(Times(c,d),Times(CN1,b,e)),Plus(q,C1)),Times(CN1,C2,e,Plus(Times(c,d,Plus(q,C1)),Times(CN1,b,e,Plus(q,C2))),Sqr(x)),Times(c,Sqr(e),Plus(Times(C2,q),C5),Power(x,4))),x),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),CN1D2)),x),x)),And(FreeQ(List(a,b,c,d,e),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),ILtQ(q,CN1)))),
IIntegrate(1224,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Sqr(e),x,Power(Plus(d,Times(e,Sqr(x))),Plus(q,C1)),Sqrt(Plus(a,Times(c,Power(x,4)))),Power(Times(C2,d,Plus(q,C1),Plus(Times(c,Sqr(d)),Times(a,Sqr(e)))),-1)),x)),Dist(Power(Times(C2,d,Plus(q,C1),Plus(Times(c,Sqr(d)),Times(a,Sqr(e)))),-1),Int(Times(Power(Plus(d,Times(e,Sqr(x))),Plus(q,C1)),Simp(Plus(Times(a,Sqr(e),Plus(Times(C2,q),C3)),Times(C2,c,Sqr(d),Plus(q,C1)),Times(CN1,C2,e,c,d,Plus(q,C1),Sqr(x)),Times(c,Sqr(e),Plus(Times(C2,q),C5),Power(x,4))),x),Power(Plus(a,Times(c,Power(x,4))),CN1D2)),x),x)),And(FreeQ(List(a,c,d,e),x),ILtQ(q,CN1)))),
IIntegrate(1225,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-2),Sqrt(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))))),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(e,Power(d,-1)),C2))),Simp(Times(c,Plus(d,Times(e,Sqr(x))),Sqrt(Times(Sqr(e),Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),Power(Times(c,Sqr(Plus(d,Times(e,Sqr(x))))),-1))),EllipticE(Times(C2,ArcTan(Times(q,x))),Times(Plus(Times(C2,c,d),Times(CN1,b,e)),Power(Times(C4,c,d),-1))),Power(Times(C2,d,Sqr(e),q,Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))))),-1)),x)),And(FreeQ(List(a,b,c,d,e),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),EqQ(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),C0),PosQ(Times(e,Power(d,-1)))))),
IIntegrate(1226,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-2),Sqrt(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))))),x_Symbol),
    Condition(Plus(Simp(Times(x,Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4)))),Power(Times(C2,d,Plus(d,Times(e,Sqr(x)))),-1)),x),Dist(Times(c,Power(Times(C2,d,Sqr(e)),-1)),Int(Times(Plus(d,Times(CN1,e,Sqr(x))),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),CN1D2)),x),x),Negate(Dist(Times(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),Power(Times(C2,d,Sqr(e)),-1)),Int(Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))))),-1),x),x))),And(FreeQ(List(a,b,c,d,e),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0)))),
IIntegrate(1227,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-2),Sqrt(Plus(a_,Times(c_DEFAULT,Power(x_,4))))),x_Symbol),
    Condition(Plus(Simp(Times(x,Sqrt(Plus(a,Times(c,Power(x,4)))),Power(Times(C2,d,Plus(d,Times(e,Sqr(x)))),-1)),x),Dist(Times(c,Power(Times(C2,d,Sqr(e)),-1)),Int(Times(Plus(d,Times(CN1,e,Sqr(x))),Power(Plus(a,Times(c,Power(x,4))),CN1D2)),x),x),Negate(Dist(Times(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),Power(Times(C2,d,Sqr(e)),-1)),Int(Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(a,Times(c,Power(x,4))))),-1),x),x))),And(FreeQ(List(a,c,d,e),x),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0)))),
IIntegrate(1228,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_)),x_Symbol),
    Condition(Module(List($s("aa"),$s("bb"),$s("cc")),Int(ReplaceAll(ExpandIntegrand(Power(Plus($s("aa"),Times($s("bb"),Sqr(x)),Times($s("cc"),Power(x,4))),CN1D2),Times(Power(Plus(d,Times(e,Sqr(x))),q),Power(Plus($s("aa"),Times($s("bb"),Sqr(x)),Times($s("cc"),Power(x,4))),Plus(p,C1D2))),x),List(Rule($s("aa"),a),Rule($s("bb"),b),Rule($s("cc"),c))),x)),And(FreeQ(List(a,b,c,d,e),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),ILtQ(q,C0),IntegerQ(Plus(p,C1D2))))),
IIntegrate(1229,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),p_)),x_Symbol),
    Condition(Module(List($s("aa"),$s("cc")),Int(ReplaceAll(ExpandIntegrand(Power(Plus($s("aa"),Times($s("cc"),Power(x,4))),CN1D2),Times(Power(Plus(d,Times(e,Sqr(x))),q),Power(Plus($s("aa"),Times($s("cc"),Power(x,4))),Plus(p,C1D2))),x),List(Rule($s("aa"),a),Rule($s("cc"),c))),x)),And(FreeQ(List(a,c,d,e),x),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),ILtQ(q,C0),IntegerQ(Plus(p,C1D2))))),
IIntegrate(1230,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),CN1D2),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(Simp(Times(C1,EllipticF(Times(C2,ArcSin(Times(Rt(Times(CN1,e,Power(d,-1)),C2),x))),Times(b,d,Power(Times(C4,a,e),-1))),Power(Times(C2,Sqrt(a),Sqrt(d),Rt(Times(CN1,e,Power(d,-1)),C2)),-1)),x),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(c,d),Times(CN1,b,e)),C0),GtQ(a,C0),GtQ(d,C0)))),
IIntegrate(1231,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),CN1D2),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(Dist(Times(Sqrt(Times(Plus(d,Times(e,Sqr(x))),Power(d,-1))),Sqrt(Times(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),Power(a,-1))),Power(Times(Sqrt(Plus(d,Times(e,Sqr(x)))),Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))))),-1)),Int(Power(Times(Sqrt(Plus(C1,Times(e,Sqr(x),Power(d,-1)))),Sqrt(Plus(C1,Times(b,Sqr(x),Power(a,-1)),Times(c,Power(x,4),Power(a,-1))))),-1),x),x),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(c,d),Times(CN1,b,e)),C0),Not(And(GtQ(a,C0),GtQ(d,C0)))))),
IIntegrate(1232,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),CN1D2),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(Dist(Times(Power(x,3),Sqrt(Plus(e,Times(d,Power(x,-2)))),Sqrt(Plus(c,Times(b,Power(x,-2)),Times(a,Power(x,-4)))),Power(Times(Sqrt(Plus(d,Times(e,Sqr(x)))),Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))))),-1)),Int(Power(Times(Power(x,3),Sqrt(Plus(e,Times(d,Power(x,-2)))),Sqrt(Plus(c,Times(b,Power(x,-2)),Times(a,Power(x,-4))))),-1),x),x),And(FreeQ(List(a,b,c,d,e),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0)))),
IIntegrate(1233,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),CN1D2),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(Dist(Times(Power(x,3),Sqrt(Plus(e,Times(d,Power(x,-2)))),Sqrt(Plus(c,Times(a,Power(x,-4)))),Power(Times(Sqrt(Plus(d,Times(e,Sqr(x)))),Sqrt(Plus(a,Times(c,Power(x,4))))),-1)),Int(Power(Times(Power(x,3),Sqrt(Plus(e,Times(d,Power(x,-2)))),Sqrt(Plus(c,Times(a,Power(x,-4))))),-1),x),x),And(FreeQ(List(a,c,d,e),x),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0)))),
IIntegrate(1234,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),CN1D2),Sqrt(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))))),x_Symbol),
    Condition(Simp(Times(Sqrt(a),EllipticE(Times(C2,ArcSin(Times(Rt(Times(CN1,e,Power(d,-1)),C2),x))),Times(b,d,Power(Times(C4,a,e),-1))),Power(Times(C2,Sqrt(d),Rt(Times(CN1,e,Power(d,-1)),C2)),-1)),x),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(c,d),Times(CN1,b,e)),C0),GtQ(a,C0),GtQ(d,C0)))),
IIntegrate(1235,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),CN1D2),Sqrt(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))))),x_Symbol),
    Condition(Dist(Times(Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4)))),Sqrt(Times(Plus(d,Times(e,Sqr(x))),Power(d,-1))),Power(Times(Sqrt(Plus(d,Times(e,Sqr(x)))),Sqrt(Times(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),Power(a,-1)))),-1)),Int(Times(Sqrt(Plus(C1,Times(b,Sqr(x),Power(a,-1)),Times(c,Power(x,4),Power(a,-1)))),Power(Plus(C1,Times(e,Sqr(x),Power(d,-1))),CN1D2)),x),x),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(c,d),Times(CN1,b,e)),C0),Not(And(GtQ(a,C0),GtQ(d,C0)))))),
IIntegrate(1236,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),CN1D2),Sqrt(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))))),x_Symbol),
    Condition(Dist(Times(Sqrt(Plus(e,Times(d,Power(x,-2)))),Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4)))),Power(Times(x,Sqrt(Plus(d,Times(e,Sqr(x)))),Sqrt(Plus(c,Times(b,Power(x,-2)),Times(a,Power(x,-4))))),-1)),Int(Times(x,Sqrt(Plus(c,Times(b,Power(x,-2)),Times(a,Power(x,-4)))),Power(Plus(e,Times(d,Power(x,-2))),CN1D2)),x),x),And(FreeQ(List(a,b,c,d,e),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0)))),
IIntegrate(1237,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),CN1D2),Sqrt(Plus(a_,Times(c_DEFAULT,Power(x_,4))))),x_Symbol),
    Condition(Dist(Times(Sqrt(Plus(e,Times(d,Power(x,-2)))),Sqrt(Plus(a,Times(c,Power(x,4)))),Power(Times(x,Sqrt(Plus(d,Times(e,Sqr(x)))),Sqrt(Plus(c,Times(a,Power(x,-4))))),-1)),Int(Times(x,Sqrt(Plus(c,Times(a,Power(x,-4)))),Power(Plus(e,Times(d,Power(x,-2))),CN1D2)),x),x),And(FreeQ(List(a,c,d,e),x),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0)))),
IIntegrate(1238,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times(Power(Plus(d,Times(e,Sqr(x))),q),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),p)),x),x),And(FreeQ(List(a,b,c,d,e,p,q),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),Or(And(IntegerQ(p),IntegerQ(q)),IGtQ(p,C0),IGtQ(q,C0))))),
IIntegrate(1239,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),p_)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times(Power(Plus(d,Times(e,Sqr(x))),q),Power(Plus(a,Times(c,Power(x,4))),p)),x),x),And(FreeQ(List(a,c,d,e,p,q),x),Or(And(IntegerQ(p),IntegerQ(q)),IGtQ(p,C0))))),
IIntegrate(1240,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),p_)),x_Symbol),
    Condition(Int(ExpandIntegrand(Power(Plus(a,Times(c,Power(x,4))),p),Power(Plus(Times(d,Power(Plus(Sqr(d),Times(CN1,Sqr(e),Power(x,4))),-1)),Times(CN1,e,Sqr(x),Power(Plus(Sqr(d),Times(CN1,Sqr(e),Power(x,4))),-1))),Negate(q)),x),x),And(FreeQ(List(a,c,d,e,p),x),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),Not(IntegerQ(p)),ILtQ(q,C0)))),
IIntegrate(1241,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_DEFAULT)),x_Symbol),
    Condition(Unintegrable(Times(Power(Plus(d,Times(e,Sqr(x))),q),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),p)),x),FreeQ(List(a,b,c,d,e,p,q),x))),
IIntegrate(1242,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),p_DEFAULT)),x_Symbol),
    Condition(Unintegrable(Times(Power(Plus(d,Times(e,Sqr(x))),q),Power(Plus(a,Times(c,Power(x,4))),p)),x),FreeQ(List(a,c,d,e,p,q),x))),
IIntegrate(1243,Int(Times(Power(x_,m_DEFAULT),Power(Times(e_DEFAULT,Sqr(x_)),q_),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Power(Times(C2,Power(e,Times(C1D2,Plus(m,Negate(C1))))),-1),Subst(Int(Times(Power(Times(e,x),Plus(q,Times(C1D2,Plus(m,Negate(C1))))),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),p)),x),x,Sqr(x)),x),And(FreeQ(List(a,b,c,e,p,q),x),Not(IntegerQ(q)),IntegerQ(Times(C1D2,Plus(m,Negate(C1))))))),
IIntegrate(1244,Int(Times(Power(x_,m_DEFAULT),Power(Times(e_DEFAULT,Sqr(x_)),q_),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Power(Times(C2,Power(e,Times(C1D2,Plus(m,Negate(C1))))),-1),Subst(Int(Times(Power(Times(e,x),Plus(q,Times(C1D2,Plus(m,Negate(C1))))),Power(Plus(a,Times(c,Sqr(x))),p)),x),x,Sqr(x)),x),And(FreeQ(List(a,c,e,p,q),x),Not(IntegerQ(q)),IntegerQ(Times(C1D2,Plus(m,Negate(C1))))))),
IIntegrate(1245,Int(Times(Power(Times(f_DEFAULT,x_),m_DEFAULT),Power(Times(e_DEFAULT,Sqr(x_)),q_),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(e,IntPart(q)),Power(Times(e,Sqr(x)),FracPart(q)),Power(Times(Power(f,Times(C2,IntPart(q))),Power(Times(f,x),Times(C2,FracPart(q)))),-1)),Int(Times(Power(Times(f,x),Plus(m,Times(C2,q))),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),p)),x),x),And(FreeQ(List(a,b,c,e,f,m,p,q),x),Not(IntegerQ(q))))),
IIntegrate(1246,Int(Times(Power(Times(f_DEFAULT,x_),m_DEFAULT),Power(Times(e_DEFAULT,Sqr(x_)),q_),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(e,IntPart(q)),Power(Times(e,Sqr(x)),FracPart(q)),Power(Times(Power(f,Times(C2,IntPart(q))),Power(Times(f,x),Times(C2,FracPart(q)))),-1)),Int(Times(Power(Times(f,x),Plus(m,Times(C2,q))),Power(Plus(a,Times(c,Power(x,4))),p)),x),x),And(FreeQ(List(a,c,e,f,m,p,q),x),Not(IntegerQ(q))))),
IIntegrate(1247,Int(Times(x_,Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_DEFAULT)),x_Symbol),
    Condition(Dist(C1D2,Subst(Int(Times(Power(Plus(d,Times(e,x)),q),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),p)),x),x,Sqr(x)),x),FreeQ(List(a,b,c,d,e,p,q),x))),
IIntegrate(1248,Int(Times(x_,Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),p_DEFAULT)),x_Symbol),
    Condition(Dist(C1D2,Subst(Int(Times(Power(Plus(d,Times(e,x)),q),Power(Plus(a,Times(c,Sqr(x))),p)),x),x,Sqr(x)),x),FreeQ(List(a,c,d,e,p,q),x))),
IIntegrate(1249,Int(Times(Power(x_,m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_)),x_Symbol),
    Condition(Dist(C1D2,Subst(Int(Times(Power(x,Times(C1D2,Plus(m,Negate(C1)))),Power(Plus(d,Times(e,x)),q),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),p)),x),x,Sqr(x)),x),And(FreeQ(List(a,b,c,d,e,p,q),x),EqQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),Not(IntegerQ(p)),IGtQ(Times(C1D2,Plus(m,C1)),C0)))),
IIntegrate(1250,Int(Times(Power(Times(f_DEFAULT,x_),m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_)),x_Symbol),
    Condition(Dist(Times(Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),FracPart(p)),Power(Times(Power(c,IntPart(p)),Power(Plus(Times(C1D2,b),Times(c,Sqr(x))),Times(C2,FracPart(p)))),-1)),Int(Times(Power(Times(f,x),m),Power(Plus(d,Times(e,Sqr(x))),q),Power(Plus(Times(C1D2,b),Times(c,Sqr(x))),Times(C2,p))),x),x),And(FreeQ(List(a,b,c,d,e,f,m,p,q),x),EqQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),Not(IntegerQ(p)))))
  );
}