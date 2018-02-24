/*
 * $Id$
 */

//package edu.unima.ky.parallel;
package edu.jas.util;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * SocketChannel provides a communication channel for Java objects using TCP/IP
 * sockets. Refactored for java.util.concurrent.
 *
 * @author Akitoshi Yoshida
 * @author Heinz Kredel
 */
public class SocketChannel {


    /*
     * Input stream from the socket.
     */
    private ObjectInputStream in;


    /*
     * Output stream to the socket.
     */
    private ObjectOutputStream out;


    /*
     * Underlying socket.
     */
//    private final Socket soc;


    /**
     * Sends an object
     */
    public void send(Object v) throws IOException {
        synchronized (out) {
            out.writeObject(v);
            out.flush();
        }
    }


    /**
     * Receives an object
     */
    public Object receive() throws IOException, ClassNotFoundException {
        Object v = null;
        synchronized (in) {
            v = in.readObject();
        }
        return v;
    }


    /**
     * Closes the channel.
     */
    public void close() {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
            }
        }
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
            }
        }
    }


    /**
     * to string
     */
    @Override
    public String toString() {
        return "socketChannel(" +  ")";
    }

}
