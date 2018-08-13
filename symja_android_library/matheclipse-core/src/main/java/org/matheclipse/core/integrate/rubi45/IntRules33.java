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
public class IntRules33 { 
  public static IAST RULES = List( 
ISetDelayed(Int(Times($p("§pq"),Power(Plus(d_,Times(e_DEFAULT,x_)),m_),Power(Plus(a_,Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(With(List(Set($s("Q"),PolynomialQuotient($s("§pq"),Plus(d,Times(e,x)),x)),Set($s("R"),PolynomialRemainder($s("§pq"),Plus(d,Times(e,x)),x))),Plus(Simp(Times(e,$s("R"),Power(Plus(d,Times(e,x)),Plus(m,C1)),Power(Plus(a,Times(c,Sqr(x))),Plus(p,C1)),Power(Times(Plus(m,C1),Plus(Times(c,Sqr(d)),Times(a,Sqr(e)))),-1)),x),Dist(Power(Times(Plus(m,C1),Plus(Times(c,Sqr(d)),Times(a,Sqr(e)))),-1),Int(Times(Power(Plus(d,Times(e,x)),Plus(m,C1)),Power(Plus(a,Times(c,Sqr(x))),p),ExpandToSum(Plus(Times(Plus(m,C1),Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),$s("Q")),Times(c,d,$s("R"),Plus(m,C1)),Times(CN1,c,e,$s("R"),Plus(m,Times(C2,p),C3),x)),x)),x),x))),And(FreeQ(List(a,c,d,e,p),x),PolyQ($s("§pq"),x),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),LtQ(m,CN1)))),
ISetDelayed(Int(Times($p("§pq"),Power(x_,m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Module(List(Set(q,Expon($s("§pq"),x)),k),Plus(Int(Times(Power(x,m),Sum(Times(Coeff($s("§pq"),x,Times(C2,k)),Power(x,Times(C2,k))),List(k,C0,Times(C1D2,q))),Power(Plus(a,Times(b,Sqr(x))),p)),x),Int(Times(Power(x,Plus(m,C1)),Sum(Times(Coeff($s("§pq"),x,Plus(Times(C2,k),C1)),Power(x,Times(C2,k))),List(k,C0,Times(C1D2,Plus(q,Negate(C1))))),Power(Plus(a,Times(b,Sqr(x))),p)),x))),And(FreeQ(List(a,b,p),x),PolyQ($s("§pq"),x),Not(PolyQ($s("§pq"),Sqr(x))),IGtQ(m,CN2),Not(IntegerQ(Times(C2,p)))))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(With(List(Set(q,Expon($s("§pq"),x)),Set(f,Coeff($s("§pq"),x,Expon($s("§pq"),x)))),Condition(Plus(Simp(Times(f,Power(Plus(d,Times(e,x)),Plus(m,q,Negate(C1))),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),Plus(p,C1)),Power(Times(c,Power(e,Plus(q,Negate(C1))),Plus(m,q,Times(C2,p),C1)),-1)),x),Dist(Power(Times(c,Power(e,q),Plus(m,q,Times(C2,p),C1)),-1),Int(Times(Power(Plus(d,Times(e,x)),m),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),p),ExpandToSum(Plus(Times(c,Power(e,q),Plus(m,q,Times(C2,p),C1),$s("§pq")),Times(CN1,c,f,Plus(m,q,Times(C2,p),C1),Power(Plus(d,Times(e,x)),q)),Times(CN1,f,Power(Plus(d,Times(e,x)),Plus(q,Negate(C2))),Plus(Times(b,d,e,Plus(p,C1)),Times(a,Sqr(e),Plus(m,q,Negate(C1))),Times(CN1,c,Sqr(d),Plus(m,q,Times(C2,p),C1)),Times(CN1,e,Plus(Times(C2,c,d),Times(CN1,b,e)),Plus(m,q,p),x)))),x)),x),x)),And(GtQ(q,C1),NeQ(Plus(m,q,Times(C2,p),C1),C0)))),And(FreeQ(List(a,b,c,d,e,m,p),x),PolyQ($s("§pq"),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),Not(And(IGtQ(m,C0),RationalQ(a,b,c,d,e),Or(IntegerQ(p),ILtQ(Plus(p,C1D2),C0))))))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus(d_,Times(e_DEFAULT,x_)),m_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(With(List(Set(q,Expon($s("§pq"),x)),Set(f,Coeff($s("§pq"),x,Expon($s("§pq"),x)))),Condition(Plus(Simp(Times(f,Power(Plus(d,Times(e,x)),Plus(m,q,Negate(C1))),Power(Plus(a,Times(c,Sqr(x))),Plus(p,C1)),Power(Times(c,Power(e,Plus(q,Negate(C1))),Plus(m,q,Times(C2,p),C1)),-1)),x),Dist(Power(Times(c,Power(e,q),Plus(m,q,Times(C2,p),C1)),-1),Int(Times(Power(Plus(d,Times(e,x)),m),Power(Plus(a,Times(c,Sqr(x))),p),ExpandToSum(Plus(Times(c,Power(e,q),Plus(m,q,Times(C2,p),C1),$s("§pq")),Times(CN1,c,f,Plus(m,q,Times(C2,p),C1),Power(Plus(d,Times(e,x)),q)),Times(CN1,f,Power(Plus(d,Times(e,x)),Plus(q,Negate(C2))),Plus(Times(a,Sqr(e),Plus(m,q,Negate(C1))),Times(CN1,c,Sqr(d),Plus(m,q,Times(C2,p),C1)),Times(CN1,C2,c,d,e,Plus(m,q,p),x)))),x)),x),x)),And(GtQ(q,C1),NeQ(Plus(m,q,Times(C2,p),C1),C0)))),And(FreeQ(List(a,c,d,e,m,p),x),PolyQ($s("§pq"),x),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),Not(And(EqQ(d,C0),True)),Not(And(IGtQ(m,C0),RationalQ(a,c,d,e),Or(IntegerQ(p),ILtQ(Plus(p,C1D2),C0))))))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus(d_DEFAULT,Times(e_DEFAULT,x_)),m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(With(List(Set(q,Expon($s("§pq"),x))),Plus(Dist(Times(Coeff($s("§pq"),x,q),Power(Power(e,q),-1)),Int(Times(Power(Plus(d,Times(e,x)),Plus(m,q)),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),p)),x),x),Dist(Power(Power(e,q),-1),Int(Times(Power(Plus(d,Times(e,x)),m),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),p),ExpandToSum(Plus(Times(Power(e,q),$s("§pq")),Times(CN1,Coeff($s("§pq"),x,q),Power(Plus(d,Times(e,x)),q))),x)),x),x))),And(FreeQ(List(a,b,c,d,e,m,p),x),PolyQ($s("§pq"),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),Not(And(IGtQ(m,C0),RationalQ(a,b,c,d,e),Or(IntegerQ(p),ILtQ(Plus(p,C1D2),C0))))))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus(d_,Times(e_DEFAULT,x_)),m_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(With(List(Set(q,Expon($s("§pq"),x))),Plus(Dist(Times(Coeff($s("§pq"),x,q),Power(Power(e,q),-1)),Int(Times(Power(Plus(d,Times(e,x)),Plus(m,q)),Power(Plus(a,Times(c,Sqr(x))),p)),x),x),Dist(Power(Power(e,q),-1),Int(Times(Power(Plus(d,Times(e,x)),m),Power(Plus(a,Times(c,Sqr(x))),p),ExpandToSum(Plus(Times(Power(e,q),$s("§pq")),Times(CN1,Coeff($s("§pq"),x,q),Power(Plus(d,Times(e,x)),q))),x)),x),x))),And(FreeQ(List(a,c,d,e,m,p),x),PolyQ($s("§pq"),x),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),Not(And(IGtQ(m,C0),RationalQ(a,c,d,e),Or(IntegerQ(p),ILtQ(Plus(p,C1D2),C0))))))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus(a_,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))),p_DEFAULT)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times($s("§pq"),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),p)),x),x),And(FreeQ(List(a,b,c),x),PolyQ($s("§pq"),x),IGtQ(p,CN2)))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Int(Times(x,PolynomialQuotient($s("§pq"),x,x),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),p)),x),And(FreeQ(List(a,b,c,p),x),PolyQ($s("§pq"),x),EqQ(Coeff($s("§pq"),x,C0),C0),Not(MatchQ($s("§pq"),Condition(Times(Power(x,m_DEFAULT),u_DEFAULT),IntegerQ(m))))))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus(a_,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(Dist(Times(Power(Plus(a,Times(b,x),Times(c,Sqr(x))),FracPart(p)),Power(Times(Power(Times(C4,c),IntPart(p)),Power(Plus(b,Times(C2,c,x)),Times(C2,FracPart(p)))),-1)),Int(Times($s("§pq"),Power(Plus(b,Times(C2,c,x)),Times(C2,p))),x),x),And(FreeQ(List(a,b,c,p),x),PolyQ($s("§pq"),x),EqQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0)))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(With(List(Set($s("Q"),PolynomialQuotient($s("§pq"),Plus(a,Times(b,x),Times(c,Sqr(x))),x)),Set(f,Coeff(PolynomialRemainder($s("§pq"),Plus(a,Times(b,x),Times(c,Sqr(x))),x),x,C0)),Set(g,Coeff(PolynomialRemainder($s("§pq"),Plus(a,Times(b,x),Times(c,Sqr(x))),x),x,C1))),Plus(Simp(Times(Plus(Times(b,f),Times(CN1,C2,a,g),Times(Plus(Times(C2,c,f),Times(CN1,b,g)),x)),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),Plus(p,C1)),Power(Times(Plus(p,C1),Plus(Sqr(b),Times(CN1,C4,a,c))),-1)),x),Dist(Power(Times(Plus(p,C1),Plus(Sqr(b),Times(CN1,C4,a,c))),-1),Int(Times(Power(Plus(a,Times(b,x),Times(c,Sqr(x))),Plus(p,C1)),ExpandToSum(Plus(Times(Plus(p,C1),Plus(Sqr(b),Times(CN1,C4,a,c)),$s("Q")),Times(CN1,Plus(Times(C2,p),C3),Plus(Times(C2,c,f),Times(CN1,b,g)))),x)),x),x))),And(FreeQ(List(a,b,c),x),PolyQ($s("§pq"),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),LtQ(p,CN1)))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_),Times(c_DEFAULT,Sqr(x_))),p_)),x_Symbol),
    Condition(With(List(Set(q,Expon($s("§pq"),x)),Set(e,Coeff($s("§pq"),x,Expon($s("§pq"),x)))),Plus(Simp(Times(e,Power(x,Plus(q,Negate(C1))),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),Plus(p,C1)),Power(Times(c,Plus(q,Times(C2,p),C1)),-1)),x),Dist(Power(Times(c,Plus(q,Times(C2,p),C1)),-1),Int(Times(Power(Plus(a,Times(b,x),Times(c,Sqr(x))),p),ExpandToSum(Plus(Times(c,Plus(q,Times(C2,p),C1),$s("§pq")),Times(CN1,a,e,Plus(q,Negate(C1)),Power(x,Plus(q,Negate(C2)))),Times(CN1,b,e,Plus(q,p),Power(x,Plus(q,Negate(C1)))),Times(CN1,c,e,Plus(q,Times(C2,p),C1),Power(x,q))),x)),x),x))),And(FreeQ(List(a,b,c,p),x),PolyQ($s("§pq"),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),Not(LeQ(p,CN1))))),
ISetDelayed(Int(Times($p("§pq"),Power(Times(d_DEFAULT,x_),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_)),x_Symbol),
    Condition(Module(List(Set(q,Expon($s("§pq"),x)),k),Plus(Int(Times(Power(Times(d,x),m),Sum(Times(Coeff($s("§pq"),x,Times(C2,k)),Power(x,Times(C2,k))),List(k,C0,Plus(Times(C1D2,q),C1))),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),p)),x),Dist(Power(d,-1),Int(Times(Power(Times(d,x),Plus(m,C1)),Sum(Times(Coeff($s("§pq"),x,Plus(Times(C2,k),C1)),Power(x,Times(C2,k))),List(k,C0,Plus(Times(C1D2,Plus(q,Negate(C1))),C1))),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),p)),x),x))),And(FreeQ(List(a,b,c,d,m,p),x),PolyQ($s("§pq"),x),Not(PolyQ($s("§pq"),Sqr(x)))))),
ISetDelayed(Int(Times($p("§pq"),Power(x_,m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_)),x_Symbol),
    Condition(Dist(C1D2,Subst(Int(Times(Power(x,Times(C1D2,Plus(m,Negate(C1)))),SubstFor(Sqr(x),$s("§pq"),x),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),p)),x),x,Sqr(x)),x),And(FreeQ(List(a,b,c,p),x),PolyQ($s("§pq"),Sqr(x)),IntegerQ(Times(C1D2,Plus(m,Negate(C1))))))),
ISetDelayed(Int(Times($p("§pq"),Power(Times(d_DEFAULT,x_),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_DEFAULT)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times(Power(Times(d,x),m),$s("§pq"),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),p)),x),x),And(FreeQ(List(a,b,c,d,m),x),PolyQ($s("§pq"),Sqr(x)),IGtQ(p,CN2)))),
ISetDelayed(Int(Times($p("§pq"),Power(Times(d_DEFAULT,x_),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_)),x_Symbol),
    Condition(Dist(Power(d,-2),Int(Times(Power(Times(d,x),Plus(m,C2)),ExpandToSum(Times($s("§pq"),Power(x,-2)),x),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),p)),x),x),And(FreeQ(List(a,b,c,d,m,p),x),PolyQ($s("§pq"),Sqr(x)),EqQ(Coeff($s("§pq"),x,C0),C0)))),
ISetDelayed(Int(Times($p("§pq"),Power(Times(d_DEFAULT,x_),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_DEFAULT)),x_Symbol),
    Condition(With(List(Set(e,Coeff($s("§pq"),x,C0)),Set(f,Coeff($s("§pq"),x,C2)),Set(g,Coeff($s("§pq"),x,C4))),Condition(Simp(Times(e,Power(Times(d,x),Plus(m,C1)),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),Plus(p,C1)),Power(Times(a,d,Plus(m,C1)),-1)),x),And(EqQ(Plus(Times(a,f,Plus(m,C1)),Times(CN1,b,e,Plus(m,Times(C2,p),C3))),C0),EqQ(Plus(Times(a,g,Plus(m,C1)),Times(CN1,c,e,Plus(m,Times(C4,p),C5))),C0),NeQ(m,CN1)))),And(FreeQ(List(a,b,c,d,m,p),x),PolyQ($s("§pq"),Sqr(x)),EqQ(Expon($s("§pq"),x),C4)))),
ISetDelayed(Int(Times($p("§pq"),Power(Times(d_DEFAULT,x_),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_)),x_Symbol),
    Condition(Dist(Times(Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),FracPart(p)),Power(Times(Power(Times(C4,c),IntPart(p)),Power(Plus(b,Times(C2,c,Sqr(x))),Times(C2,FracPart(p)))),-1)),Int(Times(Power(Times(d,x),m),$s("§pq"),Power(Plus(b,Times(C2,c,Sqr(x))),Times(C2,p))),x),x),And(FreeQ(List(a,b,c,d,m,p),x),PolyQ($s("§pq"),Sqr(x)),GtQ(Expon($s("§pq"),Sqr(x)),C1),EqQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0)))),
ISetDelayed(Int(Times($p("§pq"),Power(x_,m_),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_)),x_Symbol),
    Condition(With(List(Set(d,Coeff(PolynomialRemainder(Times(Power(x,m),$s("§pq")),Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),x),x,C0)),Set(e,Coeff(PolynomialRemainder(Times(Power(x,m),$s("§pq")),Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),x),x,C2))),Plus(Simp(Times(x,Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),Plus(p,C1)),Plus(Times(a,b,e),Times(CN1,d,Plus(Sqr(b),Times(CN1,C2,a,c))),Times(CN1,c,Plus(Times(b,d),Times(CN1,C2,a,e)),Sqr(x))),Power(Times(C2,a,Plus(p,C1),Plus(Sqr(b),Times(CN1,C4,a,c))),-1)),x),Dist(Power(Times(C2,a,Plus(p,C1),Plus(Sqr(b),Times(CN1,C4,a,c))),-1),Int(Times(Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),Plus(p,C1)),ExpandToSum(Plus(Times(C2,a,Plus(p,C1),Plus(Sqr(b),Times(CN1,C4,a,c)),PolynomialQuotient(Times(Power(x,m),$s("§pq")),Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),x)),Times(Sqr(b),d,Plus(Times(C2,p),C3)),Times(CN1,C2,a,c,d,Plus(Times(C4,p),C5)),Times(CN1,a,b,e),Times(c,Plus(Times(C4,p),C7),Plus(Times(b,d),Times(CN1,C2,a,e)),Sqr(x))),x)),x),x))),And(FreeQ(List(a,b,c),x),PolyQ($s("§pq"),Sqr(x)),GtQ(Expon($s("§pq"),Sqr(x)),C1),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),LtQ(p,CN1),IGtQ(Times(C1D2,m),C0)))),
ISetDelayed(Int(Times($p("§pq"),Power(x_,m_),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_)),x_Symbol),
    Condition(With(List(Set(d,Coeff(PolynomialRemainder(Times(Power(x,m),$s("§pq")),Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),x),x,C0)),Set(e,Coeff(PolynomialRemainder(Times(Power(x,m),$s("§pq")),Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),x),x,C2))),Plus(Simp(Times(x,Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),Plus(p,C1)),Plus(Times(a,b,e),Times(CN1,d,Plus(Sqr(b),Times(CN1,C2,a,c))),Times(CN1,c,Plus(Times(b,d),Times(CN1,C2,a,e)),Sqr(x))),Power(Times(C2,a,Plus(p,C1),Plus(Sqr(b),Times(CN1,C4,a,c))),-1)),x),Dist(Power(Times(C2,a,Plus(p,C1),Plus(Sqr(b),Times(CN1,C4,a,c))),-1),Int(Times(Power(x,m),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),Plus(p,C1)),ExpandToSum(Plus(Times(C2,a,Plus(p,C1),Plus(Sqr(b),Times(CN1,C4,a,c)),PolynomialQuotient(Times(Power(x,m),$s("§pq")),Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),x),Power(Power(x,m),-1)),Times(Plus(Times(Sqr(b),d,Plus(Times(C2,p),C3)),Times(CN1,C2,a,c,d,Plus(Times(C4,p),C5)),Times(CN1,a,b,e)),Power(Power(x,m),-1)),Times(c,Plus(Times(C4,p),C7),Plus(Times(b,d),Times(CN1,C2,a,e)),Power(x,Plus(C2,Negate(m))))),x)),x),x))),And(FreeQ(List(a,b,c),x),PolyQ($s("§pq"),Sqr(x)),GtQ(Expon($s("§pq"),Sqr(x)),C1),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),LtQ(p,CN1),ILtQ(Times(C1D2,m),C0)))),
ISetDelayed(Int(Times($p("§pq"),Power(Times(d_DEFAULT,x_),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_DEFAULT)),x_Symbol),
    Condition(Unintegrable(Times($s("§pq"),Power(Times(d,x),m),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),p)),x),And(FreeQ(List(a,b,c,d,m,p),x),PolyQ($s("§pq"),x)))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_DEFAULT)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times($s("§pq"),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),p)),x),x),And(FreeQ(List(a,b,c),x),PolyQ($s("§pq"),x),IGtQ(p,C0)))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_)),x_Symbol),
    Condition(Int(Times(x,PolynomialQuotient($s("§pq"),x,x),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),p)),x),And(FreeQ(List(a,b,c,p),x),PolyQ($s("§pq"),x),EqQ(Coeff($s("§pq"),x,C0),C0),Not(MatchQ($s("§pq"),Condition(Times(Power(x,m_DEFAULT),u_DEFAULT),IntegerQ(m))))))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_)),x_Symbol),
    Condition(Module(List(Set(q,Expon($s("§pq"),x)),k),Plus(Int(Times(Sum(Times(Coeff($s("§pq"),x,Times(C2,k)),Power(x,Times(C2,k))),List(k,C0,Times(C1D2,q))),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),p)),x),Int(Times(x,Sum(Times(Coeff($s("§pq"),x,Plus(Times(C2,k),C1)),Power(x,Times(C2,k))),List(k,C0,Times(C1D2,Plus(q,Negate(C1))))),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),p)),x))),And(FreeQ(List(a,b,c,p),x),PolyQ($s("§pq"),x),Not(PolyQ($s("§pq"),Sqr(x)))))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_DEFAULT)),x_Symbol),
    Condition(With(List(Set(d,Coeff($s("§pq"),x,C0)),Set(e,Coeff($s("§pq"),x,C2)),Set(f,Coeff($s("§pq"),x,C4))),Condition(Simp(Times(d,x,Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),Plus(p,C1)),Power(a,-1)),x),And(EqQ(Plus(Times(a,e),Times(CN1,b,d,Plus(Times(C2,p),C3))),C0),EqQ(Plus(Times(a,f),Times(CN1,c,d,Plus(Times(C4,p),C5))),C0)))),And(FreeQ(List(a,b,c,p),x),PolyQ($s("§pq"),Sqr(x)),EqQ(Expon($s("§pq"),x),C4)))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_DEFAULT)),x_Symbol),
    Condition(With(List(Set(d,Coeff($s("§pq"),x,C0)),Set(e,Coeff($s("§pq"),x,C2)),Set(f,Coeff($s("§pq"),x,C4)),Set(g,Coeff($s("§pq"),x,C6))),Condition(Simp(Times(x,Plus(Times(C3,a,d),Times(Plus(Times(a,e),Times(CN1,b,d,Plus(Times(C2,p),C3))),Sqr(x))),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),Plus(p,C1)),Power(Times(C3,Sqr(a)),-1)),x),And(EqQ(Plus(Times(C3,Sqr(a),g),Times(CN1,c,Plus(Times(C4,p),C7),Plus(Times(a,e),Times(CN1,b,d,Plus(Times(C2,p),C3))))),C0),EqQ(Plus(Times(C3,Sqr(a),f),Times(CN1,C3,a,c,d,Plus(Times(C4,p),C5)),Times(CN1,b,Plus(Times(C2,p),C5),Plus(Times(a,e),Times(CN1,b,d,Plus(Times(C2,p),C3))))),C0)))),And(FreeQ(List(a,b,c,p),x),PolyQ($s("§pq"),Sqr(x)),EqQ(Expon($s("§pq"),x),C6)))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),-1)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times($s("§pq"),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),-1)),x),x),And(FreeQ(List(a,b,c),x),PolyQ($s("§pq"),Sqr(x)),Greater(Expon($s("§pq"),Sqr(x)),C1)))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_)),x_Symbol),
    Condition(Dist(Times(Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),FracPart(p)),Power(Times(Power(Times(C4,c),IntPart(p)),Power(Plus(b,Times(C2,c,Sqr(x))),Times(C2,FracPart(p)))),-1)),Int(Times($s("§pq"),Power(Plus(b,Times(C2,c,Sqr(x))),Times(C2,p))),x),x),And(FreeQ(List(a,b,c,p),x),PolyQ($s("§pq"),Sqr(x)),Greater(Expon($s("§pq"),Sqr(x)),C1),EqQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0)))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_)),x_Symbol),
    Condition(With(List(Set(d,Coeff(PolynomialRemainder($s("§pq"),Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),x),x,C0)),Set(e,Coeff(PolynomialRemainder($s("§pq"),Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),x),x,C2))),Plus(Simp(Times(x,Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),Plus(p,C1)),Plus(Times(a,b,e),Times(CN1,d,Plus(Sqr(b),Times(CN1,C2,a,c))),Times(CN1,c,Plus(Times(b,d),Times(CN1,C2,a,e)),Sqr(x))),Power(Times(C2,a,Plus(p,C1),Plus(Sqr(b),Times(CN1,C4,a,c))),-1)),x),Dist(Power(Times(C2,a,Plus(p,C1),Plus(Sqr(b),Times(CN1,C4,a,c))),-1),Int(Times(Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),Plus(p,C1)),ExpandToSum(Plus(Times(C2,a,Plus(p,C1),Plus(Sqr(b),Times(CN1,C4,a,c)),PolynomialQuotient($s("§pq"),Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),x)),Times(Sqr(b),d,Plus(Times(C2,p),C3)),Times(CN1,C2,a,c,d,Plus(Times(C4,p),C5)),Times(CN1,a,b,e),Times(c,Plus(Times(C4,p),C7),Plus(Times(b,d),Times(CN1,C2,a,e)),Sqr(x))),x)),x),x))),And(FreeQ(List(a,b,c),x),PolyQ($s("§pq"),Sqr(x)),Greater(Expon($s("§pq"),Sqr(x)),C1),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),LtQ(p,CN1)))),
ISetDelayed(Int(Times($p("§pq"),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_)),x_Symbol),
    Condition(With(List(Set(q,Expon($s("§pq"),Sqr(x))),Set(e,Coeff($s("§pq"),Sqr(x),Expon($s("§pq"),Sqr(x))))),Plus(Simp(Times(e,Power(x,Plus(Times(C2,q),Negate(C3))),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),Plus(p,C1)),Power(Times(c,Plus(Times(C2,q),Times(C4,p),C1)),-1)),x),Dist(Power(Times(c,Plus(Times(C2,q),Times(C4,p),C1)),-1),Int(Times(Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),p),ExpandToSum(Plus(Times(c,Plus(Times(C2,q),Times(C4,p),C1),$s("§pq")),Times(CN1,a,e,Plus(Times(C2,q),Negate(C3)),Power(x,Plus(Times(C2,q),Negate(C4)))),Times(CN1,b,e,Plus(Times(C2,q),Times(C2,p),Negate(C1)),Power(x,Plus(Times(C2,q),Negate(C2)))),Times(CN1,c,e,Plus(Times(C2,q),Times(C4,p),C1),Power(x,Times(C2,q)))),x)),x),x))),And(FreeQ(List(a,b,c,p),x),PolyQ($s("§pq"),Sqr(x)),Greater(Expon($s("§pq"),Sqr(x)),C1),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),Not(LtQ(p,CN1))))),
ISetDelayed(Int(Times($p("§pq"),Power($p("§q4"),p_)),x_Symbol),
    Condition(With(List(Set(a,Coeff($s("§q4"),x,C0)),Set(b,Coeff($s("§q4"),x,C1)),Set(c,Coeff($s("§q4"),x,C2)),Set(d,Coeff($s("§q4"),x,C3)),Set(e,Coeff($s("§q4"),x,C4))),Condition(Subst(Int(SimplifyIntegrand(Times(ReplaceAll($s("§pq"),Rule(x,Plus(Times(CN1,d,Power(Times(C4,e),-1)),x))),Power(Plus(a,Times(Power(d,4),Power(Times(ZZ(256L),Power(e,3)),-1)),Times(CN1,b,d,Power(Times(C8,e),-1)),Times(Plus(c,Times(CN1,C3,Sqr(d),Power(Times(C8,e),-1))),Sqr(x)),Times(e,Power(x,4))),p)),x),x),x,Plus(Times(d,Power(Times(C4,e),-1)),x)),And(EqQ(Plus(Power(d,3),Times(CN1,C4,c,d,e),Times(C8,b,Sqr(e))),C0),NeQ(d,C0)))),And(FreeQ(p,x),PolyQ($s("§pq"),x),PolyQ($s("§q4"),x,C4),Not(IGtQ(p,C0))))),
ISetDelayed(Int(Times($p("§px"),Power(x_,m_),Power(Times(Plus(d_,Times(e_DEFAULT,Sqr(x_))),Sqrt(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))))),-1)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§px"),x,C0)),Set(BSymbol,Coeff($s("§px"),x,C2)),Set(CSymbol,Coeff($s("§px"),x,C4))),Plus(Simp(Times(CSymbol,Power(x,Plus(m,Negate(C1))),Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4)))),Power(Times(c,e,Plus(m,C1)),-1)),x),Negate(Dist(Power(Times(c,e,Plus(m,C1)),-1),Int(Times(Power(x,Plus(m,Negate(C2))),Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))))),-1),Simp(Plus(Times(a,CSymbol,d,Plus(m,Negate(C1))),Times(CN1,Plus(Times(ASymbol,c,e,Plus(m,C1)),Times(CN1,CSymbol,Plus(Times(a,e,Plus(m,Negate(C1))),Times(b,d,m)))),Sqr(x)),Times(CN1,Plus(Times(BSymbol,c,e,Plus(m,C1)),Times(CN1,CSymbol,Plus(Times(b,e,m),Times(c,d,Plus(m,C1))))),Power(x,4))),x)),x),x)))),And(FreeQ(List(a,b,c,d,e),x),PolyQ($s("§px"),Sqr(x),C2),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),IGtQ(Times(C1D2,m),C0)))),
ISetDelayed(Int(Times($p("§px"),Power(x_,m_),Power(Times(Plus(d_,Times(e_DEFAULT,Sqr(x_))),Sqrt(Plus(a_,Times(c_DEFAULT,Power(x_,4))))),-1)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§px"),x,C0)),Set(BSymbol,Coeff($s("§px"),x,C2)),Set(CSymbol,Coeff($s("§px"),x,C4))),Plus(Simp(Times(CSymbol,Power(x,Plus(m,Negate(C1))),Sqrt(Plus(a,Times(c,Power(x,4)))),Power(Times(c,e,Plus(m,C1)),-1)),x),Negate(Dist(Power(Times(c,e,Plus(m,C1)),-1),Int(Times(Power(x,Plus(m,Negate(C2))),Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(a,Times(c,Power(x,4))))),-1),Simp(Plus(Times(a,CSymbol,d,Plus(m,Negate(C1))),Times(CN1,Plus(Times(ASymbol,c,e,Plus(m,C1)),Times(CN1,CSymbol,a,e,Plus(m,Negate(C1)))),Sqr(x)),Times(CN1,Plus(Times(BSymbol,c,e,Plus(m,C1)),Times(CN1,CSymbol,c,d,Plus(m,C1))),Power(x,4))),x)),x),x)))),And(FreeQ(List(a,c,d,e),x),PolyQ($s("§px"),Sqr(x),C2),IGtQ(Times(C1D2,m),C0)))),
ISetDelayed(Int(Times($p("§px"),Power(x_,m_),Power(Times(Plus(d_,Times(e_DEFAULT,Sqr(x_))),Sqrt(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))))),-1)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§px"),x,C0)),Set(BSymbol,Coeff($s("§px"),x,C2)),Set(CSymbol,Coeff($s("§px"),x,C4))),Plus(Simp(Times(ASymbol,Power(x,Plus(m,C1)),Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4)))),Power(Times(a,d,Plus(m,C1)),-1)),x),Dist(Power(Times(a,d,Plus(m,C1)),-1),Int(Times(Power(x,Plus(m,C2)),Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))))),-1),Simp(Plus(Times(a,BSymbol,d,Plus(m,C1)),Times(CN1,ASymbol,Plus(Times(a,e,Plus(m,C1)),Times(b,d,Plus(m,C2)))),Times(Plus(Times(a,CSymbol,d,Plus(m,C1)),Times(CN1,ASymbol,Plus(Times(b,e,Plus(m,C2)),Times(c,d,Plus(m,C3))))),Sqr(x)),Times(CN1,ASymbol,c,e,Plus(m,C3),Power(x,4))),x)),x),x))),And(FreeQ(List(a,b,c,d,e),x),PolyQ($s("§px"),Sqr(x),C2),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),ILtQ(Times(C1D2,m),C0)))),
ISetDelayed(Int(Times($p("§px"),Power(x_,m_),Power(Times(Plus(d_,Times(e_DEFAULT,Sqr(x_))),Sqrt(Plus(a_,Times(c_DEFAULT,Power(x_,4))))),-1)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§px"),x,C0)),Set(BSymbol,Coeff($s("§px"),x,C2)),Set(CSymbol,Coeff($s("§px"),x,C4))),Plus(Simp(Times(ASymbol,Power(x,Plus(m,C1)),Sqrt(Plus(a,Times(c,Power(x,4)))),Power(Times(a,d,Plus(m,C1)),-1)),x),Dist(Power(Times(a,d,Plus(m,C1)),-1),Int(Times(Power(x,Plus(m,C2)),Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(a,Times(c,Power(x,4))))),-1),Simp(Plus(Times(a,BSymbol,d,Plus(m,C1)),Times(CN1,ASymbol,a,e,Plus(m,C1)),Times(Plus(Times(a,CSymbol,d,Plus(m,C1)),Times(CN1,ASymbol,c,d,Plus(m,C3))),Sqr(x)),Times(CN1,ASymbol,c,e,Plus(m,C3),Power(x,4))),x)),x),x))),And(FreeQ(List(a,c,d,e),x),PolyQ($s("§px"),Sqr(x),C2),ILtQ(Times(C1D2,m),C0)))),
ISetDelayed(Int(Times($p("§px"),x_,Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_DEFAULT)),x_Symbol),
    Condition(Dist(C1D2,Subst(Int(Times(ReplaceAll($s("§px"),Rule(x,Sqrt(x))),Power(Plus(d,Times(e,x)),q),Power(Plus(a,Times(b,x),Times(c,Sqr(x))),p)),x),x,Sqr(x)),x),And(FreeQ(List(a,b,c,d,e,p,q),x),PolyQ($s("§px"),Sqr(x))))),
ISetDelayed(Int(Times($p("§pr"),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_)),x_Symbol),
    Condition(Int(Times(x,PolynomialQuotient($s("§pr"),x,x),Power(Plus(d,Times(e,Sqr(x))),q),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),p)),x),And(FreeQ(List(a,b,c,d,e,p,q),x),PolyQ($s("§pr"),x),EqQ(PolynomialRemainder($s("§pr"),x,x),C0),Not(MatchQ($s("§pr"),Condition(Times(Power(x,m_DEFAULT),u_DEFAULT),IntegerQ(m))))))),
ISetDelayed(Int(Times($p("§pr"),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_)),x_Symbol),
    Condition(Module(List(Set(r,Expon($s("§pr"),x)),k),Plus(Int(Times(Sum(Times(Coeff($s("§pr"),x,Times(C2,k)),Power(x,Times(C2,k))),List(k,C0,Times(C1D2,r))),Power(Plus(d,Times(e,Sqr(x))),q),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),p)),x),Int(Times(x,Sum(Times(Coeff($s("§pr"),x,Plus(Times(C2,k),C1)),Power(x,Times(C2,k))),List(k,C0,Times(C1D2,Plus(r,Negate(C1))))),Power(Plus(d,Times(e,Sqr(x))),q),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),p)),x))),And(FreeQ(List(a,b,c,d,e,p,q),x),PolyQ($s("§pr"),x),Not(PolyQ($s("§pr"),Sqr(x)))))),
ISetDelayed(Int(Times($p("§px"),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_DEFAULT)),x_Symbol),
    Condition(Int(Times($s("§px"),Power(Plus(d,Times(e,Sqr(x))),Plus(p,q)),Power(Plus(Times(a,Power(d,-1)),Times(c,Sqr(x),Power(e,-1))),p)),x),And(FreeQ(List(a,b,c,d,e,q),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),EqQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),IntegerQ(p),Or(PolyQ($s("§px"),Sqr(x)),MatchQ($s("§px"),Condition(Power(Plus(f_,Times(g_DEFAULT,Sqr(x))),r_DEFAULT),FreeQ(List(f,g,r),x))))))),
ISetDelayed(Int(Times($p("§px"),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),p_DEFAULT)),x_Symbol),
    Condition(Int(Times($s("§px"),Power(Plus(d,Times(e,Sqr(x))),Plus(p,q)),Power(Plus(Times(a,Power(d,-1)),Times(c,Sqr(x),Power(e,-1))),p)),x),And(FreeQ(List(a,c,d,e,q),x),EqQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),IntegerQ(p),Or(PolyQ($s("§px"),Sqr(x)),MatchQ($s("§px"),Condition(Power(Plus(f_,Times(g_DEFAULT,Sqr(x))),r_DEFAULT),FreeQ(List(f,g,r),x))))))),
ISetDelayed(Int(Times($p("§px"),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_)),x_Symbol),
    Condition(Dist(Times(Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),FracPart(p)),Power(Times(Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Plus(Times(a,Power(d,-1)),Times(c,Sqr(x),Power(e,-1))),FracPart(p))),-1)),Int(Times($s("§px"),Power(Plus(d,Times(e,Sqr(x))),Plus(p,q)),Power(Plus(Times(a,Power(d,-1)),Times(c,Sqr(x),Power(e,-1))),p)),x),x),And(FreeQ(List(a,b,c,d,e,p,q),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),EqQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),Not(IntegerQ(p)),Or(PolyQ($s("§px"),Sqr(x)),MatchQ($s("§px"),Condition(Power(Plus(f_,Times(g_DEFAULT,Sqr(x))),r_DEFAULT),FreeQ(List(f,g,r),x))))))),
ISetDelayed(Int(Times($p("§px"),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),p_)),x_Symbol),
    Condition(Dist(Times(Power(Plus(a,Times(c,Power(x,4))),FracPart(p)),Power(Times(Power(Plus(d,Times(e,Sqr(x))),FracPart(p)),Power(Plus(Times(a,Power(d,-1)),Times(c,Sqr(x),Power(e,-1))),FracPart(p))),-1)),Int(Times($s("§px"),Power(Plus(d,Times(e,Sqr(x))),Plus(p,q)),Power(Plus(Times(a,Power(d,-1)),Times(c,Sqr(x),Power(e,-1))),p)),x),x),And(FreeQ(List(a,c,d,e,p,q),x),EqQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),Not(IntegerQ(p)),Or(PolyQ($s("§px"),Sqr(x)),MatchQ($s("§px"),Condition(Power(Plus(f_,Times(g_DEFAULT,Sqr(x))),r_DEFAULT),FreeQ(List(f,g,r),x))))))),
ISetDelayed(Int(Times($p("§px"),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),p_DEFAULT)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times($s("§px"),Power(Plus(d,Times(e,Sqr(x))),q),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),p)),x),x),And(FreeQ(List(a,b,c,d,e,q),x),PolyQ($s("§px"),Sqr(x)),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),IntegerQ(p)))),
ISetDelayed(Int(Times($p("§px"),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_DEFAULT),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),p_DEFAULT)),x_Symbol),
    Condition(Int(ExpandIntegrand(Times($s("§px"),Power(Plus(d,Times(e,Sqr(x))),q),Power(Plus(a,Times(c,Power(x,4))),p)),x),x),And(FreeQ(List(a,c,d,e,q),x),PolyQ($s("§px"),Sqr(x)),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),IntegerQ(p)))),
ISetDelayed(Int(Times($p("§p4x"),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§p4x"),x,C0)),Set(BSymbol,Coeff($s("§p4x"),x,C2)),Set(CSymbol,Coeff($s("§p4x"),x,C4))),Plus(Simp(Times(CSymbol,x,Power(Plus(d,Times(e,Sqr(x))),q),Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4)))),Power(Times(c,Plus(Times(C2,q),C3)),-1)),x),Dist(Power(Times(c,Plus(Times(C2,q),C3)),-1),Int(Times(Power(Plus(d,Times(e,Sqr(x))),Plus(q,Negate(C1))),Simp(Plus(Times(ASymbol,c,d,Plus(Times(C2,q),C3)),Times(CN1,a,CSymbol,d),Times(Plus(Times(c,Plus(Times(BSymbol,d),Times(ASymbol,e)),Plus(Times(C2,q),C3)),Times(CN1,CSymbol,Plus(Times(C2,b,d),Times(a,e),Times(C2,a,e,q)))),Sqr(x)),Times(Plus(Times(BSymbol,c,e,Plus(Times(C2,q),C3)),Times(CN1,C2,CSymbol,Plus(Times(b,e),Times(CN1,c,d,q),Times(b,e,q)))),Power(x,4))),x),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),CN1D2)),x),x))),And(FreeQ(List(a,b,c,d,e),x),PolyQ($s("§p4x"),Sqr(x)),EqQ(Expon($s("§p4x"),x),C4),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),IGtQ(q,C0)))),
ISetDelayed(Int(Times($p("§p4x"),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§p4x"),x,C0)),Set(BSymbol,Coeff($s("§p4x"),x,C2)),Set(CSymbol,Coeff($s("§p4x"),x,C4))),Plus(Simp(Times(CSymbol,x,Power(Plus(d,Times(e,Sqr(x))),q),Sqrt(Plus(a,Times(c,Power(x,4)))),Power(Times(c,Plus(Times(C2,q),C3)),-1)),x),Dist(Power(Times(c,Plus(Times(C2,q),C3)),-1),Int(Times(Power(Plus(d,Times(e,Sqr(x))),Plus(q,Negate(C1))),Simp(Plus(Times(ASymbol,c,d,Plus(Times(C2,q),C3)),Times(CN1,a,CSymbol,d),Times(Plus(Times(c,Plus(Times(BSymbol,d),Times(ASymbol,e)),Plus(Times(C2,q),C3)),Times(CN1,a,CSymbol,e,Plus(Times(C2,q),C1))),Sqr(x)),Times(Plus(Times(BSymbol,c,e,Plus(Times(C2,q),C3)),Times(C2,c,CSymbol,d,q)),Power(x,4))),x),Power(Plus(a,Times(c,Power(x,4))),CN1D2)),x),x))),And(FreeQ(List(a,c,d,e),x),PolyQ($s("§p4x"),Sqr(x)),EqQ(Expon($s("§p4x"),x),C4),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),IGtQ(q,C0)))),
ISetDelayed(Int(Times($p("§p4x"),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_),Power(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§p4x"),x,C0)),Set(BSymbol,Coeff($s("§p4x"),x,C2)),Set(CSymbol,Coeff($s("§p4x"),x,C4))),Plus(Negate(Simp(Times(Plus(Times(CSymbol,Sqr(d)),Times(CN1,BSymbol,d,e),Times(ASymbol,Sqr(e))),x,Power(Plus(d,Times(e,Sqr(x))),Plus(q,C1)),Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4)))),Power(Times(C2,d,Plus(q,C1),Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e)))),-1)),x)),Dist(Power(Times(C2,d,Plus(q,C1),Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e)))),-1),Int(Times(Power(Plus(d,Times(e,Sqr(x))),Plus(q,C1)),Simp(Plus(Times(a,d,Plus(Times(CSymbol,d),Times(CN1,BSymbol,e))),Times(ASymbol,Plus(Times(a,Sqr(e),Plus(Times(C2,q),C3)),Times(C2,d,Plus(Times(c,d),Times(CN1,b,e)),Plus(q,C1)))),Times(CN1,C2,Plus(Times(Plus(Times(BSymbol,d),Times(CN1,ASymbol,e)),Plus(Times(b,e,Plus(q,C2)),Times(CN1,c,d,Plus(q,C1)))),Times(CN1,CSymbol,d,Plus(Times(b,d),Times(a,e,Plus(q,C1))))),Sqr(x)),Times(c,Plus(Times(CSymbol,Sqr(d)),Times(CN1,BSymbol,d,e),Times(ASymbol,Sqr(e))),Plus(Times(C2,q),C5),Power(x,4))),x),Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),CN1D2)),x),x))),And(FreeQ(List(a,b,c,d,e),x),PolyQ($s("§p4x"),Sqr(x)),LeQ(Expon($s("§p4x"),x),C4),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),ILtQ(q,CN1)))),
ISetDelayed(Int(Times($p("§p4x"),Power(Plus(d_,Times(e_DEFAULT,Sqr(x_))),q_),Power(Plus(a_,Times(c_DEFAULT,Power(x_,4))),CN1D2)),x_Symbol),
    Condition(With(List(Set(ASymbol,Coeff($s("§p4x"),x,C0)),Set(BSymbol,Coeff($s("§p4x"),x,C2)),Set(CSymbol,Coeff($s("§p4x"),x,C4))),Plus(Negate(Simp(Times(Plus(Times(CSymbol,Sqr(d)),Times(CN1,BSymbol,d,e),Times(ASymbol,Sqr(e))),x,Power(Plus(d,Times(e,Sqr(x))),Plus(q,C1)),Sqrt(Plus(a,Times(c,Power(x,4)))),Power(Times(C2,d,Plus(q,C1),Plus(Times(c,Sqr(d)),Times(a,Sqr(e)))),-1)),x)),Dist(Power(Times(C2,d,Plus(q,C1),Plus(Times(c,Sqr(d)),Times(a,Sqr(e)))),-1),Int(Times(Power(Plus(d,Times(e,Sqr(x))),Plus(q,C1)),Simp(Plus(Times(a,d,Plus(Times(CSymbol,d),Times(CN1,BSymbol,e))),Times(ASymbol,Plus(Times(a,Sqr(e),Plus(Times(C2,q),C3)),Times(C2,c,Sqr(d),Plus(q,C1)))),Times(C2,d,Plus(Times(BSymbol,c,d),Times(CN1,ASymbol,c,e),Times(a,CSymbol,e)),Plus(q,C1),Sqr(x)),Times(c,Plus(Times(CSymbol,Sqr(d)),Times(CN1,BSymbol,d,e),Times(ASymbol,Sqr(e))),Plus(Times(C2,q),C5),Power(x,4))),x),Power(Plus(a,Times(c,Power(x,4))),CN1D2)),x),x))),And(FreeQ(List(a,c,d,e),x),PolyQ($s("§p4x"),Sqr(x)),LeQ(Expon($s("§p4x"),x),C4),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),ILtQ(q,CN1)))),
ISetDelayed(Int(Times(Plus(A_,Times(B_DEFAULT,Sqr(x_))),Power(Times(Plus(d_,Times(e_DEFAULT,Sqr(x_))),Sqrt(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))))),-1)),x_Symbol),
    Condition(Dist(ASymbol,Subst(Int(Power(Plus(d,Times(CN1,Plus(Times(b,d),Times(CN1,C2,a,e)),Sqr(x))),-1),x),x,Times(x,Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),CN1D2))),x),And(FreeQ(List(a,b,c,d,e,ASymbol,BSymbol),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),EqQ(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),C0),EqQ(Plus(Times(BSymbol,d),Times(ASymbol,e)),C0)))),
ISetDelayed(Int(Times(Plus(A_,Times(B_DEFAULT,Sqr(x_))),Power(Times(Plus(d_,Times(e_DEFAULT,Sqr(x_))),Sqrt(Plus(a_,Times(c_DEFAULT,Power(x_,4))))),-1)),x_Symbol),
    Condition(Dist(ASymbol,Subst(Int(Power(Plus(d,Times(C2,a,e,Sqr(x))),-1),x),x,Times(x,Power(Plus(a,Times(c,Power(x,4))),CN1D2))),x),And(FreeQ(List(a,c,d,e,ASymbol,BSymbol),x),NeQ(Plus(Times(c,Sqr(d)),Times(a,Sqr(e))),C0),EqQ(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),C0),EqQ(Plus(Times(BSymbol,d),Times(ASymbol,e)),C0)))),
ISetDelayed(Int(Times(Plus(A_,Times(B_DEFAULT,Sqr(x_))),Power(Times(Plus(d_,Times(e_DEFAULT,Sqr(x_))),Sqrt(Plus(a_,Times(b_DEFAULT,Sqr(x_)),Times(c_DEFAULT,Power(x_,4))))),-1)),x_Symbol),
    Condition(Plus(Dist(Times(Plus(Times(BSymbol,d),Times(ASymbol,e)),Power(Times(C2,d,e),-1)),Int(Power(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))),CN1D2),x),x),Negate(Dist(Times(Plus(Times(BSymbol,d),Times(CN1,ASymbol,e)),Power(Times(C2,d,e),-1)),Int(Times(Plus(d,Times(CN1,e,Sqr(x))),Power(Times(Plus(d,Times(e,Sqr(x))),Sqrt(Plus(a,Times(b,Sqr(x)),Times(c,Power(x,4))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,ASymbol,BSymbol),x),NeQ(Plus(Sqr(b),Times(CN1,C4,a,c)),C0),NeQ(Plus(Times(c,Sqr(d)),Times(CN1,b,d,e),Times(a,Sqr(e))),C0),EqQ(Plus(Times(c,Sqr(d)),Times(CN1,a,Sqr(e))),C0),NeQ(Plus(Times(BSymbol,d),Times(ASymbol,e)),C0))))
  );
}
