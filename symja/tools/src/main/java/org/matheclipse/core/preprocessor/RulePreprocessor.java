package org.matheclipse.core.preprocessor;

import org.matheclipse.core.basic.Config;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.parser.ExprParser;
import org.matheclipse.core.patternmatching.RulesData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Generate java sources for Symja rule files.
 */
public class RulePreprocessor {

	final static String HEADER = "package org.matheclipse.core.reflection.system.rules;\n" + "\n"
			+ "import static org.matheclipse.core.expression.F.*;\n" + "import org.matheclipse.core.interfaces.IAST;\n"
			+ "\n" + "/**\n"
			+ " * <p>Generated by <code>org.matheclipse.core.preprocessor.RulePreprocessor</code>.</p>\n"
			+ " * <p>See GIT repository at: <a href=\"https://github.com/axkr/symja_android_library\">github.com/axkr/symja_android_library under the tools directory</a>.</p>\n"
			+ " */\n" + "public interface ";

	final static String SIZES = "  /**\n" + "   * <ul>\n"
			+ "   * <li>index 0 - number of equal rules in <code>RULES</code></li>\n" + "	 * </ul>\n" + "	 */\n"
			+ "  final public static int[] SIZES = { ";

	final static String LIST0 = "  final public static IAST RULES";
	final static String LIST1 = " = List(";

	final static String FOOTER0 = "  );\n";
	final static String FOOTER1 = "}";

	public RulePreprocessor() {
	}

	public static void appendSetDelayedToBuffer(IAST ast, StringBuilder buffer, boolean evalRHS, boolean last) {
		IExpr leftHandSide = ast.arg1();
		IExpr rightHandSide = ast.arg2();
		if (ast.arg1().isAST()) {
			leftHandSide = EvalEngine.get().evalLHSPattern((IAST) leftHandSide);
		}
		if (evalRHS) {
			rightHandSide = F.eval(rightHandSide);
		}
		buffer.append(leftHandSide.internalJavaString(false, 1, false, false, false));
		buffer.append( ",\n      ");
		buffer.append(rightHandSide.internalJavaString(false, 1, false, false, false));
		if (last) {
			buffer.append(")\n");
		} else {
			buffer.append("),\n");
		}
	}

	public static void convert(IExpr expr, String rulePostfix, StringBuilder buffer, final PrintWriter out,
							   String symbolName, EvalEngine engine) {
		try {
			if (expr.isListOfLists()) {
				IAST list = (IAST) expr;
				for (int i = 1; i < list.size(); i++) {
					convertExpr(list.get(i), Integer.toString(i), out, null);
				}
			} else {
				convertExpr(expr, rulePostfix, out, symbolName);
			}
		} catch (UnsupportedOperationException uoe) {
			System.out.println(uoe.getMessage());
			System.out.println(expr.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void convertExpr(IExpr expr, String rulePostfix, final PrintWriter out, String symbolName) {
		boolean last;
		StringBuilder buffer = new StringBuilder();
		if (expr.isAST()) {
			IAST list = (IAST) expr;
			if (symbolName != null) {
				int equalsRuleCounter = 0;
				int simpleRuleCounter = 0;
				for (int i = 1; i < list.size(); i++) {
					last = i == (list.argSize());
					expr = list.get(i);
					if (expr.isAST(F.SetDelayed, 3)) {
						IAST ast = (IAST) expr;
						if (!RulesData.isComplicatedPatternRule(ast.arg1())) {
							simpleRuleCounter++;
						}
					} else if (expr.isAST(F.Set, 3)) {
						equalsRuleCounter++;
					}
				}
				if (equalsRuleCounter > 0 || simpleRuleCounter > 0) {
					out.print(SIZES);
					out.append(Integer.toString(equalsRuleCounter));
					out.append(", ");
					out.append(Integer.toString(simpleRuleCounter));
					out.append(" };\n\n");
					buffer.append("    IInit(");
					buffer.append(symbolName);
					buffer.append(", SIZES),\n");
				}
			}

			for (int i = 1; i < list.size(); i++) {
				last = i == (list.argSize());
				expr = list.get(i);
				if (expr.isAST(F.SetDelayed, 3)) {
					IAST ast = (IAST) expr;
					buffer.append("    // " + ast.toString().replaceAll("\\n", "") + "\n");
					buffer.append("    ISetDelayed(");
					appendSetDelayedToBuffer(ast, buffer, false, last);
				} else if (expr.isAST(F.Set, 3)) {
					IAST ast = (IAST) expr;
					buffer.append("    // " + ast.toString().replaceAll("\\n", "") + "\n");
					buffer.append("    ISet(");
					appendSetDelayedToBuffer(ast, buffer, true, last);
				} else if (expr.isAST(F.Rule, 3)) {
					IAST ast = (IAST) expr;
					buffer.append("    // " + ast.toString().replaceAll("\\n", "") + "\n");
					buffer.append("    Rule(");
					appendSetDelayedToBuffer(ast, buffer, true, last);
				}
			}
		} else {
			if (expr.isAST(F.SetDelayed, 3)) {
				IAST ast = (IAST) expr;
				buffer.append("    ISetDelayed(");
				appendSetDelayedToBuffer(ast, buffer, false, true);
			} else if (expr.isAST(F.Set, 3)) {
				IAST ast = (IAST) expr;
				buffer.append("    ISet(");
				appendSetDelayedToBuffer(ast, buffer, true, true);
			} else if (expr.isAST(F.Rule, 3)) {
				IAST ast = (IAST) expr;
				buffer.append("    Rule(");
				appendSetDelayedToBuffer(ast, buffer, true, true);
			}
		}
		out.print(LIST0);
		out.print(rulePostfix);
		out.println(LIST1);
		out.print(buffer.toString());
		out.print(FOOTER0);
	}

	public static IExpr parseFileToList(File file, EvalEngine engine) {
		try {
			final BufferedReader f = new BufferedReader(new FileReader(file));
			final StringBuilder buff = new StringBuilder(1024);
			String line;
			while ((line = f.readLine()) != null) {
				buff.append(line);
				buff.append('\n');
			}
			f.close();
			String inputString = buff.toString();
			ExprParser p = new ExprParser(engine, true);
			return p.parse(inputString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Generate Java files (*.java) from Symja rule files (*.m)
	 *
	 * @param sourceLocation
	 *            source directory for rule (*.m) files
	 * @param targetLocation
	 *            target directory for the generated Java files
	 * @param ignoreTimestamp
	 *            if <code>false</code> only change the target file (*.java), if the source file (*.m) has a newer time
	 *            stamp than the target file.
	 */
	public static void generateFunctionStrings(final File sourceLocation, File targetLocation,
											   boolean ignoreTimestamp) {
		if (sourceLocation.exists()) {
			// Get the list of the files contained in the package
			final String[] files = sourceLocation.list();
			if (files != null) {
				StringBuilder buffer;
				EvalEngine engine = new EvalEngine(true);
				for (int i = 0; i < files.length; i++) {
					File sourceFile = new File(sourceLocation, files[i]);
					// we are only interested in .m files
					if (files[i].endsWith(".m")) {
						IExpr expr = parseFileToList(sourceFile, engine);

						if (expr != null) {
							buffer = new StringBuilder(100000);
							PrintWriter out;
							try {
								String className = files[i].substring(0, files[i].length() - 2);
								String symbolName = className.substring(0, className.length() - 5);
								File targetFile = new File(targetLocation, className + ".java");
								if (targetFile.exists()) {
									if (!ignoreTimestamp && (sourceFile.lastModified() <= targetFile.lastModified())) {
										// only copy if timestamp is newer than
										// existing ones
										continue;
									}
								}
								System.out.println(className);
								out = new PrintWriter(targetFile.getCanonicalPath());
								out.print(HEADER);
								out.print(className);
								out.print(" {\n");
								convert(expr, "", buffer, out, symbolName, engine);
								out.println(FOOTER1);
								out.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}

					}
				}
			}
		}

	}

	public static void main(final String[] args) {
		Config.EXPLICIT_TIMES_OPERATOR = true;
		F.initSymbols();
		// C:\\Users\\dev\\git\\symja_android_library
		File sourceLocation = new File("..\\symja_android_library\\rules");
		File targetLocation = new File(
				"..\\symja_android_library\\matheclipse-core\\src\\main\\java\\org\\matheclipse\\core\\reflection\\system\\rules");

		generateFunctionStrings(sourceLocation, targetLocation, true);
	}

}