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
//  Copyright 2015-2018 Christoph Zengler                                //
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

/*****************************************************************************************
 * Open-WBO -- Copyright (c) 2013-2015, Ruben Martins, Vasco Manquinho, Ines Lynce
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *****************************************************************************************/

package org.logicng.solvers.maxsat.algorithms;

import org.logicng.collections.LNGIntVector;
import org.logicng.datastructures.Tristate;
import org.logicng.solvers.maxsat.encodings.Encoder;
import org.logicng.solvers.sat.MiniSatStyleSolver;

import java.io.PrintStream;

import static org.logicng.solvers.sat.MiniSatStyleSolver.not;

/**
 * Linear search solver.
 *
 * @version 1.3
 * @since 1.0
 */
public final class LinearUS extends MaxSAT {

    private final Encoder encoder;
    private final MaxSATConfig.IncrementalStrategy incrementalStrategy;
    private final LNGIntVector objFunction;
    private final PrintStream output;
    private MiniSatStyleSolver solver;

    /**
     * Constructs a new solver with default values.
     */
    public LinearUS() {
        this(new MaxSATConfig.Builder().build());
    }

    /**
     * Constructs a new solver with a given configuration.
     *
     * @param config the configuration
     */
    public LinearUS(final MaxSATConfig config) {
        super(config);
        this.solver = null;
        this.verbosity = config.verbosity;
        this.incrementalStrategy = config.incrementalStrategy;
        this.encoder = new Encoder(config.cardinalityEncoding);
        this.objFunction = new LNGIntVector();
        this.output = config.output;
    }

    @Override
    public MaxSATResult search() {
        if (problemType == ProblemType.WEIGHTED)
            throw new IllegalStateException("Error: Currently LinearUS does not support weighted MaxSAT instances.");
        switch (this.incrementalStrategy) {
            case NONE:
                return this.none();
            case ITERATIVE:
                if (this.encoder.cardEncoding() != MaxSATConfig.CardinalityEncoding.TOTALIZER)
                    throw new IllegalStateException("Error: Currently iterative encoding in LinearUS only supports the Totalizer encoding.");
                return this.iterative();
            default:
                throw new IllegalArgumentException("Unknown incremental strategy: " + this.incrementalStrategy);
        }
    }

    private MaxSATResult none() {
        nbInitialVariables = nVars();
        Tristate res;
        this.initRelaxation();
        this.solver = this.rebuildSolver();
        LNGIntVector assumptions = new LNGIntVector();
        this.encoder.setIncremental(MaxSATConfig.IncrementalStrategy.NONE);
        while (true) {
            res = searchSATSolver(this.solver, satHandler(), assumptions);
            if (res == Tristate.UNDEF)
                return MaxSATResult.UNDEF;
            else if (res == Tristate.TRUE) {
                nbSatisfiable++;
                int newCost = computeCostModel(this.solver.model(), Integer.MAX_VALUE);
                saveModel(this.solver.model());
                if (verbosity != MaxSATConfig.Verbosity.NONE)
                    this.output.println("o " + newCost);
                ubCost = newCost;
                if (nbSatisfiable == 1) {
                    if (!foundUpperBound(ubCost, null))
                        return MaxSATResult.UNDEF;
                    if (this.encoder.cardEncoding() == MaxSATConfig.CardinalityEncoding.MTOTALIZER)
                        this.encoder.setModulo((int) Math.ceil(Math.sqrt(ubCost + 1.0)));
                    this.encoder.encodeCardinality(this.solver, this.objFunction, 0);
                } else
                    return MaxSATResult.OPTIMUM;
            } else {
                lbCost++;
                if (verbosity != MaxSATConfig.Verbosity.NONE)
                    this.output.println("c LB : " + lbCost);
                if (nbSatisfiable == 0)
                    return MaxSATResult.UNSATISFIABLE;
                else if (lbCost == ubCost) {
                    if (nbSatisfiable > 0) {
                        if (verbosity != MaxSATConfig.Verbosity.NONE)
                            this.output.println("c LB = UB");
                        return MaxSATResult.OPTIMUM;
                    } else
                        return MaxSATResult.UNSATISFIABLE;
                } else if (!foundLowerBound(lbCost, null))
                    return MaxSATResult.UNDEF;
                this.solver = this.rebuildSolver();
                this.encoder.encodeCardinality(this.solver, this.objFunction, lbCost);
            }
        }
    }

    private MaxSATResult iterative() {
        assert this.encoder.cardEncoding() == MaxSATConfig.CardinalityEncoding.TOTALIZER;
        nbInitialVariables = nVars();
        Tristate res;
        this.initRelaxation();
        this.solver = this.rebuildSolver();
        LNGIntVector assumptions = new LNGIntVector();
        this.encoder.setIncremental(MaxSATConfig.IncrementalStrategy.ITERATIVE);
        while (true) {
            res = searchSATSolver(this.solver, satHandler(), assumptions);
            if (res == Tristate.UNDEF)
                return MaxSATResult.UNDEF;
            else if (res == Tristate.TRUE) {
                nbSatisfiable++;
                int newCost = computeCostModel(this.solver.model(), Integer.MAX_VALUE);
                saveModel(this.solver.model());
                if (verbosity != MaxSATConfig.Verbosity.NONE)
                    this.output.println("o " + newCost);
                ubCost = newCost;
                if (nbSatisfiable == 1) {
                    if (!foundUpperBound(ubCost, null))
                        return MaxSATResult.UNDEF;
                    for (int i = 0; i < this.objFunction.size(); i++)
                        assumptions.push(not(this.objFunction.get(i)));
                } else {
                    assert lbCost == ubCost;
                    return MaxSATResult.OPTIMUM;
                }
            } else {
                nbCores++;
                lbCost++;
                if (verbosity != MaxSATConfig.Verbosity.NONE)
                    this.output.println("c LB : " + lbCost);
                if (nbSatisfiable == 0)
                    return MaxSATResult.UNSATISFIABLE;
                if (lbCost == ubCost) {
                    if (nbSatisfiable > 0) {
                        if (verbosity != MaxSATConfig.Verbosity.NONE)
                            this.output.println("c LB = UB");
                        return MaxSATResult.OPTIMUM;
                    } else
                        return MaxSATResult.UNSATISFIABLE;
                }
                if (!foundLowerBound(lbCost, null))
                    return MaxSATResult.UNDEF;
                if (!this.encoder.hasCardEncoding())
                    this.encoder.buildCardinality(this.solver, this.objFunction, lbCost);
                final LNGIntVector join = new LNGIntVector();
                this.encoder.incUpdateCardinality(this.solver, join, this.objFunction, lbCost, assumptions);
            }
        }
    }

    private MiniSatStyleSolver rebuildSolver() {
        final MiniSatStyleSolver s = newSATSolver();
        for (int i = 0; i < nVars(); i++)
            newSATVariable(s);
        for (int i = 0; i < nHard(); i++)
            s.addClause(hardClauses.get(i).clause(), null);
        LNGIntVector clause;
        for (int i = 0; i < nSoft(); i++) {
            clause = new LNGIntVector(softClauses.get(i).clause());
            for (int j = 0; j < softClauses.get(i).relaxationVars().size(); j++)
                clause.push(softClauses.get(i).relaxationVars().get(j));
            s.addClause(clause, null);
        }
        return s;
    }

    private void initRelaxation() {
        for (int i = 0; i < nbSoft; i++) {
            final int l = newLiteral(false);
            softClauses.get(i).relaxationVars().push(l);
            softClauses.get(i).setAssumptionVar(l);
            this.objFunction.push(l);
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
