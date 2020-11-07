package org.matheclipse.core.expression;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.core.patternmatching.IPatternMap;
import org.matheclipse.core.patternmatching.IPatternMatcher;

public class RepeatedPattern extends PatternSequence {

	private static final long serialVersionUID = 1086461999754718513L;

	public static RepeatedPattern valueOf(IExpr patternExpr, EvalEngine engine) {
		return valueOf(patternExpr, false, engine);
	}

	public static RepeatedPattern valueOf(IExpr patternExpr, boolean zeroArgsAllowed, EvalEngine engine) {
		RepeatedPattern p = new RepeatedPattern();
		p.fSymbol = null;
		p.fCondition = null;
		p.fDefault = false;
		p.fZeroArgsAllowed = zeroArgsAllowed;
		p.fRepeatedExpr = patternExpr;
		p.fMatcher = engine.evalPatternMatcher(patternExpr);
		return p;
	}

	protected IExpr fRepeatedExpr;

	protected IPatternMatcher fMatcher;
	//
	// public static RepeatedPattern valueOf(IExpr patternExpr, EvalEngine engine) {
	// return valueOf(null, patternExpr, engine);
	// }

	protected RepeatedPattern() {
		super();
	}

	/**
	 * Compares this expression with the specified expression for order. Returns a negative integer, zero, or a positive
	 * integer as this expression is canonical less than, equal to, or greater than the specified expression.
	 */
	@Override
	public int compareTo(final IExpr expr) {
		if (expr instanceof RepeatedPattern) {
			int cp = fRepeatedExpr.compareTo(((RepeatedPattern) expr).fRepeatedExpr);
			if (cp != 0) {
				return cp;
			}
		}
		return super.compareTo(expr);
	}

	@Override
	public IExpr copy() {
		try {
			return (IExpr) clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof RepeatedPattern) {
			RepeatedPattern pattern = (RepeatedPattern) obj;
			if (fSymbol == null) {
				if (pattern.fSymbol == null) {
					if (fDefault == pattern.fDefault && fZeroArgsAllowed == pattern.fZeroArgsAllowed) {
						return fRepeatedExpr.equals(pattern.fRepeatedExpr);
					}
				}
				return false;
			}
			if (fSymbol.equals(pattern.fSymbol) && fDefault == pattern.fDefault
					&& fZeroArgsAllowed == pattern.fZeroArgsAllowed) {
				return fRepeatedExpr.equals(pattern.fRepeatedExpr);
			}
		}
		return false;
	}

	@Override
	public String fullFormString() {
		StringBuilder buf = new StringBuilder();
		if (fZeroArgsAllowed) {
			buf.append("RepeatedNull[");
		} else {
			buf.append("Repeated[");
		}
		buf.append(fRepeatedExpr.fullFormString());
		buf.append(']');
		return buf.toString();
	}

	public IExpr getRepeatedExpr() {
		return fRepeatedExpr;
	}

	@Override
	public int hashCode() {
		return (fSymbol == null) ? 213 : 37 + fSymbol.hashCode();
	}

	@Override
	public boolean isRepeated() {
		return true;
	}

	@Override
	public boolean matchPatternSequence(final IAST sequence, IPatternMap patternMap, ISymbol optionsPatternHead) {
		if (sequence.size() == 1 && !isNullSequence()) {
			return false;
		}
		EvalEngine engine = EvalEngine.get();
		for (int i = 1; i < sequence.size(); i++) {
			if (!fMatcher.testBlank(sequence.get(i), engine)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder buffer = new StringBuilder();
		buffer.append(fRepeatedExpr.toString());
		if (fZeroArgsAllowed) {
			buffer.append("...");
		} else {
			buffer.append("..");
		}
		return buffer.toString();
	}
}
