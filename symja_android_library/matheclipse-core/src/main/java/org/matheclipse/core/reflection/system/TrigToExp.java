package org.matheclipse.core.reflection.system;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.exception.Validate;
import org.matheclipse.core.eval.interfaces.AbstractEvaluator;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.core.patternmatching.Matcher;

import static org.matheclipse.core.expression.F.ArcCos;
import static org.matheclipse.core.expression.F.ArcSin;
import static org.matheclipse.core.expression.F.ArcTan;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CI;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CNI;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Cosh;
import static org.matheclipse.core.expression.F.Coth;
import static org.matheclipse.core.expression.F.Csch;
import static org.matheclipse.core.expression.F.E;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.Pi;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sech;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Sinh;
import static org.matheclipse.core.expression.F.Sqr;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Tan;
import static org.matheclipse.core.expression.F.Tanh;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.x_;

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

	final static Matcher MATCHER = new Matcher(EvalEngine.get());
	static {
		// I/(2*E^(I*x))-1/2*I*E^(I*x)
		MATCHER.caseOf(Sin(x_), //
				x -> Subtract(Times(C1D2, CI, Power(E, Times(CNI, x))), Times(C1D2, CI, Power(E, Times(CI, x)))));
		// 1/(2*E^(I*x))+E^(I*x)/2
		MATCHER.caseOf(Cos(x_), //
				x -> Plus(Times(C1D2, Power(E, Times(CNI, x))), Times(C1D2, Power(E, Times(CI, x)))));
		// (I*(E^(-I*x)-E^(I*x)))/(E^(-I*x)+E^(I*x))
		MATCHER.caseOf(Tan(x_), //
				x -> Times(CI, Subtract(Power(E, Times(CNI, x)), Power(E, Times(CI, x))),
				Power(Plus(Power(E, Times(CNI, x)), Power(E, Times(CI, x))), CN1)));
		// -I*Log(I*x+Sqrt(1-x^2))
		MATCHER.caseOf(ArcSin(x_), //
				x -> Times(CNI, Log(Plus(Sqrt(Subtract(C1, Sqr(x))), Times(CI, x)))));
		// Pi/2+I*Log(I*x+Sqrt(1-x^2))
		MATCHER.caseOf(ArcCos(x_), //
				x -> Plus(Times(C1D2, Pi), Times(CI, Log(Plus(Sqrt(Subtract(C1, Sqr(x))), Times(CI, x))))));
		// 1/2*I*Log(1-I*x)-1/2*I*Log(1+I*x)
		MATCHER.caseOf(ArcTan(x_), //
				x -> Subtract(Times(C1D2, CI, Log(Plus(C1, Times(CNI, x)))),
						Times(C1D2, CI, Log(Plus(C1, Times(CI, x))))));
		// (E^x+E^(-x))/2
		MATCHER.caseOf(Cosh(x_), //
				x -> Times(C1D2, Plus(Power(E, x), Power(E, Times(CN1, x)))));
		// 2/(E^x-E^(-x))
		MATCHER.caseOf(Csch(x_), //
				x -> Times(C2, Power(Plus(Power(E, x), Times(CN1, Power(E, Times(CN1, x)))), CN1)));
		// ((E^(-x))+E^x)/((-E^(-x))+E^x)
		MATCHER.caseOf(Coth(x_), //
				x -> Times(Plus(Power(E, x), Power(E, Times(CN1, x))),
				Power(Plus(Power(E, x), Times(CN1, Power(E, Times(CN1, x)))), CN1)));
		// 2/(E^x+E^(-x))
		MATCHER.caseOf(Sech(x_), //
				x -> Times(C2, Power(Plus(Power(E, x), Power(E, Times(CN1, x))), CN1)));
		// (E^x-E^(-x))/2
		MATCHER.caseOf(Sinh(x_), //
				x -> Times(C1D2, Plus(Power(E, x), Times(CN1, Power(E, Times(CN1, x))))));
		// ((-E^(-x))+E^x)/((E^(-x))+E^x)
		MATCHER.caseOf(Tanh(x_), //
				x -> Times(Plus(Times(CN1, Power(E, Times(CN1, x))), Power(E, x)),
				Power(Plus(Power(E, Times(CN1, x)), Power(E, x)), CN1)));
	}

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
		Validate.checkSize(ast, 2);
		IExpr arg1 = ast.arg1();
		return MATCHER.replaceAll(arg1).orElse(arg1);
	}

	@Override
	public void setUp(final ISymbol newSymbol) {
		newSymbol.setAttributes(ISymbol.LISTABLE);
	}

}
