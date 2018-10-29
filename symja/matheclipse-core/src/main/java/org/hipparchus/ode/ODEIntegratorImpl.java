package org.hipparchus.ode;

import org.hipparchus.exception.LocalizedCoreFormats;
import org.hipparchus.exception.MathIllegalArgumentException;
import org.hipparchus.exception.MathIllegalStateException;

public abstract class ODEIntegratorImpl implements ODEIntegrator {
    /**
     * Integrate the differential equations up to the given time.
     * <p>This method solves an Initial Value Problem (IVP).</p>
     * <p>Since this method stores some internal state variables made
     * available in its public interface during integration ({@link
     * #getCurrentSignedStepsize()}), it is <em>not</em> thread-safe.</p>
     *
     * @param equations    differential equations to integrate
     * @param initialState initial state (time, primary and secondary state vectors)
     * @param finalTime    target time for the integration
     *                     (can be set to a value smaller than {@code t0} for backward integration)
     * @return final state, its time will be the same as {@code finalTime} if
     * integration reached its target, but may be different if some {@link
     * ODEEventHandler} stops it at some point.
     * @throws MathIllegalArgumentException if integration step is too small
     * @throws MathIllegalStateException    if the number of functions evaluations is exceeded
     * @throws MathIllegalArgumentException if the location of an event cannot be bracketed
     */
    public ODEStateAndDerivative integrate(OrdinaryDifferentialEquation equations,
                                           ODEState initialState, double finalTime)
            throws MathIllegalArgumentException, MathIllegalStateException {
        return integrate(new ExpandableODE(equations), initialState, finalTime);
    }

    /**
     * Integrate the differential equations up to the given time.
     * <p>This method solves an Initial Value Problem (IVP).</p>
     * <p>Since this method stores some internal state variables made
     * available in its public interface during integration ({@link
     * #getCurrentSignedStepsize()}), it is <em>not</em> thread-safe.</p>
     *
     * @param equations differential equations to integrate
     * @param t0        initial time
     * @param y0        initial value of the state vector at t0
     * @param t         target time for the integration
     *                  (can be set to a value smaller than <code>t0</code> for backward integration)
     * @param y         placeholder where to put the state vector at each successful
     *                  step (and hence at the end of integration), can be the same object as y0
     * @return stop time, will be the same as target time if integration reached its
     * target, but may be different if some {@link
     * ODEEventHandler} stops it at some point.
     * @throws MathIllegalArgumentException if arrays dimension do not match equations settings
     * @throws MathIllegalArgumentException if integration step is too small
     * @throws MathIllegalStateException    if the number of functions evaluations is exceeded
     * @throws MathIllegalArgumentException if the location of an event cannot be bracketed
     * @deprecated as of 1.0, replaced with {@link #integrate(ExpandableODE, ODEState, double)}
     */
    @Deprecated
    public double integrate(final OrdinaryDifferentialEquation equations,
                            final double t0, final double[] y0, final double t, final double[] y)
            throws MathIllegalArgumentException, MathIllegalStateException {

        if (y0.length != equations.getDimension()) {
            throw new MathIllegalArgumentException(LocalizedCoreFormats.DIMENSIONS_MISMATCH,
                    y0.length, equations.getDimension());
        }
        if (y.length != equations.getDimension()) {
            throw new MathIllegalArgumentException(LocalizedCoreFormats.DIMENSIONS_MISMATCH,
                    y.length, equations.getDimension());
        }

        // prepare expandable stateful equations
        final ExpandableODE expandableODE = new ExpandableODE(equations);

        // perform integration
        final ODEState initialState = new ODEState(t0, y0);
        final ODEStateAndDerivative finalState = integrate(expandableODE, initialState, t);

        // extract results back from the stateful equations
        System.arraycopy(finalState.getPrimaryState(), 0, y, 0, y.length);
        return finalState.getTime();

    }
}
