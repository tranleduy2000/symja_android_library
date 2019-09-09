/*
 * (C) Copyright 2014-2016, by Dimitrios Michail
 *
 * JHeaps Library
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jheaps.monotone;

import org.jheaps.AddressableHeap;

import java.lang.reflect.Array;
import java.math.BigInteger;

/**
 * An addressable radix heap for {@link BigInteger} keys. The heap stores
 * {@link BigInteger} keys sorted according to the {@linkplain Comparable
 * natural ordering} of its keys. A radix heap is a monotone heap, especially
 * designed for algorithms (such as Dijkstra) which scan elements in order of
 * nondecreasing keys.
 *
 * <p>
 * The implementation use arrays in order to store the elements. Operations
 * {@code insert} and {@code findMin} are worst-case constant time. The cost of
 * operation {@code deleteMin} is amortized O(logC) assuming the radix-heap
 * contains keys in the range {@literal [0, C]} or equivalently
 * {@literal [a,a+C]}.
 *
 * <p>
 * <strong>Note that this implementation is not synchronized.</strong> If
 * multiple threads access a heap concurrently, and at least one of the threads
 * modifies the heap structurally, it <em>must</em> be synchronized externally.
 * (A structural modification is any operation that adds or deletes one or more
 * elements or changing the key of some element.) This is typically accomplished
 * by synchronizing on some object that naturally encapsulates the heap.
 *
 * @param <V> the type of values maintained by this heap
 * @author Dimitrios Michail
 * @see AddressableHeap
 */
public class BigIntegerRadixAddressableHeap<V> extends AbstractRadixAddressableHeap<BigInteger, V> {

    private final static long serialVersionUID = 1;

    /**
     * Constructs a new heap which can store values between a minimum and a
     * maximum key value (inclusive).
     * <p>
     * It is important to use the smallest key range as the heap uses O(logC)
     * where C=maxKey-minKey+1 buckets to store elements. Moreover, the
     * operation {@code deleteMin} requires amortized O(logC) time.
     *
     * @param minKey the non-negative minimum key that this heap supports
     *               (inclusive)
     * @param maxKey the maximum key that this heap supports (inclusive)
     * @throws IllegalArgumentException if the minimum key is negative
     * @throws IllegalArgumentException if the maximum key is less than the minimum key
     */
    @SuppressWarnings("unchecked")
    public BigIntegerRadixAddressableHeap(BigInteger minKey, BigInteger maxKey) {
        super();
        if (minKey == null) {
            throw new IllegalArgumentException("Minimum key cannot be null");
        }
        if (minKey.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("Minimum key must be non-negative");
        }
        this.minKey = minKey;
        this.lastDeletedKey = minKey;
        if (maxKey == null) {
            throw new IllegalArgumentException("Maximum key cannot be null");
        }
        if (maxKey.compareTo(minKey) < 0) {
            throw new IllegalArgumentException("Maximum key cannot be less than the minimum");
        }
        this.maxKey = maxKey;

        // compute number of buckets
        BigInteger diff = maxKey.subtract(minKey);
        int numBuckets = 2 + 1 + diff.bitLength();

        // construct representation
        this.buckets = (Node[]) Array.newInstance(Node.class, numBuckets);
        this.size = 0;
        this.currentMin = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected int compare(BigInteger o1, BigInteger o2) {
        return o1.compareTo(o2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected int msd(BigInteger a, BigInteger b) {
        if (a.equals(b)) {
            return -1;
        }
        /*
         * return floor(log_2(a xor b)).
         */
        return a.xor(b).bitLength() - 1;
    }

}
