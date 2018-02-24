 
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
  
  import static java.lang.String.format;
  
  import java.lang.reflect.Constructor;
  import java.util.ArrayList;
  import java.util.HashMap;
  
  import javax.script.ScriptContext;
  import javax.script.ScriptException;
  
  import de.lab4inf.math.Function;
  import de.lab4inf.math.scripting.L4MScriptFunction;
  import de.lab4inf.math.scripting.L4MScriptWalker;
  
  /**
   *  A javaCC compiled script as result of the Lab4Math scripting engine.
   *
   * @author nwulff
   * @since  05.01.2012
   * @version $Id: JavaCCScriptWalker.java,v 1.7 2012/01/08 13:27:38 nwulff Exp $
   */
  public class JavaCCScriptWalker extends L4MScriptWalker implements
          JavaCCParserVisitor, JavaCCParserTreeConstants {
      private JavaCCParser parser;
      private HashMap<String, SimpleNode> defs = new HashMap<String, SimpleNode>();
      private SimpleNode root;
      protected JavaCCScriptWalker self = this; // this pointer for script function
      /**
       * Package hidden constructor.
       * @param parser used for the script
       * @param node as root of the script
       * @throws ScriptException if an error happens
       */
      JavaCCScriptWalker(final JavaCCParser parser, final ScriptContext context,
              final SimpleNode node) throws ScriptException {
          super(parser,context);
          this.parser = parser;
          root = node;
          ctx.setAttribute(DEFINITIONS, defs, ScriptContext.ENGINE_SCOPE);
          visit(root, 0);
      }
      /**
       * Package hidden constructor.
       * @param parent walker for merging.
       * @param node as root of this script
       * @throws ScriptException if an error happens
       */
      JavaCCScriptWalker(final JavaCCScriptWalker parent, final SimpleNode node)
              throws ScriptException {
          super(parent);
          parser = parent.parser;
          root = node;
          defs = parent.defs;
          ctx.setAttribute(DEFINITIONS, defs, ScriptContext.ENGINE_SCOPE);
          visit(root, 0);
      }
  
      /*
       * (non-Javadoc)
       * 
       * @see javax.script.CompiledScript#eval(javax.script.ScriptContext)
       */
      @SuppressWarnings("unchecked")
      @Override
      public final Object eval(final ScriptContext ctx) throws ScriptException {
          defs = (HashMap<String, SimpleNode>) ctx.getAttribute(DEFINITIONS,
                  ScriptContext.ENGINE_SCOPE);
           return super.eval(ctx);
      }
      /**
       * Helper method to find an indexed child node
       * @param parent node
       * @param index of child
       * @return child[index]
       * @throws ScriptException if an error happens
       */
      private SimpleNode child(final Node parent, final int index)
              throws ScriptException {
         if (null != parent) {
             if (parent.jjtGetNumChildren() > index) {
                 return ((SimpleNode) parent.jjtGetChild(index));
             }
             throw new ScriptException(format("no child index " + index));
         }
         throw new ScriptException(format("node NullPointer"));
     }
     /**
      * Helper method to find the parent of a child node
      * @param child node of the parent
      * @return parent of child
      * @throws ScriptException if an error happens
      */
     private SimpleNode parent(final Node child) throws ScriptException {
         if (null != child) {
             return (SimpleNode) child.jjtGetParent();
         }
         throw new ScriptException(format("child NullPointer"));
     }
     /**
      * Helper method to find the value of a child node
      * @param parent node
      * @param index of child
      * @param data to submit
      * @return child[index].value(data)
      * @throws ScriptException if an error happens
      */
     private double valueOf(final Node parent, final int index,
             final double... data) throws ScriptException {
         SimpleNode child = child(parent, index);
         if (null != child) {
             return child.jjtAccept(this, data);
         }
         throw new ScriptException(format("no child[%d] for %s\n", index, parent));
     }
     /**
      * Define a new function form the parsed script and add it to the walker context.
      * @param name of function
      * @return function if deklaration found during parsing
      * @throws ScriptException if an error happens
      */
     @Override
     protected Function defineFunction(final String name) throws ScriptException {
         Function fct = null;
         SimpleNode fctNode = defs.get(name);
         if (null == fctNode)
             throw new ScriptException("no function for " + name);
         fct = new ScriptFunction(name, fctNode);
         addFunction(name, fct);
         return fct;
     }
 
     /*
      * (non-Javadoc)
      * 
      * @see
      * de.lab4inf.math.scripting.javacc.JavaCCParserVisitor#visit(de.lab4inf
      * .math.scripting.javacc.SimpleNode, double[])
      */
     @Override
     public double visit(final SimpleNode node, final double... data) throws ScriptException {
         double x, y, ret = data[0];
         int id = node.id;
         String key, name;
         SimpleNode left, right;
         switch (id) {
         case JJTID: {
             key = node.value.toString();
             if (vars.containsKey(key)) {
                 // obtain the value
                 ret = vars.get(key);
                 lastRetValue = ret;
                 lastRetName = key;
             } 
             //logger.info(format("%s %s value: %s \n",node,key,ret));
         }
             break;
         case JJTBRACKET: {
             left = (SimpleNode) node.jjtGetChild(0);
             ret = visit(left, data);
             //logger.info(format("%s (%s) value: %s \n",node,left,ret));
         }
             break;
         case JJTASSIGN: {
             left = (SimpleNode) node.jjtGetChild(0);
             right = (SimpleNode) node.jjtGetChild(1);
             key = left.value.toString();
             ret = right.jjtAccept(this, data);
             lastRetName = key;
             lastRetValue = ret;
             //logger.info(format("Assign %s = %f \n", key, ret));
             vars.put(key, ret);
         }
             break;
         case JJTFCT: {
             left = child(node, 0);
             right = child(node, 1);
             // find the arguments for the function....
             int m = right.jjtGetNumChildren();
             double[] args = new double[m];
             for (int j = 0; j < m; j++) {
                 args[j] = valueOf(right, j, data);
             }
             key = left.value.toString();
             ret = evalFct(key, args);
             //logger.info(format("Fct %s() = %f \n", key, ret));
         }
             break;
         case JJTPLUS: {
             x = valueOf(node, 0, data);
             y = valueOf(node, 1, data);
             ret = x + y;
             lastRetValue = ret;
             //logger.info(format("Plus %f + %f = %f \n",x,y, ret));
         }
             break;
         case JJTMINUS:
             x = valueOf(node, 0, data);
             y = valueOf(node, 1, data);
             ret = x - y;
             lastRetValue = ret;
             //logger.info(format("Sub %f - %f = %f \n",x,y, ret));
             break;
         case JJTMULT:
             x = valueOf(node, 0, data);
             y = valueOf(node, 1, data);
             ret = x * y;
             lastRetValue = ret;
             //logger.info(format("Mul %f * %f = %f \n",x,y, ret));
             break;
         case JJTDIV:
             x = valueOf(node, 0, data);
             y = valueOf(node, 1, data);
             ret = x / y;
             lastRetValue = ret;
             //logger.info(format("Div %f / %f = %f \n",x,y, ret));
             break;
         case JJTPOW:
             x = valueOf(node, 0, data);
             y = valueOf(node, 1, data);
             ret = Math.pow(x, y);
             lastRetValue = ret;
             //logger.info(format("Pow %f ** %f = %f \n",x,y, ret));
             break;
         case JJTUNARY:
             ret = valueOf(node, 0, data);
             if (node.value != null)
                 ret = -ret;
             lastRetValue = ret;
             //logger.info(format("Unary %s = %f \n",node, ret));
             break;
         case JJTINT:
             lastRetValue = ((Integer) node.value);
             ret = ((Integer) node.value).intValue();
             lastRetValue = ret;
             //logger.info(format("%s = %f \n",node, ret));
             break;
         case JJTFLOAT:
             lastRetValue = ((Double) node.value);
             ret = ((Double) node.value).doubleValue();
             lastRetValue = ret;
             //logger.info(format("%s = %f \n",node, ret));
             break;
         case JJTDEFINE:
             right = child(node, 2);
             key = child(node, 0).value.toString();
             //logger.info(format("Define Fct %s() = \n", key));
             defs.put(key, node);
             lastFctName = key;
             if (right != null) {
                 visit(right, data);
             }
             break;
         case JJTJAVANATIVE: {
             Class<?> clazz;
             Function fct;
             name = child(parent(node), 0).value.toString();
             key = node.value.toString();
             //logger.info(format("Native Fct %s() = \n", key));
             try {
                 clazz = Class.forName(key);
             } catch (Exception e) {
                 throw new ScriptException(e);
             }
             if (node.jjtGetNumChildren() == 0) {
                 try {
                     fct = (Function) clazz.newInstance();
                 } catch (Exception e) {
                     throw new ScriptException(e);
                 }
             } else {
                 right = child(node, 0);
                 int numargs = right.jjtGetNumChildren();
                 Object[] cargs = new Object[numargs];
                 Class<?>[] types = new Class<?>[numargs];
                 for (int i = 0; i < numargs; i++) {
                     cargs[i] = child(child(right, i), 0).value;
                     types[i] = cargs[i].getClass();
                 }
                 try {
                     Constructor<?> ctor = clazz.getConstructor(types);
                     fct = (Function) ctor.newInstance(cargs);
                 } catch (Exception e) {
                     throw new ScriptException(e);
                 }
             }
             addFunction(name, fct);
         }
             break;
         case JJTSCRIPT:
             node.childrenAccept(this, data);
             break;
         default:
             String msg = format("unknown id %d node:%s value:%s", id, node,
                     node.value);
             logger.error(msg);
             throw new ScriptException(msg);
         }
         ctx.setAttribute(FCTSTRING, lastFctName, ScriptContext.ENGINE_SCOPE);
         ctx.setAttribute(RETSTRING, lastRetName, ScriptContext.ENGINE_SCOPE);
         ctx.setAttribute(RETVALUE, lastRetValue, ScriptContext.ENGINE_SCOPE);
         return ret;
     }
 
     /**
      * Internal javaCC node based implemention of a script function.
      */
     class ScriptFunction extends L4MScriptFunction {
         private final SimpleNode node;
         /**
          * Internal constructor 
          * @param name of this function
          * @param node of the parsed definition
          * @throws ScriptException if an error happens
          */
         ScriptFunction(final String name, final SimpleNode node) throws ScriptException {
             super(self,name);
             this.node = node;
             SimpleNode args = child(node, 1);
             numArgs = args.jjtGetNumChildren();
             tmpVars = new double[numArgs];
             varNames = new String[numArgs];
             for (int j = 0; j < numArgs; j++) {
                 SimpleNode arg = child(args, j);
                 varNames[j] = arg.value.toString();
             }
             registerVariables();
         }
         /*
          * (non-Javadoc)
          * @see de.lab4inf.math.scripting.L4MScriptWalker.L4MScriptFunction#doCalculate(double[])
          */
         @Override
         public double doCalculate(final double... x) throws ScriptException {
             SimpleNode def = child(node, 2);
             return visit(def, x);
         }
         /* (non-Javadoc)
          * @see de.lab4inf.math.scripting.L4MScriptFunction#registerVariables()
          */
         @Override
         protected void registerVariables() throws ScriptException {
             ArrayList<String> names = new ArrayList<String>(getVariableNames());
             for(String varName: varNames) {
                 if(!names.contains(varName)) {
                     setVariable(varName,0);
                 }
             }
         }
     }    
 }
 