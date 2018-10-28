package org.hipparchus.stat.descriptive;

import org.hipparchus.exception.LocalizedCoreFormats;
import org.hipparchus.exception.MathIllegalArgumentException;
import org.hipparchus.util.MathUtils;

public abstract class UnivariateStatisticImpl implements UnivariateStatistic {
    /**
     * Returns the result of evaluating the statistic over the input array.
     * <p>
     * The default implementation delegates to
     * <code>evaluate(double[], int, int)</code> in the natural way.
     *
     * @param values input array
     * @return the value of the statistic applied to the input array
     * @throws MathIllegalArgumentException if values is null
     */
    @Override
    public double evaluate(double[] values) throws MathIllegalArgumentException {
        MathUtils.checkNotNull(values, LocalizedCoreFormats.INPUT_ARRAY);
        return evaluate(values, 0, values.length);
    }

}
