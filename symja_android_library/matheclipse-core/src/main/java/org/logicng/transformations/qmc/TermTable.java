//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.logicng.transformations.qmc;

import org.logicng.datastructures.Tristate;
import org.logicng.formulas.Formula;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Vector;

class TermTable {
    private final Vector<Formula> columnHeaders;
    private final Vector<Term> lineHeaders;
    private final Vector<Vector<Boolean>> matrixLines;
    private final Vector<Vector<Boolean>> matrixColumns;

    TermTable(LinkedHashSet<Term> terms) {
        this.lineHeaders = new Vector(terms.size());
        this.columnHeaders = this.initializeColumnHeaders(terms);
        this.matrixLines = new Vector(terms.size());
        this.matrixColumns = new Vector(this.columnHeaders.size());
        Vector<Boolean> matrixLineTemplate = new Vector(this.columnHeaders.size());

        for (int i = 0; i < this.columnHeaders.size(); ++i) {
            matrixLineTemplate.add(Boolean.valueOf(false));
        }

        Vector<Boolean> matrixColumnTemplate = new Vector(terms.size());

        int count;
        for (count = 0; count < terms.size(); ++count) {
            matrixColumnTemplate.add(Boolean.valueOf(false));
        }

        for (count = 0; count < this.columnHeaders.size(); ++count) {
            this.matrixColumns.add(new Vector(matrixColumnTemplate));
        }

        count = 0;

        for (Iterator var5 = terms.iterator(); var5.hasNext(); ++count) {
            Term term = (Term) var5.next();
            this.lineHeaders.add(term);
            Vector<Boolean> matrixLine = new Vector(matrixLineTemplate);
            this.matrixLines.add(matrixLine);
            Iterator var8 = term.minterms().iterator();

            while (var8.hasNext()) {
                Formula minterm = (Formula) var8.next();
                int index = this.columnHeaders.indexOf(minterm);
                matrixLine.setElementAt(Boolean.valueOf(true), index);
                ((Vector) this.matrixColumns.get(index)).setElementAt(Boolean.valueOf(true), count);
            }
        }

    }

    static boolean isSubsetOf(Vector<Boolean> vec1, Vector<Boolean> vec2) {
        for (int i = 0; i < vec1.size(); ++i) {
            if (((Boolean) vec1.get(i)).booleanValue() && !((Boolean) vec2.get(i)).booleanValue()) {
                return false;
            }
        }

        return true;
    }

    private static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", new Object[]{s});
    }

    private Vector<Formula> initializeColumnHeaders(LinkedHashSet<Term> terms) {
        LinkedHashSet<Formula> header = new LinkedHashSet();
        Iterator var3 = terms.iterator();

        while (var3.hasNext()) {
            Term term = (Term) var3.next();
            header.addAll(term.minterms());
        }

        return new Vector(header);
    }

    void simplifyTableByDominance() {
        boolean changed;
        do {
            boolean eliminatedColumns = this.eliminateColumnDominance();
            boolean eliminatedLines = this.eliminateLineDominance();
            changed = eliminatedColumns || eliminatedLines;
        } while (changed);

    }

    private boolean eliminateColumnDominance() {
        SortedSet<Integer> toEliminate = new TreeSet();

        int i;
        for (i = 0; i < this.matrixColumns.size(); ++i) {
            for (int j = i + 1; j < this.matrixColumns.size(); ++j) {
                if (isSubsetOf((Vector) this.matrixColumns.get(i), (Vector) this.matrixColumns.get(j))) {
                    toEliminate.add(Integer.valueOf(j));
                } else if (isSubsetOf((Vector) this.matrixColumns.get(j), (Vector) this.matrixColumns.get(i))) {
                    toEliminate.add(Integer.valueOf(i));
                }
            }
        }

        i = 0;
        Iterator var5 = toEliminate.iterator();

        while (var5.hasNext()) {
            Integer toDelete = (Integer) var5.next();
            this.deleteColumn(toDelete.intValue() - i++);
        }

        return !toEliminate.isEmpty();
    }

    private boolean eliminateLineDominance() {
        SortedSet<Integer> toEliminate = new TreeSet();

        int i;
        for (i = 0; i < this.matrixLines.size(); ++i) {
            for (int j = i + 1; j < this.matrixLines.size(); ++j) {
                if (isSubsetOf((Vector) this.matrixLines.get(i), (Vector) this.matrixLines.get(j))) {
                    toEliminate.add(Integer.valueOf(i));
                } else if (isSubsetOf((Vector) this.matrixLines.get(j), (Vector) this.matrixLines.get(i))) {
                    toEliminate.add(Integer.valueOf(j));
                }
            }
        }

        i = 0;
        Iterator var5 = toEliminate.iterator();

        while (var5.hasNext()) {
            Integer toDelete = (Integer) var5.next();
            this.deleteLine(toDelete.intValue() - i++);
        }

        return !toEliminate.isEmpty();
    }

    private void deleteColumn(int colIndex) {
        this.columnHeaders.removeElementAt(colIndex);
        this.matrixColumns.removeElementAt(colIndex);
        Iterator var2 = this.matrixLines.iterator();

        while (var2.hasNext()) {
            Vector<Boolean> line = (Vector) var2.next();
            line.removeElementAt(colIndex);
        }

    }

    private void deleteLine(int lineIndex) {
        this.lineHeaders.removeElementAt(lineIndex);
        this.matrixLines.removeElementAt(lineIndex);
        Iterator var2 = this.matrixColumns.iterator();

        while (var2.hasNext()) {
            Vector<Boolean> column = (Vector) var2.next();
            column.removeElementAt(lineIndex);
        }

    }

    Vector<Vector<Boolean>> lines() {
        return this.matrixLines;
    }

    Vector<Vector<Boolean>> columns() {
        return this.matrixColumns;
    }

    Vector<Formula> columnHeaders() {
        return this.columnHeaders;
    }

    Vector<Term> lineHeaders() {
        return this.lineHeaders;
    }

    public String toString() {
        Vector<String> lineHeaderStrings = new Vector();
        Iterator var2 = this.lineHeaders.iterator();

        while (var2.hasNext()) {
            Term header = (Term) var2.next();
            lineHeaderStrings.add(this.formatBits(header.bits()));
        }

        int lineHeaderSize = ((String) lineHeaderStrings.firstElement()).length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < lineHeaderSize; ++i) {
            sb.append(" ");
        }

        sb.append(" | ");
        LinkedHashMap<String, String> legend = new LinkedHashMap();
        int columnSize = 0;

        int i;
        String s;
        for (i = 0; i < this.columnHeaders.size(); ++i) {
            s = "m" + i;
            legend.put(s, ((Formula) this.columnHeaders.get(i)).toString());
            if (s.length() > columnSize) {
                columnSize = s.length();
            }
        }

        Iterator var11 = legend.keySet().iterator();

        while (var11.hasNext()) {
            s = (String) var11.next();
            sb.append(String.format("%s | ", new Object[]{padRight(s, columnSize)}));
        }

        sb.append(String.format("%n", new Object[0]));

        for (i = 0; i < this.matrixLines.size(); ++i) {
            sb.append(String.format("%s | %s%n", new Object[]{lineHeaderStrings.get(i), this.formatMatrixLine((Vector) this.matrixLines.get(i), columnSize)}));
        }

        return sb.toString();
    }

    private String formatMatrixLine(Vector<Boolean> booleans, int size) {
        StringBuilder sb = new StringBuilder();
        Iterator var4 = booleans.iterator();

        while (var4.hasNext()) {
            Boolean entry = (Boolean) var4.next();
            sb.append(padRight(entry.booleanValue() ? "X" : " ", size)).append(" | ");
        }

        return sb.toString();
    }

    private String formatBits(Tristate[] bits) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < bits.length; ++i) {
            if (bits[i] == Tristate.TRUE) {
                sb.append("1");
            } else if (bits[i] == Tristate.FALSE) {
                sb.append("0");
            } else {
                sb.append("-");
            }

            if (i < bits.length - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }
}
