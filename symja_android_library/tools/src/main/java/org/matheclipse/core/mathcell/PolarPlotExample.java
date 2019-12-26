package org.matheclipse.core.mathcell;

public class PolarPlotExample extends BasePlotExample {

	@Override
	public String exampleFunction() {
		return "PolarPlot(1-Cos(t), {t, 0, 2*Pi})";
	}

	public static void main(String[] args) {
		PolarPlotExample p = new PolarPlotExample();
		p.generateHTML();
	}

}
