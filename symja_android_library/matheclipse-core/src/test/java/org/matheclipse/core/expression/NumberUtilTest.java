package org.matheclipse.core.expression;

import junit.framework.TestCase;

import java.math.BigInteger;

public class NumberUtilTest extends TestCase {

    public void testApproximatelyDigitCount() {
        assertEquals(NumberUtil.approximatelyDigitCount(new BigInteger("102")), 3);
        assertEquals(NumberUtil.approximatelyDigitCount(new BigInteger("-102")), 3);
        assertEquals(NumberUtil.approximatelyDigitCount(new BigInteger("-121302")), 6);
        assertEquals(NumberUtil.approximatelyDigitCount(new BigInteger("121302")), 6);
        assertEquals(NumberUtil.approximatelyDigitCount(new BigInteger("1")), 1);
    }

    public void test2() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            s.append("1");
        }
        System.out.println("String size = " + s.length() * 2 + " bytes");
        BigInteger number = new BigInteger(s.toString());
        System.out.println("bitCount = " + number.bitCount());
        System.out.println("approximatelyDigitCount = " + NumberUtil.approximatelyDigitCount(number));
        System.out.println("actual size = 41544 (mag.length * 4 + 4 * 5)");
    }
}