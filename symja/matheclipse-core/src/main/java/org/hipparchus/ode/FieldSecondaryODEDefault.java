package org.hipparchus.ode;

import org.hipparchus.RealFieldElement;

public class FieldSecondaryODEDefault {
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
     * @param t0         value of the independent <I>time</I> variable at integration start
     * @param primary0   array containing the value of the primary state vector at integration start
     * @param secondary0 array containing the value of the secondary state vector at integration start
     * @param finalTime  target time for the integration
     */
    public  static <T extends RealFieldElement<T>> void init(FieldSecondaryODE<T> fieldSecondaryODE,
                                                             T t0, T[] primary0, T[] secondary0, T finalTime) {
        // nothing by default
    }

}
