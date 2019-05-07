package org.matheclipse.core.eval;

import com.duy.lambda.Supplier;

import org.matheclipse.core.builtin.Arithmetic;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IExpr;

public class PowerOp {
	/**
	 * Evaluate <code>base ^ exponent</code>.
	 * @param base
	 * @param exponent
	 * @return
	 */
	public static IExpr power(final IExpr base, final IExpr exponent) {
		return Arithmetic.CONST_POWER.binaryOperator(F.NIL, base, exponent).orElseGet(new Supplier<IExpr>() {
			@Override
			public IExpr get() {
				return F.Power(base, exponent);
			}
		});
	}
}
