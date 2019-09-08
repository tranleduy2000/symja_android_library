/*
 * (C) Copyright 2019-2019, by Semen Chudakov and Contributors.
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
package org.jgrapht.interfaces;

import org.jgrapht.Graph;
import org.jgrapht.alg.interfaces.AStarAdmissibleHeuristic;
import org.jgrapht.alg.interfaces.AStarAdmissibleHeuristicImpl;
import org.jgrapht.alg.shortestpath.BaseHeuristicSearchTest;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedWeightedPseudograph;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * This class tests default implementation of the
 * {@link org.jgrapht.alg.interfaces.AStarAdmissibleHeuristic#isConsistent(Graph)} method.
 */
public class AStarAdmissibleHeuristicTest
    extends
    BaseHeuristicSearchTest
{

    @Test(expected = IllegalArgumentException.class)
    public void testNullValue()
    {
        AStarAdmissibleHeuristic<Integer> heuristic = new AStarAdmissibleHeuristicImpl<Integer>() {
            @Override
            public double getCostEstimate(Integer sourceVertex, Integer targetVertex) {
                return 0;
            }
        };
        heuristic.isConsistent(null);
    }

    @Test
    public void testEmptyGraph()
    {
        Graph<Integer, DefaultWeightedEdge> graph =
            new DirectedWeightedPseudograph<>(DefaultWeightedEdge.class);
        AStarAdmissibleHeuristic<Integer> heuristic = new AStarAdmissibleHeuristicImpl<Integer>() {
            @Override
            public double getCostEstimate(Integer sourceVertex, Integer targetVertex) {
                return 0;
            }
        };
        assertTrue(heuristic.isConsistent(graph));
    }

    @Test
    public void testZeroValueHeuristic()
    {
        Graph<Node, DefaultWeightedEdge> graph = getMultigraph();
        AStarAdmissibleHeuristic<Node> heuristic = new AStarAdmissibleHeuristicImpl<Node>() {
            @Override
            public double getCostEstimate(Node sourceVertex, Node targetVertex) {
                return 0;
            }
        };
        assertTrue(heuristic.isConsistent(graph));
    }

    @Test
    public void testEuclideanHeuristic()
    {
        AStarAdmissibleHeuristic<Node> heuristic = new EuclideanDistance();
        this.readLabyrinth(labyrinth1);
        assertTrue(heuristic.isConsistent(graph));
        this.readLabyrinth(labyrinth2);
        assertTrue(heuristic.isConsistent(graph));
        Graph<Node, DefaultWeightedEdge> multigraph = getMultigraph();
        assertTrue(heuristic.isConsistent(multigraph));
    }

    @Test
    public void testManhattanHeuristic()
    {
        AStarAdmissibleHeuristic<Node> heuristic = new ManhattanDistance();
        this.readLabyrinth(labyrinth1);
        assertTrue(heuristic.isConsistent(graph));
        this.readLabyrinth(labyrinth2);
        assertTrue(heuristic.isConsistent(graph));
        Graph<Node, DefaultWeightedEdge> multigraph = getMultigraph();
        assertTrue(heuristic.isConsistent(multigraph));
    }

    /**
     * Does not override {@link AStarAdmissibleHeuristic#isConsistent(Graph)} method.
     */
    public static class ManhattanDistance
        extends AStarAdmissibleHeuristicImpl<Node>
        implements
        AStarAdmissibleHeuristic<Node>
    {
        @Override
        public double getCostEstimate(Node sourceVertex, Node targetVertex)
        {
            return Math.abs(sourceVertex.x - targetVertex.x)
                + Math.abs(sourceVertex.y - targetVertex.y);
        }
    }

    /**
     * Does not override {@link AStarAdmissibleHeuristic#isConsistent(Graph)} method.
     */
    public static class EuclideanDistance
            extends AStarAdmissibleHeuristicImpl<Node>
            implements
            AStarAdmissibleHeuristic<Node> {
        @Override
        public double getCostEstimate(Node sourceVertex, Node targetVertex)
        {
            return Math.sqrt(
                Math.pow(sourceVertex.x - targetVertex.x, 2)
                    + Math.pow(sourceVertex.y - targetVertex.y, 2));
        }
    }

}
