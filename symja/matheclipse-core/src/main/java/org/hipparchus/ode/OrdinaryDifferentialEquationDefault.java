package org.hipparchus.ode;

public class OrdinaryDifferentialEquationDefault {
    /**
     * Initialize equations at the start of an ODE integration.
     * <p>
     * This method is called once at the start of the integration. It
     * may be used by the equations to initialize some internal data
     * if needed.
     * </p>
     * <p>
     * The default implementation does nothing.
     * </p>
     *
     * @param t0        value of the independent <I>time</I> variable at integration start
     * @param y0        array containing the value of the state vector at integration start
     * @param finalTime target time for the integration
     */
    public static void init(OrdinaryDifferentialEquation ordinaryDifferentialEquation,
                            double t0, double[] y0, double finalTime) {
        // do nothing by default
    }

}
