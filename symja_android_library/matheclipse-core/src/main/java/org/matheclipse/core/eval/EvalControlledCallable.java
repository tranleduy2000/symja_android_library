package org.matheclipse.core.eval;

import com.duy.concurrent.Callable;

import org.matheclipse.core.eval.exception.Validate;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.parser.client.SyntaxError;
import org.matheclipse.parser.client.math.MathException;

import java.io.StringWriter;

public class EvalControlledCallable implements Callable<IExpr> {
	protected final EvalEngine fEngine;
	private IExpr fExpr;
	public EvalControlledCallable(EvalEngine engine) {
		fEngine = engine;
	}

	public void setExpr(IExpr fExpr) {
		this.fExpr = fExpr;
	}

	@Override
	public IExpr call() throws Exception {
		EvalEngine.remove();
		EvalEngine.set(fEngine);
		final StringWriter buf = new StringWriter();
		try {
			fEngine.reset();
			IExpr temp = fEngine.evaluate(fExpr);
			if (!fEngine.isOutListDisabled()) {
				fEngine.addOut(temp);
			}
			return temp;
		} catch (org.matheclipse.core.eval.exception.TimeoutException e) {
			return F.$Aborted;
		} catch (final SyntaxError se) {
			String msg = se.getMessage();
			System.err.println(msg);
			System.err.println();
			System.err.flush();
		} catch (final RuntimeException re) {
			Throwable me = re.getCause();
			if (me instanceof MathException) {
				Validate.printException(buf, me);
			} else {
				Validate.printException(buf, re);
			}
			System.err.println(buf.toString());
			System.err.flush();
		} catch (final Exception e) {
			Validate.printException(buf, e);
			System.err.println(buf.toString());
			System.err.flush();
		} catch (final OutOfMemoryError e) {
			Validate.printException(buf, e);
			System.err.println(buf.toString());
			System.err.flush();
		} catch (final StackOverflowError e) {
			Validate.printException(buf, e);
			System.err.println(buf.toString());
			System.err.flush();
		}
		return F.$Aborted;
	}

	public void cancel() {
		fEngine.setStopRequested(true);
	}
}