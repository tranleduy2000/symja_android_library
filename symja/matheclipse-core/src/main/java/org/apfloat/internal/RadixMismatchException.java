package org.apfloat.internal;

/**
 * Exception indicating a different radix being used in two operands
 * of a calculation.<p>
 * <p>
 * While it's possible to convert numbers to different radixes using the
 * <code>toRadix()</code> methods, this is highly inefficient. If numbers
 * of different radixes need to be used in a calculation, they should be
 * explicitly converted to matching radixes before attempting the calculation.
 * Otherwise this exception should be thrown.
 *
 * @author Mikko Tommila
 * @version 1.5
 * @since 1.5
 */

public class RadixMismatchException
        extends ApfloatInternalException {
    private static final long serialVersionUID = -7022924635011038776L;

    /**
     * Constructs a new apfloat radix mismatch exception with an empty detail message.
     */

    public RadixMismatchException() {
    }

    /**
     * Constructs a new apfloat radix mismatch exception with the specified detail message.
     *
     * @param message The detail message.
     */

    public RadixMismatchException(String message) {
        super(message);
    }

    /**
     * Constructs a new apfloat radix mismatch exception with the specified detail message and cause.
     *
     * @param message The detail message.
     * @param cause   Originating cause of the exception.
     */

    public RadixMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
}
