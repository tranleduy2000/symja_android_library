package org.matheclipse.core.integrate.rubi;

import com.duy.lambda.Predicate;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.interfaces.AbstractCoreFunctionEvaluator;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IASTAppendable;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.parser.client.math.MathException;

import static org.matheclipse.core.expression.F.Integrate;
import static org.matheclipse.core.expression.F.ast;
import static org.matheclipse.core.expression.F.binaryAST2;
import static org.matheclipse.core.expression.F.initFinalHiddenSymbol;
import static org.matheclipse.core.expression.F.quaternary;
import static org.matheclipse.core.expression.F.quinary;
import static org.matheclipse.core.expression.F.senary;
import static org.matheclipse.core.expression.F.ternaryAST3;
import static org.matheclipse.core.expression.F.unaryAST1;

/**
 * UtilityFunction constructors from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi - rule-based integrator</a>.
 *
 * TODO a lot of functions are only placeholders at the moment.
 *
 */
public class UtilityFunctionCtors {

	public static ISymbol INTEGRATE_TRIG_SIMPLIFY = null;
	public static ISymbol INTEGRATE_SMARTLEAFCOUNT = null;
	public static ISymbol INTEGRATE_SMARTNUMERATOR = null;
	public static ISymbol INTEGRATE_SMARTDENOMINATOR = null;
	public static ISymbol INTEGRATE_SIMP = null;
	public static ISymbol INTEGRATE_REAPLIST = null;

	public final static ISymbol H = initFinalHiddenSymbol("H");
	public final static ISymbol J = initFinalHiddenSymbol("J");
	public final static ISymbol K = initFinalHiddenSymbol("K");
	public final static ISymbol L = initFinalHiddenSymbol("L");
	public final static ISymbol M = initFinalHiddenSymbol("M");
	public final static ISymbol O = initFinalHiddenSymbol("O");
	public final static ISymbol P = initFinalHiddenSymbol("P");
	public final static ISymbol Q = initFinalHiddenSymbol("Q");
	public final static ISymbol R = initFinalHiddenSymbol("R");
	public final static ISymbol S = initFinalHiddenSymbol("S");
	public final static ISymbol T = initFinalHiddenSymbol("T");
	public final static ISymbol U = initFinalHiddenSymbol("U");
	public final static ISymbol V = initFinalHiddenSymbol("V");
	public final static ISymbol W = initFinalHiddenSymbol("W");
	public final static ISymbol X = initFinalHiddenSymbol("X");
	public final static ISymbol Y = initFinalHiddenSymbol("Y");
	public final static ISymbol Z = initFinalHiddenSymbol("Z");

	public static ISymbol Dist = org.matheclipse.core.expression.F.$rubi("Dist");
	public static ISymbol IntegerPowerQ = org.matheclipse.core.expression.F.$rubi("IntegerPowerQ");
	public static ISymbol FractionalPowerQ = org.matheclipse.core.expression.F
			.$rubi("FractionalPowerQ");

	public static ISymbol ReapList = org.matheclipse.core.expression.F.$rubi("ReapList");

	static ISymbol FalseQ = F.$rubi("FalseQ", new AbstractCoreFunctionEvaluator() {
		@Override
		public IExpr evaluate(IAST ast, EvalEngine engine) throws MathException {
			if (ast.size() == 2) {
				return engine.evaluate(ast.arg1()).isFalse() ? F.True : F.False;
			}
			return F.False;
		}
	});

	static ISymbol FractionQ = F.$rubi("FractionQ", new AbstractCoreFunctionEvaluator() {
		@Override
		public IExpr evaluate(IAST ast, final EvalEngine engine) {
			if (ast.size() == 2) {
				IExpr arg1 = engine.evaluate(ast.arg1());
				return arg1.isFraction() ? F.True : F.False;
			}
			if (ast.size() > 2) {
				return ast.forAll(new Predicate<IExpr>() {
                    @Override
                    public boolean test(IExpr x) {
                        return engine.evaluate(x).isFraction();
                    }
                }, 1) ? F.True : F.False;
			}
			return F.False;
		}
	});

	static ISymbol IntegersQ = F.$rubi("IntegersQ", new AbstractCoreFunctionEvaluator() {
		@Override
		public IExpr evaluate(IAST ast, final EvalEngine engine) {
			if (ast.size() == 2) {
				IExpr arg1 = engine.evaluate(ast.arg1());
				return arg1.isInteger() ? F.True : F.False;
			}
			if (ast.size() > 2) {
				return ast.forAll(new Predicate<IExpr>() {
                    @Override
                    public boolean test(IExpr x) {
                        return engine.evaluate(x).isInteger();
                    }
                }, 1) ? F.True : F.False;
			}
			return F.False;
		}
	});

	static ISymbol ComplexNumberQ = F.$rubi("ComplexNumberQ", new AbstractCoreFunctionEvaluator() {
		@Override
		public IExpr evaluate(IAST ast, EvalEngine engine) throws MathException {
			if (ast.size() == 2) {
				IExpr arg1 = engine.evaluate(ast.arg1());
				return arg1.isComplex() || arg1.isComplexNumeric() ? F.True : F.False;
			}
			return F.False;
		}
	});

	static ISymbol PowerQ = F.$rubi("PowerQ", new AbstractCoreFunctionEvaluator() {
		@Override
		public IExpr evaluate(IAST ast, EvalEngine engine) throws MathException {
			if (ast.size() == 2) {
				IExpr arg1 = engine.evaluate(ast.arg1());
				return arg1.head().equals(F.Power) ? F.True : F.False;
			}
			return F.False;
		}
	});

	static ISymbol ProductQ = F.$rubi("ProductQ", new AbstractCoreFunctionEvaluator() {
		@Override
		public IExpr evaluate(IAST ast, EvalEngine engine) throws MathException {
			if (ast.size() == 2) {
				IExpr arg1 = engine.evaluate(ast.arg1());
				return arg1.head().equals(F.Times) ? F.True : F.False;
			}
			return F.False;
		}
	});

	static ISymbol SumQ = F.$rubi("SumQ", new AbstractCoreFunctionEvaluator() {
		@Override
		public IExpr evaluate(IAST ast, EvalEngine engine) throws MathException {
			if (ast.size() == 2) {
				IExpr arg1 = engine.evaluate(ast.arg1());
				return arg1.head().equals(F.Plus) ? F.True : F.False;
			}
			return F.False;
		}
	});
	static ISymbol NonsumQ = F.$rubi("NonsumQ", new AbstractCoreFunctionEvaluator() {
		@Override
		public IExpr evaluate(IAST ast, EvalEngine engine) throws MathException {
			if (ast.size() == 2) {
				IExpr arg1 = engine.evaluate(ast.arg1());
				return arg1.head().equals(F.Plus) ? F.False : F.True;
			}
			return F.False;
		}
	});


	public static IAST F(final IExpr a0) {
		return unaryAST1(F.FSymbol, a0);
	}

	public static IAST F(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.FSymbol, a0, a1);
	}

	public static IAST G(final IExpr a0) {
		return unaryAST1(F.GSymbol, a0);
	}

	public static IAST G(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.GSymbol, a0, a1);
	}

	public static IAST H(final IExpr a0) {
		return unaryAST1(H, a0);
	}

	public static IAST H(final IExpr a0, final IExpr a1) {
		return binaryAST2(H, a0, a1);
	}

	public static IAST H(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3) {
		return quaternary(H, a0, a1, a2, a3);
	}

	/**
	 * Convert to Integrate[]
	 *
	 * @param a0
	 * @param a1
	 * @return
	 */
	public static IAST Int(final IExpr a0, final IExpr a1) {
		// Integrate.setAttributes(ISymbol.CONSOLE_OUTPUT);
		return binaryAST2(Integrate, a0, a1);
	}

	public static IAST IntBinomialQ(final IExpr... a) {
		return ast(a, F.$rubi("IntBinomialQ"));
	}

	public static IAST IntHide(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("IntHide"), a0, a1);
	}

	public static IAST IntLinearQ(final IExpr... a) {
		return ast(a, F.$rubi("IntLinearQ"));
	}

	public static IAST IntQuadraticQ(final IExpr... a) {
		return ast(a, F.$rubi("IntQuadraticQ"));
	}

	public static IAST Dist(final IExpr a0, final IExpr a1) {
		return binaryAST2(Dist, a0, a1);
	}

	public static IAST Dist(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(Dist, a0, a1, a2);
	}

	// private static ISymbol $sDBG(final String symbolName) {
	// return $s(symbolName, false);
	// }

	public static IAST AbsorbMinusSign(final IExpr a0) {
		return unaryAST1(F.$rubi("AbsorbMinusSign"), a0);
	}

	public static IAST AbsurdNumberFactors(final IExpr a0) {
		return unaryAST1(F.$rubi("AbsurdNumberFactors"), a0);
	}

	public static IAST AbsurdNumberGCD(final IExpr... a) {
		return ast(a, F.$rubi("AbsurdNumberGCD"));
	}

	public static IAST AbsurdNumberGCDList(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("AbsurdNumberGCDList"), a0, a1);
	}

	public static IAST AbsurdNumberQ(final IExpr a0) {
		return unaryAST1(F.$rubi("AbsurdNumberQ"), a0);
	}

	public static IAST ActivateTrig(final IExpr a0) {
		return unaryAST1(F.$rubi("ActivateTrig"), a0);
	}

	public static IAST AlgebraicFunctionFactors(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("AlgebraicFunctionFactors"), a0, a1);
	}

	public static IAST AlgebraicFunctionQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("AlgebraicFunctionQ"), a0, a1);
	}

	public static IAST AlgebraicFunctionQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("AlgebraicFunctionQ"), a0, a1, a2);
	}

	public static IAST AlgebraicTrigFunctionQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("AlgebraicTrigFunctionQ"), a0, a1);
	}

	public static IAST AllNegTermQ(final IExpr a0) {
		return unaryAST1(F.$rubi("AllNegTermQ"), a0);
	}

	public static IAST AtomBaseQ(final IExpr a0) {
		return unaryAST1(F.$rubi("AtomBaseQ"), a0);
	}

	public static IAST BinomialDegree(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("BinomialDegree"), a0, a1);
	}

	public static IAST BinomialMatchQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("BinomialMatchQ"), a0, a1);
	}

	public static IAST BinomialParts(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("BinomialParts"), a0, a1);
	}

	public static IAST BinomialQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("BinomialQ"), a0, a1);
	}

	public static IAST BinomialQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("BinomialQ"), a0, a1, a2);
	}

	public static IAST BinomialTest(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("BinomialTest"), a0, a1);
	}

	public static IAST CalculusFreeQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("CalculusFreeQ"), a0, a1);
	}

	public static IAST CalculusQ(final IExpr a0) {
		return unaryAST1(F.$rubi("CalculusQ"), a0);
	}

	public static IAST CancelCommonFactors(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("CancelCommonFactors"), a0, a1);
	}

	public static IAST CannotIntegrate(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("CannotIntegrate"), a0, a1);
	}

	public static IAST CollectReciprocals(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("CollectReciprocals"), a0, a1);
	}

	public static IAST Coeff(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("Coeff"), a0, a1);
	}

	public static IAST Coeff(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("Coeff"), a0, a1, a2);
	}

	public static IAST CombineExponents(final IExpr a0) {
		return unaryAST1(F.$rubi("CombineExponents"), a0);
	}

	public static IAST CommonFactors(final IExpr a0) {
		return unaryAST1(F.$rubi("CommonFactors"), a0);
	}

	public static IAST CommonNumericFactors(final IExpr a0) {
		return unaryAST1(F.$rubi("CommonNumericFactors"), a0);
	}

	public static IAST ComplexFreeQ(final IExpr a0) {
		return unaryAST1(F.$rubi("ComplexFreeQ"), a0);
	}

	public static IAST ComplexNumberQ(final IExpr a0) {
		return unaryAST1(ComplexNumberQ, a0);
	}

	public static IAST ConstantFactor(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("ConstantFactor"), a0, a1);
	}

	public static IAST ContentFactor(final IExpr a0) {
		return unaryAST1(F.$rubi("ContentFactor"), a0);
	}

	public static IAST ContentFactorAux(final IExpr a0) {
		return unaryAST1(F.$rubi("ContentFactorAux"), a0);
	}

	public static IAST CosQ(final IExpr a0) {
		return unaryAST1(F.$rubi("CosQ"), a0);
	}

	public static IAST CoshQ(final IExpr a0) {
		return unaryAST1(F.$rubi("CoshQ"), a0);
	}

	public static IAST CotQ(final IExpr a0) {
		return unaryAST1(F.$rubi("CotQ"), a0);
	}

	public static IAST CothQ(final IExpr a0) {
		return unaryAST1(F.$rubi("CothQ"), a0);
	}

	public static IAST CscQ(final IExpr a0) {
		return unaryAST1(F.$rubi("CscQ"), a0);
	}

	public static IAST CschQ(final IExpr a0) {
		return unaryAST1(F.$rubi("CschQ"), a0);
	}

	public static IAST CubicMatchQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("CubicMatchQ"), a0, a1);
	}

	public static IAST DeactivateTrig(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("DeactivateTrig"), a0, a1);
	}

	public static IAST DeactivateTrigAux(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("DeactivateTrigAux"), a0, a1);
	}

	public static IAST DerivativeDivides(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("DerivativeDivides"), a0, a1, a2);
	}

	public static IAST Distrib(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("Distrib"), a0, a1);
	}

	public static IAST DistributeDegree(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("DistributeDegree"), a0, a1);
	}

	public static IAST DivideDegreesOfFactors(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("DivideDegreesOfFactors"), a0, a1);
	}

	public static IAST Divides(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("Divides"), a0, a1, a2);
	}

	public static IAST EasyDQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("EasyDQ"), a0, a1);
	}

	public static IAST EqQ(final IExpr a0) {
		return unaryAST1(F.$rubi("EqQ"), a0);
	}

	public static IAST EqQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("EqQ"), a0, a1);
	}

	public static IAST EqQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("EqQ"), a0, a1, a2);
	}

	public static IAST EulerIntegrandQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("EulerIntegrandQ"), a0, a1);
	}

	public static IAST EveryQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("EveryQ"), a0, a1);
	}

	public static IAST EvenQuotientQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("EvenQuotientQ"), a0, a1);
	}

	public static IAST ExpQ(final IExpr a0) {
		return unaryAST1(F.$rubi("ExpQ"), a0);
	}

	public static IAST ExpandAlgebraicFunction(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("ExpandAlgebraicFunction"), a0, a1);
	}

	public static IAST ExpandBinomial(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3, final IExpr a4,
									  final IExpr a5) {
		return senary(F.$rubi("ExpandBinomial"), a0, a1, a2, a3, a4, a5);
	}

	public static IAST ExpandCleanup(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("ExpandCleanup"), a0, a1);
	}

	public static IAST ExpandExpression(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("ExpandExpression"), a0, a1);
	}

	public static IAST ExpandIntegrand(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("ExpandIntegrand"), a0, a1);
	}

	public static IAST ExpandIntegrand(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("ExpandIntegrand"), a0, a1, a2);
	}

	public static IAST ExpandLinearProduct(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3,
										   final IExpr a4) {
		return quinary(F.$rubi("ExpandLinearProduct"), a0, a1, a2, a3, a4);
	}

	public static IAST ExpandToSum(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("ExpandToSum"), a0, a1);
	}

	public static IAST ExpandToSum(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("ExpandToSum"), a0, a1, a2);
	}

	public static IAST ExpandTrig(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("ExpandTrig"), a0, a1);
	}

	public static IAST ExpandTrig(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("ExpandTrig"), a0, a1, a2);
	}

	public static IAST ExpandTrigExpand(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3, final IExpr a4,
										final IExpr a5) {
		return senary(F.$rubi("ExpandTrigExpand"), a0, a1, a2, a3, a4, a5);
	}

	public static IAST ExpandTrigReduce(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("ExpandTrigReduce"), a0, a1);
	}

	public static IAST ExpandTrigReduce(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("ExpandTrigReduce"), a0, a1, a2);
	}

	public static IAST ExpandTrigReduceAux(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("ExpandTrigReduceAux"), a0, a1);
	}

	public static IAST ExpandTrigToExp(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("ExpandTrigToExp"), a0, a1);
	}

	public static IAST ExpandTrigToExp(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("ExpandTrigToExp"), a0, a1, a2);
	}

	public static IAST Expon(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("Expon"), a0, a1);
	}

	public static IAST Expon(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("Expon"), a0, a1, a2);
	}

	public static IAST ExponentIn(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("ExponentIn"), a0, a1, a2);
	}

	public static IAST ExponentInAux(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("ExponentInAux"), a0, a1, a2);
	}

	public static IAST FactorAbsurdNumber(final IExpr a0) {
		return unaryAST1(F.$rubi("FactorAbsurdNumber"), a0);
	}

	public static IAST FactorNumericGcd(final IExpr a0) {
		return unaryAST1(F.$rubi("FactorNumericGcd"), a0);
	}

	public static IAST FactorOrder(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("FactorOrder"), a0, a1);
	}

	public static IAST FalseQ(final IExpr a0) {
		return unaryAST1(FalseQ, a0);
	}

	public static IAST FindTrigFactor(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3, final IExpr a4) {
		return quinary(F.$rubi("FindTrigFactor"), a0, a1, a2, a3, a4);
	}

	public static IAST FixInertTrigFunction(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("FixInertTrigFunction"), a0, a1);
	}

	public static IAST FixIntRule(final IExpr a0) {
		return unaryAST1(F.$rubi("FixIntRule"), a0);
	}

	public static IAST FixIntRule(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("FixIntRule"), a0, a1);
	}

	public static IAST FixIntRules() {
		return F.headAST0(F.$rubi("FixIntRules"));
	}

	public static IAST FixIntRules(final IExpr a0) {
		return unaryAST1(F.$rubi("FixIntRules"), a0);
	}

	public static IAST FixRhsIntRule(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("FixRhsIntRule"), a0, a1);
	}

	public static IAST FixSimplify(final IExpr a0) {
		return unaryAST1(F.$rubi("FixSimplify"), a0);
	}

	public static IAST FracPart(final IExpr a0) {
		return unaryAST1(F.$rubi("FracPart"), a0);
	}

	public static IAST FracPart(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("FracPart"), a0, a1);
	}

	public static IAST FractionOrNegativeQ(final IExpr... a) {
		return ast(a, F.$rubi("FractionOrNegativeQ"));
	}

	public static IAST FractionQ(final IExpr... a) {
		return ast(a, FractionQ);
	}

	public static IAST FractionalPowerFreeQ(final IExpr a0) {
		return unaryAST1(F.$rubi("FractionalPowerFreeQ"), a0);
	}

	public static IAST FractionalPowerOfLinear(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3) {
		return quaternary(F.$rubi("FractionalPowerOfLinear"), a0, a1, a2, a3);
	}

	public static IAST FractionalPowerOfQuotientOfLinears(final IExpr a0, final IExpr a1, final IExpr a2,
														  final IExpr a3) {
		return quaternary(F.$rubi("FractionalPowerOfQuotientOfLinears"), a0, a1, a2, a3);
	}

	public static IAST FractionalPowerOfSquareQ(final IExpr a0) {
		return unaryAST1(F.$rubi("FractionalPowerOfSquareQ"), a0);
	}

	public static IAST FractionalPowerQ(final IExpr a0) {
		return unaryAST1(FractionalPowerQ, a0);
	}

	public static IAST FractionalPowerSubexpressionQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("FractionalPowerSubexpressionQ"), a0, a1, a2);
	}

	public static IAST FreeFactors(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("FreeFactors"), a0, a1);
	}

	public static IAST FreeTerms(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("FreeTerms"), a0, a1);
	}

	public static IAST FunctionOfCosQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("FunctionOfCosQ"), a0, a1, a2);
	}

	public static IAST FunctionOfCoshQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("FunctionOfCoshQ"), a0, a1, a2);
	}

	public static IAST FunctionOfDensePolynomialsQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("FunctionOfDensePolynomialsQ"), a0, a1);
	}

	public static IAST FunctionOfExpnQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("FunctionOfExpnQ"), a0, a1, a2);
	}

	public static IAST FunctionOfExponential(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("FunctionOfExponential"), a0, a1);
	}

	public static IAST FunctionOfExponentialFunction(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("FunctionOfExponentialFunction"), a0, a1);
	}

	public static IAST FunctionOfExponentialFunctionAux(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("FunctionOfExponentialFunctionAux"), a0, a1);
	}

	public static IAST FunctionOfExponentialQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("FunctionOfExponentialQ"), a0, a1);
	}

	public static IAST FunctionOfExponentialTest(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("FunctionOfExponentialTest"), a0, a1);
	}

	public static IAST FunctionOfExponentialTestAux(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("FunctionOfExponentialTestAux"), a0, a1, a2);
	}

	public static IAST FunctionOfHyperbolic(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("FunctionOfHyperbolic"), a0, a1);
	}

	public static IAST FunctionOfHyperbolic(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("FunctionOfHyperbolic"), a0, a1, a2);
	}

	public static IAST FunctionOfHyperbolicQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("FunctionOfHyperbolicQ"), a0, a1, a2);
	}

	public static IAST FunctionOfInverseLinear(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("FunctionOfInverseLinear"), a0, a1);
	}

	public static IAST FunctionOfInverseLinear(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("FunctionOfInverseLinear"), a0, a1, a2);
	}

	public static IAST FunctionOfLinear(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("FunctionOfLinear"), a0, a1);
	}

	public static IAST FunctionOfLinear(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3,
										final IExpr a4) {
		return quinary(F.$rubi("FunctionOfLinear"), a0, a1, a2, a3, a4);
	}

	public static IAST FunctionOfLinearSubst(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3) {
		return quaternary(F.$rubi("FunctionOfLinearSubst"), a0, a1, a2, a3);
	}

	public static IAST FunctionOfLog(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("FunctionOfLog"), a0, a1);
	}

	public static IAST FunctionOfLog(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3) {
		return quaternary(F.$rubi("FunctionOfLog"), a0, a1, a2, a3);
	}

	public static IAST FunctionOfQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("FunctionOfQ"), a0, a1, a2);
	}

	public static IAST FunctionOfQ(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3) {
		return quaternary(F.$rubi("FunctionOfQ"), a0, a1, a2, a3);
	}

	public static IAST FunctionOfSinQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("FunctionOfSinQ"), a0, a1, a2);
	}

	public static IAST FunctionOfSinhQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("FunctionOfSinhQ"), a0, a1, a2);
	}

	public static IAST FunctionOfSquareRootOfQuadratic(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("FunctionOfSquareRootOfQuadratic"), a0, a1);
	}

	public static IAST FunctionOfSquareRootOfQuadratic(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("FunctionOfSquareRootOfQuadratic"), a0, a1, a2);
	}

	public static IAST FunctionOfTanQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("FunctionOfTanQ"), a0, a1, a2);
	}

	public static IAST FunctionOfTanWeight(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("FunctionOfTanWeight"), a0, a1, a2);
	}

	public static IAST FunctionOfTanhQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("FunctionOfTanhQ"), a0, a1, a2);
	}

	public static IAST FunctionOfTanhWeight(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("FunctionOfTanhWeight"), a0, a1, a2);
	}

	public static IAST FunctionOfTrig(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("FunctionOfTrig"), a0, a1);
	}

	public static IAST FunctionOfTrig(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("FunctionOfTrig"), a0, a1, a2);
	}

	public static IAST FunctionOfTrigOfLinearQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("FunctionOfTrigOfLinearQ"), a0, a1);
	}

	public static IAST FunctionOfTrigQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("FunctionOfTrigQ"), a0, a1, a2);
	}

	public static IAST GE(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("GE"), a0, a1);
	}

	public static IAST GE(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("GE"), a0, a1, a2);
	}

	public static IAST GT(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("GT"), a0, a1);
	}

	public static IAST GT(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("GT"), a0, a1, a2);
	}

	public static IAST GtQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("GtQ"), a0, a1);
	}

	public static IAST GtQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("GtQ"), a0, a1, a2);
	}

	public static IAST GeQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("GeQ"), a0, a1);
	}

	public static IAST GeQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("GeQ"), a0, a1, a2);
	}

	public static IAST Gcd(final IExpr... a) {
		return ast(a, F.$rubi("Gcd"));
	}

	public static IAST Gcd(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("Gcd"), a0, a1);
	}

	public static IAST GeneralizedBinomialDegree(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("GeneralizedBinomialDegree"), a0, a1);
	}

	public static IAST GeneralizedBinomialMatchQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("GeneralizedBinomialMatchQ"), a0, a1);
	}

	public static IAST GeneralizedBinomialParts(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("GeneralizedBinomialParts"), a0, a1);
	}

	public static IAST GeneralizedBinomialQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("GeneralizedBinomialQ"), a0, a1);
	}

	public static IAST GeneralizedBinomialTest(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("GeneralizedBinomialTest"), a0, a1);
	}

	public static IAST GeneralizedTrinomialDegree(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("GeneralizedTrinomialDegree"), a0, a1);
	}

	public static IAST GeneralizedTrinomialMatchQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("GeneralizedTrinomialMatchQ"), a0, a1);
	}

	public static IAST GeneralizedTrinomialParts(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("GeneralizedTrinomialParts"), a0, a1);
	}

	public static IAST GeneralizedTrinomialQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("GeneralizedTrinomialQ"), a0, a1);
	}

	public static IAST GeneralizedTrinomialTest(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("GeneralizedTrinomialTest"), a0, a1);
	}

	public static IAST GensymSubst(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("GensymSubst"), a0, a1, a2);
	}

	public static IAST HalfIntegerQ(final IExpr a0) {
		return unaryAST1(F.$rubi("HalfIntegerQ"), a0);
	}

	public static IAST HalfIntegerQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("HalfIntegerQ"), a0, a1);
	}

	public static IAST HeldFormQ(final IExpr a0) {
		return unaryAST1(F.$rubi("HeldFormQ"), a0);
	}

	public static IAST HyperbolicQ(final IExpr a0) {
		return unaryAST1(F.$rubi("HyperbolicQ"), a0);
	}

	public static IAST IGtQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("IGtQ"), a0, a1);
	}

	public static IAST IGeQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("IGeQ"), a0, a1);
	}

	public static IAST ILtQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("ILtQ"), a0, a1);
	}

	public static IAST ILeQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("ILeQ"), a0, a1);
	}

	public static IAST ImaginaryNumericQ(final IExpr a0) {
		return unaryAST1(F.$rubi("ImaginaryNumericQ"), a0);
	}

	public static IAST ImaginaryQ(final IExpr a0) {
		return unaryAST1(F.$rubi("ImaginaryQ"), a0);
	}

	public static IAST IndependentQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("IndependentQ"), a0, a1);
	}

	public static IAST InertReciprocalQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("InertReciprocalQ"), a0, a1);
	}

	public static IAST InertTrigFreeQ(final IExpr a0) {
		return unaryAST1(F.$rubi("InertTrigFreeQ"), a0);
	}

	public static IAST InertTrigQ(final IExpr a0) {
		return unaryAST1(F.$rubi("InertTrigQ"), a0);
	}

	public static IAST InertTrigQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("InertTrigQ"), a0, a1);
	}

	public static IAST InertTrigQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("InertTrigQ"), a0, a1, a2);
	}

	public static IAST InertTrigSumQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("InertTrigSumQ"), a0, a1, a2);
	}

	public static IAST IntPart(final IExpr a0) {
		return unaryAST1(F.$rubi("IntPart"), a0);
	}

	public static IAST IntPart(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("IntPart"), a0, a1);
	}

	public static IAST IntSum(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("IntSum"), a0, a1);
	}

	public static IAST IntTerm(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("IntTerm"), a0, a1);
	}

	public static IAST IntegerPowerQ(final IExpr a0) {
		return unaryAST1(IntegerPowerQ, a0);
	}

	public static IAST IntegerQuotientQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("IntegerQuotientQ"), a0, a1);
	}

	public static IAST IntegersQ(final IExpr... a) {
		return ast(a, IntegersQ);
	}

	public static IAST Integral(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("Integral"), a0, a1);
	}

	public static IAST IntegralFreeQ(final IExpr a0) {
		return unaryAST1(F.$rubi("IntegralFreeQ"), a0);
	}

	public static IAST InverseFunctionFreeQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("InverseFunctionFreeQ"), a0, a1);
	}

	public static IAST InverseFunctionOfLinear(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("InverseFunctionOfLinear"), a0, a1);
	}

	public static IAST InverseFunctionOfQuotientOfLinears(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("InverseFunctionOfQuotientOfLinears"), a0, a1);
	}

	public static IAST InverseFunctionQ(final IExpr a0) {
		return unaryAST1(F.$rubi("InverseFunctionQ"), a0);
	}

	public static IAST InverseHyperbolicQ(final IExpr a0) {
		return unaryAST1(F.$rubi("InverseHyperbolicQ"), a0);
	}

	public static IAST InverseTrigQ(final IExpr a0) {
		return unaryAST1(F.$rubi("InverseTrigQ"), a0);
	}

	public static IAST J(final IExpr a0) {
		return unaryAST1(J, a0);
	}

	public static IAST KernelSubst(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("KernelSubst"), a0, a1, a2);
	}

	public static IAST KnownCotangentIntegrandQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("KnownCotangentIntegrandQ"), a0, a1);
	}

	public static IAST KnownSecantIntegrandQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("KnownSecantIntegrandQ"), a0, a1);
	}

	public static IAST KnownSineIntegrandQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("KnownSineIntegrandQ"), a0, a1);
	}

	public static IAST KnownTangentIntegrandQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("KnownTangentIntegrandQ"), a0, a1);
	}

	public static IAST KnownTrigIntegrandQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("KnownTrigIntegrandQ"), a0, a1, a2);
	}

	public static IAST LE(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("LE"), a0, a1);
	}

	public static IAST LE(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("LE"), a0, a1, a2);
	}

	public static IAST LtQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("LtQ"), a0, a1);
	}

	public static IAST LtQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("LtQ"), a0, a1, a2);
	}

	public static IAST LeQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("LeQ"), a0, a1);
	}

	public static IAST LeQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("LeQ"), a0, a1, a2);
	}

	public static IAST LT(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("LT"), a0, a1);
	}

	public static IAST LT(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("LT"), a0, a1, a2);
	}

	public static IAST LeadBase(final IExpr a0) {
		return unaryAST1(F.$rubi("LeadBase"), a0);
	}

	public static IAST LeadDegree(final IExpr a0) {
		return unaryAST1(F.$rubi("LeadDegree"), a0);
	}

	public static IAST LeadFactor(final IExpr a0) {
		return unaryAST1(F.$rubi("LeadFactor"), a0);
	}

	public static IAST LeadTerm(final IExpr a0) {
		return unaryAST1(F.$rubi("LeadTerm"), a0);
	}

	public static IAST LinearMatchQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("LinearMatchQ"), a0, a1);
	}

	public static IAST LinearPairQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("LinearPairQ"), a0, a1, a2);
	}

	public static IAST LinearQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("LinearQ"), a0, a1);
	}

	public static IAST LogQ(final IExpr a0) {
		return unaryAST1(F.$rubi("LogQ"), a0);
	}

	public static IAST MakeAssocList(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("MakeAssocList"), a0, a1);
	}

	public static IAST MakeAssocList(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("MakeAssocList"), a0, a1, a2);
	}

	public static IAST Map2(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("Map2"), a0, a1, a2);
	}

	public static IAST MapAnd(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("MapAnd"), a0, a1);
	}

	public static IAST MapAnd(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("MapAnd"), a0, a1, a2);
	}

	public static IAST MapOr(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("MapOr"), a0, a1);
	}

	public static IAST MergeFactor(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("MergeFactor"), a0, a1, a2);
	}

	public static IAST MergeFactors(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("MergeFactors"), a0, a1);
	}

	public static IAST MergeMonomials(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("MergeMonomials"), a0, a1);
	}

	public static IAST MergeableFactorQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("MergeableFactorQ"), a0, a1, a2);
	}

	public static IAST MinimumDegree(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("MinimumDegree"), a0, a1);
	}

	public static IAST MinimumMonomialExponent(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("MinimumMonomialExponent"), a0, a1);
	}

	public static IAST MonomialExponent(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("MonomialExponent"), a0, a1);
	}

	public static IAST MonomialFactor(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("MonomialFactor"), a0, a1);
	}

	public static IAST MonomialQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("MonomialQ"), a0, a1);
	}

	public static IAST MonomialSumQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("MonomialSumQ"), a0, a1);
	}

	public static IAST MostMainFactorPosition(final IExpr a0) {
		return unaryAST1(F.$rubi("MostMainFactorPosition"), a0);
	}

	public static IAST NegativeCoefficientQ(final IExpr a0) {
		return unaryAST1(F.$rubi("NegativeCoefficientQ"), a0);
	}

	public static IAST NegativeIntegerQ(final IExpr... a) {
		return ast(a, F.$rubi("NegativeIntegerQ"));
	}

	public static IAST NegativeOrZeroQ(final IExpr a0) {
		return unaryAST1(F.$rubi("NegativeOrZeroQ"), a0);
	}

	public static IAST NegativeQ(final IExpr a0) {
		return unaryAST1(F.$rubi("NegativeQ"), a0);
	}

	public static IAST NegQ(final IExpr a0) {
		return unaryAST1(F.$rubi("NegQ"), a0);
	}

	public static IAST NegQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("NegQ"), a0, a1);
	}

	public static IAST NegSumBaseQ(final IExpr a0) {
		return unaryAST1(F.$rubi("NegSumBaseQ"), a0);
	}

	public static IAST NeQ(final IExpr a0) {
		return unaryAST1(F.$rubi("NeQ"), a0);
	}

	public static IAST NeQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("NeQ"), a0, a1);
	}

	public static IAST NiceSqrtAuxQ(final IExpr a0) {
		return unaryAST1(F.$rubi("NiceSqrtAuxQ"), a0);
	}

	public static IAST NiceSqrtQ(final IExpr a0) {
		return unaryAST1(F.$rubi("NiceSqrtQ"), a0);
	}

	public static IAST NonabsurdNumberFactors(final IExpr a0) {
		return unaryAST1(F.$rubi("NonabsurdNumberFactors"), a0);
	}

	public static IAST NonalgebraicFunctionFactors(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("NonalgebraicFunctionFactors"), a0, a1);
	}

	public static IAST NonfreeFactors(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("NonfreeFactors"), a0, a1);
	}

	public static IAST NonfreeTerms(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("NonfreeTerms"), a0, a1);
	}

	public static IAST NonnumericFactors(final IExpr a0) {
		return unaryAST1(F.$rubi("NonnumericFactors"), a0);
	}

	public static IAST NonpolynomialTerms(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("NonpolynomialTerms"), a0, a1);
	}

	public static IAST NonpositiveFactors(final IExpr a0) {
		return unaryAST1(F.$rubi("NonpositiveFactors"), a0);
	}

	public static IAST NonrationalFunctionFactors(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("NonrationalFunctionFactors"), a0, a1);
	}

	public static IAST NonsumQ(final IExpr a0) {
		return unaryAST1(NonsumQ, a0);
	}

	// public static IAST NonzeroQ(final IExpr a0) {
	// return unaryAST1(F.$rubi("NonzeroQ"), a0);
	// }

	public static IAST NormalizeHyperbolic(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3) {
		return quaternary(F.$rubi("NormalizeHyperbolic"), a0, a1, a2, a3);
	}

	public static IAST NormalizeIntegrand(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("NormalizeIntegrand"), a0, a1);
	}

	public static IAST NormalizeIntegrandAux(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("NormalizeIntegrandAux"), a0, a1);
	}

	public static IAST NormalizeIntegrandFactor(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("NormalizeIntegrandFactor"), a0, a1);
	}

	public static IAST NormalizeIntegrandFactorBase(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("NormalizeIntegrandFactorBase"), a0, a1);
	}

	public static IAST NormalizeLeadTermSigns(final IExpr a0) {
		return unaryAST1(F.$rubi("NormalizeLeadTermSigns"), a0);
	}

	public static IAST NormalizePowerOfLinear(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("NormalizePowerOfLinear"), a0, a1);
	}

	public static IAST NormalizePseudoBinomial(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("NormalizePseudoBinomial"), a0, a1);
	}

	public static IAST NormalizeSumFactors(final IExpr a0) {
		return unaryAST1(F.$rubi("NormalizeSumFactors"), a0);
	}

	public static IAST NormalizeTogether(final IExpr a0) {
		return unaryAST1(F.$rubi("NormalizeTogether"), a0);
	}

	public static IAST NormalizeTrig(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("NormalizeTrig"), a0, a1);
	}

	public static IAST NormalizeTrig(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3) {
		return quaternary(F.$rubi("NormalizeTrig"), a0, a1, a2, a3);
	}

	public static IAST NormalizeTrigReduce(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("NormalizeTrigReduce"), a0, a1);
	}

	public static IAST NotFalseQ(final IExpr a0) {
		return unaryAST1(F.$rubi("NotFalseQ"), a0);
	}

	public static IAST NotIntegrableQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("NotIntegrableQ"), a0, a1);
	}

	public static IAST NumericFactor(final IExpr a0) {
		return unaryAST1(F.$rubi("NumericFactor"), a0);
	}

	public static IAST NthRoot(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("NthRoot"), a0, a1);
	}

	public static IAST OddHyperbolicPowerQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("OddHyperbolicPowerQ"), a0, a1, a2);
	}

	public static IAST OddQuotientQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("OddQuotientQ"), a0, a1);
	}

	public static IAST OddTrigPowerQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("OddTrigPowerQ"), a0, a1, a2);
	}

	public static IAST OneQ(final IExpr a0) {
		return unaryAST1(F.$rubi("OneQ"), a0);
	}

	public static IAST OneQ(final IExpr... a) {
		return ast(a, F.$rubi("OneQ"));
	}

	public static IAST PerfectPowerTest(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("PerfectPowerTest"), a0, a1);
	}

	public static IAST PerfectSquareQ(final IExpr a0) {
		return unaryAST1(F.$rubi("PerfectSquareQ"), a0);
	}

	public static IAST PiecewiseLinearQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("PiecewiseLinearQ"), a0, a1);
	}

	public static IAST PiecewiseLinearQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("PiecewiseLinearQ"), a0, a1, a2);
	}

	public static IAST PolyGCD(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("PolyGCD"), a0, a1, a2);
	}

	public static IAST PolyQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("PolyQ"), a0, a1);
	}

	public static IAST PolyQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("PolyQ"), a0, a1, a2);
	}

	public static IAST PolynomialDivide(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("PolynomialDivide"), a0, a1, a2);
	}

	public static IAST PolynomialDivide(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3) {
		return quaternary(F.$rubi("PolynomialDivide"), a0, a1, a2, a3);
	}

	public static IAST PolynomialInAuxQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("PolynomialInAuxQ"), a0, a1, a2);
	}

	public static IAST PolynomialInQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("PolynomialInQ"), a0, a1, a2);
	}

	public static IAST PolynomialInSubst(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("PolynomialInSubst"), a0, a1, a2);
	}

	public static IAST PolynomialInSubstAux(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("PolynomialInSubstAux"), a0, a1, a2);
	}

	public static IAST PolynomialTermQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("PolynomialTermQ"), a0, a1);
	}

	public static IAST PolynomialTerms(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("PolynomialTerms"), a0, a1);
	}

	public static IAST PosAux(final IExpr a0) {
		return unaryAST1(F.$rubi("PosAux"), a0);
	}

	public static IAST PosQ(final IExpr a0) {
		return unaryAST1(F.$rubi("PosQ"), a0);
	}

	public static IAST PositiveFactors(final IExpr a0) {
		return unaryAST1(F.$rubi("PositiveFactors"), a0);
	}

	public static IAST PositiveIntegerPowerQ(final IExpr a0) {
		return unaryAST1(F.$rubi("PositiveIntegerPowerQ"), a0);
	}

	public static IAST PositiveIntegerQ(final IExpr... a) {
		return ast(a, F.$rubi("PositiveIntegerQ"));
	}

	public static IAST PositiveOrZeroQ(final IExpr a0) {
		return unaryAST1(F.$rubi("PositiveOrZeroQ"), a0);
	}

	public static IAST PositiveQ(final IExpr a0) {
		return unaryAST1(F.$rubi("PositiveQ"), a0);
	}

	public static IAST PowerOfLinearMatchQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("PowerOfLinearMatchQ"), a0, a1);
	}

	public static IAST PowerOfLinearQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("PowerOfLinearQ"), a0, a1);
	}

	public static IAST PowerQ(final IExpr a0) {
		return unaryAST1(PowerQ, a0);
	}

	public static IAST PowerVariableDegree(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3) {
		return quaternary(F.$rubi("PowerVariableDegree"), a0, a1, a2, a3);
	}

	public static IAST PowerVariableExpn(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("PowerVariableExpn"), a0, a1, a2);
	}

	public static IAST PowerVariableSubst(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("PowerVariableSubst"), a0, a1, a2);
	}

	public static IAST PowerOfInertTrigSumQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("PowerOfInertTrigSumQ"), a0, a1, a2);
	}

	public static IAST ProductOfLinearPowersQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("ProductOfLinearPowersQ"), a0, a1);
	}

	public static IAST ProductQ(final IExpr a0) {
		return unaryAST1(ProductQ, a0);
	}

	public static IAST ProperPolyQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("ProperPolyQ"), a0, a1);
	}

	public static IAST PseudoBinomialParts(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("PseudoBinomialParts"), a0, a1);
	}

	public static IAST PseudoBinomialPairQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("PseudoBinomialPairQ"), a0, a1, a2);
	}

	public static IAST PseudoBinomialQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("PseudoBinomialQ"), a0, a1);
	}

	public static IAST PureFunctionOfCosQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("PureFunctionOfCosQ"), a0, a1, a2);
	}

	public static IAST PureFunctionOfCoshQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("PureFunctionOfCoshQ"), a0, a1, a2);
	}

	public static IAST PureFunctionOfCotQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("PureFunctionOfCotQ"), a0, a1, a2);
	}

	public static IAST PureFunctionOfCothQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("PureFunctionOfCothQ"), a0, a1, a2);
	}

	public static IAST PureFunctionOfSinQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("PureFunctionOfSinQ"), a0, a1, a2);
	}

	public static IAST PureFunctionOfSinhQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("PureFunctionOfSinhQ"), a0, a1, a2);
	}

	public static IAST PureFunctionOfTanQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("PureFunctionOfTanQ"), a0, a1, a2);
	}

	public static IAST PureFunctionOfTanhQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("PureFunctionOfTanhQ"), a0, a1, a2);
	}

	public static IAST QuadraticMatchQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("QuadraticMatchQ"), a0, a1);
	}

	public static IAST QuadraticQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("QuadraticQ"), a0, a1);
	}

	public static IAST QuotientOfLinearsMatchQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("QuotientOfLinearsMatchQ"), a0, a1);
	}

	public static IAST QuotientOfLinearsP(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("QuotientOfLinearsP"), a0, a1);
	}

	public static IAST QuotientOfLinearsParts(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("QuotientOfLinearsParts"), a0, a1);
	}

	public static IAST QuotientOfLinearsQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("QuotientOfLinearsQ"), a0, a1);
	}

	public static IAST QuadraticProductQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("QuadraticProductQ"), a0, a1);
	}

	public static IAST RationalFunctionExpand(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("RationalFunctionExpand"), a0, a1);
	}

	public static IAST RationalFunctionExponents(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("RationalFunctionExponents"), a0, a1);
	}

	public static IAST RationalFunctionFactors(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("RationalFunctionFactors"), a0, a1);
	}

	public static IAST RationalFunctionQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("RationalFunctionQ"), a0, a1);
	}

	public static IAST RationalPowerQ(final IExpr a0) {
		return unaryAST1(F.$rubi("RationalPowerQ"), a0);
	}

	public static IAST RationalQ(final IExpr... a) {
		return ast(a, F.$rubi("RationalQ"));
	}

	// public static IAST RealNumericQ(final IExpr a0) {
	// return unaryAST1(F.$rubi("RealNumericQ"), a0);
	// }

	public static IAST RealQ(final IExpr a0) {
		return unaryAST1(F.$rubi("RealQ"), a0);
	}

	public static IAST ReapList(final IExpr a0) {
		return unaryAST1(ReapList, a0);
	}

	public static IAST RectifyCotangent(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3) {
		return quaternary(F.$rubi("RectifyCotangent"), a0, a1, a2, a3);
	}

	public static IAST RectifyCotangent(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3,
										final IExpr a4) {
		return quinary(F.$rubi("RectifyCotangent"), a0, a1, a2, a3, a4);
	}

	public static IAST RectifyTangent(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3) {
		return quaternary(F.$rubi("RectifyTangent"), a0, a1, a2, a3);
	}

	public static IAST RectifyTangent(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3, final IExpr a4) {
		return quinary(F.$rubi("RectifyTangent"), a0, a1, a2, a3, a4);
	}

	public static IAST ReduceInertTrig(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("ReduceInertTrig"), a0, a1);
	}

	public static IAST ReduceInertTrig(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("ReduceInertTrig"), a0, a1, a2);
	}

	public static IAST RemainingFactors(final IExpr a0) {
		return unaryAST1(F.$rubi("RemainingFactors"), a0);
	}

	public static IAST RemainingTerms(final IExpr a0) {
		return unaryAST1(F.$rubi("RemainingTerms"), a0);
	}

	public static IAST RemoveContent(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("RemoveContent"), a0, a1);
	}

	public static IAST RemoveContentAux(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("RemoveContentAux"), a0, a1);
	}

	public static IAST Rt(final IExpr a0) {
		return unaryAST1(F.$rubi("Rt"), a0);
	}

	public static IAST Rt(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("Rt"), a0, a1);
	}

	public static IAST RtAux(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("RtAux"), a0, a1);
	}

	public static IAST RuleName(final IExpr a0) {
		return unaryAST1(F.$rubi("RuleName"), a0);
	}

	public static IAST SecQ(final IExpr a0) {
		return unaryAST1(F.$rubi("SecQ"), a0);
	}

	public static IAST SechQ(final IExpr a0) {
		return unaryAST1(F.$rubi("SechQ"), a0);
	}

	public static IAST SignOfFactor(final IExpr a0) {
		return unaryAST1(F.$rubi("SignOfFactor"), a0);
	}

	public static IAST Simp(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("Simp"), a0, a1);
	}

	public static IAST SimpFixFactor(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("SimpFixFactor"), a0, a1);
	}

	public static IAST SimpHelp(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("SimpHelp"), a0, a1);
	}

	public static IAST SimplerIntegrandQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("SimplerIntegrandQ"), a0, a1, a2);
	}

	public static IAST SimplerQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("SimplerQ"), a0, a1);
	}

	public static IAST SimplerSqrtQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("SimplerSqrtQ"), a0, a1);
	}

	public static IAST SimplifyAntiderivative(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("SimplifyAntiderivative"), a0, a1);
	}

	public static IAST SimplifyAntiderivativeSum(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("SimplifyAntiderivativeSum"), a0, a1);
	}

	public static IAST SimplifyIntegrand(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("SimplifyIntegrand"), a0, a1);
	}

	public static IAST SimplifyTerm(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("SimplifyTerm"), a0, a1);
	}

	public static IAST SinCosQ(final IExpr a0) {
		return unaryAST1(F.$rubi("SinCosQ"), a0);
	}

	public static IAST SinQ(final IExpr a0) {
		return unaryAST1(F.$rubi("SinQ"), a0);
	}

	public static IAST SinhCoshQ(final IExpr a0) {
		return unaryAST1(F.$rubi("SinhCoshQ"), a0);
	}

	public static IAST SinhQ(final IExpr a0) {
		return unaryAST1(F.$rubi("SinhQ"), a0);
	}

	public static IAST Smallest(final IExpr a0) {
		return unaryAST1(F.$rubi("Smallest"), a0);
	}

	public static IAST Smallest(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("Smallest"), a0, a1);
	}

	public static IAST SmartApart(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("SmartApart"), a0, a1);
	}

	public static IAST SmartApart(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("SmartApart"), a0, a1, a2);
	}

	public static IAST SmartDenominator(final IExpr a0) {
		return unaryAST1(F.$rubi("SmartDenominator"), a0);
	}

	public static IAST SmartNumerator(final IExpr a0) {
		return unaryAST1(F.$rubi("SmartNumerator"), a0);
	}

	public static IAST SmartSimplify(final IExpr a0) {
		return unaryAST1(F.$rubi("SmartSimplify"), a0);
	}

	public static IAST SomeNegTermQ(final IExpr a0) {
		return unaryAST1(F.$rubi("SomeNegTermQ"), a0);
	}

	public static IAST SplitFreeFactors(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("SplitFreeFactors"), a0, a1);
	}

	public static IAST SplitProduct(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("SplitProduct"), a0, a1);
	}

	public static IAST SplitSum(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("SplitSum"), a0, a1);
	}

	public static IAST SqrtNumberQ(final IExpr a0) {
		return unaryAST1(F.$rubi("SqrtNumberQ"), a0);
	}

	public static IAST SqrtNumberSumQ(final IExpr a0) {
		return unaryAST1(F.$rubi("SqrtNumberSumQ"), a0);
	}

	public static IAST SqrtQ(final IExpr a0) {
		return unaryAST1(F.$rubi("SqrtQ"), a0);
	}

	public static IAST SquareRootOfQuadraticSubst(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3) {
		return quaternary(F.$rubi("SquareRootOfQuadraticSubst"), a0, a1, a2, a3);
	}

	public static IAST StopFunctionQ(final IExpr a0) {
		return unaryAST1(F.$rubi("StopFunctionQ"), a0);
	}

	public static IAST Subst(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("Subst"), a0, a1);
	}

	public static IAST Subst(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("Subst"), a0, a1, a2);
	}

	public static IAST SubstAux(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("SubstAux"), a0, a1, a2);
	}

	public static IAST SubstAux(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3) {
		return quaternary(F.$rubi("SubstAux"), a0, a1, a2, a3);
	}

	public static IAST SubstFor(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("SubstFor"), a0, a1, a2);
	}

	public static IAST SubstFor(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3) {
		return quaternary(F.$rubi("SubstFor"), a0, a1, a2, a3);
	}

	public static IAST SubstForAux(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("SubstForAux"), a0, a1, a2);
	}

	public static IAST SubstForExpn(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("SubstForExpn"), a0, a1, a2);
	}

	public static IAST SubstForFractionalPower(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3,
											   final IExpr a4) {
		return quinary(F.$rubi("SubstForFractionalPower"), a0, a1, a2, a3, a4);
	}

	public static IAST SubstForFractionalPowerAuxQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("SubstForFractionalPowerAuxQ"), a0, a1, a2);
	}

	public static IAST SubstForFractionalPowerOfLinear(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("SubstForFractionalPowerOfLinear"), a0, a1);
	}

	public static IAST SubstForFractionalPowerOfQuotientOfLinears(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("SubstForFractionalPowerOfQuotientOfLinears"), a0, a1);
	}

	public static IAST SubstForFractionalPowerQ(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("SubstForFractionalPowerQ"), a0, a1, a2);
	}

	public static IAST SubstForHyperbolic(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3,
										  final IExpr a4) {
		return quinary(F.$rubi("SubstForHyperbolic"), a0, a1, a2, a3, a4);
	}

	public static IAST SubstForInverseFunction(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("SubstForInverseFunction"), a0, a1, a2);
	}

	public static IAST SubstForInverseFunction(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3) {
		return quaternary(F.$rubi("SubstForInverseFunction"), a0, a1, a2, a3);
	}

	public static IAST SubstForInverseFunctionOfQuotientOfLinears(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("SubstForInverseFunctionOfQuotientOfLinears"), a0, a1);
	}

	public static IAST SubstForTrig(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3, final IExpr a4) {
		return quinary(F.$rubi("SubstForTrig"), a0, a1, a2, a3, a4);
	}

	public static IAST SumBaseQ(final IExpr a0) {
		return unaryAST1(F.$rubi("SumBaseQ"), a0);
	}

	public static IAST SumQ(final IExpr a0) {
		return unaryAST1(SumQ, a0);
	}

	public static IAST SumSimplerAuxQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("SumSimplerAuxQ"), a0, a1);
	}

	public static IAST SumSimplerQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("SumSimplerQ"), a0, a1);
	}

	public static IAST TanQ(final IExpr a0) {
		return unaryAST1(F.$rubi("TanQ"), a0);
	}

	public static IAST TanhQ(final IExpr a0) {
		return unaryAST1(F.$rubi("TanhQ"), a0);
	}

	public static IAST TogetherSimplify(final IExpr a0) {
		return unaryAST1(F.$rubi("TogetherSimplify"), a0);
	}

	public static IAST TrigHyperbolicFreeQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("TrigHyperbolicFreeQ"), a0, a1);
	}

	public static IAST TrigQ(final IExpr a0) {
		return unaryAST1(F.$rubi("TrigQ"), a0);
	}

	public static IAST TrigSimplify(final IExpr a0) {
		return unaryAST1(F.$rubi("TrigSimplify"), a0);
	}

	public static IAST TrigSimplifyAux(final IExpr a0) {
		return unaryAST1(F.$rubi("TrigSimplifyAux"), a0);
	}

	public static IAST TrigSimplifyQ(final IExpr a0) {
		return unaryAST1(F.$rubi("TrigSimplifyQ"), a0);
	}

	public static IAST TrigSimplifyRecur(final IExpr a0) {
		return unaryAST1(F.$rubi("TrigSimplifyRecur"), a0);
	}

	public static IAST TrigSquareQ(final IExpr a0) {
		return unaryAST1(F.$rubi("TrigSquareQ"), a0);
	}

	public static IAST TrinomialDegree(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("TrinomialDegree"), a0, a1);
	}

	public static IAST TrinomialMatchQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("TrinomialMatchQ"), a0, a1);
	}

	public static IAST TrinomialParts(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("TrinomialParts"), a0, a1);
	}

	public static IAST TrinomialQ(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("TrinomialQ"), a0, a1);
	}

	public static IAST TrinomialTest(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("TrinomialTest"), a0, a1);
	}

	public static IAST TryPureTanSubst(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("TryPureTanSubst"), a0, a1);
	}

	public static IAST TryPureTanhSubst(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("TryPureTanhSubst"), a0, a1);
	}

	public static IAST TryTanhSubst(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("TryTanhSubst"), a0, a1);
	}

	public static IAST UnifyNegativeBaseFactors(final IExpr a0) {
		return unaryAST1(F.$rubi("UnifyNegativeBaseFactors"), a0);
	}

	public static IAST UnifySum(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("UnifySum"), a0, a1);
	}

	public static IAST UnifyTerm(final IExpr a0, final IExpr a1, final IExpr a2) {
		return ternaryAST3(F.$rubi("UnifyTerm"), a0, a1, a2);
	}

	public static IAST UnifyTerms(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("UnifyTerms"), a0, a1);
	}

	public static IAST Unintegrable(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("Unintegrable"), a0, a1);
	}

	public static IAST UnifyInertTrigFunction(final IExpr a0, final IExpr a1) {
		return binaryAST2(F.$rubi("UnifyInertTrigFunction"), a0, a1);
	}

	public static IAST TrigSquare(final IExpr a0) {
		return unaryAST1(F.$rubi("TrigSquare"), a0);
	}

	/**
	 * <pre>
	 * w_*Dist[u_,v_,x_] :=
	 *     Dist[w*u,v,x] /;
	 *     w=!=-1
	 * </pre>
	 *
	 * @param astTimes
	 * @return
	 */
	public static IExpr evalRubiDistTimes(IAST astTimes) {
		for (int i = 1; i < astTimes.size(); i++) {
			IExpr temp = astTimes.get(i);
			if (temp.isAST(Dist) && temp.size() == 4) {
				IAST dist = (IAST) temp;
				temp = astTimes.removeAtClone(i).getOneIdentity(F.C1);
				if (!temp.isMinusOne()) {
					// System.out.println("w_*Dist[u_,v_,x_]");
					// Dist[ temp *u,v,x]
					return Dist(F.Times(temp, dist.arg1()), dist.arg2(), dist.arg3());
				}
			}
		}
		return F.NIL;
	}

	/**
	 * Rule 1:
	 *
	 * <pre>
	 * Dist[u_,v_,x_]+Dist[w_,v_,x_] :=
	 *     If[EqQ[u+w,0],
	 *     0,
	 *     Dist[u+w,v,x]]
	 * </pre>
	 *
	 * Rule 2:
	 *
	 * <pre>
	 * Dist[u_,v_,x_]-Dist[w_,v_,x_] :=
	 *     If[EqQ[u-w,0],
	 *     0,
	 *     Dist[u-w,v,x]]
	 * </pre>
	 *
	 * @param astTimes
	 * @return
	 */
	public static IExpr evalRubiDistPlus(IAST astPlus) {
		for (int i = 1; i < astPlus.size() - 1; i++) {
			IExpr arg1 = astPlus.get(i);
			if (arg1.isAST(Dist) && arg1.size() == 4) {
				// dist1 = Dist[u_,v_,x_]
				IAST dist1 = (IAST) arg1;
				IExpr v = dist1.arg2();
				IExpr x = dist1.arg2();
				for (int j = i + 1; j < astPlus.size(); j++) {
					IExpr arg2 = astPlus.get(j);
					if (arg2.isAST(Dist) && arg2.size() == 4 && arg2.getAt(2).equals(v) && arg2.getAt(2).equals(x)) {
						// dist2=Dist[w_,v_,x_]
						IAST dist2 = (IAST) arg2;
						IASTAppendable result = astPlus.removeAtClone(j);
						result.remove(i);
						// Dist /: Dist[u_,v_,x_]+Dist[w_,v_,x_] :=
						// If[EqQ[u+w,0],
						// 0,
						// Dist[u+w,v,x]]
						IExpr p = F.Plus(dist1.arg1(), dist2.arg1());
						result.append(F.If(EqQ(p, F.C0), F.C0, Dist(p, v, x)));
						return result;
					}
					if (arg2.isTimes() && arg2.size() == 3 && arg2.first().isMinusOne() && arg2.second().isAST(Dist)) {
						// -1 * Dist[w_,v_,x_]
						IAST dist2 = (IAST) arg2.second();
						if (dist2.size() == 4 && dist2.getAt(2).equals(v) && dist2.getAt(2).equals(x)) {
							IASTAppendable result = astPlus.removeAtClone(j);
							result.remove(i);
							// Dist /: Dist[u_,v_,x_]-Dist[w_,v_,x_] :=
							// If[EqQ[u-w,0],
							// 0,
							// Dist[u-w,v,x]]
							IExpr p = F.Subtract(dist1.arg1(), dist2.arg1());
							result.append(F.If(EqQ(p, F.C0), F.C0, Dist(p, v, x)));
							return result;
						}
					}
				}
			} else if (arg1.isTimes() && arg1.size() == 3 && arg1.first().isMinusOne() && arg1.second().isAST(Dist)) {
				// -1 * Dist[w_,v_,x_]
				IAST dist1 = (IAST) arg1.second();
				IExpr v = dist1.arg2();
				IExpr x = dist1.arg2();
				for (int j = i + 1; j < astPlus.size(); j++) {
					IExpr arg2 = astPlus.get(j);
					if (arg2.isAST(Dist) && arg2.size() == 4 && arg2.getAt(2).equals(v) && arg2.getAt(2).equals(x)) {
						// dist2 = Dist[u_,v_,x_]
						IAST dist2 = (IAST) arg2;
						IASTAppendable result = astPlus.removeAtClone(j);
						result.remove(i);
						// Dist /: Dist[u_,v_,x_]-Dist[w_,v_,x_] :=
						// If[EqQ[u-w,0],
						// 0,
						// Dist[u-w,v,x]]
						IExpr p = F.Subtract(dist2.arg1(), dist1.arg1());
						result.append(F.If(EqQ(p, F.C0), F.C0, Dist(p, v, x)));
						return result;
					}
				}
			}
		}
		return F.NIL;
	}

}