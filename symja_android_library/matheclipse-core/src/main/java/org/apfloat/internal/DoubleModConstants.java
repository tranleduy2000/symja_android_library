package org.apfloat.internal;

/**
 * Constants needed for various modular arithmetic operations for the <code>double</code> type.
 *
 * @author Mikko Tommila
 * @version 1.0
 */

public interface DoubleModConstants {
    /**
     * Moduli to be used in number theoretic transforms.
     * Allows transform lengths upto 3*2<sup>43</sup>.
     */

    double MODULUS[] = {1952732650930177.0, 1899956092796929.0, 1636073302130689.0};

    /**
     * Primitive roots for the corresponding moduli.
     */

    double PRIMITIVE_ROOT[] = {5.0, 7.0, 17.0};

    /**
     * Maximum transform length for the moduli.
     */

    long MAX_TRANSFORM_LENGTH = 26388279066624L;

    /**
     * Maximum bits in a power-of-two base that fits in a <code>double</code>.
     */

    int MAX_POWER_OF_TWO_BITS = 51;

    /**
     * Maximum power-of-two base that fits in a <code>double</code>.
     */

    double MAX_POWER_OF_TWO_BASE = (double) (1L << MAX_POWER_OF_TWO_BITS);
}
