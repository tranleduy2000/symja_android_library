package org.apfloat.internal;

/**
 * Constants needed for various modular arithmetic operations for the <code>float</code> type.
 *
 * @author Mikko Tommila
 * @version 1.0
 */

public interface FloatModConstants {
    /**
     * Moduli to be used in number theoretic transforms.
     * Allows transform lengths upto 3*2<sup>17</sup>.
     */

    float MODULUS[] = {16515073.0f, 14942209.0f, 14155777.0f};

    /**
     * Primitive roots for the corresponding moduli.
     */

    float PRIMITIVE_ROOT[] = {5.0f, 11.0f, 7.0f};

    /**
     * Maximum transform length for the moduli.
     */

    long MAX_TRANSFORM_LENGTH = 393216;

    /**
     * Maximum bits in a power-of-two base that fits in a <code>float</code>.
     */

    int MAX_POWER_OF_TWO_BITS = 24;

    /**
     * Maximum power-of-two base that fits in a <code>float</code>.
     */

    float MAX_POWER_OF_TWO_BASE = (float) (1 << MAX_POWER_OF_TWO_BITS);
}
