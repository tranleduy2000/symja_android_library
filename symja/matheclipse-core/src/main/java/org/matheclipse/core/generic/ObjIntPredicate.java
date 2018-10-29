package org.matheclipse.core.generic;

import com.duy.lambda.BiPredicate;

/**
 * <p>
 * A predicate of two arguments - one object and one {@code int}.
 * </p>
 * <p>
 * This takes two arguments and returns a {@code boolean} result.
 * </p>
 *
 * @param <T> the type of the object parameter
 * @see BiPredicate
 */
public interface ObjIntPredicate<T> {

    /**
     * Evaluates the predicate.
     *
     * @param obj   the first argument
     * @param value the second argument
     * @return true if the arguments match the predicate
     */
    public abstract boolean test(T obj, int value);

}