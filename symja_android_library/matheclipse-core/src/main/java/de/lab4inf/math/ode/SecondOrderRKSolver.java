 
   /*
    * Project: Lab4Math
    *
    * Copyright (c) 2008-2014,  Prof. Dr. Nikolaus Wulff
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
  
  package de.lab4inf.math.ode;
  import static de.lab4inf.math.ode.FirstOrderSystemSolver.Solver.RungeKutta;
  
  /**
   * SecondOrder differential solver wrapping the Runge-Kutta method.
   * @author  nwulff
   * @since   12.05.2014
   * @version $Id: SecondOrderRKSolver.java,v 1.1 2014/05/12 14:38:12 nwulff Exp $
   */
  public class SecondOrderRKSolver extends SecondOrderSolver {
      /**
       * Sole constructor.
       */
      public SecondOrderRKSolver() {
          super(RungeKutta);
      }
  }
 