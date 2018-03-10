package com.duy;

import org.matheclipse.core.system.AbstractTestCase;

/**
 * Created by Duy on 10-Mar-18.
 */

public class RandomTest extends AbstractTestCase {
    public RandomTest(String name) {
        super(name);
    }

    public void test1(){
        check("RandomInteger(1)", "0");
        check("RandomReal()*0", "0.0");
    }
}
