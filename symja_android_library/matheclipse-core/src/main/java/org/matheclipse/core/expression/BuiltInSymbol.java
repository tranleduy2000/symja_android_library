package org.matheclipse.core.expression;

import com.duy.lambda.DoubleFunction;
import com.duy.lambda.Predicate;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.exception.Validate;
import org.matheclipse.core.eval.interfaces.AbstractCorePredicateEvaluator;
import org.matheclipse.core.eval.interfaces.ICoreFunctionEvaluator;
import org.matheclipse.core.eval.interfaces.ISignedNumberConstant;
import org.matheclipse.core.eval.interfaces.ISymbolEvaluator;
import org.matheclipse.core.interfaces.ExprUtil;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IBuiltInSymbol;
import org.matheclipse.core.interfaces.IEvaluator;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.ISymbol;

import java.io.IOException;
import java.io.ObjectStreamException;

/**
 * Implements Symbols for function, constant and variable names
 * 
 */
public class BuiltInSymbol extends Symbol implements IBuiltInSymbol {
	private final static class PredicateEvaluator extends AbstractCorePredicateEvaluator {
		Predicate<IExpr> predicate;

		public PredicateEvaluator(Predicate<IExpr> predicate) {
			this.predicate = predicate;
		}

		/** {@inheritDoc} */
		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			if (ast.isAST1()) {
				return predicate.test(engine.evaluate(ast.arg1())) ? F.True : F.False;
			}
			Validate.checkSize(ast, 2);
			return F.NIL;
		}

		@Override
		public boolean evalArg1Boole(IExpr arg1, EvalEngine engine) {
			return predicate.test(engine.evaluate(arg1));
		}

	}

	private static class DummyEvaluator implements IEvaluator {

		/**
		 * Causes the current thread to wait until the INIT_THREAD has initialized the Integrate() rules.
		 *
		 */
		@Override
		public void await() throws InterruptedException {
			F.await();
		}

		@Override
		public void setUp(ISymbol newSymbol) {
			// do nothing because of dummy evaluator
		}
	}

	/** 
	 * 
	 */
	private static final long serialVersionUID = -4991038487281911261L;

	protected static final DummyEvaluator DUMMY_EVALUATOR = new DummyEvaluator();

	/**
	 * The evaluation class of this built-in-function. See packages: package
	 * <code>org.matheclipse.core.builtin.function</code> and <code>org.matheclipse.core.reflection.system</code>.
	 */
	private transient IEvaluator fEvaluator;

	private transient int fOrdinal;

	// private BuiltInSymbol(final String symbolName) {
	// this(symbolName, null);
	// }
	public BuiltInSymbol(final String symbolName, int ordinal) {
		super(symbolName, Context.SYSTEM);
		// this(symbolName, null);
		fOrdinal = ordinal;
	}

	// private BuiltInSymbol(final String symbolName, final IEvaluator evaluator) {
	// this(symbolName, Context.SYSTEM, evaluator);
	// }

	// private BuiltInSymbol(final String symbolName, Context context, final IEvaluator evaluator) {
	// super(symbolName, context);
	// fEvaluator = evaluator;
	// }
	/** {@inheritDoc} */
	@Override
	public String definitionToString() throws IOException {
		// dummy call to ensure, that the associated rules are loaded:
		getEvaluator();
		return super.definitionToString();
	}

	/** {@inheritDoc} */
	@Override
	public boolean equals(final Object obj) {
		return this == obj;
	}
	/** {@inheritDoc} */
	@Override
	public IExpr evaluate(EvalEngine engine) {
		// final IEvaluator module = getEvaluator();
		if (fEvaluator instanceof ISymbolEvaluator) {
			if (engine.isNumericMode()) {
				if (engine.isApfloat()) {
					return ((ISymbolEvaluator) fEvaluator).apfloatEval(this, engine);
				} else {
					return ((ISymbolEvaluator) fEvaluator).numericEval(this);
				}
			}
			return ((ISymbolEvaluator) fEvaluator).evaluate(this);
		}
		if (hasLocalVariableStack()) {
			return ExprUtil.ofNullable(get());
		}
		// IExpr result;
		// if ((result = evalDownRule(engine, this)).isPresent()) {
		// return result;
		// }
		return F.NIL;
	}

	/** {@inheritDoc} */
	@Override
	public IExpr evaluateHead(IAST ast, EvalEngine engine) {
		return isConstant() ? F.NIL : super.evaluateHead(ast, engine);
	}

	/** {@inheritDoc} */
	@Override
	public IEvaluator getEvaluator() {
		// use "Double-Checked Locking" idiom
		// https://en.wikipedia.org/wiki/Double-checked_locking
		if (fEvaluator == null) {
			synchronized (this) {
				if (fEvaluator == null) {
					fEvaluator = DUMMY_EVALUATOR;
					// if (Config.PARSER_USE_LOWERCASE_SYMBOLS) {
					// SystemNamespace.DEFAULT.setEvaluator(this);
					// } else {
					// if (Character.isUpperCase(fSymbolName.charAt(0))) {
					// SystemNamespace.DEFAULT.setEvaluator(this);
					// }
					// }
				}
			}
		}
		return fEvaluator;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		return fOrdinal;
	}

	/** {@inheritDoc} */
	@Override
	public int ordinal() {
		return fOrdinal;
	}

	/** {@inheritDoc} */
	@Override
	public boolean isCoreFunctionSymbol() {
		return fEvaluator instanceof ICoreFunctionEvaluator;
	}

	/** {@inheritDoc} */
	@Override
	final public boolean isHoldOrHoldFormOrDefer() {
		return this.equals(F.Defer) || this.equals(F.Hold) || this.equals(F.HoldForm);
	}

	/** {@inheritDoc} */
	@Override
	final public boolean isE() {
		return this == F.E;
	}

	/** {@inheritDoc} */
	@Override
	final public boolean isFalse() {
		return this == F.False;
	}

	/** {@inheritDoc} */
	@Override
	final public boolean isIndeterminate() {
		return this == F.Indeterminate;
	}

	/** {@inheritDoc} */
	@Override
	final public boolean isPi() {
		return this == F.Pi;
	}

	/** {@inheritDoc} */
	@Override
	final public boolean isRealConstant() {
		return fEvaluator instanceof ISignedNumberConstant;
	}

	/** {@inheritDoc} */
	@Override
	final public boolean isTrue() {
		return this == F.True;
	}


	/** {@inheritDoc} */
	@Override
	public IExpr of(EvalEngine engine, IExpr... args) {
		if (fEvaluator instanceof ICoreFunctionEvaluator) {
			// evaluate a core function (without no rule definitions)
			final ICoreFunctionEvaluator coreFunction = (ICoreFunctionEvaluator) getEvaluator();
			IAST ast = F.ast(args, this);
			return coreFunction.evaluate(ast, engine);
		}

		return engine.evaluate(F.ast(args, this));
	}

	/** {@inheritDoc} */
	@Override
	public boolean ofQ(EvalEngine engine, IExpr... args) {
		if (args.length == 1) {
			if (fEvaluator instanceof AbstractCorePredicateEvaluator) {
			// evaluate a core function (without no rule definitions)
			final AbstractCorePredicateEvaluator coreFunction = (AbstractCorePredicateEvaluator) getEvaluator();
			return coreFunction.evalArg1Boole(args[0], engine);
		}
		}
		IAST ast = F.ast(args, this);
		return engine.evalTrue(ast);
	}

	/** {@inheritDoc} */
	@Override
	public IExpr mapConstantDouble(DoubleFunction<IExpr> function) {
		if (fEvaluator instanceof ISignedNumberConstant) {
			double value = ((ISignedNumberConstant) fEvaluator).evalReal();
			if (value < Integer.MAX_VALUE && value > Integer.MIN_VALUE) {
				return function.apply(value);
		}
		}
		return F.NIL;
	}

	/** {@inheritDoc} */
	@Override
	public final void setEvaluator(final IEvaluator evaluator) {
		evaluator.setUp(this);
		fEvaluator = evaluator;
	}
	/** {@inheritDoc} */
	@Override
	public final void setPredicateQ(final Predicate<IExpr> predicate) {
		fEvaluator = new PredicateEvaluator(predicate);
	}
	private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException {
		fOrdinal = stream.readInt();
	}

	public Object readResolve() throws ObjectStreamException {
		return F.symbol(fOrdinal);
	}

	private void writeObject(java.io.ObjectOutputStream stream) throws java.io.IOException {
		stream.writeInt(fOrdinal);
	}
}