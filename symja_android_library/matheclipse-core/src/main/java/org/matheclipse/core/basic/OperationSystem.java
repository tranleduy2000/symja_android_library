package org.matheclipse.core.basic;

public class OperationSystem {

    public static boolean debug = false;
    /**
     * Recommend value:
     * - JVM: 90% values of -Xmx argument
     * - iOS or MacOS 70%
     */
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
        checkMemory(0);
    }

    /**
     * @param additionalMemory approximately memory will be allocate after perform some operations.
     *                         Unit of bytes
     */
    public static void checkMemory(int additionalMemory) {
        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory();
        long usageMemory;
        if (isJvm()) {
            usageMemory = runtime.totalMemory() - runtime.freeMemory();
        } else {
            usageMemory = runtime.totalMemory();
        }
        usageMemory += additionalMemory;
        if (debug) {
            printMemoryUsage(maxMemory, usageMemory);
        }

        // value is valid
        if (maxMemory > 0 && maxMemory < Long.MAX_VALUE && usageMemory > 0) {
            float usageFactor = (float) usageMemory / maxMemory;
            if (usageFactor < 1.0f && usageFactor > memoryUsageFactor) {
                System.err.println("usageMemory = " + usageMemory + "; maxMemory = " + maxMemory);
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

    private static String toMegabytes(long bytes) {
        return (bytes / 1024 / 1024) + " MB";
    }
}
