 
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
  package de.lab4inf.math.scripting;
  
  import static java.lang.String.format;
  
  import java.util.HashMap;
  import java.util.Set;
  
  import javax.script.CompiledScript;
  import javax.script.Invocable;
  import javax.script.ScriptContext;
  import javax.script.ScriptEngine;
  import javax.script.ScriptException;
  
  import de.lab4inf.math.Function;
  import de.lab4inf.math.L4MLogger;
  
  /**
   *  An invocable compiled script as result of the Lab4Math scripting engine.
   *
   * @author nwulff
   * @since  05.01.2012
   * @version $Id: L4MScriptWalker.java,v 1.8 2014/11/18 23:41:21 nwulff Exp $
   */
  public abstract class L4MScriptWalker extends CompiledScript implements Invocable {
      protected static final String NOT_IMPLEMENTED = "not implemented";
      protected static final String NOT_AN_INTERFACE = "not a valid interface class";
      protected static final String NOT_A_FUNCTION_NAME = "not a valid function name";
      protected static final L4MLogger LOGGER = L4MLogger.getLogger("de.lab4inf.math.scripting");
      protected final L4MLogger logger = LOGGER;
      protected static final String FCTSTRING = "_L4M_RET_FUNCTION_";
      protected static final String RETSTRING = "_L4M_RET_STRING_";
      protected static final String RETVALUE = "_L4M_RET_VALUE_";
      protected static final String DEFINITIONS = "_L4M_DEFINITIONS_";
      protected static final String FUNCTIONS = "_L4M_FUNCTIONS_";
      protected static final String VARIABLES = "_L4M_VARIABLES_";
      protected ScriptEngine engine;
      protected HashMap<String, Double> vars = new HashMap<String, Double>();
      protected HashMap<String, Function> fcts = new HashMap<String, Function>();
      protected Number lastRetValue;
      protected String lastRetName = "";
      protected String lastFctName = "";
      protected ScriptContext ctx;
      private boolean throwing = false;
  
      /**
       * Hidden constructor for derived classes.
       * @param parser used during generation
       * @param context the walker uses
       * @throws ScriptException in case of an error
       */
      protected L4MScriptWalker(final ScriptEngine parser, final ScriptContext context) throws ScriptException {
          this.engine = parser;
          ctx = context;
          // logger.error("fresh ctor " +ctx);
          ctx.setAttribute(VARIABLES, vars, ScriptContext.ENGINE_SCOPE);
          ctx.setAttribute(FUNCTIONS, fcts, ScriptContext.ENGINE_SCOPE);
      }
  
      /**
       * Hidden constructor for derived classes.
       * @param parent of this walker for chaning
       * @throws ScriptException in case of an error
       */
      protected L4MScriptWalker(final L4MScriptWalker parent) throws ScriptException {
          engine = parent.engine;
          ctx = parent.ctx;
          // logger.error("parent ctor " +ctx);
          vars = parent.vars;
          fcts = parent.fcts;
          ctx.setAttribute(VARIABLES, vars, ScriptContext.ENGINE_SCOPE);
          ctx.setAttribute(FUNCTIONS, fcts, ScriptContext.ENGINE_SCOPE);
      }
  
      /**
       * Define a new function during the parsing/walker execution. The
       * details are parser/walker specific and depend on the implementation.
       * @param fctName to to define
       * @return defined function
       * @throws ScriptException in case of an error
      */
     protected abstract Function defineFunction(String fctName) throws ScriptException;
 
     /*
      * (non-Javadoc)
      *
      * @see javax.script.CompiledScript#eval(javax.script.ScriptContext)
      */
     @SuppressWarnings("unchecked")
     @Override
     public Object eval(final ScriptContext context) throws ScriptException {
         vars = (HashMap<String, Double>) context.getAttribute(VARIABLES, ScriptContext.ENGINE_SCOPE);
         fcts = (HashMap<String, Function>) context.getAttribute(FUNCTIONS, ScriptContext.ENGINE_SCOPE);
         lastRetValue = (Number) context.getAttribute(RETVALUE, ScriptContext.ENGINE_SCOPE);
         lastRetName = (String) context.getAttribute(RETSTRING, ScriptContext.ENGINE_SCOPE);
         lastFctName = (String) context.getAttribute(FCTSTRING, ScriptContext.ENGINE_SCOPE);
         // logger.info("END eval " +ctx+ " " +lastRetValue);
         return lastRetValue;
     }
 
     /*
      * (non-Javadoc)
      *
      * @see javax.script.CompiledScript#getEngine()
      */
     @Override
     public final ScriptEngine getEngine() {
         return engine;
     }
 
     /**
      * Return the value of a named variable.
      * @param name of variable
      * @return value of variable
      * @throws ScriptException in case of an error
      */
     public final double getVariable(final String name) throws ScriptException {
         if (vars.containsKey(name)) {
             return vars.get(name);
         }
         final String msg = format("no variable %s", name);
         if (isThrowing()) {
             logger.info(msg);
             throw new ScriptException(msg);
         }
         logger.warn(msg);
         return 0;
     }
 
     /**
      * Set the value of a named variable.
      * @param name of variable
      * @param value to set
      * @throws ScriptException in case of an error
      */
     public final void setVariable(final String name, final double value) throws ScriptException {
         vars.put(name, value);
     }
 
     /**
      * Add a named function implementation.
      * @param name of function
      * @param fct to add
      * @throws ScriptException in case of an error
      */
     public final void addFunction(final String name, final Function fct) throws ScriptException {
         // logger.info(format("add %s %s \n", name, fct));
         fcts.put(name, fct);
         lastFctName = name;
     }
 
     /**
      * Get the reference of a named function
      * @param name of function
      * @return function
      * @throws ScriptException in case of an error
      */
     public final Function getFunction(final String name) throws ScriptException {
         Function fct;
         if (fcts.containsKey(name)) {
             fct = fcts.get(name);
         } else {
             fct = defineFunction(name);
         }
         return fct;
     }
 
     /**
      * Evaluate a named function with given arguments
      * @param name of function to invoke.
      * @param x parameter
      * @return f(x)
      * @throws ScriptException in case of an error
      */
     public final double evalFct(final String name, final double... x) throws ScriptException {
         final Function fct = getFunction(name);
         return fct.f(x);
     }
 
     /**
      * Return the last calculated value during script execution
      * @return double last value
      */
     public final double getRetValue() {
         return lastRetValue.doubleValue();
     }
 
     /**
      * Return the name of the last assigned script variable
      * @return last variable name
      */
     public final String getRetString() {
         return lastRetName;
     }
 
     /**
      * Return the name of the last assigned script function
      * @return last function name
      */
     public final String getFctName() {
         return lastFctName;
     }
 
     /**
      * Get the names of all known functions
      * @return set with function names
      */
     public final Set<String> getFunctionNames() {
         return fcts.keySet();
     }
 
     /**
      * Get the names of all known variables
      * @return set with variable names
      */
     public final Set<String> getVariableNames() {
         return vars.keySet();
     }
 
     /*
      * (non-Javadoc)
      * 
      * @see javax.script.Invocable#invokeFunction(java.lang.String, java.lang.Object[])
      */
     @Override
     public Object invokeFunction(final String name, final Object... args) throws ScriptException, NoSuchMethodException {
         if (args!=null&&args.length>0) {
             final double[] x = new double[args.length];
             for (int i = 0; i<args.length; i++) {
                 if (!(args[i] instanceof Number))
                     throw new ScriptException("only Numbers as argument allowed");
                 x[i] = ((Number) args[i]).doubleValue();
             }
             return evalFct(name, x);
         }
         throw new ScriptException("no arguments given");
     }
 
     /*
      * (non-Javadoc)
      * 
      * @see javax.script.Invocable#invokeMethod(java.lang.Object, java.lang.String, java.lang.Object[])
      */
     @Override
     public Object invokeMethod(final Object obj, final String methodName, final Object... args) throws ScriptException,
             NoSuchMethodException {
         if (obj==null||!(obj instanceof Function)) {
             throw new IllegalArgumentException(NOT_AN_INTERFACE);
         }
         throw new ScriptException(NOT_IMPLEMENTED);
         /*
          * logger.setLevel(java.util.logging.Level.ALL); Method method = null; int nargs = 0; if(args!=null) { nargs=
          * args.length; } boolean allDouble = true; double[] d = new double[0]; Class<?>[] types = new Class<?>[nargs];
          * Class<?> clazz = obj.getClass(); for(int j=0;j<nargs;j++) { types[j] = args[j].getClass(); allDouble &=
          * (types[j] == Double.class); logger.info(format("arg[%d]=%s type:%s",j,args[j],types[j])); }
          * logger.info(format("%s allDouble: %b",methodName, allDouble)); if(allDouble) { d = new double[nargs]; types =
          * new Class[1]; types[0] = d.getClass(); for(int j=0;j<nargs;j++) { d[j] = ((Double)args[j]).doubleValue(); } }
          * method = clazz.getMethod(methodName, types);
          * 
          * try { if(allDouble) return method.invoke(obj, d); else return method.invoke(obj, args); } catch (Exception e)
          * { logger.error(e); ScriptException error = new ScriptException(e); throw error; }
          */
     }
 
     /*
      * (non-Javadoc)
      *
      * @see javax.script.Invocable#getInterface(java.lang.Class)
      */
     @Override
     public <T> T getInterface(final Class<T> clazz) {
         if (clazz==null||!clazz.isInterface()) {
             throw new IllegalArgumentException(NOT_AN_INTERFACE);
         }
         // TODO not implemented within this script engine
         logger.warn("getInterface no implementation for "+clazz);
         return null;
     }
 
     /*
      * (non-Javadoc)
      * 
      * @see javax.script.Invocable#getInterface(java.lang.Object, java.lang.Class)
      */
     @SuppressWarnings("unchecked")
     @Override
     public <T> T getInterface(final Object that, final Class<T> clazz) {
         if (clazz==null||!clazz.isInterface()) {
             throw new IllegalArgumentException(NOT_AN_INTERFACE);
         }
         if (that==null||!(that instanceof String)) {
             throw new IllegalArgumentException(NOT_A_FUNCTION_NAME);
         }
         Function fct = null;
         try {
             if (Function.class.isAssignableFrom(clazz)) {
                 final String name = that.toString();
                 fct = getFunction(name);
             }
         } catch (final Exception e) {
             logger.info("getInferface: "+e);
         }
         if (fct==null) {
             throw new IllegalArgumentException(that+" for "+clazz);
         }
         return (T) fct;
     }
 
     /**
      * @return isThrowing flag
      */
     public boolean isThrowing() {
         return throwing;
     }
 
     /**
      * Set the flag if the walker should throw exception to unknown variables.
      * @param isThrowing flag
      */
     public void setThrowing(final boolean isThrowing) {
         this.throwing = isThrowing;
     }
 }
 