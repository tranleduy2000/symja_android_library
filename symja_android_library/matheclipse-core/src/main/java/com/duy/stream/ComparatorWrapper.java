package com.duy.stream;

import com.duy.lambda.ToDoubleFunction;
import com.duy.lambda.ToIntFunction;
import com.duy.lambda.ToLongFunction;
import com.duy.lang.IntegerWrapper;
import com.duy.util.DObjects;

import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Duy on 10/3/2017.
 */
public abstract class ComparatorWrapper<T> implements Comparator<T> {


    /**
     * Accepts a function that extracts a {@code long} sort key from a type
     * {@code T}, and returns a {@code Comparator<T>} that compares by that
     * sort key.
     * <p>
     * <p>The returned comparator is serializable if the specified function is
     * also serializable.
     *
     * @param <T>          the type of element to be compared
     * @param keyExtractor the function used to extract the long sort key
     * @return a comparator that compares by an extracted key
     * @throws NullPointerException if the argument is null
     *                              see #comparing(Function)
     * @since 1.8
     */
    public static <T> Comparator<T> comparingLong(final ToLongFunction<? super T> keyExtractor) {
        return new Comparator<T>() {
            @Override
            public int compare(T c1, T c2) {
                return LongWrapper.compare(keyExtractor.applyAsLong(c1), keyExtractor.applyAsLong(c2));
            }
        };
    }

    /**
     * Accepts a function that extracts a {@code double} sort key from a type
     * {@code T}, and returns a {@code Comparator<T>} that compares by that
     * sort key.
     *
     * <p>The returned comparator is serializable if the specified function
     * is also serializable.
     *
     * @param <T>          the type of element to be compared
     * @param keyExtractor the function used to extract the double sort key
     * @return a comparator that compares by an extracted key
     * @throws NullPointerException if the argument is null
     * @see #comparing(com.duy.lambda.Function)
     * @since 1.8
     */
    public static <T> Comparator<T> comparingDouble(final ToDoubleFunction<? super T> keyExtractor) {
        DObjects.requireNonNull(keyExtractor);
        return new Comparator<T>() {
            @Override
            public int compare(T c1, T c2) {
                return Double.compare(keyExtractor.applyAsDouble(c1), keyExtractor.applyAsDouble(c2));
            }
        };
    }

    /**
     * Accepts a function that extracts an {@code int} sort key from a type
     * {@code T}, and returns a {@code Comparator<T>} that compares by that
     * sort key.
     *
     * <p>The returned comparator is serializable if the specified function
     * is also serializable.
     *
     * @param <T>          the type of element to be compared
     * @param keyExtractor the function used to extract the integer sort key
     * @return a comparator that compares by an extracted key
     * @throws NullPointerException if the argument is null
     * @see #comparing(com.duy.lambda.Function)
     * @since 1.8
     */
    public static <T> ComparatorWrapper<T> comparingInt(final ToIntFunction<? super T> keyExtractor) {
        DObjects.requireNonNull(keyExtractor);
        return new ComparatorWrapper<T>() {
            @Override
            public int compare(T c1, T c2) {
                return IntegerWrapper.compare(keyExtractor.applyAsInt(c1), keyExtractor.applyAsInt(c2));
            }
        };
    }

    /**
     * Accepts a function that extracts a {@code double} sort key from a type
     * {@code T}, and returns a {@code Comparator<T>} that compares by that
     * sort key.
     *
     * <p>The returned comparator is serializable if the specified function
     * is also serializable.
     *
     * @param <T>          the type of element to be compared
     * @param keyExtractor the function used to extract the double sort key
     * @return a comparator that compares by an extracted key
     * @throws NullPointerException if the argument is null
     * @see #comparing(com.duy.lambda.Function)
     * @since 1.8
     */
//    public static <T> Comparator<T> comparingDouble(final com.duy.lambda.ToDoubleFunction<? super T> keyExtractor) {
//        DObjects.requireNonNull(keyExtractor);
//        return new Comparator<T>() {
//            @Override
//            public int compare(T c1, T c2) {
//                return Double.compare(keyExtractor.applyAsDouble(c1), keyExtractor.applyAsDouble(c2));
//            }
//        };
//    }

    /**
     * Accepts a function that extracts a {@link java.lang.Comparable
     * Comparable} sort key from a type {@code T}, and returns a {@code
     * Comparator<T>} that compares by that sort key.
     *
     * <p>The returned comparator is serializable if the specified function
     * is also serializable.
     *
     * @param <T>          the type of element to be compared
     * @param <U>          the type of the {@code Comparable} sort key
     * @param keyExtractor the function used to extract the {@link
     *                     Comparable} sort key
     * @return a comparator that compares by an extracted key
     * @throws NullPointerException if the argument is null
     * @apiNote For example, to obtain a {@code Comparator} that compares {@code
     * Person} objects by their last name,
     *
     * <pre>{@code
     *     Comparator<Person> byLastName = Comparator.comparing(Person::getLastName);
     * }</pre>
     * @since 1.8
     */
    public static <T, U extends Comparable<? super U>> Comparator<T> comparing(
            final com.duy.lambda.Function<? super T, ? extends U> keyExtractor) {
        DObjects.requireNonNull(keyExtractor);
        return new Comparator<T>() {
            @Override
            public int compare(T c1, T c2) {
                return keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
            }
        };
    }

    /**
     * Returns a comparator that compares {@link Comparable} objects in natural
     * order.
     *
     * <p>The returned comparator is serializable and throws {@link
     * NullPointerException} when comparing {@code null}.
     *
     * @param <T> the {@link Comparable} type of element to be compared
     * @return a comparator that imposes the <i>natural ordering</i> on {@code
     * Comparable} objects.
     * @see Comparable
     * @since 1.8
     */
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        return (Comparator<T>) NaturalOrderComparator.INSTANCE;
    }

    /**
     * Returns a comparator that imposes the reverse of the <em>natural
     * ordering</em>.
     *
     * <p>The returned comparator is serializable and throws {@link
     * NullPointerException} when comparing {@code null}.
     *
     * @param <T> the {@link Comparable} type of element to be compared
     * @return a comparator that imposes the reverse of the <i>natural
     * ordering</i> on {@code Comparable} objects.
     * @see Comparable
     * @since 1.8
     */
    public static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
        return Collections.reverseOrder();
    }

//    @Override
    public Comparator<T> reversed() {
        return Collections.reverseOrder(this);
    }

    public ComparatorWrapper<T> thenComparingInt(ToIntFunction<? super T> keyExtractor) {
        return thenComparing(comparingInt(keyExtractor));
    }

    public ComparatorWrapper<T> thenComparing(final Comparator<? super T> other) {
        DObjects.requireNonNull(other);
        return new ComparatorWrapper<T>() {
            @Override
            public int compare(T c1, T c2) {
                int res = ComparatorWrapper.this.compare(c1, c2);
                return (res != 0) ? res : other.compare(c1, c2);
            }
        };
    }

    /**
     * Compares {@link Comparable} objects in natural order.
     *
     * @see Comparable
     */
    enum NaturalOrderComparator implements Comparator<Comparable<Object>> {
        INSTANCE;

        @Override
        public int compare(Comparable<Object> c1, Comparable<Object> c2) {
            return c1.compareTo(c2);
        }

        public Comparator<Comparable<Object>> reversed() {
            return ComparatorWrapper.reverseOrder();
        }
    }
}
