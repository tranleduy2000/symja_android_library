package com.duy.stream;

import com.duy.lambda.Consumer;
import com.duy.lambda.Function;
import com.duy.lambda.Predicate;
import com.duy.lambda.ToIntFunction;
import com.duy.lambda.ToLongFunction;
import com.duy.util.Optional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StreamWrapper<E> {

    protected final Collection<E> list;

    public StreamWrapper(Collection<E> list) {
        this.list = list;
    }

    public static StreamWrapper<Integer> stream(int[] seq) {
        List<Integer> list = new ArrayList<>(seq.length);
        for (int i : seq) {
            list.add(i);
        }
        return new StreamWrapper<>(list);
    }


    /**
     * Returns a stream consisting of the elements of this stream, truncated
     * to be no longer than {@code maxSize} in length.
     *
     * <p>This is a <a href="package-summary.html#StreamOps">short-circuiting
     * stateful intermediate operation</a>.
     *
     * @param maxSize the number of elements the stream should be limited to
     * @return the new stream
     * @throws IllegalArgumentException if {@code maxSize} is negative
     */
    public StreamWrapper<E> limit(int maxSize) {
        if (list.size() > maxSize) {
            List<E> newList = new ArrayList<>(list).subList(0, maxSize);
            return new StreamWrapper<>(newList);
        }
        return this;
    }

    public boolean anyMatch(Predicate<E> predicate) {
        for (E e : list) {
            if (predicate.test(e)) {
                return true;
            }
        }
        return false;
    }

    public StreamWrapper<E> stream() {
        return this;
    }

    public StreamWrapper<E> filter(Predicate<E> predicate) {
        List<E> result = new ArrayList<>();
        for (E e : this.list) {
            if (predicate.test(e)) {
                result.add(e);
            }
        }
        return new StreamWrapper<>(result);
    }

    public <Res> StreamWrapper<Res> map(Function<E, Res> mapper) {
        List<Res> result = new ArrayList<>(this.list.size());
        for (E e : list) {
            result.add(mapper.apply(e));
        }
        return new StreamWrapper<>(result);
    }

    public LongStream mapToLong(ToLongFunction<E> mapper) {
        List<Long> result = new ArrayList<>(this.list.size());
        for (E e : list) {
            result.add(mapper.applyAsLong(e));
        }
        return new LongStream(result);
    }

    public IntStream mapToInt(ToIntFunction<E> mapper) {
        List<Integer> result = new ArrayList<>(this.list.size());
        for (E e : list) {
            result.add(mapper.applyAsInt(e));
        }
        return new IntStream(result);
    }

    public List<E> toList() {
        return new ArrayList<>(list);
    }

    public List<E> collect(Collectors.Collector<E> collector) {
        return new ArrayList<>(list);
    }

    public Optional<E> min(Comparator<E> comparator) {
        if (list.isEmpty()) {
            return Optional.ofNullable(null);
        }
        E min = null;
        for (E e : list) {
            if (min == null) {
                min = e;
            } else if (comparator.compare(min, e) > 0) {
                min = e;
            }
        }
        return Optional.of(min);
    }

    public Optional<E> max(Comparator<E> comparator) {
        if (list.isEmpty()) {
            return Optional.ofNullable(null);
        }
        E max = null;
        for (E e : list) {
            if (max == null) {
                max = e;
            } else if (comparator.compare(max, e) < 0) {
                max = e;
            }
        }
        return Optional.of(max);
    }

    public void forEach(Consumer<E> consumer) {
        for (E e : list) {
            consumer.accept(e);
        }
    }

    public StreamWrapper<E> boxed() {
        return this;
    }

    public StreamWrapper<E> sorted(Comparator<E> comparator) {
        ArrayList<E> newList = new ArrayList<>(list);
        Collections.sort(newList, comparator);
        return new StreamWrapper<>(newList);
    }

}
