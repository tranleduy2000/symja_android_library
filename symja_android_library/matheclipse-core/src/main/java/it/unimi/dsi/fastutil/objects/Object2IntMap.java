package it.unimi.dsi.fastutil.objects;

import java.util.Map;

public class Object2IntMap {
    public static class Entry<K> {
        private final Map<K, Integer> map;
        private K key;
        private int value;


        public Entry(Map<K, Integer> map, K key, Integer value) {
            this.map = map;
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public int getIntValue() {
            return value;
        }

        public void setValue(int newValue) {
            map.put(key, newValue);
        }
    }
}
