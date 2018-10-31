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

package org.logicng.datastructures;

import org.logicng.collections.LNGIntVector;
import org.logicng.collections.LNGVector;
import org.logicng.formulas.Formula;
import org.logicng.formulas.FormulaFactory;
import org.logicng.formulas.Literal;
import org.logicng.formulas.Variable;
import org.logicng.solvers.CleaneLing;
import org.logicng.solvers.MiniSat;

import java.util.ArrayList;
import java.util.List;

/**
 * The result of an encoding.
 * <p>
 * Encodings (normal forms, cardinality constraints, pseudo-Boolean constraint) are often used only when adding
 * formulas to the SAT solver.  Therefore it is not necessary to generate all the formulas required for the encoding
 * in the formula factory and therefore polluting the factory and the heap.  This class can be used to connect an
 * encoding directly with a SAT solver and therefore introducing the variables only on the solver - not in the factory.
 * When working with many encodings, this can be a large performance gain.
 *
 * @version 1.3
 * @since 1.1
 */
public final class EncodingResult {
    private final FormulaFactory f;
    private final MiniSat miniSat;
    private final CleaneLing cleaneLing;
    private List<Formula> result;

    /**
     * Constructs a new CC encoding algorithm.
     *
     * @param f          the formula factory
     * @param miniSat    the MiniSat instance
     * @param cleaneLing the CleaneLing instance
     */
    private EncodingResult(final FormulaFactory f, final MiniSat miniSat, final CleaneLing cleaneLing) {
        this.f = f;
        this.miniSat = miniSat;
        this.cleaneLing = cleaneLing;
        this.reset();
    }

    /**
     * Constructs a new result which stores the result in a formula.
     *
     * @param f the formula factory
     * @return the result
     */
    public static EncodingResult resultForFormula(final FormulaFactory f) {
        return new EncodingResult(f, null, null);
    }

    /**
     * Constructs a new result which adds the result directly to a given MiniSat solver.
     *
     * @param f       the formula factory
     * @param miniSat the solver
     * @return the result
     */
    public static EncodingResult resultForMiniSat(final FormulaFactory f, final MiniSat miniSat) {
        return new EncodingResult(f, miniSat, null);
    }

    /**
     * Constructs a new result which adds the result directly to a given CleaneLing solver.
     *
     * @param f          the formula factory
     * @param cleaneLing the CleaneLing solver
     * @return the result
     */
    public static EncodingResult resultForCleaneLing(final FormulaFactory f, final CleaneLing cleaneLing) {
        return new EncodingResult(f, null, cleaneLing);
    }

    /**
     * Adds a clause to the result
     *
     * @param literals the literals of the clause
     */
    public void addClause(final Literal... literals) {
        if (this.miniSat == null && this.cleaneLing == null)
            this.result.add(this.f.clause(literals));
        else if (this.miniSat != null) {
            final LNGIntVector clauseVec = new LNGIntVector(literals.length);
            for (Literal lit : literals) {
                int index = this.miniSat.underlyingSolver().idxForName(lit.name());
                if (index == -1) {
                    index = this.miniSat.underlyingSolver().newVar(!miniSat.initialPhase(), true);
                    this.miniSat.underlyingSolver().addName(lit.name(), index);
                }
                int litNum;
                if (lit instanceof EncodingAuxiliaryVariable)
                    litNum = !((EncodingAuxiliaryVariable) lit).negated ? index * 2 : (index * 2) ^ 1;
                else
                    litNum = lit.phase() ? index * 2 : (index * 2) ^ 1;
                clauseVec.push(litNum);
            }
            this.miniSat.underlyingSolver().addClause(clauseVec, null);
            this.miniSat.setSolverToUndef();
        } else {
            for (Literal lit : literals) {
                int index = this.cleaneLing.getOrCreateVarIndex(lit.variable());
                if (lit instanceof EncodingAuxiliaryVariable)
                    this.cleaneLing.underlyingSolver().addlit(!((EncodingAuxiliaryVariable) lit).negated ? index : -index);
                else
                    this.cleaneLing.underlyingSolver().addlit(lit.phase() ? index : -index);
            }
            this.cleaneLing.underlyingSolver().addlit(CleaneLing.CLAUSE_TERMINATOR);
            this.cleaneLing.setSolverToUndef();
        }
    }

    /**
     * Adds a clause to the result
     *
     * @param literals the literals of the clause
     */
    public void addClause(final LNGVector<Literal> literals) {
        if (this.miniSat == null && this.cleaneLing == null)
            this.result.add(this.vec2clause(literals));
        else if (this.miniSat != null) {
            final LNGIntVector clauseVec = new LNGIntVector(literals.size());
            for (Literal lit : literals) {
                int index = this.miniSat.underlyingSolver().idxForName(lit.name());
                assert index != -1;
                int litNum;
                if (lit instanceof EncodingAuxiliaryVariable)
                    litNum = !((EncodingAuxiliaryVariable) lit).negated ? index * 2 : (index * 2) ^ 1;
                else
                    litNum = lit.phase() ? index * 2 : (index * 2) ^ 1;
                clauseVec.push(litNum);
            }
            this.miniSat.underlyingSolver().addClause(clauseVec, null);
            this.miniSat.setSolverToUndef();
        } else {
            for (Literal lit : literals) {
                int index = this.cleaneLing.getOrCreateVarIndex(lit.variable());
                if (lit instanceof EncodingAuxiliaryVariable)
                    this.cleaneLing.underlyingSolver().addlit(!((EncodingAuxiliaryVariable) lit).negated ? index : -index);
                else
                    this.cleaneLing.underlyingSolver().addlit(lit.phase() ? index : -index);
            }
            this.cleaneLing.underlyingSolver().addlit(CleaneLing.CLAUSE_TERMINATOR);
            this.cleaneLing.setSolverToUndef();
        }
    }

    /**
     * Returns a clause for a vector of literals.
     *
     * @param literals the literals
     * @return the clause
     */
    private Formula vec2clause(final LNGVector<Literal> literals) {
        final List<Literal> lits = new ArrayList<>(literals.size());
        for (final Literal l : literals)
            lits.add(l);
        return this.f.clause(lits);
    }

    /**
     * Returns a new auxiliary variable.
     *
     * @return a new auxiliary variable
     */
    public Variable newVariable() {
        if (this.miniSat == null && this.cleaneLing == null)
            return this.f.newCCVariable();
        else if (miniSat != null) {
            final int index = this.miniSat.underlyingSolver().newVar(!miniSat.initialPhase(), true);
            final String name = FormulaFactory.CC_PREFIX + "MINISAT_" + index;
            this.miniSat.underlyingSolver().addName(name, index);
            return new EncodingAuxiliaryVariable(name, false);
        } else
            return new EncodingAuxiliaryVariable(this.cleaneLing.createNewVariableOnSolver(FormulaFactory.CC_PREFIX + "CLEANELING"), false);
    }

    /**
     * Resets the result.
     */
    public void reset() {
        this.result = new ArrayList<>();
    }

    /**
     * Returns the result of this algorithm.
     *
     * @return the result of this algorithm
     */
    public List<Formula> result() {
        return this.result;
    }
}
