package org.matheclipse.core.expression;

import org.matheclipse.core.interfaces.IASTAppendable;
import org.matheclipse.core.interfaces.IASTMutable;

public abstract class IASTAppendableImpl extends AbstractAST implements IASTAppendable {
    @Override
    public boolean isNotDefined() {
        return false;
    }

}
