package org.jgrapht.alg.interfaces;

import org.jgrapht.Graph;

public abstract class AStarAdmissibleHeuristicImpl<V> implements AStarAdmissibleHeuristic<V> {
    @Override
    public <E> boolean isConsistent(Graph<V, E> graph) {
        if (graph == null) {
            throw new IllegalArgumentException("Graph cannot be null!");
        }
        for (V targetVertex : graph.vertexSet()) {
            for (E e : graph.edgeSet()) {
                double weight = graph.getEdgeWeight(e);
                V edgeSource = graph.getEdgeSource(e);
                V edgeTarget = graph.getEdgeTarget(e);
                double h_x = getCostEstimate(edgeSource, targetVertex);
                double h_y = getCostEstimate(edgeTarget, targetVertex);
                if (h_x > weight + h_y)
                    return false;
            }
        }
        return true;
    }
}
