package org.jgrapht.alg.interfaces;

public abstract class MaximumFlowAlgorithmImpl<V, E> implements MaximumFlowAlgorithm<V, E> {

    @Override
    public double getMaximumFlowValue(V source, V sink) {
        return getMaximumFlow(source, sink).getValue();
    }
}
