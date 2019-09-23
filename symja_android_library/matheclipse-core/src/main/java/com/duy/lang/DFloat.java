package com.duy.lang;

public class DFloat {
    /**
     * Returns {@code true} if the argument is a finite floating-point
     * value; returns {@code false} otherwise (for NaN and infinity
     * arguments).
     *
     * @param f the {@code float} value to be tested
     * @return {@code true} if the argument is a finite
     * floating-point value, {@code false} otherwise.
     * @since 1.8
     */
    public static boolean isFinite(float f) {
        return Math.abs(f) <= Float.MAX_VALUE;
    }

}
