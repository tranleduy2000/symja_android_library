package org.matheclipse.core.expression;

import org.matheclipse.core.interfaces.IBuiltInSymbol;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.parser.client.FEConfig;
import org.matheclipse.parser.trie.Tries;

import java.util.Locale;
import java.util.Map;

import it.unimi.dsi.fastutil.objects.Object2ShortOpenHashMap;

/**
 * Factory for creating Symja built-in symbols (interface {@link IBuiltInSymbol}). The built-in symbols are generated
 * with the tools class <code>BuiltinGenerator</code>.
 */
public class S {

  public static final IBuiltInSymbol Surd = F.Surd;
  public static final IBuiltInSymbol ComplexInfinity = F.ComplexInfinity;
  public static final IBuiltInSymbol Indeterminate = F.Indeterminate;
  public static final IBuiltInSymbol DirectedInfinity = F.DirectedInfinity;
  public static final IBuiltInSymbol Infinity = F.Infinity;
  public static final IBuiltInSymbol Unevaluated = F.Unevaluated;
  public static final IBuiltInSymbol LongForm = F.LongForm;
  public static final IBuiltInSymbol GammaRegularized = F.GammaRegularized;
  public static final IBuiltInSymbol SparseArray = F.SparseArray;
  public static final IBuiltInSymbol Round = F.Round;
  public static final IBuiltInSymbol PolyLog = F.PolyLog;
  public static final IBuiltInSymbol Log = F.Log;
  public static final IBuiltInSymbol NumericArray = F.NumericArray;
  public static final IBuiltInSymbol RandomVariate = F.RandomVariate;
  public static final IBuiltInSymbol NumericArrayQ = F.NumericArrayQ;
  public static final IBuiltInSymbol NumericArrayType = F.NumericArrayType;
  public static final IBuiltInSymbol Evaluate = F.Evaluate;
  public static final IBuiltInSymbol Defer = F.Defer;
  public static final IBuiltInSymbol Except = F.Except;
  public static final IBuiltInSymbol Sinh = F.Sinh;
  public static final IBuiltInSymbol ListLinePlot = F.ListLinePlot;
  public static final IBuiltInSymbol Sequence = F.Sequence;
  public static final IBuiltInSymbol ListPlot = F.ListPlot;
  public static final IBuiltInSymbol Plot = F.Plot;
  public static final IBuiltInSymbol ParametricPlot = F.ParametricPlot;
  public static final IBuiltInSymbol PolarPlot = F.PolarPlot;
  public static final IBuiltInSymbol E = F.E;
  public static final IBuiltInSymbol Inner = F.Inner;
  public static final IBuiltInSymbol Times = F.Times;
  public static final IBuiltInSymbol RegularExpression = F.RegularExpression;
  public static final IBuiltInSymbol Cos = F.Cos;
  public static final IBuiltInSymbol Cot = F.Cot;
  public static final IBuiltInSymbol Csc = F.Csc;
  public static final IBuiltInSymbol Sec = F.Sec;
  public static final IBuiltInSymbol ProductLog = F.ProductLog;
  public static final IBuiltInSymbol Sin = F.Sin;
  public static final IBuiltInSymbol Tan = F.Tan;
  public static final IBuiltInSymbol Abs = F.Abs;
  public static final IBuiltInSymbol Import = F.Import;
  public static final IBuiltInSymbol Get = F.Get;
  public static final IBuiltInSymbol Characters = F.Characters;
  public static final IBuiltInSymbol All = F.All;
  public static final IBuiltInSymbol UpTo = F.UpTo;
  public static final IBuiltInSymbol Plus = F.Plus;
  public static final IBuiltInSymbol AppendTo = F.AppendTo;
  public static final IBuiltInSymbol $RecursionLimit = F.$RecursionLimit;
  public static final IBuiltInSymbol Commonest = F.Commonest;
  public static final IBuiltInSymbol Throw = F.Throw;
  public static final IBuiltInSymbol $IterationLimit = F.$IterationLimit;
  public static final IBuiltInSymbol General = F.General;
  public static final IBuiltInSymbol Key = F.Key;
  public static final IBuiltInSymbol KeyAbsent = F.KeyAbsent;
  public static final IBuiltInSymbol Complex = F.Complex;
  public static final IBuiltInSymbol Rational = F.Rational;
  public static final IBuiltInSymbol Equal = F.Equal;
  public static final IBuiltInSymbol StyleForm = F.StyleForm;
  public static final IBuiltInSymbol Echo = F.Echo;
  public static final IBuiltInSymbol Association = F.Association;
  public static final IBuiltInSymbol Automatic = F.Automatic;
  public static final IBuiltInSymbol False = F.False;
  public static final IBuiltInSymbol Function = F.Function;
  public static final IBuiltInSymbol In = F.In;
  public static final IBuiltInSymbol Heads = F.Heads;
  public static final IBuiltInSymbol Hold = F.Hold;
  public static final IBuiltInSymbol HoldComplete = F.HoldComplete;
  public static final IBuiltInSymbol HoldForm = F.HoldForm;
  public static final IBuiltInSymbol HoldPattern = F.HoldPattern;
  public static final IBuiltInSymbol Out = F.Out;
  public static final IBuiltInSymbol Null = F.Null;
  public static final IBuiltInSymbol Set = F.Set;
  public static final IBuiltInSymbol SetDelayed = F.SetDelayed;
  public static final IBuiltInSymbol Repeated = F.Repeated;
  public static final IBuiltInSymbol RepeatedNull = F.RepeatedNull;
  public static final IBuiltInSymbol True = F.True;
  public static final IBuiltInSymbol List = F.List;
  public static final IBuiltInSymbol Thread = F.Thread;
  public static final IBuiltInSymbol MessageName = F.MessageName;
  public static final IBuiltInSymbol Style = F.Style;
  public static final IBuiltInSymbol IgnoreCase = F.IgnoreCase;


}
