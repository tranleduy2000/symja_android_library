package org.apfloat.internal;

import org.apfloat.spi.Factor3NTTStepStrategy;
import org.apfloat.spi.NTTConvolutionStepStrategy;
import org.apfloat.spi.NTTStepStrategy;
import org.apfloat.spi.NTTStrategy;

/**
 * Creates Number Theoretic Transforms for the
 * <code>int</code> type.
 *
 * @author Mikko Tommila
 * @version 1.7.0
 */

public class IntNTTBuilder
        extends AbstractNTTBuilder {
    /**
     * Default constructor.
     */

    public IntNTTBuilder() {
    }

    public NTTStepStrategy createNTTSteps() {
        return new IntNTTStepStrategy();
    }

    public NTTConvolutionStepStrategy createNTTConvolutionSteps() {
        return new IntNTTConvolutionStepStrategy();
    }

    public Factor3NTTStepStrategy createFactor3NTTSteps() {
        return new IntFactor3NTTStepStrategy();
    }

    protected NTTStrategy createSimpleFNTStrategy() {
        return new IntTableFNTStrategy();
    }

    protected NTTStrategy createSixStepFNTStrategy() {
        return new SixStepFNTStrategy();
    }

    protected NTTStrategy createTwoPassFNTStrategy() {
        return new TwoPassFNTStrategy();
    }

    protected NTTStrategy createFactor3NTTStrategy(NTTStrategy nttStrategy) {
        return new Factor3NTTStrategy(nttStrategy);
    }
}
