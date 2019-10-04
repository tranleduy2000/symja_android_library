package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.AppellF1;
import static org.matheclipse.core.expression.F.AtomQ;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.Catch;
import static org.matheclipse.core.expression.F.CompoundExpression;
import static org.matheclipse.core.expression.F.False;
import static org.matheclipse.core.expression.F.FreeQ;
import static org.matheclipse.core.expression.F.Function;
import static org.matheclipse.core.expression.F.Head;
import static org.matheclipse.core.expression.F.Hypergeometric2F1;
import static org.matheclipse.core.expression.F.ISetDelayed;
import static org.matheclipse.core.expression.F.If;
import static org.matheclipse.core.expression.F.Length;
import static org.matheclipse.core.expression.F.LessEqual;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.MemberQ;
import static org.matheclipse.core.expression.F.Not;
import static org.matheclipse.core.expression.F.Null;
import static org.matheclipse.core.expression.F.Or;
import static org.matheclipse.core.expression.F.Part;
import static org.matheclipse.core.expression.F.PolyLog;
import static org.matheclipse.core.expression.F.Return;
import static org.matheclipse.core.expression.F.SameQ;
import static org.matheclipse.core.expression.F.Scan;
import static org.matheclipse.core.expression.F.Slot1;
import static org.matheclipse.core.expression.F.Throw;
import static org.matheclipse.core.expression.F.True;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.x_Symbol;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.CalculusFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.CalculusQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ComplexFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.ComplexNumberQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.HeldFormQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.HyperbolicQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InverseFunctionFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InverseFunctionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InverseHyperbolicQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.InverseTrigQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.LogQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.StopFunctionQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.TrigHyperbolicFreeQ;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.TrigQ;

/**
 * UtilityFunctions rules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class UtilityFunctions2 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            ISetDelayed(14, ComplexFreeQ(u_),
                    If(AtomQ(u), Not(ComplexNumberQ(u)), SameQ(Scan(Function(If(ComplexFreeQ(Slot1), Null, Return(False))), u), Null)));
            ISetDelayed(15, LogQ(u_),
                    SameQ(Head(u), Log));
            ISetDelayed(16, TrigQ(u_),
                    MemberQ($s("§$trigfunctions"), If(AtomQ(u), u, Head(u))));
            ISetDelayed(17, HyperbolicQ(u_),
                    MemberQ($s("§$hyperbolicfunctions"), If(AtomQ(u), u, Head(u))));
            ISetDelayed(18, InverseTrigQ(u_),
                    MemberQ($s("§$inversetrigfunctions"), If(AtomQ(u), u, Head(u))));
            ISetDelayed(19, InverseHyperbolicQ(u_),
                    MemberQ($s("§$inversehyperbolicfunctions"), If(AtomQ(u), u, Head(u))));
            ISetDelayed(20, CalculusQ(u_),
                    MemberQ($s("§$calculusfunctions"), If(AtomQ(u), u, Head(u))));
            ISetDelayed(21, StopFunctionQ(u_),
                    If(AtomQ(Head(u)), MemberQ($s("§$stopfunctions"), Head(u)), StopFunctionQ(Head(u))));
            ISetDelayed(22, HeldFormQ(u_),
                    If(AtomQ(Head(u)), MemberQ($s("§$heldfunctions"), Head(u)), HeldFormQ(Head(u))));
            ISetDelayed(23, InverseFunctionQ(u_),
                    Or(LogQ(u), And(InverseTrigQ(u), LessEqual(Length(u), C1)), InverseHyperbolicQ(u), SameQ(Head(u), $s("§mods")), SameQ(Head(u), PolyLog)));
            ISetDelayed(24, TrigHyperbolicFreeQ(u_, x_Symbol),
                    If(AtomQ(u), True, If(Or(TrigQ(u), HyperbolicQ(u), CalculusQ(u)), FreeQ(u, x), Catch(CompoundExpression(Scan(Function(If(TrigHyperbolicFreeQ(Slot1, x), Null, Throw(False))), u), True)))));
            ISetDelayed(25, InverseFunctionFreeQ(u_, x_Symbol),
                    If(AtomQ(u), True, If(Or(InverseFunctionQ(u), CalculusQ(u), SameQ(Head(u), Hypergeometric2F1), SameQ(Head(u), AppellF1)), FreeQ(u, x), Catch(CompoundExpression(Scan(Function(If(InverseFunctionFreeQ(Slot1, x), Null, Throw(False))), u), True)))));
            ISetDelayed(26, CalculusFreeQ(u_, x_),
                    If(AtomQ(u), True, If(Or(And(CalculusQ(u), SameQ(Part(u, C2), x)), HeldFormQ(u)), False, Catch(CompoundExpression(Scan(Function(If(CalculusFreeQ(Slot1, x), Null, Throw(False))), u), True)))));
        }
    }
}
