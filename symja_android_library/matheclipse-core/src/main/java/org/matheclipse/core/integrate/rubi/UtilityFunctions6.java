package org.matheclipse.core.integrate.rubi;


import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.*;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ActivateTrig;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.CalculusQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ComplexFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.DeactivateTrig;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.DeactivateTrigAux;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ExpandToSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FalseQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FixInertTrigFunction;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionalPowerOfLinear;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionalPowerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FreeFactors;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FunctionOfLinear;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.HyperbolicQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InertReciprocalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InertTrigFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InertTrigQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegerQuotientQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegersQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InverseFunctionOfLinear;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InverseFunctionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LinearQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LogQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NonfreeFactors;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NormalizeLeadTermSigns;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NormalizeTogether;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NumericFactor;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PowerOfInertTrigSumQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.PowerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ProductQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RectifyCotangent;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RectifyTangent;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ReduceInertTrig;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RemoveContent;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyAntiderivative;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyAntiderivativeSum;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SimplifyIntegrand;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SmartDenominator;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SmartNumerator;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Subst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SubstFor;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SubstForAux;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SubstForFractionalPower;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SubstForFractionalPowerOfLinear;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SubstForHyperbolic;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SubstForTrig;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.TrigQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.TryPureTanSubst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.TryPureTanhSubst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.TryTanhSubst;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.UnifyInertTrigFunction;
/** 
 * UtilityFunctions rules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class UtilityFunctions6 { 
  public static IAST RULES = List( 
ISetDelayed(475,SimplifyAntiderivative(ArcTan(Plus(a_DEFAULT,Times(b_DEFAULT,Tan(u_)),Times(c_DEFAULT,Sqr(Tan(u_))))),x_Symbol),
    Condition(If(EvenQ(Denominator(NumericFactor(Together(u)))),ArcTan(NormalizeTogether(Times(Plus(a,c,Negate(C1),Times(Plus(a,Negate(c),Negate(C1)),Cos(Times(C2,u))),Times(b,Sin(Times(C2,u)))),Power(Plus(a,c,C1,Times(Plus(a,Negate(c),C1),Cos(Times(C2,u))),Times(b,Sin(Times(C2,u)))),-1)))),ArcTan(NormalizeTogether(Times(Plus(c,Times(Plus(a,Negate(c),Negate(C1)),Sqr(Cos(u))),Times(b,Cos(u),Sin(u))),Power(Plus(c,Times(Plus(a,Negate(c),C1),Sqr(Cos(u))),Times(b,Cos(u),Sin(u))),-1))))),And(FreeQ(List(a,b,c),x),ComplexFreeQ(u)))),
ISetDelayed(476,SimplifyAntiderivative(ArcTan(Plus(a_DEFAULT,Times(b_DEFAULT,Plus(d_DEFAULT,Times(e_DEFAULT,Tan(u_)))),Times(c_DEFAULT,Sqr(Plus(f_DEFAULT,Times(g_DEFAULT,Tan(u_))))))),x_Symbol),
    Condition(SimplifyAntiderivative(ArcTan(Plus(a,Times(b,d),Times(c,Sqr(f)),Times(Plus(Times(b,e),Times(C2,c,f,g)),Tan(u)),Times(c,Sqr(g),Sqr(Tan(u))))),x),And(FreeQ(List(a,b,c),x),ComplexFreeQ(u)))),
ISetDelayed(477,SimplifyAntiderivative(ArcTan(Plus(a_DEFAULT,Times(c_DEFAULT,Sqr(Tan(u_))))),x_Symbol),
    Condition(If(EvenQ(Denominator(NumericFactor(Together(u)))),ArcTan(NormalizeTogether(Times(Plus(a,c,Negate(C1),Times(Plus(a,Negate(c),Negate(C1)),Cos(Times(C2,u)))),Power(Plus(a,c,C1,Times(Plus(a,Negate(c),C1),Cos(Times(C2,u)))),-1)))),ArcTan(NormalizeTogether(Times(Plus(c,Times(Plus(a,Negate(c),Negate(C1)),Sqr(Cos(u)))),Power(Plus(c,Times(Plus(a,Negate(c),C1),Sqr(Cos(u)))),-1))))),And(FreeQ(List(a,c),x),ComplexFreeQ(u)))),
ISetDelayed(478,SimplifyAntiderivative(ArcTan(Plus(a_DEFAULT,Times(c_DEFAULT,Sqr(Plus(f_DEFAULT,Times(g_DEFAULT,Tan(u_))))))),x_Symbol),
    Condition(SimplifyAntiderivative(ArcTan(Plus(a,Times(c,Sqr(f)),Times(C2,c,f,g,Tan(u)),Times(c,Sqr(g),Sqr(Tan(u))))),x),And(FreeQ(List(a,c),x),ComplexFreeQ(u)))),
ISetDelayed(479,SimplifyAntiderivative(u_,x_Symbol),
    If(FreeQ(u,x),C0,If(LogQ(u),Log(RemoveContent(Part(u,C1),x)),If(SumQ(u),SimplifyAntiderivativeSum(Map(Function(SimplifyAntiderivative(Slot1,x)),u),x),u)))),
ISetDelayed(480,SimplifyAntiderivativeSum(Plus(v_DEFAULT,Times(B_DEFAULT,Log(Cos(u_))),Times(A_DEFAULT,Log(Plus(a_,Times(b_DEFAULT,Power(Tan(u_),n_DEFAULT)))))),x_Symbol),
    Condition(Plus(SimplifyAntiderivativeSum(v,x),Times(ASymbol,Log(RemoveContent(Plus(Times(a,Power(Cos(u),n)),Times(b,Power(Sin(u),n))),x)))),And(FreeQ(List(a,b,ASymbol,BSymbol),x),IntegerQ(n),EqQ(Plus(Times(n,ASymbol),Negate(BSymbol)),C0)))),
ISetDelayed(481,SimplifyAntiderivativeSum(Plus(v_DEFAULT,Times(A_DEFAULT,Log(Plus(a_,Times(b_DEFAULT,Power(Cot(u_),n_DEFAULT))))),Times(B_DEFAULT,Log(Sin(u_)))),x_Symbol),
    Condition(Plus(SimplifyAntiderivativeSum(v,x),Times(ASymbol,Log(RemoveContent(Plus(Times(a,Power(Sin(u),n)),Times(b,Power(Cos(u),n))),x)))),And(FreeQ(List(a,b,ASymbol,BSymbol),x),IntegerQ(n),EqQ(Plus(Times(n,ASymbol),Negate(BSymbol)),C0)))),
ISetDelayed(482,SimplifyAntiderivativeSum(Plus(v_DEFAULT,Times(A_DEFAULT,Log(Plus(a_,Times(b_DEFAULT,Power(Tan(u_),n_DEFAULT))))),Times(B_DEFAULT,Log(Plus(c_,Times(d_DEFAULT,Power(Tan(u_),n_DEFAULT)))))),x_Symbol),
    Condition(Plus(SimplifyAntiderivativeSum(v,x),Times(ASymbol,Log(RemoveContent(Plus(Times(a,Power(Cos(u),n)),Times(b,Power(Sin(u),n))),x))),Times(BSymbol,Log(RemoveContent(Plus(Times(c,Power(Cos(u),n)),Times(d,Power(Sin(u),n))),x)))),And(FreeQ(List(a,b,c,d,ASymbol,BSymbol),x),IntegerQ(n),EqQ(Plus(ASymbol,BSymbol),C0)))),
ISetDelayed(483,SimplifyAntiderivativeSum(Plus(v_DEFAULT,Times(A_DEFAULT,Log(Plus(a_,Times(b_DEFAULT,Power(Cot(u_),n_DEFAULT))))),Times(B_DEFAULT,Log(Plus(c_,Times(d_DEFAULT,Power(Cot(u_),n_DEFAULT)))))),x_Symbol),
    Condition(Plus(SimplifyAntiderivativeSum(v,x),Times(ASymbol,Log(RemoveContent(Plus(Times(b,Power(Cos(u),n)),Times(a,Power(Sin(u),n))),x))),Times(BSymbol,Log(RemoveContent(Plus(Times(d,Power(Cos(u),n)),Times(c,Power(Sin(u),n))),x)))),And(FreeQ(List(a,b,c,d,ASymbol,BSymbol),x),IntegerQ(n),EqQ(Plus(ASymbol,BSymbol),C0)))),
ISetDelayed(484,SimplifyAntiderivativeSum(Plus(v_DEFAULT,Times(A_DEFAULT,Log(Plus(a_,Times(b_DEFAULT,Power(Tan(u_),n_DEFAULT))))),Times(B_DEFAULT,Log(Plus(c_,Times(d_DEFAULT,Power(Tan(u_),n_DEFAULT))))),Times(C_DEFAULT,Log(Plus(e_,Times(f_DEFAULT,Power(Tan(u_),n_DEFAULT)))))),x_Symbol),
    Condition(Plus(SimplifyAntiderivativeSum(v,x),Times(ASymbol,Log(RemoveContent(Plus(Times(a,Power(Cos(u),n)),Times(b,Power(Sin(u),n))),x))),Times(BSymbol,Log(RemoveContent(Plus(Times(c,Power(Cos(u),n)),Times(d,Power(Sin(u),n))),x))),Times(CSymbol,Log(RemoveContent(Plus(Times(e,Power(Cos(u),n)),Times(f,Power(Sin(u),n))),x)))),And(FreeQ(List(a,b,c,d,e,f,ASymbol,BSymbol,CSymbol),x),IntegerQ(n),EqQ(Plus(ASymbol,BSymbol,CSymbol),C0)))),
ISetDelayed(485,SimplifyAntiderivativeSum(Plus(v_DEFAULT,Times(A_DEFAULT,Log(Plus(a_,Times(b_DEFAULT,Power(Cot(u_),n_DEFAULT))))),Times(B_DEFAULT,Log(Plus(c_,Times(d_DEFAULT,Power(Cot(u_),n_DEFAULT))))),Times(C_DEFAULT,Log(Plus(e_,Times(f_DEFAULT,Power(Cot(u_),n_DEFAULT)))))),x_Symbol),
    Condition(Plus(SimplifyAntiderivativeSum(v,x),Times(ASymbol,Log(RemoveContent(Plus(Times(b,Power(Cos(u),n)),Times(a,Power(Sin(u),n))),x))),Times(BSymbol,Log(RemoveContent(Plus(Times(d,Power(Cos(u),n)),Times(c,Power(Sin(u),n))),x))),Times(CSymbol,Log(RemoveContent(Plus(Times(f,Power(Cos(u),n)),Times(e,Power(Sin(u),n))),x)))),And(FreeQ(List(a,b,c,d,e,f,ASymbol,BSymbol,CSymbol),x),IntegerQ(n),EqQ(Plus(ASymbol,BSymbol,CSymbol),C0)))),
ISetDelayed(486,SimplifyAntiderivativeSum(u_,x_Symbol),
    u),
ISetDelayed(487,RectifyTangent(u_,a_,b_,x_Symbol),
    If(MatchQ(Together(a),Times(d_DEFAULT,Complex(C0,c_))),Module(List(Set(c,Times(a,Power(CI,-1))),e),If(LtQ(c,C0),RectifyTangent(u,Negate(a),Negate(b),x),If(EqQ(c,C1),If(EvenQ(Denominator(NumericFactor(Together(u)))),Times(CI,b,C1D2,ArcTanh(Sin(Times(C2,u)))),Times(CI,b,C1D2,ArcTanh(Times(C2,Cos(u),Sin(u))))),CompoundExpression(Set(e,SmartDenominator(c)),Set(c,Times(c,e)),Plus(Times(CI,b,C1D2,Log(RemoveContent(Plus(Times(e,Cos(u)),Times(c,Sin(u))),x))),Times(CN1,CI,b,C1D2,Log(RemoveContent(Plus(Times(e,Cos(u)),Times(CN1,c,Sin(u))),x)))))))),If(LtQ(a,C0),RectifyTangent(u,Negate(a),Negate(b),x),If(EqQ(a,C1),Times(b,SimplifyAntiderivative(u,x)),Module(List(c,$s("numr"),$s("denr")),If(EvenQ(Denominator(NumericFactor(Together(u)))),CompoundExpression(Set(c,Simplify(Times(Plus(C1,a),Power(Plus(C1,Negate(a)),-1)))),Set($s("numr"),SmartNumerator(c)),Set($s("denr"),SmartDenominator(c)),Plus(Times(b,SimplifyAntiderivative(u,x)),Times(CN1,b,ArcTan(NormalizeLeadTermSigns(Times($s("denr"),Sin(Times(C2,u)),Power(Plus($s("numr"),Times($s("denr"),Cos(Times(C2,u)))),-1))))))),If(GtQ(a,C1),CompoundExpression(Set(c,Simplify(Power(Plus(a,Negate(C1)),-1))),Set($s("numr"),SmartNumerator(c)),Set($s("denr"),SmartDenominator(c)),Plus(Times(b,SimplifyAntiderivative(u,x)),Times(b,ArcTan(NormalizeLeadTermSigns(Times($s("denr"),Cos(u),Sin(u),Power(Plus($s("numr"),Times($s("denr"),Sqr(Sin(u)))),-1))))))),CompoundExpression(Set(c,Simplify(Times(a,Power(Plus(C1,Negate(a)),-1)))),Set($s("numr"),SmartNumerator(c)),Set($s("denr"),SmartDenominator(c)),Plus(Times(b,SimplifyAntiderivative(u,x)),Times(CN1,b,ArcTan(NormalizeLeadTermSigns(Times($s("denr"),Cos(u),Sin(u),Power(Plus($s("numr"),Times($s("denr"),Sqr(Cos(u)))),-1)))))))))))))),
ISetDelayed(488,RectifyTangent(u_,a_,b_,r_,x_Symbol),
    If(And(MatchQ(Together(a),Times(d_DEFAULT,Complex(C0,c_))),MatchQ(Together(b),Times(d_DEFAULT,Complex(C0,c_)))),Module(List(Set(c,Times(a,Power(CI,-1))),Set(d,Times(b,Power(CI,-1))),e),If(LtQ(d,C0),RectifyTangent(u,Negate(a),Negate(b),Negate(r),x),CompoundExpression(Set(e,SmartDenominator(Together(Plus(c,Times(d,x))))),Set(c,Times(c,e)),Set(d,Times(d,e)),If(EvenQ(Denominator(NumericFactor(Together(u)))),Plus(Times(CI,r,C1D4,Log(RemoveContent(Plus(Simplify(Plus(Sqr(Plus(c,e)),Sqr(d))),Times(Simplify(Plus(Sqr(Plus(c,e)),Negate(Sqr(d)))),Cos(Times(C2,u))),Times(Simplify(Times(C2,Plus(c,e),d)),Sin(Times(C2,u)))),x))),Times(CN1,CI,r,C1D4,Log(RemoveContent(Plus(Simplify(Plus(Sqr(Plus(c,Negate(e))),Sqr(d))),Times(Simplify(Plus(Sqr(Plus(c,Negate(e))),Negate(Sqr(d)))),Cos(Times(C2,u))),Times(Simplify(Times(C2,Plus(c,Negate(e)),d)),Sin(Times(C2,u)))),x)))),Plus(Times(CI,r,C1D4,Log(RemoveContent(Plus(Simplify(Sqr(Plus(c,e))),Times(Simplify(Times(C2,Plus(c,e),d)),Cos(u),Sin(u)),Times(CN1,Simplify(Plus(Sqr(Plus(c,e)),Negate(Sqr(d)))),Sqr(Sin(u)))),x))),Times(CN1,CI,r,C1D4,Log(RemoveContent(Plus(Simplify(Sqr(Plus(c,Negate(e)))),Times(Simplify(Times(C2,Plus(c,Negate(e)),d)),Cos(u),Sin(u)),Times(CN1,Simplify(Plus(Sqr(Plus(c,Negate(e))),Negate(Sqr(d)))),Sqr(Sin(u)))),x)))))))),If(LtQ(b,C0),RectifyTangent(u,Negate(a),Negate(b),Negate(r),x),If(EvenQ(Denominator(NumericFactor(Together(u)))),Plus(Times(r,SimplifyAntiderivative(u,x)),Times(r,ArcTan(Simplify(Times(Plus(Times(C2,a,b,Cos(Times(C2,u))),Times(CN1,Plus(C1,Sqr(a),Negate(Sqr(b))),Sin(Times(C2,u)))),Power(Plus(Sqr(a),Sqr(Plus(C1,b)),Times(Plus(C1,Sqr(a),Negate(Sqr(b))),Cos(Times(C2,u))),Times(C2,a,b,Sin(Times(C2,u)))),-1)))))),Plus(Times(r,SimplifyAntiderivative(u,x)),Times(CN1,r,ArcTan(ActivateTrig(Simplify(Times(Plus(Times(a,b),Times(CN1,C2,a,b,Sqr($($s("§cos"),u))),Times(Plus(C1,Sqr(a),Negate(Sqr(b))),$($s("§cos"),u),$($s("§sin"),u))),Power(Plus(Times(b,Plus(C1,b)),Times(Plus(C1,Sqr(a),Negate(Sqr(b))),Sqr($($s("§cos"),u))),Times(C2,a,b,$($s("§cos"),u),$($s("§sin"),u))),-1))))))))))),
ISetDelayed(489,RectifyCotangent(u_,a_,b_,x_Symbol),
    If(MatchQ(Together(a),Times(d_DEFAULT,Complex(C0,c_))),Module(List(Set(c,Times(a,Power(CI,-1))),e),If(LtQ(c,C0),RectifyCotangent(u,Negate(a),Negate(b),x),If(EqQ(c,C1),If(EvenQ(Denominator(NumericFactor(Together(u)))),Times(CN1,CI,b,C1D2,ArcTanh(Sin(Times(C2,u)))),Times(CN1,CI,b,C1D2,ArcTanh(Times(C2,Cos(u),Sin(u))))),CompoundExpression(Set(e,SmartDenominator(c)),Set(c,Times(c,e)),Plus(Times(CN1,CI,b,C1D2,Log(RemoveContent(Plus(Times(c,Cos(u)),Times(e,Sin(u))),x))),Times(CI,b,C1D2,Log(RemoveContent(Plus(Times(c,Cos(u)),Times(CN1,e,Sin(u))),x)))))))),If(LtQ(a,C0),RectifyCotangent(u,Negate(a),Negate(b),x),If(EqQ(a,C1),Times(b,SimplifyAntiderivative(u,x)),Module(List(c,$s("numr"),$s("denr")),If(EvenQ(Denominator(NumericFactor(Together(u)))),CompoundExpression(Set(c,Simplify(Times(Plus(C1,a),Power(Plus(C1,Negate(a)),-1)))),Set($s("numr"),SmartNumerator(c)),Set($s("denr"),SmartDenominator(c)),Plus(Times(b,SimplifyAntiderivative(u,x)),Times(b,ArcTan(NormalizeLeadTermSigns(Times($s("denr"),Sin(Times(C2,u)),Power(Plus($s("numr"),Times(CN1,$s("denr"),Cos(Times(C2,u)))),-1))))))),If(GtQ(a,C1),CompoundExpression(Set(c,Simplify(Power(Plus(a,Negate(C1)),-1))),Set($s("numr"),SmartNumerator(c)),Set($s("denr"),SmartDenominator(c)),Plus(Times(b,SimplifyAntiderivative(u,x)),Times(CN1,b,ArcTan(NormalizeLeadTermSigns(Times($s("denr"),Cos(u),Sin(u),Power(Plus($s("numr"),Times($s("denr"),Sqr(Cos(u)))),-1))))))),CompoundExpression(Set(c,Simplify(Times(a,Power(Plus(C1,Negate(a)),-1)))),Set($s("numr"),SmartNumerator(c)),Set($s("denr"),SmartDenominator(c)),Plus(Times(b,SimplifyAntiderivative(u,x)),Times(b,ArcTan(NormalizeLeadTermSigns(Times($s("denr"),Cos(u),Sin(u),Power(Plus($s("numr"),Times($s("denr"),Sqr(Sin(u)))),-1)))))))))))))),
ISetDelayed(490,RectifyCotangent(u_,a_,b_,r_,x_Symbol),
    If(And(MatchQ(Together(a),Times(d_DEFAULT,Complex(C0,c_))),MatchQ(Together(b),Times(d_DEFAULT,Complex(C0,c_)))),Module(List(Set(c,Times(a,Power(CI,-1))),Set(d,Times(b,Power(CI,-1))),e),If(LtQ(d,C0),RectifyTangent(u,Negate(a),Negate(b),Negate(r),x),CompoundExpression(Set(e,SmartDenominator(Together(Plus(c,Times(d,x))))),Set(c,Times(c,e)),Set(d,Times(d,e)),If(EvenQ(Denominator(NumericFactor(Together(u)))),Plus(Times(CI,r,C1D4,Log(RemoveContent(Plus(Simplify(Plus(Sqr(Plus(c,e)),Sqr(d))),Times(CN1,Simplify(Plus(Sqr(Plus(c,e)),Negate(Sqr(d)))),Cos(Times(C2,u))),Times(Simplify(Times(C2,Plus(c,e),d)),Sin(Times(C2,u)))),x))),Times(CN1,CI,r,C1D4,Log(RemoveContent(Plus(Simplify(Plus(Sqr(Plus(c,Negate(e))),Sqr(d))),Times(CN1,Simplify(Plus(Sqr(Plus(c,Negate(e))),Negate(Sqr(d)))),Cos(Times(C2,u))),Times(Simplify(Times(C2,Plus(c,Negate(e)),d)),Sin(Times(C2,u)))),x)))),Plus(Times(CI,r,C1D4,Log(RemoveContent(Plus(Simplify(Sqr(Plus(c,e))),Times(CN1,Simplify(Plus(Sqr(Plus(c,e)),Negate(Sqr(d)))),Sqr(Cos(u))),Times(Simplify(Times(C2,Plus(c,e),d)),Cos(u),Sin(u))),x))),Times(CN1,CI,r,C1D4,Log(RemoveContent(Plus(Simplify(Sqr(Plus(c,Negate(e)))),Times(CN1,Simplify(Plus(Sqr(Plus(c,Negate(e))),Negate(Sqr(d)))),Sqr(Cos(u))),Times(Simplify(Times(C2,Plus(c,Negate(e)),d)),Cos(u),Sin(u))),x)))))))),If(LtQ(b,C0),RectifyCotangent(u,Negate(a),Negate(b),Negate(r),x),If(EvenQ(Denominator(NumericFactor(Together(u)))),Plus(Times(CN1,r,SimplifyAntiderivative(u,x)),Times(CN1,r,ArcTan(Simplify(Times(Plus(Times(C2,a,b,Cos(Times(C2,u))),Times(Plus(C1,Sqr(a),Negate(Sqr(b))),Sin(Times(C2,u)))),Power(Plus(Sqr(a),Sqr(Plus(C1,b)),Times(CN1,Plus(C1,Sqr(a),Negate(Sqr(b))),Cos(Times(C2,u))),Times(C2,a,b,Sin(Times(C2,u)))),-1)))))),Plus(Times(CN1,r,SimplifyAntiderivative(u,x)),Times(CN1,r,ArcTan(ActivateTrig(Simplify(Times(Plus(Times(a,b),Times(CN1,C2,a,b,Sqr($($s("§sin"),u))),Times(Plus(C1,Sqr(a),Negate(Sqr(b))),$($s("§cos"),u),$($s("§sin"),u))),Power(Plus(Times(b,Plus(C1,b)),Times(Plus(C1,Sqr(a),Negate(Sqr(b))),Sqr($($s("§sin"),u))),Times(C2,a,b,$($s("§cos"),u),$($s("§sin"),u))),-1))))))))))),
ISetDelayed(491,SmartNumerator(Power(u_,n_)),
    Condition(SmartDenominator(Power(u,Negate(n))),And(RationalQ(n),Less(n,C0)))),
ISetDelayed(492,SmartNumerator(Times(u_,v_)),
    Times(SmartNumerator(u),SmartNumerator(v))),
ISetDelayed(493,SmartNumerator(u_),
    Numerator(u)),
ISetDelayed(494,SmartDenominator(Power(u_,n_)),
    Condition(SmartNumerator(Power(u,Negate(n))),And(RationalQ(n),Less(n,C0)))),
ISetDelayed(495,SmartDenominator(Times(u_,v_)),
    Times(SmartDenominator(u),SmartDenominator(v))),
ISetDelayed(496,SmartDenominator(u_),
    Denominator(u)),
ISetDelayed(497,SubstFor(w_,v_,u_,x_),
    SimplifyIntegrand(Times(w,SubstFor(v,u,x)),x)),
ISetDelayed(498,SubstFor(v_,u_,x_),
    If(AtomQ(v),Subst(u,v,x),If(Not(InertTrigFreeQ(u)),SubstFor(v,ActivateTrig(u),x),If(NeQ(FreeFactors(v,x),C1),SubstFor(NonfreeFactors(v,x),u,Times(x,Power(FreeFactors(v,x),-1))),Switch(Head(v),$s("Sin"),SubstForTrig(u,x,Sqrt(Plus(C1,Negate(Sqr(x)))),Part(v,C1),x),$s("Cos"),SubstForTrig(u,Sqrt(Plus(C1,Negate(Sqr(x)))),x,Part(v,C1),x),$s("Tan"),SubstForTrig(u,Times(x,Power(Plus(C1,Sqr(x)),CN1D2)),Power(Plus(C1,Sqr(x)),CN1D2),Part(v,C1),x),$s("Cot"),SubstForTrig(u,Power(Plus(C1,Sqr(x)),CN1D2),Times(x,Power(Plus(C1,Sqr(x)),CN1D2)),Part(v,C1),x),$s("Sec"),SubstForTrig(u,Power(Plus(C1,Negate(Sqr(x))),CN1D2),Power(x,-1),Part(v,C1),x),$s("Csc"),SubstForTrig(u,Power(x,-1),Power(Plus(C1,Negate(Sqr(x))),CN1D2),Part(v,C1),x),$s("Sinh"),SubstForHyperbolic(u,x,Sqrt(Plus(C1,Sqr(x))),Part(v,C1),x),$s("Cosh"),SubstForHyperbolic(u,Sqrt(Plus(CN1,Sqr(x))),x,Part(v,C1),x),$s("Tanh"),SubstForHyperbolic(u,Times(x,Power(Plus(C1,Negate(Sqr(x))),CN1D2)),Power(Plus(C1,Negate(Sqr(x))),CN1D2),Part(v,C1),x),$s("Coth"),SubstForHyperbolic(u,Power(Plus(CN1,Sqr(x)),CN1D2),Times(x,Power(Plus(CN1,Sqr(x)),CN1D2)),Part(v,C1),x),$s("Sech"),SubstForHyperbolic(u,Power(Plus(CN1,Sqr(x)),CN1D2),Power(x,-1),Part(v,C1),x),$s("Csch"),SubstForHyperbolic(u,Power(x,-1),Power(Plus(C1,Sqr(x)),CN1D2),Part(v,C1),x),$b(),SubstForAux(u,v,x)))))),
ISetDelayed(499,SubstForAux(u_,v_,x_),
    If(SameQ(u,v),x,If(AtomQ(u),If(And(PowerQ(v),FreeQ(Part(v,C2),x),EqQ(u,Part(v,C1))),Power(x,Simplify(Power(Part(v,C2),-1))),u),If(And(PowerQ(u),FreeQ(Part(u,C2),x)),If(EqQ(Part(u,C1),v),Power(x,Part(u,C2)),If(And(PowerQ(v),FreeQ(Part(v,C2),x),EqQ(Part(u,C1),Part(v,C1))),Power(x,Simplify(Times(Part(u,C2),Power(Part(v,C2),-1)))),Power(SubstForAux(Part(u,C1),v,x),Part(u,C2)))),If(And(ProductQ(u),NeQ(FreeFactors(u,x),C1)),Times(FreeFactors(u,x),SubstForAux(NonfreeFactors(u,x),v,x)),If(And(ProductQ(u),ProductQ(v)),SubstForAux(First(u),First(v),x),Map(Function(SubstForAux(Slot1,v,x)),u))))))),
ISetDelayed(500,SubstForTrig(u_,$p("§sin"),$p("§cos"),v_,x_),
    If(AtomQ(u),u,If(And(TrigQ(u),IntegerQuotientQ(Part(u,C1),v)),If(Or(SameQ(Part(u,C1),v),EqQ(Part(u,C1),v)),Switch(Head(u),$s("Sin"),$s("§sin"),$s("Cos"),$s("§cos"),$s("Tan"),Times($s("§sin"),Power($s("§cos"),-1)),$s("Cot"),Times($s("§cos"),Power($s("§sin"),-1)),$s("Sec"),Power($s("§cos"),-1),$s("Csc"),Power($s("§sin"),-1)),Map(Function(SubstForTrig(Slot1,$s("§sin"),$s("§cos"),v,x)),ReplaceAll(TrigExpand($(Head(u),Times(Simplify(Times(Part(u,C1),Power(v,-1))),x))),Rule(x,v)))),If(And(ProductQ(u),SameQ(Head(Part(u,C1)),$s("Cos")),SameQ(Head(Part(u,C2)),$s("Sin")),EqQ(Part(u,C1,C1),Times(C1D2,v)),EqQ(Part(u,C2,C1),Times(C1D2,v))),Times(C1D2,$s("§sin"),SubstForTrig(Drop(u,C2),$s("§sin"),$s("§cos"),v,x)),Map(Function(SubstForTrig(Slot1,$s("§sin"),$s("§cos"),v,x)),u))))),
ISetDelayed(501,SubstForHyperbolic(u_,$p("§sinh"),$p("§cosh"),v_,x_),
    If(AtomQ(u),u,If(And(HyperbolicQ(u),IntegerQuotientQ(Part(u,C1),v)),If(Or(SameQ(Part(u,C1),v),EqQ(Part(u,C1),v)),Switch(Head(u),$s("Sinh"),$s("§sinh"),$s("Cosh"),$s("§cosh"),$s("Tanh"),Times($s("§sinh"),Power($s("§cosh"),-1)),$s("Coth"),Times($s("§cosh"),Power($s("§sinh"),-1)),$s("Sech"),Power($s("§cosh"),-1),$s("Csch"),Power($s("§sinh"),-1)),Map(Function(SubstForHyperbolic(Slot1,$s("§sinh"),$s("§cosh"),v,x)),ReplaceAll(TrigExpand($(Head(u),Times(Simplify(Times(Part(u,C1),Power(v,-1))),x))),Rule(x,v)))),If(And(ProductQ(u),SameQ(Head(Part(u,C1)),$s("Cosh")),SameQ(Head(Part(u,C2)),$s("Sinh")),EqQ(Part(u,C1,C1),Times(C1D2,v)),EqQ(Part(u,C2,C1),Times(C1D2,v))),Times(C1D2,$s("§sinh"),SubstForHyperbolic(Drop(u,C2),$s("§sinh"),$s("§cosh"),v,x)),Map(Function(SubstForHyperbolic(Slot1,$s("§sinh"),$s("§cosh"),v,x)),u))))),
ISetDelayed(502,SubstForFractionalPowerOfLinear(u_,x_Symbol),
    With(List(Set($s("lst"),FractionalPowerOfLinear(u,C1,False,x))),If(Or(AtomQ($s("lst")),FalseQ(Part($s("lst"),C2))),False,With(List(Set(n,Part($s("lst"),C1)),Set(a,Coefficient(Part($s("lst"),C2),x,C0)),Set(b,Coefficient(Part($s("lst"),C2),x,C1))),With(List(Set($s("tmp"),Simplify(Times(Power(x,Plus(n,Negate(C1))),SubstForFractionalPower(u,Part($s("lst"),C2),n,Plus(Times(CN1,a,Power(b,-1)),Times(Power(x,n),Power(b,-1))),x))))),List(NonfreeFactors($s("tmp"),x),n,Part($s("lst"),C2),Times(FreeFactors($s("tmp"),x),Power(b,-1)))))))),
ISetDelayed(503,FractionalPowerOfLinear(u_,n_,v_,x_),
    If(Or(AtomQ(u),FreeQ(u,x)),List(n,v),If(CalculusQ(u),False,If(And(FractionalPowerQ(u),LinearQ(Part(u,C1),x),Or(FalseQ(v),EqQ(Part(u,C1),v))),List(LCM(Denominator(Part(u,C2)),n),Part(u,C1)),Catch(Module(List(Set($s("lst"),List(n,v))),CompoundExpression(Scan(Function(If(AtomQ(Set($s("lst"),FractionalPowerOfLinear(Slot1,Part($s("lst"),C1),Part($s("lst"),C2),x))),Throw(False))),u),$s("lst")))))))),
ISetDelayed(504,InverseFunctionOfLinear(u_,x_Symbol),
    If(Or(AtomQ(u),CalculusQ(u),FreeQ(u,x)),False,If(And(InverseFunctionQ(u),LinearQ(Part(u,C1),x)),u,Module(List($s("tmp")),Catch(CompoundExpression(Scan(Function(If(Not(AtomQ(Set($s("tmp"),InverseFunctionOfLinear(Slot1,x)))),Throw($s("tmp")))),u),False)))))),
ISetDelayed(505,TryPureTanSubst(u_,x_Symbol),
    Not(MatchQ(u,Condition($(F_,Times(c_DEFAULT,Plus(a_DEFAULT,Times(b_DEFAULT,$(G_,v_))))),And(FreeQ(List(a,b,c),x),MemberQ(List($s("ArcTan"),$s("ArcCot"),$s("ArcTanh"),$s("ArcCoth")),FSymbol),MemberQ(List($s("Tan"),$s("Cot"),$s("Tanh"),$s("Coth")),GSymbol),LinearQ(v,x)))))),
ISetDelayed(506,TryTanhSubst(u_,x_Symbol),
    And(FalseQ(FunctionOfLinear(u,x)),Not(MatchQ(u,Condition(Times(r_DEFAULT,Power(Plus(s_,t_),n_DEFAULT)),And(IntegerQ(n),Greater(n,C0))))),Not(MatchQ(u,Log(v_))),Not(MatchQ(u,Condition(Power(Plus(a_,Times(b_DEFAULT,Power($(f_,x),n_))),-1),And(MemberQ(List($s("Sinh"),$s("Cosh"),$s("Sech"),$s("Csch")),f),IntegerQ(n),Greater(n,C2))))),Not(MatchQ(u,Condition(Times($(f_,Times(m_DEFAULT,x)),$(g_,Times(n_DEFAULT,x))),And(IntegersQ(m,n),MemberQ(List($s("Sinh"),$s("Cosh"),$s("Sech"),$s("Csch")),f),MemberQ(List($s("Sinh"),$s("Cosh"),$s("Sech"),$s("Csch")),g))))),Not(MatchQ(u,Condition(Times(r_DEFAULT,Power(Times(a_DEFAULT,Power(s_,m_)),p_)),And(FreeQ(List(a,m,p),x),Not(And(SameQ(m,C2),Or(SameQ(s,Sech(x)),SameQ(s,Csch(x))))))))),SameQ(u,ExpandIntegrand(u,x)))),
ISetDelayed(507,TryPureTanhSubst(u_,x_Symbol),
    And(Not(MatchQ(u,Log(v_))),Not(MatchQ(u,Condition(ArcTanh(Times(a_DEFAULT,Tanh(v_))),FreeQ(a,x)))),Not(MatchQ(u,Condition(ArcTanh(Times(a_DEFAULT,Coth(v_))),FreeQ(a,x)))),Not(MatchQ(u,Condition(ArcCoth(Times(a_DEFAULT,Tanh(v_))),FreeQ(a,x)))),Not(MatchQ(u,Condition(ArcCoth(Times(a_DEFAULT,Coth(v_))),FreeQ(a,x)))),SameQ(u,ExpandIntegrand(u,x)))),
ISetDelayed(508,InertTrigQ(f_),
    MemberQ(List($s("§sin"),$s("§cos"),$s("§tan"),$s("§cot"),$s("§sec"),$s("§csc")),f)),
ISetDelayed(509,InertTrigQ(f_,g_),
    If(SameQ(f,g),InertTrigQ(f),Or(InertReciprocalQ(f,g),InertReciprocalQ(g,f)))),
ISetDelayed(510,InertTrigQ(f_,g_,h_),
    And(InertTrigQ(f,g),InertTrigQ(g,h))),
ISetDelayed(511,InertReciprocalQ(f_,g_),
    Or(And(SameQ(f,$s("§sin")),SameQ(g,$s("§csc"))),And(SameQ(f,$s("§cos")),SameQ(g,$s("§sec"))),And(SameQ(f,$s("§tan")),SameQ(g,$s("§cot"))))),
ISetDelayed(512,InertTrigFreeQ(u_),
    And(FreeQ(u,$s("§sin")),FreeQ(u,$s("§cos")),FreeQ(u,$s("§tan")),FreeQ(u,$s("§cot")),FreeQ(u,$s("§sec")),FreeQ(u,$s("§csc")))),
ISetDelayed(513,ActivateTrig(u_),
    ReplaceAll(u,List(Rule($s("§sin"),$s("Sin")),Rule($s("§cos"),$s("Cos")),Rule($s("§tan"),$s("Tan")),Rule($s("§cot"),$s("Cot")),Rule($s("§sec"),$s("Sec")),Rule($s("§csc"),$s("Csc"))))),
ISetDelayed(514,DeactivateTrig(Times(Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,$($p("§trig"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))))),n_DEFAULT)),x_),
    Condition(Times(Power(Plus(c,Times(d,x)),m),Power(Plus(a,Times(b,DeactivateTrig($($s("§trig"),Plus(e,Times(f,x))),x))),n)),And(FreeQ(List(a,b,c,d,e,f,m,n),x),Or(TrigQ($s("§trig")),HyperbolicQ($s("§trig")))))),
ISetDelayed(515,DeactivateTrig(u_,x_),
    UnifyInertTrigFunction(FixInertTrigFunction(DeactivateTrigAux(u,x),x),x)),
ISetDelayed(516,DeactivateTrigAux(u_,x_),
    If(AtomQ(u),u,If(And(TrigQ(u),LinearQ(Part(u,C1),x)),With(List(Set(v,ExpandToSum(Part(u,C1),x))),Switch(Head(u),$s("Sin"),ReduceInertTrig($s("§sin"),v),$s("Cos"),ReduceInertTrig($s("§cos"),v),$s("Tan"),ReduceInertTrig($s("§tan"),v),$s("Cot"),ReduceInertTrig($s("§cot"),v),$s("Sec"),ReduceInertTrig($s("§sec"),v),$s("Csc"),ReduceInertTrig($s("§csc"),v))),If(And(HyperbolicQ(u),LinearQ(Part(u,C1),x)),With(List(Set(v,ExpandToSum(Times(CI,Part(u,C1)),x))),Switch(Head(u),$s("Sinh"),Times(CN1,CI,ReduceInertTrig($s("§sin"),v)),$s("Cosh"),ReduceInertTrig($s("§cos"),v),$s("Tanh"),Times(CN1,CI,ReduceInertTrig($s("§tan"),v)),$s("Coth"),Times(CI,ReduceInertTrig($s("§cot"),v)),$s("Sech"),ReduceInertTrig($s("§sec"),v),$s("Csch"),Times(CI,ReduceInertTrig($s("§csc"),v)))),Map(Function(DeactivateTrigAux(Slot1,x)),u))))),
ISetDelayed(517,FixInertTrigFunction(Times(a_,u_),x_),
    Condition(Times(a,FixInertTrigFunction(u,x)),FreeQ(a,x))),
ISetDelayed(518,FixInertTrigFunction(Times(u_DEFAULT,Power(Times(a_,Plus(b_,v_)),n_)),x_),
    Condition(FixInertTrigFunction(Times(u,Power(Plus(Times(a,b),Times(a,v)),n)),x),And(FreeQ(List(a,b,n),x),Not(FreeQ(v,x))))),
ISetDelayed(519,FixInertTrigFunction(Times(Power($($s("§csc"),v_),m_DEFAULT),Power(Times(c_DEFAULT,$($s("§sin"),w_)),n_DEFAULT)),x_),
    Condition(Times(Power($($s("§sin"),v),Negate(m)),Power(Times(c,$($s("§sin"),w)),n)),And(FreeQ(List(c,n),x),IntegerQ(m)))),
ISetDelayed(520,FixInertTrigFunction(Times(Power(Times(c_DEFAULT,$($s("§cos"),w_)),n_DEFAULT),Power($($s("§sec"),v_),m_DEFAULT)),x_),
    Condition(Times(Power($($s("§cos"),v),Negate(m)),Power(Times(c,$($s("§cos"),w)),n)),And(FreeQ(List(c,n),x),IntegerQ(m)))),
ISetDelayed(521,FixInertTrigFunction(Times(Power($($s("§cot"),v_),m_DEFAULT),Power(Times(c_DEFAULT,$($s("§tan"),w_)),n_DEFAULT)),x_),
    Condition(Times(Power($($s("§tan"),v),Negate(m)),Power(Times(c,$($s("§tan"),w)),n)),And(FreeQ(List(c,n),x),IntegerQ(m)))),
ISetDelayed(522,FixInertTrigFunction(Times(Power(Times(c_DEFAULT,$($s("§cot"),w_)),n_DEFAULT),Power($($s("§tan"),v_),m_DEFAULT)),x_),
    Condition(Times(Power($($s("§cot"),v),Negate(m)),Power(Times(c,$($s("§cot"),w)),n)),And(FreeQ(List(c,n),x),IntegerQ(m)))),
ISetDelayed(523,FixInertTrigFunction(Times(Power($($s("§cos"),v_),m_DEFAULT),Power(Times(c_DEFAULT,$($s("§sec"),w_)),n_DEFAULT)),x_),
    Condition(Times(Power($($s("§sec"),v),Negate(m)),Power(Times(c,$($s("§sec"),w)),n)),And(FreeQ(List(c,n),x),IntegerQ(m)))),
ISetDelayed(524,FixInertTrigFunction(Times(Power(Times(c_DEFAULT,$($s("§csc"),w_)),n_DEFAULT),Power($($s("§sin"),v_),m_DEFAULT)),x_),
    Condition(Times(Power($($s("§csc"),v),Negate(m)),Power(Times(c,$($s("§csc"),w)),n)),And(FreeQ(List(c,n),x),IntegerQ(m)))),
ISetDelayed(525,FixInertTrigFunction(Times(Power($($s("§sec"),v_),m_DEFAULT),Power(Times(c_DEFAULT,$($s("§sin"),w_)),n_DEFAULT)),x_),
    Condition(Times(Power($($s("§cos"),v),Negate(m)),Power(Times(c,$($s("§sin"),w)),n)),And(FreeQ(List(c,n),x),IntegerQ(m)))),
ISetDelayed(526,FixInertTrigFunction(Times(Power(Times(c_DEFAULT,$($s("§cos"),w_)),n_DEFAULT),Power($($s("§csc"),v_),m_DEFAULT)),x_),
    Condition(Times(Power($($s("§sin"),v),Negate(m)),Power(Times(c,$($s("§cos"),w)),n)),And(FreeQ(List(c,n),x),IntegerQ(m)))),
ISetDelayed(527,FixInertTrigFunction(Times(Power($($s("§cos"),v_),m_DEFAULT),Power(Times(c_DEFAULT,$($s("§tan"),w_)),n_DEFAULT)),x_),
    Condition(Times(Power($($s("§sec"),v),Negate(m)),Power(Times(c,$($s("§tan"),w)),n)),And(FreeQ(List(c,n),x),IntegerQ(m)))),
ISetDelayed(528,FixInertTrigFunction(Times(Power(Times(c_DEFAULT,$($s("§cot"),w_)),n_DEFAULT),Power($($s("§sin"),v_),m_DEFAULT)),x_),
    Condition(Times(Power($($s("§csc"),v),Negate(m)),Power(Times(c,$($s("§cot"),w)),n)),And(FreeQ(List(c,n),x),IntegerQ(m)))),
ISetDelayed(529,FixInertTrigFunction(Times(Power(Times(c_DEFAULT,$($s("§sec"),w_)),n_DEFAULT),Power($($s("§sin"),v_),m_DEFAULT)),x_),
    Condition(Times(Power($($s("§csc"),v),Negate(m)),Power(Times(c,$($s("§sec"),w)),n)),And(FreeQ(List(c,n),x),IntegerQ(m)))),
ISetDelayed(530,FixInertTrigFunction(Times(Power($($s("§cos"),v_),m_DEFAULT),Power(Times(c_DEFAULT,$($s("§csc"),w_)),n_DEFAULT)),x_),
    Condition(Times(Power($($s("§sec"),v),Negate(m)),Power(Times(c,$($s("§csc"),w)),n)),And(FreeQ(List(c,n),x),IntegerQ(m)))),
ISetDelayed(531,FixInertTrigFunction(Times(Power($($s("§cot"),v_),m_DEFAULT),Power(Times(c_DEFAULT,$($s("§sin"),w_)),n_DEFAULT)),x_),
    Condition(Times(Power($($s("§tan"),v),Negate(m)),Power(Times(c,$($s("§sin"),w)),n)),And(FreeQ(List(c,n),x),IntegerQ(m)))),
ISetDelayed(532,FixInertTrigFunction(Times(Power(Times(c_DEFAULT,$($s("§cos"),w_)),n_DEFAULT),Power($($s("§tan"),v_),m_DEFAULT)),x_),
    Condition(Times(Power($($s("§cot"),v),Negate(m)),Power(Times(c,$($s("§cos"),w)),n)),And(FreeQ(List(c,n),x),IntegerQ(m)))),
ISetDelayed(533,FixInertTrigFunction(Times(Power($($s("§csc"),v_),m_DEFAULT),Power(Times(c_DEFAULT,$($s("§tan"),w_)),n_DEFAULT)),x_),
    Condition(Times(Power($($s("§sin"),v),Negate(m)),Power(Times(c,$($s("§tan"),w)),n)),And(FreeQ(List(c,n),x),IntegerQ(m)))),
ISetDelayed(534,FixInertTrigFunction(Times(Power(Times(c_DEFAULT,$($s("§cot"),w_)),n_DEFAULT),Power($($s("§sec"),v_),m_DEFAULT)),x_),
    Condition(Times(Power($($s("§cos"),v),Negate(m)),Power(Times(c,$($s("§cot"),w)),n)),And(FreeQ(List(c,n),x),IntegerQ(m)))),
ISetDelayed(535,FixInertTrigFunction(Times(Power($($s("§cot"),v_),m_DEFAULT),Power(Times(c_DEFAULT,$($s("§sec"),w_)),n_DEFAULT)),x_),
    Condition(Times(Power($($s("§tan"),v),Negate(m)),Power(Times(c,$($s("§sec"),w)),n)),And(FreeQ(List(c,n),x),IntegerQ(m)))),
ISetDelayed(536,FixInertTrigFunction(Times(Power(Times(c_DEFAULT,$($s("§csc"),w_)),n_DEFAULT),Power($($s("§tan"),v_),m_DEFAULT)),x_),
    Condition(Times(Power($($s("§cot"),v),Negate(m)),Power(Times(c,$($s("§csc"),w)),n)),And(FreeQ(List(c,n),x),IntegerQ(m)))),
ISetDelayed(537,FixInertTrigFunction(Times(Power($($s("§sec"),v_),m_DEFAULT),Power($($s("§sec"),w_),n_DEFAULT)),x_),
    Condition(Times(Power($($s("§cos"),v),Negate(m)),Power($($s("§cos"),w),Negate(n))),IntegersQ(m,n))),
ISetDelayed(538,FixInertTrigFunction(Times(Power($($s("§csc"),v_),m_DEFAULT),Power($($s("§csc"),w_),n_DEFAULT)),x_),
    Condition(Times(Power($($s("§sin"),v),Negate(m)),Power($($s("§sin"),w),Negate(n))),IntegersQ(m,n))),
ISetDelayed(539,FixInertTrigFunction(Times(u_,Power(Plus(a_,Times(b_DEFAULT,$($s("§sin"),w_))),n_DEFAULT),Power($($s("§tan"),v_),m_DEFAULT)),x_),
    Condition(Times(Power($($s("§sin"),v),m),Power(Power($($s("§cos"),v),m),-1),FixInertTrigFunction(Times(u,Power(Plus(a,Times(b,$($s("§sin"),w))),n)),x)),And(FreeQ(List(a,b,n),x),IntegerQ(m)))),
ISetDelayed(540,FixInertTrigFunction(Times(u_,Power($($s("§cot"),v_),m_DEFAULT),Power(Plus(a_,Times(b_DEFAULT,$($s("§sin"),w_))),n_DEFAULT)),x_),
    Condition(Times(Power($($s("§cos"),v),m),Power(Power($($s("§sin"),v),m),-1),FixInertTrigFunction(Times(u,Power(Plus(a,Times(b,$($s("§sin"),w))),n)),x)),And(FreeQ(List(a,b,n),x),IntegerQ(m)))),
ISetDelayed(541,FixInertTrigFunction(Times(u_,Power(Plus(a_,Times(b_DEFAULT,$($s("§cos"),w_))),n_DEFAULT),Power($($s("§tan"),v_),m_DEFAULT)),x_),
    Condition(Times(Power($($s("§sin"),v),m),Power(Power($($s("§cos"),v),m),-1),FixInertTrigFunction(Times(u,Power(Plus(a,Times(b,$($s("§cos"),w))),n)),x)),And(FreeQ(List(a,b,n),x),IntegerQ(m)))),
ISetDelayed(542,FixInertTrigFunction(Times(u_,Power(Plus(a_,Times(b_DEFAULT,$($s("§cos"),w_))),n_DEFAULT),Power($($s("§cot"),v_),m_DEFAULT)),x_),
    Condition(Times(Power($($s("§cos"),v),m),Power(Power($($s("§sin"),v),m),-1),FixInertTrigFunction(Times(u,Power(Plus(a,Times(b,$($s("§cos"),w))),n)),x)),And(FreeQ(List(a,b,n),x),IntegerQ(m)))),
ISetDelayed(543,FixInertTrigFunction(Times(Power($($s("§cot"),v_),m_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(Times(c_DEFAULT,$($s("§sin"),w_)),p_DEFAULT))),n_DEFAULT)),x_),
    Condition(Times(Power($($s("§tan"),v),Negate(m)),Power(Plus(a,Times(b,Power(Times(c,$($s("§sin"),w)),p))),n)),And(FreeQ(List(a,b,c,n,p),x),IntegerQ(m)))),
ISetDelayed(544,FixInertTrigFunction(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Power(Times(c_DEFAULT,$($s("§cos"),w_)),p_DEFAULT))),n_DEFAULT),Power($($s("§tan"),v_),m_DEFAULT)),x_),
    Condition(Times(Power($($s("§cot"),v),Negate(m)),Power(Plus(a,Times(b,Power(Times(c,$($s("§cos"),w)),p))),n)),And(FreeQ(List(a,b,c,n,p),x),IntegerQ(m)))),
ISetDelayed(545,FixInertTrigFunction(Times(u_DEFAULT,w_,Power(Times(c_DEFAULT,Power($($s("§sin"),v_),n_DEFAULT)),p_DEFAULT)),x_),
    Condition(Times(Power(Times(c,Power($($s("§sin"),v),n)),p),FixInertTrigFunction(Times(u,w),x)),And(FreeQ(List(c,p),x),PowerOfInertTrigSumQ(w,$s("§sin"),x)))),
ISetDelayed(546,FixInertTrigFunction(Times(u_DEFAULT,w_,Power(Times(c_DEFAULT,Power($($s("§cos"),v_),n_DEFAULT)),p_DEFAULT)),x_),
    Condition(Times(Power(Times(c,Power($($s("§cos"),v),n)),p),FixInertTrigFunction(Times(u,w),x)),And(FreeQ(List(c,p),x),PowerOfInertTrigSumQ(w,$s("§cos"),x)))),
ISetDelayed(547,FixInertTrigFunction(Times(u_DEFAULT,w_,Power(Times(c_DEFAULT,Power($($s("§tan"),v_),n_DEFAULT)),p_DEFAULT)),x_),
    Condition(Times(Power(Times(c,Power($($s("§tan"),v),n)),p),FixInertTrigFunction(Times(u,w),x)),And(FreeQ(List(c,p),x),PowerOfInertTrigSumQ(w,$s("§tan"),x)))),
ISetDelayed(548,FixInertTrigFunction(Times(u_DEFAULT,w_,Power(Times(c_DEFAULT,Power($($s("§cot"),v_),n_DEFAULT)),p_DEFAULT)),x_),
    Condition(Times(Power(Times(c,Power($($s("§cot"),v),n)),p),FixInertTrigFunction(Times(u,w),x)),And(FreeQ(List(c,p),x),PowerOfInertTrigSumQ(w,$s("§cot"),x)))),
ISetDelayed(549,FixInertTrigFunction(Times(u_DEFAULT,w_,Power(Times(c_DEFAULT,Power($($s("§sec"),v_),n_DEFAULT)),p_DEFAULT)),x_),
    Condition(Times(Power(Times(c,Power($($s("§sec"),v),n)),p),FixInertTrigFunction(Times(u,w),x)),And(FreeQ(List(c,p),x),PowerOfInertTrigSumQ(w,$s("§sec"),x)))),
ISetDelayed(550,FixInertTrigFunction(Times(u_DEFAULT,w_,Power(Times(c_DEFAULT,Power($($s("§csc"),v_),n_DEFAULT)),p_DEFAULT)),x_),
    Condition(Times(Power(Times(c,Power($($s("§csc"),v),n)),p),FixInertTrigFunction(Times(u,w),x)),And(FreeQ(List(c,p),x),PowerOfInertTrigSumQ(w,$s("§csc"),x)))),
ISetDelayed(551,FixInertTrigFunction(Times(u_DEFAULT,w_,Power($($s("§sec"),v_),n_DEFAULT)),x_),
    Condition(Times(Power($($s("§cos"),v),Negate(n)),FixInertTrigFunction(Times(u,w),x)),And(PowerOfInertTrigSumQ(w,$s("§cos"),x),IntegerQ(n)))),
ISetDelayed(552,FixInertTrigFunction(Times(u_DEFAULT,w_,Power($($s("§csc"),v_),n_DEFAULT)),x_),
    Condition(Times(Power($($s("§sin"),v),Negate(n)),FixInertTrigFunction(Times(u,w),x)),And(PowerOfInertTrigSumQ(w,$s("§sin"),x),IntegerQ(n)))),
ISetDelayed(553,FixInertTrigFunction(Times(u_DEFAULT,w_,Power($($s("§sec"),v_),n_DEFAULT)),x_),
    Condition(Times(Power($($s("§cos"),v),Negate(n)),FixInertTrigFunction(Times(u,w),x)),And(PowerOfInertTrigSumQ(w,$s("§sin"),x),IntegerQ(n)))),
ISetDelayed(554,FixInertTrigFunction(Times(u_DEFAULT,w_,Power($($s("§csc"),v_),n_DEFAULT)),x_),
    Condition(Times(Power($($s("§sin"),v),Negate(n)),FixInertTrigFunction(Times(u,w),x)),And(PowerOfInertTrigSumQ(w,$s("§cos"),x),IntegerQ(n)))),
ISetDelayed(555,FixInertTrigFunction(Times(u_DEFAULT,w_,Power($($s("§cot"),v_),n_DEFAULT)),x_),
    Condition(Times(Power($($s("§tan"),v),Negate(n)),FixInertTrigFunction(Times(u,w),x)),And(PowerOfInertTrigSumQ(w,$s("§tan"),x),IntegerQ(n)))),
ISetDelayed(556,FixInertTrigFunction(Times(u_DEFAULT,w_,Power($($s("§cos"),v_),n_DEFAULT)),x_),
    Condition(Times(Power($($s("§sec"),v),Negate(n)),FixInertTrigFunction(Times(u,w),x)),And(PowerOfInertTrigSumQ(w,$s("§tan"),x),IntegerQ(n)))),
ISetDelayed(557,FixInertTrigFunction(Times(u_DEFAULT,w_,Power($($s("§cos"),v_),n_)),x_),
    Condition(Times(Power($($s("§sec"),v),Negate(n)),FixInertTrigFunction(Times(u,w),x)),And(PowerOfInertTrigSumQ(w,$s("§tan"),x),IntegerQ(n)))),
ISetDelayed(558,FixInertTrigFunction(Times(u_DEFAULT,w_,Power($($s("§csc"),v_),n_DEFAULT)),x_),
    Condition(Times(Power($($s("§sin"),v),Negate(n)),FixInertTrigFunction(Times(u,w),x)),And(PowerOfInertTrigSumQ(w,$s("§tan"),x),IntegerQ(n)))),
ISetDelayed(559,FixInertTrigFunction(Times(u_DEFAULT,w_,Power($($s("§tan"),v_),n_DEFAULT)),x_),
    Condition(Times(Power($($s("§cot"),v),Negate(n)),FixInertTrigFunction(Times(u,w),x)),And(PowerOfInertTrigSumQ(w,$s("§cot"),x),IntegerQ(n)))),
ISetDelayed(560,FixInertTrigFunction(Times(u_DEFAULT,w_,Power($($s("§sin"),v_),n_DEFAULT)),x_),
    Condition(Times(Power($($s("§csc"),v),Negate(n)),FixInertTrigFunction(Times(u,w),x)),And(PowerOfInertTrigSumQ(w,$s("§cot"),x),IntegerQ(n)))),
ISetDelayed(561,FixInertTrigFunction(Times(u_DEFAULT,w_,Power($($s("§sin"),v_),n_DEFAULT)),x_),
    Condition(Times(Power($($s("§csc"),v),Negate(n)),FixInertTrigFunction(Times(u,w),x)),And(PowerOfInertTrigSumQ(w,$s("§cot"),x),IntegerQ(n))))
  );
}
