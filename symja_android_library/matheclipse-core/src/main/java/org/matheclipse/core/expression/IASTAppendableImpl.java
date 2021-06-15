package org.matheclipse.core.expression;

import com.duy.lambda.Consumer;
import org.matheclipse.core.interfaces.IASTAppendable;
import org.matheclipse.core.interfaces.IExpr;

public abstract class IASTAppendableImpl extends AbstractAST implements IASTAppendable {

  @Override
  public boolean isNotDefined() {
    return false;
  }

  @Override
  public boolean append(long value) {
    return append(F.ZZ(value));
  }

  @Override
  public boolean append(double value) {
    return append(F.num(value));
  }

  @Override
  public boolean append(String value) {
    return append(F.stringx(value));
  }

  @Override
  public boolean append(char value) {
    return append(F.stringx(value));
  }

  @Override
  public boolean append(boolean value) {
    return append(F.bool(value));
  }

  @Override
  public void append(int location, long value) {
    append(location, F.ZZ(value));
  }

  @Override
  public void appendRule(IExpr expr) {
    append(expr);
  }

  @Override
  public void prependRule(IExpr rule) {
    append(1, rule);
  }

  /**
   * If this expression unequals <code>F.NIL</code>, invoke the specified consumer with this <code>
   * IASTAppendable</code> object, otherwise do nothing.
   *
   * @param consumer block to be executed if this expression unequals <code>F.NIL</code>
   * @see java.util.Optional#ifPresent(Consumer)
   */
  @Override
  public void ifAppendable(Consumer<? super IASTAppendable> consumer) {
    consumer.accept(this);
  }

}
