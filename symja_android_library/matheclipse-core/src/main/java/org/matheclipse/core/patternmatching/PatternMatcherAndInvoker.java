package org.matheclipse.core.patternmatching;

import org.matheclipse.core.basic.Config;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.interfaces.IFunctionEvaluator;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IExpr;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

public class PatternMatcherAndInvoker extends PatternMatcher {
	/**
	* 
	*/
	private static final long serialVersionUID = -2448717771259975643L;

	private transient Method fMethod;
	private transient Type[] fTypes;
	private transient IFunctionEvaluator fInstance;

	@Override
	public Object clone() throws CloneNotSupportedException {
		PatternMatcherAndInvoker v = (PatternMatcherAndInvoker) super.clone();
		v.fMethod = fMethod;
		v.fTypes = fTypes;
		v.fInstance = fInstance;
		return v;
	}

	/** {@inheritDoc} */
	@Override
	public IExpr eval(final IExpr leftHandSide, EvalEngine engine) {

		if (isRuleWithoutPatterns() && fLhsPatternExpr.equals(leftHandSide)) {
			if (fTypes.length != 0) {
				return F.NIL;
			}
			IExpr result = F.NIL;
			try {
				result = (IExpr) fMethod.invoke(fInstance);
			} catch (IllegalArgumentException e) {
				if (Config.SHOW_STACKTRACE) {
					e.printStackTrace();
				}
			} catch (IllegalAccessException e) {
				if (Config.SHOW_STACKTRACE) {
					e.printStackTrace();
				}
			} catch (InvocationTargetException e) {
				if (Config.SHOW_STACKTRACE) {
					e.printStackTrace();
				}
			}
			return result != null ? result : F.NIL;
		}
		PatternMap patternMap=getPatternMap();
		if (fTypes.length != patternMap.size()) {
			return F.NIL;
		}
		patternMap.initPattern();
		if (matchExpr(fLhsPatternExpr, leftHandSide, engine)) {

			List<IExpr> args = patternMap.getValuesAsList();
			try {
				if (args != null) {
					IExpr result = (IExpr) fMethod.invoke(fInstance, args.toArray());
					return result != null ? result : F.NIL;
				}
			} catch (IllegalArgumentException e) {
				if (Config.SHOW_STACKTRACE) {
					e.printStackTrace();
				}
			} catch (IllegalAccessException e) {
				if (Config.SHOW_STACKTRACE) {
					e.printStackTrace();
				}
			} catch (InvocationTargetException e) {
				if (Config.SHOW_STACKTRACE) {
					e.printStackTrace();
				}
			}
		}
		return F.NIL;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof PatternMatcherAndInvoker) {
			// don't compare fInstance, fMethod, fTypes here
			return super.equals(obj);
		}

		return false;
	}

	@Override
	public int hashCode() {
		return super.hashCode() * 47;
	}
}