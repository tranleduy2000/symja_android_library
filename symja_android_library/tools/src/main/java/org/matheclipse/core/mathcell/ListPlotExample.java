package org.matheclipse.core.mathcell;

public class ListPlotExample extends BasePlotExample {

	@Override
	public String exampleFunction() {
		return "Manipulate(ListPlot(Table({Sin(t), Cos(t*a)}, {t, 100})), {a,1,4,1})";
	}

	public static void main(String[] args) {
		ListPlotExample p = new ListPlotExample();
		p.generateHTML();
	}
}
