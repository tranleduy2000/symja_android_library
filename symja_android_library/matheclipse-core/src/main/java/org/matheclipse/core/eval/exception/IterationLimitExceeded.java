package org.matheclipse.core.eval.exception;

import org.matheclipse.core.interfaces.IExpr;

/**
 * Exception which will be thrown, if the iteration limit of the evaluation loop
 * was exceeded.
 */
public class IterationLimitExceeded extends LimitException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5953619629034039117L;

	/**
	 * 
	 */
	long fLimit;


	public IterationLimitExceeded(final long limit) {
		fLimit = limit;
	}

	@Override
	public String getMessage() {
		return "Iteration limit of " + fLimit + " exceeded.";
	}

	public static void throwIt(long iterationCounter, final IExpr expr) {
		// HeapContext.enter();
		// try {
		throw new IterationLimitExceeded(iterationCounter);// expr.copy());
		// } finally {
		// HeapContext.exit();
		// }
	}
}
