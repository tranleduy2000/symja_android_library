package org.matheclipse.core.builtin;

import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;
import org.apfloat.Apint;
import org.apfloat.Aprational;
import org.matheclipse.core.basic.Config;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.interfaces.AbstractSymbolEvaluator;
import org.matheclipse.core.eval.interfaces.ISignedNumberConstantAbstractSymbolEvaluator;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.ISymbol;

import java.util.Calendar;
import java.util.Properties;

import ch.ethz.idsc.tensor.io.ResourceData;

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
	final static public double EULER_GAMMA = 0.57721566490153286060651209008240243104215933593992;
	/**
	 *
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
			F.$HomeDirectory.setEvaluator(new $HomeDirectory());
			F.$MachineEpsilon.setEvaluator(new $MachineEpsilon());
			F.$MachinePrecision.setEvaluator(new $MachinePrecision());
			F.$UserName.setEvaluator(new $UserName());
			F.$Version.setEvaluator(new $Version());

			// System.out.println(F.$CreationDate.of().toString());
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
		final static NILEvaluator CONST = new NILEvaluator();

		@Override
		public IExpr numericEval(final ISymbol symbol) {
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
		public IExpr evaluate(final ISymbol symbol) {
			return EvalEngine.get().getContextPath().currentCompleteContextName();
		}

	}

	private static class $ContextPath extends AbstractSymbolEvaluator {

		@Override
		public IExpr evaluate(final ISymbol symbol) {
			return EvalEngine.get().getContextPath().pathAsStrings();
		}

	}

	private static class $CreationDate extends AbstractSymbolEvaluator {

		@Override
		public IExpr evaluate(final ISymbol symbol) {
			return F.List(F.ZZ(YEAR), F.ZZ(MONTH), F.ZZ(DAY), F.ZZ(HOUR), F.ZZ(MINUTE), F.ZZ(SECOND));
		}

	}

	private static class $HomeDirectory extends AbstractSymbolEvaluator {

		@Override
		public IExpr evaluate(final ISymbol symbol) {
			String userHome = System.getProperty("user.home");
			if (userHome == null) {
				return F.stringx("");
			}
			return F.stringx(userHome);
		}

	}
	private static class $MachineEpsilon extends AbstractSymbolEvaluator {

		@Override
		public IExpr evaluate(final ISymbol symbol) {
			// System.out.println(Config.MACHINE_EPSILON);
			return F.num(Config.MACHINE_EPSILON);
		}

	}

	private static class $MachinePrecision extends AbstractSymbolEvaluator {

		@Override
		public IExpr evaluate(final ISymbol symbol) {
			return F.ZZ(Config.MACHINE_PRECISION);
		}

	}

	private static class $UserName extends AbstractSymbolEvaluator {

		@Override
		public IExpr evaluate(final ISymbol symbol) {
			String userName = System.getProperty("user.name");
			if (userName == null) {
				return F.stringx("");
			}
			return F.stringx(userName);
		}

	}
	private static class $Version extends AbstractSymbolEvaluator {

		@Override
		public IExpr evaluate(final ISymbol symbol) {
			return F.stringx(VERSION);
		}

	}
	/**
	 * <blockquote>
	 * <p>
	 * Catalan's constant
	 * </p>
	 * </blockquote>
	 * <p>
	 * See:
	 * </p>
	 * <ul>
	 * <li><a href="http://en.wikipedia.org/wiki/Catalan%27s_constant">Wikipedia - Catalan's constant</a></li>
	 * </ul>
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
		final static public double CATALAN = 0.91596559417721901505460351493238411077414937428167;

		@Override
		public void setUp(final ISymbol newSymbol) {
			newSymbol.setAttributes(ISymbol.CONSTANT | ISymbol.PROTECTED);
		}

		@Override
		public IExpr numericEval(final ISymbol symbol) {
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
	 * <p>
	 * represents an infinite complex quantity of undetermined direction.
	 * </p>
	 * </blockquote>
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
		public IExpr evaluate(final ISymbol symbol) {
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
		final static public double DEGREE = 0.017453292519943295769236907684886127134428718885417;

		/**
		 * Constant Degree converted to Pi/180
		 */
		@Override
		public IExpr evaluate(final ISymbol symbol) {
			return Times(F.Pi, Power(F.ZZ(180), F.CN1));
		}

		@Override
		public IExpr apfloatEval(ISymbol symbol, EvalEngine engine) {
			// Pi / 180
			Apfloat pi = ApfloatMath.pi(engine.getNumericPrecision());
			return F.num(pi.divide(new Apint(180)));
		}

		@Override
		public IExpr numericEval(final ISymbol symbol) {
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
	 * <blockquote>
	 * <p>
	 * Euler's constant E
	 * </p>
	 * </blockquote>
	 * <p>
	 * <strong>Note</strong>: the upper case identifier <code>E</code> is different from the lower case identifier
	 * <code>e</code>.
	 * </p>
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
			newSymbol.setAttributes(ISymbol.CONSTANT);
		}

		@Override
		public IExpr numericEval(final ISymbol symbol) {
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
	 * See <a href="http://en.wikipedia.org/wiki/Euler–Mascheroni_constant">Euler– Mascheroni constant</a>
	 */
	private static class EulerGamma extends ISignedNumberConstantAbstractSymbolEvaluator {
		final static public double EULER_GAMMA = 0.57721566490153286060651209008240243104215933593992;

		@Override
		public void setUp(final ISymbol newSymbol) {
			newSymbol.setAttributes(ISymbol.CONSTANT);
		}

		@Override
		public IExpr numericEval(final ISymbol symbol) {
			return F.num(EULER_GAMMA);
		}

		@Override
		public double evalReal() {
			return EULER_GAMMA;
		}

	}

	/**
	 * <blockquote>
	 * <p>
	 * Glaisher constant.
	 * </p>
	 * </blockquote>
	 * <p>
	 * The <code>Glaisher</code> constant is named after mathematicians James Whitbread Lee Glaisher and Hermann
	 * Kinkelin. Its approximate value is: <code>1.2824271291...</code>
	 * </p>
	 * <p>
	 * See:
	 * </p>
	 * <ul>
	 * <li><a href="http://en.wikipedia.org/wiki/Glaisher-Kinkelin_constant">Wikipedia - Glaisher-Kinkelin
	 * constant</a></li>
	 * </ul>
	 */
	private static class Glaisher extends ISignedNumberConstantAbstractSymbolEvaluator {
		final static public double GLAISHER = 1.2824271291006226368753425688697917277676889273250;

		@Override
		public void setUp(final ISymbol newSymbol) {
			newSymbol.setAttributes(ISymbol.CONSTANT | ISymbol.PROTECTED);
		}

		@Override
		public IExpr numericEval(final ISymbol symbol) {
			return F.num(GLAISHER);
		}

		@Override
		public double evalReal() {
			return GLAISHER;
		}

	}

	private static class GoldenAngle extends ISignedNumberConstantAbstractSymbolEvaluator {
		final static public double GOLDEN_ANGLE =  2.3999632297286533222315555066336138531249990110581;
		@Override
		public IExpr evaluate(final ISymbol symbol) {
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
		public IExpr numericEval(final ISymbol symbol) {
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
		final static public double GOLDEN_RATIO = 1.6180339887498948482045868343656381177203091798058;

		@Override
		public IExpr evaluate(final ISymbol symbol) {
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
		public IExpr numericEval(final ISymbol symbol) {
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
		public IExpr numericEval(final ISymbol symbol) {
			return F.complexNum(0.0, 1.0);
		}

		@Override
		public IExpr evaluate(final ISymbol symbol) {
			return F.complex(F.C0, F.C1);
		}
	}

	/**
	 * <pre>
	 * Infinity
	 * </pre>
	 *
	 * <blockquote>
	 * <p>
	 * represents an infinite real quantity.
	 * </p>
	 * </blockquote>
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
	 * <p>
	 * Indeterminate expression <code>0</code> Infinity encountered.
	 * </p>
	 *
	 * <pre>
	 * &gt;&gt; Infinity / Infinity
	 * Indeterminate
	 * </pre>
	 */
	private static class Infinity extends AbstractSymbolEvaluator {

		@Override
		public IExpr evaluate(final ISymbol symbol) {
			return F.CInfinity;// unaryAST1(F.DirectedInfinity, F.C1);
		}

		@Override
		public void setUp(final ISymbol newSymbol) {
			// don't set CONSTANT attribute !
		}
	}

	/**
	 * <pre>
	 * Khinchin
	 * </pre>
	 *
	 * <blockquote>
	 * <p>
	 * Khinchin's constant
	 * </p>
	 * </blockquote>
	 * <p>
	 * See:
	 * </p>
	 * <ul>
	 * <li><a href="http://en.wikipedia.org/wiki/Khinchin%27s_constant">Wikipedia:Khinchin's constant</a></li>
	 * </ul>
	 * <h3>Examples</h3>
	 *
	 * <pre>
	 * &gt;&gt; N(Khinchin)
	 * 2.6854520010653062
	 * </pre>
	 */
	private static class Khinchin extends ISignedNumberConstantAbstractSymbolEvaluator {
		final static public double KHINCHIN = 2.6854520010653064453097148354817956938203822939945;

		@Override
		public void setUp(final ISymbol newSymbol) {
			newSymbol.setAttributes(ISymbol.CONSTANT | ISymbol.PROTECTED);
		}

		@Override
		public IExpr numericEval(final ISymbol symbol) {
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
	 * <p>
	 * is the constant <code>Pi</code>.
	 * </p>
	 * </blockquote>
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
		public IExpr numericEval(final ISymbol symbol) {
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