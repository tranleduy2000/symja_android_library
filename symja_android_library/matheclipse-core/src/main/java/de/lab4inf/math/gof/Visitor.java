 
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
   * Generic visitor design pattern interface for objects that visit
   * a visitable of type T.
   *
   * @author nwulff
   * @since  26.06.2014
   * @version $Id: Visitor.java,v 1.3 2014/11/16 21:47:23 nwulff Exp $
   * @param <T> type of the visitable subject.
   */
  public interface Visitor<T extends Visitable<T>> {
      void visit(Visitable<T> subject);
  }
 