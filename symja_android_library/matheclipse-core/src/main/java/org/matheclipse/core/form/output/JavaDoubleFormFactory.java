package org.matheclipse.core.form.output;

import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.ISymbol;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Converts an internal <code>IExpr</code> into a user readable string.
 * 
 */
public class JavaDoubleFormFactory extends DoubleFormFactory {
	private final static Map<ISymbol, String> FUNCTIONS_STR = new HashMap<ISymbol, String>();
	static {

		FUNCTIONS_STR.put(F.Abs, "Math.abs");

		FUNCTIONS_STR.put(F.ArcCos, "Math.acos");
		FUNCTIONS_STR.put(F.ArcSin, "Math.asin");
		FUNCTIONS_STR.put(F.ArcTan, "Math.atan");

		FUNCTIONS_STR.put(F.Ceiling, "Math.ceil");
		FUNCTIONS_STR.put(F.Cos, "Math.cos");
		FUNCTIONS_STR.put(F.Cosh, "Math.cosh");
		FUNCTIONS_STR.put(F.Floor, "Math.floor");

		FUNCTIONS_STR.put(F.Log, "Math.log");
		FUNCTIONS_STR.put(F.Max, "Math.max");
		FUNCTIONS_STR.put(F.Min, "Math.min");
		// Power is handled by coding
		// FUNCTIONS_STR.put(F.Power, "Math.pow");

		FUNCTIONS_STR.put(F.Sin, "Math.sin");
		FUNCTIONS_STR.put(F.Sinh, "Math.sinh");
		FUNCTIONS_STR.put(F.Tan, "Math.tan");
		FUNCTIONS_STR.put(F.Tanh, "Math.tanh");

	}

	private JavaDoubleFormFactory(final boolean relaxedSyntax, final boolean reversed, int exponentFigures,
			int significantFigures) {
		super(relaxedSyntax, reversed, exponentFigures, significantFigures);
	}

	/**
	 * Get an <code>JavaDoubleFormFactory</code> for converting an internal expression to a user readable string.
	 * 
	 * @param relaxedSyntax
	 *            If <code>true</code> use paranthesis instead of square brackets and ignore case for functions, i.e.
	 *            sin() instead of Sin[]. If <code>true</code> use single square brackets instead of double square
	 *            brackets for extracting parts of an expression, i.e. {a,b,c,d}[1] instead of {a,b,c,d}[[1]].
	 * @return
	 */
	public static JavaDoubleFormFactory get(final boolean relaxedSyntax) {
		return get(relaxedSyntax, false);
	}

	/**
	 * Get an <code>JavaDoubleFormFactory</code> for converting an internal expression to a user readable string.
	 * 
	 * @param relaxedSyntax
	 *            if <code>true</code> use paranthesis instead of square brackets and ignore case for functions, i.e.
	 *            sin() instead of Sin[]. If <code>true</code> use single square brackets instead of double square
	 *            brackets for extracting parts of an expression, i.e. {a,b,c,d}[1] instead of {a,b,c,d}[[1]].
	 * @param plusReversed
	 *            if <code>true</code> the arguments of the <code>Plus()</code> function will be printed in reversed
	 *            order
	 * @return
	 */
	public static JavaDoubleFormFactory get(final boolean relaxedSyntax, final boolean plusReversed) {
		return get(relaxedSyntax, plusReversed, -1, -1);
	}

	/**
	 * Get an <code>JavaDoubleFormFactory</code> for converting an internal expression to a user readable string.
	 * 
	 * @param relaxedSyntax
	 *            if <code>true</code> use paranthesis instead of square brackets and ignore case for functions, i.e.
	 *            sin() instead of Sin[]. If <code>true</code> use single square brackets instead of double square
	 *            brackets for extracting parts of an expression, i.e. {a,b,c,d}[1] instead of {a,b,c,d}[[1]].
	 * @param plusReversed
	 *            if <code>true</code> the arguments of the <code>Plus()</code> function will be printed in reversed
	 *            order
	 * @param exponentFigures
	 * @param significantFigures
	 * @return
	 */
	public static JavaDoubleFormFactory get(final boolean relaxedSyntax, final boolean plusReversed,
			int exponentFigures, int significantFigures) {
		return new JavaDoubleFormFactory(relaxedSyntax, plusReversed, exponentFigures, significantFigures);
	}

	public String functionHead(ISymbol symbol) {
		return FUNCTIONS_STR.get(symbol);
	}

	/**
	 * Get an <code>JavaDoubleFormFactory</code> for converting an internal expression to a user readable string, with
	 * <code>relaxedSyntax</code> set to false.
	 * 
	 * @return
	 * @see #get(boolean)
	 */
	public static JavaDoubleFormFactory get() {
		return get(false);
	}

	public void convertAST(final Appendable buf, final IAST function) throws IOException {
		IExpr head = function.head();
		if (head.isSymbol()) {
			String str = functionHead((ISymbol) head);
			if (str != null) {
				buf.append(str);
				if (function.isAST(F.ArcTan, 3)) {
					buf.append("2");
				}
				convertArgs(buf, head, function);
				return;
			}
		}
		if (function.isPower()) {
			IExpr base = function.base();
			IExpr exponent = function.exponent();
			if (exponent.isMinusOne()) {
				buf.append("(1.0/");
				convert(buf, base);
				buf.append(")");
				return;
			}
			if (exponent.isNumEqualRational(F.C1D2)) {
				buf.append("Math.sqrt(");
				convert(buf, base);
				buf.append(")");
				return;
			}
			if (exponent.isNumEqualRational(F.C1D3)) {
				buf.append("Math.cbrt(");
				convert(buf, base);
				buf.append(")");
				return; 
			}
			buf.append("Math.pow");
			convertArgs(buf, head, function);
			return;
		}
		if (function.isInfinity()) {
			buf.append("Double.POSITIVE_INFINITY");
			return;
		}
		if (function.isNegativeInfinity()) {
			buf.append("Double.NEGATIVE_INFINITY");
			return;
		}
		convert(buf, head);
		convertArgs(buf, head, function);
	}

}
