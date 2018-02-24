 
   /*
    * Project: Lab4Math
    *
    * Copyright (c) 2006-2011,  Prof. Dr. Nikolaus Wulff
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
  
  package de.lab4inf.math;
  
  /**
   * An interval function with a known derivative.
   * @author nwulff
   * @since  08.03.2011
   * @version $Id: IDifferentiable.java,v 1.2 2011/03/10 19:44:01 nwulff Exp $
   */
  
  public interface IDifferentiable extends Differentiable, IFunction {
      /**
       * The first derivative of this function.
       * @return IFunction derivative
       */
      IFunction getIDerivative();
  
  }
 