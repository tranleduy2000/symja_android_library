package org.matheclipse.core.system;

import junit.framework.TestCase;

import org.matheclipse.core.eval.MMAConsole;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Test <code>org.matheclipse.core.eval.MMAConsole</code> app.
 * 
 * Configure <code>org.matheclipse.core.basic.Config.PARSER_USE_LOWERCASE_SYMBOLS = false;</code> in the sources for
 * running Symja in MMA mode, before running this test!
 */
public class MMAConsoleTestSingleRun extends TestCase {
	MMAConsole console;

	public MMAConsoleTestSingleRun(String name) {
		super(name);
	}

	private void check(String[] args, String result) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);

		console.main(args);

		System.out.flush();
		System.setOut(old);
		assertEquals(baos.toString(), //
				result);
	}

	/**
	 * The JUnit setup method
	 */
	@Override
	protected void setUp() {
		try {
			console = new MMAConsole();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void test001() {
		String[] args = new String[] { "-c", "D[Sin[x]^3,x]" };
		check(args, "3*Cos[x]*Sin[x]^2");
	}

	public void test002() {
		String[] args = new String[] { "-f", "Factorial", "-a", "20" };
		check(args, "2432902008176640000");
	}

	public void test003() {
		String[] args = new String[] { "-c", "f[x_,y_]:={x,y}; f[a,b]" };
		check(args, "{a,b}");
	}

	public void test004() {
		String[] args = new String[] { "-c", "Integrate[Sin[x]^2,x]" };
		check(args, "x/2-1/2*Cos[x]*Sin[x]");
	}
	
	public void test005() {
		String[] args = new String[] { "-c", "FullSimplify[Cosh[x]+Sinh[x]]" };
		check(args, "E^x");
	}
	
	public void testInput() {
		assertEquals("f[x]", console.interpreter("f[x]"));
		assertEquals("x/2-1/2*Cos[x]*Sin[x]", console.interpreter("Integrate[Sin[x]^2,x]"));
	}
	
	
}