package it.unimi.dsi.fastutil.objects;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Object2IntOpenHashMap<K> extends HashMap<K, Integer> {
    protected int defRetValue;

    public Set<Object2IntMap.Entry<K>> object2IntEntrySet() {
        Set<Entry<K, Integer>> entries = entrySet();
        Set<Object2IntMap.Entry<K>> copy = new HashSet<>();
        for (Entry<K, Integer> entry : entries) {
            copy.add(new Object2IntMap.Entry<K>(entry.getKey(), entry.getValue()));
        }
        return copy;
    }

    public void defaultReturnValue(final int rv) {
        defRetValue = rv;
    }

    public int defaultReturnValue() {
        return defRetValue;
    }

    public int getInt(K key) {
        Integer val = get(key);
        if (val != null) {
            return val;
        }
        return defRetValue;
    }
}
