package org.matheclipse.core.reflection.system;

import com.duy.lambda.Function;

import org.matheclipse.core.builtin.IOFunctions;
import org.matheclipse.core.builtin.Structure;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.interfaces.AbstractEvaluator;
import org.matheclipse.core.expression.ID;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.ISymbol;

/**
 * <pre>
 * TrigToExp(expr)
 * </pre>
 *
 * <blockquote>
 * <p>
 * converts trigonometric functions in <code>expr</code> to exponentials.
 * </p>
 * </blockquote>
 * <h3>Examples</h3>
 *
 * <pre>
 * &gt;&gt; TrigToExp(Cos(x))
 * 1/2*E^(I*x)+1/2*E^(-I*x)
 * </pre>
 */
public class TrigToExp extends AbstractEvaluator {


	public TrigToExp() {
	}

	/**
	 * Exponential definitions for trigonometric functions
	 *
	 * See <a href= "http://en.wikipedia.org/wiki/List_of_trigonometric_identities#Exponential_definitions"> List of
	 * trigonometric identities - Exponential definitions</a>,<br/>
	 * <a href="http://en.wikipedia.org/wiki/Hyperbolic_function">Hyperbolic function</a>
	 */
	@Override
	public IExpr evaluate(final IAST ast, EvalEngine engine) {
			IExpr temp = Structure.threadLogicEquationOperators(ast.arg1(), ast, 1);
			if (temp.isPresent()) {
				return temp;
			}

		IExpr arg1 = ast.arg1();
		return arg1.replaceAll(new Function<IExpr, IExpr>() {
			@Override
			public IExpr apply(IExpr x) {
				IExpr t = x.rewrite(ID.Exp);
				if (!t.isPresent()) {
					t = x.rewrite(ID.Log);
				}
				return t;
			}
		}).orElse(arg1);
	}
	@Override
	public int[] expectedArgSize() {
		return IOFunctions.ARGS_1_1;
	}

	@Override
	public void setUp(final ISymbol newSymbol) {
		newSymbol.setAttributes(ISymbol.LISTABLE);
	}

}