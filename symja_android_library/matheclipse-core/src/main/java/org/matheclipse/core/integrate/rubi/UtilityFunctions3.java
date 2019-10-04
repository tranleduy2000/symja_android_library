package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$rubi;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.Equal;
import static org.matheclipse.core.expression.F.False;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.Greater;
import static org.matheclipse.core.expression.F.GreaterEqual;
import static org.matheclipse.core.expression.F.Head;
import static org.matheclipse.core.expression.F.ISetDelayed;
import static org.matheclipse.core.expression.F.If;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.Integrate;
import static org.matheclipse.core.expression.F.Less;
import static org.matheclipse.core.expression.F.LessEqual;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.N;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.PossibleZeroQ;
import static org.matheclipse.core.expression.F.Quiet;
import static org.matheclipse.core.expression.F.Real;
import static org.matheclipse.core.expression.F.RealNumberQ;
import static org.matheclipse.core.expression.F.Refine;
import static org.matheclipse.core.expression.F.SameQ;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Together;
import static org.matheclipse.core.expression.F.True;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.w;
import static org.matheclipse.core.expression.F.w_;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EqQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.GtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IGtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ILtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntegralFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LtQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.NeQ;

/**
 * UtilityFunctions rules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class UtilityFunctions3 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            ISetDelayed(27, IntegralFreeQ(u_),
                    And(FreeQ(u, Integrate), FreeQ(u, $rubi("Integral")), FreeQ(u, $rubi("Unintegrable")), FreeQ(u, $rubi("CannotIntegrate"))));
            ISetDelayed(28, EqQ(u_, v_),
                    Or(Quiet(PossibleZeroQ(Subtract(u, v))), SameQ(Refine(Equal(u, v)), True)));
            ISetDelayed(29, NeQ(u_, v_),
                    Not(Or(Quiet(PossibleZeroQ(Subtract(u, v))), SameQ(Refine(Equal(u, v)), True))));
            ISetDelayed(30, IGtQ(u_, n_),
                    And(IntegerQ(u), Greater(u, n)));
            ISetDelayed(31, ILtQ(u_, n_),
                    And(IntegerQ(u), Less(u, n)));
            ISetDelayed(32, IGeQ(u_, n_),
                    And(IntegerQ(u), GreaterEqual(u, n)));
            ISetDelayed(33, ILeQ(u_, n_),
                    And(IntegerQ(u), LessEqual(u, n)));
            ISetDelayed(34, GtQ(u_, v_),
                    If(RealNumberQ(u), If(RealNumberQ(v), Greater(u, v), With(List(Set($s("vn"), N(Together(v)))), And(SameQ(Head($s("vn")), Real), Greater(u, $s("vn"))))), With(List(Set($s("un"), N(Together(u)))), If(SameQ(Head($s("un")), Real), If(RealNumberQ(v), Greater($s("un"), v), With(List(Set($s("vn"), N(Together(v)))), And(SameQ(Head($s("vn")), Real), Greater($s("un"), $s("vn"))))), False))));
            ISetDelayed(35, GtQ(u_, v_, w_),
                    And(GtQ(u, v), GtQ(v, w)));
            ISetDelayed(36, LtQ(u_, v_),
                    If(RealNumberQ(u), If(RealNumberQ(v), Less(u, v), With(List(Set($s("vn"), N(Together(v)))), And(SameQ(Head($s("vn")), Real), Less(u, $s("vn"))))), With(List(Set($s("un"), N(Together(u)))), If(SameQ(Head($s("un")), Real), If(RealNumberQ(v), Less($s("un"), v), With(List(Set($s("vn"), N(Together(v)))), And(SameQ(Head($s("vn")), Real), Less($s("un"), $s("vn"))))), False))));
            ISetDelayed(37, LtQ(u_, v_, w_),
                    And(LtQ(u, v), LtQ(v, w)));
            ISetDelayed(38, GeQ(u_, v_),
                    If(RealNumberQ(u), If(RealNumberQ(v), GreaterEqual(u, v), With(List(Set($s("vn"), N(Together(v)))), And(SameQ(Head($s("vn")), Real), GreaterEqual(u, $s("vn"))))), With(List(Set($s("un"), N(Together(u)))), If(SameQ(Head($s("un")), Real), If(RealNumberQ(v), GreaterEqual($s("un"), v), With(List(Set($s("vn"), N(Together(v)))), And(SameQ(Head($s("vn")), Real), GreaterEqual($s("un"), $s("vn"))))), False))));
            ISetDelayed(39, GeQ(u_, v_, w_),
                    And(GeQ(u, v), GeQ(v, w)));
            ISetDelayed(40, LeQ(u_, v_),
                    If(RealNumberQ(u), If(RealNumberQ(v), LessEqual(u, v), With(List(Set($s("vn"), N(Together(v)))), And(SameQ(Head($s("vn")), Real), LessEqual(u, $s("vn"))))), With(List(Set($s("un"), N(Together(u)))), If(SameQ(Head($s("un")), Real), If(RealNumberQ(v), LessEqual($s("un"), v), With(List(Set($s("vn"), N(Together(v)))), And(SameQ(Head($s("vn")), Real), LessEqual($s("un"), $s("vn"))))), False))));
            ISetDelayed(41, LeQ(u_, v_, w_),
                    And(LeQ(u, v), LeQ(v, w)));
        }
    }
}
