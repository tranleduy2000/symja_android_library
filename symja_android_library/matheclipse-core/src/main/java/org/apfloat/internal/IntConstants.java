package org.apfloat.internal;

/**
 * Constants needed for various algorithms for the <code>int</code> type.
 *
 * @author Mikko Tommila
 * @version 1.4
 * @since 1.4
 */

public interface IntConstants {
    /**
     * Relative cost of Karatsuba multiplication.
     */

    float KARATSUBA_COST_FACTOR = 4.8f;

    /**
     * Relative cost of NTT multiplication.
     */

    float NTT_COST_FACTOR = 4.1f;
}
