package org.matheclipse.core.integrate.rubi45;


import static org.matheclipse.core.expression.F.*;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.*;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctions.*;
import org.matheclipse.core.interfaces.IAST;

/** 
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class IntRules93 { 
  public static IAST RULES = List( 
ISetDelayed(8626,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),QQ(-3L,2L)),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcSin(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(x,Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n),Power(Times(d,Sqrt(Plus(d,Times(e,Sqr(x))))),-1)),x),Negate(Dist(Times(b,c,n,Power(d,CN1D2)),Int(Times(x,Power(Plus(a,Times(b,ArcSin(Times(c,x)))),Plus(n,Negate(C1))),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),GtQ(d,C0)))),
ISetDelayed(8627,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),QQ(-3L,2L)),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCos(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(x,Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n),Power(Times(d,Sqrt(Plus(d,Times(e,Sqr(x))))),-1)),x),Dist(Times(b,c,n,Power(d,CN1D2)),Int(Times(x,Power(Plus(a,Times(b,ArcCos(Times(c,x)))),Plus(n,Negate(C1))),Power(Plus(d,Times(e,Sqr(x))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),GtQ(d,C0)))),
ISetDelayed(8628,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),QQ(-3L,2L)),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcSin(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(x,Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n),Power(Times(d,Sqrt(Plus(d,Times(e,Sqr(x))))),-1)),x),Negate(Dist(Times(b,c,n,Sqrt(Plus(C1,Times(CN1,Sqr(c),Sqr(x)))),Power(Times(d,Sqrt(Plus(d,Times(e,Sqr(x))))),-1)),Int(Times(x,Power(Plus(a,Times(b,ArcSin(Times(c,x)))),Plus(n,Negate(C1))),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0)))),
ISetDelayed(8629,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),QQ(-3L,2L)),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCos(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(x,Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n),Power(Times(d,Sqrt(Plus(d,Times(e,Sqr(x))))),-1)),x),Dist(Times(b,c,n,Sqrt(Plus(C1,Times(CN1,Sqr(c),Sqr(x)))),Power(Times(d,Sqrt(Plus(d,Times(e,Sqr(x))))),-1)),Int(Times(x,Power(Plus(a,Times(b,ArcCos(Times(c,x)))),Plus(n,Negate(C1))),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0)))),
ISetDelayed(8630,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcSin(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(x,Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n),Power(Times(C2,d,Plus(p,C1)),-1)),x)),Dist(Times(Plus(Times(C2,p),C3),Power(Times(C2,d,Plus(p,C1)),-1)),Int(Times(Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n)),x),x),Dist(Times(b,c,n,Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(C2,Plus(p,C1),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),FracPart(p))),-1)),Int(Times(x,Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),Plus(p,C1D2)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),Plus(n,Negate(C1)))),x),x)),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),LtQ(p,CN1),NeQ(p,QQ(-3L,2L))))),
ISetDelayed(8631,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCos(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(x,Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n),Power(Times(C2,d,Plus(p,C1)),-1)),x)),Dist(Times(Plus(Times(C2,p),C3),Power(Times(C2,d,Plus(p,C1)),-1)),Int(Times(Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n)),x),x),Negate(Dist(Times(b,c,n,Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(C2,Plus(p,C1),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),FracPart(p))),-1)),Int(Times(x,Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),Plus(p,C1D2)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),Plus(n,Negate(C1)))),x),x))),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),LtQ(p,CN1),NeQ(p,QQ(-3L,2L))))),
ISetDelayed(8632,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcSin(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Dist(Power(Times(c,d),-1),Subst(Int(Times(Power(Plus(a,Times(b,x)),n),Sec(x)),x),x,ArcSin(Times(c,x))),x),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(n,C0)))),
ISetDelayed(8633,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCos(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Negate(Dist(Power(Times(c,d),-1),Subst(Int(Times(Power(Plus(a,Times(b,x)),n),Csc(x)),x),x,ArcCos(Times(c,x))),x)),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(n,C0)))),
ISetDelayed(8634,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcSin(Times(c_DEFAULT,x_)))),n_)),x_Symbol),
    Condition(Plus(Simp(Times(Sqrt(Plus(C1,Times(CN1,Sqr(c),Sqr(x)))),Power(Plus(d,Times(e,Sqr(x))),p),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),Plus(n,C1)),Power(Times(b,c,Plus(n,C1)),-1)),x),Dist(Times(c,Plus(Times(C2,p),C1),Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(b,Plus(n,C1),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),FracPart(p))),-1)),Int(Times(x,Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),Plus(p,Negate(C1D2))),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),Plus(n,C1))),x),x)),And(FreeQ(List(a,b,c,d,e,p),x),EqQ(Plus(Times(Sqr(c),d),e),C0),LtQ(n,CN1)))),
ISetDelayed(8635,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCos(Times(c_DEFAULT,x_)))),n_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Sqrt(Plus(C1,Times(CN1,Sqr(c),Sqr(x)))),Power(Plus(d,Times(e,Sqr(x))),p),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),Plus(n,C1)),Power(Times(b,c,Plus(n,C1)),-1)),x)),Negate(Dist(Times(c,Plus(Times(C2,p),C1),Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(b,Plus(n,C1),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),FracPart(p))),-1)),Int(Times(x,Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),Plus(p,Negate(C1D2))),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),Plus(n,C1))),x),x))),And(FreeQ(List(a,b,c,d,e,p),x),EqQ(Plus(Times(Sqr(c),d),e),C0),LtQ(n,CN1)))),
ISetDelayed(8636,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcSin(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(d,p),Power(c,-1)),Subst(Int(Times(Power(Plus(a,Times(b,x)),n),Power(Cos(x),Plus(Times(C2,p),C1))),x),x,ArcSin(Times(c,x))),x),And(FreeQ(List(a,b,c,d,e,n),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(Times(C2,p),C0),Or(IntegerQ(p),GtQ(d,C0))))),
ISetDelayed(8637,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCos(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Negate(Dist(Times(Power(d,p),Power(c,-1)),Subst(Int(Times(Power(Plus(a,Times(b,x)),n),Power(Sin(x),Plus(Times(C2,p),C1))),x),x,ArcCos(Times(c,x))),x)),And(FreeQ(List(a,b,c,d,e,n),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(Times(C2,p),C0),Or(IntegerQ(p),GtQ(d,C0))))),
ISetDelayed(8638,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcSin(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(d,Plus(p,Negate(C1D2))),Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),CN1D2)),Int(Times(Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),p),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n)),x),x),And(FreeQ(List(a,b,c,d,e,n),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(Times(C2,p),C0),Not(Or(IntegerQ(p),GtQ(d,C0)))))),
ISetDelayed(8639,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCos(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(d,Plus(p,Negate(C1D2))),Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),CN1D2)),Int(Times(Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),p),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n)),x),x),And(FreeQ(List(a,b,c,d,e,n),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(Times(C2,p),C0),Not(Or(IntegerQ(p),GtQ(d,C0)))))),
ISetDelayed(8640,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT),Plus(a_DEFAULT,Times(b_DEFAULT,ArcSin(Times(c_DEFAULT,x_))))),x_Symbol),
    Condition(With(List(Set(u,IntHide(Power(Plus(d,Times(e,Sqr(x))),p),x))),Plus(Dist(Plus(a,Times(b,ArcSin(Times(c,x)))),u,x),Negate(Dist(Times(b,c),Int(SimplifyIntegrand(Times(u,Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),CN1D2)),x),x),x)))),And(FreeQ(List(a,b,c,d,e),x),NeQ(Plus(Times(Sqr(c),d),e),C0),Or(IGtQ(p,C0),ILtQ(Plus(p,C1D2),C0))))),
ISetDelayed(8641,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT),Plus(a_DEFAULT,Times(b_DEFAULT,ArcCos(Times(c_DEFAULT,x_))))),x_Symbol),
    Condition(With(List(Set(u,IntHide(Power(Plus(d,Times(e,Sqr(x))),p),x))),Plus(Dist(Plus(a,Times(b,ArcCos(Times(c,x)))),u,x),Dist(Times(b,c),Int(SimplifyIntegrand(Times(u,Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),CN1D2)),x),x),x))),And(FreeQ(List(a,b,c,d,e),x),NeQ(Plus(Times(Sqr(c),d),e),C0),Or(IGtQ(p,C0),ILtQ(Plus(p,C1D2),C0))))),
ISetDelayed(8642,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcSin(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Int(ExpandIntegrand(Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n),Power(Plus(d,Times(e,Sqr(x))),p),x),x),And(FreeQ(List(a,b,c,d,e,n),x),NeQ(Plus(Times(Sqr(c),d),e),C0),IntegerQ(p),Or(GtQ(p,C0),IGtQ(n,C0))))),
ISetDelayed(8643,Int(Times(Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCos(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Int(ExpandIntegrand(Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n),Power(Plus(d,Times(e,Sqr(x))),p),x),x),And(FreeQ(List(a,b,c,d,e,n),x),NeQ(Plus(Times(Sqr(c),d),e),C0),IntegerQ(p),Or(GtQ(p,C0),IGtQ(n,C0))))),
ISetDelayed(8644,Int(Times(Power(Plus(d_,Times(e_DEFAULT,x_)),p_),Power(Plus(f_,Times(g_DEFAULT,x_)),q_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcSin(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Dist(Power(Times(CN1,Sqr(d),g,Power(e,-1)),q),Int(Times(Power(Plus(d,Times(e,x)),Plus(p,Negate(q))),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),q),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n)),x),x),And(FreeQ(List(a,b,c,d,e,f,g,n),x),EqQ(Plus(Times(e,f),Times(d,g)),C0),EqQ(Plus(Times(Sqr(c),Sqr(d)),Negate(Sqr(e))),C0),HalfIntegerQ(p,q),GeQ(Plus(p,Negate(q)),C0),GtQ(d,C0),LtQ(Times(g,Power(e,-1)),C0)))),
ISetDelayed(8645,Int(Times(Power(Plus(d_,Times(e_DEFAULT,x_)),p_),Power(Plus(f_,Times(g_DEFAULT,x_)),q_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCos(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Dist(Power(Times(CN1,Sqr(d),g,Power(e,-1)),q),Int(Times(Power(Plus(d,Times(e,x)),Plus(p,Negate(q))),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),q),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n)),x),x),And(FreeQ(List(a,b,c,d,e,f,g,n),x),EqQ(Plus(Times(e,f),Times(d,g)),C0),EqQ(Plus(Times(Sqr(c),Sqr(d)),Negate(Sqr(e))),C0),HalfIntegerQ(p,q),GeQ(Plus(p,Negate(q)),C0),GtQ(d,C0),LtQ(Times(g,Power(e,-1)),C0)))),
ISetDelayed(8646,Int(Times(Power(Plus(d_,Times(e_DEFAULT,x_)),p_),Power(Plus(f_,Times(g_DEFAULT,x_)),q_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcSin(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(Plus(d,Times(e,x)),q),Power(Plus(f,Times(g,x)),q),Power(Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),q),-1)),Int(Times(Power(Plus(d,Times(e,x)),Plus(p,Negate(q))),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),q),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n)),x),x),And(FreeQ(List(a,b,c,d,e,f,g,n),x),EqQ(Plus(Times(e,f),Times(d,g)),C0),EqQ(Plus(Times(Sqr(c),Sqr(d)),Negate(Sqr(e))),C0),HalfIntegerQ(p,q),GeQ(Plus(p,Negate(q)),C0)))),
ISetDelayed(8647,Int(Times(Power(Plus(d_,Times(e_DEFAULT,x_)),p_),Power(Plus(f_,Times(g_DEFAULT,x_)),q_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCos(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(Plus(d,Times(e,x)),q),Power(Plus(f,Times(g,x)),q),Power(Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),q),-1)),Int(Times(Power(Plus(d,Times(e,x)),Plus(p,Negate(q))),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),q),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n)),x),x),And(FreeQ(List(a,b,c,d,e,f,g,n),x),EqQ(Plus(Times(e,f),Times(d,g)),C0),EqQ(Plus(Times(Sqr(c),Sqr(d)),Negate(Sqr(e))),C0),HalfIntegerQ(p,q),GeQ(Plus(p,Negate(q)),C0)))),
ISetDelayed(8648,Int(Times(x_,Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcSin(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Negate(Dist(Power(e,-1),Subst(Int(Times(Power(Plus(a,Times(b,x)),n),Tan(x)),x),x,ArcSin(Times(c,x))),x)),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(n,C0)))),
ISetDelayed(8649,Int(Times(x_,Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCos(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Dist(Power(e,-1),Subst(Int(Times(Power(Plus(a,Times(b,x)),n),Cot(x)),x),x,ArcCos(Times(c,x))),x),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(n,C0)))),
ISetDelayed(8650,Int(Times(x_,Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcSin(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n),Power(Times(C2,e,Plus(p,C1)),-1)),x),Dist(Times(b,n,Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(C2,c,Plus(p,C1),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),FracPart(p))),-1)),Int(Times(Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),Plus(p,C1D2)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),Plus(n,Negate(C1)))),x),x)),And(FreeQ(List(a,b,c,d,e,p),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),NeQ(p,CN1)))),
ISetDelayed(8651,Int(Times(x_,Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCos(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n),Power(Times(C2,e,Plus(p,C1)),-1)),x),Negate(Dist(Times(b,n,Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(C2,c,Plus(p,C1),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),FracPart(p))),-1)),Int(Times(Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),Plus(p,C1D2)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),Plus(n,Negate(C1)))),x),x))),And(FreeQ(List(a,b,c,d,e,p),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),NeQ(p,CN1)))),
ISetDelayed(8652,Int(Times(Power(Times(x_,Plus(d_,Times(e_DEFAULT,Sqr(x_)))),-1),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcSin(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Dist(Power(d,-1),Subst(Int(Times(Power(Plus(a,Times(b,x)),n),Power(Times(Cos(x),Sin(x)),-1)),x),x,ArcSin(Times(c,x))),x),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(n,C0)))),
ISetDelayed(8653,Int(Times(Power(Times(x_,Plus(d_,Times(e_DEFAULT,Sqr(x_)))),-1),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCos(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Negate(Dist(Power(d,-1),Subst(Int(Times(Power(Plus(a,Times(b,x)),n),Power(Times(Cos(x),Sin(x)),-1)),x),x,ArcCos(Times(c,x))),x)),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(n,C0)))),
ISetDelayed(8654,Int(Times(Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcSin(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n),Power(Times(d,f,Plus(m,C1)),-1)),x),Negate(Dist(Times(b,c,n,Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(f,Plus(m,C1),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),FracPart(p))),-1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),Plus(p,C1D2)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),Plus(n,Negate(C1)))),x),x))),And(FreeQ(List(a,b,c,d,e,f,m,p),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),EqQ(Plus(m,Times(C2,p),C3),C0),NeQ(m,CN1)))),
ISetDelayed(8655,Int(Times(Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCos(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(d,Times(e,Sqr(x))),Plus(p,C1)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n),Power(Times(d,f,Plus(m,C1)),-1)),x),Dist(Times(b,c,n,Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(f,Plus(m,C1),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),FracPart(p))),-1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),Plus(p,C1D2)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),Plus(n,Negate(C1)))),x),x)),And(FreeQ(List(a,b,c,d,e,f,m,p),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),EqQ(Plus(m,Times(C2,p),C3),C0),NeQ(m,CN1)))),
ISetDelayed(8656,Int(Times(Power(x_,-1),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT),Plus(a_DEFAULT,Times(b_DEFAULT,ArcSin(Times(c_DEFAULT,x_))))),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(d,Times(e,Sqr(x))),p),Plus(a,Times(b,ArcSin(Times(c,x)))),Power(Times(C2,p),-1)),x),Dist(d,Int(Times(Power(Plus(d,Times(e,Sqr(x))),Plus(p,Negate(C1))),Plus(a,Times(b,ArcSin(Times(c,x)))),Power(x,-1)),x),x),Negate(Dist(Times(b,c,Power(d,p),Power(Times(C2,p),-1)),Int(Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),Plus(p,Negate(C1D2))),x),x))),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(p,C0)))),
ISetDelayed(8657,Int(Times(Power(x_,-1),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT),Plus(a_DEFAULT,Times(b_DEFAULT,ArcCos(Times(c_DEFAULT,x_))))),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(d,Times(e,Sqr(x))),p),Plus(a,Times(b,ArcCos(Times(c,x)))),Power(Times(C2,p),-1)),x),Dist(d,Int(Times(Power(Plus(d,Times(e,Sqr(x))),Plus(p,Negate(C1))),Plus(a,Times(b,ArcCos(Times(c,x)))),Power(x,-1)),x),x),Dist(Times(b,c,Power(d,p),Power(Times(C2,p),-1)),Int(Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),Plus(p,Negate(C1D2))),x),x)),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(p,C0)))),
ISetDelayed(8658,Int(Times(Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT),Plus(a_DEFAULT,Times(b_DEFAULT,ArcSin(Times(c_DEFAULT,x_))))),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(d,Times(e,Sqr(x))),p),Plus(a,Times(b,ArcSin(Times(c,x)))),Power(Times(f,Plus(m,C1)),-1)),x),Negate(Dist(Times(b,c,Power(d,p),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),Plus(p,Negate(C1D2)))),x),x)),Negate(Dist(Times(C2,e,p,Power(Times(Sqr(f),Plus(m,C1)),-1)),Int(Times(Power(Times(f,x),Plus(m,C2)),Power(Plus(d,Times(e,Sqr(x))),Plus(p,Negate(C1))),Plus(a,Times(b,ArcSin(Times(c,x))))),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(p,C0),ILtQ(Times(C1D2,Plus(m,C1)),C0)))),
ISetDelayed(8659,Int(Times(Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT),Plus(a_DEFAULT,Times(b_DEFAULT,ArcCos(Times(c_DEFAULT,x_))))),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(d,Times(e,Sqr(x))),p),Plus(a,Times(b,ArcCos(Times(c,x)))),Power(Times(f,Plus(m,C1)),-1)),x),Dist(Times(b,c,Power(d,p),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),Plus(p,Negate(C1D2)))),x),x),Negate(Dist(Times(C2,e,p,Power(Times(Sqr(f),Plus(m,C1)),-1)),Int(Times(Power(Times(f,x),Plus(m,C2)),Power(Plus(d,Times(e,Sqr(x))),Plus(p,Negate(C1))),Plus(a,Times(b,ArcCos(Times(c,x))))),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(p,C0),ILtQ(Times(C1D2,Plus(m,C1)),C0)))),
ISetDelayed(8660,Int(Times(Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT),Plus(a_DEFAULT,Times(b_DEFAULT,ArcSin(Times(c_DEFAULT,x_))))),x_Symbol),
    Condition(With(List(Set(u,IntHide(Times(Power(Times(f,x),m),Power(Plus(d,Times(e,Sqr(x))),p)),x))),Plus(Dist(Plus(a,Times(b,ArcSin(Times(c,x)))),u,x),Negate(Dist(Times(b,c),Int(SimplifyIntegrand(Times(u,Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),CN1D2)),x),x),x)))),And(FreeQ(List(a,b,c,d,e,f,m),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(p,C0)))),
ISetDelayed(8661,Int(Times(Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT),Plus(a_DEFAULT,Times(b_DEFAULT,ArcCos(Times(c_DEFAULT,x_))))),x_Symbol),
    Condition(With(List(Set(u,IntHide(Times(Power(Times(f,x),m),Power(Plus(d,Times(e,Sqr(x))),p)),x))),Plus(Dist(Plus(a,Times(b,ArcCos(Times(c,x)))),u,x),Dist(Times(b,c),Int(SimplifyIntegrand(Times(u,Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),CN1D2)),x),x),x))),And(FreeQ(List(a,b,c,d,e,f,m),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(p,C0)))),
ISetDelayed(8662,Int(Times(Power(x_,m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_),Plus(a_DEFAULT,Times(b_DEFAULT,ArcSin(Times(c_DEFAULT,x_))))),x_Symbol),
    Condition(With(List(Set(u,IntHide(Times(Power(x,m),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),p)),x))),Plus(Dist(Times(Power(d,p),Plus(a,Times(b,ArcSin(Times(c,x))))),u,x),Negate(Dist(Times(b,c,Power(d,p)),Int(SimplifyIntegrand(Times(u,Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),CN1D2)),x),x),x)))),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IntegerQ(Plus(p,Negate(C1D2))),Or(IGtQ(Times(C1D2,Plus(m,C1)),C0),ILtQ(Times(C1D2,Plus(m,Times(C2,p),C3)),C0)),NeQ(p,Negate(Power(C2,-1))),GtQ(d,C0)))),
ISetDelayed(8663,Int(Times(Power(x_,m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_),Plus(a_DEFAULT,Times(b_DEFAULT,ArcCos(Times(c_DEFAULT,x_))))),x_Symbol),
    Condition(With(List(Set(u,IntHide(Times(Power(x,m),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),p)),x))),Plus(Dist(Times(Power(d,p),Plus(a,Times(b,ArcCos(Times(c,x))))),u,x),Dist(Times(b,c,Power(d,p)),Int(SimplifyIntegrand(Times(u,Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),CN1D2)),x),x),x))),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IntegerQ(Plus(p,Negate(C1D2))),Or(IGtQ(Times(C1D2,Plus(m,C1)),C0),ILtQ(Times(C1D2,Plus(m,Times(C2,p),C3)),C0)),NeQ(p,Negate(Power(C2,-1))),GtQ(d,C0)))),
ISetDelayed(8664,Int(Times(Power(x_,m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_),Plus(a_DEFAULT,Times(b_DEFAULT,ArcSin(Times(c_DEFAULT,x_))))),x_Symbol),
    Condition(With(List(Set(u,IntHide(Times(Power(x,m),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),p)),x))),Plus(Dist(Plus(a,Times(b,ArcSin(Times(c,x)))),Int(Times(Power(x,m),Power(Plus(d,Times(e,Sqr(x))),p)),x),x),Negate(Dist(Times(b,c,Power(d,Plus(p,Negate(C1D2))),Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),CN1D2)),Int(SimplifyIntegrand(Times(u,Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),CN1D2)),x),x),x)))),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(Plus(p,C1D2),C0),Or(IGtQ(Times(C1D2,Plus(m,C1)),C0),ILtQ(Times(C1D2,Plus(m,Times(C2,p),C3)),C0))))),
ISetDelayed(8665,Int(Times(Power(x_,m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_),Plus(a_DEFAULT,Times(b_DEFAULT,ArcCos(Times(c_DEFAULT,x_))))),x_Symbol),
    Condition(With(List(Set(u,IntHide(Times(Power(x,m),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),p)),x))),Plus(Dist(Plus(a,Times(b,ArcCos(Times(c,x)))),Int(Times(Power(x,m),Power(Plus(d,Times(e,Sqr(x))),p)),x),x),Dist(Times(b,c,Power(d,Plus(p,Negate(C1D2))),Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),CN1D2)),Int(SimplifyIntegrand(Times(u,Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),CN1D2)),x),x),x))),And(FreeQ(List(a,b,c,d,e),x),EqQ(Plus(Times(Sqr(c),d),e),C0),IGtQ(Plus(p,C1D2),C0),Or(IGtQ(Times(C1D2,Plus(m,C1)),C0),ILtQ(Times(C1D2,Plus(m,Times(C2,p),C3)),C0))))),
ISetDelayed(8666,Int(Times(Power(Times(f_DEFAULT,x_),m_),Sqrt(Plus(d_,Times(e_DEFAULT,Sqr(x_)))),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcSin(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(f,x),Plus(m,C1)),Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n),Power(Times(f,Plus(m,C1)),-1)),x),Negate(Dist(Times(b,c,n,Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Times(f,Plus(m,C1),Sqrt(Plus(C1,Times(CN1,Sqr(c),Sqr(x))))),-1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),Plus(n,Negate(C1)))),x),x)),Dist(Times(Sqr(c),Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Times(Sqr(f),Plus(m,C1),Sqrt(Plus(C1,Times(CN1,Sqr(c),Sqr(x))))),-1)),Int(Times(Power(Times(f,x),Plus(m,C2)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),CN1D2)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),LtQ(m,CN1)))),
ISetDelayed(8667,Int(Times(Power(Times(f_DEFAULT,x_),m_),Sqrt(Plus(d_,Times(e_DEFAULT,Sqr(x_)))),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCos(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(f,x),Plus(m,C1)),Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n),Power(Times(f,Plus(m,C1)),-1)),x),Dist(Times(b,c,n,Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Times(f,Plus(m,C1),Sqrt(Plus(C1,Times(CN1,Sqr(c),Sqr(x))))),-1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),Plus(n,Negate(C1)))),x),x),Dist(Times(Sqr(c),Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Times(Sqr(f),Plus(m,C1),Sqrt(Plus(C1,Times(CN1,Sqr(c),Sqr(x))))),-1)),Int(Times(Power(Times(f,x),Plus(m,C2)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),CN1D2)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),LtQ(m,CN1)))),
ISetDelayed(8668,Int(Times(Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcSin(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(d,Times(e,Sqr(x))),p),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n),Power(Times(f,Plus(m,C1)),-1)),x),Negate(Dist(Times(C2,e,p,Power(Times(Sqr(f),Plus(m,C1)),-1)),Int(Times(Power(Times(f,x),Plus(m,C2)),Power(Plus(d,Times(e,Sqr(x))),Plus(p,Negate(C1))),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n)),x),x)),Negate(Dist(Times(b,c,n,Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(f,Plus(m,C1),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),FracPart(p))),-1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),Plus(p,Negate(C1D2))),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),Plus(n,Negate(C1)))),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),GtQ(p,C0),LtQ(m,CN1)))),
ISetDelayed(8669,Int(Times(Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCos(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(d,Times(e,Sqr(x))),p),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n),Power(Times(f,Plus(m,C1)),-1)),x),Negate(Dist(Times(C2,e,p,Power(Times(Sqr(f),Plus(m,C1)),-1)),Int(Times(Power(Times(f,x),Plus(m,C2)),Power(Plus(d,Times(e,Sqr(x))),Plus(p,Negate(C1))),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n)),x),x)),Dist(Times(b,c,n,Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(f,Plus(m,C1),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),FracPart(p))),-1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),Plus(p,Negate(C1D2))),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),Plus(n,Negate(C1)))),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),GtQ(p,C0),LtQ(m,CN1)))),
ISetDelayed(8670,Int(Times(Power(Times(f_DEFAULT,x_),m_),Sqrt(Plus(d_,Times(e_DEFAULT,Sqr(x_)))),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcSin(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(f,x),Plus(m,C1)),Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n),Power(Times(f,Plus(m,C2)),-1)),x),Dist(Times(Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Times(Plus(m,C2),Sqrt(Plus(C1,Times(CN1,Sqr(c),Sqr(x))))),-1)),Int(Times(Power(Times(f,x),m),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),CN1D2)),x),x),Negate(Dist(Times(b,c,n,Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Times(f,Plus(m,C2),Sqrt(Plus(C1,Times(CN1,Sqr(c),Sqr(x))))),-1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),Plus(n,Negate(C1)))),x),x))),And(FreeQ(List(a,b,c,d,e,f,m),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),Not(LtQ(m,CN1)),Or(RationalQ(m),EqQ(n,C1))))),
ISetDelayed(8671,Int(Times(Power(Times(f_DEFAULT,x_),m_),Sqrt(Plus(d_,Times(e_DEFAULT,Sqr(x_)))),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCos(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(f,x),Plus(m,C1)),Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n),Power(Times(f,Plus(m,C2)),-1)),x),Dist(Times(Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Times(Plus(m,C2),Sqrt(Plus(C1,Times(CN1,Sqr(c),Sqr(x))))),-1)),Int(Times(Power(Times(f,x),m),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),CN1D2)),x),x),Dist(Times(b,c,n,Sqrt(Plus(d,Times(e,Sqr(x)))),Power(Times(f,Plus(m,C2),Sqrt(Plus(C1,Times(CN1,Sqr(c),Sqr(x))))),-1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),Plus(n,Negate(C1)))),x),x)),And(FreeQ(List(a,b,c,d,e,f,m),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),Not(LtQ(m,CN1)),Or(RationalQ(m),EqQ(n,C1))))),
ISetDelayed(8672,Int(Times(Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcSin(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(d,Times(e,Sqr(x))),p),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n),Power(Times(f,Plus(m,Times(C2,p),C1)),-1)),x),Dist(Times(C2,d,p,Power(Plus(m,Times(C2,p),C1),-1)),Int(Times(Power(Times(f,x),m),Power(Plus(d,Times(e,Sqr(x))),Plus(p,Negate(C1))),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),n)),x),x),Negate(Dist(Times(b,c,n,Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(f,Plus(m,Times(C2,p),C1),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),FracPart(p))),-1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),Plus(p,Negate(C1D2))),Power(Plus(a,Times(b,ArcSin(Times(c,x)))),Plus(n,Negate(C1)))),x),x))),And(FreeQ(List(a,b,c,d,e,f,m),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),GtQ(p,C0),Not(LtQ(m,CN1)),Or(RationalQ(m),EqQ(n,C1))))),
ISetDelayed(8673,Int(Times(Power(Times(f_DEFAULT,x_),m_),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),p_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,ArcCos(Times(c_DEFAULT,x_)))),n_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(d,Times(e,Sqr(x))),p),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n),Power(Times(f,Plus(m,Times(C2,p),C1)),-1)),x),Dist(Times(C2,d,p,Power(Plus(m,Times(C2,p),C1),-1)),Int(Times(Power(Times(f,x),m),Power(Plus(d,Times(e,Sqr(x))),Plus(p,Negate(C1))),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),n)),x),x),Dist(Times(b,c,n,Power(d,IntPart(p)),Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Times(f,Plus(m,Times(C2,p),C1),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),FracPart(p))),-1)),Int(Times(Power(Times(f,x),Plus(m,C1)),Power(Plus(C1,Times(CN1,Sqr(c),Sqr(x))),Plus(p,Negate(C1D2))),Power(Plus(a,Times(b,ArcCos(Times(c,x)))),Plus(n,Negate(C1)))),x),x)),And(FreeQ(List(a,b,c,d,e,f,m),x),EqQ(Plus(Times(Sqr(c),d),e),C0),GtQ(n,C0),GtQ(p,C0),Not(LtQ(m,CN1)),Or(RationalQ(m),EqQ(n,C1)))))
  );
}
