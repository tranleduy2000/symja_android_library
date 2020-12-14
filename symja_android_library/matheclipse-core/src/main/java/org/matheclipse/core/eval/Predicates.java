package org.matheclipse.core.eval;

import com.duy.lambda.Predicate;

import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;

public class Predicates {

  public static final Predicate<IExpr> isASTUnevaluated2 = new Predicate<IExpr>() {
    @Override
    public boolean test(IExpr x) {
      return x.isAST(F.Unevaluated, 2);
    }
  };

  public static final Predicate<IExpr> isIndeterminate = new Predicate<IExpr>() {
    @Override
    public boolean test(IExpr x) {
      return x.isIndeterminate();
    }
  };

  public static final Predicate<IExpr> isAssociation = new Predicate<IExpr>() {
    @Override
    public boolean test(IExpr x) {
      return x.isAssociation();
    }
  };
  public static final Predicate<IExpr> isConditionalExpression = new Predicate<IExpr>() {
    @Override
    public boolean test(IExpr x) {
      return x.isConditionalExpression();
    }
  };
  public static final Predicate<IExpr> isNumericFunctionTrue = new Predicate<IExpr>() {
    @Override
    public boolean test(IExpr y) {
      return y.isNumericFunction(true);
    }
  };
  public static final Predicate<IExpr> isNumericArgumentPredicate = new Predicate<IExpr>() {
    @Override
    public boolean test(IExpr y) {
      return y.isNumericArgument();
    }
  };

  public static final Predicate<IExpr> isFunctionOrListNumericArgumentPredicate = new Predicate<IExpr>() {
    @Override
    public boolean test(IExpr x) {
      return x.isNumericFunction(true) || //
          (x.isList() && ((IAST) x).forAll(isNumericFunctionTrue));
    }
  };
  public static final Predicate<IExpr> isFunctionOrListNumericArgumentPredicate2 = new Predicate<IExpr>() {
    @Override
    public boolean test(IExpr x) {
      return x.isNumericArgument() || //
          (x.isList() && ((IAST) x).forAll(isNumericArgumentPredicate));
    }
  };

  public static Predicate<IExpr> isBooleanFormula = new Predicate<IExpr>() {
    @Override
    public boolean test(IExpr x) {
      return x.isBooleanFormula();
    }
  };
  public static Predicate<IExpr> isNotPolynomialStruct = new Predicate<IExpr>() {
    @Override
    public boolean test(IExpr x) {
      return !x.isPolynomialStruct();
    }
  };
  public static Predicate<IExpr> isInexactNumber = new Predicate<IExpr>() {
    @Override
    public boolean test(IExpr x) {
      return x.isInexactNumber();
    }
  };
  public static Predicate<IExpr> isBooleanResult = new Predicate<IExpr>() {
    @Override
    public boolean test(IExpr x) {
      return x.isBooleanResult();
    }
  };
  public static Predicate<IExpr> isBlank = new Predicate<IExpr>() {
    @Override
    public boolean test(IExpr x) {
      return x.isBlank();
    }
  };
  public static Predicate<IExpr> isTimes = new Predicate<IExpr>() {
    @Override
    public boolean test(IExpr iExpr) {
      return iExpr.isTimes();
    }
  };
  public static Predicate<IExpr> isPlus = new Predicate<IExpr>() {
    @Override
    public boolean test(IExpr iExpr) {
      return iExpr.isPlus();
    }
  };
  public static Predicate<IExpr> isPlusTimesPower = new Predicate<IExpr>() {
    @Override
    public boolean test(IExpr x) {
      return x.isPlusTimesPower();
    }
  };
  public static Predicate<IExpr> hasTrigonometricFunction = new Predicate<IExpr>() {
    @Override
    public boolean test(IExpr x) {
      if (x.isAST1()) {
        final IExpr head = x.head();
        if (head.isBuiltInSymbol()) {
          return //
              (head == F.ArcCos) || //
                  (head == F.ArcCsc) || //
                  (head == F.ArcCot) || //
                  (head == F.ArcSec) || //
                  (head == F.ArcSin) || //
                  (head == F.ArcTan) || //
                  (head == F.Cos) || //
                  (head == F.Csc) || //
                  (head == F.Cot) || //
                  (head == F.Sec) || //
                  (head == F.Sin) || //
                  (head == F.Sinc) || //
                  (head == F.Tan) || //
                  (head == F.Cosh) || //
                  (head == F.Csch) || //
                  (head == F.Coth) || //
                  (head == F.Sech) || //
                  (head == F.Sinh) || //
                  (head == F.Tanh) || //
                  (head == F.Haversine) || //
                  (head == F.InverseHaversine);
        }
      }
      if (x.isAST2()) {
        return x.head() == F.ArcTan;
      }
      return false;
    }
  };
  public static Predicate<? super IExpr> isNegativeInfinity = new Predicate<IExpr>() {
    @Override
    public boolean test(IExpr x) {
      return x.isNegativeInfinity();
    }
  };
}
