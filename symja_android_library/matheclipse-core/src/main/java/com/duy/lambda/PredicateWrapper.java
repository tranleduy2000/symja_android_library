package com.duy.lambda;

public class PredicateWrapper<T> {
    private Predicate<T> predicate;

    public PredicateWrapper(Predicate<T> predicate) {
        this.predicate = predicate;
    }

    /**
     * Returns a predicate that represents the logical negation of this
     * predicate.
     *
     * @return a predicate that represents the logical negation of this
     * predicate
     */
    public Predicate<T> negate() {
        return new Predicate<T>() {
            @Override
            public boolean test(T t) {
                return !PredicateWrapper.this.test(t);
            }
        };
    }

    private boolean test(T t) {
        return predicate.test(t);
    }
}
