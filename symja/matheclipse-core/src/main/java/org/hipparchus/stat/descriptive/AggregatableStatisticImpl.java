package org.hipparchus.stat.descriptive;

import org.hipparchus.util.MathUtils;

public abstract class AggregatableStatisticImpl<T> implements AggregatableStatistic<T> {
    /**
     * Aggregates the results from the provided instances into this instance.
     * <p>
     * This method can be used to combine statistics computed over partitions or
     * subsamples - i.e., the value of this instance after this operation should
     * be the same as if a single statistic would have been applied over the
     * combined dataset.
     *
     * @param others the other instances to aggregate into this instance
     * @throws NullArgumentException if either others or any instance is null
     */
    @SuppressWarnings("unchecked")
    public void aggregate(T... others) {
        MathUtils.checkNotNull(others);
        for (T other : others) {
            aggregate(other);
        }
    }

    /**
     * Aggregates the results from the provided instances into this instance.
     * <p>
     * This method can be used to combine statistics computed over partitions or
     * subsamples - i.e., the value of this instance after this operation should
     * be the same as if a single statistic would have been applied over the
     * combined dataset.
     *
     * @param others the other instances to aggregate into this instance
     * @throws NullArgumentException if either others or any instance is null
     */
    public void aggregate(Iterable<T> others) {
        MathUtils.checkNotNull(others);
        for (T other : others) {
            aggregate(other);
        }
    }
}
