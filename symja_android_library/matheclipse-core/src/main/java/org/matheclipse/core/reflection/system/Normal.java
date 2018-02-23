package org.matheclipse.core.reflection.system;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.exception.Validate;
import org.matheclipse.core.eval.interfaces.AbstractFunctionEvaluator;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IASTAppendable;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.IInteger;
import org.matheclipse.core.interfaces.INumber;

import com.duy.lambda.ObjIntConsumer;

/**
 * Power series expansion
 */
public class Normal extends AbstractFunctionEvaluator {
	public Normal() {
	}

	@Override
	public IExpr evaluate(final IAST ast, EvalEngine engine) {
		Validate.checkSize(ast, 2);

		IExpr arg1 = ast.arg1();
		if (arg1.isAST()) {
			IAST seriesData = (IAST) arg1;
			if (seriesData.isAST(F.SeriesData) && (seriesData.size() == 7)) {
				if (seriesData.arg3().isList()) {
					try {
						final IExpr x = seriesData.arg1();
						final IExpr x0 = seriesData.arg2();
						final IAST list = (IAST) seriesData.arg3();
						final long nmin = ((IInteger) seriesData.arg4()).toLong();
						final long nmax = ((IInteger) seriesData.arg5()).toLong();
						final long den = ((IInteger) seriesData.get(6)).toLong();
						int size = list.size();

						final IASTAppendable result = F.PlusAlloc(size);
						list.forEach(new ObjIntConsumer<IExpr>() {
                            @Override
                            public void accept(IExpr expr, int i) {
                                INumber exp = F.fraction(nmin + i - 1L, den).normalize();
                                IExpr pow = x.subtract(x0).power(exp);
                                result.append(F.Times(expr, pow));
                            }
                        });
						return result;
					} catch (ArithmeticException ex) {
					}
				}
			}
		}
		return F.NIL;
	}

}
