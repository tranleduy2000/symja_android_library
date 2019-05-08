/*
 * $Id$
 */

package edu.jas.kern;


import com.duy.concurrent.ExecutorService;
import com.duy.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ComputerThreads, provides global thread / executor service.
 *
 * @author Heinz Kredel
 * @usage To obtain a reference to the thread pool use
 * <code>ComputerThreads.getPool()</code>. Once a pool has been created
 * it must be shutdown to exit JAS with
 * <code>ComputerThreads.terminate()</code>.
 */

public class ComputerThreads {


    /**
     * Flag for thread usage. <b>Note:</b> Only introduced because Google app
     * engine does not support threads.
     *
     * @see edu.jas.ufd.GCDFactory#getProxy(edu.jas.structure.RingFactory)
     */
    public static boolean NO_THREADS = false;


    //public static final int N_THREADS = ( N_CPUS < 3 ? 5 : 3*N_CPUS );
    /**
     * Timeout for timed execution.
     *
     * @see edu.jas.fd.SGCDParallelProxy
     */
    static long timeout = 10L; //-1L;


    /**
     * TimeUnit for timed execution.
     *
     * @see edu.jas.fd.SGCDParallelProxy
     */
    static TimeUnit timeunit = TimeUnit.SECONDS;


    /*
     * Saturation policy.
     */
    //public static final RejectedExecutionHandler REH = new ThreadPoolExecutor.CallerRunsPolicy();
    //public static final RejectedExecutionHandler REH = new ThreadPoolExecutor.AbortPolicy();

    /**
     * ExecutorService thread pool.
     */
    //static ThreadPoolExecutor pool = null;
    private static ExecutorService pool = null;


    /**
     * No public constructor.
     */
    private ComputerThreads() {
    }


    /**
     * Get the thread pool.
     *
     * @return pool ExecutorService.
     */
    public static synchronized ExecutorService getPool() {
        if (pool == null) {
            // workpile = new ArrayBlockingQueue<Runnable>(Q_CAPACITY);
            //            pool = Executors.newFixedThreadPool(N_THREADS);
            pool = Executors.newCachedThreadPool();
            //             pool = new ThreadPoolExecutor(N_CPUS, N_THREADS,
            //                                           100L, TimeUnit.MILLISECONDS,
            //                                           workpile, REH);
            //             pool = new ThreadPoolExecutor(N_CPUS, N_THREADS,
            //                                           1000L, TimeUnit.MILLISECONDS,
            //                                           workpile);
        }
        //System.out.println("pool_init = " + pool);
        return pool;
        //return Executors.unconfigurableExecutorService(pool);

        /* not useful, is not run from jython
        final GCDProxy<C> proxy = this;
        Runtime.getRuntime().addShutdownHook( 
                         new Thread() {
                             public void run() {
                                    logger.info("running shutdown hook");
                                    proxy.terminate();
                             }
                         }
        );
        */
    }


    /**
     * Get timeout.
     *
     * @return timeout value
     */
    public static synchronized long getTimeout() {
        return timeout;
    }

    /**
     * Set timeout.
     *
     * @param t time value to set
     */
    public static synchronized void setTimeout(long t) {
        timeout = t;
    }

    /**
     * Get TimeUnit.
     *
     * @return timeunit value
     */
    public static synchronized TimeUnit getTimeUnit() {
        return timeunit;
    }

}
