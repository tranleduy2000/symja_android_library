package org.apfloat.internal;

import org.apfloat.ApfloatRuntimeException;
import org.apfloat.spi.AdditionStrategy;
import org.apfloat.spi.DataStorage.Iterator;

/**
 * Basic addition strategy for the <code>int</code> element type.
 *
 * @author Mikko Tommila
 * @version 1.7.0
 * @since 1.7.0
 */
public class IntAdditionStrategy
        extends IntBaseMath
        implements AdditionStrategy<Integer> {
    private static final long serialVersionUID = -6156689494629604331L;

    /**
     * Creates an addition strategy using the specified radix.
     *
     * @param radix The radix that will be used.
     */

    public IntAdditionStrategy(int radix) {
        super(radix);
    }

    public Integer add(Iterator src1, Iterator src2, Integer carry, Iterator dst, long size)
            throws ApfloatRuntimeException {
        return baseAdd(src1, src2, carry, dst, size);
    }

    public Integer subtract(Iterator src1, Iterator src2, Integer carry, Iterator dst, long size)
            throws ApfloatRuntimeException {
        return baseSubtract(src1, src2, carry, dst, size);
    }

    public Integer multiplyAdd(Iterator src1, Iterator src2, Integer src3, Integer carry, Iterator dst, long size)
            throws ApfloatRuntimeException {
        return baseMultiplyAdd(src1, src2, src3, carry, dst, size);
    }

    public Integer divide(Iterator src1, Integer src2, Integer carry, Iterator dst, long size)
            throws ApfloatRuntimeException {
        return baseDivide(src1, src2, carry, dst, size);
    }

    public Integer zero() {
        return (int) 0;
    }
}
