package org.matheclipse.core.tensor.qty;

import com.duy.lambda.UnaryOperator;
import com.duy.util.DObjects;

import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IExpr;

import java.util.Properties;

public class QuantityMagnitude {
    private static final QuantityMagnitude EMPTY = new QuantityMagnitude(SimpleUnitSystem.from(new Properties()));

	/** @return instance of QuantityMagnitude that uses the built-in SI convention */
    public static QuantityMagnitude SI() {
        return BuiltIn.SI.quantityMagnitude;
    }

    /**
     * @param unit
     * @return operator that extracts the value from a Quantity of given unit
     */
	private static UnaryOperator<IExpr> singleton(IUnit unit) {
        return EMPTY.in(unit);
    }

    /**
     * @param string
     * @return operator that extracts the value from a Quantity of unit specified by given string
     */
	private static UnaryOperator<IExpr> singleton(String string) {
		return singleton(IUnitStatic.ofPutIfAbsent(string));
	}

	// ---
	private final UnitSystem unitSystem;

	/**
	 * creates instance for quantity conversion and magnitude extraction that is backed by given unitSystem
	 *
	 * @param unitSystem
	 * @throws Exception
	 *             if given {@link UnitSystem} is null
	 */
	public QuantityMagnitude(UnitSystem unitSystem) {
		this.unitSystem = DObjects.requireNonNull(unitSystem);
    }

    /**
     * Example:
     * <p>
     * <pre>
     * QuantityMagnitude.SI().in(Unit.of("K*m^2")).apply(Quantity.of(2, "K*km^2")) == RealScalar.of(2_000_000)
     *
     * <pre>
     *
     * @param unit
     * @return operator that maps a quantity to the equivalent scalar of given unit
     */
    public UnaryOperator<IExpr> in(IUnit unit) {
        final IExpr base = unitSystem.apply(IQuantityStatic.of(F.C1, unit));

        return new UnaryOperator<IExpr>() {
            @Override
            public IExpr apply(IExpr scalar) {
                IExpr result = unitSystem.apply(scalar).divide(base);
                if (result instanceof IQuantity) {
                    return ((IQuantity) result).value();
                    // throw MathException.of(result);
                }
                return result;
            }
        };
    }
}
