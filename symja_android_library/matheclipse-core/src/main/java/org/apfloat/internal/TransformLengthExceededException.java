package org.apfloat.internal;

/**
 * Exception indicating that the "size" of the numbers used in a
 * multiplication is too large. The "size" is equivalent to the number
 * of significant digits in the mantissa of the number, excluding any
 * leading or trailing zeros.<p>
 * <p>
 * This exception indicates a mathematical limitation. The exact
 * maximum transform length depends on the apfloat implementation.
 *
 * @author Mikko Tommila
 * @version 1.5
 * @since 1.5
 */

public class TransformLengthExceededException
        extends ApfloatInternalException {
    private static final long serialVersionUID = -7022924635011038776L;

    /**
     * Constructs a new apfloat transform length exceeded exception with an empty detail message.
     */

    public TransformLengthExceededException() {
    }

    /**
     * Constructs a new apfloat transform length exceeded exception with the specified detail message.
     *
     * @param message The detail message.
     */

    public TransformLengthExceededException(String message) {
        super(message);
    }

    /**
     * Constructs a new apfloat transform length exceeded exception with the specified detail message and cause.
     *
     * @param message The detail message.
     * @param cause   Originating cause of the exception.
     */

    public TransformLengthExceededException(String message, Throwable cause) {
        super(message, cause);
    }
}
