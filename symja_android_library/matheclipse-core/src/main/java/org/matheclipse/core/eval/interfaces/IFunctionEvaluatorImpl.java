package org.matheclipse.core.eval.interfaces;

import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IEvaluatorImpl;

/**
 * Created by Duy on 2/20/2018.
 */

public abstract class IFunctionEvaluatorImpl extends IEvaluatorImpl implements IFunctionEvaluator {
    @Override
    public int[] expectedArgSize(IAST ast) {
        return null;
    }


}
