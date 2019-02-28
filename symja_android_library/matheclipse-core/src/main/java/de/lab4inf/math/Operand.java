/*
 * Project: Lab4Math
 *
 * Copyright (c) 2006-2010,  Prof. Dr. Nikolaus Wulff
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

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Marker annotation for methods usable with the a scripting language like SymjaMMA.
 * Examples are classes with a plus or and method. For instances of these
 * classes you can write: x + y or x | y instead of x.plus(y) or x.or(y).
 *
 * @author nwulff
 * @version $Id: Operand.java,v 1.1 2012/01/09 14:49:51 nwulff Exp $
 * @since 22.11.2010
 */
@Documented
@Target(ElementType.METHOD)
public @interface Operand {
    String symbol();
}
 