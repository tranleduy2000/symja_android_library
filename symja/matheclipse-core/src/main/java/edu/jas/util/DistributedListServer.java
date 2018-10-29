/*
 * $Id$
 */

package edu.jas.util;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;

//import edu.unima.ky.parallel.ChannelFactory;
//import edu.unima.ky.parallel.SocketChannel;


/**
 * Class for holding the list index used as key in TreeMap.
 * Implemented since Integer has no add() method.
 * Must implement Comparable so that TreeMap works with correct ordering.
 */

class Counter implements Serializable, Comparable<Counter> {

    private int value;


    /**
     * Counter.
     */
    public Counter() {
        this(0);
    }


    /**
     * Counter.
     *
     * @param v
     */
    public Counter(int v) {
        value = v;
    }


    /**
     * intValue.
     *
     * @return the value.
     */
    public int intValue() {
        return value;
    }


    /**
     * add.
     *
     * @param v
     */
    public void add(int v) { // synchronized elsewhere
        value += v;
    }


    /**
     * equals.
     *
     * @param ob an Object.
     * @return true if this is equal to o, else false.
     */
    @Override
    public boolean equals(Object ob) {
        if (!(ob instanceof Counter)) {
            return false;
        }
        return 0 == compareTo((Counter) ob);
    }


    /**
     * compareTo.
     *
     * @param c a Counter.
     * @return 1 if (this &lt; c), 0 if (this == c), -1 if (this &gt; c).
     */
    public int compareTo(Counter c) {
        int x = c.intValue();
        if (value > x) {
            return 1;
        }
        if (value < x) {
            return -1;
        }
        return 0;
    }


    /**
     * Hash code for this Counter.
     *
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {
        return value;
    }


    /**
     * toString.
     */
    @Override
    public String toString() {
        return "Counter(" + value + ")";
    }

}


/**
 * Thread for broadcasting all incoming objects to the list clients.
 */

class Broadcaster extends Thread /*implements Runnable*/ {

    private static final Logger logger = Logger.getLogger(Broadcaster.class);
    private final SocketChannel channel;
    private final List bcaster;
    private final SortedMap<Counter, Object> theList;
    private Counter listElem;


    /**
     * Broadcaster.
     *
     * @param s  SocketChannel to use.
     * @param p  list of broadcasters.
     * @param le counter
     * @param sm SortedMap with counter value pairs.
     */
    public Broadcaster(SocketChannel s, List p, Counter le, SortedMap<Counter, Object> sm) {
        channel = s;
        bcaster = p;
        listElem = le;
        theList = sm;
    }


    /**
     * closeChannel.
     */
    public void closeChannel() {
        channel.close();
    }


    /**
     * sendChannel.
     *
     * @param n counter.
     * @param o value.
     * @throws IOException
     */
    public void sendChannel(Object n, Object o) throws IOException {
        synchronized (channel) {
            channel.send(n);
            channel.send(o);
        }
    }


    /**
     * broadcast.
     *
     * @param o object to store and send.
     */
    public void broadcast(Object o) {
        Counter li = null;
        synchronized (listElem) {
            listElem.add(1);
            li = new Counter(listElem.intValue());
        }
        synchronized (theList) {
            theList.put(li, o);
        }
        synchronized (bcaster) {
            Iterator it = bcaster.iterator();
            while (it.hasNext()) {
                Broadcaster br = (Broadcaster) it.next();
                try {
                    br.sendChannel(li, o);
                    //System.out.println("bcast: "+o+" to "+x.channel);
                } catch (IOException e) {
                    try {
                        br.closeChannel();
                        while (br.isAlive()) {
                            br.interrupt();
                            br.join(100);
                        }
                    } catch (InterruptedException u) {
                        Thread.currentThread().interrupt();
                    }
                    bcaster.remove(br);
                }
            }
        }
    }


    /**
     * run.
     */
    @Override
    public void run() {
        Object o;
        boolean goon = true;
        while (goon) {
            try {
                o = channel.receive();
                //System.out.println("receive: "+o+" from "+channel);
                broadcast(o);
                if (this.isInterrupted()) {
                    goon = false;
                }
            } catch (IOException e) {
                goon = false;
            } catch (ClassNotFoundException e) {
                goon = false;
                e.printStackTrace();

            }
        }
        logger.debug("broadcaster terminated " + this);
        channel.close();
    }


    /**
     * toString.
     *
     * @return a string representation of this.
     */
    @Override
    public String toString() {
        return "Broadcaster(" + channel + "," + bcaster.size() + "," + listElem + ")";
    }

}
