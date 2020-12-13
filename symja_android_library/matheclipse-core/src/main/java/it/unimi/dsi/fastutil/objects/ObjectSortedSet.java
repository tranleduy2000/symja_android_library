package it.unimi.dsi.fastutil.objects;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class ObjectSortedSet<V extends Comparable<V>> implements Iterable<V> {

  private final SortedSet<V> set = new TreeSet<>();

  public int size() {
    return set.size();
  }

  @Override
  public Iterator<V> iterator() {
    return set.iterator();
  }

  public void add(V value) {
    set.add(value);
  }
}
