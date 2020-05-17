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

package org.logicng.solvers.sat;

import com.duy.lang.DSystem;

import org.logicng.configurations.Configuration;
import org.logicng.configurations.ConfigurationType;

/**
 * The configuration object for the Glucose SAT solver.
 *
 * @version 1.1
 * @since 1.0
 */
public final class GlucoseConfig extends Configuration {

    final int lbLBDMinimizingClause;
    final int lbLBDFrozenClause;
    final int lbSizeMinimizingClause;
    final int firstReduceDB;
    final int specialIncReduceDB;
    final int incReduceDB;
    final double factorK;
    final double factorR;
    final int sizeLBDQueue;
    final int sizeTrailQueue;
    final boolean reduceOnSize;
    final int reduceOnSizeSize;
    final double maxVarDecay;

    /**
     * Constructs a new Glucose configuration from a given builder.
     *
     * @param builder the builder
     */
    private GlucoseConfig(final Builder builder) {
        super(ConfigurationType.GLUCOSE);
        this.lbLBDMinimizingClause = builder.lbLBDMinimizingClause;
        this.lbLBDFrozenClause = builder.lbLBDFrozenClause;
        this.lbSizeMinimizingClause = builder.lbSizeMinimizingClause;
        this.firstReduceDB = builder.firstReduceDB;
        this.specialIncReduceDB = builder.specialIncReduceDB;
        this.incReduceDB = builder.incReduceDB;
        this.factorK = builder.factorK;
        this.factorR = builder.factorR;
        this.sizeLBDQueue = builder.sizeLBDQueue;
        this.sizeTrailQueue = builder.sizeTrailQueue;
        this.reduceOnSize = builder.reduceOnSize;
        this.reduceOnSizeSize = builder.reduceOnSizeSize;
        this.maxVarDecay = builder.maxVarDecay;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GlucoseConfig{").append(DSystem.lineSeparator());
        sb.append("lbLBDMinimizingClause=").append(this.lbLBDMinimizingClause).append(DSystem.lineSeparator());
        sb.append("lbLBDFrozenClause=").append(this.lbLBDFrozenClause).append(DSystem.lineSeparator());
        sb.append("lbSizeMinimizingClause=").append(this.lbSizeMinimizingClause).append(DSystem.lineSeparator());
        sb.append("firstReduceDB=").append(this.firstReduceDB).append(DSystem.lineSeparator());
        sb.append("specialIncReduceDB=").append(this.specialIncReduceDB).append(DSystem.lineSeparator());
        sb.append("incReduceDB=").append(this.incReduceDB).append(DSystem.lineSeparator());
        sb.append("factorK=").append(this.factorK).append(DSystem.lineSeparator());
        sb.append("factorR=").append(this.factorR).append(DSystem.lineSeparator());
        sb.append("sizeLBDQueue=").append(this.sizeLBDQueue).append(DSystem.lineSeparator());
        sb.append("sizeTrailQueue=").append(this.sizeTrailQueue).append(DSystem.lineSeparator());
        sb.append("reduceOnSize=").append(this.reduceOnSize).append(DSystem.lineSeparator());
        sb.append("reduceOnSizeSize=").append(this.reduceOnSizeSize).append(DSystem.lineSeparator());
        sb.append("maxVarDecay=").append(this.maxVarDecay).append(DSystem.lineSeparator());
        sb.append("}").append(DSystem.lineSeparator());
        return sb.toString();
    }

    /**
     * The builder for a Glucose configuration.
     */
    public static class Builder {
        private int lbLBDMinimizingClause = 6;
        private int lbLBDFrozenClause = 30;
        private int lbSizeMinimizingClause = 30;
        private int firstReduceDB = 2000;
        private int specialIncReduceDB = 1000;
        private int incReduceDB = 300;
        private double factorK = 0.8;
        private double factorR = 1.4;
        private int sizeLBDQueue = 50;
        private int sizeTrailQueue = 5000;
        private boolean reduceOnSize = false;
        private int reduceOnSizeSize = 12;
        private double maxVarDecay = 0.95;

        /**
         * Sets the minimal LBD required to minimize a clause to a given value.  The default value is 6.
         *
         * @param lbLBDMinimizingClause the value (should be at least 3)
         * @return the builder
         */
        public Builder lbLBDMinimizingClause(int lbLBDMinimizingClause) {
            this.lbLBDMinimizingClause = lbLBDMinimizingClause;
            return this;
        }

        /**
         * Sets the value to protect clauses if their LBD decrease and is lower than it (for one turn).  The default value
         * is 30.
         *
         * @param lbLBDFrozenClause the value
         * @return the builder
         */
        public Builder lbLBDFrozenClause(int lbLBDFrozenClause) {
            this.lbLBDFrozenClause = lbLBDFrozenClause;
            return this;
        }

        /**
         * Sets the minimal size required to minimize a clause to a given value.  The default value is 30.
         *
         * @param lbSizeMinimizingClause the value (should be at least 3)
         * @return the builder
         */
        public Builder lbSizeMinimizingClause(int lbSizeMinimizingClause) {
            this.lbSizeMinimizingClause = lbSizeMinimizingClause;
            return this;
        }

        /**
         * Sets the number of conflicts before the first DB reduction to a given value.  The default value is 2000.
         *
         * @param firstReduceDB the value
         * @return the builder
         */
        public Builder firstReduceDB(int firstReduceDB) {
            this.firstReduceDB = firstReduceDB;
            return this;
        }

        /**
         * Sets the special increment for the DB reduction to a given value.  The default value is 1000.
         *
         * @param specialIncReduceDB the value
         * @return the builder
         */
        public Builder specialIncReduceDB(int specialIncReduceDB) {
            this.specialIncReduceDB = specialIncReduceDB;
            return this;
        }

        /**
         * Sets the increment for the DB reduction to a given value. The default value is 300.
         *
         * @param incReduceDB the value
         * @return the builder
         */
        public Builder incReduceDB(int incReduceDB) {
            this.incReduceDB = incReduceDB;
            return this;
        }

        /**
         * Sets the constant used to force restart to a given value.  The default value is 0.8.
         *
         * @param factorK the value (should be in the range 0..1)
         * @return the builder
         */
        public Builder factorK(double factorK) {
            this.factorK = factorK;
            return this;
        }

        /**
         * Sets the constant used to block restart to a given value.  The default value is 1.4.
         *
         * @param factorR the value (should be in the range 1..5)
         * @return the builder
         */
        public Builder factorR(double factorR) {
            this.factorR = factorR;
            return this;
        }

        /**
         * Sets the size of moving average for LBD (restarts) to a given value.  The default value is 50.
         *
         * @param sizeLBDQueue the value (should be at least 10)
         * @return the builder
         */
        public Builder sizeLBDQueue(int sizeLBDQueue) {
            this.sizeLBDQueue = sizeLBDQueue;
            return this;
        }

        /**
         * Sets the size of moving average for trail (block restarts) to a given value.  The default value is 5000.
         *
         * @param sizeTrailQueue the value (should be at least 10)
         * @return the builder
         */
        public Builder sizeTrailQueue(int sizeTrailQueue) {
            this.sizeTrailQueue = sizeTrailQueue;
            return this;
        }

        /**
         * Turns on the size reduction during LBD computation like described in the XMinisat paper.  The default value is
         * {@code false}.
         *
         * @param reduceOnSize {@code true} if the size reduction is turned on, {@code false} otherwise
         * @return the builder
         */
        public Builder reduceOnSize(boolean reduceOnSize) {
            this.reduceOnSize = reduceOnSize;
            return this;
        }

        /**
         * Sets the constant used during size reduction like described in the XMinisat paper to a given value.  The default
         * value is 12.
         *
         * @param reduceOnSizeSize the value
         * @return the builder
         */
        public Builder reduceOnSizeSize(int reduceOnSizeSize) {
            this.reduceOnSizeSize = reduceOnSizeSize;
            return this;
        }

        /**
         * Sets the maximal variable activity decay factor to a given value.  The default value is 0.95.
         *
         * @param maxVarDecay the value (should be in the range 0..1)
         * @return the builder
         */
        public Builder maxVarDecay(double maxVarDecay) {
            this.maxVarDecay = maxVarDecay;
            return this;
        }

        /**
         * Builds the Glucose configuration.
         *
         * @return the configuration
         */
        public GlucoseConfig build() {
            return new GlucoseConfig(this);
        }
    }
}
