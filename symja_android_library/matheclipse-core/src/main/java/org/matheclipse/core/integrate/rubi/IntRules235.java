package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.*;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.*;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.*;
import org.matheclipse.core.interfaces.IAST;

/** 
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class IntRules235 { 
  public static IAST RULES = List( 
IIntegrate(4701,Int(Times(Power(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n),Power(Times(d,f,Plus(m,C1)),CN1)),x),Dist(Times(Sqr(c),Plus(m,Times(C2,p),C3),Power(Times(Sqr(f),Plus(m,C1)),CN1)),Int(Times(Power(Times(f,x),Plus(m,C2)),Power(Plus(d,Times(e,Sqr(x))),p),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n)),x),x),Negate(Dist(Times(b,c,n,Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(f,Plus(m,C1),Power(Subtract(C1,Times(Sqr(c),Sqr(x))),FracPart(p))),CN1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(Subtract(C1,Times(Sqr(c),Sqr(x))),Plus(p,C1D2)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),Subtract(n,C1))),x),x))),And(FreeQ(List(a,b,c,d,e,f,p),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),LtQ(m,CN1),IntegerQ(m)))),
IIntegrate(4702,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n),Power(Times(d,f,Plus(m,C1)),CN1)),x),Dist(Times(Sqr(c),Plus(m,Times(C2,p),C3),Power(Times(Sqr(f),Plus(m,C1)),CN1)),Int(Times(Power(Times(f,x),Plus(m,C2)),Power(Plus(d,Times(e,Sqr(x))),p),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n)),x),x),Dist(Times(b,c,n,Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(f,Plus(m,C1),Power(Subtract(C1,Times(Sqr(c),Sqr(x))),FracPart(p))),CN1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(Subtract(C1,Times(Sqr(c),Sqr(x))),Plus(p,C1D2)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),Subtract(n,C1))),x),x)),And(FreeQ(List(a,b,c,d,e,f,p),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),LtQ(m,CN1),IntegerQ(m)))),
IIntegrate(4703,Int(Times(Power(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(f,Power(Times(f,x),Subtract(m,C1)),Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n),Power(Times(C2,e,Plus(p,C1)),CN1)),x),Negate(Dist(Times(Sqr(f),Subtract(m,C1),Power(Times(C2,e,Plus(p,C1)),CN1)),Int(Times(Power(Times(f,x),Subtract(m,C2)),Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n)),x),x)),Dist(Times(b,f,n,Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(C2,c,Plus(p,C1),Power(Subtract(C1,Times(Sqr(c),Sqr(x))),FracPart(p))),CN1)),Int(Times(Power(Times(f,x),Subtract(m,C1)),Power(Subtract(C1,Times(Sqr(c),Sqr(x))),Plus(p,C1D2)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),Subtract(n,C1))),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),LtQ(p,CN1),GtQ(m,C1)))),
IIntegrate(4704,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(f,Power(Times(f,x),Subtract(m,C1)),Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n),Power(Times(C2,e,Plus(p,C1)),CN1)),x),Negate(Dist(Times(Sqr(f),Subtract(m,C1),Power(Times(C2,e,Plus(p,C1)),CN1)),Int(Times(Power(Times(f,x),Subtract(m,C2)),Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n)),x),x)),Negate(Dist(Times(b,f,n,Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(C2,c,Plus(p,C1),Power(Subtract(C1,Times(Sqr(c),Sqr(x))),FracPart(p))),CN1)),Int(Times(Power(Times(f,x),Subtract(m,C1)),Power(Subtract(C1,Times(Sqr(c),Sqr(x))),Plus(p,C1D2)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),Subtract(n,C1))),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),LtQ(p,CN1),GtQ(m,C1)))),
IIntegrate(4705,Int(Times(Power(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n),Power(Times(C2,d,f,Plus(p,C1)),CN1)),x)),Dist(Times(Plus(m,Times(C2,p),C3),Power(Times(C2,d,Plus(p,C1)),CN1)),Int(Times(Power(Times(f,x),m),Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n)),x),x),Dist(Times(b,c,n,Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(C2,f,Plus(p,C1),Power(Subtract(C1,Times(Sqr(c),Sqr(x))),FracPart(p))),CN1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(Subtract(C1,Times(Sqr(c),Sqr(x))),Plus(p,C1D2)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),Subtract(n,C1))),x),x)),And(FreeQ(List(a,b,c,d,e,f,m),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),LtQ(p,CN1),Not(GtQ(m,C1)),Or(IntegerQ(m),IntegerQ(p),EqQ(n,C1))))),
IIntegrate(4706,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n),Power(Times(C2,d,f,Plus(p,C1)),CN1)),x)),Dist(Times(Plus(m,Times(C2,p),C3),Power(Times(C2,d,Plus(p,C1)),CN1)),Int(Times(Power(Times(f,x),m),Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n)),x),x),Negate(Dist(Times(b,c,n,Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(C2,f,Plus(p,C1),Power(Subtract(C1,Times(Sqr(c),Sqr(x))),FracPart(p))),CN1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(Subtract(C1,Times(Sqr(c),Sqr(x))),Plus(p,C1D2)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),Subtract(n,C1))),x),x))),And(FreeQ(List(a,b,c,d,e,f,m),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),LtQ(p,CN1),Not(GtQ(m,C1)),Or(IntegerQ(m),IntegerQ(p),EqQ(n,C1))))),
IIntegrate(4707,Int(Times(Power(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),CN1D2)),x_Symbol),
    Condition(Plus(Simp(Times(f,Power(Times(f,x),Subtract(m,C1)),Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n),Power(Times(e,m),CN1)),x),Dist(Times(Sqr(f),Subtract(m,C1),Power(Times(Sqr(c),m),CN1)),Int(Times(Power(Times(f,x),Subtract(m,C2)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n),Power(Plus(d,Times(e,Sqr(x))),CN1D2)),x),x),Dist(Times(b,f,n,Sqrt(Subtract(C1,Times(Sqr(c),Sqr(x)))),Power(Times(c,m,Sqrt(Plus(d,Times(e,Sqr(x))))),CN1)),Int(Times(Power(Times(f,x),Subtract(m,C1)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),Subtract(n,C1))),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),GtQ(m,C1),IntegerQ(m)))),
IIntegrate(4708,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),CN1D2)),x_Symbol),
    Condition(Plus(Simp(Times(f,Power(Times(f,x),Subtract(m,C1)),Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n),Power(Times(e,m),CN1)),x),Dist(Times(Sqr(f),Subtract(m,C1),Power(Times(Sqr(c),m),CN1)),Int(Times(Power(Times(f,x),Subtract(m,C2)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n),Power(Plus(d,Times(e,Sqr(x))),CN1D2)),x),x),Negate(Dist(Times(b,f,n,Sqrt(Subtract(C1,Times(Sqr(c),Sqr(x)))),Power(Times(c,m,Sqrt(Plus(d,Times(e,Sqr(x))))),CN1)),Int(Times(Power(Times(f,x),Subtract(m,C1)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),Subtract(n,C1))),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),GtQ(m,C1),IntegerQ(m)))),
IIntegrate(4709,Int(Times(Power(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(x_,m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),CN1D2)),x_Symbol),
    Condition(Dist(Power(Times(Power(c,Plus(m,C1)),Sqrt(d)),CN1),Subst(Int(Times(Power(Plus(a,Times(b,x)),n),Power(Sin(x),m)),x),x,ArcSin(Times(c,x))),x),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(d,C0),IGtQ(n,C0),IntegerQ(m)))),
IIntegrate(4710,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(x_,m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),CN1D2)),x_Symbol),
    Condition(Negate(Dist(Power(Times(Power(c,Plus(m,C1)),Sqrt(d)),CN1),Subst(Int(Times(Power(Plus(a,Times(b,x)),n),Power(Cos(x),m)),x),x,ArcCos(Times(c,x))),x)),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(d,C0),IGtQ(n,C0),IntegerQ(m)))),
IIntegrate(4711,Int(Times(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),CN1D2)),x_Symbol),
    Condition(Subtract(Simp(Times(Power(Times(f,x),Plus(m,C1)),Plus(a,Times(b,ArcSin(Times(c,x)))),Hypergeometric2F1(C1D2,Times(C1D2,Plus(C1,m)),Times(C1D2,Plus(C3,m)),Times(Sqr(c),Sqr(x))),Power(Times(Sqrt(d),f,Plus(m,C1)),CN1)),x),Simp(Times(b,c,Power(Times(f,x),Plus(m,C2)),HypergeometricPFQ(List(C1,Plus(C1,Times(C1D2,m)),Plus(C1,Times(C1D2,m))),List(Plus(QQ(3L,2L),Times(C1D2,m)),Plus(C2,Times(C1D2,m))),Times(Sqr(c),Sqr(x))),Power(Times(Sqrt(d),Sqr(f),Plus(m,C1),Plus(m,C2)),CN1)),x)),And(FreeQ(List(a,b,c,d,e,f,m),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(d,C0),Not(IntegerQ(m))))),
IIntegrate(4712,Int(Times(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),CN1D2)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(f,x),Plus(m,C1)),Plus(a,Times(b,ArcCos(Times(c,x)))),Hypergeometric2F1(C1D2,Times(C1D2,Plus(C1,m)),Times(C1D2,Plus(C3,m)),Times(Sqr(c),Sqr(x))),Power(Times(Sqrt(d),f,Plus(m,C1)),CN1)),x),Simp(Times(b,c,Power(Times(f,x),Plus(m,C2)),HypergeometricPFQ(List(C1,Plus(C1,Times(C1D2,m)),Plus(C1,Times(C1D2,m))),List(Plus(QQ(3L,2L),Times(C1D2,m)),Plus(C2,Times(C1D2,m))),Times(Sqr(c),Sqr(x))),Power(Times(Sqrt(d),Sqr(f),Plus(m,C1),Plus(m,C2)),CN1)),x)),And(FreeQ(List(a,b,c,d,e,f,m),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(d,C0),Not(IntegerQ(m))))),
IIntegrate(4713,Int(Times(Power(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),CN1D2)),x_Symbol),
    Condition(Dist(Times(Sqrt(Subtract(C1,Times(Sqr(c),Sqr(x)))),Power(Plus(d,Times(e,Sqr(x))),CN1D2)),Int(Times(Power(Times(f,x),m),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n),Power(Subtract(C1,Times(Sqr(c),Sqr(x))),CN1D2)),x),x),And(FreeQ(List(a,b,c,d,e,f,m),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),Not(GtQ(d,C0)),Or(IntegerQ(m),EqQ(n,C1))))),
IIntegrate(4714,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),CN1D2)),x_Symbol),
    Condition(Dist(Times(Sqrt(Subtract(C1,Times(Sqr(c),Sqr(x)))),Power(Plus(d,Times(e,Sqr(x))),CN1D2)),Int(Times(Power(Times(f,x),m),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n),Power(Subtract(C1,Times(Sqr(c),Sqr(x))),CN1D2)),x),x),And(FreeQ(List(a,b,c,d,e,f,m),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),Not(GtQ(d,C0)),Or(IntegerQ(m),EqQ(n,C1))))),
IIntegrate(4715,Int(Times(Power(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(f,Power(Times(f,x),Subtract(m,C1)),Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n),Power(Times(e,Plus(m,Times(C2,p),C1)),CN1)),x),Dist(Times(Sqr(f),Subtract(m,C1),Power(Times(Sqr(c),Plus(m,Times(C2,p),C1)),CN1)),Int(Times(Power(Times(f,x),Subtract(m,C2)),Power(Plus(d,Times(e,Sqr(x))),p),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n)),x),x),Dist(Times(b,f,n,Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(c,Plus(m,Times(C2,p),C1),Power(Subtract(C1,Times(Sqr(c),Sqr(x))),FracPart(p))),CN1)),Int(Times(Power(Times(f,x),Subtract(m,C1)),Power(Subtract(C1,Times(Sqr(c),Sqr(x))),Plus(p,C1D2)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),Subtract(n,C1))),x),x)),And(FreeQ(List(a,b,c,d,e,f,p),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),GtQ(m,C1),NeQ(Plus(m,Times(C2,p),C1),C0),IntegerQ(m)))),
IIntegrate(4716,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),n_DEFAULT),Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Plus(Simp(Times(f,Power(Times(f,x),Subtract(m,C1)),Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n),Power(Times(e,Plus(m,Times(C2,p),C1)),CN1)),x),Dist(Times(Sqr(f),Subtract(m,C1),Power(Times(Sqr(c),Plus(m,Times(C2,p),C1)),CN1)),Int(Times(Power(Times(f,x),Subtract(m,C2)),Power(Plus(d,Times(e,Sqr(x))),p),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n)),x),x),Negate(Dist(Times(b,f,n,Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(c,Plus(m,Times(C2,p),C1),Power(Subtract(C1,Times(Sqr(c),Sqr(x))),FracPart(p))),CN1)),Int(Times(Power(Times(f,x),Subtract(m,C1)),Power(Subtract(C1,Times(Sqr(c),Sqr(x))),Plus(p,C1D2)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),Subtract(n,C1))),x),x))),And(FreeQ(List(a,b,c,d,e,f,p),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),GtQ(m,C1),NeQ(Plus(m,Times(C2,p),C1),C0),IntegerQ(m)))),
IIntegrate(4717,Int(Times(Power(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),n_),Power(Times(f_DEFAULT,x_),m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Subtract(Simp(Times(Power(Times(f,x),m),Sqrt(Subtract(C1,Times(Sqr(c),Sqr(x)))),Power(Plus(d,Times(e,Sqr(x))),p),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),Plus(n,C1)),Power(Times(b,c,Plus(n,C1)),CN1)),x),Dist(Times(f,m,Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(b,c,Plus(n,C1),Power(Subtract(C1,Times(Sqr(c),Sqr(x))),FracPart(p))),CN1)),Int(Times(Power(Times(f,x),Subtract(m,C1)),Power(Subtract(C1,Times(Sqr(c),Sqr(x))),Subtract(p,C1D2)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),Plus(n,C1))),x),x)),And(FreeQ(List(a,b,c,d,e,f,m,p),x),EqQ(Plus(Times(Sqr(c),d),e),C0),LtQ(n,CN1),EqQ(Plus(m,Times(C2,p),C1),C0)))),
IIntegrate(4718,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),n_),Power(Times(f_DEFAULT,x_),m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Power(Times(f,x),m),Sqrt(Subtract(C1,Times(Sqr(c),Sqr(x)))),Power(Plus(d,Times(e,Sqr(x))),p),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),Plus(n,C1)),Power(Times(b,c,Plus(n,C1)),CN1)),x)),Dist(Times(f,m,Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(b,c,Plus(n,C1),Power(Subtract(C1,Times(Sqr(c),Sqr(x))),FracPart(p))),CN1)),Int(Times(Power(Times(f,x),Subtract(m,C1)),Power(Subtract(C1,Times(Sqr(c),Sqr(x))),Subtract(p,C1D2)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),Plus(n,C1))),x),x)),And(FreeQ(List(a,b,c,d,e,f,m,p),x),EqQ(Plus(Times(Sqr(c),d),e),C0),LtQ(n,CN1),EqQ(Plus(m,Times(C2,p),C1),C0)))),
IIntegrate(4719,Int(Times(Power(Plus(a_DEFAULT,Times(ArcSin(Times(c_DEFAULT,x_)),b_DEFAULT)),n_),Power(Times(f_DEFAULT,x_),m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),CN1D2)),x_Symbol),
    Condition(Subtract(Simp(Times(Power(Times(f,x),m),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),Plus(n,C1)),Power(Times(b,c,Sqrt(d),Plus(n,C1)),CN1)),x),Dist(Times(f,m,Power(Times(b,c,Sqrt(d),Plus(n,C1)),CN1)),Int(Times(Power(Times(f,x),Subtract(m,C1)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),Plus(n,C1))),x),x)),And(FreeQ(List(a,b,c,d,e,f,m),x),EqQ(Plus(Times(Sqr(c),d),e),C0),LtQ(n,CN1),GtQ(d,C0)))),
IIntegrate(4720,Int(Times(Power(Plus(a_DEFAULT,Times(ArcCos(Times(c_DEFAULT,x_)),b_DEFAULT)),n_),Power(Times(f_DEFAULT,x_),m_DEFAULT),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),CN1D2)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Power(Times(f,x),m),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),Plus(n,C1)),Power(Times(b,c,Sqrt(d),Plus(n,C1)),CN1)),x)),Dist(Times(f,m,Power(Times(b,c,Sqrt(d),Plus(n,C1)),CN1)),Int(Times(Power(Times(f,x),Subtract(m,C1)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),Plus(n,C1))),x),x)),And(FreeQ(List(a,b,c,d,e,f,m),x),EqQ(Plus(Times(Sqr(c),d),e),C0),LtQ(n,CN1),GtQ(d,C0))))
  );
}
