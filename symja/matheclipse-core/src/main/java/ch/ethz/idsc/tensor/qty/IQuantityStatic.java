package ch.ethz.idsc.tensor.qty;

import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.parser.client.math.MathException;

public class IQuantityStatic {

    /**
     * Hint: function does not check parameters for null, although null as input is likely to cause problems
     * subsequently.
     *
     * @param value
     * @param unit  for instance Unit.of("m*s^-1")
     * @return
     * @throws Exception if value is instance of {@code Quantity}
     */
    public static IExpr of(IExpr value, IUnit unit) {
        if (value instanceof IQuantity) {
            throw MathException.of(value);
        }
        return QuantityImpl.of(value, unit);
    }

    /**
     * Hint: function does not check parameters for null, although null as input is likely to cause problems
     * subsequently.
     *
     * @param value
     * @param string for instance "m*s^-2"
     * @return
     * @throws Exception if value is instance of {@code Quantity}
     */
    public static IExpr of(IExpr value, String string) {
        if (value instanceof IQuantity)
            throw MathException.of(value);
        return QuantityImpl.of(value, IUnitStatic.of(string));
    }

    /**
     * creates quantity with number encoded as {@link ISignedNumber}
     * <p>
     * Hint: function does not check parameters for null, although null as input is likely to cause problems
     * subsequently.
     *
     * @param number non-null
     * @param unit
     * @return
     * @throws Exception if parameter number equals null
     */
    public static IExpr of(Number number, IUnit unit) {
        return QuantityImpl.of(F.expr(number), unit);
    }

    /**
     * creates quantity with number encoded as {@link ISignedNumber}
     *
     * @param number
     * @param string for instance "kg^3*m*s^-2"
     * @return
     * @throws Exception if either parameter equals null
     */
    public static IExpr of(Number number, String string) {
        return QuantityImpl.of(F.expr(number), IUnitStatic.of(string));
    }

}
