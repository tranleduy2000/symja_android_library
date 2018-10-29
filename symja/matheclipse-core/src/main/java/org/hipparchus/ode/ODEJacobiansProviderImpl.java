package org.hipparchus.ode;


import org.hipparchus.exception.MathIllegalArgumentException;

import java.util.Collections;
import java.util.List;

public abstract class ODEJacobiansProviderImpl implements ODEJacobiansProvider {
    /**
     * {@inheritDoc}
     * <p>
     * The default implementation has no parameters at all.
     * </p>
     */
    @Override
    public List<String> getParametersNames() {
        return Collections.emptyList();
    }

    /**
     * {@inheritDoc}
     * <p>
     * The default implementation supports no parameters at all.
     * </p>
     */
    @Override
    public boolean isSupported(String name) {
        return false;
    }

    /**
     * {@inheritDoc}
     * <p>
     * The default implementation supports no parameters at all.
     * </p>
     */
    @Override
    public double[] computeParameterJacobian(double t, double[] y, double[] yDot,
                                             String paramName)
            throws MathIllegalArgumentException {
        throw new MathIllegalArgumentException(LocalizedODEFormats.UNKNOWN_PARAMETER,
                paramName);
    }
}
