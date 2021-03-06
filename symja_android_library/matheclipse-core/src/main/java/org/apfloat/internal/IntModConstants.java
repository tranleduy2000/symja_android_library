package org.apfloat.internal;

/**
 * Constants needed for various modular arithmetic operations for the <code>int</code> type.
 *
 * @author Mikko Tommila
 * @version 1.0
 */

public interface IntModConstants {
    /**
     * Moduli to be used in number theoretic transforms.
     * Allows transform lengths upto 3*2<sup>24</sup>.
     */

    int MODULUS[] = {2113929217, 2013265921, 1811939329};

    /**
     * Primitive roots for the corresponding moduli.
     */

    int PRIMITIVE_ROOT[] = {5, 31, 13};

    /**
     * Maximum transform length for the moduli.
     */

    long MAX_TRANSFORM_LENGTH = 50331648;

    /**
     * Maximum bits in a power-of-two base that fits in an <code>int</code>.
     */

    int MAX_POWER_OF_TWO_BITS = 31;

    /**
     * Maximum power-of-two base that fits in an <code>int</code>.
     */

    int MAX_POWER_OF_TWO_BASE = 1 << MAX_POWER_OF_TWO_BITS;
}
