package org.apfloat.internal;

import org.apfloat.ApfloatRuntimeException;
import org.apfloat.spi.ArrayAccess;
import org.apfloat.spi.DataStorage;

import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Disk-based data storage for the <code>long</code> element type.
 *
 * @author Mikko Tommila
 * @version 1.8.0
 */

public class LongDiskDataStorage
        extends DiskDataStorage {
    private static final long serialVersionUID = 4741507089425158620L;

    /**
     * Default constructor.
     */

    public LongDiskDataStorage()
            throws ApfloatRuntimeException {
    }

    /**
     * Subsequence constructor.
     *
     * @param longDiskDataStorage The originating data storage.
     * @param offset              The subsequence starting position.
     * @param length              The subsequence length.
     */

    protected LongDiskDataStorage(LongDiskDataStorage longDiskDataStorage, long offset, long length) {
        super(longDiskDataStorage, offset, length);
    }

    protected DataStorage implSubsequence(long offset, long length)
            throws ApfloatRuntimeException {
        return new LongDiskDataStorage(this, offset + getOffset(), length);
    }

    protected ArrayAccess implGetArray(int mode, long offset, int length)
            throws ApfloatRuntimeException {
        return new LongDiskArrayAccess(mode, getOffset() + offset, length);
    }

    protected ArrayAccess createArrayAccess(int mode, int startColumn, int columns, int rows) {
        return new MemoryArrayAccess(mode, new long[columns * rows], startColumn, columns, rows);
    }

    protected ArrayAccess createTransposedArrayAccess(int mode, int startColumn, int columns, int rows) {
        return new TransposedMemoryArrayAccess(mode, new long[columns * rows], startColumn, columns, rows);
    }

    public Iterator iterator(int mode, long startPosition, long endPosition)
            throws IllegalArgumentException, IllegalStateException, ApfloatRuntimeException {
        if ((mode & READ_WRITE) == 0) {
            throw new IllegalArgumentException("Illegal mode: " + mode);
        }
        return new BlockIterator(mode, startPosition, endPosition);
    }

    protected int getUnitSize() {
        return 8;
    }

    private class LongDiskArrayAccess
            extends LongMemoryArrayAccess {
        private static final long serialVersionUID = -2591640502422276852L;
        private int mode;
        private long fileOffset;

        // fileOffset is absolute position in file
        public LongDiskArrayAccess(int mode, long fileOffset, int length)
                throws ApfloatRuntimeException {
            super(new long[length], 0, length);
            this.mode = mode;
            this.fileOffset = fileOffset;

            if ((mode & READ) != 0) {
                final long[] array = getLongData();
                WritableByteChannel out = new WritableByteChannel() {
                    private int readPosition = 0;

                    public int write(ByteBuffer buffer) {
                        LongBuffer src = buffer.asLongBuffer();
                        int readLength = src.remaining();

                        src.get(array, this.readPosition, readLength);

                        this.readPosition += readLength;
                        buffer.position(buffer.position() + readLength * 8);

                        return readLength * 8;
                    }

                    public void close() {
                    }

                    public boolean isOpen() {
                        return true;
                    }
                };

                transferTo(out, fileOffset * 8, (long) length * 8);
            }
        }

        public void close()
                throws ApfloatRuntimeException {
            if ((this.mode & WRITE) != 0 && getData() != null) {
                final long[] array = getLongData();
                ReadableByteChannel in = new ReadableByteChannel() {
                    private int writePosition = 0;

                    public int read(ByteBuffer buffer) {
                        LongBuffer dst = buffer.asLongBuffer();
                        int writeLength = dst.remaining();

                        dst.put(array, this.writePosition, writeLength);

                        this.writePosition += writeLength;
                        buffer.position(buffer.position() + writeLength * 8);

                        return writeLength * 8;
                    }

                    public void close() {
                    }

                    public boolean isOpen() {
                        return true;
                    }
                };

                transferFrom(in, this.fileOffset * 8, (long) array.length * 8);
            }

            super.close();
        }
    }

    private class MemoryArrayAccess
            extends LongMemoryArrayAccess {
        private static final long serialVersionUID = -1573539652919953016L;
        private int mode,
                startColumn,
                columns,
                rows;

        public MemoryArrayAccess(int mode, long[] data, int startColumn, int columns, int rows) {
            super(data, 0, data.length);
            this.mode = mode;
            this.startColumn = startColumn;
            this.columns = columns;
            this.rows = rows;
        }

        public void close()
                throws ApfloatRuntimeException {
            if ((this.mode & WRITE) != 0 && getData() != null) {
                setArray(this, this.startColumn, this.columns, this.rows);
            }
            super.close();
        }
    }

    private class TransposedMemoryArrayAccess
            extends LongMemoryArrayAccess {
        private static final long serialVersionUID = -455915044370886962L;
        private int mode,
                startColumn,
                columns,
                rows;

        public TransposedMemoryArrayAccess(int mode, long[] data, int startColumn, int columns, int rows) {
            super(data, 0, data.length);
            this.mode = mode;
            this.startColumn = startColumn;
            this.columns = columns;
            this.rows = rows;
        }

        public void close()
                throws ApfloatRuntimeException {
            if ((this.mode & WRITE) != 0 && getData() != null) {
                setTransposedArray(this, this.startColumn, this.columns, this.rows);
            }
            super.close();
        }
    }

    private class BlockIterator
            extends AbstractIterator {
        private static final long serialVersionUID = -2804905180796718735L;
        private ArrayAccess arrayAccess;
        private long[] data;
        private int offset,
                remaining;

        public BlockIterator(int mode, long startPosition, long endPosition)
                throws IllegalArgumentException, IllegalStateException, ApfloatRuntimeException {
            super(mode, startPosition, endPosition);
            this.arrayAccess = null;
            this.remaining = 0;
        }

        public void next()
                throws IllegalStateException, ApfloatRuntimeException {
            checkLength();

            assert (this.remaining > 0);

            checkAvailable();

            this.offset += getIncrement();
            this.remaining--;

            if (this.remaining == 0) {
                close();
            }

            super.next();
        }

        public long getLong()
                throws IllegalStateException, ApfloatRuntimeException {
            checkGet();
            checkAvailable();
            return this.data[this.offset];
        }

        public void setLong(long value)
                throws IllegalStateException, ApfloatRuntimeException {
            checkSet();
            checkAvailable();
            this.data[this.offset] = value;
        }

        public <T> T get(Class<T> type)
                throws UnsupportedOperationException, IllegalStateException {
            if (!(type.equals(Long.TYPE))) {
                throw new UnsupportedOperationException("Unsupported data type " + type.getCanonicalName() + ", the only supported type is long");
            }
            @SuppressWarnings("unchecked")
            T value = (T) (Long) getLong();
            return value;
        }

        public <T> void set(Class<T> type, T value)
                throws UnsupportedOperationException, IllegalArgumentException, IllegalStateException {
            if (!(type.equals(Long.TYPE))) {
                throw new UnsupportedOperationException("Unsupported data type " + type.getCanonicalName() + ", the only supported type is long");
            }
            if (!(value instanceof Long)) {
                throw new IllegalArgumentException("Unsupported value type " + value.getClass().getCanonicalName() + ", the only supported type is Long");
            }
            setLong((Long) value);
        }

        /**
         * Closes the iterator. This needs to be called only if the
         * iterator is not iterated to the end.
         */

        public void close()
                throws ApfloatRuntimeException {
            if (this.arrayAccess != null) {
                this.data = null;
                this.arrayAccess.close();
                this.arrayAccess = null;
            }
        }

        private void checkAvailable()
                throws ApfloatRuntimeException {
            if (this.arrayAccess == null) {
                boolean isForward = (getIncrement() > 0);
                int length = (int) Math.min(getLength(), getBlockSize() / 8);
                long offset = (isForward ? getPosition() : getPosition() - length + 1);

                this.arrayAccess = getArray(getMode(), offset, length);
                this.data = this.arrayAccess.getLongData();
                this.offset = this.arrayAccess.getOffset() + (isForward ? 0 : length - 1);
                this.remaining = length;
            }
        }
    }
}
