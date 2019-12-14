package org.matheclipse.core.eval;

import com.duy.lambda.Predicate;

import org.matheclipse.core.expression.F;
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

}
