package org.matheclipse.core.reflection.system;

import org.matheclipse.core.basic.ToggleFeature;
import org.matheclipse.core.builtin.IOFunctions;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.interfaces.AbstractCoreFunctionEvaluator;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;

/**
 *
 *
 */
public class Compile extends AbstractCoreFunctionEvaluator {
	static final String JAVA_SOURCE_CODE = //
			"/* an in-memory compiled function */                                      \n"//
					+ "package org.matheclipse.core.compile;                                      \n"//
					+ "                                                                           \n"//
					+ "import org.matheclipse.core.eval.interfaces.AbstractFunctionEvaluator;     \n"//
					+ "import org.matheclipse.core.interfaces.IExpr;                              \n"//
					+ "import org.matheclipse.core.interfaces.IAST;                               \n"//
					+ "import org.matheclipse.core.eval.EvalEngine;                               \n"//
					+ "import org.matheclipse.core.expression.F;                                  \n"//
					+ "                                                                           \n"//
					+ "public class CompiledFunction extends AbstractFunctionEvaluator {          \n"//
					+ "    public IExpr evaluate(final IAST ast, EvalEngine engine){              \n"//
					+ "        {$variables}                                                       \n"//
					+ "        return F.num({$expression});                                       \n"//
					+ "    }                                                                      \n"//
					+ "}                                                                          \n";

	@Override
	public IExpr evaluate(final IAST ast, EvalEngine engine) {
		if (!ToggleFeature.COMPILE) {
			return F.NIL;
		}

		if (ast.arg1().isList()) {

//			JavaStringCompiler compiler = new JavaStringCompiler();
//			Map<String, byte[]> results;
//			try {
//				IAST variables = (IAST) ast.arg1();
//				StringBuilder variablesBuf = new StringBuilder();
//				for (int i = 1; i < variables.size(); i++) {
//					variablesBuf.append("double " + variables.get(i) + " = engine.evalDouble(ast.get(" + i + "));\n");
//				}
//				IExpr expression = ast.arg2();
//				DoubleFormFactory factory = DoubleFormFactory.get(true, false, null);
//				StringBuilder buf = new StringBuilder();
//				factory.convert(buf, expression);
//				String source = JAVA_SOURCE_CODE.replace("{$variables}", variablesBuf.toString());
//				source = source.replace("{$expression}", buf.toString());
//				// System.out.println(source);
//
//				results = compiler.compile("CompiledFunction.java", source);
//
//				Class<?> clazz = compiler.loadClass("org.matheclipse.core.compile.CompiledFunction", results);
//
//				AbstractFunctionEvaluator fun = (AbstractFunctionEvaluator) clazz.newInstance();
//				return DataExpr.newInstance(F.CompiledFunction, fun);
//			} catch (Exception rex) {
//				if (FEConfig.SHOW_STACKTRACE) {
//					rex.printStackTrace();
//				}
//				return engine.printMessage("Compile: " + rex.getMessage());
//			}
			return F.NIL;
		} else {
			return engine.printMessage("Compile: The first argument should be a list of variable names.");
		}
	}

	public int[] expectedArgSize(IAST ast) {
		return IOFunctions.ARGS_2_2;
	}
}