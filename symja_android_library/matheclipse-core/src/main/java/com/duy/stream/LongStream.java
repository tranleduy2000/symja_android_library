package com.duy.stream;

import com.duy.util.Optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import edu.jas.poly.GenPolynomial;

public class LongStream extends StreamWrapper<Long> {

    public LongStream(Collection<Long> list) {
        super(list);
    }

    public static LongStream of(long[] freq) {
        List<Long> longs = new ArrayList<>(freq.length);
        for (long l : freq) {
            longs.add(l);
        }
        return new LongStream(longs);
    }

    public Optional<Long> max() {
        if (list.size() > 0) {
            long max = Long.MIN_VALUE;
            for (Long e : list) {
                if (max < e) {
                    max = e;
                }
            }
            return Optional.of(max);
        }
        return null;
    }

    public long sum() {
        long sum = 0;
        for (Long aLong : list) {
            sum += aLong;
        }
        return sum;
    }
}
