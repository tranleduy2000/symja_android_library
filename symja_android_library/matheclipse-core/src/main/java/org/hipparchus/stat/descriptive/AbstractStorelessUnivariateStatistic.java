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
package org.hipparchus.stat.descriptive;

import org.hipparchus.exception.LocalizedCoreFormats;
import org.hipparchus.exception.MathIllegalArgumentException;
import org.hipparchus.util.MathArrays;
import org.hipparchus.util.MathUtils;
import org.hipparchus.util.Precision;

import java.util.Locale;

/**
 * Abstract base class for implementations of the
 * {@link StorelessUnivariateStatistic} interface.
 * <p>
 * Provides default {@code hashCode()} and {@code equals(Object)}
 * implementations.
 */
public abstract class AbstractStorelessUnivariateStatistic
    implements StorelessUnivariateStatistic {

    /** {@inheritDoc} */
    @Override
    public abstract StorelessUnivariateStatistic copy();

    /** {@inheritDoc} */
    @Override
    public abstract void clear();

    /** {@inheritDoc} */
    @Override
    public abstract double getResult();

    @Override
    public double evaluate(double[] values, int begin, int length) throws MathIllegalArgumentException {
        if (MathArrays.verifyValues(values, begin, length)) {
            StorelessUnivariateStatistic stat = copy();
            stat.clear();
            stat.incrementAll(values, begin, length);
            return stat.getResult();
        }
        return Double.NaN;
    }

    /** {@inheritDoc} */
    @Override
    public abstract void increment(double d);

    @Override
    public void accept(double value) {
        increment(value);

    }

    @Override
    public void incrementAll(double[] values) throws MathIllegalArgumentException {
        MathUtils.checkNotNull(values, LocalizedCoreFormats.INPUT_ARRAY);
        incrementAll(values, 0, values.length);
    }

    @Override
    public void incrementAll(double[] values, int start, int length) throws MathIllegalArgumentException {
        if (MathArrays.verifyValues(values, start, length)) {
            int k = start + length;
            for (int i = start; i < k; i++) {
                increment(values[i]);
            }
        }
    }

    /**
     * Returns true iff <code>object</code> is the same type of
     * {@link StorelessUnivariateStatistic} (the object's class equals this
     * instance) returning the same values as this for <code>getResult()</code>
     * and <code>getN()</code>.
     *
     * @param object object to test equality against.
     * @return true if object returns the same value as this
     */
    @Override
    public boolean equals(Object object) {
        if (object == this ) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        StorelessUnivariateStatistic other = (StorelessUnivariateStatistic) object;
        return Precision.equalsIncludingNaN(other.getResult(), getResult()) &&
               Precision.equalsIncludingNaN(other.getN(),      getN());
    }

    /**
     * Returns hash code based on getResult() and getN().
     *
     * @return hash code
     */
    @Override
    public int hashCode() {
        return 31 * (31 + MathUtils.hash(getResult())) + MathUtils.hash(getN());
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%s: result=%f, N=%d",
                             getClass().getSimpleName(),
                             getResult(),
                             getN());
    }
}
