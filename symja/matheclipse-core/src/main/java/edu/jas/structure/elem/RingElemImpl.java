package edu.jas.structure.elem;

public abstract class RingElemImpl<C extends RingElem<C>>
         extends MonoidElemImpl<C> implements RingElem<C> {
    @Override
    public C leftGcd(C b) {
        return gcd(b);
    }

    @Override
    public C rightGcd(C b) {
        return gcd(b);
    }
}
