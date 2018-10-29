package org.matheclipse.core.interfaces;

public interface IDiscreteDistribution extends IDistribution {
    /**
     * Return the distributions lower and upper bounds reduced by the predicate's assumptions.
     *
     * @param discreteDistribution
     * @param predicate
     * @param x
     * @return <code>null</code> if no interval could be determined
     */
    int[] range(IExpr discreteDistribution, IExpr predicate, IExpr x);

    /**
     * The lower bound of the support is 0 by default.
     *
     * @param discreteDistribution
     * @return lower bound of the support (always 0)
     */
    int getSupportLowerBound(IExpr discreteDistribution);

    /**
     * The upper bound of the support is positive infinity, regardless of the parameter values. There is no integer
     * infinity, so this method returns {@code Integer.MAX_VALUE}.
     *
     * @param discreteDistribution
     * @return upper bound of the support (always {@code Integer.MAX_VALUE} for positive infinity)
     */
    int getSupportUpperBound(IExpr discreteDistribution);

    // default IExpr pEquals(int n, IExpr discreteDistribution) {
    // if (n < getSupportLowerBound(discreteDistribution)) {
    // return F.C0;
    // }
    // return protectedPEquals(n, discreteDistribution);
    // }
    //
    // /**
    // * @param n
    // * with n >= lowerBound()
    // * @return P(X == n), i.e. probability of random variable X == n
    // */
    // default IExpr protectedPEquals(int n, IExpr discreteDistribution) {
    // return null;
    // }
}