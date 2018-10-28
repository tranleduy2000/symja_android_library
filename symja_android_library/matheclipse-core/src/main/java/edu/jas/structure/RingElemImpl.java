package edu.jas.structure;

public abstract class RingElemImpl<C extends RingElem<C>> implements RingElem<C> {
    @Override
    public C leftGcd(C b) {
        return gcd(b);
    }

    @Override
    public C rightGcd(C b) {
        return gcd(b);
    }
}
