package ch.ethz.idsc.tensor.qty;

import com.duy.util.DObjects;

import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.IStringX;
import org.matheclipse.parser.client.math.MathException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Properties;

/** reference implementation of {@link UnitSystem} with emphasis on simplicity */
public class SimpleUnitSystem implements UnitSystem {

    /**
     * given properties map a unit expression to a {@link IQuantity}
	 *
     * <p>
     * Example from the built-in file "/unit/si.properties":
	 *
     * <pre>
     * rad=1
     * Hz=1[s^-1]
     * N=1[m*kg*s^-2]
     * Pa=1[m^-1*kg*s^-2]
     * ...
     * </pre>
     *
     * @param properties
     * @return
	 * @throws Exception
	 *             if keys do not define unit conversions
     */
    public static UnitSystem from(Properties properties) {
		//
		Map<String, IExpr> result = new HashMap<>();
		for (String key : properties.stringPropertyNames()) {
			if (result.put(UnitHelper.requireValid(key), requireNumeric(F.fromString(properties.getProperty(key)))) != null) {
				throw new IllegalStateException("Duplicate key");
			}
		}
		return new SimpleUnitSystem(result);
    }

    /**
     * @param map
     * @return unit system
     */
    public static UnitSystem from(Map<String, IExpr> map) {
		//
		Map<String, IExpr> result = new HashMap<>();
		for (Entry<String, IExpr> entry : map.entrySet()) {
			if (result.put(UnitHelper.requireValid(entry.getKey()), requireNumeric(entry.getValue())) != null) {
				throw new IllegalStateException("Duplicate key");
			}
		}
		return new SimpleUnitSystem(result);
    }

	// ---
	private final Map<String, IExpr> map;

	private SimpleUnitSystem(Map<String, IExpr> map) {
		this.map = map;
    }

    @Override
    public IExpr apply(IExpr scalar) {
        if (scalar instanceof IQuantity) {
            final IQuantity quantity = (IQuantity) scalar;
            IExpr value = quantity.value();
            for (Entry<String, IExpr> entry : quantity.unit().map().entrySet()) {
                IExpr lookup = map.get(entry.getKey());
				IExpr entryValue = entry.getValue();
				// if (entryValue.isOne()) {
				// value = Objects.isNull(lookup) //
				// ? IQuantity.of(F.C1, format(entry)) //
				// :lookup;
				// } else {
				IExpr temp = DObjects.isNull(lookup) //
                        ? IQuantity.of(F.C1, format(entry)) //
						: lookup.isQuantity()//
								? ((IQuantity) lookup).power(entryValue)//
								: F.Power.of(lookup, entryValue);
				if (temp.isQuantity()) {
					value = temp.multiply(value);
				} else {
					value = value.multiply(temp);
				}
				// }
            }
            return value;
        }
        return Objects.requireNonNull(scalar);
    }

    @Override // from UnitSystem
    public Map<String, IExpr> map() {
        return Collections.unmodifiableMap(map);
    }
	// helper function
	private static IExpr requireNumeric(IExpr scalar) {
		if (scalar instanceof IStringX)
			throw MathException.of(scalar);
		if (scalar instanceof IQuantity) {
			IQuantity quantity = (IQuantity) scalar;
			if (quantity.value() instanceof IStringX)
				throw MathException.of(scalar);
		}
		return scalar;
	}

	// helper function
	private static String format(Entry<String, IExpr> entry) {
		return entry.getKey() + IUnit.POWER_DELIMITER + entry.getValue();
	}
}
