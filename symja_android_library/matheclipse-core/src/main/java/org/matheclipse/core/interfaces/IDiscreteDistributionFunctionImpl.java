package org.matheclipse.core.interfaces;

import org.matheclipse.core.builtin.StatisticsFunctions;
import org.matheclipse.core.eval.util.Assumptions;
import org.matheclipse.core.eval.util.IAssumptions;

public abstract class IDiscreteDistributionFunctionImpl extends IDistributionFunctionImpl
        implements IDiscreteDistribution, StatisticsFunctions.IPDF {

    @Override
    public int[] range(IExpr discreteDistribution, IExpr predicate, IExpr x) {
        IAssumptions assumptions = Assumptions.getInstance(predicate);
        if (assumptions != null) {
            int[] result = new int[]{getSupportLowerBound(discreteDistribution),
                    getSupportUpperBound(discreteDistribution)};
            return assumptions.reduceRange(x, result);
        }
        return null;
    }

    /**
     * The lower bound of the support is 0 by default.
     *
     * @param discreteDistribution
     * @return lower bound of the support (always 0)
     */
    @Override
    public int getSupportLowerBound(IExpr discreteDistribution) {
        return 0;
    }

    /**
     * The upper bound of the support is positive infinity, regardless of the parameter values. There is no integer
     * infinity, so this method returns {@code Integer.MAX_VALUE}.
     *
     * @param discreteDistribution
     * @return upper bound of the support (always {@code Integer.MAX_VALUE} for positive infinity)
     */
    @Override
    public int getSupportUpperBound(IExpr discreteDistribution) {
        return Integer.MAX_VALUE;
    }

}
