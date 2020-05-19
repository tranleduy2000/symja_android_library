package it.unimi.dsi.fastutil.objects;

public interface Int2IntMap {

    int get(int key);

    Integer put(int k, int v);

    int size();

    Iterable<Int2IntMap.Entry> int2IntEntrySet();

    interface Entry {
        int getIntKey();

        int getIntValue();

        void setValue(int value);
    }
}
