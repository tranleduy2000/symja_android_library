package org.apfloat.internal;

/**
 * Constants needed for various algorithms for the <code>long</code> type.
 *
 * @author Mikko Tommila
 * @version 1.4
 * @since 1.4
 */

public interface LongConstants {
    /**
     * Relative cost of Karatsuba multiplication.
     */

    float KARATSUBA_COST_FACTOR = 4.9f;

    /**
     * Relative cost of NTT multiplication.
     */

    float NTT_COST_FACTOR = 8.3f;
}
