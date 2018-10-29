package org.hipparchus.ode.events;

import org.hipparchus.RealFieldElement;
import org.hipparchus.ode.FieldODEState;
import org.hipparchus.ode.FieldODEStateAndDerivative;

public abstract class FieldODEEventHandlerImpl<T extends RealFieldElement<T>> implements FieldODEEventHandler<T> {
    /**
     * Reset the state prior to continue the integration.
     * <p>
     * <p>This method is called after the step handler has returned and
     * before the next step is started, but only when {@link
     * #eventOccurred(FieldODEStateAndDerivative, boolean) eventOccurred} has itself
     * returned the {@link Action#RESET_STATE} indicator. It allows the user to reset
     * the state vector for the next step, without perturbing the step handler of the
     * finishing step.</p>
     * <p>The default implementation returns its argument.</p>
     *
     * @param state current value of the independent <i>time</i> variable, state vector
     *              and derivative
     * @return reset state (note that it does not include the derivatives, they will
     * be added automatically by the integrator afterwards)
     */
    public FieldODEState<T> resetState(FieldODEStateAndDerivative<T> state) {
        return state;
    }

    @Override
    public void init(FieldODEStateAndDerivative<T> s0WithDerivatives, T t) {

    }

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
