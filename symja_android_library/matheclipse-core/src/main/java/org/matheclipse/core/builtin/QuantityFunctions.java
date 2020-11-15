package org.matheclipse.core.builtin;

import com.duy.lambda.UnaryOperator;

import org.matheclipse.core.basic.ToggleFeature;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.interfaces.AbstractCoreFunctionEvaluator;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.expression.S;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.parser.client.FEConfig;

import org.matheclipse.core.tensor.qty.IQuantity;
import org.matheclipse.core.tensor.qty.IQuantityStatic;
import org.matheclipse.core.tensor.qty.IUnit;
import org.matheclipse.core.tensor.qty.IUnitStatic;
import org.matheclipse.core.tensor.qty.UnitSystemStatic;

public class QuantityFunctions {
//	final static HashMap<String, Function<LocalDateTime, IExpr>> DATEVALUE_MAP = new HashMap<String, Function<LocalDateTime, IExpr>>();

	/**
	 *
	 * See <a href="https://pangin.pro/posts/computation-in-static-initializer">Beware of computation in static
	 * initializer</a>
	 */
	private static class Initializer {

		private static void init() {
//			F.DateObject.setEvaluator(new DateObject());
//			F.DateValue.setEvaluator(new DateValue());
//
//			F.TimeObject.setEvaluator(new TimeObject());
			if (ToggleFeature.QUANTITY) {
				F.Quantity.setEvaluator(new Quantity());
				F.QuantityMagnitude.setEvaluator(new QuantityMagnitude());
				F.UnitConvert.setEvaluator(new UnitConvert());
			}

			// integers
//			DATEVALUE_MAP.put("Year", new Function<LocalDateTime, IExpr>() {
//				@Override
//				public IExpr apply(LocalDateTime x) {
//					return F.ZZ(x.getYear());
//				}
//			});
//			DATEVALUE_MAP.put("ISOYearDay", new Function<LocalDateTime, IExpr>() {
//				@Override
//				public IExpr apply(LocalDateTime x) {
//					return F.ZZ(x.getDayOfYear());
//				}
//			});
//			DATEVALUE_MAP.put("ISOYearDayShort", new Function<LocalDateTime, IExpr>() {
//				@Override
//				public IExpr apply(LocalDateTime x) {
//					return F.ZZ(x.getDayOfYear());
//				}
//			});
//			DATEVALUE_MAP.put("Month", new Function<LocalDateTime, IExpr>() {
//				@Override
//				public IExpr apply(LocalDateTime x) {
//					return F.ZZ(x.getMonthValue());
//				}
//			});
//			DATEVALUE_MAP.put("MonthShort", new Function<LocalDateTime, IExpr>() {
//				@Override
//				public IExpr apply(LocalDateTime x) {
//					return F.ZZ(x.getMonthValue());
//				}
//			});
//			DATEVALUE_MAP.put("Day", new Function<LocalDateTime, IExpr>() {
//				@Override
//				public IExpr apply(LocalDateTime x) {
//					return F.ZZ(x.getDayOfMonth());
//				}
//			});
//
//			DATEVALUE_MAP.put("Hour", new Function<LocalDateTime, IExpr>() {
//				@Override
//				public IExpr apply(LocalDateTime x) {
//					return F.ZZ(x.getHour());
//				}
//			});
//			DATEVALUE_MAP.put("HourShort", new Function<LocalDateTime, IExpr>() {
//				@Override
//				public IExpr apply(LocalDateTime x) {
//					return F.ZZ(x.getHour());
//				}
//			});
//			DATEVALUE_MAP.put("Minute", new Function<LocalDateTime, IExpr>() {
//				@Override
//				public IExpr apply(LocalDateTime x) {
//					return F.ZZ(x.getMinute());
//				}
//			});
//			DATEVALUE_MAP.put("MinuteShort", new Function<LocalDateTime, IExpr>() {
//				@Override
//				public IExpr apply(LocalDateTime x) {
//					return F.ZZ(x.getMinute());
//				}
//			});
//			DATEVALUE_MAP.put("Second", new Function<LocalDateTime, IExpr>() {
//				@Override
//				public IExpr apply(LocalDateTime x) {
//					return F.ZZ(x.getSecond());
//				}
//			});
//			DATEVALUE_MAP.put("SecondShort", new Function<LocalDateTime, IExpr>() {
//				@Override
//				public IExpr apply(LocalDateTime x) {
//					return F.ZZ(x.getSecond());
//				}
//			});
//
//			// strings
//			DATEVALUE_MAP.put("MonthName", new Function<LocalDateTime, IExpr>() {
//				@Override
//				public IExpr apply(LocalDateTime x) {
//					return F.stringx(x.getMonth().getDisplayName(TextStyle.FULL, Locale.US));
//				}
//			});
//			DATEVALUE_MAP.put("MonthNameShort",
//					new Function<LocalDateTime, IExpr>() {
//						@Override
//						public IExpr apply(LocalDateTime x) {
//							return F.stringx(x.getMonth().getDisplayName(TextStyle.SHORT, Locale.US));
//						}
//					});
//			DATEVALUE_MAP.put("MonthNameInitial",
//					new Function<LocalDateTime, IExpr>() {
//						@Override
//						public IExpr apply(LocalDateTime x) {
//							return F.stringx(x.getMonth().getDisplayName(TextStyle.NARROW, Locale.US));
//						}
//					});
//
//			DATEVALUE_MAP.put("DayName", new Function<LocalDateTime, IExpr>() {
//				@Override
//				public IExpr apply(LocalDateTime x) {
//					return F.stringx(x.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.US));
//				}
//			});
//			DATEVALUE_MAP.put("DayNameShort",
//					new Function<LocalDateTime, IExpr>() {
//						@Override
//						public IExpr apply(LocalDateTime x) {
//							return F.stringx(x.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.US));
//						}
//					});
		}
	}

//	private final static class DateObject extends AbstractFunctionEvaluator {
//
//		@Override
//		public IExpr evaluate(final IAST ast, EvalEngine engine) {
//			try {
//				if (ast.size() == 1) {
//					return DateObjectExpr.newInstance(LocalDateTime.now());
//				}
//				if (ast.size() == 2) {
//					IExpr arg1 = ast.arg1();
//					if (arg1.isList()) {
//						IAST list = (IAST) arg1;
//						if (list.size() == 4) {
//							int year = list.arg1().toIntDefault();
//							int month = list.arg2().toIntDefault();
//							int day = list.arg3().toIntDefault();
//							if (year != Integer.MIN_VALUE && //
//									month != Integer.MIN_VALUE && //
//									day != Integer.MIN_VALUE) {
//								return DateObjectExpr.newInstance(LocalDateTime.of(year, month, day, 0, 0));
//							}
//						}
//					}
//					return F.NIL;
//				}
//				if (ast.size() == 3) {
//					if (ast.arg1() instanceof DateObjectExpr && //
//							ast.arg2() instanceof TimeObjectExpr) {
//						LocalDate ld = ((DateObjectExpr) ast.arg1()).toData().toLocalDate();
//						LocalTime lt = ((TimeObjectExpr) ast.arg2()).toData();
//						return DateObjectExpr.newInstance(LocalDateTime.of(ld, lt));
//					}
//				}
//			} catch (RuntimeException rex) {
//				if (FEConfig.SHOW_STACKTRACE) {
//					rex.printStackTrace();
//				}
//				return engine.printMessage(ast.topHead(), rex);
//			}
//
//			return F.NIL;
//		}
//
//		@Override
//		public int[] expectedArgSize(IAST ast) {
//			return IOFunctions.ARGS_0_2;
//		}
//	}

//	private final static class DateValue extends AbstractFunctionEvaluator {
//
//		@Override
//		public IExpr evaluate(final IAST ast, EvalEngine engine) {
//			try {
//				if (ast.isAST1()) {
//					IExpr arg1 = ast.arg1();
//					if (arg1.isString()) {
//						String str = ((IStringX) arg1).toString();
//						Function<LocalDateTime, IExpr> function = DATEVALUE_MAP.get(str);
//						if (function != null) {
//							return function.apply(LocalDateTime.now());
//						}
//					}
//					return F.NIL;
//				}
//				if (ast.isAST2()) {
//					IExpr arg1 = ast.arg1();
//					IExpr arg2 = ast.arg2();
//					if (arg1 instanceof DateObjectExpr && arg2.isString()) {
//						LocalDateTime ldt = ((DateObjectExpr) arg1).toData();
//						String str = ((IStringX) arg2).toString();
//						Function<LocalDateTime, IExpr> function = DATEVALUE_MAP.get(str);
//						if (function != null) {
//							return function.apply(ldt);
//						}
//					}
//					return F.NIL;
//				}
//			} catch (RuntimeException rex) {
//				if (FEConfig.SHOW_STACKTRACE) {
//					rex.printStackTrace();
//				}
//				return engine.printMessage(ast.topHead(), rex);
//			}
//
//			return F.NIL;
//		}
//
//		@Override
//		public int[] expectedArgSize(IAST ast) {
//			return IOFunctions.ARGS_1_3;
//		}
//
//		@Override
//		public void setUp(ISymbol newSymbol) {
//			newSymbol.setAttributes(ISymbol.LISTABLE);
//		}
//	}

//	private final static class TimeObject extends AbstractFunctionEvaluator {
//
//		@Override
//		public IExpr evaluate(final IAST ast, EvalEngine engine) {
//			try {
//				if (ast.size() == 1) {
//					LocalTime now = LocalTime.now();
//					return TimeObjectExpr.newInstance(LocalTime.of(now.getHour(), now.getMinute(), now.getSecond()));
//				}
//				if (ast.size() == 2) {
//					IExpr arg1 = ast.arg1();
//					if (arg1.isList()) {
//						IAST list = (IAST) arg1;
//						if (list.size() >= 2 && list.size() <= 4) {
//							int hour = list.arg1().toIntDefault();
//							int minute = 0;
//							if (list.size() >= 3) {
//								minute = list.arg2().toIntDefault();
//							}
//							int second = 0;
//							if (list.size() == 4) {
//								second = list.arg3().toIntDefault();
//							}
//							if (hour >= 0 && //
//									minute >= 0 && //
//									second >= 0) {
//								return TimeObjectExpr.newInstance(LocalTime.of(hour, minute, second));
//							}
//						}
//					}
//					return F.NIL;
//				}
//			} catch (RuntimeException rex) {
//				if (FEConfig.SHOW_STACKTRACE) {
//					rex.printStackTrace();
//				}
//				return engine.printMessage(ast.topHead(), rex);
//			}
//
//			return F.NIL;
//		}
//
//		@Override
//		public int[] expectedArgSize(IAST ast) {
//			return IOFunctions.ARGS_0_1;
//	}
//	}

	/**
	 * <pre>
	 * Quantity(value, unit)
	 * </pre>
	 * 
	 * <blockquote>
	 * <p>
	 * returns the quantity for <code>value</code> and <code>unit</code>
	 * </p>
	 * </blockquote>
	 */
	private final static class Quantity extends AbstractCoreFunctionEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {

			try {
				if (ast.size() == 2) {
					IExpr arg1 = engine.evaluate(ast.arg1());
					if (arg1.isString()) {
						IUnit unit = IUnitStatic.of(arg1.toString());
						if (unit==null) {
							return F.NIL;
						}
						return IQuantityStatic.of(F.C1, unit);
					}
				}
				if (ast.size() == 3) {
					IExpr arg1 = engine.evaluate(ast.arg1());
					IExpr arg2 = engine.evaluate(ast.arg2());
					if (arg2.isString()) {
						IUnit unit = IUnitStatic.of(arg2.toString());
						if (unit==null) {
							return F.NIL;
						}
						return IQuantityStatic.of(arg1, unit);
					}
				}
			} catch (RuntimeException e) {
				if (FEConfig.SHOW_STACKTRACE) {
					e.printStackTrace();
				}
				return engine.printMessage("Quantity: " + e.getMessage());
			}

			return F.NIL;
		}

		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_1_2;
		}
	}

	/**
	 * <pre>
	 * QuantityMagnitude(quantity)
	 * </pre>
	 * 
	 * <blockquote>
	 * <p>
	 * returns the value of the <code>quantity</code>
	 * </p>
	 * </blockquote>
	 * 
	 * <pre>
	 * QuantityMagnitude(quantity, unit)
	 * </pre>
	 * 
	 * <blockquote>
	 * <p>
	 * returns the value of the <code>quantity</code> for the given <code>unit</code>
	 * </p>
	 * </blockquote>
	 */
	private final static class QuantityMagnitude extends AbstractCoreFunctionEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {

			try {
				if (ast.size() == 2) {
					IExpr arg1 = engine.evaluate(ast.arg1());
					if (arg1.isQuantity()) {
						return ((IQuantity) arg1).value();
					}
				} else if (ast.size() == 3) {
					IExpr arg1 = engine.evaluate(ast.arg1());
					IExpr arg2 = engine.evaluate(ast.arg2());
					if (arg1.isQuantity()) {
						org.matheclipse.core.tensor.qty.QuantityMagnitude quantityMagnitude = org.matheclipse.core.tensor.qty.QuantityMagnitude
								.SI();
						IUnit unit = IUnitStatic.of(arg2.toString());
						if (unit==null) {
							return F.NIL;
						}
						UnaryOperator<IExpr> suo = quantityMagnitude.in(unit);
						return suo.apply(arg1);
					}
				}
			} catch (RuntimeException e) {
				if (FEConfig.SHOW_STACKTRACE) {
					e.printStackTrace();
				}
				return engine.printMessage("QuantityMagnitude: " + e.getMessage());
			}

			return F.NIL;
		}

		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_1_2;
		}
	}

	/**
	 * <pre>
	 * UnitConvert(quantity)
	 * </pre>
	 * 
	 * <blockquote>
	 * <p>
	 * convert the <code>quantity</code> to the base unit
	 * </p>
	 * </blockquote>
	 * 
	 * <pre>
	 * UnitConvert(quantity, unit)
	 * </pre>
	 * 
	 * <blockquote>
	 * <p>
	 * convert the <code>quantity</code> to the given <code>unit</code>
	 * </p>
	 * </blockquote>
	 */
	private final static class UnitConvert extends AbstractCoreFunctionEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {

			try {
				if (ast.size() == 2) {
					IExpr arg1 = engine.evaluate(ast.arg1());
					if (arg1.isQuantity()) {
						return UnitSystemStatic.SI().apply(arg1);
					}
				} else if (ast.size() == 3) {
					IExpr arg1 = engine.evaluate(ast.arg1());
					IExpr arg2 = engine.evaluate(ast.arg2());
					if (arg1.isQuantity()) {
						IUnit unit = IUnitStatic.of(arg2.toString());
						if (unit==null) {
							return F.NIL;
						}
						return unitConvert((IQuantity)arg1, unit);
					}
				}
			} catch (RuntimeException e) {
				if (FEConfig.SHOW_STACKTRACE) {
					e.printStackTrace();
				}
				return engine.printMessage("UnitConvert: " + e.getMessage());
			}

			return F.NIL;
		}

		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_1_2;
	}

	}

	public static void initialize() {
		Initializer.init();
	}

	private QuantityFunctions() {

	}

	public  static IExpr unitConvert(IQuantity arg1, IUnit unit) {
		org.matheclipse.core.tensor.qty.UnitConvert unitConvert = org.matheclipse.core.tensor.qty.UnitConvert.SI();
		return unitConvert.to(unit).apply(arg1);
	}
}
