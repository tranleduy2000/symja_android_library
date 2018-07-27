package org.matheclipse.parser.client.math;

import org.matheclipse.core.basic.Config;

public class MathException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3520033778672500363L;

	public MathException() {
		super();
	}

	public MathException(String message) {
		super(message);
	}

	public MathException(String message, Throwable cause) {
		super(message, cause);
	}

	public MathException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * @param tensors
	 * @return exception with message consisting of truncated string expressions of given tensors
	 * @throws Exception
	 *             if any of the listed tensors is null
	 */
	public static MathException of(IExpr... exprs) {
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < exprs.length; i++) {
			buf.append(exprs[i].toString());
			if (i < exprs.length - 1) {
				buf.append(", ");
			}
		}
		return new MathException(buf.toString());
	}
	@Override
	public synchronized Throwable fillInStackTrace() {
		if (Config.SHOW_STACKTRACE) {
			return super.fillInStackTrace();
		} else {
			return this;
		}
	}
}