package it.unimi.dsi.fastutil.ints;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap.Entry;
import it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;

public class Int2ObjectAVLTreeMap<V extends Comparable<V>> {

  private final Map<Integer, V> internalMap = new HashMap<>();

  public void remove(int key) {
    internalMap.remove(key);
  }

  public void put(int key, V value) {
    internalMap.put(key, value);
  }

  public V get(int key) {
    return internalMap.get(key);
  }

  public int size() {
    return internalMap.size();
  }

  public ObjectSortedSet<Int2ObjectMap.Entry<V>> int2ObjectEntrySet() {
    ObjectSortedSet<Int2ObjectMap.Entry<V>> sortedSet = new ObjectSortedSet<>();
    for (Map.Entry<Integer, V> pair : internalMap.entrySet()) {
      sortedSet.add(new Entry<V>(pair.getKey(), pair.getValue()));
    }
    return sortedSet;
  }
}
