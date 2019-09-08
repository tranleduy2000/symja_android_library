package org.jgrapht.alg.interfaces;

import org.jgrapht.alg.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class LowestCommonAncestorAlgorithmImpl<V> implements LowestCommonAncestorAlgorithm<V> {
    @Override
    public List<V> getBatchLCA(List<Pair<V, V>> queries) {
        List<V> list = new ArrayList<>();
        for (Pair<V, V> p : queries) {
            V lca = getLCA(p.getFirst(), p.getSecond());
            list.add(lca);
        }
        return list;
    }

    @Override
    public List<Set<V>> getBatchLCASet(List<Pair<V, V>> queries) {
        List<Set<V>> list = new ArrayList<>();
        for (Pair<V, V> p : queries) {
            Set<V> lcaSet = getLCASet(p.getFirst(), p.getSecond());
            list.add(lcaSet);
        }
        return list;
    }
}
