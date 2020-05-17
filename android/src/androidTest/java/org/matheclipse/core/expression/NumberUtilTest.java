package org.matheclipse.core.expression;

import junit.framework.TestCase;

import java.math.BigInteger;

public class NumberUtilTest extends TestCase {

    public void testApproximatelyDigitCount() {
        assertEquals(NumberUtil.calculateApproximatelyDigitCount(new BigInteger("102")), 3);
        assertEquals(NumberUtil.calculateApproximatelyDigitCount(new BigInteger("-102")), 3);
        assertEquals(NumberUtil.calculateApproximatelyDigitCount(new BigInteger("-121302")), 6);
        assertEquals(NumberUtil.calculateApproximatelyDigitCount(new BigInteger("121302")), 6);
        assertEquals(NumberUtil.calculateApproximatelyDigitCount(new BigInteger("1")), 1);
    }

    public void test2() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            s.append("1");
        }
        System.out.println("String size = " + s.length() * 2 + " bytes");
        BigInteger number = new BigInteger(s.toString());
        System.out.println("bitCount = " + number.bitCount());
        System.out.println("bitLength = " + number.bitLength() + " ; " + number.bitLength() / 8);
        System.out.println("approximatelyDigitCount = " + NumberUtil.calculateApproximatelyDigitCount(number));
        System.out.println("calculateApproximatelySizeOf = " + NumberUtil.calculateApproximatelySizeOf(number) + " bytes");
        System.out.println("actual size = 41544 bytes (mag.length * 4 + 4 * 5)");
    }

    public void test3() {
        BigInteger number = new BigInteger("9").pow(333);
        System.out.println("approximatelyDigitCount = " + NumberUtil.calculateApproximatelyDigitCount(number));
    }

    public void test() {
        BigInteger nine = new BigInteger("9");
        BigInteger integer = nine.pow(9).pow(9).pow(9).pow(9);
        System.out.println();
    }
}