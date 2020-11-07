package org.matheclipse.io.test.eval;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AllEvalTests extends TestCase {
	public AllEvalTests(String name) {
		super(name);
	}

	public static Test suite() {
		TestSuite s = new TestSuite();

		s.addTestSuite(EvalDoubleCallbackTestCase.class);
		return s;
	}

}
