/*
 * java-math-library is a Java library focused on number theory, but not necessarily limited to it. It is based on the PSIQS 4.0 factoring project.
 * Copyright (C) 2018 Tilman Neumann (www.tilman-neumann.de)
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this program;
 * if not, see <http://www.gnu.org/licenses/>.
 */
package de.tilman_neumann.jml.factor.tdiv;

import org.apache.log4j.Logger;

import java.math.BigInteger;

import de.tilman_neumann.jml.factor.FactorAlgorithmBase;
import de.tilman_neumann.jml.primes.bounds.PrimeCountUpperBounds;
import de.tilman_neumann.jml.primes.exact.AutoExpandingPrimesArray;

/**
 * Trial division factor algorithm replacing division by multiplications.
 * 
 * Instead of dividing N by consecutive primes, we store the reciprocals of those primes, too,
 * and multiply N by those reciprocals. Only if such a result is near to an integer we need
 * to do a division.
 * 
 * Assuming that we want to identify "near integers" with a precision of 2^-d.
 * Then the approach works for primes p if bitLength(p) >= bitLength(N) - 53 + d.
 * 
 * @authors Thilo Harich + Tilman Neumann
 */
public class TDiv63Inverse extends FactorAlgorithmBase {
	private static final Logger LOG = Logger.getLogger(TDiv63Inverse.class);
	private static AutoExpandingPrimesArray SMALL_PRIMES = AutoExpandingPrimesArray.get().ensurePrimeCount(NUM_PRIMES_FOR_31_BIT_TDIV);

	private static final int DISCRIMINATOR_BITS = 10; // experimental result
	private static final double DISCRIMINATOR = 1.0/(1<<DISCRIMINATOR_BITS);
	
	private int[] primes;
	private double[] reciprocals;
	private int pLimit;

	/**
	 * Create a trial division algorithm that is capable of finding factors up to factorLimit.
	 * @param factorLimit
	 */
	public TDiv63Inverse(int factorLimit) {
		pLimit = factorLimit; // default if not set explicitly
		int primeCountBound = (int) PrimeCountUpperBounds.combinedUpperBound(factorLimit);
		primes = new int[primeCountBound];
		reciprocals = new double[primeCountBound];
		for (int i=0; i<primeCountBound; i++) {
			int p = SMALL_PRIMES.getPrime(i);
			primes[i] = p;
			reciprocals[i] = 1.0/p;
		}
	}
	
	@Override
	public String getName() {
		return "TDiv63Inverse";
	}

	/**
	 * Set the upper limit of primes to be tested in the next findSingleFactor() run.
	 * pLimit must be smaller than the factorLimit parameter passed to the constructor.
	 * @param pLimit
	 */
	public void setTestLimit(int pLimit) {
		this.pLimit = pLimit;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * This implementation will return 0 if the smallest factor of N is greater than pLimit.
	 */
	@Override
	public BigInteger findSingleFactor(BigInteger N) {
		return BigInteger.valueOf(findSingleFactor(N.longValue()));
	}


	public int findSingleFactor(long N) {
		int i=0;
		int Nbits = 64-Long.numberOfLeadingZeros(N);
		int pMinBits = Nbits - 53 + DISCRIMINATOR_BITS;
		if (pMinBits>0) {
			// for the smallest primes we must do standard trial division
			int pMin = 1<<pMinBits;
			for ( ; primes[i]<pMin; i++) {
				if (N%primes[i]==0) {
					return primes[i];
				}
			}
		}

		// Now the primes are big enough to apply trial division by inverses
		for (; primes[i]<=pLimit; i++) {
			//LOG.debug("N=" + N + ": Test p=" + primes[i]);
			long nDivPrime = (long) (N*reciprocals[i] + DISCRIMINATOR);
			if (nDivPrime * primes[i] == N) {
				// nDivPrime is very near to an integer
				if (N%primes[i]==0) {
					//LOG.debug("Found factor " + primes[i]);
					return primes[i];
				}
			}
		}

		// nothing found up to pLimit
		return 0;
	}
	
	/**
	 * Test.
	 * @param args ignored
	 */
//	public static void main(String[] args) {
//		ConfigUtil.initProject();
//
//		// test special cases
//		TDiv63Inverse tdivInv = new TDiv63Inverse(1<<21);
//		SquFoF63 testFactorizer = new SquFoF63();
//		long[] specialN = new long[] {
//				// first charge
//				621887327L,
//				676762483L,
//				2947524803L,
//				5616540799L,
//				35936505149L,
//				145682871839L,
//				317756737253L,
//				3294635112749L,
//				// second charge
//				13293477682249L,
//				24596491225651L, // = 3311299 * 7428049; can not be found with factorLimit=2^21
//				44579405690563L,
//				72795445155721L,
//				155209074377713L,
//				293851765137859L, // = 11736397 * 25037647; can not be found with factorLimit=2^21
//				67915439339311L // = 2061599 * 32943089, ok
//		};
//		for (long N : specialN) {
//			long tdivFactor = tdivInv.findSingleFactor(N);
//			long testFactor = testFactorizer.findSingleFactor(N);
//			LOG.info("tdivFactor=" + tdivFactor);
//			LOG.info("testFactor=" + testFactor);
//		}
//
//		// test random N
//		SecureRandom RNG = new SecureRandom();
//		int count = 100000;
//		for (int bits=10; bits<63; bits++) {
//			LOG.info("Testing " + count + " random numbers with " + bits + " bits...");
//			tdivInv.setTestLimit(1<<Math.min(21, (bits+1)/2));
//			int failCount = 0;
//			for (int i=0; i<count; i++) {
//				long N = 0;
//				while (true) { 
//					BigInteger N_big = new BigInteger(bits, RNG);
//					N = N_big.longValue();
//					if (N>2 && !N_big.isProbablePrime(20)) break;
//				}
//				long tdivFactor = tdivInv.findSingleFactor(N);
//				if (tdivFactor<2) {
//					long testFactor = testFactorizer.findSingleFactor(N);
//					if (testFactor > 1 && testFactor<N) {
//						//LOG.debug("N=" + N + ": TDiv failed to find factor " + testFactor);
//						failCount++;
//					} else {
//						LOG.error("The test factorizer failed to factor N=" + N + " !");
//					}
//				} else {
//					if (N%tdivFactor!=0) {
//						failCount++;
//					}
//				}
//			}
//			LOG.info("    #fails = " + failCount);
//		}
//	}
}
