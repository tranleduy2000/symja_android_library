package org.matheclipse.core.interfaces;

import org.matheclipse.core.expression.F;



public class ExprUtil {
	/**
     * Returns an {@code IExpr} describing the specified value, if non-null, otherwise returns {@code F.NIL} .
     *
	 * @param value
	 *            the possibly-null value to describe
     * @return an {@code IExpr} with a present value if the specified value is non-null, otherwise an empty
     * {@code Optional}
     */
    public static IExpr ofNullable( IExpr value) {
        return value == null ? F.NIL : value;
    }
    
    public static IExpr convertToExpr(IExpr_COMPARE_TERNARY temp) {
		if (temp== IExpr_COMPARE_TERNARY.TRUE) {
			return F.True;
		}
		if (temp== IExpr_COMPARE_TERNARY.FALSE) {
			return F.False;
		}
		return F.NIL;
	}
}
