package org.matheclipse.core.eval.interfaces;

import org.hipparchus.exception.MathRuntimeException;
import org.hipparchus.linear.FieldMatrix;
import org.hipparchus.linear.RealMatrix;
import org.matheclipse.core.basic.Config;
import org.matheclipse.core.builtin.IOFunctions;
import org.matheclipse.core.convert.Convert;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.exception.LimitException;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.parser.client.FEConfig;

public abstract class AbstractMatrix1Matrix extends AbstractFunctionEvaluator {

	public AbstractMatrix1Matrix() {
	}

	@Override
	public IExpr evaluate(final IAST ast, final EvalEngine engine) {
		FieldMatrix<IExpr> matrix;

		boolean togetherMode = engine.isTogetherMode();
		try {
			engine.setTogetherMode(true);

			int[] dims = checkMatrixDimensions(ast.arg1());
			if (dims != null) {
				matrix = Convert.list2Matrix(ast.arg1());
			if (matrix != null) {
				matrix = matrixEval(matrix);
				return Convert.matrix2List(matrix);
			}

			}
		} catch (LimitException le) {
			throw le;
		} catch (MathRuntimeException mre) {
			return engine.printMessage(ast.topHead(), mre);
		} catch (final ClassCastException e) {
			if (FEConfig.SHOW_STACKTRACE) {
				e.printStackTrace();
			}
		} catch (final IndexOutOfBoundsException e) {
			if (FEConfig.SHOW_STACKTRACE) {
				e.printStackTrace();
			}
		} finally {
			engine.setTogetherMode(togetherMode);
		}

		return F.NIL;
	}

	@Override
	public int[] expectedArgSize(IAST ast) {
		return IOFunctions.ARGS_1_1;
	}
	@Override
	public IExpr numericEval(final IAST ast, final EvalEngine engine) {
		RealMatrix matrix;

		boolean togetherMode = engine.isTogetherMode();
		try {
			engine.setTogetherMode(true);

			int[] dims = checkMatrixDimensions(ast.arg1());
			if (dims != null) {
				if (engine.isArbitraryMode()) {
					FieldMatrix<IExpr> fieldMatrix = Convert.list2Matrix(ast.arg1());
				if (fieldMatrix == null) {
					return F.NIL;
				}
				fieldMatrix = matrixEval(fieldMatrix);
				return Convert.matrix2List(fieldMatrix);
			}
				matrix = ast.arg1().toRealMatrix();
			if (matrix != null) {
				matrix = realMatrixEval(matrix);
					if (matrix != null) {
				return Convert.realMatrix2List(matrix);
					}
				}
			}
			return F.NIL;
		} catch (LimitException le) {
			throw le;
		} catch (final RuntimeException rex) {
			if (FEConfig.SHOW_STACKTRACE) {
				rex.printStackTrace();
			}
			return engine.printMessage(ast.topHead(), rex);
		} finally {
			engine.setTogetherMode(togetherMode);
		}
//		return evaluate(ast, engine);
	}

	/**
	 * Check if <code>arg1</code> is a matrix.
	 *
	 * @param arg1
	 * @return
	 */
	public int[] checkMatrixDimensions(IExpr arg1) {
		return arg1.isMatrix();
	}
	/**
	 * Evaluate the symbolic matrix for this algorithm.
	 * 
	 * @param matrix
	 *            the matrix which contains symbolic values
	 * @return
	 */
	public abstract FieldMatrix<IExpr> matrixEval(FieldMatrix<IExpr> matrix);

	/**
	 * Evaluate the numeric matrix for this algorithm.
	 * 
	 * @param matrix
	 *            the matrix which contains numeric values
	 * @return
	 */
	public abstract RealMatrix realMatrixEval(RealMatrix matrix);
}