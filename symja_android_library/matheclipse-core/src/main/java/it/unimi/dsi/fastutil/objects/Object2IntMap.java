package it.unimi.dsi.fastutil.objects;

public class Object2IntMap {
    public static class Entry<K> {
        private K key;
        private int value;

        public Entry(K key, int value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public int getIntValue() {
            return value;
        }
    }
}
