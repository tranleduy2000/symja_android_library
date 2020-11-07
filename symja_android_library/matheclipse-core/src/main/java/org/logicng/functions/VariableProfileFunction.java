///////////////////////////////////////////////////////////////////////////
//                   __                _      _   ________               //
//                  / /   ____  ____ _(_)____/ | / / ____/               //
//                 / /   / __ \/ __ `/ / ___/  |/ / / __                 //
//                / /___/ /_/ / /_/ / / /__/ /|  / /_/ /                 //
//               /_____/\____/\__, /_/\___/_/ |_/\____/                  //
//                           /____/                                      //
//                                                                       //
//               The Next Generation Logic Library                       //
//                                                                       //
///////////////////////////////////////////////////////////////////////////
//                                                                       //
//  Copyright 2015-20xx Christoph Zengler                                //
//                                                                       //
//  Licensed under the Apache License, Version 2.0 (the "License");      //
//  you may not use this file except in compliance with the License.     //
//  You may obtain a copy of the License at                              //
//                                                                       //
//  http://www.apache.org/licenses/LICENSE-2.0                           //
//                                                                       //
//  Unless required by applicable law or agreed to in writing, software  //
//  distributed under the License is distributed on an "AS IS" BASIS,    //
//  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or      //
//  implied.  See the License for the specific language governing        //
//  permissions and limitations under the License.                       //
//                                                                       //
///////////////////////////////////////////////////////////////////////////

package org.logicng.functions;

import com.duy.lambda.BiFunction;
import com.duy.lang.DInteger;
import com.duy.util.MapWrapper;

import static org.logicng.formulas.cache.FunctionCacheEntry.VARPROFILE;

import org.logicng.formulas.FType;
import org.logicng.formulas.Formula;
import org.logicng.formulas.FormulaFunction;
import org.logicng.formulas.Literal;
import org.logicng.formulas.Variable;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * A function that computes the variable profile for a given formula, i.e. it counts the number of occurrences for
 * each variable.
 * <p>
 * For this function, the non-caching version is preferred since it usually performs better.  The non-caching version
 * of this function generates the result mapping only once and fills it recursively whereas the caching version has to
 * construct a new mapping for each sub-formula.
 * @version 2.0.0
 * @since 1.0
 */
public final class VariableProfileFunction implements FormulaFunction<Map<Variable, Integer>> {

    /**
     * The non-caching implementation of the variable profile computation.  In this case the result map is only
     * constructed once and results are just added to it.
     * @param formula the formula
     * @return the variable profile
     */
    private static Map<Variable, Integer> nonCachingVariableProfile(final Formula formula) {
        final SortedMap<Variable, Integer> map = new TreeMap<>();
        nonCachingRecursion(formula, map);
        return map;
    }

    /**
     * Recursive function for the non-caching variable profile computation.
     * @param formula the formula
     * @param map     the variable profile
     */
    private static void nonCachingRecursion(final Formula formula, final Map<Variable, Integer> map) {
        if (formula.type() == FType.LITERAL) {
            final Literal lit = (Literal) formula;
            MapWrapper.merge(map, lit.variable(), 1, new BiFunction<Integer, Integer, Integer>() {
                @Override
                public Integer apply(Integer a, Integer b) {
                    return DInteger.sum(a, b);
                }
            });
        } else if (formula.type() == FType.PBC) {
            for (final Literal l : formula.literals()) {
                nonCachingRecursion(l.variable(), map);
            }
        } else {
            for (final Formula op : formula) {
                nonCachingRecursion(op, map);
            }
        }
    }

    /**
     * The caching implementation of the variable profile computation.  In this case a result map is constructed for
     * each sub-formula.
     * @param formula the formula
     * @return the variable profile
     */
    @SuppressWarnings("unchecked")
    private static Map<Variable, Integer> cachingVariableProfile(final Formula formula) {
        final Object cached = formula.functionCacheEntry(VARPROFILE);
        if (cached != null) {
            return (Map<Variable, Integer>) cached;
        }
        final Map<Variable, Integer> result = new HashMap<>();
        if (formula.type() == FType.LITERAL) {
            result.put(((Literal) formula).variable(), 1);
        } else if (formula.type() == FType.PBC) {
            for (final Literal l : formula.literals()) {
                result.put(l.variable(), 1);
            }
        } else {
            for (final Formula op : formula) {
                final Map<Variable, Integer> temp = cachingVariableProfile(op);
                for (final Map.Entry<Variable, Integer> entry : temp.entrySet()) {
                    MapWrapper.merge(result, entry.getKey(), entry.getValue(), new BiFunction<Integer, Integer, Integer>() {
                        @Override
                        public Integer apply(Integer a, Integer b) {
                            return DInteger.sum(a, b);
                        }
                    });
                }
            }
        }
        formula.setFunctionCacheEntry(VARPROFILE, result);
        return result;
    }

    @Override
    public Map<Variable, Integer> apply(final Formula formula, final boolean cache) {
        return cache ? cachingVariableProfile(formula) : nonCachingVariableProfile(formula);
    }
}
