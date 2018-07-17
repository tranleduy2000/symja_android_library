/*
 * Copyright (C) 2016 The Guava Authors
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

package com.google.common.graph;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import java.util.AbstractSet;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * A class to represent the set of edges connecting an (implicit) origin node to a target node.
 * <p>
 * <p>The {@link #nodeToOutEdge} map means this class only works on networks without parallel edges.
 * See {@link MultiEdgesConnecting} for a class that works with parallel edges.
 *
 * @param <E> Edge parameter type
 * @author James Sexton
 */
final class EdgesConnecting<E> extends AbstractSet<E> {

    private final Map<?, E> nodeToOutEdge;
    private final Object targetNode;

    EdgesConnecting(Map<?, E> nodeToEdgeMap, Object targetNode) {
        this.nodeToOutEdge = checkNotNull(nodeToEdgeMap);
        this.targetNode = checkNotNull(targetNode);
    }

    @Override
    public UnmodifiableIterator<E> iterator() {
        E connectingEdge = getConnectingEdge();
        return (connectingEdge == null)
                ? ImmutableSet.<E>of().iterator()
                : Iterators.singletonIterator(connectingEdge);
    }

    @Override
    public int size() {
        return getConnectingEdge() == null ? 0 : 1;
    }

    @Override
    public boolean contains(@NullableDecl Object edge) {
        E connectingEdge = getConnectingEdge();
        return (connectingEdge != null && connectingEdge.equals(edge));
    }

    @NullableDecl
    private E getConnectingEdge() {
        return nodeToOutEdge.get(targetNode);
    }
}
