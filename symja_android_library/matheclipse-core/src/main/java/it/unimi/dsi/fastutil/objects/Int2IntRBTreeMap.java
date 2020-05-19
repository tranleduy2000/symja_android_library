package it.unimi.dsi.fastutil.objects;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Int2IntRBTreeMap implements Int2IntMap {
    private TreeMap<Integer, Integer> internalMap = new TreeMap<>();
    private int defValue = 0;

    @Override
    public int get(int key) {
        Integer value = internalMap.get(key);
        if (value != null) {
            return value;
        }
        return defValue;
    }

    @Override
    public Integer put(int k, int v) {
        return internalMap.put(k, v);
    }

    @Override
    public int size() {
        return internalMap.size();
    }

    @Override
    public Iterable<Entry> int2IntEntrySet() {
        Set<Map.Entry<Integer, Integer>> entries = internalMap.entrySet();
        ArrayList<Entry> copy = new ArrayList<>();
        copy.ensureCapacity(entries.size());
        for (Map.Entry<Integer, Integer> entry : entries) {
            copy.add(new TreeMapEntry(internalMap, entry.getKey(), entry.getValue()));
        }
        return copy;
    }

    static class TreeMapEntry implements Entry {
        int key;
        int value;
        private TreeMap<Integer, Integer> internalMap;

        public TreeMapEntry(TreeMap<Integer, Integer> internalMap, int key, int value) {
            this.internalMap = internalMap;
            this.key = key;
            this.value = value;
        }

        @Override
        public int getIntKey() {
            return key;
        }

        @Override
        public int getIntValue() {
            return value;
        }

        @Override
        public void setValue(int newValue) {
            internalMap.put(key, newValue);
        }
    }

}
