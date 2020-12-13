/*
 * Copyright 2005-2008 Axel Kramer (axelclk@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.matheclipse.core.parser;

import com.gx.common.base.CharMatcher;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IASTMutable;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.IInteger;
import org.matheclipse.parser.client.FEConfig;
import org.matheclipse.parser.client.ast.IParserFactory;
import org.matheclipse.parser.client.operator.InfixOperator;
import org.matheclipse.parser.client.operator.Operator;
import org.matheclipse.parser.client.operator.Precedence;
import org.matheclipse.parser.trie.Trie;
import org.matheclipse.parser.trie.TrieMatch;

public class ExprParserFactory implements IParserFactory {

  /** The matcher for characters, which could form an operator */
  public static CharMatcher OPERATOR_MATCHER = null;

  /** The set of characters, which could form an operator */
  public boolean isOperatorChar(char ch) {
    return OPERATOR_MATCHER.matches(ch);
  }

  private static class InformationOperator extends PrefixExprOperator {

    public InformationOperator(final String oper, final String functionName, final int precedence) {
      super(oper, functionName, precedence);
    }

    public IExpr createFunction(final IParserFactory factory, final IExpr argument) {
      if (fOperatorString.equals("?")) {
        return F.Information(argument, F.Rule(F.LongForm, F.False));
      }
      // ?? operator:
      return F.Information(argument);
    }

  }

  /** @@@ operator (not @@ operator) */
  private static class ApplyOperator extends InfixExprOperator {

    public ApplyOperator(final String oper, final String functionName, final int precedence,
        final int grouping) {
      super(oper, functionName, precedence, grouping);
    }

    @Override
    public IASTMutable createFunction(final IParserFactory factory, ExprParser parser,
        final IExpr lhs,
        final IExpr rhs) {
      if (fOperatorString.equals("@")) {
        return F.unaryAST1(lhs, rhs);
      }
      if (fOperatorString.equals("@@")) {
        return F.Apply(lhs, rhs);
      }
      // case "@@@"
      return F.ApplyListC1(lhs, rhs);
    }

  }

  private static class TagSetOperator extends InfixExprOperator {

    public TagSetOperator(final String oper, final String functionName, final int precedence,
        final int grouping) {
      super(oper, functionName, precedence, grouping);
    }

    @Override
    public IASTMutable createFunction(final IParserFactory factory, ExprParser parser,
        final IExpr lhs,
        final IExpr rhs) {
      if (rhs.isAST()) {
        IAST r = (IAST) rhs;

        if (r.isAST(F.Set, 3)) {
          return F.TagSet(lhs, r.arg1(), r.arg2());
        } else if (r.isAST(F.SetDelayed, 3)) {
          return F.TagSetDelayed(lhs, r.arg1(), r.arg2());
        }
      }
      return F.binaryAST2(F.TagSet, lhs, rhs);
    }
  }

  private static class DivideExprOperator extends InfixExprOperator {

    public DivideExprOperator(final String oper, final String functionName, final int precedence,
        final int grouping) {
      super(oper, functionName, precedence, grouping);
    }

    @Override
    public IASTMutable createFunction(final IParserFactory factory, ExprParser parser,
        final IExpr lhs,
        final IExpr rhs) {

      if (rhs.isInteger() && !rhs.isZero()) {
        if (lhs.isInteger()) {
          if (!parser.isHoldOrHoldFormOrDefer()) {
            return (IASTMutable) F.Rational((IInteger) lhs, (IInteger) rhs);
          }
        }
        return (IASTMutable) F.Times(F.fraction(F.C1, (IInteger) rhs), lhs);
      }

      if (lhs.equals(F.C1)) {
        return (IASTMutable) F.Power(rhs, F.CN1);
      }
      if (rhs.isPower() && rhs.exponent().isNumber()) {
        return F.Times(lhs, F.Power(rhs.base(), rhs.exponent().negate()));
      }
      return F.Times(lhs, F.Power(rhs, F.CN1));
    }
  }

  private static class PreMinusExprOperator extends PrefixExprOperator {

    public PreMinusExprOperator(final String oper, final String functionName,
        final int precedence) {
      super(oper, functionName, precedence);
    }

    @Override
    public IExpr createFunction(final IParserFactory factory, final IExpr argument) {
      return F.Times(F.CN1, argument);
    }
  }

  private static class PrePlusExprOperator extends PrefixExprOperator {

    public PrePlusExprOperator(final String oper, final String functionName, final int precedence) {
      super(oper, functionName, precedence);
    }

    @Override
    public IExpr createFunction(final IParserFactory factory, final IExpr argument) {
      return argument;
    }
  }

  private static class SubtractExprOperator extends InfixExprOperator {

    public SubtractExprOperator(final String oper, final String functionName, final int precedence,
        final int grouping) {
      super(oper, functionName, precedence, grouping);
    }

    @Override
    public IASTMutable createFunction(final IParserFactory factory, ExprParser parser,
        final IExpr lhs,
        final IExpr rhs) {
      if (rhs.isNumber()) {
        return (IASTMutable) F.Plus(lhs, rhs.negate());
      }
      if (rhs.isTimes() && rhs.first().isNumber()) {
        return (IASTMutable) F.Plus(lhs, ((IAST) rhs).setAtCopy(1, rhs.first().negate()));
      }
      return (IASTMutable) F.Plus(lhs, F.Times(F.CN1, rhs));
    }
  }


  public static final InformationOperator INFORMATION_SHORT = //
      new InformationOperator("?", "Information", 720);

  public static final InformationOperator INFORMATION_LONG = //
      new InformationOperator("??", "Information", 720);

  public static final ApplyOperator APPLY_HEAD_OPERATOR = //
      new ApplyOperator("@", "Apply", Precedence.APPLY_HEAD, InfixExprOperator.RIGHT_ASSOCIATIVE);

  public static final ApplyOperator APPLY_OPERATOR = //
      new ApplyOperator("@@", "Apply", Precedence.APPLY, InfixExprOperator.RIGHT_ASSOCIATIVE);

  public static final ApplyOperator APPLY_LEVEL_OPERATOR = //
      new ApplyOperator("@@@", "Apply", Precedence.APPLY, InfixExprOperator.RIGHT_ASSOCIATIVE);

  public static final InfixExprOperator EQUAL_OPERATOR = //
      new InfixExprOperator("==", "Equal", Precedence.EQUAL, InfixExprOperator.NONE);

  public static final InfixExprOperator NON_COMMUTATIVE_MULTIPLY_OPERATOR = //
      new InfixExprOperator(
          "**",
          "NonCommutativeMultiply",
          Precedence.NONCOMMUTATIVEMULTIPLY,
          InfixExprOperator.NONE);

  public static final InfixExprOperator POWER_OPERATOR = //
      new InfixExprOperator("^", "Power", Precedence.POWER, InfixExprOperator.RIGHT_ASSOCIATIVE);

  public static final InfixExprOperator SET_OPERATOR = //
      new InfixExprOperator("=", "Set", Precedence.SET, InfixExprOperator.RIGHT_ASSOCIATIVE);

  public static final TagSetOperator TAG_SET_OPERATOR = //
      new TagSetOperator("/:", "TagSet", Precedence.TAGSET, InfixExprOperator.NONE);

  static final String[] HEADER_STRINGS = {"MessageName", "Information", "Information", "Get",
      "PatternTest",
      "MapAll", "TimesBy", "Plus", "UpSet", "CompoundExpression", "Apply", "Map", "Unset", "Apply",
      "Apply",
      "ReplaceRepeated", "Less", "And", "Divide", "Set", "Increment", "Factorial2", "LessEqual",
      "NonCommutativeMultiply", "Factorial", "Times", "Power", "Dot", "Not", "PreMinus", "SameQ",
      "RuleDelayed",
      "GreaterEqual", "Condition", "Colon", "//", "DivideBy", "Or", "Span", "Equal", "StringJoin",
      "Unequal",
      "Decrement", "SubtractFrom", "PrePlus", "RepeatedNull", "UnsameQ", "Rule", "UpSetDelayed",
      "PreIncrement",
      "Function", "Greater", "PreDecrement", "Subtract", "SetDelayed", "Alternatives", "AddTo",
      "Repeated",
      "ReplaceAll", "TagSet", "Composition", "StringExpression", "TwoWayRule", "TwoWayRule",
      "DirectedEdge",
      "UndirectedEdge", "CenterDot", "CircleDot"};

  static final String[] OPERATOR_STRINGS = {"::", "<<", "?", "??", "?", "//@", "*=", "+", "^=", ";",
      "@", "/@", "=.",
      "@@", "@@@", "//.", "<", "&&", "/", "=", "++", "!!", "<=", "**", "!", "*", "^", ".", "!", "-",
      "===", ":>",
      ">=", "/;", ":", "//", "/=", "||", ";;", "==", "<>", "!=", "--", "-=", "+", "...", "=!=",
      "->", "^:=", "++",
      "&", ">", "--", "-", ":=", "|", "+=", "..", "/.", "/:", "@*", "~~", //
      "<->", // TwoWayRule
      "\uF120", // TwoWayRule
      "\uF3D5", // DirectedEdge
      "\uF3D4", // UndirectedEdge
      "\u00B7", // CenterDot
      "\u2299" // CircleDot
  };

  private static Operator[] OPERATORS;

  public static final ExprParserFactory MMA_STYLE_FACTORY = new ExprParserFactory();

  public static final ExprParserFactory RELAXED_STYLE_FACTORY = new ExprParserFactory();

  /**
   *
   */
  private static Trie<String, Operator> fOperatorMap;

  /**
   *
   */
  private static Trie<String, ArrayList<Operator>> fOperatorTokenStartSet;

  /**
   * See <a href="https://pangin.pro/posts/computation-in-static-initializer">Beware of computation
   * in static initializer</a>
   */
  private static class Initializer {

    private static void init() {

      OPERATORS = new Operator[]{new InfixExprOperator("::", "MessageName", Precedence.MESSAGENAME,
          InfixExprOperator.NONE),
          new PrefixExprOperator("<<", "Get", Precedence.GET), //
          INFORMATION_SHORT, //
          INFORMATION_LONG, //
          new InfixExprOperator("?", "PatternTest", Precedence.PATTERNTEST, InfixExprOperator.NONE),
          //
          new InfixExprOperator("//@", "MapAll", Precedence.MAPALL,
              InfixExprOperator.RIGHT_ASSOCIATIVE), //
          new InfixExprOperator("*=", "TimesBy", Precedence.TIMESBY,
              InfixExprOperator.RIGHT_ASSOCIATIVE), //
          new InfixExprOperator("+", "Plus", Precedence.PLUS, InfixExprOperator.NONE), //
          new InfixExprOperator("^=", "UpSet", Precedence.UPSET,
              InfixExprOperator.RIGHT_ASSOCIATIVE), //
          new InfixExprOperator(";", "CompoundExpression", Precedence.COMPOUNDEXPRESSION,
              InfixExprOperator.NONE), //

          APPLY_HEAD_OPERATOR, //
          new InfixExprOperator("/@", "Map", Precedence.MAP, InfixExprOperator.RIGHT_ASSOCIATIVE),
          //
          new PostfixExprOperator("=.", "Unset", Precedence.UNSET), //
          APPLY_OPERATOR, //
          APPLY_LEVEL_OPERATOR, //
          new InfixExprOperator("//.", "ReplaceRepeated", Precedence.REPLACEREPEATED,
              InfixExprOperator.LEFT_ASSOCIATIVE), //
          new InfixExprOperator("<", "Less", Precedence.LESS, InfixExprOperator.NONE), //
          new InfixExprOperator("&&", "And", Precedence.AND, InfixExprOperator.NONE), //
          new DivideExprOperator("/", "Divide", Precedence.DIVIDE,
              InfixExprOperator.LEFT_ASSOCIATIVE), //
          SET_OPERATOR, //
          new PostfixExprOperator("++", "Increment", Precedence.INCREMENT), //
          new PostfixExprOperator("!!", "Factorial2", Precedence.FACTORIAL2), //
          new InfixExprOperator("<=", "LessEqual", Precedence.LESSEQUAL, InfixExprOperator.NONE), //
          NON_COMMUTATIVE_MULTIPLY_OPERATOR, //
          new PostfixExprOperator("!", "Factorial", Precedence.FACTORIAL), //
          new InfixExprOperator("*", "Times", Precedence.TIMES, InfixExprOperator.NONE), //
          POWER_OPERATOR, //
          new InfixExprOperator(".", "Dot", Precedence.DOT, InfixExprOperator.NONE), //
          new PrefixExprOperator("!", "Not", Precedence.NOT), //
          new PreMinusExprOperator("-", "PreMinus", Precedence.PREMINUS), //
          new InfixExprOperator("===", "SameQ", Precedence.SAMEQ, InfixExprOperator.NONE), //
          new InfixExprOperator(":>", "RuleDelayed", Precedence.RULEDELAYED,
              InfixExprOperator.RIGHT_ASSOCIATIVE), //
          new InfixExprOperator(">=", "GreaterEqual", Precedence.GREATEREQUAL,
              InfixExprOperator.NONE), //
          new InfixExprOperator("/;", "Condition", Precedence.CONDITION,
              InfixExprOperator.LEFT_ASSOCIATIVE), //
          new InfixExprOperator(":", "Colon", Precedence.COLON, InfixExprOperator.NONE), //
          new InfixExprOperator("//", "//", 70, InfixExprOperator.LEFT_ASSOCIATIVE), //
          new InfixExprOperator("/=", "DivideBy", Precedence.DIVIDEBY,
              InfixExprOperator.RIGHT_ASSOCIATIVE), //
          new InfixExprOperator("||", "Or", Precedence.OR, InfixExprOperator.NONE), //
          new InfixExprOperator(";;", "Span", Precedence.SPAN, InfixExprOperator.NONE), //
          EQUAL_OPERATOR, //
          new InfixExprOperator("<>", "StringJoin", Precedence.STRINGJOIN, InfixExprOperator.NONE),
          //
          new InfixExprOperator("!=", "Unequal", Precedence.UNEQUAL, InfixExprOperator.NONE), //
          new PostfixExprOperator("--", "Decrement", Precedence.DECREMENT), //
          new InfixExprOperator("-=", "SubtractFrom", Precedence.SUBTRACTFROM,
              InfixExprOperator.RIGHT_ASSOCIATIVE), //
          new PrePlusExprOperator("+", "PrePlus", Precedence.PREPLUS), //
          new PostfixExprOperator("...", "RepeatedNull", Precedence.REPEATEDNULL), //
          new InfixExprOperator("=!=", "UnsameQ", Precedence.UNSAMEQ, InfixExprOperator.NONE), //
          new InfixExprOperator("->", "Rule", Precedence.RULE, InfixExprOperator.RIGHT_ASSOCIATIVE),
          //
          new InfixExprOperator("^:=", "UpSetDelayed", Precedence.UPSETDELAYED,
              InfixExprOperator.RIGHT_ASSOCIATIVE), //
          new PrefixExprOperator("++", "PreIncrement", Precedence.PREINCREMENT), //
          new PostfixExprOperator("&", "Function", Precedence.FUNCTION), //
          new InfixExprOperator(">", "Greater", Precedence.GREATER, InfixExprOperator.NONE), //
          new PrefixExprOperator("--", "PreDecrement", Precedence.PREDECREMENT), //
          new SubtractExprOperator("-", "Subtract", Precedence.SUBTRACT,
              InfixExprOperator.LEFT_ASSOCIATIVE), //
          new InfixExprOperator(":=", "SetDelayed", Precedence.SETDELAYED,
              InfixExprOperator.RIGHT_ASSOCIATIVE), //
          new InfixExprOperator("|", "Alternatives", Precedence.ALTERNATIVES,
              InfixExprOperator.NONE), //
          new InfixExprOperator("+=", "AddTo", Precedence.ADDTO,
              InfixExprOperator.RIGHT_ASSOCIATIVE), //
          new PostfixExprOperator("..", "Repeated", Precedence.REPEATED), //
          new InfixExprOperator("/.", "ReplaceAll", Precedence.REPLACEALL,
              InfixExprOperator.LEFT_ASSOCIATIVE), //
          TAG_SET_OPERATOR, //
          new InfixExprOperator("@*", "Composition", Precedence.COMPOSITION, InfixOperator.NONE),
            new InfixExprOperator(
                "~~", "StringExpression", Precedence.STRINGEXPRESSION, InfixOperator.NONE),
            new InfixExprOperator(
                "<->", "TwoWayRule", Precedence.TWOWAYRULE, InfixOperator.RIGHT_ASSOCIATIVE), //
            new InfixExprOperator(
                "\uF120", "TwoWayRule", Precedence.TWOWAYRULE, InfixOperator.RIGHT_ASSOCIATIVE), //
            new InfixExprOperator(
                "\uF3D5",
                "DirectedEdge",
                Precedence.DIRECTEDEDGE,
              InfixOperator.RIGHT_ASSOCIATIVE), //
            new InfixExprOperator(
                "\uF3D4",
                "UndirectedEdge",
                Precedence.UNDIRECTEDEDGE,
              InfixOperator.RIGHT_ASSOCIATIVE), //
          new InfixExprOperator("\u00B7", "CenterDot", Precedence.CENTERDOT,
              InfixExprOperator.NONE), //
          new InfixExprOperator("\u2299", "CircleDot", Precedence.CIRCLEDOT, InfixExprOperator.NONE)
          //
      };

      StringBuilder buf = new StringBuilder(BASIC_OPERATOR_CHARACTERS);
      fOperatorMap = FEConfig.TRIE_STRING2OPERATOR_BUILDER.withMatch(TrieMatch.EXACT).build();
      fOperatorTokenStartSet =
          FEConfig.TRIE_STRING2OPERATORLIST_BUILDER.withMatch(TrieMatch.EXACT).build();
      // if (fuzzyParser) {
      // for (int i = 0; i < HEADER_STRINGS.length; i++) {
      // if (OPERATOR_STRINGS[i] == "=") {
      // addOperator(fOperatorMap, fOperatorTokenStartSet, OPERATOR_STRINGS[i], "Equal",
      // EQUAL_OPERATOR);
      // } else {
      // addOperator(fOperatorMap, fOperatorTokenStartSet, OPERATOR_STRINGS[i], HEADER_STRINGS[i],
      // OPERATORS[i]);
      // }
      // String unicodeChar = org.matheclipse.parser.client.Characters.NamedCharactersMap
      // .get(HEADER_STRINGS[i]);
      // if (unicodeChar != null) {
      // addOperator(fOperatorMap, fOperatorTokenStartSet, unicodeChar, HEADER_STRINGS[i],
      // OPERATORS[i]);
      // buf.append(unicodeChar);
      // }
      // }
      // } else {
      for (int i = 0; i < HEADER_STRINGS.length; i++) {
        addOperator(fOperatorMap, fOperatorTokenStartSet, OPERATOR_STRINGS[i], HEADER_STRINGS[i],
            OPERATORS[i]);
        String unicodeChar = org.matheclipse.parser.client.Characters.NamedCharactersMap
            .get(HEADER_STRINGS[i]);
        if (unicodeChar != null) {
          addOperator(fOperatorMap, fOperatorTokenStartSet, unicodeChar, HEADER_STRINGS[i],
              OPERATORS[i]);
          buf.append(unicodeChar);
        }
      }
      // }
      OPERATOR_MATCHER = CharMatcher.anyOf(buf.toString());
    }
  }

  public static void initialize() {
    Initializer.init();
  }

  public static void addOperator(
      final Map<String, Operator> operatorMap,
      final Map<String, ArrayList<Operator>> operatorTokenStartSet,
      final String operatorStr,
      final String headStr,
      final Operator oper) {
    ArrayList<Operator> list;
    operatorMap.put(headStr, oper);
    list = operatorTokenStartSet.get(operatorStr);
    if (list == null) {
      list = new ArrayList<Operator>(2);
      list.add(oper);
      operatorTokenStartSet.put(operatorStr, list);
    } else {
      list.add(oper);
    }
  }


  /** Create a default ASTNode factory */
  public ExprParserFactory() {
    // this.fIgnoreCase = ignoreCase;
  }

  @Override
  public Operator get(final String identifier) {
    return fOperatorMap.get(identifier);
  }

  /** public Map<String, Operator> getIdentifier2OperatorMap() */
  @Override
  public Map<String, Operator> getIdentifier2OperatorMap() {
    return fOperatorMap;
  }

  /**
   *
   */
  @Override
  public Map<String, ArrayList<Operator>> getOperator2ListMap() {
    return fOperatorTokenStartSet;
  }

  /**
   *
   */
  @Override
  public List<Operator> getOperatorList(final String key) {
    return fOperatorTokenStartSet.get(key);
  }

  @Override
  public boolean isValidIdentifier(String identifier) {
    return true;
  }

  // private String toRubiString(final String nodeStr) {
  // if (!FEConfig.PARSER_USE_LOWERCASE_SYMBOLS) {
  // if (nodeStr.length() == 1) {
  // return nodeStr;
  // }
  // String lowercaseName = nodeStr.toLowerCase(Locale.US);
  // String temp = AST2Expr.PREDEFINED_SYMBOLS_MAP.get(lowercaseName);
  // if (temp != null) {
  // if (!temp.equals(nodeStr)) {
  // temp = F.PREDEFINED_INTERNAL_FORM_STRINGS.get(nodeStr);
  // if (temp == null) {
  // if (lowercaseName.length() > 1) {
  // if (!lowercaseName.equals("sin") && !lowercaseName.equals("cos")
  // && !lowercaseName.equals("tan") && !lowercaseName.equals("cot")
  // && !lowercaseName.equals("csc") && !lowercaseName.equals("sec")) {
  // System.out.println(nodeStr + " => §" + lowercaseName);
  // }
  // }
  // return "§" + lowercaseName;
  // }
  // }
  // } else {
  // if (!nodeStr.equals(nodeStr.toLowerCase(Locale.US))) {
  // temp = F.PREDEFINED_INTERNAL_FORM_STRINGS.get(nodeStr);
  // if (temp == null) {
  // if (lowercaseName.length() > 1) {
  // System.out.println(nodeStr + " => §" + lowercaseName);
  // }
  // return "§" + lowercaseName;
  // }
  // }
  // }
  // }
  // return nodeStr;
  // }
}
