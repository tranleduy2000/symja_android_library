//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.logicng.transformations.qmc;

import org.logicng.cardinalityconstraints.CCIncrementalData;
import org.logicng.datastructures.Assignment;
import org.logicng.datastructures.Tristate;
import org.logicng.formulas.CType;
import org.logicng.formulas.Formula;
import org.logicng.formulas.FormulaFactory;
import org.logicng.formulas.Literal;
import org.logicng.formulas.Variable;
import org.logicng.solvers.MiniSat;
import org.logicng.solvers.SATSolver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class QuineMcCluskeyAlgorithm {
    public QuineMcCluskeyAlgorithm() {
    }

    public static Formula compute(Formula formula, Collection<Variable> relevantVariables) {
        FormulaFactory f = formula.factory();
        SATSolver solver = MiniSat.miniSat(f);
        solver.add(formula);
        List<Assignment> models = relevantVariables == null ? solver.enumerateAllModels() : solver.enumerateAllModels(relevantVariables);
        return compute(models, f);
    }

    public static Formula compute(Formula formula) {
        return compute(formula, null);
    }

    public static Formula compute(List<Assignment> models, FormulaFactory f) {
        if (models.isEmpty()) {
            return f.falsum();
        } else if (models.size() == 1) {
            return models.get(0).formula(f);
        } else {
            List<Variable> varOrder = new ArrayList<>(models.get(0).positiveLiterals());
            varOrder.addAll(models.get(0).negativeVariables());
            Collections.sort(varOrder);
            List<Term> terms = transformModels2Terms(models, varOrder, f);
            LinkedHashSet<Term> primeImplicants = computePrimeImplicants(terms);
            TermTable primeTermTable = new TermTable(primeImplicants);
            primeTermTable.simplifyTableByDominance();
            List<Term> chosenTerms = chooseSatBased(primeTermTable, f);
            return computeFormula(chosenTerms, varOrder);
        }
    }

    private static List<Term> transformModels2Terms(List<Assignment> models, List<Variable> varOrder, FormulaFactory f) {
        List<Term> terms = new ArrayList<>(models.size());
        Iterator<Assignment> var4 = models.iterator();

        while (var4.hasNext()) {
            Assignment model = var4.next();
            List<Literal> minterm = new ArrayList<>();
            Iterator<Variable> var7 = varOrder.iterator();

            while (var7.hasNext()) {
                Variable variable = var7.next();
                minterm.add(model.evaluateLit(variable) ? variable : variable.negate());
            }

            terms.add(convertToTerm(minterm, f));
        }

        return terms;
    }

    private static LinkedHashSet<Term> computePrimeImplicants(List<Term> terms) {
        SortedMap<Integer, LinkedHashSet<Term>> termsInClasses = generateInitialTermClasses(terms);
        SortedMap<Integer, LinkedHashSet<Term>> newTermsInClasses = combineInTermClasses(termsInClasses);
        LinkedHashSet<Term> primeImplicants = getUnusedTerms(termsInClasses);

        while (!newTermsInClasses.isEmpty()) {
            termsInClasses = newTermsInClasses;
            newTermsInClasses = combineInTermClasses(newTermsInClasses);
            primeImplicants.addAll(getUnusedTerms(termsInClasses));
        }

        return primeImplicants;
    }

    private static SortedMap<Integer, LinkedHashSet<Term>> combineInTermClasses(SortedMap<Integer, LinkedHashSet<Term>> termsInClasses) {
        SortedMap<Integer, LinkedHashSet<Term>> newTermsInClasses = new TreeMap<>();

        for (int i = 0; i < termsInClasses.lastKey(); ++i) {
            LinkedHashSet<Term> thisClass = termsInClasses.get((i));
            LinkedHashSet<Term> otherClass = termsInClasses.get((i + 1));
            if (thisClass != null && otherClass != null) {
                Iterator<Term> var5 = thisClass.iterator();

                while (var5.hasNext()) {
                    Term thisTerm = var5.next();
                    Iterator<Term> var7 = otherClass.iterator();

                    while (var7.hasNext()) {
                        Term otherTerm = var7.next();
                        Term combined = thisTerm.combine(otherTerm);
                        if (combined != null) {
                            thisTerm.setUsed(true);
                            otherTerm.setUsed(true);
                            LinkedHashSet<Term> foundTerms = newTermsInClasses.get((combined.termClass()));
                            if (foundTerms == null) {
                                foundTerms = new LinkedHashSet<>();
                                newTermsInClasses.put((combined.termClass()), foundTerms);
                            }

                            foundTerms.add(combined);
                        }
                    }
                }
            }
        }

        return newTermsInClasses;
    }

    private static LinkedHashSet<Term> getUnusedTerms(SortedMap<Integer, LinkedHashSet<Term>> termsInClasses) {
        LinkedHashSet<Term> unusedTerms = new LinkedHashSet<>();
        Iterator<Entry<Integer, LinkedHashSet<Term>>> var2 = termsInClasses.entrySet().iterator();

        while (var2.hasNext()) {
            Entry<Integer, LinkedHashSet<Term>> entry = var2.next();
            Iterator var4 = ((LinkedHashSet) entry.getValue()).iterator();

            while (var4.hasNext()) {
                Term term = (Term) var4.next();
                if (!term.isUsed()) {
                    unusedTerms.add(term);
                }
            }
        }

        return unusedTerms;
    }

    private static SortedMap<Integer, LinkedHashSet<Term>> generateInitialTermClasses(List<Term> terms) {
        SortedMap<Integer, LinkedHashSet<Term>> termsInClasses = new TreeMap<>();

        Term term;
        LinkedHashSet<Term> presentTerms;
        for (Iterator<Term> var2 = terms.iterator(); var2.hasNext(); presentTerms.add(term)) {
            term = var2.next();
            presentTerms = termsInClasses.get((term.termClass()));
            if (presentTerms == null) {
                presentTerms = new LinkedHashSet<>();
                termsInClasses.put((term.termClass()), presentTerms);
            }
        }

        return termsInClasses;
    }

    private static Formula computeFormula(List<Term> chosenTerms, List<Variable> varOrder) {
        FormulaFactory f = varOrder.get(0).factory();
        List<Formula> operands = new ArrayList<>(chosenTerms.size());
        Iterator<Term> var4 = chosenTerms.iterator();

        while (var4.hasNext()) {
            Term term = var4.next();
            operands.add(term.translateToFormula(varOrder));
        }

        return f.or(operands);
    }

    private static Term convertToTerm(List<Literal> minterm, FormulaFactory f) {
        Tristate[] bits = new Tristate[minterm.size()];

        for (int i = 0; i < minterm.size(); ++i) {
            bits[i] = Tristate.fromBool(minterm.get(i).phase());
        }

        return new Term(bits, Collections.singletonList(f.and(minterm)));
    }

    private static List<Term> chooseSatBased(TermTable table, FormulaFactory f) {
        LinkedHashMap<Variable, Term> var2Term = new LinkedHashMap<>();
        LinkedHashMap<Formula, Variable> formula2VarMapping = new LinkedHashMap<>();
        SATSolver satSolver = initializeSolver(table, f, var2Term, formula2VarMapping);
        if (satSolver.sat() == Tristate.FALSE) {
            throw new IllegalStateException("Solver must be satisfiable after adding the initial formula.");
        } else {
            return minimize(satSolver, var2Term, f);
        }
    }

    private static SATSolver initializeSolver(TermTable table, FormulaFactory f, LinkedHashMap<Variable, Term> var2Term, LinkedHashMap<Formula, Variable> formula2VarMapping) {
        LinkedHashMap<Variable, List<Variable>> minterm2Variants = new LinkedHashMap<>();
        int count = 0;
        String prefix = "@MINTERM_SEL_";
        Iterator<Formula> var7 = table.columnHeaders().iterator();

        while (var7.hasNext()) {
            Formula formula = var7.next();
            Variable selector = f.variable(prefix + count++);
            formula2VarMapping.put(formula, selector);
            minterm2Variants.put(selector, new ArrayList<Variable>());
        }

        count = 0;
        prefix = "@TERM_SEL_";
        SATSolver solver = MiniSat.miniSat(f);

        Iterator var18;
        for (var18 = table.lineHeaders().iterator(); var18.hasNext(); ++count) {
            Term term = (Term) var18.next();
            Variable termSelector = f.variable(prefix + count);
            var2Term.put(termSelector, term);
            List<Variable> mintermSelectors = new ArrayList<>();
            Iterator<Formula> var12 = term.minterms().iterator();

            Variable mintermSelector;
            while (var12.hasNext()) {
                Formula formula = var12.next();
                mintermSelector = formula2VarMapping.get(formula);
                if (mintermSelector != null) {
                    Variable selectorVariant = f.variable(mintermSelector.name() + "_" + count);
                    minterm2Variants.get(mintermSelector).add(selectorVariant);
                    mintermSelectors.add(selectorVariant);
                }
            }

            List<Literal> operands = new ArrayList<>();

            for (int i = 0; i < mintermSelectors.size(); ++i) {
                mintermSelector = mintermSelectors.get(i);
                solver.add(f.clause(new Literal[]{termSelector.negate(), mintermSelector}));
                operands.add(mintermSelector.negate());

                for (int j = i + 1; j < mintermSelectors.size(); ++j) {
                    Variable mintermSelector2 = mintermSelectors.get(j);
                    solver.add(f.or(new Formula[]{mintermSelector.negate(), mintermSelector2}));
                    solver.add(f.or(new Formula[]{mintermSelector2.negate(), mintermSelector}));
                }
            }

            operands.add(termSelector);
            solver.add(f.clause(operands));
        }

        var18 = minterm2Variants.values().iterator();

        while (var18.hasNext()) {
            List<Variable> variables = (List) var18.next();
            solver.add(f.clause(variables));
        }

        return solver;
    }

    private static List<Term> minimize(SATSolver satSolver, LinkedHashMap<Variable, Term> var2Term, FormulaFactory f) {
        Assignment initialModel = satSolver.model();
        List<Variable> currentTermVars = computeCurrentTermVars(initialModel, var2Term.keySet());
        if (currentTermVars.size() == 2) {
            satSolver.add(f.amo(var2Term.keySet()));
            if (satSolver.sat() == Tristate.TRUE) {
                currentTermVars = computeCurrentTermVars(satSolver.model(), var2Term.keySet());
            }
        } else {
            CCIncrementalData incData = satSolver.addIncrementalCC(f.cc(CType.LE, currentTermVars.size() - 1, var2Term.keySet()));

            while (satSolver.sat() == Tristate.TRUE) {
                currentTermVars = computeCurrentTermVars(satSolver.model(), var2Term.keySet());
                incData.newUpperBoundForSolver(currentTermVars.size() - 1);
            }
        }

        return computeTerms(currentTermVars, var2Term);
    }

    private static List<Term> computeTerms(List<Variable> currentTermVars, LinkedHashMap<Variable, Term> var2Term) {
        List<Term> terms = new ArrayList<>(currentTermVars.size());
        Iterator<Variable> var3 = currentTermVars.iterator();

        while (var3.hasNext()) {
            Variable currentTermVar = var3.next();
            terms.add(var2Term.get(currentTermVar));
        }

        return terms;
    }

    private static List<Variable> computeCurrentTermVars(Assignment model, Collection<Variable> vars) {
        List<Variable> result = new ArrayList<>();
        Iterator<Variable> var3 = vars.iterator();

        while (var3.hasNext()) {
            Variable var = var3.next();
            if (model.evaluateLit(var)) {
                result.add(var);
            }
        }

        return result;
    }
}
