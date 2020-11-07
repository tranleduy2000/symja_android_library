package com.duy.math;

import java.math.BigInteger;

public class BigIntegerUtils {

    public static int intValueExact(BigInteger bigInteger) {
        long num = bigInteger.longValue();
        if ((int) num != num)
            throw new java.lang.ArithmeticException("Overflow");
        return (int) num;
    }

}
