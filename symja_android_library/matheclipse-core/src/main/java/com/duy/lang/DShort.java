package com.duy.lang;

public class DShort {
    public static int compare(short x, short y) {
        return x - y;
    }


    /**
     * Converts the argument to an {@code int} by an unsigned
     * conversion.  In an unsigned conversion to an {@code int}, the
     * high-order 16 bits of the {@code int} are zero and the
     * low-order 16 bits are equal to the bits of the {@code short} argument.
     *
     * Consequently, zero and positive {@code short} values are mapped
     * to a numerically equal {@code int} value and negative {@code
     * short} values are mapped to an {@code int} value equal to the
     * input plus 2<sup>16</sup>.
     *
     * @param  x the value to convert to an unsigned {@code int}
     * @return the argument converted to {@code int} by an unsigned
     *         conversion
     * @since 1.8
     */
    public static int toUnsignedInt(short x) {
        return ((int) x) & 0xffff;
    }

}
