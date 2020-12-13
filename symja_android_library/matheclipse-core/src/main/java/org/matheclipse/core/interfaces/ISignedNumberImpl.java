package org.matheclipse.core.interfaces;

import org.matheclipse.core.expression.F;
import org.matheclipse.core.expression.S;

/**
 * Created by Duy on 2/20/2018.
 */
public abstract class ISignedNumberImpl extends INumberImpl implements ISignedNumber {

  /**
   * Divide <code>this</code> signed number by <code>that</code> signed number.
   *
   * @param that a signed number
   * @return
   */
  public abstract ISignedNumber divideBy(ISignedNumber that);

  @Override
  public IInteger integerPart() {
    return isNegative() ? ceilFraction() : floorFraction();
  }

  /**
   * Test if <code>this</code> signed number is greater <code>than</code> that signed number..
   *
   * @return <code>this > that</code>
   */
  public abstract boolean isGT(ISignedNumber that);

  @Override
  public boolean isGE(ISignedNumber that) {
    return !isLT(that);
  }

  @Override
  public boolean isGreaterThan(ISignedNumber that) {
    return isGT(that);
  }

  /**
   * Test if <code>this</code> signed number is less <code>than</code> that signed number..
   *
   * @return <code>this < that</code>
   */
  public abstract boolean isLT(ISignedNumber that);

  @Override
  public boolean isLE(ISignedNumber that) {
    return !isGT(that);
  }

  @Override
  public boolean isLessThan(ISignedNumber that) {
    return isLT(that);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public IExpr complexArg() {
    if (sign() < 0) {
      return F.Pi;
    }
    return F.C0;
  }

  @Override
  public boolean isNegativeResult() {
    return isNegative();
  }

  @Override
  public boolean isNonNegativeResult() {
    return !isNegative();
  }

  @Override
  public boolean isPositiveResult() {
    return isPositive();
  }

  /**
   * If this is a <code>Interval[{lower, upper}]</code> expression return the <code>lower</code>
   * value. If this is a
   * <code>ISignedNUmber</code> expression return <code>this</code>.
   *
   * @return <code>F.NIL</code> if this expression is no interval and no signed number.
   */
  @Override
  public IExpr lower() {
    return this;
  }

  @Override
  public IExpr unitStep() {
    return isNegative() ? F.C0 : F.C1;
  }

  /**
   * If this is a <code>Interval[{lower, upper}]</code> expression return the <code>upper</code>
   * value. If this is a
   * <code>ISignedNUmber</code> expression return <code>this</code>.
   *
   * @return <code>F.NIL</code> if this expression is no interval and no signed number.
   */
  @Override
  public IExpr upper() {
    return this;
  }

  @Override
  public IAST toPolarCoordinates() {
    if (isNegative()) {
      return F.pair(this.negate(), F.Pi);
    }
    return F.pair(this, F.C0);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public abstract ISignedNumber inverse();

  /**
   * Returns (-1) * this
   *
   * @return
   */
  @Override
  public abstract ISignedNumber negate();

  /**
   * {@inheritDoc}
   */
  @Override
  public abstract ISignedNumber abs();

  /**
   * {@inheritDoc}
   */
  @Override
  public INumber conjugate() {
    return this;
  }

  @Override
  public abstract ISignedNumber opposite();

  @Override
  public boolean isRange(ISignedNumber from, ISignedNumber to) {
    return isGE(from) && isLE(to);

  }

  @Override
  public boolean isRangeExclExcl(ISignedNumber from, ISignedNumber to) {
    return isGT(from) && isLT(to);

  }

  @Override
  public boolean isRangeExclIncl(ISignedNumber from, ISignedNumber to) {
    return isGT(from) && isLE(to);

  }

  @Override
  public boolean isRangeInclExcl(ISignedNumber from, ISignedNumber to) {
    return isGE(from) && isLT(to);

  }
}
