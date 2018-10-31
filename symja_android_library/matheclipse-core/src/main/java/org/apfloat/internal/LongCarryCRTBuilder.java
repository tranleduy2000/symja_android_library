package org.apfloat.internal;

import org.apfloat.spi.CarryCRTBuilder;
import org.apfloat.spi.CarryCRTStepStrategy;
import org.apfloat.spi.CarryCRTStrategy;

/**
 * Creates carry-CRT related objects, for the
 * <code>long</code> type.
 *
 * @author Mikko Tommila
 * @version 1.7.0
 * @since 1.7.0
 */

public class LongCarryCRTBuilder
        implements CarryCRTBuilder<long[]> {
    /**
     * Default constructor.
     */

    public LongCarryCRTBuilder() {
    }

    public CarryCRTStrategy createCarryCRT(int radix) {
        return new StepCarryCRTStrategy(radix);
    }

    public CarryCRTStepStrategy<long[]> createCarryCRTSteps(int radix) {
        return new LongCarryCRTStepStrategy(radix);
    }
}
