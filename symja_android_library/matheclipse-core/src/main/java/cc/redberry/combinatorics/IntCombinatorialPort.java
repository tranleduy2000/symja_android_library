package cc.redberry.combinatorics;

import java.io.Serializable;

/**
 * This interface is common for all combinatorial iterators.
 *
 * @author Dmitry Bolotin
 * @author Stanislav Poslavsky
 * @since 1.0
 */
public interface IntCombinatorialPort extends Serializable {
    /**
     * Resets the iteration
     */
    void reset();

    /**
     * Returns the reference to the current iteration element
     *
     * @return the reference to the current iteration element
     */
    int[] getReference();

    /**
     * Calculates and returns the next combination or null, if no more combinations exist.
     *
     * @return the next combination or null, if no more combinations exist
     */
    int[] take();

    final class Iterator extends IntCombinatorialIterator {
        final IntCombinatorialPort port;
        private int[] next;

        public Iterator(IntCombinatorialPort port) {
            this.port = port;
            this.next = port.take();
        }

        @Override
        public void reset() {
            port.reset();
        }

        @Override
        public int[] current() {
            return port.getReference();
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public int[] next() {
            int[] current = next.clone();
            next = port.take();
            return current;
        }
    }
}
