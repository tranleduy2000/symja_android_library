package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$ps;
import static org.matheclipse.core.expression.F.$rubi;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.AtomQ;
import static org.matheclipse.core.expression.F.Block;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CI;
import static org.matheclipse.core.expression.F.Catch;
import static org.matheclipse.core.expression.F.CompoundExpression;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.Do;
import static org.matheclipse.core.expression.F.Equal;
import static org.matheclipse.core.expression.F.False;
import static org.matheclipse.core.expression.F.First;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.Function;
import static org.matheclipse.core.expression.F.Greater;
import static org.matheclipse.core.expression.F.GreaterEqual;
import static org.matheclipse.core.expression.F.Head;
import static org.matheclipse.core.expression.F.ISetDelayed;
import static org.matheclipse.core.expression.F.If;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.Integrate;
import static org.matheclipse.core.expression.F.Length;
import static org.matheclipse.core.expression.F.Less;
import static org.matheclipse.core.expression.F.LessEqual;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.MemberQ;
import static org.matheclipse.core.expression.F.Module;
import static org.matheclipse.core.expression.F.N;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Null;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Part;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.PossibleZeroQ;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Quiet;
import static org.matheclipse.core.expression.F.RealNumberQ;
import static org.matheclipse.core.expression.F.Reap;
import static org.matheclipse.core.expression.F.Refine;
import static org.matheclipse.core.expression.F.Rest;
import static org.matheclipse.core.expression.F.Return;
import static org.matheclipse.core.expression.F.SameQ;
import static org.matheclipse.core.expression.F.Scan;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Slot1;
import static org.matheclipse.core.expression.F.Sow;
import static org.matheclipse.core.expression.F.Throw;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.Together;
import static org.matheclipse.core.expression.F.True;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.CalculusFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.CalculusQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ComplexFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ComplexNumberQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EveryQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionOrNegativeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionalPowerFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionalPowerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.HalfIntegerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.HeldFormQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.HyperbolicQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IndependentQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntHide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegralFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InverseFunctionFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InverseFunctionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InverseHyperbolicQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InverseTrigQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LogQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Map2;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ProductQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ReapList;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SqrtNumberQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SqrtNumberSumQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.StopFunctionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.TrigHyperbolicFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.TrigQ;
/** 
 * UtilityFunctions rules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class UtilityFunctions0 { 
  public static IAST RULES = List( 
ISetDelayed(1,IntHide(u_,x_Symbol),
    Block(List(Set($s("§$showsteps"),False),Set($s("§$stepcounter"),Null)),Int(u,x))),
ISetDelayed(2,EveryQ($p("func"),$p("lst")),
    Catch(CompoundExpression(Scan(Function(If($($s("func"),Slot1),Null,Throw(False))),$s("lst")),True))),
ISetDelayed(3,Map2($p("func"),$p("lst1"),$p("lst2")),
    Module(List($s("ii")),ReapList(Do(Sow($($s("func"),Part($s("lst1"),$s("ii")),Part($s("lst2"),$s("ii")))),List($s("ii"),Length($s("lst1"))))))),
ISetDelayed(4,ReapList(u_),
    With(List(Set($s("lst"),Part(Reap(u),C2))),If(SameQ($s("lst"),List()),$s("lst"),Part($s("lst"),C1)))),
ISetDelayed(5,HalfIntegerQ($ps("u")),
    SameQ(Scan(Function(If(And(SameQ(Head(Slot1),$s("Rational")),Equal(Denominator(Slot1),C2)),Null,Return(False))),List(u)),Null)),
ISetDelayed(6,RationalQ($ps("u")),
    SameQ(Scan(Function(If(Or(IntegerQ(Slot1),SameQ(Head(Slot1),$s("Rational"))),Null,Return(False))),List(u)),Null)),
ISetDelayed(7,FractionOrNegativeQ($ps("u")),
    SameQ(Scan(Function(If(Or(FractionQ(Slot1),And(IntegerQ(Slot1),Less(Slot1,C0))),Null,Return(False))),List(u)),Null)),
ISetDelayed(8,SqrtNumberQ(Power(m_,n_)),
    Or(And(IntegerQ(n),SqrtNumberQ(m)),And(IntegerQ(Plus(n,Negate(C1D2))),RationalQ(m)))),
ISetDelayed(9,SqrtNumberQ(Times(u_,v_)),
    And(SqrtNumberQ(u),SqrtNumberQ(v))),
ISetDelayed(10,SqrtNumberQ(u_),
    Or(RationalQ(u),SameQ(u,CI))),
ISetDelayed(11,SqrtNumberSumQ(u_),
    Or(And(SumQ(u),SqrtNumberQ(First(u)),SqrtNumberQ(Rest(u))),And(ProductQ(u),SqrtNumberQ(First(u)),SqrtNumberSumQ(Rest(u))))),
ISetDelayed(12,IndependentQ(u_,x_),
    FreeQ(u,x)),
ISetDelayed(13,FractionalPowerFreeQ(u_),
    If(AtomQ(u),True,If(And(FractionalPowerQ(u),Not(AtomQ(Part(u,C1)))),False,Catch(CompoundExpression(Scan(Function(If(FractionalPowerFreeQ(Slot1),Null,Throw(False))),u),True))))),
ISetDelayed(14,ComplexFreeQ(u_),
    If(AtomQ(u),Not(ComplexNumberQ(u)),SameQ(Scan(Function(If(ComplexFreeQ(Slot1),Null,Return(False))),u),Null))),
ISetDelayed(15,LogQ(u_),
    SameQ(Head(u),$s("Log"))),
ISetDelayed(16,TrigQ(u_),
    MemberQ($s("§$trigfunctions"),If(AtomQ(u),u,Head(u)))),
ISetDelayed(17,HyperbolicQ(u_),
    MemberQ($s("§$hyperbolicfunctions"),If(AtomQ(u),u,Head(u)))),
ISetDelayed(18,InverseTrigQ(u_),
    MemberQ($s("§$inversetrigfunctions"),If(AtomQ(u),u,Head(u)))),
ISetDelayed(19,InverseHyperbolicQ(u_),
    MemberQ($s("§$inversehyperbolicfunctions"),If(AtomQ(u),u,Head(u)))),
ISetDelayed(20,CalculusQ(u_),
    MemberQ($s("§$calculusfunctions"),If(AtomQ(u),u,Head(u)))),
ISetDelayed(21,StopFunctionQ(u_),
    If(AtomQ(Head(u)),MemberQ($s("§$stopfunctions"),Head(u)),StopFunctionQ(Head(u)))),
ISetDelayed(22,HeldFormQ(u_),
    If(AtomQ(Head(u)),MemberQ($s("§$heldfunctions"),Head(u)),HeldFormQ(Head(u)))),
ISetDelayed(23,InverseFunctionQ(u_),
    Or(LogQ(u),And(InverseTrigQ(u),LessEqual(Length(u),C1)),InverseHyperbolicQ(u),SameQ(Head(u),$s("§mods")),SameQ(Head(u),$s("PolyLog")))),
ISetDelayed(24,TrigHyperbolicFreeQ(u_,x_Symbol),
    If(AtomQ(u),True,If(Or(TrigQ(u),HyperbolicQ(u),CalculusQ(u)),FreeQ(u,x),Catch(CompoundExpression(Scan(Function(If(TrigHyperbolicFreeQ(Slot1,x),Null,Throw(False))),u),True))))),
ISetDelayed(25,InverseFunctionFreeQ(u_,x_Symbol),
    If(AtomQ(u),True,If(Or(InverseFunctionQ(u),CalculusQ(u),SameQ(Head(u),$s("Hypergeometric2F1")),SameQ(Head(u),$s("AppellF1"))),FreeQ(u,x),Catch(CompoundExpression(Scan(Function(If(InverseFunctionFreeQ(Slot1,x),Null,Throw(False))),u),True))))),
ISetDelayed(26,CalculusFreeQ(u_,x_),
    If(AtomQ(u),True,If(Or(And(CalculusQ(u),SameQ(Part(u,C2),x)),HeldFormQ(u)),False,Catch(CompoundExpression(Scan(Function(If(CalculusFreeQ(Slot1,x),Null,Throw(False))),u),True))))),
ISetDelayed(27,IntegralFreeQ(u_),
    And(FreeQ(u,Integrate),FreeQ(u,$rubi("Integrate::Integral")),FreeQ(u,$rubi("Integrate::Unintegrable")),FreeQ(u,$rubi("Integrate::CannotIntegrate")))),
ISetDelayed(28,EqQ(u_,v_),
    Or(Quiet(PossibleZeroQ(Plus(u,Negate(v)))),SameQ(Refine(Equal(u,v)),True))),
ISetDelayed(29,NeQ(u_,v_),
    Not(Or(Quiet(PossibleZeroQ(Plus(u,Negate(v)))),SameQ(Refine(Equal(u,v)),True)))),
ISetDelayed(30,IGtQ(u_,n_),
    And(IntegerQ(u),Greater(u,n))),
ISetDelayed(31,ILtQ(u_,n_),
    And(IntegerQ(u),Less(u,n))),
ISetDelayed(32,IGeQ(u_,n_),
    And(IntegerQ(u),GreaterEqual(u,n))),
ISetDelayed(33,ILeQ(u_,n_),
    And(IntegerQ(u),LessEqual(u,n))),
ISetDelayed(34,GtQ(u_,v_),
    If(RealNumberQ(u),If(RealNumberQ(v),Greater(u,v),With(List(Set($s("vn"),N(Together(v)))),And(SameQ(Head($s("vn")),$s("Real")),Greater(u,$s("vn"))))),With(List(Set($s("un"),N(Together(u)))),If(SameQ(Head($s("un")),$s("Real")),If(RealNumberQ(v),Greater($s("un"),v),With(List(Set($s("vn"),N(Together(v)))),And(SameQ(Head($s("vn")),$s("Real")),Greater($s("un"),$s("vn"))))),False))))
  );
}
