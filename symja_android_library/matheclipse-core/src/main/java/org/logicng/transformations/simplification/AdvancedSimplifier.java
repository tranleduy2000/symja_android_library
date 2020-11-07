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

package org.logicng.transformations.simplification;

import com.duy.lambda.Function;
import com.duy.lambda.Supplier;
import com.duy.stream.Collectors;
import com.duy.stream.StreamWrapper;

import org.logicng.backbones.Backbone;
import org.logicng.backbones.BackboneGeneration;
import org.logicng.datastructures.Assignment;
import org.logicng.explanations.smus.SmusComputation;
import org.logicng.formulas.Formula;
import org.logicng.formulas.FormulaFactory;
import org.logicng.formulas.FormulaTransformation;
import org.logicng.formulas.Literal;
import org.logicng.primecomputation.PrimeCompiler;
import org.logicng.primecomputation.PrimeResult;
import org.logicng.util.FormulaHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;

/**
 * An advanced simplifier for formulas.
 * <p>
 * The aim of the simplification is to minimize the formula with respect to a given rating function,
 * e.g. finding a formula with a minimal number of symbols when represented as string.
 * <p>
 * The simplification performs the following steps:
 * <ul>
 *     <li>Computation of all prime implicants</li>
 *     <li>Finding a minimal coverage (by finding a smallest MUS)</li>
 *     <li>Building a DNF from the minimal prime implicant coverage</li>
 *     <li>Factoring out: Applying the Distributive Law heuristically for a smaller formula</li>
 *     <li>Minimizing negations: Applying De Morgan's Law heuristically for a smaller formula</li>
 * </ul>
 * @version 2.0.0
 * @since 2.0.0
 */
public final class AdvancedSimplifier implements FormulaTransformation {

    private final RatingFunction<?> ratingFunction;

    /**
     * Constructs a new simplifier with the given rating functions.
     * @param ratingFunction the rating function
     */
    public AdvancedSimplifier(final RatingFunction<?> ratingFunction) {
        this.ratingFunction = ratingFunction;
    }

    @Override
    public Formula apply(final Formula formula, final boolean cache) {
        final FormulaFactory f = formula.factory();
        final Backbone backbone = BackboneGeneration.compute(formula, formula.variables());
        if (!backbone.isSat()) {
            return f.falsum();
        }
        final SortedSet<Literal> backboneLiterals = backbone.getCompleteBackbone();
        final Formula restrictedFormula = formula.restrict(new Assignment(backboneLiterals));
        final List<SortedSet<Literal>> primeImplicants = PrimeCompiler.getWithMinimization()
                .compute(restrictedFormula, PrimeResult.CoverageType.IMPLICANTS_COMPLETE).getPrimeImplicants();
        final List<Formula> minimizedPIs = SmusComputation.computeSmusForFormulas(negateAllLiterals(primeImplicants, f), Collections.singletonList(restrictedFormula), f);
        assert minimizedPIs != null : "The conjunction of a satisfiable formula and its negated prime implications is always a contradiction";
        StreamWrapper<Formula> stream = new StreamWrapper<>(negateAllLiteralsInFormulas(minimizedPIs, f))
                .stream();
        final Formula minDnf = f.or(stream
                .map(new Function<Formula, Formula>() {
                    @Override
                    public Formula apply(Formula formula) {
                        return f.and(formula);
                    }
                }).collect(Collectors.<Formula>toList()));
        final Formula fullFactor = minDnf.transform(new FactorOutSimplifier(this.ratingFunction));
        return f.and(f.and(backboneLiterals), fullFactor).transform(new NegationSimplifier());
    }

    private List<Formula> negateAllLiterals(final Collection<SortedSet<Literal>> literalSets, final FormulaFactory f) {
        final List<Formula> result = new ArrayList<>();
        for (final SortedSet<Literal> literals : literalSets) {
            result.add(f.or(FormulaHelper.negateLiterals(literals, new Supplier<Collection<Literal>>() {
                @Override
                public Collection<Literal> get() {
                    return new ArrayList<Literal>();
                }
            })));
        }
        return result;
    }

    private List<Formula> negateAllLiteralsInFormulas(final Collection<Formula> formulas, final FormulaFactory f) {
        final List<Formula> result = new ArrayList<>();
        for (final Formula formula : formulas) {
            result.add(f.and(FormulaHelper.negateLiterals(formula.literals(), new Supplier<Collection<Literal>>() {
                @Override
                public Collection<Literal> get() {
                    return new ArrayList<Literal>();
                }
            })));
        }
        return result;
    }
}
