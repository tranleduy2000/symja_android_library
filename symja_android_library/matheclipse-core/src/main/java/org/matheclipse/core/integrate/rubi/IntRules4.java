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
public class IntRules4 { 

	public static void initialize() {
		Initializer.init();
	}

	private static class Initializer  {

		private static void init() {
IIntegrate(201,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),-1),x_Symbol),
    Condition(Module(List(Set(r,Numerator(Rt(Times(a,Power(b,-1)),n))),Set(s,Denominator(Rt(Times(a,Power(b,-1)),n))),k,u),Simp(CompoundExpression(Set(u,Int(Times(Plus(r,Times(CN1,s,Cos(Times(Plus(Times(C2,k),Negate(C1)),Pi,Power(n,-1))),x)),Power(Plus(Sqr(r),Times(CN1,C2,r,s,Cos(Times(Plus(Times(C2,k),Negate(C1)),Pi,Power(n,-1))),x),Times(Sqr(s),Sqr(x))),-1)),x)),Plus(Times(r,Int(Power(Plus(r,Times(s,x)),-1),x),Power(Times(a,n),-1)),Dist(Times(C2,r,Power(Times(a,n),-1)),Sum(u,List(k,C1,Times(C1D2,Plus(n,Negate(C1))))),x))),x)),And(FreeQ(List(a,b),x),IGtQ(Times(C1D2,Plus(n,Negate(C3))),C0),PosQ(Times(a,Power(b,-1))))));
IIntegrate(202,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),-1),x_Symbol),
    Condition(Module(List(Set(r,Numerator(Rt(Times(CN1,a,Power(b,-1)),n))),Set(s,Denominator(Rt(Times(CN1,a,Power(b,-1)),n))),k,u),Simp(CompoundExpression(Set(u,Int(Times(Plus(r,Times(s,Cos(Times(Plus(Times(C2,k),Negate(C1)),Pi,Power(n,-1))),x)),Power(Plus(Sqr(r),Times(C2,r,s,Cos(Times(Plus(Times(C2,k),Negate(C1)),Pi,Power(n,-1))),x),Times(Sqr(s),Sqr(x))),-1)),x)),Plus(Times(r,Int(Power(Plus(r,Times(CN1,s,x)),-1),x),Power(Times(a,n),-1)),Dist(Times(C2,r,Power(Times(a,n),-1)),Sum(u,List(k,C1,Times(C1D2,Plus(n,Negate(C1))))),x))),x)),And(FreeQ(List(a,b),x),IGtQ(Times(C1D2,Plus(n,Negate(C3))),C0),NegQ(Times(a,Power(b,-1))))));
IIntegrate(203,Int(Power(Plus(a_,Times(b_DEFAULT,Sqr(x_))),-1),x_Symbol),
    Condition(Simp(Times(C1,ArcTan(Times(Rt(b,C2),x,Power(Rt(a,C2),-1))),Power(Times(Rt(a,C2),Rt(b,C2)),-1)),x),And(FreeQ(List(a,b),x),PosQ(Times(a,Power(b,-1))),Or(GtQ(a,C0),GtQ(b,C0)))));
IIntegrate(204,Int(Power(Plus(a_,Times(b_DEFAULT,Sqr(x_))),-1),x_Symbol),
    Condition(Negate(Simp(Times(ArcTan(Times(Rt(Negate(b),C2),x,Power(Rt(Negate(a),C2),-1))),Power(Times(Rt(Negate(a),C2),Rt(Negate(b),C2)),-1)),x)),And(FreeQ(List(a,b),x),PosQ(Times(a,Power(b,-1))),Or(LtQ(a,C0),LtQ(b,C0)))));
IIntegrate(205,Int(Power(Plus(a_,Times(b_DEFAULT,Sqr(x_))),-1),x_Symbol),
    Condition(Simp(Times(Rt(Times(a,Power(b,-1)),C2),ArcTan(Times(x,Power(Rt(Times(a,Power(b,-1)),C2),-1))),Power(a,-1)),x),And(FreeQ(List(a,b),x),PosQ(Times(a,Power(b,-1))))));
IIntegrate(206,Int(Power(Plus(a_,Times(b_DEFAULT,Sqr(x_))),-1),x_Symbol),
    Condition(Simp(Times(C1,ArcTanh(Times(Rt(Negate(b),C2),x,Power(Rt(a,C2),-1))),Power(Times(Rt(a,C2),Rt(Negate(b),C2)),-1)),x),And(FreeQ(List(a,b),x),NegQ(Times(a,Power(b,-1))),Or(GtQ(a,C0),LtQ(b,C0)))));
IIntegrate(207,Int(Power(Plus(a_,Times(b_DEFAULT,Sqr(x_))),-1),x_Symbol),
    Condition(Negate(Simp(Times(ArcTanh(Times(Rt(b,C2),x,Power(Rt(Negate(a),C2),-1))),Power(Times(Rt(Negate(a),C2),Rt(b,C2)),-1)),x)),And(FreeQ(List(a,b),x),NegQ(Times(a,Power(b,-1))),Or(LtQ(a,C0),GtQ(b,C0)))));
IIntegrate(208,Int(Power(Plus(a_,Times(b_DEFAULT,Sqr(x_))),-1),x_Symbol),
    Condition(Simp(Times(Rt(Times(CN1,a,Power(b,-1)),C2),ArcTanh(Times(x,Power(Rt(Times(CN1,a,Power(b,-1)),C2),-1))),Power(a,-1)),x),And(FreeQ(List(a,b),x),NegQ(Times(a,Power(b,-1))))));
IIntegrate(209,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),-1),x_Symbol),
    Condition(Module(List(Set(r,Numerator(Rt(Times(a,Power(b,-1)),n))),Set(s,Denominator(Rt(Times(a,Power(b,-1)),n))),k,u,v),Simp(CompoundExpression(Set(u,Plus(Int(Times(Plus(r,Times(CN1,s,Cos(Times(Plus(Times(C2,k),Negate(C1)),Pi,Power(n,-1))),x)),Power(Plus(Sqr(r),Times(CN1,C2,r,s,Cos(Times(Plus(Times(C2,k),Negate(C1)),Pi,Power(n,-1))),x),Times(Sqr(s),Sqr(x))),-1)),x),Int(Times(Plus(r,Times(s,Cos(Times(Plus(Times(C2,k),Negate(C1)),Pi,Power(n,-1))),x)),Power(Plus(Sqr(r),Times(C2,r,s,Cos(Times(Plus(Times(C2,k),Negate(C1)),Pi,Power(n,-1))),x),Times(Sqr(s),Sqr(x))),-1)),x))),Plus(Times(C2,Sqr(r),Int(Power(Plus(Sqr(r),Times(Sqr(s),Sqr(x))),-1),x),Power(Times(a,n),-1)),Dist(Times(C2,r,Power(Times(a,n),-1)),Sum(u,List(k,C1,Times(C1D4,Plus(n,Negate(C2))))),x))),x)),And(FreeQ(List(a,b),x),IGtQ(Times(C1D4,Plus(n,Negate(C2))),C0),PosQ(Times(a,Power(b,-1))))));
IIntegrate(210,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),-1),x_Symbol),
    Condition(Module(List(Set(r,Numerator(Rt(Times(CN1,a,Power(b,-1)),n))),Set(s,Denominator(Rt(Times(CN1,a,Power(b,-1)),n))),k,u),Simp(CompoundExpression(Set(u,Plus(Int(Times(Plus(r,Times(CN1,s,Cos(Times(C2,k,Pi,Power(n,-1))),x)),Power(Plus(Sqr(r),Times(CN1,C2,r,s,Cos(Times(C2,k,Pi,Power(n,-1))),x),Times(Sqr(s),Sqr(x))),-1)),x),Int(Times(Plus(r,Times(s,Cos(Times(C2,k,Pi,Power(n,-1))),x)),Power(Plus(Sqr(r),Times(C2,r,s,Cos(Times(C2,k,Pi,Power(n,-1))),x),Times(Sqr(s),Sqr(x))),-1)),x))),Plus(Times(C2,Sqr(r),Int(Power(Plus(Sqr(r),Times(CN1,Sqr(s),Sqr(x))),-1),x),Power(Times(a,n),-1)),Dist(Times(C2,r,Power(Times(a,n),-1)),Sum(u,List(k,C1,Times(C1D4,Plus(n,Negate(C2))))),x))),x)),And(FreeQ(List(a,b),x),IGtQ(Times(C1D4,Plus(n,Negate(C2))),C0),NegQ(Times(a,Power(b,-1))))));
IIntegrate(211,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,4))),-1),x_Symbol),
    Condition(With(List(Set(r,Numerator(Rt(Times(a,Power(b,-1)),C2))),Set(s,Denominator(Rt(Times(a,Power(b,-1)),C2)))),Plus(Dist(Power(Times(C2,r),-1),Int(Times(Plus(r,Times(CN1,s,Sqr(x))),Power(Plus(a,Times(b,Power(x,4))),-1)),x),x),Dist(Power(Times(C2,r),-1),Int(Times(Plus(r,Times(s,Sqr(x))),Power(Plus(a,Times(b,Power(x,4))),-1)),x),x))),And(FreeQ(List(a,b),x),Or(GtQ(Times(a,Power(b,-1)),C0),And(PosQ(Times(a,Power(b,-1))),AtomQ(SplitProduct($rubi("SumBaseQ"),a)),AtomQ(SplitProduct($rubi("SumBaseQ"),b)))))));
IIntegrate(212,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,4))),-1),x_Symbol),
    Condition(With(List(Set(r,Numerator(Rt(Times(CN1,a,Power(b,-1)),C2))),Set(s,Denominator(Rt(Times(CN1,a,Power(b,-1)),C2)))),Plus(Dist(Times(r,Power(Times(C2,a),-1)),Int(Power(Plus(r,Times(CN1,s,Sqr(x))),-1),x),x),Dist(Times(r,Power(Times(C2,a),-1)),Int(Power(Plus(r,Times(s,Sqr(x))),-1),x),x))),And(FreeQ(List(a,b),x),Not(GtQ(Times(a,Power(b,-1)),C0)))));
IIntegrate(213,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),-1),x_Symbol),
    Condition(With(List(Set(r,Numerator(Rt(Times(a,Power(b,-1)),C4))),Set(s,Denominator(Rt(Times(a,Power(b,-1)),C4)))),Plus(Dist(Times(r,Power(Times(C2,CSqrt2,a),-1)),Int(Times(Plus(Times(CSqrt2,r),Times(CN1,s,Power(x,Times(C1D4,n)))),Power(Plus(Sqr(r),Times(CN1,CSqrt2,r,s,Power(x,Times(C1D4,n))),Times(Sqr(s),Power(x,Times(C1D2,n)))),-1)),x),x),Dist(Times(r,Power(Times(C2,CSqrt2,a),-1)),Int(Times(Plus(Times(CSqrt2,r),Times(s,Power(x,Times(C1D4,n)))),Power(Plus(Sqr(r),Times(CSqrt2,r,s,Power(x,Times(C1D4,n))),Times(Sqr(s),Power(x,Times(C1D2,n)))),-1)),x),x))),And(FreeQ(List(a,b),x),IGtQ(Times(C1D4,n),C1),GtQ(Times(a,Power(b,-1)),C0))));
IIntegrate(214,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),-1),x_Symbol),
    Condition(With(List(Set(r,Numerator(Rt(Times(CN1,a,Power(b,-1)),C2))),Set(s,Denominator(Rt(Times(CN1,a,Power(b,-1)),C2)))),Plus(Dist(Times(r,Power(Times(C2,a),-1)),Int(Power(Plus(r,Times(CN1,s,Power(x,Times(C1D2,n)))),-1),x),x),Dist(Times(r,Power(Times(C2,a),-1)),Int(Power(Plus(r,Times(s,Power(x,Times(C1D2,n)))),-1),x),x))),And(FreeQ(List(a,b),x),IGtQ(Times(C1D4,n),C1),Not(GtQ(Times(a,Power(b,-1)),C0)))));
IIntegrate(215,Int(Power(Plus(a_,Times(b_DEFAULT,Sqr(x_))),CN1D2),x_Symbol),
    Condition(Simp(Times(ArcSinh(Times(Rt(b,C2),x,Power(a,CN1D2))),Power(Rt(b,C2),-1)),x),And(FreeQ(List(a,b),x),GtQ(a,C0),PosQ(b))));
IIntegrate(216,Int(Power(Plus(a_,Times(b_DEFAULT,Sqr(x_))),CN1D2),x_Symbol),
    Condition(Simp(Times(ArcSin(Times(Rt(Negate(b),C2),x,Power(a,CN1D2))),Power(Rt(Negate(b),C2),-1)),x),And(FreeQ(List(a,b),x),GtQ(a,C0),NegQ(b))));
IIntegrate(217,Int(Power(Plus(a_,Times(b_DEFAULT,Sqr(x_))),CN1D2),x_Symbol),
    Condition(Subst(Int(Power(Plus(C1,Times(CN1,b,Sqr(x))),-1),x),x,Times(x,Power(Plus(a,Times(b,Sqr(x))),CN1D2))),And(FreeQ(List(a,b),x),Not(GtQ(a,C0)))));
IIntegrate(218,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),CN1D2),x_Symbol),
    Condition(With(List(Set(r,$($s("§numer"),Rt(Times(b,Power(a,-1)),C3))),Set(s,$($s("§denom"),Rt(Times(b,Power(a,-1)),C3)))),Simp(Times(C2,Sqrt(Plus(C2,CSqrt3)),Plus(s,Times(r,x)),Sqrt(Times(Plus(Sqr(s),Times(CN1,r,s,x),Times(Sqr(r),Sqr(x))),Power(Plus(Times(Plus(C1,CSqrt3),s),Times(r,x)),-2))),EllipticF(ArcSin(Times(Plus(Times(Plus(C1,Negate(CSqrt3)),s),Times(r,x)),Power(Plus(Times(Plus(C1,CSqrt3),s),Times(r,x)),-1))),Plus(CN7,Times(CN1,C4,CSqrt3))),Power(Times(Power(C3,C1D4),r,Sqrt(Plus(a,Times(b,Power(x,3)))),Sqrt(Times(s,Plus(s,Times(r,x)),Power(Plus(Times(Plus(C1,CSqrt3),s),Times(r,x)),-2)))),-1)),x)),And(FreeQ(List(a,b),x),PosQ(a))));
IIntegrate(219,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),CN1D2),x_Symbol),
    Condition(With(List(Set(r,$($s("§numer"),Rt(Times(b,Power(a,-1)),C3))),Set(s,$($s("§denom"),Rt(Times(b,Power(a,-1)),C3)))),Simp(Times(C2,Sqrt(Plus(C2,Negate(CSqrt3))),Plus(s,Times(r,x)),Sqrt(Times(Plus(Sqr(s),Times(CN1,r,s,x),Times(Sqr(r),Sqr(x))),Power(Plus(Times(Plus(C1,Negate(CSqrt3)),s),Times(r,x)),-2))),EllipticF(ArcSin(Times(Plus(Times(Plus(C1,CSqrt3),s),Times(r,x)),Power(Plus(Times(Plus(C1,Negate(CSqrt3)),s),Times(r,x)),-1))),Plus(CN7,Times(C4,CSqrt3))),Power(Times(Power(C3,C1D4),r,Sqrt(Plus(a,Times(b,Power(x,3)))),Sqrt(Times(CN1,s,Plus(s,Times(r,x)),Power(Plus(Times(Plus(C1,Negate(CSqrt3)),s),Times(r,x)),-2)))),-1)),x)),And(FreeQ(List(a,b),x),NegQ(a))));
IIntegrate(220,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,4))),CN1D2),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(b,Power(a,-1)),C4))),Simp(Times(Plus(C1,Times(Sqr(q),Sqr(x))),Sqrt(Times(Plus(a,Times(b,Power(x,4))),Power(Times(a,Sqr(Plus(C1,Times(Sqr(q),Sqr(x))))),-1))),EllipticF(Times(C2,ArcTan(Times(q,x))),C1D2),Power(Times(C2,q,Sqrt(Plus(a,Times(b,Power(x,4))))),-1)),x)),And(FreeQ(List(a,b),x),PosQ(Times(b,Power(a,-1))))));
IIntegrate(221,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,4))),CN1D2),x_Symbol),
    Condition(Simp(Times(EllipticF(ArcSin(Times(Rt(Negate(b),C4),x,Power(Rt(a,C4),-1))),CN1),Power(Times(Rt(a,C4),Rt(Negate(b),C4)),-1)),x),And(FreeQ(List(a,b),x),NegQ(Times(b,Power(a,-1))),GtQ(a,C0))));
IIntegrate(222,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,4))),CN1D2),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(CN1,a,b),C2))),Condition(Simp(Times(Sqrt(Plus(Negate(a),Times(q,Sqr(x)))),Sqrt(Times(Plus(a,Times(q,Sqr(x))),Power(q,-1))),EllipticF(ArcSin(Times(x,Power(Times(Plus(a,Times(q,Sqr(x))),Power(Times(C2,q),-1)),CN1D2))),C1D2),Power(Times(CSqrt2,Sqrt(Negate(a)),Sqrt(Plus(a,Times(b,Power(x,4))))),-1)),x),IntegerQ(q))),And(FreeQ(List(a,b),x),LtQ(a,C0),GtQ(b,C0))));
IIntegrate(223,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,4))),CN1D2),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(CN1,a,b),C2))),Simp(Times(Sqrt(Times(Plus(a,Times(CN1,q,Sqr(x))),Power(Plus(a,Times(q,Sqr(x))),-1))),Sqrt(Times(Plus(a,Times(q,Sqr(x))),Power(q,-1))),EllipticF(ArcSin(Times(x,Power(Times(Plus(a,Times(q,Sqr(x))),Power(Times(C2,q),-1)),CN1D2))),C1D2),Power(Times(CSqrt2,Sqrt(Plus(a,Times(b,Power(x,4)))),Sqrt(Times(a,Power(Plus(a,Times(q,Sqr(x))),-1)))),-1)),x)),And(FreeQ(List(a,b),x),LtQ(a,C0),GtQ(b,C0))));
IIntegrate(224,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,4))),CN1D2),x_Symbol),
    Condition(Dist(Times(Sqrt(Plus(C1,Times(b,Power(x,4),Power(a,-1)))),Power(Plus(a,Times(b,Power(x,4))),CN1D2)),Int(Power(Plus(C1,Times(b,Power(x,4),Power(a,-1))),CN1D2),x),x),And(FreeQ(List(a,b),x),NegQ(Times(b,Power(a,-1))),Not(GtQ(a,C0)))));
IIntegrate(225,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,6))),CN1D2),x_Symbol),
    Condition(With(List(Set(r,$($s("§numer"),Rt(Times(b,Power(a,-1)),C3))),Set(s,$($s("§denom"),Rt(Times(b,Power(a,-1)),C3)))),Simp(Times(x,Plus(s,Times(r,Sqr(x))),Sqrt(Times(Plus(Sqr(s),Times(CN1,r,s,Sqr(x)),Times(Sqr(r),Power(x,4))),Power(Plus(s,Times(Plus(C1,CSqrt3),r,Sqr(x))),-2))),EllipticF(ArcCos(Times(Plus(s,Times(Plus(C1,Negate(CSqrt3)),r,Sqr(x))),Power(Plus(s,Times(Plus(C1,CSqrt3),r,Sqr(x))),-1))),Times(C1D4,Plus(C2,CSqrt3))),Power(Times(C2,Power(C3,C1D4),s,Sqrt(Plus(a,Times(b,Power(x,6)))),Sqrt(Times(r,Sqr(x),Plus(s,Times(r,Sqr(x))),Power(Plus(s,Times(Plus(C1,CSqrt3),r,Sqr(x))),-2)))),-1)),x)),FreeQ(List(a,b),x)));
IIntegrate(226,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,8))),CN1D2),x_Symbol),
    Condition(Plus(Dist(C1D2,Int(Times(Plus(C1,Times(CN1,Rt(Times(b,Power(a,-1)),C4),Sqr(x))),Power(Plus(a,Times(b,Power(x,8))),CN1D2)),x),x),Dist(C1D2,Int(Times(Plus(C1,Times(Rt(Times(b,Power(a,-1)),C4),Sqr(x))),Power(Plus(a,Times(b,Power(x,8))),CN1D2)),x),x)),FreeQ(List(a,b),x)));
IIntegrate(227,Int(Power(Plus(a_,Times(b_DEFAULT,Sqr(x_))),CN1D4),x_Symbol),
    Condition(Plus(Simp(Times(C2,x,Power(Plus(a,Times(b,Sqr(x))),CN1D4)),x),Negate(Dist(a,Int(Power(Plus(a,Times(b,Sqr(x))),QQ(-5L,4L)),x),x))),And(FreeQ(List(a,b),x),GtQ(a,C0),PosQ(Times(b,Power(a,-1))))));
IIntegrate(228,Int(Power(Plus(a_,Times(b_DEFAULT,Sqr(x_))),CN1D4),x_Symbol),
    Condition(Simp(Times(C2,EllipticE(Times(C1D2,C1,ArcSin(Times(Rt(Times(CN1,b,Power(a,-1)),C2),x))),C2),Power(Times(Power(a,C1D4),Rt(Times(CN1,b,Power(a,-1)),C2)),-1)),x),And(FreeQ(List(a,b),x),GtQ(a,C0),NegQ(Times(b,Power(a,-1))))));
IIntegrate(229,Int(Power(Plus(a_,Times(b_DEFAULT,Sqr(x_))),CN1D4),x_Symbol),
    Condition(Dist(Times(Power(Plus(C1,Times(b,Sqr(x),Power(a,-1))),C1D4),Power(Plus(a,Times(b,Sqr(x))),CN1D4)),Int(Power(Plus(C1,Times(b,Sqr(x),Power(a,-1))),CN1D4),x),x),And(FreeQ(List(a,b),x),PosQ(a))));
IIntegrate(230,Int(Power(Plus(a_,Times(b_DEFAULT,Sqr(x_))),CN1D4),x_Symbol),
    Condition(Dist(Times(C2,Sqrt(Times(CN1,b,Sqr(x),Power(a,-1))),Power(Times(b,x),-1)),Subst(Int(Times(Sqr(x),Power(Plus(C1,Times(CN1,Power(x,4),Power(a,-1))),CN1D2)),x),x,Power(Plus(a,Times(b,Sqr(x))),C1D4)),x),And(FreeQ(List(a,b),x),NegQ(a))));
IIntegrate(231,Int(Power(Plus(a_,Times(b_DEFAULT,Sqr(x_))),QQ(-3L,4L)),x_Symbol),
    Condition(Simp(Times(C2,EllipticF(Times(C1D2,C1,ArcTan(Times(Rt(Times(b,Power(a,-1)),C2),x))),C2),Power(Times(Power(a,QQ(3L,4L)),Rt(Times(b,Power(a,-1)),C2)),-1)),x),And(FreeQ(List(a,b),x),GtQ(a,C0),PosQ(Times(b,Power(a,-1))))));
IIntegrate(232,Int(Power(Plus(a_,Times(b_DEFAULT,Sqr(x_))),QQ(-3L,4L)),x_Symbol),
    Condition(Simp(Times(C2,EllipticF(Times(C1D2,C1,ArcSin(Times(Rt(Times(CN1,b,Power(a,-1)),C2),x))),C2),Power(Times(Power(a,QQ(3L,4L)),Rt(Times(CN1,b,Power(a,-1)),C2)),-1)),x),And(FreeQ(List(a,b),x),GtQ(a,C0),NegQ(Times(b,Power(a,-1))))));
IIntegrate(233,Int(Power(Plus(a_,Times(b_DEFAULT,Sqr(x_))),QQ(-3L,4L)),x_Symbol),
    Condition(Dist(Times(Power(Plus(C1,Times(b,Sqr(x),Power(a,-1))),QQ(3L,4L)),Power(Plus(a,Times(b,Sqr(x))),QQ(-3L,4L))),Int(Power(Plus(C1,Times(b,Sqr(x),Power(a,-1))),QQ(-3L,4L)),x),x),And(FreeQ(List(a,b),x),PosQ(a))));
IIntegrate(234,Int(Power(Plus(a_,Times(b_DEFAULT,Sqr(x_))),QQ(-3L,4L)),x_Symbol),
    Condition(Dist(Times(C2,Sqrt(Times(CN1,b,Sqr(x),Power(a,-1))),Power(Times(b,x),-1)),Subst(Int(Power(Plus(C1,Times(CN1,Power(x,4),Power(a,-1))),CN1D2),x),x,Power(Plus(a,Times(b,Sqr(x))),C1D4)),x),And(FreeQ(List(a,b),x),NegQ(a))));
IIntegrate(235,Int(Power(Plus(a_,Times(b_DEFAULT,Sqr(x_))),CN1D3),x_Symbol),
    Condition(Dist(Times(C3,Sqrt(Times(b,Sqr(x))),Power(Times(C2,b,x),-1)),Subst(Int(Times(x,Power(Plus(Negate(a),Power(x,3)),CN1D2)),x),x,Power(Plus(a,Times(b,Sqr(x))),C1D3)),x),FreeQ(List(a,b),x)));
IIntegrate(236,Int(Power(Plus(a_,Times(b_DEFAULT,Sqr(x_))),QQ(-2L,3L)),x_Symbol),
    Condition(Dist(Times(C3,Sqrt(Times(b,Sqr(x))),Power(Times(C2,b,x),-1)),Subst(Int(Power(Plus(Negate(a),Power(x,3)),CN1D2),x),x,Power(Plus(a,Times(b,Sqr(x))),C1D3)),x),FreeQ(List(a,b),x)));
IIntegrate(237,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,4))),QQ(-3L,4L)),x_Symbol),
    Condition(Dist(Times(Power(x,3),Power(Plus(C1,Times(a,Power(Times(b,Power(x,4)),-1))),QQ(3L,4L)),Power(Plus(a,Times(b,Power(x,4))),QQ(-3L,4L))),Int(Power(Times(Power(x,3),Power(Plus(C1,Times(a,Power(Times(b,Power(x,4)),-1))),QQ(3L,4L))),-1),x),x),FreeQ(List(a,b),x)));
IIntegrate(238,Int(Power(Plus(a_,Times(b_DEFAULT,Sqr(x_))),QQ(-1L,6L)),x_Symbol),
    Condition(Plus(Simp(Times(C3,x,Power(Times(C2,Power(Plus(a,Times(b,Sqr(x))),QQ(1L,6L))),-1)),x),Negate(Dist(Times(C1D2,a),Int(Power(Plus(a,Times(b,Sqr(x))),QQ(-7L,6L)),x),x))),FreeQ(List(a,b),x)));
IIntegrate(239,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,3))),CN1D3),x_Symbol),
    Condition(Plus(Simp(Times(ArcTan(Times(Plus(C1,Times(C2,Rt(b,C3),x,Power(Plus(a,Times(b,Power(x,3))),CN1D3))),C1DSqrt3)),Power(Times(CSqrt3,Rt(b,C3)),-1)),x),Negate(Simp(Times(Log(Plus(Power(Plus(a,Times(b,Power(x,3))),C1D3),Times(CN1,Rt(b,C3),x))),Power(Times(C2,Rt(b,C3)),-1)),x))),FreeQ(List(a,b),x)));
IIntegrate(240,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_),x_Symbol),
    Condition(Dist(Power(a,Plus(p,Power(n,-1))),Subst(Int(Power(Power(Plus(C1,Times(CN1,b,Power(x,n))),Plus(p,Power(n,-1),C1)),-1),x),x,Times(x,Power(Power(Plus(a,Times(b,Power(x,n))),Power(n,-1)),-1))),x),And(FreeQ(List(a,b),x),IGtQ(n,C0),LtQ(CN1,p,C0),NeQ(p,Negate(C1D2)),IntegerQ(Plus(p,Power(n,-1))))));
IIntegrate(241,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_),x_Symbol),
    Condition(Dist(Times(Power(Times(a,Power(Plus(a,Times(b,Power(x,n))),-1)),Plus(p,Power(n,-1))),Power(Plus(a,Times(b,Power(x,n))),Plus(p,Power(n,-1)))),Subst(Int(Power(Power(Plus(C1,Times(CN1,b,Power(x,n))),Plus(p,Power(n,-1),C1)),-1),x),x,Times(x,Power(Power(Plus(a,Times(b,Power(x,n))),Power(n,-1)),-1))),x),And(FreeQ(List(a,b),x),IGtQ(n,C0),LtQ(CN1,p,C0),NeQ(p,Negate(C1D2)),LtQ(Denominator(Plus(p,Power(n,-1))),Denominator(p)))));
IIntegrate(242,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_),x_Symbol),
    Condition(Negate(Subst(Int(Times(Power(Plus(a,Times(b,Power(Power(x,n),-1))),p),Power(x,-2)),x),x,Power(x,-1))),And(FreeQ(List(a,b,p),x),ILtQ(n,C0))));
IIntegrate(243,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_),x_Symbol),
    Condition(With(List(Set(k,Denominator(n))),Dist(k,Subst(Int(Times(Power(x,Plus(k,Negate(C1))),Power(Plus(a,Times(b,Power(x,Times(k,n)))),p)),x),x,Power(x,Power(k,-1))),x)),And(FreeQ(List(a,b,p),x),FractionQ(n))));
IIntegrate(244,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_),x_Symbol),
    Condition(Int(ExpandIntegrand(Power(Plus(a,Times(b,Power(x,n))),p),x),x),And(FreeQ(List(a,b,n),x),IGtQ(p,C0))));
IIntegrate(245,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_),x_Symbol),
    Condition(Simp(Times(Power(a,p),x,Hypergeometric2F1(Negate(p),Power(n,-1),Plus(Power(n,-1),C1),Times(CN1,b,Power(x,n),Power(a,-1)))),x),And(FreeQ(List(a,b,n,p),x),Not(IGtQ(p,C0)),Not(IntegerQ(Power(n,-1))),Not(ILtQ(Simplify(Plus(Power(n,-1),p)),C0)),Or(IntegerQ(p),GtQ(a,C0)))));
IIntegrate(246,Int(Power(Plus(a_,Times(b_DEFAULT,Power(x_,n_))),p_),x_Symbol),
    Condition(Dist(Times(Power(a,IntPart(p)),Power(Plus(a,Times(b,Power(x,n))),FracPart(p)),Power(Power(Plus(C1,Times(b,Power(x,n),Power(a,-1))),FracPart(p)),-1)),Int(Power(Plus(C1,Times(b,Power(x,n),Power(a,-1))),p),x),x),And(FreeQ(List(a,b,n,p),x),Not(IGtQ(p,C0)),Not(IntegerQ(Power(n,-1))),Not(ILtQ(Simplify(Plus(Power(n,-1),p)),C0)),Not(Or(IntegerQ(p),GtQ(a,C0))))));
IIntegrate(247,Int(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(v_,n_))),p_),x_Symbol),
    Condition(Dist(Power(Coefficient(v,x,C1),-1),Subst(Int(Power(Plus(a,Times(b,Power(x,n))),p),x),x,v),x),And(FreeQ(List(a,b,n,p),x),LinearQ(v,x),NeQ(v,x))));
IIntegrate(248,Int(Times(Power(Plus($p("a1",true),Times($p("b1",true),Power(x_,n_))),p_DEFAULT),Power(Plus($p("a2",true),Times($p("b2",true),Power(x_,n_))),p_DEFAULT)),x_Symbol),
    Condition(Int(Power(Plus(Times($s("a1"),$s("a2")),Times($s("b1"),$s("b2"),Power(x,Times(C2,n)))),p),x),And(FreeQ(List($s("a1"),$s("b1"),$s("a2"),$s("b2"),n,p),x),EqQ(Plus(Times($s("a2"),$s("b1")),Times($s("a1"),$s("b2"))),C0),Or(IntegerQ(p),And(GtQ($s("a1"),C0),GtQ($s("a2"),C0))))));
IIntegrate(249,Int(Times(Power(Plus($p("a1"),Times($p("b1",true),Power(x_,n_DEFAULT))),p_DEFAULT),Power(Plus($p("a2"),Times($p("b2",true),Power(x_,n_DEFAULT))),p_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(x,Power(Plus($s("a1"),Times($s("b1"),Power(x,n))),p),Power(Plus($s("a2"),Times($s("b2"),Power(x,n))),p),Power(Plus(Times(C2,n,p),C1),-1)),x),Dist(Times(C2,$s("a1"),$s("a2"),n,p,Power(Plus(Times(C2,n,p),C1),-1)),Int(Times(Power(Plus($s("a1"),Times($s("b1"),Power(x,n))),Plus(p,Negate(C1))),Power(Plus($s("a2"),Times($s("b2"),Power(x,n))),Plus(p,Negate(C1)))),x),x)),And(FreeQ(List($s("a1"),$s("b1"),$s("a2"),$s("b2")),x),EqQ(Plus(Times($s("a2"),$s("b1")),Times($s("a1"),$s("b2"))),C0),IGtQ(Times(C2,n),C0),GtQ(p,C0),Or(IntegerQ(Times(C2,p)),Less(Denominator(Plus(p,Power(n,-1))),Denominator(p))))));
IIntegrate(250,Int(Times(Power(Plus($p("a1"),Times($p("b1",true),Power(x_,n_DEFAULT))),p_),Power(Plus($p("a2"),Times($p("b2",true),Power(x_,n_DEFAULT))),p_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(x,Power(Plus($s("a1"),Times($s("b1"),Power(x,n))),Plus(p,C1)),Power(Plus($s("a2"),Times($s("b2"),Power(x,n))),Plus(p,C1)),Power(Times(C2,$s("a1"),$s("a2"),n,Plus(p,C1)),-1)),x)),Dist(Times(Plus(Times(C2,n,Plus(p,C1)),C1),Power(Times(C2,$s("a1"),$s("a2"),n,Plus(p,C1)),-1)),Int(Times(Power(Plus($s("a1"),Times($s("b1"),Power(x,n))),Plus(p,C1)),Power(Plus($s("a2"),Times($s("b2"),Power(x,n))),Plus(p,C1))),x),x)),And(FreeQ(List($s("a1"),$s("b1"),$s("a2"),$s("b2")),x),EqQ(Plus(Times($s("a2"),$s("b1")),Times($s("a1"),$s("b2"))),C0),IGtQ(Times(C2,n),C0),LtQ(p,CN1),Or(IntegerQ(Times(C2,p)),Less(Denominator(Plus(p,Power(n,-1))),Denominator(p))))));
  }
}
}
