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

package org.hipparchus.linear;

import org.hipparchus.exception.MathIllegalArgumentException;

/**
 * This class defines a linear operator operating on real ({@code double})
 * vector spaces. No direct access to the coefficients of the underlying matrix
 * is provided.
 * <p>
 * The motivation for such an interface is well stated by
 * <a href="#BARR1994">Barrett et al. (1994)</a>:
 * <blockquote>
 * We restrict ourselves to iterative methods, which work by repeatedly
 * improving an approximate solution until it is accurate enough. These
 * methods access the coefficient matrix A of the linear system only via the
 * matrix-vector product y = A &middot; x
 * (and perhaps z = A<sup>T</sup> &middot; x). Thus the user need only
 * supply a subroutine for computing y (and perhaps z) given x, which permits
 * full exploitation of the sparsity or other special structure of A.
 * </blockquote>
 * <p>
 * <dl>
 *  <dt><a name="BARR1994">Barret et al. (1994)</a></dt>
 *  <dd>
 *   R. Barrett, M. Berry, T. F. Chan, J. Demmel, J. M. Donato, J. Dongarra,
 *   V. Eijkhout, R. Pozo, C. Romine and H. Van der Vorst,
 *   <em>Templates for the Solution of Linear Systems: Building Blocks for
 *   Iterative Methods</em>, SIAM
 *  </dd>
 * </dl>
 */
public interface RealLinearOperator {
    /**
     * Returns the dimension of the codomain of this operator.
     *
     * @return the number of rows of the underlying matrix
     */
    int getRowDimension();

    /**
     * Returns the dimension of the domain of this operator.
     *
     * @return the number of columns of the underlying matrix
     */
    int getColumnDimension();

    /**
     * Returns the result of multiplying {@code this} by the vector {@code x}.
     *
     * @param x the vector to operate on
     * @return the product of {@code this} instance with {@code x}
     * @throws MathIllegalArgumentException if the column dimension does not match
     *                                      the size of {@code x}
     */
    RealVector operate(RealVector x)
            throws MathIllegalArgumentException;

}
