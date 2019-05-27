package com.duy;

import junit.framework.TestCase;

import org.matheclipse.core.basic.OperationSystem;
import org.matheclipse.core.eval.ExprEvaluator;
import org.matheclipse.core.interfaces.IExpr;

import java.util.ArrayList;

public class MemoryOverflowErrorTest extends TestCase {

    public void testPower() {
        IExpr result = new ExprEvaluator().eval("N(3123^22321321)");
        assertEquals(result.toString(), "Infinity");

        result = new ExprEvaluator().eval("3123^(1232321311/2131211123)");
        assertEquals(result.toString(), "Infinity");
    }

    public void testPower2() {
        OperationSystem.debug = true;
        IExpr result;
        result = new ExprEvaluator().eval("123232131112323213111232321311123232131112323211232321311123231232321123232131112323" +
                "^31112323213111232");
        assertEquals(result.toString(), "Infinity");
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
