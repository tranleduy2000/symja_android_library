/*
 * Project: Lab4Exp
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
package de.lab4inf.math.scripting.javacc;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

import de.lab4inf.math.scripting.L4MScriptEngineFactory;
import de.lab4inf.math.scripting.L4MScriptWalker;

import static java.lang.String.format;

/**
 * JavaCC-jjTree based Lab4Math scripting engine factory.
 *
 * @author nwulff
 * @version $Id: JavaCCScriptEngineFactory.java,v 1.6 2012/01/09 11:19:04 nwulff Exp $
 * @since 05.01.2012
 */
public class JavaCCScriptEngineFactory extends L4MScriptEngineFactory {
    private static final JavaCCScriptEngineFactory FACTORY;
    private static final ScriptEngine ENGINE_PROTOTYPE;

    static {
        FACTORY = new JavaCCScriptEngineFactory();
        ENGINE_PROTOTYPE = FACTORY.getScriptEngine();
        //java.util.logging.Level lev = LOGGER.getLevel();
        //LOGGER.setLevel(java.util.logging.Level.ALL);
        LOGGER.info(format("%s intialized", FACTORY));
        //LOGGER.setLevel(lev);
    }

    /**
     * Access to a factory instance.
     *
     * @return ScriptEngineFactory
     */
    public static final JavaCCScriptEngineFactory getInstance() {
        return FACTORY;
    }

    /*
     * (non-Javadoc)
     * @see de.lab4inf.math.scripting.L4MScriptEngineFactory#inject(de.lab4inf.math.scripting.L4MScriptWalker)
     */
    @Override
    protected void inject(final L4MScriptWalker walker) throws ScriptException {
        super.inject(walker);
        // this method makes inject visible within this package to the parser
    }

    /* (non-Javadoc)
     * @see javax.script.ScriptEngineFactory#getScriptEngine()
     */
    @Override
    public ScriptEngine getScriptEngine() {
        try {
            return new JavaCCParser();
        } catch (Exception e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }

    /* (non-Javadoc)
     * @see javax.script.ScriptEngineFactory#getParameter(java.lang.String)
     */
    @Override
    public Object getParameter(final String key) {
        // logger.warn(format("getParameter %s",key));
        return ENGINE_PROTOTYPE.get(key);
    }
}
 