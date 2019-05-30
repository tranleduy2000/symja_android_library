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
}