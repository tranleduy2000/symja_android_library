package com.duy.lang;

public class DThreadLocal<T> {

    private T value;

    public DThreadLocal() {
    }

    protected T initialValue() {
        return null;
    }

    public synchronized T get() {
        if (value != null) {
            return value;
        }
        return setInitialValue();
    }


    private synchronized T setInitialValue() {
        this.value = initialValue();
        return value;
    }

    /**
     * Sets the current thread's copy of this thread-local variable
     * to the specified value.  Most subclasses will have no need to
     * override this method, relying solely on the {@link #initialValue}
     * method to set the values of thread-locals.
     *
     * @param value the value to be stored in the current thread's copy of
     *              this thread-local.
     */
    public synchronized void set(T value) {
        this.value = value;
    }

    /**
     * Removes the current thread's value for this thread-local
     * variable.  If this thread-local variable is subsequently
     * {@linkplain #get read} by the current thread, its value will be
     * reinitialized by invoking its {@link #initialValue} method,
     * unless its value is {@linkplain #set set} by the current thread
     * in the interim.  This may result in multiple invocations of the
     * {@code initialValue} method in the current thread.
     *
     * @since 1.5
     */
    public synchronized void remove() {
        this.value = null;
    }


}
