package org.matheclipse.core.expression;

import org.matheclipse.core.interfaces.IASTAppendable;
import org.matheclipse.core.interfaces.IASTMutable;
import org.matheclipse.core.interfaces.IExpr;

public abstract class IASTAppendableImpl extends AbstractAST implements IASTAppendable {

  @Override
  public boolean isNotDefined() {
    return false;
  }

  @Override
  public void appendRule(IExpr expr) {
    append(expr);
  }

  @Override
  public void prependRule(IExpr rule) {
    append(1, rule);
  }
}
