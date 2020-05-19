package org.matheclipse.core.reflection.system;

import com.duy.lambda.Consumer;
import com.duy.lambda.Function;

import org.matheclipse.core.builtin.IOFunctions;
import org.matheclipse.core.builtin.StructureFunctions;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.interfaces.AbstractEvaluator;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IASTAppendable;
import org.matheclipse.core.interfaces.IASTMutable;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.core.visit.VisitorReplaceAll;

/**
 * <pre>
 * ExpToTrig(expr)
 * </pre>
 *
 */
public class ExpToTrig extends AbstractEvaluator {

	public ExpToTrig() {
	}

	/**
	 * Exponential definitions for trigonometric functions
	 * 
	 * See <a href= "http://en.wikipedia.org/wiki/List_of_trigonometric_identities#Exponential_definitions"> List of
	 * trigonometric identities - Exponential definitions</a>,<br/>
	 * <a href="http://en.wikipedia.org/wiki/Hyperbolic_function">Hyperbolic function</a>
	 */
	@Override
	public IExpr evaluate(final IAST ast, final EvalEngine engine) {

		IExpr temp = StructureFunctions.threadLogicEquationOperators(ast.arg1(), ast, 1);
		if (temp.isPresent()) {
			return temp;
		}

		IExpr arg1 = ast.arg1();
		VisitorReplaceAll visitor = new VisitorReplaceAll(new Function<IExpr, IExpr>() {
			@Override
			public IExpr apply(IExpr x) {
				if (x.isPower()) {
					IExpr exponent = F.NIL;
					IExpr base = x.base();
					if (base.equals(F.E)) {
						exponent = x.exponent();
						// return F.Plus(F.Cosh(exponent), F.Sinh(exponent));
					} else if (base.isNumber()) {
						// base^exponent => E ^(exponent*Log(base))
						exponent = F.Expand.of(engine, F.Times(x.exponent(), F.Log(base)));
						// System.out.println(exponent);
					}
					if (exponent.isPresent()) {
						if (exponent.isPlus()) {
							// E ^ (a+b+...) => map on plus args
							final IASTAppendable result = F.TimesAlloc(exponent.size());
							((IAST) exponent).forEach(new Consumer<IExpr>() {
								@Override
								public void accept(IExpr arg) {
									result.append(F.Plus(F.Cosh(arg), F.Sinh(arg)));
								}
							});
							return result;
						}
						return F.Plus(F.Cosh(exponent), F.Sinh(exponent));
					}
				}
				return F.NIL;
			}
		});

		visitor.setPostProcessing(new Function<IASTMutable, IExpr>() {
			@Override
			public IExpr apply(IASTMutable x) {
				if (x.isTimes() && x.arg1().isNumber() && x.arg2().isPlus()) {
					return F.Expand(x);
				}
				return x;
			}
		});
		temp = arg1.accept(visitor);
		if (temp.isPresent()) {
			return temp; // F.evalExpandAll(temp, engine);
		}
		return arg1;
	}

	@Override
	public int[] expectedArgSize() {
		return IOFunctions.ARGS_1_1;
	}

	@Override
	public void setUp(final ISymbol newSymbol) {
		newSymbol.setAttributes(ISymbol.LISTABLE);
	}

}
