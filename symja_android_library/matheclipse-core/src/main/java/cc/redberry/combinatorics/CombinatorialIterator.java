package cc.redberry.combinatorics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Combinatorial iterator.
 *
 * @author Dmitry Bolotin
 * @author Stanislav Poslavsky
 * @since 1.0
 */
public interface CombinatorialIterator<T>
        extends Iterator<T>, Iterable<T>, Serializable {
    /**
     * Resets the iteration
     */
    void reset();

    /**
     * Returns the reference on the current iteration element.
     *
     * @return the reference on the current iteration element
     */
    T current();

    @Override
    default Iterator<T> iterator() {
        return this;
    }

    /**
     * Return a stream of combinations
     */
    default Stream<T> stream() { return StreamSupport.stream(this.spliterator(), false);}

    /**
     * Write all elements of this iterable to list
     */
    default List<T> toList() {
        List<T> list = new ArrayList<>();
        for (T t : this)
            list.add(t);
        return list;
    }
}
