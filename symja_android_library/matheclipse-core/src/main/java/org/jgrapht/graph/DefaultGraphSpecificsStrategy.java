/*
 * (C) Copyright 2018-2018, by Dimitrios Michail and Contributors.
 *
 * JGraphT : a free Java graph-theory library
 *
 * See the CONTRIBUTORS.md file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0, or the
 * GNU Lesser General Public License v2.1 or later
 * which is available at
 * http://www.gnu.org/licenses/old-licenses/lgpl-2.1-standalone.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR LGPL-2.1-or-later
 */
package org.jgrapht.graph;

import org.jgrapht.Graph;
import org.jgrapht.GraphType;
import org.jgrapht.graph.specifics.ArrayUnenforcedSetEdgeSetFactory;
import org.jgrapht.graph.specifics.DirectedEdgeContainer;
import org.jgrapht.graph.specifics.DirectedSpecifics;
import org.jgrapht.graph.specifics.Specifics;
import org.jgrapht.graph.specifics.UndirectedEdgeContainer;
import org.jgrapht.graph.specifics.UndirectedSpecifics;

import java.util.LinkedHashMap;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * A default lookup specifics strategy implementation.
 * 
 * <p>
 * Graphs constructed using this strategy require the least amount of memory, at the expense of slow
 * edge retrievals. Methods which depend on edge retrievals, e.g. getEdge(V u, V v), containsEdge(V
 * u, V v), addEdge(V u, V v), etc may be relatively slow when the average degree of a vertex is
 * high (dense graphs). For a fast implementation, use {@link FastLookupGraphSpecificsStrategy}.
 * 
 * @author Dimitrios Michail
 *
 * @param <V> the graph vertex type
 * @param <E> the graph edge type
 */
public class DefaultGraphSpecificsStrategy<V, E>
    implements
    GraphSpecificsStrategy<V, E>
{
    private static final long serialVersionUID = 7615319421753562075L;

    @Override
    public Function<GraphType, IntrusiveEdgesSpecifics<V, E>> getIntrusiveEdgesSpecificsFactory()
    {
        return new Function<GraphType, IntrusiveEdgesSpecifics<V, E>>() {
            @Override
            public IntrusiveEdgesSpecifics<V, E> apply(GraphType type) {
                if (type.isWeighted()) {
                    return new WeightedIntrusiveEdgesSpecifics<V, E>(new LinkedHashMap<E, IntrusiveWeightedEdge>());
                } else {
                    return new UniformIntrusiveEdgesSpecifics<>(new LinkedHashMap<E, IntrusiveEdge>());
                }
            }
        };
    }

    @Override
    public BiFunction<Graph<V, E>, GraphType, Specifics<V, E>> getSpecificsFactory()
    {
        return new BiFunction<Graph<V, E>, GraphType, Specifics<V, E>>() {
            @Override
            public Specifics<V, E> apply(Graph<V, E> graph, GraphType type) {
                if (type.isDirected()) {
                    return new DirectedSpecifics<V, E>(
                            graph, new LinkedHashMap<V, DirectedEdgeContainer<V, E>>(), DefaultGraphSpecificsStrategy.this.getEdgeSetFactory());
                } else {
                    return new UndirectedSpecifics<>(
                            graph, new LinkedHashMap<V, UndirectedEdgeContainer<V, E>>(), DefaultGraphSpecificsStrategy.this.getEdgeSetFactory());
                }
            }
        };
    }

    @Override
    public EdgeSetFactory<V, E> getEdgeSetFactory() {
        return new ArrayUnenforcedSetEdgeSetFactory<>();
    }

}
