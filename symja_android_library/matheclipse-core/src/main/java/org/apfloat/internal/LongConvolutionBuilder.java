package org.apfloat.internal;

import org.apfloat.spi.ConvolutionStrategy;
import org.apfloat.spi.NTTStrategy;

import static org.apfloat.internal.LongConstants.KARATSUBA_COST_FACTOR;
import static org.apfloat.internal.LongConstants.NTT_COST_FACTOR;

/**
 * Creates convolutions of suitable type for the <code>long</code> type.<p>
 *
 * @author Mikko Tommila
 * @version 1.7.0
 * @see LongShortConvolutionStrategy
 * @see LongMediumConvolutionStrategy
 * @see LongKaratsubaConvolutionStrategy
 * @see ThreeNTTConvolutionStrategy
 */

public class LongConvolutionBuilder
        extends AbstractConvolutionBuilder {
    /**
     * Default constructor.
     */

    public LongConvolutionBuilder() {
    }

    protected int getKaratsubaCutoffPoint() {
        return LongKaratsubaConvolutionStrategy.CUTOFF_POINT;
    }

    protected float getKaratsubaCostFactor() {
        return KARATSUBA_COST_FACTOR;
    }

    protected float getNTTCostFactor() {
        return NTT_COST_FACTOR;
    }

    protected ConvolutionStrategy createShortConvolutionStrategy(int radix) {
        return new LongShortConvolutionStrategy(radix);
    }

    protected ConvolutionStrategy createMediumConvolutionStrategy(int radix) {
        return new LongMediumConvolutionStrategy(radix);
    }

    protected ConvolutionStrategy createKaratsubaConvolutionStrategy(int radix) {
        return new LongKaratsubaConvolutionStrategy(radix);
    }


    protected ConvolutionStrategy createThreeNTTConvolutionStrategy(int radix, NTTStrategy nttStrategy) {
        return new ParallelThreeNTTConvolutionStrategy(radix, nttStrategy);
    }
}
