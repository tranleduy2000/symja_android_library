package org.matheclipse.core.interfaces;

import org.matheclipse.core.expression.F;

/**
 * Created by Duy on 2/20/2018.
 */

public abstract class IEvaluatorImpl implements IEvaluator {

    @Override
    public void await() throws InterruptedException{
        // do nothing
    }

    @Override
    public IAST options() {
        return F.NIL;
    }
}
