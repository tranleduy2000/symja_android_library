package org.matheclipse.core.builtin;

import com.duy.lambda.BiFunction;
import com.duy.lambda.Function;
import com.duy.lambda.IntFunction;
import com.duy.lambda.ObjIntConsumer;

import org.hipparchus.exception.MathIllegalArgumentException;
import org.hipparchus.linear.BlockFieldMatrix;
import org.hipparchus.linear.DecompositionSolver;
import org.hipparchus.linear.EigenDecomposition;
import org.hipparchus.linear.FieldDecompositionSolver;
import org.hipparchus.linear.FieldLUDecomposition;
import org.hipparchus.linear.FieldMatrix;
import org.hipparchus.linear.FieldVector;
import org.hipparchus.linear.RealMatrix;
import org.hipparchus.linear.RealVector;
import org.matheclipse.core.basic.Config;
import org.matheclipse.core.convert.Convert;
import org.matheclipse.core.eval.EvalAttributes;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.exception.LimitException;
import org.matheclipse.core.eval.exception.Validate;
import org.matheclipse.core.eval.exception.WrappedException;
import org.matheclipse.core.eval.exception.WrongArgumentType;
import org.matheclipse.core.eval.exception.WrongNumberOfArguments;
import org.matheclipse.core.eval.interfaces.AbstractEvaluator;
import org.matheclipse.core.eval.interfaces.AbstractFunctionEvaluator;
import org.matheclipse.core.eval.interfaces.AbstractMatrix1Expr;
import org.matheclipse.core.eval.interfaces.AbstractMatrix1Matrix;
import org.matheclipse.core.eval.interfaces.AbstractNonOrderlessArgMultiple;
import org.matheclipse.core.eval.util.IIndexFunction;
import org.matheclipse.core.eval.util.IndexFunctionDiagonal;
import org.matheclipse.core.eval.util.IndexTableGenerator;
import org.matheclipse.core.expression.ASTRealMatrix;
import org.matheclipse.core.expression.ASTRealVector;
import org.matheclipse.core.expression.Context;
import org.matheclipse.core.expression.ExprField;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.expression.Symbol;
import org.matheclipse.core.generic.Comparators.ExprReverseComparator;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IASTAppendable;
import org.matheclipse.core.interfaces.IASTMutable;
import org.matheclipse.core.interfaces.IBuiltInSymbol;
import org.matheclipse.core.interfaces.IEvalStepListener;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.INumber;
import org.matheclipse.core.interfaces.ISymbol;

import java.util.ArrayList;
import java.util.List;

import static org.matheclipse.core.expression.F.ArcCos;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C4;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CN2;
import static org.matheclipse.core.expression.F.Divide;
import static org.matheclipse.core.expression.F.Dot;
import static org.matheclipse.core.expression.F.Function;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Map;
import static org.matheclipse.core.expression.F.MapThread;
import static org.matheclipse.core.expression.F.Most;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Norm;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Prepend;
import static org.matheclipse.core.expression.F.ReplaceAll;
import static org.matheclipse.core.expression.F.Rule;
import static org.matheclipse.core.expression.F.Slot1;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;

public final class LinearAlgebra {

	/**
	 *
	 * See <a href="https://pangin.pro/posts/computation-in-static-initializer">Beware of computation in static
	 * initializer</a>
	 */
	private static class Initializer {

		private static void init() {
        F.ArrayDepth.setEvaluator(new ArrayDepth());
        F.BrayCurtisDistance.setEvaluator(new BrayCurtisDistance());
        F.CanberraDistance.setEvaluator(new CanberraDistance());
        F.CharacteristicPolynomial.setEvaluator(new CharacteristicPolynomial());
        F.ChessboardDistance.setEvaluator(new ChessboardDistance());
        F.CholeskyDecomposition.setEvaluator(new CholeskyDecomposition());
        F.ConjugateTranspose.setEvaluator(new ConjugateTranspose());
        F.CosineDistance.setEvaluator(new CosineDistance());
        F.Cross.setEvaluator(new Cross());
        F.DesignMatrix.setEvaluator(new DesignMatrix());
        F.Det.setEvaluator(new Det());
        F.Diagonal.setEvaluator(new Diagonal());
        F.DiagonalMatrix.setEvaluator(new DiagonalMatrix());
        F.Dimensions.setEvaluator(new Dimensions());
        F.Dot.setEvaluator(new Dot());
        F.Eigenvalues.setEvaluator(new Eigenvalues());
        F.Eigenvectors.setEvaluator(new Eigenvectors());
        F.EuclideanDistance.setEvaluator(new EuclideanDistance());
        F.FourierMatrix.setEvaluator(new FourierMatrix());
			F.FromPolarCoordinates.setEvaluator(new FromPolarCoordinates());
        F.HilbertMatrix.setEvaluator(new HilbertMatrix());
        F.IdentityMatrix.setEvaluator(new IdentityMatrix());
        F.Inner.setEvaluator(new Inner());
        F.Inverse.setEvaluator(new Inverse());
        F.JacobiMatrix.setEvaluator(new JacobiMatrix());
        F.LeastSquares.setEvaluator(new LeastSquares());
        F.LinearSolve.setEvaluator(new LinearSolve());
        F.LowerTriangularize.setEvaluator(new LowerTriangularize());
        F.LUDecomposition.setEvaluator(new LUDecomposition());
        F.ManhattanDistance.setEvaluator(new ManhattanDistance());
        F.MatrixMinimalPolynomial.setEvaluator(new MatrixMinimalPolynomial());
		F.MatrixExp.setEvaluator(new MatrixExp());
        F.MatrixPower.setEvaluator(new MatrixPower());
        F.MatrixRank.setEvaluator(new MatrixRank());
        F.Norm.setEvaluator(new Norm());
        F.Normalize.setEvaluator(new Normalize());
        F.NullSpace.setEvaluator(new NullSpace());
        F.Orthogonalize.setEvaluator(new Orthogonalize());
        F.PseudoInverse.setEvaluator(PseudoInverse.CONST);
        F.Projection.setEvaluator(new Projection());
        F.QRDecomposition.setEvaluator(new QRDecomposition());
        F.RowReduce.setEvaluator(new RowReduce());
        F.SingularValueDecomposition.setEvaluator(new SingularValueDecomposition());
        F.SquaredEuclideanDistance.setEvaluator(new SquaredEuclideanDistance());
        F.ToeplitzMatrix.setEvaluator(new ToeplitzMatrix());
			F.ToPolarCoordinates.setEvaluator(new ToPolarCoordinates());
        F.Tr.setEvaluator(new Tr());
        F.Transpose.setEvaluator(new Transpose());
        F.UpperTriangularize.setEvaluator(new UpperTriangularize());
        F.UnitVector.setEvaluator(new UnitVector());
        F.VandermondeMatrix.setEvaluator(new VandermondeMatrix());
        F.VectorAngle.setEvaluator(new VectorAngle());
    }
	}

	/**
	 * <p>
	 * Matrix class that wraps a <code>FieldMatrix&lt;T&gt;</code> matrix, which is transformed to reduced row echelon
	 * format.
	 * </p>
	 * <p>
	 * See: <a href="http://en.wikipedia.org/wiki/Row_echelon_form">Wikipedia - Row echelon form</a>.
	 * </p>
	 * <p>
	 * The code was adapted from: <a href="http://rosettacode.org/wiki/Reduced_row_echelon_form#Java">Rosetta Code -
	 * Reduced row echelon form</a>
	 * </p>
	 */
	private final static class FieldReducedRowEchelonForm {
		/**
		 * Wrapper for a row and column index.
		 *
		 */
		private static class RowColIndex {
			int row;
			int col;

			RowColIndex(int r, int c) {
				row = r;
				col = c;
			}

			@Override
			public String toString() {
				return "(" + row + ", " + col + ")";
			}
		}

		private final FieldMatrix<IExpr> originalMatrix;
		private final FieldMatrix<IExpr> rowReducedMatrix;
		private FieldMatrix<IExpr> nullSpaceCache;
		private int matrixRankCache;

		/**
		 * Number of rows.
		 */
		private final int numRows;

		/**
		 * Number of columns.
		 */
		private final int numCols;

		/**
		 * Constructor which creates row reduced echelon matrix from the given <code>FieldMatrix&lt;T&gt;</code> matrix.
		 *
		 * @param matrix
		 *            matrix which will be transformed to a row reduced echelon matrix.
		 *
		 * @see #rowReduce()
		 */
		public FieldReducedRowEchelonForm(FieldMatrix<IExpr> matrix) {
			this.originalMatrix = matrix;
			this.rowReducedMatrix = matrix.copy();
			this.numRows = matrix.getRowDimension();
			this.numCols = matrix.getColumnDimension();
			this.matrixRankCache = -1;
			this.nullSpaceCache = null;
			rowReduce();
		}

		/**
		 * Constructor which creates row reduced echelon matrix from the given augmented <code>matrix</code> and
		 * column-vector <code>b</code>.
		 *
		 * @param matrix
		 *            matrix which will be transformed to a row reduced echelon matrix.
		 *
		 * @see #rowReduce()
		 */
		// public FieldReducedRowEchelonForm(FieldMatrix<IExpr> matrix, FieldVector<IExpr> b) {
		// this.originalMatrix = matrix;
		// this.rowReducedMatrix = matrix.copy();
		// this.numRows = matrix.getRowDimension();
		// this.numCols = matrix.getColumnDimension();
		// this.matrixRankCache = -1;
		// this.nullSpaceCache = null;
		// rowReduce();
		// }

		/**
		 * Test if <code>expr</code> equals the zero element.
		 *
		 * @param expr
		 * @return
		 */
		protected boolean isZero(IExpr expr) {
			return expr.isZero();
		}

		/**
		 * Test if <code>expr</code> equals the one element.
		 *
		 * @param expr
		 * @return
		 */
		protected boolean isOne(IExpr expr) {
			return expr.isOne();
		}

		private RowColIndex findPivot(RowColIndex a) {
			int first_row = a.row;
			RowColIndex pivot = new RowColIndex(a.row, a.col);
			RowColIndex current = new RowColIndex(a.row, a.col);

			for (int i = a.row; i < (numRows - first_row); i++) {
				current.row = i;
				if (isOne(rowReducedMatrix.getEntry(current.row, current.col))) {
					swapRow(current, a);
				}
			}

			current.row = a.row;
			for (int i = current.row; i < (numRows - first_row); i++) {
				current.row = i;
				if (!isZero(rowReducedMatrix.getEntry(current.row, current.col))) {
					pivot.row = i;
					break;
				}
			}

			return pivot;
		}

		private IExpr getCoordinate(RowColIndex a) {
			return rowReducedMatrix.getEntry(a.row, a.col);
		}

		/**
		 * Get the row reduced echelon form of the matrix.
		 *
		 * See: <a href="http://en.wikipedia.org/wiki/Row_echelon_form">Wikipedia - Row echelon form</a>.
		 *
		 * @return
		 */
		public FieldMatrix<IExpr> getRowReducedMatrix() {
			return rowReducedMatrix;
		}

		/**
		 * Swap the rows <code>a.row</code> and <code>b.row</code> in the matrix and swap the <code>row</code> values in
		 * the corresponding <code>RowColIndex</code> objects.
		 *
		 * @param a
		 * @param b
		 */
		private void swapRow(RowColIndex a, RowColIndex b) {
			IExpr[] temp = rowReducedMatrix.getRow(a.row);
			rowReducedMatrix.setRow(a.row, rowReducedMatrix.getRow(b.row));
			rowReducedMatrix.setRow(b.row, temp);

			int t = a.row;
			a.row = b.row;
			b.row = t;
		}

		/**
		 * Test if the column <code>a.col</code> of the matrix contains only zero-elements starting with the
		 * <code>a.row</code> element.
		 *
		 * @param a
		 * @return
		 */
		private boolean isColumnZeroFromRow(RowColIndex a) {
			for (int i = 0; i < numRows; i++) {
				if (!isZero(rowReducedMatrix.getEntry(i, a.col))) {
					return false;
				}
			}

			return true;
		}

		/**
		 * Test if the row <code>a.row</code> of the matrix contains only zero-elements.
		 *
		 * @param a
		 * @return
		 */
		private boolean isRowZeroes(int row) {
			IExpr[] temp = rowReducedMatrix.getRow(row);
			for (int i = 0; i < numCols; i++) {
				if (!isZero(temp[i])) {
					return false;
				}
			}

			return true;
		}

		/**
		 * Add the values of the row <code>to.row</code> to the product of the values of the row
		 * <code>from.row * factor</code> and assign the result values back to the row <code>to.row</code>.
		 *
		 * @param to
		 * @param from
		 * @param scalar
		 */
		private void multiplyAdd(RowColIndex to, RowColIndex from, IExpr factor) {
			IExpr[] row = rowReducedMatrix.getRow(to.row);
			IExpr[] rowMultiplied = rowReducedMatrix.getRow(from.row);

			for (int i = 0; i < numCols; i++) {
				rowReducedMatrix.setEntry(to.row, i, row[i].plus((rowMultiplied[i].times(factor))));
			}
		}

		/**
		 * Get the nullspace of the row reduced matrix.
		 *
		 * See: <a href="http://en.wikipedia.org/wiki/Kernel_%28linear_algebra%29"> Wikipedia - Kernel (linear
		 * algebra)</a>. <a href="http://en.wikibooks.org/wiki/Linear_Algebra/Null_Spaces"> Wikibooks - Null Spaces</a>.
		 *
		 * @param minusOneFactor
		 *            factor <code>-1</code> for multiplying all elements of the free part of the reduced row echelon
		 *            form matrix
		 * @return <code>null</code> if the input matrix has full rank, otherwise return the nullspaace.
		 */
		public FieldMatrix<IExpr> getNullSpace(IExpr minusOneFactor) {
			int rank = getMatrixRank();
			int newRowDimension = rowReducedMatrix.getColumnDimension() - rank;
			if (newRowDimension == 0) {
				return null;
			}
			int newColumnDimension = rowReducedMatrix.getColumnDimension();
			if (nullSpaceCache != null) {
				return nullSpaceCache;
			}
			nullSpaceCache = rowReducedMatrix.createMatrix(newRowDimension, newColumnDimension);
			getResultOfNullspace(minusOneFactor, rank);
			return nullSpaceCache;
		}

		private void getResultOfNullspace(IExpr minusOneFactor, int rank) {
			// search free columns
			boolean[] columns = new boolean[nullSpaceCache.getColumnDimension()];
			int numberOfFreeColumns = 0;
			for (int i = 0; i < rank; i++) {
				if (!columns[i]) {
					for (int k = i; k < rowReducedMatrix.getColumnDimension(); k++) {
						if (isZero(rowReducedMatrix.getEntry(i, k))) {
							columns[k] = true;
							// free column
							int offset = 0;
							for (int j = 0; j < rank; j++) {
								if (columns[j]) {
									offset++;
								}
								nullSpaceCache.setEntry(numberOfFreeColumns, j + offset,
										rowReducedMatrix.getEntry(j, i));
							}
							numberOfFreeColumns++;
						} else {
							break;
						}
					}
				}
			}

			// Let's take the rest of the 'free part' of the reduced row echelon
			// form
			int start = rank + numberOfFreeColumns;
			int row = numberOfFreeColumns;
			for (int i = start; i < nullSpaceCache.getColumnDimension(); i++) {
				int offset = 0;
				for (int j = 0; j < rank; j++) {
					if (columns[j]) {
						offset++;
					}
					nullSpaceCache.setEntry(row, j + offset, rowReducedMatrix.getEntry(j, i));
				}
				row++;
			}
			for (int i = start; i < nullSpaceCache.getColumnDimension(); i++) {
				columns[i] = true;
			}

			// multiply matrix with scalar -1
			nullSpaceCache = nullSpaceCache.scalarMultiply(minusOneFactor);

			// append the 'one element' (typically as identity matrix)
			row = 0;
			for (int i = 0; i < columns.length; i++) {
				if (columns[i]) {
					nullSpaceCache.setEntry(row++, i, F.C1);
				}
			}
		}

		/**
		 * Create the &quot;reduced row echelon form&quot; of a matrix.
		 *
		 * See: <a href="http://en.wikipedia.org/wiki/Row_echelon_form">Wikipedia - Row echelon form</a>.
		 *
		 * @return
		 */
		private FieldMatrix<IExpr> rowReduce() {
			RowColIndex pivot = new RowColIndex(0, 0);
			int submatrix = 0;
			for (int x = 0; x < numCols; x++) {
				pivot = new RowColIndex(pivot.row, x);
				// Step 1
				// Begin with the leftmost nonzero column. This is a pivot column.
				// The pivot position is at the top.
				for (int i = x; i < numCols; i++) {
					if (isColumnZeroFromRow(pivot) == false) {
						break;
					} else {
						pivot.col = i;
					}
				}
				// Step 2
				// Select a nonzero entry in the pivot column with the highest
				// absolute value as a pivot.
				pivot = findPivot(pivot);

				if (isZero(getCoordinate(pivot))) {
					pivot.row++;
					if (pivot.row + 1 > numRows) {
						pivot.row--;
						continue;
					}
				}

				// If necessary, interchange rows to move this entry into the pivot
				// position.
				// move this row to the top of the submatrix
				if (pivot.row != submatrix && !isRowZeroes(pivot.row)) {
					swapRow(new RowColIndex(submatrix, pivot.col), pivot);
				}

				if (!(isZero(getCoordinate(pivot)))) {
					// Force pivot to be 1
					if (!isOne(getCoordinate(pivot))) {
						IExpr scalar = getCoordinate(pivot).inverse();
						scaleRow(pivot, scalar);
					}
					// Step 3
					// Use row replacement operations to create zeroes in all positions
					// below the pivot.
					// belowPivot = belowPivot + (Pivot * -belowPivot)
					for (int i = pivot.row + 1; i < numRows; i++) {
						RowColIndex belowPivot = new RowColIndex(i, pivot.col);
						IExpr complement = getCoordinate(belowPivot).negate().divide(getCoordinate(pivot));
						multiplyAdd(belowPivot, pivot, complement);
					}
					// Step 5
					// Beginning with the rightmost pivot and working upward and to the
					// left, create zeroes above each pivot.
					// If a pivot is not 1, make it 1 by a scaling operation.
					// Use row replacement operations to create zeroes in all positions
					// above the pivot
					for (int i = pivot.row; i >= 0; i--) {
						if (i == pivot.row) {
							if (!isOne(getCoordinate(pivot))) {
								scaleRow(pivot, getCoordinate(pivot).inverse());
							}
							continue;
						}

						RowColIndex abovePivot = new RowColIndex(i, pivot.col);
						IExpr complement = getCoordinate(abovePivot).negate().divide(getCoordinate(pivot));
						multiplyAdd(abovePivot, pivot, complement);
					}
					submatrix++;
				}
				// Step 4
				// Ignore the row containing the pivot position and cover all rows,
				// if any, above it.
				// Apply steps 1-3 to the remaining submatrix. Repeat until there
				// are no more nonzero entries.
				if ((pivot.row + 1) >= numRows) {// || isRowZeroes(pivot.row + 1)) {
					break;
				}

				pivot.row++;
			}
			EvalEngine engine = EvalEngine.get();
			IEvalStepListener listener = engine.getStepListener();
			if (listener != null) {
				listener.add(Convert.matrix2List(originalMatrix), Convert.matrix2List(rowReducedMatrix),
						engine.getRecursionCounter(), -1, "ReducedRowEchelonForm");
			}
			return rowReducedMatrix;
		}

		/**
		 * Get the rank of the row reduced matrix.
		 *
		 * See: <a href="http://en.wikipedia.org/wiki/Rank_%28linear_algebra%29">Wikipedia - Rank (linear algebra)</a>.
		 *
		 * @return the rank of the matrix.
		 */
		public int getMatrixRank() {
			if (rowReducedMatrix.getRowDimension() == 0 || rowReducedMatrix.getColumnDimension() == 0) {
				return 0;
			}
			if (matrixRankCache < 0) {
				matrixRankCache = 0;
				int rows = rowReducedMatrix.getRowDimension() - 1;
				for (int i = rows; i >= 0; i--) {
					if (!isRowZeroes(i)) {
						matrixRankCache = i + 1;
						return matrixRankCache;
					}
				}
			}
			return matrixRankCache;
		}

		/**
		 * Multiply the <code>x.row</code> elements with the scalar <code>factor</code>.
		 *
		 * @param x
		 * @param d
		 */
		private void scaleRow(RowColIndex x, IExpr factor) {
			for (int i = 0; i < numCols; i++) {
				rowReducedMatrix.multiplyEntry(x.row, i, factor);
			}
		}

	}

    /**
     * <pre>
     * ArrayDepth(a)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * returns the depth of the non-ragged array <code>a</code>, defined as <code>Length(Dimensions(a))</code>.<br />
     * </p>
     * </blockquote>
     * <h3>Examples</h3>
	 *
     * <pre>
	 * &gt;&gt; ArrayDepth({{a,b},{c,d}})
	 * 2
     *
     * &gt;&gt; ArrayDepth(x)
     * 0
     * </pre>
     */
    private final static class ArrayDepth extends AbstractFunctionEvaluator {

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {

            if (ast.arg1().isAST()) {
                IAST list = (IAST) ast.arg1();
                IExpr header = list.head();
                ArrayList<Integer> dims = LinearAlgebra.dimensions(list, header, Integer.MAX_VALUE);
                return F.integer(dims.size());
            }

            return F.C0;

        }

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_1;
		}
        @Override
        public void setUp(final ISymbol newSymbol) {
        }

    }

    /**
     * <pre>
     * BrayCurtisDistance(u, v)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * returns the Bray Curtis distance between <code>u</code> and <code>v</code>.
     * </p>
     * </blockquote>
	 *
     * <pre>
     * &gt;&gt; BrayCurtisDistance[{-1, -1}, {10, 10}]
     * 11/9
     * </pre>
     */
    private final static class BrayCurtisDistance extends AbstractEvaluator {

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {
            if (ast.size() != 3) {
                throw new WrongNumberOfArguments(ast, 2, ast.argSize());
            }
            IExpr u = ast.arg1();
            IExpr v = ast.arg2();

            int dim1 = u.isVector();
            if (dim1 > (-1)) {
                int dim2 = v.isVector();
                if (dim1 == dim2) {
                    if (dim1 == 0) {
                        return F.C0;
                    }

                    return F.Total(F.Divide(F.Abs(F.Subtract(u, v)), F.Total(F.Abs(F.Plus(u, v)))));

                }
            }
            return F.NIL;
        }

    }

    /**
     * <pre>
     * CanberraDistance(u, v)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * returns the canberra distance between <code>u</code> and <code>v</code>, which is a weighted version of the
     * Manhattan distance.
     * </p>
     * </blockquote>
     * <h3>Examples</h3>
	 *
     * <pre>
     * &gt;&gt; CanberraDistance({-1, -1}, {1, 1})
     * 2
     * </pre>
     */
    private final static class CanberraDistance extends AbstractEvaluator {

        @Override
        public IExpr evaluate(final IAST functionList, EvalEngine engine) {
            if (functionList.size() != 3) {
                throw new WrongNumberOfArguments(functionList, 2, functionList.argSize());
            }
            IExpr arg1 = functionList.arg1();
            IExpr arg2 = functionList.arg2();

            int dim1 = arg1.isVector();
            if (dim1 > (-1)) {
                int dim2 = arg2.isVector();
                if (dim1 == dim2) {
                    if (dim1 == 0) {
                        return F.C0;
                    }

                    return F.Total(F.Divide(F.Abs(F.Subtract(arg1, arg2)), F.Plus(F.Abs(arg1), F.Abs(arg2))));

                }
            }
            return F.NIL;
        }

    }

    /**
     * <pre>
     * CharacteristicPolynomial(matrix, var)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * computes the characteristic polynomial of a <code>matrix</code> for the variable <code>var</code>.
     * </p>
     * </blockquote>
     * <p>
     * See:<br />
     * </p>
     * <ul>
     * <li><a href= "https://en.wikipedia.org/wiki/Characteristic_polynomial">Wikipedia - Characteristic
     * polynomial</a></li>
     * </ul>
     * <h3>Examples</h3>
	 *
     * <pre>
     * &gt;&gt; CharacteristicPolynomial({{1, 2}, {42, 43}}, x)
     * -41-44*x+x^2
     * </pre>
     */
    private final static class CharacteristicPolynomial extends AbstractFunctionEvaluator {

        /**
         * Generate the characteristic polynomial of a square matrix.
         *
		 * @param dim
		 *            dimension of the square matrix
		 * @param matrix
		 *            the square matrix
		 * @param variable
		 *            the variable which should be used in the resulting characteristic polynomial
         * @return
         */
        public static IAST generateCharacteristicPolynomial(int dim, IAST matrix, IExpr variable) {
            final IExpr[] valuesForIdentityMatrix = {F.C0, variable};
            return F.Det(F.Subtract(matrix, diagonalMatrix(valuesForIdentityMatrix, dim)));
        }

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {
            int[] dimensions = ast.arg1().isMatrix();
            if (dimensions != null && dimensions[0] == dimensions[1]) {
                // a matrix with square dimensions
                IAST matrix = (IAST) ast.arg1();
                IExpr variable = ast.arg2();
                return generateCharacteristicPolynomial(dimensions[0], matrix, variable);
            }

            return F.NIL;
        }

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_2_2;
		}
    }

    /**
     * <pre>
     * ChessboardDistance(u, v)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * returns the chessboard distance (also known as Chebyshev distance) between <code>u</code> and <code>v</code>,
     * which is the number of moves a king on a chessboard needs to get from square <code>u</code> to square
     * <code>v</code>.
     * </p>
     * </blockquote>
     * <h3>Examples</h3>
	 *
     * <pre>
     * &gt;&gt; ChessboardDistance({-1, -1}, {1, 1})
     * 2
     * </pre>
     */
    private final static class ChessboardDistance extends AbstractEvaluator {

        @Override
        public IExpr evaluate(final IAST functionList, EvalEngine engine) {
            if (functionList.size() != 3) {
                throw new WrongNumberOfArguments(functionList, 2, functionList.argSize());
            }
            IExpr arg1 = functionList.arg1();
            IExpr arg2 = functionList.arg2();

            int dim1 = arg1.isVector();
            if (dim1 > (-1)) {
                int dim2 = arg2.isVector();
                if (dim1 == dim2) {
                    if (dim1 == 0) {
                        return F.C0;
                    }
					final IAST a1 = ((IAST) arg1);
					final IAST a2 = ((IAST) arg2);
                    IASTAppendable maxAST = F.Max();
                    return maxAST.appendArgs(a1.size(), new IntFunction<IExpr>() {
                        @Override
                        public IExpr apply(int i) {
                            return F.Abs(F.Subtract(a1.get(i), a2.get(i)));
                        }
                    });
                    // for (int i = 1; i < a1.size(); i++) {
                    // maxAST.append(F.Abs(F.Subtract(a1.get(i), a2.get(i))));
                    // }
                    // return maxAST;
                }
            }
            return F.NIL;
        }

    }

    /**
     * Calculates the Cholesky decomposition of a matrix.
	 *
     * The Cholesky decomposition of a real symmetric positive-definite matrix A consists of a lower triangular matrix L
     * with same size such that: A = LL<sup>T</sup>. In a sense, this is the square root of A.
	 *
     */
    private final static class CholeskyDecomposition extends AbstractFunctionEvaluator {

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {

            RealMatrix matrix;
            try {

                matrix = ast.arg1().toRealMatrix();
                if (matrix != null) {
                    final org.hipparchus.linear.CholeskyDecomposition dcomposition = new org.hipparchus.linear.CholeskyDecomposition(
                            matrix);
                    // Returns the transpose of the matrix L of the decomposition.
                    return new ASTRealMatrix(dcomposition.getLT(), false);
                }

            } catch (final WrongArgumentType e) {
                // WrongArgumentType occurs in list2RealMatrix(),
                // if the matrix elements aren't pure numerical values
                if (Config.SHOW_STACKTRACE) {
                    e.printStackTrace();
                }
            } catch (final IndexOutOfBoundsException e) {
                if (Config.SHOW_STACKTRACE) {
                    e.printStackTrace();
                }
            }

            return F.NIL;
        }

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_1;
		}
    }

    /**
     * <pre>
     * ConjugateTranspose(matrix)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * get the transposed <code>matrix</code> with conjugated matrix elements.
     * </p>
     * </blockquote>
     * <p>
     * See:<br />
     * </p>
     * <ul>
     * <li><a href="http://en.wikipedia.org/wiki/Transpose">Wikipedia - Transpose</a></li>
     * <li><a href="http://en.wikipedia.org/wiki/Complex_conjugation">Wikipedia - Complex conjugation</a></li>
     * </ul>
     */
    private final static class ConjugateTranspose extends Transpose {

        @Override
        protected IExpr transform(final IExpr expr) {
            return expr.conjugate();
        }

    }

    /**
     * <pre>
     * CosineDistance(u, v)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * returns the cosine distance between <code>u</code> and <code>v</code>.
     * </p>
     * </blockquote>
     * <h3>Examples</h3>
	 *
     * <pre>
     * &gt;&gt; N(CosineDistance({7, 9}, {71, 89}))
     * 7.596457213221441E-5
     *
     * &gt;&gt; CosineDistance({a, b}, {c, d})
     * 1-(a*c+b*d)/(Sqrt(Abs(a)^2+Abs(b)^2)*Sqrt(Abs(c)^2+Abs(d)^2))
     * </pre>
     */
    private final static class CosineDistance extends AbstractEvaluator {

        @Override
        public IExpr evaluate(final IAST functionList, EvalEngine engine) {
            if (functionList.size() != 3) {
                throw new WrongNumberOfArguments(functionList, 2, functionList.argSize());
            }
            IExpr arg1 = functionList.arg1();
            IExpr arg2 = functionList.arg2();

            int dim1 = arg1.isVector();
            if (dim1 > (-1)) {
                int dim2 = arg2.isVector();
                if (dim1 == dim2) {
                    if (dim1 == 0) {
                        return F.C0;
                    }

                    return F.Subtract(F.C1, F.Divide(F.Dot(arg1, arg2), F.Times(F.Norm(arg1), F.Norm(arg2))));

                }
            }
            return F.NIL;
        }

    }

    /**
     * <pre>
     * Cross(a, b)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * computes the vector cross product of <code>a</code> and <code>b</code>.
     * </p>
     * </blockquote>
     * <p>
     * See:
     * </p>
     * <ul>
     * <li><a href="https://en.wikipedia.org/wiki/Cross_product">Wikipedia: Cross product</a></li>
     * </ul>
     * <h3>Examples</h3>
	 *
     * <pre>
     * &gt;&gt; Cross({x1, y1, z1}, {x2, y2, z2})
     * {-y2*z1+y1*z2,x2*z1-x1*z2,-x2*y1+x1*y2}
     *
     * &gt;&gt; Cross({x, y})
     * {-y,x}
     * </pre>
     * <p>
     * The arguments are expected to be vectors of equal length, and the number of arguments is expected to be 1 less
     * than their length.
     * </p>
	 *
     * <pre>
     * &gt;&gt; Cross({1, 2}, {3, 4, 5})
     * Cross({1, 2}, {3, 4, 5})
     * </pre>
     */
    private final static class Cross extends AbstractFunctionEvaluator {

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {

            IExpr arg1 = ast.arg1();
            if (ast.isAST2()) {
                IExpr arg2 = ast.arg2();
                int dim1 = arg1.isVector();
                int dim2 = arg2.isVector();
                if (dim1 == 2 && dim2 == 2) {
                    final IAST v1 = (IAST) arg1;
                    final IAST v2 = (IAST) arg2;
                    if ((v1.isAST2()) || (v2.isAST2())) {
                        // Cross({a,b}, {c,d})", "a*d-b*c
                        return F.Subtract(Times(v1.arg1(), v2.arg2()), Times(v1.arg2(), v2.arg1()));
                    }
                } else if (dim1 == 3 && dim2 == 3) {
                    final IAST v1 = (IAST) arg1;
                    final IAST v2 = (IAST) arg2;
                    if ((v1.isAST3()) || (v2.isAST3())) {
                        return List(Plus(Times(v1.arg2(), v2.arg3()), Times(CN1, v1.arg3(), v2.arg2())),
                                Plus(Times(v1.arg3(), v2.arg1()), Times(CN1, v1.arg1(), v2.arg3())),
                                Plus(Times(v1.arg1(), v2.arg2()), Times(CN1, v1.arg2(), v2.arg1())));
                    }
                }
            } else if (ast.isAST1()) {
                int dim1 = arg1.isVector();
                if (dim1 == 2) {
                    final IAST v1 = (IAST) arg1;
                    return List(Negate(v1.arg2()), v1.arg1());
                }
            } else if (ast.size() > 3) {
                int dim1 = arg1.isVector();
                if (dim1 == ast.size()) {
                    for (int i = 2; i < ast.size(); i++) {
                        if (ast.get(i).isVector() != dim1) {
                            return F.NIL;
                        }
                    }
                    // TODO implement for more than 2 vector arguments
                }
            }
            return F.NIL;
        }

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_INFINITY;
		}
    }

    /**
     * <pre>
     * DesignMatrix(m, f, x)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * returns the design matrix.
     * </p>
     * </blockquote>
     * <h3>Examples</h3>
	 *
     * <pre>
     * &gt;&gt; DesignMatrix({{2, 1}, {3, 4}, {5, 3}, {7, 6}}, x, x)
     * {{1,2},{1,3},{1,5},{1,7}}
     *
     * &gt;&gt; DesignMatrix({{2, 1}, {3, 4}, {5, 3}, {7, 6}}, f(x), x)
     * {{1,f(2)},{1,f(3)},{1,f(5)},{1,f(7)}}
     * </pre>
     */
    private static class DesignMatrix extends AbstractEvaluator {

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {
            IExpr m = ast.arg1();
            IExpr f = ast.arg2();
            IExpr x = ast.arg3();
            if (f.isList()) {
                if (x.isAtom()) {
					// DesignMatrix(m_, f_List, x_?AtomQ) :=
					// DesignMatrix(m, {f}, ConstantArray(x, Length(f)))
					return F.DesignMatrix(m, F.List(f), F.ConstantArray(x, F.ZZ(((IAST)f).argSize())));
                } else if (x.isList()) {
					// DesignMatrix(m_, f_List, x_List) :=
					// Prepend(MapThread(Function({g, y, r}, g /. y -> r), {f, x, Most(#)}), 1)& /@ m
					return Map(
							Function(Prepend(MapThread(Function(List(F.g, F.y, F.r), ReplaceAll(F.g, Rule(F.y, F.r))),
									List(f, x, Most(Slot1))), C1)),
							m);
                }
            } else {
                if (x.isAtom()) {
					// DesignMatrix(m_, f_, x_?AtomQ) := DesignMatrix(m, {f}, {x})
                    return F.DesignMatrix(m, F.List(f), F.List(x));
                }
            }
            return F.NIL;
        }

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_3_3;
		}
        @Override
        public void setUp(final ISymbol newSymbol) {
        }

    }

    /**
     * <pre>
     * Det(matrix)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * computes the determinant of the <code>matrix</code>.
     * </p>
     * </blockquote>
     * <p>
     * See:
     * </p>
     * <ul>
     * <li><a href="https://en.wikipedia.org/wiki/Determinant">Wikipedia: Determinant</a></li>
     * </ul>
     * <h3>Examples</h3>
	 *
     * <pre>
     * &gt;&gt; Det({{1, 1, 0}, {1, 0, 1}, {0, 1, 1}})
     * -2
     * </pre>
     * <p>
     * Symbolic determinant:
     * </p>
	 *
     * <pre>
     * &gt;&gt; Det({{a, b, c}, {d, e, f}, {g, h, i}})
     * -c*e*g+b*f*g+c*d*h-a*f*h-b*d*i+a*e*i
     * </pre>
     */
    private static class Det extends AbstractMatrix1Expr {

        @Override
        public IExpr matrixEval(final FieldMatrix<IExpr> matrix) {
            if (matrix.getRowDimension() == 2 && matrix.getColumnDimension() == 2) {
                return determinant2x2(matrix);
            }
            if (matrix.getRowDimension() == 3 && matrix.getColumnDimension() == 3) {
                return determinant3x3(matrix);
            }
            final FieldLUDecomposition<IExpr> lu = new FieldLUDecomposition<IExpr>(matrix);
            return F.evalExpand(lu.getDeterminant());
        }

        @Override
        public IExpr realMatrixEval(RealMatrix matrix) {
            final org.hipparchus.linear.LUDecomposition lu = new org.hipparchus.linear.LUDecomposition(matrix);
            return F.num(lu.getDeterminant());
        }
    }

    private static class Diagonal extends AbstractEvaluator {

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {

            final int[] dim = ast.arg1().isMatrix();
            if (dim != null) {
                int diff = 0;
                if (ast.size() > 2) {
                    diff = ast.arg2().toIntDefault(Integer.MIN_VALUE);
                    if (diff == Integer.MIN_VALUE) {
                        return F.NIL;
                    }
                }
                final IAST matrix = (IAST) ast.arg1();

                int rowLength = dim[0];
                int columnLength = dim[1];
                IAST row;
                IASTAppendable result = F.ListAlloc(rowLength);
                for (int i = 1; i <= rowLength; i++) {
                    row = (IAST) matrix.get(i);
                    int indx = i + diff;
                    if (indx > 0 && indx <= columnLength) {
                        result.append(row.get(indx));
                    }
                }
                return result;
            }
            return F.NIL;
        }

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_2;
		}
        @Override
        public void setUp(final ISymbol newSymbol) {
        }

    }

    /**
     * <pre>
     * DiagonalMatrix(list)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * gives a matrix with the values in $list$ on its diagonal and zeroes elsewhere.
     * </p>
     * </blockquote>
	 *
     * <pre>
     * &gt;&gt; DiagonalMatrix({1, 2, 3})
     * {{1, 0, 0}, {0, 2, 0}, {0, 0, 3}}
     *
     * &gt;&gt; MatrixForm(%)
     *  1   0   0
     *  0   2   0
     *  0   0   3
     *
     * &gt;&gt; DiagonalMatrix(a + b)
     * DiagonalMatrix(a + b)
     * </pre>
     */
    private static class DiagonalMatrix extends AbstractFunctionEvaluator {

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {

            if (ast.arg1().isAST()) {
				final IAST vector = (IAST) ast.arg1();
                int m = vector.size();
                final int offset = ast.isAST2() ? Validate.checkIntType(ast, 2, Integer.MIN_VALUE) : 0;
				return F.matrix(new BiFunction<Integer, Integer, IExpr>() {
                    @Override
                    public IExpr apply(Integer i, Integer j) {
                        return (i + offset) == j ? vector.get(i + 1) : F.C0;
                    }
                }, m - 1, m - 1);
            }

            return F.NIL;

        }

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_2;
		}
        @Override
        public void setUp(final ISymbol newSymbol) {
        }

    }

    /**
     * <pre>
     * Dimensions(expr)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * returns a list of the dimensions of the expression <code>expr</code>.
     * </p>
     * </blockquote>
     * <h3>Examples</h3>
     * <p>
     * A vector of length 3:
     * </p>
	 *
     * <pre>
     * &gt;&gt; Dimensions({a, b, c})
     *  = {3}
     * </pre>
     * <p>
     * A 3x2 matrix:
     * </p>
	 *
     * <pre>
     * &gt;&gt; Dimensions({{a, b}, {c, d}, {e, f}})
     *  = {3, 2}
     * </pre>
     * <p>
     * Ragged arrays are not taken into account:
     * </p>
	 *
     * <pre>
     * &gt;&gt; Dimensions({{a, b}, {b, c}, {c, d, e}})
     * {3}
     * </pre>
     * <p>
     * The expression can have any head:
     * </p>
	 *
     * <pre>
     * &gt;&gt; Dimensions[f[f[a, b, c]]]
     * {1, 3}
     * &gt;&gt; Dimensions({})
     * {0}
     * &gt;&gt; Dimensions({{}})
     * {1, 0}
     * </pre>
     */
    private static class Dimensions extends AbstractFunctionEvaluator {

        private static IAST getDimensions(final IAST ast, int maximumLevel) {
            IAST list = (IAST) ast.arg1();
            IExpr header = list.head();
			final ArrayList<Integer> dims = dimensions(list, header, maximumLevel - 1);
            int dimsSize = dims.size();
            IASTAppendable res = F.ListAlloc(dimsSize);
			return res.appendArgs(0, dimsSize, new IntFunction<IExpr>() {
                @Override
                public IExpr apply(int i) {
                    return F.integer(dims.get(i).intValue());
                }
            });
        }

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {

            int maximumLevel = Integer.MAX_VALUE;
            if (ast.isAST2() && ast.arg2().isInteger()) {
				maximumLevel = ast.arg2().toIntDefault(Integer.MIN_VALUE);
				if (maximumLevel < 0) {
					// Positive integer (less equal 2147483647) expected at position `2` in `1`.
					return IOFunctions.printMessage(F.Dimensions, "intpm", F.List(ast, F.C2), engine);
				}
            }
            if (ast.arg1().isAST()) {
                if (maximumLevel > 0) {
                    return getDimensions(ast, maximumLevel);
                }
                return F.List();
            }

            return F.List();

        }

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_2;
		}
        @Override
        public void setUp(final ISymbol newSymbol) {
        }

    }

    /**
     * <pre>
     * Dot(x, y) or x . y
     * </pre>
	 *
     * <blockquote>
     * <p>
     * <code>x . y</code> computes the vector dot product or matrix product <code>x . y</code>.
     * </p>
     * </blockquote>
     * <p>
     * See:<br />
     * </p>
     * <ul>
     * <li><a href="https://en.wikipedia.org/wiki/Matrix_multiplication">Wikipedia - Matrix multiplication</a></li>
     * </ul>
     * <h3>Examples</h3>
     * <p>
     * Scalar product of vectors:
     * </p>
	 *
     * <pre>
     * &gt;&gt; {a, b, c} . {x, y, z}
     * a*x+b*y+c*z
     * </pre>
     * <p>
     * Product of matrices and vectors:
     * </p>
	 *
     * <pre>
     * &gt;&gt; {{a, b}, {c, d}} . {x, y}
     * {a*x+b*y,c*x+d*y}
     * </pre>
     * <p>
     * Matrix product:
     * </p>
	 *
     * <pre>
     * &gt;&gt; {{a, b}, {c, d}} . {{r, s}, {t, u}}
     * {{a*r+b*t,a*s+b*u}, {c*r+d*t,c*s+d*u}}
     *
     * &gt;&gt; a . b
     * a.b
     * </pre>
     */
    private static class Dot extends AbstractNonOrderlessArgMultiple {

		@Override
		public IExpr evaluateAST1(final IAST ast, EvalEngine engine) {
			return ast.arg1();
		}

        @Override
		public IExpr e2ObjArg(IAST ast, final IExpr arg1, final IExpr arg2) {

			IExpr temp = numericalDot(arg1, arg2);
            if (temp.isPresent()) {
                return temp;
            }

            FieldMatrix<IExpr> matrix0;
            FieldMatrix<IExpr> matrix1;
            FieldVector<IExpr> vector0;
            FieldVector<IExpr> vector1;
            EvalEngine engine = EvalEngine.get();
            boolean togetherMode = engine.isTogetherMode();
            try {
                engine.setTogetherMode(true);
                IAST list;

				if (arg1.isMatrix() != null) {
					list = (IAST) arg1;
                    matrix0 = Convert.list2Matrix(list);
                    if (matrix0 != null) {
						if (arg2.isMatrix() != null) {
							list = (IAST) arg2;
                            matrix1 = Convert.list2Matrix(list);
							if (matrix1 != null) {
                            return Convert.matrix2List(matrix0.multiply(matrix1));
							}
						} else if (arg2.isVector() != (-1)) {
							list = (IAST) arg2;
                            vector1 = Convert.list2Vector(list);
                            IAST res = Convert.vector2List(matrix0.operate(vector1));
                            if (res == null) {
                                return F.NIL;
                            }
                            return res;
                        }
                    }
					return engine.printMessage(ast.topHead() + ": Error in matrix");
				} else if (arg1.isVector() != (-1)) {
					list = (IAST) arg1;
                    vector0 = Convert.list2Vector(list);
                    if (vector0 != null) {
						if (arg2.isMatrix() != null) {
							list = (IAST) arg2;
                            matrix1 = Convert.list2Matrix(list);
                            return Convert.vector2List(matrix1.preMultiply(vector0));
						} else if (arg2.isVector() != (-1)) {
							list = (IAST) arg2;
                            vector1 = Convert.list2Vector(list);
                            if (vector1 != null) {
                                return vector0.dotProduct(vector1);
                            }
                        }
                    }
					return engine.printMessage(ast.topHead() + ": Error in vector");
                }

				// } catch (final ClassCastException e) {
				// if (Config.SHOW_STACKTRACE) {
				// e.printStackTrace();
				// }
				// } catch (final IndexOutOfBoundsException e) {
				// if (Config.SHOW_STACKTRACE) {
				// e.printStackTrace();
				// }
			} catch (final RuntimeException e) {
				engine.printMessage(ast.topHead() + ": " + e.getMessage());
                if (Config.SHOW_STACKTRACE) {
                    e.printStackTrace();
                }
				// } catch (final org.hipparchus.exception.MathRuntimeException e) {
				// if (Config.SHOW_STACKTRACE) {
				// e.printStackTrace();
				// }
            } finally {
                engine.setTogetherMode(togetherMode);
            }
            return F.NIL;
        }

        private IExpr numericalDot(final IExpr o0, final IExpr o1) throws MathIllegalArgumentException {
            if (o0.isRealMatrix()) {
                if (o1.isMatrix() != null) {
                    RealMatrix m1 = o1.toRealMatrix();
                    if (m1 != null) {
                        RealMatrix m0 = o0.toRealMatrix();
                        return new ASTRealMatrix(m0.multiply(m1), false);
                    }
                } else if (o1.isVector() != (-1)) {
                    RealVector m1 = o1.toRealVector();
                    if (m1 != null) {
                        RealMatrix m0 = o0.toRealMatrix();
                        return new ASTRealVector(m0.operate(m1), false);
                    }
                }
            } else if (o0.isRealVector()) {
                if (o1.isMatrix() != null) {
                    RealMatrix m1 = o1.toRealMatrix();
                    if (m1 != null) {
                        RealVector v0 = o0.toRealVector();
                        return new ASTRealVector(m1.preMultiply(v0), false);
                    }
                } else if (o1.isVector() != (-1)) {
                    RealVector v1 = o1.toRealVector();
                    if (v1 != null) {
                        RealVector v0 = o0.toRealVector();
                        return F.num(v0.dotProduct(v1));
                    }
                }
            }

            if (o1.isRealMatrix()) {
                if (o0.isMatrix() != null) {
                    RealMatrix m0 = o0.toRealMatrix();
                    if (m0 != null) {
                        RealMatrix m1 = o1.toRealMatrix();
                        return new ASTRealMatrix(m0.multiply(m1), false);
                    }
                } else if (o0.isVector() != (-1)) {
                    RealVector v0 = o0.toRealVector();
                    if (v0 != null) {
                        RealMatrix m1 = o1.toRealMatrix();
                        return new ASTRealVector(m1.preMultiply(v0), false);
                    }
                }
            } else if (o1.isRealVector()) {
                if (o0.isMatrix() != null) {
                    RealMatrix m0 = o0.toRealMatrix();
                    if (m0 != null) {
                        RealVector m1 = o1.toRealVector();
                        return new ASTRealVector(m0.operate(m1), false);
                    }
                } else if (o0.isVector() != (-1)) {
                    RealVector v0 = o0.toRealVector();
                    if (v0 != null) {
                        RealVector v1 = o1.toRealVector();
                        return F.num(v0.dotProduct(v1));
                    }
                }
            }
            return F.NIL;
        }

        @Override
        public IExpr numericEval(final IAST ast, EvalEngine engine) {
            return evaluate(ast, engine);
        }

        @Override
        public void setUp(final ISymbol newSymbol) {
            newSymbol.setAttributes(ISymbol.FLAT | ISymbol.ONEIDENTITY);
        }

    }

    /**
     * <pre>
     * Eigenvalues(matrix)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * get the numerical eigenvalues of the <code>matrix</code>.
     * </p>
     * </blockquote>
     * <p>
     * See:
     * </p>
     * <ul>
     * <li><a href="http://en.wikipedia.org/wiki/Eigenvalue">Wikipedia - Eigenvalue</a></li>
     * </ul>
     * <h3>Examples</h3>
	 *
     * <pre>
     * &gt;&gt;&gt; Eigenvalues({{1,0,0},{0,1,0},{0,0,1}})
     * {1.0,1.0,1.0}
     * </pre>
     */
    private static class Eigenvalues extends AbstractMatrix1Expr {

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {
            if (ast.size() == 2) {
                FieldMatrix<IExpr> matrix;
                try {

                    IExpr arg1 = ast.arg1();
                    int[] dim = arg1.isMatrix();
                    if (dim != null) {
                        if (dim[0] == 1 && dim[1] == 1) {
                            // Eigenvalues({{a}})
                            return List(((IAST) arg1).getPart(1, 1));
                        }
                        if (dim[0] == 2 && dim[1] == 2) {
                            matrix = Convert.list2Matrix((IAST) arg1);
                            if (matrix != null) {
                                // Eigenvalues({{a, b}, {c, d}}) =>
                                // {
                                // 1/2*(a + d - Sqrt(a^2 + 4*b*c - 2*a*d + d^2)),
                                // 1/2*(a + d + Sqrt(a^2 + 4*b*c - 2*a*d + d^2))
                                // }
                                IExpr sqrtExpr = Sqrt(Plus(Sqr(matrix.getEntry(0, 0)),
                                        Times(C4, matrix.getEntry(0, 1), matrix.getEntry(1, 0)),
                                        Times(CN2, matrix.getEntry(0, 0), matrix.getEntry(1, 1)),
                                        Sqr(matrix.getEntry(1, 1))));
                                return List(
                                        Times(C1D2,
                                                Plus(Negate(sqrtExpr), matrix.getEntry(0, 0), matrix.getEntry(1, 1))),
                                        Times(C1D2, Plus(sqrtExpr, matrix.getEntry(0, 0), matrix.getEntry(1, 1))));
                            }
                        }

						// if (((IAST) arg1).forAllLeaves(x->x.isExactNumber(), 1)) {
						// ISymbol x = F.Dummy("x");
						// IExpr m = engine.evaluate(F.CharacteristicPolynomial(arg1, x));
						// IAST list = PolynomialFunctions.roots(m, false, F.List(x), engine);
						// if (list.isPresent()) {
						// return F.Reverse(list);
						// }
						// }
                    }

				} catch (final RuntimeException e) {
                    if (Config.SHOW_STACKTRACE) {
                        e.printStackTrace();
                    }
                }
            }
            // switch to numeric calculation
            return numericEval(ast, engine);
        }

        @Override
        public IExpr matrixEval(FieldMatrix<IExpr> matrix) {
            return F.NIL;
        }

        @Override
        public IAST realMatrixEval(RealMatrix matrix) {
            try {

                EigenDecomposition ed = new EigenDecomposition(matrix);
                final double[] realValues = ed.getRealEigenvalues();
                final double[] imagValues = ed.getImagEigenvalues();
                int size = realValues.length;
                IASTAppendable list = F.ListAlloc(size);
                return list.appendArgs(0, size, new IntFunction<IExpr>() {
                    @Override
                    public IExpr apply(int i) {
                        if (F.isZero(imagValues[i])) {
                            return F.num(realValues[i]);
                        }
                        return F.complexNum(realValues[i], imagValues[i]);
                    }
                });
            } catch (Exception ime) {
                throw new WrappedException(ime);
            }
        }
    }

    /**
     * <pre>
     * Eigenvectors(matrix)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * get the numerical eigenvectors of the <code>matrix</code>.
     * </p>
     * </blockquote>
     * <p>
     * See:
     * </p>
     * <ul>
     * <li><a href="http://en.wikipedia.org/wiki/Eigenvalue">Wikipedia - Eigenvalue</a></li>
     * </ul>
     * <h3>Examples</h3>
	 *
     * <pre>
     * &gt;&gt;&gt; Eigenvectors({{1,0,0},{0,1,0},{0,0,1}})
     * {{1.0,0.0,0.0},{0.0,1.0,0.0},{0.0,0.0,1.0}}
     * </pre>
     */
    private static class Eigenvectors extends AbstractMatrix1Expr {

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {
            if (ast.size() == 2) {
                FieldMatrix<IExpr> matrix;
                try {

                    int[] dim = ast.arg1().isMatrix();
                    if (dim != null) {
                        if (dim[0] == 1 && dim[1] == 1) {
                            // Eigenvectors({{a}})
                            return C1;
                        }
                        if (dim[0] == 2 && dim[1] == 2) {
                            matrix = Convert.list2Matrix((IAST) ast.arg1());
                            if (matrix != null) {
                                if (matrix.getEntry(1, 0).isZero()) {
                                    if (matrix.getEntry(0, 0).equals(matrix.getEntry(1, 1))) {
                                        // Eigenvectors({{a, b}, {0, a}})
                                        return List(List(C1, C0), List(C0, C0));
                                    } else {
                                        // Eigenvectors({{a, b}, {0, d}})
                                        return List(List(C1, C0), List(Divide(Negate(matrix.getEntry(0, 1)),
                                                Subtract(matrix.getEntry(0, 0), matrix.getEntry(1, 1))), C1));
                                    }
                                } else {
                                    // Eigenvectors({{a, b}, {c, d}}) =>
                                    // {
                                    // { - (1/(2*c)) * (-a + d + Sqrt(a^2 + 4*b*c - 2*a*d + d^2)), 1},
                                    // { - (1/(2*c)) * (-a + d - Sqrt(a^2 + 4*b*c - 2*a*d + d^2)), 1}
                                    // }
                                    IExpr sqrtExpr = Sqrt(Plus(Sqr(matrix.getEntry(0, 0)),
                                            Times(C4, matrix.getEntry(0, 1), matrix.getEntry(1, 0)),
                                            Times(CN2, matrix.getEntry(0, 0), matrix.getEntry(1, 1)),
                                            Sqr(matrix.getEntry(1, 1))));
                                    return List(
                                            List(Times(CN1D2, Power(matrix.getEntry(1, 0), CN1),
                                                    Plus(sqrtExpr, Negate(matrix.getEntry(0, 0)),
                                                            matrix.getEntry(1, 1))),
                                                    C1),
                                            List(Times(CN1D2, Power(matrix.getEntry(1, 0), CN1), Plus(Negate(sqrtExpr),
                                                    Negate(matrix.getEntry(0, 0)), matrix.getEntry(1, 1))), C1));
                                }
                            }
                        }

                    }

                } catch (final ClassCastException e) {
                    if (Config.SHOW_STACKTRACE) {
                        e.printStackTrace();
                    }
                } catch (final IndexOutOfBoundsException e) {
                    if (Config.SHOW_STACKTRACE) {
                        e.printStackTrace();
                    }
                }
            }

            // switch to numeric calculation
            return numericEval(ast, engine);
        }

        @Override
        public IExpr matrixEval(FieldMatrix<IExpr> matrix) {
            return F.NIL;
        }

        @Override
        public IAST realMatrixEval(RealMatrix matrix) {
            try {
                final EigenDecomposition ed = new EigenDecomposition(matrix);
                int size = matrix.getColumnDimension();
                IASTAppendable list = F.ListAlloc(size);
                return list.appendArgs(0, size, new IntFunction<IExpr>() {
                    @Override
                    public IExpr apply(int i) {
                        RealVector rv = ed.getEigenvector(i);
                        return Convert.vector2List(rv);
                    }
                });
                // for (int i = 0; i < size; i++) {
                // RealVector rv = ed.getEigenvector(i);
                // list.append(Convert.vector2List(rv));
                // }
                // return list;
            } catch (Exception ime) {
                throw new WrappedException(ime);
            }
        }
    }

    /**
     * <pre>
     * EuclideanDistance(u, v)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * returns the euclidean distance between <code>u</code> and <code>v</code>.
     * </p>
     * </blockquote>
     * <h3>Examples</h3>
	 *
     * <pre>
     * &gt;&gt; EuclideanDistance({-1, -1}, {1, 1})
     * 2*Sqrt(2)
     *
     * &gt;&gt; EuclideanDistance({a, b}, {c, d})
     * Sqrt(Abs(a-c)^2+Abs(b-d)^2)
     * </pre>
     */
    private final static class EuclideanDistance extends AbstractEvaluator {

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {
            IExpr arg1 = ast.arg1();
            IExpr arg2 = ast.arg2();

            int dim1 = arg1.isVector();
            if (dim1 > (-1)) {
                int dim2 = arg2.isVector();
                if (dim1 == dim2) {
                    if (dim1 == 0) {
                        return F.C0;
                    }
					final IAST a1 = ((IAST) arg1);
					final IAST a2 = ((IAST) arg2);
                    int size = a1.size();
                    IASTAppendable plusAST = F.PlusAlloc(size);
					plusAST.appendArgs(size, new IntFunction<IExpr>() {
                        @Override
                        public IExpr apply(int i) {
                            return F.Sqr(F.Abs(F.Subtract(a1.get(i), a2.get(i))));
                        }
                    });
                    return F.Sqrt(plusAST);
                }
            }
            return F.NIL;
        }

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_2_2;
		}
        @Override
        public void setUp(ISymbol newSymbol) {

        }

    }

    private static class FourierMatrix extends AbstractFunctionEvaluator {

        /**
         * Complex number on unit circle with given argument.
         *
         * @param arg
         * @return complex number on unit circle with given argument
         */
        private static IExpr unit(IExpr arg) {
            return F.Plus(F.Cos(arg), F.Times(F.CI, F.Sin(arg)));
        }

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {

            if (ast.arg1().isInteger()) {
				final int m = ast.arg1().toIntDefault(Integer.MIN_VALUE);
				if (m < 0) {
					// Positive integer (less equal 2147483647) expected at position `2` in `1`.
					return IOFunctions.printMessage(F.FourierMatrix, "intpm", F.List(ast, F.C1), engine);
				}
                int[] count = new int[1];
                count[0] = 1;
				final IAST scalar = F.Sqrt(F.QQ(1, m));
				return F.matrix(new BiFunction<Integer, Integer, IExpr>() {
                    @Override
                    public IExpr apply(Integer i, Integer j) {
                        return unit(F.QQ(2L * ((long) i) * ((long) j), m).times(F.Pi)).times(scalar);
                    }
                }, m, m);
			}
			return F.NIL;
		}
		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_1;
		}

	}

	/**
	 * <pre>
	 * FromPolarCoordinates({r, t})
	 * </pre>
	 *
	 * <blockquote>
	 * <p>
	 * return the cartesian coordinates for the polar coordinates <code>{r, t}</code>.
	 * </p>
	 * </blockquote>
	 *
	 * <pre>
	 * FromPolarCoordinates({r, t, p})
	 * </pre>
	 *
	 * <blockquote>
	 * <p>
	 * return the cartesian coordinates for the polar coordinates <code>{r, t, p}</code>.
	 * </p>
	 * </blockquote>
	 * <h3>Examples</h3>
	 *
	 * <pre>
	 * &gt;&gt; FromPolarCoordinates({r, t})
	 * {r*Cos(t),r*Sin(t)}
	 *
	 * &gt;&gt; FromPolarCoordinates({r, t, p})
	 * {r*Cos(t),r*Cos(p)*Sin(t),r*Sin(p)*Sin(t)}
	 * </pre>
	 */
	private final static class FromPolarCoordinates extends AbstractEvaluator {
                    @Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			int dim = ast.arg1().isVector();
			if (dim > 0) {
				IAST list = (IAST) ast.arg1();
				if (dim == 2) {
					IExpr r = list.arg1();
					IExpr theta = list.arg2();
					return F.List(F.Times(r, F.Cos(theta)), F.Times(r, F.Sin(theta)));
				} else if (dim == 3) {
					IExpr r = list.arg1();
					IExpr theta = list.arg2();
					IExpr phi = list.arg3();
					return F.List(F.Times(r, F.Cos(theta)), F.Times(r, F.Cos(phi), F.Sin(theta)),
							F.Times(r, F.Sin(theta), F.Sin(phi)));
                    }
			} else if (ast.arg1().isList()) {
				return ((IAST) ast.arg1()).mapThread(F.ListAlloc(ast.size()), ast, 1);
            }
            return F.NIL;
        }

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_1;
		}
		@Override
		public void setUp(final ISymbol newSymbol) {
		}
    }

    /**
     * <pre>
     * HilbertMatrix(n)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * gives the hilbert matrix with <code>n</code> rows and columns.
     * </p>
     * </blockquote>
     * <p>
     * See:<br />
     * </p>
     * <ul>
     * <li><a href="http://en.wikipedia.org/wiki/Hilbert_matrix">Wikipedia - Hilbert matrix</a></li>
     * </ul>
     * <h3>Examples</h3>
	 *
     * <pre>
     * &gt;&gt; HilbertMatrix(2)
     * {{1,1/2},
     *  {1/2,1/3}}
     * </pre>
     */
    private static class HilbertMatrix extends AbstractFunctionEvaluator {

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {

            int rowSize = 0;
            int columnSize = 0;
            if (ast.isAST1() && ast.arg1().isInteger()) {
				rowSize = ast.arg1().toIntDefault(Integer.MIN_VALUE);
				if (rowSize < 0) {
					// Positive integer (less equal 2147483647) expected at position `2` in `1`.
					return IOFunctions.printMessage(F.HilbertMatrix, "intpm", F.List(ast, F.C1), engine);
				}
                columnSize = rowSize;
            } else if (ast.isAST2() && ast.arg1().isInteger() && ast.arg2().isInteger()) {
				rowSize = ast.arg1().toIntDefault(Integer.MIN_VALUE);
				if (rowSize < 0) {
					// Positive integer (less equal 2147483647) expected at position `2` in `1`.
					return IOFunctions.printMessage(F.HilbertMatrix, "intpm", F.List(ast, F.C1), engine);
				}
				columnSize = ast.arg2().toIntDefault(Integer.MIN_VALUE);
				if (columnSize < 0) {
					// Positive integer (less equal 2147483647) expected at position `2` in `1`.
					return IOFunctions.printMessage(F.HilbertMatrix, "intpm", F.List(ast, F.C2), engine);
				}
            } else {
                return F.NIL;
            }
			return F.matrix(new BiFunction<Integer, Integer, IExpr>() {
                @Override
                public IExpr apply(Integer i, Integer j) {
                    return F.QQ(1, i + j + 1);
                }
            }, rowSize, columnSize);
		}
                @Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_2;
        }
    }

    /**
     * <pre>
     * IdentityMatrix(n)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * gives the identity matrix with <code>n</code> rows and columns.
     * </p>
     * </blockquote>
     * <h3>Examples</h3>
	 *
     * <pre>
     * &gt;&gt; IdentityMatrix(3)
     * {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}
     * </pre>
     */
    private static class IdentityMatrix extends AbstractFunctionEvaluator {

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {

            if (ast.arg1().isInteger()) {
				int m = ast.arg1().toIntDefault(Integer.MIN_VALUE);
				if (m < 0) {
					// Positive integer (less equal 2147483647) expected at position `2` in `1`.
					return IOFunctions.printMessage(F.IdentityMatrix, "intpm", F.List(ast, F.C1), engine);
                    }
				return F.matrix(new BiFunction<Integer, Integer, IExpr>() {
                    @Override
                    public IExpr apply(Integer i, Integer j) {
                        return i.equals(j) ? F.C1 : F.C0;
                    }
                }, m, m);
            }
            return F.NIL;
        }

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_1;
		}
    }

    /**
     * <pre>
     * Inner(f, x, y, g)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * computes a generalised inner product of <code>x</code> and <code>y</code>, using a multiplication function
     * <code>f</code> and an addition function <code>g</code>.
     * </p>
     * </blockquote>
	 *
     * <pre>
     * &gt;&gt; Inner(f, {a, b}, {x, y}, g)
     * g(f(a, x), f(b, y))
     * </pre>
     * <p>
     * 'Inner' can be used to compute a dot product:
     * </p>
	 *
     * <pre>
     * &gt;&gt; Inner(Times, {a, b}, {c, d}, Plus) == {a, b} . {c, d}
     * </pre>
     * <p>
     * The inner product of two boolean matrices:
     * </p>
	 *
     * <pre>
     * &gt;&gt; Inner(And, {{False, False}, {False, True}}, {{True, False}, {True, True}}, Or)
     * {{False, False}, {True, True}}
     * </pre>
     */
    private static class Inner extends AbstractFunctionEvaluator {


        private static class InnerAlgorithm {
            final IExpr f;
            final IExpr g;
            final IExpr head;
            final IAST list1;
            final IAST list2;
            int list2Dim0;

            private InnerAlgorithm(final IExpr f, final IAST list1, final IAST list2, final IExpr g) {
                this.f = f;
                this.list1 = list1;
                this.list2 = list2;
                this.g = g;
                this.head = list2.head();
            }

            private IAST inner() {
                ArrayList<Integer> list1Dimensions = dimensions(list1, list1.head(), Integer.MAX_VALUE);
                ArrayList<Integer> list2Dimensions = dimensions(list2, list2.head(), Integer.MAX_VALUE);
                list2Dim0 = list2Dimensions.get(0);
                return recursion(new ArrayList<Integer>(), new ArrayList<Integer>(),
                        list1Dimensions.subList(0, list1Dimensions.size() - 1),
                        list2Dimensions.subList(1, list2Dimensions.size()));
            }

            @SuppressWarnings("unchecked")
            private IAST recursion(final ArrayList<Integer> list1Cur, final ArrayList<Integer> list2Cur,
                                   List<Integer> list1RestDimensions, List<Integer> list2RestDimensions) {
                if (list1RestDimensions.size() > 0) {
                    int size = list1RestDimensions.get(0) + 1;
                    IASTAppendable newResult = F.ast(head, size, false);
                    for (int i = 1; i < size; i++) {
                        ArrayList<Integer> list1CurClone = (ArrayList<Integer>) list1Cur.clone();
                        list1CurClone.add(i);
                        newResult.append(recursion(list1CurClone, list2Cur,
                                list1RestDimensions.subList(1, list1RestDimensions.size()), list2RestDimensions));
                    }
                    return newResult;
                } else if (list2RestDimensions.size() > 0) {
                    int size = list2RestDimensions.get(0) + 1;
                    IASTAppendable newResult = F.ast(head, size, false);
                    for (int i = 1; i < size; i++) {
                        ArrayList<Integer> list2CurClone = (ArrayList<Integer>) list2Cur.clone();
                        list2CurClone.add(i);
                        newResult.append(recursion(list1Cur, list2CurClone, list1RestDimensions,
                                list2RestDimensions.subList(1, list2RestDimensions.size())));
                    }
                    return newResult;
                } else {
                    int size = list2Dim0 + 1;
                    IASTAppendable part = F.ast(g, size, false);
                    return part.appendArgs(size, new IntFunction<IExpr>() {
                        @Override
                        public IExpr apply(int i) {
                            return InnerAlgorithm.this.summand(list1Cur, list2Cur, i);
                        }
                    });
                    // for (int i = 1; i < size; i++) {
                    // part.append(summand(list1Cur, list2Cur, i));
                    // }
                    // return part;
                }
            }

            @SuppressWarnings("unchecked")
            private IAST summand(ArrayList<Integer> list1Cur, ArrayList<Integer> list2Cur, final int i) {
                IASTAppendable result = F.ast(f, 2, false);
                ArrayList<Integer> list1CurClone = (ArrayList<Integer>) list1Cur.clone();
                list1CurClone.add(i);
                result.append(list1.getPart(list1CurClone));
                ArrayList<Integer> list2CurClone = (ArrayList<Integer>) list2Cur.clone();
                list2CurClone.add(0, i);
                result.append(list2.getPart(list2CurClone));
                return result;
            }
        }
		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {

			if (ast.arg2().isAST() && ast.arg3().isAST()) {
				IExpr f = ast.arg1();
				IAST list1 = (IAST) ast.arg2();
				IAST list2 = (IAST) ast.arg3();
				IExpr g;
				if (ast.isAST3()) {
					g = F.Plus;
				} else {
					g = ast.arg4();
				}
				IExpr head2 = list2.head();
				if (!list1.head().equals(head2)) {
					return F.NIL;
				}
				InnerAlgorithm ic = new InnerAlgorithm(f, list1, list2, g);
				return ic.inner();
			}
			return F.NIL;
		}
		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_3_4;
		}
    }

    /**
     * <pre>
     * Inverse(matrix)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * computes the inverse of the <code>matrix</code>.
     * </p>
     * </blockquote>
     * <p>
     * See:<br />
     * </p>
     * <ul>
     * <li><a href="https://en.wikipedia.org/wiki/Invertible_matrix">Wikipedia - Invertible matrix</a></li>
     * </ul>
     * <h3>Examples</h3>
	 *
     * <pre>
     * &gt;&gt; Inverse({{1, 2, 0}, {2, 3, 0}, {3, 4, 1}})
     * {{-3,2,0},
     *  {2,-1,0},
     *  {1,-2,1}}
     * </pre>
     * <p>
     * The matrix <code>{{1, 0}, {0, 0}}</code> is singular.
     * </p>
	 *
     * <pre>
	 * &gt;&gt; Inverse({{1, 0}, {0, 0}})
     * Inverse({{1, 0}, {0, 0}})
     *
     * &gt;&gt; Inverse({{1, 0, 0}, {0, Sqrt(3)/2, 1/2}, {0,-1 / 2, Sqrt(3)/2}})
     * {{1,0,0},
     *  {0,Sqrt(3)/2,-1/2},
     *  {0,1/2,1/(1/(2*Sqrt(3))+Sqrt(3)/2)}}
     * </pre>
     */
    private final static class Inverse extends AbstractMatrix1Matrix {

        public static FieldMatrix<IExpr> inverseMatrix(FieldMatrix<IExpr> matrix) {
            final FieldLUDecomposition<IExpr> lu = new FieldLUDecomposition<IExpr>(matrix);
            FieldDecompositionSolver<IExpr> solver = lu.getSolver();
            if (!solver.isNonSingular()) {
                EvalEngine.get().printMessage("Inverse: the matrix is singular.");
                return null;
            }
            return solver.getInverse();
        }

        @Override
        public FieldMatrix<IExpr> matrixEval(FieldMatrix<IExpr> matrix) {
            return inverseMatrix(matrix);
        }

        @Override
        public RealMatrix realMatrixEval(RealMatrix matrix) {
            final org.hipparchus.linear.LUDecomposition lu = new org.hipparchus.linear.LUDecomposition(matrix);
            DecompositionSolver solver = lu.getSolver();
            if (!solver.isNonSingular()) {
                EvalEngine.get().printMessage("Inverse: the matrix is singular.");
                return null;
            }
            return solver.getInverse();
        }
    }

    /**
     * <pre>
     * JacobiMatrix(matrix, var)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * creates a Jacobian matrix.
     * </p>
     * </blockquote>
     * <p>
     * See:<br />
     * </p>
     * <ul>
     * <li><a href="http://en.wikipedia.org/wiki/Jacobian">Wikipedia - Jacobian</a></li>
     * </ul>
     */
    private static class JacobiMatrix extends AbstractFunctionEvaluator {

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {

            if (ast.arg1().isVector() >= 0) {
                IAST variables = F.NIL;
                if (ast.arg2().isSymbol()) {
                    variables = F.List();
                } else if (ast.arg2().isVector() >= 0) {
                    variables = (IAST) ast.arg2();
                }
                if (variables.isPresent()) {
					final int variablesSize = variables.size();
					final IAST vector = (IAST) ast.arg1();
                    int vectorSize = vector.size();
                    IASTAppendable jacobiMatrix = F.ListAlloc(vectorSize);
                    final IAST vars = variables;
					return jacobiMatrix.appendArgs(vectorSize, new IntFunction<IExpr>() {
                        @Override
                        public IExpr apply(final int i) {
                            IASTAppendable jacobiRow = F.ListAlloc(variablesSize);
                            return jacobiRow.appendArgs(variablesSize, new IntFunction<IExpr>() {
                                @Override
                                public IExpr apply(int j) {
                                    return F.D(vector.get(i), vars.get(j));
                                }
                            });
                        }
                    });
                }
            }

            return F.NIL;
        }

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_2_2;
		}
    }

    /**
     * <pre>
     * LeastSquares(matrix, right)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * solves the linear least-squares problem 'matrix . x = right'.
     * </p>
     * </blockquote>
     * <h3>Examples</h3>
	 *
     * <pre>
     * &gt;&gt; LeastSquares(Table(Complex(i,Rational(2 * i + 2 + j, 1 + 9 * i + j)),{i,0,3},{j,0,2}), {1,1,1,1})
     * {-1577780898195/827587904419-I*11087326045520/827587904419,35583840059240/5793115330933+I*275839049310660/5793115330933,-3352155369084/827587904419-I*2832105547140/827587904419}
     * </pre>
     */
    private static class LeastSquares extends AbstractFunctionEvaluator {

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {

            if (ast.arg1().isMatrix() != null && ast.arg2().isVector() >= 0) {
                IAST matrix = (IAST) ast.arg1();
                IAST vector = (IAST) ast.arg2();
                try {
                    if (matrix.isNumericMode() || vector.isNumericMode()) {
                        RealMatrix realMatrix = ast.arg1().toRealMatrix();
                        if (realMatrix != null) {
                            RealVector realVector = ast.arg2().toRealVector();
                            if (realVector != null) {
                                // for numerical stability use: Dot(PseudoInverse(matrix), vector)
                                realMatrix = PseudoInverse.CONST.realMatrixEval(realMatrix);
                                return new ASTRealVector(realMatrix.operate(realVector), false);
                            }
                        }
                    }
                } catch (final ClassCastException e) {
                    if (Config.SHOW_STACKTRACE) {
                        e.printStackTrace();
                    }
                } catch (final IndexOutOfBoundsException e) {
                    if (Config.SHOW_STACKTRACE) {
                        e.printStackTrace();
                    }
                }
                try {
                    IAST matrixTransposed = (IAST) F.ConjugateTranspose.of(engine, matrix);
                    return F.Expand(F.LinearSolve(F.ConjugateTranspose(F.Dot(matrixTransposed, matrix)),
                            F.Dot(matrixTransposed, vector)));
                } catch (final ClassCastException e) {
                    if (Config.SHOW_STACKTRACE) {
                        e.printStackTrace();
                    }
                } catch (final IndexOutOfBoundsException e) {
                    if (Config.SHOW_STACKTRACE) {
                        e.printStackTrace();
                    }
                }
            }

            return F.NIL;
        }

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_2_2;
		}
    }

    /**
     * <pre>
     * LinearSolve(matrix, right)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * solves the linear equation system 'matrix . x = right' and returns one corresponding solution <code>x</code>.
     * </p>
     * </blockquote>
     * <h3>Examples</h3>
	 *
     * <pre>
     * &gt;&gt; LinearSolve({{1, 1, 0}, {1, 0, 1}, {0, 1, 1}}, {1, 2, 3})
     * {0,1,2}
     * </pre>
     * <p>
     * Test the solution:
     * </p>
	 *
     * <pre>
     * &gt;&gt; {{1, 1, 0}, {1, 0, 1}, {0, 1, 1}} . {0, 1, 2}
     * {1,2,3}
     * </pre>
     * <p>
     * If there are several solutions, one arbitrary solution is returned:
     * </p>
	 *
     * <pre>
     * &gt;&gt; LinearSolve({{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, {1, 1, 1})
     * {-1,1,0}
     * </pre>
     * <p>
     * Infeasible systems are reported:
     * </p>
	 *
     * <pre>
     * &gt;&gt; LinearSolve({{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, {1, -2, 3})
     *  : Linear equation encountered that has no solution.
     * LinearSolve({{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, {1, -2, 3})
     * </pre>
     * <p>
     * Argument {1, {2}} at position 1 is not a non-empty rectangular matrix.
     * </p>
	 *
     * <pre>
     * &gt;&gt; LinearSolve({1, {2}}, {1, 2})
     * LinearSolve({1, {2}}, {1, 2})
	 * &gt;&gt; LinearSolve({{1, 2}, {3, 4}}, {1, {2}})
     * LinearSolve({{1, 2}, {3, 4}}, {1, {2}})
     * </pre>
     */
    private static class LinearSolve extends AbstractFunctionEvaluator {

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {

			final int[] matrixDims = ast.arg1().isMatrix();
			if (matrixDims != null && ast.arg2().isVector() >= 0) {
                try {
					final IAST mat = (IAST) ast.arg1();
					final IAST vec = (IAST) ast.arg2();
					final FieldMatrix<IExpr> matrix = Convert.list2Matrix(mat);
					final FieldVector<IExpr> vector = Convert.list2Vector(vec);
					if (matrixDims[0] > matrixDims[1]) {
						if (vector.getDimension() == matrix.getRowDimension()
								&& vector.getDimension() <= matrix.getColumnDimension()) {
							return underdeterminedSystem(mat, vec, engine);
                    }
						return engine.printMessage("LinearSolve: first argument is not a square matrix.");
					}
					if (vector.getDimension() != matrix.getRowDimension()) {
						return engine.printMessage("LinearSolve: matrix row and vector have different dimensions.");
					}
					if (matrixDims[0] == 1 && matrixDims[1] >= 1) {
						IExpr temp = eval1x1Matrix(matrix, vector, engine);
						if (temp.isPresent()) {
							return temp;
						}
						return underdeterminedSystem(mat, vec, engine);
					}
					if (matrixDims[0] == 2 && matrixDims[1] == 2) {
						IExpr temp = eval2x2Matrix(matrix, vector, engine);
						if (temp.isPresent()) {
							return temp;
						}
						return underdeterminedSystem(mat, vec, engine);
					}
					if (matrixDims[0] == 3 && matrixDims[1] == 3) {
						IExpr temp = eval3x3Matrix(matrix, vector, engine);
						if (temp.isPresent()) {
							return temp;
						}
						return underdeterminedSystem(mat, vec, engine);
					}
					if (matrixDims[0] != matrixDims[1]) {
						return underdeterminedSystem(mat, vec, engine);
					}
					FieldDecompositionSolver<IExpr> solver = new FieldLUDecomposition<IExpr>(matrix).getSolver();
					if (solver.isNonSingular()) {
						FieldVector<IExpr> resultVector = solver.solve(vector);
						for (int i = 0; i < resultVector.getDimension(); i++) {
							if (resultVector.getEntry(i).isIndeterminate() || //
									resultVector.getEntry(i).isDirectedInfinity()) {
								return underdeterminedSystem(mat, vec, engine);
							}
						}
						return Convert.vector2List(resultVector);
					} else {
						return underdeterminedSystem(mat, vec, engine);
                    }
				} catch (LimitException le) {
					throw le;
				} catch (final RuntimeException e) {
                    if (Config.SHOW_STACKTRACE) {
                        e.printStackTrace();
                    }
                }
            }

            return F.NIL;
        }

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_2_2;
		}
		/**
		 * For a underdetermined system, return one of the possible solutions through a row reduced matrix.
		 *
		 * @param matrix
		 * @param vector
		 * @param engine
		 * @return
		 */
		private IExpr underdeterminedSystem(final IAST matrix, IAST vector, EvalEngine engine) {
			FieldMatrix<IExpr> augmentedMatrix = Convert.list2Matrix(matrix, vector);
			if (augmentedMatrix != null) {
				return LinearAlgebra.rowReduced2List(augmentedMatrix, true, engine);
			}
			return F.NIL;
		}

		/**
		 * Solve <code>matrix . vector</code> for a <code>1 x 1</code> matrix
		 *
		 * @param matrix
		 * @param vector
		 * @param engine
		 * @return
		 */
		private IExpr eval1x1Matrix(FieldMatrix<IExpr> matrix, FieldVector<IExpr> vector, EvalEngine engine) {
			IASTAppendable result = F.ListAlloc(matrix.getColumnDimension());
			IExpr a = matrix.getEntry(0, 0);
			IExpr x = vector.getEntry(0);
			// x/a
			IExpr row = F.Divide(x, a);
			result.append(row);
			if (matrix.getColumnDimension() > 1) {
				for (int i = 1; i < matrix.getColumnDimension(); i++) {
					result.append(F.C0);
				}
			}
			IExpr temp = engine.evalQuiet(result);
			if (temp.isAST()) {
				IAST ast = (IAST) temp;
				for (int k = 1; k < ast.size(); k++) {
					if (ast.get(k).isIndeterminate() || //
							ast.get(k).isDirectedInfinity()) {
						return F.NIL;
					}
				}
			}
			return temp;
		}

		/**
		 * Solve <code>matrix . vector</code> for a <code>2 x 2</code> matrix
		 *
		 * @param matrix
		 * @param vector
		 * @param engine
		 * @return
		 */
		private IExpr eval2x2Matrix(FieldMatrix<IExpr> matrix, FieldVector<IExpr> vector, EvalEngine engine) {
			IASTAppendable result = F.ListAlloc(matrix.getColumnDimension());
			IExpr a = matrix.getEntry(0, 0);
			IExpr b = matrix.getEntry(0, 1);
			IExpr c = matrix.getEntry(1, 0);
			IExpr d = matrix.getEntry(1, 1);

			IExpr x = vector.getEntry(0);
			IExpr y = vector.getEntry(1);
			// (d*x-b*y)/((-b)*c+a*d)
			IExpr row = F.Times(F.Power(F.Plus(F.Times(F.CN1, b, c), F.Times(a, d)), -1),
					F.Plus(F.Times(d, x), F.Times(F.CN1, b, y)));
			result.append(row);
			// (c*x-a*y)/(b*c-a*d)
			row = F.Times(F.Power(F.Plus(F.Times(b, c), F.Times(F.CN1, a, d)), -1),
					F.Plus(F.Times(c, x), F.Times(F.CN1, a, y)));
			result.append(row);

			if (matrix.getColumnDimension() > 2) {
				for (int i = 2; i < matrix.getColumnDimension(); i++) {
					result.append(F.C0);
				}
			}
			IExpr temp = engine.evalQuiet(result);
			if (temp.isAST()) {
				IAST ast = (IAST) temp;
				for (int k = 1; k < ast.size(); k++) {
					if (ast.get(k).isIndeterminate() || //
							ast.get(k).isDirectedInfinity()) {
						return F.NIL;
					}
				}
			}
			return temp;
		}

		/**
		 * Solve <code>matrix . vector</code> for a <code>3 x 3</code> matrix
		 *
		 * @param matrix
		 * @param vector
		 * @param engine
		 * @return
		 */
		private IExpr eval3x3Matrix(FieldMatrix<IExpr> matrix, FieldVector<IExpr> vector, EvalEngine engine) {
			IASTAppendable result = F.ListAlloc(matrix.getColumnDimension());
			IExpr a = matrix.getEntry(0, 0);
			IExpr b = matrix.getEntry(0, 1);
			IExpr c = matrix.getEntry(0, 2);
			IExpr d = matrix.getEntry(1, 0);
			IExpr e = matrix.getEntry(1, 1);
			IExpr f = matrix.getEntry(1, 2);
			IExpr g = matrix.getEntry(2, 0);
			IExpr h = matrix.getEntry(2, 1);
			IExpr i = matrix.getEntry(2, 2);

			IExpr x = vector.getEntry(0);
			IExpr y = vector.getEntry(1);
			IExpr z = vector.getEntry(2);
			// (f*h*x-e*i*x-c*h*y+b*i*y+c*e*z-b*f*z)/(c*e*g-b*f*g-c*d*h+a*f*h+b*d*i-a*e*i)
			IExpr row = F.Times(
					F.Power(F.Plus(F.Times(c, e, g), F.Times(F.CN1, b, f, g), F.Times(F.CN1, c, d, h), F.Times(a, f, h),
							F.Times(b, d, i), F.Times(F.CN1, a, e, i)), -1),
					F.Plus(F.Times(f, h, x), F.Times(F.CN1, e, i, x), F.Times(F.CN1, c, h, y), F.Times(b, i, y),
							F.Times(c, e, z), F.Times(F.CN1, b, f, z)));
			result.append(row);
			// ((-f)*g*x+d*i*x+c*g*y-a*i*y-c*d*z+a*f*z)/(c*e*g-b*f*g-c*d*h+a*f*h+b*d*i-a*e*i)
			row = F.Times(
					F.Power(F.Plus(F.Times(c, e, g), F.Times(F.CN1, b, f, g), F.Times(F.CN1, c, d, h), F.Times(a, f, h),
							F.Times(b, d, i), F.Times(F.CN1, a, e, i)), -1),
					F.Plus(F.Times(F.CN1, f, g, x), F.Times(d, i, x), F.Times(c, g, y), F.Times(F.CN1, a, i, y),
							F.Times(F.CN1, c, d, z), F.Times(a, f, z)));
			result.append(row);
			// (e*g*x-d*h*x-b*g*y+a*h*y+b*d*z-a*e*z)/(c*e*g-b*f*g-c*d*h+a*f*h+b*d*i-a*e*i)
			row = F.Times(
					F.Power(F.Plus(F.Times(c, e, g), F.Times(F.CN1, b, f, g), F.Times(F.CN1, c, d, h), F.Times(a, f, h),
							F.Times(b, d, i), F.Times(F.CN1, a, e, i)), -1),
					F.Plus(F.Times(e, g, x), F.Times(F.CN1, d, h, x), F.Times(F.CN1, b, g, y), F.Times(a, h, y),
							F.Times(b, d, z), F.Times(F.CN1, a, e, z)));
			result.append(row);

			if (matrix.getColumnDimension() > 3) {
				for (int k = 3; k < matrix.getColumnDimension(); k++) {
					result.append(F.C0);
				}
			}

			IExpr temp = engine.evalQuiet(result);
			if (temp.isAST()) {
				IAST ast = (IAST) temp;
				for (int k = 1; k < ast.size(); k++) {
					if (ast.get(k).isIndeterminate() || //
							ast.get(k).isDirectedInfinity()) {
						return F.NIL;
					}
				}
			}
			return temp;
		}
    }

    private static class LowerTriangularize extends AbstractFunctionEvaluator {

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {

            int[] dim = ast.arg1().isMatrix();
            if (dim != null) {
				final IAST matrix = (IAST) ast.arg1();
                final int k = (ast.size() == 3 && ast.arg2().isInteger())
                        ? Validate.checkIntType(ast, 2, Integer.MIN_VALUE)
                        : 0;
				return F.matrix(new BiFunction<Integer, Integer, IExpr>() {
                    @Override
                    public IExpr apply(Integer i, Integer j) {
                        return i >= j - k ? matrix.getPart(i + 1, j + 1) : F.C0;
                    }
                }, dim[0], dim[1]);
			}
			return F.NIL;
		}
                    @Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_2;
            }

    }

    /**
     * <pre>
     * LUDecomposition(matrix)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * calculate the LUP-decomposition of a square <code>matrix</code>.
     * </p>
     * </blockquote>
     * <p>
     * See:<br />
     * </p>
     * <ul>
     * <li><a href="https://en.wikipedia.org/wiki/LU_decomposition">Wikipedia - LU decomposition</a></li>
     * <li><a href=
     * "http://commons.apache.org/proper/commons-math/apidocs/org/apache/commons/math3/linear/FieldLUDecomposition.html">Commons
     * Math - Class FieldLUDecomposition</a></li>
     * </ul>
     * <h3>Examples</h3>
	 *
     * <pre>
     * &gt;&gt;&gt; LUDecomposition[{{1, 2, 3}, {3, 4, 11}, {13, 7, 8}}]
     * {{{1,0,0},
     *   {3,1,0},
     *   {13,19/2,1}},
     *  {{1,2,3},
     *   {0,-2,2},
     *   {0,0,-50}},{1,2,3}}
     * </pre>
     */
    private static class LUDecomposition extends AbstractFunctionEvaluator {

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {

            FieldMatrix<IExpr> matrix;
            boolean togetherMode = engine.isTogetherMode();
            try {
                engine.setTogetherMode(true);
                final IAST list = (IAST) ast.arg1();
                matrix = Convert.list2Matrix(list);
                if (matrix != null) {
                    final FieldLUDecomposition<IExpr> lu = new FieldLUDecomposition<IExpr>(matrix);
                    final FieldMatrix<IExpr> lMatrix = lu.getL();
                    final FieldMatrix<IExpr> uMatrix = lu.getU();
                    final int[] iArr = lu.getPivot();
                    // final int permutationCount = lu.getPermutationCount();
                    int size = iArr.length;
                    final IASTAppendable iList = F.ListAlloc(size);
                    // +1 because in Symja the offset is +1 compared to java arrays
                    iList.appendArgs(0, size, new IntFunction<IExpr>() {
                        @Override
                        public IExpr apply(int i) {
                            return F.integer(iArr[i] + 1);
                        }
                    });
                    // for (int i = 0; i < size; i++) {
                    // // +1 because in Symja the offset is +1 compared to java arrays
                    // iList.append(F.integer(iArr[i] + 1));
                    // }
                    return F.List(Convert.matrix2List(lMatrix), Convert.matrix2List(uMatrix), iList);
                }

            } catch (final ClassCastException e) {
                if (Config.SHOW_STACKTRACE) {
                    e.printStackTrace();
                }
            } catch (final IndexOutOfBoundsException e) {
                if (Config.SHOW_STACKTRACE) {
                    e.printStackTrace();
                }
            } finally {
                engine.setTogetherMode(togetherMode);
            }

            return F.NIL;
        }

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_1;
		}
    }

    /**
     * <pre>
     * ManhattanDistance(u, v)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * returns the Manhattan distance between <code>u</code> and <code>v</code>, which is the number of horizontal or
     * vertical moves in the grid like Manhattan city layout to get from <code>u</code> to <code>v</code>.
     * </p>
     * </blockquote>
     * <p>
     * See:
     * </p>
     * <ul>
     * <li><a href="https://en.wikipedia.org/wiki/Taxicab_geometry">Wikipedia - Taxicab geometry</a></li>
     * </ul>
     * <h3>Examples</h3>
	 *
     * <pre>
     * &gt;&gt; ManhattanDistance({-1, -1}, {1, 1})
     * 4
     * </pre>
     */
    private final static class ManhattanDistance extends AbstractEvaluator {

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {
            if (ast.size() != 3) {
                throw new WrongNumberOfArguments(ast, 2, ast.argSize());
            }
            IExpr arg1 = ast.arg1();
            IExpr arg2 = ast.arg2();

            int dim1 = arg1.isVector();
            if (dim1 > (-1)) {
                int dim2 = arg2.isVector();
                if (dim1 == dim2) {
                    if (dim1 == 0) {
                        return F.C0;
                    }
                    final IAST a1 = ((IAST) arg1);
                    final IAST a2 = ((IAST) arg2);
                    int size = a1.size();
                    IASTAppendable plusAST = F.PlusAlloc(size);
                    return plusAST.appendArgs(size, new IntFunction<IExpr>() {
                        @Override
                        public IExpr apply(int i) {
                            return F.Abs(F.Subtract(a1.get(i), a2.get(i)));
                        }
                    });
                    // for (int i = 1; i < size; i++) {
                    // plusAST.append(F.Abs(F.Subtract(a1.get(i), a2.get(i))));
                    // }
                    // return plusAST;
                }
            }
            return F.NIL;
        }

        @Override
        public void setUp(ISymbol newSymbol) {

        }

    }

	private static class MatrixExp extends AbstractFunctionEvaluator {
		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			if (ast.size() == 2) {
				int[] dim = ast.arg1().isMatrix();
				if (dim != null && dim[0] == dim[1]) {
					IAST matrix = (IAST) ast.arg1();
					final int n = dim[0];
				}
			}
			return F.NIL;
		}
	}

    /**
     * <pre>
     * MatrixMinimalPolynomial(matrix, var)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * computes the matrix minimal polynomial of a <code>matrix</code> for the variable <code>var</code>.
     * </p>
     * </blockquote>
     * <p>
     * See:<br />
     * </p>
     * <ul>
     * <li><a href= "https://en.wikipedia.org/wiki/Minimal_polynomial_(linear_algebra)">Wikipedia - Minimal polynomial
     * (linear algebra)</a></li>
     * </ul>
     * <h3>Examples</h3>
	 *
     * <pre>
     * &gt;&gt; MatrixMinimalPolynomial({{1, -1, -1}, {1, -2, 1}, {0, 1, -3}}, x)
     * -1+x+4*x^2+x^3
     * </pre>
     */
    private static class MatrixMinimalPolynomial extends AbstractFunctionEvaluator {

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {
            int[] dimensions = ast.arg1().isMatrix();
            if (dimensions != null && dimensions[0] == dimensions[1] && dimensions[0] > 0) {
                // a matrix with square dimensions
                IAST matrix = (IAST) ast.arg1();
                IExpr variable = ast.arg2();
                ISymbol i = new Symbol("§i", Context.SYSTEM);
                int n = 1;
                IAST qu = F.List();
                IAST mnm = (IAST) engine
                        .evaluate(F.List(F.Flatten(diagonalMatrix(new IExpr[]{F.C0, F.C1}, dimensions[0]))));
                if (!(mnm instanceof IASTAppendable)) {
                    mnm = mnm.copyAppendable();
                }
                while (qu.size() == 1) {
                    ((IASTAppendable) mnm).append(engine.evaluate(F.Flatten(F.MatrixPower(matrix, F.integer(n)))));
                    qu = (IAST) F.NullSpace.of(engine, F.Transpose(mnm));
                    n++;
                }
                return F.Dot.of(engine, qu.arg1(), F.Table(F.Power(variable, i), F.List(i, F.C0, F.integer(--n))));
            }

            return F.NIL;
        }

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_2_2;
		}
    }

    /**
     * <pre>
     * MatrixPower(matrix, n)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * computes the <code>n</code>th power of a <code>matrix</code>
     * </p>
     * </blockquote>
     * <h3>Examples</h3>
	 *
     * <pre>
     * &gt;&gt; MatrixPower({{1, 2}, {1, 1}}, 10)
     * {{3363,4756},
     *  {2378,3363}}
     *
     * &gt;&gt; MatrixPower({{1, 2}, {2, 5}}, -3)
     * {{169,-70},
     *  {-70,29}}
     * </pre>
     * <p>
     * Argument {{1, 0}, {0}} at position 1 is not a non-empty rectangular matrix.
     * </p>
	 *
     * <pre>
     * &gt;&gt; MatrixPower({{1, 0}, {0}}, 2)
     * MatrixPower({{1, 0}, {0}}, 2)
     * </pre>
     */

    private final static class MatrixPower extends AbstractFunctionEvaluator {

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {

            FieldMatrix<IExpr> matrix;
            FieldMatrix<IExpr> resultMatrix;
            boolean togetherMode = engine.isTogetherMode();
            try {
                engine.setTogetherMode(true);
                matrix = Convert.list2Matrix((IAST) ast.arg1());
                if (matrix == null) {
                    return F.NIL;
                }
				int p = ast.arg2().toIntDefault(Integer.MIN_VALUE);
				if (p == Integer.MIN_VALUE) {
					return F.NIL;
				}
                if (p == 1) {
                    ((IAST) ast.arg1()).addEvalFlags(IAST.IS_MATRIX);
                    return ast.arg1();
                }
                if (p == 0) {
                    resultMatrix = new BlockFieldMatrix<IExpr>(ExprField.CONST, matrix.getRowDimension(),
                            matrix.getColumnDimension());
                    int min = matrix.getRowDimension();
                    if (min > matrix.getColumnDimension()) {
                        min = matrix.getColumnDimension();
                    }
                    for (int i = 0; i < min; i++) {
                        resultMatrix.setEntry(i, i, F.C1);
                    }

                    return Convert.matrix2List(resultMatrix);
                }
                if (p < 0) {
                    resultMatrix = Inverse.inverseMatrix(matrix);
                    matrix = resultMatrix;
                    p *= (-1);
                } else {
                    resultMatrix = matrix;
                }
                for (int i = 1; i < p; i++) {
                    resultMatrix = resultMatrix.multiply(matrix);
                }
                return Convert.matrix2List(resultMatrix);

				// } catch (final ClassCastException e) {
				// if (Config.SHOW_STACKTRACE) {
				// e.printStackTrace();
				// }
				// } catch (final ArithmeticException e) {
				// if (Config.SHOW_STACKTRACE) {
				// e.printStackTrace();
				// }
				// throw new NonNegativeIntegerExpected(ast, 2);
				// } catch (final IndexOutOfBoundsException e) {
				// if (Config.SHOW_STACKTRACE) {
				// e.printStackTrace();
				// }
			} catch (final RuntimeException e) {
                if (Config.SHOW_STACKTRACE) {
                    e.printStackTrace();
                }
				return engine.printMessage(ast.topHead() + ": " + e.getMessage());
            } finally {
                engine.setTogetherMode(togetherMode);
            }
        }
		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_2_2;
		}
    }

    /**
     * <pre>
     * MatrixRank(matrix)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * returns the rank of <code>matrix</code>.
     * </p>
     * </blockquote>
     * <p>
     * See:
     * </p>
     * <ul>
     * <li><a href= "https://en.wikipedia.org/wiki/Rank_%28linear_algebra%29">Wikipedia - Rank (linear algebra</a></li>
     * </ul>
     * <h3>Examples</h3>
	 *
     * <pre>
     * &gt;&gt; MatrixRank({{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})
     * 2
     * &gt;&gt; MatrixRank({{1, 1, 0}, {1, 0, 1}, {0, 1, 1}})
     * 3
     * &gt;&gt; MatrixRank({{a, b}, {3 a, 3 b}})
     * 1
     * </pre>
     * <p>
     * Argument <code>{{1, 0}, {0}}</code> at position <code>1</code> is not a non-empty rectangular matrix.
     * </p>
	 *
     * <pre>
     * &gt;&gt; MatrixRank({{1, 0}, {0}})
     * MatrixRank({{1, 0}, {0}})
     * </pre>
     */
    private final static class MatrixRank extends AbstractFunctionEvaluator {

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {
            FieldMatrix<IExpr> matrix;
            try {

                IExpr arg1 = engine.evaluate(ast.arg1());
                if (arg1.isMatrix() != null) {
                    final IAST astMatrix = (IAST) arg1;
                    matrix = Convert.list2Matrix(astMatrix);
                    if (matrix != null) {
                        FieldReducedRowEchelonForm fmw = new FieldReducedRowEchelonForm(matrix);
                        return F.integer(fmw.getMatrixRank());
                    }
                }

            } catch (final ClassCastException e) {
                if (Config.SHOW_STACKTRACE) {
                    e.printStackTrace();
                }
            } catch (final IndexOutOfBoundsException e) {
                if (Config.SHOW_STACKTRACE) {
                    e.printStackTrace();
                }
            }

            return F.NIL;
        }

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_1;
		}
        @Override
        public void setUp(final ISymbol newSymbol) {
            newSymbol.setAttributes(ISymbol.HOLDALL);
        }
    }

    /**
     * <pre>
     * Norm(m, l)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * computes the <code>l</code>-norm of matrix <code>m</code> (currently only works for vectors!).<br />
     * </p>
     * </blockquote>
	 *
     * <pre>
     * Norm(m)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * computes the 2-norm of matrix <code>m</code> (currently only works for vectors!).<br />
     * </p>
     * </blockquote>
     * <h3>Examples</h3>
	 *
     * <pre>
	 * &gt;&gt; Norm({1, 2, 3, 4}, 2)
	 * Sqrt(30)
     *
	 * &gt;&gt; Norm({10, 100, 200}, 1)
	 * 310
     *
     * &gt;&gt; Norm({a, b, c})
	 * Sqrt(Abs(a)^2+Abs(b)^2+Abs(c)^2)
     *
	 * &gt;&gt; Norm({-100, 2, 3, 4}, Infinity)
	 * 100
     *
	 * &gt;&gt; Norm(1 + I)
     * Sqrt(2)
     * </pre>
     * <p>
     * The first Norm argument should be a number, vector, or matrix.<br />
     * </p>
	 *
     * <pre>
	 * &gt;&gt; Norm({1, {2, 3}})
	 * Norm({1, {2, 3}})
     *
	 * &gt;&gt; Norm({x, y})
	 * Sqrt(Abs(x)^2+Abs(y)^2)
     *
	 * &gt;&gt; Norm({x, y}, p)
     * (Abs(x) ^ p + Abs(y) ^ p) ^ (1 / p)
     * </pre>
     * <p>
     * The second argument of Norm, 0, should be a symbol, Infinity, or an integer or real number not less than 1 for
     * vector p-norms; or 1, 2, Infinity, or &ldquo;Frobenius&rdquo; for matrix norms.<br />
     * </p>
	 *
     * <pre>
	 * &gt;&gt; Norm({x, y}, 0)
     * Norm({x, y}, 0)
     * </pre>
     * <p>
     * The second argument of Norm, 0.5, should be a symbol, Infinity, or an integer or real number not less than 1 for
     * vector p-norms; or 1, 2, Infinity, or &ldquo;Frobenius&rdquo; for matrix norms.
     * </p>
	 *
     * <pre>
	 * &gt;&gt; Norm({x, y}, 0.5)
     * Norm({x, y}, 0.5)
     *
	 * &gt;&gt; Norm({})
     * Norm({})
     *
	 * &gt;&gt; Norm(0)
     * 0
     * </pre>
     */
    private final static class Norm extends AbstractEvaluator {

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {

            IExpr arg1 = ast.arg1();
            int dim = arg1.isVector();
            if (dim > (-1)) {
                if (dim == 0) {
                    return F.NIL;
                }
                IAST vector = (IAST) arg1;
                if (ast.isAST2()) {
                    final IExpr p = ast.arg2();
                    if (p.isInfinity()) {
                        return vector.map(F.Max, new Function<IExpr, IExpr>() {
                            @Override
                            public IExpr apply(IExpr x) {
                                return F.Abs(x);
                            }
                        });
                    } else {
                        if (p.isSymbol() || p.isReal()) {
                            if (p.isZero()) {
                                engine.printMessage("Norm: 0 not allowed as second argument!");
                                return F.NIL;
                            }
                            if (p.isReal() && p.lessThan(F.C1).isTrue()) {
                                engine.printMessage("Norm: Second argument is < 1!");
                                return F.NIL;
                            }
                            return F.Power(vector.map(F.Plus, new Function<IExpr, IExpr>() {
                                @Override
                                public IExpr apply(IExpr x) {
                                    return F.Power(F.Abs(x), p);
                                }
                            }), p.inverse());
                        }
                    }
                    return F.NIL;
                }
                return F.Sqrt(vector.map(F.Plus, new Function<IExpr, IExpr>() {
                    @Override
                    public IExpr apply(IExpr x) {
                        return F.Sqr(F.Abs(x));
                    }
                }));
            }
            if (arg1.isNumber()) {
                if (ast.isAST2()) {
                    return F.NIL;
                }
                // absolute Value of a number
                return ((INumber) arg1).abs();
            }
			if (arg1.isNumericFunction()&&!arg1.isList()) {
                if (ast.isAST2()) {
                    return F.NIL;
                }
                // absolute Value
                return F.Abs(arg1);
            }
            return F.NIL;
        }

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_2;
		}
    }

    /**
     * <pre>
     * Normalize(v)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * calculates the normalized vector <code>v</code>.
     * </p>
     * </blockquote>
	 *
     * <pre>
     * Normalize(z)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * calculates the normalized complex number <code>z</code>.
     * </p>
     * </blockquote>
     * <h3>Examples</h3>
	 *
     * <pre>
     * &gt;&gt; Normalize({1, 1, 1, 1})
     * {1/2,1/2,1/2,1/2}
     *
     * &gt;&gt; Normalize(1 + I)
	 * (1+I)/Sqrt(2)
     *
     * &gt;&gt; Normalize(0)
     * 0
     *
     * &gt;&gt; Normalize({0})
     * {0}
     *
     * &gt;&gt; Normalize({})
     * {}
     * </pre>
     */
    private final static class Normalize extends AbstractEvaluator {

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {

            IExpr normFunction = F.Norm;
            if (ast.isAST2()) {
                normFunction = ast.arg2();
            }
            IExpr arg1 = ast.arg1();
            if (arg1.isAST(F.List, 1) && ast.isAST1()) {
                return arg1;
            }
            IExpr norm = engine.evaluate(F.unaryAST1(normFunction, ast.arg1()));
            if (norm.isZero()) {
                return arg1;
            }
            return F.Divide(ast.arg1(), norm);
        }

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_2;
		}
    }

    /**
     * <pre>
     * NullSpace(matrix)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * returns a list of vectors that span the nullspace of the <code>matrix</code>.
     * </p>
     * </blockquote>
     * <p>
     * See:<br />
     * </p>
     * <ul>
     * <li><a href= "http://en.wikipedia.org/wiki/Kernel_%28linear_algebra%29">Wikipedia - Kernel (linear
     * algebra)</a></li>
     * </ul>
     * <h3>Examples</h3>
	 *
     * <pre>
     * &gt;&gt; NullSpace({{1,0,-3,0,2,-8},{0,1,5,0,-1,4},{0,0,0,1,7,-9},{0,0,0,0,0,0}})
     * {{3,-5,1,0,0,0},
     *  {-2,1,0,-7,1,0},
     *  {8,-4,0,9,0,1}}
     * </pre>
	 *
     * <pre>
	 * ```
	 * &gt;&gt; NullSpace({{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})
     * {{1,-2,1}}
     *
	 * &gt;&gt; A = {{1, 1, 0}, {1, 0, 1}, {0, 1, 1}}
	 * &gt;&gt; NullSpace(A)
	 * {}
     *
	 * &gt;&gt; MatrixRank(A)
     * 3
     * </pre>
     * <p>
     * Argument {1, {2}} at position 1 is not a non-empty rectangular matrix.<br />
     * </p>
	 *
     * <pre>
	 * &gt;&gt; NullSpace({1, {2}})
     * NullSpace({1, {2}})
     * </pre>
     */
    private static class NullSpace extends AbstractFunctionEvaluator {

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {
            FieldMatrix<IExpr> matrix;
            boolean togetherMode = engine.isTogetherMode();
            try {
                engine.setTogetherMode(true);

                final IAST list = (IAST) ast.arg1();
                matrix = Convert.list2Matrix(list);
                if (matrix != null) {
                    FieldReducedRowEchelonForm fmw = new FieldReducedRowEchelonForm(matrix);
                    FieldMatrix<IExpr> nullspace = fmw.getNullSpace(F.CN1);
                    if (nullspace == null) {
                        return F.List();
                    }

                    IASTMutable list2 = Convert.matrix2List(nullspace);
                    // rows in descending orders
                    EvalAttributes.sort(list2, ExprReverseComparator.CONS);
                    return list2;
                }
            } catch (final ClassCastException e) {
                if (Config.SHOW_STACKTRACE) {
                    e.printStackTrace();
                }
            } catch (final IndexOutOfBoundsException e) {
                if (Config.SHOW_STACKTRACE) {
                    e.printStackTrace();
                }
            } finally {
                engine.setTogetherMode(togetherMode);
            }

            return F.NIL;
        }

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_1;
		}
    }

    private static class Orthogonalize extends AbstractEvaluator {

        static IBuiltInSymbol oneStep = F.localBiFunction("oneStep", new BiFunction<IExpr, IExpr, IExpr>() {
            @Override
            public IExpr apply(IExpr vec, IExpr vecmat) {
                if (vecmat.equals(F.List())) {
                    return vec;
                }
                IExpr function = // [$ (#1-(vec.#2)/(#2.#2)*#2)& $]
					F.Function(F.Plus(F.Slot1,
							F.Times(F.CN1, F.Dot(vec, F.Slot2), F.Power(F.Dot(F.Slot2, F.Slot2), F.CN1), F.Slot2))); // $$;
                return F.eval(F.Fold(function, vec, vecmat));
            }
        });
        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {
            IExpr arg1 = ast.arg1();
            int[] dim = arg1.isMatrix();
            if (dim != null) {
                // Gram-Schmidt orthogonalization
                IExpr result = F.Map(F.Function(F.Normalize(F.Slot1)), //
						F.Fold(F.Function(F.Append(F.Slot1, F.binaryAST2(oneStep, F.Slot2, F.Slot1))), F.List(), arg1));
                return engine.evaluate(result);
            }
            return F.NIL;
        }

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_2;
		}
        @Override
        public void setUp(final ISymbol newSymbol) {
        }

    }

    /**
     * <pre>
     * Projection(vector1, vector2)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * Find the orthogonal projection of <code>vector1</code> onto another <code>vector2</code>.
     * </p>
     * </blockquote>
	 *
     * <pre>
     * Projection(vector1, vector2, ipf)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * Find the orthogonal projection of <code>vector1</code> onto another <code>vector2</code> using the inner product
     * function <code>ipf</code>.
     * </p>
     * </blockquote>
     * <h3>Examples</h3>
	 *
     * <pre>
     * &gt;&gt; Projection({5, I, 7}, {1, 1, 1})
     * {4+I*1/3,4+I*1/3,4+I*1/3}
     * </pre>
     */
    private static class Projection extends AbstractEvaluator {

        /**
         * Create a binary function &quot"dot product&quot; <code>head(u,v)</code> and evaluate it.
         *
		 * @param head
		 *            the header of the binary function
		 * @param u
		 *            the first argument of the function
		 * @param v
		 *            the second argument of the function
		 * @param engine
		 *            the evaluation engine
         * @return the evaluated <code>head(u,v)</code> AST.
         */
        private static IExpr dotProduct(IExpr head, IExpr u, IExpr v, EvalEngine engine) {
            return engine.evaluate(F.binaryAST2(head, u, v));
        }

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {
            int dim1 = ast.arg1().isVector();
            int dim2 = ast.arg2().isVector();
            if (ast.size() == 4) {
                IExpr head = ast.arg3();
                if (head.equals(F.Dot)) {
                    if (dim1 >= 0 && dim1 == dim2) {
                        FieldVector<IExpr> u = Convert.list2Vector((IAST) ast.arg1());
                        FieldVector<IExpr> v = Convert.list2Vector((IAST) ast.arg2());
                        return Convert.vector2List(u.projection(v));
                    }
                }
                IExpr u = ast.arg1();
                IExpr v = ast.arg2();
                return v.times(dotProduct(head, u, v, engine).divide(dotProduct(head, v, v, engine)));
            }
            if (dim1 >= 0 && dim1 == dim2) {
                FieldVector<IExpr> u = Convert.list2Vector((IAST) ast.arg1());
                FieldVector<IExpr> v = Convert.list2Vector((IAST) ast.arg2());
                FieldVector<IExpr> vConjugate = v.copy();
                for (int i = 0; i < dim2; i++) {
                    vConjugate.setEntry(i, vConjugate.getEntry(i).conjugate());
                }

                return Convert.vector2List(v.mapMultiply(u.dotProduct(vConjugate).divide(v.dotProduct(vConjugate))));
            }
            return F.NIL;
        }

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_2_3;
		}
        @Override
        public void setUp(final ISymbol newSymbol) {
        }

    }

    /**
     * <pre>
     * PseudoInverse(matrix)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * computes the Moore-Penrose pseudoinverse of the <code>matrix</code>. If <code>matrix</code> is invertible, the
     * pseudoinverse equals the inverse.
     * </p>
     * </blockquote>
     * <p>
     * See:
     * </p>
     * <ul>
     * <li><a href= "https://en.wikipedia.org/wiki/Moore%E2%80%93Penrose_pseudoinverse">Wikipedia: Moore-Penrose
     * pseudoinverse</a></li>
     * </ul>
     * <h3>Examples</h3>
	 *
     * <pre>
     * &gt;&gt; PseudoInverse({{1, 2}, {2, 3}, {3, 4}})
     * {{1.0000000000000002,2.000000000000001},
     *  {1.9999999999999976,2.999999999999996},
     *  {3.000000000000001,4.0}}
     * &gt;&gt; PseudoInverse({{1, 2, 0}, {2, 3, 0}, {3, 4, 1}})
     * {{-2.999999999999998,1.9999999999999967,4.440892098500626E-16},
     *  {1.999999999999999,-0.9999999999999982,-2.7755575615628914E-16},
     *  {0.9999999999999999,-1.9999999999999991,1.0}}
	 * &gt;&gt; PseudoInverse({{1.0, 2.5}, {2.5, 1.0}})
     * {{-0.19047619047619038,0.47619047619047616},
     *  {0.47619047619047616,-0.1904761904761904}}
     * </pre>
     * <p>
     * Argument {1, {2}} at position 1 is not a non-empty rectangular matrix.
     * </p>
	 *
     * <pre>
     * &gt;&gt; PseudoInverse({1, {2}})
     * PseudoInverse({1, {2}})
     * </pre>
     */
    private final static class PseudoInverse extends AbstractMatrix1Matrix {
        protected final static PseudoInverse CONST = new PseudoInverse();

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {
            return numericEval(ast, engine);
        }

        @Override
        public FieldMatrix<IExpr> matrixEval(FieldMatrix<IExpr> matrix) {
            return null;
        }

        @Override
        public RealMatrix realMatrixEval(RealMatrix matrix) {
            final org.hipparchus.linear.SingularValueDecomposition lu = new org.hipparchus.linear.SingularValueDecomposition(
                    matrix);
            DecompositionSolver solver = lu.getSolver();
            return solver.getInverse();
        }
    }

    /**
     * <pre>
     * QRDecomposition(matrix)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * computes the QR decomposition of the <code>matrix</code>.
     * </p>
     * </blockquote>
     * <h3>Examples</h3>
	 *
     * <pre>
     * &gt;&gt; QRDecomposition({{1, 2}, {3, 4}, {5, 6}})
     * {
     * {{-0.16903085094570325,0.8970852271450604,0.4082482904638636},
     *  {-0.50709255283711,0.2760262237369421,-0.8164965809277258},
     *  {-0.8451542547285165,-0.3450327796711773,0.40824829046386274}},
     * {{-5.916079783099616,-7.437357441610944},
     *  {0.0,0.828078671210824},
     *  {0.0,0.0}}}
     * </pre>
     */
    private static class QRDecomposition extends AbstractMatrix1Expr {

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {
            // FieldMatrix<IExpr> matrix;
            try {

                int[] dim = ast.arg1().isMatrix();
                if (dim != null) {
                    // if (dim[0] == 1 && dim[1] == 1) {
                    // }

                    // if (dim[0] == 2 && dim[1] == 2) {
                    // matrix = Convert.list2Matrix((IAST) ast.arg1());
                    // if (matrix != null) {
                    // }
                    // }

                }

            } catch (final ClassCastException e) {
                if (Config.SHOW_STACKTRACE) {
                    e.printStackTrace();
                }
            } catch (final IndexOutOfBoundsException e) {
                if (Config.SHOW_STACKTRACE) {
                    e.printStackTrace();
                }
            }

            // switch to numeric calculation
            return numericEval(ast, engine);
        }

        @Override
        public IExpr matrixEval(FieldMatrix<IExpr> matrix) {
            return F.NIL;
        }

        @Override
        public IAST realMatrixEval(RealMatrix matrix) {
            try {
                org.hipparchus.linear.QRDecomposition ed = new org.hipparchus.linear.QRDecomposition(matrix);
                return F.List(Convert.realMatrix2List(ed.getQ()), Convert.realMatrix2List(ed.getR()));
            } catch (Exception ime) {
                throw new WrappedException(ime);
            }
        }
    }

    /**
     * <pre>
     * RowReduce(matrix)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * returns the reduced row-echelon form of <code>matrix</code>.
     * </p>
     * </blockquote>
     * <p>
     * See:<br />
     * </p>
     * <ul>
     * <li><a href="http://en.wikipedia.org/wiki/Row_echelon_form">Wikipedia - Row echelon form</a></li>
     * </ul>
     * <h3>Examples</h3>
	 *
     * <pre>
     * &gt;&gt; RowReduce({{1,1,0,1,5},{1,0,0,2,2},{0,0,1,4,-1},{0,0,0,0,0}})
	 * {{1,0,0,2,2},
     *  {0,1,0,-1,3},
     *  {0,0,1,4,-1},
     *  {0,0,0,0,0}}
     *
	 * &gt;&gt; RowReduce({{1, 0, a}, {1, 1, b}})
     * {{1,0,a},
     *  {0,1,-a+b}}
     *
     * &gt;&gt; RowReduce({{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})
     * {{1,0,-1},
     *  {0,1,2},
     *  {0,0,0}}
     * </pre>
     * <p>
     * Argument {{1, 0}, {0}} at position 1 is not a non-empty rectangular matrix.<br />
     * </p>
	 *
     * <pre>
	 * &gt;&gt; RowReduce({{1, 0}, {0}})
     * RowReduce({{1, 0}, {0}})
     * </pre>
     */
    private static class RowReduce extends AbstractFunctionEvaluator {

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {
            FieldMatrix<IExpr> matrix;
            boolean togetherMode = engine.isTogetherMode();
            try {
                engine.setTogetherMode(true);

                final IAST list = (IAST) ast.arg1();
                matrix = Convert.list2Matrix(list);
                if (matrix != null) {
                    FieldReducedRowEchelonForm fmw = new FieldReducedRowEchelonForm(matrix);
                    return Convert.matrix2List(fmw.getRowReducedMatrix());
                }

            } catch (final ClassCastException e) {
                if (Config.SHOW_STACKTRACE) {
                    e.printStackTrace();
                }
            } catch (final IndexOutOfBoundsException e) {
                if (Config.SHOW_STACKTRACE) {
                    e.printStackTrace();
                }
            } finally {
                engine.setTogetherMode(togetherMode);
            }

            return F.NIL;
        }

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_1;
		}
    }

    /**
     * <pre>
     * SingularValueDecomposition(matrix)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * calculates the singular value decomposition for the <code>matrix</code>.
     * </p>
     * </blockquote>
     * <p>
     * 'SingularValueDecomposition' returns <code>u</code>, <code>s</code>, <code>w</code> such that
     * <code>matrix =u s v</code>, <code>u' u</code>=1, <code>v' v</code>=1, and <code>s</code> is diagonal.
     * </p>
     * <p>
     * See:
     * </p>
     * <ul>
     * <li><a href= "https://en.wikipedia.org/wiki/Singular_value_decomposition">Wikipedia: Singular value
     * decomposition</a></li>
     * </ul>
     * <h3>Examples</h3>
	 *
     * <pre>
	 * &gt;&gt; SingularValueDecomposition({{1.5, 2.0}, {2.5, 3.0}})
     * {
     * {{0.5389535334972082,0.8423354965397538},
     *  {0.8423354965397537,-0.5389535334972083}},
     * {{4.635554529660638,0.0},
     *  {0.0,0.10786196059193007}},
     * {{0.6286775450376476,-0.7776660879615599},
     *  {0.7776660879615599,0.6286775450376476}}}
     * </pre>
     * <p>
     * Symbolic SVD is not implemented, performing numerically.
     * </p>
	 *
     * <pre>
	 * &gt;&gt; SingularValueDecomposition({{3/2, 2}, {5/2, 3}})
     * {
     * {{0.5389535334972082,0.8423354965397538},
     *  {0.8423354965397537,-0.5389535334972083}},
     * {{4.635554529660638,0.0},
     *  {0.0,0.10786196059193007}},
     * {{0.6286775450376476,-0.7776660879615599},
     *  {0.7776660879615599,0.6286775450376476}}}
     * </pre>
     * <p>
     * Argument {1, {2}} at position 1 is not a non-empty rectangular matrix.
     * </p>
	 *
     * <pre>
     * &gt;&gt; SingularValueDecomposition({1, {2}})
     * SingularValueDecomposition({1, {2}})
     * </pre>
     */
    private final static class SingularValueDecomposition extends AbstractFunctionEvaluator {

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {

            RealMatrix matrix;
            try {

                matrix = ast.arg1().toRealMatrix();
                if (matrix != null) {
                    final org.hipparchus.linear.SingularValueDecomposition svd = new org.hipparchus.linear.SingularValueDecomposition(
                            matrix);
                    return F.List(new ASTRealMatrix(svd.getU(), false), new ASTRealMatrix(svd.getS(), false),
                            new ASTRealMatrix(svd.getV(), false));
                }

            } catch (final WrongArgumentType e) {
                // WrongArgumentType occurs in list2RealMatrix(),
                // if the matrix elements aren't pure numerical values
                if (Config.SHOW_STACKTRACE) {
                    e.printStackTrace();
                }
            } catch (final IndexOutOfBoundsException e) {
                if (Config.SHOW_STACKTRACE) {
                    e.printStackTrace();
                }
            }

            return F.NIL;
        }

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_1;
		}
    }

    /**
     * <pre>
     * SquaredEuclideanDistance(u, v)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * returns squared the euclidean distance between <code>u$</code> and <code>v</code>.
     * </p>
     * </blockquote>
     * <h3>Examples</h3>
	 *
     * <pre>
     * &gt;&gt; SquaredEuclideanDistance({-1, -1}, {1, 1})
     * 8
     * </pre>
     */
    private final static class SquaredEuclideanDistance extends AbstractEvaluator {

        @Override
        public IExpr evaluate(final IAST functionList, EvalEngine engine) {
            if (functionList.size() != 3) {
                throw new WrongNumberOfArguments(functionList, 2, functionList.argSize());
            }
            IExpr arg1 = functionList.arg1();
            IExpr arg2 = functionList.arg2();

            int dim1 = arg1.isVector();
            if (dim1 > (-1)) {
                int dim2 = arg2.isVector();
                if (dim1 == dim2) {
                    if (dim1 == 0) {
                        return F.C0;
                    }
					final IAST a1 = ((IAST) arg1);
					final IAST a2 = ((IAST) arg2);
                    int size = a1.size();
                    IASTAppendable plusAST = F.PlusAlloc(size);

					return plusAST.appendArgs(size, new IntFunction<IExpr>() {
                        @Override
                        public IExpr apply(int i) {
                            return F.Sqr(F.Abs(F.Subtract(a1.get(i), a2.get(i))));
                        }
                    });
                    // for (int i = 1; i < size; i++) {
                    // plusAST.append(F.Sqr(F.Abs(F.Subtract(a1.get(i), a2.get(i)))));
                    // }
                    // return plusAST;
                }
            }
            return F.NIL;
        }

    }

    private static class ToeplitzMatrix extends AbstractFunctionEvaluator {

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {
			if (ast.isAST2()) {
				if (ast.arg1().isList() && ast.arg2().isList()) {
					final IAST vector1 = (IAST) ast.arg1();
					final IAST vector2 = (IAST) ast.arg2();
					int numberOfRows = vector1.argSize();
					int numberOfColumns = vector2.argSize();
					return F.matrix(new BiFunction<Integer, Integer, IExpr>() {
                        @Override
                        public IExpr apply(Integer i, Integer j) {
                            return i <= j ? vector2.get(j - i + 1) : vector1.get(i - j + 1);
                        }
                    }, numberOfRows, numberOfColumns);

				}

				return F.NIL;
			}
			if (ast.arg1().isList()) {
				final IAST vector = (IAST) ast.arg1();
                int m = vector.argSize();
				return F.matrix(new BiFunction<Integer, Integer, IExpr>() {
                    @Override
                    public IExpr apply(Integer i, Integer j) {
                        return i <= j ? vector.get(j - i + 1) : vector.get(i - j + 1);
                    }
                }, m, m);
            }

            if (ast.arg1().isInteger()) {
				int m = ast.arg1().toIntDefault(Integer.MIN_VALUE);
				if (m < 0) {
					// Positive integer (less equal 2147483647) expected at position `2` in `1`.
					return IOFunctions.printMessage(F.ToeplitzMatrix, "intpm", F.List(ast, F.C1), engine);
				}
                int[] count = new int[1];
                count[0] = 1;
				return F.matrix(new BiFunction<Integer, Integer, IExpr>() {
                    @Override
                    public IExpr apply(Integer i, Integer j) {
                        return i <= j ? F.ZZ(j - i + 1) : F.ZZ(i - j + 1);
                    }
                }, m, m);
			}
			return F.NIL;
		}

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_2;
		}
	}

	/**
	 * <pre>
	 * ToPolarCoordinates({x, y})
	 * </pre>
	 *
	 * <blockquote>
	 * <p>
	 * return the polar coordinates for the cartesian coordinates <code>{x, y}</code>.
	 * </p>
	 * </blockquote>
	 *
	 * <pre>
	 * ToPolarCoordinates({x, y, z})
	 * </pre>
	 *
	 * <blockquote>
	 * <p>
	 * return the polar coordinates for the cartesian coordinates <code>{x, y, z}</code>.
	 * </p>
	 * </blockquote>
	 * <h3>Examples</h3>
	 *
	 * <pre>
	 * &gt;&gt; ToPolarCoordinates({x, y})
	 * {Sqrt(x^2+y^2),ArcTan(x,y)}
	 *
	 * &gt;&gt; ToPolarCoordinates({x, y, z})
	 * {Sqrt(x^2+y^2+z^2),ArcCos(x/Sqrt(x^2+y^2+z^2)),ArcTan(y,z)}
	 * </pre>
	 */
	private final static class ToPolarCoordinates extends AbstractEvaluator {
                    @Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			int dim = ast.arg1().isVector();
			if (dim > 0) {
				IAST list = (IAST) ast.arg1();
				if (dim == 2) {
					IExpr x = list.arg1();
					IExpr y = list.arg2();
					return F.List(F.Sqrt(F.Plus(F.Sqr(x), F.Sqr(y))), F.ArcTan(x, y));
				} else if (dim == 3) {
					IExpr x = list.arg1();
					IExpr y = list.arg2();
					IExpr z = list.arg3();
					IAST sqrtExpr = F.Sqrt(F.Plus(F.Sqr(x), F.Sqr(y), F.Sqr(z)));
					return F.List(sqrtExpr, F.ArcCos(F.Divide(x, sqrtExpr)), F.ArcTan(y, z));
                    }
			} else if (ast.arg1().isList()) {
				IAST list = (IAST) ast.arg1();
				return list.mapThread(F.ListAlloc(list.size()), ast, 1);
			}
			return F.NIL;
		}
                    @Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_1;
            }

		@Override
		public void setUp(final ISymbol newSymbol) {
		}
    }

    /**
     * <pre>
     * Tr(matrix)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * computes the trace of the <code>matrix</code>.
     * </p>
     * </blockquote>
     * <p>
     * See:<br />
     * </p>
     * <ul>
     * <li><a href="http://en.wikipedia.org/wiki/Trace_matrix">Wikipedia - Trace (linear algebra)</a><br />
     * </li>
     * </ul>
     * <h3>Examples</h3>
	 *
     * <pre>
     * &gt;&gt; Tr({{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})
     * 15
     * </pre>
     * <p>
     * Symbolic trace:
     * </p>
	 *
     * <pre>
     * &gt;&gt; Tr({{a, b, c}, {d, e, f}, {g, h, i}})
     * a+e+i
     * </pre>
     */
    private static class Tr extends AbstractEvaluator {

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {

            // TODO generalize for tensors
            IExpr arg1 = ast.arg1();
            IExpr header = F.Plus;
            if (ast.size() > 2) {
                header = ast.arg2();
            }

            final int[] dim = arg1.isMatrix();
            if (dim != null) {
                final IAST mat = (IAST) arg1;
                int len = dim[0] < dim[1] ? dim[0] : dim[1];
				final IASTAppendable tr = F.ast(header, len, true);
				mat.forEach(1, len + 1, new ObjIntConsumer<IExpr>() {
                    @Override
                    public void accept(IExpr x, int i) {
                        tr.set(i, ((IAST) x).get(i));
                    }
                });
                return tr;
            }

            final int len = arg1.isVector();
            if (len >= 0) {
				final IASTAppendable tr = F.ast(header, len, true);
				((IAST) arg1).forEach(1, len + 1, new ObjIntConsumer<IExpr>() {
                    @Override
                    public void accept(IExpr x, int i) {
                        tr.set(i, x);
                    }
                });
                return tr;
            }
            return F.NIL;
        }

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_2;
		}
        @Override
        public void setUp(final ISymbol newSymbol) {
        }

    }

    /**
     * <pre>
     * Transpose(m)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * transposes rows and columns in the matrix <code>m</code>.
     * </p>
     * </blockquote>
     * <p>
     * See:
     * </p>
     * <ul>
     * <li><a href="https://en.wikipedia.org/wiki/Transpose">Wikipedia - Transpose</a></li>
     * </ul>
     * <h3>Examples</h3>
	 *
     * <pre>
     * &gt;&gt; Transpose({{1, 2, 3}, {4, 5, 6}})
     * {{1, 4}, {2, 5}, {3, 6}}
     * &gt;&gt; MatrixForm(%)
     * 1   4
     * 2   5
     * 3   6
     *
     * &gt;&gt; Transpose(x)
     * Transpose(x)
     * </pre>
     */
    private static class Transpose extends AbstractEvaluator {


        private static class TransposePermute {
            /**
             * The current tensor.
             */
            final IAST tensor;
            /**
             * The dimensions of the current tensor.
             */
            final int[] dimensions;
            /**
             * The permutation of the result tensor
             */
            final int[] permutation;
            /**
             * The position from which to extract the current element
             */
            int[] positions;

            private TransposePermute(IAST tensor, ArrayList<Integer> tensorDimensions, int[] permutation) {
                this.tensor = tensor;
                this.dimensions = new int[tensorDimensions.size()];
                for (int i = 0; i < tensorDimensions.size(); i++) {
                    dimensions[i] = tensorDimensions.get(i);
                }
                this.permutation = permutation;
                this.positions = new int[dimensions.length];
            }

            private IAST recursiveTranspose() {
                return recursiveTranspose(0, null);
            }

            /**
			 *
			 * @param permutationIndex
			 *            the current permutation index, which should be used to get the element from permutation array
			 * @param resultList
			 *            the parent list or <code>null</code> if the root-list should be created.
             * @return
             */
            private IAST recursiveTranspose(int permutationIndex, IASTAppendable resultList) {
                if (permutationIndex >= permutation.length) {
					if (resultList != null) {
                    resultList.append(tensor.getPart(positions));
					}
                } else {
                    int size = dimensions[permutation[permutationIndex] - 1];
                    IASTAppendable list = F.ListAlloc(size);
                    if (resultList != null) {
                        resultList.append(list);
                    }
                    for (int i = 0; i < size; i++) {
                        positions[permutation[permutationIndex] - 1] = i + 1;
                        recursiveTranspose(permutationIndex + 1, list);
                    }
                    return list;
                }
                return F.NIL;
            }
        }

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {

			if (ast.size() == 3) {
				if (ast.arg1().isList() && ast.arg2().isList()) {
					IAST tensor = (IAST) ast.arg1();
					ArrayList<Integer> dims = dimensions(tensor, tensor.head(), Integer.MAX_VALUE);
					int[] permutation = Validate.checkListOfInts(ast.arg2(), 1, dims.size());
					return new TransposePermute(tensor, dims, permutation).recursiveTranspose();
				}
				return F.NIL;
			}
			final int[] dim = ast.arg1().isMatrix();
			if (dim != null) {
				final IAST originalMatrix = (IAST) ast.arg1();
				return transpose(originalMatrix, dim[0], dim[1]);
			}
			return F.NIL;
		}

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_2;
		}
		protected IExpr transform(final IExpr expr) {
			return expr;
		}

		/**
		 * Transpose the given matrix.
		 *
		 * @param matrix
		 *            the matrix which should be transposed
		 * @param rows
		 *            number of rows of the matrix
		 * @param cols
		 *            number of columns of the matrix
		 * @return
		 */
		public IAST transpose(final IAST matrix, final int rows, int cols) {
			final IASTAppendable transposedMatrix = F.ast(F.List, cols, true);
			transposedMatrix.setArgs(cols + 1, new IntFunction<IExpr>() {
                @Override
                public IExpr apply(int i) {
                    return F.ast(F.List, rows, true);
                }
            });
			// for (int i = 1; i <= cols; i++) {
			// transposedMatrix.set(i, F.ast(F.List, rows, true));
			// }

			IAST originalRow;
			IASTMutable transposedResultRow;
			for (int i = 1; i <= rows; i++) {
				originalRow = (IAST) matrix.get(i);
				for (int j = 1; j <= cols; j++) {
					transposedResultRow = (IASTMutable) transposedMatrix.get(j);
					transposedResultRow.set(i, transform(originalRow.get(j)));
				}
			}
			transposedMatrix.addEvalFlags(IAST.IS_MATRIX);
			return transposedMatrix;
		}
    }

    /**
     * <pre>
     * UnitVector(position)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * returns a unit vector with element <code>1</code> at the given <code>position</code>.
     * </p>
     * </blockquote>
	 *
     * <pre>
     * UnitVector(dimension, position)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * returns a unit vector with dimension <code>dimension</code> and an element <code>1</code> at the given
     * <code>position</code>.
     * </p>
     * </blockquote>
     * <p>
     * See:<br />
     * </p>
     * <ul>
     * <li><a href="http://en.wikipedia.org/wiki/Unit_vector">Wikipedia - Unit vector</a><br />
     * </li>
     * </ul>
     * <h3>Examples</h3>
	 *
     * <pre>
     * &gt;&gt; UnitVector(4,3)
     * {0,0,1,0}
     * </pre>
     */
    private final static class UnitVector extends AbstractFunctionEvaluator {

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {

            if (ast.isAST2()) {
				int n = ast.arg1().toIntDefault(Integer.MIN_VALUE);
				if (n < 0) {
					// Positive integer (less equal 2147483647) expected at position `2` in `1`.
					return IOFunctions.printMessage(F.UnitVector, "intpm", F.List(ast, F.C1), engine);
				}
				int k = ast.arg2().toIntDefault(Integer.MIN_VALUE);
				if (k < 0) {
					// Positive integer (less equal 2147483647) expected at position `2` in `1`.
					return IOFunctions.printMessage(F.UnitVector, "intpm", F.List(ast, F.C2), engine);
				}
                if (k <= n) {
                    IASTAppendable vector = F.ListAlloc(n);
					vector.appendArgs(0, n, new IntFunction<IExpr>() {
                        @Override
                        public IExpr apply(int i) {
                            return F.C0;
                        }
                    });
                    vector.set(k, F.C1);
                    return vector;
                }
                return F.NIL;
            }

            if (ast.arg1().isInteger()) {
				int k = ast.arg1().toIntDefault(Integer.MIN_VALUE);
				if (k < 0) {
					// Positive integer (less equal 2147483647) expected at position `2` in `1`.
					return IOFunctions.printMessage(F.UnitVector, "intpm", F.List(ast, F.C1), engine);
				}
                if (k == 1) {
                    return F.List(F.C1, F.C0);
                }
                if (k == 2) {
                    return F.List(F.C0, F.C1);
                }
            }
            return F.NIL;
        }

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_2;
		}
    }

    private static class UpperTriangularize extends AbstractFunctionEvaluator {

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {

            int[] dim = ast.arg1().isMatrix();
            if (dim != null) {
				final IAST matrix = (IAST) ast.arg1();
                final int k = (ast.size() == 3 && ast.arg2().isInteger())
                        ? Validate.checkIntType(ast, 2, Integer.MIN_VALUE)
                        : 0;
                int m = dim[0];
                int n = dim[1];
				return F.matrix(new BiFunction<Integer, Integer, IExpr>() {
                    @Override
                    public IExpr apply(Integer i, Integer j) {
                        return i <= j - k ? matrix.getPart(i + 1, j + 1) : F.C0;
                    }
                }, m, n);
			}
			return F.NIL;
		}
                    @Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_2;
            }

    }

    /**
     * <pre>
     * VandermondeMatrix(n)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * gives the Vandermonde matrix with <code>n</code> rows and columns.
     * </p>
     * </blockquote>
     * <p>
     * See:<br />
     * </p>
     * <ul>
     * <li><a href="http://en.wikipedia.org/wiki/Vandermonde_matrix">Wikipedia - Vandermonde matrix</a></li>
     * </ul>
     * <h3>Examples</h3>
	 *
     * <pre>
     * &gt;&gt; VandermondeMatrix({a,b,c})
     * {{1,a,a^2},
     *  {1,b,b^2},
     *  {1,c,c^2}}
     * </pre>
     */
    private static class VandermondeMatrix extends AbstractFunctionEvaluator {
        public VandermondeMatrix() {
        }

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {
            if (ast.arg1().isList()) {
                final IAST lst = (IAST) ast.arg1();
                final int len0 = lst.argSize();

                final int[] indexArray = new int[2];
                indexArray[0] = len0;
                indexArray[1] = len0;

                // final IIndexFunction<IExpr> function = new IIndexFunction<IExpr>() {
                // @Override
                // public IExpr evaluate(int[] index) {
                // return Power(lst.get(index[0] + 1), F.integer(index[1]));
                // }
                // };
                final IndexTableGenerator generator = new IndexTableGenerator(indexArray, F.List, //
                        new IIndexFunction<IExpr>() {
                            @Override
                            public IExpr evaluate(int[] indx) {
                                return Power(lst.get(indx[0] + 1), F.integer(indx[1]));
                            }
                        });
                final IAST matrix = (IAST) generator.table();
                matrix.addEvalFlags(IAST.IS_MATRIX);
                return matrix;
            }

            return F.NIL;
        }
		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_1;
		}
    }

    /**
     * <pre>
     * VectorAngle(u, v)
     * </pre>
	 *
     * <blockquote>
     * <p>
     * gives the angles between vectors <code>u</code> and <code>v</code>
     * </p>
     * </blockquote>
     * <h3>Examples</h3>
	 *
     * <pre>
     * &gt;&gt; VectorAngle({1, 0}, {0, 1})
     * Pi/2
     *
     * &gt;&gt; VectorAngle({1, 2}, {3, 1})
     * Pi/4
     *
     * &gt;&gt; VectorAngle({1, 1, 0}, {1, 0, 1})
     * Pi/3
     *
     * &gt;&gt; VectorAngle({0, 1}, {0, 1})
     * 0
     * </pre>
     */
    private static class VectorAngle extends AbstractFunctionEvaluator {

        @Override
        public IExpr evaluate(final IAST ast, EvalEngine engine) {
            IExpr arg1 = ast.arg1();
            IExpr arg2 = ast.arg2();

            int dim1 = arg1.isVector();
            int dim2 = arg2.isVector();
            if (dim1 > (-1) && dim2 > (-1)) {
                return ArcCos(Divide(Dot(arg1, arg2), Times(Norm(arg1), Norm(arg2))));
            }
            return F.NIL;
        }

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_2_2;
    }

	}

	/**
	 * <p>
	 * Use cramer's rule to solve linear equations represented by a <code>2 x 3</code> augmented matrix which represents
	 * the system <code>M.x == b</code>, where the columns of the <code>2 x 2</code> matrix <code>M</code> are augmented
	 * by the vector <code>b</code>. This method assumes that the dimensions of the matrix are already checked by the
	 * caller.
	 * </p>
	 * See: <a href="https://en.wikipedia.org/wiki/Cramer's_rule">Wikipedia Cramer's rule</a>
	 *
	 * @param matrix
	 *            the <code>2 x 3</code> augmented matrix
	 * @param quiet
	 *            show no message if there is no solution
	 * @param engine
	 *            the evaluation engine
	 * @return a list of values which solve the equations or <code>F#NIL</code>, if the equations have no solution.
	 */
	public static IAST cramersRule2x3(FieldMatrix<IExpr> matrix, boolean quiet, EvalEngine engine) {
		IASTAppendable list = F.ListAlloc(2);
		// a1 * b2 - b1 * a2
		IExpr denominator = determinant2x2(matrix);
		if (denominator.isZero()) {
			if (!quiet) {
				return engine.printMessage("Row reduced linear equations have no solution.");
			}
			return F.NIL;
		}
		// c1 * b2 - b1 * c2
		IExpr xNumerator = F.Subtract(F.Times(matrix.getEntry(0, 2), matrix.getEntry(1, 1)),
				F.Times(matrix.getEntry(0, 1), matrix.getEntry(1, 2)));
		list.append(F.Divide(xNumerator, denominator));
		// a1 * c2 - c1*a2
		IExpr yNumerator = F.Subtract(F.Times(matrix.getEntry(0, 0), matrix.getEntry(1, 2)),
				F.Times(matrix.getEntry(0, 2), matrix.getEntry(1, 0)));
		list.append(F.Divide(yNumerator, denominator));
		return list;
	}

	/**
	 * <p>
	 * Use cramer's rule to solve linear equations represented by a <code>3 x 4</code> augmented matrix which represents
	 * the system <code>M.x == b</code>, where the columns of the <code>3 x 3</code> matrix <code>M</code> are augmented
	 * by the vector <code>b</code>. This method assumes that the dimensions of the matrix are already checked by the
	 * caller.
	 * </p>
	 * See: <a href="https://en.wikipedia.org/wiki/Cramer's_rule">Wikipedia Cramer's rule</a>
	 *
	 * @param matrix
	 *            the <code>3 x 4</code> augmented matrix
	 * @param quiet
	 *            show no message if there is no solution
	 * @param engine
	 *            the evaluation engine
	 * @return a list of values which solve the equations or <code>F#NIL</code>, if the equations have no solution.
	 */
	public static IAST cramersRule3x4(FieldMatrix<IExpr> matrix, boolean quiet, EvalEngine engine) {
		IASTAppendable list = F.ListAlloc(3);
		FieldMatrix<IExpr> denominatorMatrix = matrix.getSubMatrix(0, 2, 0, 2);
		IExpr denominator = determinant3x3(denominatorMatrix);
		if (denominator.isZero()) {
			if (!quiet) {
				return engine.printMessage("Row reduced linear equations have no solution.");
			}
			return F.NIL;
		}

		FieldMatrix<IExpr> xMatrix = denominatorMatrix.copy();
		xMatrix.setColumn(0, new IExpr[] { matrix.getEntry(0, 3), matrix.getEntry(1, 3), matrix.getEntry(2, 3) });
		IExpr xNumerator = determinant3x3(xMatrix);

		list.append(F.Divide(xNumerator, denominator));

		FieldMatrix<IExpr> yMatrix = denominatorMatrix.copy();
		yMatrix.setColumn(1, new IExpr[] { matrix.getEntry(0, 3), matrix.getEntry(1, 3), matrix.getEntry(2, 3) });
		IExpr yNumerator = determinant3x3(yMatrix);

		list.append(F.Divide(yNumerator, denominator));

		FieldMatrix<IExpr> zMatrix = denominatorMatrix.copy();
		zMatrix.setColumn(2, new IExpr[] { matrix.getEntry(0, 3), matrix.getEntry(1, 3), matrix.getEntry(2, 3) });
		IExpr zNumerator = determinant3x3(zMatrix);

		list.append(F.Divide(zNumerator, denominator));

		return list;
	}

	/**
	 * Get the determinant of a <code>2 x 2</code> matrix. This method assumes that the dimensions of the matrix are
	 * already checked by the caller.
	 *
	 * @param matrix
	 *            a 2x2 matrix
	 * @return
	 */
	public static IExpr determinant2x2(final FieldMatrix<IExpr> matrix) {
		// 2x2 matrix
		IExpr[] row1 = matrix.getRow(0);
		IExpr[] row2 = matrix.getRow(1);
		return F.evalExpand(row1[0].times(row2[1]).subtract((row1[1].times(row2[0]))));
	}

	/**
	 * Get the determinant of a <code>3 x 3</code> matrix. This method assumes that the dimensions of the matrix are
	 * already checked by the caller.
	 *
	 * @param matrix
	 *            a 3x3 matrix
	 * @return
	 */
	public static IExpr determinant3x3(final FieldMatrix<IExpr> matrix) {
		// 3x3 matrix
		IExpr[] row1 = matrix.getRow(0);
		IExpr[] row2 = matrix.getRow(1);
		IExpr[] row3 = matrix.getRow(2);
		return F.evalExpand(row1[0].times(row2[1].times(row3[2])).subtract((row1[0].times(row2[2].times(row3[1]))))
				.subtract((row1[1].times(row2[0].times(row3[2])))).plus((row1[1].times(row2[2].times(row3[0]))))
				.plus((row1[2].times(row2[0].times(row3[1])))).subtract((row1[2].times(row2[1].times(row3[0])))));
	}

	/**
	 * Create a diagonal matrix from <code>valueArray[0]</code> (non-diagonal elements) and <code>valueArray[1]</code>
	 * (diagonal elements).
	 *
	 * @param valueArray
	 *            2 values for non-diagonal and diagonal elemnets of the matrix.
	 * @param dimension
	 *            of the square matrix
	 *
	 * @return
	 */
	public static IAST diagonalMatrix(final IExpr[] valueArray, int dimension) {
		final int[] indexArray = new int[2];
		indexArray[0] = dimension;
		indexArray[1] = dimension;
		final IndexTableGenerator generator = new IndexTableGenerator(indexArray, F.List,
				new IndexFunctionDiagonal(valueArray));
		final IAST matrix = (IAST) generator.table();
		matrix.addEvalFlags(IAST.IS_MATRIX);
		return matrix;
	}

	public static ArrayList<Integer> dimensions(IAST ast) {
		return dimensions(ast, ast.head(), Integer.MAX_VALUE, new ArrayList<Integer>());
	}

	public static ArrayList<Integer> dimensions(IAST ast, IExpr header, int maxLevel) {
		return dimensions(ast, header, maxLevel, new ArrayList<Integer>());
	}

	public static ArrayList<Integer> dimensions(IAST ast, IExpr header, int maxLevel, ArrayList<Integer> dims) {
		int size = ast.size();
		dims.add(size - 1);
		if (size > 1 && ast.arg1().isAST()) {
			IAST arg1AST = (IAST) ast.arg1();
			int arg1Size = arg1AST.size();
			if (!header.equals(arg1AST.head())) {
				return dims;
			}
			if (maxLevel > 0) {
				for (int i = 2; i < size; i++) {
					if (!ast.get(i).isAST()) {
						return dims;
					}
					if (arg1Size != ((IAST) ast.get(i)).size()) {
						return dims;
					}
				}
				dimensions(arg1AST, header, maxLevel - 1, dims);
			}
		}
		return dims;
	}

	public static void initialize() {
		Initializer.init();
	}

	/**
	 * Return the solution of the given (augmented-)matrix interpreted as a system of linear equations.
	 *
	 * @param matrix
	 * @param quiet
	 *            suppress warning messages if <code>true</code>
	 * @param engine
	 *            the evaluation engine
	 * @return <code>F.NIL</code> if the linear system is inconsistent and has no solution
	 */
	public static IAST rowReduced2List(FieldMatrix<IExpr> matrix, boolean quiet, final EvalEngine engine) {

		int rows = matrix.getRowDimension();
		final int cols = matrix.getColumnDimension();
		if (rows == 2 && cols == 3) {
			IAST list = cramersRule2x3(matrix, quiet, engine);
			if (list.isPresent()) {
				return list;
			}
		} else if (rows == 3 && cols == 4) {
			IAST list = cramersRule3x4(matrix, quiet, engine);
			if (list.isPresent()) {
				return list;
			}
		}
		FieldReducedRowEchelonForm ref = new FieldReducedRowEchelonForm(matrix);
		final FieldMatrix<IExpr> rowReduced = ref.getRowReducedMatrix();
		// System.out.println(rowReduced.toString());
		IExpr lastVarCoefficient = rowReduced.getEntry(rows - 1, cols - 2);
		if (lastVarCoefficient.isZero()) {
			if (!rowReduced.getEntry(rows - 1, cols - 1).isZero()) {
				return engine.printMessage("Row reduced linear equations have no solution.");
			}
		}
		IASTAppendable list = F.ListAlloc(rows < cols - 1 ? cols - 1 : rows);
		list.appendArgs(0, rows, new IntFunction<IExpr>() {
            @Override
            public IExpr apply(int j) {
                return F.Together.of(engine, rowReduced.getEntry(j, cols - 1));
            }
        });
		if (rows < cols - 1) {
			list.appendArgs(rows, cols - 1, new IntFunction<IExpr>() {
                @Override
                public IExpr apply(int i) {
                    return F.C0;
                }
            });
		}
		return list;
	}

	/**
	 * Row reduce the given <code>(augmented-)matrix</code> and append the result as rules for the given
	 * <code>variableList</code>.
	 *
	 * @param matrix
	 *            a (augmented-)matrix
	 * @param listOfVariables
	 *            list of variable symbols
	 * @param resultList
	 *            a list to which the rules should be appended
	 * @param engine
	 *            the evaluation engine
	 * @return resultList with the appended results as list of rules
	 */
	public static IAST rowReduced2RulesList(FieldMatrix<IExpr> matrix, final IAST listOfVariables, IASTAppendable resultList,
                                            final EvalEngine engine) {
		int rows = matrix.getRowDimension();
		int cols = matrix.getColumnDimension();
		IAST smallList = null;
		if (rows == 2 && cols == 3) {
			smallList = cramersRule2x3(matrix, true, engine);
		} else if (rows == 3 && cols == 4) {
			smallList = cramersRule3x4(matrix, true, engine);
		}
		if (smallList != null) {
			if (!smallList.isPresent()) {
				// no solution
				return F.List();
			}
			final IAST sList = smallList;
			int size = smallList.size();
			IASTAppendable list = F.ListAlloc(size);
			list.appendArgs(size, new IntFunction<IExpr>() {
                @Override
                public IExpr apply(int j) {
                    return F.Rule(listOfVariables.get(j), engine.evaluate(sList.get(j)));
                }
            });

			resultList.append(list);
			return resultList;
		}
		FieldReducedRowEchelonForm ref = new FieldReducedRowEchelonForm(matrix);
		FieldMatrix<IExpr> rowReduced = ref.getRowReducedMatrix();
		int size = listOfVariables.argSize();

		IExpr lastVarCoefficient = rowReduced.getEntry(rows - 1, cols - 2);

		if (lastVarCoefficient.isZero()) {
			if (!rowReduced.getEntry(rows - 1, cols - 1).isZero()) {
				// no solution
				return F.List();
			}
		}
		IAST rule;
		IASTAppendable list = F.ListAlloc(rows);
		for (int j = 1; j < rows + 1; j++) {
			if (j < size + 1) {
				IExpr diagonal = rowReduced.getEntry(j - 1, j - 1);
				if (!diagonal.isZero()) {
					IASTAppendable plus = F.PlusAlloc(cols);
					plus.append(rowReduced.getEntry(j - 1, cols - 1));
					for (int i = j; i < cols - 1; i++) {
						if (!rowReduced.getEntry(j - 1, i).isZero()) {
							plus.append(F.Times(rowReduced.getEntry(j - 1, i).negate(), listOfVariables.get(i + 1)));
						}
					}
					rule = F.Rule(listOfVariables.get(j),  F.Together.of(engine, plus.oneIdentity0()));
					list.append(rule);
				}
			}
		}
		resultList.append(list);
		return resultList;
	}

	private LinearAlgebra() {

	}
}
