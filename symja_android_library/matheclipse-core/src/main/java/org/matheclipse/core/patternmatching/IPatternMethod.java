package org.matheclipse.core.patternmatching;

import org.matheclipse.core.interfaces.IExpr;

public interface IPatternMethod {
	public abstract IExpr eval(IPatternMap pm);
}
