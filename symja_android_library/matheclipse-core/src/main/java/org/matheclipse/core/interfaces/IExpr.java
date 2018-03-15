package org.matheclipse.core.interfaces;

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
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.exception.WrongArgumentType;
import org.matheclipse.core.expression.NILPointer;
import org.matheclipse.core.visit.IVisitor;
import org.matheclipse.core.visit.IVisitorBoolean;
import org.matheclipse.core.visit.IVisitorInt;
import org.matheclipse.core.visit.IVisitorLong;
import org.matheclipse.core.visit.VisitorReplaceAll;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import edu.jas.structure.ElemFactory;
import edu.jas.structure.GcdRingElem;

/**
 * (I)nterface for a mathematical (Expr)ession<br />
 * <p>
 * <code>IExpr</code> is the main interface for the Symja object type hierarchy:
 * <p>
 * <pre>
 * java.lang.Object
 *    |--- java.util.AbstractCollection
 *    |       |--- java.util.AbstractList
 *    |               |--- org.matheclipse.core.expression.HMArrayList
 *    |                       |--- org.matheclipse.core.expression.AST - abstract syntax tree which represents lists, vectors, matrices and functions
 *    |                                           implements IAST, List, IExpr
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
public interface IExpr extends Comparable<IExpr>, GcdRingElem<IExpr>, Serializable, FieldElement<IExpr> {

    public final static int ASTID = 1024;
    public final static int BLANKID = 256;
    public final static int COMPLEXID = 32;
    public final static int DOUBLECOMPLEXID = 4;
    public final static int DOUBLEID = 2;
    public final static int FRACTIONID = 16;
    public final static int INTEGERID = 8;
    public final static int METHODSYMBOLID = 2048;
    public final static int PATTERNID = 512;
    public final static int STRINGID = 64;
    public final static int SYMBOLID = 128;


    /**
     * Operator overloading for Scala operator <code>/</code>. Calls <code>divide(that)</code>.
     *
     * @param that
     * @return
     */
    IExpr $div(final IExpr that);

    /**
     * Operator overloading for Scala operator <code>/</code>. Calls <code>divide(that)</code>.
     *
     * @param that
     * @return
     */
    IExpr $minus(final IExpr that);

    /**
     * Operator overloading for Scala operator <code>+</code>. Calls <code>plus(that)</code>.
     *
     * @param that
     * @return
     */
    IExpr $plus(final IExpr that);

    /**
     * Operator overloading for Scala operator <code>*</code>. Calls <code>times(that)</code>.
     *
     * @param that
     * @return
     */
    IExpr $times(final IExpr that);

    /**
     * Operator overloading for Scala operator <code>^</code>. Calls <code>power(that)</code>.
     *
     * @param that
     * @return
     */
    IExpr $up(final IExpr that);

    @Override
    IExpr abs();

    /**
     * Accept a visitor with return type T
     *
     * @param visitor
     * @return
     */
    public <T> T accept(IVisitor<T> visitor);

    /**
     * Accept a visitor with return type <code>boolean</code>
     *
     * @param visitor
     * @return
     */
    public boolean accept(IVisitorBoolean visitor);

    /**
     * Accept a visitor with return type <code>int</code>
     *
     * @param visitor
     * @return
     */
    public int accept(IVisitorInt visitor);

    /**
     * Accept a visitor with return type <code>long</code>
     *
     * @param visitor
     * @return
     */
    public long accept(IVisitorLong visitor);

    @Override
    IExpr add(IExpr that);

    IExpr and(final IExpr that);

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

    Object asType(Class<?> clazz);


    /**
     * Get the first element of this <code>Power(base, exponent)</code> expression.
     *
     * @return
     */
    public IExpr base();

    /**
     * Compares this expression with the specified expression for order. Returns a negative integer, zero, or a positive
     * integer as this expression is canonical less than, equal to, or greater than the specified expression.
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
     * Return <code>negate()</code> if <code>number.sign() < 0</code>, otherwise return <code>this</code>
     *
     * @param number
     * @return
     */
    IExpr copySign(ISignedNumber number);

    /**
     * Returns an <code>IExpr</code> whose value is <code>(this - 1)</code>. Calculates
     * <code>F.eval(F.Subtract(this, C1))</code> in the common case and uses a specialized implementation for derived
     * number classes.
     *
     * @return
     */
    IExpr dec();

    /**
     * Returns an <code>IExpr</code> whose value is <code>(this / that)</code>. Calculates
     * <code>F.eval(F.Times(this, F.Power(that, F.CN1)))</code> in the common case and uses a specialized implementation
     * for derived number classes.
     *
     * @param that
     * @return
     */
    @Override
    IExpr divide(IExpr that);


    IExpr[] egcd(IExpr b);

    /**
     * Calls <code>get(position).equals(expr)</code> if <code>this</code> is an <code>IAST</code>. Returns
     * <code>false</code> otherwise.
     *
     * @param position the position in the <code>IAST</code> which should be tested for equality
     * @param expr     the expression which should be tested for equality
     * @return
     */
    public boolean equalsAt(int position, final IExpr expr);

    /**
     * Compare if <code>this == that</code:
     * <ul>
     * <li>return F.True if the comparison is <code>true</code></li>
     * <li>return F.False if the comparison is <code>false</code></li>
     * <li>return F.NIL if the comparison is undetermined (i.e. could not be evaluated)</li>
     * </ul>
     *
     * @param that
     * @return <code>F.True, F.False or F.NIL</code
     */
    public IExpr equalTo(IExpr that);

    /**
     * Evaluate the expression to a <code>INumber</code> value.
     *
     * @return <code>null</code> if the conversion is not possible.
     */
    Complex evalComplex();

    /**
     * Evaluate the expression to a Java <code>double</code> value. If the conversion to a double value is not possible,
     * the method throws a <code>WrongArgumentType</code> exception.
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
    ISignedNumber evalSignedNumber();

    /**
     * Evaluate an expression
     *
     * @param engine the evaluation engine
     * @return the evaluated Object or <code>F.NIL</code> if the evaluation is not possible (i.e. the evaluation doesn't
     * change the object).
     */
    IExpr evaluate(EvalEngine engine);

    IExpr evaluateHead(IAST ast, EvalEngine engine);

    /**
     * Get the second element of this <code>Power(base, exponent)</code> expression.
     *
     * @return
     */
    public IExpr exponent();

    @Override
    ElemFactory<IExpr> factory();

    /**
     * Get the first element of this <code>AST</code> list (i.e. get(1)). Return <code>F.NIL</code> if this object isn't
     * an <code>AST</code>.
     *
     * @return the second argument of the function represented by this <code>AST</code> or <code>F.NIL</code> if this
     * object isn't an AST.
     */
    public IExpr first();

    /**
     * Get the last element of the <code>AST</code> list (i.e. get(size()-1). Return <code>F.NIL</code> if this object
     * isn't an <code>AST</code>.
     *
     * @return the last argument of the function represented by this <code>AST</code>.
     * @see IExpr#head()
     */
    public IExpr last();

    /**
     * Return the <code>FullForm()</code> of this expression
     *
     * @return
     */
    String fullFormString();


    IExpr gcd(IExpr that);

    /**
     * Get the element at the specified <code>index</code> if this object is of type <code>IAST</code>.
     *
     * @param index
     * @return
     */
    IExpr getAt(final int index);

    @Override
    public Field<IExpr> getField();

    /**
     * Evaluate Greater, if both arguments are real numbers
     *
     * @param a1
     * @return
     */
    IExpr greater(final IExpr a1);

    /**
     * Evaluate GreaterEqual, if both arguments are real numbers
     *
     * @param a1
     * @return
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
     * @param that
     * @return <code>F.True, F.False or F.NIL</code
     */
    public IExpr greaterEqualThan(IExpr that);

    /**
     * Compare if <code>this > that</code:
     * <ul>
     * <li>return F.True if the comparison is <code>true</code></li>
     * <li>return F.False if the comparison is <code>false</code></li>
     * <li>return F.NIL if the comparison is undetermined (i.e. could not be evaluated)</li>
     * </ul>
     *
     * @param that
     * @return <code>F.True, F.False or F.NIL</code
     */
    public IExpr greaterThan(IExpr that);

    /**
     * If this object is an instance of <code>IAST</code> get the first element (offset 0) of the <code>IAST</code> list
     * (i.e. get(0) ).
     *
     * @return the head of the expression, which must not be null.
     */
    public IExpr head();

    /**
     * A unique integer ID for the implementation of this expression
     *
     * @return a unique integer id for the implementation of this expression
     */
    public int hierarchy();

    /**
     * If this expression unequals <code>F.NIL</code>, invoke the specified consumer with the <code>this</code> object,
     * otherwise do nothing.
     *
     * @param consumer block to be executed if this expression unequals <code>F.NIL</code>
     * @see java.util.Optional#ifPresent(java.util.function.Consumer)
     */
    void ifPresent(Consumer<? super IExpr> consumer);

    /**
     * If a value is present, performs the given <code>consumer</code> with the value, otherwise performs the given
     * empty-based action.
     *
     * @param consumer    the action to be performed, if a value is present
     * @param emptyAction the empty-based action to be performed, if no value is present
     */
    void ifPresentOrElse​(Consumer<? super IExpr> consumer, Runnable emptyAction);

    /**
     * Return the imaginary part of this expression if possible. Otherwise return <code>Im(this)</code>.
     *
     * @return real part
     */
    public IExpr im();

    /**
     * Returns an <code>IExpr</code> whose value is <code>(this + 1)</code>. Calculates
     * <code>F.eval(F.Plus(this, C1))</code> in the common case and uses a specialized implementation for derived number
     * classes.
     *
     * @return
     */
    IExpr inc();

    /**
     * Return the internal Java form of this expression.
     *
     * @param symbolsAsFactoryMethod if <code>true</code> use the <code>F.symbol()</code> method, otherwise print the symbol name.
     * @param depth                  the recursion depth of this call. <code>0</code> indicates &quot;recurse without a limit&quot;.
     * @return the internal Java form of this expression
     */
    String internalFormString(boolean symbolsAsFactoryMethod, int depth);

    /**
     * Return the internal Java form of this expression.
     *
     * @param symbolsAsFactoryMethod if <code>true</code> use the <code>F.symbol()</code> method, otherwise print the symbol name.
     * @param depth                  the recursion depth of this call. <code>0</code> indicates &quot;recurse without a limit&quot;.
     * @param useOperators           use operators instead of function names for representation of Plus, Times, Power,...
     * @param usePrefix              use the <code>F....</code> class prefix for genrating Java code.
     * @return the internal Java form of this expression
     */
    String internalJavaString(boolean symbolsAsFactoryMethod, int depth, boolean useOperators,
                              boolean usePrefix);

    /**
     * Return the internal Scala form of this expression.
     *
     * @param symbolsAsFactoryMethod if <code>true</code> use the <code>F.symbol()</code> method, otherwise print the symbol name.
     * @param depth                  the recursion depth of this call. <code>0</code> indicates &quot;recurse without a limit&quot;.
     * @return the internal Scala form of this expression
     */
    String internalScalaString(boolean symbolsAsFactoryMethod, int depth);

    /**
     * Returns the multiplicative inverse of this object. It is the object such as
     * <code>this.times(this.inverse()) == ONE </code>, with <code>ONE</code> being the multiplicative identity.
     * Calculates <code>F.eval(F.Power(this, F.CN1))</code> in the common case and uses a specialized implmentation for
     * derived number classes.
     *
     * @return <code>ONE / this</code>.
     */
    @Override
    IExpr inverse();

    /**
     * Test if this expression is the function <code>Abs[&lt;arg&gt;]</code>
     *
     * @return
     */
    boolean isAbs();

    /**
     * Test if this expression and all subexpressions are already expanded i.e. all <code>Plus, Times, Power</code>
     * (sub-)expressions are expanded.
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
     *
     * @return
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
     *
     * @return
     */
    boolean isArcCosh();

    /**
     * Test if this expression is the function <code>ArcSin[&lt;arg&gt;]</code>
     *
     * @return
     */
    boolean isArcSin();

    /**
     * Test if this expression is the function <code>ArcSinh[&lt;arg&gt;]</code>
     *
     * @return
     */
    boolean isArcSinh();

    /**
     * Test if this expression is the function <code>ArcTan[&lt;arg&gt;]</code>
     *
     * @return
     */
    boolean isArcTan();

    /**
     * Test if this expression is the function <code>ArcTanh[&lt;arg&gt;]</code>
     *
     * @return
     */
    boolean isArcTanh();

    /**
     * Test if this expression is an AST list, which contains a <b>header element</b> (i.e. the function name) at index
     * position <code>0</code> and some optional <b>argument elements</b> at the index positions <code>1..n</code>.
     * Therefore this expression is no <b>atomic expression</b>.
     *
     * @return
     * @see #isAtom()
     */
    boolean isAST();

    /**
     * Test if this expression is an AST list, which contains the given <b>header element</b> at index position
     * <code>0</code> and some optional <b>argument elements</b> at the index positions <code>1..(size()-1)</code>.
     * Therefore this expression is not an <b>atomic expression</b>.
     *
     * @param header the header element at position 0, which should be tested
     * @return
     * @see #isAtom()
     */
    boolean isAST(IExpr header);

    /**
     * Test if this expression is an AST list, which contains the given <b>header element</b> at index position
     * <code>0</code> and optional <b>argument elements</b> at the index positions <code>1..(length-1)</code>. If this
     * test gives <code>true</code> this expression is not an <b>atomic expression</b>.
     *
     * @param header the header element at position 0, which should be tested
     * @param length the size the AST expression must have (<b>inclusive head element</b>)
     * @return
     * @see #isAtom()
     */
    boolean isAST(IExpr header, int length);

    /**
     * Test if this expression is an AST list, which contains the given <b>header element</b> at index position
     * <code>0</code> and optional <b>argument elements</b> at the index positions <code>1..(length-1)</code>. If this
     * test gives <code>true</code> this expression is not an <b>atomic expression</b>.
     *
     * @param header the header element at position 0, which should be tested
     * @param length the size the AST expression must have
     * @param args   the arguments of this AST which should be tested, if they are equal, a <code>null</code> value
     *               argument skips the equals check.
     * @return
     * @see #isAtom()
     */
    boolean isAST(IExpr header, int length, IExpr... args);

    /**
     * Test if this expression is an AST list, which contains the given <b>header element</b> at index position
     * <code>0</code> and optional <b>argument elements</b> at the index positions <code>1..(length-1)</code>. If this
     * test gives <code>true</code> this expression is not an <b>atomic expression</b>.
     *
     * @param header    the header element at position 0, which should be tested
     * @param minLength the minimum size the AST expression must have
     * @param maxLength the maximum size the AST expression must have
     * @return
     * @see #isAtom()
     */
    boolean isAST(IExpr header, int minLength, int maxLength);

    /**
     * <p>
     * Test if this expression is an AST list, where the string representation of the <b>header element</b> at index
     * position <code>0</code> equals the given <code>symbol</code> and some optional <b>argument elements</b> at the
     * index positions <code>1..(size()-1)</code>. If this test gives <code>true</code> this expression is not an
     * <b>atomic expression</b>.
     * </p>
     * <p>
     * Example: <code>isAST("Sin")</code> gives <code>true</code> for <code>Sin[Pi/2]</code>.
     * </p>
     * <p>
     * <b>Note:</b> this is a performance critical method, only use it in special cases like for example UI handling
     * etc.
     * </p>
     *
     * @param headerStr string representation of the <b>header element</b> at index position <code>0</code>
     * @return
     * @see #isAtom()
     */
    boolean isAST(String headerStr);

    /**
     * Test if this expression is an AST list, where the string representation of the <b>header element</b> at index
     * position <code>0</code> equals the given <code>symbol</code> and some optional <b>argument elements</b> at the
     * index positions <code>1..(length-1)</code>. Therefore this expression is no <b>atomic expression</b>. Example:
     * <code>isAST("Sin", 2)</code> gives <code>true</code> for <code>Sin[0]</code>.
     *
     * @param headerStr string representation of the <b>header element</b> at index position <code>0</code>
     * @param length    the size the AST expression must have
     * @return
     * @see #isAtom()
     */
    boolean isAST(String headerStr, int length);

    /**
     * Test if this expression is an AST list, which contains a <b>header element</b> (i.e. the function name) at index
     * position <code>0</code> and no <b>argument elements</b>. Therefore this expression is no <b>atomic
     * expression</b>.
     *
     * @return
     * @see #isAtom()
     */
    boolean isAST0();

    /**
     * Test if this expression is an AST list, which contains a <b>header element</b> (i.e. the function name) at index
     * position <code>0</code> and one <b>argument element</b> at the index position <code>1</code>. Therefore this
     * expression is no <b>atomic expression</b>.
     *
     * @return
     * @see #isAtom()
     */
    boolean isAST1();

    /**
     * Test if this expression is an AST list, which contains a <b>header element</b> (i.e. the function name) at index
     * position <code>0</code> and two <b>argument elements</b> at the index positions <code>1, 2</code>. Therefore this
     * expression is no <b>atomic expression</b>.
     *
     * @return
     * @see #isAtom()
     */
    boolean isAST2();

    /**
     * Test if this expression is an AST list, which contains a <b>header element</b> (i.e. the function name) at index
     * position <code>0</code> and three <b>argument elements</b> at the index positions <code>1, 2, 3</code>. Therefore
     * this expression is no <b>atomic expression</b>.
     *
     * @return
     * @see #isAtom()
     */
    boolean isAST3();

    /**
     * Test if this expression is an AST list, which contains the given <b>header element</b> at index position
     * <code>0</code> and optional <b>argument elements</b> at the index positions <code>1..n</code>. <code>n</code>
     * must be greater equal than the given <code>length</code>. Therefore this expression is no <b>atomic
     * expression</b>.
     *
     * @param header the header element at position 0, which should be tested
     * @param length the size the AST expression must have
     * @return
     * @see #isAtom()
     */
    boolean isASTSizeGE(IExpr header, int length);

    /**
     * Test if this expression is an atomic expression (i.e. no AST expression)
     *
     * @return
     */
    boolean isAtom();

    /**
     * Test if this expression is a <code>Blank[]</code> object
     *
     * @return
     */
    boolean isBlank();

    /**
     * Test if this expression is a symbol (instanceof IBuiltInSymbol)
     *
     * @return
     */
    boolean isBuiltInSymbol();

    /**
     * Test if this expression is a symbolic complex number (i.e. <code>instanceof IComplex</code>)
     *
     * @return
     */
    boolean isComplex();

    /**
     * Test if this expression is representing ComplexInfinity (i.e. DirectedInfinity[])
     *
     * @return
     */
    boolean isComplexInfinity();

    /**
     * Test if this expression is a numeric complex number (i.e. <code>instanceof IComplexNum</code>)
     *
     * @return
     */
    boolean isComplexNumeric();

    /**
     * Test if this expression is the Condition function <code>Condition[&lt;arg1&gt;, &lt;arg2&gt;]</code>
     *
     * @return
     */
    boolean isCondition();

    /**
     * Test if this expression is the function <code>Conjugate[&lt;arg&gt;]</code>
     *
     * @return
     */
    boolean isConjugate();

    /**
     * Test if this expression is a symbol with attribute <code>Constant</code>. Therefore numbers return
     * <code>false</code> for this method!
     *
     * @return
     * @see #isRealResult()
     * @see #isNumericFunction()
     */
    boolean isConstant();

    /**
     * Test if this expression is a <code>IBuiltInSymbol</code> symbol and the evaluator implements
     * <code>ICoreFunctionEvaluator</code> (see package <code>org.matheclipse.core.builtin.function</code>).
     *
     * @return
     */
    boolean isCoreFunctionSymbol();

    /**
     * Test if this expression is the function <code>Cos[&lt;arg&gt;]</code>
     *
     * @return
     */
    boolean isCos();

    /**
     * Test if this expression is the function <code>Cosh[&lt;arg&gt;]</code>
     *
     * @return
     */
    boolean isCosh();

    /**
     * Test if this expression is the function <code>Defer[&lt;arg&gt;]</code>
     *
     * @return
     */
    boolean isDefer();

    /**
     * <p>
     * Test if this expression is a <code>Derivative[number, ...][symbol][arg,...]</code> or
     * <code>Derivative[number][symbol]</code> expression and return the corresponding <code>IAST</code> structures.
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
     * @return <code>null</code> if the expression is not a <code>Derivative[number, ...][symbol][arg, ...]</code> or
     * <code>Derivative[number, ...][symbol]</code> expression.
     */
    IAST[] isDerivative();

    /**
     * <p>
     * Test if this expression is a <code>Derivative[number][symbol][arg]</code> or
     * <code>Derivative[number][symbol]</code> expression with one argument and return the corresponding
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
     * @return <code>null</code> if the expression is not a <code>Derivative[number][symbol][arg]</code> or
     * <code>Derivative[number][symbol]</code> expression.
     */
    IAST[] isDerivativeAST1();

    /**
     * Test if this expression is representing a DirectedInfinity (i.e. <code>Infinity->DirectedInfinity[1]</code>,
     * <code>-Infinity->DirectedInfinity[-1]</code>, <code>ComplexInfinity->DirectedInfinity[]</code>)
     *
     * @return
     */
    boolean isDirectedInfinity();

    /**
     * Test if this expression is representing a DirectedInfinity (i.e. <code>Infinity->DirectedInfinity[1]</code>,
     * <code>-Infinity->DirectedInfinity[-1]</code>, <code>ComplexInfinity->DirectedInfinity[]</code>)
     *
     * @param x
     * @return
     */
    boolean isDirectedInfinity(IExpr x);

    /**
     * Test if this expression equals <code>E</code> (base of the natural logarithm; approximately equal to 2.71828...)
     * in symbolic or numeric mode.
     * <p>
     * <br>
     * See <a href="http://en.wikipedia.org/wiki/E_%28mathematical_constant%29">e (mathematical constant)</a>
     *
     * @return
     */
    boolean isE();

    /**
     * Test if this expression is the function <code>Equal[&lt;arg1&gt;, &lt;arg2&gt;]</code>
     *
     * @return
     */
    boolean isEqual();

    /**
     * Test if this expression is an exact number. I.e. an instance of type <code>IRational</code> or
     * <code>IComplex</code>.
     *
     * @return
     */
    boolean isExactNumber();

    /**
     * Test if this expression is the <code>Except</code> function <code>Except[&lt;pattern1&gt;]</code> or
     * <code>Except[&lt;pattern1&gt;, &lt;pattern2&gt;]</code>
     *
     * @return
     */
    boolean isExcept();

    /**
     * Test if this expression is already expanded i.e. <code>Plus, Times, Power</code> expression is expanded.
     *
     * @return
     */
    boolean isExpanded();

    /**
     * Test if this expression equals the symbol "False"
     *
     * @return
     */
    boolean isFalse();

    /**
     * Test if this expression is an AST list, which contains a <b>header element</b> (i.e. a function symbol like for
     * example <code>Dot, Plus or Times</code>) with attribute <code>Flat</code> at index position <code>0</code> and
     * some optional <b>argument elements</b> at the index positions <code>1..(size()-1)</code>. Examples for
     * <code>Flat</code> functions are <code>Dot[], Plus[] or Times[]</code>. Therefore this expression is no <b>atomic
     * expression</b>.
     *
     * @return
     * @see #isAtom()
     */
    boolean isFlatAST();

    /**
     * Test if this expression is a fractional number, but no integer number.
     *
     * @return
     */
    boolean isFraction();

    /**
     * Returns <code>true</code>, if <b>all of the elements</b> in the subexpressions or the expression itself, did not
     * match the given pattern. Calls <code>isFree(pattern, true)</code>.
     *
     * @param pattern a pattern-matching expression
     * @return
     */
    boolean isFree(IExpr pattern);

    /**
     * Returns <code>true</code>, if <b>all of the elements</b> in the subexpressions or the expression itself, did not
     * match the given pattern.
     *
     * @param pattern a pattern-matching expression
     * @param heads   if set to <code>false</code>, only the arguments of an IAST should be tested and not the
     *                <code>Head[]</code> element.
     * @return
     */
    boolean isFree(IExpr pattern, boolean heads);

    /**
     * Returns <code>true</code>, if <b>all of the elements</b> in the subexpressions or the expression itself, did not
     * satisfy the given unary predicate.
     *
     * @param predicate a unary predicate
     * @param heads     if set to <code>false</code>, only the arguments of an IAST should be tested and not the
     *                  <code>Head[]</code> element.
     * @return
     */
    boolean isFree(Predicate<IExpr> predicate, boolean heads);

    /**
     * Returns <code>true</code>, if <b>all of the elements</b> in the subexpressions or the expression itself, aren't
     * ASTs with a head which match the given pattern.
     *
     * @param pattern a pattern-matching expression
     * @return
     */
    boolean isFreeAST(IExpr pattern);

    /**
     * Returns <code>true</code>, if <b>all of the elements</b> in the subexpressions or the expression itself, aren't
     * ASTs with a head which match the given predicate.
     *
     * @param predicate a unary predicate
     * @return
     */
    boolean isFreeAST(Predicate<IExpr> predicate);

    /**
     * Returns <code>true</code>, if <b>all of the elements</b> in the subexpressions or the expression itself, are no
     * pattern objects.
     *
     * @return <code>true</code> if the expression contains no <code>IPatternObject</code>.
     */
    boolean isFreeOfPatterns();

    /**
     * Test if this expression is a <code>Function( arg1 )</code> expression with at least 1 argument.
     *
     * @return
     */
    boolean isFunction();

    /**
     * Compares this expression with the specified expression for order. Returns true if this expression is canonical
     * greater than or equal to the specified expression (&lt;= relation).
     *
     * @param expr an expression to compare with
     * @return true if this expression is canonical greater than or equal to the specified expression.
     */
    boolean isGEOrdered(IExpr expr);

    /**
     * Compares this expression with the specified expression for order. Returns true if this expression is canonical
     * greater than the specified expression (&lt; relation).
     *
     * @param expr an expression to compare with
     * @return true if this expression is canonical greater than the specified expression.
     */
    boolean isGTOrdered(IExpr expr);

    /**
     * Test if this expression is th symbol <code>Hold</code> or <code>HoldForm</code>
     *
     * @return
     */
    boolean isHoldOrHoldFormOrDefer();

    /**
     * Test if this expression is representing <code>I</code>.
     *
     * @return
     */
    boolean isImaginaryUnit();

    /**
     * Test if this expression is representing <code>Indeterminate</code>
     *
     * @return
     */
    boolean isIndeterminate();

    /**
     * Test if this expression is an inexact number. I.e. an instance of type <code>INum</code> or
     * <code>IComplexNum</code>.
     *
     * @return
     */
    boolean isInexactNumber();

    /**
     * Test if this expression is representing <code>Infinity</code> (i.e. <code>Infinity->DirectedInfinity[1]</code>)
     *
     * @return
     */
    boolean isInfinity();

    /**
     * Test if this expression is a integer number
     *
     * @return
     */
    boolean isInteger();

    /**
     * Test if this expression is a integer function (i.e. a number, a symbolic constant or an integer function where
     * all arguments are also &quot;integer functions&quot;)
     *
     * @return <code>true</code>, if the given expression is a integer function or value.
     * @see #isRealResult()
     */
    boolean isIntegerResult();

    /**
     * Test if this expression is an interval expression with one or more <code>List[min, max]</code> arguments
     * <code>Interval[{min1, max1}, {min2, max2}, ...]</code> which represent the union of the interval ranges.
     *
     * @return
     */
    boolean isInterval();

    /**
     * Test if this expression is an interval expression with one <code>List[min, max]</code> argument
     * <code>Interval[{min, max}]</code>
     *
     * @return
     */
    boolean isInterval1();

    /**
     * Compares this expression with the specified expression for order. Returns true if this expression is canonical
     * less than or equal to the specified expression (&lt;= relation).
     *
     * @param expr an expression to compare with
     * @return true if this expression is canonical less than or equal to the specified expression.
     */
    boolean isLEOrdered(IExpr expr);

    /**
     * Test if this expression is a list (i.e. an AST with head List)
     *
     * @return
     */
    boolean isList();

    /**
     * Test if this expression is a list of lists
     *
     * @return
     * @see #isList()
     * @see #isMatrix(boolean)
     * @see #isVector()
     */
    boolean isListOfLists();

    /**
     * Test if this expression is the function <code>Log[&lt;arg&gt;]</code>
     *
     * @return
     */
    boolean isLog();

    /**
     * Compares this expression with the specified expression for order. Returns true if this expression is canonical
     * less than the specified expression (&lt; relation).
     *
     * @param expr an expression to compare with
     * @return true if this expression is canonical less than the specified expression.
     */
    boolean isLTOrdered(IExpr expr);

    /**
     * Test if this expression is a machine-precision (Java double type) real or complex number. I.e. an instance of
     * type <code>Num</code> or <code>ComplexNum</code>.
     *
     * @return
     */
    boolean isMachineNumber();

    /**
     * Test if this expression is a matrix and return the dimensions as array [row-dimension, column-dimension]. This
     * expression is only a matrix, if it is a <code>ASTRealMatrix</code> or a <code>List(...)</code> where all elements
     * are lists with the header <code>List</code> and have the same size.
     *
     * @return <code>null</code> if the expression is not a matrix
     */
    int[] isMatrix();

    /**
     * Test if this expression is a matrix and return the dimensions as array [row-dimension, column-dimension]. This
     * expression is only a matrix, if it is a <code>ASTRealMatrix</code> or a <code>List(...)</code> where all elements
     * are lists with the header <code>List</code> and have the same size.
     *
     * @param setMatrixFormat set the <code>IAST.IS_MATRIX</code> flag for formatting as a matrix.
     * @return <code>null</code> if the expression is not a matrix
     */
    int[] isMatrix(boolean setMatrixFormat);

    /**
     * Returns <code>true</code>, if <b>at least one of the elements</b> in the subexpressions or the expression itself,
     * match the given pattern.
     *
     * @param pattern a pattern-matching expression
     * @param heads   if set to <code>false</code>, only the arguments of an IAST should be tested and not the
     *                <code>Head[]</code> element.
     * @return
     */
    boolean isMember(IExpr pattern, boolean heads);

    /**
     * Returns <code>true</code>, if <b>at least one of the elements</b> in the subexpressions or the expression itself,
     * satisfy the given unary predicate.
     *
     * @param predicate a unary predicate
     * @param heads     if set to <code>false</code>, only the arguments of an IAST should be tested and not the
     *                  <code>Head[]</code> element.
     * @return
     */
    boolean isMember(Predicate<IExpr> predicate, boolean heads);

    /**
     * Test if this expression equals <code>-1</code> in symbolic or numeric mode.
     *
     * @return
     */
    boolean isMinusOne();

    /**
     * Test if this expression is the Module function <code>Module[&lt;arg1&gt;, &lt;arg2&gt;]</code>
     *
     * @return
     */
    boolean isModuleOrWith();

    boolean isModuleOrWithCondition();

    /**
     * Test if this object is a negative signed number. For an <code>IAST</code> object the method checks, if it is a
     * numeric constant. If the <code>IAST</code> object evaluates to a negative numeric expression this method returns
     * <code>true</code>.
     *
     * @return <code>true</code>, if <code>this < 0</code>; <code>false</code> in all other case.
     */
    boolean isNegative();

    /**
     * Test if this expression is representing <code>-I</code>.
     *
     * @return
     */
    boolean isNegativeImaginaryUnit();

    /**
     * Test if this expression is representing <code>-Infinity</code> (i.e.
     * <code>-Infinity->DirectedInfinity[-1]</code>)
     *
     * @return
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
     * Check if the expression is a negative signed expression. This method is used in output forms of
     * <code>Plus[...]</code> expressions.
     * <p>
     * param expr the expression which should be analyzed for a negative sign
     *
     * @return <code>true</code> if the expression is a negative signed expression
     */
    boolean isNegativeSigned();

    /**
     * Test if this expression has a non-negative result (i.e. greater equal 0) or is assumed to be non-negative.
     *
     * @return <code>true</code>, if the given expression is a non-negative function or value.
     * @see #isRealResult()
     */
    boolean isNonNegativeResult();

    /**
     * Test if this expression unequals <code>0</code> and is a numeric complex value or is assumed to be a negative or
     * positive value.
     *
     * @return
     */
    boolean isNonZeroComplexResult();

    /**
     * Test if this expression unequals <code>0</code> and is a numeric real value or is assumed to be a negative or
     * positive value.
     *
     * @return
     */
    boolean isNonZeroRealResult();

    /**
     * Test if this expression is the function <code>Not[&lt;arg&gt;]</code>
     *
     * @return
     */
    boolean isNot();

    /**
     * Test if this expression is a number. I.e. an instance of type <code>INumber</code>.
     *
     * @return
     */
    boolean isNumber();

    /**
     * Check if this expression equals an <code>IInteger</code> value. The value of an <code>INum</code> or the value of
     * an <code>IInteger</code> object can be equal to <code>value</code>.
     *
     * @param value
     * @return
     * @throws ArithmeticException
     */
    boolean isNumEqualInteger(IInteger value) throws ArithmeticException;

    /**
     * Check if this expression equals an <code>IRational</code> value. The value of an <code>IInteger</code>,
     * <code>IFraction</code> or the value of an <code>INum</code> object can be equal to <code>value</code>.
     *
     * @param value
     * @return
     * @throws ArithmeticException
     * @see #isRational()
     */
    boolean isNumEqualRational(IRational value) throws ArithmeticException;

    /**
     * Test if this expression is a numeric number (i.e. an instance of type <code>INum</code> or type
     * <code>IComplexNum</code>.
     *
     * @return
     */
    boolean isNumeric();

    /**
     * Test if this expression is a numeric number (i.e. an instance of type <code>INum</code> or type
     * <code>IComplexNum</code>), an <code>ASTRealVector</code> or an <code>ASTRealMatrix</code>.
     *
     * @return
     */
    boolean isNumericArgument();

    /**
     * Test if this expression is a numeric function (i.e. a number, a symbolic constant or a function (with attribute
     * NumericFunction) where all arguments are also &quot;numeric functions&quot;)
     *
     * @return <code>true</code>, if the given expression is a numeric function or value.
     * @see #isRealResult()
     */
    boolean isNumericFunction();

    /**
     * Test if this expression contains a numeric number (i.e. of type <code>INum</code> or <code>IComplexNum</code>.
     *
     * @return <code>true</code>, if the given expression contains numeric number (i.e. of type <code>INum</code> or
     * <code>IComplexNum</code>.
     * @see #isRealResult()
     */
    boolean isNumericMode();

    /**
     * Check if this expression represents an <code>int</code> value. The value of an <code>INum</code> object can be an
     * <code>int</code> value.
     *
     * @return
     */
    boolean isNumIntValue();

    /**
     * Test if this expression equals <code>1</code> in symbolic or numeric mode.
     *
     * @return
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
     * Test if this expression is an AST list, which contains a <b>header element</b> (i.e. a function symbol like for
     * example <code>Plus or Times</code>) with attribute <code>OneIdentity</code> at index position <code>0</code> and
     * exactly <b>one argument</b> at the index position <code>1</code>. Examples for <code>OneIdentity</code> functions
     * are <code>Plus[] or Times[]</code>. Therefore this expression is no <b>atomic expression</b>.
     *
     * @return
     * @see #isAtom()
     */
    boolean isOneIdentityAST1();

    /**
     * Test if this expression is the function <code>Or[&lt;arg&gt;,...]</code>
     *
     * @return
     */
    boolean isOr();

    /**
     * Test if this expression is an AST list, which contains a <b>header element</b> (i.e. a function symbol like for
     * example <code>Plus or Times</code>) with attribute <code>Orderless</code> at index position <code>0</code> and
     * some optional <b>argument elements</b> at the index positions <code>1..n</code>. Examples for
     * <code>Orderless</code> functions are <code>Plus[] or Times[]</code>. Therefore this expression is no <b>atomic
     * expression</b>.
     *
     * @return
     * @see #isAtom()
     */
    boolean isOrderlessAST();

    /**
     * Test if this expression is a <code>Pattern[symbol]</code> object
     *
     * @return
     */
    boolean isPattern();

    /**
     * Return <code>true</code>, if the expression is a pattern object with an associated  value (for example
     * <code>0</code> is the  value for the addition expression <code>x_+y_.</code>)
     *
     * @return
     */
    boolean isPatternDefault();

    /**
     * Test if this expression or a subexpression is a pattern object. Used in pattern-matching; checks flags in
     * <code>IAST</code> with flag <code>IAST.CONTAINS_PATTERN_EXPR</code>.
     *
     * @return
     */
    boolean isPatternExpr();

    /**
     * Return <code>true</code>, if the expression is a pattern object with an associated optional value (for example
     * <code>value</code> is the  value for the expression <code>f[x_, y_:value]</code>)
     *
     * @return
     */
    boolean isPatternOptional();

    /**
     * Test if this expression is a pattern sequence object
     *
     * @return
     */
    boolean isPatternSequence();

    /**
     * Test if this expression is the <code>Except</code> function <code>Except[&lt;pattern1&gt;]</code> or
     * <code>Except[&lt;pattern1&gt;, &lt;pattern2&gt;]</code>
     *
     * @return
     */
    boolean isPatternTest();

    /**
     * Test if this expression equals <code>Pi</code> (the ratio of a circle's circumference to its diameter, approx.
     * 3.141592...) in symbolic or numeric mode.
     * <p>
     * <br>
     * See <a href="http://en.wikipedia.org/wiki/Pi">Pi</a>
     *
     * @return
     */
    boolean isPi();

    /**
     * Test if this expression is the addition function <code>Plus[&lt;arg1&gt;, &lt;arg2&gt;, ...]</code> with at least
     * 2 arguments.
     *
     * @return
     */
    boolean isPlus();

    /**
     * Test if this expression is a <code>Plus, Power or Times</code> function.
     *
     * @return
     */
    boolean isPlusTimesPower();

    /**
     * <p>
     * Test if this expression is a polynomial for the given list of <code>variables</code>.
     * </p>
     * <b>Note:</b> if the list contains no argument, this method returns <code>true</code> for a <code>Symbol</code>
     * expression.
     *
     * @param variables a list of variables or an empty list
     * @return <code>true</code> if this expression is a polynomial; <code>false</code>otherwise
     */
    boolean isPolynomial(IAST variables);

    /**
     * <p>
     * Test if this expression is a polynomial for the given <code>variable</code>.
     * </p>
     * <b>Note:</b> if the variable is set to <code>null</code>, this method returns <code>true</code> for a
     * <code>Symbol</code> expression.
     *
     * @param variable the variable of the polynomial
     * @return
     */
    boolean isPolynomial(@Nullable IExpr variable);

    /**
     * Test if this expression is a polynomial of <code>maxDegree</code> (i.e. the maximum exponent <= maxDegree) for
     * the given <code>variable</code>.
     *
     * @param variable  the variable of the polynomial
     * @param maxDegree the maximum degree of the polynomial; maxDegree must be greater 0
     * @return
     */
    boolean isPolynomialOfMaxDegree(ISymbol variable, long maxDegree);

    /**
     * Test if this object is a positive signed number. For an <code>IAST</code> object the method checks, if it is a
     * numeric constant. If the <code>IAST</code> object evaluates to a positive numeric expression this method returns
     * <code>true</code>.
     *
     * @return <code>true</code>, if <code>this > 0</code>; <code>false</code> in all other case.
     */
    boolean isPositive();

    /**
     * Test if this expression has a positive result (i.e. greater than 0) or is assumed to be positive.
     *
     * @return <code>true</code>, if the given expression is a positive function or value.
     * @see #isRealResult()
     */
    boolean isPositiveResult();

    /**
     * Test if this expression is the function <code>Power[&lt;arg1&gt;, &lt;arg2&gt;]</code>
     *
     * @return
     */
    boolean isPower();

    /**
     * Return {@code true} if this expression unequals <code>F.NIL</code>, otherwise {@code false}. This method is
     * similar to <code>java.util.Optional#isPresent()</code>.
     *
     * @return {@code true} if the expression unequals <code>F.NIL</code>, otherwise {@code false}.
     * @see java.util.Optional#isPresent()
     */
    boolean isPresent();

    /**
     * Test if this expression is a rational number, i.e. integer or fraction number.
     *
     * @return
     * @see #isNumEqualRational(IRational)
     */
    boolean isRational();

    /**
     * Test if this expression is a rational function (i.e. a number, a symbolic constant or an rational function where
     * all arguments are also &quot;rational functions&quot;)
     *
     * @return <code>true</code>, if the given expression is a rational function or value.
     * @see #isRealResult()
     */
    boolean isRationalResult();

    /**
     * Test if this expression equals the rational number <code>value</code> in symbolic or numeric mode.
     *
     * @param value the rational number
     * @return
     */
    boolean isRationalValue(IRational value);

    /**
     * Test if this expression is a real matrix (i.e. an ASTRealMatrix) or a <code>List[List[...],...,List[...]]</code>
     * matrix with elements of type <code>org.matheclipse.core.expression.Num</code>.
     *
     * @return
     */
    boolean isRealMatrix();

    /**
     * Test if this expression is a number with no imaginary component. I.e. an instance of type <code>IRational</code>
     * or <code>INum</code>.
     *
     * @return
     */
    boolean isRealNumber();

    /**
     * Test if this expression is a real function (i.e. a number, a symbolic constant or an integer function where all
     * arguments are also &quot;reals functions&quot;)
     *
     * @return <code>true</code>, if the given expression is a real function or value.
     * @see #isIntegerResult
     */
    boolean isRealResult();

    /**
     * Test if this expression is a real vector (i.e. an ASTRealVector) or a <code>List[...]</code> with elements of
     * type <code>org.matheclipse.core.expression.Num</code>.
     *
     * @return
     */
    boolean isRealVector();

    /**
     * Test if this expression is of the form <code>Rule[&lt;arg1&gt;, &lt;arg2&gt;]</code>.
     *
     * @return
     */
    boolean isRule();

    /**
     * Test if this expression is of the form <code>Rule[&lt;arg1&gt;, &lt;arg2&gt;]</code> or
     * <code>RuleDelayed[&lt;arg1&gt;, &lt;arg2&gt;]</code>.
     *
     * @return
     */
    boolean isRuleAST();

    /**
     * Test if this expression is of the form <code>RuleDelayed[&lt;arg1&gt;, &lt;arg2&gt;]</code>.
     *
     * @return
     */
    boolean isRuleDelayed();

    /**
     * Test if this expression equals the given expression. If the compared expressions are of the same numeric type,
     * they are equal to a given EPSILON
     *
     * @param expression
     * @return
     */
    boolean isSame(IExpr expression);

    /**
     * Test if this expression equals the given expression. If the compared expressions are of the same numeric type,
     * they are equal to a given EPSILON
     *
     * @param expression
     * @param epsilon
     * @return
     */
    boolean isSame(IExpr expression, double epsilon);

    /**
     * Check if the object at index 0 (i.e. the head of the list) is the same object as <code>head</code> and if the
     * size of the list is greater or equal <code>length</code>.
     *
     * @param head   object to compare with element at location <code>0</code>
     * @param length
     * @return
     */
    boolean isSameHeadSizeGE(IExpr head, int length);

    /**
     * Test if this expression is a sequence (i.e. an AST with head Sequence)
     *
     * @return
     */
    boolean isSequence();

    /**
     * Test if this expression is a signed number. I.e. an instance of type <code>ISignedNumber</code>.
     *
     * @return
     */
    boolean isSignedNumber();

    /**
     * Test if this expression is a <code>IBuiltInSymbol</code> symbol and the evaluator implements the
     * <code>ISignedNumberConstant</code> interface (see package <code>org.matheclipse.core.builtin.constant</code>).
     *
     * @return
     */
    boolean isSignedNumberConstant();

    /**
     * Test if this expression is the function <code>Sin[&lt;arg&gt;]</code>
     *
     * @return
     */
    boolean isSin();

    /**
     * Test if this expression is the function <code>Sinh[&lt;arg&gt;]</code>
     *
     * @return
     */
    boolean isSinh();

    /**
     * Test if this expression is the function <code>Slot[&lt;integer-value&gt;]</code> (i.e. #1, #2, #3,....)
     *
     * @return
     */
    boolean isSlot();

    /**
     * Test if this expression is the function <code>SlotSequence[&lt;integer-value&gt;]</code>
     *
     * @return
     */
    boolean isSlotSequence();

    /**
     * Test if this expression is the function <code>Span[...]</code> with 2 or 3 arguments.
     *
     * @param size the size of an AST for which <code>Span[]</code> should be applied.
     * @return <code>null</code> if this is no <code>Span[...]</code> expression.
     * @throws WrongArgumentType
     */
    int[] isSpan(int size);

    /**
     * Test if this expression is a string (instanceof IStringX)
     *
     * @return
     */
    boolean isString();

    /**
     * Test if this expression is a symbol (instanceof ISymbol)
     *
     * @return
     */
    boolean isSymbol();

    /**
     * Test if this expression is a symbol (instanceof ISymbol) or a pattern object (instanceof IPatternObject)
     *
     * @return
     */
    boolean isSymbolOrPattern();

    /**
     * Test if this expression is the function <code>TAn[&lt;arg&gt;]</code>
     *
     * @return
     */
    boolean isTan();

    /**
     * Test if this expression is the function <code>Tanh[&lt;arg&gt;]</code>
     *
     * @return
     */
    boolean isTanh();

    /**
     * Test if this expression is the multiplication function <code>Times[&lt;arg1&gt;, &lt;arg2&gt;, ...]</code> with
     * at least 2 arguments.
     *
     * @return
     */
    boolean isTimes();

    /**
     * Test if this expression equals the symbol <code>True</code>.
     *
     * @return <code>true</code> if the expression equals symbol <code>True</code> and <code>false</code> in all other
     * cases
     */
    boolean isTrue();

    /**
     * {@inheritDoc}
     */
    @Override
    boolean isUnit();

    /**
     * Returns <code>true</code>, if this symbol or ast expression is bound to a value (i.e. the evaluation returns an
     * <i>assigned</i> value).
     *
     * @return
     */
    boolean isValue();

    /**
     * Test if this expression is a symbol which doesn't has attribute <code>Constant</code>.
     *
     * @return
     * @see #isConstant()
     * @see #isSymbol()
     */
    boolean isVariable();

    /**
     * Test if this expression is a vector and return the dimension of the vector. This expression is only a vector, if
     * the expression is a <code>ASTRealVector</code> or a <code>List(...)</code> and no element is itself a
     * <code>List(...)</code>.
     *
     * @return <code>-1</code> if the expression is no vector or <code>size()-1</code> of this vector AST.
     */
    int isVector();

    /**
     * Test if this expression equals <code>0</code> in symbolic or numeric mode.
     *
     * @return
     */
    boolean isZero();

    /**
     * {@inheritDoc}
     *
     * @deprecated use {@link #isZero()} instead.
     */
    @Deprecated
    @Override
    boolean isZERO();

    /**
     * Count the number of leaves of this expression.
     *
     * @return
     */
    long leafCount();

    /**
     * Count the number of leaves of this expression; for integer numbers in exact integer, fractional and complex
     * numbers count the digits of the integers. This function is used in <code>Simplify</code> as the
     * &quot;complexity function&quot;.
     *
     * @return
     */
    long leafCountSimplify();

    /**
     * Evaluate Less, if both arguments are real numbers
     *
     * @param a1
     * @return
     */
    IExpr less(final IExpr a1);

    /**
     * Evaluate LessEqual, if both arguments are real numbers
     *
     * @param a1
     * @return
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
     * @param that
     * @return <code>F.True, F.False or F.NIL</code
     */
    public IExpr lessEqualThan(IExpr that);

    /**
     * Compare if <code>this < that</code:
     * <ul>
     * <li>return F.True if the comparison is <code>true</code></li>
     * <li>return F.False if the comparison is <code>false</code></li>
     * <li>return F.NIL if the comparison is undetermined (i.e. could not be evaluated)</li>
     * </ul>
     *
     * @param that
     * @return <code>F.True, F.False or F.NIL</code
     */
    public IExpr lessThan(IExpr that);

    /**
     * If this is a <code>Interval[{lower, upper}]</code> expression return the <code>lower</code> value. If this is a
     * <code>ISignedNumber</code> expression return <code>this</code>.
     *
     * @return <code>F.NIL</code> if this expression is no interval and no signed number.
     */
    public IExpr lower();

    /**
     * Returns an <code>IExpr</code> whose value is <code>(this - that)</code>. Calculates
     * <code>F.eval(F.Plus(this, F.Times(F.CN1, that)))</code> in the common case and uses a specialized implementation
     * for derived number classes.
     *
     * @param that
     * @return
     */
    IExpr minus(final IExpr that);

    IExpr mod(final IExpr that);

    /**
     * Additional multiply method which works like <code>times()</code> to fulfill groovy's method signature
     *
     * @param that
     * @return
     * @see IExpr#times(IExpr)
     */
    @Override
    IExpr multiply(final IExpr that);

    @Override
    public IExpr multiply(int n);

    /**
     * {@inheritDoc}
     */
    @Override
    IExpr negate();

    /**
     * Additional negative method, which works like opposite to fulfill groovy's method signature
     *
     * @return
     * @see #opposite()
     */
    IExpr negative();

    /**
     * Returns an <code>IExpr</code> whose value is <code>(-1) * this</code>. Calculates
     * <code>F.eval(F.Times(F.CN1, this))</code> in the common case and uses a specialized implementation for derived
     * number classes.
     *
     * @return
     * @see #negative()
     */
    IExpr opposite();

    /**
     * The <code>ExprNull.NIL#optional()</code> method always returns <code>that</code>. All other objects which
     * implement this method returns <code>that</code> if <code>that!=null</code> or <code>this</code> if
     * <code>that==null</code>
     *
     * @param that
     * @return <code>that</code> if <code>that!=null</code> or <code>this</code> in all other cases.
     * @see NILPointer#optional(IExpr)
     */
    IExpr optional(final IExpr that);

    IExpr or(final IExpr that);

    /**
     * Return <code>this</code> if <code>this</code> unequals <code>F.NIL</code> , otherwise return <code>other</code>.
     *
     * @param other
     * @return <code>this</code> if <code>this</code> unequals <code>F.NIL</code>, otherwise return <code>other</code>.
     * @see java.util.Optional#orElse(Object)
     */
    IExpr orElse(final IExpr other);

    /**
     * Return <code>this</code> if <code>this</code> unequals <code>F.NIL</code> , otherwise invoke {@code other} and
     * return the result of that invocation.
     *
     * @param other a {@code Supplier} whose result is returned if no value is present
     * @return <code>this</code> if <code>this</code> unequals <code>F.NIL</code>, otherwise the result of
     * {@code other.get()}
     */
    IExpr orElseGet(Supplier<? extends IExpr> other);

    /**
     * Return <code>this</code> if <code>this</code> unequals <code>F.NIL</code> , otherwise throw an exception to be
     * created by the provided supplier.
     *
     * @param <X>               Type of the exception to be thrown
     * @param exceptionSupplier The supplier which will return the exception to be thrown
     * @return <code>this</code> if <code>this</code> unequals <code>F.NIL</code> or throw an exception
     * @throws X if there is no value present
     * @apiNote A method reference to the exception constructor with an empty argument list can be used as the supplier.
     * For example, {@code IllegalStateException::new}
     */
    <X extends Throwable> IExpr orElseThrow(Supplier<? extends X> exceptionSupplier) throws X;

    /**
     * <p>
     * Select all elements by applying the <code>predicate</code> to each argument in this <code>AST</code> and append
     * the arguments which satisfy the predicate to the <code>1st element</code> of the resulting AST, or otherwise
     * append it to the <code>2nd element</code> of the resulting AST.
     * </p>
     * <p>
     * See: <a href= "https://people.eecs.berkeley.edu/~fateman/papers/partition.pdf">Fateman - Partitioning of
     * Algebraic Subexpressions in Computer Algebra Systems</a>
     * </p>
     *
     * @param operator  the if the head of this expression equals <code>operator</code>, otherwise return <code>F.NIL</code>.
     * @param predicate the predicate which filters each element in this AST
     * @param initTrue  the result for the 1st result element, if the predicate doesn't give <code>true</code> for any of the
     *                  arguments in this AST.
     * @param initFalse the result for the 2nd result element, if the predicate doesn't give <code>false</code> for any of the
     *                  arguments in this AST.
     * @param combiner  the 1st and 2md results element head
     * @return <code>F.NIL</code> if partitioning wasn't possible
     */
    IAST partition(ISymbol operator, Predicate<? super IExpr> predicate, IExpr initTrue, IExpr initFalse,
                   ISymbol combiner, ISymbol action);

    /**
     * <p>
     * Select all elements by applying the <code>predicate</code> to each argument in this <code>Plus(...)</code>
     * expression and append the arguments which satisfy the predicate to the <code>1st element</code> of the resulting
     * AST, or otherwise append it to the <code>2nd element</code> of the resulting AST.
     * </p>
     * <p>
     * See: <a href= "https://people.eecs.berkeley.edu/~fateman/papers/partition.pdf">Fateman - Partitioning of
     * Algebraic Subexpressions in Computer Algebra Systems</a>
     * </p>
     *
     * @param predicate the predicate which filters each element in this AST
     * @param initTrue  the result for the 1st result element, if the predicate doesn't give <code>true</code> for any of the
     *                  arguments in this AST.
     * @param initFalse the result for the 2nd result element, if the predicate doesn't give <code>false</code> for any of the
     *                  arguments in this AST.
     * @return <code>F.NIL</code> if partitioning wasn't possible
     */
    IAST partitionPlus(Predicate<? super IExpr> predicate, IExpr initTrue, IExpr initFalse, ISymbol action);

    /**
     * <p>
     * Select all elements by applying the <code>predicate</code> to each argument in this <code>Times(...)</code>
     * expression and append the arguments which satisfy the predicate to the <code>1st element</code> of the resulting
     * AST, or otherwise append it to the <code>2nd element</code> of the resulting AST.
     * </p>
     * <p>
     * See: <a href= "https://people.eecs.berkeley.edu/~fateman/papers/partition.pdf">Fateman - Partitioning of
     * Algebraic Subexpressions in Computer Algebra Systems</a>
     * </p>
     *
     * @param predicate the predicate which filters each element in this AST
     * @param initTrue  the result for the 1st result element, if the predicate doesn't give <code>true</code> for any of the
     *                  arguments in this AST.
     * @param initFalse the result for the 2nd result element, if the predicate doesn't give <code>false</code> for any of the
     *                  arguments in this AST.
     * @return <code>F.NIL</code> if partitioning wasn't possible
     */
    IAST partitionTimes(Predicate<? super IExpr> predicate, IExpr initTrue, IExpr initFalse, ISymbol action);

    /**
     * Returns an <code>IExpr</code> whose value is <code>(this + that)</code>. Calculates
     * <code>F.eval(F.Plus(this, that))</code> in the common case and uses a specialized implementation for derived
     * number classes.
     *
     * @param that
     * @return
     */
    IExpr plus(final IExpr that);

    /**
     * Returns an <code>IExpr</code> whose value is <code>(this ^ that)</code>. Calculates
     * <code>F.eval(F.Power(this, that))</code> in the common case and uses a specialized implementation for derived
     * number classes.
     *
     * @param that
     * @return <code>(this ^ that)</code>
     */
    IExpr power(final IExpr that);

    /**
     * Returns an <code>IExpr</code> whose value is <code>(this ^ n)</code>. Calculates
     * <code>F.eval(F.Power(this, that))</code> in the common case and uses a specialized implementation for derived
     * number classes.
     *
     * @param n the exponent
     * @return <code>(this ^ n)</code>
     */
    @Override
    IExpr power(final long n);

    /**
     * Return the real part of this expression if possible. Otherwise return <code>Re(this)</code>.
     *
     * @return real part
     */
    public IExpr re();

    @Override
    public IExpr reciprocal() throws MathRuntimeException;


    IExpr remainder(IExpr that);

    /**
     * Replace all (sub-) expressions with the given unary function. If no substitution matches, the method returns
     * <code>null</code>.
     *
     * @param function if the unary functions <code>apply()</code> method returns <code>F.NIL</code> the expression isn't
     *                 substituted.
     * @return <code>F.NIL</code> if no substitution of a (sub-)expression was possible.
     */
    @Nullable
    IExpr replaceAll(final Function<IExpr, IExpr> function);

    /**
     * Replace all (sub-) expressions with the given rule set. If no substitution matches, the method returns
     * <code>null</code>.
     *
     * @param astRules rules of the form <code>x-&gt;y</code> or <code>{a-&gt;b, c-&gt;d}</code>; the left-hand-side of the
     *                 rule can contain pattern objects.
     * @return <code>F.NIL</code> if no substitution of a (sub-)expression was possible.
     */
    @Nullable
    IExpr replaceAll(final IAST astRules);

    /**
     * Replace all subexpressions with the given rule set. A rule must contain the position of the subexpression which
     * should be replaced on the left-hand-side. If no substitution matches, the method returns <code>F.NIL</code>.
     *
     * @param astRules rules of the form <code>position-&gt;y</code> or <code>{position1-&gt;b, position2-&gt;d}</code>
     * @return <code>F.NIL</code> if no substitution of a subexpression was possible.
     */
    IExpr replacePart(final IAST astRules);

    /**
     * Repeatedly replace all (sub-) expressions with the given unary function. If no substitution matches, the method
     * returns <code>this</code>.
     *
     * @param function if the unary functions <code>apply()</code> method returns <code>null</code> the expression isn't
     *                 substituted.
     * @return <code>this</code> if no substitution of a (sub-)expression was possible.
     */
    IExpr replaceRepeated(final Function<IExpr, IExpr> function);

    /**
     * Repeatedly replace all (sub-) expressions with the given rule set. If no substitution matches, the method returns
     * <code>this</code>.
     *
     * @param astRules rules of the form <code>x-&gt;y</code> or <code>{a-&gt;b, c-&gt;d}</code>; the left-hand-side of the
     *                 rule can contain pattern objects.
     * @return <code>this</code> if no substitution of a (sub-)expression was possible.
     */
    IExpr replaceRepeated(final IAST astRules);

    /**
     * Repeatedly replace all (sub-) expressions with the given visitor. If no substitution matches, the method returns
     * <code>this</code>.
     *
     * @param visitor
     * @return
     */
    IExpr replaceRepeated(VisitorReplaceAll visitor);

    /**
     * <p>
     * Replace all occurrences of Slot[&lt;index&gt;] expressions with the expression at the appropriate
     * <code>index</code> in the given <code>slotsList</code>.
     * </p>
     * <p>
     * <b>Note:</b> If a slot value is <code>null</code> the Slot will not be substituted.
     * </p>
     *
     * @param slotsList the values for the slots.
     * @return <code>null</code> if no substitution occurred.
     * @deprecated use org.matheclipse.core.eval.util.Lambda#replaceSlots() instead
     */
    @Deprecated
    IExpr replaceSlots(final IAST slotsList);

    /**
     * Get the rest of the elements of this <code>AST</code> list. Return <code>F.NIL</code> if this object isn't an
     * <code>AST</code>.
     *
     * @return the rest arguments of the function represented by this <code>AST</code> with the first argument removed.
     * @see IExpr#head()
     */
    public IASTAppendable rest();

    /**
     * Get the second element of this <code>AST</code> list (i.e. get(2)). Return <code>F.NIL</code> if this object
     * isn't an <code>AST</code>.
     *
     * @return the second argument of the function represented by this <code>AST</code> or <code>F.NIL</code> if this
     * object isn't an AST.
     */
    public IExpr second();

    /**
     * Signum functionality is used in JAS toString() method, don't use it as math signum function.
     *
     * @deprecated
     */
    @Deprecated
    @Override
    int signum();

    /**
     * Returns the <b>number of elements</b> in this {@code IAST}.The <b>number of elements</b> equals
     * <code>argSize() + 1</code> (i.e. the <b>number of arguments</b> plus 1). If this is an atom return size
     * <code>0</code>.
     *
     * @return the <b>number of elements</b> in this {@code IAST}.
     * @see #argSize()
     */
    int size();

    /**
     * Generate <code>Sqrt(this)</code>.
     */
    IExpr sqrt();

    @Override
    IExpr subtract(IExpr that);

    @Override
    IExpr sum(final IExpr that);

    /**
     * Returns an <code>IExpr</code> whose value is <code>(this * that)</code>. Calculates
     * <code>F.eval(F.Times(this, that))</code> in the common case and uses a specialized implementation for derived
     * number classes.
     *
     * @param that the multiplier expression
     * @return <code>(this * that)</code>
     */
    IExpr times(final IExpr that);

    /**
     * Returns an <code>IExpr</code> whose value is <code>(this * that)</code>. Calculates
     * <code>F.eval(F.Times(this, that))</code> in the common case and uses a specialized implementation for derived
     * number classes.
     *
     * @param that the multiplier expression
     * @return <code>(this * that)</code>
     */
    public IExpr timesDistributed(final IExpr that);

    /**
     * Convert this object into a <code>double[]</code> matrix.
     *
     * @return <code>null</code> if this object can not be converted into a <code>double[]</code> matrix
     */
    double[][] toDoubleMatrix();

    /**
     * Convert this object into a <code>double[]</code> vector.
     *
     * @return <code>null</code> if this object can not be converted into a <code>double[]</code> vector
     */
    double[] toDoubleVector();

    /**
     * Converts this number to an <code>int</code> value; unlike {link #intValue} this method returns
     * <code>Value</code> if the value of this integer isn't in the range <code>Integer.MIN_VALUE</code> to
     * <code>Integer.MAX_VALUE</code> or the expression is not convertible to the int range.
     *
     * @param Value the  value, if this integer is not in the <code>int</code> range
     * @return the numeric value represented by this integer after conversion to type <code>int</code>.
     */
    int toIntDefault(int Value);

    /**
     * The 'highest level' head of the expression, before Symbol, Integer, Real or String. for example while the head of
     * a[b][c] is a[b], the top head is a.
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
     * Convert this object into a RealVector.
     *
     * @return <code>null</code> if this object can not be converted into a RealVector
     */
    RealVector toRealVector();

    @Override
    String toScript();

    @Override
    String toScriptFactory();

    /**
     * Compare if <code>this != that</code:
     * <ul>
     * <li>return F.True if the comparison is <code>true</code></li>
     * <li>return F.False if the comparison is <code>false</code></li>
     * <li>return F.NIL if the comparison is undetermined (i.e. could not be evaluated)</li>
     * </ul>
     *
     * @param that
     * @return <code>F.True, F.False or F.NIL</code
     */
    public IExpr unequalTo(IExpr that);

    /**
     * If this is a <code>Interval[{lower, upper}]</code> expression return the <code>upper</code> value. If this is a
     * <code>ISignedNumber</code> expression return <code>this</code>.
     *
     * @return <code>F.NIL</code> if this expression is no interval and no signed number.
     */
    public IExpr upper();

    /**
     * Convert the variables (i.e. expressions of type <code>ISymbol</code> which aren't constants) in this expression
     * into Slot[] s.
     *
     * @param map               for every given symbol argument return the associated unique slot from this map
     * @param variableCollector collects the variables which are used in the replacement process
     * @return <code>F.NIL</code> if no variable symbol was found.
     */
    IExpr variables2Slots(final Map<IExpr, IExpr> map, final Collection<IExpr> variableCollector);

    public enum COMPARE_TERNARY {
        TRUE, FALSE, UNDEFINED
    }
}
