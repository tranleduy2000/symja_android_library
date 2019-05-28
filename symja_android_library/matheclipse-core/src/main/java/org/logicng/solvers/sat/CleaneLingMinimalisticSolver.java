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

/**************************************************************************
 * Copyright (C) 2012 - 2014 Armin Biere JKU Linz
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to
 * deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or
 * sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 ****************************************************************************/

package org.logicng.solvers.sat;

import org.logicng.collections.LNGIntVector;
import org.logicng.collections.LNGVector;
import org.logicng.datastructures.Tristate;
import org.logicng.handlers.SATHandler;
import org.logicng.solvers.datastructures.CLClause;
import org.logicng.solvers.datastructures.CLFrame;
import org.logicng.solvers.datastructures.CLVar;
import org.logicng.solvers.datastructures.CLWatch;

import java.io.PrintStream;

import static org.logicng.datastructures.Tristate.FALSE;
import static org.logicng.datastructures.Tristate.TRUE;
import static org.logicng.datastructures.Tristate.UNDEF;

/**
 * A minimalistic version of the CleaneLing solver.
 *
 * @version 1.1
 * @since 1.0
 * @deprecated CleaneLing does not support many of the features of MiniSat in LogicNG.
 * With an upcoming 2.0 Release of LogicNG CleaneLing will be removed.
 */
public final class CleaneLingMinimalisticSolver extends CleaneLingStyleSolver {

    /**
     * Constructs a new minimalistic CleaneLing solver with a given configuration.
     *
     * @param config the configuration
     */
    public CleaneLingMinimalisticSolver(final CleaneLingConfig config) {
        super(config);
    }

    @Override
    public Tristate solve(final SATHandler handler) {
        this.handler = handler;
        if (this.handler != null) {
            this.handler.startedSolving();
        }
        this.model.clear();
        initLimits();
        Tristate res;
        while (true) {
            if ((res = search()) != UNDEF || this.canceledByHandler) {
                break;
            } else {
                updateLimits();
            }
        }
        if (res == TRUE) {
            for (int i = 0; i < this.vals.size(); i++) {
                this.model.push(this.vals.get(i) == VALUE_TRUE);
            }
        }
        if (this.handler != null) {
            this.handler.finishedSolving();
        }
        backtrack();
        this.handler = null;
        this.canceledByHandler = false;
        return res;
    }

    @Override
    protected void newPushConnectClause(final boolean redundant, final int glue) {
        connectClause(newClause(redundant, glue));
    }

    @Override
    protected void assign(final int lit, final CLClause reason) {
        final CLVar v = var(lit);
        assert val(lit) == VALUE_UNASSIGNED;
        final int idx = Math.abs(lit);
        final byte s = sign(lit);
        this.vals.set(idx, s);
        this.phases.set(idx, s);
        v.setLevel(this.level);
        if (this.level == 0) {
            v.setState(CLVar.State.FIXED);
        }
        this.trail.push(lit);
        v.setReason(reason);
        if (reason != null) {
            assert !reason.forcing();
            reason.setForcing(true);
        }
    }

    @Override
    protected void unassign(final int lit) {
        assert this.level > 0;
        final CLClause reason;
        final CLVar v = var(lit);
        assert val(lit) == VALUE_TRUE;
        this.vals.set(Math.abs(lit), VALUE_UNASSIGNED);
        assert v.level() == this.level;
        v.setLevel(Integer.MAX_VALUE);
        reason = v.reason();
        if (reason != null) {
            assert reason.forcing();
            reason.setForcing(false);
        }
        final int idx = Math.abs(lit);
        if (!this.decisions.contains(idx)) {
            this.decisions.push(idx);
        }
    }

    @Override
    protected void initLimits() {
        newRestartLimit();
        if (this.limits.simpSteps == 0) {
            this.limits.simpSteps = Integer.MAX_VALUE;
        }
    }

    @Override
    protected void updateLimits() {
        this.limits.simpInc = Integer.MAX_VALUE;
        this.limits.simpSteps = this.limits.simpInc;
        if (this.limits.searchInc == 0) {
            this.limits.searchInc = this.config.searchint;
        }
        if (this.limits.searchConflicts != 0) {
            final int inc = this.limits.searchInc;
            if (this.limits.searchInc >= Integer.MAX_VALUE - inc) {
                this.limits.searchInc = Integer.MAX_VALUE;
            } else {
                this.limits.searchInc += inc;
            }
        }
        this.limits.searchConflicts = this.limits.searchInc;
    }

    @Override
    protected CLClause newClause(final boolean redundant, final int glue) {
        final CLClause c = new CLClause();
        c.setRedundant(redundant);
        for (int i = 0; i < this.addedlits.size(); i++) {
            c.lits().push(this.addedlits.get(i));
        }
        return c;
    }

    @Override
    protected void connectClause(final CLClause c) {
        if (c.satisfied()) {
            return;
        }

        final int size = c.size();
        final boolean binary = size == 2;
        for (int p = 0; p < 2; p++) {
            for (int q = p + 1; q < c.lits().size(); q++) {
                final int lit = c.lits().get(q);
                final int litP = c.lits().get(p);
                final int cmp = var(lit).level() - var(litP).level();
                if (cmp > 0 || (cmp == 0 && (val(lit) > val(litP)))) {
                    c.lits().set(p, lit);
                    c.lits().set(q, litP);
                }
            }
        }
        final int l0 = c.lits().get(0);
        final int l1 = l0 != 0 ? c.lits().get(1) : 0;

        final int newLevel = (l0 != 0 && l1 != 0) ? Math.min(var(l0).level(), var(l1).level()) : 0;
        if (newLevel != Integer.MAX_VALUE) {
            backtrack(newLevel);
        }

        if (size >= 2) {
            addWatch(l0, l1, binary, c);
            addWatch(l1, l0, binary, c);
        }
        boolean ignore = false;
        int lit = 0;
        int other;
        int tmp;
        int p;
        for (p = 0; p < c.lits().size(); p++) {
            other = c.lits().get(p);
            tmp = val(other);
            if (tmp == VALUE_TRUE) {
                ignore = true;
                break;
            }
            if (tmp == VALUE_UNASSIGNED) {
                if (lit != 0) {
                    ignore = true;
                } else {
                    lit = other;
                }
            }
        }
        if (!ignore) {
            if (lit == 0) {
                assert this.level == 0;
                if (this.empty == null) {
                    this.empty = c;
                }
            } else {
                assign(lit, c);
            }
        }
    }

    @Override
    protected CLClause bcp() {
        CLClause conflict = this.empty;
        while (conflict == null && this.next < this.trail.size()) {
            final int lit = -this.trail.get(this.next++);
            final LNGVector<CLWatch> ws = watches(lit);
            final LNGVector<CLWatch> newWS = new LNGVector<>();
            int i;
            for (i = 0; conflict == null && i < ws.size(); i++) {
                final CLWatch w = ws.get(i);
                newWS.push(w);
                int other = w.blit();
                byte v = val(other);
                if (v == VALUE_TRUE) {
                    continue;
                }
                final CLClause clause = w.clause();
                if (this.ignore != null && (this.ignore == clause || clause.redundant())) {
                    continue;
                }
                if (w.binary()) {
                    if (v == VALUE_FALSE) {
                        conflict = clause;
                    } else {
                        assign(other, clause);
                    }
                } else {
                    int p;
                    if (clause.lits().get(0) == lit) {
                        final int temp = clause.lits().get(0);
                        clause.lits().set(0, clause.lits().get(1));
                        clause.lits().set(1, temp);
                    }
                    assert clause.lits().get(1) == lit;
                    for (p = 2; p < clause.lits().size(); p++) {
                        other = clause.lits().get(p);
                        if (val(other) >= 0) {
                            break;
                        }
                    }
                    if (p == clause.size()) {
                        other = 0;
                    }
                    if (other != 0) {
                        clause.lits().set(p, lit);
                        clause.lits().set(1, other);
                        addWatch(other, clause.lits().get(0), false, clause);
                        newWS.pop();
                    } else {
                        other = clause.lits().get(0);
                        v = val(other);
                        if (v == VALUE_FALSE) {
                            conflict = clause;
                        } else if (v != VALUE_TRUE) {
                            assign(other, clause);
                        } else {
                            newWS.back().setBlit(other);
                        }
                    }
                }
            }
            if (conflict != null) {
                while (i < ws.size()) {
                    newWS.push(ws.get(i++));
                }
            }
            ws.replaceInplace(newWS);
        }
        if (conflict != null) {
            this.stats.conflicts++;
        }
        return conflict;
    }

    @Override
    protected void minimizeClause() {
        final LNGIntVector newAddedLits = new LNGIntVector(this.addedlits.size());
        for (int i = 0; i < this.addedlits.size(); i++) {
            if (!minimizeLit(-this.addedlits.get(i))) {
                newAddedLits.push(this.addedlits.get(i));
            }
        }
        this.addedlits = newAddedLits;
    }

    @Override
    protected void analyze(final CLClause r) {
        CLClause reason = r;
        if (this.empty != null) {
            assert this.level == 0;
            return;
        }
        assert this.addedlits.empty();
        int lit = 0;
        int open = 0;
        int it = this.trail.size();
        while (true) {
            for (int p = 0; p < reason.lits().size(); p++) {
                lit = reason.lits().get(p);
                if (pullLit(lit)) {
                    open++;
                }
            }
            while (it > 0 && marked(lit = -this.trail.get(--it)) == 0) {
                assert var(lit).level() == this.level;
            }
            if (it == 0 || --open == 0) {
                break;
            }
            reason = var(lit).reason();
            assert reason != null;
        }

        assert lit != 0;
        this.addedlits.push(lit);
        minimizeClause();
        unmark();
        unmarkFrames();
        this.stats.gluesCount++;
        newPushConnectClause(true, -1);
        this.addedlits.clear();
        this.scoreIncrement *= this.config.scincfact / 1000.0;
    }

    @Override
    protected boolean restarting() {
        return this.stats.conflicts >= this.limits.restart;
    }

    @Override
    protected void restart() {
        this.stats.restartsCount++;
        int nextDecision = 0;
        while (nextDecision == 0 && !this.decisions.empty()) {
            final int lit = this.decisions.top();
            if (val(lit) != 0) {
                this.decisions.pop(lit);
            } else {
                nextDecision = lit;
            }
        }
        if (nextDecision != 0) {
            int newLevel;
            final double nextDecisionPriority = this.decisions.priority(nextDecision);
            for (newLevel = 0; newLevel < this.level; newLevel++) {
                final CLFrame frame = this.control.get(newLevel + 1);
                final int decision = Math.abs(frame.decision());
                if (this.decisions.priority(decision) < nextDecisionPriority) {
                    break;
                }
            }
            backtrack(newLevel);
        }
        newRestartLimit();
    }

    @Override
    protected Tristate search() {
        long conflicts = 0;
        CLClause conflict;
        Tristate res = UNDEF;
        while (res == UNDEF) {
            if (this.empty != null) {
                res = FALSE;
            } else if ((conflict = bcp()) != null) {
                if (this.handler != null && !this.handler.detectedConflict()) {
                    this.canceledByHandler = true;
                    return UNDEF;
                }
                analyze(conflict);
                conflicts++;
            } else if (conflicts >= this.limits.searchConflicts) {
                break;
            } else if (restarting()) {
                restart();
            } else if (!decide()) {
                res = TRUE;
            }
        }
        return res;
    }

    /**
     * Prints the current solver state to a given output stream.
     *
     * @param output the output stream
     */
    public void printSolverState(final PrintStream output) {
        output.println("level=" + this.level);
        output.println("next=" + this.next);
        output.println("ignore=" + this.ignore);
        output.println("empty=" + this.empty);
        output.println("vars=" + this.vars);
        output.println("vals=" + this.vals);
        output.println("phases=" + this.phases);
        output.println("decisions=" + this.decisions);
        output.println("control=" + this.control);
        output.println("watches=" + this.watches);
        output.println("trail=" + this.trail);
        output.println("frames=" + this.frames);
    }
}
