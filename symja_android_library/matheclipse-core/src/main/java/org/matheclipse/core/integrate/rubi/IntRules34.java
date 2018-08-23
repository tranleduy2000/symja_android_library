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
public class IntRules34 { 
  public static IAST RULES = List( 
IIntegrate(1701,Int(Times(Plus(A_,Times(B_DEFAULT,Sqr(x_))),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(Plus(Dist(Times(Plus(Times(BSymbol,d),Times(ASymbol,e)),Power(Times(C2,d,e),-1)),Int(Power(Plus(a,Times(c,Power(x,4))),CN1D2),x),x),Negate(Dist(Times(Plus(Times(BSymbol,d),Times(CN1,ASymbol,e)),Power(Times(C2,d,e),-1)),Int(Times(Plus(d,Times(CN1,e,Sqr(x))),Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(a,Times(c,Power(x,4))))),-1)),x),x))),And(FreeQ(List(a,c,d,e,ASymbol,BSymbol),x),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),EqQ(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),C0),NeQ(Plus(Times(BSymbol,d),Times(ASymbol,e)),C0)))),
IIntegrate(1702,Int(Times(Plus(A_,Times(B_DEFAULT,Sqr(x_))),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(Dist(Times(Sqrt(Plus(ASymbol,Times(BSymbol,Sqr(x)))),Sqrt(Plus(Times(a,Power(ASymbol,-1)),Times(c,Sqr(x),Power(BSymbol,-1)))),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),CN1D2)),Int(Times(Sqrt(Plus(ASymbol,Times(BSymbol,Sqr(x)))),Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(Times(a,Power(ASymbol,-1)),Times(c,Sqr(x),Power(BSymbol,-1))))),-1)),x),x),And(FreeQ(List(a,b,c,d,e,ASymbol,BSymbol),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),EqQ(Plus(Times(c,Sqr(ASymbol)),Times(CN1,b,ASymbol,BSymbol),Times(a,Sqr(BSymbol))),C0)))),
IIntegrate(1703,Int(Times(Plus(A_,Times(B_DEFAULT,Sqr(x_))),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(Dist(Times(Sqrt(Plus(ASymbol,Times(BSymbol,Sqr(x)))),Sqrt(Plus(Times(a,Power(ASymbol,-1)),Times(c,Sqr(x),Power(BSymbol,-1)))),Power(Plus(a,Times(c,Power(x,4))),CN1D2)),Int(Times(Sqrt(Plus(ASymbol,Times(BSymbol,Sqr(x)))),Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(Times(a,Power(ASymbol,-1)),Times(c,Sqr(x),Power(BSymbol,-1))))),-1)),x),x),And(FreeQ(List(a,c,d,e,ASymbol,BSymbol),x),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),EqQ(Plus(Times(c,Sqr(ASymbol)),Times(a,Sqr(BSymbol))),C0)))),
IIntegrate(1704,Int(Times(Plus(A_,Times(B_DEFAULT,Sqr(x_))),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(q,Sqrt(Plus(Sqr(b),Times(CN1,C4,a,c))))),Condition(Plus(Dist(Times(Plus(Times(C2,a,BSymbol),Times(CN1,ASymbol,Plus(b,q))),Power(Plus(Times(C2,a,e),Times(CN1,d,Plus(b,q))),-1)),Int(Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),CN1D2),x),x),Negate(Dist(Times(Plus(Times(BSymbol,d),Times(CN1,ASymbol,e)),Power(Plus(Times(C2,a,e),Times(CN1,d,Plus(b,q))),-1)),Int(Times(Plus(Times(C2,a),Times(Plus(b,q),Sqr(x))),Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))))),-1)),x),x))),RationalQ(q))),And(FreeQ(List(a,b,c,d,e,ASymbol,BSymbol),x),GtQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),NeQ(Plus(Times(c,Sqr(ASymbol)),Times(CN1,b,ASymbol,BSymbol),Times(a,Sqr(BSymbol))),C0)))),
IIntegrate(1705,Int(Times(Plus(A_,Times(B_DEFAULT,Sqr(x_))),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(q,Sqrt(Times(CN1,a,c)))),Condition(Plus(Dist(Times(Plus(Times(a,BSymbol),Times(CN1,ASymbol,q)),Power(Plus(Times(a,e),Times(CN1,d,q)),-1)),Int(Power(Plus(a,Times(c,Power(x,4))),CN1D2),x),x),Negate(Dist(Times(Plus(Times(BSymbol,d),Times(CN1,ASymbol,e)),Power(Plus(Times(a,e),Times(CN1,d,q)),-1)),Int(Times(Plus(a,Times(q,Sqr(x))),Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(a,Times(c,Power(x,4))))),-1)),x),x))),RationalQ(q))),And(FreeQ(List(a,c,d,e,ASymbol,BSymbol),x),GtQ(Times(CN1,a,c),C0),EqQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),NeQ(Plus(Times(c,Sqr(ASymbol)),Times(a,Sqr(BSymbol))),C0)))),
IIntegrate(1706,Int(Times(Plus(A_,Times(B_DEFAULT,Sqr(x_))),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(BSymbol,Power(ASymbol,-1)),C2))),Plus(Negate(Simp(Times(Plus(Times(BSymbol,d),Times(CN1,ASymbol,e)),ArcTan(Times(Rt(Plus(Negate(b),Times(c,d,Power(e,-1)),Times(a,e,Power(d,-1))),C2),x,Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),CN1D2))),Power(Times(C2,d,e,Rt(Plus(Negate(b),Times(c,d,Power(e,-1)),Times(a,e,Power(d,-1))),C2)),-1)),x)),Simp(Times(Plus(Times(BSymbol,d),Times(ASymbol,e)),Plus(ASymbol,Times(BSymbol,Sqr(x))),Sqrt(Times(Sqr(ASymbol),Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),Power(Times(a,Sqr(Plus(ASymbol,Times(BSymbol,Sqr(x))))),-1))),EllipticPi(Cancel(Times(CN1,Sqr(Plus(Times(BSymbol,d),Times(CN1,ASymbol,e))),Power(Times(C4,d,e,ASymbol,BSymbol),-1))),Times(C2,ArcTan(Times(q,x))),Plus(C1D2,Times(CN1,b,ASymbol,Power(Times(C4,a,BSymbol),-1)))),Power(Times(C4,d,e,ASymbol,q,Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))))),-1)),x))),And(FreeQ(List(a,b,c,d,e,ASymbol,BSymbol),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),C0),PosQ(Times(c,Power(a,-1))),EqQ(Plus(Times(c,Sqr(ASymbol)),Times(CN1,a,Sqr(BSymbol))),C0)))),
IIntegrate(1707,Int(Times(Plus(A_,Times(B_DEFAULT,Sqr(x_))),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(BSymbol,Power(ASymbol,-1)),C2))),Plus(Negate(Simp(Times(Plus(Times(BSymbol,d),Times(CN1,ASymbol,e)),ArcTan(Times(Rt(Plus(Times(c,d,Power(e,-1)),Times(a,e,Power(d,-1))),C2),x,Power(Plus(a,Times(c,Power(x,4))),CN1D2))),Power(Times(C2,d,e,Rt(Plus(Times(c,d,Power(e,-1)),Times(a,e,Power(d,-1))),C2)),-1)),x)),Simp(Times(Plus(Times(BSymbol,d),Times(ASymbol,e)),Plus(ASymbol,Times(BSymbol,Sqr(x))),Sqrt(Times(Sqr(ASymbol),Plus(a,Times(c,Power(x,4))),Power(Times(a,Sqr(Plus(ASymbol,Times(BSymbol,Sqr(x))))),-1))),EllipticPi(Cancel(Times(CN1,Sqr(Plus(Times(BSymbol,d),Times(CN1,ASymbol,e))),Power(Times(C4,d,e,ASymbol,BSymbol),-1))),Times(C2,ArcTan(Times(q,x))),C1D2),Power(Times(C4,d,e,ASymbol,q,Sqrt(Plus(a,Times(c,Power(x,4))))),-1)),x))),And(FreeQ(List(a,c,d,e,ASymbol,BSymbol),x),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),C0),PosQ(Times(c,Power(a,-1))),EqQ(Plus(Times(c,Sqr(ASymbol)),Times(CN1,a,Sqr(BSymbol))),C0)))),
IIntegrate(1708,Int(Times(Plus(A_DEFAULT,Times(B_DEFAULT,Sqr(x_))),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(c,Power(a,-1)),C2))),Plus(Dist(Times(Plus(Times(ASymbol,Plus(Times(c,d),Times(a,e,q))),Times(CN1,a,BSymbol,Plus(e,Times(d,q)))),Power(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),-1)),Int(Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),CN1D2),x),x),Dist(Times(a,Plus(Times(BSymbol,d),Times(CN1,ASymbol,e)),Plus(e,Times(d,q)),Power(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),-1)),Int(Times(Plus(C1,Times(q,Sqr(x))),Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,ASymbol,BSymbol),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),C0),PosQ(Times(c,Power(a,-1))),NeQ(Plus(Times(c,Sqr(ASymbol)),Times(CN1,a,Sqr(BSymbol))),C0)))),
IIntegrate(1709,Int(Times(Plus(A_DEFAULT,Times(B_DEFAULT,Sqr(x_))),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(c,Power(a,-1)),C2))),Plus(Dist(Times(Plus(Times(ASymbol,Plus(Times(c,d),Times(a,e,q))),Times(CN1,a,BSymbol,Plus(e,Times(d,q)))),Power(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),-1)),Int(Power(Plus(a,Times(c,Power(x,4))),CN1D2),x),x),Dist(Times(a,Plus(Times(BSymbol,d),Times(CN1,ASymbol,e)),Plus(e,Times(d,q)),Power(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),-1)),Int(Times(Plus(C1,Times(q,Sqr(x))),Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(a,Times(c,Power(x,4))))),-1)),x),x))),And(FreeQ(List(a,c,d,e,ASymbol,BSymbol),x),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),C0),PosQ(Times(c,Power(a,-1))),NeQ(Plus(Times(c,Sqr(ASymbol)),Times(CN1,a,Sqr(BSymbol))),C0)))),
IIntegrate(1710,Int(Times(Plus(A_DEFAULT,Times(B_DEFAULT,Sqr(x_))),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(Plus(Dist(Times(BSymbol,Power(e,-1)),Int(Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),CN1D2),x),x),Dist(Times(Plus(Times(e,ASymbol),Times(CN1,d,BSymbol)),Power(e,-1)),Int(Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))))),-1),x),x)),And(FreeQ(List(a,b,c,d,e,ASymbol,BSymbol),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),C0),NegQ(Times(c,Power(a,-1)))))),
IIntegrate(1711,Int(Times(Plus(A_DEFAULT,Times(B_DEFAULT,Sqr(x_))),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(Plus(Dist(Times(BSymbol,Power(e,-1)),Int(Power(Plus(a,Times(c,Power(x,4))),CN1D2),x),x),Dist(Times(Plus(Times(e,ASymbol),Times(CN1,d,BSymbol)),Power(e,-1)),Int(Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(a,Times(c,Power(x,4))))),-1),x),x)),And(FreeQ(List(a,c,d,e,ASymbol,BSymbol),x),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),C0),NegQ(Times(c,Power(a,-1)))))),
IIntegrate(1712,Int(Times($p("§p4x"),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§p4x"),x,C0)),Set(BSymbol,Coeff($s("§p4x"),x,C2)),Set(CSymbol,Coeff($s("§p4x"),x,C4))),Plus(Negate(Dist(Times(CSymbol,Power(e,-2)),Int(Times(Plus(d,Times(CN1,e,Sqr(x))),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),CN1D2)),x),x)),Dist(Power(e,-2),Int(Times(Plus(Times(CSymbol,Sqr(d)),Times(ASymbol,Sqr(e)),Times(BSymbol,Sqr(e),Sqr(x))),Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e),x),PolyQ($s("§p4x"),Sqr(x),C2),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),EqQ(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),C0)))),
IIntegrate(1713,Int(Times($p("§p4x"),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§p4x"),x,C0)),Set(BSymbol,Coeff($s("§p4x"),x,C2)),Set(CSymbol,Coeff($s("§p4x"),x,C4))),Plus(Negate(Dist(Times(CSymbol,Power(e,-2)),Int(Times(Plus(d,Times(CN1,e,Sqr(x))),Power(Plus(a,Times(c,Power(x,4))),CN1D2)),x),x)),Dist(Power(e,-2),Int(Times(Plus(Times(CSymbol,Sqr(d)),Times(ASymbol,Sqr(e)),Times(BSymbol,Sqr(e),Sqr(x))),Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(a,Times(c,Power(x,4))))),-1)),x),x))),And(FreeQ(List(a,c,d,e),x),PolyQ($s("§p4x"),Sqr(x),C2),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),EqQ(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),C0)))),
IIntegrate(1714,Int(Times($p("§p4x"),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(c,Power(a,-1)),C2)),Set(ASymbol,Coeff($s("§p4x"),x,C0)),Set(BSymbol,Coeff($s("§p4x"),x,C2)),Set(CSymbol,Coeff($s("§p4x"),x,C4))),Plus(Negate(Dist(Times(CSymbol,Power(Times(e,q),-1)),Int(Times(Plus(C1,Times(CN1,q,Sqr(x))),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),CN1D2)),x),x)),Dist(Power(Times(c,e),-1),Int(Times(Plus(Times(ASymbol,c,e),Times(a,CSymbol,d,q),Times(Plus(Times(BSymbol,c,e),Times(CN1,CSymbol,Plus(Times(c,d),Times(CN1,a,e,q)))),Sqr(x))),Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e),x),PolyQ($s("§p4x"),Sqr(x),C2),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),C0),PosQ(Times(c,Power(a,-1))),Not(GtQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0))))),
IIntegrate(1715,Int(Times($p("§p4x"),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(c,Power(a,-1)),C2)),Set(ASymbol,Coeff($s("§p4x"),x,C0)),Set(BSymbol,Coeff($s("§p4x"),x,C2)),Set(CSymbol,Coeff($s("§p4x"),x,C4))),Plus(Negate(Dist(Times(CSymbol,Power(Times(e,q),-1)),Int(Times(Plus(C1,Times(CN1,q,Sqr(x))),Power(Plus(a,Times(c,Power(x,4))),CN1D2)),x),x)),Dist(Power(Times(c,e),-1),Int(Times(Plus(Times(ASymbol,c,e),Times(a,CSymbol,d,q),Times(Plus(Times(BSymbol,c,e),Times(CN1,CSymbol,Plus(Times(c,d),Times(CN1,a,e,q)))),Sqr(x))),Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(a,Times(c,Power(x,4))))),-1)),x),x))),And(FreeQ(List(a,c,d,e),x),PolyQ($s("§p4x"),Sqr(x),C2),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),C0),PosQ(Times(c,Power(a,-1)))))),
IIntegrate(1716,Int(Times($p("§p4x"),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§p4x"),x,C0)),Set(BSymbol,Coeff($s("§p4x"),x,C2)),Set(CSymbol,Coeff($s("§p4x"),x,C4))),Plus(Negate(Dist(Power(e,-2),Int(Times(Plus(Times(CSymbol,d),Times(CN1,BSymbol,e),Times(CN1,CSymbol,e,Sqr(x))),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),CN1D2)),x),x)),Dist(Times(Plus(Times(CSymbol,Sqr(d)),Times(CN1,BSymbol,d,e),Times(ASymbol,Sqr(e))),Power(e,-2)),Int(Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))))),-1),x),x))),And(FreeQ(List(a,b,c,d,e),x),PolyQ($s("§p4x"),Sqr(x),C2),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),C0)))),
IIntegrate(1717,Int(Times($p("§p4x"),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§p4x"),x,C0)),Set(BSymbol,Coeff($s("§p4x"),x,C2)),Set(CSymbol,Coeff($s("§p4x"),x,C4))),Plus(Negate(Dist(Power(e,-2),Int(Times(Plus(Times(CSymbol,d),Times(CN1,BSymbol,e),Times(CN1,CSymbol,e,Sqr(x))),Power(Plus(a,Times(c,Power(x,4))),CN1D2)),x),x)),Dist(Times(Plus(Times(CSymbol,Sqr(d)),Times(CN1,BSymbol,d,e),Times(ASymbol,Sqr(e))),Power(e,-2)),Int(Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(a,Times(c,Power(x,4))))),-1),x),x))),And(FreeQ(List(a,c,d,e),x),PolyQ($s("§p4x"),Sqr(x),C2),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),C0)))),
IIntegrate(1718,Int(Times($p("§px"),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(q,Expon($s("§px"),x))),Condition(Plus(Simp(Times(Coeff($s("§px"),x,q),Power(x,Plus(q,Negate(C5))),Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4)))),Power(Times(c,e,Plus(q,Negate(C3))),-1)),x),Dist(Power(Times(c,e,Plus(q,Negate(C3))),-1),Int(Times(Plus(Times(c,e,Plus(q,Negate(C3)),$s("§px")),Times(CN1,Coeff($s("§px"),x,q),Power(x,Plus(q,Negate(C6))),Plus(d,Times(e,Sqr(x))),Plus(Times(a,Plus(q,Negate(C5))),Times(b,Plus(q,Negate(C4)),Sqr(x)),Times(c,Plus(q,Negate(C3)),Power(x,4))))),Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))))),-1)),x),x)),GtQ(q,C4))),And(FreeQ(List(a,b,c,d,e),x),PolyQ($s("§px"),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0)))),
IIntegrate(1719,Int(Times($p("§px"),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),-1),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(q,Expon($s("§px"),x))),Condition(Plus(Simp(Times(Coeff($s("§px"),x,q),Power(x,Plus(q,Negate(C5))),Sqrt(Plus(a,Times(c,Power(x,4)))),Power(Times(c,e,Plus(q,Negate(C3))),-1)),x),Dist(Power(Times(c,e,Plus(q,Negate(C3))),-1),Int(Times(Plus(Times(c,e,Plus(q,Negate(C3)),$s("§px")),Times(CN1,Coeff($s("§px"),x,q),Power(x,Plus(q,Negate(C6))),Plus(d,Times(e,Sqr(x))),Plus(Times(a,Plus(q,Negate(C5))),Times(c,Plus(q,Negate(C3)),Power(x,4))))),Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(a,Times(c,Power(x,4))))),-1)),x),x)),GtQ(q,C4))),And(FreeQ(List(a,c,d,e),x),PolyQ($s("§px"),x),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0)))),
IIntegrate(1720,Int(Times($p("§px"),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_)),x_Symbol),
    Condition(Int(ExpandIntegrand(Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),CN1D2),Times($s("§px"),Power(Plus(d,Times(e,Sqr(x))),q),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),Plus(p,C1D2))),x),x),And(FreeQ(List(a,b,c,d,e),x),PolyQ($s("§px"),Sqr(x)),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),IntegerQ(Plus(p,C1D2)),IntegerQ(q)))),
IIntegrate(1721,Int(Times($p("§px"),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),p_)),x_Symbol),
    Condition(Int(ExpandIntegrand(Power(Plus(a,Times(c,Power(x,4))),CN1D2),Times($s("§px"),Power(Plus(d,Times(e,Sqr(x))),q),Power(Plus(a,Times(c,Power(x,4))),Plus(p,C1D2))),x),x),And(FreeQ(List(a,c,d,e),x),PolyQ($s("§px"),Sqr(x)),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),IntegerQ(Plus(p,C1D2)),IntegerQ(q)))),
IIntegrate(1722,Int(Times($p("§px"),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_DEFAULT)),x_Symbol),
    Condition(Unintegrable(Times($s("§px"),Power(Plus(d,Times(e,Sqr(x))),q),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),p)),x),And(FreeQ(List(a,b,c,d,e,p,q),x),PolyQ($s("§px"),x)))),
IIntegrate(1723,Int(Times($p("§px"),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),p_DEFAULT)),x_Symbol),
    Condition(Unintegrable(Times($s("§px"),Power(Plus(d,Times(e,Sqr(x))),q),Power(Plus(a,Times(c,Power(x,4))),p)),x),And(FreeQ(List(a,c,d,e,p,q),x),PolyQ($s("§px"),x)))),
IIntegrate(1724,Int(Times(Power(Plus(d_,Times(e_DEFAULT,x_)),-1),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(Plus(Dist(d,Int(Power(Times(Plus(Sqr(d),Times(CN1,Sqr(e),Sqr(x))),Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))))),-1),x),x),Negate(Dist(e,Int(Times(x,Power(Times(Plus(Sqr(d),Times(CN1,Sqr(e),Sqr(x))),Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))))),-1)),x),x))),FreeQ(List(a,b,c,d,e),x))),
IIntegrate(1725,Int(Times(Power(Plus(d_,Times(e_DEFAULT,x_)),-1),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(Plus(Dist(d,Int(Power(Times(Plus(Sqr(d),Times(CN1,Sqr(e),Sqr(x))),Sqrt(Plus(a,Times(c,Power(x,4))))),-1),x),x),Negate(Dist(e,Int(Times(x,Power(Times(Plus(Sqr(d),Times(CN1,Sqr(e),Sqr(x))),Sqrt(Plus(a,Times(c,Power(x,4))))),-1)),x),x))),FreeQ(List(a,c,d,e),x))),
IIntegrate(1726,Int(Times(Power(Plus(d_,Times(e_DEFAULT,x_)),q_),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(Plus(Simp(Times(Power(e,3),Power(Plus(d,Times(e,x)),Plus(q,C1)),Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4)))),Power(Times(Plus(q,C1),Plus(Times(c,Power(d,4)),Times(b,Sqr(d),Sqr(e)),Times(a,Power(e,4)))),-1)),x),Dist(Power(Times(Plus(q,C1),Plus(Times(c,Power(d,4)),Times(b,Sqr(d),Sqr(e)),Times(a,Power(e,4)))),-1),Int(Times(Power(Plus(d,Times(e,x)),Plus(q,C1)),Simp(Plus(Times(d,Plus(q,C1),Plus(Times(c,Sqr(d)),Times(b,Sqr(e)))),Times(CN1,e,Plus(Times(c,Sqr(d),Plus(q,C1)),Times(b,Sqr(e),Plus(q,C2))),x),Times(c,d,Sqr(e),Plus(q,C1),Sqr(x)),Times(CN1,c,Power(e,3),Plus(q,C3),Power(x,3))),x),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),CN1D2)),x),x)),And(FreeQ(List(a,b,c,d,e),x),NeQ(Plus(Times(c,Power(d,4)),Times(b,Sqr(d),Sqr(e)),Times(a,Power(e,4))),C0),ILtQ(q,CN1)))),
IIntegrate(1727,Int(Times(Power(Plus(d_,Times(e_DEFAULT,x_)),q_),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(Plus(Simp(Times(Power(e,3),Power(Plus(d,Times(e,x)),Plus(q,C1)),Sqrt(Plus(a,Times(c,Power(x,4)))),Power(Times(Plus(q,C1),Plus(Times(c,Power(d,4)),Times(a,Power(e,4)))),-1)),x),Dist(Times(c,Power(Times(Plus(q,C1),Plus(Times(c,Power(d,4)),Times(a,Power(e,4)))),-1)),Int(Times(Power(Plus(d,Times(e,x)),Plus(q,C1)),Simp(Plus(Times(Power(d,3),Plus(q,C1)),Times(CN1,Sqr(d),e,Plus(q,C1),x),Times(d,Sqr(e),Plus(q,C1),Sqr(x)),Times(CN1,Power(e,3),Plus(q,C3),Power(x,3))),x),Power(Plus(a,Times(c,Power(x,4))),CN1D2)),x),x)),And(FreeQ(List(a,c,d,e),x),NeQ(Plus(Times(c,Power(d,4)),Times(a,Power(e,4))),C0),ILtQ(q,CN1)))),
IIntegrate(1728,Int(Times(Power(Plus(d_,Times(e_DEFAULT,x_)),-1),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Dist(d,Int(Times(Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),p),Power(Plus(Sqr(d),Times(CN1,Sqr(e),Sqr(x))),-1)),x),x),Negate(Dist(e,Int(Times(x,Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),p),Power(Plus(Sqr(d),Times(CN1,Sqr(e),Sqr(x))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e),x),IntegerQ(Plus(p,C1D2))))),
IIntegrate(1729,Int(Times(Power(Plus(d_,Times(e_DEFAULT,x_)),-1),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Dist(d,Int(Times(Power(Plus(a,Times(c,Power(x,4))),p),Power(Plus(Sqr(d),Times(CN1,Sqr(e),Sqr(x))),-1)),x),x),Negate(Dist(e,Int(Times(x,Power(Plus(a,Times(c,Power(x,4))),p),Power(Plus(Sqr(d),Times(CN1,Sqr(e),Sqr(x))),-1)),x),x))),And(FreeQ(List(a,c,d,e),x),IntegerQ(Plus(p,C1D2))))),
IIntegrate(1730,Int(Times($p("§px"),Power(Plus(d_,Times(e_DEFAULT,x_)),q_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_DEFAULT)),x_Symbol),
    Condition(Int(Times(PolynomialQuotient($s("§px"),Plus(d,Times(e,x)),x),Power(Plus(d,Times(e,x)),Plus(q,C1)),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),p)),x),And(FreeQ(List(a,b,c,d,e,p,q),x),PolyQ($s("§px"),x),EqQ(PolynomialRemainder($s("§px"),Plus(d,Times(e,x)),x),C0)))),
IIntegrate(1731,Int(Times($p("§px"),Power(Plus(d_,Times(e_DEFAULT,x_)),q_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),p_DEFAULT)),x_Symbol),
    Condition(Int(Times(PolynomialQuotient($s("§px"),Plus(d,Times(e,x)),x),Power(Plus(d,Times(e,x)),Plus(q,C1)),Power(Plus(a,Times(c,Power(x,4))),p)),x),And(FreeQ(List(a,c,d,e,p,q),x),PolyQ($s("§px"),x),EqQ(PolynomialRemainder($s("§px"),Plus(d,Times(e,x)),x),C0)))),
IIntegrate(1732,Int(Times($p("§px"),Power(Plus(d_,Times(e_DEFAULT,x_)),q_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_DEFAULT)),x_Symbol),
    Condition(Int(Times(PolynomialQuotient($s("§px"),Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),x),Power(Plus(d,Times(e,x)),q),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),Plus(p,C1))),x),And(FreeQ(List(a,b,c,d,e,p,q),x),PolyQ($s("§px"),x),EqQ(PolynomialRemainder($s("§px"),Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),x),C0)))),
IIntegrate(1733,Int(Times($p("§px"),Power(Plus(d_,Times(e_DEFAULT,x_)),q_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),p_DEFAULT)),x_Symbol),
    Condition(Int(Times(PolynomialQuotient($s("§px"),Plus(a,Times(c,Power(x,4))),x),Power(Plus(d,Times(e,x)),q),Power(Plus(a,Times(c,Power(x,4))),Plus(p,C1))),x),And(FreeQ(List(a,c,d,e,p,q),x),PolyQ($s("§px"),x),EqQ(PolynomialRemainder($s("§px"),Plus(a,Times(c,Power(x,4))),x),C0)))),
IIntegrate(1734,Int(Times($p("§px"),Power(Plus(d_,Times(e_DEFAULT,x_)),q_),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§px"),x,C0)),Set(BSymbol,Coeff($s("§px"),x,C1)),Set(CSymbol,Coeff($s("§px"),x,C2)),Set($s("D"),Coeff($s("§px"),x,C3))),Int(Times(Power(Plus(d,Times(e,x)),Plus(q,Negate(C1))),Plus(Times(ASymbol,d),Times(Plus(Times(BSymbol,d),Times(ASymbol,e)),x),Times(Plus(Times(CSymbol,d),Times(BSymbol,e)),Sqr(x)),Times(CSymbol,e,Power(x,3))),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),CN1D2)),x)),And(FreeQ(List(a,b,c,d,e),x),PolyQ($s("§px"),x),LeQ(Expon($s("§px"),x),C2),NeQ(Plus(Times(c,Power(d,4)),Times(b,Sqr(d),Sqr(e)),Times(a,Power(e,4))),C0),GtQ(q,C0)))),
IIntegrate(1735,Int(Times($p("§px"),Power(Plus(d_,Times(e_DEFAULT,x_)),q_),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§px"),x,C0)),Set(BSymbol,Coeff($s("§px"),x,C1)),Set(CSymbol,Coeff($s("§px"),x,C2)),Set($s("D"),Coeff($s("§px"),x,C3))),Int(Times(Power(Plus(d,Times(e,x)),Plus(q,Negate(C1))),Plus(Times(ASymbol,d),Times(Plus(Times(BSymbol,d),Times(ASymbol,e)),x),Times(Plus(Times(CSymbol,d),Times(BSymbol,e)),Sqr(x)),Times(CSymbol,e,Power(x,3))),Power(Plus(a,Times(c,Power(x,4))),CN1D2)),x)),And(FreeQ(List(a,c,d,e),x),PolyQ($s("§px"),x),LeQ(Expon($s("§px"),x),C2),NeQ(Plus(Times(c,Power(d,4)),Times(a,Power(e,4))),C0),GtQ(q,C0)))),
IIntegrate(1736,Int(Times($p("§px"),Power(Plus(d_,Times(e_DEFAULT,x_)),q_),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§px"),x,C0)),Set(BSymbol,Coeff($s("§px"),x,C1)),Set(CSymbol,Coeff($s("§px"),x,C2)),Set($s("D"),Coeff($s("§px"),x,C3))),Plus(Simp(Times($s("D"),Power(Plus(d,Times(e,x)),q),Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4)))),Power(Times(c,Plus(q,C2)),-1)),x),Negate(Dist(Power(Times(c,Plus(q,C2)),-1),Int(Times(Power(Plus(d,Times(e,x)),Plus(q,Negate(C1))),Simp(Plus(Times(a,$s("D"),e,q),Times(CN1,ASymbol,c,d,Plus(q,C2)),Times(Plus(Times(b,d,$s("D")),Times(CN1,BSymbol,c,d,Plus(q,C2)),Times(CN1,ASymbol,c,e,Plus(q,C2))),x),Times(Plus(Times(b,$s("D"),e,Plus(q,C1)),Times(CN1,c,Plus(Times(CSymbol,d),Times(BSymbol,e)),Plus(q,C2))),Sqr(x)),Times(CN1,c,Plus(Times(d,$s("D"),q),Times(CSymbol,e,Plus(q,C2))),Power(x,3))),x),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),CN1D2)),x),x)))),And(FreeQ(List(a,b,c,d,e),x),PolyQ($s("§px"),x,C3),NeQ(Plus(Times(c,Power(d,4)),Times(b,Sqr(d),Sqr(e)),Times(a,Power(e,4))),C0),GtQ(q,C0)))),
IIntegrate(1737,Int(Times($p("§px"),Power(Plus(d_,Times(e_DEFAULT,x_)),q_),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§px"),x,C0)),Set(BSymbol,Coeff($s("§px"),x,C1)),Set(CSymbol,Coeff($s("§px"),x,C2)),Set($s("D"),Coeff($s("§px"),x,C3))),Plus(Simp(Times($s("D"),Power(Plus(d,Times(e,x)),q),Sqrt(Plus(a,Times(c,Power(x,4)))),Power(Times(c,Plus(q,C2)),-1)),x),Negate(Dist(Power(Times(c,Plus(q,C2)),-1),Int(Times(Power(Plus(d,Times(e,x)),Plus(q,Negate(C1))),Simp(Plus(Times(a,$s("D"),e,q),Times(CN1,ASymbol,c,d,Plus(q,C2)),Times(CN1,c,Plus(Times(BSymbol,d,Plus(q,C2)),Times(ASymbol,e,Plus(q,C2))),x),Times(CN1,c,Plus(Times(CSymbol,d),Times(BSymbol,e)),Plus(q,C2),Sqr(x)),Times(CN1,c,Plus(Times(d,$s("D"),q),Times(CSymbol,e,Plus(q,C2))),Power(x,3))),x),Power(Plus(a,Times(c,Power(x,4))),CN1D2)),x),x)))),And(FreeQ(List(a,c,d,e),x),PolyQ($s("§px"),x,C3),NeQ(Plus(Times(c,Power(d,4)),Times(a,Power(e,4))),C0),GtQ(q,C0)))),
IIntegrate(1738,Int(Times($p("§px"),Power(Plus(d_,Times(e_DEFAULT,x_)),q_),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§px"),x,C0)),Set(BSymbol,Coeff($s("§px"),x,C1)),Set(CSymbol,Coeff($s("§px"),x,C2)),Set($s("D"),Coeff($s("§px"),x,C3))),Plus(Negate(Simp(Times(Plus(Times(Power(d,3),$s("D")),Times(CN1,CSymbol,Sqr(d),e),Times(BSymbol,d,Sqr(e)),Times(CN1,ASymbol,Power(e,3))),Power(Plus(d,Times(e,x)),Plus(q,C1)),Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4)))),Power(Times(Plus(q,C1),Plus(Times(c,Power(d,4)),Times(b,Sqr(d),Sqr(e)),Times(a,Power(e,4)))),-1)),x)),Dist(Power(Times(Plus(q,C1),Plus(Times(c,Power(d,4)),Times(b,Sqr(d),Sqr(e)),Times(a,Power(e,4)))),-1),Int(Times(Power(Plus(d,Times(e,x)),Plus(q,C1)),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),CN1D2),Simp(Plus(Times(Plus(q,C1),Plus(Times(a,e,Plus(Times(Sqr(d),$s("D")),Times(CN1,CSymbol,d,e),Times(BSymbol,Sqr(e)))),Times(ASymbol,d,Plus(Times(c,Sqr(d)),Times(b,Sqr(e)))))),Times(CN1,Plus(Times(e,Plus(q,C1),Plus(Times(ASymbol,c,Sqr(d)),Times(a,e,Plus(Times(d,$s("D")),Times(CN1,CSymbol,e))))),Times(CN1,BSymbol,d,Plus(Times(c,Sqr(d),Plus(q,C1)),Times(b,Sqr(e),Plus(q,C2)))),Times(CN1,b,Plus(Times(Power(d,3),$s("D")),Times(CN1,CSymbol,Sqr(d),e),Times(CN1,ASymbol,Power(e,3),Plus(q,C2))))),x),Times(Plus(q,C1),Plus(Times($s("D"),e,Plus(Times(b,Sqr(d)),Times(a,Sqr(e)))),Times(c,d,Plus(Times(CSymbol,Sqr(d)),Times(CN1,e,Plus(Times(BSymbol,d),Times(CN1,ASymbol,e)))))),Sqr(x)),Times(c,Plus(q,C3),Plus(Times(Power(d,3),$s("D")),Times(CN1,CSymbol,Sqr(d),e),Times(BSymbol,d,Sqr(e)),Times(CN1,ASymbol,Power(e,3))),Power(x,3))),x)),x),x))),And(FreeQ(List(a,b,c,d,e),x),PolyQ($s("§px"),x),LeQ(Expon($s("§px"),x),C3),NeQ(Plus(Times(c,Power(d,4)),Times(b,Sqr(d),Sqr(e)),Times(a,Power(e,4))),C0),LtQ(q,CN1)))),
IIntegrate(1739,Int(Times($p("§px"),Power(Plus(d_,Times(e_DEFAULT,x_)),q_),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§px"),x,C0)),Set(BSymbol,Coeff($s("§px"),x,C1)),Set(CSymbol,Coeff($s("§px"),x,C2)),Set($s("D"),Coeff($s("§px"),x,C3))),Plus(Negate(Simp(Times(Plus(Times(Power(d,3),$s("D")),Times(CN1,CSymbol,Sqr(d),e),Times(BSymbol,d,Sqr(e)),Times(CN1,ASymbol,Power(e,3))),Power(Plus(d,Times(e,x)),Plus(q,C1)),Sqrt(Plus(a,Times(c,Power(x,4)))),Power(Times(Plus(q,C1),Plus(Times(c,Power(d,4)),Times(a,Power(e,4)))),-1)),x)),Dist(Power(Times(Plus(q,C1),Plus(Times(c,Power(d,4)),Times(a,Power(e,4)))),-1),Int(Times(Power(Plus(d,Times(e,x)),Plus(q,C1)),Power(Plus(a,Times(c,Power(x,4))),CN1D2),Simp(Plus(Times(Plus(q,C1),Plus(Times(a,e,Plus(Times(Sqr(d),$s("D")),Times(CN1,CSymbol,d,e),Times(BSymbol,Sqr(e)))),Times(ASymbol,d,c,Sqr(d)))),Times(CN1,Plus(Times(e,Plus(q,C1),Plus(Times(ASymbol,c,Sqr(d)),Times(a,e,Plus(Times(d,$s("D")),Times(CN1,CSymbol,e))))),Times(CN1,BSymbol,d,c,Sqr(d),Plus(q,C1))),x),Times(Plus(q,C1),Plus(Times($s("D"),e,a,Sqr(e)),Times(c,d,Plus(Times(CSymbol,Sqr(d)),Times(CN1,e,Plus(Times(BSymbol,d),Times(CN1,ASymbol,e)))))),Sqr(x)),Times(c,Plus(q,C3),Plus(Times(Power(d,3),$s("D")),Times(CN1,CSymbol,Sqr(d),e),Times(BSymbol,d,Sqr(e)),Times(CN1,ASymbol,Power(e,3))),Power(x,3))),x)),x),x))),And(FreeQ(List(a,c,d,e),x),PolyQ($s("§px"),x),LeQ(Expon($s("§px"),x),C3),NeQ(Plus(Times(c,Power(d,4)),Times(a,Power(e,4))),C0),LtQ(q,CN1)))),
IIntegrate(1740,Int(Times(Plus(A_,Times(B_DEFAULT,x_)),Power(Plus(d_,Times(e_DEFAULT,x_)),-1),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(Negate(Dist(Times(Sqr(ASymbol),Plus(Times(BSymbol,d),Times(ASymbol,e)),Power(e,-1)),Subst(Int(Power(Plus(Times(C6,Power(ASymbol,3),BSymbol,d),Times(C3,Power(ASymbol,4),e),Times(CN1,a,e,Sqr(x))),-1),x),x,Times(Sqr(Plus(ASymbol,Times(BSymbol,x))),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),CN1D2))),x)),And(FreeQ(List(a,b,c,d,e,ASymbol,BSymbol),x),NeQ(Plus(Times(BSymbol,d),Times(CN1,ASymbol,e)),C0),EqQ(Plus(Times(Sqr(c),Power(d,6)),Times(a,Power(e,4),Plus(Times(ZZ(13L),c,Sqr(d)),Times(b,Sqr(e))))),C0),EqQ(Plus(Times(Sqr(b),Power(e,4)),Times(CN1,ZZ(12L),c,Sqr(d),Plus(Times(c,Sqr(d)),Times(CN1,b,Sqr(e))))),C0),EqQ(Plus(Times(C4,ASymbol,c,d,e),Times(BSymbol,Plus(Times(C2,c,Sqr(d)),Times(CN1,b,Sqr(e))))),C0)))),
IIntegrate(1741,Int(Times($p("§px"),Power(Plus(d_,Times(e_DEFAULT,x_)),-1),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§px"),x,C0)),Set(BSymbol,Coeff($s("§px"),x,C1)),Set(CSymbol,Coeff($s("§px"),x,C2)),Set($s("D"),Coeff($s("§px"),x,C3))),Plus(Int(Times(x,Plus(Times(BSymbol,d),Times(CN1,ASymbol,e),Times(Plus(Times(d,$s("D")),Times(CN1,CSymbol,e)),Sqr(x))),Power(Times(Plus(Sqr(d),Times(CN1,Sqr(e),Sqr(x))),Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))))),-1)),x),Int(Times(Plus(Times(ASymbol,d),Times(Plus(Times(CSymbol,d),Times(CN1,BSymbol,e)),Sqr(x)),Times(CN1,$s("D"),e,Power(x,4))),Power(Times(Plus(Sqr(d),Times(CN1,Sqr(e),Sqr(x))),Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))))),-1)),x))),And(FreeQ(List(a,b,c,d,e),x),PolyQ($s("§px"),x),LeQ(Expon($s("§px"),x),C3),NeQ(Plus(Times(c,Power(d,4)),Times(b,Sqr(d),Sqr(e)),Times(a,Power(e,4))),C0)))),
IIntegrate(1742,Int(Times($p("§px"),Power(Plus(d_,Times(e_DEFAULT,x_)),-1),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§px"),x,C0)),Set(BSymbol,Coeff($s("§px"),x,C1)),Set(CSymbol,Coeff($s("§px"),x,C2)),Set($s("D"),Coeff($s("§px"),x,C3))),Plus(Int(Times(x,Plus(Times(BSymbol,d),Times(CN1,ASymbol,e),Times(Plus(Times(d,$s("D")),Times(CN1,CSymbol,e)),Sqr(x))),Power(Times(Plus(Sqr(d),Times(CN1,Sqr(e),Sqr(x))),Sqrt(Plus(a,Times(c,Power(x,4))))),-1)),x),Int(Times(Plus(Times(ASymbol,d),Times(Plus(Times(CSymbol,d),Times(CN1,BSymbol,e)),Sqr(x)),Times(CN1,$s("D"),e,Power(x,4))),Power(Times(Plus(Sqr(d),Times(CN1,Sqr(e),Sqr(x))),Sqrt(Plus(a,Times(c,Power(x,4))))),-1)),x))),And(FreeQ(List(a,c,d,e),x),PolyQ($s("§px"),x),LeQ(Expon($s("§px"),x),C3),NeQ(Plus(Times(c,Power(d,4)),Times(a,Power(e,4))),C0)))),
IIntegrate(1743,Int(Times($p("§px"),Power(Plus(d_,Times(e_DEFAULT,x_)),-1),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Dist(d,Int(Times($s("§px"),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),p),Power(Plus(Sqr(d),Times(CN1,Sqr(e),Sqr(x))),-1)),x),x),Negate(Dist(e,Int(Times(x,$s("§px"),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),p),Power(Plus(Sqr(d),Times(CN1,Sqr(e),Sqr(x))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e),x),PolyQ($s("§px"),x),IntegerQ(Plus(p,C1D2))))),
IIntegrate(1744,Int(Times($p("§px"),Power(Plus(d_,Times(e_DEFAULT,x_)),-1),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Dist(d,Int(Times($s("§px"),Power(Plus(a,Times(c,Power(x,4))),p),Power(Plus(Sqr(d),Times(CN1,Sqr(e),Sqr(x))),-1)),x),x),Negate(Dist(e,Int(Times(x,$s("§px"),Power(Plus(a,Times(c,Power(x,4))),p),Power(Plus(Sqr(d),Times(CN1,Sqr(e),Sqr(x))),-1)),x),x))),And(FreeQ(List(a,c,d,e),x),PolyQ($s("§px"),x),IntegerQ(Plus(p,C1D2))))),
IIntegrate(1745,Int(Times($p("§pq"),Power(x_,m_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2",true))),Times(b_DEFAULT,Power(x_,n_))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Power(n,-1),Subst(Int(Times(SubstFor(Power(x,n),$s("§pq"),x),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),p)),x),x,Power(x,n)),x),And(FreeQ(List(a,b,c,m,n,p),x),EqQ($s("n2"),Times(C2,n)),PolyQ($s("§pq"),Power(x,n)),EqQ(Simplify(Plus(m,Negate(n),C1)),C0)))),
IIntegrate(1746,Int(Times($p("§pq"),Power(Times(d_DEFAULT,x_),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_DEFAULT)),Times(c_DEFAULT,Power(x_,$p("n2",true)))),p_DEFAULT)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times(Power(Times(d,x),m),$s("§pq"),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),p)),x),x),And(FreeQ(List(a,b,c,d,m,n),x),EqQ($s("n2"),Times(C2,n)),PolyQ($s("§pq"),x),IGtQ(p,C0)))),
IIntegrate(1747,Int(Times(Power(Times(g_DEFAULT,x_),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_DEFAULT)),Times(c_DEFAULT,Power(x_,$p("n2",true)))),p_DEFAULT),Plus(d_,Times(e_DEFAULT,Power(x_,n_DEFAULT)),Times(f_DEFAULT,Power(x_,$p("n2",true))))),x_Symbol),
    Condition(Simp(Times(d,Power(Times(g,x),Plus(m,C1)),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),Plus(p,C1)),Power(Times(a,g,Plus(m,C1)),-1)),x),And(FreeQ(List(a,b,c,d,e,f,g,m,n,p),x),EqQ($s("n2"),Times(C2,n)),EqQ(Plus(Times(a,e,Plus(m,C1)),Times(CN1,b,d,Plus(m,Times(n,Plus(p,C1)),C1))),C0),EqQ(Plus(Times(a,f,Plus(m,C1)),Times(CN1,c,d,Plus(m,Times(C2,n,Plus(p,C1)),C1))),C0),NeQ(m,CN1)))),
IIntegrate(1748,Int(Times(Power(Times(g_DEFAULT,x_),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_DEFAULT)),Times(c_DEFAULT,Power(x_,$p("n2",true)))),p_DEFAULT),Plus(d_,Times(f_DEFAULT,Power(x_,$p("n2",true))))),x_Symbol),
    Condition(Simp(Times(d,Power(Times(g,x),Plus(m,C1)),Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),Plus(p,C1)),Power(Times(a,g,Plus(m,C1)),-1)),x),And(FreeQ(List(a,b,c,d,f,g,m,n,p),x),EqQ($s("n2"),Times(C2,n)),EqQ(Plus(m,Times(n,Plus(p,C1)),C1),C0),EqQ(Plus(Times(c,d),Times(a,f)),C0),NeQ(m,CN1)))),
IIntegrate(1749,Int(Times($p("§pq"),Power(Times(d_DEFAULT,x_),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_DEFAULT)),Times(c_DEFAULT,Power(x_,$p("n2",true)))),p_)),x_Symbol),
    Condition(Dist(Times(Power(Plus(a,Times(b,Power(x,n)),Times(c,Power(x,Times(C2,n)))),FracPart(p)),Power(Times(Power(Times(C4,c),IntPart(p)),Power(Plus(b,Times(C2,c,Power(x,n))),Times(C2,FracPart(p)))),-1)),Int(Times(Power(Times(d,x),m),$s("§pq"),Power(Plus(b,Times(C2,c,Power(x,n))),Times(C2,p))),x),x),And(FreeQ(List(a,b,c,d,m,n,p),x),EqQ($s("n2"),Times(C2,n)),PolyQ($s("§pq"),x),EqQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),Not(IntegerQ(Times(C2,p)))))),
IIntegrate(1750,Int(Times($p("§pq"),Power(x_,m_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(x_,$p("n2",true))),Times(b_DEFAULT,Power(x_,n_))),p_)),x_Symbol),
    Condition(Dist(Power(n,-1),Subst(Int(Times(Power(x,Plus(Simplify(Times(Plus(m,C1),Power(n,-1))),Negate(C1))),SubstFor(Power(x,n),$s("§pq"),x),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),p)),x),x,Power(x,n)),x),And(FreeQ(List(a,b,c,m,n,p),x),EqQ($s("n2"),Times(C2,n)),PolyQ($s("§pq"),Power(x,n)),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),IntegerQ(Simplify(Times(Plus(m,C1),Power(n,-1)))))))
  );
}
