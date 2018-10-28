package org.hipparchus.ode.events;

import org.hipparchus.RealFieldElement;
import org.hipparchus.ode.FieldODEStateAndDerivative;

public class DefaultFieldODEEventHandler {
    /**
     * Initialize event handler at the start of an ODE integration.
     * <p>
     * This method is called once at the start of the integration. It
     * may be used by the event handler to initialize some internal data
     * if needed.
     * </p>
     * <p>
     * The default implementation does nothing
     * </p>
     *
     * @param initialState initial time, state vector and derivative
     * @param finalTime    target time for the integration
     */
    public static <T extends RealFieldElement<T>> void init(FieldODEEventHandler<T> fieldODEEventHandler,
                                                            FieldODEStateAndDerivative<T> initialState, T finalTime) {
        // nothing by default
    }

}
