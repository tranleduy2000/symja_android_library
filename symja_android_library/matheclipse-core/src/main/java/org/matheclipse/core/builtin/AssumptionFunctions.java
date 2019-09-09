package org.matheclipse.core.builtin;

import com.duy.lambda.Function;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.interfaces.AbstractCoreFunctionEvaluator;
import org.matheclipse.core.eval.interfaces.AbstractEvaluator;
import org.matheclipse.core.eval.util.AbstractAssumptions;
import org.matheclipse.core.eval.util.Assumptions;
import org.matheclipse.core.eval.util.IAssumptions;
import org.matheclipse.core.eval.util.OptionArgs;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.expression.ID;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IASTAppendable;
import org.matheclipse.core.interfaces.IBuiltInSymbol;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.ISymbol;

public class AssumptionFunctions {
	/**
	 *
	 * See <a href="https://pangin.pro/posts/computation-in-static-initializer">Beware of computation in static
	 * initializer</a>
	 */
	private static class Initializer {

		private static void init() {
		F.Arrays.setEvaluator(new Arrays());
		F.Element.setEvaluator(new Element());
		F.NotElement.setEvaluator(new NotElement());
		F.Refine.setEvaluator(new Refine());
	}
	}

	private final static class Arrays extends AbstractEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {

			if (ast.size() == 2 && ast.arg1().isAST()) {
				return F.Arrays((IAST) ast.arg1());
			}
			if (ast.size() == 3 && ast.arg1().isAST() && ast.arg2().isSymbol()) {
				return F.Arrays((IAST) ast.arg1(), (ISymbol) ast.arg2());
			}
			return F.NIL;
		}

		@Override
		public void setUp(ISymbol newSymbol) {
		}

	}

	/**
	 * <pre>
	 * Element(symbol, dom)
	 * </pre>
	 * 
	 * <blockquote>
	 * <p>
	 * assume (or test) that the <code>symbol</code> is in the domain <code>dom</code>.
	 * </p>
	 * </blockquote>
	 * <p>
	 * See:
	 * </p>
	 * <ul>
	 * <li><a href="https://en.wikipedia.org/wiki/Domain_of_a_function">Wikipedia - Domain of a function</a></li>
	 * </ul>
	 * <h3>Examples</h3>
	 * 
	 * <pre>
	 * &gt;&gt; Refine(Sin(k*Pi), Element(k, Integers))
	 * 0
	 * </pre>
	 */
	private static class Element extends AbstractCoreFunctionEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {

			final IExpr arg2 = engine.evaluate(ast.arg2());
			if (arg2.isSymbol()) {
				final ISymbol domain = (ISymbol) arg2;
				final IExpr arg1 = engine.evaluate(ast.arg1());
				if (arg1.isAST(F.Alternatives)) {
					return ((IAST) arg1).findFirst(new Function<IExpr, IExpr>() {
						@Override
						public IExpr apply(IExpr x) {
							return Element.this.assumeDomain(x, domain);
						}
					});
				} else {
					return assumeDomain(arg1, domain);
				}
			}
			return F.NIL;
		}

		public int[] expectedArgSize() {
			return IOFunctions.ARGS_2_2;
		}
		/**
		 * Return F.True or F.False if expr is assumed to be in the <code>domain</code> or not to be in the
		 * <code>domain</code>.
		 *
		 * @param arg1
		 * @param domain
		 * @return F.True or F.False if expr is assumed to be in the <code>domain</code> or not to be in the
		 *         <code>domain</code>. In all other cases return <code>F.NIL</code>.
		 */
		private IExpr assumeDomain(final IExpr arg1, final ISymbol domain) {
			if (domain.isBuiltInSymbol()) {
				ISymbol truthValue;
				int symbolID = ((IBuiltInSymbol) domain).ordinal();
				switch (symbolID) {
				case ID.Algebraics:
					truthValue = AbstractAssumptions.assumeAlgebraic(arg1);
				if (truthValue != null) {
					return truthValue;
				}
					break;
				case ID.Arrays: 
					truthValue = AbstractAssumptions.assumeArray(arg1);
					if (truthValue != null) {
						return truthValue;
					}
					break;
				case ID.Booleans:
					truthValue = AbstractAssumptions.assumeBoolean(arg1);
				if (truthValue != null) {
					return truthValue;
				}
					break;
				case ID.Complexes:
					truthValue = AbstractAssumptions.assumeComplex(arg1);
				if (truthValue != null) {
					return truthValue;
				}
					break;
				case ID.Integers:
					truthValue = AbstractAssumptions.assumeInteger(arg1);
				if (truthValue != null) {
					return truthValue;
				}
					break;
				case ID.Primes:
				return AbstractAssumptions.assumePrime(arg1);
				case ID.Rationals:
					truthValue = AbstractAssumptions.assumeRational(arg1);
				if (truthValue != null) {
					return truthValue;
				}
					break;
				case ID.Reals:
					truthValue = AbstractAssumptions.assumeReal(arg1);
				if (truthValue != null) {
					return truthValue;
				}
					break;
				default:
					break;
				}
			}
			return F.NIL;
		}

	}

	private static class NotElement extends AbstractCoreFunctionEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {

			final IExpr arg2 = engine.evaluate(ast.arg2());
			if (arg2.isSymbol()) {
				final IExpr arg1 = engine.evaluate(ast.arg1());
				if (arg1.isAST(F.Alternatives)) {
					IAST alternatives = (IAST) arg1;
					IASTAppendable andList = F.And();
					for (int i = 1; i < alternatives.size(); i++) {
						andList.append(F.Not(F.Element(alternatives.get(i), (ISymbol) arg2)));
					}
					return andList;
				}
				return F.Not(F.Element(arg1, (ISymbol) arg2));
			}
			return F.NIL;
		}

		public int[] expectedArgSize() {
			return IOFunctions.ARGS_2_2;
		}
	}
	/**
	 * <pre>
	 * Refine(expression, assumptions)
	 * </pre>
	 * 
	 * <blockquote>
	 * <p>
	 * evaluate the <code>expression</code> for the given <code>assumptions</code>.
	 * </p>
	 * </blockquote>
	 * <h3>Examples</h3>
	 * 
	 * <pre>
	 * &gt;&gt; Refine(Abs(n+Abs(m)), n&gt;=0)
	 * Abs(m)+n
	 * 
	 * &gt;&gt; Refine(-Infinity&lt;x, x&gt;0)
	 * True 
	 * 
	 * &gt;&gt; Refine(Max(Infinity,x,y), x&gt;0)
	 * Max(Infinity,y)
	 * 
	 * &gt;&gt; Refine(Sin(k*Pi), Element(k, Integers))
	 * 0
	 * 
	 * &gt;&gt; Sin(k*Pi)
	 * Sin(k*Pi)
	 * </pre>
	 */
	private static class Refine extends AbstractCoreFunctionEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {

			if (ast.size() == 3) {
				final IExpr arg2 = engine.evaluate(ast.arg2());
				IAssumptions assumptions = determineAssumptions(ast.topHead(), arg2, engine);
				if (assumptions != null) {
					return refineAssumptions(ast.arg1(), assumptions, engine);
				}
			}
			return ast.arg1();
		}



		@Override
		public int[] expectedArgSize() {
			return IOFunctions.ARGS_1_2;
		}
	}

	public static IAssumptions determineAssumptions(final ISymbol symbol, final IExpr arg2, EvalEngine engine) {
		final OptionArgs options = new OptionArgs(symbol, arg2, engine);
		IExpr option = options.getOption(F.Assumptions);
		if (option.isPresent()) {
			return Assumptions.getInstance(option);
		} else {
			return Assumptions.getInstance(arg2);
		}
	}

	public static IExpr refineAssumptions(final IExpr expr, IAssumptions assumptions, EvalEngine engine) {
		IAssumptions oldAssumptions=engine.getAssumptions();
		try {
			engine.setAssumptions(assumptions);
			// System.out.println(expr.toString());
			return engine.evalWithoutNumericReset(expr);
		} finally {
			engine.setAssumptions(oldAssumptions);
		}
	}


	public static void initialize() {
		Initializer.init();
	}

	private AssumptionFunctions() {

	}

}
