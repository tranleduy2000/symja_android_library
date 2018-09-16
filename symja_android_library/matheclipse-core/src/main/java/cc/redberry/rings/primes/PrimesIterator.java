package cc.redberry.rings.primes;

import cc.redberry.rings.bigint.BigInteger;

import java.util.Arrays;

/**
 * Iterator over prime numbers.
 */
public final class PrimesIterator {
    private final int[] smallPrimes = SmallPrimes.SmallPrimes12;
    private long pointer;
    private int smallPrimesPointer = Integer.MAX_VALUE;
    private static final int largeSieveLimit = 16777216;
    private final SieveOfAtkin smallSieve = SieveOfAtkin.SmallPrimesSieve;
    private SieveOfAtkin largeSieve = null;

    /**
     * Create iterator over prime numbers starting from 2.
     */
    public PrimesIterator() {pointer = 0;}

    /**
     * Create iterator over prime numbers starting from the prime closest to the specified value (prime >= from)
     */
    public PrimesIterator(long from) {
        if (from < smallPrimes[smallPrimes.length - 1]) {
            smallPrimesPointer = Arrays.binarySearch(smallPrimes, (int) from);
            if (smallPrimesPointer < 0) smallPrimesPointer = ~smallPrimesPointer;
            pointer = smallPrimes[smallPrimesPointer];
        } else pointer = from;
    }

    /**
     * Get the next prime number
     */
    public long take() {
        if (smallPrimesPointer < smallPrimes.length)
            return (pointer = smallPrimes[smallPrimesPointer++] + 1) - 1;

        for (; pointer < smallSieve.getLimit(); ) {
            if (smallSieve.isPrime((int) (pointer++)))
                return pointer - 1;
        }

        if (pointer < largeSieveLimit) {
            if (largeSieve == null)
                largeSieve = SieveOfAtkin.createSieve(largeSieveLimit);

            for (; pointer < largeSieve.getLimit(); )
                if (largeSieve.isPrime((int) pointer++))
                    return pointer - 1;
        }

        if (pointer < Integer.MAX_VALUE - 1)
            return pointer = SmallPrimes.nextPrime((int) (pointer + 1));

        if (pointer < Long.MAX_VALUE - 1)
            try {
                return pointer = BigPrimes.nextPrime(BigInteger.valueOf(pointer + 1)).longValueExact();
            } catch (ArithmeticException e) {
                return -1;
            }

        return -1;
    }
}
