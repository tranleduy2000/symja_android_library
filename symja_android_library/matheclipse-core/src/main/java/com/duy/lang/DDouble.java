package com.duy.lang;

import static java.lang.Double.doubleToLongBits;

/**
 * Created by Duy on 2/20/2018.
 */

public class DDouble {
    /**
     * Returns a hash code for a {@code double} value; compatible with
     * {@code DDouble.hashCode()}.
     *
     * @param value the value to hash
     * @return a hash code value for a {@code double} value.
     * @since 1.8
     */
    public static int hashCode(double value) {
        long bits = doubleToLongBits(value);
        return (int) (bits ^ (bits >>> 32));
    }

    /**
     * Returns {@code true} if the argument is a finite floating-point
     * value; returns {@code false} otherwise (for NaN and infinity
     * arguments).
     *
     * @param d the {@code double} value to be tested
     * @return {@code true} if the argument is a finite
     * floating-point value, {@code false} otherwise.
     * @since 1.8
     */
    public static boolean isFinite(double d) {
        return java.lang.Math.abs(d) <= java.lang.Double.MAX_VALUE;
    }
}
