 
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
  
  import java.io.Reader;
  
  import javax.script.ScriptEngine;
  import javax.script.ScriptException;
  
  import de.lab4inf.math.Script;
  /**
   * Lab4Math extension of the ScriptEngine interface, providing
   * compiled script instances.
   * 
   * To get an instance of a L4M ScriptEngine use the Lab4Math Loader:
   * <pre>
   * 
   *   L4MScriptEngineFactor factory = L4MLoader.load(L4MScriptEngineFactory.class);
   *   L4MScriptEngine engine = factory.getL4MScriptEngine();; 
   * 
   * </pre>
   * or the standard javax.script.ScriptEngineManager using extension "l4m":
   * <pre>
   * 
   *   ScriptEngineManager manager = new ScriptEngineManager();
   *   ScriptEngine anEngine =  manager.getEngineByExtension("l4m");
   *   assert anEngine!= null : "no L4M based engine found";
   *   L4MScriptEngine engine = (L4MScriptEngine) anEngine;
   * </pre>
   * after this you can use it to parse String/Reader based script 
   * definitions and obtain usable L4M functions ready to execute like:
   * <pre>
   * 
   *   double x = 0.3;
   *   Script script = engine.parse("foo(a) = sin(a)");
   *   Function aFct = script.getFunction("foo");
   *   
   *   System.out.printf("Function %s(%.2f)=%f\n","foo",x,aFct.f(x)); 
   * 
   * </pre>
   * Note: The parse method is just a type-safe shorthand for the
   * (Script)eval(definition) method of javax.script.ScriptEngine.
   * 
   * @see javax.script.ScriptEngineFactory
   * @see javax.script.ScriptEngine
   * @see de.lab4inf.math.L4MLoader
   * @see de.lab4inf.math.Script
   * 
   * @author nwulff
   * @since  07.01.2012
   * @version $Id: L4MScriptEngine.java,v 1.4 2012/01/08 15:09:14 nwulff Exp $
   */
  public interface L4MScriptEngine extends ScriptEngine {
      /**
       * Access to  the internal L4MWalker of the script engine.
       * @return L4MScriptWalker
       */
      L4MScriptWalker getWalker();
      /**
       * Parse the given script definition into the script engine context.
       * This call is equal to (Script) engine.eval(def), i.e. eval and
       * parse will return the same resulting object.
       * @see javax.script.ScriptEngine#eval(String)
       * @param definition of this script
       * @return a L4M Script instance
       * @throws ScriptException in case of an error
       */
      Script parse(final String definition) throws ScriptException;
      /**
       * Parse the given script definition from the reader into the script engine context.
       * This call is equal to (Script) engine.eval(reader).
       * @see javax.script.ScriptEngine#eval(String)
       * @param reader with the script definition
       * @return a L4M Script instance
       * @throws ScriptException in case of an error
       */
      Script parse(final Reader reader) throws ScriptException;
  }
 