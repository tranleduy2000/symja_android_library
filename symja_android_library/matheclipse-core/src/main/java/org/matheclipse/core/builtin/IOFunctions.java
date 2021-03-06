package org.matheclipse.core.builtin;

import com.duy.lambda.Consumer;
import com.duy.lambda.IntFunction;

import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.matheclipse.core.basic.Config;
import org.matheclipse.core.convert.AST2Expr;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.exception.Validate;
import org.matheclipse.core.eval.interfaces.AbstractCoreFunctionEvaluator;
import org.matheclipse.core.eval.interfaces.AbstractEvaluator;
import org.matheclipse.core.eval.interfaces.AbstractFunctionEvaluator;
import org.matheclipse.core.eval.util.OptionArgs;
import org.matheclipse.core.expression.Context;
import org.matheclipse.core.expression.ContextPath;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.expression.S;
import org.matheclipse.core.form.output.OutputFormFactory;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IASTAppendable;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.IStringX;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.core.patternmatching.IPatternMatcher;
import org.matheclipse.core.patternmatching.RulesData;
import org.matheclipse.parser.trie.SuggestTree;
import org.matheclipse.parser.client.FEConfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.matheclipse.parser.trie.SuggestTree.Node;

public class IOFunctions {

  /**
   * See <a href="https://pangin.pro/posts/computation-in-static-initializer">Beware of computation
   * in static initializer</a>
   */
  private static class Initializer {

    private static void init() {
      // F.General.setEvaluator(new General());
      F.Echo.setEvaluator(new Echo());
      F.EchoFunction.setEvaluator(new EchoFunction());
      F.Message.setEvaluator(new Message());
      F.Messages.setEvaluator(new Messages());
      F.Names.setEvaluator(new Names());
      F.Print.setEvaluator(new Print());

      F.Short.setEvaluator(new Short());
      F.StyleForm.setEvaluator(new StyleForm());
      for (int i = 0; i < MESSAGES.length; i += 2) {
        F.General.putMessage(IPatternMatcher.SET, MESSAGES[i], F.stringx(MESSAGES[i + 1]));
      }
    }
  }

  /**
   *
   *
   * <pre>
   * <code>Echo(expr)
   * </code>
   * </pre>
   *
   * <blockquote>
   *
   * <p>prints the <code>expr</code> to the default output stream and returns <code>expr</code>.
   *
   * </blockquote>
   *
   * <pre>
   * <code>Echo(expr, label)
   * </code>
   * </pre>
   *
   * <blockquote>
   *
   * <p>prints <code>label</code> before printing <code>expr</code>.
   *
   * </blockquote>
   *
   * <pre>
   * <code>Echo(expr, label, head)
   * </code>
   * </pre>
   *
   * <blockquote>
   *
   * <p>prints <code>label</code> before printing <code>head(expr)</code> and returns <code>expr
   * </code>.
   *
   * </blockquote>
   *
   * <h3>Examples</h3>
   *
   * <pre>
   * <code>&gt;&gt; {Echo(f(x,y)), Print(g(a,b))}
   * {f(x,y),Null}
   * </code>
   * </pre>
   *
   * <p>prints
   *
   * <pre>
   * <code>f(x,y)
   * g(a,b)
   * </code>
   * </pre>
   *
   * <p>and returns
   *
   * <pre>
   * <code>{f(x,y),Null}
   * </code>
   * </pre>
   */
  private static class Echo extends Print {

    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      final PrintStream s = engine.getOutPrintStream();
      final PrintStream stream;
      if (s == null) {
        stream = System.out;
      } else {
        stream = s;
      }
      final StringBuilder buf = new StringBuilder();
      OutputFormFactory out = OutputFormFactory.get(engine.isRelaxedSyntax());
      boolean[] convert = new boolean[]{true};
      IExpr arg1 = ast.arg1();
      IExpr result = engine.evaluate(arg1);
      if (ast.argSize() >= 2) {
        IExpr arg2 = engine.evaluate(ast.arg2());
        printExpression(arg2, out, buf, convert, engine);
        if (ast.isAST3()) {
          IExpr arg3 = engine.evaluate(F.unaryAST1(ast.arg3(), arg1));
          printExpression(arg3, out, buf, convert, engine);
        } else {
          printExpression(result, out, buf, convert, engine);
        }
      } else {
        printExpression(result, out, buf, convert, engine);
      }
      stream.println(buf.toString());
      return result;
    }

    public int[] expectedArgSize(IAST ast) {
      return ARGS_1_3;
    }
  }

  /**
   *
   *
   * <pre>
   * <code>EchoFunction()[expr]
   * </code>
   * </pre>
   *
   * <blockquote>
   *
   * <p>operator form of the <code>Echo</code>function. Print the <code>expr</code> to the default
   * output stream and return <code>expr</code>.
   *
   * </blockquote>
   *
   * <pre>
   * <code>EchoFunction(head)[expr]
   * </code>
   * </pre>
   *
   * <blockquote>
   *
   * <p>prints <code>head(expr)</code> and returns <code>expr</code>.
   *
   * </blockquote>
   *
   * <pre>
   * <code>EchoFunction(label, head)[expr]
   * </code>
   * </pre>
   *
   * <blockquote>
   *
   * <p>prints <code>label</code> before printing <code>head(expr)</code> and returns <code>expr
   * </code>.
   *
   * </blockquote>
   *
   * <h3>Examples</h3>
   *
   * <pre>
   * <code>&gt;&gt; {EchoFunction()[f(x,y)], Print(g(a,b))}
   * {f(x,y),Null}
   * </code>
   * </pre>
   *
   * <p>prints
   *
   * <pre>
   * <code>f(x,y)
   * g(a,b)
   * </code>
   * </pre>
   *
   * <p>and returns
   *
   * <pre>
   * <code>{f(x,y),Null}
   * </code>
   * </pre>
   */
  private static final class EchoFunction extends Print {

    @Override
    public IExpr evaluate(IAST ast, EvalEngine engine) {

      if (ast.isAST1() && ast.head().isAST()) {
        final int size = ast.head().size();
        switch (size) {
          case 1:
            return F.unaryAST1(S.Echo, ast.arg1());
          case 2:
            return echo(ast.arg1(), ast.head().first(), engine);
          case 3:
            return F.ternaryAST3(S.Echo, ast.arg1(), ast.head().first(), ast.head().second());
          default:
        }
      }
      return F.NIL;
    }

    private static IExpr echo(final IExpr arg1, IExpr headFirst, EvalEngine engine) {
      final PrintStream s = engine.getOutPrintStream();
      final PrintStream stream;
      if (s == null) {
        stream = System.out;
      } else {
        stream = s;
      }
      final StringBuilder buf = new StringBuilder();
      OutputFormFactory out = OutputFormFactory.get(engine.isRelaxedSyntax());
      boolean[] convert = new boolean[]{true};
      IExpr result = engine.evaluate(arg1);
      IExpr arg3 = engine.evaluate(F.unaryAST1(headFirst, arg1));
      printExpression(arg3, out, buf, convert, engine);
      stream.println(buf.toString());
      return result;
    }

    public int[] expectedArgSize(IAST ast) {
      return ARGS_0_2_0;
    }

  }

  /**
   *
   *
   * <pre>
   * <code>Message(symbol::msg, expr1, expr2, ...)
   * </code>
   * </pre>
   *
   * <blockquote>
   *
   * <p>displays the specified message, replacing placeholders in the message text with the
   * corresponding expressions.
   *
   * </blockquote>
   *
   * <h3>Examples</h3>
   *
   * <pre>
   * <code>&gt;&gt; a::b = &quot;Hello world!&quot;
   * Hello world!
   *
   * &gt;&gt; Message(a::b)
   * a: Hello world!
   *
   * &gt;&gt; a::c := &quot;Hello `1`, Mr 00`2`!&quot;
   *
   * &gt;&gt; Message(a::c, &quot;you&quot;, 3 + 4)
   * a: Hello you, Mr 007!
   * </code>
   * </pre>
   */
  private static class Message extends AbstractEvaluator {

    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      if (ast.size() > 1) {
        if (ast.arg1().isString()) {
          String message = ast.arg1().toString();
          for (int i = 2; i < ast.size(); i++) {
            message = message.replaceAll("`" + (i - 1) + "`", ast.get(i).toString());
          }
          return F.stringx(": " + message);
        }
        if (ast.arg1().isAST(S.MessageName, 3)) {
          IAST messageName = (IAST) ast.arg1();
          String messageShortcut = messageName.arg2().toString();
          if (messageName.arg1().isSymbol()) {
            IExpr temp = message((ISymbol) messageName.arg1(), messageShortcut, ast);
            if (temp.isPresent()) {
              return temp;
            }
          }
          return message(S.General, messageShortcut, ast);
        }
      }
      return F.NIL;
    }

    @Override
    public void setUp(ISymbol newSymbol) {
      newSymbol.setAttributes(ISymbol.HOLDFIRST);
    }
  }

  private static class Messages extends AbstractCoreFunctionEvaluator {

    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      IExpr arg1 = Validate.checkSymbolType(ast, 1, engine);
      if (arg1.isSymbol()) {
        ISymbol symbol = (ISymbol) arg1;
        RulesData rulesData = symbol.getRulesData();
        if (rulesData != null) {
          Map<String, IStringX> map = rulesData.getMessages();
          if (map != null) {
            IASTAppendable result = F.ListAlloc(map.size());
            for (Map.Entry<String, IStringX> entry : map.entrySet()) {
              result.append(
                  F.RuleDelayed(
                      F.HoldPattern(F.MessageName(symbol, entry.getKey())), entry.getValue()));
            }
            return result;
          }
        }
        return F.CEmptyList;
      }
      return F.NIL;
    }

    public int[] expectedArgSize(IAST ast) {
      return ARGS_1_1;
    }

    @Override
    public void setUp(ISymbol newSymbol) {
      newSymbol.setAttributes(ISymbol.HOLDALL);
    }
  }

  private static class Short extends AbstractEvaluator {

    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      return F.stringx(shorten(ast.arg1()));
    }

    public int[] expectedArgSize(IAST ast) {
      return ARGS_1_1;
    }
  }

  private static class StyleForm extends AbstractEvaluator {

    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      if (ast.head() == S.StyleForm) {
        return ast.apply(S.Style);
      }
      return F.NIL;
    }
  }

  private static final class Names extends AbstractFunctionEvaluator {

    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      if (ast.isAST0()) {
        return getAllNames();
      }

      IExpr arg1 = ast.arg1();
      boolean ignoreCase = FEConfig.PARSER_USE_LOWERCASE_SYMBOLS ? true : false;
      if (ast.size() > 2) {
        final OptionArgs options = new OptionArgs(ast.topHead(), ast, 2, engine, true);
        IExpr option = options.getOption(S.IgnoreCase);
        if (option.isTrue()) {
          ignoreCase = true;
        }
      }
      if (arg1.isString() && arg1.toString().indexOf("`") < 0) {
        arg1 = F.$str("System`" + arg1.toString());
      }
      java.util.regex.Pattern pattern =
          StringFunctions.toRegexPattern(arg1, true, ignoreCase, ast, engine);

      if (pattern == null) {
      return F.NIL;
    }

      return getNamesByPattern(pattern, engine);
    }
    public int[] expectedArgSize(IAST ast) {
      return ARGS_0_2;
    }

  }

  private static class Print extends AbstractCoreFunctionEvaluator {

    @Override
    public IExpr evaluate(final IAST ast, final EvalEngine engine) {
      final PrintStream s = engine.getOutPrintStream();
      final PrintStream stream;
      if (s == null) {
        stream = System.out;
      } else {
        stream = s;
      }
      final StringBuilder buf = new StringBuilder();
      final OutputFormFactory out = OutputFormFactory.get(engine.isRelaxedSyntax());
      final boolean[] convert = new boolean[] {true};
      ast.forEach(
          new Consumer<IExpr>() {
            @Override
            public void accept(IExpr x) {
              IExpr temp = engine.evaluate(x);
              printExpression(temp, out, buf, convert, engine);
            }
          });
      if (!convert[0]) {
        stream.println("ERROR-IN-OUTPUTFORM");
        return F.Null;
      }
      stream.println(buf.toString());
      return F.Null;
    }

    protected static void printExpression(IExpr x, OutputFormFactory out, final StringBuilder buf,
        boolean[] convert, EvalEngine engine) {
      if (x instanceof IStringX) {
        buf.append(x.toString());
      } else {
        if (x.isASTSizeGE(S.Style, 2)) {
          printExpression(x.first(), out, buf, convert, engine);
        } else if (convert[0] && !out.convert(buf, x)) {
          convert[0] = false;
        }
      }
    }

  }

  private static final String[] MESSAGES = { //
    "argillegal",
    "illegal arguments: \"`1`\" in `2`", //
    "argb",
    "`1` called with `2` arguments; between `3` and `4` arguments are expected.", //
    "argct",
    "`1` called with `2` arguments.", //
    "argctu",
    "`1` called with 1 argument.", //
    "argr",
    "`1` called with 1 argument; `2` arguments are expected.", //
    "argrx",
    "`1` called with `2` arguments; `3` arguments are expected.", //
    "argx",
    "`1` called with `2` arguments; 1 argument is expected.", //
    "argt",
    "`1` called with `2` arguments; `3` or `4` arguments are expected.", //
    "argtu",
    "`1` called with 1 argument; `2` or `3` arguments are expected.", //
      "argtype",
    "Arguments `1` and `2` of `3` should be either non-negative integers or one-character strings.", //
    "base",
    "Requested base `1` in `2` should be between 2 and `3`.", //
    "boxfmt",
    "`1` is not a box formatting type.", //
    "cfn",
    "Numerical error encountered, proceeding with uncompiled evaluation.", //
    "coef",
    "The first argument `1` of `2` should be a non-empty list of positive integers.", //
    "color",
    "`1` is not a valid color or gray-level specification.", //
    "compat",
    "`1` and `2` are incompatible units", //
    "cxt",
    "`1` is not a valid context name.", //
    "divz",
    "The argument `1` should be nonzero.", //
    "digit",
    "Digit at position `1` in `2` is too large to be used in base `3`.", //
      "dmval",
      "Input value `1` lies outside the range of data in the interpolating function. Extrapolation will be used.",
    "drop",
    "Cannot drop positions `1` through `2` in `3`.", //
    "empt",
    "Argument `1` should be a non-empty list.", //
    "eqf",
    "`1` is not a well-formed equation.", //
    "exact",
    "Argument `1` is not an exact number.", //
    "exdims",
    "The dimensions cannot be determined from the position `1`.", //
    "fdup",
    "Duplicate parameter `1` found in `2`.", //
    "fftl",
    "Argument `1` is not a non-empty list or rectangular array of numeric quantities.", //
    "fpct",
    "To many parameters in `1` to be filled from `2`.", //
    "fnsym",
    "First argument in `1` is not a symbol or a string naming a symbol.", //
    "heads",
    "Heads `1` and `2` are expected to be the same.", //
    "idim",
    "`1` and `2` must have the same length.", //
    "ilsnn",
    "Single or list of non-negative integers expected at position `1`.", //
    "incom",
    "Length `1` of dimension `2` in `3` is incommensurate with length `4` of dimension `5` in `6`.", //
    "incomp",
    "Expressions `1` and `2` have incompatible shapes.", //
    "incpt",
    "incompatible elements in `1` cannot be joined.", //
    "indet",
    "Indeterminate expression `1` encountered.", //
    "infy",
    "Infinite expression `1` encountered.", //
    "innf",
    "Non-negative integer or Infinity expected at position `1` in `2`.", //
    "ins",
    "Cannot insert at position `1` in `2`.", //
    "int",
    "Integer expected at position `2` in `1`.", //
    "intjava",
    "Java int value greater equal `1` expected instead of `2`.", //
    "intlevel",
    "Level specification value greater equal `1` expected instead of `2`.", //
    "intp",
    "Positive integer expected.", //
    "intnn",
    "Non-negative integer expected.", //
    "intnm",
    "Non-negative machine-sized integer expected at position `2` in `1`.", //
    "intm",
    "Machine-sized integer expected at position `2` in `1`.", //
    "intpm",
    "Positive machine-sized integer expected at position `2` in `1`.", //
    "intrange",
    "Integer expected in range `1` to `2`.", //
    "invdt",
    "The argument is not a rule or a list of rules.", //
    "invrl",
    "The argument `1` is not a valid Association or a list of rules.", //
    "iterb",
    "Iterator does not have appropriate bounds.", //
    "itform",
    "Argument `1` at position `2` does not have the correct form for an iterator.", //
    "itlim",
    "Iteration limit of `1` exceeded.", //
    "itlimpartial",
    "Iteration limit of `1` exceeded. Returning partial results.", //
    "itendless",
    "Endless iteration detected in `1` in evaluation loop.", //
    "itraw",
    "Raw object `1` cannot be used as an iterator.", //
    "ivar",
    "`1` is not a valid variable.", //
      "lend",
    "The argument at position `1` in `2` should be a vector of unsigned byte values or a Base64 encoded string.", //
    "level",
    "Level specification `1` is not of the form n, {n}, or {m, n}.", //
    "levelpad",
    "The padding specification `1` involves `2` levels, the list `3` has only `4` level.", //
    "limset",
    "Cannot set $RecursionLimit to `1`; value must be Infinity or an integer at least 20.", //
    "list",
    "List expected at position `1` in `2`.", //
    "listofbigints",
    "List of Java BigInteger numbers expected in `1`.", //
    "listofints",
    "List of Java int numbers expected in `1`.", //
    "listoflongs",
    "List of Java long numbers expected in `1`.", //
    "locked",
    "Symbol `1` is locked.", //
    "lvlist",
    "Local variable specification `1` is not a List.", //
    "lvws",
    "Variable `1` in local variable specification `2` requires assigning a value", //
      "lvset",
    "Local variable specification `1` contains `2`, which is an assignment to `3`; only assignments to symbols are allowed.", //
    "lvsym",
    "Local variable specification `1` contains `2` which is not a symbol or an assignment to a symbol.", //
    "matrix",
    "Argument `1` at position `2` is not a non-empty rectangular matrix.", //
    "matsq",
    "Argument `1` at position `2` is not a non-empty square matrix.", //
    "mseqs",
    "Sequence specification or a list of sequence specifications expected at position `1` in `2`.", //
    "nconvss",
    "The argument `1` cannot be converted to a NumericArray of type `2` using method `3`", //
    "nliter",
    "Non-list iterator `1` at position `2` does not evaluate to a real numeric value.", //
    "nil",
    "unexpected NIL expression encountered.", //
    "nocatch",
    "Uncaught `1` returned to top level.", //
    "noneg",
    "Argument `1` should be a real non-negative number.", //
    "nonegs",
    "Surd is not defined for even roots of negative values.", //
    "noopen",
    "Cannot open `1`.", //
      "nonopt",
      "Options expected (instead of `1`) beyond position `2` in `3`. An option must be a rule or a list of rules.",
//
      "nord", "Invalid comparison with `1` attempted.", //
      "normal", "Nonatomic expression expected at position `1` in `2`.", //
      "notent", "`2` is not a known entity, class, or tag for `1`.", //
      "nquan", "The Quantile specification `1` should be a number between `2` and `3`.", "nvld",
      "The expression `1` is not a valid interval.", //
      "notunicode",
      "A character unicode, which should be a non-negative integer less than 1114112, is expected at position `2` in `1`.",
      //
      "noprime", "There are no primes in the specified interval.", //
      "noval", "Symbol `1` in part assignment does not have an immediate value.", //
      "nsmet", "This system cannot be solved with the methods available to `1`", //
      "nvm", "The first Norm argument should be a scalar, vector or matrix.", //
      "openx", "`1` is not open.", //
      "optb", "Optional object `1` in `2` is not a single blank.", //
      "optnf", "Option name `2` not found in defaults for `1`", //
      "optx", "Unknown option `1` in `2`.", //
      "ovfl", "Overflow occurred in computation.", //
      "padlevel",
      "The padding specification `1` involves `2` levels; the list `3` has only `4` level.", //
      "partd", "Part specification `1` is longer than depth of object.", //
      "partw", "Part `1` of `2` does not exist.", //
      "pilist",
    "The arguments to `1` must be two lists of integers of identical length, with the second list only containing positive integers.", //
    "plld",
    "Endpoints in `1` must be distinct machine-size real numbers.", //
    "plln",
    "Limiting value `1` in `2` is not a machine-size real number.", //
    "pspec",
    "Part specification `1` is neither an integer nor a list of integer.", //
    "poly",
    "`1` is not a polynomial.", //
    "polynomial",
    "Polynomial expected at position `1` in `2`.", //
    "posr",
    "The left hand side of `2` in `1` doesn't match an int-array of depth `3`.", //
    "pkspec1",
    "The expression `1` cannot be used as a part specification.", //
    "precsm",
    "Requested precision `1` is smaller than `2`.", //
    "precgt",
    "Requested precision `1` is greater than `2`.", //
    "range",
    "Range specification in `1` does not have appropriate bounds.", //
    "realx",
    "The value `1` is not a real number.", //
    "reclim2",
    "Recursion depth of `1` exceeded during evaluation of `2`.", //
    "rectt",
    "Rectangular array expected at position `1` in `2`.", //
    "reps",
    "(`1`) is neither a list of replacement nor a valid dispatch table and cannot be used for replacing.", //
    "rvalue",
    "`1` is not a variable with a value, so its value cannot be changed.", //
    "rubiendless",
    "Endless iteration detected in `1` for Rubi pattern-matching rules.", //
    "seqs",
    "Sequence specification expected, but got `1`.", //
    "setp",
    "Part assignment to `1` could not be made", //
    "setraw",
    "Cannot assign to raw object `1`.", //
    "setps",
    "`1` in the part assignment is not a symbol.", //
    "sing",
    "Matrix `1` is singular.", //
    "span",
    "`1` is not a valid Span specification.", //
    "ssle",
    "Symbol, string or HoldPattern(symbol) expected at position `2` in `1`.", //
    "step",
    "The step size `1` is expected to be positive", //
    "stream",
    "`1` is not string, InputStream[], or OutputStream[]", //
    "string",
    "String expected at position `1` in `2`.", //
    "sym",
    "Argument `1` at position `2` is expected to be a symbol.", //
    "tdlen",
    "Objects of unequal length in `1` cannot be combined.", //
    "tag",
    "Rule for `1` can only be attached to `2`.", //
    "take",
    "Cannot take positions `1` through `2` in `3`.", //
    "toggle",
    "ToggleFeature `1` is disabled.", //
    "unsupported",
    "`1` currently not supported in `2`.", //
    "usraw",
    "Cannot unset object `1`.", //
      "vloc",
      "The variable `1` cannot be localized so that it can be assigned to numerical values.", //
    "vpow2",
    "Argument `1` is restricted to vectors with a length of power of 2.", //
    "vrule",
    "Cannot set `1` to `2`, which is not a valid list of replacement rules.", //
    "write",
    "Tag `1` in `2` is Protected.", //
    "wrsym",
    "Symbol `1` is Protected.", //
    "ucdec",
    "An invalid unicode sequence was encountered and ignored.", //
    // Symja special
    "zzregex",
    "Regex expression `1` error message: `2`" //
  };

  public static void initialize() {
    Initializer.init();
  }

  public static IExpr message(ISymbol symbol, String messageShortcut, final IAST list) {
    IExpr temp = symbol.evalMessage(messageShortcut);
    String message = null;
    if (temp.isPresent()) {
      message = temp.toString();
    } else {
      temp = F.General.evalMessage(messageShortcut);
      if (temp.isPresent()) {
        message = temp.toString();
      }
    }
    if (message != null) {
      message = rawMessage(list, message);
      return F.stringx(symbol.toString() + ": " + message);
    }
    return F.NIL;
  }

  /**
   * argr, argx, argrx, argt messages
   *
   * <p><b>Example:</b> &quot;`1` called with 1 argument; `2` arguments are expected.&quot;
   *
   * @param ast
   * @param expected
   * @param engine
   * @return
   */
  public static IAST printArgMessage(IAST ast, int[] expected, EvalEngine engine) {
    final ISymbol topHead = ast.topHead();
    int argSize = ast.argSize();
    if (expected[0] == expected[1]) {
      if (expected[0] == 1) {
        return printMessage(topHead, "argx", F.List(topHead, F.ZZ(argSize), F.ZZ(expected[0])),
            engine);
      }
      if (argSize == 1) {
        return printMessage(topHead, "argr", F.List(topHead, F.ZZ(expected[0])), engine);
      }
      return printMessage(topHead, "argrx", F.List(topHead, F.ZZ(argSize), F.ZZ(expected[0])),
          engine);
    }
    return printMessage(topHead, "argt",
        F.List(topHead, F.ZZ(argSize), F.ZZ(expected[0]), F.ZZ(expected[1])),
        engine);
  }

  /**
   * Format a message according to the shortcut from the <code>MESSAGES</code> array and print it to
   * the error stream with the <code>engine.printMessage()</code>method.
   *
   * @param symbol
   * @param messageShortcut the message shortcut defined in the <code>MESSAGES</code> array
   * @param listOfArgs a list of arguments which should be inserted into the message shortcuts
   *     placeholder
   * @param engine
   * @return always <code>F.NIL</code>
   */
  public static IAST printMessage(ISymbol symbol, String messageShortcut, final IAST listOfArgs,
      EvalEngine engine) {
    IExpr temp = symbol.evalMessage(messageShortcut);
    String message = null;
    if (temp.isPresent()) {
      message = temp.toString();
    } else {
      temp = F.General.evalMessage(messageShortcut);
      if (temp.isPresent()) {
        message = temp.toString();
      }
    }

    if (message == null) {
      message = "Undefined message shortcut: " + messageShortcut;
      engine.setMessageShortcut(messageShortcut);
      engine.printMessage(symbol.toString() + ": " + message);
    } else {
      for (int i = 1; i < listOfArgs.size(); i++) {
        message = StringUtils.replace(message, "`" + (i) + "`", shorten(listOfArgs.get(i)));
      }
      engine.setMessageShortcut(messageShortcut);
      engine.printMessage(symbol.toString() + ": " + message);
    }
    return F.NIL;
  }

  public static String getMessage(String messageShortcut, final IAST listOfArgs) {
    return getMessage(messageShortcut, listOfArgs, EvalEngine.get());
  }

  public static String getMessage(String messageShortcut, final IAST listOfArgs,
      EvalEngine engine) {
    IExpr temp = F.General.evalMessage(messageShortcut);
    String message = null;
    if (temp.isPresent()) {
      message = temp.toString();
    }
    if (message == null) {
      message = "Undefined message shortcut: " + messageShortcut;
      engine.setMessageShortcut(messageShortcut);
      return message;
    }
    for (int i = 1; i < listOfArgs.size(); i++) {
      message = StringUtils.replace(message, "`" + (i) + "`", shorten(listOfArgs.get(i)));
    }
    engine.setMessageShortcut(messageShortcut);
    return message;
  }

  public static IAST printMessage(ISymbol symbol, Exception ex, EvalEngine engine) {
    String message = ex.getMessage();
    if (message != null) {
      engine.printMessage(symbol.toString() + ": " + message);
    } else {
      engine.printMessage(symbol.toString() + ": " + ex.getClass().toString());
    }
    return F.NIL;
  }

  private static String rawMessage(final IAST list, String message) {
    for (int i = 2; i < list.size(); i++) {
      message = StringUtils.replace(message, "`" + (i - 1) + "`", shorten(list.get(i)));
    }
    return message;
  }

  /**
   * Shorten the output string generated from <code>expr</code> to a maximum length of <code>
   * Config.SHORTEN_STRING_LENGTH</code> characters. Print <<SHORT>> as substitute of the middle of
   * the expression if necessary.
   *
   * @param expr
   * @return
   */
  public static String shorten(IExpr expr) {
    return shorten(expr, Config.SHORTEN_STRING_LENGTH);
  }

  /**
   * Shorten the output string generated from <code>expr</code> to a maximum length of <code>
   * maximuLength</code> characters. Print <<SHORT>> as substitute of the middle of the expression
   * if necessary.
   *
   * @param expr
   * @param maximuLength the maximum length of the result string.
   * @return
   */
  public static String shorten(IExpr expr, int maximuLength) {
    String str = expr.toString();
    if (str.length() > maximuLength) {
      StringBuilder buf = new StringBuilder(maximuLength);
      int halfLength = (maximuLength / 2) - 14;
      buf.append(str.substring(0, halfLength));
      buf.append("<<SHORT>>");
      buf.append(str.substring(str.length() - halfLength));
      return buf.toString();
    }
    return str;
  }

  public static IAST getNamesByPattern(java.util.regex.Pattern pattern, EvalEngine engine) {
    ContextPath cp = engine.getContextPath();
    IASTAppendable list = F.ListAlloc();
    for (Context context : cp) {
      for (Map.Entry<String, ISymbol> entry : context.entrySet()) {
        String fullName = context.getContextName() + entry.getKey();
        // System.out.println(fullName);
        java.util.regex.Matcher matcher = pattern.matcher(fullName);
        if (matcher.matches()) {
          if (FEConfig.PARSER_USE_LOWERCASE_SYMBOLS && context.equals(Context.SYSTEM)) {
            String str = AST2Expr.PREDEFINED_SYMBOLS_MAP.get(entry.getValue().getSymbolName());
            if (str != null) {
              list.append(F.$str(str));
              continue;
            }
          }
          list.append(F.$str(entry.getKey()));
        }
      }
    }
    return list;
  }
  public static IAST getNamesByPrefix(String name) {

    if (name.length() == 0) {
      return F.List();
    }
    boolean exact = true;
    if (name.charAt(name.length() - 1) == '*') {
      name = name.substring(0, name.length() - 1);
      if (name.length() == 0) {
        return getAllNames();
      }
      exact = false;
    }
    SuggestTree suggestTree = AST2Expr.getSuggestTree();
    //    name = FEConfig.PARSER_USE_LOWERCASE_SYMBOLS ? name.toLowerCase(Locale.US) : name;
    name = name.toLowerCase(Locale.US);
    Node n = suggestTree.getAutocompleteSuggestions(name);
    if (n != null) {
      IASTAppendable list = F.ListAlloc(n.listLength());
      for (int i = 0; i < n.listLength(); i++) {
        String identifierStr = n.getSuggestion(i).getTerm();
        String str = AST2Expr.PREDEFINED_SYMBOLS_MAP.get(identifierStr);
        if (str != null) {
          identifierStr = str;
        }
        if (exact) {
          if (name.equals(identifierStr)) {
            list.append(F.$s(identifierStr));
          }
        } else {
          list.append(F.$s(identifierStr));
        }
      }
      return list;
    }
    return F.List();
  }

  public static List<String> getAutoCompletionList(String namePrefix) {
    List<String> list = new ArrayList<String>();
    if (namePrefix.length() == 0) {
      return list;
    }
    SuggestTree suggestTree = AST2Expr.getSuggestTree();
    namePrefix = FEConfig.PARSER_USE_LOWERCASE_SYMBOLS ? namePrefix.toLowerCase(Locale.US) : namePrefix;
    Node n = suggestTree.getAutocompleteSuggestions(namePrefix);
    if (n != null) {
      for (int i = 0; i < n.listLength(); i++) {
        list.add(n.getSuggestion(i).getTerm());
      }
    }
    return list;
  }

  public static IAST getAllNames() {
    int size = AST2Expr.FUNCTION_STRINGS.length;
    IASTAppendable list = F.ListAlloc(size);
    return list.appendArgs(0, size, new IntFunction<IExpr>() {
      @Override
      public IExpr apply(int i) {
        return F.$s(AST2Expr.FUNCTION_STRINGS[i]);
      }
    });

  }

  private IOFunctions() {}
}
