package it.unimi.dsi.fastutil.objects;

import java.util.HashMap;
import java.util.Map;

public class Object2ShortOpenHashMap<K> {
    protected short defRetValue;
    private Map<K, Short> map;

    public Object2ShortOpenHashMap() {
        this.map = new HashMap<>();
    }

    public Object2ShortOpenHashMap(int capacity) {
        this.map = new HashMap<>(capacity);
    }

    public Object2ShortOpenHashMap(Map<K, Short> collection) {
        this.map = new HashMap<>(collection);
    }

    public void defaultReturnValue(final short rv) {
        defRetValue = rv;
    }

    public short defaultReturnValue() {
        return defRetValue;
    }

    public short getShort(K key) {
        Short val;
        val = map.get(key);
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
        short value = getShort(k);
        value += incr;
        map.put(k, value);
        return value;
    }

    @Override
    public Object2ShortOpenHashMap<K> clone() {
        return new Object2ShortOpenHashMap<>(map);
    }

    public void put(K key, short value) {
        map.put(key, value);
    }

}
