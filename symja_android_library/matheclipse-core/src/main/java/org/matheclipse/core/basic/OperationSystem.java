package org.matheclipse.core.basic;

public class OperationSystem {
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
}
