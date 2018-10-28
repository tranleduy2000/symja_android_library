package org.hipparchus.analysis.solvers;

import org.hipparchus.analysis.UnivariateFunction;
import org.hipparchus.exception.MathIllegalArgumentException;
import org.hipparchus.exception.MathIllegalStateException;

public abstract class BracketedUnivariateSolverUnivariateFunction
        extends AbstractUnivariateSolver
        implements BracketedUnivariateSolver<UnivariateFunction> {
    protected BracketedUnivariateSolverUnivariateFunction(double absoluteAccuracy) {
        super(absoluteAccuracy);
    }

    protected BracketedUnivariateSolverUnivariateFunction(double relativeAccuracy, double absoluteAccuracy) {
        super(relativeAccuracy, absoluteAccuracy);
    }

    protected BracketedUnivariateSolverUnivariateFunction(double relativeAccuracy, double absoluteAccuracy, double functionValueAccuracy) {
        super(relativeAccuracy, absoluteAccuracy, functionValueAccuracy);
    }

    /**
     * Solve for a zero in the given interval and return a tolerance interval surrounding
     * the root.
     * <p>
     * <p> It is required that the starting interval brackets a root or that the function
     * value at either end point is 0.0.
     *
     * @param maxEval Maximum number of evaluations.
     * @param f       Function to solve.
     * @param min     Lower bound for the interval.
     * @param max     Upper bound for the interval. Must be greater than {@code min}.
     * @return an interval [ta, tb] such that for some t in [ta, tb] f(t) == 0.0 or has a
     * step wise discontinuity that crosses zero. Both end points also satisfy the
     * convergence criteria so either one could be used as the root. That is the interval
     * satisfies the condition (| tb - ta | <= {@link #getAbsoluteAccuracy() absolute}
     * accuracy + max(ta, tb) * {@link #getRelativeAccuracy() relative} accuracy) or (
     * max(|f(ta)|, |f(tb)|) <= {@link #getFunctionValueAccuracy()}) or there are no
     * floating point numbers between ta and tb. The width of the interval (tb - ta) may
     * be zero.
     * @throws MathIllegalArgumentException if the arguments do not satisfy the
     *                                      requirements specified by the solver.
     * @throws MathIllegalStateException    if the allowed number of evaluations is
     *                                      exceeded.
     */
    public Interval solveInterval(int maxEval, UnivariateFunction f, double min, double max)
            throws MathIllegalArgumentException, MathIllegalStateException {
        return this.solveInterval(maxEval, f, min, max, min + 0.5 * (max - min));
    }
}
