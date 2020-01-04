package org.matheclipse.core.reflection.system.rules;

import static org.matheclipse.core.expression.F.*;
import org.matheclipse.core.interfaces.IAST;

/**
 * <p>Generated by <code>org.matheclipse.core.preprocessor.RulePreprocessor</code>.</p>
 * <p>See GIT repository at: <a href="https://github.com/axkr/symja_android_library">github.com/axkr/symja_android_library under the tools directory</a>.</p>
 */
public interface BesselYRules {
  /**
   * <ul>
   * <li>index 0 - number of equal rules in <code>RULES</code></li>
	 * </ul>
	 */
  final public static int[] SIZES = { 0, 6 };

  final public static IAST RULES = List(
    IInit(BesselY, SIZES),
    // BesselY(-1/2,z_):=(Sqrt(2/Pi)*Sin(z))/Sqrt(z)
    ISetDelayed(BesselY(CN1D2,z_),
      Times(Sqrt(Times(C2,Power(Pi,CN1))),Power(z,CN1D2),Sin(z))),
    // BesselY(1/2,z_):=(-Sqrt(2/Pi)*Cos(z))/Sqrt(z)
    ISetDelayed(BesselY(C1D2,z_),
      Times(CN1,Sqrt(Times(C2,Power(Pi,CN1))),Power(z,CN1D2),Cos(z))),
    // BesselY(-3/2,z_):=(Sqrt(2/Pi)*(Cos(z)-Sin(z)/z))/Sqrt(z)
    ISetDelayed(BesselY(QQ(-3L,2L),z_),
      Times(Sqrt(Times(C2,Power(Pi,CN1))),Power(z,CN1D2),Plus(Cos(z),Times(CN1,Power(z,CN1),Sin(z))))),
    // BesselY(3/2,z_):=(Sqrt(2/Pi)*(-Cos(z)/z-Sin(z)))/Sqrt(z)
    ISetDelayed(BesselY(QQ(3L,2L),z_),
      Times(Sqrt(Times(C2,Power(Pi,CN1))),Power(z,CN1D2),Subtract(Times(CN1,Power(z,CN1),Cos(z)),Sin(z)))),
    // BesselY(-5/2,z_):=(Sqrt(2/Pi)*(((-1)*3*Cos(z))/z-Sin(z)+(3*Sin(z))/z^2))/Sqrt(z)
    ISetDelayed(BesselY(QQ(-5L,2L),z_),
      Times(Sqrt(Times(C2,Power(Pi,CN1))),Power(z,CN1D2),Plus(Times(CN1,C3,Power(z,CN1),Cos(z)),Negate(Sin(z)),Times(C3,Power(z,CN2),Sin(z))))),
    // BesselY(5/2,z_):=(Sqrt(2/Pi)*(Cos(z)+(-3*Cos(z))/z^2+(-3*Sin(z))/z))/Sqrt(z)
    ISetDelayed(BesselY(QQ(5L,2L),z_),
      Times(Sqrt(Times(C2,Power(Pi,CN1))),Power(z,CN1D2),Plus(Cos(z),Times(CN3,Power(z,CN2),Cos(z)),Times(CN3,Power(z,CN1),Sin(z)))))
  );
}
