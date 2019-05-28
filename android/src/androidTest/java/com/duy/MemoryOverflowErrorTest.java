package com.duy;

import junit.framework.TestCase;

import org.matheclipse.core.basic.OperationSystem;
import org.matheclipse.core.eval.ExprEvaluator;
import org.matheclipse.core.interfaces.IExpr;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class MemoryOverflowErrorTest extends TestCase {

    public void testPower() {
        IExpr result = new ExprEvaluator().eval("N(3123^22321321)");
        assertEquals(result.toString(), "Infinity");

        result = new ExprEvaluator().eval("3123^(1232321311/2131211123)");
        assertEquals(result.toString(), "Infinity");
    }

    public void testPower2() throws InterruptedException {
        OperationSystem.debug = true;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CountDownLatch countDownLatch = new CountDownLatch(availableProcessors);
        for (int i = 0; i < availableProcessors; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    new ExprEvaluator().eval("31112323213111232" +
                            "^31112323213111232");
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
    }

    public void test2() throws InterruptedException {
        try {
            OperationSystem.debug = true;
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
