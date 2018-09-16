package cc.redberry.combinatorics;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * This class provides factory and utility methods for combinatorics infrastructure.
 *
 * @author Dmitry Bolotin
 * @author Stanislav Poslavsky
 * @since 1.0
 */
public final class Combinatorics {
    private Combinatorics() {}

    /**
     * Iterator over all k-combinations from {code n}.
     *
     * @param n combination length
     * @param k the total
     */
    public static CombinatorialIterator<int[]> combinations(int n, int k) {
        if (n < k)
            throw new IllegalArgumentException();
        return new IntCombinations(n, k);
    }

    /**
     * Iterator over all k-combinations with permutations from {code n}.
     *
     * @param n combination length
     * @param k the total
     */
    public static CombinatorialIterator<int[]> combinationsWithPermutations(int n, int k) {
        if (n < k)
            throw new IllegalArgumentException();
        if (n == k)
            return new IntPermutations(n);
        else
            return new IntCombinationsWithPermutations(n, k);
    }

    /**
     * Iterator over all permutations of the specified length
     */
    public static CombinatorialIterator<int[]> permutations(int n) {
        return new IntPermutations(n);
    }

    /**
     * Iterator over all compositions of {@code integer} into {@code nPartitions}
     *
     * @param integer     the sum
     * @param nPartitions number of partitions
     * @see IntCompositions
     */
    public static CombinatorialIterator<int[]> compositions(int integer, int nPartitions) {
        return new IntCombinatorialPort.Iterator(new IntCompositions(integer, nPartitions));
    }

    /**
     * Iterator over all distinct N-tuples, which can be chosen from {@code N} specified sets of integers.
     *
     * @param sets array of sets of integers
     * @see IntDistinctTuples
     */
    public static CombinatorialIterator<int[]> distinctTuples(int[]... sets) {
        return new IntCombinatorialPort.Iterator(new IntDistinctTuples(deepClone(sets)));
    }

    private static int[][] deepClone(int[][] sets) {
        sets = sets.clone();
        for (int i = 0; i < sets.length; i++)
            sets[i] = sets[i].clone();
        return sets;
    }

    /**
     * Iterator over all N-tuples (not necessary to be distinct), which can be chosen from {@code N} arrays of integers
     * of the form <i>array</i><sub>i</sub> = [0, 1, 2, ..., K<sub>i</sub>]
     *
     * @param bounds the bounds on the tuple elements
     * @see IntDistinctTuples
     */
    public static CombinatorialIterator<int[]> tuples(int... bounds) {
        return new IntCombinatorialPort.Iterator(new IntTuples(bounds));
    }

    static final Comparator<int[]> arrayComparator = (o1, o2) -> {
        int comp = Integer.compare(o1.length, o2.length);
        if (comp != 0)
            return comp;
        for (int i = 0; i < o1.length; i++)
            if ((comp = Integer.compare(o1[i], o2[i])) != 0)
                return comp;
        return 0;
    };

    private interface ArrayFactory<T> {
        T[] create(int len);
    }

    @SuppressWarnings("unchecked")
    private static final class GenericFactory<T> implements ArrayFactory<T> {
        final Class<T> tClass;

        GenericFactory(Class<T> tClass) { this.tClass = tClass; }

        GenericFactory(T el) { this((Class<T>) el.getClass()); }

        GenericFactory(T[] el) { this((Class<T>) el.getClass().getComponentType()); }

        @Override
        @SuppressWarnings("unchecked")
        public T[] create(int len) {
            return (T[]) Array.newInstance(tClass, len);
        }
    }

    private static <T> T[] map(T[] array, int[] indices, ArrayFactory<T> factory) {
        T[] r = factory.create(indices.length);
        for (int i = 0; i < indices.length; i++)
            r[i] = array[indices[i]];
        return r;
    }

    static final class TIterator<T> implements CombinatorialIterator<T[]> {
        final T[] initialArray;
        final ArrayFactory<T> factory;
        final CombinatorialIterator<int[]> intIterator;

        public TIterator(T[] initialArray, ArrayFactory<T> factory, CombinatorialIterator<int[]> intIterator) {
            this.initialArray = initialArray;
            this.factory = factory;
            this.intIterator = intIterator;
        }

        @Override
        public void reset() {
            intIterator.reset();
        }

        @Override
        public T[] current() {
            return map(initialArray, intIterator.current(), factory);
        }

        @Override
        public boolean hasNext() {
            return intIterator.hasNext();
        }

        @Override
        public T[] next() {
            return map(initialArray, intIterator.next(), factory);
        }
    }

    /**
     * Iterator over all permutations of the specified array
     */
    public static <T> CombinatorialIterator<T[]> permutations(final T[] input) {
        return new TIterator<>(input, new GenericFactory<>(input), permutations(input.length));
    }

    /**
     * Iterator over all k-combinations from the specified array
     */
    public static <T> CombinatorialIterator<T[]> combinations(final T[] input, int k) {
        return new TIterator<>(input, new GenericFactory<>(input), combinations(input.length, k));
    }

    /**
     * Iterator over all k-combinations with permutations from the specified array
     */
    public static <T> CombinatorialIterator<T[]> combinationsWithPermutations(final T[] input, int k) {
        return new TIterator<>(input, new GenericFactory<>(input), combinationsWithPermutations(input.length, k));
    }

    private static <T> T[] map(T[][] arrays, int[] indices, ArrayFactory<T> factory) {
        T[] r = factory.create(arrays.length);
        for (int i = 0; i < arrays.length; i++)
            r[i] = arrays[i][indices[i]];
        return r;
    }

    static final class TTIterator<T> implements CombinatorialIterator<T[]> {
        final T[][] initialArray;
        final ArrayFactory<T> factory;
        final CombinatorialIterator<int[]> intIterator;

        public TTIterator(T[][] initialArray, ArrayFactory<T> factory, CombinatorialIterator<int[]> intIterator) {
            this.initialArray = initialArray;
            this.factory = factory;
            this.intIterator = intIterator;
        }

        @Override
        public void reset() {
            intIterator.reset();
        }

        @Override
        public T[] current() {
            return map(initialArray, intIterator.current(), factory);
        }

        @Override
        public boolean hasNext() {
            return intIterator.hasNext();
        }

        @Override
        public T[] next() {
            return map(initialArray, intIterator.next(), factory);
        }
    }

    private static int[] indices(int length) {
        int[] r = new int[length];
        for (int i = 0; i < length; i++)
            r[i] = i;
        return r;
    }

    /**
     * Iterator over all N-tuples of elements at different positions, which can be chosen from {@code N} specified sets
     * of elements.
     *
     * @param sets array of sets of integers
     * @see IntDistinctTuples
     */
    public static <T> CombinatorialIterator<T[]> distinctTuples(T[]... sets) {
        return new TTIterator<>(sets, new GenericFactory<>(sets[0]), distinctTuples(Arrays.stream(sets).map(t -> indices(t.length)).toArray(int[][]::new)));
    }

    /**
     * Iterator over all N-tuples, which can be chosen from {@code N} specified sets of integers.
     *
     * @param sets array of sets of integers
     * @see IntDistinctTuples
     */
    public static <T> CombinatorialIterator<T[]> tuples(T[]... sets) {
        return new TTIterator<>(sets, new GenericFactory<>(sets[0]), tuples(Arrays.stream(sets).mapToInt(t -> t.length).toArray()));
    }
}
