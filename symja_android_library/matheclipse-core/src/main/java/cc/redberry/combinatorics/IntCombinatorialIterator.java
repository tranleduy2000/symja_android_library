package cc.redberry.combinatorics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stanislav Poslavsky
 * @since 1.0
 */
abstract class IntCombinatorialIterator implements CombinatorialIterator<int[]> {
    @Override
    public final List<int[]> toList() {
        List<int[]> list = new ArrayList<>();
        for (int[] t : this)
            list.add(t.clone());
        return list;
    }
}
