package com.duy;

import junit.framework.TestCase;

import org.matheclipse.core.basic.OperationSystem;
import org.matheclipse.core.eval.ExprEvaluator;
import org.matheclipse.core.interfaces.IExpr;

import java.util.ArrayList;

public class MemoryOverflowErrorTest extends TestCase {

    public void test1() {
        IExpr result = new ExprEvaluator().eval("N(3123^22321321)");
        assertEquals(result.toString(), "Infinity");
    }

    public void test4() throws InterruptedException {
        try {
            //noinspection MismatchedQueryAndUpdateOfCollection
            ArrayList<int[]> arrayList = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                arrayList.add(new int[4000000]);
                Runtime runtime = Runtime.getRuntime();
                System.out.println("maxMemory = " + toMegabytes(runtime.maxMemory()));
                System.out.println("totalMemory = " + toMegabytes(runtime.totalMemory()));
                System.out.println("freeMemory = " + toMegabytes(runtime.freeMemory()));
                System.out.println("usageMemory = " + toMegabytes(runtime.totalMemory() - runtime.freeMemory()));
                System.out.println();
                Thread.sleep(100);
                OperationSystem.checkMemory();
            }
        } catch (OutOfMemoryError error) {
            return;
        }
        fail();
    }

    private String toMegabytes(long bytes) {
        return String.format("%d MB", bytes / 1024 / 1024);
    }
}
