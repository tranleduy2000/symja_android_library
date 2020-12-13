package org.matheclipse.core.tensor.qty;

import com.duy.lambda.BiFunction;
import com.duy.util.DStringJoiner;
import com.duy.util.MapWrapper;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.ISignedNumber;
import org.matheclipse.parser.client.math.MathException;

/* package */ class UnitImpl implements IUnit, Serializable {

  private final Map<String, IExpr> navigableMap;

  UnitImpl(Map<String, IExpr> navigableMap) {
    this.navigableMap = Collections.unmodifiableMap(navigableMap);
  }

  @Override // from Unit
  public IUnit negate() {
    //
    TreeMap<String, IExpr> map = new TreeMap<>();
    for (Entry<String, IExpr> entry : navigableMap.entrySet()) {
      MapWrapper.merge(map, entry.getKey(), entry.getValue().negate(),
          new BiFunction<IExpr, IExpr, IExpr>() {
            @Override
            public IExpr apply(IExpr e1, IExpr e2) {
              return null;
            }
          });
    }
    return new UnitImpl(map);
  }

  @Override // from Unit
  public IUnit add(IUnit unit) {
    Map<String, IExpr> map = new TreeMap<>(navigableMap);
    for (Entry<String, IExpr> entry : unit.map().entrySet()) {
      String key = entry.getKey();
      IExpr value = entry.getValue();
        if (map.containsKey(key)) {
            // TODO this may not always use the defined UnitHelper.EvalEngine
            IExpr sum = F.Plus.of(UnitHelper.ENGINE, map.get(key), value);
            if (sum.isZero()) {
                map.remove(key); // exponents cancel out
            } else {
                map.put(key, sum); // exponent is updated
            }
        } else {
            map.put(key, value); // unit is introduced
        }
    }
    return new UnitImpl(map);
  }

  @Override // from Unit
  public IUnit multiply(IExpr factor) {
    if (factor instanceof ISignedNumber) {
      Map<String, IExpr> map = new TreeMap<>();
      for (Entry<String, IExpr> entry : navigableMap.entrySet()) {
        // TODO this may not always use the defined UnitHelper.EvalEngine
        IExpr value = F.Times.of(UnitHelper.ENGINE, entry.getValue(), factor);
          if (!value.isZero()) { map.put(entry.getKey(), value); }
      }
      return new UnitImpl(map);
    }
    return null;
  }

  @Override // from Unit
  public Map<String, IExpr> map() {
    return navigableMap;
  }

  /** ************************************************ */
  @Override // from Object
  public int hashCode() {
    return navigableMap.hashCode();
  }

  @Override // from Object
  public boolean equals(Object object) {
    return object instanceof IUnit && navigableMap.equals(((IUnit) object).map());
  }

  private static String exponentString(IExpr exponent) {
    String string = exponent.toString();
    return string.equals("1") ? "" : IUnit.POWER_DELIMITER + string;
  }

  @Override // from Object
  public String toString() {
    //
    //
    DStringJoiner joiner = new DStringJoiner(IUnit.JOIN_DELIMITER);
    for (Entry<String, IExpr> entry : navigableMap.entrySet()) {
      String s = entry.getKey() + exponentString(entry.getValue());
      joiner.add(s);
    }
    return joiner.toString();
  }

  @Override
  public int compareTo(IUnit o) {
    Map<String, IExpr> map = o.map();
    if (navigableMap.size() == map.size()) {
      return toString().compareTo(o.toString());
    }
    return navigableMap.size() > map.size() ? 1 : -1;
  }
}
