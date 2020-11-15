package org.matheclipse.core.builtin;

import com.duy.lambda.BiFunction;
import com.duy.lambda.Function;
import com.duy.lambda.Predicate;
import com.duy.lambda.Supplier;
import com.duy.util.MapWrapper;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.exception.ArgumentTypeException;
import org.matheclipse.core.eval.exception.Validate;
import org.matheclipse.core.eval.exception.ValidateException;
import org.matheclipse.core.eval.interfaces.AbstractCoreFunctionEvaluator;
import org.matheclipse.core.eval.interfaces.AbstractEvaluator;
import org.matheclipse.core.eval.interfaces.ICoreFunctionEvaluator;
import org.matheclipse.core.eval.interfaces.ISetEvaluator;
import org.matheclipse.core.expression.ASTAssociation;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.expression.S;
import org.matheclipse.core.generic.Predicates;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IASTAppendable;
import org.matheclipse.core.interfaces.IASTMutable;
import org.matheclipse.core.interfaces.IAssociation;
import org.matheclipse.core.interfaces.IBuiltInSymbol;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.IStringX;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.parser.client.FEConfig;

import java.util.HashMap;
import java.util.Map;

public class AssociationFunctions {
	private final static class MutableInt {
		int value;

		public MutableInt(int value) {
			this.value = value;
		}

		public MutableInt increment() {
			value++;
			return this;
		}

		public int value() {
			return value;
		}
	}

	/**
	 *
	 * See <a href="https://pangin.pro/posts/computation-in-static-initializer">Beware of computation in static
	 * initializer</a>
	 */
	private static class Initializer {

		private static void init() {
			F.AssociateTo.setEvaluator(new AssociateTo());
			F.Association.setEvaluator(new Association());
			F.AssociationMap.setEvaluator(new AssociationMap());
			F.AssociationThread.setEvaluator(new AssociationThread());
			F.Counts.setEvaluator(new Counts());
			F.KeyExistsQ.setEvaluator(new KeyExistsQ());
			F.Keys.setEvaluator(new Keys());
			F.KeySort.setEvaluator(new KeySort());
			F.KeyTake.setEvaluator(new KeyTake());
			F.LetterCounts.setEvaluator(new LetterCounts());
			F.Lookup.setEvaluator(new Lookup());
			F.Structure.setEvaluator(new Structure());
			F.Summary.setEvaluator(new Summary());
			F.Values.setEvaluator(new Values());
		}
	}

	private final static class AssociateTo extends AbstractCoreFunctionEvaluator {

		private static class AssociateToFunction implements Function<IExpr, IExpr> {
			private final IExpr value;

			public AssociateToFunction(final IExpr value) {
				this.value = value;
			}

			@Override
			public IExpr apply(final IExpr symbolValue) {
				if (symbolValue.isAssociation()) {
					if (value.isRuleAST() || value.isListOfRules() || value.isAssociation()) {
						IAssociation result = ((IAssociation) symbolValue);// .copy();
						result.appendRules((IAST) value);
						return result;
					} else {
						// The argument is not a rule or a list of rules.
						return IOFunctions.printMessage(F.AssociateTo, "invdt", F.List(), EvalEngine.get());
					}
				}
				return F.NIL;
			}

		}

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			IExpr sym = Validate.checkSymbolType(ast, 1, engine);
			if (sym.isPresent()) {
				IExpr arg2 = engine.evaluate(ast.arg2());
				Function<IExpr, IExpr> function = new AssociateToFunction(arg2);
				IExpr[] results = ((ISymbol) sym).reassignSymbolValue(function, F.AssociateTo, engine);
				if (results != null) {
					return results[1];
				}
			}
			return F.NIL;
		}

		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_2_2;
		}

		@Override
		public void setUp(final ISymbol newSymbol) {
			newSymbol.setAttributes(ISymbol.HOLDFIRST);
		}
	}

	private static class Association extends AbstractEvaluator implements ISetEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			if (ast.isAssociation()) {
				return F.NIL;
			}
			if (ast.isAST0()) {
				return F.assoc(F.List());
			} else if (ast.size() > 1) {
				try {

					// IExpr arg1 = engine.evaluate(ast.arg1());
					IAssociation assoc = F.assoc(F.CEmptyList);
					for (int i = 1; i < ast.size(); i++) {
						if (ast.get(i).isAST()) {
							assoc.appendRules((IAST) ast.get(i));
						} else {
							throw new ArgumentTypeException(
									"rule expression expected instead of " + ast.get(i).toString());
						}
					}

					return assoc;
				} catch (ValidateException ve) {
					if (FEConfig.SHOW_STACKTRACE) {
						ve.printStackTrace();
					}
					// print no message
				}
			}
			return F.NIL;
		}


		@Override
		public void setUp(final ISymbol newSymbol) {
			newSymbol.setAttributes(ISymbol.HOLDALLCOMPLETE);
		}

		public IExpr evaluateSet(final IExpr leftHandSide, IExpr rightHandSide, IBuiltInSymbol builtinSymbol,
				EvalEngine engine) {
			if (leftHandSide.head().isSymbol()) {
				ISymbol symbol = (ISymbol) leftHandSide.head();

				IExpr temp = symbol.assignedValue();
				if (temp == null) {
					// `1` is not a variable with a value, so its value cannot be changed.
					return IOFunctions.printMessage(builtinSymbol, "rvalue", F.List(symbol), engine);
				} else {
					if (symbol.isProtected()) {
						// Symbol `1` is Protected.
						return IOFunctions.printMessage(builtinSymbol, "wrsym", F.List(symbol), EvalEngine.get());
					}
					try {
						IExpr lhsHead = engine.evaluate(symbol);
						if (lhsHead.isAssociation()) {
							IAssociation assoc = ((IAssociation) lhsHead);
							assoc = assoc.copy();
							assoc.appendRule(F.Rule(((IAST) leftHandSide).arg1(), rightHandSide));
							symbol.assignValue(assoc);
							return rightHandSide;
						}
					} catch (ValidateException ve) {
						return engine.printMessage(builtinSymbol, ve);
						// } catch (RuntimeException rex) {
						// if (FEConfig.SHOW_STACKTRACE) {
						// rex.printStackTrace();
						// }
						// return engine.printMessage(F.Set, rex);
						}
					}
				}
			IOFunctions.printMessage(builtinSymbol, "setps", F.List(leftHandSide.head()), engine);
			return rightHandSide;
			}
	}
	private static class AssociationMap extends AbstractEvaluator {

		@Override
		public IExpr evaluate(IAST ast, EvalEngine engine) {
			if (ast.isAST1()) {
				ast = F.operatorFormPrepend(ast);
				if (!ast.isPresent()) {
					return F.NIL;
				}
			}
			IExpr arg1 = ast.arg1();
			if (ast.isAST2()) {
				IExpr arg2 = ast.arg2();
				return associationMap(F.Rule, arg1, arg2, engine);
			}
			return F.NIL;
		}

		private static IExpr associationMap(ISymbol symbol, IExpr arg1, IExpr arg2, EvalEngine engine) {
			if (arg2.isList()) {
				IAST list2 = (IAST) arg2;
				IAssociation result = F.assoc(list2.size());
				for (int i = 1; i < list2.size(); i++) {
					IExpr function = engine.evaluate(F.unaryAST1(arg1, list2.get(i)));
					result.append(F.binaryAST2(symbol, list2.get(i), function));
				}
				return result;
			}
			if (arg2.isAssociation()) {
				IAssociation list2 = (IAssociation) arg2;
				IASTAppendable result = F.ast(F.Association, list2.size(), false);
				for (int i = 1; i < list2.size(); i++) {
					IExpr function = engine.evaluate(F.unaryAST1(arg1, list2.getRule(i)));
					result.appendRule(function);
				}
				return result;
			}
			return F.NIL;
		}
		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_1_2;
		}
	}

	private static class AssociationThread extends AbstractEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			IExpr arg1 = ast.arg1();
			if (ast.isAST2()) {
				IExpr arg2 = ast.arg2();
				return associationThread(F.Rule, arg1, arg2);
			}
			if (arg1.isRuleAST()) {
				IAST rule = (IAST) arg1;

				return associationThread((ISymbol) rule.head(), rule.arg1(), rule.arg2());
			}
			return F.NIL;
		}

		private static IExpr associationThread(ISymbol symbol, IExpr arg1, IExpr arg2) {
			if (arg1.isList() && arg2.isList()) {
				if (arg1.size() == arg2.size()) {
					IAST list1 = (IAST) arg1;
					IAST list2 = (IAST) arg2;
					IASTAppendable listOfRules = F.ListAlloc(arg1.size());
					for (int i = 1; i < list1.size(); i++) {
						listOfRules.append(F.binaryAST2(symbol, list1.get(i), list2.get(i)));
					}
					return F.assoc(listOfRules);
				}
			}
			return F.NIL;
		}

		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_1_2;
		}
	}

	private static class Counts extends AbstractEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			IExpr arg1 = ast.arg1();
			if (arg1.isList()) {
				IAST list = (IAST) arg1;
				try {
					HashMap<IExpr, MutableInt> map = new HashMap<IExpr, MutableInt>();
					for (int i = 1; i < list.size(); i++) {
						IExpr key = list.get(i);
						new MapWrapper<>(map).compute(key, new BiFunction<IExpr, MutableInt, MutableInt>() {
                            @Override
                            public MutableInt apply(IExpr k, MutableInt v) {
                                return (v == null) ? new MutableInt(1) : v.increment();
                            }
                        });
					}
					IAssociation assoc = new ASTAssociation(map.size(), false);
					for (Map.Entry<IExpr, AssociationFunctions.MutableInt> elem : map.entrySet()) {
						assoc.appendRule(F.Rule(elem.getKey(), F.ZZ(elem.getValue().value())));
					}
					return assoc;
				} catch (ValidateException ve) {
					return engine.printMessage(ast.topHead(), ve);
				}
			}
			return F.NIL;
		}

		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_1_1;
		}
	}

	private static class KeyExistsQ extends AbstractEvaluator {

		@Override
		public IExpr evaluate(IAST ast, EvalEngine engine) {
			if (ast.isAST1()) {
				ast = F.operatorFormPrepend(ast);
				if (!ast.isPresent()) {
					return F.NIL;
				}
			}
			if (ast.isAST2()) {
				IExpr arg1 = ast.arg1();
				IExpr arg2 = ast.arg2();
				if (arg1.isAssociation()) {
					return ((IAssociation) arg1).isKey(arg2) ? F.True : F.False;
				}
				if (arg1.isListOfRules(true)) {
					IAST listOfRules = (IAST) arg1;
					for (int i = 1; i < listOfRules.size(); i++) {
						IExpr rule = listOfRules.get(i);
						if (rule.isRuleAST()) {
							if (arg2.equals(rule.first())) {
								return F.True;
							}
						}
					}
				}
				return F.False;
			}
			return F.NIL;
		}

		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_1_2;
		}
	}

	private static class Keys extends AbstractEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			IExpr arg1 = ast.arg1();
			final IExpr head = ast.isAST2() ? ast.arg2() : F.NIL;
			if (arg1.isAssociation()) {
				IASTMutable list = ((IAssociation) arg1).keys();
				return mapHeadIfPresent(list, head);
			}
			// swift changed: unsupported feature
			/*else if (arg1.isDataSet()) {
				return ((IASTDataset) arg1).columnNames();
			}*/ else if (arg1.isRuleAST()) {
				if (head.isPresent()) {
					return F.unaryAST1(head, arg1.first());
			}
				return arg1.first();
			} else if (arg1.isList()) {
				if (arg1.isListOfRules(true)) {
					IAST listOfRules = (IAST) arg1;
					IASTAppendable list = F.ast(F.List, listOfRules.argSize(), false);
					for (int i = 1; i < listOfRules.size(); i++) {
						IExpr rule = listOfRules.get(i);
						if (rule.isRuleAST()) {
							list.append(rule.first());
						} else if (rule.isEmptyList()) {
							list.append(rule);
						} else {
							// The argument `1` is not a vaild Association or list of rules.
							throw new ArgumentTypeException(IOFunctions.getMessage("invrl", F.List(rule)));
						}
					}
					return mapHeadIfPresent(list, head);
				}

				// thread over Lists in first argument
				return ((IAST) arg1).mapThread(ast.setAtCopy(1, F.Slot1), 1);
			}
			return F.NIL;
		}

		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_1_2;
		}
	}

	private static class KeySort extends AbstractEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			if (ast.arg1().isAST()) {
				IAST arg1 = (IAST) ast.arg1();
				if (arg1.isAssociation()) {
					if (ast.isAST2()) {
						return ((IAssociation) arg1).keySort(new Predicates.IsBinaryFalse(ast.arg2()));
					}
					return ((IAssociation) arg1).keySort();
				}
			}

			return F.NIL;
		}

		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_1_2;
		}
	}

	private static class LetterCounts extends AbstractEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			IExpr arg1 = ast.arg1();
			if (arg1.isString()) {
				String str = ((IStringX) arg1).toString();
				try {
					HashMap<Character, MutableInt> map = new HashMap<Character, MutableInt>();
					for (int i = 0; i < str.length(); i++) {
						new MapWrapper<>(map).compute(str.charAt(i), //
								new BiFunction<Character, MutableInt, MutableInt>() {
									@Override
									public MutableInt apply(Character k, MutableInt v) {
										return (v == null) ? new MutableInt(1) : v.increment();
									}
								});
					}
					IAssociation assoc = new ASTAssociation(map.size(), false);
					for (Map.Entry<Character, AssociationFunctions.MutableInt> elem : map.entrySet()) {
						assoc.appendRule(F.Rule(F.$str(elem.getKey()), F.ZZ(elem.getValue().value())));
					}
					return assoc;
				} catch (ValidateException ve) {
					return engine.printMessage(ast.topHead(), ve);
				}
			}
			return F.NIL;
		}

		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_1_1;
		}
	}

	private static class Lookup extends AbstractEvaluator implements ICoreFunctionEvaluator {

		@Override
		public IExpr evaluate(IAST ast, final EvalEngine engine) {
			if (ast.isAST1()) {
				ast = F.operatorFormAppend(ast);
				if (!ast.isPresent()) {
					return F.NIL;
				}
			}
			IExpr arg1 = engine.evaluate(ast.arg1());
			if (arg1.isList()) {
				if (ast.size() > 2) {
					if (arg1.isListOfRules(true)) {
						IExpr key = engine.evaluate(ast.arg2());
						if (key.isList()) {
							return ((IAST) key).mapThread(ast, 2);
						}
						if (key.isAST(F.Key, 2)) {
							key = key.first();
						}
						IAST listOfRules = (IAST) arg1;
						for (int i = 1; i < listOfRules.size(); i++) {
							IExpr rule = listOfRules.get(i);
							if (rule.isRuleAST()) {
								if (rule.first().equals(key)) {
									return rule.second();
								}
							}
						}
						if (ast.isAST3()) {
							return engine.evaluate(ast.arg3());
						}
						return F.Missing(F.stringx("KeyAbsent"), key);
					}
				}
				return ((IAST) arg1).mapThread(ast, 1);
			} else if (arg1.isAssociation()) {
				if (ast.isAST2()) {
					IExpr key = engine.evaluate(ast.arg2());
					if (key.isList()) {
						return ((IAST) key).mapThread(ast, 2);
					}
					if (key.isAST(F.Key, 2)) {
						key = key.first();
					}
					return ((IAssociation) arg1).getValue(key);
				}
				if (ast.isAST3()) {
					IExpr key = engine.evaluate(ast.arg2());
					if (key.isList()) {
						return ((IAST) key).mapThread(ast, 2);
					}
					if (key.isAST(F.Key, 2)) {
						key = key.first();
					}
					final IExpr arg3 = ast.arg3();
					return ((IAssociation) arg1).getValue(key, new Supplier<IExpr>() {
						@Override
						public IExpr get() {
							return engine.evaluate(arg3);
						}
					});
						}
			} else {
				// The argument `1` is not a valid Association or list of rules.
				return IOFunctions.printMessage(ast.topHead(), "invrl", F.List(), engine);
			}
			return F.NIL;
		}

		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_1_3;
		}

		@Override
		public void setUp(final ISymbol newSymbol) {
			newSymbol.setAttributes(ISymbol.HOLDALLCOMPLETE);
		}
	}

	private static class Structure extends AbstractEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			IExpr arg1 = ast.arg1();
			// swift changed: unsupported feature.
//			if (arg1.isDataSet()) {
//				ASTDataset dataset = (ASTDataset) arg1;
//				return dataset.structure();
//			}
			return F.NIL;
		}

		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_1_1;
		}
	}

	private final static class KeyTake extends AbstractCoreFunctionEvaluator {

		@Override
		public IExpr evaluate(IAST ast, EvalEngine engine) {
			if (ast.isAST1()) {
				ast = F.operatorFormAppend(ast);
				if (!ast.isPresent()) {
					return F.NIL;
				}
			}
			IAST evaledAST = (IAST) engine.evalAttributes(F.KeyTake, ast);
			if (!evaledAST.isPresent()) {
				evaledAST = ast;
			}
			try {
				if (evaledAST.arg1().isListOfRulesOrAssociation(true) || evaledAST.arg1().isListOfLists()) {
					final IAST arg1 = (IAST) evaledAST.arg1();
					if (arg1.forAll(new Predicate<IExpr>() {
						@Override
						public boolean test(IExpr x) {
							return x.isListOfRulesOrAssociation(true);
						}
					})) {
						return arg1.mapThread(ast, 1);
					}
					IExpr arg2 = evaledAST.arg2();
					if (!arg2.isList()) {
						arg2 = F.List(arg2);
					}
					return keyTake(arg1, (IAST) arg2);
				} else {
					return engine.printMessage("KeyTake: Association or list of rules expected at position 1.");
				}
			} catch (final ValidateException ve) {
				return engine.printMessage(ast.topHead(), ve);
			} catch (final RuntimeException rex) {
				if (FEConfig.SHOW_STACKTRACE) {
					rex.printStackTrace();
				}
			}

			return F.NIL;
		}

		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_1_2;
		}

		private static IAST keyTake(final IAST expr, final IAST list) {
			final int size = list.size();
			// final IASTAppendable assoc = F.assoc(expr);
			final IASTAppendable resultAssoc = F.assoc(10 > size ? size : 10);
			for (int i = 1; i < size; i++) {
				IExpr rule = expr.getRule(list.get(i));
				if (rule.isPresent()) {
					resultAssoc.appendRule(rule);
				}
			}
			return resultAssoc;
		}

		@Override
		public void setUp(final ISymbol newSymbol) {
			newSymbol.setAttributes(ISymbol.NHOLDREST);
		}
	}
	private static class Summary extends AbstractEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			IExpr arg1 = ast.arg1();
			// swift changed: unsupported feature.
//			if (arg1.isDataSet()) {
//				ASTDataset dataset = (ASTDataset) arg1;
//				return dataset.summary();
//			}
			return F.NIL;
		}

		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_1_1;
		}
	}
	private static class Values extends AbstractEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			IExpr arg1 = ast.arg1();
			final IExpr head = ast.isAST2() ? ast.arg2() : F.NIL;
			if (arg1.isAssociation()) {
				IASTMutable list = ((IAssociation) arg1).values();
				return mapHeadIfPresent(list, head);
			} else if (arg1.isRuleAST()) {
				if (head.isPresent()) {
					return F.unaryAST1(head, arg1.second());
			}
				return arg1.second();
			} else if (arg1.isList()) {
				if (arg1.isListOfRules(true)) {
					IAST listOfRules = (IAST) arg1;
					IASTAppendable list = F.ast(F.List, listOfRules.argSize(), false);
					for (int i = 1; i < listOfRules.size(); i++) {
						IExpr rule = listOfRules.get(i);
						if (rule.isRuleAST()) {
							list.append(rule.second());
						} else if (rule.isEmptyList()) {
							list.append(rule);
						}
					}
					return mapHeadIfPresent(list, head);
				}

				// thread over Lists in first argument
				return ((IAST) arg1).mapThread(ast.setAtCopy(1, F.Slot1), 1);
			}
			return F.NIL;
		}

		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_1_2;
		}
	}

	/**
	 * If <code>head.isPresent()</code> map the <code>head</code> on each argument of list. Otherwise return
	 * <code>list</code>.
	 *
	 * @param list
	 * @param head
	 * @return
	 */
	private static IExpr mapHeadIfPresent(IASTMutable list, final IExpr head) {
		if (head.isPresent()) {
			return list.mapThread(new Function<IExpr, IExpr>() {
				@Override
				public IExpr apply(IExpr x) {
					return F.unaryAST1(head, x);
				}
			});
		}
		return list;
	}

	public static void initialize() {
		Initializer.init();
	}

	private AssociationFunctions() {

	}
}
