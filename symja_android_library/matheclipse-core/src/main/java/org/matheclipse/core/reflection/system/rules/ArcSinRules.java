package org.matheclipse.core.reflection.system.rules;

import static org.matheclipse.core.expression.F.*;
import org.matheclipse.core.interfaces.IAST;

/**
 * <p>Generated by <code>org.matheclipse.core.preprocessor.RulePreprocessor</code>.</p>
 * <p>See GIT repository at: <a href="https://github.com/axkr/symja_android_library">github.com/axkr/symja_android_library under the tools directory</a>.</p>
 */
public interface ArcSinRules {
    /**
     * <ul>
     * <li>index 0 - number of equal rules in <code>RULES</code></li>
     * </ul>
     */
    final public static int[] SIZES = { 17, 0 };

    final public static IAST RULES = List(
            IInit(ArcSin, SIZES),
            // ArcSin(Undefined)=Undefined
            ISet(ArcSin(Undefined),
                    Undefined),
            // ArcSin(0)=0
            ISet(ArcSin(C0),
                    C0),
            // ArcSin((-1+Sqrt(3))/(2*Sqrt(2)))=Pi/12
            ISet(ArcSin(Times(C1D2,C1DSqrt2,Plus(CN1,CSqrt3))),
                    Times(QQ(1L,12L),Pi)),
            // ArcSin(1/4*(-1+Sqrt(5)))=Pi/10
            ISet(ArcSin(Times(C1D4,Plus(CN1,CSqrt5))),
                    Times(QQ(1L,10L),Pi)),
            // ArcSin(1/4*(Sqrt(5)+1))=3/10*Pi
            ISet(ArcSin(Times(C1D4,Plus(C1,CSqrt5))),
                    Times(QQ(3L,10L),Pi)),
            // ArcSin(Sqrt(2-Sqrt(2))/2)=Pi/8
            ISet(ArcSin(Times(C1D2,Sqrt(Subtract(C2,CSqrt2)))),
                    Times(QQ(1L,8L),Pi)),
            // ArcSin(1/2)=Pi/6
            ISet(ArcSin(C1D2),
                    Times(QQ(1L,6L),Pi)),
            // ArcSin(Sqrt(1/2*(5-Sqrt(5)))/2)=Pi/5
            ISet(ArcSin(Times(C1D2,Sqrt(Times(C1D2,Subtract(C5,CSqrt5))))),
                    Times(QQ(1L,5L),Pi)),
            // ArcSin(Sqrt(2)/2)=Pi/4
            ISet(ArcSin(C1DSqrt2),
                    Times(C1D4,Pi)),
            // ArcSin(Sqrt(3)/2)=Pi/3
            ISet(ArcSin(Times(C1D2,CSqrt3)),
                    Times(C1D3,Pi)),
            // ArcSin(Sqrt(2+Sqrt(2))/2)=3/8*Pi
            ISet(ArcSin(Times(C1D2,Sqrt(Plus(C2,CSqrt2)))),
                    Times(QQ(3L,8L),Pi)),
            // ArcSin(Sqrt(1/2*(5+Sqrt(5)))/2)=2/5*Pi
            ISet(ArcSin(Times(C1D2,Sqrt(Times(C1D2,Plus(C5,CSqrt5))))),
                    Times(QQ(2L,5L),Pi)),
            // ArcSin((1+Sqrt(3))/(2*Sqrt(2)))=5/12*Pi
            ISet(ArcSin(Times(C1D2,C1DSqrt2,Plus(C1,CSqrt3))),
                    Times(QQ(5L,12L),Pi)),
            // ArcSin(1)=Pi/2
            ISet(ArcSin(C1),
                    CPiHalf),
            // ArcSin(Infinity)=-I*Infinity
            ISet(ArcSin(oo),
                    DirectedInfinity(CNI)),
            // ArcSin(I*Infinity)=I*Infinity
            ISet(ArcSin(DirectedInfinity(CI)),
                    DirectedInfinity(CI)),
            // ArcSin(ComplexInfinity)=ComplexInfinity
            ISet(ArcSin(CComplexInfinity),
                    CComplexInfinity)
    );
}
