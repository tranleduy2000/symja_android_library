package com.duy.util;

import java.util.Random;

/**
 * Created by Duy on 23-Apr-18.
 */

public class ThreadLocalRandom {
    private static final Random RANDOM = new Random(System.currentTimeMillis());

    public static Random current() {
        return RANDOM;
    }
}
