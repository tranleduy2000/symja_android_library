
package org.matheclipse.core.builtin;

import com.duy.lambda.IntFunction;
import com.duy.util.ThreadLocalRandom;

import org.hipparchus.util.MathArrays;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.exception.Validate;
import org.matheclipse.core.eval.interfaces.AbstractFunctionEvaluator;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IASTAppendable;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.IInteger;
import org.matheclipse.parser.client.math.MathException;

import java.math.BigInteger;

public final class RandomFunctions {

	static {
		F.RandomInteger.setEvaluator(new RandomInteger());
		F.RandomChoice.setEvaluator(new RandomChoice());
		F.RandomReal.setEvaluator(new RandomReal());
		F.RandomSample.setEvaluator(new RandomSample());
	}

	private static class RandomChoice extends AbstractFunctionEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) throws MathException {
			if (ast.size() > 1 && ast.arg1().isAST()) {
				IAST list = (IAST) ast.arg1();
				ThreadLocalRandom random = ThreadLocalRandom.current();
				int listSize = list.argSize();
				int randomIndex = random.nextInt(listSize);
				if (ast.size() == 2) {
				return list.get(randomIndex + 1);
			}
				if (ast.size() == 3) {
					int n = ast.arg2().toIntDefault(Integer.MIN_VALUE);
					if (n > 0) {
						IASTAppendable result = F.ListAlloc(n);
						for (int i = 0; i < n; i++) {
							result.append(list.get(randomIndex + 1));
							randomIndex = random.nextInt(listSize);
						}
						return result;
					}
				}
			}

			return F.NIL;
		}

	}

	private static class RandomInteger extends AbstractFunctionEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) throws MathException {
			Validate.checkSize(ast, 2);

			if (ast.arg1().isInteger()) {
				// RandomInteger(100) gives an integer between 0 and 100
				BigInteger n = ((IInteger) ast.arg1()).toBigNumerator();
				BigInteger r;
				do {
					r = new BigInteger(n.bitLength(), ThreadLocalRandom.current());
				} while (r.compareTo(n) >= 0);
				return F.integer(r);
			}

			return F.NIL;
		}

	}

	private static class RandomReal extends AbstractFunctionEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) throws MathException {
			if (ast.isAST0()) {
				// RandomReal() gives a double value between 0.0 and 1.0
				double r = Math.random();
				return F.num(r);
			}

			return F.NIL;
		}

	}

	/**
	 * Create a random shuffled list.
	 *
	 */
	private static class RandomSample extends AbstractFunctionEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) throws MathException {
			Validate.checkSize(ast, 2);

			if (ast.arg1().isAST()) {
				return shuffle((IAST) ast.arg1());
			}

			return F.NIL;
		}

		public static IAST shuffle(final IAST list) {
			final int len = list.argSize();

			// Shuffle indices.
			final int[] indexList = MathArrays.natural(len);
			MathArrays.shuffle(indexList);

			// Create shuffled list.
			return list.copy().setArgs(1, len + 1, new IntFunction<IExpr>() {
				@Override
				public IExpr apply(int i) {
					return list.get(indexList[i - 1] + 1);
				}
			});
		}
	}

	private final static RandomFunctions CONST = new RandomFunctions();

	public static RandomFunctions initialize() {
		return CONST;
	}

	private RandomFunctions() {

	}

}
