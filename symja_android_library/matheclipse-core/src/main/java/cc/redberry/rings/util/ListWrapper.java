package cc.redberry.rings.util;

import com.duy.lambda.Consumer;
import com.duy.lambda.Predicate;
import com.duy.lambda.UnaryOperator;
import com.duy.stream.FakeStream;
import com.duy.util.DList;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.stream.Stream;

/**
 * A simple list wrapper
 */
public class ListWrapper<Poly>
        extends AbstractList<Poly> {
    /**
     * Inner list
     */
    public final List<Poly> list;

    public ListWrapper(List<Poly> list) {
        this.list = list;
    }


    public boolean isEmpty() {
        return list.isEmpty();
    }


    public boolean contains(Object o) {
        return list.contains(o);
    }


    public Object[] toArray() {
        return list.toArray();
    }


    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }


    public boolean remove(Object o) {
        return list.remove(o);
    }


    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }


    public boolean addAll(Collection<? extends Poly> c) {
        return list.addAll(c);
    }


    public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }


    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    public void replaceAll(UnaryOperator<Poly> operator) {
        list.replaceAll(operator);
    }


    public void sort(Comparator<? super Poly> c) {
        list.sort(c);
    }


    public Spliterator<Poly> spliterator() {
        return list.spliterator();
    }


    public boolean removeIf(Predicate<? super Poly> filter) {
        return DList.removeIf(list, filter);
    }


    public Stream<Poly> stream() {
        return list.stream();
    }


    public Stream<Poly> parallelStream() {
//        return FakeStream.valueOf(list);
        return list.stream();
    }

    public void forEach(Consumer<? super Poly> action) {
        DList.forEach(list, action);
    }


    public boolean add(Poly poly) {
        return list.add(poly);
    }


    public Poly set(int index, Poly element) {
        return list.set(index, element);
    }


    public void add(int index, Poly element) {
        list.add(index, element);
    }


    public Poly remove(int index) {
        return list.remove(index);
    }


    public int indexOf(Object o) {
        return list.indexOf(o);
    }


    public int lastIndexOf(Object o) {
        return list.lastIndexOf(o);
    }


    public void clear() {
        list.clear();
    }


    public boolean addAll(int index, Collection<? extends Poly> c) {
        return list.addAll(index, c);
    }


    public Iterator<Poly> iterator() {
        return list.iterator();
    }


    public ListIterator<Poly> listIterator() {
        return list.listIterator();
    }


    public ListIterator<Poly> listIterator(int index) {
        return list.listIterator(index);
    }


    public List<Poly> subList(int fromIndex, int toIndex) {
        return list.subList(fromIndex, toIndex);
    }

    public boolean equals(Object o) {
        return list.equals(o);
    }

    public int hashCode() {
        return list.hashCode();
    }


    protected void removeRange(int fromIndex, int toIndex) {
        super.removeRange(fromIndex, toIndex);
    }


    public Poly get(int index) {
        return list.get(index);
    }


    public int size() {
        return list.size();
    }


    public String toString() {
        return list.toString();
    }
}