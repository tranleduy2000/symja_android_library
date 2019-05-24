package com.duy.ref;

@SuppressWarnings("unused")
public class ObjectRef<T> {

    private T value;

    public ObjectRef() {

    }

    public ObjectRef(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }
}
