package org.matheclipse.core.mathcell;

public class ListPlotExample extends BasePlotExample {

	@Override
	public String exampleFunction() {
		// return "ListPlot(Prime(Range(25)))";
//		return "ListPlot(Table({Sin(t), Cos(t)}, {t, 100}))";
		return "Manipulate(ListPlot(Table({Sin(t*b), Cos(t*a)}, {t, 100})), {a,1,4,1}, {b,1,12})";
	}

	public static void main(String[] args) {
		ListPlotExample p = new ListPlotExample();
		p.generateHTML();
	}
}
