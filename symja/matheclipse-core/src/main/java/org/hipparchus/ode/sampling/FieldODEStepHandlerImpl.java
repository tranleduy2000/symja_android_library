package org.hipparchus.ode.sampling;

import org.hipparchus.RealFieldElement;
import org.hipparchus.ode.FieldODEStateAndDerivative;

public abstract class FieldODEStepHandlerImpl<T extends RealFieldElement<T>> implements FieldODEStepHandler<T> {

    /**
     * Initialize step handler at the start of an ODE integration.
     * <p>
     * This method is called once at the start of the integration. It
     * may be used by the step handler to initialize some internal data
     * if needed.
     * </p>
     * <p>
     * The default implementation does nothing.
     * </p>
     *
     * @param initialState initial time, state vector and derivative
     * @param finalTime    target time for the integration
     */
    public void init(FieldODEStateAndDerivative<T> initialState, T finalTime) {
        // nothing by default
    }

}
