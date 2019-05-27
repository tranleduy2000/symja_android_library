package org.matheclipse.core.basic;

import android.annotation.SuppressLint;

public class OperationSystem {
    public static boolean debug = false;
    public static float memoryUsageFactor = 0.9f;
    private static boolean jvm = true;

    static {
        setJvm(true);
    }

    public static boolean isJvm() {
        return jvm;
    }

    public static void setJvm(boolean jvm) {
        OperationSystem.jvm = jvm;
    }

    public static void checkMemory() {
        long memoryUsage = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();
        if (debug) {
            printMemoryUsage(maxMemory, memoryUsage);
        }

        // value is valid
        if (maxMemory > 0
                && maxMemory < Long.MAX_VALUE
                && memoryUsage > 0) {
            float usageFactor = (float) memoryUsage / maxMemory;
            if (usageFactor < 1.0f && usageFactor > memoryUsageFactor) {
                System.err.println("freeMemory = " + memoryUsage + "; maxMemory = " + maxMemory);
                throw new OutOfMemoryError("Out of memory");
            }
        }
    }

    private static void printMemoryUsage(long maxMemory, long usageMemory) {
        int max = 50;
        int usage = (int) (((float) usageMemory / maxMemory) * max);
        StringBuilder str = new StringBuilder("[");
        for (int i = 1; i <= max; i++) {
            if (i <= usage) {
                str.append("=");
            } else {
                str.append(" ");
            }
        }
        str.append("] ");
        str.append(" ").append(toMegabytes(usageMemory)).append("/").append(toMegabytes(maxMemory));
        System.out.println(str);
    }

    @SuppressLint("DefaultLocale")
    private static String toMegabytes(long bytes) {
        return String.format("%5d MB", bytes / 1024 / 1024);
    }
}
