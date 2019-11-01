package org.matheclipse.core.reflection.system;

import com.duy.lambda.BiFunction;
import com.duy.lambda.Predicate;
import com.gx.common.cache.CacheBuilder;

import org.matheclipse.core.basic.Config;
import org.matheclipse.core.builtin.Algebra;
import org.matheclipse.core.builtin.NumberTheory;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.exception.AbortException;
import org.matheclipse.core.eval.exception.FailedException;
import org.matheclipse.core.eval.exception.RecursionLimitExceeded;
import org.matheclipse.core.eval.interfaces.AbstractFunctionEvaluator;
import org.matheclipse.core.expression.ASTSeriesData;
import org.matheclipse.core.expression.ContextPath;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.integrate.rubi.UtilityFunctionCtors;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IASTAppendable;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.core.patternmatching.RulesData;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

import static org.matheclipse.core.expression.F.Divide;
import static org.matheclipse.core.expression.F.Integrate;
import static org.matheclipse.core.expression.F.List;
import static org.matheclipse.core.expression.F.Log;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Times;

/**
 * <pre>
 * Integrate(f, x)
 * </pre>
 * 
 * <blockquote>
 * <p>
 * integrates <code>f</code> with respect to <code>x</code>. The result does not contain the additive integration
 * constant.
 * </p>
 * </blockquote>
 * 
 * <pre>
 * Integrate(f, {x,a,b})
 * </pre>
 * 
 * <blockquote>
 * <p>
 * computes the definite integral of <code>f</code> with respect to <code>x</code> from <code>a</code> to
 * <code>b</code>.
 * </p>
 * </blockquote>
 * <p>
 * See: <a href="https://en.wikipedia.org/wiki/Integral">Wikipedia: Integral</a>
 * </p>
 * <h3>Examples</h3>
 * 
 * <pre>
 * &gt;&gt; Integrate(x^2, x)
 * x^3/3
 * 
 * &gt;&gt; Integrate(Tan(x) ^ 5, x)
 * -Log(Cos(x))-Tan(x)^2/2+Tan(x)^4/4
 * </pre>
 */
public class Integrate extends AbstractFunctionEvaluator {
	private static Thread INIT_THREAD = null;

	private final static CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(1);

	/**
	 * Causes the current thread to wait until the INIT_THREAD has initialized the Integrate() rules.
	 *
	 */
	public final void await() throws InterruptedException {
		COUNT_DOWN_LATCH.await();
	}

	/**
	 * 
	 * See <a href="https://pangin.pro/posts/computation-in-static-initializer">Beware of computation in static
	 * initializer</a>
	 */
	public static class IntegrateInitializer implements Runnable {

		@Override
		public void run() {
			// long start = System.currentTimeMillis();
			if (!INTEGRATE_RULES_READ) {
				INTEGRATE_RULES_READ = true;
				final EvalEngine engine = EvalEngine.get();
				ContextPath path = engine.getContextPath();
				try {
					engine.getContextPath().add(org.matheclipse.core.expression.Context.RUBI);
					getUtilityFunctionsRuleASTRubi45();
					getRuleASTStatic();
				} finally {
					engine.setContextPath(path);
				}
				// F.Integrate.setEvaluator(CONST);
				engine.setPackageMode(false);
				// long stop = System.currentTimeMillis();
				// System.out.println("Milliseconds: " + (stop - start));
				COUNT_DOWN_LATCH.countDown();
			}
		}

		private static synchronized void getRuleASTStatic() {
			INTEGRATE_RULES_DATA = F.Integrate.createRulesData(new int[] { 0, 7000 });
			getRuleASTRubi45();

			ISymbol[] rubiSymbols = { F.Derivative, F.D };
			for (int i = 0; i < rubiSymbols.length; i++) {
				INT_RUBI_FUNCTIONS.add(rubiSymbols[i]);
			}
		}

		private static void getUtilityFunctionsRuleASTRubi45() {
			org.matheclipse.core.integrate.rubi.UtilityFunctions0.initialize();
			org.matheclipse.core.integrate.rubi.UtilityFunctions1.initialize();
			org.matheclipse.core.integrate.rubi.UtilityFunctions2.initialize();
			org.matheclipse.core.integrate.rubi.UtilityFunctions3.initialize();
			org.matheclipse.core.integrate.rubi.UtilityFunctions4.initialize();
			org.matheclipse.core.integrate.rubi.UtilityFunctions5.initialize();
			org.matheclipse.core.integrate.rubi.UtilityFunctions6.initialize();
			org.matheclipse.core.integrate.rubi.UtilityFunctions7.initialize();
			org.matheclipse.core.integrate.rubi.UtilityFunctions8.initialize();
			org.matheclipse.core.integrate.rubi.UtilityFunctions9.initialize();
			org.matheclipse.core.integrate.rubi.UtilityFunctions10.initialize();
			org.matheclipse.core.integrate.rubi.UtilityFunctions11.initialize();
			org.matheclipse.core.integrate.rubi.UtilityFunctions12.initialize();
			org.matheclipse.core.integrate.rubi.UtilityFunctions13.initialize();
			org.matheclipse.core.integrate.rubi.UtilityFunctions14.initialize();
			org.matheclipse.core.integrate.rubi.UtilityFunctions15.initialize();
			org.matheclipse.core.integrate.rubi.UtilityFunctions16.initialize();
			org.matheclipse.core.integrate.rubi.UtilityFunctions17.initialize();
			org.matheclipse.core.integrate.rubi.UtilityFunctions18.initialize();
			org.matheclipse.core.integrate.rubi.UtilityFunctions19.initialize();
			org.matheclipse.core.integrate.rubi.UtilityFunctions20.initialize();
			org.matheclipse.core.integrate.rubi.UtilityFunctions21.initialize();
			org.matheclipse.core.integrate.rubi.UtilityFunctions22.initialize();
			org.matheclipse.core.integrate.rubi.UtilityFunctions23.initialize();
			org.matheclipse.core.integrate.rubi.UtilityFunctions24.initialize();
			org.matheclipse.core.integrate.rubi.UtilityFunctions25.initialize();
			org.matheclipse.core.integrate.rubi.UtilityFunctions26.initialize();
			org.matheclipse.core.integrate.rubi.UtilityFunctions27.initialize();
			org.matheclipse.core.integrate.rubi.UtilityFunctions28.initialize();
			org.matheclipse.core.integrate.rubi.UtilityFunctions29.initialize();
			org.matheclipse.core.integrate.rubi.UtilityFunctions30.initialize();
			org.matheclipse.core.integrate.rubi.UtilityFunctions31.initialize(); 
			
			// org.matheclipse.core.integrate.rubi.UtilityFunctions.init();
		}

		private static void getRuleASTRubi45() {

			org.matheclipse.core.integrate.rubi.IntRules0.initialize();
			org.matheclipse.core.integrate.rubi.IntRules1.initialize();
			org.matheclipse.core.integrate.rubi.IntRules2.initialize();
			org.matheclipse.core.integrate.rubi.IntRules3.initialize();
			org.matheclipse.core.integrate.rubi.IntRules4.initialize();
			org.matheclipse.core.integrate.rubi.IntRules5.initialize();
			org.matheclipse.core.integrate.rubi.IntRules6.initialize();
			org.matheclipse.core.integrate.rubi.IntRules7.initialize();
			org.matheclipse.core.integrate.rubi.IntRules8.initialize();
			org.matheclipse.core.integrate.rubi.IntRules9.initialize();
			org.matheclipse.core.integrate.rubi.IntRules10.initialize();
			org.matheclipse.core.integrate.rubi.IntRules11.initialize();
			org.matheclipse.core.integrate.rubi.IntRules12.initialize();
			org.matheclipse.core.integrate.rubi.IntRules13.initialize();
			org.matheclipse.core.integrate.rubi.IntRules14.initialize();
			org.matheclipse.core.integrate.rubi.IntRules15.initialize();
			org.matheclipse.core.integrate.rubi.IntRules16.initialize();
			org.matheclipse.core.integrate.rubi.IntRules17.initialize();
			org.matheclipse.core.integrate.rubi.IntRules18.initialize();
			org.matheclipse.core.integrate.rubi.IntRules19.initialize();
			org.matheclipse.core.integrate.rubi.IntRules20.initialize();
			org.matheclipse.core.integrate.rubi.IntRules21.initialize();
			org.matheclipse.core.integrate.rubi.IntRules22.initialize();
			org.matheclipse.core.integrate.rubi.IntRules23.initialize();
			org.matheclipse.core.integrate.rubi.IntRules24.initialize();
			org.matheclipse.core.integrate.rubi.IntRules25.initialize();
			org.matheclipse.core.integrate.rubi.IntRules26.initialize();
			org.matheclipse.core.integrate.rubi.IntRules27.initialize();
			org.matheclipse.core.integrate.rubi.IntRules28.initialize();
			org.matheclipse.core.integrate.rubi.IntRules29.initialize();
			org.matheclipse.core.integrate.rubi.IntRules30.initialize();
			org.matheclipse.core.integrate.rubi.IntRules31.initialize();
			org.matheclipse.core.integrate.rubi.IntRules32.initialize();
			org.matheclipse.core.integrate.rubi.IntRules33.initialize();
			org.matheclipse.core.integrate.rubi.IntRules34.initialize();
			org.matheclipse.core.integrate.rubi.IntRules35.initialize();
			org.matheclipse.core.integrate.rubi.IntRules36.initialize();
			org.matheclipse.core.integrate.rubi.IntRules37.initialize();
			org.matheclipse.core.integrate.rubi.IntRules38.initialize();
			org.matheclipse.core.integrate.rubi.IntRules39.initialize();
			org.matheclipse.core.integrate.rubi.IntRules40.initialize();
			org.matheclipse.core.integrate.rubi.IntRules41.initialize();
			org.matheclipse.core.integrate.rubi.IntRules42.initialize();
			org.matheclipse.core.integrate.rubi.IntRules43.initialize();
			org.matheclipse.core.integrate.rubi.IntRules44.initialize();
			org.matheclipse.core.integrate.rubi.IntRules45.initialize();
			org.matheclipse.core.integrate.rubi.IntRules46.initialize();
			org.matheclipse.core.integrate.rubi.IntRules47.initialize();
			org.matheclipse.core.integrate.rubi.IntRules48.initialize();
			org.matheclipse.core.integrate.rubi.IntRules49.initialize();
			org.matheclipse.core.integrate.rubi.IntRules50.initialize();
			org.matheclipse.core.integrate.rubi.IntRules51.initialize();
			org.matheclipse.core.integrate.rubi.IntRules52.initialize();
			org.matheclipse.core.integrate.rubi.IntRules53.initialize();
			org.matheclipse.core.integrate.rubi.IntRules54.initialize();
			org.matheclipse.core.integrate.rubi.IntRules55.initialize();
			org.matheclipse.core.integrate.rubi.IntRules56.initialize();
			org.matheclipse.core.integrate.rubi.IntRules57.initialize();
			org.matheclipse.core.integrate.rubi.IntRules58.initialize();
			org.matheclipse.core.integrate.rubi.IntRules59.initialize();
			org.matheclipse.core.integrate.rubi.IntRules60.initialize();
			org.matheclipse.core.integrate.rubi.IntRules61.initialize();
			org.matheclipse.core.integrate.rubi.IntRules62.initialize();
			org.matheclipse.core.integrate.rubi.IntRules63.initialize();
			org.matheclipse.core.integrate.rubi.IntRules64.initialize();
			org.matheclipse.core.integrate.rubi.IntRules65.initialize();
			org.matheclipse.core.integrate.rubi.IntRules66.initialize();
			org.matheclipse.core.integrate.rubi.IntRules67.initialize();
			org.matheclipse.core.integrate.rubi.IntRules68.initialize();
			org.matheclipse.core.integrate.rubi.IntRules69.initialize();
			org.matheclipse.core.integrate.rubi.IntRules70.initialize();
			org.matheclipse.core.integrate.rubi.IntRules71.initialize();
			org.matheclipse.core.integrate.rubi.IntRules72.initialize();
			org.matheclipse.core.integrate.rubi.IntRules73.initialize();
			org.matheclipse.core.integrate.rubi.IntRules74.initialize();
			org.matheclipse.core.integrate.rubi.IntRules75.initialize();
			org.matheclipse.core.integrate.rubi.IntRules76.initialize();
			org.matheclipse.core.integrate.rubi.IntRules77.initialize();
			org.matheclipse.core.integrate.rubi.IntRules78.initialize();
			org.matheclipse.core.integrate.rubi.IntRules79.initialize();
			org.matheclipse.core.integrate.rubi.IntRules80.initialize();
			org.matheclipse.core.integrate.rubi.IntRules81.initialize();
			org.matheclipse.core.integrate.rubi.IntRules82.initialize();
			org.matheclipse.core.integrate.rubi.IntRules83.initialize();
			org.matheclipse.core.integrate.rubi.IntRules84.initialize();
			org.matheclipse.core.integrate.rubi.IntRules85.initialize();
			org.matheclipse.core.integrate.rubi.IntRules86.initialize();
			org.matheclipse.core.integrate.rubi.IntRules87.initialize();
			org.matheclipse.core.integrate.rubi.IntRules88.initialize();
			org.matheclipse.core.integrate.rubi.IntRules89.initialize();
			org.matheclipse.core.integrate.rubi.IntRules90.initialize();
			org.matheclipse.core.integrate.rubi.IntRules91.initialize();
			org.matheclipse.core.integrate.rubi.IntRules92.initialize();
			org.matheclipse.core.integrate.rubi.IntRules93.initialize();
			org.matheclipse.core.integrate.rubi.IntRules94.initialize();
			org.matheclipse.core.integrate.rubi.IntRules95.initialize();
			org.matheclipse.core.integrate.rubi.IntRules96.initialize();
			org.matheclipse.core.integrate.rubi.IntRules97.initialize();
			org.matheclipse.core.integrate.rubi.IntRules98.initialize();
			org.matheclipse.core.integrate.rubi.IntRules99.initialize();
			org.matheclipse.core.integrate.rubi.IntRules100.initialize();
			org.matheclipse.core.integrate.rubi.IntRules101.initialize();
			org.matheclipse.core.integrate.rubi.IntRules102.initialize();
			org.matheclipse.core.integrate.rubi.IntRules103.initialize();
			org.matheclipse.core.integrate.rubi.IntRules104.initialize();
			org.matheclipse.core.integrate.rubi.IntRules105.initialize();
			org.matheclipse.core.integrate.rubi.IntRules106.initialize();
			org.matheclipse.core.integrate.rubi.IntRules107.initialize();
			org.matheclipse.core.integrate.rubi.IntRules108.initialize();
			org.matheclipse.core.integrate.rubi.IntRules109.initialize();
			org.matheclipse.core.integrate.rubi.IntRules110.initialize();
			org.matheclipse.core.integrate.rubi.IntRules111.initialize();
			org.matheclipse.core.integrate.rubi.IntRules112.initialize();
			org.matheclipse.core.integrate.rubi.IntRules113.initialize();
			org.matheclipse.core.integrate.rubi.IntRules114.initialize();
			org.matheclipse.core.integrate.rubi.IntRules115.initialize();
			org.matheclipse.core.integrate.rubi.IntRules116.initialize();
			org.matheclipse.core.integrate.rubi.IntRules117.initialize();
			org.matheclipse.core.integrate.rubi.IntRules118.initialize();
			org.matheclipse.core.integrate.rubi.IntRules119.initialize();
			org.matheclipse.core.integrate.rubi.IntRules120.initialize();
			org.matheclipse.core.integrate.rubi.IntRules121.initialize();
			org.matheclipse.core.integrate.rubi.IntRules122.initialize();
			org.matheclipse.core.integrate.rubi.IntRules123.initialize();
			org.matheclipse.core.integrate.rubi.IntRules124.initialize();
			org.matheclipse.core.integrate.rubi.IntRules125.initialize();
			org.matheclipse.core.integrate.rubi.IntRules126.initialize();
			org.matheclipse.core.integrate.rubi.IntRules127.initialize();
			org.matheclipse.core.integrate.rubi.IntRules128.initialize();
			org.matheclipse.core.integrate.rubi.IntRules129.initialize();
			org.matheclipse.core.integrate.rubi.IntRules130.initialize();
			org.matheclipse.core.integrate.rubi.IntRules131.initialize();
			org.matheclipse.core.integrate.rubi.IntRules132.initialize();
			org.matheclipse.core.integrate.rubi.IntRules133.initialize();
			org.matheclipse.core.integrate.rubi.IntRules134.initialize();
			org.matheclipse.core.integrate.rubi.IntRules135.initialize();
			org.matheclipse.core.integrate.rubi.IntRules136.initialize();
			org.matheclipse.core.integrate.rubi.IntRules137.initialize();
			org.matheclipse.core.integrate.rubi.IntRules138.initialize();
			org.matheclipse.core.integrate.rubi.IntRules139.initialize();
			org.matheclipse.core.integrate.rubi.IntRules140.initialize();
			org.matheclipse.core.integrate.rubi.IntRules141.initialize();
			org.matheclipse.core.integrate.rubi.IntRules142.initialize();
			org.matheclipse.core.integrate.rubi.IntRules143.initialize();
			org.matheclipse.core.integrate.rubi.IntRules144.initialize();
			org.matheclipse.core.integrate.rubi.IntRules145.initialize();
			org.matheclipse.core.integrate.rubi.IntRules146.initialize();
			org.matheclipse.core.integrate.rubi.IntRules147.initialize();
			org.matheclipse.core.integrate.rubi.IntRules148.initialize();
			org.matheclipse.core.integrate.rubi.IntRules149.initialize();
			org.matheclipse.core.integrate.rubi.IntRules150.initialize();
			org.matheclipse.core.integrate.rubi.IntRules151.initialize();
			org.matheclipse.core.integrate.rubi.IntRules152.initialize();
			org.matheclipse.core.integrate.rubi.IntRules153.initialize();
			org.matheclipse.core.integrate.rubi.IntRules154.initialize();
			org.matheclipse.core.integrate.rubi.IntRules155.initialize();
			org.matheclipse.core.integrate.rubi.IntRules156.initialize();
			org.matheclipse.core.integrate.rubi.IntRules157.initialize();
			org.matheclipse.core.integrate.rubi.IntRules158.initialize();
			org.matheclipse.core.integrate.rubi.IntRules159.initialize();
			org.matheclipse.core.integrate.rubi.IntRules160.initialize();
			org.matheclipse.core.integrate.rubi.IntRules161.initialize();
			org.matheclipse.core.integrate.rubi.IntRules162.initialize();
			org.matheclipse.core.integrate.rubi.IntRules163.initialize();
			org.matheclipse.core.integrate.rubi.IntRules164.initialize();
			org.matheclipse.core.integrate.rubi.IntRules165.initialize();
			org.matheclipse.core.integrate.rubi.IntRules166.initialize();
			org.matheclipse.core.integrate.rubi.IntRules167.initialize();
			org.matheclipse.core.integrate.rubi.IntRules168.initialize();
			org.matheclipse.core.integrate.rubi.IntRules169.initialize();
			org.matheclipse.core.integrate.rubi.IntRules170.initialize();
			org.matheclipse.core.integrate.rubi.IntRules171.initialize();
			org.matheclipse.core.integrate.rubi.IntRules172.initialize();
			org.matheclipse.core.integrate.rubi.IntRules173.initialize();
			org.matheclipse.core.integrate.rubi.IntRules174.initialize();
			org.matheclipse.core.integrate.rubi.IntRules175.initialize();
			org.matheclipse.core.integrate.rubi.IntRules176.initialize();
			org.matheclipse.core.integrate.rubi.IntRules177.initialize();
			org.matheclipse.core.integrate.rubi.IntRules178.initialize();
			org.matheclipse.core.integrate.rubi.IntRules179.initialize();
			org.matheclipse.core.integrate.rubi.IntRules180.initialize();
			org.matheclipse.core.integrate.rubi.IntRules181.initialize();
			org.matheclipse.core.integrate.rubi.IntRules182.initialize();
			org.matheclipse.core.integrate.rubi.IntRules183.initialize();
			org.matheclipse.core.integrate.rubi.IntRules184.initialize();
			org.matheclipse.core.integrate.rubi.IntRules185.initialize();
			org.matheclipse.core.integrate.rubi.IntRules186.initialize();
			org.matheclipse.core.integrate.rubi.IntRules187.initialize();
			org.matheclipse.core.integrate.rubi.IntRules188.initialize();
			org.matheclipse.core.integrate.rubi.IntRules189.initialize();
			org.matheclipse.core.integrate.rubi.IntRules190.initialize();
			org.matheclipse.core.integrate.rubi.IntRules191.initialize();
			org.matheclipse.core.integrate.rubi.IntRules192.initialize();
			org.matheclipse.core.integrate.rubi.IntRules193.initialize();
			org.matheclipse.core.integrate.rubi.IntRules194.initialize();
			org.matheclipse.core.integrate.rubi.IntRules195.initialize();
			org.matheclipse.core.integrate.rubi.IntRules196.initialize();
			org.matheclipse.core.integrate.rubi.IntRules197.initialize();
			org.matheclipse.core.integrate.rubi.IntRules198.initialize();
			org.matheclipse.core.integrate.rubi.IntRules199.initialize();
			
			org.matheclipse.core.integrate.rubi.IntRules200.initialize();
			org.matheclipse.core.integrate.rubi.IntRules201.initialize();
			org.matheclipse.core.integrate.rubi.IntRules202.initialize();
			org.matheclipse.core.integrate.rubi.IntRules203.initialize();
			org.matheclipse.core.integrate.rubi.IntRules204.initialize();
			org.matheclipse.core.integrate.rubi.IntRules205.initialize();
			org.matheclipse.core.integrate.rubi.IntRules206.initialize();
			org.matheclipse.core.integrate.rubi.IntRules207.initialize();
			org.matheclipse.core.integrate.rubi.IntRules208.initialize();
			org.matheclipse.core.integrate.rubi.IntRules209.initialize();
			org.matheclipse.core.integrate.rubi.IntRules210.initialize();
			org.matheclipse.core.integrate.rubi.IntRules211.initialize();
			org.matheclipse.core.integrate.rubi.IntRules212.initialize();
			org.matheclipse.core.integrate.rubi.IntRules213.initialize();
			org.matheclipse.core.integrate.rubi.IntRules214.initialize();
			org.matheclipse.core.integrate.rubi.IntRules215.initialize();
			org.matheclipse.core.integrate.rubi.IntRules216.initialize();
			org.matheclipse.core.integrate.rubi.IntRules217.initialize();
			org.matheclipse.core.integrate.rubi.IntRules218.initialize();
			org.matheclipse.core.integrate.rubi.IntRules219.initialize();
			org.matheclipse.core.integrate.rubi.IntRules220.initialize();
			org.matheclipse.core.integrate.rubi.IntRules221.initialize();
			org.matheclipse.core.integrate.rubi.IntRules222.initialize();
			org.matheclipse.core.integrate.rubi.IntRules223.initialize();
			org.matheclipse.core.integrate.rubi.IntRules224.initialize();
			org.matheclipse.core.integrate.rubi.IntRules225.initialize();
			org.matheclipse.core.integrate.rubi.IntRules226.initialize();
			org.matheclipse.core.integrate.rubi.IntRules227.initialize();
			org.matheclipse.core.integrate.rubi.IntRules228.initialize();
			org.matheclipse.core.integrate.rubi.IntRules229.initialize();
			org.matheclipse.core.integrate.rubi.IntRules230.initialize();
			org.matheclipse.core.integrate.rubi.IntRules231.initialize();
			org.matheclipse.core.integrate.rubi.IntRules232.initialize();
			org.matheclipse.core.integrate.rubi.IntRules233.initialize();
			org.matheclipse.core.integrate.rubi.IntRules234.initialize();
			org.matheclipse.core.integrate.rubi.IntRules235.initialize();
			org.matheclipse.core.integrate.rubi.IntRules236.initialize();
			org.matheclipse.core.integrate.rubi.IntRules237.initialize();
			org.matheclipse.core.integrate.rubi.IntRules238.initialize();
			org.matheclipse.core.integrate.rubi.IntRules239.initialize();
			org.matheclipse.core.integrate.rubi.IntRules240.initialize();
			org.matheclipse.core.integrate.rubi.IntRules241.initialize();
			org.matheclipse.core.integrate.rubi.IntRules242.initialize();
			org.matheclipse.core.integrate.rubi.IntRules243.initialize();
			org.matheclipse.core.integrate.rubi.IntRules244.initialize();
			org.matheclipse.core.integrate.rubi.IntRules245.initialize();
			org.matheclipse.core.integrate.rubi.IntRules246.initialize();
			org.matheclipse.core.integrate.rubi.IntRules247.initialize();
			org.matheclipse.core.integrate.rubi.IntRules248.initialize();
			org.matheclipse.core.integrate.rubi.IntRules249.initialize();
			org.matheclipse.core.integrate.rubi.IntRules250.initialize();
			org.matheclipse.core.integrate.rubi.IntRules251.initialize();
			org.matheclipse.core.integrate.rubi.IntRules252.initialize();
			org.matheclipse.core.integrate.rubi.IntRules253.initialize();
			org.matheclipse.core.integrate.rubi.IntRules254.initialize();
			org.matheclipse.core.integrate.rubi.IntRules255.initialize();
			org.matheclipse.core.integrate.rubi.IntRules256.initialize();
			org.matheclipse.core.integrate.rubi.IntRules257.initialize();
			org.matheclipse.core.integrate.rubi.IntRules258.initialize();
			org.matheclipse.core.integrate.rubi.IntRules259.initialize();
			org.matheclipse.core.integrate.rubi.IntRules260.initialize();
			org.matheclipse.core.integrate.rubi.IntRules261.initialize();
			org.matheclipse.core.integrate.rubi.IntRules262.initialize();
			org.matheclipse.core.integrate.rubi.IntRules263.initialize();
			org.matheclipse.core.integrate.rubi.IntRules264.initialize();
			org.matheclipse.core.integrate.rubi.IntRules265.initialize();
			org.matheclipse.core.integrate.rubi.IntRules266.initialize();
			org.matheclipse.core.integrate.rubi.IntRules267.initialize();
			org.matheclipse.core.integrate.rubi.IntRules268.initialize();
			org.matheclipse.core.integrate.rubi.IntRules269.initialize();
		}
	}

	public static RulesData INTEGRATE_RULES_DATA;
	/**
	 * Constructor for the singleton
	 */
	public final static Integrate CONST = new Integrate();

	public final static Set<ISymbol> INT_RUBI_FUNCTIONS = new HashSet<ISymbol>();

	public final static Set<IExpr> DEBUG_EXPR = new HashSet<IExpr>(64);

	public static volatile boolean INTEGRATE_RULES_READ = false;

	public Integrate() {
	}

	@Override
	public IExpr evaluate(final IAST holdallAST, final EvalEngine engine) {
		try {
			await();
		} catch (InterruptedException e) {
		}
		boolean evaled = false;
		IExpr result;
		boolean numericMode = engine.isNumericMode();
		try {
			engine.setNumericMode(false);
			if (holdallAST.size() < 3) {
				return F.NIL;
			}
			final IExpr a1 = NumberTheory.rationalize(holdallAST.arg1()).orElse(holdallAST.arg1());
			IExpr arg1 = engine.evaluateNull(a1);
			if (arg1.isPresent()) {
				evaled = true;
			} else {
				arg1 = a1;
			}
			if (arg1.isIndeterminate()) {
				return F.Indeterminate;
			}
			if (holdallAST.size() > 3) {
				// reduce arguments by folding Integrate[fxy, x, y] to
				// Integrate[Integrate[fxy, y], x] ...
				return holdallAST.foldRight(new BiFunction<IExpr, IExpr, IExpr>() {
					@Override
					public IExpr apply(IExpr x, IExpr y) {
						return engine.evaluate(F.Integrate(x, y));
					}
				}, arg1, 2);
			}

			IExpr arg2 = engine.evaluateNull(holdallAST.arg2());
			if (arg2.isPresent()) {
				evaled = true;
			} else {
				arg2 = holdallAST.arg2();
			}
			if (arg2.isList()) {
				IAST xList = (IAST) arg2;
				if (xList.isVector() == 3) {
					// Integrate[f[x], {x,a,b}]
					IAST copy = holdallAST.setAtCopy(2, xList.arg1());
					IExpr temp = engine.evaluate(copy);
					if (temp.isFreeAST(F.Integrate)) {
						return definiteIntegral(temp, xList, engine);
					}
				}
				return F.NIL;
			}
			if (arg1.isList() && arg2.isSymbol()) {
				return mapIntegrate((IAST) arg1, arg2);
			}

			final IASTAppendable ast = holdallAST.setAtClone(1, arg1);
			ast.set(2, arg2);
			final IExpr x = ast.arg2();

			if (arg1.isNumber()) {
				// Integrate[x_?NumberQ,y_Symbol] -> x*y
				return Times(arg1, x);
			}
			if (arg1 instanceof ASTSeriesData) {
				ASTSeriesData series = ((ASTSeriesData) arg1);
				if (series.getX().equals(x)) {
					final IExpr temp = ((ASTSeriesData) arg1).integrate(x);
					if (temp != null) {
						return temp;
					}
				}
				return F.NIL;
			}
			if (arg1.isFree(x, true)) {
				// Integrate[x_,y_Symbol] -> x*y /; FreeQ[x,y]
				return Times(arg1, x);
			}
			if (arg1.equals(x)) {
				// Integrate[x_,x_Symbol] -> x^2 / 2
				return Times(F.C1D2, Power(arg1, F.C2));
			}
			boolean showSteps = false;
			if (showSteps) {
				System.out.println("\nINTEGRATE: " + arg1.toString());
				if (DEBUG_EXPR.contains(arg1)) {
					// System.exit(-1);
				}
				DEBUG_EXPR.add(arg1);
			}
			if (arg1.isAST()) {
				final IAST fx = (IAST) arg1;
				if (fx.topHead().equals(x)) {
					// issue #91
					return F.NIL;
				}

				result = integrateByRubiRules(fx, x, ast, engine);
				if (result.isPresent()) {
					return result;
				}

				if (arg1.isTimes()) {
					IAST[] temp = ((IAST) arg1).filter(new Predicate<IExpr>() {
						@Override
						public boolean test(IExpr arg) {
							return arg.isFree(x);
						}
					});
					IExpr free = temp[0].oneIdentity1();
					if (!free.isOne()) {
						IExpr rest = temp[1].oneIdentity1();
						// Integrate[free_ * rest_,x_Symbol] -> free*Integrate[rest, x] /; FreeQ[free,x]
						return Times(free, Integrate(rest, x));
					}
				}

				if (fx.isPower()) {
					// base ^ exponent
					IExpr base = fx.base();
					IExpr exponent = fx.exponent();
					if (base.equals(x) && exponent.isFree(x)) {
						if (exponent.isMinusOne()) {
							// Integrate[ 1 / x_ , x_ ] -> Log[x]
							return Log(x);
						}
						// Integrate[ x_ ^n_ , x_ ] -> x^(n+1)/(n+1) /; FreeQ[n, x]
						IExpr temp = Plus(F.C1, exponent);
						return Divide(Power(x, temp), temp);
					}
					if (exponent.equals(x) && base.isFree(x)) {
						if (base.isE()) {
							// E^x
							return arg1;
						}
						// a^x / Log(a)
						return F.Divide(fx, F.Log(base));
					}
				}

				result = callRestIntegrate(fx, x, engine);
				if (result.isPresent()) {
					return result;
				}

			}
			return evaled ? ast : F.NIL;
		} finally {
			engine.setNumericMode(numericMode);
		}
	}

	/**
	 * <p>
	 * Given a <code>function</code> of a real variable <code>x</code> and an interval <code>[a, b]</code> of the real
	 * line, calculate the definite integral <code>F(b)-F(a)</code>.
	 * </p>
	 * <a href="https://en.wikipedia.org/wiki/Integral">Wikipedia - Integral</a>
	 *
	 * @param function
	 *            a function of <code>x</code>
	 * @param xValueList
	 *            a list of the form <code>{x,a,b}</code> with <code>3</code> arguments
	 * @param engine
	 *            the evaluation engine
	 * @return
	 */
	private static IExpr definiteIntegral(IExpr function, IAST xValueList, EvalEngine engine) {
		IExpr x = xValueList.arg1();
		IExpr a = xValueList.arg2();
		IExpr b = xValueList.arg3();
		IExpr Fb = engine.evaluate(F.Limit(function, F.Rule(x, b)));
		IExpr Fa = engine.evaluate(F.Limit(function, F.Rule(x, a)));
		if (!Fb.isFree(F.DirectedInfinity, true) || !Fb.isFree(F.Indeterminate, true)) {
			return engine.printMessage("Not integrable: " + function + " for limit " + x + " -> " + b);
		}
		if (!Fa.isFree(F.DirectedInfinity, true) || !Fa.isFree(F.Indeterminate, true)) {
			return engine.printMessage("Not integrable: " + function + " for limit " + x + " -> " + a);
		}
		if (a.isNegativeResult() && b.isPositiveResult()) {
			// 0 is a value inside he given interval
			IExpr FZero = engine.evaluate(F.Limit(function, F.Rule(x, F.C0)));
			if (!FZero.isFree(F.DirectedInfinity, true) || !FZero.isFree(F.Indeterminate, true)) {
				return F.Plus(F.Subtract(Fb, FZero), F.Subtract(FZero, Fa));
			}
		}
		if (Fb.isAST() && Fa.isAST()) {
			IExpr bDenominator = F.Denominator.of(engine, Fb);
			IExpr aDenominator = F.Denominator.of(engine, Fa);
			if (bDenominator.equals(aDenominator)) {
				return F.Divide(F.Subtract(F.Numerator(Fb), F.Numerator(Fa)), bDenominator);
			}
		}
		return F.Subtract(Fb, Fa);
	}
	private static IExpr callRestIntegrate(IAST arg1, final IExpr x, final EvalEngine engine) {
		IExpr fxExpanded = F.expand(arg1, false, false, false);
		if (fxExpanded.isAST()) {
			if (fxExpanded.isPlus()) {
				return mapIntegrate((IAST) fxExpanded, x);
			}

			final IAST arg1AST = (IAST) fxExpanded;
			if (arg1AST.isTimes()) {
				// Integrate[a_*y_,x_Symbol] -> a*Integrate[y,x] /; FreeQ[a,x]
				IASTAppendable filterCollector = F.TimesAlloc(arg1AST.size());
				IASTAppendable restCollector = F.TimesAlloc(arg1AST.size());
				arg1AST.filter(filterCollector, restCollector, new Predicate<IExpr>() {
					@Override
					public boolean test(IExpr input) {
						return input.isFree(x, true);
					}
				});
				if (filterCollector.size() > 1) {
					if (restCollector.size() > 1) {
						filterCollector.append(F.Integrate(restCollector.oneIdentity0(), x));
					}
					return filterCollector;
				}

				// IExpr temp = integrateTimesTrigFunctions(arg1AST, x);
				// if (temp.isPresent()) {
				// return temp;
				// }
			}

			if (arg1AST.size() >= 3 && arg1AST.isFree(F.Integrate) && arg1AST.isPlusTimesPower()) {
				if (!arg1AST.isEvalFlagOn(IAST.IS_DECOMPOSED_PARTIAL_FRACTION) && x.isSymbol()) {
					IExpr[] parts = Algebra.fractionalParts(arg1, true);
					if (parts != null) {
						IExpr temp = Algebra.partsApart(parts, x, engine);
						if (temp.isPresent() && !temp.equals(arg1)) {
							if (temp.isPlus()) {
								return mapIntegrate((IAST) temp, x);
							}
							// return F.Integrate(temp, x);
							// return mapIntegrate((IAST) temp, x);
						}
						// if (temp.isPlus()) {
						// return mapIntegrate((IAST) temp, x);
						// }
						// return Algebra.partialFractionDecompositionRational(new
						// PartialFractionIntegrateGenerator(x),parts, x);
					}
				}
			}
		}
		if (arg1.isTrigFunction()||arg1.isHyperbolicFunction()) {
			// https://github.com/RuleBasedIntegration/Rubi/issues/12
			IExpr temp = engine.evaluate(F.TrigToExp(arg1));
			return engine.evaluate(F.Integrate(temp, x));
		}
		return F.NIL;
	}

	/**
	 * Map <code>Integrate</code> on <code>ast</code>. Examples:
	 * <ul>
	 * <li><code>Integrate[{a_, b_,...},x_] -> {Integrate[a,x], Integrate[b,x], ...}</code> or</li>
	 * <li><code>Integrate[a_+b_+...,x_] -> Integrate[a,x]+Integrate[b,x]+...</code></li>
	 * </ul>
	 * 
	 * @param ast
	 *            a <code>List(...)</code> or <code>Plus(...)</code> ast
	 * @param x
	 *            the integ ration veariable
	 * @return
	 */
	private static IExpr mapIntegrate(IAST ast, final IExpr x) {
		return ast.mapThread(F.Integrate(null, x), 1);
	}


	/**
	 * See <a href="http://en.wikipedia.org/wiki/Integration_by_parts">Wikipedia- Integration by parts</a>
	 * 
	 * @param ast
	 *            TODO - not used
	 * @param arg1
	 * @param symbol
	 * 
	 * @return
	 */
	private static IExpr integratePolynomialByParts(IAST ast, final IAST arg1, IExpr symbol, EvalEngine engine) {
		IASTAppendable fTimes = F.TimesAlloc(arg1.size());
		IASTAppendable gTimes = F.TimesAlloc(arg1.size());
		collectPolynomialTerms(arg1, symbol, gTimes, fTimes);
		IExpr g = gTimes.oneIdentity1();
		IExpr f = fTimes.oneIdentity1();
		// conflicts with Rubi 4.5 integration rules
		// only call integrateByParts for simple Times() expressions
		if (f.isOne() || g.isOne()) {
			return F.NIL;
		}
		return integrateByParts(f, g, symbol, engine);
	}

	/**
	 * Use the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi - Symbolic Integration Rules</a> to integrate the
	 * expression.
	 * 
	 * @param ast
	 * @return
	 */
	private static IExpr integrateByRubiRules(IAST arg1, IExpr x, IAST ast, EvalEngine engine) {
		// EvalEngine engine = EvalEngine.get();
		int limit = engine.getRecursionLimit();
		boolean quietMode = engine.isQuietMode();
		ISymbol head = arg1.topHead();

		if (head.isNumericFunctionAttribute() || INT_RUBI_FUNCTIONS.contains(head)
				|| head.getSymbolName().startsWith("§")) {

			boolean newCache = false;
			try {

				if (engine.REMEMBER_AST_CACHE != null) {
					IExpr result = engine.REMEMBER_AST_CACHE.getIfPresent(ast);
					if (result != null) {// &&engine.getRecursionCounter()>0) {
						if (result.isPresent()) {
							return result;
						}
						return callRestIntegrate(arg1, x, engine);
					}
				} else {
					newCache = true;
					engine.REMEMBER_AST_CACHE = CacheBuilder.newBuilder().maximumSize(50).build();
				}
				try {
					engine.setQuietMode(true);
					if (limit <= 0 || limit > Config.INTEGRATE_RUBI_RULES_RECURSION_LIMIT) {
						engine.setRecursionLimit(Config.INTEGRATE_RUBI_RULES_RECURSION_LIMIT);
					}

					// System.out.println(ast.toString());
					engine.REMEMBER_AST_CACHE.put(ast, F.NIL);
					IExpr temp = F.Integrate.evalDownRule(EvalEngine.get(), ast);
					if (temp.isPresent()) {
						engine.REMEMBER_AST_CACHE.put(ast, temp);
						return temp;
					}
				} catch (RecursionLimitExceeded rle) {
					// engine.printMessage("Integrate(Rubi recursion): " + Config.INTEGRATE_RUBI_RULES_RECURSION_LIMIT
					// + " exceeded: " + ast.toString());
					engine.setRecursionLimit(limit);
					return engine.printMessage("Integrate(Rubi recursion): " + rle.getMessage());
				} catch (RuntimeException rex) {
					if (Config.SHOW_STACKTRACE) {
						rex.printStackTrace();
					}
					engine.setRecursionLimit(limit);
					return engine.printMessage("Integrate Rubi recursion limit "
							+ Config.INTEGRATE_RUBI_RULES_RECURSION_LIMIT + " RuntimeException: " + ast.toString());

				}

			} catch (AbortException ae) {
				if (Config.DEBUG) {
					ae.printStackTrace();
				}
			} catch (final FailedException fe) {
				if (Config.DEBUG) {
					fe.printStackTrace();
				}
			} finally {
				engine.setRecursionLimit(limit);
				if (newCache) {
					engine.REMEMBER_AST_CACHE = null;
				}
				engine.setQuietMode(quietMode);
			}
		}
		return F.NIL;
	}

	/**
	 * <p>
	 * Integrate by parts rule: <code>Integrate(f'(x) * g(x), x) = f(x) * g(x) - Integrate(f(x) * g'(x),x )</code> .
	 * </p>
	 * 
	 * See <a href="http://en.wikipedia.org/wiki/Integration_by_parts">Wikipedia- Integration by parts</a>
	 * 
	 * @param f
	 *            <code>f(x)</code>
	 * @param g
	 *            <code>g(x)</code>
	 * @param x
	 * @return <code>f(x) * g(x) - Integrate(f(x) * g'(x),x )</code>
	 */
	private static IExpr integrateByParts(IExpr f, IExpr g, IExpr x, EvalEngine engine) {
		int limit = engine.getRecursionLimit();
		try {
			if (limit <= 0 || limit > Config.INTEGRATE_BY_PARTS_RECURSION_LIMIT) {
				engine.setRecursionLimit(Config.INTEGRATE_BY_PARTS_RECURSION_LIMIT);
			}
			IExpr firstIntegrate = engine.evaluate(F.Integrate(f, x));
			if (!firstIntegrate.isFreeAST(Integrate)) {
				return F.NIL;
			}
			IExpr gDerived = F.eval(F.D(g, x));
			IExpr second2Integrate = F.eval(F.Integrate(F.Times(gDerived, firstIntegrate), x));
			if (!second2Integrate.isFreeAST(Integrate)) {
				return F.NIL;
			}
			return F.eval(F.Subtract(F.Times(g, firstIntegrate), second2Integrate));
		} catch (RecursionLimitExceeded rle) {
			engine.setRecursionLimit(limit);
		} finally {
			engine.setRecursionLimit(limit);
		}
		return F.NIL;
	}

	/**
	 * Collect all found polynomial terms into <code>polyTimes</code> and the rest into <code>restTimes</code>.
	 * 
	 * @param timesAST
	 *            an AST representing a <code>Times[...]</code> expression.
	 * @param symbol
	 * @param polyTimes
	 *            the polynomial terms part
	 * @param restTimes
	 *            the non-polynomil terms part
	 */
	private static void collectPolynomialTerms(final IAST timesAST, IExpr symbol, IASTAppendable polyTimes,
			IASTAppendable restTimes) {
		IExpr temp;
		for (int i = 1; i < timesAST.size(); i++) {
			temp = timesAST.get(i);
			if (temp.isFree(symbol, true)) {
				polyTimes.append(temp);
				continue;
			} else if (temp.equals(symbol)) {
				polyTimes.append(temp);
				continue;
			} else if (temp.isPolynomial(List(symbol))) {
				polyTimes.append(temp);
				continue;
			}
			restTimes.append(temp);
		}
	}

	@Override
	public void setUp(final ISymbol newSymbol) {
		newSymbol.setAttributes(ISymbol.HOLDALL);
		super.setUp(newSymbol);

		if (Config.THREAD_FACTORY != null) {
			INIT_THREAD = Config.THREAD_FACTORY.newThread(new IntegrateInitializer());
		} else {
			INIT_THREAD = new Thread(new IntegrateInitializer());
		}

		if (Config.JAS_NO_THREADS) {
			INIT_THREAD.run();
		} else {
			INIT_THREAD.start();
		}

		F.ISet(F.$s("§simplifyflag"), F.False);

		F.ISet(F.$s("§$timelimit"), F.ZZ(Config.INTEGRATE_RUBI_TIMELIMIT));
		F.ISet(F.$s("§$showsteps"), F.False);
		UtilityFunctionCtors.ReapList.setAttributes(ISymbol.HOLDFIRST);
		F.ISet(F.$s("§$trigfunctions"), F.List(F.Sin, F.Cos, F.Tan, F.Cot, F.Sec, F.Csc));
		F.ISet(F.$s("§$hyperbolicfunctions"), F.List(F.Sinh, F.Cosh, F.Tanh, F.Coth, F.Sech, F.Csch));
		F.ISet(F.$s("§$inversetrigfunctions"), F.List(F.ArcSin, F.ArcCos, F.ArcTan, F.ArcCot, F.ArcSec, F.ArcCsc));
		F.ISet(F.$s("§$inversehyperbolicfunctions"),
				F.List(F.ArcSinh, F.ArcCosh, F.ArcTanh, F.ArcCoth, F.ArcSech, F.ArcCsch));
		F.ISet(F.$s("§$calculusfunctions"), F.List(F.D, F.Sum, F.Product, F.Integrate, F.$rubi("Unintegrable"),
				F.$rubi("CannotIntegrate"), F.$rubi("Dif"), F.$rubi("Subst")));
		F.ISet(F.$s("§$stopfunctions"), F.List(F.Hold, F.HoldForm, F.Defer, F.Pattern, F.If, F.Integrate,
				F.$rubi("Unintegrable"), F.$rubi("CannotIntegrate")));
		F.ISet(F.$s("§$heldfunctions"), F.List(F.Hold, F.HoldForm, F.Defer, F.Pattern));

		F.ISet(UtilityFunctionCtors.IntegerPowerQ, //
				F.Function(F.And(F.SameQ(F.Head(F.Slot1), F.Power), F.IntegerQ(F.Part(F.Slot1, F.C2)))));

		F.ISet(UtilityFunctionCtors.FractionalPowerQ, //
				F.Function(
						F.And(F.SameQ(F.Head(F.Slot1), F.Power), F.SameQ(F.Head(F.Part(F.Slot1, F.C2)), F.Rational))));
	}

}