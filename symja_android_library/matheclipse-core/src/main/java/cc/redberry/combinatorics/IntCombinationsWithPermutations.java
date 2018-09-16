package cc.redberry.combinatorics;

/**
 * Iterator over over all possible unique combinations with permutations (i.e. {0,1} and {1,0} both will appear in the
 * iteration) of {@code k} numbers, which can be chosen from the set of {@code n} numbers (0,1,2,...,{@code n}). The
 * total number of such combinations will be {@code n!/(n-k)!}.
 *
 * <p> For example, for {@code k=2} and {@code n=3}, it will produce the following arrays sequence: [0,1], [1,0], [0,2],
 * [2,0], [1,2], [2,1].
 *
 * <p> The iterator is implemented such that each next combination will be calculated only on the invocation of method
 * {@link #next()} (no pre-calculation of results).
 *
 * <p> <b>Note:</b> method {@link #next()} returns the same reference on each invocation.
 *
 * <p> Internally this class uses combination of {@link IntCombinations} and {@link IntPermutations}.
 *
 * @author Dmitry Bolotin
 * @author Stanislav Poslavsky
 * @see IntCombinations
 * @see IntPermutations
 * @since 1.0
 */
public final class IntCombinationsWithPermutations
        extends IntCombinatorialIterator {
    private static final long serialVersionUID = 8846104681881108285L;
    private final int[] permutation, combination;
    private final int[] combinationPermutation;
    private final IntPermutations permutationsGenerator;
    private final IntCombinations combinationsGenerator;
    private final int k;

    /**
     * Constructs the iterator with the desired n and k
     */
    public IntCombinationsWithPermutations(int n, int k) {
        this.k = k;
        this.combinationsGenerator = new IntCombinations(n, k);
        this.combination = this.combinationsGenerator.combination;
        this.permutationsGenerator = new IntPermutations(k);
        this.permutation = this.permutationsGenerator.permutation;
        this.combinationPermutation = new int[k];
        combinationsGenerator.next();
        System.arraycopy(combination, 0, combinationPermutation, 0, k);
    }

    @Override
    public boolean hasNext() {
        return combinationsGenerator.hasNext() || permutationsGenerator.hasNext();
    }

    /**
     * Calculates and returns the next combination.
     *
     * @return the next combination
     */
    @Override
    public int[] next() {
        if (!permutationsGenerator.hasNext()) {
            permutationsGenerator.reset();
            combinationsGenerator.next();
        }
        permutationsGenerator.next();
        for (int i = 0; i < k; ++i)
            combinationPermutation[i] = combination[permutation[i]];
        return combinationPermutation;
    }

    /**
     * Throws UnsupportedOperationException.
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public void reset() {
        permutationsGenerator.reset();
        combinationsGenerator.reset();
        combinationsGenerator.next();
    }

    @Override
    public int[] current() {
        return combinationPermutation;
    }
}
