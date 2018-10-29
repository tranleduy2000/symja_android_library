/*
 * $Id$
 */

package edu.jas.gb;


import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Semaphore;

import edu.jas.poly.ExpVector;
import edu.jas.poly.GenPolynomial;
import edu.jas.structure.RingElem;
import edu.jas.util.ChannelFactory;
import edu.jas.util.DistHashTable;
import edu.jas.util.DistHashTableServer;
import edu.jas.util.SocketChannel;
import edu.jas.util.Terminator;
import edu.jas.util.ThreadPool;


/**
 * Distributed server reducing worker threads.
 *
 * @param <C> coefficient type
 */

class ReducerServerSeqPair<C extends RingElem<C>> implements Runnable {


    private static final Logger logger = Logger.getLogger(ReducerServerSeqPair.class);
    private final Terminator pool;
    private final ChannelFactory cf;
    private final DistHashTable<Integer, GenPolynomial<C>> theList;


    //private List<GenPolynomial<C>> G;
    private final CriticalPairList<C> pairlist;


    ReducerServerSeqPair(Terminator fin, ChannelFactory cf, DistHashTable<Integer, GenPolynomial<C>> dl,
                         CriticalPairList<C> L) {
        pool = fin;
        this.cf = cf;
        theList = dl;
        //this.G = G;
        pairlist = L;
    }


    public void run() {
        logger.debug("reducer server running");
        SocketChannel pairChannel;
        try {
            pairChannel = cf.getChannel();
        } catch (InterruptedException e) {
            logger.debug("get pair channel interrupted");
            e.printStackTrace();
            return;
        }
        if (logger.isDebugEnabled()) {
            logger.debug("pairChannel = " + pairChannel);
        }
        CriticalPair<C> pair;
        //GenPolynomial<C> pi;
        //GenPolynomial<C> pj;
        //GenPolynomial<C> S;
        GenPolynomial<C> H = null;
        boolean set = false;
        boolean goon = true;
        int polIndex = -1;
        int red = 0;
        int sleeps = 0;

        // while more requests
        while (goon) {
            // receive request
            logger.debug("receive request");
            Object req = null;
            try {
                req = pairChannel.receive();
            } catch (IOException e) {
                goon = false;
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                goon = false;
                e.printStackTrace();
            }
            //logger.debug("received request, req = " + req);
            if (req == null) {
                goon = false;
                break;
            }
            if (!(req instanceof GBSPTransportMessReq)) {
                goon = false;
                break;
            }

            // find pair
            if (logger.isDebugEnabled()) {
                logger.debug("find pair");
                logger.debug("pool.hasJobs() " + pool.hasJobs() + " pairlist.hasNext() " + pairlist.hasNext());
            }
            while (!pairlist.hasNext()) { // wait
                pairlist.update();
                if (!set) {
                    pool.beIdle();
                    set = true;
                }
                if (!pool.hasJobs() && !pairlist.hasNext()) {
                    goon = false;
                    break;
                }
                try {
                    sleeps++;
                    if (sleeps % 10 == 0) {
                        logger.info(" reducer is sleeping");
                    }
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    goon = false;
                    break;
                }
            }
            if (!pairlist.hasNext() && !pool.hasJobs()) {
                goon = false;
                break; //continue; //break?
            }
            if (set) {
                set = false;
                pool.notIdle();
            }

            pair = pairlist.getNext();
            /*
             * send pair to client, receive H
             */
            if (logger.isDebugEnabled()) {
                logger.debug("send pair = " + pair);
                logger.info("theList keys " + theList.keySet());
            }
            if (logger.isDebugEnabled()) {
                logger.info("inWork " + pairlist.inWork());
            }
            GBSPTransportMess msg = null;
            if (pair != null) {
                msg = new GBSPTransportMessPairIndex(pair);
            } else {
                msg = new GBSPTransportMess(); //End();
                // goon ?= false;
            }
            try {
                pairChannel.send(msg);
            } catch (IOException e) {
                e.printStackTrace();
                goon = false;
                break;
            }
            // use idle time to update pairlist
            pairlist.update();
            //logger.debug("#distributed list = "+theList.size());
            //logger.debug("receive H polynomial");
            Object rh = null;
            try {
                rh = pairChannel.receive();
            } catch (IOException e) {
                e.printStackTrace();
                goon = false;
                break;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                goon = false;
                break;
            }
            if (logger.isDebugEnabled()) {
                logger.info("received H polynomial rh = " + rh);
            }
            if (rh == null) {
                if (pair != null) {
                    polIndex = pairlist.record(pair, null);
                    //pair.setZero();
                }
                pairlist.update();
            } else if (rh instanceof GBSPTransportMessPoly) {
                // update pair list
                red++;
                H = ((GBSPTransportMessPoly<C>) rh).pol;
                //logger.info("H = " + H);
                if (H == null) {
                    if (pair != null) {
                        polIndex = pairlist.record(pair, null);
                        //pair.setZero();
                    }
                    pairlist.update();
                } else {
                    if (H.isZERO()) {
                        polIndex = pairlist.record(pair, H);
                        //pair.setZero();
                    } else {
                        if (H.isONE()) {
                            // pool.allIdle();
                            pairlist.putOne();
                            theList.put(Integer.valueOf(0), H);
                            goon = false;
                            //break;
                        } else {
                            polIndex = pairlist.record(pair, H);
                            // not correct:
                            // polIndex = pairlist.getList().size(); 
                            // pairlist.update();
                            // polIndex = pairlist.put( H );
                            // use putWait ? but still not all distributed
                            theList.put(Integer.valueOf(polIndex), H);
                        }
                    }
                }
            } else {
                if (pair != null) {
                    polIndex = pairlist.record(pair, null);
                    //pair.setZero();
                }
                if (logger.isDebugEnabled()) {
                    logger.debug("invalid message " + rh);
                }
            }
        }
        logger.info("terminated, done " + red + " reductions");

        /*
         * send end mark to client
         */
        logger.debug("send end");
        try {
            pairChannel.send(new GBSPTransportMessEnd());
        } catch (IOException e) {
            if (logger.isDebugEnabled()) {
                e.printStackTrace();
            }
        }
        pool.beIdle();
        pairChannel.close();
    }

}


/**
 * Distributed GB transport message.
 */

class GBSPTransportMess implements Serializable {


    /**
     * toString.
     */
    @Override
    public String toString() {
        return "" + this.getClass().getName();
    }
}


/**
 * Distributed GB transport message for requests.
 */

class GBSPTransportMessReq extends GBSPTransportMess {


    public GBSPTransportMessReq() {
    }
}


/**
 * Distributed GB transport message for termination.
 */

class GBSPTransportMessEnd extends GBSPTransportMess {


    public GBSPTransportMessEnd() {
    }
}


/**
 * Distributed GB transport message for polynomial.
 */

class GBSPTransportMessPoly<C extends RingElem<C>> extends GBSPTransportMess {


    /**
     * The polynomial for transport.
     */
    public final GenPolynomial<C> pol;


    /**
     * GBSPTransportMessPoly.
     *
     * @param p polynomial to transfered.
     */
    public GBSPTransportMessPoly(GenPolynomial<C> p) {
        this.pol = p;
    }


    /**
     * toString.
     */
    @Override
    public String toString() {
        return super.toString() + "( " + pol + " )";
    }
}


/**
 * Distributed GB transport message for pairs.
 */

class GBSPTransportMessPair<C extends RingElem<C>> extends GBSPTransportMess {


    public final CriticalPair<C> pair;


    /**
     * GBSPTransportMessPair.
     *
     * @param p pair for transfer.
     */
    public GBSPTransportMessPair(CriticalPair<C> p) {
        this.pair = p;
    }


    /**
     * toString.
     */
    @Override
    public String toString() {
        return super.toString() + "( " + pair + " )";
    }
}


/**
 * Distributed GB transport message for index pairs.
 */

class GBSPTransportMessPairIndex extends GBSPTransportMess {


    public final Integer i;


    public final Integer j;


    /**
     * GBSPTransportMessPairIndex.
     *
     * @param p pair for transport.
     */
    public GBSPTransportMessPairIndex(CriticalPair p) {
        if (p == null) {
            throw new NullPointerException("pair may not be null");
        }
        this.i = Integer.valueOf(p.i);
        this.j = Integer.valueOf(p.j);
    }


    /**
     * GBSPTransportMessPairIndex.
     *
     * @param i first index.
     * @param j second index.
     */
    public GBSPTransportMessPairIndex(int i, int j) {
        this.i = Integer.valueOf(i);
        this.j = Integer.valueOf(j);
    }


    /**
     * GBSPTransportMessPairIndex.
     *
     * @param i first index.
     * @param j second index.
     */
    public GBSPTransportMessPairIndex(Integer i, Integer j) {
        this.i = i;
        this.j = j;
    }


    /**
     * toString.
     */
    @Override
    public String toString() {
        return super.toString() + "( " + i + "," + j + " )";
    }
}


/**
 * Distributed clients reducing worker threads.
 */

class ReducerClientSeqPair<C extends RingElem<C>> implements Runnable {


    private static final Logger logger = Logger.getLogger(ReducerClientSeqPair.class);
    private final SocketChannel pairChannel;
    private final DistHashTable<Integer, GenPolynomial<C>> theList;
    private final ReductionPar<C> red;


    ReducerClientSeqPair(SocketChannel pc, DistHashTable<Integer, GenPolynomial<C>> dl) {
        pairChannel = pc;
        theList = dl;
        red = new ReductionPar<C>();
    }


    public void run() {
        if (logger.isDebugEnabled()) {
            logger.debug("pairChannel = " + pairChannel + "reducer client running");
        }
        CriticalPair<C> pair = null;
        GenPolynomial<C> pi;
        GenPolynomial<C> pj;
        GenPolynomial<C> S;
        GenPolynomial<C> H = null;
        //boolean set = false;
        boolean goon = true;
        int reduction = 0;
        //int sleeps = 0;
        Integer pix;
        Integer pjx;

        while (goon) {
            /* protocol:
             * request pair, process pair, send result
             */
            // pair = (Pair) pairlist.removeNext();
            Object req = new GBSPTransportMessReq();
            if (logger.isDebugEnabled()) {
                logger.debug("send request = " + req);
            }
            try {
                pairChannel.send(req);
            } catch (IOException e) {
                goon = false;
                e.printStackTrace();
                break;
            }
            if (logger.isDebugEnabled()) {
                logger.debug("receive pair, goon = " + goon);
            }
            Object pp = null;
            try {
                pp = pairChannel.receive();
            } catch (IOException e) {
                goon = false;
                if (logger.isDebugEnabled()) {
                    e.printStackTrace();
                }
                break;
            } catch (ClassNotFoundException e) {
                goon = false;
                e.printStackTrace();
            }
            if (logger.isDebugEnabled()) {
                logger.info("received pair = " + pp);
            }
            H = null;
            if (pp == null) { // should not happen
                //logger.debug("received pair = " + pp);
                continue;
            }
            if (pp instanceof GBSPTransportMessEnd) {
                goon = false;
                continue;
            }
            if (pp instanceof GBSPTransportMessPair || pp instanceof GBSPTransportMessPairIndex) {
                pi = pj = null;
                if (pp instanceof GBSPTransportMessPair) {
                    pair = ((GBSPTransportMessPair<C>) pp).pair;
                    if (pair != null) {
                        pi = pair.pi;
                        pj = pair.pj;
                        //logger.debug("pair: pix = " + pair.i 
                        //               + ", pjx = " + pair.j);
                    }
                }
                if (pp instanceof GBSPTransportMessPairIndex) {
                    pix = ((GBSPTransportMessPairIndex) pp).i;
                    pjx = ((GBSPTransportMessPairIndex) pp).j;
                    //logger.info("waiting for pix = " + pix); 
                    pi = theList.getWait(pix);
                    //logger.info("waiting for pjx = " + pjx); 
                    pj = theList.getWait(pjx);
                    //logger.info("pix = " + pix + ", pjx = " +pjx);
                }

                if (logger.isDebugEnabled()) {
                    logger.info("pi = " + pi.leadingExpVector() + ", pj = " + pj.leadingExpVector());
                }
                if (pi != null && pj != null) {
                    S = red.SPolynomial(pi, pj);
                    //System.out.println("S   = " + S);
                    if (S.isZERO()) {
                        // pair.setZero(); does not work in dist
                        H = S;
                    } else {
                        if (logger.isDebugEnabled()) {
                            logger.debug("ht(S) = " + S.leadingExpVector());
                        }
                        H = red.normalform(theList, S);
                        reduction++;
                        if (H.isZERO()) {
                            // pair.setZero(); does not work in dist
                        } else {
                            H = H.monic();
                            if (logger.isDebugEnabled()) {
                                logger.info("ht(H) = " + H.leadingExpVector());
                            }
                        }
                    }
                }
            } else {
                if (logger.isDebugEnabled()) {
                    logger.debug("invalid message = " + pp);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // send H or must send null
            //logger.debug("#distributed list = "+theList.size());
            if (logger.isDebugEnabled()) {
                logger.info("send H polynomial = " + H);
            }
            try {
                pairChannel.send(new GBSPTransportMessPoly<C>(H));
            } catch (IOException e) {
                goon = false;
                e.printStackTrace();
                break;
            }
        }
        logger.info("terminated, done " + reduction + " reductions");
        pairChannel.close();
    }
}


/**
 * Distributed server reducing worker threads for minimal GB Not jet distributed
 * but threaded.
 */

class MiReducerServerSeqPair<C extends RingElem<C>> implements Runnable {


    private static final Logger logger = Logger.getLogger(MiReducerServerSeqPair.class);
    private final List<GenPolynomial<C>> G;
    private final Semaphore done = new Semaphore(0);


    private final Reduction<C> red;
    private GenPolynomial<C> H;


    MiReducerServerSeqPair(List<GenPolynomial<C>> G, GenPolynomial<C> p) {
        this.G = G;
        H = p;
        red = new ReductionPar<C>();
    }


    /**
     * getNF. Blocks until the normal form is computed.
     *
     * @return the computed normal form.
     */
    public GenPolynomial<C> getNF() {
        try {
            done.acquire(); //done.P();
        } catch (InterruptedException e) {
        }
        return H;
    }


    public void run() {
        if (logger.isDebugEnabled()) {
            logger.debug("ht(H) = " + H.leadingExpVector());
        }
        H = red.normalform(G, H); //mod
        done.release(); //done.V();
        if (logger.isDebugEnabled()) {
            logger.debug("ht(H) = " + H.leadingExpVector());
        }
        // H = H.monic();
    }
}


/**
 * Distributed clients reducing worker threads for minimal GB. Not jet used.
 */

class MiReducerClientSeqPair<C extends RingElem<C>> implements Runnable {


    private static final Logger logger = Logger.getLogger(MiReducerClientSeqPair.class);
    private final List<GenPolynomial<C>> G;
    private final Reduction<C> red;


    private final Semaphore done = new Semaphore(0);
    private GenPolynomial<C> H;


    MiReducerClientSeqPair(List<GenPolynomial<C>> G, GenPolynomial<C> p) {
        this.G = G;
        H = p;
        red = new ReductionPar<C>();
    }


    /**
     * getNF. Blocks until the normal form is computed.
     *
     * @return the computed normal form.
     */
    public GenPolynomial<C> getNF() {
        try {
            done.acquire(); //done.P();
        } catch (InterruptedException u) {
            Thread.currentThread().interrupt();
        }
        return H;
    }


    public void run() {
        if (logger.isDebugEnabled()) {
            logger.debug("ht(H) = " + H.leadingExpVector());
        }
        H = red.normalform(G, H); // mod
        done.release(); //done.V();
        if (logger.isDebugEnabled()) {
            logger.debug("ht(H) = " + H.leadingExpVector());
        }
        // H = H.monic();
    }
}
