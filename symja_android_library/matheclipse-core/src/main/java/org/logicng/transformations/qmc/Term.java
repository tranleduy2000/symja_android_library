//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.logicng.transformations.qmc;

import org.logicng.datastructures.Tristate;
import org.logicng.formulas.Formula;
import org.logicng.formulas.FormulaFactory;
import org.logicng.formulas.Literal;
import org.logicng.formulas.Variable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Term {
    private final Tristate[] bits;
    private final List<Formula> minterms;
    private final int termClass;
    private final long undefNum;
    private boolean used;

    Term(Tristate[] bits, List<Formula> minterms) {
        this.bits = bits;
        this.minterms = minterms;
        this.termClass = this.countNonNegativeBits(bits);
        this.undefNum = this.computeUndefNum(bits);
    }

    private int countNonNegativeBits(Tristate[] bits) {
        int result = 0;
        Tristate[] var3 = bits;
        int var4 = bits.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            Tristate bit = var3[var5];
            if (bit != Tristate.FALSE) {
                ++result;
            }
        }

        return result;
    }

    private long computeUndefNum(Tristate[] bits) {
        long sum = 0L;

        for (int i = bits.length - 1; i >= 0; --i) {
            if (bits[i] == Tristate.UNDEF) {
                sum = (long) ((double) sum + Math.pow(2.0D, (double) (bits.length - 1 - i)));
            }
        }

        return sum;
    }

    Tristate[] bits() {
        return this.bits;
    }

    List<Formula> minterms() {
        return this.minterms;
    }

    int termClass() {
        return this.termClass;
    }

    boolean isUsed() {
        return this.used;
    }

    void setUsed(boolean used) {
        this.used = used;
    }

    Term combine(Term other) {
        if (this.bits.length != other.bits.length) {
            return null;
        } else if (this.undefNum != other.undefNum) {
            return null;
        } else {
            int diffPosition = -1;

            for (int i = 0; i < this.bits.length; ++i) {
                if (this.bits[i] != other.bits[i]) {
                    if (diffPosition != -1) {
                        return null;
                    }

                    diffPosition = i;
                }
            }

            if (diffPosition == -1) {
                return null;
            } else {
                Tristate[] newBits = (Tristate[]) Arrays.copyOf(this.bits, this.bits.length);
                newBits[diffPosition] = Tristate.UNDEF;
                List<Formula> newMinterms = new ArrayList(this.minterms);
                newMinterms.addAll(other.minterms);
                return new Term(newBits, newMinterms);
            }
        }
    }

    Formula translateToFormula(List<Variable> varOrder) {
        FormulaFactory f = ((Variable) varOrder.get(0)).factory();

        assert this.bits.length == varOrder.size();

        List<Literal> operands = new ArrayList(varOrder.size());

        for (int i = 0; i < this.bits.length; ++i) {
            if (this.bits[i] != Tristate.UNDEF) {
                operands.add(this.bits[i] == Tristate.TRUE ? (Literal) varOrder.get(i) : ((Variable) varOrder.get(i)).negate());
            }
        }

        return f.and(operands);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Term term = (Term) o;
            return Arrays.equals(this.bits, term.bits);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Arrays.hashCode(this.bits);
    }

    public String toString() {
        return "Term{bits=" + Arrays.toString(this.bits) + ", minterms=" + this.minterms + ", termClass=" + this.termClass + '}';
    }
}
