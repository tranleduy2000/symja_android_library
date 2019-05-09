package org.matheclipse.core.eval;

import java.util.concurrent.Callable;

import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IExpr;


class EvalCallable implements Callable<IExpr> {
	protected final EvalEngine fEngine;
	private IExpr fExpr;

	public EvalCallable(EvalEngine engine) {
		this(F.Null, engine);
	}

	public EvalCallable(IExpr expr, EvalEngine engine) {
		fExpr = expr;
		fEngine = engine;
	}

	/**
	 * Basic call which catches no exceptions
	 */
	@Override
	public IExpr call() throws Exception {
		EvalEngine.remove();
		EvalEngine.set(fEngine);
		try {
		fEngine.reset();
		IExpr temp = fEngine.evaluate(fExpr);
		if (!fEngine.isOutListDisabled()) {
			fEngine.addOut(temp);
		}
		return temp;
		} catch (org.matheclipse.core.eval.exception.TimeoutException e) {
			return F.$Aborted;
//		} catch (RuntimeException rex) {
//			rex.printStackTrace();
//			return F.$Aborted;
		} finally {
			EvalEngine.remove();
		}
	}

	public IExpr getExpr() {
		return fExpr;
	}

	public void setExpr(IExpr fExpr) {
		this.fExpr = fExpr;
	}

}