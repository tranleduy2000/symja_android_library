package cc.redberry.rings;

import com.duy.lambda.Function;

import org.hipparchus.random.RandomGenerator;

import java.util.Iterator;

import cc.redberry.rings.bigint.BigInteger;
import cc.redberry.rings.io.IStringifier;

/**
 * The ring of rationals (Q).
 *
 * @since 1.0
 */
public final class Rationals<E> implements Ring<Rational<E>> {
    private static final long serialVersionUID = 1L;
    /**
     * Ring that numerator and denominator belongs to
     */
    public final Ring<E> ring;

    public Rationals(Ring<E> ring) {
        this.ring = ring;
    }

    /**
     * Gives rational with a given numerator and unit denominator
     */
    public Rational<E> mkNumerator(E num) {
        return new Rational<>(ring, num);
    }

    /**
     * Gives rational with a given numerator and unit denominator
     */
    public Rational<E> mkNumerator(long num) {
        return mkNumerator(ring.valueOf(num));
    }

    /**
     * Gives rational with a given denominator and unit numerator
     */
    public Rational<E> mkDenominator(E den) {
        return new Rational<>(ring, ring.getOne(), den);
    }

    /**
     * Gives rational with a given denominator and unit numerator
     */
    public Rational<E> mkDenominator(long den) {
        return mkDenominator(ring.valueOf(den));
    }

    /**
     * Gives rational with a given numerator and denominator
     */
    public Rational<E> mk(E num, E den) {
        return new Rational<>(ring, num, den);
    }

    /**
     * Gives rational with a given numerator and denominator
     */
    public Rational<E> mk(long num, long den) {
        return new Rational<>(ring, ring.valueOf(num), ring.valueOf(den));
    }

    @Override
    public boolean isField() {
        return true;
    }

    @Override
    public boolean isEuclideanRing() {
        return true;
    }

    @Override
    public BigInteger cardinality() {
        return null;
    }

    @Override
    public BigInteger characteristic() {
        return BigInteger.ZERO;
    }

    @Override
    public boolean isPerfectPower() {
        return false;
    }

    @Override
    public BigInteger perfectPowerBase() {
        return null;
    }

    @Override
    public BigInteger perfectPowerExponent() {
        return null;
    }

    @Override
    public Rational<E> add(Rational<E> a, Rational<E> b) {
        return a.add(b);
    }

//    @Override
//    public Rational<E> addMutable(Rational<E> a, Rational<E> b) {
//        return a.addMutable(b);
//    }

    @Override
    public Rational<E> subtract(Rational<E> a, Rational<E> b) {
        return a.subtract(b);
    }

//    @Override
//    public Rational<E> subtractMutable(Rational<E> a, Rational<E> b) {
//        return a.subtractMutable(b);
//    }

    @Override
    public Rational<E> multiply(Rational<E> a, Rational<E> b) {
        return a.multiply(b);
    }

//    @Override
//    public Rational<E> multiplyMutable(Rational<E> a, Rational<E> b) {
//        return a.multiplyMutable(b);
//    }

    @Override
    public Rational<E> negate(Rational<E> element) {
        return element.negate();
    }

//    @Override
//    public Rational<E> negateMutable(Rational<E> element) {
//        return element.negateMutable();
//    }

    @Override
    public int signum(Rational<E> element) {
        return element.signum();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Rational<E>[] divideAndRemainder(Rational<E> dividend, Rational<E> divider) {
        return new Rational[]{dividend.divide(divider), Rational.zero(ring)};
    }

//    @Override
//    public Rational<E> divideExactMutable(Rational<E> dividend, Rational<E> divider) {
//        return dividend.divideMutable(divider);
//    }

    @Override
    public Rational<E> reciprocal(Rational<E> element) {
        return element.reciprocal();
    }

    @Override
    public Rational<E> gcd(Rational<E> a, Rational<E> b) {
        return Rational.one(ring);
    }

    private FactorDecomposition<Rational<E>> factor(Rational<E> element, Function<E, FactorDecomposition<E>> factor) {
        FactorDecomposition<E> numFactors = FactorDecomposition.empty(ring);
        for (E e : element.numerator) {
            FactorDecomposition<E> es = factor.apply(e);
            numFactors = numFactors.addAll(es);
        }
        FactorDecomposition<Rational<E>> factors = FactorDecomposition.empty(this);

        for (int i = 0; i < numFactors.size(); i++)
            factors.addNonUnitFactor(new Rational<>(ring, numFactors.get(i)), numFactors.getExponent(i));
        factors.addFactor(new Rational<>(ring, numFactors.unit), 1);

        FactorDecomposition<E> denFactors = FactorDecomposition.empty(ring);
        for (E e : element.denominator) {
            FactorDecomposition<E> es = factor.apply(e);
            denFactors = denFactors.addAll(es);
        }
        for (int i = 0; i < denFactors.size(); i++)
            factors.addNonUnitFactor(new Rational<>(ring, ring.getOne(), denFactors.get(i)), denFactors.getExponent(i));
        factors.addFactor(new Rational<>(ring, ring.getOne(), denFactors.unit), 1);

        return factors;
    }

    @Override
    public FactorDecomposition<Rational<E>> factorSquareFree(Rational<E> element) {
        return factor(element, ring::factorSquareFree);
    }

    @Override
    public FactorDecomposition<Rational<E>> factor(Rational<E> element) {
        return factor(element, ring::factor);
    }

    @Override
    public Rational<E> getZero() {
        return Rational.zero(ring);
    }

    @Override
    public Rational<E> getOne() {
        return Rational.one(ring);
    }

    @Override
    public boolean isZero(Rational element) {
        return element.isZero();
    }

    @Override
    public boolean isOne(Rational element) {
        return element.isOne();
    }

    @Override
    public boolean isUnit(Rational element) {
        return !isZero(element);
    }

    @Override
    public Rational<E> valueOf(long val) {
        return new Rational<>(ring, ring.valueOf(val));
    }

    @Override
    public Rational<E> valueOfBigInteger(BigInteger val) {
        return new Rational<>(ring, ring.valueOfBigInteger(val));
    }

    @Override
    public Rational<E> copy(Rational<E> element) {
        return new Rational<>(true, ring, element.numerator.deepCopy(), element.denominator.deepCopy());
    }

    @Override
    public Rational<E> valueOf(Rational<E> val) {
        if (val.ring.equals(ring))
            return val;
        else
            return new Rational<>(ring, val.numerator.map(ring::valueOf), val.denominator.map(ring::valueOf));
    }

    @Override
    @SuppressWarnings("unchecked")
    public Rational<E>[][] createArray2d(int length) {
        return new Rational[length][];
    }

    @Override
    @SuppressWarnings("unchecked")
    public Rational<E>[][] createArray2d(int m, int n) {
        return new Rational[m][n];
    }

    @Override
    public int compare(Rational<E> o1, Rational<E> o2) {
        return o1.compareTo(o2);
    }

    @Override
    public Rational<E> getNegativeOne() {
        return Rational.one(ring).negate();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Rational<E>[] createArray(int length) {
        return new Rational[length];
    }

    @Override
    public Rational<E> randomElement(RandomGenerator rnd) {
        long den;
        E eden;
        do {
            den = rnd.nextInt();
        } while (ring.isZero(eden = ring.valueOf(den)));
        return new Rational<>(ring, ring.valueOf(rnd.nextInt()), eden);
    }

    @Override
    public Rational<E> randomElementTree(RandomGenerator rnd) {
        E den;
        do {
            den = ring.randomElementTree(rnd);
        } while (ring.isZero(den));
        return new Rational<>(ring, ring.randomElementTree(rnd), den);
    }

    @Override
    public Iterator<Rational<E>> iterator() {
        throw new UnsupportedOperationException("Ring of infinite cardinality.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rationals<?> rationals = (Rationals<?>) o;

        return ring.equals(rationals.ring);
    }

    @Override
    public int hashCode() {
        return ring.hashCode();
    }

    @Override
    public String toString(IStringifier<Rational<E>> stringifier) {
        return ring.equals(Rings.Z) ? "Q" : "Frac(" + ring.toString(stringifier.substringifier(ring)) + ")";
    }

    @Override
    public String toString() {
        return toString(IStringifier.dummy());
    }
}
