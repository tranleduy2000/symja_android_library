package org.matheclipse.core.rubi;

import junit.framework.TestCase;

import org.matheclipse.core.basic.Config;
import org.matheclipse.core.eval.EvalControlledCallable;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.ExprEvaluator;
import org.matheclipse.core.eval.exception.AbortException;
import org.matheclipse.core.eval.exception.Validate;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.form.output.OutputFormFactory;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.parser.client.SyntaxError;
import org.matheclipse.parser.client.math.MathException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.concurrent.TimeUnit;

/**
 * Tests system.reflection classes
 */
public abstract class AbstractRubiTestCase extends TestCase {

	private ExprEvaluator fEvaluator;
	/**
	 * Timeout limit in seconds as the default value for Symja expression evaluation.
	 */
	private long fSeconds = 3;

	public AbstractRubiTestCase(String name) {
		super(name);
		Config.SERVER_MODE = false;
	}

	private String printResult(IExpr result, String expectedResult) throws IOException {
		if (result.equals(F.Null)) {
			return "";
		}
		if (result.equals(F.$Aborted)) {
			return "TIMEOUT";
		}
		IExpr expected = fEvaluator.eval(expectedResult);
		if (result.equals(expected)) {
			// the expressions are structurally equal
			return expectedResult;
		}
		// IExpr resultTogether= F.Together.of(F.ExpandAll(result));
		// IExpr expectedTogether = F.Together.of(F.ExpandAll(expected));
		// if (resultTogether.equals(expectedTogether)) {
		// // the expressions are structurally equal
		// return expectedResult;
		// }
		final StringWriter buf = new StringWriter();
		OutputFormFactory.get(true).convert(buf, result);
		return buf.toString();
	}

	/**
	 * Evaluates the given string-expression and returns the result in <code>OutputForm</code>
	 * 
	 * @param inputExpression
	 * @return
	 */
	public String interpreter(final String inputExpression, final String expectedResult) {
		IExpr result;
		final StringWriter buf = new StringWriter();
		try {
			if (fSeconds <= 0) {
				result = fEvaluator.eval(inputExpression);
			} else {
				result = fEvaluator.evaluateWithTimeout(inputExpression, fSeconds, TimeUnit.SECONDS, true,
						new EvalControlledCallable(fEvaluator.getEvalEngine()));
			}
			if (result != null) {
				return printResult(result, expectedResult);
			}
		} catch (final AbortException re) {
			try {
				return printResult(F.$Aborted, expectedResult);
			} catch (IOException e) {
				Validate.printException(buf, e);
				System.err.println(buf.toString());
				System.err.flush();
				return "";
			}
		} catch (final SyntaxError se) {
			String msg = se.getMessage();
			System.err.println(msg);
			System.err.println();
			System.err.flush();
			return "";
		} catch (final RuntimeException re) {
			Throwable me = re.getCause();
			if (me instanceof MathException) {
				Validate.printException(buf, me);
			} else {
				Validate.printException(buf, re);
			}
			System.err.println(buf.toString());
			System.err.flush();
			return "";
		} catch (final Exception e) {
			Validate.printException(buf, e);
			System.err.println(buf.toString());
			System.err.flush();
			return "";
		} catch (final OutOfMemoryError e) {
			Validate.printException(buf, e);
			System.err.println(buf.toString());
			System.err.flush();
			return "";
		} catch (final StackOverflowError e) {
			Validate.printException(buf, e);
			System.err.println(buf.toString());
			System.err.flush();
			return "";
		}
		return buf.toString();
	}

	public void check(String evalString, String expectedResult) {
		check(evalString, expectedResult, -1);
	}

	public void check(String evalString, String expectedResult, int resultLength) {
		try {
			if (evalString.length() == 0 && expectedResult.length() == 0) {
				return;
			}
			// scriptEngine.put("STEPWISE",Boolean.TRUE);
			String evaledResult = interpreter(evalString, expectedResult);

			if (resultLength > 0 && evaledResult.length() > resultLength) {
				evaledResult = evaledResult.substring(0, resultLength) + "<<SHORT>>";
				assertEquals(expectedResult, evaledResult);
			} else {
				assertEquals(expectedResult, evaledResult);
			}
		} catch (Exception e) {
			e.printStackTrace();
			assertEquals("", "1");
		}
	}

	/**
	 * The JUnit setup method
	 */
	@Override
	protected void setUp() {
		try {
			fEvaluator = new ExprEvaluator(false, 100);
			F.await();

			EvalEngine engine = EvalEngine.get();
			engine.setRecursionLimit(256);
			engine.setIterationLimit(500);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
