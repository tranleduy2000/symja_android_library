package cc.redberry.combinatorics;

import java.util.Arrays;
import java.util.BitSet;

/**
 * Iterator over all distinct N-tuples, which can be chosen from {@code N} sets of integers. More formally, for {@code
 * N} integer arrays: <i>array</i><sub>1</sub>, <i>array</i><sub>2</sub>,...,<i>array</i><sub>N</sub>, this class allows
 * to iterate over all possible integer arrays of the form [i<sub>1</sub>, i<sub>2</sub>,...,i<sub>N</sub>], where all
 * numbers numbers i<sub>j</sub> are different and i<sub>1</sub> is chosen from <i>array</i><sub>1</sub>, i<sub>2</sub>
 * is chosen from <i>array</i><sub>2</sub> and so on.
 *
 * <p>Consider the example:
 * <code><pre>
 * int[] a1 = {1, 2, 3};
 * int[] a2 = {2, 3};
 * IntDistinctTuples tuples = new IntDistinctTuples(a1, a2);
 * int[] tuple;
 * while ((tuple = tuples.take()) != null)
 *      System.out.println(Arrays.toString(tuple));
 * </pre></code>
 * This code will produce the following sequence:
 * <code><pre>
 * [1, 2]
 * [1, 3]
 * [2, 3]
 * [3, 2]
 * </pre></code>
 *
 * <p>This class is implemented via output port pattern and the calculation of the next tuple occurs only on the
 * invocation of {@link #take()}.
 *
 * <p><b>Note:</b> method {@link #take()} returns the same reference on each invocation.
 *
 * @author Dmitry Bolotin
 * @author Stanislav Poslavsky
 * @since 1.0
 */
public final class IntDistinctTuples implements IntCombinatorialPort {
    private static final long serialVersionUID = -7599542899697602636L;
    private final BitSet previousMask;
    private final BitSet[] setMasks;
    private final int[] combination;
    private final BitSet temp;
    private byte state = -1;

    /**
     * Create iterator over distinct tuples formed from the specified arrays (each set will be sorted in place)
     */
    public IntDistinctTuples(int[]... sets) {
        int maxIndex = 0;
        for (int[] set : sets) {
            if (set.length == 0)
                continue;
            Arrays.sort(set);
            if (maxIndex < set[set.length - 1])
                maxIndex = set[set.length - 1];
        }
        ++maxIndex;
        previousMask = new BitSet(maxIndex);
        temp = new BitSet(maxIndex);

        setMasks = new BitSet[sets.length];
        for (int i = 0; i < sets.length; ++i) {
            setMasks[i] = new BitSet(maxIndex);
            for (int j : sets[i])
                setMasks[i].set(j);
        }
        combination = new int[sets.length];
        previousMask.set(0, previousMask.size());
        init();
    }

    private void init() {
        int i = 0, nextBit;
        while (i < setMasks.length) {

            temp.clear();
            temp.or(setMasks[i]);
            temp.and(previousMask);

            nextBit = temp.nextSetBit(combination[i]);
            if (nextBit != -1) {
                combination[i] = nextBit;
                previousMask.clear(nextBit);
            } else {
                if (i == 0) {
                    state = 1;
                    return;
                }
                combination[i] = 0;
                previousMask.set(combination[--i]);
                ++combination[i];
                continue;
            }
            ++i;
        }
    }

    /**
     * Calculates and returns the next tuple, or {@code null} if no more distinct tuples exist.
     *
     * @return the next tuple, or {@code null} if no more distinct tuples exist
     */
    @Override
    public int[] take() {
        if (state == 1)
            return null;

        if (state == -1) {
            state = 0;
            return combination;
        }
        previousMask.set(combination[setMasks.length - 1]++);

        int i = setMasks.length - 1, nextBit;
        while (i < setMasks.length) {

            temp.clear();
            temp.or(setMasks[i]);
            temp.and(previousMask);

            nextBit = temp.nextSetBit(combination[i]);
            if (nextBit != -1) {
                combination[i] = nextBit;
                previousMask.clear(nextBit);
            } else {
                if (i == 0) {
                    state = 1;
                    return null;
                }
                combination[i] = 0;
                previousMask.set(combination[--i]);
                ++combination[i];
                continue;
            }
            ++i;
        }

        return combination;
    }

    @Override
    public void reset() {
        state = -1;
        Arrays.fill(combination, 0);
        previousMask.set(0, previousMask.size());
        init();
    }

    @Override
    public int[] getReference() {
        return combination;
    }
}
