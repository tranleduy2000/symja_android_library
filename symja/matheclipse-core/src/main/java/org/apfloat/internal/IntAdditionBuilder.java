package org.apfloat.internal;

import org.apfloat.spi.AdditionBuilder;
import org.apfloat.spi.AdditionStrategy;

/**
 * Creates additions for the specified radix and the <code>int</code> element type.<p>
 *
 * @author Mikko Tommila
 * @version 1.7.0
 * @since 1.7.0
 */

public class IntAdditionBuilder
        implements AdditionBuilder<Integer> {
    /**
     * Default constructor.
     */

    public IntAdditionBuilder() {
    }

    public AdditionStrategy<Integer> createAddition(int radix) {
        AdditionStrategy<Integer> additionStrategy = new IntAdditionStrategy(radix);
        return additionStrategy;
    }
}
