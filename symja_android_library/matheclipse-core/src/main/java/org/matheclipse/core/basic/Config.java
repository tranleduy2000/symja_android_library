package org.matheclipse.core.basic;

import com.gx.common.cache.Cache;
import com.gx.common.cache.CacheBuilder;

import org.hipparchus.util.Precision;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.ISymbol;

import java.util.HashSet;
import java.util.Set;

/**
 * General configuration settings.
 */
public class Config {

	public static final String SYMJA = //
			"" //
					+ "     _______.____    ____ .___  ___.        __       ___      \n"
					+ "    /       |\\   \\  /   / |   \\/   |       |  |     /   \\     \n"
					+ "   |   (----` \\   \\/   /  |  \\  /  |       |  |    /  ^  \\    \n"
					+ "    \\   \\      \\_    _/   |  |\\/|  | .--.  |  |   /  /_\\  \\   \n"
					+ ".----)   |       |  |     |  |  |  | |  `--'  |  /  _____  \\  \n"
					+ "|_______/        |__|     |__|  |__|  \\______/  /__/     \\__\\ \n"
					+ "                                                              \n";

	/**
	 * A global expression cache which compares keys with <code>==</code> object identity instead of
	 * <code>equals()</code>. The keys and values are weak references.
	 */
	public static Cache<IExpr, Object> EXPR_CACHE;

	private static final int MAX_EXPR_CACHE_SIZE = 10000;

	/**
	 * Maximum number for the leaf count of an expression so that <code>Factor()</code> will try a factoring
	 */
	public static final int MAX_FACTOR_LEAFCOUNT = 600;

	/**
	 * Maximum number for the leaf count of an expression so that <code>Simplify()</code> will try calling
	 * <code>Factor()</code>.
	 */
	public static final int MAX_SIMPLIFY_FACTOR_LEAFCOUNT = 50;

	/**
	 * Maximum number for the leaf count of an expression so that <code>Simplify()</code> will try calling
	 * <code>Apart()</code>.
	 */
	public static final int MAX_SIMPLIFY_APART_LEAFCOUNT = 50;

	/**
	 * Maximum number for the leaf count of an expression so that <code>Simplify()</code> will try calling
	 * <code>Together()</code>.
	 */
	public static final int MAX_SIMPLIFY_TOGETHER_LEAFCOUNT = 65;
	static {
		EXPR_CACHE = CacheBuilder.newBuilder().maximumSize(MAX_EXPR_CACHE_SIZE).weakKeys().weakValues().build();
	}
	/**
	 * COMPILER switch - set this boolean variable to <code>true</code>, if you would force a direct plot frame creation
	 * from the Plot[], Plot3D[] and ParametricPlot[] functions
	 * 
	 * On the server this switch should be set to <code>false</code>
	 */
	public static boolean SWING_PLOT_FRAME = false;

	/**
	 * The time in milliseconds an evaluation thread should run.<br/>
	 * 0 => forever
	 * 
	 */
	// public static long TIME_CONSTRAINED_MILLISECONDS = 60000L;

	/**
	 * The time in milliseconds an evaluation thread should run.<br/>
	 * 0 => forever
	 * 
	 */
	public final static long FOREVER = 0L;

	/**
	 * The time in milliseconds an evaluation thread should sleep until <code>Thread#stop()</code> will be called.
	 * 
	 */
	public final static long TIME_CONSTRAINED_SLEEP_MILLISECONDS = 500;

	/**
	 * Switch debug mode on/off
	 * 
	 */
	public final static boolean DEBUG = false;

	/**
	 * Show the stack trace, if an exception is thrown in evaluation
	 * 
	 */
	public static boolean SHOW_STACKTRACE = false;

	/**
	 * Show the console output, if an expression has a head symbol with attribute <code>ISymbol.CONSOLE_OUTPUT</code>.
	 * 
	 */
	public final static boolean SHOW_CONSOLE = true;

	/**
	 * Show the pattern-matching evaluation steps in the console output.
	 * 
	 */
	public final static boolean SHOW_PATTERN_EVAL_STEPS = false;

	public final static Set<ISymbol> SHOW_PATTERN_SYMBOL_STEPS = new HashSet<ISymbol>();

	/**
	 * If <code>true</code> the parser doesn't distinguish between lower- or uppercase symbols (i.e. constants, function
	 * names,...), with the exception of symbols with only one character (i.e. the variable &quot;i&quot; is different
	 * from the imaginary unit &quot;I&quot;)
	 */
	public static boolean PARSER_USE_LOWERCASE_SYMBOLS = true;

	/**
	 * If <code>true</code> the parser doesn't allow "square brackets" instead of "parentheses" for enclosing function
	 * arguments in relaxed mode. The syntax <code>f[x, y, ...]</code> isn't allowed then. Always use
	 * <code>f(x, y, ...)</code>.
	 * 
	 */
	public final static boolean PARSER_USE_STRICT_SYNTAX = false;

	/**
	 * Used to parse Rubi files. See <a href="http://www.apmaths.uwo.ca/~arich/">Rubi - Symbolic Integration Rules</a>
	 */
	public static boolean RUBI_CONVERT_SYMBOLS = false;

	/**
	 * Used to serialize the internal Rubi rules or the <code>org.matheclipse.core.reflection.system.rules</code>
	 * classes to a file.
	 */
	public static boolean SERIALIZE_SYMBOLS = false;

	/**
	 * If set to true the <code>Integrate</code> initialization Rules will be read from ressource
	 * <code>/ser/integrate.ser</code>
	 */
	// public static boolean LOAD_SERIALIZED_RULES = false;

	/**
	 * <code>true</code> if the engine is started by a servlet<br/>
	 * In <i>server mode</i> the user can only assign values to variables with prefix '$' <br/>
	 * <br/>
	 * SERVER_MODE should be set to <code>true</code> in the initialization of a servlet
	 * 
	 */
	public static boolean SERVER_MODE = false;

	/**
	 * <code>true</code> if it's allowed to delete the <code>Protected</code> attribute from a symbol. In <i>server
	 * mode</i> this flag should be set to <code>false</code>. <br/>
	 *
	 */
	public static boolean UNPROTECT_ALLOWED = true;
	/**
	 * See <a href="http://en.wikipedia.org/wiki/Machine_epsilon">Wikipedia: Machine epsilon</a>
	 */
	public static double DOUBLE_EPSILON = Precision.EPSILON;

	/**
	 * The double tolerance used for comparisons.
	 */
	public static double DOUBLE_TOLERANCE = DOUBLE_EPSILON * 10d;

	/**
	 * The real which added to 1.0 gives the next double value greater than 1.0
	 */
	public static double MACHINE_EPSILON = Math.nextUp(1.0) - 1.0;

	/**
	 * Replace <code>double</code> values in root algorithms by 0 if they are below this tolerance.
	 */
	public static double DEFAULT_ROOTS_CHOP_DELTA = 1.0e-5;

	/**
	 * Define the recursion limit for <code>Integrate#integrateByParts()</code> method.
	 */
	public static int INTEGRATE_BY_PARTS_RECURSION_LIMIT = 10;

	/**
	 * Define the recursion limit for <code>Integrate#integrateByRubiRules()</code> method.
	 */
	public static int INTEGRATE_RUBI_RULES_RECURSION_LIMIT = 100;

	/**
	 * Define the Rubi time limit for the <code>TimeConstrained()</code> function.
	 */
	public static int INTEGRATE_RUBI_TIMELIMIT = 8;

	/**
	 * Define the recursion limit for <code>Limit#lHospitalesRule()</code> method.
	 */
	public static int LIMIT_LHOSPITAL_RECURSION_LIMIT = 128;

	/**
	 * <p>
	 * Flag for thread usage.
	 * </p>
	 * <p>
	 * <b>Note:</b> introduced because Google app engine does not support threads.
	 * </p>
	 * 
	 * @see edu.jas.ufd.GCDFactory#getProxy(edu.jas.structure.RingFactory)
	 */
	public static boolean JAS_NO_THREADS = false;

	/**
	 * Use of <code>java.misc.Unsafe</code> is allowed if <code>true</code>.
	 */
	public static boolean JAVA_UNSAFE = true;

	/**
	 * <p>
	 * Flag for thread usage in TimeConstrained function.
	 * </p>
	 * <p>
	 * <b>Note:</b> introduced because Google app engine does not support threads.
	 * </p>
	 *
	 */
	public static boolean TIMECONSTRAINED_NO_THREAD = false;

	/**
	 * An object that creates new threads on demand. Using thread factories removes hardwiring of calls to new Thread,
	 * enabling applications to use special thread subclasses, priorities, etc.
	 *
	 * For example <code>com.google.appengine.api.ThreadManager.currentRequestThreadFactory()</code> can be used on
	 * Google appengine.
	 *
	 */
	public static java.util.concurrent.ThreadFactory THREAD_FACTORY = null;

	/**
	 * Use <code>Num</code> objects for numeric calculations up to 16 digits precision.
	 */
	public static final int MACHINE_PRECISION = 16;

	/**
	 * Print trigonometric functions in lower case characters.
	 */
	public static boolean MATHML_TRIG_LOWERCASE = true;
	/**
	 * Enable tests and functions which use the local files. Don't use <code>final</code> here because of grpc
	 * interface.
	 */
	public static boolean FILESYSTEM_ENABLED = false;

	public static boolean isFileSystemEnabled(EvalEngine engine) {
		return FILESYSTEM_ENABLED || engine.isFileSystemEnabled();
	}

	/**
	 * Do time consuming JUnit tests. For example for <code>FactorInteger</code> function
	 *
	 */
	public static boolean EXPENSIVE_JUNIT_TESTS = false;

	/**
	 * <p>
	 * If <code>true</code> the <code>*</code> operator must be written for a <code>Times()</code> expression. I.e. you
	 * cannot write <code>2(b+c)</code> anymore, but have to write <code>2*(b+c)</code> to get
	 * <code>Times(2, Plus(b, c))</code>.
	 * </p>
	 * <p>
	 * You also enable <a href="https://en.wikipedia.org/wiki/Scientific_notation#E-notation">scientific E-notation</a>.
	 * I.e. <code>1E-2</code> is converted to a double value <code>0.01</code> for floating point numbers and not parsed
	 * as <code>Plus(-2, E)</code> anymore.
	 * </p>
	 * <p>
	 * You also enable integer literal input with a prefix, similar to
	 * <a href="https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html">Java integer literals</a>
	 * <ul>
	 * <li><code>0b</code> or <code>0B</code> for binary numbers</li>
	 * <li><code>0x</code> or <code>0X</code> for hexadecimal numbers</li>
	 * <li><code>0o</code> or <code>0O</code> for octal numbers</li>
	 * </ul>
	 * </p>
	 */
	public static boolean EXPLICIT_TIMES_OPERATOR = false;

	/**
	 * <p>
	 * If <code>true</code> the implicit <code>*</code> operator has a higher precedence than all other operators. I.e.
	 * <code>1/2Pi</code> is parsed as <code>Power(Times(2, Pi), -1)</code>. If <code>false</code> the implicit
	 * <code>*</code> operator has a normal precedence as in all other cases. I.e. <code>1/2Pi</code> is parsed as
	 * <code>Times(Rational(1,2), Pi)</code>.
	 * </p>
	 */
	public static boolean DOMINANT_IMPLICIT_TIMES = false;

	/**
	 * Default package mode with which the EvalEngines initially can be started
	 */
	public static boolean PACKAGE_MODE = true;

	/**
	 * Use JavaScript libraries for the <code>Manipulate()</code> function
	 */
	public static boolean USE_MANIPULATE_JS = true;
	/**
	 * Use visjs.org JavaScript library for visualizing graph theory objects
	 */
	public static boolean USE_VISJS = false;
	/**
	 * HTML template for the <a href="https://visjs.org/">VIS-network</a>
	 */
	public final static String VISJS_PAGE = //
			"<html>\n" + //
					"<head>\n" + //
					"<meta charset=\"utf-8\">\n" + //
					"<head>\n" + //
					"  <title>VIS-Network</title>\n" + //
					"\n" + //
					"  <script type=\"text/javascript\" src=\"https://cdn.jsdelivr.net/npm/vis-network@6.0.0/dist/vis-network.min.js\"></script>\n"
					+ //
					"  <style type=\"text/css\">\n" + //
					"    #mynetwork {\n" + //
					"      width: 600px;\n" + //
					"      height: 400px;\n" + //
					"      border: 1px solid lightgray;\n" + //
					"    }\n" + //
					"  </style>\n" + //
					"</head>\n" + //
					"<body>\n" + //
					"\n" + //
					"<h1>VIS-Network</h1>\n" + //
					"\n" + //
					"<div id=\"vis\"></div>\n" + //
					"\n" + //
					"<script type=\"text/javascript\">\n" + //
					"`1`\n" + //
					"  // create a network\n" + //
					"  var container = document.getElementById('vis');\n" + //
					"  var data = {\n" + //
					"    nodes: nodes,\n" + //
					"    edges: edges\n" + //
					"  };\n" + //
					"`2`\n" + //
					// " var options = {};\n" + //
					"  var network = new vis.Network(container, data, options);\n" + //
					"</script>\n" + //
					"\n" + //
					"\n" + //
					"</body>\n" + //
					"</html>";//

	/**
	 * HTML template for the <a href="https://github.com/paulmasson/mathcell">MathCell</a> and
	 * <a href="https://github.com/paulmasson/math">Math</a> JavaScript libraries.
	 */
	public final static String MATHCELL_PAGE = //
			"<html>\n" + //
					"<head>\n" + //
					"<meta charset=\"utf-8\">\n" + //
					"<title>MathCell</title>\n" + //
					"<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n" + //
					"</head>\n" + //
					"\n" + //
					"<body>\n" + //
					"<script src=\"https://cdn.jsdelivr.net/gh/paulmasson/math@1.2.4/build/math.js\"></script>" + //
					"\n" + //
					"\n" + //
					"<script src=\"https://cdn.jsdelivr.net/gh/paulmasson/mathcell@1.7.7/build/mathcell.js\"></script>\n"
					+ //
					"<script src=\"https://cdn.jsdelivr.net/gh/mathjax/MathJax@2.7.5/MathJax.js?config=TeX-AMS_HTML\"></script>"
					+ //
					"\n" + //
					"<div class=\"mathcell\" style=\"width: 100%; height: 100%; padding: .25in .5in .5in .5in;\">\n" + //
					"<script>\n" + //
					"\n" + //
					"var parent = document.scripts[ document.scripts.length - 1 ].parentNode;\n" + //
					"\n" + //
					"var id = generateId();\n" + //
					"parent.id = id;\n" + //
					"\n" + //
					"`1`\n" + //
					"\n" + //
					"parent.update( id );\n" + //
					"\n" + //
					"</script>\n" + //
					"</div>\n" + //
					"\n" + //
					"</body>\n" + //
					"</html>";//
	/**
	 * HTML template for JSXGraph
	 */
	public final static String JSXGRAPH_PAGE = //
			"<html>\n" + //
					"<head>\n" + //
					"<meta charset=\"utf-8\">\n" + //
					"<title>JSXGraph</title>\n" + //
					"</head>\n" + //
					"\n" + //
					"<body>\n" + //
					"\n" + //
					"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdnjs.cloudflare.com/ajax/libs/jsxgraph/1.3.5/jsxgraph.css\" />\n"
					+ //
					"<script src=\"https://cdn.jsdelivr.net/gh/paulmasson/math@1.2.4/build/math.js\"\\n></script>"
					+ "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jsxgraph/1.3.5/jsxgraphcore.js\"\n" + //
					"        type='text/javascript'></script>\n" + //
					"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jsxgraph/1.3.5/geonext.min.js\"\n" + //
					"        type='text/javascript'></script>\n" + //
					"\n" + //
					"<div id=\"jxgbox\" class=\"jxgbox\" style=\"display: flex; width:99%; height:99%; margin: 0; flex-direction: column; overflow: hidden\">\n"
					+ //
					"<script>\n" + //
					// "var board = JXG.JSXGraph.initBoard('jxgbox', {axis:true});\n" + //
					// ,boundingbox:[-7.0,5.0,4.0,-3.0]
					// "board.suspendUpdate();\n" + //
					"`1`\n" + //
					// "board.unsuspendUpdate();\n" + //
					"</script>\n" + //
					"</div>\n" + //
					"\n" + //
					"</body>\n" + //
					"</html>";//
	public final static double DEFAULT_CHOP_DELTA = 1.0e-10;
}
