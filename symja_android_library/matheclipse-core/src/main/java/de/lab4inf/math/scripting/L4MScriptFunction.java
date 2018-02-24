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
package de.lab4inf.math.scripting;

import javax.script.ScriptException;

import de.lab4inf.math.functions.L4MFunction;

import static java.lang.String.format;

/**
 * Script based function implementation.
 * <pre>
 *
 *  L4MScriptEngine engine = ...
 *  Script script = engine.parse("foo(x,y)=sin(x)*cos(y)");
 *  Function fct = script.getFunction("foo");
 *  System.out.printf("foo(0.2,0.3)=%f \n",fct.f(0.2,0.3));
 *
 * </pre>
 *
 * @author nwulff
 * @version $Id: L4MScriptFunction.java,v 1.9 2014/11/18 23:41:21 nwulff Exp $
 * @see de.lab4inf.math.Function
 * @see de.lab4inf.math.Script
 * @see de.lab4inf.math.scripting.L4MScriptEngine
 * @since 07.01.2012
 */
public abstract class L4MScriptFunction extends L4MFunction {
    private static final String ARGUMENTS_MISSMATCH = "%s arguments missmatch %d != %d";
    protected final L4MScriptWalker walker;
    protected final String name;
    protected String[] varNames = {""};
    protected double[] tmpVars = {0};
    protected int numArgs = 1;

    /**
     * Named constructor.
     *
     * @param walker script walker of this function
     * @param name   of the function.
     * @throws ScriptException in case of an error
     */
    protected L4MScriptFunction(final L4MScriptWalker walker, final String name) throws ScriptException {
        this.name = name;
        this.walker = walker;
    }

    /**
     * Make sure the the varNames are register within the script engine
     * before first usage of pushVars and popVars.
     *
     * @throws ScriptException in case of an error
     */
    protected abstract void registerVariables() throws ScriptException;

    /**
     * Store the internal function arguments before executing the script
     *
     * @param x the function arguments
     * @throws ScriptException in case of an error
     */
    protected void pushVars(final double... x) throws ScriptException {
        if (numArgs != x.length) {
            final String msg = format(ARGUMENTS_MISSMATCH, name, numArgs, x.length);
            logger.info(msg);
            throw new IllegalArgumentException(msg);
        }
        for (int j = 0; j < numArgs; j++) {
            tmpVars[j] = walker.getVariable(varNames[j]);
            walker.setVariable(varNames[j], x[j]);
        }
    }

    /**
     * Restore the function arguments after execution.
     *
     * @throws ScriptException in case of an error
     */
    protected void popVars() throws ScriptException {
        for (int j = 0; j < numArgs; j++) {
            walker.setVariable(varNames[j], tmpVars[j]);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see de.lab4inf.math.Function#f(double[])
     */
    @Override
    public double f(final double... x) {
        double ret = 0;
        try {
            pushVars(x);
            try {
                ret = doCalculate(x);
            } catch (final ScriptException e) {
                throw new RuntimeException(e);
            } finally {
                popVars();
            }
        } catch (final ScriptException e) {
            throw new RuntimeException(e);
        }
        return ret;
    }

    /**
     * Internal implementation for the function evaluation.
     *
     * @param x the arguments
     * @return f(x)
     * @throws ScriptException in case of an error
     */
    protected abstract double doCalculate(final double... x) throws ScriptException;
}
 