 
   /*
    * Project: Lab4Math
    *
    * Copyright (c) 2008-2009,  Prof. Dr. Nikolaus Wulff
    * University of Applied Sciences, Muenster, Germany
    * Lab for Computer sciences (Lab4Inf).
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
  
  package de.lab4inf.math.ode;
  
  import de.lab4inf.math.Function;
  
  /**
   * Solve a second order differential equation. 
   * <pre>
   *    y'' = f(x,y,y')
   * </pre>
   *
   * @author  Prof. Dr. Nikolaus Wulff
   * @since   18.01.2009
   * @version $Id: SecondOrderOdeSolver.java,v 1.2 2010/02/25 15:31:55 nwulff Exp $
   */
  public interface SecondOrderOdeSolver {
      /**
       * Calculate y1 at point x1, given x0,y0 and dy0 with eps precision 
       * for the given first order differential equation y''=f(x,y,y').
       * 
       * @param x0 the starting point
       * @param y0 the starting value y(x0)
       * @param dy0 the starting value y'(x0) 
       * @param x1 the end point
       * @param f reference to the differential equation
       * @param eps double the maximal error of y1
       * @return double the approximate solution y1(x1)
       */
      double solve(final double x0, final double y0, final double dy0,
              final double x1, final Function f, final double eps);
  
  }
 