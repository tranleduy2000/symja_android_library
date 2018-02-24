 
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
  
  import java.util.ArrayList;
  import java.util.List;
  
  import javax.script.ScriptEngine;
  import javax.script.ScriptEngineFactory;
  import javax.script.ScriptException;
  
  import de.lab4inf.math.FunctionResolver;
  import de.lab4inf.math.L4MLoader;
  import de.lab4inf.math.L4MObject;
  import de.lab4inf.math.Service;
  /**
   * Lab4Math scripting engine factory prototype as a Service.
   *
   * @author nwulff
   * @since  05.01.2012
   * @version $Id: L4MScriptEngineFactory.java,v 1.11 2012/06/23 12:47:43 nwulff Exp $
   */
  @Service
  public abstract class L4MScriptEngineFactory extends L4MObject implements ScriptEngineFactory {
      /** Extension of the script engine. */
      private static final String EXTENSION = "l4m";
      private static final String NOT_IMPLEMENTED = "not implemented";
      private static final String LAB4MATH = "Lab4Math";
      protected static final FunctionResolver FCT_RESOLVER = L4MLoader.load(FunctionResolver.class);
      /*
       * (non-Javadoc)
       * @see de.lab4inf.math.L4MObject#toString()
       */
      @Override
      public final String toString() {
          return format("javax.script.ScriptEngineFactory %s-%s",getEngineName(),getEngineVersion());
      }
      /**
       * Returns an instance of a L4M ScriptEngine associated
       * with this ScriptEngine implementation.
       * 
       * @see javax.script.ScriptEngineFactory#getScriptEngine()
       * @return L4MScriptEngine instance
       */
      public final L4MScriptEngine getL4MScriptEngine() {
          return (L4MScriptEngine) getScriptEngine();
      }
      /* (non-Javadoc)
       * @see javax.script.ScriptEngineFactory#getScriptEngine()
       */
      @Override
      public abstract ScriptEngine getScriptEngine();
      /* (non-Javadoc)
       * @see javax.script.ScriptEngineFactory#getEngineName()
       */
      @Override
      public final String getEngineName() {
          //logger.error("getEngineName");
          return LAB4MATH;
      }
      /* (non-Javadoc)
       * @see javax.script.ScriptEngineFactory#getEngineVersion()
       */
      @Override
      public final String getEngineVersion() {
          //logger.error("getEngineVerion");
          return L4MObject.getVersion();
      }
      /* (non-Javadoc)
       * @see javax.script.ScriptEngineFactory#getExtensions()
       */
      @Override
      public final List<String> getExtensions() {
          //logger.error("getExtensions");
          ArrayList<String> list = new ArrayList<String>();
          list.add(EXTENSION);
          list.add("txt");
          return list;
      }
     /* (non-Javadoc)
      * @see javax.script.ScriptEngineFactory#getLanguageName()
      */
     @Override
     public final String getLanguageName() {
         //logger.error("getLanguageName");
         return EXTENSION;
     }
     /* (non-Javadoc)
      * @see javax.script.ScriptEngineFactory#getLanguageVersion()
      */
     @Override
     public final String getLanguageVersion() {
         //logger.error("getLanguageVersion");
         return "1.0.0";
     }
     /* (non-Javadoc)
      * @see javax.script.ScriptEngineFactory#getMimeTypes()
      */
     @Override
     public final List<String> getMimeTypes() {
         //logger.error("getMimeTypes");
         ArrayList<String> list = new ArrayList<String>();
         list.add("text/plain");
         return list;
     }
     /* (non-Javadoc)
      * @see javax.script.ScriptEngineFactory#getNames()
      */
     @Override
     public final List<String> getNames() {
         //logger.error("getNames");
         ArrayList<String> names = new ArrayList<String>();
         names.add(LAB4MATH);
         names.add(EXTENSION);
         return names;
     }
     /* (non-Javadoc)
      * @see javax.script.ScriptEngineFactory#getOutputStatement(java.lang.String)
      */
     @Override
     public String getOutputStatement(final String stm) {
         //logger.warn("getOutputStatement not implemented");
         return stm;
     }
     /* (non-Javadoc)
      * @see javax.script.ScriptEngineFactory#getProgram(java.lang.String[])
      */
     @Override
     public String getProgram(final String... stmts) {
         logger.error("getProgram");
         throw new IllegalStateException(NOT_IMPLEMENTED);
     }
     /* (non-Javadoc)
      * @see javax.script.ScriptEngineFactory#getMethodCallSyntax(java.lang.String, java.lang.String, java.lang.String[])
      */
     @Override
     public String getMethodCallSyntax(final String obj,final String method,final String... args) {
         logger.error("getMethodCallSyntax");
         throw new IllegalStateException(NOT_IMPLEMENTED);
     }
     /**
      * Implementation specific injection of some Lab4Math functions
      * and constants into a L4M tree walker.
      * @param walker to inject
      * @throws ScriptException in case of an error
      */
     protected void inject(final L4MScriptWalker walker) throws ScriptException {
         // some constants
         walker.setVariable("PI", Math.PI);
         walker.setVariable("E", Math.E);
         // some dummy variables
         walker.setVariable("x", 0);
         walker.setVariable("y", 0);
         // inject the well known functions
         try {
             for(String fctName:FCT_RESOLVER.functionNames()) {
                 walker.addFunction(fctName,FCT_RESOLVER.byName(fctName));
             }
         }catch(NoSuchMethodException error) {
             // should never happen for known functions.
             logger.error(error);
         }
     }
 }
 