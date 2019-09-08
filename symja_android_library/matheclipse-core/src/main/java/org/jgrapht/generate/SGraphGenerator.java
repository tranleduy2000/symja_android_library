package org.jgrapht.generate;

import org.jgrapht.Graph;

public class SGraphGenerator {

    /**
     * Generate a graph structure.
     *
     * @param target receives the generated edges and vertices; if this is non-empty on entry, the
     *               result will be a disconnected graph since generated elements will not be connected to
     *               existing elements
     * @throws UnsupportedOperationException if the graph does not have appropriate vertex and edge
     *                                       suppliers, in order to be able to create new vertices and edges
     */
    public static <V, E, T> void generateGraph(GraphGenerator<V, E, T> graph, Graph<V, E> target) {
        graph.generateGraph(target, null);
    }
}
