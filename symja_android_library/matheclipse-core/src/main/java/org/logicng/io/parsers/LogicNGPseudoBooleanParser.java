// Generated from LogicNGPseudoBoolean.g4 by ANTLR 4.7

package org.logicng.io.parsers;

import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.logicng.formulas.CType;
import org.logicng.formulas.Formula;
import org.logicng.formulas.FormulaFactory;
import org.logicng.formulas.Literal;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class LogicNGPseudoBooleanParser extends Parser {
    public static final int
            NUMBER = 1, LITERAL = 2, TRUE = 3, FALSE = 4, LBR = 5, RBR = 6, NOT = 7, AND = 8, OR = 9,
            IMPL = 10, EQUIV = 11, MUL = 12, ADD = 13, EQ = 14, LE = 15, LT = 16, GE = 17, GT = 18,
            WS = 19;
    public static final int
            RULE_formula = 0, RULE_constant = 1, RULE_comparison = 2, RULE_simp = 3,
            RULE_lit = 4, RULE_conj = 5, RULE_disj = 6, RULE_impl = 7, RULE_equiv = 8,
            RULE_mul = 9, RULE_add = 10;
    public static final String[] ruleNames = {
            "formula", "constant", "comparison", "simp", "lit", "conj", "disj", "impl",
            "equiv", "mul", "add"
    };
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\25\u009b\4\2\t\2" +
                    "\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13" +
                    "\t\13\4\f\t\f\3\2\3\2\3\2\3\2\3\2\3\2\5\2\37\n\2\3\3\3\3\3\3\3\3\5\3%" +
                    "\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3" +
                    "\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4@\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3" +
                    "\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5O\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6X\n" +
                    "\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7`\n\7\f\7\16\7c\13\7\3\7\3\7\3\b\3\b\3\b" +
                    "\3\b\3\b\3\b\7\bm\n\b\f\b\16\bp\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\5" +
                    "\tz\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0084\n\n\3\n\3\n\3\13\3\13" +
                    "\3\13\3\13\3\13\3\13\5\13\u008e\n\13\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u0096" +
                    "\n\f\f\f\16\f\u0099\13\f\3\f\2\2\r\2\4\6\b\n\f\16\20\22\24\26\2\2\2\u009f" +
                    "\2\36\3\2\2\2\4$\3\2\2\2\6?\3\2\2\2\bN\3\2\2\2\nW\3\2\2\2\fY\3\2\2\2\16" +
                    "f\3\2\2\2\20s\3\2\2\2\22}\3\2\2\2\24\u008d\3\2\2\2\26\u008f\3\2\2\2\30" +
                    "\31\7\2\2\3\31\37\b\2\1\2\32\33\5\22\n\2\33\34\7\2\2\3\34\35\b\2\1\2\35" +
                    "\37\3\2\2\2\36\30\3\2\2\2\36\32\3\2\2\2\37\3\3\2\2\2 !\7\5\2\2!%\b\3\1" +
                    "\2\"#\7\6\2\2#%\b\3\1\2$ \3\2\2\2$\"\3\2\2\2%\5\3\2\2\2&\'\5\26\f\2\'" +
                    "(\7\20\2\2()\7\3\2\2)*\b\4\1\2*@\3\2\2\2+,\5\26\f\2,-\7\21\2\2-.\7\3\2" +
                    "\2./\b\4\1\2/@\3\2\2\2\60\61\5\26\f\2\61\62\7\22\2\2\62\63\7\3\2\2\63" +
                    "\64\b\4\1\2\64@\3\2\2\2\65\66\5\26\f\2\66\67\7\23\2\2\678\7\3\2\289\b" +
                    "\4\1\29@\3\2\2\2:;\5\26\f\2;<\7\24\2\2<=\7\3\2\2=>\b\4\1\2>@\3\2\2\2?" +
                    "&\3\2\2\2?+\3\2\2\2?\60\3\2\2\2?\65\3\2\2\2?:\3\2\2\2@\7\3\2\2\2AB\7\4" +
                    "\2\2BO\b\5\1\2CD\5\4\3\2DE\b\5\1\2EO\3\2\2\2FG\5\6\4\2GH\b\5\1\2HO\3\2" +
                    "\2\2IJ\7\7\2\2JK\5\22\n\2KL\7\b\2\2LM\b\5\1\2MO\3\2\2\2NA\3\2\2\2NC\3" +
                    "\2\2\2NF\3\2\2\2NI\3\2\2\2O\t\3\2\2\2PQ\7\t\2\2QR\5\n\6\2RS\b\6\1\2SX" +
                    "\3\2\2\2TU\5\b\5\2UV\b\6\1\2VX\3\2\2\2WP\3\2\2\2WT\3\2\2\2X\13\3\2\2\2" +
                    "YZ\5\n\6\2Za\b\7\1\2[\\\7\n\2\2\\]\5\n\6\2]^\b\7\1\2^`\3\2\2\2_[\3\2\2" +
                    "\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2bd\3\2\2\2ca\3\2\2\2de\b\7\1\2e\r\3\2" +
                    "\2\2fg\5\f\7\2gn\b\b\1\2hi\7\13\2\2ij\5\f\7\2jk\b\b\1\2km\3\2\2\2lh\3" +
                    "\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2oq\3\2\2\2pn\3\2\2\2qr\b\b\1\2r\17" +
                    "\3\2\2\2st\5\16\b\2ty\b\t\1\2uv\7\f\2\2vw\5\20\t\2wx\b\t\1\2xz\3\2\2\2" +
                    "yu\3\2\2\2yz\3\2\2\2z{\3\2\2\2{|\b\t\1\2|\21\3\2\2\2}~\5\20\t\2~\u0083" +
                    "\b\n\1\2\177\u0080\7\r\2\2\u0080\u0081\5\22\n\2\u0081\u0082\b\n\1\2\u0082" +
                    "\u0084\3\2\2\2\u0083\177\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3\2\2" +
                    "\2\u0085\u0086\b\n\1\2\u0086\23\3\2\2\2\u0087\u0088\7\4\2\2\u0088\u008e" +
                    "\b\13\1\2\u0089\u008a\7\3\2\2\u008a\u008b\7\16\2\2\u008b\u008c\7\4\2\2" +
                    "\u008c\u008e\b\13\1\2\u008d\u0087\3\2\2\2\u008d\u0089\3\2\2\2\u008e\25" +
                    "\3\2\2\2\u008f\u0090\5\24\13\2\u0090\u0097\b\f\1\2\u0091\u0092\7\17\2" +
                    "\2\u0092\u0093\5\24\13\2\u0093\u0094\b\f\1\2\u0094\u0096\3\2\2\2\u0095" +
                    "\u0091\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2" +
                    "\2\2\u0098\27\3\2\2\2\u0099\u0097\3\2\2\2\r\36$?NWany\u0083\u008d\u0097";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = {
            null, null, null, "'$true'", "'$false'", "'('", "')'", "'~'", "'&'", "'|'",
            "'=>'", "'<=>'", "'*'", null, "'='", "'<='", "'<'", "'>='", "'>'"
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, "NUMBER", "LITERAL", "TRUE", "FALSE", "LBR", "RBR", "NOT", "AND",
            "OR", "IMPL", "EQUIV", "MUL", "ADD", "EQ", "LE", "LT", "GE", "GT", "WS"
    };
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    static {
        RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION);
    }

    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "";
            }
        }
    }

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    private FormulaFactory f;

    public LogicNGPseudoBooleanParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getGrammarFileName() {
        return "LogicNGPseudoBoolean.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public void setFormulaFactory(final FormulaFactory f) {
        this.f = f;
    }

    public final FormulaContext formula() throws RecognitionException {
        FormulaContext _localctx = new FormulaContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_formula);
        try {
            setState(28);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case EOF:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(22);
                    match(EOF);
                    _localctx.f = f.verum();
                }
                break;
                case NUMBER:
                case LITERAL:
                case TRUE:
                case FALSE:
                case LBR:
                case NOT:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(24);
                    _localctx.equiv = equiv();
                    setState(25);
                    match(EOF);
                    _localctx.f = _localctx.equiv.f;
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ConstantContext constant() throws RecognitionException {
        ConstantContext _localctx = new ConstantContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_constant);
        try {
            setState(34);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case TRUE:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(30);
                    match(TRUE);
                    _localctx.f = f.verum();
                }
                break;
                case FALSE:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(32);
                    match(FALSE);
                    _localctx.f = f.falsum();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ComparisonContext comparison() throws RecognitionException {
        ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_comparison);
        try {
            setState(61);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 2, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(36);
                    _localctx.e = add();
                    setState(37);
                    match(EQ);
                    setState(38);
                    _localctx.n = match(NUMBER);
                    _localctx.f = f.pbc(CType.EQ, Integer.parseInt((_localctx.n != null ? _localctx.n.getText() : null)), _localctx.e.literals, _localctx.e.coeffs);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(41);
                    _localctx.e = add();
                    setState(42);
                    match(LE);
                    setState(43);
                    _localctx.n = match(NUMBER);
                    _localctx.f = f.pbc(CType.LE, Integer.parseInt((_localctx.n != null ? _localctx.n.getText() : null)), _localctx.e.literals, _localctx.e.coeffs);
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(46);
                    _localctx.e = add();
                    setState(47);
                    match(LT);
                    setState(48);
                    _localctx.n = match(NUMBER);
                    _localctx.f = f.pbc(CType.LT, Integer.parseInt((_localctx.n != null ? _localctx.n.getText() : null)), _localctx.e.literals, _localctx.e.coeffs);
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(51);
                    _localctx.e = add();
                    setState(52);
                    match(GE);
                    setState(53);
                    _localctx.n = match(NUMBER);
                    _localctx.f = f.pbc(CType.GE, Integer.parseInt((_localctx.n != null ? _localctx.n.getText() : null)), _localctx.e.literals, _localctx.e.coeffs);
                }
                break;
                case 5:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(56);
                    _localctx.e = add();
                    setState(57);
                    match(GT);
                    setState(58);
                    _localctx.n = match(NUMBER);
                    _localctx.f = f.pbc(CType.GT, Integer.parseInt((_localctx.n != null ? _localctx.n.getText() : null)), _localctx.e.literals, _localctx.e.coeffs);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final SimpContext simp() throws RecognitionException {
        SimpContext _localctx = new SimpContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_simp);
        try {
            setState(76);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 3, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(63);
                    _localctx.LITERAL = match(LITERAL);
                    _localctx.f = ((_localctx.LITERAL != null ? _localctx.LITERAL.getText() : null).startsWith("~") ? f.literal((_localctx.LITERAL != null ? _localctx.LITERAL.getText() : null).substring(1, (_localctx.LITERAL != null ? _localctx.LITERAL.getText() : null).length()), false) : f.literal((_localctx.LITERAL != null ? _localctx.LITERAL.getText() : null), true));
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(65);
                    _localctx.constant = constant();
                    _localctx.f = _localctx.constant.f;
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(68);
                    _localctx.comparison = comparison();
                    _localctx.f = _localctx.comparison.f;
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(71);
                    match(LBR);
                    setState(72);
                    _localctx.equiv = equiv();
                    setState(73);
                    match(RBR);
                    _localctx.f = _localctx.equiv.f;
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final LitContext lit() throws RecognitionException {
        LitContext _localctx = new LitContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_lit);
        try {
            setState(85);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case NOT:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(78);
                    match(NOT);
                    setState(79);
                    _localctx.a = lit();
                    _localctx.f = f.not(_localctx.a.f);
                }
                break;
                case NUMBER:
                case LITERAL:
                case TRUE:
                case FALSE:
                case LBR:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(82);
                    _localctx.simp = simp();
                    _localctx.f = _localctx.simp.f;
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ConjContext conj() throws RecognitionException {
        ConjContext _localctx = new ConjContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_conj);
        LinkedHashSet literals = new LinkedHashSet<>();
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(87);
                _localctx.a = lit();
                literals.add(_localctx.a.f);
                setState(95);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == AND) {
                    {
                        {
                            setState(89);
                            match(AND);
                            setState(90);
                            _localctx.b = lit();
                            literals.add(_localctx.b.f);
                        }
                    }
                    setState(97);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                _localctx.f = f.and(literals);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final DisjContext disj() throws RecognitionException {
        DisjContext _localctx = new DisjContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_disj);
        LinkedHashSet conjunctions = new LinkedHashSet<>();
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(100);
                _localctx.a = conj();
                conjunctions.add(_localctx.a.f);
                setState(108);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OR) {
                    {
                        {
                            setState(102);
                            match(OR);
                            setState(103);
                            _localctx.b = conj();
                            conjunctions.add(_localctx.b.f);
                        }
                    }
                    setState(110);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                _localctx.f = f.or(conjunctions);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ImplContext impl() throws RecognitionException {
        ImplContext _localctx = new ImplContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_impl);
        Formula[] operands = new Formula[2];
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(113);
                _localctx.a = disj();
                operands[0] = _localctx.a.f;
                setState(119);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == IMPL) {
                    {
                        setState(115);
                        match(IMPL);
                        setState(116);
                        _localctx.b = impl();
                        operands[1] = _localctx.b.f;
                    }
                }

                _localctx.f = operands[1] == null ? operands[0] : f.implication(operands[0], operands[1]);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final EquivContext equiv() throws RecognitionException {
        EquivContext _localctx = new EquivContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_equiv);
        Formula[] operands = new Formula[2];
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(123);
                _localctx.a = impl();
                operands[0] = _localctx.a.f;
                setState(129);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == EQUIV) {
                    {
                        setState(125);
                        match(EQUIV);
                        setState(126);
                        _localctx.b = equiv();
                        operands[1] = _localctx.b.f;
                    }
                }

                _localctx.f = operands[1] == null ? operands[0] : f.equivalence(operands[0], operands[1]);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final MulContext mul() throws RecognitionException {
        MulContext _localctx = new MulContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_mul);
        try {
            setState(139);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case LITERAL:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(133);
                    _localctx.LITERAL = match(LITERAL);
                    _localctx.l = ((_localctx.LITERAL != null ? _localctx.LITERAL.getText() : null).startsWith("~") ? f.literal((_localctx.LITERAL != null ? _localctx.LITERAL.getText() : null).substring(1, (_localctx.LITERAL != null ? _localctx.LITERAL.getText() : null).length()), false) : f.literal((_localctx.LITERAL != null ? _localctx.LITERAL.getText() : null), true));
                    _localctx.c = 1;
                }
                break;
                case NUMBER:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(135);
                    _localctx.NUMBER = match(NUMBER);
                    setState(136);
                    match(MUL);
                    setState(137);
                    _localctx.LITERAL = match(LITERAL);
                    _localctx.l = ((_localctx.LITERAL != null ? _localctx.LITERAL.getText() : null).startsWith("~") ? f.literal((_localctx.LITERAL != null ? _localctx.LITERAL.getText() : null).substring(1, (_localctx.LITERAL != null ? _localctx.LITERAL.getText() : null).length()), false) : f.literal((_localctx.LITERAL != null ? _localctx.LITERAL.getText() : null), true));
                    _localctx.c = Integer.parseInt((_localctx.NUMBER != null ? _localctx.NUMBER.getText() : null));
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final AddContext add() throws RecognitionException {
        AddContext _localctx = new AddContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_add);
        _localctx.literals = new ArrayList<>();
        _localctx.coeffs = new ArrayList<>();
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(141);
                _localctx.m1 = mul();
                _localctx.literals.add(_localctx.m1.l);
                _localctx.coeffs.add(_localctx.m1.c);
                setState(149);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == ADD) {
                    {
                        {
                            setState(143);
                            _localctx.ADD = match(ADD);
                            setState(144);
                            _localctx.m2 = mul();
                            _localctx.literals.add(_localctx.m2.l);
                            _localctx.coeffs.add((_localctx.ADD != null ? _localctx.ADD.getText() : null).equals("+") ? _localctx.m2.c : -_localctx.m2.c);
                        }
                    }
                    setState(151);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FormulaContext extends ParserRuleContext {
        public Formula f;
        public EquivContext equiv;

        public FormulaContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode EOF() {
            return getToken(LogicNGPseudoBooleanParser.EOF, 0);
        }

        public EquivContext equiv() {
            return getRuleContext(EquivContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_formula;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPseudoBooleanListener)
                ((LogicNGPseudoBooleanListener) listener).enterFormula(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPseudoBooleanListener)
                ((LogicNGPseudoBooleanListener) listener).exitFormula(this);
        }
    }

    public static class ConstantContext extends ParserRuleContext {
        public Formula f;

        public ConstantContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode TRUE() {
            return getToken(LogicNGPseudoBooleanParser.TRUE, 0);
        }

        public TerminalNode FALSE() {
            return getToken(LogicNGPseudoBooleanParser.FALSE, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_constant;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPseudoBooleanListener)
                ((LogicNGPseudoBooleanListener) listener).enterConstant(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPseudoBooleanListener)
                ((LogicNGPseudoBooleanListener) listener).exitConstant(this);
        }
    }

    public static class ComparisonContext extends ParserRuleContext {
        public Formula f;
        public AddContext e;
        public Token n;

        public ComparisonContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode EQ() {
            return getToken(LogicNGPseudoBooleanParser.EQ, 0);
        }

        public AddContext add() {
            return getRuleContext(AddContext.class, 0);
        }

        public TerminalNode NUMBER() {
            return getToken(LogicNGPseudoBooleanParser.NUMBER, 0);
        }

        public TerminalNode LE() {
            return getToken(LogicNGPseudoBooleanParser.LE, 0);
        }

        public TerminalNode LT() {
            return getToken(LogicNGPseudoBooleanParser.LT, 0);
        }

        public TerminalNode GE() {
            return getToken(LogicNGPseudoBooleanParser.GE, 0);
        }

        public TerminalNode GT() {
            return getToken(LogicNGPseudoBooleanParser.GT, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_comparison;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPseudoBooleanListener)
                ((LogicNGPseudoBooleanListener) listener).enterComparison(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPseudoBooleanListener)
                ((LogicNGPseudoBooleanListener) listener).exitComparison(this);
        }
    }

    public static class SimpContext extends ParserRuleContext {
        public Formula f;
        public Token LITERAL;
        public ConstantContext constant;
        public ComparisonContext comparison;
        public EquivContext equiv;

        public SimpContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode LITERAL() {
            return getToken(LogicNGPseudoBooleanParser.LITERAL, 0);
        }

        public ConstantContext constant() {
            return getRuleContext(ConstantContext.class, 0);
        }

        public ComparisonContext comparison() {
            return getRuleContext(ComparisonContext.class, 0);
        }

        public TerminalNode LBR() {
            return getToken(LogicNGPseudoBooleanParser.LBR, 0);
        }

        public EquivContext equiv() {
            return getRuleContext(EquivContext.class, 0);
        }

        public TerminalNode RBR() {
            return getToken(LogicNGPseudoBooleanParser.RBR, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_simp;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPseudoBooleanListener)
                ((LogicNGPseudoBooleanListener) listener).enterSimp(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPseudoBooleanListener)
                ((LogicNGPseudoBooleanListener) listener).exitSimp(this);
        }
    }

    public static class LitContext extends ParserRuleContext {
        public Formula f;
        public LitContext a;
        public SimpContext simp;

        public LitContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode NOT() {
            return getToken(LogicNGPseudoBooleanParser.NOT, 0);
        }

        public LitContext lit() {
            return getRuleContext(LitContext.class, 0);
        }

        public SimpContext simp() {
            return getRuleContext(SimpContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_lit;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPseudoBooleanListener)
                ((LogicNGPseudoBooleanListener) listener).enterLit(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPseudoBooleanListener)
                ((LogicNGPseudoBooleanListener) listener).exitLit(this);
        }
    }

    public static class ConjContext extends ParserRuleContext {
        public Formula f;
        public LitContext a;
        public LitContext b;

        public ConjContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List lit() {
            return getRuleContexts(LitContext.class);
        }

        public LitContext lit(int i) {
            return getRuleContext(LitContext.class, i);
        }

        public List AND() {
            return getTokens(LogicNGPseudoBooleanParser.AND);
        }

        public TerminalNode AND(int i) {
            return getToken(LogicNGPseudoBooleanParser.AND, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_conj;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPseudoBooleanListener)
                ((LogicNGPseudoBooleanListener) listener).enterConj(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPseudoBooleanListener)
                ((LogicNGPseudoBooleanListener) listener).exitConj(this);
        }
    }

    public static class DisjContext extends ParserRuleContext {
        public Formula f;
        public ConjContext a;
        public ConjContext b;

        public DisjContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List conj() {
            return getRuleContexts(ConjContext.class);
        }

        public ConjContext conj(int i) {
            return getRuleContext(ConjContext.class, i);
        }

        public List OR() {
            return getTokens(LogicNGPseudoBooleanParser.OR);
        }

        public TerminalNode OR(int i) {
            return getToken(LogicNGPseudoBooleanParser.OR, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_disj;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPseudoBooleanListener)
                ((LogicNGPseudoBooleanListener) listener).enterDisj(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPseudoBooleanListener)
                ((LogicNGPseudoBooleanListener) listener).exitDisj(this);
        }
    }

    public static class ImplContext extends ParserRuleContext {
        public Formula f;
        public DisjContext a;
        public ImplContext b;

        public ImplContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public DisjContext disj() {
            return getRuleContext(DisjContext.class, 0);
        }

        public TerminalNode IMPL() {
            return getToken(LogicNGPseudoBooleanParser.IMPL, 0);
        }

        public ImplContext impl() {
            return getRuleContext(ImplContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_impl;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPseudoBooleanListener)
                ((LogicNGPseudoBooleanListener) listener).enterImpl(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPseudoBooleanListener)
                ((LogicNGPseudoBooleanListener) listener).exitImpl(this);
        }
    }

    public static class EquivContext extends ParserRuleContext {
        public Formula f;
        public ImplContext a;
        public EquivContext b;

        public EquivContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ImplContext impl() {
            return getRuleContext(ImplContext.class, 0);
        }

        public TerminalNode EQUIV() {
            return getToken(LogicNGPseudoBooleanParser.EQUIV, 0);
        }

        public EquivContext equiv() {
            return getRuleContext(EquivContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_equiv;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPseudoBooleanListener)
                ((LogicNGPseudoBooleanListener) listener).enterEquiv(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPseudoBooleanListener)
                ((LogicNGPseudoBooleanListener) listener).exitEquiv(this);
        }
    }

    public static class MulContext extends ParserRuleContext {
        public Literal l;
        public int c;
        public Token LITERAL;
        public Token NUMBER;

        public MulContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode LITERAL() {
            return getToken(LogicNGPseudoBooleanParser.LITERAL, 0);
        }

        public TerminalNode NUMBER() {
            return getToken(LogicNGPseudoBooleanParser.NUMBER, 0);
        }

        public TerminalNode MUL() {
            return getToken(LogicNGPseudoBooleanParser.MUL, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_mul;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPseudoBooleanListener)
                ((LogicNGPseudoBooleanListener) listener).enterMul(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPseudoBooleanListener)
                ((LogicNGPseudoBooleanListener) listener).exitMul(this);
        }
    }

    public static class AddContext extends ParserRuleContext {
        public List literals;
        public List coeffs;
        public MulContext m1;
        public Token ADD;
        public MulContext m2;

        public AddContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List mul() {
            return getRuleContexts(MulContext.class);
        }

        public MulContext mul(int i) {
            return getRuleContext(MulContext.class, i);
        }

        public List ADD() {
            return getTokens(LogicNGPseudoBooleanParser.ADD);
        }

        public TerminalNode ADD(int i) {
            return getToken(LogicNGPseudoBooleanParser.ADD, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_add;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPseudoBooleanListener)
                ((LogicNGPseudoBooleanListener) listener).enterAdd(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LogicNGPseudoBooleanListener)
                ((LogicNGPseudoBooleanListener) listener).exitAdd(this);
        }
    }
}