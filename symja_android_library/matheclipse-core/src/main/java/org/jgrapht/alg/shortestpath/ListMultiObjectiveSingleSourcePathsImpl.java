/*
 * (C) Copyright 2017-2018, by Dimitrios Michail and Contributors.
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
package org.jgrapht.alg.shortestpath;

import com.duy.util.DObjects;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.interfaces.MultiObjectiveShortestPathAlgorithm.MultiObjectiveSingleSourcePaths;
import org.jgrapht.graph.GraphWalk;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * An implementation of {@link MultiObjectiveSingleSourcePaths} which stores one list of paths per
 * vertex.
 *
 * @param <V> the graph vertex type
 * @param <E> the graph edge type
 * @author Dimitrios Michail
 */
public class ListMultiObjectiveSingleSourcePathsImpl<V, E>
        implements
        MultiObjectiveSingleSourcePaths<V, E>,
        Serializable {
    private static final long serialVersionUID = -6213225353391554721L;

    /**
     * The graph
     */
    protected Graph<V, E> graph;

    /**
     * The source vertex of all paths
     */
    protected V source;

    /**
     * One path per vertex
     */
    protected Map<V, List<GraphPath<V, E>>> paths;

    /**
     * Construct a new instance.
     *
     * @param graph  the graph
     * @param source the source vertex
     * @param paths  a list of paths per target vertex
     */
    public ListMultiObjectiveSingleSourcePathsImpl(
            Graph<V, E> graph, V source, Map<V, List<GraphPath<V, E>>> paths) {
        this.graph = DObjects.requireNonNull(graph, "Graph is null");
        this.source = DObjects.requireNonNull(source, "Source vertex is null");
        this.paths = DObjects.requireNonNull(paths, "Paths are null");
    }

    @Override
    public Graph<V, E> getGraph() {
        return graph;
    }

    @Override
    public V getSourceVertex() {
        return source;
    }

    @Override
    public List<GraphPath<V, E>> getPaths(V targetVertex) {
        List<GraphPath<V, E>> p = paths.get(targetVertex);
        if (p == null) {
            if (source.equals(targetVertex)) {
                GraphWalk<V, E> o = GraphWalk.singletonWalk(graph, source, 0d);
                return Collections.<GraphPath<V, E>>singletonList(o);
            } else {
                return Collections.emptyList();
            }
        } else {
            return p;
        }
    }

}
