package cc.redberry.rings;

import org.hipparchus.random.RandomGenerator;
import org.hipparchus.random.Well19937c;
import org.hipparchus.random.Well44497b;

import java.util.Comparator;

import cc.redberry.rings.bigint.BigInteger;
import cc.redberry.rings.poly.AlgebraicNumberField;
import cc.redberry.rings.poly.FiniteField;
import cc.redberry.rings.poly.IPolynomial;
import cc.redberry.rings.poly.IPolynomialRing;
import cc.redberry.rings.poly.MultipleFieldExtension;
import cc.redberry.rings.poly.MultivariateRing;
import cc.redberry.rings.poly.QuotientRing;
import cc.redberry.rings.poly.SimpleFieldExtension;
import cc.redberry.rings.poly.UnivariateRing;
import cc.redberry.rings.poly.multivar.AMonomial;
import cc.redberry.rings.poly.multivar.AMultivariatePolynomial;
import cc.redberry.rings.poly.multivar.DegreeVector;
import cc.redberry.rings.poly.multivar.Ideal;
import cc.redberry.rings.poly.multivar.MonomialOrder;
import cc.redberry.rings.poly.multivar.MultivariatePolynomial;
import cc.redberry.rings.poly.multivar.MultivariatePolynomialZp64;
import cc.redberry.rings.poly.univar.IUnivariatePolynomial;
import cc.redberry.rings.poly.univar.IrreduciblePolynomials;
import cc.redberry.rings.poly.univar.UnivariatePolynomial;
import cc.redberry.rings.poly.univar.UnivariatePolynomialZp64;

/**
 * Common rings.
 *
 * @since 1.0
 */
public final class Rings {
    /**
     * Ring of integers (Z)
     */
    public static final Integers Z = Integers.Integers;
    /**
     * Field of rationals (Q)
     */
    public static final Rationals<BigInteger> Q = new Rationals<>(Z);
    /**
     * Ring of univariate polynomials over integers (Z[x])
     */
    public static final UnivariateRing<UnivariatePolynomial<BigInteger>> UnivariateRingZ = UnivariateRing(Z);
    /**
     * Ring of univariate polynomials over rationals (Q[x])
     */
    public static final UnivariateRing<UnivariatePolynomial<Rational<BigInteger>>> UnivariateRingQ = UnivariateRing(Q);
    /**
     * Field of Gaussian rationals (rational complex numbers).
     */
    public static AlgebraicNumberField<UnivariatePolynomial<Rational<BigInteger>>> GaussianRationals = GaussianNumbers(Q);
    /**
     * Ring of Gaussian integers (integer complex numbers).
     */
    public static AlgebraicNumberField<UnivariatePolynomial<BigInteger>> GaussianIntegers = GaussianNumbers(Z);
    static RandomGenerator privateRandom = new Well44497b(System.nanoTime());

    private Rings() {
    }

    /**
     * Ring of rational functions over specified ring
     *
     * @param ring the ring that numerators and denominators belong to
     */
    public static <E> Rationals<E> Frac(Ring<E> ring) {
        return new Rationals<>(ring);
    }

    /**
     * Ring of integers modulo {@code modulus} (with modulus < 2^63)
     *
     * @param modulus the modulus
     */
    public static IntegersZp64 Zp64(long modulus) {
        return new IntegersZp64(modulus);
    }

    /**
     * Ring of integers modulo {@code modulus} (arbitrary large modulus)
     *
     * @param modulus the modulus (arbitrary large)
     */
    public static IntegersZp Zp(long modulus) {
        return new IntegersZp(modulus);
    }

    /**
     * Ring of integers modulo {@code modulus} (arbitrary large modulus)
     *
     * @param modulus the modulus (arbitrary large)
     */
    public static IntegersZp Zp(BigInteger modulus) {
        return new IntegersZp(modulus);
    }

    /**
     * Galois field with the cardinality {@code prime ^ exponent} (with prime < 2^63).
     *
     * @param prime    the integer prime modulus
     * @param exponent the exponent (degree of modulo polynomial)
     */
    public static FiniteField<UnivariatePolynomialZp64> GF(long prime, int exponent) {
        if (exponent <= 0)
            throw new IllegalArgumentException("Exponent must be positive");
        // provide random generator with fixed seed to make the behavior predictable
        return new FiniteField<>(IrreduciblePolynomials.randomIrreduciblePolynomial(prime, exponent, new Well19937c(0x77f3dfae)));
    }

    /**
     * Galois field with the cardinality {@code prime ^ exponent} for arbitrary large {@code prime}
     *
     * @param prime    the integer (arbitrary large) prime modulus
     * @param exponent the exponent (degree of modulo polynomial)
     */
    public static FiniteField<UnivariatePolynomial<BigInteger>> GF(BigInteger prime, int exponent) {
        if (exponent <= 0)
            throw new IllegalArgumentException("Exponent must be positive");
        // provide random generator with fixed seed to make the behavior predictable
        return new FiniteField<>(IrreduciblePolynomials.randomIrreduciblePolynomial(Zp(prime), exponent, new Well19937c(0x77f3dfae)));
    }

    /**
     * Galois field with the specified minimal polynomial. Note: there is no explicit check that minimal polynomial is
     * irreducible
     *
     * @param irreducible irreducible univariate polynomial
     */
    public static <Poly extends IUnivariatePolynomial<Poly>> FiniteField<Poly> GF(Poly irreducible) {
        return new FiniteField<>(irreducible);
    }

    /**
     * Algebraic number field generated by the specified minimal polynomial
     */
    public static <Poly extends IUnivariatePolynomial<Poly>> AlgebraicNumberField<Poly>
    AlgebraicNumberField(Poly minimalPoly) {
        return new AlgebraicNumberField<>(minimalPoly);
    }

    /**
     * Gaussian numbers for a given ring (that is ring adjoined with imaginary unit)
     */
    public static <E> AlgebraicNumberField<UnivariatePolynomial<E>> GaussianNumbers(Ring<E> ring) {
        return AlgebraicNumberField(UnivariatePolynomial.create(ring, ring.createArray(ring.getOne(), ring.getZero(), ring.getOne())));
    }

    /**
     * Quotient ring {@code baseRing/<modulus> }
     *
     * @deprecated Use either {@link #GF(IUnivariatePolynomial)} or {@link #AlgebraicNumberField(IUnivariatePolynomial)}
     */
    @Deprecated
    public static <uPoly extends IUnivariatePolynomial<uPoly>>
    SimpleFieldExtension<uPoly>
    UnivariateQuotientRing(uPoly modulus) {
        return SimpleFieldExtension(modulus);
    }

    /**
     * Returns a simple field extension generated by given minimal polynomial
     */
    public static <uPoly extends IUnivariatePolynomial<uPoly>>
    SimpleFieldExtension<uPoly>
    SimpleFieldExtension(uPoly minimalPolynomial) {
        return minimalPolynomial.isOverFiniteField() ? GF(minimalPolynomial) : AlgebraicNumberField(minimalPolynomial);
    }

    /**
     * Multiple field extension generated by given algebraic elements represented by their minimal polynomials (not
     * tested that they are irreducible)
     */
    public static <
            Term extends AMonomial<Term>,
            mPoly extends AMultivariatePolynomial<Term, mPoly>,
            sPoly extends IUnivariatePolynomial<sPoly>
            > MultipleFieldExtension<Term, mPoly, sPoly>
    MultipleFieldExtension(sPoly... minimalPolynomials) {
        return MultipleFieldExtension.mkMultipleExtension(minimalPolynomials);
    }

    /**
     * Splitting field of a given polynomial.
     */
    public static <
            Term extends AMonomial<Term>,
            mPoly extends AMultivariatePolynomial<Term, mPoly>,
            sPoly extends IUnivariatePolynomial<sPoly>
            > MultipleFieldExtension<Term, mPoly, sPoly>
    SplittingField(sPoly polynomial) {
        return MultipleFieldExtension.mkSplittingField(polynomial);
    }

    /**
     * Ring of univariate polynomials over specified coefficient ring
     *
     * @param coefficientRing the coefficient ring
     */
    public static <E> UnivariateRing<UnivariatePolynomial<E>> UnivariateRing(Ring<E> coefficientRing) {
        return new UnivariateRing<>(UnivariatePolynomial.zero(coefficientRing));
    }

    /**
     * Ring of univariate polynomials with specified factory
     *
     * @param factory factory
     */
    public static <Poly extends IUnivariatePolynomial<Poly>> UnivariateRing<Poly> UnivariateRing(Poly factory) {
        return new UnivariateRing<>(factory);
    }

    /**
     * Ring of univariate polynomials over Zp integers (Zp[x])
     *
     * @param modulus the modulus
     */
    public static UnivariateRing<UnivariatePolynomialZp64> UnivariateRingZp64(long modulus) {
        return new UnivariateRing<>(UnivariatePolynomialZp64.zero(modulus));
    }

    /**
     * Ring of univariate polynomials over Zp integers (Zp[x])
     *
     * @param modulus the modulus
     */
    public static UnivariateRing<UnivariatePolynomialZp64> UnivariateRingZp64(IntegersZp64 modulus) {
        return new UnivariateRing<>(UnivariatePolynomialZp64.zero(modulus));
    }

    /**
     * Ring of univariate polynomials over Zp integers (Zp[x]) with arbitrary large modulus
     *
     * @param modulus the modulus (arbitrary large)
     */
    public static UnivariateRing<UnivariatePolynomial<BigInteger>> UnivariateRingZp(BigInteger modulus) {
        return UnivariateRing(Zp(modulus));
    }

    /**
     * Ring of multivariate polynomials with specified number of variables over specified coefficient ring
     *
     * @param nVariables      the number of variables
     * @param coefficientRing the coefficient ring
     * @param monomialOrder   the monomial order
     */
    public static <E> MultivariateRing<MultivariatePolynomial<E>>
    MultivariateRing(int nVariables, Ring<E> coefficientRing, Comparator<DegreeVector> monomialOrder) {
        return new MultivariateRing<>(MultivariatePolynomial.zero(nVariables, coefficientRing, monomialOrder));
    }

    /**
     * Ring of multivariate polynomials with specified number of variables over specified coefficient ring
     *
     * @param nVariables      the number of variables
     * @param coefficientRing the coefficient ring
     */
    public static <E> MultivariateRing<MultivariatePolynomial<E>>
    MultivariateRing(int nVariables, Ring<E> coefficientRing) {
        return MultivariateRing(nVariables, coefficientRing, MonomialOrder.DEFAULT);
    }

    /**
     * Ring of multivariate polynomials with specified factory
     *
     * @param factory factory
     */
    public static <Term extends AMonomial<Term>, Poly extends AMultivariatePolynomial<Term, Poly>>
    MultivariateRing<Poly> MultivariateRing(Poly factory) {
        return new MultivariateRing<>(factory);
    }

    /**
     * Ring of multivariate polynomials over integers (Z[x1, x2, ...])
     *
     * @param nVariables the number of variables
     */
    public static MultivariateRing<MultivariatePolynomial<BigInteger>>
    MultivariateRingZ(int nVariables) {
        return MultivariateRing(nVariables, Z);
    }

    /**
     * Ring of multivariate polynomials over rationals (Q[x1, x2, ...])
     *
     * @param nVariables the number of variables
     */
    public static MultivariateRing<MultivariatePolynomial<Rational<BigInteger>>>
    MultivariateRingQ(int nVariables) {
        return MultivariateRing(nVariables, Q);
    }

    /**
     * Ring of multivariate polynomials over Zp integers (Zp[x1, x2, ...])
     *
     * @param nVariables    the number of variables
     * @param modulus       the modulus
     * @param monomialOrder the monomial order
     */
    public static MultivariateRing<MultivariatePolynomialZp64>
    MultivariateRingZp64(int nVariables, long modulus, Comparator<DegreeVector> monomialOrder) {
        return new MultivariateRing<>(MultivariatePolynomialZp64.zero(nVariables, Zp64(modulus), monomialOrder));
    }

    /**
     * Ring of multivariate polynomials over Zp machine integers (Zp[x1, x2, ...])
     *
     * @param nVariables the number of variables
     * @param modulus    the modulus
     */
    public static MultivariateRing<MultivariatePolynomialZp64>
    MultivariateRingZp64(int nVariables, long modulus) {
        return MultivariateRingZp64(nVariables, modulus, MonomialOrder.DEFAULT);
    }

    /**
     * Ring of multivariate polynomials over Zp integers (Zp[x1, x2, ...])
     *
     * @param nVariables    the number of variables
     * @param modulus       the modulus
     * @param monomialOrder monomial order
     */
    public static MultivariateRing<MultivariatePolynomialZp64>
    MultivariateRingZp64(int nVariables, IntegersZp64 modulus, Comparator<DegreeVector> monomialOrder) {
        return new MultivariateRing<>(MultivariatePolynomialZp64.zero(nVariables, modulus, monomialOrder));
    }

    /**
     * Ring of multivariate polynomials over Zp integers (Zp[x1, x2, ...])
     *
     * @param nVariables the number of variables
     * @param modulus    the modulus
     */
    public static MultivariateRing<MultivariatePolynomialZp64>
    MultivariateRingZp64(int nVariables, IntegersZp64 modulus) {
        return MultivariateRingZp64(nVariables, modulus, MonomialOrder.DEFAULT);
    }

    /**
     * Ring of multivariate polynomials over Zp integers (Zp[x1, x2, ...]) with arbitrary large modulus
     *
     * @param nVariables the number of variables
     * @param modulus    the modulus (arbitrary large)
     */
    public static MultivariateRing<MultivariatePolynomial<BigInteger>>
    MultivariateRingZp(int nVariables, BigInteger modulus) {
        return MultivariateRing(nVariables, Zp(modulus));
    }

    /**
     * Generic factory for polynomial ring
     */
    @SuppressWarnings("unchecked")
    public static <Poly extends IPolynomial<Poly>> IPolynomialRing<Poly> PolynomialRing(Poly factory) {
        if (factory instanceof IUnivariatePolynomial)
            return (IPolynomialRing<Poly>) UnivariateRing((IUnivariatePolynomial) factory);
        else
            return (IPolynomialRing<Poly>) MultivariateRing((AMultivariatePolynomial) factory);
    }

    /**
     * Quotient ring {@code baseRing/<ideal> }
     */
    public static <Term extends AMonomial<Term>, Poly extends AMultivariatePolynomial<Term, Poly>>
    QuotientRing<Term, Poly>
    QuotientRing(MultivariateRing<Poly> baseRing, Ideal<Term, Poly> ideal) {
        return new QuotientRing<>(baseRing, ideal);
    }
}
