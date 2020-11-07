package it.unimi.dsi.fastutil.ints;

import java.util.ArrayList;

public class IntArrayList extends ArrayList<Integer> {
    public IntArrayList() {
        super();
    }
    public IntArrayList(int capacity) {
        super(capacity);
    }

    public int getInt(int index) {
        return get(index);
    }

    public void removeInt(int index) {
        remove(index);
    }
}
