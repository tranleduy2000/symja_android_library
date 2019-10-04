package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.AtomQ;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.CI;
import static org.matheclipse.core.expression.F.Catch;
import static org.matheclipse.core.expression.F.CompoundExpression;
import static org.matheclipse.core.expression.F.False;
import static org.matheclipse.core.expression.F.First;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.Function;
import static org.matheclipse.core.expression.F.ISetDelayed;
import static org.matheclipse.core.expression.F.If;
import static org.matheclipse.core.expression.F.IntegerQ;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Null;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Part;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Rest;
import static org.matheclipse.core.expression.F.SameQ;
import static org.matheclipse.core.expression.F.Scan;
import static org.matheclipse.core.expression.F.Slot1;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Throw;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.True;
import static org.matheclipse.core.expression.F.m;
import static org.matheclipse.core.expression.F.m_;
import static org.matheclipse.core.expression.F.n;
import static org.matheclipse.core.expression.F.n_;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionalPowerFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FractionalPowerQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.IndependentQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ProductQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.RationalQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SqrtNumberQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SqrtNumberSumQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.SumQ;

/**
 * UtilityFunctions rules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class UtilityFunctions1 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            ISetDelayed(8, SqrtNumberQ(Power(m_, n_)),
                    Or(And(IntegerQ(n), SqrtNumberQ(m)), And(IntegerQ(Subtract(n, C1D2)), RationalQ(m))));
            ISetDelayed(9, SqrtNumberQ(Times(u_, v_)),
                    And(SqrtNumberQ(u), SqrtNumberQ(v)));
            ISetDelayed(10, SqrtNumberQ(u_),
                    Or(RationalQ(u), SameQ(u, CI)));
            ISetDelayed(11, SqrtNumberSumQ(u_),
                    Or(And(SumQ(u), SqrtNumberQ(First(u)), SqrtNumberQ(Rest(u))), And(ProductQ(u), SqrtNumberQ(First(u)), SqrtNumberSumQ(Rest(u)))));
            ISetDelayed(12, IndependentQ(u_, x_),
                    FreeQ(u, x));
            ISetDelayed(13, FractionalPowerFreeQ(u_),
                    If(AtomQ(u), True, If(And(FractionalPowerQ(u), Not(AtomQ(Part(u, C1)))), False, Catch(CompoundExpression(Scan(Function(If(FractionalPowerFreeQ(Slot1), Null, Throw(False))), u), True)))));
        }
    }
}
