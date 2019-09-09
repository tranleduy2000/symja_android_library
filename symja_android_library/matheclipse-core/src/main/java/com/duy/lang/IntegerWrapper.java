package com.duy.lang;

public class IntegerWrapper {

    /**
     * Compares two {@code int} values.
     * @return 0 if lhs = rhs, less than 0 if lhs &lt; rhs, and greater than 0
     *         if lhs &gt; rhs.
     * @since 1.7
     */
    public static int compare(int lhs, int rhs) {
        return lhs < rhs ? -1 : (lhs == rhs ? 0 : 1);
    }

    /**
     * Returns a hash code for a {@code int} value; compatible with
     * {@code Integer.hashCode()}.
     *
     * @param value the value to hash
     * @since 1.8
     *
     * @return a hash code value for a {@code int} value.
     */
    public static int hashCode(int value) {
        return value;
    }
}
