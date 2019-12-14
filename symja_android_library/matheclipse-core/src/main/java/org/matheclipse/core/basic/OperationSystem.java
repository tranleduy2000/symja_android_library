package org.matheclipse.core.basic;

@SuppressWarnings("unused")
public class OperationSystem {

    public static boolean debug = false;

    /**
     * Is running on JVM or not
     */
    private static boolean jvm = true;

    /**
     * Maximum memory can use by this process
     */
    private static float maxMemoryUsageFactor = 0.9f;

    /**
     * This field should be set to true if the application receive memory warning, typically in
     * AppDelegate.swift
     * Before calculating, this field should set to true
     */
    private static boolean memoryWarning = false;

    /**
     * Maximum number of bytes the heap can expand to. Negative values mean default JVM value
     */
    private static long maxMemory = -1;

    static {
        setJvm(true);
    }

    public static boolean isJvm() {
        return jvm;
    }

    public static void setJvm(boolean jvm) {
        OperationSystem.jvm = jvm;
    }

    public static float getMemoryUsageFactor() {
        return maxMemoryUsageFactor;
    }

    public static void setMemoryUsageFactor(float memoryUsageFactor) {
        OperationSystem.maxMemoryUsageFactor = memoryUsageFactor;
    }

    public static void setMemoryWarning(boolean memoryWarning) {
        OperationSystem.memoryWarning = memoryWarning;
    }

    public static void checkMemory() {
        checkMemory(0);
    }

    public static long getMaxMemory() {
        return maxMemory;
    }

    public static void setMaxMemory(long maxMemory) {
        OperationSystem.maxMemory = maxMemory;
    }

    /**
     * @param additionalMemoryInBytes approximately memory will be allocate after perform some operations.
     *                                Unit of bytes
     */
    public static void checkMemory(int additionalMemoryInBytes) {
        if (isJvm()) {
            Runtime runtime = Runtime.getRuntime();
            if (maxMemory <= 0) {
                maxMemory = runtime.maxMemory();
            }
            long usedMemory = runtime.totalMemory() - runtime.freeMemory() + additionalMemoryInBytes;

            if (debug) {
                printMemoryUsage(maxMemory, usedMemory);
            }

            // value is valid
            if (maxMemory > 0 && maxMemory < Long.MAX_VALUE && usedMemory > 0) {
                float usageFactor = (float) usedMemory / maxMemory;
                if (usageFactor < 1.0f && usageFactor > maxMemoryUsageFactor) {
                    if (debug) {
                        System.err.println("usedMemory = " + usedMemory + "; maxMemory = " + maxMemory);
                    }
                    throw new OutOfMemoryError("Out of memory");
                }
            }
        } else {
            if (maxMemory <= 0) {
                return;
            }
            Runtime runtime = Runtime.getRuntime();
            long usedMemory = runtime.totalMemory() + additionalMemoryInBytes;
            if (debug) {
                printMemoryUsage(maxMemory, usedMemory);
            }
            if (usedMemory > maxMemory || memoryWarning) {
                if (debug) {
                    System.err.println("usedMemory = " + usedMemory + "; maxMemory = " + maxMemory);
                }
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
