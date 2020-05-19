package org.matheclipse.core.eval.exception;

/**
 * Exception which will be thrown, if the Config.MAX_AST_SIZE limit was exceeded.
 */
public class ASTElementLimitExceeded extends LimitException {

	long fLimit;

	public ASTElementLimitExceeded(final long limit) {
		fLimit = limit;
	}

	/**
	 * Set the exceeded limit to <code>(long)rowDimension*(long)columnDimension</code>.
	 *
	 * @param rowDimension
	 * @param columnDimension
	 */
	public ASTElementLimitExceeded(final int rowDimension, final int columnDimension) {
		fLimit = (long)rowDimension*(long)columnDimension;
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
