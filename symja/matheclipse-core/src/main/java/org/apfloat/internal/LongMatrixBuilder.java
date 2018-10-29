package org.apfloat.internal;

import org.apfloat.spi.MatrixBuilder;
import org.apfloat.spi.MatrixStrategy;

/**
 * Creates matrix operations objects, for the
 * <code>long</code> type.
 *
 * @author Mikko Tommila
 * @version 1.7.0
 * @since 1.7.0
 */

public class LongMatrixBuilder
        implements MatrixBuilder {
    private static MatrixStrategy matrixStrategy = new LongMatrixStrategy();

    /**
     * Default constructor.
     */

    public LongMatrixBuilder() {
    }

    public MatrixStrategy createMatrix() {
        return LongMatrixBuilder.matrixStrategy;
    }
}
