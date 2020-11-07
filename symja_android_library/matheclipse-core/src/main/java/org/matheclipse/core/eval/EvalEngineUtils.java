package org.matheclipse.core.eval;

import com.duy.lambda.Predicate;

import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;

public class EvalEngineUtils {

    public static final Predicate<? super IExpr> isASTUnevaluated2 = new Predicate<IExpr>() {
        @Override
        public boolean test(IExpr x) {
            return x.isAST(F.Unevaluated, 2);
        }
    };

    public static final Predicate<? super IExpr> isIndeterminate = new Predicate<IExpr>() {
        @Override
        public boolean test(IExpr x) {
            return x.isIndeterminate();
        }
    };

    public static final Predicate<? super IExpr> isAssociation = new Predicate<IExpr>() {
        @Override
        public boolean test(IExpr x) {
            return x.isAssociation();
        }
    };
    public static final Predicate<? super IExpr> isConditionalExpression = new Predicate<IExpr>() {
        @Override
        public boolean test(IExpr x) {
            return x.isConditionalExpression();
        }
    };
    public static final Predicate<? super IExpr> isNumericFunction = new Predicate<IExpr>() {
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
                    (x.isList() && ((IAST) x).forAll(isNumericFunction));
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
