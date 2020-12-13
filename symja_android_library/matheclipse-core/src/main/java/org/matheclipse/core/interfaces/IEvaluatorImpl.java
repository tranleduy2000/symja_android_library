package org.matheclipse.core.interfaces;

import org.matheclipse.core.expression.F;
import org.matheclipse.core.patternmatching.IPatternMapImpl;
import org.matheclipse.core.patternmatching.IPatternMatcher;

/**
 * Created by Duy on 2/20/2018.
 */

public abstract class IEvaluatorImpl implements IEvaluator {

    @Override
    public void await() throws InterruptedException{
        // do nothing
    }

    @Override
    public void setOptions(ISymbol symbol, IAST listOfRules) {
        symbol.putDownRule(
            IPatternMatcher.SET,
            true,
            F.Options(symbol),
            listOfRules,
            IPatternMapImpl.DEFAULT_RULE_PRIORITY,
            true);
    }
}
