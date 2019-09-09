package com.duy.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListWrapper<E> extends CollectionWrapper<E> {


    private List<E> list;

    public ListWrapper(List<E> collection) {
        super(collection);
        list = collection;
    }

    public void sort(Comparator<? super E> c) {
        Collections.sort(list, c);
    }
}
