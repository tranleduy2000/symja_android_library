package cc.redberry.rings.poly.multivar;

import org.hipparchus.random.RandomGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import cc.redberry.combinatorics.Combinatorics;
import cc.redberry.combinatorics.IntCombinatorialPort;
import cc.redberry.combinatorics.IntCompositions;
import cc.redberry.rings.FactorDecomposition;
import cc.redberry.rings.IntegersZp64;
import cc.redberry.rings.Rational;
import cc.redberry.rings.Ring;
import cc.redberry.rings.Rings;
import cc.redberry.rings.bigint.BigInteger;
import cc.redberry.rings.linear.LinearSolver;
import cc.redberry.rings.poly.IPolynomial;
import cc.redberry.rings.poly.MultivariateRing;
import cc.redberry.rings.poly.PolynomialMethods;
import cc.redberry.rings.util.ArraysUtil;

import static cc.redberry.rings.Rings.MultivariateRing;
import static cc.redberry.rings.Rings.Q;
import static cc.redberry.rings.Rings.Z;
import static cc.redberry.rings.linear.LinearSolver.SystemInfo.Consistent;
import static cc.redberry.rings.linear.LinearSolver.SystemInfo.Inconsistent;
import static cc.redberry.rings.poly.multivar.GroebnerBases.GroebnerBasis;
import static cc.redberry.rings.poly.multivar.GroebnerBases.isMonomialIdeal;
import static cc.redberry.rings.poly.multivar.GroebnerBases.optimalOrder;
import static cc.redberry.rings.poly.multivar.MonomialOrder.GREVLEX;
import static cc.redberry.rings.poly.multivar.MonomialOrder.LEX;

/**
 * Utility methods based on Groebner bases
 */
public final class GroebnerMethods {
    /**
     * Number of random substitutions for polynomial Jacobian to deduce its rank
     */
    private static final int N_JACOBIAN_EVALUATIONS_TRIES = 2;

    /* *********************************************** Elimination *********************************************** */
    private static final int NULLSTELLENSATZ_LIN_SYS_THRESHOLD = 1 << 16;

    private GroebnerMethods() {
    }

    /**
     * Eliminates specified variables from the given ideal.
     */
    @SuppressWarnings("unchecked")
    public static <Poly extends AMultivariatePolynomial>
    List<Poly> eliminate(List<Poly> ideal, int variable) {
        return eliminate0(ideal, variable);
    }

    /* ******************************************* Algebraic dependence ******************************************** */

    private static <Term extends AMonomial<Term>, Poly extends AMultivariatePolynomial<Term, Poly>>
    List<Poly> eliminate0(List<Poly> ideal, int variable) {
        if (ideal.isEmpty())
            return Collections.emptyList();

        Comparator<DegreeVector> originalOrder = ideal.get(0).ordering;
        Comparator<DegreeVector> optimalOrder = optimalOrder(ideal);

        List<Poly> eliminationIdeal = ideal;
        if (!(optimalOrder instanceof MonomialOrder.GrevLexWithPermutation)) {
            List<Poly> list = new ArrayList<>();
            for (Poly p : GroebnerBasis(
                    eliminationIdeal,
                    new MonomialOrder.EliminationOrder(optimalOrder, variable))) {
                if (p.degree(variable) == 0) {
                    list.add(p);
                }
            }
            eliminationIdeal = list;
        } else {
            MonomialOrder.GrevLexWithPermutation order = (MonomialOrder.GrevLexWithPermutation) optimalOrder;
            int[] inversePermutation = MultivariateGCD.inversePermutation(order.permutation);
            List<Poly> list = new ArrayList<>();
            for (Poly terms : eliminationIdeal) {
                Poly poly = AMultivariatePolynomial.renameVariables(terms, order.permutation);
                list.add(poly);
            }
            List<Poly> result = new ArrayList<>();
            for (Poly p : GroebnerBasis(list, new MonomialOrder.EliminationOrder(GREVLEX, inversePermutation[variable]))) {
                Poly terms = AMultivariatePolynomial.renameVariables(p, inversePermutation);
                if (terms.degree(variable) == 0) {
                    result.add(terms);
                }
            }
            eliminationIdeal = result;
        }

        List<Poly> list = new ArrayList<>();
        for (Poly p : eliminationIdeal) {
            Poly terms = p.setOrdering(originalOrder);
            list.add(terms);
        }
        return list;
    }

    /**
     * Eliminates specified variables from the given ideal.
     */
    public static <Poly extends AMultivariatePolynomial>
    List<Poly> eliminate(List<Poly> ideal, int... variables) {
        for (int variable : variables)
            ideal = eliminate(ideal, variable);
        return ideal;
    }

    /**
     * Returns true if a given set of polynomials is probably algebraically dependent or false otherwise (which means
     * that the given set is certainly independent). The method applies two criteria: it tests for lead set (LEX)
     * independence and does a probabilistic Jacobian test.
     */
    @SuppressWarnings("unchecked")
    public static <Poly extends AMultivariatePolynomial>
    boolean probablyAlgebraicallyDependentQ(List<Poly> sys) {
        if (sys.isEmpty())
            return false;

        Poly representative = sys.get(0);
        if (sys.size() > representative.nVariables)
            return true;

        // give a check for LEX leading terms set
        List<DegreeVector> leadTerms;
        boolean b = true;
        for (Poly sy : sys) {
            if (sy.ordering != LEX) {
                b = false;
                break;
            }
        }
        if (b)
            leadTerms = sys.stream().map(AMultivariatePolynomial::lt).collect(Collectors.toList());
        else
            leadTerms = sys.stream().map(p -> p.lt(LEX)).collect(Collectors.toList());
        if (!algebraicallyDependentMonomialsQ(leadTerms))
            return false;

        if (isMonomialIdeal(sys))
            return true;

        if (probablyMaximalJacobianRankQ(JacobianMatrix(sys)))
            return false;

        return true;
    }

    /**
     * Returns true if a given set of polynomials is algebraically dependent or false otherwise.
     */
    public static <Poly extends AMultivariatePolynomial>
    boolean algebraicallyDependentQ(List<Poly> sys) {
        return !algebraicRelations(sys).isEmpty();
    }

    /**
     * Tests for algebraic dependence the set of monomials
     */
    static boolean algebraicallyDependentMonomialsQ(List<DegreeVector> sys) {
        if (sys.isEmpty())
            return false;

        // build a homogeneous linear system
        int nVariables = sys.get(0).exponents.length;
        int nUnknowns = sys.size();

        // fixme use Bareiss in future
        @SuppressWarnings("unchecked")
        Rational<BigInteger>[][] lhs = new Rational[nVariables][nUnknowns];
        for (int i = 0; i < nVariables; ++i)
            for (int j = 0; j < nUnknowns; ++j)
                lhs[i][j] = Q.valueOf(sys.get(j).exponents[i]);
        Rational<BigInteger>[] rhs = Q.createZeroesArray(nVariables);

        // try to solve the system
        Rational<BigInteger>[] solution = Q.createZeroesArray(nUnknowns);
        LinearSolver.SystemInfo solveResult = LinearSolver.solve(Q, lhs, rhs, solution);
        if (solveResult == Consistent && Arrays.stream(solution).allMatch(Rational::isZero))
            return false;
        if (solveResult == LinearSolver.SystemInfo.Inconsistent)
            return false;
        return true;
    }

    /**
     * Probabilistic test for the maximality of the rank of Jacobian matrix
     */
    @SuppressWarnings("unchecked")
    static <Poly extends AMultivariatePolynomial>
    boolean probablyMaximalJacobianRankQ(Poly[][] jacobian) {
        if (jacobian[0][0] instanceof MultivariatePolynomialZp64)
            return probablyMaximalJacobianRankQ((MultivariatePolynomialZp64[][]) jacobian);
        else
            return probablyMaximalJacobianRankQ((MultivariatePolynomial[][]) jacobian);
    }

    /**
     * Probabilistic test for the maximality of the rank of Jacobian matrix
     */
    static boolean probablyMaximalJacobianRankQ(MultivariatePolynomialZp64[][] jacobian) {
        int nRows = jacobian.length, nColumns = jacobian[0].length;
        MultivariatePolynomialZp64 factory = jacobian[0][0];
        IntegersZp64 ring = factory.ring;
        long[][] matrix = new long[nRows][nColumns];
        long[] substitution = new long[nRows];
        RandomGenerator random = PrivateRandom.getRandom();
        for (int i = 0; i < N_JACOBIAN_EVALUATIONS_TRIES; ++i) {
            for (int var = 0; var < nRows; ++var)
                substitution[var] = ring.randomNonZeroElement(random);

            for (int iRow = 0; iRow < nRows; ++iRow)
                for (int iColumn = 0; iColumn < nColumns; ++iColumn)
                    matrix[iRow][iColumn] = jacobian[iRow][iColumn].evaluate(substitution);

            int nz = LinearSolver.rowEchelonForm(ring, matrix, null, false, true);
            if (nz == 0)
                return true;
        }
        return false;
    }

    /**
     * Probabilistic test for the maximality of the rank of Jacobian matrix
     */
    static <E> boolean probablyMaximalJacobianRankQ(MultivariatePolynomial<E>[][] jacobian) {
        int nRows = jacobian.length, nColumns = jacobian[0].length;
        MultivariatePolynomial<E> factory = jacobian[0][0];
        Ring<E> ring = factory.ring;
        E[][] matrix = ring.createArray2d(nRows, nColumns);
        E[] substitution = ring.createArray(nRows);
        RandomGenerator random = PrivateRandom.getRandom();
        for (int i = 0; i < N_JACOBIAN_EVALUATIONS_TRIES; ++i) {
            for (int var = 0; var < nRows; ++var)
                substitution[var] = ring.randomNonZeroElement(random);

            for (int iRow = 0; iRow < nRows; ++iRow)
                for (int iColumn = 0; iColumn < nColumns; ++iColumn)
                    matrix[iRow][iColumn] = jacobian[iRow][iColumn].evaluate(substitution);

            // fixme use Bareiss in future
            int nz = LinearSolver.rowEchelonForm(ring, matrix, null, false, true);
            if (nz == 0)
                return true;
        }
        return false;
    }

    /**
     * Gives a list of algebraic relations (annihilating polynomials) for the given list of polynomials
     */
    @SuppressWarnings("unchecked")
    public static <Poly extends AMultivariatePolynomial>
    List<Poly> algebraicRelations(List<Poly> polys) {
        return algebraicRelations0(polys);
    }

    private static <Term extends AMonomial<Term>, Poly extends AMultivariatePolynomial<Term, Poly>>
    List<Poly> algebraicRelations0(List<Poly> polys) {
        if (!probablyAlgebraicallyDependentQ(polys))
            return Collections.emptyList();

        int nInitialVars = polys.get(0).nVariables;
        int nAdditionalVars = polys.size();
        List<Poly> helpPolys = new ArrayList<>();
        for (int i = 0; i < polys.size(); i++) {
            Poly p = polys.get(i).setNVariables(nInitialVars + nAdditionalVars);
            helpPolys.add(p.createMonomial(nInitialVars + i, 1).subtract(p));
        }

        int[] dropVars = ArraysUtil.sequence(0, nInitialVars);
        List<Poly> list = new ArrayList<>();
        for (Poly p : eliminate(helpPolys, dropVars)) {
            Poly terms = p.dropVariables(dropVars);
            list.add(terms);
        }
        return list;
    }

    /* **************************************** Nullstellensatz certificate **************************************** */

    /**
     * Creates a Jacobian matrix of a given list of polynomials
     */
    public static <Term extends AMonomial<Term>, Poly extends AMultivariatePolynomial<Term, Poly>>
    Poly[][] JacobianMatrix(List<Poly> sys) {
        if (sys.isEmpty())
            throw new IllegalArgumentException("Empty list");
        MultivariateRing<Poly> ring = MultivariateRing(sys.get(0));
        Poly[][] jacobian = ring.createArray2d(ring.nVariables(), sys.size());
        for (int i = 0; i < ring.nVariables(); ++i)
            for (int j = 0; j < sys.size(); ++j)
                jacobian[i][j] = sys.get(j).derivative(i);
        return jacobian;
    }

    /**
     * Computes Nullstellensatz certificate for a given list of polynomials assuming that they have no common zeros (or
     * equivalently assuming that the ideal formed by the list is trivial). The method doesn't perform explicit check
     * that the {@code polynomials} have no common zero, so if they are the method will fail.
     *
     * @param polynomials list of polynomials
     * @return polynomials {@code S_i} such that {@code S_1 * f_1 + ... + S_n * f_n = 1} or null if no solution with
     * moderate degree bounds exist (either since {@code polynomials} have a common root or because the degree
     * bound on the solutions is so big that the system is intractable for computer)
     */
    @SuppressWarnings("unchecked")
    public static <Poly extends AMultivariatePolynomial>
    List<Poly> NullstellensatzCertificate(List<Poly> polynomials) {
        return NullstellensatzCertificate(polynomials, true);
    }

    /**
     * Computes Nullstellensatz certificate for a given list of polynomials assuming that they have no common zeros (or
     * equivalently assuming that the ideal formed by the list is trivial). The method doesn't perform explicit check
     * that the {@code polynomials} have no common zero, so if they are the method will fail.
     *
     * @param polynomials list of polynomials
     * @return polynomials {@code S_i} such that {@code S_1 * f_1 + ... + S_n * f_n = 1} or null if no solution with
     * moderate degree bounds exist (either since {@code polynomials} have a common root or because the degree
     * bound on the solutions is so big that the system is intractable for computer)
     */
    @SuppressWarnings("unchecked")
    public static <Poly extends AMultivariatePolynomial>
    List<Poly> NullstellensatzCertificate(List<Poly> polynomials, boolean boundTotalDeg) {
        return NullstellensatzSolver(polynomials, (Poly) polynomials.get(0).createOne(), boundTotalDeg);
    }

    /**
     * Tries to find solution of the equation {@code S_1 * f_1 + ... + S_n * f_n = g} for given {@code f_i} and {@code
     * g} and unknown {@code S_i} by transforming to a system of linear equations with unknown coefficients of {@code
     * S_i}.
     *
     * @param polynomials   list of polynomials
     * @param rhs           right hand side of the equation
     * @param boundTotalDeg whether to perform evaluations by increasing total degree of unknown polys or by increasing
     *                      individual degrees of vars
     * @return polynomials {@code S_i} such that {@code S_1 * f_1 + ... + S_n * f_n = g} or null if no solution with
     * moderate degree bounds exists
     */
    @SuppressWarnings("unchecked")
    public static <Poly extends AMultivariatePolynomial>
    List<Poly> NullstellensatzSolver(List<Poly> polynomials, Poly rhs, boolean boundTotalDeg) {
        return NullstellensatzSolver0(polynomials, rhs, boundTotalDeg);
    }

    @SuppressWarnings("unchecked")
    private static <Term extends AMonomial<Term>, Poly extends AMultivariatePolynomial<Term, Poly>>
    List<Poly> NullstellensatzSolver0(List<Poly> polynomials, Poly rhs, boolean boundTotalDeg) {
        if (rhs.isOverZ())
            // fixme: improve when Bareiss will be done
            // switch to Q and then to Z
            return NullstellensatzSolverZ((List) polynomials, (MultivariatePolynomial) rhs, boundTotalDeg);

        Poly factory = polynomials.get(0);
        for (int degreeBound = 1; ; ++degreeBound) {
            // number of coefficients in a single unknown poly
            BigInteger _maxCfSize;
            if (boundTotalDeg) {
                BigInteger acc = Z.getZero();
                for (int d = 0; d <= degreeBound; d++) {
                    BigInteger binomial = Z.binomial(d + factory.nVariables - 1, factory.nVariables - 1);
                    acc = Z.add(acc, binomial);
                }
                _maxCfSize = acc;
            } else
                _maxCfSize = Z.pow(Z.valueOf(degreeBound), factory.nVariables);
            // total number of unknown coefficients
            BigInteger _nUnknowns = _maxCfSize.multiply(Z.valueOf(polynomials.size()));
            if (!_nUnknowns.isInt())
                return null;
            int nUnknowns = _nUnknowns.intValue();
            if (nUnknowns > NULLSTELLENSATZ_LIN_SYS_THRESHOLD)
                return null;

            int maxCfSize = _maxCfSize.intValueExact();

            // factory polynomial and ring for the coefficients R[u1, ..., uM]
            Poly cfFactory = factory.createZero().setNVariables(nUnknowns);
            MultivariateRing<Poly> cfRing = MultivariateRing(cfFactory);

            // ring used to build the system R[u1, ..., uM][x1, ..., xN]
            MultivariateRing<MultivariatePolynomial<Poly>> linSysRing = Rings.MultivariateRing(factory.nVariables, cfRing);

            // initial system as R[u1, ..., uM][x1, ..., xN]
            List<MultivariatePolynomial<Poly>> convertedPolynomials = new ArrayList<>();
            for (Poly p : polynomials) {
                MultivariatePolynomial<Poly> monomials = p.asOverPoly(cfFactory);
                convertedPolynomials.add(monomials);
            }

            // solution
            List<MultivariatePolynomial<Poly>> certificate = new ArrayList<>();

            // building the lhs of the equation \sum_i C_i * f_i = rhs
            MultivariatePolynomial<Poly> eq = linSysRing.getZero();
            for (int i = 0; i < polynomials.size(); ++i) {
                MultivariatePolynomial<Poly> unknownPoly = generate(cfRing, linSysRing, degreeBound, i * maxCfSize, boundTotalDeg);
                certificate.add(unknownPoly);
                eq.add(convertedPolynomials.get(i).multiply(unknownPoly));
            }

            // if still not compatible
            if (!eq.getSkeleton().containsAll(rhs.getSkeleton()))
                continue;

            // solving linear system
            List<Poly> cert = findCertificateFromLinearSystem(eq, certificate, rhs, nUnknowns);
            if (cert != null)
                return cert;
        }
    }

    private static List<MultivariatePolynomial<BigInteger>> NullstellensatzSolverZ(List<MultivariatePolynomial<BigInteger>> polynomials,
                                                                                   MultivariatePolynomial<BigInteger> rhs, boolean boundTotalDeg) {
        // fixme: a crutch
        List<MultivariatePolynomial<Rational<BigInteger>>> list = new ArrayList<>();
        for (MultivariatePolynomial<BigInteger> polynomial : polynomials) {
            MultivariatePolynomial<Rational<BigInteger>> monomials = polynomial.mapCoefficients(Q, Q::mkNumerator);
            list.add(monomials);
        }
        List<MultivariatePolynomial<Rational<BigInteger>>> result = NullstellensatzSolver(
                list,
                rhs.mapCoefficients(Q, Q::mkNumerator),
                boundTotalDeg);
        for (MultivariatePolynomial<Rational<BigInteger>> monomials : result) {
            if (!monomials.stream().allMatch(Rational::isIntegral)) {
                return null;
            }
        }
        List<MultivariatePolynomial<BigInteger>> list1 = new ArrayList<>();
        for (MultivariatePolynomial<Rational<BigInteger>> p : result) {
            MultivariatePolynomial<BigInteger> monomials = p.mapCoefficients(Z, Rational::numerator);
            list1.add(monomials);
        }
        return list1;
    }

    /**
     * @param eq          the equation
     * @param certificate unknown polynomials (certificate)
     * @param rhs         rhs poly
     * @param nUnknowns   number of unknown coefficients
     */
    @SuppressWarnings("unchecked")
    private static <Term extends AMonomial<Term>, Poly extends AMultivariatePolynomial<Term, Poly>>
    List<Poly> findCertificateFromLinearSystem(MultivariatePolynomial<Poly> eq,
                                               List<MultivariatePolynomial<Poly>> certificate,
                                               Poly rhs,
                                               int nUnknowns) {
        if (eq.cc() instanceof MultivariatePolynomialZp64)
            return findCertificateZp64((MultivariatePolynomial) eq, (List) certificate, (MultivariatePolynomialZp64) rhs, nUnknowns);
        else
            return findCertificateE((MultivariatePolynomial) eq, (List) certificate, (MultivariatePolynomial) rhs, nUnknowns);
    }

    /**
     * Solve in Zp64
     */
    private static List<MultivariatePolynomialZp64> findCertificateZp64(
            MultivariatePolynomial<MultivariatePolynomialZp64> eq,
            List<MultivariatePolynomial<MultivariatePolynomialZp64>> certificate,
            MultivariatePolynomialZp64 rhsPoly,
            int nUnknowns) {
        long[]
                // lhs of the system
                lhs[] = new long[eq.size()][nUnknowns],
                // rhs of the system
                rhs = new long[eq.size()];

        int iEq = 0;
        for (Monomial<MultivariatePolynomialZp64> term : eq) {
            MonomialZp64 rhsTerm = rhsPoly.terms.get(term);
            if (rhsTerm != null)
                rhs[iEq] = rhsTerm.coefficient;
            else
                rhs[iEq] = 0;

            for (MonomialZp64 cfTerm : term.coefficient) {
                assert cfTerm.totalDegree == 1;
                lhs[iEq][cfTerm.firstNonZeroVariable()] = cfTerm.coefficient;
            }
            ++iEq;
        }

        IntegersZp64 ring = eq.lc().ring;
        long[] result = new long[nUnknowns];
        LinearSolver.SystemInfo solve = LinearSolver.solve(ring, lhs, rhs, result, true);
        if (solve == Inconsistent)
            return null;

        List<MultivariatePolynomialZp64> list = new ArrayList<>();
        for (MultivariatePolynomial<MultivariatePolynomialZp64> p : certificate) {
            MultivariatePolynomialZp64 monomialZp64s = p.mapCoefficients(ring, m -> m.evaluate(result));
            list.add(monomialZp64s);
        }
        return list;
    }

    /**
     * Solve in genetic ring
     */
    private static <E> List<MultivariatePolynomial<E>> findCertificateE(
            MultivariatePolynomial<MultivariatePolynomial<E>> eq,
            List<MultivariatePolynomial<MultivariatePolynomial<E>>> certificate,
            MultivariatePolynomial<E> rhsPoly,
            int nUnknowns) {
        Ring<E> ring = eq.lc().ring;
        E[]
                // lhs of the system
                lhs[] = ring.createZeroesArray2d(eq.size(), nUnknowns),
                // rhs of the system
                rhs = ring.createZeroesArray(eq.size());

        int iEq = 0;
        for (Monomial<MultivariatePolynomial<E>> term : eq) {
            Monomial<E> rhsTerm = rhsPoly.terms.get(term);
            if (rhsTerm != null)
                rhs[iEq] = rhsTerm.coefficient;
            else
                rhs[iEq] = ring.getZero();

            for (Monomial<E> cfTerm : term.coefficient) {
                assert cfTerm.totalDegree == 1;
                lhs[iEq][cfTerm.firstNonZeroVariable()] = cfTerm.coefficient;
            }
            ++iEq;
        }

        E[] result = ring.createArray(nUnknowns);
        LinearSolver.SystemInfo solve = LinearSolver.solve(ring, lhs, rhs, result, true);
        if (solve == Inconsistent)
            return null;

        List<MultivariatePolynomial<E>> list = new ArrayList<>();
        for (MultivariatePolynomial<MultivariatePolynomial<E>> p : certificate) {
            MultivariatePolynomial<E> monomials = p.mapCoefficients(ring, m -> m.evaluate(result));
            list.add(monomials);
        }
        return list;
    }

    /**
     * Generates a poly of specified degree (in each variable) with unknown coefficients.
     *
     * @param cfRing      coefficient ring
     * @param ring        ring which result belongs to
     * @param degree      degree bound
     * @param startingVar the starting coefficient
     */
    static <Term extends AMonomial<Term>, Poly extends AMultivariatePolynomial<Term, Poly>>
    MultivariatePolynomial<Poly> generate(
            MultivariateRing<Poly> cfRing,
            MultivariateRing<MultivariatePolynomial<Poly>> ring,
            int degree, int startingVar, boolean boundTotalDeg) {
        MultivariatePolynomial<Poly> result = ring.getZero();
        if (boundTotalDeg)
            for (int d = 0; d <= degree; ++d)
                for (int[] tuple : new IntCombinatorialPort.Iterator(new IntCompositions(d, ring.nVariables())))
                    result.add(new Monomial<>(tuple, cfRing.variable(startingVar++)));
        else
            for (int[] tuple : Combinatorics.tuples(ArraysUtil.arrayOf(degree, ring.nVariables())))
                result.add(new Monomial<>(tuple, cfRing.variable(startingVar++)));
        return result;
    }

    /* **************************************** Partial fractions **************************************** */

    /**
     * Computes Leinart's decomposition of given rational expression (see https://arxiv.org/abs/1206.4740)
     */
    @SuppressWarnings("unchecked")
    public static <Poly extends AMultivariatePolynomial>
    List<Rational<Poly>> LeinartDecomposition(Rational<Poly> fraction) {
        return LeinartDecomposition0(fraction);
    }

    /**
     * Computes Leinart's decomposition of given rational expression (see https://arxiv.org/abs/1206.4740)
     */
    private static <Term extends AMonomial<Term>, Poly extends AMultivariatePolynomial<Term, Poly>>
    List<Rational<Poly>> LeinartDecomposition0(Rational<Poly> fraction) {
        FactorDecomposition<Poly> denDecomposition = fraction.factorDenominator();
        List<Factor<Term, Poly>> denominator = new ArrayList<>();
        int bound = denDecomposition.size();
        for (int i = 0; i < bound; i++) {
            Factor<Term, Poly> termPolyFactor = new Factor<>(denDecomposition.get(i), denDecomposition.getExponent(i));
            denominator.add(termPolyFactor);
        }

        List<Rational<Poly>> list = new ArrayList<>();
        for (Fraction<Term, Poly> p : NullstellensatzDecomposition(new Fraction<>(fraction.numerator(), denominator, denDecomposition.unit))) {
            for (Fraction<Term, Poly> f : AlgebraicDecomposition(p)) {
                Rational<Poly> polyRational = f.toRational(fraction.ring);
                list.add(polyRational);
            }
        }
        return list;
    }

    static <Term extends AMonomial<Term>, Poly extends AMultivariatePolynomial<Term, Poly>>
    List<Fraction<Term, Poly>> NullstellensatzDecomposition(Fraction<Term, Poly> fraction) {
        if (!Ideal.create(fraction.bareDenominatorNoUnits()).isEmpty())
            return Collections.singletonList(fraction);

        // denominators have not common zeros
        // apply Nullstellensatz decomposition
        List<Poly> certificate = NullstellensatzCertificate(fraction.raisedDenominator());
        List<Fraction<Term, Poly>> list = new ArrayList<>();
        int bound = certificate.size();
        for (int i = 0; i < bound; i++) {
            Fraction<Term, Poly> f = new Fraction<>(certificate.get(i).multiply(fraction.numerator), remove(fraction.denominator, i), fraction.denominatorConstantFactor);
            for (Fraction<Term, Poly> termPolyFraction : NullstellensatzDecomposition(f)) {
                list.add(termPolyFraction);
            }
        }
        return list;
    }

    static <Term extends AMonomial<Term>, Poly extends AMultivariatePolynomial<Term, Poly>>
    List<Fraction<Term, Poly>> AlgebraicDecomposition(Fraction<Term, Poly> fraction) {
        if (!probablyAlgebraicallyDependentQ(fraction.bareDenominatorNoUnits()))
            return Collections.singletonList(fraction);

        List<Poly> raisedDenominator = fraction.raisedDenominator();
        assert raisedDenominator.stream().noneMatch(IPolynomial::isConstant);

        List<Poly> annihilators = algebraicRelations(raisedDenominator);
        if (annihilators.isEmpty())
            return Collections.singletonList(fraction);

        // denominators are algebraically dependent
        // choose the simplest annihilator
        boolean seen = false;
        Poly best = null;
        Comparator<Poly> comparator = Comparator.comparingInt(p -> p.mt().totalDegree);
        for (Poly terms : annihilators) {
            if (!seen || comparator.compare(terms, best) < 0) {
                seen = true;
                best = terms;
            }
        }
        Poly annihilator = (seen ? Optional.of(best) : Optional.<Poly>empty()).get()
                .setOrderingUnsafe(GREVLEX);
        // choose the simplest monomial in annihilator
        Term minNormTerm = annihilator.mt();
        annihilator.subtract(minNormTerm).negate();

        Poly numerator = fraction.numerator;
        List<Factor<Term, Poly>> denominator = fraction.denominator;

        int[] denominatorExponents = new int[10];
        int count = 0;
        for (Factor<Term, Poly> f : denominator) {
            int exponent = f.exponent;
            if (denominatorExponents.length == count)
                denominatorExponents = Arrays.copyOf(denominatorExponents, count * 2);
            denominatorExponents[count++] = exponent;
        }
        denominatorExponents = Arrays.copyOfRange(denominatorExponents, 0, count);

        List<Fraction<Term, Poly>> result = new ArrayList<>();
        for (Term numFactor : annihilator) {
            // numFactor / minNormTerm / denominator
            int[] numExponents = ArraysUtil.multiply(denominatorExponents, numFactor.exponents);
            int[] denExponents = ArraysUtil.sum(denominatorExponents, ArraysUtil.multiply(denominatorExponents, minNormTerm.exponents));

            for (int i = 0; i < numExponents.length; ++i) {
                if (numExponents[i] >= denExponents[i]) {
                    numExponents[i] -= denExponents[i];
                    denExponents[i] = 0;
                } else {
                    denExponents[i] -= numExponents[i];
                    numExponents[i] = 0;
                }
            }

            Poly acc = numerator.clone();
            int bound = numExponents.length;
            for (int i = 0; i < bound; i++) {
                Poly raised = denominator.get(i).setExponent(numExponents[i]).raised;
                acc = acc.multiply(raised);
            }
            Poly num = acc
                    .multiply(numerator.createConstantFromTerm(numFactor));

            List<Factor<Term, Poly>> den = new ArrayList<>();
            int bound1 = numExponents.length;
            for (int i = 0; i < bound1; i++) {
                Factor<Term, Poly> termPolyFactor = denominator.get(i).setExponent(denExponents[i]);
                den.add(termPolyFactor);
            }

            Poly denConstant = fraction.denominatorConstantFactor.clone()
                    .multiply(numerator.createConstantFromTerm(minNormTerm));


            result.addAll(AlgebraicDecomposition(new Fraction<>(num, den, denConstant)));
        }
        return result;
    }

    private static <E> List<E> remove(List<E> list, int i) {
        list.remove(i);
        return list;
    }

    private static final class Fraction<Term extends AMonomial<Term>, Poly extends AMultivariatePolynomial<Term, Poly>> {
        final Poly numerator;
        final List<Factor<Term, Poly>> denominator;
        final Poly denominatorConstantFactor;

        Fraction(Poly numerator, List<Factor<Term, Poly>> denominator) {
            this(numerator, denominator, numerator.createOne());
        }

        Fraction(Poly numerator, List<Factor<Term, Poly>> denominator, Poly denominatorConstantFactor) {
            denominator = new ArrayList<>(denominator);
            denominatorConstantFactor = denominatorConstantFactor.clone();
            for (int i = denominator.size() - 1; i >= 0; --i)
                if (denominator.get(i).isConstant()) {
                    denominatorConstantFactor = denominatorConstantFactor.multiply(denominator.get(i).raised);
                    denominator.remove(i);
                }
            Poly cGcd = PolynomialMethods.PolynomialGCD(numerator, denominatorConstantFactor);
            this.numerator = numerator.divideByLC(cGcd);
            this.denominator = denominator;
            this.denominatorConstantFactor = denominatorConstantFactor.divideByLC(cGcd);

            for (int i = 0; i < raisedDenominator().size(); ++i)
                assert !(raisedDenominator().get(i).isConstant());
        }

        final List<Poly> raisedDenominator() {
            List<Poly> list = new ArrayList<>();
            for (Factor<Term, Poly> p : denominator) {
                Poly raised = p.raised;
                list.add(raised);
            }
            return list;
        }

        final List<Poly> bareDenominator() {
            List<Poly> list = new ArrayList<>();
            for (Factor<Term, Poly> p : denominator) {
                Poly factor = p.factor;
                list.add(factor);
            }
            return list;
        }

        final List<Poly> bareDenominatorNoUnits() {
            List<Poly> list = new ArrayList<>();
            for (Poly p : bareDenominator()) {
                if (!p.isConstant()) {
                    list.add(p);
                }
            }
            return list;
        }

        final Rational<Poly> toRational(Ring<Poly> polyRing) {
            Rational<Poly> r = new Rational<>(polyRing, numerator);
            r = r.divide(denominatorConstantFactor);
            for (Factor<Term, Poly> den : denominator)
                r = r.divide(den.raised);
            return r;
        }
    }

    private static final class Factor<Term extends AMonomial<Term>, Poly extends AMultivariatePolynomial<Term, Poly>> {
        final Poly factor;
        final int exponent;
        final Poly raised;

        Factor(Poly factor, int exponent, Poly raised) {
            this.factor = exponent == 0 ? factor.createOne() : factor;
            this.exponent = exponent;
            this.raised = raised;
        }

        Factor(Poly factor, int exponent) {
            this.factor = factor;
            this.exponent = exponent;
            this.raised = PolynomialMethods.polyPow(factor, exponent, true);
        }

        Factor<Term, Poly> setExponent(int newExponent) {
            if (exponent == newExponent)
                return this;
            if (exponent == 0)
                return new Factor<>(factor.createOne(), 0, factor.createOne());
            if (newExponent % exponent == 0)
                return new Factor<>(factor, newExponent, PolynomialMethods.polyPow(raised, newExponent / exponent));
            return new Factor<>(factor, newExponent);
        }

        boolean isConstant() {
            return factor.isConstant();
        }
    }
}
