 
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
  
  package de.lab4inf.math.scripting;
  
  import java.io.Reader;
  import java.util.List;
  import java.util.Set;
  
  import javax.script.ScriptEngineFactory;
  import javax.script.ScriptEngineManager;
  import javax.script.ScriptException;
  
  import de.lab4inf.math.Function;
  import de.lab4inf.math.L4MObject;
  import de.lab4inf.math.Script;
  
  /**
   * Lab4Math script engine wrapper class implementing the Script interface.
   *
   * @see de.lab4inf.math.Script
   * @author  nwulff
   * @since   05.01.2012
   * @version $Id: L4MScript.java,v 1.8 2014/11/18 23:41:21 nwulff Exp $
   */
  public class L4MScript extends L4MObject implements Script {
      private static final String NO_SCRIPT_ENGINE = "no script engine";
      private static final String NO_SCRIPT_WALKER = "no script walker";
      private static L4MScriptEngineFactory factory = null;
      protected L4MScriptEngine engine;
      protected L4MScriptWalker walker;
      static {
          final ScriptEngineManager manager = new ScriptEngineManager();
          final List<ScriptEngineFactory> factories = manager.getEngineFactories();
          for (final ScriptEngineFactory f : factories) {
              // logger.info(f);
              final String fname = f.getEngineName();
              if (fname!=null&&fname.contains("Lab4Math")) {
                  factory = (L4MScriptEngineFactory) f;
                  break;
              }
          }
          if (null==factory) {
              throw new RuntimeException("no Lab4Math script engine found");
          }
      }
  
      /**
       * Sole POJO constructor.
       * @throws ScriptException during parsing
       */
      public L4MScript() throws ScriptException {
          this(null, "");
      }
  
      /**
       * Constructor with script definition.
       * @param defintion of the script
       * @throws ScriptException during parsing
       */
      public L4MScript(final String defintion) throws ScriptException {
          this(null, defintion);
      }
  
      /**
       * Chaining constructor with given parent script to merge.
       * @param parent of this script
       * @throws ScriptException during parsing
       */
      public L4MScript(final L4MScript parent) throws ScriptException {
          this(parent, "");
      }
  
      /**
       * Constructor with script definition and parent script to merge.
       * @param parent of this script
       * @param definition for this script
       * @throws ScriptException during parsing
       */
      public L4MScript(final L4MScript parent, final String definition) throws ScriptException {
          if (null!=parent) {
             engine = parent.engine;
             walker = parent.walker;
             if (null==walker)
                 throw new ScriptException(NO_SCRIPT_WALKER);
         } else {
             engine = (L4MScriptEngine) factory.getScriptEngine();
         }
         if (null==engine)
             throw new ScriptException(NO_SCRIPT_ENGINE);
         setScript(definition);
     }
 
     /**
      * Internal constructor used by the script engine.
      * @param engine in use
      * @param walker in ues
      * @throws ScriptException during parsing
      */
     public L4MScript(final L4MScriptEngine engine, final L4MScriptWalker walker) throws ScriptException {
         this.engine = engine;
         this.walker = walker;
         if (null==walker)
             throw new ScriptException(NO_SCRIPT_WALKER);
         if (null==engine)
             throw new ScriptException(NO_SCRIPT_ENGINE);
     }
 
     /*
      * (non-Javadoc)
      *
      * @see de.lab4inf.math.Script#getFunction(java.lang.String)
      */
     @Override
     public Function getFunction(final String name) throws ScriptException {
         return walker.getFunction(name);
     }
 
     /*
      * (non-Javadoc)
      *
      * @see de.lab4inf.math.Script#evalFct(java.lang.String, double[])
      */
     @Override
     public double evalFct(final String name, final double... x) throws ScriptException {
         return walker.evalFct(name, x);
     }
 
     /*
      * (non-Javadoc)
      *
      * @see de.lab4inf.math.Script#getVariable(java.lang.String)
      */
     @Override
     public double getVariable(final String name) throws ScriptException {
         return walker.getVariable(name);
     }
 
     /*
      * (non-Javadoc)
      *
      * @see de.lab4inf.math.Script#getRetValue()
      */
     @Override
     public double getRetValue() {
         return walker.getRetValue();
     }
 
     /*
      * (non-Javadoc)
      *
      * @see de.lab4inf.math.Script#setScript(java.lang.String)
      */
     @Override
     public void setScript(final String script) throws ScriptException {
         if (null!=script) {
             engine.eval(script);
             walker = engine.getWalker();
             if (null==walker)
                 throw new ScriptException(NO_SCRIPT_WALKER);
         }
     }
 
     /*
      * (non-Javadoc)
      *
      * @see de.lab4inf.math.Script#setScript(java.io.Reader)
      */
     @Override
     public void setScript(final Reader reader) throws ScriptException {
         if (null!=reader) {
             engine.eval(reader);
             walker = engine.getWalker();
             if (null==walker)
                 throw new ScriptException(NO_SCRIPT_WALKER);
         }
     }
 
     /*
      * (non-Javadoc)
      *
      * @see de.lab4inf.math.Script#getFunctionNames()
      */
     @Override
     public Set<String> getFunctionNames() {
         return walker.getFunctionNames();
     }
 
     /*
      * (non-Javadoc)
      *
      * @see de.lab4inf.math.Script#getVariableNames()
      */
     @Override
     public Set<String> getVariableNames() {
         return walker.getVariableNames();
     }
 
     /*
      * (non-Javadoc)
      *
      * @see de.lab4inf.math.Script#getRetString()
      */
     @Override
     public String getRetString() {
         return walker.getRetString();
     }
 
     /*
      * (non-Javadoc)
      *
      * @see de.lab4inf.math.Script#getFctName()
      */
     @Override
     public String getFctName() {
         return walker.getFctName();
     }
 
     /*
      * (non-Javadoc)
      *
      * @see de.lab4inf.math.Script#setVariable(java.lang.String, double)
      */
     @Override
     public void setVariable(final String name, final double value) throws ScriptException {
         walker.setVariable(name, value);
     }
 
     /*
      * (non-Javadoc)
      *
      * @see javax.script.Invocable#getInterface(java.lang.Class)
      */
     @Override
     public <T> T getInterface(final Class<T> clazz) {
         return walker.getInterface(clazz);
     }
 
     /*
      * (non-Javadoc)
      *
      * @see javax.script.Invocable#getInterface(java.lang.Object, java.lang.Class)
      */
     @Override
     public <T> T getInterface(final Object that, final Class<T> clazz) {
         return walker.getInterface(that, clazz);
     }
 
     /*
      * (non-Javadoc)
      *
      * @see javax.script.Invocable#invokeFunction(java.lang.String, java.lang.Object[])
      */
     @Override
     public Object invokeFunction(final String name, final Object... args) throws ScriptException, NoSuchMethodException {
         return walker.invokeFunction(name, args);
     }
 
     /*
      * (non-Javadoc)
      *
      * @see javax.script.Invocable#invokeMethod(java.lang.Object, java.lang.String, java.lang.Object[])
      */
     @Override
     public Object invokeMethod(final Object that, final String name, final Object... args) throws ScriptException,
     NoSuchMethodException {
         return walker.invokeMethod(that, name, args);
     }
 
     /*
      * (non-Javadoc)
      *
      * @see de.lab4inf.math.Script#setThrowing(boolean)
      */
     @Override
     public void setThrowing(final boolean shouldThrow) {
         walker.setThrowing(shouldThrow);
     }
 }
 