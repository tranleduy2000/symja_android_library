/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * This is not the original file distributed by the Apache Software Foundation
 * It has been modified by the Hipparchus project
 */
package org.hipparchus.analysis.polynomials;

import org.hipparchus.Field;
import org.hipparchus.RealFieldElement;
import org.hipparchus.analysis.FieldUnivariateFunction;
import org.hipparchus.analysis.RealFieldUnivariateFunction;
import org.hipparchus.analysis.differentiation.DerivativeStructure;
import org.hipparchus.analysis.differentiation.UnivariateDifferentiableFunction;
import org.hipparchus.exception.LocalizedCoreFormats;
import org.hipparchus.exception.MathIllegalArgumentException;
import org.hipparchus.exception.NullArgumentException;
import org.hipparchus.util.MathUtils;

/**
 * Implements the representation of a real polynomial function in
 * Newton Form. For reference, see <b>Elementary Numerical Analysis</b>,
 * ISBN 0070124477, chapter 2.
 * <p>
 * The formula of polynomial in Newton form is
 * p(x) = a[0] + a[1](x-c[0]) + a[2](x-c[0])(x-c[1]) + ... +
 * a[n](x-c[0])(x-c[1])...(x-c[n-1])
 * Note that the length of a[] is one more than the length of c[]</p>
 */
public class PolynomialFunctionNewtonForm implements UnivariateDifferentiableFunction, FieldUnivariateFunction {

    /**
     * Centers of the Newton polynomial.
     */
    private final double[] c;
    /**
     * When all c[i] = 0, a[] becomes normal polynomial coefficients,
     * i.e. a[i] = coefficients[i].
     */
    private final double[] a;
    /**
     * The coefficients of the polynomial, ordered by degree -- i.e.
     * coefficients[0] is the constant term and coefficients[n] is the
     * coefficient of x^n where n is the degree of the polynomial.
     */
    private double[] coefficients;
    /**
     * Whether the polynomial coefficients are available.
     */
    private boolean coefficientsComputed;

    /**
     * Construct a Newton polynomial with the given a[] and c[]. The order of
     * centers are important in that if c[] shuffle, then values of a[] would
     * completely change, not just a permutation of old a[].
     * <p>
     * The constructor makes copy of the input arrays and assigns them.</p>
     *
     * @param a Coefficients in Newton form formula.
     * @param c Centers.
     * @throws NullArgumentException        if any argument is {@code null}.
     * @throws MathIllegalArgumentException if any array has zero length.
     * @throws MathIllegalArgumentException if the size difference between
     *                                      {@code a} and {@code c} is not equal to 1.
     */
    public PolynomialFunctionNewtonForm(double[] a, double[] c)
            throws MathIllegalArgumentException, NullArgumentException {

        verifyInputArray(a, c);
        this.a = new double[a.length];
        this.c = new double[c.length];
        System.arraycopy(a, 0, this.a, 0, a.length);
        System.arraycopy(c, 0, this.c, 0, c.length);
        coefficientsComputed = false;
    }

    /**
     * Evaluate the Newton polynomial using nested multiplication. It is
     * also called <a href="http://mathworld.wolfram.com/HornersRule.html">
     * Horner's Rule</a> and takes O(N) time.
     *
     * @param a Coefficients in Newton form formula.
     * @param c Centers.
     * @param z Point at which the function value is to be computed.
     * @return the function value.
     * @throws NullArgumentException        if any argument is {@code null}.
     * @throws MathIllegalArgumentException if any array has zero length.
     * @throws MathIllegalArgumentException if the size difference between
     *                                      {@code a} and {@code c} is not equal to 1.
     */
    public static double evaluate(double[] a, double[] c, double z)
            throws MathIllegalArgumentException, NullArgumentException {
        verifyInputArray(a, c);

        final int n = c.length;
        double value = a[n];
        for (int i = n - 1; i >= 0; i--) {
            value = a[i] + (z - c[i]) * value;
        }

        return value;
    }

    /**
     * Verifies that the input arrays are valid.
     * <p>
     * The centers must be distinct for interpolation purposes, but not
     * for general use. Thus it is not verified here.</p>
     *
     * @param a the coefficients in Newton form formula
     * @param c the centers
     * @throws NullArgumentException        if any argument is {@code null}.
     * @throws MathIllegalArgumentException if any array has zero length.
     * @throws MathIllegalArgumentException if the size difference between
     *                                      {@code a} and {@code c} is not equal to 1.
     * @see org.hipparchus.analysis.interpolation.DividedDifferenceInterpolator#computeDividedDifference(double[],
     * double[])
     */
    protected static void verifyInputArray(double[] a, double[] c)
            throws MathIllegalArgumentException, NullArgumentException {
        MathUtils.checkNotNull(a);
        MathUtils.checkNotNull(c);
        if (a.length == 0 || c.length == 0) {
            throw new MathIllegalArgumentException(LocalizedCoreFormats.EMPTY_POLYNOMIALS_COEFFICIENTS_ARRAY);
        }
        if (a.length != c.length + 1) {
            throw new MathIllegalArgumentException(LocalizedCoreFormats.ARRAY_SIZES_SHOULD_HAVE_DIFFERENCE_1,
                    a.length, c.length);
        }
    }

    /**
     * Calculate the function value at the given point.
     *
     * @param z Point at which the function value is to be computed.
     * @return the function value.
     */
    @Override
    public double value(double z) {
        return evaluate(a, c, z);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DerivativeStructure value(final DerivativeStructure t) {
        verifyInputArray(a, c);

        final int n = c.length;
        DerivativeStructure value = t.getFactory().constant(a[n]);
        for (int i = n - 1; i >= 0; i--) {
            value = t.subtract(c[i]).multiply(value).add(a[i]);
        }

        return value;

    }

    @Override
    public <T extends RealFieldElement<T>> RealFieldUnivariateFunction<T> toRealFieldUnivariateFunction(Field<T> field) {
        return new RealFieldUnivariateFunction<T>() {
            @Override
            public T value(T x) {
                return PolynomialFunctionNewtonForm.this.value(x);
            }
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T extends RealFieldElement<T>> T value(final T t) {
        verifyInputArray(a, c);

        final int n = c.length;
        T value = t.getField().getZero().add(a[n]);
        for (int i = n - 1; i >= 0; i--) {
            value = t.subtract(c[i]).multiply(value).add(a[i]);
        }

        return value;

    }

    /**
     * Returns the degree of the polynomial.
     *
     * @return the degree of the polynomial
     */
    public int degree() {
        return c.length;
    }

    /**
     * Returns a copy of coefficients in Newton form formula.
     * <p>
     * Changes made to the returned copy will not affect the polynomial.</p>
     *
     * @return a fresh copy of coefficients in Newton form formula
     */
    public double[] getNewtonCoefficients() {
        double[] out = new double[a.length];
        System.arraycopy(a, 0, out, 0, a.length);
        return out;
    }

    /**
     * Returns a copy of the centers array.
     * <p>
     * Changes made to the returned copy will not affect the polynomial.</p>
     *
     * @return a fresh copy of the centers array.
     */
    public double[] getCenters() {
        double[] out = new double[c.length];
        System.arraycopy(c, 0, out, 0, c.length);
        return out;
    }

    /**
     * Returns a copy of the coefficients array.
     * <p>
     * Changes made to the returned copy will not affect the polynomial.</p>
     *
     * @return a fresh copy of the coefficients array.
     */
    public double[] getCoefficients() {
        if (!coefficientsComputed) {
            computeCoefficients();
        }
        double[] out = new double[coefficients.length];
        System.arraycopy(coefficients, 0, out, 0, coefficients.length);
        return out;
    }

    /**
     * Calculate the normal polynomial coefficients given the Newton form.
     * It also uses nested multiplication but takes O(N^2) time.
     */
    protected void computeCoefficients() {
        final int n = degree();

        coefficients = new double[n + 1];
        for (int i = 0; i <= n; i++) {
            coefficients[i] = 0.0;
        }

        coefficients[0] = a[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - i; j > 0; j--) {
                coefficients[j] = coefficients[j - 1] - c[i] * coefficients[j];
            }
            coefficients[0] = a[i] - c[i] * coefficients[0];
        }

        coefficientsComputed = true;
    }

}
