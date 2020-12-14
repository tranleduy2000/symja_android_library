package com.duy;

import junit.framework.TestCase;
import org.matheclipse.core.builtin.GraphFunctions;
import org.matheclipse.core.eval.ExprEvaluator;
import org.matheclipse.core.interfaces.IDataExpr;

public class GraphFunctionsTest extends TestCase {

  public void testGraphToViJs() {
    ExprEvaluator exprEvaluator = new ExprEvaluator();
    IDataExpr dataExpr = (IDataExpr) exprEvaluator.eval(
        "FindSpanningTree(Graph({a,b,c,d,e,f},{a<->b,a<->d,b<->c,b<->d,b<->e,c<->e,c<->f,d<->e,e<->f}, {EdgeWeight->{1.0,3.0,6.0,5.0,1.0,5.0,2.0,1.0,4.0}}))");
    String s = GraphFunctions.graphToJSForm(dataExpr);
    assertEquals(s,
        "var nodes = new vis.DataSet([\n" +
            "  {id: 1, label: 'a'}\n" +
            ", {id: 2, label: 'b'}\n" +
            ", {id: 3, label: 'd'}\n" +
            ", {id: 4, label: 'e'}\n" +
            ", {id: 5, label: 'c'}\n" +
            ", {id: 6, label: 'f'}\n" +
            "]);\n" +
            "var edges = new vis.DataSet([\n" +
            "  {from: 1, to: 2 , arrows: { to: { enabled: true, type: 'arrow'}}}\n" +
            ", {from: 3, to: 4 , arrows: { to: { enabled: true, type: 'arrow'}}}\n" +
            ", {from: 5, to: 6 , arrows: { to: { enabled: true, type: 'arrow'}}}\n" +
            ", {from: 2, to: 4 , arrows: { to: { enabled: true, type: 'arrow'}}}\n" +
            ", {from: 4, to: 6 , arrows: { to: { enabled: true, type: 'arrow'}}}\n" +
            "]);\n");


  }

  public void testGraphToViJs2() {
    ExprEvaluator exprEvaluator = new ExprEvaluator();
    IDataExpr dataExpr = (IDataExpr) exprEvaluator.eval("Graph({1 -> 2, 2 -> 3, 3 -> 4, 4 -> 1})");
    String s = GraphFunctions.graphToJSForm(dataExpr);
    assertEquals(s, "var nodes = new vis.DataSet([\n" +
        "  {id: 1, label: '1'}\n" +
        ", {id: 2, label: '2'}\n" +
        ", {id: 3, label: '3'}\n" +
        ", {id: 4, label: '4'}\n" +
        "]);\n" +
        "var edges = new vis.DataSet([\n" +
        "  {from: 1, to: 2 , arrows: { to: { enabled: true, type: 'arrow'}}}\n" +
        ", {from: 2, to: 3 , arrows: { to: { enabled: true, type: 'arrow'}}}\n" +
        ", {from: 3, to: 4 , arrows: { to: { enabled: true, type: 'arrow'}}}\n" +
        ", {from: 4, to: 1 , arrows: { to: { enabled: true, type: 'arrow'}}}\n" +
        "]);\n");
  }
}
