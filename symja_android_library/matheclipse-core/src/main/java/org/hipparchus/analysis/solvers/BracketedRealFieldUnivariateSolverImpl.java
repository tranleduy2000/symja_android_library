package org.hipparchus.analysis.solvers;

import org.hipparchus.RealFieldElement;
import org.hipparchus.analysis.RealFieldUnivariateFunction;
import org.hipparchus.exception.MathIllegalArgumentException;
import org.hipparchus.exception.MathIllegalStateException;

public abstract class BracketedRealFieldUnivariateSolverImpl<T extends RealFieldElement<T>> implements BracketedRealFieldUnivariateSolver<T> {
    /**
     * Solve for a zero in the given interval and return a tolerance interval surrounding
     * the root.
     * <p>
     * <p> It is required that the starting interval brackets a root.
     *
     * @param maxEval Maximum number of evaluations.
     * @param f       Function to solve.
     * @param min     Lower bound for the interval. f(min) != 0.0.
     * @param max     Upper bound for the interval. f(max) != 0.0.
     * @return an interval [ta, tb] such that for some t in [ta, tb] f(t) == 0.0 or has a
     * step wise discontinuity that crosses zero. Both end points also satisfy the
     * convergence criteria so either one could be used as the root. That is the interval
     * satisfies the condition (| tb - ta | <= {@link #getAbsoluteAccuracy() absolute}
     * accuracy + max(ta, tb) * {@link #getRelativeAccuracy() relative} accuracy) or (
     * max(|f(ta)|, |f(tb)|) <= {@link #getFunctionValueAccuracy()}) or there are no
     * numbers in the field between ta and tb. The width of the interval (tb - ta) may be
     * zero.
     * @throws MathIllegalArgumentException if the arguments do not satisfy the
     *                                      requirements specified by the solver.
     * @throws MathIllegalStateException    if the allowed number of evaluations is
     *                                      exceeded.
     */
    public Interval<T> solveInterval(int maxEval,
                                     RealFieldUnivariateFunction<T> f,
                                     T min,
                                     T max)
            throws MathIllegalArgumentException, MathIllegalStateException {
        return this.solveInterval(maxEval, f, min, max, min.add(max.subtract(min).multiply(0.5)));
    }


}
