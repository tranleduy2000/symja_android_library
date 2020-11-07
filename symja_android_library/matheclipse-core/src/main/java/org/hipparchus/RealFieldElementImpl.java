package org.hipparchus;

import org.hipparchus.util.FastMath;

public abstract class RealFieldElementImpl<T> extends CalculusFieldElementImpl<T> implements RealFieldElement<T> {

    @Override
    public long round() {
        return FastMath.round(getReal());
    }
}
