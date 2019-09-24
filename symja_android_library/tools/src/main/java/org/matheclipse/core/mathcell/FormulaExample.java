package org.matheclipse.core.mathcell;

public class FormulaExample extends BasePlotExample {

	@Override
	public String exampleFunction() {
		return "Manipulate(Factor(x^n + 1), {n, 1, 5, 1})";
	}

	public static void main(String[] args) {
		FormulaExample p = new FormulaExample();
		p.generateHTML();
	}
}
