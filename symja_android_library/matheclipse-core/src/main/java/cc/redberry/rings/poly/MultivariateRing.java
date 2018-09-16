package cc.redberry.rings.poly;

import org.hipparchus.random.RandomGenerator;
import org.hipparchus.random.Well44497b;

import java.util.Comparator;
import java.util.function.Function;

import cc.redberry.rings.Ring;
import cc.redberry.rings.poly.multivar.AMonomial;
import cc.redberry.rings.poly.multivar.AMultivariatePolynomial;
import cc.redberry.rings.poly.multivar.DegreeVector;
import cc.redberry.rings.poly.multivar.IMonomialAlgebra;
import cc.redberry.rings.poly.multivar.MultivariateDivision;
import cc.redberry.rings.poly.multivar.MultivariateFactorization;
import cc.redberry.rings.poly.multivar.MultivariateGCD;
import cc.redberry.rings.poly.multivar.MultivariatePolynomial;
import cc.redberry.rings.poly.multivar.MultivariateSquareFreeFactorization;
import cc.redberry.rings.poly.multivar.RandomMultivariatePolynomials;

/**
 * Ring of multivariate polynomials.
 *
 * @param <Poly> type of multivariate polynomials
 * @since 1.0
 */
public final class MultivariateRing<Poly extends AMultivariatePolynomial<?, Poly>> extends APolynomialRing<Poly> {
    /**
     * Default degree of polynomial generated with {@link #randomElementTree(RandomGenerator)}
     */
    public static final int DEGREE_OF_RANDOM_POLY = 16;
    /**
     * Default size of polynomial generated with {@link #randomElementTree(RandomGenerator)}
     */
    public static final int SIZE_OF_RANDOM_POLY = 16;
    private static final long serialVersionUID = 1L;
    private static final RandomGenerator privateRandom = new Well44497b(System.nanoTime());

    /**
     * Creates ring of multivariate polynomials which support operations over multivariate polynomials of the type and
     * number of variables same as of provided {@code factory} polynomial
     *
     * @param factory the factory polynomial (the exact value of {@code factory} is irrelevant) which fixes the element
     *                type of this ring, coefficient ring and the number of variables
     */
    public MultivariateRing(Poly factory) {
        super(factory);
    }

    @SuppressWarnings("unchecked")
    public <Term extends AMonomial<Term>> IMonomialAlgebra<Term> monomialAlgebra() {
        IMonomialAlgebra<?> monomialAlgebra = factory.monomialAlgebra;
        return (IMonomialAlgebra<Term>) monomialAlgebra;
    }

    @Override
    public int nVariables() {
        return factory.nVariables;
    }

    public Comparator<DegreeVector> ordering() {
        return factory.ordering;
    }

    public MultivariateRing<Poly> dropVariable() {
        return new MultivariateRing<>(factory.dropVariable(0));
    }

    @Override
    @SuppressWarnings("unchecked")
    public Poly[] divideAndRemainder(Poly dividend, Poly divider) {
        Poly[] arr = divider.createArray(1);
        arr[0] = divider;
        return (Poly[]) MultivariateDivision.divideAndRemainder((AMultivariatePolynomial) dividend, (AMultivariatePolynomial[]) arr);
    }

    @Override
    public Poly gcd(Poly a, Poly b) {
        return MultivariateGCD.PolynomialGCD(a, b);
    }

    @Override
    public Poly gcd(Poly[] elements) {
        return MultivariateGCD.PolynomialGCD(elements);
    }

    @Override
    public Poly gcd(Iterable<Poly> elements) {
        return MultivariateGCD.PolynomialGCD(elements);
    }

    @Override
    @SuppressWarnings("unchecked")
    public PolynomialFactorDecomposition<Poly> factorSquareFree(Poly element) {
        return (PolynomialFactorDecomposition<Poly>) MultivariateSquareFreeFactorization.SquareFreeFactorization((AMultivariatePolynomial) element);
    }

    @Override
    public PolynomialFactorDecomposition<Poly> factor(Poly element) {
        return MultivariateFactorization.Factor(element);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Poly variable(int variable) {
        return factory.createMonomial(variable, 1);
    }

    /**
     * Creates multivariate polynomial over the same ring as this with the single monomial
     *
     * @param term the monomial
     * @return multivariate polynomial
     */
    @SuppressWarnings("unchecked")
    public Poly create(DegreeVector term) {
        return factory.create(term);
    }

    /**
     * Generates random multivariate polynomial
     *
     * @param degree maximal degree of the result
     * @param size   number of elements in the result
     * @param rnd    random source
     * @return random polynomial
     */
    @SuppressWarnings("unchecked")
    public Poly randomElement(int degree, int size, RandomGenerator rnd) {
        return (Poly) RandomMultivariatePolynomials.randomPolynomial((AMultivariatePolynomial) factory, degree, size, rnd);
    }

    /**
     * Generates random multivariate polynomial
     *
     * @param degree maximal degree of the result
     * @param size   number of elements in the result
     * @param rnd    random source
     * @return random polynomial
     */
    @SuppressWarnings("unchecked")
    public Poly randomElementTree(int degree, int size, RandomGenerator rnd) {
        if (factory instanceof MultivariatePolynomial) {
            MultivariatePolynomial f = (MultivariatePolynomial) this.factory;
            Ring cfRing = f.ring;
            Function<RandomGenerator, ?> method = cfRing::randomElementTree;
            return (Poly) RandomMultivariatePolynomials.randomPolynomial(nVariables(), degree, size, cfRing,
                    ((MultivariatePolynomial) factory).ordering, method, rnd);
        } else
            return randomElement(degree, size, rnd);
    }

    /**
     * Generates random multivariate polynomial
     *
     * @param degree maximal degree of the result
     * @param size   number of elements in the result
     * @return random polynomial
     */
    @SuppressWarnings("unchecked")
    public Poly randomElement(int degree, int size) {
        return randomElement(degree, size, privateRandom);
    }

    /**
     * Gives a random constant polynomial. For generating non-constant random polynomials see {@link
     * RandomMultivariatePolynomials}
     *
     * @param rnd the source of randomness
     * @return random constant polynomial
     * @see RandomMultivariatePolynomials
     */
    @Override
    public Poly randomElement(RandomGenerator rnd) {
        return super.randomElement(rnd);
    }

    @Override
    public Poly randomElementTree(RandomGenerator rnd) {
        return randomElementTree(DEGREE_OF_RANDOM_POLY, SIZE_OF_RANDOM_POLY, rnd);
    }
}
