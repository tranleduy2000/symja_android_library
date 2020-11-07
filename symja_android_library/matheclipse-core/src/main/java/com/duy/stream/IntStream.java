package com.duy.stream;

import java.util.ArrayList;
import java.util.Collection;

public class IntStream extends StreamWrapper<Integer> {

    public IntStream(Collection<Integer> list) {
        super(list);
    }


    public int[] toArray() {
        ArrayList<Integer> intList = new ArrayList<>(list);
        int[] array = new int[intList.size()];
        for (int i = 0; i < intList.size(); i++) {
            array[i] = intList.get(i);
        }
        return array;
    }
}
