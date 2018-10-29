package org.apfloat.internal;

import org.apfloat.ApfloatRuntimeException;
import org.apfloat.spi.DataStorage;

/**
 * Default data storage creation strategy for the <code>long</code> data type.
 *
 * @author Mikko Tommila
 * @version 1.7.0
 * @see LongMemoryDataStorage
 * @see LongDiskDataStorage
 */

public class LongDataStorageBuilder
        extends AbstractDataStorageBuilder {
    /**
     * Default constructor.
     */

    public LongDataStorageBuilder() {
    }

    protected DataStorage createCachedDataStorage()
            throws ApfloatRuntimeException {
        return new LongMemoryDataStorage();
    }

    protected DataStorage createNonCachedDataStorage()
            throws ApfloatRuntimeException {
        return new LongDiskDataStorage();
    }

    protected boolean isCached(DataStorage dataStorage)
            throws ApfloatRuntimeException {
        return (dataStorage instanceof LongMemoryDataStorage);
    }
}
