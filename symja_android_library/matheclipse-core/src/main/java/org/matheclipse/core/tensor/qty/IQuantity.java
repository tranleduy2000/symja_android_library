package org.matheclipse.core.tensor.qty;

import org.matheclipse.core.interfaces.IExpr;

/**
 * {@link IQuantity} represents a magnitude and unit.
 *
 * <p>
 * The sum of two quantities is well defined whenever the units are identical. Two quantities with different units are
 * added if one of the values equals to zero. In that case the result carries the unit of the non-zero input quantity.
 *
 * <p>
 * For export and import of tensors with scalars of type {@link IQuantity} use {@link ObjectFormat} and
 * {@link CsvFormat}.
 *
 * <p>
 * Two quantities are comparable only if they have the same unit. Otherwise an exception is thrown.
 *
 * <p>
 * Different units should mapped to a common unit system before carrying out operations.
 *
 * <pre>
 * Scalar a = Quantity.of(200, "g");
 * Scalar b = Quantity.of(1, "kg");
 * Total.of(Tensors.of(a, b).map(UnitSystem.SI())) == 6/5[kg]
 * </pre>
 * <p>
 * whereas <code>a.add(b)</code> throws an Exception.
 */
@SuppressWarnings("JavadocReference")
public interface IQuantity extends IExpr, Comparable<IExpr> {
    char UNIT_OPENING_BRACKET = '[';
    char UNIT_CLOSING_BRACKET = ']';

    IQuantity ofUnit(IExpr scalar);

    /**
     * @return unit of quantity without value
     */
    IUnit unit();

	String unitString();
    /**
	 *
     * @return value of quantity without unit
     */
    IExpr value();
}
