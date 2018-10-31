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

package com.gx.common.graph;

import com.gx.common.annotations.Beta;
import com.gx.common.base.Function;
import com.gx.common.collect.Maps;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import java.util.Map;
import java.util.Set;

/**
 * This class provides a skeletal implementation of {@link ValueGraph}. It is recommended to extend
 * this class rather than implement {@link ValueGraph} directly.
 * <p>
 * <p>The methods implemented in this class should not be overridden unless the subclass admits a
 * more efficient implementation.
 *
 * @param <N> Node parameter type
 * @param <V> Value parameter type
 * @author James Sexton
 * @since 20.0
 */
@Beta
public abstract class AbstractValueGraph<N, V> extends AbstractBaseGraph<N>
        implements ValueGraph<N, V> {

    private static <N, V> Map<EndpointPair<N>, V> edgeValueMap(final ValueGraph<N, V> graph) {
        Function<EndpointPair<N>, V> edgeToValueFn =
                new Function<EndpointPair<N>, V>() {
                    @Override
                    public V apply(EndpointPair<N> edge) {
                        return graph.edgeValueOrDefault(edge.nodeU(), edge.nodeV(), null);
                    }
                };
        return Maps.asMap(graph.edges(), edgeToValueFn);
    }

    @Override
    public Graph<N> asGraph() {
        return new AbstractGraph<N>() {
            @Override
            public Set<N> nodes() {
                return AbstractValueGraph.this.nodes();
            }

            @Override
            public Set<EndpointPair<N>> edges() {
                return AbstractValueGraph.this.edges();
            }

            @Override
            public boolean isDirected() {
                return AbstractValueGraph.this.isDirected();
            }

            @Override
            public boolean allowsSelfLoops() {
                return AbstractValueGraph.this.allowsSelfLoops();
            }

            @Override
            public ElementOrder<N> nodeOrder() {
                return AbstractValueGraph.this.nodeOrder();
            }

            @Override
            public Set<N> adjacentNodes(N node) {
                return AbstractValueGraph.this.adjacentNodes(node);
            }

            @Override
            public Set<N> predecessors(N node) {
                return AbstractValueGraph.this.predecessors(node);
            }

            @Override
            public Set<N> successors(N node) {
                return AbstractValueGraph.this.successors(node);
            }

            @Override
            public int degree(N node) {
                return AbstractValueGraph.this.degree(node);
            }

            @Override
            public int inDegree(N node) {
                return AbstractValueGraph.this.inDegree(node);
            }

            @Override
            public int outDegree(N node) {
                return AbstractValueGraph.this.outDegree(node);
            }
        };
    }

    @Override
    public final boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ValueGraph)) {
            return false;
        }
        ValueGraph<?, ?> other = (ValueGraph<?, ?>) obj;

        return isDirected() == other.isDirected()
                && nodes().equals(other.nodes())
                && edgeValueMap(this).equals(edgeValueMap(other));
    }

    @Override
    public final int hashCode() {
        return edgeValueMap(this).hashCode();
    }

    /**
     * Returns a string representation of this graph.
     */
    @Override
    public String toString() {
        return "isDirected: "
                + isDirected()
                + ", allowsSelfLoops: "
                + allowsSelfLoops()
                + ", nodes: "
                + nodes()
                + ", edges: "
                + edgeValueMap(this);
    }
}
