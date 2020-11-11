package it.unimi.dsi.fastutil.objects;

import com.duy.util.DObjects;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Object2IntOpenHashMap<K> {
    protected int defRetValue;
    private Map<K, Integer> map = new HashMap<>();

    public Object2IntOpenHashMap() {
        super();
    }

    public Object2IntOpenHashMap(Map<K, Integer> collection) {
        this.map = new HashMap<>(collection);
    }

    public Set<Object2IntMap.Entry<K>> object2IntEntrySet() {
        Set<Map.Entry<K, Integer>> entries = map.entrySet();
        Set<Object2IntMap.Entry<K>> copy = new HashSet<>();
        for (Map.Entry<K, Integer> entry : entries) {
            copy.add(new Object2IntMap.Entry<>(map, entry.getKey(), entry.getValue()));
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
        Integer val = map.get(key);
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
        map.put(k, value);
        return value;
    }

    public int size() {
        return map.size();
    }

    @Override
    public Object2IntOpenHashMap<K> clone() {
        return new Object2IntOpenHashMap<>(map);
    }

    /**
     * Removes the entry for the specified key only if it is currently
     * mapped to the specified value.
     *
     * @param key   key with which the specified value is associated
     * @param value value expected to be associated with the specified key
     * @return {@code true} if the value was removed
     * @throws UnsupportedOperationException if the {@code remove} operation
     *                                       is not supported by this map
     *                                       (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException            if the key or value is of an inappropriate
     *                                       type for this map
     *                                       (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException          if the specified key or value is null,
     *                                       and this map does not permit null keys or values
     *                                       (<a href="Collection.html#optional-restrictions">optional</a>)
     * @implSpec The default implementation is equivalent to, for this {@code map}:
     *
     * <pre> {@code
     * if (map.containsKey(key) && DObjects.equals(map.get(key), value)) {
     *     map.remove(key);
     *     return true;
     * } else
     *     return false;
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
     * @since 1.8
     */
    public boolean remove(K key, Object value) {
        Object curValue = map.get(key);
        if (!DObjects.equals(curValue, value) ||
                (curValue == null && !map.containsKey(key))) {
            return false;
        }
        map.remove(key);
        return true;
    }

    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    public void put(K key, int value) {
        map.put(key, value);
    }
}
