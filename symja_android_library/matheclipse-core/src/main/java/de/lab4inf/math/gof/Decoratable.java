 
   /*
    * Project: Lab4Math
    *
    * Copyright (c) 2008-2014,  Prof. Dr. Nikolaus Wulff
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
  package de.lab4inf.math.gof;
  
  /**
   * Generic subject interface to be decorated within the decorator design pattern. 
   *
   * @author nwulff
   * @since  26.06.2014
   * @version $Id: Decoratable.java,v 1.2 2014/06/26 13:21:55 nwulff Exp $
   * @param <T> type to be decorated.
   */
  public interface Decoratable<T extends Decoratable<T>> {
  
  }
 