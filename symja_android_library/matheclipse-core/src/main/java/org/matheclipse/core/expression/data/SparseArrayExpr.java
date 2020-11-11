package org.matheclipse.core.expression.data;

import com.duy.lambda.Function;
import com.duy.lambda.Predicate;
import com.duy.util.MapWrapper;


import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Arrays;

import org.hipparchus.Field;
import org.hipparchus.FieldElement;
import org.hipparchus.exception.LocalizedCoreFormats;
import org.hipparchus.exception.MathIllegalArgumentException;
import org.hipparchus.exception.MathRuntimeException;
import org.hipparchus.exception.NullArgumentException;
import org.hipparchus.linear.AbstractFieldMatrix;
import org.hipparchus.linear.FieldMatrix;
import org.hipparchus.linear.FieldVector;
import org.hipparchus.util.MathUtils;
import org.matheclipse.core.builtin.IOFunctions;
import org.matheclipse.core.builtin.LinearAlgebra;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.Predicates;
import org.matheclipse.core.eval.exception.ArgumentTypeException;
import org.matheclipse.core.expression.DataExpr;
import org.matheclipse.core.expression.ExprField;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.expression.S;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IASTAppendable;
import org.matheclipse.core.interfaces.IASTMutable;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.ISparseArray;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.core.patternmatching.IPatternMap;
import org.matheclipse.core.patternmatching.PatternMatcherAndEvaluator;
import org.matheclipse.parser.client.FEConfig;
import org.matheclipse.parser.trie.Trie;
import org.matheclipse.parser.trie.TrieNode;
import org.matheclipse.parser.trie.Tries;


/**
 * <p>
 * Sparse array implementation.
 * </p>
 * <b>Note:</b> in Symja sparse arrays the offset is +1 compared to java arrays or hipparchus <code>FieldVector</code>,
 * <code>FieldMatrix</code>.
 *
 */
public class SparseArrayExpr extends DataExpr<Trie<int[], IExpr>> implements ISparseArray, Externalizable {
	/**
	 *
	 * This class implements the {@link FieldMatrix} interface with a {@link SparseArrayExpr} backing store.
	 *
	 * <b>Note:</b> in Symja sparse arrays the offset is +1 compared to java arrays or hipparchus
	 * <code>FieldMatrix</code>.
	 *
	 */
	public static class SparseExprMatrix extends AbstractFieldMatrix<IExpr> {
		final SparseArrayExpr array;

		/**
		 * Create a new SparseExprMatrix with the supplied row and column dimensions.
		 *
		 * @param rowDimension
		 *            Number of rows in the new matrix.
		 * @param columnDimension
		 *            Number of columns in the new matrix.
		 * @throws org.hipparchus.exception.MathIllegalArgumentException
		 *             if row or column dimension is not positive.
		 */
		public SparseExprMatrix(final int rowDimension, final int columnDimension, IExpr defaultValue) {
			super(ExprField.CONST, rowDimension, columnDimension);
			this.array = new SparseArrayExpr(Tries.<IExpr>forInts(), new int[] { rowDimension, columnDimension }, defaultValue,
					false);
		}

		/**
		 * Copy constructor.
		 *
		 * @param other
		 *            Instance to copy.
		 * @param copyArray
		 *            Whether to copy or reference the input array.
		 */
		public SparseExprMatrix(SparseArrayExpr array, boolean copyArray) {
			super(ExprField.CONST, array.dimension[0], array.dimension[1]);
			if (copyArray) {
				this.array = new SparseArrayExpr(array.fData, array.dimension, array.defaultValue, true);
			} else {
				this.array = array;
			}
		}

		/**
		 * Copy constructor.
		 *
		 * @param other
		 *            Instance to copy.
		 */
		public SparseExprMatrix(SparseExprMatrix other) {
			super(ExprField.CONST, other.array.dimension[0], other.array.dimension[1]);
			this.array = new SparseArrayExpr(other.array.fData, other.array.dimension, other.array.defaultValue, true);
		}

		/**
		 * Change an entry in the specified row and column.
		 *
		 * @param row
		 *            Row location of entry to be set.
		 * @param column
		 *            Column location of entry to be set.
		 * @param increment
		 *            Value to add to the current matrix entry in {@code (row, column)}.
		 * @throws MathIllegalArgumentException
		 *             if the row or column index is not valid.
		 */
		@Override
		public void addToEntry(int row, int column, IExpr increment) throws MathIllegalArgumentException {
			final Trie<int[], IExpr> map = array.fData;
			final int[] key = new int[] { row + 1, column + 1 };
			IExpr value = map.get(key);
			value = S.Plus.of(value != null ? value : array.defaultValue, increment);
			if (value.equals(array.defaultValue)) {
				map.remove(key);
			} else {
				map.put(key, value);
			}
		}

		/**
		 * Make a (deep) copy of this.
		 *
		 * @return a copy of this matrix.
		 */
		@Override
		public FieldMatrix<IExpr> copy() {
			return new SparseExprMatrix(this);
		}

		/**
		 * Create a new FieldMatrix<T> of the same type as the instance with the supplied row and column dimensions.
		 *
		 * @param rowDimension
		 *            the number of rows in the new matrix
		 * @param columnDimension
		 *            the number of columns in the new matrix
		 * @return a new matrix of the same type as the instance
		 * @throws MathIllegalArgumentException
		 *             if row or column dimension is not positive.
		 */
		@Override
		public SparseExprMatrix createMatrix(int rowDimension, int columnDimension)
				throws MathIllegalArgumentException {
			return new SparseExprMatrix(rowDimension, columnDimension, F.C0);
		}

		@Override
		public int getColumnDimension() {
			return array.dimension[1];
		}

		/**
		 * Returns the entry in the specified row and column.
		 *
		 * @param row
		 *            row location of entry to be fetched
		 * @param column
		 *            column location of entry to be fetched
		 * @return matrix entry in row,column
		 * @throws MathIllegalArgumentException
		 *             if the row or column index is not valid.
		 */
		@Override
		public IExpr getEntry(int arg0, int arg1) throws MathIllegalArgumentException {
			IExpr value = array.fData.get(new int[] { arg0 + 1, arg1 + 1 });
			return value == null ? array.defaultValue : value;
		}

		@Override
		public int getRowDimension() {
			return array.dimension[0];
		}

		public SparseArrayExpr getSparseArray() {
			return array;
		}

		/**
		 * Postmultiply this matrix by {@code m}.
		 *
		 * @param m
		 *            Matrix to postmultiply by.
		 * @return {@code this} * {@code m}.
		 * @throws MathIllegalArgumentException
		 *             if the number of columns of {@code this} matrix is not equal to the number of rows of matrix
		 *             {@code m}.
		 */
		@Override
		public SparseExprMatrix multiply(final FieldMatrix<IExpr> m) throws MathIllegalArgumentException {
			// safety check
			checkMultiplicationCompatible(m);

			final int nRows = getRowDimension();
			final int nCols = m.getColumnDimension();
			final int nSum = getColumnDimension();
			final SparseExprMatrix out = createMatrix(nRows, nCols);
			for (int row = 0; row < nRows; ++row) {
				for (int col = 0; col < nCols; ++col) {
					IExpr sum = F.C0;
					for (int i = 0; i < nSum; ++i) {
						sum = sum.add(getEntry(row, i).multiply(m.getEntry(i, col)));
					}
					out.setEntry(row, col, sum);
				}
			}

			return out;
		}

		/**
		 * Change an entry in the specified row and column.
		 *
		 * @param row
		 *            Row location of entry to be set.
		 * @param column
		 *            Column location of entry to be set.
		 * @param factor
		 *            Multiplication factor for the current matrix entry in {@code (row,column)}
		 * @throws MathIllegalArgumentException
		 *             if the row or column index is not valid.
		 */
		@Override
		public void multiplyEntry(int row, int column, IExpr factor) throws MathIllegalArgumentException {
			final Trie<int[], IExpr> map = array.fData;
			final int[] key = new int[] { row + 1, column + 1 };
			IExpr value = map.get(key);
			value = S.Times.of(value != null ? value : array.defaultValue, factor);
			if (value.equals(array.defaultValue)) {
				map.remove(key);
			} else {
				map.put(key, value);
			}
		}

		/**
		 * Returns the result of multiplying this by the vector {@code v}.
		 *
		 * @param v
		 *            the vector to operate on
		 * @return {@code this * v}
		 * @throws MathIllegalArgumentException
		 *             if the number of columns of {@code this} matrix is not equal to the size of the vector {@code v}.
		 */
		@Override
		public SparseExprVector operate(final FieldVector<IExpr> fv) throws MathIllegalArgumentException {
			if (fv instanceof SparseExprVector) {
				SparseExprVector v = (SparseExprVector) fv;
				final int nRows = getRowDimension();
				final int nCols = getColumnDimension();
				if (v.getDimension() != nCols) {
					throw new MathIllegalArgumentException(LocalizedCoreFormats.DIMENSIONS_MISMATCH, v.getDimension(),
							nCols);
				}

				SparseExprVector out = new SparseExprVector(nRows, array.defaultValue);
				for (int row = 0; row < nRows; row++) {
					IExpr sum = F.C0;
					for (int i = 0; i < nCols; i++) {
						sum = sum.add(getEntry(row, i).multiply(v.getEntry(i)));
					}
					out.setEntry(row, sum);
				}

				return out;
			}
			return null;
		}

		/**
		 * Set the entry in the specified row and column.
		 *
		 * @param row
		 *            row location of entry to be set
		 * @param column
		 *            column location of entry to be set
		 * @param value
		 *            matrix entry to be set in row,column
		 * @throws MathIllegalArgumentException
		 *             if the row or column index is not valid.
		 */
		@Override
		public void setEntry(int row, int column, IExpr value) throws MathIllegalArgumentException {
			final Trie<int[], IExpr> map = array.fData;
			final int[] key = new int[] { row + 1, column + 1 };
			if (value.equals(array.defaultValue)) {
				map.remove(key);
			} else {
				map.put(key, value);
			}
		}
	}

	/**
	 * This class implements the {@link FieldVector} interface with a {@link SparseArrayExpr} backing store.
	 *
	 * <b>Note:</b> in Symja sparse arrays the offset is +1 compared to java arrays or hipparchus
	 * <code>FieldVector</code>.
	 */
	public static class SparseExprVector implements FieldVector<IExpr> {
		final SparseArrayExpr array;
		/** Dimension of the vector. */
		private final int virtualSize;

		/**
		 * Create a new SparseExprVector with the supplied row dimensions.
		 *
		 * @param dimension
		 *            Number of elements in the new vector.
		 * @throws org.hipparchus.exception.MathIllegalArgumentException
		 *             if row or column dimension is not positive.
		 */
		public SparseExprVector(final int dimension, IExpr defaultValue) {
			this.array = new SparseArrayExpr(Tries.<IExpr>forInts(), new int[] { dimension }, defaultValue, false);
			this.virtualSize = dimension;
		}

		/**
		 * Copy constructor
		 *
		 * @param array
		 * @param copyArray
		 *            Whether to copy or reference the input array.
		 */
		public SparseExprVector(SparseArrayExpr array, boolean copyArray) {
			if (copyArray) {
				this.array = new SparseArrayExpr(Tries.<IExpr>forInts(), new int[] { array.dimension[0] }, array.defaultValue,
						false);
			} else {
				this.array = array;
			}
			this.virtualSize = array.dimension[0];
		}

		/**
		 * Build a resized vector, for use with append.
		 *
		 * @param v
		 *            Original vector
		 * @param resize
		 *            Amount to add.
		 */
		protected SparseExprVector(SparseArrayExpr array, int resize) {
			this.array = new SparseArrayExpr(array.fData, array.dimension, array.defaultValue, true);
			this.virtualSize = array.dimension[0] + resize;
		}

		/**
		 * Copy constructor.
		 *
		 * @param other
		 *            Instance to copy.
		 */
		public SparseExprVector(SparseExprVector other) {
			this.array = new SparseArrayExpr(other.array.fData, other.array.dimension, other.array.defaultValue, true);
			this.virtualSize = other.array.dimension[0];
		}

		/**
		 * Build a resized vector, for use with append.
		 *
		 * @param v
		 *            Original vector
		 * @param resize
		 *            Amount to add.
		 */
		protected SparseExprVector(SparseExprVector v, int resize) {
			this.array = new SparseArrayExpr(v.array.fData, v.array.dimension, v.array.defaultValue, true);
			this.virtualSize = v.array.dimension[0] + resize;
		}

		/**
		 * Compute the sum of {@code this} and {@code v}.
		 *
		 * @param v
		 *            vector to be added
		 * @return {@code this + v}
		 * @throws MathIllegalArgumentException
		 *             if {@code v} is not the same size as {@code this}
		 */
		@Override
		public SparseExprVector add(FieldVector<IExpr> v) throws MathIllegalArgumentException {
			final int n = v.getDimension();
			checkVectorDimensions(n);
			SparseExprVector res = new SparseExprVector(getDimension(), array.defaultValue);
			for (int i = 0; i < n; i++) {
				res.setEntry(i, v.getEntry(i).add(getEntry(i)));
			}
			return res;
		}

		/**
		 * Construct a vector by appending a vector to this vector.
		 *
		 * @param v
		 *            vector to append to this one.
		 * @return a new vector
		 */
		@Override
		public SparseExprVector append(FieldVector<IExpr> v) {
			final int n = v.getDimension();
			SparseExprVector res = new SparseExprVector(array, n);
			for (int i = 0; i < n; i++) {
				res.setEntry(i + virtualSize, v.getEntry(i));
			}
			return res;
		}

		/**
		 * Construct a vector by appending a IExpr to this vector.
		 *
		 * @param d
		 *            IExpr to append.
		 * @return a new vector
		 */
		@Override
		public SparseExprVector append(IExpr d) {
			MathUtils.checkNotNull(d);
			SparseExprVector res = new SparseExprVector(this, 1);
			res.setEntry(virtualSize, d);
			return res;
		}

		/**
		 * Check whether an index is valid.
		 *
		 * @param index
		 *            Index to check.
		 * @throws MathIllegalArgumentException
		 *             if the index is not valid.
		 */
		private void checkIndex(final int index) throws MathIllegalArgumentException {
			MathUtils.checkRangeInclusive(index, 0, getDimension() - 1);
		}

		/**
		 * Checks that the indices of a subvector are valid.
		 *
		 * @param start
		 *            the index of the first entry of the subvector
		 * @param end
		 *            the index of the last entry of the subvector (inclusive)
		 * @throws MathIllegalArgumentException
		 *             if {@code start} of {@code end} are not valid
		 * @throws MathIllegalArgumentException
		 *             if {@code end < start}
		 */
		private void checkIndices(final int start, final int end) throws MathIllegalArgumentException {
			final int dim = getDimension();
			if ((start < 0) || (start >= dim)) {
				throw new MathIllegalArgumentException(LocalizedCoreFormats.INDEX, start, 0, dim - 1);
			}
			if ((end < 0) || (end >= dim)) {
				throw new MathIllegalArgumentException(LocalizedCoreFormats.INDEX, end, 0, dim - 1);
			}
			if (end < start) {
				throw new MathIllegalArgumentException(LocalizedCoreFormats.INITIAL_ROW_AFTER_FINAL_ROW, end, start,
						false);
			}
		}

		/**
		 * Check if instance dimension is equal to some expected value.
		 *
		 * @param n
		 *            Expected dimension.
		 * @throws MathIllegalArgumentException
		 *             if the dimensions do not match.
		 */
		protected void checkVectorDimensions(int n) throws MathIllegalArgumentException {
			if (getDimension() != n) {
				throw new MathIllegalArgumentException(LocalizedCoreFormats.DIMENSIONS_MISMATCH, getDimension(), n);
			}
		}

		@Override
		public SparseExprVector copy() {
			return new SparseExprVector(this);
		}

		/**
		 * Compute the dot product.
		 *
		 * @param v
		 *            vector with which dot product should be computed
		 * @return the scalar dot product of {@code this} and {@code v}
		 * @throws MathIllegalArgumentException
		 *             if {@code v} is not the same size as {@code this}
		 */
		@Override
		public IExpr dotProduct(FieldVector<IExpr> v) throws MathIllegalArgumentException {
			checkVectorDimensions(v.getDimension());
			IASTAppendable plus = F.PlusAlloc(array.fData.size());
			for (TrieNode<int[], IExpr> entry : array.fData.nodeSet()) {
				int[] key = entry.getKey();
				IExpr value = entry.getValue();
				plus.append(v.getEntry(key[0] - 1).multiply(value));
			}
			return EvalEngine.get().evaluate(plus.oneIdentity(F.C0));
		}

		/**
		 * Element-by-element division.
		 *
		 * @param v
		 *            vector by which instance elements must be divided
		 * @return a vector containing {@code this[i] / v[i]} for all {@code i}
		 * @throws MathIllegalArgumentException
		 *             if {@code v} is not the same size as {@code this}
		 * @throws MathRuntimeException
		 *             if one entry of {@code v} is zero.
		 */
		@Override
		public SparseExprVector ebeDivide(FieldVector<IExpr> v)
				throws MathIllegalArgumentException, MathRuntimeException {
			checkVectorDimensions(v.getDimension());
			SparseExprVector res = new SparseExprVector(this);
			for (TrieNode<int[], IExpr> entry : array.fData.nodeSet()) {
				int[] key = entry.getKey();
				IExpr value = entry.getValue();
				IExpr newEntry = value.divide(v.getEntry(key[0] - 1));
				res.setEntry(key[0] - 1, newEntry);
			}
			return res;
		}

		/**
		 * Element-by-element multiplication.
		 *
		 * @param v
		 *            vector by which instance elements must be multiplied
		 * @return a vector containing {@code this[i] * v[i]} for all {@code i}
		 * @throws MathIllegalArgumentException
		 *             if {@code v} is not the same size as {@code this}
		 */
		@Override
		public SparseExprVector ebeMultiply(FieldVector<IExpr> v) throws MathIllegalArgumentException {
			checkVectorDimensions(v.getDimension());
			SparseExprVector res = new SparseExprVector(this);
			for (TrieNode<int[], IExpr> entry : array.fData.nodeSet()) {
				int[] key = entry.getKey();
				IExpr value = entry.getValue();
				IExpr newEntry = value.times(v.getEntry(key[0] - 1));
				res.setEntry(key[0] - 1, newEntry);
			}
			return res;
		}

		/**
		 * Returns the size of the vector.
		 *
		 * @return size
		 */
		@Override
		public int getDimension() {
			return array.dimension[0];
		}

		/**
		 * Returns the entry in the specified index.
		 *
		 * @param index
		 *            Index location of entry to be fetched.
		 * @return the vector entry at {@code index}.
		 * @throws MathIllegalArgumentException
		 *             if the index is not valid.
		 * @see #setEntry(int, FieldElement)
		 */
		@Override
		public IExpr getEntry(int index) throws MathIllegalArgumentException {
			IExpr value = array.fData.get(new int[] { index + 1 });
			return value == null ? array.defaultValue : value;
		}

		/**
		 * Get the type of field elements of the vector.
		 *
		 * @return type of field elements of the vector
		 */

		@Override
		public Field<IExpr> getField() {
			return ExprField.CONST;
		}

		public SparseArrayExpr getSparseArray() {
			return array;
		}

		/**
		 * Get a subvector from consecutive elements.
		 *
		 * @param index
		 *            index of first element.
		 * @param n
		 *            number of elements to be retrieved.
		 * @return a vector containing n elements.
		 * @throws MathIllegalArgumentException
		 *             if the index is not valid.
		 * @throws MathIllegalArgumentException
		 *             if the number of elements if not positive.
		 */
		@Override
		public SparseExprVector getSubVector(int index, int n) throws MathIllegalArgumentException {
			if (n < 0) {
				throw new MathIllegalArgumentException(LocalizedCoreFormats.NUMBER_OF_ELEMENTS_SHOULD_BE_POSITIVE, n);
			}
			checkIndex(index);
			checkIndex(index + n - 1);
			SparseExprVector res = new SparseExprVector(n, array.defaultValue);
			int end = index + n;

			for (TrieNode<int[], IExpr> entry : array.fData.nodeSet()) {
				int[] key = entry.getKey();
				IExpr value = entry.getValue();
				if (key[0] >= index + 1 && key[0] < end + 1) {
					res.setEntry(key[0] - index + 1, value);
				}
			}
			return res;
		}

		/**
		 * Map an addition operation to each entry.
		 *
		 * @param d
		 *            value to be added to each entry
		 * @return {@code this + d}
		 * @throws NullArgumentException
		 *             if {@code d} is {@code null}.
		 */
		@Override
		public SparseExprVector mapAdd(IExpr d) throws NullArgumentException {
			return copy().mapAddToSelf(d);
		}

		/**
		 * Map an addition operation to each entry.
		 * <p>
		 * The instance <strong>is</strong> changed by this method.
		 * </p>
		 *
		 * @param d
		 *            value to be added to each entry
		 * @return for convenience, return {@code this}
		 * @throws NullArgumentException
		 *             if {@code d} is {@code null}.
		 */
		@Override
		public SparseExprVector mapAddToSelf(IExpr d) throws NullArgumentException {
			for (int i = 0; i < virtualSize; i++) {
				setEntry(i, getEntry(i).add(d));
			}
			return this;
		}

		/**
		 * Map a division operation to each entry.
		 *
		 * @param d
		 *            value to divide all entries by
		 * @return {@code this / d}
		 * @throws NullArgumentException
		 *             if {@code d} is {@code null}.
		 * @throws MathRuntimeException
		 *             if {@code d} is zero.
		 */
		@Override
		public SparseExprVector mapDivide(IExpr d) throws NullArgumentException, MathRuntimeException {
			return copy().mapDivideToSelf(d);
		}

		/**
		 * Map a division operation to each entry.
		 * <p>
		 * The instance <strong>is</strong> changed by this method.
		 * </p>
		 *
		 * @param d
		 *            value to divide all entries by
		 * @return for convenience, return {@code this}
		 * @throws NullArgumentException
		 *             if {@code d} is {@code null}.
		 * @throws MathRuntimeException
		 *             if {@code d} is zero.
		 */
		@Override
		public SparseExprVector mapDivideToSelf(IExpr d) throws NullArgumentException, MathRuntimeException {
			Trie<int[], IExpr> map = array.fData;
			for (TrieNode<int[], IExpr> entry : map.nodeSet()) {
				int[] key = entry.getKey();
				IExpr value = entry.getValue();
				map.put(key, value.divide(d));
			}
			return this;
		}

		/**
		 * Map the 1/x function to each entry.
		 *
		 * @return a vector containing the result of applying the function to each entry.
		 * @throws MathRuntimeException
		 *             if one of the entries is zero.
		 */
		@Override
		public SparseExprVector mapInv() throws MathRuntimeException {
			return copy().mapInvToSelf();
		}

		/**
		 * Map the 1/x function to each entry.
		 * <p>
		 * The instance <strong>is</strong> changed by this method.
		 * </p>
		 *
		 * @return for convenience, return {@code this}
		 * @throws MathRuntimeException
		 *             if one of the entries is zero.
		 */
		@Override
		public SparseExprVector mapInvToSelf() throws MathRuntimeException {
			for (int i = 0; i < virtualSize; i++) {
				setEntry(i, getEntry(i).inverse());
			}
			return this;
		}

		/**
		 * Map a multiplication operation to each entry.
		 *
		 * @param d
		 *            value to multiply all entries by
		 * @return {@code this * d}
		 * @throws NullArgumentException
		 *             if {@code d} is {@code null}.
		 */
		@Override
		public SparseExprVector mapMultiply(IExpr d) throws NullArgumentException {
			return copy().mapMultiplyToSelf(d);
		}

		/**
		 * Map a multiplication operation to each entry.
		 * <p>
		 * The instance <strong>is</strong> changed by this method.
		 * </p>
		 *
		 * @param d
		 *            value to multiply all entries by
		 * @return for convenience, return {@code this}
		 * @throws NullArgumentException
		 *             if {@code d} is {@code null}.
		 */
		@Override
		public SparseExprVector mapMultiplyToSelf(IExpr d) throws NullArgumentException {
			Trie<int[], IExpr> map = array.fData;
			for (TrieNode<int[], IExpr> entry : map.nodeSet()) {
				int[] key = entry.getKey();
				IExpr value = entry.getValue();
				map.put(key, value.multiply(d));
			}
			return this;
		}

		/**
		 * Map a subtraction operation to each entry.
		 *
		 * @param d
		 *            value to be subtracted to each entry
		 * @return {@code this - d}
		 * @throws NullArgumentException
		 *             if {@code d} is {@code null}
		 */
		@Override
		public SparseExprVector mapSubtract(IExpr d) throws NullArgumentException {
			return copy().mapSubtractToSelf(d);
		}

		/**
		 * Map a subtraction operation to each entry.
		 * <p>
		 * The instance <strong>is</strong> changed by this method.
		 * </p>
		 *
		 * @param d
		 *            value to be subtracted to each entry
		 * @return for convenience, return {@code this}
		 * @throws NullArgumentException
		 *             if {@code d} is {@code null}
		 */
		@Override
		public SparseExprVector mapSubtractToSelf(IExpr d) throws NullArgumentException {
			return mapAddToSelf(d.negate());
		}

		/**
		 * Compute the outer product.
		 *
		 * @param v
		 *            vector with which outer product should be computed
		 * @return the matrix outer product between instance and v
		 */
		@Override
		public SparseExprMatrix outerProduct(FieldVector<IExpr> fv) {
			if (fv instanceof SparseExprVector) {
				SparseExprVector v = (SparseExprVector) fv;
				final int n = v.getDimension();
				SparseExprMatrix res = new SparseExprMatrix(virtualSize, n, array.defaultValue);

				Trie<int[], IExpr> map1 = array.fData;
				for (TrieNode<int[], IExpr> entry1 : map1.nodeSet()) {
					int[] key1 = entry1.getKey();
					IExpr value1 = entry1.getValue();

					Trie<int[], IExpr> map2 = v.array.fData;
					for (TrieNode<int[], IExpr> entry2 : map2.nodeSet()) {
						int[] key2 = entry2.getKey();
						IExpr value2 = entry2.getValue();
						res.setEntry(key1[0] - 1, key2[0] - 1, value1.multiply(value2));
					}
				}
				return res;
			}
			return null;
		}

		/**
		 * Find the orthogonal projection of this vector onto another vector.
		 *
		 * @param v
		 *            vector onto which {@code this} must be projected
		 * @return projection of {@code this} onto {@code v}
		 * @throws MathIllegalArgumentException
		 *             if {@code v} is not the same size as {@code this}
		 * @throws MathRuntimeException
		 *             if {@code v} is the null vector.
		 */
		@Override
		public SparseExprVector projection(FieldVector<IExpr> fv)
				throws MathIllegalArgumentException, MathRuntimeException {
			if (fv instanceof SparseExprVector) {
				SparseExprVector v = (SparseExprVector) fv;
				checkVectorDimensions(v.getDimension());
				return v.mapMultiply(dotProduct(v).divide(v.dotProduct(v)));
			}
			return null;
		}

		/**
		 * Set all elements to a single value.
		 *
		 * @param value
		 *            single value to set for all elements
		 */
		@Override
		public void set(IExpr value) {
			MathUtils.checkNotNull(value);
			for (int i = 0; i < virtualSize; i++) {
				setEntry(i, value);
			}
		}

		/**
		 * Set a single element.
		 *
		 * @param index
		 *            element index.
		 * @param value
		 *            new value for the element.
		 * @throws MathIllegalArgumentException
		 *             if the index is not valid.
		 * @see #getEntry(int)
		 */
		@Override
		public void setEntry(int index, IExpr value) throws MathIllegalArgumentException {
			final Trie<int[], IExpr> map = array.fData;
			final int[] key = new int[] { index + 1 };
			if (value.equals(array.defaultValue)) {
				map.remove(key);
			} else {
				map.put(key, value);
			}
		}

		/**
		 * Set a set of consecutive elements.
		 *
		 * @param index
		 *            index of first element to be set.
		 * @param v
		 *            vector containing the values to set.
		 * @throws MathIllegalArgumentException
		 *             if the index is not valid.
		 */
		@Override
		public void setSubVector(int index, FieldVector<IExpr> v) throws MathIllegalArgumentException {
			checkIndex(index);
			checkIndex(index + v.getDimension() - 1);
			final int n = v.getDimension();
			for (int i = 0; i < n; i++) {
				setEntry(i + index, v.getEntry(i));
			}
		}

		/**
		 * Compute {@code this} minus {@code v}.
		 *
		 * @param v
		 *            vector to be subtracted
		 * @return {@code this - v}
		 * @throws MathIllegalArgumentException
		 *             if {@code v} is not the same size as {@code this}
		 */
		@Override
		public SparseExprVector subtract(FieldVector<IExpr> fv) throws MathIllegalArgumentException {

			if (fv instanceof SparseExprVector) {
				SparseExprVector v = (SparseExprVector) fv;
				checkVectorDimensions(v.getDimension());
				SparseExprVector res = copy();

				Trie<int[], IExpr> map = v.array.fData;
				for (TrieNode<int[], IExpr> entry : map.nodeSet()) {
					int[] key = entry.getKey();
					int position = key[0];
					IExpr value = entry.getValue();
					if (array.fData.containsKey(key)) {
						res.setEntry(position, array.fData.get(key).subtract(value));
					} else {
						res.setEntry(position, value.negate());
					}
				}
				return res;
			}
			return null;
		}

		/**
		 * Convert the vector to a IExpr array.
		 * <p>
		 * The array is independent from vector data, it's elements are copied.
		 * </p>
		 *
		 * @return array containing a copy of vector elements
		 */
		@Override
		public IExpr[] toArray() {
			IExpr[] res = new IExpr[virtualSize];
			for (int i = 0; i < res.length; i++) {
				res[i] = array.defaultValue;
			}
			Trie<int[], IExpr> map = array.fData;
			for (TrieNode<int[], IExpr> entry : map.nodeSet()) {
				res[entry.getKey()[0]] = entry.getValue();
			}
			return res;
		}
	}

	/**
	 * Create array rules from the nested lists. From array rules a sparse array can be created.
	 *
	 * @param nestedListsOfValues
	 * @return
	 */
	public static IAST arrayRules(IAST nestedListsOfValues, IExpr defaultValue) {
		int depth = SparseArrayExpr.depth(nestedListsOfValues, 1);
		if (depth < 0) {
			return F.NIL;
		}
		IASTAppendable result = F.ListAlloc();
		IASTMutable positions = F.constantArray(F.C1, depth);
		if (SparseArrayExpr.arrayRulesRecursive(nestedListsOfValues, depth + 1, depth, positions, defaultValue,
				result)) {
			result.append(F.Rule(F.constantArray(F.$b(), depth), defaultValue));
			return result;
		}
		return F.NIL;
	}

	private static boolean arrayRulesRecursive(IAST nestedListsOfValues, int count, int level, IASTMutable positions,
			IExpr defaultValue, IASTAppendable result) {
		final int position = count - level;
		level--;
		for (int i = 1; i < nestedListsOfValues.size(); i++) {
			IExpr arg = nestedListsOfValues.get(i);
			positions.set(position, F.ZZ(i));
			if (level == 0) {
				if (arg.isList()) {
					return false;
				}
				if (!arg.equals(defaultValue)) {
					result.append(F.Rule(positions.copy(), arg));
				}
			} else {
				if (!arg.isList() || //
						!arrayRulesRecursive((IAST) arg, count, level, positions, defaultValue, result)) {
					return false;
				}
			}
		}
		return true;
	}

	private static int[] checkPositions(IAST ast, IExpr arg, EvalEngine engine) {
		if (arg.isNonEmptyList()) {
			IAST list = (IAST) arg;
			int[] result = new int[list.argSize()];
			try {
				IExpr expr;
				for (int i = 1; i < list.size(); i++) {
					expr = list.get(i);
					int intValue = expr.toIntDefault();
					if (intValue == Integer.MIN_VALUE) {
						return null;
					}
					if (intValue <= 0) {
						return null;
					}
					result[i - 1] = intValue;
				}
				return result;
			} catch (RuntimeException rex) {
				if (FEConfig.SHOW_STACKTRACE) {
					rex.printStackTrace();
				}
			}
		}
		return null;
	}

	private static int[] createTrie(IAST arrayRulesList, final Trie<int[], IExpr> value, int[] dimension,
			int defaultDimension, IExpr[] defaultValue, EvalEngine engine) {
		boolean determineDimension = defaultDimension < 0 || dimension == null;
		IExpr arg1 = arrayRulesList.arg1();
		IAST rule1 = (IAST) arg1;
		int[] positions = null;
		int depth = 1;
		if (dimension != null) {
			depth = dimension.length;
		}
		if (rule1.arg1().isList()) {
			IAST positionList = (IAST) rule1.arg1();
			if (dimension == null) {
				depth = positionList.argSize();
				dimension = new int[depth];
			} else {
				if (dimension.length != positionList.argSize()) {
					// TODO print message
					return null;
				}
				depth = dimension.length;
			}
			positions = checkPositions(arrayRulesList, positionList, engine);
			if (positions == null) {
				if (positionList.forAll(Predicates.isBlank)) {
					if (!defaultValue[0].isPresent()) {
						defaultValue[0] = rule1.arg2();
					} else if (!defaultValue[0].equals(rule1.arg2())) {
						// The left hand side of `2` in `1` doesn't match an int-array of depth `3`.
						IOFunctions.printMessage(S.SparseArray, "posr",
								F.List(arrayRulesList, rule1.arg1(), F.ZZ(depth)), engine);
						return null;
					}
				} else {
					if (positionList.argSize() == depth) {
						// pattern matching
						if (!patternPositionsList(value, rule1, dimension, arrayRulesList, engine)) {
							return null;
						}
					} else {
						// The left hand side of `2` in `1` doesn't match an int-array of depth `3`.
						IOFunctions.printMessage(S.SparseArray, "posr",
								F.List(arrayRulesList, positionList, F.ZZ(depth)), EvalEngine.get());
						return null;
					}
				}
			}
		} else {
			int n = rule1.arg1().toIntDefault();
			if (n > 0) {
				if (dimension == null) {
					depth = 1;
					dimension = new int[depth];
				} else {
					if (dimension.length != 1) {
						// TODO print message
						return null;
					}
					depth = 1;
				}
				positions = new int[1];
				positions[0] = n;
			} else {
				// pattern matching
				if (!patternPositionsList(value, rule1, dimension, arrayRulesList, engine)) {
					return null;
				}
			}
		}

		if (positions != null) {
			if (defaultDimension > 0) {
				for (int i = 0; i < depth; i++) {
					dimension[i] = defaultDimension;
				}
			} else {
				if (determineDimension) {
					for (int i = 0; i < depth; i++) {
						if (positions[i] > dimension[i]) {
							dimension[i] = positions[i];
						}
					}
				}
			}
			value.put(positions, rule1.arg2());
		}
		for (int j = 2; j < arrayRulesList.size(); j++) {
			IExpr arg = arrayRulesList.get(j);
			if (arg.isRule()) {
				IAST rule = (IAST) arg;
				if (rule.arg1().isList()) {
					IAST positionList = (IAST) rule.arg1();
					positions = checkPositions(arrayRulesList, positionList, engine);
					if (positions == null) {
						if (positionList.forAll(Predicates.isBlank)) {
							if (!defaultValue[0].isPresent()) {
								defaultValue[0] = rule.arg2();
								continue;
							} else if (!defaultValue[0].equals(rule.arg2())) {
								// The left hand side of `2` in `1` doesn't match an int-array of depth `3`.
								IOFunctions.printMessage(S.SparseArray, "posr",
										F.List(arrayRulesList, rule.arg1(), F.ZZ(depth)), engine);
								return null;
							}
						} else {
							// The left hand side of `2` in `1` doesn't match an int-array of depth `3`.
							IOFunctions.printMessage(S.SparseArray, "posr",
									F.List(arrayRulesList, rule.arg1(), F.ZZ(depth)), engine);
							return null;
						}
					} else {
						if (positions.length != depth) {
							// The left hand side of `2` in `1` doesn't match an int-array of depth `3`.
							IOFunctions.printMessage(S.SparseArray, "posr",
									F.List(arrayRulesList, rule.arg1(), F.ZZ(depth)), engine);
							return null;
						}
						if (determineDimension) {
							for (int i = 0; i < depth; i++) {
								if (positions[i] > dimension[i]) {
									dimension[i] = positions[i];
								}
							}
						}
						value.putIfAbsent(positions, rule.arg2());
					}
				} else {
					// if (rule.arg1().isList()) {
					// IAST positionList = (IAST) rule.arg1();
					// if (positionList.argSize() == depth) {
					//
					// } else {
					// // The left hand side of `2` in `1` doesn't match an int-array of depth `3`.
					// IOFunctions.printMessage(S.SparseArray, "posr",
					// F.List(arrayRulesList, positionList, F.ZZ(depth)), EvalEngine.get());
					// return null;
					// }
					// } else {
					int n = rule.arg1().toIntDefault();
					if (n > 0) {
						positions = new int[1];
						positions[0] = n;
						if (determineDimension) {
							if (n > dimension[0]) {
								dimension[0] = n;
							}
						}
						value.putIfAbsent(positions, rule.arg2());
					} else {
						// pattern matching
						if (!patternPositionsList(value, rule, dimension, arrayRulesList, engine)) {
							return null;
						}
					}
					// }
				}
			}

		}
		return dimension;
	}

	/**
	 * Determine the sparse array depth from the first entry, which isn't a <code>List(...)</code>.
	 *
	 * @param list
	 * @param count
	 * @return
	 */
	private static int depth(IAST list, int count) {
		if (list.size() > 1) {
			if (list.arg1().isList()) {
				return depth((IAST) list.arg1(), ++count);
			}
			return count;
		}
		return -1;
	}

	/**
	 * Create a sparse array from the array rules list.
	 *
	 * @param arrayRulesList
	 * @param dimension
	 * @param defaultDimension
	 * @param defaultValue
	 *            default value for positions not specified in arrayRulesList. If <code>F.NIL</code> determine from '_'
	 *            (Blank) rule.
	 * @return <code>null</code> if a new <code>SparseArrayExpr</code> cannot be created.
	 */
	public static SparseArrayExpr newArrayRules(IAST arrayRulesList, int[] dimension, int defaultDimension,
			IExpr defaultValue) {
		IExpr[] defValue = new IExpr[] { defaultValue };
		final Trie<int[], IExpr> value = Tries.<IExpr>forInts();
		int[] determinedDimension = createTrie(arrayRulesList, value, dimension, defaultDimension, defValue,
				EvalEngine.get());
		if (determinedDimension != null) {
			return new SparseArrayExpr(value, determinedDimension, defValue[0].orElse(F.C0), false);
		}
		return null;
	}

	/**
	 * Create a sparse array from the dense list representation (for example dense vectors and matrices)
	 *
	 * @param denseList
	 * @param defaultValue
	 *            default value for positions not specified in the dense list representation.
	 * @return <code>null</code> if a new <code>SparseArrayExpr</code> cannot be created.
	 */
	public static SparseArrayExpr newDenseList(IAST denseList, IExpr defaultValue) {
		ArrayList<Integer> dims = LinearAlgebra.dimensions(denseList);
		if (dims != null && dims.size() > 0) {
			defaultValue = defaultValue.orElse(F.C0);
			IAST listOfRules = SparseArrayExpr.arrayRules(denseList, defaultValue);
			if (listOfRules.isPresent()) {
				SparseArrayExpr result = SparseArrayExpr.newArrayRules(listOfRules, null, -1, defaultValue);
				int[] dimension = new int[dims.size()];
				for (int i = 0; i < dims.size(); i++) {
					dimension[i] = dims.get(i);
				}
				result.dimension = dimension;
				return result;
			}
		}
		return null;
	}

	/**
	 * <p>
	 * Create a sparse array from the compressed sparse row (CSR) storage format (input form):
	 * <code>SparseArray(Automatic, dimension, defaultValue, {1,{rowPointers, columnIndiceMatrix}, nonZeroValues})</code>.
	 * </p>
	 * See: <a href="http://netlib.org/utk/papers/templates/node91.html">Netlib - Compressed Row Storage (CRS)</a>
	 *
	 * @param dimension
	 *            the dimension of the sparse array
	 * @param defaultValue
	 *            default value for positions not specified in input form.
	 * @param rowPointers
	 * @param columnIndiceMatrix
	 * @param nonZeroValues
	 * @return <code>null</code> if a new <code>SparseArrayExpr</code> cannot be created.
	 */
	public static SparseArrayExpr newInputForm(int[] dimension, IExpr defaultValue, int[] rowPointers,
			IAST columnIndiceMatrix, IAST nonZeroValues) {
		int first = 0;
		final Trie<int[], IExpr> value = Tries.<IExpr>forInts();
		final int depth = dimension.length;
		int k = 0;
		for (int i = 1; i < columnIndiceMatrix.size(); i++) {
			IAST row = (IAST) columnIndiceMatrix.get(i);
			int[] key = new int[depth];
			if (depth == 1) {
				for (int j = 1; j < row.size(); j++) {
					int p = row.get(j).toIntDefault();
					if (p < 1) {
						return null;
					}
					key[0] = p;
				}
			} else {
				while (rowPointers[k] < i) {
					k++;
					first++;
				}
				key[0] = first;
				for (int j = 1; j < row.size(); j++) {
					int p = row.get(j).toIntDefault();
					if (p < 1) {
						return null;
					}
					key[j] = p;
				}
			}
			value.put(key, nonZeroValues.get(i));

		}
		return new SparseArrayExpr(value, dimension, defaultValue, false);
	}

	private static boolean patternPositionsList(final Trie<int[], IExpr> value, IAST rule, int[] dimension,
			IAST arrayRulesList, EvalEngine engine) {
		if (dimension == null) {
			return false;
		}
		final int depth = dimension.length;
		PatternMatcherAndEvaluator matcher = new PatternMatcherAndEvaluator(rule.arg1(), rule.arg2());
		if (matcher.isRuleWithoutPatterns()) {
			// The left hand side of `2` in `1` doesn't match an int-array of depth `3`.
			IOFunctions.printMessage(S.SparseArray, "posr", F.List(arrayRulesList, rule.arg1(), F.ZZ(depth)),
					EvalEngine.get());
			return false;
		}
		IASTMutable positionList = F.constantArray(F.C1, depth);
		int[] positionsKey = new int[depth];

		IPatternMap patternMap = matcher.getPatternMap();
		IExpr[] patternValuesArray = patternMap.copyPattern();

		recursivePatternPositions(value, dimension, engine, matcher, positionList, 0, positionsKey, patternMap,
				patternValuesArray);

		return true;
	}

	private static void recursivePatternPositions(final Trie<int[], IExpr> value, int[] dimension, EvalEngine engine,
			PatternMatcherAndEvaluator matcher, IASTMutable positionList, int pointer, int[] positionsKey,
			IPatternMap patternMap, IExpr[] patternValuesArray) {
		if (pointer == dimension.length) {
			try {
				IExpr result = matcher.eval(positionList, engine);
				if (result.isPresent()) {
					new MapWrapper<>(value).putIfAbsent(positionsKey.clone(), result);
				}
			} finally {
				patternMap.resetPattern(patternValuesArray);
			}
		} else {
			for (int i = 1; i <= dimension[pointer]; i++) {
				positionsKey[pointer] = i;
				positionList.set(pointer + 1, F.ZZ(i));
				recursivePatternPositions(value, dimension, engine, matcher, positionList, pointer + 1, positionsKey,
						patternMap, patternValuesArray);
			}
		}
	}

	/**
	 * The maximum number of elements this sparse array could contain.
	 *
	 * @param dimension
	 *            assumes dimension contains at least one element.
	 * @return
	 */
	private static int totalSize(int[] dimension) {
		int total = 1;
		for (int i = 0; i < dimension.length; i++) {
			total *= dimension[i];
		}
		return total;
	}

	// private transient IAST normalCache = null;
	/**
	 * Flags for controlling evaluation and left-hand-side pattern-matching expressions
	 *
	 */
	protected int fEvalFlags = 0;

	/**
	 * The dimension of the sparse array.
	 */
	int[] dimension;

	/**
	 * The default value for the positions with no entry in the map. Usually <code>0</code>.
	 */
	IExpr defaultValue;

	/**
	 * Constructor for serialization.
	 */
	public SparseArrayExpr() {
		super(S.SparseArray, null);
	}

	/**
	 * Copy constructor. See <a href="https://en.wikipedia.org/wiki/Trie">Wikipedia - Trie</a>.
	 *
	 * @param trie
	 *            map positions of a sparse array to a value
	 * @param dimension
	 *            the dimensions of the positions
	 * @param defaultValue
	 *            default value for positions not specified in the trie
	 * @param deepCopy
	 *            if <code>true</code> create a deep copy.
	 */
	protected SparseArrayExpr(final Trie<int[], IExpr> trie, int[] dimension, IExpr defaultValue, boolean deepCopy) {
		super(S.SparseArray, trie);
		if (deepCopy) {
			this.fData = Tries.<IExpr>forInts();
			for (TrieNode<int[], IExpr> entry : trie.nodeSet()) {
				int[] key = entry.getKey();
				int[] newKey = new int[key.length];
				System.arraycopy(key, 0, newKey, 0, key.length);
				this.fData.put(newKey, entry.getValue());
			}
			this.dimension = new int[dimension.length];
			System.arraycopy(dimension, 0, this.dimension, 0, dimension.length);
			this.defaultValue = defaultValue;
		} else {
			this.dimension = dimension;
			this.defaultValue = defaultValue;
		}
		// this.addEvalFlags(IAST.SEQUENCE_FLATTENED);
	}

	/** {@inheritDoc} */
	@Override
	public final ISparseArray addEvalFlags(final int i) {
		fEvalFlags |= i;
		return this;
	}

	/**
	 * Convert this sparse array to array rules list format.
	 */
	@Override
	public IAST arrayRules() {
		IASTAppendable result = F.ListAlloc(fData.size() + 1);

		for (TrieNode<int[], IExpr> entry : fData.nodeSet()) {
			int[] key = entry.getKey();
			IExpr value = entry.getValue();
			IAST lhs = F.ast(S.List, key);
			result.append(F.Rule(lhs, value));
		}
		result.append(F.Rule(F.constantArray(F.$b(), dimension.length), defaultValue));
		return result;
	}

	@Override
	public SparseArrayExpr copy() {
		return new SparseArrayExpr(fData, dimension, defaultValue, true);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof SparseArrayExpr) {
			SparseArrayExpr s = (SparseArrayExpr) obj;
			if (Arrays.equals(dimension, s.dimension) && //
					defaultValue.equals(s.defaultValue)) {
				Trie<int[], IExpr> sData = s.fData;
				if (fData.size() == sData.size()) {
					for (TrieNode<int[], IExpr> entry : fData.nodeSet()) {
						int[] sequence = entry.getKey();
						IExpr sValue = sData.get(sequence);
						if (sValue == null) {
							return false;
						}
						IExpr value = entry.getValue();
						if (!value.equals(sValue)) {
							return false;
						}
					}
					return true;
				}
			}
		}
		return false;
	}

	/** {@inheritDoc} */
	@Override
	public IExpr evaluate(EvalEngine engine) {
		if (isEvalFlagOff(IAST.BUILT_IN_EVALED)) {
			boolean evaled = false;
			IExpr newDefaultValue = defaultValue;
			IExpr temp = engine.evaluateNull(defaultValue);
			if (temp.isPresent()) {
				evaled = true;
				newDefaultValue = temp;
			}
			final Trie<int[], IExpr> trie = Tries.<IExpr>forInts();
			for (TrieNode<int[], IExpr> entry : fData.nodeSet()) {
				IExpr value = entry.getValue();
				temp = engine.evaluateNull(value);
				if (temp.isPresent()) {
					evaled = true;
					trie.put(entry.getKey(), temp);
				} else {
					trie.put(entry.getKey(), value);
				}
			}
			if (evaled) {
				SparseArrayExpr result = new SparseArrayExpr(trie, dimension, newDefaultValue, false);
				result.addEvalFlags(IAST.BUILT_IN_EVALED);
				return result;
			}
			addEvalFlags(IAST.BUILT_IN_EVALED);
		}
		return F.NIL;
	}

	@Override
	public ISparseArray flatten() {
		if (dimension.length <= 1) {
			return this;
		}
		int vectorDim = totalSize(dimension);
		int[] offsets = new int[dimension.length];
		int val = dimension[dimension.length - 1];
		for (int i = offsets.length - 1; i >= 0; i--) {
			offsets[i] = val;
			if (i > 0) {
				val *= dimension[i - 1];
			}
		}
		final Trie<int[], IExpr> result = Tries.<IExpr>forInts();
		for (TrieNode<int[], IExpr> entry : fData.nodeSet()) {
			int[] key = entry.getKey();
			int keyDim = key[key.length - 1];
			for (int i = 0; i < key.length - 1; i++) {
				keyDim += (key[i] - 1) * offsets[i + 1];
			}
			result.put(new int[] { keyDim }, entry.getValue());
		}

		return new SparseArrayExpr(result, new int[] { vectorDim }, defaultValue, false);

	}

	/**
	 * <p>
	 * For the FullForm create a compressed sparse row (CSR) representation internally:
	 * <code>SparseArray(Automatic, dimension, defaultValue, {1,{rowPointers, columnIndiceMatrix}, nonZeroValues})</code>.
	 * </p>
	 * See: <a href="http://netlib.org/utk/papers/templates/node91.html">Netlib - Compressed Row Storage (CRS)</a>
	 */
	@Override
	public String fullFormString() {
		IAST dimensionList = F.ast(S.List, dimension);
		IASTAppendable result = F.ast(S.SparseArray, 6, false);
		result.append(S.Automatic);
		result.append(dimensionList);
		result.append(defaultValue);
		// create compressed sparse row (CSR) storage format (input form):
		// SparseArray(Automatic, dimension, defaultValue, {1,{rowPointers, columnIndiceMatrix}, nonZeroValues})
		IASTAppendable list1 = F.ListAlloc(4);
		result.append(list1);
		list1.append(F.C1);

		IASTAppendable subList = F.ListAlloc(2);
		list1.append(subList);
		IASTAppendable rowPointers = F.ListAlloc(fData.size());
		subList.append(rowPointers);
		IASTAppendable columnIndiceMatrix = F.ListAlloc(fData.size());
		subList.append(columnIndiceMatrix);
		IASTAppendable nonZeroValues = F.ListAlloc(fData.size());

		int columnIndex = 0;
		int rowCounter = 0;
		if (dimension.length > 1) {
			// matrix, general case
			for (TrieNode<int[], IExpr> entry : fData.nodeSet()) {
				int[] key = entry.getKey();
				int row = key[0];
				while (rowCounter < row) {
					rowPointers.append(F.ZZ(columnIndex));
					rowCounter++;
				}
				columnIndex++;
				int[] newKey = new int[key.length - 1];
				System.arraycopy(key, 1, newKey, 0, newKey.length);
				IAST indice = F.ast(S.List, newKey);
				columnIndiceMatrix.append(indice);
				nonZeroValues.append(entry.getValue());
			}
		} else {
			// vector case
			rowPointers.append(F.ZZ(columnIndex));
			for (TrieNode<int[], IExpr> entry : fData.nodeSet()) {
				int[] key = entry.getKey();
				columnIndex++;
				IAST indice = F.ast(S.List, key);
				columnIndiceMatrix.append(indice);
				nonZeroValues.append(entry.getValue());
			}
		}
		rowPointers.append(F.ZZ(columnIndex));
		list1.append(nonZeroValues);
		return result.fullFormString();
	}

	@Override
	public IExpr get(int position) {
		int[] dims = getDimension();

		final int partSize = 1;

		int len = 0;
		int[] partIndex = new int[dims.length];
		int count = 0;
		partIndex[0] = position;

		for (int i = partSize; i < dims.length; i++) {
			partIndex[i] = -1;
			count++;
		}
		if (count == 0 && partSize == dims.length) {
			IExpr temp = fData.get(partIndex);
			if (temp == null) {
				return defaultValue;
			}
			return temp;
		}
		int[] newDimension = new int[count];
		count = 0;
		for (int i = 0; i < partIndex.length; i++) {
			if (partIndex[i] == (-1)) {
				len++;
				newDimension[count++] = dims[i];
			}
		}
		final Trie<int[], IExpr> value = Tries.<IExpr>forInts();
		for (TrieNode<int[], IExpr> entry : fData.nodeSet()) {
			int[] key = entry.getKey();
			boolean evaled = true;
			for (int i = 0; i < partIndex.length; i++) {
				if (partIndex[i] == (-1)) {
					continue;
				}
				if (partIndex[i] != key[i]) {
					evaled = false;
					break;
				}
			}
			if (evaled) {
				int[] newKey = new int[len];
				int j = 0;
				for (int i = 0; i < partIndex.length; i++) {
					if (partIndex[i] == (-1)) {
						newKey[j++] = key[i];
					}
				}
				value.put(newKey, entry.getValue());
			}
		}
		return new SparseArrayExpr(value, newDimension, defaultValue.orElse(F.C0), false);

	}

	@Override
	public IExpr getDefaultValue() {
		return defaultValue;
	}

	@Override
	public int[] getDimension() {
		return dimension;
	}

	@Override
	public IExpr getPart(IAST ast, int startPosition) {
		int[] dims = getDimension();

		final int partSize = ast.size() - startPosition;
		if (dims.length >= partSize) {

			int len = 0;
			int[] partIndex = new int[dims.length];
			int count = 0;
			for (int i = startPosition; i < ast.size(); i++) {
				partIndex[i - startPosition] = ast.get(i).toIntDefault(-1);
				if (partIndex[i - startPosition] == -1) {
					count++;
				} else if (partIndex[i - startPosition] > dims[i - startPosition] || //
						partIndex[i - startPosition] <= 0) {
					return IOFunctions.printMessage(S.Part, "partw", F.List(ast.get(i), ast), EvalEngine.get());
				}
			}
			for (int i = partSize; i < dims.length; i++) {
				partIndex[i] = -1;
				count++;
			}
			if (count == 0 && partSize == dims.length) {
				IExpr temp = fData.get(partIndex);
				if (temp == null) {
					return defaultValue;
				}
				return temp;
			}
			int[] newDimension = new int[count];
			count = 0;
			for (int i = 0; i < partIndex.length; i++) {
				if (partIndex[i] == (-1)) {
					len++;
					newDimension[count++] = dims[i];
				}
			}
			final Trie<int[], IExpr> value = Tries.<IExpr>forInts();
			for (TrieNode<int[], IExpr> entry : fData.nodeSet()) {
				int[] key = entry.getKey();
				boolean evaled = true;
				for (int i = 0; i < partIndex.length; i++) {
					if (partIndex[i] == (-1)) {
						continue;
					}
					if (partIndex[i] != key[i]) {
						evaled = false;
						break;
					}
				}
				if (evaled) {
					int[] newKey = new int[len];
					int j = 0;
					for (int i = 0; i < partIndex.length; i++) {
						if (partIndex[i] == (-1)) {
							newKey[j++] = key[i];
						}
					}
					value.put(newKey, entry.getValue());
				}
			}
			return new SparseArrayExpr(value, newDimension, defaultValue.orElse(F.C0), false);

		}
		return IOFunctions.printMessage(S.Part, "partd", F.List(ast), EvalEngine.get());

	}

	@Override
	public int hashCode() {
		return (fData == null) ? 541 : 541 + fData.size() + defaultValue.hashCode();
	}

	@Override
	public ISymbol head() {
		return S.SparseArray;
	}

	@Override
	public int hierarchy() {
		return SPARSEARRAYID;
	}

	@Override
	public int[] isMatrix(boolean setMatrixFormat) {
		return (dimension.length == 2) ? dimension : null;
	}

	@Override
	public boolean isSparseArray() {
		return true;
	}

	@Override
	public int isVector() {
		return (dimension.length == 1) ? dimension[0] : -1;
	}

	@Override
	public ISparseArray join(ISparseArray that) {
		SparseArrayExpr thatArray = (SparseArrayExpr) that;
		SparseArrayExpr result = copy();
		int rowDimension = result.dimension[0];
		for (TrieNode<int[], IExpr> entry : thatArray.fData.nodeSet()) {
			int[] key = entry.getKey();
			int[] newKey = new int[key.length];
			System.arraycopy(key, 0, newKey, 0, key.length);
			newKey[0] += rowDimension;
			result.fData.put(newKey, entry.getValue());
		}
		result.dimension[0] += thatArray.dimension[0];
		// result.normalCache = null;
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public SparseArrayExpr map(final Function<IExpr, IExpr> function) {
		SparseArrayExpr result = copy();
		for (TrieNode<int[], IExpr> entry : result.fData.nodeSet()) {
			IExpr value = entry.getValue();
			IExpr temp = function.apply(value);
			if (temp.isPresent()) {
				result.fData.put(entry.getKey(), temp);
			}
		}
		IExpr temp = function.apply(result.defaultValue);
		if (temp.isPresent()) {
			result.defaultValue = temp;
		}
		return result;
	}

	/**
	 * <p>
	 * This method assumes that <code>this</code> is a list of lists in matrix form. It combines the column values in a
	 * list as argument for the given <code>function</code>.
	 * </p>
	 * <b>Example</b> a matrix <code>{{x1, y1,...}, {x2, y2, ...}, ...}</code> will be converted to
	 * <code>{f.apply({x1, x2,...}), f.apply({y1, y2, ...}), ...}</code>
	 *
	 * @param dim
	 *            the dimension of the matrix
	 * @param f
	 *            a unary function
	 * @return
	 */
	@Override
	public IExpr mapMatrixColumns(int[] dim, Function<IExpr, IExpr> f) {
		// TODO improve performance; return a sparse array?
		IAST matrix = normal(false);
		return matrix.mapMatrixColumns(dim, f);
	}

	/** {@inheritDoc} */
	@Override
	public final SparseArrayExpr mapThread(final IAST replacement, final int position) {
		final Function<IExpr, IExpr> function = new Function<IExpr, IExpr>() {
			@Override
			public IExpr apply(IExpr x) {
				return replacement.setAtCopy(position, x);
			}
		};
		return map(function);
	}

	@Override
	public IASTMutable normal(boolean nilIfUnevaluated) {
		if (dimension.length > 0) {
			return normalAppendable(S.List, dimension);
			// if (normalCache != null) {
			// return normalCache;
			// }
			// IASTAppendable list = normalAppendable(S.List, dimension);
			// normalCache = list;
			// return normalCache;
		}
		return F.headAST0(S.List);
	}

	@Override
	public IASTMutable normal(int[] dims) {
		return normalAppendable(S.List, dims);
	}

	private void normal(Trie<int[], IExpr> map, IASTMutable list, int[] dims, int position, int[] index) {
		if (dims.length - 1 == position) {
			int size = dims[position];
			for (int i = 1; i <= size; i++) {
				index[position] = i;
				IExpr expr = map.get(index);
				if (expr == null) {
					list.set(i, defaultValue);
				} else {
					list.set(i, expr);
				}
			}
			return;
		}
		int size1 = dims[position];
		int size2 = dims[position + 1];
		for (int i = 1; i <= size1; i++) {
			index[position] = i;
			IASTAppendable currentList = F.ast(S.List, size2, true);
			list.set(i, currentList);
			normal(map, currentList, dims, position + 1, index);
		}
	}

	private IASTAppendable normalAppendable(IExpr head, int[] dims) {
		IASTAppendable list = F.ast(head, dims[0], true);
		int[] index = new int[dims.length];
		for (int i = 0; i < index.length; i++) {
			index[i] = 1;
		}
		normal(fData, list, dims, 0, index);
		return list;
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		defaultValue = (IExpr) in.readObject();
		final int len = in.readInt();
		dimension = new int[len];
		for (int i = 0; i < len; i++) {
			dimension[i] = in.readInt();
		}
		IAST arrayRulesList = (IAST) in.readObject();
		fData = Tries.<IExpr>forInts();
		IExpr[] defValue = new IExpr[] { defaultValue };
		int[] determinedDimension = createTrie(arrayRulesList, fData, null, -1, defValue, EvalEngine.get());
		if (determinedDimension == null) {
			throw new java.io.InvalidClassException("no valid Trie creation");
		}
	}

	public IExpr set(int i, IExpr value) {
		if (dimension.length == 1 && i > 0 && i <= dimension[0]) {
			int[] positions = new int[1];
			positions[0] = i;
			IExpr old = fData.get(positions);
			fData.put(positions, value);
			return (old == null) ? defaultValue : old;
		}
		throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + dimension[0]);
	}

	@Override
	public int size() {
		return dimension[0];
	}

	/** {@inheritDoc} */
	@Override
	public double[][] toDoubleMatrix() {
		if (dimension.length == 2 && dimension[0] > 0 && dimension[1] > 0) {
			try {
				double[][] result = new double[dimension[0]][dimension[1]];
				if (!defaultValue.isZero()) {
					double d = defaultValue.evalDouble();
					for (int i = 0; i < dimension[0]; i++) {
						for (int j = 0; j < dimension[1]; j++) {
							result[i][j] = d;
						}
					}
				}
				for (TrieNode<int[], IExpr> entry : fData.nodeSet()) {
					int[] key = entry.getKey();
					IExpr value = entry.getValue();
					result[key[0] - 1][key[1] - 1] = value.evalDouble();
				}
				return result;
			} catch (ArgumentTypeException rex) {

			}
		}
		return null;
	}

	/** {@inheritDoc} */
	@Override
	public double[] toDoubleVector() {
		if (dimension.length == 1 && dimension[0] > 0) {
			try {
				double[] result = new double[dimension[0]];
				if (!defaultValue.isZero()) {
					double d = defaultValue.evalDouble();
					for (int i = 0; i < result.length; i++) {
						result[i] = d;
					}
				}
				for (TrieNode<int[], IExpr> entry : fData.nodeSet()) {
					int[] key = entry.getKey();
					IExpr value = entry.getValue();
					result[key[0] - 1] = value.evalDouble();
				}
				return result;
			} catch (ArgumentTypeException rex) {

			}
		}
		return null;
	}

	@Override
	public FieldMatrix<IExpr> toFieldMatrix(boolean copyArray) {
		if (dimension.length == 2 && dimension[0] > 0 && dimension[1] > 0) {
			return new SparseExprMatrix(this, copyArray);
		}
		return null;
	}

	@Override
	public FieldVector<IExpr> toFieldVector(boolean copyArray) {
		if (dimension.length == 1 && dimension[0] > 0) {
			return new SparseExprVector(this, copyArray);
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuilder buf = new StringBuilder();
		buf.append("SparseArray(Number of elements: ");
		buf.append(fData.size());
		buf.append(" Dimensions: {");
		for (int i = 0; i < dimension.length; i++) {
			buf.append(dimension[i]);
			if (i < dimension.length - 1) {
				buf.append(",");
			}
		}
		buf.append("} Default value: ");
		buf.append(defaultValue.toString());
		buf.append(")");
		return buf.toString();
	}

	@Override
	public IExpr total(IExpr head) {
		if (head.equals(S.Plus) && defaultValue.isZero()) {
			IASTAppendable result = F.PlusAlloc(fData.size());
			for (TrieNode<int[], IExpr> entry : fData.nodeSet()) {
				result.append(entry.getValue());
			}
			return result;
		}
		IASTAppendable result = F.ast(head, totalSize(dimension), false);
		return totalAppendable(result);
	}

	private void total(Trie<int[], IExpr> map, int[] dimension, int position, int[] index, IASTAppendable result) {
		if (dimension.length - 1 == position) {
			int size = dimension[position];
			for (int i = 1; i <= size; i++) {
				index[position] = i;
				IExpr expr = map.get(index);
				if (expr == null) {
					result.append(defaultValue);
				} else {
					result.append(expr);
				}
			}
			return;
		}
		int size1 = dimension[position];
		for (int i = 1; i <= size1; i++) {
			index[position] = i;
			total(map, dimension, position + 1, index, result);
		}
	}

	private IASTAppendable totalAppendable(IASTAppendable result) {
		int[] index = new int[dimension.length];
		for (int i = 0; i < index.length; i++) {
			index[i] = 1;
		}
		total(fData, dimension, 0, index, result);
		return result;
	}

	@Override
	public void writeExternal(ObjectOutput output) throws IOException {
		output.writeObject(defaultValue);
		output.writeInt(dimension.length);
		for (int i = 0; i < dimension.length; i++) {
			output.writeInt(dimension[i]);
		}
		IAST rules = arrayRules();
		output.writeObject(rules);
	}
}
