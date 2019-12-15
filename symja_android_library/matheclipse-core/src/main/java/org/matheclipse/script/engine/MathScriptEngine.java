package org.matheclipse.script.engine;

import org.apfloat.ApfloatRuntimeException;
import org.matheclipse.core.basic.Config;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.EvalUtilities;
import org.matheclipse.core.eval.exception.AbortException;
import org.matheclipse.core.eval.exception.FailedException;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.form.output.OutputFormFactory;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.parser.client.SyntaxError;
import org.matheclipse.parser.client.math.MathException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;

import javax.script.AbstractScriptEngine;
import javax.script.ScriptContext;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptException;

public class MathScriptEngine extends AbstractScriptEngine {
    public final static String RETURN_OBJECT = "RETURN_OBJECT";

    private EvalUtilities fUtility;
    private EvalEngine fEngine;
    private String fDecimalFormat;

    // static {
    // run the static groovy code for the MathEclipse domain specific language
    // DSL groovyDSL = new DSL();
    // }

    public MathScriptEngine() {
        this(new EvalEngine());
    }

    public MathScriptEngine(EvalEngine engine) {
        // get the thread local evaluation engine
        fEngine = engine;
        // fEngine.setRecursionLimit(256);
        // fEngine.setIterationLimit(256);
        fUtility = new EvalUtilities(fEngine, false, false);
    }

    @Override
    public Object eval(final String script, final ScriptContext context) throws ScriptException {
        // final ArrayList<ISymbol> list = new ArrayList<ISymbol>();
        boolean relaxedSyntax = false;
        try {
            // first assign the EvalEngine to the current thread:
            fUtility.startRequest();

            // final Bindings bindings = context.getBindings(ScriptContext.ENGINE_SCOPE);
            // ISymbol symbol;
            // for (Map.Entry<String, Object> currEntry : bindings.entrySet()) {
            // symbol = F.userSymbol(currEntry.getKey(), fEngine);
            // symbol.pushLocalVariable(Object2Expr.convert(currEntry.getValue()));
            // list.add(symbol);
            // }

            final Object decimalFormat = get("DECIMAL_FORMAT");
            if (decimalFormat instanceof String) {
                fDecimalFormat = (String) decimalFormat;
            }

            final Object relaxedSyntaxBoolean = get("RELAXED_SYNTAX");
            if (Boolean.TRUE.equals(relaxedSyntaxBoolean)) {
                relaxedSyntax = true;
                fEngine.setRelaxedSyntax(relaxedSyntax);
            }

            boolean disableHistory = true;
            final Object enableHistoryBoolean = get("ENABLE_HISTORY");
            if (Boolean.TRUE.equals(enableHistoryBoolean)) {
                disableHistory = false;
                fEngine.setOutListDisabled(disableHistory, 100);
            }

            // evaluate an expression
            final Object stepwise = get("STEPWISE");
            final IExpr[] result = new IExpr[1];
            if (Boolean.TRUE.equals(stepwise)) {
                result[0] = fUtility.evalTrace(script, null, F.List());
            } else {
                final Throwable[] error = new Throwable[1];
                ThreadGroup group = new ThreadGroup("CalculateThread");
                Thread thread = new Thread(group, new Runnable() {
                    @Override
                    public void run() {
                        try {
                            result[0] = fUtility.evaluate(script);
                        } catch (Throwable e) {
                            error[0] = e;
                        }
                    }
                }, toString(), 2 * 1024 * 1024);
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
                if (error[0] != null) {
                    throw error[0];
                }
            }
            final Object returnType = context.getAttribute("RETURN_OBJECT");
            if ((returnType != null) && returnType.equals(Boolean.TRUE)) {
                // return the object "as is"
                return result[0];
            } else {
                // return the object as String representation
                if (result[0] != null) {
                    return printResult(result[0], relaxedSyntax);
                }
                return "";
            }

        } catch (final AbortException e) {
            if (Config.SHOW_STACKTRACE) {
                e.printStackTrace();
            }
            try {
                return printResult(F.$Aborted, relaxedSyntax);
            } catch (IOException e1) {
                if (Config.DEBUG) {
                    e.printStackTrace();
                }
                return e1.getMessage();
            }
        } catch (final FailedException e) {
            if (Config.SHOW_STACKTRACE) {
                e.printStackTrace();
            }
            try {
                return printResult(F.$Failed, relaxedSyntax);
            } catch (IOException e1) {
                if (Config.DEBUG) {
                    e.printStackTrace();
                }
                return e1.getMessage();
            }
        } catch (final SyntaxError e) {
            if (Config.DEBUG) {
                e.printStackTrace();
            }
            // catch parser errors here
            return e.getMessage();
        } catch (final MathException e) {
            if (Config.SHOW_STACKTRACE) {
                e.printStackTrace();
            }
            // catch parser errors here
            return e.getMessage();
        } catch (final ApfloatRuntimeException e) {
            if (Config.SHOW_STACKTRACE) {
                e.printStackTrace();
            }
            // catch parser errors here
            return "Apfloat: " + e.getMessage();
        } catch (final Exception e) {
            // if (e instanceof ExceptionContextProvider) {
            // if (Config.DEBUG) {
            // e.printStackTrace();
            // }
            // return e.getMessage();
            // }
            if (Config.SHOW_STACKTRACE) {
                e.printStackTrace();
            }
            return "Exception: " + e.getMessage();
        } catch (final OutOfMemoryError e) {
            if (Config.SHOW_STACKTRACE) {
                e.printStackTrace();
            }
            return "OutOfMemoryError";
        } catch (final StackOverflowError e) {
            if (Config.SHOW_STACKTRACE) {
                e.printStackTrace();
            }
            return "StackOverflowError";
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return "Exception: " + throwable.getMessage();
        } finally {
            // if (list.size() > 0) {
            // for (int i = 0; i < list.size(); i++) {
            // list.get(i).popLocalVariable();
            // }
            // }
            EvalEngine.remove();
        }

    }

    @Override
    public Object eval(final Reader reader, final ScriptContext context) throws ScriptException {
        final BufferedReader f = new BufferedReader(reader);
        final StringBuilder buff = new StringBuilder(1024);
        String line;
        try {
            while ((line = f.readLine()) != null) {
                buff.append(line);
                buff.append('\n');
            }
            return eval(buff.toString());
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ScriptEngineFactory getFactory() {
        return new MathScriptEngineFactory();
    }

    private Object printResult(IExpr result, boolean relaxedSyntax) throws IOException {
        if (result.equals(F.Null)) {
            return "";
        }
        final StringWriter buf = new StringWriter();
        if (fDecimalFormat != null) {
            // DecimalFormatSymbols usSymbols = new DecimalFormatSymbols(Locale.US);
            // DecimalFormat decimalFormat = new DecimalFormat(fDecimalFormat, usSymbols);
            OutputFormFactory.get(relaxedSyntax, false, 5, 7).convert(buf, result);
        } else {
            OutputFormFactory.get(relaxedSyntax).convert(buf, result);
        }
        // print the result in the console
        return buf.toString();
    }
}
