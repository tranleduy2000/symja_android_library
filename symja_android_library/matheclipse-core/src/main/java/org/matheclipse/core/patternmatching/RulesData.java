package org.matheclipse.core.patternmatching;

import com.duy.lambda.Predicate;

import org.matheclipse.core.basic.Config;
import org.matheclipse.core.basic.OperationSystem;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.util.OpenIntToIExprHashMap;
import org.matheclipse.core.expression.Context;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IASTAppendable;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.IStringX;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.core.visit.AbstractVisitor;
import org.matheclipse.parser.client.FEConfig;

import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import it.unimi.dsi.fastutil.ints.IntArrayList;


/**
 * The pattern matching rules associated with a symbol.
 */
public final class RulesData implements Serializable {
	private static final long serialVersionUID = -7747268035549814899L;

	static boolean showSteps = false;

	/**
	 * 
	 */
	public static final int DEFAULT_VALUE_INDEX = Integer.MIN_VALUE;

	/**
	 * If this method returns <code>false</code>, the matching can try to match the <code>lha</code> with a hash value
	 * in a step before the &quot;real structural pattern matching&quot;.
	 *
	 * @param lhs
	 *            the left-hand-side of pattern matching definition
	 * @return
	 */
	public static boolean isComplicatedPatternRule(final IExpr lhs) {
		if (lhs.isAST()) {
			final IAST lhsAST = ((IAST) lhs);
			if (lhsAST.size() > 1) {
				int attr = lhsAST.topHead().getAttributes();
				if ((ISymbol.ORDERLESS & attr) == ISymbol.ORDERLESS) {
					return true;
				}
				IExpr a1 = lhsAST.arg1();
				if (isComplicatedPatternExpr(a1) || !a1.head().isFreeOfPatterns()) {
					return true;
				}
				if (lhsAST.exists(new Predicate<IExpr>() {
					@Override
					public boolean test(IExpr x) {
						return x.isPatternDefault() || x.isPatternSequence(false);
					}
				})) {
					return true;
				}
			}
			return !lhs.head().isFreeOfPatterns();
		}
		return isComplicatedPatternExpr(lhs);
	}

	private static boolean isComplicatedPatternExpr(IExpr a1) {
		if (a1.isBlank()) {
					return true;
		} else if (a1.isPattern()) {
			return true;
		} else if (a1.isPatternSequence(false)) {
			return true;
		} else if (a1.isAST()) {
			if (a1.isPatternMatchingFunction()) {
				return true;
			}

			IAST arg1 = (IAST) a1;
			IExpr head = arg1.head();
			if (!head.isSymbol() && isComplicatedPatternExpr(head)) {
				// the head contains a pattern F_(a1, a2,...) or complicated expression
				return true;
			}
			// the left hand side is associated with the first argument
			// see if one of the arguments contain a pattern with default
			// value
			return arg1.exists(new Predicate<IExpr>() {
				@Override
				public boolean test(IExpr x) {
					return x.isPatternDefault();
				}
			}, 1);
		}
		return false;
	}

	private OpenIntToIExprHashMap<IExpr> fDefaultValues;

	private Map<String, IStringX> fMessages;

	private Map<IExpr, PatternMatcherEquals> fEqualDownRules;

	/**
	 * List of pattern matchers. The corresponding priority is stored in <code>fPriorityDownRules</code>.
	 */
	private List<IPatternMatcher> fPatternDownRules;
	/**
	 * Sorted int array of the priorities of the correponding <code>fPatternDownRules</code> matcher.
	 */
	private transient IntArrayList fPriorityDownRules;
	private Map<IExpr, PatternMatcherEquals> fEqualUpRules;
	private List<IPatternMatcher> fSimplePatternUpRules;

	public RulesData() {
		clear();
	}

	public RulesData(int[] sizes) {
		// this.context = context;
		clear();
		if (sizes.length > 0) {
			int capacity;
			if (sizes[0] > 0) {
				capacity = sizes[0];
				if (capacity < 8) {
					capacity = 8;
				}
				fEqualDownRules = new HashMap<IExpr, PatternMatcherEquals>(capacity);
			}
		}
	}

	/**
	 * <p>
	 * Run the given visitor on every IAST stored in the rule database.
	 * </p>
	 * Example: optimize internal memory usage by sharing common objects.
	 * 
	 * @param visitor
	 *            the visitor whch manipulates the IAST objects
	 * @return
	 */
	public IAST accept(AbstractVisitor visitor) {
		Iterator<IExpr> iter;
		IExpr key;
		PatternMatcherEquals pmEquals;
		IAST ast;
		IExpr condition;
		PatternMatcherAndEvaluator pmEvaluator;
		if (fEqualUpRules != null && fEqualUpRules.size() > 0) {
			iter = fEqualUpRules.keySet().iterator();
			while (iter.hasNext()) {
				key = iter.next();
				pmEquals = fEqualUpRules.get(key);
				if (key.isAST()) {
					key.accept(visitor);
				}
				if (pmEquals.getRHS().isAST()) {
					pmEquals.getRHS().accept(visitor);
				}
			}
		}
		if (fSimplePatternUpRules != null && fSimplePatternUpRules.size() > 0) {
			List<IPatternMatcher> upRules = fSimplePatternUpRules;
			for (int i = 0; i < upRules.size(); i++) {
				if (upRules.get(i) != null) {
					IPatternMatcher elem = upRules.get(i);
						if (elem instanceof PatternMatcherAndEvaluator) {
							pmEvaluator = (PatternMatcherAndEvaluator) elem;
							if (pmEvaluator.getLHS().isAST()) {
								pmEvaluator.getLHS().accept(visitor);
							}
							if (pmEvaluator.getRHS().isAST()) {
								pmEvaluator.getRHS().accept(visitor);
							}
							condition = pmEvaluator.getCondition();
							if (condition != null) {
								if (condition.isAST()) {
									condition.accept(visitor);
								}
							}
						}
				}
			}
		}

		if (fEqualDownRules != null && fEqualDownRules.size() > 0) {
			iter = fEqualDownRules.keySet().iterator();
			while (iter.hasNext()) {
				key = iter.next();
				pmEquals = fEqualDownRules.get(key);
				ast = pmEquals.getAsAST();
				if (key.isAST()) {
					key.accept(visitor);
				}
				ast.accept(visitor);
			}
		}

		if (fPatternDownRules != null && fPatternDownRules.size() > 0) {
			IPatternMatcher[] list = fPatternDownRules.toArray(new IPatternMatcher[0]);
			final int length = list.length;
			for (int i = 0; i < length; i++) {
				if (list[i] instanceof PatternMatcherAndEvaluator) {
					pmEvaluator = (PatternMatcherAndEvaluator) list[i];
					ast = pmEvaluator.getAsAST();
					ast.accept(visitor);
				}
			}

		}

		return null;
	}

	/**
	 * Create a pattern hash value for the left-hand-side expression and insert the left-hand-side as a simple pattern
	 * rule to the <code>fSimplePatternRules</code>.
	 * 
	 * @param leftHandSide
	 * @param pmEvaluator
	 * @return
	 */
	private PatternMatcher addSimplePatternUpRule(final IExpr leftHandSide, final PatternMatcher pmEvaluator) {
		IExpr head = ((IAST) leftHandSide).head();
		if (head.isFreeOfPatterns()) {
		final int hash = ((IAST) leftHandSide).topHead().hashCode();
			if (F.isSystemInitialized) {
				int indx = fSimplePatternUpRules.indexOf(pmEvaluator);
				if (indx >= 0) {
					fSimplePatternUpRules.remove(indx);
				}
			}
			fSimplePatternUpRules.add(pmEvaluator);
			return pmEvaluator;
		}

		if (F.isSystemInitialized) {
			int indx = fSimplePatternUpRules.indexOf(pmEvaluator);
			if (indx >= 0) {
				fSimplePatternUpRules.remove(indx);
		}
		}
		fSimplePatternUpRules.add(pmEvaluator);
		return pmEvaluator;
	}

	public void clear() {
		fEqualDownRules = null;
		fPatternDownRules = null;
		fPriorityDownRules = null;
		fEqualUpRules = null;
		fSimplePatternUpRules = null;
	}

	public List<IAST> definition() {
		ArrayList<IAST> definitionList = new ArrayList<IAST>();
		Iterator<IExpr> iter;
		IExpr key;
		PatternMatcherEquals pmEquals;
		PatternMatcherAndEvaluator pmEvaluator;
		if (fEqualUpRules != null && fEqualUpRules.size() > 0) {
			iter = fEqualUpRules.keySet().iterator();
			while (iter.hasNext()) {
				key = iter.next();
				pmEquals = fEqualUpRules.get(key);
				definitionList.add( pmEquals.getAsAST());
			}
		}
		if (fSimplePatternUpRules != null) {
			for (int i = 0; i < fSimplePatternUpRules.size(); i++) {
				IPatternMatcher elem = fSimplePatternUpRules.get(i);
						if (elem instanceof PatternMatcherAndEvaluator) {
							pmEvaluator = (PatternMatcherAndEvaluator) elem;
							definitionList.add(pmEvaluator.getAsAST());

				}
			}
		}

		if (fEqualDownRules != null && fEqualDownRules.size() > 0) {
			iter = fEqualDownRules.keySet().iterator();
			while (iter.hasNext()) {
				key = iter.next();
				pmEquals = fEqualDownRules.get(key);
				definitionList.add(pmEquals.getAsAST());
			}
		}

		if (fPatternDownRules != null && fPatternDownRules.size() > 0) {
			IPatternMatcher[] list = fPatternDownRules.toArray(new IPatternMatcher[0]);
			final int length = list.length;
			for (int i = 0; i < length; i++) {
				if (list[i] instanceof PatternMatcherAndEvaluator) {
					pmEvaluator = (PatternMatcherAndEvaluator) list[i];
					definitionList.add(pmEvaluator.getAsAST());
				}
			}

		}

		return definitionList;
	}

	/**
	 * Give the <code>DownValues()</code> of a symbol as a list of <code>RuleDelayed</code> (delayed rules) with the
	 * left-hand-side wrapped in a <code>HoldPattern()</code> expression.
	 *
	 * @return a list of <code>RuleDelayed(HoldPattern(lhs), rhs)</code> rules
	 */
	public IAST downValues() {
		int size = 1;
		if (fEqualDownRules != null) {
			size += fEqualDownRules.size();
		}
		if (fPatternDownRules != null) {
			size += fPatternDownRules.size();
		}
		IASTAppendable result = F.ListAlloc(size);
		if (fEqualDownRules != null) {
			for (Map.Entry<IExpr, PatternMatcherEquals> entry : fEqualDownRules.entrySet()) {
				PatternMatcherEquals value = entry.getValue();
				result.append(F.RuleDelayed(F.HoldPattern(value.getLHS()), value.getRHS()));
			}
		}
		if (fPatternDownRules != null ) {
			for (int i = 0; i < fPatternDownRules.size(); i++) {
				IPatternMatcher matcher=fPatternDownRules.get(i);
				result.append(F.RuleDelayed(F.HoldPattern(matcher.getLHS()), matcher.getRHS()));
			}
		}
		return result;
	}

	/**
	 * Give the <code>UpValues()</code> of a symbol as a list of <code>RuleDelayed</code> (delayed rules) with the
	 * left-hand-side wrapped in a <code>HoldPattern()</code> expression.
	 *
	 * @return a list of <code>RuleDelayed(HoldPattern(lhs), rhs)</code> rules
	 */
	public IAST upValues() {
		int size = 1;
		if (fEqualUpRules != null) {
			size += fEqualUpRules.size();
		}
		if (fSimplePatternUpRules != null) {
			size += fSimplePatternUpRules.size();
		}
		IASTAppendable result = F.ListAlloc(size);
		if (fEqualUpRules != null) {
			for (Map.Entry<IExpr, PatternMatcherEquals> entry : fEqualUpRules.entrySet()) {
				PatternMatcherEquals value = entry.getValue();
				result.append(F.RuleDelayed(F.HoldPattern(value.getLHS()), value.getRHS()));
			}
		}
		if (fSimplePatternUpRules != null ) {
			for (int i = 0; i < fSimplePatternUpRules.size(); i++) {
				IPatternMatcher matcher=fSimplePatternUpRules.get(i);
				result.append(F.RuleDelayed(F.HoldPattern(matcher.getLHS()), matcher.getRHS()));
			}
		}
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		RulesData other = (RulesData) obj;

		if (fEqualDownRules == null) {
			if (other.fEqualDownRules != null)
				return false;
		} else if (!fEqualDownRules.equals(other.fEqualDownRules))
			return false;
		if (fEqualUpRules == null) {
			if (other.fEqualUpRules != null)
				return false;
		} else if (!fEqualUpRules.equals(other.fEqualUpRules))
			return false;

		if (fPatternDownRules == null) {
			if (other.fPatternDownRules != null)
				return false;
		} else if (!fPatternDownRules.equals(other.fPatternDownRules))
			return false;

		if (fSimplePatternUpRules == null) {
			if (other.fSimplePatternUpRules != null)
				return false;
		} else if (!fSimplePatternUpRules.equals(other.fSimplePatternUpRules))
			return false;

		return true;
	}

	/**
	 * 
	 * @param expr
	 * @return <code>F.NIL</code> if no evaluation was possible
	 */
	public IExpr evalDownRule(final IExpr expr, EvalEngine engine) {

		if (Config.SHOW_PATTERN_EVAL_STEPS) {
			showSteps = Config.SHOW_PATTERN_SYMBOL_STEPS.contains(expr.topHead());
			if (showSteps) {
				System.out.println("EVAL_EXPR: " + expr.toString());
			}
		}
		if (fEqualDownRules != null) {
			// if (showSteps) {
			// System.out.println(" EQUAL RULES");
			// }
			PatternMatcherEquals res = fEqualDownRules.get(expr);
			if (res != null) {
				if (showSteps) {
					System.out.println("\n  >>>> " + res.getRHS().toString());
				}
				return res.getRHS();
			}
		}

		if (!expr.isAST()) {
			return F.NIL;
		}

		boolean evalRHSMode = engine.isEvalRHSMode();
		try {
			engine.setEvalRHSMode(true);
			// obj-c changed: autoreleasepool
			// IPatternMatcher pmEvaluator;
			if (fPatternDownRules != null) {
				IExpr result;
				int patternHash = 0;
				if (expr.isAST()) {
					patternHash = ((IAST) expr).patternHashCode();
				}
				for (IPatternMatcher patternEvaluator : fPatternDownRules) {
					// if (patternEvaluator.fLhsPatternExpr.isAST(F.Integrate)) {
					// System.out.println(((IPatternMatcher) patternEvaluator).getLHSPriority());
					// if (((IPatternMatcher) patternEvaluator).getLHSPriority() == 5665) {
					// System.out.println("Debug from this line");
					// }
					// }
					if (patternEvaluator.isPatternHashAllowed(patternHash)) {
						OperationSystem.checkMemory();
						OperationSystem.checkInterrupt();
						// obj-c changed: autoreleasepool
						IPatternMatcher pmEvaluator;
						//pmEvaluator = (IPatternMatcher) patternEvaluator.clone(); // swift changed: memory issue
						pmEvaluator = patternEvaluator;
						//if (showSteps) {
						//	if (isShowSteps(pmEvaluator)) {
						//		IExpr rhs = pmEvaluator.getRHS().orElse(F.Null);
						//		System.out.println(
						//				" COMPLEX: " + pmEvaluator.getLHS().toString() + " := " + rhs.toString());
						//	}
						//}
						// if (pmEvaluator.getLHSPriority() == 6656) {
						// System.out.println("Debug from this line");
						// }
						//if (FEConfig.SHOW_STACKTRACE) {
						//	if (isShowPriority(pmEvaluator)) {
						//		System.out.print("try: " + pmEvaluator.getLHSPriority() + " - ");
						//	}
						//	// if (pmEvaluator.getLHSPriority() == 432) {
						//	// System.out.println(pmEvaluator.toString());
						//	// System.out.println(expr);
						//	// System.out.println("Debug from this line");
						//	// }
						//}
						// System.out.println(pmEvaluator.toString());
						// System.out.println(">>"+expr);


						result = pmEvaluator.eval(expr, engine);
						if (result.isPresent()) {
							// if (patternEvaluator.fLhsPatternExpr.isAST(F.Integrate)) {
							// System.out.println(((IPatternMatcher) patternEvaluator).toString());
							// // if (((IPatternMatcher) patternEvaluator).getLHSPriority() == 6686) {
							// System.out.println("Rule number: "+((IPatternMatcher)
							// patternEvaluator).getLHSPriority());
							// // }
							// }
							if (FEConfig.SHOW_STACKTRACE) {
								if (isShowPriority(pmEvaluator)) {
									System.out.println("matched: " + pmEvaluator.getLHSPriority() + ": " + pmEvaluator.toString());
								}
							}
							if (showSteps) {
								if (isShowSteps(pmEvaluator)) {
									IExpr rhs = pmEvaluator.getRHS();
									if (!rhs.isPresent()) {
										rhs = F.Null;
									}
									System.out.println(
											"\nCOMPLEX: " + pmEvaluator.getLHS().toString() + " := " + rhs.toString());
									System.out.println(" >>> " + expr.toString() + "  >>>>  " + result.toString());
								}
							}
							return result;
						}
						if (FEConfig.SHOW_STACKTRACE) {
							if (isShowPriority(pmEvaluator)) {
								System.out.print("not matched: " + pmEvaluator.getLHSPriority() + " ");
							}
						}
					}
				}
			}
		} /*catch (CloneNotSupportedException cnse) {
			cnse.printStackTrace();
		}*/ finally {
			engine.setEvalRHSMode(evalRHSMode);
		}
		return F.NIL;
	}

	private boolean isShowSteps(IPatternMatcher pmEvaluator) {
		IExpr head = pmEvaluator.getLHS().head();
		if (head.isSymbol() && ((ISymbol) head).getContext().equals(Context.RUBI)) {
			return true;
		}
		return head.equals(F.Integrate);
	}

	private boolean isShowPriority(IPatternMatcher pmEvaluator) {
		IExpr head = pmEvaluator.getLHS().head();
		return head.equals(F.Integrate);
	}

	public IExpr evalUpRule(final IExpr expression, EvalEngine engine) {
		PatternMatcherEquals res;
		if (fEqualUpRules != null) {
			res = fEqualUpRules.get(expression);
			if (res != null) {
				return res.getRHS();
			}
		}

		try {
			IPatternMatcher pmEvaluator;
			if ((fSimplePatternUpRules != null) && (expression.isAST())) {
							IExpr result;
				for (int i = 0; i < fSimplePatternUpRules.size(); i++) {
					pmEvaluator = (IPatternMatcher) fSimplePatternUpRules.get(i).clone();
								result = pmEvaluator.eval(expression, engine);
								if (result.isPresent()) {
									return result;
								}
							}
						}

		} catch (CloneNotSupportedException cnse) {
			cnse.printStackTrace();
		}
		return F.NIL;
	}

	final public IExpr getDefaultValue(int pos) {
		if (fDefaultValues == null) {
			return null;
		}
		return fDefaultValues.get(pos);
	}

	/**
	 * @return Returns the equalRules.
	 */
	final public Map<String, IStringX> getMessages() {
		if (fMessages == null) {
			fMessages = new HashMap<String, IStringX>();
		}
		return fMessages;
	}

	/**
	 * @return Returns the equalRules.
	 */
	final public Map<IExpr, PatternMatcherEquals> getEqualDownRules() {
		if (fEqualDownRules == null) {
			fEqualDownRules = new HashMap<IExpr, PatternMatcherEquals>();
		}
		return fEqualDownRules;
	}

	/**
	 * @return Returns the equalRules.
	 */
	final public Map<IExpr, PatternMatcherEquals> getEqualUpRules() {
		if (fEqualUpRules == null) {
			fEqualUpRules = new HashMap<IExpr, PatternMatcherEquals>();
		}
		return fEqualUpRules;
	}

	private List<IPatternMatcher> getSimplePatternUpRules() {
		if (fSimplePatternUpRules == null) {
			fSimplePatternUpRules = new ArrayList<IPatternMatcher>();// IPatternMatcher.EQUIVALENCE_COMPARATOR);
		}
		return fSimplePatternUpRules;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fEqualDownRules == null) ? 0 : fEqualDownRules.hashCode());
		result = prime * result + ((fEqualUpRules == null) ? 0 : fEqualUpRules.hashCode());
		result = prime * result + ((fPatternDownRules == null) ? 0 : fPatternDownRules.hashCode());
		result = prime * result + ((fSimplePatternUpRules == null) ? 0 : fSimplePatternUpRules.hashCode());
		return result;
	}


	public final IPatternMatcher putDownRule(final IExpr leftHandSide, final IExpr rightHandSide) {
		return putDownRule(IPatternMatcher.SET_DELAYED, false, leftHandSide, rightHandSide,
				IPatternMapImpl.DEFAULT_RULE_PRIORITY);
	}

	public final IPatternMatcher putDownRule(final int setSymbol, final boolean equalRule, final IExpr leftHandSide,
			final IExpr rightHandSide) {
		return putDownRule(IPatternMatcher.SET_DELAYED, false, leftHandSide, rightHandSide,
				IPatternMapImpl.DEFAULT_RULE_PRIORITY);
	}

	public final IPatternMatcher putDownRule(final int setSymbol, final boolean equalRule, final IExpr leftHandSide,
			final IExpr rightHandSide, final int priority) {
		if (equalRule || leftHandSide.isSymbol()) {
			fEqualDownRules = getEqualDownRules();
			PatternMatcherEquals pmEquals = new PatternMatcherEquals(setSymbol, leftHandSide, rightHandSide);
			fEqualDownRules.put(leftHandSide, pmEquals);
			return pmEquals;
		}

		final PatternMatcherAndEvaluator pmEvaluator;
		int patternHash = 0;
		if (!isComplicatedPatternRule(leftHandSide) && !leftHandSide.isCondition()) {
			patternHash = ((IAST) leftHandSide).patternHashCode();
		}
		if (leftHandSide.isAST(F.Integrate)) {
			pmEvaluator = new PatternMatcherAndEvaluator(setSymbol, leftHandSide, rightHandSide, false, patternHash);
			// keep Integrate rules in order predefined by Rubi project
			pmEvaluator.setLHSPriority(priority);

			if (fPatternDownRules == null) {
				fPatternDownRules = new ArrayList<IPatternMatcher>(7000);
				fPriorityDownRules = new IntArrayList(7000);
			}
			fPatternDownRules.add(pmEvaluator);
			fPriorityDownRules.add(priority);
			return pmEvaluator;
		} else {
			pmEvaluator = new PatternMatcherAndEvaluator(setSymbol, leftHandSide, rightHandSide, true, patternHash);
			if (pmEvaluator.isRuleWithoutPatterns()) {
				fEqualDownRules = getEqualDownRules();
				PatternMatcherEquals pmEquals = new PatternMatcherEquals(setSymbol, leftHandSide, rightHandSide);
				fEqualDownRules.put(leftHandSide, pmEquals);
				return pmEquals;
			}
		}

		if (IPatternMapImpl.DEFAULT_RULE_PRIORITY != priority) {
			pmEvaluator.setLHSPriority(priority);
		}

		return insertMatcher(pmEvaluator);
	}

	/**
	 * Insert a new (or replace an old equivalent) pattern matching rule in the rules data structure.
	 *
	 * @param newPatternMatcher
	 *            the new pattern matching rule
	 * @return
	 */
	public final PatternMatcher insertMatcher(final PatternMatcher newPatternMatcher) {
		if (fPatternDownRules == null) {
			fPatternDownRules = new ArrayList<IPatternMatcher>();
			fPriorityDownRules = new IntArrayList();
			fPatternDownRules.add(newPatternMatcher);
			fPriorityDownRules.add(newPatternMatcher.getLHSPriority());
			return newPatternMatcher;

		}

		final int size = fPatternDownRules.size();
		final int patternHash = newPatternMatcher.getPatternHash();
		final int lhsPriority = newPatternMatcher.getLHSPriority();
		IPatternMap pmSlotValuesMap = null;
		IExpr pmRHS = null;
		IExpr pmSlotValuesLHS = null;
		// TODO use a binary search in fPriorityDownRules to find the first equal getLHSPriority()
		for (int i = 0; i < size; i++) {
			final int priority = fPriorityDownRules.getInt(i);
			if (priority > lhsPriority) {
				fPatternDownRules.add(i, newPatternMatcher);
				fPriorityDownRules.add(i, lhsPriority);
				return newPatternMatcher;
		} else {
				if (priority == lhsPriority) {
					// There can be "multiple rules" with the same priority
					// Append the new rule matcher behind the last one or replace an existing equivalent rule matcher
					final IPatternMatcher matcher = fPatternDownRules.get(i);
					if (matcher.isPatternHashAllowed(patternHash)) {
						if (IPatternMatcher.EQUIVALENCE_COMPARATOR.compare(newPatternMatcher, matcher) == 0) {
							if (pmSlotValuesMap == null) {
								pmSlotValuesMap = newPatternMatcher.getPatternMap().clone();
								pmSlotValuesMap.initSlotValues();
								pmRHS = pmSlotValuesMap.substituteSymbols(newPatternMatcher.getRHS());
								pmSlotValuesLHS = pmSlotValuesMap.substitutePatternOrSymbols(newPatternMatcher.getLHS(),
										true);
							}
							if (equivalentSlots(matcher, pmSlotValuesMap.size(), pmSlotValuesLHS, pmRHS)) {
								fPatternDownRules.set(i, newPatternMatcher);
								fPriorityDownRules.set(i, lhsPriority);
								return newPatternMatcher;
							}
						}
					}
				}
			}
						}
		fPatternDownRules.add(newPatternMatcher);
		fPriorityDownRules.add(lhsPriority);
		return newPatternMatcher;
	}

	/**
	 * Test if the matchers are equivalent, comparing the LHS (and possibly RHS-condition), with named patterns replaced
	 * by slot values <code>#1, #2, #3,...</code>.
	 *
	 * @param matcher
	 *            the existing pattern matcher in the RulesData structure
	 * @param newNumberOfPatterns
	 *            the number of patterns which the new rule contains
	 * @param newSlotValuesLHS
	 *            the left-hand-side of the new rule with patterns replaced by slot values
	 * @param newSlotValuesRHS
	 *            the right-hand-side of the new rule with pattern symbols replaced by slot values
	 * @return <code>true</code> if the <code>matcher</code>'s LHS and RHS-condition are equivalent to the new matcher
	 *         parameters
	 */
	private static boolean equivalentSlots(IPatternMatcher matcher, int newNumberOfPatterns, IExpr newSlotValuesLHS,
			IExpr newSlotValuesRHS) {
		IPatternMap oldMap = matcher.getPatternMap();
		if (oldMap.size() != newNumberOfPatterns) {
			return false;
				}
		oldMap = oldMap.clone();
		oldMap.initSlotValues();
		IExpr oldSlotValuesLHS = oldMap.substitutePatternOrSymbols(matcher.getLHS(), true);
		if (oldSlotValuesLHS.equals(newSlotValuesLHS)) {
			IExpr rhs = matcher.getRHS();
			if (newSlotValuesRHS.isCondition() && rhs.isCondition()) {
				IExpr oldSlotValuesRHS = oldMap.substituteSymbols(rhs.second());
				return newSlotValuesRHS.second().equals(oldSlotValuesRHS);
			}
			return !(rhs.isCondition() || newSlotValuesRHS.isCondition());
		}
		return false;
		}

	public void putfDefaultValues(IExpr expr) {
		putfDefaultValues(DEFAULT_VALUE_INDEX, expr);
	}

	public void putfDefaultValues(int pos, IExpr expr) {
		if (this.fDefaultValues == null) {
			this.fDefaultValues = new OpenIntToIExprHashMap<IExpr>();
		}
		fDefaultValues.put(pos, expr);
	}

	public IPatternMatcher putUpRule(final int setSymbol, final boolean equalRule, final IAST leftHandSide,
			final IExpr rightHandSide) {
		if (equalRule) {
			fEqualUpRules = getEqualUpRules();
			PatternMatcherEquals pmEquals = new PatternMatcherEquals(setSymbol, leftHandSide, rightHandSide);
			fEqualUpRules.put(leftHandSide, pmEquals);
			return pmEquals;
		}

		final PatternMatcherAndEvaluator pmEvaluator = new PatternMatcherAndEvaluator(setSymbol, leftHandSide,
				rightHandSide);

		if (pmEvaluator.isRuleWithoutPatterns()) {
			fEqualUpRules = getEqualUpRules();
			PatternMatcherEquals pmEquals = new PatternMatcherEquals(setSymbol, leftHandSide, rightHandSide);
			fEqualUpRules.put(leftHandSide, pmEquals);
			return pmEquals;
		}

		fSimplePatternUpRules = getSimplePatternUpRules();
		return addSimplePatternUpRule(leftHandSide, pmEvaluator);

	}

	public boolean removeRule(final int setSymbol, final boolean equalRule, final IExpr leftHandSide) {
		if (equalRule) {
			if (fEqualDownRules != null) {
				return fEqualDownRules.remove(leftHandSide) != null;
			}
		}

		final PatternMatcherAndEvaluator pmEvaluator = new PatternMatcherAndEvaluator(setSymbol, leftHandSide, null);
		if (pmEvaluator.isRuleWithoutPatterns()) {
			if (fEqualDownRules != null) {
				return fEqualDownRules.remove(leftHandSide) != null;
			}
		}

			if (fPatternDownRules != null) {
			int i = 0;
			boolean evaled = false;
			while (i < fPatternDownRules.size()) {
				IPatternMatcher pm = fPatternDownRules.get(i);
				if (pm.equivalentLHS(pmEvaluator) == 0) {
					fPatternDownRules.remove(i);
					fPriorityDownRules.removeInt(i);
					evaled = true;
					continue;
				}
				i++;
			}
			return evaled;
		}
		return false;
	}

	@Override
	public String toString() {
		StringWriter buf = new StringWriter();
		List<IAST> list = definition();
		final int size = list.size();
		for (int i = 0; i < size; i++) {
			buf.append(list.get(i).toString());
			if (i < size - 1) {
				buf.append(",\n ");
			}
		}
		return buf.toString();
	}
}