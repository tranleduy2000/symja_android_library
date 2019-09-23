package org.matheclipse.core.builtin;

import com.duy.lambda.BiFunction;
import com.duy.lambda.Consumer;
import com.duy.lambda.Predicate;
import com.duy.util.SetWrapper;

import org.gavaghan.geodesy.Ellipsoid;
import org.gavaghan.geodesy.GeodeticCalculator;
import org.gavaghan.geodesy.GeodeticMeasurement;
import org.gavaghan.geodesy.GlobalPosition;
import org.hipparchus.util.MathArrays;
import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.GraphType;
import org.jgrapht.Graphs;
import org.jgrapht.alg.cycle.HierholzerEulerianCycle;
import org.jgrapht.alg.interfaces.EulerianCycleAlgorithm;
import org.jgrapht.alg.interfaces.HamiltonianCycleAlgorithm;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm.SingleSourcePaths;
import org.jgrapht.alg.interfaces.SpanningTreeAlgorithm;
import org.jgrapht.alg.interfaces.VertexCoverAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.alg.shortestpath.GraphMeasurer;
import org.jgrapht.alg.spanning.BoruvkaMinimumSpanningTree;
import org.jgrapht.alg.tour.HeldKarpTSP;
import org.jgrapht.alg.vertexcover.GreedyVCImpl;
import org.jgrapht.graph.AbstractBaseGraph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultUndirectedGraph;
import org.jgrapht.graph.DefaultUndirectedWeightedGraph;
import org.matheclipse.core.basic.Config;
import org.matheclipse.core.convert.Object2Expr;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.interfaces.AbstractEvaluator;
import org.matheclipse.core.eval.util.OptionArgs;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.expression.IExprEdge;
import org.matheclipse.core.expression.IExprWeightedEdge;
import org.matheclipse.core.expression.data.GeoPositionExpr;
import org.matheclipse.core.expression.data.GraphExpr;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IASTAppendable;
import org.matheclipse.core.interfaces.IDataExpr;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.IInteger;
import org.matheclipse.core.interfaces.INum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Functions for graph theory algorithms.
 *
 */
public class GraphFunctions {
	/**
	 * 
	 * See <a href="https://pangin.pro/posts/computation-in-static-initializer">Beware of computation in static
	 * initializer</a>
	 */
	private static class Initializer {

		private static void init() {
			F.Graph.setEvaluator(new GraphCTor());
			F.GraphCenter.setEvaluator(new GraphCenter());
			F.GraphDiameter.setEvaluator(new GraphDiameter());
			F.GraphPeriphery.setEvaluator(new GraphPeriphery());
			F.GraphRadius.setEvaluator(new GraphRadius());
			F.AdjacencyMatrix.setEvaluator(new AdjacencyMatrix());
			F.EdgeList.setEvaluator(new EdgeList());
			F.EdgeQ.setEvaluator(new EdgeQ());
			F.EulerianGraphQ.setEvaluator(new EulerianGraphQ());
			F.FindEulerianCycle.setEvaluator(new FindEulerianCycle());
			F.FindHamiltonianCycle.setEvaluator(new FindHamiltonianCycle());
			F.FindVertexCover.setEvaluator(new FindVertexCover());
			F.FindShortestPath.setEvaluator(new FindShortestPath());
			F.FindShortestTour.setEvaluator(new FindShortestTour());
			F.FindSpanningTree.setEvaluator(new FindSpanningTree());
			F.GraphQ.setEvaluator(new GraphQ());
			F.HamiltonianGraphQ.setEvaluator(new HamiltonianGraphQ());
			F.VertexEccentricity.setEvaluator(new VertexEccentricity());
			F.VertexList.setEvaluator(new VertexList());
			F.VertexQ.setEvaluator(new VertexQ());
		}
	}

	/**
	 * <code>Graph</code> constructor.
	 *
	 */
	private static class GraphCTor extends AbstractEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			try {
				if (ast.isAST1()) {
					GraphExpr<IExprEdge> gex = createGraph(ast.arg1());
					if (gex != null) {
						return gex;
					}
				} else if (ast.size() >= 3 && ast.arg1().isList()) {
					IExpr edgeWeight = F.NIL;
					final OptionArgs options = new OptionArgs(F.Graph, ast, 2, engine);
					IExpr option = options.getOption(F.EdgeWeight);
					if (option.isPresent() && !option.equals(F.Automatic)) {
						edgeWeight = option;
					}
					GraphType t = ast.arg1().isListOfEdges();
					if (t != null) {
						if (edgeWeight.isList()) {
							GraphExpr<IExprWeightedEdge> gex = createWeightedGraph(F.NIL, (IAST) ast.arg1(),
									(IAST) edgeWeight);
							if (gex != null) {
								return gex;
							}
						} else {
							GraphExpr g = createGraph(F.NIL, (IAST) ast.arg1());
							if (g != null) {
								return g;
							}
						}
					} else {
						if (edgeWeight.isList()) {
							GraphExpr<IExprWeightedEdge> gex = createWeightedGraph((IAST) ast.arg1(), (IAST) ast.arg2(),
									(IAST) edgeWeight);
							if (gex != null) {
								return gex;
							}
						} else {
							if (ast.arg2().isList()) {
								GraphExpr g = createGraph((IAST) ast.arg1(), (IAST) ast.arg2());
								if (g != null) {
									return g;
								}
							}
						}
					}
				}
			} catch (RuntimeException rex) {
				if (Config.SHOW_STACKTRACE) {
					rex.printStackTrace();
				}
			}
			return F.NIL;
		}

		@Override
		public IAST options() {
			return F.List(F.Rule(F.EdgeWeight, F.Automatic));
		}

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_INFINITY;
		}
	}

	private static class GraphCenter extends AbstractEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			try {
				GraphExpr<IExprEdge> gex = createGraph(ast.arg1());
				if (gex == null) {
					return F.NIL;
				}
				Graph<IExpr, IExprEdge> g = gex.toData();

				GraphMeasurer<IExpr, IExprEdge> graphMeasurer = new GraphMeasurer<>(g);
				Set<IExpr> centerSet = graphMeasurer.getGraphCenter();
				IASTAppendable list = F.ListAlloc(centerSet.size());
				list.appendAll(centerSet);
				return list;
			} catch (RuntimeException rex) {
				if (Config.SHOW_STACKTRACE) {
					rex.printStackTrace();
				}
			}
			return F.NIL;
		}

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_1;
		}
	}

	private static class GraphDiameter extends AbstractEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			try {
				GraphExpr<IExprEdge> dex = createGraph(ast.arg1());
				if (dex == null) {
					return F.NIL;
				}
				Graph<IExpr, IExprEdge> g = dex.toData();
				GraphMeasurer<IExpr, IExprEdge> graphMeasurer = new GraphMeasurer<>(g);
				INum diameter = F.num(graphMeasurer.getDiameter());
				if (dex.isWeightedGraph()) {
					return diameter;
				}
				int intDiameter = diameter.toIntDefault();
				if (intDiameter != Integer.MIN_VALUE) {
					return F.ZZ(intDiameter);
				}
				return diameter;
			} catch (RuntimeException rex) {
				if (Config.SHOW_STACKTRACE) {
					rex.printStackTrace();
				}
			}
			return F.NIL;
		}

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_1;
		}
	}

	private static class GraphPeriphery extends AbstractEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			try {
				GraphExpr<IExprEdge> gex = createGraph(ast.arg1());
				if (gex == null) {
					return F.NIL;
				}
				Graph<IExpr, IExprEdge> g = gex.toData();
				// boolean pseudoDiameter = false;
				// if (ast.isAST2()) {
				// final OptionArgs options = new OptionArgs(ast.topHead(), ast, 2, engine);
				// IExpr option = options.getOption(F.Method);
				//
				// if (option.isPresent() && option.toString().equals("PseudoDiameter")) {
				// pseudoDiameter = true;
				// } else if (!option.isPresent()) {
				// return engine.printMessage("GraphPeriphery: Option PseudoDiameter expected!");
				// }
				// }

				GraphMeasurer<IExpr, IExprEdge> graphMeasurer = new GraphMeasurer<>(g);
				Set<IExpr> centerSet = graphMeasurer.getGraphPeriphery();
				IASTAppendable list = F.ListAlloc(centerSet.size());
				list.appendAll(centerSet);
				return list;
			} catch (RuntimeException rex) {
				if (Config.SHOW_STACKTRACE) {
					rex.printStackTrace();
				}
			}
			return F.NIL;
		}

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_1;
		}
	}
	private static class GraphQ extends AbstractEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			try {
				if (ast.isAST1()) {
					GraphExpr<IExprEdge> gex = createGraph(ast.arg1());
					if (gex != null) {
						return F.True;
					}
				}
			} catch (RuntimeException rex) {
				if (Config.SHOW_STACKTRACE) {
					rex.printStackTrace();
				}
			}
			return F.False;
		}

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_1;
		}
	}

	private static class GraphRadius extends AbstractEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			try {
				GraphExpr<IExprEdge> gex = createGraph(ast.arg1());
				if (gex == null) {
					return F.NIL;
				}
				Graph<IExpr, IExprEdge> g = gex.toData();

				GraphMeasurer<IExpr, IExprEdge> graphMeasurer = new GraphMeasurer<>(g);
				INum radius = F.num(graphMeasurer.getRadius());
				if (gex.isWeightedGraph()) {
					return radius;
				}
				int intRadius = radius.toIntDefault();
				if (intRadius != Integer.MIN_VALUE) {
					return F.ZZ(intRadius);
				}
				return radius;
			} catch (RuntimeException rex) {
				if (Config.SHOW_STACKTRACE) {
					rex.printStackTrace();
				}
			}
			return F.NIL;
		}

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_1;
		}
	}
	private static class FindShortestTour extends AbstractEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			try {
				if (ast.isAST1()) {
					if (ast.arg1().isListOfLists()) {
						int[] dim = ast.arg1().isMatrix();
						if (dim != null) {
							IAST m = (IAST) ast.arg1();
							double[][] matrix = m.toDoubleMatrix();
							int rowDim = dim[0];
							int colDim = dim[1];
							if (colDim == 2) {
								Graph<IInteger, IExprWeightedEdge> g = new DefaultUndirectedWeightedGraph<>(
										IExprWeightedEdge.class);
								// define the vertices as integer numbers 1..rowDim
								for (int i = 1; i <= rowDim; i++) {
									g.addVertex(F.ZZ(i));
								}
								// create all possible edges between the given vertices
								for (int i = 0; i < rowDim; i++) {
									for (int j = i + 1; j < rowDim; j++) {
										g.setEdgeWeight(g.addEdge(F.ZZ(i + 1), F.ZZ(j + 1)), // EuclideanDistance
												MathArrays.distance(matrix[i], matrix[j]));
									}
								}
								GraphPath<IInteger, IExprWeightedEdge> tour = new HeldKarpTSP<IInteger, IExprWeightedEdge>()
										.getTour(g);

								// calculate the shortest tour from the sum of distances and
								// create list of vertices for the shortest tour
								List<IInteger> tourPositions = tour.getVertexList();
								IASTAppendable shortestTourList = F.ListAlloc(tourPositions.size());
								IASTAppendable sum = F.PlusAlloc(tourPositions.size());
								IInteger lastPosition = tourPositions.get(tourPositions.size() - 1);
								shortestTourList.append(lastPosition);
								for (int i = tourPositions.size() - 2; i >= 0; i--) {
									IInteger position = tourPositions.get(i);
									shortestTourList.append(position);
									sum.append(F.EuclideanDistance(m.get(lastPosition), m.get(position)));
									lastPosition = position;
								}
								return F.List(sum, shortestTourList);
							}
							}
					} else if (ast.arg1().isList()) {
						IAST list = (IAST) ast.arg1();
						if (list.size() > 2 && list.forAll(new Predicate<IExpr>() {
							@Override
							public boolean test(IExpr x) {
								return (x instanceof GeoPositionExpr);
							}
						})) {
							int rowDim = list.size() - 1;
							Graph<IInteger, IExprWeightedEdge> g = new DefaultUndirectedWeightedGraph<>(
									IExprWeightedEdge.class);
							// define the vertices as integer numbers 1..rowDim
							for (int i = 1; i <= rowDim; i++) {
								g.addVertex(F.ZZ(i));
							}

							GeodeticCalculator geoCalc = new GeodeticCalculator();
							Ellipsoid reference = Ellipsoid.WGS84;
							// create all possible edges between the given vertices
							for (int i = 0; i < rowDim - 1; i++) {
								GlobalPosition p1 = ((GeoPositionExpr) list.get(i + 1)).toData();
								for (int j = i + 1; j < rowDim; j++) {
									GlobalPosition p2 = ((GeoPositionExpr) list.get(j + 1)).toData();
									GeodeticMeasurement gm = geoCalc.calculateGeodeticMeasurement(reference, p1, p2);
									g.setEdgeWeight(g.addEdge(F.ZZ(i + 1), F.ZZ(j + 1)), // GeoDistance
											gm.getPointToPointDistance());
								}

							}
							GraphPath<IInteger, IExprWeightedEdge> tour = new HeldKarpTSP<IInteger, IExprWeightedEdge>()
									.getTour(g);

							// calculate the shortest tour from the sum of distances and
							// create list of vertices for the shortest tour
							List<IInteger> tourPositions = tour.getVertexList();
							IASTAppendable shortestTourList = F.ListAlloc(tourPositions.size());
							IASTAppendable sum = F.PlusAlloc(tourPositions.size());
							IInteger lastPosition = tourPositions.get(tourPositions.size() - 1);
							shortestTourList.append(lastPosition);
							for (int i = tourPositions.size() - 2; i >= 0; i--) {
								IInteger position = tourPositions.get(i);
								shortestTourList.append(position);
								sum.append(F.GeoDistance(list.get(lastPosition), list.get(position)));
								lastPosition = position;
							}
							return F.List(sum, shortestTourList);
						}
					}
				}
			} catch (RuntimeException rex) {
				// if (Config.SHOW_STACKTRACE) {
					rex.printStackTrace();
				// }
			}
			return F.NIL;
		}

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_3;
		}
	}

	private static class FindSpanningTree extends AbstractEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			try {
				if (ast.isAST1()) {
					GraphExpr<IExprEdge> gex = createGraph(ast.arg1());
					if (gex == null) {
						return F.NIL;
					}
					Graph<IExpr, IExprEdge> g = gex.toData();
					SpanningTreeAlgorithm<IExprEdge> k = new BoruvkaMinimumSpanningTree<IExpr, IExprEdge>(g);
					Set<IExprEdge> edgeSet = k.getSpanningTree().getEdges();
					Graph<IExpr, IExprEdge> gResult = new DefaultDirectedGraph<IExpr, IExprEdge>(IExprEdge.class);
					Graphs.addAllEdges(gResult, g, edgeSet);
					return GraphExpr.newInstance(gResult);
				}
			} catch (RuntimeException rex) {
				if (Config.SHOW_STACKTRACE) {
					rex.printStackTrace();
				}
			}
			return F.NIL;
		}

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_1;
		}
	}

	private static class AdjacencyMatrix extends AbstractEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			try {
				if (ast.isAST1()) {
					GraphExpr<IExprEdge> gex = createGraph(ast.arg1());
					if (gex == null) {
						return F.NIL;
					}

					Graph<IExpr, IExprEdge> g = gex.toData();
					return graphToAdjacencyMatrix(g);
				}
			} catch (RuntimeException rex) {
				if (Config.SHOW_STACKTRACE) {
					rex.printStackTrace();
				}
			}
			return F.NIL;
		}

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_1;
		}
	}

	private static class EdgeList extends AbstractEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			try {
				if (ast.isAST1()) {
					GraphExpr<IExprEdge> gex = createGraph(ast.arg1());
					if (gex == null) {
						return F.NIL;
					}
					Graph<IExpr, IExprEdge> g = gex.toData();
					return edgesToIExpr(g)[0];
				}
			} catch (RuntimeException rex) {
				if (Config.SHOW_STACKTRACE) {
					rex.printStackTrace();
				}
			}
			return F.NIL;
		}

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_1;
		}
	}

	private static class EdgeQ extends AbstractEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			try {

				if (ast.isAST2() && ast.arg2().isEdge()) {
					IAST edge = (IAST) ast.arg2();
					GraphExpr<IExprEdge> gex = createGraph(ast.arg1());
					if (gex != null) {
						Graph<IExpr, IExprEdge> g = gex.toData();
						return F.bool(g.containsEdge(edge.first(), edge.second()));
					}
				}
			} catch (RuntimeException rex) {
				if (Config.SHOW_STACKTRACE) {
					rex.printStackTrace();
				}
			}
			return F.False;
		}

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_2_2;
		}
	}

	private static class EulerianGraphQ extends AbstractEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			try {
				if (ast.isAST1()) {
					GraphExpr<IExprEdge> gex = createGraph(ast.arg1());
					if (gex == null) {
						return F.NIL;
					}

					Graph<IExpr, IExprEdge> g = gex.toData();
					GraphPath<IExpr, IExprEdge> path = eulerianCycle(g);
					if (path != null) {
						// Graph is Eulerian
						return F.True;
					}
				}
			} catch (RuntimeException rex) {
				if (Config.SHOW_STACKTRACE) {
					rex.printStackTrace();
				}
			}
			return F.False;
		}

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_1;
		}
	}

	private static class HamiltonianGraphQ extends AbstractEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			try {
				if (ast.isAST1()) {
					GraphExpr<IExprEdge> gex = createGraph(ast.arg1());
					if (gex == null) {
						return F.NIL;
					}

					Graph<IExpr, IExprEdge> g = gex.toData();
					GraphPath<IExpr, IExprEdge> path = hamiltonianCycle(g);
					if (path != null) {
						// Graph is Hamiltonian
						return F.True;
					}
				}
			} catch (RuntimeException rex) {
				if (Config.SHOW_STACKTRACE) {
					rex.printStackTrace();
				}
			}
			return F.False;
		}

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_1;
		}
	}

	private static class FindEulerianCycle extends AbstractEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			try {
				if (ast.isAST1()) {
					GraphExpr<IExprEdge> gex = createGraph(ast.arg1());
					if (gex == null) {
						return F.NIL;
					}

					Graph<IExpr, IExprEdge> g = gex.toData();
					GraphPath<IExpr, IExprEdge> path = eulerianCycle(g);
					if (path == null) {
						// Graph is not Eulerian
						return F.CEmptyList;
					}
					List<IExpr> iList = path.getVertexList();
					IASTAppendable list = F.ListAlloc(iList.size());
					for (int i = 0; i < iList.size() - 1; i++) {
						list.append(F.DirectedEdge(iList.get(i), iList.get(i + 1)));
					}
					return list;
				}
			} catch (RuntimeException rex) {
				if (Config.SHOW_STACKTRACE) {
					rex.printStackTrace();
				}
			}
			return F.NIL;
		}

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_1;
		}
	}

	private static class FindHamiltonianCycle extends AbstractEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			try {
				if (ast.isAST1()) {
					GraphExpr<IExprEdge> gex = createGraph(ast.arg1());
					if (gex == null) {
						return F.NIL;
					}

					Graph<IExpr, IExprEdge> g = gex.toData();
					GraphPath<IExpr, IExprEdge> path = hamiltonianCycle(g);
					if (path == null) {
						// Graph is not Hamiltonian
						return F.CEmptyList;
					}
					List<IExpr> iList = path.getVertexList();
					IASTAppendable list = F.ListAlloc(iList.size());
					for (int i = 0; i < iList.size() - 1; i++) {
						list.append(F.DirectedEdge(iList.get(i), iList.get(i + 1)));
					}
					return list;
				}
			} catch (RuntimeException rex) {
				if (Config.SHOW_STACKTRACE) {
					rex.printStackTrace();
				}
			}
			return F.NIL;
		}
		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_1;
		}
	}

	private static class FindVertexCover extends AbstractEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			try {
				if (ast.isAST1()) {
					GraphExpr<IExprEdge> gex = createGraph(ast.arg1());
					if (gex == null) {
						return F.NIL;
					}
					Graph<IExpr, IExprEdge> g = gex.toData();
					// ChordalityInspector<IExpr, IExprEdge> inspector = new ChordalityInspector<IExpr, IExprEdge>(g);
					VertexCoverAlgorithm<IExpr> greedy = new GreedyVCImpl<>(g);
					VertexCoverAlgorithm.VertexCover<IExpr> cover = greedy.getVertexCover();
					if (cover == null) {
						return F.List();
					}
					final IASTAppendable result = F.ListAlloc(10);
					new SetWrapper<>(cover).forEach(new Consumer<IExpr>() {
						@Override
						public void accept(IExpr x) {
							result.append(x);
						}
					});
					return result;
				}
			} catch (IllegalArgumentException iae) {
				return engine.printMessage("Graph must be undirected");
			} catch (RuntimeException rex) {
				if (Config.SHOW_STACKTRACE) {
					rex.printStackTrace();
				}
			}
			return F.NIL;
		}

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_1;
		}
	}

	private static class FindShortestPath extends AbstractEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			try {
				GraphExpr<IExprEdge> gex = createGraph(ast.arg1());
				if (gex == null) {
					return F.NIL;
				}

				Graph<IExpr, IExprEdge> g = gex.toData();

				DijkstraShortestPath<IExpr, IExprEdge> dijkstraAlg = new DijkstraShortestPath<>(g);
				SingleSourcePaths<IExpr, IExprEdge> iPaths = dijkstraAlg.getPaths(ast.arg2());
				GraphPath<IExpr, IExprEdge> path = iPaths.getPath(ast.arg3());

				return Object2Expr.convertList(path.getVertexList());
			} catch (RuntimeException rex) {
				if (Config.SHOW_STACKTRACE) {
					rex.printStackTrace();
				}
			}
			return F.NIL;
		}

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_3_3;
		}
	}

	private static class VertexEccentricity extends AbstractEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			try {
				GraphExpr<IExprEdge> gex = createGraph(ast.arg1());
				if (gex == null) {
					return F.NIL;
				}
				Graph<IExpr, IExprEdge> g = gex.toData();

				GraphMeasurer<IExpr, IExprEdge> graphMeasurer = new GraphMeasurer<>(g);
				Map<IExpr, Double> centerSet = graphMeasurer.getVertexEccentricityMap();
				Double dValue = centerSet.get(ast.arg2());
				if (dValue != null) {
					INum vertexEccentricity = F.num(dValue);
					if (gex.isWeightedGraph()) {
						return vertexEccentricity;
					}
					int intVertexEccentricity = vertexEccentricity.toIntDefault();
					if (intVertexEccentricity != Integer.MIN_VALUE) {
						return F.ZZ(intVertexEccentricity);
					}
					return vertexEccentricity;
				}

			} catch (RuntimeException rex) {
				if (Config.SHOW_STACKTRACE) {
					rex.printStackTrace();
				}
			}
			return F.NIL;
		}

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_2_2;
		}
	}
	private static class VertexList extends AbstractEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			try {
				if (ast.isAST1()) {
					GraphExpr<IExprEdge> gex = createGraph(ast.arg1());
					if (gex == null) {
						return F.NIL;
					}
					Graph<IExpr, IExprEdge> g = gex.toData();
					return vertexToIExpr(g);
					// Set<IExpr> vertexSet = g.vertexSet();
					// int size = vertexSet.size();
					// IASTAppendable result = F.ListAlloc(size);
					// for (IExpr expr : vertexSet) {
					// result.append(expr);
					// }
					// return result;
				}
			} catch (RuntimeException rex) {
				if (Config.SHOW_STACKTRACE) {
					rex.printStackTrace();
				}
			}
			return F.NIL;
		}

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_1;
		}
	}

	private static class VertexQ extends AbstractEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			try {
				if (ast.isAST2()) {
					GraphExpr<IExprEdge> gex = createGraph(ast.arg1());
					if (gex != null) {
						Graph<IExpr, IExprEdge> g = gex.toData();
						return F.bool(g.containsVertex(ast.arg2()));
					}
				}
			} catch (RuntimeException rex) {
				if (Config.SHOW_STACKTRACE) {
					rex.printStackTrace();
				}
			}
			return F.False;
		}

		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_2_2;
		}
	}

	/**
	 * Create an internal DataExpr Graph.
	 *
	 * @param arg1
	 * @return
	 */
	private static GraphExpr<IExprEdge> createGraph(final IExpr arg1) {
		if (arg1.head().equals(F.Graph) && arg1 instanceof GraphExpr) {
			return (GraphExpr<IExprEdge>) arg1;
		}
		Graph<IExpr, IExprEdge> g;
		GraphType t = arg1.isListOfEdges();
		if (t != null) {
			if (t.isDirected()) {
				g = new DefaultDirectedGraph<IExpr, IExprEdge>(IExprEdge.class);
			} else {
				g = new DefaultUndirectedGraph<IExpr, IExprEdge>(IExprEdge.class);
			}

			IAST list = (IAST) arg1;
			for (int i = 1; i < list.size(); i++) {
				IAST edge = list.getAST(i);
				g.addVertex(edge.arg1());
				g.addVertex(edge.arg2());
				g.addEdge(edge.arg1(), edge.arg2());
			}

			return GraphExpr.newInstance(g);
		}

		return null;
	}

	/**
	 * Create an internal DataExpr Graph.
	 *
	 * @param arg1
	 * @return
	 */
	private static GraphExpr<IExprWeightedEdge> createWeightedGraph(final IAST vertices, final IAST arg1,
			final IAST edgeWeight) {
		if (arg1.size() != edgeWeight.size()) {
			return null;
		}
		Graph<IExpr, IExprWeightedEdge> g;
		GraphType t = arg1.isListOfEdges();
		if (t != null) {

			if (t.isDirected()) {
				g = new DefaultDirectedWeightedGraph<IExpr, IExprWeightedEdge>(IExprWeightedEdge.class);
			} else {
				g = new DefaultUndirectedWeightedGraph<IExpr, IExprWeightedEdge>(IExprWeightedEdge.class);
			}

			IAST list = (IAST) arg1;
			for (int i = 1; i < list.size(); i++) {
				IAST edge = list.getAST(i);
				g.addVertex(edge.arg1());
				g.addVertex(edge.arg2());
				g.addEdge(edge.arg1(), edge.arg2());
			}

			if (t.isDirected()) {
				DefaultDirectedWeightedGraph gw = (DefaultDirectedWeightedGraph<IExpr, IExprWeightedEdge>) g;
				for (int i = 1; i < list.size(); i++) {
					IAST edge = list.getAST(i);
					gw.setEdgeWeight(gw.getEdge(edge.arg1(), edge.arg2()), edgeWeight.get(i).evalDouble());
				}
			} else {
				DefaultUndirectedWeightedGraph gw = (DefaultUndirectedWeightedGraph<IExpr, IExprWeightedEdge>) g;
				for (int i = 1; i < list.size(); i++) {
					IAST edge = list.getAST(i);
					gw.setEdgeWeight(gw.getEdge(edge.arg1(), edge.arg2()), edgeWeight.get(i).evalDouble());
				}
			}

			return GraphExpr.newInstance(g);
		}

		return null;
	}

	private static GraphExpr createGraph(final IAST vertices, final IAST edges) {

		Graph<IExpr, IExprEdge> g;
		GraphType t = edges.isListOfEdges();
		if (t != null) {
			if (t.isDirected()) {
				g = new DefaultDirectedGraph<IExpr, IExprEdge>(IExprEdge.class);
			} else {
				g = new DefaultUndirectedGraph<IExpr, IExprEdge>(IExprEdge.class);
			}
			if (vertices.isList()) {
				// Graph<IExpr, IExprEdge> g = new DefaultDirectedGraph<IExpr, IExprEdge>(IExprEdge.class);
				for (int i = 1; i < vertices.size(); i++) {
					g.addVertex(vertices.get(i));
				}
			}

			for (int i = 1; i < edges.size(); i++) {
				IAST edge = edges.getAST(i);
				g.addVertex(edge.arg1());
				g.addVertex(edge.arg2());
				g.addEdge(edge.arg1(), edge.arg2());
			}

			return GraphExpr.newInstance(g);
		}

		return null;
	}

	/**
	 * Create an eulerian cycle.
	 *
	 * @param g
	 * @return <code>null</code> if no eulerian cycle can be created
	 */
	private static GraphPath<IExpr, IExprEdge> eulerianCycle(Graph<IExpr, IExprEdge> g) {
		EulerianCycleAlgorithm<IExpr, IExprEdge> eca = new HierholzerEulerianCycle<>();
		try {
			return eca.getEulerianCycle(g);
		} catch (IllegalArgumentException iae) {
			// Graph is not Eulerian
		}
		return null;
	}

	private static GraphPath<IExpr, IExprEdge> hamiltonianCycle(Graph<IExpr, IExprEdge> g) {
		HamiltonianCycleAlgorithm<IExpr, IExprEdge> eca = new HeldKarpTSP<>();
		try {
			return eca.getTour(g);
		} catch (IllegalArgumentException iae) {
			// Graph is not Hamiltonian
		}
		return null;
	}

	public static void initialize() {
		Initializer.init();
	}

	private GraphFunctions() {

	}

	/**
	 * Convert a graph into an IExpr object.
	 *
	 * @param g
	 * @return
	 */
	public static IExpr graphToIExpr(AbstractBaseGraph<IExpr, IExprEdge> g) {
		IASTAppendable vertexes = vertexToIExpr(g);
		IASTAppendable[] edgeData = edgesToIExpr(g);
		if (edgeData[1] == null) {
			return F.Graph(vertexes, edgeData[0]);
		}
		return F.Graph(vertexes, edgeData[0], F.List(F.Rule(F.EdgeWeight, edgeData[1])));
	}

	public static IExpr weightedGraphToIExpr(AbstractBaseGraph<IExpr, IExprWeightedEdge> g) {
		IASTAppendable vertexes = vertexToIExpr(g);
		IASTAppendable[] res = weightedEdgesToIExpr(g);
		IExpr graph = F.Graph(vertexes, res[0], F.List(F.Rule(F.EdgeWeight, res[1])));
		return graph;
	}

	private static IASTAppendable vertexToIExpr(Graph<IExpr, ?> g) {
		Set<IExpr> vertexSet = g.vertexSet();
		IASTAppendable vertexes = F.ListAlloc(vertexSet.size());
		for (IExpr expr : vertexSet) {
			vertexes.append(expr);
		}
		return vertexes;
	}

	private static IASTAppendable[] edgesToIExpr(Graph<IExpr, ?> g) {
		Set<Object> edgeSet = (Set<Object>) g.edgeSet();
		IASTAppendable edges = F.ListAlloc(edgeSet.size());
		IASTAppendable weights = F.ListAlloc(edgeSet.size());
		boolean hasWeights = false;
		GraphType type = g.getType();
		for (Object edge : edgeSet) {
			if (edge instanceof IExprWeightedEdge) {
				hasWeights = true;
				IExprWeightedEdge weightedEdge = (IExprWeightedEdge) edge;
		if (type.isDirected()) {
					edges.append(F.DirectedEdge(weightedEdge.lhs(), weightedEdge.rhs()));
				} else {
					edges.append(F.UndirectedEdge(weightedEdge.lhs(), weightedEdge.rhs()));
				}
				weights.append(F.num(weightedEdge.weight()));
			} else if (edge instanceof IExprEdge) {
				IExprEdge exprEdge = (IExprEdge) edge;
				if (type.isDirected()) {
					edges.append(F.DirectedEdge(exprEdge.lhs(), exprEdge.rhs()));
		} else {
					edges.append(F.UndirectedEdge(exprEdge.lhs(), exprEdge.rhs()));
				}
			}
		}
		if (hasWeights) {
			return new IASTAppendable[] { edges, weights };
		}
		return new IASTAppendable[] { edges, null };
		// return edges;
		// GraphType type = g.getType();
		// if (type.isDirected()) {
		// if (type.isWeighted()) {
		// Set<IExprWeightedEdge> edgeSet = (Set<IExprWeightedEdge>) g.edgeSet();
		// IASTAppendable edges = F.ListAlloc(edgeSet.size());
		// for (IExprWeightedEdge edge : edgeSet) {
		// edges.append(F.DirectedEdge(edge.lhs(), edge.rhs()));
		// }
		// return edges;
		// } else {
		// Set<IExprEdge> edgeSet = (Set<IExprEdge>) g.edgeSet();
		// IASTAppendable edges = F.ListAlloc(edgeSet.size());
		// for (IExprEdge edge : edgeSet) {
		// edges.append(F.DirectedEdge(edge.lhs(), edge.rhs()));
		// }
		// return edges;
		// }
		// } else {
		// if (type.isWeighted()) {
		// Set<IExprWeightedEdge> edgeSet = (Set<IExprWeightedEdge>) g.edgeSet();
		// IASTAppendable edges = F.ListAlloc(edgeSet.size());
		// for (IExprWeightedEdge edge : edgeSet) {
		// edges.append(F.UndirectedEdge(edge.lhs(), edge.rhs()));
		// }
		// return edges;
		// } else {
		// Set<IExprEdge> edgeSet = (Set<IExprEdge>) g.edgeSet();
		// IASTAppendable edges = F.ListAlloc(edgeSet.size());
		// for (IExprEdge edge : edgeSet) {
		// edges.append(F.UndirectedEdge(edge.lhs(), edge.rhs()));
		// }
		// return edges;
		// }
		// }
	}

	/**
	 * Return an array of 2 lists. At index 0 the list of edges. At index 1 the list of corresponding weights.
	 *
	 * @param graph
	 *
	 * @return an array of 2 lists. At index 0 the list of edges. At index 1 the list of corresponding weights.
	 */
	private static IASTAppendable[] weightedEdgesToIExpr(Graph<IExpr, IExprWeightedEdge> graph) {

		Set<IExprWeightedEdge> edgeSet = (Set<IExprWeightedEdge>) graph.edgeSet();
		IASTAppendable edges = F.ListAlloc(edgeSet.size());
		IASTAppendable weights = F.ListAlloc(edgeSet.size());
		GraphType type = graph.getType();
		if (type.isDirected()) {
			for (IExprWeightedEdge edge : edgeSet) {
				edges.append(F.DirectedEdge(edge.lhs(), edge.rhs()));
				weights.append(F.num(edge.weight()));
			}
		} else {
			for (IExprWeightedEdge edge : edgeSet) {
				edges.append(F.UndirectedEdge(edge.lhs(), edge.rhs()));
				weights.append(F.num(edge.weight()));
			}
		}
		return new IASTAppendable[] { edges, weights };

	}

	public static IAST graphToAdjacencyMatrix(final Graph<IExpr, IExprEdge> g) {
		Set<IExpr> vertexSet = g.vertexSet();
		int size = vertexSet.size();
		final IExpr[] array = new IExpr[size];
		int indx = 0;
		for (IExpr expr : vertexSet) {
			array[indx++] = expr;
		}
		return F.matrix(new BiFunction<Integer, Integer, IExpr>() {
            @Override
            public IExpr apply(Integer i, Integer j) {
                return g.containsEdge(array[i], array[j]) ? F.C1 : F.C0;
            }
        }, size, size);
	}

	/**
	 * Convert a Graph into a JavaScript visjs.org form
	 *
	 * @param graphExpr
	 * @return
	 */
	public static String graphToJSForm(IDataExpr graphExpr) {

		GraphExpr<IExprEdge> gex = (GraphExpr<IExprEdge>) graphExpr;
		AbstractBaseGraph<IExpr, ?> g = (AbstractBaseGraph<IExpr, ?>) gex.toData();
		Map<IExpr, Integer> map = new HashMap<IExpr, Integer>();
		StringBuilder buf = new StringBuilder();
		if (g.getType().isWeighted()) {
			weightedGraphToVisjs(map, buf, (AbstractBaseGraph<IExpr, IExprWeightedEdge>) g);
		} else {
			graphToVisjs(map, buf, (AbstractBaseGraph<IExpr, IExprEdge>) g);
		}
		return buf.toString();
	}

	public static void graphToVisjs(Map<IExpr, Integer> map, StringBuilder buf, AbstractBaseGraph<IExpr, IExprEdge> g) {
		vertexToVisjs(map, buf, g);
		edgesToVisjs(map, buf, g);
	}

	public static void weightedGraphToVisjs(Map<IExpr, Integer> map, StringBuilder buf,
			AbstractBaseGraph<IExpr, IExprWeightedEdge> g) {
		vertexToVisjs(map, buf, g);
		weightedEdgesToVisjs(map, buf, g);
	}

	private static void vertexToVisjs(Map<IExpr, Integer> map, StringBuilder buf, Graph<IExpr, ?> g) {
		Set<IExpr> vertexSet = g.vertexSet();
		IASTAppendable vertexes = F.ListAlloc(vertexSet.size());
		buf.append("var nodes = new vis.DataSet([\n");
		boolean first = true;
		int counter = 1;
		for (IExpr expr : vertexSet) {
			// {id: 1, label: 'Node 1'},
			if (first) {
				buf.append("  {id: ");
			} else {
				buf.append(", {id: ");
			}
			buf.append(counter);
			map.put(expr, counter++);
			buf.append(", label: '");
			buf.append(expr.toString());
			buf.append("'}\n");
			first = false;
		}
		buf.append("]);\n");
	}

	private static void edgesToVisjs(Map<IExpr, Integer> map, StringBuilder buf, Graph<IExpr, IExprEdge> g) {
		Set<IExprEdge> edgeSet = g.edgeSet();
		IASTAppendable edges = F.ListAlloc(edgeSet.size());
		GraphType type = g.getType();
		boolean first = true;
		if (type.isDirected()) {
			buf.append("var edges = new vis.DataSet([\n");
			for (IExprEdge edge : edgeSet) {
				// {from: 1, to: 3},
				if (first) {
					buf.append("  {from: ");
				} else {
					buf.append(", {from: ");
				}
				buf.append(map.get(edge.lhs()));
				buf.append(", to: ");
				buf.append(map.get(edge.rhs()));
				// , arrows: { to: { enabled: true, type: 'arrow'}}
				buf.append(" , arrows: { to: { enabled: true, type: 'arrow'}}");
				buf.append("}\n");
				first = false;
			}
			buf.append("]);\n");
		} else {
			//
			buf.append("var edges = new vis.DataSet([\n");
			for (IExprEdge edge : edgeSet) {
				// {from: 1, to: 3},
				if (first) {
					buf.append("  {from: ");
				} else {
					buf.append(", {from: ");
			}
				buf.append(map.get(edge.lhs()));
				buf.append(", to: ");
				buf.append(map.get(edge.rhs()));
				buf.append("}\n");
				first = false;
			}
			buf.append("]);\n");
		}
	}

	private static void weightedEdgesToVisjs(Map<IExpr, Integer> map, StringBuilder buf,
			Graph<IExpr, IExprWeightedEdge> graph) {

		Set<IExprWeightedEdge> edgeSet = (Set<IExprWeightedEdge>) graph.edgeSet();
		IASTAppendable edges = F.ListAlloc(edgeSet.size());
		IASTAppendable weights = F.ListAlloc(edgeSet.size());
		GraphType type = graph.getType();
		boolean first = true;
		if (type.isDirected()) {
			buf.append("var edges = new vis.DataSet([\n");
			for (IExprWeightedEdge edge : edgeSet) {
				// {from: 1, to: 3},
				if (first) {
					buf.append("  {from: ");
				} else {
					buf.append(", {from: ");
				}

				buf.append(map.get(edge.lhs()));
				buf.append(", to: ");
				buf.append(map.get(edge.rhs()));

				buf.append(", label: '");
				buf.append(edge.weight());
				buf.append("'");
				// , arrows: { to: { enabled: true, type: 'arrow'}}
				buf.append(" , arrows: { to: { enabled: true, type: 'arrow'}}");
				buf.append("}\n");
				first = false;
			}
			buf.append("]);\n");
		} else {
			buf.append("var edges = new vis.DataSet([\n");
			for (IExprWeightedEdge edge : edgeSet) {
				// {from: 1, to: 3},
				if (first) {
					buf.append("  {from: ");
				} else {
					buf.append(", {from: ");
				}

				buf.append(map.get(edge.lhs()));
				buf.append(", to: ");
				buf.append(map.get(edge.rhs()));
				buf.append(", label: '");
				buf.append(edge.weight());
				buf.append("'");
				buf.append("}\n");
				first = false;
			}
			buf.append("]);\n");
	}
}

}