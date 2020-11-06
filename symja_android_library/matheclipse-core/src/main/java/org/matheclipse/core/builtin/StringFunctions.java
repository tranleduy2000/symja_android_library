
package org.matheclipse.core.builtin;

import com.duy.lambda.Predicate;

import org.matheclipse.core.basic.Config;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.exception.Validate;
import org.matheclipse.core.eval.exception.ValidateException;
import org.matheclipse.core.eval.interfaces.AbstractCoreFunctionEvaluator;
import org.matheclipse.core.eval.interfaces.AbstractFunctionEvaluator;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.expression.StringX;
import org.matheclipse.core.form.output.OutputFormFactory;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IASTAppendable;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.IPredicate;
import org.matheclipse.core.interfaces.IStringX;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.core.parser.ExprParser;
import org.matheclipse.parser.client.FEConfig;

import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

public final class StringFunctions {

	/**
	 *
	 * See <a href="https://pangin.pro/posts/computation-in-static-initializer">Beware of computation in static
	 * initializer</a>
	 */
	private static class Initializer {

		private static void init() {
			F.FromCharacterCode.setEvaluator(new FromCharacterCode());
			F.LetterQ.setEvaluator(new LetterQ());
			F.LowerCaseQ.setEvaluator(new LowerCaseQ());
			F.StringCases.setEvaluator(new StringCases());
			F.StringContainsQ.setEvaluator(new StringContainsQ());
			F.StringDrop.setEvaluator(new StringDrop());
			F.StringExpression.setEvaluator(new StringExpression());
			F.StringJoin.setEvaluator(new StringJoin());
			F.StringLength.setEvaluator(new StringLength());
			F.StringMatchQ.setEvaluator(new StringMatchQ());
			F.StringPart.setEvaluator(new StringPart());
			F.StringReplace.setEvaluator(new StringReplace());
			F.StringRiffle.setEvaluator(new StringRiffle());
			F.StringSplit.setEvaluator(new StringSplit());
			F.StringTake.setEvaluator(new StringTake());
			F.SyntaxLength.setEvaluator(new SyntaxLength());
			F.TextString.setEvaluator(new TextString());
			F.ToCharacterCode.setEvaluator(new ToCharacterCode());
			F.ToExpression.setEvaluator(new ToExpression());
			F.ToString.setEvaluator(new ToString());
			F.ToUnicode.setEvaluator(new ToUnicode());
			F.UpperCaseQ.setEvaluator(new UpperCaseQ());
		}
	}

	private static class FromCharacterCode extends AbstractFunctionEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			if (ast.size() != 2) {
				return F.NIL;
			}

			if (ast.arg1().isList()) {
				final IAST list = (IAST) ast.arg1();
				return fromCharacterCode(list, ast, engine);
			}
			if (ast.arg1().isInteger()) {
				return fromCharacterCode(ast, ast, engine);
			}

			return F.NIL;
		}

		private static IExpr fromCharacterCode(final IAST charList, final IAST fromCharacterCodeAST,
				EvalEngine engine) {
			final StringBuilder buffer = new StringBuilder(charList.size());
				char ch;
			for (int i = 1; i < charList.size(); i++) {
				if (charList.get(i).isInteger()) {
					int unicode = charList.get(i).toIntDefault(Integer.MIN_VALUE);
					if (unicode < 0 || unicode >= 1114112) {
						// A character unicode, which should be a non-negative integer less than 1114112, is expected at
						// position `2` in `1`.
						return IOFunctions.printMessage(F.FromCharacterCode, "notunicode", F.List(charList, F.ZZ(i)),
								engine);
					}
					ch = (char) unicode;
						buffer.append(ch);
					} else {
						return F.NIL;
					}
				}
				return StringX.valueOf(buffer);
			}

		@Override
		public void setUp(final ISymbol newSymbol) {
		}

		// public static IAST fromCharacterCode(final String unicodeInput, final String inputEncoding,
		// final IASTAppendable list) {
		// try {
		// final String utf8String = new String(unicodeInput.getBytes(inputEncoding), "UTF-8");
		// int characterCode;
		// for (int i = 0; i < utf8String.length(); i++) {
		// characterCode = utf8String.charAt(i);
		// list.append(F.integer(characterCode));
		// }
		// return list;
		// } catch (final UnsupportedEncodingException e) {
		// e.printStackTrace();
		// }
		// return F.NIL;
		// }
	}

	/**
	 * <pre>
	 * LetterQ(expr)
	 * </pre>
	 * 
	 * <blockquote>
	 * <p>
	 * tests whether <code>expr</code> is a string, which only contains letters.
	 * </p>
	 * </blockquote>
	 * <p>
	 * A character is considered to be a letter if its general category type, provided by the Java method
	 * <code>Character#getType()</code> is any of the following:
	 * </p>
	 * <ul>
	 * <li><code>UPPERCASE_LETTER</code></li>
	 * <li><code>LOWERCASE_LETTER</code></li>
	 * <li><code>TITLECASE_LETTER</code></li>
	 * <li><code>MODIFIER_LETTER</code></li>
	 * <li><code>OTHER_LETTER</code></li>
	 * </ul>
	 * <p>
	 * Not all letters have case. Many characters are letters but are neither uppercase nor lowercase nor titlecase.
	 * </p>
	 */
	private static class LetterQ extends AbstractFunctionEvaluator implements Predicate<IExpr> {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			if (ast.arg1().isString()) {

			return F.bool(test(ast.arg1()));
		}
			return F.NIL;
		}

		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_1_1;
		}
		@Override
		public void setUp(final ISymbol newSymbol) {
			newSymbol.setAttributes(ISymbol.LISTABLE);
		}

		@Override
		public boolean test(final IExpr obj) {
			final String str = obj.toString();
			char ch;
			for (int i = 0; i < str.length(); i++) {
				ch = str.charAt(i);
				if (!(Character.isLetter(ch))) {
					return false;
				}
			}
			return true;
		}
	}

	/**
	 * Returns <code>True</code>, if the given expression is a string which only contains lower case characters
	 * 
	 */
	private static class LowerCaseQ extends AbstractFunctionEvaluator implements Predicate<IExpr> {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			IExpr arg1 = Validate.checkStringType(ast, 1, engine);
			if (arg1.isPresent()) {
				return F.bool(test(arg1));
			}

			return F.NIL;
		}

		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_1_1;
		}
		@Override
		public void setUp(final ISymbol newSymbol) {
			newSymbol.setAttributes(ISymbol.LISTABLE);
		}

		@Override
		public boolean test(final IExpr obj) {
			final String str = obj.toString();
			char ch;
			for (int i = 0; i < str.length(); i++) {
				ch = str.charAt(i);
				if (!(Character.isLowerCase(ch))) {
					return false;
				}
			}
			return true;
		}
	}

	private static class StringCases extends AbstractFunctionEvaluator {

		@Override
		public IExpr evaluate(IAST ast, EvalEngine engine) {
			if (ast.isAST1()) {
				ast = F.operatorFormAppend(ast);
				if (!ast.isPresent()) {
					return F.NIL;
				}
			}
			if (ast.isAST2()) {
				IExpr arg1 = ast.arg1();
				if (arg1.isList()) {
					return ((IAST) arg1).mapThread(ast.copy(), 1);
				}
				if (arg1.isString()) {
					final String s1 = arg1.toString();
					IExpr arg2 = ast.arg2();
					if (arg2.isString()) {
						IASTAppendable result = F.ListAlloc();
						String s2 = arg2.toString();
						appendMatches(s1, s2, result);
						return result;
					} else if (arg2.isList() || arg2.isAlternatives()) {
						IASTAppendable result = F.ListAlloc();
						IAST list = (IAST) arg2;
						for (int i = 1; i < list.size(); i++) {
							if (!list.get(i).isString()) {
								// `1` currently not supported in `2`.
								return IOFunctions.printMessage(ast.topHead(), "unsupported",
										F.List(list.get(i).topHead(), ast.topHead()), engine);
							}
						}
						appendMatches(s1, list, result);
						return result;
					} else {
						// `1` currently not supported in `2`.
						return IOFunctions.printMessage(ast.topHead(), "unsupported",
								F.List(arg2.topHead(), ast.topHead()), engine);
					}
				}
			}
			return F.NIL;
		}

		/**
		 * Append matches of the <code>list</code> elements expression in <code>s1</code> into the <code>result</code>
		 * list.
		 *
		 * @param s1
		 * @param list
		 * @param result
		 */
		private static void appendMatches(String s1, IAST list, IASTAppendable result) {
			if (list.isEmpty()) {
				return;
			}
			int i = 1;
			String s2 = list.get(i++).toString();
			int lastIndex = -1;
			int index = s1.indexOf(s2);
			while (index >= 0 || i < list.size()) {
				if (index < 0) {
					if (i >= list.size()) {
						return;
					}
					s2 = list.get(i++).toString();
					index = s1.indexOf(s2, lastIndex + 1);
					continue;
				}
				result.append(F.stringx(s2));
				lastIndex = index + s2.length();
				index = s1.indexOf(s2, lastIndex + 1);
			}
		}

		/**
		 * Append matches of the <code>s2</code> expression in <code>s1</code> into the <code>result</code> list.
		 *
		 * @param s1
		 * @param s2
		 * @param result
		 */
		private static void appendMatches(String s1, String s2, IASTAppendable result) {
			int index = s1.indexOf(s2);
			while (index >= 0) {
				result.append(F.stringx(s2));
				index = s1.indexOf(s2, index + 1);
			}
		}

		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_1_2;
		}
	}

	private static class StringContainsQ extends AbstractFunctionEvaluator {

		@Override
		public IExpr evaluate(IAST ast, EvalEngine engine) {
			if (ast.isAST1()) {
				ast = F.operatorFormAppend(ast);
				if (!ast.isPresent()) {
					return F.NIL;
				}
			}
			if (ast.isAST2()) {
				IExpr arg1 = ast.arg1();
				if (arg1.isList()) {
					return ((IAST) arg1).mapThread(ast.copy(), 1);
				}
				IExpr arg2 = ast.arg2();
				if (arg2.isAST(F.StringExpression)) {
					// `1` currently not supported in `2`.
					return IOFunctions.printMessage(ast.topHead(), "unsupported",
							F.List(F.StringExpression, ast.topHead()), engine);

				}
				if (arg1.isString()) {
					String s1 = arg1.toString();
					if (arg2.isString()) {
						String s2 = arg2.toString();
						return F.bool(s1.contains(s2));
					}
				}
			}
			return F.NIL;
		}

		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_1_2;
		}
	}
	private static class StringDrop extends AbstractFunctionEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {

			int from = 1;
			int to = 1;
			try {
			if (ast.arg1().isString()) {
				String s = ast.arg1().toString();
					from = Validate.checkIntType(ast, 2, Integer.MIN_VALUE);
					if (from >= 0) {
						from++;
						to = s.length();
				} else {
						to = s.length() + from;
						from = 1;
				}
					return F.$str(s.substring(from - 1, to));
			}

			} catch (IndexOutOfBoundsException iob) {
				// from substring
				// Cannot drop positions `1` through `2` in `3`.
				return IOFunctions.printMessage(ast.topHead(), "drop", F.List(F.ZZ(from - 1), F.ZZ(to), ast.arg1()),
						engine);
			} catch (final ValidateException ve) {
				// int number validation
				return engine.printMessage(ve.getMessage(ast.topHead()));
			}
			return F.NIL;
		}
		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_2_2;
		}
	}

	private static class StringExpression extends AbstractFunctionEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			// if (ast.arg1().isString()) {
			// String s = ast.arg1().toString();
			// }
			return F.NIL;
		}

		@Override
		public void setUp(final ISymbol newSymbol) {
			newSymbol.setAttributes(ISymbol.ONEIDENTITY | ISymbol.FLAT);
		}

		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_1_INFINITY;
		}
	}
	private static class StringJoin extends AbstractFunctionEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {

			IAST list = ast;
			if (ast.size() > 1) {
				if (ast.isAST1()) {
					IExpr arg1 = ast.arg1();
					if (arg1.isList()) {
						list = (IAST) arg1;
					} else {
						return arg1.isString() ? arg1 : F.NIL;
					}
				}
			StringBuilder buf = new StringBuilder();
				for (int i = 1; i < list.size(); i++) {
					if (list.get(i).isString()) {
						buf.append(list.get(i).toString());
				} else {
					return F.NIL;
				}
			}
			return F.$str(buf.toString());
			}
			return F.NIL;

		}

		@Override
		public void setUp(final ISymbol newSymbol) {
			newSymbol.setAttributes(ISymbol.FLAT | ISymbol.ONEIDENTITY);
		}
	}

	private static class StringLength extends AbstractFunctionEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {

			if (ast.arg1().isString()) {
				return F.ZZ(ast.arg1().toString().length());
			}
			return F.NIL;
		}

		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_1_1;
		}
		@Override
		public void setUp(final ISymbol newSymbol) {
			newSymbol.setAttributes(ISymbol.LISTABLE);
		}
	}

	private static class StringMatchQ extends AbstractFunctionEvaluator {

		@Override
		public IExpr evaluate(IAST ast, EvalEngine engine) {
			if (ast.isAST1()) {
				ast = F.operatorFormAppend(ast);
				if (!ast.isPresent()) {
					return F.NIL;
				}
			}
			if (ast.isAST2()) {
				IExpr arg1 = ast.arg1();
				if (arg1.isList()) {
					return ((IAST) arg1).mapThread(ast.copy(), 1);
				}
				if (arg1.isString()) {
					IExpr arg2 = ast.arg2();
					if (arg2.isAST(F.RegularExpression, 2) && arg2.first().isString()) {
						return F.bool(Pattern.matches(((IStringX) arg2.first()).toString(), arg1.toString()));
					} else {
						// `1` currently not supported in `2`.
						return IOFunctions.printMessage(ast.topHead(), "unsupported",
								F.List(arg2.topHead(), ast.topHead()), engine);
					}
				}
			}
			return F.NIL;
		}

		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_1_2;
		}
	}

	private static class StringPart extends AbstractFunctionEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			if (!ast.arg1().isString()) {
				return F.NIL;
			}

			IExpr arg2 = ast.arg2();
			if (arg2.isList()) {
				return ((IAST) arg2).mapThread(ast.copy(), 2);
			}
			String str = ((IStringX) ast.arg1()).toString();
			int part = arg2.toIntDefault();
			if (part > 0) {
				if (part > str.length()) {
					// Part `1` of `2` does not exist.
					return IOFunctions.printMessage(ast.topHead(), "partw", F.List(F.ZZ(part), ast.arg1()), engine);
				}
				return F.stringx(str.charAt(part - 1));
			}

			return F.NIL;

		}

		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_2_2;
		}

		@Override
		public void setUp(final ISymbol newSymbol) {

		}
	}

	private static class StringReplace extends AbstractFunctionEvaluator {

		@Override
		public IExpr evaluate(IAST ast, EvalEngine engine) {
			if (ast.isAST1()) {
				ast = F.operatorFormAppend(ast);
				if (!ast.isPresent()) {
					return F.NIL;
				}
			}
			if (ast.size() == 3) {
				if (!ast.arg1().isString()) {
					return F.NIL;
				}
				String str = ((IStringX) ast.arg1()).toString();
				IExpr arg2 = ast.arg2();
				if (!arg2.isListOfRules(false)) {
					if (arg2.isRuleAST()) {
						arg2 = F.List(arg2);
					} else {
						return F.NIL;
					}
				}
				IAST list = (IAST) arg2;
				for (int i = 1; i < list.size(); i++) {
					IAST rule = (IAST) list.get(i);
					if (!rule.arg1().isString() || !rule.arg2().isString()) {
						return F.NIL;
					}
					str = str.replace(((IStringX) rule.arg1()).toString(), //
							((IStringX) rule.arg2()).toString());
				}
				return F.$str(str);
			}
			return F.NIL;

		}

		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_1_3;
		}
		@Override
		public void setUp(final ISymbol newSymbol) {

		}
	}

	private static class StringRiffle extends AbstractFunctionEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			IExpr arg1 = ast.arg1();
			String sep1 = " ";
			String sep2 = "\n";
			String left = "";
			String right = "";
			boolean isListOfLists = arg1.isListOfLists();
			if (isListOfLists) {
				sep1 = "\n";
				sep2 = " ";
			}
			if (ast.size() >= 3) {
				IExpr arg2 = ast.arg2();
				if (arg2.isString()) {
					sep1 = arg2.toString();
				} else if (arg2.isAST(F.List, 4)) {
					IAST list = (IAST) arg2;
					left = list.arg1().toString();
					sep1 = list.arg2().toString();
					right = list.arg3().toString();
				} else {
					// String expected at position `1` in `2`.
					return IOFunctions.printMessage(ast.topHead(), "string", F.List(F.C2, ast), engine);
				}
			}
			if (ast.isAST3()) {
				IExpr arg3 = ast.arg3();
				if (arg3.isString()) {
					sep2 = arg3.toString();
				} else {
					// String expected at position `1` in `2`.
					return IOFunctions.printMessage(ast.topHead(), "string", F.List(F.C3, ast), engine);
				}
			}
			if (isListOfLists) {
				StringBuilder buf = new StringBuilder();
				IAST list1 = (IAST) arg1;
				buf.append(left);
				for (int i = 1; i < list1.size(); i++) {
					IAST row = (IAST) list1.get(i);
					for (int j = 1; j < row.size(); j++) {
						TextString.of(row.get(j), buf);
						if (j < row.size() - 1) {
							buf.append(sep2);
						}
					}
					if (i < list1.size() - 1) {
						buf.append(sep1);
					}
				}
				buf.append(right);
				return F.stringx(buf.toString());
			} else if (arg1.isList()) {
				StringBuilder buf = new StringBuilder();
				IAST list1 = (IAST) arg1;
				buf.append(left);
				for (int j = 1; j < list1.size(); j++) {
					TextString.of(list1.get(j), buf);
					if (j < list1.size() - 1) {
						buf.append(sep1);
					}
				}
				buf.append(right);
				return F.stringx(buf.toString());
			}
			return engine.printMessage("StringRiffle: list expected as first argument");
		}

		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_1_3;
		}

	}
	private static class StringSplit extends AbstractFunctionEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {

			if (!ast.arg1().isString()) {
				return F.NIL;
			}
			String str1 = ((IStringX) ast.arg1()).toString().trim();
			if (ast.isAST1()) {
				return splitList(str1, str1.split("\\s+"));
			}
			if (ast.isAST2()) {
				IExpr arg2 = ast.arg2();
				if (arg2.isBuiltInSymbol()) {
					if (arg2 == F.Whitespace) {
						return splitList(str1, str1.split("\\s+"));
					}
					if (arg2 == F.NumberString) {
						return splitList(str1, str1.split("[0-9]{1,13}(\\.[0-9]+)?"));
					}
				}
				if (arg2.isString()) {
					String str2 = ((IStringX) arg2).toString();
					return splitList(str1, str1.split(Pattern.quote(str2)));
				}
				if (arg2.isAST(F.RegularExpression, 2) && arg2.first().isString()) {
					Pattern strPattern = Pattern.compile(((IStringX) arg2.first()).toString());
					return splitList(str1, strPattern.split(str1));
				}
			}
			return F.NIL;

		}

		private static IExpr splitList(String str, String[] result) {
			if (result == null || str.length() == 0) {
				return F.CEmptyList;
			}
			IASTAppendable list = F.ListAlloc(result.length);
			for (int i = 0; i < result.length; i++) {
				list.append(F.stringx(result[i]));
			}
			return list;
		}

		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_1_3;
		}

		@Override
		public void setUp(final ISymbol newSymbol) {

		}
	}
	private static class StringTake extends AbstractFunctionEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {

			int from = 1;
			int to = 1;
			try {
			if (ast.arg1().isString()) {
				String s = ast.arg1().toString();
					to = Validate.checkIntType(ast, 2, Integer.MIN_VALUE);
					if (to >= 0) {
				} else {
						from = s.length() + to + 1;
						to = s.length();
						// return F.$str(s.substring(s.length() + to, s.length()));
				}
					return F.$str(s.substring(from - 1, to));
			}

			} catch (IndexOutOfBoundsException iob) {
				// from substring
				// Cannot take positions `1` through `2` in `3`.
				return IOFunctions.printMessage(ast.topHead(), "take", F.List(F.ZZ(from), F.ZZ(to), ast.arg1()),
						engine);
			} catch (final ValidateException ve) {
				// int number validation
				return engine.printMessage(ve.getMessage(ast.topHead()));
			}
			return F.NIL;
		}
		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_2_2;
		}
	}

	private static class SyntaxLength extends AbstractFunctionEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			if (!(ast.arg1() instanceof IStringX)) {
				return F.NIL;
			}

			final String str = ast.arg1().toString();
			return F.ZZ(ExprParser.syntaxLength(str, engine));
		}

		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_1_1;
		}
		@Override
		public void setUp(final ISymbol newSymbol) {
			newSymbol.setAttributes(ISymbol.LISTABLE);
		}

	}

	private static class TextString extends AbstractFunctionEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			IExpr arg1 = ast.arg1();
			return of(arg1);
		}

		private static IExpr of(IExpr arg1) {
			if (arg1.isString()) {
				return arg1;
			}
			return F.stringx(arg1.toString());
		}

		protected static void of(IExpr arg1, StringBuilder buf) {
			if (arg1.isString()) {
				buf.append(((IStringX) arg1).toString());
				return;
			}
			buf.append(arg1.toString());

		}

		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_1_1;
		}

	}
	private static class ToCharacterCode extends AbstractFunctionEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			if (!(ast.arg1() instanceof IStringX)) {
				return F.NIL;
			}

			return toCharacterCode(ast.arg1().toString(), "UTF-8");
		}

		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_1_1;
		}
		@Override
		public void setUp(final ISymbol newSymbol) {
			newSymbol.setAttributes(ISymbol.LISTABLE);
		}

		public static IAST toCharacterCode(final String unicodeInput, final String inputEncoding) {
			try {
				final String utf8String = new String(unicodeInput.getBytes(inputEncoding), "UTF-8");
				int characterCode;
				final int length = utf8String.length();
				IASTAppendable list = F.ListAlloc(length);
				for (int i = 0; i < length; i++) {
					characterCode = utf8String.charAt(i);
					list.append(F.ZZ(characterCode));
				}
				return list;
			} catch (final UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return F.NIL;
		}
	}

	private final static class ToExpression extends AbstractFunctionEvaluator {
		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			IExpr arg1 = ast.arg1();
			if (arg1.isString()) {
				ISymbol form = F.InputForm;
				if (ast.size() == 3) {
					IExpr arg2 = ast.arg2();
					if (arg2.equals(F.InputForm)) {
						form = F.InputForm;
					} else if (arg2.equals(F.TeXForm)) {
						form = F.TeXForm;
					} else {
						return F.NIL;
					}
				}
				try {
					if (form.equals(F.InputForm)) {
						ExprParser parser = new ExprParser(engine);
						IExpr temp = parser.parse(arg1.toString());
						return temp;
					} else if (form.equals(F.TeXForm)) {
//						TeXParser texParser = new TeXParser(engine);
//						return texParser.toExpression(arg1.toString());
					}
				} catch (RuntimeException rex) {
					if (FEConfig.SHOW_STACKTRACE) {
						rex.printStackTrace();
					}
					return F.$Aborted;
				}
			}
			return F.NIL;
		}

		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_1_2;
		}
		@Override
		public void setUp(final ISymbol newSymbol) {
//			TeXParser.initialize();
		}
	}
	private static class ToString extends AbstractFunctionEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {

			if (ast.arg1().isString()) {
				return ast.arg1();
			}
			return F.stringx(inputForm(ast.arg1()));
		}

		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_1_1;
		}
	}

	private static class ToUnicode extends AbstractFunctionEvaluator {
		private final static String UNICODE_PREFIX = "\\u";

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			if (!(ast.arg1() instanceof IStringX)) {
				return F.NIL;
			}

			return StringX.valueOf(toUnicodeString(ast.arg1().toString(), "UTF-8"));
		}

		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_1_1;
		}
		@Override
		public void setUp(final ISymbol newSymbol) {
			newSymbol.setAttributes(ISymbol.LISTABLE);
		}

		public static String toUnicodeString(final String unicodeInput, final String inputEncoding) {
			final StringBuilder unicodeStringBuilder = new StringBuilder();
			String unicodeString = null;

			try {
				final String utf8String = new String(unicodeInput.getBytes(inputEncoding), "UTF-8");
				String hexValueString = null;
				int hexValueLength = 0;
				for (int i = 0; i < utf8String.length(); i++) {
					hexValueString = Integer.toHexString(utf8String.charAt(i));
					hexValueLength = hexValueString.length();
					if (hexValueLength < 4) {
						for (int j = 0; j < (4 - hexValueLength); j++) {
							hexValueString = "0" + hexValueString;
						}
					}
					unicodeStringBuilder.append(UNICODE_PREFIX);
					unicodeStringBuilder.append(hexValueString);
				}
				unicodeString = unicodeStringBuilder.toString();
			} catch (final UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return unicodeString;
		}
	}

	/**
	 * <pre>
	 * UpperCaseQ(str)
	 * </pre>
	 *
	 * <blockquote>
	 * <p>
	 * is <code>True</code> if the given <code>str</code> is a string which only contains upper case characters.
	 * </p>
	 * </blockquote>
	 * <h3>Examples</h3>
	 *
	 * <pre>
	 * &gt;&gt; UpperCaseQ("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
	 * True
	 *
	 * &gt;&gt; UpperCaseQ("ABCDEFGHIJKLMNopqRSTUVWXYZ")
	 * False
	 * </pre>
	 */
	private final static class UpperCaseQ extends AbstractCoreFunctionEvaluator
			implements Predicate<IExpr>, IPredicate {

		/** {@inheritDoc} */
		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			IExpr arg1 = engine.evaluate(ast.arg1());
			IExpr temp = Validate.checkStringType(ast, 1, engine);
			if (temp.isPresent()) {
				return F.bool(test(arg1));
			}
			return F.NIL;
		}

		@Override
		public boolean test(final IExpr obj) {
			final String str = obj.toString();
			char ch;
			for (int i = 0; i < str.length(); i++) {
				ch = str.charAt(i);
				if (!(Character.isUpperCase(ch))) {
					return false;
				}
			}
			return true;
		}

		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_1_1;
		}
	}
	public static String inputForm(final IExpr expression, boolean relaxedSyntax) {
		try {
			StringBuilder buf = new StringBuilder();
			OutputFormFactory off = OutputFormFactory.get(relaxedSyntax, false);
			off.setIgnoreNewLine(true);
			off.setQuotes(true);
			if (off.convert(buf, expression)) {
			return buf.toString();
			}
		} catch (RuntimeException rex) {
			if (FEConfig.SHOW_STACKTRACE) {
				rex.printStackTrace();
			}
		}
		return null;
	}

	public static String inputForm(final IExpr expression) {
		if (FEConfig.PARSER_USE_LOWERCASE_SYMBOLS) {
			return StringFunctions.inputForm(expression, true);
		}
		return StringFunctions.inputForm(expression, false);
	}

	public static void initialize() {
		Initializer.init();
	}

	private StringFunctions() {

	}

}
