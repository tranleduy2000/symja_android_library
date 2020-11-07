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

package org.logicng.knowledgecompilation.bdds;

import com.duy.util.DObjects;

import org.logicng.datastructures.Assignment;
import org.logicng.formulas.Formula;
import org.logicng.formulas.FormulaFactory;
import org.logicng.formulas.Variable;
import org.logicng.knowledgecompilation.bdds.functions.BDDCNFFunction;
import org.logicng.knowledgecompilation.bdds.functions.BDDFunction;
import org.logicng.knowledgecompilation.bdds.functions.BDDModelEnumerationFunction;
import org.logicng.knowledgecompilation.bdds.jbuddy.BDDConstruction;
import org.logicng.knowledgecompilation.bdds.jbuddy.BDDKernel;
import org.logicng.knowledgecompilation.bdds.jbuddy.BDDOperations;
import org.logicng.knowledgecompilation.bdds.jbuddy.BDDReordering;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * The internal representation of a BDD.
 * @version 2.0.0
 * @since 1.4.0
 */
public final class BDD {

    private final int index;
    protected final BDDKernel kernel;
    protected final BDDConstruction construction;
    protected final BDDOperations operations;

    /**
     * Constructs a new BDD with a given index.
     * @param index  the index
     * @param kernel the kernel of this BDD
     */
    public BDD(final int index, final BDDKernel kernel) {
        this.index = index;
        this.kernel = kernel;
        this.construction = new BDDConstruction(kernel);
        this.operations = new BDDOperations(kernel);
    }

    /**
     * Returns the index of this BDD.
     * <p>
     * The index marks the entry point of this BDD in the {@link #underlyingKernel() underlying kernel}.
     * @return the index of this BDD
     */
    public int index() {
        return this.index;
    }

    /**
     * Returns the BDD Kernel of this factory.  The Kernel should only be accessed when you know, what you are doing.
     * @return the BDD Kernel
     */
    public BDDKernel underlyingKernel() {
        return this.kernel;
    }

    /**
     * Applies a given function on this BDD and returns the result.
     * @param function the function
     * @param <T>      the result type of the function
     * @return the result of the function application
     */
    public <T> T apply(final BDDFunction<T> function) {
        return function.apply(this);
    }

    /**
     * Returns {@code true} if this BDD is a tautology, {@code false} otherwise.
     * @return {@code true} if this BDD is a tautology, {@code false} otherwise
     */
    public boolean isTautology() {
        return this.index == 1;
    }

    /**
     * Returns {@code true} if this BDD is a contradiction, {@code false} otherwise.
     * @return {@code true} if this BDD is a contradiction, {@code false} otherwise
     */
    public boolean isContradiction() {
        return this.index == 0;
    }

    /**
     * Returns the model count of this BDD.
     * @return the model count
     */
    public BigInteger modelCount() {
        return this.operations.satCount(this.index);
    }

    /**
     * Enumerates all models of this BDD.
     * @return the list of all models
     */
    public List<Assignment> enumerateAllModels() {
        return enumerateAllModels((Collection<Variable>) null);
    }

    /**
     * Enumerates all models of this BDD wrt. a given set of variables.
     * @param variables the variables
     * @return the list of all models
     */
    public List<Assignment> enumerateAllModels(final Variable... variables) {
        return this.enumerateAllModels(Arrays.asList(variables));
    }

    /**
     * Enumerates all models of this BDD wrt. a given set of variables.
     * @param variables the variables
     * @return the list of all models
     */
    public List<Assignment> enumerateAllModels(final Collection<Variable> variables) {
        return this.apply(new BDDModelEnumerationFunction(variables));
    }

    /**
     * Returns a CNF formula for this BDD.
     * @return the CNF for the formula represented by this BDD
     */
    public Formula cnf() {
        return this.apply(new BDDCNFFunction());
    }

    /**
     * Returns the number of clauses for the CNF formula of the BDD.
     * @return the number of clauses for the CNF formula of the BDD
     */
    public BigInteger numberOfClausesCNF() {
        return this.operations.pathCountZero(this.index);
    }

    /**
     * Returns a DNF formula for a this BDD.
     * @return the DNF for the formula represented by this BDD
     */
    public Formula dnf() {
        final List<Formula> ops = new ArrayList<>();
        final FormulaFactory f = this.kernel.factory();
        for (final Assignment ass : this.enumerateAllModels()) {
            ops.add(ass.formula(f));
        }
        return ops.isEmpty() ? f.falsum() : f.or(ops);
    }

    /**
     * Returns an arbitrary model of this BDD or {@code null} if there is none.
     * @return an arbitrary model of this BDD
     */
    public Assignment model() {
        return createAssignment(this.operations.satOne(this.index));
    }

    /**
     * Returns a full model of this BDD or {@code null} if there is none.
     * @return an full model of this BDD
     */
    public Assignment fullModel() {
        return createAssignment(this.operations.fullSatOne(this.index));
    }

    /**
     * Returns the number of paths leading to the terminal 'one' node.
     * @return the number of paths leading to the terminal 'one' node
     */
    public BigInteger pathCountOne() {
        return this.operations.pathCountOne(this.index);
    }

    /**
     * Returns the number of paths leading to the terminal 'zero' node.
     * @return the number of paths leading to the terminal 'zero' node
     */
    public BigInteger pathCountZero() {
        return this.operations.pathCountZero(this.index);
    }

    /**
     * Returns all the variables this BDD depends on.
     * @return all the variables that this BDD depends on
     */
    public SortedSet<Variable> support() {
        final int supportBDD = this.operations.support(this.index);
        final Assignment assignment = createAssignment(supportBDD);
        assert assignment == null || assignment.negativeLiterals().isEmpty();
        return assignment == null ? new TreeSet<Variable>() : new TreeSet<>(assignment.positiveVariables());
    }

    /**
     * Returns the number of distinct nodes for this BDD.
     * @return the number of distinct nodes
     */
    public int nodeCount() {
        return this.operations.nodeCount(this.index);
    }

    /**
     * Returns how often each variable occurs in this BDD.
     * @return how often each variable occurs in the BDD
     */
    public SortedMap<Variable, Integer> variableProfile() {
        final int[] varProfile = this.operations.varProfile(this.index);
        final SortedMap<Variable, Integer> profile = new TreeMap<>();
        for (int i = 0; i < varProfile.length; i++) {
            profile.put(this.kernel.getVariableForIndex(i), varProfile[i]);
        }
        return profile;
    }

    /**
     * Returns the variable order of this BDD.
     * @return the variable order
     */
    public List<Variable> getVariableOrder() {
        final List<Variable> order = new ArrayList<>();
        for (final int i : this.kernel.getCurrentVarOrder()) {
            order.add(this.kernel.getVariableForIndex(i));
        }
        return order;
    }

    /**
     * Swaps two variables in a BDD.
     * Beware that if the {@link #kernel BDDKernel} of this BDD was used for multiple
     * BDDs, the variables are swapped in <b>all</b> of these BDDs.
     * @param first  the first variable to swap
     * @param second the second variable to swap
     */
    public void swapVariables(final Variable first, final Variable second) {
        final int firstVar = this.kernel.getIndexForVariable(first);
        final int secondVar = this.kernel.getIndexForVariable(second);
        if (firstVar < 0) {
            throw new IllegalArgumentException("Unknown variable: " + first);
        } else if (secondVar < 0) {
            throw new IllegalArgumentException("Unknown variable: " + second);
        }
        this.kernel.getReordering().swapVariables(firstVar, secondVar);
    }

    /**
     * Returns the reordering object for the BDD kernel.
     * @return the reordering object
     */
    public BDDReordering getReordering() {
        return this.kernel.getReordering();
    }

    /**
     * Creates an assignment from a BDD.
     * @param modelBDD the BDD
     * @return the assignment
     * @throws IllegalStateException if the BDD does not represent a unique model
     */
    private Assignment createAssignment(final int modelBDD) {
        if (modelBDD == BDDKernel.BDD_FALSE) {
            return null;
        }
        if (modelBDD == BDDKernel.BDD_TRUE) {
            return new Assignment();
        }
        final List<int[]> nodes = this.operations.allNodes(modelBDD);
        final Assignment assignment = new Assignment();
        for (final int[] node : nodes) {
            final Variable variable = this.kernel.getVariableForIndex(node[1]);
            if (node[2] == BDDKernel.BDD_FALSE) {
                assignment.addLiteral(variable);
            } else if (node[3] == BDDKernel.BDD_FALSE) {
                assignment.addLiteral(variable.negate());
            } else {
                throw new IllegalStateException("Expected that the model BDD has one unique path through the BDD.");
            }
        }
        return assignment;
    }

    @Override
    public int hashCode() {
        return DObjects.hash(this.index, this.kernel);
    }

    @Override
    public boolean equals(final Object other) {
        return this == other || other instanceof BDD
                && this.index == ((BDD) other).index
                && DObjects.equals(this.kernel, ((BDD) other).kernel);
    }

    @Override
    public String toString() {
        return "BDD{" + this.index + "}";
    }
}
