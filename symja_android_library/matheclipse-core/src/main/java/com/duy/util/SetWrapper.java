package com.duy.util;

import java.util.Set;

public class SetWrapper<V> extends CollectionWrapper<V> {
    private Set<V> set;

    public SetWrapper(Set<V> set) {
        super(set);
        this.set = set;
    }



}
