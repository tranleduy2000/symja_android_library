package ch.ethz.idsc.tensor.qty;

import com.duy.util.DObjects;

import org.matheclipse.core.interfaces.IExpr;


/**
 * auxiliary functions and operators for {@link IUnit}
 */
public enum Units {
    ;

    /**
     * @param scalar
     * @return unit of scalar
     */
    public static IUnit of(IExpr scalar) {
        if (scalar instanceof IQuantity) {
            IQuantity quantity = (IQuantity) scalar;
            return quantity.unit();
        }
        if (DObjects.isNull(scalar))
            throw new IllegalArgumentException(); // scalar == null
        return IUnit.ONE;
    }

    /**
     * @param unit
     * @return true if given unit is dimension-less
     */
    public static boolean isOne(IUnit unit) {
        return IUnit.ONE.equals(unit);
    }
}
