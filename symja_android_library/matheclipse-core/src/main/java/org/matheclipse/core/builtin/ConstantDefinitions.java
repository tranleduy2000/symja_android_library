package org.matheclipse.core.builtin;

import android.graphics.Path;
import java.io.File;
import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;
import org.apfloat.Apint;
import org.apfloat.Aprational;
import org.matheclipse.core.basic.Config;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.interfaces.AbstractSymbolEvaluator;
import org.matheclipse.core.eval.interfaces.ISetValueEvaluator;
import org.matheclipse.core.eval.interfaces.ISignedNumberConstantAbstractSymbolEvaluator;
import org.matheclipse.core.expression.ContextPath;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.expression.S;
import org.matheclipse.core.interfaces.IASTAppendable;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.IInteger;
import org.matheclipse.core.interfaces.ISymbol;

import java.util.Calendar;
import java.util.Properties;

import org.matheclipse.core.tensor.io.ResourceData;
import org.matheclipse.parser.client.FEConfig;

import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Times;

public class ConstantDefinitions {

  public static String VERSION = "1.0.0";
  public static String TIMESTAMP = "";
  private static int YEAR = Calendar.getInstance().get(Calendar.YEAR);
  private static int MONTH = Calendar.getInstance().get(Calendar.MONTH);
  private static int DAY = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
  private static int HOUR = Calendar.getInstance().get(Calendar.HOUR);
  private static int MINUTE = Calendar.getInstance().get(Calendar.MINUTE);
  private static int SECOND = Calendar.getInstance().get(Calendar.SECOND);
  public static final double EULER_GAMMA = 0.57721566490153286060651209008240243104215933593992;

  /**
   * See <a href="https://pangin.pro/posts/computation-in-static-initializer">Beware of computation in static
   * initializer</a>
   */
  private static class Initializer {

    private static void init() {
      Properties properties = ResourceData.properties("/version.txt");

      String versionString = properties.getProperty("version");
      if (versionString != null && versionString.charAt(0) != '$') {
        VERSION = versionString;
      }

      String timestamp = properties.getProperty("timestamp");
      if (timestamp != null && timestamp.charAt(0) != '$') {
        TIMESTAMP = timestamp;
        try {
          YEAR = Integer.parseInt(TIMESTAMP.substring(0, 4));
          MONTH = Integer.parseInt(TIMESTAMP.substring(4, 6));
          DAY = Integer.parseInt(TIMESTAMP.substring(6, 8));
          HOUR = Integer.parseInt(TIMESTAMP.substring(8, 10));
          MINUTE = Integer.parseInt(TIMESTAMP.substring(10, 12));
          SECOND = Integer.parseInt(TIMESTAMP.substring(12, 14));
        } catch (NumberFormatException nfe) {
          nfe.printStackTrace();
        }
      }

      // System.out.println(VERSION);
      // System.out.println(TIMESTAMP);
      F.$Context.setEvaluator(new $Context());
      F.$ContextPath.setEvaluator(new $ContextPath());
      F.$CreationDate.setEvaluator(new $CreationDate());
//      F.$HistoryLength.setEvaluator(new $HistoryLength());
      F.$HomeDirectory.setEvaluator(new $HomeDirectory());
      F.$IterationLimit.setEvaluator(new $IterationLimit());
//      F.$Line.setEvaluator(new $Line());
      F.$MachineEpsilon.setEvaluator(new $MachineEpsilon());
      F.$MachinePrecision.setEvaluator(new $MachinePrecision());
//      F.$Packages.setEvaluator(new $Packages());
      F.$Path.setEvaluator(new $Path());
      F.$PathnameSeparator.setEvaluator(new $PathnameSeparator());

      F.$UserName.setEvaluator(new $UserName());
      F.$RecursionLimit.setEvaluator(new $RecursionLimit());
//      F.$RootDirectory.setEvaluator(new $RootDirectory());
//      F.$TemporaryDirectory.setEvaluator(new $TemporaryDirectory());
      F.$Version.setEvaluator(new $Version());

      // System.out.println(S.$CreationDate.of().toString());
      F.Catalan.setEvaluator(new Catalan());
      F.ComplexInfinity.setEvaluator(new ComplexInfinity());
      F.Degree.setEvaluator(new Degree());
      F.E.setEvaluator(new E());
      F.EulerGamma.setEvaluator(new EulerGamma());
      F.Glaisher.setEvaluator(new Glaisher());
      F.GoldenAngle.setEvaluator(new GoldenAngle());
      F.GoldenRatio.setEvaluator(new GoldenRatio());
      F.I.setEvaluator(new I());
      F.Infinity.setEvaluator(new Infinity());
      F.Khinchin.setEvaluator(new Khinchin());
      F.Pi.setEvaluator(new Pi());

//      F.Now.setEvaluator(new Now());
//      F.Today.setEvaluator(new Today());

      F.False.setEvaluator(NILEvaluator.CONST);
      F.True.setEvaluator(NILEvaluator.CONST);
      F.Null.setEvaluator(NILEvaluator.CONST);
    }
  }


  public static void initialize() {
    Initializer.init();
  }

  private ConstantDefinitions() {

  }

  private static class NILEvaluator extends AbstractSymbolEvaluator {

    static final NILEvaluator CONST = new NILEvaluator();

    @Override
    public IExpr numericEval(final ISymbol symbol, EvalEngine engine) {
      return F.NIL;
    }

    @Override
    public IExpr apfloatEval(ISymbol symbol, EvalEngine engine) {
      return F.NIL;
    }

    @Override
    public void setUp(final ISymbol newSymbol) {
      // don't set CONSTANT attribute !
    }
  }

  private static class $Context extends AbstractSymbolEvaluator {

    @Override
    public IExpr evaluate(final ISymbol symbol, EvalEngine engine) {
      return EvalEngine.get().getContextPath().currentCompleteContextName();
    }

  }

  private static class $ContextPath extends AbstractSymbolEvaluator {

    @Override
    public IExpr evaluate(final ISymbol symbol, EvalEngine engine) {
      return EvalEngine.get().getContextPath().pathAsStrings();
    }

  }

  private static class $CreationDate extends AbstractSymbolEvaluator {

    @Override
    public IExpr evaluate(final ISymbol symbol, EvalEngine engine) {
      return F.List(F.ZZ(YEAR), F.ZZ(MONTH), F.ZZ(DAY), F.ZZ(HOUR), F.ZZ(MINUTE), F.ZZ(SECOND));
    }
  }

//  private static class $HistoryLength extends AbstractSymbolEvaluator {
//
//    @Override
//    public IExpr evaluate(final ISymbol symbol, EvalEngine engine) {
//      EvalHistory history = engine.getEvalHistory();
//      if (history == null) {
//        return F.C0;
//      }
//      short historyLength = history.getHistoryLength();
//      if (historyLength == Short.MAX_VALUE) {
//        return F.CInfinity;
//      }
//      return F.ZZ(historyLength);
//    }
//
//    public IExpr evaluateSet(IExpr rightHandSide, boolean setDelayed, final EvalEngine engine) {
//      int iValue = rightHandSide.toIntDefault();
//      short historyLength;
//      if (iValue < 0) {
//        if (rightHandSide.isInfinity()) {
//          historyLength = Short.MAX_VALUE;
//        } else {
//          // Positive machine-sized integer expected at position `2` in `1`.
//          return IOFunctions.printMessage(
//              F.$HistoryLength,
//              "intpm",
//              F.List(F.C2, F.Set(F.$HistoryLength, rightHandSide)),
//              engine);
//        }
//      } else if (iValue < Short.MAX_VALUE) {
//        historyLength = (short) iValue;
//      } else {
//        historyLength = Short.MAX_VALUE;
//      }
//      IInteger value = F.ZZ(historyLength);
//      F.$HistoryLength.assignValue(value, setDelayed);
//      EvalHistory history = engine.getEvalHistory();
//      if (history == null) {
//        history = new EvalHistory(historyLength);
//        engine.setOutListDisabled(history);
//      } else {
//        history.setHistoryLength(historyLength);
//      }
//      return value;
//    }
//  }

  private static class $HomeDirectory extends AbstractSymbolEvaluator {

    @Override
    public IExpr evaluate(final ISymbol symbol, EvalEngine engine) {
      String userHome = System.getProperty("user.home");
      if (userHome == null) {
        return F.CEmptyString;
      }
      return F.stringx(userHome);
    }
  }

  private static class $IterationLimit extends AbstractSymbolEvaluator
      implements ISetValueEvaluator {

    @Override
    public IExpr evaluate(final ISymbol symbol, EvalEngine engine) {
      int iterationLimit = engine.getIterationLimit();
      if (symbol.hasAssignedSymbolValue()) {
        IExpr value = symbol.assignedValue();
        iterationLimit = value.toIntDefault();
        engine.setIterationLimit(iterationLimit);
      }

      return F.ZZ(iterationLimit);
    }

    public IExpr evaluateSet(IExpr rightHandSide, boolean setDelayed, final EvalEngine engine) {
      if (rightHandSide.isInfinity()) {
        S.$IterationLimit.assignValue(F.CN1, false);
        engine.setIterationLimit(-1);
        return rightHandSide;
      }
      int iterationLimit = rightHandSide.toIntDefault();
      if (iterationLimit < 20) {
        // Cannot set $IterationLimit to `1`; value must be Infinity or an integer at least 20.
        return IOFunctions.printMessage(S.$IterationLimit, "limset", F.List(rightHandSide), engine);
      }
      S.$IterationLimit.assignValue(F.ZZ(iterationLimit), setDelayed);
      engine.setIterationLimit(iterationLimit);
      return F.ZZ(iterationLimit);
    }
  }

//  private static class $Line extends AbstractSymbolEvaluator implements ISetValueEvaluator {
//
//    @Override
//    public IExpr evaluate(final ISymbol symbol, EvalEngine engine) {
//      EvalHistory history = engine.getEvalHistory();
//      if (history == null) {
//        return F.C0;
//      }
//      int line = history.getLineCounter();
//      return F.ZZ(line);
//    }
//
//    public IExpr evaluateSet(IExpr rightHandSide, boolean setDelayed, final EvalEngine engine) {
//      int line = rightHandSide.toIntDefault();
//      IInteger value = F.ZZ(line);
//      F.$Line.assignValue(value, setDelayed);
//      EvalHistory history = engine.getEvalHistory();
//      if (history == null) {
//        history = new EvalHistory((short) 100);
//        engine.setOutListDisabled(history);
//      }
//      history.resetLineCounter(line);
//      return value;
//    }
//  }

  private static class $MachineEpsilon extends AbstractSymbolEvaluator {

    @Override
    public IExpr evaluate(final ISymbol symbol, EvalEngine engine) {
      // System.out.println(Config.MACHINE_EPSILON);
      return F.num(Config.MACHINE_EPSILON);
    }

  }

  private static class $MachinePrecision extends AbstractSymbolEvaluator {

    @Override
    public IExpr evaluate(final ISymbol symbol, EvalEngine engine) {
      return F.ZZ(FEConfig.MACHINE_PRECISION);
    }
  }

  private static class $Packages extends AbstractSymbolEvaluator {

    @Override
    public IExpr evaluate(final ISymbol symbol, EvalEngine engine) {
      IASTAppendable result = F.ListAlloc(ContextPath.PACKAGES.size());
      for (String str : ContextPath.PACKAGES) {
        result.append(F.$str(str));
      }
      return result;
    }
  }

  private static class $Path extends AbstractSymbolEvaluator {

    @Override
    public IExpr evaluate(final ISymbol symbol, EvalEngine engine) {
      String path = System.getenv("PATH");
      if (path == null) {
        return F.CEmptyString;
      }
      return F.stringx(path);
    }
  }

  private static class $PathnameSeparator extends AbstractSymbolEvaluator {

    @Override
    public IExpr evaluate(final ISymbol symbol, EvalEngine engine) {
      return F.stringx(File.separator);
    }
  }

  private static class $RecursionLimit extends AbstractSymbolEvaluator
      implements ISetValueEvaluator {

    @Override
    public IExpr evaluate(final ISymbol symbol, EvalEngine engine) {
      int recursionLimit = engine.getRecursionLimit();
      if (symbol.hasAssignedSymbolValue()) {
        IExpr value = symbol.assignedValue();
        recursionLimit = value.toIntDefault();
        engine.setRecursionLimit(recursionLimit);
      }

      return F.ZZ(recursionLimit);
    }

    public IExpr evaluateSet(IExpr rightHandSide, boolean setDelayed, final EvalEngine engine) {
      if (rightHandSide.isInfinity()) {
        S.$RecursionLimit.assignValue(F.CN1, false);
        engine.setRecursionLimit(-1);
        return rightHandSide;
      }
      int recursionLimit = rightHandSide.toIntDefault();
      if (recursionLimit < 20) {
        // Cannot set $RecursionLimit to `1`; value must be Infinity or an integer at least 20.
        return IOFunctions.printMessage(S.$RecursionLimit, "limset", F.List(rightHandSide), engine);
      }
      S.$RecursionLimit.assignValue(F.ZZ(recursionLimit), setDelayed);
      engine.setRecursionLimit(recursionLimit);
      return F.ZZ(recursionLimit);
    }
  }

//  private static class $RootDirectory extends AbstractSymbolEvaluator {
//
//    @Override
//    public IExpr evaluate(final ISymbol symbol, EvalEngine engine) {
//      Path root =
//          Paths.get(System.getProperty("user.dir"))
//              .getFileSystem()
//              .getRootDirectories()
//              .iterator()
//              .next();
//      if (root == null) {
//        return F.stringx("/");
//      }
//      return F.stringx(root.toString());
//    }
//  }

  private static class $TemporaryDirectory extends AbstractSymbolEvaluator {

    @Override
    public IExpr evaluate(final ISymbol symbol, EvalEngine engine) {
      String tempDirectory = System.getProperty("java.io.tmpdir");
      if (tempDirectory == null) {
        return F.CEmptyString;
      }
      return F.stringx(tempDirectory);
    }
  }

  private static class $UserName extends AbstractSymbolEvaluator {

    @Override
    public IExpr evaluate(final ISymbol symbol, EvalEngine engine) {
      String userName = System.getProperty("user.name");
      if (userName == null) {
        return F.stringx("");
      }
      return F.stringx(userName);
    }

  }

  private static class $Version extends AbstractSymbolEvaluator {

    @Override
    public IExpr evaluate(final ISymbol symbol, EvalEngine engine) {
      return F.stringx(VERSION);
    }

  }

  /**
   *
   *
   * <blockquote>
   *
   * <p>Catalan's constant
   *
   * </blockquote>
   *
   * <p>See:
   *
   * <ul>
   *   <li><a href="http://en.wikipedia.org/wiki/Catalan%27s_constant">Wikipedia - Catalan's
   *       constant</a>
   * </ul>
   *
   * <h3>Examples</h3>
   *
   * <pre>
   * &gt;&gt; N(Catalan)
   * 0.915965594177219
   *
   * &gt;&gt; PolyGamma(1,1/4)
   * 8*Catalan+Pi^2
   * </pre>
   */
  private static class Catalan extends ISignedNumberConstantAbstractSymbolEvaluator {

    public static final double CATALAN = 0.91596559417721901505460351493238411077414937428167;

    @Override
    public void setUp(final ISymbol newSymbol) {
      newSymbol.setAttributes(ISymbol.CONSTANT | ISymbol.PROTECTED);
    }

    @Override
    public IExpr numericEval(final ISymbol symbol, EvalEngine engine) {
      return F.num(CATALAN);
    }

    @Override
    public double evalReal() {
      return CATALAN;
    }

  }

  /**
   * <pre>
   * ComplexInfinity
   * </pre>
   *
   * <blockquote>
   *
   * <p>represents an infinite complex quantity of undetermined direction.
   *
   * </blockquote>
   *
   * <h3>Examples</h3>
   *
   * <pre>
   * &gt;&gt; 1 / ComplexInfinity
   * 0
   *
   * &gt;&gt; ComplexInfinity + ComplexInfinity
   * ComplexInfinity
   *
   * &gt;&gt; ComplexInfinity * Infinity
   * ComplexInfinity
   *
   * &gt;&gt; FullForm(ComplexInfinity)
   * DirectedInfinity()
   * </pre>
   */
  private static class ComplexInfinity extends AbstractSymbolEvaluator {

    @Override
    public IExpr evaluate(final ISymbol symbol, EvalEngine engine) {
      return F.CComplexInfinity;
    }

    @Override
    public void setUp(final ISymbol newSymbol) {
      // don't set CONSTANT attribute !
    }
  }

  /**
   * <pre>
   * Degree
   * </pre>
   *
   * <blockquote>
   * <p>
   * the constant <code>Degree</code> converts angles from degree to <code>Pi/180</code> radians.
   * </p>
   * </blockquote>
   * <p>
   * See:
   * </p>
   * <ul>
   * <li><a href="http://en.wikipedia.org/wiki/Degree_(angle)">Wikipedia - Degree (angle)</a></li>
   * </ul>
   * <h3>Examples</h3>
   *
   * <pre>
   * &gt;&gt; Sin(30*Degree)
   * 1/2
   * </pre>
   * <p>
   * Degree has the value of Pi / 180
   * </p>
   *
   * <pre>
   * &gt;&gt; Degree == Pi / 180
   * True
   *
   * &gt;&gt; Cos(Degree(x))
   * Cos(Degree(x))
   *
   * &gt;&gt; N(Degree)
   * 0.017453292519943295
   * </pre>
   */
  private static class Degree extends ISignedNumberConstantAbstractSymbolEvaluator {
    public static final double DEGREE = 0.017453292519943295769236907684886127134428718885417;

    /** Constant Degree converted to Pi/180 */
    @Override
    public IExpr evaluate(final ISymbol symbol, EvalEngine engine) {
      return Times(F.Pi, Power(F.ZZ(180), F.CN1));
    }

    @Override
    public IExpr apfloatEval(ISymbol symbol, EvalEngine engine) {
      // Pi / 180
      Apfloat pi = ApfloatMath.pi(engine.getNumericPrecision());
      return F.num(pi.divide(new Apint(180)));
    }

    @Override
    public IExpr numericEval(final ISymbol symbol, EvalEngine engine) {
      return F.num(DEGREE);
    }

    @Override
    public double evalReal() {
      return DEGREE;
    }

    @Override
    public void setUp(final ISymbol newSymbol) {
      newSymbol.setAttributes(ISymbol.CONSTANT | ISymbol.PROTECTED);
    }
  }

  /**
   *
   *
   * <blockquote>
   *
   * <p>Euler's constant E
   *
   * </blockquote>
   *
   * <p><strong>Note</strong>: the upper case identifier <code>E</code> is different from the lower
   * case identifier <code>e</code>.
   *
   * <h3>Examples</h3>
   *
   * <pre>
   * &gt;&gt; Exp(1)
   * E
   *
   * &gt;&gt; N(E)
   * 2.718281828459045
   * </pre>
   */
  private static class E extends ISignedNumberConstantAbstractSymbolEvaluator {

    @Override
    public void setUp(final ISymbol newSymbol) {
      newSymbol.setAttributes(ISymbol.CONSTANT | ISymbol.PROTECTED);
    }

    @Override
    public IExpr numericEval(final ISymbol symbol, EvalEngine engine) {
      return F.num(Math.E);
    }

    @Override
    public IExpr apfloatEval(ISymbol symbol, EvalEngine engine) {
      return F.num(ApfloatMath.exp(new Apfloat(1, engine.getNumericPrecision())));
    }

    @Override
    public double evalReal() {
      return Math.E;
    }

  }

  /**
   * Euler gamma constant
   *
   * <p>See <a href="http://en.wikipedia.org/wiki/Euler–Mascheroni_constant">Euler– Mascheroni
   * constant</a>
   */
  private static class EulerGamma extends ISignedNumberConstantAbstractSymbolEvaluator {

    @Override
    public void setUp(final ISymbol newSymbol) {
      newSymbol.setAttributes(ISymbol.CONSTANT | ISymbol.PROTECTED);
    }

    @Override
    public IExpr numericEval(final ISymbol symbol, EvalEngine engine) {
      return F.num(EULER_GAMMA);
    }

    @Override
    public double evalReal() {
      return EULER_GAMMA;
    }

  }

  /**
   *
   *
   * <blockquote>
   *
   * <p>Glaisher constant.
   *
   * </blockquote>
   *
   * <p>The <code>Glaisher</code> constant is named after mathematicians James Whitbread Lee
   * Glaisher and Hermann Kinkelin. Its approximate value is: <code>1.2824271291...</code>
   *
   * <p>See:
   *
   * <ul>
   *   <li><a href="http://en.wikipedia.org/wiki/Glaisher-Kinkelin_constant">Wikipedia -
   *       Glaisher-Kinkelin constant</a>
   * </ul>
   */
  private static class Glaisher extends ISignedNumberConstantAbstractSymbolEvaluator {

    public static final double GLAISHER = 1.2824271291006226368753425688697917277676889273250;
    @Override
    public void setUp(final ISymbol newSymbol) {
      newSymbol.setAttributes(ISymbol.CONSTANT | ISymbol.PROTECTED);
    }

    @Override
    public IExpr numericEval(final ISymbol symbol, EvalEngine engine) {
      return F.num(GLAISHER);
    }

    @Override
    public double evalReal() {
      return GLAISHER;
    }

  }

  private static class GoldenAngle extends ISignedNumberConstantAbstractSymbolEvaluator {

    public static final double GOLDEN_ANGLE = 2.3999632297286533222315555066336138531249990110581;

    @Override
    public IExpr evaluate(final ISymbol symbol, EvalEngine engine) {
      // (3-Sqrt(5))*Pi
      // return F.Times(F.Subtract(F.C3, F.Sqrt(F.C5)), F.Pi);
      return F.NIL;
    }

    @Override
    public void setUp(final ISymbol newSymbol) {
      newSymbol.setAttributes(ISymbol.CONSTANT | ISymbol.PROTECTED);
    }

    @Override
    public IExpr apfloatEval(ISymbol symbol, EvalEngine engine) {
      // (3-Sqrt(5)) * Pi
      Apfloat pi = ApfloatMath.pi(engine.getNumericPrecision());
      Apfloat five = new Apfloat(5, engine.getNumericPrecision());
      return F.num(ApfloatMath.sqrt(five).negate().add(new Apint(3)).multiply(pi));
    }

    @Override
    public IExpr numericEval(final ISymbol symbol, EvalEngine engine) {
      return F.num(GOLDEN_ANGLE);
    }

    @Override
    public double evalReal() {
      return GOLDEN_ANGLE;
    }

  }

  /**
   * <pre>
   * GoldenRatio
   * </pre>
   *
   * <blockquote>
   * <p>
   * is the golden ratio.
   * </p>
   * </blockquote>
   * <p>
   * See:
   * </p>
   * <ul>
   * <li><a href="https://en.wikipedia.org/wiki/Golden_ratio">Wikipedia: Golden ratio</a></li>
   * </ul>
   * <h3>Examples</h3>
   *
   * <pre>
   * &gt;&gt; N(GoldenRatio)
   * 1.618033988749895
   * </pre>
   */
  private static class GoldenRatio extends ISignedNumberConstantAbstractSymbolEvaluator {

    public static final double GOLDEN_RATIO = 1.6180339887498948482045868343656381177203091798058;

    @Override
    public IExpr evaluate(final ISymbol symbol, EvalEngine engine) {
      // 1/2*(1+5^(1/2))
      // return F.Times(F.C1D2, F.Plus(F.C1, F.Power(F.integer(5), F.C1D2)));
      return F.NIL;
    }

    @Override
    public void setUp(final ISymbol newSymbol) {
      newSymbol.setAttributes(ISymbol.CONSTANT | ISymbol.PROTECTED);
    }

    @Override
    public IExpr apfloatEval(ISymbol symbol, EvalEngine engine) {
      // (1/2)*(1+Sqrt(5))
      Apfloat five = new Apfloat(5, engine.getNumericPrecision());
      Apfloat half = new Aprational(Apint.ONE, new Apint(2));
      return F.num(ApfloatMath.sqrt(five).add(Apfloat.ONE).multiply(half));
    }

    @Override
    public IExpr numericEval(final ISymbol symbol, EvalEngine engine) {
      return F.num(GOLDEN_RATIO);
    }

    @Override
    public double evalReal() {
      return GOLDEN_RATIO;
    }

  }

  /**
   * <pre>
   * I
   * </pre>
   *
   * <blockquote>
   * <p>
   * Imaginary unit - internally converted to the complex number <code>0+1*i</code>. <code>I</code> represents the
   * imaginary number <code>Sqrt(-1)</code>. <code>I^2</code> will be evaluated to <code>-1</code>.
   * </p>
   * </blockquote>
   * <p>
   * <strong>Note</strong>: the upper case identifier <code>I</code> is different from the lower case identifier
   * <code>i</code>.
   * </p>
   * <h3>Examples</h3>
   *
   * <pre>
   * &gt;&gt; I^2
   * -1
   *
   * &gt;&gt; (3+I)*(3-I)
   * 10
   * </pre>
   */
  private static class I extends AbstractSymbolEvaluator {

    @Override
    public void setUp(final ISymbol newSymbol) {
      newSymbol.setAttributes(ISymbol.CONSTANT | ISymbol.PROTECTED);
    }

    @Override
    public IExpr numericEval(final ISymbol symbol, EvalEngine engine) {
      return F.complexNum(0.0, 1.0);
    }

    @Override
    public IExpr evaluate(final ISymbol symbol, EvalEngine engine) {
      return F.complex(F.C0, F.C1);
    }
  }

  /**
   *
   *
   * <pre>
   * Infinity
   * </pre>
   *
   * <blockquote>
   *
   * <p>represents an infinite real quantity.
   *
   * </blockquote>
   *
   * <h3>Examples</h3>
   *
   * <pre>
   * &gt;&gt; 1 / Infinity
   * 0
   *
   * &gt;&gt; Infinity + 100
   * Infinity
   * </pre>
   * <p>
   * Use <code>Infinity</code> in sum and limit calculations:
   * </p>
   *
   * <pre>
   * &gt;&gt; Sum(1/x^2, {x, 1, Infinity})
   * Pi ^ 2 / 6
   *
   * &gt;&gt; FullForm(Infinity)
   * DirectedInfinity(1)
   *
   * &gt;&gt; (2 + 3.5*I) / Infinity
   * 0.0"
   *
   * &gt;&gt; Infinity + Infinity
   * Infinity
   * </pre>
   *
   * <p>Indeterminate expression <code>0</code> Infinity encountered.
   *
   * <pre>
   * &gt;&gt; Infinity / Infinity
   * Indeterminate
   * </pre>
   */
  private static class Infinity extends AbstractSymbolEvaluator {

    @Override
    public IExpr evaluate(final ISymbol symbol, EvalEngine engine) {
      return F.CInfinity;// unaryAST1(F.DirectedInfinity, F.C1);
    }

    @Override
    public void setUp(final ISymbol newSymbol) {
      // don't set CONSTANT attribute !
    }
  }

//  private static class Now extends AbstractSymbolEvaluator {
//
//    @Override
//    public IExpr evaluate(final ISymbol symbol, EvalEngine engine) {
//      return DateObjectExpr.newInstance(LocalDateTime.now());
//    }
//
//    @Override
//    public void setUp(final ISymbol newSymbol) {
//      // don't set CONSTANT attribute !
//    }
//  }
//
//  private static class Today extends AbstractSymbolEvaluator {
//
//    @Override
//    public IExpr evaluate(final ISymbol symbol, EvalEngine engine) {
//      LocalDateTime now = LocalDateTime.now();
//      return DateObjectExpr.newInstance(
//          LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 0, 0));
//    }
//
//    @Override
//    public void setUp(final ISymbol newSymbol) {
//      // don't set CONSTANT attribute !
//    }
//  }
  /**
   *
   *
   * <pre>
   * Khinchin
   * </pre>
   *
   * <blockquote>
   *
   * <p>Khinchin's constant
   *
   * </blockquote>
   *
   * <p>See:
   *
   * <ul>
   *   <li><a href="http://en.wikipedia.org/wiki/Khinchin%27s_constant">Wikipedia:Khinchin's
   *       constant</a>
   * </ul>
   *
   * <h3>Examples</h3>
   *
   * <pre>
   * &gt;&gt; N(Khinchin)
   * 2.6854520010653062
   * </pre>
   */
  private static class Khinchin extends ISignedNumberConstantAbstractSymbolEvaluator {

    public static final double KHINCHIN = 2.6854520010653064453097148354817956938203822939945;

    @Override
    public void setUp(final ISymbol newSymbol) {
      newSymbol.setAttributes(ISymbol.CONSTANT | ISymbol.PROTECTED);
    }

    @Override
    public IExpr numericEval(final ISymbol symbol, EvalEngine engine) {
      return F.num(KHINCHIN);
    }

    @Override
    public double evalReal() {
      return KHINCHIN;
    }

  }

  /**
   * <pre>
   * Pi
   * </pre>
   *
   * <blockquote>
   *
   * <p>is the constant <code>Pi</code>.
   *
   * </blockquote>
   *
   * <h3>Examples</h3>
   *
   * <pre>
   * &gt;&gt; N(Pi)
   * 3.141592653589793
   * </pre>
   */
  private static class Pi extends ISignedNumberConstantAbstractSymbolEvaluator {

    @Override
    public void setUp(final ISymbol newSymbol) {
      newSymbol.setAttributes(ISymbol.CONSTANT | ISymbol.PROTECTED);
    }

    @Override
    public IExpr numericEval(final ISymbol symbol, EvalEngine engine) {
      return F.num(Math.PI);
    }

    @Override
    public IExpr apfloatEval(ISymbol symbol, EvalEngine engine) {
      return F.num(ApfloatMath.pi(engine.getNumericPrecision()));
    }

    @Override
    public double evalReal() {
      return Math.PI;
    }

  }
}