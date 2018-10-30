package org.matheclipse.core.reflection.system.rules;

import org.matheclipse.core.interfaces.IAST;

import static org.matheclipse.core.expression.F.ArcCosh;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C1DSqrt2;
import static org.matheclipse.core.expression.F.CC;
import static org.matheclipse.core.expression.F.CComplexInfinity;
import static org.matheclipse.core.expression.F.CI;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CSqrt2;
import static org.matheclipse.core.expression.F.CSqrt3;
import static org.matheclipse.core.expression.F.DirectedInfinity;
import static org.matheclipse.core.expression.F.IInit;
import static org.matheclipse.core.expression.F.ISet;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Pi;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.oo;

/**
 * <p>Generated by <code>org.matheclipse.core.preprocessor.RulePreprocessor</code>.</p>
 * <p>See GIT repository at: <a href="https://github.com/axkr/symja_android_library">github.com/axkr/symja_android_library under the tools directory</a>.</p>
 */
public interface ArcCoshRules {
  /**
   * <ul>
   * <li>index 0 - number of equal rules in <code>RULES</code></li>
	 * </ul>
	 */
  final public static int[] SIZES = { 13, 0 };

  final public static IAST RULES = List(
    IInit(ArcCosh, SIZES),
    // ArcCosh(0)=I*Pi/2
    ISet(ArcCosh(C0),
      Times(CC(0L,1L,1L,2L),Pi)),
    // ArcCosh(1/2)=I*Pi/3
    ISet(ArcCosh(C1D2),
      Times(CC(0L,1L,1L,3L),Pi)),
    // ArcCosh(-1/2)=2/3*I*Pi
    ISet(ArcCosh(CN1D2),
      Times(CC(0L,1L,2L,3L),Pi)),
    // ArcCosh(Sqrt(2)/2)=1/4*I*Pi
    ISet(ArcCosh(C1DSqrt2),
      Times(CC(0L,1L,1L,4L),Pi)),
    // ArcCosh((-1)*1/2*Sqrt(2))=3/4*I*Pi
    ISet(ArcCosh(Negate(C1DSqrt2)),
      Times(CC(0L,1L,3L,4L),Pi)),
    // ArcCosh(Sqrt(3)/2)=1/6*I*Pi
    ISet(ArcCosh(Times(C1D2,CSqrt3)),
      Times(CC(0L,1L,1L,6L),Pi)),
    // ArcCosh((-1)*1/2*Sqrt(3))=5/6*I*Pi
    ISet(ArcCosh(Times(CN1D2,CSqrt3)),
      Times(CC(0L,1L,5L,6L),Pi)),
    // ArcCosh(1)=0
    ISet(ArcCosh(C1),
      C0),
    // ArcCosh(-1)=Pi*I
    ISet(ArcCosh(CN1),
      Times(CI,Pi)),
    // ArcCosh(I)=Log(I*(1+Sqrt(2)))
    ISet(ArcCosh(CI),
      Log(Times(CI,Plus(C1,CSqrt2)))),
    // ArcCosh(Infinity)=Infinity
    ISet(ArcCosh(oo),
      oo),
    // ArcCosh(I*Infinity)=Infinity
    ISet(ArcCosh(DirectedInfinity(CI)),
      oo),
    // ArcCosh(ComplexInfinity)=Infinity
    ISet(ArcCosh(CComplexInfinity),
      oo)
  );
}