package org.matheclipse.core.interfaces;

import com.duy.lambda.BiFunction;
import com.duy.lambda.BiPredicate;
import com.duy.lambda.Consumer;
import com.duy.lambda.Function;
import com.duy.lambda.ObjIntConsumer;
import com.duy.lambda.Predicate;

import org.matheclipse.core.eval.exception.WrongArgumentType;
import org.matheclipse.core.generic.ObjIntPredicate;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * (I)nterface for the (A)bstract (S)yntax (T)ree of a given function.
 * </p>
 *
 * <p>
 * In Symja, an abstract syntax tree (AST), is a tree representation of the abstract syntactic structure of the Symja
 * source code. Each node of the tree denotes a construct occurring in the source code. The syntax is 'abstract' in the
 * sense that it does not represent every detail that appears in the real syntax. For instance, grouping parentheses are
 * implicit in the tree structure, and a syntactic construct such as a <code>Sin(x)</code> expression will be denoted by
 * an AST with 2 nodes. One node for the header <code>Sin</code> and one node for the argument <code>x</code>.
 * </p>
 * <p>
 * Internally an AST is represented as a list which contains
 * <ul>
 * <li>the operator of a function (i.e. the &quot;header&quot;-symbol: Sin, Cos, Inverse, Plus, Times,...) at index
 * <code>0</code> and</li>
 * <li>the <code>n</code> arguments of a function in the index <code>1 to n</code></li>
 * </ul>
 * <p>
 * See <a href="http://en.wikipedia.org/wiki/Abstract_syntax_tree">Abstract syntax tree</a>,
 * <a href="https://en.wikipedia.org/wiki/Directed_acyclic_graph">Directed acyclic graph</a>
 */
public interface IAST extends IExpr, Cloneable, Iterable<IExpr> {

    /**
     * NO_FLAG ACTIVATED
     */
    int NO_FLAG = 0x0000;
    /**
     * The head or one of the arguments of the list or sublists contains a pattern object
     */
    int CONTAINS_PATTERN = 0x0001;
    /**
     * The head or one of the arguments of the list or sublists contains a pattern object
     */
    int CONTAINS_PATTERN_SEQUENCE = 0x0002;
    /**
     * One of the arguments of the list contains a pattern object which can be set to a default value.
     */
    int CONTAINS_DEFAULT_PATTERN = 0x0004;
    /**
     * The list or the lists subexpressions contain no pattern object.
     */
    int CONTAINS_NO_PATTERN = 0x0008;
    /**
     * One of the arguments of the list or sublists contains a pattern object. Combination of
     * <code>CONTAINS_PATTERN, CONTAINS_PATTERN_SEQUENCE, CONTAINS_DEFAULT_PATTERN</code>
     */
    int CONTAINS_PATTERN_EXPR = 0x0007;
    /**
     * Negative flag mask for CONTAINS_DEFAULT_PATTERN
     */
    int CONTAINS_NO_DEFAULT_PATTERN_MASK = 0xFFFB;
    /**
     * This expression represents a matrix
     */
    int IS_MATRIX = 0x0020;
    /**
     * This expression represents a vector
     */
    int IS_VECTOR = 0x0040;
    /**
     * This expression represents a matrix or vector if one of the following bits is set.
     */
    int IS_MATRIX_OR_VECTOR = 0x0060;
    /**
     * This expression represents an already decomposed partial fraction
     *
     * @see Apart
     */
    int IS_DECOMPOSED_PARTIAL_FRACTION = 0x0080;
    /**
     * This expression is an already flattened expression
     */
    int IS_FLATTENED = 0x0100;
    /**
     * This expression is an already sorted expression (i.e. sorted with the <code>Order()</code> function)
     */
    int IS_SORTED = 0x0200;
    /**
     * This expression has already applied the Listable attribute to its argument expressions
     */
    int IS_LISTABLE_THREADED = 0x0400;
    /**
     * This expression is an already flattened or sorted expression
     */
    int IS_FLATTENED_OR_SORTED_MASK = 0x0300;
    /**
     * This expression is an already evaled expression
     */
    int IS_FLAT_ORDERLESS_EVALED = 0x0800;
    /**
     * This expression is already evaluated by Expand() function
     */
    int IS_EXPANDED = 0x1000;
    /**
     * This expression is already evaluated by ExpandAll() function
     */
    int IS_ALL_EXPANDED = 0x2000;
    /**
     * This expression is already evaluated by a HashedOrderlessMatcher function
     */
    int IS_HASH_EVALED = 0x4000;
    /**
     * This expression is already evaluated in the Derivative[] function
     */
    int IS_DERIVATIVE_EVALED = 0x8000;
    /**
     * Is set, if one of the (nested) arguments of a numeric function contains a numeric expression.
     */
    int CONTAINS_NUMERIC_ARG = 0x00010000;

    /**
     * Add an evaluation flag to the existing ones.
     *
     * @param i
     */
    IAST addEvalFlags(int i);

    /**
     * Create a shallow copy of this <code>IAST</code> instance (the elements themselves are not copied) and add the
     * <code>expr</code> at the given <code>position</code>.
     *
     * @param position
     * @param expr
     * @return a clone with added <code>expr</code> element at the given <code>position</code>.
     */
    IASTAppendable appendAtClone(int position, IExpr expr);

//	public final int DEFER_AST = 0x00020000;

    /**
     * Append an expression to this list.
     *
     * @param expr the expression which should be appended
     * @return <code>this</code> after appending the given expression.
     */
    IASTAppendable appendClone(IExpr expr);

    /**
     * Apply the given head to this expression (i.e. create a list clone and replace the old head with the given one)
     *
     * @param head
     * @return
     */
    IASTAppendable apply(IExpr head);

    /**
     * Apply the given head to this expression (i.e. create a sublist clone starting from index start and replacing the
     * old head with the given one)
     *
     * @param head
     * @param start the start index
     * @return
     */
    IAST apply(IExpr head, int start);

    /**
     * Apply the given head to this expression (i.e. create a sublist clone from index start to end, and replacing the
     * old head with the given one)
     *
     * @param head
     * @param start the start index
     * @param end   the end index
     * @return a clone with element set to <code>head</code> at the given <code>0</code>.
     */
    IAST apply(IExpr head, int start, int end);

    /**
     * Get the first argument (i.e. the second element of the underlying list structure) of the <code>AST</code>
     * function (i.e. get(1) ). <br />
     * <b>Example:</b> for the AST representing the expression <code>Sin(x)</code>, <code>arg1()</code> returns
     * <code>x</code>.
     *
     * @return the first argument of the function represented by this <code>AST</code>.
     * @see IExpr#head()
     */
    IExpr arg1();

    /**
     * Get the second argument (i.e. the third element of the underlying list structure) of the <code>AST</code>
     * function (i.e. get(2) ). <br />
     * <b>Example:</b> for the AST representing the expression <code>x^y</code> (i.e. <code>Power(x, y)</code>),
     * <code>arg2()</code> returns <code>y</code>.
     *
     * @return the second argument of the function represented by this <code>AST</code>.
     * @see IExpr#head()
     */
    IExpr arg2();

    /**
     * Get the third argument (i.e. the fourth element of the underlying list structure) of the <code>AST</code>
     * function (i.e. get(3) ).<br />
     * <b>Example:</b> for the AST representing the expression <code>f(a, b, c)</code>, <code>arg3()</code> returns
     * <code>c</code>.
     *
     * @return the third argument of the function represented by this <code>AST</code>.
     * @see IExpr#head()
     */
    IExpr arg3();

    /**
     * Get the fourth argument (i.e. the fifth element of the underlying list structure) of the <code>AST</code>
     * function (i.e. get(4) ).<br />
     * <b>Example:</b> for the AST representing the expression <code>f(a, b ,c, d)</code>, <code>arg4()</code> returns
     * <code>d</code>.
     *
     * @return the fourth argument of the function represented by this <code>AST</code>.
     * @see IExpr#head()
     */
    IExpr arg4();

    /**
     * Get the fifth argument (i.e. the sixth element of the underlying list structure) of the <code>AST</code> function
     * (i.e. get(5) ).<br />
     * <b>Example:</b> for the AST representing the expression <code>f(a, b ,c, d, e)</code>, <code>arg5()</code>
     * returns <code>e</code> .
     *
     * @return the fifth argument of the function represented by this <code>AST</code>.
     * @see IExpr#head()
     */
    IExpr arg5();

    int argSize();

    /**
     * Calls <code>get(position).equals(expr)</code>.
     *
     * @param position the position which should be tested for equality
     * @param expr     the expr which should be tested for equality
     * @return
     */
    boolean equalsAt(int position, final IExpr expr);

    /**
     * {@inheritDoc}
     */
    @Override
    IExpr first();

    /**
     * {@inheritDoc}
     */
    @Override
    IExpr last();

    boolean isNotDefined();

    /**
     * Check if the object at index 0 (i.e. the head of the list) is the same object as <code>head</code> and if the
     * size of the list is greater or equal <code>length</code>.
     *
     * @param head   object to compare with element at location <code>0</code>
     * @param length
     * @return
     */
    @Override
    boolean isSameHeadSizeGE(ISymbol head, int length);

    /**
     * {@inheritDoc}
     */
    @Override
    boolean isTimes();

    /**
     * {@inheritDoc}
     */
    @Override
    boolean isTrigFunction();

    /**
     * {@inheritDoc}
     */
    @Override
    IAST rest();

    /**
     * {@inheritDoc}
     */
    @Override
    IExpr second();

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
     * Returns the header. If the header itself is an ISymbol it will return the symbol object. If the header itself is
     * an IAST it will recursively call headSymbol(). If the head is of type INumbers, the head will return one of these
     * headers: "DoubleComplex", "Double", "Integer", "Fraction", "Complex". All other objects return <code>null</code>.
     */
    @Override
    ISymbol topHead();

    /**
     * Collect all arguments of this AST in a new set.
     *
     * @return
     */
    Set<IExpr> asSet();

    /**
     * Set the cached hash value to zero.
     */
    void clearHashCache();

    /**
     * Returns a shallow copy of this <code>IAST</code> instance (the elements themselves are not cloned).
     *
     * @return a clone of this <code>IAST</code> instance.
     */
    IAST clone() throws CloneNotSupportedException;

    /**
     * Compare all adjacent elements from lowest to highest index and return true, if the binary predicate gives true in
     * each step. If the size is &lt; 2 the method returns false;
     *
     * @param predicate the binary predicate
     * @return
     */
    boolean compareAdjacent(BiPredicate<IExpr, IExpr> predicate);

    /**
     * Tests whether this {@code List} contains the specified object.
     *
     * @param object the object to search for.
     * @return {@code true} if object is an element of this {@code List}, {@code false} otherwise
     */
    boolean contains(Object object);

    /**
     * Tests whether this {@code Collection} contains all objects contained in the specified {@code Collection}. This
     * implementation iterates over the specified {@code Collection}. If one element returned by the iterator is not
     * contained in this {@code Collection}, then {@code false} is returned; {@code true} otherwise.
     *
     * @param collection the collection of objects.
     * @return {@code true} if all objects in the specified {@code Collection} are elements of this {@code Collection},
     * {@code false} otherwise.
     * @throws ClassCastException   if one or more elements of {@code collection} isn't of the correct type.
     * @throws NullPointerException if {@code collection} contains at least one {@code null} element and this {@code Collection} doesn't
     *                              support {@code null} elements.
     * @throws NullPointerException if {@code collection} is {@code null}.
     */
    boolean containsAll(Collection<?> collection);

    /**
     * Returns a shallow copy of this <code>IAST</code> instance (the elements themselves are not copied). In contrast
     * to the <code>clone()</code> method, this method returns exactly the same type for
     * <code>AST0, AST1, AST2,AST3</code>.
     *
     * @return a copy of this <code>IAST</code> instance.
     */
    @Override
    IASTMutable copy();

    /**
     * Returns a shallow copy of this <code>IAST</code> instance (the elements themselves are not copied). In contrast
     * to the <code>clone()</code> method, this method returns exactly the same type for
     * <code>AST0, AST1, AST2,AST3</code>.
     *
     * @return a copy of this <code>IAST</code> instance.
     */
    IASTAppendable copyAppendable();

    /**
     * Create a copy of this <code>AST</code>, which contains the same head and all elements from the given
     * <code>position</code> (inclusive).
     *
     * @param position
     * @return
     */
    IASTAppendable copyFrom(int position);

    /**
     * Create a copy of this <code>AST</code>, which only contains the head element of the list (i.e. the element with
     * index 0).
     *
     * @return
     */
    IASTAppendable copyHead();

    /**
     * Create a copy of this <code>AST</code>, which only contains the head element of the list (i.e. the element with
     * index 0) and allocate the <code>intialCapacity</code> size of entries for the arguments.
     *
     * @param intialCapacity the initial number of arguments
     * @return
     */
    IASTAppendable copyHead(final int intialCapacity);

    /**
     * Copy the arguments of this AST to a list.
     *
     * @return
     */
    List<IExpr> copyTo();

    /**
     * Copy the arguments of this AST to a given collection object.
     *
     * @param collection
     * @return
     */
    Collection<IExpr> copyTo(Collection<IExpr> collection);

    /**
     * Create a copy of this <code>AST</code>, which contains the same head and all elements up to the given
     * <code>position</code> (exclusive).
     *
     * @param position
     * @return
     */
    IASTAppendable copyUntil(int position);

    /**
     * Create a copy of this <code>AST</code>, which contains the same head and all elements up to the given
     * <code>position</code> (exclusive).
     *
     * @param intialCapacity the initial capacity of elements
     * @param position
     * @return
     */
    IASTAppendable copyUntil(final int intialCapacity, int position);

    /**
     * Check all elements by applying the <code>predicate</code> to each argument in this <code>AST</code> and return
     * <code>true</code> if one of the arguments satisfy the predicate.
     *
     * @param predicate the predicate which filters each argument in this <code>AST</code>
     * @return the <code>true</code> if the predicate is true the first time or <code>false</code> otherwise
     */
    boolean exists(ObjIntPredicate<? super IExpr> predicate);

    /**
     * Check all elements by applying the <code>predicate</code> to each argument in this <code>AST</code> and return
     * <code>true</code> if one of the arguments satisfy the predicate.
     *
     * @param predicate   the predicate which filters each argument in this <code>AST</code>
     * @param startOffset start offset from which the element have to be tested
     * @return the <code>true</code> if the predicate is true the first time or <code>false</code> otherwise
     */
    boolean exists(ObjIntPredicate<? super IExpr> predicate, int startOffset);

    /**
     * Check all elements by applying the <code>predicate</code> to each argument in this <code>AST</code> and return
     * <code>true</code> if one of the arguments satisfy the predicate.
     *
     * @param predicate the predicate which filters each argument in this <code>AST</code>
     * @return the <code>true</code> if the predicate is true the first time or <code>false</code> otherwise
     */
    boolean exists(Predicate<? super IExpr> predicate);

    /**
     * Check all elements by applying the <code>predicate</code> to each argument in this <code>AST</code> and return
     * <code>true</code> if one of the arguments satisfy the predicate.
     *
     * @param predicate   the predicate which filters each argument in this <code>AST</code>
     * @param startOffset start offset from which the element have to be tested
     * @return the <code>true</code> if the predicate is true the first time or <code>false</code> otherwise
     */
    boolean exists(Predicate<? super IExpr> predicate, int startOffset);

    /**
     * Compare the arguments pairwise with the <code>stopPredicate</code>. If the predicate gives <code>true</code>
     * return <code>true</code>. If the <code>stopPredicate</code> gives false for each pairwise comparison return the
     * <code>false</code> at the end.
     *
     * @param ast
     * @param stopPredicate
     * @param stopExpr
     * @param resultExpr
     * @return
     */
    boolean existsLeft(BiPredicate<IExpr, IExpr> stopPredicate);

    /**
     * Copy of sub <code>AST</code> fromIndex (inclusive) to toIndex (exclusive).
     *
     * @param fromIndex
     * @param toIndex
     * @return copy of sub <code>AST</code> fromIndex (inclusive) to toIndex (exclusive)
     */
    IASTAppendable extract(int fromIndex, int toIndex);

    /**
     * Select all elements by applying the <code>function</code> to each argument in this <code>AST</code> and append
     * the result elements for which the function returns non-null elements to the <code>0th element</code> of the
     * result array, or otherwise append it to the <code>1st element</code> of the result array.
     *
     * @param function the function which filters each argument in this AST by returning a <code>result != F.NIL</code> .
     * @return the resulting ASTs in the 0-th and 1-st element of the array
     */
    IASTAppendable[] filter(final Function<IExpr, IExpr> function);

    /**
     * Select all elements by applying the <code>predicate</code> to each argument in this <code>AST</code> and append
     * the elements which satisfy the <code>predicate</code> to the <code>filterAST</code>, or otherwise append it to
     * the <code>restAST</code>.
     *
     * @param filterAST the elements where the <code>predicate#apply()</code> method returns <code>true</code>
     * @param restAST   the elements which don't match the predicate
     * @param predicate the predicate which filters each argument in this <code>AST</code>
     * @return the <code>filterAST</code>
     */
    IAST filter(IASTAppendable filterAST, IASTAppendable restAST, Predicate<? super IExpr> predicate);

    /**
     * Select all elements by applying the <code>Predicates.isTrue(expr)</code> predicate to each argument in this
     * <code>AST</code> and append the elements which satisfy the <code>Predicates.isTrue(expr)</code> predicate to the
     * <code>filterAST</code>.
     *
     * @param filterAST the elements where the <code>predicate#apply()</code> method returns <code>true</code>
     * @param expr      create a <code>Predicates.isTrue(expr)</code> predicate which filters each element in this AST.
     * @return the <code>filterAST</code>
     */
    IAST filter(IASTAppendable filterAST, IExpr expr);

    /**
     * Select all elements by applying the <code>predicate</code> to each argument in this <code>AST</code> and append
     * the arguments which satisfy the predicate to the <code>filterAST</code>.
     *
     * @param filterAST the elements where the <code>predicate#apply()</code> method returns <code>true</code>
     * @param predicate the predicate which filters each argument in this <code>AST</code>
     * @return the <code>filterAST</code>
     */
    IAST filter(IASTAppendable filterAST, Predicate<? super IExpr> predicate);

    /**
     * Select all elements by applying the <code>predicate</code> to each argument in this <code>AST</code> and append
     * up to <code>maxMatches</code> arguments which satisfy the predicate to the <code>filterAST</code>.
     *
     * @param filterAST  the elements where the <code>predicate#apply()</code> method returns <code>true</code>
     * @param predicate  the predicate which filters each argument in this <code>AST</code>
     * @param maxMatches the maximum number of matches
     * @return the <code>filterAST</code>
     */
    IAST filter(IASTAppendable filterAST, Predicate<? super IExpr> predicate, int maxMatches);

    /**
     * Select all elements by applying the <code>predicate</code> to each argument in this <code>AST</code> and append
     * the arguments which satisfy the predicate to the <code>0th element</code> of the result array, or otherwise
     * append it to the <code>1st element</code> of the result array.
     *
     * @param predicate the predicate which filters each element in the range
     * @return the resulting ASTs in the 0-th and 1-st element of the array
     */
    IAST[] filter(Predicate<? super IExpr> predicate);

    /**
     * Find the first argument position, which equals <code>expr</code>. The search starts at index <code>1</code>.
     *
     * @param expr
     * @return <code>-1</code> if no position was found
     * @deprecated use {@link #indexOf(IExpr)} instead
     */
    int findFirstEquals(final IExpr expr);

    /**
     * Apply the functor to the elements of the range from left to right and return the final result. Results do
     * accumulate from one invocation to the next: each time this method is called, the accumulation starts over with
     * value from the previous function call.
     *
     * @param function   a binary function that accumulate the elements
     * @param startValue
     * @return the accumulated elements
     */
    IExpr foldLeft(final BiFunction<IExpr, IExpr, ? extends IExpr> function, IExpr startValue, int start);

    /**
     * Apply the functor to the elements of the range from right to left and return the final result. Results do
     * accumulate from one invocation to the next: each time this method is called, the accumulation starts over with
     * value from the previous function call.
     *
     * @param function   a binary function that accumulate the elements
     * @param startValue
     * @return the accumulated elements
     */
    IExpr foldRight(final BiFunction<IExpr, IExpr, ? extends IExpr> function, IExpr startValue, int start);

    /**
     * Check all elements by applying the <code>predicate</code> to each argument in this <code>AST</code> and return
     * <code>true</code> if all of the arguments satisfy the predicate.
     *
     * @param predicate the predicate which filters each argument in this <code>AST</code>
     * @return the <code>true</code> if the predicate is true for all elements or <code>false</code> otherwise
     */
    boolean forAll(ObjIntPredicate<? super IExpr> predicate);

    /**
     * Check all elements by applying the <code>predicate</code> to each argument in this <code>AST</code> and return
     * <code>true</code> if all of the arguments satisfy the predicate.
     *
     * @param predicate   the predicate which filters each argument in this <code>AST</code>
     * @param startOffset start offset from which the element have to be tested
     * @return the <code>true</code> if the predicate is true for all elements or <code>false</code> otherwise
     */
    boolean forAll(ObjIntPredicate<? super IExpr> predicate, int startOffset);

    /**
     * Check all elements by applying the <code>predicate</code> to each argument in this <code>AST</code> and return
     * <code>true</code> if all of the arguments starting from index <code>1</code> satisfy the predicate.
     *
     * @param predicate the predicate which filters each argument in this <code>AST</code>
     * @return the <code>true</code> if the predicate is true for all elements or <code>false</code> otherwise
     */
    boolean forAll(Predicate<? super IExpr> predicate);

    /**
     * Check all elements by applying the <code>predicate</code> to each argument in this <code>AST</code> and return
     * <code>true</code> if all of the arguments starting from index <code>startOffset</code> satisfy the predicate.
     *
     * @param predicate   the predicate which filters each argument in this <code>AST</code>
     * @param startOffset start offset from which the element have to be tested
     * @return the <code>true</code> if the predicate is true for all elements or <code>false</code> otherwise
     */
    boolean forAll(Predicate<? super IExpr> predicate, int startOffset);

    /**
     * Check all atomic (non IAST objects) leave element by applying the <code>predicate</code> to each leave argument in this <code>AST</code> and sub-<code>AST</code>s and  return
     * <code>true</code> if all of the leave elements starting from index <code>startOffset</code> satisfy the predicate.
     *
     * @param predicate   the predicate which filters each argument in this <code>AST</code>
     * @param startOffset start offset from which the leave elements have to be tested
     * @return the <code>true</code> if the predicate is true for all elements or <code>false</code> otherwise
     */
    boolean forAllLeaves(Predicate<? super IExpr> predicate, int startOffset);

    /**
     * <p>
     * Iterate over all elements from index <code>1</code> to <code>size()-1</code> and call the method
     * <code>Consumer.accept()</code> for these elements.
     * </p>
     * <b>Note:</b> the 0-th element (i.e. the head of the AST) will not be selected.
     */
    void forEach(Consumer<? super IExpr> action);

    /**
     * <p>
     * Iterate over all elements from index <code>startOffset</code> to <code>size()-1</code> and call the method
     * <code>Consumer.accept()</code> for these elements.
     * </p>
     * <b>Note:</b> the 0-th element (i.e. the head of the AST) will not be selected.
     *
     * @param action
     * @param startOffset the start offset from which the action.accept() method should be executed
     */
    void forEach(Consumer<? super IExpr> action, int startOffset);

    /**
     * Consume all elements generated by the given function from index <code>1</code> inclusive to <code>end</code>
     * exclusive.
     *
     * @param end    end index (exclusive)
     * @param action function which accepts the elements
     * @return <tt>this</tt>
     */
    void forEach(int end, Consumer<? super IExpr> action);

    /**
     * Consume all elements generated by the given function from index <code>start</code> inclusive to <code>end</code>
     * exclusive.
     *
     * @param start  start index (inclusive)
     * @param end    end index (exclusive)
     * @param action function which accepts the elements
     */
    void forEach(int start, int end, Consumer<? super IExpr> action);

    void forEach(int start, int end, ObjIntConsumer<? super IExpr> action);

    void forEach(int end, ObjIntConsumer<? super IExpr> action);

    void forEach(ObjIntConsumer<? super IExpr> action);

    /**
     * Returns the element at the specified location in this {@code IAST}.
     *
     * @param location the index of the element to return.
     * @return the element at the specified location.
     * @throws IndexOutOfBoundsException if {@code location < 0 || >= size()}
     */
    IExpr get(int location);

    /**
     * Casts an <code>IExpr</code> at position <code>index</code> to an <code>IAST</code>.
     *
     * @param index
     * @return
     * @throws WrongArgumentType if the cast is not possible
     */
    IAST getAST(int index);

    /**
     * Get the evaluation flags for this list.
     *
     * @return
     */
    int getEvalFlags();

    /**
     * Set the evaluation flags for this list.
     *
     * @param i
     */
    void setEvalFlags(int i);

    /**
     * Get the cached hash value.
     *
     * @return
     */
    int getHashCache();

    /**
     * Casts an <code>IExpr</code> at position <code>index</code> to an <code>IInteger</code>.
     *
     * @param index
     * @return
     * @throws WrongArgumentType if the cast is not possible
     */
    IInteger getInt(int index);

    /**
     * Casts an <code>IExpr</code> which is a list at position <code>index</code> to an <code>IAST</code>.
     *
     * @param index
     * @return
     * @throws WrongArgumentType
     */
    IAST getList(int index);

    /**
     * Casts an <code>IExpr</code> at position <code>index</code> to an <code>INumber</code>.
     *
     * @param index
     * @return
     * @throws WrongArgumentType if the cast is not possible
     */
    INumber getNumber(int index);

    /**
     * Get the argument at index 1, if the <code>size() == 2</code> or the complete ast if the <code>size() > 2</code>
     * (useful for ASTs with attribute <code>OneIdentity</code> for example for <code>Plus[]</code> you can call
     * <code>getOneIdentity(F.C0)</code> or for <code>Times[]</code>) you can call <code>getOneIdentity(F.C1)</code>.
     *
     * @param defaultValue default value, if <code>size() < 2</code>.
     * @return
     */
    IExpr getOneIdentity(IExpr defaultValue);

    /**
     * Returns the element at the specified positions in the nested ASTs.
     *
     * @param positions index of the element to return
     * @return the element at the specified positions in this nested AST
     * @throws IndexOutOfBoundsException if one of the positions are out of range
     */
    IExpr getPart(final int... positions);

    /**
     * Returns the element at the specified positions in the nested ASTs.
     *
     * @param positions index of the element to return
     * @return the element at the specified positions in this nested AST
     * @throws IndexOutOfBoundsException if one of the positions are out of range
     */
    IExpr getPart(final List<Integer> positions);

    /**
     * Test if the last argument contains a pattern with a default argument.
     *
     * @return
     */
    boolean hasDefaultArgument();

    /**
     * Test if the last argument contains a pattern with a default argument.
     *
     * @return
     */
    boolean haspublicArgument();

    /**
     * Test if one of the arguments gives <code>true</code> for the <code>isNumericArgument()</code> method
     *
     * @return <code>true</code> if one of the arguments gives <code>true</code> for the
     * <code>isNumericArgument()</code> method
     */
    boolean hasNumericArgument();

    /**
     * Test if the last argument contains a pattern with an optional argument. (i.e. <code>x_:value</code>)
     *
     * @return
     */
    boolean hasOptionalArgument();

    /**
     * Find the first argument position, which equals <code>expr</code>. The search starts at index <code>1</code>.
     *
     * @param expr
     * @return <code>-1</code> if no position was found
     */
    public int indexOf(final IExpr expr);

    /**
     * Find the first argument position, which fulfills the <code>predicate</code>. The search starts at index
     * <code>1</code>.
     *
     * @param expr
     * @return <code>-1</code> if no position was found
     */
    int indexOf(Predicate<? super IExpr> predicate);

    /**
     * Test if this AST contains no argument
     *
     * @return
     */
    boolean isEmpty();

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
     * Returns <code>true</code>, if <b>all of the elements</b> in the expressions or the expression itself at the given
     * <code>position</code>, did not match the <code>pattern</code>. Calls
     * <code>get(Position).isFree(pattern, true)</code>.
     *
     * @param position
     * @param pattern  a pattern-matching expression
     * @return
     */
    boolean isFreeAt(int position, final IExpr pattern);

    /**
     * Returns an iterator over the elements in this list starting with offset <b>1</b>.
     *
     * @return an iterator over this list values.
     */
    @Override
    Iterator<IExpr> iterator();

    int lastIndexOf(IExpr object);

    /**
     * Maps the elements of this IAST with the unary <code>functor</code>. If the <code>functor</code> returns
     * <code>F.NIL</code> the original element of this AST list is used.
     * <p>
     * <br />
     * <br />
     * Example for mapping with <code>Functors#replace1st()</code>, where the first argument will be replaced by the
     * current argument of this AST:
     * <p>
     * <pre>
     * plusAST.map(Functors.replace1st(F.D(null, dAST.arg2())));
     * </pre>
     *
     * @param functor     a unary function
     * @param startOffset the startOffset from there the <code>functor</code> should be used.
     * @return
     */
    IAST map(final Function<IExpr, IExpr> functor, final int startOffset);

    /**
     * Maps the elements of this IAST with the elements of the <code>secondAST</code>.
     *
     * @param resultAST
     * @param secondAST
     * @param function  a binary function
     * @return the given resultAST.
     * @throws IndexOutOfBoundsException if the secondAST size is lesser than this AST size
     */
    IAST map(IASTAppendable resultAST, IAST secondAST, BiFunction<IExpr, IExpr, IExpr> function);

    /**
     * Append the mapped ranges elements directly to the given <code>list</code>
     *
     * @param astResult
     * @param function
     * @return
     */
    IASTAppendable map(IASTAppendable astResult, IUnaryIndexFunction<IExpr, IExpr> function);

    /**
     * Maps the elements of this IAST with the unary functor. If the function returns <code>F.NIL</code> the original
     * element of the result list is used.
     *
     * @param clonedResultAST a list which is cloned from <code>this</code> list or greater or equal in size of <code>this</code>
     *                        list.
     * @param functor         a unary function
     * @return
     */
    IAST map(final IASTMutable clonedResultAST, final Function<IExpr, IExpr> functor);

    /**
     * Maps the elements of this IAST with the unary functor. If the function returns <code>null</code> the original
     * element of the result list is used.
     *
     * @param head    the new head element of the result list
     * @param functor a unary function
     * @return
     */
    IAST map(final IExpr head, final Function<IExpr, IExpr> functor);

    /**
     * Maps the elements of this IAST with the unary functor <code>Functors.replaceArg(replacement, position)</code>,
     * there <code>replacement</code> is an IAST at which the argument at the given position will be replaced by the
     * currently mapped element and appends the element to <code>appendAST</code>.
     *
     * @param appendAST
     * @param replacement an IAST there the argument at the given position is replaced by the currently mapped argument of this
     *                    IAST.
     * @param position
     * @return <code>appendAST</code>
     * @deprecated use IAST#mapThread() instead
     */
    @Deprecated
    IAST mapAt(IASTAppendable appendAST, final IAST replacement, int position);

    IAST mapAt(final IASTAppendable replacement, int position);

    /**
     * Append the mapped elements directly to the given <code>list</code>
     *
     * @param list
     * @param binaryFunction binary function
     * @param leftArg        left argument of the binary functions <code>apply()</code> method.
     * @return
     */
    IAST mapLeft(IASTAppendable list, BiFunction<IExpr, IExpr, IExpr> binaryFunction, IExpr leftArg);

    /**
     * <p>
     * This method assumes that <code>this</code> is a list of list in matrix form. It combines the column values in a
     * list as argument for the given <code>function</code>.
     * </p>
     * <b>Example</b> a matrix <code>{{x1, y1,...}, {x2, y2, ...}, ...}</code> will be converted to
     * <code>{f.apply({x1, x2,...}), f.apply({y1, y2, ...}), ...}</code>
     *
     * @param dim the dimension of the matrix
     * @param f   a unary function
     * @return
     */
    IExpr mapMatrixColumns(int[] dim, Function<IExpr, IExpr> f);

    /**
     * Append the mapped elements directly to the given <code>list</code>
     *
     * @param list
     * @param binaryFunction a binary function
     * @param rightArg       right argument of the binary functions <code>apply()</code> method.
     * @return the given list
     */
    Collection<IExpr> mapRight(Collection<IExpr> list, BiFunction<IExpr, IExpr, IExpr> binaryFunction,
                               IExpr rightArg);

    /**
     * Maps the elements of this IAST with the unary functor <code>Functors.replaceArg(replacement, position)</code>,
     * there <code>replacement</code> is an IAST at which the argument at the given position will be replaced by the
     * currently mapped element.
     * <p>
     * <br />
     * <br />
     * Example for mapping with <code>Functors#replaceArg()</code>, where the argument at the given position will be
     * replaced by the current argument of this AST:
     * <p>
     * <pre>
     * plusAST.mapThread(F.D(null, F.x), 1);
     * </pre>
     *
     * @param replacement an IAST there the argument at the given position is replaced by the currently mapped argument of this
     *                    IAST.
     * @param position
     * @return
     * @see IAST#map(Function, int)
     */
    IASTMutable mapThread(final IAST replacement, int position);

    /**
     * Maps the elements of this IAST with the unary functor <code>Functors.replaceArg(replacement, position)</code>,
     * there <code>replacement</code> is an IAST at which the argument at the given position will be replaced by the
     * currently mapped element and appends the element to <code>appendAST</code>.
     *
     * @param appendAST
     * @param replacement an IAST there the argument at the given position is replaced by the currently mapped argument of this
     *                    IAST.
     * @param position
     * @return <code>appendAST</code>
     * @see IAST#map(Function, int)
     */
    IASTAppendable mapThread(IASTAppendable appendAST, final IAST replacement, int position);

    /**
     * Removes the object at the specified location from this {@code IAST}.
     *
     * @param location
     *            the index of the object to remove.
     * @return the removed object.
     * @throws UnsupportedOperationException
     *             if removing from this {@code IAST} is not supported.
     * @throws IndexOutOfBoundsException
     *             if {@code location < 0 || >= size()}
     */
    // public IExpr remove(int location);

    /**
     * Return <code>this</code> if <code>this</code> unequals <code>F.NIL</code> , otherwise return <code>other</code>.
     *
     * @param other
     * @return <code>this</code> if <code>this</code> unequals <code>F.NIL</code>, otherwise return <code>other</code>.
     * @see java.util.Optional#orElse(Object)
     */
    IAST orElse(final IAST other);

    /**
     * Calculate a special hash value for pattern matching
     *
     * @return
     */
    int patternHashCode();

    /**
     * Prepend an expression to this list.
     *
     * @param expr
     * @return <code>this</code> after prepending the given expression.
     */
    IASTAppendable prependClone(IExpr expr);

    /**
     * Removes all objects which satisfy the given predicate.
     *
     * @param predicate
     * @return <code>F.NIL</code> if no element could be removed
     */
    IASTAppendable remove(Predicate<? super IExpr> predicate);


    /**
     * Create a shallow copy of this <code>IAST</code> instance (the elements themselves are not copied) and remove the
     * element at the given <code>position</code>.
     *
     * @param position
     * @return an IAST with removed element at the given position.
     */
    IASTMutable removeAtCopy(int position);

    /**
     * Create a shallow copy of this <code>IAST</code> instance (the elements themselves are not copied) and remove the
     * element at the given <code>position</code>.
     *
     * @param i
     * @return a clone with removed element at the given position.
     */
    IASTAppendable removeAtClone(int position);

    /**
     * Copy to a new <code>IAST</code> and remove all arguments from position <code>1</code> inclusive to the
     * <code>firstPosition</code> exclusive of this AST.
     *
     * @param firstPosition
     * @return
     */
    public IAST removeFromStart(int firstPosition);

    /**
     * Create a new <code>IAST</code> and remove all arguments from position <code>fromPosition</code> inclusive to the
     * end of this AST.
     *
     * @param fromPosition
     * @return
     */
    IAST removeFromEnd(int fromPosition);

    /**
     * Append the elements in reversed order to the given <code>list</code>
     *
     * @param list
     * @return
     */
    IASTAppendable reverse(IASTAppendable list);

    /**
     * Rotate the elements to the left by n places and append the resulting elements to the <code>list</code>
     *
     * @param list
     * @param n
     * @return the given list
     */
    IAST rotateLeft(IASTAppendable list, final int n);

    /**
     * Rotate the elements to the right by n places and append the resulting elements to the <code>list</code>
     *
     * @param list
     * @param n
     * @return the given list
     */
    IAST rotateRight(IASTAppendable list, final int n);

    /**
     * Create a shallow copy of this <code>IAST</code> instance (the elements themselves are not copied) and set the
     * <code>expr</code> at the given <code>position</code>.
     *
     * @param i
     * @param expr
     * @return a clone with element set to <code>expr</code> at the given <code>position</code>.
     */
    IASTAppendable setAtClone(int i, IExpr expr);

    /**
     * Create a shallow copy of this <code>IAST</code> instance (the elements themselves are not copied) and set the
     * <code>expr</code> at the given <code>position</code>. In contrast to the <code>setAtClone()</code> method, this
     * method returns exactly the same type for <code>AST0, AST1, AST2, AST3</code>.
     *
     * @param i
     * @param expr
     * @return a copy with element set to <code>expr</code> at the given <code>position</code>.
     */
    IASTMutable setAtCopy(int i, IExpr expr);

    /**
     * Returns an array containing all elements contained in this {@code List}.
     *
     * @return an array of the elements from this {@code List}.
     */
    IExpr[] toArray();

    /**
     * The enumeration for the properties (keys) of the map possibly associated with this <code>IAST</code> object.
     */
    enum PROPERTY {
        CSS
    }

}
