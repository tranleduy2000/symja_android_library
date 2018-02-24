/*
 * Project: Lab4Math
 *
 * Copyright (c) 2008-2012,  Prof. Dr. Nikolaus Wulff
 * University of Applied Sciences, Muenster, Germany
 * Lab for computer sciences (Lab4Inf).
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

import java.util.HashMap;
import java.util.Set;

import de.lab4inf.math.Function;
import de.lab4inf.math.FunctionResolver;
import de.lab4inf.math.L4MObject;
import de.lab4inf.math.functions.L4MFunction;

import static java.lang.String.format;

/**
 * Lab4Math function resolver service
 * <p>
 * Get the implementation of a function by name.
 *
 * @author nwulff
 * @version $Id: FunctionService.java,v 1.10 2014/11/18 23:41:21 nwulff Exp $
 * @since 06.01.2012
 */
public class FunctionService extends L4MObject implements FunctionResolver {
    private static final HashMap<String, Function> L4M_FCTS;

    static {
        L4M_FCTS = new HashMap<String, Function>();
        FunctionService.init();
        // java.util.logging.Level lev = LOGGER.getLevel();
        // LOGGER.setLevel(java.util.logging.Level.ALL);
        LOGGER.info(format("%s intialized", FunctionService.class.getSimpleName()));
        // LOGGER.setLevel(lev);
    }

    /**
     * Register the known functions. Should be done via external
     * property file...
     */
    private static void init() {
        L4M_FCTS.put("abs", new MathWrapper(0));
        L4M_FCTS.put("sin", new MathWrapper(1));
        L4M_FCTS.put("asin", new MathWrapper(-1));
        L4M_FCTS.put("cos", new MathWrapper(2));
        L4M_FCTS.put("acos", new MathWrapper(-2));
        L4M_FCTS.put("tan", new MathWrapper(3));
        L4M_FCTS.put("atan", new MathWrapper(-3));
        L4M_FCTS.put("atan2", new MathWrapper(-13));
        L4M_FCTS.put("sqrt", new MathWrapper(4));
        L4M_FCTS.put("exp", new MathWrapper(5));
        L4M_FCTS.put("ln", new MathWrapper(-5));
        L4M_FCTS.put("log", new MathWrapper(-15));
        L4M_FCTS.put("log10", new MathWrapper(-15));
        L4M_FCTS.put("pow", new MathWrapper(6));
        L4M_FCTS.put("sinh", new MathWrapper(7));
        L4M_FCTS.put("cosh", new MathWrapper(8));
        // Lab4Math special functions
        L4M_FCTS.put("tanh", de.lab4inf.math.functions.HyperbolicTangent.FCT);
        L4M_FCTS.put("acosh", new de.lab4inf.math.functions.ArcHyperbolicCosine());
        L4M_FCTS.put("asinh", new de.lab4inf.math.functions.ArcHyperbolicSine());
        L4M_FCTS.put("atanh", new de.lab4inf.math.functions.ArcHyperbolicTangent());
        L4M_FCTS.put("j0", new de.lab4inf.math.functions.Bessel(0));
        L4M_FCTS.put("j1", new de.lab4inf.math.functions.Bessel(1));
        L4M_FCTS.put("beta", new de.lab4inf.math.functions.Beta());
        L4M_FCTS.put("gamma", new de.lab4inf.math.functions.Gamma());
        L4M_FCTS.put("si", new de.lab4inf.math.functions.SineIntegral());
        L4M_FCTS.put("sinc", new de.lab4inf.math.functions.Sinc());
        L4M_FCTS.put("erf", new de.lab4inf.math.functions.Erf());
        L4M_FCTS.put("zeta", new de.lab4inf.math.functions.Zeta());

    }

    /*
     * (non-Javadoc)
     *
     * @see de.lab4inf.math.FunctionResolver#byName(java.lang.String)
     */
    @Override
    public Function byName(final String fctName) throws NoSuchMethodException {
        if (L4M_FCTS.containsKey(fctName)) {
            return L4M_FCTS.get(fctName);
        }
        final String msg = format("unknown function %s", fctName);
        logger.warn(msg);
        throw new NoSuchMethodException(msg);
    }

    /*
     * (non-Javadoc)
     *
     * @see de.lab4inf.math.FunctionResolver#functionNames()
     */
    @Override
    public Set<String> functionNames() {
        return L4M_FCTS.keySet();
    }

    /**
     * Wrapper class for some of the java.lang.Math methods.
     */
    static class MathWrapper extends L4MFunction {
        private final int id;

        MathWrapper(final int t) {
            id = t;
        }

        private IllegalArgumentException illegal(final String msg) {
            return new IllegalArgumentException(msg);
        }

        /*
         * (non-Javadoc)
         *
         * @see de.lab4inf.math.Function#f(double[])
         */
        @Override
        public double f(final double... x) {
            double ret = 0;
            if (x == null || x.length < 1)
                throw illegal("function needs arguments");
            switch (id) {
                case 0:
                    ret = Math.abs(x[0]);
                    break;
                case 1:
                    ret = Math.sin(x[0]);
                    break;
                case 2:
                    ret = Math.cos(x[0]);
                    break;
                case 3:
                    ret = Math.tan(x[0]);
                    break;
                case 4:
                    ret = Math.sqrt(x[0]);
                    break;
                case 5:
                    ret = Math.exp(x[0]);
                    break;
                case 6:
                    if (x.length != 2)
                        throw illegal("pow needs two arguments");
                    ret = Math.pow(x[0], x[1]);
                    break;
                case 7:
                    ret = Math.sinh(x[0]);
                    break;
                case 8:
                    ret = Math.cosh(x[0]);
                    break;
                // inverse functions
                case -1:
                    ret = Math.asin(x[0]);
                    break;
                case -2:
                    ret = Math.acos(x[0]);
                    break;
                case -3:
                    ret = Math.atan(x[0]);
                    break;
                case -13:
                    if (x.length != 2)
                        throw illegal("atan2 needs two arguments");
                    ret = Math.atan2(x[0], x[1]);
                    break;
                case -5:
                    ret = Math.log(x[0]);
                    break;
                case -15:
                    ret = Math.log10(x[0]);
                    break;
                default:
                    final String msg = String.format("undefinded java.lang.Math function id=%d", id);
                    logger.info(msg);
                    throw new RuntimeException(msg);
            }
            return ret;
        }
    }
}
 