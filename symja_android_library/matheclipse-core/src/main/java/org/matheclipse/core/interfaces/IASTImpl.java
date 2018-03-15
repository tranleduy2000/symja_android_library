package org.matheclipse.core.interfaces;

import com.duy.lambda.BiPredicate;
import com.duy.lambda.Consumer;
import com.duy.lambda.ObjIntConsumer;
import com.duy.lambda.Predicate;

import org.matheclipse.core.generic.ObjIntPredicate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * <p>
 * (I)nterface for the (A)bstract (S)yntax (T)ree of a given function.
 * </p>
 * <p>
 * <p>
 * In Symja, an abstract syntax tree (AST), is a tree representation of the abstract syntactic structure of the Symja
 * source code. Each node of the tree denotes a construct occurring in the source code. The syntax is 'abstract' in the
 * sense that it does not represent every detail that appears in the real syntax. For instance, grouping parentheses are
 * implicit in the tree structure, and a syntactic construct such as a <code>Sin(x)</code> expression will be denoted by
 * an AST with 2 nodes. One node for the header <code>Sin</code> and one node for the argument <code>x</code>.
 * </p>
 * <p>
 * Internally an AST is represented as a <code>java.util.List</code> which contains
 * <ul>
 * <li>the operator of a function (i.e. the &quot;header&quot;-symbol: Sin, Cos, Inverse, Plus, Times,...) at index
 * <code>0</code> and</li>
 * <li>the <code>n</code> arguments of a function in the index <code>1 to n</code></li>
 * </ul>
 * <p>
 * See <a href="http://en.wikipedia.org/wiki/Abstract_syntax_tree">Abstract syntax tree</a>,
 * <a href="https://en.wikipedia.org/wiki/Directed_acyclic_graph">Directed acyclic graph</a>
 */

public abstract class IASTImpl extends IExprImpl implements IAST {

    @Override
    public int argSize() {
        return argSize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IExpr base() {
        return arg1();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IExpr exponent() {
        return arg2();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IExpr first() {
        return arg1();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IExpr second() {
        return arg2();
    }

    @Override
    public IExpr last() {
        return get(argSize());
    }

    @Override
    public abstract IAST clone() throws CloneNotSupportedException;

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
    @Override
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }


    /**
     * Returns a shallow copy of this <code>IAST</code> instance (the elements themselves are not copied). In contrast
     * to the <code>clone()</code> method, this method returns exactly the same type for
     * <code>AST0, AST1, AST2,AST3</code>.
     *
     * @return a copy of this <code>IAST</code> instance.
     */
    @Override
    public IASTMutable copy() {
        return copyAppendable();
    }

    /**
     * Copy the arguments of this AST to a list.
     *
     * @return
     */
    @Override
    public List<IExpr> copyTo() {
        return (List<IExpr>) copyTo(new ArrayList<IExpr>(size()));
    }

    /**
     * Copy the arguments of this AST to a given collection object.
     *
     * @param collection
     * @return
     */
    @Override
    public Collection<IExpr> copyTo(Collection<IExpr> collection) {
        for (int i = 1; i < size(); i++) {
            collection.add(get(i));
        }
        return collection;
    }

    /**
     * Check all elements by applying the <code>predicate</code> to each argument in this <code>AST</code> and return if
     * one of the arguments satisfy the predicate.
     *
     * @param predicate the predicate which filters each argument in this <code>AST</code>
     * @return the <code>true</code> if the predicate is true the first time or <code>false</code> otherwise
     */
    @Override
    public boolean exists(ObjIntPredicate<? super IExpr> predicate) {
        return exists(predicate, 1);
    }

    /**
     * Check all elements by applying the <code>predicate</code> to each argument in this <code>AST</code> and return if
     * one of the arguments satisfy the predicate.
     *
     * @param predicate the predicate which filters each argument in this <code>AST</code>
     * @return the <code>true</code> if the predicate is true the first time or <code>false</code> otherwise
     */
    @Override
    public boolean exists(Predicate<? super IExpr> predicate) {
        return exists(predicate, 1);
    }

    /**
     * Compare the arguments pairwise with the <code>stopPredicate</code>. If the predicate gives <code>true</code>
     * return <code>true</code>. If the <code>stopPredicate</code> gives false for each pairwise comparison return the
     * <code>false</code> at the end.
     */
    @Override
    public boolean existsLeft(BiPredicate<IExpr, IExpr> stopPredicate) {
        int size = size();
        for (int i = 2; i < size; i++) {
            if (stopPredicate.test(get(i - 1), get(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check all elements by applying the <code>predicate</code> to each argument in this <code>AST</code> and return if
     * all of the arguments satisfy the predicate.
     *
     * @param predicate the predicate which filters each argument in this <code>AST</code>
     * @return the <code>true</code> if the predicate is true for all elements or <code>false</code> otherwise
     */
    @Override

    public boolean forAll(ObjIntPredicate<? super IExpr> predicate) {
        return forAll(predicate, 1);
    }

    /**
     * Check all elements by applying the <code>predicate</code> to each argument in this <code>AST</code> and return if
     * all of the arguments satisfy the predicate.
     *
     * @param predicate the predicate which filters each argument in this <code>AST</code>
     * @return the <code>true</code> if the predicate is true for all elements or <code>false</code> otherwise
     */
    @Override
    public boolean forAll(Predicate<? super IExpr> predicate) {
        return forAll(predicate, 1);
    }

    /**
     * Consume all elements generated by the given function from index <code>1</code> inclusive to <code>end</code>
     * exclusive.
     *
     * @param end    end index (exclusive)
     * @param action function which accepts the elements
     * @return <tt>this</tt>
     */
    @Override
    public void forEach(int end, Consumer<? super IExpr> action) {
        forEach(1, end, action);
    }

    /**
     * Consume all elements generated by the given function from index <code>start</code> inclusive to <code>end</code>
     * exclusive.
     *
     * @param start  start index (inclusive)
     * @param end    end index (exclusive)
     * @param action function which accepts the elements
     */
    @Override
    public void forEach(int start, int end, Consumer<? super IExpr> action) {
        for (int i = start; i < end; i++) {
            action.accept(get(i));
        }
    }

    @Override
    public void forEach(int start, int end, ObjIntConsumer<? super IExpr> action) {
        for (int i = start; i < end; i++) {
            action.accept(get(i), i);
        }
    }

    @Override
    public void forEach(int end, ObjIntConsumer<? super IExpr> action) {
        forEach(1, end, action);
    }

    @Override
    public void forEach(ObjIntConsumer<? super IExpr> action) {
        forEach(1, size(), action);
    }


    /**
     * Test if the last argument contains a pattern with a default argument.
     *
     * @return
     */
    @Override
    public boolean haspublicArgument() {
        if (size() > 1) {
            return last().isPatternDefault();
        }
        return false;
    }

    /**
     * Test if one of the arguments gives <code>true</code> for the <code>isNumericArgument()</code> method
     *
     * @return <code>true</code> if one of the arguments gives <code>true</code> for the
     * <code>isNumericArgument()</code> method
     */
    @Override
    public boolean hasNumericArgument() {
        int size = size();
        for (int i = 1; i < size; i++) {
            if (get(i).isNumericArgument()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Test if the last argument contains a pattern with an optional argument. (i.e. <code>x_:value</code>)
     *
     * @return
     */
    @Override
    public boolean hasOptionalArgument() {
        if (size() > 1) {
            return last().isPatternDefault();
        }
        return false;
    }

    /**
     * Check if the object at index 0 (i.e. the head of the list) is the same object as <code>head</code> and if the
     * size of the list is greater or equal <code>length</code>.
     *
     * @param head   object to compare with element at location <code>0</code>
     * @param length
     * @return
     */
    @Override
    public boolean isSameHeadSizeGE(IExpr head, int length) {
        int size = size();
        return head().equals(head) && length <= size;
    }

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
    @Override
    public IAST mapAt(IASTAppendable appendAST, final IAST replacement, int position) {
        return mapThread(appendAST, replacement, position);
    }

    @Override
    public IAST mapAt(final IASTAppendable replacement, int position) {
        return mapThread(replacement, position);
    }

    @Override
    public IASTAppendable rest() {
        return removeAtClone(1);
    }

    /**
     * Create a shallow copy of this <code>IAST</code> instance (the elements themselves are not copied) and set the
     * <code>expr</code> at the given <code>position</code>. In contrast to the <code>setAtClone()</code> method, this
     * method returns exactly the same type for <code>AST0, AST1, AST2, AST3</code>.
     *
     * @param i
     * @param expr
     * @return a copy with element set to <code>expr</code> at the given <code>position</code>.
     */
    @Override
    public IASTMutable setAtCopy(int i, IExpr expr) {
        IASTMutable ast = copy();
        ast.set(i, expr);
        return ast;
    }
}
