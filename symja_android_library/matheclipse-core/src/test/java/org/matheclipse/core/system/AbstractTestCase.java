package org.matheclipse.core.system;

import junit.framework.TestCase;

import org.matheclipse.core.basic.Config;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.TimeConstrainedEvaluator;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.form.output.OutputFormFactory;
import org.matheclipse.core.graphics.Show2SVG;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.parser.client.FEConfig;
import org.matheclipse.script.engine.MathScriptEngine;

import java.io.StringWriter;
import java.util.Locale;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;

/**
 * Tests system.reflection classes
 */
public abstract class AbstractTestCase extends TestCase {
    protected final Object fScriptManager = new Object();
    protected ScriptEngine fScriptEngine;
    protected ScriptEngine fNumericScriptEngine;

    public AbstractTestCase(String name) {
        super(name);
        Locale.setDefault(Locale.US);
        Config.SERVER_MODE = false;
        FEConfig.SHOW_STACKTRACE = true;
    }

	public void ESameTest(String expectedString, String evalString) {
        try {
            if (evalString.length() == 0 && expectedString.length() == 0) {
                return;
            }
            // scriptEngine.put("STEPWISE",Boolean.TRUE);
            String evaledResult = (String) fScriptEngine.eval(evalString);
            String expectedResult = (String) fScriptEngine.eval(expectedString);

            assertEquals(expectedResult, evaledResult);

        } catch (Exception e) {
            e.printStackTrace();
            assertEquals("", "1");
        }
    }

    public void check(String evalString, String expectedResult) {
        System.out.println("evalString = " + evalString);
        check(fScriptEngine, evalString, expectedResult, -1);
    }

    public void check(String evalString, String expectedResult, int resultLength) {
        check(fScriptEngine, evalString, expectedResult, resultLength);
    }

    public void check(ScriptEngine scriptEngine, String evalString, String expectedResult, int resultLength) {
        try {
            if (evalString.length() == 0 && expectedResult.length() == 0) {
                return;
            }
            // scriptEngine.put("STEPWISE",Boolean.TRUE);
            String evaledResult = (String) scriptEngine.eval(evalString);

            if (resultLength > 0 && evaledResult.length() > resultLength) {
                evaledResult = evaledResult.substring(0, resultLength) + "<<SHORT>>";
                assertEquals(expectedResult, evaledResult);
            } else {
                assertEquals(expectedResult, evaledResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            assertEquals("", "1");
        }
    }

	public String evalString(String evalString) {
        try {
            // scriptEngine.put("STEPWISE",Boolean.TRUE);
			return (String) fScriptEngine.eval(evalString);
        } catch (Exception e) {
            e.printStackTrace();
            assertEquals("", "1");
        }
		return "";
    }

    public void checkNumeric(String evalString, String expectedResult) {
        check(fNumericScriptEngine, evalString, expectedResult, -1);
    }

    public void checkNumeric(String evalString, String expectedResult, int resultLength) {
        check(fNumericScriptEngine, evalString, expectedResult, resultLength);
    }

    public void check(IAST ast, String strResult) {
        check(EvalEngine.get(), true, ast, strResult);
    }

    public void check(EvalEngine engine, boolean configMode, IAST ast, String strResult) {
        boolean mode = Config.SERVER_MODE;
        try {
            StringWriter buf = new StringWriter();

            Config.SERVER_MODE = configMode;
            if (Config.SERVER_MODE) {
                IAST inExpr = ast;
                TimeConstrainedEvaluator utility = new TimeConstrainedEvaluator(engine, false, Config.FOREVER);
                utility.constrainedEval(buf, inExpr);
            } else {
                if (ast != null) {
                    OutputFormFactory off = OutputFormFactory.get();
                    off.setIgnoreNewLine(true);
                    off.convert(buf, ast);
                }
            }

            assertEquals(strResult, buf.toString());
        } catch (Exception e) {
            e.printStackTrace();
            assertEquals("", "1");
        } finally {
            Config.SERVER_MODE = mode;
        }
    }

    public void checkSVGGraphics(String evalString, String expectedResult) {
        checkSVGGraphics(fScriptEngine, evalString, expectedResult);
    }

    public void checkSVGGraphics(ScriptEngine scriptEngine, String evalString, String expectedResult) {
        try {
            if (evalString.length() == 0 && expectedResult.length() == 0) {
                return;
            }
            scriptEngine.getContext().setAttribute("RETURN_OBJECT", Boolean.TRUE, ScriptContext.ENGINE_SCOPE);
            IExpr result = (IExpr) scriptEngine.eval(evalString);
            if (result.isAST()) {
                StringBuilder buf = new StringBuilder(2048);
                Show2SVG.toSVG((IAST) result, buf);
                assertEquals(expectedResult, buf.toString());
            } else {
                assertEquals("", "1");
            }
        } catch (Exception e) {
            e.printStackTrace();
            assertEquals("", "1");
        }
    }

    /**
     * The JUnit setup method
     */
    @Override
    protected void setUp() {
        try {
            synchronized (fScriptManager) {
				Config.FILESYSTEM_ENABLED = false;
				EvalEngine engine = new EvalEngine();
				fScriptEngine = new MathScriptEngine(engine);// fScriptManager.getEngineByExtension("m");
                fScriptEngine.put("RELAXED_SYNTAX", Boolean.TRUE);
                fScriptEngine.put("DECIMAL_FORMAT", "0.0####");

                fNumericScriptEngine = new MathScriptEngine();// fScriptManager.getEngineByExtension("m");
                fNumericScriptEngine.put("RELAXED_SYNTAX", Boolean.TRUE);
                F.await();

				EvalEngine.set(engine);
				engine.init();
                engine.setRecursionLimit(256);
                engine.setIterationLimit(500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
