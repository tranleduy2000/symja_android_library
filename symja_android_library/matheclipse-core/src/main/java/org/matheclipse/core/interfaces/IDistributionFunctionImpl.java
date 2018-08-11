package org.matheclipse.core.interfaces;

import com.duy.lambda.Function;

import org.hipparchus.distribution.RealDistribution;
import org.matheclipse.core.builtin.StatisticsFunctions;
import org.matheclipse.core.eval.interfaces.AbstractEvaluator;
import org.matheclipse.core.expression.F;

public abstract class IDistributionFunctionImpl extends AbstractEvaluator
        implements StatisticsFunctions.ICDF, IDistribution, StatisticsFunctions.IPDF {

    @Override
    public RealDistribution dist() {
        return null;
    }

    @Override
    public IExpr callFunction(IExpr pureFunction, IExpr x) {
        if (x.isPresent()) {
            if (x.isList()) {
                return ((IAST) x).map(new Function<IExpr, IExpr>() {
                    @Override
                    public IExpr apply(IExpr v) {
                        return F.unaryAST1(pureFunction, v);
                    }
                }, 1);
            }
            return F.unaryAST1(pureFunction, x);
        }
        return pureFunction;
    }
}