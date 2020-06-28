package org.matheclipse.core.eval;

import com.duy.lambda.Predicate;

import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;

public class EvalEngineUtils {

    public static final Predicate<? super IExpr> unevaluatedPredicate = new Predicate<IExpr>() {
        @Override
        public boolean test(IExpr x) {
            return x.isAST(F.Unevaluated, 2);
        }
    };

    public static final Predicate<? super IExpr> indeterminatePredicate = new Predicate<IExpr>() {
        @Override
        public boolean test(IExpr x) {
            return x.isIndeterminate();
        }
    };

    public static final Predicate<? super IExpr> associationPredicate = new Predicate<IExpr>() {
        @Override
        public boolean test(IExpr x) {
            return x.isAssociation();
        }
    };
    public static final Predicate<? super IExpr> conditionalExpressionPredicate = new Predicate<IExpr>() {
        @Override
        public boolean test(IExpr x) {
            return x.isConditionalExpression();
        }
    };
    public static final Predicate<? super IExpr> isNumericFunctionPredicate = new Predicate<IExpr>() {
        @Override
        public boolean test(IExpr y) {
            return y.isNumericFunction();
        }
    };
    public static final Predicate<? super IExpr> isNumericArgumentPredicate = new Predicate<IExpr>() {
        @Override
        public boolean test(IExpr y) {
            return y.isNumericArgument();
        }
    };

    public static final Predicate<? super IExpr> isFunctionOrListNumericArgumentPredicate = new Predicate<IExpr>() {
        @Override
        public boolean test(IExpr x) {
            return x.isNumericFunction() || //
                    (x.isList() && ((IAST) x).forAll(isNumericFunctionPredicate));
        }
    };
    public static final Predicate<? super IExpr> isFunctionOrListNumericArgumentPredicate2 = new Predicate<IExpr>() {
        @Override
        public boolean test(IExpr x) {
            return x.isNumericArgument() || //
                    (x.isList() && ((IAST) x).forAll(isNumericArgumentPredicate));
        }
    };

}
