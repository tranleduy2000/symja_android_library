package com.duy.util;

import com.duy.lambda.BiFunction;

import java.util.Map;

public class DMap {
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
}
