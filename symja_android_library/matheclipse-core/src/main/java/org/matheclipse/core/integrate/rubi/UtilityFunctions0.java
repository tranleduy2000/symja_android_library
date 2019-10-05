package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$;
import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$ps;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.Block;
import static org.matheclipse.core.expression.F.C0;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.Catch;
import static org.matheclipse.core.expression.F.CompoundExpression;
import static org.matheclipse.core.expression.F.Denominator;
import static org.matheclipse.core.expression.F.Do;
import static org.matheclipse.core.expression.F.Equal;
import static org.matheclipse.core.expression.F.False;
import static org.matheclipse.core.expression.F.Function;
import static org.matheclipse.core.expression.F.Head;
import static org.matheclipse.core.expression.F.ISetDelayed;
import static org.matheclipse.core.expression.F.If;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.Length;
import static org.matheclipse.core.expression.F.Less;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Module;
import static org.matheclipse.core.expression.F.Null;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Part;
import static org.matheclipse.core.expression.F.Rational;
import static org.matheclipse.core.expression.F.Reap;
import static org.matheclipse.core.expression.F.Return;
import static org.matheclipse.core.expression.F.SameQ;
import static org.matheclipse.core.expression.F.Scan;
import static org.matheclipse.core.expression.F.Set;
import static org.matheclipse.core.expression.F.Slot1;
import static org.matheclipse.core.expression.F.Sow;
import static org.matheclipse.core.expression.F.Throw;
import static org.matheclipse.core.expression.F.True;
import static org.matheclipse.core.expression.F.With;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.EveryQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionOrNegativeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.HalfIntegerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Int;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IntHide;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Map2;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ReapList;

/**
 * UtilityFunctions rules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class UtilityFunctions0 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            ISetDelayed(1, IntHide(u_, x_Symbol),
                    Block(List(Set($s("§$showsteps"), False), Set($s("§$stepcounter"), Null)), Int(u, x)));
            ISetDelayed(2, EveryQ($p("func"), $p("lst")),
                    Catch(CompoundExpression(Scan(Function(If($($s("func"), Slot1), Null, Throw(False))), $s("lst")), True)));
            ISetDelayed(3, Map2($p("func"), $p("lst1"), $p("lst2")),
                    Module(List($s("ii")), ReapList(Do(Sow($($s("func"), Part($s("lst1"), $s("ii")), Part($s("lst2"), $s("ii")))), List($s("ii"), Length($s("lst1")))))));
            ISetDelayed(4, ReapList(u_),
                    With(List(Set($s("lst"), Part(Reap(u), C2))), If(SameQ($s("lst"), List()), $s("lst"), Part($s("lst"), C1))));
            ISetDelayed(5, HalfIntegerQ($ps("u")),
                    SameQ(Scan(Function(If(And(SameQ(Head(Slot1), Rational), Equal(Denominator(Slot1), C2)), Null, Return(False))), List(u)), Null));
            ISetDelayed(6, RationalQ($ps("u")),
                    SameQ(Scan(Function(If(Or(IntegerQ(Slot1), SameQ(Head(Slot1), Rational)), Null, Return(False))), List(u)), Null));
            ISetDelayed(7, FractionOrNegativeQ($ps("u")),
                    SameQ(Scan(Function(If(Or(FractionQ(Slot1), And(IntegerQ(Slot1), Less(Slot1, C0))), Null, Return(False))), List(u)), Null));
        }
    }
}
