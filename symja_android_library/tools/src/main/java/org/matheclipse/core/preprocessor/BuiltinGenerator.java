package org.matheclipse.core.preprocessor;

import org.matheclipse.core.convert.AST2Expr;

import java.util.ArrayList;
import java.util.Collections;

public class BuiltinGenerator {

	final static String HEADER = "package org.matheclipse.core.expression;\n" + "\n"
			+ "import org.matheclipse.core.interfaces.IBuiltInSymbol;\n" + "\n" + "public enum BuiltIns {";

	final static String FOOTER = "\n" + "	private final String name;\n" + "	private final int symbolID;\n"
			+ "	private final static IBuiltInSymbol[] builtInSymbols = new IBuiltInSymbol[values().length];\n" + "\n"
			+ "	public static IBuiltInSymbol valueOf(BuiltIns sEnum) {\n"
			+ "		IBuiltInSymbol symbol = F.initFinalSymbol(sEnum);\n"
			+ "		builtInSymbols[sEnum.symbolID] = symbol;\n" + "		return symbol;\n" + "	}\n" + "\n"
			+ "	BuiltIns(String name, int symbolID) {\n" + "		this.name = name;\n"
			+ "		this.symbolID = symbolID;\n" + "	}\n" + "\n" + "	public static IBuiltInSymbol symbol(int id) {\n"
			+ "		return builtInSymbols[id];\n" + "	}\n" + "\n" + "	public final int id() {\n"
			+ "		return symbolID;\n" + "	}\n" + "\n" + "	public final String str() {\n" + "		return name;\n"
			+ "	}\n" + "}";

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < AST2Expr.UPPERCASE_SYMBOL_STRINGS.length; i++) {
			list.add(AST2Expr.UPPERCASE_SYMBOL_STRINGS[i]);
		}
		for (int i = 0; i < AST2Expr.SYMBOL_STRINGS.length; i++) {
			list.add(AST2Expr.SYMBOL_STRINGS[i]);
		}
		for (int i = 0; i < AST2Expr.FUNCTION_STRINGS.length; i++) {
			list.add(AST2Expr.FUNCTION_STRINGS[i]);
		}
		Collections.sort(list);

		// public final static IBuiltInSymbol XXXXX = BuiltIns.valueOf(BuiltIns.XXXXX);
		int i = 0;
		for (String sym : list) {
			// System.out.println(" public final static IBuiltInSymbol " + sym.name()
			// + " = BuiltIns.valueOf(BuiltIns." + sym.name() + ");");
			System.out.println("        public final static IBuiltInSymbol " + sym + " = F.initFinalSymbol(\"" + sym
					+ "\", ID." + sym + ");");

		}

	}
}
