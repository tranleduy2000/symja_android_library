package org.matheclipse.core.expression;

import com.duy.annotations.Nonnull;
import com.duy.lambda.BiFunction;
import com.duy.lambda.BiPredicate;
import com.duy.lambda.Consumer;
import com.duy.lambda.Function;
import com.duy.lambda.IntFunction;
import com.duy.lambda.Predicate;
import com.duy.lang.DDouble;
import com.gx.common.cache.Cache;
import com.gx.common.cache.CacheBuilder;

import org.apache.commons.lang3.StringUtils;
import org.apfloat.Apcomplex;
import org.apfloat.Apfloat;
import org.apfloat.ApfloatContext;
import org.hipparchus.complex.Complex;
import org.hipparchus.fraction.BigFraction;
import org.matheclipse.core.basic.Config;
import org.matheclipse.core.builtin.Algebra;
import org.matheclipse.core.builtin.Arithmetic;
import org.matheclipse.core.builtin.AssociationFunctions;
import org.matheclipse.core.builtin.AssumptionFunctions;
import org.matheclipse.core.builtin.AttributeFunctions;
import org.matheclipse.core.builtin.BesselFunctions;
import org.matheclipse.core.builtin.BooleanFunctions;
import org.matheclipse.core.builtin.ClusteringFunctions;
import org.matheclipse.core.builtin.Combinatoric;
import org.matheclipse.core.builtin.ComputationalGeometryFunctions;
import org.matheclipse.core.builtin.ConstantDefinitions;
import org.matheclipse.core.builtin.ContainsFunctions;
import org.matheclipse.core.builtin.CurveFitterFunctions;
import org.matheclipse.core.builtin.EllipticIntegrals;
import org.matheclipse.core.builtin.EntityFunctions;
import org.matheclipse.core.builtin.ExpTrigsFunctions;
import org.matheclipse.core.builtin.FinancialFunctions;
import org.matheclipse.core.builtin.FunctionDefinitions;
import org.matheclipse.core.builtin.GeodesyFunctions;
import org.matheclipse.core.builtin.GraphDataFunctions;
import org.matheclipse.core.builtin.GraphFunctions;
import org.matheclipse.core.builtin.HypergeometricFunctions;
import org.matheclipse.core.builtin.IOFunctions;
import org.matheclipse.core.builtin.ImageFunctions;
import org.matheclipse.core.builtin.IntegerFunctions;
import org.matheclipse.core.builtin.IntervalFunctions;
import org.matheclipse.core.builtin.LinearAlgebra;
import org.matheclipse.core.builtin.ListFunctions;
import org.matheclipse.core.builtin.ManipulateFunction;
import org.matheclipse.core.builtin.MinMaxFunctions;
import org.matheclipse.core.builtin.NumberTheory;
import org.matheclipse.core.builtin.OutputFunctions;
import org.matheclipse.core.builtin.PatternMatching;
import org.matheclipse.core.builtin.PolynomialFunctions;
import org.matheclipse.core.builtin.PredicateQ;
import org.matheclipse.core.builtin.Programming;
import org.matheclipse.core.builtin.QuantityFunctions;
import org.matheclipse.core.builtin.RandomFunctions;
import org.matheclipse.core.builtin.SeriesFunctions;
import org.matheclipse.core.builtin.SimplifyFunctions;
import org.matheclipse.core.builtin.SparseArrayFunctions;
import org.matheclipse.core.builtin.SpecialFunctions;
import org.matheclipse.core.builtin.StatisticsFunctions;
import org.matheclipse.core.builtin.StringFunctions;
import org.matheclipse.core.builtin.StructureFunctions;
import org.matheclipse.core.builtin.TensorFunctions;
import org.matheclipse.core.builtin.VectorAnalysisFunctions;
import org.matheclipse.core.builtin.WXFFunctions;
import org.matheclipse.core.builtin.WindowFunctions;
import org.matheclipse.core.convert.AST2Expr;
import org.matheclipse.core.convert.Object2Expr;
import org.matheclipse.core.eval.EvalAttributes;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.Predicates;
import org.matheclipse.core.eval.exception.ASTElementLimitExceeded;
import org.matheclipse.core.eval.interfaces.AbstractCoreFunctionEvaluator;
import org.matheclipse.core.eval.interfaces.ICoreFunctionEvaluator;
import org.matheclipse.core.eval.util.IAssumptions;
import org.matheclipse.core.eval.util.Lambda;
import org.matheclipse.core.expression.data.GraphExpr;
import org.matheclipse.core.expression.data.SparseArrayExpr;
import org.matheclipse.core.form.Documentation;
import org.matheclipse.core.generic.Functors;
import org.matheclipse.core.graphics.Show2SVG;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IASTAppendable;
import org.matheclipse.core.interfaces.IASTMutable;
import org.matheclipse.core.interfaces.IAssociation;
import org.matheclipse.core.interfaces.IBuiltInSymbol;
import org.matheclipse.core.interfaces.IComplex;
import org.matheclipse.core.interfaces.IComplexNum;
import org.matheclipse.core.interfaces.IEvaluator;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.IFraction;
import org.matheclipse.core.interfaces.IInteger;
import org.matheclipse.core.interfaces.INum;
import org.matheclipse.core.interfaces.INumber;
import org.matheclipse.core.interfaces.IPattern;
import org.matheclipse.core.interfaces.IPatternSequence;
import org.matheclipse.core.interfaces.IRational;
import org.matheclipse.core.interfaces.ISignedNumber;
import org.matheclipse.core.interfaces.ISparseArray;
import org.matheclipse.core.interfaces.IStringX;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.core.parser.ExprParser;
import org.matheclipse.core.parser.ExprParserFactory;
import org.matheclipse.core.patternmatching.IPatternMapImpl;
import org.matheclipse.core.patternmatching.IPatternMatcher;
import org.matheclipse.parser.client.FEConfig;
import org.matheclipse.parser.client.SyntaxError;
import org.matheclipse.parser.trie.Tries;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.IdentityHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import org.matheclipse.core.tensor.QuantityParser;
import edu.jas.kern.ComputerThreads;
import edu.jas.kern.PreemptStatus;
import it.unimi.dsi.fastutil.objects.Object2ShortOpenHashMap;

/**
 *
 * Factory for creating Symja predefined function expression objects (interface {@link IAST}).
 *
 */
@SuppressWarnings({"JavaDoc", "JavadocReference"})
public class F {

	/**
	 * <p>
	 * In computing, memoization or memoisation is an optimization technique used primarily to speed up computer
	 * programs by storing the results of expensive function calls and returning the cached result when the same inputs
	 * occur again. This cache is especially used for recursive integer functions to remember the results of the
	 * recursive call.
	 * </p>
	 *
	 * See: <a href="https://en.wikipedia.org/wiki/Memoization">Wikipedia - Memoization</a>
	 */
	public static Cache<IAST, IExpr> REMEMBER_INTEGER_CACHE = CacheBuilder.newBuilder().maximumSize(500).build();

	/**
	 * <p>
	 * In computing, memoization or memoisation is an optimization technique used primarily to speed up computer
	 * programs by storing the results of expensive function calls and returning the cached result when the same inputs
	 * occur again.
	 * </p>
	 * <p>
	 * This cache is especially used for expensive functions like <code>FullSimplify, Factor,...</code> to remember the
	 * results of the function call. It often also stores the <code>F.NIL</code> result to indicate that a new
	 * evaluation of a function is unnecessary.
	 * </p>
	 *
	 * See: <a href="https://en.wikipedia.org/wiki/Memoization">Wikipedia - Memoization</a>
	 */
	public static Cache<IAST, IExpr> REMEMBER_AST_CACHE = CacheBuilder.newBuilder().maximumSize(500).build();

	/**
	 * Set to <code>true</code> at the start of initSymbols() method
	 */
	public static volatile boolean isSystemStarted = false;

	/**
	 * Set to <code>true</code> at the end of initSymbols() method
	 */
	public static volatile boolean isSystemInitialized = false;
    /**
     * The map for predefined strings for the {@link IExpr#internalFormString(boolean, int)} method.
     */
	public final static Map<String, String> PREDEFINED_INTERNAL_FORM_STRINGS = Tries.forStrings();

	public final static Map<String, IPattern> PREDEFINED_PATTERN_MAP = Tries.forStrings();

	public final static Map<String, IPatternSequence> PREDEFINED_PATTERNSEQUENCE_MAP = Tries.forStrings();

	public static ISymbolObserver SYMBOL_OBSERVER = new ISymbolObserver() {
		@Override
		public final boolean createPredefinedSymbol(String symbol) {
			return false;
		}

		@Override
		public void createUserSymbol(ISymbol symbol) {

		}

	};
	// private static final Cache<IAST, IAST> PARSER_AST_CACHE = CacheBuilder.newBuilder().maximumSize(1024).build();
	// Android changed: more symbols
	final private static IBuiltInSymbol[] BUILT_IN_SYMBOLS = new IBuiltInSymbol[ID.Zeta + 200];

	final static short EXPRID_MAX_BUILTIN_LENGTH = (short) (BUILT_IN_SYMBOLS.length + 1);

	/** package private */
	static IExpr[] COMMON_IDS = null;

	/**
	 * Global map of predefined constant expressions.
	 */
	public final static Object2ShortOpenHashMap<IExpr> GLOBAL_IDS_MAP = new Object2ShortOpenHashMap<IExpr>(
			EXPRID_MAX_BUILTIN_LENGTH + 1000);



	public final static Map<String, ISymbol> HIDDEN_SYMBOLS_MAP = Tries.forStrings();

	/***/
	public final static IBuiltInSymbol $Aborted = initFinalSymbol("$Aborted", ID.$Aborted);
	/***/
	public final static IBuiltInSymbol $Assumptions = initFinalSymbol("$Assumptions", ID.$Assumptions);

	/***/
	public final static IBuiltInSymbol $Cancel = initFinalSymbol("$Cancel", ID.$Cancel);

	/***/
	public final static IBuiltInSymbol $Context = initFinalSymbol("$Context", ID.$Context);
	/***/
	public final static IBuiltInSymbol $ContextPath = initFinalSymbol("$ContextPath", ID.$ContextPath);
	/***/
	public final static IBuiltInSymbol $CreationDate = initFinalSymbol("$CreationDate", ID.$CreationDate);
	/***/
	public final static IBuiltInSymbol $DisplayFunction = initFinalSymbol("$DisplayFunction", ID.$DisplayFunction);
	/***/
	public final static IBuiltInSymbol $Failed = initFinalSymbol("$Failed", ID.$Failed);
	/***/
	public final static IBuiltInSymbol $HistoryLength = initFinalSymbol("$HistoryLength", ID.$HistoryLength);
	/***/
	public final static IBuiltInSymbol $HomeDirectory = initFinalSymbol("$HomeDirectory", ID.$HomeDirectory);
	/***/
	public final static IBuiltInSymbol $IterationLimit = initFinalSymbol("$IterationLimit", ID.$IterationLimit);
	/***/
	public final static IBuiltInSymbol $Line = initFinalSymbol("$Line", ID.$Line);
	/***/
	public final static IBuiltInSymbol $MachineEpsilon = initFinalSymbol("$MachineEpsilon", ID.$MachineEpsilon);
	/***/
	public final static IBuiltInSymbol $MachinePrecision = initFinalSymbol("$MachinePrecision", ID.$MachinePrecision);
	/***/
	public final static IBuiltInSymbol $MaxMachineNumber = initFinalSymbol("$MaxMachineNumber", ID.$MaxMachineNumber);
	/***/
	public final static IBuiltInSymbol $MessageList = initFinalSymbol("$MessageList", ID.$MessageList);
	/***/
	public final static IBuiltInSymbol $MinMachineNumber = initFinalSymbol("$MinMachineNumber", ID.$MinMachineNumber);
	/***/
	public final static IBuiltInSymbol $OutputSizeLimit = initFinalSymbol("$OutputSizeLimit", ID.$OutputSizeLimit);
	/***/
	public final static IBuiltInSymbol $Path = initFinalSymbol("$Path", ID.$Path);

	/***/
	public final static IBuiltInSymbol $PathnameSeparator = initFinalSymbol("$PathnameSeparator",
			ID.$PathnameSeparator);
	/***/
	public final static IBuiltInSymbol $PrePrint = initFinalSymbol("$PrePrint", ID.$PrePrint);
	/***/
	public final static IBuiltInSymbol $PreRead = initFinalSymbol("$PreRead", ID.$PreRead);
	/***/
	public final static IBuiltInSymbol $RecursionLimit = initFinalSymbol("$RecursionLimit", ID.$RecursionLimit);
	/***/
	public final static IBuiltInSymbol $UserName = initFinalSymbol("$UserName", ID.$UserName);
	/***/
	public final static IBuiltInSymbol $Version = initFinalSymbol("$Version", ID.$Version);
	/** Abort() - aborts an evaluation completely and returns `$Aborted`. */
	public final static IBuiltInSymbol Abort = initFinalSymbol("Abort", ID.Abort);
	/** Abs(expr) - returns the absolute value of the real or complex number `expr`. */
	public final static IBuiltInSymbol Abs = initFinalSymbol("Abs", ID.Abs);
	/** AbsArg(expr) - returns a list of 2 values of the complex number `Abs(expr), Arg(expr)`. */
	public final static IBuiltInSymbol AbsArg = initFinalSymbol("AbsArg", ID.AbsArg);
	/***/
	public final static IBuiltInSymbol AbsoluteCorrelation = initFinalSymbol("AbsoluteCorrelation",
			ID.AbsoluteCorrelation);
	/***/
	public final static IBuiltInSymbol AbsoluteTime = initFinalSymbol("AbsoluteTime", ID.AbsoluteTime);
	/***/
	public final static IBuiltInSymbol AbsoluteTiming = initFinalSymbol("AbsoluteTiming", ID.AbsoluteTiming);
	/** Accumulate(list) - accumulate the values of `list` returning a new list. */
	public final static IBuiltInSymbol Accumulate = initFinalSymbol("Accumulate", ID.Accumulate);
	/** AddTo(x, dx) - is equivalent to `x = x + dx`. */
	public final static IBuiltInSymbol AddTo = initFinalSymbol("AddTo", ID.AddTo);
	/** AdjacencyMatrix(graph) - convert the `graph` into a adjacency matrix. */
	public final static IBuiltInSymbol AdjacencyMatrix = initFinalSymbol("AdjacencyMatrix", ID.AdjacencyMatrix);
	/** AiryAi(z) - returns the Airy function of the first kind of `z`. */
	public final static IBuiltInSymbol AiryAi = initFinalSymbol("AiryAi", ID.AiryAi);

	/** AiryAiPrime(z) - returns the derivative of the `AiryAi` function. */
	public final static IBuiltInSymbol AiryAiPrime = initFinalSymbol("AiryAiPrime", ID.AiryAiPrime);
	/** AiryBi(z) - returns the Airy function of the second kind of `z`. */
	public final static IBuiltInSymbol AiryBi = initFinalSymbol("AiryBi", ID.AiryBi);
	/** AiryBiPrime(z) - returns the derivative of the `AiryBi` function. */
	public final static IBuiltInSymbol AiryBiPrime = initFinalSymbol("AiryBiPrime", ID.AiryBiPrime);
	/***/
	public final static IBuiltInSymbol AlgebraicNumber = initFinalSymbol("AlgebraicNumber", ID.AlgebraicNumber);
	/***/
	public final static IBuiltInSymbol Algebraics = initFinalSymbol("Algebraics", ID.Algebraics);
	/** All - is a possible value for `Span` and `Quiet`. */
	public final static IBuiltInSymbol All = initFinalSymbol("All", ID.All);
	/**
	 * AllTrue({expr1, expr2, ...}, test) - returns `True` if all applications of `test` to `expr1, expr2, ...` evaluate
	 * to `True`.
	 */
	public final static IBuiltInSymbol AllTrue = initFinalSymbol("AllTrue", ID.AllTrue);
	/** Alternatives(p1, p2, ..., p_i) - is a pattern that matches any of the patterns `p1, p2,...., p_i`. */
	public final static IBuiltInSymbol Alternatives = initFinalSymbol("Alternatives", ID.Alternatives);
	/**
	 * And(expr1, expr2, ...) - `expr1 && expr2 && ...` evaluates each expression in turn, returning `False` as soon as
	 * an expression evaluates to `False`. If all expressions evaluate to `True`, `And` returns `True`.
	 */
	public final static IBuiltInSymbol And = initFinalSymbol("And", ID.And);
	/** AngleVector(phi) - returns the point at angle `phi` on the unit circle. */
	public final static IBuiltInSymbol AngleVector = initFinalSymbol("AngleVector", ID.AngleVector);
	/** Annuity(p, t) - returns an annuity object. */
	public final static IBuiltInSymbol Annuity = initFinalSymbol("Annuity", ID.Annuity);
	/** AnnuityDue(p, t) - returns an annuity due object. */
	public final static IBuiltInSymbol AnnuityDue = initFinalSymbol("AnnuityDue", ID.AnnuityDue);
	/***/
	public final static IBuiltInSymbol AntiSymmetric = initFinalSymbol("AntiSymmetric", ID.AntiSymmetric);
	/** AntihermitianMatrixQ(m) - returns `True` if `m` is a anti hermitian matrix. */
	public final static IBuiltInSymbol AntihermitianMatrixQ = initFinalSymbol("AntihermitianMatrixQ",
			ID.AntihermitianMatrixQ);

	/** AntisymmetricMatrixQ(m) - returns `True` if `m` is a anti symmetric matrix. */
	public final static IBuiltInSymbol AntisymmetricMatrixQ = initFinalSymbol("AntisymmetricMatrixQ",
			ID.AntisymmetricMatrixQ);

	/**
	 * AnyTrue({expr1, expr2, ...}, test) - returns `True` if any application of `test` to `expr1, expr2, ...` evaluates
	 * to `True`.
	 */
	public final static IBuiltInSymbol AnyTrue = initFinalSymbol("AnyTrue", ID.AnyTrue);
	/** Apart(expr) - rewrites `expr` as a sum of individual fractions. */
	public final static IBuiltInSymbol Apart = initFinalSymbol("Apart", ID.Apart);
	/***/
	public final static IBuiltInSymbol AppellF1 = initFinalSymbol("AppellF1", ID.AppellF1);
	/** Append(expr, item) - returns `expr` with `item` appended to its leaves. */
	public final static IBuiltInSymbol Append = initFinalSymbol("Append", ID.Append);
	/** AppendTo(s, item) - append `item` to value of `s` and sets `s` to the result. */
	public final static IBuiltInSymbol AppendTo = initFinalSymbol("AppendTo", ID.AppendTo);
	/** f @ expr - returns `f(expr)` */
	public final static IBuiltInSymbol Apply = initFinalSymbol("Apply", ID.Apply);
	/** ArcCos(expr) - returns the arc cosine (inverse cosine) of `expr` (measured in radians). */
	public final static IBuiltInSymbol ArcCos = initFinalSymbol("ArcCos", ID.ArcCos);
	/** ArcCosh(z) - returns the inverse hyperbolic cosine of `z`. */
	public final static IBuiltInSymbol ArcCosh = initFinalSymbol("ArcCosh", ID.ArcCosh);
	/** ArcCot(z) - returns the inverse cotangent of `z`. */
	public final static IBuiltInSymbol ArcCot = initFinalSymbol("ArcCot", ID.ArcCot);
	/** ArcCoth(z) - returns the inverse hyperbolic cotangent of `z`. */
	public final static IBuiltInSymbol ArcCoth = initFinalSymbol("ArcCoth", ID.ArcCoth);
	/** ArcCsc(z) - returns the inverse cosecant of `z`. */
	public final static IBuiltInSymbol ArcCsc = initFinalSymbol("ArcCsc", ID.ArcCsc);
	/** ArcCsch(z) - returns the inverse hyperbolic cosecant of `z`. */
	public final static IBuiltInSymbol ArcCsch = initFinalSymbol("ArcCsch", ID.ArcCsch);
	/** ArcSec(z) - returns the inverse secant of `z`. */
	public final static IBuiltInSymbol ArcSec = initFinalSymbol("ArcSec", ID.ArcSec);
	/** ArcSech(z) - returns the inverse hyperbolic secant of `z`. */
	public final static IBuiltInSymbol ArcSech = initFinalSymbol("ArcSech", ID.ArcSech);
	/** ArcSin(expr) - returns the arc sine (inverse sine) of `expr` (measured in radians). */
	public final static IBuiltInSymbol ArcSin = initFinalSymbol("ArcSin", ID.ArcSin);
	/** ArcSinh(z) - returns the inverse hyperbolic sine of `z`. */
	public final static IBuiltInSymbol ArcSinh = initFinalSymbol("ArcSinh", ID.ArcSinh);
	/** ArcTan(expr) - returns the arc tangent (inverse tangent) of `expr` (measured in radians). */
	public final static IBuiltInSymbol ArcTan = initFinalSymbol("ArcTan", ID.ArcTan);
	/** ArcTanh(z) - returns the inverse hyperbolic tangent of `z`. */
	public final static IBuiltInSymbol ArcTanh = initFinalSymbol("ArcTanh", ID.ArcTanh);
	/** Arg(expr) - returns the argument of the complex number `expr`. */
	public final static IBuiltInSymbol Arg = initFinalSymbol("Arg", ID.Arg);
	/** ArgMax(function, variable) - returns a maximizer point for a univariate `function`. */
	public final static IBuiltInSymbol ArgMax = initFinalSymbol("ArgMax", ID.ArgMax);

	/** ArgMin(function, variable) - returns a minimizer point for a univariate `function`. */
	public final static IBuiltInSymbol ArgMin = initFinalSymbol("ArgMin", ID.ArgMin);
	/** ArithmeticGeometricMean({a, b, c,...}) - returns the arithmetic geometric mean of `{a, b, c,...}`. */
	public final static IBuiltInSymbol ArithmeticGeometricMean = initFinalSymbol("ArithmeticGeometricMean",
			ID.ArithmeticGeometricMean);
	/** Array(f, n) - returns the `n`-element list `{f(1), ..., f(n)}`. */
	public final static IBuiltInSymbol Array = initFinalSymbol("Array", ID.Array);
	/** ArrayDepth(a) - returns the depth of the non-ragged array `a`, defined as `Length(Dimensions(a))`. */
	public final static IBuiltInSymbol ArrayDepth = initFinalSymbol("ArrayDepth", ID.ArrayDepth);
	/** ArrayPad(list, n) - adds `n` times `0` on the left and right of the `list`. */
	public final static IBuiltInSymbol ArrayPad = initFinalSymbol("ArrayPad", ID.ArrayPad);
	/** ArrayQ(expr) - tests whether expr is a full array. */
	public final static IBuiltInSymbol ArrayQ = initFinalSymbol("ArrayQ", ID.ArrayQ);
	/**
	 * ArrayReshape(list-of-values, list-of-dimension) - returns the `list-of-values` elements reshaped as nested list
	 * with dimensions according to the `list-of-dimension`.
	 */
	public final static IBuiltInSymbol ArrayReshape = initFinalSymbol("ArrayReshape", ID.ArrayReshape);
	/***/
	public final static IBuiltInSymbol ArrayRules = initFinalSymbol("ArrayRules", ID.ArrayRules);
	/***/
	public final static IBuiltInSymbol Arrays = initFinalSymbol("Arrays", ID.Arrays);
	/***/
	public final static IBuiltInSymbol AssociateTo = initFinalSymbol("AssociateTo", ID.AssociateTo);
	/** Association(list-of-rules) - create a `key->value` association map from the `list-of-rules`. */
	public final static IBuiltInSymbol Association = initFinalSymbol("Association", ID.Association);

	/***/
	public final static IBuiltInSymbol AssociationMap = initFinalSymbol("AssociationMap", ID.AssociationMap);
	/** AssociationQ(expr) - returns `True` if `expr` is an association, and `False` otherwise. */
	public final static IBuiltInSymbol AssociationQ = initFinalSymbol("AssociationQ", ID.AssociationQ);
	/***/
	public final static IBuiltInSymbol AssociationThread = initFinalSymbol("AssociationThread", ID.AssociationThread);
	/***/
	public final static IBuiltInSymbol Assumptions = initFinalSymbol("Assumptions", ID.Assumptions);
	/**
	 * AtomQ(x) - is true if `x` is an atom (an object such as a number or string, which cannot be divided into
	 * subexpressions using 'Part').
	 */
	public final static IBuiltInSymbol AtomQ = initFinalSymbol("AtomQ", ID.AtomQ);
	/** Attributes(symbol) - returns the list of attributes which are assigned to `symbol` */
	public final static IBuiltInSymbol Attributes = initFinalSymbol("Attributes", ID.Attributes);
	/***/
	public final static IBuiltInSymbol Automatic = initFinalSymbol("Automatic", ID.Automatic);
	/***/
	public final static IBuiltInSymbol Axes = initFinalSymbol("Axes", ID.Axes);
	/***/
	public final static IBuiltInSymbol AxesOrigin = initFinalSymbol("AxesOrigin", ID.AxesOrigin);
	/***/
	public final static IBuiltInSymbol AxesStyle = initFinalSymbol("AxesStyle", ID.AxesStyle);
	/***/
	public final static IBuiltInSymbol BSplineFunction = initFinalSymbol("BSplineFunction", ID.BSplineFunction);
	/***/
	public final static IBuiltInSymbol Background = initFinalSymbol("Background", ID.Background);
	/**
	 * BarChart(list-of-values, options) - plot a bar chart for a `list-of-values` with option `BarOrigin->Bottom` or
	 * `BarOrigin->Bottom`
	 */
	public final static IBuiltInSymbol BarChart = initFinalSymbol("BarChart", ID.BarChart);
	/***/
	public final static IBuiltInSymbol BarOrigin = initFinalSymbol("BarOrigin", ID.BarOrigin);

	/***/
	public final static IBuiltInSymbol BartlettWindow = initFinalSymbol("BartlettWindow", ID.BartlettWindow);

	/** BaseForm(integer, radix) - prints the `integer` number in base `radix` form. */
	public final static IBuiltInSymbol BaseForm = initFinalSymbol("BaseForm", ID.BaseForm);
	/** Begin("<context-name>") - start a new context definition */
	public final static IBuiltInSymbol Begin = initFinalSymbol("Begin", ID.Begin);
	/** BeginPackage("<context-name>") - start a new package definition */
	public final static IBuiltInSymbol BeginPackage = initFinalSymbol("BeginPackage", ID.BeginPackage);
	/***/
	public final static IBuiltInSymbol BeginTestSection = initFinalSymbol("BeginTestSection", ID.BeginTestSection);
	/**
	 * BellB(n) - the Bell number function counts the number of different ways to partition a set that has exactly `n`
	 * elements
	 */
	public final static IBuiltInSymbol BellB = initFinalSymbol("BellB", ID.BellB);
	/** BellY(n, k, {x1, x2, ... , xN}) - the second kind of Bell polynomials (incomplete Bell polynomials). */
	public final static IBuiltInSymbol BellY = initFinalSymbol("BellY", ID.BellY);
	/** BernoulliB(expr) - computes the Bernoulli number of the first kind. */
	public final static IBuiltInSymbol BernoulliB = initFinalSymbol("BernoulliB", ID.BernoulliB);
	/** BernoulliDistribution(p) - returns the Bernoulli distribution. */
	public final static IBuiltInSymbol BernoulliDistribution = initFinalSymbol("BernoulliDistribution",
			ID.BernoulliDistribution);
	/** BesselI(n, z) - modified Bessel function of the first kind. */
	public final static IBuiltInSymbol BesselI = initFinalSymbol("BesselI", ID.BesselI);
	/** BesselJ(n, z) - Bessel function of the first kind. */
	public final static IBuiltInSymbol BesselJ = initFinalSymbol("BesselJ", ID.BesselJ);
	/** BesselJZero(n, z) - is the `k`th zero of the `BesselJ(n,z)` function. */
	public final static IBuiltInSymbol BesselJZero = initFinalSymbol("BesselJZero", ID.BesselJZero);
	/** BesselK(n, z) - modified Bessel function of the second kind. */
	public final static IBuiltInSymbol BesselK = initFinalSymbol("BesselK", ID.BesselK);
	/** BesselY(n, z) - Bessel function of the second kind. */
	public final static IBuiltInSymbol BesselY = initFinalSymbol("BesselY", ID.BesselY);
	/** BesselYZero(n, z) - is the `k`th zero of the `BesselY(n,z)` function. */
	public final static IBuiltInSymbol BesselYZero = initFinalSymbol("BesselYZero", ID.BesselYZero);

	/** Beta(a, b) - is the beta function of the numbers `a`,`b`. */
	public final static IBuiltInSymbol Beta = initFinalSymbol("Beta", ID.Beta);
	/***/
	public final static IBuiltInSymbol BetaDistribution = initFinalSymbol("BetaDistribution", ID.BetaDistribution);
	/***/
	public final static IBuiltInSymbol BetaRegularized = initFinalSymbol("BetaRegularized", ID.BetaRegularized);
	/**
	 * BinCounts(list, width-of-bin) - count the number of elements, if `list`, is divided into successive bins with
	 * width `width-of-bin`.
	 */
	public final static IBuiltInSymbol BinCounts = initFinalSymbol("BinCounts", ID.BinCounts);
	/** BinaryDeserialize(byte-array) - deserialize the `byte-array` from WXF format into a Symja expression. */
	public final static IBuiltInSymbol BinaryDeserialize = initFinalSymbol("BinaryDeserialize", ID.BinaryDeserialize);
	/**
	 * BinaryDistance(u, v) - returns the binary distance between `u` and `v`. `0` if `u` and `v` are unequal. `1` if
	 * `u` and `v` are equal.
	 */
	public final static IBuiltInSymbol BinaryDistance = initFinalSymbol("BinaryDistance", ID.BinaryDistance);

	/** BinarySerialize(expr) - serialize the Symja `expr` into a byte array expression in WXF format. */
	public final static IBuiltInSymbol BinarySerialize = initFinalSymbol("BinarySerialize", ID.BinarySerialize);
	/** Binomial(n, k) - returns the binomial coefficient of the 2 integers `n` and `k` */
	public final static IBuiltInSymbol Binomial = initFinalSymbol("Binomial", ID.Binomial);
	/** BinomialDistribution(n, p) - returns the binomial distribution. */
	public final static IBuiltInSymbol BinomialDistribution = initFinalSymbol("BinomialDistribution",
			ID.BinomialDistribution);
	/** BitLengthi(x) - gives the number of bits needed to represent the integer `x`. The sign of `x` is ignored. */
	public final static IBuiltInSymbol BitLength = initFinalSymbol("BitLength", ID.BitLength);
	/***/
	public final static IBuiltInSymbol Black = initFinalSymbol("Black", ID.Black);
	/***/
	public final static IBuiltInSymbol BlackmanHarrisWindow = initFinalSymbol("BlackmanHarrisWindow",
			ID.BlackmanHarrisWindow);

	/***/
	public final static IBuiltInSymbol BlackmanNuttallWindow = initFinalSymbol("BlackmanNuttallWindow",
			ID.BlackmanNuttallWindow);
	/***/
	public final static IBuiltInSymbol BlackmanWindow = initFinalSymbol("BlackmanWindow", ID.BlackmanWindow);
	/***/
	public final static IBuiltInSymbol Blank = initFinalSymbol("Blank", ID.Blank);
	/***/
	public final static IBuiltInSymbol BlankNullSequence = initFinalSymbol("BlankNullSequence", ID.BlankNullSequence);
	/***/
	public final static IBuiltInSymbol BlankSequence = initFinalSymbol("BlankSequence", ID.BlankSequence);
	/** Block({list_of_local_variables}, expr ) - evaluates `expr` for the `list_of_local_variables` */
	public final static IBuiltInSymbol Block = initFinalSymbol("Block", ID.Block);
	/***/
	public final static IBuiltInSymbol Blue = initFinalSymbol("Blue", ID.Blue);
	/**
	 * Boole(expr) - returns `1` if `expr` evaluates to `True`; returns `0` if `expr` evaluates to `False`; and gives no
	 * result otherwise.
	 */
	public final static IBuiltInSymbol Boole = initFinalSymbol("Boole", ID.Boole);
	/**
	 * BooleanConvert(logical-expr) - convert the `logical-expr` to [disjunctive normal
	 * form](https://en.wikipedia.org/wiki/Disjunctive_normal_form)
	 */
	public final static IBuiltInSymbol BooleanConvert = initFinalSymbol("BooleanConvert", ID.BooleanConvert);
	/**
	 * BooleanMinimize(expr) - minimizes a boolean function with the [Quine McCluskey
	 * algorithm](https://en.wikipedia.org/wiki/Quine%E2%80%93McCluskey_algorithm)
	 */
	public final static IBuiltInSymbol BooleanMinimize = initFinalSymbol("BooleanMinimize", ID.BooleanMinimize);
	/** BooleanQ(expr) - returns `True` if `expr` is either `True` or `False`. */
	public final static IBuiltInSymbol BooleanQ = initFinalSymbol("BooleanQ", ID.BooleanQ);
	/**
	 * BooleanTable(logical-expr, variables) - generate [truth values](https://en.wikipedia.org/wiki/Truth_table) from
	 * the `logical-expr`
	 */
	public final static IBuiltInSymbol BooleanTable = initFinalSymbol("BooleanTable", ID.BooleanTable);
	/** BooleanVariables(logical-expr) - gives a list of the boolean variables that appear in the `logical-expr`. */
	public final static IBuiltInSymbol BooleanVariables = initFinalSymbol("BooleanVariables", ID.BooleanVariables);
	/** Booleans - is the set of boolean values. */
	public final static IBuiltInSymbol Booleans = initFinalSymbol("Booleans", ID.Booleans);
	/***/
	public final static IBuiltInSymbol Bottom = initFinalSymbol("Bottom", ID.Bottom);

	/** BoxWhiskerChart( ) - plot a box whisker chart. */
	public final static IBuiltInSymbol BoxWhiskerChart = initFinalSymbol("BoxWhiskerChart", ID.BoxWhiskerChart);
	/** BrayCurtisDistance(u, v) - returns the Bray Curtis distance between `u` and `v`. */
	public final static IBuiltInSymbol BrayCurtisDistance = initFinalSymbol("BrayCurtisDistance",
			ID.BrayCurtisDistance);
	/** Break() - exits a `For`, `While`, or `Do` loop. */
	public final static IBuiltInSymbol Break = initFinalSymbol("Break", ID.Break);
	/***/
	public final static IBuiltInSymbol Brown = initFinalSymbol("Brown", ID.Brown);
	/***/
	public final static IBuiltInSymbol Button = initFinalSymbol("Button", ID.Button);
	/** ByteArray({list-of-byte-values}) - converts the `list-of-byte-values` into a byte array. */
	public final static IBuiltInSymbol ByteArray = initFinalSymbol("ByteArray", ID.ByteArray);
	/***/
	public final static IBuiltInSymbol ByteArrayQ = initFinalSymbol("ByteArrayQ", ID.ByteArrayQ);
	/***/
	public final static IBuiltInSymbol ByteCount = initFinalSymbol("ByteCount", ID.ByteCount);
	/** C(n) - represents the `n`-th constant in a solution to a differential equation. */
	public final static IBuiltInSymbol C = initFinalSymbol("C", ID.C);
	/** CDF(distribution, value) - returns the cumulative distribution function of `value`. */
	public final static IBuiltInSymbol CDF = initFinalSymbol("CDF", ID.CDF);
	/***/
	public final static IBuiltInSymbol CForm = initFinalSymbol("CForm", ID.CForm);
	/***/
	public final static IBuiltInSymbol CMYColor = initFinalSymbol("CMYColor", ID.CMYColor);
	/**
	 * CanberraDistance(u, v) - returns the canberra distance between `u` and `v`, which is a weighted version of the
	 * Manhattan distance.
	 */
	public final static IBuiltInSymbol CanberraDistance = initFinalSymbol("CanberraDistance", ID.CanberraDistance);
	/** Cancel(expr) - cancels out common factors in numerators and denominators. */
	public final static IBuiltInSymbol Cancel = initFinalSymbol("Cancel", ID.Cancel);
	/***/
	public final static IBuiltInSymbol CancelButton = initFinalSymbol("CancelButton", ID.CancelButton);
	/** CarmichaelLambda(n) - the Carmichael function of `n` */
	public final static IBuiltInSymbol CarmichaelLambda = initFinalSymbol("CarmichaelLambda", ID.CarmichaelLambda);
	/** CartesianProduct(list1, list2) - returns the cartesian product for multiple lists. */
	public final static IBuiltInSymbol CartesianProduct = initFinalSymbol("CartesianProduct", ID.CartesianProduct);
	/** Cases(list, pattern) - returns the elements of `list` that match `pattern`. */
	public final static IBuiltInSymbol Cases = initFinalSymbol("Cases", ID.Cases);
	/** Catalan - Catalan's constant */
	public final static IBuiltInSymbol Catalan = initFinalSymbol("Catalan", ID.Catalan);
	/** CatalanNumber(n) - returns the catalan number for the integer argument `n`. */
	public final static IBuiltInSymbol CatalanNumber = initFinalSymbol("CatalanNumber", ID.CatalanNumber);
	/***/
	public final static IBuiltInSymbol Catch = initFinalSymbol("Catch", ID.Catch);
	/** Catenate({l1, l2, ...}) - concatenates the lists `l1, l2, ...` */
	public final static IBuiltInSymbol Catenate = initFinalSymbol("Catenate", ID.Catenate);
	/** Ceiling(expr) - gives the first integer greater than or equal `expr`. */
	public final static IBuiltInSymbol Ceiling = initFinalSymbol("Ceiling", ID.Ceiling);
	/***/
	public final static IBuiltInSymbol CenterDot = initFinalSymbol("CenterDot", ID.CenterDot);
	/** CentralMoment(list, r) - gives the the `r`th central moment (i.e. the `r`th moment about the mean) of `list`. */
	public final static IBuiltInSymbol CentralMoment = initFinalSymbol("CentralMoment", ID.CentralMoment);
	/***/
	public final static IBuiltInSymbol CharacterEncoding = initFinalSymbol("CharacterEncoding", ID.CharacterEncoding);
	/***/
	public final static IBuiltInSymbol CharacterRange = initFinalSymbol("CharacterRange", ID.CharacterRange);
	/**
	 * CharacteristicPolynomial(matrix, var) - computes the characteristic polynomial of a `matrix` for the variable
	 * `var`.
	 */
	public final static IBuiltInSymbol CharacteristicPolynomial = initFinalSymbol("CharacteristicPolynomial",
			ID.CharacteristicPolynomial);
	/***/
	public final static IBuiltInSymbol Characters = initFinalSymbol("Characters", ID.Characters);
	/** ChebyshevT(n, x) - returns the Chebyshev polynomial of the first kind `T_n(x)`. */
	public final static IBuiltInSymbol ChebyshevT = initFinalSymbol("ChebyshevT", ID.ChebyshevT);
	/** ChebyshevU(n, x) - returns the Chebyshev polynomial of the second kind `U_n(x)`. */
	public final static IBuiltInSymbol ChebyshevU = initFinalSymbol("ChebyshevU", ID.ChebyshevU);
	/**
	 * Check(expr, failure) - evaluates `expr`, and returns the result, unless messages were generated, in which case
	 * `failure` will be returned.
	 */
	public final static IBuiltInSymbol Check = initFinalSymbol("Check", ID.Check);

	/**
	 * ChessboardDistance(u, v) - returns the chessboard distance (also known as Chebyshev distance) between `u` and
	 * `v`, which is the number of moves a king on a chessboard needs to get from square `u` to square `v`.
	 */
	public final static IBuiltInSymbol ChessboardDistance = initFinalSymbol("ChessboardDistance",
			ID.ChessboardDistance);
	/***/
	public final static IBuiltInSymbol ChiSquareDistribution = initFinalSymbol("ChiSquareDistribution",
			ID.ChiSquareDistribution);
	/** ChineseRemainder({a1, a2, a3,...}, {n1, n2, n3,...}) - the chinese remainder function. */
	public final static IBuiltInSymbol ChineseRemainder = initFinalSymbol("ChineseRemainder", ID.ChineseRemainder);
	/**
	 * CholeskyDecomposition(matrix) - calculate the Cholesky decomposition of a hermitian, positive definite square
	 * `matrix`.
	 */
	public final static IBuiltInSymbol CholeskyDecomposition = initFinalSymbol("CholeskyDecomposition",
			ID.CholeskyDecomposition);
	/**
	 * Chop(numerical-expr) - replaces numerical values in the `numerical-expr` which are close to zero with symbolic
	 * value `0`.
	 */
	public final static IBuiltInSymbol Chop = initFinalSymbol("Chop", ID.Chop);
	/***/
	public final static IBuiltInSymbol CircleDot = initFinalSymbol("CircleDot", ID.CircleDot);
	/** CirclePoints(i) - gives the `i` points on the unit circle for a positive integer `i`. */
	public final static IBuiltInSymbol CirclePoints = initFinalSymbol("CirclePoints", ID.CirclePoints);
	/** Clear(symbol1, symbol2,...) - clears all values of the given symbols. */
	public final static IBuiltInSymbol Clear = initFinalSymbol("Clear", ID.Clear);
	/** ClearAll(symbol1, symbol2,...) - clears all values and attributes associated with the given symbols. */
	public final static IBuiltInSymbol ClearAll = initFinalSymbol("ClearAll", ID.ClearAll);
	/** ClearAttributes(symbol, attrib) - removes `attrib` from `symbol`'s attributes. */
	public final static IBuiltInSymbol ClearAttributes = initFinalSymbol("ClearAttributes", ID.ClearAttributes);
	/**
	 * Clip(expr) - returns `expr` in the range `-1` to `1`. Returns `-1` if `expr` is less than `-1`. Returns `1` if
	 * `expr` is greater than `1`.
	 */
	public final static IBuiltInSymbol Clip = initFinalSymbol("Clip", ID.Clip);
	/** Coefficient(polynomial, variable, exponent) - get the coefficient of `variable^exponent` in `polynomial`. */
	public final static IBuiltInSymbol Coefficient = initFinalSymbol("Coefficient", ID.Coefficient);
	/** CoefficientList(polynomial, variable) - get the coefficient list of a `polynomial`. */
	public final static IBuiltInSymbol CoefficientList = initFinalSymbol("CoefficientList", ID.CoefficientList);
	/** CoefficientRules(polynomial, list-of-variables) - get the list of coefficient rules of a `polynomial`. */
	public final static IBuiltInSymbol CoefficientRules = initFinalSymbol("CoefficientRules", ID.CoefficientRules);
	/** Collect(expr, variable) - collect subexpressions in `expr` which belong to the same `variable`. */
	public final static IBuiltInSymbol Collect = initFinalSymbol("Collect", ID.Collect);
	/***/
	public final static IBuiltInSymbol Colon = initFinalSymbol("Colon", ID.Colon);
	/***/
	public final static IBuiltInSymbol ColorData = initFinalSymbol("ColorData", ID.ColorData);

	/***/
	public final static IBuiltInSymbol ColorFunction = initFinalSymbol("ColorFunction", ID.ColorFunction);
	/***/
	public final static IBuiltInSymbol Column = initFinalSymbol("Column", ID.Column);
	/** Commonest(data-values-list) - the mode of a list of data values is the value that appears most often. */
	public final static IBuiltInSymbol Commonest = initFinalSymbol("Commonest", ID.Commonest);
	/***/
	public final static IBuiltInSymbol CompatibleUnitQ = initFinalSymbol("CompatibleUnitQ", ID.CompatibleUnitQ);
	/***/
	public final static IBuiltInSymbol Compile = initFinalSymbol("Compile", ID.Compile);
	/***/
	public final static IBuiltInSymbol CompiledFunction = initFinalSymbol("CompiledFunction", ID.CompiledFunction);

	/** Complement(set1, set2) - get the complement set from `set1` and `set2`. */
	public final static IBuiltInSymbol Complement = initFinalSymbol("Complement", ID.Complement);
	/** Complex - is the head of complex numbers. */
	public final static IBuiltInSymbol Complex = initFinalSymbol("Complex", ID.Complex);
	/**
	 * ComplexExpand(expr) - get the expanded `expr`. All variable symbols in `expr` are assumed to be non complex
	 * numbers.
	 */
	public final static IBuiltInSymbol ComplexExpand = initFinalSymbol("ComplexExpand", ID.ComplexExpand);
	/** ComplexInfinity - represents an infinite complex quantity of undetermined direction. */
	public final static IBuiltInSymbol ComplexInfinity = initFinalSymbol("ComplexInfinity", ID.ComplexInfinity);
	/**
	 * ComplexPlot3D(expr, {z, min, max ) - create a 3D plot of `expr` for the complex variable `z` in the range `{
	 * Re(min),Re(max) }` to `{ Im(min),Im(max) }`
	 */
	public final static IBuiltInSymbol ComplexPlot3D = initFinalSymbol("ComplexPlot3D", ID.ComplexPlot3D);
	/** Complexes - is the set of complex numbers. */
	public final static IBuiltInSymbol Complexes = initFinalSymbol("Complexes", ID.Complexes);
	/***/
	public final static IBuiltInSymbol ComplexityFunction = initFinalSymbol("ComplexityFunction",
			ID.ComplexityFunction);
	/**
	 * ComposeList(list-of-symbols, variable) - creates a list of compositions of the symbols applied at the argument
	 * `x`.
	 */
	public final static IBuiltInSymbol ComposeList = initFinalSymbol("ComposeList", ID.ComposeList);
	/** ComposeSeries( series1, series2 ) - substitute `series2` into `series1` */
	public final static IBuiltInSymbol ComposeSeries = initFinalSymbol("ComposeSeries", ID.ComposeSeries);
	/** Composition(sym1, sym2,...)[arg1, arg2,...] - creates a composition of the symbols applied at the arguments. */
	public final static IBuiltInSymbol Composition = initFinalSymbol("Composition", ID.Composition);
	/** CompoundExpression(expr1, expr2, ...) - evaluates its arguments in turn, returning the last result. */
	public final static IBuiltInSymbol CompoundExpression = initFinalSymbol("CompoundExpression",
			ID.CompoundExpression);
	/**
	 * Condition(pattern, expr) - places an additional constraint on `pattern` that only allows it to match if `expr`
	 * evaluates to `True`.
	 */
	public final static IBuiltInSymbol Condition = initFinalSymbol("Condition", ID.Condition);
	/**
	 * ConditionalExpression(expr, condition) - if `condition` evaluates to `True` return `expr`, if `condition`
	 * evaluates to `False` return `Undefined`. Otherwise return the `ConditionalExpression` unevaluated.
	 */
	public final static IBuiltInSymbol ConditionalExpression = initFinalSymbol("ConditionalExpression",
			ID.ConditionalExpression);
	/** Conjugate(z) - returns the complex conjugate of the complex number `z`. */
	public final static IBuiltInSymbol Conjugate = initFinalSymbol("Conjugate", ID.Conjugate);
	/** ConjugateTranspose(matrix) - get the transposed `matrix` with conjugated matrix elements. */
	public final static IBuiltInSymbol ConjugateTranspose = initFinalSymbol("ConjugateTranspose",
			ID.ConjugateTranspose);

	/***/
	public final static IBuiltInSymbol ConnectedGraphQ = initFinalSymbol("ConnectedGraphQ", ID.ConnectedGraphQ);

	/** Constant - is an attribute that indicates that a symbol is a constant. */
	public final static IBuiltInSymbol Constant = initFinalSymbol("Constant", ID.Constant);
	/** ConstantArray(expr, n) - returns a list of `n` copies of `expr`. */
	public final static IBuiltInSymbol ConstantArray = initFinalSymbol("ConstantArray", ID.ConstantArray);
	/***/
	public final static IBuiltInSymbol ContainsAll = initFinalSymbol("ContainsAll", ID.ContainsAll);

	/***/
	public final static IBuiltInSymbol ContainsAny = initFinalSymbol("ContainsAny", ID.ContainsAny);
	/***/
	public final static IBuiltInSymbol ContainsExactly = initFinalSymbol("ContainsExactly", ID.ContainsExactly);

	/***/
	public final static IBuiltInSymbol ContainsNone = initFinalSymbol("ContainsNone", ID.ContainsNone);

	/** ContainsOnly(list1, list2) - yields True if `list1` contains only elements that appear in `list2`. */
	public final static IBuiltInSymbol ContainsOnly = initFinalSymbol("ContainsOnly", ID.ContainsOnly);
	/** Context(symbol) - return the context of the given symbol. */
	public final static IBuiltInSymbol Context = initFinalSymbol("Context", ID.Context);
	/** Continue() - continues with the next iteration in a `For`, `While`, or `Do` loop. */
	public final static IBuiltInSymbol Continue = initFinalSymbol("Continue", ID.Continue);
	/** ContinuedFraction(number) - get the continued fraction representation of `number`. */
	public final static IBuiltInSymbol ContinuedFraction = initFinalSymbol("ContinuedFraction", ID.ContinuedFraction);

	/***/
	public final static IBuiltInSymbol ContourPlot = initFinalSymbol("ContourPlot", ID.ContourPlot);
	/**
	 * Convergents({n1, n2, ...}) - return the list of convergents which represents the continued fraction list `{n1,
	 * n2, ...}`.
	 */
	public final static IBuiltInSymbol Convergents = initFinalSymbol("Convergents", ID.Convergents);
	/***/
	public final static IBuiltInSymbol ConvexHullMesh = initFinalSymbol("ConvexHullMesh", ID.ConvexHullMesh);
	/** CoprimeQ(x, y) - tests whether `x` and `y` are coprime by computing their greatest common divisor. */
	public final static IBuiltInSymbol CoprimeQ = initFinalSymbol("CoprimeQ", ID.CoprimeQ);
	/** Correlation(a, b) - computes Pearson's correlation of two equal-sized vectors `a` and `b`. */
	public final static IBuiltInSymbol Correlation = initFinalSymbol("Correlation", ID.Correlation);
	/**
	 * Cos(expr) - returns the cosine of `expr` (measured in radians). `Cos(expr)` will evaluate automatically in the
	 * case `expr` is a multiple of `Pi, Pi/2, Pi/3, Pi/4` and `Pi/6`.
	 */
	public final static IBuiltInSymbol Cos = initFinalSymbol("Cos", ID.Cos);
	/***/
	public final static IBuiltInSymbol CosIntegral = initFinalSymbol("CosIntegral", ID.CosIntegral);
	/** Cosh(z) - returns the hyperbolic cosine of `z`. */
	public final static IBuiltInSymbol Cosh = initFinalSymbol("Cosh", ID.Cosh);
	/***/
	public final static IBuiltInSymbol CoshIntegral = initFinalSymbol("CoshIntegral", ID.CoshIntegral);
	/** CosineDistance(u, v) - returns the cosine distance between `u` and `v`. */
	public final static IBuiltInSymbol CosineDistance = initFinalSymbol("CosineDistance", ID.CosineDistance);
	/** Cot(expr) - the cotangent function. */
	public final static IBuiltInSymbol Cot = initFinalSymbol("Cot", ID.Cot);
	/** Coth(z) - returns the hyperbolic cotangent of `z`. */
	public final static IBuiltInSymbol Coth = initFinalSymbol("Coth", ID.Coth);
	/** Count(list, pattern) - returns the number of times `pattern` appears in `list`. */
	public final static IBuiltInSymbol Count = initFinalSymbol("Count", ID.Count);
	/***/
	public final static IBuiltInSymbol CountDistinct = initFinalSymbol("CountDistinct", ID.CountDistinct);

	/**
	 * Counts({elem1, elem2, elem3, ...}) - count the number of each distinct element in the list `{elem1, elem2, elem3,
	 * ...}` and return the result as an association `<|elem1->counter1, ...|>`.
	 */
	public final static IBuiltInSymbol Counts = initFinalSymbol("Counts", ID.Counts);
	/** Covariance(a, b) - computes the covariance between the equal-sized vectors `a` and `b`. */
	public final static IBuiltInSymbol Covariance = initFinalSymbol("Covariance", ID.Covariance);
	/***/
	public final static IBuiltInSymbol CreateDirectory = initFinalSymbol("CreateDirectory", ID.CreateDirectory);
	/** Cross(a, b) - computes the vector cross product of `a` and `b`. */
	public final static IBuiltInSymbol Cross = initFinalSymbol("Cross", ID.Cross);
	/** Csc(z) - returns the cosecant of `z`. */
	public final static IBuiltInSymbol Csc = initFinalSymbol("Csc", ID.Csc);
	/** Csch(z) - returns the hyperbolic cosecant of `z`. */
	public final static IBuiltInSymbol Csch = initFinalSymbol("Csch", ID.Csch);
	/** CubeRoot(n) - finds the real-valued cube root of the given `n`. */
	public final static IBuiltInSymbol CubeRoot = initFinalSymbol("CubeRoot", ID.CubeRoot);
	/** Curl({f1, f2}, {x1, x2}) - gives the curl. */
	public final static IBuiltInSymbol Curl = initFinalSymbol("Curl", ID.Curl);

	/***/
	public final static IBuiltInSymbol Cyan = initFinalSymbol("Cyan", ID.Cyan);

	/** Cyclotomic(n, x) - returns the Cyclotomic polynomial `C_n(x)`. */
	public final static IBuiltInSymbol Cyclotomic = initFinalSymbol("Cyclotomic", ID.Cyclotomic);
	/** D(f, x) - gives the partial derivative of `f` with respect to `x`. */
	public final static IBuiltInSymbol D = initFinalSymbol("D", ID.D);
	/**
	 * DSolve(equation, f(var), var) - attempts to solve a linear differential `equation` for the function `f(var)` and
	 * variable `var`.
	 */
	public final static IBuiltInSymbol DSolve = initFinalSymbol("DSolve", ID.DSolve);
	/***/
	public final static IBuiltInSymbol Dataset = initFinalSymbol("Dataset", ID.Dataset);
	/***/
	public final static IBuiltInSymbol DateObject = initFinalSymbol("DateObject", ID.DateObject);

	/***/
	public final static IBuiltInSymbol DateValue = initFinalSymbol("DateValue", ID.DateValue);
	/** Decrement(x) - decrements `x` by `1`, returning the original value of `x`. */
	public final static IBuiltInSymbol Decrement = initFinalSymbol("Decrement", ID.Decrement);
	/**
	 * Default(symbol) - `Default` returns the default value associated with the `symbol` for a pattern default `_.`
	 * expression.
	 */
	public final static IBuiltInSymbol Default = initFinalSymbol("Default", ID.Default);
	/***/
	public final static IBuiltInSymbol DefaultButton = initFinalSymbol("DefaultButton", ID.DefaultButton);
	/** Defer(expr) - `Defer` doesn't evaluate `expr` and didn't appear in the output */
	public final static IBuiltInSymbol Defer = initFinalSymbol("Defer", ID.Defer);
	/** Definition(symbol) - prints user-defined values and rules associated with `symbol`. */
	public final static IBuiltInSymbol Definition = initFinalSymbol("Definition", ID.Definition);
	/** Degree - the constant `Degree` converts angles from degree to `Pi/180` radians. */
	public final static IBuiltInSymbol Degree = initFinalSymbol("Degree", ID.Degree);
	/***/
	public final static IBuiltInSymbol DegreeLexicographic = initFinalSymbol("DegreeLexicographic", ID.DegreeLexicographic);

	/***/
	public final static IBuiltInSymbol DegreeReverseLexicographic = initFinalSymbol("DegreeReverseLexicographic", ID.DegreeReverseLexicographic);
	/** Delete(expr, n) - returns `expr` with part `n` removed. */
	public final static IBuiltInSymbol Delete = initFinalSymbol("Delete", ID.Delete);
	/** DeleteCases(list, pattern) - returns the elements of `list` that do not match `pattern`. */
	public final static IBuiltInSymbol DeleteCases = initFinalSymbol("DeleteCases", ID.DeleteCases);
	/** DeleteDuplicates(list) - deletes duplicates from `list`. */
	public final static IBuiltInSymbol DeleteDuplicates = initFinalSymbol("DeleteDuplicates", ID.DeleteDuplicates);
	/**
	 * DeleteDuplicatesBy(list, predicate) - deletes duplicates from `list`, for which the `predicate` returns `True`.
	 */
	public final static IBuiltInSymbol DeleteDuplicatesBy = initFinalSymbol("DeleteDuplicatesBy",
			ID.DeleteDuplicatesBy);
	/**
	 * Denominator(expr) - gives the denominator in `expr`. Denominator collects expressions with negative exponents.
	 */
	public final static IBuiltInSymbol Denominator = initFinalSymbol("Denominator", ID.Denominator);
	/** DensityHistogram( list-of-pair-values ) - plot a density histogram for a `list-of-pair-values` */
	public final static IBuiltInSymbol DensityHistogram = initFinalSymbol("DensityHistogram", ID.DensityHistogram);

	/***/
	public final static IBuiltInSymbol DensityPlot = initFinalSymbol("DensityPlot", ID.DensityPlot);
	/** Depth(expr) - gives the depth of `expr`. */
	public final static IBuiltInSymbol Depth = initFinalSymbol("Depth", ID.Depth);
	/** Derivative(n)[f] - represents the `n`-th derivative of the function `f`. */
	public final static IBuiltInSymbol Derivative = initFinalSymbol("Derivative", ID.Derivative);
	/** DesignMatrix(m, f, x) - returns the design matrix. */
	public final static IBuiltInSymbol DesignMatrix = initFinalSymbol("DesignMatrix", ID.DesignMatrix);
	/** Det(matrix) - computes the determinant of the `matrix`. */
	public final static IBuiltInSymbol Det = initFinalSymbol("Det", ID.Det);
	/** Diagonal(matrix) - computes the diagonal vector of the `matrix`. */
	public final static IBuiltInSymbol Diagonal = initFinalSymbol("Diagonal", ID.Diagonal);
	/** DiagonalMatrix(list) - gives a matrix with the values in `list` on its diagonal and zeroes elsewhere. */
	public final static IBuiltInSymbol DiagonalMatrix = initFinalSymbol("DiagonalMatrix", ID.DiagonalMatrix);
	/** DialogInput() - if the file system is enabled, the user can input a string in a dialog box. */
	public final static IBuiltInSymbol DialogInput = initFinalSymbol("DialogInput", ID.DialogInput);

	/***/
	public final static IBuiltInSymbol DialogNotebook = initFinalSymbol("DialogNotebook", ID.DialogNotebook);

	/***/
	public final static IBuiltInSymbol DialogReturn = initFinalSymbol("DialogReturn", ID.DialogReturn);
	/**
	 * DiceDissimilarity(u, v) - returns the Dice dissimilarity between the two boolean 1-D lists `u` and `v`, which is
	 * defined as `(c_tf + c_ft) / (2 * c_tt + c_ft + c_tf)`, where n is `len(u)` and `c_ij` is the number of
	 * occurrences of `u(k)=i` and `v(k)=j` for `k<n`.
	 */
	public final static IBuiltInSymbol DiceDissimilarity = initFinalSymbol("DiceDissimilarity", ID.DiceDissimilarity);
	/***/
	public final static IBuiltInSymbol Differences = initFinalSymbol("Differences", ID.Differences);
	/***/
	public final static IBuiltInSymbol DigitCharacter = F.initFinalSymbol("DigitCharacter", ID.DigitCharacter);
	/** DigitCount(n) - returns a list of the number of integer digits for `n` for `radix` 10. */
	public final static IBuiltInSymbol DigitCount = initFinalSymbol("DigitCount", ID.DigitCount);
	/** DigitQ(str) - returns `True` if `str` is a string which contains only digits. */
	public final static IBuiltInSymbol DigitQ = initFinalSymbol("DigitQ", ID.DigitQ);
	/** Dimensions(expr) - returns a list of the dimensions of the expression `expr`. */
	public final static IBuiltInSymbol Dimensions = initFinalSymbol("Dimensions", ID.Dimensions);
	/** DiracDelta(x) - `DiracDelta` function returns `0` for all real numbers `x` where `x != 0`. */
	public final static IBuiltInSymbol DiracDelta = initFinalSymbol("DiracDelta", ID.DiracDelta);
	/***/
	public final static IBuiltInSymbol DirectedEdge = initFinalSymbol("DirectedEdge", ID.DirectedEdge);

	/** DirectedInfinity(z) - represents an infinite multiple of the complex number `z`. */
	public final static IBuiltInSymbol DirectedInfinity = initFinalSymbol("DirectedInfinity", ID.DirectedInfinity);
	/***/
	public final static IBuiltInSymbol Direction = initFinalSymbol("Direction", ID.Direction);
	/***/
	public final static IBuiltInSymbol Directive = initFinalSymbol("Directive", ID.Directive);
	/***/
	public final static IBuiltInSymbol DirichletEta = initFinalSymbol("DirichletEta", ID.DirichletEta);
	/***/
	public final static IBuiltInSymbol DirichletWindow = initFinalSymbol("DirichletWindow", ID.DirichletWindow);
	/**
	 * DiscreteDelta(n1, n2, n3, ...) - `DiscreteDelta` function returns `1` if all the `ni` are `0`. Returns `0`
	 * otherwise.
	 */
	public final static IBuiltInSymbol DiscreteDelta = initFinalSymbol("DiscreteDelta", ID.DiscreteDelta);
	/** DiscreteUniformDistribution({min, max}) - returns a discrete uniform distribution. */
	public final static IBuiltInSymbol DiscreteUniformDistribution = initFinalSymbol("DiscreteUniformDistribution",
			ID.DiscreteUniformDistribution);

	/**
	 * Discriminant(poly, var) - computes the discriminant of the polynomial `poly` with respect to the variable `var`.
	 */
	public final static IBuiltInSymbol Discriminant = initFinalSymbol("Discriminant", ID.Discriminant);
	/***/
	public final static IBuiltInSymbol DisjointQ = initFinalSymbol("DisjointQ", ID.DisjointQ);
	/***/
	public final static IBuiltInSymbol Dispatch = initFinalSymbol("Dispatch", ID.Dispatch);
	/***/
	public final static IBuiltInSymbol Disputed = initFinalSymbol("Disputed", ID.Disputed);
	/***/
	public final static IBuiltInSymbol DistanceFunction = initFinalSymbol("DistanceFunction", ID.DistanceFunction);
	/** Distribute(f(x1, x2, x3,...)) - distributes `f` over `Plus` appearing in any of the `xi`. */
	public final static IBuiltInSymbol Distribute = initFinalSymbol("Distribute", ID.Distribute);
	/***/
	public final static IBuiltInSymbol Distributed = initFinalSymbol("Distributed", ID.Distributed);
	/** Div({f1, f2, f3,...},{x1, x2, x3,...}) - compute the divergence. */
	public final static IBuiltInSymbol Div = initFinalSymbol("Div", ID.Div);
	/** Divide(a, b) - represents the division of `a` by `b`. */
	public final static IBuiltInSymbol Divide = initFinalSymbol("Divide", ID.Divide);
	/** DivideBy(x, dx) - is equivalent to `x = x / dx`. */
	public final static IBuiltInSymbol DivideBy = initFinalSymbol("DivideBy", ID.DivideBy);
	/** Divisible(n, m) - returns `True` if `n` could be divide by `m`. */
	public final static IBuiltInSymbol Divisible = initFinalSymbol("Divisible", ID.Divisible);
	/** DivisorSigma(k, n) - returns the sum of the `k`-th powers of the divisors of `n`. */
	public final static IBuiltInSymbol DivisorSigma = initFinalSymbol("DivisorSigma", ID.DivisorSigma);
	/** DivisorSum(n, head) - returns the sum of the divisors of `n`. The `head` is applied to each divisor. */
	public final static IBuiltInSymbol DivisorSum = initFinalSymbol("DivisorSum", ID.DivisorSum);
	/** Divisors(n) - returns all integers that divide the integer `n`. */
	public final static IBuiltInSymbol Divisors = initFinalSymbol("Divisors", ID.Divisors);
	/** Do(expr, {max}) - evaluates `expr` `max` times. */
	public final static IBuiltInSymbol Do = initFinalSymbol("Do", ID.Do);
	/** Dot(x, y) or x . y - `x . y` computes the vector dot product or matrix product `x . y`. */
	public final static IBuiltInSymbol Dot = initFinalSymbol("Dot", ID.Dot);
	/***/
	public final static IBuiltInSymbol DownValues = initFinalSymbol("DownValues", ID.DownValues);
	/** Drop(expr, n) - returns `expr` with the first `n` leaves removed. */
	public final static IBuiltInSymbol Drop = initFinalSymbol("Drop", ID.Drop);
	/***/
	public final static IBuiltInSymbol DuplicateFreeQ = initFinalSymbol("DuplicateFreeQ", ID.DuplicateFreeQ);
	/***/
	public final static IBuiltInSymbol Dynamic = initFinalSymbol("Dynamic", ID.Dynamic);
	/** E - Euler's constant E */
	public final static IBuiltInSymbol E = initFinalSymbol("E", ID.E);
	/***/
	public final static IBuiltInSymbol EasterSunday = initFinalSymbol("EasterSunday", ID.EasterSunday);
	/** Echo(expr) - prints the `expr` to the default output stream and returns `expr`. */
	public final static IBuiltInSymbol Echo = initFinalSymbol("Echo", ID.Echo);

	/**
	 * EchoFunction()[expr] - operator form of the `Echo`function. Print the `expr` to the default output stream and
	 * return `expr`.
	 */
	public final static IBuiltInSymbol EchoFunction = initFinalSymbol("EchoFunction", ID.EchoFunction);
	/***/
	public final static IBuiltInSymbol EdgeCount = initFinalSymbol("EdgeCount", ID.EdgeCount);

	/** EdgeList(graph) - convert the `graph` into a list of edges. */
	public final static IBuiltInSymbol EdgeList = initFinalSymbol("EdgeList", ID.EdgeList);
	/** EdgeQ(graph, edge) - test if `edge` is an edge in the `graph` object. */
	public final static IBuiltInSymbol EdgeQ = initFinalSymbol("EdgeQ", ID.EdgeQ);

	/***/
	public final static IBuiltInSymbol EdgeWeight = initFinalSymbol("EdgeWeight", ID.EdgeWeight);
	/** EffectiveInterest(i, n) - returns an effective interest rate object. */
	public final static IBuiltInSymbol EffectiveInterest = initFinalSymbol("EffectiveInterest", ID.EffectiveInterest);
	/** Eigenvalues(matrix) - get the numerical eigenvalues of the `matrix`. */
	public final static IBuiltInSymbol Eigenvalues = initFinalSymbol("Eigenvalues", ID.Eigenvalues);
	/** Eigenvectors(matrix) - get the numerical eigenvectors of the `matrix`. */
	public final static IBuiltInSymbol Eigenvectors = initFinalSymbol("Eigenvectors", ID.Eigenvectors);
	/** Element(symbol, dom) - assume (or test) that the `symbol` is in the domain `dom`. */
	public final static IBuiltInSymbol Element = initFinalSymbol("Element", ID.Element);
	/** ElementData("name", "property") - gives the value of the property for the chemical specified by name. */
	public final static IBuiltInSymbol ElementData = initFinalSymbol("ElementData", ID.ElementData);
	/**
	 * Eliminate(list-of-equations, list-of-variables) - attempts to eliminate the variables from the
	 * `list-of-variables` in the `list-of-equations`.
	 */
	public final static IBuiltInSymbol Eliminate = initFinalSymbol("Eliminate", ID.Eliminate);
	/***/
	public final static IBuiltInSymbol EliminationOrder = initFinalSymbol("EliminationOrder", ID.EliminationOrder);
	/** EllipticE(z) - returns the complete elliptic integral of the second kind. */
	public final static IBuiltInSymbol EllipticE = initFinalSymbol("EllipticE", ID.EllipticE);
	/** EllipticF(z) - returns the incomplete elliptic integral of the first kind. */
	public final static IBuiltInSymbol EllipticF = initFinalSymbol("EllipticF", ID.EllipticF);
	/** EllipticK(z) - returns the complete elliptic integral of the first kind. */
	public final static IBuiltInSymbol EllipticK = initFinalSymbol("EllipticK", ID.EllipticK);
	/** EllipticPi(n,m) - returns the complete elliptic integral of the third kind. */
	public final static IBuiltInSymbol EllipticPi = initFinalSymbol("EllipticPi", ID.EllipticPi);
	/***/
	public final static IBuiltInSymbol EllipticTheta = initFinalSymbol("EllipticTheta", ID.EllipticTheta);
	/** End( ) - end a context definition started with `Begin` */
	public final static IBuiltInSymbol End = initFinalSymbol("End", ID.End);
	/***/
	public final static IBuiltInSymbol EndOfLine = initFinalSymbol("EndOfLine", ID.EndOfLine);

	/***/
	public final static IBuiltInSymbol EndOfString = initFinalSymbol("EndOfString", ID.EndOfString);
	/** EndPackage( ) - end a package definition */
	public final static IBuiltInSymbol EndPackage = initFinalSymbol("EndPackage", ID.EndPackage);

	/***/
	public final static IBuiltInSymbol EndTestSection = initFinalSymbol("EndTestSection", ID.EndTestSection);
	/***/
	public final static IBuiltInSymbol Entity = initFinalSymbol("Entity", ID.Entity);


	/**
	 * Equal(x, y) - yields `True` if `x` and `y` are known to be equal, or `False` if `x` and `y` are known to be
	 * unequal.
	 */
	public final static IBuiltInSymbol Equal = initFinalSymbol("Equal", ID.Equal);
	/**
	 * Equivalent(arg1, arg2, ...) - Equivalence relation. `Equivalent(A, B)` is `True` iff `A` and `B` are both `True`
	 * or both `False`. Returns `True` if all of the arguments are logically equivalent. Returns `False` otherwise.
	 * `Equivalent(arg1, arg2, ...)` is equivalent to `(arg1 && arg2 && ...) || (!arg1 && !arg2 && ...)`.
	 */
	public final static IBuiltInSymbol Equivalent = initFinalSymbol("Equivalent", ID.Equivalent);
	/** Erf(z) - returns the error function of `z`. */
	public final static IBuiltInSymbol Erf = initFinalSymbol("Erf", ID.Erf);
	/** Erfc(z) - returns the complementary error function of `z`. */
	public final static IBuiltInSymbol Erfc = initFinalSymbol("Erfc", ID.Erfc);
	/** Erfi(z) - returns the imaginary error function of `z`. */
	public final static IBuiltInSymbol Erfi = initFinalSymbol("Erfi", ID.Erfi);
	/** ErlangDistribution({k, lambda}) - returns a Erlang distribution. */
	public final static IBuiltInSymbol ErlangDistribution = initFinalSymbol("ErlangDistribution",
			ID.ErlangDistribution);

	/** EuclideanDistance(u, v) - returns the euclidean distance between `u` and `v`. */
	public final static IBuiltInSymbol EuclideanDistance = initFinalSymbol("EuclideanDistance", ID.EuclideanDistance);
	/** EulerE(n) - gives the euler number `En`. */
	public final static IBuiltInSymbol EulerE = initFinalSymbol("EulerE", ID.EulerE);
	/** EulerGamma - Euler-Mascheroni constant */
	public final static IBuiltInSymbol EulerGamma = initFinalSymbol("EulerGamma", ID.EulerGamma);
	/** EulerPhi(n) - compute Euler's totient function. */
	public final static IBuiltInSymbol EulerPhi = initFinalSymbol("EulerPhi", ID.EulerPhi);
	/** EulerianGraphQ(graph) - returns `True` if `graph` is an eulerian graph, and `False` otherwise. */
	public final static IBuiltInSymbol EulerianGraphQ = initFinalSymbol("EulerianGraphQ", ID.EulerianGraphQ);
	/**
	 * Evaluate(expr) - the `Evaluate` function will be executed even if the function attributes `HoldFirst, HoldRest,
	 * HoldAll` are set for the function head.
	 */
	public final static IBuiltInSymbol Evaluate = initFinalSymbol("Evaluate", ID.Evaluate);
	/** EvenQ(x) - returns `True` if `x` is even, and `False` otherwise. */
	public final static IBuiltInSymbol EvenQ = initFinalSymbol("EvenQ", ID.EvenQ);
	/** ExactNumberQ(expr) - returns `True` if `expr` is an exact number, and `False` otherwise. */
	public final static IBuiltInSymbol ExactNumberQ = initFinalSymbol("ExactNumberQ", ID.ExactNumberQ);
	/** Except(c) - represents a pattern object that matches any expression except those matching `c`. */
	public final static IBuiltInSymbol Except = initFinalSymbol("Except", ID.Except);
	/***/
	public final static IBuiltInSymbol Exists = initFinalSymbol("Exists", ID.Exists);
	/***/
	public final static IBuiltInSymbol Exit = initFinalSymbol("Exit", ID.Exit);
	/** Exp(z) - the exponential function `E^z`. */
	public final static IBuiltInSymbol Exp = initFinalSymbol("Exp", ID.Exp);
	/** ExpIntegralE(n, expr) - returns the exponential integral `E_n(expr)` of `expr`. */
	public final static IBuiltInSymbol ExpIntegralE = initFinalSymbol("ExpIntegralE", ID.ExpIntegralE);
	/** ExpIntegralEi(expr) - returns the exponential integral `Ei(expr)` of `expr`. */
	public final static IBuiltInSymbol ExpIntegralEi = initFinalSymbol("ExpIntegralEi", ID.ExpIntegralEi);
	/***/
	public final static IBuiltInSymbol ExpToTrig = initFinalSymbol("ExpToTrig", ID.ExpToTrig);
	/** Expand(expr) - expands out positive rational powers and products of sums in `expr`. */
	public final static IBuiltInSymbol Expand = initFinalSymbol("Expand", ID.Expand);
	/** ExpandAll(expr) - expands out all positive integer powers and products of sums in `expr`. */
	public final static IBuiltInSymbol ExpandAll = initFinalSymbol("ExpandAll", ID.ExpandAll);
	/**
	 * Expectation(pure-function, data-set) - returns the expected value of the `pure-function` for the given
	 * `data-set`.
	 */
	public final static IBuiltInSymbol Expectation = initFinalSymbol("Expectation", ID.Expectation);
	/**
	 * Exponent(polynomial, x) - gives the maximum power with which `x` appears in the expanded form of `polynomial`.
	 */
	public final static IBuiltInSymbol Exponent = initFinalSymbol("Exponent", ID.Exponent);
	/** ExponentialDistribution(lambda) - returns an exponential distribution. */
	public final static IBuiltInSymbol ExponentialDistribution = initFinalSymbol("ExponentialDistribution",
			ID.ExponentialDistribution);
	/**
	 * Export("path-to-filename", expression, "WXF") - if the file system is enabled, export the `expression` in WXF
	 * format to the "path-to-filename" file.
	 */
	public final static IBuiltInSymbol Export = initFinalSymbol("Export", ID.Export);
	/***/
	public final static IBuiltInSymbol ExportString = initFinalSymbol("ExportString", ID.ExportString);
	/***/
	public final static IBuiltInSymbol Expression = initFinalSymbol("Expression", ID.Expression);
	/** ExtendedGCD(n1, n2, ...) - computes the extended greatest common divisor of the given integers. */
	public final static IBuiltInSymbol ExtendedGCD = initFinalSymbol("ExtendedGCD", ID.ExtendedGCD);
	/***/
	public final static IBuiltInSymbol Extension = initFinalSymbol("Extension", ID.Extension);
	/** Extract(expr, list) - extracts parts of `expr` specified by `list`. */
	public final static IBuiltInSymbol Extract = initFinalSymbol("Extract", ID.Extract);
	/***/
	public final static IBuiltInSymbol FRatioDistribution = initFinalSymbol("FRatioDistribution",
			ID.FRatioDistribution);
	/** Factor(expr) - factors the polynomial expression `expr` */
	public final static IBuiltInSymbol Factor = initFinalSymbol("Factor", ID.Factor);
	/** FactorInteger(n) - returns the factorization of `n` as a list of factors and exponents. */
	public final static IBuiltInSymbol FactorInteger = initFinalSymbol("FactorInteger", ID.FactorInteger);
	/** FactorSquareFree(polynomial) - factor the polynomial expression `polynomial` square free. */
	public final static IBuiltInSymbol FactorSquareFree = initFinalSymbol("FactorSquareFree", ID.FactorSquareFree);
	/** FactorSquareFreeList(polynomial) - get the square free factors of the polynomial expression `polynomial`. */
	public final static IBuiltInSymbol FactorSquareFreeList = initFinalSymbol("FactorSquareFreeList",
			ID.FactorSquareFreeList);
	/** FactorTerms(poly) - pulls out any overall numerical factor in `poly`. */
	public final static IBuiltInSymbol FactorTerms = initFinalSymbol("FactorTerms", ID.FactorTerms);
	/** Factorial(n) - returns the factorial number of the integer `n` */
	public final static IBuiltInSymbol Factorial = initFinalSymbol("Factorial", ID.Factorial);


	/** Factorial2(n) - returns the double factorial number of the integer `n`. */
	public final static IBuiltInSymbol Factorial2 = initFinalSymbol("Factorial2", ID.Factorial2);
	/***/
	public final static IBuiltInSymbol FactorialPower = initFinalSymbol("FactorialPower", ID.FactorialPower);
	/** False - the constant `False` represents the boolean value **false ***/
	public final static IBuiltInSymbol False = initFinalSymbol("False", ID.False);
	/** Fibonacci(n) - returns the Fibonacci number of the integer `n` */
	public final static IBuiltInSymbol Fibonacci = initFinalSymbol("Fibonacci", ID.Fibonacci);
	/***/
	public final static IBuiltInSymbol FilterRules = initFinalSymbol("FilterRules", ID.FilterRules);

	/**
	 * FindClusters(list-of-data-points, k) - Clustering algorithm based on David Arthur and Sergei Vassilvitski
	 * k-means++ algorithm. Create `k` number of clusters to split the `list-of-data-points` into.
	 */
	public final static IBuiltInSymbol FindClusters = initFinalSymbol("FindClusters", ID.FindClusters);
	/***/
	public final static IBuiltInSymbol FindEdgeCover = initFinalSymbol("FindEdgeCover", ID.FindEdgeCover);

	/** FindEulerianCycle(graph) - find an eulerian cycle in the `graph`. */
	public final static IBuiltInSymbol FindEulerianCycle = initFinalSymbol("FindEulerianCycle", ID.FindEulerianCycle);

	/**
	 * FindFit(list-of-data-points, function, parameters, variable) - solve a least squares problem using the
	 * Levenberg-Marquardt algorithm.
	 */
	public final static IBuiltInSymbol FindFit = initFinalSymbol("FindFit", ID.FindFit);
	/***/
	public final static IBuiltInSymbol FindGraphCommunities = initFinalSymbol("FindGraphCommunities",
			ID.FindGraphCommunities);
	/** FindHamiltonianCycle(graph) - find an hamiltonian cycle in the `graph`. */
	public final static IBuiltInSymbol FindHamiltonianCycle = initFinalSymbol("FindHamiltonianCycle",
			ID.FindHamiltonianCycle);

	/***/
	public final static IBuiltInSymbol FindIndependentEdgeSet = initFinalSymbol("FindIndependentEdgeSet",
			ID.FindIndependentEdgeSet);

	/***/
	public final static IBuiltInSymbol FindIndependentVertexSet = initFinalSymbol("FindIndependentVertexSet",
			ID.FindIndependentVertexSet);

	/**
	 * FindInstance(equations, vars) - attempts to find one solution which solves the `equations` for the variables
	 * `vars`.
	 */
	public final static IBuiltInSymbol FindInstance = initFinalSymbol("FindInstance", ID.FindInstance);
	/**
	 * FindRoot(f, {x, xmin, xmax}) - searches for a numerical root of `f` for the variable `x`, in the range `xmin` to
	 * `xmax`.
	 */
	public final static IBuiltInSymbol FindRoot = initFinalSymbol("FindRoot", ID.FindRoot);
	/**
	 * FindShortestPath(graph, source, destination) - find a shortest path in the `graph` from `source` to
	 * `destination`.
	 */
	public final static IBuiltInSymbol FindShortestPath = initFinalSymbol("FindShortestPath", ID.FindShortestPath);

	/**
	 * FindShortestTour({{p11, p12}, {p21, p22}, {p31, p32}, ...}) - find a shortest tour in the `graph` with minimum
	 * `EuclideanDistance`.
	 */
	public final static IBuiltInSymbol FindShortestTour = initFinalSymbol("FindShortestTour", ID.FindShortestTour);

	/** FindSpanningTree(graph) - find the minimum spanning tree in the `graph`. */
	public final static IBuiltInSymbol FindSpanningTree = initFinalSymbol("FindSpanningTree", ID.FindSpanningTree);
	/**
	 * FindVertexCover(graph) - algorithm to find a vertex cover for a `graph`. A vertex cover is a set of vertices that
	 * touches all the edges in the graph.
	 */
	public final static IBuiltInSymbol FindVertexCover = initFinalSymbol("FindVertexCover", ID.FindVertexCover);
	/** First(expr) - returns the first element in `expr`. */
	public final static IBuiltInSymbol First = initFinalSymbol("First", ID.First);
	/**
	 * Fit(list-of-data-points, degree, variable) - solve a least squares problem using the Levenberg-Marquardt
	 * algorithm.
	 */
	public final static IBuiltInSymbol Fit = initFinalSymbol("Fit", ID.Fit);
	/** FittedModel( ) - `FittedModel`holds the model generated with `LinearModelFit` */
	public final static IBuiltInSymbol FittedModel = initFinalSymbol("FittedModel", ID.FittedModel);
	/**
	 * FiveNum({dataset}) - the Tuckey five-number summary is a set of descriptive statistics that provide information
	 * about a `dataset`. It consists of the five most important sample percentiles:
	 */
	public final static IBuiltInSymbol FiveNum = initFinalSymbol("FiveNum", ID.FiveNum);
	/** FixedPoint(f, expr) - starting with `expr`, iteratively applies `f` until the result no longer changes. */
	public final static IBuiltInSymbol FixedPoint = initFinalSymbol("FixedPoint", ID.FixedPoint);
	/**
	 * FixedPointList(f, expr) - starting with `expr`, iteratively applies `f` until the result no longer changes, and
	 * returns a list of all intermediate results.
	 */
	public final static IBuiltInSymbol FixedPointList = initFinalSymbol("FixedPointList", ID.FixedPointList);
	/**
	 * Flat - is an attribute that specifies that nested occurrences of a function should be automatically flattened.
	 */
	public final static IBuiltInSymbol Flat = initFinalSymbol("Flat", ID.Flat);
	/***/
	public final static IBuiltInSymbol FlatTopWindow = initFinalSymbol("FlatTopWindow", ID.FlatTopWindow);
	/** Flatten(expr) - flattens out nested lists in `expr`. */
	public final static IBuiltInSymbol Flatten = initFinalSymbol("Flatten", ID.Flatten);
	/** FlattenAt(expr, position) - flattens out nested lists at the given `position` in `expr`. */
	public final static IBuiltInSymbol FlattenAt = initFinalSymbol("FlattenAt", ID.FlattenAt);
	/***/
	public final static IBuiltInSymbol Float = initFinalSymbol("Float", ID.Float);
	/** Floor(expr) - gives the smallest integer less than or equal `expr`. */
	public final static IBuiltInSymbol Floor = initFinalSymbol("Floor", ID.Floor);
	/** Fold[f, x, {a, b}] - returns `f[f[x, a], b]`, and this nesting continues for lists of arbitrary length. */
	public final static IBuiltInSymbol Fold = initFinalSymbol("Fold", ID.Fold);
	/** FoldList[f, x, {a, b}] - returns `{x, f[x, a], f[f[x, a], b]}` */
	public final static IBuiltInSymbol FoldList = initFinalSymbol("FoldList", ID.FoldList);
	/**
	 * For(start, test, incr, body) - evaluates `start`, and then iteratively `body` and `incr` as long as test
	 * evaluates to `True`.
	 */
	public final static IBuiltInSymbol For = initFinalSymbol("For", ID.For);
	/***/
	public final static IBuiltInSymbol ForAll = initFinalSymbol("ForAll", ID.ForAll);
	/**
	 * Fourier(vector-of-complex-numbers) - Discrete Fourier transform of a `vector-of-complex-numbers`. Fourier
	 * transform is restricted to vectors with length of power of 2.
	 */
	public final static IBuiltInSymbol Fourier = initFinalSymbol("Fourier", ID.Fourier);

	/** FourierMatrix(n) - gives a fourier matrix with the dimension `n`. */
	public final static IBuiltInSymbol FourierMatrix = initFinalSymbol("FourierMatrix", ID.FourierMatrix);
	/** FractionalPart(number) - get the fractional part of a `number`. */
	public final static IBuiltInSymbol FractionalPart = initFinalSymbol("FractionalPart", ID.FractionalPart);
	/** FrechetDistribution(a,b) - returns a Frechet distribution. */
	public final static IBuiltInSymbol FrechetDistribution = initFinalSymbol("FrechetDistribution",
			ID.FrechetDistribution);
	/** FreeQ(`expr`, `x`) - returns 'True' if `expr` does not contain the expression `x`. */
	public final static IBuiltInSymbol FreeQ = initFinalSymbol("FreeQ", ID.FreeQ);
	/***/
	public final static IBuiltInSymbol FresnelC = initFinalSymbol("FresnelC", ID.FresnelC);
	/***/
	public final static IBuiltInSymbol FresnelS = initFinalSymbol("FresnelS", ID.FresnelS);
	/** FrobeniusNumber({a1, ... ,aN}) - returns the Frobenius number of the nonnegative integers `{a1, ... ,aN}` */
	public final static IBuiltInSymbol FrobeniusNumber = initFinalSymbol("FrobeniusNumber", ID.FrobeniusNumber);
	/**
	 * FrobeniusSolve({a1, ... ,aN}, M) - get a list of solutions for the Frobenius equation given by the list of
	 * integers `{a1, ... ,aN}` and the non-negative integer `M`.
	 */
	public final static IBuiltInSymbol FrobeniusSolve = initFinalSymbol("FrobeniusSolve", ID.FrobeniusSolve);
	/**
	 * FromCharacterCode({ch1, ch2, ...}) - converts the `ch1, ch2,...` character codes into a string of corresponding
	 * characters.
	 */
	public final static IBuiltInSymbol FromCharacterCode = initFinalSymbol("FromCharacterCode", ID.FromCharacterCode);
	/**
	 * FromContinuedFraction({n1, n2, ...}) - return the number which represents the continued fraction list `{n1, n2,
	 * ...}`.
	 */
	public final static IBuiltInSymbol FromContinuedFraction = initFinalSymbol("FromContinuedFraction", ID.FromContinuedFraction);

	/** FromDigits(list) - creates an expression from the list of digits for radix `10`. */
	public final static IBuiltInSymbol FromDigits = initFinalSymbol("FromDigits", ID.FromDigits);
	/** FromPolarCoordinates({r, t}) - return the cartesian coordinates for the polar coordinates `{r, t}`. */
	public final static IBuiltInSymbol FromPolarCoordinates = initFinalSymbol("FromPolarCoordinates",
			ID.FromPolarCoordinates);

	/***/
	public final static IBuiltInSymbol Full = initFinalSymbol("Full", ID.Full);
	/** FullForm(expression) - shows the internal representation of the given `expression`. */
	public final static IBuiltInSymbol FullForm = initFinalSymbol("FullForm", ID.FullForm);
	/**
	 * FullSimplify(expr) - works like `Simplify` but additionally tries some `FunctionExpand` rule transformations to
	 * simplify `expr`.
	 */
	public final static IBuiltInSymbol FullSimplify = initFinalSymbol("FullSimplify", ID.FullSimplify);
	/***/
	public final static IBuiltInSymbol Function = initFinalSymbol("Function", ID.Function);
	/**
	 * FunctionExpand(expression) - expands the special function `expression`. `FunctionExpand` expands simple nested
	 * radicals.
	 */
	public final static IBuiltInSymbol FunctionExpand = initFinalSymbol("FunctionExpand", ID.FunctionExpand);
	/***/
	public final static IBuiltInSymbol FunctionRange = initFinalSymbol("FunctionRange", ID.FunctionRange);
	/**
	 * FunctionURL(built-in-symbol) - returns the GitHub URL of the `built-in-symbol` implementation in the [Symja
	 * GitHub repository](https://github.com/axkr/symja_android_library).
	 */
	public final static IBuiltInSymbol FunctionURL = initFinalSymbol("FunctionURL", ID.FunctionURL);
	/** GCD(n1, n2, ...) - computes the greatest common divisor of the given integers. */
	public final static IBuiltInSymbol GCD = initFinalSymbol("GCD", ID.GCD);
	/** Gamma(z) - is the gamma function on the complex number `z`. */
	public final static IBuiltInSymbol Gamma = initFinalSymbol("Gamma", ID.Gamma);
	/** GammaDistribution(a,b) - returns a gamma distribution. */
	public final static IBuiltInSymbol GammaDistribution = initFinalSymbol("GammaDistribution", ID.GammaDistribution);
	/***/
	public final static IBuiltInSymbol GammaRegularized = initFinalSymbol("GammaRegularized", ID.GammaRegularized);
	/** Gather(list, test) - gathers leaves of `list` into sub lists of items that are the same according to `test`. */
	public final static IBuiltInSymbol Gather = initFinalSymbol("Gather", ID.Gather);
	/** GatherBy(list, f) - gathers leaves of `list` into sub lists of items whose image under `f` identical. */
	public final static IBuiltInSymbol GatherBy = initFinalSymbol("GatherBy", ID.GatherBy);
	/***/
	public final static IBuiltInSymbol GaussianIntegers = initFinalSymbol("GaussianIntegers", ID.GaussianIntegers);
	/***/
	public final static IBuiltInSymbol GaussianMatrix = initFinalSymbol("GaussianMatrix", ID.GaussianMatrix);
	/***/
	public final static IBuiltInSymbol GaussianWindow = initFinalSymbol("GaussianWindow", ID.GaussianWindow);
	/** GegenbauerC(n, a, x) - returns the GegenbauerC polynomial. */
	public final static IBuiltInSymbol GegenbauerC = initFinalSymbol("GegenbauerC", ID.GegenbauerC);
	/***/
	public final static IBuiltInSymbol General = initFinalSymbol("General", ID.General);
	/**
	 * GeoDistance({latitude1,longitude1}, {latitude2,longitude2}) - returns the geodesic distance between
	 * `{latitude1,longitude1}` and `{latitude2,longitude2}`.
	 */
	public final static IBuiltInSymbol GeoDistance = initFinalSymbol("GeoDistance", ID.GeoDistance);

	/***/
	public final static IBuiltInSymbol GeoPosition = initFinalSymbol("GeoPosition", ID.GeoPosition);

	/***/
	public final static IBuiltInSymbol GeodesyData = initFinalSymbol("GeodesyData", ID.GeodesyData);

	/** GeometricDistribution(p) - returns a geometric distribution. */
	public final static IBuiltInSymbol GeometricDistribution = initFinalSymbol("GeometricDistribution",
			ID.GeometricDistribution);

	/** GeometricMean({a, b, c,...}) - returns the geometric mean of `{a, b, c,...}`. */
	public final static IBuiltInSymbol GeometricMean = initFinalSymbol("GeometricMean", ID.GeometricMean);
	/** Get("path-to-package-file-name") - load the package defined in `path-to-package-file-name`. */
	public final static IBuiltInSymbol Get = initFinalSymbol("Get", ID.Get);
	/** Glaisher - Glaisher constant. */
	public final static IBuiltInSymbol Glaisher = initFinalSymbol("Glaisher", ID.Glaisher);
	/** */
	public final static IBuiltInSymbol GoldenAngle = initFinalSymbol("GoldenAngle", ID.GoldenAngle);

	/** GoldenRatio - is the golden ratio `(1+Sqrt(5))/2`. */
	public final static IBuiltInSymbol GoldenRatio = initFinalSymbol("GoldenRatio", ID.GoldenRatio);
	/***/
	public final static IBuiltInSymbol GompertzMakehamDistribution = initFinalSymbol("GompertzMakehamDistribution",
			ID.GompertzMakehamDistribution);
	/** Grad(function, list-of-variables) - gives the gradient of the function. */
	public final static IBuiltInSymbol Grad = initFinalSymbol("Grad", ID.Grad);
	/** Graph({edge1,...,edgeN}) - create a graph from the given edges `edge1,...,edgeN`. */
	public final static IBuiltInSymbol Graph = initFinalSymbol("Graph", ID.Graph);

	/**
	 * GraphCenter(graph) - compute the `graph` center. The center of a `graph` is the set of vertices of graph
	 * eccentricity equal to the `graph` radius.
	 */
	public final static IBuiltInSymbol GraphCenter = initFinalSymbol("GraphCenter", ID.GraphCenter);
	/***/
	public final static IBuiltInSymbol GraphData = initFinalSymbol("GraphData", ID.GraphData);
	/** GraphDiameter(graph) - return the diameter of the `graph`. */
	public final static IBuiltInSymbol GraphDiameter = initFinalSymbol("GraphDiameter", ID.GraphDiameter);

	/**
	 * GraphPeriphery(graph) - compute the `graph` periphery. The periphery of a `graph` is the set of vertices of graph
	 * eccentricity equal to the graph diameter.
	 */
	public final static IBuiltInSymbol GraphPeriphery = initFinalSymbol("GraphPeriphery", ID.GraphPeriphery);

	/** GraphQ(expr) - test if `expr` is a graph object. */
	public final static IBuiltInSymbol GraphQ = initFinalSymbol("GraphQ", ID.GraphQ);
	/** GraphRadius(graph) - return the radius of the `graph`. */
	public final static IBuiltInSymbol GraphRadius = initFinalSymbol("GraphRadius", ID.GraphRadius);
	/***/
	public final static IBuiltInSymbol Graphics = initFinalSymbol("Graphics", ID.Graphics);
	/***/
	public final static IBuiltInSymbol Graphics3D = initFinalSymbol("Graphics3D", ID.Graphics3D);
	/***/
	public final static IBuiltInSymbol Gray = initFinalSymbol("Gray", ID.Gray);

	/***/
	public final static IBuiltInSymbol GrayLevel = initFinalSymbol("GrayLevel", ID.GrayLevel);
	/** Greater(x, y) - yields `True` if `x` is known to be greater than `y`. */
	public final static IBuiltInSymbol Greater = initFinalSymbol("Greater", ID.Greater);
	/** GreaterEqual(x, y) - yields `True` if `x` is known to be greater than or equal to `y`. */
	public final static IBuiltInSymbol GreaterEqual = initFinalSymbol("GreaterEqual", ID.GreaterEqual);
	/***/
	public final static IBuiltInSymbol Green = initFinalSymbol("Green", ID.Green);
	/**
	 * GroebnerBasis({polynomial-list},{variable-list}) - returns a Gröbner basis for the `polynomial-list` and
	 * `variable-list`.
	 */
	public final static IBuiltInSymbol GroebnerBasis = initFinalSymbol("GroebnerBasis", ID.GroebnerBasis);
	/***/
	public final static IBuiltInSymbol GroupBy = initFinalSymbol("GroupBy", ID.GroupBy);

	/** GumbelDistribution(a, b) - returns a Gumbel distribution. */
	public final static IBuiltInSymbol GumbelDistribution = initFinalSymbol("GumbelDistribution",
			ID.GumbelDistribution);

	/** HamiltonianGraphQ(graph) - returns `True` if `graph` is an hamiltonian graph, and `False` otherwise. */
	public final static IBuiltInSymbol HamiltonianGraphQ = initFinalSymbol("HamiltonianGraphQ", ID.HamiltonianGraphQ);
	/***/
	public final static IBuiltInSymbol HammingWindow = initFinalSymbol("HammingWindow", ID.HammingWindow);
	/***/
	public final static IBuiltInSymbol HankelH1 = initFinalSymbol("HankelH1", ID.HankelH1);

	/***/
	public final static IBuiltInSymbol HankelH2 = initFinalSymbol("HankelH2", ID.HankelH2);
	/***/
	public final static IBuiltInSymbol HannWindow = initFinalSymbol("HannWindow", ID.HannWindow);
	/** HarmonicMean({a, b, c,...}) - returns the harmonic mean of `{a, b, c,...}`. */
	public final static IBuiltInSymbol HarmonicMean = initFinalSymbol("HarmonicMean", ID.HarmonicMean);
	/** HarmonicNumber(n) - returns the `n`th harmonic number. */
	public final static IBuiltInSymbol HarmonicNumber = initFinalSymbol("HarmonicNumber", ID.HarmonicNumber);
	/** Haversine(z) - returns the haversine function of `z`. */
	public final static IBuiltInSymbol Haversine = initFinalSymbol("Haversine", ID.Haversine);
	/** Head(expr) - returns the head of the expression or atom `expr`. */
	public final static IBuiltInSymbol Head = initFinalSymbol("Head", ID.Head);
	/***/
	public final static IBuiltInSymbol Heads = initFinalSymbol("Heads", ID.Heads);
	/**
	 * HeavisideTheta(expr1, expr2, ... exprN) - returns `1` if all `expr1, expr2, ... exprN` are positive and `0` if
	 * one of the `expr1, expr2, ... exprN` is negative. `HeavisideTheta(0)` returns unevaluated as `HeavisideTheta(0)`.
	 */
	public final static IBuiltInSymbol HeavisideTheta = initFinalSymbol("HeavisideTheta", ID.HeavisideTheta);
	/** HermiteH(n, x) - returns the Hermite polynomial `H_n(x)`. */
	public final static IBuiltInSymbol HermiteH = initFinalSymbol("HermiteH", ID.HermiteH);
	/** HermitianMatrixQ(m) - returns `True` if `m` is a hermitian matrix. */
	public final static IBuiltInSymbol HermitianMatrixQ = initFinalSymbol("HermitianMatrixQ", ID.HermitianMatrixQ);
	/***/
	public final static IBuiltInSymbol HexidecimalCharacter = initFinalSymbol("HexidecimalCharacter",
			ID.HexidecimalCharacter);
	/** HilbertMatrix(n) - gives the hilbert matrix with `n` rows and columns. */
	public final static IBuiltInSymbol HilbertMatrix = initFinalSymbol("HilbertMatrix", ID.HilbertMatrix);
	/** Histogram(list-of-values) - plots a histogram for a `list-of-values` */
	public final static IBuiltInSymbol Histogram = initFinalSymbol("Histogram", ID.Histogram);
	/** Hold(expr) - `Hold` doesn't evaluate `expr`. */
	public final static IBuiltInSymbol Hold = initFinalSymbol("Hold", ID.Hold);
	/** HoldAll - is an attribute specifying that all arguments of a function should be left unevaluated. */
	public final static IBuiltInSymbol HoldAll = initFinalSymbol("HoldAll", ID.HoldAll);
	/***/
	public final static IBuiltInSymbol HoldAllComplete = initFinalSymbol("HoldAllComplete", ID.HoldAllComplete);
	/***/
	public final static IBuiltInSymbol HoldComplete = initFinalSymbol("HoldComplete", ID.HoldComplete);
	/** HoldFirst - is an attribute specifying that the first argument of a function should be left unevaluated. */
	public final static IBuiltInSymbol HoldFirst = initFinalSymbol("HoldFirst", ID.HoldFirst);
	/** HoldForm(expr) - `HoldForm` doesn't evaluate `expr` and didn't appear in the output. */
	public final static IBuiltInSymbol HoldForm = initFinalSymbol("HoldForm", ID.HoldForm);
	/** HoldPattern(expr) - `HoldPattern` doesn't evaluate `expr` for pattern-matching. */
	public final static IBuiltInSymbol HoldPattern = initFinalSymbol("HoldPattern", ID.HoldPattern);
	/**
	 * HoldRest - is an attribute specifying that all but the first argument of a function should be left unevaluated.
	 */
	public final static IBuiltInSymbol HoldRest = initFinalSymbol("HoldRest", ID.HoldRest);
	/***/
	public final static IBuiltInSymbol Horner = initFinalSymbol("Horner", ID.Horner);
	/** HornerForm(polynomial) - Generate the horner scheme for a univariate `polynomial`. */
	public final static IBuiltInSymbol HornerForm = initFinalSymbol("HornerForm", ID.HornerForm);
	/***/
	public final static IBuiltInSymbol Hue = initFinalSymbol("Hue", ID.Hue);
	/** HurwitzZeta(s, a) - returns the Hurwitz zeta function. */
	public final static IBuiltInSymbol HurwitzZeta = initFinalSymbol("HurwitzZeta", ID.HurwitzZeta);
	/** Hypergeometric0F1(b, z) - return the `Hypergeometric0F1` function */
	public final static IBuiltInSymbol Hypergeometric0F1 = initFinalSymbol("Hypergeometric0F1", ID.Hypergeometric0F1);
	/** Hypergeometric1F1(a, b, z) - return the `Hypergeometric1F1` function */
	public final static IBuiltInSymbol Hypergeometric1F1 = initFinalSymbol("Hypergeometric1F1", ID.Hypergeometric1F1);
	/***/
	public final static IBuiltInSymbol Hypergeometric1F1Regularized = initFinalSymbol("Hypergeometric1F1Regularized",
			ID.Hypergeometric1F1Regularized);
	/** Hypergeometric2F1(a, b, c, z) - return the `Hypergeometric2F1` function */
	public final static IBuiltInSymbol Hypergeometric2F1 = initFinalSymbol("Hypergeometric2F1", ID.Hypergeometric2F1);
	/** HypergeometricDistribution(n, s, t) - returns a hypergeometric distribution. */
	public final static IBuiltInSymbol HypergeometricDistribution = initFinalSymbol("HypergeometricDistribution",
			ID.HypergeometricDistribution);
	/** HypergeometricPFQ({a,...}, {b,...}, c) - return the `HypergeometricPFQ` function */
	public final static IBuiltInSymbol HypergeometricPFQ = initFinalSymbol("HypergeometricPFQ", ID.HypergeometricPFQ);
	/***/
	public final static IBuiltInSymbol HypergeometricPFQRegularized = initFinalSymbol("HypergeometricPFQRegularized",
			ID.HypergeometricPFQRegularized);
	/***/
	public final static IBuiltInSymbol HypergeometricU = initFinalSymbol("HypergeometricU", ID.HypergeometricU);
	/**
	 * I - Imaginary unit - internally converted to the complex number `0+1*i`. `I` represents the imaginary number
	 * `Sqrt(-1)`. `I^2` will be evaluated to `-1`.
	 */
	public final static IBuiltInSymbol I = initFinalSymbol("I", ID.I);
	/** Identity(expr) - returns `expr`. */
	public final static IBuiltInSymbol Identity = initFinalSymbol("Identity", ID.Identity);
	/** IdentityMatrix(n) - gives the identity matrix with `n` rows and columns. */
	public final static IBuiltInSymbol IdentityMatrix = initFinalSymbol("IdentityMatrix", ID.IdentityMatrix);
	/** If(cond, pos, neg) - returns `pos` if `cond` evaluates to `True`, and `neg` if it evaluates to `False`. */
	public final static IBuiltInSymbol If = initFinalSymbol("If", ID.If);
	/***/
	public final static IBuiltInSymbol IgnoreCase = initFinalSymbol("IgnoreCase", ID.IgnoreCase);
	/** Im(z) - returns the imaginary component of the complex number `z`. */
	public final static IBuiltInSymbol Im = initFinalSymbol("Im", ID.Im);
	/** Implies(arg1, arg2) - Logical implication. */
	public final static IBuiltInSymbol Implies = initFinalSymbol("Implies", ID.Implies);
	/**
	 * Import("path-to-filename", "WXF") - if the file system is enabled, import an expression in WXF format from the
	 * "path-to-filename" file.
	 */
	public final static IBuiltInSymbol Import = initFinalSymbol("Import", ID.Import);
	/** Increment(x) - increments `x` by `1`, returning the original value of `x`. */
	public final static IBuiltInSymbol Increment = initFinalSymbol("Increment", ID.Increment);
	/** Indeterminate - represents an indeterminate result. */
	public final static IBuiltInSymbol Indeterminate = initFinalSymbol("Indeterminate", ID.Indeterminate);
	/***/
	public final static IBuiltInSymbol Inequality = initFinalSymbol("Inequality", ID.Inequality);
	/** InexactNumberQ(expr) - returns `True` if `expr` is not an exact number, and `False` otherwise. */
	public final static IBuiltInSymbol InexactNumberQ = initFinalSymbol("InexactNumberQ", ID.InexactNumberQ);
	/** Infinity - represents an infinite real quantity. */
	public final static IBuiltInSymbol Infinity = initFinalSymbol("Infinity", ID.Infinity);
	/***/
	public final static IBuiltInSymbol Infix = initFinalSymbol("Infix", ID.Infix);
	/***/
	public final static IBuiltInSymbol Information = initFinalSymbol("Information", ID.Information);
	/**
	 * Inner(f, x, y, g) - computes a generalized inner product of `x` and `y`, using a multiplication function `f` and
	 * an addition function `g`.
	 */
	public final static IBuiltInSymbol Inner = initFinalSymbol("Inner", ID.Inner);
	/**
	 * Input() - if the file system is enabled, the user can input an expression. After input this expression will be
	 * evaluated immediately.
	 */
	public final static IBuiltInSymbol Input = initFinalSymbol("Input", ID.Input);
	/***/
	public final static IBuiltInSymbol InputField = initFinalSymbol("InputField", ID.InputField);
	/***/
	public final static IBuiltInSymbol InputForm = initFinalSymbol("InputForm", ID.InputForm);

	/** InputString() - if the file system is enabled, the user can input a string. */
	public final static IBuiltInSymbol InputString = initFinalSymbol("InputString", ID.InputString);
	/***/
	public final static IBuiltInSymbol Insert = initFinalSymbol("Insert", ID.Insert);
	/** Integer - is the head of integers. */
	public final static IBuiltInSymbol Integer = initFinalSymbol("Integer", ID.Integer);
	/** IntegerDigits(n, base) - returns a list of integer digits for `n` under `base`. */
	public final static IBuiltInSymbol IntegerDigits = initFinalSymbol("IntegerDigits", ID.IntegerDigits);
	/** IntegerExponent(n, b) - gives the highest exponent of `b` that divides `n`. */
	public final static IBuiltInSymbol IntegerExponent = initFinalSymbol("IntegerExponent", ID.IntegerExponent);
	/** IntegerLength(x) - gives the number of digits in the base-10 representation of `x`. */
	public final static IBuiltInSymbol IntegerLength = initFinalSymbol("IntegerLength", ID.IntegerLength);

	/** IntegerName(integer-number) - gives the spoken number string of `integer-number` in language `English`. */
	public final static IBuiltInSymbol IntegerName = initFinalSymbol("IntegerName", ID.IntegerName);

	/** IntegerPart(expr) - for real `expr` return the integer part of `expr`. */
	public final static IBuiltInSymbol IntegerPart = initFinalSymbol("IntegerPart", ID.IntegerPart);
	/** IntegerPartitions(n) - returns all partitions of the integer `n`. */
	public final static IBuiltInSymbol IntegerPartitions = initFinalSymbol("IntegerPartitions", ID.IntegerPartitions);
	/** IntegerQ(expr) - returns `True` if `expr` is an integer, and `False` otherwise. */
	public final static IBuiltInSymbol IntegerQ = initFinalSymbol("IntegerQ", ID.IntegerQ);
	/** Integers - is the set of integer numbers. */
	public final static IBuiltInSymbol Integers = initFinalSymbol("Integers", ID.Integers);
	/**
	 * Integrate(f, x) - integrates `f` with respect to `x`. The result does not contain the additive integration
	 * constant.
	 */
	public final static IBuiltInSymbol Integrate = initFinalSymbol("Integrate", ID.Integrate);
	/**
	 * InterpolatingFunction(data-list) - get the representation for the given `data-list` as piecewise
	 * `InterpolatingPolynomial`s.
	 */
	public final static IBuiltInSymbol InterpolatingFunction = initFinalSymbol("InterpolatingFunction",
			ID.InterpolatingFunction);
	/** InterpolatingPolynomial(data-list, symbol) - get the polynomial representation for the given `data-list`. */
	public final static IBuiltInSymbol InterpolatingPolynomial = initFinalSymbol("InterpolatingPolynomial",
			ID.InterpolatingPolynomial);
	/***/
	public final static IBuiltInSymbol Interpolation = initFinalSymbol("Interpolation", ID.Interpolation);
	/** Interrupt( ) - Interrupt an evaluation and returns `$Aborted`. */
	public final static IBuiltInSymbol Interrupt = initFinalSymbol("Interrupt", ID.Interrupt);
	/***/
	public final static IBuiltInSymbol IntersectingQ = initFinalSymbol("IntersectingQ", ID.IntersectingQ);
	/** Intersection(set1, set2, ...) - get the intersection set from `set1` and `set2` .... */
	public final static IBuiltInSymbol Intersection = initFinalSymbol("Intersection", ID.Intersection);
	/** Interval({a, b}) - represents the interval from `a` to `b`. */
	public final static IBuiltInSymbol Interval = initFinalSymbol("Interval", ID.Interval);
	/**
	 * IntervalIntersection(interval_1, interval_2, ...) - compute the intersection of the intervals `interval_1,
	 * interval_2, ...`
	 */
	public final static IBuiltInSymbol IntervalIntersection = initFinalSymbol("IntervalIntersection",
			ID.IntervalIntersection);

	/**
	 * IntervalMemberQ(interval, interval-or-real-number) - returns `True`, if `interval-or-real-number` is completly
	 * sourrounded by `interval`
	 */
	public final static IBuiltInSymbol IntervalMemberQ = initFinalSymbol("IntervalMemberQ", ID.IntervalMemberQ);

	/** IntervalUnion(interval_1, interval_2, ...) - compute the union of the intervals `interval_1, interval_2, ...` */
	public final static IBuiltInSymbol IntervalUnion = initFinalSymbol("IntervalUnion", ID.IntervalUnion);
	/** Inverse(matrix) - computes the inverse of the `matrix`. */
	public final static IBuiltInSymbol Inverse = initFinalSymbol("Inverse", ID.Inverse);
	/***/
	public final static IBuiltInSymbol InverseBetaRegularized = initFinalSymbol("InverseBetaRegularized", ID.InverseBetaRegularized);

	/**
	 * InverseCDF(dist, q) - returns the inverse cumulative distribution for the distribution `dist` as a function of
	 * `q`
	 */
	public final static IBuiltInSymbol InverseCDF = initFinalSymbol("InverseCDF", ID.InverseCDF);
	/** InverseErf(z) - returns the inverse error function of `z`. */
	public final static IBuiltInSymbol InverseErf = initFinalSymbol("InverseErf", ID.InverseErf);
	/** InverseErfc(z) - returns the inverse complementary error function of `z`. */
	public final static IBuiltInSymbol InverseErfc = initFinalSymbol("InverseErfc", ID.InverseErfc);
	/**
	 * InverseFourier(vector-of-complex-numbers) - Inverse discrete Fourier transform of a `vector-of-complex-numbers`.
	 * Fourier transform is restricted to vectors with length of power of 2.
	 */
	public final static IBuiltInSymbol InverseFourier = initFinalSymbol("InverseFourier", ID.InverseFourier);

	/** InverseFunction(head) - returns the inverse function for the symbol `head`. */
	public final static IBuiltInSymbol InverseFunction = initFinalSymbol("InverseFunction", ID.InverseFunction);
	/***/
	public final static IBuiltInSymbol InverseGammaRegularized = initFinalSymbol("InverseGammaRegularized",
			ID.InverseGammaRegularized);
	/** InverseHaversine(z) - returns the inverse haversine function of `z`. */
	public final static IBuiltInSymbol InverseHaversine = initFinalSymbol("InverseHaversine", ID.InverseHaversine);
	/** InverseLaplaceTransform(f,s,t) - returns the inverse laplace transform. */
	public final static IBuiltInSymbol InverseLaplaceTransform = initFinalSymbol("InverseLaplaceTransform",
			ID.InverseLaplaceTransform);
	/** InverseSeries( series ) - return the inverse series. */
	public final static IBuiltInSymbol InverseSeries = initFinalSymbol("InverseSeries", ID.InverseSeries);
	/***/
	public final static IBuiltInSymbol InverseWeierstrassP = initFinalSymbol("InverseWeierstrassP", ID.InverseWeierstrassP);

	/** JSForm(expr) - returns the JavaScript form of the `expr`. */
	public final static IBuiltInSymbol JSForm = initFinalSymbol("JSForm", ID.JSForm);

	/***/
	public final static IBuiltInSymbol JSFormData = initFinalSymbol("JSFormData", ID.JSFormData);

	/**
	 * JaccardDissimilarity(u, v) - returns the Jaccard-Needham dissimilarity between the two boolean 1-D lists `u` and
	 * `v`, which is defined as `(c_tf + c_ft) / (c_tt + c_ft + c_tf)`, where n is `len(u)` and `c_ij` is the number of
	 * occurrences of `u(k)=i` and `v(k)=j` for `k<n`.
	 */
	public final static IBuiltInSymbol JaccardDissimilarity = initFinalSymbol("JaccardDissimilarity", ID.JaccardDissimilarity);

	/** JacobiAmplitude(x, m) - returns the amplitude `am(x, m)` for Jacobian elliptic function. */
	public final static IBuiltInSymbol JacobiAmplitude = initFinalSymbol("JacobiAmplitude", ID.JacobiAmplitude);

	/***/
	public final static IBuiltInSymbol JacobiCD = initFinalSymbol("JacobiCD", ID.JacobiCD);
	/** JacobiCN(x, m) - returns the Jacobian elliptic function `cn(x, m)`. */
	public final static IBuiltInSymbol JacobiCN = initFinalSymbol("JacobiCN", ID.JacobiCN);

	/***/
	public final static IBuiltInSymbol JacobiDC = initFinalSymbol("JacobiDC", ID.JacobiDC);
	/** JacobiDN(x, m) - returns the Jacobian elliptic function `dn(x, m)`. */
	public final static IBuiltInSymbol JacobiDN = initFinalSymbol("JacobiDN", ID.JacobiDN);

	/** JacobiMatrix(matrix, var) - creates a Jacobian matrix. */
	public final static IBuiltInSymbol JacobiMatrix = initFinalSymbol("JacobiMatrix", ID.JacobiMatrix);
	/***/
	public final static IBuiltInSymbol JacobiNC = initFinalSymbol("JacobiNC", ID.JacobiNC);

	/***/
	public final static IBuiltInSymbol JacobiND = initFinalSymbol("JacobiND", ID.JacobiND);

	/***/
	public final static IBuiltInSymbol JacobiSC = initFinalSymbol("JacobiSC", ID.JacobiSC);

	/***/
	public final static IBuiltInSymbol JacobiSD = initFinalSymbol("JacobiSD", ID.JacobiSD);
	/** JacobiSN(x, m) - returns the Jacobian elliptic function `sn(x, m)`. */
	public final static IBuiltInSymbol JacobiSN = initFinalSymbol("JacobiSN", ID.JacobiSN);
	/** JacobiSymbol(m, n) - calculates the Jacobi symbol. */
	public final static IBuiltInSymbol JacobiSymbol = initFinalSymbol("JacobiSymbol", ID.JacobiSymbol);
	/***/
	public final static IBuiltInSymbol JacobiZeta = initFinalSymbol("JacobiZeta", ID.JacobiZeta);
	/**
	 * JavaForm(expr) - returns the Symja Java form of the `expr`. In Java you can use the created Symja expressions.
	 */
	public final static IBuiltInSymbol JavaForm = initFinalSymbol("JavaForm", ID.JavaForm);
	/** Join(l1, l2) - concatenates the lists `l1` and `l2`. */
	public final static IBuiltInSymbol Join = initFinalSymbol("Join", ID.Join);
	/***/
	public final static IBuiltInSymbol KOrderlessPartitions = initFinalSymbol("KOrderlessPartitions",
			ID.KOrderlessPartitions);
	/***/
	public final static IBuiltInSymbol KPartitions = initFinalSymbol("KPartitions", ID.KPartitions);
	/***/
	public final static IBuiltInSymbol Key = initFinalSymbol("Key", ID.Key);

	/***/
	public final static IBuiltInSymbol KeyExistsQ = initFinalSymbol("KeyExistsQ", ID.KeyExistsQ);

	/** KeySort(<|key1->value1, ...|>) - sort the `<|key1->value1, ...|>` entries by the `key` values. */
	public final static IBuiltInSymbol KeySort = initFinalSymbol("KeySort", ID.KeySort);

	/***/
	public final static IBuiltInSymbol KeyTake = initFinalSymbol("KeyTake", ID.KeyTake);
	/** Keys(association) - return a list of keys of the `association`. */
	public final static IBuiltInSymbol Keys = initFinalSymbol("Keys", ID.Keys);
	/** Khinchin - Khinchin's constant */
	public final static IBuiltInSymbol Khinchin = initFinalSymbol("Khinchin", ID.Khinchin);
	/***/
	public final static IBuiltInSymbol KleinInvariantJ = initFinalSymbol("KleinInvariantJ", ID.KleinInvariantJ);
	/***/
	public final static IBuiltInSymbol KnownUnitQ = initFinalSymbol("KnownUnitQ", ID.KnownUnitQ);

	/**
	 * KolmogorovSmirnovTest(data) - Computes the `p-value`, or <i>observed significance level</i>, of a one-sample
	 * [Wikipedia:Kolmogorov-Smirnov test](http://en.wikipedia.org/wiki/Kolmogorov-Smirnov_test) evaluating the null
	 * hypothesis that `data` conforms to the `NormalDistribution()`.
	 */
	public final static IBuiltInSymbol KolmogorovSmirnovTest = initFinalSymbol("KolmogorovSmirnovTest",
			ID.KolmogorovSmirnovTest);

	/**
	 * KroneckerDelta(arg1, arg2, ... argN) - if all arguments `arg1` to `argN` are equal return `1`, otherwise return
	 * `0`.
	 */
	public final static IBuiltInSymbol KroneckerDelta = initFinalSymbol("KroneckerDelta", ID.KroneckerDelta);
	/** Kurtosis(list) - gives the Pearson measure of kurtosis for `list` (a measure of existing outliers). */
	public final static IBuiltInSymbol Kurtosis = initFinalSymbol("Kurtosis", ID.Kurtosis);
	/** LCM(n1, n2, ...) - computes the least common multiple of the given integers. */
	public final static IBuiltInSymbol LCM = initFinalSymbol("LCM", ID.LCM);
	/** LUDecomposition(matrix) - calculate the LUP-decomposition of a square `matrix`. */
	public final static IBuiltInSymbol LUDecomposition = initFinalSymbol("LUDecomposition", ID.LUDecomposition);
	/** LaguerreL(n, x) - returns the Laguerre polynomial `L_n(x)`. */
	public final static IBuiltInSymbol LaguerreL = initFinalSymbol("LaguerreL", ID.LaguerreL);
	/** LaplaceTransform(f,t,s) - returns the laplace transform. */
	public final static IBuiltInSymbol LaplaceTransform = initFinalSymbol("LaplaceTransform", ID.LaplaceTransform);
	/** Last(expr) - returns the last element in `expr`. */
	public final static IBuiltInSymbol Last = initFinalSymbol("Last", ID.Last);
	/** LeafCount(expr) - returns the total number of indivisible subexpressions in `expr`. */
	public final static IBuiltInSymbol LeafCount = initFinalSymbol("LeafCount", ID.LeafCount);
	/** LeastSquares(matrix, right) - solves the linear least-squares problem 'matrix . x = right'. */
	public final static IBuiltInSymbol LeastSquares = initFinalSymbol("LeastSquares", ID.LeastSquares);
	/***/
	public final static IBuiltInSymbol Left = initFinalSymbol("Left", ID.Left);
	/** LegendreP(n, x) - returns the Legendre polynomial `P_n(x)`. */
	public final static IBuiltInSymbol LegendreP = initFinalSymbol("LegendreP", ID.LegendreP);
	/** LegendreQ(n, x) - returns the Legendre functions of the second kind `Q_n(x)`. */
	public final static IBuiltInSymbol LegendreQ = initFinalSymbol("LegendreQ", ID.LegendreQ);
	/** Length(expr) - returns the number of leaves in `expr`. */
	public final static IBuiltInSymbol Length = initFinalSymbol("Length", ID.Length);
	/** Less(x, y) - yields `True` if `x` is known to be less than `y`. */
	public final static IBuiltInSymbol Less = initFinalSymbol("Less", ID.Less);
	/** LessEqual(x, y) - yields `True` if `x` is known to be less than or equal `y`. */
	public final static IBuiltInSymbol LessEqual = initFinalSymbol("LessEqual", ID.LessEqual);
	/***/
	public final static IBuiltInSymbol LetterCharacter = initFinalSymbol("LetterCharacter", ID.LetterCharacter);

	/**
	 * LetterCounts(string) - count the number of each distinct character in the `string` and return the result as an
	 * association `<|char->counter1, ...|>`.
	 */
	public final static IBuiltInSymbol LetterCounts = initFinalSymbol("LetterCounts", ID.LetterCounts);
	/** LetterQ(expr) - tests whether `expr` is a string, which only contains letters. */
	public final static IBuiltInSymbol LetterQ = initFinalSymbol("LetterQ", ID.LetterQ);
	/**
	 * Level(expr, levelspec) - gives a list of all sub-expressions of `expr` at the level(s) specified by `levelspec`.
	 */
	public final static IBuiltInSymbol Level = initFinalSymbol("Level", ID.Level);
	/** LevelQ(expr) - tests whether `expr` is a valid level specification. */
	public final static IBuiltInSymbol LevelQ = initFinalSymbol("LevelQ", ID.LevelQ);
	/***/
	public final static IBuiltInSymbol Lexicographic = initFinalSymbol("Lexicographic", ID.Lexicographic);

	/***/
	public final static IBuiltInSymbol LightBlue = initFinalSymbol("LightBlue", ID.LightBlue);

	/***/
	public final static IBuiltInSymbol LightBrown = initFinalSymbol("LightBrown", ID.LightBrown);

	/***/
	public final static IBuiltInSymbol LightCyan = initFinalSymbol("LightCyan", ID.LightCyan);

	/***/
	public final static IBuiltInSymbol LightGray = initFinalSymbol("LightGray", ID.LightGray);

	/***/
	public final static IBuiltInSymbol LightGreen = initFinalSymbol("LightGreen", ID.LightGreen);

	/***/
	public final static IBuiltInSymbol LightMagenta = initFinalSymbol("LightMagenta", ID.LightMagenta);

	/***/
	public final static IBuiltInSymbol LightOrange = initFinalSymbol("LightOrange", ID.LightOrange);

	/***/
	public final static IBuiltInSymbol LightPink = initFinalSymbol("LightPink", ID.LightPink);

	/***/
	public final static IBuiltInSymbol LightPurple = initFinalSymbol("LightPurple", ID.LightPurple);

	/***/
	public final static IBuiltInSymbol LightRed = initFinalSymbol("LightRed", ID.LightRed);

	/***/
	public final static IBuiltInSymbol LightYellow = initFinalSymbol("LightYellow", ID.LightYellow);
	/** Limit(expr, x->x0) - gives the limit of `expr` as `x` approaches `x0` */
	public final static IBuiltInSymbol Limit = initFinalSymbol("Limit", ID.Limit);
	/***/
	public final static IBuiltInSymbol Line = initFinalSymbol("Line", ID.Line);
	/**
	 * LinearModelFit(list-of-data-points, expr, symbol) - In statistics, linear regression is a linear approach to
	 * modeling the relationship between a scalar response (or dependent variable) and one or more explanatory variables
	 * (or independent variables).
	 */
	public final static IBuiltInSymbol LinearModelFit = initFinalSymbol("LinearModelFit", ID.LinearModelFit);
	/**
	 * LinearProgramming(coefficientsOfLinearObjectiveFunction, constraintList, constraintRelationList) - the
	 * `LinearProgramming` function provides an implementation of [George Dantzig's simplex
	 * algorithm](http://en.wikipedia.org/wiki/Simplex_algorithm) for solving linear optimization problems with linear
	 * equality and inequality constraints and implicit non-negative variables.
	 */
	public final static IBuiltInSymbol LinearProgramming = initFinalSymbol("LinearProgramming", ID.LinearProgramming);
	/**
	 * LinearRecurrence(list1, list2, n) - solve the linear recurrence and return the generated sequence of elements.
	 */
	public final static IBuiltInSymbol LinearRecurrence = initFinalSymbol("LinearRecurrence", ID.LinearRecurrence);
	/**
	 * LinearSolve(matrix, right) - solves the linear equation system 'matrix . x = right' and returns one corresponding
	 * solution `x`.
	 */
	public final static IBuiltInSymbol LinearSolve = initFinalSymbol("LinearSolve", ID.LinearSolve);
	/***/
	public final static IBuiltInSymbol LiouvilleLambda = initFinalSymbol("LiouvilleLambda", ID.LiouvilleLambda);
	/** List(e1, e2, ..., ei) - represents a list containing the elements `e1...ei`. */
	public final static IBuiltInSymbol List = initFinalSymbol("List", ID.List);
	/***/
	public final static IBuiltInSymbol ListContourPlot = initFinalSymbol("ListContourPlot", ID.ListContourPlot);
	/** ListConvolve(kernel-list, tensor-list) - create the convolution of the `kernel-list` with `tensor-list`. */
	public final static IBuiltInSymbol ListConvolve = initFinalSymbol("ListConvolve", ID.ListConvolve);


	/** ListCorrelate(kernel-list, tensor-list) - create the correlation of the `kernel-list` with `tensor-list`. */
	public final static IBuiltInSymbol ListCorrelate = initFinalSymbol("ListCorrelate", ID.ListCorrelate);

	/** ListLinePlot( { list-of-points } ) - generate a JavaScript list line plot control for the `list-of-points`. */
	public final static IBuiltInSymbol ListLinePlot = initFinalSymbol("ListLinePlot", ID.ListLinePlot);
	/** ListPlot( { list-of-points } ) - generate a JavaScript list plot control for the `list-of-points`. */
	public final static IBuiltInSymbol ListPlot = initFinalSymbol("ListPlot", ID.ListPlot);

	/** ListPlot3D( { list-of-points } ) - generate a JavaScript list plot 3D control for the `list-of-points`. */
	public final static IBuiltInSymbol ListPlot3D = initFinalSymbol("ListPlot3D", ID.ListPlot3D);
	/** ListQ(expr) - tests whether `expr` is a `List`. */
	public final static IBuiltInSymbol ListQ = initFinalSymbol("ListQ", ID.ListQ);
	/**
	 * Listable - is an attribute specifying that a function should be automatically applied to each element of a list.
	 */
	public final static IBuiltInSymbol Listable = initFinalSymbol("Listable", ID.Listable);
	/***/
	public final static IBuiltInSymbol Literal = initFinalSymbol("Literal", ID.Literal);
	/** Log(z) - returns the natural logarithm of `z`. */
	public final static IBuiltInSymbol Log = initFinalSymbol("Log", ID.Log);
	/**
	 * Log10(z) - returns the base-`10` logarithm of `z`. `Log10(z)` will be converted to `Log(z)/Log(10)` in symbolic
	 * mode.
	 */
	public final static IBuiltInSymbol Log10 = initFinalSymbol("Log10", ID.Log10);
	/**
	 * Log2(z) - returns the base-`2` logarithm of `z`. `Log2(z)` will be converted to `Log(z)/Log(2)` in symbolic mode.
	 */
	public final static IBuiltInSymbol Log2 = initFinalSymbol("Log2", ID.Log2);
	/** LogGamma(z) - is the logarithmic gamma function on the complex number `z`. */
	public final static IBuiltInSymbol LogGamma = initFinalSymbol("LogGamma", ID.LogGamma);
	/** LogIntegral(expr) - returns the integral logarithm of `expr`. */
	public final static IBuiltInSymbol LogIntegral = initFinalSymbol("LogIntegral", ID.LogIntegral);
	/** LogNormalDistribution(m, s) - returns a log-normal distribution. */
	public final static IBuiltInSymbol LogNormalDistribution = initFinalSymbol("LogNormalDistribution",
			ID.LogNormalDistribution);
	/***/
	public final static IBuiltInSymbol LogicalExpand = initFinalSymbol("LogicalExpand", ID.LogicalExpand);
	/** LogisticSigmoid(z) - returns the logistic sigmoid of `z`. */
	public final static IBuiltInSymbol LogisticSigmoid = initFinalSymbol("LogisticSigmoid", ID.LogisticSigmoid);
	/***/
	public final static IBuiltInSymbol Longest = initFinalSymbol("Longest", ID.Longest);
	/***/
	public final static IBuiltInSymbol LongForm = initFinalSymbol("LongForm", ID.LongForm);
	/**
	 * Lookup(association, key) - return the value in the `association` which is associated with the `key`. If no value
	 * is available return `Missing("KeyAbsent",key)`.
	 */
	public final static IBuiltInSymbol Lookup = initFinalSymbol("Lookup", ID.Lookup);
	/***/
	public final static IBuiltInSymbol LowerCaseQ = initFinalSymbol("LowerCaseQ", ID.LowerCaseQ);
	/** LowerTriangularize(matrix) - create a lower triangular matrix from the given `matrix`. */
	public final static IBuiltInSymbol LowerTriangularize = initFinalSymbol("LowerTriangularize",
			ID.LowerTriangularize);
	/** LucasL(n) - gives the `n`th Lucas number. */
	public final static IBuiltInSymbol LucasL = initFinalSymbol("LucasL", ID.LucasL);
	/** MachineNumberQ(expr) - returns `True` if `expr` is a machine-precision real or complex number. */
	public final static IBuiltInSymbol MachineNumberQ = initFinalSymbol("MachineNumberQ", ID.MachineNumberQ);
	/***/
	public final static IBuiltInSymbol Magenta = initFinalSymbol("Magenta", ID.Magenta);
	/** MangoldtLambda(n) - the von Mangoldt function of `n` */
	public final static IBuiltInSymbol MangoldtLambda = initFinalSymbol("MangoldtLambda", ID.MangoldtLambda);
	/**
	 * ManhattanDistance(u, v) - returns the Manhattan distance between `u` and `v`, which is the number of horizontal
	 * or vertical moves in the grid like Manhattan city layout to get from `u` to `v`.
	 */
	public final static IBuiltInSymbol ManhattanDistance = initFinalSymbol("ManhattanDistance", ID.ManhattanDistance);
	/**
	 * Manipulate(plot, {x, min, max}) - generate a JavaScript control for the expression `plot` which can be
	 * manipulated by a range slider `{x, min, max}`.
	 */
	public final static IBuiltInSymbol Manipulate = initFinalSymbol("Manipulate", ID.Manipulate);
	/***/
	public final static IBuiltInSymbol MantissaExponent = initFinalSymbol("MantissaExponent", ID.MantissaExponent);
	/** Map(f, expr) or f /@ expr - applies `f` to each part on the first level of `expr`. */
	public final static IBuiltInSymbol Map = initFinalSymbol("Map", ID.Map);
	/***/
	public final static IBuiltInSymbol MapAll = initFinalSymbol("MapAll", ID.MapAll);
	/***/
	public final static IBuiltInSymbol MapAt = initFinalSymbol("MapAt", ID.MapAt);
	/**
	 * MapIndexed(f, expr) - applies `f` to each part on the first level of `expr` and appending the elements position
	 * as a list in the second argument.
	 */
	public final static IBuiltInSymbol MapIndexed = initFinalSymbol("MapIndexed", ID.MapIndexed);
	/** MapThread(f, {{a1, a2, ...}, {b1, b2, ...}, ...}) - returns `{f(a1, b1, ...), f(a2, b2, ...), ...}`. */
	public final static IBuiltInSymbol MapThread = initFinalSymbol("MapThread", ID.MapThread);
	/** MatchQ(expr, form) - tests whether `expr` matches `form`. */
	public final static IBuiltInSymbol MatchQ = initFinalSymbol("MatchQ", ID.MatchQ);
	/**
	 * MatchingDissimilarity(u, v) - returns the Matching dissimilarity between the two boolean 1-D lists `u` and `v`,
	 * which is defined as `(c_tf + c_ft) / n`, where `n` is `len(u)` and `c_ij` is the number of occurrences of
	 * `u(k)=i` and `v(k)=j` for `k<n`.
	 */
	public final static IBuiltInSymbol MatchingDissimilarity = initFinalSymbol("MatchingDissimilarity",
			ID.MatchingDissimilarity);
	/** MathMLForm(expr) - returns the MathML form of the evaluated `expr`. */
	public final static IBuiltInSymbol MathMLForm = initFinalSymbol("MathMLForm", ID.MathMLForm);
	/** MatrixExp(matrix) - computes the matrix exponential of the square `matrix`. */
	public final static IBuiltInSymbol MatrixExp = initFinalSymbol("MatrixExp", ID.MatrixExp);
	/***/
	public final static IBuiltInSymbol MatrixForm = initFinalSymbol("MatrixForm", ID.MatrixForm);
	/**
	 * MatrixMinimalPolynomial(matrix, var) - computes the matrix minimal polynomial of a `matrix` for the variable
	 * `var`.
	 */
	public final static IBuiltInSymbol MatrixMinimalPolynomial = initFinalSymbol("MatrixMinimalPolynomial",
			ID.MatrixMinimalPolynomial);
	/** MatrixPlot( matrix ) - create a matrix plot. */
	public final static IBuiltInSymbol MatrixPlot = initFinalSymbol("MatrixPlot", ID.MatrixPlot);
	/** MatrixPower(matrix, n) - computes the `n`th power of a `matrix` */
	public final static IBuiltInSymbol MatrixPower = initFinalSymbol("MatrixPower", ID.MatrixPower);
	/** MatrixQ(m) - returns `True` if `m` is a list of equal-length lists. */
	public final static IBuiltInSymbol MatrixQ = initFinalSymbol("MatrixQ", ID.MatrixQ);
	/** MatrixRank(matrix) - returns the rank of `matrix`. */
	public final static IBuiltInSymbol MatrixRank = initFinalSymbol("MatrixRank", ID.MatrixRank);
	/** Max(e_1, e_2, ..., e_i) - returns the expression with the greatest value among the `e_i`. */
	public final static IBuiltInSymbol Max = initFinalSymbol("Max", ID.Max);
	/** MaxFilter(list, r) - filter which evaluates the `Max` of `list` for the radius `r`. */
	public final static IBuiltInSymbol MaxFilter = initFinalSymbol("MaxFilter", ID.MaxFilter);
	/***/
	public final static IBuiltInSymbol MaxIterations = initFinalSymbol("MaxIterations", ID.MaxIterations);
	/***/
	public final static IBuiltInSymbol MaxPoints = initFinalSymbol("MaxPoints", ID.MaxPoints);
	/** Maximize(unary-function, variable) - returns the maximum of the unary function for the given `variable`. */
	public final static IBuiltInSymbol Maximize = initFinalSymbol("Maximize", ID.Maximize);
	/** Mean(list) - returns the statistical mean of `list`. */
	public final static IBuiltInSymbol Mean = initFinalSymbol("Mean", ID.Mean);
	/***/
	public final static IBuiltInSymbol MeanDeviation = initFinalSymbol("MeanDeviation", ID.MeanDeviation);

	/** MeanFilter(list, r) - filter which evaluates the `Mean` of `list` for the radius `r`. */
	public final static IBuiltInSymbol MeanFilter = initFinalSymbol("MeanFilter", ID.MeanFilter);
	/** Median(list) - returns the median of `list`. */
	public final static IBuiltInSymbol Median = initFinalSymbol("Median", ID.Median);
	/** MedianFilter(list, r) - filter which evaluates the `Median` of `list` for the radius `r`. */
	public final static IBuiltInSymbol MedianFilter = initFinalSymbol("MedianFilter", ID.MedianFilter);
	/***/
	public final static IBuiltInSymbol MeijerG = initFinalSymbol("MeijerG", ID.MeijerG);
	/** MemberQ(list, pattern) - returns `True` if pattern matches any element of `list`, or `False` otherwise. */
	public final static IBuiltInSymbol MemberQ = initFinalSymbol("MemberQ", ID.MemberQ);
	/** MersennePrimeExponent(n) - returns the `n`th mersenne prime exponent. `2^n - 1` must be a prime number. */
	public final static IBuiltInSymbol MersennePrimeExponent = initFinalSymbol("MersennePrimeExponent", ID.MersennePrimeExponent);
	/**
	 * MersennePrimeExponentQ(n) - returns `True` if `2^n - 1` is a prime number. Currently `0 <= n <= 47` can be
	 * computed in reasonable time.
	 */
	public final static IBuiltInSymbol MersennePrimeExponentQ = initFinalSymbol("MersennePrimeExponentQ",
			ID.MersennePrimeExponentQ);
	/***/
	public final static IBuiltInSymbol MeshRange = initFinalSymbol("MeshRange", ID.MeshRange);
	/**
	 * Message(symbol::msg, expr1, expr2, ...) - displays the specified message, replacing placeholders in the message
	 * text with the corresponding expressions.
	 */
	public final static IBuiltInSymbol Message = initFinalSymbol("Message", ID.Message);
	/**
	 * MessageName(symbol, msg) - `symbol::msg` identifies a message. `MessageName` is the head of message IDs of the
	 * form `symbol::tag`.
	 */
	public final static IBuiltInSymbol MessageName = initFinalSymbol("MessageName", ID.MessageName);
	/***/
	public final static IBuiltInSymbol Messages = initFinalSymbol("Messages", ID.Messages);
	/***/
	public final static IBuiltInSymbol Method = initFinalSymbol("Method", ID.Method);
	/** Min(e_1, e_2, ..., e_i) - returns the expression with the lowest value among the `e_i`. */
	public final static IBuiltInSymbol Min = initFinalSymbol("Min", ID.Min);
	/** MinFilter(list, r) - filter which evaluates the `Min` of `list` for the radius `r`. */
	public final static IBuiltInSymbol MinFilter = initFinalSymbol("MinFilter", ID.MinFilter);
	/***/
	public final static IBuiltInSymbol MinMax = initFinalSymbol("MinMax", ID.MinMax);
	/***/
	public final static IBuiltInSymbol MinimalPolynomial = initFinalSymbol("MinimalPolynomial", ID.MinimalPolynomial);
	/** Minimize(unary-function, variable) - returns the minimum of the unary function for the given `variable`. */
	public final static IBuiltInSymbol Minimize = initFinalSymbol("Minimize", ID.Minimize);
	/** Minus(expr) - is the negation of `expr`. */
	public final static IBuiltInSymbol Minus = initFinalSymbol("Minus", ID.Minus);
	/***/
	public final static IBuiltInSymbol Missing = initFinalSymbol("Missing", ID.Missing);
	/** MissingQ(expr) - returns `True` if `expr` is a `Missing()` expression. */
	public final static IBuiltInSymbol MissingQ = initFinalSymbol("MissingQ", ID.MissingQ);
	/** Mod(x, m) - returns `x` modulo `m`. */
	public final static IBuiltInSymbol Mod = initFinalSymbol("Mod", ID.Mod);
	/**
	 * Module({list_of_local_variables}, expr ) - evaluates `expr` for the `list_of_local_variables` by renaming local
	 * variables.
	 */
	public final static IBuiltInSymbol Module = initFinalSymbol("Module", ID.Module);
	/***/
	public final static IBuiltInSymbol Modulus = initFinalSymbol("Modulus", ID.Modulus);
	/** MoebiusMu(expr) - calculate the Möbius function. */
	public final static IBuiltInSymbol MoebiusMu = initFinalSymbol("MoebiusMu", ID.MoebiusMu);
	/**
	 * MonomialList(polynomial, list-of-variables) - get the list of monomials of a `polynomial` expression, with
	 * respect to the `list-of-variables`.
	 */
	public final static IBuiltInSymbol MonomialList = initFinalSymbol("MonomialList", ID.MonomialList);
	/***/
	public final static IBuiltInSymbol MonomialOrder = initFinalSymbol("MonomialOrder", ID.MonomialOrder);

	/** Most(expr) - returns `expr` with the last element removed. */
	public final static IBuiltInSymbol Most = initFinalSymbol("Most", ID.Most);
	/** Multinomial(n1, n2, ...) - gives the multinomial coefficient `(n1+n2+...)!/(n1! n2! ...)`. */
	public final static IBuiltInSymbol Multinomial = initFinalSymbol("Multinomial", ID.Multinomial);
	/** MultiplicativeOrder(a, n) - gives the multiplicative order `a` modulo `n`. */
	public final static IBuiltInSymbol MultiplicativeOrder = initFinalSymbol("MultiplicativeOrder",
			ID.MultiplicativeOrder);
	/** N(expr) - gives the numerical value of `expr`. */
	public final static IBuiltInSymbol N = initFinalSymbol("N", ID.N);
	/**
	 * ND(function, x, value) - returns a numerical approximation of the partial derivative of the `function` for the
	 * variable `x` and the given `value`.
	 */
	public final static IBuiltInSymbol ND = initFinalSymbol("ND", ID.ND);
	/***/
	public final static IBuiltInSymbol NDSolve = initFinalSymbol("NDSolve", ID.NDSolve);
	/***/
	public final static IBuiltInSymbol NFourierTransform = initFinalSymbol("NFourierTransform", ID.NFourierTransform);
	/** NHoldAll - is an attribute that protects all arguments of a function from numeric evaluation. */
	public final static IBuiltInSymbol NHoldAll = initFinalSymbol("NHoldAll", ID.NHoldAll);
	/** NHoldFirst - is an attribute that protects the first argument of a function from numeric evaluation. */
	public final static IBuiltInSymbol NHoldFirst = initFinalSymbol("NHoldFirst", ID.NHoldFirst);
	/** NHoldRest - is an attribute that protects all but the first argument of a function from numeric evaluation. */
	public final static IBuiltInSymbol NHoldRest = initFinalSymbol("NHoldRest", ID.NHoldRest);
	/**
	 * NIntegrate(f, {x,a,b}) - computes the numerical univariate real integral of `f` with respect to `x` from `a` to
	 * `b`.
	 */
	public final static IBuiltInSymbol NIntegrate = initFinalSymbol("NIntegrate", ID.NIntegrate);
	/**
	 * NMaximize({maximize_function, constraints}, variables_list) - the `NMaximize` function provides an implementation
	 * of [George Dantzig's simplex algorithm](http://en.wikipedia.org/wiki/Simplex_algorithm) for solving linear
	 * optimization problems with linear equality and inequality constraints and implicit non-negative variables.
	 */
	public final static IBuiltInSymbol NMaximize = initFinalSymbol("NMaximize", ID.NMaximize);
	/**
	 * NMinimize({maximize_function, constraints}, variables_list) - the `NMinimize` function provides an implementation
	 * of [George Dantzig's simplex algorithm](http://en.wikipedia.org/wiki/Simplex_algorithm) for solving linear
	 * optimization problems with linear equality and inequality constraints and implicit non-negative variables.
	 */
	public final static IBuiltInSymbol NMinimize = initFinalSymbol("NMinimize", ID.NMinimize);
	/** NRoots(polynomial==0) - gives the numerical roots of a univariate polynomial `polynomial`. */
	public final static IBuiltInSymbol NRoots = initFinalSymbol("NRoots", ID.NRoots);
	/** NSolve(equations, vars) - attempts to solve `equations` for the variables `vars`. */
	public final static IBuiltInSymbol NSolve = initFinalSymbol("NSolve", ID.NSolve);
	/** NakagamiDistribution(m, o) - returns a Nakagami distribution. */
	public final static IBuiltInSymbol NakagamiDistribution = initFinalSymbol("NakagamiDistribution",
			ID.NakagamiDistribution);
	/***/
	public final static IBuiltInSymbol Names = initFinalSymbol("Names", ID.Names);
	/**
	 * Nand(arg1, arg2, ...)' - Logical NAND function. It evaluates its arguments in order, giving `True` immediately if
	 * any of them are `False`, and `False` if they are all `True`.
	 */
	public final static IBuiltInSymbol Nand = initFinalSymbol("Nand", ID.Nand);
	/***/
	public final static IBuiltInSymbol Nearest = initFinalSymbol("Nearest", ID.Nearest);
	/** Negative(x) - returns `True` if `x` is a negative real number. */
	public final static IBuiltInSymbol Negative = initFinalSymbol("Negative", ID.Negative);
	/***/
	public final static IBuiltInSymbol NegativeDegreeLexicographic = initFinalSymbol("NegativeDegreeLexicographic", ID.NegativeDegreeLexicographic);

	/***/
	public final static IBuiltInSymbol NegativeDegreeReverseLexicographic = initFinalSymbol("NegativeDegreeReverseLexicographic", ID.NegativeDegreeReverseLexicographic);

	/***/
	public final static IBuiltInSymbol NegativeLexicographic = initFinalSymbol("NegativeLexicographic", ID.NegativeLexicographic);

	/** Nest(f, expr, n) - starting with `expr`, iteratively applies `f` `n` times and returns the final result. */
	public final static IBuiltInSymbol Nest = initFinalSymbol("Nest", ID.Nest);
	/**
	 * NestList(f, expr, n) - starting with `expr`, iteratively applies `f` `n` times and returns a list of all
	 * intermediate results.
	 */
	public final static IBuiltInSymbol NestList = initFinalSymbol("NestList", ID.NestList);
	/**
	 * NestWhile(f, expr, test) - applies a function `f` repeatedly on an expression `expr`, until applying `test` on
	 * the result no longer yields `True`.
	 */
	public final static IBuiltInSymbol NestWhile = initFinalSymbol("NestWhile", ID.NestWhile);
	/**
	 * NestWhileList(f, expr, test) - applies a function `f` repeatedly on an expression `expr`, until applying `test`
	 * on the result no longer yields `True`. It returns a list of all intermediate results.
	 */
	public final static IBuiltInSymbol NestWhileList = initFinalSymbol("NestWhileList", ID.NestWhileList);
	/** NextPrime(n) - gives the next prime after `n`. */
	public final static IBuiltInSymbol NextPrime = initFinalSymbol("NextPrime", ID.NextPrime);
	/***/
	public final static IBuiltInSymbol NonCommutativeMultiply = initFinalSymbol("NonCommutativeMultiply",
			ID.NonCommutativeMultiply);
	/** NonNegative(x) - returns `True` if `x` is a positive real number or zero. */
	public final static IBuiltInSymbol NonNegative = initFinalSymbol("NonNegative", ID.NonNegative);
	/** NonPositive(x) - returns `True` if `x` is a negative real number or zero. */
	public final static IBuiltInSymbol NonPositive = initFinalSymbol("NonPositive", ID.NonPositive);
	/** None - is a possible value for `Span` and `Quiet`. */
	public final static IBuiltInSymbol None = initFinalSymbol("None", ID.None);
	/**
	 * NoneTrue({expr1, expr2, ...}, test) - returns `True` if no application of `test` to `expr1, expr2, ...` evaluates
	 * to `True`.
	 */
	public final static IBuiltInSymbol NoneTrue = initFinalSymbol("NoneTrue", ID.NoneTrue);
	/***/
	public final static IBuiltInSymbol Nonexistent = initFinalSymbol("Nonexistent", ID.Nonexistent);
	/**
	 * Nor(arg1, arg2, ...)' - Logical NOR function. It evaluates its arguments in order, giving `False` immediately if
	 * any of them are `True`, and `True` if they are all `False`.
	 */
	public final static IBuiltInSymbol Nor = initFinalSymbol("Nor", ID.Nor);
	/** Norm(m, l) - computes the `l`-norm of matrix `m` (currently only works for vectors!). */
	public final static IBuiltInSymbol Norm = initFinalSymbol("Norm", ID.Norm);
	/** Normal(expr) - converts a special Symja expression `expr` into a standard expression. */
	public final static IBuiltInSymbol Normal = initFinalSymbol("Normal", ID.Normal);
	/** NormalDistribution(m, s) - returns the normal distribution of mean `m` and sigma `s`. */
	public final static IBuiltInSymbol NormalDistribution = initFinalSymbol("NormalDistribution",
			ID.NormalDistribution);
	/** Normalize(v) - calculates the normalized vector `v` as `v/Norm(v)`. */
	public final static IBuiltInSymbol Normalize = initFinalSymbol("Normalize", ID.Normalize);
	/**
	 * Not(expr) - Logical Not function (negation). Returns `True` if the statement is `False`. Returns `False` if the
	 * `expr` is `True`
	 */
	public final static IBuiltInSymbol Not = initFinalSymbol("Not", ID.Not);
	/***/
	public final static IBuiltInSymbol NotApplicable = initFinalSymbol("NotApplicable", ID.NotApplicable);
	/***/
	public final static IBuiltInSymbol NotAvailable = initFinalSymbol("NotAvailable", ID.NotAvailable);
	/***/
	public final static IBuiltInSymbol NotElement = initFinalSymbol("NotElement", ID.NotElement);
	/***/
	public final static IBuiltInSymbol NotListQ = initFinalSymbol("NotListQ", ID.NotListQ);
	/***/
	public final static IBuiltInSymbol Nothing = initFinalSymbol("Nothing", ID.Nothing);

	/***/
	public final static IBuiltInSymbol Now = initFinalSymbol("Now", ID.Now);

	/** Null - is the implicit result of expressions that do not yield a result. */
	public final static IBuiltInSymbol Null = initFinalSymbol("Null", ID.Null);
	/** NullSpace(matrix) - returns a list of vectors that span the nullspace of the `matrix`. */
	public final static IBuiltInSymbol NullSpace = initFinalSymbol("NullSpace", ID.NullSpace);
	/***/
	public final static IBuiltInSymbol Number = initFinalSymbol("Number", ID.Number);

	/***/
	public final static IBuiltInSymbol NumberFieldRootsOfUnity = initFinalSymbol("NumberFieldRootsOfUnity", ID.NumberFieldRootsOfUnity);

	/** NumberQ(expr) - returns `True` if `expr` is an explicit number, and `False` otherwise. */
	public final static IBuiltInSymbol NumberQ = initFinalSymbol("NumberQ", ID.NumberQ);
	/***/
	public final static IBuiltInSymbol NumberString = initFinalSymbol("NumberString", ID.NumberString);
	/** Numerator(expr) - gives the numerator in `expr`. Numerator collects expressions with non negative exponents. */
	public final static IBuiltInSymbol Numerator = initFinalSymbol("Numerator", ID.Numerator);
	/***/
	public final static IBuiltInSymbol NumericFunction = initFinalSymbol("NumericFunction", ID.NumericFunction);
	/** NumericQ(expr) - returns `True` if `expr` is an explicit numeric expression, and `False` otherwise. */
	public final static IBuiltInSymbol NumericQ = initFinalSymbol("NumericQ", ID.NumericQ);
	/***/
	public final static IBuiltInSymbol NuttallWindow = initFinalSymbol("NuttallWindow", ID.NuttallWindow);
	/***/
	public final static IBuiltInSymbol O = initFinalSymbol("O", ID.O);
	/** OddQ(x) - returns `True` if `x` is odd, and `False` otherwise. */
	public final static IBuiltInSymbol OddQ = initFinalSymbol("OddQ", ID.OddQ);
	/** Off( ) - switch off the interactive trace. */
	public final static IBuiltInSymbol Off = initFinalSymbol("Off", ID.Off);
	/** On( ) - switch on the interactive trace. The output is printed in the defined `out` stream. */
	public final static IBuiltInSymbol On = initFinalSymbol("On", ID.On);
	/**
	 * OneIdentity - is an attribute specifying that `f(x)` should be treated as equivalent to `x` in pattern matching.
	 */
	public final static IBuiltInSymbol OneIdentity = initFinalSymbol("OneIdentity", ID.OneIdentity);
	/** Operate(p, expr) - applies `p` to the head of `expr`. */
	public final static IBuiltInSymbol Operate = initFinalSymbol("Operate", ID.Operate);
	/**
	 * OptimizeExpression(function) - common subexpressions elimination for a complicated `function` by generating
	 * "dummy" variables for these subexpressions.
	 */
	public final static IBuiltInSymbol OptimizeExpression = initFinalSymbol("OptimizeExpression",
			ID.OptimizeExpression);
	/***/
	public final static IBuiltInSymbol OptionValue = initFinalSymbol("OptionValue", ID.OptionValue);
	/**
	 * Optional(patt, default) - is a pattern which matches `patt`, which if omitted should be replaced by `default`.
	 */
	public final static IBuiltInSymbol Optional = initFinalSymbol("Optional", ID.Optional);
	/***/
	public final static IBuiltInSymbol Options = initFinalSymbol("Options", ID.Options);
	/***/
	public final static IBuiltInSymbol OptionsPattern = initFinalSymbol("OptionsPattern", ID.OptionsPattern);
	/**
	 * Or(expr1, expr2, ...)' - `expr1 || expr2 || ...` evaluates each expression in turn, returning `True` as soon as
	 * an expression evaluates to `True`. If all expressions evaluate to `False`, `Or` returns `False`.
	 */
	public final static IBuiltInSymbol Or = initFinalSymbol("Or", ID.Or);
	/***/
	public final static IBuiltInSymbol Orange = initFinalSymbol("Orange", ID.Orange);
	/** Order(a, b) - is `0` if `a` equals `b`. Is `-1` or `1` according to canonical order of `a` and `b`. */
	public final static IBuiltInSymbol Order = initFinalSymbol("Order", ID.Order);
	/** OrderedQ({a, b}) - is `True` if `a` sorts before `b` according to canonical ordering. */
	public final static IBuiltInSymbol OrderedQ = initFinalSymbol("OrderedQ", ID.OrderedQ);
	/** Ordering(list) - calculate the permutation list of the elements in the sorted `list`. */
	public final static IBuiltInSymbol Ordering = initFinalSymbol("Ordering", ID.Ordering);
	/**
	 * Orderless - is an attribute indicating that the leaves in an expression `f(a, b, c)` can be placed in any order.
	 */
	public final static IBuiltInSymbol Orderless = initFinalSymbol("Orderless", ID.Orderless);
	/** OrthogonalMatrixQ(matrix) - returns `True`, if `matrix` is an orthogonal matrix. `False` otherwise. */
	public final static IBuiltInSymbol OrthogonalMatrixQ = initFinalSymbol("OrthogonalMatrixQ", ID.OrthogonalMatrixQ);
	/** Orthogonalize(matrix) - returns a basis for the orthogonalized set of vectors defined by `matrix`. */
	public final static IBuiltInSymbol Orthogonalize = initFinalSymbol("Orthogonalize", ID.Orthogonalize);
	/***/
	public final static IBuiltInSymbol Out = initFinalSymbol("Out", ID.Out);
	/**
	 * Outer(f, x, y) - computes a generalised outer product of `x` and `y`, using the function `f` in place of
	 * multiplication.
	 */
	public final static IBuiltInSymbol Outer = initFinalSymbol("Outer", ID.Outer);
	/***/
	public final static IBuiltInSymbol OutputForm = initFinalSymbol("OutputForm", ID.OutputForm);
	/***/
	public final static IBuiltInSymbol OutputStream = initFinalSymbol("OutputStream", ID.OutputStream);
	/***/
	public final static IBuiltInSymbol OwnValues = initFinalSymbol("OwnValues", ID.OwnValues);
	/** PDF(distribution, value) - returns the probability density function of `value`. */
	public final static IBuiltInSymbol PDF = initFinalSymbol("PDF", ID.PDF);
	/***/
	public final static IBuiltInSymbol Package = initFinalSymbol("Package", ID.Package);
	/** PadLeft(list, n) - pads `list` to length `n` by adding `0` on the left. */
	public final static IBuiltInSymbol PadLeft = initFinalSymbol("PadLeft", ID.PadLeft);
	/** PadRight(list, n) - pads `list` to length `n` by adding `0` on the right. */
	public final static IBuiltInSymbol PadRight = initFinalSymbol("PadRight", ID.PadRight);
	/**
	 * ParametricPlot({function1, function2}, {t, tMin, tMax}) - generate a JavaScript control for the parametric
	 * expressions `function1`, `function2` in the `t` range `{t, tMin, tMax}`.
	 */
	public final static IBuiltInSymbol ParametricPlot = initFinalSymbol("ParametricPlot", ID.ParametricPlot);
	/** Part(expr, i) - returns part `i` of `expr`. */
	public final static IBuiltInSymbol Part = initFinalSymbol("Part", ID.Part);
	/** Partition(list, n) - partitions `list` into sublists of length `n`. */
	public final static IBuiltInSymbol Partition = initFinalSymbol("Partition", ID.Partition);
	/** PartitionsP(n) - gives the number of unrestricted partitions of the integer `n`. */
	public final static IBuiltInSymbol PartitionsP = initFinalSymbol("PartitionsP", ID.PartitionsP);
	/** PartitionsQ(n) - gives the number of partitions of the integer `n` into distinct parts */
	public final static IBuiltInSymbol PartitionsQ = initFinalSymbol("PartitionsQ", ID.PartitionsQ);
	/***/
	public final static IBuiltInSymbol ParzenWindow = initFinalSymbol("ParzenWindow", ID.ParzenWindow);
	/***/
	public final static IBuiltInSymbol Pattern = initFinalSymbol("Pattern", ID.Pattern);
	/***/
	public final static IBuiltInSymbol PatternOrder = initFinalSymbol("PatternOrder", ID.PatternOrder);
	/**
	 * PatternTest(pattern, test) - constrains `pattern` to match `expr` only if the evaluation of `test(expr)` yields
	 * `True`.
	 */
	public final static IBuiltInSymbol PatternTest = initFinalSymbol("PatternTest", ID.PatternTest);
	/***/
	public final static IBuiltInSymbol Pause = initFinalSymbol("Pause", ID.Pause);
	/***/
	public final static IBuiltInSymbol PearsonChiSquareTest = initFinalSymbol("PearsonChiSquareTest", ID.PearsonChiSquareTest);
	/**
	 * PerfectNumber(n) - returns the `n`th perfect number. In number theory, a perfect number is a positive integer
	 * that is equal to the sum of its proper
	 */
	public final static IBuiltInSymbol PerfectNumber = initFinalSymbol("PerfectNumber", ID.PerfectNumber);
	/**
	 * PerfectNumberQ(n) - returns `True` if `n` is a perfect number. In number theory, a perfect number is a positive
	 * integer that is equal to the sum of its proper
	 */
	public final static IBuiltInSymbol PerfectNumberQ = initFinalSymbol("PerfectNumberQ", ID.PerfectNumberQ);
	/** Permutations(list) - gives all possible orderings of the items in `list`. */
	public final static IBuiltInSymbol Permutations = initFinalSymbol("Permutations", ID.Permutations);
	/** Pi - is the constant `Pi`. */
	public final static IBuiltInSymbol Pi = initFinalSymbol("Pi", ID.Pi);
	/** PieChart(list-of-values) - plot a pie chart from a `list-of-values`. */
	public final static IBuiltInSymbol PieChart = initFinalSymbol("PieChart", ID.PieChart);
	/** Piecewise({{expr1, cond1}, ...}) - represents a piecewise function. */
	public final static IBuiltInSymbol Piecewise = initFinalSymbol("Piecewise", ID.Piecewise);
	/**
	 * PiecewiseExpand(function) - expands piecewise expressions into a `Piecewise` function. Currently only `Abs, Clip,
	 * If, Ramp, UnitStep` are converted to Piecewise expressions.
	 */
	public final static IBuiltInSymbol PiecewiseExpand = initFinalSymbol("PiecewiseExpand", ID.PiecewiseExpand);

	/***/
	public final static IBuiltInSymbol Pink = F.initFinalSymbol("Pink", ID.Pink);
	/**
	 * Plot(function, {x, xMin, xMax}, PlotRange->{yMin,yMax}) - generate a JavaScript control for the expression
	 * `function` in the `x` range `{x, xMin, xMax}` and `{yMin, yMax}` in the `y` range.
	 */
	public final static IBuiltInSymbol Plot = initFinalSymbol("Plot", ID.Plot);
	/**
	 * Plot3D(function, {x, xMin, xMax}, {y,yMin,yMax}) - generate a JavaScript control for the expression `function` in
	 * the `x` range `{x, xMin, xMax}` and `{yMin, yMax}` in the `y` range.
	 */
	public final static IBuiltInSymbol Plot3D = initFinalSymbol("Plot3D", ID.Plot3D);
	/***/
	public final static IBuiltInSymbol PlotRange = initFinalSymbol("PlotRange", ID.PlotRange);
	/***/
	public final static IBuiltInSymbol PlotStyle = initFinalSymbol("PlotStyle", ID.PlotStyle);
	/** Plus(a, b, ...) - represents the sum of the terms `a, b, ...`. */
	public final static IBuiltInSymbol Plus = initFinalSymbol("Plus", ID.Plus);
	/** Pochhammer(a, n) - returns the pochhammer symbol for a rational number `a` and an integer number `n`. */
	public final static IBuiltInSymbol Pochhammer = initFinalSymbol("Pochhammer", ID.Pochhammer);
	/***/
	public final static IBuiltInSymbol Point = initFinalSymbol("Point", ID.Point);
	/** PoissonDistribution(m) - returns a Poisson distribution. */
	public final static IBuiltInSymbol PoissonDistribution = initFinalSymbol("PoissonDistribution",
			ID.PoissonDistribution);
	/**
	 * PolarPlot(function, {t, tMin, tMax}) - generate a JavaScript control for the polar plot expressions `function` in
	 * the `t` range `{t, tMin, tMax}`.
	 */
	public final static IBuiltInSymbol PolarPlot = initFinalSymbol("PolarPlot", ID.PolarPlot);
	/**
	 * PolyGamma(value) - return the digamma function of the `value`. The digamma function is defined as the logarithmic
	 * derivative of the gamma function.
	 */
	public final static IBuiltInSymbol PolyGamma = initFinalSymbol("PolyGamma", ID.PolyGamma);
	/***/
	public final static IBuiltInSymbol PolyLog = initFinalSymbol("PolyLog", ID.PolyLog);
	/***/
	public final static IBuiltInSymbol Polygon = initFinalSymbol("Polygon", ID.Polygon);
	/**
	 * PolynomialExtendedGCD(p, q, x) - returns the extended GCD ('greatest common divisor') of the univariate
	 * polynomials `p` and `q`.
	 */
	public final static IBuiltInSymbol PolynomialExtendedGCD = initFinalSymbol("PolynomialExtendedGCD",
			ID.PolynomialExtendedGCD);
	/** PolynomialGCD(p, q) - returns the GCD ('greatest common divisor') of the polynomials `p` and `q`. */
	public final static IBuiltInSymbol PolynomialGCD = initFinalSymbol("PolynomialGCD", ID.PolynomialGCD);
	/** PolynomialLCM(p, q) - returns the LCM ('least common multiple') of the polynomials `p` and `q`. */
	public final static IBuiltInSymbol PolynomialLCM = initFinalSymbol("PolynomialLCM", ID.PolynomialLCM);
	/**
	 * PolynomialQ(p, x) - return `True` if `p` is a polynomial for the variable `x`. Return `False` in all other cases.
	 */
	public final static IBuiltInSymbol PolynomialQ = initFinalSymbol("PolynomialQ", ID.PolynomialQ);
	/**
	 * PolynomialQuotient(p, q, x) - returns the polynomial quotient of the polynomials `p` and `q` for the variable
	 * `x`.
	 */
	public final static IBuiltInSymbol PolynomialQuotient = initFinalSymbol("PolynomialQuotient",
			ID.PolynomialQuotient);
	/**
	 * PolynomialQuotientRemainder(p, q, x) - returns a list with the polynomial quotient and remainder of the
	 * polynomials `p` and `q` for the variable `x`.
	 */
	public final static IBuiltInSymbol PolynomialQuotientRemainder = initFinalSymbol("PolynomialQuotientRemainder",
			ID.PolynomialQuotientRemainder);
	/**
	 * PolynomialQuotient(p, q, x) - returns the polynomial remainder of the polynomials `p` and `q` for the variable
	 * `x`.
	 */
	public final static IBuiltInSymbol PolynomialRemainder = initFinalSymbol("PolynomialRemainder",
			ID.PolynomialRemainder);
	/** Position(expr, patt) - returns the list of positions for which `expr` matches `patt`. */
	public final static IBuiltInSymbol Position = initFinalSymbol("Position", ID.Position);
	/** Positive(x) - returns `True` if `x` is a positive real number. */
	public final static IBuiltInSymbol Positive = initFinalSymbol("Positive", ID.Positive);
	/** PossibleZeroQ(expr) - maps a (possible) zero `expr` to `True` and returns `False` otherwise. */
	public final static IBuiltInSymbol PossibleZeroQ = initFinalSymbol("PossibleZeroQ", ID.PossibleZeroQ);
	/***/
	public final static IBuiltInSymbol Postefix = initFinalSymbol("Postefix", ID.Postefix);

	/** Power(a, b) - represents `a` raised to the power of `b`. */
	public final static IBuiltInSymbol Power = initFinalSymbol("Power", ID.Power);
	/** PowerExpand(expr) - expands out powers of the form `(x^y)^z` and `(x*y)^z` in `expr`. */
	public final static IBuiltInSymbol PowerExpand = initFinalSymbol("PowerExpand", ID.PowerExpand);
	/** PowerMod(x, y, m) - computes `x^y` modulo `m`. */
	public final static IBuiltInSymbol PowerMod = initFinalSymbol("PowerMod", ID.PowerMod);
	/** PreDecrement(x) - decrements `x` by `1`, returning the new value of `x`. */
	public final static IBuiltInSymbol PreDecrement = initFinalSymbol("PreDecrement", ID.PreDecrement);
	/** PreIncrement(x) - increments `x` by `1`, returning the new value of `x`. */
	public final static IBuiltInSymbol PreIncrement = initFinalSymbol("PreIncrement", ID.PreIncrement);
	/***/
	public final static IBuiltInSymbol Precision = initFinalSymbol("Precision", ID.Precision);
	/***/
	public final static IBuiltInSymbol PrecisionGoal = initFinalSymbol("PrecisionGoal", ID.PrecisionGoal);
	/***/
	public final static IBuiltInSymbol Prefix = initFinalSymbol("Prefix", ID.Prefix);

	/** Prepend(expr, item) - returns `expr` with `item` prepended to its leaves. */
	public final static IBuiltInSymbol Prepend = initFinalSymbol("Prepend", ID.Prepend);
	/** PrependTo(s, item) - prepend `item` to value of `s` and sets `s` to the result. */
	public final static IBuiltInSymbol PrependTo = initFinalSymbol("PrependTo", ID.PrependTo);
	/** Prime(n) - returns the `n`th prime number. */
	public final static IBuiltInSymbol Prime = initFinalSymbol("Prime", ID.Prime);
	/** PrimeOmega(n) - returns the sum of the exponents of the prime factorization of `n`. */
	public final static IBuiltInSymbol PrimeOmega = initFinalSymbol("PrimeOmega", ID.PrimeOmega);
	/** PrimePi(x) - gives the number of primes less than or equal to `x`. */
	public final static IBuiltInSymbol PrimePi = initFinalSymbol("PrimePi", ID.PrimePi);
	/** PrimePowerQ(n) - returns `True` if `n` is a power of a prime number. */
	public final static IBuiltInSymbol PrimePowerQ = initFinalSymbol("PrimePowerQ", ID.PrimePowerQ);
	/** PrimeQ(n) - returns `True` if `n` is a integer prime number. */
	public final static IBuiltInSymbol PrimeQ = initFinalSymbol("PrimeQ", ID.PrimeQ);
	/***/
	public final static IBuiltInSymbol Primes = initFinalSymbol("Primes", ID.Primes);
	/***/
	public final static IBuiltInSymbol PrimitiveRoot = initFinalSymbol("PrimitiveRoot", ID.PrimitiveRoot);
	/** PrimitiveRootList(n) - returns the list of the primitive roots of `n`. */
	public final static IBuiltInSymbol PrimitiveRootList = initFinalSymbol("PrimitiveRootList", ID.PrimitiveRootList);
	/** Print(expr) - print the `expr` to the default output stream and return `Null`. */
	public final static IBuiltInSymbol Print = initFinalSymbol("Print", ID.Print);
	/***/
	public final static IBuiltInSymbol PrintableASCIIQ = initFinalSymbol("PrintableASCIIQ", ID.PrintableASCIIQ);
	/**
	 * Probability(pure-function, data-set) - returns the probability of the `pure-function` for the given `data-set`.
	 */
	public final static IBuiltInSymbol Probability = initFinalSymbol("Probability", ID.Probability);
	/**
	 * Product(expr, {i, imin, imax}) - evaluates the discrete product of `expr` with `i` ranging from `imin` to `imax`.
	 */
	public final static IBuiltInSymbol Product = initFinalSymbol("Product", ID.Product);
	/** ProductLog(z) - returns the value of the Lambert W function at `z`. */
	public final static IBuiltInSymbol ProductLog = initFinalSymbol("ProductLog", ID.ProductLog);
	/** Projection(vector1, vector2) - Find the orthogonal projection of `vector1` onto another `vector2`. */
	public final static IBuiltInSymbol Projection = initFinalSymbol("Projection", ID.Projection);
	/***/
	public final static IBuiltInSymbol Protect = initFinalSymbol("Protect", ID.Protect);
	/***/
	public final static IBuiltInSymbol Protected = initFinalSymbol("Protected", ID.Protected);
	/**
	 * PseudoInverse(matrix) - computes the Moore-Penrose pseudoinverse of the `matrix`. If `matrix` is invertible, the
	 * pseudoinverse equals the inverse.
	 */
	public final static IBuiltInSymbol PseudoInverse = initFinalSymbol("PseudoInverse", ID.PseudoInverse);
	/***/
	public final static IBuiltInSymbol Purple = initFinalSymbol("Purple", ID.Purple);
	/***/
	public final static IBuiltInSymbol Put = initFinalSymbol("Put", ID.Put);
	/**
	 * QRDecomposition(A) - computes the QR decomposition of the matrix `A`. The QR decomposition is a decomposition of
	 * a matrix `A` into a product `A = Q.R` of an unitary matrix `Q` and an upper triangular matrix `R`.
	 */
	public final static IBuiltInSymbol QRDecomposition = initFinalSymbol("QRDecomposition", ID.QRDecomposition);
	/** Quantile(list, q) - returns the `q`-Quantile of `list`. */
	public final static IBuiltInSymbol Quantile = initFinalSymbol("Quantile", ID.Quantile);
	/** Quantity(value, unit) - returns the quantity for `value` and `unit` */
	public final static IBuiltInSymbol Quantity = initFinalSymbol("Quantity", ID.Quantity);
	/***/
	public final static IBuiltInSymbol QuantityDistribution = initFinalSymbol("QuantityDistribution",
			ID.QuantityDistribution);
	/** QuantityMagnitude(quantity) - returns the value of the `quantity` */
	public final static IBuiltInSymbol QuantityMagnitude = initFinalSymbol("QuantityMagnitude", ID.QuantityMagnitude);
	/***/
	public final static IBuiltInSymbol QuantityQ = initFinalSymbol("QuantityQ", ID.QuantityQ);
	/** Quartiles(arg) - returns a list of the `1/4`, `1/2` and `3/4` quantile of `arg`. */
	public final static IBuiltInSymbol Quartiles = initFinalSymbol("Quartiles", ID.Quartiles);
	/** Quiet(expr) - evaluates `expr` in "quiet" mode (i.e. no warning messages are shown during evaluation). */
	public final static IBuiltInSymbol Quiet = initFinalSymbol("Quiet", ID.Quiet);
	/***/
	public final static IBuiltInSymbol Quit = initFinalSymbol("Quit", ID.Quit);
	/** Quotient(m, n) - computes the integer quotient of `m` and `n`. */
	public final static IBuiltInSymbol Quotient = initFinalSymbol("Quotient", ID.Quotient);
	/** QuotientRemainder(m, n) - computes a list of the quotient and remainder from division of `m` and `n`. */
	public final static IBuiltInSymbol QuotientRemainder = initFinalSymbol("QuotientRemainder", ID.QuotientRemainder);
	/***/
	public final static IBuiltInSymbol RGBColor = initFinalSymbol("RGBColor", ID.RGBColor);

	/** Ramp(z) - The `Ramp` function is a unary real function, whose graph is shaped like a ramp. */
	public final static IBuiltInSymbol Ramp = initFinalSymbol("Ramp", ID.Ramp);
	/** RandomChoice({arg1, arg2, arg3,...}) - chooses a random `arg` from the list. */
	public final static IBuiltInSymbol RandomChoice = initFinalSymbol("RandomChoice", ID.RandomChoice);
	/***/
	public final static IBuiltInSymbol RandomComplex = initFinalSymbol("RandomComplex", ID.RandomComplex);
	/** RandomInteger(n) - create a random integer number between `0` and `n`. */
	public final static IBuiltInSymbol RandomInteger = initFinalSymbol("RandomInteger", ID.RandomInteger);
	/** RandomPrime(n) - create a random prime integer number between `2` and `n`. */
	public final static IBuiltInSymbol RandomPrime = initFinalSymbol("RandomPrime", ID.RandomPrime);
	/** RandomReal() - create a random number between `0.0` and `1.0`. */
	public final static IBuiltInSymbol RandomReal = initFinalSymbol("RandomReal", ID.RandomReal);
	/** RandomSample(<function>) - create a random sample for the arguments of the `function`. */
	public final static IBuiltInSymbol RandomSample = initFinalSymbol("RandomSample", ID.RandomSample);
	/***/
	public final static IBuiltInSymbol RandomVariate = initFinalSymbol("RandomVariate", ID.RandomVariate);
	/** Range(n) - returns a list of integers from `1` to `n`. */
	public final static IBuiltInSymbol Range = initFinalSymbol("Range", ID.Range);
	/** Rational - is the head of rational numbers. */
	public final static IBuiltInSymbol Rational = initFinalSymbol("Rational", ID.Rational);
	/**
	 * Rationalize(expression) - convert numerical real or imaginary parts in (sub-)expressions into rational numbers.
	 */
	public final static IBuiltInSymbol Rationalize = initFinalSymbol("Rationalize", ID.Rationalize);
	/***/
	public final static IBuiltInSymbol Rationals = initFinalSymbol("Rationals", ID.Rationals);
	/** Re(z) - returns the real component of the complex number `z`. */
	public final static IBuiltInSymbol Re = initFinalSymbol("Re", ID.Re);
	/***/
	public final static IBuiltInSymbol ReadProtected = initFinalSymbol("ReadProtected", ID.ReadProtected);
	/***/
	public final static IBuiltInSymbol ReadString = initFinalSymbol("ReadString", ID.ReadString);
	/** Real - is the head of real (floating point) numbers. */
	public final static IBuiltInSymbol Real = initFinalSymbol("Real", ID.Real);
	/***/
	public final static IBuiltInSymbol RealDigits = initFinalSymbol("RealDigits", ID.RealDigits);
	/** RealNumberQ(expr) - returns `True` if `expr` is an explicit number with no imaginary component. */
	public final static IBuiltInSymbol RealNumberQ = initFinalSymbol("RealNumberQ", ID.RealNumberQ);
	/** Reals - is the set of real numbers. */
	public final static IBuiltInSymbol Reals = initFinalSymbol("Reals", ID.Reals);
	/**
	 * Reap(expr) - gives the result of evaluating `expr`, together with all values sown during this evaluation. Values
	 * sown with different tags are given in different lists.
	 */
	public final static IBuiltInSymbol Reap = initFinalSymbol("Reap", ID.Reap);
	/***/
	public final static IBuiltInSymbol Rectangle = initFinalSymbol("Rectangle", ID.Rectangle);
	/***/
	public final static IBuiltInSymbol Red = initFinalSymbol("Red", ID.Red);
	/***/
	public final static IBuiltInSymbol Reduce = initFinalSymbol("Reduce", ID.Reduce);
	/** Refine(expression, assumptions) - evaluate the `expression` for the given `assumptions`. */
	public final static IBuiltInSymbol Refine = initFinalSymbol("Refine", ID.Refine);
	/***/
	public final static IBuiltInSymbol RegularExpression = initFinalSymbol("RegularExpression", ID.RegularExpression);
	/***/
	public final static IBuiltInSymbol Remove = initFinalSymbol("Remove", ID.Remove);
	/***/
	public final static IBuiltInSymbol RemoveDiacritics = initFinalSymbol("RemoveDiacritics", ID.RemoveDiacritics);
	/***/
	public final static IBuiltInSymbol Repeated = initFinalSymbol("Repeated", ID.Repeated);
	/***/
	public final static IBuiltInSymbol RepeatedNull = initFinalSymbol("RepeatedNull", ID.RepeatedNull);
	/**
	 * Replace(expr, lhs -> rhs) - replaces the left-hand-side pattern expression `lhs` in `expr` with the
	 * right-hand-side `rhs`.
	 */
	public final static IBuiltInSymbol Replace = initFinalSymbol("Replace", ID.Replace);
	/** ReplaceAll(expr, i -> new) - replaces all `i` in `expr` with `new`. */
	public final static IBuiltInSymbol ReplaceAll = initFinalSymbol("ReplaceAll", ID.ReplaceAll);
	/**
	 * ReplaceList(expr, lhs -> rhs) - replaces the left-hand-side pattern expression `lhs` in `expr` with the
	 * right-hand-side `rhs`.
	 */
	public final static IBuiltInSymbol ReplaceList = initFinalSymbol("ReplaceList", ID.ReplaceList);
	/** ReplacePart(expr, i -> new) - replaces part `i` in `expr` with `new`. */
	public final static IBuiltInSymbol ReplacePart = initFinalSymbol("ReplacePart", ID.ReplacePart);
	/**
	 * ReplaceRepeated(expr, lhs -> rhs) - repeatedly applies the rule `lhs -> rhs` to `expr` until the result no longer
	 * changes.
	 */
	public final static IBuiltInSymbol ReplaceRepeated = initFinalSymbol("ReplaceRepeated", ID.ReplaceRepeated);
	/** Rescale(list) - returns `Rescale(list,{Min(list), Max(list)})`. */
	public final static IBuiltInSymbol Rescale = initFinalSymbol("Rescale", ID.Rescale);
	/** Rest(expr) - returns `expr` with the first element removed. */
	public final static IBuiltInSymbol Rest = initFinalSymbol("Rest", ID.Rest);
	/**
	 * Resultant(polynomial1, polynomial2, var) - computes the resultant of the polynomials `polynomial1` and
	 * `polynomial2` with respect to the variable `var`.
	 */
	public final static IBuiltInSymbol Resultant = initFinalSymbol("Resultant", ID.Resultant);
	/** Return(expr) - aborts a function call and returns `expr`. */
	public final static IBuiltInSymbol Return = initFinalSymbol("Return", ID.Return);
	/** Reverse(list) - reverse the elements of the `list`. */
	public final static IBuiltInSymbol Reverse = initFinalSymbol("Reverse", ID.Reverse);
	/**
	 * RiccatiSolve({A,B},{Q,R}) - An algebraic Riccati equation is a type of nonlinear equation that arises in the
	 * context of infinite-horizon optimal control problems in continuous time or discrete time. The continuous time
	 * algebraic Riccati equation (CARE): `A^{T}·X+X·A-X·B·R^{-1}·B^{T}·X+Q==0`. And the respective linear controller
	 * is: `K = R^{-1}·B^{T}·P`. The solver receives `A`, `B`, `Q` and `R` and computes `P`.
	 */
	public final static IBuiltInSymbol RiccatiSolve = initFinalSymbol("RiccatiSolve", ID.RiccatiSolve);
	/** Riffle(list1, list2) - insert elements of `list2` between the elements of `list1`. */
	public final static IBuiltInSymbol Riffle = initFinalSymbol("Riffle", ID.Riffle);
	/***/
	public final static IBuiltInSymbol Right = initFinalSymbol("Right", ID.Right);
	/**
	 * RogersTanimotoDissimilarity(u, v) - returns the Rogers-Tanimoto dissimilarity between the two boolean 1-D lists
	 * `u` and `v`, which is defined as `R / (c_tt + c_ff + R)` where n is `len(u)`, `c_ij` is the number of occurrences
	 * of `u(k)=i` and `v(k)=j` for `k<n`, and `R = 2 * (c_tf + c_ft)`.
	 */
	public final static IBuiltInSymbol RogersTanimotoDissimilarity = initFinalSymbol("RogersTanimotoDissimilarity",
			ID.RogersTanimotoDissimilarity);

	/** RomanNumeral(positive-int-value) - converts the given `positive-int-value` to a roman numeral string. */
	public final static IBuiltInSymbol RomanNumeral = initFinalSymbol("RomanNumeral", ID.RomanNumeral);

	/***/
	public final static IBuiltInSymbol Root = initFinalSymbol("Root", ID.Root);
	/***/
	public final static IBuiltInSymbol RootIntervals = initFinalSymbol("RootIntervals", ID.RootIntervals);
	/***/
	public final static IBuiltInSymbol RootOf = initFinalSymbol("RootOf", ID.RootOf);
	/**
	 * Roots(polynomial-equation, var) - determine the roots of a univariate polynomial equation with respect to the
	 * variable `var`.
	 */
	public final static IBuiltInSymbol Roots = initFinalSymbol("Roots", ID.Roots);
	/** RotateLeft(list) - rotates the items of `list` by one item to the left. */
	public final static IBuiltInSymbol RotateLeft = initFinalSymbol("RotateLeft", ID.RotateLeft);
	/** RotateRight(list) - rotates the items of `list` by one item to the right. */
	public final static IBuiltInSymbol RotateRight = initFinalSymbol("RotateRight", ID.RotateRight);
	/** RotationMatrix(theta) - yields a rotation matrix for the angle `theta`. */
	public final static IBuiltInSymbol RotationMatrix = initFinalSymbol("RotationMatrix", ID.RotationMatrix);
	/** Round(expr) - round a given `expr` to nearest integer. */
	public final static IBuiltInSymbol Round = initFinalSymbol("Round", ID.Round);

	/***/
	public final static IBuiltInSymbol Row = initFinalSymbol("Row", ID.Row);
	/** RowReduce(matrix) - returns the reduced row-echelon form of `matrix`. */
	public final static IBuiltInSymbol RowReduce = initFinalSymbol("RowReduce", ID.RowReduce);
	/** Rule(x, y) - represents a rule replacing `x` with `y`. */
	public final static IBuiltInSymbol Rule = initFinalSymbol("Rule", ID.Rule);
	/** RuleDelayed(x, y) - represents a rule replacing `x` with `y`, with `y` held unevaluated. */
	public final static IBuiltInSymbol RuleDelayed = initFinalSymbol("RuleDelayed", ID.RuleDelayed);
	/**
	 * RussellRaoDissimilarity(u, v) - returns the Russell-Rao dissimilarity between the two boolean 1-D lists `u` and
	 * `v`, which is defined as `(n - c_tt) / c_tt` where `n` is `len(u)` and `c_ij` is the number of occurrences of
	 * `u(k)=i` and `v(k)=j` for `k<n`.
	 */
	public final static IBuiltInSymbol RussellRaoDissimilarity = initFinalSymbol("RussellRaoDissimilarity",
			ID.RussellRaoDissimilarity);
	/** SameQ(x, y) - returns `True` if `x` and `y` are structurally identical. */
	public final static IBuiltInSymbol SameQ = initFinalSymbol("SameQ", ID.SameQ);
	/***/
	public final static IBuiltInSymbol SameTest = initFinalSymbol("SameTest", ID.SameTest);
	/**
	 * SatisfiabilityCount(boolean-expr) - test whether the `boolean-expr` is satisfiable by a combination of boolean
	 * `False` and `True` values for the variables of the boolean expression and return the number of possible
	 * combinations.
	 */
	public final static IBuiltInSymbol SatisfiabilityCount = initFinalSymbol("SatisfiabilityCount",
			ID.SatisfiabilityCount);
	/**
	 * SatisfiabilityInstances(boolean-expr, list-of-variables) - test whether the `boolean-expr` is satisfiable by a
	 * combination of boolean `False` and `True` values for the `list-of-variables` and return exactly one instance of
	 * `True, False` combinations if possible.
	 */
	public final static IBuiltInSymbol SatisfiabilityInstances = initFinalSymbol("SatisfiabilityInstances",
			ID.SatisfiabilityInstances);
	/**
	 * SatisfiableQ(boolean-expr, list-of-variables) - test whether the `boolean-expr` is satisfiable by a combination
	 * of boolean `False` and `True` values for the `list-of-variables`.
	 */
	public final static IBuiltInSymbol SatisfiableQ = initFinalSymbol("SatisfiableQ", ID.SatisfiableQ);
	/***/
	public final static IBuiltInSymbol Scaled = initFinalSymbol("Scaled", ID.Scaled);
	/** Scan(f, expr) - applies `f` to each element of `expr` and returns 'Null'. */
	public final static IBuiltInSymbol Scan = initFinalSymbol("Scan", ID.Scan);
	/** Sec(z) - returns the secant of `z`. */
	public final static IBuiltInSymbol Sec = initFinalSymbol("Sec", ID.Sec);
	/** Sech(z) - returns the hyperbolic secant of `z`. */
	public final static IBuiltInSymbol Sech = initFinalSymbol("Sech", ID.Sech);
	/***/
	public final static IBuiltInSymbol Second = initFinalSymbol("Second", ID.Second);
	/** Select({e1, e2, ...}, f) - returns a list of the elements `ei` for which `f(ei)` returns `True`. */
	public final static IBuiltInSymbol Select = initFinalSymbol("Select", ID.Select);
	/** SelectFirst({e1, e2, ...}, f) - returns the first of the elements `ei` for which `f(ei)` returns `True`. */
	public final static IBuiltInSymbol SelectFirst = initFinalSymbol("SelectFirst", ID.SelectFirst);
	/**
	 * SemanticImport("path-to-filename") - if the file system is enabled, import the data from CSV files and do a
	 * semantic interpretation of the columns.
	 */
	public final static IBuiltInSymbol SemanticImport = initFinalSymbol("SemanticImport", ID.SemanticImport);

	/**
	 * SemanticImportString("string-content") - import the data from a content string in CSV format and do a semantic
	 * interpretation of the columns.
	 */
	public final static IBuiltInSymbol SemanticImportString = initFinalSymbol("SemanticImportString",
			ID.SemanticImportString);
	/***/
	public final static IBuiltInSymbol Sequence = initFinalSymbol("Sequence", ID.Sequence);
	/***/
	public final static IBuiltInSymbol SequenceHold = initFinalSymbol("SequenceHold", ID.SequenceHold);
	/** Series(expr, {x, x0, n}) - create a power series of `expr` up to order `(x- x0)^n` at the point `x = x0` */
	public final static IBuiltInSymbol Series = initFinalSymbol("Series", ID.Series);
	/** SeriesCoefficient(expr, {x, x0, n}) - get the coefficient of `(x- x0)^n` at the point `x = x0` */
	public final static IBuiltInSymbol SeriesCoefficient = initFinalSymbol("SeriesCoefficient", ID.SeriesCoefficient);
	/**
	 * SeriesData(x, x0, {coeff0, coeff1, coeff2,...}, nMin, nMax, denominator}) - internal structure of a power series
	 * at the point `x = x0` the `coeff`-i are coefficients of the power series.
	 */
	public final static IBuiltInSymbol SeriesData = initFinalSymbol("SeriesData", ID.SeriesData);
	/** Set(expr, value) - evaluates `value` and assigns it to `expr`. */
	public final static IBuiltInSymbol Set = initFinalSymbol("Set", ID.Set);
	/** SetAttributes(symbol, attrib) - adds `attrib` to `symbol`'s attributes. */
	public final static IBuiltInSymbol SetAttributes = initFinalSymbol("SetAttributes", ID.SetAttributes);
	/** SetDelayed(expr, value) - assigns `value` to `expr`, without evaluating `value`. */
	public final static IBuiltInSymbol SetDelayed = initFinalSymbol("SetDelayed", ID.SetDelayed);
	/***/
	public final static IBuiltInSymbol Share = initFinalSymbol("Share", ID.Share);
	/***/
	public final static IBuiltInSymbol Short = initFinalSymbol("Short", ID.Short);

	/***/
	public final static IBuiltInSymbol Shortest = initFinalSymbol("Shortest", ID.Shortest);
	/***/
	public final static IBuiltInSymbol Show = initFinalSymbol("Show", ID.Show);
	/** Sign(x) - gives `-1`, `0` or `1` depending on whether `x` is negative, zero or positive. */
	public final static IBuiltInSymbol Sign = initFinalSymbol("Sign", ID.Sign);
	/***/
	public final static IBuiltInSymbol SignCmp = initFinalSymbol("SignCmp", ID.SignCmp);
	/**
	 * Signature(permutation-list) - determine if the `permutation-list` has odd (`-1`) or even (`1`) parity. Returns
	 * `0` if two elements in the `permutation-list` are equal.
	 */
	public final static IBuiltInSymbol Signature = initFinalSymbol("Signature", ID.Signature);
	/** Simplify(expr) - simplifies `expr` */
	public final static IBuiltInSymbol Simplify = initFinalSymbol("Simplify", ID.Simplify);
	/** Sin(expr) - returns the sine of `expr` (measured in radians). */
	public final static IBuiltInSymbol Sin = initFinalSymbol("Sin", ID.Sin);
	/** SinIntegral(expr) - returns the hyperbolic sine integral of `expr`. */
	public final static IBuiltInSymbol SinIntegral = initFinalSymbol("SinIntegral", ID.SinIntegral);
	/** Sinc(expr) - the sinc function `Sin(expr)/expr` for `expr != 0`. `Sinc(0)` returns `1`. */
	public final static IBuiltInSymbol Sinc = initFinalSymbol("Sinc", ID.Sinc);
	/** SingularValueDecomposition(matrix) - calculates the singular value decomposition for the `matrix`. */
	public final static IBuiltInSymbol SingularValueDecomposition = initFinalSymbol("SingularValueDecomposition",
			ID.SingularValueDecomposition);
	/** Sinh(z) - returns the hyperbolic sine of `z`. */
	public final static IBuiltInSymbol Sinh = initFinalSymbol("Sinh", ID.Sinh);
	/** SinhIntegral(expr) - returns the sine integral of `expr`. */
	public final static IBuiltInSymbol SinhIntegral = initFinalSymbol("SinhIntegral", ID.SinhIntegral);
	/**
	 * Skewness(list) - gives Pearson's moment coefficient of skewness for `list` (a measure for estimating the symmetry
	 * of a distribution).
	 */
	public final static IBuiltInSymbol Skewness = initFinalSymbol("Skewness", ID.Skewness);
	/** # - is a short-hand for `#1`. */
	public final static IBuiltInSymbol Slot = initFinalSymbol("Slot", ID.Slot);
	/** ## - is the sequence of arguments supplied to a pure function. */
	public final static IBuiltInSymbol SlotSequence = initFinalSymbol("SlotSequence", ID.SlotSequence);
	/**
	 * SokalSneathDissimilarity(u, v) - returns the Sokal-Sneath dissimilarity between the two boolean 1-D lists `u` and
	 * `v`, which is defined as `R / (c_tt + R)` where n is `len(u)`, `c_ij` is the number of occurrences of `u(k)=i`
	 * and `v(k)=j` for `k<n`, and `R = 2 * (c_tf + c_ft)`.
	 */
	public final static IBuiltInSymbol SokalSneathDissimilarity = initFinalSymbol("SokalSneathDissimilarity",
			ID.SokalSneathDissimilarity);
	/** Solve(equations, vars) - attempts to solve `equations` for the variables `vars`. */
	public final static IBuiltInSymbol Solve = initFinalSymbol("Solve", ID.Solve);
	/** Sort(list) - sorts `list` (or the leaves of any other expression) according to canonical ordering. */
	public final static IBuiltInSymbol Sort = initFinalSymbol("Sort", ID.Sort);
	/**
	 * SortBy(list, f) - sorts `list` (or the leaves of any other expression) according to canonical ordering of the
	 * keys that are extracted from the `list`'s elements using `f`. Chunks of leaves that appear the same under `f` are
	 * sorted according to their natural order (without applying `f`).
	 */
	public final static IBuiltInSymbol SortBy = initFinalSymbol("SortBy", ID.SortBy);
	/** Sow(expr) - sends the value `expr` to the innermost `Reap`. */
	public final static IBuiltInSymbol Sow = initFinalSymbol("Sow", ID.Sow);
	/** Span - is the head of span ranges like `1;;3`. */
	public final static IBuiltInSymbol Span = initFinalSymbol("Span", ID.Span);
	/***/
	public final static IBuiltInSymbol SparseArray = initFinalSymbol("SparseArray", ID.SparseArray);
	/** SphericalBesselJ(n, z) - spherical Bessel function `J(n, x)`. */
	public final static IBuiltInSymbol SphericalBesselJ = initFinalSymbol("SphericalBesselJ", ID.SphericalBesselJ);

	/** SphericalBesselY(n, z) - spherical Bessel function `Y(n, x)`. */
	public final static IBuiltInSymbol SphericalBesselY = initFinalSymbol("SphericalBesselY", ID.SphericalBesselY);

	/***/
	public final static IBuiltInSymbol SphericalHankelH1 = initFinalSymbol("SphericalHankelH1", ID.SphericalHankelH1);

	/***/
	public final static IBuiltInSymbol SphericalHankelH2 = initFinalSymbol("SphericalHankelH2", ID.SphericalHankelH2);
	/** Split(list) - splits `list` into collections of consecutive identical elements. */
	public final static IBuiltInSymbol Split = initFinalSymbol("Split", ID.Split);
	/**
	 * SplitBy(list, f) - splits `list` into collections of consecutive elements that give the same result when `f` is
	 * applied.
	 */
	public final static IBuiltInSymbol SplitBy = initFinalSymbol("SplitBy", ID.SplitBy);
	/** Sqrt(expr) - returns the square root of `expr`. */
	public final static IBuiltInSymbol Sqrt = initFinalSymbol("Sqrt", ID.Sqrt);
	/**
	 * SquareFreeQ(n) - returns `True` if `n` is a square free integer number or a square free univariate polynomial.
	 */
	public final static IBuiltInSymbol SquareFreeQ = initFinalSymbol("SquareFreeQ", ID.SquareFreeQ);
	/** SquareMatrixQ(m) - returns `True` if `m` is a square matrix. */
	public final static IBuiltInSymbol SquareMatrixQ = initFinalSymbol("SquareMatrixQ", ID.SquareMatrixQ);
	/** SquaredEuclideanDistance(u, v) - returns squared the euclidean distance between `u$` and `v`. */
	public final static IBuiltInSymbol SquaredEuclideanDistance = initFinalSymbol("SquaredEuclideanDistance",
			ID.SquaredEuclideanDistance);
	/** Stack( ) - return a list of the heads of the current stack wrapped by `HoldForm`. */
	public final static IBuiltInSymbol Stack = initFinalSymbol("Stack", ID.Stack);

	/**
	 * Stack(expr) - begine a new stack and evaluate `èxpr`. Use `Stack(_)` as a subexpression in `expr` to return the
	 * stack elements.
	 */
	public final static IBuiltInSymbol StackBegin = initFinalSymbol("StackBegin", ID.StackBegin);
	/**
	 * StandardDeviation(list) - computes the standard deviation of `list`. `list` may consist of numerical values or
	 * symbols. Numerical values may be real or complex.
	 */
	public final static IBuiltInSymbol StandardDeviation = initFinalSymbol("StandardDeviation", ID.StandardDeviation);
	/***/
	public final static IBuiltInSymbol StandardForm = initFinalSymbol("StandardForm", ID.StandardForm);
	/***/
	public final static IBuiltInSymbol Standardize = initFinalSymbol("Standardize", ID.Standardize);
	/***/
	public final static IBuiltInSymbol StartOfLine = initFinalSymbol("StartOfLine", ID.StartOfLine);

	/***/
	public final static IBuiltInSymbol StartOfString = initFinalSymbol("StartOfString", ID.StartOfString);

	/** StieltjesGamma(a) - returns Stieltjes constant. */
	public final static IBuiltInSymbol StieltjesGamma = initFinalSymbol("StieltjesGamma", ID.StieltjesGamma);
	/** StirlingS1(n, k) - returns the Stirling numbers of the first kind. */
	public final static IBuiltInSymbol StirlingS1 = initFinalSymbol("StirlingS1", ID.StirlingS1);
	/**
	 * StirlingS2(n, k) - returns the Stirling numbers of the second kind. `StirlingS2(n,k)` is the number of ways of
	 * partitioning an `n`-element set into `k` non-empty subsets.
	 */
	public final static IBuiltInSymbol StirlingS2 = initFinalSymbol("StirlingS2", ID.StirlingS2);
	/***/
	public final static IBuiltInSymbol Strict = initFinalSymbol("Strict", ID.Strict);
	/***/
	public final static IBuiltInSymbol String = initFinalSymbol("String", ID.String);
	/** StringCases(string, pattern) - gives all occurences of `pattern` in `string`. */
	public final static IBuiltInSymbol StringCases = initFinalSymbol("StringCases", ID.StringCases);

	/**
	 * StringContainsQ(str1, str2) - return a list of matches for `"p1", "p2",...` list of strings in the string `str`.
	 */
	public final static IBuiltInSymbol StringContainsQ = initFinalSymbol("StringContainsQ", ID.StringContainsQ);
	/** StringCount(string, pattern) - counts all occurences of `pattern` in `string`. */
	public final static IBuiltInSymbol StringCount = initFinalSymbol("StringCount", ID.StringCount);
	/***/
	public final static IBuiltInSymbol StringDrop = initFinalSymbol("StringDrop", ID.StringDrop);
	/***/
	public final static IBuiltInSymbol StringExpression = initFinalSymbol("StringExpression", ID.StringExpression);
	/***/
	public final static IBuiltInSymbol StringInsert = initFinalSymbol("StringInsert", ID.StringInsert);

	/** StringJoin(str1, str2, ... strN) - returns the concatenation of the strings `str1, str2, ... strN`. */
	public final static IBuiltInSymbol StringJoin = initFinalSymbol("StringJoin", ID.StringJoin);
	/** StringLength(string) - gives the length of `string`. */
	public final static IBuiltInSymbol StringLength = initFinalSymbol("StringLength", ID.StringLength);
	/** StringMatchQ(string, regex-pattern) - check if the regular expression `regex-pattern` matches the `string`. */
	public final static IBuiltInSymbol StringMatchQ = initFinalSymbol("StringMatchQ", ID.StringMatchQ);

	/** StringPart(str, pos) - return the character at position `pos` from the `str` string expression. */
	public final static IBuiltInSymbol StringPart = initFinalSymbol("StringPart", ID.StringPart);

	/** StringQ(x) - is `True` if `x` is a string object, or `False` otherwise. */
	public final static IBuiltInSymbol StringQ = initFinalSymbol("StringQ", ID.StringQ);
	/** StringReplace(string, fromStr -> toStr) - replaces each occurrence of `fromStr` with `toStr` in `string`. */
	public final static IBuiltInSymbol StringReplace = initFinalSymbol("StringReplace", ID.StringReplace);
	/***/
	public final static IBuiltInSymbol StringRiffle = initFinalSymbol("StringRiffle", ID.StringRiffle);
	/** StringSplit(str) - split the string `str` by whitespaces into a list of strings. */
	public final static IBuiltInSymbol StringSplit = initFinalSymbol("StringSplit", ID.StringSplit);
	/***/
	public final static IBuiltInSymbol StringTake = initFinalSymbol("StringTake", ID.StringTake);

	/***/
	public final static IBuiltInSymbol StringTrim = initFinalSymbol("StringTrim", ID.StringTrim);
	/***/
	public final static IBuiltInSymbol Structure = initFinalSymbol("Structure", ID.Structure);

	/** StruveH(n, z) - returns the Struve function `H_n(z)`. */
	public final static IBuiltInSymbol StruveH = initFinalSymbol("StruveH", ID.StruveH);
	/** StruveL(n, z) - returns the modified Struve function `L_n(z)`. */
	public final static IBuiltInSymbol StruveL = initFinalSymbol("StruveL", ID.StruveL);
	/** StudentTDistribution(v) - returns a Student's t-distribution. */
	public final static IBuiltInSymbol StudentTDistribution = initFinalSymbol("StudentTDistribution",
			ID.StudentTDistribution);
	/***/
	public final static IBuiltInSymbol Style = initFinalSymbol("Style", ID.Style);

	/***/
	public final static IBuiltInSymbol StyleForm = initFinalSymbol("StyleForm", ID.StyleForm);
	/** Subdivide(n) - returns a list with `n+1` entries obtained by subdividing the range `0` to `1`. */
	public final static IBuiltInSymbol Subdivide = initFinalSymbol("Subdivide", ID.Subdivide);
	/** Subfactorial(n) - returns the subfactorial number of the integer `n` */
	public final static IBuiltInSymbol Subfactorial = initFinalSymbol("Subfactorial", ID.Subfactorial);
	/***/
	public final static IBuiltInSymbol Subscript = initFinalSymbol("Subscript", ID.Subscript);
	/***/
	public final static IBuiltInSymbol SubsetQ = initFinalSymbol("SubsetQ", ID.SubsetQ);
	/** Subsets(list) - finds a list of all possible subsets of `list`. */
	public final static IBuiltInSymbol Subsets = initFinalSymbol("Subsets", ID.Subsets);
	/***/
	public final static IBuiltInSymbol Subsuperscript = initFinalSymbol("Subsuperscript", ID.Subsuperscript);
	/** Subtract(a, b) - represents the subtraction of `b` from `a`. */
	public final static IBuiltInSymbol Subtract = initFinalSymbol("Subtract", ID.Subtract);
	/** SubtractFrom(x, dx) - is equivalent to `x = x - dx`. */
	public final static IBuiltInSymbol SubtractFrom = initFinalSymbol("SubtractFrom", ID.SubtractFrom);
	/** Sum(expr, {i, imin, imax}) - evaluates the discrete sum of `expr` with `i` ranging from `imin` to `imax`. */
	public final static IBuiltInSymbol Sum = initFinalSymbol("Sum", ID.Sum);

	/***/
	public final static IBuiltInSymbol Summary = initFinalSymbol("Summary", ID.Summary);

	/***/
	public final static IBuiltInSymbol Superscript = initFinalSymbol("Superscript", ID.Superscript);
	/** Surd(expr, n) - returns the `n`-th root of `expr`. If the result is defined, it's a real value. */
	public final static IBuiltInSymbol Surd = initFinalSymbol("Surd", ID.Surd);
	/***/
	public final static IBuiltInSymbol SurfaceGraphics = initFinalSymbol("SurfaceGraphics", ID.SurfaceGraphics);
	/** SurvivalFunction(dist, x) - returns the survival function for the distribution `dist` evaluated at `x`. */
	public final static IBuiltInSymbol SurvivalFunction = initFinalSymbol("SurvivalFunction", ID.SurvivalFunction);
	/**
	 * Switch(expr, pattern1, value1, pattern2, value2, ...) - yields the first `value` for which `expr` matches the
	 * corresponding pattern.
	 */
	public final static IBuiltInSymbol Switch = initFinalSymbol("Switch", ID.Switch);
	/** Symbol - is the head of symbols. */
	public final static IBuiltInSymbol Symbol = initFinalSymbol("Symbol", ID.Symbol);
	/** SymbolName(s) - returns the name of the symbol `s` (without any leading context name). */
	public final static IBuiltInSymbol SymbolName = initFinalSymbol("SymbolName", ID.SymbolName);
	/** SymbolQ(x) - is `True` if `x` is a symbol, or `False` otherwise. */
	public final static IBuiltInSymbol SymbolQ = initFinalSymbol("SymbolQ", ID.SymbolQ);
	/***/
	public final static IBuiltInSymbol Symmetric = initFinalSymbol("Symmetric", ID.Symmetric);
	/** SymmetricMatrixQ(m) - returns `True` if `m` is a symmetric matrix. */
	public final static IBuiltInSymbol SymmetricMatrixQ = initFinalSymbol("SymmetricMatrixQ", ID.SymmetricMatrixQ);
	/***/
	public final static IBuiltInSymbol SyntaxLength = initFinalSymbol("SyntaxLength", ID.SyntaxLength);
	/** SyntaxQ(str) - is `True` if the given `str` is a string which has the correct syntax. */
	public final static IBuiltInSymbol SyntaxQ = initFinalSymbol("SyntaxQ", ID.SyntaxQ);
	/** SystemDialogInput("FileOpen") - if the file system is enabled, open a file chooser dialog box. */
	public final static IBuiltInSymbol SystemDialogInput = initFinalSymbol("SystemDialogInput", ID.SystemDialogInput);

	/** Table(expr, {i, n}) - evaluates `expr` with `i` ranging from `1` to `n`, returning a list of the results. */
	public final static IBuiltInSymbol Table = initFinalSymbol("Table", ID.Table);
	/***/
	public final static IBuiltInSymbol TableForm = initFinalSymbol("TableForm", ID.TableForm);
	/***/
	public final static IBuiltInSymbol TableHeadings = initFinalSymbol("TableHeadings", ID.TableHeadings);
	/***/
	public final static IBuiltInSymbol TagSet = initFinalSymbol("TagSet", ID.TagSet);
	/***/
	public final static IBuiltInSymbol TagSetDelayed = initFinalSymbol("TagSetDelayed", ID.TagSetDelayed);
	/** Take(expr, n) - returns `expr` with all but the first `n` leaves removed. */
	public final static IBuiltInSymbol Take = initFinalSymbol("Take", ID.Take);
	/***/
	public final static IBuiltInSymbol TakeLargest = initFinalSymbol("TakeLargest", ID.TakeLargest);

	/***/
	public final static IBuiltInSymbol TakeLargestBy = initFinalSymbol("TakeLargestBy", ID.TakeLargestBy);
	/***/
	public final static IBuiltInSymbol Tally = initFinalSymbol("Tally", ID.Tally);
	/** Tan(expr) - returns the tangent of `expr` (measured in radians). */
	public final static IBuiltInSymbol Tan = initFinalSymbol("Tan", ID.Tan);
	/** Tanh(z) - returns the hyperbolic tangent of `z`. */
	public final static IBuiltInSymbol Tanh = initFinalSymbol("Tanh", ID.Tanh);
	/**
	 * TautologyQ(boolean-expr, list-of-variables) - test whether the `boolean-expr` is satisfiable by all combinations
	 * of boolean `False` and `True` values for the `list-of-variables`.
	 */
	public final static IBuiltInSymbol TautologyQ = initFinalSymbol("TautologyQ", ID.TautologyQ);
	/***/
	public final static IBuiltInSymbol Taylor = initFinalSymbol("Taylor", ID.Taylor);
	/** TeXForm(expr) - returns the TeX form of the evaluated `expr`. */
	public final static IBuiltInSymbol TeXForm = initFinalSymbol("TeXForm", ID.TeXForm);
	/***/
	public final static IBuiltInSymbol TensorDimensions = initFinalSymbol("TensorDimensions", ID.TensorDimensions);
	/***/
	public final static IBuiltInSymbol TensorProduct = initFinalSymbol("TensorProduct", ID.TensorProduct);
	/***/
	public final static IBuiltInSymbol TensorRank = initFinalSymbol("TensorRank", ID.TensorRank);
	/***/
	public final static IBuiltInSymbol TensorSymmetry = initFinalSymbol("TensorSymmetry", ID.TensorSymmetry);
	/***/
	public final static IBuiltInSymbol TestID = initFinalSymbol("TestID", ID.TestID);

	/***/
	public final static IBuiltInSymbol TestReport = initFinalSymbol("TestReport", ID.TestReport);

	/***/
	public final static IBuiltInSymbol TestReportObject = initFinalSymbol("TestReportObject", ID.TestReportObject);

	/***/
	public final static IBuiltInSymbol TestResultObject = initFinalSymbol("TestResultObject", ID.TestResultObject);
	/***/
	public final static IBuiltInSymbol TextCell = initFinalSymbol("TextCell", ID.TextCell);
	/***/
	public final static IBuiltInSymbol TextString = initFinalSymbol("TextString", ID.TextString);

	/** Thread(f(args) - threads `f` over any lists that appear in `args`. */
	public final static IBuiltInSymbol Thread = initFinalSymbol("Thread", ID.Thread);
	/** Through(p(f)[x]) - gives `p(f(x))`. */
	public final static IBuiltInSymbol Through = initFinalSymbol("Through", ID.Through);
	/***/
	public final static IBuiltInSymbol Throw = initFinalSymbol("Throw", ID.Throw);
	/***/
	public final static IBuiltInSymbol TimeConstrained = initFinalSymbol("TimeConstrained", ID.TimeConstrained);
	/***/
	public final static IBuiltInSymbol TimeObject = initFinalSymbol("TimeObject", ID.TimeObject);
	/** TimeValue(p, i, n) - returns a time value calculation. */
	public final static IBuiltInSymbol TimeValue = initFinalSymbol("TimeValue", ID.TimeValue);
	/** Times(a, b, ...) - represents the product of the terms `a, b, ...`. */
	public final static IBuiltInSymbol Times = initFinalSymbol("Times", ID.Times);
	/** TimesBy(x, dx) - is equivalent to `x = x * dx`. */
	public final static IBuiltInSymbol TimesBy = initFinalSymbol("TimesBy", ID.TimesBy);
	/**
	 * Timing(x) - returns a list with the first entry containing the evaluation time of `x` and the second entry is the
	 * evaluation result of `x`.
	 */
	public final static IBuiltInSymbol Timing = initFinalSymbol("Timing", ID.Timing);
	/** ToCharacterCode(string) - converts `string` into a list of corresponding integer character codes. */
	public final static IBuiltInSymbol ToCharacterCode = initFinalSymbol("ToCharacterCode", ID.ToCharacterCode);
	/** ToExpression("string", form) - converts the `string` given in `form` into an expression. */
	public final static IBuiltInSymbol ToExpression = initFinalSymbol("ToExpression", ID.ToExpression);
	/** ToPolarCoordinates({x, y}) - return the polar coordinates for the cartesian coordinates `{x, y}`. */
	public final static IBuiltInSymbol ToPolarCoordinates = initFinalSymbol("ToPolarCoordinates",
			ID.ToPolarCoordinates);
	/***/
	public final static IBuiltInSymbol ToRadicals = initFinalSymbol("ToRadicals", ID.ToRadicals);
	/** ToString(expr) - converts `expr` into a string. */
	public final static IBuiltInSymbol ToString = initFinalSymbol("ToString", ID.ToString);
	/***/
	public final static IBuiltInSymbol ToUnicode = initFinalSymbol("ToUnicode", ID.ToUnicode);
	/***/
	public final static IBuiltInSymbol Today = initFinalSymbol("Today", ID.Today);
	/** ToeplitzMatrix(n) - gives a toeplitz matrix with the dimension `n`. */
	public final static IBuiltInSymbol ToeplitzMatrix = initFinalSymbol("ToeplitzMatrix", ID.ToeplitzMatrix);
	/** Together(expr) - writes sums of fractions in `expr` together. */
	public final static IBuiltInSymbol Together = initFinalSymbol("Together", ID.Together);
	/***/
	public final static IBuiltInSymbol TooLarge = initFinalSymbol("TooLarge", ID.TooLarge);
	/***/
	public final static IBuiltInSymbol Top = initFinalSymbol("Top", ID.Top);
	/** Total(list) - adds all values in `list`. */
	public final static IBuiltInSymbol Total = initFinalSymbol("Total", ID.Total);
	/** Tr(matrix) - computes the trace of the `matrix`. */
	public final static IBuiltInSymbol Tr = initFinalSymbol("Tr", ID.Tr);
	/** Trace(expr) - return the evaluation steps which are used to get the result. */
	public final static IBuiltInSymbol Trace = initFinalSymbol("Trace", ID.Trace);
	/***/
	public final static IBuiltInSymbol TraceForm = initFinalSymbol("TraceForm", ID.TraceForm);
	/***/
	public final static IBuiltInSymbol TraditionalForm = initFinalSymbol("TraditionalForm", ID.TraditionalForm);
	/***/
	public final static IBuiltInSymbol Transliterate = initFinalSymbol("Transliterate", ID.Transliterate);
	/** Transpose(m) - transposes rows and columns in the matrix `m`. */
	public final static IBuiltInSymbol Transpose = initFinalSymbol("Transpose", ID.Transpose);
	/** TreeForm(expr) - create a tree visualization from the given expression `expr`. */
	public final static IBuiltInSymbol TreeForm = initFinalSymbol("TreeForm", ID.TreeForm);
	/***/
	public final static IBuiltInSymbol Trig = initFinalSymbol("Trig", ID.Trig);
	/** TrigExpand(expr) - expands out trigonometric expressions in `expr`. */
	public final static IBuiltInSymbol TrigExpand = initFinalSymbol("TrigExpand", ID.TrigExpand);
	/**
	 * TrigReduce(expr) - rewrites products and powers of trigonometric functions in `expr` in terms of trigonometric
	 * functions with combined arguments.
	 */
	public final static IBuiltInSymbol TrigReduce = initFinalSymbol("TrigReduce", ID.TrigReduce);
	/** TrigToExp(expr) - converts trigonometric functions in `expr` to exponentials. */
	public final static IBuiltInSymbol TrigToExp = initFinalSymbol("TrigToExp", ID.TrigToExp);
	/** True - the constant `True` represents the boolean value **true ***/
	public final static IBuiltInSymbol True = initFinalSymbol("True", ID.True);
	/** TrueQ(expr) - returns `True` if and only if `expr` is `True`. */
	public final static IBuiltInSymbol TrueQ = initFinalSymbol("TrueQ", ID.TrueQ);
	/***/
	public final static IBuiltInSymbol TukeyWindow = initFinalSymbol("TukeyWindow", ID.TukeyWindow);
	/** Tuples(list, n) - creates a list of all `n`-tuples of elements in `list`. */
	public final static IBuiltInSymbol Tuples = initFinalSymbol("Tuples", ID.Tuples);
	/***/
	public final static IBuiltInSymbol TwoWayRule = initFinalSymbol("TwoWayRule", ID.TwoWayRule);
	/***/
	public final static IBuiltInSymbol Undefined = initFinalSymbol("Undefined", ID.Undefined);
	/***/
	public final static IBuiltInSymbol Underoverscript = initFinalSymbol("Underoverscript", ID.Underoverscript);
	/***/
	public final static IBuiltInSymbol UndirectedEdge = initFinalSymbol("UndirectedEdge", ID.UndirectedEdge);

	/**
	 * Unequal(x, y) - yields `False` if `x` and `y` are known to be equal, or `True` if `x` and `y` are known to be
	 * unequal.
	 */
	public final static IBuiltInSymbol Unequal = initFinalSymbol("Unequal", ID.Unequal);
	/***/
	public final static IBuiltInSymbol Unevaluated = initFinalSymbol("Unevaluated", ID.Unevaluated);
	/** UniformDistribution({min, max}) - returns a uniform distribution. */
	public final static IBuiltInSymbol UniformDistribution = initFinalSymbol("UniformDistribution",
			ID.UniformDistribution);
	/** Union(set1, set2) - get the union set from `set1` and `set2`. */
	public final static IBuiltInSymbol Union = initFinalSymbol("Union", ID.Union);
	/** Unique(expr) - create a unique symbol of the form `expr$...`. */
	public final static IBuiltInSymbol Unique = initFinalSymbol("Unique", ID.Unique);
	/** UnitConvert(quantity) - convert the `quantity` to the base unit */
	public final static IBuiltInSymbol UnitConvert = initFinalSymbol("UnitConvert", ID.UnitConvert);
	/**
	 * UnitStep(expr) - returns `0`, if `expr` is less than `0` and returns `1`, if `expr` is greater equal than `0`.
	 */
	public final static IBuiltInSymbol UnitStep = initFinalSymbol("UnitStep", ID.UnitStep);
	/** UnitVector(position) - returns a unit vector with element `1` at the given `position`. */
	public final static IBuiltInSymbol UnitVector = initFinalSymbol("UnitVector", ID.UnitVector);
	/***/
	public final static IBuiltInSymbol UnitaryMatrixQ = initFinalSymbol("UnitaryMatrixQ", ID.UnitaryMatrixQ);
	/** Unitize(expr) - maps a non-zero `expr` to `1`, and a zero `expr` to `0`. */
	public final static IBuiltInSymbol Unitize = initFinalSymbol("Unitize", ID.Unitize);
	/***/
	public final static IBuiltInSymbol Unknown = initFinalSymbol("Unknown", ID.Unknown);
	/***/
	public final static IBuiltInSymbol Unprotect = initFinalSymbol("Unprotect", ID.Unprotect);
	/** UnsameQ(x, y) - returns `True` if `x` and `y` are not structurally identical. */
	public final static IBuiltInSymbol UnsameQ = initFinalSymbol("UnsameQ", ID.UnsameQ);
	/** Unset(expr) - removes any definitions belonging to the left-hand-side `expr`. */
	public final static IBuiltInSymbol Unset = initFinalSymbol("Unset", ID.Unset);
	/***/
	public final static IBuiltInSymbol UpSet = initFinalSymbol("UpSet", ID.UpSet);
	/***/
	public final static IBuiltInSymbol UpSetDelayed = initFinalSymbol("UpSetDelayed", ID.UpSetDelayed);
	/***/
	public final static IBuiltInSymbol UpTo = initFinalSymbol("UpTo", ID.UpTo);

	/***/
	public final static IBuiltInSymbol UpValues = initFinalSymbol("UpValues", ID.UpValues);


	/** UpperCaseQ(str) - is `True` if the given `str` is a string which only contains upper case characters. */
	public final static IBuiltInSymbol UpperCaseQ = initFinalSymbol("UpperCaseQ", ID.UpperCaseQ);
	/** UpperTriangularize(matrix) - create a upper triangular matrix from the given `matrix`. */
	public final static IBuiltInSymbol UpperTriangularize = initFinalSymbol("UpperTriangularize",
			ID.UpperTriangularize);
	/** ValueQ(expr) - returns `True` if and only if `expr` is defined. */
	public final static IBuiltInSymbol ValueQ = initFinalSymbol("ValueQ", ID.ValueQ);
	/** Values(association) - return a list of values of the `association`. */
	public final static IBuiltInSymbol Values = initFinalSymbol("Values", ID.Values);
	/** VandermondeMatrix(n) - gives the Vandermonde matrix with `n` rows and columns. */
	public final static IBuiltInSymbol VandermondeMatrix = initFinalSymbol("VandermondeMatrix", ID.VandermondeMatrix);
	/***/
	public final static IBuiltInSymbol Variable = initFinalSymbol("Variable", ID.Variable);
	/** Variables(expr) - gives a list of the variables that appear in the polynomial `expr`. */
	public final static IBuiltInSymbol Variables = initFinalSymbol("Variables", ID.Variables);
	/**
	 * Variance(list) - computes the variance of `list`. `list` may consist of numerical values or symbols. Numerical
	 * values may be real or complex.
	 */
	public final static IBuiltInSymbol Variance = initFinalSymbol("Variance", ID.Variance);
	/** VectorAngle(u, v) - gives the angles between vectors `u` and `v` */
	public final static IBuiltInSymbol VectorAngle = initFinalSymbol("VectorAngle", ID.VectorAngle);
	/** VectorQ(v) - returns `True` if `v` is a list of elements which are not themselves lists. */
	public final static IBuiltInSymbol VectorQ = initFinalSymbol("VectorQ", ID.VectorQ);
	/***/
	public final static IBuiltInSymbol VerificationTest = initFinalSymbol("VerificationTest", ID.VerificationTest);
	/**
	 * VertexEccentricity(graph, vertex) - compute the eccentricity of `vertex` in the `graph`. It's the length of the
	 * longest shortest path from the `vertex` to every other vertex in the `graph`.
	 */
	public final static IBuiltInSymbol VertexEccentricity = initFinalSymbol("VertexEccentricity", ID.VertexEccentricity);

	/** VertexList(graph) - convert the `graph` into a list of vertices. */
	public final static IBuiltInSymbol VertexList = initFinalSymbol("VertexList", ID.VertexList);

	/** VertexQ(graph, vertex) - test if `vertex` is a vertex in the `graph` object. */
	public final static IBuiltInSymbol VertexQ = initFinalSymbol("VertexQ", ID.VertexQ);
	/***/
	public final static IBuiltInSymbol ViewPoint = initFinalSymbol("ViewPoint", ID.ViewPoint);

	/** WeibullDistribution(a, b) - returns a Weibull distribution. */
	public final static IBuiltInSymbol WeibullDistribution = initFinalSymbol("WeibullDistribution",
			ID.WeibullDistribution);

	/***/
	public final static IBuiltInSymbol WeierstrassHalfPeriods = initFinalSymbol("WeierstrassHalfPeriods", ID.WeierstrassHalfPeriods);

	/***/
	public final static IBuiltInSymbol WeierstrassInvariants = initFinalSymbol("WeierstrassInvariants", ID.WeierstrassInvariants);

	/** WeierstrassP(expr, {n1, n2}) - Weierstrass elliptic function. */
	public final static IBuiltInSymbol WeierstrassP = initFinalSymbol("WeierstrassP", ID.WeierstrassP);

	/***/
	public final static IBuiltInSymbol WeierstrassPPrime = initFinalSymbol("WeierstrassPPrime", ID.WeierstrassPPrime);
	/***/
	public final static IBuiltInSymbol WeightedAdjacencyMatrix = initFinalSymbol("WeightedAdjacencyMatrix",
			ID.WeightedAdjacencyMatrix);

	/***/
	public final static IBuiltInSymbol WeightedData = initFinalSymbol("WeightedData", ID.WeightedData);
	/**
	 * Which(cond1, expr1, cond2, expr2, ...) - yields `expr1` if `cond1` evaluates to `True`, `expr2` if `cond2`
	 * evaluates to `True`, etc.
	 */
	public final static IBuiltInSymbol Which = initFinalSymbol("Which", ID.Which);
	/** While(test, body) - evaluates `body` as long as test evaluates to `True`. */
	public final static IBuiltInSymbol While = initFinalSymbol("While", ID.While);
	/***/
	public final static IBuiltInSymbol White = initFinalSymbol("White", ID.White);

	/***/
	public final static IBuiltInSymbol Whitespace = initFinalSymbol("Whitespace", ID.Whitespace);

	/***/
	public final static IBuiltInSymbol WhitespaceCharacter = initFinalSymbol("WhitespaceCharacter",
			ID.WhitespaceCharacter);
	/***/
	public final static IBuiltInSymbol WhittakerM = initFinalSymbol("WhittakerM", ID.WhittakerM);

	/***/
	public final static IBuiltInSymbol WhittakerW = initFinalSymbol("WhittakerW", ID.WhittakerW);

	/**
	 * With({list_of_local_variables}, expr ) - evaluates `expr` for the `list_of_local_variables` by replacing the
	 * local variables in `expr`.
	 */
	public final static IBuiltInSymbol With = initFinalSymbol("With", ID.With);
	/***/
	public final static IBuiltInSymbol WordBoundary = initFinalSymbol("WordBoundary", ID.WordBoundary);

	/***/
	public final static IBuiltInSymbol WordCharacter = initFinalSymbol("WordCharacter", ID.WordCharacter);
	/***/
	public final static IBuiltInSymbol WriteString = initFinalSymbol("WriteString", ID.WriteString);
	/**
	 * Xor(arg1, arg2, ...) - Logical XOR (exclusive OR) function. Returns `True` if an odd number of the arguments are
	 * `True` and the rest are `False`. Returns `False` if an even number of the arguments are `True` and the rest are
	 * `False`.
	 */
	public final static IBuiltInSymbol Xor = initFinalSymbol("Xor", ID.Xor);
	/***/
	public final static IBuiltInSymbol Yellow = initFinalSymbol("Yellow", ID.Yellow);
	/**
	 * YuleDissimilarity(u, v) - returns the Yule dissimilarity between the two boolean 1-D lists `u` and `v`, which is
	 * defined as `R / (c_tt * c_ff + R / 2)` where `n` is `len(u)`, `c_ij` is the number of occurrences of `u(k)=i` and
	 * `v(k)=j` for `k<n`, and `R = 2 * c_tf * c_ft`.
	 */
	public final static IBuiltInSymbol YuleDissimilarity = initFinalSymbol("YuleDissimilarity", ID.YuleDissimilarity);
	/***/
	public final static IBuiltInSymbol ZeroSymmetric = initFinalSymbol("ZeroSymmetric", ID.ZeroSymmetric);
	/** Zeta(z) - returns the Riemann zeta function of `z`. */
	public final static IBuiltInSymbol Zeta = initFinalSymbol("Zeta", ID.Zeta);


	/**
	 * Used to represent a formal parameter <code>LHS_HEAD</code> that will never be assigned a value. Used for setting
	 * the left-hand-side in pattern-matching for <code>OptionValue(...)</code>
	 */
	public final static ISymbol LHS_HEAD = initFinalHiddenSymbol("LHSHead");

    /**
     * <p>
     * The constant object <code>NIL</code> (not in list) indicates in the evaluation process that no evaluation was
     * possible (i.e. no further definition was found to create a new expression from the existing one).
     * </p>
     * <p>
     * Almost every modifying method in this class throws an <tt>UnsupportedOperationException</tt>, almost every
     * predicate returns <code>false</code>. The main method to check if the object is valid is the
     * <code>isPresent()</code> method. The method is similar to <code>java.util.Optional#isPresent()</code>.
     * </p>
     *
     * @see java.util.Optional#isPresent
     */
    // Swift change: type is incompatible
	public final static INilPointer NIL = AbstractAST.NIL;

	public final static ISymbol $RealVector = initFinalHiddenSymbol(
			FEConfig.PARSER_USE_LOWERCASE_SYMBOLS ? "$realvector" : "$RealVector");
	public final static ISymbol $RealMatrix = initFinalHiddenSymbol(
			FEConfig.PARSER_USE_LOWERCASE_SYMBOLS ? "$realmatrix" : "$RealMatrix");

	// public final static ISymbol usage = initFinalHiddenSymbol("usage");

	/** Used to represent a formal parameter <code>a</code> that will never be assigned a value. */
	public final static ISymbol a = initFinalHiddenSymbol("a");
	/** Used to represent a formal parameter <code>b</code> that will never be assigned a value. */
	public final static ISymbol b = initFinalHiddenSymbol("b");
	/** Used to represent a formal parameter <code>c</code> that will never be assigned a value. */
	public final static ISymbol c = initFinalHiddenSymbol("c");
	/** Used to represent a formal parameter <code>d</code> that will never be assigned a value. */
	public final static ISymbol d = initFinalHiddenSymbol("d");
	/** Used to represent a formal parameter <code>e</code> that will never be assigned a value. */
	public final static ISymbol e = initFinalHiddenSymbol("e");
	/** Used to represent a formal parameter <code>f</code> that will never be assigned a value. */
	public final static ISymbol f = initFinalHiddenSymbol("f");
	/** Used to represent a formal parameter <code>g</code> that will never be assigned a value. */
	public final static ISymbol g = initFinalHiddenSymbol("g");
	/** Used to represent a formal parameter <code>h</code> that will never be assigned a value. */
	public final static ISymbol h = initFinalHiddenSymbol("h");
	/** Used to represent a formal parameter <code>i</code> that will never be assigned a value. */
	public final static ISymbol i = initFinalHiddenSymbol("i");
	/** Used to represent a formal parameter <code>j</code> that will never be assigned a value. */
	public final static ISymbol j = initFinalHiddenSymbol("j");
	/** Used to represent a formal parameter <code>k</code> that will never be assigned a value. */
	public final static ISymbol k = initFinalHiddenSymbol("k");
	/** Used to represent a formal parameter <code>l</code> that will never be assigned a value. */
	public final static ISymbol l = initFinalHiddenSymbol("l");
	/** Used to represent a formal parameter <code>m</code> that will never be assigned a value. */
	public final static ISymbol m = initFinalHiddenSymbol("m");
	/** Used to represent a formal parameter <code>n</code> that will never be assigned a value. */
	public final static ISymbol n = initFinalHiddenSymbol("n");
	/** Used to represent a formal parameter <code>o</code> that will never be assigned a value. */
	public final static ISymbol o = initFinalHiddenSymbol("o");
	/** Used to represent a formal parameter <code>p</code> that will never be assigned a value. */
	public final static ISymbol p = initFinalHiddenSymbol("p");
	/** Used to represent a formal parameter <code>q</code> that will never be assigned a value. */
	public final static ISymbol q = initFinalHiddenSymbol("q");
	/** Used to represent a formal parameter <code>r</code> that will never be assigned a value. */
	public final static ISymbol r = initFinalHiddenSymbol("r");
	/** Used to represent a formal parameter <code>s</code> that will never be assigned a value. */
	public final static ISymbol s = initFinalHiddenSymbol("s");
	/** Used to represent a formal parameter <code>t</code> that will never be assigned a value. */
	public final static ISymbol t = initFinalHiddenSymbol("t");
	/** Used to represent a formal parameter <code>u</code> that will never be assigned a value. */
	public final static ISymbol u = initFinalHiddenSymbol("u");
	/** Used to represent a formal parameter <code>v</code> that will never be assigned a value. */
	public final static ISymbol v = initFinalHiddenSymbol("v");
	/** Used to represent a formal parameter <code>w</code> that will never be assigned a value. */
	public final static ISymbol w = initFinalHiddenSymbol("w");
	/** Used to represent a formal parameter <code>x</code> that will never be assigned a value. */
	public final static ISymbol x = initFinalHiddenSymbol("x");
	/** Used to represent a formal parameter <code>y</code> that will never be assigned a value. */
	public final static ISymbol y = initFinalHiddenSymbol("y");
	/** Used to represent a formal parameter <code>z</code> that will never be assigned a value. */
	public final static ISymbol z = initFinalHiddenSymbol("z");

	public final static ISymbol ASymbol = initFinalHiddenSymbol("A");
	public final static ISymbol BSymbol = initFinalHiddenSymbol("B");
	public final static ISymbol CSymbol = initFinalHiddenSymbol("C"); // don't use constant BuiltinSymbol 'C' here
	public final static ISymbol FSymbol = initFinalHiddenSymbol("F");
	public final static ISymbol GSymbol = initFinalHiddenSymbol("G");
	public final static ISymbol PSymbol = initFinalHiddenSymbol("P");
	public final static ISymbol QSymbol = initFinalHiddenSymbol("Q");

	public final static IPattern a_ = initPredefinedPattern(a);
	public final static IPattern b_ = initPredefinedPattern(b);
	public final static IPattern c_ = initPredefinedPattern(c);
	public final static IPattern d_ = initPredefinedPattern(d);
	public final static IPattern e_ = initPredefinedPattern(e);
	public final static IPattern f_ = initPredefinedPattern(f);
	public final static IPattern g_ = initPredefinedPattern(g);
	public final static IPattern h_ = initPredefinedPattern(h);
	public final static IPattern i_ = initPredefinedPattern(i);
	public final static IPattern j_ = initPredefinedPattern(j);
	public final static IPattern k_ = initPredefinedPattern(k);
	public final static IPattern l_ = initPredefinedPattern(l);
	public final static IPattern m_ = initPredefinedPattern(m);
	public final static IPattern n_ = initPredefinedPattern(n);
	public final static IPattern o_ = initPredefinedPattern(o);
	public final static IPattern p_ = initPredefinedPattern(p);
	public final static IPattern q_ = initPredefinedPattern(q);
	public final static IPattern r_ = initPredefinedPattern(r);
	public final static IPattern s_ = initPredefinedPattern(s);
	public final static IPattern t_ = initPredefinedPattern(t);
	public final static IPattern u_ = initPredefinedPattern(u);
	public final static IPattern v_ = initPredefinedPattern(v);
	public final static IPattern w_ = initPredefinedPattern(w);
	public final static IPattern x_ = initPredefinedPattern(x);
	public final static IPattern y_ = initPredefinedPattern(y);
	public final static IPattern z_ = initPredefinedPattern(z);

	public final static IPatternSequence x__ = initPredefinedPatternSequence(x);
	public final static IPatternSequence y__ = initPredefinedPatternSequence(y);
	public final static IPatternSequence z__ = initPredefinedPatternSequence(z);

	public final static IPattern A_ = initPredefinedPattern(ASymbol);
	public final static IPattern B_ = initPredefinedPattern(BSymbol);
	public final static IPattern C_ = initPredefinedPattern(CSymbol);
	public final static IPattern F_ = initPredefinedPattern(FSymbol);
	public final static IPattern G_ = initPredefinedPattern(GSymbol);
	public final static IPattern P_ = initPredefinedPattern(PSymbol);
	public final static IPattern Q_ = initPredefinedPattern(QSymbol);

	public final static IPattern m_Integer = new Pattern(m, F.Integer);
	public final static IPattern n_Integer = new Pattern(n, F.Integer);

	public final static IPattern a_Symbol = new Pattern(a, F.Symbol);
	public final static IPattern b_Symbol = new Pattern(b, F.Symbol);
	public final static IPattern c_Symbol = new Pattern(c, F.Symbol);
	public final static IPattern d_Symbol = new Pattern(d, F.Symbol);
	public final static IPattern e_Symbol = new Pattern(e, F.Symbol);
	public final static IPattern f_Symbol = new Pattern(f, F.Symbol);
	public final static IPattern g_Symbol = new Pattern(g, F.Symbol);
	public final static IPattern h_Symbol = new Pattern(h, F.Symbol);
	public final static IPattern i_Symbol = new Pattern(i, F.Symbol);
	public final static IPattern j_Symbol = new Pattern(j, F.Symbol);
	public final static IPattern k_Symbol = new Pattern(k, F.Symbol);
	public final static IPattern l_Symbol = new Pattern(l, F.Symbol);
	public final static IPattern m_Symbol = new Pattern(m, F.Symbol);
	public final static IPattern n_Symbol = new Pattern(n, F.Symbol);
	public final static IPattern o_Symbol = new Pattern(o, F.Symbol);
	public final static IPattern p_Symbol = new Pattern(p, F.Symbol);
	public final static IPattern q_Symbol = new Pattern(q, F.Symbol);
	public final static IPattern r_Symbol = new Pattern(r, F.Symbol);
	public final static IPattern s_Symbol = new Pattern(s, F.Symbol);
	public final static IPattern t_Symbol = new Pattern(t, F.Symbol);
	public final static IPattern u_Symbol = new Pattern(u, F.Symbol);
	public final static IPattern v_Symbol = new Pattern(v, F.Symbol);
	public final static IPattern w_Symbol = new Pattern(w, F.Symbol);
	public final static IPattern x_Symbol = new Pattern(x, F.Symbol);
	public final static IPattern y_Symbol = new Pattern(y, F.Symbol);
	public final static IPattern z_Symbol = new Pattern(z, F.Symbol);

	public final static IPattern a_DEFAULT = new Pattern(a, null, true);
	public final static IPattern b_DEFAULT = new Pattern(b, null, true);
	public final static IPattern c_DEFAULT = new Pattern(c, null, true);
	public final static IPattern d_DEFAULT = new Pattern(d, null, true);
	public final static IPattern e_DEFAULT = new Pattern(e, null, true);
	public final static IPattern f_DEFAULT = new Pattern(f, null, true);
	public final static IPattern g_DEFAULT = new Pattern(g, null, true);
	public final static IPattern h_DEFAULT = new Pattern(h, null, true);
	public final static IPattern i_DEFAULT = new Pattern(i, null, true);
	public final static IPattern j_DEFAULT = new Pattern(j, null, true);
	public final static IPattern k_DEFAULT = new Pattern(k, null, true);
	public final static IPattern l_DEFAULT = new Pattern(l, null, true);
	public final static IPattern m_DEFAULT = new Pattern(m, null, true);
	public final static IPattern n_DEFAULT = new Pattern(n, null, true);
	public final static IPattern o_DEFAULT = new Pattern(o, null, true);
	public final static IPattern p_DEFAULT = new Pattern(p, null, true);
	public final static IPattern q_DEFAULT = new Pattern(q, null, true);
	public final static IPattern r_DEFAULT = new Pattern(r, null, true);
	public final static IPattern s_DEFAULT = new Pattern(s, null, true);
	public final static IPattern t_DEFAULT = new Pattern(t, null, true);
	public final static IPattern u_DEFAULT = new Pattern(u, null, true);
	public final static IPattern v_DEFAULT = new Pattern(v, null, true);
	public final static IPattern w_DEFAULT = new Pattern(w, null, true);
	public final static IPattern x_DEFAULT = new Pattern(x, null, true);
	public final static IPattern y_DEFAULT = new Pattern(y, null, true);
	public final static IPattern z_DEFAULT = new Pattern(z, null, true);

	public final static IPattern A_DEFAULT = new Pattern(ASymbol, null, true);
	public final static IPattern B_DEFAULT = new Pattern(BSymbol, null, true);
	public final static IPattern C_DEFAULT = new Pattern(CSymbol, null, true);
	public final static IPattern F_DEFAULT = new Pattern(FSymbol, null, true);
	public final static IPattern G_DEFAULT = new Pattern(GSymbol, null, true);
	public final static IPattern P_DEFAULT = new Pattern(PSymbol, null, true);
	public final static IPattern Q_DEFAULT = new Pattern(QSymbol, null, true);
	/**
	 * Constant integer &quot;0&quot;
	 */
	public final static IInteger C0 = AbstractIntegerSym.valueOf(0);

	/**
	 * Constant integer &quot;1&quot;
	 */
	public final static IInteger C1 = AbstractIntegerSym.valueOf(1);

	/**
	 * Constant integer &quot;2&quot;
	 */
	public final static IInteger C2 = AbstractIntegerSym.valueOf(2);

	/**
	 * Constant integer &quot;3&quot;
	 */
	public final static IInteger C3 = AbstractIntegerSym.valueOf(3);

	/**
	 * Constant integer &quot;4&quot;
	 */
	public final static IInteger C4 = AbstractIntegerSym.valueOf(4);

	/**
	 * Constant integer &quot;5&quot;
	 */
	public final static IInteger C5 = AbstractIntegerSym.valueOf(5);

	/**
	 * Constant integer &quot;6&quot;
	 */
	public final static IInteger C6 = AbstractIntegerSym.valueOf(6);

	/**
	 * Constant integer &quot;7&quot;
	 */
	public final static IInteger C7 = AbstractIntegerSym.valueOf(7);

	/**
	 * Constant integer &quot;8&quot;
	 */
	public final static IInteger C8 = AbstractIntegerSym.valueOf(8);

	/**
	 * Constant integer &quot;9&quot;
	 */
	public final static IInteger C9 = AbstractIntegerSym.valueOf(9);

	/**
	 * Constant integer &quot;10&quot;
	 */
	public final static IInteger C10 = AbstractIntegerSym.valueOf(10);

	/**
	 * Complex imaginary unit. The parsed symbol &quot;I&quot; is converted on input to this constant.
	 */
	public final static IComplex CI = ComplexSym.valueOf(0, 1, 1, 1);

	/**
	 * Complex negative imaginary unit.
	 */
	public final static IComplex CNI = ComplexSym.valueOf(0, 1, -1, 1);

	/**
	 * Constant fraction &quot;1/2&quot;
	 */
	public final static IFraction C1D2 = AbstractFractionSym.valueOf(1, 2);

	/**
	 * Constant fraction &quot;3/2&quot;
	 */
	public final static IFraction C3D2 = AbstractFractionSym.valueOf(3, 2);

	/**
	 * Constant fraction &quot;3/4&quot;
	 */
	public final static IFraction C3D4 = AbstractFractionSym.valueOf(3, 4);

	/**
	 * Constant fraction &quot;5/2&quot;
	 */
	public final static IFraction C5D2 = AbstractFractionSym.valueOf(5, 2);

	/**
	 * Constant fraction &quot;-1/2&quot;
	 */
	public final static IFraction CN1D2 = AbstractFractionSym.valueOf(-1, 2);

	/**
	 * Constant fraction &quot;-3/2&quot;
	 */
	public final static IFraction CN3D2 = AbstractFractionSym.valueOf(-3, 2);

	/**
	 * Constant fraction &quot;1/3&quot;
	 */
	public final static IFraction C1D3 = AbstractFractionSym.valueOf(1, 3);
    /**
	 * Constant fraction &quot;-1/3&quot;
     */
	public final static IFraction CN1D3 = AbstractFractionSym.valueOf(-1, 3);

	/**
	 * Constant fraction &quot;1/4&quot;
	 */
	public final static IFraction C1D4 = AbstractFractionSym.valueOf(1, 4);
    /**
	 * Constant fraction &quot;-1/4&quot;
     */
	public final static IFraction CN1D4 = AbstractFractionSym.valueOf(-1, 4);
    /**
	 * Constant double &quot;-1.0&quot;
     */
	public final static Num CND1 = new Num(-1.0);

	/**
	 * Constant double &quot;0.0&quot;
	 */
	public final static Num CD0 = new Num(0.0);

	/**
	 * Constant double &quot;1.0&quot;
	 */
	public final static Num CD1 = new Num(1.0);
	/**
	 * Represents the empty Smyja string <code>""</code>
	 */
	public static IStringX CEmptyString;

    /**
     * Represents <code>List()</code> (i.e. the constant empty list)
     */
    public static IAST CEmptyList;
    /**
     * Represents <code>List(0)</code>
     */
    public static IAST CListC0;
    /**
     * Represents <code>List(1)</code>
     */
    public static IAST CListC1;
	/**
	 * Represents <code>List(-1)</code>
	 */
	public static IAST CListCN1;
    /**
     * Represents <code>List(1,1)</code>
     */
    public static IAST CListC1C1;
    /**
     * Represents <code>List(1,2)</code>
     */
    public static IAST CListC1C2;
    /**
     * Represents <code>List(2)</code>
     */
    public static IAST CListC2;
    /**
     * Represents <code>List(2,1)</code>
     */
    public static IAST CListC2C1;
    /**
     * Represents <code>List(2,2)</code>
     */
    public static IAST CListC2C2;
    /**
     * Represents <code>Infinity</code> (i.e. <code>Infinity-&gt;DirectedInfinity(1)</code>)
     */
    public static IAST CInfinity;
	/**
	 * Represents <code>Return(False)</code>
	 */
	public static IAST CReturnFalse;

	/**
	 * Represents <code>Return(True)</code>
	 */
	public static IAST CReturnTrue;

	/**
	 * Represents <code>Throw(False)</code>
	 */
	public static IAST CThrowFalse;

	/**
	 * Represents <code>Throw(True)</code>
	 */
	public static IAST CThrowTrue;
    /**
     * Alias for CInfinity. Represents <code>Infinity</code> (i.e. <code>Infinity-&gt;DirectedInfinity(1)</code>)
     */
    public static IAST oo;
    /**
     * Represents <code>-Infinity</code> (i.e. <code>-Infinity-&gt;DirectedInfinity(-1)</code>)
     */
    public static IAST CNInfinity;
    /**
     * Alias for CNInfinity. Represents <code>-Infinity</code> (i.e. <code>-Infinity-&gt;DirectedInfinity(-1)</code>)
     */
    public static IAST Noo;
    /**
     * Represents <code>I*Infinity</code> (i.e. <code>I*Infinity-&gt;DirectedInfinity(I)</code>)
     */
    public static IAST CIInfinity;
    /**
     * Represents <code>-I*Infinity</code> (i.e. <code>-I*Infinity-&gt;DirectedInfinity(-I)</code>)
     */
    public static IAST CNIInfinity;
    /**
     * Represents <code>ComplexInfinity</code> (i.e. <code>ComplexInfinity-&gt;DirectedInfinity()</code>)
     */
    public static IAST CComplexInfinity;
	/**
	 * Represents <code>-Pi</code> as Symja expression <code>Times(CN1, Pi)</code>
	 */
	public static IAST CNPi;

	/**
	 * Represents <code>-2*Pi</code> as Symja expression <code>Times(CN2, Pi)</code>
	 */
	public static IAST CN2Pi;

	/**
	 * Represents <code>2*Pi</code> as Symja expression <code>Times(C2, Pi)</code>
	 */
	public static IAST C2Pi;
    /**
     * Represents <code>-Pi/2</code> as Symja expression <code>Times(CN1D2, Pi)</code>
     */
    public static IAST CNPiHalf;
    /**
     * Represents <code>Pi/2</code> as Symja expression <code>Times(C1D2, Pi)</code>
     */
    public static IAST CPiHalf;
    /**
     * Represents <code>Sqrt(2)</code>
     */
    public static IAST CSqrt2;
    /**
     * Represents <code>Sqrt(3)</code>
     */
    public static IAST CSqrt3;
    /**
     * Represents <code>Sqrt(5)</code>
     */
    public static IAST CSqrt5;
    /**
     * Represents <code>Sqrt(6)</code>
     */
    public static IAST CSqrt6;
    /**
     * Represents <code>Sqrt(7)</code>
     */
    public static IAST CSqrt7;
    /**
     * Represents <code>Sqrt(10)</code>
     */
    public static IAST CSqrt10;
    /**
     * Represents <code>1/Sqrt(2)</code>
     */
    public static IAST C1DSqrt2;
    /**
     * Represents <code>1/Sqrt(3)</code>
     */
    public static IAST C1DSqrt3;
    /**
     * Represents <code>1/Sqrt(5)</code>
     */
    public static IAST C1DSqrt5;
    /**
     * Represents <code>1/Sqrt(6)</code>
     */
    public static IAST C1DSqrt6;
    /**
     * Represents <code>1/Sqrt(7)</code>
     */
    public static IAST C1DSqrt7;
    /**
     * Represents <code>1/Sqrt(10)</code>
     */
    public static IAST C1DSqrt10;
    /**
     * Represents <code>#1</code>
     */
    public static IAST Slot1;
    /**
     * Represents <code>#2</code>
     */
    public static IAST Slot2;
	/**
	 * Represents <code>#3</code>
	 */
	public static IAST Slot3;
	/**
	 * Constant integer &quot;-1&quot;
	 */
	public final static IInteger CN1 = AbstractIntegerSym.valueOf(-1);

	/**
	 * Constant integer &quot;-2&quot;
	 */
	public final static IInteger CN2 = AbstractIntegerSym.valueOf(-2);

	/**
	 * Constant integer &quot;-3&quot;
	 */
	public final static IInteger CN3 = AbstractIntegerSym.valueOf(-3);

	/**
	 * Constant integer &quot;-4&quot;
	 */
	public final static IInteger CN4 = AbstractIntegerSym.valueOf(-4);

	/**
	 * Constant integer &quot;-5&quot;
	 */
	public final static IInteger CN5 = AbstractIntegerSym.valueOf(-5);

	/**
	 * Constant integer &quot;-6&quot;
	 */
	public final static IInteger CN6 = AbstractIntegerSym.valueOf(-6);

	/**
	 * Constant integer &quot;-7&quot;
	 */
	public final static IInteger CN7 = AbstractIntegerSym.valueOf(-7);

	/**
	 * Constant integer &quot;-8&quot;
	 */
	public final static IInteger CN8 = AbstractIntegerSym.valueOf(-8);

	/**
	 * Constant integer &quot;-9&quot;
	 */
	public final static IInteger CN9 = AbstractIntegerSym.valueOf(-9);

	/**
	 * Constant integer &quot;-10&quot;
	 */
	public final static IInteger CN10 = AbstractIntegerSym.valueOf(-10);

    public static Map<ISymbol, IExpr> UNARY_INVERSE_FUNCTIONS = new IdentityHashMap<ISymbol, IExpr>();
    public static ISymbol[] DENOMINATOR_NUMERATOR_SYMBOLS = null;
    public static IExpr[] DENOMINATOR_TRIG_TRUE_EXPRS = null;
    public static ISymbol[] NUMERATOR_NUMERATOR_SYMBOLS = null;
    public static IExpr[] NUMERATOR_TRIG_TRUE_EXPRS = null;

	private final static CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(1);

	/**
	 * Causes the current thread to wait until the main initialization has finished.
	 *
	 */
	public final static void await() throws InterruptedException {
		COUNT_DOWN_LATCH.await();
	}
    static {
        try {
            // long start = System.currentTimeMillis();
            // System.out.println("Start");
            AST2Expr.initialize();
			ExprParserFactory.initialize();

			PreemptStatus.setNotAllow();
            ComputerThreads.NO_THREADS = Config.JAS_NO_THREADS;

            ApfloatContext ctx = ApfloatContext.getContext();
            ctx.setNumberOfProcessors(1);

            Slot.setAttributes(ISymbol.NHOLDALL);
            Slot.setEvaluator(ICoreFunctionEvaluator.ARGS_EVALUATOR);
            SlotSequence.setAttributes(ISymbol.NHOLDALL);
            SlotSequence.setEvaluator(ICoreFunctionEvaluator.ARGS_EVALUATOR);
			PatternTest.setAttributes(ISymbol.HOLDREST);
			List.setEvaluator(ICoreFunctionEvaluator.ARGS_EVALUATOR);

            CEmptyList = headAST0(List);
			CEmptyString = $str("");
			CListC0 = new B1.List(C0);
			CListC1 = new B1.List(C1);
			CListC2 = new B1.List(C2);
			CListCN1 = new B1.List(CN1);

			CListC1C1 = new B2.List(C1, C1);
			CListC1C2 = new B2.List(C1, C2);
			CListC2C1 = new B2.List(C2, C1);
			CListC2C2 = new B2.List(C2, C2);

			CReturnFalse = new B1.Return(False);
			CReturnTrue = new B1.Return(True);
			CThrowFalse = new B1.Throw(False);
			CThrowTrue = new B1.Throw(True);
            CInfinity = unaryAST1(DirectedInfinity, C1);
            oo = CInfinity;
            CNInfinity = unaryAST1(DirectedInfinity, CN1);
            Noo = CNInfinity;
            CIInfinity = unaryAST1(DirectedInfinity, CI);
            CNIInfinity = unaryAST1(DirectedInfinity, CNI);
            CComplexInfinity = headAST0(DirectedInfinity);

			CNPi = new B2.Times(CN1, Pi);
			CN2Pi = new B2.Times(CN2, Pi);
			C2Pi = new B2.Times(C2, Pi);
			CNPiHalf = new B2.Times(CN1D2, Pi);
			CPiHalf = new B2.Times(C1D2, Pi);

			CSqrt2 = new B2.Power(C2, C1D2);
			CSqrt3 = new B2.Power(C3, C1D2);
			CSqrt5 = new B2.Power(C5, C1D2);
			CSqrt6 = new B2.Power(C6, C1D2);
			CSqrt7 = new B2.Power(C7, C1D2);
			CSqrt10 = new B2.Power(C10, C1D2);

			C1DSqrt2 = new B2.Power(C2, CN1D2);
			C1DSqrt3 = new B2.Power(C3, CN1D2);
			C1DSqrt5 = new B2.Power(C5, CN1D2);
			C1DSqrt6 = new B2.Power(C6, CN1D2);
			C1DSqrt7 = new B2.Power(C7, CN1D2);
			C1DSqrt10 = new B2.Power(C10, CN1D2);

            Slot1 = unaryAST1(Slot, C1);
            Slot2 = unaryAST1(Slot, C2);
			Slot3 = unaryAST1(Slot, C3);

			COMMON_IDS = new IExpr[] { CN1, CN2, CN3, CN4, CN5, CN6, CN7, CN8, CN9, CN10, C0, C1, C2, C3, C4, C5, C6,
                    C7, C8, C9, C10, CI, CNI, C1D2, CN1D2, C1D3, CN1D3, C1D4, CN1D4, CD0, CD1, CInfinity, CNInfinity,
                    CComplexInfinity, CSqrt2, CSqrt3, CSqrt5, CSqrt6, CSqrt7, CSqrt10, C1DSqrt2, C1DSqrt3, C1DSqrt5,
                    C1DSqrt6, C1DSqrt7, C1DSqrt10, Slot1, Slot2,
                    // start symbols
                    a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, ASymbol, BSymbol,
                    CSymbol, FSymbol, GSymbol,
                    // start pattern
                    a_, b_, c_, d_, e_, f_, g_, h_, i_, j_, k_, l_, m_, n_, o_, p_, q_, r_, s_, t_, u_, v_, w_, x_, y_,
                    z_, A_, B_, C_, F_, G_, a_Symbol, b_Symbol, c_Symbol, d_Symbol, e_Symbol, f_Symbol, g_Symbol,
                    h_Symbol, i_Symbol, j_Symbol, k_Symbol, l_Symbol, m_Symbol, n_Symbol, o_Symbol, p_Symbol, q_Symbol,
                    r_Symbol, s_Symbol, t_Symbol, u_Symbol, v_Symbol, w_Symbol, x_Symbol, y_Symbol, z_Symbol, a_DEFAULT,
                    b_DEFAULT, c_DEFAULT, d_DEFAULT, e_DEFAULT, f_DEFAULT, g_DEFAULT, h_DEFAULT, i_DEFAULT, j_DEFAULT,
                    k_DEFAULT, l_DEFAULT, m_DEFAULT, n_DEFAULT, o_DEFAULT, p_DEFAULT, q_DEFAULT, r_DEFAULT, s_DEFAULT,
                    t_DEFAULT, u_DEFAULT, v_DEFAULT, w_DEFAULT, x_DEFAULT, y_DEFAULT, z_DEFAULT, A_DEFAULT, B_DEFAULT,
                    C_DEFAULT, F_DEFAULT, G_DEFAULT,
                    // start symbol strings
					// Algebraics, Booleans, ComplexInfinity, Catalan, Complexes, Degree, EulerGamma, False, Flat,
					// Glaisher, GoldenRatio, HoldAll, HoldFirst, HoldForm, HoldRest, Indeterminate, Infinity, Integer,
					// Integers, Khinchin, Listable, Modulus, Null, NumericFunction, OneIdentity, Orderless, Pi, Primes,
					// Rationals, Real, Reals, Slot, SlotSequence, String, F.Symbol, True,
					// // start function strings
					// Abs, AddTo, And, Alternatives, Apart, AppellF1, Append, AppendTo, Apply, ArcCos, ArcCosh, ArcCot,
					// ArcCoth, ArcCsc, ArcCsch, ArcSec, ArcSech, ArcSin, ArcSinh, ArcTan, ArcTanh, Arg, Array,
					// // ArrayDepth,
					// ArrayQ, Assumptions, AtomQ, Attributes,
					// // BernoulliB,
					// Binomial, Blank, Block, Boole,
					// // BooleanConvert,
					// BooleanMinimize, Break, Cancel, CartesianProduct, Cases, CatalanNumber, Catch, Ceiling,
					// CharacteristicPolynomial,
					// // ChebyshevT,
					// ChessboardDistance, Chop, Clear, ClearAll, Coefficient, CoefficientList, Collect, Complement,
					// Complex,
					// // ComplexExpand,
					// ComplexInfinity, ComposeList, CompoundExpression, Condition, Conjugate, ConjugateTranspose,
					// ConstantArray, Continue, ContinuedFraction, CoprimeQ, Cos, Cosh, CosIntegral, CoshIntegral, Cot,
					// Coth, Count, Cross, Csc, Csch, Curl, Decrement, Default, Defer, Definition, Delete, DeleteCases,
					// // DeleteDuplicates,
					// Denominator, Depth, Derivative, Det, DiagonalMatrix, DigitQ, Dimensions, DirectedInfinity,
					// Discriminant, Distribute, Div, DivideBy, Divisible,
					// // Divisors,
					// Do, Dot, Drop, Eigenvalues, Eigenvectors, Element,
					// // Eliminate,
					// EllipticE, EllipticF, EllipticPi, Equal, Equivalent, Erf, Erfc, Erfi, EuclideanDistance,
					// // EulerE,
					// EulerPhi, EvenQ, Exp, Expand, ExpandAll, ExpIntegralE, ExpIntegralEi, Exponent, ExtendedGCD,
					// Extract, Factor, Factorial, Factorial2, FactorInteger, FactorSquareFree, FactorSquareFreeList,
					// FactorTerms, Flatten, Fibonacci, FindRoot, First, Fit, FixedPoint, Floor, Fold, FoldList, For,
					// FractionalPart, FreeQ, FresnelC, FresnelS, FrobeniusSolve, FromCharacterCode,
					// FromContinuedFraction,
					// FullForm, FullSimplify, Function, Gamma, GCD, GeometricMean, Graphics, Graphics3D, Graphics3D,
					// Greater, GreaterEqual, GroebnerBasis, HarmonicNumber, Head,
					// // HermiteH,
					// HilbertMatrix, Hold, HoldForm, Horner,
					// // HornerForm,
					// HurwitzZeta, HypergeometricPFQ, Hypergeometric2F1, Identity, IdentityMatrix, If, Im, Implies,
					// Increment, Inner, Insert, IntegerPart, IntegerPartitions, IntegerQ, Integrate,
					// // InterpolatingFunction, InterpolatingPolynomial,
					// Intersection, Inverse, InverseErf, InverseFunction, JacobiMatrix, JacobiSymbol, JavaForm, Join,
					// KOrderlessPartitions, KPartitions, LaplaceTransform, Last, LCM, LeafCount,
					// // LaguerreL, LegendreP,
					// Length, Less, LessEqual, LetterQ, Level, Limit, Line, LinearProgramming, LinearSolve, List,
					// ListQ,
					// Log,
					// // Log2, Log10,
					// LogGamma,
					// // LogicalExpand,
					// LogIntegral, LowerCaseQ, LUDecomposition, ManhattanDistance, Map, MapAll, MapThread, MatchQ,
					// MathMLForm,
					// // MatrixForm,
					// MatrixPower, MatrixQ,
					// // MatrixRank,
					// Max, Mean, Median, MemberQ, Min, Mod, Module, MoebiusMu,
					// // MonomialList,
					// Most, Multinomial, Nand, Negative, Nest, NestList, NestWhile, NestWhileList, NextPrime,
					// NFourierTransform, NIntegrate,
					// // NMaximize, NMinimize,
					// NonCommutativeMultiply, NonNegative, Nor, Norm, Not, NRoots, NSolve,
					// // NullSpace,
					// NumberQ, Numerator, NumericQ, OddQ, Options, Or, Order, OrderedQ, Out, Outer, PadLeft, PadRight,
					// // ParametricPlot,
					// Part, Partition, Pattern, Permutations, Piecewise, Plot, Plot3D, Plus,
					// // Pochhammer,
					// PolyGamma, PolyLog, PolynomialExtendedGCD, PolynomialGCD, PolynomialLCM, PolynomialQ,
					// PolynomialQuotient, PolynomialQuotientRemainder, PolynomialRemainder, Position, Positive,
					// PossibleZeroQ, Power, PowerExpand, PowerMod, PreDecrement, PreIncrement, Prepend, PrependTo,
					// // Prime,
					// PrimeQ, PrimitiveRootList, Print, Product, ProductLog, Quiet, Quotient, RandomInteger,
					// RandomReal,
					// // RandomSample,
					// Range, Rational, Rationalize, Re, Reap, Refine, ReplaceAll, ReplacePart, ReplaceRepeated, Rest,
					// Resultant, Return, Reverse, Riffle, RootIntervals, RootOf, Roots, Surd, RotateLeft, RotateRight,
					// Round,
					// // RowReduce,
					// Rule, RuleDelayed, SameQ, Scan, Sec, Sech, Select, Sequence, Set, SetAttributes, SetDelayed,
					// Show,
					// Sign, SignCmp, Simplify, Sin, Sinc, SingularValueDecomposition, Sinh, SinIntegral, SinhIntegral,
					// Solve, Sort, Sow, Sqrt, SquaredEuclideanDistance, SquareFreeQ, StirlingS2, StringDrop,
					// StringJoin,
					// StringLength, StringTake, Subfactorial, Subscript, Subsuperscript, Subsets, SubtractFrom, Sum,
					// Superscript, Switch, SyntaxLength, SyntaxQ, Table, Take, Tan, Tanh, Taylor, TeXForm, Thread,
					// Through, Throw, TimeConstrained, Times, TimesBy, Timing, ToCharacterCode, Together, ToString,
					// Total,
					// ToUnicode, Tr, Trace, Transpose, TrigExpand, TrigReduce, TrigToExp, TrueQ,
					// // Tuples,
					// Unequal, Unevaluated, Union, Unique, UnitStep,
					// // UnitVector,
					// UnsameQ, UpperCaseQ, UpSet, UpSetDelayed, ValueQ, VandermondeMatrix, Variables, VectorQ, Which,
					// While, Xor,
					// // Zeta
			};
			short exprID = EXPRID_MAX_BUILTIN_LENGTH;
			GLOBAL_IDS_MAP.defaultReturnValue((short) -1);
			for (short i = 0; i < COMMON_IDS.length; i++) {
				GLOBAL_IDS_MAP.put(COMMON_IDS[i], exprID++);
            }

            PREDEFINED_INTERNAL_FORM_STRINGS.put("Pi", "Pi");
            PREDEFINED_INTERNAL_FORM_STRINGS.put("E", "E");
            PREDEFINED_INTERNAL_FORM_STRINGS.put("False", "False");
            PREDEFINED_INTERNAL_FORM_STRINGS.put("True", "True");
            PREDEFINED_INTERNAL_FORM_STRINGS.put("Null", "Null");
            PREDEFINED_INTERNAL_FORM_STRINGS.put("Integer", "IntegerHead");
            PREDEFINED_INTERNAL_FORM_STRINGS.put("Symbol", "SymbolHead");
            PREDEFINED_INTERNAL_FORM_STRINGS.put("Infinity", "CInfinity");
            PREDEFINED_INTERNAL_FORM_STRINGS.put("ComplexInfinity", "CComplexInfinity");
            PREDEFINED_INTERNAL_FORM_STRINGS.put("Plus", "Plus");
            PREDEFINED_INTERNAL_FORM_STRINGS.put("Power", "Power");
            PREDEFINED_INTERNAL_FORM_STRINGS.put("Times", "Times");

            Arithmetic.initialize();
            PredicateQ.initialize();
            AttributeFunctions.initialize();

            createInverseFunctionMap();
            createDenominatorFunctionMap();
            createNumeratorFunctionMap();

            ConstantDefinitions.initialize();
            FunctionDefinitions.initialize();
            IOFunctions.initialize();
            Programming.initialize();
            PatternMatching.initialize();
            Algebra.initialize();
			SimplifyFunctions.initialize();
			StructureFunctions.initialize();
            ExpTrigsFunctions.initialize();
            NumberTheory.initialize();
            BooleanFunctions.initialize();
            LinearAlgebra.initialize();
            TensorFunctions.initialize();
            ListFunctions.initialize();
            Combinatoric.initialize();
            IntegerFunctions.initialize();
			BesselFunctions.initialize();
            SpecialFunctions.initialize();
            StringFunctions.initialize();
            OutputFunctions.initialize();
            RandomFunctions.initialize();
            StatisticsFunctions.initialize();
            HypergeometricFunctions.initialize();
            EllipticIntegrals.initialize();
            PolynomialFunctions.initialize();
            SeriesFunctions.initialize();
            AssumptionFunctions.initialize();
			ContainsFunctions.initialize();
            CurveFitterFunctions.initialize();
            VectorAnalysisFunctions.initialize();
            QuantityFunctions.initialize();
			IntervalFunctions.initialize();
			FinancialFunctions.initialize();
            WXFFunctions.initialize();
            WindowFunctions.initialize();
			MinMaxFunctions.initialize();
			GraphFunctions.initialize();
			GraphDataFunctions.initialize();
			AssociationFunctions.initialize();
			GeodesyFunctions.initialize();
			ManipulateFunction.initialize();
            ImageFunctions.initialize();
			EntityFunctions.initialize();
			ClusteringFunctions.initialize();
//			SourceCodeFunctions.initialize();
			SparseArrayFunctions.initialize();
//			UnitTestingFunctions.initialize();

			ComputationalGeometryFunctions.initialize();

			F.Integrate.setEvaluator(org.matheclipse.core.reflection.system.Integrate.CONST);
            COUNT_DOWN_LATCH.countDown();
            // long stop = System.currentTimeMillis();
            // System.out.println("Milliseconds: " + (stop - start));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }


    private static void createNumeratorFunctionMap() {
        NUMERATOR_NUMERATOR_SYMBOLS = new ISymbol[6];
        NUMERATOR_NUMERATOR_SYMBOLS[0] = Sin;
        NUMERATOR_NUMERATOR_SYMBOLS[1] = Cos;
        NUMERATOR_NUMERATOR_SYMBOLS[2] = Tan;
        NUMERATOR_NUMERATOR_SYMBOLS[3] = Csc;
        NUMERATOR_NUMERATOR_SYMBOLS[4] = Sec;
        NUMERATOR_NUMERATOR_SYMBOLS[5] = Cot;
        NUMERATOR_TRIG_TRUE_EXPRS = new IExpr[6];
        NUMERATOR_TRIG_TRUE_EXPRS[0] = Sin;
        NUMERATOR_TRIG_TRUE_EXPRS[1] = Cos;
        NUMERATOR_TRIG_TRUE_EXPRS[2] = Sin;
        NUMERATOR_TRIG_TRUE_EXPRS[3] = C1;
        NUMERATOR_TRIG_TRUE_EXPRS[4] = C1;
        NUMERATOR_TRIG_TRUE_EXPRS[5] = Cos;
    }

    private static void createDenominatorFunctionMap() {
        DENOMINATOR_NUMERATOR_SYMBOLS = new ISymbol[6];
        DENOMINATOR_NUMERATOR_SYMBOLS[0] = F.Sin;
        DENOMINATOR_NUMERATOR_SYMBOLS[1] = F.Cos;
        DENOMINATOR_NUMERATOR_SYMBOLS[2] = F.Tan;
        DENOMINATOR_NUMERATOR_SYMBOLS[3] = F.Csc;
        DENOMINATOR_NUMERATOR_SYMBOLS[4] = F.Sec;
        DENOMINATOR_NUMERATOR_SYMBOLS[5] = F.Cot;
        DENOMINATOR_TRIG_TRUE_EXPRS = new IExpr[6];
        DENOMINATOR_TRIG_TRUE_EXPRS[0] = F.C1;
        DENOMINATOR_TRIG_TRUE_EXPRS[1] = F.C1;
        DENOMINATOR_TRIG_TRUE_EXPRS[2] = F.Cos;
        DENOMINATOR_TRIG_TRUE_EXPRS[3] = F.Sin;
        DENOMINATOR_TRIG_TRUE_EXPRS[4] = F.Cos;
        DENOMINATOR_TRIG_TRUE_EXPRS[5] = F.Sin;
    }

    private static void createInverseFunctionMap() {
        UNARY_INVERSE_FUNCTIONS.put(Abs, Function(Times(CN1, Slot1)));
		UNARY_INVERSE_FUNCTIONS.put(ProductLog, Function(Times(Slot1, Power(E, Slot1))));
        UNARY_INVERSE_FUNCTIONS.put(Cos, ArcCos);
        UNARY_INVERSE_FUNCTIONS.put(Cot, ArcCot);
        UNARY_INVERSE_FUNCTIONS.put(Csc, ArcCsc);
        UNARY_INVERSE_FUNCTIONS.put(Sec, ArcSec);
        UNARY_INVERSE_FUNCTIONS.put(Sin, ArcSin);
        UNARY_INVERSE_FUNCTIONS.put(Tan, ArcTan);

        UNARY_INVERSE_FUNCTIONS.put(ArcCos, Cos);
        UNARY_INVERSE_FUNCTIONS.put(ArcCot, Cot);
        UNARY_INVERSE_FUNCTIONS.put(ArcCsc, Csc);
        UNARY_INVERSE_FUNCTIONS.put(ArcSec, Sec);
        UNARY_INVERSE_FUNCTIONS.put(ArcSin, Sin);
        UNARY_INVERSE_FUNCTIONS.put(ArcTan, Tan);
        UNARY_INVERSE_FUNCTIONS.put(Cosh, ArcCosh);
        UNARY_INVERSE_FUNCTIONS.put(Coth, ArcCoth);
        UNARY_INVERSE_FUNCTIONS.put(Csch, ArcCsch);
        UNARY_INVERSE_FUNCTIONS.put(Sech, ArcSech);
        UNARY_INVERSE_FUNCTIONS.put(Sinh, ArcSinh);
        UNARY_INVERSE_FUNCTIONS.put(Tanh, ArcTanh);
        UNARY_INVERSE_FUNCTIONS.put(ArcCosh, Cosh);
        UNARY_INVERSE_FUNCTIONS.put(ArcCoth, Coth);
        UNARY_INVERSE_FUNCTIONS.put(ArcCsch, Csch);
        UNARY_INVERSE_FUNCTIONS.put(ArcSech, Sech);
        UNARY_INVERSE_FUNCTIONS.put(ArcSinh, Sinh);
        UNARY_INVERSE_FUNCTIONS.put(ArcTanh, Tanh);
        UNARY_INVERSE_FUNCTIONS.put(Log, Exp);
		UNARY_INVERSE_FUNCTIONS.put(Identity, Identity);

		UNARY_INVERSE_FUNCTIONS.put(Erf, InverseErf);
		UNARY_INVERSE_FUNCTIONS.put(Erfc, InverseErfc);

		UNARY_INVERSE_FUNCTIONS.put(InverseErf, Erf);
		UNARY_INVERSE_FUNCTIONS.put(InverseErfc, Erfc);
    }

	public static IBuiltInSymbol symbol(int id) {
		return BUILT_IN_SYMBOLS[id];
	}


	/**
	 * Convert the symbolName to lowercase (if <code>Config.PARSER_USE_LOWERCASE_SYMBOLS</code> is set) and insert a new
	 * Symbol in the <code>PREDEFINED_SYMBOLS_MAP</code>. The symbol is created using the given upper case string to use
	 * it as associated class name in package org.matheclipse.core.reflection.system.
	 *
	 * @param symbolName
	 *            the predefined symbol name in upper-case form
	 * @param ordinal
	 * @return
	 */
	public static IBuiltInSymbol initFinalSymbol(final String symbolName, int ordinal) {
		String str;
		if (FEConfig.PARSER_USE_LOWERCASE_SYMBOLS) {
			str = (symbolName.length() == 1) ? symbolName : symbolName.toLowerCase(Locale.US);
		} else {
			str = symbolName;
		}
		final IBuiltInSymbol temp = new BuiltInSymbol(str, ordinal);
		BUILT_IN_SYMBOLS[ordinal] = temp;
		org.matheclipse.core.expression.Context.SYSTEM.put(str, temp);
		GLOBAL_IDS_MAP.put(temp, (short) ordinal);
		return temp;
	}

	public static IExpr exprID(short id) {
		if (id >= EXPRID_MAX_BUILTIN_LENGTH) {
			return COMMON_IDS[id - EXPRID_MAX_BUILTIN_LENGTH];
		}
		return BUILT_IN_SYMBOLS[id];
	}
	/**
	 * Convert the symbolName to lowercase (if <code>Config.PARSER_USE_LOWERCASE_SYMBOLS</code> is set) and insert a new
	 * Symbol in the <code>PREDEFINED_SYMBOLS_MAP</code>. The symbol is created using the given upper case string to use
	 * it as associated class name in package org.matheclipse.core.reflection.system.
	 *
	 * @param symbolName
	 *            the predefined symbol name in upper-case form
	 * @return
	 */
	public static ISymbol initFinalHiddenSymbol(final String symbolName) {
		final ISymbol temp = new Symbol(symbolName, org.matheclipse.core.expression.Context.DUMMY);
		HIDDEN_SYMBOLS_MAP.put(symbolName, temp);
		return temp;
	}

    /**
     * Create a new abstract syntax tree (AST).
     *
	 * @param head
	 *            the header expression of the function. If the ast represents a function like
	 *            <code>f[x,y], Sin[x],...</code>, the <code>head</code> will be an instance of type ISymbol.
     * @param a
     * @return
     */
    public final static IASTMutable $(final IExpr head, final IExpr... a) {
        return ast(a, head);
    }


    /**
     * Create a <code>BlankSequence[condition]</code> pattern object for pattern-matching and term rewriting
     *
	 * @param condition
	 *            additional condition which should be checked in pattern-matching
     * @return IPattern
     */
    public static PatternSequence $bs(final IExpr condition) {
        return org.matheclipse.core.expression.PatternSequence.valueOf(null, condition, false);
    }

    /**
     * Create a <code>BlankNullSequence[condition]</code> pattern object for pattern-matching and term rewriting
     *
	 * @param condition
	 *            additional condition which should be checked in pattern-matching
     * @return IPattern
     */
    public static PatternSequence $bns(final IExpr condition) {
        return org.matheclipse.core.expression.PatternSequence.valueOf(null, condition, false);
    }

    /**
     * Create a <code>Blank[]</code> pattern object for pattern-matching and term rewriting
     *
     * @return IPattern
     */
    public static IPattern $b() {
        return org.matheclipse.core.expression.Blank.valueOf();
    }

    /**
     * Create a <code>Blank[condition]</code> pattern object for pattern-matching and term rewriting
     *
	 * @param condition
	 *            additional condition which should be checked in pattern-matching
     * @return IPattern
     */
    public static IPattern $b(final IExpr condition) {
        return org.matheclipse.core.expression.Blank.valueOf(condition);
    }

    /**
     * Create a <code>Blank[condition]</code> pattern object for pattern-matching and term rewriting
     *
	 * @param condition
	 *            additional condition which should be checked in pattern-matching
	 * @param def
	 *            if <code>true</code> use a default value in pattern-matching if an argument is optional
     * @return IPattern
     */
    public static IPattern $b(final IExpr condition, boolean def) {
        return new org.matheclipse.core.expression.Blank(condition, def);
    }


    /**
     * Create a <code>Pattern[]</code> pattern for pattern-matching and term rewriting
     *
     * @param symbol
     * @return IPattern
     */
    public static IPattern $p(@Nonnull final ISymbol symbol) {
        return org.matheclipse.core.expression.Pattern.valueOf(symbol);
    }

    /**
     * Create a pattern for pattern-matching and term rewriting
     *
     * @param symbol
	 * @param def
	 *            use a default value for this pattern if necessary
     * @return IPattern
     */
    public static IPattern $p(final ISymbol symbol, boolean def) {
        return $p(symbol, null, def);
    }

    /**
     * Create a pattern for pattern-matching and term rewriting
     *
     * @param symbol
	 * @param check
	 *            additional condition which should be checked in pattern-matching
     * @return IPattern
     */
    public static IPattern $p(final ISymbol symbol, final IExpr check) {
        return org.matheclipse.core.expression.Pattern.valueOf(symbol, check);
    }

    /**
     * Create a pattern for pattern-matching and term rewriting
     *
     * @param symbol
	 * @param check
	 *            additional condition which should be checked in pattern-matching
	 * @param def
	 *            if <code>true</code>, the pattern can match to a default value associated with the AST's head the
	 *            pattern is used in.
     * @return IPattern
     */
    public static IPattern $p(final ISymbol symbol, final IExpr check, final boolean def) {
        return org.matheclipse.core.expression.Pattern.valueOf(symbol, check, def);
    }


    /**
     * Create a pattern for pattern-matching and term rewriting
     *
     * @param symbolName
     * @return IPattern
     */
	public static IPattern $p(final String symbolName) {
        // if (symbolName == null) {
        // return org.matheclipse.core.expression.Pattern.valueOf(null);
        // }
        return org.matheclipse.core.expression.Pattern.valueOf($s(symbolName));
    }

    /**
     * Create a pattern for pattern-matching and term rewriting
     *
     * @param symbolName
	 * @param def
	 *            use a default value for this pattern if necessary
     * @return IPattern
     */
    public static IPattern $p(final String symbolName, boolean def) {
        return $p($s(symbolName), null, def);
    }

    /**
     * Create a pattern for pattern-matching and term rewriting
     *
     * @param symbolName
	 * @param check
	 *            additional condition which should be checked in pattern-matching
     * @return IPattern
     */
	public static IPattern $p(final String symbolName, final IExpr check) {
        // if (symbolName == null) {
        // return org.matheclipse.core.expression.Pattern.valueOf(null, check);
        // }
        return org.matheclipse.core.expression.Pattern.valueOf($s(symbolName), check);
    }

    /**
     * Create a pattern for pattern-matching and term rewriting
     *
     * @param symbolName
	 * @param check
	 *            additional condition which should be checked in pattern-matching
	 * @param def
	 *            use a default value for this pattern if necessary
     * @return IPattern
     */
	public static IPattern $p(final String symbolName, final IExpr check, boolean def) {
        return org.matheclipse.core.expression.Pattern.valueOf($s(symbolName), check, def);
    }

    /**
     * Create a pattern for pattern-matching and term rewriting
     *
     * @param symbol
     * @return IPattern
     */
    public static IPattern pattern(final ISymbol symbol) {
        return org.matheclipse.core.expression.Pattern.valueOf(symbol);
    }

    /**
     * Create a pattern for pattern-matching and term rewriting
     *
     * @param symbol
	 * @param check
	 *            additional condition which should be checked in pattern-matching
	 * @param def
	 *            if <code>true</code>, the pattern can match to a default value associated with the AST's head the
	 *            pattern is used in.
     * @return IPattern
     */
    public static IPattern pattern(final ISymbol symbol, final IExpr check, final boolean def) {
        return org.matheclipse.core.expression.Pattern.valueOf(symbol, check, def);
    }


    /**
     * Create a pattern for pattern-matching and term rewriting
     *
     * @param symbol
     * @return IPattern
     */
    public static IPatternSequence $ps(final ISymbol symbol) {
        return PatternSequence.valueOf(symbol, false);
    }

    /**
	 *
     * @param symbol
	 * @param zeroArgsAllowed
	 *            if <code>true</code> 0 argument sequences are allowed for this pattern
     * @return
     */
    public static IPatternSequence $ps(final ISymbol symbol, boolean zeroArgsAllowed) {
        return PatternSequence.valueOf(symbol, zeroArgsAllowed);
    }

    /**
     * Create a pattern for pattern-matching and term rewriting
     *
     * @param symbol
	 * @param check
	 *            additional condition which should be checked in pattern-matching
     * @return IPattern
     */
    public static IPatternSequence $ps(final ISymbol symbol, final IExpr check) {
        return PatternSequence.valueOf(symbol, check, false);
    }

    /**
     * Create a pattern for pattern-matching and term rewriting
     *
     * @param symbol
	 * @param check
	 *            additional condition which should be checked in pattern-matching
	 * @param def
	 *            if <code>true</code>, the pattern can match to a default value associated with the AST's head the
	 *            pattern is used in.
	 * @param zeroArgsAllowed
	 *            if <code>true</code> 0 argument sequences are allowed for this pattern
     * @return IPattern
     */
    public static IPatternSequence $ps(final ISymbol symbol, final IExpr check, final boolean def,
                                       boolean zeroArgsAllowed) {
		return PatternSequence.valueOf(symbol, check, def, zeroArgsAllowed);
	}

	public static IPatternSequence $OptionsPattern(final ISymbol symbol) {
		return org.matheclipse.core.expression.OptionsPattern.valueOf(symbol);
	}

	public static IPatternSequence $OptionsPattern(final ISymbol symbol, final IExpr defaultOptions) {
		return org.matheclipse.core.expression.OptionsPattern.valueOf(symbol, defaultOptions);
	}

	public static IPatternSequence $Repeated(final IExpr patternExpr, EvalEngine engine) {
		return org.matheclipse.core.expression.RepeatedPattern.valueOf(patternExpr, false, engine);
	}

	public static IPatternSequence $RepeatedNull(final IExpr patternExpr, EvalEngine engine) {
		return org.matheclipse.core.expression.RepeatedPattern.valueOf(patternExpr, true, engine);
	}

	/**
     * Create a pattern for pattern-matching and term rewriting
     *
	 * @param symbolName
	 *            the name of the pattrn symbol
     * @return IPattern
     */
    public static IPatternSequence $ps(final String symbolName) {
        return PatternSequence.valueOf($s(symbolName), false);
    }

    /**
     * <p>
     * Get or create a global predefined symbol which is retrieved from the SYSTEM context map or created or retrieved
     * from the SYSTEM context variables map.
     * </p>
     * <p>
     * <b>Note:</b> user defined variables on the context path are defined with method <code>userSymbol()</code>
     * </p>
     *
	 * @param symbolName
	 *            the name of the symbol
     * @return
     */
    public static ISymbol $s(final String symbolName) {
        return $s(symbolName, true);
    }

    /**
     * <pre>
     * SymbolQ(x)
     * </pre>
     *
     * <blockquote>
     * <p>
     * is <code>True</code> if <code>x</code> is a symbol, or <code>False</code> otherwise.
     * </p>
     * </blockquote>
     * <h3>Examples</h3>
     *
     * <pre>
     * &gt;&gt; SymbolQ(a)
     * True
     * &gt;&gt; SymbolQ(1)
     * False
     * &gt;&gt; SymbolQ(a + b)
     * False
     * </pre>
     */
    public static IAST SymbolQ(final IExpr x) {
        return new AST1(SymbolQ, x);
    }

    /**
     * Full symmetry
     *
     * @param a0
     * @return
     */
    public static IAST Symmetric(final IExpr a0) {
        return new AST1(Symmetric, a0);
    }

	/**
	 * See <a href=
	 * "https://github.com/axkr/symja_android_library/blob/master/symja_android_library/doc/functions/SymmetricMatrixQ.md">SymmetricMatrixQ</a>
	 */
	public static IAST SymmetricMatrixQ(final IExpr a0) {
		return new AST1(SymmetricMatrixQ, a0);
	}
    /**
	 * Converts and evaluates arbitrary expressiona to a Symja type.
	 *
	 * <pre>
	 * Java Object       -&gt; Symja object
	 * -------------------------------------
	 * null object          F.Null symbol
	 * IExpr                IExpr type
	 * Boolean              True or False symbol
	 * BigInteger           Integer value
	 * BigDecimal           <code>Num</code> with doubleValue() value
	 * Double               <code>Num</code> with doubleValue() value
	 * Float                <code>Num</code> with doubleValue() value
	 * Integer              Symja Integer with longValue() value
	 * Long                 Symja Integer with longValue() value
	 * Number               Symja <code>Num</code> with doubleValue() value
	 * java.util.Collection list of elements
	 *                      1..nth element of the list give the elements of the List()
	 * Object[]             a list of converted objects
	 * int[]                a list of <code>IntegerSym</code> integer values
	 * double[]             a vector ASTRealVector of <code>double</code> values
	 * double[][]           a matrix ASTRealMatrix of <code>double</code> values
	 * Complex[]            a list of <code>ComplexNum</code> values
	 * boolean[]            a list of True or False symbols
     *
	 * </pre>
	 *
     */
    public static IExpr symjify(final Object object) {
		return symjify(object, true);
	}

	public static IExpr symjify(final Object object, boolean evaluate) {
		IExpr temp = Object2Expr.convert(object);
		return evaluate ? eval(temp) : temp;
	}

	/**
	 * Parses and evaluates a Java string to a Symja expression. May throw an SyntaxError exception, if the string
	 * couldn't be parsed.
	 *
	 * @param str
	 *            the epression which should be parsed
	 * @return
	 * @throws SyntaxError
	 */
	public static IExpr symjify(final String str) {
		return symjify(str, true);
    }

	/**
	 * Parses a Java string to a Symja expression. May throw an SyntaxError exception, if the string couldn't be parsed.
	 *
	 * @param str
	 *            the epression which should be parsed
	 * @param evaluate
	 *            if true evaluate the parsed string
	 * @return
	 * @throws SyntaxError
	 */
	public static IExpr symjify(final String str, boolean evaluate) {
		EvalEngine engine = EvalEngine.get();
		ExprParser parser = new ExprParser(engine);
		IExpr temp = parser.parse(str);
		return evaluate ? engine.evaluate(temp) : temp;
	}

	public static IExpr symjify(final long value) {
		return F.ZZ(value);
	}

	public static IExpr symjify(final double value) {
		return F.num(value);
	}

	public static IExpr symjify(final boolean value) {
		return value ? F.True : F.False;
	}
    /**
     * <p>
     * Get or create a global predefined symbol which is retrieved from the SYSTEM context map or created or retrieved
     * from the SYSTEM context variables map.
     * </p>
     * <p>
     * <b>Note:</b> user defined variables on the context path are defined with method <code>userSymbol()</code>
     * </p>
     *
	 * @param symbolName
	 *            the name of the symbol
	 * @param setEval
	 *            if <code>true</code> determine and assign the built-in evaluator object to the symbol.
     * @return
     */
    private static ISymbol $s(final String symbolName, boolean setEval) {
        String name = symbolName;
		if (FEConfig.PARSER_USE_LOWERCASE_SYMBOLS) {
            if (symbolName.length() == 1) {
                name = symbolName;
            } else {
                name = symbolName.toLowerCase(Locale.ENGLISH);
            }
        }
        ISymbol symbol = org.matheclipse.core.expression.Context.PREDEFINED_SYMBOLS_MAP.get(name);
        if (symbol != null) {
            return symbol;
        }
        symbol = HIDDEN_SYMBOLS_MAP.get(name);
        if (symbol != null) {
            return symbol;
        }
        if (Config.SERVER_MODE) {
			if (FEConfig.PARSER_USE_LOWERCASE_SYMBOLS) {
                if (SYMBOL_OBSERVER.createPredefinedSymbol(name)) {
                    // second try, because the symbol may now be added to
                    // fSymbolMap
                    ISymbol secondTry = org.matheclipse.core.expression.Context.PREDEFINED_SYMBOLS_MAP.get(name);
                    if (secondTry != null) {
                        return secondTry;
                    }
                }
            } else {
                if (Character.isUpperCase(name.charAt(0))) {
                    if (SYMBOL_OBSERVER.createPredefinedSymbol(name)) {
                        // second try, because the symbol may now be added to
                        // fSymbolMap
                        ISymbol secondTry = org.matheclipse.core.expression.Context.PREDEFINED_SYMBOLS_MAP.get(name);
                        if (secondTry != null) {
                            return secondTry;
                        }
                    }
                }
            }
            // symbol = new BuiltInSymbol(name);
            symbol = symbol(name, EvalEngine.get());
            // engine.putUserVariable(name, symbol);
            HIDDEN_SYMBOLS_MAP.put(name, symbol);
            if (name.charAt(0) == '$') {
                SYMBOL_OBSERVER.createUserSymbol(symbol);
            }
        } else {
			symbol = new BuiltInDummy(name);
			// symbol = symbol(name);
            HIDDEN_SYMBOLS_MAP.put(name, symbol);
            // if (symbol.isBuiltInSymbol()) {
            // if (!setEval) {
            // ((IBuiltInSymbol) symbol).setEvaluator(BuiltInSymbol.DUMMY_EVALUATOR);
            // } else {
            // ((IBuiltInSymbol) symbol).getEvaluator();
            // }
            // }
        }

        return symbol;
    }

    public static ISymbol $rubi(final String symbolName) {
        return $rubi(symbolName, BuiltInSymbol.DUMMY_EVALUATOR);
    }

    public static ISymbol $rubi(final String symbolName, IEvaluator evaluator) {
		String name = FEConfig.PARSER_USE_LOWERCASE_SYMBOLS //
				? (symbolName.length() == 1 ? symbolName : //
						symbolName.toLowerCase(Locale.ENGLISH))//
				: symbolName;
        ISymbol symbol = org.matheclipse.core.expression.Context.RUBI.get(name);
        if (symbol != null) {
            return symbol;
        }
        BuiltInRubi bSymbol = new BuiltInRubi(name);
        bSymbol.setEvaluator(evaluator);
        org.matheclipse.core.expression.Context.RUBI.put(name, bSymbol);
        return bSymbol;
    }
	final static public IStringX $str(final char ch) {
		return StringX.valueOf(ch);
	}

    /**
     * Create a string expression
     *
     * @param str
     * @return
     */
    final static public IStringX $str(final String str) {
        return StringX.valueOf(str);
    }

	final static public IStringX $str(final String str, final short mimeType) {
		return StringX.valueOf(str, mimeType);
	}
    // --- generated source codes:
    public static IAST Abs(final IExpr a0) {
        return new AST1(Abs, a0);
    }

	public static IAST AbsoluteCorrelation(final IExpr a0, final IExpr a1) {
		return new AST2(AbsoluteCorrelation, a0, a1);
	}
    public static IAST Alternatives(final IExpr... a) {
        return function(Alternatives, a);
    }

    public static IExpr and(IExpr a, Integer i) {
		return And(a, ZZ(i.longValue()));
    }

    public static IExpr and(IExpr a, java.math.BigInteger i) {
		return And(a, ZZ(i));
    }

    public static IExpr and(Integer i, IExpr b) {
		return And(ZZ(i.longValue()), b);
    }

    public static IExpr and(java.math.BigInteger i, IExpr b) {
		return And(ZZ(i), b);
    }

    public static IASTAppendable And() {
        return ast(And);
    }

    public static IAST And(final IExpr... a) {
        return function(And, a);
    }

	public static IAST And(final IExpr a0, final IExpr a1) {
		return new B2.And(a0, a1);
	}

	public static IAST And(final IExpr a0, final IExpr a1, final IExpr a3) {
		return new AST3(F.And, a0, a1, a3);
	}
    public static IAST AngleVector(final IExpr a0) {
        return new AST1(AngleVector, a0);
    }

    public static IAST AntiSymmetric(final IExpr a0) {
        return new AST1(AntiSymmetric, a0);
    }


    public static IAST Apart(final IExpr a0) {
        return new AST1(Apart, a0);
    }

    public static IAST Apart(final IExpr a0, final IExpr a1) {
        return new AST2(Apart, a0, a1);
    }

    public static IAST AppellF1(final IExpr... a) {
        return function(AppellF1, a);
    }

    public static IAST Append(final IExpr a0, final IExpr a1) {
        return new AST2(Append, a0, a1);
    }

    public static IAST AppendTo(final IExpr a0, final IExpr a1) {
        return new AST2(AppendTo, a0, a1);
    }

	/**
	 * Operator <code>@@</code>
	 *
	 * @param a0
	 * @param a1
	 * @return
	 */
	public static IASTMutable Apply(final IExpr a0, final IExpr a1) {
        return new AST2(Apply, a0, a1);
    }

	/**
	 * Operator <code>@@@</code>
	 *
	 * @param a0
	 * @param a1
	 * @return
	 */
	public static IASTMutable ApplyListC1(final IExpr a0, final IExpr a1) {
		return new AST3(Apply, a0, a1, CListC1);
	}

	public static IAST AiryAi(final IExpr a0) {
		return new AST1(AiryAi, a0);
	}

	public static IAST AiryAiPrime(final IExpr a0) {
		return new AST1(AiryAiPrime, a0);
	}

	public static IAST AiryBi(final IExpr a0) {
		return new AST1(AiryBi, a0);
	}

	public static IAST AiryBiPrime(final IExpr a0) {
		return new AST1(AiryBiPrime, a0);
	}

	public static IAST Array(final IExpr a0, final IExpr a1) {
		return new AST2(Array, a0, a1);
	}

    public static IAST ArcCos(final IExpr a0) {
        return new AST1(ArcCos, a0);
    }

    public static IAST ArcCosh(final IExpr a0) {
        return new AST1(ArcCosh, a0);
    }

    public static IAST ArcCot(final IExpr a0) {
        return new AST1(ArcCot, a0);
    }

    public static IAST ArcCoth(final IExpr a0) {
        return new AST1(ArcCoth, a0);
    }

    public static IAST ArcCsc(final IExpr a0) {
        return new AST1(ArcCsc, a0);
    }

    public static IAST ArcCsch(final IExpr a0) {
        return new AST1(ArcCsch, a0);
    }

    public static IAST ArcSec(final IExpr a0) {
        return new AST1(ArcSec, a0);
    }

    public static IAST ArcSech(final IExpr a0) {
        return new AST1(ArcSech, a0);
    }

    public static IAST ArcSin(final IExpr a0) {

        return new AST1(ArcSin, a0);
    }

    public static IAST ArcSinh(final IExpr a0) {
        return new AST1(ArcSinh, a0);
    }

    public static IAST ArcTan(final IExpr a0) {
        return new AST1(ArcTan, a0);
    }

    public static IAST ArcTan(final IExpr a0, final IExpr a1) {
        return new AST2(ArcTan, a0, a1);
    }

    public static IAST ArcTanh(final IExpr a0) {
        return new AST1(ArcTanh, a0);
    }

    public static IAST Arg(final IExpr a0) {
        return new AST1(Arg, a0);
    }

    /**
     * <pre>
     * 'ArrayQ(expr)
     * </pre>
     *
     * <blockquote>
     * <p>
     * tests whether expr is a full array.
     * </p>
     * </blockquote>
     *
     * <pre>
     * 'ArrayQ(expr, pattern)
     * </pre>
     *
     * <blockquote>
     * <p>
     * also tests whether the array depth of expr matches pattern.
     * </p>
     * </blockquote>
     *
     * <pre>
     * 'ArrayQ(expr, pattern, test)
     * </pre>
     *
     * <blockquote>
     * <p>
     * furthermore tests whether <code>test</code> yields <code>True</code> for all elements of expr.
     * </p>
     * </blockquote>
     * <h3>Examples</h3>
     *
     * <pre>
     * &gt;&gt; ArrayQ(a)
     * False
     * &gt;&gt; ArrayQ({a})
     * True
     * &gt;&gt; ArrayQ({{{a}},{{b,c}}})
     * False
     * &gt;&gt; ArrayQ({{a, b}, {c, d}}, 2, SymbolQ)
     * True
     * </pre>
     */
    public static IAST ArrayQ(final IExpr a0) {
        return new AST1(ArrayQ, a0);
    }

    /**
     * The domain of arrays.
     *
     * @param dimension
     * @return <code>Arrays(dimensions, Complexes, {})</code>.
     */
    public static IAST Arrays(final IAST dimension) {
        return Arrays(dimension, F.Complexes, F.List());
    }

    /**
     * The domain of arrays.
     *
     * @param dimension
     * @param domain
     * @return <code>Arrays(dimensions, domain, {})</code>.
     */
    public static IAST Arrays(final IAST dimension, ISymbol domain) {
        return Arrays(dimension, domain, F.List());
    }

    /**
     * The domain of arrays.
     *
     * @param dimension
     * @param domain
     * @param symmetry
     * @return <code>Arrays(dimensions, domain, symmetry)</code>.
     */
    public static IAST Arrays(final IAST dimension, ISymbol domain, IAST symmetry) {
        return new AST3(Arrays, dimension, domain, symmetry);
    }

    public static IAST ArithmeticGeometricMean(final IExpr a0, final IExpr a1) {
        return new AST2(ArithmeticGeometricMean, a0, a1);
    }

	public static IAssociation assoc(final IAST listOfRules) {
		if (listOfRules.isAST1() && listOfRules.arg1().isListOfRules(true)) {
			return new ASTAssociation((IAST) listOfRules.arg1());
		}
		return new ASTAssociation(listOfRules);
	}

	public static IAssociation assoc(final int capacity) {
		return new ASTAssociation(capacity, false);
	}

	public static ISparseArray sparseArray(final IAST arrayRulesList) {
		return SparseArrayExpr.newArrayRules(arrayRulesList, null, -1, F.C0);
	}

    /**
     * Creates a new AST from the given <code>ast</code> and <code>head</code>. if <code>include</code> is set to
     * <code>true </code> all arguments from index first to last-1 are copied in the new list if <code>include</code> is
     * set to <code> false </code> all arguments excluded from index first to last-1 are copied in the new list
	 *
     */
    public static IAST ast(final IAST f, final IExpr head, final boolean include, final int first, final int last) {
        AST ast = null;
        if (include) {
			ast = AST.newInstance(last - first, head, false);
            // range include
			ast.appendAll(f, first, last);
			// for (int i = first; i < last; i++) {
			// ast.append(f.get(i));
			// }
        } else {
			ast = AST.newInstance(f.size() - last + first - 1, head, false);
            // range exclude
			ast.appendAll(f, 1, first);
			// for (int i = 1; i < first; i++) {
			// ast.append(f.get(i));
			// }
			ast.appendAll(f, last, f.size());
			// for (int j = last; j < f.size(); j++) {
			// ast.append(f.get(j));
			// }
        }
        return ast;
    }

    /**
     * Create a new abstract syntax tree (AST).
     *
	 * @param head
	 *            the header expression of the function. If the ast represents a function like
	 *            <code>f[x,y], Sin[x],...</code>, the <code>head</code> will be an instance of type ISymbol.
	 *
     */
    public final static IASTAppendable ast(final IExpr head) {
        return AST.newInstance(head);
    }

    /**
     * Create a new abstract syntax tree (AST).
     *
	 * @param head
	 *            the header expression of the function. If the ast represents a function like
	 *            <code>f[x,y], Sin[x],...</code>, the <code>head</code> will be an instance of type ISymbol.
	 * @param initialCapacity
	 *            the initial capacity (i.e. number of arguments without the header element) of the list.
	 * @param initNull
	 *            initialize all elements with <code>null</code>.
     * @return
     */
    public static IASTAppendable ast(final IExpr head, final int initialCapacity, final boolean initNull) {
		return AST.newInstance(initialCapacity, head, initNull);
    }

    /**
     * Create a new <code>List()</code> with <code>copies</code> number of arguments, which are set to
     * <code>value</code>.
     *
	 * @param value
	 *            initialize all elements with <code>value</code>.
	 * @param copies
	 *            the initial capacity (i.e. number of arguments without the header element) of the list.
     * @return
     */
    public static IASTAppendable constantArray(final IExpr value, final int copies) {
        return value.constantArray(F.List, 0, copies);
    }

    /**
     * Create a new abstract syntax tree (AST) with a <code>head</code> and <code>copies</code> number of arguments,
     * which are set to <code>value</code>.
     *
	 * @param head
	 *            the header expression of the function. If the ast represents a function like
	 *            <code>f[x,y], Sin[x],...</code>, the <code>head</code> will be an instance of type ISymbol.
	 * @param value
	 *            initialize all elements with <code>value</code>.
	 * @param copies
	 *            the initial capacity (i.e. number of arguments without the header element) of the list.
     * @return
     */
    public static IASTAppendable constantArray(final IExpr head, final IExpr value, final int copies) {
        return value.constantArray(head, 0, copies);
    }

    /**
     * Create a new abstract syntax tree (AST).
     *
     * @param arr
	 * @param head
	 *            the header expression of the function. If the ast represents a function like
	 *            <code>f[x,y], Sin[x],...</code>, the <code>head</code> will be an instance of type ISymbol.
     * @return
     */
    public static IASTAppendable ast(final IExpr[] arr, final IExpr head) {
        return new AST(head, arr);
    }

	public static IASTAppendable ast(final ISymbol head, final int[] arr) {
		return AST.newInstance(head, arr);
	}

	public static IASTAppendable ast(final ISymbol head, final org.hipparchus.complex.Complex[] arr) {
		return AST.newInstance(head, false, arr);
	}

	public static IASTAppendable ast(final ISymbol head, boolean evalComplex, org.hipparchus.complex.Complex[] arr) {
		return AST.newInstance(head, evalComplex, arr);
	}
    /**
     * <pre>
     * AtomQ(x)
     * </pre>
     *
     * <blockquote>
     * <p>
     * is true if <code>x</code> is an atom (an object such as a number or string, which cannot be divided into
     * subexpressions using 'Part').
     * </p>
     * </blockquote>
     * <h3>Examples</h3>
     *
     * <pre>
     * &gt;&gt; AtomQ(x)
     * True
     *
     * &gt;&gt; AtomQ(1.2)
     * True
     *
     * &gt;&gt; AtomQ(2 + I)
     * True
     *
     * &gt;&gt; AtomQ(2 / 3)
     * True
     *
     * &gt;&gt; AtomQ(x + y)
     * False
     * </pre>
     */
    public static IAST AtomQ(final IExpr a) {
        return new AST1(AtomQ, a);
    }

    public static IAST Attributes(final IExpr a) {
        return new AST1(Attributes, a);
    }

	public static IAST BaseForm(final IExpr a0, final IExpr a1) {
		return new AST2(F.BaseForm, a0, a1);
	}

    /**
     * Bell number.
     *
     * @param a0
     * @return
     */
    public static IAST BellB(final IExpr a0) {
        return new AST1(F.BellB, a0);
    }

    /**
     * Bell polynomial.
     *
     * @param a0
     * @param a1
     * @return
     */
    public static IAST BellB(final IExpr a0, final IExpr a1) {
        return new AST2(F.BellB, a0, a1);
    }

	public static IAST BellY(final IExpr a0, final IExpr a1, final IExpr a2) {
		return new AST3(F.BellY, a0, a1, a2);
	}
    public static IAST BernoulliB(final IExpr a0) {
        return new AST1(F.BernoulliB, a0);
    }

	public static IAST BernoulliB(final IExpr a0, final IExpr a1) {
		return new AST2(F.BernoulliB, a0, a1);
	}
    public static IAST BernoulliDistribution(final IExpr a0) {
        return new AST1(F.BernoulliDistribution, a0);
    }

    /**
	 * Create a function <code>head(arg1, arg2)</code> with 2 arguments without evaluation.
     *
     * @param head
	 * @param arg1
	 * @param arg2
     * @return
     */
	public final static IASTAppendable binary(final IExpr head, final IExpr arg1, final IExpr arg2) {
		return new AST(new IExpr[] { head, arg1, arg2 });
    }
	/**
	 * Create a function <code>head(arg1, arg2)</code> with 2 argument as an <code>AST2</code> mutable object without
	 * evaluation.
	 *
	 * @param head
	 * @param arg1
	 * @param arg2
	 * @return
	 */
	public final static IASTMutable binaryAST2(final IExpr head, final IExpr arg1, final IExpr arg2) {
		return new AST2(head, arg1, arg2);
	}

	public final static IASTMutable binaryAST2(final IExpr head, final String arg1, final IExpr arg2) {
		return new AST2(head, F.$str(arg1), arg2);
	}

	public final static IASTMutable binaryAST2(final IExpr head, final String arg1, final String arg2) {
		return new AST2(head, F.$str(arg1), F.$str(arg2));
	}


    public static IAST Binomial(final IExpr a0, final IExpr a1) {
        return new AST2(F.Binomial, a0, a1);
    }

	public static IAST Binomial(final int a0, final int a1) {
		return new AST2(F.Binomial, F.ZZ(a0), F.ZZ(a1));
	}

    public static IAST BlankSequence() {
        return new AST0(BlankSequence);
    }

    public static IAST Block(final IExpr a0, final IExpr a1) {
        return new AST2(Block, a0, a1);
    }

    /**
     * Gives symbols "True" or "False" (type ISymbol) depending on the boolean value.
     *
     * @param value
     * @return
     */
    public static ISymbol bool(final boolean value) {
        return value ? True : False;
    }

    public static IAST Boole(final IExpr a) {
        return new AST1(Boole, a);
    }

	public static IAST BooleanConvert(final IExpr a0, final IExpr a1) {
		return new AST2(BooleanConvert, a0, a1);
	}
    /**
     * <pre>
     * BooleanQ(expr)
     * </pre>
     *
     * <blockquote>
     * <p>
     * returns <code>True</code> if <code>expr</code> is either <code>True</code> or <code>False</code>.
     * </p>
     * </blockquote>
     * <h3>Examples</h3>
     *
     * <pre>
     * &gt;&gt; BooleanQ(True)
     * True
     * &gt;&gt; BooleanQ(False)
     * True
     * &gt;&gt; BooleanQ(a)
     * False
     * &gt;&gt; BooleanQ(1 &lt; 2)
     * True
     * &gt;&gt; BooleanQ("string")
     * False
     * &gt;&gt; BooleanQ(Together(x/y + y/x))
     * False
     * </pre>
     */
    public static IAST BooleanQ(final IExpr a) {
        return new AST1(BooleanQ, a);
    }

	public static IAST BooleanTable(final IExpr a0, final IExpr a1) {
		return new AST2(BooleanTable, a0, a1);
	}

    public static IAST BesselI(final IExpr a0, final IExpr a1) {
        return new AST2(BesselI, a0, a1);
    }

    public static IAST BesselJ(final IExpr a0, final IExpr a1) {
        return new AST2(BesselJ, a0, a1);
    }

    public static IAST BesselY(final IExpr a0, final IExpr a1) {
        return new AST2(BesselY, a0, a1);
    }

    public static IAST BesselK(final IExpr a0, final IExpr a1) {
        return new AST2(BesselK, a0, a1);
    }

    public static IAST Beta(final IExpr a0, final IExpr a1) {
        return new AST2(Beta, a0, a1);
    }

    public static IAST Beta(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(Beta, a0, a1, a2);
    }

    public static IAST BetaRegularized(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(BetaRegularized, a0, a1, a2);
    }

	public static IAST BetaRegularized(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3) {
		return quaternary(BetaRegularized, a0, a1, a2, a3);
	}
    public static IAST Break() {
        return new AST0(Break);
    }

	public static IAST C(final int index) {
		return new AST1(C, F.ZZ(index));
	}
    public static IAST Cancel(final IExpr a) {
        return new AST1(Cancel, a);
    }

	public static IAST CancelButton() {
		return new AST0(CancelButton);
	}
    public static IAST CarmichaelLambda(final IExpr a0) {
        return new AST1(CarmichaelLambda, a0);
    }

    /**
     * Converts a given object into a MathEclipse IExpr expression
     *
     * <pre>
     * Java Object     -&gt; MathEclipse object
     * -------------------------------------
     * null object          Null symbol
     * IExpr                IExpr type
     * Boolean              True or False symbol
	 * BigInteger           Integer value
	 * java.math.BigInteger Integer value
     * BigDecimal           Double with doubleValue() value
     * Double               Double with doubleValue() value
     * Float                Double with doubleValue() value
     * Number               Integer with longValue() value
	 * java.util.List       0-th element of the list gives the head of the function
     *                      1..nth element of the list give the arguments of the function
	 * Object[]             a list of converted objects
     * int[]                a list of Integer values
     * double[]             a list of Double values
     * double[][]           a matrix (i.e. nested lists) of Double values
     * boolean[]            a list of True or False symbols
     *
     * </pre>
     *
     * @param obj
     * @return
     */
    public static IExpr cast(Object obj) {
        return Object2Expr.convert(obj);
    }

    public static IAST CatalanNumber(final IExpr a) {
        return new AST1(CatalanNumber, a);
    }

    public static IAST Catch(final IExpr a) {
        return new AST1(Catch, a);
    }

    /**
     * Create a symbolic complex number
     *
     * @param re
     * @return
     */
    public static IComplex CC(final IFraction re) {
        return complex(re, fraction(0L, 1L));
    }

    /**
     * Create a symbolic complex number
     *
     * @param re
     * @param im
     * @return
     */
	public static IComplex CC(final IRational re, final IRational im) {
        return ComplexSym.valueOf(re, im);
    }

    /**
     * Create a symbolic complex number
     *
     * @param real_numerator
     * @param real_denominator
     * @param imag_numerator
     * @param imag_denominator
     * @return
     */
    public static IComplex CC(final long real_numerator, final long real_denominator, final long imag_numerator,
                              final long imag_denominator) {
        return ComplexSym.valueOf(real_numerator, real_denominator, imag_numerator, imag_denominator);
    }

    public static IAST CDF(final IExpr a0) {
        return new AST1(CDF, a0);
    }

    public static IAST CDF(final IExpr a0, final IExpr a1) {
        return new AST2(CDF, a0, a1);
    }

    public static IAST Ceiling(final IExpr a0) {
        return new AST1(Ceiling, a0);
    }

    public static IAST ChebyshevT(final IExpr a0, final IExpr a1) {
        return new AST2(ChebyshevT, a0, a1);
    }

    public static IAST ChebyshevU(final IExpr a0, final IExpr a1) {
        return new AST2(ChebyshevU, a0, a1);
    }

    public static IAST CharacteristicPolynomial(final IExpr a0, final IExpr a1) {
        return new AST2(CharacteristicPolynomial, a0, a1);
    }

    public static IAST Chop(final IExpr a0) {
        return new AST1(Chop, a0);
    }

    public static IExpr chopExpr(IExpr arg, double delta) {
        if (arg.isNumber()) {
            return chopNumber((INumber) arg, delta);
        }
        return arg;
    }

    /**
     * Set real or imaginary parts of a numeric argument to zero, those absolute value is less than a delta.
     *
	 * @param arg
	 *            a numeric number
	 * @param delta
	 *            the delta for which the number should be set to zero
     * @return <code>arg</code> if the argument couldn't be chopped
     */
    public static INumber chopNumber(INumber arg, double delta) {
        if (arg instanceof INum) {
            if (isZero(((INum) arg).getRealPart(), delta)) {
                return C0;
            }
        } else if (arg instanceof IComplexNum) {
			Complex c = ((IComplexNum) arg).evalComplex();
			if (isZero(c.getReal(), delta)) {
				if (isZero(c.getImaginary(), delta)) {
                    return C0;
                }
				return complexNum(0.0, c.getImaginary());
            }
			if (isZero(c.getImaginary(), delta)) {
                return num(((IComplexNum) arg).getRealPart());
            }

        }
        return arg;
    }

	/**
	 * Set real or imaginary parts of a numeric argument to zero, those absolute value is less than
	 * <code>Config.DEFAULT_CHOP_DELTA</code>
	 *
	 * @param arg
	 *            a numeric number
	 * @return <code>arg</code> if the argument couldn't be chopped
	 */
	public static org.hipparchus.complex.Complex chopComplex(org.hipparchus.complex.Complex arg) {
		return chopComplex(arg, Config.DEFAULT_CHOP_DELTA);
	}

	/**
	 * Set real or imaginary parts of a numeric argument to zero, those absolute value is less than a delta.
	 *
	 * @param arg
	 *            a numeric number
	 * @param delta
	 *            the delta for which the number should be set to zero
	 * @return <code>arg</code> if the argument couldn't be chopped
	 */
	public static org.hipparchus.complex.Complex chopComplex(org.hipparchus.complex.Complex arg, double delta) {
		org.hipparchus.complex.Complex c = arg;
		if (isZero(c.getReal(), delta)) {
			if (isZero(c.getImaginary(), delta)) {
				return org.hipparchus.complex.Complex.ZERO;
			}
			return new org.hipparchus.complex.Complex(0.0, c.getImaginary());
		}
		if (isZero(c.getImaginary(), delta)) {
			return new org.hipparchus.complex.Complex(c.getReal());
		}
		return arg;
	}
    public static IAST CentralMoment(final IExpr a0, final IExpr a1) {
        return new AST2(CentralMoment, a0, a1);
    }

    public static IAST Clear(final IExpr... a) {
        return function(Clear, a);
    }

    public static IAST ClearAttributes(final IExpr a0, final IExpr a1) {
        return new AST2(ClearAttributes, a0, a1);
    }


    public static IAST Coefficient(final IExpr a0, final IExpr a1) {
        return new AST2(Coefficient, a0, a1);
    }

    public static IAST Coefficient(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(Coefficient, a0, a1, a2);
    }

    public static IAST CoefficientList(final IExpr a0, final IExpr a1) {
        return new AST2(CoefficientList, a0, a1);
    }

    public static IAST Collect(final IExpr a0, final IExpr a1) {
        return new AST2(Collect, a0, a1);
    }

    public static IAST Colon(final IExpr a0, final IExpr a1) {
        return new AST2(Colon, a0, a1);
    }

    public static int compareTo(IExpr a, IExpr b) throws UnsupportedOperationException {
        if (a instanceof ISignedNumber && b instanceof ISignedNumber) {
            return a.compareTo(b);
        }
        IExpr tempA = eval(a);
        IExpr tempB = eval(b);
        if (tempA instanceof ISignedNumber && tempB instanceof ISignedNumber) {
            return tempA.compareTo(tempB);
        }
        throw new UnsupportedOperationException(
                "compareTo() - first or second argument could not be converted into a signed number.");
    }

    public static int compareTo(IExpr a, Integer i) throws UnsupportedOperationException {
        if (a instanceof ISignedNumber) {
			return a.compareTo(ZZ(i.longValue()));
        }
        IExpr temp = eval(a);
        if (temp instanceof ISignedNumber) {
			return temp.compareTo(ZZ(i.longValue()));
        }
        throw new UnsupportedOperationException(
                "compareTo() - first argument could not be converted into a signed number.");
    }

    public static int compareTo(IExpr a, java.math.BigInteger i) throws UnsupportedOperationException {
        if (a instanceof ISignedNumber) {
			return a.compareTo(ZZ(i));
        }
        IExpr temp = eval(a);
        if (temp instanceof ISignedNumber) {
			return temp.compareTo(ZZ(i));
        }
        throw new UnsupportedOperationException(
                "compareTo() - first argument could not be converted into a signed number.");
    }

    public static int compareTo(Integer i, IExpr b) throws UnsupportedOperationException {
        if (b instanceof ISignedNumber) {
			return ZZ(i.longValue()).compareTo(b);
        }
        IExpr temp = eval(b);
        if (temp instanceof ISignedNumber) {
			return ZZ(i.longValue()).compareTo(temp);
        }
        throw new UnsupportedOperationException(
                "compareTo() - second argument could not be converted into a signed number.");
    }

    public static int compareTo(java.math.BigInteger i, IExpr b) throws UnsupportedOperationException {
        if (b instanceof ISignedNumber) {
			return ZZ(i).compareTo(b);
        }
        IExpr temp = eval(b);
        if (temp instanceof ISignedNumber) {
			return ZZ(i).compareTo(temp);
        }
        throw new UnsupportedOperationException(
                "compareTo() - second argument could not be converted into a signed number.");
    }

    /**
     * Create a symbolic complex number
     *
	 * @param realPart
	 *            the real double value part which should be converted to a complex number
	 * @param imagPart
	 *            the imaginary double value part which should be converted to a complex number
     * @return IComplex
     */
    public static IComplex complex(final double realPart, final double imagPart) {
        // J2objc changed: use DOUBLE_TOLERANCE to avoid infinity loop
        return complex(realPart, imagPart, Config.DOUBLE_TOLERANCE);
    }

    /**
     * Create a symbolic complex number
     *
	 * @param realPart
	 *            the real double value part which should be converted to a complex number
	 * @param imagPart
	 *            the imaginary double value part which should be converted to a complex number
     * @param epsilon
     * @return IFraction
     */
    public static IComplex complex(final double realPart, final double imagPart, final double epsilon) {
        return ComplexSym.valueOf(AbstractFractionSym.valueOfEpsilon(realPart, epsilon),
                AbstractFractionSym.valueOfEpsilon(imagPart, epsilon));
    }

    /**
     * Create a symbolic complex number
     *
     * @param re
     * @return
     */
    public static IComplex complex(final IRational re) {
        return complex(re, fraction(0L, 1L));
    }

    /**
     * Create a symbolic complex number
     *
     * @param re
     * @param im
     * @return
     */
    public static IComplex complex(final IRational re, final IRational im) {
        return ComplexSym.valueOf(re, im);
    }

    /**
     * Create a symbolic complex number
     *
     * @param real_numerator
     * @param real_denominator
     * @param imag_numerator
     * @param imag_denominator
     * @return
     */
    public static IComplex complex(final long real_numerator, final long real_denominator, final long imag_numerator,
                                   final long imag_denominator) {
        return ComplexSym.valueOf(real_numerator, real_denominator, imag_numerator, imag_denominator);
    }

    /**
     * Create a Complex(a, b) symbolic expression?
     *
     * @param a0
     * @param a1
     * @return
     */
    public static IAST Complex(final IExpr a0, final IExpr a1) {
        return new AST2(Complex, a0, a1);
    }

    public static IComplexNum complexNum(final Apcomplex c) {
        return ApcomplexNum.valueOf(c);
    }

    public static IComplexNum complexNum(final Apfloat r) {
        return ApcomplexNum.valueOf(r, Apcomplex.ZERO);
    }

    public static IComplexNum complexNum(final Apfloat r, final Apfloat i) {
        return ApcomplexNum.valueOf(r, i);
    }

    public static IComplexNum complexNum(final Complex c) {
        return ComplexNum.valueOf(c);
    }

    /**
     * Create a complex numeric number with imaginary part = 0.0
     *
	 * @param r
	 *            the real part of the number
     * @return
     */
    public static IComplexNum complexNum(final double r) {
        return complexNum(r, 0.0);
    }

    /**
     * Create a complex numeric value
     *
	 * @param r
	 *            real part
	 * @param i
	 *            imaginary part
     * @return
     */
    public static IComplexNum complexNum(final double r, final double i) {
        return ComplexNum.valueOf(r, i);
    }

    public static IComplexNum complexNum(final IComplex value) {
        final IRational realFraction = value.getRealPart();
        final IRational imagFraction = value.getImaginaryPart();
        final EvalEngine engine = EvalEngine.get();
		if (engine.isArbitraryMode()) {
			return ApcomplexNum.valueOf(realFraction.toBigNumerator(), realFraction.toBigDenominator(),
                    imagFraction.toBigNumerator(), imagFraction.toBigDenominator(), engine.getNumericPrecision());
        }
        // double precision complex number
        double nr = realFraction.numerator().doubleValue();
        double dr = realFraction.denominator().doubleValue();
        double ni = imagFraction.numerator().doubleValue();
        double di = imagFraction.denominator().doubleValue();

        return complexNum(nr / dr, ni / di);
    }

    public static IComplexNum complexNum(final IFraction value) {
        final EvalEngine engine = EvalEngine.get();
		if (engine.isArbitraryMode()) {
			return ApcomplexNum.valueOf(value.toBigNumerator(), value.toBigDenominator(), BigInteger.ZERO,
                    BigInteger.ONE, engine.getNumericPrecision());
        }
        return complexNum(value.doubleValue(), 0.0d);
    }

    public static IComplexNum complexNum(final IInteger value) {
        final EvalEngine engine = EvalEngine.get();
		if (engine.isArbitraryMode()) {
			return ApcomplexNum.valueOf(value.toBigNumerator(), BigInteger.ONE, BigInteger.ZERO, BigInteger.ONE,
                    engine.getNumericPrecision());
        }
        return complexNum(value.doubleValue(), 0.0d);
    }

    public static IAST CompoundExpression(final IExpr... a) {
        return function(CompoundExpression, a);
    }

    /**
     * Create a new abstract syntax tree (AST).
     *
	 * @param head
	 *            the header symbol of the function. If the ast represents a function like
	 *            <code>f[x,y], Sin[x],...</code>, the <code>head</code> will be an instance of type ISymbol.
     * @param a
     * @return
     */
    public static IAST function(IExpr head, final IExpr... a) {
        final int size = a.length;
        switch (size) {
            case 1:
                return new AST1(head, a[0]);
            case 2:
                return new AST2(head, a[0], a[1]);
            case 3:
                return new AST3(head, a[0], a[1], a[2]);
        }
        return new AST(head, a);
    }

	public static IAST Condition(final IExpr a1, final IExpr a2) {
		return new B2.Condition(a1, a2);
    }

    public static IAST ConditionalExpression(final IExpr a0, final IExpr a1) {
        return new AST2(ConditionalExpression, a0, a1);
    }

    public static IAST Conjugate(final IExpr a0) {
        return new AST1(Conjugate, a0);
    }

    public static IAST ConstantArray(final IExpr a0, final IExpr a1) {
        return new AST2(ConstantArray, a0, a1);
    }

    public static IAST ConjugateTranspose(final IExpr a0) {
        return new AST1(ConjugateTranspose, a0);
    }

    public static IAST Continue() {
        return new AST0(Continue);
    }

	public static IAST ContinuedFraction(final IExpr a0) {
		return new AST1(ContinuedFraction, a0);
	}

    public static IAST CoprimeQ(final IExpr a0, final IExpr a1) {
        return new AST2(CoprimeQ, a0, a1);
    }

    public static IAST Cos(final IExpr a0) {
		return new B1.Cos(a0);
    }

    public static IAST Cosh(final IExpr a0) {
        return new AST1(Cosh, a0);
    }

    public static IAST CoshIntegral(final IExpr a) {
        return new AST1(CoshIntegral, a);
    }

    public static IAST CosIntegral(final IExpr a) {
        return new AST1(CosIntegral, a);
    }

    public static IAST Cot(final IExpr a0) {
        return new AST1(Cot, a0);
    }

    public static IAST Coth(final IExpr a0) {
        return new AST1(Coth, a0);
    }

    public static IAST Count(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(Count, a0, a1, a2);
    }

    public static IAST Covariance(final IExpr a0, final IExpr a1) {
        return new AST2(Covariance, a0, a1);
    }

    public static IAST Cross(final IExpr a0, final IExpr a1) {
        return new AST2(Cross, a0, a1);
    }

    public static IAST Csc(final IExpr a0) {
        return new AST1(Csc, a0);
    }

    public static IAST Csch(final IExpr a0) {
        return new AST1(Csch, a0);
    }

    public static IAST D() {
        return ast(D);
    }

    public static IAST D(final IExpr a0, final IExpr a1) {
        return new AST2(D, a0, a1);
    }

    public static IAST Decrement(final IExpr a) {
        return new AST1(Decrement, a);
    }

    public static IAST Defer(final IExpr a0) {
        return new AST1(Defer, a0);
    }

    public static IAST Delete(final IExpr a0, final IExpr a1) {
        return new AST2(Delete, a0, a1);
    }

    public static IAST DeleteCases(final IExpr... a) {
        return function(DeleteCases, a);
    }

    public static IAST Denominator(final IExpr a0) {

        return new AST1(Denominator, a0);
    }

    public static IAST Depth(final IExpr a0) {

        return new AST1(Depth, a0);
    }

    public static IAST Derivative(final IExpr... a) {
        return function(Derivative, a);
    }

    public static IAST DesignMatrix(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(DesignMatrix, a0, a1, a2);
    }

    public static IAST Det(final IExpr a0) {
        return new AST1(Det, a0);
    }

	public static IAST DialogReturn() {
		return new AST0(DialogReturn);
	}

	public static IAST DialogReturn(final IExpr a0) {
		return new AST1(DialogReturn, a0);
	}
    /**
     * <pre>
     * DigitQ(str)
     * </pre>
     *
     * <blockquote>
     * <p>
     * returns <code>True</code> if <code>str</code> is a string which contains only digits.
     * </p>
     * </blockquote>
     * <h3>Examples</h3>
     *
     * <pre>
     * &gt;&gt; DigitQ("1234")
     * True
     * </pre>
     */
    public static IAST DigitQ(final IExpr a0) {
        return new AST1(DigitQ, a0);
    }

    /**
     * <pre>
     * Dimensions(expr)
     * </pre>
     *
     * <blockquote>
     * <p>
     * returns a list of the dimensions of the expression <code>expr</code>.
     * </p>
     * </blockquote>
     * <h3>Examples</h3>
     * <p>
     * A vector of length 3:
     * </p>
     *
     * <pre>
     * &gt;&gt; Dimensions({a, b, c})
     *  = {3}
     * </pre>
     * <p>
     * A 3x2 matrix:
     * </p>
     *
     * <pre>
     * &gt;&gt; Dimensions({{a, b}, {c, d}, {e, f}})
     *  = {3, 2}
     * </pre>
     * <p>
     * Ragged arrays are not taken into account:
     * </p>
     *
     * <pre>
     * &gt;&gt; Dimensions({{a, b}, {b, c}, {c, d, e}})
     * {3}
     * </pre>
     * <p>
     * The expression can have any head:
     * </p>
     *
     * <pre>
     * &gt;&gt; Dimensions[f[f[a, b, c]]]
     * {1, 3}
     * &gt;&gt; Dimensions({})
     * {0}
     * &gt;&gt; Dimensions({{}})
     * {1, 0}
     * </pre>
     */
    public static IAST Dimensions(final IExpr a0) {
        return new AST1(Dimensions, a0);
    }

    public static IAST DiracDelta(final IExpr a0) {
        return new AST1(DiracDelta, a0);
    }

	public static IAST DirectedEdge(final IExpr a0, final IExpr a1) {
		return new B2.DirectedEdge(a0, a1);
	}
    public static IAST DirectedInfinity(final IExpr a0) {
        return new AST1(DirectedInfinity, a0);
    }

    public static IAST DiscreteUniformDistribution(final IExpr a) {
        return new AST1(DiscreteUniformDistribution, a);
    }

    public static IAST Discriminant(final IExpr a0, final IExpr a1) {
        return new AST2(Discriminant, a0, a1);
    }

    public static IAST Distribute(final IExpr a) {
        return new AST1(Distribute, a);
    }

    public static IAST Distribute(final IExpr a0, final IExpr a1) {
        return new AST2(Distribute, a0, a1);
    }

    public static IAST Distribute(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(Distribute, a0, a1, a2);
    }

    /**
     * Create a <code>Distributed(x, &lt;distribution&gt;)</code> AST.
     *
     * @param x
     * @param distribution
     * @return
     */
    public static IAST Distributed(final IExpr x, final IAST distribution) {
        return new AST2(Distributed, x, distribution);
    }

    public static IExpr div(IExpr a, Integer i) {
		return Times(a, Power(ZZ(i.longValue()), CN1));
    }

    public static IExpr div(IExpr a, java.math.BigInteger i) {
		return Times(a, Power(ZZ(i), CN1));
    }

    public static IExpr div(Integer i, IExpr b) {
		return Times(ZZ(i.longValue()), Power(b, CN1));
    }

    public static IExpr div(java.math.BigInteger i, IExpr b) {
		return Times(ZZ(i), Power(b, CN1));
    }

    /**
     * The division <code>arg1 / arg2</code> will be represented by <code>arg1 * arg2^(-1)</code>.
     *
	 * @param arg1
	 *            numerator
	 * @param arg2
	 *            denominator
     * @return
     */
    public static IAST Divide(final IExpr arg1, final IExpr arg2) {
		return new B2.Times(arg1, new B2.Power(arg2, CN1));
    }

    public static IAST Divisible(final IExpr a0, final IExpr a1) {
        return new AST2(Divisible, a0, a1);
    }

    public static IAST DivisorSigma(final IExpr a0, final IExpr a1) {
        return new AST2(DivisorSigma, a0, a1);
    }

    public static IAST Divisors(final IExpr a0) {
        return new AST1(Divisors, a0);
    }

    public static IAST Do(final IExpr a0, final IExpr a1) {
        return new AST2(Do, a0, a1);
    }

    public static IAST Dot(final IExpr... a) {
        return function(Dot, a);
    }

    public static IAST Dot(final IExpr a0, final IExpr a1) {
        return new AST2(Dot, a0, a1);
    }

    public static IAST Drop(final IExpr a0, final IExpr a1) {
        return new AST2(Drop, a0, a1);
    }

    public static IAST DSolve(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(DSolve, a0, a1, a2);
    }

    public static IAST Element(final IExpr a0, final IExpr a1) {
        return new AST2(Element, a0, a1);
    }

	public static IAST ElementData(final IExpr a0) {
		return new AST1(ElementData, a0);
	}

	public static IAST ElementData(final IExpr a0, final IExpr a1) {
		return new AST2(ElementData, a0, a1);
	}

    public static IAST EllipticE(final IExpr a0) {
        return new AST1(EllipticE, a0);
    }

    public static IAST EllipticE(final IExpr a0, final IExpr a1) {
        return new AST2(EllipticE, a0, a1);
    }

    public static IAST EllipticF(final IExpr a0, final IExpr a1) {
        return new AST2(EllipticF, a0, a1);
    }

    public static IAST EllipticK(final IExpr a0) {
        return new AST1(EllipticK, a0);
    }

    public static IAST EllipticPi(final IExpr a0, final IExpr a1) {
        return new AST2(EllipticPi, a0, a1);
    }

    public static IAST EllipticPi(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(EllipticPi, a0, a1, a2);
    }

    public static IAST Equal(final IExpr... a) {
        return function(Equal, a);
    }

    public static IAST Equal(final IExpr a0, final IExpr a1) {
		return new B2.Equal(a0, a1);
    }

    public static IAST Equivalent(final IExpr a0, final IExpr a1) {
        return new AST2(Equivalent, a0, a1);
    }

    public static IAST Erf(final IExpr a) {
        return new AST1(Erf, a);
    }

    public static IAST Erfc(final IExpr a) {
        return new AST1(Erfc, a);
    }

    public static IAST Erfi(final IExpr a) {
        return new AST1(Erfi, a);
    }

    public static IAST ErlangDistribution(final IExpr a0, final IExpr a1) {
        return new AST2(ErlangDistribution, a0, a1);
    }

    /**
     * Evaluate an expression. If no evaluation was possible this method returns the given argument.
     *
	 * @param a
	 *            the expression which should be evaluated
     * @return the evaluated expression
     * @see EvalEngine#evaluate(IExpr)
     */
    public static IExpr eval(IExpr a) {
        return EvalEngine.get().evaluate(a);
    }

    /**
     * Parse and evaluate a string expression.
     *
	 * @param str
	 *            the string expression which should be parsed and evaluated
     * @return the evaluated expression
     * @see EvalEngine#evaluate(IExpr)
     */
    public static IExpr eval(String str) {
        return EvalEngine.get().evaluate(str);
    }

    /**
     * Create a function with 1 argument and evaluate it.
     *
     * @param head
     * @param a0
     * @return the evaluated object
     * @deprecated
     */
    @Deprecated
    private static IExpr eval(final ISymbol head, final IExpr a0) {
        final IASTAppendable ast = ast(head);
        ast.append(a0);
        return EvalEngine.get().evaluate(ast);
    }

    /**
	 * Evaluate <code>Expand()</code> for the given expression. Returns the evaluated expression or the given argument.
     *
	 * @param expr
	 *            the expression which should be evaluated
     * @return the evaluated expression
     * @see EvalEngine#evaluate(IExpr)
     */
	public static IExpr evalExpand(IExpr expr) {
		EvalEngine engine = EvalEngine.get();
		if (expr.isAST()) {
			IAST ast = (IAST) expr;
            if (ast.isPlus()) {
				if (ast.exists(Predicates.isPlusTimesPower)) {
					return engine.evaluate(Expand(expr));
                    }
			} else if (ast.isTimes() || ast.isPower()) {
				return engine.evaluate(Expand(expr));
            }
            }
		return expr;
    }

    /**
     * Apply <code>ExpandAll()</code> to the given expression if it's an <code>IAST</code>. If expanding wasn't possible
     * this method returns the given argument.
     *
	 * @param a
	 *            the expression which should be evaluated
     * @return the evaluated expression
     * @see EvalEngine#evaluate(IExpr)
     */
    public static IExpr evalExpandAll(IExpr a) {
        return evalExpandAll(a, EvalEngine.get());
    }

    /**
     * Apply <code>ExpandAll()</code> to the given expression if it's an <code>IAST</code>. If expanding wasn't possible
     * this method returns the given argument.
     *
	 * @param a
	 *            the expression which should be evaluated
     * @return the evaluated expression
     * @see EvalEngine#evaluate(IExpr)
     */
    public static IExpr evalExpandAll(IExpr a, EvalEngine engine) {
        return engine.evaluate(ExpandAll(a));
    }

    /**
     * Evaluate the given expression in numeric mode
     *
     * @param a0
     * @return
     * @deprecated use EvalEngine.get().evalN() instead
     */
    @Deprecated
    public static IExpr evaln(final IExpr a0) {
        return eval(N, a0);
    }

    /**
     * Evaluate an expression in &quot;quiet mode&quot;. If no evaluation was possible this method returns the given
     * argument. In &quot;quiet mode&quot; all warnings would be suppressed.
     *
	 * @param a
	 *            the expression which should be evaluated
     * @return the evaluated expression
     * @see EvalEngine#evalQuiet(IExpr)
     * @deprecated use EvalEngine#evalQuiet();
     */
    @Deprecated
    public static IExpr evalQuiet(IExpr a) {
        return EvalEngine.get().evalQuiet(a);
    }

    /**
     * Evaluate an expression in &quot;quiet mode&quot;. If evaluation is not possible return <code>null</code>. In
     * &quot;quiet mode&quot; all warnings would be suppressed.
     *
	 * @param a
	 *            the expression which should be evaluated
     * @return the evaluated object or <code>F.NIL</code> if no evaluation was possible
     * @see EvalEngine#evalQuietNull(IExpr)
     * @deprecated use EvalEngine#evalQuietNull()
     */
    @Deprecated
    public static IExpr evalQuietNull(IExpr a) {
        return EvalEngine.get().evalQuietNull(a);
    }

    /**
     * Evaluate the given expression and test if the result equals the symbol <code>True</code>.
     *
     * @param expr
     * @return
     * @deprecated use EvalEngine#evalTrue()
     */
    @Deprecated
    public static boolean evalTrue(IExpr expr) {
        return EvalEngine.get().evalTrue(expr);
    }

    /**
     * <pre>
     * EvenQ(x)
     * </pre>
     *
     * <blockquote>
     * <p>
     * returns <code>True</code> if <code>x</code> is even, and <code>False</code> otherwise.
     * </p>
     * </blockquote>
     * <h3>Examples</h3>
     *
     * <pre>
     * &gt;&gt; EvenQ(4)
     * True
     * &gt;&gt; EvenQ(-3)
     * False
     * &gt;&gt; EvenQ(n)
     * False
     * </pre>
     */
    public static IAST EvenQ(final IExpr x) {
        return new AST1(EvenQ, x);
    }

    /**
     * <pre>
     * ExactNumberQ(expr)
     * </pre>
     *
     * <blockquote>
     * <p>
     * returns <code>True</code> if <code>expr</code> is an exact number, and <code>False</code> otherwise.
     * </p>
     * </blockquote>
     * <h3>Examples</h3>
     *
     * <pre>
     * &gt;&gt; ExactNumberQ(10)
     * True
     *
     * &gt;&gt; ExactNumberQ(4.0)
     * False
     *
     * &gt;&gt; ExactNumberQ(n)
     * False
     *
	 * &gt;&gt; ExactNumberQ(1+I)
     * True
     *
     * &gt;&gt; ExactNumberQ(1 + 1. * I)
     * False
     * </pre>
     */
    public static IAST ExactNumberQ(final IExpr expr) {
        return new AST1(ExactNumberQ, expr);
    }

    public static IAST Exists(final IExpr a0, final IExpr a1) {
        return new AST2(Exists, a0, a1);
    }

    public static IAST Exists(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(Exists, a0, a1, a2);
    }

    /**
     * depending on the derived class of the given {@link Number}, the value is encoded as {@link IInteger},
     * {@link INum}
     *
	 * @param number
	 *            non-null
     * @return scalar with best possible accuracy to encode given number
	 * @throws Exception
	 *             if number is null, or instance of an unsupported type
     */
	public static ISignedNumber expr(Number number) {
        if (number instanceof Integer || //
                number instanceof Long || //
                number instanceof Short || //
                number instanceof Byte)
            return ZZ(number.longValue());
        if (number instanceof Double || //
                number instanceof Float)
            return num(number.doubleValue());
        if (number instanceof BigInteger)
            return ZZ((BigInteger) number);
        throw new IllegalArgumentException(number.getClass().getName());
    }

	public static IAST EuclideanDistance(final IExpr a0, final IExpr a1) {
		return new AST2(EuclideanDistance, a0, a1);
	}
    public static IAST EulerE(final IExpr a0) {
        return new AST1(EulerE, a0);
    }

    public static IAST EulerPhi(final IExpr a0) {
        return new AST1(EulerPhi, a0);
    }

    public static IAST Exp(final IExpr a0) {
		return new B2.Power(E, a0);
    }

    public static IAST ExpToTrig(final IExpr a0) {
        return new AST1(ExpToTrig, a0);
    }

    /**
     * Apply <code>Expand()</code> to the given expression if it's an <code>IAST</code>. If expanding wasn't possible
     * this method returns the given argument.
     *
	 * @param a
	 *            the expression which should be evaluated
	 * @param expandNegativePowers
	 *            TODO
	 * @param distributePlus
	 *            TODO
	 * @param evalParts
	 *            evaluate the determined numerator and denominator parts
     * @return the evaluated expression
     * @see EvalEngine#evaluate(IExpr)
     */
    public static IExpr expand(IExpr a, boolean expandNegativePowers, boolean distributePlus, boolean evalParts) {
        if (a.isAST()) {
            EvalEngine engine = EvalEngine.get();
			IAST ast = engine.evalFlatOrderlessAttributesRecursive((IAST) a).orElse((IAST) a);
            return Algebra.expand(ast, null, expandNegativePowers, distributePlus, evalParts).orElse(a);
        }
        return a;
    }

    public static IAST Expand(final IExpr a0) {
        return new AST1(Expand, a0);
    }

    public static IAST Expand(final IExpr a0, final IExpr a1) {

        return new AST2(Expand, a0, a1);
    }

    /**
     * Apply <code>ExpandAll()</code> to the given expression if it's an <code>IAST</code>. If expanding wasn't possible
     * this method returns the given argument.
     *
	 * @param a
	 *            the expression which should be evaluated
	 * @param expandNegativePowers
	 *            TODO
	 * @param distributePlus
	 *            TODO
     * @return the evaluated expression
     * @see EvalEngine#evaluate(IExpr)
     */
    public static IExpr expandAll(IExpr a, boolean expandNegativePowers, boolean distributePlus) {
        if (a.isAST()) {
            EvalEngine engine = EvalEngine.get();
			IAST ast = engine.evalFlatOrderlessAttributesRecursive((IAST) a).orElse((IAST) a);
			return Algebra.expandAll(ast, null, expandNegativePowers, distributePlus, engine).orElse(ast);
        }
        return a;
    }

    //
    // public static IAST NumberPartitions(final IExpr a0) {
    //
    // return unaryAST2(NumberPartitions, a0);
    // }

    public static IAST ExpandAll(final IExpr a0) {
        return new AST1(ExpandAll, a0);
    }

    public static IAST ExpIntegralE(final IExpr a0, final IExpr a1) {
        return new AST2(ExpIntegralE, a0, a1);
    }

    public static IAST ExpIntegralEi(final IExpr a) {
        return new AST1(ExpIntegralEi, a);
    }

    public static IAST Exponent(final IExpr a0, final IExpr a1) {
        return new AST2(Exponent, a0, a1);
    }

    public static IAST Exponent(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(Exponent, a0, a1, a2);
    }

    public static IAST ExponentialDistribution(final IExpr a0) {
        return new AST1(ExponentialDistribution, a0);
    }

    public static IAST Extract(final IExpr a0, final IExpr a1) {
        return new AST2(Extract, a0, a1);
    }

    public static IAST Factor(final IExpr a0) {
        return new AST1(Factor, a0);
    }

    public static IAST FactorTerms(final IExpr a0) {
        return new AST1(FactorTerms, a0);
    }

    public static IAST Factorial(final IExpr a0) {
        return new AST1(Factorial, a0);
    }

	public static IAST Factorial(final int a0) {
		return new AST1(Factorial, F.ZZ(a0));
	}

    public static IAST Factorial2(final IExpr a0) {
        return new AST1(Factorial2, a0);
    }

    public static IAST FactorInteger(final IExpr a0) {
        return new AST1(FactorInteger, a0);
    }

    public static IAST FactorSquareFree(final IExpr a) {
        return new AST1(FactorSquareFree, a);
    }

    public static IAST FactorSquareFreeList(final IExpr a) {
        return new AST1(FactorSquareFreeList, a);
    }

    public static IAST Fibonacci(final IExpr a0) {
        return new AST1(Fibonacci, a0);
    }

	public static IAST Fibonacci(final IExpr a0, final IExpr a1) {
		return new AST2(Fibonacci, a0, a1);
	}
    public static IAST FindFit(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3) {
        return quaternary(FindFit, a0, a1, a2, a3);
    }

	public static IAST FindShortestPath(final IExpr a0, final IExpr a1, final IExpr a2) {
		return new AST3(FindShortestPath, a0, a1, a2);
	}

	public static IAST FindShortestTour(final IExpr a0) {
		return new AST1(FindShortestTour, a0);
	}

	public static IAST FindSpanningTree(final IExpr a0) {
		return new AST1(FindSpanningTree, a0);
	}
    public static IAST Fit(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(Fit, a0, a1, a2);
    }

	public static IAST FiveNum(final IExpr a) {
		return new AST1(FiveNum, a);
	}
    public static IAST First(final IExpr a0) {
        return new AST1(First, a0);
    }

    public static IAST Flatten(final IExpr a0) {
        return new AST1(Flatten, a0);
    }

    public static IAST Flatten(final IExpr a0, final IExpr a1) {
        return new AST2(Flatten, a0, a1);
    }

    public static IAST Floor(final IExpr a0) {
        return new AST1(Floor, a0);
    }

    public static IAST Fold(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(Fold, a0, a1, a2);
    }

    public static IAST ForAll(final IExpr a0, final IExpr a1) {
        return new AST2(ForAll, a0, a1);
    }

    public static IAST ForAll(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(ForAll, a0, a1, a2);
    }

    /**
     * Create a "fractional" number
     *
	 * @param value
	 *            the rational value which should be converted to a fractional number
     * @return IFraction
     */
    public static IFraction fraction(final BigFraction value) {
        return AbstractFractionSym.valueOf(value.getNumerator(), value.getDenominator());
    }

    /**
     * Create a "fractional" number
     *
	 * @param numerator
	 *            numerator of the fractional number
	 * @param denominator
	 *            denumerator of the fractional number
     * @return IFraction
     */
    public static IFraction fraction(final BigInteger numerator, final BigInteger denominator) {
        return AbstractFractionSym.valueOf(numerator, denominator);
    }

    /**
     * Create a "fractional" number
     *
	 * @param value
	 *            the double value which should be converted to a fractional number
     * @return IFraction
     */
    public static IFraction fraction(final double value) {
        return AbstractFractionSym.valueOfEpsilon(value);
    }

    public static IFraction fraction(final double value, final double epsilon) {
        return AbstractFractionSym.valueOfEpsilon(value, epsilon);
    }

    /**
     * Create a "fractional" number
     *
	 * @param numerator
	 *            numerator of the fractional number
	 * @param denominator
	 *            denumerator of the fractional number
     * @return IFraction
     */
    public static IFraction fraction(final IInteger numerator, final IInteger denominator) {
        return AbstractFractionSym.valueOf(numerator, denominator);
    }

    /**
     * Create a "fractional" number
     *
	 * @param numerator
	 *            numerator of the fractional number
	 * @param denominator
	 *            denumerator of the fractional number
     * @return IFraction
     */
    public static IRational fraction(final long numerator, final long denominator) {
        return AbstractFractionSym.valueOf(numerator, denominator);
    }

    public static IAST FractionalPart(final IExpr a) {
        return new AST1(FractionalPart, a);
    }

    public static IAST FreeQ(final IExpr a0, final IExpr a1) {

		return new B2.FreeQ(a0, a1);
    }

    public static IAST FrechetDistribution(final IExpr a0, final IExpr a1) {
        return new AST2(FrechetDistribution, a0, a1);
    }

    public static IAST FresnelC(final IExpr a) {
        return new AST1(FresnelC, a);
    }

    public static IAST FresnelS(final IExpr a) {
        return new AST1(FresnelS, a);
    }

    public static IAST FullForm(final IExpr a0) {
        return new AST1(FullForm, a0);
    }

    public static IAST FullSimplify(final IExpr a) {
        return new AST1(FullSimplify, a);
    }

    public static IAST Function(final IExpr a0) {
        return new AST1(Function, a0);
    }

    public static IAST Function(final IExpr a0, final IExpr a1) {
        return new AST2(Function, a0, a1);
    }

    public static IAST FunctionExpand(final IExpr a0) {
        return new AST1(FunctionExpand, a0);
    }

    public static IAST FunctionExpand(final IExpr a0, final IExpr a1) {
        return new AST2(FunctionExpand, a0, a1);
    }

	public static IAST FunctionURL(final IExpr a0) {
		return new AST1(FunctionURL, a0);
	}
    public static IAST Get(final IExpr a0) {
        return new AST1(Get, a0);
    }

    public static IAST Get(final String str) {
        return new AST1(Get, F.stringx(str));
    }

    public static IAST Gamma(final IExpr a0) {
        return new AST1(Gamma, a0);
    }

    public static IAST Gamma(final IExpr a0, final IExpr a1) {
        return new AST2(Gamma, a0, a1);
    }

    public static IAST Gamma(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(Gamma, a0, a1, a2);
    }

    public static IAST GammaDistribution(final IExpr a0, final IExpr a1) {
        return new AST2(GammaDistribution, a0, a1);
    }

    public static IAST GammaDistribution(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3) {
        return quaternary(GammaDistribution, a0, a1, a2, a3);
    }

    public static IAST GammaRegularized(final IExpr a0, final IExpr a1) {
        return new AST2(GammaRegularized, a0, a1);
    }

    public static IAST GammaRegularized(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(GammaRegularized, a0, a1, a2);
    }

	public static IAST Gather(final IExpr a0, final IExpr a1) {
		return new AST2(Gather, a0, a1);
	}

	public static IAST GatherBy(final IExpr a0, final IExpr a1) {
		return new AST2(GatherBy, a0, a1);
	}
    public static IAST GCD(final IExpr a0) {
        return new AST1(GCD, a0);
    }

    public static IAST GCD(final IExpr a0, final IExpr a1) {
        return new AST2(GCD, a0, a1);
    }

    public static IAST GegenbauerC(final IExpr a0, final IExpr a1) {
        return new AST2(GegenbauerC, a0, a1);
    }

	public static IAST GegenbauerC(final IExpr a0, final IExpr a1, final IExpr a2) {
		return new AST3(GegenbauerC, a0, a1, a2);
	}
	public static IAST GeoDistance(final IExpr a0, final IExpr a1) {
		return new AST2(GeoDistance, a0, a1);
	}
    public static IAST GeometricMean(final IExpr a0) {
        return new AST1(GeometricMean, a0);
    }

    public static IAST Grad(final IExpr a0, final IExpr a1) {
        return new AST2(Grad, a0, a1);
    }

	public static IAST Graph(final IExpr a0, final IExpr a1) {
		return new AST2(Graph, a0, a1);
	}
	public static IAST Graph(final IExpr a0, final IExpr a1, final IExpr a2) {
		return new AST3(Graph, a0, a1, a2);
	}
    public static IASTAppendable Graphics() {
        return ast(Graphics);
    }

    public static IAST Greater(final IExpr a0, final IExpr a1) {
		return new B2.Greater(a0, a1);
    }

    public static IAST GreaterEqual(final IExpr a0, final IExpr a1) {
		return new B2.GreaterEqual(a0, a1);
    }

    public static IAST GumbelDistribution() {
        return new AST0(GumbelDistribution);
    }

    public static IAST GumbelDistribution(final IExpr a0, final IExpr a1) {
        return new AST2(GumbelDistribution, a0, a1);
    }

	public static IAST HarmonicMean(final IExpr a0) {
		return new AST1(HarmonicMean, a0);
	}
    public static IAST HarmonicNumber(final IExpr a) {
        return new AST1(HarmonicNumber, a);
    }

    public static IAST HarmonicNumber(final IExpr a0, final IExpr a1) {
        return new AST2(HarmonicNumber, a0, a1);
    }

	public static IAST Haversine(final IExpr a) {
		return new AST1(Haversine, a);
	}
    public static IAST Head(final IExpr a) {
        return new AST1(Head, a);
    }

    /**
     * Create a new abstract syntax tree (AST).
     *
	 * @param head
	 *            the header expression of the function. If the ast represents a function like
	 *            <code>f[x,y], Sin[x],...</code>, the <code>head</code> will be an instance of type ISymbol.
	 *
     */
    public final static IASTMutable headAST0(final IExpr head) {
        return new AST0(head);
    }

    public static IAST HeavisideTheta(final IExpr a0) {
        return new AST1(HeavisideTheta, a0);
    }

	public static IAST HermitianMatrixQ(final IExpr a0) {
		return new AST1(HermitianMatrixQ, a0);
	}

	public static IAST Histogram(final IExpr a) {
		return new AST1(Histogram, a);
	}
    public static IAST Hold(final IExpr a0) {
        return new AST1(Hold, a0);
    }

    public static IAST HoldForm(final IExpr a0) {
        return new AST1(HoldForm, a0);
    }

    public static IAST HoldPattern(final IExpr a0) {
        return new AST1(HoldPattern, a0);
    }

    public static IAST HurwitzZeta(final IExpr a0, final IExpr a1) {
        return new AST2(HurwitzZeta, a0, a1);
    }

    public static IAST Hypergeometric0F1(final IExpr a0, final IExpr a1) {
        return new AST2(Hypergeometric0F1, a0, a1);
    }

	public static IAST Hypergeometric1F1(final IExpr a0, final IExpr a1, final IExpr a2) {
		return new AST3(Hypergeometric1F1, a0, a1, a2);
	}

    public static IAST Hypergeometric1F1Regularized(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(Hypergeometric1F1Regularized, a0, a1, a2);
    }

    public static IAST Hypergeometric2F1(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3) {
        return quaternary(Hypergeometric2F1, a0, a1, a2, a3);
    }

    public static IAST HypergeometricPFQ(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(HypergeometricPFQ, a0, a1, a2);
    }

    public static IAST HypergeometricPFQRegularized(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(HypergeometricPFQRegularized, a0, a1, a2);
    }

	public static IAST HypergeometricU(final IExpr a0, final IExpr a1, final IExpr a2) {
		return new AST3(HypergeometricU, a0, a1, a2);
	}

    public static IAST Identity(final IExpr a0) {
        return new AST1(Identity, a0);
    }

    public static IAST If(final IExpr a0, final IExpr a1) {
		return new B2.If(a0, a1);
    }

    public static IAST If(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(If, a0, a1, a2);
    }

    public static IAST If(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3) {
        return quaternary(If, a0, a1, a2, a3);
    }

    public static IAST IInit(final ISymbol sym, int[] sizes) {
        sym.createRulesData(sizes);
        return null;
    }

    public static IExpr Im(final IExpr a0) {
        if (a0 != null && a0.isNumber()) {
            return ((INumber) a0).im();
        }
        return new AST1(Im, a0);
    }

    public static IAST Implies(final IExpr a0, final IExpr a1) {
        return new AST2(Implies, a0, a1);
    }

    public static IAST Increment(final IExpr a) {
        return new AST1(Increment, a);
    }

    public static IAST Inequality(final IExpr... a) {
        return function(Inequality, a);
    }

    /**
     * <pre>
     * InexactNumberQ(expr)
     * </pre>
     *
     * <blockquote>
     * <p>
     * returns <code>True</code> if <code>expr</code> is not an exact number, and <code>False</code> otherwise.
     * </p>
     * </blockquote>
     * <h3>Examples</h3>
     *
     * <pre>
     * &gt;&gt; InexactNumberQ(a)
     * False
     *
     * &gt;&gt; InexactNumberQ(3.0)
     * True
     *
     * &gt;&gt; InexactNumberQ(2/3)
     * False
     * </pre>
     * <p>
     * <code>InexactNumberQ</code> can be applied to complex numbers:
     * </p>
     *
     * <pre>
	 * &gt;&gt; InexactNumberQ(4.0+I)
     * True
     * </pre>
     */
    public static IAST InexactNumberQ(final IExpr a) {
        return new AST1(InexactNumberQ, a);
    }

    public static IAST Information(final IExpr a) {
        return new AST1(Information, a);
    }

    public static IAST Information(final IExpr a0, final IExpr a1) {
        return new AST2(Information, a0, a1);
    }


	public static IPattern initPredefinedPattern(final ISymbol symbol) {
        IPattern temp = new Pattern(symbol);
        PREDEFINED_PATTERN_MAP.put(symbol.toString(), temp);
        return temp;
    }

	public static IPatternSequence initPredefinedPatternSequence(final ISymbol symbol) {
        PatternSequence temp = PatternSequence.valueOf(symbol, false);
        PREDEFINED_PATTERNSEQUENCE_MAP.put(symbol.toString(), temp);
        return temp;
    }

    /**
     * Initialize the complete System. Calls {@link #initSymbols(String, ISymbolObserver, boolean)} with parameters
     * <code>null, null</code>.
     */
    public synchronized static void initSymbols() {
        initSymbols(null, null, false);
    }

    /**
     * Initialize the complete System
     *
	 * @param fileName
	 *            <code>null</code> or optional text filename, which includes the preloaded system rules
	 * @param symbolObserver
	 *            the observer for newly created <code>ISymbols</code>
	 * @param noPackageLoading
	 *            don't load any package at start up
     */
    public synchronized static void initSymbols(String fileName, ISymbolObserver symbolObserver,
                                                boolean noPackageLoading) {

        if (!isSystemStarted) {
            try {
                isSystemStarted = true;

                if (Config.SHOW_PATTERN_EVAL_STEPS) {
                    // watch the rules which are used in pattern matching in
                    // system.out
                    Config.SHOW_PATTERN_SYMBOL_STEPS.add(Integrate);
                }
                if (symbolObserver != null) {
                    SYMBOL_OBSERVER = symbolObserver;
                }

                // if (!noPackageLoading) {
                // Reader reader = null;
                // if (fileName != null) {
                // try {
                // reader = new InputStreamReader(new FileInputStream(fileName), "UTF-8");
                // } catch (FileNotFoundException e) {
                // e.printStackTrace();
                // }
                // }
                // if (reader == null) {
                // InputStream systemPackage = F.class.getResourceAsStream("/System.mep");
                // if (systemPackage != null) {
                // reader = new InputStreamReader(systemPackage, "UTF-8");
                // }
                // }
                // if (reader != null) {
                // org.matheclipse.core.builtin.function.Package.loadPackage(EvalEngine.get(), reader);
                // }
                // }

                isSystemInitialized = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static IAST Insert(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(Insert, a0, a1, a2);
    }

    /**
     * Create a large integer number.
     *
     * @param integerValue
     * @return
	 * @deprecated use ZZ()
     */
    public static IInteger integer(final BigInteger integerValue) {
        return AbstractIntegerSym.valueOf(integerValue);
    }

    /**
     * Create a large integer number.
     *
     * @param integerValue
     * @return
	 * @deprecated use ZZ()
     */
    public static IInteger integer(final long integerValue) {
        return AbstractIntegerSym.valueOf(integerValue);
    }

    /**
     * Create a large integer number.
     *
	 * @param integerString
	 *            the integer number represented as a String
	 * @param radix
	 *            the radix to be used while parsing
     * @return Object
	 * @deprecated use ZZ()
     */
    public static IInteger integer(final String integerString, final int radix) {
        return AbstractIntegerSym.valueOf(integerString, radix);
    }

    public static IAST IntegerPart(final IExpr a0) {
        return new AST1(IntegerPart, a0);
    }

	public static IAST IntegerName(final IExpr a0) {
		return new AST1(IntegerName, a0);
	}

	public static IAST IntegerName(final IExpr a0, final IExpr a1) {
		return new AST2(IntegerName, a0, a1);
	}

    /**
     * <pre>
     * IntegerQ(expr)
     * </pre>
     *
     * <blockquote>
     * <p>
     * returns <code>True</code> if <code>expr</code> is an integer, and <code>False</code> otherwise.
     * </p>
     * </blockquote>
     * <h3>Examples</h3>
     *
     * <pre>
     * &gt;&gt; IntegerQ(3)
     * 4
     *
     * &gt;&gt; IntegerQ(Pi)
     * False
     * </pre>
     */
    public static IAST IntegerQ(final IExpr a) {
		return new B1.IntegerQ(a);
    }

    public static IAST Integrate(final IExpr a0, final IExpr a1) {
		return new B2.Integrate(a0, a1);
    }

    public static IAST Interpolation(final IExpr list) {
        return new AST1(Interpolation, list);
    }


    public static IAST InterpolatingPolynomial(final IExpr a0, final IExpr a1) {
        return new AST2(InterpolatingPolynomial, a0, a1);
    }

	/**
	 * Create a new <code>List</code> with the given <code>capacity</code>.
	 *
	 * @param capacity
	 *            the assumed number of arguments (+ 1 for the header expression is added internally).
	 * @return
	 */
	public static IASTAppendable IntervalAlloc(int capacity) {
		return ast(Interval, capacity, false);
	}
    /**
     * Create an "interval" expression: <code>Interval(list)</code>.
     *
     * @param list
     * @return
     */
    public static IAST Interval(final IExpr list) {
        return new AST1(Interval, list);
    }

    /**
     * Create an "interval" expression: <code>Interval(List(from, to))</code>.
     *
	 * @param min
	 *            minimum value of the interval
	 * @param max
	 *            maximum value of the interval
     * @return
     */
    public static IAST Interval(final IExpr min, final IExpr max) {
        return new AST1(Interval, binaryAST2(List, min, max));
    }

    /**
     * Iterate over an integer range <code>from <= i <= to</code> with the step <code>step/code>.
     *
	 * @param head
	 *            the header symbol of the result
	 * @param function
	 *            the function which should be applied on each iterator value
     * @param from
     * @param to
     * @param step
     * @return
     */
    public static IAST intIterator(ISymbol head, final Function<IExpr, IExpr> function, final int from, final int to,
                                   final int step) {
        IASTAppendable result = F.ast(head, to - from + 1, false);
		long numberOfLeaves = 0;
        for (int i = from; i <= to; i += step) {
			IExpr temp = function.apply(F.ZZ(i));
			numberOfLeaves += temp.leafCount() + 1;
			if (numberOfLeaves >= Config.MAX_AST_SIZE) {
				ASTElementLimitExceeded.throwIt(numberOfLeaves);
			}
			result.append(temp);
        }
        return result;
    }

	/**
	 * Iterate over an integer range <code>from <= i <= to</code> with the step <code>step/code>.
	 *
	 * @param head
	 *            the header symbol of the result
	 * @param function
	 *            the integer function which should be applied on each iterator value
	 * @param from
	 * @param to
	 * @param step
	 * @return
	 */
	public static IAST intIterator(ISymbol head, final IntFunction<IExpr> function, final int from, final int to,
			final int step) {
		IASTAppendable result = F.ast(head, to - from + 1, false);
		for (int i = from; i <= to; i += step) {
			result.append(function.apply(i));
		}
		return result;
	}

    public static IAST intIterator(ISymbol head, final Function<IExpr, IExpr> function, final IAST list) {
        IASTAppendable result = F.ast(head, list.size(), false);
        for (int i = 1; i < list.size(); i++) {
            result.append(function.apply(list.get(i)));
        }
        return result;
    }

    public static IAST Inverse(final IExpr a0) {

        return new AST1(Inverse, a0);
    }

    public static IAST InverseBetaRegularized(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(InverseBetaRegularized, a0, a1, a2);
    }

    public static IAST InverseBetaRegularized(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3) {
        return quaternary(InverseBetaRegularized, a0, a1, a2, a3);
    }

    public static IAST InverseErf(final IExpr a0) {
        return new AST1(InverseErf, a0);
    }

    public static IAST InverseErfc(final IExpr a0) {
        return new AST1(InverseErfc, a0);
    }

    public static IAST InverseFunction(final IExpr a) {
        return new AST1(InverseFunction, a);
    }

    public static IAST InverseGammaRegularized(final IExpr a0, final IExpr a1) {
        return new AST2(InverseGammaRegularized, a0, a1);
    }

    public static IAST InverseGammaRegularized(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(InverseGammaRegularized, a0, a1, a2);
    }

	public static IAST InverseHaversine(final IExpr a) {
		return new AST1(InverseHaversine, a);
	}
    public static IAST InverseLaplaceTransform(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(InverseLaplaceTransform, a0, a1, a2);
    }

    /**
     * Assign the evaluated <code>rhs</code> to the <code>lhs</code>.<br/>
     *
     * <b>Note:</b> this method returns <code>F.NIL</code>.
     *
	 * @param lhs
	 *            left-hand-side of the assignment
	 * @param rhs
	 *            right-hand-side of the assignment
     * @return <code>F.NIL</code>
     */
    public static IAST ISet(final IExpr lhs, final IExpr rhs) {
        if (lhs.isAST()) {
            ((IAST) lhs).setEvalFlags(((IAST) lhs).getEvalFlags() | IAST.IS_FLATTENED_OR_SORTED_MASK);
        }
        PatternMatching.setDownRule(IPatternMatcher.NOFLAG, lhs, rhs, true);
        return F.NIL;
    }

    /**
     * Assign the unevaluated <code>rhs</code> to the <code>lhs</code>.<br/>
     *
     * <b>Note:</b> this method returns <code>F.NIL</code>.
     *
	 * @param lhs
	 *            left-hand-side of the assignment
	 * @param rhs
	 *            right-hand-side of the assignment
     * @return <code>F.NIL</code>
     */
    public static IAST ISetDelayed(final IExpr lhs, final IExpr rhs) {
        if (lhs.isAST()) {
            ((IAST) lhs).setEvalFlags(((IAST) lhs).getEvalFlags() | IAST.IS_FLATTENED_OR_SORTED_MASK);
        }
        PatternMatching.setDelayedDownRule(IPatternMapImpl.DEFAULT_RULE_PRIORITY, lhs, rhs, true);
        return F.NIL;
    }

    public static IAST ISetDelayed(int priority, final IExpr lhs, final IExpr rhs) {
        if (lhs.isAST()) {
            ((IAST) lhs).setEvalFlags(((IAST) lhs).getEvalFlags() | IAST.IS_FLATTENED_OR_SORTED_MASK);
        }
        PatternMatching.setDelayedDownRule(priority, lhs, rhs, true);
        return F.NIL;
    }

    public static IExpr IIntegrate(int priority, final IAST lhs, final IExpr rhs) {
        ((IAST) lhs).setEvalFlags(((IAST) lhs).getEvalFlags() | IAST.IS_FLATTENED_OR_SORTED_MASK);
        org.matheclipse.core.reflection.system.Integrate.INTEGRATE_RULES_DATA.putDownRule(IPatternMatcher.SET_DELAYED,
                false, lhs, rhs, priority);
        return F.NIL;
    }

    public static boolean isNumEqualInteger(double value, IInteger ii) throws ArithmeticException {
        return isZero(value - ii.doubleValue(), Config.DOUBLE_TOLERANCE);
    }

	/**
	 * Test if <code>rational.doubleValue()</code> equals <code>value</code> within the tolerance
	 * <code>Config.DOUBLE_TOLERANCE</code>.
	 *
	 * @param value
	 * @param rational
	 * @return
	 * @throws ArithmeticException
	 */
    public static boolean isNumEqualRational(double value, IRational rational) throws ArithmeticException {
        return isZero(value - rational.doubleValue(), Config.DOUBLE_TOLERANCE);
    }

	/**
	 * Test if the value is a Java <code>int</code> value within the tolerance <code>Config.DOUBLE_TOLERANCE</code>.
	 *
	 * @param value
	 * @return
	 */
    public static boolean isNumIntValue(double value) {
        return isZero(value - Math.rint(value), Config.DOUBLE_TOLERANCE);
    }

	/**
	 * Test if the value is a Java <code>int</code> value within the given tolerance <code>epsilon</code>.
	 *
	 * @param value
	 * @param epsilon
	 *            the tolerance
	 * @return
	 */
    public static boolean isNumIntValue(double value, double epsilon) {
        return isZero(value - Math.rint(value), epsilon);
    }

    public static boolean isNumIntValue(double value, int i) {
        return isZero(value - i, Config.DOUBLE_TOLERANCE);
    }

    /**
     * Check difference is less than a constant
	 *
     * infinity == infinity returns true eg 1/0
	 *
     * -infinity == infinity returns false eg -1/0
	 *
     * -infinity == -infinity returns true
	 *
     * undefined == undefined returns false eg 0/0
     *
     * @return whether x is equal to y
	 *
	 *
     */
    final public static boolean isEqual(double x, double y) {
        return isFuzzyEquals(x, y, Config.MACHINE_EPSILON);
    }

    /**
     * Returns {@code true} if {@code a} and {@code b} are within {@code tolerance} (exclusive) of each other.
     *
     * <p>
     * Technically speaking, this is equivalent to {@code Math.abs(a - b) <= tolerance ||
     * Double.valueOf(a).equals(Double.valueOf(b))}.
     *
     * <p>
     * Notable special cases include:
     *
     * <ul>
     * <li>All NaNs are fuzzily equal.
     * <li>If {@code a == b}, then {@code a} and {@code b} are always fuzzily equal.
     * <li>Positive and negative zero are always fuzzily equal.
     * <li>If {@code tolerance} is zero, and neither {@code a} nor {@code b} is NaN, then {@code a} and {@code b} are
     * fuzzily equal if and only if {@code a == b}.
     * <li>With {@link Double#POSITIVE_INFINITY} tolerance, all non-NaN values are fuzzily equal.
     * <li>With finite tolerance, {@code Double.POSITIVE_INFINITY} and {@code
	 *       Double.NEGATIVE_INFINITY} are fuzzily equal only to themselves.
     * </ul>
     *
     * <p>
     * This is reflexive and symmetric, but <em>not</em> transitive, so it is <em>not</em> an equivalence relation and
     * <em>not</em> suitable for use in {@link Object#equals} implementations.
     *
	 * @throws IllegalArgumentException
	 *             if {@code tolerance} is {@code < 0} or NaN
     */
    public static boolean isFuzzyEquals(double a, double b, double tolerance) {
        return Math.copySign(a - b, 1.0) < tolerance
                // copySign(x, 1.0) is a branch-free version of abs(x), but with different NaN semantics
                || (a == b) // needed to ensure that infinities equal themselves
                || (Double.isNaN(a) && Double.isNaN(b));
    }

    /**
	 * Test if the absolute value is less <code>Config.DOUBLE_EPSILON</code>.
     *
     * @param value
     * @return
     */
    public static boolean isZero(double value) {
        //Swift changed: use DOUBLE_TOLERANCE in order to avoid infinity loop.
        return isZero(value, Config.DOUBLE_TOLERANCE);
    }


    /**
     * Test if the absolute value is less <code>Config.DOUBLE_TOLERANCE</code>.
     *
     * @param value
     * @return
     */
    public static boolean isZero(org.hipparchus.complex.Complex value) {
        //Swift changed: use DOUBLE_TOLERANCE
		return org.hipparchus.complex.Complex.equals(value, org.hipparchus.complex.Complex.ZERO,
				Config.DOUBLE_TOLERANCE);
    }


    /**
     * Test if the absolute value is less than the given epsilon.
     *
     * @param x
     * @param epsilon
     * @return
     */
    public static boolean isZero(double x, double epsilon) {
        return isFuzzyEquals(x, 0.0, epsilon);
        // return -epsilon < x && x < epsilon;
    }

	/**
	 * Test if the absolute value is less <code>Config.MACHINE_EPSILON</code>.
	 *
	 * @param x
	 * @param epsilon
	 * @return
	 */
	public static boolean isZero(org.hipparchus.complex.Complex x, double epsilon) {
		return org.hipparchus.complex.Complex.equals(x, org.hipparchus.complex.Complex.ZERO, epsilon);
	}
	/**
	 * Create JavaScript form data in the given format.
	 *
	 * @param plainJavaScript
	 * @param format
	 * @return
	 */
	public static IAST JSFormData(final String plainJavaScript, final String format) {
		return new AST2(JSFormData, F.$str(plainJavaScript), F.$str(format));
	}
	public static IAST JacobiAmplitude(final IExpr a0, final IExpr a1) {
		return new AST2(JacobiAmplitude, a0, a1);
	}

	public static IAST JacobiCD(final IExpr a0, final IExpr a1) {
		return new AST2(JacobiCD, a0, a1);
	}
	public static IAST JacobiCN(final IExpr a0, final IExpr a1) {
		return new AST2(JacobiCN, a0, a1);
	}

	public static IAST JacobiDC(final IExpr a0, final IExpr a1) {
		return new AST2(JacobiDC, a0, a1);
	}

	public static IAST JacobiNC(final IExpr a0, final IExpr a1) {
		return new AST2(JacobiNC, a0, a1);
	}

	public static IAST JacobiND(final IExpr a0, final IExpr a1) {
		return new AST2(JacobiND, a0, a1);
	}
	public static IAST JacobiDN(final IExpr a0, final IExpr a1) {
		return new AST2(JacobiDN, a0, a1);
	}

	public static IAST JacobiSC(final IExpr a0, final IExpr a1) {
		return new AST2(JacobiSC, a0, a1);
	}

	public static IAST JacobiSD(final IExpr a0, final IExpr a1) {
		return new AST2(JacobiSD, a0, a1);
	}
	public static IAST JacobiSN(final IExpr a0, final IExpr a1) {
		return new AST2(JacobiSN, a0, a1);
	}
    public static IAST Join(final IExpr a0, final IExpr a1) {
        return new AST2(Join, a0, a1);
    }

	public static IAST Key(final IExpr a0) {
		return new AST1(Key, a0);
	}

	public static IAST KleinInvariantJ(final IExpr a0) {
		return new AST1(KleinInvariantJ, a0);
	}
    public static IAST KroneckerDelta(final IExpr a0) {
        return new AST1(KroneckerDelta, a0);
    }

    public static IAST KroneckerDelta(final IExpr a0, final IExpr a1) {
        return new AST2(KroneckerDelta, a0, a1);
    }

    public static IAST LaguerreL(final IExpr a0, final IExpr a1) {
        return new AST2(LaguerreL, a0, a1);
    }

    public static IAST LaguerreL(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(LaguerreL, a0, a1, a2);
    }

    public static IAST LaplaceTransform(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(LaplaceTransform, a0, a1, a2);
    }

    public static IAST Last(final IExpr a0) {
        return new AST1(Last, a0);
    }

    public static IAST LCM(final IExpr a0, final IExpr a1) {
        return new AST2(LCM, a0, a1);
    }

    public static IAST LegendreP(final IExpr a0, final IExpr a1) {
        return new AST2(LegendreP, a0, a1);
    }

    public static IAST LegendreP(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(LegendreP, a0, a1, a2);
    }

    public static IAST LegendreQ(final IExpr a0, final IExpr a1) {
        return new AST2(LegendreQ, a0, a1);
    }

    public static IAST LegendreQ(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(LegendreQ, a0, a1, a2);
    }

    public static IAST LeafCount(final IExpr a0) {
        return new AST1(LeafCount, a0);
    }

    public static IAST Length(final IExpr a) {
        return new AST1(Length, a);
    }

    public static IAST Less(final IExpr a0, final IExpr a1) {
		return new B2.Less(a0, a1);
    }

    public static IAST Less(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(Less, a0, a1, a2);
    }

    public static IAST Less(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3) {
        return quaternary(Less, a0, a1, a2, a3);
    }

    public static IAST Less(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3, final IExpr a4) {
        return quinary(Less, a0, a1, a2, a3, a4);
    }

    public static IAST LessEqual(final IExpr a0, final IExpr a1) {
		return new B2.LessEqual(a0, a1);
    }

    public static IAST LessEqual(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(LessEqual, a0, a1, a2);
    }

    public static IAST LessEqual(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3) {
        return quaternary(LessEqual, a0, a1, a2, a3);
    }

    public static IAST Limit(final IExpr a0, final IExpr a1) {
        return new AST2(Limit, a0, a1);
    }

    public static IAST Limit(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(Limit, a0, a1, a2);
    }

    public static IASTAppendable Line() {
        return ast(Line);
    }

	public static IAST Line(final IExpr a0) {
		return new B1.Line(a0);
	}
    public static IAST LinearModelFit(final IExpr a0) {
        return new AST1(LinearModelFit, a0);
    }

    public static IAST LinearModelFit(final IExpr a0, final IExpr a1) {
        return new AST2(LinearModelFit, a0, a1);
    }

    public static IAST LinearModelFit(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(LinearModelFit, a0, a1, a2);
    }

    public static IAST LinearModelFit(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3) {
        return quaternary(LinearModelFit, a0, a1, a2, a3);
    }

    public static IAST LinearProgramming(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(LinearProgramming, a0, a1, a2);
    }

    public static IAST LinearSolve(final IExpr a0, final IExpr a1) {
        return new AST2(LinearSolve, a0, a1);
    }

    /**
     * Create an appendable list <code>{ }</code>.
     *
     * @return
     * @see {@link #List()} to create an empty unmodifiable AST
     */
    public static IASTAppendable ListAlloc() {
		return ast(List, 3, false);
    }

    /**
     * Create a new <code>List</code> with the given <code>capacity</code>.
     *
	 * @param capacity
	 *            the assumed number of arguments (+ 1 for the header expression is added internally).
     * @return
     */
    public static IASTAppendable ListAlloc(int capacity) {
        return ast(List, capacity, false);
    }

    /**
     * Create an appendable list <code>{ }</code>.
     *
     * @param a
     * @return
     * @see {@link #List(final IExpr...)} to create an unmodifiable AST
     */
    public static IASTAppendable ListAlloc(final IExpr... a) {
        return ast(a, List);
    }

    /**
     * For positive n, add the first n elements of <code>numbers</code> to the list.For negative n, add the last n
     * elements of <code>numbers</code> to the list.
     *
     * @param n
     * @param numbers
     * @return
     */
	public static IAST tensorList(final int n, final Integer... numbers) {
        int nPositive = n;
        if (n < 0) {
            nPositive = -n;
        }
        int size = numbers.length;
        if (nPositive > size) {
            nPositive = size;
        }
        IInteger[] a = new IInteger[nPositive];
        if (n < 0) {
            if (nPositive < size) {
                size = size + n;
            } else {
                size = 0;
            }
            int j = 0;
            for (int i = numbers.length - 1; i >= size; i--) {
                a[j++] = F.ZZ(numbers[i]);
            }
        } else {
            if (n < size) {
                size = n;
            }
            for (int i = 0; i < size; i++) {
                a[i] = F.ZZ(numbers[i]);
            }
        }
        return ast(a, List);
    }

    public static IAST List(final double... numbers) {
        INum a[] = new INum[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            a[i] = num(numbers[i]);
        }
        return function(List, a);
    }

    /**
     * Create an empty immutable list <code>{ }</code> (i.e. <code>List()</code>).
     *
     * @return
     * @see {@link #ListAlloc()} to create an appendable list
     */
    public static IAST List() {
        return F.CEmptyList;
    }

    /**
     * Create an immutable list <code>{ }</code>.
     *
     * @param a
     * @return
     * @see {@link #ListAlloc(final IExpr...)} to create an appendable list
     */
    public static IAST List(final IExpr... a) {
        switch (a.length) {
            case 1:
                if (a[0] != null) {
                    if (a[0].equals(F.C0)) {
                        return F.CListC0;
                    }
                    if (a[0].equals(F.C1)) {
                        return F.CListC1;
                    }
                    if (a[0].equals(F.C2)) {
                        return F.CListC2;
                    }
				return new B1.List(a[0]);
                }
                break;
            case 2:
                if (a[0] != null) {
                    if (a[0].equals(F.C1)) {
                        if (a[1].equals(F.C1)) {
                            return F.CListC1C1;
                        }
                        if (a[1].equals(F.C2)) {
                            return F.CListC1C2;
                        }
                    } else if (a[0].equals(F.C2)) {
                        if (a[1].equals(F.C1)) {
                            return F.CListC2C1;
                        }
                        if (a[1].equals(F.C2)) {
                            return F.CListC2C2;
                        }
                    }
				return new B2.List(a[0], a[1]);
                }
                break;
            case 3:
                return new AST3(List, a[0], a[1], a[2]);
        }
        return ast(a, List);
    }

    public static IAST List(final long... numbers) {
        IInteger a[] = new IInteger[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
			a[i] = ZZ(numbers[i]);
        }
        return function(List, a);
    }

	public static IAST List(final int... numbers) {
		IInteger a[] = new IInteger[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			a[i] = ZZ(numbers[i]);
		}
		return function(List, a);
	}
    public static IAST ListConvolve(final IExpr a0, final IExpr a1) {
        return new AST2(ListConvolve, a0, a1);
    }

	public static IAST ListPlot(final IExpr a) {
		return new AST1(ListPlot, a);
	}

    /**
     * <pre>
     * ListQ(expr)
     * </pre>
     *
     * <blockquote>
     * <p>
     * tests whether <code>expr</code> is a <code>List</code>.
     * </p>
     * </blockquote>
     * <h3>Examples</h3>
     *
     * <pre>
     * &gt;&gt; ListQ({1, 2, 3})
     * True
     *
     * &gt;&gt; ListQ({{1, 2}, {3, 4}})
     * True
     *
     * &gt;&gt; ListQ(x)
     * False
     * </pre>
     */
    public static IAST ListQ(final IExpr a) {
        return new AST1(ListQ, a);
    }

    /**
	 *
     * @param a0
     * @return
     * @deprecated use HoldPattern
     */
    public static IAST Literal(final IExpr a0) {
        return new AST1(Literal, a0);
    }

    public static IAST Log(final IExpr a0) {
		return new B1.Log(a0);
    }

    public static IAST Log(final IExpr a0, final IExpr a1) {

        return new AST2(Log, a0, a1);
    }

    /**
     * <code>Log[10, a0]</code>.
     *
     * @param a0
     * @return <code>Log[10, a0]</code>.
     */
    public static IAST Log10(final IExpr a0) {

        return new AST2(Log, F.C10, a0);
    }

    public static IAST LogGamma(final IExpr a0) {
        return new AST1(LogGamma, a0);
    }

    public static IAST LogIntegral(final IExpr a) {
        return new AST1(LogIntegral, a);
    }

    public static IAST LogisticSigmoid(final IExpr a) {
        return new AST1(LogisticSigmoid, a);
    }

    public static IAST LogNormalDistribution(final IExpr a0, final IExpr a1) {
        return new AST2(LogNormalDistribution, a0, a1);
    }

    public static IAST LucasL(final IExpr a) {
        return new AST1(LucasL, a);
    }

	public static IAST LucasL(final IExpr a, final IExpr b) {
		return new AST2(LucasL, a, b);
	}

    /**
     * <pre>
     * MachineNumberQ(expr)
     * </pre>
     *
     * <blockquote>
     * <p>
     * returns <code>True</code> if <code>expr</code> is a machine-precision real or complex number.
     * </p>
     * </blockquote>
     * <h3>Examples</h3>
     *
     * <pre>
     * &gt;&gt; MachineNumberQ(3.14159265358979324)
     * False
     *
     * &gt;&gt; MachineNumberQ(1.5 + 2.3*I)
     * True
     *
     * &gt;&gt; MachineNumberQ(2.71828182845904524 + 3.14159265358979324*I)
     * False
     *
	 * &gt;&gt; MachineNumberQ(1.5 + 3.14159265358979324*I)
     * True
     *
     * &gt;&gt; MachineNumberQ(1.5 + 5 *I)
     * True
     * </pre>
     */
    public static IAST MachineNumberQ(final IExpr a0) {
        return new AST1(MachineNumberQ, a0);
    }

	public static IAST Manipulate(final IExpr a0) {
		return new AST1(Manipulate, a0);
	}
    public static IAST Manipulate(final IExpr a0, final IExpr a1) {
        return new AST2(Manipulate, a0, a1);
    }

    public static IAST Map(final IExpr a0) {

        return new AST1(Map, a0);
    }

    public static IAST Map(final IExpr a0, final IExpr a1) {
        return new AST2(Map, a0, a1);
    }

	public static IAST Map(final IExpr a0, final IExpr a1, final IExpr a2) {
		return new AST3(Map, a0, a1, a2);
	}
    public static IAST MapThread(final IExpr a0, final IExpr a1) {
        return new AST2(MapThread, a0, a1);
    }

    public static IAST MapAll(final IExpr a0) {

        return new AST1(MapAll, a0);
    }

    public static IAST MatchQ(final IExpr a0, final IExpr a1) {
        return new AST2(MatchQ, a0, a1);
    }

    public static IAST MathMLForm(final IExpr a0) {
        return new AST1(MathMLForm, a0);
    }

	public static IAST MatrixForm(final IExpr a0) {
		return new AST1(MatrixForm, a0);
	}

    public static IAST MatrixPower(final IExpr a0, final IExpr a1) {

        return new AST2(MatrixPower, a0, a1);
    }

    public static IASTAppendable Max() {
        return ast(Max);
    }

    public static IAST Max(final IExpr a0) {
        return new AST1(Max, a0);
    }

    public static IAST Max(final IExpr a0, final IExpr a1) {
        return new AST2(Max, a0, a1);
    }

    public static IAST Max(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3) {
        return quaternary(Max, a0, a1, a2, a3);
    }

	public static IAST Maximize(final IExpr a0, final IExpr a1) {
		return new AST2(Maximize, a0, a1);
	}
    public static IAST Mean(final IExpr a0) {
        return new AST1(Mean, a0);
    }

    public static IAST MeanDeviation(final IExpr a0) {
        return new AST1(MeanDeviation, a0);
    }

    public static IAST Median(final IExpr a0) {
        return new AST1(Median, a0);
    }

    public static IAST MeijerG(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(MeijerG, a0, a1, a2);
    }

    public static IAST MemberQ(final IExpr a0, final IExpr a1) {
		return new B2.MemberQ(a0, a1);
    }

    public static IAST MessageName(final IExpr a0, final IExpr a1) {
        return new AST2(MessageName, a0, a1);
    }

    public static IASTAppendable Min() {
        return ast(Min);
    }

    public static IAST Min(final IExpr a0) {
        return new AST1(Min, a0);
    }

    public static IAST Min(final IExpr a0, final IExpr a1) {
        return new AST2(Min, a0, a1);
    }

    public static IAST Min(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3) {
        return quaternary(Min, a0, a1, a2, a3);
    }

	public static IAST Minimize(final IExpr a0, final IExpr a1) {
		return new AST2(Minimize, a0, a1);
	}
    public static IExpr minus(IExpr a, Integer i) {
		return Plus(F.ZZ(i.longValue() * (-1)), a);
    }

    public static IExpr minus(IExpr a, java.math.BigInteger i) {
		return Plus(ZZ(i.negate()), a);
    }

    public static IExpr minus(Integer i, IExpr b) {
		return Plus(ZZ(i.longValue()), new B2.Times(CN1, b));
    }

    public static IExpr minus(java.math.BigInteger i, IExpr b) {
		return Plus(ZZ(i), new B2.Times(CN1, b));
    }

    public static IAST Missing(final IExpr a0) {
        return new AST1(Missing, a0);
    }

	public static IAST Missing(final String str) {
		return new AST1(Missing, stringx(str));
	}
	public static IAST Missing(final IExpr a0, final IExpr a1) {
		return new AST2(Missing, a0, a1);
	}
    /**
     * <pre>
     * MissingQ(expr)
     * </pre>
     *
     * <blockquote>
     * <p>
     * returns <code>True</code> if <code>expr</code> is a <code>Missing()</code> expression.
     * </p>
     * </blockquote>
     * <h3>Examples</h3>
     *
     * <pre>
     * &gt;&gt; MissingQ(Missing("Test message"))
     * True
     * </pre>
     */
    public static IAST MissingQ(final IExpr a0) {
        return new AST1(MissingQ, a0);
    }

    public static IAST MoebiusMu(final IExpr a0) {
        return new AST1(MoebiusMu, a0);
    }

    public static IExpr mod(IExpr a, Integer i) {
		return Mod(a, ZZ(i.longValue()));
    }

    public static IExpr mod(IExpr a, java.math.BigInteger i) {
		return Mod(a, ZZ(i));
    }

    public static IExpr mod(Integer i, IExpr b) {
		return Mod(ZZ(i.longValue()), b);
    }

    public static IExpr mod(java.math.BigInteger i, IExpr b) {
		return Mod(ZZ(i), b);
    }

    public static IExpr Mod(final IExpr a0, final IExpr a1) {
        return new AST2(Mod, a0, a1);
    }

    public static IAST Module(final IExpr a0, final IExpr a1) {
        return new AST2(Module, a0, a1);
    }

    public static IAST Most(final IExpr a0) {
        return new AST1(Most, a0);
    }

    public static IExpr multiply(IExpr a, Integer i) {
		return new B2.Times(ZZ(i.longValue()), a);
    }

    public static IExpr multiply(IExpr a, java.math.BigInteger i) {
		return new B2.Times(ZZ(i), a);
    }

    public static IExpr multiply(Integer i, IExpr b) {
		return new B2.Times(ZZ(i.longValue()), b);
    }

    public static IExpr multiply(java.math.BigInteger i, IExpr b) {
		return Times(ZZ(i), b);
    }

    public static IAST Multinomial(final IExpr... a) {
        return function(Multinomial, a);
    }

	public static IAST MultiplicativeOrder(final IExpr a0, final IExpr a1) {
		return new AST2(MultiplicativeOrder, a0, a1);
	}
    /**
     * Evaluate the given expression in numeric mode
     *
     * @param a0
     * @return
     */
    public static IAST N(final IExpr a0) {
        return new AST1(N, a0);
    }

    public static IAST NakagamiDistribution(final IExpr a0, final IExpr a1) {
        return new AST2(NakagamiDistribution, a0, a1);
    }

    /**
     * Multiplies the given argument by <code>-1</code>. The <code>IExpr#negate()</code> method does evaluations, which
     * don't agree with pattern matching assumptions (in left-hand-sige expressions). so it is only called called for
     * <code>INumber</code> objects, otherwis a <code>Times(CN1, x)</code> AST would be created.
     *
	 * @param x
	 *            the expression which should be negated.
     * @return
     */
    public static IExpr Negate(final IExpr x) {
        if (x.isNumber()) {
            return x.negate();
        }
        if (x.isInfinity()) {
            return CNInfinity;
        }
        if (x.isNegativeInfinity()) {
            return CInfinity;
        }
		return new B2.Times(CN1, x);
    }

    public static IAST Negative(final IExpr a0) {
        return new AST1(Negative, a0);
    }

	public static IAST Nest(final IExpr a0, final IExpr a1, final int n) {
		return Nest(a0, a1, ZZ(n));
	}

	public static IAST Nest(final IExpr a0, final IExpr a1, final IExpr a2) {
		return new AST3(Nest, a0, a1, a2);
	}
    /**
     * Create a new abstract syntax tree (AST).
     *
	 * @param intialArgumentsCapacity
	 *            the initial capacity of arguments of the AST.
	 * @param head
	 *            the header expression of the function. If the ast represents a function like
	 *            <code>f[x,y], Sin[x],...</code>, the <code>head</code> will be an instance of type ISymbol.
     * @return
     */
    public static IAST newInstance(final int intialArgumentsCapacity, final IExpr head) {
        return AST.newInstance(intialArgumentsCapacity, head, false);
    }

    public static INilPointer nilPtr() {
        return NIL;
    }

    public static IAST NMaximize(final IExpr a0, final IExpr a1) {
        return new AST2(NMaximize, a0, a1);
    }

    public static IAST NMinimize(final IExpr a0, final IExpr a1) {
        return new AST2(NMinimize, a0, a1);
    }

    public static IAST Norm(final IExpr a) {
        return new AST1(Norm, a);
    }

    public static IAST NormalDistribution() {
        return new AST0(NormalDistribution);
    }

    public static IAST NormalDistribution(final IExpr a0, final IExpr a1) {
        return new AST2(NormalDistribution, a0, a1);
    }

    public static IAST Normalize(final IExpr a) {
        return new AST1(Normalize, a);
    }

    public static IAST Not(final IExpr a) {
		return new B1.Not(a);
    }

    public static IAST NotElement(final IExpr a0, final IExpr a1) {
        return new AST2(NotElement, a0, a1);
    }

    public static IAST NullSpace(final IExpr a0) {
        return new AST1(NullSpace, a0);
    }

    public static INum num(final Apfloat af) {
        return ApfloatNum.valueOf(af);
    }

    /**
     * Create a numeric value
     *
     * @param d
     * @return
     */
    public static INum num(final double d) {
        return Num.valueOf(d);
    }

    public static INum num(final IFraction value) {
        EvalEngine engine = EvalEngine.get();
		if (engine.isArbitraryMode()) {
			return ApfloatNum.valueOf(value.toBigNumerator(), value.toBigDenominator(), engine.getNumericPrecision());
        }
        double n = value.toBigNumerator().doubleValue();
        double d = value.toBigDenominator().doubleValue();
        // case: 1.02^181 return Infinity
        if (!DDouble.isFinite(n) || !DDouble.isFinite(d) || !DDouble.isFinite(n / d)) {
            return num(value.doubleValue());
        }
        // Android changed: avoid Android's framework bug
        if (F.isEqual(n, d)) {
            n = new BigDecimal(value.toBigNumerator()).doubleValue();
            d = new BigDecimal(value.toBigDenominator()).doubleValue();
        }
        return num(n / d);
    }

    public static INum num(final IInteger value) {
        EvalEngine engine = EvalEngine.get();
		if (engine.isArbitraryMode()) {
			return ApfloatNum.valueOf(value.toBigNumerator(), engine.getNumericPrecision());
        }
        return num(value.doubleValue());
    }

    /**
     * Create a numeric value from the input string.
     *
	 * @param valueString
	 *            the numeric value represented as a string.
     * @return
     */
    public static INum num(final String valueString) {
        EvalEngine engine = EvalEngine.get();
		if (engine.isArbitraryMode()) {
			return ApfloatNum.valueOf(valueString, engine.getNumericPrecision());
        }
        return Num.valueOf(Double.parseDouble(valueString));
    }

    /**
     * <pre>
     * NumberQ(expr)
     * </pre>
     *
     * <blockquote>
     * <p>
     * returns <code>True</code> if <code>expr</code> is an explicit number, and <code>False</code> otherwise.
     * </p>
     * </blockquote>
     * <h3>Examples</h3>
     *
     * <pre>
     * &gt;&gt; NumberQ(3+I)
     * True
     *
     * &gt;&gt; NumberQ(5!)
     * True
     *
     * &gt;&gt; NumberQ(Pi)
     * False
     * </pre>
     */
    public static IAST NumberQ(final IExpr a0) {

        return new AST1(NumberQ, a0);
    }

    public static IAST Numerator(final IExpr a0) {
        return new AST1(Numerator, a0);
    }

    /**
     * <pre>
     * NumericQ(expr)
     * </pre>
     *
     * <blockquote>
     * <p>
     * returns <code>True</code> if <code>expr</code> is an explicit numeric expression, and <code>False</code>
     * otherwise.
     * </p>
     * </blockquote>
     * <h3>Examples</h3>
     *
     * <pre>
     * &gt;&gt; NumericQ(E+Pi)
     * True
     *
     * &gt;&gt; NumericQ(Sqrt(3))
     * True
     * </pre>
     */
    public static IAST NumericQ(final IExpr a0) {
        return new AST1(NumericQ, a0);
    }

    public static IAST O(final IExpr a0) {
        return new AST1(O, a0);
    }

    /**
     * <pre>
     * OddQ(x)
     * </pre>
     *
     * <blockquote>
     * <p>
     * returns <code>True</code> if <code>x</code> is odd, and <code>False</code> otherwise.
     * </p>
     * </blockquote>
     * <h3>Examples</h3>
     *
     * <pre>
     * &gt;&gt; OddQ(-3)
     * True
     *
     * &gt;&gt; OddQ(0)
     * False
     * </pre>
     */
    public static IAST OddQ(final IExpr x) {
        return new AST1(OddQ, x);
    }

    public static IAST On(final IExpr a0, final IExpr a1) {
        return new AST2(On, a0, a1);
    }

    public static IAST On(final IExpr a0) {
        return new AST1(On, a0);
    }

    public static IInteger one() {
        return C1;
    }

    public static IAST Optional(final IExpr a0, final IExpr a1) {
        return new AST2(Optional, a0, a1);
    }

    public static IAST Optional(final IExpr a0) {
        return new AST1(Optional, a0);
    }

    public static IAST Options(final IExpr a0) {

        return new AST1(Options, a0);
    }


    public static IASTAppendable Or() {
        return ast(Or);
    }

    public static IAST Or(final IExpr a0, final IExpr a1) {
		return new B2.Or(a0, a1);
    }

	public static IAST Or(final IExpr a0, final IExpr a1, final IExpr a2) {
		return new AST3(F.Or, a0, a1, a2);
	}
    public static IAST Or(final IExpr... a) {
        return function(Or, a);
    }

    public static IAST Order(final IExpr a0, final IExpr a1) {
        return new AST2(Order, a0, a1);
    }

    public static IAST OrderedQ(final IExpr a) {
        return new AST1(OrderedQ, a);
    }

	public static IASTAppendable Part() {
        return ast(Part);
    }

	public static IAST Part(final IExpr a0, final IExpr a1) {
		return new B2.Part(a0, a1);
	}

	public static IAST Part(final IExpr a0, final IExpr a1, final IExpr a2) {
		return new AST3(Part, a0, a1, a2);
	}
    public static IASTAppendable Part(final IExpr... a) {
		return Part(0, a);
	}

	public static IASTAppendable Part(final int extraSize, final IExpr... a) {
		IASTAppendable part = F.ast(Part, a.length + extraSize + 1, false);
        for (int i = 0; i < a.length; i++) {
            part.append(a[i]);
        }
        return part;
    }

    public static IAST PartitionsP(final IExpr a0) {
        return new AST1(PartitionsP, a0);
    }

    public static IAST PartitionsQ(final IExpr a0) {
        return new AST1(PartitionsQ, a0);
    }

    public static IAST Pattern(final IExpr a0, final IExpr a1) {
        return new AST2(Pattern, a0, a1);
    }

    public static IAST PatternTest(final IExpr a0, final IExpr a1) {
        return new AST2(PatternTest, a0, a1);
    }

    public static IAST PDF(final IExpr a0) {
        return new AST1(PDF, a0);
    }

    public static IAST PDF(final IExpr a0, final IExpr a1) {
        return new AST2(PDF, a0, a1);
    }

    public static IAST Piecewise(final IExpr a0) {
        return new AST1(Piecewise, a0);
    }

	public static IAST PiecewiseExpand(final IExpr a0) {
		return new AST1(PiecewiseExpand, a0);
	}
    public static IAST Piecewise(final IExpr a0, final IExpr a1) {
        return new AST2(Piecewise, a0, a1);
    }

	public static IAST Plot(final IExpr a0, final IExpr a1) {
		return new AST2(Plot, a0, a1);
	}

	public static IAST Plot(final IExpr a0, final IExpr a1, final IExpr a2) {
		return new AST3(Plot, a0, a1, a2);
	}

	public static IAST Plot3D(final IExpr a0, final IExpr a1, final IExpr a2) {
		return new AST3(Plot3D, a0, a1, a2);
	}
    public static IExpr plus(IExpr a, Integer i) {
		return Plus(a, ZZ(i.longValue()));
    }

    public static IExpr plus(IExpr a, java.math.BigInteger i) {
		return Plus(a, ZZ(i));
    }

    public static IExpr plus(Integer i, IExpr b) {
		return Plus(ZZ(i.longValue()), b);
    }

    public static IExpr plus(java.math.BigInteger i, IExpr b) {
		return Plus(ZZ(i), b);
    }

    /**
     * Create a Plus() function.
     *
     * @return
     */
	public static IASTAppendable Plus() {
        return ast(Plus);
    }

    /**
     * Create a Plus() function with allocated space for size elements.
     *
     * @param size
     * @return
     */
    public static IASTAppendable PlusAlloc(int size) {
        return ast(Plus, size, false);
    }

    public static IASTAppendable Plus(final IExpr a0) {
        return unary(Plus, a0);
    }

    public static IAST Plus(final IExpr... a) {
        return function(Plus, a);
    }

    public static IAST Plus(final IExpr a1, final IExpr a2) {
        if (a1 != null && a2 != null) {
            return binaryASTOrderless(Predicates.isPlus, F.Plus, a1, a2);
        }
        return new B2.Plus(a1, a2);
    }

	public static IAST Plus(final IExpr a0, final IExpr a1, final IExpr a2) {
		return new AST3(Plus, a0, a1, a2);
	}
    public static IAST Plus(final long num, final IExpr... a) {
        IASTAppendable ast = ast(Plus, a.length + 1, false);
        ast.append(ZZ(num));
        ast.appendAll(a, 0, a.length);
        return ast;
    }

    public static IAST Pochhammer(final IExpr a0, final IExpr a1) {
        return new AST2(Pochhammer, a0, a1);
    }

	public static IAST Point(final IAST list) {
		return new B1.Point(list);
	}
    public static IAST PolyGamma(final IExpr a0) {
        return new AST1(PolyGamma, a0);
    }

    public static IAST PolyGamma(final IExpr a0, final IExpr a1) {
        return new AST2(PolyGamma, a0, a1);
    }

    public static IAST PolyLog(final IExpr a0, final IExpr a1) {
        return new AST2(PolyLog, a0, a1);
    }

    public static IAST PolynomialGCD(final IExpr a0, final IExpr a1) {
        return new AST2(PolynomialGCD, a0, a1);
    }

    public static IAST PolynomialQ(final IExpr a0, final IExpr a1) {
		return new B2.PolynomialQ(a0, a1);
    }

    public static IAST PolynomialQuotient(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(PolynomialQuotient, a0, a1, a2);
    }

    public static IAST PolynomialQuotientRemainder(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(PolynomialQuotientRemainder, a0, a1, a2);
    }

    public static IAST PolynomialRemainder(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(PolynomialRemainder, a0, a1, a2);
    }

    public static IAST Position(final IExpr a0, final IExpr a1) {
        return new AST2(Position, a0, a1);
    }

    public static IAST Positive(final IExpr a0) {
        return new AST1(Positive, a0);
    }

    public static IAST PossibleZeroQ(final IExpr a0) {
        return new AST1(PossibleZeroQ, a0);
    }

    public static IAST pow(final IExpr a0, final IExpr a1) {
		return new B2.Power(a0, a1);
    }

    public static IAST Power(final IExpr a0, final IExpr a1) {
		return new B2.Power(a0, a1);
    }

    public static IExpr Power(final IExpr a0, final long exp) {
		if (exp == 1L) {
			return a0;
		}
        if (a0.isNumber()) {
            if (exp > 0L) {
                return a0.power(exp);
            }
            if (exp == -1L) {
                if (a0.isZero()) {
                    EvalEngine.get().printMessage("Infinite expression 0^(-1)");
                    return F.CComplexInfinity;
                }
                return a0.inverse();
            }
            if (exp == 0L && !a0.isZero()) {
                return C1;
            }
        }
		return new B2.Power(a0, ZZ(exp));
    }

    public static IAST PowerExpand(final IExpr a0) {

        return new AST1(PowerExpand, a0);
    }

	public static IAST PowerMod(final IExpr a0, final IExpr a1, final IExpr a2) {
		return new AST3(PowerMod, a0, a1, a2);
	}
    /**
     * Create a "predefined" symbol for constants or function names.
     *
     * @param symbolName
     * @return
     */
    public static ISymbol predefinedSymbol(final String symbolName) {
        ISymbol temp = org.matheclipse.core.expression.Context.SYSTEM.get(symbolName);
        if (temp != null) {
            return temp;
        }
        String lcSymbolName = symbolName;
		if (FEConfig.PARSER_USE_LOWERCASE_SYMBOLS) {
            if (symbolName.length() > 1) {
                // use the lower case string here to use it as associated class
                // name
                // in package org.matheclipse.core.reflection.system
                lcSymbolName = symbolName.toLowerCase(Locale.ENGLISH);
            }
        }
        temp = new Symbol(lcSymbolName, org.matheclipse.core.expression.Context.SYSTEM);
        org.matheclipse.core.expression.Context.SYSTEM.put(lcSymbolName, temp);
        return temp;
    }

    public static IAST Prepend(final IExpr a0, final IExpr a1) {

        return new AST2(Prepend, a0, a1);
    }

    public static IAST PrimeOmega(final IExpr a0) {
        return new AST1(PrimeOmega, a0);
    }

	/**
	 * See <a href=
	 * "https://github.com/axkr/symja_android_library/blob/master/symja_android_library/doc/functions/PrimePi.md">PrimePi</a>
	 */
	public static IAST PrimePi(final IExpr a0) {
		return new AST1(PrimePi, a0);
	}

	/**
	 * See <a href=
	 * "https://github.com/axkr/symja_android_library/blob/master/symja_android_library/doc/functions/PrimeQ.md">PrimeQ</a>
	 */
    public static IAST PrimeQ(final IExpr a0) {

        return new AST1(PrimeQ, a0);
    }

    public static IAST Print(final IExpr... a) {
        return function(Print, a);
    }

    public static IAST Product(final IExpr a0, final IExpr a1) {
        return new AST2(Product, a0, a1);
    }

    /**
     * Iterate over an integer range <code>from <= i <= to</code> and create a product of the created values.
     *
	 * @param function
	 *            the function which should be applied on each iterator value
     * @param from
     * @param to
     * @return
     */
    public static IAST product(final Function<IExpr, IExpr> function, final int from, final int to) {
        return intIterator(F.Times, function, from, to, 1);
    }

    public static IAST ProductLog(final IExpr a0) {
        return new AST1(ProductLog, a0);
    }

    public static IAST ProductLog(final IExpr a0, final IExpr a1) {
        return new AST2(ProductLog, a0, a1);
    }

    public static IAST PseudoInverse(final IExpr a0) {
        return new AST1(PseudoInverse, a0);
    }

    /**
     * Create a "fractional" number
     *
	 * @param frac
	 *            a big fractional number
     * @return IFraction
     */
    public static IFraction QQ(final BigFraction frac) {
        return AbstractFractionSym.valueOf(frac);
    }

    /**
     * Create a "fractional" number
     *
	 * @param numerator
	 *            numerator of the fractional number
	 * @param denominator
	 *            denominator of the fractional number
     * @return IFraction
     */
    public static IFraction QQ(final IInteger numerator, final IInteger denominator) {
        return AbstractFractionSym.valueOf(numerator, denominator);
    }

    /**
     * Create a "fractional" number
     *
	 * @param numerator
	 *            numerator of the fractional number
	 * @param denominator
	 *            denominator of the fractional number
     * @return IFraction
     */
    public static IFraction QQ(final long numerator, final long denominator) {
        return AbstractFractionSym.valueOf(numerator, denominator);
    }

    public static IAST QRDecomposition(final IExpr a0) {
        return new AST1(QRDecomposition, a0);
    }

    public final static IASTAppendable quaternary(final IExpr head, final IExpr a0, final IExpr a1, final IExpr a2,
                                                  final IExpr a3) {
        return new AST(new IExpr[]{head, a0, a1, a2, a3});
    }

    public static IAST Quantile(final IExpr a0) {
        return new AST1(Quantile, a0);
    }

    public static IAST Quantile(final IExpr a0, final IExpr a1) {
        return new AST2(Quantile, a0, a1);
    }

    public static IAST Quantile(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(Quantile, a0, a1, a2);
    }

    public static IAST Quantity(final IExpr a0, final IExpr a1) {
        return new AST2(Quantity, a0, a1);
    }

    public static IAST QuantityMagnitude(final IExpr a0) {
        return new AST1(QuantityMagnitude, a0);
    }

    public static IAST QuantityMagnitude(final IExpr a0, final IExpr a1) {
        return new AST2(QuantityMagnitude, a0, a1);
    }

    public static IAST Quiet(final IExpr a0) {
        return new AST1(Quiet, a0);
    }

    public final static IASTMutable quinary(final IExpr head, final IExpr a0, final IExpr a1, final IExpr a2,
                                            final IExpr a3, final IExpr a4) {
        return new AST(new IExpr[]{head, a0, a1, a2, a3, a4});
    }

    public static IAST Quotient(final IExpr a0, final IExpr a1) {
        return new AST2(Quotient, a0, a1);
    }

	public static IAST Quotient(final IExpr a0, final IExpr a1, final IExpr a2) {
		return new AST3(Quotient, a0, a1, a2);
	}
	public static IAST RandomComplex(final IExpr a0) {
		return new AST1(RandomComplex, a0);
	}

	public static IAST RandomInteger(final IExpr a0) {
		return new AST1(RandomInteger, a0);
	}

	public static IAST RandomReal(final IExpr a0) {
		return new AST1(RandomReal, a0);
	}

    public static IAST RandomVariate(final IExpr a0) {
        return new AST1(RandomVariate, a0);
    }

    public static IAST RandomVariate(final IExpr a0, final IExpr a1) {
        return new AST2(RandomVariate, a0, a1);
    }

    public static IAST Range(final IExpr a0) {
        return new AST1(Range, a0);
    }

    public static IAST Range(final IExpr a0, final IExpr a1) {
        return new AST2(Range, a0, a1);
    }

	public static IAST Range(final IExpr a0, final IExpr a1, final IExpr a2) {
		return new AST3(Range, a0, a1, a2);
	}

    public static IAST Rational(final IExpr a0, final IExpr a1) {
        return new AST2(Rational, a0, a1);
    }

	public static IAST Rationalize(final IExpr a0) {
		return new AST1(Rationalize, a0);
	}
    public static IExpr Re(final IExpr a0) {
        if (a0 != null && a0.isNumber()) {
            return ((INumber) a0).re();
        }
        return new AST1(Re, a0);
    }

    public static IAST RealNumberQ(final IExpr a) {
        return new AST1(RealNumberQ, a);
    }

    public static IAST Reap(final IExpr a) {
        return new AST1(Reap, a);
    }

    public static IAST Refine(final IExpr a) {
        return new AST1(Refine, a);
    }

    public static IAST Refine(final IExpr a0, final IExpr a1) {
        return new AST2(Refine, a0, a1);
    }

    public static IAST Replace(final IExpr a0, final IExpr a1) {
        return new AST2(Replace, a0, a1);
    }

    public static IAST ReplaceAll(final IExpr a0, final IExpr a1) {
        return new AST2(ReplaceAll, a0, a1);
    }

    public static IAST ReplaceList(final IExpr a0, final IExpr a1) {
        return new AST2(ReplaceList, a0, a1);
    }

    public static IAST ReplacePart(final IExpr a0, final IExpr a1) {
        return new AST2(ReplacePart, a0, a1);
    }

    public static IAST ReplacePart(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(ReplacePart, a0, a1, a2);
    }

    public static IAST Rest(final IExpr a0) {
        return new AST1(Rest, a0);
    }

    public static IAST Resultant(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(Resultant, a0, a1, a2);
    }

	public static IAST RGBColor(final IExpr a0, final IExpr a1, final IExpr a2) {
		return new AST3(RGBColor, a0, a1, a2);
	}
    /**
     * Get or create a user defined symbol which is retrieved from the evaluation engines context path.
     *
	 * @param symbolName
	 *            the name of the symbol
     * @return the symbol object from the context path
     */
    public static ISymbol symbol(final String symbolName) {
        return symbol(symbolName, null, EvalEngine.get());
    }

    /**
     * Get or create a user defined symbol which is retrieved from the evaluation engines context path.
     *
	 * @param symbolName
	 *            the name of the symbol
	 * @param engine
	 *            the evaluation engine
     * @return the symbol object from the context path
     */
    public static ISymbol symbol(final String symbolName, EvalEngine engine) {
        return symbol(symbolName, null, engine);
    }

    /**
     * Get or create a user defined symbol which is retrieved from the evaluation engines context path. Additional set
     * assumptions to the engines global assumptions. Use <code>#1</code> or {@link F#Slot1} in the
     * <code>assumptionAST</code> expression for this symbol.
     *
	 * @param symbolName
	 *            the name of the symbol
	 * @param assumptionAST
	 *            the assumptions which should be set for the symbol. Use <code>#1</code> or {@link F#Slot1} in the
	 *            <code>assumptionAST</code> expression for this symbol.
     * @return the symbol object from the context path
     */
    public static ISymbol symbol(final String symbolName, IAST assumptionAST) {
        return symbol(symbolName, assumptionAST, EvalEngine.get());
    }

    /**
     * Get or create a user defined symbol which is retrieved from the evaluation engines context path. Additional set
     * assumptions to the engines global assumptions. Use <code>#1</code> or {@link F#Slot1} in the
     * <code>assumptionAST</code> expression for this symbol.
     *
	 * @param symbolName
	 *            the name of the symbol
	 * @param assumptionAST
	 *            the assumptions which should be set for the symbol. Use <code>#1</code> or {@link F#Slot1} in the
	 *            <code>assumptionAST</code> expression for this symbol.
	 * @param engine
	 *            the evaluation engine
     * @return the symbol object from the context path
     */
    public static ISymbol symbol(final String symbolName, IAST assumptionAST, EvalEngine engine) {
        ISymbol symbol = engine.getContextPath().symbol(symbolName, engine.getContext(), engine.isRelaxedSyntax());
        if (assumptionAST != null) {
			IExpr temp = Lambda.replaceSlots(assumptionAST, F.List(symbol)).orElse(assumptionAST);
            if (temp.isAST()) {
                IAssumptions assumptions = engine.getAssumptions();
                if (assumptions == null) {
                    assumptions = org.matheclipse.core.eval.util.Assumptions.getInstance(temp);
                    engine.setAssumptions(assumptions);
                } else {
                    assumptions.addAssumption((IAST) temp);
                }
            }
        }
        return symbol;
    }

    public static ISymbol symbol(final String symbolName, final String contextStr, IAST assumptionAST,
                                 EvalEngine engine) {
        if (contextStr.length() == 0) {
            return symbol(symbolName, assumptionAST, engine);
        }
        ISymbol symbol;
        ContextPath contextPath = engine.getContextPath();
        Context context = contextPath.getContext(contextStr);
        // if (context == null) {
        // contextPath.add(new Context(contextStr));
        // }
        symbol = contextPath.getSymbol(symbolName, context, engine.isRelaxedSyntax());
        if (assumptionAST != null) {
			IExpr temp = Lambda.replaceSlots(assumptionAST, F.List(symbol)).orElse(assumptionAST);
            if (temp.isAST()) {
                IAssumptions assumptions = engine.getAssumptions();
                if (assumptions == null) {
                    assumptions = org.matheclipse.core.eval.util.Assumptions.getInstance(temp);
                    engine.setAssumptions(assumptions);
                } else {
                    assumptions.addAssumption((IAST) temp);
                }
            }
        }
        return symbol;
    }

    /**
     * Print the documentation for the given symbol.
     *
     * @param head
     * @return
     */
    public final static IStringX usage(final ISymbol head) {
        return usage(head.toString());
    }

    /**
     * Print the documentation for the given symbol name.
     *
     * @param symbolName
     * @return
     */
    public final static IStringX usage(final String symbolName) {
        StringBuilder buf = new StringBuilder();
        Documentation.usageDocumentation(buf, symbolName);
        return F.stringx(buf.toString());
    }

    /**
	 * Create a unique dummy symbol which is retrieved from the evaluation engines DUMMY context.
     *
	 * @param symbolName
	 *            the name of the symbol
     * @return the symbol object from the context path
     */
    public static ISymbol Dummy(final String symbolName) {
        String name = symbolName;
		if (FEConfig.PARSER_USE_LOWERCASE_SYMBOLS) {
            if (symbolName.length() == 1) {
                name = symbolName;
            } else {
                name = symbolName.toLowerCase(Locale.ENGLISH);
            }
        }
        return new Symbol(name, org.matheclipse.core.expression.Context.DUMMY);
    }

	/**
	 * Create a unique dummy symbol with prefix "$", which is retrieved from the evaluation engines DUMMY context.
	 *
	 * @param engine
	 *            the evaluation engine
	 * @return the symbol object from the context path
	 */
	public static ISymbol Dummy(EvalEngine engine) {
		return Dummy(engine.uniqueName("$"));
	}

	public static IBuiltInSymbol localBiFunction(final String symbolName, final BiFunction<IExpr, IExpr, IExpr> function) {
        IBuiltInSymbol localBuittIn = new BuiltInSymbol(symbolName, java.lang.Integer.MAX_VALUE);
        localBuittIn.setEvaluator(new AbstractCoreFunctionEvaluator() {
            @Override
            public IExpr evaluate(IAST ast, EvalEngine engine) {
                return function.apply(ast.arg1(), ast.arg2());
            }
        });
        return localBuittIn;
    }

    public static IBuiltInSymbol localFunction(final String symbolName, final Function<IExpr, IExpr> function) {
        return localFunction(symbolName, new AbstractCoreFunctionEvaluator() {
            @Override
            public IExpr evaluate(IAST ast, EvalEngine engine) {
                return function.apply(ast.arg1());
            }
        });
    }

    public static IBuiltInSymbol localFunction(final String symbolName, IEvaluator evaluator) {
        IBuiltInSymbol localBuittIn = new BuiltInDummy(symbolName);
        localBuittIn.setEvaluator(evaluator);
        return localBuittIn;
    }

    public static IBuiltInSymbol localBiPredicate(final String symbolName, final BiPredicate<IExpr, IExpr> function) {
        return localFunction(symbolName, new AbstractCoreFunctionEvaluator() {
            @Override
            public IExpr evaluate(IAST ast, EvalEngine engine) {
                return F.bool(function.test(ast.arg1(), ast.arg2()));
            }
        });
    }

    public static IBuiltInSymbol localPredicate(final String symbolName, final Predicate<IExpr> function) {
        return localFunction(symbolName, new AbstractCoreFunctionEvaluator() {
            @Override
            public IExpr evaluate(IAST ast, EvalEngine engine) {
                return F.bool(function.test(ast.arg1()));
            }
        });
    }

    /**
     * Remove a user-defined symbol from the eval engines context path. Doesn't remove predefined names from the System
     * Context.
     *
	 * @param symbolName
	 *            the name of the symbol
     * @return the removed symbol or <code>null</code> if no symbol was found
     */
    public static ISymbol removeUserSymbol(final String symbolName) {
        ContextPath contextPath = EvalEngine.get().getContextPath();
        return contextPath.removeSymbol(symbolName);
    }

    public static IAST Return(final IExpr a) {
		if (a.isFalse()) {
			return CReturnFalse;
		}
		if (a.isTrue()) {
			return CReturnTrue;
		}
        return new AST1(Return, a);
    }

    public static IAST Reverse(final IExpr a) {
        return new AST1(Reverse, a);
    }

	public static IAST RomanNumeral(final IExpr a) {
		return new AST1(RomanNumeral, a);
	}

    public static IAST Root(final IExpr a0, final IExpr a1) {
        return new AST2(Root, a0, a1);
    }

    public static IAST Roots(final IExpr a0) {
        return new AST1(Roots, a0);
    }

    public static IAST Roots(final IExpr a0, final IExpr a1) {
        return new AST2(Roots, a0, a1);
    }

    public static IAST Round(final IExpr a0) {
        return new AST1(Round, a0);
    }

    public static IAST RowReduce(final IExpr a0) {
        return new AST1(RowReduce, a0);
    }

	public static IAST Rule(final String str, final IExpr a1) {
		return new B2.Rule(F.$str(str), a1);
	}

	public static IAST Rule(final String str0, final String str1) {
		return new B2.Rule(F.$str(str0), F.$str(str1));
	}

    public static IAST Rule(final IExpr a0, final IExpr a1) {
		return new B2.Rule(a0, a1);
    }

    public static IAST RuleDelayed(final IExpr a0, final IExpr a1) {
		return new B2.RuleDelayed(a0, a1);
    }

    public static IAST SameQ(final IExpr a0, final IExpr a1) {
		return new B2.SameQ(a0, a1);
    }

	public static IAST SatisfiabilityInstances(final IExpr a0, final IExpr a1, final IExpr a2) {
		return new AST3(SatisfiabilityInstances, a0, a1, a2);
	}

    public static IAST SameQ(final IExpr a0, final double d) {
        return new AST2(SameQ, a0, F.num(d));
    }

    public static IAST Scan(final IExpr a0, final IExpr a1) {
        return new AST2(Scan, a0, a1);
    }

    public static IAST Sec(final IExpr a0) {
        return new AST1(Sec, a0);
    }

    public static IAST Sech(final IExpr a0) {
        return new AST1(Sech, a0);
    }

    public static IAST Select(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(Select, a0, a1, a2);
    }

	public static IAST Select(final IExpr a0, final IExpr a1 ) {
		return new AST2(Select, a0, a1);
	}

    public final static IAST senary(final IExpr head, final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3,
                                    final IExpr a4, final IExpr a5) {
        return new AST(new IExpr[]{head, a0, a1, a2, a3, a4, a5});
    }

    public static IASTAppendable Sequence() {
        return ast(Sequence);
    }

    public static IAST Sequence(final IExpr a0) {
        return unary(Sequence, a0);
    }

    public static IAST Sequence(final IExpr... a) {
        return function(Sequence, a);
    }

    public static IAST Series(final IExpr... a) {
        return function(Series, a);
    }

    public static IAST SeriesCoefficient(final IExpr a0, final IExpr a1) {
        return new AST2(SeriesCoefficient, a0, a1);
    }

    public static IAST SeriesData(final IExpr... a) {
        return function(SeriesData, a);
    }

    public static IAST Set(final IExpr a0, final IExpr a1) {
		return new B2.B2Set(a0, a1);
    }

    public static IAST SetAttributes(final IExpr a0) {
        return new AST1(SetAttributes, a0);
    }

    public static IAST SetAttributes(final IExpr a0, final IExpr a1) {
        return new AST2(SetAttributes, a0, a1);
    }

    public static IAST SetDelayed(final IExpr a0, final IExpr a1) {
        return new AST2(SetDelayed, a0, a1);
    }

    public static IAST Show(final IExpr a0) {
        return new AST1(Show, a0);
    }

    public static IAST Sign(final IExpr a) {
        return new AST1(Sign, a);
    }

    public static IAST SignCmp(final IExpr a0) {
        return new AST1(SignCmp, a0);
    }

    public static IAST Simplify(final IExpr a0) {
        return new AST1(F.Simplify, a0);
    }

    public static IAST Sin(final IExpr a0) {
		return new B1.Sin(a0);
    }

    public static IAST Sinc(final IExpr a0) {
        return new AST1(Sinc, a0);
    }

    public static IAST Sinh(final IExpr a0) {

        return new AST1(Sinh, a0);
    }

    public static IAST SinhIntegral(final IExpr a) {
        return new AST1(SinhIntegral, a);
    }

    public static IAST SinIntegral(final IExpr a) {
        return new AST1(SinIntegral, a);
    }

	public static IAST Skewness(final IExpr a0) {
		return new AST1(Skewness, a0);
	}
    public static IAST Slot(final IExpr a0) {
        return new AST1(Slot, a0);
    }

    public static IAST Slot(final int i) {
		return new AST1(Slot, ZZ(i));
    }

    public static IAST SlotSequence(final int i) {
		return new AST1(SlotSequence, ZZ(i));
    }

    public static IAST Solve(final IExpr a0, final IExpr a1) {
        return new AST2(Solve, a0, a1);
    }

    public static IAST Sort(final IExpr a0, final IExpr a1) {
        return new AST2(Sort, a0, a1);
    }

    public static IAST Sow(final IExpr a) {
        return new AST1(Sow, a);
    }

    public static IAST Span(final IExpr... a) {
        return function(Span, a);
    }

    /**
     * Create a "square" expression: <code>Power(x, 2)</code>.
     *
     * @param x
     * @return
     */
    public static IAST Sqr(final IExpr x) {
		return new B2.Power(x, C2);
    }

    /**
     * Create a "square root" expression: <code>Power(x, 1/2)</code>.
     *
     * @param x
     * @return
     */
    public static IAST Sqrt(final IExpr x) {
		return new B2.Power(x, C1D2);
    }

    public static IAST Sqrt(int n) {
		return new B2.Power(F.ZZ(n), C1D2);
    }

    public static IAST StandardDeviation(final IExpr a0) {
        return new AST1(StandardDeviation, a0);
    }

    public static IAST Standardize(final IExpr a0) {
        return new AST1(Standardize, a0);
    }

    public static IAST StieltjesGamma(final IExpr a0) {
        return new AST1(StieltjesGamma, a0);
    }

    public static IAST StieltjesGamma(final IExpr a0, final IExpr a1) {
        return new AST2(StieltjesGamma, a0, a1);
    }

    public static IAST StirlingS1(final IExpr a0, final IExpr a1) {
        return new AST2(StirlingS1, a0, a1);
    }

    public static IAST StirlingS2(final IExpr a0, final IExpr a1) {
        return new AST2(StirlingS2, a0, a1);
    }

    public static IAST StringJoin(final IExpr a) {
        return new AST1(StringJoin, a);
    }

    public static IAST Surd(final IExpr a0, final IExpr a1) {
        return new AST2(Surd, a0, a1);
    }

	/**
	 * Create a Symja string expression with mime type TEXT_PLAIN.
	 *
	 * @param c
	 * @return
	 * @see IStringX#TEXT_PLAIN
	 */
	final static public IStringX stringx(final char c) {
		return StringX.valueOf(c);
	}
    /**
	 * Create a Symja string expression with mime type TEXT_PLAIN.
     *
     * @param str
     * @return
	 * @see IStringX#TEXT_PLAIN
     */
    final static public IStringX stringx(final String str) {
        return StringX.valueOf(str);
    }

	/**
	 * reate a Symja string expression.
	 *
	 * @param str
	 * @param mimeType
	 *            the mime type of the string
	 * @return
	 * @see IStringX#TEXT_PLAIN
	 * @see IStringX#TEXT_LATEX
	 * @see IStringX#TEXT_MATHML
	 * @see IStringX#TEXT_HTML
	 */
	final static public IStringX stringx(final String str, final short mimeType) {
		return StringX.valueOf(str, mimeType);
	}
    /**
     * Create a string expression
     *
     * @param str
     * @return
     */
    final static public IStringX stringx(final StringBuilder str) {
        return StringX.valueOf(str);
    }

    public static IAST StruveH(final IExpr a0, final IExpr a1) {
        return new AST2(StruveH, a0, a1);
    }

    public static IAST StruveL(final IExpr a0, final IExpr a1) {
        return new AST2(StruveL, a0, a1);
    }

    public static IAST StudentTDistribution(final IExpr a0) {
        return new AST1(StudentTDistribution, a0);
    }

    public static IAST StudentTDistribution(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(StudentTDistribution, a0, a1, a2);
    }

    public static IAST Subdivide(final IExpr a0) {
        return new AST1(Subdivide, a0);
    }

    public static IAST Subdivide(final IExpr a0, final IExpr a1) {
        return new AST2(Subdivide, a0, a1);
    }

    public static IAST Subdivide(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(Subdivide, a0, a1, a2);
    }

    public static IAST Subfactorial(final IExpr a0) {
        return new AST1(Subfactorial, a0);
    }

	public static IAST Subscript(final IExpr a0, final IExpr a1) {
		return new AST2(Subscript, a0, a1);
	}
    /**
     * Substitute all (sub-) expressions <code>x</code> with <code>y</code>. If no substitution matches, the method
     * returns the given <code>expr</code>.
     *
	 * @param expr
	 *            the complete expresssion
	 * @param x
	 *            the subexpression which should be replaced
	 * @param y
	 *            the expression which replaces <code>x</code>
     * @return the input <code>expr</code> if no substitution of a (sub-)expression was possible or the substituted
	 *         expression.
     */
    public static IExpr subs(final IExpr expr, final IExpr x, final IExpr y) {
        return expr.replaceAll(F.Rule(x, y)).orElse(expr);
    }

    /**
     * Substitute all (sub-) expressions with the given unary function. If no substitution matches, the method returns
     * the given <code>expr</code>.
     *
     * @param expr
	 * @param function
	 *            if the unary functions <code>apply()</code> method returns <code>F.NIL</code> the expression isn't
	 *            substituted.
     * @return the input <code>expr</code> if no substitution of a (sub-)expression was possible or the substituted
	 *         expression.
     */
    public static IExpr subst(IExpr expr, final Function<IExpr, IExpr> function) {
        return expr.replaceAll(function).orElse(expr);
    }

    /**
     * Substitute all (sub-) expressions with the given map. If no substitution matches, the method returns the given
     * <code>expr</code>.
     *
     * @param expr
	 * @param map
	 *            if the maps <code>get()</code> method returns <code>null</code> the expression isn't substituted.
     * @return the input <code>expr</code> if no substitution of a (sub-)expression was possible or the substituted
	 *         expression.
     */
    public static IExpr subst(IExpr expr, final Map<? extends IExpr, ? extends IExpr> map) {
        return expr.replaceAll(map).orElse(expr);
    }

    /**
     * Substitute all (sub-) expressions with the given rule set. If no substitution matches, the method returns the
     * given <code>expr</code>.
     *
     * @param expr
	 * @param astRules
	 *            rules of the form <code>x-&gt;y</code> or <code>{a-&gt;b, c-&gt;d}</code>; the left-hand-side of the
	 *            rule can contain pattern objects.
     * @return the input <code>expr</code> if no substitution of a (sub-)expression was possible or the substituted
	 *         expression.
     */
    public static IExpr subst(IExpr expr, final IAST astRules) {
        if (astRules.isListOfLists()) {
            IExpr result = expr;
            for (IExpr subList : astRules) {
                result = F.subst(result, (IAST) subList);
            }
            return result;
        }
        return expr.replaceAll(astRules).orElse(expr);
    }

    /**
     * Substitute all (sub-) expressions with the given replacement expression. If no (sub-) expression matches, the
     * method returns the given <code>expr</code>.
     *
     * @param expr
     * @param subExpr
     * @param replacementExpr
     * @return the input <code>expr</code> if no substitution of a (sub-)expression was possible or the substituted
	 *         expression.
     */
    public static IExpr subst(IExpr expr, IExpr subExpr, IExpr replacementExpr) {
        return expr.replaceAll(Functors.rules(Rule(subExpr, replacementExpr), EvalEngine.get())).orElse(expr);
    }

    /**
     * Return <code>arg1 + (-1)*arg2</code>
     *
     * @param arg1
     * @param arg2
     * @return
     */
    public static IAST Subtract(final IExpr arg1, final IExpr arg2) {
		return new B2.Plus(arg1, new B2.Times(CN1, arg2));
    }

    public static IAST Sum(final IExpr a0, final IExpr a1) {
        return new AST2(Sum, a0, a1);
    }

    public static IAST Sum(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(Sum, a0, a1, a2);
    }

	public static IAST Sum(final IExpr a0, final IExpr a1, final IExpr a2, final IExpr a3) {
		return quaternary(F.Sum, a0, a1, a2, a3);
	}

    /**
     * Evaluate the sum from <code>iMin</code> to <code>iMax</code> and step <code>1</code>.
     *
     * @param function
     * @param iMin
     * @param iMax
     * @return
     */
    public static IAST sum(final Function<IExpr, IExpr> function, final int iMin, final int iMax) {
        return intIterator(F.Plus, function, iMin, iMax, 1);
    }

	public static IAST intSum(final IntFunction<IExpr> function, final int iMin, final int iMax) {
		return intIterator(F.Plus, function, iMin, iMax, 1);
	}

    /**
     * Evaluate the sum from <code>iMin</code> to <code>iMax</code> and step <code>iStep</code>.
     *
     * @param function
     * @param iMin
     * @param iMax
     * @param iStep
     * @return
     */
    public static IAST sum(final Function<IExpr, IExpr> function, final int iMin, final int iMax, final int iStep) {
        return intIterator(F.Plus, function, iMin, iMax, iStep);
    }

	public static IAST Superscript(final IExpr a0, final IExpr a1) {
		return new AST2(Superscript, a0, a1);
	}
    public static IASTAppendable SurfaceGraphics() {

        return ast(SurfaceGraphics);
    }

    public static IAST Switch(final IExpr... a) {
        return function(Switch, a);
    }

	/**
	 * See <a href=
	 * "https://github.com/axkr/symja_android_library/blob/master/symja_android_library/doc/functions/Table.md">Table</a>
	 */
    public static IAST Table(final IExpr a0, final IExpr a1) {
        return new AST2(Table, a0, a1);
    }

    public static IASTMutable TagSet(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(TagSet, a0, a1, a2);
    }

    public static IASTMutable TagSetDelayed(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(TagSetDelayed, a0, a1, a2);
    }

	/**
	 * See <a href=
	 * "https://github.com/axkr/symja_android_library/blob/master/symja_android_library/doc/functions/Take.md">Take</a>
	 */
    public static IAST Take(final IExpr a0, final IExpr a1) {
        return new AST2(Take, a0, a1);
    }

	/**
	 * See <a href=
	 * "https://github.com/axkr/symja_android_library/blob/master/symja_android_library/doc/functions/Tan.md">Tan</a>
	 */
    public static IAST Tan(final IExpr a0) {
		return new B1.Tan(a0);
    }

	/**
	 * See <a href=
	 * "https://github.com/axkr/symja_android_library/blob/master/symja_android_library/doc/functions/Tanh.md">Tanh</a>
	 */
    public static IAST Tanh(final IExpr a0) {
        return new AST1(Tanh, a0);
    }

    public static IAST Taylor(final IExpr a0, final IExpr a1) {
        return new AST2(Taylor, a0, a1);
    }

    public static IAST TensorSymmetry(final IExpr a0) {
        return new AST1(TensorSymmetry, a0);
    }

    public static IAST TensorSymmetry(final IExpr a0, final IExpr a1) {
        return new AST2(TensorSymmetry, a0, a1);
    }

	/**
	 * See <a href=
	 * "https://github.com/axkr/symja_android_library/blob/master/symja_android_library/doc/functions/TeXForm.md">TeXForm</a>
	 */
    public static IAST TeXForm(final IExpr a0) {
        return new AST1(TeXForm, a0);
    }

    public final static IASTMutable ternary(final IExpr head, final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST(new IExpr[]{head, a0, a1, a2});
    }

    /**
	 * Create a function <code>head(arg1, arg2, arg3)</code> with 3 argument as an <code>AST3</code> mutable object
	 * without evaluation.
     *
     * @param head
	 * @param arg1
	 * @param arg2
	 * @param arg3
     * @return
     */
	public final static IASTMutable ternaryAST3(final IExpr head, final IExpr arg1, final IExpr arg2,
			final IExpr arg3) {
		return new AST3(head, arg1, arg2, arg3);
    }

	/**
	 * See <a href=
	 * "https://github.com/axkr/symja_android_library/blob/master/symja_android_library/doc/functions/Thread.md">Thread</a>
	 */
    public static IAST Thread(final IExpr a0) {
        return new AST1(Thread, a0);
    }

	/**
	 * See <a href=
	 * "https://github.com/axkr/symja_android_library/blob/master/symja_android_library/doc/functions/Throw.md">Throw</a>
	 */
    public static IAST Throw(final IExpr a) {
		if (a.isFalse()) {
			return CThrowFalse;
		}
		if (a.isTrue()) {
			return CThrowTrue;
		}
        return new AST1(Throw, a);
    }

	/**
	 * See <a href=
	 * "https://github.com/axkr/symja_android_library/blob/master/symja_android_library/doc/functions/TimeConstrained.md">TimeConstrained</a>
	 */
    public static IAST TimeConstrained(final IExpr a0, final IExpr a1) {
        return new AST2(TimeConstrained, a0, a1);
    }

	/**
	 * See <a href=
	 * "https://github.com/axkr/symja_android_library/blob/master/symja_android_library/doc/functions/TimeConstrained.md">TimeConstrained</a>
	 */
    public static IAST TimeConstrained(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(TimeConstrained, a0, a1, a2);
    }

    /**
	 * Create a Times() function. See <a href=
	 * "https://github.com/axkr/symja_android_library/blob/master/symja_android_library/doc/functions/Times.md">Times</a>.
     *
     * @return
     */
    public static IASTAppendable Times() {
        return ast(Times);
    }

    /**
	 * Create a Times() function with allocated space for size elements. See <a href=
	 * "https://github.com/axkr/symja_android_library/blob/master/symja_android_library/doc/functions/Times.md">Times</a>.
     *
     * @param size
     * @return
     */
    public static IASTAppendable TimesAlloc(int size) {
        return ast(Times, size, false);
    }

	/**
	 * See <a href=
	 * "https://github.com/axkr/symja_android_library/blob/master/symja_android_library/doc/functions/Times.md">Times</a>
	 */
    public static IASTAppendable Times(final IExpr a0) {
        return unary(Times, a0);
    }

	/**
	 * See <a href=
	 * "https://github.com/axkr/symja_android_library/blob/master/symja_android_library/doc/functions/Times.md">Times</a>
	 */
    public static IAST Times(final IExpr... a) {
        return function(Times, a);
    }

	/**
	 * See <a href=
	 * "https://github.com/axkr/symja_android_library/blob/master/symja_android_library/doc/functions/Times.md">Times</a>
	 */
    public static IASTMutable Times(final IExpr a1, final IExpr a2) {
        if (a1 != null && a2 != null) {
            return binaryASTOrderless(Predicates.isTimes, F.Times, a1, a2);
        }
        return new B2.Times(a1, a2);
    }

	/**
	 * See <a href=
	 * "https://github.com/axkr/symja_android_library/blob/master/symja_android_library/doc/functions/Times.md">Times</a>
	 */
	public static IASTMutable Times(final IExpr a0, final IExpr a1, final IExpr a2) {
		return new AST3(Times, a0, a1, a2);
	}
    private static IASTMutable binaryASTOrderless(Predicate<IExpr> t, ISymbol symbol, final IExpr a1, final IExpr a2) {
        final boolean test1 = t.test(a1);
        final boolean test2 = t.test(a2);
        if (test1 || test2) {
            int size = test1 ? a1.size() : 1;
			size += test2 ? a2.size() : 1;
            IASTAppendable result = ast(symbol, size, false);
            if (test1) {
                result.appendArgs((IAST) a1);
            } else {
                result.append(a1);
            }
            if (test2) {
                result.appendArgs((IAST) a2);
            } else {
                result.append(a2);
            }
            EvalAttributes.sort(result);
            return result;
        }
        if (a1.compareTo(a2) > 0) {
            // swap arguments
			return binaryAST2(symbol, a2, a1);
        }
		return binaryAST2(symbol, a1, a2);
    }

    public static IAST Times(final long num, final IExpr... a) {
        IASTAppendable ast = ast(Times, a.length + 1, false);
        ast.append(ZZ(num));
        ast.appendAll(a, 0, a.length);
        return ast;
    }

	public static IAST ToExpression(final IExpr a0) {
		return new AST1(ToExpression, a0);
	}
    public static IAST Together(final IExpr a0) {
        return new AST1(Together, a0);
    }

    public static IAST Total(final IExpr a0) {
        return new AST1(Total, a0);
    }

    public static IAST Tr(final IExpr a0) {
        return new AST1(Tr, a0);
    }

    public static IAST Trace(final IExpr a0) {
        return new AST1(Trace, a0);
    }

    public static IAST Transpose(final IExpr a0) {
        return new AST1(Transpose, a0);
    }

    public static IAST TrigExpand(final IExpr a0) {
        return new AST1(TrigExpand, a0);
    }

    public static IAST TrigReduce(final IExpr v) {
        return new AST1(TrigReduce, v);
    }

    public static IAST TrigToExp(final IExpr a0) {
        return new AST1(TrigToExp, a0);
    }

    public static IAST TrueQ(final IExpr a0) {
        return new AST1(TrueQ, a0);
    }

    /**
	 * Create a function <code>head(arg)</code> with 1 argument without evaluation.
     *
     * @param head
	 * @param arg
     * @return
     */
	public final static IASTAppendable unary(final IExpr head, final IExpr arg) {
		return new AST(new IExpr[] { head, arg });
    }

    /**
	 * Create a function <code>head(arg)</code> with 1 argument as an <code>AST1</code> mutable object without
	 * evaluation.
     *
     * @param head
	 * @param arg
     * @return
     */
	public final static IASTMutable unaryAST1(final IExpr head, final IExpr arg) {
		return new AST1(head, arg);
    }

	public static IAST UndirectedEdge(final IExpr a0, final IExpr a1) {
		return new B2.UndirectedEdge(a0, a1);
	}
    public static IAST Unequal(final IExpr a0, final IExpr a1) {
        return new AST2(Unequal, a0, a1);
    }

    public static IAST Unevaluated(final IExpr a0) {
        return new AST1(Unevaluated, a0);
    }

	public static IAST Union(final IExpr a0) {
		return new AST1(Union, a0);
	}

	public static IAST Union(final IExpr a0, final IExpr a1) {
		return new AST2(Union, a0, a1);
	}

    public static IAST Unique(final IExpr a0) {
        return new AST1(Unique, a0);
    }

    public static IAST UnitConvert(final IExpr a0) {
        return new AST1(UnitConvert, a0);
    }

    public static IAST UnitConvert(final IExpr a0, final IExpr a1) {
        return new AST2(UnitConvert, a0, a1);
    }

    public static IAST UnitStep(final IExpr a0) {
        return new AST1(UnitStep, a0);
    }

    public static IAST UnsameQ(final IExpr a0, final IExpr a1) {
        return new AST2(UnsameQ, a0, a1);
    }

    public static IAST Unset(final IExpr a0) {
        return new AST1(Unset, a0);
    }

    public static IAST UpSet(final IExpr a0, final IExpr a1) {
        return new AST2(UpSet, a0, a1);
    }

    public static IAST UpSetDelayed(final IExpr a0, final IExpr a1) {
        return new AST2(UpSetDelayed, a0, a1);
    }

    public static IAST Variance(final IExpr a0) {
        return new AST1(Variance, a0);
    }

    public static IAST WeibullDistribution(final IExpr a0, final IExpr a1) {
        return new AST2(WeibullDistribution, a0, a1);
    }

    public static IAST WeibullDistribution(final IExpr a0, final IExpr a1, final IExpr a2) {
        return new AST3(WeibullDistribution, a0, a1, a2);
    }

    public static IAST While(final IExpr a0, final IExpr a1) {
        return new AST2(While, a0, a1);
    }

	public static IAST WhittakerM(final IExpr a0, final IExpr a1, final IExpr a2) {
		return new AST3(WhittakerM, a0, a1, a2);
	}

	public static IAST WhittakerW(final IExpr a0, final IExpr a1, final IExpr a2) {
		return new AST3(WhittakerW, a0, a1, a2);
	}

    public static IAST With(final IExpr a0, final IExpr a1) {
		return new B2.With(a0, a1);
    }

    /**
     * Symmetry of a zero tensor.
     *
     * @param a0
     * @return
     */
    public static IAST ZeroSymmetric(final IExpr a0) {
        return new AST1(ZeroSymmetric, a0);
    }

    public static IAST Zeta(final IExpr a0) {
        return new AST1(Zeta, a0);
    }

    public static IAST Zeta(final IExpr a0, final IExpr a1) {
        return new AST2(Zeta, a0, a1);
    }

    /**
     * Create a large integer number.
     *
     * @param integerValue
     * @return
     */
    public static IInteger ZZ(final BigInteger integerValue) {
        return AbstractIntegerSym.valueOf(integerValue);
    }

	/**
	 * Create an integer number.
	 *
	 * @param integerValue
	 * @return
	 */
	public static IInteger ZZ(final int integerValue) {
		return AbstractIntegerSym.valueOf(integerValue);
	}
    /**
     * Create an integer number.
     *
     * @param integerValue
     * @return
     */
    public static IInteger ZZ(final long integerValue) {
        return AbstractIntegerSym.valueOf(integerValue);
    }

	/**
	 * Create a large integer number.
	 *
	 * @param integerString
	 *            the integer number represented as a String
	 * @param radix
	 *            the radix to be used while parsing
	 * @return Object
	 */
	public static IInteger ZZ(final String integerString, final int radix) {
		return AbstractIntegerSym.valueOf(integerString, radix);
	}
	/**
	 * The operator form <code>op(f)[expr]</code> is transformed to <code>op(expr, f)</code>
	 *
	 * @param ast1Arg
	 *            an IAST with condition <code>ast1Arg.head().isAST1() && ast1Arg.isAST1()</code>
	 * @return
	 */
	public static IAST operatorFormAppend(final IAST ast1Arg) {
		if (ast1Arg.head().isAST1() && ast1Arg.isAST1()) {
			return new AST2(ast1Arg.topHead(), ast1Arg.arg1(), ((IAST) ast1Arg.head()).arg1());
		}
		return NIL;
	}
	/**
	 * The binary operator form <code>op(f, g)[expr]</code> is transformed to <code>op(expr, f, g)</code>
	 *
	 * @param astArg
	 *            an IAST with condition <code>astArg.head().isAST2() && astArg.isAST1()</code>
	 * @return
	 */
	public static IAST operatorFormAppend2(final IAST astArg) {
		if (astArg.head().isAST2() && astArg.isAST1()) {
			return new AST3(astArg.topHead(), astArg.arg1(), ((IAST) astArg.head()).arg1(), ((IAST) astArg.head()).arg2());
		}
		return NIL;
	}

	/**
	 * The operator form <code>op(f)[expr]</code> is transformed to <code>op(f, expr)</code>
	 *
	 * @param ast1Arg
	 *            an IAST with condition <code>ast1Arg.head().isAST1() && ast1Arg.isAST1()</code>
	 * @return
	 */
	public static IAST operatorFormPrepend(final IAST ast1Arg) {
		if (ast1Arg.head().isAST1() && ast1Arg.isAST1()) {
			return new AST2(ast1Arg.topHead(), ((IAST) ast1Arg.head()).arg1(), ast1Arg.arg1());
        }
        return NIL;
    }

    /**
     * Generate a <code>n x m</code> matrix.
     *
     * @param biFunction
	 * @param n
	 *            the number of rows of the matrix.
	 * @param m
	 *            the number of elements in one row
     * @return
     */
    public static IAST matrix(BiFunction<Integer, Integer, ? extends IExpr> biFunction, int n, int m) {
		if (n > Config.MAX_MATRIX_DIMENSION_SIZE || m > Config.MAX_MATRIX_DIMENSION_SIZE) {
			ASTElementLimitExceeded.throwIt(((long) n) * ((long) m));
		}
        IASTAppendable matrix = F.ListAlloc(n);
        for (int i = 0; i < n; i++) {
            IASTAppendable row = F.ListAlloc(m);
            for (int j = 0; j < m; j++) {
                row.append(biFunction.apply(i, j));
            }
            matrix.append(row);
        }
		// because the rows can contain sub lists the IAST.IS_MATRIX flag cannot be set directly. isMatrix() must be
		// used!
		matrix.isMatrix(true);
        return matrix;
    }

    /**
     * Generate a vector with <code>n</code> elements.
     *
     * @param iFunction
	 * @param n
	 *            the number of elements of the vector.
     * @return
     */
    public static IAST vector(IntFunction<? extends IExpr> iFunction, int n) {
        IASTAppendable matrix = F.ListAlloc(n);
        for (int i = 0; i < n; i++) {
            matrix.append(iFunction.apply(i));
        }
        matrix.addEvalFlags(IAST.IS_VECTOR);
        return matrix;
    }

    /**
     * Parses a given string to an instance of {@link IExpr}
	 *
     * Examples:
     *
     * <pre>
     * "7/9" -> RationalScalar.of(7, 9)
     * "3.14" -> DoubleScalar.of(3.14)
     * "(3+2)*I/(-1+4)+8-I" -> ComplexScalar.of(8, 2/3) == "8+2/3*I"
     * "9.81[m*s^-2]" -> Quantity.of(9.81, "m*s^-2")
     * </pre>
	 *
     * If the parsing logic encounters an inconsistency, the return type is a {@link IStringX} that holds the input
     * string.
	 *
     * Scalar types that are not supported include {@link GaussScalar}.
     *
     * @param string
     * @return scalar
     */
    public static IExpr fromString(String string) {
        try {
            return QuantityParser.of(string);
        } catch (Exception exception) {
            // ---
        }
        return stringx(string);
    }

    /**
     * Show the result in an HTML page with the help of the Java <code>Desktop.getDesktop().open()</code> method. On
     * some platforms the Desktop API may not be supported; use the <code>isDesktopSupported()</code> method todetermine
     * if the current desktop is supported.
     *
     * @param expr
     * @return
	 * @throws IOException
     */
    public static String show(IExpr expr) {
		try {
			if (expr.isSameHeadSizeGE(Show, 2)) {
				IAST show = (IAST) expr;
				if (show.size() > 1 && show.arg1().isSameHeadSizeGE(Graphics, 2)) {
					return openSVGOnDesktop(show);
				}
			} else if (expr instanceof GraphExpr) {
				String javaScriptStr = GraphFunctions.graphToJSForm((GraphExpr) expr);
				if (javaScriptStr != null) {
					String html = Config.VISJS_PAGE;
					html = StringUtils.replace(html, "`1`", javaScriptStr);
					html = StringUtils.replace(html, "`2`", "var options = {};");
					return openHTMLOnDesktop(html);
				}
			} else if (expr.isAST(JSFormData, 3)) {
				return printJSFormData(expr);
			} else if (expr.isString()) {
				IStringX str = (IStringX) expr;
				if (str.getMimeType() == IStringX.TEXT_HTML) {
					String htmlSnippet = str.toString();
					String htmlPage = Config.HTML_PAGE;
					htmlPage = StringUtils.replace(htmlPage, "`1`", htmlSnippet);
					System.out.println(htmlPage);
					return F.openHTMLOnDesktop(htmlPage);
				}
			} else if (expr.isList(new Predicate<IExpr>() {
				@Override
				public boolean test(IExpr x) {
					return x.isAST(JSFormData, 3);
				}
			})) {
				final StringBuilder buf = new StringBuilder();
				((IAST) expr).forEach(new Consumer<IExpr>() {
					@Override
					public void accept(IExpr x) {
						buf.append(printJSFormData(x));
					}
				});
				return buf.toString();
			}
		} catch (Exception ex) {
			if (FEConfig.SHOW_STACKTRACE) {
				ex.printStackTrace();
			}
		}
        return null;
    }

	private static String printJSFormData(IExpr expr) {
		IAST jsFormData = (IAST) expr;
		if (jsFormData.arg2().toString().equals("mathcell")) {
			try {
				String manipulateStr = jsFormData.arg1().toString();
				String html = Config.MATHCELL_PAGE;
				html = StringUtils.replace(html, "`1`", manipulateStr);
				return openHTMLOnDesktop(html);
			} catch (Exception ex) {
				if (FEConfig.SHOW_STACKTRACE) {
					ex.printStackTrace();
				}
			}
		} else if (jsFormData.arg2().toString().equals("jsxgraph")) {
			try {
				String manipulateStr = jsFormData.arg1().toString();
				String html = Config.JSXGRAPH_PAGE;
				html = StringUtils.replace(html, "`1`", manipulateStr);
				return openHTMLOnDesktop(html);
			} catch (Exception ex) {
				if (FEConfig.SHOW_STACKTRACE) {
					ex.printStackTrace();
				}
			}
		} else if (jsFormData.arg2().toString().equals("plotly")) {
			try {
				String manipulateStr = jsFormData.arg1().toString();
				String html = Config.PLOTLY_PAGE;
				html = StringUtils.replace(html, "`1`", manipulateStr);
				return openHTMLOnDesktop(html);
			} catch (Exception ex) {
				if (FEConfig.SHOW_STACKTRACE) {
					ex.printStackTrace();
				}
			}
		} else if (jsFormData.arg2().toString().equals("treeform")) {
			try {
				String manipulateStr = jsFormData.arg1().toString();
				String html = Config.VISJS_PAGE;
				html = StringUtils.replace(html, "`1`", manipulateStr);
				html = StringUtils.replace(html, "`2`", //
						"  var options = {\n" + //
								"		  edges: {\n" + //
								"              smooth: {\n" + //
								"                  type: 'cubicBezier',\n" + //
								"                  forceDirection:  'vertical',\n" + //
								"                  roundness: 0.4\n" + //
								"              }\n" + //
								"          },\n" + //
								"          layout: {\n" + //
								"              hierarchical: {\n" + //
								"                  direction: \"UD\"\n" + //
								"              }\n" + //
								"          },\n" + //
								"          nodes: {\n" + //
								"            shape: 'box'\n" + //
								"          },\n" + //
								"          physics:false\n" + //
								"      }; "//
				);
				return openHTMLOnDesktop(html);
			} catch (Exception ex) {
				if (FEConfig.SHOW_STACKTRACE) {
					ex.printStackTrace();
				}
			}
		} else if (jsFormData.arg2().toString().equals("traceform")) {
			try {
				String jsStr = jsFormData.arg1().toString();
				String html = Config.TRACEFORM_PAGE;
				html = StringUtils.replace(html, "`1`", jsStr);
				return openHTMLOnDesktop(html);
			} catch (Exception ex) {
				if (FEConfig.SHOW_STACKTRACE) {
					ex.printStackTrace();
				}
			}
		}
		return null;
	}

	public static String openSVGOnDesktop(IAST show) throws IOException {
		StringBuilder stw = new StringBuilder();
		Show2SVG.graphicsToSVG(show.getAST(1), stw);
		File temp = File.createTempFile("tempfile", ".svg");
		BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
		bw.write(stw.toString());
		bw.close();
//		if (Desktop.isDesktopSupported()) {
//			Desktop.getDesktop().open(temp);
//		}
		return temp.toString();
	}

	public static String openHTMLOnDesktop(String html) throws IOException {
		File temp = File.createTempFile("tempfile", ".html");
		BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
		bw.write(html);
		bw.close();
//		if (Desktop.isDesktopSupported()) {
//			Desktop.getDesktop().open(temp);
//		}
		return temp.toString();
	}

	public static IExpr zeroInteger() {

		return C0;
	}

	public static INum oneDouble() {
		return CD1;
    }
}