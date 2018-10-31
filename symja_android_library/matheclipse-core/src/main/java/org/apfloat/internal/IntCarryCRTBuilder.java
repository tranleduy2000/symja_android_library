package org.apfloat.internal;

import org.apfloat.spi.CarryCRTBuilder;
import org.apfloat.spi.CarryCRTStepStrategy;
import org.apfloat.spi.CarryCRTStrategy;

/**
 * Creates carry-CRT related objects, for the
 * <code>int</code> type.
 *
 * @author Mikko Tommila
 * @version 1.7.0
 * @since 1.7.0
 */

public class IntCarryCRTBuilder
        implements CarryCRTBuilder<int[]> {
    /**
     * Default constructor.
     */

    public IntCarryCRTBuilder() {
    }

    public CarryCRTStrategy createCarryCRT(int radix) {
        return new StepCarryCRTStrategy(radix);
    }

    public CarryCRTStepStrategy<int[]> createCarryCRTSteps(int radix) {
        return new IntCarryCRTStepStrategy(radix);
    }
}
