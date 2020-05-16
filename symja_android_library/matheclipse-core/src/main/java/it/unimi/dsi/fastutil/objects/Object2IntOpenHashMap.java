package it.unimi.dsi.fastutil.objects;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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

    /**
     * Adds an increment to value currently associated with a key.
     *
     * <P>Note that this method respects the {@linkplain #defaultReturnValue() default return value} semantics: when
     * called with a key that does not currently appears in the map, the key
     * will be associated with the default return value plus
     * the given increment.
     *
     * @param k    the key.
     * @param incr the increment.
     * @return the old value, or the {@linkplain #defaultReturnValue() default return value} if no value was present for the given key.
     */
    public int addTo(final K k, final int incr) {
        int value = getInt(k);
        value += incr;
        put(k, value);
        return value;
    }
}
