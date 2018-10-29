package org.apfloat.internal;

/**
 * Constants needed for various algorithms for the <code>double</code> type.
 *
 * @author Mikko Tommila
 * @version 1.4
 * @since 1.4
 */

public interface DoubleConstants {
    /**
     * Relative cost of Karatsuba multiplication.
     */

    public static final float KARATSUBA_COST_FACTOR = 4.3f;

    /**
     * Relative cost of NTT multiplication.
     */

    public static final float NTT_COST_FACTOR = 6.2f;
}
