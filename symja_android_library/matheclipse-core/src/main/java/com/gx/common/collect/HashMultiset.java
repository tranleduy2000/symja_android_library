/*
 * Copyright (C) 2007 The Guava Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gx.common.collect;

import com.gx.common.annotations.GwtCompatible;
import com.gx.common.annotations.GwtIncompatible;

/**
 * Multiset implementation that uses hashing for key and entry access.
 *
 * @author Kevin Bourrillion
 * @author Jared Levy
 * @since 2.0
 */
@GwtCompatible(serializable = true, emulated = true)
public class HashMultiset<E> extends AbstractMapBasedMultiset<E> {

    @GwtIncompatible // Not needed in emulated source.
    private static final long serialVersionUID = 0;

    HashMultiset(int distinctElements) {
        super(distinctElements);
    }

    /**
     * Creates a new, empty {@code HashMultiset} using the default initial capacity.
     */
    public static <E> HashMultiset<E> create() {
        return create(ObjectCountHashMap.DEFAULT_SIZE);
    }

    /**
     * Creates a new, empty {@code HashMultiset} with the specified expected number of distinct
     * elements.
     *
     * @param distinctElements the expected number of distinct elements
     * @throws IllegalArgumentException if {@code distinctElements} is negative
     */
    public static <E> HashMultiset<E> create(int distinctElements) {
        return new HashMultiset<E>(distinctElements);
    }

    /**
     * Creates a new {@code HashMultiset} containing the specified elements.
     * <p>
     * <p>This implementation is highly efficient when {@code elements} is itself a {@link Multiset}.
     *
     * @param elements the elements that the multiset should contain
     */
    public static <E> HashMultiset<E> create(Iterable<? extends E> elements) {
        HashMultiset<E> multiset = create(Multisets.inferDistinctElements(elements));
        Iterables.addAll(multiset, elements);
        return multiset;
    }

    @Override
    void init(int distinctElements) {
        backingMap = new ObjectCountHashMap<>(distinctElements);
    }
}
