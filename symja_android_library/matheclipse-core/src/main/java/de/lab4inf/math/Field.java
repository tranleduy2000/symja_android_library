 
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
   * Interface of the algebraic structure of a mathematical field over a set T.
   * @author nwulff
   * @since  09.03.2011
   * @version $Id: Field.java,v 1.5 2012/01/09 15:11:24 nwulff Exp $
   * @param <T> set of this field
   */
  public interface Field<T> extends Ring<T> {
  	/**
  	 * Divide this by that
  	 * @param that the divisor
  	 * @return this / that
  	 */
      @Operand(symbol = "/")
  	T div(final T that);
  }
 