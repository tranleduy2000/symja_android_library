package org.matheclipse.core.eval.exception;

/**
 * Exception which will be thrown, if the Config.MAX_AST_SIZE limit was exceeded.
 */
public class ASTElementLimitExceeded extends LimitException {

	long fLimit;

	public ASTElementLimitExceeded(final long limit) {
		fLimit = limit;
	}

	@Override
	public String getMessage() {
		return "Maximum AST size " + fLimit + " exceeded" ;
	}

	public static void throwIt(final int limit ) {
		// HeapContext.enter();
		// try {
		throw new ASTElementLimitExceeded(limit);// .copy());
		// } finally {
		// HeapContext.exit();
		// }
	}

}
