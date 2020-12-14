package org.matheclipse.core.interfaces;

import com.duy.annotations.Nullable;
import com.duy.lambda.Consumer;
import com.duy.lambda.Function;
import com.duy.lambda.Predicate;
import com.duy.lambda.Supplier;

import org.hipparchus.Field;
import org.hipparchus.FieldElement;
import org.hipparchus.complex.Complex;
import org.hipparchus.exception.MathRuntimeException;
import org.hipparchus.linear.RealMatrix;
import org.hipparchus.linear.RealVector;
import org.jgrapht.GraphType;
import org.matheclipse.core.convert.VariablesSet;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.expression.S;
import org.matheclipse.core.visit.IVisitor;
import org.matheclipse.core.visit.IVisitorBoolean;
import org.matheclipse.core.visit.IVisitorInt;
import org.matheclipse.core.visit.IVisitorLong;
import org.matheclipse.core.visit.VisitorReplaceAll;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import edu.jas.structure.ElemFactory;
import edu.jas.structure.GcdRingElem;

/**
 * (I)nterface for a mathematical (Expr)ession<br>
 * <code>IExpr</code> is the main interface for the Symja object type hierarchy:
 *
 * <pre>
 * java.lang.Object
 *    |--- org.matheclipse.core.expression.AbstractAST
 *    |       |--- org.matheclipse.core.expression.HMArrayList
 *    |               |--- org.matheclipse.core.expression.AST - abstract syntax tree which represents lists, vectors, matrices and functions
 *    |                                   implements IAST, IASTMutable, IASTAppendable, IExpr
 *    |
 *    |--- org.matheclipse.core.expression.ExprImpl
 *            |           implements IExpr
 *            |
 *            |--- org.matheclipse.core.expression.ApcomplexNum - Apcomplex number
 *            |                   implements IComplexNum, INumber, IExpr
 *            |
 *            |--- org.matheclipse.core.expression.ApfloatNum - Apfloat number
 *            |                   implements INum, ISignedNumber, INumber, IExpr
 *            |
 *            |--- org.matheclipse.core.expression.ComplexNum - a complex number with real and imaginary part represented by Java <code>double</code>
 *            |                   implements IComplexNum, INumber, IExpr
 *            |
 *            |--- org.matheclipse.core.expression.ComplexSym - exact complex number
 *            |                   implements IComplex, IBigNumber, INumber, IExpr
 *            |
 *            |--- org.matheclipse.core.expression.FractionSym - exact fraction number
 *            |                   implements IFraction, IRational, ISignedNumber, IBigNumber, INumber, IExpr
 *            |
 *            |--- org.matheclipse.core.expression.IntegerSym - exact integer number
 *            |                   implements IInteger, IRational, ISignedNumber, IBigNumber, INumber, IExpr
 *            |
 *            |--- org.matheclipse.core.expression.Num - a real number which is represented by a Java <code>double</code> value
 *            |                   implements INum, ISignedNumber, INumber, IExpr
 *            |
 *            |--- org.matheclipse.core.expression.Pattern - a pattern object (i.e. <code>x_</code>)
 *            |                   implements IPattern, IPatternObject, IExpr
 *            |
 *            |--- org.matheclipse.core.expression.PatternSequence - a pattern sequence object (i.e. <code>x__</code>)
 *            |                   implements IPatternSequence, IPatternObject, IExpr
 *            |
 *            |--- org.matheclipse.core.expression.StringX - a Java <code>string</code> wrapper
 *            |                   implements IStringX, IExpr
 *            |
 *            |--- org.matheclipse.core.expression.Symbol - represents variables, function names or constants
 *                                implements ISymbol, IExpr
 * </pre>
 */
@SuppressWarnings({"UnnecessaryInterfaceModifier", "JavaDoc", "JavadocReference"})
public interface IExpr extends Comparable<IExpr>, GcdRingElem<IExpr>, Serializable,
    FieldElement<IExpr> {

  public static final int ASTID = 1024;

  public static final int BLANKID = 4096;

  public static final int COMPLEXID = 32;

  public static final int DOUBLECOMPLEXID = 4;

  public static final int DOUBLEID = 2;

  public static final int FRACTIONID = 16;

  public static final int INTEGERID = 8;

  public static final int METHODSYMBOLID = 8192;

  public static final int PATTERNID = 2048;

  public static final int SERIESID = 64;

  public static final int QUANTITYID = 128;

  public static final int STRINGID = 256;

  public static final int SYMBOLID = 512;

  public static final int DATASETID = 16384;

  public static final int DATAID = 32786;

  public static final int BYTEARRAYID = DATAID + 1;

  public static final int COMPILEFUNCTONID = DATAID + 2;

  public static final int GEOPOSITIONID = DATAID + 3;

  public static final int GRAPHEXPRID = DATAID + 4;

  public static final int DATEOBJECTEXPRID = DATAID + 5;

  public static final int TIMEOBJECTEXPRID = DATAID + 6;

  public static final int FITTEDMODELID = DATAID + 7;

  public static final int INTERPOLATEDFUNCTONID = DATAID + 8;

  public static final int SPARSEARRAYID = DATAID + 9;

  public static final int NUMERICARRAYID = DATAID + 10;

  public static final int DISPATCHID = DATAID + 11;

  public static final int TESTREPORTOBJECT = DATAID + 12;

  public static final int TESTRESULTOBJECT = DATAID + 13;


  /**
   * Operator overloading for Scala operator <code>/</code>. Calls <code>divide(that)</code>.
   *
   * @param that
   * @return
   */
  IExpr $div(final IExpr that);

  /**
   * Operator overloading for Scala operator <code>/</code>. Calls <code>divide(that)</code>.
   */
  IExpr $minus(final IExpr that);

  /**
   * Operator overloading for Scala operator <code>+</code>. Calls <code>plus(that)</code>.
   */
  IExpr $plus(final IExpr that);

  /**
   * Operator overloading for Scala operator <code>*</code>. Calls <code>times(that)</code>.
   */
  IExpr $times(final IExpr that);

  /**
   * Operator overloading for Scala operator <code>^</code>. Calls <code>power(that)</code>.
   */
  IExpr $up(final IExpr that);

  /**
   * Accept a visitor with return type T
   */
  IExpr accept(IVisitor visitor);

  /**
   * Accept a visitor with return type <code>boolean</code>
   */
  boolean accept(IVisitorBoolean visitor);

  /**
   * Accept a visitor with return type <code>int</code>
   */
  int accept(IVisitorInt visitor);

  /**
   * Accept a visitor with return type <code>long</code>
   */
  long accept(IVisitorLong visitor);

  @Override
  IExpr add(IExpr that);

  @Override
  IExpr multiply(int n);

  @Override
  IExpr reciprocal() throws MathRuntimeException;

  @Override
  Field<IExpr> getField();

  IExpr and(final IExpr that);

  /**
   * <p>
   * Set an evaluation flag.
   * </p>
   * <b>Note</b> only certain data structures like <code>IAST</code> and <code>ISparseArray</code>
   * support evaluation flags, otherwise the <code>this</code> object will be returned without
   * modification.
   *
   * @param evalFlags
   * @return
   */
  IExpr addEvalFlags(final int evalFlags);

  /**
   * @param leaves
   * @return an IExpr instance with the current expression as head(), and leaves as leaves().
   */
  IExpr apply(IExpr... leaves);

  /**
   * @param leaves
   * @return an IExpr instance with the current expression as head(), and leaves as leaves().
   */
  IExpr apply(List<? extends IExpr> leaves);

  /**
   * Returns the <b>number of arguments</b> in this {@code IAST}. The <b>number of arguments</b>
   * equals <code>size() - 1</code> (i.e. the <b>number of elements</b> minus 1). If this is an atom
   * return size <code>-1</code>.
   *
   * @return the number of arguments in this {@code IAST}.
   * @see #size()
   */
  int argSize();

  Object asType(Class<?> clazz);

  /**
   * Get the first element of this <code>AST</code> list (i.e. get(1)). Return <code>F.NIL</code> if
   * this object isn't an <code>AST</code>. Use this method if the AST gives <code>true</code> for
   * the <code>isPower()</code> method.
   *
   * @return the first argument of the function represented by this <code>AST</code> or
   * <code>F.NIL</code> if this
   * object isn't an AST.
   */
  IExpr base();

  /**
   * Compares this expression with the specified expression for order. Returns a negative integer,
   * zero, or a positive integer as this expression is canonical less than, equal to, or greater
   * than the specified expression.
   */
  @Override
  int compareTo(IExpr expr);

  /**
   * Return the argument of a complex number.
   *
   * @return the argument of a complex number
   */
  IExpr complexArg();

  /**
   * Conjugate this (complex-) number.
   *
   * @return the conjugate complex number
   */
  IExpr conjugate();

  /**
   * Get a nested list with <code>this</code> expression set as a value.
   * <p>
   * <pre>
   * v.constantArray(2, 3) -> {{v, v, v}, {v, v, v}}
   * </pre>
   *
   * @param startPosition the position from there to create the constant array recusively.
   * @param arr the nested lists dimensions. <code>arr.length</code> must be greater
   * <code>0</code>
   * @return <code>F.NIL</code> if <code>arr</code> has length 0.
   */
  IASTAppendable constantArray(IExpr head, final int startPosition, int... arr);

  /**
   * Return <code>negate()</code> if <code>number.sign() < 0</code>, otherwise return
   * <code>this</code>
   *
   * @param number
   */
  IExpr copySign(ISignedNumber number);

  /**
   * Returns an <code>IExpr</code> whose value is <code>(this - 1)</code>. Calculates
   * <code>F.eval(F.Subtract(this, C1))</code> in the common case and uses a specialized
   * implementation for derived number classes.
   */
  IExpr dec();

  /**
   * Calculates the depth of an expression. Atomic expressions (no sublists) have depth <code>1
   * </code> Example: the nested list <code>[x,[y]]</code> has depth <code>3</code>
   */
  int depth(); /*{
    return 1;
  }*/

  /**
   * Determine precision of this expression. Return -1 for symbolic evaluation.
   *
   * @return the precision of this expression. -1 for symbolic evaluation.
   */
  long determinePrecision();

  /**
   * Calls <code>get(position).equals(expr)</code> if <code>this</code> is an <code>IAST</code>.
   * Returns
   * <code>false</code> otherwise.
   *
   * @param position the position in the <code>IAST</code> which should be tested for equality
   * @param expr the expression which should be tested for equality
   */
  boolean equalsAt(int position, final IExpr expr);

  /**
   * Compare if <code>this == that</code:
   * <ul>
   * <li>return F.True if the comparison is <code>true</code></li>
   * <li>return F.False if the comparison is <code>false</code></li>
   * <li>return F.NIL if the comparison is undetermined (i.e. could not be evaluated)</li>
   * </ul>
   *
   * @return <code>F.True, F.False or F.NIL</code
   */
  IExpr equalTo(IExpr that);

  /**
   * Evaluate the expression to a <code>INumber</code> value.
   *
   * @return <code>null</code> if the conversion is not possible.
   */
  Complex evalComplex();

  /**
   * Evaluate the expression to a Java <code>double</code> value. If the conversion to a double
   * value is not possible, the method throws a <code>WrongArgumentType</code> exception.
   *
   * @return this expression converted to a Java <code>double</code> value.
   */
  double evalDouble();

  /**
   * Evaluate the expression to a <code>INumber</code> value.
   *
   * @return <code>null</code> if the conversion is not possible.
   */
  INumber evalNumber();

  /**
   * Evaluate the expression to a <code>ISignedNumber</code> value.
   *
   * @return <code>null</code> if the conversion is not possible.
   */
  ISignedNumber evalReal();

  /**
   * Evaluate the expression to a <code>ISignedNumber</code> value.
   *
   * @return <code>null</code> if the conversion is not possible.
   * @deprecated use {@link #evalReal()} instead
   */
  @Deprecated
  ISignedNumber evalSignedNumber(); /*{
    return evalReal();
  }*/

  /**
   * Evaluate an expression
   *
   * @param engine the evaluation engine
   * @return the evaluated Object or <code>F.NIL</code> if the evaluation is not possible (i.e. the
   *     evaluation doesn't change the object).
   */
  IExpr evaluate(EvalEngine engine); /*{
    return F.NIL;
  }*/

  IExpr evaluateHead(IAST ast, EvalEngine engine);

  /**
   * Get the second element of this <code>Power(base, exponent)</code> expression.
   */
  IExpr exponent();

  @Override
  ElemFactory<IExpr> factory();

  /**
   * Get the first element of this <code>AST</code> list (i.e. get(1)). Return <code>F.NIL</code> if
   * this object isn't an <code>AST</code>.
   *
   * @return the second argument of the function represented by this <code>AST</code> or
   * <code>F.NIL</code> if this
   * object isn't an AST.
   */
  IExpr first();

  /**
   * Get the last element of the <code>AST</code> list (i.e. get(size()-1). Return
   * <code>F.NIL</code> if this object isn't an <code>AST</code>.
   *
   * @return the last argument of the function represented by this <code>AST</code>.
   * @see IExpr#head()
   */
  IExpr last();

  /**
   * Return the <code>FullForm()</code> of this expression
   */
  String fullFormString();

  /**
   * Return the Gaussian integers real and imaginary parts. If this is not a Gaussian integer
   * return
   * <code>null</code>
   *
   * @return <code>null</code> if this is not a Gaussian integer
   */
  IInteger[] gaussianIntegers();

  IExpr gcd(IExpr that);

  IExpr[] egcd(IExpr b);

  /**
   * Get the element at the specified <code>index</code> if this object is of type
   * <code>IAST</code>.
   *
   * @param index
   */
  IExpr getAt(final int index);

  IExpr getOptionalValue();

  /**
   * Evaluate Greater, if both arguments are real numbers
   *
   * @param a1
   */
  IExpr greater(final IExpr a1);

  /**
   * Evaluate GreaterEqual, if both arguments are real numbers
   *
   * @param a1
   */
  IExpr greaterEqual(final IExpr a1);

  /**
   * Compare if <code>this >= that</code:
   * <ul>
   * <li>return F.True if the comparison is <code>true</code></li>
   * <li>return F.False if the comparison is <code>false</code></li>
   * <li>return F.NIL if the comparison is undetermined (i.e. could not be evaluated)</li>
   * </ul>
   *
   * @return <code>F.True, F.False or F.NIL</code
   */
  IExpr greaterEqualThan(IExpr that);

  /**
   * Compare if <code>this > that</code:
   * <ul>
   * <li>return F.True if the comparison is <code>true</code></li>
   * <li>return F.False if the comparison is <code>false</code></li>
   * <li>return F.NIL if the comparison is undetermined (i.e. could not be evaluated)</li>
   * </ul>
   *
   * @return <code>F.True, F.False or F.NIL</code
   */
  IExpr greaterThan(IExpr that);

  /**
   * Returns <code>true</code>, if <b>all of the elements</b> in the subexpressions or the
   * expression itself, did not match the given pattern. Calls <code>isFree(pattern, true)</code>.
   *
   * @param pattern a pattern-matching expression
   * @return
   */
  boolean has(IExpr pattern);

  /**
   * Returns <code>false</code>, if <b>all of the elements</b> in the subexpressions or the
   * expression itself, aren't a symbolic or numerical complex number or a structure with complex
   * number arguments.
   *
   * @return <code>true</code> if this expression is a complex number or a structure with complex
   * number arguments.
   */
  boolean hasComplexNumber();

  /**
   * Returns <code>true</code>, if <b>at least one of the elements</b> in the subexpressions or the
   * expression itself, match the given pattern.
   *
   * @param pattern a pattern-matching expression
   * @param heads if set to <code>false</code>, only the arguments of an IAST should be tested and
   * not the
   * <code>Head[]</code> element.
   * @return
   */
  boolean has(IExpr pattern, boolean heads);

  /**
   * Returns <code>true</code>, if <b>at least one of the elements</b> in the subexpressions or the
   * expression itself, satisfy the given unary predicate.
   *
   * @param predicate a unary predicate
   * @param heads if set to <code>false</code>, only the arguments of an IAST should be tested
   * and not the
   * <code>Head[]</code> element.
   * @return
   */
  boolean has(Predicate<IExpr> predicate, boolean heads);

  /**
   * If this object is an instance of <code>IAST</code> get the first element (offset 0) of the
   * <code>IAST</code> list (i.e. <code>#get(0)</code> ). Otherwise return the specific header,
   * i.e. for
   * <code>integer number type => F.Integer, fraction number type => F.Rational, complex number
   * type => F.Complex, ...  </code>
   *
   * @return the head of the expression, which must not be null.
   */
  IExpr head();

  /**
   * Get the head of an expression and if it is a built-in symbol return the ID of this symbol,
   * otherwise return
   * <code>-1</code> (ID.UNKNNOWN)
   *
   * @return return the ID of this built-in header symbol or <code>-1</code>
   */
  int headID();

  /**
   * A unique integer ID for the implementation of this expression
   *
   * @return a unique integer id for the implementation of this expression
   */
  int hierarchy();

  /**
   * If this expression unequals <code>F.NIL</code>, invoke the specified consumer with the
   * <code>this</code> object, otherwise do nothing.
   *
   * @param consumer block to be executed if this expression unequals <code>F.NIL</code>
   */
  IExpr ifPresent(Function<? super IExpr, IExpr> function);

  /**
   * If a value is present, performs the given <code>consumer</code> with the value, otherwise
   * performs the given empty-based action.
   *
   * @param consumer the action to be performed, if a value is present
   * @param emptyAction the empty-based action to be performed, if no value is present
   */
  void ifPresentOrElse​(Consumer<? super IExpr> consumer, Runnable emptyAction);

  /**
   * Return the imaginary part of this expression if possible. Otherwise return
   * <code>Im(this)</code>.
   *
   * @return real part
   */
  IExpr im();

  /**
   * Returns an <code>IExpr</code> whose value is <code>(this + 1)</code>. Calculates
   * <code>F.eval(F.Plus(this, C1))</code> in the common case and uses a specialized implementation
   * for derived number classes.
   */
  IExpr inc();

  /**
   * If this is of type {@link IAST}, find the first argument position, which equals
   * <code>expr</code>. The search starts at index <code>1</code>. Otherwise return
   * <code>-1</code>.
   *
   * @param expr
   * @return <code>-1</code> if no position was found
   */
  int indexOf(final IExpr expr);

  /**
   * If this is of type {@link IAST}, find the first argument position, which fulfills the
   * <code>predicate</code>. The search starts at index <code>1</code>. Otherwise return
   * <code>-1</code>.
   *
   * @param predicate
   * @return the index of the first occurrence of the specified predicate, or <code>-1</code> if no
   * position was found
   */
  int indexOf(Predicate<? super IExpr> predicate);

  /**
   * If this is of type {@link IAST}, find the first argument position, which fulfills the
   * <code>predicate</code>. The search starts at index <code>fromIndex</code>. Otherwise return
   * <code>-1</code>.
   *
   * @param predicate
   * @param fromIndex
   * @return the index of the first occurrence of the specified predicate, starting at the specified
   * index, or
   * <code>-1</code> if no position was found
   */
  int indexOf(Predicate<? super IExpr> predicate, int fromIndex);

  /**
   * Return the internal Java form of this expression.
   *
   * @param symbolsAsFactoryMethod if <code>true</code> use the <code>F.symbol()</code> method,
   * otherwise print the symbol name.
   * @param depth the recursion depth of this call. <code>0</code> indicates
   * &quot;recurse without a limit&quot;.
   * @return the internal Java form of this expression
   */
  String internalFormString(boolean symbolsAsFactoryMethod, int depth);

  /**
   * Return the internal Java form of this expression.
   *
   * @param symbolsAsFactoryMethod if <code>true</code> use the <code>F.symbol()</code> method,
   * otherwise print the symbol name.
   * @param depth the recursion depth of this call. <code>0</code> indicates
   * &quot;recurse without a limit&quot;.
   * @param useOperators use operators instead of function names for representation of
   * Plus, Times, Power,...
   * @param usePrefix use the <code>F....</code> class prefix for genrating Java code.
   * @return the internal Java form of this expression
   */
  String internalJavaString(
      boolean symbolsAsFactoryMethod,
      int depth,
      boolean useOperators,
      boolean usePrefix,
      boolean noSymbolPrefix,
      Function<IExpr, String> variables);

  String internalJavaString(Function<IExpr, String> variables);


  /**
   * Return the internal Scala form of this expression.
   *
   * @param symbolsAsFactoryMethod if <code>true</code> use the <code>F.symbol()</code> method,
   * otherwise print the symbol name.
   * @param depth the recursion depth of this call. <code>0</code> indicates
   * &quot;recurse without a limit&quot;.
   * @return the internal Scala form of this expression
   */
  String internalScalaString(boolean symbolsAsFactoryMethod, int depth);

  /**
   * Test if this expression is the function <code>Abs[&lt;arg&gt;]</code>
   *
   * @return
   */
  boolean isAbs();

  /**
   * Test if this expression and all subexpressions are already expanded i.e. all <code>Plus, Times,
   * Power</code> (sub-)expressions are expanded.
   *
   * @return
   */
  boolean isAllExpanded();

  /**
   * Test if this expression is the <code>Alternatives</code> function
   * <code>Alternatives[&lt;pattern1&gt;, &lt;pattern2&gt;, ...]</code>
   *
   * @return
   */
  boolean isAlternatives();


  /**
   * Test if this expression is the function <code>And[&lt;arg&gt;,...]</code>
   */
  boolean isAnd();

  /**
   * Test if this expression is the function <code>ArcCos[&lt;arg&gt;]</code>
   *
   * @return
   */
  boolean isArcCos();

  /**
   * Test if this expression is the function <code>ArcCosh[&lt;arg&gt;]</code>
   */
  boolean isArcCosh();

  /**
   * Test if this expression is the function <code>ArcSin[&lt;arg&gt;]</code>
   */
  boolean isArcSin();

  /**
   * Test if this expression is the function <code>ArcSinh[&lt;arg&gt;]</code>
   */
  boolean isArcSinh();

  /**
   * Test if this expression is the function <code>ArcTan[&lt;arg&gt;]</code>
   */
  boolean isArcTan();

  /**
   * Test if this expression is the function <code>ArcTanh[&lt;arg&gt;]</code>
   */
  boolean isArcTanh();

  /**
   * Test if this AST is an association <code>&lt;|a-&gt;b, c-&gt;d|&gt;</code>(i.e. type
   * <code>AssociationAST</code>)
   *
   * @return
   */
  boolean isAssociation();

  /**
   * Test if this expression is an AST list, which contains a <b>header element</b> (i.e. the
   * function name) at index position <code>0</code> and some optional <b>argument elements</b> at
   * the index positions <code>1..n</code>. Therefore this expression is no <b>atomic
   * expression</b>.
   *
   * @see #isAtom()
   */
  boolean isAST();


  /**
   * Test if this expression is an AST list, which contains the given <b>header element</b> at index
   * position
   * <code>0</code> and some optional <b>argument elements</b> at the index positions
   * <code>1..(size()-1)</code>.
   * Therefore this expression is not an <b>atomic expression</b>.
   *
   * @param header the header element at position 0, which should be tested
   * @see #isAtom()
   */
  boolean isAST(IExpr header);

  /**
   * Test if this expression is an AST list, which contains the given <b>header element</b> at index
   * position
   * <code>0</code> and optional <b>argument elements</b> at the index positions
   * <code>1..(length-1)</code>. If this
   * test gives <code>true</code> this expression is not an <b>atomic expression</b>.
   *
   * @param header the header element at position 0, which should be tested
   * @param length the size the AST expression must have (<b>inclusive head element</b>)
   * @see #isAtom()
   */
  boolean isAST(IExpr header, int length);

  /**
   * Test if this expression is an AST list, which contains the given <b>header element</b> at index
   * position
   * <code>0</code> and optional <b>argument elements</b> at the index positions
   * <code>1..(length-1)</code>. If this
   * test gives <code>true</code> this expression is not an <b>atomic expression</b>.
   *
   * @param header the header element at position 0, which should be tested
   * @param length the size the AST expression must have
   * @param args the arguments of this AST which should be tested, if they are equal, a
   * <code>null</code> value argument skips the equals check.
   * @see #isAtom()
   */
  boolean isAST(IExpr header, int length, IExpr... args);

  /**
   * Test if this expression is an AST list, which contains the given <b>header element</b> at index
   * position
   * <code>0</code> and optional <b>argument elements</b> at the index positions
   * <code>1..(length-1)</code>. If this
   * test gives <code>true</code> this expression is not an <b>atomic expression</b>.
   *
   * @param header the header element at position 0, which should be tested
   * @param minLength the minimum size the AST expression must have
   * @param maxLength the maximum size the AST expression must have
   * @see #isAtom()
   */
  boolean isAST(IExpr header, int minLength, int maxLength);

  /**
   * <p>
   * Test if this expression is an AST list, where the string representation of the <b>header
   * element</b> at index position <code>0</code> equals the given <code>symbol</code> and some
   * optional <b>argument elements</b> at the index positions <code>1..(size()-1)</code>. If this
   * test gives <code>true</code> this expression is not an
   * <b>atomic expression</b>.
   * </p>
   * <p>
   * Example: <code>isAST("Sin")</code> gives <code>true</code> for <code>Sin[Pi/2]</code>.
   * </p>
   * <p>
   * <b>Note:</b> this is a performance critical method, only use it in special cases like for
   * example UI handling etc.
   * </p>
   *
   * @param headerStr string representation of the <b>header element</b> at index position
   * <code>0</code>
   * @see #isAtom()
   */
  boolean isAST(String headerStr);

  /**
   * <p>
   * Test if this expression is an AST list, where the string representation of the <b>header
   * element</b> at index position <code>0</code> equals the given <code>symbol</code> and some
   * optional <b>argument elements</b> at the index positions <code>1..(length-1)</code>.<br/>
   * Therefore this expression is no <b>atomic expression</b>. <br/> Example: <code>isAST("Sin",
   * 2)</code> gives <code>true</code> for <code>Sin(0)</code>.
   * </p>
   *
   * @param headerStr string representation of the <b>header element</b> at index position
   * <code>0</code>
   * @param length the size the AST expression must have
   * @return
   * @see #isAtom()
   */
  boolean isAST(String headerStr, int length);

  /**
   * Test if this expression is an AST function or an Association, which contains a <b>header
   * element</b> (i.e. the function name) at index position <code>0</code> and some optional
   * <b>argument elements</b> at the index positions <code>1..n</code>.
   *
   * @return
   */
  boolean isASTOrAssociation();

  /**
   * <p>
   * Test if this expression is an AST list, which contains a <b>header element</b> (i.e. the
   * function name) at index position <code>0</code> and no <b>argument elements</b>. <br/>
   * Therefore this expression is no <b>atomic expression</b>.
   * </p>
   *
   * @return
   * @see #isAtom()
   */
  boolean isAST0();

  /**
   * <p>
   * Test if this expression is an AST list, which contains a <b>header element</b> (i.e. the
   * function name) at index position <code>0</code> and one <b>argument element</b> at the index
   * position <code>1</code>.<br/> Therefore this expression is no <b>atomic expression</b>.
   * </p>
   *
   * @see #isAtom()
   */
  boolean isAST1();

  /**
   * Test if this expression is an AST list, which contains a <b>header element</b> (i.e. the
   * function name) at index position <code>0</code> and two <b>argument elements</b> at the index
   * positions <code>1, 2</code>. Therefore this expression is no <b>atomic expression</b>.
   *
   * @see #isAtom()
   */
  boolean isAST2();

  /**
   * Test if this expression is an AST list, which contains a <b>header element</b> (i.e. the
   * function name) at index position <code>0</code> and three <b>argument elements</b> at the index
   * positions <code>1, 2, 3</code>. Therefore this expression is no <b>atomic expression</b>.
   *
   * @see #isAtom()
   */
  boolean isAST3();

  /**
   * Test if this expression is an AST list, which contains the given <b>header element</b> at index
   * position
   * <code>0</code> and optional <b>argument elements</b> at the index positions <code>1..n</code>.
   * <code>n</code>
   * must be greater equal than the given <code>length</code>. Therefore this expression is no
   * <b>atomic expression</b>.
   *
   * @param header the header element at position 0, which should be tested
   * @param length the size the AST expression must have
   * @see #isAtom()
   */
  boolean isASTSizeGE(IExpr header, int length);

  /**
   * Test if this expression is an atomic expression (i.e. no AST expression)
   */
  boolean isAtom();

  /**
   * Test if this expression is a <code>Blank[]</code> object
   */
  boolean isBlank();

  /**
   * Test if this expression is a boolean formula (i.e. a symbol or a boolean function
   * <code>And, Equivalent, Nand, Nor, Not, Or, Xor</code> where all arguments are also
   * &quot;boolean formulas&quot;)
   *
   * @return <code>true</code>, if the given expression is a boolean formula or a symbol.
   * @see #isRealResult()
   */
  boolean isBooleanFormula();

  /**
   * Test if this expression is a <code>IBuiltInSymbol</code> symbol and the evaluator implements
   * <code>IBooleanFormula</code>.
   *
   * @return
   */
  boolean isBooleanFormulaSymbol();

  /**
   * Test if this expression is a boolean function with head <code>And, Equivalent, Nand, Nor, Not,
   * Or, Xor</code>.
   *
   * @return
   */
  boolean isBooleanFunction();

  /**
   * Test if this expression is a boolean function (i.e. a symbol or a boolean function like for
   * example
   * <code>And, Equivalent, Equal, Greater, GreaterEqual, Less, LessEqual, Nand, Nor, Not, Or,
   * Xor,...</code> where all arguments are also &quot;boolean functions&quot;) or a symbol or some
   * builtin predicates like for example
   * <code>IntegerQ, EvenQ, PrimeQ,....</code>
   *
   * @return <code>true</code>, if the given expression is a boolean function or a symbol.
   * @see #isRealResult()
   */
  boolean isBooleanResult();

  /**
   * Test if this expression is a symbol (instanceof IBuiltInSymbol)
   */
  boolean isBuiltInSymbol();

  /**
   * Test if this expression is a comparator function (i.e. a function with head
   * <code>Equal, Equivalent, Greater, GreaterEqual, Less, LessEqual, Inequlity, SameQ, Unequal,
   * UnsameQ</code> where all arguments are also &quot;boolean formulas&quot;)
   *
   * @return <code>true</code>, if the given expression is a comparator function.
   */
  boolean isComparatorFunction();

  /**
   * Test if this expression is a symbolic complex number (i.e. <code>instanceof IComplex</code>)
   */
  boolean isComplex();

  /**
   * Test if this expression is representing ComplexInfinity (i.e. DirectedInfinity[])
   */
  boolean isComplexInfinity();

  /**
   * Test if this expression is a numeric complex number (i.e. <code>instanceof IComplexNum</code>)
   */
  boolean isComplexNumeric();

  /**
   * Test if this expression is the Condition function <code>Condition[&lt;arg1&gt;,
   * &lt;arg2&gt;]</code>
   */
  boolean isCondition();

  /**
   * Test if this expression is the ConditionalExpression function <code>ConditionalExpression[&lt;arg1&gt;,
   * &lt;arg2&gt;]</code>
   *
   * @return
   */
  boolean isConditionalExpression();

  /**
   * Test if this expression is the function <code>Conjugate[&lt;arg&gt;]</code>
   */
  boolean isConjugate();

  /**
   * Test if this expression is a symbol with attribute <code>Constant</code>. Therefore numbers
   * return
   * <code>false</code> for this method!
   *
   * @see #isRealResult()
   * @see #isNumericFunction()
   */
  boolean isConstantAttribute();

  /**
   * Test if this expression is a continuous distribution AST (i.e. NormalDistribution(),
   * ExponentialDistribution(),...)
   *
   * @return
   */
  boolean isContinuousDistribution();

  /**
   * Test if this expression is a <code>IBuiltInSymbol</code> symbol and the evaluator implements
   * <code>IComparatorFunction</code>.
   *
   * @return
   */
  boolean isComparatorFunctionSymbol();

  /**
   * Test if this expression is a <code>IBuiltInSymbol</code> symbol and the evaluator implements
   * <code>ICoreFunctionEvaluator</code> (see package <code>org.matheclipse.core.builtin.function</code>).
   */
  boolean isCoreFunctionSymbol();

  /**
   * Test if this expression is a <code>IBuiltInSymbol</code> symbol and the evaluator implements
   * <code>IPrediacte</code>.
   *
   * @return
   */
  boolean isPredicateFunctionSymbol();

  /**
   * Test if this expression is the function <code>Cos[&lt;arg&gt;]</code>
   */
  boolean isCos();

  /**
   * Test if this expression is the function <code>Cosh[&lt;arg&gt;]</code>
   */
  boolean isCosh();

  /**
   * Test if this AST is a <code>Dataset</code> (i.e. instance of <code>IASTDataset</code>).
   *
   * @return
   */
  boolean isDataset();

  /**
   * Test if this expression is the function <code>Defer[&lt;arg&gt;]</code>
   */
  boolean isDefer();

  /**
   * <p>
   * Test if this expression is a <code>Derivative[number, ...][symbol][arg,...]</code> or
   * <code>Derivative[number][symbol]</code> expression and return the corresponding
   * <code>IAST</code> structures.
   * <ul>
   * <li>The expression at index <code>[0]</code> contains the <code>Derivative[number, ...]</code> AST part.</li>
   * <li>The expression at index <code>[1]</code> contains the <code>Derivative[...][symbol]</code> AST part.</li>
   * <li>The expression at index <code>[2]</code> contains the <code>Derivative[...][...][arg, ...]</code> AST part,
   * if available.</li>
   * </ul>
   * </p>
   * <p>
   * <b>Note:</b> the result at index <code>[2]</code> maybe <code>null</code> , if no argument is available.
   * </p>
   *
   * @return <code>null</code> if the expression is not a <code>Derivative[number, ...][symbol][arg,
   * ...]</code> or
   * <code>Derivative[number, ...][symbol]</code> expression.
   */
  IAST[] isDerivative();

  /**
   * <p>
   * Test if this expression is a <code>Derivative[number][symbol][arg]</code> or
   * <code>Derivative[number][symbol]</code> expression with one argument and return the
   * corresponding
   * <code>IAST</code> structures.
   * <ul>
   * <li>The expression at index <code>[0]</code> contains the <code>Derivative[number,...]</code> AST part.</li>
   * <li>The expression at index <code>[1]</code> contains the <code>Derivative[...][symbol]</code> AST part.</li>
   * <li>The expression at index <code>[2]</code> contains the <code>Derivative[...][...][arg]</code> AST part, if
   * available.</li>
   * </ul>
   * </p>
   * <p>
   * <b>Note:</b> the result at index <code>[2]</code> maybe <code>null</code> , if no argument is available.
   * </p>
   *
   * @return <code>null</code> if the expression is not a <code>Derivative[number][symbol][arg]</code>
   * or
   * <code>Derivative[number][symbol]</code> expression.
   */
  IAST[] isDerivativeAST1();

  /**
   * Test if this expression is representing a DirectedInfinity (i.e.
   * <code>Infinity->DirectedInfinity[1]</code>,
   * <code>-Infinity->DirectedInfinity[-1]</code>, <code>ComplexInfinity->DirectedInfinity[]</code>)
   */
  boolean isDirectedInfinity();

  /**
   * Test if this expression is representing a DirectedInfinity (i.e.
   * <code>Infinity->DirectedInfinity[1]</code>,
   * <code>-Infinity->DirectedInfinity[-1]</code>, <code>ComplexInfinity->DirectedInfinity[]</code>)
   *
   * @param x
   */
  boolean isDirectedInfinity(IExpr x);

  /**
   * Test if this expression is a discrete distribution AST (i.e. BinomialDistribution(),
   * PoissonDistribution(),...)
   *
   * @return
   */
  boolean isDiscreteDistribution();

  /**
   * Test if this expression is a distribution AST (i.e. NormalDistribution(),
   * PoissonDistribution(),...)
   *
   * @return
   */
  boolean isDistribution();

  /**
   * Test if this expression equals <code>E</code> (base of the natural logarithm; approximately
   * equal to 2.71828...) in symbolic or numeric mode.
   * <p>
   * <br>
   * See <a href="http://en.wikipedia.org/wiki/E_%28mathematical_constant%29">e (mathematical
   * constant)</a>
   */
  boolean isE();

  /**
   * Test if this expression is the function <code>Equal[&lt;arg1&gt;, &lt;arg2&gt;]</code>
   */
  boolean isEqual();

  /**
   * Check if this expression is an even integer result otherwise return false.
   *
   * @return <code>true</code> if this is an even integer result.
   */
  boolean isEvenResult();

  /**
   * Test if this expression is an exact number. I.e. an instance of type <code>IRational</code> or
   * <code>IComplex</code>.
   */
  boolean isExactNumber();

  /**
   * Test if this expression is the <code>Except</code> function <code>Except[&lt;pattern1&gt;]</code>
   * or
   * <code>Except[&lt;pattern1&gt;, &lt;pattern2&gt;]</code>
   */
  boolean isExcept();

  /**
   * Test if this expression is the <code>OptionsPattern</code> function
   * <code>OptionsPattern()</code> or
   * <code>OptionsPattern(&lt;symbol&gt;)</code>
   *
   * @return
   */
  boolean isOptionsPattern();

  /**
   * Test if this expression is already expanded i.e. <code>Plus, Times, Power</code> expression is
   * expanded.
   */
  boolean isExpanded();

  /**
   * Test if this expression equals the symbol "False"
   */
  boolean isFalse();

  boolean isFalseValue();

  /**
   * Are the given evaluation flags disabled for this list ?
   *
   * @param flags
   * @return
   * @see IAST#NO_FLAG
   */
  boolean isEvalFlagOff(int flags);

  /**
   * Are the given evaluation flags enabled for this list ?
   *
   * @param flags
   * @return
   * @see IAST#NO_FLAG
   */
  boolean isEvalFlagOn(int flags);

  /**
   * Test if this expression is an AST list, which contains a <b>header element</b> (i.e. a function
   * symbol like for example <code>Dot, Plus or Times</code>) with attribute <code>Flat</code> at
   * index position <code>0</code> and some optional <b>argument elements</b> at the index
   * positions
   * <code>1..(size()-1)</code>. Examples for
   * <code>Flat</code> functions are <code>Dot[], Plus[] or Times[]</code>. Therefore this
   * expression is no <b>atomic expression</b>.
   *
   * @see #isAtom()
   */
  boolean isFlatAST();

  /**
   * Test if this expression is a fractional number, but no integer number.
   */
  boolean isFraction();

  /**
   * Returns <code>true</code>, if <b>all of the elements</b> in the subexpressions or the
   * expression itself, did not match the given pattern. Calls <code>isFree(pattern, true)</code>.
   *
   * @param pattern a pattern-matching expression
   */
  boolean isFree(IExpr pattern);

  /**
   * Returns <code>true</code>, if <b>all of the elements</b> in the subexpressions or the
   * expression itself, did not match the given pattern.
   *
   * @param pattern a pattern-matching expression
   * @param heads if set to <code>false</code>, only the arguments of an IAST should be tested and
   * not the
   * <code>Head[]</code> element.
   */
  boolean isFree(IExpr pattern, boolean heads);

  /**
   * Returns <code>true</code>, if <b>all of the elements</b> in the subexpressions or the
   * expression itself, did not satisfy the given unary predicate.
   *
   * @param predicate a unary predicate
   * @param heads if set to <code>false</code>, only the arguments of an IAST should be tested
   * and not the
   * <code>Head[]</code> element.
   */
  boolean isFree(Predicate<IExpr> predicate, boolean heads);

  /**
   * Returns <code>true</code>, if <b>all of the elements</b> in the subexpressions or the
   * expression itself, aren't ASTs with a head which match the given pattern.
   *
   * @param pattern a pattern-matching expression
   */
  boolean isFreeAST(IExpr pattern);

  /**
   * Returns <code>true</code>, if <b>all of the elements</b> in the subexpressions or the
   * expression itself, aren't ASTs with a head which match the given predicate.
   *
   * @param predicate a unary predicate
   */
  boolean isFreeAST(Predicate<IExpr> predicate);

  /**
   * Returns <code>true</code>, if <b>all of the elements</b> in the subexpressions or the
   * expression itself, are no pattern objects.
   *
   * @return <code>true</code> if the expression contains no <code>IPatternObject</code>.
   */
  boolean isFreeOfPatterns();

  /**
   * Test if this expression is a <code>Function( arg1 )</code> expression with at least 1
   * argument.
   */
  boolean isFunction();

  /**
   * Compares this expression with the specified expression for order. Returns true if this
   * expression is canonical greater than or equal to the specified expression (&lt;= relation).
   *
   * @param expr an expression to compare with
   * @return true if this expression is canonical greater than or equal to the specified expression.
   */
  boolean isGEOrdered(IExpr expr);

  /**
   * Compares this expression with the specified expression for order. Returns true if this
   * expression is canonical greater than the specified expression (&lt; relation).
   *
   * @param expr an expression to compare with
   * @return true if this expression is canonical greater than the specified expression.
   */
  boolean isGTOrdered(IExpr expr);

  /**
   * Test if this expression is th symbol <code>Hold</code> or <code>HoldForm</code>
   */
  boolean isHoldOrHoldFormOrDefer();

  /**
   * Test if this expression is the <code>HoldPattern</code> function
   * <code>HoldPattern[&lt;expression&gt;]</code> or the deprecated <code>Literal[&lt;expression&gt;]</code>
   * form.
   *
   * @return
   */
  boolean isHoldPatternOrLiteral();

  /**
   * Test if this expression is representing <code>I</code>.
   */
  boolean isImaginaryUnit();

  /**
   * Test if this expression is representing <code>Indeterminate</code>
   */
  boolean isIndeterminate();


  /**
   * Test if this expression is an inexact number. I.e. an instance of type <code>INum</code> or
   * <code>IComplexNum</code>.
   */
  boolean isInexactNumber();

  /**
   * Test if this expression is representing <code>Infinity</code> (i.e.
   * <code>Infinity->DirectedInfinity[1]</code>)
   */
  boolean isInfinity();

  /**
   * Test if this expression is a integer number
   */
  boolean isInteger();


  /**
   * Test if this expression is a integer function (i.e. a number, a symbolic constant or an integer
   * function where all arguments are also &quot;integer functions&quot;)
   *
   * @return <code>true</code>, if the given expression is a integer function or value.
   * @see #isRealResult()
   */
  boolean isIntegerResult();

  /**
   * Test if this expression is an interval expression with one or more <code>List[min, max]</code>
   * arguments
   * <code>Interval[{min1, max1}, {min2, max2}, ...]</code> which represent the union of the
   * interval ranges.
   */
  boolean isInterval();

  /**
   * Test if this expression is an interval expression with one <code>List[min, max]</code>
   * argument
   * <code>Interval[{min, max}]</code>
   */
  boolean isInterval1();

  /**
   * Compares this expression with the specified expression for order. Returns true if this
   * expression is canonical less than or equal to the specified expression (&lt;= relation).
   *
   * @param expr an expression to compare with
   * @return true if this expression is canonical less than or equal to the specified expression.
   */
  boolean isLEOrdered(IExpr expr);

  /**
   * Test if this expression is a list (i.e. an AST with head List)
   */
  boolean isList();/*{
    return false;
  }*/

  boolean isList(Predicate<IExpr> pred); /*{
    return false;
  }*/


  /**
   * Test if this expression is a list (i.e. an AST with head List) with exactly 2 arguments
   *
   * @return
   */
  boolean isList1(); /*{
    return isList() && size() == 2;
  }*/

  /**
   * Test if this expression is a list (i.e. an AST with head List) with exactly 2 arguments
   *
   * @return
   */
  boolean isList2();

  /**
   * Test if this expression is a list (i.e. an AST with head List) with exactly 2 arguments
   *
   * @return
   */
  boolean isList3();

  /**
   * Test if this expression is a list of DirectedEdge or UndirectedEdge
   *
   * @return
   */
  GraphType isListOfEdges();

  /**
   * Test if this expression is a list of lists
   *
   * @see #isList()
   * @see #isMatrix(boolean)
   * @see #isVector()
   */
  boolean isListOfLists();


  /**
   * Test if this expression is an DirectedEdge, UndirectedEdge, Rule, TwoWayRule.
   *
   * @return
   */
  boolean isEdge();

  /**
   * Test if this expression is an empty list (i.e. a list <code>{}</code>)
   *
   * @return
   */
  boolean isEmptyList();

  /**
   * Test if this expression is a list of matrices
   *
   * @return
   */
  boolean isListOfMatrices();

  /**
   * Test if this expression is a list of rules (head Rule or RuleDelayed)
   *
   * @see #isList()
   * @see #isMatrix(boolean)
   * @see #isVector()
   */
  boolean isListOfRules();

  /**
   * Test if this expression is a list of rules (head Rule or RuleDelayed)
   *
   * @param ignoreEmptyList if <code>true</code>, ignore elements which equals an empty list <code>{
   * }</code>
   * @return
   * @see #isList()
   * @see #isMatrix(boolean)
   * @see #isVector()
   */
  boolean isListOfRules(boolean ignoreEmptyList);

  boolean isListOfRulesOrAssociation(boolean ignoreEmptyList);


  /**
   * Test if this expression is a list (i.e. an AST with head List) or an Association
   *
   * @return
   */
  boolean isListOrAssociation(); /*{
    return isList();
  }*/

  /**
   * Test if this expression is a list with at least one element (i.e. a list <code>{element,
   * ...}</code>)
   *
   * @return
   */
  boolean isNonEmptyList();

  /**
   * Test if this expression is the function <code>Log[&lt;arg&gt;]</code>
   */
  boolean isLog();

  /**
   * Compares this expression with the specified expression for order. Returns true if this
   * expression is canonical less than the specified expression (&lt; relation).
   *
   * @param expr an expression to compare with
   * @return true if this expression is canonical less than the specified expression.
   */
  boolean isLTOrdered(IExpr expr);

  /**
   * Test if this expression is a machine-precision (Java double type) real or complex number. I.e.
   * an instance of type <code>Num</code> or <code>ComplexNum</code>.
   */
  boolean isMachineNumber();

  /**
   * Test if this expression is a matrix and return the dimensions as array [row-dimension,
   * column-dimension]. This expression is only a matrix, if it is a <code>ASTRealMatrix</code> or
   * a
   * <code>List(...)</code> where all elements are lists with the header <code>List</code> and have
   * the same size.
   *
   * @return <code>null</code> if the expression is not a matrix
   */
  int[] isMatrix();

  /**
   * Test if this expression is a matrix and return the dimensions as array [row-dimension,
   * column-dimension]. This expression is only a matrix, if it is a <code>ASTRealMatrix</code> or
   * a
   * <code>List(...)</code> where all elements are lists with the header <code>List</code> and have
   * the same size.
   *
   * @param setMatrixFormat set the <code>IAST.IS_MATRIX</code> flag for formatting as a matrix.
   * @return <code>null</code> if the expression is not a matrix
   */
  int[] isMatrix(boolean setMatrixFormat);

  /**
   * Test if this expression is a matrix and return the dimensions as array [row-dimension,
   * column-dimension]. This expression is a matrix, if it is a <code>ASTRealMatrix</code> or a
   * <code>List(...)</code> where elements which could not be converted to a row vector are
   * ignored.
   *
   * @return <code>null</code> if the expression is not a matrix
   */
  int[] isMatrixIgnore();

  /**
   * Returns <code>true</code>, if <b>at least one of the elements</b> in the subexpressions, match
   * the given pattern. By default <code>isMember()</code> only operates at level 1.
   *
   * @param pattern a pattern-matching expression
   * @return
   */
  boolean isMember(IExpr pattern, boolean heads);

  /**
   * Returns <code>true</code>, if <b>at least one of the elements</b> in the subexpressions or the
   * expression itself, satisfy the given unary predicate.
   *
   * @param predicate a unary predicate
   * @param heads if set to <code>false</code>, only the arguments of an IAST should be tested
   * and not the
   * <code>Head[]</code> element.
   * @return
   */
  boolean isMember(Predicate<IExpr> predicate, boolean heads);

  /**
   * Returns <code>true</code>, if <b>at least one of the elements</b> in the subexpressions, match
   * the given pattern. If <code>visitor==null</code> the <code>isMember()</code> method only
   * operates at level 1.
   *
   * @param pattern a pattern-matching expression
   * @param heads if set to <code>false</code>, only the arguments of an IAST should be tested and
   * not the
   * <code>Head[]</code> element.
   * @param visitor if <code>null</code> use <code>VisitorBooleanLevelSpecification(predicate, 1,
   * heads)</code>
   * @return
   */
  boolean isMember(IExpr pattern, boolean heads, IVisitorBoolean visitor);

  /**
   * Test if this expression equals <code>-1</code> in symbolic or numeric mode.
   */
  boolean isMinusOne();

  /**
   * Test if this expression is the Module function <code>Module[&lt;arg1&gt;, &lt;arg2&gt;]</code>
   */
  boolean isModule();


  boolean isModuleOrWithCondition();

  /**
   * Test if this object is a negative signed number. For an <code>IAST</code> object the method
   * checks, if it is a numeric constant. If the <code>IAST</code> object evaluates to a negative
   * numeric expression this method returns
   * <code>true</code>.
   *
   * @return <code>true</code>, if <code>this < 0</code>; <code>false</code> in all other case.
   */
  boolean isNegative();

  /**
   * Test if this expression is representing <code>-I</code>.
   */
  boolean isNegativeImaginaryUnit();

  /**
   * Test if this expression is representing <code>-Infinity</code> (i.e.
   * <code>-Infinity->DirectedInfinity[-1]</code>)
   */
  boolean isNegativeInfinity();

  /**
   * Test if this expression has a negative result (i.e. less than 0) or is assumed to be negative.
   *
   * @return <code>true</code>, if the given expression is a negative function or value.
   * @see #isRealResult()
   */
  boolean isNegativeResult();

  /**
   * Check if the expression is a negative signed expression. This method is used in output forms
   * of
   * <code>Plus[...]</code> expressions.
   * <p>
   * param expr the expression which should be analyzed for a negative sign
   *
   * @return <code>true</code> if the expression is a negative signed expression
   */
  boolean isNegativeSigned();

  /**
   * Test if this expression has a non-negative result (i.e. greater equal 0) or is assumed to be
   * non-negative.
   *
   * @return <code>true</code>, if the given expression is a non-negative function or value.
   * @see #isRealResult()
   */
  boolean isNonNegativeResult();

  /**
   * Test if this expression unequals <code>0</code> and is a numeric complex value or is assumed to
   * be a negative or positive value.
   */
  boolean isNonZeroComplexResult();

  /**
   * Test if this expression unequals <code>0</code> and is a numeric real value or is assumed to be
   * a negative or positive value.
   */
  boolean isNonZeroRealResult();

  /**
   * Test if this expression is the function <code>Not[&lt;arg&gt;]</code>
   */
  boolean isNot();

  boolean isNotDefined();

  /**
   * Test if this expression is a number. I.e. an instance of type <code>INumber</code>.
   */
  boolean isNumber();

  /**
   * Check if this expression equals an <code>IInteger</code> value. The value of an
   * <code>INum</code> or the value of an <code>IInteger</code> object can be equal to
   * <code>value</code>.
   */
  boolean isNumEqualInteger(IInteger value) throws ArithmeticException;

  /**
   * Check if this expression equals an <code>IRational</code> value. The value of an
   * <code>IInteger</code>,
   * <code>IFraction</code> or the value of an <code>INum</code> object can be equal to
   * <code>value</code>.
   *
   * @see #isRational()
   */
  boolean isNumEqualRational(IRational value) throws ArithmeticException;

  /**
   * Test if this expression is a numeric number (i.e. an instance of type <code>INum</code> or
   * type
   * <code>IComplexNum</code>.
   */
  boolean isNumeric();

  /**
   * Test if this expression is an instance of NumericArrayExpr
   *
   * @return
   */
  boolean isNumericArray(); /*{
    return false;
  }*/

  /**
   * Test if this expression is a numeric number (i.e. an instance of type <code>INum</code> or
   * type
   * <code>IComplexNum</code>), an <code>ASTRealVector</code> or an <code>ASTRealMatrix</code>.
   */
  boolean isNumericArgument();

  /**
   * Test if this expression is a numeric function (i.e. a number, a symbolic constant or a function
   * (with attribute NumericFunction) where all arguments are also &quot;numeric functions&quot;)
   *
   * @return <code>true</code>, if the given expression is a numeric function or value.
   * @see #isRealResult()
   */
  boolean isNumericFunction(); /*{
        return isNumericFunction(false);
  }*/

  /**
   * Test if this expression is a numeric function (i.e. a number, a symbolic constant or a function
   * (with attribute NumericFunction) where all arguments are also &quot;numeric functions&quot;)
   *
   * @param allowList if <code>true</code> a <code>List(...)</code> AST is seen, as if it has
   * attribute {@link ISymbol#NUMERICFUNCTION}
   * @return <code>true</code>, if the given expression is a numeric function or value.
   * @see #isRealResult()
   */
  boolean isNumericFunction(boolean allowList);/*{
    return isNumber() || isConstantAttribute();
  }*/

  /**
   * Test if this expression is a numeric function (i.e. a number, a symbolic constant or a function
   * (with attribute NumericFunction) where all arguments are also &quot;numeric functions&quot;)
   * under the assumption, that all variables contained in <code>varSet</code> are also numeric.
   *
   * @return <code>true</code>, if the given expression is a numeric function or value, assuming all
   * variables contained in <code>varSet</code> are also numeric.
   */
  boolean isNumericFunction(VariablesSet varSet);

  /**
   * Test if this expression is a numeric function (i.e. a number, a symbolic constant or a function
   * (with attribute NumericFunction) where all arguments are also &quot;numeric functions&quot;)
   * under the assumption, that all variables contained in <code>list</code> are also numeric.
   *
   * @param list a list of variable symbols
   * @return
   */
  boolean isNumericFunction(Function<IExpr, String> list); /* {
    return isNumericFunction(true) || list.apply(this) != null;
  }*/

  /**
   * Test if this expression contains a numeric number (i.e. of type <code>INum</code> or <code>
   * IComplexNum</code>.
   *
   * @return <code>true</code>, if the given expression contains numeric number (i.e. of type <code>
   * INum</code> or <code>IComplexNum</code>.
   * @see #isRealResult()
   */
  boolean isNumericMode();

  /**
   * Check if this expression represents an <code>int</code> value. The value of an
   * <code>INum</code> object can be an
   * <code>int</code> value.
   */
  boolean isNumIntValue();

  /**
   * Test if this expression equals <code>1</code> in symbolic or numeric mode.
   */
  boolean isOne();

  /**
   * {@inheritDoc}
   *
   * @deprecated use {@link #isOne()} instead.
   */
  @Deprecated
  @Override
  boolean isONE();


  /**
   * Additional multiply method which works like <code>times()</code> to fulfill groovy's method
   * signature
   *
   * @see IExpr#times(IExpr)
   */
  @Override
  IExpr multiply(final IExpr that);

  /**
   * Returns an <code>IExpr</code> whose value is <code>(this / that)</code>. Calculates
   * <code>F.eval(F.Times(this, F.Power(that, F.CN1)))</code> in the common case and uses a
   * specialized implementation for derived number classes.
   */
  @Override
  IExpr divide(IExpr that);

  IExpr remainder(IExpr that);

  /**
   * Returns the multiplicative inverse of this object. It is the object such as
   * <code>this.times(this.inverse()) == ONE </code>, with <code>ONE</code> being the
   * multiplicative identity. Calculates <code>F.eval(F.Power(this, F.CN1))</code> in the common
   * case and uses a specialized implmentation for derived number classes.
   *
   * @return <code>ONE / this</code>.
   */
  @Override
  IExpr inverse();

  /**
   * Returns an <code>IExpr</code> whose value is <code>(this ^ n)</code>. Calculates
   * <code>F.eval(F.Power(this, that))</code> in the common case and uses a specialized
   * implementation for derived number classes.
   *
   * @param n the exponent
   * @return <code>(this ^ n)</code>
   */
  @Override
  IExpr power(final long n);

  /**
   * Test if this expression is an AST list, which contains a <b>header element</b> (i.e. a function
   * symbol like for example <code>Plus or Times</code>) with attribute <code>OneIdentity</code> at
   * index position <code>0</code> and exactly <b>one argument</b> at the index position
   * <code>1</code>. Examples for <code>OneIdentity</code> functions are <code>Plus[] or
   * Times[]</code>. Therefore this expression is no <b>atomic expression</b>.
   *
   * @see #isAtom()
   */
  boolean isOneIdentityAST1();

  /**
   * Test if this expression is the <code>Optional</code> function <code>Optional[&lt;pattern&gt;]</code>
   * or
   * <code>Optional[&lt;pattern&gt;, &lt;value&gt;]</code>
   *
   * @return
   */
  boolean isOptional();

  /**
   * Test if this expression is the function <code>Or[&lt;arg&gt;,...]</code>
   */
  boolean isOr();

  /**
   * Test if this expression is an AST list, which contains a <b>header element</b> (i.e. a function
   * symbol like for example <code>Plus or Times</code>) with attribute <code>Orderless</code> at
   * index position <code>0</code> and some optional <b>argument elements</b> at the index
   * positions
   * <code>1..n</code>. Examples for
   * <code>Orderless</code> functions are <code>Plus[] or Times[]</code>. Therefore this expression
   * is no <b>atomic expression</b>.
   *
   * @see #isAtom()
   */
  boolean isOrderlessAST();

  /**
   * Test if this expression is a <code>Pattern[symbol]</code> object
   */
  boolean isPattern();

  /**
   * Return <code>true</code>, if the expression is a pattern object with an associated  value (for
   * example
   * <code>0</code> is the  value for the addition expression <code>x_+y_.</code>)
   */
  boolean isPatternDefault();

  /**
   * Test if this expression or a subexpression is a pattern object. Used in pattern-matching;
   * checks flags in
   * <code>IAST</code> with flag <code>IAST.CONTAINS_PATTERN_EXPR</code>.
   */
  boolean isPatternExpr();

  /**
   * Return <code>true</code>, if the expression is a pattern object with an associated optional
   * value (for example
   * <code>value</code> is the  value for the expression <code>f[x_, y_:value]</code>)
   */
  boolean isPatternOptional();

  /**
   * Test if this expression is a pattern sequence object
   */
  boolean isPatternSequence(boolean testNullSequence);

  /**
   * Test if this expression is the <code>Except</code> function <code>Except[&lt;pattern1&gt;]</code>
   * or
   * <code>Except[&lt;pattern1&gt;, &lt;pattern2&gt;]</code>
   */
  boolean isPatternTest();

  /**
   * Test if this expression equals <code>Pi</code> (the ratio of a circle's circumference to its
   * diameter, approx. 3.141592...) in symbolic or numeric mode.
   * <p>
   * <br>
   * See <a href="http://en.wikipedia.org/wiki/Pi">Pi</a>
   */
  boolean isPi();

  /**
   * Test if this expression is a <code>Piecewise({{...}}},...)</code> function and the first
   * argument is a matrix with dimension <code>[row-dimension, 2]</code> and <code>row-dimension > 0
   * </code>. Return the dimensions of the matrix as array <code>[row-dimension, column-dimension]
   * </code>. The first argument is only a matrix, if it is a <code>List(...)</code> where all
   * elements are lists with the header <code>List</code> and have the same size.
   *
   * @return <code>null</code> if the expression is not a <code>Piecewise({{...}}},...)</code>
   * function or if the first argument is not a matrix
   */
  int[] isPiecewise();

  /**
   * Test if this expression is the addition function <code>Plus[&lt;arg1&gt;, &lt;arg2&gt;, ...]
   * </code> with at least 2 arguments.
   *
   * @return
   */
  boolean isPlus();

  /**
   * Test if this expression is the multiplication function <code>
   * Plus[&lt;arg1&gt;, &lt;arg2&gt;]</code> with exactly 2 arguments.
   *
   * @return
   */
  boolean isPlus2(); /*{
    return false;
  }*/

  /**
   * Test if this expression is the multiplication function <code>
   * Plus[&lt;arg1&gt;, &lt;arg2&gt;, &lt;arg3&gt;]</code> with exactly 3 arguments.
   *
   * @return
   */
  boolean isPlus3(); /*{
    return false;
  }*/

  /**
   * Test if this expression is a <code>Plus, Power or Times</code> function.
   *
   * @return
   */
  boolean isPlusTimesPower();

  /**
   * Test if this expression is a polynomial for the given list of <code>variables</code>.
   * <b>Note:</b> if the list contains no argument, this method returns <code>true</code> for a
   * <code>Symbol</code> expression.
   *
   * @param variables a list of variables or an empty list
   * @return <code>true</code> if this expression is a polynomial; <code>false</code>otherwise
   */
  boolean isPolynomial(IAST variables);

  /**
   * <p>
   * Test if this expression has a polynomial structiure, i.e. no built-in function as head
   * </p>
   *
   * @return <code>true</code> if this expression has a polynomial structure;
   * <code>false</code>otherwise
   */
  boolean isPolynomialStruct();

  /**
   * <p>
   * Test if this expression is a polynomial for the given <code>variable</code>.
   * </p>
   * <b>Note:</b> if the variable is set to <code>null</code>, this method returns
   * <code>true</code>
   * for a
   * <code>Symbol</code> expression.
   *
   * @param variable the variable of the polynomial
   */
  boolean isPolynomial(IExpr variable);

  /**
   * Test if this expression is a polynomial of <code>maxDegree</code> (i.e. the maximum exponent <=
   * maxDegree) for the given <code>variable</code>.
   *
   * @param variable the variable of the polynomial
   * @param maxDegree the maximum degree of the polynomial; maxDegree must be greater 0
   */
  boolean isPolynomialOfMaxDegree(ISymbol variable, long maxDegree);

  /**
   * Test if this object is a positive signed number. For an <code>IAST</code> object the method
   * checks, if it is a numeric constant. If the <code>IAST</code> object evaluates to a positive
   * numeric expression this method returns
   * <code>true</code>.
   *
   * @return <code>true</code>, if <code>this > 0</code>; <code>false</code> in all other case.
   */
  boolean isPositive();

  /**
   * Test if this expression has a positive result (i.e. greater than 0) or is assumed to be
   * positive.
   *
   * @return <code>true</code>, if the given expression is a positive function or value.
   * @see #isRealResult()
   */
  boolean isPositiveResult();

  /**
   * Test if this expression is the function <code>Power[&lt;arg1&gt;, &lt;arg2&gt;]</code>
   */
  boolean isPower();

  /**
   * Test if this expression is the function <code>Power[&lt;arg1&gt;, &lt;arg2&gt;]</code>
   *
   * @return
   */
  boolean isExp();

  /**
   * <p>
   * Test if this expression is the function <code>Power[&lt;arg1&gt;, -1]</code> (i.e.
   * <code>1 / &lt;arg1&gt;</code>).
   * </p>
   * <p>
   * See: <a href="https://en.wikipedia.org/wiki/Multiplicative_inverse">Wikipedia - Multiplicative
   * inverse</a>
   *
   * @return
   */
  boolean isPowerReciprocal();


  /**
   * Return {@code true} if this expression unequals <code>F.NIL</code>, otherwise {@code false}.
   * This method is similar to <code>java.util.Optional#isPresent()</code>.
   *
   * @return {@code true} if the expression unequals <code>F.NIL</code>, otherwise {@code false}.
   * @see java.util.Optional#isPresent()
   */
  boolean isPresent();

  /**
   * Test if this expression is a &quot;pure&quot; or &quot;anonymous&quot; <code>Function( arg1 )
   * </code> expression with exactly 1 argument.
   *
   * @return
   * @see #isFunction()
   */
  boolean isPureFunction(); /*{
    return false;
  }*/
  /**
   * Test if this expression is a Quantity(a,unit) expression.
   *
   * @return
   */
  boolean isQuantity();

  /**
   * Test if this expression is a rational number, i.e. integer or fraction number.
   *
   * @return
   * @see #isNumEqualRational(IRational)
   */
  boolean isRational();

  /**
   * Test if this expression is the <code>Repetead</code> function <code>Repetead(&lt;pattern1&gt;)</code>.
   *
   * @return
   */
  boolean isRepeated();

  /**
   * Test if this expression is a rational function (i.e. a number, a symbolic constant or an
   * rational function where all arguments are also &quot;rational functions&quot;)
   *
   * @return <code>true</code>, if the given expression is a rational function or value.
   * @see #isRealResult()
   */
  boolean isRationalResult();

  /**
   * Test if this expression equals the rational number <code>value</code> in symbolic or numeric
   * mode.
   *
   * @param value the rational number
   */
  boolean isRationalValue(IRational value);

  /**
   * Test if this expression is a signed number. I.e. an instance of type
   * <code>ISignedNumber</code>.
   */
  boolean isReal();

  /**
   * Test if this expression is a <code>IBuiltInSymbol</code> symbol and the evaluator implements
   * the
   * <code>ISignedNumberConstant</code> interface (see package <code>org.matheclipse.core.builtin.constant</code>).
   *
   * @return
   */
  boolean isRealConstant();

  /**
   * Test if this expression is a real matrix (i.e. an ASTRealMatrix) or a
   * <code>List[List[...],...,List[...]]</code> matrix with elements of type
   * <code>org.matheclipse.core.expression.Num</code>.
   */
  boolean isRealMatrix();

  /**
   * Test if this expression is a number with no imaginary component. I.e. an instance of type
   * <code>IRational</code> or <code>INum</code>.
   */
  boolean isRealNumber();

  /**
   * Test if this expression is a real function (i.e. a number, a symbolic constant or an integer
   * function where all arguments are also &quot;reals functions&quot;)
   *
   * @return <code>true</code>, if the given expression is a real function or value.
   * @see #isIntegerResult
   */
  boolean isRealResult();

  /**
   * Test if this expression is a real vector (i.e. an ASTRealVector) or a <code>List[...]</code>
   * with elements of type <code>org.matheclipse.core.expression.Num</code>.
   */
  boolean isRealVector();

  /**
   * Test if this expression is of the form <code>Rule[&lt;arg1&gt;, &lt;arg2&gt;]</code>.
   */
  boolean isRule();

  /**
   * Test if this expression is of the form <code>Rule[&lt;arg1&gt;, &lt;arg2&gt;]</code> or
   * <code>RuleDelayed[&lt;arg1&gt;, &lt;arg2&gt;]</code>.
   */
  boolean isRuleAST();

  /**
   * Test if this expression is of the form <code>RuleDelayed[&lt;arg1&gt;, &lt;arg2&gt;]</code>.
   */
  boolean isRuleDelayed();

  /**
   * Test if this expression equals the given expression. If the compared expressions are of the
   * same numeric type, they are equal to a given EPSILON
   *
   * @param expression
   */
  boolean isSame(IExpr expression);

  /**
   * Test if this expression equals the given expression. If the compared expressions are of the
   * same numeric type, they are equal to a given EPSILON
   */
  boolean isSame(IExpr expression, double epsilon);

  /**
   * Check if the object at index 0 (i.e. the head of the list) is the same object as
   * <code>head</code> and if the size of the list is greater or equal <code>length</code>.
   *
   * @param head object to compare with element at location <code>0</code>
   */
  boolean isSameHeadSizeGE(ISymbol head, int length);

  /**
   * Test if this expression is a sequence (i.e. an AST with head Sequence)
   */
  boolean isSequence();

  /**
   * Test if this expression is a signed real number. I.e. an instance of type
   * <code>IFraction</code> for exact number values or <code>INum</code> for approximated numbers.
   *
   * @deprecated use {@link #isReal()};
   */
  boolean isSignedNumber();

  /**
   * Test if this expression is a <code>IBuiltInSymbol</code> symbol and the evaluator implements
   * the
   * <code>ISignedNumberConstant</code> interface (see package <code>org.matheclipse.core.builtin.constant</code>).
   */
  boolean isSignedNumberConstant();

  /**
   * Test if this expression is the function <code>Sin[&lt;arg&gt;]</code>
   */
  boolean isSin();

  /**
   * Test if this expression is the function <code>Sinh[&lt;arg&gt;]</code>
   */
  boolean isSinh();

  /**
   * Test if this expression is the function <code>Slot[&lt;integer-value&gt;]</code> (i.e. #1, #2,
   * #3,....)
   */
  boolean isSlot();

  /**
   * Test if this expression is the function <code>SlotSequence[&lt;integer-value&gt;]</code>
   */
  boolean isSlotSequence();

  /**
   * Test if this expression is the function <code>Span[...]</code> with 2 or 3 arguments.
   *
   * @param size the size of an AST for which <code>Span[]</code> should be applied.
   * @return <code>null</code> if this is no <code>Span[...]</code> expression.
   */
  int[] isSpan(int size);

  /**
   * Test if this expression is a instance of SparseArrayExpr
   *
   * @return
   */
  boolean isSparseArray();

  /**
   * Test if this expression is the function <code>Power[&lt;arg1&gt;, 1/2]</code> (i.e.
   * <code>Sqrt[&lt;arg1&gt;]</code>).
   *
   * @return
   */
  boolean isSqrt();

  /**
   * Test if this expression is the function <code>Power[&lt;arg1&gt;, 1/2]</code> (i.e.
   * <code>Sqrt[&lt;arg1&gt;]</code>) or <code>-Power[&lt;arg1&gt;, 1/2]</code> (i.e.
   * <code>-Sqrt[&lt;arg1&gt;]</code>)
   *
   * @return
   */
  boolean isSqrtExpr();

  /**
   * Test if this expression is a string (instanceof IStringX)
   */
  boolean isString();

  /**
   * Test if this expression is the function <code>Subscript[var, &lt;integer-value&gt;]</code>.
   * <code>var</code> has to be a variable.
   *
   * @return
   */
  boolean isSubscript(); /*{
    return false;
  }*/

  /**
   * Test if this expression is a symbol (instanceof ISymbol)
   *
   * @return
   */
  boolean isString(String str);

  /**
   * Test if this expression is a symbol (instanceof ISymbol)
   */
  boolean isSymbol();

  /**
   * Test if this expression is a symbol (instanceof ISymbol) or a pattern object (instanceof
   * IPatternObject)
   *
   * @return
   */
  boolean isSymbolOrPattern();

  /**
   * Test if this expression is the function <code>TAn[&lt;arg&gt;]</code>
   */
  boolean isTan();

  /**
   * Test if this expression is the function <code>Tanh[&lt;arg&gt;]</code>
   *
   * @return
   */
  boolean isTanh();

  /**
   * Test if this expression is the multiplication function <code> Times[&lt;arg1&gt;, &lt;arg2&gt;,
   * ...]</code> with at least 2 arguments.
   *
   * @return
   */
  boolean isTimes();


  /**
   * Test if this expression is the multiplication function <code> Times[&lt;arg1&gt;,
   * &lt;arg2&gt;]</code> with exactly 2 arguments.
   *
   * @return
   */
  boolean isTimes2();/*{
    return false;
  }*/

  /**
   * Test if this expression is the multiplication function <code> Times[&lt;arg1&gt;, &lt;arg2&gt;,
   * &lt;arg3&gt;]</code> with exactly 3 arguments.
   *
   * @return
   */
  boolean isTimes3();/*{
    return false;
  }*/

  /**
   * Test if this expression is a trigonometric function.
   *
   * <p><b> Note</b>: ArcTan(x,y) can have 2 arguments and is considered as a trigonometric
   * function. All other detected function types have 1 argument.
   *
   * @return
   */
  boolean isTrigFunction();/*{
    return false;
  }*/

  /**
   * Test if this expression equals the symbol <code>True</code>.
   *
   * @return <code>true</code> if the expression equals symbol <code>True</code> and <code>false
   * </code> in all other cases
   */
  boolean isTrue();/*{
    return false;
  }*/

  /**
   * Test if this expression is the function <code>Unevaluated[&lt;arg&gt;]</code>
   *
   * @return
   */
  boolean isUnevaluated(); /* {
    return false;
  }*/

  /** {@inheritDoc} */
  @Override
  boolean isUnit();

  /**
   * Returns <code>true</code>, if this symbol or ast expression is bound to a value (i.e. the
   * evaluation returns an <i>assigned</i> value).
   *
   * @return
   */
  boolean isValue(); /*{
    return false;
  }*/

  /**
   * Test if this expression is a symbol which doesn't has attribute <code>Constant</code>.
   *
   * @return
   * @see #isConstantAttribute()
   * @see #isSymbol()
   */
  boolean isVariable(); /*{
    return false;
  }*/

  /**
   * Test if this expression is a vector and return the length of the vector. This expression is
   * only a vector, if the expression is a <code>ASTRealVector</code> or a <code>List(...)</code>
   * and no element is itself a <code>List(...)</code> or a <code>SparseArray(...)</code> of
   * dimension <code>1</code>;
   *
   * @return <code>-1</code> if the expression is no vector or <code>size()-1</code> of this vector
   * AST.
   */
  int isVector(); /*{
    // default: no vector
    return -1;
  }*/

  /**
   * Test if this expression is a hyperbolic function.
   *
   * @return
   */
  boolean isHyperbolicFunction();

  /**
   * Test if this expression is a special pattern-matching function (i.e. Alternatives, Except,...)
   *
   * @return
   */
  boolean isPatternMatchingFunction();


  boolean isTrueValue();


  /**
   * Test if this expression is an IAST and contains at least one numeric argument.
   *
   * @return
   */
  boolean isNumericAST();

  /**
   * Test if this expression is the With function <code>With[&lt;arg1&gt;, &lt;arg2&gt;]</code>
   *
   * @return
   */
  boolean isWith();

  /**
   * Test if this expression equals <code>0</code> in symbolic or numeric mode.
   */
  boolean isZero();

  /**
   * {@inheritDoc}
   *
   * @deprecated use {@link #isZero()} instead.
   */
  @Override
  boolean isZERO();

  /**
   * Signum functionality is used in JAS toString() method, don't use it as math signum function.
   *
   * @deprecated
   */
  @Deprecated
  @Override
  int signum();

  @Override
  IExpr sum(final IExpr that);

  @Override
  IExpr subtract(IExpr that);

  @Override
  IExpr abs();

  /**
   * Count the number of leaves of this expression.
   */
  long leafCount();

  /**
   * Count the number of leaves of this expression; for integer numbers in exact integer, fractional
   * and complex numbers count the digits of the integers. This function is used in
   * <code>Simplify</code> as the &quot;complexity function&quot;.
   */
  long leafCountSimplify();

  /**
   * Evaluate Less, if both arguments are real numbers
   *
   * @param a1
   */
  IExpr less(final IExpr a1);

  /**
   * Evaluate LessEqual, if both arguments are real numbers
   *
   * @param a1
   */
  IExpr lessEqual(final IExpr a1);

  /**
   * Compare if <code>this <= that</code:
   * <ul>
   * <li>return F.True if the comparison is <code>true</code></li>
   * <li>return F.False if the comparison is <code>false</code></li>
   * <li>return F.NIL if the comparison is undetermined (i.e. could not be evaluated)</li>
   * </ul>
   *
   * @return <code>F.True, F.False or F.NIL</code
   */
  IExpr lessEqualThan(IExpr that);

  /**
   * Compare if <code>this < that</code:
   * <ul>
   * <li>return F.True if the comparison is <code>true</code></li>
   * <li>return F.False if the comparison is <code>false</code></li>
   * <li>return F.NIL if the comparison is undetermined (i.e. could not be evaluated)</li>
   * </ul>
   *
   * @return <code>F.True, F.False or F.NIL</code
   */
  IExpr lessThan(IExpr that);

  /**
   * If this is a linear expression return the addedn at index 0 and the multiplicant at index 1
   *
   * @param variable th variable to check for linearity
   * @return <code>null</code> if this is not a linear expression
   */
  IExpr[] linear(IExpr variable);

  /**
   * If this is an expression of the form <code>a + b * x^n</code> with <code>n</code> integer,
   * return the addend at index <code>0</code> and the multiplicant at index <code>0</code> and the
   * exponent <code>n</code> at index
   * <code>2</code>.
   *
   * @param variable the variable <code>x</code> in the formula
   * @return <code>null</code> if this is not an expression of the form <code>a+b*x^n</code>
   */
  IExpr[] linearPower(IExpr variable);

  /**
   * If this is a <code>Interval[{lower, upper}]</code> expression return the <code>lower</code>
   * value. If this is a
   * <code>ISignedNumber</code> expression return <code>this</code>.
   *
   * @return <code>F.NIL</code> if this expression is no interval and no signed number.
   */
  IExpr lower();

  /**
   * Returns an <code>IExpr</code> whose value is <code>(this - that)</code>. Calculates
   * <code>F.eval(F.Plus(this, F.Times(F.CN1, that)))</code> in the common case and uses a
   * specialized implementation for derived number classes.
   */
  IExpr minus(final IExpr that);

  /**
   * <p>
   * This method assumes that <code>this</code> is a list of lists in matrix form. It combines the
   * column values in a list as argument for the given <code>function</code>.
   * </p>
   * <b>Example</b> a matrix <code>{{x1, y1,...}, {x2, y2, ...}, ...}</code> will be converted to
   * <code>{f.apply({x1, x2,...}), f.apply({y1, y2, ...}), ...}</code>
   *
   * @param dim the dimension of the matrix
   * @param f a unary function
   * @return
   */
  IExpr mapMatrixColumns(int[] dim, Function<IExpr, IExpr> f);

  /**
   * If a value is present (i.e. this unequals F.NIL), apply the provided mapping function to it,
   * and if the result is non-NIL, return the result. Otherwise return <code>F.NIL</code>
   *
   * @param mapper a mapping function to apply to the value, if present
   * @return an IExpr describing the result of applying a mapping function to the value of this
   * object, if a value is present, otherwise return <code>F.NIL</code>.
   */
  IExpr mapExpr(Function<? super IExpr, ? extends IExpr> mapper);

  IExpr mod(final IExpr that);

  /**
   * Multiply <code>this * that</code>. If oneof the arguments is a <code>Plus</code> expression,
   * distribute the other expression other <code>Plus</code>.
   *
   * @param that
   */
  IExpr multiplyDistributed(IExpr that); /*
  {
    if (isZero()) {
      return this;
    }
    if (that.isZero()) {
      return that;
    }
    if (isOne()) {
      return that;
    }
    if (that.isOne()) {
      return this;
    }
    if (isPlus()) {
      if (that.isPlus()) {
        IExpr temp = ((IAST) this).map(x -> x.multiplyDistributed(that), 1);
        return EvalEngine.get().evaluate(temp);
      }
      IExpr temp = ((IAST) this).mapThread(F.binaryAST2(S.Times, F.Slot1, that), 1);
      return EvalEngine.get().evaluate(temp);
    } else if (that.isPlus()) {
      IExpr temp = ((IAST) that).mapThread(F.binaryAST2(S.Times, this, F.Slot1), 2);
      return EvalEngine.get().evaluate(temp);
    }
    return times(that);
  }
  */

  /** {@inheritDoc} */
  @Override
  IExpr negate(); /*{
    return opposite();
  }*/

  /**
   * Additional negative method, which works like opposite to fulfill groovy's method signature
   *
   * @return
   * @see #opposite()
   */
  IExpr negative(); /*{
    return opposite();
  }*/

  /**
   * Converts a <b>special expression</b> (like a series, association, dataset, ...) into a standard
   * <i>normalized</i> expression.
   *
   * <pre>
   * &gt;&gt; Normal(SeriesData(x, 0, {1, 0, -1, -4, -17, -88, -549}, -1, 6, 1))
   * 1/x-x-4*x^2-17*x^3-88*x^4-549*x^5
   * </pre>
   *
   * @param nilIfUnevaluated if <code>true</code> return <code>F.NIL</code>, if no evaluation is
   * necessary, otherwise <code>this</code>.
   * @return the standard expression for <b>special expression</b> or <code>F.NIL</code> otherwise
   */
  IExpr normal(boolean nilIfUnevaluated); /*{
    return nilIfUnevaluated ? F.NIL : this;
  }*/

  /**
   * Returns an <code>IExpr</code> whose value is <code>(-1) * this</code>. Calculates <code>
   * F.eval(F.Times(F.CN1, this))</code> in the common case and uses a specialized implementation
   * for derived number classes.
   *
   * @return
   * @see #negative()
   */
  IExpr opposite();

  /**
   * The <code>ExprNull.NIL#optional()</code> method always returns <code>that</code>. All other
   * objects which implement this method returns <code>that</code> if <code>that!=null</code> or
   * <code>this</code> if
   * <code>that==null</code>
   *
   * @return <code>that</code> if <code>that!=null</code> or <code>this</code> in all other cases.
   * @see NILPointer#optional(IExpr)
   */
  IExpr optional();

  IExpr or(final IExpr that);

  /**
   * Return <code>this</code> if <code>this</code> unequals <code>F.NIL</code> , otherwise return
   * <code>other</code>.
   *
   * @return <code>this</code> if <code>this</code> unequals <code>F.NIL</code>, otherwise return
   * <code>other</code>.
   * @see java.util.Optional#orElse(Object)
   */
  IExpr orElse(final IExpr other);

  /**
   * Return <code>this</code> if <code>this</code> unequals <code>F.NIL</code> , otherwise invoke
   * {@code other} and return the result of that invocation.
   *
   * @param other a {@code Supplier} whose result is returned if no value is present
   * @return <code>this</code> if <code>this</code> unequals <code>F.NIL</code>, otherwise the
   * result of {@code other.get()}
   */
  IExpr orElseGet(Supplier<? extends IExpr> other);

  /**
   * Return <code>this</code> if <code>this</code> unequals <code>F.NIL</code> , otherwise throw an
   * exception to be created by the provided supplier.
   *
   * @param <X> Type of the exception to be thrown
   * @param exceptionSupplier The supplier which will return the exception to be thrown
   * @return <code>this</code> if <code>this</code> unequals <code>F.NIL</code> or throw an
   * exception
   * @throws X if there is no value present
   * @apiNote A method reference to the exception constructor with an empty argument list can be
   * used as the supplier. For example, {@code IllegalStateException::new}
   */
  <X extends Throwable> IExpr orElseThrow(Supplier<? extends X> exceptionSupplier) throws X;

  /**
   * Return <code>this</code> if <code>isList()==true</code>, otherwise create a new list
   * <code>{this}</code> from this (i.e. return <code>F.List(this)</code>).
   *
   * @return <code>this</code> if <code>isList()==true</code>, otherwise return
   * <code>F.List(this)</code>.
   */
  IAST orNewList();

  /**
   * <p>
   * Select all elements by applying the <code>predicate</code> to each argument in this
   * <code>AST</code> and append the arguments which satisfy the predicate to the <code>1st
   * element</code> of the resulting AST, or otherwise append it to the <code>2nd element</code> of
   * the resulting AST.
   * </p>
   * <p>
   * See: <a href= "https://people.eecs.berkeley.edu/~fateman/papers/partition.pdf">Fateman -
   * Partitioning of Algebraic Subexpressions in Computer Algebra Systems</a>
   * </p>
   *
   * @param operator the if the head of this expression equals <code>operator</code>, otherwise
   * return <code>F.NIL</code>.
   * @param predicate the predicate which filters each element in this AST
   * @param initTrue the result for the 1st result element, if the predicate doesn't give
   * <code>true</code> for any of the arguments in this AST.
   * @param initFalse the result for the 2nd result element, if the predicate doesn't give
   * <code>false</code> for any of the arguments in this AST.
   * @param combiner the 1st and 2md results element head
   * @return <code>F.NIL</code> if partitioning wasn't possible
   */
  IAST partition(ISymbol operator, Predicate<? super IExpr> predicate, IExpr initTrue,
      IExpr initFalse,
      ISymbol combiner, ISymbol action);

  /**
   * <p>
   * Select all elements by applying the <code>predicate</code> to each argument in this
   * <code>Plus(...)</code> expression and append the arguments which satisfy the predicate to the
   * <code>1st element</code> of the resulting AST, or otherwise append it to the <code>2nd
   * element</code> of the resulting AST.
   * </p>
   * <p>
   * See: <a href= "https://people.eecs.berkeley.edu/~fateman/papers/partition.pdf">Fateman -
   * Partitioning of Algebraic Subexpressions in Computer Algebra Systems</a>
   * </p>
   *
   * @param predicate the predicate which filters each element in this AST
   * @param initTrue the result for the 1st result element, if the predicate doesn't give
   * <code>true</code> for any of the arguments in this AST.
   * @param initFalse the result for the 2nd result element, if the predicate doesn't give
   * <code>false</code> for any of the arguments in this AST.
   * @return <code>F.NIL</code> if partitioning wasn't possible
   */
  IAST partitionPlus(Predicate<? super IExpr> predicate, IExpr initTrue, IExpr initFalse,
      ISymbol action);

  /**
   * <p>
   * Select all elements by applying the <code>predicate</code> to each argument in this
   * <code>Times(...)</code> expression and append the arguments which satisfy the predicate to the
   * <code>1st element</code> of the resulting AST, or otherwise append it to the <code>2nd
   * element</code> of the resulting AST.
   * </p>
   * <p>
   * See: <a href= "https://people.eecs.berkeley.edu/~fateman/papers/partition.pdf">Fateman -
   * Partitioning of Algebraic Subexpressions in Computer Algebra Systems</a>
   * </p>
   *
   * @param predicate the predicate which filters each element in this AST
   * @param initTrue the result for the 1st result element, if the predicate doesn't give
   * <code>true</code> for any of the arguments in this AST.
   * @param initFalse the result for the 2nd result element, if the predicate doesn't give
   * <code>false</code> for any of the arguments in this AST.
   * @return <code>F.NIL</code> if partitioning wasn't possible
   */
  IAST partitionTimes(Predicate<? super IExpr> predicate, IExpr initTrue, IExpr initFalse,
      ISymbol action);

  /**
   * Returns an <code>IExpr</code> whose value is <code>(this + that)</code>. Calculates
   * <code>F.eval(F.Plus(this, that))</code> in the common case and uses a specialized
   * implementation for derived number classes.
   */
  IExpr plus(final IExpr that);

  /**
   * Returns an <code>IExpr</code> whose value is <code>(this ^ that)</code>. Calculates
   * <code>F.eval(F.Power(this, that))</code> in the common case and uses a specialized
   * implementation for derived number classes.
   *
   * @return <code>(this ^ that)</code>
   */
  IExpr power(final IExpr that);

  /**
   * Return the real part of this expression if possible. Otherwise return <code>Re(this)</code>.
   *
   * @return real part
   */
  IExpr re();

  /**
   * Replace all (sub-) expressions with the given unary function, if the given predicate yields
   * <code>true</code>. If no substitution matches, the method returns <code>this</code>.
   *
   * @param predicate
   * @param function if the unary functions <code>apply()</code> method returns <code>F.NIL</code>
   * the expression isn't substituted.
   * @return <code>this</code> if no substitution of a (sub-)expression was possible.
   */
  @Nullable
  IExpr replace(final Predicate<IExpr> predicate, final Function<IExpr, IExpr> function);

  /**
   * Replace all (sub-) expressions with the given unary function. If no substitution matches, the
   * method returns
   * <code>F.NIL</code>.
   *
   * @param function if the unary functions <code>apply()</code> method returns <code>F.NIL</code>
   * the expression isn't substituted.
   * @return <code>F.NIL</code> if no substitution of a (sub-)expression was possible.
   */
  IExpr replaceAll(final Function<IExpr, IExpr> function);

  /**
   * Replace all (sub-) expressions with the given rule set. If no substitution matches, the method
   * returns
   * <code>F.NIL</code>.
   *
   * @param astRules rules of the form <code>x-&gt;y</code> or <code>{a-&gt;b, c-&gt;d}</code>; the
   * left-hand-side of the rule can contain pattern objects.
   * @return <code>F.NIL</code> if no substitution of a (sub-)expression was possible.
   */
  @Nullable
  IExpr replaceAll(final IAST astRules);


  /**
   * Replace all (sub-) expressions with the given <code>java.util.Map</code>n. If no substitution
   * matches, the method returns <code>F.NIL</code>.
   *
   * @param map if the unary functions <code>apply()</code> method returns <code>F.NIL</code> the
   * expression isn't substituted.
   * @return <code>F.NIL</code> if no substitution of a (sub-)expression was possible.
   */

  IExpr replaceAll(final Map<? extends IExpr, ? extends IExpr> map);


  IExpr replaceAll(VisitorReplaceAll visitor);

  /**
   * Replace all subexpressions with the given rule set. A rule must contain the position of the
   * subexpression which should be replaced on the left-hand-side. If no substitution matches, the
   * method returns <code>F.NIL</code>.
   *
   * @param astRules rules of the form <code>position-&gt;y</code> or <code>{position1-&gt;b,
   * position2-&gt;d}</code>
   * @return <code>F.NIL</code> if no substitution of a subexpression was possible.
   */
  IExpr replacePart(final IAST astRules);

  /**
   * Repeatedly replace all (sub-) expressions with the given unary function. If no substitution
   * matches, the method returns <code>this</code>.
   *
   * @param function if the unary functions <code>apply()</code> method returns <code>null</code>
   * the expression isn't substituted.
   * @return <code>this</code> if no substitution of a (sub-)expression was possible.
   */
  IExpr replaceRepeated(final Function<IExpr, IExpr> function);

  /**
   * Repeatedly replace all (sub-) expressions with the given rule set. If no substitution matches,
   * the method returns
   * <code>this</code>.
   *
   * @param astRules rules of the form <code>x-&gt;y</code> or <code>{a-&gt;b, c-&gt;d}</code>; the
   * left-hand-side of the rule can contain pattern objects.
   * @return <code>this</code> if no substitution of a (sub-)expression was possible.
   */
  IExpr replaceRepeated(final IAST astRules);

  /**
   * Repeatedly replace all (sub-) expressions with the given visitor. If no substitution matches,
   * the method returns <code>this</code>.
   *
   * @param visitor
   * @return
   */
  IExpr replaceRepeated(VisitorReplaceAll visitor); /*{
    IExpr result = this;
    IExpr temp = accept(visitor);
    EvalEngine engine = EvalEngine.get();
    final int iterationLimit = engine.getIterationLimit();
    int iterationCounter = 1;
    while (temp.isPresent()) {
      result = engine.evaluate(temp);
      temp = result.accept(visitor);
      if (iterationLimit >= 0 && iterationLimit <= ++iterationCounter) {
        IterationLimitExceeded.throwIt(iterationCounter, result);
      }
    }
    return result;
  }*/

  /**
   * <p>
   * Replace all occurrences of Slot[&lt;index&gt;] expressions with the expression at the
   * appropriate <code>index</code> in the given <code>slotsList</code>.
   *
   * <p><b>Note:</b> If a slot value is <code>null</code> the Slot will not be substituted.
   *
   * @param slotsList the values for the slots.
   * @return <code>null</code> if no substitution occurred.
   * @deprecated use org.matheclipse.core.eval.util.Lambda#replaceSlots() instead
   */
  @Deprecated
  IExpr replaceSlots(final IAST slotsList);

  /**
   * Get the rest of the elements of this <code>AST</code> list. Return <code>F.NIL</code> if this
   * object isn't an
   * <code>AST</code>.
   *
   * @return the rest arguments of the function represented by this <code>AST</code> with the first
   * argument removed.
   * @see IExpr#head()
   */
  IAST rest();

  IExpr rewrite(int functionID);

  /**
   * Get the second element of this <code>AST</code> list (i.e. get(2)). Return <code>F.NIL</code>
   * if this object isn't an <code>AST</code>.
   *
   * @return the second argument of the function represented by this <code>AST</code> or
   * <code>F.NIL</code> if this
   * object isn't an AST.
   */
  IExpr second();

  /**
   * Returns the <b>number of elements</b> in this {@code IAST}.The <b>number of elements</b>
   * equals
   * <code>argSize() + 1</code> (i.e. the <b>number of arguments</b> plus 1). If this is an atom
   * return size
   * <code>0</code>.
   *
   * @return the <b>number of elements</b> in this {@code IAST}.
   * @see #argSize()
   */
  int size();

  /**
   * Generate <code>Sqrt(this)</code>.
   *
   * @return <code>Sqrt(this)</code>
   */
  IExpr sqrt();

  /**
   * Returns an <code>IExpr</code> whose value is <code>(this * that)</code>. Calculates
   * <code>F.eval(F.Times(this, that))</code> in the common case and uses a specialized
   * implementation for derived number classes.
   *
   * @param that the multiplier expression
   * @return <code>(this * that)</code>
   */
  IExpr times(final IExpr that);

  /**
   * Returns an <code>IExpr</code> whose value is <code>(this * that)</code>. Calculates
   * <code>F.eval(F.Times(this, that))</code> in the common case and uses a specialized
   * implementation for derived number classes.
   *
   * @param that the multiplier expression
   * @return <code>(this * that)</code>
   */
  IExpr timesDistributed(final IExpr that);

//    Object toData();

  /**
   * Convert this object into a <code>double[]</code> matrix.
   *
   * @return <code>null</code> if this object can not be converted into a <code>double[]</code>
   * matrix
   */
  double[][] toDoubleMatrix();

  /**
   * Convert this object into a <code>double[]</code> matrix, if a row is not convertible to double
   * vector ignore the row.
   *
   * @return <code>null</code> if this object can not be converted into a <code>double[]</code>
   * matrix
   */
  double[][] toDoubleMatrixIgnore();

  /**
   * Convert this object into a <code>double[]</code> vector.
   *
   * @return <code>null</code> if this object can not be converted into a <code>double[]</code>
   * vector
   */
  double[] toDoubleVector();

  /**
   * Convert this object into a <code>double[]</code> vector, if an argument is not convertible to
   * double ignore the value.
   *
   * @return <code>null</code> if this object can not be converted into a <code>double[]</code>
   * vector
   */
  double[] toDoubleVectorIgnore();

  /**
   * Convert this object into a <code>Complex[]</code> vector.
   *
   * @return <code>null</code> if this object can not be converted into a <code>Complex[]</code>
   * vector
   */
  Complex[] toComplexVector();

  /**
   * Convert this object into a <code>int[]</code> vector.
   *
   * @return
   */
  int[] toIntVector();

  /**
   * Converts this number to an <code>int</code> value; unlike {link #intValue} this method returns
   * <code>Value</code> if the value of this integer isn't in the range
   * <code>Integer.MIN_VALUE</code> to
   * <code>Integer.MAX_VALUE</code> or the expression is not convertible to the int range.
   *
   * @param Value the  value, if this integer is not in the <code>int</code> range
   * @return the numeric value represented by this integer after conversion to type
   * <code>int</code>.
   */
  int toIntDefault(int Value);

  /**
   * Converts this number to an <code>int</code> value; unlike {@link #intValue} this method
   * returns
   * <code>Integer.MIN_VALUE</code> if the value of this integer isn't in the range
   * <code>Integer.MIN_VALUE</code> to
   * <code>Integer.MAX_VALUE</code> or the expression is not convertible to the <code>int</code>
   * range.
   *
   * @return the numeric value represented by this integer after conversion to type
   * <code>int</code>.
   */
  int toIntDefault();

  /**
   * The 'highest level' head of the expression, before Symbol, Integer, Real or String. for example
   * while the head of a[b][c] is a[b], the top head is a.
   *
   * @return the 'highest level' head of the expression.
   */
  ISymbol topHead();

  /**
   * Convert this object into a RealMatrix.
   *
   * @return <code>null</code> if this object can not be converted into a RealMatrix
   */
  RealMatrix toRealMatrix();

  /**
   * Convert this object into a RealMatrix.
   *
   * @return <code>null</code> if this object can not be converted into a RealMatrix
   */
  RealMatrix toRealMatrixIgnore();

  /**
   * Convert this object into a RealVector.
   *
   * @return <code>null</code> if this object can not be converted into a RealVector
   */
  RealVector toRealVector();


  /**
   * Return the <code>Mathematica()</code> form of this expression
   *
   * @return
   */
  String toMMA();/* {
       return  WolframFormFactory.get().toString(this);
  }*/

  @Override
  String toScript();/* {
    return toString();
  }*/

  @Override
  String toScriptFactory(); /*{
    throw new UnsupportedOperationException(toString());
  }*/

  /**
   * Compare if <code>this != that</code:
   * <ul>
   * <li>return S.True if the comparison is <code>true</code></li>
   * <li>return S.False if the comparison is <code>false</code></li>
   * <li>return F.NIL if the comparison is undetermined (i.e. could not be evaluated)</li>
   * </ul>
   *
   * @return <code>F.True, F.False or F.NIL</code
   */
  IExpr unequalTo(IExpr that);

  IExpr unitStep();

  /**
   * If this is a <code>Interval[{lower, upper}]</code> expression return the <code>upper</code>
   * value. If this is a <code>ISignedNumber</code> expression return <code>this</code>.
   *
   * @return <code>F.NIL</code> if this expression is no interval and no signed number.
   */
  IExpr upper();

  /**
   * Convert the variables (i.e. expressions of type <code>ISymbol</code> which aren't constants) in
   * this expression into Slot[] s.
   *
   * @param map for every given symbol argument return the associated unique slot from this map
   * @param variableCollector collects the variables which are used in the replacement process
   * @return <code>F.NIL</code> if no variable symbol was found.
   */
  IExpr variables2Slots(final Map<IExpr, IExpr> map, final Collection<IExpr> variableCollector);

  String toString();

}
