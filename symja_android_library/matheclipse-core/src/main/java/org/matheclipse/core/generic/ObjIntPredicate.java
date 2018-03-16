package org.matheclipse.core.generic;

import com.duy.util.DObjects;

import com.duy.lambda.BiPredicate;

/**
 * <p>
 * A predicate of two arguments - one object and one {@code int}.
 * </p>
 * <p>
 * This takes two arguments and returns a {@code boolean} result.
 * </p>
 *
 * @param <T>
 *            the type of the object parameter
 * @see BiPredicate
 */
@FunctionalInterface
public interface ObjIntPredicate<T> {

	/**
	 * Evaluates the predicate.
	 *
	 * @param obj
	 *            the first argument
	 * @param value
	 *            the second argument
	 * @return true if the arguments match the predicate
	 */
	boolean test(T obj, int value);

	/**
	 * Returns a new predicate that returns true if both predicates return true.
	 * <p>
	 * The second predicate is only invoked if the first returns true.
	 *
	 * @param other
	 *            the second predicate
	 * @return the combined predicate, "this AND that"
	 * @throws NullPointerException
	 *             if the other predicate is null
	 */
	default ObjIntPredicate<T> and(ObjIntPredicate<? super T> other) {
		DObjects.requireNonNull(other);
		return new ObjIntPredicate<T>() {
			@Override
			public boolean test(T obj, int value) {
				return ObjIntPredicate.this.test(obj, value) && other.test(obj, value);
			}
		};
	}

	/**
	 * Returns a new predicate that returns true if either predicates returns true.
	 * <p>
	 * The second predicate is only invoked if the first returns false.
	 *
	 * @param other
	 *            the second predicate
	 * @return the combined predicate, "this OR that"
	 * @throws NullPointerException
	 *             if the other predicate is null
	 */
	default ObjIntPredicate<T> or(ObjIntPredicate<? super T> other) {
		DObjects.requireNonNull(other);
		return new ObjIntPredicate<T>() {
            @Override
            public boolean test(T obj, int value) {
                return ObjIntPredicate.this.test(obj, value) || other.test(obj, value);
            }
        };
	}

	/**
	 * Returns a new predicate that negates the result of this predicate.
	 *
	 * @return the predicate, "NOT this"
	 */
	default ObjIntPredicate<T> negate() {
		return new ObjIntPredicate<T>() {
			@Override
			public boolean test(T obj, int value) {
				return !ObjIntPredicate.this.test(obj, value);
			}
		};
	}

}