package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.ASymbol;
import static org.matheclipse.core.expression.F.A_DEFAULT;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.BSymbol;
import static org.matheclipse.core.expression.F.B_DEFAULT;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CI;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D4;
import static org.matheclipse.core.expression.F.CSymbol;
import static org.matheclipse.core.expression.F.C_DEFAULT;
import static org.matheclipse.core.expression.F.Complex;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.GreaterEqual;
import static org.matheclipse.core.expression.F.ISetDelayed;
import static org.matheclipse.core.expression.F.If;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.Less;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.MatchQ;
import static org.matheclipse.core.expression.F.Mod;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Pi;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Switch;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.True;
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
import static org.matheclipse.core.expression.F.f_;
import static org.matheclipse.core.expression.F.f_DEFAULT;
import static org.matheclipse.core.expression.F.g;
import static org.matheclipse.core.expression.F.g_;
import static org.matheclipse.core.expression.F.g_DEFAULT;
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
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.u_DEFAULT;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.v_DEFAULT;
import static org.matheclipse.core.expression.F.w;
import static org.matheclipse.core.expression.F.w_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FixInertTrigFunction;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InertReciprocalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PowerOfInertTrigSumQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ReduceInertTrig;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.UnifyInertTrigFunction;
/** 
 * UtilityFunctions rules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class UtilityFunctions7 { 
  public static IAST RULES = List( 
ISetDelayed(562,FixInertTrigFunction(Times(u_DEFAULT,w_,Power($($s("§sec"),v_),n_DEFAULT)),x_),
    Condition(Times(Power($($s("§cos"),v),Negate(n)),FixInertTrigFunction(Times(u,w),x)),And(PowerOfInertTrigSumQ(w,$s("§cot"),x),IntegerQ(n)))),
ISetDelayed(563,FixInertTrigFunction(Times(u_DEFAULT,w_,Power($($s("§cos"),v_),n_DEFAULT)),x_),
    Condition(Times(Power($($s("§sec"),v),Negate(n)),FixInertTrigFunction(Times(u,w),x)),And(PowerOfInertTrigSumQ(w,$s("§sec"),x),IntegerQ(n)))),
ISetDelayed(564,FixInertTrigFunction(Times(u_DEFAULT,w_,Power($($s("§cot"),v_),n_DEFAULT)),x_),
    Condition(Times(Power($($s("§tan"),v),Negate(n)),FixInertTrigFunction(Times(u,w),x)),And(PowerOfInertTrigSumQ(w,$s("§sec"),x),IntegerQ(n)))),
ISetDelayed(565,FixInertTrigFunction(Times(u_DEFAULT,w_,Power($($s("§csc"),v_),n_DEFAULT)),x_),
    Condition(Times(Power($($s("§sin"),v),Negate(n)),FixInertTrigFunction(Times(u,w),x)),And(PowerOfInertTrigSumQ(w,$s("§sec"),x),IntegerQ(n)))),
ISetDelayed(566,FixInertTrigFunction(Times(u_DEFAULT,w_,Power($($s("§sin"),v_),n_DEFAULT)),x_),
    Condition(Times(Power($($s("§csc"),v),Negate(n)),FixInertTrigFunction(Times(u,w),x)),And(PowerOfInertTrigSumQ(w,$s("§csc"),x),IntegerQ(n)))),
ISetDelayed(567,FixInertTrigFunction(Times(u_DEFAULT,w_,Power($($s("§tan"),v_),n_DEFAULT)),x_),
    Condition(Times(Power($($s("§cot"),v),Negate(n)),FixInertTrigFunction(Times(u,w),x)),And(PowerOfInertTrigSumQ(w,$s("§csc"),x),IntegerQ(n)))),
ISetDelayed(568,FixInertTrigFunction(Times(u_DEFAULT,w_,Power($($s("§sec"),v_),n_DEFAULT)),x_),
    Condition(Times(Power($($s("§cos"),v),Negate(n)),FixInertTrigFunction(Times(u,w),x)),And(PowerOfInertTrigSumQ(w,$s("§csc"),x),IntegerQ(n)))),
ISetDelayed(569,FixInertTrigFunction(Times(u_DEFAULT,Power(Plus(Times(b_DEFAULT,$($s("§cos"),v_)),Times(a_DEFAULT,$($s("§sin"),v_))),n_DEFAULT),Power($($s("§tan"),v_),m_DEFAULT)),x_),
    Condition(Times(Power($($s("§sin"),v),m),Power($($s("§cos"),v),Negate(m)),FixInertTrigFunction(Times(u,Power(Plus(Times(a,$($s("§sin"),v)),Times(b,$($s("§cos"),v))),n)),x)),And(FreeQ(List(a,b,n),x),IntegerQ(m)))),
ISetDelayed(570,FixInertTrigFunction(Times(u_DEFAULT,Power($($s("§cot"),v_),m_DEFAULT),Power(Plus(Times(b_DEFAULT,$($s("§cos"),v_)),Times(a_DEFAULT,$($s("§sin"),v_))),n_DEFAULT)),x_),
    Condition(Times(Power($($s("§cos"),v),m),Power($($s("§sin"),v),Negate(m)),FixInertTrigFunction(Times(u,Power(Plus(Times(a,$($s("§sin"),v)),Times(b,$($s("§cos"),v))),n)),x)),And(FreeQ(List(a,b,n),x),IntegerQ(m)))),
ISetDelayed(571,FixInertTrigFunction(Times(u_DEFAULT,Power($($s("§sec"),v_),m_DEFAULT),Power(Plus(Times(b_DEFAULT,$($s("§cos"),v_)),Times(a_DEFAULT,$($s("§sin"),v_))),n_DEFAULT)),x_),
    Condition(Times(Power($($s("§cos"),v),Negate(m)),FixInertTrigFunction(Times(u,Power(Plus(Times(a,$($s("§sin"),v)),Times(b,$($s("§cos"),v))),n)),x)),And(FreeQ(List(a,b,n),x),IntegerQ(m)))),
ISetDelayed(572,FixInertTrigFunction(Times(u_DEFAULT,Power($($s("§csc"),v_),m_DEFAULT),Power(Plus(Times(b_DEFAULT,$($s("§cos"),v_)),Times(a_DEFAULT,$($s("§sin"),v_))),n_DEFAULT)),x_),
    Condition(Times(Power($($s("§sin"),v),Negate(m)),FixInertTrigFunction(Times(u,Power(Plus(Times(a,$($s("§sin"),v)),Times(b,$($s("§cos"),v))),n)),x)),And(FreeQ(List(a,b,n),x),IntegerQ(m)))),
ISetDelayed(573,FixInertTrigFunction(Times(Power($(f_,v_),m_DEFAULT),Plus(A_DEFAULT,Times(B_DEFAULT,$(g_,v_)),Times(C_DEFAULT,Sqr($(g_,v_))))),x_),
    Condition(Times(Power($(g,v),Negate(m)),Plus(ASymbol,Times(BSymbol,$(g,v)),Times(CSymbol,Sqr($(g,v))))),And(FreeQ(List(ASymbol,BSymbol,CSymbol),x),IntegerQ(m),Or(InertReciprocalQ(f,g),InertReciprocalQ(g,f))))),
ISetDelayed(574,FixInertTrigFunction(Times(Power($(f_,v_),m_DEFAULT),Plus(A_DEFAULT,Times(C_DEFAULT,Sqr($(g_,v_))))),x_),
    Condition(Times(Power($(g,v),Negate(m)),Plus(ASymbol,Times(CSymbol,Sqr($(g,v))))),And(FreeQ(List(ASymbol,CSymbol),x),IntegerQ(m),Or(InertReciprocalQ(f,g),InertReciprocalQ(g,f))))),
ISetDelayed(575,FixInertTrigFunction(Times(Power($(f_,v_),m_DEFAULT),Plus(A_DEFAULT,Times(B_DEFAULT,$(g_,v_)),Times(C_DEFAULT,Sqr($(g_,v_)))),Power(Plus(a_DEFAULT,Times(b_DEFAULT,$(g_,v_))),n_DEFAULT)),x_),
    Condition(Times(Power($(g,v),Negate(m)),Plus(ASymbol,Times(BSymbol,$(g,v)),Times(CSymbol,Sqr($(g,v)))),Power(Plus(a,Times(b,$(g,v))),n)),And(FreeQ(List(a,b,ASymbol,BSymbol,CSymbol,n),x),IntegerQ(m),Or(InertReciprocalQ(f,g),InertReciprocalQ(g,f))))),
ISetDelayed(576,FixInertTrigFunction(Times(Power($(f_,v_),m_DEFAULT),Plus(A_DEFAULT,Times(C_DEFAULT,Sqr($(g_,v_)))),Power(Plus(a_DEFAULT,Times(b_DEFAULT,$(g_,v_))),n_DEFAULT)),x_),
    Condition(Times(Power($(g,v),Negate(m)),Plus(ASymbol,Times(CSymbol,Sqr($(g,v)))),Power(Plus(a,Times(b,$(g,v))),n)),And(FreeQ(List(a,b,ASymbol,CSymbol,n),x),IntegerQ(m),Or(InertReciprocalQ(f,g),InertReciprocalQ(g,f))))),
ISetDelayed(577,FixInertTrigFunction(u_,x_),
    u),
ISetDelayed(578,PowerOfInertTrigSumQ(u_,$p("func"),x_),
    Or(MatchQ(u,Condition(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(Times(c_DEFAULT,$($s("func"),w_)),n_DEFAULT))),p_DEFAULT),And(FreeQ(List(a,b,c,n,p),x),Not(And(EqQ(a,C0),Or(IntegerQ(p),EqQ(n,C1))))))),MatchQ(u,Condition(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(Times(d_DEFAULT,$($s("func"),w_)),p_DEFAULT)),Times(c_DEFAULT,Power(Times(d_DEFAULT,$($s("func"),w_)),q_DEFAULT))),n_DEFAULT),FreeQ(List(a,b,c,d,n,p,q),x))))),
ISetDelayed(579,ReduceInertTrig($p("func"),Plus(Times(m_DEFAULT,Plus(Times(Pi,n_DEFAULT),u_DEFAULT)),v_DEFAULT)),
    Condition(ReduceInertTrig($s("func"),Times(m,n),Plus(Times(m,u),v)),RationalQ(m,n))),
ISetDelayed(580,ReduceInertTrig($p("func"),Plus(v_DEFAULT,Times(m_DEFAULT,Complex(C0,$p("mz")),Plus(u_DEFAULT,Times(Pi,n_DEFAULT,Complex(C0,$p("nz"))))))),
    Condition(ReduceInertTrig($s("func"),Times(CN1,m,$s("mz"),n,$s("nz")),Plus(Times(m,$s("mz"),CI,u),v)),RationalQ(m,$s("mz"),n,$s("nz")))),
ISetDelayed(581,ReduceInertTrig($p("func"),u_),
    $($s("func"),u)),
ISetDelayed(582,ReduceInertTrig($p("func"),m_,u_),
    Condition(If(Less(m,C0),If(GreaterEqual(m,CN1D4),$($s("func"),Plus(Times(m,Pi),u)),Switch($s("func"),$s("§sin"),Negate(ReduceInertTrig($s("§sin"),Negate(m),Negate(u))),$s("§cos"),ReduceInertTrig($s("§cos"),Negate(m),Negate(u)),$s("§tan"),Negate(ReduceInertTrig($s("§tan"),Negate(m),Negate(u))),$s("§cot"),Negate(ReduceInertTrig($s("§cot"),Negate(m),Negate(u))),$s("§sec"),ReduceInertTrig($s("§sec"),Negate(m),Negate(u)),$s("§csc"),Negate(ReduceInertTrig($s("§csc"),Negate(m),Negate(u))))),If(GreaterEqual(m,C2),ReduceInertTrig($s("func"),Mod(m,C2),u),If(GreaterEqual(m,C1),Switch($s("func"),$s("§sin"),Negate(ReduceInertTrig($s("§sin"),Plus(m,Negate(C1)),u)),$s("§cos"),Negate(ReduceInertTrig($s("§cos"),Plus(m,Negate(C1)),u)),$s("§tan"),ReduceInertTrig($s("§tan"),Plus(m,Negate(C1)),u),$s("§cot"),ReduceInertTrig($s("§cot"),Plus(m,Negate(C1)),u),$s("§sec"),Negate(ReduceInertTrig($s("§sec"),Plus(m,Negate(C1)),u)),$s("§csc"),Negate(ReduceInertTrig($s("§csc"),Plus(m,Negate(C1)),u))),If(GreaterEqual(m,C1D2),Switch($s("func"),$s("§sin"),ReduceInertTrig($s("§cos"),Plus(m,Negate(C1D2)),u),$s("§cos"),Negate(ReduceInertTrig($s("§sin"),Plus(m,Negate(C1D2)),u)),$s("§tan"),Negate(ReduceInertTrig($s("§cot"),Plus(m,Negate(C1D2)),u)),$s("§cot"),Negate(ReduceInertTrig($s("§tan"),Plus(m,Negate(C1D2)),u)),$s("§sec"),Negate(ReduceInertTrig($s("§csc"),Plus(m,Negate(C1D2)),u)),$s("§csc"),ReduceInertTrig($s("§sec"),Plus(m,Negate(C1D2)),u)),$($s("func"),Plus(Times(m,Pi),u)))))),RationalQ(m))),
ISetDelayed(583,UnifyInertTrigFunction(Times(a_,u_),x_),
    Condition(Times(a,UnifyInertTrigFunction(u,x)),FreeQ(a,x))),
ISetDelayed(584,UnifyInertTrigFunction(Times(Power(Times(a_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT),Power(Times(b_DEFAULT,$($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_DEFAULT)),x_),
    Condition(Times(Power(Times(a,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x)))),m),Power(Times(CN1,b,$($s("§sec"),Plus(e,Times(C1D2,Pi),Times(f,x)))),n)),FreeQ(List(a,b,e,f,m,n),x))),
ISetDelayed(585,UnifyInertTrigFunction(Times(Power(Times(a_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT),Power(Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_DEFAULT)),x_),
    Condition(Times(Power(Times(a,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x)))),m),Power(Times(b,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x)))),n)),FreeQ(List(a,b,e,f,m,n),x))),
ISetDelayed(586,UnifyInertTrigFunction(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT),x_),
    Condition(Power(Plus(a,Times(b,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x))))),n),FreeQ(List(a,b,e,f,n),x))),
ISetDelayed(587,UnifyInertTrigFunction(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Times(g_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),p_DEFAULT)),x_),
    Condition(Times(Power(Times(g,$($s("§cos"),Plus(e,Times(CN1,C1D2,Pi),Times(f,x)))),p),Power(Plus(a,Times(CN1,b,$($s("§sin"),Plus(e,Times(CN1,C1D2,Pi),Times(f,x))))),m)),FreeQ(List(a,b,e,f,g,m,p),x))),
ISetDelayed(588,UnifyInertTrigFunction(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Times(g_DEFAULT,$($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),p_DEFAULT)),x_),
    Condition(Times(Power(Times(g,$($s("§sec"),Plus(e,Times(CN1,C1D2,Pi),Times(f,x)))),p),Power(Plus(a,Times(CN1,b,$($s("§sin"),Plus(e,Times(CN1,C1D2,Pi),Times(f,x))))),m)),FreeQ(List(a,b,e,f,g,m,p),x))),
ISetDelayed(589,UnifyInertTrigFunction(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Times(g_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),p_DEFAULT)),x_),
    Condition(If(True,Times(Power(Times(CN1,g,$($s("§tan"),Plus(e,Times(CN1,C1D2,Pi),Times(f,x)))),p),Power(Plus(a,Times(CN1,b,$($s("§sin"),Plus(e,Times(CN1,C1D2,Pi),Times(f,x))))),m)),Times(Power(Times(CN1,g,$($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x)))),p),Power(Plus(a,Times(b,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x))))),m))),FreeQ(List(a,b,e,f,g,m,p),x))),
ISetDelayed(590,UnifyInertTrigFunction(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Times(g_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),p_DEFAULT)),x_),
    Condition(Times(Power(Times(CN1,g,$($s("§cot"),Plus(e,Times(C1D2,Pi),Times(f,x)))),p),Power(Plus(a,Times(b,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x))))),m)),FreeQ(List(a,b,e,f,g,m,p),x))),
ISetDelayed(591,UnifyInertTrigFunction(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT)),x_),
    Condition(Times(Power(Plus(a,Times(b,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x))))),m),Power(Plus(c,Times(d,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x))))),n)),FreeQ(List(a,b,c,d,e,f,m,n),x))),
ISetDelayed(592,UnifyInertTrigFunction(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT)),x_),
    Condition(Times(Power(Plus(a,Times(b,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x))))),m),Power(Plus(c,Times(d,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x))))),n)),FreeQ(List(a,b,c,d,e,f,m,n),x))),
ISetDelayed(593,UnifyInertTrigFunction(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT),Power(Times(g_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),p_DEFAULT)),x_),
    Condition(If(And(IntegerQ(Times(C2,p)),Less(p,C0),IntegerQ(Times(C2,n))),Times(Power(Times(g,$($s("§cos"),Plus(e,Times(CN1,C1D2,Pi),Times(f,x)))),p),Power(Plus(a,Times(CN1,b,$($s("§sin"),Plus(e,Times(CN1,C1D2,Pi),Times(f,x))))),m),Power(Plus(c,Times(CN1,d,$($s("§sin"),Plus(e,Times(CN1,C1D2,Pi),Times(f,x))))),n)),Times(Power(Times(CN1,g,$($s("§cos"),Plus(e,Times(C1D2,Pi),Times(f,x)))),p),Power(Plus(a,Times(b,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x))))),m),Power(Plus(c,Times(d,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x))))),n))),FreeQ(List(a,b,c,d,e,f,g,m,n,p),x))),
ISetDelayed(594,UnifyInertTrigFunction(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT),Power(Times(g_DEFAULT,$($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),p_DEFAULT)),x_),
    Condition(Times(Power(Times(g,$($s("§sec"),Plus(e,Times(CN1,C1D2,Pi),Times(f,x)))),p),Power(Plus(a,Times(CN1,b,$($s("§sin"),Plus(e,Times(CN1,C1D2,Pi),Times(f,x))))),m),Power(Plus(c,Times(CN1,d,$($s("§sin"),Plus(e,Times(CN1,C1D2,Pi),Times(f,x))))),n)),FreeQ(List(a,b,c,d,e,f,g,m,n,p),x))),
ISetDelayed(595,UnifyInertTrigFunction(Times(Power(Times(g_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),p_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT)),x_),
    Condition(Times(Power(Times(g,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x)))),p),Power(Plus(a,Times(b,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x))))),m),Power(Plus(c,Times(d,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x))))),n)),FreeQ(List(a,b,c,d,e,f,g,m,n,p),x))),
ISetDelayed(596,UnifyInertTrigFunction(Times(Power(Times(g_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),p_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT)),x_),
    Condition(Times(Power(Times(g,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x)))),p),Power(Plus(a,Times(b,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x))))),m),Power(Plus(c,Times(d,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x))))),n)),FreeQ(List(a,b,c,d,e,f,g,m,n,p),x))),
ISetDelayed(597,UnifyInertTrigFunction(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT),Power(Times(g_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),p_DEFAULT)),x_),
    Condition(Times(Power(Times(g,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x)))),p),Power(Plus(a,Times(b,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x))))),m),Power(Plus(c,Times(d,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x))))),n)),FreeQ(List(a,b,c,d,e,f,g,m,n,p),x))),
ISetDelayed(598,UnifyInertTrigFunction(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Times(g_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),p_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT)),x_),
    Condition(Times(Power(Times(g,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x)))),p),Power(Plus(a,Times(b,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x))))),m),Power(Plus(c,Times(d,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x))))),n)),FreeQ(List(a,b,c,d,e,f,g,m,n,p),x))),
ISetDelayed(599,UnifyInertTrigFunction(Times(Plus(A_DEFAULT,Times(B_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT)),x_),
    Condition(Times(Power(Plus(a,Times(b,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x))))),m),Power(Plus(c,Times(d,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x))))),n),Plus(ASymbol,Times(BSymbol,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x)))))),FreeQ(List(a,b,c,d,e,f,ASymbol,BSymbol,m,n),x))),
ISetDelayed(600,UnifyInertTrigFunction(Times(Plus(A_DEFAULT,Times(B_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),Times(C_DEFAULT,Sqr($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT)),x_),
    Condition(Times(Power(Plus(a,Times(b,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x))))),m),Plus(ASymbol,Times(BSymbol,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x)))),Times(CSymbol,Sqr($($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x))))))),FreeQ(List(a,b,c,e,f,ASymbol,BSymbol,CSymbol,m),x))),
ISetDelayed(601,UnifyInertTrigFunction(Times(Plus(A_DEFAULT,Times(C_DEFAULT,Sqr($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT)),x_),
    Condition(Times(Power(Plus(a,Times(b,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x))))),m),Plus(ASymbol,Times(CSymbol,Sqr($($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x))))))),FreeQ(List(a,b,c,e,f,ASymbol,CSymbol,m),x))),
ISetDelayed(602,UnifyInertTrigFunction(Times(Plus(A_DEFAULT,Times(B_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),Times(C_DEFAULT,Sqr($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT)),x_),
    Condition(Times(Power(Plus(a,Times(b,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x))))),m),Power(Plus(c,Times(d,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x))))),n),Plus(ASymbol,Times(BSymbol,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x)))),Times(CSymbol,Sqr($($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x))))))),FreeQ(List(a,b,c,d,e,f,ASymbol,BSymbol,CSymbol,m,n),x))),
ISetDelayed(603,UnifyInertTrigFunction(Times(Plus(A_DEFAULT,Times(C_DEFAULT,Sqr($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT)),x_),
    Condition(Times(Power(Plus(a,Times(b,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x))))),m),Power(Plus(c,Times(d,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x))))),n),Plus(ASymbol,Times(CSymbol,Sqr($($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x))))))),FreeQ(List(a,b,c,d,e,f,ASymbol,CSymbol,m,n),x))),
ISetDelayed(604,UnifyInertTrigFunction(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(Times(c_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_))),p_),x_),
    Condition(Power(Plus(a,Times(b,Power(Times(c,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x)))),n))),p),And(FreeQ(List(a,b,e,f,n,p),x),Not(And(EqQ(a,C0),IntegerQ(p)))))),
ISetDelayed(605,UnifyInertTrigFunction(Times(Power(Times(d_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(Times(c_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_))),p_DEFAULT)),x_),
    Condition(Times(Power(Times(d,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x)))),m),Power(Plus(a,Times(b,Power(Times(c,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x)))),n))),p)),And(FreeQ(List(a,b,c,d,e,f,m,n,p),x),Not(And(EqQ(a,C0),IntegerQ(p)))))),
ISetDelayed(606,UnifyInertTrigFunction(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(Times(c_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_))),p_DEFAULT),Power(Times(d_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT)),x_),
    Condition(Times(Power(Times(CN1,d,$($s("§cos"),Plus(e,Times(C1D2,Pi),Times(f,x)))),m),Power(Plus(a,Times(b,Power(Times(c,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x)))),n))),p)),And(FreeQ(List(a,b,c,d,e,f,m,n,p),x),Not(And(EqQ(a,C0),IntegerQ(p)))))),
ISetDelayed(607,UnifyInertTrigFunction(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(Times(c_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_))),p_DEFAULT),Power(Times(d_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT)),x_),
    Condition(Times(Power(Times(CN1,d,$($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x)))),m),Power(Plus(a,Times(b,Power(Times(c,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x)))),n))),p)),And(FreeQ(List(a,b,c,d,e,f,m,n,p),x),Not(And(EqQ(a,C0),IntegerQ(p)))))),
ISetDelayed(608,UnifyInertTrigFunction(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(Times(c_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_))),p_DEFAULT),Power(Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT)),x_),
    Condition(Times(Power(Times(CN1,d,$($s("§cot"),Plus(e,Times(C1D2,Pi),Times(f,x)))),m),Power(Plus(a,Times(b,Power(Times(c,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x)))),n))),p)),And(FreeQ(List(a,b,c,d,e,f,m,n,p),x),Not(And(EqQ(a,C0),IntegerQ(p)))))),
ISetDelayed(609,UnifyInertTrigFunction(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(Times(c_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_))),p_DEFAULT),Power(Times(d_DEFAULT,$($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT)),x_),
    Condition(Times(Power(Times(CN1,d,$($s("§sec"),Plus(e,Times(C1D2,Pi),Times(f,x)))),m),Power(Plus(a,Times(b,Power(Times(c,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x)))),n))),p)),And(FreeQ(List(a,b,c,d,e,f,m,n,p),x),Not(And(EqQ(a,C0),IntegerQ(p)))))),
ISetDelayed(610,UnifyInertTrigFunction(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(Times(c_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_))),p_DEFAULT),Power(Times(d_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT)),x_),
    Condition(Times(Power(Times(d,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x)))),m),Power(Plus(a,Times(b,Power(Times(c,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x)))),n))),p)),And(FreeQ(List(a,b,c,d,e,f,m,n,p),x),Not(And(EqQ(a,C0),IntegerQ(p)))))),
ISetDelayed(611,UnifyInertTrigFunction(Times(Plus(A_DEFAULT,Times(B_DEFAULT,Power($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),n_))),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power($($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),n_))),m_DEFAULT)),x_),
    Condition(Times(Power(Plus(a,Times(b,Power($($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x))),n))),m),Plus(ASymbol,Times(BSymbol,Power($($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x))),n)))),And(FreeQ(List(a,b,e,f,ASymbol,BSymbol,m,n),x),Not(And(EqQ(a,C0),IntegerQ(m)))))),
ISetDelayed(612,UnifyInertTrigFunction(Times(Power(Times(a_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT),Power(Times(b_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_DEFAULT)),x_),
    Condition(Times(Power(Times(a,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x)))),m),Power(Times(CN1,b,$($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x)))),n)),FreeQ(List(a,b,e,f,m,n),x))),
ISetDelayed(613,UnifyInertTrigFunction(Times(Power(Times(b_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_DEFAULT),Power(Times(a_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT)),x_),
    Condition(Times(Power(Times(a,$($s("§cos"),Plus(e,Times(CN1,C1D2,Pi),Times(f,x)))),m),Power(Times(CN1,b,$($s("§tan"),Plus(e,Times(CN1,C1D2,Pi),Times(f,x)))),n)),FreeQ(List(a,b,e,f,m,n),x))),
ISetDelayed(614,UnifyInertTrigFunction(Times(Power(Times(b_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_DEFAULT),Power(Times(a_DEFAULT,$($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT)),x_),
    Condition(Times(Power(Times(a,$($s("§sec"),Plus(e,Times(CN1,C1D2,Pi),Times(f,x)))),m),Power(Times(CN1,b,$($s("§tan"),Plus(e,Times(CN1,C1D2,Pi),Times(f,x)))),n)),FreeQ(List(a,b,e,f,m,n),x))),
ISetDelayed(615,UnifyInertTrigFunction(Times(Power(Times(b_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_DEFAULT),Power(Times(a_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT)),x_),
    Condition(Times(Power(Times(a,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x)))),m),Power(Times(CN1,b,$($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x)))),n)),FreeQ(List(a,b,e,f,m,n),x))),
ISetDelayed(616,UnifyInertTrigFunction(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT),x_),
    Condition(Power(Plus(a,Times(CN1,b,$($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x))))),n),FreeQ(List(a,b,e,f,n),x))),
ISetDelayed(617,UnifyInertTrigFunction(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT),Power(Times(d_DEFAULT,$($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT)),x_),
    Condition(Times(Power(Times(d,$($s("§sec"),Plus(e,Times(CN1,C1D2,Pi),Times(f,x)))),m),Power(Plus(a,Times(CN1,b,$($s("§tan"),Plus(e,Times(CN1,C1D2,Pi),Times(f,x))))),n)),FreeQ(List(a,b,d,e,f,m,n),x))),
ISetDelayed(618,UnifyInertTrigFunction(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT),Power(Times(d_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT)),x_),
    Condition(Times(Power(Times(d,$($s("§cos"),Plus(e,Times(CN1,C1D2,Pi),Times(f,x)))),m),Power(Plus(a,Times(CN1,b,$($s("§tan"),Plus(e,Times(CN1,C1D2,Pi),Times(f,x))))),n)),FreeQ(List(a,b,d,e,f,m,n),x))),
ISetDelayed(619,UnifyInertTrigFunction(Times(Power(Times(d_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT)),x_),
    Condition(Times(Power(Times(d,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x)))),m),Power(Plus(a,Times(CN1,b,$($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x))))),n)),FreeQ(List(a,b,d,e,f,m,n),x))),
ISetDelayed(620,UnifyInertTrigFunction(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT),Power(Times(d_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT)),x_),
    Condition(Times(Power(Times(d,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x)))),m),Power(Plus(a,Times(CN1,b,$($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x))))),n)),FreeQ(List(a,b,d,e,f,m,n),x))),
ISetDelayed(621,UnifyInertTrigFunction(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT)),x_),
    Condition(Times(Power(Plus(a,Times(CN1,b,$($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x))))),m),Power(Plus(c,Times(CN1,d,$($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x))))),n)),FreeQ(List(a,b,c,d,e,f,m,n),x))),
ISetDelayed(622,UnifyInertTrigFunction(Times(Power(Times(g_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),p_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT)),x_),
    Condition(Times(Power(Times(CN1,g,$($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x)))),p),Power(Plus(a,Times(CN1,b,$($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x))))),m),Power(Plus(c,Times(CN1,d,$($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x))))),n)),FreeQ(List(a,b,c,d,e,f,g,m,n,p),x))),
ISetDelayed(623,UnifyInertTrigFunction(Times(Power(Times(g_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),p_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT)),x_),
    Condition(Times(Power(Times(CN1,g,$($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x)))),p),Power(Plus(a,Times(CN1,b,$($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x))))),m),Power(Plus(c,Times(CN1,d,$($s("§cot"),Plus(e,Times(C1D2,Pi),Times(f,x))))),n)),FreeQ(List(a,b,c,d,e,f,g,m,n,p),x))),
ISetDelayed(624,UnifyInertTrigFunction(Times(Plus(A_DEFAULT,Times(B_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT)),x_),
    Condition(Times(Power(Plus(a,Times(CN1,b,$($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x))))),m),Power(Plus(c,Times(CN1,d,$($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x))))),n),Plus(ASymbol,Times(CN1,BSymbol,$($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x)))))),FreeQ(List(a,b,c,d,e,f,ASymbol,BSymbol,m,n),x))),
ISetDelayed(625,UnifyInertTrigFunction(Times(Plus(A_DEFAULT,Times(B_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),Times(C_DEFAULT,Sqr($($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT)),x_),
    Condition(Times(Power(Plus(a,Times(CN1,b,$($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x))))),m),Plus(ASymbol,Times(CN1,BSymbol,$($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x)))),Times(CSymbol,Sqr($($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x))))))),FreeQ(List(a,b,e,f,ASymbol,BSymbol,CSymbol,m),x))),
ISetDelayed(626,UnifyInertTrigFunction(Times(Plus(A_DEFAULT,Times(C_DEFAULT,Sqr($($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT)),x_),
    Condition(Times(Power(Plus(a,Times(CN1,b,$($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x))))),m),Plus(ASymbol,Times(CSymbol,Sqr($($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x))))))),FreeQ(List(a,b,e,f,ASymbol,CSymbol,m),x))),
ISetDelayed(627,UnifyInertTrigFunction(Times(Plus(A_DEFAULT,Times(B_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),Times(C_DEFAULT,Sqr($($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT)),x_),
    Condition(Times(Power(Plus(a,Times(CN1,b,$($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x))))),m),Power(Plus(c,Times(CN1,d,$($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x))))),n),Plus(ASymbol,Times(CN1,BSymbol,$($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x)))),Times(CSymbol,Sqr($($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x))))))),FreeQ(List(a,b,c,d,e,f,ASymbol,BSymbol,CSymbol,m,n),x))),
ISetDelayed(628,UnifyInertTrigFunction(Times(Plus(A_DEFAULT,Times(C_DEFAULT,Sqr($($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT)),x_),
    Condition(Times(Power(Plus(a,Times(CN1,b,$($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x))))),m),Power(Plus(c,Times(CN1,d,$($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x))))),n),Plus(ASymbol,Times(CSymbol,Sqr($($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x))))))),FreeQ(List(a,b,c,d,e,f,ASymbol,CSymbol,m,n),x))),
ISetDelayed(629,UnifyInertTrigFunction(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(Times(c_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_))),p_),x_),
    Condition(Power(Plus(a,Times(b,Power(Times(CN1,c,$($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x)))),n))),p),And(FreeQ(List(a,b,c,e,f,n,p),x),Not(And(EqQ(a,C0),IntegerQ(p)))))),
ISetDelayed(630,UnifyInertTrigFunction(Times(Power(Times(d_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(Times(c_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_))),p_DEFAULT)),x_),
    Condition(Times(Power(Times(d,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x)))),m),Power(Plus(a,Times(b,Power(Times(CN1,c,$($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x)))),n))),p)),And(FreeQ(List(a,b,c,d,e,f,m,n,p),x),Not(And(EqQ(a,C0),IntegerQ(p)))))),
ISetDelayed(631,UnifyInertTrigFunction(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(Times(c_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_))),p_DEFAULT),Power(Times(d_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT)),x_),
    Condition(Times(Power(Times(CN1,d,$($s("§cos"),Plus(e,Times(C1D2,Pi),Times(f,x)))),m),Power(Plus(a,Times(b,Power(Times(CN1,c,$($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x)))),n))),p)),And(FreeQ(List(a,b,c,d,e,f,m,n,p),x),Not(And(EqQ(a,C0),IntegerQ(p)))))),
ISetDelayed(632,UnifyInertTrigFunction(Times(Power(Times(d_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(Times(c_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_))),p_DEFAULT)),x_),
    Condition(Times(Power(Times(CN1,d,$($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x)))),m),Power(Plus(a,Times(b,Power(Times(CN1,c,$($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x)))),n))),p)),And(FreeQ(List(a,b,c,d,e,f,m,n,p),x),Not(And(EqQ(a,C0),IntegerQ(p)))))),
ISetDelayed(633,UnifyInertTrigFunction(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(Times(c_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_))),p_DEFAULT),Power(Times(d_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT)),x_),
    Condition(Times(Power(Times(CN1,d,$($s("§cot"),Plus(e,Times(C1D2,Pi),Times(f,x)))),m),Power(Plus(a,Times(b,Power(Times(CN1,c,$($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x)))),n))),p)),And(FreeQ(List(a,b,c,d,e,f,m,n,p),x),Not(And(EqQ(a,C0),IntegerQ(p)))))),
ISetDelayed(634,UnifyInertTrigFunction(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(Times(c_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_))),p_DEFAULT),Power(Times(d_DEFAULT,$($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT)),x_),
    Condition(Times(Power(Times(CN1,d,$($s("§sec"),Plus(e,Times(C1D2,Pi),Times(f,x)))),m),Power(Plus(a,Times(b,Power(Times(CN1,c,$($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x)))),n))),p)),And(FreeQ(List(a,b,c,d,e,f,m,n,p),x),Not(And(EqQ(a,C0),IntegerQ(p)))))),
ISetDelayed(635,UnifyInertTrigFunction(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(Times(c_DEFAULT,$($s("§cot"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_))),p_DEFAULT),Power(Times(d_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),m_DEFAULT)),x_),
    Condition(Times(Power(Times(d,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x)))),m),Power(Plus(a,Times(b,Power(Times(CN1,c,$($s("§tan"),Plus(e,Times(C1D2,Pi),Times(f,x)))),n))),p)),And(FreeQ(List(a,b,c,d,e,f,m,n,p),x),Not(And(EqQ(a,C0),IntegerQ(p)))))),
ISetDelayed(636,UnifyInertTrigFunction(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT),x_),
    Condition(Power(Plus(a,Times(b,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x))))),n),FreeQ(List(a,b,e,f,n),x))),
ISetDelayed(637,UnifyInertTrigFunction(Times(Power(Times(g_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),p_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT)),x_),
    Condition(Times(Power(Times(g,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x)))),p),Power(Plus(a,Times(b,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x))))),m)),FreeQ(List(a,b,e,f,g,m,p),x))),
ISetDelayed(638,UnifyInertTrigFunction(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Times(g_DEFAULT,$($s("§sin"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),p_DEFAULT)),x_),
    Condition(Times(Power(Times(g,$($s("§cos"),Plus(e,Times(CN1,C1D2,Pi),Times(f,x)))),p),Power(Plus(a,Times(CN1,b,$($s("§csc"),Plus(e,Times(CN1,C1D2,Pi),Times(f,x))))),m)),FreeQ(List(a,b,e,f,g,m,p),x))),
ISetDelayed(639,UnifyInertTrigFunction(Times(Power(Times(g_DEFAULT,$($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),p_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT)),x_),
    Condition(Times(Power(Times(g,$($s("§sec"),Plus(e,Times(CN1,C1D2,Pi),Times(f,x)))),p),Power(Plus(a,Times(CN1,b,$($s("§csc"),Plus(e,Times(CN1,C1D2,Pi),Times(f,x))))),m)),FreeQ(List(a,b,e,f,g,m,p),x))),
ISetDelayed(640,UnifyInertTrigFunction(Times(Power(Plus(a_,Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Times(g_DEFAULT,$($s("§tan"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),p_DEFAULT)),x_),
    Condition(Times(Power(Times(CN1,g,$($s("§cot"),Plus(e,Times(C1D2,Pi),Times(f,x)))),p),Power(Plus(a,Times(b,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x))))),m)),FreeQ(List(a,b,e,f,g,m,p),x))),
ISetDelayed(641,UnifyInertTrigFunction(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT)),x_),
    Condition(Times(Power(Plus(a,Times(b,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x))))),m),Power(Plus(c,Times(d,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x))))),n)),FreeQ(List(a,b,c,d,e,f,m,n),x))),
ISetDelayed(642,UnifyInertTrigFunction(Times(Power(Times(g_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),p_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT)),x_),
    Condition(Times(Power(Times(g,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x)))),p),Power(Plus(a,Times(b,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x))))),m),Power(Plus(c,Times(d,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x))))),n)),FreeQ(List(a,b,c,d,e,f,g,m,n,p),x))),
ISetDelayed(643,UnifyInertTrigFunction(Times(Power(Times(g_DEFAULT,$($s("§cos"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),p_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT)),x_),
    Condition(Times(Power(Times(g,$($s("§sin"),Plus(e,Times(C1D2,Pi),Times(f,x)))),p),Power(Plus(a,Times(b,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x))))),m),Power(Plus(c,Times(d,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x))))),n)),FreeQ(List(a,b,c,d,e,f,g,m,n,p),x))),
ISetDelayed(644,UnifyInertTrigFunction(Times(Plus(A_DEFAULT,Times(B_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),Power(Times(d_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT)),x_),
    Condition(Times(Power(Plus(a,Times(b,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x))))),m),Power(Times(d,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x)))),n),Plus(ASymbol,Times(BSymbol,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x)))))),FreeQ(List(a,b,d,e,f,ASymbol,BSymbol,m,n),x))),
ISetDelayed(645,UnifyInertTrigFunction(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT),Power(Plus(A_DEFAULT,Times(B_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),p_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT)),x_),
    Condition(Times(Power(Plus(a,Times(b,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x))))),m),Power(Plus(c,Times(d,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x))))),n),Power(Plus(ASymbol,Times(BSymbol,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x))))),p)),FreeQ(List(a,b,c,d,e,f,ASymbol,BSymbol,m,n,p),x))),
ISetDelayed(646,UnifyInertTrigFunction(Times(Plus(A_DEFAULT,Times(B_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),Times(C_DEFAULT,Sqr($($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT)),x_),
    Condition(Times(Power(Plus(a,Times(b,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x))))),m),Plus(ASymbol,Times(BSymbol,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x)))),Times(CSymbol,Sqr($($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x))))))),FreeQ(List(a,b,e,f,ASymbol,BSymbol,CSymbol,m),x))),
ISetDelayed(647,UnifyInertTrigFunction(Times(Plus(A_DEFAULT,Times(C_DEFAULT,Sqr($($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT)),x_),
    Condition(Times(Power(Plus(a,Times(b,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x))))),m),Plus(ASymbol,Times(CSymbol,Sqr($($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x))))))),FreeQ(List(a,b,e,f,ASymbol,CSymbol,m),x))),
ISetDelayed(648,UnifyInertTrigFunction(Times(Plus(A_DEFAULT,Times(B_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),Times(C_DEFAULT,Sqr($($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Power(Times(d_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT)),x_),
    Condition(Times(Power(Plus(a,Times(b,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x))))),m),Power(Times(d,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x)))),n),Plus(ASymbol,Times(BSymbol,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x)))),Times(CSymbol,Sqr($($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x))))))),FreeQ(List(a,b,d,e,f,ASymbol,BSymbol,CSymbol,m,n),x))),
ISetDelayed(649,UnifyInertTrigFunction(Times(Plus(A_DEFAULT,Times(C_DEFAULT,Sqr($($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))))),Power(Times(d_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_)))),n_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($s("§sec"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),m_DEFAULT)),x_),
    Condition(Times(Power(Plus(a,Times(b,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x))))),m),Power(Times(d,$($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x)))),n),Plus(ASymbol,Times(CSymbol,Sqr($($s("§csc"),Plus(e,Times(C1D2,Pi),Times(f,x))))))),FreeQ(List(a,b,d,e,f,ASymbol,CSymbol,m,n),x))),
ISetDelayed(650,UnifyInertTrigFunction(u_,x_),
    u)
  );
}