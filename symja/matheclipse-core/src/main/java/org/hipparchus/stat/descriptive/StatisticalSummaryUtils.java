package org.hipparchus.stat.descriptive;

import org.hipparchus.util.MathUtils;

import java.util.Arrays;

public class StatisticalSummaryUtils {
    /**
     * Computes aggregated statistical summaries.
     * <p>
     * This method can be used to combine statistics computed over partitions or
     * subsamples - i.e., the returned StatisticalSummary should contain
     * the same values that would have been obtained by computing a single
     * StatisticalSummary over the combined dataset.
     *
     * @param statistics StatisticalSummary instances to aggregate
     * @return summary statistics for the combined dataset
     * @throws org.hipparchus.exception.NullArgumentException if the input is null
     */
    static StatisticalSummary aggregate(StatisticalSummary... statistics) {
        MathUtils.checkNotNull(statistics);
        return aggregate(Arrays.asList(statistics));
    }


    /**
     * Computes aggregated statistical summaries.
     * <p>
     * This method can be used to combine statistics computed over partitions or
     * subsamples - i.e., the returned StatisticalSummary should contain
     * the same values that would have been obtained by computing a single
     * StatisticalSummary over the combined dataset.
     *
     * @param statistics iterable of StatisticalSummary instances to aggregate
     * @return summary statistics for the combined dataset
     * @throws org.hipparchus.exception.NullArgumentException if the input is null
     */
    static StatisticalSummary aggregate(Iterable<? extends StatisticalSummary> statistics) {
        MathUtils.checkNotNull(statistics);

        long n = 0;
        double min = Double.NaN;
        double max = Double.NaN;
        double sum = Double.NaN;
        double mean = Double.NaN;
        double m2 = Double.NaN;

        for (StatisticalSummary current : statistics) {
            if (current.getN() == 0) {
                continue;
            }

            if (n == 0) {
                n = current.getN();
                min = current.getMin();
                sum = current.getSum();
                max = current.getMax();
                m2 = current.getVariance() * (n - 1);
                mean = current.getMean();
            } else {
                if (current.getMin() < min) {
                    min = current.getMin();
                }
                if (current.getMax() > max) {
                    max = current.getMax();
                }

                sum += current.getSum();
                final double oldN = n;
                final double curN = current.getN();
                n += curN;
                final double meanDiff = current.getMean() - mean;
                mean = sum / n;
                final double curM2 = current.getVariance() * (curN - 1d);
                m2 = m2 + curM2 + meanDiff * meanDiff * oldN * curN / n;
            }
        }

        final double variance = n == 0 ? Double.NaN :
                n == 1 ? 0d :
                        m2 / (n - 1);

        return new StatisticalSummaryValues(mean, variance, n, max, min, sum);
    }

}
