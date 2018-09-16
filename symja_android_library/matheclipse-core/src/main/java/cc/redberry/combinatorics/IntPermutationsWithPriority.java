package cc.redberry.combinatorics;

import java.util.*;

/**
 * Iterator over all possible permutations of specified that allows to adjust the "niceness" of particular permutations,
 * such they will appear earlier in the iteration if iterator was reset via {@link #reset()}.
 *
 * @author Dmitry Bolotin
 * @author Stanislav Poslavsky
 * @see IntPermutations
 * @since 1.0
 */
public final class IntPermutationsWithPriority implements IntCombinatorialPort {
    private static final long serialVersionUID = -8335112838485172963L;
    private final IntPermutations generator;
    private final List<PermutationPriorityTuple> tuples = new ArrayList<>();
    private final Set<PermutationPriorityTuple> set = new HashSet<>();
    private int[] last = null;
    private int lastTuplePointer = 0;

    public IntPermutationsWithPriority(int dimension) {
        generator = new IntPermutations(dimension);
    }

    public IntPermutationsWithPriority(int[] initialPermutation) {
        generator = new IntPermutations(initialPermutation);
    }

    @Override
    public int[] take() {
        if (lastTuplePointer == tuples.size()) {
            if (!generator.hasNext())
                return null;
            int[] next;
            do {
                if (!generator.hasNext())
                    return null;
                next = generator.next();
            } while (set.contains(new PermutationPriorityTuple(next)));
            last = next;
            return next;
        }
        return tuples.get(lastTuplePointer++).permutation;
    }

    /**
     * Increase niceness of the last returned permutation.
     */
    public void nice() {
        if (last == null) {
            int index = lastTuplePointer - 1;
            int nPriority = ++tuples.get(index).priority;
            int position = index;
            while (--position >= 0 && tuples.get(position).priority < nPriority) ;
            ++position;
            swap(position, index);
            return;
        }
        PermutationPriorityTuple tuple = new PermutationPriorityTuple(last.clone());
        set.add(tuple);
        tuples.add(tuple);
        ++lastTuplePointer;
    }

    @Override
    public void reset() {
        generator.reset();
        lastTuplePointer = 0;
        last = null;
    }

    @Override
    public int[] getReference() {
        return tuples.get(lastTuplePointer - 1).permutation;
    }

    private void swap(int i, int j) {
        PermutationPriorityTuple permutationPriorityTuple = tuples.get(i);
        tuples.set(i, tuples.get(j));
        tuples.set(j, permutationPriorityTuple);
    }

    private static class PermutationPriorityTuple {
        final int[] permutation;
        int priority;

        PermutationPriorityTuple(int[] permutation) {
            this.permutation = permutation;
            this.priority = 1;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            final PermutationPriorityTuple other = (PermutationPriorityTuple) obj;
            return Arrays.equals(this.permutation, other.permutation);
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 89 * hash + Arrays.hashCode(this.permutation);
            return hash;
        }

        @Override
        public String toString() {
            return Arrays.toString(permutation) + " : " + priority;
        }
    }
}
