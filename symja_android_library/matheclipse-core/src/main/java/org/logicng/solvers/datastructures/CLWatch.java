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

package org.logicng.solvers.datastructures;

import java.util.Locale;

/**
 * Watcher of for a clause.
 *
 * @version 1.1
 * @since 1.0
 */
public final class CLWatch {
    private final boolean binary;
    private final CLClause clause;
    private int blit;

    /**
     * Constructs a new clause watcher.
     *
     * @param l the blocking literal
     * @param b {@code true} if this watch is for a binary clause, {@code false} otherwise
     * @param c the clause to watch
     */
    public CLWatch(int l, boolean b, final CLClause c) {
        this.blit = l;
        this.binary = b;
        this.clause = c;
    }

    /**
     * Returns the blocking literal of this watcher.
     *
     * @return the blocking literal of this watcher
     */
    public int blit() {
        return this.blit;
    }

    /**
     * Sets the blocking literal of this watcher
     *
     * @param blit the blocking literal
     */
    public void setBlit(int blit) {
        this.blit = blit;
    }

    /**
     * Returns {@code true} if this watcher watches a binary clause, {@code false} otherwise.
     *
     * @return {@code true} if this watcher watches a binary clause
     */
    public boolean binary() {
        return this.binary;
    }

    /**
     * Returns the watched clause.
     *
     * @return the watched clause
     */
    public CLClause clause() {
        return this.clause;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "CLWatch{blit=%d, binary=%s, clause=%s}", this.blit, this.binary, this.clause);
    }
}


