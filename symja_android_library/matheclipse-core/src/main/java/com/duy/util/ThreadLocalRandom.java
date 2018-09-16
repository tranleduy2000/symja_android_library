package com.duy.util;

import java.util.Random;

/**
 * Created by Duy on 23-Apr-18.
 */

public class ThreadLocalRandom extends Random {
    private static final ThreadLocalRandom RANDOM = new ThreadLocalRandom(System.currentTimeMillis());

    public ThreadLocalRandom(long seek) {
        super(seek);
    }

    public static ThreadLocalRandom current() {
        return RANDOM;
    }
}
