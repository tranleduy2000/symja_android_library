package org.matheclipse.core.tensor.qty;

public class IUnitStatic {

  /**
   * @param string for instance "m*s^-2"
   * @return <code>null</code> if unit couldn't be found
   */
  public static IUnit of(String string) {
    return UnitHelper.MEMO.lookup(string);
  }

  /**
   * @param string for instance "m*s^-2"
   * @return if unit couldn't be found, add string as new unit
   */
  public static IUnit ofPutIfAbsent(String string) {
    return UnitHelper.MEMO.lookupAndPutIfAbsent(string);
  }
}
