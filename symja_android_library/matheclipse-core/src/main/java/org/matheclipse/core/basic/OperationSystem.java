package org.matheclipse.core.basic;

public class OperationSystem {
    private static boolean jvm = true;
    private static boolean debug = false;

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
        final float memoryUsageFactor = 0.85f;
        long freeMemory = Runtime.getRuntime().freeMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();
        if (debug) {
            printMemoryUsage(freeMemory, totalMemory);
        }

        // value is valid
        if (totalMemory > 0 && freeMemory > 0) {
            float usageFactor = (1.0f * totalMemory - freeMemory) / totalMemory;
            if (usageFactor < 1.0f && usageFactor > memoryUsageFactor) {
                System.err.println("freeMemory = " + freeMemory + "; totalMemory = " + totalMemory);
                throw new OutOfMemoryError("Out of memory");
            }
        }
    }

    private static void printMemoryUsage(long freeMemory, long totalMemory) {
        int max = 50;
        int usage = (int) (((1.0f * totalMemory - freeMemory) / totalMemory) * max);
        StringBuilder str = new StringBuilder("[");
        for (int i = 1; i <= max; i++) {
            if (i <= usage) {
                str.append("=");
            } else {
                str.append(" ");
            }
        }
        str.append("] ");
        str.append(" Max = ").append(totalMemory / 1024 / 1024).append(" MB").append(";");
        str.append(" Free = ").append(freeMemory / 1024 / 1024).append(" MB");
        System.out.println(str);
    }
}
