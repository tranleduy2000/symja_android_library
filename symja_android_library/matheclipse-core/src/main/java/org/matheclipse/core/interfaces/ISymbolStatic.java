package org.matheclipse.core.interfaces;

import static org.matheclipse.core.interfaces.ISymbol.FLAT;
import static org.matheclipse.core.interfaces.ISymbol.FLATORDERLESS;
import static org.matheclipse.core.interfaces.ISymbol.HOLDALLCOMPLETE;
import static org.matheclipse.core.interfaces.ISymbol.ORDERLESS;

public class ISymbolStatic {

  /**
   * Does the attributes flag set contains the {@link ISymbol#FLAT} bit set?
   *
   * @return <code>true</code> if this attribute set contains the <code>ISymbol.Flat</code>
   * attribute.
   */
  public static boolean hasFlatAttribute(int attributes) {
    return (attributes & FLAT) == FLAT;
  }

  /**
   * Does the attributes flag set contains the {@link ISymbol#HOLDALLCOMPLETE} bit set?
   *
   * @param attributes
   * @return
   */
  public static boolean hasHoldAllCompleteAttribute(int attributes) {
    return (attributes & HOLDALLCOMPLETE) == HOLDALLCOMPLETE;
  }

  /**
   * Does this symbols attribute set contains the <code>Orderless</code> attribute?
   *
   * @return <code>true</code> if this symbols attribute set contains the <code>Orderless</code>
   * attribute.
   */
  public static boolean hasOrderlessAttribute(int attributes) {
    return (attributes & ORDERLESS) == ORDERLESS;
  }

  /**
   * Does the attributes flag set contains the <code>ISymbol.Flat</code> and <code>ISymbol.Orderless
   * </code> bits set?
   *
   * @return <code>true</code> if this attribute set contains the <code>ISymbol.Flat</code> and
   * <code>ISymbol.Orderless</code> attribute.
   */
  public static boolean hasOrderlessFlatAttribute(int attributes) {
    return (attributes & FLATORDERLESS) == FLATORDERLESS;
  }

}
