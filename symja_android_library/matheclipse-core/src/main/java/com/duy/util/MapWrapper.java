package com.duy.util;

import com.duy.lambda.BiConsumer;
import com.duy.lambda.BiFunction;
import com.duy.lambda.Function;

import java.util.Map;
import java.util.Set;

public class MapWrapper<K, V> {

    private Map<K, V> map;

    public MapWrapper(Map<K, V> map) {
        this.map = map;
    }

    public static <K, V> V merge(Map<K, V> map, K key, V value,
                                 BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        V oldValue = map.get(key);
        V newValue = (oldValue == null) ? value :
                remappingFunction.apply(oldValue, value);
        if (newValue == null) {
            map.remove(key);
        } else {
            map.put(key, newValue);
        }
        return newValue;
    }

    public static <K, V> V replace(Map<K, V> map,
                                   K key, V value) {
        V curValue;
        if (((curValue = map.get(key)) != null) || map.containsKey(key)) {
            curValue = map.put(key, value);
        }
        return curValue;
    }

    public void forEach(BiConsumer<K, V> action) {
        DObjects.requireNonNull(action);
        for (Map.Entry<K, V> entry : entrySet()) {
            K k;
            V v;
            try {
                k = entry.getKey();
                v = entry.getValue();
            } catch (IllegalStateException ise) {
                // this usually means the entry is no longer in the map.
                throw new ConcurrentModificationException(ise);
            }
            action.accept(k, v);
        }
    }

    private Set<Map.Entry<K, V>> entrySet() {
        return map.entrySet();
    }

    public V computeIfAbsent(K key,
                             Function<? super K, ? extends V> mappingFunction) {
        DObjects.requireNonNull(mappingFunction);
        V v;
        if ((v = get(key)) == null) {
            V newValue;
            if ((newValue = mappingFunction.apply(key)) != null) {
                put(key, newValue);
                return newValue;
            }
        }

        return v;
    }

    public V computeIfPresent(K key,
                              BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        DObjects.requireNonNull(remappingFunction);
        V oldValue;
        if ((oldValue = get(key)) != null) {
            V newValue = remappingFunction.apply(key, oldValue);
            if (newValue != null) {
                put(key, newValue);
                return newValue;
            } else {
                remove(key);
                return null;
            }
        } else {
            return null;
        }
    }

    public V put(K key, V newValue) {
        return map.put(key, newValue);
    }

    public V get(K key) {
        return map.get(key);
    }

    public void remove(K key) {
        map.remove(key);
    }

    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    public V getOrDefault(K key, V defaultValue) {
        V v;
        return (((v = get(key)) != null) || containsKey(key))
                ? v
                : defaultValue;
    }

    public V putIfAbsent(K key, V value) {
        V v = get(key);
        if (v == null) {
            v = put(key, value);
        }

        return v;
    }
}
