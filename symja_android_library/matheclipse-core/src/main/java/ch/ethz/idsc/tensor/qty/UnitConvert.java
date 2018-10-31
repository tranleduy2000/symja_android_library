package ch.ethz.idsc.tensor.qty;

import com.duy.lambda.UnaryOperator;

import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IExpr;

import java.util.Objects;

public class UnitConvert {
  /** @return instance of UnitConvert that uses the built-in SI convention */
  public static UnitConvert SI() {
    return BuiltIn.SI.unitConvert;
  }
  // ---
    private final UnitSystem unitSystem;

  /** @param unitSystem
   * @throws Exception if given {@link UnitSystem} is null */
    public UnitConvert(UnitSystem unitSystem) {
        this.unitSystem = Objects.requireNonNull(unitSystem);
    }

  /** Example:
     * <code>
     * UnitConvert.SI().to(Unit.of("N")).apply(Quantity.of(981, "cm*kg*s^-2"))
     * == Quantity.fromString("981/100[N]")
     * </code>
     *
     * @param unit
   * @return operator that maps a quantity to the quantity of given unit */
    public UnaryOperator<IExpr> to(final IUnit unit) {
        final IExpr base = unitSystem.apply(IQuantityStatic.of(F.C1, unit));
        return new UnaryOperator<IExpr>() {
            @Override
            public IExpr apply(IExpr scalar) {
                return IQuantityStatic.of(unitSystem.apply(scalar).divide(base), unit);
            }
        };
    }
}
