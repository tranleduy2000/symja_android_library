package org.matheclipse.core.generic;

import com.duy.annotations.Nonnull;
import com.duy.lambda.Function;
import com.duy.lambda.Predicate;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.exception.ArgumentTypeException;
import org.matheclipse.core.eval.exception.WrongArgumentType;
import org.matheclipse.core.eval.util.OpenFixedSizeMap;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IASTAppendable;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.core.parser.ExprParser;
import org.matheclipse.core.patternmatching.IPatternMatcher;
import org.matheclipse.core.patternmatching.PatternMatcherAndEvaluator;
import org.matheclipse.core.patternmatching.PatternMatcherList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Functors {

	private static class SingleRuleFunctor implements Function<IExpr, IExpr> {
		private final IExpr lhs;
		private final IExpr rhs;

		/**
		 *
		 * @param plusAST
		 *            the complete AST which should be cloned in the {@code apply} method
		 * @param position
		 *            the position which should be replaced in the <code>apply()</code> method.
		 */
		public SingleRuleFunctor(IAST equalRule) {
			lhs = equalRule.arg1();
			rhs = equalRule.arg2();
		}

		@Override
		@Nonnull
		public IExpr apply(final IExpr arg) {
			return lhs.equals(arg) ? rhs : F.NIL;
		}

	}
	private static class RulesFunctor implements Function<IExpr, IExpr> {
		private final Map<? extends IExpr, ? extends IExpr> fEqualRules;

		public RulesFunctor(Map<? extends IExpr, ? extends IExpr> rulesMap) {
			fEqualRules = rulesMap;
		}

		@Override
		@Nonnull
		public IExpr apply(final IExpr arg) {
			IExpr temp = fEqualRules.get(arg);
			return temp != null ? temp : F.NIL;
		}

	}

	private static class RulesPatternFunctor implements Function<IExpr, IExpr> {
		private final Map<IExpr, IExpr> fEqualRules;
		private final List<PatternMatcherAndEvaluator> fMatchers;
		private final EvalEngine fEngine;

		public RulesPatternFunctor(Map<IExpr, IExpr> equalRules, List<PatternMatcherAndEvaluator> matchers,
				@Nonnull EvalEngine engine) {
			fEqualRules = equalRules;
			fMatchers = matchers;
			fEngine = engine;
		}

		@Override
		@Nonnull
		public IExpr apply(final IExpr arg) {
			IExpr temp = fEqualRules.get(arg);
			if (temp != null) {
				return temp;
			}
			for (int i = 0; i < fMatchers.size(); i++) {
				temp = fMatchers.get(i).replace(arg, fEngine, false);
				if (temp.isPresent()) {
					return temp;
				}
			}
			return F.NIL;
		}
	}

	private static class ListRulesPatternFunctor implements Function<IExpr, IExpr> {
		private final Map<IExpr, IExpr> fEqualRules;
		private final List<PatternMatcherList> fMatchers;
		private final EvalEngine fEngine;
		private IASTAppendable fResult;

		/**
		 *
		 * @param plusAST
		 *            the complete AST which should be cloned in the {@code apply} method
		 * @param position
		 *            the position which should be replaced in the <code>apply()</code> method.
		 */
		public ListRulesPatternFunctor(Map<IExpr, IExpr> equalRules, List<PatternMatcherList> matchers,
				IASTAppendable result, @Nonnull EvalEngine engine) {
			fEqualRules = equalRules;
			fMatchers = matchers;
			fResult = result;
			fEngine = engine;
		}

		public ListRulesPatternFunctor(Map<IExpr, IExpr> rulesMap, IASTAppendable result) {
			fEqualRules = rulesMap;
			fResult = result;
			fMatchers = null;
			fEngine = null;
		}

		@Override
		@Nonnull
		public IExpr apply(final IExpr arg) {
			IExpr temp = fEqualRules.get(arg);
			if (temp != null) {
				fResult.append(temp);
				return temp;
			}
			if (fMatchers != null) {
				for (int i = 0; i < fMatchers.size(); i++) {
					PatternMatcherList matcher = fMatchers.get(i);
					if (matcher != null) {
						matcher.replace(arg, fEngine, false);
						IAST list = matcher.getReplaceList();
						if (list.size() > 1) {
							for (int j = 1; j < list.size(); j++) {
								fResult.append(list.get(j));
							}
							return list;
						}
					}
				}
			}
			return F.NIL;
		}
	}

	/**
	 * Create a functor from the given map, which calls the <code>rulesMap.get()</code> in the functors
	 * <code>apply</code>method.
	 * 
	 * @param rulesMap
	 * @return
	 */
	public static Function<IExpr, IExpr> rules(Map<? extends IExpr, ? extends IExpr> rulesMap) {
		return new RulesFunctor(rulesMap);
	}

	/**
	 * Create a functor from the given rule <code>lhs->rhs</code> or <code>lhs:>rhs</code> and match the left-hand-side
	 * argument with the <code>#equals()</code> method. Therefore the left-hand-side shouldn't contain any pattern or
	 * orderless expression.
	 *
	 * @param rulesMap
	 * @return
	 */
	public static Function<IExpr, IExpr> equalRule(IAST rule) {
		return new SingleRuleFunctor(rule);
	}
	/**
	 * Create a functor from the given rules. All strings in <code>strRules</code> are parsed in internal rules form.
	 * 
	 * @param strRules
	 *            array of rules of the form &quot;<code>x-&gt;y</code>&quot;
	 * @return
	 */
	public static Function<IExpr, IExpr> rules(@Nonnull String[] strRules) {
		IASTAppendable astRules = F.ListAlloc(strRules.length);
		final EvalEngine engine = EvalEngine.get();
		ExprParser parser = new ExprParser(engine);
		for (String str : strRules) {
			IExpr expr = parser.parse(str);
			expr = engine.evaluate(expr);
			astRules.append(expr);
		}
		return rules(astRules, engine);
	}

	/**
	 * Create a functor from the given rules. If <code>astRules</code> is a <code>List[]</code> object, the elements of
	 * the list are taken as the rules of the form <code>Rule[lhs, rhs]</code>, otherwise the <code>astRules</code>
	 * itself is taken as the <code>Rule[lhs, rhs]</code>.
	 * 
	 * @param astRules
	 * @return
	 */
	public static Function<IExpr, IExpr> rules(@Nonnull IAST astRules, @Nonnull EvalEngine engine)
			 {
		final Map<IExpr, IExpr> equalRules;

		IAST rule;
		List<PatternMatcherAndEvaluator> matchers = new ArrayList<PatternMatcherAndEvaluator>();
		if (astRules.isList()) {
			if (astRules.size() > 1) {
			// assuming multiple rules in a list
			int argsSize = astRules.argSize();
			if (argsSize <= 5) {
				equalRules = new OpenFixedSizeMap<IExpr, IExpr>(argsSize * 3 - 1);
			} else {
				equalRules = new HashMap<IExpr, IExpr>();
			}

			for (final IExpr expr : astRules) {
				if (expr.isRuleAST()) {
					rule = (IAST) expr;
					addRuleToCollection(equalRules, matchers, rule);
				} else {
						throw new ArgumentTypeException("rule expression (x->y) expected instead of "+expr.toString());
				}
			}
				if (matchers.size() > 0) {
					return new RulesPatternFunctor(equalRules, matchers, engine);
				}
				if (argsSize == 1) {
					return equalRule((IAST) astRules.arg1());
				}
				return rules(equalRules);
			}
				equalRules = new HashMap<IExpr, IExpr>();
			return rules(equalRules);
		} else {
			if (astRules.isRuleAST()) {
				rule = astRules;
				equalRules = new OpenFixedSizeMap<IExpr, IExpr>(3);
				addRuleToCollection(equalRules, matchers, rule);
			} else {
				throw new ArgumentTypeException("rule expression (x->y) expected instead of "+astRules.toString());
			}
		if (matchers.size() > 0) {
			return new RulesPatternFunctor(equalRules, matchers, engine);
		}
			return equalRule(rule);
		}
	}

	public static Function<IExpr, IExpr> listRules(@Nonnull IAST astRules, IASTAppendable result,
			@Nonnull EvalEngine engine)  {
		final Map<IExpr, IExpr> equalRules;
		List<PatternMatcherList> matchers = new ArrayList<PatternMatcherList>();
		if (astRules.isList()) {
			if (astRules.size() > 1) {
				// assuming multiple rules in a list
				IAST rule;
				int argsSize = astRules.argSize();
				if (argsSize <= 5) {
					equalRules = new OpenFixedSizeMap<IExpr, IExpr>(argsSize * 3 - 1);
				} else {
					equalRules = new HashMap<IExpr, IExpr>();
				}

				for (final IExpr expr : astRules) {
					if (expr.isRuleAST()) {
						rule = (IAST) expr;
						createPatternMatcherList(equalRules, matchers, rule);
					} else {
						throw new ArgumentTypeException("rule expression (x->y) expected instead of "+expr.toString());
					}
				}
			} else {
				equalRules = new HashMap<IExpr, IExpr>();
			}
		} else {
			if (astRules.isRuleAST()) {
				equalRules = new OpenFixedSizeMap<IExpr, IExpr>(3);
				createPatternMatcherList(equalRules, matchers, astRules);
			} else {
				throw new ArgumentTypeException("rule expression (x->y) expected instead of "+astRules.toString());
			}
		}
		if (matchers.size() > 0) {
			return new ListRulesPatternFunctor(equalRules, matchers, result, engine);
		}
		return listRules(equalRules, result);
	}

	public static Function<IExpr, IExpr> listRules(Map<IExpr, IExpr> rulesMap, IASTAppendable result) {
		return new ListRulesPatternFunctor(rulesMap, result);
	}

	/**
	 * A predicate to determine if an expression is an instance of <code>IPattern</code> or
	 * <code>IPatternSequence</code>.
	 */
	private static Predicate<IExpr> PATTERNQ_PREDICATE = new Predicate<IExpr>() {
		@Override
		public boolean test(IExpr input) {
			return input.isBlank() || input.isPattern() || input.isPatternSequence(false) || input.isAlternatives()
					|| input.isExcept();
		}
	};

	private static void addRuleToCollection(Map<IExpr, IExpr> equalRules, List<PatternMatcherAndEvaluator> matchers,
			IAST rule) {
		if (rule.arg1().isFree(PATTERNQ_PREDICATE, true)) {
			IExpr temp = equalRules.get(rule.arg1());
			if (temp == null) {
				if (rule.arg1().isOrderlessAST() || rule.arg1().isFlatAST()) {
					if (rule.isRuleDelayed()) {
						matchers.add(
								new PatternMatcherAndEvaluator(IPatternMatcher.SET_DELAYED, rule.arg1(), rule.arg2()));
					} else {
						matchers.add(new PatternMatcherAndEvaluator(IPatternMatcher.SET, rule.arg1(),
								evalOneIdentity(rule.arg2())));
					}
					return;
				}
				equalRules.put(rule.arg1(), rule.arg2());
			}
		} else {
			if (rule.isRuleDelayed()) {
				matchers.add(new PatternMatcherAndEvaluator(IPatternMatcher.SET_DELAYED, rule.arg1(), rule.arg2()));
			} else {
				matchers.add(new PatternMatcherAndEvaluator(IPatternMatcher.SET, rule.arg1(),
						evalOneIdentity(rule.arg2())));
			}
		}
	}

	private static void createPatternMatcherList(Map<IExpr, IExpr> equalRules, List<PatternMatcherList> matchers,
			IAST rule) {
		if (rule.arg1().isFree(PATTERNQ_PREDICATE, true)) {
			IExpr temp = equalRules.get(rule.arg1());
			if (temp == null) {
				if (rule.arg1().isOrderlessAST() || rule.arg1().isFlatAST()) {
					if (rule.isRuleDelayed()) {
						matchers.add(new PatternMatcherList(IPatternMatcher.SET_DELAYED, rule.arg1(), rule.arg2()));
					} else {
						matchers.add(new PatternMatcherList(IPatternMatcher.SET, rule.arg1(),
								evalOneIdentity(rule.arg2())));
					}
					return;
				}
				equalRules.put(rule.arg1(), rule.arg2());
			}
		} else {
			if (rule.isRuleDelayed()) {
				matchers.add(new PatternMatcherList(IPatternMatcher.SET_DELAYED, rule.arg1(), rule.arg2()));
			} else {
				matchers.add(new PatternMatcherList(IPatternMatcher.SET, rule.arg1(), evalOneIdentity(rule.arg2())));
			}
		}
	}

	/**
	 * Test if <code>expr</code> is an <code>IAST</code> with one argument and the head symbol contains the
	 * <code>OneIdentity</code> attribute.
	 * 
	 * @param expr
	 * @return
	 */
	private static IExpr evalOneIdentity(IExpr expr) {
		if (expr.isAST()) {
			IAST arg2AST = (IAST) expr;
			if (arg2AST.isAST1() && arg2AST.head().isSymbol()) {
				final int attr = ((ISymbol) arg2AST.head()).getAttributes();
				if ((ISymbol.ONEIDENTITY & attr) == ISymbol.ONEIDENTITY) {
					expr = arg2AST.arg1();
				}
			}
		}
		return expr;
	}

	private Functors() {

	}
}
