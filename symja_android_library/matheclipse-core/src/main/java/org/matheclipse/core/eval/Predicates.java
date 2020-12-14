package org.matheclipse.core.eval;

import com.duy.lambda.Function;
import com.duy.lambda.Predicate;
import org.matheclipse.core.builtin.WXFFunctions;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.expression.S;
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
  public static Predicate<IExpr> isAtom = new Predicate<IExpr>() {
    @Override
    public boolean test(IExpr x) {
      return x.isAtom();
    }
  };
  public static Predicate<IExpr> isTrueOrFalse = new Predicate<IExpr>() {
    @Override
    public boolean test(IExpr x) {
      return x.isTrue() || x.isFalse();
    }
  };
  public static Predicate<IExpr> isString = new Predicate<IExpr>() {
    @Override
    public boolean test(IExpr x) {
      return x.isString();
    }
  };
  public static Predicate<IExpr> isSymbol = new Predicate<IExpr>() {
    @Override
    public boolean test(IExpr x) {
      return x.isSymbol();
    }
  };
  public static Predicate<IExpr> isNumber = new Predicate<IExpr>() {
    @Override
    public boolean test(IExpr x) {
      return x.isNumber();
    }
  };
  public static Predicate<IExpr> isMachineNumber = new Predicate<IExpr>() {
    @Override
    public boolean test(IExpr x) {
      return x.isMachineNumber();
    }
  };
  public static Predicate<IExpr> isExactNumber = new Predicate<IExpr>() {
    @Override
    public boolean test(IExpr x) {
      return x.isExactNumber();
    }
  };

  public static Predicate<IExpr> isInteger = new Predicate<IExpr>() {
    @Override
    public boolean test(IExpr x) {
      return x.isInteger();
    }
  };
  public static Predicate<IExpr> isList = new Predicate<IExpr>() {
    @Override
    public boolean test(IExpr x) {
      return x.isList();
    }
  };
  public static Predicate<IExpr> isASTMissing2 = new Predicate<IExpr>() {
    @Override
    public boolean test(IExpr x) {
      return x.isAST(S.Missing, 2);
    }
  };
  public static Predicate<IExpr> isNotList = new Predicate<IExpr>() {
    @Override
    public boolean test(IExpr x) {
      return !x.isList();
    }
  };
  public static Predicate<IExpr> isByteArray = new Predicate<IExpr>() {
    @Override
    public boolean test(IExpr x) {
      return WXFFunctions.isByteArray(x);
    }
  };
  public static Function<IExpr, IExpr> evalNumber = new Function<IExpr, IExpr>() {
    @Override
    public IExpr apply(IExpr x) {
      return x.evalNumber();
    }
  };
  public static Predicate<IExpr> isNumericFunctionFalse = new Predicate<IExpr>() {
    @Override
    public boolean test(IExpr x) {
      return x.isNumericFunction(false);
    }
  };
}
