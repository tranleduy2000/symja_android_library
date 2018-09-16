package com.duy.stream;

import java.util.ArrayList;
import java.util.List;

public class FakeStream<E> extends ArrayList<E> {
    private List<E> list;

    public FakeStream(List<E> list) {
        this.list = list;
    }

    public static <E> FakeStream<E> valueOf(List<E> list) {
        return new FakeStream<>(list);
    }
}
