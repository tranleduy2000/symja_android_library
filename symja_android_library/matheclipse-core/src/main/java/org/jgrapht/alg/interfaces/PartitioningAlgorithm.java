/*
 * (C) Copyright 2018-2018, by Alexandru Valeanu and Contributors.
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
package org.jgrapht.alg.interfaces;

import com.duy.lambda.Function;
import com.duy.util.DObjects;
import com.duy.util.MapWrapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Algorithm to compute a vertex partitioning of a graph.
 *
 * @param <V> vertex the graph vertex type
 * @author Alexandru Valeanu
 */
public interface PartitioningAlgorithm<V> {

    /**
     * Computes a vertex partitioning.
     *
     * @return a vertex partitioning
     */
    Partitioning<V> getPartitioning();

    /**
     * Check if the given vertex partitioning is valid.
     *
     * @param partitioning the input vertex partitioning
     * @return true if the input partitioning is valid, false otherwise
     */
    boolean isValidPartitioning(Partitioning<V> partitioning);

    /**
     * A <a href="https://en.wikipedia.org/wiki/Graph_partition">graph partitioning</a>.
     *
     * @param <V> the vertex type
     */
    interface Partitioning<V>
            extends
            Iterable<Set<V>> {

        /**
         * Get the number of partitions.
         *
         * @return the number of partitions
         */
        int getNumberPartitions();

        /**
         * Get the index-th partition (0-based).
         *
         * @param index index of the partition to return
         * @return the index-th partition
         * @throws IndexOutOfBoundsException if the index is out of range
         *                                   (<tt>index &lt; 0 || index &gt;= getNumberPartitions()</tt>)
         */
        Set<V> getPartition(int index);

//        /**
//         * Get the partitions. This method returns a partitioning of the vertices in the graph into
//         * disjoint partitions.
//         *
//         * @return a list of partitions
//         */
//        default List<Set<V>> getPartitions()
//        {
//            final int n = getNumberPartitions();
//            List<Set<V>> partitions = new ArrayList<>(n);
//
//            for (int i = 0; i < n; i++) {
//                partitions.add(getPartition(i));
//            }
//
//            return partitions;
//        }
    }

    /**
     * Default implementation of a vertex partition
     *
     * @param <V> the vertex type
     */
    class PartitioningImpl<V>
            implements
            Partitioning<V>,
            Serializable {

        private static final long serialVersionUID = 3702471090706836080L;

        /* Partitioning classes */
        private final List<Set<V>> classes;

        /**
         * Construct a new vertex partitioning.
         *
         * @param classes the partition classes
         * @throws NullPointerException if {@code classes} is {@code null}
         */
        public PartitioningImpl(List<Set<V>> classes) {
            List<Set<V>> list = new ArrayList<>();
            for (Set<V> vs : DObjects.requireNonNull(classes)) {
                Set<V> unmodifiableSet = Collections.unmodifiableSet(vs);
                list.add(unmodifiableSet);
            }
            this.classes = Collections.unmodifiableList(
                    list);
        }

        /**
         * Construct a new vertex partitioning.
         *
         * @param vertexToPartitionMap the vertex to partition index map
         * @throws NullPointerException if {@code vertexToPartitionMap} is {@code null}
         */
        public PartitioningImpl(Map<V, Integer> vertexToPartitionMap) {
            DObjects.requireNonNull(vertexToPartitionMap);

            Map<Integer, Set<V>> partitionIndexToVertexMap = new HashMap<>();

            for (Map.Entry<V, Integer> entry : vertexToPartitionMap.entrySet()) {
                new MapWrapper<>(partitionIndexToVertexMap)
                        .computeIfAbsent(entry.getValue(), new Function<Integer, Set<V>>() {
                            @Override
                            public Set<V> apply(Integer x) {
                                return new HashSet<>();
                            }
                        }).add(entry.getKey());
            }

            List<Set<V>> list = new ArrayList<>();
            for (Set<V> vs : partitionIndexToVertexMap
                    .values()) {
                Set<V> unmodifiableSet = Collections.unmodifiableSet(vs);
                list.add(unmodifiableSet);
            }
            this.classes = Collections.unmodifiableList(
                    list);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int getNumberPartitions() {
            return classes.size();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Set<V> getPartition(int index) {
            if (index < 0 || index >= classes.size()) {
                throw new IndexOutOfBoundsException(index + " is not valid");
            }

            return classes.get(index);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "Partition [number-of-partitions=" + getNumberPartitions() + ", partitions="
                    + classes + "]";
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Iterator<Set<V>> iterator() {
            return classes.iterator();
        }
    }
}
