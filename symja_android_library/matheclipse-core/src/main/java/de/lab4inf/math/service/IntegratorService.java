 
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
  
  import de.lab4inf.math.Differentiable;
  import de.lab4inf.math.Function;
  import de.lab4inf.math.Integrable;
  import de.lab4inf.math.Integrator;
  import de.lab4inf.math.L4MObject;
  import de.lab4inf.math.gof.Visitable;
  import de.lab4inf.math.gof.Visitor;
  /**
   * Integrator service implementation.
   *
   * @author nwulff
   * @since  07.01.2012
   * @version $Id: IntegratorService.java,v 1.3 2014/06/26 11:25:34 nwulff Exp $
   */
  public class IntegratorService extends L4MObject implements Integrator {
      private static final double EPS = 1.E-8;
      /* (non-Javadoc)
       * @see de.lab4inf.math.Integrator#antiderivative(de.lab4inf.math.Function)
       */
      @Override
      public Function antiderivative(final Function fct) {
          if(fct instanceof Integrable) {
              return  ((Integrable) fct).getAntiderivative();
          }
          return new IntegratorFunction(fct);
      }
  
      /* (non-Javadoc)
       * @see de.lab4inf.math.Integrator#integrate(de.lab4inf.math.Function, double, double)
       */
      @Override
      public double integrate(final Function fct,final double a,final double b) {
          if(fct instanceof Integrable) {
              Function aFct = ((Integrable) fct).getAntiderivative();
              return aFct.f(b) - aFct.f(a);
          }
          return de.lab4inf.math.integration.Integrator.integrate(a, b, EPS, fct);
      }
      /* (non-Javadoc)
       * @see de.lab4inf.math.gof.Visitor#visit(de.lab4inf.math.gof.Visitable)
       */
      @Override
      public void visit(final Visitable<Function> subject) {
          throw new IllegalStateException("not implemented yet...");  
      }
     /**
       * Internal utility function wrapper for integration.
       */
      static class IntegratorFunction implements Differentiable {
          private final Function fct;
          private double x0;
          IntegratorFunction(final Function fct) {
              this(fct,0);
          }
          IntegratorFunction(final Function fct, final double a) {
              this.fct = fct;
              this.x0 = a;
          }
          /* (non-Javadoc)
           * @see de.lab4inf.math.Function#f(double[])
           */
          @Override
          public double f(final double... x) {
              return de.lab4inf.math.integration.Integrator.integrate(x0, x[0], fct);
          }
          /* (non-Javadoc)
           * @see de.lab4inf.math.Differentiable#getDerivative()
           */
          @Override
          public Function getDerivative() {
              return fct;
          }
          /* (non-Javadoc)
           * @see de.lab4inf.math.gof.Visitable#accept(de.lab4inf.math.gof.Visitor)
           */
          @Override
          public void accept(final Visitor<Function> visitor) {
             visitor.visit(this);
         }
     }
 }
 