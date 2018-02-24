/*
 * Project: Lab4Math
 *
 * Copyright (c) 2008-2012,  Prof. Dr. Nikolaus Wulff
 * University of Applied Sciences, Muenster, Germany
 * Lab for Computer Sciences (Lab4Inf).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*
*/

package de.lab4inf.math.service;

import de.lab4inf.math.Differentiable;
import de.lab4inf.math.Differentiator;
import de.lab4inf.math.Function;
import de.lab4inf.math.L4MObject;
import de.lab4inf.math.differentiation.Gradient;
import de.lab4inf.math.differentiation.GradientApproximator;
import de.lab4inf.math.gof.Visitable;

/**
 * Differentiator service implementation.
 *
 * @author nwulff
 * @version $Id: DifferentiatorService.java,v 1.3 2014/06/26 11:25:34 nwulff Exp $
 * @since 06.01.2012
 */
public class DifferentiatorService extends L4MObject implements Differentiator {

    /* (non-Javadoc)
     * @see de.lab4inf.math.Differentiator#differentiate(de.lab4inf.math.Function, double)
     */
    @Override
    public double differentiate(final Function fct, final double x) {
        return de.lab4inf.math.differentiation.Differentiator.dF(fct, x);
    }

    /* (non-Javadoc)
     * @see de.lab4inf.math.Differentiator#differentiate(de.lab4inf.math.Function, double[])
     */
    @Override
    public double[] differentiate(final Function fct, final double... x) {
        Gradient grad = new GradientApproximator(fct);
        return grad.gradient(x);
    }

    /* (non-Javadoc)
     * @see de.lab4inf.math.Differentiator#differential(de.lab4inf.math.Function)
     */
    @Override
    public Function differential(final Function fct) {
        if (fct instanceof Differentiable) {
            return ((Differentiable) fct).getDerivative();
        }
        return new de.lab4inf.math.differentiation.Differentiator(fct);
    }

    /* (non-Javadoc)
     * @see de.lab4inf.math.gof.Visitor#visit(de.lab4inf.math.gof.Visitable)
     */
    @Override
    public void visit(final Visitable<Function> subject) {
        throw new IllegalStateException("not implemented yet...");
    }

}
 