 
   /*
    * Project: Lab4Math
    *
    * Copyright (c) 2008-2013,  Prof. Dr. Nikolaus Wulff
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
  
  package de.lab4inf.math;
  
  /**
   * Interface a class that serves as a factory to
   * construct new instances of type T. 
   * @author  nwulff
   * @since   20.06.2013
   * @version $Id: Factory.java,v 1.2 2013/06/23 19:46:58 nwulff Exp $
   * @param <T> type of the pojo instances
   */
  public interface Factory<T> {
      /**
       * Factory method to create a new instance of type T 
       * using this as prototype.
       * @return a new instance of this
       */
      T create();
  }
 