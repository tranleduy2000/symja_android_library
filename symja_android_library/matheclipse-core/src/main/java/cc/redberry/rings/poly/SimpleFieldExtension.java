package cc.redberry.rings.poly;

import org.hipparchus.random.RandomGenerator;

import java.lang.reflect.Array;

import cc.redberry.rings.ARing;
import cc.redberry.rings.FactorDecomposition;
import cc.redberry.rings.bigint.BigInteger;
import cc.redberry.rings.bigint.BigIntegerUtil;
import cc.redberry.rings.io.IStringifier;
import cc.redberry.rings.poly.multivar.AMonomial;
import cc.redberry.rings.poly.multivar.AMultivariatePolynomial;
import cc.redberry.rings.poly.multivar.MonomialOrder;
import cc.redberry.rings.poly.multivar.MultivariatePolynomial;
import cc.redberry.rings.poly.multivar.MultivariatePolynomialZp64;
import cc.redberry.rings.poly.multivar.MultivariateResultants;
import cc.redberry.rings.poly.univar.IUnivariatePolynomial;
import cc.redberry.rings.poly.univar.IrreduciblePolynomials;
import cc.redberry.rings.poly.univar.RandomUnivariatePolynomials;
import cc.redberry.rings.poly.univar.UnivariateDivision;
import cc.redberry.rings.poly.univar.UnivariateDivision.InverseModMonomial;
import cc.redberry.rings.poly.univar.UnivariateGCD;
import cc.redberry.rings.poly.univar.UnivariatePolynomial;
import cc.redberry.rings.poly.univar.UnivariatePolynomialZp64;
import cc.redberry.rings.poly.univar.UnivariateResultants;
import cc.redberry.rings.poly.univar.UnivariateSquareFreeFactorization;

import static cc.redberry.rings.poly.univar.UnivariatePolynomialArithmetic.polyAddMod;
import static cc.redberry.rings.poly.univar.UnivariatePolynomialArithmetic.polyMod;
import static cc.redberry.rings.poly.univar.UnivariatePolynomialArithmetic.polyMultiplyMod;
import static cc.redberry.rings.poly.univar.UnivariatePolynomialArithmetic.polyNegateMod;
import static cc.redberry.rings.poly.univar.UnivariatePolynomialArithmetic.polySubtractMod;

/**
 * A simple field extension {@code F(α)} represented as a univariate quotient ring {@code F[x]/<m(x)>} where {@code
 * m(x)} is the minimal polynomial of {@code α}. Elements of extension field are represented as univariate polynomials
 * in {@code α}. To create simple field extensions one should use either {@link FiniteField} for extensions of finite
 * fields or {@link AlgebraicNumberField} for extensions of rationals. See {@link MultipleFieldExtension} for
 * implementation of multiple extensions.
 *
 * @see FiniteField
 * @see AlgebraicNumberField
 * @see cc.redberry.rings.Rings#SimpleFieldExtension(IUnivariatePolynomial)
 * @see MultipleFieldExtension
 * @since 2.5
 */
public abstract class SimpleFieldExtension<E extends IUnivariatePolynomial<E>>
        extends ARing<E> implements IPolynomialRing<E> {
    private static final long serialVersionUID = 1L;
    /**
     * Minimal polynomial
     */
    final E minimalPoly;
    /**
     * Factory polynomial
     */
    final E factory;
    /**
     * Precomputed inverses for fast division
     */
    final InverseModMonomial<E> inverseMod;
    /**
     * Ring cardinality
     */
    final BigInteger cardinality;

    /**
     * Constructs a simple field extension {@code F(α)} generated by the algebraic number {@code α} with the specified
     * minimal polynomial.
     * <p>
     * <p><b>NOTE:</b> irreducibility test for the minimal polynomial is not performed here, use {@link
     * IrreduciblePolynomials#irreducibleQ(IUnivariatePolynomial)} to test irreducibility.
     *
     * @param minimalPoly the minimal polynomial
     */
    protected SimpleFieldExtension(E minimalPoly) {
        minimalPoly = minimalPoly.monic();
        if (minimalPoly == null)
            throw new IllegalArgumentException("Minimal polynomial must be monic");
        this.minimalPoly = minimalPoly;
        this.factory = minimalPoly.clone();
        this.inverseMod = UnivariateDivision.fastDivisionPreConditioning(minimalPoly);
        this.cardinality = minimalPoly.coefficientRingCardinality() == null
                ? null
                : BigIntegerUtil.pow(minimalPoly.coefficientRingCardinality(), minimalPoly.degree());
    }

    private static <E> UnivariatePolynomial<E>
    normOfPolynomialE(SimpleFieldExtension<UnivariatePolynomial<E>> ring,
                      UnivariatePolynomial<UnivariatePolynomial<E>> poly) {
        return MultivariateResultants.Resultant(
                ring.minimalPoly.asMultivariate(MonomialOrder.DEFAULT).setNVariables(2), // to bivariate
                MultivariatePolynomial.asNormalMultivariate(poly.asMultivariate(), 0),
                0).asUnivariate();
    }

    private static UnivariatePolynomialZp64
    normOfPolynomialZp64(SimpleFieldExtension<UnivariatePolynomialZp64> ring,
                         UnivariatePolynomial<UnivariatePolynomialZp64> poly) {
        return MultivariateResultants.Resultant(
                ring.minimalPoly.asMultivariate(MonomialOrder.DEFAULT).setNVariables(2),
                MultivariatePolynomialZp64.asNormalMultivariate(poly.asMultivariate(), 0),
                0).asUnivariate();
    }

    private static <E> MultivariatePolynomial<E>
    normOfPolynomialE(SimpleFieldExtension<UnivariatePolynomial<E>> ring,
                      MultivariatePolynomial<UnivariatePolynomial<E>> poly) {
        return MultivariateResultants.Resultant(
                ring.minimalPoly.asMultivariate(MonomialOrder.DEFAULT).setNVariables(poly.nVariables + 1),
                MultivariatePolynomial.asNormalMultivariate(poly, 0),
                0).dropVariable(0);
    }

    private static MultivariatePolynomialZp64
    normOfPolynomialZp64(SimpleFieldExtension<UnivariatePolynomialZp64> ring,
                         MultivariatePolynomial<UnivariatePolynomialZp64> poly) {
        return MultivariateResultants.Resultant(
                ring.minimalPoly.asMultivariate(MonomialOrder.DEFAULT).setNVariables(poly.nVariables + 1),
                MultivariatePolynomialZp64.asNormalMultivariate(poly, 0),
                0).dropVariable(0);
    }

    /**
     * Returns whether the given element belongs to the base field
     */
    public boolean isInTheBaseField(E element) {
        return element.isConstant();
    }

    /**
     * Returns the generator element {@code α} of this field extension {@code F(α)}
     */
    public E generator() {
        return minimalPoly.createMonomial(1);
    }

    /**
     * Returns the degree of this filed extension (that is the degree of minimal polynomial)
     */
    public int degree() {
        return minimalPoly.degree();
    }

    /**
     * Returns the minimal polynomial of the generator (that is the "modulo" polynomial {@code p(x)} of this field
     * viewed as quotient field {@code F[x]/<p(x)>})
     */
    public E getMinimalPolynomial() {
        return minimalPoly.clone();
    }

    /**
     * INTERNAL
     **/
    public E getMinimalPolynomialRef() {
        return minimalPoly;
    }

    /**
     * Gives the norm of field extension element (it is always belongs to the base field)
     */
    public E norm(E element) {
        return UnivariateResultants.ResultantAsPoly(minimalPoly, element);
    }

    /**
     * Gives the product of all conjugates of given element (except element itself), that is {@code norm(element) /
     * element}
     */
    public E conjugatesProduct(E element) {
        return divideExact(norm(element), element);
    }

    /**
     * Gives the trace of field extension element (it is always belongs to the base field)
     */
    public E trace(E element) {
        E minimalPoly = minimalPolynomial(element);
        return negate(divideExact(minimalPoly.getAsPoly(minimalPoly.degree() - 1), minimalPoly.lcAsPoly()));
    }

    /**
     * Gives the norm of univariate polynomial over this field extension, which is always a polynomial with the
     * coefficients from the base field
     */
    @SuppressWarnings("unchecked")
    public E normOfPolynomial(UnivariatePolynomial<E> poly) {
        if (!poly.ring.equals(this))
            throw new IllegalArgumentException();
        if (minimalPoly instanceof UnivariatePolynomial)
            return (E) normOfPolynomialE((SimpleFieldExtension) this, (UnivariatePolynomial) poly);
        if (minimalPoly instanceof UnivariatePolynomialZp64)
            return (E) normOfPolynomialZp64((SimpleFieldExtension) this, (UnivariatePolynomial) poly);
        throw new RuntimeException();
    }

    /**
     * Gives the norm of multivariate polynomial over this field extension, which is always a polynomial with the
     * coefficients from the base field.
     */
    @SuppressWarnings("unchecked")
    public <MPoly extends AMultivariatePolynomial>
    MPoly normOfPolynomial(MultivariatePolynomial<E> poly) {
        if (!poly.ring.equals(this))
            throw new IllegalArgumentException();
        if (minimalPoly instanceof UnivariatePolynomial)
            return (MPoly) normOfPolynomialE((SimpleFieldExtension) this, (MultivariatePolynomial) poly);
        if (minimalPoly instanceof UnivariatePolynomialZp64)
            return (MPoly) normOfPolynomialZp64((SimpleFieldExtension) this, (MultivariatePolynomial) poly);
        throw new RuntimeException();
    }

    /**
     * Computes minimal polynomial of a given algebraic element
     */
    public E minimalPolynomial(E element) {
        //if (element.equals(getOne()))
        //    return getMinimalPolynomial();
        UnivariatePolynomial<E> es = UnivariatePolynomial.create(this, createArray(negate(element), getOne()));
        return UnivariateSquareFreeFactorization.SquareFreePart(normOfPolynomial(es));
    }

    /**
     * Returns a view of this as a multiple field extension
     */
    public <Term extends AMonomial<Term>, mPoly extends AMultivariatePolynomial<Term, mPoly>>
    MultipleFieldExtension<Term, mPoly, E> asMultipleExtension() {
        return MultipleFieldExtension.mkMultipleExtension(this);
    }

    @Override
    public int nVariables() {
        return 1;
    }

    @Override
    public E factory() {
        return factory;
    }

    @Override
    public boolean isEuclideanRing() {
        return minimalPoly.isOverField();
    }

    @Override
    public BigInteger cardinality() {
        return cardinality;
    }

    @Override
    public BigInteger characteristic() {
        return minimalPoly.coefficientRingCharacteristic();
    }

    /**
     * empiric to switch between fast and plain division
     */
    protected boolean shouldReduceFast(int dividendDegree) {
        int mDeg = minimalPoly.degree();
        if (dividendDegree < mDeg)
            return false;
        if (isFiniteField()) {
            if (mDeg < 8)
                return false;
            int defect = dividendDegree / mDeg;
            if (mDeg <= 20)
                return defect <= 16;
            else
                return defect <= 30;
        } else
            return false;
    }

    @Override
    public E add(E a, E b) {
        return shouldReduceFast(Math.max(a.degree(), b.degree()))
                ? polyAddMod(a, b, minimalPoly, inverseMod, true)
                : polyAddMod(a, b, minimalPoly, true);
    }

    @Override
    public E subtract(E a, E b) {
        return shouldReduceFast(Math.max(a.degree(), b.degree()))
                ? polySubtractMod(a, b, minimalPoly, inverseMod, true)
                : polySubtractMod(a, b, minimalPoly, true);
    }

    @Override
    public E multiply(E a, E b) {
        return shouldReduceFast(a.degree() + b.degree())
                ? polyMultiplyMod(a, b, minimalPoly, inverseMod, true)
                : polyMultiplyMod(a, b, minimalPoly, true);
    }

    @Override
    public E negate(E element) {
        return shouldReduceFast(element.degree())
                ? polyNegateMod(element, minimalPoly, inverseMod, true)
                : polyNegateMod(element, minimalPoly, true);
    }

    @Override
    public E addMutable(E a, E b) {
        return shouldReduceFast(Math.max(a.degree(), b.degree()))
                ? polyAddMod(a, b, minimalPoly, inverseMod, false)
                : polyAddMod(a, b, minimalPoly, false);
    }

    @Override
    public E subtractMutable(E a, E b) {
        return shouldReduceFast(Math.max(a.degree(), b.degree()))
                ? polySubtractMod(a, b, minimalPoly, inverseMod, false)
                : polySubtractMod(a, b, minimalPoly, false);
    }

    @Override
    public E multiplyMutable(E a, E b) {
        return shouldReduceFast(a.degree() + b.degree())
                ? polyMultiplyMod(a, b, minimalPoly, inverseMod, false)
                : polyMultiplyMod(a, b, minimalPoly, false);
    }

    @Override
    public E negateMutable(E element) {
        return shouldReduceFast(element.degree())
                ? polyNegateMod(element, minimalPoly, inverseMod, false)
                : polyNegateMod(element, minimalPoly, false);
    }

    @Override
    public E reciprocal(E element) {
        if (element.isZero())
            throw new ArithmeticException("divide by zero");
        if (isOne(element))
            return element;
        if (isMinusOne(element))
            return element;

        E[] xgcd = UnivariateGCD.PolynomialFirstBezoutCoefficient(element, minimalPoly);
        assert xgcd[0].isConstant();
        return xgcd[1].divideByLC(xgcd[0]);
    }

    @Override
    public FactorDecomposition<E> factor(E element) {
        return FactorDecomposition.unit(this, element);
    }

    @Override
    public E getZero() {
        return minimalPoly.createZero();
    }

    @Override
    public E getOne() {
        return minimalPoly.createOne();
    }

    @Override
    public boolean isZero(E element) {
        return element.isZero();
    }

    @Override
    public boolean isOne(E element) {
        return element.isOne();
    }

    @Override
    public E valueOf(long val) {
        return getOne().multiply(val);
    }

    @Override
    public E valueOfBigInteger(BigInteger val) {
        return getOne().multiplyByBigInteger(val);
    }

    @Override
    public E valueOf(E val) {
        return shouldReduceFast(val.degree())
                ? polyMod(val.setCoefficientRingFrom(factory), minimalPoly, inverseMod, false)
                : polyMod(val.setCoefficientRingFrom(factory), minimalPoly, false);
    }

    @Override
    public E copy(E element) {
        return element.clone();
    }

    @Override
    public E[] createArray(int length) {
        return minimalPoly.createArray(length);
    }

    @Override
    @SuppressWarnings("unchecked")
    public E[][] createArray2d(int length) {
        E[] array = createArray(0);
        return (E[][]) Array.newInstance(array.getClass(), length);
    }

    @Override
    public E[][] createArray2d(int m, int n) {
        E[][] arr = createArray2d(m);
        for (int i = 0; i < arr.length; i++)
            arr[i] = createArray(n);
        return arr;
    }

    @Override
    public int compare(E o1, E o2) {
        return o1.compareTo(o2);
    }

    @Override
    public E randomElement(RandomGenerator rnd) {
        E r = RandomUnivariatePolynomials.randomPoly(minimalPoly, rnd.nextInt(minimalPoly.degree()), rnd);
        if (r.isOverFiniteField()) {
            if (r instanceof UnivariatePolynomial)
                ((UnivariatePolynomial) r).multiply(((UnivariatePolynomial) r).ring.randomElement(rnd));
            else
                r.multiply(rnd.nextLong());
        }
        return r;
    }

    @Override
    public E variable(int variable) {
        if (variable != 0)
            throw new IllegalArgumentException();
        return valueOf(minimalPoly.createMonomial(1));
    }

    @Override
    public E parse(String string) {
        return valueOf(factory.parsePoly(string));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleFieldExtension<?> that = (SimpleFieldExtension<?>) o;
        return minimalPoly.equals(that.minimalPoly);
    }

    @Override
    public int hashCode() {
        return minimalPoly.hashCode();
    }

    @Override
    public String toString(IStringifier<E> stringifier) {
        String cfrStr = factory.coefficientRingToString(stringifier);
        String varStr = stringifier.getBinding(factory.createMonomial(1), IStringifier.defaultVar());
        String irrStr = minimalPoly.toString(stringifier);
        return "(" + cfrStr + ")[" + varStr + "]/<" + irrStr + ">";
    }

    public String toString(String... variables) {
        return toString(IStringifier.mkPolyStringifier(factory, variables));
    }

    @Override
    public String toString() {
        return toString(IStringifier.defaultVars(1));
    }
}
