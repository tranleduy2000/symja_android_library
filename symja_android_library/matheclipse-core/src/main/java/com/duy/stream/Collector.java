/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package com.duy.stream;

import com.duy.lambda.BiConsumer;
import com.duy.lambda.BinaryOperator;
import com.duy.lambda.Function;
import com.duy.lambda.Supplier;

import java.util.Set;

public interface Collector<T, A, R> {
    /**
     * A function that creates and returns a new mutable result container.
     *
     * @return a function which returns a new, mutable result container
     */
    Supplier<A> supplier();

    /**
     * A function that folds a value into a mutable result container.
     *
     * @return a function which folds a value into a mutable result container
     */
    BiConsumer<A, T> accumulator();

    /**
     * A function that accepts two partial results and merges them.  The
     * combiner function may fold state from one argument into the other and
     * return that, or may return a new result container.
     *
     * @return a function which combines two partial results into a combined
     * result
     */
    BinaryOperator<A> combiner();

    /**
     * Perform the final transformation from the intermediate accumulation type
     * {@code A} to the final result type {@code R}.
     * <p>
     * <p>If the characteristic {@code IDENTITY_TRANSFORM} is
     * set, this function may be presumed to be an identity transform with an
     * unchecked cast from {@code A} to {@code R}.
     *
     * @return a function which transforms the intermediate result to the final
     * result
     */
    Function<A, R> finisher();

    /**
     * Returns a {@code Set} of {@code Collector.Characteristics} indicating
     * the characteristics of this Collector.  This set should be immutable.
     *
     * @return an immutable set of collector characteristics
     */
    Set<Characteristics> characteristics();

//    /**
//     * Returns a new {@code Collector} described by the given {@code supplier},
//     * {@code accumulator}, and {@code combiner} functions.  The resulting
//     * {@code Collector} has the {@code Collector.Characteristics.IDENTITY_FINISH}
//     * characteristic.
//     *
//     * @param supplier The supplier function for the new collector
//     * @param accumulator The accumulator function for the new collector
//     * @param combiner The combiner function for the new collector
//     * @param characteristics The collector characteristics for the new
//     *                        collector
//     * @param <T> The type of input elements for the new collector
//     * @param <R> The type of intermediate accumulation result, and final result,
//     *           for the new collector
//     * @throws NullPointerException if any argument is null
//     * @return the new {@code Collector}
//     */
//    public static<T, R> Collector<T, R, R> of(Supplier<R> supplier,
//                                              BiConsumer<R, T> accumulator,
//                                              BinaryOperator<R> combiner,
//                                              Characteristics... characteristics) {
//        Objects.requireNonNull(supplier);
//        Objects.requireNonNull(accumulator);
//        Objects.requireNonNull(combiner);
//        Objects.requireNonNull(characteristics);
//        Set<Characteristics> cs = (characteristics.length == 0)
//                                  ? Collectors.CH_ID
//                                  : Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.IDENTITY_FINISH,
//                                                                           characteristics));
//        return new Collectors.CollectorImpl<>(supplier, accumulator, combiner, cs);
//    }

//    /**
//     * Returns a new {@code Collector} described by the given {@code supplier},
//     * {@code accumulator}, {@code combiner}, and {@code finisher} functions.
//     *
//     * @param supplier The supplier function for the new collector
//     * @param accumulator The accumulator function for the new collector
//     * @param combiner The combiner function for the new collector
//     * @param finisher The finisher function for the new collector
//     * @param characteristics The collector characteristics for the new
//     *                        collector
//     * @param <T> The type of input elements for the new collector
//     * @param <A> The intermediate accumulation type of the new collector
//     * @param <R> The final result type of the new collector
//     * @throws NullPointerException if any argument is null
//     * @return the new {@code Collector}
//     */
//    public static<T, A, R> Collector<T, A, R> of(Supplier<A> supplier,
//                                                 BiConsumer<A, T> accumulator,
//                                                 BinaryOperator<A> combiner,
//                                                 Function<A, R> finisher,
//                                                 Characteristics... characteristics) {
//        Objects.requireNonNull(supplier);
//        Objects.requireNonNull(accumulator);
//        Objects.requireNonNull(combiner);
//        Objects.requireNonNull(finisher);
//        Objects.requireNonNull(characteristics);
//        Set<Characteristics> cs = Collectors.CH_NOID;
//        if (characteristics.length > 0) {
//            cs = EnumSet.noneOf(Characteristics.class);
//            Collections.addAll(cs, characteristics);
//            cs = Collections.unmodifiableSet(cs);
//        }
//        return new Collectors.CollectorImpl<>(supplier, accumulator, combiner, finisher, cs);
//    }

    /**
     * Characteristics indicating properties of a {@code Collector}, which can
     * be used to optimize reduction implementations.
     */
    enum Characteristics {
        /**
         * Indicates that this collector is <em>concurrent</em>, meaning that
         * the result container can support the accumulator function being
         * called concurrently with the same result container from multiple
         * threads.
         * <p>
         * <p>If a {@code CONCURRENT} collector is not also {@code UNORDERED},
         * then it should only be evaluated concurrently if applied to an
         * unordered data source.
         */
        CONCURRENT,

        /**
         * Indicates that the collection operation does not commit to preserving
         * the encounter order of input elements.  (This might be true if the
         * result container has no intrinsic order, such as a {@link Set}.)
         */
        UNORDERED,

        /**
         * Indicates that the finisher function is the identity function and
         * can be elided.  If set, it must be the case that an unchecked cast
         * from A to R will succeed.
         */
        IDENTITY_FINISH
    }
}
