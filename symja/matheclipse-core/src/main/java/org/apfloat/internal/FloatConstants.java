package org.apfloat.internal;

/**
 * Constants needed for various algorithms for the <code>float</code> type.
 *
 * @author Mikko Tommila
 * @version 1.4
 * @since 1.4
 */

public interface FloatConstants {
    /**
     * Relative cost of Karatsuba multiplication.
     */

    float KARATSUBA_COST_FACTOR = 6.1f;

    /**
     * Relative cost of NTT multiplication.
     */

    float NTT_COST_FACTOR = 7.4f;
}
