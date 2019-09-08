package org.jgrapht.generate;

import org.jgrapht.Graph;

public abstract class GraphGeneratorImpl<V, E, T> implements GraphGenerator<V, E, T> {
    @Override
    public void generateGraph(Graph<V, E> target) {
        generateGraph(target, null);
    }
}
