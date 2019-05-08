package org.apfloat.internal;

import com.duy.concurrent.Callable;
import com.duy.concurrent.FutureTask;

import org.apfloat.ApfloatContext;
import org.apfloat.spi.NTTStrategy;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Convolution using three Number Theoretic Transforms
 * and the CRT to get the final result, using multiple threads in parallel.<p>
 * <p>
 * This algorithm is parallelized so that all operations are done in parallel
 * using multiple threads, if the number of processors is greater than one
 * in {@link ApfloatContext#getNumberOfProcessors()}.<p>
 * <p>
 * If the data block to be transformed is larger than the shared memory treshold setting
 * in the current ApfloatContext, this class will synchronize all data access on
 * the shared memory lock retrieved from {@link ApfloatContext#getSharedMemoryLock()}.<p>
 * <p>
 * All access to this class must be externally synchronized.
 *
 * @author Mikko Tommila
 * @version 1.8.0
 * @since 1.7.0
 */

public class ParallelThreeNTTConvolutionStrategy
        extends ThreeNTTConvolutionStrategy {
    private static Map<Object, Lock> locks = new WeakHashMap<Object, Lock>();
    private Object key;

    /**
     * Creates a new convoluter that uses the specified
     * transform for transforming the data.
     *
     * @param radix       The radix to be used.
     * @param nttStrategy The transform to be used.
     */

    public ParallelThreeNTTConvolutionStrategy(int radix, NTTStrategy nttStrategy) {
        super(radix, nttStrategy);
    }

    protected void lock(long length) {
        assert (this.key == null);

        if (super.nttStrategy instanceof Parallelizable &&
                super.carryCRTStrategy instanceof Parallelizable &&
                super.stepStrategy instanceof Parallelizable) {
            ApfloatContext ctx = ApfloatContext.getContext();
            if (length > ctx.getSharedMemoryTreshold() / ctx.getBuilderFactory().getElementSize()) {
                // Data size is big: synchronize on shared memory lock
                this.key = ctx.getSharedMemoryLock();

                if (this.key != null) {
                    Lock lock;
                    synchronized (ParallelThreeNTTConvolutionStrategy.locks) {
                        lock = ParallelThreeNTTConvolutionStrategy.locks.get(this.key);
                        if (lock == null) {
                            lock = new ReentrantLock();
                            ParallelThreeNTTConvolutionStrategy.locks.put(this.key, lock);
                        }
                    }
                    ParallelRunner.wait(new LockFuture(lock));
                }
            }
        }
    }

    protected void unlock() {
        if (this.key != null) {
            synchronized (ParallelThreeNTTConvolutionStrategy.locks) {
                ParallelThreeNTTConvolutionStrategy.locks.get(this.key).unlock();
            }
        }
    }

    private static class LockFuture
            extends FutureTask<Void> {
        private static final Callable<Void> VOID_CALLABLE = new Callable<Void>() {
            public Void call() {
                return null;
            }
        };
        private Lock lock;

        public LockFuture(Lock lock) {
            super(VOID_CALLABLE);
            this.lock = lock;
        }

        public boolean isDone() {
            return this.lock.tryLock();
        }
    }
}
