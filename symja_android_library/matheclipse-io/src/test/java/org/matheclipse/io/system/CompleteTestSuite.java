package org.matheclipse.io.system;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.matheclipse.io.form.mathml.MathMLPresentationTestCase;
import org.matheclipse.io.form.tex.BasicTeXTestCase;
import org.matheclipse.io.test.BracketBalancerTestCase;
import org.matheclipse.io.test.ParserTestCase;
import org.matheclipse.io.test.RelaxedParserTestCase;
import org.matheclipse.io.test.eval.EvalDoubleCallbackTestCase;

/**
 * General test suite. Starts all other tests.
 */
public class CompleteTestSuite extends TestCase {

	public CompleteTestSuite(String name) {
		super(name);
	}

	/**
	 * A unit test suite
	 * 
	 * @return The test suite
	 */
	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(NumberTheoryTestCase.class);
		suite.addTestSuite(ASCIIPrintTest.class);
		suite.addTestSuite(SVGGraphicsTestCase.class);
//		suite.addTestSuite(Graphics3DTestCase.class);
//		suite.addTestSuite(SymjifyTestCase.class);
		suite.addTestSuite(BasicPatternPropertiesTestCase.class);
		suite.addTestSuite(CompareToTestCase.class);
		suite.addTestSuite(PatternMatchingTestCase.class);
		suite.addTestSuite(CombinatoricTestCase.class);

		suite.addTestSuite(MathMLPresentationTestCase.class);
		suite.addTestSuite(BasicTeXTestCase.class);

		suite.addTestSuite(LastCalculationsHistoryTest.class);
		suite.addTestSuite(ExpandTestCase.class);

		suite.addTestSuite(OpenFixedSizeMapTest.class);
		suite.addTestSuite(NumberTest.class);
		suite.addTestSuite(JavaFormTestCase.class);

		suite.addTestSuite(MainTestCase.class);
		suite.addTestSuite(LowercaseTestCase.class);
		suite.addTestSuite(RubiIntegrationTest.class);
		suite.addTestSuite(DistributionTest.class);
		suite.addTestSuite(SeriesTest.class);
		suite.addTestSuite(SerializableTest.class);
		suite.addTestSuite(PatternsTest.class);
		
		suite.addTestSuite(ParserTestCase.class);
		suite.addTestSuite(RelaxedParserTestCase.class);
		suite.addTestSuite(BracketBalancerTestCase.class);
		suite.addTestSuite(EvalDoubleCallbackTestCase.class);
		suite.addTestSuite(ExprEvaluatorTest.class);

//		suite.addTestSuite(ConsoleTestCase.class);
		suite.addTestSuite(AssumptionTestCase.class);
		suite.addTestSuite(WXFTestCase.class);
		suite.addTestSuite(IntegerTestCase.class);

		// suite.addTestSuite(ArcTanTest.class);
		// suite.addTestSuite(BooleanTest.class);
		// suite.addTestSuite(CachedTest.class);
		// suite.addTestSuite(CompatibleTest.class);
		// suite.addTestSuite(GraphFunctionsTest.class);
		// suite.addTestSuite(NumericTest.class);
		// suite.addTestSuite(ParseNumberTest.class);
		// suite.addTestSuite(ToStringTest.class);

		return suite;

	}

	/**
	 * Run all tests in a swing GUI
	 * 
	 * @param args
	 *            Description of Parameter
	 */
	// public static void main(String args[]) {
	// junit.swingui.TestRunner.run(CompleteTestSuite.class);
	// }
}
