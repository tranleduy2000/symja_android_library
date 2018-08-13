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
public class IntRules37 { 
  public static IAST RULES = List( 
ISetDelayed(Int(Times($p("§pq"),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_DEFAULT))),p_)),x_Symbol),
    Condition(Int(Times(x,PolynomialQuotient($s("§pq"),x,x),Power(Plus(a,Times(b,Power(x,n))),p)),x),And(FreeQ(List(a,b,n,p),x),PolyQ($s("§pq"),x),EqQ(Coeff($s("§pq"),x,C0),C0),Not(MatchQ($s("§pq"),Condition(Times(Power(x,m_DEFAULT),u_DEFAULT),IntegerQ(m))))))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_DEFAULT))),p_DEFAULT)),x_Symbol),
    Condition(Int(Times(PolynomialQuotient($s("§pq"),Plus(a,Times(b,Power(x,n))),x),Power(Plus(a,Times(b,Power(x,n))),Plus(p,C1))),x),And(FreeQ(List(a,b,p),x),PolyQ($s("§pq"),x),IGtQ(n,C0),GeQ(Expon($s("§pq"),x),n),EqQ(PolynomialRemainder($s("§pq"),Plus(a,Times(b,Power(x,n))),x),C0)))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_DEFAULT))),p_)),x_Symbol),
    Condition(Module(List(Set(q,Expon($s("§pq"),x)),i),Plus(Simp(Times(Power(Plus(a,Times(b,Power(x,n))),p),Sum(Times(Coeff($s("§pq"),x,i),Power(x,Plus(i,C1)),Power(Plus(Times(n,p),i,C1),-1)),List(i,C0,q))),x),Dist(Times(a,n,p),Int(Times(Power(Plus(a,Times(b,Power(x,n))),Plus(p,Negate(C1))),Sum(Times(Coeff($s("§pq"),x,i),Power(x,i),Power(Plus(Times(n,p),i,C1),-1)),List(i,C0,q))),x),x))),And(FreeQ(List(a,b),x),PolyQ($s("§pq"),x),IGtQ(Times(C1D2,Plus(n,Negate(C1))),C0),GtQ(p,C0)))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_)),x_Symbol),
    Condition(Module(List(Set(q,Expon($s("§pq"),x)),i),Condition(Plus(Simp(Times(Plus(Times(a,Coeff($s("§pq"),x,q)),Times(CN1,b,x,ExpandToSum(Plus($s("§pq"),Times(CN1,Coeff($s("§pq"),x,q),Power(x,q))),x))),Power(Plus(a,Times(b,Power(x,n))),Plus(p,C1)),Power(Times(a,b,n,Plus(p,C1)),-1)),x),Dist(Power(Times(a,n,Plus(p,C1)),-1),Int(Times(Sum(Times(Plus(Times(n,Plus(p,C1)),i,C1),Coeff($s("§pq"),x,i),Power(x,i)),List(i,C0,Plus(q,Negate(C1)))),Power(Plus(a,Times(b,Power(x,n))),Plus(p,C1))),x),x)),Equal(q,Plus(n,Negate(C1))))),And(FreeQ(List(a,b),x),PolyQ($s("§pq"),x),IGtQ(n,C0),LtQ(p,CN1)))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_DEFAULT))),p_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(x,$s("§pq"),Power(Plus(a,Times(b,Power(x,n))),Plus(p,C1)),Power(Times(a,n,Plus(p,C1)),-1)),x)),Dist(Power(Times(a,n,Plus(p,C1)),-1),Int(Times(ExpandToSum(Plus(Times(n,Plus(p,C1),$s("§pq")),D(Times(x,$s("§pq")),x)),x),Power(Plus(a,Times(b,Power(x,n))),Plus(p,C1))),x),x)),And(FreeQ(List(a,b),x),PolyQ($s("§pq"),x),IGtQ(n,C0),LtQ(p,CN1),LtQ(Expon($s("§pq"),x),Plus(n,Negate(C1)))))),
ISetDelayed(Int(Times($p("§p4"),Power(Plus(a_,Times(b_DEFAULT,Power(x_,4))),QQ(-3L,2L))),x_Symbol),
    Condition(With(List(Set(d,Coeff($s("§p4"),x,C0)),Set(e,Coeff($s("§p4"),x,C1)),Set(f,Coeff($s("§p4"),x,C3)),Set(g,Coeff($s("§p4"),x,C4))),Condition(Negate(Simp(Times(Plus(Times(a,f),Times(C2,a,g,x),Times(CN1,b,e,Sqr(x))),Power(Times(C2,a,b,Sqrt(Plus(a,Times(b,Power(x,4))))),-1)),x)),EqQ(Plus(Times(b,d),Times(a,g)),C0))),And(FreeQ(List(a,b),x),PolyQ($s("§p4"),x,C4),EqQ(Coeff($s("§p4"),x,C2),C0)))),
ISetDelayed(Int(Times($p("§p6"),Power(Plus(a_,Times(b_DEFAULT,Power(x_,4))),QQ(-3L,2L))),x_Symbol),
    Condition(With(List(Set(d,Coeff($s("§p6"),x,C0)),Set(e,Coeff($s("§p6"),x,C2)),Set(f,Coeff($s("§p6"),x,C3)),Set(g,Coeff($s("§p6"),x,C4)),Set(h,Coeff($s("§p6"),x,C6))),Condition(Negate(Simp(Times(Plus(Times(a,f),Times(CN1,C2,b,d,x),Times(CN1,C2,a,h,Power(x,3))),Power(Times(C2,a,b,Sqrt(Plus(a,Times(b,Power(x,4))))),-1)),x)),And(EqQ(Plus(Times(b,e),Times(CN1,C3,a,h)),C0),EqQ(Plus(Times(b,d),Times(a,g)),C0)))),And(FreeQ(List(a,b),x),PolyQ($s("§p6"),x,C6),EqQ(Coeff($s("§p6"),x,C1),C0),EqQ(Coeff($s("§p6"),x,C5),C0)))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_DEFAULT))),p_)),x_Symbol),
    Condition(With(List(Set(q,Expon($s("§pq"),x))),Condition(Module(List(Set($s("Q"),PolynomialQuotient(Times(Power(b,Plus(Floor(Times(Plus(q,Negate(C1)),Power(n,-1))),C1)),$s("§pq")),Plus(a,Times(b,Power(x,n))),x)),Set($s("R"),PolynomialRemainder(Times(Power(b,Plus(Floor(Times(Plus(q,Negate(C1)),Power(n,-1))),C1)),$s("§pq")),Plus(a,Times(b,Power(x,n))),x))),Plus(Dist(Power(Times(a,n,Plus(p,C1),Power(b,Plus(Floor(Times(Plus(q,Negate(C1)),Power(n,-1))),C1))),-1),Int(Times(Power(Plus(a,Times(b,Power(x,n))),Plus(p,C1)),ExpandToSum(Plus(Times(a,n,Plus(p,C1),$s("Q")),Times(n,Plus(p,C1),$s("R")),D(Times(x,$s("R")),x)),x)),x),x),Negate(Simp(Times(x,$s("R"),Power(Plus(a,Times(b,Power(x,n))),Plus(p,C1)),Power(Times(a,n,Plus(p,C1),Power(b,Plus(Floor(Times(Plus(q,Negate(C1)),Power(n,-1))),C1))),-1)),x)))),GeQ(q,n))),And(FreeQ(List(a,b),x),PolyQ($s("§pq"),x),IGtQ(n,C0),LtQ(p,CN1)))),
ISetDelayed(Int(Times(Plus(A_,Times(B_DEFAULT,x_)),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),-1)),x_Symbol),
    Condition(Dist(Times(Power(BSymbol,3),Power(b,-1)),Int(Power(Plus(Sqr(ASymbol),Times(CN1,ASymbol,BSymbol,x),Times(Sqr(BSymbol),Sqr(x))),-1),x),x),And(FreeQ(List(a,b,ASymbol,BSymbol),x),EqQ(Plus(Times(a,Power(BSymbol,3)),Times(CN1,b,Power(ASymbol,3))),C0)))),
ISetDelayed(Int(Times(Plus(A_,Times(B_DEFAULT,x_)),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),-1)),x_Symbol),
    Condition(With(List(Set(r,Numerator(Rt(Times(a,Power(b,-1)),C3))),Set(s,Denominator(Rt(Times(a,Power(b,-1)),C3)))),Plus(Negate(Dist(Times(r,Plus(Times(BSymbol,r),Times(CN1,ASymbol,s)),Power(Times(C3,a,s),-1)),Int(Power(Plus(r,Times(s,x)),-1),x),x)),Dist(Times(r,Power(Times(C3,a,s),-1)),Int(Times(Plus(Times(r,Plus(Times(BSymbol,r),Times(C2,ASymbol,s))),Times(s,Plus(Times(BSymbol,r),Times(CN1,ASymbol,s)),x)),Power(Plus(Sqr(r),Times(CN1,r,s,x),Times(Sqr(s),Sqr(x))),-1)),x),x))),And(FreeQ(List(a,b,ASymbol,BSymbol),x),NeQ(Plus(Times(a,Power(BSymbol,3)),Times(CN1,b,Power(ASymbol,3))),C0),PosQ(Times(a,Power(b,-1)))))),
ISetDelayed(Int(Times(Plus(A_,Times(B_DEFAULT,x_)),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),-1)),x_Symbol),
    Condition(With(List(Set(r,Numerator(Rt(Times(CN1,a,Power(b,-1)),C3))),Set(s,Denominator(Rt(Times(CN1,a,Power(b,-1)),C3)))),Plus(Dist(Times(r,Plus(Times(BSymbol,r),Times(ASymbol,s)),Power(Times(C3,a,s),-1)),Int(Power(Plus(r,Times(CN1,s,x)),-1),x),x),Negate(Dist(Times(r,Power(Times(C3,a,s),-1)),Int(Times(Plus(Times(r,Plus(Times(BSymbol,r),Times(CN1,C2,ASymbol,s))),Times(CN1,s,Plus(Times(BSymbol,r),Times(ASymbol,s)),x)),Power(Plus(Sqr(r),Times(r,s,x),Times(Sqr(s),Sqr(x))),-1)),x),x)))),And(FreeQ(List(a,b,ASymbol,BSymbol),x),NeQ(Plus(Times(a,Power(BSymbol,3)),Times(CN1,b,Power(ASymbol,3))),C0),NegQ(Times(a,Power(b,-1)))))),
ISetDelayed(Int(Times($p("§p2"),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),-1)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§p2"),x,C0)),Set(BSymbol,Coeff($s("§p2"),x,C1)),Set(CSymbol,Coeff($s("§p2"),x,C2))),Condition(Negate(Dist(Times(Sqr(CSymbol),Power(b,-1)),Int(Power(Plus(BSymbol,Times(CN1,CSymbol,x)),-1),x),x)),And(EqQ(Plus(Sqr(BSymbol),Times(CN1,ASymbol,CSymbol)),C0),EqQ(Plus(Times(b,Power(BSymbol,3)),Times(a,Power(CSymbol,3))),C0)))),And(FreeQ(List(a,b),x),PolyQ($s("§p2"),x,C2)))),
ISetDelayed(Int(Times($p("§p2"),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),-1)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§p2"),x,C0)),Set(BSymbol,Coeff($s("§p2"),x,C1)),Set(CSymbol,Coeff($s("§p2"),x,C2))),Condition(With(List(Set(q,Times(Power(a,C1D3),Power(b,CN1D3)))),Plus(Dist(Times(CSymbol,Power(b,-1)),Int(Power(Plus(q,x),-1),x),x),Dist(Times(Plus(BSymbol,Times(CSymbol,q)),Power(b,-1)),Int(Power(Plus(Sqr(q),Times(CN1,q,x),Sqr(x)),-1),x),x))),EqQ(Plus(Times(ASymbol,Power(b,QQ(2L,3L))),Times(CN1,Power(a,C1D3),Power(b,C1D3),BSymbol),Times(CN1,C2,Power(a,QQ(2L,3L)),CSymbol)),C0))),And(FreeQ(List(a,b),x),PolyQ($s("§p2"),x,C2)))),
ISetDelayed(Int(Times($p("§p2"),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),-1)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§p2"),x,C0)),Set(BSymbol,Coeff($s("§p2"),x,C1)),Set(CSymbol,Coeff($s("§p2"),x,C2))),Condition(With(List(Set(q,Times(Power(Negate(a),C1D3),Power(Negate(b),CN1D3)))),Plus(Dist(Times(CSymbol,Power(b,-1)),Int(Power(Plus(q,x),-1),x),x),Dist(Times(Plus(BSymbol,Times(CSymbol,q)),Power(b,-1)),Int(Power(Plus(Sqr(q),Times(CN1,q,x),Sqr(x)),-1),x),x))),EqQ(Plus(Times(ASymbol,Power(Negate(b),QQ(2L,3L))),Times(CN1,Power(Negate(a),C1D3),Power(Negate(b),C1D3),BSymbol),Times(CN1,C2,Power(Negate(a),QQ(2L,3L)),CSymbol)),C0))),And(FreeQ(List(a,b),x),PolyQ($s("§p2"),x,C2)))),
ISetDelayed(Int(Times($p("§p2"),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),-1)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§p2"),x,C0)),Set(BSymbol,Coeff($s("§p2"),x,C1)),Set(CSymbol,Coeff($s("§p2"),x,C2))),Condition(With(List(Set(q,Times(Power(Negate(a),C1D3),Power(b,CN1D3)))),Plus(Negate(Dist(Times(CSymbol,Power(b,-1)),Int(Power(Plus(q,Negate(x)),-1),x),x)),Dist(Times(Plus(BSymbol,Times(CN1,CSymbol,q)),Power(b,-1)),Int(Power(Plus(Sqr(q),Times(q,x),Sqr(x)),-1),x),x))),EqQ(Plus(Times(ASymbol,Power(b,QQ(2L,3L))),Times(Power(Negate(a),C1D3),Power(b,C1D3),BSymbol),Times(CN1,C2,Power(Negate(a),QQ(2L,3L)),CSymbol)),C0))),And(FreeQ(List(a,b),x),PolyQ($s("§p2"),x,C2)))),
ISetDelayed(Int(Times($p("§p2"),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),-1)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§p2"),x,C0)),Set(BSymbol,Coeff($s("§p2"),x,C1)),Set(CSymbol,Coeff($s("§p2"),x,C2))),Condition(With(List(Set(q,Times(Power(a,C1D3),Power(Negate(b),CN1D3)))),Plus(Negate(Dist(Times(CSymbol,Power(b,-1)),Int(Power(Plus(q,Negate(x)),-1),x),x)),Dist(Times(Plus(BSymbol,Times(CN1,CSymbol,q)),Power(b,-1)),Int(Power(Plus(Sqr(q),Times(q,x),Sqr(x)),-1),x),x))),EqQ(Plus(Times(ASymbol,Power(Negate(b),QQ(2L,3L))),Times(Power(a,C1D3),Power(Negate(b),C1D3),BSymbol),Times(CN1,C2,Power(a,QQ(2L,3L)),CSymbol)),C0))),And(FreeQ(List(a,b),x),PolyQ($s("§p2"),x,C2)))),
ISetDelayed(Int(Times($p("§p2"),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),-1)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§p2"),x,C0)),Set(BSymbol,Coeff($s("§p2"),x,C1)),Set(CSymbol,Coeff($s("§p2"),x,C2))),Condition(With(List(Set(q,Power(Times(a,Power(b,-1)),C1D3))),Plus(Dist(Times(CSymbol,Power(b,-1)),Int(Power(Plus(q,x),-1),x),x),Dist(Times(Plus(BSymbol,Times(CSymbol,q)),Power(b,-1)),Int(Power(Plus(Sqr(q),Times(CN1,q,x),Sqr(x)),-1),x),x))),EqQ(Plus(ASymbol,Times(CN1,Power(Times(a,Power(b,-1)),C1D3),BSymbol),Times(CN1,C2,Power(Times(a,Power(b,-1)),QQ(2L,3L)),CSymbol)),C0))),And(FreeQ(List(a,b),x),PolyQ($s("§p2"),x,C2)))),
ISetDelayed(Int(Times($p("§p2"),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),-1)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§p2"),x,C0)),Set(BSymbol,Coeff($s("§p2"),x,C1)),Set(CSymbol,Coeff($s("§p2"),x,C2))),Condition(With(List(Set(q,Rt(Times(a,Power(b,-1)),C3))),Plus(Dist(Times(CSymbol,Power(b,-1)),Int(Power(Plus(q,x),-1),x),x),Dist(Times(Plus(BSymbol,Times(CSymbol,q)),Power(b,-1)),Int(Power(Plus(Sqr(q),Times(CN1,q,x),Sqr(x)),-1),x),x))),EqQ(Plus(ASymbol,Times(CN1,Rt(Times(a,Power(b,-1)),C3),BSymbol),Times(CN1,C2,Sqr(Rt(Times(a,Power(b,-1)),C3)),CSymbol)),C0))),And(FreeQ(List(a,b),x),PolyQ($s("§p2"),x,C2)))),
ISetDelayed(Int(Times($p("§p2"),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),-1)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§p2"),x,C0)),Set(BSymbol,Coeff($s("§p2"),x,C1)),Set(CSymbol,Coeff($s("§p2"),x,C2))),Condition(With(List(Set(q,Power(Times(CN1,a,Power(b,-1)),C1D3))),Plus(Negate(Dist(Times(CSymbol,Power(b,-1)),Int(Power(Plus(q,Negate(x)),-1),x),x)),Dist(Times(Plus(BSymbol,Times(CN1,CSymbol,q)),Power(b,-1)),Int(Power(Plus(Sqr(q),Times(q,x),Sqr(x)),-1),x),x))),EqQ(Plus(ASymbol,Times(Power(Times(CN1,a,Power(b,-1)),C1D3),BSymbol),Times(CN1,C2,Power(Times(CN1,a,Power(b,-1)),QQ(2L,3L)),CSymbol)),C0))),And(FreeQ(List(a,b),x),PolyQ($s("§p2"),x,C2)))),
ISetDelayed(Int(Times($p("§p2"),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),-1)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§p2"),x,C0)),Set(BSymbol,Coeff($s("§p2"),x,C1)),Set(CSymbol,Coeff($s("§p2"),x,C2))),Condition(With(List(Set(q,Rt(Times(CN1,a,Power(b,-1)),C3))),Plus(Negate(Dist(Times(CSymbol,Power(b,-1)),Int(Power(Plus(q,Negate(x)),-1),x),x)),Dist(Times(Plus(BSymbol,Times(CN1,CSymbol,q)),Power(b,-1)),Int(Power(Plus(Sqr(q),Times(q,x),Sqr(x)),-1),x),x))),EqQ(Plus(ASymbol,Times(Rt(Times(CN1,a,Power(b,-1)),C3),BSymbol),Times(CN1,C2,Sqr(Rt(Times(CN1,a,Power(b,-1)),C3)),CSymbol)),C0))),And(FreeQ(List(a,b),x),PolyQ($s("§p2"),x,C2)))),
ISetDelayed(Int(Times($p("§p2"),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),-1)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§p2"),x,C0)),Set(BSymbol,Coeff($s("§p2"),x,C1)),Set(CSymbol,Coeff($s("§p2"),x,C2))),Condition(Plus(Int(Times(Plus(ASymbol,Times(BSymbol,x)),Power(Plus(a,Times(b,Power(x,3))),-1)),x),Dist(CSymbol,Int(Times(Sqr(x),Power(Plus(a,Times(b,Power(x,3))),-1)),x),x)),Or(EqQ(Plus(Times(a,Power(BSymbol,3)),Times(CN1,b,Power(ASymbol,3))),C0),Not(RationalQ(Times(a,Power(b,-1))))))),And(FreeQ(List(a,b),x),PolyQ($s("§p2"),x,C2)))),
ISetDelayed(Int(Times($p("§p2"),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),-1)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§p2"),x,C0)),Set(BSymbol,Coeff($s("§p2"),x,C1)),Set(CSymbol,Coeff($s("§p2"),x,C2))),Condition(With(List(Set(q,Power(Times(a,Power(b,-1)),C1D3))),Dist(Times(Sqr(q),Power(a,-1)),Int(Times(Plus(ASymbol,Times(CSymbol,q,x)),Power(Plus(Sqr(q),Times(CN1,q,x),Sqr(x)),-1)),x),x)),EqQ(Plus(ASymbol,Times(CN1,BSymbol,Power(Times(a,Power(b,-1)),C1D3)),Times(CSymbol,Power(Times(a,Power(b,-1)),QQ(2L,3L)))),C0))),And(FreeQ(List(a,b),x),PolyQ($s("§p2"),x,C2)))),
ISetDelayed(Int(Times($p("§p2"),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),-1)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§p2"),x,C0)),Set(BSymbol,Coeff($s("§p2"),x,C1)),Set(CSymbol,Coeff($s("§p2"),x,C2))),Condition(With(List(Set(q,Power(Times(CN1,a,Power(b,-1)),C1D3))),Dist(Times(q,Power(a,-1)),Int(Times(Plus(Times(ASymbol,q),Times(Plus(ASymbol,Times(BSymbol,q)),x)),Power(Plus(Sqr(q),Times(q,x),Sqr(x)),-1)),x),x)),EqQ(Plus(ASymbol,Times(BSymbol,Power(Times(CN1,a,Power(b,-1)),C1D3)),Times(CSymbol,Power(Times(CN1,a,Power(b,-1)),QQ(2L,3L)))),C0))),And(FreeQ(List(a,b),x),PolyQ($s("§p2"),x,C2)))),
ISetDelayed(Int(Times($p("§p2"),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),-1)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§p2"),x,C0)),Set(BSymbol,Coeff($s("§p2"),x,C1)),Set(CSymbol,Coeff($s("§p2"),x,C2)),Set(q,Power(Times(a,Power(b,-1)),C1D3))),Condition(Plus(Dist(Times(q,Plus(ASymbol,Times(CN1,BSymbol,q),Times(CSymbol,Sqr(q))),Power(Times(C3,a),-1)),Int(Power(Plus(q,x),-1),x),x),Dist(Times(q,Power(Times(C3,a),-1)),Int(Times(Plus(Times(q,Plus(Times(C2,ASymbol),Times(BSymbol,q),Times(CN1,CSymbol,Sqr(q)))),Times(CN1,Plus(ASymbol,Times(CN1,BSymbol,q),Times(CN1,C2,CSymbol,Sqr(q))),x)),Power(Plus(Sqr(q),Times(CN1,q,x),Sqr(x)),-1)),x),x)),And(NeQ(Plus(Times(a,Power(BSymbol,3)),Times(CN1,b,Power(ASymbol,3))),C0),NeQ(Plus(ASymbol,Times(CN1,BSymbol,q),Times(CSymbol,Sqr(q))),C0)))),And(FreeQ(List(a,b),x),PolyQ($s("§p2"),x,C2),GtQ(Times(a,Power(b,-1)),C0)))),
ISetDelayed(Int(Times($p("§p2"),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),-1)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§p2"),x,C0)),Set(BSymbol,Coeff($s("§p2"),x,C1)),Set(CSymbol,Coeff($s("§p2"),x,C2)),Set(q,Power(Times(CN1,a,Power(b,-1)),C1D3))),Condition(Plus(Dist(Times(q,Plus(ASymbol,Times(BSymbol,q),Times(CSymbol,Sqr(q))),Power(Times(C3,a),-1)),Int(Power(Plus(q,Negate(x)),-1),x),x),Dist(Times(q,Power(Times(C3,a),-1)),Int(Times(Plus(Times(q,Plus(Times(C2,ASymbol),Times(CN1,BSymbol,q),Times(CN1,CSymbol,Sqr(q)))),Times(Plus(ASymbol,Times(BSymbol,q),Times(CN1,C2,CSymbol,Sqr(q))),x)),Power(Plus(Sqr(q),Times(q,x),Sqr(x)),-1)),x),x)),And(NeQ(Plus(Times(a,Power(BSymbol,3)),Times(CN1,b,Power(ASymbol,3))),C0),NeQ(Plus(ASymbol,Times(BSymbol,q),Times(CSymbol,Sqr(q))),C0)))),And(FreeQ(List(a,b),x),PolyQ($s("§p2"),x,C2),LtQ(Times(a,Power(b,-1)),C0)))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),-1)),x_Symbol),
    Condition(With(List(Set(v,Sum(Times(Power(x,$s("ii")),Plus(Coeff($s("§pq"),x,$s("ii")),Times(Coeff($s("§pq"),x,Plus(Times(C1D2,n),$s("ii"))),Power(x,Times(C1D2,n)))),Power(Plus(a,Times(b,Power(x,n))),-1)),List($s("ii"),C0,Plus(Times(C1D2,n),Negate(C1)))))),Condition(Int(v,x),SumQ(v))),And(FreeQ(List(a,b),x),PolyQ($s("§pq"),x),IGtQ(Times(C1D2,n),C0),Less(Expon($s("§pq"),x),n)))),
ISetDelayed(Int(Times(Plus(c_,Times(d_DEFAULT,x_)),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),CN1D2)),x_Symbol),
    Condition(With(List(Set(r,$($s("§numer"),Simplify(Times(Plus(C1,Negate(CSqrt3)),d,Power(c,-1))))),Set(s,$($s("§denom"),Simplify(Times(Plus(C1,Negate(CSqrt3)),d,Power(c,-1)))))),Plus(Simp(Times(C2,d,Power(s,3),Sqrt(Plus(a,Times(b,Power(x,3)))),Power(Times(a,Sqr(r),Plus(Times(Plus(C1,CSqrt3),s),Times(r,x))),-1)),x),Negate(Simp(Times(Power(C3,C1D4),Sqrt(Plus(C2,Negate(CSqrt3))),d,s,Plus(s,Times(r,x)),Sqrt(Times(Plus(Sqr(s),Times(CN1,r,s,x),Times(Sqr(r),Sqr(x))),Power(Plus(Times(Plus(C1,CSqrt3),s),Times(r,x)),-2))),EllipticE(ArcSin(Times(Plus(Times(Plus(C1,Negate(CSqrt3)),s),Times(r,x)),Power(Plus(Times(Plus(C1,CSqrt3),s),Times(r,x)),-1))),Plus(CN7,Times(CN1,C4,CSqrt3))),Power(Times(Sqr(r),Sqrt(Plus(a,Times(b,Power(x,3)))),Sqrt(Times(s,Plus(s,Times(r,x)),Power(Plus(Times(Plus(C1,CSqrt3),s),Times(r,x)),-2)))),-1)),x)))),And(FreeQ(List(a,b,c,d),x),PosQ(a),EqQ(Plus(Times(b,Power(c,3)),Times(CN1,C2,Plus(C5,Times(CN1,C3,CSqrt3)),a,Power(d,3))),C0)))),
ISetDelayed(Int(Times(Plus(c_,Times(d_DEFAULT,x_)),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),CN1D2)),x_Symbol),
    Condition(With(List(Set(r,$($s("§numer"),Rt(Times(b,Power(a,-1)),C3))),Set(s,$($s("§denom"),Rt(Times(b,Power(a,-1)),C3)))),Plus(Dist(Times(Plus(Times(c,r),Times(CN1,Plus(C1,Negate(CSqrt3)),d,s)),Power(r,-1)),Int(Power(Plus(a,Times(b,Power(x,3))),CN1D2),x),x),Dist(Times(d,Power(r,-1)),Int(Times(Plus(Times(Plus(C1,Negate(CSqrt3)),s),Times(r,x)),Power(Plus(a,Times(b,Power(x,3))),CN1D2)),x),x))),And(FreeQ(List(a,b,c,d),x),PosQ(a),NeQ(Plus(Times(b,Power(c,3)),Times(CN1,C2,Plus(C5,Times(CN1,C3,CSqrt3)),a,Power(d,3))),C0)))),
ISetDelayed(Int(Times(Plus(c_,Times(d_DEFAULT,x_)),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),CN1D2)),x_Symbol),
    Condition(With(List(Set(r,$($s("§numer"),Simplify(Times(Plus(C1,CSqrt3),d,Power(c,-1))))),Set(s,$($s("§denom"),Simplify(Times(Plus(C1,CSqrt3),d,Power(c,-1)))))),Plus(Simp(Times(C2,d,Power(s,3),Sqrt(Plus(a,Times(b,Power(x,3)))),Power(Times(a,Sqr(r),Plus(Times(Plus(C1,Negate(CSqrt3)),s),Times(r,x))),-1)),x),Simp(Times(Power(C3,C1D4),Sqrt(Plus(C2,CSqrt3)),d,s,Plus(s,Times(r,x)),Sqrt(Times(Plus(Sqr(s),Times(CN1,r,s,x),Times(Sqr(r),Sqr(x))),Power(Plus(Times(Plus(C1,Negate(CSqrt3)),s),Times(r,x)),-2))),EllipticE(ArcSin(Times(Plus(Times(Plus(C1,CSqrt3),s),Times(r,x)),Power(Plus(Times(Plus(C1,Negate(CSqrt3)),s),Times(r,x)),-1))),Plus(CN7,Times(C4,CSqrt3))),Power(Times(Sqr(r),Sqrt(Plus(a,Times(b,Power(x,3)))),Sqrt(Times(CN1,s,Plus(s,Times(r,x)),Power(Plus(Times(Plus(C1,Negate(CSqrt3)),s),Times(r,x)),-2)))),-1)),x))),And(FreeQ(List(a,b,c,d),x),NegQ(a),EqQ(Plus(Times(b,Power(c,3)),Times(CN1,C2,Plus(C5,Times(C3,CSqrt3)),a,Power(d,3))),C0)))),
ISetDelayed(Int(Times(Plus(c_,Times(d_DEFAULT,x_)),Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),CN1D2)),x_Symbol),
    Condition(With(List(Set(r,$($s("§numer"),Rt(Times(b,Power(a,-1)),C3))),Set(s,$($s("§denom"),Rt(Times(b,Power(a,-1)),C3)))),Plus(Dist(Times(Plus(Times(c,r),Times(CN1,Plus(C1,CSqrt3),d,s)),Power(r,-1)),Int(Power(Plus(a,Times(b,Power(x,3))),CN1D2),x),x),Dist(Times(d,Power(r,-1)),Int(Times(Plus(Times(Plus(C1,CSqrt3),s),Times(r,x)),Power(Plus(a,Times(b,Power(x,3))),CN1D2)),x),x))),And(FreeQ(List(a,b,c,d),x),NegQ(a),NeQ(Plus(Times(b,Power(c,3)),Times(CN1,C2,Plus(C5,Times(C3,CSqrt3)),a,Power(d,3))),C0)))),
ISetDelayed(Int(Times(Plus(c_,Times(d_DEFAULT,Power(x_,4))),Power(Plus(a_,Times(b_DEFAULT,Power(x_,6))),CN1D2)),x_Symbol),
    Condition(With(List(Set(r,$($s("§numer"),Rt(Times(b,Power(a,-1)),C3))),Set(s,$($s("§denom"),Rt(Times(b,Power(a,-1)),C3)))),Plus(Simp(Times(Plus(C1,CSqrt3),d,Power(s,3),x,Sqrt(Plus(a,Times(b,Power(x,6)))),Power(Times(C2,a,Sqr(r),Plus(s,Times(Plus(C1,CSqrt3),r,Sqr(x)))),-1)),x),Negate(Simp(Times(Power(C3,C1D4),d,s,x,Plus(s,Times(r,Sqr(x))),Sqrt(Times(Plus(Sqr(s),Times(CN1,r,s,Sqr(x)),Times(Sqr(r),Power(x,4))),Power(Plus(s,Times(Plus(C1,CSqrt3),r,Sqr(x))),-2))),EllipticE(ArcCos(Times(Plus(s,Times(Plus(C1,Negate(CSqrt3)),r,Sqr(x))),Power(Plus(s,Times(Plus(C1,CSqrt3),r,Sqr(x))),-1))),Times(C1D4,Plus(C2,CSqrt3))),Power(Times(C2,Sqr(r),Sqrt(Times(r,Sqr(x),Plus(s,Times(r,Sqr(x))),Power(Plus(s,Times(Plus(C1,CSqrt3),r,Sqr(x))),-2))),Sqrt(Plus(a,Times(b,Power(x,6))))),-1)),x)))),And(FreeQ(List(a,b,c,d),x),EqQ(Plus(Times(C2,Sqr(Rt(Times(b,Power(a,-1)),C3)),c),Times(CN1,Plus(C1,Negate(CSqrt3)),d)),C0)))),
ISetDelayed(Int(Times(Plus(c_,Times(d_DEFAULT,Power(x_,4))),Power(Plus(a_,Times(b_DEFAULT,Power(x_,6))),CN1D2)),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(b,Power(a,-1)),C3))),Plus(Dist(Times(Plus(Times(C2,c,Sqr(q)),Times(CN1,Plus(C1,Negate(CSqrt3)),d)),Power(Times(C2,Sqr(q)),-1)),Int(Power(Plus(a,Times(b,Power(x,6))),CN1D2),x),x),Dist(Times(d,Power(Times(C2,Sqr(q)),-1)),Int(Times(Plus(C1,Negate(CSqrt3),Times(C2,Sqr(q),Power(x,4))),Power(Plus(a,Times(b,Power(x,6))),CN1D2)),x),x))),And(FreeQ(List(a,b,c,d),x),NeQ(Plus(Times(C2,Sqr(Rt(Times(b,Power(a,-1)),C3)),c),Times(CN1,Plus(C1,Negate(CSqrt3)),d)),C0)))),
ISetDelayed(Int(Times(Plus(c_,Times(d_DEFAULT,Sqr(x_))),Power(Plus(a_,Times(b_DEFAULT,Power(x_,8))),CN1D2)),x_Symbol),
    Condition(Negate(Simp(Times(c,d,Power(x,3),Sqrt(Times(CN1,Sqr(Plus(c,Times(CN1,d,Sqr(x)))),Power(Times(c,d,Sqr(x)),-1))),Sqrt(Times(CN1,Sqr(d),Plus(a,Times(b,Power(x,8))),Power(Times(b,Sqr(c),Power(x,4)),-1))),EllipticF(ArcSin(Times(C1D2,C1,Sqrt(Times(Plus(Times(CSqrt2,Sqr(c)),Times(C2,c,d,Sqr(x)),Times(CSqrt2,Sqr(d),Power(x,4))),Power(Times(c,d,Sqr(x)),-1))))),Times(CN2,Plus(C1,Negate(CSqrt2)))),Power(Times(Sqrt(Plus(C2,CSqrt2)),Plus(c,Times(CN1,d,Sqr(x))),Sqrt(Plus(a,Times(b,Power(x,8))))),-1)),x)),And(FreeQ(List(a,b,c,d),x),EqQ(Plus(Times(b,Power(c,4)),Times(CN1,a,Power(d,4))),C0)))),
ISetDelayed(Int(Times(Plus(c_,Times(d_DEFAULT,Sqr(x_))),Power(Plus(a_,Times(b_DEFAULT,Power(x_,8))),CN1D2)),x_Symbol),
    Condition(Plus(Dist(Times(Plus(d,Times(Rt(Times(b,Power(a,-1)),C4),c)),Power(Times(C2,Rt(Times(b,Power(a,-1)),C4)),-1)),Int(Times(Plus(C1,Times(Rt(Times(b,Power(a,-1)),C4),Sqr(x))),Power(Plus(a,Times(b,Power(x,8))),CN1D2)),x),x),Negate(Dist(Times(Plus(d,Times(CN1,Rt(Times(b,Power(a,-1)),C4),c)),Power(Times(C2,Rt(Times(b,Power(a,-1)),C4)),-1)),Int(Times(Plus(C1,Times(CN1,Rt(Times(b,Power(a,-1)),C4),Sqr(x))),Power(Plus(a,Times(b,Power(x,8))),CN1D2)),x),x))),And(FreeQ(List(a,b,c,d),x),NeQ(Plus(Times(b,Power(c,4)),Times(CN1,a,Power(d,4))),C0)))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_)),x_Symbol),
    Condition(Module(List(Set(q,Expon($s("§pq"),x)),j,k),Int(Sum(Times(Power(x,j),Sum(Times(Coeff($s("§pq"),x,Plus(j,Times(C1D2,k,n))),Power(x,Times(C1D2,k,n))),List(k,C0,Plus(Times(C2,Plus(q,Negate(j)),Power(n,-1)),C1))),Power(Plus(a,Times(b,Power(x,n))),p)),List(j,C0,Plus(Times(C1D2,n),Negate(C1)))),x)),And(FreeQ(List(a,b,p),x),PolyQ($s("§pq"),x),IGtQ(Times(C1D2,n),C0),Not(PolyQ($s("§pq"),Power(x,Times(C1D2,n))))))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_)),x_Symbol),
    Condition(Plus(Dist(Coeff($s("§pq"),x,Plus(n,Negate(C1))),Int(Times(Power(x,Plus(n,Negate(C1))),Power(Plus(a,Times(b,Power(x,n))),p)),x),x),Int(Times(ExpandToSum(Plus($s("§pq"),Times(CN1,Coeff($s("§pq"),x,Plus(n,Negate(C1))),Power(x,Plus(n,Negate(C1))))),x),Power(Plus(a,Times(b,Power(x,n))),p)),x)),And(FreeQ(List(a,b,p),x),PolyQ($s("§pq"),x),IGtQ(n,C0),Equal(Expon($s("§pq"),x),Plus(n,Negate(C1)))))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),-1)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times($s("§pq"),Power(Plus(a,Times(b,Power(x,n))),-1)),x),x),And(FreeQ(List(a,b),x),PolyQ($s("§pq"),x),IntegerQ(n)))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_)),x_Symbol),
    Condition(With(List(Set(q,Expon($s("§pq"),x))),Condition(With(List(Set($s("§pqq"),Coeff($s("§pq"),x,q))),Plus(Dist(Power(Times(b,Plus(q,Times(n,p),C1)),-1),Int(Times(ExpandToSum(Plus(Times(b,Plus(q,Times(n,p),C1),Plus($s("§pq"),Times(CN1,$s("§pqq"),Power(x,q)))),Times(CN1,a,$s("§pqq"),Plus(q,Negate(n),C1),Power(x,Plus(q,Negate(n))))),x),Power(Plus(a,Times(b,Power(x,n))),p)),x),x),Simp(Times($s("§pqq"),Power(x,Plus(q,Negate(n),C1)),Power(Plus(a,Times(b,Power(x,n))),Plus(p,C1)),Power(Times(b,Plus(q,Times(n,p),C1)),-1)),x))),And(NeQ(Plus(q,Times(n,p),C1),C0),GreaterEqual(Plus(q,Negate(n)),C0),Or(IntegerQ(Times(C2,p)),IntegerQ(Plus(p,Times(Plus(q,C1),Power(Times(C2,n),-1)))))))),And(FreeQ(List(a,b,p),x),PolyQ($s("§pq"),x),IGtQ(n,C0)))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_)),x_Symbol),
    Condition(With(List(Set(q,Expon($s("§pq"),x))),Negate(Subst(Int(Times(ExpandToSum(Times(Power(x,q),ReplaceAll($s("§pq"),Rule(x,Power(x,-1)))),x),Power(Plus(a,Times(b,Power(Power(x,n),-1))),p),Power(Power(x,Plus(q,C2)),-1)),x),x,Power(x,-1)))),And(FreeQ(List(a,b,p),x),PolyQ($s("§pq"),x),ILtQ(n,C0)))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_)),x_Symbol),
    Condition(With(List(Set(g,Denominator(n))),Dist(g,Subst(Int(Times(Power(x,Plus(g,Negate(C1))),ReplaceAll($s("§pq"),Rule(x,Power(x,g))),Power(Plus(a,Times(b,Power(x,Times(g,n)))),p)),x),x,Power(x,Power(g,-1))),x)),And(FreeQ(List(a,b,p),x),PolyQ($s("§pq"),x),FractionQ(n)))),
ISetDelayed(Int(Times(Plus(A_,Times(B_DEFAULT,Power(x_,m_DEFAULT))),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Dist(ASymbol,Int(Power(Plus(a,Times(b,Power(x,n))),p),x),x),Dist(BSymbol,Int(Times(Power(x,m),Power(Plus(a,Times(b,Power(x,n))),p)),x),x)),And(FreeQ(List(a,b,ASymbol,BSymbol,m,n,p),x),EqQ(Plus(m,Negate(n),C1),C0)))),
ISetDelayed(Int(Times($p("§p3"),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§p3"),Power(x,Times(C1D2,n)),C0)),Set(BSymbol,Coeff($s("§p3"),Power(x,Times(C1D2,n)),C1)),Set(CSymbol,Coeff($s("§p3"),Power(x,Times(C1D2,n)),C2)),Set($s("D"),Coeff($s("§p3"),Power(x,Times(C1D2,n)),C3))),Plus(Negate(Simp(Times(x,Plus(Times(b,ASymbol),Times(CN1,a,CSymbol),Times(Plus(Times(b,BSymbol),Times(CN1,a,$s("D"))),Power(x,Times(C1D2,n)))),Power(Plus(a,Times(b,Power(x,n))),Plus(p,C1)),Power(Times(a,b,n,Plus(p,C1)),-1)),x)),Negate(Dist(Power(Times(C2,a,b,n,Plus(p,C1)),-1),Int(Times(Power(Plus(a,Times(b,Power(x,n))),Plus(p,C1)),Simp(Plus(Times(C2,a,CSymbol),Times(CN1,C2,b,ASymbol,Plus(Times(n,Plus(p,C1)),C1)),Times(Plus(Times(a,$s("D"),Plus(n,C2)),Times(CN1,b,BSymbol,Plus(Times(n,Plus(Times(C2,p),C3)),C2))),Power(x,Times(C1D2,n)))),x)),x),x)))),And(FreeQ(List(a,b,n),x),PolyQ($s("§p3"),Power(x,Times(C1D2,n)),C3),ILtQ(p,CN1)))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_DEFAULT)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times($s("§pq"),Power(Plus(a,Times(b,Power(x,n))),p)),x),x),And(FreeQ(List(a,b,n,p),x),Or(PolyQ($s("§pq"),x),PolyQ($s("§pq"),Power(x,n)))))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus(a_,Times(b_DEFAULT,Power(v_,n_DEFAULT))),p_)),x_Symbol),
    Condition(Dist(Power(Coeff(v,x,C1),-1),Subst(Int(Times(SubstFor(v,$s("§pq"),x),Power(Plus(a,Times(b,Power(x,n))),p)),x),x,v),x),And(FreeQ(List(a,b,n,p),x),LinearQ(v,x),PolyQ($s("§pq"),Power(v,n))))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus($p("a1"),Times($p("b1",true),Power(x_,n_DEFAULT))),p_DEFAULT),Power(Plus($p("a2"),Times($p("b2",true),Power(x_,n_DEFAULT))),p_DEFAULT)),x_Symbol),
    Condition(Int(Times($s("§pq"),Power(Plus(Times($s("a1"),$s("a2")),Times($s("b1"),$s("b2"),Power(x,Times(C2,n)))),p)),x),And(FreeQ(List($s("a1"),$s("b1"),$s("a2"),$s("b2"),n,p),x),PolyQ($s("§pq"),x),EqQ(Plus(Times($s("a2"),$s("b1")),Times($s("a1"),$s("b2"))),C0),Or(IntegerQ(p),And(GtQ($s("a1"),C0),GtQ($s("a2"),C0)))))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus($p("a1"),Times($p("b1",true),Power(x_,n_DEFAULT))),p_DEFAULT),Power(Plus($p("a2"),Times($p("b2",true),Power(x_,n_DEFAULT))),p_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Power(Plus($s("a1"),Times($s("b1"),Power(x,n))),FracPart(p)),Power(Plus($s("a2"),Times($s("b2"),Power(x,n))),FracPart(p)),Power(Power(Plus(Times($s("a1"),$s("a2")),Times($s("b1"),$s("b2"),Power(x,Times(C2,n)))),FracPart(p)),-1)),Int(Times($s("§pq"),Power(Plus(Times($s("a1"),$s("a2")),Times($s("b1"),$s("b2"),Power(x,Times(C2,n)))),p)),x),x),And(FreeQ(List($s("a1"),$s("b1"),$s("a2"),$s("b2"),n,p),x),PolyQ($s("§pq"),x),EqQ(Plus(Times($s("a2"),$s("b1")),Times($s("a1"),$s("b2"))),C0),Not(And(EqQ(n,C1),LinearQ($s("§pq"),x)))))),
ISetDelayed(Int(Times(Plus(e_,Times(f_DEFAULT,Power(x_,n_DEFAULT)),Times(g_DEFAULT,Power(x_,$p("n2",true)))),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_DEFAULT))),p_DEFAULT),Power(Plus(c_,Times(d_DEFAULT,Power(x_,n_DEFAULT))),p_DEFAULT)),x_Symbol),
    Condition(Simp(Times(e,x,Power(Plus(a,Times(b,Power(x,n))),Plus(p,C1)),Power(Plus(c,Times(d,Power(x,n))),Plus(p,C1)),Power(Times(a,c),-1)),x),And(FreeQ(List(a,b,c,d,e,f,g,n,p),x),EqQ($s("n2"),Times(C2,n)),EqQ(Plus(Times(a,c,f),Times(CN1,e,Plus(Times(b,c),Times(a,d)),Plus(Times(n,Plus(p,C1)),C1))),C0),EqQ(Plus(Times(a,c,g),Times(CN1,b,d,e,Plus(Times(C2,n,Plus(p,C1)),C1))),C0)))),
ISetDelayed(Int(Times(Plus(e_,Times(g_DEFAULT,Power(x_,$p("n2",true)))),Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_DEFAULT))),p_DEFAULT),Power(Plus(c_,Times(d_DEFAULT,Power(x_,n_DEFAULT))),p_DEFAULT)),x_Symbol),
    Condition(Simp(Times(e,x,Power(Plus(a,Times(b,Power(x,n))),Plus(p,C1)),Power(Plus(c,Times(d,Power(x,n))),Plus(p,C1)),Power(Times(a,c),-1)),x),And(FreeQ(List(a,b,c,d,e,g,n,p),x),EqQ($s("n2"),Times(C2,n)),EqQ(Plus(Times(n,Plus(p,C1)),C1),C0),EqQ(Plus(Times(a,c,g),Times(CN1,b,d,e,Plus(Times(C2,n,Plus(p,C1)),C1))),C0)))),
ISetDelayed(Int(Times(Plus(A_,Times(B_DEFAULT,Power(x_,m_DEFAULT))),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(x_,n_))),p_DEFAULT),Power(Plus(c_,Times(d_DEFAULT,Power(x_,n_))),q_DEFAULT)),x_Symbol),
    Condition(Plus(Dist(ASymbol,Int(Times(Power(Plus(a,Times(b,Power(x,n))),p),Power(Plus(c,Times(d,Power(x,n))),q)),x),x),Dist(BSymbol,Int(Times(Power(x,m),Power(Plus(a,Times(b,Power(x,n))),p),Power(Plus(c,Times(d,Power(x,n))),q)),x),x)),And(FreeQ(List(a,b,c,d,ASymbol,BSymbol,m,n,p,q),x),NeQ(Plus(Times(b,c),Times(CN1,a,d)),C0),EqQ(Plus(m,Negate(n),C1),C0)))),
ISetDelayed(Int(Times(Power($p("§px"),q_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(Plus(c_,Times(d_DEFAULT,x_)),n_))),p_)),x_Symbol),
    Condition(With(List(Set(k,Denominator(n))),Dist(Times(k,Power(d,-1)),Subst(Int(SimplifyIntegrand(Times(Power(x,Plus(k,Negate(C1))),Power(ReplaceAll($s("§px"),Rule(x,Plus(Times(Power(x,k),Power(d,-1)),Times(CN1,c,Power(d,-1))))),q),Power(Plus(a,Times(b,Power(x,Times(k,n)))),p)),x),x),x,Power(Plus(c,Times(d,x)),Power(k,-1))),x)),And(FreeQ(List(a,b,c,d,p),x),PolynomialQ($s("§px"),x),IntegerQ(q),FractionQ(n))))
  );
}
