package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.$p;
import static org.matheclipse.core.expression.F.$rubi;
import static org.matheclipse.core.expression.F.$s;
import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.C3;
import static org.matheclipse.core.expression.F.Condition;
import static org.matheclipse.core.expression.F.Equal;
import static org.matheclipse.core.expression.F.Head;
import static org.matheclipse.core.expression.F.ISetDelayed;
import static org.matheclipse.core.expression.F.If;
import static org.matheclipse.core.expression.F.Insert;
import static org.matheclipse.core.expression.F.Integrate;
import static org.matheclipse.core.expression.F.Length;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.MemberQ;
import static org.matheclipse.core.expression.F.Negate;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.ReplacePart;
import static org.matheclipse.core.expression.F.Rule;
import static org.matheclipse.core.expression.F.RuleDelayed;
import static org.matheclipse.core.expression.F.SameQ;
import static org.matheclipse.core.expression.F.Subtract;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.Unevaluated;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.u;
import static org.matheclipse.core.expression.F.u_;
import static org.matheclipse.core.expression.F.v;
import static org.matheclipse.core.expression.F.v_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Dist;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FixIntRule;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.FixRhsIntRule;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.Simp;

/**
 * UtilityFunctions rules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 */
public class UtilityFunctions31 {

    public static void initialize() {
        Initializer.init();
    }

    private static class Initializer {

        private static void init() {
            ISetDelayed(704, FixIntRule(RuleDelayed($p("lhs"), u_), x_),
                    ReplacePart(RuleDelayed($s("lhs"), u), Rule(List(C2), FixRhsIntRule(u, x))));
            ISetDelayed(705, FixRhsIntRule(Plus(u_, v_), x_),
                    Plus(FixRhsIntRule(u, x), FixRhsIntRule(v, x)));
            ISetDelayed(706, FixRhsIntRule(Subtract(u_, v_), x_),
                    Subtract(FixRhsIntRule(u, x), FixRhsIntRule(v, x)));
            ISetDelayed(707, FixRhsIntRule(Negate(u_), x_),
                    Negate(FixRhsIntRule(u, x)));
            ISetDelayed(708, FixRhsIntRule(Times(a_, u_), x_),
                    Condition(Dist(a, u, x), MemberQ(List(Integrate, $rubi("Subst")), Head(Unevaluated(u)))));
            ISetDelayed(709, FixRhsIntRule(u_, x_),
                    If(And(SameQ(Head(Unevaluated(u)), $rubi("Dist")), Equal(Length(Unevaluated(u)), C2)), Insert(Unevaluated(u), x, C3), If(MemberQ(List(Integrate, $rubi("Unintegrable"), $rubi("CannotIntegrate"), $rubi("Subst"), $rubi("Simp"), $rubi("Dist")), Head(Unevaluated(u))), u, Simp(u, x))));
        }

        ;
    }
}
