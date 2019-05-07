package org.matheclipse.core.reflection.system;

import org.matheclipse.core.basic.Config;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.exception.Validate;
import org.matheclipse.core.eval.interfaces.AbstractFunctionEvaluator;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IASTMutable;
import org.matheclipse.core.interfaces.IComplex;
import org.matheclipse.core.interfaces.IComplexNum;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.INum;
import org.matheclipse.core.interfaces.IRational;
import org.matheclipse.core.interfaces.ISignedNumber;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.core.visit.VisitorExpr;

/**
 * <pre>
 * Rationalize(expression)
 * </pre>
 * 
 * <blockquote>
 * <p>
 * convert numerical real or imaginary parts in (sub-)expressions into rational numbers.
 * </p>
 * </blockquote>
 * <h3>Examples</h3>
 * 
 * <pre>
 * &gt;&gt; Rationalize(6.75)
 * 27/4
 * 
 * &gt;&gt; Rationalize(0.25+I*0.33333)
 * 1/4+I*33333/100000
 * </pre>
 */
public class Rationalize extends AbstractFunctionEvaluator {

	static class RationalizeVisitor extends VisitorExpr {
		double epsilon;

		public RationalizeVisitor(double epsilon) {
			super();
			this.epsilon = epsilon;
		}

		@Override
		public IExpr visit(IASTMutable ast) {
			if (ast.isNumericFunction()) {
				ISignedNumber signedNumber = ast.evalReal();
				if (signedNumber != null) {
					return getRational(signedNumber);
				}
			}
			return super.visitAST(ast);
		}

		@Override
		public IExpr visit(IComplex element) {
			return element;
		}

		@Override
		public IExpr visit(IComplexNum element) {
			return F.complex(element.getRealPart(), element.getImaginaryPart(), epsilon);
		}

		// @Override
		// public IExpr visit(IFraction element) {
		// return element;
		// }

		// @Override
		// public IExpr visit(IInteger element) {
		// return element;
		// }

		@Override
		public IExpr visit(INum element) {
			return F.fraction(element.getRealPart(), epsilon);
		}

		/**
		 * 
		 * @return <code>F.NIL</code>, if no evaluation is possible
		 */
		@Override
		public IExpr visit(ISymbol element) {
			if (element.isNumericFunction()) {
				ISignedNumber signedNumber = element.evalReal();
				if (signedNumber != null) {
					return getRational(signedNumber);
				}
			}
			return F.NIL;
		}

		private IRational getRational(ISignedNumber signedNumber) {
			if (signedNumber.isRational()) {
				return (IRational) signedNumber;
			}
					return F.fraction(signedNumber.doubleValue(), epsilon);
				}
			}
	static class RationalizeNumericsVisitor extends VisitorExpr {
		double epsilon;

		public RationalizeNumericsVisitor(double epsilon) {
			super();
			this.epsilon = epsilon;
		}

		@Override
		public IExpr visit(IASTMutable ast) {
			return super.visitAST(ast);
		}

		@Override
		public IExpr visit(IComplex element) {
			return element;
		}

		@Override
		public IExpr visit(IComplexNum element) {
			return F.complex(element.getRealPart(), element.getImaginaryPart(), epsilon);
		}

		@Override
		public IExpr visit(INum element) {
			return F.fraction(element.getRealPart(), epsilon);
		}

		private IRational getRational(ISignedNumber signedNumber) {
			if (signedNumber.isRational()) {
				return (IRational) signedNumber;
			}
			return F.fraction(signedNumber.doubleValue(), epsilon);
		}
	}

	public Rationalize() {
	}

	@Override
	public IExpr evaluate(final IAST ast, EvalEngine engine) {
		Validate.checkRange(ast, 2, 3);

		IExpr arg1 = ast.arg1();
		double epsilon = Config.DOUBLE_EPSILON;
		try {
			if (ast.isAST2()) {
				ISignedNumber epsilonExpr = ast.arg2().evalReal();
				if (epsilonExpr == null) {
					return F.NIL;
				}
				epsilon = epsilonExpr.doubleValue();
				if (arg1.isNumericFunction()) {
					// works more similar to MMA if we do this step:
					arg1 = engine.evalN(arg1);
				}
			}
			// try to convert into a fractional number
			return ofNumbers(arg1, epsilon).orElse(arg1);
		} catch (Exception e) {
			if (Config.SHOW_STACKTRACE) {
				e.printStackTrace();
			}
		}

		return F.NIL;
	}

	/**
	 * Rationalize numeric numbers and numeric functions (e.g. Sin(Pi*4.5) ) in expression <code>arg</code>.
	 *
	 * @param arg1
	 * @return <code>F.NIL</code> if no expression was transformed
	 */
	public static IExpr of(IExpr arg1) {
		return of(arg1, Config.DOUBLE_EPSILON);
	}

	/**
	 * Rationalize numeric numbers and numeric functions (e.g. Sin(Pi*4.5) ) in expression <code>arg</code>.
	 *
	 * @param arg1
	 * @param epsilon
	 * @return <code>F.NIL</code> if no expression was transformed
	 */
	public static IExpr of(IExpr arg1, double epsilon) {
		RationalizeVisitor rationalizeVisitor = new RationalizeVisitor(epsilon);
		return arg1.accept(rationalizeVisitor);
	}

	/**
	 * Rationalize only pure numeric numbers in expression <code>arg</code>.
	 *
	 * @param arg1
	 * @return <code>F.NIL</code> if no expression was transformed
	 */
	public static IExpr ofNumbers(IExpr arg1) {
		return ofNumbers(arg1, Config.DOUBLE_EPSILON);
	}

	/**
	 * Rationalize only pure numeric numbers in expression <code>arg</code>.
	 *
	 * @param arg1
	 * @param epsilon
	 * @return <code>F.NIL</code> if no expression was transformed
	 */
	public static IExpr ofNumbers(IExpr arg1, double epsilon) {
		RationalizeNumericsVisitor rationalizeVisitor = new RationalizeNumericsVisitor(epsilon);
		return arg1.accept(rationalizeVisitor);
	}
	@Override
	public void setUp(final ISymbol newSymbol) {
		newSymbol.setAttributes(ISymbol.HOLDALL | ISymbol.LISTABLE);
	}
}
