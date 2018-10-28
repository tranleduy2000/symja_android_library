package org.hipparchus.stat.descriptive;

import org.hipparchus.exception.LocalizedCoreFormats;
import org.hipparchus.exception.MathIllegalArgumentException;
import org.hipparchus.util.MathArrays;
import org.hipparchus.util.MathUtils;

public abstract class StorelessUnivariateStatisticImpl
        extends UnivariateStatisticImpl
        implements StorelessUnivariateStatistic {
    /**
     * {@inheritDoc}
     * <p>
     * The default implementation creates a copy of this {@link StorelessUnivariateStatistic}
     * instance, calls {@link #clear} on it, then calls {@link #incrementAll} with the specified
     * portion of the input array, and then uses {@link #getResult} to compute the return value.
     * <p>
     * Note that this implementation does not change the internal state of the statistic.
     * <p>
     * Implementations may override this method with a more efficient and possibly more
     * accurate implementation that works directly with the input array.
     *
     * @param values the input array
     * @param begin  the index of the first element to include
     * @param length the number of elements to include
     * @return the value of the statistic applied to the included array entries
     * @throws MathIllegalArgumentException if the array is null or the indices are not valid
     * @see UnivariateStatistic#evaluate(double[], int, int)
     */
    @Override
    public double evaluate(final double[] values, final int begin, final int length)
            throws MathIllegalArgumentException {

        if (MathArrays.verifyValues(values, begin, length)) {
            StorelessUnivariateStatistic stat = copy();
            stat.clear();
            stat.incrementAll(values, begin, length);
            return stat.getResult();
        }
        return Double.NaN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(double value) {
        increment(value);
    }

    /**
     * Updates the internal state of the statistic to reflect addition of
     * all values in the values array. Does not clear the statistic first --
     * i.e., the values are added <strong>incrementally</strong> to the dataset.
     * <p>
     * The default implementation delegates to
     * <code>incrementAll(double[], int, int)</code> in the natural way.
     *
     * @param values array holding the new values to add
     * @throws MathIllegalArgumentException if the array is null
     */
    public void incrementAll(double[] values) throws MathIllegalArgumentException {
        MathUtils.checkNotNull(values, LocalizedCoreFormats.INPUT_ARRAY);
        incrementAll(values, 0, values.length);
    }


    /**
     * Updates the internal state of the statistic to reflect addition of
     * the values in the designated portion of the values array.  Does not
     * clear the statistic first -- i.e., the values are added
     * <strong>incrementally</strong> to the dataset.
     * <p>
     * The default implementation just calls {@link #increment} in a loop over
     * the specified portion of the input array.
     *
     * @param values array holding the new values to add
     * @param start  the array index of the first value to add
     * @param length the number of elements to add
     * @throws MathIllegalArgumentException if the array is null or the index
     */
    public void incrementAll(double[] values, int start, int length)
            throws MathIllegalArgumentException {

        if (MathArrays.verifyValues(values, start, length)) {
            int k = start + length;
            for (int i = start; i < k; i++) {
                increment(values[i]);
            }
        }
    }


}
