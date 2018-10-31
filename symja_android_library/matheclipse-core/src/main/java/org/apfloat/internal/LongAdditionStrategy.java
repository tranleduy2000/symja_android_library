package org.apfloat.internal;

import org.apfloat.ApfloatRuntimeException;
import org.apfloat.spi.AdditionStrategy;
import org.apfloat.spi.DataStorage.Iterator;

/**
 * Basic addition strategy for the <code>long</code> element type.
 *
 * @author Mikko Tommila
 * @version 1.7.0
 * @since 1.7.0
 */
public class LongAdditionStrategy
        extends LongBaseMath
        implements AdditionStrategy<Long> {
    private static final long serialVersionUID = 4128390142053847289L;

    /**
     * Creates an addition strategy using the specified radix.
     *
     * @param radix The radix that will be used.
     */

    public LongAdditionStrategy(int radix) {
        super(radix);
    }

    public Long add(Iterator src1, Iterator src2, Long carry, Iterator dst, long size)
            throws ApfloatRuntimeException {
        return baseAdd(src1, src2, carry, dst, size);
    }

    public Long subtract(Iterator src1, Iterator src2, Long carry, Iterator dst, long size)
            throws ApfloatRuntimeException {
        return baseSubtract(src1, src2, carry, dst, size);
    }

    public Long multiplyAdd(Iterator src1, Iterator src2, Long src3, Long carry, Iterator dst, long size)
            throws ApfloatRuntimeException {
        return baseMultiplyAdd(src1, src2, src3, carry, dst, size);
    }

    public Long divide(Iterator src1, Long src2, Long carry, Iterator dst, long size)
            throws ApfloatRuntimeException {
        return baseDivide(src1, src2, carry, dst, size);
    }

    public Long zero() {
        return (long) 0;
    }
}
