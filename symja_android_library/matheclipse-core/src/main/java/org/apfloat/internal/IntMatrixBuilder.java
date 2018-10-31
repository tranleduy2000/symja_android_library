package org.apfloat.internal;

import org.apfloat.spi.MatrixBuilder;
import org.apfloat.spi.MatrixStrategy;

/**
 * Creates matrix operations objects, for the
 * <code>int</code> type.
 *
 * @author Mikko Tommila
 * @version 1.7.0
 * @since 1.7.0
 */

public class IntMatrixBuilder
        implements MatrixBuilder {
    private static MatrixStrategy matrixStrategy = new IntMatrixStrategy();

    /**
     * Default constructor.
     */

    public IntMatrixBuilder() {
    }

    public MatrixStrategy createMatrix() {
        return IntMatrixBuilder.matrixStrategy;
    }
}
