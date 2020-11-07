package org.hipparchus;

import com.duy.lang.DDouble;

import org.hipparchus.util.FastMath;
import org.hipparchus.util.FieldSinCos;

public abstract class CalculusFieldElementImpl<T> implements CalculusFieldElement<T> {
    @Override
    public T newInstance(double value) {
        @SuppressWarnings("unchecked") final CalculusFieldElement<T> zero = (CalculusFieldElement<T>) getField().getZero();
        return zero.add(value);
    }

    @Override
    public int getExponent() {
        return FastMath.getExponent(getReal());
    }

    @Override
    public FieldSinCos<T> sinCos() {
        return new FieldSinCos<>(sin(), cos());
    }

    @Override
    public T toDegrees() {
        return multiply(RAD_TO_DEG);
    }

    @Override
    public T toRadians() {
        return multiply(DEG_TO_RAD);
    }

    @Override
    public boolean isInfinite() {
        return DDouble.isFinite(getReal());
    }

    @Override
    public boolean isNaN() {
        return Double.isNaN(getReal());
    }
}
