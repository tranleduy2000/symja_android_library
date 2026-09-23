package org.matheclipse.core.system;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.RoundingMode;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.matheclipse.core.basic.Config;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.ExprEvaluator;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;

/**
 * An exact 3x3 <code>LinearSolve</code> whose entries are cosines of rational multiples of
 * <code>Pi</code> costs seconds and gigabytes of transient allocation.
 *
 * <p>
 * Measured here, on one JVM (M3 Ultra, JDK 11 target), for the <code>LinearSolve</code> call
 * itself - the test prints it:
 *
 * <pre>
 * as is                                              16.1 - 16.3 s
 * declining the GCD by MAX_CANCEL_GCD_TERM_PRODUCT     0.93 - 1.25 s, same roots
 * the same system approximated first                   0.004 s
 * </pre>
 *
 * The garbage collector is what keeps this merely slow. The same calculation through j2objc on an
 * iOS device, where nothing is collected until the evaluation returns, passed <b>8 GB</b> of
 * footprint after two and a half minutes and had still not finished; in the app it is killed by a
 * 3 GB memory monitor after 76 s.
 *
 * <p>
 * The system is the one a calculator produces from three equations in degrees:
 *
 * <pre>
 * Cos(35 Degree)*x - Cos(20 Degree)*y + z == Cos(-15 Degree)
 * Cos(45 Degree)*x - Cos(35 Degree)*y + z == Cos(-10 Degree)
 * Cos(60 Degree)*x - Cos(50 Degree)*y + z == Cos(-10 Degree)
 * </pre>
 *
 * Two of the nine entries collapse (<code>Cos(45 Degree)</code> to <code>1/Sqrt(2)</code>,
 * <code>Cos(60 Degree)</code> to <code>1/2</code>); the rest stay as cosines with no closed form. So
 * the LU decomposition runs over a field of unevaluated algebraic expressions.
 *
 * <p>
 * Where it goes, from a sampler on the running process:
 *
 * <pre>
 * LinearSolve → FieldLUDecomposition.Solver.solve → EvalEngine.evaluate
 *   → AlgebraUtil.togetherExpr → togetherPlus → AlgebraUtil.cancelGCD
 *     → GreatestCommonDivisorSubres.recursiveUnivariateGcd → PolyUtil.basePseudoDivide
 *       → GenPolynomial.multiply → IExpr.multiply → EvalEngine.evaluate → Expand → ...
 * </pre>
 *
 * The subresultant PRS does about <code>p1.length() * p2.length()</code> pseudo-remainder steps and
 * each one multiplies every coefficient. With numeric coefficients that is bignum arithmetic and
 * stays fast - {@link #testNumericLinearSolveIsCheap()} is the control, and it finishes in
 * milliseconds. Here a single coefficient multiplication is a whole
 * {@link EvalEngine#evaluate(IExpr)} whose result grows again at every step.
 *
 * <p>
 * Instrumented, the solve reaches that GCD 49 times. Forty-seven of them are a millisecond or two.
 * The 48th is handed 28 terms over 23 - five variables, total degree 3 - and spends <b>24
 * seconds</b> to report that the GCD is 1. The 49th is handed the same shape and does not come back:
 * measured on a phone it passed 8 GB of transient allocation after two and a half minutes and was
 * still running.
 *
 * <p>
 * {@link Config#MAX_CANCEL_GCD_LEAFCOUNT} does not bound it. That limit is 4000 and the call that
 * runs away is at a leaf count of 1281 - the size of the expression is not the size of the work.
 */
public class LinearSolveSubresultantGCDTest {

  /**
   * The matrix as <code>LinearSolve</code> receives it, already evaluated, so the test does not
   * depend on how <code>Degree</code> is normalised.
   */
  private static final String EXACT_MATRIX = "{{Cos(7/36*Pi),-Cos(Pi/9),1}," //
      + "{1/Sqrt(2),-Cos(7/36*Pi),1}," //
      + "{1/2,-Cos(5/18*Pi),1}}";

  private static final String EXACT_VECTOR = "{(1+Sqrt(3))/(2*Sqrt(2)),Cos(Pi/18),Cos(Pi/18)}";

  /** The solution, from a 50 digit LU solve of the same system. */
  private static final double[] EXPECTED_ROOTS =
      {0.63991519622033242272, 0.75145976466452541197, 1.1478791808063615053};

  /**
   * What the exact solve is given. Measured on one JVM it is 16.1 s without the
   * {@link Config#MAX_CANCEL_GCD_TERM_PRODUCT} guard and 0.93 s with it, so 5 s sits five times
   * above the one and three times below the other: a machine several times slower than this one
   * still passes, and the unguarded engine still fails.
   */
  private static final long BUDGET_SECONDS = 5;

  /**
   * Symja's static initialisation has nothing to do with what this test bounds, and it is not
   * small: 0.7 s in this module, 5.1 s in the Android build of the same sources. It happens once,
   * before any budget starts, so a budget measures the solve rather than the start-up.
   */
  @BeforeAll
  public static void awaitEngineInitialisation() throws InterruptedException {
    F.await();
  }

  @Test
  public void testExactLinearSolveFinishesWithinBudget() {
    double[] roots = solveWithin(BUDGET_SECONDS, EXACT_MATRIX, EXACT_VECTOR,
        "LinearSolve over exact trigonometric entries did not finish within " + BUDGET_SECONDS
            + " s. It is in the subresultant GCD of AlgebraUtil.cancelGCD, which is quadratic in"
            + " the term counts and re-enters the evaluator for every coefficient multiplication -"
            + " and which cannot be interrupted once it is running.");

    // The tolerance is wide on purpose: the symbolic roots are a 4000 character sum of products of
    // cosines and radicals, and evaluating that in double arithmetic loses about eight digits to
    // cancellation. 1e-6 is far above that and far below any wrong root.
    assertEquals(EXPECTED_ROOTS[0], roots[0], 1e-6);
    assertEquals(EXPECTED_ROOTS[1], roots[1], 1e-6);
    assertEquals(EXPECTED_ROOTS[2], roots[2], 1e-6);
  }

  /**
   * The same system with the entries approximated first. It reaches the same
   * <code>FieldLUDecomposition</code>, so what differs is only the coefficient ring - which is the
   * evidence that the cost above is the coefficients rather than the size of the system.
   */
  @Test
  public void testNumericLinearSolveIsCheap() {
    double[] roots = solveWithin(10, "N(" + EXACT_MATRIX + ")", "N(" + EXACT_VECTOR + ")",
        "The numeric solve of the same system did not finish either - the cost is not the"
            + " coefficient ring after all, and the analysis above is wrong.");

    assertEquals(EXPECTED_ROOTS[0], roots[0], 1e-9);
    assertEquals(EXPECTED_ROOTS[1], roots[1], 1e-9);
    assertEquals(EXPECTED_ROOTS[2], roots[2], 1e-9);
  }

  /**
   * Runs the solve on a thread of its own and fails with <code>message</code> if it has not
   * finished within <code>budgetSeconds</code>.
   *
   * <p>
   * A plain {@link Future#get(long, TimeUnit)} rather than
   * <code>Assertions.assertTimeoutPreemptively</code>, which needs <code>java.time</code> - not
   * available in every module this test is compiled for.
   *
   * <p>
   * The thread is a daemon because the calculation being bounded here <b>cannot be interrupted</b>:
   * JAS only tests the interrupt flag when it constructs a polynomial, so a runaway GCD outlives
   * the failure and would otherwise hold the JVM open.
   *
   * @return the three roots as doubles
   */
  private static double[] solveWithin(long budgetSeconds, String matrix, String vector,
      String message) {
    ExecutorService executor = Executors.newSingleThreadExecutor(runnable -> {
      Thread thread = new Thread(runnable, "LinearSolveSubresultantGCDTest");
      thread.setDaemon(true);
      return thread;
    });
    try {
      Future<double[]> solved = executor.submit(() -> solveAndApproximate(matrix, vector));
      return solved.get(budgetSeconds, TimeUnit.SECONDS);
    } catch (TimeoutException timedOut) {
      return fail(message);
    } catch (InterruptedException | ExecutionException failed) {
      throw new AssertionError(failed);
    } finally {
      executor.shutdownNow();
    }
  }

  /**
   * Solves on the calling thread and approximates the three roots.
   *
   * <p>
   * The engine is built here rather than in a field because {@link EvalEngine} is held per thread
   * and {@link #solveWithin} runs this on one of its own.
   *
   * @return the three roots as doubles
   */
  private static double[] solveAndApproximate(String matrix, String vector)
      throws InterruptedException {
    F.await();

    // The limits ExprEvaluatorTestCase installs. A smaller limit makes the engine decline earlier
    // and take a branch this test is not about.
    Config.MAX_AST_SIZE = 20000;
    Config.MAX_MATRIX_DIMENSION_SIZE = 100;
    Config.MAX_BIT_LENGTH = 200000;
    Config.MAX_POLYNOMIAL_DEGREE = 150;
    Config.MAX_PRECISION_APFLOAT = 512;
    Config.ROUNDING_MODE = RoundingMode.HALF_EVEN;

    boolean relaxedSyntax = true;
    EvalEngine engine = new EvalEngine(relaxedSyntax);
    EvalEngine.set(engine);
    engine.init();
    engine.setRecursionLimit(512);
    engine.setIterationLimit(500);
    ExprEvaluator evaluator = new ExprEvaluator(engine, false, (short) 100);

    long startedAt = System.nanoTime();
    IExpr result = evaluator.eval("LinearSolve(" + matrix + "," + vector + ")");
    // The class time surefire reports also carries F.await() and the engine init, so print the
    // solve on its own - it is the number the javadoc above quotes.
    System.out.println(String.format("LinearSolve took %.3f s",
        (System.nanoTime() - startedAt) / 1e9));

    assertTrue(result.isList() && result.size() == 4,
        () -> "expected a list of three roots, got " + result);
    IAST roots = (IAST) result;
    return new double[] {roots.get(1).evalf(), roots.get(2).evalf(), roots.get(3).evalf()};
  }
}
